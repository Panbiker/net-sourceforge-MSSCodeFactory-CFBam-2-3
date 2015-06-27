// Description: Java 7 XML SAX Parser for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSaxLoader;

import java.io.File;
import java.lang.reflect.*;
import java.math.*;
import java.net.URL;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public class CFBamSaxLoader
	extends CFLibXmlCoreSaxParser
	implements ContentHandler
{

	// The namespace URI of the supported schema
	public final static String	SCHEMA_XMLNS = "uri://net.sourceforge.msscodefactory.cfbam.v2_3/cfbamloader";

	// The source for loading the supported schema
	public final static String	SCHEMA_URI = "xsd/cfbam-23-structured.xsd";
	public final static String	SCHEMA_ROOT_URI = "/xsd/cfbam-23-structured.xsd";
	public final static String CFSECURITY_XMLNS = "uri://net.sourceforge.msscodefactory.cfbam.v2_3/cfsecurityloader";
	public final static String CFSECURITY_URI = "xsd/cfsecurity-23-structured.xsd";
	public final static String CFSECURITY_ROOT_URI = "xsd/cfsecurity-23-structured.xsd";

	public final static String CFINTERNET_XMLNS = "uri://net.sourceforge.msscodefactory.cfbam.v2_3/cfinternetloader";
	public final static String CFINTERNET_URI = "xsd/cfinternet-23-structured.xsd";
	public final static String CFINTERNET_ROOT_URI = "xsd/cfinternet-23-structured.xsd";


	// The schema instance to load in to

	private ICFBamSchemaObj schemaObj = null;

	// The cluster to use for loading
	
	private ICFBamClusterObj useCluster = null;
	
	public ICFBamClusterObj getUseCluster() {
		return( useCluster );
	}
	
	public void setUseCluster( ICFBamClusterObj value ) {
		useCluster = value;
	}

	// The tenant to use for loading

	private ICFBamTenantObj useTenant = null;
	
	public ICFBamTenantObj getUseTenant() {
		return( useTenant );
	}
	
	public void setUseTenant( ICFBamTenantObj value ) {
		useTenant = value;
	}

	// Loader behaviour configuration attributes

	public enum LoaderBehaviourEnum {
		Insert,
		Update,
		Replace
	};
	private LoaderBehaviourEnum accessFrequencyLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum accessSecurityLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum atomLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum auditActionLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum blobColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum blobDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum blobTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum boolColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum boolDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum boolTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum chainLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clearDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clearSubDep1LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clearSubDep2LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clearSubDep3LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clearTopDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum clusterLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum dataScopeLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum dateColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dateDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum dateTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum delDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum delSubDep1LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum delSubDep2LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum delSubDep3LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum delTopDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum domainLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum domainBaseLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum doubleColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum doubleDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum doubleTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum enumColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum enumDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum enumTagLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum enumTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum floatColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum floatDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum floatTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum hostNodeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOCountryLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOCountryCurrencyLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum iSOCountryLanguageLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum iSOCurrencyLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOLanguageLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOTimezoneLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum id16GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum id32GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum id64GenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum indexLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum indexColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int16ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int16DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int16TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int32ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int32DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int32TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int64ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int64DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum int64TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum licenseLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum loaderBehaviourLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum majorVersionLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum mimeTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum minorVersionLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokenColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokenDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokenTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokensColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokensDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum nmTokensTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum numberColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum numberDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum numberTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum paramLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum popDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum popSubDep1LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum popSubDep2LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum popSubDep3LoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum popTopDepLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum projectBaseLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum realProjectLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum relationLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum relationColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum relationTypeLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum schemaDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum schemaRefLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum scopeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum secAppLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum secDeviceLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secFormLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum secGroupLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secGroupFormLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secGroupIncludeLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secGroupMemberLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSessionLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum securityScopeLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum serverListFuncLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum serverMethodLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum serverObjFuncLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum serverProcLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum serviceLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum serviceTypeLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum stringColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum stringDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum stringTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum subProjectLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum sysClusterLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum tSecGroupLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum tSecGroupIncludeLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum tSecGroupMemberLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum tZDateColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZDateDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZDateTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimeColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimeDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimeTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimestampColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimestampDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tZTimestampTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tableLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tableColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tenantLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum textColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum textDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum textTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timeColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timeDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timeTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timestampColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timestampDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum timestampTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tldLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tokenColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tokenDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tokenTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum topDomainLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum topProjectLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt16ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt16DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt16TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt32ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt32DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt32TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt64ColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt64DefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uInt64TypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uRLProtocolLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuidColLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuidDefLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuidGenLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uuidTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum valueLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum versionLoaderBehaviour = LoaderBehaviourEnum.Update;


	// Constructors

	public CFBamSaxLoader() {
		super();
		setRootElementHandler( getSaxRootHandler() );
		File file = new File( SCHEMA_URI );
		if( file.exists() ) {
			addSchema( SCHEMA_URI );
		}
		else {
			URL url = getClass().getResource( SCHEMA_ROOT_URI );
			if( url != null ) {
				addSchema( url.toString() );
			}
		}
		file = new File( CFSECURITY_URI );
		if( file.exists() ) {
			addSchema( CFSECURITY_URI );
		}
		else {
			URL url = getClass().getResource( CFSECURITY_ROOT_URI );
			if( url != null ) {
				addSchema( url.toString() );
			}
		}
		file = new File( CFINTERNET_URI );
		if( file.exists() ) {
			addSchema( CFINTERNET_URI );
		}
		else {
			URL url = getClass().getResource( CFINTERNET_ROOT_URI );
			if( url != null ) {
				addSchema( url.toString() );
			}
		}
		initParser();
	}

	public CFBamSaxLoader( ICFLibMessageLog logger ) {
		super( logger );
		setRootElementHandler( getSaxRootHandler() );
		File file = new File( SCHEMA_URI );
		if( file.exists() ) {
			addSchema( SCHEMA_URI );
		}
		else {
			URL url = getClass().getResource( SCHEMA_ROOT_URI );
			if( url != null ) {
				addSchema( url.toString() );
			}
		}
		file = new File( CFSECURITY_URI );
		if( file.exists() ) {
			addSchema( CFSECURITY_URI );
		}
		else {
			URL url = getClass().getResource( CFSECURITY_ROOT_URI );
			if( url != null ) {
				addSchema( url.toString() );
			}
		}
		file = new File( CFINTERNET_URI );
		if( file.exists() ) {
			addSchema( CFINTERNET_URI );
		}
		else {
			URL url = getClass().getResource( CFINTERNET_ROOT_URI );
			if( url != null ) {
				addSchema( url.toString() );
			}
		}
		initParser();
	}

	// Element Handler instances

	private CFBamSaxLoaderAccessFrequencyHandler accessFrequencyHandler = null;
	private CFBamSaxLoaderAccessSecurityHandler accessSecurityHandler = null;
	private CFBamSaxLoaderAtomHandler atomHandler = null;
	private CFBamSaxLoaderAuditActionHandler auditActionHandler = null;
	private CFBamSaxLoaderBlobColHandler blobColHandler = null;
	private CFBamSaxLoaderBlobDefHandler blobDefHandler = null;
	private CFBamSaxLoaderBlobTypeHandler blobTypeHandler = null;
	private CFBamSaxLoaderBoolColHandler boolColHandler = null;
	private CFBamSaxLoaderBoolDefHandler boolDefHandler = null;
	private CFBamSaxLoaderBoolTypeHandler boolTypeHandler = null;
	private CFBamSaxLoaderChainHandler chainHandler = null;
	private CFBamSaxLoaderClearDepHandler clearDepHandler = null;
	private CFBamSaxLoaderClearSubDep1Handler clearSubDep1Handler = null;
	private CFBamSaxLoaderClearSubDep2Handler clearSubDep2Handler = null;
	private CFBamSaxLoaderClearSubDep3Handler clearSubDep3Handler = null;
	private CFBamSaxLoaderClearTopDepHandler clearTopDepHandler = null;
	private CFBamSaxLoaderClusterHandler clusterHandler = null;
	private CFBamSaxLoaderDataScopeHandler dataScopeHandler = null;
	private CFBamSaxLoaderDateColHandler dateColHandler = null;
	private CFBamSaxLoaderDateDefHandler dateDefHandler = null;
	private CFBamSaxLoaderDateTypeHandler dateTypeHandler = null;
	private CFBamSaxLoaderDelDepHandler delDepHandler = null;
	private CFBamSaxLoaderDelSubDep1Handler delSubDep1Handler = null;
	private CFBamSaxLoaderDelSubDep2Handler delSubDep2Handler = null;
	private CFBamSaxLoaderDelSubDep3Handler delSubDep3Handler = null;
	private CFBamSaxLoaderDelTopDepHandler delTopDepHandler = null;
	private CFBamSaxLoaderDomainHandler domainHandler = null;
	private CFBamSaxLoaderDomainBaseHandler domainBaseHandler = null;
	private CFBamSaxLoaderDoubleColHandler doubleColHandler = null;
	private CFBamSaxLoaderDoubleDefHandler doubleDefHandler = null;
	private CFBamSaxLoaderDoubleTypeHandler doubleTypeHandler = null;
	private CFBamSaxLoaderEnumColHandler enumColHandler = null;
	private CFBamSaxLoaderEnumDefHandler enumDefHandler = null;
	private CFBamSaxLoaderEnumTagHandler enumTagHandler = null;
	private CFBamSaxLoaderEnumTypeHandler enumTypeHandler = null;
	private CFBamSaxLoaderFloatColHandler floatColHandler = null;
	private CFBamSaxLoaderFloatDefHandler floatDefHandler = null;
	private CFBamSaxLoaderFloatTypeHandler floatTypeHandler = null;
	private CFBamSaxLoaderHostNodeHandler hostNodeHandler = null;
	private CFBamSaxLoaderISOCountryHandler iSOCountryHandler = null;
	private CFBamSaxLoaderISOCountryCurrencyHandler iSOCountryCurrencyHandler = null;
	private CFBamSaxLoaderISOCountryLanguageHandler iSOCountryLanguageHandler = null;
	private CFBamSaxLoaderISOCurrencyHandler iSOCurrencyHandler = null;
	private CFBamSaxLoaderISOLanguageHandler iSOLanguageHandler = null;
	private CFBamSaxLoaderISOTimezoneHandler iSOTimezoneHandler = null;
	private CFBamSaxLoaderId16GenHandler id16GenHandler = null;
	private CFBamSaxLoaderId32GenHandler id32GenHandler = null;
	private CFBamSaxLoaderId64GenHandler id64GenHandler = null;
	private CFBamSaxLoaderIndexHandler indexHandler = null;
	private CFBamSaxLoaderIndexColHandler indexColHandler = null;
	private CFBamSaxLoaderInt16ColHandler int16ColHandler = null;
	private CFBamSaxLoaderInt16DefHandler int16DefHandler = null;
	private CFBamSaxLoaderInt16TypeHandler int16TypeHandler = null;
	private CFBamSaxLoaderInt32ColHandler int32ColHandler = null;
	private CFBamSaxLoaderInt32DefHandler int32DefHandler = null;
	private CFBamSaxLoaderInt32TypeHandler int32TypeHandler = null;
	private CFBamSaxLoaderInt64ColHandler int64ColHandler = null;
	private CFBamSaxLoaderInt64DefHandler int64DefHandler = null;
	private CFBamSaxLoaderInt64TypeHandler int64TypeHandler = null;
	private CFBamSaxLoaderLicenseHandler licenseHandler = null;
	private CFBamSaxLoaderLoaderBehaviourHandler loaderBehaviourHandler = null;
	private CFBamSaxLoaderMajorVersionHandler majorVersionHandler = null;
	private CFBamSaxLoaderMimeTypeHandler mimeTypeHandler = null;
	private CFBamSaxLoaderMinorVersionHandler minorVersionHandler = null;
	private CFBamSaxLoaderNmTokenColHandler nmTokenColHandler = null;
	private CFBamSaxLoaderNmTokenDefHandler nmTokenDefHandler = null;
	private CFBamSaxLoaderNmTokenTypeHandler nmTokenTypeHandler = null;
	private CFBamSaxLoaderNmTokensColHandler nmTokensColHandler = null;
	private CFBamSaxLoaderNmTokensDefHandler nmTokensDefHandler = null;
	private CFBamSaxLoaderNmTokensTypeHandler nmTokensTypeHandler = null;
	private CFBamSaxLoaderNumberColHandler numberColHandler = null;
	private CFBamSaxLoaderNumberDefHandler numberDefHandler = null;
	private CFBamSaxLoaderNumberTypeHandler numberTypeHandler = null;
	private CFBamSaxLoaderParamHandler paramHandler = null;
	private CFBamSaxLoaderPopDepHandler popDepHandler = null;
	private CFBamSaxLoaderPopSubDep1Handler popSubDep1Handler = null;
	private CFBamSaxLoaderPopSubDep2Handler popSubDep2Handler = null;
	private CFBamSaxLoaderPopSubDep3Handler popSubDep3Handler = null;
	private CFBamSaxLoaderPopTopDepHandler popTopDepHandler = null;
	private CFBamSaxLoaderProjectBaseHandler projectBaseHandler = null;
	private CFBamSaxLoaderRealProjectHandler realProjectHandler = null;
	private CFBamSaxLoaderRelationHandler relationHandler = null;
	private CFBamSaxLoaderRelationColHandler relationColHandler = null;
	private CFBamSaxLoaderRelationTypeHandler relationTypeHandler = null;
	private CFBamSaxLoaderSchemaDefHandler schemaDefHandler = null;
	private CFBamSaxLoaderSchemaRefHandler schemaRefHandler = null;
	private CFBamSaxLoaderScopeHandler scopeHandler = null;
	private CFBamSaxLoaderSecAppHandler secAppHandler = null;
	private CFBamSaxLoaderSecDeviceHandler secDeviceHandler = null;
	private CFBamSaxLoaderSecFormHandler secFormHandler = null;
	private CFBamSaxLoaderSecGroupHandler secGroupHandler = null;
	private CFBamSaxLoaderSecGroupFormHandler secGroupFormHandler = null;
	private CFBamSaxLoaderSecGroupIncludeHandler secGroupIncludeHandler = null;
	private CFBamSaxLoaderSecGroupMemberHandler secGroupMemberHandler = null;
	private CFBamSaxLoaderSecSessionHandler secSessionHandler = null;
	private CFBamSaxLoaderSecUserHandler secUserHandler = null;
	private CFBamSaxLoaderSecurityScopeHandler securityScopeHandler = null;
	private CFBamSaxLoaderServerListFuncHandler serverListFuncHandler = null;
	private CFBamSaxLoaderServerMethodHandler serverMethodHandler = null;
	private CFBamSaxLoaderServerObjFuncHandler serverObjFuncHandler = null;
	private CFBamSaxLoaderServerProcHandler serverProcHandler = null;
	private CFBamSaxLoaderServiceHandler serviceHandler = null;
	private CFBamSaxLoaderServiceTypeHandler serviceTypeHandler = null;
	private CFBamSaxLoaderStringColHandler stringColHandler = null;
	private CFBamSaxLoaderStringDefHandler stringDefHandler = null;
	private CFBamSaxLoaderStringTypeHandler stringTypeHandler = null;
	private CFBamSaxLoaderSubProjectHandler subProjectHandler = null;
	private CFBamSaxLoaderSysClusterHandler sysClusterHandler = null;
	private CFBamSaxLoaderTSecGroupHandler tSecGroupHandler = null;
	private CFBamSaxLoaderTSecGroupIncludeHandler tSecGroupIncludeHandler = null;
	private CFBamSaxLoaderTSecGroupMemberHandler tSecGroupMemberHandler = null;
	private CFBamSaxLoaderTZDateColHandler tZDateColHandler = null;
	private CFBamSaxLoaderTZDateDefHandler tZDateDefHandler = null;
	private CFBamSaxLoaderTZDateTypeHandler tZDateTypeHandler = null;
	private CFBamSaxLoaderTZTimeColHandler tZTimeColHandler = null;
	private CFBamSaxLoaderTZTimeDefHandler tZTimeDefHandler = null;
	private CFBamSaxLoaderTZTimeTypeHandler tZTimeTypeHandler = null;
	private CFBamSaxLoaderTZTimestampColHandler tZTimestampColHandler = null;
	private CFBamSaxLoaderTZTimestampDefHandler tZTimestampDefHandler = null;
	private CFBamSaxLoaderTZTimestampTypeHandler tZTimestampTypeHandler = null;
	private CFBamSaxLoaderTableHandler tableHandler = null;
	private CFBamSaxLoaderTableColHandler tableColHandler = null;
	private CFBamSaxLoaderTenantHandler tenantHandler = null;
	private CFBamSaxLoaderTextColHandler textColHandler = null;
	private CFBamSaxLoaderTextDefHandler textDefHandler = null;
	private CFBamSaxLoaderTextTypeHandler textTypeHandler = null;
	private CFBamSaxLoaderTimeColHandler timeColHandler = null;
	private CFBamSaxLoaderTimeDefHandler timeDefHandler = null;
	private CFBamSaxLoaderTimeTypeHandler timeTypeHandler = null;
	private CFBamSaxLoaderTimestampColHandler timestampColHandler = null;
	private CFBamSaxLoaderTimestampDefHandler timestampDefHandler = null;
	private CFBamSaxLoaderTimestampTypeHandler timestampTypeHandler = null;
	private CFBamSaxLoaderTldHandler tldHandler = null;
	private CFBamSaxLoaderTokenColHandler tokenColHandler = null;
	private CFBamSaxLoaderTokenDefHandler tokenDefHandler = null;
	private CFBamSaxLoaderTokenTypeHandler tokenTypeHandler = null;
	private CFBamSaxLoaderTopDomainHandler topDomainHandler = null;
	private CFBamSaxLoaderTopProjectHandler topProjectHandler = null;
	private CFBamSaxLoaderUInt16ColHandler uInt16ColHandler = null;
	private CFBamSaxLoaderUInt16DefHandler uInt16DefHandler = null;
	private CFBamSaxLoaderUInt16TypeHandler uInt16TypeHandler = null;
	private CFBamSaxLoaderUInt32ColHandler uInt32ColHandler = null;
	private CFBamSaxLoaderUInt32DefHandler uInt32DefHandler = null;
	private CFBamSaxLoaderUInt32TypeHandler uInt32TypeHandler = null;
	private CFBamSaxLoaderUInt64ColHandler uInt64ColHandler = null;
	private CFBamSaxLoaderUInt64DefHandler uInt64DefHandler = null;
	private CFBamSaxLoaderUInt64TypeHandler uInt64TypeHandler = null;
	private CFBamSaxLoaderURLProtocolHandler uRLProtocolHandler = null;
	private CFBamSaxLoaderUuidColHandler uuidColHandler = null;
	private CFBamSaxLoaderUuidDefHandler uuidDefHandler = null;
	private CFBamSaxLoaderUuidGenHandler uuidGenHandler = null;
	private CFBamSaxLoaderUuidTypeHandler uuidTypeHandler = null;
	private CFBamSaxLoaderValueHandler valueHandler = null;
	private CFBamSaxLoaderVersionHandler versionHandler = null;
	private CFBamSaxRootHandler saxRootHandler = null;

	private CFBamSaxDocHandler saxDocHandler = null;

	// Schema object accessors

	// SchemaObj accessors

	public ICFBamSchemaObj getSchemaObj() {
		return( schemaObj );
	}

	public void setSchemaObj( ICFBamSchemaObj value ) {
		schemaObj = value;
	}

	// Element Handler Resolver Factories

	protected CFBamSaxLoaderAccessFrequencyHandler getAccessFrequencyHandler() {
		if( accessFrequencyHandler == null ) {
			accessFrequencyHandler = new CFBamSaxLoaderAccessFrequencyHandler( this );
		}
		return( accessFrequencyHandler );
	}

	protected CFBamSaxLoaderAccessSecurityHandler getAccessSecurityHandler() {
		if( accessSecurityHandler == null ) {
			accessSecurityHandler = new CFBamSaxLoaderAccessSecurityHandler( this );
		}
		return( accessSecurityHandler );
	}

	protected CFBamSaxLoaderAtomHandler getAtomHandler() {
		if( atomHandler == null ) {
			atomHandler = new CFBamSaxLoaderAtomHandler( this );
		}
		return( atomHandler );
	}

	protected CFBamSaxLoaderAuditActionHandler getAuditActionHandler() {
		if( auditActionHandler == null ) {
			auditActionHandler = new CFBamSaxLoaderAuditActionHandler( this );
		}
		return( auditActionHandler );
	}

	protected CFBamSaxLoaderBlobColHandler getBlobColHandler() {
		if( blobColHandler == null ) {
			blobColHandler = new CFBamSaxLoaderBlobColHandler( this );
		}
		return( blobColHandler );
	}

	protected CFBamSaxLoaderBlobDefHandler getBlobDefHandler() {
		if( blobDefHandler == null ) {
			blobDefHandler = new CFBamSaxLoaderBlobDefHandler( this );
		}
		return( blobDefHandler );
	}

	protected CFBamSaxLoaderBlobTypeHandler getBlobTypeHandler() {
		if( blobTypeHandler == null ) {
			blobTypeHandler = new CFBamSaxLoaderBlobTypeHandler( this );
		}
		return( blobTypeHandler );
	}

	protected CFBamSaxLoaderBoolColHandler getBoolColHandler() {
		if( boolColHandler == null ) {
			boolColHandler = new CFBamSaxLoaderBoolColHandler( this );
		}
		return( boolColHandler );
	}

	protected CFBamSaxLoaderBoolDefHandler getBoolDefHandler() {
		if( boolDefHandler == null ) {
			boolDefHandler = new CFBamSaxLoaderBoolDefHandler( this );
		}
		return( boolDefHandler );
	}

	protected CFBamSaxLoaderBoolTypeHandler getBoolTypeHandler() {
		if( boolTypeHandler == null ) {
			boolTypeHandler = new CFBamSaxLoaderBoolTypeHandler( this );
		}
		return( boolTypeHandler );
	}

	protected CFBamSaxLoaderChainHandler getChainHandler() {
		if( chainHandler == null ) {
			chainHandler = new CFBamSaxLoaderChainHandler( this );
		}
		return( chainHandler );
	}

	protected CFBamSaxLoaderClearDepHandler getClearDepHandler() {
		if( clearDepHandler == null ) {
			clearDepHandler = new CFBamSaxLoaderClearDepHandler( this );
		}
		return( clearDepHandler );
	}

	protected CFBamSaxLoaderClearSubDep1Handler getClearSubDep1Handler() {
		if( clearSubDep1Handler == null ) {
			clearSubDep1Handler = new CFBamSaxLoaderClearSubDep1Handler( this );
			clearSubDep1Handler.addElementHandler( "ClearSubDep2", getClearSubDep2Handler() );
		}
		return( clearSubDep1Handler );
	}

	protected CFBamSaxLoaderClearSubDep2Handler getClearSubDep2Handler() {
		if( clearSubDep2Handler == null ) {
			clearSubDep2Handler = new CFBamSaxLoaderClearSubDep2Handler( this );
			clearSubDep2Handler.addElementHandler( "ClearSubDep3", getClearSubDep3Handler() );
		}
		return( clearSubDep2Handler );
	}

	protected CFBamSaxLoaderClearSubDep3Handler getClearSubDep3Handler() {
		if( clearSubDep3Handler == null ) {
			clearSubDep3Handler = new CFBamSaxLoaderClearSubDep3Handler( this );
		}
		return( clearSubDep3Handler );
	}

	protected CFBamSaxLoaderClearTopDepHandler getClearTopDepHandler() {
		if( clearTopDepHandler == null ) {
			clearTopDepHandler = new CFBamSaxLoaderClearTopDepHandler( this );
			clearTopDepHandler.addElementHandler( "ClearSubDep1", getClearSubDep1Handler() );
		}
		return( clearTopDepHandler );
	}

	protected CFBamSaxLoaderClusterHandler getClusterHandler() {
		if( clusterHandler == null ) {
			clusterHandler = new CFBamSaxLoaderClusterHandler( this );
			clusterHandler.addElementHandler( "HostNode", getHostNodeHandler() );
			clusterHandler.addElementHandler( "Tenant", getTenantHandler() );
			clusterHandler.addElementHandler( "SecApp", getSecAppHandler() );
			clusterHandler.addElementHandler( "SecGroup", getSecGroupHandler() );
			clusterHandler.addElementHandler( "SysCluster", getSysClusterHandler() );
		}
		return( clusterHandler );
	}

	protected CFBamSaxLoaderDataScopeHandler getDataScopeHandler() {
		if( dataScopeHandler == null ) {
			dataScopeHandler = new CFBamSaxLoaderDataScopeHandler( this );
		}
		return( dataScopeHandler );
	}

	protected CFBamSaxLoaderDateColHandler getDateColHandler() {
		if( dateColHandler == null ) {
			dateColHandler = new CFBamSaxLoaderDateColHandler( this );
		}
		return( dateColHandler );
	}

	protected CFBamSaxLoaderDateDefHandler getDateDefHandler() {
		if( dateDefHandler == null ) {
			dateDefHandler = new CFBamSaxLoaderDateDefHandler( this );
		}
		return( dateDefHandler );
	}

	protected CFBamSaxLoaderDateTypeHandler getDateTypeHandler() {
		if( dateTypeHandler == null ) {
			dateTypeHandler = new CFBamSaxLoaderDateTypeHandler( this );
		}
		return( dateTypeHandler );
	}

	protected CFBamSaxLoaderDelDepHandler getDelDepHandler() {
		if( delDepHandler == null ) {
			delDepHandler = new CFBamSaxLoaderDelDepHandler( this );
		}
		return( delDepHandler );
	}

	protected CFBamSaxLoaderDelSubDep1Handler getDelSubDep1Handler() {
		if( delSubDep1Handler == null ) {
			delSubDep1Handler = new CFBamSaxLoaderDelSubDep1Handler( this );
			delSubDep1Handler.addElementHandler( "DelSubDep2", getDelSubDep2Handler() );
		}
		return( delSubDep1Handler );
	}

	protected CFBamSaxLoaderDelSubDep2Handler getDelSubDep2Handler() {
		if( delSubDep2Handler == null ) {
			delSubDep2Handler = new CFBamSaxLoaderDelSubDep2Handler( this );
			delSubDep2Handler.addElementHandler( "DelSubDep3", getDelSubDep3Handler() );
		}
		return( delSubDep2Handler );
	}

	protected CFBamSaxLoaderDelSubDep3Handler getDelSubDep3Handler() {
		if( delSubDep3Handler == null ) {
			delSubDep3Handler = new CFBamSaxLoaderDelSubDep3Handler( this );
		}
		return( delSubDep3Handler );
	}

	protected CFBamSaxLoaderDelTopDepHandler getDelTopDepHandler() {
		if( delTopDepHandler == null ) {
			delTopDepHandler = new CFBamSaxLoaderDelTopDepHandler( this );
			delTopDepHandler.addElementHandler( "DelSubDep1", getDelSubDep1Handler() );
		}
		return( delTopDepHandler );
	}

	protected CFBamSaxLoaderDomainHandler getDomainHandler() {
		if( domainHandler == null ) {
			domainHandler = new CFBamSaxLoaderDomainHandler( this );
			domainHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
			domainHandler.addElementHandler( "License", getLicenseHandler() );
			domainHandler.addElementHandler( "TopProject", getTopProjectHandler() );
		}
		return( domainHandler );
	}

	protected CFBamSaxLoaderDomainBaseHandler getDomainBaseHandler() {
		if( domainBaseHandler == null ) {
			domainBaseHandler = new CFBamSaxLoaderDomainBaseHandler( this );
			domainBaseHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
			domainBaseHandler.addElementHandler( "License", getLicenseHandler() );
		}
		return( domainBaseHandler );
	}

	protected CFBamSaxLoaderDoubleColHandler getDoubleColHandler() {
		if( doubleColHandler == null ) {
			doubleColHandler = new CFBamSaxLoaderDoubleColHandler( this );
		}
		return( doubleColHandler );
	}

	protected CFBamSaxLoaderDoubleDefHandler getDoubleDefHandler() {
		if( doubleDefHandler == null ) {
			doubleDefHandler = new CFBamSaxLoaderDoubleDefHandler( this );
		}
		return( doubleDefHandler );
	}

	protected CFBamSaxLoaderDoubleTypeHandler getDoubleTypeHandler() {
		if( doubleTypeHandler == null ) {
			doubleTypeHandler = new CFBamSaxLoaderDoubleTypeHandler( this );
		}
		return( doubleTypeHandler );
	}

	protected CFBamSaxLoaderEnumColHandler getEnumColHandler() {
		if( enumColHandler == null ) {
			enumColHandler = new CFBamSaxLoaderEnumColHandler( this );
			enumColHandler.addElementHandler( "EnumTag", getEnumTagHandler() );
		}
		return( enumColHandler );
	}

	protected CFBamSaxLoaderEnumDefHandler getEnumDefHandler() {
		if( enumDefHandler == null ) {
			enumDefHandler = new CFBamSaxLoaderEnumDefHandler( this );
			enumDefHandler.addElementHandler( "EnumTag", getEnumTagHandler() );
		}
		return( enumDefHandler );
	}

	protected CFBamSaxLoaderEnumTagHandler getEnumTagHandler() {
		if( enumTagHandler == null ) {
			enumTagHandler = new CFBamSaxLoaderEnumTagHandler( this );
		}
		return( enumTagHandler );
	}

	protected CFBamSaxLoaderEnumTypeHandler getEnumTypeHandler() {
		if( enumTypeHandler == null ) {
			enumTypeHandler = new CFBamSaxLoaderEnumTypeHandler( this );
			enumTypeHandler.addElementHandler( "EnumTag", getEnumTagHandler() );
		}
		return( enumTypeHandler );
	}

	protected CFBamSaxLoaderFloatColHandler getFloatColHandler() {
		if( floatColHandler == null ) {
			floatColHandler = new CFBamSaxLoaderFloatColHandler( this );
		}
		return( floatColHandler );
	}

	protected CFBamSaxLoaderFloatDefHandler getFloatDefHandler() {
		if( floatDefHandler == null ) {
			floatDefHandler = new CFBamSaxLoaderFloatDefHandler( this );
		}
		return( floatDefHandler );
	}

	protected CFBamSaxLoaderFloatTypeHandler getFloatTypeHandler() {
		if( floatTypeHandler == null ) {
			floatTypeHandler = new CFBamSaxLoaderFloatTypeHandler( this );
		}
		return( floatTypeHandler );
	}

	protected CFBamSaxLoaderHostNodeHandler getHostNodeHandler() {
		if( hostNodeHandler == null ) {
			hostNodeHandler = new CFBamSaxLoaderHostNodeHandler( this );
			hostNodeHandler.addElementHandler( "Service", getServiceHandler() );
		}
		return( hostNodeHandler );
	}

	protected CFBamSaxLoaderISOCountryHandler getISOCountryHandler() {
		if( iSOCountryHandler == null ) {
			iSOCountryHandler = new CFBamSaxLoaderISOCountryHandler( this );
			iSOCountryHandler.addElementHandler( "ISOCountryCurrency", getISOCountryCurrencyHandler() );
			iSOCountryHandler.addElementHandler( "ISOCountryLanguage", getISOCountryLanguageHandler() );
		}
		return( iSOCountryHandler );
	}

	protected CFBamSaxLoaderISOCountryCurrencyHandler getISOCountryCurrencyHandler() {
		if( iSOCountryCurrencyHandler == null ) {
			iSOCountryCurrencyHandler = new CFBamSaxLoaderISOCountryCurrencyHandler( this );
		}
		return( iSOCountryCurrencyHandler );
	}

	protected CFBamSaxLoaderISOCountryLanguageHandler getISOCountryLanguageHandler() {
		if( iSOCountryLanguageHandler == null ) {
			iSOCountryLanguageHandler = new CFBamSaxLoaderISOCountryLanguageHandler( this );
		}
		return( iSOCountryLanguageHandler );
	}

	protected CFBamSaxLoaderISOCurrencyHandler getISOCurrencyHandler() {
		if( iSOCurrencyHandler == null ) {
			iSOCurrencyHandler = new CFBamSaxLoaderISOCurrencyHandler( this );
		}
		return( iSOCurrencyHandler );
	}

	protected CFBamSaxLoaderISOLanguageHandler getISOLanguageHandler() {
		if( iSOLanguageHandler == null ) {
			iSOLanguageHandler = new CFBamSaxLoaderISOLanguageHandler( this );
		}
		return( iSOLanguageHandler );
	}

	protected CFBamSaxLoaderISOTimezoneHandler getISOTimezoneHandler() {
		if( iSOTimezoneHandler == null ) {
			iSOTimezoneHandler = new CFBamSaxLoaderISOTimezoneHandler( this );
		}
		return( iSOTimezoneHandler );
	}

	protected CFBamSaxLoaderId16GenHandler getId16GenHandler() {
		if( id16GenHandler == null ) {
			id16GenHandler = new CFBamSaxLoaderId16GenHandler( this );
		}
		return( id16GenHandler );
	}

	protected CFBamSaxLoaderId32GenHandler getId32GenHandler() {
		if( id32GenHandler == null ) {
			id32GenHandler = new CFBamSaxLoaderId32GenHandler( this );
		}
		return( id32GenHandler );
	}

	protected CFBamSaxLoaderId64GenHandler getId64GenHandler() {
		if( id64GenHandler == null ) {
			id64GenHandler = new CFBamSaxLoaderId64GenHandler( this );
		}
		return( id64GenHandler );
	}

	protected CFBamSaxLoaderIndexHandler getIndexHandler() {
		if( indexHandler == null ) {
			indexHandler = new CFBamSaxLoaderIndexHandler( this );
			indexHandler.addElementHandler( "IndexCol", getIndexColHandler() );
		}
		return( indexHandler );
	}

	protected CFBamSaxLoaderIndexColHandler getIndexColHandler() {
		if( indexColHandler == null ) {
			indexColHandler = new CFBamSaxLoaderIndexColHandler( this );
		}
		return( indexColHandler );
	}

	protected CFBamSaxLoaderInt16ColHandler getInt16ColHandler() {
		if( int16ColHandler == null ) {
			int16ColHandler = new CFBamSaxLoaderInt16ColHandler( this );
		}
		return( int16ColHandler );
	}

	protected CFBamSaxLoaderInt16DefHandler getInt16DefHandler() {
		if( int16DefHandler == null ) {
			int16DefHandler = new CFBamSaxLoaderInt16DefHandler( this );
		}
		return( int16DefHandler );
	}

	protected CFBamSaxLoaderInt16TypeHandler getInt16TypeHandler() {
		if( int16TypeHandler == null ) {
			int16TypeHandler = new CFBamSaxLoaderInt16TypeHandler( this );
		}
		return( int16TypeHandler );
	}

	protected CFBamSaxLoaderInt32ColHandler getInt32ColHandler() {
		if( int32ColHandler == null ) {
			int32ColHandler = new CFBamSaxLoaderInt32ColHandler( this );
		}
		return( int32ColHandler );
	}

	protected CFBamSaxLoaderInt32DefHandler getInt32DefHandler() {
		if( int32DefHandler == null ) {
			int32DefHandler = new CFBamSaxLoaderInt32DefHandler( this );
		}
		return( int32DefHandler );
	}

	protected CFBamSaxLoaderInt32TypeHandler getInt32TypeHandler() {
		if( int32TypeHandler == null ) {
			int32TypeHandler = new CFBamSaxLoaderInt32TypeHandler( this );
		}
		return( int32TypeHandler );
	}

	protected CFBamSaxLoaderInt64ColHandler getInt64ColHandler() {
		if( int64ColHandler == null ) {
			int64ColHandler = new CFBamSaxLoaderInt64ColHandler( this );
		}
		return( int64ColHandler );
	}

	protected CFBamSaxLoaderInt64DefHandler getInt64DefHandler() {
		if( int64DefHandler == null ) {
			int64DefHandler = new CFBamSaxLoaderInt64DefHandler( this );
		}
		return( int64DefHandler );
	}

	protected CFBamSaxLoaderInt64TypeHandler getInt64TypeHandler() {
		if( int64TypeHandler == null ) {
			int64TypeHandler = new CFBamSaxLoaderInt64TypeHandler( this );
		}
		return( int64TypeHandler );
	}

	protected CFBamSaxLoaderLicenseHandler getLicenseHandler() {
		if( licenseHandler == null ) {
			licenseHandler = new CFBamSaxLoaderLicenseHandler( this );
		}
		return( licenseHandler );
	}

	protected CFBamSaxLoaderLoaderBehaviourHandler getLoaderBehaviourHandler() {
		if( loaderBehaviourHandler == null ) {
			loaderBehaviourHandler = new CFBamSaxLoaderLoaderBehaviourHandler( this );
		}
		return( loaderBehaviourHandler );
	}

	protected CFBamSaxLoaderMajorVersionHandler getMajorVersionHandler() {
		if( majorVersionHandler == null ) {
			majorVersionHandler = new CFBamSaxLoaderMajorVersionHandler( this );
			majorVersionHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
			majorVersionHandler.addElementHandler( "License", getLicenseHandler() );
			majorVersionHandler.addElementHandler( "MinorVersion", getMinorVersionHandler() );
		}
		return( majorVersionHandler );
	}

	protected CFBamSaxLoaderMimeTypeHandler getMimeTypeHandler() {
		if( mimeTypeHandler == null ) {
			mimeTypeHandler = new CFBamSaxLoaderMimeTypeHandler( this );
		}
		return( mimeTypeHandler );
	}

	protected CFBamSaxLoaderMinorVersionHandler getMinorVersionHandler() {
		if( minorVersionHandler == null ) {
			minorVersionHandler = new CFBamSaxLoaderMinorVersionHandler( this );
			minorVersionHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
			minorVersionHandler.addElementHandler( "License", getLicenseHandler() );
		}
		return( minorVersionHandler );
	}

	protected CFBamSaxLoaderNmTokenColHandler getNmTokenColHandler() {
		if( nmTokenColHandler == null ) {
			nmTokenColHandler = new CFBamSaxLoaderNmTokenColHandler( this );
		}
		return( nmTokenColHandler );
	}

	protected CFBamSaxLoaderNmTokenDefHandler getNmTokenDefHandler() {
		if( nmTokenDefHandler == null ) {
			nmTokenDefHandler = new CFBamSaxLoaderNmTokenDefHandler( this );
		}
		return( nmTokenDefHandler );
	}

	protected CFBamSaxLoaderNmTokenTypeHandler getNmTokenTypeHandler() {
		if( nmTokenTypeHandler == null ) {
			nmTokenTypeHandler = new CFBamSaxLoaderNmTokenTypeHandler( this );
		}
		return( nmTokenTypeHandler );
	}

	protected CFBamSaxLoaderNmTokensColHandler getNmTokensColHandler() {
		if( nmTokensColHandler == null ) {
			nmTokensColHandler = new CFBamSaxLoaderNmTokensColHandler( this );
		}
		return( nmTokensColHandler );
	}

	protected CFBamSaxLoaderNmTokensDefHandler getNmTokensDefHandler() {
		if( nmTokensDefHandler == null ) {
			nmTokensDefHandler = new CFBamSaxLoaderNmTokensDefHandler( this );
		}
		return( nmTokensDefHandler );
	}

	protected CFBamSaxLoaderNmTokensTypeHandler getNmTokensTypeHandler() {
		if( nmTokensTypeHandler == null ) {
			nmTokensTypeHandler = new CFBamSaxLoaderNmTokensTypeHandler( this );
		}
		return( nmTokensTypeHandler );
	}

	protected CFBamSaxLoaderNumberColHandler getNumberColHandler() {
		if( numberColHandler == null ) {
			numberColHandler = new CFBamSaxLoaderNumberColHandler( this );
		}
		return( numberColHandler );
	}

	protected CFBamSaxLoaderNumberDefHandler getNumberDefHandler() {
		if( numberDefHandler == null ) {
			numberDefHandler = new CFBamSaxLoaderNumberDefHandler( this );
		}
		return( numberDefHandler );
	}

	protected CFBamSaxLoaderNumberTypeHandler getNumberTypeHandler() {
		if( numberTypeHandler == null ) {
			numberTypeHandler = new CFBamSaxLoaderNumberTypeHandler( this );
		}
		return( numberTypeHandler );
	}

	protected CFBamSaxLoaderParamHandler getParamHandler() {
		if( paramHandler == null ) {
			paramHandler = new CFBamSaxLoaderParamHandler( this );
		}
		return( paramHandler );
	}

	protected CFBamSaxLoaderPopDepHandler getPopDepHandler() {
		if( popDepHandler == null ) {
			popDepHandler = new CFBamSaxLoaderPopDepHandler( this );
		}
		return( popDepHandler );
	}

	protected CFBamSaxLoaderPopSubDep1Handler getPopSubDep1Handler() {
		if( popSubDep1Handler == null ) {
			popSubDep1Handler = new CFBamSaxLoaderPopSubDep1Handler( this );
			popSubDep1Handler.addElementHandler( "PopSubDep2", getPopSubDep2Handler() );
		}
		return( popSubDep1Handler );
	}

	protected CFBamSaxLoaderPopSubDep2Handler getPopSubDep2Handler() {
		if( popSubDep2Handler == null ) {
			popSubDep2Handler = new CFBamSaxLoaderPopSubDep2Handler( this );
			popSubDep2Handler.addElementHandler( "PopSubDep3", getPopSubDep3Handler() );
		}
		return( popSubDep2Handler );
	}

	protected CFBamSaxLoaderPopSubDep3Handler getPopSubDep3Handler() {
		if( popSubDep3Handler == null ) {
			popSubDep3Handler = new CFBamSaxLoaderPopSubDep3Handler( this );
		}
		return( popSubDep3Handler );
	}

	protected CFBamSaxLoaderPopTopDepHandler getPopTopDepHandler() {
		if( popTopDepHandler == null ) {
			popTopDepHandler = new CFBamSaxLoaderPopTopDepHandler( this );
			popTopDepHandler.addElementHandler( "PopSubDep1", getPopSubDep1Handler() );
		}
		return( popTopDepHandler );
	}

	protected CFBamSaxLoaderProjectBaseHandler getProjectBaseHandler() {
		if( projectBaseHandler == null ) {
			projectBaseHandler = new CFBamSaxLoaderProjectBaseHandler( this );
			projectBaseHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
			projectBaseHandler.addElementHandler( "License", getLicenseHandler() );
		}
		return( projectBaseHandler );
	}

	protected CFBamSaxLoaderRealProjectHandler getRealProjectHandler() {
		if( realProjectHandler == null ) {
			realProjectHandler = new CFBamSaxLoaderRealProjectHandler( this );
			realProjectHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
			realProjectHandler.addElementHandler( "License", getLicenseHandler() );
			realProjectHandler.addElementHandler( "MajorVersion", getMajorVersionHandler() );
		}
		return( realProjectHandler );
	}

	protected CFBamSaxLoaderRelationHandler getRelationHandler() {
		if( relationHandler == null ) {
			relationHandler = new CFBamSaxLoaderRelationHandler( this );
			relationHandler.addElementHandler( "RelationCol", getRelationColHandler() );
			relationHandler.addElementHandler( "PopTopDep", getPopTopDepHandler() );
		}
		return( relationHandler );
	}

	protected CFBamSaxLoaderRelationColHandler getRelationColHandler() {
		if( relationColHandler == null ) {
			relationColHandler = new CFBamSaxLoaderRelationColHandler( this );
		}
		return( relationColHandler );
	}

	protected CFBamSaxLoaderRelationTypeHandler getRelationTypeHandler() {
		if( relationTypeHandler == null ) {
			relationTypeHandler = new CFBamSaxLoaderRelationTypeHandler( this );
		}
		return( relationTypeHandler );
	}

	protected CFBamSaxLoaderSchemaDefHandler getSchemaDefHandler() {
		if( schemaDefHandler == null ) {
			schemaDefHandler = new CFBamSaxLoaderSchemaDefHandler( this );
			schemaDefHandler.addElementHandler( "Table", getTableHandler() );
			schemaDefHandler.addElementHandler( "BlobType", getBlobTypeHandler() );
			schemaDefHandler.addElementHandler( "BoolType", getBoolTypeHandler() );
			schemaDefHandler.addElementHandler( "Int16Type", getInt16TypeHandler() );
			schemaDefHandler.addElementHandler( "Id16Gen", getId16GenHandler() );
			schemaDefHandler.addElementHandler( "EnumType", getEnumTypeHandler() );
			schemaDefHandler.addElementHandler( "Int32Type", getInt32TypeHandler() );
			schemaDefHandler.addElementHandler( "Id32Gen", getId32GenHandler() );
			schemaDefHandler.addElementHandler( "Int64Type", getInt64TypeHandler() );
			schemaDefHandler.addElementHandler( "Id64Gen", getId64GenHandler() );
			schemaDefHandler.addElementHandler( "UInt16Type", getUInt16TypeHandler() );
			schemaDefHandler.addElementHandler( "UInt32Type", getUInt32TypeHandler() );
			schemaDefHandler.addElementHandler( "UInt64Type", getUInt64TypeHandler() );
			schemaDefHandler.addElementHandler( "FloatType", getFloatTypeHandler() );
			schemaDefHandler.addElementHandler( "DoubleType", getDoubleTypeHandler() );
			schemaDefHandler.addElementHandler( "NumberType", getNumberTypeHandler() );
			schemaDefHandler.addElementHandler( "StringType", getStringTypeHandler() );
			schemaDefHandler.addElementHandler( "TextType", getTextTypeHandler() );
			schemaDefHandler.addElementHandler( "NmTokenType", getNmTokenTypeHandler() );
			schemaDefHandler.addElementHandler( "NmTokensType", getNmTokensTypeHandler() );
			schemaDefHandler.addElementHandler( "TokenType", getTokenTypeHandler() );
			schemaDefHandler.addElementHandler( "DateType", getDateTypeHandler() );
			schemaDefHandler.addElementHandler( "TimeType", getTimeTypeHandler() );
			schemaDefHandler.addElementHandler( "TimestampType", getTimestampTypeHandler() );
			schemaDefHandler.addElementHandler( "TZDateType", getTZDateTypeHandler() );
			schemaDefHandler.addElementHandler( "TZTimeType", getTZTimeTypeHandler() );
			schemaDefHandler.addElementHandler( "TZTimestampType", getTZTimestampTypeHandler() );
			schemaDefHandler.addElementHandler( "UuidType", getUuidTypeHandler() );
			schemaDefHandler.addElementHandler( "UuidGen", getUuidGenHandler() );
			schemaDefHandler.addElementHandler( "SchemaRef", getSchemaRefHandler() );
		}
		return( schemaDefHandler );
	}

	protected CFBamSaxLoaderSchemaRefHandler getSchemaRefHandler() {
		if( schemaRefHandler == null ) {
			schemaRefHandler = new CFBamSaxLoaderSchemaRefHandler( this );
		}
		return( schemaRefHandler );
	}

	protected CFBamSaxLoaderScopeHandler getScopeHandler() {
		if( scopeHandler == null ) {
			scopeHandler = new CFBamSaxLoaderScopeHandler( this );
		}
		return( scopeHandler );
	}

	protected CFBamSaxLoaderSecAppHandler getSecAppHandler() {
		if( secAppHandler == null ) {
			secAppHandler = new CFBamSaxLoaderSecAppHandler( this );
			secAppHandler.addElementHandler( "SecForm", getSecFormHandler() );
		}
		return( secAppHandler );
	}

	protected CFBamSaxLoaderSecDeviceHandler getSecDeviceHandler() {
		if( secDeviceHandler == null ) {
			secDeviceHandler = new CFBamSaxLoaderSecDeviceHandler( this );
		}
		return( secDeviceHandler );
	}

	protected CFBamSaxLoaderSecFormHandler getSecFormHandler() {
		if( secFormHandler == null ) {
			secFormHandler = new CFBamSaxLoaderSecFormHandler( this );
		}
		return( secFormHandler );
	}

	protected CFBamSaxLoaderSecGroupHandler getSecGroupHandler() {
		if( secGroupHandler == null ) {
			secGroupHandler = new CFBamSaxLoaderSecGroupHandler( this );
			secGroupHandler.addElementHandler( "SecGroupInclude", getSecGroupIncludeHandler() );
			secGroupHandler.addElementHandler( "SecGroupMember", getSecGroupMemberHandler() );
			secGroupHandler.addElementHandler( "SecGroupForm", getSecGroupFormHandler() );
		}
		return( secGroupHandler );
	}

	protected CFBamSaxLoaderSecGroupFormHandler getSecGroupFormHandler() {
		if( secGroupFormHandler == null ) {
			secGroupFormHandler = new CFBamSaxLoaderSecGroupFormHandler( this );
		}
		return( secGroupFormHandler );
	}

	protected CFBamSaxLoaderSecGroupIncludeHandler getSecGroupIncludeHandler() {
		if( secGroupIncludeHandler == null ) {
			secGroupIncludeHandler = new CFBamSaxLoaderSecGroupIncludeHandler( this );
		}
		return( secGroupIncludeHandler );
	}

	protected CFBamSaxLoaderSecGroupMemberHandler getSecGroupMemberHandler() {
		if( secGroupMemberHandler == null ) {
			secGroupMemberHandler = new CFBamSaxLoaderSecGroupMemberHandler( this );
		}
		return( secGroupMemberHandler );
	}

	protected CFBamSaxLoaderSecSessionHandler getSecSessionHandler() {
		if( secSessionHandler == null ) {
			secSessionHandler = new CFBamSaxLoaderSecSessionHandler( this );
		}
		return( secSessionHandler );
	}

	protected CFBamSaxLoaderSecUserHandler getSecUserHandler() {
		if( secUserHandler == null ) {
			secUserHandler = new CFBamSaxLoaderSecUserHandler( this );
			secUserHandler.addElementHandler( "SecDevice", getSecDeviceHandler() );
			secUserHandler.addElementHandler( "SecSession", getSecSessionHandler() );
		}
		return( secUserHandler );
	}

	protected CFBamSaxLoaderSecurityScopeHandler getSecurityScopeHandler() {
		if( securityScopeHandler == null ) {
			securityScopeHandler = new CFBamSaxLoaderSecurityScopeHandler( this );
		}
		return( securityScopeHandler );
	}

	protected CFBamSaxLoaderServerListFuncHandler getServerListFuncHandler() {
		if( serverListFuncHandler == null ) {
			serverListFuncHandler = new CFBamSaxLoaderServerListFuncHandler( this );
			serverListFuncHandler.addElementHandler( "Param", getParamHandler() );
		}
		return( serverListFuncHandler );
	}

	protected CFBamSaxLoaderServerMethodHandler getServerMethodHandler() {
		if( serverMethodHandler == null ) {
			serverMethodHandler = new CFBamSaxLoaderServerMethodHandler( this );
			serverMethodHandler.addElementHandler( "Param", getParamHandler() );
		}
		return( serverMethodHandler );
	}

	protected CFBamSaxLoaderServerObjFuncHandler getServerObjFuncHandler() {
		if( serverObjFuncHandler == null ) {
			serverObjFuncHandler = new CFBamSaxLoaderServerObjFuncHandler( this );
			serverObjFuncHandler.addElementHandler( "Param", getParamHandler() );
		}
		return( serverObjFuncHandler );
	}

	protected CFBamSaxLoaderServerProcHandler getServerProcHandler() {
		if( serverProcHandler == null ) {
			serverProcHandler = new CFBamSaxLoaderServerProcHandler( this );
			serverProcHandler.addElementHandler( "Param", getParamHandler() );
		}
		return( serverProcHandler );
	}

	protected CFBamSaxLoaderServiceHandler getServiceHandler() {
		if( serviceHandler == null ) {
			serviceHandler = new CFBamSaxLoaderServiceHandler( this );
		}
		return( serviceHandler );
	}

	protected CFBamSaxLoaderServiceTypeHandler getServiceTypeHandler() {
		if( serviceTypeHandler == null ) {
			serviceTypeHandler = new CFBamSaxLoaderServiceTypeHandler( this );
		}
		return( serviceTypeHandler );
	}

	protected CFBamSaxLoaderStringColHandler getStringColHandler() {
		if( stringColHandler == null ) {
			stringColHandler = new CFBamSaxLoaderStringColHandler( this );
		}
		return( stringColHandler );
	}

	protected CFBamSaxLoaderStringDefHandler getStringDefHandler() {
		if( stringDefHandler == null ) {
			stringDefHandler = new CFBamSaxLoaderStringDefHandler( this );
		}
		return( stringDefHandler );
	}

	protected CFBamSaxLoaderStringTypeHandler getStringTypeHandler() {
		if( stringTypeHandler == null ) {
			stringTypeHandler = new CFBamSaxLoaderStringTypeHandler( this );
		}
		return( stringTypeHandler );
	}

	protected CFBamSaxLoaderSubProjectHandler getSubProjectHandler() {
		if( subProjectHandler == null ) {
			subProjectHandler = new CFBamSaxLoaderSubProjectHandler( this );
			subProjectHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
			subProjectHandler.addElementHandler( "License", getLicenseHandler() );
			subProjectHandler.addElementHandler( "MajorVersion", getMajorVersionHandler() );
		}
		return( subProjectHandler );
	}

	protected CFBamSaxLoaderSysClusterHandler getSysClusterHandler() {
		if( sysClusterHandler == null ) {
			sysClusterHandler = new CFBamSaxLoaderSysClusterHandler( this );
		}
		return( sysClusterHandler );
	}

	protected CFBamSaxLoaderTSecGroupHandler getTSecGroupHandler() {
		if( tSecGroupHandler == null ) {
			tSecGroupHandler = new CFBamSaxLoaderTSecGroupHandler( this );
			tSecGroupHandler.addElementHandler( "TSecGroupInclude", getTSecGroupIncludeHandler() );
			tSecGroupHandler.addElementHandler( "TSecGroupMember", getTSecGroupMemberHandler() );
		}
		return( tSecGroupHandler );
	}

	protected CFBamSaxLoaderTSecGroupIncludeHandler getTSecGroupIncludeHandler() {
		if( tSecGroupIncludeHandler == null ) {
			tSecGroupIncludeHandler = new CFBamSaxLoaderTSecGroupIncludeHandler( this );
		}
		return( tSecGroupIncludeHandler );
	}

	protected CFBamSaxLoaderTSecGroupMemberHandler getTSecGroupMemberHandler() {
		if( tSecGroupMemberHandler == null ) {
			tSecGroupMemberHandler = new CFBamSaxLoaderTSecGroupMemberHandler( this );
		}
		return( tSecGroupMemberHandler );
	}

	protected CFBamSaxLoaderTZDateColHandler getTZDateColHandler() {
		if( tZDateColHandler == null ) {
			tZDateColHandler = new CFBamSaxLoaderTZDateColHandler( this );
		}
		return( tZDateColHandler );
	}

	protected CFBamSaxLoaderTZDateDefHandler getTZDateDefHandler() {
		if( tZDateDefHandler == null ) {
			tZDateDefHandler = new CFBamSaxLoaderTZDateDefHandler( this );
		}
		return( tZDateDefHandler );
	}

	protected CFBamSaxLoaderTZDateTypeHandler getTZDateTypeHandler() {
		if( tZDateTypeHandler == null ) {
			tZDateTypeHandler = new CFBamSaxLoaderTZDateTypeHandler( this );
		}
		return( tZDateTypeHandler );
	}

	protected CFBamSaxLoaderTZTimeColHandler getTZTimeColHandler() {
		if( tZTimeColHandler == null ) {
			tZTimeColHandler = new CFBamSaxLoaderTZTimeColHandler( this );
		}
		return( tZTimeColHandler );
	}

	protected CFBamSaxLoaderTZTimeDefHandler getTZTimeDefHandler() {
		if( tZTimeDefHandler == null ) {
			tZTimeDefHandler = new CFBamSaxLoaderTZTimeDefHandler( this );
		}
		return( tZTimeDefHandler );
	}

	protected CFBamSaxLoaderTZTimeTypeHandler getTZTimeTypeHandler() {
		if( tZTimeTypeHandler == null ) {
			tZTimeTypeHandler = new CFBamSaxLoaderTZTimeTypeHandler( this );
		}
		return( tZTimeTypeHandler );
	}

	protected CFBamSaxLoaderTZTimestampColHandler getTZTimestampColHandler() {
		if( tZTimestampColHandler == null ) {
			tZTimestampColHandler = new CFBamSaxLoaderTZTimestampColHandler( this );
		}
		return( tZTimestampColHandler );
	}

	protected CFBamSaxLoaderTZTimestampDefHandler getTZTimestampDefHandler() {
		if( tZTimestampDefHandler == null ) {
			tZTimestampDefHandler = new CFBamSaxLoaderTZTimestampDefHandler( this );
		}
		return( tZTimestampDefHandler );
	}

	protected CFBamSaxLoaderTZTimestampTypeHandler getTZTimestampTypeHandler() {
		if( tZTimestampTypeHandler == null ) {
			tZTimestampTypeHandler = new CFBamSaxLoaderTZTimestampTypeHandler( this );
		}
		return( tZTimestampTypeHandler );
	}

	protected CFBamSaxLoaderTableHandler getTableHandler() {
		if( tableHandler == null ) {
			tableHandler = new CFBamSaxLoaderTableHandler( this );
			tableHandler.addElementHandler( "Relation", getRelationHandler() );
			tableHandler.addElementHandler( "Index", getIndexHandler() );
			tableHandler.addElementHandler( "TableCol", getTableColHandler() );
			tableHandler.addElementHandler( "BlobCol", getBlobColHandler() );
			tableHandler.addElementHandler( "BoolCol", getBoolColHandler() );
			tableHandler.addElementHandler( "Int16Col", getInt16ColHandler() );
			tableHandler.addElementHandler( "EnumCol", getEnumColHandler() );
			tableHandler.addElementHandler( "Int32Col", getInt32ColHandler() );
			tableHandler.addElementHandler( "Int64Col", getInt64ColHandler() );
			tableHandler.addElementHandler( "UInt16Col", getUInt16ColHandler() );
			tableHandler.addElementHandler( "UInt32Col", getUInt32ColHandler() );
			tableHandler.addElementHandler( "UInt64Col", getUInt64ColHandler() );
			tableHandler.addElementHandler( "FloatCol", getFloatColHandler() );
			tableHandler.addElementHandler( "DoubleCol", getDoubleColHandler() );
			tableHandler.addElementHandler( "NumberCol", getNumberColHandler() );
			tableHandler.addElementHandler( "StringCol", getStringColHandler() );
			tableHandler.addElementHandler( "TextCol", getTextColHandler() );
			tableHandler.addElementHandler( "NmTokenCol", getNmTokenColHandler() );
			tableHandler.addElementHandler( "NmTokensCol", getNmTokensColHandler() );
			tableHandler.addElementHandler( "TokenCol", getTokenColHandler() );
			tableHandler.addElementHandler( "DateCol", getDateColHandler() );
			tableHandler.addElementHandler( "TimeCol", getTimeColHandler() );
			tableHandler.addElementHandler( "TimestampCol", getTimestampColHandler() );
			tableHandler.addElementHandler( "TZDateCol", getTZDateColHandler() );
			tableHandler.addElementHandler( "TZTimeCol", getTZTimeColHandler() );
			tableHandler.addElementHandler( "TZTimestampCol", getTZTimestampColHandler() );
			tableHandler.addElementHandler( "UuidCol", getUuidColHandler() );
			tableHandler.addElementHandler( "Chain", getChainHandler() );
			tableHandler.addElementHandler( "DelTopDep", getDelTopDepHandler() );
			tableHandler.addElementHandler( "ClearTopDep", getClearTopDepHandler() );
			tableHandler.addElementHandler( "ServerMethod", getServerMethodHandler() );
			tableHandler.addElementHandler( "ServerProc", getServerProcHandler() );
			tableHandler.addElementHandler( "ServerObjFunc", getServerObjFuncHandler() );
			tableHandler.addElementHandler( "ServerListFunc", getServerListFuncHandler() );
		}
		return( tableHandler );
	}

	protected CFBamSaxLoaderTableColHandler getTableColHandler() {
		if( tableColHandler == null ) {
			tableColHandler = new CFBamSaxLoaderTableColHandler( this );
		}
		return( tableColHandler );
	}

	protected CFBamSaxLoaderTenantHandler getTenantHandler() {
		if( tenantHandler == null ) {
			tenantHandler = new CFBamSaxLoaderTenantHandler( this );
			tenantHandler.addElementHandler( "TSecGroup", getTSecGroupHandler() );
			tenantHandler.addElementHandler( "Tld", getTldHandler() );
		}
		return( tenantHandler );
	}

	protected CFBamSaxLoaderTextColHandler getTextColHandler() {
		if( textColHandler == null ) {
			textColHandler = new CFBamSaxLoaderTextColHandler( this );
		}
		return( textColHandler );
	}

	protected CFBamSaxLoaderTextDefHandler getTextDefHandler() {
		if( textDefHandler == null ) {
			textDefHandler = new CFBamSaxLoaderTextDefHandler( this );
		}
		return( textDefHandler );
	}

	protected CFBamSaxLoaderTextTypeHandler getTextTypeHandler() {
		if( textTypeHandler == null ) {
			textTypeHandler = new CFBamSaxLoaderTextTypeHandler( this );
		}
		return( textTypeHandler );
	}

	protected CFBamSaxLoaderTimeColHandler getTimeColHandler() {
		if( timeColHandler == null ) {
			timeColHandler = new CFBamSaxLoaderTimeColHandler( this );
		}
		return( timeColHandler );
	}

	protected CFBamSaxLoaderTimeDefHandler getTimeDefHandler() {
		if( timeDefHandler == null ) {
			timeDefHandler = new CFBamSaxLoaderTimeDefHandler( this );
		}
		return( timeDefHandler );
	}

	protected CFBamSaxLoaderTimeTypeHandler getTimeTypeHandler() {
		if( timeTypeHandler == null ) {
			timeTypeHandler = new CFBamSaxLoaderTimeTypeHandler( this );
		}
		return( timeTypeHandler );
	}

	protected CFBamSaxLoaderTimestampColHandler getTimestampColHandler() {
		if( timestampColHandler == null ) {
			timestampColHandler = new CFBamSaxLoaderTimestampColHandler( this );
		}
		return( timestampColHandler );
	}

	protected CFBamSaxLoaderTimestampDefHandler getTimestampDefHandler() {
		if( timestampDefHandler == null ) {
			timestampDefHandler = new CFBamSaxLoaderTimestampDefHandler( this );
		}
		return( timestampDefHandler );
	}

	protected CFBamSaxLoaderTimestampTypeHandler getTimestampTypeHandler() {
		if( timestampTypeHandler == null ) {
			timestampTypeHandler = new CFBamSaxLoaderTimestampTypeHandler( this );
		}
		return( timestampTypeHandler );
	}

	protected CFBamSaxLoaderTldHandler getTldHandler() {
		if( tldHandler == null ) {
			tldHandler = new CFBamSaxLoaderTldHandler( this );
			tldHandler.addElementHandler( "TopDomain", getTopDomainHandler() );
		}
		return( tldHandler );
	}

	protected CFBamSaxLoaderTokenColHandler getTokenColHandler() {
		if( tokenColHandler == null ) {
			tokenColHandler = new CFBamSaxLoaderTokenColHandler( this );
		}
		return( tokenColHandler );
	}

	protected CFBamSaxLoaderTokenDefHandler getTokenDefHandler() {
		if( tokenDefHandler == null ) {
			tokenDefHandler = new CFBamSaxLoaderTokenDefHandler( this );
		}
		return( tokenDefHandler );
	}

	protected CFBamSaxLoaderTokenTypeHandler getTokenTypeHandler() {
		if( tokenTypeHandler == null ) {
			tokenTypeHandler = new CFBamSaxLoaderTokenTypeHandler( this );
		}
		return( tokenTypeHandler );
	}

	protected CFBamSaxLoaderTopDomainHandler getTopDomainHandler() {
		if( topDomainHandler == null ) {
			topDomainHandler = new CFBamSaxLoaderTopDomainHandler( this );
			topDomainHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
			topDomainHandler.addElementHandler( "License", getLicenseHandler() );
			topDomainHandler.addElementHandler( "Domain", getDomainHandler() );
			topDomainHandler.addElementHandler( "TopProject", getTopProjectHandler() );
		}
		return( topDomainHandler );
	}

	protected CFBamSaxLoaderTopProjectHandler getTopProjectHandler() {
		if( topProjectHandler == null ) {
			topProjectHandler = new CFBamSaxLoaderTopProjectHandler( this );
			topProjectHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
			topProjectHandler.addElementHandler( "License", getLicenseHandler() );
			topProjectHandler.addElementHandler( "MajorVersion", getMajorVersionHandler() );
			topProjectHandler.addElementHandler( "SubProject", getSubProjectHandler() );
		}
		return( topProjectHandler );
	}

	protected CFBamSaxLoaderUInt16ColHandler getUInt16ColHandler() {
		if( uInt16ColHandler == null ) {
			uInt16ColHandler = new CFBamSaxLoaderUInt16ColHandler( this );
		}
		return( uInt16ColHandler );
	}

	protected CFBamSaxLoaderUInt16DefHandler getUInt16DefHandler() {
		if( uInt16DefHandler == null ) {
			uInt16DefHandler = new CFBamSaxLoaderUInt16DefHandler( this );
		}
		return( uInt16DefHandler );
	}

	protected CFBamSaxLoaderUInt16TypeHandler getUInt16TypeHandler() {
		if( uInt16TypeHandler == null ) {
			uInt16TypeHandler = new CFBamSaxLoaderUInt16TypeHandler( this );
		}
		return( uInt16TypeHandler );
	}

	protected CFBamSaxLoaderUInt32ColHandler getUInt32ColHandler() {
		if( uInt32ColHandler == null ) {
			uInt32ColHandler = new CFBamSaxLoaderUInt32ColHandler( this );
		}
		return( uInt32ColHandler );
	}

	protected CFBamSaxLoaderUInt32DefHandler getUInt32DefHandler() {
		if( uInt32DefHandler == null ) {
			uInt32DefHandler = new CFBamSaxLoaderUInt32DefHandler( this );
		}
		return( uInt32DefHandler );
	}

	protected CFBamSaxLoaderUInt32TypeHandler getUInt32TypeHandler() {
		if( uInt32TypeHandler == null ) {
			uInt32TypeHandler = new CFBamSaxLoaderUInt32TypeHandler( this );
		}
		return( uInt32TypeHandler );
	}

	protected CFBamSaxLoaderUInt64ColHandler getUInt64ColHandler() {
		if( uInt64ColHandler == null ) {
			uInt64ColHandler = new CFBamSaxLoaderUInt64ColHandler( this );
		}
		return( uInt64ColHandler );
	}

	protected CFBamSaxLoaderUInt64DefHandler getUInt64DefHandler() {
		if( uInt64DefHandler == null ) {
			uInt64DefHandler = new CFBamSaxLoaderUInt64DefHandler( this );
		}
		return( uInt64DefHandler );
	}

	protected CFBamSaxLoaderUInt64TypeHandler getUInt64TypeHandler() {
		if( uInt64TypeHandler == null ) {
			uInt64TypeHandler = new CFBamSaxLoaderUInt64TypeHandler( this );
		}
		return( uInt64TypeHandler );
	}

	protected CFBamSaxLoaderURLProtocolHandler getURLProtocolHandler() {
		if( uRLProtocolHandler == null ) {
			uRLProtocolHandler = new CFBamSaxLoaderURLProtocolHandler( this );
		}
		return( uRLProtocolHandler );
	}

	protected CFBamSaxLoaderUuidColHandler getUuidColHandler() {
		if( uuidColHandler == null ) {
			uuidColHandler = new CFBamSaxLoaderUuidColHandler( this );
		}
		return( uuidColHandler );
	}

	protected CFBamSaxLoaderUuidDefHandler getUuidDefHandler() {
		if( uuidDefHandler == null ) {
			uuidDefHandler = new CFBamSaxLoaderUuidDefHandler( this );
		}
		return( uuidDefHandler );
	}

	protected CFBamSaxLoaderUuidGenHandler getUuidGenHandler() {
		if( uuidGenHandler == null ) {
			uuidGenHandler = new CFBamSaxLoaderUuidGenHandler( this );
		}
		return( uuidGenHandler );
	}

	protected CFBamSaxLoaderUuidTypeHandler getUuidTypeHandler() {
		if( uuidTypeHandler == null ) {
			uuidTypeHandler = new CFBamSaxLoaderUuidTypeHandler( this );
		}
		return( uuidTypeHandler );
	}

	protected CFBamSaxLoaderValueHandler getValueHandler() {
		if( valueHandler == null ) {
			valueHandler = new CFBamSaxLoaderValueHandler( this );
		}
		return( valueHandler );
	}

	protected CFBamSaxLoaderVersionHandler getVersionHandler() {
		if( versionHandler == null ) {
			versionHandler = new CFBamSaxLoaderVersionHandler( this );
			versionHandler.addElementHandler( "SchemaDef", getSchemaDefHandler() );
			versionHandler.addElementHandler( "License", getLicenseHandler() );
		}
		return( versionHandler );
	}

	// Root Element Handler Resolver Factory

	protected CFBamSaxRootHandler getSaxRootHandler() {
		if( saxRootHandler == null ) {
			saxRootHandler = new CFBamSaxRootHandler( this );
			saxRootHandler.addElementHandler( "CFBam", getSaxDocHandler() );
			saxRootHandler.addElementHandler( "CFSecurity", getSaxDocHandler() );
			saxRootHandler.addElementHandler( "CFInternet", getSaxDocHandler() );
		}
		return( saxRootHandler );
	}

	// Root Element Handler

	/*
	 *	CFBamSaxRootHandler XML SAX Root Element Handler implementation
	 */
	public class CFBamSaxRootHandler
		extends CFLibXmlCoreElementHandler
	{
		public CFBamSaxRootHandler( CFBamSaxLoader saxLoader ) {
			super( saxLoader );
		}

		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
		}

		public void endElement(
			String		uri,
			String		localName,
			String		qName )
		throws SAXException
		{
		}
	}

	// Document Element Handler Resolver Factory

	protected CFBamSaxDocHandler getSaxDocHandler() {
		if( saxDocHandler == null ) {
			saxDocHandler = new CFBamSaxDocHandler( this );
			saxDocHandler.addElementHandler( "AccessFrequency", getAccessFrequencyHandler() );
			saxDocHandler.addElementHandler( "AccessSecurity", getAccessSecurityHandler() );
			saxDocHandler.addElementHandler( "AuditAction", getAuditActionHandler() );
			saxDocHandler.addElementHandler( "Cluster", getClusterHandler() );
			saxDocHandler.addElementHandler( "DataScope", getDataScopeHandler() );
			saxDocHandler.addElementHandler( "ISOCountry", getISOCountryHandler() );
			saxDocHandler.addElementHandler( "ISOCurrency", getISOCurrencyHandler() );
			saxDocHandler.addElementHandler( "ISOLanguage", getISOLanguageHandler() );
			saxDocHandler.addElementHandler( "ISOTimezone", getISOTimezoneHandler() );
			saxDocHandler.addElementHandler( "LoaderBehaviour", getLoaderBehaviourHandler() );
			saxDocHandler.addElementHandler( "MimeType", getMimeTypeHandler() );
			saxDocHandler.addElementHandler( "RelationType", getRelationTypeHandler() );
			saxDocHandler.addElementHandler( "SecUser", getSecUserHandler() );
			saxDocHandler.addElementHandler( "SecurityScope", getSecurityScopeHandler() );
			saxDocHandler.addElementHandler( "ServiceType", getServiceTypeHandler() );
			saxDocHandler.addElementHandler( "URLProtocol", getURLProtocolHandler() );
		}
		return( saxDocHandler );
	}

	// Document Element Handler

	/*
	 *	CFBamSaxDocHandler XML SAX Doc Element Handler implementation
	 */
	public class CFBamSaxDocHandler
		extends CFLibXmlCoreElementHandler
	{
		public CFBamSaxDocHandler( CFBamSaxLoader saxLoader ) {
			super( saxLoader );
		}

		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
		}

		public void endElement(
			String		uri,
			String		localName,
			String		qName )
		throws SAXException
		{
		}
	}

	// Loader behaviour configuration accessors

	public LoaderBehaviourEnum getAccessFrequencyLoaderBehaviour() {
		return( accessFrequencyLoaderBehaviour );
	}
	
	public void setAccessFrequencyLoaderBehaviour( LoaderBehaviourEnum value ) {
		accessFrequencyLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getAccessSecurityLoaderBehaviour() {
		return( accessSecurityLoaderBehaviour );
	}
	
	public void setAccessSecurityLoaderBehaviour( LoaderBehaviourEnum value ) {
		accessSecurityLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getAtomLoaderBehaviour() {
		return( atomLoaderBehaviour );
	}
	
	public void setAtomLoaderBehaviour( LoaderBehaviourEnum value ) {
		atomLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getAuditActionLoaderBehaviour() {
		return( auditActionLoaderBehaviour );
	}
	
	public void setAuditActionLoaderBehaviour( LoaderBehaviourEnum value ) {
		auditActionLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBlobColLoaderBehaviour() {
		return( blobColLoaderBehaviour );
	}
	
	public void setBlobColLoaderBehaviour( LoaderBehaviourEnum value ) {
		blobColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBlobDefLoaderBehaviour() {
		return( blobDefLoaderBehaviour );
	}
	
	public void setBlobDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		blobDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBlobTypeLoaderBehaviour() {
		return( blobTypeLoaderBehaviour );
	}
	
	public void setBlobTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		blobTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBoolColLoaderBehaviour() {
		return( boolColLoaderBehaviour );
	}
	
	public void setBoolColLoaderBehaviour( LoaderBehaviourEnum value ) {
		boolColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBoolDefLoaderBehaviour() {
		return( boolDefLoaderBehaviour );
	}
	
	public void setBoolDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		boolDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getBoolTypeLoaderBehaviour() {
		return( boolTypeLoaderBehaviour );
	}
	
	public void setBoolTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		boolTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getChainLoaderBehaviour() {
		return( chainLoaderBehaviour );
	}
	
	public void setChainLoaderBehaviour( LoaderBehaviourEnum value ) {
		chainLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClearDepLoaderBehaviour() {
		return( clearDepLoaderBehaviour );
	}
	
	public void setClearDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		clearDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClearSubDep1LoaderBehaviour() {
		return( clearSubDep1LoaderBehaviour );
	}
	
	public void setClearSubDep1LoaderBehaviour( LoaderBehaviourEnum value ) {
		clearSubDep1LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClearSubDep2LoaderBehaviour() {
		return( clearSubDep2LoaderBehaviour );
	}
	
	public void setClearSubDep2LoaderBehaviour( LoaderBehaviourEnum value ) {
		clearSubDep2LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClearSubDep3LoaderBehaviour() {
		return( clearSubDep3LoaderBehaviour );
	}
	
	public void setClearSubDep3LoaderBehaviour( LoaderBehaviourEnum value ) {
		clearSubDep3LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClearTopDepLoaderBehaviour() {
		return( clearTopDepLoaderBehaviour );
	}
	
	public void setClearTopDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		clearTopDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getClusterLoaderBehaviour() {
		return( clusterLoaderBehaviour );
	}
	
	public void setClusterLoaderBehaviour( LoaderBehaviourEnum value ) {
		clusterLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDataScopeLoaderBehaviour() {
		return( dataScopeLoaderBehaviour );
	}
	
	public void setDataScopeLoaderBehaviour( LoaderBehaviourEnum value ) {
		dataScopeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDateColLoaderBehaviour() {
		return( dateColLoaderBehaviour );
	}
	
	public void setDateColLoaderBehaviour( LoaderBehaviourEnum value ) {
		dateColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDateDefLoaderBehaviour() {
		return( dateDefLoaderBehaviour );
	}
	
	public void setDateDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		dateDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDateTypeLoaderBehaviour() {
		return( dateTypeLoaderBehaviour );
	}
	
	public void setDateTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		dateTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDelDepLoaderBehaviour() {
		return( delDepLoaderBehaviour );
	}
	
	public void setDelDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		delDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDelSubDep1LoaderBehaviour() {
		return( delSubDep1LoaderBehaviour );
	}
	
	public void setDelSubDep1LoaderBehaviour( LoaderBehaviourEnum value ) {
		delSubDep1LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDelSubDep2LoaderBehaviour() {
		return( delSubDep2LoaderBehaviour );
	}
	
	public void setDelSubDep2LoaderBehaviour( LoaderBehaviourEnum value ) {
		delSubDep2LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDelSubDep3LoaderBehaviour() {
		return( delSubDep3LoaderBehaviour );
	}
	
	public void setDelSubDep3LoaderBehaviour( LoaderBehaviourEnum value ) {
		delSubDep3LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDelTopDepLoaderBehaviour() {
		return( delTopDepLoaderBehaviour );
	}
	
	public void setDelTopDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		delTopDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDomainLoaderBehaviour() {
		return( domainLoaderBehaviour );
	}
	
	public void setDomainLoaderBehaviour( LoaderBehaviourEnum value ) {
		domainLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDomainBaseLoaderBehaviour() {
		return( domainBaseLoaderBehaviour );
	}
	
	public void setDomainBaseLoaderBehaviour( LoaderBehaviourEnum value ) {
		domainBaseLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDoubleColLoaderBehaviour() {
		return( doubleColLoaderBehaviour );
	}
	
	public void setDoubleColLoaderBehaviour( LoaderBehaviourEnum value ) {
		doubleColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDoubleDefLoaderBehaviour() {
		return( doubleDefLoaderBehaviour );
	}
	
	public void setDoubleDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		doubleDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getDoubleTypeLoaderBehaviour() {
		return( doubleTypeLoaderBehaviour );
	}
	
	public void setDoubleTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		doubleTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getEnumColLoaderBehaviour() {
		return( enumColLoaderBehaviour );
	}
	
	public void setEnumColLoaderBehaviour( LoaderBehaviourEnum value ) {
		enumColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getEnumDefLoaderBehaviour() {
		return( enumDefLoaderBehaviour );
	}
	
	public void setEnumDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		enumDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getEnumTagLoaderBehaviour() {
		return( enumTagLoaderBehaviour );
	}
	
	public void setEnumTagLoaderBehaviour( LoaderBehaviourEnum value ) {
		enumTagLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getEnumTypeLoaderBehaviour() {
		return( enumTypeLoaderBehaviour );
	}
	
	public void setEnumTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		enumTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getFloatColLoaderBehaviour() {
		return( floatColLoaderBehaviour );
	}
	
	public void setFloatColLoaderBehaviour( LoaderBehaviourEnum value ) {
		floatColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getFloatDefLoaderBehaviour() {
		return( floatDefLoaderBehaviour );
	}
	
	public void setFloatDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		floatDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getFloatTypeLoaderBehaviour() {
		return( floatTypeLoaderBehaviour );
	}
	
	public void setFloatTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		floatTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getHostNodeLoaderBehaviour() {
		return( hostNodeLoaderBehaviour );
	}
	
	public void setHostNodeLoaderBehaviour( LoaderBehaviourEnum value ) {
		hostNodeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCountryLoaderBehaviour() {
		return( iSOCountryLoaderBehaviour );
	}
	
	public void setISOCountryLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCountryLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCountryCurrencyLoaderBehaviour() {
		return( iSOCountryCurrencyLoaderBehaviour );
	}
	
	public void setISOCountryCurrencyLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCountryCurrencyLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCountryLanguageLoaderBehaviour() {
		return( iSOCountryLanguageLoaderBehaviour );
	}
	
	public void setISOCountryLanguageLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCountryLanguageLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCurrencyLoaderBehaviour() {
		return( iSOCurrencyLoaderBehaviour );
	}
	
	public void setISOCurrencyLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCurrencyLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOLanguageLoaderBehaviour() {
		return( iSOLanguageLoaderBehaviour );
	}
	
	public void setISOLanguageLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOLanguageLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOTimezoneLoaderBehaviour() {
		return( iSOTimezoneLoaderBehaviour );
	}
	
	public void setISOTimezoneLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOTimezoneLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getId16GenLoaderBehaviour() {
		return( id16GenLoaderBehaviour );
	}
	
	public void setId16GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		id16GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getId32GenLoaderBehaviour() {
		return( id32GenLoaderBehaviour );
	}
	
	public void setId32GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		id32GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getId64GenLoaderBehaviour() {
		return( id64GenLoaderBehaviour );
	}
	
	public void setId64GenLoaderBehaviour( LoaderBehaviourEnum value ) {
		id64GenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getIndexLoaderBehaviour() {
		return( indexLoaderBehaviour );
	}
	
	public void setIndexLoaderBehaviour( LoaderBehaviourEnum value ) {
		indexLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getIndexColLoaderBehaviour() {
		return( indexColLoaderBehaviour );
	}
	
	public void setIndexColLoaderBehaviour( LoaderBehaviourEnum value ) {
		indexColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt16ColLoaderBehaviour() {
		return( int16ColLoaderBehaviour );
	}
	
	public void setInt16ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		int16ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt16DefLoaderBehaviour() {
		return( int16DefLoaderBehaviour );
	}
	
	public void setInt16DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		int16DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt16TypeLoaderBehaviour() {
		return( int16TypeLoaderBehaviour );
	}
	
	public void setInt16TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		int16TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt32ColLoaderBehaviour() {
		return( int32ColLoaderBehaviour );
	}
	
	public void setInt32ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		int32ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt32DefLoaderBehaviour() {
		return( int32DefLoaderBehaviour );
	}
	
	public void setInt32DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		int32DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt32TypeLoaderBehaviour() {
		return( int32TypeLoaderBehaviour );
	}
	
	public void setInt32TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		int32TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt64ColLoaderBehaviour() {
		return( int64ColLoaderBehaviour );
	}
	
	public void setInt64ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		int64ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt64DefLoaderBehaviour() {
		return( int64DefLoaderBehaviour );
	}
	
	public void setInt64DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		int64DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getInt64TypeLoaderBehaviour() {
		return( int64TypeLoaderBehaviour );
	}
	
	public void setInt64TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		int64TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getLicenseLoaderBehaviour() {
		return( licenseLoaderBehaviour );
	}
	
	public void setLicenseLoaderBehaviour( LoaderBehaviourEnum value ) {
		licenseLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getLoaderBehaviourLoaderBehaviour() {
		return( loaderBehaviourLoaderBehaviour );
	}
	
	public void setLoaderBehaviourLoaderBehaviour( LoaderBehaviourEnum value ) {
		loaderBehaviourLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getMajorVersionLoaderBehaviour() {
		return( majorVersionLoaderBehaviour );
	}
	
	public void setMajorVersionLoaderBehaviour( LoaderBehaviourEnum value ) {
		majorVersionLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getMimeTypeLoaderBehaviour() {
		return( mimeTypeLoaderBehaviour );
	}
	
	public void setMimeTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		mimeTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getMinorVersionLoaderBehaviour() {
		return( minorVersionLoaderBehaviour );
	}
	
	public void setMinorVersionLoaderBehaviour( LoaderBehaviourEnum value ) {
		minorVersionLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokenColLoaderBehaviour() {
		return( nmTokenColLoaderBehaviour );
	}
	
	public void setNmTokenColLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokenColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokenDefLoaderBehaviour() {
		return( nmTokenDefLoaderBehaviour );
	}
	
	public void setNmTokenDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokenDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokenTypeLoaderBehaviour() {
		return( nmTokenTypeLoaderBehaviour );
	}
	
	public void setNmTokenTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokenTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokensColLoaderBehaviour() {
		return( nmTokensColLoaderBehaviour );
	}
	
	public void setNmTokensColLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokensColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokensDefLoaderBehaviour() {
		return( nmTokensDefLoaderBehaviour );
	}
	
	public void setNmTokensDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokensDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNmTokensTypeLoaderBehaviour() {
		return( nmTokensTypeLoaderBehaviour );
	}
	
	public void setNmTokensTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		nmTokensTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNumberColLoaderBehaviour() {
		return( numberColLoaderBehaviour );
	}
	
	public void setNumberColLoaderBehaviour( LoaderBehaviourEnum value ) {
		numberColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNumberDefLoaderBehaviour() {
		return( numberDefLoaderBehaviour );
	}
	
	public void setNumberDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		numberDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getNumberTypeLoaderBehaviour() {
		return( numberTypeLoaderBehaviour );
	}
	
	public void setNumberTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		numberTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getParamLoaderBehaviour() {
		return( paramLoaderBehaviour );
	}
	
	public void setParamLoaderBehaviour( LoaderBehaviourEnum value ) {
		paramLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getPopDepLoaderBehaviour() {
		return( popDepLoaderBehaviour );
	}
	
	public void setPopDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		popDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getPopSubDep1LoaderBehaviour() {
		return( popSubDep1LoaderBehaviour );
	}
	
	public void setPopSubDep1LoaderBehaviour( LoaderBehaviourEnum value ) {
		popSubDep1LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getPopSubDep2LoaderBehaviour() {
		return( popSubDep2LoaderBehaviour );
	}
	
	public void setPopSubDep2LoaderBehaviour( LoaderBehaviourEnum value ) {
		popSubDep2LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getPopSubDep3LoaderBehaviour() {
		return( popSubDep3LoaderBehaviour );
	}
	
	public void setPopSubDep3LoaderBehaviour( LoaderBehaviourEnum value ) {
		popSubDep3LoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getPopTopDepLoaderBehaviour() {
		return( popTopDepLoaderBehaviour );
	}
	
	public void setPopTopDepLoaderBehaviour( LoaderBehaviourEnum value ) {
		popTopDepLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getProjectBaseLoaderBehaviour() {
		return( projectBaseLoaderBehaviour );
	}
	
	public void setProjectBaseLoaderBehaviour( LoaderBehaviourEnum value ) {
		projectBaseLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getRealProjectLoaderBehaviour() {
		return( realProjectLoaderBehaviour );
	}
	
	public void setRealProjectLoaderBehaviour( LoaderBehaviourEnum value ) {
		realProjectLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getRelationLoaderBehaviour() {
		return( relationLoaderBehaviour );
	}
	
	public void setRelationLoaderBehaviour( LoaderBehaviourEnum value ) {
		relationLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getRelationColLoaderBehaviour() {
		return( relationColLoaderBehaviour );
	}
	
	public void setRelationColLoaderBehaviour( LoaderBehaviourEnum value ) {
		relationColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getRelationTypeLoaderBehaviour() {
		return( relationTypeLoaderBehaviour );
	}
	
	public void setRelationTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		relationTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSchemaDefLoaderBehaviour() {
		return( schemaDefLoaderBehaviour );
	}
	
	public void setSchemaDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		schemaDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSchemaRefLoaderBehaviour() {
		return( schemaRefLoaderBehaviour );
	}
	
	public void setSchemaRefLoaderBehaviour( LoaderBehaviourEnum value ) {
		schemaRefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getScopeLoaderBehaviour() {
		return( scopeLoaderBehaviour );
	}
	
	public void setScopeLoaderBehaviour( LoaderBehaviourEnum value ) {
		scopeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecAppLoaderBehaviour() {
		return( secAppLoaderBehaviour );
	}
	
	public void setSecAppLoaderBehaviour( LoaderBehaviourEnum value ) {
		secAppLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecDeviceLoaderBehaviour() {
		return( secDeviceLoaderBehaviour );
	}
	
	public void setSecDeviceLoaderBehaviour( LoaderBehaviourEnum value ) {
		secDeviceLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecFormLoaderBehaviour() {
		return( secFormLoaderBehaviour );
	}
	
	public void setSecFormLoaderBehaviour( LoaderBehaviourEnum value ) {
		secFormLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecGroupLoaderBehaviour() {
		return( secGroupLoaderBehaviour );
	}
	
	public void setSecGroupLoaderBehaviour( LoaderBehaviourEnum value ) {
		secGroupLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecGroupFormLoaderBehaviour() {
		return( secGroupFormLoaderBehaviour );
	}
	
	public void setSecGroupFormLoaderBehaviour( LoaderBehaviourEnum value ) {
		secGroupFormLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecGroupIncludeLoaderBehaviour() {
		return( secGroupIncludeLoaderBehaviour );
	}
	
	public void setSecGroupIncludeLoaderBehaviour( LoaderBehaviourEnum value ) {
		secGroupIncludeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecGroupMemberLoaderBehaviour() {
		return( secGroupMemberLoaderBehaviour );
	}
	
	public void setSecGroupMemberLoaderBehaviour( LoaderBehaviourEnum value ) {
		secGroupMemberLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSessionLoaderBehaviour() {
		return( secSessionLoaderBehaviour );
	}
	
	public void setSecSessionLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSessionLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserLoaderBehaviour() {
		return( secUserLoaderBehaviour );
	}
	
	public void setSecUserLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecurityScopeLoaderBehaviour() {
		return( securityScopeLoaderBehaviour );
	}
	
	public void setSecurityScopeLoaderBehaviour( LoaderBehaviourEnum value ) {
		securityScopeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getServerListFuncLoaderBehaviour() {
		return( serverListFuncLoaderBehaviour );
	}
	
	public void setServerListFuncLoaderBehaviour( LoaderBehaviourEnum value ) {
		serverListFuncLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getServerMethodLoaderBehaviour() {
		return( serverMethodLoaderBehaviour );
	}
	
	public void setServerMethodLoaderBehaviour( LoaderBehaviourEnum value ) {
		serverMethodLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getServerObjFuncLoaderBehaviour() {
		return( serverObjFuncLoaderBehaviour );
	}
	
	public void setServerObjFuncLoaderBehaviour( LoaderBehaviourEnum value ) {
		serverObjFuncLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getServerProcLoaderBehaviour() {
		return( serverProcLoaderBehaviour );
	}
	
	public void setServerProcLoaderBehaviour( LoaderBehaviourEnum value ) {
		serverProcLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getServiceLoaderBehaviour() {
		return( serviceLoaderBehaviour );
	}
	
	public void setServiceLoaderBehaviour( LoaderBehaviourEnum value ) {
		serviceLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getServiceTypeLoaderBehaviour() {
		return( serviceTypeLoaderBehaviour );
	}
	
	public void setServiceTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		serviceTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getStringColLoaderBehaviour() {
		return( stringColLoaderBehaviour );
	}
	
	public void setStringColLoaderBehaviour( LoaderBehaviourEnum value ) {
		stringColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getStringDefLoaderBehaviour() {
		return( stringDefLoaderBehaviour );
	}
	
	public void setStringDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		stringDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getStringTypeLoaderBehaviour() {
		return( stringTypeLoaderBehaviour );
	}
	
	public void setStringTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		stringTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSubProjectLoaderBehaviour() {
		return( subProjectLoaderBehaviour );
	}
	
	public void setSubProjectLoaderBehaviour( LoaderBehaviourEnum value ) {
		subProjectLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSysClusterLoaderBehaviour() {
		return( sysClusterLoaderBehaviour );
	}
	
	public void setSysClusterLoaderBehaviour( LoaderBehaviourEnum value ) {
		sysClusterLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTSecGroupLoaderBehaviour() {
		return( tSecGroupLoaderBehaviour );
	}
	
	public void setTSecGroupLoaderBehaviour( LoaderBehaviourEnum value ) {
		tSecGroupLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTSecGroupIncludeLoaderBehaviour() {
		return( tSecGroupIncludeLoaderBehaviour );
	}
	
	public void setTSecGroupIncludeLoaderBehaviour( LoaderBehaviourEnum value ) {
		tSecGroupIncludeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTSecGroupMemberLoaderBehaviour() {
		return( tSecGroupMemberLoaderBehaviour );
	}
	
	public void setTSecGroupMemberLoaderBehaviour( LoaderBehaviourEnum value ) {
		tSecGroupMemberLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZDateColLoaderBehaviour() {
		return( tZDateColLoaderBehaviour );
	}
	
	public void setTZDateColLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZDateColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZDateDefLoaderBehaviour() {
		return( tZDateDefLoaderBehaviour );
	}
	
	public void setTZDateDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZDateDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZDateTypeLoaderBehaviour() {
		return( tZDateTypeLoaderBehaviour );
	}
	
	public void setTZDateTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZDateTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimeColLoaderBehaviour() {
		return( tZTimeColLoaderBehaviour );
	}
	
	public void setTZTimeColLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimeColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimeDefLoaderBehaviour() {
		return( tZTimeDefLoaderBehaviour );
	}
	
	public void setTZTimeDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimeDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimeTypeLoaderBehaviour() {
		return( tZTimeTypeLoaderBehaviour );
	}
	
	public void setTZTimeTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimeTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimestampColLoaderBehaviour() {
		return( tZTimestampColLoaderBehaviour );
	}
	
	public void setTZTimestampColLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimestampColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimestampDefLoaderBehaviour() {
		return( tZTimestampDefLoaderBehaviour );
	}
	
	public void setTZTimestampDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimestampDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTZTimestampTypeLoaderBehaviour() {
		return( tZTimestampTypeLoaderBehaviour );
	}
	
	public void setTZTimestampTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		tZTimestampTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTableLoaderBehaviour() {
		return( tableLoaderBehaviour );
	}
	
	public void setTableLoaderBehaviour( LoaderBehaviourEnum value ) {
		tableLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTableColLoaderBehaviour() {
		return( tableColLoaderBehaviour );
	}
	
	public void setTableColLoaderBehaviour( LoaderBehaviourEnum value ) {
		tableColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTenantLoaderBehaviour() {
		return( tenantLoaderBehaviour );
	}
	
	public void setTenantLoaderBehaviour( LoaderBehaviourEnum value ) {
		tenantLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTextColLoaderBehaviour() {
		return( textColLoaderBehaviour );
	}
	
	public void setTextColLoaderBehaviour( LoaderBehaviourEnum value ) {
		textColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTextDefLoaderBehaviour() {
		return( textDefLoaderBehaviour );
	}
	
	public void setTextDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		textDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTextTypeLoaderBehaviour() {
		return( textTypeLoaderBehaviour );
	}
	
	public void setTextTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		textTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimeColLoaderBehaviour() {
		return( timeColLoaderBehaviour );
	}
	
	public void setTimeColLoaderBehaviour( LoaderBehaviourEnum value ) {
		timeColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimeDefLoaderBehaviour() {
		return( timeDefLoaderBehaviour );
	}
	
	public void setTimeDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		timeDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimeTypeLoaderBehaviour() {
		return( timeTypeLoaderBehaviour );
	}
	
	public void setTimeTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		timeTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimestampColLoaderBehaviour() {
		return( timestampColLoaderBehaviour );
	}
	
	public void setTimestampColLoaderBehaviour( LoaderBehaviourEnum value ) {
		timestampColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimestampDefLoaderBehaviour() {
		return( timestampDefLoaderBehaviour );
	}
	
	public void setTimestampDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		timestampDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTimestampTypeLoaderBehaviour() {
		return( timestampTypeLoaderBehaviour );
	}
	
	public void setTimestampTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		timestampTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTldLoaderBehaviour() {
		return( tldLoaderBehaviour );
	}
	
	public void setTldLoaderBehaviour( LoaderBehaviourEnum value ) {
		tldLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTokenColLoaderBehaviour() {
		return( tokenColLoaderBehaviour );
	}
	
	public void setTokenColLoaderBehaviour( LoaderBehaviourEnum value ) {
		tokenColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTokenDefLoaderBehaviour() {
		return( tokenDefLoaderBehaviour );
	}
	
	public void setTokenDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		tokenDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTokenTypeLoaderBehaviour() {
		return( tokenTypeLoaderBehaviour );
	}
	
	public void setTokenTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		tokenTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTopDomainLoaderBehaviour() {
		return( topDomainLoaderBehaviour );
	}
	
	public void setTopDomainLoaderBehaviour( LoaderBehaviourEnum value ) {
		topDomainLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTopProjectLoaderBehaviour() {
		return( topProjectLoaderBehaviour );
	}
	
	public void setTopProjectLoaderBehaviour( LoaderBehaviourEnum value ) {
		topProjectLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt16ColLoaderBehaviour() {
		return( uInt16ColLoaderBehaviour );
	}
	
	public void setUInt16ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt16ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt16DefLoaderBehaviour() {
		return( uInt16DefLoaderBehaviour );
	}
	
	public void setUInt16DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt16DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt16TypeLoaderBehaviour() {
		return( uInt16TypeLoaderBehaviour );
	}
	
	public void setUInt16TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt16TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt32ColLoaderBehaviour() {
		return( uInt32ColLoaderBehaviour );
	}
	
	public void setUInt32ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt32ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt32DefLoaderBehaviour() {
		return( uInt32DefLoaderBehaviour );
	}
	
	public void setUInt32DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt32DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt32TypeLoaderBehaviour() {
		return( uInt32TypeLoaderBehaviour );
	}
	
	public void setUInt32TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt32TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt64ColLoaderBehaviour() {
		return( uInt64ColLoaderBehaviour );
	}
	
	public void setUInt64ColLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt64ColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt64DefLoaderBehaviour() {
		return( uInt64DefLoaderBehaviour );
	}
	
	public void setUInt64DefLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt64DefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUInt64TypeLoaderBehaviour() {
		return( uInt64TypeLoaderBehaviour );
	}
	
	public void setUInt64TypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		uInt64TypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getURLProtocolLoaderBehaviour() {
		return( uRLProtocolLoaderBehaviour );
	}
	
	public void setURLProtocolLoaderBehaviour( LoaderBehaviourEnum value ) {
		uRLProtocolLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuidColLoaderBehaviour() {
		return( uuidColLoaderBehaviour );
	}
	
	public void setUuidColLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuidColLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuidDefLoaderBehaviour() {
		return( uuidDefLoaderBehaviour );
	}
	
	public void setUuidDefLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuidDefLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuidGenLoaderBehaviour() {
		return( uuidGenLoaderBehaviour );
	}
	
	public void setUuidGenLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuidGenLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getUuidTypeLoaderBehaviour() {
		return( uuidTypeLoaderBehaviour );
	}
	
	public void setUuidTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		uuidTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getValueLoaderBehaviour() {
		return( valueLoaderBehaviour );
	}
	
	public void setValueLoaderBehaviour( LoaderBehaviourEnum value ) {
		valueLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getVersionLoaderBehaviour() {
		return( versionLoaderBehaviour );
	}
	
	public void setVersionLoaderBehaviour( LoaderBehaviourEnum value ) {
		versionLoaderBehaviour = value;
	}

	// Parse a file

	public void parseFile( String url ) {
		parse( url );
	}
}
