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

public class CFBamMajorVersionTableObj
	implements ICFBamMajorVersionTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamDomainBasePKey, ICFBamMajorVersionObj> members;
	private Map<CFBamDomainBasePKey, ICFBamMajorVersionObj> allMajorVersion;
	private Map< CFBamDomainBaseByTenantIdxKey,
		Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > > indexByTenantIdx;
	private Map< CFBamMajorVersionByPPrjIdxKey,
		Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > > indexByPPrjIdx;
	private Map< CFBamMajorVersionByNameIdxKey,
		ICFBamMajorVersionObj > indexByNameIdx;
	public static String TABLE_NAME = "MajorVersion";
	public static String TABLE_DBNAME = "mjverdef";

	public CFBamMajorVersionTableObj() {
		schema = null;
		members = new HashMap<CFBamDomainBasePKey, ICFBamMajorVersionObj>();
		allMajorVersion = null;
		indexByTenantIdx = null;
		indexByPPrjIdx = null;
		indexByNameIdx = null;
	}

	public CFBamMajorVersionTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamDomainBasePKey, ICFBamMajorVersionObj>();
		allMajorVersion = null;
		indexByTenantIdx = null;
		indexByPPrjIdx = null;
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
		allMajorVersion = null;
		indexByTenantIdx = null;
		indexByPPrjIdx = null;
		indexByNameIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamMajorVersionObj.
	 */
	public ICFBamMajorVersionObj newInstance() {
		ICFBamMajorVersionObj inst = new CFBamMajorVersionObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamMajorVersionObj.
	 */
	public ICFBamMajorVersionEditObj newEditInstance( ICFBamMajorVersionObj orig ) {
		ICFBamMajorVersionEditObj edit = new CFBamMajorVersionEditObj( orig );
		return( edit );
	}

	public ICFBamMajorVersionObj realizeMajorVersion( ICFBamMajorVersionObj Obj ) {
		ICFBamMajorVersionObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		ICFBamMajorVersionObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamMajorVersionObj existingObj = members.get( pkey );
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
				Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByPPrjIdx != null ) {
				CFBamMajorVersionByPPrjIdxKey keyPPrjIdx =
					schema.getBackingStore().getFactoryMajorVersion().newPPrjIdxKey();
				keyPPrjIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPPrjIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > mapPPrjIdx = indexByPPrjIdx.get( keyPPrjIdx );
				if( mapPPrjIdx != null ) {
					mapPPrjIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamMajorVersionByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryMajorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFBamMajorVersionObj)schema.getVersionTableObj().realizeVersion( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPPrjIdx != null ) {
				CFBamMajorVersionByPPrjIdxKey keyPPrjIdx =
					schema.getBackingStore().getFactoryMajorVersion().newPPrjIdxKey();
				keyPPrjIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPPrjIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > mapPPrjIdx = indexByPPrjIdx.get( keyPPrjIdx );
				if( mapPPrjIdx != null ) {
					mapPPrjIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamMajorVersionByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryMajorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
			if( allMajorVersion != null ) {
				allMajorVersion.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFBamMajorVersionObj)schema.getVersionTableObj().realizeVersion( keepObj );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allMajorVersion != null ) {
				allMajorVersion.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPPrjIdx != null ) {
				CFBamMajorVersionByPPrjIdxKey keyPPrjIdx =
					schema.getBackingStore().getFactoryMajorVersion().newPPrjIdxKey();
				keyPPrjIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPPrjIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > mapPPrjIdx = indexByPPrjIdx.get( keyPPrjIdx );
				if( mapPPrjIdx != null ) {
					mapPPrjIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamMajorVersionByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryMajorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetMajorVersion( ICFBamMajorVersionObj Obj ) {
		forgetMajorVersion( Obj, false );
	}

	public void forgetMajorVersion( ICFBamMajorVersionObj Obj, boolean forgetSubObjects ) {
		ICFBamMajorVersionObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamMajorVersionObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByPPrjIdx != null ) {
				CFBamMajorVersionByPPrjIdxKey keyPPrjIdx =
					schema.getBackingStore().getFactoryMajorVersion().newPPrjIdxKey();
				keyPPrjIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyPPrjIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > mapPPrjIdx = indexByPPrjIdx.get( keyPPrjIdx );
				if( mapPPrjIdx != null ) {
					mapPPrjIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByNameIdx != null ) {
				CFBamMajorVersionByNameIdxKey keyNameIdx =
					schema.getBackingStore().getFactoryMajorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredParentProjectId( keepObj.getRequiredParentProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allMajorVersion != null ) {
				allMajorVersion.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getMinorVersionTableObj().forgetMinorVersionByMajorIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
		schema.getVersionTableObj().forgetVersion( obj );
	}

	public void forgetMajorVersionByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamDomainBasePKey key = schema.getBackingStore().getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamMajorVersionObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetMajorVersionByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamMajorVersionObj> toForget = new LinkedList<ICFBamMajorVersionObj>();
				ICFBamMajorVersionObj cur = null;
				Iterator<ICFBamMajorVersionObj> iter = mapTenantIdx.values().iterator();
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

	public void forgetMajorVersionByPPrjIdx( long TenantId,
		long ParentProjectId )
	{
		if( indexByPPrjIdx == null ) {
			return;
		}
		CFBamMajorVersionByPPrjIdxKey key = schema.getBackingStore().getFactoryMajorVersion().newPPrjIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		if( indexByPPrjIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamMajorVersionObj > mapPPrjIdx = indexByPPrjIdx.get( key );
			if( mapPPrjIdx != null ) {
				List<ICFBamMajorVersionObj> toForget = new LinkedList<ICFBamMajorVersionObj>();
				ICFBamMajorVersionObj cur = null;
				Iterator<ICFBamMajorVersionObj> iter = mapPPrjIdx.values().iterator();
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

			indexByPPrjIdx.remove( key );
		}
	}

	public void forgetMajorVersionByNameIdx( long TenantId,
		long ParentProjectId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		CFBamMajorVersionByNameIdxKey key = schema.getBackingStore().getFactoryMajorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			ICFBamMajorVersionObj probed = indexByNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByNameIdx.remove( key );
		}
	}

	public ICFBamMajorVersionObj createMajorVersion( ICFBamMajorVersionObj Obj ) {
		ICFBamMajorVersionObj obj = Obj;
		CFBamMajorVersionBuff buff = obj.getMajorVersionBuff();
		schema.getBackingStore().getTableMajorVersion().createMajorVersion(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "MJVR" ) ) {
			obj = (ICFBamMajorVersionObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamMajorVersionObj readMajorVersion( CFBamDomainBasePKey pkey ) {
		return( readMajorVersion( pkey, false ) );
	}

	public ICFBamMajorVersionObj readMajorVersion( CFBamDomainBasePKey pkey, boolean forceRead ) {
		ICFBamMajorVersionObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamMajorVersionBuff readBuff = schema.getBackingStore().getTableMajorVersion().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamMajorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamMajorVersionObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamMajorVersionObj lockMajorVersion( CFBamDomainBasePKey pkey ) {
		ICFBamMajorVersionObj locked = null;
		CFBamMajorVersionBuff lockBuff = schema.getBackingStore().getTableMajorVersion().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamMajorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamMajorVersionObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockMajorVersion", pkey );
		}
		return( locked );
	}

	public List<ICFBamMajorVersionObj> readAllMajorVersion() {
		return( readAllMajorVersion( false ) );
	}

	public List<ICFBamMajorVersionObj> readAllMajorVersion( boolean forceRead ) {
		final String S_ProcName = "readAllMajorVersion";
		if( ( allMajorVersion == null ) || forceRead ) {
			Map<CFBamDomainBasePKey, ICFBamMajorVersionObj> map = new HashMap<CFBamDomainBasePKey,ICFBamMajorVersionObj>();
			allMajorVersion = map;
			CFBamMajorVersionBuff[] buffList = schema.getBackingStore().getTableMajorVersion().readAllDerived( schema.getAuthorization() );
			CFBamMajorVersionBuff buff;
			ICFBamMajorVersionObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamMajorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamMajorVersionObj realized = (ICFBamMajorVersionObj)obj.realize();
			}
		}
		Comparator<ICFBamMajorVersionObj> cmp = new Comparator<ICFBamMajorVersionObj>() {
			public int compare( ICFBamMajorVersionObj lhs, ICFBamMajorVersionObj rhs ) {
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
		int len = allMajorVersion.size();
		ICFBamMajorVersionObj arr[] = new ICFBamMajorVersionObj[len];
		Iterator<ICFBamMajorVersionObj> valIter = allMajorVersion.values().iterator();
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
		ArrayList<ICFBamMajorVersionObj> arrayList = new ArrayList<ICFBamMajorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamMajorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamMajorVersionObj readMajorVersionByIdIdx( long TenantId,
		long Id )
	{
		return( readMajorVersionByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamMajorVersionObj readMajorVersionByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamMajorVersionObj obj = readMajorVersion( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamMajorVersionObj> readMajorVersionByTenantIdx( long TenantId )
	{
		return( readMajorVersionByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamMajorVersionObj> readMajorVersionByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readMajorVersionByTenantIdx";
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamDomainBasePKey, ICFBamMajorVersionObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamMajorVersionObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamMajorVersionObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamDomainBaseObj obj;
			CFBamDomainBaseBuff[] buffList = schema.getBackingStore().getTableDomainBase().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamDomainBaseBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamMajorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamMajorVersionObj realized = (ICFBamMajorVersionObj)obj.realize();
			}
		}
		Comparator<ICFBamMajorVersionObj> cmp = new Comparator<ICFBamMajorVersionObj>() {
			public int compare( ICFBamMajorVersionObj lhs, ICFBamMajorVersionObj rhs ) {
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
		ICFBamMajorVersionObj arr[] = new ICFBamMajorVersionObj[len];
		Iterator<ICFBamMajorVersionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamMajorVersionObj> arrayList = new ArrayList<ICFBamMajorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamMajorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamMajorVersionObj> readMajorVersionByPPrjIdx( long TenantId,
		long ParentProjectId )
	{
		return( readMajorVersionByPPrjIdx( TenantId,
			ParentProjectId,
			false ) );
	}

	public List<ICFBamMajorVersionObj> readMajorVersionByPPrjIdx( long TenantId,
		long ParentProjectId,
		boolean forceRead )
	{
		final String S_ProcName = "readMajorVersionByPPrjIdx";
		CFBamMajorVersionByPPrjIdxKey key = schema.getBackingStore().getFactoryMajorVersion().newPPrjIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		Map<CFBamDomainBasePKey, ICFBamMajorVersionObj> dict;
		if( indexByPPrjIdx == null ) {
			indexByPPrjIdx = new HashMap< CFBamMajorVersionByPPrjIdxKey,
				Map< CFBamDomainBasePKey, ICFBamMajorVersionObj > >();
		}
		if( ( ! forceRead ) && indexByPPrjIdx.containsKey( key ) ) {
			dict = indexByPPrjIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamMajorVersionObj>();
			// Allow other threads to dirty-read while we're loading
			indexByPPrjIdx.put( key, dict );
			ICFBamMajorVersionObj obj;
			CFBamMajorVersionBuff[] buffList = schema.getBackingStore().getTableMajorVersion().readDerivedByPPrjIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId );
			CFBamMajorVersionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamMajorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamMajorVersionObj realized = (ICFBamMajorVersionObj)obj.realize();
			}
		}
		Comparator<ICFBamMajorVersionObj> cmp = new Comparator<ICFBamMajorVersionObj>() {
			public int compare( ICFBamMajorVersionObj lhs, ICFBamMajorVersionObj rhs ) {
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
		ICFBamMajorVersionObj arr[] = new ICFBamMajorVersionObj[len];
		Iterator<ICFBamMajorVersionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamMajorVersionObj> arrayList = new ArrayList<ICFBamMajorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamMajorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamMajorVersionObj readMajorVersionByNameIdx( long TenantId,
		long ParentProjectId,
		String Name )
	{
		return( readMajorVersionByNameIdx( TenantId,
			ParentProjectId,
			Name,
			false ) );
	}

	public ICFBamMajorVersionObj readMajorVersionByNameIdx( long TenantId,
		long ParentProjectId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamMajorVersionByNameIdxKey,
				ICFBamMajorVersionObj >();
		}
		CFBamMajorVersionByNameIdxKey key = schema.getBackingStore().getFactoryMajorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		key.setRequiredName( Name );
		ICFBamMajorVersionObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFBamMajorVersionBuff buff = schema.getBackingStore().getTableMajorVersion().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId,
				Name );
			if( buff != null ) {
				obj = (ICFBamMajorVersionObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamMajorVersionObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamMajorVersionObj updateMajorVersion( ICFBamMajorVersionObj Obj ) {
		ICFBamMajorVersionObj obj = Obj;
		schema.getBackingStore().getTableMajorVersion().updateMajorVersion( schema.getAuthorization(),
			Obj.getMajorVersionBuff() );
		if( Obj.getClassCode().equals( "MJVR" ) ) {
			obj = (ICFBamMajorVersionObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteMajorVersion( ICFBamMajorVersionObj Obj ) {
		ICFBamMajorVersionObj obj = Obj;
		schema.getBackingStore().getTableMajorVersion().deleteMajorVersion( schema.getAuthorization(),
			obj.getMajorVersionBuff() );
		obj.forget( true );
	}

	public void deleteMajorVersionByIdIdx( long TenantId,
		long Id )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDomainBaseObj obj = readMajorVersion( pkey );
		if( obj != null ) {
			ICFBamMajorVersionEditObj editObj = (ICFBamMajorVersionEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamMajorVersionEditObj)obj.beginEdit();
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

	public void deleteMajorVersionByTenantIdx( long TenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamMajorVersionObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamMajorVersionObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableMajorVersion().deleteMajorVersionByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamMajorVersionObj> iter = dict.values().iterator();
			ICFBamMajorVersionObj obj;
			List<ICFBamMajorVersionObj> toForget = new LinkedList<ICFBamMajorVersionObj>();
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
			schema.getBackingStore().getTableMajorVersion().deleteMajorVersionByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteMajorVersionByPPrjIdx( long TenantId,
		long ParentProjectId )
	{
		CFBamMajorVersionByPPrjIdxKey key = schema.getBackingStore().getFactoryMajorVersion().newPPrjIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		if( indexByPPrjIdx == null ) {
			indexByPPrjIdx = new HashMap< CFBamMajorVersionByPPrjIdxKey,
				Map< CFBamDomainBasePKey, ICFBamMajorVersionObj > >();
		}
		if( indexByPPrjIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamMajorVersionObj> dict = indexByPPrjIdx.get( key );
			schema.getBackingStore().getTableMajorVersion().deleteMajorVersionByPPrjIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId );
			Iterator<ICFBamMajorVersionObj> iter = dict.values().iterator();
			ICFBamMajorVersionObj obj;
			List<ICFBamMajorVersionObj> toForget = new LinkedList<ICFBamMajorVersionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPPrjIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableMajorVersion().deleteMajorVersionByPPrjIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId );
		}
	}

	public void deleteMajorVersionByNameIdx( long TenantId,
		long ParentProjectId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFBamMajorVersionByNameIdxKey,
				ICFBamMajorVersionObj >();
		}
		CFBamMajorVersionByNameIdxKey key = schema.getBackingStore().getFactoryMajorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		key.setRequiredName( Name );
		ICFBamMajorVersionObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getBackingStore().getTableMajorVersion().deleteMajorVersionByNameIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableMajorVersion().deleteMajorVersionByNameIdx( schema.getAuthorization(),
				TenantId,
				ParentProjectId,
				Name );
		}
	}
}
