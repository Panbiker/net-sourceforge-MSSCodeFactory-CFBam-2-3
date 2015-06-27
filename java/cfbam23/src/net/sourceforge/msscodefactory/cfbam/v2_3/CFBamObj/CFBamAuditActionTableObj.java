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

public class CFBamAuditActionTableObj
	implements ICFBamAuditActionTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamAuditActionPKey, ICFBamAuditActionObj> members;
	private Map<CFBamAuditActionPKey, ICFBamAuditActionObj> allAuditAction;
	private Map< CFBamAuditActionByUDescrIdxKey,
		ICFBamAuditActionObj > indexByUDescrIdx;
	public static String TABLE_NAME = "AuditAction";
	public static String TABLE_DBNAME = "auditaction";

	public CFBamAuditActionTableObj() {
		schema = null;
		members = new HashMap<CFBamAuditActionPKey, ICFBamAuditActionObj>();
		allAuditAction = null;
		indexByUDescrIdx = null;
	}

	public CFBamAuditActionTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamAuditActionPKey, ICFBamAuditActionObj>();
		allAuditAction = null;
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
		allAuditAction = null;
		indexByUDescrIdx = null;
		List<ICFBamAuditActionObj> toForget = new LinkedList<ICFBamAuditActionObj>();
		ICFBamAuditActionObj cur = null;
		Iterator<ICFBamAuditActionObj> iter = members.values().iterator();
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
	 *	CFBamAuditActionObj.
	 */
	public ICFBamAuditActionObj newInstance() {
		ICFBamAuditActionObj inst = new CFBamAuditActionObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamAuditActionObj.
	 */
	public ICFBamAuditActionEditObj newEditInstance( ICFBamAuditActionObj orig ) {
		ICFBamAuditActionEditObj edit = new CFBamAuditActionEditObj( orig );
		return( edit );
	}

	public ICFBamAuditActionObj realizeAuditAction( ICFBamAuditActionObj Obj ) {
		ICFBamAuditActionObj obj = Obj;
		CFBamAuditActionPKey pkey = obj.getPKey();
		ICFBamAuditActionObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamAuditActionObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUDescrIdx != null ) {
				CFBamAuditActionByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryAuditAction().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUDescrIdx != null ) {
				CFBamAuditActionByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryAuditAction().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}
			if( allAuditAction != null ) {
				allAuditAction.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allAuditAction != null ) {
				allAuditAction.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUDescrIdx != null ) {
				CFBamAuditActionByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryAuditAction().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetAuditAction( ICFBamAuditActionObj Obj ) {
		forgetAuditAction( Obj, false );
	}

	public void forgetAuditAction( ICFBamAuditActionObj Obj, boolean forgetSubObjects ) {
		ICFBamAuditActionObj obj = Obj;
		CFBamAuditActionPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamAuditActionObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByUDescrIdx != null ) {
				CFBamAuditActionByUDescrIdxKey keyUDescrIdx =
					schema.getBackingStore().getFactoryAuditAction().newUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			if( allAuditAction != null ) {
				allAuditAction.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetAuditActionByIdIdx( short AuditActionId )
	{
		if( members == null ) {
			return;
		}
		CFBamAuditActionPKey key = schema.getBackingStore().getFactoryAuditAction().newPKey();
		key.setRequiredAuditActionId( AuditActionId );
		if( members.containsKey( key ) ) {
			ICFBamAuditActionObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetAuditActionByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			return;
		}
		CFBamAuditActionByUDescrIdxKey key = schema.getBackingStore().getFactoryAuditAction().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		if( indexByUDescrIdx.containsKey( key ) ) {
			ICFBamAuditActionObj probed = indexByUDescrIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUDescrIdx.remove( key );
		}
	}

	public ICFBamAuditActionObj createAuditAction( ICFBamAuditActionObj Obj ) {
		ICFBamAuditActionObj obj = Obj;
		CFBamAuditActionBuff buff = obj.getAuditActionBuff();
		schema.getBackingStore().getTableAuditAction().createAuditAction(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamAuditActionObj readAuditAction( CFBamAuditActionPKey pkey ) {
		return( readAuditAction( pkey, false ) );
	}

	public ICFBamAuditActionObj readAuditAction( CFBamAuditActionPKey pkey, boolean forceRead ) {
		ICFBamAuditActionObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamAuditActionBuff readBuff = schema.getBackingStore().getTableAuditAction().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredAuditActionId() );
			if( readBuff != null ) {
				obj = schema.getAuditActionTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryAuditAction().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamAuditActionObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamAuditActionObj lockAuditAction( CFBamAuditActionPKey pkey ) {
		ICFBamAuditActionObj locked = null;
		CFBamAuditActionBuff lockBuff = schema.getBackingStore().getTableAuditAction().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getAuditActionTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactoryAuditAction().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamAuditActionObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockAuditAction", pkey );
		}
		return( locked );
	}

	public List<ICFBamAuditActionObj> readAllAuditAction() {
		return( readAllAuditAction( false ) );
	}

	public List<ICFBamAuditActionObj> readAllAuditAction( boolean forceRead ) {
		final String S_ProcName = "readAllAuditAction";
		if( ( allAuditAction == null ) || forceRead ) {
			Map<CFBamAuditActionPKey, ICFBamAuditActionObj> map = new HashMap<CFBamAuditActionPKey,ICFBamAuditActionObj>();
			allAuditAction = map;
			CFBamAuditActionBuff[] buffList = schema.getBackingStore().getTableAuditAction().readAllDerived( schema.getAuthorization() );
			CFBamAuditActionBuff buff;
			ICFBamAuditActionObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryAuditAction().newPKey() );
				obj.setBuff( buff );
				ICFBamAuditActionObj realized = (ICFBamAuditActionObj)obj.realize();
			}
		}
		Comparator<ICFBamAuditActionObj> cmp = new Comparator<ICFBamAuditActionObj>() {
			public int compare( ICFBamAuditActionObj lhs, ICFBamAuditActionObj rhs ) {
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
					CFBamAuditActionPKey lhsPKey = lhs.getPKey();
					CFBamAuditActionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allAuditAction.size();
		ICFBamAuditActionObj arr[] = new ICFBamAuditActionObj[len];
		Iterator<ICFBamAuditActionObj> valIter = allAuditAction.values().iterator();
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
		ArrayList<ICFBamAuditActionObj> arrayList = new ArrayList<ICFBamAuditActionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamAuditActionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamAuditActionObj readAuditActionByIdIdx( short AuditActionId )
	{
		return( readAuditActionByIdIdx( AuditActionId,
			false ) );
	}

	public ICFBamAuditActionObj readAuditActionByIdIdx( short AuditActionId, boolean forceRead )
	{
		CFBamAuditActionPKey pkey = schema.getBackingStore().getFactoryAuditAction().newPKey();
		pkey.setRequiredAuditActionId( AuditActionId );
		ICFBamAuditActionObj obj = readAuditAction( pkey, forceRead );
		return( obj );
	}

	public ICFBamAuditActionObj readAuditActionByUDescrIdx( String Description )
	{
		return( readAuditActionByUDescrIdx( Description,
			false ) );
	}

	public ICFBamAuditActionObj readAuditActionByUDescrIdx( String Description, boolean forceRead )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFBamAuditActionByUDescrIdxKey,
				ICFBamAuditActionObj >();
		}
		CFBamAuditActionByUDescrIdxKey key = schema.getBackingStore().getFactoryAuditAction().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		ICFBamAuditActionObj obj = null;
		if( ( ! forceRead ) && indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
		}
		else {
			CFBamAuditActionBuff buff = schema.getBackingStore().getTableAuditAction().readDerivedByUDescrIdx( schema.getAuthorization(),
				Description );
			if( buff != null ) {
				obj = schema.getAuditActionTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactoryAuditAction().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamAuditActionObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUDescrIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamAuditActionObj updateAuditAction( ICFBamAuditActionObj Obj ) {
		ICFBamAuditActionObj obj = Obj;
		schema.getBackingStore().getTableAuditAction().updateAuditAction( schema.getAuthorization(),
			Obj.getAuditActionBuff() );
		obj = (ICFBamAuditActionObj)Obj.realize();
		return( obj );
	}

	public void deleteAuditAction( ICFBamAuditActionObj Obj ) {
		ICFBamAuditActionObj obj = Obj;
		schema.getBackingStore().getTableAuditAction().deleteAuditAction( schema.getAuthorization(),
			obj.getAuditActionBuff() );
		obj.forget( true );
	}

	public void deleteAuditActionByIdIdx( short AuditActionId )
	{
		CFBamAuditActionPKey pkey = schema.getBackingStore().getFactoryAuditAction().newPKey();
		pkey.setRequiredAuditActionId( AuditActionId );
		ICFBamAuditActionObj obj = readAuditAction( pkey );
		if( obj != null ) {
			ICFBamAuditActionEditObj editObj = (ICFBamAuditActionEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamAuditActionEditObj)obj.beginEdit();
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

	public void deleteAuditActionByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFBamAuditActionByUDescrIdxKey,
				ICFBamAuditActionObj >();
		}
		CFBamAuditActionByUDescrIdxKey key = schema.getBackingStore().getFactoryAuditAction().newUDescrIdxKey();
		key.setRequiredDescription( Description );
		ICFBamAuditActionObj obj = null;
		if( indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
			schema.getBackingStore().getTableAuditAction().deleteAuditActionByUDescrIdx( schema.getAuthorization(),
				Description );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableAuditAction().deleteAuditActionByUDescrIdx( schema.getAuthorization(),
				Description );
		}
	}

	public void bootstrapAuditActions() {
		boolean transactionStarted = schema.beginTransaction();
		try {
			ICFBamAuditActionObj auditActionObj = readAuditActionByIdIdx( (short)1 );
			ICFBamAuditActionEditObj auditActionEdit;
			if( auditActionObj == null ) {
				auditActionObj = newInstance();
				auditActionEdit = auditActionObj.beginEdit();
				auditActionEdit.setRequiredAuditActionId( (short)1 );
				auditActionEdit.setRequiredDescription( "Created" );
				auditActionObj = auditActionEdit.create();
				auditActionEdit.endEdit();
			}

			auditActionObj = readAuditActionByIdIdx( (short)2 );
			if( auditActionObj == null ) {
				auditActionObj = newInstance();
				auditActionEdit = auditActionObj.beginEdit();
				auditActionEdit.setRequiredAuditActionId( (short)2 );
				auditActionEdit.setRequiredDescription( "Updated" );
				auditActionObj = auditActionEdit.create();
				auditActionEdit.endEdit();
			}

			auditActionObj = readAuditActionByIdIdx( (short)3 );
			if( auditActionObj == null ) {
				auditActionObj = newInstance();
				auditActionEdit = auditActionObj.beginEdit();
				auditActionEdit.setRequiredAuditActionId( (short)3 );
				auditActionEdit.setRequiredDescription( "Deleted" );
				auditActionObj = auditActionEdit.create();
				auditActionEdit.endEdit();
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
	}
}
