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

public class CFBamParamTableObj
	implements ICFBamParamTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamParamPKey, ICFBamParamObj> members;
	private Map<CFBamParamPKey, ICFBamParamObj> allParam;
	private Map< CFBamParamByUNameIdxKey,
		ICFBamParamObj > indexByUNameIdx;
	private Map< CFBamParamByValTentIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByValTentIdx;
	private Map< CFBamParamByServerMethodIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByServerMethodIdx;
	private Map< CFBamParamByDefSchemaIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByDefSchemaIdx;
	private Map< CFBamParamByServerTypeIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByServerTypeIdx;
	private Map< CFBamParamByPrevIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByPrevIdx;
	private Map< CFBamParamByNextIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByNextIdx;
	private Map< CFBamParamByContPrevIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByContPrevIdx;
	private Map< CFBamParamByContNextIdxKey,
		Map<CFBamParamPKey, ICFBamParamObj > > indexByContNextIdx;
	public static String TABLE_NAME = "Param";
	public static String TABLE_DBNAME = "srvprm";

	public CFBamParamTableObj() {
		schema = null;
		members = new HashMap<CFBamParamPKey, ICFBamParamObj>();
		allParam = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByServerMethodIdx = null;
		indexByDefSchemaIdx = null;
		indexByServerTypeIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
	}

	public CFBamParamTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamParamPKey, ICFBamParamObj>();
		allParam = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByServerMethodIdx = null;
		indexByDefSchemaIdx = null;
		indexByServerTypeIdx = null;
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
		allParam = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByServerMethodIdx = null;
		indexByDefSchemaIdx = null;
		indexByServerTypeIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
		ICFBamParamObj cur = null;
		Iterator<ICFBamParamObj> iter = members.values().iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			if( cur.getEdit() == null ) {
				toForget.add( cur );
			}
		}
		iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget();
		}
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamParamObj.
	 */
	public ICFBamParamObj newInstance() {
		ICFBamParamObj inst = new CFBamParamObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamParamObj.
	 */
	public ICFBamParamEditObj newEditInstance( ICFBamParamObj orig ) {
		ICFBamParamEditObj edit = new CFBamParamEditObj( orig );
		return( edit );
	}

	public ICFBamParamObj realizeParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = Obj;
		CFBamParamPKey pkey = obj.getPKey();
		ICFBamParamObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamParamObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamParamByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryParam().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByValTentIdx != null ) {
				CFBamParamByValTentIdxKey keyValTentIdx =
					schema.getBackingStore().getFactoryParam().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByServerMethodIdx != null ) {
				CFBamParamByServerMethodIdxKey keyServerMethodIdx =
					schema.getBackingStore().getFactoryParam().newServerMethodIdxKey();
				keyServerMethodIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamParamByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryParam().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByServerTypeIdx != null ) {
				CFBamParamByServerTypeIdxKey keyServerTypeIdx =
					schema.getBackingStore().getFactoryParam().newServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeTenantId( keepObj.getOptionalTypeTenantId() );
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamParamByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryParam().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamParamByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryParam().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamParamByContPrevIdxKey keyContPrevIdx =
					schema.getBackingStore().getFactoryParam().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamParamByContNextIdxKey keyContNextIdx =
					schema.getBackingStore().getFactoryParam().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamParamByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryParam().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByValTentIdx != null ) {
				CFBamParamByValTentIdxKey keyValTentIdx =
					schema.getBackingStore().getFactoryParam().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByServerMethodIdx != null ) {
				CFBamParamByServerMethodIdxKey keyServerMethodIdx =
					schema.getBackingStore().getFactoryParam().newServerMethodIdxKey();
				keyServerMethodIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamParamByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryParam().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByServerTypeIdx != null ) {
				CFBamParamByServerTypeIdxKey keyServerTypeIdx =
					schema.getBackingStore().getFactoryParam().newServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeTenantId( keepObj.getOptionalTypeTenantId() );
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamParamByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryParam().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamParamByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryParam().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamParamByContPrevIdxKey keyContPrevIdx =
					schema.getBackingStore().getFactoryParam().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamParamByContNextIdxKey keyContNextIdx =
					schema.getBackingStore().getFactoryParam().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allParam != null ) {
				allParam.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allParam != null ) {
				allParam.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamParamByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryParam().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByValTentIdx != null ) {
				CFBamParamByValTentIdxKey keyValTentIdx =
					schema.getBackingStore().getFactoryParam().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByServerMethodIdx != null ) {
				CFBamParamByServerMethodIdxKey keyServerMethodIdx =
					schema.getBackingStore().getFactoryParam().newServerMethodIdxKey();
				keyServerMethodIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamParamByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryParam().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByServerTypeIdx != null ) {
				CFBamParamByServerTypeIdxKey keyServerTypeIdx =
					schema.getBackingStore().getFactoryParam().newServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeTenantId( keepObj.getOptionalTypeTenantId() );
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamParamByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryParam().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamParamByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryParam().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamParamByContPrevIdxKey keyContPrevIdx =
					schema.getBackingStore().getFactoryParam().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamParamByContNextIdxKey keyContNextIdx =
					schema.getBackingStore().getFactoryParam().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetParam( ICFBamParamObj Obj ) {
		forgetParam( Obj, false );
	}

	public void forgetParam( ICFBamParamObj Obj, boolean forgetSubObjects ) {
		ICFBamParamObj obj = Obj;
		CFBamParamPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamParamObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamParamByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryParam().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByValTentIdx != null ) {
				CFBamParamByValTentIdxKey keyValTentIdx =
					schema.getBackingStore().getFactoryParam().newValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByServerMethodIdx != null ) {
				CFBamParamByServerMethodIdxKey keyServerMethodIdx =
					schema.getBackingStore().getFactoryParam().newServerMethodIdxKey();
				keyServerMethodIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamParamByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryParam().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByServerTypeIdx != null ) {
				CFBamParamByServerTypeIdxKey keyServerTypeIdx =
					schema.getBackingStore().getFactoryParam().newServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeTenantId( keepObj.getOptionalTypeTenantId() );
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamParamByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryParam().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamParamByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryParam().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByContPrevIdx != null ) {
				CFBamParamByContPrevIdxKey keyContPrevIdx =
					schema.getBackingStore().getFactoryParam().newContPrevIdxKey();
				keyContPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByContNextIdx != null ) {
				CFBamParamByContNextIdxKey keyContNextIdx =
					schema.getBackingStore().getFactoryParam().newContNextIdxKey();
				keyContNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamParamPKey, ICFBamParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.remove( keepObj.getPKey() );
				}
			}

			if( allParam != null ) {
				allParam.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetParamByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamParamPKey key = schema.getBackingStore().getFactoryParam().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamParamObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetParamByUNameIdx( long TenantId,
		long ServerMethodId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamParamByUNameIdxKey key = schema.getBackingStore().getFactoryParam().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamParamObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetParamByValTentIdx( long TenantId )
	{
		if( indexByValTentIdx == null ) {
			return;
		}
		CFBamParamByValTentIdxKey key = schema.getBackingStore().getFactoryParam().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapValTentIdx = indexByValTentIdx.get( key );
			if( mapValTentIdx != null ) {
				List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
				ICFBamParamObj cur = null;
				Iterator<ICFBamParamObj> iter = mapValTentIdx.values().iterator();
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

	public void forgetParamByServerMethodIdx( long TenantId,
		long ServerMethodId )
	{
		if( indexByServerMethodIdx == null ) {
			return;
		}
		CFBamParamByServerMethodIdxKey key = schema.getBackingStore().getFactoryParam().newServerMethodIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		if( indexByServerMethodIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( key );
			if( mapServerMethodIdx != null ) {
				List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
				ICFBamParamObj cur = null;
				Iterator<ICFBamParamObj> iter = mapServerMethodIdx.values().iterator();
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

			indexByServerMethodIdx.remove( key );
		}
	}

	public void forgetParamByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamParamByDefSchemaIdxKey key = schema.getBackingStore().getFactoryParam().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
				ICFBamParamObj cur = null;
				Iterator<ICFBamParamObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetParamByServerTypeIdx( Long TypeTenantId,
		Long TypeId )
	{
		if( indexByServerTypeIdx == null ) {
			return;
		}
		CFBamParamByServerTypeIdxKey key = schema.getBackingStore().getFactoryParam().newServerTypeIdxKey();
		key.setOptionalTypeTenantId( TypeTenantId );
		key.setOptionalTypeId( TypeId );
		if( indexByServerTypeIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( key );
			if( mapServerTypeIdx != null ) {
				List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
				ICFBamParamObj cur = null;
				Iterator<ICFBamParamObj> iter = mapServerTypeIdx.values().iterator();
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

			indexByServerTypeIdx.remove( key );
		}
	}

	public void forgetParamByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		CFBamParamByPrevIdxKey key = schema.getBackingStore().getFactoryParam().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
				ICFBamParamObj cur = null;
				Iterator<ICFBamParamObj> iter = mapPrevIdx.values().iterator();
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

	public void forgetParamByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		CFBamParamByNextIdxKey key = schema.getBackingStore().getFactoryParam().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
				ICFBamParamObj cur = null;
				Iterator<ICFBamParamObj> iter = mapNextIdx.values().iterator();
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

	public void forgetParamByContPrevIdx( long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		if( indexByContPrevIdx == null ) {
			return;
		}
		CFBamParamByContPrevIdxKey key = schema.getBackingStore().getFactoryParam().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapContPrevIdx = indexByContPrevIdx.get( key );
			if( mapContPrevIdx != null ) {
				List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
				ICFBamParamObj cur = null;
				Iterator<ICFBamParamObj> iter = mapContPrevIdx.values().iterator();
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

	public void forgetParamByContNextIdx( long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		if( indexByContNextIdx == null ) {
			return;
		}
		CFBamParamByContNextIdxKey key = schema.getBackingStore().getFactoryParam().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj > mapContNextIdx = indexByContNextIdx.get( key );
			if( mapContNextIdx != null ) {
				List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
				ICFBamParamObj cur = null;
				Iterator<ICFBamParamObj> iter = mapContNextIdx.values().iterator();
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

	public ICFBamParamObj createParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = Obj;
		CFBamParamBuff buff = obj.getParamBuff();
		schema.getBackingStore().getTableParam().createParam(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		ICFBamParamObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		return( obj );
	}

	public ICFBamParamObj readParam( CFBamParamPKey pkey ) {
		return( readParam( pkey, false ) );
	}

	public ICFBamParamObj readParam( CFBamParamPKey pkey, boolean forceRead ) {
		ICFBamParamObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamParamBuff readBuff = schema.getBackingStore().getTableParam().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamParamObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamParamObj lockParam( CFBamParamPKey pkey ) {
		ICFBamParamObj locked = null;
		CFBamParamBuff lockBuff = schema.getBackingStore().getTableParam().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getParamTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamParamObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockParam", pkey );
		}
		return( locked );
	}

	public List<ICFBamParamObj> readAllParam() {
		return( readAllParam( false ) );
	}

	public List<ICFBamParamObj> readAllParam( boolean forceRead ) {
		final String S_ProcName = "readAllParam";
		if( ( allParam == null ) || forceRead ) {
			Map<CFBamParamPKey, ICFBamParamObj> map = new HashMap<CFBamParamPKey,ICFBamParamObj>();
			allParam = map;
			CFBamParamBuff[] buffList = schema.getBackingStore().getTableParam().readAllDerived( schema.getAuthorization() );
			CFBamParamBuff buff;
			ICFBamParamObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realized = (ICFBamParamObj)obj.realize();
			}
		}
		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allParam.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = allParam.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamParamObj readParamByIdIdx( long TenantId,
		long Id )
	{
		return( readParamByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamParamObj readParamByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamParamPKey pkey = schema.getBackingStore().getFactoryParam().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamParamObj obj = readParam( pkey, forceRead );
		return( obj );
	}

	public ICFBamParamObj readParamByUNameIdx( long TenantId,
		long ServerMethodId,
		String Name )
	{
		return( readParamByUNameIdx( TenantId,
			ServerMethodId,
			Name,
			false ) );
	}

	public ICFBamParamObj readParamByUNameIdx( long TenantId,
		long ServerMethodId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamParamByUNameIdxKey,
				ICFBamParamObj >();
		}
		CFBamParamByUNameIdxKey key = schema.getBackingStore().getFactoryParam().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );
		ICFBamParamObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamParamBuff buff = schema.getBackingStore().getTableParam().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				Name );
			if( buff != null ) {
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamParamObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamParamObj> readParamByValTentIdx( long TenantId )
	{
		return( readParamByValTentIdx( TenantId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByValTentIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByValTentIdx";
		CFBamParamByValTentIdxKey key = schema.getBackingStore().getFactoryParam().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamParamByValTentIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			// Allow other threads to dirty-read while we're loading
			indexByValTentIdx.put( key, dict );
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = schema.getBackingStore().getTableParam().readDerivedByValTentIdx( schema.getAuthorization(),
				TenantId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realized = (ICFBamParamObj)obj.realize();
			}
		}
		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByServerMethodIdx( long TenantId,
		long ServerMethodId )
	{
		return( readParamByServerMethodIdx( TenantId,
			ServerMethodId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByServerMethodIdx( long TenantId,
		long ServerMethodId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByServerMethodIdx";
		CFBamParamByServerMethodIdxKey key = schema.getBackingStore().getFactoryParam().newServerMethodIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByServerMethodIdx == null ) {
			indexByServerMethodIdx = new HashMap< CFBamParamByServerMethodIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByServerMethodIdx.containsKey( key ) ) {
			dict = indexByServerMethodIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			// Allow other threads to dirty-read while we're loading
			indexByServerMethodIdx.put( key, dict );
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = schema.getBackingStore().getTableParam().readDerivedByServerMethodIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realized = (ICFBamParamObj)obj.realize();
			}
		}
		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readParamByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByDefSchemaIdx";
		CFBamParamByDefSchemaIdxKey key = schema.getBackingStore().getFactoryParam().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamParamByDefSchemaIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = schema.getBackingStore().getTableParam().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realized = (ICFBamParamObj)obj.realize();
			}
		}
		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByServerTypeIdx( Long TypeTenantId,
		Long TypeId )
	{
		return( readParamByServerTypeIdx( TypeTenantId,
			TypeId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByServerTypeIdx( Long TypeTenantId,
		Long TypeId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByServerTypeIdx";
		CFBamParamByServerTypeIdxKey key = schema.getBackingStore().getFactoryParam().newServerTypeIdxKey();
		key.setOptionalTypeTenantId( TypeTenantId );
		key.setOptionalTypeId( TypeId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByServerTypeIdx == null ) {
			indexByServerTypeIdx = new HashMap< CFBamParamByServerTypeIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByServerTypeIdx.containsKey( key ) ) {
			dict = indexByServerTypeIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			// Allow other threads to dirty-read while we're loading
			indexByServerTypeIdx.put( key, dict );
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = schema.getBackingStore().getTableParam().readDerivedByServerTypeIdx( schema.getAuthorization(),
				TypeTenantId,
				TypeId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realized = (ICFBamParamObj)obj.realize();
			}
		}
		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readParamByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByPrevIdx";
		CFBamParamByPrevIdxKey key = schema.getBackingStore().getFactoryParam().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamParamByPrevIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			// Allow other threads to dirty-read while we're loading
			indexByPrevIdx.put( key, dict );
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = schema.getBackingStore().getTableParam().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realized = (ICFBamParamObj)obj.realize();
			}
		}
		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readParamByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByNextIdx";
		CFBamParamByNextIdxKey key = schema.getBackingStore().getFactoryParam().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamParamByNextIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			// Allow other threads to dirty-read while we're loading
			indexByNextIdx.put( key, dict );
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = schema.getBackingStore().getTableParam().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realized = (ICFBamParamObj)obj.realize();
			}
		}
		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByContPrevIdx( long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		return( readParamByContPrevIdx( TenantId,
			ServerMethodId,
			PrevId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByContPrevIdx( long TenantId,
		long ServerMethodId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByContPrevIdx";
		CFBamParamByContPrevIdxKey key = schema.getBackingStore().getFactoryParam().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamParamByContPrevIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			// Allow other threads to dirty-read while we're loading
			indexByContPrevIdx.put( key, dict );
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = schema.getBackingStore().getTableParam().readDerivedByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				PrevId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realized = (ICFBamParamObj)obj.realize();
			}
		}
		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamParamObj> readParamByContNextIdx( long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		return( readParamByContNextIdx( TenantId,
			ServerMethodId,
			NextId,
			false ) );
	}

	public List<ICFBamParamObj> readParamByContNextIdx( long TenantId,
		long ServerMethodId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByContNextIdx";
		CFBamParamByContNextIdxKey key = schema.getBackingStore().getFactoryParam().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );
		Map<CFBamParamPKey, ICFBamParamObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamParamByContNextIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamParamPKey, ICFBamParamObj>();
			// Allow other threads to dirty-read while we're loading
			indexByContNextIdx.put( key, dict );
			ICFBamParamObj obj;
			CFBamParamBuff[] buffList = schema.getBackingStore().getTableParam().readDerivedByContNextIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				NextId );
			CFBamParamBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
				obj.setBuff( buff );
				ICFBamParamObj realized = (ICFBamParamObj)obj.realize();
			}
		}
		Comparator<ICFBamParamObj> cmp = new Comparator<ICFBamParamObj>() {
			public int compare( ICFBamParamObj lhs, ICFBamParamObj rhs ) {
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
					CFBamParamPKey lhsPKey = lhs.getPKey();
					CFBamParamPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamParamObj arr[] = new ICFBamParamObj[len];
		Iterator<ICFBamParamObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamParamObj> arrayList = new ArrayList<ICFBamParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamParamObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamParamObj updateParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = Obj;
		schema.getBackingStore().getTableParam().updateParam( schema.getAuthorization(),
			Obj.getParamBuff() );
		obj = (ICFBamParamObj)Obj.realize();
		return( obj );
	}

	public void deleteParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = Obj;
		ICFBamParamObj prev = obj.getOptionalLookupPrev();
		ICFBamParamObj next = obj.getOptionalLookupNext();
		schema.getBackingStore().getTableParam().deleteParam( schema.getAuthorization(),
			obj.getParamBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteParamByIdIdx( long TenantId,
		long Id )
	{
		CFBamParamPKey pkey = schema.getBackingStore().getFactoryParam().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamParamObj obj = readParam( pkey );
		if( obj != null ) {
			ICFBamParamEditObj editObj = (ICFBamParamEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamParamEditObj)obj.beginEdit();
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

	public void deleteParamByUNameIdx( long TenantId,
		long ServerMethodId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamParamByUNameIdxKey,
				ICFBamParamObj >();
		}
		CFBamParamByUNameIdxKey key = schema.getBackingStore().getFactoryParam().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );
		ICFBamParamObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableParam().deleteParamByUNameIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableParam().deleteParamByUNameIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				Name );
		}
	}

	public void deleteParamByValTentIdx( long TenantId )
	{
		CFBamParamByValTentIdxKey key = schema.getBackingStore().getFactoryParam().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< CFBamParamByValTentIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByValTentIdx.get( key );
			schema.getBackingStore().getTableParam().deleteParamByValTentIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			schema.getBackingStore().getTableParam().deleteParamByValTentIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteParamByServerMethodIdx( long TenantId,
		long ServerMethodId )
	{
		CFBamParamByServerMethodIdxKey key = schema.getBackingStore().getFactoryParam().newServerMethodIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		if( indexByServerMethodIdx == null ) {
			indexByServerMethodIdx = new HashMap< CFBamParamByServerMethodIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByServerMethodIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByServerMethodIdx.get( key );
			schema.getBackingStore().getTableParam().deleteParamByServerMethodIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByServerMethodIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableParam().deleteParamByServerMethodIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId );
		}
	}

	public void deleteParamByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamParamByDefSchemaIdxKey key = schema.getBackingStore().getFactoryParam().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamParamByDefSchemaIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableParam().deleteParamByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			schema.getBackingStore().getTableParam().deleteParamByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteParamByServerTypeIdx( Long TypeTenantId,
		Long TypeId )
	{
		CFBamParamByServerTypeIdxKey key = schema.getBackingStore().getFactoryParam().newServerTypeIdxKey();
		key.setOptionalTypeTenantId( TypeTenantId );
		key.setOptionalTypeId( TypeId );
		if( indexByServerTypeIdx == null ) {
			indexByServerTypeIdx = new HashMap< CFBamParamByServerTypeIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByServerTypeIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByServerTypeIdx.get( key );
			schema.getBackingStore().getTableParam().deleteParamByServerTypeIdx( schema.getAuthorization(),
				TypeTenantId,
				TypeId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByServerTypeIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableParam().deleteParamByServerTypeIdx( schema.getAuthorization(),
				TypeTenantId,
				TypeId );
		}
	}

	public void deleteParamByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamParamByPrevIdxKey key = schema.getBackingStore().getFactoryParam().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamParamByPrevIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByPrevIdx.get( key );
			schema.getBackingStore().getTableParam().deleteParamByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			schema.getBackingStore().getTableParam().deleteParamByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteParamByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamParamByNextIdxKey key = schema.getBackingStore().getFactoryParam().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamParamByNextIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByNextIdx.get( key );
			schema.getBackingStore().getTableParam().deleteParamByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			schema.getBackingStore().getTableParam().deleteParamByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteParamByContPrevIdx( long TenantId,
		long ServerMethodId,
		Long PrevId )
	{
		CFBamParamByContPrevIdxKey key = schema.getBackingStore().getFactoryParam().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< CFBamParamByContPrevIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByContPrevIdx.get( key );
			schema.getBackingStore().getTableParam().deleteParamByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				PrevId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			schema.getBackingStore().getTableParam().deleteParamByContPrevIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				PrevId );
		}
	}

	public void deleteParamByContNextIdx( long TenantId,
		long ServerMethodId,
		Long NextId )
	{
		CFBamParamByContNextIdxKey key = schema.getBackingStore().getFactoryParam().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< CFBamParamByContNextIdxKey,
				Map< CFBamParamPKey, ICFBamParamObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<CFBamParamPKey, ICFBamParamObj> dict = indexByContNextIdx.get( key );
			schema.getBackingStore().getTableParam().deleteParamByContNextIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				NextId );
			Iterator<ICFBamParamObj> iter = dict.values().iterator();
			ICFBamParamObj obj;
			List<ICFBamParamObj> toForget = new LinkedList<ICFBamParamObj>();
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
			schema.getBackingStore().getTableParam().deleteParamByContNextIdx( schema.getAuthorization(),
				TenantId,
				ServerMethodId,
				NextId );
		}
	}

	/**
	 *	Move the CFBamParamObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamParamObj refreshed cache instance.
	 */
	public ICFBamParamObj moveUpParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveUpParam",
				"You cannot move an object that is being edited" );
		}
		CFBamParamBuff buff = schema.getBackingStore().getTableParam().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getParamTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamParamObj)obj.realize();
			ICFBamParamObj prev = obj.getOptionalLookupPrev( true );
			ICFBamParamObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamParamObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamParamObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamParamObj refreshed cache instance.
	 */
	public ICFBamParamObj moveDownParam( ICFBamParamObj Obj ) {
		ICFBamParamObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveDownParam",
				"You cannot move an object that is being edited" );
		}
		CFBamParamBuff buff = schema.getBackingStore().getTableParam().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getParamTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryParam().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamParamObj)obj.realize();
			ICFBamParamObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamParamObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamParamObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
