// Description: Java7 edit object instance implementation for CFBam Param.

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

public class CFBamParamEditObj
	implements ICFBamParamEditObj
{
	protected ICFBamParamObj orig;
	protected CFBamParamBuff buff;
	protected ICFBamSecUserObj createdBy = null;
	protected ICFBamSecUserObj updatedBy = null;
	protected ICFBamServerMethodObj requiredContainerServerMeth;
	protected ICFBamTenantObj requiredOwnerTenant;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamValueObj requiredLookupType;
	protected ICFBamParamObj optionalLookupPrev;
	protected ICFBamParamObj optionalLookupNext;

	public CFBamParamEditObj( ICFBamParamObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamParamBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredContainerServerMeth = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		requiredLookupType = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
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
		return( CFBamParamObj.CLASS_CODE );
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
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamParamObj retobj = getSchema().getParamTableObj().realizeParam( (ICFBamParamObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsParam().getSchema().getParamTableObj().forgetParam( getOrigAsParam(), forgetSubObjects );
	}

	public ICFBamParamObj read() {
		ICFBamParamObj retval = getOrigAsParam().read();
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamParamObj read( boolean forceRead ) {
		ICFBamParamObj retval = getOrigAsParam().read( forceRead );
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamParamObj moveUp() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
			"moveUp",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamParamObj moveDown() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
			"moveDown",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamParamObj create() {
		copyBuffToOrig();
		ICFBamParamObj retobj = getOrigAsParam().getSchema().getParamTableObj().createParam( getOrigAsParam() );
		if( retobj == getOrigAsParam() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getParamTableObj().updateParam( (ICFBamParamObj)this );
	}

	public void delete() {
		if( getIsNew() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getParamTableObj().deleteParam( getOrigAsParam() );
	}

	public ICFBamParamTableObj getParamTable() {
		return( orig.getSchema().getParamTableObj() );
	}

	public ICFBamParamEditObj getEdit() {
		return( (ICFBamParamEditObj)this );
	}

	public ICFBamParamEditObj getEditAsParam() {
		return( (ICFBamParamEditObj)this );
	}

	public ICFBamParamEditObj beginEdit() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamParamObj getOrig() {
		return( orig );
	}

	public ICFBamParamObj getOrigAsParam() {
		return( (ICFBamParamObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamParamBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsParam().getSchema().getBackingStore().getFactoryParam().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamParamBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredContainerServerMeth = null;
			requiredOwnerTenant = null;
			optionalLookupDefSchema = null;
			requiredLookupType = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
		}
	}

	public CFBamParamBuff getParamBuff() {
		return( (CFBamParamBuff)getBuff() );
	}

	public CFBamParamPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamParamPKey value ) {
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

	public void setRequiredName( String value ) {
		if( getParamBuff().getRequiredName() != value ) {
			getParamBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getParamBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getParamBuff().getOptionalShortDescription() != value ) {
			getParamBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getParamBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getParamBuff().getOptionalDescription() != value ) {
			getParamBuff().setOptionalDescription( value );
		}
	}

	public boolean getRequiredIsNullable() {
		return( getParamBuff().getRequiredIsNullable() );
	}

	public void setRequiredIsNullable( boolean value ) {
		if( getParamBuff().getRequiredIsNullable() != value ) {
			getParamBuff().setRequiredIsNullable( value );
		}
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
		if( forceRead || ( requiredContainerServerMeth == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamServerMethodObj obj = getOrigAsParam().getSchema().getServerMethodTableObj().readServerMethodByIdIdx( getPKey().getRequiredTenantId(),
					getParamBuff().getRequiredServerMethodId() );
				requiredContainerServerMeth = obj;
				if( obj != null ) {
					getParamBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getParamBuff().setRequiredServerMethodId( obj.getRequiredId() );
					requiredContainerServerMeth = obj;
				}
			}
		}
		return( requiredContainerServerMeth );
	}

	public void setRequiredContainerServerMeth( ICFBamServerMethodObj value ) {
			if( buff == null ) {
				getParamBuff();
			}
			requiredContainerServerMeth = null;
			requiredOwnerTenant = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getParamBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getParamBuff().setRequiredServerMethodId( value.getRequiredId() );
			}
			requiredContainerServerMeth = value;
	}

	public ICFBamTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFBamTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTenantObj obj = getOrigAsParam().getSchema().getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFBamTenantObj value ) {
			if( buff == null ) {
				getParamBuff();
			}
			requiredContainerServerMeth = null;
			requiredOwnerTenant = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getParamBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = getOrigAsParam().getSchema().getSchemaDefTableObj().readSchemaDefByIdIdx( getParamBuff().getOptionalDefSchemaTenantId(),
					getParamBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getParamBuff();
			}
			if( value != null ) {
				getParamBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getParamBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getParamBuff().setOptionalDefSchemaTenantId( null );
				getParamBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public ICFBamValueObj getRequiredLookupType() {
		return( getRequiredLookupType( false ) );
	}

	public ICFBamValueObj getRequiredLookupType( boolean forceRead ) {
		if( forceRead || ( requiredLookupType == null ) ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalTypeTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalTypeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamValueObj obj = getOrigAsParam().getSchema().getValueTableObj().readValueByIdIdx( getParamBuff().getOptionalTypeTenantId(),
					getParamBuff().getOptionalTypeId() );
				requiredLookupType = obj;
			}
		}
		return( requiredLookupType );
	}

	public void setRequiredLookupType( ICFBamValueObj value ) {
			if( buff == null ) {
				getParamBuff();
			}
			if( value != null ) {
				getParamBuff().setOptionalTypeTenantId( value.getRequiredTenantId() );
				getParamBuff().setOptionalTypeId( value.getRequiredId() );
			}
			else {
				getParamBuff().setOptionalTypeTenantId( null );
				getParamBuff().setOptionalTypeId( null );
			}
			requiredLookupType = value;
	}

	public ICFBamParamObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamParamObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamParamObj obj = getOrigAsParam().getSchema().getParamTableObj().readParamByIdIdx( getParamBuff().getOptionalPrevTenantId(),
					getParamBuff().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	public void setOptionalLookupPrev( ICFBamParamObj value ) {
			if( buff == null ) {
				getParamBuff();
			}
			if( value != null ) {
				getParamBuff().setOptionalPrevTenantId( value.getRequiredTenantId() );
				getParamBuff().setOptionalPrevId( value.getRequiredId() );
			}
			else {
				getParamBuff().setOptionalPrevTenantId( null );
				getParamBuff().setOptionalPrevId( null );
			}
			optionalLookupPrev = value;
	}

	public ICFBamParamObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamParamObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamParamObj obj = getOrigAsParam().getSchema().getParamTableObj().readParamByIdIdx( getParamBuff().getOptionalNextTenantId(),
					getParamBuff().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	public void setOptionalLookupNext( ICFBamParamObj value ) {
			if( buff == null ) {
				getParamBuff();
			}
			if( value != null ) {
				getParamBuff().setOptionalNextTenantId( value.getRequiredTenantId() );
				getParamBuff().setOptionalNextId( value.getRequiredId() );
			}
			else {
				getParamBuff().setOptionalNextTenantId( null );
				getParamBuff().setOptionalNextId( null );
			}
			optionalLookupNext = value;
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
		CFBamParamBuff origBuff = getOrigAsParam().getParamBuff();
		CFBamParamBuff myBuff = getParamBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamParamBuff origBuff = getOrigAsParam().getParamBuff();
		CFBamParamBuff myBuff = getParamBuff();
		myBuff.set( origBuff );
	}
}
