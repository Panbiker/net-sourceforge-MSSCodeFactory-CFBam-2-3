// Description: Java7 Schema Object implementation for CFBam.

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

/**
 *	TODO The current implementation of the objects lacks an important
 *	feature.  When an object is updated, it needs to search out any
 *	existing references to itself by other realized objects and relink
 *	them appropriately.  If an index is updated, any relationships
 *	which reference that index as a ToIndex need to have their relationships
 *	synchronized with the change.
 *	<p>
 *	At this point, I've only cleared the relationships at the object
 *	implementation.  I have not chased down the referencing objects
 *	to clear them.  Realistically this is not a significant limitation,
 *	because virtually all relationships in the applications I've worked
 *	on reference a unique index that is treated as immutable.
 *	<p>
 *	The concern is that referencing collections held by the referencing
 *	objects won't be refreshed properly when the duplicate indexes are
 *	updated, leading to image corruption.
 *	<p>
 *	Again, I'll be putting this off because it's not significant for
 *	the web implementations I'm focusing on at the moment.  More important
 *	for those web implementations is adding a clearUnedited() method to
 *	the SchemaObj, which chases down it's tables and forgets about any
 *	objects that have no outstanding edits.  It will then clear the
 *	relatioships of the remaining edit objects so that they will re-establish
 *	those relationships during the course of servicing the next page request.
 *	<p>
 *	This approach minimizes the memory footprint of a session in between
 *	page requests, dramatically increasing the session handling capabilities
 *	of a JEE server.
 *	<p>
 *	This does increase the load on the database, but the
 *	database should implement object caching, not the web service
 *	implementations.
 */
