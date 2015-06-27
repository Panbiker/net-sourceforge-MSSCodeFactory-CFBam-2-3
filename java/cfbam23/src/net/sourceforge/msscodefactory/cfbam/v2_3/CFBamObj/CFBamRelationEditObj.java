// Description: Java7 edit object instance implementation for CFBam Relation.

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

public class CFBamRelationEditObj
	extends CFBamScopeEditObj

	implements ICFBamRelationEditObj
{
	protected ICFBamTenantObj requiredOwnerRelTenant;
	protected ICFBamRelationTypeObj requiredLookupRelationType;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamTableObj requiredContainerFromTable;
	protected ICFBamIndexObj requiredLookupFromIndex;
	protected ICFBamTableObj requiredLookupToTable;
	protected ICFBamIndexObj requiredLookupToIndex;
	protected ICFBamRelationObj optionalLookupNarrowed;

	public CFBamRelationEditObj( ICFBamRelationObj argOrig ) {
		super( argOrig );
		requiredOwnerRelTenant = null;
		requiredLookupRelationType = null;
		optionalLookupDefSchema = null;
		requiredContainerFromTable = null;
		requiredLookupFromIndex = null;
		requiredLookupToTable = null;
		requiredLookupToIndex = null;
		optionalLookupNarrowed = null;
	}

	public String getClassCode() {
		return( CFBamRelationObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Relation" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamTableObj scope = getRequiredContainerFromTable();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamTableObj scope = getRequiredContainerFromTable();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredName();
		return( objName );
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
		if( subObj == null ) {
			subObj = getSchema().getRelationColTableObj().readRelationColByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
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

	public ICFBamScopeObj realize() {
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamRelationObj retobj = getSchema().getRelationTableObj().realizeRelation( (ICFBamRelationObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsRelation().getSchema().getRelationTableObj().forgetRelation( getOrigAsRelation(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamRelationObj retobj = getOrigAsRelation().getSchema().getRelationTableObj().createRelation( getOrigAsRelation() );
		if( retobj == getOrigAsRelation() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getRelationTableObj().updateRelation( (ICFBamRelationObj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getRelationTableObj().deleteRelation( getOrigAsRelation() );
	}

	public ICFBamRelationTableObj getRelationTable() {
		return( orig.getSchema().getRelationTableObj() );
	}

	public ICFBamRelationEditObj getEditAsRelation() {
		return( (ICFBamRelationEditObj)this );
	}

	public ICFBamRelationObj getOrigAsRelation() {
		return( (ICFBamRelationObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsRelation().getSchema().getBackingStore().getFactoryRelation().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredOwnerRelTenant = null;
			requiredLookupRelationType = null;
			optionalLookupDefSchema = null;
			requiredContainerFromTable = null;
			requiredLookupFromIndex = null;
			requiredLookupToTable = null;
			requiredLookupToIndex = null;
			optionalLookupNarrowed = null;
		}
	}

	public CFBamRelationBuff getRelationBuff() {
		return( (CFBamRelationBuff)getBuff() );
	}

	public long getRequiredTableId() {
		return( getRelationBuff().getRequiredTableId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getRelationBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getRelationBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getRelationBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getRelationBuff().getRequiredName() != value ) {
			getRelationBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getRelationBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getRelationBuff().getOptionalShortName() != value ) {
			getRelationBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getRelationBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getRelationBuff().getOptionalLabel() != value ) {
			getRelationBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getRelationBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getRelationBuff().getOptionalShortDescription() != value ) {
			getRelationBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getRelationBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getRelationBuff().getOptionalDescription() != value ) {
			getRelationBuff().setOptionalDescription( value );
		}
	}

	public short getRequiredRelationTypeId() {
		return( getRelationBuff().getRequiredRelationTypeId() );
	}

	public String getOptionalDbName() {
		return( getRelationBuff().getOptionalDbName() );
	}

	public void setOptionalDbName( String value ) {
		if( getRelationBuff().getOptionalDbName() != value ) {
			getRelationBuff().setOptionalDbName( value );
		}
	}

	public String getOptionalSuffix() {
		return( getRelationBuff().getOptionalSuffix() );
	}

	public void setOptionalSuffix( String value ) {
		if( getRelationBuff().getOptionalSuffix() != value ) {
			getRelationBuff().setOptionalSuffix( value );
		}
	}

	public long getRequiredFromIndexId() {
		return( getRelationBuff().getRequiredFromIndexId() );
	}

	public long getRequiredToTableId() {
		return( getRelationBuff().getRequiredToTableId() );
	}

	public long getRequiredToIndexId() {
		return( getRelationBuff().getRequiredToIndexId() );
	}

	public boolean getRequiredIsRequired() {
		return( getRelationBuff().getRequiredIsRequired() );
	}

	public void setRequiredIsRequired( boolean value ) {
		if( getRelationBuff().getRequiredIsRequired() != value ) {
			getRelationBuff().setRequiredIsRequired( value );
		}
	}

	public boolean getRequiredIsAbstract() {
		return( getRelationBuff().getRequiredIsAbstract() );
	}

	public void setRequiredIsAbstract( boolean value ) {
		if( getRelationBuff().getRequiredIsAbstract() != value ) {
			getRelationBuff().setRequiredIsAbstract( value );
		}
	}

	public boolean getRequiredIsXsdContainer() {
		return( getRelationBuff().getRequiredIsXsdContainer() );
	}

	public void setRequiredIsXsdContainer( boolean value ) {
		if( getRelationBuff().getRequiredIsXsdContainer() != value ) {
			getRelationBuff().setRequiredIsXsdContainer( value );
		}
	}

	public Long getOptionalNarrowedTenantId() {
		return( getRelationBuff().getOptionalNarrowedTenantId() );
	}

	public Long getOptionalNarrowedId() {
		return( getRelationBuff().getOptionalNarrowedId() );
	}

	public boolean getRequiredDefaultVisibility() {
		return( getRelationBuff().getRequiredDefaultVisibility() );
	}

	public void setRequiredDefaultVisibility( boolean value ) {
		if( getRelationBuff().getRequiredDefaultVisibility() != value ) {
			getRelationBuff().setRequiredDefaultVisibility( value );
		}
	}

	public ICFBamTenantObj getRequiredOwnerRelTenant() {
		return( getRequiredOwnerRelTenant( false ) );
	}

	public ICFBamTenantObj getRequiredOwnerRelTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerRelTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTenantObj obj = getOrigAsRelation().getSchema().getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerRelTenant = obj;
			}
		}
		return( requiredOwnerRelTenant );
	}

	public void setRequiredOwnerRelTenant( ICFBamTenantObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			requiredOwnerRelTenant = null;
			requiredContainerFromTable = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getRelationBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerRelTenant = value;

		super.setRequiredOwnerTenant( value );	}

	public ICFBamRelationTypeObj getRequiredLookupRelationType() {
		return( getRequiredLookupRelationType( false ) );
	}

	public ICFBamRelationTypeObj getRequiredLookupRelationType( boolean forceRead ) {
		if( forceRead || ( requiredLookupRelationType == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamRelationTypeObj obj = getOrigAsRelation().getSchema().getRelationTypeTableObj().readRelationTypeByIdIdx( getRelationBuff().getRequiredRelationTypeId() );
				requiredLookupRelationType = obj;
			}
		}
		return( requiredLookupRelationType );
	}

	public void setRequiredLookupRelationType( ICFBamRelationTypeObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getRelationBuff().setRequiredRelationTypeId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupRelationType = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getRelationBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = getOrigAsRelation().getSchema().getSchemaDefTableObj().readSchemaDefByIdIdx( getRelationBuff().getOptionalDefSchemaTenantId(),
					getRelationBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getRelationBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getRelationBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getRelationBuff().setOptionalDefSchemaTenantId( null );
				getRelationBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public ICFBamTableObj getRequiredContainerFromTable() {
		return( getRequiredContainerFromTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerFromTable( boolean forceRead ) {
		if( forceRead || ( requiredContainerFromTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTableObj obj = getOrigAsRelation().getSchema().getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredTableId() );
				requiredContainerFromTable = obj;
				if( obj != null ) {
					getRelationBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getRelationBuff().setRequiredTableId( obj.getRequiredId() );
					requiredContainerFromTable = obj;
				}
			}
		}
		return( requiredContainerFromTable );
	}

	public void setRequiredContainerFromTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			requiredOwnerRelTenant = null;
			requiredContainerFromTable = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredTableId( value.getRequiredId() );
			}
			requiredContainerFromTable = value;
	}

	public ICFBamIndexObj getRequiredLookupFromIndex() {
		return( getRequiredLookupFromIndex( false ) );
	}

	public ICFBamIndexObj getRequiredLookupFromIndex( boolean forceRead ) {
		if( forceRead || ( requiredLookupFromIndex == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamIndexObj obj = getOrigAsRelation().getSchema().getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredFromIndexId() );
				requiredLookupFromIndex = obj;
			}
		}
		return( requiredLookupFromIndex );
	}

	public void setRequiredLookupFromIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredFromIndexId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupFromIndex = value;
	}

	public ICFBamTableObj getRequiredLookupToTable() {
		return( getRequiredLookupToTable( false ) );
	}

	public ICFBamTableObj getRequiredLookupToTable( boolean forceRead ) {
		if( forceRead || ( requiredLookupToTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTableObj obj = getOrigAsRelation().getSchema().getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredToTableId() );
				requiredLookupToTable = obj;
			}
		}
		return( requiredLookupToTable );
	}

	public void setRequiredLookupToTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredToTableId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupToTable = value;
	}

	public ICFBamIndexObj getRequiredLookupToIndex() {
		return( getRequiredLookupToIndex( false ) );
	}

	public ICFBamIndexObj getRequiredLookupToIndex( boolean forceRead ) {
		if( forceRead || ( requiredLookupToIndex == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamIndexObj obj = getOrigAsRelation().getSchema().getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredToIndexId() );
				requiredLookupToIndex = obj;
			}
		}
		return( requiredLookupToIndex );
	}

	public void setRequiredLookupToIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredToIndexId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupToIndex = value;
	}

	public ICFBamRelationObj getOptionalLookupNarrowed() {
		return( getOptionalLookupNarrowed( false ) );
	}

	public ICFBamRelationObj getOptionalLookupNarrowed( boolean forceRead ) {
		if( forceRead || ( optionalLookupNarrowed == null ) ) {
			boolean anyMissing = false;
			if( getRelationBuff().getOptionalNarrowedTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationBuff().getOptionalNarrowedId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamRelationObj obj = getOrigAsRelation().getSchema().getRelationTableObj().readRelationByIdIdx( getRelationBuff().getOptionalNarrowedTenantId(),
					getRelationBuff().getOptionalNarrowedId() );
				optionalLookupNarrowed = obj;
			}
		}
		return( optionalLookupNarrowed );
	}

	public void setOptionalLookupNarrowed( ICFBamRelationObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getRelationBuff().setOptionalNarrowedTenantId( value.getRequiredTenantId() );
				getRelationBuff().setOptionalNarrowedId( value.getRequiredId() );
			}
			else {
				getRelationBuff().setOptionalNarrowedTenantId( null );
				getRelationBuff().setOptionalNarrowedId( null );
			}
			optionalLookupNarrowed = value;
	}

	public List<ICFBamRelationColObj> getOptionalComponentsColumns() {
		List<ICFBamRelationColObj> retval;
		retval = getOrigAsRelation().getSchema().getRelationColTableObj().readRelationColByRelationIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationColObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamRelationColObj> retval;
		retval = getOrigAsRelation().getSchema().getRelationColTableObj().readRelationColByRelationIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamPopTopDepObj> getOptionalComponentsPopDep() {
		List<ICFBamPopTopDepObj> retval;
		retval = getOrigAsRelation().getSchema().getPopTopDepTableObj().readPopTopDepByContRelIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamPopTopDepObj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<ICFBamPopTopDepObj> retval;
		retval = getOrigAsRelation().getSchema().getPopTopDepTableObj().readPopTopDepByContRelIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamRelationBuff origBuff = getOrigAsRelation().getRelationBuff();
		CFBamRelationBuff myBuff = getRelationBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamRelationBuff origBuff = getOrigAsRelation().getRelationBuff();
		CFBamRelationBuff myBuff = getRelationBuff();
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
