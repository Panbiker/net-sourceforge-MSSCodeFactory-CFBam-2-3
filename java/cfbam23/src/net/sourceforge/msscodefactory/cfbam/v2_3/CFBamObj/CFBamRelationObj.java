// Description: Java7 base object instance implementation for CFBam Relation.

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

public class CFBamRelationObj
	extends CFBamScopeObj
	implements ICFBamRelationObj
{
	public final static String CLASS_CODE = "RELD";
	protected ICFBamTenantObj requiredOwnerRelTenant;
	protected ICFBamRelationTypeObj requiredLookupRelationType;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamTableObj requiredContainerFromTable;
	protected ICFBamIndexObj requiredLookupFromIndex;
	protected ICFBamTableObj requiredLookupToTable;
	protected ICFBamIndexObj requiredLookupToIndex;
	protected ICFBamRelationObj optionalLookupNarrowed;

	public CFBamRelationObj() {
		super();
		requiredOwnerRelTenant = null;
		requiredLookupRelationType = null;
		optionalLookupDefSchema = null;
		requiredContainerFromTable = null;
		requiredLookupFromIndex = null;
		requiredLookupToTable = null;
		requiredLookupToIndex = null;
		optionalLookupNarrowed = null;
	}

	public CFBamRelationObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
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
		return( CLASS_CODE );
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
		ICFBamRelationObj retobj = schema.getRelationTableObj().realizeRelation(
			(ICFBamRelationObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		schema.getRelationTableObj().forgetRelation( (ICFBamRelationObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamRelationObj retobj = schema.getRelationTableObj().readRelationByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamRelationObj retobj = schema.getRelationTableObj().readRelationByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamRelationTableObj getRelationTable() {
		return( schema.getRelationTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = schema.getBackingStore().getFactoryRelation().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = schema.getBackingStore().getTableRelation().readDerivedByIdIdx( schema.getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamRelationBuff ) ) ) {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamRelationBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredOwnerRelTenant = null;
		requiredLookupRelationType = null;
		optionalLookupDefSchema = null;
		requiredContainerFromTable = null;
		requiredLookupFromIndex = null;
		requiredLookupToTable = null;
		requiredLookupToIndex = null;
		optionalLookupNarrowed = null;
	}

	public CFBamRelationBuff getRelationBuff() {
		return( (CFBamRelationBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamRelationObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamRelationObj)this;
		}
		else {
			lockobj = schema.getRelationTableObj().lockRelation( getPKey() );
		}
		edit = schema.getRelationTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamRelationEditObj getEditAsRelation() {
		return( (ICFBamRelationEditObj)edit );
	}

	public ICFBamSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamScopeBuff buff = getBuff();
			createdBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFBamSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamScopeBuff buff = getBuff();
			updatedBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
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

	public String getOptionalShortName() {
		return( getRelationBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getRelationBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getRelationBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getRelationBuff().getOptionalDescription() );
	}

	public short getRequiredRelationTypeId() {
		return( getRelationBuff().getRequiredRelationTypeId() );
	}

	public String getOptionalDbName() {
		return( getRelationBuff().getOptionalDbName() );
	}

	public String getOptionalSuffix() {
		return( getRelationBuff().getOptionalSuffix() );
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

	public boolean getRequiredIsAbstract() {
		return( getRelationBuff().getRequiredIsAbstract() );
	}

	public boolean getRequiredIsXsdContainer() {
		return( getRelationBuff().getRequiredIsXsdContainer() );
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

	public ICFBamTenantObj getRequiredOwnerRelTenant() {
		return( getRequiredOwnerRelTenant( false ) );
	}

	public ICFBamTenantObj getRequiredOwnerRelTenant( boolean forceRead ) {
		if( ( requiredOwnerRelTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerRelTenant = schema.getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerRelTenant );
	}

	public ICFBamRelationTypeObj getRequiredLookupRelationType() {
		return( getRequiredLookupRelationType( false ) );
	}

	public ICFBamRelationTypeObj getRequiredLookupRelationType( boolean forceRead ) {
		if( ( requiredLookupRelationType == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupRelationType = schema.getRelationTypeTableObj().readRelationTypeByIdIdx( getRelationBuff().getRequiredRelationTypeId(), forceRead );
			}
		}
		return( requiredLookupRelationType );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getRelationBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = schema.getSchemaDefTableObj().readSchemaDefByIdIdx( getRelationBuff().getOptionalDefSchemaTenantId(),
					getRelationBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public ICFBamTableObj getRequiredContainerFromTable() {
		return( getRequiredContainerFromTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerFromTable( boolean forceRead ) {
		if( ( requiredContainerFromTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerFromTable = schema.getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredTableId(), forceRead );
			}
		}
		return( requiredContainerFromTable );
	}

	public ICFBamIndexObj getRequiredLookupFromIndex() {
		return( getRequiredLookupFromIndex( false ) );
	}

	public ICFBamIndexObj getRequiredLookupFromIndex( boolean forceRead ) {
		if( ( requiredLookupFromIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupFromIndex = schema.getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredFromIndexId(), forceRead );
			}
		}
		return( requiredLookupFromIndex );
	}

	public ICFBamTableObj getRequiredLookupToTable() {
		return( getRequiredLookupToTable( false ) );
	}

	public ICFBamTableObj getRequiredLookupToTable( boolean forceRead ) {
		if( ( requiredLookupToTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupToTable = schema.getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredToTableId(), forceRead );
			}
		}
		return( requiredLookupToTable );
	}

	public ICFBamIndexObj getRequiredLookupToIndex() {
		return( getRequiredLookupToIndex( false ) );
	}

	public ICFBamIndexObj getRequiredLookupToIndex( boolean forceRead ) {
		if( ( requiredLookupToIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupToIndex = schema.getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredToIndexId(), forceRead );
			}
		}
		return( requiredLookupToIndex );
	}

	public ICFBamRelationObj getOptionalLookupNarrowed() {
		return( getOptionalLookupNarrowed( false ) );
	}

	public ICFBamRelationObj getOptionalLookupNarrowed( boolean forceRead ) {
		if( ( optionalLookupNarrowed == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getRelationBuff().getOptionalNarrowedTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationBuff().getOptionalNarrowedId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNarrowed = schema.getRelationTableObj().readRelationByIdIdx( getRelationBuff().getOptionalNarrowedTenantId(),
					getRelationBuff().getOptionalNarrowedId(), forceRead );
			}
		}
		return( optionalLookupNarrowed );
	}

	public List<ICFBamRelationColObj> getOptionalComponentsColumns() {
		List<ICFBamRelationColObj> retval;
		retval = schema.getRelationColTableObj().readRelationColByRelationIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationColObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamRelationColObj> retval;
		retval = schema.getRelationColTableObj().readRelationColByRelationIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamPopTopDepObj> getOptionalComponentsPopDep() {
		List<ICFBamPopTopDepObj> retval;
		retval = schema.getPopTopDepTableObj().readPopTopDepByContRelIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamPopTopDepObj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<ICFBamPopTopDepObj> retval;
		retval = schema.getPopTopDepTableObj().readPopTopDepByContRelIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
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
