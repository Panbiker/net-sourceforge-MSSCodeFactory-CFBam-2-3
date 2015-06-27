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

public class CFBamDomainBaseTableObj
	implements ICFBamDomainBaseTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamDomainBasePKey, ICFBamDomainBaseObj> members;
	private Map<CFBamDomainBasePKey, ICFBamDomainBaseObj> allDomainBase;
	private Map< CFBamDomainBaseByTenantIdxKey,
		Map<CFBamDomainBasePKey, ICFBamDomainBaseObj > > indexByTenantIdx;
	public static String TABLE_NAME = "DomainBase";
	public static String TABLE_DBNAME = "bdomdef";

	public CFBamDomainBaseTableObj() {
		schema = null;
		members = new HashMap<CFBamDomainBasePKey, ICFBamDomainBaseObj>();
		allDomainBase = null;
		indexByTenantIdx = null;
	}

	public CFBamDomainBaseTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamDomainBasePKey, ICFBamDomainBaseObj>();
		allDomainBase = null;
		indexByTenantIdx = null;
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
		allDomainBase = null;
		indexByTenantIdx = null;
		List<ICFBamDomainBaseObj> toForget = new LinkedList<ICFBamDomainBaseObj>();
		ICFBamDomainBaseObj cur = null;
		Iterator<ICFBamDomainBaseObj> iter = members.values().iterator();
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
	 *	CFBamDomainBaseObj.
	 */
	public ICFBamDomainBaseObj newInstance() {
		ICFBamDomainBaseObj inst = new CFBamDomainBaseObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamDomainBaseObj.
	 */
	public ICFBamDomainBaseEditObj newEditInstance( ICFBamDomainBaseObj orig ) {
		ICFBamDomainBaseEditObj edit = new CFBamDomainBaseEditObj( orig );
		return( edit );
	}

	public ICFBamDomainBaseObj constructByClassCode( String argClassCode ) {
		ICFBamDomainBaseObj obj = null;
		if( argClassCode.equals( "BDOM" ) ) {
			obj = schema.getDomainBaseTableObj().newInstance();
		}
		else if( argClassCode.equals( "TDOM" ) ) {
			obj = schema.getTopDomainTableObj().newInstance();
		}
		else if( argClassCode.equals( "DOMN" ) ) {
			obj = schema.getDomainTableObj().newInstance();
		}
		else if( argClassCode.equals( "BPRJ" ) ) {
			obj = schema.getProjectBaseTableObj().newInstance();
		}
		else if( argClassCode.equals( "RPRJ" ) ) {
			obj = schema.getRealProjectTableObj().newInstance();
		}
		else if( argClassCode.equals( "TPRJ" ) ) {
			obj = schema.getTopProjectTableObj().newInstance();
		}
		else if( argClassCode.equals( "SPRJ" ) ) {
			obj = schema.getSubProjectTableObj().newInstance();
		}
		else if( argClassCode.equals( "VERN" ) ) {
			obj = schema.getVersionTableObj().newInstance();
		}
		else if( argClassCode.equals( "MJVR" ) ) {
			obj = schema.getMajorVersionTableObj().newInstance();
		}
		else if( argClassCode.equals( "MNVR" ) ) {
			obj = schema.getMinorVersionTableObj().newInstance();
		}
		return( obj );
	}

	public ICFBamDomainBaseObj realizeDomainBase( ICFBamDomainBaseObj Obj ) {
		ICFBamDomainBaseObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		ICFBamDomainBaseObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamDomainBaseObj existingObj = members.get( pkey );
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
				Map<CFBamDomainBasePKey, ICFBamDomainBaseObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamDomainBaseObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allDomainBase != null ) {
				allDomainBase.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDomainBase != null ) {
				allDomainBase.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamDomainBaseObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetDomainBase( ICFBamDomainBaseObj Obj ) {
		forgetDomainBase( Obj, false );
	}

	public void forgetDomainBase( ICFBamDomainBaseObj Obj, boolean forgetSubObjects ) {
		ICFBamDomainBaseObj obj = Obj;
		CFBamDomainBasePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamDomainBaseObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamDomainBaseByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamDomainBasePKey, ICFBamDomainBaseObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( allDomainBase != null ) {
				allDomainBase.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getSchemaDefTableObj().forgetSchemaDefByDomainIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				schema.getLicenseTableObj().forgetLicenseByDomainIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
	}

	public void forgetDomainBaseByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamDomainBasePKey key = schema.getBackingStore().getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamDomainBaseObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetDomainBaseByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamDomainBaseObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamDomainBaseObj> toForget = new LinkedList<ICFBamDomainBaseObj>();
				ICFBamDomainBaseObj cur = null;
				Iterator<ICFBamDomainBaseObj> iter = mapTenantIdx.values().iterator();
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

	public ICFBamDomainBaseObj createDomainBase( ICFBamDomainBaseObj Obj ) {
		ICFBamDomainBaseObj obj = Obj;
		CFBamDomainBaseBuff buff = obj.getDomainBaseBuff();
		schema.getBackingStore().getTableDomainBase().createDomainBase(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "BDOM" ) ) {
			obj = (ICFBamDomainBaseObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamDomainBaseObj readDomainBase( CFBamDomainBasePKey pkey ) {
		return( readDomainBase( pkey, false ) );
	}

	public ICFBamDomainBaseObj readDomainBase( CFBamDomainBasePKey pkey, boolean forceRead ) {
		ICFBamDomainBaseObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamDomainBaseBuff readBuff = schema.getBackingStore().getTableDomainBase().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamDomainBaseObj)schema.getDomainBaseTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamDomainBaseObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamDomainBaseObj lockDomainBase( CFBamDomainBasePKey pkey ) {
		ICFBamDomainBaseObj locked = null;
		CFBamDomainBaseBuff lockBuff = schema.getBackingStore().getTableDomainBase().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamDomainBaseObj)schema.getDomainBaseTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamDomainBaseObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockDomainBase", pkey );
		}
		return( locked );
	}

	public List<ICFBamDomainBaseObj> readAllDomainBase() {
		return( readAllDomainBase( false ) );
	}

	public List<ICFBamDomainBaseObj> readAllDomainBase( boolean forceRead ) {
		final String S_ProcName = "readAllDomainBase";
		if( ( allDomainBase == null ) || forceRead ) {
			Map<CFBamDomainBasePKey, ICFBamDomainBaseObj> map = new HashMap<CFBamDomainBasePKey,ICFBamDomainBaseObj>();
			allDomainBase = map;
			CFBamDomainBaseBuff[] buffList = schema.getBackingStore().getTableDomainBase().readAllDerived( schema.getAuthorization() );
			CFBamDomainBaseBuff buff;
			ICFBamDomainBaseObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDomainBaseObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamDomainBaseObj realized = (ICFBamDomainBaseObj)obj.realize();
			}
		}
		Comparator<ICFBamDomainBaseObj> cmp = new Comparator<ICFBamDomainBaseObj>() {
			public int compare( ICFBamDomainBaseObj lhs, ICFBamDomainBaseObj rhs ) {
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
		int len = allDomainBase.size();
		ICFBamDomainBaseObj arr[] = new ICFBamDomainBaseObj[len];
		Iterator<ICFBamDomainBaseObj> valIter = allDomainBase.values().iterator();
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
		ArrayList<ICFBamDomainBaseObj> arrayList = new ArrayList<ICFBamDomainBaseObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDomainBaseObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDomainBaseObj readDomainBaseByIdIdx( long TenantId,
		long Id )
	{
		return( readDomainBaseByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamDomainBaseObj readDomainBaseByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDomainBaseObj obj = readDomainBase( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamDomainBaseObj> readDomainBaseByTenantIdx( long TenantId )
	{
		return( readDomainBaseByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamDomainBaseObj> readDomainBaseByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDomainBaseByTenantIdx";
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamDomainBasePKey, ICFBamDomainBaseObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamDomainBaseObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamDomainBasePKey, ICFBamDomainBaseObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamDomainBaseObj obj;
			CFBamDomainBaseBuff[] buffList = schema.getBackingStore().getTableDomainBase().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamDomainBaseBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamDomainBaseObj)schema.getDomainBaseTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryDomainBase().newPKey() );
				obj.setBuff( buff );
				ICFBamDomainBaseObj realized = (ICFBamDomainBaseObj)obj.realize();
			}
		}
		Comparator<ICFBamDomainBaseObj> cmp = new Comparator<ICFBamDomainBaseObj>() {
			public int compare( ICFBamDomainBaseObj lhs, ICFBamDomainBaseObj rhs ) {
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
		ICFBamDomainBaseObj arr[] = new ICFBamDomainBaseObj[len];
		Iterator<ICFBamDomainBaseObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamDomainBaseObj> arrayList = new ArrayList<ICFBamDomainBaseObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamDomainBaseObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamDomainBaseObj updateDomainBase( ICFBamDomainBaseObj Obj ) {
		ICFBamDomainBaseObj obj = Obj;
		schema.getBackingStore().getTableDomainBase().updateDomainBase( schema.getAuthorization(),
			Obj.getDomainBaseBuff() );
		if( Obj.getClassCode().equals( "BDOM" ) ) {
			obj = (ICFBamDomainBaseObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteDomainBase( ICFBamDomainBaseObj Obj ) {
		ICFBamDomainBaseObj obj = Obj;
		schema.getBackingStore().getTableDomainBase().deleteDomainBase( schema.getAuthorization(),
			obj.getDomainBaseBuff() );
		obj.forget( true );
	}

	public void deleteDomainBaseByIdIdx( long TenantId,
		long Id )
	{
		CFBamDomainBasePKey pkey = schema.getBackingStore().getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamDomainBaseObj obj = readDomainBase( pkey );
		if( obj != null ) {
			ICFBamDomainBaseEditObj editObj = (ICFBamDomainBaseEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamDomainBaseEditObj)obj.beginEdit();
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

	public void deleteDomainBaseByTenantIdx( long TenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getBackingStore().getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey, ICFBamDomainBaseObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamDomainBasePKey, ICFBamDomainBaseObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableDomainBase().deleteDomainBaseByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamDomainBaseObj> iter = dict.values().iterator();
			ICFBamDomainBaseObj obj;
			List<ICFBamDomainBaseObj> toForget = new LinkedList<ICFBamDomainBaseObj>();
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
			schema.getBackingStore().getTableDomainBase().deleteDomainBaseByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}
}
