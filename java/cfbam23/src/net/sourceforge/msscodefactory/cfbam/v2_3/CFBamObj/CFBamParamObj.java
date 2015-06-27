// Description: Java7 base object instance implementation for CFBam Param.

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

public class CFBamParamObj
	implements ICFBamParamObj
{
	public final static String CLASS_CODE = "SPRM";
	protected ICFBamSecUserObj createdBy = null;
	protected ICFBamSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFBamParamEditObj edit;
	protected ICFBamSchemaObj schema;
	protected CFBamParamPKey pKey;
	protected CFBamParamBuff buff;
	protected ICFBamServerMethodObj requiredContainerServerMeth;
	protected ICFBamTenantObj requiredOwnerTenant;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamValueObj requiredLookupType;
	protected ICFBamParamObj optionalLookupPrev;
	protected ICFBamParamObj optionalLookupNext;

	public CFBamParamObj() {
		isNew = true;
		requiredContainerServerMeth = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		requiredLookupType = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamParamObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerServerMeth = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		requiredLookupType = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Param" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamServerMethodObj scope = getRequiredContainerServerMeth();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamServerMethodObj scope = getRequiredContainerServerMeth();
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

	public ICFBamParamObj realize() {
		ICFBamParamObj retobj = schema.getParamTableObj().realizeParam(
			(ICFBamParamObj)this );
		return( (ICFBamParamObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		schema.getParamTableObj().forgetParam( (ICFBamParamObj)this, forgetSubObjects );
	}

	public ICFBamParamObj read() {
		ICFBamParamObj retobj = schema.getParamTableObj().readParamByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamParamObj)retobj );
	}

	public ICFBamParamObj read( boolean forceRead ) {
		ICFBamParamObj retobj = schema.getParamTableObj().readParamByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamParamObj)retobj );
	}

	public ICFBamParamObj moveUp() {
		ICFBamParamObj retobj = schema.getParamTableObj().moveUpParam( this );
		return( (ICFBamParamObj)retobj );
	}

	public ICFBamParamObj moveDown() {
		ICFBamParamObj retobj = schema.getParamTableObj().moveDownParam( this );
		return( (ICFBamParamObj)retobj );
	}

	public ICFBamParamTableObj getParamTable() {
		return( schema.getParamTableObj() );
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj value ) {
		schema = value;
	}

	public CFBamParamBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = schema.getBackingStore().getFactoryParam().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = schema.getBackingStore().getTableParam().readDerivedByIdIdx( schema.getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamParamBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamParamBuff ) ) ) {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamParamBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerServerMeth = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		requiredLookupType = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamParamBuff getParamBuff() {
		return( (CFBamParamBuff)getBuff() );
	}

	public CFBamParamPKey getPKey() {
		if( pKey == null ) {
			pKey = schema.getBackingStore().getFactoryParam().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFBamParamPKey value ) {
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

	public ICFBamParamEditObj beginEdit() {
		if( edit != null ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamParamObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamParamObj)this;
		}
		else {
			lockobj = schema.getParamTableObj().lockParam( getPKey() );
		}
		edit = schema.getParamTableObj().newEditInstance( lockobj );
		return( (ICFBamParamEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFBamParamEditObj getEdit() {
		return( edit );
	}

	public ICFBamParamEditObj getEditAsParam() {
		return( (ICFBamParamEditObj)edit );
	}

	public ICFBamSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamParamBuff buff = getBuff();
			createdBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFBamSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamParamBuff buff = getBuff();
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

	public long getRequiredServerMethodId() {
		return( getParamBuff().getRequiredServerMethodId() );
	}

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getParamBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getParamBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getParamBuff().getRequiredName() );
	}

	public String getOptionalShortDescription() {
		return( getParamBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getParamBuff().getOptionalDescription() );
	}

	public boolean getRequiredIsNullable() {
		return( getParamBuff().getRequiredIsNullable() );
	}

	public Long getOptionalTypeTenantId() {
		return( getParamBuff().getOptionalTypeTenantId() );
	}

	public Long getOptionalTypeId() {
		return( getParamBuff().getOptionalTypeId() );
	}

	public Long getOptionalPrevTenantId() {
		return( getParamBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getParamBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getParamBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getParamBuff().getOptionalNextId() );
	}

	public ICFBamServerMethodObj getRequiredContainerServerMeth() {
		return( getRequiredContainerServerMeth( false ) );
	}

	public ICFBamServerMethodObj getRequiredContainerServerMeth( boolean forceRead ) {
		if( ( requiredContainerServerMeth == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerServerMeth = schema.getServerMethodTableObj().readServerMethodByIdIdx( getPKey().getRequiredTenantId(),
					getParamBuff().getRequiredServerMethodId(), forceRead );
			}
		}
		return( requiredContainerServerMeth );
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

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = schema.getSchemaDefTableObj().readSchemaDefByIdIdx( getParamBuff().getOptionalDefSchemaTenantId(),
					getParamBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public ICFBamValueObj getRequiredLookupType() {
		return( getRequiredLookupType( false ) );
	}

	public ICFBamValueObj getRequiredLookupType( boolean forceRead ) {
		if( ( requiredLookupType == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalTypeTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalTypeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				requiredLookupType = schema.getValueTableObj().readValueByIdIdx( getParamBuff().getOptionalTypeTenantId(),
					getParamBuff().getOptionalTypeId(), forceRead );
			}
		}
		return( requiredLookupType );
	}

	public ICFBamParamObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamParamObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = schema.getParamTableObj().readParamByIdIdx( getParamBuff().getOptionalPrevTenantId(),
					getParamBuff().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	public ICFBamParamObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamParamObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = schema.getParamTableObj().readParamByIdIdx( getParamBuff().getOptionalNextTenantId(),
					getParamBuff().getOptionalNextId(), forceRead );
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
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredId( buff.getRequiredId() );
	}
}
