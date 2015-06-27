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

public class CFBamScopeTableObj
	implements ICFBamScopeTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamScopePKey, ICFBamScopeObj> members;
	private Map<CFBamScopePKey, ICFBamScopeObj> allScope;
	private Map< CFBamScopeByTenantIdxKey,
		Map<CFBamScopePKey, ICFBamScopeObj > > indexByTenantIdx;
	public static String TABLE_NAME = "Scope";
	public static String TABLE_DBNAME = "scopedef";

	public CFBamScopeTableObj() {
		schema = null;
		members = new HashMap<CFBamScopePKey, ICFBamScopeObj>();
		allScope = null;
		indexByTenantIdx = null;
	}

	public CFBamScopeTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamScopePKey, ICFBamScopeObj>();
		allScope = null;
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
		allScope = null;
		indexByTenantIdx = null;
		List<ICFBamScopeObj> toForget = new LinkedList<ICFBamScopeObj>();
		ICFBamScopeObj cur = null;
		Iterator<ICFBamScopeObj> iter = members.values().iterator();
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
	 *	CFBamScopeObj.
	 */
	public ICFBamScopeObj newInstance() {
		ICFBamScopeObj inst = new CFBamScopeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamScopeObj.
	 */
	public ICFBamScopeEditObj newEditInstance( ICFBamScopeObj orig ) {
		ICFBamScopeEditObj edit = new CFBamScopeEditObj( orig );
		return( edit );
	}

	public ICFBamScopeObj constructByClassCode( String argClassCode ) {
		ICFBamScopeObj obj = null;
		if( argClassCode.equals( "SCOP" ) ) {
			obj = schema.getScopeTableObj().newInstance();
		}
		else if( argClassCode.equals( "SCHM" ) ) {
			obj = schema.getSchemaDefTableObj().newInstance();
		}
		else if( argClassCode.equals( "SCRF" ) ) {
			obj = schema.getSchemaRefTableObj().newInstance();
		}
		else if( argClassCode.equals( "TBLD" ) ) {
			obj = schema.getTableTableObj().newInstance();
		}
		else if( argClassCode.equals( "DELD" ) ) {
			obj = schema.getDelDepTableObj().newInstance();
		}
		else if( argClassCode.equals( "DELT" ) ) {
			obj = schema.getDelTopDepTableObj().newInstance();
		}
		else if( argClassCode.equals( "DEL1" ) ) {
			obj = schema.getDelSubDep1TableObj().newInstance();
		}
		else if( argClassCode.equals( "DEL2" ) ) {
			obj = schema.getDelSubDep2TableObj().newInstance();
		}
		else if( argClassCode.equals( "DEL3" ) ) {
			obj = schema.getDelSubDep3TableObj().newInstance();
		}
		else if( argClassCode.equals( "IDXD" ) ) {
			obj = schema.getIndexTableObj().newInstance();
		}
		else if( argClassCode.equals( "RELD" ) ) {
			obj = schema.getRelationTableObj().newInstance();
		}
		else if( argClassCode.equals( "SRVM" ) ) {
			obj = schema.getServerMethodTableObj().newInstance();
		}
		else if( argClassCode.equals( "SRVP" ) ) {
			obj = schema.getServerProcTableObj().newInstance();
		}
		else if( argClassCode.equals( "SRVO" ) ) {
			obj = schema.getServerObjFuncTableObj().newInstance();
		}
		else if( argClassCode.equals( "SRVL" ) ) {
			obj = schema.getServerListFuncTableObj().newInstance();
		}
		else if( argClassCode.equals( "POPD" ) ) {
			obj = schema.getPopDepTableObj().newInstance();
		}
		else if( argClassCode.equals( "POPT" ) ) {
			obj = schema.getPopTopDepTableObj().newInstance();
		}
		else if( argClassCode.equals( "POP1" ) ) {
			obj = schema.getPopSubDep1TableObj().newInstance();
		}
		else if( argClassCode.equals( "POP2" ) ) {
			obj = schema.getPopSubDep2TableObj().newInstance();
		}
		else if( argClassCode.equals( "POP3" ) ) {
			obj = schema.getPopSubDep3TableObj().newInstance();
		}
		else if( argClassCode.equals( "CLRD" ) ) {
			obj = schema.getClearDepTableObj().newInstance();
		}
		else if( argClassCode.equals( "CLRT" ) ) {
			obj = schema.getClearTopDepTableObj().newInstance();
		}
		else if( argClassCode.equals( "CLR1" ) ) {
			obj = schema.getClearSubDep1TableObj().newInstance();
		}
		else if( argClassCode.equals( "CLR2" ) ) {
			obj = schema.getClearSubDep2TableObj().newInstance();
		}
		else if( argClassCode.equals( "CLR3" ) ) {
			obj = schema.getClearSubDep3TableObj().newInstance();
		}
		return( obj );
	}

	public ICFBamScopeObj realizeScope( ICFBamScopeObj Obj ) {
		ICFBamScopeObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		ICFBamScopeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamScopeObj existingObj = members.get( pkey );
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
				Map<CFBamScopePKey, ICFBamScopeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamScopeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}
			if( allScope != null ) {
				allScope.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allScope != null ) {
				allScope.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamScopeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}
		}
		return( keepObj );
	}

	public void forgetScope( ICFBamScopeObj Obj ) {
		forgetScope( Obj, false );
	}

	public void forgetScope( ICFBamScopeObj Obj, boolean forgetSubObjects ) {
		ICFBamScopeObj obj = Obj;
		CFBamScopePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamScopeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamScopeByTenantIdxKey keyTenantIdx =
					schema.getBackingStore().getFactoryScope().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamScopePKey, ICFBamScopeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
				}
			}

			if( allScope != null ) {
				allScope.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetScopeByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamScopePKey key = schema.getBackingStore().getFactoryScope().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamScopeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetScopeByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamScopeObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				List<ICFBamScopeObj> toForget = new LinkedList<ICFBamScopeObj>();
				ICFBamScopeObj cur = null;
				Iterator<ICFBamScopeObj> iter = mapTenantIdx.values().iterator();
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

	public ICFBamScopeObj createScope( ICFBamScopeObj Obj ) {
		ICFBamScopeObj obj = Obj;
		CFBamScopeBuff buff = obj.getScopeBuff();
		schema.getBackingStore().getTableScope().createScope(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "SCOP" ) ) {
			obj = (ICFBamScopeObj)(obj.realize());
		}
		return( obj );
	}

	public ICFBamScopeObj readScope( CFBamScopePKey pkey ) {
		return( readScope( pkey, false ) );
	}

	public ICFBamScopeObj readScope( CFBamScopePKey pkey, boolean forceRead ) {
		ICFBamScopeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamScopeBuff readBuff = schema.getBackingStore().getTableScope().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = (ICFBamScopeObj)schema.getScopeTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamScopeObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamScopeObj lockScope( CFBamScopePKey pkey ) {
		ICFBamScopeObj locked = null;
		CFBamScopeBuff lockBuff = schema.getBackingStore().getTableScope().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFBamScopeObj)schema.getScopeTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamScopeObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockScope", pkey );
		}
		return( locked );
	}

	public List<ICFBamScopeObj> readAllScope() {
		return( readAllScope( false ) );
	}

	public List<ICFBamScopeObj> readAllScope( boolean forceRead ) {
		final String S_ProcName = "readAllScope";
		if( ( allScope == null ) || forceRead ) {
			Map<CFBamScopePKey, ICFBamScopeObj> map = new HashMap<CFBamScopePKey,ICFBamScopeObj>();
			allScope = map;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readAllDerived( schema.getAuthorization() );
			CFBamScopeBuff buff;
			ICFBamScopeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamScopeObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamScopeObj realized = (ICFBamScopeObj)obj.realize();
			}
		}
		Comparator<ICFBamScopeObj> cmp = new Comparator<ICFBamScopeObj>() {
			public int compare( ICFBamScopeObj lhs, ICFBamScopeObj rhs ) {
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
		int len = allScope.size();
		ICFBamScopeObj arr[] = new ICFBamScopeObj[len];
		Iterator<ICFBamScopeObj> valIter = allScope.values().iterator();
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
		ArrayList<ICFBamScopeObj> arrayList = new ArrayList<ICFBamScopeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamScopeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamScopeObj readScopeByIdIdx( long TenantId,
		long Id )
	{
		return( readScopeByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamScopeObj readScopeByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readScope( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamScopeObj> readScopeByTenantIdx( long TenantId )
	{
		return( readScopeByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamScopeObj> readScopeByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readScopeByTenantIdx";
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamScopePKey, ICFBamScopeObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamScopeObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamScopePKey, ICFBamScopeObj>();
			// Allow other threads to dirty-read while we're loading
			indexByTenantIdx.put( key, dict );
			ICFBamScopeObj obj;
			CFBamScopeBuff[] buffList = schema.getBackingStore().getTableScope().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamScopeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFBamScopeObj)schema.getScopeTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( schema.getBackingStore().getFactoryScope().newPKey() );
				obj.setBuff( buff );
				ICFBamScopeObj realized = (ICFBamScopeObj)obj.realize();
			}
		}
		Comparator<ICFBamScopeObj> cmp = new Comparator<ICFBamScopeObj>() {
			public int compare( ICFBamScopeObj lhs, ICFBamScopeObj rhs ) {
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
		ICFBamScopeObj arr[] = new ICFBamScopeObj[len];
		Iterator<ICFBamScopeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamScopeObj> arrayList = new ArrayList<ICFBamScopeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamScopeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamScopeObj updateScope( ICFBamScopeObj Obj ) {
		ICFBamScopeObj obj = Obj;
		schema.getBackingStore().getTableScope().updateScope( schema.getAuthorization(),
			Obj.getScopeBuff() );
		if( Obj.getClassCode().equals( "SCOP" ) ) {
			obj = (ICFBamScopeObj)Obj.realize();
		}
		return( obj );
	}

	public void deleteScope( ICFBamScopeObj Obj ) {
		ICFBamScopeObj obj = Obj;
		schema.getBackingStore().getTableScope().deleteScope( schema.getAuthorization(),
			obj.getScopeBuff() );
		obj.forget( true );
	}

	public void deleteScopeByIdIdx( long TenantId,
		long Id )
	{
		CFBamScopePKey pkey = schema.getBackingStore().getFactoryScope().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamScopeObj obj = readScope( pkey );
		if( obj != null ) {
			ICFBamScopeEditObj editObj = (ICFBamScopeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamScopeEditObj)obj.beginEdit();
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

	public void deleteScopeByTenantIdx( long TenantId )
	{
		CFBamScopeByTenantIdxKey key = schema.getBackingStore().getFactoryScope().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamScopeByTenantIdxKey,
				Map< CFBamScopePKey, ICFBamScopeObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamScopePKey, ICFBamScopeObj> dict = indexByTenantIdx.get( key );
			schema.getBackingStore().getTableScope().deleteScopeByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamScopeObj> iter = dict.values().iterator();
			ICFBamScopeObj obj;
			List<ICFBamScopeObj> toForget = new LinkedList<ICFBamScopeObj>();
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
			schema.getBackingStore().getTableScope().deleteScopeByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}
}
