// Description: Java7 base object instance implementation for CFBam Value.

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

public class CFBamValueObj
	implements ICFBamValueObj
{
	public final static String CLASS_CODE = "VALU";
	protected ICFBamSecUserObj createdBy = null;
	protected ICFBamSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFBamValueEditObj edit;
	protected ICFBamSchemaObj schema;
	protected CFBamValuePKey pKey;
	protected CFBamValueBuff buff;
	protected ICFBamTenantObj requiredOwnerTenant;
	protected ICFBamScopeObj requiredContainerScope;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamDataScopeObj optionalLookupDataScope;
	protected ICFBamAccessSecurityObj optionalLookupVAccSec;
	protected ICFBamAccessSecurityObj optionalLookupEAccSec;
	protected ICFBamAccessFrequencyObj optionalLookupVAccFreq;
	protected ICFBamAccessFrequencyObj optionalLookupEAccFreq;
	protected ICFBamValueObj optionalLookupPrev;
	protected ICFBamValueObj optionalLookupNext;

	public CFBamValueObj() {
		getPKey().setClassCode( getClassCode() );
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupDataScope = null;
		optionalLookupVAccSec = null;
		optionalLookupEAccSec = null;
		optionalLookupVAccFreq = null;
		optionalLookupEAccFreq = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamValueObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		getPKey().setClassCode( getClassCode() );
		requiredOwnerTenant = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupDataScope = null;
		optionalLookupVAccSec = null;
		optionalLookupEAccSec = null;
		optionalLookupVAccFreq = null;
		optionalLookupEAccFreq = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Value" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamScopeObj scope = getRequiredContainerScope();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamScopeObj scope = getRequiredContainerScope();
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

	public ICFBamValueObj realize() {
		ICFBamValueObj retobj = schema.getValueTableObj().realizeValue(
			(ICFBamValueObj)this );
		return( (ICFBamValueObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		schema.getValueTableObj().forgetValue( (ICFBamValueObj)this, forgetSubObjects );
	}

	public ICFBamValueObj read() {
		ICFBamValueObj retobj = schema.getValueTableObj().readValueByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj read( boolean forceRead ) {
		ICFBamValueObj retobj = schema.getValueTableObj().readValueByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveUp() {
		ICFBamValueObj retobj = schema.getValueTableObj().moveUpValue( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveDown() {
		ICFBamValueObj retobj = schema.getValueTableObj().moveDownValue( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueTableObj getValueTable() {
		return( schema.getValueTableObj() );
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj value ) {
		schema = value;
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = schema.getBackingStore().getFactoryValue().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = schema.getBackingStore().getTableValue().readDerivedByIdIdx( schema.getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamValueBuff ) ) ) {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamValueBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupDataScope = null;
		optionalLookupVAccSec = null;
		optionalLookupEAccSec = null;
		optionalLookupVAccFreq = null;
		optionalLookupEAccFreq = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamValueBuff getValueBuff() {
		return( (CFBamValueBuff)getBuff() );
	}

	public CFBamValuePKey getPKey() {
		if( pKey == null ) {
			pKey = schema.getBackingStore().getFactoryValue().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFBamValuePKey value ) {
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

	public ICFBamValueEditObj beginEdit() {
		if( edit != null ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamValueObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamValueObj)this;
		}
		else {
			lockobj = schema.getValueTableObj().lockValue( getPKey() );
		}
		edit = schema.getValueTableObj().newEditInstance( lockobj );
		return( (ICFBamValueEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFBamValueEditObj getEdit() {
		return( edit );
	}

	public ICFBamValueEditObj getEditAsValue() {
		return( (ICFBamValueEditObj)edit );
	}

	public ICFBamSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamValueBuff buff = getBuff();
			createdBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFBamSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamValueBuff buff = getBuff();
			updatedBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredTenantId() {
		return( getPKey().getRequiredTenantId() );
	}

	public long getRequiredScopeId() {
		return( getValueBuff().getRequiredScopeId() );
	}

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getValueBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getValueBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getValueBuff().getRequiredName() );
	}

	public String getOptionalShortName() {
		return( getValueBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getValueBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getValueBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getValueBuff().getOptionalDescription() );
	}

	public boolean getRequiredIsNullable() {
		return( getValueBuff().getRequiredIsNullable() );
	}

	public Boolean getOptionalGenerateId() {
		return( getValueBuff().getOptionalGenerateId() );
	}

	public Short getOptionalDataScopeId() {
		return( getValueBuff().getOptionalDataScopeId() );
	}

	public Short getOptionalViewAccessSecurityId() {
		return( getValueBuff().getOptionalViewAccessSecurityId() );
	}

	public Short getOptionalEditAccessSecurityId() {
		return( getValueBuff().getOptionalEditAccessSecurityId() );
	}

	public Short getOptionalViewAccessFrequencyId() {
		return( getValueBuff().getOptionalViewAccessFrequencyId() );
	}

	public Short getOptionalEditAccessFrequencyId() {
		return( getValueBuff().getOptionalEditAccessFrequencyId() );
	}

	public Long getOptionalPrevTenantId() {
		return( getValueBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getValueBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getValueBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getValueBuff().getOptionalNextId() );
	}

	public boolean getRequiredDefaultVisibility() {
		return( getValueBuff().getRequiredDefaultVisibility() );
	}

	public ICFBamTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFBamTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = schema.getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	public ICFBamScopeObj getRequiredContainerScope() {
		return( getRequiredContainerScope( false ) );
	}

	public ICFBamScopeObj getRequiredContainerScope( boolean forceRead ) {
		if( ( requiredContainerScope == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerScope = schema.getScopeTableObj().readScopeByIdIdx( getPKey().getRequiredTenantId(),
					getValueBuff().getRequiredScopeId(), forceRead );
			}
		}
		return( requiredContainerScope );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = schema.getSchemaDefTableObj().readSchemaDefByIdIdx( getValueBuff().getOptionalDefSchemaTenantId(),
					getValueBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope() {
		return( getOptionalLookupDataScope( false ) );
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope( boolean forceRead ) {
		if( ( optionalLookupDataScope == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalDataScopeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDataScope = schema.getDataScopeTableObj().readDataScopeByIdIdx( getValueBuff().getOptionalDataScopeId(), forceRead );
			}
		}
		return( optionalLookupDataScope );
	}

	public ICFBamAccessSecurityObj getOptionalLookupVAccSec() {
		return( getOptionalLookupVAccSec( false ) );
	}

	public ICFBamAccessSecurityObj getOptionalLookupVAccSec( boolean forceRead ) {
		if( ( optionalLookupVAccSec == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalViewAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupVAccSec = schema.getAccessSecurityTableObj().readAccessSecurityByIdIdx( getValueBuff().getOptionalViewAccessSecurityId(), forceRead );
			}
		}
		return( optionalLookupVAccSec );
	}

	public ICFBamAccessSecurityObj getOptionalLookupEAccSec() {
		return( getOptionalLookupEAccSec( false ) );
	}

	public ICFBamAccessSecurityObj getOptionalLookupEAccSec( boolean forceRead ) {
		if( ( optionalLookupEAccSec == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalEditAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupEAccSec = schema.getAccessSecurityTableObj().readAccessSecurityByIdIdx( getValueBuff().getOptionalEditAccessSecurityId(), forceRead );
			}
		}
		return( optionalLookupEAccSec );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupVAccFreq() {
		return( getOptionalLookupVAccFreq( false ) );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupVAccFreq( boolean forceRead ) {
		if( ( optionalLookupVAccFreq == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalViewAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupVAccFreq = schema.getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getValueBuff().getOptionalViewAccessFrequencyId(), forceRead );
			}
		}
		return( optionalLookupVAccFreq );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupEAccFreq() {
		return( getOptionalLookupEAccFreq( false ) );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupEAccFreq( boolean forceRead ) {
		if( ( optionalLookupEAccFreq == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalEditAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupEAccFreq = schema.getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getValueBuff().getOptionalEditAccessFrequencyId(), forceRead );
			}
		}
		return( optionalLookupEAccFreq );
	}

	public ICFBamValueObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamValueObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = schema.getValueTableObj().readValueByIdIdx( getValueBuff().getOptionalPrevTenantId(),
					getValueBuff().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	public ICFBamValueObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamValueObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = schema.getValueTableObj().readValueByIdIdx( getValueBuff().getOptionalNextTenantId(),
					getValueBuff().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
			buff.setRequiredId( getPKey().getRequiredId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setClassCode( buff.getClassCode() );
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredId( buff.getRequiredId() );
	}

    public List<ICFBamIndexObj> getAffectedIndexes()
    {
        List<ICFBamIndexObj> list = new LinkedList<ICFBamIndexObj>();
        ICFBamScopeObj container = getRequiredContainerScope();
        ICFBamTableObj tableDef = null;
        if( container == null ) {
            throw new RuntimeException("RMValueDefObj.getAffectedIndexes() RequiredContainerScope has no value");
        }
        else if( container instanceof ICFBamTableObj ) {
        	tableDef = (ICFBamTableObj)container;
        }
        else {
        	throw new RuntimeException( "RMValueDefObj.getAffectedIndexes() RequiredContainerScope is not an ICFBamTableObj");
        }
        Iterator<ICFBamIndexObj> cursorIndexDef = tableDef.getOptionalComponentsIndex().iterator();
        while (cursorIndexDef.hasNext())
        {
            ICFBamIndexObj indexDef = cursorIndexDef.next();

            Iterator<ICFBamIndexColObj> cursorIndexColDef = indexDef.getOptionalComponentsColumns().iterator();
            while (cursorIndexColDef.hasNext())
            {
                ICFBamIndexColObj indexColDef = cursorIndexColDef.next();
                if (indexColDef.getRequiredLookupColumn().equals(this))
                {
                    list.add(indexDef);
                }
            }
        }
        return (list);
    }

    public List<ICFBamRelationObj> getAffectedRelations()
    {
        List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
        ICFBamScopeObj container = getRequiredContainerScope();
        ICFBamTableObj tableDef = null;
        if( container == null ) {
            throw new RuntimeException("RMValueDefObj.getAffectedRelations() RequiredContainerScope has no value");
        }
        else if( container instanceof ICFBamTableObj ) {
        	tableDef = (ICFBamTableObj)container;
        }
        else {
        	throw new RuntimeException( "RMValueDefObj.getAffectedRelations() RequiredContainerScope is not an ICFBamTableObj");
        }
        Iterator<ICFBamRelationObj> cursorRelationDef = tableDef.getOptionalComponentsRelation().iterator();
        while (cursorRelationDef.hasNext())
        {
            ICFBamRelationObj relationDef = cursorRelationDef.next();
            Iterator<ICFBamRelationColObj> cursorRelationColDef = relationDef.getOptionalComponentsColumns().iterator();
            while (cursorRelationColDef.hasNext())
            {
                ICFBamRelationColObj relationColDef = cursorRelationColDef.next();
                if (relationColDef.getRequiredLookupFromCol().equals(this))
                {
                    list.add(relationDef);
                }
            }
        }
        return (list);
    }

    public List<ICFBamIndexObj> getAffectedUniqueIndexes()
    {
        List<ICFBamIndexObj> affectedIndexes = getAffectedIndexes();
        List<ICFBamIndexObj> list = new LinkedList<ICFBamIndexObj>();
        ICFBamScopeObj container = getRequiredContainerScope();
        ICFBamTableObj tableDef = null;
        if( container == null ) {
            throw new RuntimeException("RMValueDefObj.getAffectedUniqueIndexes() RequiredContainerScope has no value");
        }
        else if( container instanceof ICFBamTableObj ) {
        	tableDef = (ICFBamTableObj)container;
        }
        else {
        	throw new RuntimeException( "RMValueDefObj.getAffectedUniqueIndexes() RequiredContainerScope is not an ICFBamTableObj");
        }
        Iterator<ICFBamIndexObj> cursorIndexDef = affectedIndexes.iterator();
        while (cursorIndexDef.hasNext())
        {
            ICFBamIndexObj indexDef = cursorIndexDef.next();
            if (indexDef.getRequiredIsUnique())
            {
                list.add(indexDef);
            }
        }
        return (list);
    }

    public List<ICFBamRelationObj> getColumnInMemberRelations()
    {
        final String S_ProcName = "RMValueDefObj.getColumnInMemberRelations() ";

        ICFBamScopeObj scopeDef = (ICFBamScopeObj)getObjScope();
        if (scopeDef == null)
        {
            throw new RuntimeException(S_ProcName + "OptionalParentScope is required");
        }
        else if (scopeDef instanceof ICFBamTableObj)
        {
            List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
            Iterator<ICFBamRelationObj> relations = ((ICFBamTableObj)scopeDef).getOptionalComponentsRelation().iterator();
            ICFBamRelationColObj relationCol;
            Iterator<ICFBamRelationColObj> relationColumns;
            ICFBamRelationObj relation;
            String relationTypeName;
            while (relations.hasNext())
            {
                relation = relations.next();
                relationTypeName = relation.getRequiredLookupRelationType().getRequiredTag();
                if (	//	relationTypeName.equals( "Unknown" )
                    //								relationTypeName.equals( "Superclass" )
                        relationTypeName.equals("Lookup")
                    || relationTypeName.equals("Master")
                    || relationTypeName.equals("Details")
                    || relationTypeName.equals("Container")
                    || relationTypeName.equals("Components")
                    || relationTypeName.equals("Parent")
                    || relationTypeName.equals("Children")
                    || relationTypeName.equals("Owner"))
                {
                    relationColumns = relation.getOptionalComponentsColumns().iterator();
                    while (relationColumns.hasNext())
                    {
                        relationCol = relationColumns.next();
                        if (this == relationCol.getRequiredLookupFromCol())
                        {
                            list.add(relation);
                            break;
                        }
                    }
                }
            }
            return (list);
        }
        else
        {
            throw new RuntimeException(S_ProcName + "Expected scope definition to be an ICFBamTableObj");
        }
    }

    public List<ICFBamRelationObj> getColumnInComponentsRelations()
    {
        final String S_ProcName = "RMValueDefObj.getColumnInComponentsRelations() ";

        ICFBamScopeObj container = getRequiredContainerScope();
        ICFBamTableObj tableDef = null;
        if( container == null ) {
            throw new RuntimeException("RMValueDefObj.getColumnInComponentsRelations() RequiredContainerScope has no value");
        }
        else if( container instanceof ICFBamTableObj ) {
        	tableDef = (ICFBamTableObj)container;
        }
        else {
        	throw new RuntimeException( "RMValueDefObj.getColumnInComponentsRelations() RequiredContainerScope is not an ICFBamTableObj");
        }

        ICFBamRelationColObj relationCol;
        ICFBamRelationObj relation;
        Iterator<ICFBamRelationColObj> relationColumns;
        String relationTypeName;
        List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
        Iterator<ICFBamRelationObj> relations = tableDef.getOptionalComponentsRelation().iterator();

        while( relations.hasNext() ) {
        	relation = relations.next();
        	relationTypeName = relation.getRequiredLookupRelationType().getRequiredTag();
        	if( relationTypeName.equals( "Components" ) ) {
                relationColumns = relation.getOptionalComponentsColumns().iterator();
                while (relationColumns.hasNext()) {
                    relationCol = relationColumns.next();
                    if (this == relationCol.getRequiredLookupFromCol()) {
                        list.add(relation);
                        break;
                    }
                }
        	}
        }
        
        return( list );
    }

    public boolean getGenerateId()
    {
        boolean ret;
        if (getOptionalGenerateId() != null )         {
            ret = getOptionalGenerateId().booleanValue();
        }
        else {
            ret = false;
        }
        return (ret);
    }
}
