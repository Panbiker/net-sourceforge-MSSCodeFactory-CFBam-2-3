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

public class CFBamTopProjectTableObj
	implements ICFBamTopProjectTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamDomainBasePKey, ICFBamTopProjectObj> members;
	private Map<CFBamDomainBasePKey, ICFBamTopProjectObj> allTopProject;
	private Map< CFBamDomainBaseByTenantIdxKey,
		Map<CFBamDomainBasePKey, ICFBamTopProjectObj > > indexByTenantIdx;
	private Map< CFBamTopProjectByDomainIdxKey,
		Map<CFBamDomainBasePKey, ICFBamTopProjectObj > > indexByDomainIdx;
	private Map< CFBamTopProjectByNameIdxKey,
		ICFBamTopProjectObj > indexByNameIdx;
	public static String TABLE_NAME = "TopProject";
	public static String TABLE_DBNAME = "tprjdef";

	public CFBamTopProjectTableObj() {
		schema = null;
		members = new HashMap<CFBamDomainBasePKey, ICFBamTopProjectObj>();
		allTopProject = null;
		indexByTenantIdx = null;
		indexByDomainIdx = null;
		indexByNameIdx = null;
	}

	public CFBamTopProjectTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamDomainBasePKey, ICFBamTopProjectObj>();
		allTopProject = null;
		indexByTenantIdx = null;
		indexByDomainIdx = null;
		indexByNameIdx = null;
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
		allTopProject = null;
		indexByTenantIdx = null;
		indexByDomainIdx = null;
		indexByNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTopProjectObj.
	 */
	public ICFBamTopProjectObj newInstance() {
		ICFBamTopProjectObj inst = new CFBamTopProjectObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTopProjectObj.
	 */
	public ICFBamTopProjectEditObj newEditInstance( ICFBamTopProjectObj orig ) {
		ICFBamTopProjectEditObj edit = new CFBamTopProjectEditObj( orig );
		return( edit );
	}

	public ICFBamTopProjectObj realizeTopProject( ICFBamTopProjectObj Obj ) {
		ICFBamTopProjectObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		ICFBamTopProjectObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamTopProjectObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamTopProjectByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactoryTopProject().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamDomainBasePKey, ICFBamTopProjectObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTopProjectByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTopProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamTopProjectObj)schema.getRealProjectTableObj().realizeRealProject( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamTopProjectByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactoryTopProject().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamDomainBasePKey, ICFBamTopProjectObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTopProjectByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTopProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
			if( allTopProject != null ) {
				allTopProject.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamTopProjectObj)schema.getRealProjectTableObj().realizeRealProject( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTopProject != null ) {
				allTopProject.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamTopProjectByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactoryTopProject().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamDomainBasePKey, ICFBamTopProjectObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTopProjectByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTopProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetTopProject( ICFBamTopProjectObj Obj ) {
		forgetTopProject( Obj, false );
	}

	public void forgetTopProject( ICFBamTopProjectObj Obj, boolean forgetSubObjects ) {
		ICFBamTopProjectObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamTopProjectObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamTopProjectByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactoryTopProject().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamDomainBasePKey, ICFBamTopProjectObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamTopProjectByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryTopProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allTopProject != null ) {
				allTopProject.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getSubProjectTableObj().forgetSubProjectByParentIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getRealProjectTableObj().forgetRealProject( obj );
	}

	public void forgetTopProjectByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamDomainBasePKey key = schema.getBackingStore().getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamTopProjectObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTopProjectByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamTopProjectObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamTopProjectObj> toForget = new LinkedList<ICFBamTopProjectObj>();
				ICFBamTopProjectObj cur = null;
				Iterator<ICFBamTopProjectObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetTopProjectByDomainIdx( long TenantId,
		long DomainId )
	{
		if( indexByDomainIdx == null ) {
			return;
		}
		CFBamTopProjectByDomainIdxKey key = schema.getBackingStore().getFactoryTopProject().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		if( indexByDomainIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamTopProjectObj > mapDomainIdx = indexByDomainIdx.get( key );
			if( mapDomainIdx != null ) {
				List<ICFBamTopProjectObj> toForget = new LinkedList<ICFBamTopProjectObj>();
				ICFBamTopProjectObj cur = null;
				Iterator<ICFBamTopProjectObj> iter = mapDomainIdx.values().iterator();
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

	public void forgetTopProjectByNameIdx( long TenantId,
		long DomainId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		CFBamTopProjectByNameIdxKey key = schema.getBackingStore().getFactoryTopProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			ICFBamTopProjectObj probed = indexByNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByNameIdx.remove( key );
		}
	}

	public ICFBamTopProjectObj createTopProject( ICFBamTopProjectObj Obj ) {
		ICFBamTopProjectObj obj = Obj;
		CFBamTopProjectBuff buff = obj.getTopProjectBuff();
		schema.getBackingStore().getTableTopProject().createTopProject(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "TPRJ" ) ) {
			obj = (ICFBamTopProjectObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamTopProjectObj readTopProject( CFBamDomainBasePKey pkey ) {
		return( readTopProject( pkey, false ) );
	}

	public ICFBamTopProjectObj readTopProject( CFBamDomainBasePKey pkey, boolean forceRead ) {
		ICFBamTopProjectObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamTopProjectBuff readBuff = schema.getBackingStore().getTableTopProject().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamTopProjectObj)schema.getDomainBaseTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamTopProjectObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamTopProjectObj lockTopProject( CFBamDomainBasePKey pkey ) {
		ICFBamTopProjectObj locked = null;
		CFBamTopProjectBuff lockBuff = schema.getBackingStore().getTableTopProject().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamTopProjectObj)schema.getDomainBaseTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamTopProjectObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockTopProject", pkey );
		}
		return( locked );
	}

	public List<ICFBamTopProjectObj> readAllTopProject() {
		return( readAllTopProject( false ) );
	}

	public List<ICFBamTopProjectObj> readAllTopProject( boolean forceRead ) {
		final String S_ProcName = "readAllTopProject";
		if( ( allTopProject == null ) || forceRead ) {
			Map<CFBamDomainBasePKey, ICFBamTopProjectObj> map = new HashMap<CFBamDomainBasePKey,ICFBamTopProjectObj>();
			allTopProject = map;
			CFBamTopProjectBuff[] buffList = schema.getBackingStore().getTableTopProject().readAllDerived( schema.getAuthorization() );
			CFBamTopProjectBuff buff;
			ICFBamTopProjectObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTopProjectObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamTopProjectObj realized = (ICFBamTopProjectObj)obj.realize();
			}
		}
		Comparator<ICFBamTopProjectObj> cmp = new Comparator<ICFBamTopProjectObj>() {
			public int compare( ICFBamTopProjectObj lhs, ICFBamTopProjectObj rhs ) {
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
					CFBamDomainBasePKey lhsPKey = lhs.getPKey();
					CFBamDomainBasePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allTopProject.size();
		ICFBamTopProjectObj arr[] = new ICFBamTopProjectObj[len];
		Iterator<ICFBamTopProjectObj> valIter = allTopProject.values().iterator();
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
		ArrayList<ICFBamTopProjectObj> arrayList = new ArrayList<ICFBamTopProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTopProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTopProjectObj readTopProjectByIdIdx( long TenantId,
		long Id )
	{
		return( readTopProjectByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamTopProjectObj readTopProjectByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamTopProjectObj obj = readTopProject( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamTopProjectObj> readTopProjectByTenantIdx( long TenantId )
	{
		return( readTopProjectByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamTopProjectObj> readTopProjectByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopProjectByTenantIdx";
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamDomainBasePKey, ICFBamTopProjectObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamTopProjectObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamTopProjectObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamDomainBaseObj obj;
			CFBamDomainBaseBuff[] buffList = schema.getBackingStore().getTableDomainBase().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamDomainBaseBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTopProjectObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamTopProjectObj realized = (ICFBamTopProjectObj)obj.realize();
			}
		}
		Comparator<ICFBamTopProjectObj> cmp = new Comparator<ICFBamTopProjectObj>() {
			public int compare( ICFBamTopProjectObj lhs, ICFBamTopProjectObj rhs ) {
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
					CFBamDomainBasePKey lhsPKey = lhs.getPKey();
					CFBamDomainBasePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTopProjectObj arr[] = new ICFBamTopProjectObj[len];
		Iterator<ICFBamTopProjectObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTopProjectObj> arrayList = new ArrayList<ICFBamTopProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTopProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamTopProjectObj> readTopProjectByDomainIdx( long TenantId,
		long DomainId )
	{
		return( readTopProjectByDomainIdx( TenantId,
			DomainId,
			false ) );
	}

	public List<ICFBamTopProjectObj> readTopProjectByDomainIdx( long TenantId,
		long DomainId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopProjectByDomainIdx";
		CFBamTopProjectByDomainIdxKey key = schema.getBackingStore().getFactoryTopProject().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		Map<CFBamDomainBasePKey, ICFBamTopProjectObj> dict;
		if( indexByDomainIdx == null ) {
			indexByDomainIdx = new HashMap< CFBamTopProjectByDomainIdxKey,
				Map< CFBamDomainBasePKey, ICFBamTopProjectObj > >();
		}
		if( ( ! forceRead ) && indexByDomainIdx.containsKey( key ) ) {
			dict = indexByDomainIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamTopProjectObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDomainIdx.put( key, dict );
			ICFBamTopProjectObj obj;
			CFBamTopProjectBuff[] buffList = schema.getBackingStore().getTableTopProject().readDerivedByDomainIdx( schema.getAuthorization(),
				TenantId,
				DomainId );
			CFBamTopProjectBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamTopProjectObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamTopProjectObj realized = (ICFBamTopProjectObj)obj.realize();
			}
		}
		Comparator<ICFBamTopProjectObj> cmp = new Comparator<ICFBamTopProjectObj>() {
			public int compare( ICFBamTopProjectObj lhs, ICFBamTopProjectObj rhs ) {
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
					CFBamDomainBasePKey lhsPKey = lhs.getPKey();
					CFBamDomainBasePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamTopProjectObj arr[] = new ICFBamTopProjectObj[len];
		Iterator<ICFBamTopProjectObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamTopProjectObj> arrayList = new ArrayList<ICFBamTopProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamTopProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamTopProjectObj readTopProjectByNameIdx( long TenantId,
		long DomainId,
		String Name )
	{
		return( readTopProjectByNameIdx( TenantId,
			DomainId,
			Name,
			false ) );
	}

	public ICFBamTopProjectObj readTopProjectByNameIdx( long TenantId,
		long DomainId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamTopProjectByNameIdxKey,
				ICFBamTopProjectObj >();
		}
		CFBamTopProjectByNameIdxKey key = schema.getBackingStore().getFactoryTopProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );
		ICFBamTopProjectObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFBamTopProjectBuff buff = schema.getBackingStore().getTableTopProject().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				DomainId,
				Name );
			if( buff != null ) {
				obj = (ICFBamTopProjectObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamTopProjectObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamTopProjectObj updateTopProject( ICFBamTopProjectObj Obj ) {
		ICFBamTopProjectObj obj = Obj;
		schema.getBackingStore().getTableTopProject().updateTopProject( schema.getAuthorization(),
			Obj.getTopProjectBuff() );
		if( Obj.getClassCode().equals( "TPRJ" ) ) {
			obj = (ICFBamTopProjectObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteTopProject( ICFBamTopProjectObj Obj ) {
		ICFBamTopProjectObj obj = Obj;
		schema.getBackingStore().getTableTopProject().deleteTopProject( schema.getAuthorization(),
			obj.getTopProjectBuff() );
		obj.forget( true );
	}

	public void deleteTopProjectByIdIdx( long TenantId,
		long Id )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDomainBaseObj obj = readTopProject( pkey );
		if( obj != null ) {
			ICFBamTopProjectEditObj editObj = (ICFBamTopProjectEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamTopProjectEditObj)obj.beginEdit();
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

	public void deleteTopProjectByTenantIdx( long TenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamTopProjectObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamTopProjectObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableTopProject().deleteTopProjectByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamTopProjectObj> iter = dict.values().iterator();
			ICFBamTopProjectObj obj;
			List<ICFBamTopProjectObj> toForget = new LinkedList<ICFBamTopProjectObj>();
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
			schema.getBackingStore().getTableTopProject().deleteTopProjectByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTopProjectByDomainIdx( long TenantId,
		long DomainId )
	{
		CFBamTopProjectByDomainIdxKey key = schema.getBackingStore().getFactoryTopProject().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		if( indexByDomainIdx == null ) {
			indexByDomainIdx = new HashMap< CFBamTopProjectByDomainIdxKey,
				Map< CFBamDomainBasePKey, ICFBamTopProjectObj > >();
		}
		if( indexByDomainIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamTopProjectObj> dict = indexByDomainIdx.get( key );
			schema.getBackingStore().getTableTopProject().deleteTopProjectByDomainIdx( schema.getAuthorization(),
				TenantId,
				DomainId );
			Iterator<ICFBamTopProjectObj> iter = dict.values().iterator();
			ICFBamTopProjectObj obj;
			List<ICFBamTopProjectObj> toForget = new LinkedList<ICFBamTopProjectObj>();
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
			schema.getBackingStore().getTableTopProject().deleteTopProjectByDomainIdx( schema.getAuthorization(),
				TenantId,
				DomainId );
		}
	}

	public void deleteTopProjectByNameIdx( long TenantId,
		long DomainId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamTopProjectByNameIdxKey,
				ICFBamTopProjectObj >();
		}
		CFBamTopProjectByNameIdxKey key = schema.getBackingStore().getFactoryTopProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );
		ICFBamTopProjectObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getBackingStore().getTableTopProject().deleteTopProjectByNameIdx( schema.getAuthorization(),
				TenantId,
				DomainId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableTopProject().deleteTopProjectByNameIdx( schema.getAuthorization(),
				TenantId,
				DomainId,
				Name );
		}
	}
}
