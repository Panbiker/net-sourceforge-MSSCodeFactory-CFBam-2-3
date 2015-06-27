// Description: Java7 edit object instance implementation for CFBam SecGroupForm.

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

public class CFBamSecGroupFormEditObj
	implements ICFBamSecGroupFormEditObj
{
	protected ICFBamSecGroupFormObj orig;
	protected CFBamSecGroupFormBuff buff;
	protected ICFBamSecUserObj createdBy = null;
	protected ICFBamSecUserObj updatedBy = null;
	protected ICFBamClusterObj requiredOwnerCluster;
	protected ICFBamSecGroupObj requiredContainerGroup;
	protected ICFBamSecAppObj requiredParentApp;
	protected ICFBamSecFormObj requiredParentForm;

	public CFBamSecGroupFormEditObj( ICFBamSecGroupFormObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamSecGroupFormBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerCluster = null;
		requiredContainerGroup = null;
		requiredParentApp = null;
		requiredParentForm = null;
	}

	public ICFBamSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamSecGroupFormBuff buff = getBuff();
			createdBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFBamSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamSecGroupFormBuff buff = getBuff();
			updatedBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public void setCreatedBy( ICFBamSecUserObj value ) {
		createdBy = value;
		if( value != null ) {
			getBuff().setCreatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setCreatedAt( Calendar value ) {
		getBuff().setCreatedAt( value );
	}

	public void setUpdatedBy( ICFBamSecUserObj value ) {
		updatedBy = value;
		if( value != null ) {
			getBuff().setUpdatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setUpdatedAt( Calendar value ) {
		getBuff().setUpdatedAt( value );
	}

	public String getClassCode() {
		return( CFBamSecGroupFormObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SecGroupForm" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamSecGroupObj scope = getRequiredContainerGroup();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamSecGroupObj scope = getRequiredContainerGroup();
		return( scope );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredSecGroupFormId();
		objName = Long.toString( val );
		return( objName );
	}

	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
					break;
				}
				else if( qualifyingClass.isInstance( container ) ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		else {
			while( container != null ) {
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	public ICFLibAnyObj getNamedObject( Class qualifyingClass, String objName ) {
		ICFLibAnyObj topContainer = getObjQualifier( qualifyingClass );
		if( topContainer == null ) {
			return( null );
		}
		ICFLibAnyObj namedObject = topContainer.getNamedObject( objName );
		return( namedObject );
	}

	public ICFLibAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		ICFLibAnyObj subObj = null;
		ICFLibAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	public String getObjQualifiedName() {
		String qualName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFBamClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFBamTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	public String getObjFullName() {
		String fullName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFBamClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFBamTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				fullName = containerName + "." + fullName;
				container = container.getObjScope();
			}
		}
		return( fullName );
	}

	public ICFBamSecGroupFormObj realize() {
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamSecGroupFormObj retobj = getSchema().getSecGroupFormTableObj().realizeSecGroupForm( (ICFBamSecGroupFormObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsSecGroupForm().getSchema().getSecGroupFormTableObj().forgetSecGroupForm( getOrigAsSecGroupForm(), forgetSubObjects );
	}

	public ICFBamSecGroupFormObj read() {
		ICFBamSecGroupFormObj retval = getOrigAsSecGroupForm().read();
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamSecGroupFormObj read( boolean forceRead ) {
		ICFBamSecGroupFormObj retval = getOrigAsSecGroupForm().read( forceRead );
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamSecGroupFormObj create() {
		copyBuffToOrig();
		ICFBamSecGroupFormObj retobj = getOrigAsSecGroupForm().getSchema().getSecGroupFormTableObj().createSecGroupForm( getOrigAsSecGroupForm() );
		if( retobj == getOrigAsSecGroupForm() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getSecGroupFormTableObj().updateSecGroupForm( (ICFBamSecGroupFormObj)this );
	}

	public void delete() {
		if( getIsNew() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getSecGroupFormTableObj().deleteSecGroupForm( getOrigAsSecGroupForm() );
	}

	public ICFBamSecGroupFormTableObj getSecGroupFormTable() {
		return( orig.getSchema().getSecGroupFormTableObj() );
	}

	public ICFBamSecGroupFormEditObj getEdit() {
		return( (ICFBamSecGroupFormEditObj)this );
	}

	public ICFBamSecGroupFormEditObj getEditAsSecGroupForm() {
		return( (ICFBamSecGroupFormEditObj)this );
	}

	public ICFBamSecGroupFormEditObj beginEdit() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamSecGroupFormObj getOrig() {
		return( orig );
	}

	public ICFBamSecGroupFormObj getOrigAsSecGroupForm() {
		return( (ICFBamSecGroupFormObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamSecGroupFormBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsSecGroupForm().getSchema().getBackingStore().getFactorySecGroupForm().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamSecGroupFormBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerCluster = null;
			requiredContainerGroup = null;
			requiredParentApp = null;
			requiredParentForm = null;
		}
	}

	public CFBamSecGroupFormBuff getSecGroupFormBuff() {
		return( (CFBamSecGroupFormBuff)getBuff() );
	}

	public CFBamSecGroupFormPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamSecGroupFormPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public long getRequiredClusterId() {
		return( getPKey().getRequiredClusterId() );
	}

	public long getRequiredSecGroupFormId() {
		return( getPKey().getRequiredSecGroupFormId() );
	}

	public int getRequiredSecGroupId() {
		return( getSecGroupFormBuff().getRequiredSecGroupId() );
	}

	public int getRequiredSecAppId() {
		return( getSecGroupFormBuff().getRequiredSecAppId() );
	}

	public int getRequiredSecFormId() {
		return( getSecGroupFormBuff().getRequiredSecFormId() );
	}

	public ICFBamClusterObj getRequiredOwnerCluster() {
		return( getRequiredOwnerCluster( false ) );
	}

	public ICFBamClusterObj getRequiredOwnerCluster( boolean forceRead ) {
		if( forceRead || ( requiredOwnerCluster == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamClusterObj obj = getOrigAsSecGroupForm().getSchema().getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId() );
				requiredOwnerCluster = obj;
			}
		}
		return( requiredOwnerCluster );
	}

	public void setRequiredOwnerCluster( ICFBamClusterObj value ) {
			if( buff == null ) {
				getSecGroupFormBuff();
			}
			requiredOwnerCluster = null;
			requiredContainerGroup = null;
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredId() );
				getSecGroupFormBuff().setRequiredClusterId( value.getRequiredId() );
			}
			requiredOwnerCluster = value;
	}

	public ICFBamSecGroupObj getRequiredContainerGroup() {
		return( getRequiredContainerGroup( false ) );
	}

	public ICFBamSecGroupObj getRequiredContainerGroup( boolean forceRead ) {
		if( forceRead || ( requiredContainerGroup == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamSecGroupObj obj = getOrigAsSecGroupForm().getSchema().getSecGroupTableObj().readSecGroupByIdIdx( getPKey().getRequiredClusterId(),
					getSecGroupFormBuff().getRequiredSecGroupId() );
				requiredContainerGroup = obj;
				if( obj != null ) {
					getSecGroupFormBuff().setRequiredClusterId( obj.getRequiredClusterId() );
					getSecGroupFormBuff().setRequiredSecGroupId( obj.getRequiredSecGroupId() );
					requiredContainerGroup = obj;
				}
			}
		}
		return( requiredContainerGroup );
	}

	public void setRequiredContainerGroup( ICFBamSecGroupObj value ) {
			if( buff == null ) {
				getSecGroupFormBuff();
			}
			requiredOwnerCluster = null;
			requiredContainerGroup = null;
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredSecGroupId( value.getRequiredSecGroupId() );
			}
			requiredContainerGroup = value;
	}

	public ICFBamSecAppObj getRequiredParentApp() {
		return( getRequiredParentApp( false ) );
	}

	public ICFBamSecAppObj getRequiredParentApp( boolean forceRead ) {
		if( forceRead || ( requiredParentApp == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamSecAppObj obj = getOrigAsSecGroupForm().getSchema().getSecAppTableObj().readSecAppByIdIdx( getPKey().getRequiredClusterId(),
					getSecGroupFormBuff().getRequiredSecAppId() );
				requiredParentApp = obj;
			}
		}
		return( requiredParentApp );
	}

	public void setRequiredParentApp( ICFBamSecAppObj value ) {
			if( buff == null ) {
				getSecGroupFormBuff();
			}
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredSecAppId( value.getRequiredSecAppId() );
			}
			else {
			}
			requiredParentApp = value;
	}

	public ICFBamSecFormObj getRequiredParentForm() {
		return( getRequiredParentForm( false ) );
	}

	public ICFBamSecFormObj getRequiredParentForm( boolean forceRead ) {
		if( forceRead || ( requiredParentForm == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamSecFormObj obj = getOrigAsSecGroupForm().getSchema().getSecFormTableObj().readSecFormByIdIdx( getPKey().getRequiredClusterId(),
					getSecGroupFormBuff().getRequiredSecFormId() );
				requiredParentForm = obj;
			}
		}
		return( requiredParentForm );
	}

	public void setRequiredParentForm( ICFBamSecFormObj value ) {
			if( buff == null ) {
				getSecGroupFormBuff();
			}
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredSecFormId( value.getRequiredSecFormId() );
			}
			else {
			}
			requiredParentForm = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
		buff.setRequiredSecGroupFormId( getPKey().getRequiredSecGroupFormId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredSecGroupFormId( buff.getRequiredSecGroupFormId() );
	}

	public void copyBuffToOrig() {
		CFBamSecGroupFormBuff origBuff = getOrigAsSecGroupForm().getSecGroupFormBuff();
		CFBamSecGroupFormBuff myBuff = getSecGroupFormBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamSecGroupFormBuff origBuff = getOrigAsSecGroupForm().getSecGroupFormBuff();
		CFBamSecGroupFormBuff myBuff = getSecGroupFormBuff();
		myBuff.set( origBuff );
	}
}
