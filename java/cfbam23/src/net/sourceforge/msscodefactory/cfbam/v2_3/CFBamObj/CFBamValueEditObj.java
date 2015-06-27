// Description: Java7 edit object instance implementation for CFBam Value.

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

public class CFBamValueEditObj
	implements ICFBamValueEditObj
{
	protected ICFBamValueObj orig;
	protected CFBamValueBuff buff;
	protected ICFBamSecUserObj createdBy = null;
	protected ICFBamSecUserObj updatedBy = null;
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

	public CFBamValueEditObj( ICFBamValueObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamValueBuff origBuff = orig.getBuff();
		buff.set( origBuff );
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
		return( CFBamValueObj.CLASS_CODE );
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
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamValueObj retobj = getSchema().getValueTableObj().realizeValue( (ICFBamValueObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsValue().getSchema().getValueTableObj().forgetValue( getOrigAsValue(), forgetSubObjects );
	}

	public ICFBamValueObj read() {
		ICFBamValueObj retval = getOrigAsValue().read();
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamValueObj read( boolean forceRead ) {
		ICFBamValueObj retval = getOrigAsValue().read( forceRead );
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamValueObj moveUp() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
			"moveUp",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamValueObj moveDown() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
			"moveDown",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamValueObj create() {
		copyBuffToOrig();
		ICFBamValueObj retobj = getOrigAsValue().getSchema().getValueTableObj().createValue( getOrigAsValue() );
		if( retobj == getOrigAsValue() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getValueTableObj().updateValue( (ICFBamValueObj)this );
	}

	public void delete() {
		if( getIsNew() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getValueTableObj().deleteValue( getOrigAsValue() );
	}

	public ICFBamValueTableObj getValueTable() {
		return( orig.getSchema().getValueTableObj() );
	}

	public ICFBamValueEditObj getEdit() {
		return( (ICFBamValueEditObj)this );
	}

	public ICFBamValueEditObj getEditAsValue() {
		return( (ICFBamValueEditObj)this );
	}

	public ICFBamValueEditObj beginEdit() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamValueObj getOrig() {
		return( orig );
	}

	public ICFBamValueObj getOrigAsValue() {
		return( (ICFBamValueObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsValue().getSchema().getBackingStore().getFactoryValue().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			buff = value;
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
	}

	public CFBamValueBuff getValueBuff() {
		return( (CFBamValueBuff)getBuff() );
	}

	public CFBamValuePKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamValuePKey value ) {
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

	public void setRequiredName( String value ) {
		if( getValueBuff().getRequiredName() != value ) {
			getValueBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getValueBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getValueBuff().getOptionalShortName() != value ) {
			getValueBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getValueBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getValueBuff().getOptionalLabel() != value ) {
			getValueBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getValueBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getValueBuff().getOptionalShortDescription() != value ) {
			getValueBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getValueBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getValueBuff().getOptionalDescription() != value ) {
			getValueBuff().setOptionalDescription( value );
		}
	}

	public boolean getRequiredIsNullable() {
		return( getValueBuff().getRequiredIsNullable() );
	}

	public void setRequiredIsNullable( boolean value ) {
		if( getValueBuff().getRequiredIsNullable() != value ) {
			getValueBuff().setRequiredIsNullable( value );
		}
	}

	public Boolean getOptionalGenerateId() {
		return( getValueBuff().getOptionalGenerateId() );
	}

	public void setOptionalGenerateId( Boolean value ) {
		if( getValueBuff().getOptionalGenerateId() != value ) {
			getValueBuff().setOptionalGenerateId( value );
		}
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

	public void setRequiredDefaultVisibility( boolean value ) {
		if( getValueBuff().getRequiredDefaultVisibility() != value ) {
			getValueBuff().setRequiredDefaultVisibility( value );
		}
	}

	public ICFBamTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFBamTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTenantObj obj = getOrigAsValue().getSchema().getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFBamTenantObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			requiredOwnerTenant = null;
			requiredContainerScope = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getValueBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFBamScopeObj getRequiredContainerScope() {
		return( getRequiredContainerScope( false ) );
	}

	public ICFBamScopeObj getRequiredContainerScope( boolean forceRead ) {
		if( forceRead || ( requiredContainerScope == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamScopeObj obj = getOrigAsValue().getSchema().getScopeTableObj().readScopeByIdIdx( getPKey().getRequiredTenantId(),
					getValueBuff().getRequiredScopeId() );
				requiredContainerScope = obj;
				if( obj != null ) {
					getValueBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getValueBuff().setRequiredScopeId( obj.getRequiredId() );
					requiredContainerScope = obj;
				}
			}
		}
		return( requiredContainerScope );
	}

	public void setRequiredContainerScope( ICFBamScopeObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			requiredOwnerTenant = null;
			requiredContainerScope = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getValueBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getValueBuff().setRequiredScopeId( value.getRequiredId() );
			}
			requiredContainerScope = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = getOrigAsValue().getSchema().getSchemaDefTableObj().readSchemaDefByIdIdx( getValueBuff().getOptionalDefSchemaTenantId(),
					getValueBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getValueBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalDefSchemaTenantId( null );
				getValueBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope() {
		return( getOptionalLookupDataScope( false ) );
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope( boolean forceRead ) {
		if( forceRead || ( optionalLookupDataScope == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalDataScopeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamDataScopeObj obj = getOrigAsValue().getSchema().getDataScopeTableObj().readDataScopeByIdIdx( getValueBuff().getOptionalDataScopeId() );
				optionalLookupDataScope = obj;
			}
		}
		return( optionalLookupDataScope );
	}

	public void setOptionalLookupDataScope( ICFBamDataScopeObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalDataScopeId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalDataScopeId( null );
			}
			optionalLookupDataScope = value;
	}

	public ICFBamAccessSecurityObj getOptionalLookupVAccSec() {
		return( getOptionalLookupVAccSec( false ) );
	}

	public ICFBamAccessSecurityObj getOptionalLookupVAccSec( boolean forceRead ) {
		if( forceRead || ( optionalLookupVAccSec == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalViewAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessSecurityObj obj = getOrigAsValue().getSchema().getAccessSecurityTableObj().readAccessSecurityByIdIdx( getValueBuff().getOptionalViewAccessSecurityId() );
				optionalLookupVAccSec = obj;
			}
		}
		return( optionalLookupVAccSec );
	}

	public void setOptionalLookupVAccSec( ICFBamAccessSecurityObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalViewAccessSecurityId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalViewAccessSecurityId( null );
			}
			optionalLookupVAccSec = value;
	}

	public ICFBamAccessSecurityObj getOptionalLookupEAccSec() {
		return( getOptionalLookupEAccSec( false ) );
	}

	public ICFBamAccessSecurityObj getOptionalLookupEAccSec( boolean forceRead ) {
		if( forceRead || ( optionalLookupEAccSec == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalEditAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessSecurityObj obj = getOrigAsValue().getSchema().getAccessSecurityTableObj().readAccessSecurityByIdIdx( getValueBuff().getOptionalEditAccessSecurityId() );
				optionalLookupEAccSec = obj;
			}
		}
		return( optionalLookupEAccSec );
	}

	public void setOptionalLookupEAccSec( ICFBamAccessSecurityObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalEditAccessSecurityId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalEditAccessSecurityId( null );
			}
			optionalLookupEAccSec = value;
	}

	public ICFBamAccessFrequencyObj getOptionalLookupVAccFreq() {
		return( getOptionalLookupVAccFreq( false ) );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupVAccFreq( boolean forceRead ) {
		if( forceRead || ( optionalLookupVAccFreq == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalViewAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessFrequencyObj obj = getOrigAsValue().getSchema().getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getValueBuff().getOptionalViewAccessFrequencyId() );
				optionalLookupVAccFreq = obj;
			}
		}
		return( optionalLookupVAccFreq );
	}

	public void setOptionalLookupVAccFreq( ICFBamAccessFrequencyObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalViewAccessFrequencyId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalViewAccessFrequencyId( null );
			}
			optionalLookupVAccFreq = value;
	}

	public ICFBamAccessFrequencyObj getOptionalLookupEAccFreq() {
		return( getOptionalLookupEAccFreq( false ) );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupEAccFreq( boolean forceRead ) {
		if( forceRead || ( optionalLookupEAccFreq == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalEditAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessFrequencyObj obj = getOrigAsValue().getSchema().getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getValueBuff().getOptionalEditAccessFrequencyId() );
				optionalLookupEAccFreq = obj;
			}
		}
		return( optionalLookupEAccFreq );
	}

	public void setOptionalLookupEAccFreq( ICFBamAccessFrequencyObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalEditAccessFrequencyId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalEditAccessFrequencyId( null );
			}
			optionalLookupEAccFreq = value;
	}

	public ICFBamValueObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamValueObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamValueObj obj = getOrigAsValue().getSchema().getValueTableObj().readValueByIdIdx( getValueBuff().getOptionalPrevTenantId(),
					getValueBuff().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	public void setOptionalLookupPrev( ICFBamValueObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalPrevTenantId( value.getRequiredTenantId() );
				getValueBuff().setOptionalPrevId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalPrevTenantId( null );
				getValueBuff().setOptionalPrevId( null );
			}
			optionalLookupPrev = value;
	}

	public ICFBamValueObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamValueObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamValueObj obj = getOrigAsValue().getSchema().getValueTableObj().readValueByIdIdx( getValueBuff().getOptionalNextTenantId(),
					getValueBuff().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	public void setOptionalLookupNext( ICFBamValueObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalNextTenantId( value.getRequiredTenantId() );
				getValueBuff().setOptionalNextId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalNextTenantId( null );
				getValueBuff().setOptionalNextId( null );
			}
			optionalLookupNext = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setClassCode( buff.getClassCode() );
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFBamValueBuff origBuff = getOrigAsValue().getValueBuff();
		CFBamValueBuff myBuff = getValueBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamValueBuff origBuff = getOrigAsValue().getValueBuff();
		CFBamValueBuff myBuff = getValueBuff();
		myBuff.set( origBuff );
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
