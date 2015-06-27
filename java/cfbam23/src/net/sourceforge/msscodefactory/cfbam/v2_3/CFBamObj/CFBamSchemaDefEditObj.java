// Description: Java7 edit object instance implementation for CFBam SchemaDef.

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

public class CFBamSchemaDefEditObj
	extends CFBamScopeEditObj

	implements ICFBamSchemaDefEditObj
{
	protected ICFBamDomainBaseObj requiredContainerDomain;
	protected ICFBamTenantObj requiredOwnerCTenant;
	protected ICFBamLicenseObj optionalLookupDefaultLicense;
	protected ICFBamDataScopeObj optionalLookupDataScope;
	protected ICFBamAccessSecurityObj optionalLookupVAccSec;
	protected ICFBamAccessSecurityObj optionalLookupEAccSec;
	protected ICFBamAccessFrequencyObj optionalLookupVAccFreq;
	protected ICFBamAccessFrequencyObj optionalLookupEAccFreq;

	public CFBamSchemaDefEditObj( ICFBamSchemaDefObj argOrig ) {
		super( argOrig );
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
		return( CFBamSchemaDefObj.CLASS_CODE );
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
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamSchemaDefObj retobj = getSchema().getSchemaDefTableObj().realizeSchemaDef( (ICFBamSchemaDefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsSchemaDef().getSchema().getSchemaDefTableObj().forgetSchemaDef( getOrigAsSchemaDef(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamSchemaDefObj retobj = getOrigAsSchemaDef().getSchema().getSchemaDefTableObj().createSchemaDef( getOrigAsSchemaDef() );
		if( retobj == getOrigAsSchemaDef() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getSchemaDefTableObj().updateSchemaDef( (ICFBamSchemaDefObj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getSchemaDefTableObj().deleteSchemaDef( getOrigAsSchemaDef() );
	}

	public ICFBamSchemaDefTableObj getSchemaDefTable() {
		return( orig.getSchema().getSchemaDefTableObj() );
	}

	public ICFBamSchemaDefEditObj getEditAsSchemaDef() {
		return( (ICFBamSchemaDefEditObj)this );
	}

	public ICFBamSchemaDefObj getOrigAsSchemaDef() {
		return( (ICFBamSchemaDefObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsSchemaDef().getSchema().getBackingStore().getFactorySchemaDef().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerDomain = null;
			requiredOwnerCTenant = null;
			optionalLookupDefaultLicense = null;
			optionalLookupDataScope = null;
			optionalLookupVAccSec = null;
			optionalLookupEAccSec = null;
			optionalLookupVAccFreq = null;
			optionalLookupEAccFreq = null;
		}
	}

	public CFBamSchemaDefBuff getSchemaDefBuff() {
		return( (CFBamSchemaDefBuff)getBuff() );
	}

	public long getRequiredDomainId() {
		return( getSchemaDefBuff().getRequiredDomainId() );
	}

	public String getRequiredName() {
		return( getSchemaDefBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getSchemaDefBuff().getRequiredName() != value ) {
			getSchemaDefBuff().setRequiredName( value );
		}
	}

	public String getOptionalDbName() {
		return( getSchemaDefBuff().getOptionalDbName() );
	}

	public void setOptionalDbName( String value ) {
		if( getSchemaDefBuff().getOptionalDbName() != value ) {
			getSchemaDefBuff().setOptionalDbName( value );
		}
	}

	public String getOptionalShortName() {
		return( getSchemaDefBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getSchemaDefBuff().getOptionalShortName() != value ) {
			getSchemaDefBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getSchemaDefBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getSchemaDefBuff().getOptionalLabel() != value ) {
			getSchemaDefBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getSchemaDefBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getSchemaDefBuff().getOptionalShortDescription() != value ) {
			getSchemaDefBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getSchemaDefBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getSchemaDefBuff().getOptionalDescription() != value ) {
			getSchemaDefBuff().setOptionalDescription( value );
		}
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

	public void setRequiredExtendCFCore( boolean value ) {
		if( getSchemaDefBuff().getRequiredExtendCFCore() != value ) {
			getSchemaDefBuff().setRequiredExtendCFCore( value );
		}
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

	public void setRequiredCopyrightPeriod( String value ) {
		if( getSchemaDefBuff().getRequiredCopyrightPeriod() != value ) {
			getSchemaDefBuff().setRequiredCopyrightPeriod( value );
		}
	}

	public String getRequiredCopyrightHolder() {
		return( getSchemaDefBuff().getRequiredCopyrightHolder() );
	}

	public void setRequiredCopyrightHolder( String value ) {
		if( getSchemaDefBuff().getRequiredCopyrightHolder() != value ) {
			getSchemaDefBuff().setRequiredCopyrightHolder( value );
		}
	}

	public String getRequiredPublishURI() {
		return( getSchemaDefBuff().getRequiredPublishURI() );
	}

	public void setRequiredPublishURI( String value ) {
		if( getSchemaDefBuff().getRequiredPublishURI() != value ) {
			getSchemaDefBuff().setRequiredPublishURI( value );
		}
	}

	public String getOptionalJSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJSchemaObjImport() );
	}

	public void setOptionalJSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJSchemaObjImport( value );
		}
	}

	public String getOptionalJSchemaObjInterface() {
		return( getSchemaDefBuff().getOptionalJSchemaObjInterface() );
	}

	public void setOptionalJSchemaObjInterface( String value ) {
		if( getSchemaDefBuff().getOptionalJSchemaObjInterface() != value ) {
			getSchemaDefBuff().setOptionalJSchemaObjInterface( value );
		}
	}

	public String getOptionalJSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJSchemaObjMembers() );
	}

	public void setOptionalJSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJSchemaObjMembers( value );
		}
	}

	public String getOptionalJSchemaObjImplementation() {
		return( getSchemaDefBuff().getOptionalJSchemaObjImplementation() );
	}

	public void setOptionalJSchemaObjImplementation( String value ) {
		if( getSchemaDefBuff().getOptionalJSchemaObjImplementation() != value ) {
			getSchemaDefBuff().setOptionalJSchemaObjImplementation( value );
		}
	}

	public String getOptionalJDb2LUWSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjMembers() );
	}

	public void setOptionalJDb2LUWSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJDb2LUWSchemaObjMembers( value );
		}
	}

	public String getOptionalJDb2LUWSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImpl() );
	}

	public void setOptionalJDb2LUWSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJDb2LUWSchemaObjImpl( value );
		}
	}

	public String getOptionalJDb2LUWSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImport() );
	}

	public void setOptionalJDb2LUWSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJDb2LUWSchemaObjImport( value );
		}
	}

	public String getOptionalJMSSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjMembers() );
	}

	public void setOptionalJMSSqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJMSSqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJMSSqlSchemaObjMembers( value );
		}
	}

	public String getOptionalJMSSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImpl() );
	}

	public void setOptionalJMSSqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJMSSqlSchemaObjImpl( value );
		}
	}

	public String getOptionalJMSSqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImport() );
	}

	public void setOptionalJMSSqlSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJMSSqlSchemaObjImport( value );
		}
	}

	public String getOptionalJMySqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjMembers() );
	}

	public void setOptionalJMySqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJMySqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJMySqlSchemaObjMembers( value );
		}
	}

	public String getOptionalJMySqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjImpl() );
	}

	public void setOptionalJMySqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJMySqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJMySqlSchemaObjImpl( value );
		}
	}

	public String getOptionalJMySqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjImport() );
	}

	public void setOptionalJMySqlSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJMySqlSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJMySqlSchemaObjImport( value );
		}
	}

	public String getOptionalJOracleSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjMembers() );
	}

	public void setOptionalJOracleSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJOracleSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJOracleSchemaObjMembers( value );
		}
	}

	public String getOptionalJOracleSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjImpl() );
	}

	public void setOptionalJOracleSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJOracleSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJOracleSchemaObjImpl( value );
		}
	}

	public String getOptionalJOracleSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjImport() );
	}

	public void setOptionalJOracleSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJOracleSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJOracleSchemaObjImport( value );
		}
	}

	public String getOptionalJPgSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjMembers() );
	}

	public void setOptionalJPgSqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJPgSqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJPgSqlSchemaObjMembers( value );
		}
	}

	public String getOptionalJPgSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImpl() );
	}

	public void setOptionalJPgSqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJPgSqlSchemaObjImpl( value );
		}
	}

	public String getOptionalJPgSqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImport() );
	}

	public void setOptionalJPgSqlSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJPgSqlSchemaObjImport( value );
		}
	}

	public String getOptionalJSybaseSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJSybaseSchemaObjMembers() );
	}

	public void setOptionalJSybaseSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJSybaseSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJSybaseSchemaObjMembers( value );
		}
	}

	public String getOptionalJSybaseSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJSybaseSchemaObjImpl() );
	}

	public void setOptionalJSybaseSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJSybaseSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJSybaseSchemaObjImpl( value );
		}
	}

	public String getOptionalJSybaseSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJSybaseSchemaObjImport() );
	}

	public void setOptionalJSybaseSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJSybaseSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJSybaseSchemaObjImport( value );
		}
	}

	public String getOptionalJRamSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjMembers() );
	}

	public void setOptionalJRamSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJRamSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJRamSchemaObjMembers( value );
		}
	}

	public String getOptionalJRamSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjImpl() );
	}

	public void setOptionalJRamSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJRamSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJRamSchemaObjImpl( value );
		}
	}

	public String getOptionalJRamSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjImport() );
	}

	public void setOptionalJRamSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJRamSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJRamSchemaObjImport( value );
		}
	}

	public String getOptionalJXMsgSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgSchemaImport() );
	}

	public void setOptionalJXMsgSchemaImport( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgSchemaImport() != value ) {
			getSchemaDefBuff().setOptionalJXMsgSchemaImport( value );
		}
	}

	public String getOptionalJXMsgSchemaFormatters() {
		return( getSchemaDefBuff().getOptionalJXMsgSchemaFormatters() );
	}

	public void setOptionalJXMsgSchemaFormatters( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgSchemaFormatters() != value ) {
			getSchemaDefBuff().setOptionalJXMsgSchemaFormatters( value );
		}
	}

	public String getOptionalJXMsgClientSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgClientSchemaImport() );
	}

	public void setOptionalJXMsgClientSchemaImport( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgClientSchemaImport() != value ) {
			getSchemaDefBuff().setOptionalJXMsgClientSchemaImport( value );
		}
	}

	public String getOptionalJXMsgClientSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgClientSchemaBody() );
	}

	public void setOptionalJXMsgClientSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgClientSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalJXMsgClientSchemaBody( value );
		}
	}

	public String getOptionalJXMsgRqstSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaBody() );
	}

	public void setOptionalJXMsgRqstSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRqstSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRqstSchemaBody( value );
		}
	}

	public String getOptionalJXMsgRqstSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaImport() );
	}

	public void setOptionalJXMsgRqstSchemaImport( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRqstSchemaImport() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRqstSchemaImport( value );
		}
	}

	public String getOptionalJXMsgRqstSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaWireParsers() );
	}

	public void setOptionalJXMsgRqstSchemaWireParsers( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRqstSchemaWireParsers() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRqstSchemaWireParsers( value );
		}
	}

	public String getOptionalJXMsgRqstSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdSpec() );
	}

	public void setOptionalJXMsgRqstSchemaXsdSpec( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdSpec() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRqstSchemaXsdSpec( value );
		}
	}

	public String getOptionalJXMsgRqstSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdElementList() );
	}

	public void setOptionalJXMsgRqstSchemaXsdElementList( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdElementList() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRqstSchemaXsdElementList( value );
		}
	}

	public String getOptionalJXMsgRspnSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaBody() );
	}

	public void setOptionalJXMsgRspnSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRspnSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRspnSchemaBody( value );
		}
	}

	public String getOptionalJXMsgRspnSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaImport() );
	}

	public void setOptionalJXMsgRspnSchemaImport( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRspnSchemaImport() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRspnSchemaImport( value );
		}
	}

	public String getOptionalJXMsgRspnSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaWireParsers() );
	}

	public void setOptionalJXMsgRspnSchemaWireParsers( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRspnSchemaWireParsers() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRspnSchemaWireParsers( value );
		}
	}

	public String getOptionalJXMsgRspnSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdElementList() );
	}

	public void setOptionalJXMsgRspnSchemaXsdElementList( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdElementList() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRspnSchemaXsdElementList( value );
		}
	}

	public String getOptionalJXMsgRspnSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdSpec() );
	}

	public void setOptionalJXMsgRspnSchemaXsdSpec( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdSpec() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRspnSchemaXsdSpec( value );
		}
	}

	public ICFBamDomainBaseObj getRequiredContainerDomain() {
		return( getRequiredContainerDomain( false ) );
	}

	public ICFBamDomainBaseObj getRequiredContainerDomain( boolean forceRead ) {
		if( forceRead || ( requiredContainerDomain == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamDomainBaseObj obj = getOrigAsSchemaDef().getSchema().getDomainBaseTableObj().readDomainBaseByIdIdx( getPKey().getRequiredTenantId(),
					getSchemaDefBuff().getRequiredDomainId() );
				requiredContainerDomain = obj;
				if( obj != null ) {
					getSchemaDefBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getSchemaDefBuff().setRequiredDomainId( obj.getRequiredId() );
					requiredContainerDomain = obj;
				}
			}
		}
		return( requiredContainerDomain );
	}

	public void setRequiredContainerDomain( ICFBamDomainBaseObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			requiredContainerDomain = null;
			requiredOwnerCTenant = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getSchemaDefBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getSchemaDefBuff().setRequiredDomainId( value.getRequiredId() );
			}
			requiredContainerDomain = value;
	}

	public ICFBamTenantObj getRequiredOwnerCTenant() {
		return( getRequiredOwnerCTenant( false ) );
	}

	public ICFBamTenantObj getRequiredOwnerCTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerCTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTenantObj obj = getOrigAsSchemaDef().getSchema().getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerCTenant = obj;
			}
		}
		return( requiredOwnerCTenant );
	}

	public void setRequiredOwnerCTenant( ICFBamTenantObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			requiredContainerDomain = null;
			requiredOwnerCTenant = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getSchemaDefBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerCTenant = value;

		super.setRequiredOwnerTenant( value );	}

	public List<ICFBamTableObj> getOptionalComponentsTables() {
		List<ICFBamTableObj> retval;
		retval = getOrigAsSchemaDef().getSchema().getTableTableObj().readTableBySchemaDefIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamTableObj> getOptionalComponentsTables( boolean forceRead ) {
		List<ICFBamTableObj> retval;
		retval = getOrigAsSchemaDef().getSchema().getTableTableObj().readTableBySchemaDefIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsTypes() {
		List<ICFBamValueObj> retval;
		retval = getOrigAsSchemaDef().getSchema().getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsTypes( boolean forceRead ) {
		List<ICFBamValueObj> retval;
		retval = getOrigAsSchemaDef().getSchema().getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamLicenseObj getOptionalLookupDefaultLicense() {
		return( getOptionalLookupDefaultLicense( false ) );
	}

	public ICFBamLicenseObj getOptionalLookupDefaultLicense( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefaultLicense == null ) ) {
			boolean anyMissing = false;
			if( getSchemaDefBuff().getOptionalDefaultLicenseTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaDefBuff().getOptionalDefaultLicenseId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamLicenseObj obj = getOrigAsSchemaDef().getSchema().getLicenseTableObj().readLicenseByIdIdx( getSchemaDefBuff().getOptionalDefaultLicenseTenantId(),
					getSchemaDefBuff().getOptionalDefaultLicenseId() );
				optionalLookupDefaultLicense = obj;
			}
		}
		return( optionalLookupDefaultLicense );
	}

	public void setOptionalLookupDefaultLicense( ICFBamLicenseObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			if( value != null ) {
				getSchemaDefBuff().setOptionalDefaultLicenseTenantId( value.getRequiredTenantId() );
				getSchemaDefBuff().setOptionalDefaultLicenseId( value.getRequiredId() );
			}
			else {
				getSchemaDefBuff().setOptionalDefaultLicenseTenantId( null );
				getSchemaDefBuff().setOptionalDefaultLicenseId( null );
			}
			optionalLookupDefaultLicense = value;
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope() {
		return( getOptionalLookupDataScope( false ) );
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope( boolean forceRead ) {
		if( forceRead || ( optionalLookupDataScope == null ) ) {
			boolean anyMissing = false;
			if( getSchemaDefBuff().getOptionalDataScopeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamDataScopeObj obj = getOrigAsSchemaDef().getSchema().getDataScopeTableObj().readDataScopeByIdIdx( getSchemaDefBuff().getOptionalDataScopeId() );
				optionalLookupDataScope = obj;
			}
		}
		return( optionalLookupDataScope );
	}

	public void setOptionalLookupDataScope( ICFBamDataScopeObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			if( value != null ) {
				getSchemaDefBuff().setOptionalDataScopeId( value.getRequiredId() );
			}
			else {
				getSchemaDefBuff().setOptionalDataScopeId( null );
			}
			optionalLookupDataScope = value;
	}

	public ICFBamAccessSecurityObj getOptionalLookupVAccSec() {
		return( getOptionalLookupVAccSec( false ) );
	}

	public ICFBamAccessSecurityObj getOptionalLookupVAccSec( boolean forceRead ) {
		if( forceRead || ( optionalLookupVAccSec == null ) ) {
			boolean anyMissing = false;
			if( getSchemaDefBuff().getOptionalViewAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessSecurityObj obj = getOrigAsSchemaDef().getSchema().getAccessSecurityTableObj().readAccessSecurityByIdIdx( getSchemaDefBuff().getOptionalViewAccessSecurityId() );
				optionalLookupVAccSec = obj;
			}
		}
		return( optionalLookupVAccSec );
	}

	public void setOptionalLookupVAccSec( ICFBamAccessSecurityObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			if( value != null ) {
				getSchemaDefBuff().setOptionalViewAccessSecurityId( value.getRequiredId() );
			}
			else {
				getSchemaDefBuff().setOptionalViewAccessSecurityId( null );
			}
			optionalLookupVAccSec = value;
	}

	public ICFBamAccessSecurityObj getOptionalLookupEAccSec() {
		return( getOptionalLookupEAccSec( false ) );
	}

	public ICFBamAccessSecurityObj getOptionalLookupEAccSec( boolean forceRead ) {
		if( forceRead || ( optionalLookupEAccSec == null ) ) {
			boolean anyMissing = false;
			if( getSchemaDefBuff().getOptionalEditAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessSecurityObj obj = getOrigAsSchemaDef().getSchema().getAccessSecurityTableObj().readAccessSecurityByIdIdx( getSchemaDefBuff().getOptionalEditAccessSecurityId() );
				optionalLookupEAccSec = obj;
			}
		}
		return( optionalLookupEAccSec );
	}

	public void setOptionalLookupEAccSec( ICFBamAccessSecurityObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			if( value != null ) {
				getSchemaDefBuff().setOptionalEditAccessSecurityId( value.getRequiredId() );
			}
			else {
				getSchemaDefBuff().setOptionalEditAccessSecurityId( null );
			}
			optionalLookupEAccSec = value;
	}

	public ICFBamAccessFrequencyObj getOptionalLookupVAccFreq() {
		return( getOptionalLookupVAccFreq( false ) );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupVAccFreq( boolean forceRead ) {
		if( forceRead || ( optionalLookupVAccFreq == null ) ) {
			boolean anyMissing = false;
			if( getSchemaDefBuff().getOptionalViewAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessFrequencyObj obj = getOrigAsSchemaDef().getSchema().getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getSchemaDefBuff().getOptionalViewAccessFrequencyId() );
				optionalLookupVAccFreq = obj;
			}
		}
		return( optionalLookupVAccFreq );
	}

	public void setOptionalLookupVAccFreq( ICFBamAccessFrequencyObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			if( value != null ) {
				getSchemaDefBuff().setOptionalViewAccessFrequencyId( value.getRequiredId() );
			}
			else {
				getSchemaDefBuff().setOptionalViewAccessFrequencyId( null );
			}
			optionalLookupVAccFreq = value;
	}

	public ICFBamAccessFrequencyObj getOptionalLookupEAccFreq() {
		return( getOptionalLookupEAccFreq( false ) );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupEAccFreq( boolean forceRead ) {
		if( forceRead || ( optionalLookupEAccFreq == null ) ) {
			boolean anyMissing = false;
			if( getSchemaDefBuff().getOptionalEditAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessFrequencyObj obj = getOrigAsSchemaDef().getSchema().getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getSchemaDefBuff().getOptionalEditAccessFrequencyId() );
				optionalLookupEAccFreq = obj;
			}
		}
		return( optionalLookupEAccFreq );
	}

	public void setOptionalLookupEAccFreq( ICFBamAccessFrequencyObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			if( value != null ) {
				getSchemaDefBuff().setOptionalEditAccessFrequencyId( value.getRequiredId() );
			}
			else {
				getSchemaDefBuff().setOptionalEditAccessFrequencyId( null );
			}
			optionalLookupEAccFreq = value;
	}

	public List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs() {
		List<ICFBamSchemaRefObj> retval;
		retval = getOrigAsSchemaDef().getSchema().getSchemaRefTableObj().readSchemaRefBySchemaIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs( boolean forceRead ) {
		List<ICFBamSchemaRefObj> retval;
		retval = getOrigAsSchemaDef().getSchema().getSchemaRefTableObj().readSchemaRefBySchemaIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamSchemaDefBuff origBuff = getOrigAsSchemaDef().getSchemaDefBuff();
		CFBamSchemaDefBuff myBuff = getSchemaDefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamSchemaDefBuff origBuff = getOrigAsSchemaDef().getSchemaDefBuff();
		CFBamSchemaDefBuff myBuff = getSchemaDefBuff();
		myBuff.set( origBuff );
	}
}
