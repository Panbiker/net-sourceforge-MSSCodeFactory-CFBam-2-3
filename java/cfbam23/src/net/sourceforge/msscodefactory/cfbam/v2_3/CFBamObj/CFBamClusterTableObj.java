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

public class CFBamClusterTableObj
	implements ICFBamClusterTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamClusterPKey, ICFBamClusterObj> members;
	private Map<CFBamClusterPKey, ICFBamClusterObj> allCluster;
	private Map< CFBamClusterByUDomainNameIdxKey,
		ICFBamClusterObj > indexByUDomainNameIdx;
	private Map< CFBamClusterByUDescrIdxKey,
		ICFBamClusterObj > indexByUDescrIdx;
	public static String TABLE_NAME = "Cluster";
	public static String TABLE_DBNAME = "clus";

	public CFBamClusterTableObj() {
		schema = null;
		members = new HashMap<CFBamClusterPKey, ICFBamClusterObj>();
		allCluster = null;
		indexByUDomainNameIdx = null;
		indexByUDescrIdx = null;
	}

	public CFBamClusterTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamClusterPKey, ICFBamClusterObj>();
		allCluster = null;
		indexByUDomainNameIdx = null;
		indexByUDescrIdx = null;
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
		allCluster = null;
		indexByUDomainNameIdx = null;
		indexByUDescrIdx = null;
		List<ICFBamClusterObj> toForget = new LinkedList<ICFBamClusterObj>();
		ICFBamClusterObj cur = null;
		Iterator<ICFBamClusterObj> iter = members.values().iterator();
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
	 *	CFBamClusterObj.
	 */
	public ICFBamClusterObj newInstance() {
		ICFBamClusterObj inst = new CFBamClusterObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamClusterObj.
	 */
	public ICFBamClusterEditObj newEditInstance( ICFBamClusterObj orig ) {
		ICFBamClusterEditObj edit = new CFBamClusterEditObj( orig );
		return( edit );
	}

	public ICFBamClusterObj realizeCluster( ICFBamClusterObj Obj ) {
		ICFBamClusterObj obj = Obj;
		CFBamClusterPKey pkey = obj.getPKey();
		ICFBamClusterObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamClusterObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUDomainNameIdx != null ) {
				CFBamClusterByUDomainNameIdxKey keyUDomainNameIdx =
					schema.getBackingStore().getFactoryCluster().newUDomainNameIdxKey();
				keyUDomainNameIdx.setRequiredFullDomainName( keepObj.getRequiredFullDomainName() );
				indexByUDomainNameIdx.remove( keyUDomainNameIdx );
			}

			if( indexByUDescrIdx != null ) {
				CFBamClusterByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryCluster().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUDomainNameIdx != null ) {
				CFBamClusterByUDomainNameIdxKey keyUDomainNameIdx =
					schema.getBackingStore().getFactoryCluster().newUDomainNameIdxKey();
				keyUDomainNameIdx.setRequiredFullDomainName( keepObj.getRequiredFullDomainName() );
				indexByUDomainNameIdx.put( keyUDomainNameIdx, keepObj );
			}

			if( indexByUDescrIdx != null ) {
				CFBamClusterByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryCluster().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}
			if( allCluster != null ) {
				allCluster.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allCluster != null ) {
				allCluster.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUDomainNameIdx != null ) {
				CFBamClusterByUDomainNameIdxKey keyUDomainNameIdx =
					schema.getBackingStore().getFactoryCluster().newUDomainNameIdxKey();
				keyUDomainNameIdx.setRequiredFullDomainName( keepObj.getRequiredFullDomainName() );
				indexByUDomainNameIdx.put( keyUDomainNameIdx, keepObj );
			}

			if( indexByUDescrIdx != null ) {
				CFBamClusterByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryCluster().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetCluster( ICFBamClusterObj Obj ) {
		forgetCluster( Obj, false );
	}

	public void forgetCluster( ICFBamClusterObj Obj, boolean forgetSubObjects ) {
		ICFBamClusterObj obj = Obj;
		CFBamClusterPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamClusterObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUDomainNameIdx != null ) {
				CFBamClusterByUDomainNameIdxKey keyUDomainNameIdx =
					schema.getBackingStore().getFactoryCluster().newUDomainNameIdxKey();
				keyUDomainNameIdx.setRequiredFullDomainName( keepObj.getRequiredFullDomainName() );
				indexByUDomainNameIdx.remove( keyUDomainNameIdx );
			}

			if( indexByUDescrIdx != null ) {
				CFBamClusterByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryCluster().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			if( allCluster != null ) {
				allCluster.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				schema.getHostNodeTableObj().forgetHostNodeByClusterIdx( keepObj.getRequiredId() );
				schema.getTenantTableObj().forgetTenantByClusterIdx( keepObj.getRequiredId() );
				schema.getSecAppTableObj().forgetSecAppByClusterIdx( keepObj.getRequiredId() );
				schema.getSecGroupTableObj().forgetSecGroupByClusterIdx( keepObj.getRequiredId() );
				schema.getSysClusterTableObj().forgetSysClusterByClusterIdx( keepObj.getRequiredId() );
			}
		}
	}

	public void forgetClusterByIdIdx( long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamClusterPKey key = schema.getBackingStore().getFactoryCluster().newPKey();
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamClusterObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetClusterByUDomainNameIdx( String FullDomainName )
	{
		if( indexByUDomainNameIdx == null ) {
			return;
		}
		CFBamClusterByUDomainNameIdxKey key = schema.getBackingStore().getFactoryCluster().newUDomainNameIdxKey();
		key.setRequiredFullDomainName( FullDomainName );
		if( indexByUDomainNameIdx.containsKey( key ) ) {
			ICFBamClusterObj probed = indexByUDomainNameIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUDomainNameIdx.remove( key );
		}
	}

	public void forgetClusterByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			return;
		}
		CFBamClusterByUDescrIdxKey key = schema.getBackingStore().getFactoryCluster().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		if( indexByUDescrIdx.containsKey( key ) ) {
			ICFBamClusterObj probed = indexByUDescrIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUDescrIdx.remove( key );
		}
	}

	public ICFBamClusterObj createCluster( ICFBamClusterObj Obj ) {
		ICFBamClusterObj obj = Obj;
		CFBamClusterBuff buff = obj.getClusterBuff();
		schema.getBackingStore().getTableCluster().createCluster(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamClusterObj readCluster( CFBamClusterPKey pkey ) {
		return( readCluster( pkey, false ) );
	}

	public ICFBamClusterObj readCluster( CFBamClusterPKey pkey, boolean forceRead ) {
		ICFBamClusterObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamClusterBuff readBuff = schema.getBackingStore().getTableCluster().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getClusterTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryCluster().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamClusterObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamClusterObj lockCluster( CFBamClusterPKey pkey ) {
		ICFBamClusterObj locked = null;
		CFBamClusterBuff lockBuff = schema.getBackingStore().getTableCluster().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getClusterTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryCluster().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamClusterObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockCluster", pkey );
		}
		return( locked );
	}

	public List<ICFBamClusterObj> readAllCluster() {
		return( readAllCluster( false ) );
	}

	public List<ICFBamClusterObj> readAllCluster( boolean forceRead ) {
		final String S_ProcName = "readAllCluster";
		if( ( allCluster == null ) || forceRead ) {
			Map<CFBamClusterPKey, ICFBamClusterObj> map = new HashMap<CFBamClusterPKey,ICFBamClusterObj>();
			allCluster = map;
			CFBamClusterBuff[] buffList = schema.getBackingStore().getTableCluster().readAllDerived( schema.getAuthorization() );
			CFBamClusterBuff buff;
			ICFBamClusterObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryCluster().newPKey() );
				obj.setBuff( buff );
				ICFBamClusterObj realized = (ICFBamClusterObj)obj.realize();
			}
		}
		Comparator<ICFBamClusterObj> cmp = new Comparator<ICFBamClusterObj>() {
			public int compare( ICFBamClusterObj lhs, ICFBamClusterObj rhs ) {
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
					CFBamClusterPKey lhsPKey = lhs.getPKey();
					CFBamClusterPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allCluster.size();
		ICFBamClusterObj arr[] = new ICFBamClusterObj[len];
		Iterator<ICFBamClusterObj> valIter = allCluster.values().iterator();
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
		ArrayList<ICFBamClusterObj> arrayList = new ArrayList<ICFBamClusterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamClusterObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamClusterObj readClusterByIdIdx( long Id )
	{
		return( readClusterByIdIdx( Id,
			false ) );
	}

	public ICFBamClusterObj readClusterByIdIdx( long Id, boolean forceRead )
	{
		CFBamClusterPKey pkey = schema.getBackingStore().getFactoryCluster().newPKey();
		pkey.setRequiredId( Id );
		ICFBamClusterObj obj = readCluster( pkey, forceRead );
		return( obj );
	}

	public ICFBamClusterObj readClusterByUDomainNameIdx( String FullDomainName )
	{
		return( readClusterByUDomainNameIdx( FullDomainName,
			false ) );
	}

	public ICFBamClusterObj readClusterByUDomainNameIdx( String FullDomainName, boolean forceRead )
	{
		if( indexByUDomainNameIdx == null ) {
			indexByUDomainNameIdx = new HashMap< CFBamClusterByUDomainNameIdxKey,
				ICFBamClusterObj >();
		}
		CFBamClusterByUDomainNameIdxKey key = schema.getBackingStore().getFactoryCluster().newUDomainNameIdxKey();
		key.setRequiredFullDomainName( FullDomainName );
		ICFBamClusterObj obj = null;
		if( ( ! forceRead ) && indexByUDomainNameIdx.containsKey( key ) ) {
			obj = indexByUDomainNameIdx.get( key );
		}
		else {
			CFBamClusterBuff buff = schema.getBackingStore().getTableCluster().readDerivedByUDomainNameIdx( schema.getAuthorization(),
				FullDomainName );
			if( buff != null ) {
				obj = schema.getClusterTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryCluster().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamClusterObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUDomainNameIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamClusterObj readClusterByUDescrIdx( String Description )
	{
		return( readClusterByUDescrIdx( Description,
			false ) );
	}

	public ICFBamClusterObj readClusterByUDescrIdx( String Description, boolean forceRead )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFBamClusterByUDescrIdxKey,
				ICFBamClusterObj >();
		}
		CFBamClusterByUDescrIdxKey key = schema.getBackingStore().getFactoryCluster().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		ICFBamClusterObj obj = null;
		if( ( ! forceRead ) && indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
		}
		else {
			CFBamClusterBuff buff = schema.getBackingStore().getTableCluster().readDerivedByUDescrIdx( schema.getAuthorization(),
				Description );
			if( buff != null ) {
				obj = schema.getClusterTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryCluster().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamClusterObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUDescrIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamClusterObj updateCluster( ICFBamClusterObj Obj ) {
		ICFBamClusterObj obj = Obj;
		schema.getBackingStore().getTableCluster().updateCluster( schema.getAuthorization(),
			Obj.getClusterBuff() );
		obj = (ICFBamClusterObj)Obj.realize();
		return( obj );
	}

	public void deleteCluster( ICFBamClusterObj Obj ) {
		ICFBamClusterObj obj = Obj;
		schema.getBackingStore().getTableCluster().deleteCluster( schema.getAuthorization(),
			obj.getClusterBuff() );
		obj.forget( true );
	}

	public void deleteClusterByIdIdx( long Id )
	{
		CFBamClusterPKey pkey = schema.getBackingStore().getFactoryCluster().newPKey();
		pkey.setRequiredId( Id );
		ICFBamClusterObj obj = readCluster( pkey );
		if( obj != null ) {
			ICFBamClusterEditObj editObj = (ICFBamClusterEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamClusterEditObj)obj.beginEdit();
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

	public void deleteClusterByUDomainNameIdx( String FullDomainName )
	{
		if( indexByUDomainNameIdx == null ) {
			indexByUDomainNameIdx = new HashMap< CFBamClusterByUDomainNameIdxKey,
				ICFBamClusterObj >();
		}
		CFBamClusterByUDomainNameIdxKey key = schema.getBackingStore().getFactoryCluster().newUDomainNameIdxKey();
		key.setRequiredFullDomainName( FullDomainName );
		ICFBamClusterObj obj = null;
		if( indexByUDomainNameIdx.containsKey( key ) ) {
			obj = indexByUDomainNameIdx.get( key );
			schema.getBackingStore().getTableCluster().deleteClusterByUDomainNameIdx( schema.getAuthorization(),
				FullDomainName );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableCluster().deleteClusterByUDomainNameIdx( schema.getAuthorization(),
				FullDomainName );
		}
	}

	public void deleteClusterByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFBamClusterByUDescrIdxKey,
				ICFBamClusterObj >();
		}
		CFBamClusterByUDescrIdxKey key = schema.getBackingStore().getFactoryCluster().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		ICFBamClusterObj obj = null;
		if( indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
			schema.getBackingStore().getTableCluster().deleteClusterByUDescrIdx( schema.getAuthorization(),
				Description );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableCluster().deleteClusterByUDescrIdx( schema.getAuthorization(),
				Description );
		}
	}

	public ICFBamClusterObj getSystemCluster() {
		boolean transactionStarted = schema.beginTransaction();
		ICFBamClusterObj clusterObj;
		try {
			schema.getAuditActionTableObj().bootstrapAuditActions();
			clusterObj = readClusterByUDomainNameIdx( "system" );
			if( clusterObj == null ) {
				clusterObj = newInstance();
				ICFBamClusterEditObj clusterEdit = clusterObj.beginEdit();
				clusterEdit.setRequiredFullDomainName( "system" );
				clusterObj = clusterEdit.create();
				clusterEdit.endEdit();
			}
			if( transactionStarted ) {
				schema.commit();
			}
		}
		catch( RuntimeException e ) {
			if( transactionStarted ) {
				try {
					schema.rollback();
				}
				catch( Exception e2 ) {
				}
			}
			throw e;
		}
		return( clusterObj );
	}
}
