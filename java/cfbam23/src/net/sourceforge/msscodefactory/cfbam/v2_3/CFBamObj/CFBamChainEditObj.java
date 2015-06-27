// Description: Java7 edit object instance implementation for CFBam Chain.

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

public class CFBamChainEditObj
	implements ICFBamChainEditObj
{
	protected ICFBamChainObj orig;
	protected CFBamChainBuff buff;
	protected ICFBamSecUserObj createdBy = null;
	protected ICFBamSecUserObj updatedBy = null;
	protected ICFBamTenantObj requiredOwnerTenant;
	protected ICFBamTableObj requiredContainerTable;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamRelationObj requiredLookupPrevRel;
	protected ICFBamRelationObj requiredLookupNextRel;

	public CFBamChainEditObj( ICFBamChainObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamChainBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerTenant = null;
		requiredContainerTable = null;
		optionalLookupDefSchema = null;
		requiredLookupPrevRel = null;
		requiredLookupNextRel = null;
	}

	public ICFBamSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamChainBuff buff = getBuff();
			createdBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFBamSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamChainBuff buff = getBuff();
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
		return( CFBamChainObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Chain" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamTableObj scope = getRequiredContainerTable();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamTableObj scope = getRequiredContainerTable();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredName();
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
			else if( container instanceof ICFBamSchemaDefObj ) {
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

	public ICFBamChainObj realize() {
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamChainObj retobj = getSchema().getChainTableObj().realizeChain( (ICFBamChainObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsChain().getSchema().getChainTableObj().forgetChain( getOrigAsChain(), forgetSubObjects );
	}

	public ICFBamChainObj read() {
		ICFBamChainObj retval = getOrigAsChain().read();
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamChainObj read( boolean forceRead ) {
		ICFBamChainObj retval = getOrigAsChain().read( forceRead );
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamChainObj create() {
		copyBuffToOrig();
		ICFBamChainObj retobj = getOrigAsChain().getSchema().getChainTableObj().createChain( getOrigAsChain() );
		if( retobj == getOrigAsChain() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getChainTableObj().updateChain( (ICFBamChainObj)this );
	}

	public void delete() {
		if( getIsNew() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getChainTableObj().deleteChain( getOrigAsChain() );
	}

	public ICFBamChainTableObj getChainTable() {
		return( orig.getSchema().getChainTableObj() );
	}

	public ICFBamChainEditObj getEdit() {
		return( (ICFBamChainEditObj)this );
	}

	public ICFBamChainEditObj getEditAsChain() {
		return( (ICFBamChainEditObj)this );
	}

	public ICFBamChainEditObj beginEdit() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamChainObj getOrig() {
		return( orig );
	}

	public ICFBamChainObj getOrigAsChain() {
		return( (ICFBamChainObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamChainBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsChain().getSchema().getBackingStore().getFactoryChain().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamChainBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerTenant = null;
			requiredContainerTable = null;
			optionalLookupDefSchema = null;
			requiredLookupPrevRel = null;
			requiredLookupNextRel = null;
		}
	}

	public CFBamChainBuff getChainBuff() {
		return( (CFBamChainBuff)getBuff() );
	}

	public CFBamChainPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamChainPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public long getRequiredTenantId() {
		return( getPKey().getRequiredTenantId() );
	}

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getChainBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getChainBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getChainBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getChainBuff().getRequiredName() != value ) {
			getChainBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getChainBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getChainBuff().getOptionalShortName() != value ) {
			getChainBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getChainBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getChainBuff().getOptionalLabel() != value ) {
			getChainBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getChainBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getChainBuff().getOptionalShortDescription() != value ) {
			getChainBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getChainBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getChainBuff().getOptionalDescription() != value ) {
			getChainBuff().setOptionalDescription( value );
		}
	}

	public long getRequiredTableId() {
		return( getChainBuff().getRequiredTableId() );
	}

	public String getOptionalSuffix() {
		return( getChainBuff().getOptionalSuffix() );
	}

	public void setOptionalSuffix( String value ) {
		if( getChainBuff().getOptionalSuffix() != value ) {
			getChainBuff().setOptionalSuffix( value );
		}
	}

	public long getRequiredPrevRelationTenantId() {
		return( getChainBuff().getRequiredPrevRelationTenantId() );
	}

	public long getRequiredPrevRelationId() {
		return( getChainBuff().getRequiredPrevRelationId() );
	}

	public long getRequiredNextRelationTenantId() {
		return( getChainBuff().getRequiredNextRelationTenantId() );
	}

	public long getRequiredNextRelationId() {
		return( getChainBuff().getRequiredNextRelationId() );
	}

	public boolean getRequiredDefaultVisibility() {
		return( getChainBuff().getRequiredDefaultVisibility() );
	}

	public void setRequiredDefaultVisibility( boolean value ) {
		if( getChainBuff().getRequiredDefaultVisibility() != value ) {
			getChainBuff().setRequiredDefaultVisibility( value );
		}
	}

	public ICFBamTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFBamTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTenantObj obj = getOrigAsChain().getSchema().getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFBamTenantObj value ) {
			if( buff == null ) {
				getChainBuff();
			}
			requiredOwnerTenant = null;
			requiredContainerTable = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getChainBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFBamTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerTable( boolean forceRead ) {
		if( forceRead || ( requiredContainerTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTableObj obj = getOrigAsChain().getSchema().getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getChainBuff().getRequiredTableId() );
				requiredContainerTable = obj;
				if( obj != null ) {
					getChainBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getChainBuff().setRequiredTableId( obj.getRequiredId() );
					requiredContainerTable = obj;
				}
			}
		}
		return( requiredContainerTable );
	}

	public void setRequiredContainerTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getChainBuff();
			}
			requiredOwnerTenant = null;
			requiredContainerTable = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getChainBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getChainBuff().setRequiredTableId( value.getRequiredId() );
			}
			requiredContainerTable = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getChainBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getChainBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = getOrigAsChain().getSchema().getSchemaDefTableObj().readSchemaDefByIdIdx( getChainBuff().getOptionalDefSchemaTenantId(),
					getChainBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getChainBuff();
			}
			if( value != null ) {
				getChainBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getChainBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getChainBuff().setOptionalDefSchemaTenantId( null );
				getChainBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public ICFBamRelationObj getRequiredLookupPrevRel() {
		return( getRequiredLookupPrevRel( false ) );
	}

	public ICFBamRelationObj getRequiredLookupPrevRel( boolean forceRead ) {
		if( forceRead || ( requiredLookupPrevRel == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamRelationObj obj = getOrigAsChain().getSchema().getRelationTableObj().readRelationByIdIdx( getChainBuff().getRequiredPrevRelationTenantId(),
					getChainBuff().getRequiredPrevRelationId() );
				requiredLookupPrevRel = obj;
			}
		}
		return( requiredLookupPrevRel );
	}

	public void setRequiredLookupPrevRel( ICFBamRelationObj value ) {
			if( buff == null ) {
				getChainBuff();
			}
			if( value != null ) {
				getChainBuff().setRequiredPrevRelationTenantId( value.getRequiredTenantId() );
				getChainBuff().setRequiredPrevRelationId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupPrevRel = value;
	}

	public ICFBamRelationObj getRequiredLookupNextRel() {
		return( getRequiredLookupNextRel( false ) );
	}

	public ICFBamRelationObj getRequiredLookupNextRel( boolean forceRead ) {
		if( forceRead || ( requiredLookupNextRel == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamRelationObj obj = getOrigAsChain().getSchema().getRelationTableObj().readRelationByIdIdx( getChainBuff().getRequiredNextRelationTenantId(),
					getChainBuff().getRequiredNextRelationId() );
				requiredLookupNextRel = obj;
			}
		}
		return( requiredLookupNextRel );
	}

	public void setRequiredLookupNextRel( ICFBamRelationObj value ) {
			if( buff == null ) {
				getChainBuff();
			}
			if( value != null ) {
				getChainBuff().setRequiredNextRelationTenantId( value.getRequiredTenantId() );
				getChainBuff().setRequiredNextRelationId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupNextRel = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFBamChainBuff origBuff = getOrigAsChain().getChainBuff();
		CFBamChainBuff myBuff = getChainBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamChainBuff origBuff = getOrigAsChain().getChainBuff();
		CFBamChainBuff myBuff = getChainBuff();
		myBuff.set( origBuff );
	}

    public ICFBamProjectBaseObj getProject()
    {
        for (ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope() ) {
            if (curDef instanceof ICFBamProjectBaseObj) {
                return ((ICFBamProjectBaseObj)curDef);
            }
            else if (curDef instanceof ICFBamTldObj) {
                return (null);
            }
        }
        return (null);
    }

    public ICFBamTopDomainObj getCompany()
    {
        for (ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope()) {
            if (curDef instanceof ICFBamTopDomainObj) {
                return ((ICFBamTopDomainObj)curDef);
            }
            else if (curDef instanceof ICFBamTldObj) {
                return (null);
            }
        }
        return (null);
    }

    public ICFBamSchemaDefObj getSchemaDef()
    {
        for (ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope()) {
            if (curDef instanceof ICFBamSchemaDefObj) {
                return ((ICFBamSchemaDefObj)curDef);
            }
            else if (curDef instanceof ICFBamTldObj) {
                return (null);
            }
        }
        return (null);
    }

    public ICFBamVersionObj getVersionLeaf()
    {
        for (ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope()) {
            if (curDef instanceof ICFBamMinorVersionObj) {
                return ((ICFBamMinorVersionObj)curDef);
            }
            else if (curDef instanceof ICFBamMajorVersionObj) {
                return ((ICFBamMajorVersionObj)curDef);
            }
            else if (curDef instanceof ICFBamVersionObj) {
                return ((ICFBamVersionObj)curDef);
            }
            else if (curDef instanceof ICFBamProjectBaseObj) {
                return (null);
            }
            else if (curDef instanceof ICFBamTldObj) {
                return (null);
            }
        }
        return (null);
    }

	protected String getVersionStringForLeafDef( ICFBamVersionObj value ) {
		String ret;
		if( value instanceof ICFBamMinorVersionObj ) {
			ret = ((ICFBamMinorVersionObj)value).getRequiredName();
		}
		else if( value instanceof ICFBamMajorVersionObj ) {
			ret = ((ICFBamMajorVersionObj)value).getRequiredName();
		}
		else {
			ret = null;
		}
		return( ret );
	}

    public String getVersionString()
    {
        ICFLibAnyObj scopeDef;
        ICFBamVersionObj versionLeafDef = getVersionLeaf();
        List<String> invertedNodeNames = new ArrayList<String>();
        while (versionLeafDef != null) {
            invertedNodeNames.add( getVersionStringForLeafDef( versionLeafDef ) );
            scopeDef = versionLeafDef.getObjScope();
            if (scopeDef == null) {
                versionLeafDef = null;
            }
            else if (scopeDef instanceof ICFBamMinorVersionObj) {
                versionLeafDef = (ICFBamMinorVersionObj)scopeDef;
            }
            else if (scopeDef instanceof ICFBamMajorVersionObj) {
                versionLeafDef = (ICFBamMajorVersionObj)scopeDef;
            }
            else if (scopeDef instanceof ICFBamVersionObj) {
                versionLeafDef = (ICFBamVersionObj)scopeDef;
            }
            else {
                versionLeafDef = null;
            }
        }
        String ret = "";
        for (int idx = invertedNodeNames.size() - 1; idx >= 0; idx--)
        {
            if (ret.length() == 0) {
                ret = invertedNodeNames.get(idx);
            }
            else {
                ret = ret + "-" + invertedNodeNames.get(idx);
            }
        }
        return( ret );
    }

    public String getPackedVersionString()
    {
        ICFLibAnyObj scopeDef;
        ICFBamVersionObj versionLeafDef = getVersionLeaf();
        List<String> invertedNodeNames = new ArrayList<String>();
        while (versionLeafDef != null) {
            invertedNodeNames.add( getVersionStringForLeafDef( versionLeafDef ) );
            scopeDef = versionLeafDef.getObjScope();
            if (scopeDef == null) {
                versionLeafDef = null;
            }
            else if (scopeDef instanceof ICFBamMinorVersionObj) {
                versionLeafDef = (ICFBamMinorVersionObj)scopeDef;
            }
            else if (scopeDef instanceof ICFBamMajorVersionObj) {
                versionLeafDef = (ICFBamMajorVersionObj)scopeDef;
            }
            else if (scopeDef instanceof ICFBamVersionObj) {
                versionLeafDef = (ICFBamVersionObj)scopeDef;
            }
            else {
                versionLeafDef = null;
            }
        }
        String ret = "";
        for (int idx = invertedNodeNames.size() - 1; idx >= 0; idx--) {
            if (ret.length() == 0) {
                ret = invertedNodeNames.get(idx);
            }
            else {
                ret = ret + invertedNodeNames.get(idx);
            }
        }
        return( ret );
    }

	/**
	 *	The core evaluation of ColumnInOwnerRelation is also to determine
	 *	if an index definition is in an owner relation.
	 *	<P>
	 *	WORKING: Yes, I know.  This should be a business method instead
	 *	of copying the code in ICFBamIndexObj and MSIsaGenBindColumnInOwnerRelation.
	 *
	 *	@param	genDef to be considered
	 *	@return	True if the column participates in an owner relation.
	 */
	public Boolean isColumnInOwnerRelation() {

		ICFLibAnyObj		focusDef;
		ICFBamTableObj		tableDef;
		final String S_ProcName = "isColumnInOwnerRelation() ";

		if( this instanceof ICFBamAtomObj ) {
			ICFBamAtomObj atomDef = (ICFBamAtomObj)this;
			ICFLibAnyObj atomScopeDef = atomDef.getObjScope();
			tableDef = (ICFBamTableObj)atomScopeDef;
			focusDef = this;
		}
		else if( this instanceof ICFBamTableColObj ) {
			ICFBamTableColObj tableColDef = (ICFBamTableColObj)this;
			ICFLibAnyObj tableColScopeDef = tableColDef.getObjScope();
			tableDef = (ICFBamTableObj)tableColScopeDef;
			focusDef = this;
		}
		else if( this instanceof ICFBamIndexColObj ) {
			ICFBamIndexColObj indexColDef = (ICFBamIndexColObj)this;
			focusDef = indexColDef.getRequiredLookupColumn();
			if( focusDef instanceof ICFBamAtomObj ) {
				tableDef = (ICFBamTableObj)((ICFBamAtomObj)focusDef).getObjScope();
			}
			else if( focusDef instanceof ICFBamTableColObj ) {
				tableDef = (ICFBamTableObj)((ICFBamTableColObj)focusDef).getObjScope();
			}
			else {
				throw new RuntimeException(
					S_ProcName + "genContext.getGenDef().getColumnDef() for a ICFBamIndexColObj did not return a ICFBamAtomObj"
						+	" nor a ICFBamTableColObj" );
			}
		}
		else if( this instanceof ICFBamRelationColObj ) {
			ICFBamRelationColObj relColDef = (ICFBamRelationColObj)this;
			ICFLibAnyObj columnDef = relColDef.getRequiredLookupFromCol();
			if( columnDef instanceof ICFBamAtomObj ) {
				focusDef = columnDef;
				tableDef = (ICFBamTableObj)columnDef.getObjScope();
			}
			else if( columnDef instanceof ICFBamTableColObj ) {
				focusDef = columnDef;
				tableDef = (ICFBamTableObj)columnDef.getObjScope();
			}
			else {
				throw new RuntimeException(
					S_ProcName + "genContext.getGenDef().getFromColumnDef() for a ICFBamIndexColObj did not return a ICFBamAtomObj"
						+	" nor a ICFBamTableColObj" );
			}
		}
		else {
			throw new RuntimeException(
				S_ProcName + "genContext.getGenDef() did not return a ICFBamAtomObj, ICFBamTableColObj, nor ICFBamIndexColObj instance" );
		}

		List<ICFBamRelationObj> ownerRelations = tableDef.getContainerOwnerRelations();
		if( ( ownerRelations == null )
		 || ( ( ownerRelations != null ) && ( ownerRelations.size() == 0 ) ) )
		{
			return( false );
		}

		ListIterator<ICFBamRelationObj> ownerEnumerator = ownerRelations.listIterator();

		ICFBamRelationObj ownerRelation;
		ICFBamRelationColObj ownerRelationCol;
		Iterator<ICFBamRelationColObj> ownerRelationCols;

		while( ownerEnumerator.hasNext() ) {

			ownerRelation = ownerEnumerator.next();
			ownerRelationCols = ownerRelation.getOptionalComponentsColumns().iterator();
			
			while( ownerRelationCols.hasNext() ) {
				ownerRelationCol = ownerRelationCols.next();
				if( ownerRelationCol.getRequiredLookupFromCol() == focusDef ) {
					return( true );
				}
			}
		}

		return( false );
	}
}
