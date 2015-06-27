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

public class CFBamSchemaRefTableObj
	implements ICFBamSchemaRefTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamSchemaRefObj> members;
	private Map<CFBamScopePKey, ICFBamSchemaRefObj> allSchemaRef;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaRefObj > > indexByTenantIdx;
	private Map< CFBamSchemaRefBySchemaIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaRefObj > > indexBySchemaIdx;
	private Map< CFBamSchemaRefByUNameIdxKey,
		ICFBamSchemaRefObj > indexByUNameIdx;
	private Map< CFBamSchemaRefByRefSchemaIdxKey,
		Map<CFBamScopePKey, ICFBamSchemaRefObj > > indexByRefSchemaIdx;
	public static String TABLE_NAME = "SchemaRef";
	public static String TABLE_DBNAME = "schema_ref";

	public CFBamSchemaRefTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
		allSchemaRef = null;
		indexByTenantIdx = null;
		indexBySchemaIdx = null;
		indexByUNameIdx = null;
		indexByRefSchemaIdx = null;
	}

	public CFBamSchemaRefTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
		allSchemaRef = null;
		indexByTenantIdx = null;
		indexBySchemaIdx = null;
		indexByUNameIdx = null;
		indexByRefSchemaIdx = null;
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
		allSchemaRef = null;
		indexByTenantIdx = null;
		indexBySchemaIdx = null;
		indexByUNameIdx = null;
		indexByRefSchemaIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSchemaRefObj.
	 */
	public ICFBamSchemaRefObj newInstance() {
		ICFBamSchemaRefObj inst = new CFBamSchemaRefObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSchemaRefObj.
	 */
	public ICFBamSchemaRefEditObj newEditInstance( ICFBamSchemaRefObj orig ) {
		ICFBamSchemaRefEditObj edit = new CFBamSchemaRefEditObj( orig );
		return( edit );
	}

	public ICFBamSchemaRefObj realizeSchemaRef( ICFBamSchemaRefObj Obj ) {
		ICFBamSchemaRefObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamSchemaRefObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSchemaRefObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamSchemaRefBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactorySchemaRef().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaRefByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySchemaRef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRefSchemaIdx != null ) {
				CFBamSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					schema.getBackingStore().getFactorySchemaRef().newRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaTenantId( keepObj.getOptionalRefSchemaTenantId() );
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.remove( keepObj.getPKey() );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamSchemaRefObj)schema.getScopeTableObj().realizeScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamSchemaRefBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactorySchemaRef().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaRefByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySchemaRef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRefSchemaIdx != null ) {
				CFBamSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					schema.getBackingStore().getFactorySchemaRef().newRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaTenantId( keepObj.getOptionalRefSchemaTenantId() );
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allSchemaRef != null ) {
				allSchemaRef.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamSchemaRefObj)schema.getScopeTableObj().realizeScope( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSchemaRef != null ) {
				allSchemaRef.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamSchemaRefBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactorySchemaRef().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaRefByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySchemaRef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRefSchemaIdx != null ) {
				CFBamSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					schema.getBackingStore().getFactorySchemaRef().newRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaTenantId( keepObj.getOptionalRefSchemaTenantId() );
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetSchemaRef( ICFBamSchemaRefObj Obj ) {
		forgetSchemaRef( Obj, false );
	}

	public void forgetSchemaRef( ICFBamSchemaRefObj Obj, boolean forgetSubObjects ) {
		ICFBamSchemaRefObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSchemaRefObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				CFBamSchemaRefBySchemaIdxKey keySchemaIdx =
					schema.getBackingStore().getFactorySchemaRef().newSchemaIdxKey();
				keySchemaIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamSchemaRefByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactorySchemaRef().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRefSchemaIdx != null ) {
				CFBamSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					schema.getBackingStore().getFactorySchemaRef().newRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaTenantId( keepObj.getOptionalRefSchemaTenantId() );
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<CFBamScopePKey, ICFBamSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.remove( keepObj.getPKey() );
				}
			}

			if( allSchemaRef != null ) {
				allSchemaRef.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getScopeTableObj().forgetScope( obj );
	}

	public void forgetSchemaRefByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamSchemaRefObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSchemaRefByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
				ICFBamSchemaRefObj cur = null;
				Iterator<ICFBamSchemaRefObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetSchemaRefBySchemaIdx( long TenantId,
		long SchemaId )
	{
		if( indexBySchemaIdx == null ) {
			return;
		}
		CFBamSchemaRefBySchemaIdxKey key = schema.getBackingStore().getFactorySchemaRef().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( key );
			if( mapSchemaIdx != null ) {
				List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
				ICFBamSchemaRefObj cur = null;
				Iterator<ICFBamSchemaRefObj> iter = mapSchemaIdx.values().iterator();
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

	public void forgetSchemaRefByUNameIdx( long TenantId,
		long SchemaId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamSchemaRefByUNameIdxKey key = schema.getBackingStore().getFactorySchemaRef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamSchemaRefObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public void forgetSchemaRefByRefSchemaIdx( Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		if( indexByRefSchemaIdx == null ) {
			return;
		}
		CFBamSchemaRefByRefSchemaIdxKey key = schema.getBackingStore().getFactorySchemaRef().newRefSchemaIdxKey();
		key.setOptionalRefSchemaTenantId( RefSchemaTenantId );
		key.setOptionalRefSchemaId( RefSchemaId );
		if( indexByRefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( key );
			if( mapRefSchemaIdx != null ) {
				List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
				ICFBamSchemaRefObj cur = null;
				Iterator<ICFBamSchemaRefObj> iter = mapRefSchemaIdx.values().iterator();
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

			indexByRefSchemaIdx.remove( key );
		}
	}

	public ICFBamSchemaRefObj createSchemaRef( ICFBamSchemaRefObj Obj ) {
		ICFBamSchemaRefObj obj = Obj;
		CFBamSchemaRefBuff buff = obj.getSchemaRefBuff();
		schema.getBackingStore().getTableSchemaRef().createSchemaRef(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "SCRF" ) ) {
			obj = (ICFBamSchemaRefObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamSchemaRefObj readSchemaRef( CFBamScopePKey pkey ) {
		return( readSchemaRef( pkey, false ) );
	}

	public ICFBamSchemaRefObj readSchemaRef( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamSchemaRefObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSchemaRefBuff readBuff = schema.getBackingStore().getTableSchemaRef().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSchemaRefObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSchemaRefObj lockSchemaRef( CFBamScopePKey pkey ) {
		ICFBamSchemaRefObj locked = null;
		CFBamSchemaRefBuff lockBuff = schema.getBackingStore().getTableSchemaRef().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSchemaRefObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSchemaRef", pkey );
		}
		return( locked );
	}

	public List<ICFBamSchemaRefObj> readAllSchemaRef() {
		return( readAllSchemaRef( false ) );
	}

	public List<ICFBamSchemaRefObj> readAllSchemaRef( boolean forceRead ) {
		final String S_ProcName = "readAllSchemaRef";
		if( ( allSchemaRef == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj> map = new HashMap<CFBamScopePKey,ICFBamSchemaRefObj>();
			allSchemaRef = map;
			CFBamSchemaRefBuff[] buffList = schema.getBackingStore().getTableSchemaRef().readAllDerived( schema.getAuthorization() );
			CFBamSchemaRefBuff buff;
			ICFBamSchemaRefObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaRefObj realized = (ICFBamSchemaRefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaRefObj> cmp = new Comparator<ICFBamSchemaRefObj>() {
			public int compare( ICFBamSchemaRefObj lhs, ICFBamSchemaRefObj rhs ) {
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
		int len = allSchemaRef.size();
		ICFBamSchemaRefObj arr[] = new ICFBamSchemaRefObj[len];
		Iterator<ICFBamSchemaRefObj> valIter = allSchemaRef.values().iterator();
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
		ArrayList<ICFBamSchemaRefObj> arrayList = new ArrayList<ICFBamSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaRefObj readSchemaRefByIdIdx( long TenantId,
		long Id )
	{
		return( readSchemaRefByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamSchemaRefObj readSchemaRefByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamSchemaRefObj obj = readSchemaRef( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByTenantIdx( long TenantId )
	{
		return( readSchemaRefByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamSchemaRefObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaRefObj realized = (ICFBamSchemaRefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaRefObj> cmp = new Comparator<ICFBamSchemaRefObj>() {
			public int compare( ICFBamSchemaRefObj lhs, ICFBamSchemaRefObj rhs ) {
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
		ICFBamSchemaRefObj arr[] = new ICFBamSchemaRefObj[len];
		Iterator<ICFBamSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaRefObj> arrayList = new ArrayList<ICFBamSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefBySchemaIdx( long TenantId,
		long SchemaId )
	{
		return( readSchemaRefBySchemaIdx( TenantId,
			SchemaId,
			false ) );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefBySchemaIdx( long TenantId,
		long SchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefBySchemaIdx";
		CFBamSchemaRefBySchemaIdxKey key = schema.getBackingStore().getFactorySchemaRef().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		Map<CFBamScopePKey, ICFBamSchemaRefObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< CFBamSchemaRefBySchemaIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
			// Allow other threads to dirty-read while we're loading
			indexBySchemaIdx.put( key, dict );
			ICFBamSchemaRefObj obj;
			CFBamSchemaRefBuff[] buffList = schema.getBackingStore().getTableSchemaRef().readDerivedBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaId );
			CFBamSchemaRefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaRefObj realized = (ICFBamSchemaRefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaRefObj> cmp = new Comparator<ICFBamSchemaRefObj>() {
			public int compare( ICFBamSchemaRefObj lhs, ICFBamSchemaRefObj rhs ) {
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
		ICFBamSchemaRefObj arr[] = new ICFBamSchemaRefObj[len];
		Iterator<ICFBamSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaRefObj> arrayList = new ArrayList<ICFBamSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaRefObj readSchemaRefByUNameIdx( long TenantId,
		long SchemaId,
		String Name )
	{
		return( readSchemaRefByUNameIdx( TenantId,
			SchemaId,
			Name,
			false ) );
	}

	public ICFBamSchemaRefObj readSchemaRefByUNameIdx( long TenantId,
		long SchemaId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSchemaRefByUNameIdxKey,
				ICFBamSchemaRefObj >();
		}
		CFBamSchemaRefByUNameIdxKey key = schema.getBackingStore().getFactorySchemaRef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );
		ICFBamSchemaRefObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamSchemaRefBuff buff = schema.getBackingStore().getTableSchemaRef().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaId,
				Name );
			if( buff != null ) {
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSchemaRefObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByRefSchemaIdx( Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		return( readSchemaRefByRefSchemaIdx( RefSchemaTenantId,
			RefSchemaId,
			false ) );
	}

	public List<ICFBamSchemaRefObj> readSchemaRefByRefSchemaIdx( Long RefSchemaTenantId,
		Long RefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefByRefSchemaIdx";
		CFBamSchemaRefByRefSchemaIdxKey key = schema.getBackingStore().getFactorySchemaRef().newRefSchemaIdxKey();
		key.setOptionalRefSchemaTenantId( RefSchemaTenantId );
		key.setOptionalRefSchemaId( RefSchemaId );
		Map<CFBamScopePKey, ICFBamSchemaRefObj> dict;
		if( indexByRefSchemaIdx == null ) {
			indexByRefSchemaIdx = new HashMap< CFBamSchemaRefByRefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexByRefSchemaIdx.containsKey( key ) ) {
			dict = indexByRefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamSchemaRefObj>();
			// Allow other threads to dirty-read while we're loading
			indexByRefSchemaIdx.put( key, dict );
			ICFBamSchemaRefObj obj;
			CFBamSchemaRefBuff[] buffList = schema.getBackingStore().getTableSchemaRef().readDerivedByRefSchemaIdx( schema.getAuthorization(),
				RefSchemaTenantId,
				RefSchemaId );
			CFBamSchemaRefBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSchemaRefObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamSchemaRefObj realized = (ICFBamSchemaRefObj)obj.realize();
			}
		}
		Comparator<ICFBamSchemaRefObj> cmp = new Comparator<ICFBamSchemaRefObj>() {
			public int compare( ICFBamSchemaRefObj lhs, ICFBamSchemaRefObj rhs ) {
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
		ICFBamSchemaRefObj arr[] = new ICFBamSchemaRefObj[len];
		Iterator<ICFBamSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSchemaRefObj> arrayList = new ArrayList<ICFBamSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSchemaRefObj updateSchemaRef( ICFBamSchemaRefObj Obj ) {
		ICFBamSchemaRefObj obj = Obj;
		schema.getBackingStore().getTableSchemaRef().updateSchemaRef( schema.getAuthorization(),
			Obj.getSchemaRefBuff() );
		if( Obj.getClassCode().equals( "SCRF" ) ) {
			obj = (ICFBamSchemaRefObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteSchemaRef( ICFBamSchemaRefObj Obj ) {
		ICFBamSchemaRefObj obj = Obj;
		schema.getBackingStore().getTableSchemaRef().deleteSchemaRef( schema.getAuthorization(),
			obj.getSchemaRefBuff() );
		obj.forget( true );
	}

	public void deleteSchemaRefByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readSchemaRef( pkey );
		if( obj != null ) {
			ICFBamSchemaRefEditObj editObj = (ICFBamSchemaRefEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSchemaRefEditObj)obj.beginEdit();
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

	public void deleteSchemaRefByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableSchemaRef().deleteSchemaRefByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamSchemaRefObj> iter = dict.values().iterator();
			ICFBamSchemaRefObj obj;
			List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
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
			schema.getBackingStore().getTableSchemaRef().deleteSchemaRefByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteSchemaRefBySchemaIdx( long TenantId,
		long SchemaId )
	{
		CFBamSchemaRefBySchemaIdxKey key = schema.getBackingStore().getFactorySchemaRef().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< CFBamSchemaRefBySchemaIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj> dict = indexBySchemaIdx.get( key );
			schema.getBackingStore().getTableSchemaRef().deleteSchemaRefBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaId );
			Iterator<ICFBamSchemaRefObj> iter = dict.values().iterator();
			ICFBamSchemaRefObj obj;
			List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
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
			schema.getBackingStore().getTableSchemaRef().deleteSchemaRefBySchemaIdx( schema.getAuthorization(),
				TenantId,
				SchemaId );
		}
	}

	public void deleteSchemaRefByUNameIdx( long TenantId,
		long SchemaId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamSchemaRefByUNameIdxKey,
				ICFBamSchemaRefObj >();
		}
		CFBamSchemaRefByUNameIdxKey key = schema.getBackingStore().getFactorySchemaRef().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );
		ICFBamSchemaRefObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableSchemaRef().deleteSchemaRefByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSchemaRef().deleteSchemaRefByUNameIdx( schema.getAuthorization(),
				TenantId,
				SchemaId,
				Name );
		}
	}

	public void deleteSchemaRefByRefSchemaIdx( Long RefSchemaTenantId,
		Long RefSchemaId )
	{
		CFBamSchemaRefByRefSchemaIdxKey key = schema.getBackingStore().getFactorySchemaRef().newRefSchemaIdxKey();
		key.setOptionalRefSchemaTenantId( RefSchemaTenantId );
		key.setOptionalRefSchemaId( RefSchemaId );
		if( indexByRefSchemaIdx == null ) {
			indexByRefSchemaIdx = new HashMap< CFBamSchemaRefByRefSchemaIdxKey,
				Map< CFBamScopePKey, ICFBamSchemaRefObj > >();
		}
		if( indexByRefSchemaIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamSchemaRefObj> dict = indexByRefSchemaIdx.get( key );
			schema.getBackingStore().getTableSchemaRef().deleteSchemaRefByRefSchemaIdx( schema.getAuthorization(),
				RefSchemaTenantId,
				RefSchemaId );
			Iterator<ICFBamSchemaRefObj> iter = dict.values().iterator();
			ICFBamSchemaRefObj obj;
			List<ICFBamSchemaRefObj> toForget = new LinkedList<ICFBamSchemaRefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByRefSchemaIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSchemaRef().deleteSchemaRefByRefSchemaIdx( schema.getAuthorization(),
				RefSchemaTenantId,
				RefSchemaId );
		}
	}
}
