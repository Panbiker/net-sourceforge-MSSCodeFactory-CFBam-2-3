// Description: Java7 base object instance implementation for CFBam SchemaDef.

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

public class CFBamSchemaDefObj
	extends CFBamScopeObj
	implements ICFBamSchemaDefObj
{
	public final static String CLASS_CODE = "SCHM";
	protected ICFBamDomainBaseObj requiredContainerDomain;
	protected ICFBamTenantObj requiredOwnerCTenant;
	protected ICFBamLicenseObj optionalLookupDefaultLicense;
	protected ICFBamDataScopeObj optionalLookupDataScope;
	protected ICFBamAccessSecurityObj optionalLookupVAccSec;
	protected ICFBamAccessSecurityObj optionalLookupEAccSec;
	protected ICFBamAccessFrequencyObj optionalLookupVAccFreq;
	protected ICFBamAccessFrequencyObj optionalLookupEAccFreq;

	public CFBamSchemaDefObj() {
		super();
		requiredContainerDomain = null;
		requiredOwnerCTenant = null;
		optionalLookupDefaultLicense = null;
		optionalLookupDataScope = null;
		optionalLookupVAccSec = null;
		optionalLookupEAccSec = null;
		optionalLookupVAccFreq = null;
		optionalLookupEAccFreq = null;
	}

	public CFBamSchemaDefObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerDomain = null;
		requiredOwnerCTenant = null;
		optionalLookupDefaultLicense = null;
		optionalLookupDataScope = null;
		optionalLookupVAccSec = null;
		optionalLookupEAccSec = null;
		optionalLookupVAccFreq = null;
		optionalLookupEAccFreq = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SchemaDef" );
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
			subObj = getSchema().getTableTableObj().readTableByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = getSchema().getValueTableObj().readValueByUNameIdx( getRequiredTenantId(),
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
		ICFBamSchemaDefObj retobj = schema.getSchemaDefTableObj().realizeSchemaDef(
			(ICFBamSchemaDefObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		schema.getSchemaDefTableObj().forgetSchemaDef( (ICFBamSchemaDefObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamSchemaDefObj retobj = schema.getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamSchemaDefObj retobj = schema.getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamSchemaDefTableObj getSchemaDefTable() {
		return( schema.getSchemaDefTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = schema.getBackingStore().getFactorySchemaDef().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = schema.getBackingStore().getTableSchemaDef().readDerivedByIdIdx( schema.getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamSchemaDefBuff ) ) ) {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamSchemaDefBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerDomain = null;
		requiredOwnerCTenant = null;
		optionalLookupDefaultLicense = null;
		optionalLookupDataScope = null;
		optionalLookupVAccSec = null;
		optionalLookupEAccSec = null;
		optionalLookupVAccFreq = null;
		optionalLookupEAccFreq = null;
	}

	public CFBamSchemaDefBuff getSchemaDefBuff() {
		return( (CFBamSchemaDefBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamSchemaDefObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamSchemaDefObj)this;
		}
		else {
			lockobj = schema.getSchemaDefTableObj().lockSchemaDef( getPKey() );
		}
		edit = schema.getSchemaDefTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamSchemaDefEditObj getEditAsSchemaDef() {
		return( (ICFBamSchemaDefEditObj)edit );
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

	public long getRequiredDomainId() {
		return( getSchemaDefBuff().getRequiredDomainId() );
	}

	public String getRequiredName() {
		return( getSchemaDefBuff().getRequiredName() );
	}

	public String getOptionalDbName() {
		return( getSchemaDefBuff().getOptionalDbName() );
	}

	public String getOptionalShortName() {
		return( getSchemaDefBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getSchemaDefBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getSchemaDefBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getSchemaDefBuff().getOptionalDescription() );
	}

	public Long getOptionalDefaultLicenseTenantId() {
		return( getSchemaDefBuff().getOptionalDefaultLicenseTenantId() );
	}

	public Long getOptionalDefaultLicenseId() {
		return( getSchemaDefBuff().getOptionalDefaultLicenseId() );
	}

	public boolean getRequiredExtendCFCore() {
		return( getSchemaDefBuff().getRequiredExtendCFCore() );
	}

	public Short getOptionalDataScopeId() {
		return( getSchemaDefBuff().getOptionalDataScopeId() );
	}

	public Short getOptionalViewAccessSecurityId() {
		return( getSchemaDefBuff().getOptionalViewAccessSecurityId() );
	}

	public Short getOptionalEditAccessSecurityId() {
		return( getSchemaDefBuff().getOptionalEditAccessSecurityId() );
	}

	public Short getOptionalViewAccessFrequencyId() {
		return( getSchemaDefBuff().getOptionalViewAccessFrequencyId() );
	}

	public Short getOptionalEditAccessFrequencyId() {
		return( getSchemaDefBuff().getOptionalEditAccessFrequencyId() );
	}

	public String getRequiredCopyrightPeriod() {
		return( getSchemaDefBuff().getRequiredCopyrightPeriod() );
	}

	public String getRequiredCopyrightHolder() {
		return( getSchemaDefBuff().getRequiredCopyrightHolder() );
	}

	public String getRequiredPublishURI() {
		return( getSchemaDefBuff().getRequiredPublishURI() );
	}

	public String getOptionalJSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJSchemaObjImport() );
	}

	public String getOptionalJSchemaObjInterface() {
		return( getSchemaDefBuff().getOptionalJSchemaObjInterface() );
	}

	public String getOptionalJSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJSchemaObjMembers() );
	}

	public String getOptionalJSchemaObjImplementation() {
		return( getSchemaDefBuff().getOptionalJSchemaObjImplementation() );
	}

	public String getOptionalJDb2LUWSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjMembers() );
	}

	public String getOptionalJDb2LUWSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImpl() );
	}

	public String getOptionalJDb2LUWSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImport() );
	}

	public String getOptionalJMSSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjMembers() );
	}

	public String getOptionalJMSSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImpl() );
	}

	public String getOptionalJMSSqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImport() );
	}

	public String getOptionalJMySqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjMembers() );
	}

	public String getOptionalJMySqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjImpl() );
	}

	public String getOptionalJMySqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjImport() );
	}

	public String getOptionalJOracleSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjMembers() );
	}

	public String getOptionalJOracleSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjImpl() );
	}

	public String getOptionalJOracleSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjImport() );
	}

	public String getOptionalJPgSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjMembers() );
	}

	public String getOptionalJPgSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImpl() );
	}

	public String getOptionalJPgSqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImport() );
	}

	public String getOptionalJSybaseSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJSybaseSchemaObjMembers() );
	}

	public String getOptionalJSybaseSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJSybaseSchemaObjImpl() );
	}

	public String getOptionalJSybaseSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJSybaseSchemaObjImport() );
	}

	public String getOptionalJRamSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjMembers() );
	}

	public String getOptionalJRamSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjImpl() );
	}

	public String getOptionalJRamSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjImport() );
	}

	public String getOptionalJXMsgSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgSchemaImport() );
	}

	public String getOptionalJXMsgSchemaFormatters() {
		return( getSchemaDefBuff().getOptionalJXMsgSchemaFormatters() );
	}

	public String getOptionalJXMsgClientSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgClientSchemaImport() );
	}

	public String getOptionalJXMsgClientSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgClientSchemaBody() );
	}

	public String getOptionalJXMsgRqstSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaBody() );
	}

	public String getOptionalJXMsgRqstSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaImport() );
	}

	public String getOptionalJXMsgRqstSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaWireParsers() );
	}

	public String getOptionalJXMsgRqstSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdSpec() );
	}

	public String getOptionalJXMsgRqstSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdElementList() );
	}

	public String getOptionalJXMsgRspnSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaBody() );
	}

	public String getOptionalJXMsgRspnSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaImport() );
	}

	public String getOptionalJXMsgRspnSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaWireParsers() );
	}

	public String getOptionalJXMsgRspnSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdElementList() );
	}

	public String getOptionalJXMsgRspnSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdSpec() );
	}

	public ICFBamDomainBaseObj getRequiredContainerDomain() {
		return( getRequiredContainerDomain( false ) );
	}

	public ICFBamDomainBaseObj getRequiredContainerDomain( boolean forceRead ) {
		if( ( requiredContainerDomain == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerDomain = schema.getDomainBaseTableObj().readDomainBaseByIdIdx( getPKey().getRequiredTenantId(),
					getSchemaDefBuff().getRequiredDomainId(), forceRead );
			}
		}
		return( requiredContainerDomain );
	}

	public ICFBamTenantObj getRequiredOwnerCTenant() {
		return( getRequiredOwnerCTenant( false ) );
	}

	public ICFBamTenantObj getRequiredOwnerCTenant( boolean forceRead ) {
		if( ( requiredOwnerCTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerCTenant = schema.getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerCTenant );
	}

	public List<ICFBamTableObj> getOptionalComponentsTables() {
		List<ICFBamTableObj> retval;
		retval = schema.getTableTableObj().readTableBySchemaDefIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamTableObj> getOptionalComponentsTables( boolean forceRead ) {
		List<ICFBamTableObj> retval;
		retval = schema.getTableTableObj().readTableBySchemaDefIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsTypes() {
		List<ICFBamValueObj> retval;
		retval = schema.getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsTypes( boolean forceRead ) {
		List<ICFBamValueObj> retval;
		retval = schema.getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamLicenseObj getOptionalLookupDefaultLicense() {
		return( getOptionalLookupDefaultLicense( false ) );
	}

	public ICFBamLicenseObj getOptionalLookupDefaultLicense( boolean forceRead ) {
		if( ( optionalLookupDefaultLicense == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSchemaDefBuff().getOptionalDefaultLicenseTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaDefBuff().getOptionalDefaultLicenseId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefaultLicense = schema.getLicenseTableObj().readLicenseByIdIdx( getSchemaDefBuff().getOptionalDefaultLicenseTenantId(),
					getSchemaDefBuff().getOptionalDefaultLicenseId(), forceRead );
			}
		}
		return( optionalLookupDefaultLicense );
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope() {
		return( getOptionalLookupDataScope( false ) );
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope( boolean forceRead ) {
		if( ( optionalLookupDataScope == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSchemaDefBuff().getOptionalDataScopeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDataScope = schema.getDataScopeTableObj().readDataScopeByIdIdx( getSchemaDefBuff().getOptionalDataScopeId(), forceRead );
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
			if( getSchemaDefBuff().getOptionalViewAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupVAccSec = schema.getAccessSecurityTableObj().readAccessSecurityByIdIdx( getSchemaDefBuff().getOptionalViewAccessSecurityId(), forceRead );
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
			if( getSchemaDefBuff().getOptionalEditAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupEAccSec = schema.getAccessSecurityTableObj().readAccessSecurityByIdIdx( getSchemaDefBuff().getOptionalEditAccessSecurityId(), forceRead );
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
			if( getSchemaDefBuff().getOptionalViewAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupVAccFreq = schema.getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getSchemaDefBuff().getOptionalViewAccessFrequencyId(), forceRead );
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
			if( getSchemaDefBuff().getOptionalEditAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupEAccFreq = schema.getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getSchemaDefBuff().getOptionalEditAccessFrequencyId(), forceRead );
			}
		}
		return( optionalLookupEAccFreq );
	}

	public List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs() {
		List<ICFBamSchemaRefObj> retval;
		retval = schema.getSchemaRefTableObj().readSchemaRefBySchemaIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs( boolean forceRead ) {
		List<ICFBamSchemaRefObj> retval;
		retval = schema.getSchemaRefTableObj().readSchemaRefBySchemaIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}
}
