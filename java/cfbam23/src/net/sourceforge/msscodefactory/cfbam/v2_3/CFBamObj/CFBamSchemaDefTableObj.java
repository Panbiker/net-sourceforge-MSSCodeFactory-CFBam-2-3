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

public class CFBamSchemaDefTableObj
	implements ICFBamSchemaDefTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamSchemaDefObj> members;
	private Map<CFBamScopePKey, ICFBamSchemaDefObj> allSchemaDef;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByTenantIdx;
	private Map< CFBamSchemaDefByCTenantIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByCTenantIdx;
	private Map< CFBamSchemaDefByDomainIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByDomainIdx;
	private Map< CFBamSchemaDefByUNameIdxKey,
		ICFBamSchemaDefObj > indexByUNameIdx;
	private Map< CFBamSchemaDefByDefLcnIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByDefLcnIdx;
	private Map< CFBamSchemaDefByDataScopeIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByDataScopeIdx;
	private Map< CFBamSchemaDefByVAccSecIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByVAccSecIdx;
	private Map< CFBamSchemaDefByVAccFreqIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByVAccFreqIdx;
	private Map< CFBamSchemaDefByEAccSecIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByEAccSecIdx;
	private Map< CFBamSchemaDefByEAccFreqIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaDefObj > > indexByEAccFreqIdx;
	private Map< CFBamSchemaDefByPubURIIdxKey,
		ICFBamSchemaDefObj > indexByPubURIIdx;
	public static String TABLE_NAME = "SchemaDef";
	public static String TABLE_DBNAME = "schemadef";

	public CFBamSchemaDefTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
		allSchemaDef = null;
		indexByTenantIdx = null;
		indexByCTenantIdx = null;
		indexByDomainIdx = null;
		indexByUNameIdx = null;
		indexByDefLcnIdx = null;
		indexByDataScopeIdx = null;
		indexByVAccSecIdx = null;
		indexByVAccFreqIdx = null;
		indexByEAccSecIdx = null;
		indexByEAccFreqIdx = null;
		indexByPubURIIdx = null;
	}

	public CFBamSchemaDefTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
		allSchemaDef = null;
		indexByTenantIdx = null;
		indexByCTenantIdx = null;
		indexByDomainIdx = null;
		indexByUNameIdx = null;
		indexByDefLcnIdx = null;
		indexByDataScopeIdx = null;
		indexByVAccSecIdx = null;
		indexByVAccFreqIdx = null;
		indexByEAccSecIdx = null;
		indexByEAccFreqIdx = null;
		indexByPubURIIdx = null;
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
		return( ICFBamTenantObj.class );
	}


	public void minimizeMemory() {
		allSchemaDef = null;
		indexByTenantIdx = null;
		indexByCTenantIdx = null;
		indexByDomainIdx = null;
		indexByUNameIdx = null;
		indexByDefLcnIdx = null;
		indexByDataScopeIdx = null;
		indexByVAccSecIdx = null;
		indexByVAccFreqIdx = null;
		indexByEAccSecIdx = null;
		indexByEAccFreqIdx = null;
		indexByPubURIIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSchemaDefObj.
	 */
	public ICFBamSchemaDefObj newInstance() {
		ICFBamSchemaDefObj inst = new CFBamSchemaDefObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSchemaDefObj.
	 */
	public ICFBamSchemaDefEditObj newEditInstance( ICFBamSchemaDefObj orig ) {
		ICFBamSchemaDefEditObj edit = new CFBamSchemaDefEditObj( orig );
		return( edit );
	}

	public ICFBamSchemaDefObj realizeSchemaDef( ICFBamSchemaDefObj Obj ) {
		ICFBamSchemaDefObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamSchemaDefObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSchemaDefObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByCTenantIdx != null ) {
				CFBamSchemaDefByCTenantIdxKey keyCTenantIdx =
					schema.getBackingStore().getFactorySchemaDef().newCTenantIdxKey();
				keyCTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamSchemaDefByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactorySchemaDef().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaDefByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySchemaDef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByDefLcnIdx != null ) {
				CFBamSchemaDefByDefLcnIdxKey keyDefLcnIdx =
					schema.getBackingStore().getFactorySchemaDef().newDefLcnIdxKey();
				keyDefLcnIdx.setOptionalDefaultLicenseTenantId( keepObj.getOptionalDefaultLicenseTenantId() );
				keyDefLcnIdx.setOptionalDefaultLicenseId( keepObj.getOptionalDefaultLicenseId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDefLcnIdx = indexByDefLcnIdx.get( keyDefLcnIdx );
				if( mapDefLcnIdx != null ) {
					mapDefLcnIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamSchemaDefByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactorySchemaDef().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamSchemaDefByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactorySchemaDef().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamSchemaDefByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactorySchemaDef().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamSchemaDefByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactorySchemaDef().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamSchemaDefByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactorySchemaDef().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByPubURIIdx != null ) {
				CFBamSchemaDefByPubURIIdxKey keyPubURIIdx =
					schema.getBackingStore().getFactorySchemaDef().newPubURIIdxKey();
				keyPubURIIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.remove( keyPubURIIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamSchemaDefObj)schema.getScopeTableObj().realizeScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCTenantIdx != null ) {
				CFBamSchemaDefByCTenantIdxKey keyCTenantIdx =
					schema.getBackingStore().getFactorySchemaDef().newCTenantIdxKey();
				keyCTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamSchemaDefByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactorySchemaDef().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaDefByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySchemaDef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByDefLcnIdx != null ) {
				CFBamSchemaDefByDefLcnIdxKey keyDefLcnIdx =
					schema.getBackingStore().getFactorySchemaDef().newDefLcnIdxKey();
				keyDefLcnIdx.setOptionalDefaultLicenseTenantId( keepObj.getOptionalDefaultLicenseTenantId() );
				keyDefLcnIdx.setOptionalDefaultLicenseId( keepObj.getOptionalDefaultLicenseId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDefLcnIdx = indexByDefLcnIdx.get( keyDefLcnIdx );
				if( mapDefLcnIdx != null ) {
					mapDefLcnIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamSchemaDefByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactorySchemaDef().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamSchemaDefByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactorySchemaDef().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamSchemaDefByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactorySchemaDef().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamSchemaDefByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactorySchemaDef().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamSchemaDefByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactorySchemaDef().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPubURIIdx != null ) {
				CFBamSchemaDefByPubURIIdxKey keyPubURIIdx =
					schema.getBackingStore().getFactorySchemaDef().newPubURIIdxKey();
				keyPubURIIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.put( keyPubURIIdx, keepObj );
			}
			if( allSchemaDef != null ) {
				allSchemaDef.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamSchemaDefObj)schema.getScopeTableObj().realizeScope( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSchemaDef != null ) {
				allSchemaDef.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCTenantIdx != null ) {
				CFBamSchemaDefByCTenantIdxKey keyCTenantIdx =
					schema.getBackingStore().getFactorySchemaDef().newCTenantIdxKey();
				keyCTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamSchemaDefByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactorySchemaDef().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaDefByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySchemaDef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByDefLcnIdx != null ) {
				CFBamSchemaDefByDefLcnIdxKey keyDefLcnIdx =
					schema.getBackingStore().getFactorySchemaDef().newDefLcnIdxKey();
				keyDefLcnIdx.setOptionalDefaultLicenseTenantId( keepObj.getOptionalDefaultLicenseTenantId() );
				keyDefLcnIdx.setOptionalDefaultLicenseId( keepObj.getOptionalDefaultLicenseId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDefLcnIdx = indexByDefLcnIdx.get( keyDefLcnIdx );
				if( mapDefLcnIdx != null ) {
					mapDefLcnIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamSchemaDefByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactorySchemaDef().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamSchemaDefByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactorySchemaDef().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamSchemaDefByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactorySchemaDef().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamSchemaDefByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactorySchemaDef().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamSchemaDefByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactorySchemaDef().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPubURIIdx != null ) {
				CFBamSchemaDefByPubURIIdxKey keyPubURIIdx =
					schema.getBackingStore().getFactorySchemaDef().newPubURIIdxKey();
				keyPubURIIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.put( keyPubURIIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetSchemaDef( ICFBamSchemaDefObj Obj ) {
		forgetSchemaDef( Obj, false );
	}

	public void forgetSchemaDef( ICFBamSchemaDefObj Obj, boolean forgetSubObjects ) {
		ICFBamSchemaDefObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSchemaDefObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByCTenantIdx != null ) {
				CFBamSchemaDefByCTenantIdxKey keyCTenantIdx =
					schema.getBackingStore().getFactorySchemaDef().newCTenantIdxKey();
				keyCTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamSchemaDefByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactorySchemaDef().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaDefByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySchemaDef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByDefLcnIdx != null ) {
				CFBamSchemaDefByDefLcnIdxKey keyDefLcnIdx =
					schema.getBackingStore().getFactorySchemaDef().newDefLcnIdxKey();
				keyDefLcnIdx.setOptionalDefaultLicenseTenantId( keepObj.getOptionalDefaultLicenseTenantId() );
				keyDefLcnIdx.setOptionalDefaultLicenseId( keepObj.getOptionalDefaultLicenseId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDefLcnIdx = indexByDefLcnIdx.get( keyDefLcnIdx );
				if( mapDefLcnIdx != null ) {
					mapDefLcnIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDataScopeIdx != null ) {
				CFBamSchemaDefByDataScopeIdxKey keyDataScopeIdx =
					schema.getBackingStore().getFactorySchemaDef().newDataScopeIdxKey();
				keyDataScopeIdx.setOptionalDataScopeId( keepObj.getOptionalDataScopeId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDataScopeIdx = indexByDataScopeIdx.get( keyDataScopeIdx );
				if( mapDataScopeIdx != null ) {
					mapDataScopeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByVAccSecIdx != null ) {
				CFBamSchemaDefByVAccSecIdxKey keyVAccSecIdx =
					schema.getBackingStore().getFactorySchemaDef().newVAccSecIdxKey();
				keyVAccSecIdx.setOptionalViewAccessSecurityId( keepObj.getOptionalViewAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapVAccSecIdx = indexByVAccSecIdx.get( keyVAccSecIdx );
				if( mapVAccSecIdx != null ) {
					mapVAccSecIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByVAccFreqIdx != null ) {
				CFBamSchemaDefByVAccFreqIdxKey keyVAccFreqIdx =
					schema.getBackingStore().getFactorySchemaDef().newVAccFreqIdxKey();
				keyVAccFreqIdx.setOptionalViewAccessFrequencyId( keepObj.getOptionalViewAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( keyVAccFreqIdx );
				if( mapVAccFreqIdx != null ) {
					mapVAccFreqIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByEAccSecIdx != null ) {
				CFBamSchemaDefByEAccSecIdxKey keyEAccSecIdx =
					schema.getBackingStore().getFactorySchemaDef().newEAccSecIdxKey();
				keyEAccSecIdx.setOptionalEditAccessSecurityId( keepObj.getOptionalEditAccessSecurityId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapEAccSecIdx = indexByEAccSecIdx.get( keyEAccSecIdx );
				if( mapEAccSecIdx != null ) {
					mapEAccSecIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByEAccFreqIdx != null ) {
				CFBamSchemaDefByEAccFreqIdxKey keyEAccFreqIdx =
					schema.getBackingStore().getFactorySchemaDef().newEAccFreqIdxKey();
				keyEAccFreqIdx.setOptionalEditAccessFrequencyId( keepObj.getOptionalEditAccessFrequencyId() );
				Map<CFBamScopePKey, ICFBamSchemaDefObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( keyEAccFreqIdx );
				if( mapEAccFreqIdx != null ) {
					mapEAccFreqIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByPubURIIdx != null ) {
				CFBamSchemaDefByPubURIIdxKey keyPubURIIdx =
					schema.getBackingStore().getFactorySchemaDef().newPubURIIdxKey();
				keyPubURIIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.remove( keyPubURIIdx );
			}

			if( allSchemaDef != null ) {
				allSchemaDef.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getTableTableObj().forgetTableBySchemaDefIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getValueTableObj().forgetValueByScopeIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getSchemaRefTableObj().forgetSchemaRefBySchemaIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getScopeTableObj().forgetScope( obj );
	}

	public void forgetSchemaDefByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamSchemaDefObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSchemaDefByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
				ICFBamSchemaDefObj cur = null;
				Iterator<ICFBamSchemaDefObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetSchemaDefByCTenantIdx( long TenantId )
	{
		if( indexByCTenantIdx == null ) {
			return;
		}
		CFBamSchemaDefByCTenantIdxKey key = schema.getBackingStore().getFactorySchemaDef().newCTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByCTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( key );
			if( mapCTenantIdx != null ) {
				List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
				ICFBamSchemaDefObj cur = null;
				Iterator<ICFBamSchemaDefObj> iter = mapCTenantIdx.values().iterator();
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

			indexByCTenantIdx.remove( key );
		}
	}

	public void forgetSchemaDefByDomainIdx( long TenantId,
		long DomainId )
	{
		if( indexByDomainIdx == null ) {
			return;
		}
		CFBamSchemaDefByDomainIdxKey key = schema.getBackingStore().getFactorySchemaDef().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		if( indexByDomainIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDomainIdx = indexByDomainIdx.get( key );
			if( mapDomainIdx != null ) {
				List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
				ICFBamSchemaDefObj cur = null;
				Iterator<ICFBamSchemaDefObj> iter = mapDomainIdx.values().iterator();
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

			indexByDomainIdx.remove( key );
		}
	}

	public void forgetSchemaDefByUNameIdx( long TenantId,
		long DomainId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamSchemaDefByUNameIdxKey key = schema.getBackingStore().getFactorySchemaDef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamSchemaDefObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		if( indexByDefLcnIdx == null ) {
			return;
		}
		CFBamSchemaDefByDefLcnIdxKey key = schema.getBackingStore().getFactorySchemaDef().newDefLcnIdxKey();
		key.setOptionalDefaultLicenseTenantId( DefaultLicenseTenantId );
		key.setOptionalDefaultLicenseId( DefaultLicenseId );
		if( indexByDefLcnIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDefLcnIdx = indexByDefLcnIdx.get( key );
			if( mapDefLcnIdx != null ) {
				List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
				ICFBamSchemaDefObj cur = null;
				Iterator<ICFBamSchemaDefObj> iter = mapDefLcnIdx.values().iterator();
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

			indexByDefLcnIdx.remove( key );
		}
	}

	public void forgetSchemaDefByDataScopeIdx( Short DataScopeId )
	{
		if( indexByDataScopeIdx == null ) {
			return;
		}
		CFBamSchemaDefByDataScopeIdxKey key = schema.getBackingStore().getFactorySchemaDef().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapDataScopeIdx = indexByDataScopeIdx.get( key );
			if( mapDataScopeIdx != null ) {
				List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
				ICFBamSchemaDefObj cur = null;
				Iterator<ICFBamSchemaDefObj> iter = mapDataScopeIdx.values().iterator();
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

	public void forgetSchemaDefByVAccSecIdx( Short ViewAccessSecurityId )
	{
		if( indexByVAccSecIdx == null ) {
			return;
		}
		CFBamSchemaDefByVAccSecIdxKey key = schema.getBackingStore().getFactorySchemaDef().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapVAccSecIdx = indexByVAccSecIdx.get( key );
			if( mapVAccSecIdx != null ) {
				List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
				ICFBamSchemaDefObj cur = null;
				Iterator<ICFBamSchemaDefObj> iter = mapVAccSecIdx.values().iterator();
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

	public void forgetSchemaDefByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		if( indexByVAccFreqIdx == null ) {
			return;
		}
		CFBamSchemaDefByVAccFreqIdxKey key = schema.getBackingStore().getFactorySchemaDef().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapVAccFreqIdx = indexByVAccFreqIdx.get( key );
			if( mapVAccFreqIdx != null ) {
				List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
				ICFBamSchemaDefObj cur = null;
				Iterator<ICFBamSchemaDefObj> iter = mapVAccFreqIdx.values().iterator();
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

	public void forgetSchemaDefByEAccSecIdx( Short EditAccessSecurityId )
	{
		if( indexByEAccSecIdx == null ) {
			return;
		}
		CFBamSchemaDefByEAccSecIdxKey key = schema.getBackingStore().getFactorySchemaDef().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapEAccSecIdx = indexByEAccSecIdx.get( key );
			if( mapEAccSecIdx != null ) {
				List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
				ICFBamSchemaDefObj cur = null;
				Iterator<ICFBamSchemaDefObj> iter = mapEAccSecIdx.values().iterator();
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

	public void forgetSchemaDefByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		if( indexByEAccFreqIdx == null ) {
			return;
		}
		CFBamSchemaDefByEAccFreqIdxKey key = schema.getBackingStore().getFactorySchemaDef().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj > mapEAccFreqIdx = indexByEAccFreqIdx.get( key );
			if( mapEAccFreqIdx != null ) {
				List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
				ICFBamSchemaDefObj cur = null;
				Iterator<ICFBamSchemaDefObj> iter = mapEAccFreqIdx.values().iterator();
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

	public void forgetSchemaDefByPubURIIdx( long TenantId,
		String PublishURI )
	{
		if( indexByPubURIIdx == null ) {
			return;
		}
		CFBamSchemaDefByPubURIIdxKey key = schema.getBackingStore().getFactorySchemaDef().newPubURIIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredPublishURI( PublishURI );
		if( indexByPubURIIdx.containsKey( key ) ) {
			ICFBamSchemaDefObj probed = indexByPubURIIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByPubURIIdx.remove( key );
		}
	}

	public ICFBamSchemaDefObj createSchemaDef( ICFBamSchemaDefObj Obj ) {
		ICFBamSchemaDefObj obj = Obj;
		CFBamSchemaDefBuff buff = obj.getSchemaDefBuff();
		schema.getBackingStore().getTableSchemaDef().createSchemaDef(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "SCHM" ) ) {
			obj = (ICFBamSchemaDefObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamSchemaDefObj readSchemaDef( CFBamScopePKey pkey ) {
		return( readSchemaDef( pkey, false ) );
	}

	public ICFBamSchemaDefObj readSchemaDef( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamSchemaDefObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSchemaDefBuff readBuff = schema.getBackingStore().getTableSchemaDef().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSchemaDefObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSchemaDefObj lockSchemaDef( CFBamScopePKey pkey ) {
		ICFBamSchemaDefObj locked = null;
		CFBamSchemaDefBuff lockBuff = schema.getBackingStore().getTableSchemaDef().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSchemaDefObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSchemaDef", pkey );
		}
		return( locked );
	}

	public List<ICFBamSchemaDefObj> readAllSchemaDef() {
		return( readAllSchemaDef( false ) );
	}

	public List<ICFBamSchemaDefObj> readAllSchemaDef( boolean forceRead ) {
		final String S_ProcName = "readAllSchemaDef";
		if( ( allSchemaDef == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> map = new HashMap<CFBamScopePKey,ICFBamSchemaDefObj>();
			allSchemaDef = map;
			CFBamSchemaDefBuff[] buffList = schema.getBackingStore().getTableSchemaDef().readAllDerived( schema.getAuthorization() );
			CFBamSchemaDefBuff buff;
			ICFBamSchemaDefObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		int len = allSchemaDef.size();
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = allSchemaDef.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaDefObj readSchemaDefByIdIdx( long TenantId,
		long Id )
	{
		return( readSchemaDefByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamSchemaDefObj readSchemaDefByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamSchemaDefObj obj = readSchemaDef( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByTenantIdx( long TenantId )
	{
		return( readSchemaDefByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByCTenantIdx( long TenantId )
	{
		return( readSchemaDefByCTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByCTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByCTenantIdx";
		CFBamSchemaDefByCTenantIdxKey key = schema.getBackingStore().getFactorySchemaDef().newCTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByCTenantIdx == null ) {
			indexByCTenantIdx = new HashMap< CFBamSchemaDefByCTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByCTenantIdx.containsKey( key ) ) {
			dict = indexByCTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByCTenantIdx.put( key, dict );
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = schema.getBackingStore().getTableSchemaDef().readDerivedByCTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByDomainIdx( long TenantId,
		long DomainId )
	{
		return( readSchemaDefByDomainIdx( TenantId,
			DomainId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByDomainIdx( long TenantId,
		long DomainId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByDomainIdx";
		CFBamSchemaDefByDomainIdxKey key = schema.getBackingStore().getFactorySchemaDef().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByDomainIdx == null ) {
			indexByDomainIdx = new HashMap< CFBamSchemaDefByDomainIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByDomainIdx.containsKey( key ) ) {
			dict = indexByDomainIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDomainIdx.put( key, dict );
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = schema.getBackingStore().getTableSchemaDef().readDerivedByDomainIdx( schema.getAuthorization(),
				TenantId,
				DomainId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaDefObj readSchemaDefByUNameIdx( long TenantId,
		long DomainId,
		String Name )
	{
		return( readSchemaDefByUNameIdx( TenantId,
			DomainId,
			Name,
			false ) );
	}

	public ICFBamSchemaDefObj readSchemaDefByUNameIdx( long TenantId,
		long DomainId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSchemaDefByUNameIdxKey,
				ICFBamSchemaDefObj >();
		}
		CFBamSchemaDefByUNameIdxKey key = schema.getBackingStore().getFactorySchemaDef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );
		ICFBamSchemaDefObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamSchemaDefBuff buff = schema.getBackingStore().getTableSchemaDef().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				DomainId,
				Name );
			if( buff != null ) {
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSchemaDefObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		return( readSchemaDefByDefLcnIdx( DefaultLicenseTenantId,
			DefaultLicenseId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByDefLcnIdx";
		CFBamSchemaDefByDefLcnIdxKey key = schema.getBackingStore().getFactorySchemaDef().newDefLcnIdxKey();
		key.setOptionalDefaultLicenseTenantId( DefaultLicenseTenantId );
		key.setOptionalDefaultLicenseId( DefaultLicenseId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByDefLcnIdx == null ) {
			indexByDefLcnIdx = new HashMap< CFBamSchemaDefByDefLcnIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByDefLcnIdx.containsKey( key ) ) {
			dict = indexByDefLcnIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefLcnIdx.put( key, dict );
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = schema.getBackingStore().getTableSchemaDef().readDerivedByDefLcnIdx( schema.getAuthorization(),
				DefaultLicenseTenantId,
				DefaultLicenseId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByDataScopeIdx( Short DataScopeId )
	{
		return( readSchemaDefByDataScopeIdx( DataScopeId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByDataScopeIdx( Short DataScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByDataScopeIdx";
		CFBamSchemaDefByDataScopeIdxKey key = schema.getBackingStore().getFactorySchemaDef().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamSchemaDefByDataScopeIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByDataScopeIdx.containsKey( key ) ) {
			dict = indexByDataScopeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDataScopeIdx.put( key, dict );
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = schema.getBackingStore().getTableSchemaDef().readDerivedByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByVAccSecIdx( Short ViewAccessSecurityId )
	{
		return( readSchemaDefByVAccSecIdx( ViewAccessSecurityId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByVAccSecIdx";
		CFBamSchemaDefByVAccSecIdxKey key = schema.getBackingStore().getFactorySchemaDef().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamSchemaDefByVAccSecIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByVAccSecIdx.containsKey( key ) ) {
			dict = indexByVAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccSecIdx.put( key, dict );
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = schema.getBackingStore().getTableSchemaDef().readDerivedByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		return( readSchemaDefByVAccFreqIdx( ViewAccessFrequencyId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByVAccFreqIdx";
		CFBamSchemaDefByVAccFreqIdxKey key = schema.getBackingStore().getFactorySchemaDef().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamSchemaDefByVAccFreqIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByVAccFreqIdx.containsKey( key ) ) {
			dict = indexByVAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByVAccFreqIdx.put( key, dict );
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = schema.getBackingStore().getTableSchemaDef().readDerivedByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByEAccSecIdx( Short EditAccessSecurityId )
	{
		return( readSchemaDefByEAccSecIdx( EditAccessSecurityId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByEAccSecIdx";
		CFBamSchemaDefByEAccSecIdxKey key = schema.getBackingStore().getFactorySchemaDef().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamSchemaDefByEAccSecIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByEAccSecIdx.containsKey( key ) ) {
			dict = indexByEAccSecIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccSecIdx.put( key, dict );
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = schema.getBackingStore().getTableSchemaDef().readDerivedByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		return( readSchemaDefByEAccFreqIdx( EditAccessFrequencyId,
			false ) );
	}

	public List<ICFBamSchemaDefObj> readSchemaDefByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByEAccFreqIdx";
		CFBamSchemaDefByEAccFreqIdxKey key = schema.getBackingStore().getFactorySchemaDef().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		Map<CFBamScopePKey, ICFBamSchemaDefObj> dict;
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamSchemaDefByEAccFreqIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByEAccFreqIdx.containsKey( key ) ) {
			dict = indexByEAccFreqIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaDefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByEAccFreqIdx.put( key, dict );
			ICFBamSchemaDefObj obj;
			CFBamSchemaDefBuff[] buffList = schema.getBackingStore().getTableSchemaDef().readDerivedByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			CFBamSchemaDefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaDefObj> cmp = new Comparator<ICFBamSchemaDefObj>() {
			public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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
		ICFBamSchemaDefObj arr[] = new ICFBamSchemaDefObj[len];
		Iterator<ICFBamSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaDefObj> arrayList = new ArrayList<ICFBamSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaDefObj readSchemaDefByPubURIIdx( long TenantId,
		String PublishURI )
	{
		return( readSchemaDefByPubURIIdx( TenantId,
			PublishURI,
			false ) );
	}

	public ICFBamSchemaDefObj readSchemaDefByPubURIIdx( long TenantId,
		String PublishURI, boolean forceRead )
	{
		if( indexByPubURIIdx == null ) {
			indexByPubURIIdx = new HashMap< CFBamSchemaDefByPubURIIdxKey,
				ICFBamSchemaDefObj >();
		}
		CFBamSchemaDefByPubURIIdxKey key = schema.getBackingStore().getFactorySchemaDef().newPubURIIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredPublishURI( PublishURI );
		ICFBamSchemaDefObj obj = null;
		if( ( ! forceRead ) && indexByPubURIIdx.containsKey( key ) ) {
			obj = indexByPubURIIdx.get( key );
		}
		else {
			CFBamSchemaDefBuff buff = schema.getBackingStore().getTableSchemaDef().readDerivedByPubURIIdx( schema.getAuthorization(),
				TenantId,
				PublishURI );
			if( buff != null ) {
				obj = (ICFBamSchemaDefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSchemaDefObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByPubURIIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamSchemaDefObj updateSchemaDef( ICFBamSchemaDefObj Obj ) {
		ICFBamSchemaDefObj obj = Obj;
		schema.getBackingStore().getTableSchemaDef().updateSchemaDef( schema.getAuthorization(),
			Obj.getSchemaDefBuff() );
		if( Obj.getClassCode().equals( "SCHM" ) ) {
			obj = (ICFBamSchemaDefObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteSchemaDef( ICFBamSchemaDefObj Obj ) {
		ICFBamSchemaDefObj obj = Obj;
		schema.getBackingStore().getTableSchemaDef().deleteSchemaDef( schema.getAuthorization(),
			obj.getSchemaDefBuff() );
		obj.forget( true );
	}

	public void deleteSchemaDefByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readSchemaDef( pkey );
		if( obj != null ) {
			ICFBamSchemaDefEditObj editObj = (ICFBamSchemaDefEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSchemaDefEditObj)obj.beginEdit();
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

	public void deleteSchemaDefByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
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
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteSchemaDefByCTenantIdx( long TenantId )
	{
		CFBamSchemaDefByCTenantIdxKey key = schema.getBackingStore().getFactorySchemaDef().newCTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByCTenantIdx == null ) {
			indexByCTenantIdx = new HashMap< CFBamSchemaDefByCTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByCTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByCTenantIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByCTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByCTenantIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByCTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteSchemaDefByDomainIdx( long TenantId,
		long DomainId )
	{
		CFBamSchemaDefByDomainIdxKey key = schema.getBackingStore().getFactorySchemaDef().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		if( indexByDomainIdx == null ) {
			indexByDomainIdx = new HashMap< CFBamSchemaDefByDomainIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByDomainIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByDomainIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByDomainIdx( schema.getAuthorization(),
				TenantId,
				DomainId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDomainIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByDomainIdx( schema.getAuthorization(),
				TenantId,
				DomainId );
		}
	}

	public void deleteSchemaDefByUNameIdx( long TenantId,
		long DomainId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSchemaDefByUNameIdxKey,
				ICFBamSchemaDefObj >();
		}
		CFBamSchemaDefByUNameIdxKey key = schema.getBackingStore().getFactorySchemaDef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );
		ICFBamSchemaDefObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByUNameIdx( schema.getAuthorization(),
				TenantId,
				DomainId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByUNameIdx( schema.getAuthorization(),
				TenantId,
				DomainId,
				Name );
		}
	}

	public void deleteSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		CFBamSchemaDefByDefLcnIdxKey key = schema.getBackingStore().getFactorySchemaDef().newDefLcnIdxKey();
		key.setOptionalDefaultLicenseTenantId( DefaultLicenseTenantId );
		key.setOptionalDefaultLicenseId( DefaultLicenseId );
		if( indexByDefLcnIdx == null ) {
			indexByDefLcnIdx = new HashMap< CFBamSchemaDefByDefLcnIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByDefLcnIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByDefLcnIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByDefLcnIdx( schema.getAuthorization(),
				DefaultLicenseTenantId,
				DefaultLicenseId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDefLcnIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByDefLcnIdx( schema.getAuthorization(),
				DefaultLicenseTenantId,
				DefaultLicenseId );
		}
	}

	public void deleteSchemaDefByDataScopeIdx( Short DataScopeId )
	{
		CFBamSchemaDefByDataScopeIdxKey key = schema.getBackingStore().getFactorySchemaDef().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );
		if( indexByDataScopeIdx == null ) {
			indexByDataScopeIdx = new HashMap< CFBamSchemaDefByDataScopeIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByDataScopeIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByDataScopeIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
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
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByDataScopeIdx( schema.getAuthorization(),
				DataScopeId );
		}
	}

	public void deleteSchemaDefByVAccSecIdx( Short ViewAccessSecurityId )
	{
		CFBamSchemaDefByVAccSecIdxKey key = schema.getBackingStore().getFactorySchemaDef().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );
		if( indexByVAccSecIdx == null ) {
			indexByVAccSecIdx = new HashMap< CFBamSchemaDefByVAccSecIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByVAccSecIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByVAccSecIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
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
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByVAccSecIdx( schema.getAuthorization(),
				ViewAccessSecurityId );
		}
	}

	public void deleteSchemaDefByVAccFreqIdx( Short ViewAccessFrequencyId )
	{
		CFBamSchemaDefByVAccFreqIdxKey key = schema.getBackingStore().getFactorySchemaDef().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );
		if( indexByVAccFreqIdx == null ) {
			indexByVAccFreqIdx = new HashMap< CFBamSchemaDefByVAccFreqIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByVAccFreqIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByVAccFreqIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
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
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByVAccFreqIdx( schema.getAuthorization(),
				ViewAccessFrequencyId );
		}
	}

	public void deleteSchemaDefByEAccSecIdx( Short EditAccessSecurityId )
	{
		CFBamSchemaDefByEAccSecIdxKey key = schema.getBackingStore().getFactorySchemaDef().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );
		if( indexByEAccSecIdx == null ) {
			indexByEAccSecIdx = new HashMap< CFBamSchemaDefByEAccSecIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByEAccSecIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByEAccSecIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
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
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByEAccSecIdx( schema.getAuthorization(),
				EditAccessSecurityId );
		}
	}

	public void deleteSchemaDefByEAccFreqIdx( Short EditAccessFrequencyId )
	{
		CFBamSchemaDefByEAccFreqIdxKey key = schema.getBackingStore().getFactorySchemaDef().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );
		if( indexByEAccFreqIdx == null ) {
			indexByEAccFreqIdx = new HashMap< CFBamSchemaDefByEAccFreqIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaDefObj > >();
		}
		if( indexByEAccFreqIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaDefObj> dict = indexByEAccFreqIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
			Iterator<ICFBamSchemaDefObj> iter = dict.values().iterator();
			ICFBamSchemaDefObj obj;
			List<ICFBamSchemaDefObj> toForget = new LinkedList<ICFBamSchemaDefObj>();
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
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByEAccFreqIdx( schema.getAuthorization(),
				EditAccessFrequencyId );
		}
	}

	public void deleteSchemaDefByPubURIIdx( long TenantId,
		String PublishURI )
	{
		if( indexByPubURIIdx == null ) {
			indexByPubURIIdx = new HashMap< CFBamSchemaDefByPubURIIdxKey,
				ICFBamSchemaDefObj >();
		}
		CFBamSchemaDefByPubURIIdxKey key = schema.getBackingStore().getFactorySchemaDef().newPubURIIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredPublishURI( PublishURI );
		ICFBamSchemaDefObj obj = null;
		if( indexByPubURIIdx.containsKey( key ) ) {
			obj = indexByPubURIIdx.get( key );
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByPubURIIdx( schema.getAuthorization(),
				TenantId,
				PublishURI );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSchemaDef().deleteSchemaDefByPubURIIdx( schema.getAuthorization(),
				TenantId,
				PublishURI );
		}
	}
}
