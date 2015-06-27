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

public class CFBamLicenseTableObj
	implements ICFBamLicenseTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamLicensePKey, ICFBamLicenseObj> members;
	private Map<CFBamLicensePKey, ICFBamLicenseObj> allLicense;
	private Map< CFBamLicenseByLicnTenantIdxKey,
		Map<CFBamLicensePKey, ICFBamLicenseObj > > indexByLicnTenantIdx;
	private Map< CFBamLicenseByDomainIdxKey,
		Map<CFBamLicensePKey, ICFBamLicenseObj > > indexByDomainIdx;
	private Map< CFBamLicenseByUNameIdxKey,
		ICFBamLicenseObj > indexByUNameIdx;
	public static String TABLE_NAME = "License";
	public static String TABLE_DBNAME = "licn";

	public CFBamLicenseTableObj() {
		schema = null;
		members = new HashMap<CFBamLicensePKey, ICFBamLicenseObj>();
		allLicense = null;
		indexByLicnTenantIdx = null;
		indexByDomainIdx = null;
		indexByUNameIdx = null;
	}

	public CFBamLicenseTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamLicensePKey, ICFBamLicenseObj>();
		allLicense = null;
		indexByLicnTenantIdx = null;
		indexByDomainIdx = null;
		indexByUNameIdx = null;
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
		allLicense = null;
		indexByLicnTenantIdx = null;
		indexByDomainIdx = null;
		indexByUNameIdx = null;
		List<ICFBamLicenseObj> toForget = new LinkedList<ICFBamLicenseObj>();
		ICFBamLicenseObj cur = null;
		Iterator<ICFBamLicenseObj> iter = members.values().iterator();
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
	 *	CFBamLicenseObj.
	 */
	public ICFBamLicenseObj newInstance() {
		ICFBamLicenseObj inst = new CFBamLicenseObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamLicenseObj.
	 */
	public ICFBamLicenseEditObj newEditInstance( ICFBamLicenseObj orig ) {
		ICFBamLicenseEditObj edit = new CFBamLicenseEditObj( orig );
		return( edit );
	}

	public ICFBamLicenseObj realizeLicense( ICFBamLicenseObj Obj ) {
		ICFBamLicenseObj obj = Obj;
		CFBamLicensePKey pkey = obj.getPKey();
		ICFBamLicenseObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamLicenseObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByLicnTenantIdx != null ) {
				CFBamLicenseByLicnTenantIdxKey keyLicnTenantIdx =
					schema.getBackingStore().getFactoryLicense().newLicnTenantIdxKey();
				keyLicnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamLicensePKey, ICFBamLicenseObj > mapLicnTenantIdx = indexByLicnTenantIdx.get( keyLicnTenantIdx );
				if( mapLicnTenantIdx != null ) {
					mapLicnTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamLicenseByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactoryLicense().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamLicensePKey, ICFBamLicenseObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamLicenseByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryLicense().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByLicnTenantIdx != null ) {
				CFBamLicenseByLicnTenantIdxKey keyLicnTenantIdx =
					schema.getBackingStore().getFactoryLicense().newLicnTenantIdxKey();
				keyLicnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamLicensePKey, ICFBamLicenseObj > mapLicnTenantIdx = indexByLicnTenantIdx.get( keyLicnTenantIdx );
				if( mapLicnTenantIdx != null ) {
					mapLicnTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamLicenseByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactoryLicense().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamLicensePKey, ICFBamLicenseObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamLicenseByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryLicense().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
			if( allLicense != null ) {
				allLicense.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allLicense != null ) {
				allLicense.put( keepObj.getPKey(), keepObj );
			}

			if( indexByLicnTenantIdx != null ) {
				CFBamLicenseByLicnTenantIdxKey keyLicnTenantIdx =
					schema.getBackingStore().getFactoryLicense().newLicnTenantIdxKey();
				keyLicnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamLicensePKey, ICFBamLicenseObj > mapLicnTenantIdx = indexByLicnTenantIdx.get( keyLicnTenantIdx );
				if( mapLicnTenantIdx != null ) {
					mapLicnTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamLicenseByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactoryLicense().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamLicensePKey, ICFBamLicenseObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamLicenseByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryLicense().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetLicense( ICFBamLicenseObj Obj ) {
		forgetLicense( Obj, false );
	}

	public void forgetLicense( ICFBamLicenseObj Obj, boolean forgetSubObjects ) {
		ICFBamLicenseObj obj = Obj;
		CFBamLicensePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamLicenseObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByLicnTenantIdx != null ) {
				CFBamLicenseByLicnTenantIdxKey keyLicnTenantIdx =
					schema.getBackingStore().getFactoryLicense().newLicnTenantIdxKey();
				keyLicnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamLicensePKey, ICFBamLicenseObj > mapLicnTenantIdx = indexByLicnTenantIdx.get( keyLicnTenantIdx );
				if( mapLicnTenantIdx != null ) {
					mapLicnTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByDomainIdx != null ) {
				CFBamLicenseByDomainIdxKey keyDomainIdx =
					schema.getBackingStore().getFactoryLicense().newDomainIdxKey();
				keyDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyDomainIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				Map<CFBamLicensePKey, ICFBamLicenseObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamLicenseByUNameIdxKey keyUNameIdx =
					schema.getBackingStore().getFactoryLicense().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredDomainId( keepObj.getRequiredDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allLicense != null ) {
				allLicense.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetLicenseByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamLicensePKey key = schema.getBackingStore().getFactoryLicense().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamLicenseObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetLicenseByLicnTenantIdx( long TenantId )
	{
		if( indexByLicnTenantIdx == null ) {
			return;
		}
		CFBamLicenseByLicnTenantIdxKey key = schema.getBackingStore().getFactoryLicense().newLicnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByLicnTenantIdx.containsKey( key ) ) {
			Map<CFBamLicensePKey, ICFBamLicenseObj > mapLicnTenantIdx = indexByLicnTenantIdx.get( key );
			if( mapLicnTenantIdx != null ) {
				List<ICFBamLicenseObj> toForget = new LinkedList<ICFBamLicenseObj>();
				ICFBamLicenseObj cur = null;
				Iterator<ICFBamLicenseObj> iter = mapLicnTenantIdx.values().iterator();
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

			indexByLicnTenantIdx.remove( key );
		}
	}

	public void forgetLicenseByDomainIdx( long TenantId,
		long DomainId )
	{
		if( indexByDomainIdx == null ) {
			return;
		}
		CFBamLicenseByDomainIdxKey key = schema.getBackingStore().getFactoryLicense().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		if( indexByDomainIdx.containsKey( key ) ) {
			Map<CFBamLicensePKey, ICFBamLicenseObj > mapDomainIdx = indexByDomainIdx.get( key );
			if( mapDomainIdx != null ) {
				List<ICFBamLicenseObj> toForget = new LinkedList<ICFBamLicenseObj>();
				ICFBamLicenseObj cur = null;
				Iterator<ICFBamLicenseObj> iter = mapDomainIdx.values().iterator();
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

	public void forgetLicenseByUNameIdx( long TenantId,
		long DomainId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		CFBamLicenseByUNameIdxKey key = schema.getBackingStore().getFactoryLicense().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			ICFBamLicenseObj probed = indexByUNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUNameIdx.remove( key );
		}
	}

	public ICFBamLicenseObj createLicense( ICFBamLicenseObj Obj ) {
		ICFBamLicenseObj obj = Obj;
		CFBamLicenseBuff buff = obj.getLicenseBuff();
		schema.getBackingStore().getTableLicense().createLicense(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamLicenseObj readLicense( CFBamLicensePKey pkey ) {
		return( readLicense( pkey, false ) );
	}

	public ICFBamLicenseObj readLicense( CFBamLicensePKey pkey, boolean forceRead ) {
		ICFBamLicenseObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamLicenseBuff readBuff = schema.getBackingStore().getTableLicense().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getLicenseTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryLicense().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamLicenseObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamLicenseObj lockLicense( CFBamLicensePKey pkey ) {
		ICFBamLicenseObj locked = null;
		CFBamLicenseBuff lockBuff = schema.getBackingStore().getTableLicense().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getLicenseTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryLicense().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamLicenseObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockLicense", pkey );
		}
		return( locked );
	}

	public List<ICFBamLicenseObj> readAllLicense() {
		return( readAllLicense( false ) );
	}

	public List<ICFBamLicenseObj> readAllLicense( boolean forceRead ) {
		final String S_ProcName = "readAllLicense";
		if( ( allLicense == null ) || forceRead ) {
			Map<CFBamLicensePKey, ICFBamLicenseObj> map = new HashMap<CFBamLicensePKey,ICFBamLicenseObj>();
			allLicense = map;
			CFBamLicenseBuff[] buffList = schema.getBackingStore().getTableLicense().readAllDerived( schema.getAuthorization() );
			CFBamLicenseBuff buff;
			ICFBamLicenseObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryLicense().newPKey() );
				obj.setBuff( buff );
				ICFBamLicenseObj realized = (ICFBamLicenseObj)obj.realize();
			}
		}
		Comparator<ICFBamLicenseObj> cmp = new Comparator<ICFBamLicenseObj>() {
			public int compare( ICFBamLicenseObj lhs, ICFBamLicenseObj rhs ) {
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
					CFBamLicensePKey lhsPKey = lhs.getPKey();
					CFBamLicensePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allLicense.size();
		ICFBamLicenseObj arr[] = new ICFBamLicenseObj[len];
		Iterator<ICFBamLicenseObj> valIter = allLicense.values().iterator();
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
		ArrayList<ICFBamLicenseObj> arrayList = new ArrayList<ICFBamLicenseObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamLicenseObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamLicenseObj readLicenseByIdIdx( long TenantId,
		long Id )
	{
		return( readLicenseByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamLicenseObj readLicenseByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamLicensePKey pkey = schema.getBackingStore().getFactoryLicense().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamLicenseObj obj = readLicense( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamLicenseObj> readLicenseByLicnTenantIdx( long TenantId )
	{
		return( readLicenseByLicnTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamLicenseObj> readLicenseByLicnTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readLicenseByLicnTenantIdx";
		CFBamLicenseByLicnTenantIdxKey key = schema.getBackingStore().getFactoryLicense().newLicnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamLicensePKey, ICFBamLicenseObj> dict;
		if( indexByLicnTenantIdx == null ) {
			indexByLicnTenantIdx = new HashMap< CFBamLicenseByLicnTenantIdxKey,
				Map< CFBamLicensePKey, ICFBamLicenseObj > >();
		}
		if( ( ! forceRead ) && indexByLicnTenantIdx.containsKey( key ) ) {
			dict = indexByLicnTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamLicensePKey, ICFBamLicenseObj>();
			// Allow other threads to dirty-read while we're loading
			indexByLicnTenantIdx.put( key, dict );
			ICFBamLicenseObj obj;
			CFBamLicenseBuff[] buffList = schema.getBackingStore().getTableLicense().readDerivedByLicnTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamLicenseBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getLicenseTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryLicense().newPKey() );
				obj.setBuff( buff );
				ICFBamLicenseObj realized = (ICFBamLicenseObj)obj.realize();
			}
		}
		Comparator<ICFBamLicenseObj> cmp = new Comparator<ICFBamLicenseObj>() {
			public int compare( ICFBamLicenseObj lhs, ICFBamLicenseObj rhs ) {
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
					CFBamLicensePKey lhsPKey = lhs.getPKey();
					CFBamLicensePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamLicenseObj arr[] = new ICFBamLicenseObj[len];
		Iterator<ICFBamLicenseObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamLicenseObj> arrayList = new ArrayList<ICFBamLicenseObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamLicenseObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamLicenseObj> readLicenseByDomainIdx( long TenantId,
		long DomainId )
	{
		return( readLicenseByDomainIdx( TenantId,
			DomainId,
			false ) );
	}

	public List<ICFBamLicenseObj> readLicenseByDomainIdx( long TenantId,
		long DomainId,
		boolean forceRead )
	{
		final String S_ProcName = "readLicenseByDomainIdx";
		CFBamLicenseByDomainIdxKey key = schema.getBackingStore().getFactoryLicense().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		Map<CFBamLicensePKey, ICFBamLicenseObj> dict;
		if( indexByDomainIdx == null ) {
			indexByDomainIdx = new HashMap< CFBamLicenseByDomainIdxKey,
				Map< CFBamLicensePKey, ICFBamLicenseObj > >();
		}
		if( ( ! forceRead ) && indexByDomainIdx.containsKey( key ) ) {
			dict = indexByDomainIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamLicensePKey, ICFBamLicenseObj>();
			// Allow other threads to dirty-read while we're loading
			indexByDomainIdx.put( key, dict );
			ICFBamLicenseObj obj;
			CFBamLicenseBuff[] buffList = schema.getBackingStore().getTableLicense().readDerivedByDomainIdx( schema.getAuthorization(),
				TenantId,
				DomainId );
			CFBamLicenseBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getLicenseTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryLicense().newPKey() );
				obj.setBuff( buff );
				ICFBamLicenseObj realized = (ICFBamLicenseObj)obj.realize();
			}
		}
		Comparator<ICFBamLicenseObj> cmp = new Comparator<ICFBamLicenseObj>() {
			public int compare( ICFBamLicenseObj lhs, ICFBamLicenseObj rhs ) {
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
					CFBamLicensePKey lhsPKey = lhs.getPKey();
					CFBamLicensePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamLicenseObj arr[] = new ICFBamLicenseObj[len];
		Iterator<ICFBamLicenseObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamLicenseObj> arrayList = new ArrayList<ICFBamLicenseObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamLicenseObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamLicenseObj readLicenseByUNameIdx( long TenantId,
		long DomainId,
		String Name )
	{
		return( readLicenseByUNameIdx( TenantId,
			DomainId,
			Name,
			false ) );
	}

	public ICFBamLicenseObj readLicenseByUNameIdx( long TenantId,
		long DomainId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamLicenseByUNameIdxKey,
				ICFBamLicenseObj >();
		}
		CFBamLicenseByUNameIdxKey key = schema.getBackingStore().getFactoryLicense().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );
		ICFBamLicenseObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamLicenseBuff buff = schema.getBackingStore().getTableLicense().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				DomainId,
				Name );
			if( buff != null ) {
				obj = schema.getLicenseTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryLicense().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamLicenseObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamLicenseObj updateLicense( ICFBamLicenseObj Obj ) {
		ICFBamLicenseObj obj = Obj;
		schema.getBackingStore().getTableLicense().updateLicense( schema.getAuthorization(),
			Obj.getLicenseBuff() );
		obj = (ICFBamLicenseObj)Obj.realize();
		return( obj );
	}

	public void deleteLicense( ICFBamLicenseObj Obj ) {
		ICFBamLicenseObj obj = Obj;
		schema.getBackingStore().getTableLicense().deleteLicense( schema.getAuthorization(),
			obj.getLicenseBuff() );
		obj.forget( true );
	}

	public void deleteLicenseByIdIdx( long TenantId,
		long Id )
	{
		CFBamLicensePKey pkey = schema.getBackingStore().getFactoryLicense().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamLicenseObj obj = readLicense( pkey );
		if( obj != null ) {
			ICFBamLicenseEditObj editObj = (ICFBamLicenseEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamLicenseEditObj)obj.beginEdit();
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

	public void deleteLicenseByLicnTenantIdx( long TenantId )
	{
		CFBamLicenseByLicnTenantIdxKey key = schema.getBackingStore().getFactoryLicense().newLicnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByLicnTenantIdx == null ) {
			indexByLicnTenantIdx = new HashMap< CFBamLicenseByLicnTenantIdxKey,
				Map< CFBamLicensePKey, ICFBamLicenseObj > >();
		}
		if( indexByLicnTenantIdx.containsKey( key ) ) {
			Map<CFBamLicensePKey, ICFBamLicenseObj> dict = indexByLicnTenantIdx.get( key );
			schema.getBackingStore().getTableLicense().deleteLicenseByLicnTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamLicenseObj> iter = dict.values().iterator();
			ICFBamLicenseObj obj;
			List<ICFBamLicenseObj> toForget = new LinkedList<ICFBamLicenseObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByLicnTenantIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableLicense().deleteLicenseByLicnTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteLicenseByDomainIdx( long TenantId,
		long DomainId )
	{
		CFBamLicenseByDomainIdxKey key = schema.getBackingStore().getFactoryLicense().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		if( indexByDomainIdx == null ) {
			indexByDomainIdx = new HashMap< CFBamLicenseByDomainIdxKey,
				Map< CFBamLicensePKey, ICFBamLicenseObj > >();
		}
		if( indexByDomainIdx.containsKey( key ) ) {
			Map<CFBamLicensePKey, ICFBamLicenseObj> dict = indexByDomainIdx.get( key );
			schema.getBackingStore().getTableLicense().deleteLicenseByDomainIdx( schema.getAuthorization(),
				TenantId,
				DomainId );
			Iterator<ICFBamLicenseObj> iter = dict.values().iterator();
			ICFBamLicenseObj obj;
			List<ICFBamLicenseObj> toForget = new LinkedList<ICFBamLicenseObj>();
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
			schema.getBackingStore().getTableLicense().deleteLicenseByDomainIdx( schema.getAuthorization(),
				TenantId,
				DomainId );
		}
	}

	public void deleteLicenseByUNameIdx( long TenantId,
		long DomainId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamLicenseByUNameIdxKey,
				ICFBamLicenseObj >();
		}
		CFBamLicenseByUNameIdxKey key = schema.getBackingStore().getFactoryLicense().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );
		ICFBamLicenseObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBackingStore().getTableLicense().deleteLicenseByUNameIdx( schema.getAuthorization(),
				TenantId,
				DomainId,
				Name );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableLicense().deleteLicenseByUNameIdx( schema.getAuthorization(),
				TenantId,
				DomainId,
				Name );
		}
	}
}
