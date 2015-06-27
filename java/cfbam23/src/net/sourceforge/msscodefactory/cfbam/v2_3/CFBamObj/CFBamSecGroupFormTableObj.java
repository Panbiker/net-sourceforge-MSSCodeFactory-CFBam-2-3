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

public class CFBamSecGroupFormTableObj
	implements ICFBamSecGroupFormTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> members;
	private Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> allSecGroupForm;
	private Map< CFBamSecGroupFormByClusterIdxKey,
		Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > > indexByClusterIdx;
	private Map< CFBamSecGroupFormByGroupIdxKey,
		Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > > indexByGroupIdx;
	private Map< CFBamSecGroupFormByAppIdxKey,
		Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > > indexByAppIdx;
	private Map< CFBamSecGroupFormByFormIdxKey,
		Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > > indexByFormIdx;
	private Map< CFBamSecGroupFormByUFormIdxKey,
		ICFBamSecGroupFormObj > indexByUFormIdx;
	public static String TABLE_NAME = "SecGroupForm";
	public static String TABLE_DBNAME = "secgrpfrm";

	public CFBamSecGroupFormTableObj() {
		schema = null;
		members = new HashMap<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj>();
		allSecGroupForm = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByAppIdx = null;
		indexByFormIdx = null;
		indexByUFormIdx = null;
	}

	public CFBamSecGroupFormTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj>();
		allSecGroupForm = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByAppIdx = null;
		indexByFormIdx = null;
		indexByUFormIdx = null;
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
		allSecGroupForm = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByAppIdx = null;
		indexByFormIdx = null;
		indexByUFormIdx = null;
		List<ICFBamSecGroupFormObj> toForget = new LinkedList<ICFBamSecGroupFormObj>();
		ICFBamSecGroupFormObj cur = null;
		Iterator<ICFBamSecGroupFormObj> iter = members.values().iterator();
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
	 *	CFBamSecGroupFormObj.
	 */
	public ICFBamSecGroupFormObj newInstance() {
		ICFBamSecGroupFormObj inst = new CFBamSecGroupFormObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecGroupFormObj.
	 */
	public ICFBamSecGroupFormEditObj newEditInstance( ICFBamSecGroupFormObj orig ) {
		ICFBamSecGroupFormEditObj edit = new CFBamSecGroupFormEditObj( orig );
		return( edit );
	}

	public ICFBamSecGroupFormObj realizeSecGroupForm( ICFBamSecGroupFormObj Obj ) {
		ICFBamSecGroupFormObj obj = Obj;
		CFBamSecGroupFormPKey pkey = obj.getPKey();
		ICFBamSecGroupFormObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamSecGroupFormObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFBamSecGroupFormByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupFormByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByAppIdx != null ) {
				CFBamSecGroupFormByAppIdxKey keyAppIdx =
					schema.getBackingStore().getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByFormIdx != null ) {
				CFBamSecGroupFormByFormIdxKey keyFormIdx =
					schema.getBackingStore().getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUFormIdx != null ) {
				CFBamSecGroupFormByUFormIdxKey keyUFormIdx =
					schema.getBackingStore().getFactorySecGroupForm().newUFormIdxKey();
				keyUFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUFormIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				indexByUFormIdx.remove( keyUFormIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFBamSecGroupFormByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupFormByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAppIdx != null ) {
				CFBamSecGroupFormByAppIdxKey keyAppIdx =
					schema.getBackingStore().getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFormIdx != null ) {
				CFBamSecGroupFormByFormIdxKey keyFormIdx =
					schema.getBackingStore().getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUFormIdx != null ) {
				CFBamSecGroupFormByUFormIdxKey keyUFormIdx =
					schema.getBackingStore().getFactorySecGroupForm().newUFormIdxKey();
				keyUFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUFormIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				indexByUFormIdx.put( keyUFormIdx, keepObj );
			}
			if( allSecGroupForm != null ) {
				allSecGroupForm.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );
			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecGroupForm != null ) {
				allSecGroupForm.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFBamSecGroupFormByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupFormByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAppIdx != null ) {
				CFBamSecGroupFormByAppIdxKey keyAppIdx =
					schema.getBackingStore().getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFormIdx != null ) {
				CFBamSecGroupFormByFormIdxKey keyFormIdx =
					schema.getBackingStore().getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUFormIdx != null ) {
				CFBamSecGroupFormByUFormIdxKey keyUFormIdx =
					schema.getBackingStore().getFactorySecGroupForm().newUFormIdxKey();
				keyUFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUFormIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				indexByUFormIdx.put( keyUFormIdx, keepObj );
			}
		}
		return( keepObj );
	}

	public void forgetSecGroupForm( ICFBamSecGroupFormObj Obj ) {
		forgetSecGroupForm( Obj, false );
	}

	public void forgetSecGroupForm( ICFBamSecGroupFormObj Obj, boolean forgetSubObjects ) {
		ICFBamSecGroupFormObj obj = Obj;
		CFBamSecGroupFormPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamSecGroupFormObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFBamSecGroupFormByClusterIdxKey keyClusterIdx =
					schema.getBackingStore().getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByGroupIdx != null ) {
				CFBamSecGroupFormByGroupIdxKey keyGroupIdx =
					schema.getBackingStore().getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByAppIdx != null ) {
				CFBamSecGroupFormByAppIdxKey keyAppIdx =
					schema.getBackingStore().getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByFormIdx != null ) {
				CFBamSecGroupFormByFormIdxKey keyFormIdx =
					schema.getBackingStore().getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.remove( keepObj.getPKey() );
				}
			}

			if( indexByUFormIdx != null ) {
				CFBamSecGroupFormByUFormIdxKey keyUFormIdx =
					schema.getBackingStore().getFactorySecGroupForm().newUFormIdxKey();
				keyUFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUFormIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				indexByUFormIdx.remove( keyUFormIdx );
			}

			if( allSecGroupForm != null ) {
				allSecGroupForm.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId )
	{
		if( members == null ) {
			return;
		}
		CFBamSecGroupFormPKey key = schema.getBackingStore().getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupFormId( SecGroupFormId );
		if( members.containsKey( key ) ) {
			ICFBamSecGroupFormObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecGroupFormByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		CFBamSecGroupFormByClusterIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				List<ICFBamSecGroupFormObj> toForget = new LinkedList<ICFBamSecGroupFormObj>();
				ICFBamSecGroupFormObj cur = null;
				Iterator<ICFBamSecGroupFormObj> iter = mapClusterIdx.values().iterator();
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

			indexByClusterIdx.remove( key );
		}
	}

	public void forgetSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		if( indexByGroupIdx == null ) {
			return;
		}
		CFBamSecGroupFormByGroupIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				List<ICFBamSecGroupFormObj> toForget = new LinkedList<ICFBamSecGroupFormObj>();
				ICFBamSecGroupFormObj cur = null;
				Iterator<ICFBamSecGroupFormObj> iter = mapGroupIdx.values().iterator();
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

			indexByGroupIdx.remove( key );
		}
	}

	public void forgetSecGroupFormByAppIdx( long ClusterId,
		int SecAppId )
	{
		if( indexByAppIdx == null ) {
			return;
		}
		CFBamSecGroupFormByAppIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( indexByAppIdx.containsKey( key ) ) {
			Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapAppIdx = indexByAppIdx.get( key );
			if( mapAppIdx != null ) {
				List<ICFBamSecGroupFormObj> toForget = new LinkedList<ICFBamSecGroupFormObj>();
				ICFBamSecGroupFormObj cur = null;
				Iterator<ICFBamSecGroupFormObj> iter = mapAppIdx.values().iterator();
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

			indexByAppIdx.remove( key );
		}
	}

	public void forgetSecGroupFormByFormIdx( long ClusterId,
		int SecFormId )
	{
		if( indexByFormIdx == null ) {
			return;
		}
		CFBamSecGroupFormByFormIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		if( indexByFormIdx.containsKey( key ) ) {
			Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > mapFormIdx = indexByFormIdx.get( key );
			if( mapFormIdx != null ) {
				List<ICFBamSecGroupFormObj> toForget = new LinkedList<ICFBamSecGroupFormObj>();
				ICFBamSecGroupFormObj cur = null;
				Iterator<ICFBamSecGroupFormObj> iter = mapFormIdx.values().iterator();
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

			indexByFormIdx.remove( key );
		}
	}

	public void forgetSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		if( indexByUFormIdx == null ) {
			return;
		}
		CFBamSecGroupFormByUFormIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );
		if( indexByUFormIdx.containsKey( key ) ) {
			ICFBamSecGroupFormObj probed = indexByUFormIdx.get( key );
			if( probed != null ) {
				probed.forget( true );
			}

			indexByUFormIdx.remove( key );
		}
	}

	public ICFBamSecGroupFormObj createSecGroupForm( ICFBamSecGroupFormObj Obj ) {
		ICFBamSecGroupFormObj obj = Obj;
		CFBamSecGroupFormBuff buff = obj.getSecGroupFormBuff();
		schema.getBackingStore().getTableSecGroupForm().createSecGroupForm(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realize();
		return( obj );
	}

	public ICFBamSecGroupFormObj readSecGroupForm( CFBamSecGroupFormPKey pkey ) {
		return( readSecGroupForm( pkey, false ) );
	}

	public ICFBamSecGroupFormObj readSecGroupForm( CFBamSecGroupFormPKey pkey, boolean forceRead ) {
		ICFBamSecGroupFormObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamSecGroupFormBuff readBuff = schema.getBackingStore().getTableSecGroupForm().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGroupFormId() );
			if( readBuff != null ) {
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupForm().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamSecGroupFormObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				members.put( pkey, null );
			}
		}
		return( obj );
	}

	public ICFBamSecGroupFormObj lockSecGroupForm( CFBamSecGroupFormPKey pkey ) {
		ICFBamSecGroupFormObj locked = null;
		CFBamSecGroupFormBuff lockBuff = schema.getBackingStore().getTableSecGroupForm().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGroupFormTableObj().newInstance();
			locked.setPKey( schema.getBackingStore().getFactorySecGroupForm().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamSecGroupFormObj)locked.realize();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(), "lockSecGroupForm", pkey );
		}
		return( locked );
	}

	public List<ICFBamSecGroupFormObj> readAllSecGroupForm() {
		return( readAllSecGroupForm( false ) );
	}

	public List<ICFBamSecGroupFormObj> readAllSecGroupForm( boolean forceRead ) {
		final String S_ProcName = "readAllSecGroupForm";
		if( ( allSecGroupForm == null ) || forceRead ) {
			Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> map = new HashMap<CFBamSecGroupFormPKey,ICFBamSecGroupFormObj>();
			allSecGroupForm = map;
			CFBamSecGroupFormBuff[] buffList = schema.getBackingStore().getTableSecGroupForm().readAllDerived( schema.getAuthorization() );
			CFBamSecGroupFormBuff buff;
			ICFBamSecGroupFormObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupFormObj realized = (ICFBamSecGroupFormObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupFormObj> cmp = new Comparator<ICFBamSecGroupFormObj>() {
			public int compare( ICFBamSecGroupFormObj lhs, ICFBamSecGroupFormObj rhs ) {
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
					CFBamSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = allSecGroupForm.size();
		ICFBamSecGroupFormObj arr[] = new ICFBamSecGroupFormObj[len];
		Iterator<ICFBamSecGroupFormObj> valIter = allSecGroupForm.values().iterator();
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
		ArrayList<ICFBamSecGroupFormObj> arrayList = new ArrayList<ICFBamSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecGroupFormObj readSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId )
	{
		return( readSecGroupFormByIdIdx( ClusterId,
			SecGroupFormId,
			false ) );
	}

	public ICFBamSecGroupFormObj readSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId, boolean forceRead )
	{
		CFBamSecGroupFormPKey pkey = schema.getBackingStore().getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupFormId( SecGroupFormId );
		ICFBamSecGroupFormObj obj = readSecGroupForm( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamSecGroupFormObj> readSecGroupFormByClusterIdx( long ClusterId )
	{
		return( readSecGroupFormByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFBamSecGroupFormObj> readSecGroupFormByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByClusterIdx";
		CFBamSecGroupFormByClusterIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecGroupFormByClusterIdxKey,
				Map< CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj>();
			// Allow other threads to dirty-read while we're loading
			indexByClusterIdx.put( key, dict );
			ICFBamSecGroupFormObj obj;
			CFBamSecGroupFormBuff[] buffList = schema.getBackingStore().getTableSecGroupForm().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFBamSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupFormObj realized = (ICFBamSecGroupFormObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupFormObj> cmp = new Comparator<ICFBamSecGroupFormObj>() {
			public int compare( ICFBamSecGroupFormObj lhs, ICFBamSecGroupFormObj rhs ) {
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
					CFBamSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupFormObj arr[] = new ICFBamSecGroupFormObj[len];
		Iterator<ICFBamSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupFormObj> arrayList = new ArrayList<ICFBamSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecGroupFormObj> readSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGroupFormByGroupIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public List<ICFBamSecGroupFormObj> readSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByGroupIdx";
		CFBamSecGroupFormByGroupIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFBamSecGroupFormByGroupIdxKey,
				Map< CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj>();
			// Allow other threads to dirty-read while we're loading
			indexByGroupIdx.put( key, dict );
			ICFBamSecGroupFormObj obj;
			CFBamSecGroupFormBuff[] buffList = schema.getBackingStore().getTableSecGroupForm().readDerivedByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			CFBamSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupFormObj realized = (ICFBamSecGroupFormObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupFormObj> cmp = new Comparator<ICFBamSecGroupFormObj>() {
			public int compare( ICFBamSecGroupFormObj lhs, ICFBamSecGroupFormObj rhs ) {
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
					CFBamSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupFormObj arr[] = new ICFBamSecGroupFormObj[len];
		Iterator<ICFBamSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupFormObj> arrayList = new ArrayList<ICFBamSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecGroupFormObj> readSecGroupFormByAppIdx( long ClusterId,
		int SecAppId )
	{
		return( readSecGroupFormByAppIdx( ClusterId,
			SecAppId,
			false ) );
	}

	public List<ICFBamSecGroupFormObj> readSecGroupFormByAppIdx( long ClusterId,
		int SecAppId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByAppIdx";
		CFBamSecGroupFormByAppIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> dict;
		if( indexByAppIdx == null ) {
			indexByAppIdx = new HashMap< CFBamSecGroupFormByAppIdxKey,
				Map< CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByAppIdx.containsKey( key ) ) {
			dict = indexByAppIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj>();
			// Allow other threads to dirty-read while we're loading
			indexByAppIdx.put( key, dict );
			ICFBamSecGroupFormObj obj;
			CFBamSecGroupFormBuff[] buffList = schema.getBackingStore().getTableSecGroupForm().readDerivedByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
			CFBamSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupFormObj realized = (ICFBamSecGroupFormObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupFormObj> cmp = new Comparator<ICFBamSecGroupFormObj>() {
			public int compare( ICFBamSecGroupFormObj lhs, ICFBamSecGroupFormObj rhs ) {
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
					CFBamSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupFormObj arr[] = new ICFBamSecGroupFormObj[len];
		Iterator<ICFBamSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupFormObj> arrayList = new ArrayList<ICFBamSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamSecGroupFormObj> readSecGroupFormByFormIdx( long ClusterId,
		int SecFormId )
	{
		return( readSecGroupFormByFormIdx( ClusterId,
			SecFormId,
			false ) );
	}

	public List<ICFBamSecGroupFormObj> readSecGroupFormByFormIdx( long ClusterId,
		int SecFormId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByFormIdx";
		CFBamSecGroupFormByFormIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> dict;
		if( indexByFormIdx == null ) {
			indexByFormIdx = new HashMap< CFBamSecGroupFormByFormIdxKey,
				Map< CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByFormIdx.containsKey( key ) ) {
			dict = indexByFormIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj>();
			// Allow other threads to dirty-read while we're loading
			indexByFormIdx.put( key, dict );
			ICFBamSecGroupFormObj obj;
			CFBamSecGroupFormBuff[] buffList = schema.getBackingStore().getTableSecGroupForm().readDerivedByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId );
			CFBamSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFBamSecGroupFormObj realized = (ICFBamSecGroupFormObj)obj.realize();
			}
		}
		Comparator<ICFBamSecGroupFormObj> cmp = new Comparator<ICFBamSecGroupFormObj>() {
			public int compare( ICFBamSecGroupFormObj lhs, ICFBamSecGroupFormObj rhs ) {
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
					CFBamSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFBamSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		int len = dict.size();
		ICFBamSecGroupFormObj arr[] = new ICFBamSecGroupFormObj[len];
		Iterator<ICFBamSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamSecGroupFormObj> arrayList = new ArrayList<ICFBamSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}
		List<ICFBamSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamSecGroupFormObj readSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		return( readSecGroupFormByUFormIdx( ClusterId,
			SecGroupId,
			SecFormId,
			false ) );
	}

	public ICFBamSecGroupFormObj readSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId, boolean forceRead )
	{
		if( indexByUFormIdx == null ) {
			indexByUFormIdx = new HashMap< CFBamSecGroupFormByUFormIdxKey,
				ICFBamSecGroupFormObj >();
		}
		CFBamSecGroupFormByUFormIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );
		ICFBamSecGroupFormObj obj = null;
		if( ( ! forceRead ) && indexByUFormIdx.containsKey( key ) ) {
			obj = indexByUFormIdx.get( key );
		}
		else {
			CFBamSecGroupFormBuff buff = schema.getBackingStore().getTableSecGroupForm().readDerivedByUFormIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecFormId );
			if( buff != null ) {
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( schema.getBackingStore().getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamSecGroupFormObj)obj.realize();
			}
			else if( schema.getCacheMisses() ) {
				indexByUFormIdx.put( key, null );
			}
		}
		return( obj );
	}

	public ICFBamSecGroupFormObj updateSecGroupForm( ICFBamSecGroupFormObj Obj ) {
		ICFBamSecGroupFormObj obj = Obj;
		schema.getBackingStore().getTableSecGroupForm().updateSecGroupForm( schema.getAuthorization(),
			Obj.getSecGroupFormBuff() );
		obj = (ICFBamSecGroupFormObj)Obj.realize();
		return( obj );
	}

	public void deleteSecGroupForm( ICFBamSecGroupFormObj Obj ) {
		ICFBamSecGroupFormObj obj = Obj;
		schema.getBackingStore().getTableSecGroupForm().deleteSecGroupForm( schema.getAuthorization(),
			obj.getSecGroupFormBuff() );
		obj.forget( true );
	}

	public void deleteSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId )
	{
		CFBamSecGroupFormPKey pkey = schema.getBackingStore().getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupFormId( SecGroupFormId );
		ICFBamSecGroupFormObj obj = readSecGroupForm( pkey );
		if( obj != null ) {
			ICFBamSecGroupFormEditObj editObj = (ICFBamSecGroupFormEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamSecGroupFormEditObj)obj.beginEdit();
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

	public void deleteSecGroupFormByClusterIdx( long ClusterId )
	{
		CFBamSecGroupFormByClusterIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFBamSecGroupFormByClusterIdxKey,
				Map< CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> dict = indexByClusterIdx.get( key );
			schema.getBackingStore().getTableSecGroupForm().deleteSecGroupFormByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFBamSecGroupFormObj> iter = dict.values().iterator();
			ICFBamSecGroupFormObj obj;
			List<ICFBamSecGroupFormObj> toForget = new LinkedList<ICFBamSecGroupFormObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClusterIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecGroupForm().deleteSecGroupFormByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		CFBamSecGroupFormByGroupIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFBamSecGroupFormByGroupIdxKey,
				Map< CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> dict = indexByGroupIdx.get( key );
			schema.getBackingStore().getTableSecGroupForm().deleteSecGroupFormByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			Iterator<ICFBamSecGroupFormObj> iter = dict.values().iterator();
			ICFBamSecGroupFormObj obj;
			List<ICFBamSecGroupFormObj> toForget = new LinkedList<ICFBamSecGroupFormObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByGroupIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecGroupForm().deleteSecGroupFormByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
		}
	}

	public void deleteSecGroupFormByAppIdx( long ClusterId,
		int SecAppId )
	{
		CFBamSecGroupFormByAppIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( indexByAppIdx == null ) {
			indexByAppIdx = new HashMap< CFBamSecGroupFormByAppIdxKey,
				Map< CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > >();
		}
		if( indexByAppIdx.containsKey( key ) ) {
			Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> dict = indexByAppIdx.get( key );
			schema.getBackingStore().getTableSecGroupForm().deleteSecGroupFormByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
			Iterator<ICFBamSecGroupFormObj> iter = dict.values().iterator();
			ICFBamSecGroupFormObj obj;
			List<ICFBamSecGroupFormObj> toForget = new LinkedList<ICFBamSecGroupFormObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByAppIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecGroupForm().deleteSecGroupFormByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
		}
	}

	public void deleteSecGroupFormByFormIdx( long ClusterId,
		int SecFormId )
	{
		CFBamSecGroupFormByFormIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		if( indexByFormIdx == null ) {
			indexByFormIdx = new HashMap< CFBamSecGroupFormByFormIdxKey,
				Map< CFBamSecGroupFormPKey, ICFBamSecGroupFormObj > >();
		}
		if( indexByFormIdx.containsKey( key ) ) {
			Map<CFBamSecGroupFormPKey, ICFBamSecGroupFormObj> dict = indexByFormIdx.get( key );
			schema.getBackingStore().getTableSecGroupForm().deleteSecGroupFormByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId );
			Iterator<ICFBamSecGroupFormObj> iter = dict.values().iterator();
			ICFBamSecGroupFormObj obj;
			List<ICFBamSecGroupFormObj> toForget = new LinkedList<ICFBamSecGroupFormObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByFormIdx.remove( key );
		}
		else {
			schema.getBackingStore().getTableSecGroupForm().deleteSecGroupFormByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId );
		}
	}

	public void deleteSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		if( indexByUFormIdx == null ) {
			indexByUFormIdx = new HashMap< CFBamSecGroupFormByUFormIdxKey,
				ICFBamSecGroupFormObj >();
		}
		CFBamSecGroupFormByUFormIdxKey key = schema.getBackingStore().getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );
		ICFBamSecGroupFormObj obj = null;
		if( indexByUFormIdx.containsKey( key ) ) {
			obj = indexByUFormIdx.get( key );
			schema.getBackingStore().getTableSecGroupForm().deleteSecGroupFormByUFormIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecFormId );
			obj.forget( true );
		}
		else {
			schema.getBackingStore().getTableSecGroupForm().deleteSecGroupFormByUFormIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecFormId );
		}
	}
}