public class CFBamSchemaObj
	implements ICFBamSchemaObj
{
	protected CFBamAuthorization authorization = null;
	protected ICFBamSchema backingStore = null;
	protected String secClusterName = "system";
	protected String secTenantName = "system";
	protected String secUserName = "system";
	protected ICFBamClusterObj secCluster = null;
	protected long secClusterId = 0L;
	protected ICFBamTenantObj secTenant = null;
	protected long secTenantId = 0L;
	protected ICFBamSecUserObj secUser = null;
	protected UUID secSessionUserId = null;
	protected ICFBamSecSessionObj secSession = null;
	protected UUID secSessionSessionId = null;
	public static String SCHEMA_NAME = "CFBam";
	public static String SCHEMA_DBNAME = "cfbam23";
	protected String schemaDbName = SCHEMA_DBNAME;
	protected String lowerDbSchemaName = SCHEMA_DBNAME.toLowerCase();
	protected boolean cacheMisses = true;
	protected ICFBamAccessFrequencyTableObj accessFrequencyTableObj;
	protected ICFBamAccessSecurityTableObj accessSecurityTableObj;
	protected ICFBamAtomTableObj atomTableObj;
	protected ICFBamAuditActionTableObj auditActionTableObj;
	protected ICFBamBlobColTableObj blobColTableObj;
	protected ICFBamBlobDefTableObj blobDefTableObj;
	protected ICFBamBlobTypeTableObj blobTypeTableObj;
	protected ICFBamBoolColTableObj boolColTableObj;
	protected ICFBamBoolDefTableObj boolDefTableObj;
	protected ICFBamBoolTypeTableObj boolTypeTableObj;
	protected ICFBamChainTableObj chainTableObj;
	protected ICFBamClearDepTableObj clearDepTableObj;
	protected ICFBamClearSubDep1TableObj clearSubDep1TableObj;
	protected ICFBamClearSubDep2TableObj clearSubDep2TableObj;
	protected ICFBamClearSubDep3TableObj clearSubDep3TableObj;
	protected ICFBamClearTopDepTableObj clearTopDepTableObj;
	protected ICFBamClusterTableObj clusterTableObj;
	protected ICFBamDataScopeTableObj dataScopeTableObj;
	protected ICFBamDateColTableObj dateColTableObj;
	protected ICFBamDateDefTableObj dateDefTableObj;
	protected ICFBamDateTypeTableObj dateTypeTableObj;
	protected ICFBamDelDepTableObj delDepTableObj;
	protected ICFBamDelSubDep1TableObj delSubDep1TableObj;
	protected ICFBamDelSubDep2TableObj delSubDep2TableObj;
	protected ICFBamDelSubDep3TableObj delSubDep3TableObj;
	protected ICFBamDelTopDepTableObj delTopDepTableObj;
	protected ICFBamDomainTableObj domainTableObj;
	protected ICFBamDomainBaseTableObj domainBaseTableObj;
	protected ICFBamDoubleColTableObj doubleColTableObj;
	protected ICFBamDoubleDefTableObj doubleDefTableObj;
	protected ICFBamDoubleTypeTableObj doubleTypeTableObj;
	protected ICFBamEnumColTableObj enumColTableObj;
	protected ICFBamEnumDefTableObj enumDefTableObj;
	protected ICFBamEnumTagTableObj enumTagTableObj;
	protected ICFBamEnumTypeTableObj enumTypeTableObj;
	protected ICFBamFloatColTableObj floatColTableObj;
	protected ICFBamFloatDefTableObj floatDefTableObj;
	protected ICFBamFloatTypeTableObj floatTypeTableObj;
	protected ICFBamHostNodeTableObj hostNodeTableObj;
	protected ICFBamISOCountryTableObj iSOCountryTableObj;
	protected ICFBamISOCountryCurrencyTableObj iSOCountryCurrencyTableObj;
	protected ICFBamISOCountryLanguageTableObj iSOCountryLanguageTableObj;
	protected ICFBamISOCurrencyTableObj iSOCurrencyTableObj;
	protected ICFBamISOLanguageTableObj iSOLanguageTableObj;
	protected ICFBamISOTimezoneTableObj iSOTimezoneTableObj;
	protected ICFBamId16GenTableObj id16GenTableObj;
	protected ICFBamId32GenTableObj id32GenTableObj;
	protected ICFBamId64GenTableObj id64GenTableObj;
	protected ICFBamIndexTableObj indexTableObj;
	protected ICFBamIndexColTableObj indexColTableObj;
	protected ICFBamInt16ColTableObj int16ColTableObj;
	protected ICFBamInt16DefTableObj int16DefTableObj;
	protected ICFBamInt16TypeTableObj int16TypeTableObj;
	protected ICFBamInt32ColTableObj int32ColTableObj;
	protected ICFBamInt32DefTableObj int32DefTableObj;
	protected ICFBamInt32TypeTableObj int32TypeTableObj;
	protected ICFBamInt64ColTableObj int64ColTableObj;
	protected ICFBamInt64DefTableObj int64DefTableObj;
	protected ICFBamInt64TypeTableObj int64TypeTableObj;
	protected ICFBamLicenseTableObj licenseTableObj;
	protected ICFBamLoaderBehaviourTableObj loaderBehaviourTableObj;
	protected ICFBamMajorVersionTableObj majorVersionTableObj;
	protected ICFBamMimeTypeTableObj mimeTypeTableObj;
	protected ICFBamMinorVersionTableObj minorVersionTableObj;
	protected ICFBamNmTokenColTableObj nmTokenColTableObj;
	protected ICFBamNmTokenDefTableObj nmTokenDefTableObj;
	protected ICFBamNmTokenTypeTableObj nmTokenTypeTableObj;
	protected ICFBamNmTokensColTableObj nmTokensColTableObj;
	protected ICFBamNmTokensDefTableObj nmTokensDefTableObj;
	protected ICFBamNmTokensTypeTableObj nmTokensTypeTableObj;
	protected ICFBamNumberColTableObj numberColTableObj;
	protected ICFBamNumberDefTableObj numberDefTableObj;
	protected ICFBamNumberTypeTableObj numberTypeTableObj;
	protected ICFBamParamTableObj paramTableObj;
	protected ICFBamPopDepTableObj popDepTableObj;
	protected ICFBamPopSubDep1TableObj popSubDep1TableObj;
	protected ICFBamPopSubDep2TableObj popSubDep2TableObj;
	protected ICFBamPopSubDep3TableObj popSubDep3TableObj;
	protected ICFBamPopTopDepTableObj popTopDepTableObj;
	protected ICFBamProjectBaseTableObj projectBaseTableObj;
	protected ICFBamRealProjectTableObj realProjectTableObj;
	protected ICFBamRelationTableObj relationTableObj;
	protected ICFBamRelationColTableObj relationColTableObj;
	protected ICFBamRelationTypeTableObj relationTypeTableObj;
	protected ICFBamSchemaDefTableObj schemaDefTableObj;
	protected ICFBamSchemaRefTableObj schemaRefTableObj;
	protected ICFBamScopeTableObj scopeTableObj;
	protected ICFBamSecAppTableObj secAppTableObj;
	protected ICFBamSecDeviceTableObj secDeviceTableObj;
	protected ICFBamSecFormTableObj secFormTableObj;
	protected ICFBamSecGroupTableObj secGroupTableObj;
	protected ICFBamSecGroupFormTableObj secGroupFormTableObj;
	protected ICFBamSecGroupIncludeTableObj secGroupIncludeTableObj;
	protected ICFBamSecGroupMemberTableObj secGroupMemberTableObj;
	protected ICFBamSecSessionTableObj secSessionTableObj;
	protected ICFBamSecUserTableObj secUserTableObj;
	protected ICFBamSecurityScopeTableObj securityScopeTableObj;
	protected ICFBamServerListFuncTableObj serverListFuncTableObj;
	protected ICFBamServerMethodTableObj serverMethodTableObj;
	protected ICFBamServerObjFuncTableObj serverObjFuncTableObj;
	protected ICFBamServerProcTableObj serverProcTableObj;
	protected ICFBamServiceTableObj serviceTableObj;
	protected ICFBamServiceTypeTableObj serviceTypeTableObj;
	protected ICFBamStringColTableObj stringColTableObj;
	protected ICFBamStringDefTableObj stringDefTableObj;
	protected ICFBamStringTypeTableObj stringTypeTableObj;
	protected ICFBamSubProjectTableObj subProjectTableObj;
	protected ICFBamSysClusterTableObj sysClusterTableObj;
	protected ICFBamTSecGroupTableObj tSecGroupTableObj;
	protected ICFBamTSecGroupIncludeTableObj tSecGroupIncludeTableObj;
	protected ICFBamTSecGroupMemberTableObj tSecGroupMemberTableObj;
	protected ICFBamTZDateColTableObj tZDateColTableObj;
	protected ICFBamTZDateDefTableObj tZDateDefTableObj;
	protected ICFBamTZDateTypeTableObj tZDateTypeTableObj;
	protected ICFBamTZTimeColTableObj tZTimeColTableObj;
	protected ICFBamTZTimeDefTableObj tZTimeDefTableObj;
	protected ICFBamTZTimeTypeTableObj tZTimeTypeTableObj;
	protected ICFBamTZTimestampColTableObj tZTimestampColTableObj;
	protected ICFBamTZTimestampDefTableObj tZTimestampDefTableObj;
	protected ICFBamTZTimestampTypeTableObj tZTimestampTypeTableObj;
	protected ICFBamTableTableObj tableTableObj;
	protected ICFBamTableColTableObj tableColTableObj;
	protected ICFBamTenantTableObj tenantTableObj;
	protected ICFBamTextColTableObj textColTableObj;
	protected ICFBamTextDefTableObj textDefTableObj;
	protected ICFBamTextTypeTableObj textTypeTableObj;
	protected ICFBamTimeColTableObj timeColTableObj;
	protected ICFBamTimeDefTableObj timeDefTableObj;
	protected ICFBamTimeTypeTableObj timeTypeTableObj;
	protected ICFBamTimestampColTableObj timestampColTableObj;
	protected ICFBamTimestampDefTableObj timestampDefTableObj;
	protected ICFBamTimestampTypeTableObj timestampTypeTableObj;
	protected ICFBamTldTableObj tldTableObj;
	protected ICFBamTokenColTableObj tokenColTableObj;
	protected ICFBamTokenDefTableObj tokenDefTableObj;
	protected ICFBamTokenTypeTableObj tokenTypeTableObj;
	protected ICFBamTopDomainTableObj topDomainTableObj;
	protected ICFBamTopProjectTableObj topProjectTableObj;
	protected ICFBamUInt16ColTableObj uInt16ColTableObj;
	protected ICFBamUInt16DefTableObj uInt16DefTableObj;
	protected ICFBamUInt16TypeTableObj uInt16TypeTableObj;
	protected ICFBamUInt32ColTableObj uInt32ColTableObj;
	protected ICFBamUInt32DefTableObj uInt32DefTableObj;
	protected ICFBamUInt32TypeTableObj uInt32TypeTableObj;
	protected ICFBamUInt64ColTableObj uInt64ColTableObj;
	protected ICFBamUInt64DefTableObj uInt64DefTableObj;
	protected ICFBamUInt64TypeTableObj uInt64TypeTableObj;
	protected ICFBamURLProtocolTableObj uRLProtocolTableObj;
	protected ICFBamUuidColTableObj uuidColTableObj;
	protected ICFBamUuidDefTableObj uuidDefTableObj;
	protected ICFBamUuidGenTableObj uuidGenTableObj;
	protected ICFBamUuidTypeTableObj uuidTypeTableObj;
	protected ICFBamValueTableObj valueTableObj;
	protected ICFBamVersionTableObj versionTableObj;

	public CFBamSchemaObj() {
		accessFrequencyTableObj = new CFBamAccessFrequencyTableObj( this );
		accessSecurityTableObj = new CFBamAccessSecurityTableObj( this );
		atomTableObj = new CFBamAtomTableObj( this );
		auditActionTableObj = new CFBamAuditActionTableObj( this );
		blobColTableObj = new CFBamBlobColTableObj( this );
		blobDefTableObj = new CFBamBlobDefTableObj( this );
		blobTypeTableObj = new CFBamBlobTypeTableObj( this );
		boolColTableObj = new CFBamBoolColTableObj( this );
		boolDefTableObj = new CFBamBoolDefTableObj( this );
		boolTypeTableObj = new CFBamBoolTypeTableObj( this );
		chainTableObj = new CFBamChainTableObj( this );
		clearDepTableObj = new CFBamClearDepTableObj( this );
		clearSubDep1TableObj = new CFBamClearSubDep1TableObj( this );
		clearSubDep2TableObj = new CFBamClearSubDep2TableObj( this );
		clearSubDep3TableObj = new CFBamClearSubDep3TableObj( this );
		clearTopDepTableObj = new CFBamClearTopDepTableObj( this );
		clusterTableObj = new CFBamClusterTableObj( this );
		dataScopeTableObj = new CFBamDataScopeTableObj( this );
		dateColTableObj = new CFBamDateColTableObj( this );
		dateDefTableObj = new CFBamDateDefTableObj( this );
		dateTypeTableObj = new CFBamDateTypeTableObj( this );
		delDepTableObj = new CFBamDelDepTableObj( this );
		delSubDep1TableObj = new CFBamDelSubDep1TableObj( this );
		delSubDep2TableObj = new CFBamDelSubDep2TableObj( this );
		delSubDep3TableObj = new CFBamDelSubDep3TableObj( this );
		delTopDepTableObj = new CFBamDelTopDepTableObj( this );
		domainTableObj = new CFBamDomainTableObj( this );
		domainBaseTableObj = new CFBamDomainBaseTableObj( this );
		doubleColTableObj = new CFBamDoubleColTableObj( this );
		doubleDefTableObj = new CFBamDoubleDefTableObj( this );
		doubleTypeTableObj = new CFBamDoubleTypeTableObj( this );
		enumColTableObj = new CFBamEnumColTableObj( this );
		enumDefTableObj = new CFBamEnumDefTableObj( this );
		enumTagTableObj = new CFBamEnumTagTableObj( this );
		enumTypeTableObj = new CFBamEnumTypeTableObj( this );
		floatColTableObj = new CFBamFloatColTableObj( this );
		floatDefTableObj = new CFBamFloatDefTableObj( this );
		floatTypeTableObj = new CFBamFloatTypeTableObj( this );
		hostNodeTableObj = new CFBamHostNodeTableObj( this );
		iSOCountryTableObj = new CFBamISOCountryTableObj( this );
		iSOCountryCurrencyTableObj = new CFBamISOCountryCurrencyTableObj( this );
		iSOCountryLanguageTableObj = new CFBamISOCountryLanguageTableObj( this );
		iSOCurrencyTableObj = new CFBamISOCurrencyTableObj( this );
		iSOLanguageTableObj = new CFBamISOLanguageTableObj( this );
		iSOTimezoneTableObj = new CFBamISOTimezoneTableObj( this );
		id16GenTableObj = new CFBamId16GenTableObj( this );
		id32GenTableObj = new CFBamId32GenTableObj( this );
		id64GenTableObj = new CFBamId64GenTableObj( this );
		indexTableObj = new CFBamIndexTableObj( this );
		indexColTableObj = new CFBamIndexColTableObj( this );
		int16ColTableObj = new CFBamInt16ColTableObj( this );
		int16DefTableObj = new CFBamInt16DefTableObj( this );
		int16TypeTableObj = new CFBamInt16TypeTableObj( this );
		int32ColTableObj = new CFBamInt32ColTableObj( this );
		int32DefTableObj = new CFBamInt32DefTableObj( this );
		int32TypeTableObj = new CFBamInt32TypeTableObj( this );
		int64ColTableObj = new CFBamInt64ColTableObj( this );
		int64DefTableObj = new CFBamInt64DefTableObj( this );
		int64TypeTableObj = new CFBamInt64TypeTableObj( this );
		licenseTableObj = new CFBamLicenseTableObj( this );
		loaderBehaviourTableObj = new CFBamLoaderBehaviourTableObj( this );
		majorVersionTableObj = new CFBamMajorVersionTableObj( this );
		mimeTypeTableObj = new CFBamMimeTypeTableObj( this );
		minorVersionTableObj = new CFBamMinorVersionTableObj( this );
		nmTokenColTableObj = new CFBamNmTokenColTableObj( this );
		nmTokenDefTableObj = new CFBamNmTokenDefTableObj( this );
		nmTokenTypeTableObj = new CFBamNmTokenTypeTableObj( this );
		nmTokensColTableObj = new CFBamNmTokensColTableObj( this );
		nmTokensDefTableObj = new CFBamNmTokensDefTableObj( this );
		nmTokensTypeTableObj = new CFBamNmTokensTypeTableObj( this );
		numberColTableObj = new CFBamNumberColTableObj( this );
		numberDefTableObj = new CFBamNumberDefTableObj( this );
		numberTypeTableObj = new CFBamNumberTypeTableObj( this );
		paramTableObj = new CFBamParamTableObj( this );
		popDepTableObj = new CFBamPopDepTableObj( this );
		popSubDep1TableObj = new CFBamPopSubDep1TableObj( this );
		popSubDep2TableObj = new CFBamPopSubDep2TableObj( this );
		popSubDep3TableObj = new CFBamPopSubDep3TableObj( this );
		popTopDepTableObj = new CFBamPopTopDepTableObj( this );
		projectBaseTableObj = new CFBamProjectBaseTableObj( this );
		realProjectTableObj = new CFBamRealProjectTableObj( this );
		relationTableObj = new CFBamRelationTableObj( this );
		relationColTableObj = new CFBamRelationColTableObj( this );
		relationTypeTableObj = new CFBamRelationTypeTableObj( this );
		schemaDefTableObj = new CFBamSchemaDefTableObj( this );
		schemaRefTableObj = new CFBamSchemaRefTableObj( this );
		scopeTableObj = new CFBamScopeTableObj( this );
		secAppTableObj = new CFBamSecAppTableObj( this );
		secDeviceTableObj = new CFBamSecDeviceTableObj( this );
		secFormTableObj = new CFBamSecFormTableObj( this );
		secGroupTableObj = new CFBamSecGroupTableObj( this );
		secGroupFormTableObj = new CFBamSecGroupFormTableObj( this );
		secGroupIncludeTableObj = new CFBamSecGroupIncludeTableObj( this );
		secGroupMemberTableObj = new CFBamSecGroupMemberTableObj( this );
		secSessionTableObj = new CFBamSecSessionTableObj( this );
		secUserTableObj = new CFBamSecUserTableObj( this );
		securityScopeTableObj = new CFBamSecurityScopeTableObj( this );
		serverListFuncTableObj = new CFBamServerListFuncTableObj( this );
		serverMethodTableObj = new CFBamServerMethodTableObj( this );
		serverObjFuncTableObj = new CFBamServerObjFuncTableObj( this );
		serverProcTableObj = new CFBamServerProcTableObj( this );
		serviceTableObj = new CFBamServiceTableObj( this );
		serviceTypeTableObj = new CFBamServiceTypeTableObj( this );
		stringColTableObj = new CFBamStringColTableObj( this );
		stringDefTableObj = new CFBamStringDefTableObj( this );
		stringTypeTableObj = new CFBamStringTypeTableObj( this );
		subProjectTableObj = new CFBamSubProjectTableObj( this );
		sysClusterTableObj = new CFBamSysClusterTableObj( this );
		tSecGroupTableObj = new CFBamTSecGroupTableObj( this );
		tSecGroupIncludeTableObj = new CFBamTSecGroupIncludeTableObj( this );
		tSecGroupMemberTableObj = new CFBamTSecGroupMemberTableObj( this );
		tZDateColTableObj = new CFBamTZDateColTableObj( this );
		tZDateDefTableObj = new CFBamTZDateDefTableObj( this );
		tZDateTypeTableObj = new CFBamTZDateTypeTableObj( this );
		tZTimeColTableObj = new CFBamTZTimeColTableObj( this );
		tZTimeDefTableObj = new CFBamTZTimeDefTableObj( this );
		tZTimeTypeTableObj = new CFBamTZTimeTypeTableObj( this );
		tZTimestampColTableObj = new CFBamTZTimestampColTableObj( this );
		tZTimestampDefTableObj = new CFBamTZTimestampDefTableObj( this );
		tZTimestampTypeTableObj = new CFBamTZTimestampTypeTableObj( this );
		tableTableObj = new CFBamTableTableObj( this );
		tableColTableObj = new CFBamTableColTableObj( this );
		tenantTableObj = new CFBamTenantTableObj( this );
		textColTableObj = new CFBamTextColTableObj( this );
		textDefTableObj = new CFBamTextDefTableObj( this );
		textTypeTableObj = new CFBamTextTypeTableObj( this );
		timeColTableObj = new CFBamTimeColTableObj( this );
		timeDefTableObj = new CFBamTimeDefTableObj( this );
		timeTypeTableObj = new CFBamTimeTypeTableObj( this );
		timestampColTableObj = new CFBamTimestampColTableObj( this );
		timestampDefTableObj = new CFBamTimestampDefTableObj( this );
		timestampTypeTableObj = new CFBamTimestampTypeTableObj( this );
		tldTableObj = new CFBamTldTableObj( this );
		tokenColTableObj = new CFBamTokenColTableObj( this );
		tokenDefTableObj = new CFBamTokenDefTableObj( this );
		tokenTypeTableObj = new CFBamTokenTypeTableObj( this );
		topDomainTableObj = new CFBamTopDomainTableObj( this );
		topProjectTableObj = new CFBamTopProjectTableObj( this );
		uInt16ColTableObj = new CFBamUInt16ColTableObj( this );
		uInt16DefTableObj = new CFBamUInt16DefTableObj( this );
		uInt16TypeTableObj = new CFBamUInt16TypeTableObj( this );
		uInt32ColTableObj = new CFBamUInt32ColTableObj( this );
		uInt32DefTableObj = new CFBamUInt32DefTableObj( this );
		uInt32TypeTableObj = new CFBamUInt32TypeTableObj( this );
		uInt64ColTableObj = new CFBamUInt64ColTableObj( this );
		uInt64DefTableObj = new CFBamUInt64DefTableObj( this );
		uInt64TypeTableObj = new CFBamUInt64TypeTableObj( this );
		uRLProtocolTableObj = new CFBamURLProtocolTableObj( this );
		uuidColTableObj = new CFBamUuidColTableObj( this );
		uuidDefTableObj = new CFBamUuidDefTableObj( this );
		uuidGenTableObj = new CFBamUuidGenTableObj( this );
		uuidTypeTableObj = new CFBamUuidTypeTableObj( this );
		valueTableObj = new CFBamValueTableObj( this );
		versionTableObj = new CFBamVersionTableObj( this );
		}

	public void setSecClusterName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setClusterName",
				1,
				"value" );
		}
		secClusterName = value;
		secCluster = null;
	}

	public String getSecClusterName() {
		return( secClusterName );
	}

	public ICFBamClusterObj getSecCluster() {
		if( secCluster == null ) {
			if( authorization != null ) {
				secCluster = getClusterTableObj().readClusterByIdIdx( authorization.getSecClusterId() );
			}
			else {
				secCluster = getClusterTableObj().readClusterByUDomainNameIdx( secClusterName );
				if( ( secCluster == null ) && ( secClusterId > 0 ) ) {
					secCluster = getClusterTableObj().readClusterByIdIdx( secClusterId );
				}
			}
			if( secCluster != null ) {
				secClusterName = secCluster.getRequiredFullDomainName();
				secClusterId = secCluster.getRequiredId();
				if( authorization != null ) {
					authorization.setSecCluster( secCluster );
				}
			}
		}
		return( secCluster );
	}

	public void setSecCluster( ICFBamClusterObj value ) {
		secCluster = value;
		if( secCluster == null ) {
			return;
		}
		secClusterId = secCluster.getRequiredId();
		secClusterName = secCluster.getRequiredFullDomainName();
		if( authorization != null ) {
			authorization.setSecCluster( secCluster );
		}
	}

	public long getSecClusterId() {
		return( secClusterId );
	}

	public void setSecTenantName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setTenantName",
				1,
				"value" );
		}
		secTenantName = value;
		secTenant = null;
	}

	public String getSecTenantName() {
		return( secTenantName );
	}

	public ICFBamTenantObj getSecTenant() {
		if( secTenant == null ) {
			if( authorization != null ) {
				secTenant = getTenantTableObj().readTenantByIdIdx( authorization.getSecTenantId() );
			}
			else {
				secTenant = getTenantTableObj().readTenantByUNameIdx( getSecCluster().getRequiredId(), secTenantName );
				if( ( secTenant == null ) && ( secTenantId > 0 ) ) {
					secTenant = getTenantTableObj().readTenantByIdIdx( secTenantId );
				}
			}
			if( secTenant != null ) {
				secTenantName = secTenant.getRequiredTenantName();
				secTenantId = secTenant.getRequiredId();
				if( authorization != null ) {
					authorization.setSecTenant( secTenant );
				}
			}
		}
		return( secTenant );
	}

	public void setSecTenant( ICFBamTenantObj value ) {
		secTenant = value;
		if( secTenant == null ) {
			return;
		}
		secTenantId = secTenant.getRequiredId();
		secTenantName = secTenant.getRequiredTenantName();
		if( authorization != null ) {
			authorization.setSecTenant( secTenant );
		}
	}

	public long getSecTenantId() {
		return( secTenantId );
	}

	public void setSecUserName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setUserName",
				1,
				"value" );
		}
		secUserName = value;
		secUser = null;
	}

	public String getSecUserName() {
		return( secUserName );
	}

	public ICFBamSecUserObj getSecUser() {
		if( secUser == null ) {
			if( authorization != null ) {
				secUser = getSecUserTableObj().readSecUserByIdIdx( authorization.getSecUserId() );
			}
			else {
				secUser = getSecUserTableObj().readSecUserByULoginIdx( secUserName );
				if( ( secUser == null ) && ( secSessionUserId != null ) ) {
					secUser = getSecUserTableObj().readSecUserByIdIdx( secSessionUserId );
				}
			}
			if( secUser != null ) {
				secUserName = secUser.getRequiredLoginId();
				secSessionUserId = secUser.getRequiredSecUserId();
			}
		}
		return( secUser );
	}
	
	public void setSecUser( ICFBamSecUserObj value ) {
		secUser = value;
		if( secUser != null ) {
			secUserName = secUser.getRequiredLoginId();
			secSessionUserId = secUser.getRequiredSecUserId();
		}
	}
	public ICFBamSecSessionObj getSecSession() {
		if( secSession == null ) {
			if( authorization != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( authorization.getSecSessionId() );
			}
			else if( secSessionSessionId != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionSessionId );
			}
			if( secSession != null ) {
				secSessionSessionId = secSession.getRequiredSecSessionId();
				secSessionUserId = secSession.getRequiredSecUserId();
			}
		}
		return( secSession );
	}

	public void setSecSession( ICFBamSecSessionObj value ) {
		secSession = value;
		if( secSession == null ) {
			return;
		}
		secSessionSessionId = secSession.getRequiredSecSessionId();
		secSessionUserId = secSession.getRequiredSecUserId();
		if( authorization != null ) {
			authorization.setSecSession( secSession );
		}
	}

	public void setSecSessionId( UUID value ) {
		secSessionSessionId = value;
	}

	public UUID getSecSessionSessionId() {
		return( secSessionSessionId );
	}

	public UUID getSecSessionUserId() {
		return( secSessionUserId );
	}

	/**
	 *	When you first connect to a database, you can opt to specify a database
	 *	schema name to be used by the session.  The implementation code must always
	 *	be dynamically based on the invocation of <tt>String getDbSchemaName()</tt>
	 *	at runtime.
	 *	<p>
	 *	The initial value is defined by the implementing schema model which has inherited
	 *	the expression of the current schema model being expanded.  That is, it is specified
	 *	in the DbSchemaName attribute of a SchemaDef instance.
	 */
	public String getDbSchemaName() {
		return( schemaDbName );
	}

	/**
	 *	PostgreSQL coerces database schema names to lowercase for consistency.
	 */
	public String getLowerDbSchemaName() {
		return( lowerDbSchemaName );
	}

	/**
	 *	The database is expected to override this implementation and invoke the
	 *	<tt>super.setDbSchemaName( String argDbSchemaName )</tt> early
	 *	on in the implementation of the custom body.  You should let the exceptions
	 *	which can be thrown by this implementation pass unimpeded.
	 *	<pg>
	 *	When you set the database schema name, the database-specific implementation
	 *	of this method does a "commit; use database"-type sequence to change
	 *	to the target database.  This should be specified globally for all
	 *	database connections in a given cluster, so that all of
	 *	the application implementation clients are using the same database instance
	 *	regardless of what's been provided by the custom client implementation,
	 *	be it as a Java application or a web interface written using JEE.
	 */
	public void setDbSchemaName( String argDbSchemaName ) {
		final String S_ProcName = "setDbSchemaName";

		rollback();

		if( ( argDbSchemaName == null ) || ( argDbSchemaName.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argDbSchemaName" );
		}

		if( backingStore != null ) {
			backingStore.setDbSchemaName( argDbSchemaName );
		}

		schemaDbName = argDbSchemaName;
		lowerDbSchemaName = schemaDbName.toLowerCase();

		releasePreparedStatements();
	}

	public String fileImport( String fileName, String fileContents ) {
		String logContents = backingStore.fileImport( getAuthorization(), fileName, fileContents );
		return( logContents );
	}

	public boolean getCacheMisses() {
		return( cacheMisses );
	}

	public void setCacheMisses( boolean value ) {
		cacheMisses = value;
	}

	/**
	 *	Release any prepared statements acquired by this connection.
	 *	<p>
	 *	Resets the prepared statements so they can acquire the new value of
	 *	<tt>setDbSchemaName()</tt>.
	 */
	public void releasePreparedStatements() {
	}
	public CFBamAuthorization getAuthorization() {
		return( authorization );
	}

	public void setAuthorization( CFBamAuthorization value ) {
		authorization = value;
	}

	public ICFBamSchema getBackingStore() {
		return( backingStore );
	}

	public void setBackingStore( ICFBamSchema value ) {
		backingStore = value;
	}

	public String getSchemaName() {
		return( SCHEMA_NAME );
	}

	public boolean isConnected() {
		if( backingStore == null ) {
			return( false );
		}
		else {
			return( backingStore.isConnected() );
		}
	}

	public boolean connect() {
		return( backingStore.connect() );
	}

	public boolean connect( String username, String password ) {
		return( backingStore.connect( username, password ) );
	}

	public boolean connect( String clusterName, String tenantName, String secUserName, String password ) {
		final String S_ProcName = "connect-full";
		if( ( clusterName == null ) || ( clusterName.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"clusterName" );
		}
		if( ( tenantName == null ) || ( tenantName.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				2,
				"tenantName" );
		}
		if( ( secUserName == null ) || ( secUserName.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				3,
				"secUserName" );
		}
		if( ( password == null ) || ( password.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				5,
				"password" );
		}
		if( ! backingStore.connect( secUserName, password, clusterName, tenantName ) ) {
			return( false );
		}
		if( authorization != null ) {
			// The login was established as an XMsg client, which automatically sets the Authorization
			// information based on the return message.  You only need to do the remaining SecSession
			// and authorization creation if you're using a direct client-server model instead of
			// an XMsg client-server model.
			setSecClusterName( clusterName );
			setSecTenantName( tenantName );
			setSecUserName( secUserName );
			return( true );
		}
		setSecClusterName( clusterName );
		setSecTenantName( tenantName );
		setSecUserName( secUserName );
		boolean transactionStarted = beginTransaction();
		secCluster = null;
		secTenant = null;
		secUser = null;
		secSession = null;
		ICFBamClusterObj cluster = getSecCluster();
		ICFBamTenantObj tenant = getSecTenant();
		ICFBamSecUserObj user = getSecUser();
		ICFBamSecSessionObj session;
		if( ( cluster != null ) && ( tenant != null ) && ( user != null ) ) {
			session = getSecSessionTableObj().newInstance();
			ICFBamSecSessionEditObj sessionEdit = session.beginEdit();
			sessionEdit.setRequiredContainerSecUser( user );
			sessionEdit.setRequiredStart( Calendar.getInstance() );
			sessionEdit.setOptionalFinish( null );
			session = sessionEdit.create();
			sessionEdit.endEdit();
			setSecSession( session );
		}
		else {
			session = null;
		}
		if( transactionStarted ) {
			commit();
		}
		if( ( cluster == null ) || ( tenant == null ) || ( user == null ) || ( session == null ) ) {
			disconnect( false );
			authorization = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Could not resolve cluster name, tenant name, user name, or session.  Login cancelled" );
		}
		if( authorization == null ) {
			authorization = new CFBamAuthorization();
		}
		authorization.setSecCluster( cluster );
		authorization.setSecTenant( tenant );
		authorization.setSecSession( session );
		return( true );
	}

	public void disconnect( boolean doCommit ) {
		backingStore.disconnect( doCommit );
	}

	public void logout() {
		if( authorization == null ) {
			if( isConnected() ) {
				disconnect( false );
			}
			return;
		}
		if( isConnected() ) {
			try {
				boolean transactionStarted = beginTransaction();
				if( ! transactionStarted ) {
					rollback();
					transactionStarted = beginTransaction();
					if( ! transactionStarted ) {
						setAuthorization( null );
						return;
					}
				}
				UUID secSessionId = authorization.getSecSessionId();
				if( secSessionId != null ) {
					ICFBamSecSessionObj secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionId );
					if( secSession != null ) {
						if( secSession.getOptionalFinish() == null ) {
							ICFBamSecSessionEditObj editSecSession = secSession.beginEdit();
							editSecSession.setOptionalFinish( Calendar.getInstance() );
							editSecSession.update();
							editSecSession.endEdit();
						}
					}
				}
				commit();
			}
			finally {
				setAuthorization( null );
				try {
					disconnect( false );
				}
				catch( RuntimeException e ) {
				}
			}
		}
	}

	public void minimizeMemory() {
		if( accessFrequencyTableObj != null ) {
			accessFrequencyTableObj.minimizeMemory();
		}
		if( accessSecurityTableObj != null ) {
			accessSecurityTableObj.minimizeMemory();
		}
		if( atomTableObj != null ) {
			atomTableObj.minimizeMemory();
		}
		if( auditActionTableObj != null ) {
			auditActionTableObj.minimizeMemory();
		}
		if( blobColTableObj != null ) {
			blobColTableObj.minimizeMemory();
		}
		if( blobDefTableObj != null ) {
			blobDefTableObj.minimizeMemory();
		}
		if( blobTypeTableObj != null ) {
			blobTypeTableObj.minimizeMemory();
		}
		if( boolColTableObj != null ) {
			boolColTableObj.minimizeMemory();
		}
		if( boolDefTableObj != null ) {
			boolDefTableObj.minimizeMemory();
		}
		if( boolTypeTableObj != null ) {
			boolTypeTableObj.minimizeMemory();
		}
		if( chainTableObj != null ) {
			chainTableObj.minimizeMemory();
		}
		if( clearDepTableObj != null ) {
			clearDepTableObj.minimizeMemory();
		}
		if( clearSubDep1TableObj != null ) {
			clearSubDep1TableObj.minimizeMemory();
		}
		if( clearSubDep2TableObj != null ) {
			clearSubDep2TableObj.minimizeMemory();
		}
		if( clearSubDep3TableObj != null ) {
			clearSubDep3TableObj.minimizeMemory();
		}
		if( clearTopDepTableObj != null ) {
			clearTopDepTableObj.minimizeMemory();
		}
		if( clusterTableObj != null ) {
			clusterTableObj.minimizeMemory();
		}
		if( dataScopeTableObj != null ) {
			dataScopeTableObj.minimizeMemory();
		}
		if( dateColTableObj != null ) {
			dateColTableObj.minimizeMemory();
		}
		if( dateDefTableObj != null ) {
			dateDefTableObj.minimizeMemory();
		}
		if( dateTypeTableObj != null ) {
			dateTypeTableObj.minimizeMemory();
		}
		if( delDepTableObj != null ) {
			delDepTableObj.minimizeMemory();
		}
		if( delSubDep1TableObj != null ) {
			delSubDep1TableObj.minimizeMemory();
		}
		if( delSubDep2TableObj != null ) {
			delSubDep2TableObj.minimizeMemory();
		}
		if( delSubDep3TableObj != null ) {
			delSubDep3TableObj.minimizeMemory();
		}
		if( delTopDepTableObj != null ) {
			delTopDepTableObj.minimizeMemory();
		}
		if( domainTableObj != null ) {
			domainTableObj.minimizeMemory();
		}
		if( domainBaseTableObj != null ) {
			domainBaseTableObj.minimizeMemory();
		}
		if( doubleColTableObj != null ) {
			doubleColTableObj.minimizeMemory();
		}
		if( doubleDefTableObj != null ) {
			doubleDefTableObj.minimizeMemory();
		}
		if( doubleTypeTableObj != null ) {
			doubleTypeTableObj.minimizeMemory();
		}
		if( enumColTableObj != null ) {
			enumColTableObj.minimizeMemory();
		}
		if( enumDefTableObj != null ) {
			enumDefTableObj.minimizeMemory();
		}
		if( enumTagTableObj != null ) {
			enumTagTableObj.minimizeMemory();
		}
		if( enumTypeTableObj != null ) {
			enumTypeTableObj.minimizeMemory();
		}
		if( floatColTableObj != null ) {
			floatColTableObj.minimizeMemory();
		}
		if( floatDefTableObj != null ) {
			floatDefTableObj.minimizeMemory();
		}
		if( floatTypeTableObj != null ) {
			floatTypeTableObj.minimizeMemory();
		}
		if( hostNodeTableObj != null ) {
			hostNodeTableObj.minimizeMemory();
		}
		if( iSOCountryTableObj != null ) {
			iSOCountryTableObj.minimizeMemory();
		}
		if( iSOCountryCurrencyTableObj != null ) {
			iSOCountryCurrencyTableObj.minimizeMemory();
		}
		if( iSOCountryLanguageTableObj != null ) {
			iSOCountryLanguageTableObj.minimizeMemory();
		}
		if( iSOCurrencyTableObj != null ) {
			iSOCurrencyTableObj.minimizeMemory();
		}
		if( iSOLanguageTableObj != null ) {
			iSOLanguageTableObj.minimizeMemory();
		}
		if( iSOTimezoneTableObj != null ) {
			iSOTimezoneTableObj.minimizeMemory();
		}
		if( id16GenTableObj != null ) {
			id16GenTableObj.minimizeMemory();
		}
		if( id32GenTableObj != null ) {
			id32GenTableObj.minimizeMemory();
		}
		if( id64GenTableObj != null ) {
			id64GenTableObj.minimizeMemory();
		}
		if( indexTableObj != null ) {
			indexTableObj.minimizeMemory();
		}
		if( indexColTableObj != null ) {
			indexColTableObj.minimizeMemory();
		}
		if( int16ColTableObj != null ) {
			int16ColTableObj.minimizeMemory();
		}
		if( int16DefTableObj != null ) {
			int16DefTableObj.minimizeMemory();
		}
		if( int16TypeTableObj != null ) {
			int16TypeTableObj.minimizeMemory();
		}
		if( int32ColTableObj != null ) {
			int32ColTableObj.minimizeMemory();
		}
		if( int32DefTableObj != null ) {
			int32DefTableObj.minimizeMemory();
		}
		if( int32TypeTableObj != null ) {
			int32TypeTableObj.minimizeMemory();
		}
		if( int64ColTableObj != null ) {
			int64ColTableObj.minimizeMemory();
		}
		if( int64DefTableObj != null ) {
			int64DefTableObj.minimizeMemory();
		}
		if( int64TypeTableObj != null ) {
			int64TypeTableObj.minimizeMemory();
		}
		if( licenseTableObj != null ) {
			licenseTableObj.minimizeMemory();
		}
		if( loaderBehaviourTableObj != null ) {
			loaderBehaviourTableObj.minimizeMemory();
		}
		if( majorVersionTableObj != null ) {
			majorVersionTableObj.minimizeMemory();
		}
		if( mimeTypeTableObj != null ) {
			mimeTypeTableObj.minimizeMemory();
		}
		if( minorVersionTableObj != null ) {
			minorVersionTableObj.minimizeMemory();
		}
		if( nmTokenColTableObj != null ) {
			nmTokenColTableObj.minimizeMemory();
		}
		if( nmTokenDefTableObj != null ) {
			nmTokenDefTableObj.minimizeMemory();
		}
		if( nmTokenTypeTableObj != null ) {
			nmTokenTypeTableObj.minimizeMemory();
		}
		if( nmTokensColTableObj != null ) {
			nmTokensColTableObj.minimizeMemory();
		}
		if( nmTokensDefTableObj != null ) {
			nmTokensDefTableObj.minimizeMemory();
		}
		if( nmTokensTypeTableObj != null ) {
			nmTokensTypeTableObj.minimizeMemory();
		}
		if( numberColTableObj != null ) {
			numberColTableObj.minimizeMemory();
		}
		if( numberDefTableObj != null ) {
			numberDefTableObj.minimizeMemory();
		}
		if( numberTypeTableObj != null ) {
			numberTypeTableObj.minimizeMemory();
		}
		if( paramTableObj != null ) {
			paramTableObj.minimizeMemory();
		}
		if( popDepTableObj != null ) {
			popDepTableObj.minimizeMemory();
		}
		if( popSubDep1TableObj != null ) {
			popSubDep1TableObj.minimizeMemory();
		}
		if( popSubDep2TableObj != null ) {
			popSubDep2TableObj.minimizeMemory();
		}
		if( popSubDep3TableObj != null ) {
			popSubDep3TableObj.minimizeMemory();
		}
		if( popTopDepTableObj != null ) {
			popTopDepTableObj.minimizeMemory();
		}
		if( projectBaseTableObj != null ) {
			projectBaseTableObj.minimizeMemory();
		}
		if( realProjectTableObj != null ) {
			realProjectTableObj.minimizeMemory();
		}
		if( relationTableObj != null ) {
			relationTableObj.minimizeMemory();
		}
		if( relationColTableObj != null ) {
			relationColTableObj.minimizeMemory();
		}
		if( relationTypeTableObj != null ) {
			relationTypeTableObj.minimizeMemory();
		}
		if( schemaDefTableObj != null ) {
			schemaDefTableObj.minimizeMemory();
		}
		if( schemaRefTableObj != null ) {
			schemaRefTableObj.minimizeMemory();
		}
		if( scopeTableObj != null ) {
			scopeTableObj.minimizeMemory();
		}
		if( secAppTableObj != null ) {
			secAppTableObj.minimizeMemory();
		}
		if( secDeviceTableObj != null ) {
			secDeviceTableObj.minimizeMemory();
		}
		if( secFormTableObj != null ) {
			secFormTableObj.minimizeMemory();
		}
		if( secGroupTableObj != null ) {
			secGroupTableObj.minimizeMemory();
		}
		if( secGroupFormTableObj != null ) {
			secGroupFormTableObj.minimizeMemory();
		}
		if( secGroupIncludeTableObj != null ) {
			secGroupIncludeTableObj.minimizeMemory();
		}
		if( secGroupMemberTableObj != null ) {
			secGroupMemberTableObj.minimizeMemory();
		}
		if( secSessionTableObj != null ) {
			secSessionTableObj.minimizeMemory();
		}
		if( secUserTableObj != null ) {
			secUserTableObj.minimizeMemory();
		}
		if( securityScopeTableObj != null ) {
			securityScopeTableObj.minimizeMemory();
		}
		if( serverListFuncTableObj != null ) {
			serverListFuncTableObj.minimizeMemory();
		}
		if( serverMethodTableObj != null ) {
			serverMethodTableObj.minimizeMemory();
		}
		if( serverObjFuncTableObj != null ) {
			serverObjFuncTableObj.minimizeMemory();
		}
		if( serverProcTableObj != null ) {
			serverProcTableObj.minimizeMemory();
		}
		if( serviceTableObj != null ) {
			serviceTableObj.minimizeMemory();
		}
		if( serviceTypeTableObj != null ) {
			serviceTypeTableObj.minimizeMemory();
		}
		if( stringColTableObj != null ) {
			stringColTableObj.minimizeMemory();
		}
		if( stringDefTableObj != null ) {
			stringDefTableObj.minimizeMemory();
		}
		if( stringTypeTableObj != null ) {
			stringTypeTableObj.minimizeMemory();
		}
		if( subProjectTableObj != null ) {
			subProjectTableObj.minimizeMemory();
		}
		if( sysClusterTableObj != null ) {
			sysClusterTableObj.minimizeMemory();
		}
		if( tSecGroupTableObj != null ) {
			tSecGroupTableObj.minimizeMemory();
		}
		if( tSecGroupIncludeTableObj != null ) {
			tSecGroupIncludeTableObj.minimizeMemory();
		}
		if( tSecGroupMemberTableObj != null ) {
			tSecGroupMemberTableObj.minimizeMemory();
		}
		if( tZDateColTableObj != null ) {
			tZDateColTableObj.minimizeMemory();
		}
		if( tZDateDefTableObj != null ) {
			tZDateDefTableObj.minimizeMemory();
		}
		if( tZDateTypeTableObj != null ) {
			tZDateTypeTableObj.minimizeMemory();
		}
		if( tZTimeColTableObj != null ) {
			tZTimeColTableObj.minimizeMemory();
		}
		if( tZTimeDefTableObj != null ) {
			tZTimeDefTableObj.minimizeMemory();
		}
		if( tZTimeTypeTableObj != null ) {
			tZTimeTypeTableObj.minimizeMemory();
		}
		if( tZTimestampColTableObj != null ) {
			tZTimestampColTableObj.minimizeMemory();
		}
		if( tZTimestampDefTableObj != null ) {
			tZTimestampDefTableObj.minimizeMemory();
		}
		if( tZTimestampTypeTableObj != null ) {
			tZTimestampTypeTableObj.minimizeMemory();
		}
		if( tableTableObj != null ) {
			tableTableObj.minimizeMemory();
		}
		if( tableColTableObj != null ) {
			tableColTableObj.minimizeMemory();
		}
		if( tenantTableObj != null ) {
			tenantTableObj.minimizeMemory();
		}
		if( textColTableObj != null ) {
			textColTableObj.minimizeMemory();
		}
		if( textDefTableObj != null ) {
			textDefTableObj.minimizeMemory();
		}
		if( textTypeTableObj != null ) {
			textTypeTableObj.minimizeMemory();
		}
		if( timeColTableObj != null ) {
			timeColTableObj.minimizeMemory();
		}
		if( timeDefTableObj != null ) {
			timeDefTableObj.minimizeMemory();
		}
		if( timeTypeTableObj != null ) {
			timeTypeTableObj.minimizeMemory();
		}
		if( timestampColTableObj != null ) {
			timestampColTableObj.minimizeMemory();
		}
		if( timestampDefTableObj != null ) {
			timestampDefTableObj.minimizeMemory();
		}
		if( timestampTypeTableObj != null ) {
			timestampTypeTableObj.minimizeMemory();
		}
		if( tldTableObj != null ) {
			tldTableObj.minimizeMemory();
		}
		if( tokenColTableObj != null ) {
			tokenColTableObj.minimizeMemory();
		}
		if( tokenDefTableObj != null ) {
			tokenDefTableObj.minimizeMemory();
		}
		if( tokenTypeTableObj != null ) {
			tokenTypeTableObj.minimizeMemory();
		}
		if( topDomainTableObj != null ) {
			topDomainTableObj.minimizeMemory();
		}
		if( topProjectTableObj != null ) {
			topProjectTableObj.minimizeMemory();
		}
		if( uInt16ColTableObj != null ) {
			uInt16ColTableObj.minimizeMemory();
		}
		if( uInt16DefTableObj != null ) {
			uInt16DefTableObj.minimizeMemory();
		}
		if( uInt16TypeTableObj != null ) {
			uInt16TypeTableObj.minimizeMemory();
		}
		if( uInt32ColTableObj != null ) {
			uInt32ColTableObj.minimizeMemory();
		}
		if( uInt32DefTableObj != null ) {
			uInt32DefTableObj.minimizeMemory();
		}
		if( uInt32TypeTableObj != null ) {
			uInt32TypeTableObj.minimizeMemory();
		}
		if( uInt64ColTableObj != null ) {
			uInt64ColTableObj.minimizeMemory();
		}
		if( uInt64DefTableObj != null ) {
			uInt64DefTableObj.minimizeMemory();
		}
		if( uInt64TypeTableObj != null ) {
			uInt64TypeTableObj.minimizeMemory();
		}
		if( uRLProtocolTableObj != null ) {
			uRLProtocolTableObj.minimizeMemory();
		}
		if( uuidColTableObj != null ) {
			uuidColTableObj.minimizeMemory();
		}
		if( uuidDefTableObj != null ) {
			uuidDefTableObj.minimizeMemory();
		}
		if( uuidGenTableObj != null ) {
			uuidGenTableObj.minimizeMemory();
		}
		if( uuidTypeTableObj != null ) {
			uuidTypeTableObj.minimizeMemory();
		}
		if( valueTableObj != null ) {
			valueTableObj.minimizeMemory();
		}
		if( versionTableObj != null ) {
			versionTableObj.minimizeMemory();
		}
	}

	public boolean isTransactionOpen() {
		boolean txnOpen = backingStore.isTransactionOpen();
		return( txnOpen );
	}

	public boolean beginTransaction() {
		boolean txnInitiated = backingStore.beginTransaction();
		return( txnInitiated );
	}

	public void commit() {
		backingStore.commit();
	}

	public void rollback() {
		backingStore.rollback();
	}
	public ICFBamAccessFrequencyTableObj getAccessFrequencyTableObj() {
		return( accessFrequencyTableObj );
	}

	public ICFBamAccessSecurityTableObj getAccessSecurityTableObj() {
		return( accessSecurityTableObj );
	}

	public ICFBamAtomTableObj getAtomTableObj() {
		return( atomTableObj );
	}

	public ICFBamAuditActionTableObj getAuditActionTableObj() {
		return( auditActionTableObj );
	}

	public ICFBamBlobColTableObj getBlobColTableObj() {
		return( blobColTableObj );
	}

	public ICFBamBlobDefTableObj getBlobDefTableObj() {
		return( blobDefTableObj );
	}

	public ICFBamBlobTypeTableObj getBlobTypeTableObj() {
		return( blobTypeTableObj );
	}

	public ICFBamBoolColTableObj getBoolColTableObj() {
		return( boolColTableObj );
	}

	public ICFBamBoolDefTableObj getBoolDefTableObj() {
		return( boolDefTableObj );
	}

	public ICFBamBoolTypeTableObj getBoolTypeTableObj() {
		return( boolTypeTableObj );
	}

	public ICFBamChainTableObj getChainTableObj() {
		return( chainTableObj );
	}

	public ICFBamClearDepTableObj getClearDepTableObj() {
		return( clearDepTableObj );
	}

	public ICFBamClearSubDep1TableObj getClearSubDep1TableObj() {
		return( clearSubDep1TableObj );
	}

	public ICFBamClearSubDep2TableObj getClearSubDep2TableObj() {
		return( clearSubDep2TableObj );
	}

	public ICFBamClearSubDep3TableObj getClearSubDep3TableObj() {
		return( clearSubDep3TableObj );
	}

	public ICFBamClearTopDepTableObj getClearTopDepTableObj() {
		return( clearTopDepTableObj );
	}

	public ICFBamClusterTableObj getClusterTableObj() {
		return( clusterTableObj );
	}

	public ICFBamDataScopeTableObj getDataScopeTableObj() {
		return( dataScopeTableObj );
	}

	public ICFBamDateColTableObj getDateColTableObj() {
		return( dateColTableObj );
	}

	public ICFBamDateDefTableObj getDateDefTableObj() {
		return( dateDefTableObj );
	}

	public ICFBamDateTypeTableObj getDateTypeTableObj() {
		return( dateTypeTableObj );
	}

	public ICFBamDelDepTableObj getDelDepTableObj() {
		return( delDepTableObj );
	}

	public ICFBamDelSubDep1TableObj getDelSubDep1TableObj() {
		return( delSubDep1TableObj );
	}

	public ICFBamDelSubDep2TableObj getDelSubDep2TableObj() {
		return( delSubDep2TableObj );
	}

	public ICFBamDelSubDep3TableObj getDelSubDep3TableObj() {
		return( delSubDep3TableObj );
	}

	public ICFBamDelTopDepTableObj getDelTopDepTableObj() {
		return( delTopDepTableObj );
	}

	public ICFBamDomainTableObj getDomainTableObj() {
		return( domainTableObj );
	}

	public ICFBamDomainBaseTableObj getDomainBaseTableObj() {
		return( domainBaseTableObj );
	}

	public ICFBamDoubleColTableObj getDoubleColTableObj() {
		return( doubleColTableObj );
	}

	public ICFBamDoubleDefTableObj getDoubleDefTableObj() {
		return( doubleDefTableObj );
	}

	public ICFBamDoubleTypeTableObj getDoubleTypeTableObj() {
		return( doubleTypeTableObj );
	}

	public ICFBamEnumColTableObj getEnumColTableObj() {
		return( enumColTableObj );
	}

	public ICFBamEnumDefTableObj getEnumDefTableObj() {
		return( enumDefTableObj );
	}

	public ICFBamEnumTagTableObj getEnumTagTableObj() {
		return( enumTagTableObj );
	}

	public ICFBamEnumTypeTableObj getEnumTypeTableObj() {
		return( enumTypeTableObj );
	}

	public ICFBamFloatColTableObj getFloatColTableObj() {
		return( floatColTableObj );
	}

	public ICFBamFloatDefTableObj getFloatDefTableObj() {
		return( floatDefTableObj );
	}

	public ICFBamFloatTypeTableObj getFloatTypeTableObj() {
		return( floatTypeTableObj );
	}

	public ICFBamHostNodeTableObj getHostNodeTableObj() {
		return( hostNodeTableObj );
	}

	public ICFBamISOCountryTableObj getISOCountryTableObj() {
		return( iSOCountryTableObj );
	}

	public ICFBamISOCountryCurrencyTableObj getISOCountryCurrencyTableObj() {
		return( iSOCountryCurrencyTableObj );
	}

	public ICFBamISOCountryLanguageTableObj getISOCountryLanguageTableObj() {
		return( iSOCountryLanguageTableObj );
	}

	public ICFBamISOCurrencyTableObj getISOCurrencyTableObj() {
		return( iSOCurrencyTableObj );
	}

	public ICFBamISOLanguageTableObj getISOLanguageTableObj() {
		return( iSOLanguageTableObj );
	}

	public ICFBamISOTimezoneTableObj getISOTimezoneTableObj() {
		return( iSOTimezoneTableObj );
	}

	public ICFBamId16GenTableObj getId16GenTableObj() {
		return( id16GenTableObj );
	}

	public ICFBamId32GenTableObj getId32GenTableObj() {
		return( id32GenTableObj );
	}

	public ICFBamId64GenTableObj getId64GenTableObj() {
		return( id64GenTableObj );
	}

	public ICFBamIndexTableObj getIndexTableObj() {
		return( indexTableObj );
	}

	public ICFBamIndexColTableObj getIndexColTableObj() {
		return( indexColTableObj );
	}

	public ICFBamInt16ColTableObj getInt16ColTableObj() {
		return( int16ColTableObj );
	}

	public ICFBamInt16DefTableObj getInt16DefTableObj() {
		return( int16DefTableObj );
	}

	public ICFBamInt16TypeTableObj getInt16TypeTableObj() {
		return( int16TypeTableObj );
	}

	public ICFBamInt32ColTableObj getInt32ColTableObj() {
		return( int32ColTableObj );
	}

	public ICFBamInt32DefTableObj getInt32DefTableObj() {
		return( int32DefTableObj );
	}

	public ICFBamInt32TypeTableObj getInt32TypeTableObj() {
		return( int32TypeTableObj );
	}

	public ICFBamInt64ColTableObj getInt64ColTableObj() {
		return( int64ColTableObj );
	}

	public ICFBamInt64DefTableObj getInt64DefTableObj() {
		return( int64DefTableObj );
	}

	public ICFBamInt64TypeTableObj getInt64TypeTableObj() {
		return( int64TypeTableObj );
	}

	public ICFBamLicenseTableObj getLicenseTableObj() {
		return( licenseTableObj );
	}

	public ICFBamLoaderBehaviourTableObj getLoaderBehaviourTableObj() {
		return( loaderBehaviourTableObj );
	}

	public ICFBamMajorVersionTableObj getMajorVersionTableObj() {
		return( majorVersionTableObj );
	}

	public ICFBamMimeTypeTableObj getMimeTypeTableObj() {
		return( mimeTypeTableObj );
	}

	public ICFBamMinorVersionTableObj getMinorVersionTableObj() {
		return( minorVersionTableObj );
	}

	public ICFBamNmTokenColTableObj getNmTokenColTableObj() {
		return( nmTokenColTableObj );
	}

	public ICFBamNmTokenDefTableObj getNmTokenDefTableObj() {
		return( nmTokenDefTableObj );
	}

	public ICFBamNmTokenTypeTableObj getNmTokenTypeTableObj() {
		return( nmTokenTypeTableObj );
	}

	public ICFBamNmTokensColTableObj getNmTokensColTableObj() {
		return( nmTokensColTableObj );
	}

	public ICFBamNmTokensDefTableObj getNmTokensDefTableObj() {
		return( nmTokensDefTableObj );
	}

	public ICFBamNmTokensTypeTableObj getNmTokensTypeTableObj() {
		return( nmTokensTypeTableObj );
	}

	public ICFBamNumberColTableObj getNumberColTableObj() {
		return( numberColTableObj );
	}

	public ICFBamNumberDefTableObj getNumberDefTableObj() {
		return( numberDefTableObj );
	}

	public ICFBamNumberTypeTableObj getNumberTypeTableObj() {
		return( numberTypeTableObj );
	}

	public ICFBamParamTableObj getParamTableObj() {
		return( paramTableObj );
	}

	public ICFBamPopDepTableObj getPopDepTableObj() {
		return( popDepTableObj );
	}

	public ICFBamPopSubDep1TableObj getPopSubDep1TableObj() {
		return( popSubDep1TableObj );
	}

	public ICFBamPopSubDep2TableObj getPopSubDep2TableObj() {
		return( popSubDep2TableObj );
	}

	public ICFBamPopSubDep3TableObj getPopSubDep3TableObj() {
		return( popSubDep3TableObj );
	}

	public ICFBamPopTopDepTableObj getPopTopDepTableObj() {
		return( popTopDepTableObj );
	}

	public ICFBamProjectBaseTableObj getProjectBaseTableObj() {
		return( projectBaseTableObj );
	}

	public ICFBamRealProjectTableObj getRealProjectTableObj() {
		return( realProjectTableObj );
	}

	public ICFBamRelationTableObj getRelationTableObj() {
		return( relationTableObj );
	}

	public ICFBamRelationColTableObj getRelationColTableObj() {
		return( relationColTableObj );
	}

	public ICFBamRelationTypeTableObj getRelationTypeTableObj() {
		return( relationTypeTableObj );
	}

	public ICFBamSchemaDefTableObj getSchemaDefTableObj() {
		return( schemaDefTableObj );
	}

	public ICFBamSchemaRefTableObj getSchemaRefTableObj() {
		return( schemaRefTableObj );
	}

	public ICFBamScopeTableObj getScopeTableObj() {
		return( scopeTableObj );
	}

	public ICFBamSecAppTableObj getSecAppTableObj() {
		return( secAppTableObj );
	}

	public ICFBamSecDeviceTableObj getSecDeviceTableObj() {
		return( secDeviceTableObj );
	}

	public ICFBamSecFormTableObj getSecFormTableObj() {
		return( secFormTableObj );
	}

	public ICFBamSecGroupTableObj getSecGroupTableObj() {
		return( secGroupTableObj );
	}

	public ICFBamSecGroupFormTableObj getSecGroupFormTableObj() {
		return( secGroupFormTableObj );
	}

	public ICFBamSecGroupIncludeTableObj getSecGroupIncludeTableObj() {
		return( secGroupIncludeTableObj );
	}

	public ICFBamSecGroupMemberTableObj getSecGroupMemberTableObj() {
		return( secGroupMemberTableObj );
	}

	public ICFBamSecSessionTableObj getSecSessionTableObj() {
		return( secSessionTableObj );
	}

	public ICFBamSecUserTableObj getSecUserTableObj() {
		return( secUserTableObj );
	}

	public ICFBamSecurityScopeTableObj getSecurityScopeTableObj() {
		return( securityScopeTableObj );
	}

	public ICFBamServerListFuncTableObj getServerListFuncTableObj() {
		return( serverListFuncTableObj );
	}

	public ICFBamServerMethodTableObj getServerMethodTableObj() {
		return( serverMethodTableObj );
	}

	public ICFBamServerObjFuncTableObj getServerObjFuncTableObj() {
		return( serverObjFuncTableObj );
	}

	public ICFBamServerProcTableObj getServerProcTableObj() {
		return( serverProcTableObj );
	}

	public ICFBamServiceTableObj getServiceTableObj() {
		return( serviceTableObj );
	}

	public ICFBamServiceTypeTableObj getServiceTypeTableObj() {
		return( serviceTypeTableObj );
	}

	public ICFBamStringColTableObj getStringColTableObj() {
		return( stringColTableObj );
	}

	public ICFBamStringDefTableObj getStringDefTableObj() {
		return( stringDefTableObj );
	}

	public ICFBamStringTypeTableObj getStringTypeTableObj() {
		return( stringTypeTableObj );
	}

	public ICFBamSubProjectTableObj getSubProjectTableObj() {
		return( subProjectTableObj );
	}

	public ICFBamSysClusterTableObj getSysClusterTableObj() {
		return( sysClusterTableObj );
	}

	public ICFBamTSecGroupTableObj getTSecGroupTableObj() {
		return( tSecGroupTableObj );
	}

	public ICFBamTSecGroupIncludeTableObj getTSecGroupIncludeTableObj() {
		return( tSecGroupIncludeTableObj );
	}

	public ICFBamTSecGroupMemberTableObj getTSecGroupMemberTableObj() {
		return( tSecGroupMemberTableObj );
	}

	public ICFBamTZDateColTableObj getTZDateColTableObj() {
		return( tZDateColTableObj );
	}

	public ICFBamTZDateDefTableObj getTZDateDefTableObj() {
		return( tZDateDefTableObj );
	}

	public ICFBamTZDateTypeTableObj getTZDateTypeTableObj() {
		return( tZDateTypeTableObj );
	}

	public ICFBamTZTimeColTableObj getTZTimeColTableObj() {
		return( tZTimeColTableObj );
	}

	public ICFBamTZTimeDefTableObj getTZTimeDefTableObj() {
		return( tZTimeDefTableObj );
	}

	public ICFBamTZTimeTypeTableObj getTZTimeTypeTableObj() {
		return( tZTimeTypeTableObj );
	}

	public ICFBamTZTimestampColTableObj getTZTimestampColTableObj() {
		return( tZTimestampColTableObj );
	}

	public ICFBamTZTimestampDefTableObj getTZTimestampDefTableObj() {
		return( tZTimestampDefTableObj );
	}

	public ICFBamTZTimestampTypeTableObj getTZTimestampTypeTableObj() {
		return( tZTimestampTypeTableObj );
	}

	public ICFBamTableTableObj getTableTableObj() {
		return( tableTableObj );
	}

	public ICFBamTableColTableObj getTableColTableObj() {
		return( tableColTableObj );
	}

	public ICFBamTenantTableObj getTenantTableObj() {
		return( tenantTableObj );
	}

	public ICFBamTextColTableObj getTextColTableObj() {
		return( textColTableObj );
	}

	public ICFBamTextDefTableObj getTextDefTableObj() {
		return( textDefTableObj );
	}

	public ICFBamTextTypeTableObj getTextTypeTableObj() {
		return( textTypeTableObj );
	}

	public ICFBamTimeColTableObj getTimeColTableObj() {
		return( timeColTableObj );
	}

	public ICFBamTimeDefTableObj getTimeDefTableObj() {
		return( timeDefTableObj );
	}

	public ICFBamTimeTypeTableObj getTimeTypeTableObj() {
		return( timeTypeTableObj );
	}

	public ICFBamTimestampColTableObj getTimestampColTableObj() {
		return( timestampColTableObj );
	}

	public ICFBamTimestampDefTableObj getTimestampDefTableObj() {
		return( timestampDefTableObj );
	}

	public ICFBamTimestampTypeTableObj getTimestampTypeTableObj() {
		return( timestampTypeTableObj );
	}

	public ICFBamTldTableObj getTldTableObj() {
		return( tldTableObj );
	}

	public ICFBamTokenColTableObj getTokenColTableObj() {
		return( tokenColTableObj );
	}

	public ICFBamTokenDefTableObj getTokenDefTableObj() {
		return( tokenDefTableObj );
	}

	public ICFBamTokenTypeTableObj getTokenTypeTableObj() {
		return( tokenTypeTableObj );
	}

	public ICFBamTopDomainTableObj getTopDomainTableObj() {
		return( topDomainTableObj );
	}

	public ICFBamTopProjectTableObj getTopProjectTableObj() {
		return( topProjectTableObj );
	}

	public ICFBamUInt16ColTableObj getUInt16ColTableObj() {
		return( uInt16ColTableObj );
	}

	public ICFBamUInt16DefTableObj getUInt16DefTableObj() {
		return( uInt16DefTableObj );
	}

	public ICFBamUInt16TypeTableObj getUInt16TypeTableObj() {
		return( uInt16TypeTableObj );
	}

	public ICFBamUInt32ColTableObj getUInt32ColTableObj() {
		return( uInt32ColTableObj );
	}

	public ICFBamUInt32DefTableObj getUInt32DefTableObj() {
		return( uInt32DefTableObj );
	}

	public ICFBamUInt32TypeTableObj getUInt32TypeTableObj() {
		return( uInt32TypeTableObj );
	}

	public ICFBamUInt64ColTableObj getUInt64ColTableObj() {
		return( uInt64ColTableObj );
	}

	public ICFBamUInt64DefTableObj getUInt64DefTableObj() {
		return( uInt64DefTableObj );
	}

	public ICFBamUInt64TypeTableObj getUInt64TypeTableObj() {
		return( uInt64TypeTableObj );
	}

	public ICFBamURLProtocolTableObj getURLProtocolTableObj() {
		return( uRLProtocolTableObj );
	}

	public ICFBamUuidColTableObj getUuidColTableObj() {
		return( uuidColTableObj );
	}

	public ICFBamUuidDefTableObj getUuidDefTableObj() {
		return( uuidDefTableObj );
	}

	public ICFBamUuidGenTableObj getUuidGenTableObj() {
		return( uuidGenTableObj );
	}

	public ICFBamUuidTypeTableObj getUuidTypeTableObj() {
		return( uuidTypeTableObj );
	}

	public ICFBamValueTableObj getValueTableObj() {
		return( valueTableObj );
	}

	public ICFBamVersionTableObj getVersionTableObj() {
		return( versionTableObj );
	}
}
