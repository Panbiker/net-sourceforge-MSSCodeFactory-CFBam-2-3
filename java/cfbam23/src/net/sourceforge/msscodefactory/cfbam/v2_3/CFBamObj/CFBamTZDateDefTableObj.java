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

public class CFBamTZDateDefTableObj
	implements ICFBamTZDateDefTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamValuePKey, ICFBamTZDateDefObj> members;
	private Map<CFBamValuePKey, ICFBamTZDateDefObj> allTZDateDef;
	private Map< CFBamValueByUNameIdxKey,
		ICFBamTZDateDefObj > indexByUNameIdx;
	private Map< CFBamValueByValTentIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByValTentIdx;
	private Map< CFBamValueByScopeIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByScopeIdx;
	private Map< CFBamValueByDefSchemaIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByDefSchemaIdx;
	private Map< CFBamValueByDataScopeIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByDataScopeIdx;
	private Map< CFBamValueByVAccSecIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByVAccSecIdx;
	private Map< CFBamValueByVAccFreqIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByVAccFreqIdx;
	private Map< CFBamValueByEAccSecIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByEAccSecIdx;
	private Map< CFBamValueByEAccFreqIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByEAccFreqIdx;
	private Map< CFBamValueByPrevIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByPrevIdx;
	private Map< CFBamValueByNextIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByNextIdx;
	private Map< CFBamValueByContPrevIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByContPrevIdx;
	private Map< CFBamValueByContNextIdxKey,
		Map<CFBamValuePKey, ICFBamTZDateDefObj > > indexByContNextIdx;
	public static String TABLE_NAME = "TZDateDef";
	public static String TABLE_DBNAME = "dzdef";

	public CFBamTZDateDefTableObj() {
		schema = null;
		members = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
		allTZDateDef = null;
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
	}

	public CFBamTZDateDefTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
		allTZDateDef = null;
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
		allTZDateDef = null;
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
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTZDateDefObj.
	 */
	public ICFBamTZDateDefObj newInstance() {
		ICFBamTZDateDefObj inst = new CFBamTZDateDefObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTZDateDefObj.
	 */
	public ICFBamTZDateDefEditObj newEditInstance( ICFBamTZDateDefObj orig ) {
		ICFBamTZDateDefEditObj edit = new CFBamTZDateDefEditObj( orig );
		return( edit );
	}

	public ICFBamTZDateDefObj realizeTZDateDef( ICFBamTZDateDefObj Obj ) {
		ICFBamTZDateDefObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		ICFBamTZDateDefObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTZDateDefObj existingObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					indexByDataScopeIdx.remove( keyDataScopeIdx );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					indexByVAccSecIdx.remove( keyVAccSecIdx );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					indexByVAccFreqIdx.remove( keyVAccFreqIdx );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					indexByEAccSecIdx.remove( keyEAccSecIdx );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					indexByEAccFreqIdx.remove( keyEAccFreqIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamTZDateDefObj)schema.getAtomTableObj().realizeAtom( Obj );

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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allTZDateDef != null ) {
				allTZDateDef.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamTZDateDefObj)schema.getAtomTableObj().realizeAtom( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTZDateDef != null ) {
				allTZDateDef.put( keepObj.getPKey(), keepObj );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetTZDateDef( ICFBamTZDateDefObj Obj ) {
		forgetTZDateDef( Obj, false );
	}

	public void forgetTZDateDef( ICFBamTZDateDefObj Obj, boolean forgetSubObjects ) {
		ICFBamTZDateDefObj obj = Obj;
		CFBamValuePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTZDateDefObj keepObj = members.get( pkey );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				CFBamValueByScopeIdxKey keyScopeIdx =
					schema.getBackingStore().getFactoryValue().newScopeIdxKey();
				keyScopeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamValueByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					indexByDataScopeIdx.remove( keyDataScopeIdx );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamValueByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					indexByVAccSecIdx.remove( keyVAccSecIdx );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamValueByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					indexByVAccFreqIdx.remove( keyVAccFreqIdx );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamValueByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					indexByEAccSecIdx.remove( keyEAccSecIdx );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamValueByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					indexByEAccFreqIdx.remove( keyEAccFreqIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamValueByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryValue().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamValueByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryValue().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
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
				Map<CFBamValuePKey, ICFBamTZDateDefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( allTZDateDef != null ) {
				allTZDateDef.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getAtomTableObj().forgetAtom( obj );
	}

	public void forgetTZDateDefByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamValuePKey key = schema.getBackingStore().getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamTZDateDefObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTZDateDefByUNameIdx( long TenantId,
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
			ICFBamTZDateDefObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetTZDateDefByValTentIdx( long TenantId )
	{
		if( indexByValTentIdx == null ) {
			return;
		}
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapValTentIdx = indexByValTentIdx.get( key );
			if( mapValTentIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapValTentIdx.values().iterator();
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

	public void forgetTZDateDefByScopeIdx( long TenantId,
		long ScopeId )
	{
		if( indexByScopeIdx == null ) {
			return;
		}
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapScopeIdx = indexByScopeIdx.get( key );
			if( mapScopeIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapScopeIdx.values().iterator();
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

	public void forgetTZDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetTZDateDefByDataScopeIdx( Short DataScopeId )
	{
		if( indexByDataScopeIdx == null ) {
			return;
		}
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapDataScopeIdx = indexByDataScopeIdx.get( key );
			if( mapDataScopeIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapDataScopeIdx.values().iterator();
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

	public void forgetTZDateDefByVAccSecIdx( Short ViewAccessSecurityId )
	{
		if( indexByVAccSecIdx == null ) {
			return;
		}
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapVAccSecIdx = indexByVAccSecIdx.get( key );
			if( mapVAccSecIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapVAccSecIdx.values().iterator();
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

	public void forgetTZDateDefByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		if( indexByVAccFreqIdx == null ) {
			return;
		}
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( key );
			if( mapVAccFreqIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapVAccFreqIdx.values().iterator();
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

	public void forgetTZDateDefByEAccSecIdx( Short EditAccessSecurityId )
	{
		if( indexByEAccSecIdx == null ) {
			return;
		}
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapEAccSecIdx = indexByEAccSecIdx.get( key );
			if( mapEAccSecIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapEAccSecIdx.values().iterator();
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

	public void forgetTZDateDefByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		if( indexByEAccFreqIdx == null ) {
			return;
		}
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( key );
			if( mapEAccFreqIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapEAccFreqIdx.values().iterator();
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

	public void forgetTZDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapPrevIdx.values().iterator();
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

	public void forgetTZDateDefByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapNextIdx.values().iterator();
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

	public void forgetTZDateDefByContPrevIdx( long TenantId,
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
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapContPrevIdx = indexByContPrevIdx.get( key );
			if( mapContPrevIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapContPrevIdx.values().iterator();
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

	public void forgetTZDateDefByContNextIdx( long TenantId,
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
			Map<CFBamValuePKey, ICFBamTZDateDefObj > mapContNextIdx = indexByContNextIdx.get( key );
			if( mapContNextIdx != null ) {
				List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
				ICFBamTZDateDefObj cur = null;
				Iterator<ICFBamTZDateDefObj> iter = mapContNextIdx.values().iterator();
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

	public ICFBamTZDateDefObj createTZDateDef( ICFBamTZDateDefObj Obj ) {
		ICFBamTZDateDefObj obj = Obj;
		CFBamTZDateDefBuff buff = obj.getTZDateDefBuff();
		schema.getBackingStore().getTableTZDateDef().createTZDateDef(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "DAZD" ) ) {
			obj = (ICFBamTZDateDefObj)(obj.realize());
		}
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		return( obj );
	}

	public ICFBamTZDateDefObj readTZDateDef( CFBamValuePKey pkey ) {
		return( readTZDateDef( pkey, false ) );
	}

	public ICFBamTZDateDefObj readTZDateDef( CFBamValuePKey pkey, boolean forceRead ) {
		ICFBamTZDateDefObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTZDateDefBuff readBuff = schema.getBackingStore().getTableTZDateDef().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTZDateDefObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTZDateDefObj lockTZDateDef( CFBamValuePKey pkey ) {
		ICFBamTZDateDefObj locked = null;
		CFBamTZDateDefBuff lockBuff = schema.getBackingStore().getTableTZDateDef().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTZDateDefObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTZDateDef", pkey );
		}
		return( locked );
	}

	public List<ICFBamTZDateDefObj> readAllTZDateDef() {
		return( readAllTZDateDef( false ) );
	}

	public List<ICFBamTZDateDefObj> readAllTZDateDef( boolean forceRead ) {
		final String S_ProcName = "readAllTZDateDef";
		if( ( allTZDateDef == null ) || forceRead ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> map = new HashMap<CFBamValuePKey,ICFBamTZDateDefObj>();
			allTZDateDef = map;
			CFBamTZDateDefBuff[] buffList = schema.getBackingStore().getTableTZDateDef().readAllDerived( schema.getAuthorization() );
			CFBamTZDateDefBuff buff;
			ICFBamTZDateDefObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		int len = allTZDateDef.size();
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = allTZDateDef.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTZDateDefObj readTZDateDefByIdIdx( long TenantId,
		long Id )
	{
		return( readTZDateDefByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamTZDateDefObj readTZDateDefByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamValuePKey pkey = schema.getBackingStore().getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTZDateDefObj obj = readTZDateDef( pkey, forceRead );
		return( obj );
	}

	public ICFBamTZDateDefObj readTZDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		return( readTZDateDefByUNameIdx( TenantId,
			ScopeId,
			Name,
			false ) );
	}

	public ICFBamTZDateDefObj readTZDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamTZDateDefObj >();
		}
		CFBamValueByUNameIdxKey key = schema.getBackingStore().getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamTZDateDefObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamValueBuff buff = schema.getBackingStore().getTableValue().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			if( buff != null ) {
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTZDateDefObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByValTentIdx( long TenantId )
	{
		return( readTZDateDefByValTentIdx( TenantId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByValTentIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByValTentIdx";
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByValTentIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByValTentIdx( schema.getAuthorization(),
				TenantId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByScopeIdx( long TenantId,
		long ScopeId )
	{
		return( readTZDateDefByScopeIdx( TenantId,
			ScopeId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByScopeIdx";
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByScopeIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readTZDateDefByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByDefSchemaIdx";
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByDataScopeIdx( Short DataScopeId )
	{
		return( readTZDateDefByDataScopeIdx( DataScopeId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByDataScopeIdx( Short DataScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByDataScopeIdx";
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamValueByDataScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByDataScopeIdx.containsKey( key ) ) {
			dict = indexByDataScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDataScopeIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByVAccSecIdx( Short ViewAccessSecurityId )
	{
		return( readTZDateDefByVAccSecIdx( ViewAccessSecurityId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByVAccSecIdx";
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamValueByVAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByVAccSecIdx.containsKey( key ) ) {
			dict = indexByVAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccSecIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		return( readTZDateDefByVAccFreqIdx( ViewAccessFrequencyId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByVAccFreqIdx";
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamValueByVAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByVAccFreqIdx.containsKey( key ) ) {
			dict = indexByVAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccFreqIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByEAccSecIdx( Short EditAccessSecurityId )
	{
		return( readTZDateDefByEAccSecIdx( EditAccessSecurityId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByEAccSecIdx";
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamValueByEAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByEAccSecIdx.containsKey( key ) ) {
			dict = indexByEAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccSecIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		return( readTZDateDefByEAccFreqIdx( EditAccessFrequencyId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByEAccFreqIdx";
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamValueByEAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByEAccFreqIdx.containsKey( key ) ) {
			dict = indexByEAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccFreqIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readTZDateDefByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByPrevIdx";
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByPrevIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readTZDateDefByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByNextIdx";
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByNextIdx.put( key, dict );
			ICFBamValueObj obj;
			CFBamValueBuff[] buffList = schema.getBackingStore().getTableValue().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamValueBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		return( readTZDateDefByContPrevIdx( TenantId,
			ScopeId,
			PrevId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByContPrevIdx";
		CFBamValueByContPrevIdxKey key = schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
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
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		return( readTZDateDefByContNextIdx( TenantId,
			ScopeId,
			NextId,
			false ) );
	}

	public List<ICFBamTZDateDefObj> readTZDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTZDateDefByContNextIdx";
		CFBamValueByContNextIdxKey key = schema.getBackingStore().getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<CFBamValuePKey, ICFBamTZDateDefObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamValuePKey, ICFBamTZDateDefObj>();
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
				obj = (ICFBamTZDateDefObj)schema.getValueTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
				obj.setBuff( buff );
				ICFBamTZDateDefObj realized = (ICFBamTZDateDefObj)obj.realize();
			}
		}
		Comparator<ICFBamTZDateDefObj> cmp = new Comparator<ICFBamTZDateDefObj>() {
			public int compare( ICFBamTZDateDefObj lhs, ICFBamTZDateDefObj rhs ) {
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
		ICFBamTZDateDefObj arr[] = new ICFBamTZDateDefObj[len];
		Iterator<ICFBamTZDateDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTZDateDefObj> arrayList = new ArrayList<ICFBamTZDateDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTZDateDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTZDateDefObj updateTZDateDef( ICFBamTZDateDefObj Obj ) {
		ICFBamTZDateDefObj obj = Obj;
		schema.getBackingStore().getTableTZDateDef().updateTZDateDef( schema.getAuthorization(),
			Obj.getTZDateDefBuff() );
		if( Obj.getClassCode().equals( "DAZD" ) ) {
			obj = (ICFBamTZDateDefObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteTZDateDef( ICFBamTZDateDefObj Obj ) {
		ICFBamTZDateDefObj obj = Obj;
		ICFBamValueObj prev = obj.getOptionalLookupPrev();
		ICFBamValueObj next = obj.getOptionalLookupNext();
		schema.getBackingStore().getTableTZDateDef().deleteTZDateDef( schema.getAuthorization(),
			obj.getTZDateDefBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteTZDateDefByIdIdx( long TenantId,
		long Id )
	{
		CFBamValuePKey pkey = schema.getBackingStore().getFactoryValue().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamValueObj obj = readTZDateDef( pkey );
		if( obj != null ) {
			ICFBamTZDateDefEditObj editObj = (ICFBamTZDateDefEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTZDateDefEditObj)obj.beginEdit();
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

	public void deleteTZDateDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamValueByUNameIdxKey,
				ICFBamTZDateDefObj >();
		}
		CFBamValueByUNameIdxKey key = schema.getBackingStore().getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		ICFBamTZDateDefObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByUNameIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				Name );
		}
	}

	public void deleteTZDateDefByValTentIdx( long TenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getBackingStore().getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByValTentIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByValTentIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByValTentIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTZDateDefByScopeIdx( long TenantId,
		long ScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getBackingStore().getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByScopeIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByScopeIdx( schema.getAuthorization(),
				TenantId,
				ScopeId );
		}
	}

	public void deleteTZDateDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getBackingStore().getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteTZDateDefByDataScopeIdx( Short DataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getBackingStore().getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamValueByDataScopeIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByDataScopeIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
		}
	}

	public void deleteTZDateDefByVAccSecIdx( Short ViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamValueByVAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByVAccSecIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
		}
	}

	public void deleteTZDateDefByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamValueByVAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByVAccFreqIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
		}
	}

	public void deleteTZDateDefByEAccSecIdx( Short EditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getBackingStore().getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamValueByEAccSecIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByEAccSecIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
		}
	}

	public void deleteTZDateDefByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getBackingStore().getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamValueByEAccFreqIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByEAccFreqIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
		}
	}

	public void deleteTZDateDefByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getBackingStore().getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByPrevIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteTZDateDefByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamValueByNextIdxKey key = schema.getBackingStore().getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByNextIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteTZDateDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getBackingStore().getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByContPrevIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				PrevId );
		}
	}

	public void deleteTZDateDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId )
	{
		CFBamValueByContNextIdxKey key = schema.getBackingStore().getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey, ICFBamTZDateDefObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamValuePKey, ICFBamTZDateDefObj> dict = indexByContNextIdx.get( key );
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
			Iterator<ICFBamTZDateDefObj> iter = dict.values().iterator();
			ICFBamTZDateDefObj obj;
			List<ICFBamTZDateDefObj> toForget = new LinkedList<ICFBamTZDateDefObj>();
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
			schema.getBackingStore().getTableTZDateDef().deleteTZDateDefByContNextIdx( schema.getAuthorization(),
				TenantId,
				ScopeId,
				NextId );
		}
	}

	/**
	 *	Move the CFBamTZDateDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZDateDefObj refreshed cache instance.
	 */
	public ICFBamTZDateDefObj moveUpTZDateDef( ICFBamTZDateDefObj Obj ) {
		ICFBamTZDateDefObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveUpTZDateDef",
				"You cannot move an object that is being edited" );
		}
		CFBamTZDateDefBuff buff = schema.getBackingStore().getTableTZDateDef().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getTZDateDefTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamTZDateDefObj)obj.realize();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamTZDateDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZDateDefObj refreshed cache instance.
	 */
	public ICFBamTZDateDefObj moveDownTZDateDef( ICFBamTZDateDefObj Obj ) {
		ICFBamTZDateDefObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveDownTZDateDef",
				"You cannot move an object that is being edited" );
		}
		CFBamTZDateDefBuff buff = schema.getBackingStore().getTableTZDateDef().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getTZDateDefTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryValue().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamTZDateDefObj)obj.realize();
			ICFBamValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
