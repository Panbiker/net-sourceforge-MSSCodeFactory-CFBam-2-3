// Description: Java7 Object interface for CFBam SchemaDef.

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
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public interface ICFBamSchemaDefObj
	extends ICFBamScopeObj
{

	/**
	 *	Get the current edition of this SchemaDef instance as a ICFBamSchemaDefEditObj.
	 *
	 *	@return	The ICFBamSchemaDefEditObj edition of this instance.
	 */
	ICFBamSchemaDefEditObj getEditAsSchemaDef();

	/**
	 *	Get the ICFBamSchemaDefTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamSchemaDefTableObj table cache which manages this instance.
	 */
	ICFBamSchemaDefTableObj getSchemaDefTable();

	/**
	 *	Get the CFBamSchemaDefBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamSchemaDefBuff instance which currently backs this object.
	 */
	CFBamSchemaDefBuff getSchemaDefBuff();

	/**
	 *	Get the required long attribute DomainId.
	 *
	 *	@return	The required long attribute DomainId.
	 */
	long getRequiredDomainId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The optional String attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The optional String attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The optional String attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The optional String attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Get the optional Long attribute DefaultLicenseTenantId.
	 *
	 *	@return	The optional Long attribute DefaultLicenseTenantId.
	 */
	Long getOptionalDefaultLicenseTenantId();

	/**
	 *	Get the optional Long attribute DefaultLicenseId.
	 *
	 *	@return	The optional Long attribute DefaultLicenseId.
	 */
	Long getOptionalDefaultLicenseId();

	/**
	 *	Get the required boolean attribute ExtendCFCore.
	 *
	 *	@return	The required boolean attribute ExtendCFCore.
	 */
	boolean getRequiredExtendCFCore();

	/**
	 *	Get the optional Short attribute DataScopeId.
	 *
	 *	@return	The optional Short attribute DataScopeId.
	 */
	Short getOptionalDataScopeId();

	/**
	 *	Get the optional Short attribute ViewAccessSecurityId.
	 *
	 *	@return	The optional Short attribute ViewAccessSecurityId.
	 */
	Short getOptionalViewAccessSecurityId();

	/**
	 *	Get the optional Short attribute EditAccessSecurityId.
	 *
	 *	@return	The optional Short attribute EditAccessSecurityId.
	 */
	Short getOptionalEditAccessSecurityId();

	/**
	 *	Get the optional Short attribute ViewAccessFrequencyId.
	 *
	 *	@return	The optional Short attribute ViewAccessFrequencyId.
	 */
	Short getOptionalViewAccessFrequencyId();

	/**
	 *	Get the optional Short attribute EditAccessFrequencyId.
	 *
	 *	@return	The optional Short attribute EditAccessFrequencyId.
	 */
	Short getOptionalEditAccessFrequencyId();

	/**
	 *	Get the required String attribute CopyrightPeriod.
	 *
	 *	@return	The required String attribute CopyrightPeriod.
	 */
	String getRequiredCopyrightPeriod();

	/**
	 *	Get the required String attribute CopyrightHolder.
	 *
	 *	@return	The required String attribute CopyrightHolder.
	 */
	String getRequiredCopyrightHolder();

	/**
	 *	Get the required String attribute PublishURI.
	 *
	 *	@return	The required String attribute PublishURI.
	 */
	String getRequiredPublishURI();

	/**
	 *	Get the optional String attribute JSchemaObjImport.
	 *
	 *	@return	The optional String attribute JSchemaObjImport.
	 */
	String getOptionalJSchemaObjImport();

	/**
	 *	Get the optional String attribute JSchemaObjInterface.
	 *
	 *	@return	The optional String attribute JSchemaObjInterface.
	 */
	String getOptionalJSchemaObjInterface();

	/**
	 *	Get the optional String attribute JSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JSchemaObjMembers.
	 */
	String getOptionalJSchemaObjMembers();

	/**
	 *	Get the optional String attribute JSchemaObjImplementation.
	 *
	 *	@return	The optional String attribute JSchemaObjImplementation.
	 */
	String getOptionalJSchemaObjImplementation();

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JDb2LUWSchemaObjMembers.
	 */
	String getOptionalJDb2LUWSchemaObjMembers();

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JDb2LUWSchemaObjImpl.
	 */
	String getOptionalJDb2LUWSchemaObjImpl();

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjImport.
	 *
	 *	@return	The optional String attribute JDb2LUWSchemaObjImport.
	 */
	String getOptionalJDb2LUWSchemaObjImport();

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JMSSqlSchemaObjMembers.
	 */
	String getOptionalJMSSqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JMSSqlSchemaObjImpl.
	 */
	String getOptionalJMSSqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjImport.
	 *
	 *	@return	The optional String attribute JMSSqlSchemaObjImport.
	 */
	String getOptionalJMSSqlSchemaObjImport();

	/**
	 *	Get the optional String attribute JMySqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JMySqlSchemaObjMembers.
	 */
	String getOptionalJMySqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute JMySqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JMySqlSchemaObjImpl.
	 */
	String getOptionalJMySqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute JMySqlSchemaObjImport.
	 *
	 *	@return	The optional String attribute JMySqlSchemaObjImport.
	 */
	String getOptionalJMySqlSchemaObjImport();

	/**
	 *	Get the optional String attribute JOracleSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JOracleSchemaObjMembers.
	 */
	String getOptionalJOracleSchemaObjMembers();

	/**
	 *	Get the optional String attribute JOracleSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JOracleSchemaObjImpl.
	 */
	String getOptionalJOracleSchemaObjImpl();

	/**
	 *	Get the optional String attribute JOracleSchemaObjImport.
	 *
	 *	@return	The optional String attribute JOracleSchemaObjImport.
	 */
	String getOptionalJOracleSchemaObjImport();

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JPgSqlSchemaObjMembers.
	 */
	String getOptionalJPgSqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JPgSqlSchemaObjImpl.
	 */
	String getOptionalJPgSqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjImport.
	 *
	 *	@return	The optional String attribute JPgSqlSchemaObjImport.
	 */
	String getOptionalJPgSqlSchemaObjImport();

	/**
	 *	Get the optional String attribute JSybaseSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JSybaseSchemaObjMembers.
	 */
	String getOptionalJSybaseSchemaObjMembers();

	/**
	 *	Get the optional String attribute JSybaseSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JSybaseSchemaObjImpl.
	 */
	String getOptionalJSybaseSchemaObjImpl();

	/**
	 *	Get the optional String attribute JSybaseSchemaObjImport.
	 *
	 *	@return	The optional String attribute JSybaseSchemaObjImport.
	 */
	String getOptionalJSybaseSchemaObjImport();

	/**
	 *	Get the optional String attribute JRamSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JRamSchemaObjMembers.
	 */
	String getOptionalJRamSchemaObjMembers();

	/**
	 *	Get the optional String attribute JRamSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JRamSchemaObjImpl.
	 */
	String getOptionalJRamSchemaObjImpl();

	/**
	 *	Get the optional String attribute JRamSchemaObjImport.
	 *
	 *	@return	The optional String attribute JRamSchemaObjImport.
	 */
	String getOptionalJRamSchemaObjImport();

	/**
	 *	Get the optional String attribute JXMsgSchemaImport.
	 *
	 *	@return	The optional String attribute JXMsgSchemaImport.
	 */
	String getOptionalJXMsgSchemaImport();

	/**
	 *	Get the optional String attribute JXMsgSchemaFormatters.
	 *
	 *	@return	The optional String attribute JXMsgSchemaFormatters.
	 */
	String getOptionalJXMsgSchemaFormatters();

	/**
	 *	Get the optional String attribute JXMsgClientSchemaImport.
	 *
	 *	@return	The optional String attribute JXMsgClientSchemaImport.
	 */
	String getOptionalJXMsgClientSchemaImport();

	/**
	 *	Get the optional String attribute JXMsgClientSchemaBody.
	 *
	 *	@return	The optional String attribute JXMsgClientSchemaBody.
	 */
	String getOptionalJXMsgClientSchemaBody();

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaBody.
	 *
	 *	@return	The optional String attribute JXMsgRqstSchemaBody.
	 */
	String getOptionalJXMsgRqstSchemaBody();

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaImport.
	 *
	 *	@return	The optional String attribute JXMsgRqstSchemaImport.
	 */
	String getOptionalJXMsgRqstSchemaImport();

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaWireParsers.
	 *
	 *	@return	The optional String attribute JXMsgRqstSchemaWireParsers.
	 */
	String getOptionalJXMsgRqstSchemaWireParsers();

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaXsdSpec.
	 *
	 *	@return	The optional String attribute JXMsgRqstSchemaXsdSpec.
	 */
	String getOptionalJXMsgRqstSchemaXsdSpec();

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaXsdElementList.
	 *
	 *	@return	The optional String attribute JXMsgRqstSchemaXsdElementList.
	 */
	String getOptionalJXMsgRqstSchemaXsdElementList();

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaBody.
	 *
	 *	@return	The optional String attribute JXMsgRspnSchemaBody.
	 */
	String getOptionalJXMsgRspnSchemaBody();

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaImport.
	 *
	 *	@return	The optional String attribute JXMsgRspnSchemaImport.
	 */
	String getOptionalJXMsgRspnSchemaImport();

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaWireParsers.
	 *
	 *	@return	The optional String attribute JXMsgRspnSchemaWireParsers.
	 */
	String getOptionalJXMsgRspnSchemaWireParsers();

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaXsdElementList.
	 *
	 *	@return	The optional String attribute JXMsgRspnSchemaXsdElementList.
	 */
	String getOptionalJXMsgRspnSchemaXsdElementList();

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaXsdSpec.
	 *
	 *	@return	The optional String attribute JXMsgRspnSchemaXsdSpec.
	 */
	String getOptionalJXMsgRspnSchemaXsdSpec();

	/**
	 *	Get the required ICFBamDomainBaseObj instance referenced by the Domain key.
	 *
	 *	@return	The required ICFBamDomainBaseObj instance referenced by the Domain key.
	 */
	ICFBamDomainBaseObj getRequiredContainerDomain();

	/**
	 *	Get the required ICFBamDomainBaseObj instance referenced by the Domain key.
	 *
	 *	@return	The required ICFBamDomainBaseObj instance referenced by the Domain key.
	 */
	ICFBamDomainBaseObj getRequiredContainerDomain( boolean forceRead );

	/**
	 *	Get the required ICFBamTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required ICFBamTenantObj instance referenced by the CTenant key.
	 */
	ICFBamTenantObj getRequiredOwnerCTenant();

	/**
	 *	Get the required ICFBamTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required ICFBamTenantObj instance referenced by the CTenant key.
	 */
	ICFBamTenantObj getRequiredOwnerCTenant( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamTableObj array of instances referenced by the Tables key.
	 *
	 *	@return	The optional ICFBamTableObj[] array of instances referenced by the Tables key.
	 */
	List<ICFBamTableObj> getOptionalComponentsTables();

	/**
	 *	Get the array of optional ICFBamTableObj array of instances referenced by the Tables key.
	 *
	 *	@return	The optional ICFBamTableObj[] array of instances referenced by the Tables key.
	 */
	List<ICFBamTableObj> getOptionalComponentsTables( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamValueObj array of instances referenced by the Types key.
	 *
	 *	@return	The optional ICFBamValueObj[] array of instances referenced by the Types key.
	 */
	List<ICFBamValueObj> getOptionalComponentsTypes();

	/**
	 *	Get the array of optional ICFBamValueObj array of instances referenced by the Types key.
	 *
	 *	@return	The optional ICFBamValueObj[] array of instances referenced by the Types key.
	 */
	List<ICFBamValueObj> getOptionalComponentsTypes( boolean forceRead );

	/**
	 *	Get the optional ICFBamLicenseObj instance referenced by the DefaultLicense key.
	 *
	 *	@return	The optional ICFBamLicenseObj instance referenced by the DefaultLicense key.
	 */
	ICFBamLicenseObj getOptionalLookupDefaultLicense();

	/**
	 *	Get the optional ICFBamLicenseObj instance referenced by the DefaultLicense key.
	 *
	 *	@return	The optional ICFBamLicenseObj instance referenced by the DefaultLicense key.
	 */
	ICFBamLicenseObj getOptionalLookupDefaultLicense( boolean forceRead );

	/**
	 *	Get the optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 *
	 *	@return	The optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 */
	ICFBamDataScopeObj getOptionalLookupDataScope();

	/**
	 *	Get the optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 *
	 *	@return	The optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 */
	ICFBamDataScopeObj getOptionalLookupDataScope( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupVAccSec();

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupVAccSec( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupEAccSec();

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupEAccSec( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupVAccFreq();

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupVAccFreq( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupEAccFreq();

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupEAccFreq( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamSchemaRefObj array of instances referenced by the SchemaRefs key.
	 *
	 *	@return	The optional ICFBamSchemaRefObj[] array of instances referenced by the SchemaRefs key.
	 */
	List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs();

	/**
	 *	Get the array of optional ICFBamSchemaRefObj array of instances referenced by the SchemaRefs key.
	 *
	 *	@return	The optional ICFBamSchemaRefObj[] array of instances referenced by the SchemaRefs key.
	 */
	List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs( boolean forceRead );
}
