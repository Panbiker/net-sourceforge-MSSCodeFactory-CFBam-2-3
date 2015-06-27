// Description: Java7 edit object instance implementation for CFBam Service.

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

public class CFBamServiceEditObj
	implements ICFBamServiceEditObj
{
	protected ICFBamServiceObj orig;
	protected CFBamServiceBuff buff;
	protected ICFBamSecUserObj createdBy = null;
	protected ICFBamSecUserObj updatedBy = null;
	protected ICFBamClusterObj requiredOwnerCluster;
	protected ICFBamHostNodeObj optionalContainerHost;
	protected ICFBamServiceTypeObj optionalParentServiceType;

	public CFBamServiceEditObj( ICFBamServiceObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamServiceBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerCluster = null;
		optionalContainerHost = null;
		optionalParentServiceType = null;
	}

	public ICFBamSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamServiceBuff buff = getBuff();
			createdBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFBamSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamServiceBuff buff = getBuff();
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
		return( CFBamServiceObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Service" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamHostNodeObj scope = getOptionalContainerHost();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamHostNodeObj scope = getOptionalContainerHost();
		return( scope );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredServiceId();
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

	public ICFBamServiceObj realize() {
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamServiceObj retobj = getSchema().getServiceTableObj().realizeService( (ICFBamServiceObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsService().getSchema().getServiceTableObj().forgetService( getOrigAsService(), forgetSubObjects );
	}

	public ICFBamServiceObj read() {
		ICFBamServiceObj retval = getOrigAsService().read();
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamServiceObj read( boolean forceRead ) {
		ICFBamServiceObj retval = getOrigAsService().read( forceRead );
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamServiceObj create() {
		copyBuffToOrig();
		ICFBamServiceObj retobj = getOrigAsService().getSchema().getServiceTableObj().createService( getOrigAsService() );
		if( retobj == getOrigAsService() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getServiceTableObj().updateService( (ICFBamServiceObj)this );
	}

	public void delete() {
		if( getIsNew() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getServiceTableObj().deleteService( getOrigAsService() );
	}

	public ICFBamServiceTableObj getServiceTable() {
		return( orig.getSchema().getServiceTableObj() );
	}

	public ICFBamServiceEditObj getEdit() {
		return( (ICFBamServiceEditObj)this );
	}

	public ICFBamServiceEditObj getEditAsService() {
		return( (ICFBamServiceEditObj)this );
	}

	public ICFBamServiceEditObj beginEdit() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamServiceObj getOrig() {
		return( orig );
	}

	public ICFBamServiceObj getOrigAsService() {
		return( (ICFBamServiceObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamServiceBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsService().getSchema().getBackingStore().getFactoryService().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamServiceBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerCluster = null;
			optionalContainerHost = null;
			optionalParentServiceType = null;
		}
	}

	public CFBamServiceBuff getServiceBuff() {
		return( (CFBamServiceBuff)getBuff() );
	}

	public CFBamServicePKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamServicePKey value ) {
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

	public long getRequiredServiceId() {
		return( getPKey().getRequiredServiceId() );
	}

	public long getRequiredHostNodeId() {
		return( getServiceBuff().getRequiredHostNodeId() );
	}

	public int getRequiredServiceTypeId() {
		return( getServiceBuff().getRequiredServiceTypeId() );
	}

	public short getRequiredHostPort() {
		return( getServiceBuff().getRequiredHostPort() );
	}

	public void setRequiredHostPort( short value ) {
		if( getServiceBuff().getRequiredHostPort() != value ) {
			getServiceBuff().setRequiredHostPort( value );
		}
	}

	public ICFBamClusterObj getRequiredOwnerCluster() {
		return( getRequiredOwnerCluster( false ) );
	}

	public ICFBamClusterObj getRequiredOwnerCluster( boolean forceRead ) {
		if( forceRead || ( requiredOwnerCluster == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamClusterObj obj = getOrigAsService().getSchema().getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId() );
				requiredOwnerCluster = obj;
			}
		}
		return( requiredOwnerCluster );
	}

	public void setRequiredOwnerCluster( ICFBamClusterObj value ) {
			if( buff == null ) {
				getServiceBuff();
			}
			requiredOwnerCluster = null;
			optionalContainerHost = null;
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredId() );
				getServiceBuff().setRequiredClusterId( value.getRequiredId() );
			}
			requiredOwnerCluster = value;
	}

	public ICFBamHostNodeObj getOptionalContainerHost() {
		return( getOptionalContainerHost( false ) );
	}

	public ICFBamHostNodeObj getOptionalContainerHost( boolean forceRead ) {
		if( forceRead || ( optionalContainerHost == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamHostNodeObj obj = getOrigAsService().getSchema().getHostNodeTableObj().readHostNodeByIdIdx( getPKey().getRequiredClusterId(),
					getServiceBuff().getRequiredHostNodeId() );
				optionalContainerHost = obj;
				if( obj != null ) {
					getServiceBuff().setRequiredClusterId( obj.getRequiredClusterId() );
					getServiceBuff().setRequiredHostNodeId( obj.getRequiredHostNodeId() );
					optionalContainerHost = obj;
				}
			}
		}
		return( optionalContainerHost );
	}

	public void setOptionalContainerHost( ICFBamHostNodeObj value ) {
			if( buff == null ) {
				getServiceBuff();
			}
			requiredOwnerCluster = null;
			optionalContainerHost = null;
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredClusterId() );
				getServiceBuff().setRequiredClusterId( value.getRequiredClusterId() );
				getServiceBuff().setRequiredHostNodeId( value.getRequiredHostNodeId() );
			}
			optionalContainerHost = value;
	}

	public ICFBamServiceTypeObj getOptionalParentServiceType() {
		return( getOptionalParentServiceType( false ) );
	}

	public ICFBamServiceTypeObj getOptionalParentServiceType( boolean forceRead ) {
		if( forceRead || ( optionalParentServiceType == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamServiceTypeObj obj = getOrigAsService().getSchema().getServiceTypeTableObj().readServiceTypeByIdIdx( getServiceBuff().getRequiredServiceTypeId() );
				optionalParentServiceType = obj;
			}
		}
		return( optionalParentServiceType );
	}

	public void setOptionalParentServiceType( ICFBamServiceTypeObj value ) {
			if( buff == null ) {
				getServiceBuff();
			}
			if( value != null ) {
				getServiceBuff().setRequiredServiceTypeId( value.getRequiredServiceTypeId() );
			}
			else {
			}
			optionalParentServiceType = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
		buff.setRequiredServiceId( getPKey().getRequiredServiceId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredServiceId( buff.getRequiredServiceId() );
	}

	public void copyBuffToOrig() {
		CFBamServiceBuff origBuff = getOrigAsService().getServiceBuff();
		CFBamServiceBuff myBuff = getServiceBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamServiceBuff origBuff = getOrigAsService().getServiceBuff();
		CFBamServiceBuff myBuff = getServiceBuff();
		myBuff.set( origBuff );
	}
}
