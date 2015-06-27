// Description: Java7 edit object instance implementation for CFBam License.

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

public class CFBamLicenseEditObj
	implements ICFBamLicenseEditObj
{
	protected ICFBamLicenseObj orig;
	protected CFBamLicenseBuff buff;
	protected ICFBamTenantObj requiredOwnerTenant;
	protected ICFBamDomainBaseObj requiredContainerDomain;

	public CFBamLicenseEditObj( ICFBamLicenseObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamLicenseBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerTenant = null;
		requiredContainerDomain = null;
	}

	public String getClassCode() {
		return( CFBamLicenseObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "License" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamDomainBaseObj scope = getRequiredContainerDomain();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamDomainBaseObj scope = getRequiredContainerDomain();
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

	public ICFBamLicenseObj realize() {
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamLicenseObj retobj = getSchema().getLicenseTableObj().realizeLicense( (ICFBamLicenseObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsLicense().getSchema().getLicenseTableObj().forgetLicense( getOrigAsLicense(), forgetSubObjects );
	}

	public ICFBamLicenseObj read() {
		ICFBamLicenseObj retval = getOrigAsLicense().read();
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamLicenseObj read( boolean forceRead ) {
		ICFBamLicenseObj retval = getOrigAsLicense().read( forceRead );
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamLicenseObj create() {
		copyBuffToOrig();
		ICFBamLicenseObj retobj = getOrigAsLicense().getSchema().getLicenseTableObj().createLicense( getOrigAsLicense() );
		if( retobj == getOrigAsLicense() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getLicenseTableObj().updateLicense( (ICFBamLicenseObj)this );
	}

	public void delete() {
		if( getIsNew() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getLicenseTableObj().deleteLicense( getOrigAsLicense() );
	}

	public ICFBamLicenseTableObj getLicenseTable() {
		return( orig.getSchema().getLicenseTableObj() );
	}

	public ICFBamLicenseEditObj getEdit() {
		return( (ICFBamLicenseEditObj)this );
	}

	public ICFBamLicenseEditObj getEditAsLicense() {
		return( (ICFBamLicenseEditObj)this );
	}

	public ICFBamLicenseEditObj beginEdit() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamLicenseObj getOrig() {
		return( orig );
	}

	public ICFBamLicenseObj getOrigAsLicense() {
		return( (ICFBamLicenseObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamLicenseBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsLicense().getSchema().getBackingStore().getFactoryLicense().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamLicenseBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerTenant = null;
			requiredContainerDomain = null;
		}
	}

	public CFBamLicenseBuff getLicenseBuff() {
		return( (CFBamLicenseBuff)getBuff() );
	}

	public CFBamLicensePKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamLicensePKey value ) {
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

	public long getRequiredDomainId() {
		return( getLicenseBuff().getRequiredDomainId() );
	}

	public String getRequiredName() {
		return( getLicenseBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getLicenseBuff().getRequiredName() != value ) {
			getLicenseBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getLicenseBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getLicenseBuff().getOptionalShortName() != value ) {
			getLicenseBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getLicenseBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getLicenseBuff().getOptionalLabel() != value ) {
			getLicenseBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getLicenseBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getLicenseBuff().getOptionalShortDescription() != value ) {
			getLicenseBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getLicenseBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getLicenseBuff().getOptionalDescription() != value ) {
			getLicenseBuff().setOptionalDescription( value );
		}
	}

	public String getOptionalEmbeddedText() {
		return( getLicenseBuff().getOptionalEmbeddedText() );
	}

	public void setOptionalEmbeddedText( String value ) {
		if( getLicenseBuff().getOptionalEmbeddedText() != value ) {
			getLicenseBuff().setOptionalEmbeddedText( value );
		}
	}

	public String getOptionalFullText() {
		return( getLicenseBuff().getOptionalFullText() );
	}

	public void setOptionalFullText( String value ) {
		if( getLicenseBuff().getOptionalFullText() != value ) {
			getLicenseBuff().setOptionalFullText( value );
		}
	}

	public ICFBamTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFBamTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTenantObj obj = getOrigAsLicense().getSchema().getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFBamTenantObj value ) {
			if( buff == null ) {
				getLicenseBuff();
			}
			requiredOwnerTenant = null;
			requiredContainerDomain = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getLicenseBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFBamDomainBaseObj getRequiredContainerDomain() {
		return( getRequiredContainerDomain( false ) );
	}

	public ICFBamDomainBaseObj getRequiredContainerDomain( boolean forceRead ) {
		if( forceRead || ( requiredContainerDomain == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamDomainBaseObj obj = getOrigAsLicense().getSchema().getDomainBaseTableObj().readDomainBaseByIdIdx( getPKey().getRequiredTenantId(),
					getLicenseBuff().getRequiredDomainId() );
				requiredContainerDomain = obj;
				if( obj != null ) {
					getLicenseBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getLicenseBuff().setRequiredDomainId( obj.getRequiredId() );
					requiredContainerDomain = obj;
				}
			}
		}
		return( requiredContainerDomain );
	}

	public void setRequiredContainerDomain( ICFBamDomainBaseObj value ) {
			if( buff == null ) {
				getLicenseBuff();
			}
			requiredOwnerTenant = null;
			requiredContainerDomain = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getLicenseBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getLicenseBuff().setRequiredDomainId( value.getRequiredId() );
			}
			requiredContainerDomain = value;
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
		CFBamLicenseBuff origBuff = getOrigAsLicense().getLicenseBuff();
		CFBamLicenseBuff myBuff = getLicenseBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamLicenseBuff origBuff = getOrigAsLicense().getLicenseBuff();
		CFBamLicenseBuff myBuff = getLicenseBuff();
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
