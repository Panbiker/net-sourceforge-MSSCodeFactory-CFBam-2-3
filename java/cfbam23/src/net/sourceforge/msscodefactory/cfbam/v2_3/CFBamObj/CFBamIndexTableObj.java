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

public class CFBamIndexTableObj
	implements ICFBamIndexTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamIndexObj> members;
	private Map<CFBamScopePKey, ICFBamIndexObj> allIndex;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamIndexObj > > indexByTenantIdx;
	private Map< CFBamIndexByUNameIdxKey,
		ICFBamIndexObj > indexByUNameIdx;
	private Map< CFBamIndexByIndexTenantIdxKey,
		Map<CFBamScopePKey, ICFBamIndexObj > > indexByIndexTenantIdx;
	private Map< CFBamIndexByTableIdxKey,
		Map<CFBamScopePKey, ICFBamIndexObj > > indexByTableIdx;
	private Map< CFBamIndexByDefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamIndexObj > > indexByDefSchemaIdx;
	public static String TABLE_NAME = "Index";
	public static String TABLE_DBNAME = "idxdef";

	public CFBamIndexTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamIndexObj>();
		allIndex = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByIndexTenantIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
	}

	public CFBamIndexTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamIndexObj>();
		allIndex = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByIndexTenantIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
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
		allIndex = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByIndexTenantIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamIndexObj.
	 */
	public ICFBamIndexObj newInstance() {
		ICFBamIndexObj inst = new CFBamIndexObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamIndexObj.
	 */
	public ICFBamIndexEditObj newEditInstance( ICFBamIndexObj orig ) {
		ICFBamIndexEditObj edit = new CFBamIndexEditObj( orig );
		return( edit );
	}

	public ICFBamIndexObj realizeIndex( ICFBamIndexObj Obj ) {
		ICFBamIndexObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamIndexObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamIndexObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamIndexObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamIndexByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryIndex().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIndexTenantIdx != null ) {
				CFBamIndexByIndexTenantIdxKey keyIndexTenantIdx =
					schema.getBackingStore().getFactoryIndex().newIndexTenantIdxKey();
				keyIndexTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapIndexTenantIdx = indexByIndexTenantIdx.get( keyIndexTenantIdx );
				if( mapIndexTenantIdx != null ) {
					mapIndexTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamIndexByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryIndex().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamIndexByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryIndex().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamIndexObj)schema.getScopeTableObj().realizeScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamIndexByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryIndex().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIndexTenantIdx != null ) {
				CFBamIndexByIndexTenantIdxKey keyIndexTenantIdx =
					schema.getBackingStore().getFactoryIndex().newIndexTenantIdxKey();
				keyIndexTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapIndexTenantIdx = indexByIndexTenantIdx.get( keyIndexTenantIdx );
				if( mapIndexTenantIdx != null ) {
					mapIndexTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamIndexByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryIndex().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamIndexByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryIndex().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allIndex != null ) {
				allIndex.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamIndexObj)schema.getScopeTableObj().realizeScope( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allIndex != null ) {
				allIndex.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamIndexByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryIndex().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIndexTenantIdx != null ) {
				CFBamIndexByIndexTenantIdxKey keyIndexTenantIdx =
					schema.getBackingStore().getFactoryIndex().newIndexTenantIdxKey();
				keyIndexTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapIndexTenantIdx = indexByIndexTenantIdx.get( keyIndexTenantIdx );
				if( mapIndexTenantIdx != null ) {
					mapIndexTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamIndexByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryIndex().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamIndexByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryIndex().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetIndex( ICFBamIndexObj Obj ) {
		forgetIndex( Obj, false );
	}

	public void forgetIndex( ICFBamIndexObj Obj, boolean forgetSubObjects ) {
		ICFBamIndexObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamIndexObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamIndexByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryIndex().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIndexTenantIdx != null ) {
				CFBamIndexByIndexTenantIdxKey keyIndexTenantIdx =
					schema.getBackingStore().getFactoryIndex().newIndexTenantIdxKey();
				keyIndexTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapIndexTenantIdx = indexByIndexTenantIdx.get( keyIndexTenantIdx );
				if( mapIndexTenantIdx != null ) {
					mapIndexTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamIndexByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryIndex().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamIndexByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryIndex().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamScopePKey, ICFBamIndexObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( allIndex != null ) {
				allIndex.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getIndexColTableObj().forgetIndexColByIndexIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getScopeTableObj().forgetScope( obj );
	}

	public void forgetIndexByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamIndexObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetIndexByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamIndexObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamIndexObj> toForget = new LinkedList<ICFBamIndexObj>();
				ICFBamIndexObj cur = null;
				Iterator<ICFBamIndexObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetIndexByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamIndexByUNameIdxKey key = schema.getBackingStore().getFactoryIndex().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamIndexObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetIndexByIndexTenantIdx( long TenantId )
	{
		if( indexByIndexTenantIdx == null ) {
			return;
		}
		CFBamIndexByIndexTenantIdxKey key = schema.getBackingStore().getFactoryIndex().newIndexTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByIndexTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamIndexObj > mapIndexTenantIdx = indexByIndexTenantIdx.get( key );
			if( mapIndexTenantIdx != null ) {
				List<ICFBamIndexObj> toForget = new LinkedList<ICFBamIndexObj>();
				ICFBamIndexObj cur = null;
				Iterator<ICFBamIndexObj> iter = mapIndexTenantIdx.values().iterator();
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

			indexByIndexTenantIdx.remove( key );
		}
	}

	public void forgetIndexByTableIdx( long TenantId,
		long TableId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamIndexByTableIdxKey key = schema.getBackingStore().getFactoryIndex().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamIndexObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamIndexObj> toForget = new LinkedList<ICFBamIndexObj>();
				ICFBamIndexObj cur = null;
				Iterator<ICFBamIndexObj> iter = mapTableIdx.values().iterator();
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

	public void forgetIndexByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamIndexByDefSchemaIdxKey key = schema.getBackingStore().getFactoryIndex().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamIndexObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamIndexObj> toForget = new LinkedList<ICFBamIndexObj>();
				ICFBamIndexObj cur = null;
				Iterator<ICFBamIndexObj> iter = mapDefSchemaIdx.values().iterator();
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

	public ICFBamIndexObj createIndex( ICFBamIndexObj Obj ) {
		ICFBamIndexObj obj = Obj;
		CFBamIndexBuff buff = obj.getIndexBuff();
		schema.getBackingStore().getTableIndex().createIndex(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "IDXD" ) ) {
			obj = (ICFBamIndexObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamIndexObj readIndex( CFBamScopePKey pkey ) {
		return( readIndex( pkey, false ) );
	}

	public ICFBamIndexObj readIndex( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamIndexObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamIndexBuff readBuff = schema.getBackingStore().getTableIndex().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamIndexObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamIndexObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamIndexObj lockIndex( CFBamScopePKey pkey ) {
		ICFBamIndexObj locked = null;
		CFBamIndexBuff lockBuff = schema.getBackingStore().getTableIndex().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamIndexObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamIndexObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockIndex", pkey );
		}
		return( locked );
	}

	public List<ICFBamIndexObj> readAllIndex() {
		return( readAllIndex( false ) );
	}

	public List<ICFBamIndexObj> readAllIndex( boolean forceRead ) {
		final String S_ProcName = "readAllIndex";
		if( ( allIndex == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamIndexObj> map = new HashMap<CFBamScopePKey,ICFBamIndexObj>();
			allIndex = map;
			CFBamIndexBuff[] buffList = schema.getBackingStore().getTableIndex().readAllDerived( schema.getAuthorization() );
			CFBamIndexBuff buff;
			ICFBamIndexObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamIndexObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexObj realized = (ICFBamIndexObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexObj> cmp = new Comparator<ICFBamIndexObj>() {
			public int compare( ICFBamIndexObj lhs, ICFBamIndexObj rhs ) {
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
		int len = allIndex.size();
		ICFBamIndexObj arr[] = new ICFBamIndexObj[len];
		Iterator<ICFBamIndexObj> valIter = allIndex.values().iterator();
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
		ArrayList<ICFBamIndexObj> arrayList = new ArrayList<ICFBamIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamIndexObj readIndexByIdIdx( long TenantId,
		long Id )
	{
		return( readIndexByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamIndexObj readIndexByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamIndexObj obj = readIndex( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamIndexObj> readIndexByTenantIdx( long TenantId )
	{
		return( readIndexByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamIndexObj> readIndexByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamIndexObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamIndexObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamIndexObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamIndexObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexObj realized = (ICFBamIndexObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexObj> cmp = new Comparator<ICFBamIndexObj>() {
			public int compare( ICFBamIndexObj lhs, ICFBamIndexObj rhs ) {
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
		ICFBamIndexObj arr[] = new ICFBamIndexObj[len];
		Iterator<ICFBamIndexObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexObj> arrayList = new ArrayList<ICFBamIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamIndexObj readIndexByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		return( readIndexByUNameIdx( TenantId,
			TableId,
			Name,
			false ) );
	}

	public ICFBamIndexObj readIndexByUNameIdx( long TenantId,
		long TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamIndexByUNameIdxKey,
				ICFBamIndexObj >();
		}
		CFBamIndexByUNameIdxKey key = schema.getBackingStore().getFactoryIndex().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamIndexObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamIndexBuff buff = schema.getBackingStore().getTableIndex().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			if( buff != null ) {
				obj = (ICFBamIndexObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamIndexObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamIndexObj> readIndexByIndexTenantIdx( long TenantId )
	{
		return( readIndexByIndexTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamIndexObj> readIndexByIndexTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexByIndexTenantIdx";
		CFBamIndexByIndexTenantIdxKey key = schema.getBackingStore().getFactoryIndex().newIndexTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamIndexObj> dict;
		if( indexByIndexTenantIdx == null ) {
			indexByIndexTenantIdx = new HashMap< CFBamIndexByIndexTenantIdxKey,
				Map< CFBamScopePKey, ICFBamIndexObj > >();
		}
		if( ( ! forceRead ) && indexByIndexTenantIdx.containsKey( key ) ) {
			dict = indexByIndexTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamIndexObj>();
			// Allow other threads to dirty-read while we're loading
			indexByIndexTenantIdx.put( key, dict );
			ICFBamIndexObj obj;
			CFBamIndexBuff[] buffList = schema.getBackingStore().getTableIndex().readDerivedByIndexTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamIndexBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamIndexObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexObj realized = (ICFBamIndexObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexObj> cmp = new Comparator<ICFBamIndexObj>() {
			public int compare( ICFBamIndexObj lhs, ICFBamIndexObj rhs ) {
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
		ICFBamIndexObj arr[] = new ICFBamIndexObj[len];
		Iterator<ICFBamIndexObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexObj> arrayList = new ArrayList<ICFBamIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamIndexObj> readIndexByTableIdx( long TenantId,
		long TableId )
	{
		return( readIndexByTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamIndexObj> readIndexByTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexByTableIdx";
		CFBamIndexByTableIdxKey key = schema.getBackingStore().getFactoryIndex().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamScopePKey, ICFBamIndexObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamIndexByTableIdxKey,
				Map< CFBamScopePKey, ICFBamIndexObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamIndexObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamIndexObj obj;
			CFBamIndexBuff[] buffList = schema.getBackingStore().getTableIndex().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamIndexBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamIndexObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexObj realized = (ICFBamIndexObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexObj> cmp = new Comparator<ICFBamIndexObj>() {
			public int compare( ICFBamIndexObj lhs, ICFBamIndexObj rhs ) {
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
		ICFBamIndexObj arr[] = new ICFBamIndexObj[len];
		Iterator<ICFBamIndexObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexObj> arrayList = new ArrayList<ICFBamIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamIndexObj> readIndexByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readIndexByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamIndexObj> readIndexByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexByDefSchemaIdx";
		CFBamIndexByDefSchemaIdxKey key = schema.getBackingStore().getFactoryIndex().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamScopePKey, ICFBamIndexObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamIndexByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamIndexObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamIndexObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamIndexObj obj;
			CFBamIndexBuff[] buffList = schema.getBackingStore().getTableIndex().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamIndexBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamIndexObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamIndexObj realized = (ICFBamIndexObj)obj.realize();
			}
		}
		Comparator<ICFBamIndexObj> cmp = new Comparator<ICFBamIndexObj>() {
			public int compare( ICFBamIndexObj lhs, ICFBamIndexObj rhs ) {
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
		ICFBamIndexObj arr[] = new ICFBamIndexObj[len];
		Iterator<ICFBamIndexObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamIndexObj> arrayList = new ArrayList<ICFBamIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamIndexObj updateIndex( ICFBamIndexObj Obj ) {
		ICFBamIndexObj obj = Obj;
		schema.getBackingStore().getTableIndex().updateIndex( schema.getAuthorization(),
			Obj.getIndexBuff() );
		if( Obj.getClassCode().equals( "IDXD" ) ) {
			obj = (ICFBamIndexObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteIndex( ICFBamIndexObj Obj ) {
		ICFBamIndexObj obj = Obj;
		schema.getBackingStore().getTableIndex().deleteIndex( schema.getAuthorization(),
			obj.getIndexBuff() );
		obj.forget( true );
	}

	public void deleteIndexByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readIndex( pkey );
		if( obj != null ) {
			ICFBamIndexEditObj editObj = (ICFBamIndexEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamIndexEditObj)obj.beginEdit();
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

	public void deleteIndexByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamIndexObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamIndexObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableIndex().deleteIndexByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamIndexObj> iter = dict.values().iterator();
			ICFBamIndexObj obj;
			List<ICFBamIndexObj> toForget = new LinkedList<ICFBamIndexObj>();
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
			schema.getBackingStore().getTableIndex().deleteIndexByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteIndexByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamIndexByUNameIdxKey,
				ICFBamIndexObj >();
		}
		CFBamIndexByUNameIdxKey key = schema.getBackingStore().getFactoryIndex().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamIndexObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableIndex().deleteIndexByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableIndex().deleteIndexByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
		}
	}

	public void deleteIndexByIndexTenantIdx( long TenantId )
	{
		CFBamIndexByIndexTenantIdxKey key = schema.getBackingStore().getFactoryIndex().newIndexTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByIndexTenantIdx == null ) {
			indexByIndexTenantIdx = new HashMap< CFBamIndexByIndexTenantIdxKey,
				Map< CFBamScopePKey, ICFBamIndexObj > >();
		}
		if( indexByIndexTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamIndexObj> dict = indexByIndexTenantIdx.get( key );
			schema.getBackingStore().getTableIndex().deleteIndexByIndexTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamIndexObj> iter = dict.values().iterator();
			ICFBamIndexObj obj;
			List<ICFBamIndexObj> toForget = new LinkedList<ICFBamIndexObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIndexTenantIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableIndex().deleteIndexByIndexTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteIndexByTableIdx( long TenantId,
		long TableId )
	{
		CFBamIndexByTableIdxKey key = schema.getBackingStore().getFactoryIndex().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamIndexByTableIdxKey,
				Map< CFBamScopePKey, ICFBamIndexObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamIndexObj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableIndex().deleteIndexByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamIndexObj> iter = dict.values().iterator();
			ICFBamIndexObj obj;
			List<ICFBamIndexObj> toForget = new LinkedList<ICFBamIndexObj>();
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
			schema.getBackingStore().getTableIndex().deleteIndexByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	public void deleteIndexByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamIndexByDefSchemaIdxKey key = schema.getBackingStore().getFactoryIndex().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamIndexByDefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamIndexObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamIndexObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableIndex().deleteIndexByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamIndexObj> iter = dict.values().iterator();
			ICFBamIndexObj obj;
			List<ICFBamIndexObj> toForget = new LinkedList<ICFBamIndexObj>();
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
			schema.getBackingStore().getTableIndex().deleteIndexByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}
}
