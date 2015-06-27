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

public class CFBamServerObjFuncTableObj
	implements ICFBamServerObjFuncTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamServerObjFuncObj> members;
	private Map<CFBamScopePKey, ICFBamServerObjFuncObj> allServerObjFunc;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamServerObjFuncObj > > indexByTenantIdx;
	private Map< CFBamServerMethodByUNameIdxKey,
		ICFBamServerObjFuncObj > indexByUNameIdx;
	private Map< CFBamServerMethodByTableIdxKey,
		Map<CFBamScopePKey, ICFBamServerObjFuncObj > > indexByTableIdx;
	private Map< CFBamServerMethodByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamServerObjFuncObj > > indexByDefSchemaIdx;
	private Map< CFBamServerObjFuncByRetTblIdxKey,
		Map<CFBamScopePKey, ICFBamServerObjFuncObj > > indexByRetTblIdx;
	public static String TABLE_NAME = "ServerObjFunc";
	public static String TABLE_DBNAME = "srvofunc";

	public CFBamServerObjFuncTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
		allServerObjFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
	}

	public CFBamServerObjFuncTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
		allServerObjFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
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
		allServerObjFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamServerObjFuncObj.
	 */
	public ICFBamServerObjFuncObj newInstance() {
		ICFBamServerObjFuncObj inst = new CFBamServerObjFuncObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamServerObjFuncObj.
	 */
	public ICFBamServerObjFuncEditObj newEditInstance( ICFBamServerObjFuncObj orig ) {
		ICFBamServerObjFuncEditObj edit = new CFBamServerObjFuncEditObj( orig );
		return( edit );
	}

	public ICFBamServerObjFuncObj realizeServerObjFunc( ICFBamServerObjFuncObj Obj ) {
		ICFBamServerObjFuncObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamServerObjFuncObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamServerObjFuncObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamServerMethodByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryServerMethod().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByTableIdx != null ) {
				CFBamServerMethodByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryServerMethod().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerObjFuncByRetTblIdxKey keyRetTblIdx =
					schema.getBackingStore().getFactoryServerObjFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.remove( keepObj.getPKey() );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamServerObjFuncObj)schema.getServerMethodTableObj().realizeServerMethod( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamServerMethodByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryServerMethod().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByTableIdx != null ) {
				CFBamServerMethodByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryServerMethod().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerObjFuncByRetTblIdxKey keyRetTblIdx =
					schema.getBackingStore().getFactoryServerObjFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allServerObjFunc != null ) {
				allServerObjFunc.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamServerObjFuncObj)schema.getServerMethodTableObj().realizeServerMethod( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allServerObjFunc != null ) {
				allServerObjFunc.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamServerMethodByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryServerMethod().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByTableIdx != null ) {
				CFBamServerMethodByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryServerMethod().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerObjFuncByRetTblIdxKey keyRetTblIdx =
					schema.getBackingStore().getFactoryServerObjFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetServerObjFunc( ICFBamServerObjFuncObj Obj ) {
		forgetServerObjFunc( Obj, false );
	}

	public void forgetServerObjFunc( ICFBamServerObjFuncObj Obj, boolean forgetSubObjects ) {
		ICFBamServerObjFuncObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamServerObjFuncObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamServerMethodByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryServerMethod().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByTableIdx != null ) {
				CFBamServerMethodByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryServerMethod().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryServerMethod().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByRetTblIdx != null ) {
				CFBamServerObjFuncByRetTblIdxKey keyRetTblIdx =
					schema.getBackingStore().getFactoryServerObjFunc().newRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTenantId( keepObj.getOptionalRetTenantId() );
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.remove( keepObj.getPKey() );
				}
			}

			if( allServerObjFunc != null ) {
				allServerObjFunc.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getServerMethodTableObj().forgetServerMethod( obj );
	}

	public void forgetServerObjFuncByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamServerObjFuncObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetServerObjFuncByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
				ICFBamServerObjFuncObj cur = null;
				Iterator<ICFBamServerObjFuncObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetServerObjFuncByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamServerMethodByUNameIdxKey key = schema.getBackingStore().getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamServerObjFuncObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetServerObjFuncByTableIdx( long TenantId,
		long TableId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamServerMethodByTableIdxKey key = schema.getBackingStore().getFactoryServerMethod().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
				ICFBamServerObjFuncObj cur = null;
				Iterator<ICFBamServerObjFuncObj> iter = mapTableIdx.values().iterator();
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

	public void forgetServerObjFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamServerMethodByDefSchemaIdxKey key = schema.getBackingStore().getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
				ICFBamServerObjFuncObj cur = null;
				Iterator<ICFBamServerObjFuncObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetServerObjFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId )
	{
		if( indexByRetTblIdx == null ) {
			return;
		}
		CFBamServerObjFuncByRetTblIdxKey key = schema.getBackingStore().getFactoryServerObjFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );
		if( indexByRetTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( key );
			if( mapRetTblIdx != null ) {
				List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
				ICFBamServerObjFuncObj cur = null;
				Iterator<ICFBamServerObjFuncObj> iter = mapRetTblIdx.values().iterator();
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

			indexByRetTblIdx.remove( key );
		}
	}

	public ICFBamServerObjFuncObj createServerObjFunc( ICFBamServerObjFuncObj Obj ) {
		ICFBamServerObjFuncObj obj = Obj;
		CFBamServerObjFuncBuff buff = obj.getServerObjFuncBuff();
		schema.getBackingStore().getTableServerObjFunc().createServerObjFunc(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "SRVO" ) ) {
			obj = (ICFBamServerObjFuncObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamServerObjFuncObj readServerObjFunc( CFBamScopePKey pkey ) {
		return( readServerObjFunc( pkey, false ) );
	}

	public ICFBamServerObjFuncObj readServerObjFunc( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamServerObjFuncObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamServerObjFuncBuff readBuff = schema.getBackingStore().getTableServerObjFunc().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamServerObjFuncObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamServerObjFuncObj lockServerObjFunc( CFBamScopePKey pkey ) {
		ICFBamServerObjFuncObj locked = null;
		CFBamServerObjFuncBuff lockBuff = schema.getBackingStore().getTableServerObjFunc().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamServerObjFuncObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockServerObjFunc", pkey );
		}
		return( locked );
	}

	public List<ICFBamServerObjFuncObj> readAllServerObjFunc() {
		return( readAllServerObjFunc( false ) );
	}

	public List<ICFBamServerObjFuncObj> readAllServerObjFunc( boolean forceRead ) {
		final String S_ProcName = "readAllServerObjFunc";
		if( ( allServerObjFunc == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj> map = new HashMap<CFBamScopePKey,ICFBamServerObjFuncObj>();
			allServerObjFunc = map;
			CFBamServerObjFuncBuff[] buffList = schema.getBackingStore().getTableServerObjFunc().readAllDerived( schema.getAuthorization() );
			CFBamServerObjFuncBuff buff;
			ICFBamServerObjFuncObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerObjFuncObj realized = (ICFBamServerObjFuncObj)obj.realize();
			}
		}
		Comparator<ICFBamServerObjFuncObj> cmp = new Comparator<ICFBamServerObjFuncObj>() {
			public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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
		int len = allServerObjFunc.size();
		ICFBamServerObjFuncObj arr[] = new ICFBamServerObjFuncObj[len];
		Iterator<ICFBamServerObjFuncObj> valIter = allServerObjFunc.values().iterator();
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
		ArrayList<ICFBamServerObjFuncObj> arrayList = new ArrayList<ICFBamServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServerObjFuncObj readServerObjFuncByIdIdx( long TenantId,
		long Id )
	{
		return( readServerObjFuncByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamServerObjFuncObj readServerObjFuncByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamServerObjFuncObj obj = readServerObjFunc( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByTenantIdx( long TenantId )
	{
		return( readServerObjFuncByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerObjFuncObj realized = (ICFBamServerObjFuncObj)obj.realize();
			}
		}
		Comparator<ICFBamServerObjFuncObj> cmp = new Comparator<ICFBamServerObjFuncObj>() {
			public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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
		ICFBamServerObjFuncObj arr[] = new ICFBamServerObjFuncObj[len];
		Iterator<ICFBamServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerObjFuncObj> arrayList = new ArrayList<ICFBamServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServerObjFuncObj readServerObjFuncByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		return( readServerObjFuncByUNameIdx( TenantId,
			TableId,
			Name,
			false ) );
	}

	public ICFBamServerObjFuncObj readServerObjFuncByUNameIdx( long TenantId,
		long TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamServerMethodByUNameIdxKey,
				ICFBamServerObjFuncObj >();
		}
		CFBamServerMethodByUNameIdxKey key = schema.getBackingStore().getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamServerObjFuncObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamServerMethodBuff buff = schema.getBackingStore().getTableServerMethod().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			if( buff != null ) {
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamServerObjFuncObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByTableIdx( long TenantId,
		long TableId )
	{
		return( readServerObjFuncByTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByTableIdx";
		CFBamServerMethodByTableIdxKey key = schema.getBackingStore().getFactoryServerMethod().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamServerMethodByTableIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamServerMethodObj obj;
			CFBamServerMethodBuff[] buffList = schema.getBackingStore().getTableServerMethod().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamServerMethodBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerObjFuncObj realized = (ICFBamServerObjFuncObj)obj.realize();
			}
		}
		Comparator<ICFBamServerObjFuncObj> cmp = new Comparator<ICFBamServerObjFuncObj>() {
			public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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
		ICFBamServerObjFuncObj arr[] = new ICFBamServerObjFuncObj[len];
		Iterator<ICFBamServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerObjFuncObj> arrayList = new ArrayList<ICFBamServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readServerObjFuncByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByDefSchemaIdx";
		CFBamServerMethodByDefSchemaIdxKey key = schema.getBackingStore().getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamServerMethodByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamServerMethodObj obj;
			CFBamServerMethodBuff[] buffList = schema.getBackingStore().getTableServerMethod().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamServerMethodBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerObjFuncObj realized = (ICFBamServerObjFuncObj)obj.realize();
			}
		}
		Comparator<ICFBamServerObjFuncObj> cmp = new Comparator<ICFBamServerObjFuncObj>() {
			public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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
		ICFBamServerObjFuncObj arr[] = new ICFBamServerObjFuncObj[len];
		Iterator<ICFBamServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerObjFuncObj> arrayList = new ArrayList<ICFBamServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId )
	{
		return( readServerObjFuncByRetTblIdx( RetTenantId,
			RetTableId,
			false ) );
	}

	public List<ICFBamServerObjFuncObj> readServerObjFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByRetTblIdx";
		CFBamServerObjFuncByRetTblIdxKey key = schema.getBackingStore().getFactoryServerObjFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );
		Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict;
		if( indexByRetTblIdx == null ) {
			indexByRetTblIdx = new HashMap< CFBamServerObjFuncByRetTblIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByRetTblIdx.containsKey( key ) ) {
			dict = indexByRetTblIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamServerObjFuncObj>();
			// Allow other threads to dirty-read while we're loading
			indexByRetTblIdx.put( key, dict );
			ICFBamServerObjFuncObj obj;
			CFBamServerObjFuncBuff[] buffList = schema.getBackingStore().getTableServerObjFunc().readDerivedByRetTblIdx( schema.getAuthorization(),
				RetTenantId,
				RetTableId );
			CFBamServerObjFuncBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamServerObjFuncObj realized = (ICFBamServerObjFuncObj)obj.realize();
			}
		}
		Comparator<ICFBamServerObjFuncObj> cmp = new Comparator<ICFBamServerObjFuncObj>() {
			public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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
		ICFBamServerObjFuncObj arr[] = new ICFBamServerObjFuncObj[len];
		Iterator<ICFBamServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamServerObjFuncObj> arrayList = new ArrayList<ICFBamServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamServerObjFuncObj updateServerObjFunc( ICFBamServerObjFuncObj Obj ) {
		ICFBamServerObjFuncObj obj = Obj;
		schema.getBackingStore().getTableServerObjFunc().updateServerObjFunc( schema.getAuthorization(),
			Obj.getServerObjFuncBuff() );
		if( Obj.getClassCode().equals( "SRVO" ) ) {
			obj = (ICFBamServerObjFuncObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteServerObjFunc( ICFBamServerObjFuncObj Obj ) {
		ICFBamServerObjFuncObj obj = Obj;
		schema.getBackingStore().getTableServerObjFunc().deleteServerObjFunc( schema.getAuthorization(),
			obj.getServerObjFuncBuff() );
		obj.forget( true );
	}

	public void deleteServerObjFuncByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readServerObjFunc( pkey );
		if( obj != null ) {
			ICFBamServerObjFuncEditObj editObj = (ICFBamServerObjFuncEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamServerObjFuncEditObj)obj.beginEdit();
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

	public void deleteServerObjFuncByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableServerObjFunc().deleteServerObjFuncByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamServerObjFuncObj> iter = dict.values().iterator();
			ICFBamServerObjFuncObj obj;
			List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
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
			schema.getBackingStore().getTableServerObjFunc().deleteServerObjFuncByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteServerObjFuncByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamServerMethodByUNameIdxKey,
				ICFBamServerObjFuncObj >();
		}
		CFBamServerMethodByUNameIdxKey key = schema.getBackingStore().getFactoryServerMethod().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamServerObjFuncObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableServerObjFunc().deleteServerObjFuncByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableServerObjFunc().deleteServerObjFuncByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
		}
	}

	public void deleteServerObjFuncByTableIdx( long TenantId,
		long TableId )
	{
		CFBamServerMethodByTableIdxKey key = schema.getBackingStore().getFactoryServerMethod().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamServerMethodByTableIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableServerObjFunc().deleteServerObjFuncByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamServerObjFuncObj> iter = dict.values().iterator();
			ICFBamServerObjFuncObj obj;
			List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
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
			schema.getBackingStore().getTableServerObjFunc().deleteServerObjFuncByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	public void deleteServerObjFuncByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamServerMethodByDefSchemaIdxKey key = schema.getBackingStore().getFactoryServerMethod().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamServerMethodByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableServerObjFunc().deleteServerObjFuncByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamServerObjFuncObj> iter = dict.values().iterator();
			ICFBamServerObjFuncObj obj;
			List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
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
			schema.getBackingStore().getTableServerObjFunc().deleteServerObjFuncByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteServerObjFuncByRetTblIdx( Long RetTenantId,
		Long RetTableId )
	{
		CFBamServerObjFuncByRetTblIdxKey key = schema.getBackingStore().getFactoryServerObjFunc().newRetTblIdxKey();
		key.setOptionalRetTenantId( RetTenantId );
		key.setOptionalRetTableId( RetTableId );
		if( indexByRetTblIdx == null ) {
			indexByRetTblIdx = new HashMap< CFBamServerObjFuncByRetTblIdxKey,
				Map< CFBamScopePKey, ICFBamServerObjFuncObj > >();
		}
		if( indexByRetTblIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamServerObjFuncObj> dict = indexByRetTblIdx.get( key );
			schema.getBackingStore().getTableServerObjFunc().deleteServerObjFuncByRetTblIdx( schema.getAuthorization(),
				RetTenantId,
				RetTableId );
			Iterator<ICFBamServerObjFuncObj> iter = dict.values().iterator();
			ICFBamServerObjFuncObj obj;
			List<ICFBamServerObjFuncObj> toForget = new LinkedList<ICFBamServerObjFuncObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRetTblIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableServerObjFunc().deleteServerObjFuncByRetTblIdx( schema.getAuthorization(),
				RetTenantId,
				RetTableId );
		}
	}
}
