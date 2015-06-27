// Description: Java7 base object instance implementation for CFBam HostNode.

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

public class CFBamHostNodeObj
	implements ICFBamHostNodeObj
{
	public final static String CLASS_CODE = "HSND";
	protected ICFBamSecUserObj createdBy = null;
	protected ICFBamSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFBamHostNodeEditObj edit;
	protected ICFBamSchemaObj schema;
	protected CFBamHostNodePKey pKey;
	protected CFBamHostNodeBuff buff;
	protected ICFBamClusterObj requiredContainerCluster;

	public CFBamHostNodeObj() {
		isNew = true;
		requiredContainerCluster = null;
	}

	public CFBamHostNodeObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerCluster = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "HostNode" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamClusterObj scope = getRequiredContainerCluster();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamClusterObj scope = getRequiredContainerCluster();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredHostName();
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

	public ICFBamHostNodeObj realize() {
		ICFBamHostNodeObj retobj = schema.getHostNodeTableObj().realizeHostNode(
			(ICFBamHostNodeObj)this );
		return( (ICFBamHostNodeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		schema.getHostNodeTableObj().forgetHostNode( (ICFBamHostNodeObj)this, forgetSubObjects );
	}

	public ICFBamHostNodeObj read() {
		ICFBamHostNodeObj retobj = schema.getHostNodeTableObj().readHostNodeByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredHostNodeId(), false );
		return( (ICFBamHostNodeObj)retobj );
	}

	public ICFBamHostNodeObj read( boolean forceRead ) {
		ICFBamHostNodeObj retobj = schema.getHostNodeTableObj().readHostNodeByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredHostNodeId(), forceRead );
		return( (ICFBamHostNodeObj)retobj );
	}

	public ICFBamHostNodeTableObj getHostNodeTable() {
		return( schema.getHostNodeTableObj() );
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj value ) {
		schema = value;
	}

	public CFBamHostNodeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = schema.getBackingStore().getFactoryHostNode().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = schema.getBackingStore().getTableHostNode().readDerivedByIdIdx( schema.getAuthorization(),
						getPKey().getRequiredClusterId(),
						getPKey().getRequiredHostNodeId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamHostNodeBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamHostNodeBuff ) ) ) {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamHostNodeBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerCluster = null;
	}

	public CFBamHostNodeBuff getHostNodeBuff() {
		return( (CFBamHostNodeBuff)getBuff() );
	}

	public CFBamHostNodePKey getPKey() {
		if( pKey == null ) {
			pKey = schema.getBackingStore().getFactoryHostNode().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFBamHostNodePKey value ) {
		if( pKey != value ) {
			pKey = value;
			copyPKeyToBuff();
		}
	}

	public boolean getIsNew() {
		return( isNew );
	}

	public void setIsNew( boolean value ) {
		isNew = value;
	}

	public ICFBamHostNodeEditObj beginEdit() {
		if( edit != null ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamHostNodeObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamHostNodeObj)this;
		}
		else {
			lockobj = schema.getHostNodeTableObj().lockHostNode( getPKey() );
		}
		edit = schema.getHostNodeTableObj().newEditInstance( lockobj );
		return( (ICFBamHostNodeEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFBamHostNodeEditObj getEdit() {
		return( edit );
	}

	public ICFBamHostNodeEditObj getEditAsHostNode() {
		return( (ICFBamHostNodeEditObj)edit );
	}

	public ICFBamSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamHostNodeBuff buff = getBuff();
			createdBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFBamSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamHostNodeBuff buff = getBuff();
			updatedBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredClusterId() {
		return( getPKey().getRequiredClusterId() );
	}

	public long getRequiredHostNodeId() {
		return( getPKey().getRequiredHostNodeId() );
	}

	public String getRequiredDescription() {
		return( getHostNodeBuff().getRequiredDescription() );
	}

	public String getRequiredHostName() {
		return( getHostNodeBuff().getRequiredHostName() );
	}

	public ICFBamClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	public ICFBamClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( ( requiredContainerCluster == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerCluster = schema.getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId(), forceRead );
			}
		}
		return( requiredContainerCluster );
	}

	public List<ICFBamServiceObj> getOptionalComponentsService() {
		List<ICFBamServiceObj> retval;
		retval = schema.getServiceTableObj().readServiceByHostIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredHostNodeId(),
			false );
		return( retval );
	}

	public List<ICFBamServiceObj> getOptionalComponentsService( boolean forceRead ) {
		List<ICFBamServiceObj> retval;
		retval = schema.getServiceTableObj().readServiceByHostIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredHostNodeId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
			buff.setRequiredHostNodeId( getPKey().getRequiredHostNodeId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredHostNodeId( buff.getRequiredHostNodeId() );
	}
}
