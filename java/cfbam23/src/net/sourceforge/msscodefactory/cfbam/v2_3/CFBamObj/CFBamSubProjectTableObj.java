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

public class CFBamSubProjectTableObj
	implements ICFBamSubProjectTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamDomainBasePKey, ICFBamSubProjectObj> members;
	private Map<CFBamDomainBasePKey, ICFBamSubProjectObj> allSubProject;
	private Map< CFBamDomainBaseByTenantIdxKey,
		Map<CFBamDomainBasePKey, ICFBamSubProjectObj > > indexByTenantIdx;
	private Map< CFBamSubProjectByParentIdxKey,
		Map<CFBamDomainBasePKey, ICFBamSubProjectObj > > indexByParentIdx;
	private Map< CFBamSubProjectByNameIdxKey,
		ICFBamSubProjectObj > indexByNameIdx;
	public static String TABLE_NAME = "SubProject";
	public static String TABLE_DBNAME = "sprjdef";

	public CFBamSubProjectTableObj() {
		schema = null;
		members = new HashMap<CFBamDomainBasePKey, ICFBamSubProjectObj>();
		allSubProject = null;
		indexByTenantIdx = null;
		indexByParentIdx = null;
		indexByNameIdx = null;
	}

	public CFBamSubProjectTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamDomainBasePKey, ICFBamSubProjectObj>();
		allSubProject = null;
		indexByTenantIdx = null;
		indexByParentIdx = null;
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
		allSubProject = null;
		indexByTenantIdx = null;
		indexByParentIdx = null;
		indexByNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSubProjectObj.
	 */
	public ICFBamSubProjectObj newInstance() {
		ICFBamSubProjectObj inst = new CFBamSubProjectObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSubProjectObj.
	 */
	public ICFBamSubProjectEditObj newEditInstance( ICFBamSubProjectObj orig ) {
		ICFBamSubProjectEditObj edit = new CFBamSubProjectEditObj( orig );
		return( edit );
	}

	public ICFBamSubProjectObj realizeSubProject( ICFBamSubProjectObj Obj ) {
		ICFBamSubProjectObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		ICFBamSubProjectObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSubProjectObj existingObj = members.get( pkey );
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
				Map<CFBamDomainBasePKey, ICFBamSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByParentIdx != null ) {
				CFBamSubProjectByParentIdxKey keyParentIdx =
					schema.getBackingStore().getFactorySubProject().newParentIdxKey();
				keyParentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyParentIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				Map<CFBamDomainBasePKey, ICFBamSubProjectObj > mapParentIdx = indexByParentIdx.get( keyParentIdx );
				if( mapParentIdx != null ) {
					mapParentIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamSubProjectByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactorySubProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamSubProjectObj)schema.getRealProjectTableObj().realizeRealProject( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByParentIdx != null ) {
				CFBamSubProjectByParentIdxKey keyParentIdx =
					schema.getBackingStore().getFactorySubProject().newParentIdxKey();
				keyParentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyParentIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				Map<CFBamDomainBasePKey, ICFBamSubProjectObj > mapParentIdx = indexByParentIdx.get( keyParentIdx );
				if( mapParentIdx != null ) {
					mapParentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamSubProjectByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactorySubProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
			if( allSubProject != null ) {
				allSubProject.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamSubProjectObj)schema.getRealProjectTableObj().realizeRealProject( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSubProject != null ) {
				allSubProject.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByParentIdx != null ) {
				CFBamSubProjectByParentIdxKey keyParentIdx =
					schema.getBackingStore().getFactorySubProject().newParentIdxKey();
				keyParentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyParentIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				Map<CFBamDomainBasePKey, ICFBamSubProjectObj > mapParentIdx = indexByParentIdx.get( keyParentIdx );
				if( mapParentIdx != null ) {
					mapParentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamSubProjectByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactorySubProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetSubProject( ICFBamSubProjectObj Obj ) {
		forgetSubProject( Obj, false );
	}

	public void forgetSubProject( ICFBamSubProjectObj Obj, boolean forgetSubObjects ) {
		ICFBamSubProjectObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSubProjectObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByParentIdx != null ) {
				CFBamSubProjectByParentIdxKey keyParentIdx =
					schema.getBackingStore().getFactorySubProject().newParentIdxKey();
				keyParentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyParentIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				Map<CFBamDomainBasePKey, ICFBamSubProjectObj > mapParentIdx = indexByParentIdx.get( keyParentIdx );
				if( mapParentIdx != null ) {
					mapParentIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamSubProjectByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactorySubProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allSubProject != null ) {
				allSubProject.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		schema.getRealProjectTableObj().forgetRealProject( obj );
	}

	public void forgetSubProjectByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamDomainBasePKey key = schema.getBackingStore().getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamSubProjectObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSubProjectByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamSubProjectObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamSubProjectObj> toForget = new LinkedList<ICFBamSubProjectObj>();
				ICFBamSubProjectObj cur = null;
				Iterator<ICFBamSubProjectObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetSubProjectByParentIdx( long TenantId,
		long ParentProjectId )
	{
		if( indexByParentIdx == null ) {
			return;
		}
		CFBamSubProjectByParentIdxKey key = schema.getBackingStore().getFactorySubProject().newParentIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		if( indexByParentIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamSubProjectObj > mapParentIdx = indexByParentIdx.get( key );
			if( mapParentIdx != null ) {
				List<ICFBamSubProjectObj> toForget = new LinkedList<ICFBamSubProjectObj>();
				ICFBamSubProjectObj cur = null;
				Iterator<ICFBamSubProjectObj> iter = mapParentIdx.values().iterator();
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

			indexByParentIdx.remove( key );
		}
	}

	public void forgetSubProjectByNameIdx( long TenantId,
		long ParentProjectId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		CFBamSubProjectByNameIdxKey key = schema.getBackingStore().getFactorySubProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			ICFBamSubProjectObj probed = indexByNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByNameIdx.remove( key );
		}
	}

	public ICFBamSubProjectObj createSubProject( ICFBamSubProjectObj Obj ) {
		ICFBamSubProjectObj obj = Obj;
		CFBamSubProjectBuff buff = obj.getSubProjectBuff();
		schema.getBackingStore().getTableSubProject().createSubProject(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "SPRJ" ) ) {
			obj = (ICFBamSubProjectObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamSubProjectObj readSubProject( CFBamDomainBasePKey pkey ) {
		return( readSubProject( pkey, false ) );
	}

	public ICFBamSubProjectObj readSubProject( CFBamDomainBasePKey pkey, boolean forceRead ) {
		ICFBamSubProjectObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSubProjectBuff readBuff = schema.getBackingStore().getTableSubProject().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamSubProjectObj)schema.getDomainBaseTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSubProjectObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSubProjectObj lockSubProject( CFBamDomainBasePKey pkey ) {
		ICFBamSubProjectObj locked = null;
		CFBamSubProjectBuff lockBuff = schema.getBackingStore().getTableSubProject().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamSubProjectObj)schema.getDomainBaseTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSubProjectObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSubProject", pkey );
		}
		return( locked );
	}

	public List<ICFBamSubProjectObj> readAllSubProject() {
		return( readAllSubProject( false ) );
	}

	public List<ICFBamSubProjectObj> readAllSubProject( boolean forceRead ) {
		final String S_ProcName = "readAllSubProject";
		if( ( allSubProject == null ) || forceRead ) {
			Map<CFBamDomainBasePKey, ICFBamSubProjectObj> map = new HashMap<CFBamDomainBasePKey,ICFBamSubProjectObj>();
			allSubProject = map;
			CFBamSubProjectBuff[] buffList = schema.getBackingStore().getTableSubProject().readAllDerived( schema.getAuthorization() );
			CFBamSubProjectBuff buff;
			ICFBamSubProjectObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSubProjectObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamSubProjectObj realized = (ICFBamSubProjectObj)obj.realize();
			}
		}
		Comparator<ICFBamSubProjectObj> cmp = new Comparator<ICFBamSubProjectObj>() {
			public int compare( ICFBamSubProjectObj lhs, ICFBamSubProjectObj rhs ) {
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
		int len = allSubProject.size();
		ICFBamSubProjectObj arr[] = new ICFBamSubProjectObj[len];
		Iterator<ICFBamSubProjectObj> valIter = allSubProject.values().iterator();
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
		ArrayList<ICFBamSubProjectObj> arrayList = new ArrayList<ICFBamSubProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSubProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSubProjectObj readSubProjectByIdIdx( long TenantId,
		long Id )
	{
		return( readSubProjectByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamSubProjectObj readSubProjectByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamSubProjectObj obj = readSubProject( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSubProjectObj> readSubProjectByTenantIdx( long TenantId )
	{
		return( readSubProjectByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamSubProjectObj> readSubProjectByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSubProjectByTenantIdx";
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamDomainBasePKey, ICFBamSubProjectObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamSubProjectObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamSubProjectObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamDomainBaseObj obj;
			CFBamDomainBaseBuff[] buffList = schema.getBackingStore().getTableDomainBase().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamDomainBaseBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSubProjectObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamSubProjectObj realized = (ICFBamSubProjectObj)obj.realize();
			}
		}
		Comparator<ICFBamSubProjectObj> cmp = new Comparator<ICFBamSubProjectObj>() {
			public int compare( ICFBamSubProjectObj lhs, ICFBamSubProjectObj rhs ) {
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
		ICFBamSubProjectObj arr[] = new ICFBamSubProjectObj[len];
		Iterator<ICFBamSubProjectObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSubProjectObj> arrayList = new ArrayList<ICFBamSubProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSubProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSubProjectObj> readSubProjectByParentIdx( long TenantId,
		long ParentProjectId )
	{
		return( readSubProjectByParentIdx( TenantId,
			ParentProjectId,
			false ) );
	}

	public List<ICFBamSubProjectObj> readSubProjectByParentIdx( long TenantId,
		long ParentProjectId,
		boolean forceRead )
	{
		final String S_ProcName = "readSubProjectByParentIdx";
		CFBamSubProjectByParentIdxKey key = schema.getBackingStore().getFactorySubProject().newParentIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		Map<CFBamDomainBasePKey, ICFBamSubProjectObj> dict;
		if( indexByParentIdx == null ) {
			indexByParentIdx = new HashMap< CFBamSubProjectByParentIdxKey,
				Map< CFBamDomainBasePKey, ICFBamSubProjectObj > >();
		}
		if( ( ! forceRead ) && indexByParentIdx.containsKey( key ) ) {
			dict = indexByParentIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamSubProjectObj>();
			// Allow other threads to dirty-read while we're loading
			indexByParentIdx.put( key, dict );
			ICFBamSubProjectObj obj;
			CFBamSubProjectBuff[] buffList = schema.getBackingStore().getTableSubProject().readDerivedByParentIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId );
			CFBamSubProjectBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamSubProjectObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamSubProjectObj realized = (ICFBamSubProjectObj)obj.realize();
			}
		}
		Comparator<ICFBamSubProjectObj> cmp = new Comparator<ICFBamSubProjectObj>() {
			public int compare( ICFBamSubProjectObj lhs, ICFBamSubProjectObj rhs ) {
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
		ICFBamSubProjectObj arr[] = new ICFBamSubProjectObj[len];
		Iterator<ICFBamSubProjectObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSubProjectObj> arrayList = new ArrayList<ICFBamSubProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSubProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSubProjectObj readSubProjectByNameIdx( long TenantId,
		long ParentProjectId,
		String Name )
	{
		return( readSubProjectByNameIdx( TenantId,
			ParentProjectId,
			Name,
			false ) );
	}

	public ICFBamSubProjectObj readSubProjectByNameIdx( long TenantId,
		long ParentProjectId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamSubProjectByNameIdxKey,
				ICFBamSubProjectObj >();
		}
		CFBamSubProjectByNameIdxKey key = schema.getBackingStore().getFactorySubProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		key.setRequiredName( Name );
		ICFBamSubProjectObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFBamSubProjectBuff buff = schema.getBackingStore().getTableSubProject().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId,
				Name );
			if( buff != null ) {
				obj = (ICFBamSubProjectObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSubProjectObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamSubProjectObj updateSubProject( ICFBamSubProjectObj Obj ) {
		ICFBamSubProjectObj obj = Obj;
		schema.getBackingStore().getTableSubProject().updateSubProject( schema.getAuthorization(),
			Obj.getSubProjectBuff() );
		if( Obj.getClassCode().equals( "SPRJ" ) ) {
			obj = (ICFBamSubProjectObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteSubProject( ICFBamSubProjectObj Obj ) {
		ICFBamSubProjectObj obj = Obj;
		schema.getBackingStore().getTableSubProject().deleteSubProject( schema.getAuthorization(),
			obj.getSubProjectBuff() );
		obj.forget( true );
	}

	public void deleteSubProjectByIdIdx( long TenantId,
		long Id )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDomainBaseObj obj = readSubProject( pkey );
		if( obj != null ) {
			ICFBamSubProjectEditObj editObj = (ICFBamSubProjectEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSubProjectEditObj)obj.beginEdit();
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

	public void deleteSubProjectByTenantIdx( long TenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamSubProjectObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamSubProjectObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableSubProject().deleteSubProjectByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamSubProjectObj> iter = dict.values().iterator();
			ICFBamSubProjectObj obj;
			List<ICFBamSubProjectObj> toForget = new LinkedList<ICFBamSubProjectObj>();
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
			schema.getBackingStore().getTableSubProject().deleteSubProjectByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteSubProjectByParentIdx( long TenantId,
		long ParentProjectId )
	{
		CFBamSubProjectByParentIdxKey key = schema.getBackingStore().getFactorySubProject().newParentIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		if( indexByParentIdx == null ) {
			indexByParentIdx = new HashMap< CFBamSubProjectByParentIdxKey,
				Map< CFBamDomainBasePKey, ICFBamSubProjectObj > >();
		}
		if( indexByParentIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamSubProjectObj> dict = indexByParentIdx.get( key );
			schema.getBackingStore().getTableSubProject().deleteSubProjectByParentIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId );
			Iterator<ICFBamSubProjectObj> iter = dict.values().iterator();
			ICFBamSubProjectObj obj;
			List<ICFBamSubProjectObj> toForget = new LinkedList<ICFBamSubProjectObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByParentIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSubProject().deleteSubProjectByParentIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId );
		}
	}

	public void deleteSubProjectByNameIdx( long TenantId,
		long ParentProjectId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamSubProjectByNameIdxKey,
				ICFBamSubProjectObj >();
		}
		CFBamSubProjectByNameIdxKey key = schema.getBackingStore().getFactorySubProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		key.setRequiredName( Name );
		ICFBamSubProjectObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getBackingStore().getTableSubProject().deleteSubProjectByNameIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSubProject().deleteSubProjectByNameIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId,
				Name );
		}
	}
}
