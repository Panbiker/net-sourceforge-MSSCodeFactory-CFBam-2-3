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

public class CFBamChainTableObj
	implements ICFBamChainTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamChainPKey, ICFBamChainObj> members;
	private Map<CFBamChainPKey, ICFBamChainObj> allChain;
	private Map< CFBamChainByTenantIdxKey,
		Map<CFBamChainPKey, ICFBamChainObj > > indexByTenantIdx;
	private Map< CFBamChainByTableIdxKey,
		Map<CFBamChainPKey, ICFBamChainObj > > indexByTableIdx;
	private Map< CFBamChainByDefSchemaIdxKey,
		Map<CFBamChainPKey, ICFBamChainObj > > indexByDefSchemaIdx;
	private Map< CFBamChainByUNameIdxKey,
		ICFBamChainObj > indexByUNameIdx;
	private Map< CFBamChainByPrevRelIdxKey,
		Map<CFBamChainPKey, ICFBamChainObj > > indexByPrevRelIdx;
	private Map< CFBamChainByNextRelIdxKey,
		Map<CFBamChainPKey, ICFBamChainObj > > indexByNextRelIdx;
	public static String TABLE_NAME = "Chain";
	public static String TABLE_DBNAME = "chain_def";

	public CFBamChainTableObj() {
		schema = null;
		members = new HashMap<CFBamChainPKey, ICFBamChainObj>();
		allChain = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexByPrevRelIdx = null;
		indexByNextRelIdx = null;
	}

	public CFBamChainTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamChainPKey, ICFBamChainObj>();
		allChain = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexByPrevRelIdx = null;
		indexByNextRelIdx = null;
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
		allChain = null;
		indexByTenantIdx = null;
		indexByTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexByPrevRelIdx = null;
		indexByNextRelIdx = null;
		List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
		ICFBamChainObj cur = null;
		Iterator<ICFBamChainObj> iter = members.values().iterator();
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
	 *	CFBamChainObj.
	 */
	public ICFBamChainObj newInstance() {
		ICFBamChainObj inst = new CFBamChainObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamChainObj.
	 */
	public ICFBamChainEditObj newEditInstance( ICFBamChainObj orig ) {
		ICFBamChainEditObj edit = new CFBamChainEditObj( orig );
		return( edit );
	}

	public ICFBamChainObj realizeChain( ICFBamChainObj Obj ) {
		ICFBamChainObj obj = Obj;
		CFBamChainPKey pkey = obj.getPKey();
		ICFBamChainObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamChainObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamChainByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryChain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamChainByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryChain().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamChainByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryChain().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamChainByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryChain().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevRelIdx != null ) {
				CFBamChainByPrevRelIdxKey keyPrevRelIdx =
					schema.getBackingStore().getFactoryChain().newPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationTenantId( keepObj.getRequiredPrevRelationTenantId() );
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNextRelIdx != null ) {
				CFBamChainByNextRelIdxKey keyNextRelIdx =
					schema.getBackingStore().getFactoryChain().newNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationTenantId( keepObj.getRequiredNextRelationTenantId() );
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamChainByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryChain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamChainByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryChain().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamChainByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryChain().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamChainByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryChain().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevRelIdx != null ) {
				CFBamChainByPrevRelIdxKey keyPrevRelIdx =
					schema.getBackingStore().getFactoryChain().newPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationTenantId( keepObj.getRequiredPrevRelationTenantId() );
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextRelIdx != null ) {
				CFBamChainByNextRelIdxKey keyNextRelIdx =
					schema.getBackingStore().getFactoryChain().newNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationTenantId( keepObj.getRequiredNextRelationTenantId() );
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allChain != null ) {
				allChain.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allChain != null ) {
				allChain.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamChainByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryChain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamChainByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryChain().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamChainByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryChain().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamChainByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryChain().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevRelIdx != null ) {
				CFBamChainByPrevRelIdxKey keyPrevRelIdx =
					schema.getBackingStore().getFactoryChain().newPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationTenantId( keepObj.getRequiredPrevRelationTenantId() );
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextRelIdx != null ) {
				CFBamChainByNextRelIdxKey keyNextRelIdx =
					schema.getBackingStore().getFactoryChain().newNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationTenantId( keepObj.getRequiredNextRelationTenantId() );
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetChain( ICFBamChainObj Obj ) {
		forgetChain( Obj, false );
	}

	public void forgetChain( ICFBamChainObj Obj, boolean forgetSubObjects ) {
		ICFBamChainObj obj = Obj;
		CFBamChainPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamChainObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamChainByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryChain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByTableIdx != null ) {
				CFBamChainByTableIdxKey keyTableIdx =
					schema.getBackingStore().getFactoryChain().newTableIdxKey();
				keyTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamChainByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBackingStore().getFactoryChain().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamChainByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryChain().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevRelIdx != null ) {
				CFBamChainByPrevRelIdxKey keyPrevRelIdx =
					schema.getBackingStore().getFactoryChain().newPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationTenantId( keepObj.getRequiredPrevRelationTenantId() );
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNextRelIdx != null ) {
				CFBamChainByNextRelIdxKey keyNextRelIdx =
					schema.getBackingStore().getFactoryChain().newNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationTenantId( keepObj.getRequiredNextRelationTenantId() );
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.remove( keepObj.getPKey() );
				}
			}

			if( allChain != null ) {
				allChain.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetChainByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamChainPKey key = schema.getBackingStore().getFactoryChain().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamChainObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetChainByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamChainByTenantIdxKey key = schema.getBackingStore().getFactoryChain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
				ICFBamChainObj cur = null;
				Iterator<ICFBamChainObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetChainByTableIdx( long TenantId,
		long TableId )
	{
		if( indexByTableIdx == null ) {
			return;
		}
		CFBamChainByTableIdxKey key = schema.getBackingStore().getFactoryChain().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj > mapTableIdx = indexByTableIdx.get( key );
			if( mapTableIdx != null ) {
				List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
				ICFBamChainObj cur = null;
				Iterator<ICFBamChainObj> iter = mapTableIdx.values().iterator();
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

	public void forgetChainByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		CFBamChainByDefSchemaIdxKey key = schema.getBackingStore().getFactoryChain().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
				ICFBamChainObj cur = null;
				Iterator<ICFBamChainObj> iter = mapDefSchemaIdx.values().iterator();
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

	public void forgetChainByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamChainByUNameIdxKey key = schema.getBackingStore().getFactoryChain().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamChainObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetChainByPrevRelIdx( long PrevRelationTenantId,
		long PrevRelationId )
	{
		if( indexByPrevRelIdx == null ) {
			return;
		}
		CFBamChainByPrevRelIdxKey key = schema.getBackingStore().getFactoryChain().newPrevRelIdxKey();
		key.setRequiredPrevRelationTenantId( PrevRelationTenantId );
		key.setRequiredPrevRelationId( PrevRelationId );
		if( indexByPrevRelIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( key );
			if( mapPrevRelIdx != null ) {
				List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
				ICFBamChainObj cur = null;
				Iterator<ICFBamChainObj> iter = mapPrevRelIdx.values().iterator();
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

			indexByPrevRelIdx.remove( key );
		}
	}

	public void forgetChainByNextRelIdx( long NextRelationTenantId,
		long NextRelationId )
	{
		if( indexByNextRelIdx == null ) {
			return;
		}
		CFBamChainByNextRelIdxKey key = schema.getBackingStore().getFactoryChain().newNextRelIdxKey();
		key.setRequiredNextRelationTenantId( NextRelationTenantId );
		key.setRequiredNextRelationId( NextRelationId );
		if( indexByNextRelIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj > mapNextRelIdx = indexByNextRelIdx.get( key );
			if( mapNextRelIdx != null ) {
				List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
				ICFBamChainObj cur = null;
				Iterator<ICFBamChainObj> iter = mapNextRelIdx.values().iterator();
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

			indexByNextRelIdx.remove( key );
		}
	}

	public ICFBamChainObj createChain( ICFBamChainObj Obj ) {
		ICFBamChainObj obj = Obj;
		CFBamChainBuff buff = obj.getChainBuff();
		schema.getBackingStore().getTableChain().createChain(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamChainObj readChain( CFBamChainPKey pkey ) {
		return( readChain( pkey, false ) );
	}

	public ICFBamChainObj readChain( CFBamChainPKey pkey, boolean forceRead ) {
		ICFBamChainObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamChainBuff readBuff = schema.getBackingStore().getTableChain().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryChain().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamChainObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamChainObj lockChain( CFBamChainPKey pkey ) {
		ICFBamChainObj locked = null;
		CFBamChainBuff lockBuff = schema.getBackingStore().getTableChain().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getChainTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryChain().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamChainObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockChain", pkey );
		}
		return( locked );
	}

	public List<ICFBamChainObj> readAllChain() {
		return( readAllChain( false ) );
	}

	public List<ICFBamChainObj> readAllChain( boolean forceRead ) {
		final String S_ProcName = "readAllChain";
		if( ( allChain == null ) || forceRead ) {
			Map<CFBamChainPKey, ICFBamChainObj> map = new HashMap<CFBamChainPKey,ICFBamChainObj>();
			allChain = map;
			CFBamChainBuff[] buffList = schema.getBackingStore().getTableChain().readAllDerived( schema.getAuthorization() );
			CFBamChainBuff buff;
			ICFBamChainObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realized = (ICFBamChainObj)obj.realize();
			}
		}
		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allChain.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = allChain.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamChainObj readChainByIdIdx( long TenantId,
		long Id )
	{
		return( readChainByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamChainObj readChainByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamChainPKey pkey = schema.getBackingStore().getFactoryChain().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamChainObj obj = readChain( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamChainObj> readChainByTenantIdx( long TenantId )
	{
		return( readChainByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamChainObj> readChainByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByTenantIdx";
		CFBamChainByTenantIdxKey key = schema.getBackingStore().getFactoryChain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamChainPKey, ICFBamChainObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamChainByTenantIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamChainPKey, ICFBamChainObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamChainObj obj;
			CFBamChainBuff[] buffList = schema.getBackingStore().getTableChain().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamChainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realized = (ICFBamChainObj)obj.realize();
			}
		}
		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamChainObj> readChainByTableIdx( long TenantId,
		long TableId )
	{
		return( readChainByTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamChainObj> readChainByTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByTableIdx";
		CFBamChainByTableIdxKey key = schema.getBackingStore().getFactoryChain().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamChainPKey, ICFBamChainObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamChainByTableIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamChainPKey, ICFBamChainObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTableIdx.put( key, dict );
			ICFBamChainObj obj;
			CFBamChainBuff[] buffList = schema.getBackingStore().getTableChain().readDerivedByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamChainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realized = (ICFBamChainObj)obj.realize();
			}
		}
		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamChainObj> readChainByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readChainByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamChainObj> readChainByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByDefSchemaIdx";
		CFBamChainByDefSchemaIdxKey key = schema.getBackingStore().getFactoryChain().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamChainPKey, ICFBamChainObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamChainByDefSchemaIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamChainPKey, ICFBamChainObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDefSchemaIdx.put( key, dict );
			ICFBamChainObj obj;
			CFBamChainBuff[] buffList = schema.getBackingStore().getTableChain().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamChainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realized = (ICFBamChainObj)obj.realize();
			}
		}
		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamChainObj readChainByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		return( readChainByUNameIdx( TenantId,
			TableId,
			Name,
			false ) );
	}

	public ICFBamChainObj readChainByUNameIdx( long TenantId,
		long TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamChainByUNameIdxKey,
				ICFBamChainObj >();
		}
		CFBamChainByUNameIdxKey key = schema.getBackingStore().getFactoryChain().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamChainObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamChainBuff buff = schema.getBackingStore().getTableChain().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			if( buff != null ) {
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryChain().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamChainObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamChainObj> readChainByPrevRelIdx( long PrevRelationTenantId,
		long PrevRelationId )
	{
		return( readChainByPrevRelIdx( PrevRelationTenantId,
			PrevRelationId,
			false ) );
	}

	public List<ICFBamChainObj> readChainByPrevRelIdx( long PrevRelationTenantId,
		long PrevRelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByPrevRelIdx";
		CFBamChainByPrevRelIdxKey key = schema.getBackingStore().getFactoryChain().newPrevRelIdxKey();
		key.setRequiredPrevRelationTenantId( PrevRelationTenantId );
		key.setRequiredPrevRelationId( PrevRelationId );
		Map<CFBamChainPKey, ICFBamChainObj> dict;
		if( indexByPrevRelIdx == null ) {
			indexByPrevRelIdx = new HashMap< CFBamChainByPrevRelIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( ( ! forceRead ) && indexByPrevRelIdx.containsKey( key ) ) {
			dict = indexByPrevRelIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamChainPKey, ICFBamChainObj>();
			// Allow other threads to dirty-read while we're loading
			indexByPrevRelIdx.put( key, dict );
			ICFBamChainObj obj;
			CFBamChainBuff[] buffList = schema.getBackingStore().getTableChain().readDerivedByPrevRelIdx( schema.getAuthorization(),
				PrevRelationTenantId,
				PrevRelationId );
			CFBamChainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realized = (ICFBamChainObj)obj.realize();
			}
		}
		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamChainObj> readChainByNextRelIdx( long NextRelationTenantId,
		long NextRelationId )
	{
		return( readChainByNextRelIdx( NextRelationTenantId,
			NextRelationId,
			false ) );
	}

	public List<ICFBamChainObj> readChainByNextRelIdx( long NextRelationTenantId,
		long NextRelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByNextRelIdx";
		CFBamChainByNextRelIdxKey key = schema.getBackingStore().getFactoryChain().newNextRelIdxKey();
		key.setRequiredNextRelationTenantId( NextRelationTenantId );
		key.setRequiredNextRelationId( NextRelationId );
		Map<CFBamChainPKey, ICFBamChainObj> dict;
		if( indexByNextRelIdx == null ) {
			indexByNextRelIdx = new HashMap< CFBamChainByNextRelIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( ( ! forceRead ) && indexByNextRelIdx.containsKey( key ) ) {
			dict = indexByNextRelIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamChainPKey, ICFBamChainObj>();
			// Allow other threads to dirty-read while we're loading
			indexByNextRelIdx.put( key, dict );
			ICFBamChainObj obj;
			CFBamChainBuff[] buffList = schema.getBackingStore().getTableChain().readDerivedByNextRelIdx( schema.getAuthorization(),
				NextRelationTenantId,
				NextRelationId );
			CFBamChainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realized = (ICFBamChainObj)obj.realize();
			}
		}
		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamChainObj updateChain( ICFBamChainObj Obj ) {
		ICFBamChainObj obj = Obj;
		schema.getBackingStore().getTableChain().updateChain( schema.getAuthorization(),
			Obj.getChainBuff() );
		obj = (ICFBamChainObj)Obj.realize();
		return( obj );
	}

	public void deleteChain( ICFBamChainObj Obj ) {
		ICFBamChainObj obj = Obj;
		schema.getBackingStore().getTableChain().deleteChain( schema.getAuthorization(),
			obj.getChainBuff() );
		obj.forget( true );
	}

	public void deleteChainByIdIdx( long TenantId,
		long Id )
	{
		CFBamChainPKey pkey = schema.getBackingStore().getFactoryChain().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamChainObj obj = readChain( pkey );
		if( obj != null ) {
			ICFBamChainEditObj editObj = (ICFBamChainEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamChainEditObj)obj.beginEdit();
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

	public void deleteChainByTenantIdx( long TenantId )
	{
		CFBamChainByTenantIdxKey key = schema.getBackingStore().getFactoryChain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamChainByTenantIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableChain().deleteChainByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamChainObj> iter = dict.values().iterator();
			ICFBamChainObj obj;
			List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
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
			schema.getBackingStore().getTableChain().deleteChainByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteChainByTableIdx( long TenantId,
		long TableId )
	{
		CFBamChainByTableIdxKey key = schema.getBackingStore().getFactoryChain().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< CFBamChainByTableIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj> dict = indexByTableIdx.get( key );
			schema.getBackingStore().getTableChain().deleteChainByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamChainObj> iter = dict.values().iterator();
			ICFBamChainObj obj;
			List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
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
			schema.getBackingStore().getTableChain().deleteChainByTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	public void deleteChainByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamChainByDefSchemaIdxKey key = schema.getBackingStore().getFactoryChain().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamChainByDefSchemaIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBackingStore().getTableChain().deleteChainByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamChainObj> iter = dict.values().iterator();
			ICFBamChainObj obj;
			List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
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
			schema.getBackingStore().getTableChain().deleteChainByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteChainByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamChainByUNameIdxKey,
				ICFBamChainObj >();
		}
		CFBamChainByUNameIdxKey key = schema.getBackingStore().getFactoryChain().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamChainObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableChain().deleteChainByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableChain().deleteChainByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
		}
	}

	public void deleteChainByPrevRelIdx( long PrevRelationTenantId,
		long PrevRelationId )
	{
		CFBamChainByPrevRelIdxKey key = schema.getBackingStore().getFactoryChain().newPrevRelIdxKey();
		key.setRequiredPrevRelationTenantId( PrevRelationTenantId );
		key.setRequiredPrevRelationId( PrevRelationId );
		if( indexByPrevRelIdx == null ) {
			indexByPrevRelIdx = new HashMap< CFBamChainByPrevRelIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( indexByPrevRelIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj> dict = indexByPrevRelIdx.get( key );
			schema.getBackingStore().getTableChain().deleteChainByPrevRelIdx( schema.getAuthorization(),
				PrevRelationTenantId,
				PrevRelationId );
			Iterator<ICFBamChainObj> iter = dict.values().iterator();
			ICFBamChainObj obj;
			List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPrevRelIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableChain().deleteChainByPrevRelIdx( schema.getAuthorization(),
				PrevRelationTenantId,
				PrevRelationId );
		}
	}

	public void deleteChainByNextRelIdx( long NextRelationTenantId,
		long NextRelationId )
	{
		CFBamChainByNextRelIdxKey key = schema.getBackingStore().getFactoryChain().newNextRelIdxKey();
		key.setRequiredNextRelationTenantId( NextRelationTenantId );
		key.setRequiredNextRelationId( NextRelationId );
		if( indexByNextRelIdx == null ) {
			indexByNextRelIdx = new HashMap< CFBamChainByNextRelIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( indexByNextRelIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj> dict = indexByNextRelIdx.get( key );
			schema.getBackingStore().getTableChain().deleteChainByNextRelIdx( schema.getAuthorization(),
				NextRelationTenantId,
				NextRelationId );
			Iterator<ICFBamChainObj> iter = dict.values().iterator();
			ICFBamChainObj obj;
			List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByNextRelIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableChain().deleteChainByNextRelIdx( schema.getAuthorization(),
				NextRelationTenantId,
				NextRelationId );
		}
	}
}
