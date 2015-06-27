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

public class CFBamTZTimestampColTableObj
	implements ICFBamTZTimestampColTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamValuePKey, ICFBamTZTimestampColObj> members;
	private Map<CFBamValuePKey, ICFBamTZTimestampColObj> allTZTimestampCol;
	private Map< CFBamValueByUNameIdxKey,
		ICFBamTZTimestampColObj > indexByUNameIdx;
	private Map< CFBamValueByValTentIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByValTentIdx;
	private Map< CFBamValueByScopeIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByScopeIdx;
	private Map< CFBamValueByDefSchemaIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByDefSchemaIdx;
	private Map< CFBamValueByDataScopeIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByDataScopeIdx;
	private Map< CFBamValueByVAccSecIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByVAccSecIdx;
	private Map< CFBamValueByVAccFreqIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByVAccFreqIdx;
	private Map< CFBamValueByEAccSecIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByEAccSecIdx;
	private Map< CFBamValueByEAccFreqIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByEAccFreqIdx;
	private Map< CFBamValueByPrevIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByPrevIdx;
	private Map< CFBamValueByNextIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByNextIdx;
	private Map< CFBamValueByContPrevIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByContPrevIdx;
	private Map< CFBamValueByContNextIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByContNextIdx;
	private Map< CFBamTZTimestampColByTableIdxKey,
		Map<CFBamValuePKey, ICFBamTZTimestampColObj > > indexByTableIdx;
	public static String TABLE_NAME = "TZTimestampCol";
	public static String TABLE_DBNAME = "zscol";

	public CFBamTZTimestampColTableObj() {
		schema = null;
		members = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
		allTZTimestampCol = null;
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
		indexByTableIdx = null;
	}

	public CFBamTZTimestampColTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
		allTZTimestampCol = null;
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
		indexByTableIdx = null;
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
		allTZTimestampCol = null;
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
		indexByTableIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTZTimestampColObj.
	 */
	public ICFBamTZTimestampColObj newInstance() {
		ICFBamTZTimestampColObj inst = new CFBamTZTimestampColObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTZTimestampColObj.
	 */
	public ICFBamTZTimestampColEditObj newEditInstance( ICFBamTZTimestampColObj orig ) {
		ICFBamTZTimestampColEditObj edit = new CFBamTZTimestampColEditObj( orig );
		return( edit );
	}

	public ICFBamTZTimestampColObj realizeTZTimestampCol( ICFBamTZTimestampColObj Obj ) {
		ICFBamTZTimestampColObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		ICFBamTZTimestampColObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTZTimestampColObj existingObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					indexByDataScopeIdx.remove( keyDataScopeIdx );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					indexByVAccSecIdx.remove( keyVAccSecIdx );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					indexByVAccFreqIdx.remove( keyVAccFreqIdx );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					indexByEAccSecIdx.remove( keyEAccSecIdx );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					indexByEAccFreqIdx.remove( keyEAccFreqIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamTZTimestampColByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryTZTimestampCol().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamTZTimestampColObj)schema.getTZTimestampDefTableObj().realizeTZTimestampDef( Obj );

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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamTZTimestampColByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryTZTimestampCol().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allTZTimestampCol != null ) {
				allTZTimestampCol.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamTZTimestampColObj)schema.getTZTimestampDefTableObj().realizeTZTimestampDef( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTZTimestampCol != null ) {
				allTZTimestampCol.put( keepObj.getPKey(), keepObj );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamTZTimestampColByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryTZTimestampCol().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetTZTimestampCol( ICFBamTZTimestampColObj Obj ) {
		forgetTZTimestampCol( Obj, false );
	}

	public void forgetTZTimestampCol( ICFBamTZTimestampColObj Obj, boolean forgetSubObjects ) {
		ICFBamTZTimestampColObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTZTimestampColObj keepObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					indexByDataScopeIdx.remove( keyDataScopeIdx );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					indexByVAccSecIdx.remove( keyVAccSecIdx );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					indexByVAccFreqIdx.remove( keyVAccFreqIdx );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					indexByEAccSecIdx.remove( keyEAccSecIdx );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					indexByEAccFreqIdx.remove( keyEAccFreqIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamTZTimestampColByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryTZTimestampCol().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( allTZTimestampCol != null ) {
				allTZTimestampCol.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getTZTimestampDefTableObj().forgetTZTimestampDef( obj );
	}

	public void forgetTZTimestampColByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamValuePKey key = schema.getBackingStore().getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamTZTimestampColObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTZTimestampColByUNameIdx( long TenantId,
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
			ICFBamTZTimestampColObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetTZTimestampColByValTentIdx( long TenantId )
	{
		if( indexByValTentIdx == null ) {
			return;
		}
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapValTentIdx = indexByValTentIdx.get( key );
			if( mapValTentIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapValTentIdx.values().iterator();
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

	public void forgetTZTimestampColByScopeIdx( long TenantId,
		long ScopeId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapScopeIdx.values().iterator();
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

	public void forgetTZTimestampColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetTZTimestampColByDataScopeIdx( Short DataScopeId )
	{
		if( indexByDataScopeIdx == null ) {
			return;
		}
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapDataScopeIdx = indexByDataScopeIdx.get( key );
			if( mapDataScopeIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapDataScopeIdx.values().iterator();
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

	public void forgetTZTimestampColByVAccSecIdx( Short ViewAccessSecurityId )
	{
		if( indexByVAccSecIdx == null ) {
			return;
		}
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapVAccSecIdx = indexByVAccSecIdx.get( key );
			if( mapVAccSecIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapVAccSecIdx.values().iterator();
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

	public void forgetTZTimestampColByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		if( indexByVAccFreqIdx == null ) {
			return;
		}
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( key );
			if( mapVAccFreqIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapVAccFreqIdx.values().iterator();
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

	public void forgetTZTimestampColByEAccSecIdx( Short EditAccessSecurityId )
	{
		if( indexByEAccSecIdx == null ) {
			return;
		}
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapEAccSecIdx = indexByEAccSecIdx.get( key );
			if( mapEAccSecIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapEAccSecIdx.values().iterator();
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

	public void forgetTZTimestampColByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		if( indexByEAccFreqIdx == null ) {
			return;
		}
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( key );
			if( mapEAccFreqIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapEAccFreqIdx.values().iterator();
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

	public void forgetTZTimestampColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapPrevIdx.values().iterator();
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

	public void forgetTZTimestampColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapNextIdx.values().iterator();
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

	public void forgetTZTimestampColByContPrevIdx( long TenantId,
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
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapContPrevIdx = indexByContPrevIdx.get( key );
			if( mapContPrevIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapContPrevIdx.values().iterator();
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

	public void forgetTZTimestampColByContNextIdx( long TenantId,
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
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapContNextIdx = indexByContNextIdx.get( key );
			if( mapContNextIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapContNextIdx.values().iterator();
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

	public void forgetTZTimestampColByTableIdx( long TenantId,
		long TableId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamTZTimestampColByTableIdxKey key = schema.getBackingStore().getFactoryTZTimestampCol().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
				ICFBamTZTimestampColObj cur = null;
				Iterator<ICFBamTZTimestampColObj> iter = mapTableIdx.values().iterator();
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

	public ICFBamTZTimestampColObj createTZTimestampCol( ICFBamTZTimestampColObj Obj ) {
		ICFBamTZTimestampColObj obj = Obj;
		CFBamTZTimestampColBuff buff = obj.getTZTimestampColBuff();
		schema.getBackingStore().getTableTZTimestampCol().createTZTimestampCol(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "ZSTC" ) ) {
			obj = (ICFBamTZTimestampColObj)(obj.realize());
		}
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		return( obj );
	}

	public ICFBamTZTimestampColObj readTZTimestampCol( CFBamValuePKey pkey ) {
		return( readTZTimestampCol( pkey, false ) );
	}

	public ICFBamTZTimestampColObj readTZTimestampCol( CFBamValuePKey pkey, boolean forceRead ) {
		ICFBamTZTimestampColObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTZTimestampColBuff readBuff = schema.getBackingStore().getTableTZTimestampCol().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTZTimestampColObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTZTimestampColObj lockTZTimestampCol( CFBamValuePKey pkey ) {
		ICFBamTZTimestampColObj locked = null;
		CFBamTZTimestampColBuff lockBuff = schema.getBackingStore().getTableTZTimestampCol().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTZTimestampColObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTZTimestampCol", pkey );
		}
		return( locked );
	}

	public List<ICFBamTZTimestampColObj> readAllTZTimestampCol() {
		return( readAllTZTimestampCol( false ) );
	}

	public List<ICFBamTZTimestampColObj> readAllTZTimestampCol( boolean forceRead ) {
		final String S_ProcName = "readAllTZTimestampCol";
		if( ( allTZTimestampCol == null ) || forceRead ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> map = new HashMap<CFBamValuePKey,ICFBamTZTimestampColObj>();
			allTZTimestampCol = map;
			CFBamTZTimestampColBuff[] buffList = schema.getBackingStore().getTableTZTimestampCol().readAllDerived( schema.getAuthorization() );
			CFBamTZTimestampColBuff buff;
			ICFBamTZTimestampColObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		int len = allTZTimestampCol.size();
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = allTZTimestampCol.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTZTimestampColObj readTZTimestampColByIdIdx( long TenantId,
		long Id )
	{
		return( readTZTimestampColByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamTZTimestampColObj readTZTimestampColByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamValuePKey pkey = schema.getBackingStore().getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTZTimestampColObj obj = readTZTimestampCol( pkey, forceRead );
		return( obj );
	}

	public ICFBamTZTimestampColObj readTZTimestampColByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		return( readTZTimestampColByUNameIdx( TenantId,
			ScopeId,
			Name,
			false ) );
	}

	public ICFBamTZTimestampColObj readTZTimestampColByUNameIdx( long TenantId,
		long ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamTZTimestampColObj >();
		}
		CFBamValueByUNameIdxKey key = schema.getBackingStore().getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamTZTimestampColObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamValueBuff buff = schema.getBackingStore().getTableValue().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			if( buff != null ) {
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTZTimestampColObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByValTentIdx( long TenantId )
	{
		return( readTZTimestampColByValTentIdx( TenantId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByValTentIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByValTentIdx";
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByValTentIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByValTentIdx( schema.getAuthorization(),
				TenantId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByScopeIdx( long TenantId,
		long ScopeId )
	{
		return( readTZTimestampColByScopeIdx( TenantId,
			ScopeId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByScopeIdx";
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByScopeIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readTZTimestampColByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByDefSchemaIdx";
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByDataScopeIdx( Short DataScopeId )
	{
		return( readTZTimestampColByDataScopeIdx( DataScopeId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByDataScopeIdx( Short DataScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByDataScopeIdx";
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamValueByDataScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByDataScopeIdx.containsKey( key ) ) {
			dict = indexByDataScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDataScopeIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByVAccSecIdx( Short ViewAccessSecurityId )
	{
		return( readTZTimestampColByVAccSecIdx( ViewAccessSecurityId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByVAccSecIdx";
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamValueByVAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByVAccSecIdx.containsKey( key ) ) {
			dict = indexByVAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccSecIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		return( readTZTimestampColByVAccFreqIdx( ViewAccessFrequencyId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByVAccFreqIdx";
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamValueByVAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByVAccFreqIdx.containsKey( key ) ) {
			dict = indexByVAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccFreqIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByEAccSecIdx( Short EditAccessSecurityId )
	{
		return( readTZTimestampColByEAccSecIdx( EditAccessSecurityId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByEAccSecIdx";
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamValueByEAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByEAccSecIdx.containsKey( key ) ) {
			dict = indexByEAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccSecIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		return( readTZTimestampColByEAccFreqIdx( EditAccessFrequencyId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByEAccFreqIdx";
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamValueByEAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByEAccFreqIdx.containsKey( key ) ) {
			dict = indexByEAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccFreqIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readTZTimestampColByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByPrevIdx";
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByPrevIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readTZTimestampColByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByNextIdx";
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByNextIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		return( readTZTimestampColByContPrevIdx( TenantId,
			ScopeId,
			PrevId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByContPrevIdx";
		CFBamValueByContPrevIdxKey key = schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
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
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		return( readTZTimestampColByContNextIdx( TenantId,
			ScopeId,
			NextId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByContNextIdx";
		CFBamValueByContNextIdxKey key = schema.getBackingStore().getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
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
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByTableIdx( long TenantId,
		long TableId )
	{
		return( readTZTimestampColByTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamTZTimestampColObj> readTZTimestampColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZTimestampColByTableIdx";
		CFBamTZTimestampColByTableIdxKey key = schema.getBackingStore().getFactoryTZTimestampCol().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamTZTimestampColByTableIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZTimestampColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamTZTimestampColObj obj;
			CFBamTZTimestampColBuff[] buffList = schema.getBackingStore().getTableTZTimestampCol().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamTZTimestampColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZTimestampColObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZTimestampColObj realized = (ICFBamTZTimestampColObj)obj.realize();
			}
		}
		Comparator<ICFBamTZTimestampColObj> cmp = new Comparator<ICFBamTZTimestampColObj>() {
			public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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
		ICFBamTZTimestampColObj arr[] = new ICFBamTZTimestampColObj[len];
		Iterator<ICFBamTZTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZTimestampColObj> arrayList = new ArrayList<ICFBamTZTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTZTimestampColObj updateTZTimestampCol( ICFBamTZTimestampColObj Obj ) {
		ICFBamTZTimestampColObj obj = Obj;
		schema.getBackingStore().getTableTZTimestampCol().updateTZTimestampCol( schema.getAuthorization(),
			Obj.getTZTimestampColBuff() );
		if( Obj.getClassCode().equals( "ZSTC" ) ) {
			obj = (ICFBamTZTimestampColObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteTZTimestampCol( ICFBamTZTimestampColObj Obj ) {
		ICFBamTZTimestampColObj obj = Obj;
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		ICFBamValueObj next = obj.getOptionalLookupNext();
		schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampCol( schema.getAuthorization(),
			obj.getTZTimestampColBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteTZTimestampColByIdIdx( long TenantId,
		long Id )
	{
		CFBamValuePKey pkey = schema.getBackingStore().getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamValueObj obj = readTZTimestampCol( pkey );
		if( obj != null ) {
			ICFBamTZTimestampColEditObj editObj = (ICFBamTZTimestampColEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTZTimestampColEditObj)obj.beginEdit();
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

	public void deleteTZTimestampColByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamTZTimestampColObj >();
		}
		CFBamValueByUNameIdxKey key = schema.getBackingStore().getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamTZTimestampColObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
		}
	}

	public void deleteTZTimestampColByValTentIdx( long TenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByValTentIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByValTentIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByValTentIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTZTimestampColByScopeIdx( long TenantId,
		long ScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByScopeIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
		}
	}

	public void deleteTZTimestampColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteTZTimestampColByDataScopeIdx( Short DataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamValueByDataScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByDataScopeIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
		}
	}

	public void deleteTZTimestampColByVAccSecIdx( Short ViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamValueByVAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByVAccSecIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
		}
	}

	public void deleteTZTimestampColByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamValueByVAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByVAccFreqIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
		}
	}

	public void deleteTZTimestampColByEAccSecIdx( Short EditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamValueByEAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByEAccSecIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
		}
	}

	public void deleteTZTimestampColByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamValueByEAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByEAccFreqIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
		}
	}

	public void deleteTZTimestampColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByPrevIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteTZTimestampColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByNextIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteTZTimestampColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByContPrevIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
		}
	}

	public void deleteTZTimestampColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		CFBamValueByContNextIdxKey key = schema.getBackingStore().getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByContNextIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
		}
	}

	public void deleteTZTimestampColByTableIdx( long TenantId,
		long TableId )
	{
		CFBamTZTimestampColByTableIdxKey key = schema.getBackingStore().getFactoryTZTimestampCol().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamTZTimestampColByTableIdxKey,
				Map< CFBamValuePKey, ICFBamTZTimestampColObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZTimestampColObj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamTZTimestampColObj> iter = dict.values().iterator();
			ICFBamTZTimestampColObj obj;
			List<ICFBamTZTimestampColObj> toForget = new LinkedList<ICFBamTZTimestampColObj>();
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
			schema.getBackingStore().getTableTZTimestampCol().deleteTZTimestampColByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	/**
	 *	Move the CFBamTZTimestampColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimestampColObj refreshed cache instance.
	 */
	public ICFBamTZTimestampColObj moveUpTZTimestampCol( ICFBamTZTimestampColObj Obj ) {
		ICFBamTZTimestampColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveUpTZTimestampCol",
				"You cannot move an object that is being edited" );
		}
		CFBamTZTimestampColBuff buff = schema.getBackingStore().getTableTZTimestampCol().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getTZTimestampColTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamTZTimestampColObj)obj.realize();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamTZTimestampColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimestampColObj refreshed cache instance.
	 */
	public ICFBamTZTimestampColObj moveDownTZTimestampCol( ICFBamTZTimestampColObj Obj ) {
		ICFBamTZTimestampColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveDownTZTimestampCol",
				"You cannot move an object that is being edited" );
		}
		CFBamTZTimestampColBuff buff = schema.getBackingStore().getTableTZTimestampCol().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getTZTimestampColTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamTZTimestampColObj)obj.realize();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
