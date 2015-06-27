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

public class CFBamIndexColTableObj
	implements ICFBamIndexColTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamIndexColPKey, ICFBamIndexColObj> members;
	private Map<CFBamIndexColPKey, ICFBamIndexColObj> allIndexCol;
	private Map< CFBamIndexColByUNameIdxKey,
		ICFBamIndexColObj > indexByUNameIdx;
	private Map< CFBamIndexColByIdxColTenantIdxKey,
		Map<CFBamIndexColPKey, ICFBamIndexColObj > > indexByIdxColTenantIdx;
	private Map< CFBamIndexColByIndexIdxKey,
		Map<CFBamIndexColPKey, ICFBamIndexColObj > > indexByIndexIdx;
	private Map< CFBamIndexColByDefSchemaIdxKey,
		Map<CFBamIndexColPKey, ICFBamIndexColObj > > indexByDefSchemaIdx;
	private Map< CFBamIndexColByColIdxKey,
		Map<CFBamIndexColPKey, ICFBamIndexColObj > > indexByColIdx;
	private Map< CFBamIndexColByPrevIdxKey,
		Map<CFBamIndexColPKey, ICFBamIndexColObj > > indexByPrevIdx;
	private Map< CFBamIndexColByNextIdxKey,
		Map<CFBamIndexColPKey, ICFBamIndexColObj > > indexByNextIdx;
	private Map< CFBamIndexColByIdxPrevIdxKey,
		Map<CFBamIndexColPKey, ICFBamIndexColObj > > indexByIdxPrevIdx;
	private Map< CFBamIndexColByIdxNextIdxKey,
		Map<CFBamIndexColPKey, ICFBamIndexColObj > > indexByIdxNextIdx;
	public static String TABLE_NAME = "IndexCol";
	public static String TABLE_DBNAME = "idxcol";

	public CFBamIndexColTableObj() {
		schema = null;
		members = new HashMap<CFBamIndexColPKey, ICFBamIndexColObj>();
		allIndexCol = null;
		indexByUNameIdx = null;
		indexByIdxColTenantIdx = null;
		indexByIndexIdx = null;
		indexByDefSchemaIdx = null;
		indexByColIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByIdxPrevIdx = null;
		indexByIdxNextIdx = null;
	}

	public CFBamIndexColTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamIndexColPKey, ICFBamIndexColObj>();
		allIndexCol = null;
		indexByUNameIdx = null;
		indexByIdxColTenantIdx = null;
		indexByIndexIdx = null;
		indexByDefSchemaIdx = null;
		indexByColIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByIdxPrevIdx = null;
		indexByIdxNextIdx = null;
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
		allIndexCol = null;
		indexByUNameIdx = null;
		indexByIdxColTenantIdx = null;
		indexByIndexIdx = null;
		indexByDefSchemaIdx = null;
		indexByColIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByIdxPrevIdx = null;
		indexByIdxNextIdx = null;
		List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
		ICFBamIndexColObj cur = null;
		Iterator<ICFBamIndexColObj> iter = members.values().iterator();
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
	 *	CFBamIndexColObj.
	 */
	public ICFBamIndexColObj newInstance() {
		ICFBamIndexColObj inst = new CFBamIndexColObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamIndexColObj.
	 */
	public ICFBamIndexColEditObj newEditInstance( ICFBamIndexColObj orig ) {
		ICFBamIndexColEditObj edit = new CFBamIndexColEditObj( orig );
		return( edit );
	}

	public ICFBamIndexColObj realizeIndexCol( ICFBamIndexColObj Obj ) {
		ICFBamIndexColObj obj = Obj;
		CFBamIndexColPKey pkey = obj.getPKey();
		ICFBamIndexColObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamIndexColObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				CFBamIndexColByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryIndexCol().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIdxColTenantIdx != null ) {
				CFBamIndexColByIdxColTenantIdxKey keyIdxColTenantIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxColTenantIdxKey();
				keyIdxColTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxColTenantIdx = indexByIdxColTenantIdx.get( keyIdxColTenantIdx );
				if( mapIdxColTenantIdx != null ) {
					mapIdxColTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByIndexIdx != null ) {
				CFBamIndexColByIndexIdxKey keyIndexIdx =
					schema.getBackingStore().getFactoryIndexCol().newIndexIdxKey();
				keyIndexIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIndexIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIndexIdx = indexByIndexIdx.get( keyIndexIdx );
				if( mapIndexIdx != null ) {
					mapIndexIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamIndexColByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryIndexCol().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByColIdx != null ) {
				CFBamIndexColByColIdxKey keyColIdx =
					schema.getBackingStore().getFactoryIndexCol().newColIdxKey();
				keyColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyColIdx.setRequiredColumnId( keepObj.getRequiredColumnId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapColIdx = indexByColIdx.get( keyColIdx );
				if( mapColIdx != null ) {
					mapColIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamIndexColByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryIndexCol().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamIndexColByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryIndexCol().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByIdxPrevIdx != null ) {
				CFBamIndexColByIdxPrevIdxKey keyIdxPrevIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxPrevIdxKey();
				keyIdxPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIdxPrevIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxPrevIdx = indexByIdxPrevIdx.get( keyIdxPrevIdx );
				if( mapIdxPrevIdx != null ) {
					mapIdxPrevIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByIdxNextIdx != null ) {
				CFBamIndexColByIdxNextIdxKey keyIdxNextIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxNextIdxKey();
				keyIdxNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIdxNextIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxNextIdx = indexByIdxNextIdx.get( keyIdxNextIdx );
				if( mapIdxNextIdx != null ) {
					mapIdxNextIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				CFBamIndexColByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryIndexCol().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIdxColTenantIdx != null ) {
				CFBamIndexColByIdxColTenantIdxKey keyIdxColTenantIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxColTenantIdxKey();
				keyIdxColTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxColTenantIdx = indexByIdxColTenantIdx.get( keyIdxColTenantIdx );
				if( mapIdxColTenantIdx != null ) {
					mapIdxColTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIndexIdx != null ) {
				CFBamIndexColByIndexIdxKey keyIndexIdx =
					schema.getBackingStore().getFactoryIndexCol().newIndexIdxKey();
				keyIndexIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIndexIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIndexIdx = indexByIndexIdx.get( keyIndexIdx );
				if( mapIndexIdx != null ) {
					mapIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamIndexColByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryIndexCol().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByColIdx != null ) {
				CFBamIndexColByColIdxKey keyColIdx =
					schema.getBackingStore().getFactoryIndexCol().newColIdxKey();
				keyColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyColIdx.setRequiredColumnId( keepObj.getRequiredColumnId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapColIdx = indexByColIdx.get( keyColIdx );
				if( mapColIdx != null ) {
					mapColIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamIndexColByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryIndexCol().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamIndexColByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryIndexCol().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxPrevIdx != null ) {
				CFBamIndexColByIdxPrevIdxKey keyIdxPrevIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxPrevIdxKey();
				keyIdxPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIdxPrevIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxPrevIdx = indexByIdxPrevIdx.get( keyIdxPrevIdx );
				if( mapIdxPrevIdx != null ) {
					mapIdxPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxNextIdx != null ) {
				CFBamIndexColByIdxNextIdxKey keyIdxNextIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxNextIdxKey();
				keyIdxNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIdxNextIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxNextIdx = indexByIdxNextIdx.get( keyIdxNextIdx );
				if( mapIdxNextIdx != null ) {
					mapIdxNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allIndexCol != null ) {
				allIndexCol.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allIndexCol != null ) {
				allIndexCol.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				CFBamIndexColByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryIndexCol().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIdxColTenantIdx != null ) {
				CFBamIndexColByIdxColTenantIdxKey keyIdxColTenantIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxColTenantIdxKey();
				keyIdxColTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxColTenantIdx = indexByIdxColTenantIdx.get( keyIdxColTenantIdx );
				if( mapIdxColTenantIdx != null ) {
					mapIdxColTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIndexIdx != null ) {
				CFBamIndexColByIndexIdxKey keyIndexIdx =
					schema.getBackingStore().getFactoryIndexCol().newIndexIdxKey();
				keyIndexIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIndexIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIndexIdx = indexByIndexIdx.get( keyIndexIdx );
				if( mapIndexIdx != null ) {
					mapIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamIndexColByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryIndexCol().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByColIdx != null ) {
				CFBamIndexColByColIdxKey keyColIdx =
					schema.getBackingStore().getFactoryIndexCol().newColIdxKey();
				keyColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyColIdx.setRequiredColumnId( keepObj.getRequiredColumnId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapColIdx = indexByColIdx.get( keyColIdx );
				if( mapColIdx != null ) {
					mapColIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamIndexColByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryIndexCol().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamIndexColByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryIndexCol().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxPrevIdx != null ) {
				CFBamIndexColByIdxPrevIdxKey keyIdxPrevIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxPrevIdxKey();
				keyIdxPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIdxPrevIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxPrevIdx = indexByIdxPrevIdx.get( keyIdxPrevIdx );
				if( mapIdxPrevIdx != null ) {
					mapIdxPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxNextIdx != null ) {
				CFBamIndexColByIdxNextIdxKey keyIdxNextIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxNextIdxKey();
				keyIdxNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIdxNextIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxNextIdx = indexByIdxNextIdx.get( keyIdxNextIdx );
				if( mapIdxNextIdx != null ) {
					mapIdxNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetIndexCol( ICFBamIndexColObj Obj ) {
		forgetIndexCol( Obj, false );
	}

	public void forgetIndexCol( ICFBamIndexColObj Obj, boolean forgetSubObjects ) {
		ICFBamIndexColObj obj = Obj;
		CFBamIndexColPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamIndexColObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUNameIdx != null ) {
				CFBamIndexColByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryIndexCol().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIdxColTenantIdx != null ) {
				CFBamIndexColByIdxColTenantIdxKey keyIdxColTenantIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxColTenantIdxKey();
				keyIdxColTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxColTenantIdx = indexByIdxColTenantIdx.get( keyIdxColTenantIdx );
				if( mapIdxColTenantIdx != null ) {
					mapIdxColTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByIndexIdx != null ) {
				CFBamIndexColByIndexIdxKey keyIndexIdx =
					schema.getBackingStore().getFactoryIndexCol().newIndexIdxKey();
				keyIndexIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIndexIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIndexIdx = indexByIndexIdx.get( keyIndexIdx );
				if( mapIndexIdx != null ) {
					mapIndexIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamIndexColByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryIndexCol().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByColIdx != null ) {
				CFBamIndexColByColIdxKey keyColIdx =
					schema.getBackingStore().getFactoryIndexCol().newColIdxKey();
				keyColIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyColIdx.setRequiredColumnId( keepObj.getRequiredColumnId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapColIdx = indexByColIdx.get( keyColIdx );
				if( mapColIdx != null ) {
					mapColIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByPrevIdx != null ) {
				CFBamIndexColByPrevIdxKey keyPrevIdx =
					schema.getBackingStore().getFactoryIndexCol().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamIndexColByNextIdxKey keyNextIdx =
					schema.getBackingStore().getFactoryIndexCol().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByIdxPrevIdx != null ) {
				CFBamIndexColByIdxPrevIdxKey keyIdxPrevIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxPrevIdxKey();
				keyIdxPrevIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIdxPrevIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxPrevIdx = indexByIdxPrevIdx.get( keyIdxPrevIdx );
				if( mapIdxPrevIdx != null ) {
					mapIdxPrevIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByIdxNextIdx != null ) {
				CFBamIndexColByIdxNextIdxKey keyIdxNextIdx =
					schema.getBackingStore().getFactoryIndexCol().newIdxNextIdxKey();
				keyIdxNextIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIdxNextIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxNextIdx = indexByIdxNextIdx.get( keyIdxNextIdx );
				if( mapIdxNextIdx != null ) {
					mapIdxNextIdx.remove( keepObj.getPKey() );
				}
			}

			if( allIndexCol != null ) {
				allIndexCol.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetIndexColByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamIndexColPKey key = schema.getBackingStore().getFactoryIndexCol().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamIndexColObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetIndexColByUNameIdx( long TenantId,
		long IndexId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamIndexColByUNameIdxKey key = schema.getBackingStore().getFactoryIndexCol().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamIndexColObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetIndexColByIdxColTenantIdx( long TenantId )
	{
		if( indexByIdxColTenantIdx == null ) {
			return;
		}
		CFBamIndexColByIdxColTenantIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIdxColTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByIdxColTenantIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxColTenantIdx = indexByIdxColTenantIdx.get( key );
			if( mapIdxColTenantIdx != null ) {
				List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
				ICFBamIndexColObj cur = null;
				Iterator<ICFBamIndexColObj> iter = mapIdxColTenantIdx.values().iterator();
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

			indexByIdxColTenantIdx.remove( key );
		}
	}

	public void forgetIndexColByIndexIdx( long TenantId,
		long IndexId )
	{
		if( indexByIndexIdx == null ) {
			return;
		}
		CFBamIndexColByIndexIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIndexIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		if( indexByIndexIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIndexIdx = indexByIndexIdx.get( key );
			if( mapIndexIdx != null ) {
				List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
				ICFBamIndexColObj cur = null;
				Iterator<ICFBamIndexColObj> iter = mapIndexIdx.values().iterator();
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

			indexByIndexIdx.remove( key );
		}
	}

	public void forgetIndexColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamIndexColByDefSchemaIdxKey key = schema.getBackingStore().getFactoryIndexCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
				ICFBamIndexColObj cur = null;
				Iterator<ICFBamIndexColObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetIndexColByColIdx( long TenantId,
		long ColumnId )
	{
		if( indexByColIdx == null ) {
			return;
		}
		CFBamIndexColByColIdxKey key = schema.getBackingStore().getFactoryIndexCol().newColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredColumnId( ColumnId );
		if( indexByColIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj > mapColIdx = indexByColIdx.get( key );
			if( mapColIdx != null ) {
				List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
				ICFBamIndexColObj cur = null;
				Iterator<ICFBamIndexColObj> iter = mapColIdx.values().iterator();
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

			indexByColIdx.remove( key );
		}
	}

	public void forgetIndexColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		CFBamIndexColByPrevIdxKey key = schema.getBackingStore().getFactoryIndexCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
				ICFBamIndexColObj cur = null;
				Iterator<ICFBamIndexColObj> iter = mapPrevIdx.values().iterator();
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

	public void forgetIndexColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		CFBamIndexColByNextIdxKey key = schema.getBackingStore().getFactoryIndexCol().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
				ICFBamIndexColObj cur = null;
				Iterator<ICFBamIndexColObj> iter = mapNextIdx.values().iterator();
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

	public void forgetIndexColByIdxPrevIdx( long TenantId,
		long IndexId,
		Long PrevId )
	{
		if( indexByIdxPrevIdx == null ) {
			return;
		}
		CFBamIndexColByIdxPrevIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIdxPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setOptionalPrevId( PrevId );
		if( indexByIdxPrevIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxPrevIdx = indexByIdxPrevIdx.get( key );
			if( mapIdxPrevIdx != null ) {
				List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
				ICFBamIndexColObj cur = null;
				Iterator<ICFBamIndexColObj> iter = mapIdxPrevIdx.values().iterator();
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

			indexByIdxPrevIdx.remove( key );
		}
	}

	public void forgetIndexColByIdxNextIdx( long TenantId,
		long IndexId,
		Long NextId )
	{
		if( indexByIdxNextIdx == null ) {
			return;
		}
		CFBamIndexColByIdxNextIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIdxNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setOptionalNextId( NextId );
		if( indexByIdxNextIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj > mapIdxNextIdx = indexByIdxNextIdx.get( key );
			if( mapIdxNextIdx != null ) {
				List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
				ICFBamIndexColObj cur = null;
				Iterator<ICFBamIndexColObj> iter = mapIdxNextIdx.values().iterator();
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

			indexByIdxNextIdx.remove( key );
		}
	}

	public ICFBamIndexColObj createIndexCol( ICFBamIndexColObj Obj ) {
		ICFBamIndexColObj obj = Obj;
		CFBamIndexColBuff buff = obj.getIndexColBuff();
		schema.getBackingStore().getTableIndexCol().createIndexCol(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		ICFBamIndexColObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		return( obj );
	}

	public ICFBamIndexColObj readIndexCol( CFBamIndexColPKey pkey ) {
		return( readIndexCol( pkey, false ) );
	}

	public ICFBamIndexColObj readIndexCol( CFBamIndexColPKey pkey, boolean forceRead ) {
		ICFBamIndexColObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamIndexColBuff readBuff = schema.getBackingStore().getTableIndexCol().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamIndexColObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamIndexColObj lockIndexCol( CFBamIndexColPKey pkey ) {
		ICFBamIndexColObj locked = null;
		CFBamIndexColBuff lockBuff = schema.getBackingStore().getTableIndexCol().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getIndexColTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamIndexColObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockIndexCol", pkey );
		}
		return( locked );
	}

	public List<ICFBamIndexColObj> readAllIndexCol() {
		return( readAllIndexCol( false ) );
	}

	public List<ICFBamIndexColObj> readAllIndexCol( boolean forceRead ) {
		final String S_ProcName = "readAllIndexCol";
		if( ( allIndexCol == null ) || forceRead ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj> map = new HashMap<CFBamIndexColPKey,ICFBamIndexColObj>();
			allIndexCol = map;
			CFBamIndexColBuff[] buffList = schema.getBackingStore().getTableIndexCol().readAllDerived( schema.getAuthorization() );
			CFBamIndexColBuff buff;
			ICFBamIndexColObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexColObj realized = (ICFBamIndexColObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexColObj> cmp = new Comparator<ICFBamIndexColObj>() {
			public int compare( ICFBamIndexColObj lhs, ICFBamIndexColObj rhs ) {
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
					CFBamIndexColPKey lhsPKey = lhs.getPKey();
					CFBamIndexColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allIndexCol.size();
		ICFBamIndexColObj arr[] = new ICFBamIndexColObj[len];
		Iterator<ICFBamIndexColObj> valIter = allIndexCol.values().iterator();
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
		ArrayList<ICFBamIndexColObj> arrayList = new ArrayList<ICFBamIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamIndexColObj readIndexColByIdIdx( long TenantId,
		long Id )
	{
		return( readIndexColByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamIndexColObj readIndexColByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamIndexColPKey pkey = schema.getBackingStore().getFactoryIndexCol().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamIndexColObj obj = readIndexCol( pkey, forceRead );
		return( obj );
	}

	public ICFBamIndexColObj readIndexColByUNameIdx( long TenantId,
		long IndexId,
		String Name )
	{
		return( readIndexColByUNameIdx( TenantId,
			IndexId,
			Name,
			false ) );
	}

	public ICFBamIndexColObj readIndexColByUNameIdx( long TenantId,
		long IndexId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamIndexColByUNameIdxKey,
				ICFBamIndexColObj >();
		}
		CFBamIndexColByUNameIdxKey key = schema.getBackingStore().getFactoryIndexCol().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setRequiredName( Name );
		ICFBamIndexColObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamIndexColBuff buff = schema.getBackingStore().getTableIndexCol().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				IndexId,
				Name );
			if( buff != null ) {
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamIndexColObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamIndexColObj> readIndexColByIdxColTenantIdx( long TenantId )
	{
		return( readIndexColByIdxColTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamIndexColObj> readIndexColByIdxColTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByIdxColTenantIdx";
		CFBamIndexColByIdxColTenantIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIdxColTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamIndexColPKey, ICFBamIndexColObj> dict;
		if( indexByIdxColTenantIdx == null ) {
			indexByIdxColTenantIdx = new HashMap< CFBamIndexColByIdxColTenantIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByIdxColTenantIdx.containsKey( key ) ) {
			dict = indexByIdxColTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamIndexColPKey, ICFBamIndexColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByIdxColTenantIdx.put( key, dict );
			ICFBamIndexColObj obj;
			CFBamIndexColBuff[] buffList = schema.getBackingStore().getTableIndexCol().readDerivedByIdxColTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamIndexColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexColObj realized = (ICFBamIndexColObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexColObj> cmp = new Comparator<ICFBamIndexColObj>() {
			public int compare( ICFBamIndexColObj lhs, ICFBamIndexColObj rhs ) {
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
					CFBamIndexColPKey lhsPKey = lhs.getPKey();
					CFBamIndexColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamIndexColObj arr[] = new ICFBamIndexColObj[len];
		Iterator<ICFBamIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexColObj> arrayList = new ArrayList<ICFBamIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamIndexColObj> readIndexColByIndexIdx( long TenantId,
		long IndexId )
	{
		return( readIndexColByIndexIdx( TenantId,
			IndexId,
			false ) );
	}

	public List<ICFBamIndexColObj> readIndexColByIndexIdx( long TenantId,
		long IndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByIndexIdx";
		CFBamIndexColByIndexIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIndexIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		Map<CFBamIndexColPKey, ICFBamIndexColObj> dict;
		if( indexByIndexIdx == null ) {
			indexByIndexIdx = new HashMap< CFBamIndexColByIndexIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByIndexIdx.containsKey( key ) ) {
			dict = indexByIndexIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamIndexColPKey, ICFBamIndexColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByIndexIdx.put( key, dict );
			ICFBamIndexColObj obj;
			CFBamIndexColBuff[] buffList = schema.getBackingStore().getTableIndexCol().readDerivedByIndexIdx( schema.getAuthorization(),
				TenantId,
				IndexId );
			CFBamIndexColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexColObj realized = (ICFBamIndexColObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexColObj> cmp = new Comparator<ICFBamIndexColObj>() {
			public int compare( ICFBamIndexColObj lhs, ICFBamIndexColObj rhs ) {
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
					CFBamIndexColPKey lhsPKey = lhs.getPKey();
					CFBamIndexColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamIndexColObj arr[] = new ICFBamIndexColObj[len];
		Iterator<ICFBamIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexColObj> arrayList = new ArrayList<ICFBamIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamIndexColObj> readIndexColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readIndexColByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamIndexColObj> readIndexColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByDefSchemaIdx";
		CFBamIndexColByDefSchemaIdxKey key = schema.getBackingStore().getFactoryIndexCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamIndexColPKey, ICFBamIndexColObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamIndexColByDefSchemaIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamIndexColPKey, ICFBamIndexColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamIndexColObj obj;
			CFBamIndexColBuff[] buffList = schema.getBackingStore().getTableIndexCol().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamIndexColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexColObj realized = (ICFBamIndexColObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexColObj> cmp = new Comparator<ICFBamIndexColObj>() {
			public int compare( ICFBamIndexColObj lhs, ICFBamIndexColObj rhs ) {
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
					CFBamIndexColPKey lhsPKey = lhs.getPKey();
					CFBamIndexColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamIndexColObj arr[] = new ICFBamIndexColObj[len];
		Iterator<ICFBamIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexColObj> arrayList = new ArrayList<ICFBamIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamIndexColObj> readIndexColByColIdx( long TenantId,
		long ColumnId )
	{
		return( readIndexColByColIdx( TenantId,
			ColumnId,
			false ) );
	}

	public List<ICFBamIndexColObj> readIndexColByColIdx( long TenantId,
		long ColumnId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByColIdx";
		CFBamIndexColByColIdxKey key = schema.getBackingStore().getFactoryIndexCol().newColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredColumnId( ColumnId );
		Map<CFBamIndexColPKey, ICFBamIndexColObj> dict;
		if( indexByColIdx == null ) {
			indexByColIdx = new HashMap< CFBamIndexColByColIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByColIdx.containsKey( key ) ) {
			dict = indexByColIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamIndexColPKey, ICFBamIndexColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByColIdx.put( key, dict );
			ICFBamIndexColObj obj;
			CFBamIndexColBuff[] buffList = schema.getBackingStore().getTableIndexCol().readDerivedByColIdx( schema.getAuthorization(),
				TenantId,
				ColumnId );
			CFBamIndexColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexColObj realized = (ICFBamIndexColObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexColObj> cmp = new Comparator<ICFBamIndexColObj>() {
			public int compare( ICFBamIndexColObj lhs, ICFBamIndexColObj rhs ) {
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
					CFBamIndexColPKey lhsPKey = lhs.getPKey();
					CFBamIndexColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamIndexColObj arr[] = new ICFBamIndexColObj[len];
		Iterator<ICFBamIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexColObj> arrayList = new ArrayList<ICFBamIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamIndexColObj> readIndexColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readIndexColByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamIndexColObj> readIndexColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByPrevIdx";
		CFBamIndexColByPrevIdxKey key = schema.getBackingStore().getFactoryIndexCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamIndexColPKey, ICFBamIndexColObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamIndexColByPrevIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamIndexColPKey, ICFBamIndexColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByPrevIdx.put( key, dict );
			ICFBamIndexColObj obj;
			CFBamIndexColBuff[] buffList = schema.getBackingStore().getTableIndexCol().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamIndexColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexColObj realized = (ICFBamIndexColObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexColObj> cmp = new Comparator<ICFBamIndexColObj>() {
			public int compare( ICFBamIndexColObj lhs, ICFBamIndexColObj rhs ) {
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
					CFBamIndexColPKey lhsPKey = lhs.getPKey();
					CFBamIndexColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamIndexColObj arr[] = new ICFBamIndexColObj[len];
		Iterator<ICFBamIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexColObj> arrayList = new ArrayList<ICFBamIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamIndexColObj> readIndexColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readIndexColByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamIndexColObj> readIndexColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByNextIdx";
		CFBamIndexColByNextIdxKey key = schema.getBackingStore().getFactoryIndexCol().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamIndexColPKey, ICFBamIndexColObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamIndexColByNextIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamIndexColPKey, ICFBamIndexColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByNextIdx.put( key, dict );
			ICFBamIndexColObj obj;
			CFBamIndexColBuff[] buffList = schema.getBackingStore().getTableIndexCol().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamIndexColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexColObj realized = (ICFBamIndexColObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexColObj> cmp = new Comparator<ICFBamIndexColObj>() {
			public int compare( ICFBamIndexColObj lhs, ICFBamIndexColObj rhs ) {
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
					CFBamIndexColPKey lhsPKey = lhs.getPKey();
					CFBamIndexColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamIndexColObj arr[] = new ICFBamIndexColObj[len];
		Iterator<ICFBamIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexColObj> arrayList = new ArrayList<ICFBamIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamIndexColObj> readIndexColByIdxPrevIdx( long TenantId,
		long IndexId,
		Long PrevId )
	{
		return( readIndexColByIdxPrevIdx( TenantId,
			IndexId,
			PrevId,
			false ) );
	}

	public List<ICFBamIndexColObj> readIndexColByIdxPrevIdx( long TenantId,
		long IndexId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByIdxPrevIdx";
		CFBamIndexColByIdxPrevIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIdxPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamIndexColPKey, ICFBamIndexColObj> dict;
		if( indexByIdxPrevIdx == null ) {
			indexByIdxPrevIdx = new HashMap< CFBamIndexColByIdxPrevIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByIdxPrevIdx.containsKey( key ) ) {
			dict = indexByIdxPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamIndexColPKey, ICFBamIndexColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByIdxPrevIdx.put( key, dict );
			ICFBamIndexColObj obj;
			CFBamIndexColBuff[] buffList = schema.getBackingStore().getTableIndexCol().readDerivedByIdxPrevIdx( schema.getAuthorization(),
				TenantId,
				IndexId,
				PrevId );
			CFBamIndexColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexColObj realized = (ICFBamIndexColObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexColObj> cmp = new Comparator<ICFBamIndexColObj>() {
			public int compare( ICFBamIndexColObj lhs, ICFBamIndexColObj rhs ) {
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
					CFBamIndexColPKey lhsPKey = lhs.getPKey();
					CFBamIndexColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamIndexColObj arr[] = new ICFBamIndexColObj[len];
		Iterator<ICFBamIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexColObj> arrayList = new ArrayList<ICFBamIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamIndexColObj> readIndexColByIdxNextIdx( long TenantId,
		long IndexId,
		Long NextId )
	{
		return( readIndexColByIdxNextIdx( TenantId,
			IndexId,
			NextId,
			false ) );
	}

	public List<ICFBamIndexColObj> readIndexColByIdxNextIdx( long TenantId,
		long IndexId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByIdxNextIdx";
		CFBamIndexColByIdxNextIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIdxNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setOptionalNextId( NextId );
		Map<CFBamIndexColPKey, ICFBamIndexColObj> dict;
		if( indexByIdxNextIdx == null ) {
			indexByIdxNextIdx = new HashMap< CFBamIndexColByIdxNextIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByIdxNextIdx.containsKey( key ) ) {
			dict = indexByIdxNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamIndexColPKey, ICFBamIndexColObj>();
			// Allow other threads to dirty-read while we're loading
			indexByIdxNextIdx.put( key, dict );
			ICFBamIndexColObj obj;
			CFBamIndexColBuff[] buffList = schema.getBackingStore().getTableIndexCol().readDerivedByIdxNextIdx( schema.getAuthorization(),
				TenantId,
				IndexId,
				NextId );
			CFBamIndexColBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexColObj realized = (ICFBamIndexColObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexColObj> cmp = new Comparator<ICFBamIndexColObj>() {
			public int compare( ICFBamIndexColObj lhs, ICFBamIndexColObj rhs ) {
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
					CFBamIndexColPKey lhsPKey = lhs.getPKey();
					CFBamIndexColPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamIndexColObj arr[] = new ICFBamIndexColObj[len];
		Iterator<ICFBamIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexColObj> arrayList = new ArrayList<ICFBamIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamIndexColObj updateIndexCol( ICFBamIndexColObj Obj ) {
		ICFBamIndexColObj obj = Obj;
		schema.getBackingStore().getTableIndexCol().updateIndexCol( schema.getAuthorization(),
			Obj.getIndexColBuff() );
		obj = (ICFBamIndexColObj)Obj.realize();
		return( obj );
	}

	public void deleteIndexCol( ICFBamIndexColObj Obj ) {
		ICFBamIndexColObj obj = Obj;
		ICFBamIndexColObj prev = obj.getOptionalLookupPrev();
		ICFBamIndexColObj next = obj.getOptionalLookupNext();
		schema.getBackingStore().getTableIndexCol().deleteIndexCol( schema.getAuthorization(),
			obj.getIndexColBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteIndexColByIdIdx( long TenantId,
		long Id )
	{
		CFBamIndexColPKey pkey = schema.getBackingStore().getFactoryIndexCol().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamIndexColObj obj = readIndexCol( pkey );
		if( obj != null ) {
			ICFBamIndexColEditObj editObj = (ICFBamIndexColEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamIndexColEditObj)obj.beginEdit();
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

	public void deleteIndexColByUNameIdx( long TenantId,
		long IndexId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamIndexColByUNameIdxKey,
				ICFBamIndexColObj >();
		}
		CFBamIndexColByUNameIdxKey key = schema.getBackingStore().getFactoryIndexCol().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setRequiredName( Name );
		ICFBamIndexColObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableIndexCol().deleteIndexColByUNameIdx( schema.getAuthorization(),
				TenantId,
				IndexId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableIndexCol().deleteIndexColByUNameIdx( schema.getAuthorization(),
				TenantId,
				IndexId,
				Name );
		}
	}

	public void deleteIndexColByIdxColTenantIdx( long TenantId )
	{
		CFBamIndexColByIdxColTenantIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIdxColTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByIdxColTenantIdx == null ) {
			indexByIdxColTenantIdx = new HashMap< CFBamIndexColByIdxColTenantIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( indexByIdxColTenantIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj> dict = indexByIdxColTenantIdx.get( key );
			schema.getBackingStore().getTableIndexCol().deleteIndexColByIdxColTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamIndexColObj> iter = dict.values().iterator();
			ICFBamIndexColObj obj;
			List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIdxColTenantIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableIndexCol().deleteIndexColByIdxColTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteIndexColByIndexIdx( long TenantId,
		long IndexId )
	{
		CFBamIndexColByIndexIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIndexIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		if( indexByIndexIdx == null ) {
			indexByIndexIdx = new HashMap< CFBamIndexColByIndexIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( indexByIndexIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj> dict = indexByIndexIdx.get( key );
			schema.getBackingStore().getTableIndexCol().deleteIndexColByIndexIdx( schema.getAuthorization(),
				TenantId,
				IndexId );
			Iterator<ICFBamIndexColObj> iter = dict.values().iterator();
			ICFBamIndexColObj obj;
			List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIndexIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableIndexCol().deleteIndexColByIndexIdx( schema.getAuthorization(),
				TenantId,
				IndexId );
		}
	}

	public void deleteIndexColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamIndexColByDefSchemaIdxKey key = schema.getBackingStore().getFactoryIndexCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamIndexColByDefSchemaIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableIndexCol().deleteIndexColByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamIndexColObj> iter = dict.values().iterator();
			ICFBamIndexColObj obj;
			List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
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
			schema.getBackingStore().getTableIndexCol().deleteIndexColByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteIndexColByColIdx( long TenantId,
		long ColumnId )
	{
		CFBamIndexColByColIdxKey key = schema.getBackingStore().getFactoryIndexCol().newColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredColumnId( ColumnId );
		if( indexByColIdx == null ) {
			indexByColIdx = new HashMap< CFBamIndexColByColIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( indexByColIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj> dict = indexByColIdx.get( key );
			schema.getBackingStore().getTableIndexCol().deleteIndexColByColIdx( schema.getAuthorization(),
				TenantId,
				ColumnId );
			Iterator<ICFBamIndexColObj> iter = dict.values().iterator();
			ICFBamIndexColObj obj;
			List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByColIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableIndexCol().deleteIndexColByColIdx( schema.getAuthorization(),
				TenantId,
				ColumnId );
		}
	}

	public void deleteIndexColByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamIndexColByPrevIdxKey key = schema.getBackingStore().getFactoryIndexCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamIndexColByPrevIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj> dict = indexByPrevIdx.get( key );
			schema.getBackingStore().getTableIndexCol().deleteIndexColByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamIndexColObj> iter = dict.values().iterator();
			ICFBamIndexColObj obj;
			List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
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
			schema.getBackingStore().getTableIndexCol().deleteIndexColByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteIndexColByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamIndexColByNextIdxKey key = schema.getBackingStore().getFactoryIndexCol().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamIndexColByNextIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj> dict = indexByNextIdx.get( key );
			schema.getBackingStore().getTableIndexCol().deleteIndexColByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamIndexColObj> iter = dict.values().iterator();
			ICFBamIndexColObj obj;
			List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
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
			schema.getBackingStore().getTableIndexCol().deleteIndexColByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	public void deleteIndexColByIdxPrevIdx( long TenantId,
		long IndexId,
		Long PrevId )
	{
		CFBamIndexColByIdxPrevIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIdxPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setOptionalPrevId( PrevId );
		if( indexByIdxPrevIdx == null ) {
			indexByIdxPrevIdx = new HashMap< CFBamIndexColByIdxPrevIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( indexByIdxPrevIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj> dict = indexByIdxPrevIdx.get( key );
			schema.getBackingStore().getTableIndexCol().deleteIndexColByIdxPrevIdx( schema.getAuthorization(),
				TenantId,
				IndexId,
				PrevId );
			Iterator<ICFBamIndexColObj> iter = dict.values().iterator();
			ICFBamIndexColObj obj;
			List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIdxPrevIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableIndexCol().deleteIndexColByIdxPrevIdx( schema.getAuthorization(),
				TenantId,
				IndexId,
				PrevId );
		}
	}

	public void deleteIndexColByIdxNextIdx( long TenantId,
		long IndexId,
		Long NextId )
	{
		CFBamIndexColByIdxNextIdxKey key = schema.getBackingStore().getFactoryIndexCol().newIdxNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setOptionalNextId( NextId );
		if( indexByIdxNextIdx == null ) {
			indexByIdxNextIdx = new HashMap< CFBamIndexColByIdxNextIdxKey,
				Map< CFBamIndexColPKey, ICFBamIndexColObj > >();
		}
		if( indexByIdxNextIdx.containsKey( key ) ) {
			Map<CFBamIndexColPKey, ICFBamIndexColObj> dict = indexByIdxNextIdx.get( key );
			schema.getBackingStore().getTableIndexCol().deleteIndexColByIdxNextIdx( schema.getAuthorization(),
				TenantId,
				IndexId,
				NextId );
			Iterator<ICFBamIndexColObj> iter = dict.values().iterator();
			ICFBamIndexColObj obj;
			List<ICFBamIndexColObj> toForget = new LinkedList<ICFBamIndexColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIdxNextIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableIndexCol().deleteIndexColByIdxNextIdx( schema.getAuthorization(),
				TenantId,
				IndexId,
				NextId );
		}
	}

	/**
	 *	Move the CFBamIndexColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamIndexColObj refreshed cache instance.
	 */
	public ICFBamIndexColObj moveUpIndexCol( ICFBamIndexColObj Obj ) {
		ICFBamIndexColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveUpIndexCol",
				"You cannot move an object that is being edited" );
		}
		CFBamIndexColBuff buff = schema.getBackingStore().getTableIndexCol().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getIndexColTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamIndexColObj)obj.realize();
			ICFBamIndexColObj prev = obj.getOptionalLookupPrev( true );
			ICFBamIndexColObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamIndexColObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamIndexColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamIndexColObj refreshed cache instance.
	 */
	public ICFBamIndexColObj moveDownIndexCol( ICFBamIndexColObj Obj ) {
		ICFBamIndexColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"moveDownIndexCol",
				"You cannot move an object that is being edited" );
		}
		CFBamIndexColBuff buff = schema.getBackingStore().getTableIndexCol().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getIndexColTableObj().newInstance();
			obj.setPKey( schema.getBackingStore().getFactoryIndexCol().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamIndexColObj)obj.realize();
			ICFBamIndexColObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamIndexColObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamIndexColObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
