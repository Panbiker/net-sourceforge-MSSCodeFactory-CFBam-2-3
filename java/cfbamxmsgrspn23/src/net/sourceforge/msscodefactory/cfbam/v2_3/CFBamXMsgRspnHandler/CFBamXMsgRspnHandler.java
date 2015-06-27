// Description: Java 7 XML SAX Request Message Handler for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgRspnHandler;

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
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Tip.*;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public class CFBamXMsgRspnHandler
	extends CFLibXmlCoreSaxParser
	implements ContentHandler,
		ICFTipResponseHandler
{

	// The namespace URI of the supported schema
	public final static String	SCHEMA_XMLNS = "uri://xsd/cfbamrspn";

	// The source for loading the supported schema
	public final static String	SCHEMA_URI = "xsd/cfbam-23-rspn.xsd";
	public final static String	SCHEMA_ROOT_URI = "/xsd/cfbam-23-rspn.xsd";
	public final static String CFSECURITY_XMLNS = "uri://xsd/cfsecurityrspn";
	public final static String CFSECURITY_URI = "xsd/cfsecurity-23-rspn.xsd";
	public final static String CFSECURITY_ROOT_URI = "xsd/cfsecurity-23-rspn.xsd";

	public final static String CFINTERNET_XMLNS = "uri://xsd/cfinternetrspn";
	public final static String CFINTERNET_URI = "xsd/cfinternet-23-rspn.xsd";
	public final static String CFINTERNET_ROOT_URI = "xsd/cfinternet-23-rspn.xsd";


	// The schema instance to load in to

	private ICFBamSchemaObj schemaObj = null;
	private boolean deleted = false;
	private CFLibRuntimeException exceptionRaised = null;
	private Object lastObjectProcessed = null;
	private Object sortedListOfObjects = null;
	private String logContents = null;
	private boolean dataChanged = false;
	// Constructors

	public CFBamXMsgRspnHandler() {
		super();
		setRootElementHandler( getSaxRspnRootHandler() );
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
		setSchemaObj( null );
	}

	public CFBamXMsgRspnHandler( CFBamSchemaObj schemaObj ) {
		super();
		setRootElementHandler( getSaxRspnRootHandler() );
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
		setSchemaObj( schemaObj );
	}

	public CFBamXMsgRspnHandler( ICFLibMessageLog logger ) {
		super( logger );
		setRootElementHandler( getSaxRspnRootHandler() );
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
		setSchemaObj( null );
	}

	public CFBamXMsgRspnHandler( CFBamSchemaObj schemaObj, ICFLibMessageLog logger ) {
		super( logger );
		setRootElementHandler( getSaxRspnRootHandler() );
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
		setSchemaObj( schemaObj );
	}

	// Element Handler instances

	private CFBamXMsgRspnNoDataFoundHandler rspnNoDataFoundHandler = null;
	private CFBamXMsgRspnExceptionHandler rspnExceptionHandler = null;
	private CFBamXMsgRspnFileLoadedHandler rspnFileLoadedHandler = null;
	private CFBamXMsgRspnLoggedInHandler rspnLoggedInHandler = null;
	private CFBamXMsgRspnLoggedOutHandler rspnLoggedOutHandler = null;
	private CFBamXMsgRspnServerProcExecutedHandler rspnServerProcExecutedHandler = null;

	// AccessFrequency Response Handlers
	private CFBamXMsgRspnAccessFrequencyRecHandler rspnAccessFrequencyRecHandler = null;
	private CFBamXMsgRspnAccessFrequencyCreatedHandler rspnAccessFrequencyCreatedHandler = null;
	private CFBamXMsgRspnAccessFrequencyReadSingleHandler rspnAccessFrequencyReadSingleHandler = null;
	private CFBamXMsgRspnAccessFrequencyReadListHandler rspnAccessFrequencyReadListHandler = null;
	private CFBamXMsgRspnAccessFrequencyLockedHandler rspnAccessFrequencyLockedHandler = null;
	private CFBamXMsgRspnAccessFrequencyUpdatedHandler rspnAccessFrequencyUpdatedHandler = null;
	private CFBamXMsgRspnAccessFrequencyDeletedHandler rspnAccessFrequencyDeletedHandler = null;

	// AccessSecurity Response Handlers
	private CFBamXMsgRspnAccessSecurityRecHandler rspnAccessSecurityRecHandler = null;
	private CFBamXMsgRspnAccessSecurityCreatedHandler rspnAccessSecurityCreatedHandler = null;
	private CFBamXMsgRspnAccessSecurityReadSingleHandler rspnAccessSecurityReadSingleHandler = null;
	private CFBamXMsgRspnAccessSecurityReadListHandler rspnAccessSecurityReadListHandler = null;
	private CFBamXMsgRspnAccessSecurityLockedHandler rspnAccessSecurityLockedHandler = null;
	private CFBamXMsgRspnAccessSecurityUpdatedHandler rspnAccessSecurityUpdatedHandler = null;
	private CFBamXMsgRspnAccessSecurityDeletedHandler rspnAccessSecurityDeletedHandler = null;

	// Atom Response Handlers
	private CFBamXMsgRspnAtomRecHandler rspnAtomRecHandler = null;
	private CFBamXMsgRspnAtomCreatedHandler rspnAtomCreatedHandler = null;
	private CFBamXMsgRspnAtomReadSingleHandler rspnAtomReadSingleHandler = null;
	private CFBamXMsgRspnAtomReadListHandler rspnAtomReadListHandler = null;
	private CFBamXMsgRspnAtomLockedHandler rspnAtomLockedHandler = null;
	private CFBamXMsgRspnAtomUpdatedHandler rspnAtomUpdatedHandler = null;
	private CFBamXMsgRspnAtomDeletedHandler rspnAtomDeletedHandler = null;

	// AuditAction Response Handlers
	private CFBamXMsgRspnAuditActionRecHandler rspnAuditActionRecHandler = null;
	private CFBamXMsgRspnAuditActionCreatedHandler rspnAuditActionCreatedHandler = null;
	private CFBamXMsgRspnAuditActionReadSingleHandler rspnAuditActionReadSingleHandler = null;
	private CFBamXMsgRspnAuditActionReadListHandler rspnAuditActionReadListHandler = null;
	private CFBamXMsgRspnAuditActionLockedHandler rspnAuditActionLockedHandler = null;
	private CFBamXMsgRspnAuditActionUpdatedHandler rspnAuditActionUpdatedHandler = null;
	private CFBamXMsgRspnAuditActionDeletedHandler rspnAuditActionDeletedHandler = null;

	// BlobCol Response Handlers
	private CFBamXMsgRspnBlobColRecHandler rspnBlobColRecHandler = null;
	private CFBamXMsgRspnBlobColCreatedHandler rspnBlobColCreatedHandler = null;
	private CFBamXMsgRspnBlobColReadSingleHandler rspnBlobColReadSingleHandler = null;
	private CFBamXMsgRspnBlobColReadListHandler rspnBlobColReadListHandler = null;
	private CFBamXMsgRspnBlobColLockedHandler rspnBlobColLockedHandler = null;
	private CFBamXMsgRspnBlobColUpdatedHandler rspnBlobColUpdatedHandler = null;
	private CFBamXMsgRspnBlobColDeletedHandler rspnBlobColDeletedHandler = null;

	// BlobDef Response Handlers
	private CFBamXMsgRspnBlobDefRecHandler rspnBlobDefRecHandler = null;
	private CFBamXMsgRspnBlobDefCreatedHandler rspnBlobDefCreatedHandler = null;
	private CFBamXMsgRspnBlobDefReadSingleHandler rspnBlobDefReadSingleHandler = null;
	private CFBamXMsgRspnBlobDefReadListHandler rspnBlobDefReadListHandler = null;
	private CFBamXMsgRspnBlobDefLockedHandler rspnBlobDefLockedHandler = null;
	private CFBamXMsgRspnBlobDefUpdatedHandler rspnBlobDefUpdatedHandler = null;
	private CFBamXMsgRspnBlobDefDeletedHandler rspnBlobDefDeletedHandler = null;

	// BlobType Response Handlers
	private CFBamXMsgRspnBlobTypeRecHandler rspnBlobTypeRecHandler = null;
	private CFBamXMsgRspnBlobTypeCreatedHandler rspnBlobTypeCreatedHandler = null;
	private CFBamXMsgRspnBlobTypeReadSingleHandler rspnBlobTypeReadSingleHandler = null;
	private CFBamXMsgRspnBlobTypeReadListHandler rspnBlobTypeReadListHandler = null;
	private CFBamXMsgRspnBlobTypeLockedHandler rspnBlobTypeLockedHandler = null;
	private CFBamXMsgRspnBlobTypeUpdatedHandler rspnBlobTypeUpdatedHandler = null;
	private CFBamXMsgRspnBlobTypeDeletedHandler rspnBlobTypeDeletedHandler = null;

	// BoolCol Response Handlers
	private CFBamXMsgRspnBoolColRecHandler rspnBoolColRecHandler = null;
	private CFBamXMsgRspnBoolColCreatedHandler rspnBoolColCreatedHandler = null;
	private CFBamXMsgRspnBoolColReadSingleHandler rspnBoolColReadSingleHandler = null;
	private CFBamXMsgRspnBoolColReadListHandler rspnBoolColReadListHandler = null;
	private CFBamXMsgRspnBoolColLockedHandler rspnBoolColLockedHandler = null;
	private CFBamXMsgRspnBoolColUpdatedHandler rspnBoolColUpdatedHandler = null;
	private CFBamXMsgRspnBoolColDeletedHandler rspnBoolColDeletedHandler = null;

	// BoolDef Response Handlers
	private CFBamXMsgRspnBoolDefRecHandler rspnBoolDefRecHandler = null;
	private CFBamXMsgRspnBoolDefCreatedHandler rspnBoolDefCreatedHandler = null;
	private CFBamXMsgRspnBoolDefReadSingleHandler rspnBoolDefReadSingleHandler = null;
	private CFBamXMsgRspnBoolDefReadListHandler rspnBoolDefReadListHandler = null;
	private CFBamXMsgRspnBoolDefLockedHandler rspnBoolDefLockedHandler = null;
	private CFBamXMsgRspnBoolDefUpdatedHandler rspnBoolDefUpdatedHandler = null;
	private CFBamXMsgRspnBoolDefDeletedHandler rspnBoolDefDeletedHandler = null;

	// BoolType Response Handlers
	private CFBamXMsgRspnBoolTypeRecHandler rspnBoolTypeRecHandler = null;
	private CFBamXMsgRspnBoolTypeCreatedHandler rspnBoolTypeCreatedHandler = null;
	private CFBamXMsgRspnBoolTypeReadSingleHandler rspnBoolTypeReadSingleHandler = null;
	private CFBamXMsgRspnBoolTypeReadListHandler rspnBoolTypeReadListHandler = null;
	private CFBamXMsgRspnBoolTypeLockedHandler rspnBoolTypeLockedHandler = null;
	private CFBamXMsgRspnBoolTypeUpdatedHandler rspnBoolTypeUpdatedHandler = null;
	private CFBamXMsgRspnBoolTypeDeletedHandler rspnBoolTypeDeletedHandler = null;

	// Chain Response Handlers
	private CFBamXMsgRspnChainRecHandler rspnChainRecHandler = null;
	private CFBamXMsgRspnChainCreatedHandler rspnChainCreatedHandler = null;
	private CFBamXMsgRspnChainReadSingleHandler rspnChainReadSingleHandler = null;
	private CFBamXMsgRspnChainReadListHandler rspnChainReadListHandler = null;
	private CFBamXMsgRspnChainLockedHandler rspnChainLockedHandler = null;
	private CFBamXMsgRspnChainUpdatedHandler rspnChainUpdatedHandler = null;
	private CFBamXMsgRspnChainDeletedHandler rspnChainDeletedHandler = null;

	// ClearDep Response Handlers
	private CFBamXMsgRspnClearDepRecHandler rspnClearDepRecHandler = null;
	private CFBamXMsgRspnClearDepCreatedHandler rspnClearDepCreatedHandler = null;
	private CFBamXMsgRspnClearDepReadSingleHandler rspnClearDepReadSingleHandler = null;
	private CFBamXMsgRspnClearDepReadListHandler rspnClearDepReadListHandler = null;
	private CFBamXMsgRspnClearDepLockedHandler rspnClearDepLockedHandler = null;
	private CFBamXMsgRspnClearDepUpdatedHandler rspnClearDepUpdatedHandler = null;
	private CFBamXMsgRspnClearDepDeletedHandler rspnClearDepDeletedHandler = null;

	// ClearSubDep1 Response Handlers
	private CFBamXMsgRspnClearSubDep1RecHandler rspnClearSubDep1RecHandler = null;
	private CFBamXMsgRspnClearSubDep1CreatedHandler rspnClearSubDep1CreatedHandler = null;
	private CFBamXMsgRspnClearSubDep1ReadSingleHandler rspnClearSubDep1ReadSingleHandler = null;
	private CFBamXMsgRspnClearSubDep1ReadListHandler rspnClearSubDep1ReadListHandler = null;
	private CFBamXMsgRspnClearSubDep1LockedHandler rspnClearSubDep1LockedHandler = null;
	private CFBamXMsgRspnClearSubDep1UpdatedHandler rspnClearSubDep1UpdatedHandler = null;
	private CFBamXMsgRspnClearSubDep1DeletedHandler rspnClearSubDep1DeletedHandler = null;

	// ClearSubDep2 Response Handlers
	private CFBamXMsgRspnClearSubDep2RecHandler rspnClearSubDep2RecHandler = null;
	private CFBamXMsgRspnClearSubDep2CreatedHandler rspnClearSubDep2CreatedHandler = null;
	private CFBamXMsgRspnClearSubDep2ReadSingleHandler rspnClearSubDep2ReadSingleHandler = null;
	private CFBamXMsgRspnClearSubDep2ReadListHandler rspnClearSubDep2ReadListHandler = null;
	private CFBamXMsgRspnClearSubDep2LockedHandler rspnClearSubDep2LockedHandler = null;
	private CFBamXMsgRspnClearSubDep2UpdatedHandler rspnClearSubDep2UpdatedHandler = null;
	private CFBamXMsgRspnClearSubDep2DeletedHandler rspnClearSubDep2DeletedHandler = null;

	// ClearSubDep3 Response Handlers
	private CFBamXMsgRspnClearSubDep3RecHandler rspnClearSubDep3RecHandler = null;
	private CFBamXMsgRspnClearSubDep3CreatedHandler rspnClearSubDep3CreatedHandler = null;
	private CFBamXMsgRspnClearSubDep3ReadSingleHandler rspnClearSubDep3ReadSingleHandler = null;
	private CFBamXMsgRspnClearSubDep3ReadListHandler rspnClearSubDep3ReadListHandler = null;
	private CFBamXMsgRspnClearSubDep3LockedHandler rspnClearSubDep3LockedHandler = null;
	private CFBamXMsgRspnClearSubDep3UpdatedHandler rspnClearSubDep3UpdatedHandler = null;
	private CFBamXMsgRspnClearSubDep3DeletedHandler rspnClearSubDep3DeletedHandler = null;

	// ClearTopDep Response Handlers
	private CFBamXMsgRspnClearTopDepRecHandler rspnClearTopDepRecHandler = null;
	private CFBamXMsgRspnClearTopDepCreatedHandler rspnClearTopDepCreatedHandler = null;
	private CFBamXMsgRspnClearTopDepReadSingleHandler rspnClearTopDepReadSingleHandler = null;
	private CFBamXMsgRspnClearTopDepReadListHandler rspnClearTopDepReadListHandler = null;
	private CFBamXMsgRspnClearTopDepLockedHandler rspnClearTopDepLockedHandler = null;
	private CFBamXMsgRspnClearTopDepUpdatedHandler rspnClearTopDepUpdatedHandler = null;
	private CFBamXMsgRspnClearTopDepDeletedHandler rspnClearTopDepDeletedHandler = null;

	// Cluster Response Handlers
	private CFBamXMsgRspnClusterRecHandler rspnClusterRecHandler = null;
	private CFBamXMsgRspnClusterCreatedHandler rspnClusterCreatedHandler = null;
	private CFBamXMsgRspnClusterReadSingleHandler rspnClusterReadSingleHandler = null;
	private CFBamXMsgRspnClusterReadListHandler rspnClusterReadListHandler = null;
	private CFBamXMsgRspnClusterLockedHandler rspnClusterLockedHandler = null;
	private CFBamXMsgRspnClusterUpdatedHandler rspnClusterUpdatedHandler = null;
	private CFBamXMsgRspnClusterDeletedHandler rspnClusterDeletedHandler = null;

	// DataScope Response Handlers
	private CFBamXMsgRspnDataScopeRecHandler rspnDataScopeRecHandler = null;
	private CFBamXMsgRspnDataScopeCreatedHandler rspnDataScopeCreatedHandler = null;
	private CFBamXMsgRspnDataScopeReadSingleHandler rspnDataScopeReadSingleHandler = null;
	private CFBamXMsgRspnDataScopeReadListHandler rspnDataScopeReadListHandler = null;
	private CFBamXMsgRspnDataScopeLockedHandler rspnDataScopeLockedHandler = null;
	private CFBamXMsgRspnDataScopeUpdatedHandler rspnDataScopeUpdatedHandler = null;
	private CFBamXMsgRspnDataScopeDeletedHandler rspnDataScopeDeletedHandler = null;

	// DateCol Response Handlers
	private CFBamXMsgRspnDateColRecHandler rspnDateColRecHandler = null;
	private CFBamXMsgRspnDateColCreatedHandler rspnDateColCreatedHandler = null;
	private CFBamXMsgRspnDateColReadSingleHandler rspnDateColReadSingleHandler = null;
	private CFBamXMsgRspnDateColReadListHandler rspnDateColReadListHandler = null;
	private CFBamXMsgRspnDateColLockedHandler rspnDateColLockedHandler = null;
	private CFBamXMsgRspnDateColUpdatedHandler rspnDateColUpdatedHandler = null;
	private CFBamXMsgRspnDateColDeletedHandler rspnDateColDeletedHandler = null;

	// DateDef Response Handlers
	private CFBamXMsgRspnDateDefRecHandler rspnDateDefRecHandler = null;
	private CFBamXMsgRspnDateDefCreatedHandler rspnDateDefCreatedHandler = null;
	private CFBamXMsgRspnDateDefReadSingleHandler rspnDateDefReadSingleHandler = null;
	private CFBamXMsgRspnDateDefReadListHandler rspnDateDefReadListHandler = null;
	private CFBamXMsgRspnDateDefLockedHandler rspnDateDefLockedHandler = null;
	private CFBamXMsgRspnDateDefUpdatedHandler rspnDateDefUpdatedHandler = null;
	private CFBamXMsgRspnDateDefDeletedHandler rspnDateDefDeletedHandler = null;

	// DateType Response Handlers
	private CFBamXMsgRspnDateTypeRecHandler rspnDateTypeRecHandler = null;
	private CFBamXMsgRspnDateTypeCreatedHandler rspnDateTypeCreatedHandler = null;
	private CFBamXMsgRspnDateTypeReadSingleHandler rspnDateTypeReadSingleHandler = null;
	private CFBamXMsgRspnDateTypeReadListHandler rspnDateTypeReadListHandler = null;
	private CFBamXMsgRspnDateTypeLockedHandler rspnDateTypeLockedHandler = null;
	private CFBamXMsgRspnDateTypeUpdatedHandler rspnDateTypeUpdatedHandler = null;
	private CFBamXMsgRspnDateTypeDeletedHandler rspnDateTypeDeletedHandler = null;

	// DelDep Response Handlers
	private CFBamXMsgRspnDelDepRecHandler rspnDelDepRecHandler = null;
	private CFBamXMsgRspnDelDepCreatedHandler rspnDelDepCreatedHandler = null;
	private CFBamXMsgRspnDelDepReadSingleHandler rspnDelDepReadSingleHandler = null;
	private CFBamXMsgRspnDelDepReadListHandler rspnDelDepReadListHandler = null;
	private CFBamXMsgRspnDelDepLockedHandler rspnDelDepLockedHandler = null;
	private CFBamXMsgRspnDelDepUpdatedHandler rspnDelDepUpdatedHandler = null;
	private CFBamXMsgRspnDelDepDeletedHandler rspnDelDepDeletedHandler = null;

	// DelSubDep1 Response Handlers
	private CFBamXMsgRspnDelSubDep1RecHandler rspnDelSubDep1RecHandler = null;
	private CFBamXMsgRspnDelSubDep1CreatedHandler rspnDelSubDep1CreatedHandler = null;
	private CFBamXMsgRspnDelSubDep1ReadSingleHandler rspnDelSubDep1ReadSingleHandler = null;
	private CFBamXMsgRspnDelSubDep1ReadListHandler rspnDelSubDep1ReadListHandler = null;
	private CFBamXMsgRspnDelSubDep1LockedHandler rspnDelSubDep1LockedHandler = null;
	private CFBamXMsgRspnDelSubDep1UpdatedHandler rspnDelSubDep1UpdatedHandler = null;
	private CFBamXMsgRspnDelSubDep1DeletedHandler rspnDelSubDep1DeletedHandler = null;

	// DelSubDep2 Response Handlers
	private CFBamXMsgRspnDelSubDep2RecHandler rspnDelSubDep2RecHandler = null;
	private CFBamXMsgRspnDelSubDep2CreatedHandler rspnDelSubDep2CreatedHandler = null;
	private CFBamXMsgRspnDelSubDep2ReadSingleHandler rspnDelSubDep2ReadSingleHandler = null;
	private CFBamXMsgRspnDelSubDep2ReadListHandler rspnDelSubDep2ReadListHandler = null;
	private CFBamXMsgRspnDelSubDep2LockedHandler rspnDelSubDep2LockedHandler = null;
	private CFBamXMsgRspnDelSubDep2UpdatedHandler rspnDelSubDep2UpdatedHandler = null;
	private CFBamXMsgRspnDelSubDep2DeletedHandler rspnDelSubDep2DeletedHandler = null;

	// DelSubDep3 Response Handlers
	private CFBamXMsgRspnDelSubDep3RecHandler rspnDelSubDep3RecHandler = null;
	private CFBamXMsgRspnDelSubDep3CreatedHandler rspnDelSubDep3CreatedHandler = null;
	private CFBamXMsgRspnDelSubDep3ReadSingleHandler rspnDelSubDep3ReadSingleHandler = null;
	private CFBamXMsgRspnDelSubDep3ReadListHandler rspnDelSubDep3ReadListHandler = null;
	private CFBamXMsgRspnDelSubDep3LockedHandler rspnDelSubDep3LockedHandler = null;
	private CFBamXMsgRspnDelSubDep3UpdatedHandler rspnDelSubDep3UpdatedHandler = null;
	private CFBamXMsgRspnDelSubDep3DeletedHandler rspnDelSubDep3DeletedHandler = null;

	// DelTopDep Response Handlers
	private CFBamXMsgRspnDelTopDepRecHandler rspnDelTopDepRecHandler = null;
	private CFBamXMsgRspnDelTopDepCreatedHandler rspnDelTopDepCreatedHandler = null;
	private CFBamXMsgRspnDelTopDepReadSingleHandler rspnDelTopDepReadSingleHandler = null;
	private CFBamXMsgRspnDelTopDepReadListHandler rspnDelTopDepReadListHandler = null;
	private CFBamXMsgRspnDelTopDepLockedHandler rspnDelTopDepLockedHandler = null;
	private CFBamXMsgRspnDelTopDepUpdatedHandler rspnDelTopDepUpdatedHandler = null;
	private CFBamXMsgRspnDelTopDepDeletedHandler rspnDelTopDepDeletedHandler = null;

	// Domain Response Handlers
	private CFBamXMsgRspnDomainRecHandler rspnDomainRecHandler = null;
	private CFBamXMsgRspnDomainCreatedHandler rspnDomainCreatedHandler = null;
	private CFBamXMsgRspnDomainReadSingleHandler rspnDomainReadSingleHandler = null;
	private CFBamXMsgRspnDomainReadListHandler rspnDomainReadListHandler = null;
	private CFBamXMsgRspnDomainLockedHandler rspnDomainLockedHandler = null;
	private CFBamXMsgRspnDomainUpdatedHandler rspnDomainUpdatedHandler = null;
	private CFBamXMsgRspnDomainDeletedHandler rspnDomainDeletedHandler = null;

	// DomainBase Response Handlers
	private CFBamXMsgRspnDomainBaseRecHandler rspnDomainBaseRecHandler = null;
	private CFBamXMsgRspnDomainBaseCreatedHandler rspnDomainBaseCreatedHandler = null;
	private CFBamXMsgRspnDomainBaseReadSingleHandler rspnDomainBaseReadSingleHandler = null;
	private CFBamXMsgRspnDomainBaseReadListHandler rspnDomainBaseReadListHandler = null;
	private CFBamXMsgRspnDomainBaseLockedHandler rspnDomainBaseLockedHandler = null;
	private CFBamXMsgRspnDomainBaseUpdatedHandler rspnDomainBaseUpdatedHandler = null;
	private CFBamXMsgRspnDomainBaseDeletedHandler rspnDomainBaseDeletedHandler = null;

	// DoubleCol Response Handlers
	private CFBamXMsgRspnDoubleColRecHandler rspnDoubleColRecHandler = null;
	private CFBamXMsgRspnDoubleColCreatedHandler rspnDoubleColCreatedHandler = null;
	private CFBamXMsgRspnDoubleColReadSingleHandler rspnDoubleColReadSingleHandler = null;
	private CFBamXMsgRspnDoubleColReadListHandler rspnDoubleColReadListHandler = null;
	private CFBamXMsgRspnDoubleColLockedHandler rspnDoubleColLockedHandler = null;
	private CFBamXMsgRspnDoubleColUpdatedHandler rspnDoubleColUpdatedHandler = null;
	private CFBamXMsgRspnDoubleColDeletedHandler rspnDoubleColDeletedHandler = null;

	// DoubleDef Response Handlers
	private CFBamXMsgRspnDoubleDefRecHandler rspnDoubleDefRecHandler = null;
	private CFBamXMsgRspnDoubleDefCreatedHandler rspnDoubleDefCreatedHandler = null;
	private CFBamXMsgRspnDoubleDefReadSingleHandler rspnDoubleDefReadSingleHandler = null;
	private CFBamXMsgRspnDoubleDefReadListHandler rspnDoubleDefReadListHandler = null;
	private CFBamXMsgRspnDoubleDefLockedHandler rspnDoubleDefLockedHandler = null;
	private CFBamXMsgRspnDoubleDefUpdatedHandler rspnDoubleDefUpdatedHandler = null;
	private CFBamXMsgRspnDoubleDefDeletedHandler rspnDoubleDefDeletedHandler = null;

	// DoubleType Response Handlers
	private CFBamXMsgRspnDoubleTypeRecHandler rspnDoubleTypeRecHandler = null;
	private CFBamXMsgRspnDoubleTypeCreatedHandler rspnDoubleTypeCreatedHandler = null;
	private CFBamXMsgRspnDoubleTypeReadSingleHandler rspnDoubleTypeReadSingleHandler = null;
	private CFBamXMsgRspnDoubleTypeReadListHandler rspnDoubleTypeReadListHandler = null;
	private CFBamXMsgRspnDoubleTypeLockedHandler rspnDoubleTypeLockedHandler = null;
	private CFBamXMsgRspnDoubleTypeUpdatedHandler rspnDoubleTypeUpdatedHandler = null;
	private CFBamXMsgRspnDoubleTypeDeletedHandler rspnDoubleTypeDeletedHandler = null;

	// EnumCol Response Handlers
	private CFBamXMsgRspnEnumColRecHandler rspnEnumColRecHandler = null;
	private CFBamXMsgRspnEnumColCreatedHandler rspnEnumColCreatedHandler = null;
	private CFBamXMsgRspnEnumColReadSingleHandler rspnEnumColReadSingleHandler = null;
	private CFBamXMsgRspnEnumColReadListHandler rspnEnumColReadListHandler = null;
	private CFBamXMsgRspnEnumColLockedHandler rspnEnumColLockedHandler = null;
	private CFBamXMsgRspnEnumColUpdatedHandler rspnEnumColUpdatedHandler = null;
	private CFBamXMsgRspnEnumColDeletedHandler rspnEnumColDeletedHandler = null;

	// EnumDef Response Handlers
	private CFBamXMsgRspnEnumDefRecHandler rspnEnumDefRecHandler = null;
	private CFBamXMsgRspnEnumDefCreatedHandler rspnEnumDefCreatedHandler = null;
	private CFBamXMsgRspnEnumDefReadSingleHandler rspnEnumDefReadSingleHandler = null;
	private CFBamXMsgRspnEnumDefReadListHandler rspnEnumDefReadListHandler = null;
	private CFBamXMsgRspnEnumDefLockedHandler rspnEnumDefLockedHandler = null;
	private CFBamXMsgRspnEnumDefUpdatedHandler rspnEnumDefUpdatedHandler = null;
	private CFBamXMsgRspnEnumDefDeletedHandler rspnEnumDefDeletedHandler = null;

	// EnumTag Response Handlers
	private CFBamXMsgRspnEnumTagRecHandler rspnEnumTagRecHandler = null;
	private CFBamXMsgRspnEnumTagCreatedHandler rspnEnumTagCreatedHandler = null;
	private CFBamXMsgRspnEnumTagReadSingleHandler rspnEnumTagReadSingleHandler = null;
	private CFBamXMsgRspnEnumTagReadListHandler rspnEnumTagReadListHandler = null;
	private CFBamXMsgRspnEnumTagLockedHandler rspnEnumTagLockedHandler = null;
	private CFBamXMsgRspnEnumTagUpdatedHandler rspnEnumTagUpdatedHandler = null;
	private CFBamXMsgRspnEnumTagDeletedHandler rspnEnumTagDeletedHandler = null;

	// EnumType Response Handlers
	private CFBamXMsgRspnEnumTypeRecHandler rspnEnumTypeRecHandler = null;
	private CFBamXMsgRspnEnumTypeCreatedHandler rspnEnumTypeCreatedHandler = null;
	private CFBamXMsgRspnEnumTypeReadSingleHandler rspnEnumTypeReadSingleHandler = null;
	private CFBamXMsgRspnEnumTypeReadListHandler rspnEnumTypeReadListHandler = null;
	private CFBamXMsgRspnEnumTypeLockedHandler rspnEnumTypeLockedHandler = null;
	private CFBamXMsgRspnEnumTypeUpdatedHandler rspnEnumTypeUpdatedHandler = null;
	private CFBamXMsgRspnEnumTypeDeletedHandler rspnEnumTypeDeletedHandler = null;

	// FloatCol Response Handlers
	private CFBamXMsgRspnFloatColRecHandler rspnFloatColRecHandler = null;
	private CFBamXMsgRspnFloatColCreatedHandler rspnFloatColCreatedHandler = null;
	private CFBamXMsgRspnFloatColReadSingleHandler rspnFloatColReadSingleHandler = null;
	private CFBamXMsgRspnFloatColReadListHandler rspnFloatColReadListHandler = null;
	private CFBamXMsgRspnFloatColLockedHandler rspnFloatColLockedHandler = null;
	private CFBamXMsgRspnFloatColUpdatedHandler rspnFloatColUpdatedHandler = null;
	private CFBamXMsgRspnFloatColDeletedHandler rspnFloatColDeletedHandler = null;

	// FloatDef Response Handlers
	private CFBamXMsgRspnFloatDefRecHandler rspnFloatDefRecHandler = null;
	private CFBamXMsgRspnFloatDefCreatedHandler rspnFloatDefCreatedHandler = null;
	private CFBamXMsgRspnFloatDefReadSingleHandler rspnFloatDefReadSingleHandler = null;
	private CFBamXMsgRspnFloatDefReadListHandler rspnFloatDefReadListHandler = null;
	private CFBamXMsgRspnFloatDefLockedHandler rspnFloatDefLockedHandler = null;
	private CFBamXMsgRspnFloatDefUpdatedHandler rspnFloatDefUpdatedHandler = null;
	private CFBamXMsgRspnFloatDefDeletedHandler rspnFloatDefDeletedHandler = null;

	// FloatType Response Handlers
	private CFBamXMsgRspnFloatTypeRecHandler rspnFloatTypeRecHandler = null;
	private CFBamXMsgRspnFloatTypeCreatedHandler rspnFloatTypeCreatedHandler = null;
	private CFBamXMsgRspnFloatTypeReadSingleHandler rspnFloatTypeReadSingleHandler = null;
	private CFBamXMsgRspnFloatTypeReadListHandler rspnFloatTypeReadListHandler = null;
	private CFBamXMsgRspnFloatTypeLockedHandler rspnFloatTypeLockedHandler = null;
	private CFBamXMsgRspnFloatTypeUpdatedHandler rspnFloatTypeUpdatedHandler = null;
	private CFBamXMsgRspnFloatTypeDeletedHandler rspnFloatTypeDeletedHandler = null;

	// HostNode Response Handlers
	private CFBamXMsgRspnHostNodeRecHandler rspnHostNodeRecHandler = null;
	private CFBamXMsgRspnHostNodeCreatedHandler rspnHostNodeCreatedHandler = null;
	private CFBamXMsgRspnHostNodeReadSingleHandler rspnHostNodeReadSingleHandler = null;
	private CFBamXMsgRspnHostNodeReadListHandler rspnHostNodeReadListHandler = null;
	private CFBamXMsgRspnHostNodeLockedHandler rspnHostNodeLockedHandler = null;
	private CFBamXMsgRspnHostNodeUpdatedHandler rspnHostNodeUpdatedHandler = null;
	private CFBamXMsgRspnHostNodeDeletedHandler rspnHostNodeDeletedHandler = null;

	// ISOCountry Response Handlers
	private CFBamXMsgRspnISOCountryRecHandler rspnISOCountryRecHandler = null;
	private CFBamXMsgRspnISOCountryCreatedHandler rspnISOCountryCreatedHandler = null;
	private CFBamXMsgRspnISOCountryReadSingleHandler rspnISOCountryReadSingleHandler = null;
	private CFBamXMsgRspnISOCountryReadListHandler rspnISOCountryReadListHandler = null;
	private CFBamXMsgRspnISOCountryLockedHandler rspnISOCountryLockedHandler = null;
	private CFBamXMsgRspnISOCountryUpdatedHandler rspnISOCountryUpdatedHandler = null;
	private CFBamXMsgRspnISOCountryDeletedHandler rspnISOCountryDeletedHandler = null;

	// ISOCountryCurrency Response Handlers
	private CFBamXMsgRspnISOCountryCurrencyRecHandler rspnISOCountryCurrencyRecHandler = null;
	private CFBamXMsgRspnISOCountryCurrencyCreatedHandler rspnISOCountryCurrencyCreatedHandler = null;
	private CFBamXMsgRspnISOCountryCurrencyReadSingleHandler rspnISOCountryCurrencyReadSingleHandler = null;
	private CFBamXMsgRspnISOCountryCurrencyReadListHandler rspnISOCountryCurrencyReadListHandler = null;
	private CFBamXMsgRspnISOCountryCurrencyLockedHandler rspnISOCountryCurrencyLockedHandler = null;
	private CFBamXMsgRspnISOCountryCurrencyUpdatedHandler rspnISOCountryCurrencyUpdatedHandler = null;
	private CFBamXMsgRspnISOCountryCurrencyDeletedHandler rspnISOCountryCurrencyDeletedHandler = null;

	// ISOCountryLanguage Response Handlers
	private CFBamXMsgRspnISOCountryLanguageRecHandler rspnISOCountryLanguageRecHandler = null;
	private CFBamXMsgRspnISOCountryLanguageCreatedHandler rspnISOCountryLanguageCreatedHandler = null;
	private CFBamXMsgRspnISOCountryLanguageReadSingleHandler rspnISOCountryLanguageReadSingleHandler = null;
	private CFBamXMsgRspnISOCountryLanguageReadListHandler rspnISOCountryLanguageReadListHandler = null;
	private CFBamXMsgRspnISOCountryLanguageLockedHandler rspnISOCountryLanguageLockedHandler = null;
	private CFBamXMsgRspnISOCountryLanguageUpdatedHandler rspnISOCountryLanguageUpdatedHandler = null;
	private CFBamXMsgRspnISOCountryLanguageDeletedHandler rspnISOCountryLanguageDeletedHandler = null;

	// ISOCurrency Response Handlers
	private CFBamXMsgRspnISOCurrencyRecHandler rspnISOCurrencyRecHandler = null;
	private CFBamXMsgRspnISOCurrencyCreatedHandler rspnISOCurrencyCreatedHandler = null;
	private CFBamXMsgRspnISOCurrencyReadSingleHandler rspnISOCurrencyReadSingleHandler = null;
	private CFBamXMsgRspnISOCurrencyReadListHandler rspnISOCurrencyReadListHandler = null;
	private CFBamXMsgRspnISOCurrencyLockedHandler rspnISOCurrencyLockedHandler = null;
	private CFBamXMsgRspnISOCurrencyUpdatedHandler rspnISOCurrencyUpdatedHandler = null;
	private CFBamXMsgRspnISOCurrencyDeletedHandler rspnISOCurrencyDeletedHandler = null;

	// ISOLanguage Response Handlers
	private CFBamXMsgRspnISOLanguageRecHandler rspnISOLanguageRecHandler = null;
	private CFBamXMsgRspnISOLanguageCreatedHandler rspnISOLanguageCreatedHandler = null;
	private CFBamXMsgRspnISOLanguageReadSingleHandler rspnISOLanguageReadSingleHandler = null;
	private CFBamXMsgRspnISOLanguageReadListHandler rspnISOLanguageReadListHandler = null;
	private CFBamXMsgRspnISOLanguageLockedHandler rspnISOLanguageLockedHandler = null;
	private CFBamXMsgRspnISOLanguageUpdatedHandler rspnISOLanguageUpdatedHandler = null;
	private CFBamXMsgRspnISOLanguageDeletedHandler rspnISOLanguageDeletedHandler = null;

	// ISOTimezone Response Handlers
	private CFBamXMsgRspnISOTimezoneRecHandler rspnISOTimezoneRecHandler = null;
	private CFBamXMsgRspnISOTimezoneCreatedHandler rspnISOTimezoneCreatedHandler = null;
	private CFBamXMsgRspnISOTimezoneReadSingleHandler rspnISOTimezoneReadSingleHandler = null;
	private CFBamXMsgRspnISOTimezoneReadListHandler rspnISOTimezoneReadListHandler = null;
	private CFBamXMsgRspnISOTimezoneLockedHandler rspnISOTimezoneLockedHandler = null;
	private CFBamXMsgRspnISOTimezoneUpdatedHandler rspnISOTimezoneUpdatedHandler = null;
	private CFBamXMsgRspnISOTimezoneDeletedHandler rspnISOTimezoneDeletedHandler = null;

	// Id16Gen Response Handlers
	private CFBamXMsgRspnId16GenRecHandler rspnId16GenRecHandler = null;
	private CFBamXMsgRspnId16GenCreatedHandler rspnId16GenCreatedHandler = null;
	private CFBamXMsgRspnId16GenReadSingleHandler rspnId16GenReadSingleHandler = null;
	private CFBamXMsgRspnId16GenReadListHandler rspnId16GenReadListHandler = null;
	private CFBamXMsgRspnId16GenLockedHandler rspnId16GenLockedHandler = null;
	private CFBamXMsgRspnId16GenUpdatedHandler rspnId16GenUpdatedHandler = null;
	private CFBamXMsgRspnId16GenDeletedHandler rspnId16GenDeletedHandler = null;

	// Id32Gen Response Handlers
	private CFBamXMsgRspnId32GenRecHandler rspnId32GenRecHandler = null;
	private CFBamXMsgRspnId32GenCreatedHandler rspnId32GenCreatedHandler = null;
	private CFBamXMsgRspnId32GenReadSingleHandler rspnId32GenReadSingleHandler = null;
	private CFBamXMsgRspnId32GenReadListHandler rspnId32GenReadListHandler = null;
	private CFBamXMsgRspnId32GenLockedHandler rspnId32GenLockedHandler = null;
	private CFBamXMsgRspnId32GenUpdatedHandler rspnId32GenUpdatedHandler = null;
	private CFBamXMsgRspnId32GenDeletedHandler rspnId32GenDeletedHandler = null;

	// Id64Gen Response Handlers
	private CFBamXMsgRspnId64GenRecHandler rspnId64GenRecHandler = null;
	private CFBamXMsgRspnId64GenCreatedHandler rspnId64GenCreatedHandler = null;
	private CFBamXMsgRspnId64GenReadSingleHandler rspnId64GenReadSingleHandler = null;
	private CFBamXMsgRspnId64GenReadListHandler rspnId64GenReadListHandler = null;
	private CFBamXMsgRspnId64GenLockedHandler rspnId64GenLockedHandler = null;
	private CFBamXMsgRspnId64GenUpdatedHandler rspnId64GenUpdatedHandler = null;
	private CFBamXMsgRspnId64GenDeletedHandler rspnId64GenDeletedHandler = null;

	// Index Response Handlers
	private CFBamXMsgRspnIndexRecHandler rspnIndexRecHandler = null;
	private CFBamXMsgRspnIndexCreatedHandler rspnIndexCreatedHandler = null;
	private CFBamXMsgRspnIndexReadSingleHandler rspnIndexReadSingleHandler = null;
	private CFBamXMsgRspnIndexReadListHandler rspnIndexReadListHandler = null;
	private CFBamXMsgRspnIndexLockedHandler rspnIndexLockedHandler = null;
	private CFBamXMsgRspnIndexUpdatedHandler rspnIndexUpdatedHandler = null;
	private CFBamXMsgRspnIndexDeletedHandler rspnIndexDeletedHandler = null;

	// IndexCol Response Handlers
	private CFBamXMsgRspnIndexColRecHandler rspnIndexColRecHandler = null;
	private CFBamXMsgRspnIndexColCreatedHandler rspnIndexColCreatedHandler = null;
	private CFBamXMsgRspnIndexColReadSingleHandler rspnIndexColReadSingleHandler = null;
	private CFBamXMsgRspnIndexColReadListHandler rspnIndexColReadListHandler = null;
	private CFBamXMsgRspnIndexColLockedHandler rspnIndexColLockedHandler = null;
	private CFBamXMsgRspnIndexColUpdatedHandler rspnIndexColUpdatedHandler = null;
	private CFBamXMsgRspnIndexColDeletedHandler rspnIndexColDeletedHandler = null;

	// Int16Col Response Handlers
	private CFBamXMsgRspnInt16ColRecHandler rspnInt16ColRecHandler = null;
	private CFBamXMsgRspnInt16ColCreatedHandler rspnInt16ColCreatedHandler = null;
	private CFBamXMsgRspnInt16ColReadSingleHandler rspnInt16ColReadSingleHandler = null;
	private CFBamXMsgRspnInt16ColReadListHandler rspnInt16ColReadListHandler = null;
	private CFBamXMsgRspnInt16ColLockedHandler rspnInt16ColLockedHandler = null;
	private CFBamXMsgRspnInt16ColUpdatedHandler rspnInt16ColUpdatedHandler = null;
	private CFBamXMsgRspnInt16ColDeletedHandler rspnInt16ColDeletedHandler = null;

	// Int16Def Response Handlers
	private CFBamXMsgRspnInt16DefRecHandler rspnInt16DefRecHandler = null;
	private CFBamXMsgRspnInt16DefCreatedHandler rspnInt16DefCreatedHandler = null;
	private CFBamXMsgRspnInt16DefReadSingleHandler rspnInt16DefReadSingleHandler = null;
	private CFBamXMsgRspnInt16DefReadListHandler rspnInt16DefReadListHandler = null;
	private CFBamXMsgRspnInt16DefLockedHandler rspnInt16DefLockedHandler = null;
	private CFBamXMsgRspnInt16DefUpdatedHandler rspnInt16DefUpdatedHandler = null;
	private CFBamXMsgRspnInt16DefDeletedHandler rspnInt16DefDeletedHandler = null;

	// Int16Type Response Handlers
	private CFBamXMsgRspnInt16TypeRecHandler rspnInt16TypeRecHandler = null;
	private CFBamXMsgRspnInt16TypeCreatedHandler rspnInt16TypeCreatedHandler = null;
	private CFBamXMsgRspnInt16TypeReadSingleHandler rspnInt16TypeReadSingleHandler = null;
	private CFBamXMsgRspnInt16TypeReadListHandler rspnInt16TypeReadListHandler = null;
	private CFBamXMsgRspnInt16TypeLockedHandler rspnInt16TypeLockedHandler = null;
	private CFBamXMsgRspnInt16TypeUpdatedHandler rspnInt16TypeUpdatedHandler = null;
	private CFBamXMsgRspnInt16TypeDeletedHandler rspnInt16TypeDeletedHandler = null;

	// Int32Col Response Handlers
	private CFBamXMsgRspnInt32ColRecHandler rspnInt32ColRecHandler = null;
	private CFBamXMsgRspnInt32ColCreatedHandler rspnInt32ColCreatedHandler = null;
	private CFBamXMsgRspnInt32ColReadSingleHandler rspnInt32ColReadSingleHandler = null;
	private CFBamXMsgRspnInt32ColReadListHandler rspnInt32ColReadListHandler = null;
	private CFBamXMsgRspnInt32ColLockedHandler rspnInt32ColLockedHandler = null;
	private CFBamXMsgRspnInt32ColUpdatedHandler rspnInt32ColUpdatedHandler = null;
	private CFBamXMsgRspnInt32ColDeletedHandler rspnInt32ColDeletedHandler = null;

	// Int32Def Response Handlers
	private CFBamXMsgRspnInt32DefRecHandler rspnInt32DefRecHandler = null;
	private CFBamXMsgRspnInt32DefCreatedHandler rspnInt32DefCreatedHandler = null;
	private CFBamXMsgRspnInt32DefReadSingleHandler rspnInt32DefReadSingleHandler = null;
	private CFBamXMsgRspnInt32DefReadListHandler rspnInt32DefReadListHandler = null;
	private CFBamXMsgRspnInt32DefLockedHandler rspnInt32DefLockedHandler = null;
	private CFBamXMsgRspnInt32DefUpdatedHandler rspnInt32DefUpdatedHandler = null;
	private CFBamXMsgRspnInt32DefDeletedHandler rspnInt32DefDeletedHandler = null;

	// Int32Type Response Handlers
	private CFBamXMsgRspnInt32TypeRecHandler rspnInt32TypeRecHandler = null;
	private CFBamXMsgRspnInt32TypeCreatedHandler rspnInt32TypeCreatedHandler = null;
	private CFBamXMsgRspnInt32TypeReadSingleHandler rspnInt32TypeReadSingleHandler = null;
	private CFBamXMsgRspnInt32TypeReadListHandler rspnInt32TypeReadListHandler = null;
	private CFBamXMsgRspnInt32TypeLockedHandler rspnInt32TypeLockedHandler = null;
	private CFBamXMsgRspnInt32TypeUpdatedHandler rspnInt32TypeUpdatedHandler = null;
	private CFBamXMsgRspnInt32TypeDeletedHandler rspnInt32TypeDeletedHandler = null;

	// Int64Col Response Handlers
	private CFBamXMsgRspnInt64ColRecHandler rspnInt64ColRecHandler = null;
	private CFBamXMsgRspnInt64ColCreatedHandler rspnInt64ColCreatedHandler = null;
	private CFBamXMsgRspnInt64ColReadSingleHandler rspnInt64ColReadSingleHandler = null;
	private CFBamXMsgRspnInt64ColReadListHandler rspnInt64ColReadListHandler = null;
	private CFBamXMsgRspnInt64ColLockedHandler rspnInt64ColLockedHandler = null;
	private CFBamXMsgRspnInt64ColUpdatedHandler rspnInt64ColUpdatedHandler = null;
	private CFBamXMsgRspnInt64ColDeletedHandler rspnInt64ColDeletedHandler = null;

	// Int64Def Response Handlers
	private CFBamXMsgRspnInt64DefRecHandler rspnInt64DefRecHandler = null;
	private CFBamXMsgRspnInt64DefCreatedHandler rspnInt64DefCreatedHandler = null;
	private CFBamXMsgRspnInt64DefReadSingleHandler rspnInt64DefReadSingleHandler = null;
	private CFBamXMsgRspnInt64DefReadListHandler rspnInt64DefReadListHandler = null;
	private CFBamXMsgRspnInt64DefLockedHandler rspnInt64DefLockedHandler = null;
	private CFBamXMsgRspnInt64DefUpdatedHandler rspnInt64DefUpdatedHandler = null;
	private CFBamXMsgRspnInt64DefDeletedHandler rspnInt64DefDeletedHandler = null;

	// Int64Type Response Handlers
	private CFBamXMsgRspnInt64TypeRecHandler rspnInt64TypeRecHandler = null;
	private CFBamXMsgRspnInt64TypeCreatedHandler rspnInt64TypeCreatedHandler = null;
	private CFBamXMsgRspnInt64TypeReadSingleHandler rspnInt64TypeReadSingleHandler = null;
	private CFBamXMsgRspnInt64TypeReadListHandler rspnInt64TypeReadListHandler = null;
	private CFBamXMsgRspnInt64TypeLockedHandler rspnInt64TypeLockedHandler = null;
	private CFBamXMsgRspnInt64TypeUpdatedHandler rspnInt64TypeUpdatedHandler = null;
	private CFBamXMsgRspnInt64TypeDeletedHandler rspnInt64TypeDeletedHandler = null;

	// License Response Handlers
	private CFBamXMsgRspnLicenseRecHandler rspnLicenseRecHandler = null;
	private CFBamXMsgRspnLicenseCreatedHandler rspnLicenseCreatedHandler = null;
	private CFBamXMsgRspnLicenseReadSingleHandler rspnLicenseReadSingleHandler = null;
	private CFBamXMsgRspnLicenseReadListHandler rspnLicenseReadListHandler = null;
	private CFBamXMsgRspnLicenseLockedHandler rspnLicenseLockedHandler = null;
	private CFBamXMsgRspnLicenseUpdatedHandler rspnLicenseUpdatedHandler = null;
	private CFBamXMsgRspnLicenseDeletedHandler rspnLicenseDeletedHandler = null;

	// LoaderBehaviour Response Handlers
	private CFBamXMsgRspnLoaderBehaviourRecHandler rspnLoaderBehaviourRecHandler = null;
	private CFBamXMsgRspnLoaderBehaviourCreatedHandler rspnLoaderBehaviourCreatedHandler = null;
	private CFBamXMsgRspnLoaderBehaviourReadSingleHandler rspnLoaderBehaviourReadSingleHandler = null;
	private CFBamXMsgRspnLoaderBehaviourReadListHandler rspnLoaderBehaviourReadListHandler = null;
	private CFBamXMsgRspnLoaderBehaviourLockedHandler rspnLoaderBehaviourLockedHandler = null;
	private CFBamXMsgRspnLoaderBehaviourUpdatedHandler rspnLoaderBehaviourUpdatedHandler = null;
	private CFBamXMsgRspnLoaderBehaviourDeletedHandler rspnLoaderBehaviourDeletedHandler = null;

	// MajorVersion Response Handlers
	private CFBamXMsgRspnMajorVersionRecHandler rspnMajorVersionRecHandler = null;
	private CFBamXMsgRspnMajorVersionCreatedHandler rspnMajorVersionCreatedHandler = null;
	private CFBamXMsgRspnMajorVersionReadSingleHandler rspnMajorVersionReadSingleHandler = null;
	private CFBamXMsgRspnMajorVersionReadListHandler rspnMajorVersionReadListHandler = null;
	private CFBamXMsgRspnMajorVersionLockedHandler rspnMajorVersionLockedHandler = null;
	private CFBamXMsgRspnMajorVersionUpdatedHandler rspnMajorVersionUpdatedHandler = null;
	private CFBamXMsgRspnMajorVersionDeletedHandler rspnMajorVersionDeletedHandler = null;

	// MimeType Response Handlers
	private CFBamXMsgRspnMimeTypeRecHandler rspnMimeTypeRecHandler = null;
	private CFBamXMsgRspnMimeTypeCreatedHandler rspnMimeTypeCreatedHandler = null;
	private CFBamXMsgRspnMimeTypeReadSingleHandler rspnMimeTypeReadSingleHandler = null;
	private CFBamXMsgRspnMimeTypeReadListHandler rspnMimeTypeReadListHandler = null;
	private CFBamXMsgRspnMimeTypeLockedHandler rspnMimeTypeLockedHandler = null;
	private CFBamXMsgRspnMimeTypeUpdatedHandler rspnMimeTypeUpdatedHandler = null;
	private CFBamXMsgRspnMimeTypeDeletedHandler rspnMimeTypeDeletedHandler = null;

	// MinorVersion Response Handlers
	private CFBamXMsgRspnMinorVersionRecHandler rspnMinorVersionRecHandler = null;
	private CFBamXMsgRspnMinorVersionCreatedHandler rspnMinorVersionCreatedHandler = null;
	private CFBamXMsgRspnMinorVersionReadSingleHandler rspnMinorVersionReadSingleHandler = null;
	private CFBamXMsgRspnMinorVersionReadListHandler rspnMinorVersionReadListHandler = null;
	private CFBamXMsgRspnMinorVersionLockedHandler rspnMinorVersionLockedHandler = null;
	private CFBamXMsgRspnMinorVersionUpdatedHandler rspnMinorVersionUpdatedHandler = null;
	private CFBamXMsgRspnMinorVersionDeletedHandler rspnMinorVersionDeletedHandler = null;

	// NmTokenCol Response Handlers
	private CFBamXMsgRspnNmTokenColRecHandler rspnNmTokenColRecHandler = null;
	private CFBamXMsgRspnNmTokenColCreatedHandler rspnNmTokenColCreatedHandler = null;
	private CFBamXMsgRspnNmTokenColReadSingleHandler rspnNmTokenColReadSingleHandler = null;
	private CFBamXMsgRspnNmTokenColReadListHandler rspnNmTokenColReadListHandler = null;
	private CFBamXMsgRspnNmTokenColLockedHandler rspnNmTokenColLockedHandler = null;
	private CFBamXMsgRspnNmTokenColUpdatedHandler rspnNmTokenColUpdatedHandler = null;
	private CFBamXMsgRspnNmTokenColDeletedHandler rspnNmTokenColDeletedHandler = null;

	// NmTokenDef Response Handlers
	private CFBamXMsgRspnNmTokenDefRecHandler rspnNmTokenDefRecHandler = null;
	private CFBamXMsgRspnNmTokenDefCreatedHandler rspnNmTokenDefCreatedHandler = null;
	private CFBamXMsgRspnNmTokenDefReadSingleHandler rspnNmTokenDefReadSingleHandler = null;
	private CFBamXMsgRspnNmTokenDefReadListHandler rspnNmTokenDefReadListHandler = null;
	private CFBamXMsgRspnNmTokenDefLockedHandler rspnNmTokenDefLockedHandler = null;
	private CFBamXMsgRspnNmTokenDefUpdatedHandler rspnNmTokenDefUpdatedHandler = null;
	private CFBamXMsgRspnNmTokenDefDeletedHandler rspnNmTokenDefDeletedHandler = null;

	// NmTokenType Response Handlers
	private CFBamXMsgRspnNmTokenTypeRecHandler rspnNmTokenTypeRecHandler = null;
	private CFBamXMsgRspnNmTokenTypeCreatedHandler rspnNmTokenTypeCreatedHandler = null;
	private CFBamXMsgRspnNmTokenTypeReadSingleHandler rspnNmTokenTypeReadSingleHandler = null;
	private CFBamXMsgRspnNmTokenTypeReadListHandler rspnNmTokenTypeReadListHandler = null;
	private CFBamXMsgRspnNmTokenTypeLockedHandler rspnNmTokenTypeLockedHandler = null;
	private CFBamXMsgRspnNmTokenTypeUpdatedHandler rspnNmTokenTypeUpdatedHandler = null;
	private CFBamXMsgRspnNmTokenTypeDeletedHandler rspnNmTokenTypeDeletedHandler = null;

	// NmTokensCol Response Handlers
	private CFBamXMsgRspnNmTokensColRecHandler rspnNmTokensColRecHandler = null;
	private CFBamXMsgRspnNmTokensColCreatedHandler rspnNmTokensColCreatedHandler = null;
	private CFBamXMsgRspnNmTokensColReadSingleHandler rspnNmTokensColReadSingleHandler = null;
	private CFBamXMsgRspnNmTokensColReadListHandler rspnNmTokensColReadListHandler = null;
	private CFBamXMsgRspnNmTokensColLockedHandler rspnNmTokensColLockedHandler = null;
	private CFBamXMsgRspnNmTokensColUpdatedHandler rspnNmTokensColUpdatedHandler = null;
	private CFBamXMsgRspnNmTokensColDeletedHandler rspnNmTokensColDeletedHandler = null;

	// NmTokensDef Response Handlers
	private CFBamXMsgRspnNmTokensDefRecHandler rspnNmTokensDefRecHandler = null;
	private CFBamXMsgRspnNmTokensDefCreatedHandler rspnNmTokensDefCreatedHandler = null;
	private CFBamXMsgRspnNmTokensDefReadSingleHandler rspnNmTokensDefReadSingleHandler = null;
	private CFBamXMsgRspnNmTokensDefReadListHandler rspnNmTokensDefReadListHandler = null;
	private CFBamXMsgRspnNmTokensDefLockedHandler rspnNmTokensDefLockedHandler = null;
	private CFBamXMsgRspnNmTokensDefUpdatedHandler rspnNmTokensDefUpdatedHandler = null;
	private CFBamXMsgRspnNmTokensDefDeletedHandler rspnNmTokensDefDeletedHandler = null;

	// NmTokensType Response Handlers
	private CFBamXMsgRspnNmTokensTypeRecHandler rspnNmTokensTypeRecHandler = null;
	private CFBamXMsgRspnNmTokensTypeCreatedHandler rspnNmTokensTypeCreatedHandler = null;
	private CFBamXMsgRspnNmTokensTypeReadSingleHandler rspnNmTokensTypeReadSingleHandler = null;
	private CFBamXMsgRspnNmTokensTypeReadListHandler rspnNmTokensTypeReadListHandler = null;
	private CFBamXMsgRspnNmTokensTypeLockedHandler rspnNmTokensTypeLockedHandler = null;
	private CFBamXMsgRspnNmTokensTypeUpdatedHandler rspnNmTokensTypeUpdatedHandler = null;
	private CFBamXMsgRspnNmTokensTypeDeletedHandler rspnNmTokensTypeDeletedHandler = null;

	// NumberCol Response Handlers
	private CFBamXMsgRspnNumberColRecHandler rspnNumberColRecHandler = null;
	private CFBamXMsgRspnNumberColCreatedHandler rspnNumberColCreatedHandler = null;
	private CFBamXMsgRspnNumberColReadSingleHandler rspnNumberColReadSingleHandler = null;
	private CFBamXMsgRspnNumberColReadListHandler rspnNumberColReadListHandler = null;
	private CFBamXMsgRspnNumberColLockedHandler rspnNumberColLockedHandler = null;
	private CFBamXMsgRspnNumberColUpdatedHandler rspnNumberColUpdatedHandler = null;
	private CFBamXMsgRspnNumberColDeletedHandler rspnNumberColDeletedHandler = null;

	// NumberDef Response Handlers
	private CFBamXMsgRspnNumberDefRecHandler rspnNumberDefRecHandler = null;
	private CFBamXMsgRspnNumberDefCreatedHandler rspnNumberDefCreatedHandler = null;
	private CFBamXMsgRspnNumberDefReadSingleHandler rspnNumberDefReadSingleHandler = null;
	private CFBamXMsgRspnNumberDefReadListHandler rspnNumberDefReadListHandler = null;
	private CFBamXMsgRspnNumberDefLockedHandler rspnNumberDefLockedHandler = null;
	private CFBamXMsgRspnNumberDefUpdatedHandler rspnNumberDefUpdatedHandler = null;
	private CFBamXMsgRspnNumberDefDeletedHandler rspnNumberDefDeletedHandler = null;

	// NumberType Response Handlers
	private CFBamXMsgRspnNumberTypeRecHandler rspnNumberTypeRecHandler = null;
	private CFBamXMsgRspnNumberTypeCreatedHandler rspnNumberTypeCreatedHandler = null;
	private CFBamXMsgRspnNumberTypeReadSingleHandler rspnNumberTypeReadSingleHandler = null;
	private CFBamXMsgRspnNumberTypeReadListHandler rspnNumberTypeReadListHandler = null;
	private CFBamXMsgRspnNumberTypeLockedHandler rspnNumberTypeLockedHandler = null;
	private CFBamXMsgRspnNumberTypeUpdatedHandler rspnNumberTypeUpdatedHandler = null;
	private CFBamXMsgRspnNumberTypeDeletedHandler rspnNumberTypeDeletedHandler = null;

	// Param Response Handlers
	private CFBamXMsgRspnParamRecHandler rspnParamRecHandler = null;
	private CFBamXMsgRspnParamCreatedHandler rspnParamCreatedHandler = null;
	private CFBamXMsgRspnParamReadSingleHandler rspnParamReadSingleHandler = null;
	private CFBamXMsgRspnParamReadListHandler rspnParamReadListHandler = null;
	private CFBamXMsgRspnParamLockedHandler rspnParamLockedHandler = null;
	private CFBamXMsgRspnParamUpdatedHandler rspnParamUpdatedHandler = null;
	private CFBamXMsgRspnParamDeletedHandler rspnParamDeletedHandler = null;

	// PopDep Response Handlers
	private CFBamXMsgRspnPopDepRecHandler rspnPopDepRecHandler = null;
	private CFBamXMsgRspnPopDepCreatedHandler rspnPopDepCreatedHandler = null;
	private CFBamXMsgRspnPopDepReadSingleHandler rspnPopDepReadSingleHandler = null;
	private CFBamXMsgRspnPopDepReadListHandler rspnPopDepReadListHandler = null;
	private CFBamXMsgRspnPopDepLockedHandler rspnPopDepLockedHandler = null;
	private CFBamXMsgRspnPopDepUpdatedHandler rspnPopDepUpdatedHandler = null;
	private CFBamXMsgRspnPopDepDeletedHandler rspnPopDepDeletedHandler = null;

	// PopSubDep1 Response Handlers
	private CFBamXMsgRspnPopSubDep1RecHandler rspnPopSubDep1RecHandler = null;
	private CFBamXMsgRspnPopSubDep1CreatedHandler rspnPopSubDep1CreatedHandler = null;
	private CFBamXMsgRspnPopSubDep1ReadSingleHandler rspnPopSubDep1ReadSingleHandler = null;
	private CFBamXMsgRspnPopSubDep1ReadListHandler rspnPopSubDep1ReadListHandler = null;
	private CFBamXMsgRspnPopSubDep1LockedHandler rspnPopSubDep1LockedHandler = null;
	private CFBamXMsgRspnPopSubDep1UpdatedHandler rspnPopSubDep1UpdatedHandler = null;
	private CFBamXMsgRspnPopSubDep1DeletedHandler rspnPopSubDep1DeletedHandler = null;

	// PopSubDep2 Response Handlers
	private CFBamXMsgRspnPopSubDep2RecHandler rspnPopSubDep2RecHandler = null;
	private CFBamXMsgRspnPopSubDep2CreatedHandler rspnPopSubDep2CreatedHandler = null;
	private CFBamXMsgRspnPopSubDep2ReadSingleHandler rspnPopSubDep2ReadSingleHandler = null;
	private CFBamXMsgRspnPopSubDep2ReadListHandler rspnPopSubDep2ReadListHandler = null;
	private CFBamXMsgRspnPopSubDep2LockedHandler rspnPopSubDep2LockedHandler = null;
	private CFBamXMsgRspnPopSubDep2UpdatedHandler rspnPopSubDep2UpdatedHandler = null;
	private CFBamXMsgRspnPopSubDep2DeletedHandler rspnPopSubDep2DeletedHandler = null;

	// PopSubDep3 Response Handlers
	private CFBamXMsgRspnPopSubDep3RecHandler rspnPopSubDep3RecHandler = null;
	private CFBamXMsgRspnPopSubDep3CreatedHandler rspnPopSubDep3CreatedHandler = null;
	private CFBamXMsgRspnPopSubDep3ReadSingleHandler rspnPopSubDep3ReadSingleHandler = null;
	private CFBamXMsgRspnPopSubDep3ReadListHandler rspnPopSubDep3ReadListHandler = null;
	private CFBamXMsgRspnPopSubDep3LockedHandler rspnPopSubDep3LockedHandler = null;
	private CFBamXMsgRspnPopSubDep3UpdatedHandler rspnPopSubDep3UpdatedHandler = null;
	private CFBamXMsgRspnPopSubDep3DeletedHandler rspnPopSubDep3DeletedHandler = null;

	// PopTopDep Response Handlers
	private CFBamXMsgRspnPopTopDepRecHandler rspnPopTopDepRecHandler = null;
	private CFBamXMsgRspnPopTopDepCreatedHandler rspnPopTopDepCreatedHandler = null;
	private CFBamXMsgRspnPopTopDepReadSingleHandler rspnPopTopDepReadSingleHandler = null;
	private CFBamXMsgRspnPopTopDepReadListHandler rspnPopTopDepReadListHandler = null;
	private CFBamXMsgRspnPopTopDepLockedHandler rspnPopTopDepLockedHandler = null;
	private CFBamXMsgRspnPopTopDepUpdatedHandler rspnPopTopDepUpdatedHandler = null;
	private CFBamXMsgRspnPopTopDepDeletedHandler rspnPopTopDepDeletedHandler = null;

	// ProjectBase Response Handlers
	private CFBamXMsgRspnProjectBaseRecHandler rspnProjectBaseRecHandler = null;
	private CFBamXMsgRspnProjectBaseCreatedHandler rspnProjectBaseCreatedHandler = null;
	private CFBamXMsgRspnProjectBaseReadSingleHandler rspnProjectBaseReadSingleHandler = null;
	private CFBamXMsgRspnProjectBaseReadListHandler rspnProjectBaseReadListHandler = null;
	private CFBamXMsgRspnProjectBaseLockedHandler rspnProjectBaseLockedHandler = null;
	private CFBamXMsgRspnProjectBaseUpdatedHandler rspnProjectBaseUpdatedHandler = null;
	private CFBamXMsgRspnProjectBaseDeletedHandler rspnProjectBaseDeletedHandler = null;

	// RealProject Response Handlers
	private CFBamXMsgRspnRealProjectRecHandler rspnRealProjectRecHandler = null;
	private CFBamXMsgRspnRealProjectCreatedHandler rspnRealProjectCreatedHandler = null;
	private CFBamXMsgRspnRealProjectReadSingleHandler rspnRealProjectReadSingleHandler = null;
	private CFBamXMsgRspnRealProjectReadListHandler rspnRealProjectReadListHandler = null;
	private CFBamXMsgRspnRealProjectLockedHandler rspnRealProjectLockedHandler = null;
	private CFBamXMsgRspnRealProjectUpdatedHandler rspnRealProjectUpdatedHandler = null;
	private CFBamXMsgRspnRealProjectDeletedHandler rspnRealProjectDeletedHandler = null;

	// Relation Response Handlers
	private CFBamXMsgRspnRelationRecHandler rspnRelationRecHandler = null;
	private CFBamXMsgRspnRelationCreatedHandler rspnRelationCreatedHandler = null;
	private CFBamXMsgRspnRelationReadSingleHandler rspnRelationReadSingleHandler = null;
	private CFBamXMsgRspnRelationReadListHandler rspnRelationReadListHandler = null;
	private CFBamXMsgRspnRelationLockedHandler rspnRelationLockedHandler = null;
	private CFBamXMsgRspnRelationUpdatedHandler rspnRelationUpdatedHandler = null;
	private CFBamXMsgRspnRelationDeletedHandler rspnRelationDeletedHandler = null;

	// RelationCol Response Handlers
	private CFBamXMsgRspnRelationColRecHandler rspnRelationColRecHandler = null;
	private CFBamXMsgRspnRelationColCreatedHandler rspnRelationColCreatedHandler = null;
	private CFBamXMsgRspnRelationColReadSingleHandler rspnRelationColReadSingleHandler = null;
	private CFBamXMsgRspnRelationColReadListHandler rspnRelationColReadListHandler = null;
	private CFBamXMsgRspnRelationColLockedHandler rspnRelationColLockedHandler = null;
	private CFBamXMsgRspnRelationColUpdatedHandler rspnRelationColUpdatedHandler = null;
	private CFBamXMsgRspnRelationColDeletedHandler rspnRelationColDeletedHandler = null;

	// RelationType Response Handlers
	private CFBamXMsgRspnRelationTypeRecHandler rspnRelationTypeRecHandler = null;
	private CFBamXMsgRspnRelationTypeCreatedHandler rspnRelationTypeCreatedHandler = null;
	private CFBamXMsgRspnRelationTypeReadSingleHandler rspnRelationTypeReadSingleHandler = null;
	private CFBamXMsgRspnRelationTypeReadListHandler rspnRelationTypeReadListHandler = null;
	private CFBamXMsgRspnRelationTypeLockedHandler rspnRelationTypeLockedHandler = null;
	private CFBamXMsgRspnRelationTypeUpdatedHandler rspnRelationTypeUpdatedHandler = null;
	private CFBamXMsgRspnRelationTypeDeletedHandler rspnRelationTypeDeletedHandler = null;

	// SchemaDef Response Handlers
	private CFBamXMsgRspnSchemaDefRecHandler rspnSchemaDefRecHandler = null;
	private CFBamXMsgRspnSchemaDefCreatedHandler rspnSchemaDefCreatedHandler = null;
	private CFBamXMsgRspnSchemaDefReadSingleHandler rspnSchemaDefReadSingleHandler = null;
	private CFBamXMsgRspnSchemaDefReadListHandler rspnSchemaDefReadListHandler = null;
	private CFBamXMsgRspnSchemaDefLockedHandler rspnSchemaDefLockedHandler = null;
	private CFBamXMsgRspnSchemaDefUpdatedHandler rspnSchemaDefUpdatedHandler = null;
	private CFBamXMsgRspnSchemaDefDeletedHandler rspnSchemaDefDeletedHandler = null;

	// SchemaRef Response Handlers
	private CFBamXMsgRspnSchemaRefRecHandler rspnSchemaRefRecHandler = null;
	private CFBamXMsgRspnSchemaRefCreatedHandler rspnSchemaRefCreatedHandler = null;
	private CFBamXMsgRspnSchemaRefReadSingleHandler rspnSchemaRefReadSingleHandler = null;
	private CFBamXMsgRspnSchemaRefReadListHandler rspnSchemaRefReadListHandler = null;
	private CFBamXMsgRspnSchemaRefLockedHandler rspnSchemaRefLockedHandler = null;
	private CFBamXMsgRspnSchemaRefUpdatedHandler rspnSchemaRefUpdatedHandler = null;
	private CFBamXMsgRspnSchemaRefDeletedHandler rspnSchemaRefDeletedHandler = null;

	// Scope Response Handlers
	private CFBamXMsgRspnScopeRecHandler rspnScopeRecHandler = null;
	private CFBamXMsgRspnScopeCreatedHandler rspnScopeCreatedHandler = null;
	private CFBamXMsgRspnScopeReadSingleHandler rspnScopeReadSingleHandler = null;
	private CFBamXMsgRspnScopeReadListHandler rspnScopeReadListHandler = null;
	private CFBamXMsgRspnScopeLockedHandler rspnScopeLockedHandler = null;
	private CFBamXMsgRspnScopeUpdatedHandler rspnScopeUpdatedHandler = null;
	private CFBamXMsgRspnScopeDeletedHandler rspnScopeDeletedHandler = null;

	// SecApp Response Handlers
	private CFBamXMsgRspnSecAppRecHandler rspnSecAppRecHandler = null;
	private CFBamXMsgRspnSecAppCreatedHandler rspnSecAppCreatedHandler = null;
	private CFBamXMsgRspnSecAppReadSingleHandler rspnSecAppReadSingleHandler = null;
	private CFBamXMsgRspnSecAppReadListHandler rspnSecAppReadListHandler = null;
	private CFBamXMsgRspnSecAppLockedHandler rspnSecAppLockedHandler = null;
	private CFBamXMsgRspnSecAppUpdatedHandler rspnSecAppUpdatedHandler = null;
	private CFBamXMsgRspnSecAppDeletedHandler rspnSecAppDeletedHandler = null;

	// SecDevice Response Handlers
	private CFBamXMsgRspnSecDeviceRecHandler rspnSecDeviceRecHandler = null;
	private CFBamXMsgRspnSecDeviceCreatedHandler rspnSecDeviceCreatedHandler = null;
	private CFBamXMsgRspnSecDeviceReadSingleHandler rspnSecDeviceReadSingleHandler = null;
	private CFBamXMsgRspnSecDeviceReadListHandler rspnSecDeviceReadListHandler = null;
	private CFBamXMsgRspnSecDeviceLockedHandler rspnSecDeviceLockedHandler = null;
	private CFBamXMsgRspnSecDeviceUpdatedHandler rspnSecDeviceUpdatedHandler = null;
	private CFBamXMsgRspnSecDeviceDeletedHandler rspnSecDeviceDeletedHandler = null;

	// SecForm Response Handlers
	private CFBamXMsgRspnSecFormRecHandler rspnSecFormRecHandler = null;
	private CFBamXMsgRspnSecFormCreatedHandler rspnSecFormCreatedHandler = null;
	private CFBamXMsgRspnSecFormReadSingleHandler rspnSecFormReadSingleHandler = null;
	private CFBamXMsgRspnSecFormReadListHandler rspnSecFormReadListHandler = null;
	private CFBamXMsgRspnSecFormLockedHandler rspnSecFormLockedHandler = null;
	private CFBamXMsgRspnSecFormUpdatedHandler rspnSecFormUpdatedHandler = null;
	private CFBamXMsgRspnSecFormDeletedHandler rspnSecFormDeletedHandler = null;

	// SecGroup Response Handlers
	private CFBamXMsgRspnSecGroupRecHandler rspnSecGroupRecHandler = null;
	private CFBamXMsgRspnSecGroupCreatedHandler rspnSecGroupCreatedHandler = null;
	private CFBamXMsgRspnSecGroupReadSingleHandler rspnSecGroupReadSingleHandler = null;
	private CFBamXMsgRspnSecGroupReadListHandler rspnSecGroupReadListHandler = null;
	private CFBamXMsgRspnSecGroupLockedHandler rspnSecGroupLockedHandler = null;
	private CFBamXMsgRspnSecGroupUpdatedHandler rspnSecGroupUpdatedHandler = null;
	private CFBamXMsgRspnSecGroupDeletedHandler rspnSecGroupDeletedHandler = null;

	// SecGroupForm Response Handlers
	private CFBamXMsgRspnSecGroupFormRecHandler rspnSecGroupFormRecHandler = null;
	private CFBamXMsgRspnSecGroupFormCreatedHandler rspnSecGroupFormCreatedHandler = null;
	private CFBamXMsgRspnSecGroupFormReadSingleHandler rspnSecGroupFormReadSingleHandler = null;
	private CFBamXMsgRspnSecGroupFormReadListHandler rspnSecGroupFormReadListHandler = null;
	private CFBamXMsgRspnSecGroupFormLockedHandler rspnSecGroupFormLockedHandler = null;
	private CFBamXMsgRspnSecGroupFormUpdatedHandler rspnSecGroupFormUpdatedHandler = null;
	private CFBamXMsgRspnSecGroupFormDeletedHandler rspnSecGroupFormDeletedHandler = null;

	// SecGroupInclude Response Handlers
	private CFBamXMsgRspnSecGroupIncludeRecHandler rspnSecGroupIncludeRecHandler = null;
	private CFBamXMsgRspnSecGroupIncludeCreatedHandler rspnSecGroupIncludeCreatedHandler = null;
	private CFBamXMsgRspnSecGroupIncludeReadSingleHandler rspnSecGroupIncludeReadSingleHandler = null;
	private CFBamXMsgRspnSecGroupIncludeReadListHandler rspnSecGroupIncludeReadListHandler = null;
	private CFBamXMsgRspnSecGroupIncludeLockedHandler rspnSecGroupIncludeLockedHandler = null;
	private CFBamXMsgRspnSecGroupIncludeUpdatedHandler rspnSecGroupIncludeUpdatedHandler = null;
	private CFBamXMsgRspnSecGroupIncludeDeletedHandler rspnSecGroupIncludeDeletedHandler = null;

	// SecGroupMember Response Handlers
	private CFBamXMsgRspnSecGroupMemberRecHandler rspnSecGroupMemberRecHandler = null;
	private CFBamXMsgRspnSecGroupMemberCreatedHandler rspnSecGroupMemberCreatedHandler = null;
	private CFBamXMsgRspnSecGroupMemberReadSingleHandler rspnSecGroupMemberReadSingleHandler = null;
	private CFBamXMsgRspnSecGroupMemberReadListHandler rspnSecGroupMemberReadListHandler = null;
	private CFBamXMsgRspnSecGroupMemberLockedHandler rspnSecGroupMemberLockedHandler = null;
	private CFBamXMsgRspnSecGroupMemberUpdatedHandler rspnSecGroupMemberUpdatedHandler = null;
	private CFBamXMsgRspnSecGroupMemberDeletedHandler rspnSecGroupMemberDeletedHandler = null;

	// SecSession Response Handlers
	private CFBamXMsgRspnSecSessionRecHandler rspnSecSessionRecHandler = null;
	private CFBamXMsgRspnSecSessionCreatedHandler rspnSecSessionCreatedHandler = null;
	private CFBamXMsgRspnSecSessionReadSingleHandler rspnSecSessionReadSingleHandler = null;
	private CFBamXMsgRspnSecSessionReadListHandler rspnSecSessionReadListHandler = null;
	private CFBamXMsgRspnSecSessionLockedHandler rspnSecSessionLockedHandler = null;
	private CFBamXMsgRspnSecSessionUpdatedHandler rspnSecSessionUpdatedHandler = null;
	private CFBamXMsgRspnSecSessionDeletedHandler rspnSecSessionDeletedHandler = null;

	// SecUser Response Handlers
	private CFBamXMsgRspnSecUserRecHandler rspnSecUserRecHandler = null;
	private CFBamXMsgRspnSecUserCreatedHandler rspnSecUserCreatedHandler = null;
	private CFBamXMsgRspnSecUserReadSingleHandler rspnSecUserReadSingleHandler = null;
	private CFBamXMsgRspnSecUserReadListHandler rspnSecUserReadListHandler = null;
	private CFBamXMsgRspnSecUserLockedHandler rspnSecUserLockedHandler = null;
	private CFBamXMsgRspnSecUserUpdatedHandler rspnSecUserUpdatedHandler = null;
	private CFBamXMsgRspnSecUserDeletedHandler rspnSecUserDeletedHandler = null;

	// SecurityScope Response Handlers
	private CFBamXMsgRspnSecurityScopeRecHandler rspnSecurityScopeRecHandler = null;
	private CFBamXMsgRspnSecurityScopeCreatedHandler rspnSecurityScopeCreatedHandler = null;
	private CFBamXMsgRspnSecurityScopeReadSingleHandler rspnSecurityScopeReadSingleHandler = null;
	private CFBamXMsgRspnSecurityScopeReadListHandler rspnSecurityScopeReadListHandler = null;
	private CFBamXMsgRspnSecurityScopeLockedHandler rspnSecurityScopeLockedHandler = null;
	private CFBamXMsgRspnSecurityScopeUpdatedHandler rspnSecurityScopeUpdatedHandler = null;
	private CFBamXMsgRspnSecurityScopeDeletedHandler rspnSecurityScopeDeletedHandler = null;

	// ServerListFunc Response Handlers
	private CFBamXMsgRspnServerListFuncRecHandler rspnServerListFuncRecHandler = null;
	private CFBamXMsgRspnServerListFuncCreatedHandler rspnServerListFuncCreatedHandler = null;
	private CFBamXMsgRspnServerListFuncReadSingleHandler rspnServerListFuncReadSingleHandler = null;
	private CFBamXMsgRspnServerListFuncReadListHandler rspnServerListFuncReadListHandler = null;
	private CFBamXMsgRspnServerListFuncLockedHandler rspnServerListFuncLockedHandler = null;
	private CFBamXMsgRspnServerListFuncUpdatedHandler rspnServerListFuncUpdatedHandler = null;
	private CFBamXMsgRspnServerListFuncDeletedHandler rspnServerListFuncDeletedHandler = null;

	// ServerMethod Response Handlers
	private CFBamXMsgRspnServerMethodRecHandler rspnServerMethodRecHandler = null;
	private CFBamXMsgRspnServerMethodCreatedHandler rspnServerMethodCreatedHandler = null;
	private CFBamXMsgRspnServerMethodReadSingleHandler rspnServerMethodReadSingleHandler = null;
	private CFBamXMsgRspnServerMethodReadListHandler rspnServerMethodReadListHandler = null;
	private CFBamXMsgRspnServerMethodLockedHandler rspnServerMethodLockedHandler = null;
	private CFBamXMsgRspnServerMethodUpdatedHandler rspnServerMethodUpdatedHandler = null;
	private CFBamXMsgRspnServerMethodDeletedHandler rspnServerMethodDeletedHandler = null;

	// ServerObjFunc Response Handlers
	private CFBamXMsgRspnServerObjFuncRecHandler rspnServerObjFuncRecHandler = null;
	private CFBamXMsgRspnServerObjFuncCreatedHandler rspnServerObjFuncCreatedHandler = null;
	private CFBamXMsgRspnServerObjFuncReadSingleHandler rspnServerObjFuncReadSingleHandler = null;
	private CFBamXMsgRspnServerObjFuncReadListHandler rspnServerObjFuncReadListHandler = null;
	private CFBamXMsgRspnServerObjFuncLockedHandler rspnServerObjFuncLockedHandler = null;
	private CFBamXMsgRspnServerObjFuncUpdatedHandler rspnServerObjFuncUpdatedHandler = null;
	private CFBamXMsgRspnServerObjFuncDeletedHandler rspnServerObjFuncDeletedHandler = null;

	// ServerProc Response Handlers
	private CFBamXMsgRspnServerProcRecHandler rspnServerProcRecHandler = null;
	private CFBamXMsgRspnServerProcCreatedHandler rspnServerProcCreatedHandler = null;
	private CFBamXMsgRspnServerProcReadSingleHandler rspnServerProcReadSingleHandler = null;
	private CFBamXMsgRspnServerProcReadListHandler rspnServerProcReadListHandler = null;
	private CFBamXMsgRspnServerProcLockedHandler rspnServerProcLockedHandler = null;
	private CFBamXMsgRspnServerProcUpdatedHandler rspnServerProcUpdatedHandler = null;
	private CFBamXMsgRspnServerProcDeletedHandler rspnServerProcDeletedHandler = null;

	// Service Response Handlers
	private CFBamXMsgRspnServiceRecHandler rspnServiceRecHandler = null;
	private CFBamXMsgRspnServiceCreatedHandler rspnServiceCreatedHandler = null;
	private CFBamXMsgRspnServiceReadSingleHandler rspnServiceReadSingleHandler = null;
	private CFBamXMsgRspnServiceReadListHandler rspnServiceReadListHandler = null;
	private CFBamXMsgRspnServiceLockedHandler rspnServiceLockedHandler = null;
	private CFBamXMsgRspnServiceUpdatedHandler rspnServiceUpdatedHandler = null;
	private CFBamXMsgRspnServiceDeletedHandler rspnServiceDeletedHandler = null;

	// ServiceType Response Handlers
	private CFBamXMsgRspnServiceTypeRecHandler rspnServiceTypeRecHandler = null;
	private CFBamXMsgRspnServiceTypeCreatedHandler rspnServiceTypeCreatedHandler = null;
	private CFBamXMsgRspnServiceTypeReadSingleHandler rspnServiceTypeReadSingleHandler = null;
	private CFBamXMsgRspnServiceTypeReadListHandler rspnServiceTypeReadListHandler = null;
	private CFBamXMsgRspnServiceTypeLockedHandler rspnServiceTypeLockedHandler = null;
	private CFBamXMsgRspnServiceTypeUpdatedHandler rspnServiceTypeUpdatedHandler = null;
	private CFBamXMsgRspnServiceTypeDeletedHandler rspnServiceTypeDeletedHandler = null;

	// StringCol Response Handlers
	private CFBamXMsgRspnStringColRecHandler rspnStringColRecHandler = null;
	private CFBamXMsgRspnStringColCreatedHandler rspnStringColCreatedHandler = null;
	private CFBamXMsgRspnStringColReadSingleHandler rspnStringColReadSingleHandler = null;
	private CFBamXMsgRspnStringColReadListHandler rspnStringColReadListHandler = null;
	private CFBamXMsgRspnStringColLockedHandler rspnStringColLockedHandler = null;
	private CFBamXMsgRspnStringColUpdatedHandler rspnStringColUpdatedHandler = null;
	private CFBamXMsgRspnStringColDeletedHandler rspnStringColDeletedHandler = null;

	// StringDef Response Handlers
	private CFBamXMsgRspnStringDefRecHandler rspnStringDefRecHandler = null;
	private CFBamXMsgRspnStringDefCreatedHandler rspnStringDefCreatedHandler = null;
	private CFBamXMsgRspnStringDefReadSingleHandler rspnStringDefReadSingleHandler = null;
	private CFBamXMsgRspnStringDefReadListHandler rspnStringDefReadListHandler = null;
	private CFBamXMsgRspnStringDefLockedHandler rspnStringDefLockedHandler = null;
	private CFBamXMsgRspnStringDefUpdatedHandler rspnStringDefUpdatedHandler = null;
	private CFBamXMsgRspnStringDefDeletedHandler rspnStringDefDeletedHandler = null;

	// StringType Response Handlers
	private CFBamXMsgRspnStringTypeRecHandler rspnStringTypeRecHandler = null;
	private CFBamXMsgRspnStringTypeCreatedHandler rspnStringTypeCreatedHandler = null;
	private CFBamXMsgRspnStringTypeReadSingleHandler rspnStringTypeReadSingleHandler = null;
	private CFBamXMsgRspnStringTypeReadListHandler rspnStringTypeReadListHandler = null;
	private CFBamXMsgRspnStringTypeLockedHandler rspnStringTypeLockedHandler = null;
	private CFBamXMsgRspnStringTypeUpdatedHandler rspnStringTypeUpdatedHandler = null;
	private CFBamXMsgRspnStringTypeDeletedHandler rspnStringTypeDeletedHandler = null;

	// SubProject Response Handlers
	private CFBamXMsgRspnSubProjectRecHandler rspnSubProjectRecHandler = null;
	private CFBamXMsgRspnSubProjectCreatedHandler rspnSubProjectCreatedHandler = null;
	private CFBamXMsgRspnSubProjectReadSingleHandler rspnSubProjectReadSingleHandler = null;
	private CFBamXMsgRspnSubProjectReadListHandler rspnSubProjectReadListHandler = null;
	private CFBamXMsgRspnSubProjectLockedHandler rspnSubProjectLockedHandler = null;
	private CFBamXMsgRspnSubProjectUpdatedHandler rspnSubProjectUpdatedHandler = null;
	private CFBamXMsgRspnSubProjectDeletedHandler rspnSubProjectDeletedHandler = null;

	// SysCluster Response Handlers
	private CFBamXMsgRspnSysClusterRecHandler rspnSysClusterRecHandler = null;
	private CFBamXMsgRspnSysClusterCreatedHandler rspnSysClusterCreatedHandler = null;
	private CFBamXMsgRspnSysClusterReadSingleHandler rspnSysClusterReadSingleHandler = null;
	private CFBamXMsgRspnSysClusterReadListHandler rspnSysClusterReadListHandler = null;
	private CFBamXMsgRspnSysClusterLockedHandler rspnSysClusterLockedHandler = null;
	private CFBamXMsgRspnSysClusterUpdatedHandler rspnSysClusterUpdatedHandler = null;
	private CFBamXMsgRspnSysClusterDeletedHandler rspnSysClusterDeletedHandler = null;

	// TSecGroup Response Handlers
	private CFBamXMsgRspnTSecGroupRecHandler rspnTSecGroupRecHandler = null;
	private CFBamXMsgRspnTSecGroupCreatedHandler rspnTSecGroupCreatedHandler = null;
	private CFBamXMsgRspnTSecGroupReadSingleHandler rspnTSecGroupReadSingleHandler = null;
	private CFBamXMsgRspnTSecGroupReadListHandler rspnTSecGroupReadListHandler = null;
	private CFBamXMsgRspnTSecGroupLockedHandler rspnTSecGroupLockedHandler = null;
	private CFBamXMsgRspnTSecGroupUpdatedHandler rspnTSecGroupUpdatedHandler = null;
	private CFBamXMsgRspnTSecGroupDeletedHandler rspnTSecGroupDeletedHandler = null;

	// TSecGroupInclude Response Handlers
	private CFBamXMsgRspnTSecGroupIncludeRecHandler rspnTSecGroupIncludeRecHandler = null;
	private CFBamXMsgRspnTSecGroupIncludeCreatedHandler rspnTSecGroupIncludeCreatedHandler = null;
	private CFBamXMsgRspnTSecGroupIncludeReadSingleHandler rspnTSecGroupIncludeReadSingleHandler = null;
	private CFBamXMsgRspnTSecGroupIncludeReadListHandler rspnTSecGroupIncludeReadListHandler = null;
	private CFBamXMsgRspnTSecGroupIncludeLockedHandler rspnTSecGroupIncludeLockedHandler = null;
	private CFBamXMsgRspnTSecGroupIncludeUpdatedHandler rspnTSecGroupIncludeUpdatedHandler = null;
	private CFBamXMsgRspnTSecGroupIncludeDeletedHandler rspnTSecGroupIncludeDeletedHandler = null;

	// TSecGroupMember Response Handlers
	private CFBamXMsgRspnTSecGroupMemberRecHandler rspnTSecGroupMemberRecHandler = null;
	private CFBamXMsgRspnTSecGroupMemberCreatedHandler rspnTSecGroupMemberCreatedHandler = null;
	private CFBamXMsgRspnTSecGroupMemberReadSingleHandler rspnTSecGroupMemberReadSingleHandler = null;
	private CFBamXMsgRspnTSecGroupMemberReadListHandler rspnTSecGroupMemberReadListHandler = null;
	private CFBamXMsgRspnTSecGroupMemberLockedHandler rspnTSecGroupMemberLockedHandler = null;
	private CFBamXMsgRspnTSecGroupMemberUpdatedHandler rspnTSecGroupMemberUpdatedHandler = null;
	private CFBamXMsgRspnTSecGroupMemberDeletedHandler rspnTSecGroupMemberDeletedHandler = null;

	// TZDateCol Response Handlers
	private CFBamXMsgRspnTZDateColRecHandler rspnTZDateColRecHandler = null;
	private CFBamXMsgRspnTZDateColCreatedHandler rspnTZDateColCreatedHandler = null;
	private CFBamXMsgRspnTZDateColReadSingleHandler rspnTZDateColReadSingleHandler = null;
	private CFBamXMsgRspnTZDateColReadListHandler rspnTZDateColReadListHandler = null;
	private CFBamXMsgRspnTZDateColLockedHandler rspnTZDateColLockedHandler = null;
	private CFBamXMsgRspnTZDateColUpdatedHandler rspnTZDateColUpdatedHandler = null;
	private CFBamXMsgRspnTZDateColDeletedHandler rspnTZDateColDeletedHandler = null;

	// TZDateDef Response Handlers
	private CFBamXMsgRspnTZDateDefRecHandler rspnTZDateDefRecHandler = null;
	private CFBamXMsgRspnTZDateDefCreatedHandler rspnTZDateDefCreatedHandler = null;
	private CFBamXMsgRspnTZDateDefReadSingleHandler rspnTZDateDefReadSingleHandler = null;
	private CFBamXMsgRspnTZDateDefReadListHandler rspnTZDateDefReadListHandler = null;
	private CFBamXMsgRspnTZDateDefLockedHandler rspnTZDateDefLockedHandler = null;
	private CFBamXMsgRspnTZDateDefUpdatedHandler rspnTZDateDefUpdatedHandler = null;
	private CFBamXMsgRspnTZDateDefDeletedHandler rspnTZDateDefDeletedHandler = null;

	// TZDateType Response Handlers
	private CFBamXMsgRspnTZDateTypeRecHandler rspnTZDateTypeRecHandler = null;
	private CFBamXMsgRspnTZDateTypeCreatedHandler rspnTZDateTypeCreatedHandler = null;
	private CFBamXMsgRspnTZDateTypeReadSingleHandler rspnTZDateTypeReadSingleHandler = null;
	private CFBamXMsgRspnTZDateTypeReadListHandler rspnTZDateTypeReadListHandler = null;
	private CFBamXMsgRspnTZDateTypeLockedHandler rspnTZDateTypeLockedHandler = null;
	private CFBamXMsgRspnTZDateTypeUpdatedHandler rspnTZDateTypeUpdatedHandler = null;
	private CFBamXMsgRspnTZDateTypeDeletedHandler rspnTZDateTypeDeletedHandler = null;

	// TZTimeCol Response Handlers
	private CFBamXMsgRspnTZTimeColRecHandler rspnTZTimeColRecHandler = null;
	private CFBamXMsgRspnTZTimeColCreatedHandler rspnTZTimeColCreatedHandler = null;
	private CFBamXMsgRspnTZTimeColReadSingleHandler rspnTZTimeColReadSingleHandler = null;
	private CFBamXMsgRspnTZTimeColReadListHandler rspnTZTimeColReadListHandler = null;
	private CFBamXMsgRspnTZTimeColLockedHandler rspnTZTimeColLockedHandler = null;
	private CFBamXMsgRspnTZTimeColUpdatedHandler rspnTZTimeColUpdatedHandler = null;
	private CFBamXMsgRspnTZTimeColDeletedHandler rspnTZTimeColDeletedHandler = null;

	// TZTimeDef Response Handlers
	private CFBamXMsgRspnTZTimeDefRecHandler rspnTZTimeDefRecHandler = null;
	private CFBamXMsgRspnTZTimeDefCreatedHandler rspnTZTimeDefCreatedHandler = null;
	private CFBamXMsgRspnTZTimeDefReadSingleHandler rspnTZTimeDefReadSingleHandler = null;
	private CFBamXMsgRspnTZTimeDefReadListHandler rspnTZTimeDefReadListHandler = null;
	private CFBamXMsgRspnTZTimeDefLockedHandler rspnTZTimeDefLockedHandler = null;
	private CFBamXMsgRspnTZTimeDefUpdatedHandler rspnTZTimeDefUpdatedHandler = null;
	private CFBamXMsgRspnTZTimeDefDeletedHandler rspnTZTimeDefDeletedHandler = null;

	// TZTimeType Response Handlers
	private CFBamXMsgRspnTZTimeTypeRecHandler rspnTZTimeTypeRecHandler = null;
	private CFBamXMsgRspnTZTimeTypeCreatedHandler rspnTZTimeTypeCreatedHandler = null;
	private CFBamXMsgRspnTZTimeTypeReadSingleHandler rspnTZTimeTypeReadSingleHandler = null;
	private CFBamXMsgRspnTZTimeTypeReadListHandler rspnTZTimeTypeReadListHandler = null;
	private CFBamXMsgRspnTZTimeTypeLockedHandler rspnTZTimeTypeLockedHandler = null;
	private CFBamXMsgRspnTZTimeTypeUpdatedHandler rspnTZTimeTypeUpdatedHandler = null;
	private CFBamXMsgRspnTZTimeTypeDeletedHandler rspnTZTimeTypeDeletedHandler = null;

	// TZTimestampCol Response Handlers
	private CFBamXMsgRspnTZTimestampColRecHandler rspnTZTimestampColRecHandler = null;
	private CFBamXMsgRspnTZTimestampColCreatedHandler rspnTZTimestampColCreatedHandler = null;
	private CFBamXMsgRspnTZTimestampColReadSingleHandler rspnTZTimestampColReadSingleHandler = null;
	private CFBamXMsgRspnTZTimestampColReadListHandler rspnTZTimestampColReadListHandler = null;
	private CFBamXMsgRspnTZTimestampColLockedHandler rspnTZTimestampColLockedHandler = null;
	private CFBamXMsgRspnTZTimestampColUpdatedHandler rspnTZTimestampColUpdatedHandler = null;
	private CFBamXMsgRspnTZTimestampColDeletedHandler rspnTZTimestampColDeletedHandler = null;

	// TZTimestampDef Response Handlers
	private CFBamXMsgRspnTZTimestampDefRecHandler rspnTZTimestampDefRecHandler = null;
	private CFBamXMsgRspnTZTimestampDefCreatedHandler rspnTZTimestampDefCreatedHandler = null;
	private CFBamXMsgRspnTZTimestampDefReadSingleHandler rspnTZTimestampDefReadSingleHandler = null;
	private CFBamXMsgRspnTZTimestampDefReadListHandler rspnTZTimestampDefReadListHandler = null;
	private CFBamXMsgRspnTZTimestampDefLockedHandler rspnTZTimestampDefLockedHandler = null;
	private CFBamXMsgRspnTZTimestampDefUpdatedHandler rspnTZTimestampDefUpdatedHandler = null;
	private CFBamXMsgRspnTZTimestampDefDeletedHandler rspnTZTimestampDefDeletedHandler = null;

	// TZTimestampType Response Handlers
	private CFBamXMsgRspnTZTimestampTypeRecHandler rspnTZTimestampTypeRecHandler = null;
	private CFBamXMsgRspnTZTimestampTypeCreatedHandler rspnTZTimestampTypeCreatedHandler = null;
	private CFBamXMsgRspnTZTimestampTypeReadSingleHandler rspnTZTimestampTypeReadSingleHandler = null;
	private CFBamXMsgRspnTZTimestampTypeReadListHandler rspnTZTimestampTypeReadListHandler = null;
	private CFBamXMsgRspnTZTimestampTypeLockedHandler rspnTZTimestampTypeLockedHandler = null;
	private CFBamXMsgRspnTZTimestampTypeUpdatedHandler rspnTZTimestampTypeUpdatedHandler = null;
	private CFBamXMsgRspnTZTimestampTypeDeletedHandler rspnTZTimestampTypeDeletedHandler = null;

	// Table Response Handlers
	private CFBamXMsgRspnTableRecHandler rspnTableRecHandler = null;
	private CFBamXMsgRspnTableCreatedHandler rspnTableCreatedHandler = null;
	private CFBamXMsgRspnTableReadSingleHandler rspnTableReadSingleHandler = null;
	private CFBamXMsgRspnTableReadListHandler rspnTableReadListHandler = null;
	private CFBamXMsgRspnTableLockedHandler rspnTableLockedHandler = null;
	private CFBamXMsgRspnTableUpdatedHandler rspnTableUpdatedHandler = null;
	private CFBamXMsgRspnTableDeletedHandler rspnTableDeletedHandler = null;

	// TableCol Response Handlers
	private CFBamXMsgRspnTableColRecHandler rspnTableColRecHandler = null;
	private CFBamXMsgRspnTableColCreatedHandler rspnTableColCreatedHandler = null;
	private CFBamXMsgRspnTableColReadSingleHandler rspnTableColReadSingleHandler = null;
	private CFBamXMsgRspnTableColReadListHandler rspnTableColReadListHandler = null;
	private CFBamXMsgRspnTableColLockedHandler rspnTableColLockedHandler = null;
	private CFBamXMsgRspnTableColUpdatedHandler rspnTableColUpdatedHandler = null;
	private CFBamXMsgRspnTableColDeletedHandler rspnTableColDeletedHandler = null;

	// Tenant Response Handlers
	private CFBamXMsgRspnTenantRecHandler rspnTenantRecHandler = null;
	private CFBamXMsgRspnTenantCreatedHandler rspnTenantCreatedHandler = null;
	private CFBamXMsgRspnTenantReadSingleHandler rspnTenantReadSingleHandler = null;
	private CFBamXMsgRspnTenantReadListHandler rspnTenantReadListHandler = null;
	private CFBamXMsgRspnTenantLockedHandler rspnTenantLockedHandler = null;
	private CFBamXMsgRspnTenantUpdatedHandler rspnTenantUpdatedHandler = null;
	private CFBamXMsgRspnTenantDeletedHandler rspnTenantDeletedHandler = null;

	// TextCol Response Handlers
	private CFBamXMsgRspnTextColRecHandler rspnTextColRecHandler = null;
	private CFBamXMsgRspnTextColCreatedHandler rspnTextColCreatedHandler = null;
	private CFBamXMsgRspnTextColReadSingleHandler rspnTextColReadSingleHandler = null;
	private CFBamXMsgRspnTextColReadListHandler rspnTextColReadListHandler = null;
	private CFBamXMsgRspnTextColLockedHandler rspnTextColLockedHandler = null;
	private CFBamXMsgRspnTextColUpdatedHandler rspnTextColUpdatedHandler = null;
	private CFBamXMsgRspnTextColDeletedHandler rspnTextColDeletedHandler = null;

	// TextDef Response Handlers
	private CFBamXMsgRspnTextDefRecHandler rspnTextDefRecHandler = null;
	private CFBamXMsgRspnTextDefCreatedHandler rspnTextDefCreatedHandler = null;
	private CFBamXMsgRspnTextDefReadSingleHandler rspnTextDefReadSingleHandler = null;
	private CFBamXMsgRspnTextDefReadListHandler rspnTextDefReadListHandler = null;
	private CFBamXMsgRspnTextDefLockedHandler rspnTextDefLockedHandler = null;
	private CFBamXMsgRspnTextDefUpdatedHandler rspnTextDefUpdatedHandler = null;
	private CFBamXMsgRspnTextDefDeletedHandler rspnTextDefDeletedHandler = null;

	// TextType Response Handlers
	private CFBamXMsgRspnTextTypeRecHandler rspnTextTypeRecHandler = null;
	private CFBamXMsgRspnTextTypeCreatedHandler rspnTextTypeCreatedHandler = null;
	private CFBamXMsgRspnTextTypeReadSingleHandler rspnTextTypeReadSingleHandler = null;
	private CFBamXMsgRspnTextTypeReadListHandler rspnTextTypeReadListHandler = null;
	private CFBamXMsgRspnTextTypeLockedHandler rspnTextTypeLockedHandler = null;
	private CFBamXMsgRspnTextTypeUpdatedHandler rspnTextTypeUpdatedHandler = null;
	private CFBamXMsgRspnTextTypeDeletedHandler rspnTextTypeDeletedHandler = null;

	// TimeCol Response Handlers
	private CFBamXMsgRspnTimeColRecHandler rspnTimeColRecHandler = null;
	private CFBamXMsgRspnTimeColCreatedHandler rspnTimeColCreatedHandler = null;
	private CFBamXMsgRspnTimeColReadSingleHandler rspnTimeColReadSingleHandler = null;
	private CFBamXMsgRspnTimeColReadListHandler rspnTimeColReadListHandler = null;
	private CFBamXMsgRspnTimeColLockedHandler rspnTimeColLockedHandler = null;
	private CFBamXMsgRspnTimeColUpdatedHandler rspnTimeColUpdatedHandler = null;
	private CFBamXMsgRspnTimeColDeletedHandler rspnTimeColDeletedHandler = null;

	// TimeDef Response Handlers
	private CFBamXMsgRspnTimeDefRecHandler rspnTimeDefRecHandler = null;
	private CFBamXMsgRspnTimeDefCreatedHandler rspnTimeDefCreatedHandler = null;
	private CFBamXMsgRspnTimeDefReadSingleHandler rspnTimeDefReadSingleHandler = null;
	private CFBamXMsgRspnTimeDefReadListHandler rspnTimeDefReadListHandler = null;
	private CFBamXMsgRspnTimeDefLockedHandler rspnTimeDefLockedHandler = null;
	private CFBamXMsgRspnTimeDefUpdatedHandler rspnTimeDefUpdatedHandler = null;
	private CFBamXMsgRspnTimeDefDeletedHandler rspnTimeDefDeletedHandler = null;

	// TimeType Response Handlers
	private CFBamXMsgRspnTimeTypeRecHandler rspnTimeTypeRecHandler = null;
	private CFBamXMsgRspnTimeTypeCreatedHandler rspnTimeTypeCreatedHandler = null;
	private CFBamXMsgRspnTimeTypeReadSingleHandler rspnTimeTypeReadSingleHandler = null;
	private CFBamXMsgRspnTimeTypeReadListHandler rspnTimeTypeReadListHandler = null;
	private CFBamXMsgRspnTimeTypeLockedHandler rspnTimeTypeLockedHandler = null;
	private CFBamXMsgRspnTimeTypeUpdatedHandler rspnTimeTypeUpdatedHandler = null;
	private CFBamXMsgRspnTimeTypeDeletedHandler rspnTimeTypeDeletedHandler = null;

	// TimestampCol Response Handlers
	private CFBamXMsgRspnTimestampColRecHandler rspnTimestampColRecHandler = null;
	private CFBamXMsgRspnTimestampColCreatedHandler rspnTimestampColCreatedHandler = null;
	private CFBamXMsgRspnTimestampColReadSingleHandler rspnTimestampColReadSingleHandler = null;
	private CFBamXMsgRspnTimestampColReadListHandler rspnTimestampColReadListHandler = null;
	private CFBamXMsgRspnTimestampColLockedHandler rspnTimestampColLockedHandler = null;
	private CFBamXMsgRspnTimestampColUpdatedHandler rspnTimestampColUpdatedHandler = null;
	private CFBamXMsgRspnTimestampColDeletedHandler rspnTimestampColDeletedHandler = null;

	// TimestampDef Response Handlers
	private CFBamXMsgRspnTimestampDefRecHandler rspnTimestampDefRecHandler = null;
	private CFBamXMsgRspnTimestampDefCreatedHandler rspnTimestampDefCreatedHandler = null;
	private CFBamXMsgRspnTimestampDefReadSingleHandler rspnTimestampDefReadSingleHandler = null;
	private CFBamXMsgRspnTimestampDefReadListHandler rspnTimestampDefReadListHandler = null;
	private CFBamXMsgRspnTimestampDefLockedHandler rspnTimestampDefLockedHandler = null;
	private CFBamXMsgRspnTimestampDefUpdatedHandler rspnTimestampDefUpdatedHandler = null;
	private CFBamXMsgRspnTimestampDefDeletedHandler rspnTimestampDefDeletedHandler = null;

	// TimestampType Response Handlers
	private CFBamXMsgRspnTimestampTypeRecHandler rspnTimestampTypeRecHandler = null;
	private CFBamXMsgRspnTimestampTypeCreatedHandler rspnTimestampTypeCreatedHandler = null;
	private CFBamXMsgRspnTimestampTypeReadSingleHandler rspnTimestampTypeReadSingleHandler = null;
	private CFBamXMsgRspnTimestampTypeReadListHandler rspnTimestampTypeReadListHandler = null;
	private CFBamXMsgRspnTimestampTypeLockedHandler rspnTimestampTypeLockedHandler = null;
	private CFBamXMsgRspnTimestampTypeUpdatedHandler rspnTimestampTypeUpdatedHandler = null;
	private CFBamXMsgRspnTimestampTypeDeletedHandler rspnTimestampTypeDeletedHandler = null;

	// Tld Response Handlers
	private CFBamXMsgRspnTldRecHandler rspnTldRecHandler = null;
	private CFBamXMsgRspnTldCreatedHandler rspnTldCreatedHandler = null;
	private CFBamXMsgRspnTldReadSingleHandler rspnTldReadSingleHandler = null;
	private CFBamXMsgRspnTldReadListHandler rspnTldReadListHandler = null;
	private CFBamXMsgRspnTldLockedHandler rspnTldLockedHandler = null;
	private CFBamXMsgRspnTldUpdatedHandler rspnTldUpdatedHandler = null;
	private CFBamXMsgRspnTldDeletedHandler rspnTldDeletedHandler = null;

	// TokenCol Response Handlers
	private CFBamXMsgRspnTokenColRecHandler rspnTokenColRecHandler = null;
	private CFBamXMsgRspnTokenColCreatedHandler rspnTokenColCreatedHandler = null;
	private CFBamXMsgRspnTokenColReadSingleHandler rspnTokenColReadSingleHandler = null;
	private CFBamXMsgRspnTokenColReadListHandler rspnTokenColReadListHandler = null;
	private CFBamXMsgRspnTokenColLockedHandler rspnTokenColLockedHandler = null;
	private CFBamXMsgRspnTokenColUpdatedHandler rspnTokenColUpdatedHandler = null;
	private CFBamXMsgRspnTokenColDeletedHandler rspnTokenColDeletedHandler = null;

	// TokenDef Response Handlers
	private CFBamXMsgRspnTokenDefRecHandler rspnTokenDefRecHandler = null;
	private CFBamXMsgRspnTokenDefCreatedHandler rspnTokenDefCreatedHandler = null;
	private CFBamXMsgRspnTokenDefReadSingleHandler rspnTokenDefReadSingleHandler = null;
	private CFBamXMsgRspnTokenDefReadListHandler rspnTokenDefReadListHandler = null;
	private CFBamXMsgRspnTokenDefLockedHandler rspnTokenDefLockedHandler = null;
	private CFBamXMsgRspnTokenDefUpdatedHandler rspnTokenDefUpdatedHandler = null;
	private CFBamXMsgRspnTokenDefDeletedHandler rspnTokenDefDeletedHandler = null;

	// TokenType Response Handlers
	private CFBamXMsgRspnTokenTypeRecHandler rspnTokenTypeRecHandler = null;
	private CFBamXMsgRspnTokenTypeCreatedHandler rspnTokenTypeCreatedHandler = null;
	private CFBamXMsgRspnTokenTypeReadSingleHandler rspnTokenTypeReadSingleHandler = null;
	private CFBamXMsgRspnTokenTypeReadListHandler rspnTokenTypeReadListHandler = null;
	private CFBamXMsgRspnTokenTypeLockedHandler rspnTokenTypeLockedHandler = null;
	private CFBamXMsgRspnTokenTypeUpdatedHandler rspnTokenTypeUpdatedHandler = null;
	private CFBamXMsgRspnTokenTypeDeletedHandler rspnTokenTypeDeletedHandler = null;

	// TopDomain Response Handlers
	private CFBamXMsgRspnTopDomainRecHandler rspnTopDomainRecHandler = null;
	private CFBamXMsgRspnTopDomainCreatedHandler rspnTopDomainCreatedHandler = null;
	private CFBamXMsgRspnTopDomainReadSingleHandler rspnTopDomainReadSingleHandler = null;
	private CFBamXMsgRspnTopDomainReadListHandler rspnTopDomainReadListHandler = null;
	private CFBamXMsgRspnTopDomainLockedHandler rspnTopDomainLockedHandler = null;
	private CFBamXMsgRspnTopDomainUpdatedHandler rspnTopDomainUpdatedHandler = null;
	private CFBamXMsgRspnTopDomainDeletedHandler rspnTopDomainDeletedHandler = null;

	// TopProject Response Handlers
	private CFBamXMsgRspnTopProjectRecHandler rspnTopProjectRecHandler = null;
	private CFBamXMsgRspnTopProjectCreatedHandler rspnTopProjectCreatedHandler = null;
	private CFBamXMsgRspnTopProjectReadSingleHandler rspnTopProjectReadSingleHandler = null;
	private CFBamXMsgRspnTopProjectReadListHandler rspnTopProjectReadListHandler = null;
	private CFBamXMsgRspnTopProjectLockedHandler rspnTopProjectLockedHandler = null;
	private CFBamXMsgRspnTopProjectUpdatedHandler rspnTopProjectUpdatedHandler = null;
	private CFBamXMsgRspnTopProjectDeletedHandler rspnTopProjectDeletedHandler = null;

	// UInt16Col Response Handlers
	private CFBamXMsgRspnUInt16ColRecHandler rspnUInt16ColRecHandler = null;
	private CFBamXMsgRspnUInt16ColCreatedHandler rspnUInt16ColCreatedHandler = null;
	private CFBamXMsgRspnUInt16ColReadSingleHandler rspnUInt16ColReadSingleHandler = null;
	private CFBamXMsgRspnUInt16ColReadListHandler rspnUInt16ColReadListHandler = null;
	private CFBamXMsgRspnUInt16ColLockedHandler rspnUInt16ColLockedHandler = null;
	private CFBamXMsgRspnUInt16ColUpdatedHandler rspnUInt16ColUpdatedHandler = null;
	private CFBamXMsgRspnUInt16ColDeletedHandler rspnUInt16ColDeletedHandler = null;

	// UInt16Def Response Handlers
	private CFBamXMsgRspnUInt16DefRecHandler rspnUInt16DefRecHandler = null;
	private CFBamXMsgRspnUInt16DefCreatedHandler rspnUInt16DefCreatedHandler = null;
	private CFBamXMsgRspnUInt16DefReadSingleHandler rspnUInt16DefReadSingleHandler = null;
	private CFBamXMsgRspnUInt16DefReadListHandler rspnUInt16DefReadListHandler = null;
	private CFBamXMsgRspnUInt16DefLockedHandler rspnUInt16DefLockedHandler = null;
	private CFBamXMsgRspnUInt16DefUpdatedHandler rspnUInt16DefUpdatedHandler = null;
	private CFBamXMsgRspnUInt16DefDeletedHandler rspnUInt16DefDeletedHandler = null;

	// UInt16Type Response Handlers
	private CFBamXMsgRspnUInt16TypeRecHandler rspnUInt16TypeRecHandler = null;
	private CFBamXMsgRspnUInt16TypeCreatedHandler rspnUInt16TypeCreatedHandler = null;
	private CFBamXMsgRspnUInt16TypeReadSingleHandler rspnUInt16TypeReadSingleHandler = null;
	private CFBamXMsgRspnUInt16TypeReadListHandler rspnUInt16TypeReadListHandler = null;
	private CFBamXMsgRspnUInt16TypeLockedHandler rspnUInt16TypeLockedHandler = null;
	private CFBamXMsgRspnUInt16TypeUpdatedHandler rspnUInt16TypeUpdatedHandler = null;
	private CFBamXMsgRspnUInt16TypeDeletedHandler rspnUInt16TypeDeletedHandler = null;

	// UInt32Col Response Handlers
	private CFBamXMsgRspnUInt32ColRecHandler rspnUInt32ColRecHandler = null;
	private CFBamXMsgRspnUInt32ColCreatedHandler rspnUInt32ColCreatedHandler = null;
	private CFBamXMsgRspnUInt32ColReadSingleHandler rspnUInt32ColReadSingleHandler = null;
	private CFBamXMsgRspnUInt32ColReadListHandler rspnUInt32ColReadListHandler = null;
	private CFBamXMsgRspnUInt32ColLockedHandler rspnUInt32ColLockedHandler = null;
	private CFBamXMsgRspnUInt32ColUpdatedHandler rspnUInt32ColUpdatedHandler = null;
	private CFBamXMsgRspnUInt32ColDeletedHandler rspnUInt32ColDeletedHandler = null;

	// UInt32Def Response Handlers
	private CFBamXMsgRspnUInt32DefRecHandler rspnUInt32DefRecHandler = null;
	private CFBamXMsgRspnUInt32DefCreatedHandler rspnUInt32DefCreatedHandler = null;
	private CFBamXMsgRspnUInt32DefReadSingleHandler rspnUInt32DefReadSingleHandler = null;
	private CFBamXMsgRspnUInt32DefReadListHandler rspnUInt32DefReadListHandler = null;
	private CFBamXMsgRspnUInt32DefLockedHandler rspnUInt32DefLockedHandler = null;
	private CFBamXMsgRspnUInt32DefUpdatedHandler rspnUInt32DefUpdatedHandler = null;
	private CFBamXMsgRspnUInt32DefDeletedHandler rspnUInt32DefDeletedHandler = null;

	// UInt32Type Response Handlers
	private CFBamXMsgRspnUInt32TypeRecHandler rspnUInt32TypeRecHandler = null;
	private CFBamXMsgRspnUInt32TypeCreatedHandler rspnUInt32TypeCreatedHandler = null;
	private CFBamXMsgRspnUInt32TypeReadSingleHandler rspnUInt32TypeReadSingleHandler = null;
	private CFBamXMsgRspnUInt32TypeReadListHandler rspnUInt32TypeReadListHandler = null;
	private CFBamXMsgRspnUInt32TypeLockedHandler rspnUInt32TypeLockedHandler = null;
	private CFBamXMsgRspnUInt32TypeUpdatedHandler rspnUInt32TypeUpdatedHandler = null;
	private CFBamXMsgRspnUInt32TypeDeletedHandler rspnUInt32TypeDeletedHandler = null;

	// UInt64Col Response Handlers
	private CFBamXMsgRspnUInt64ColRecHandler rspnUInt64ColRecHandler = null;
	private CFBamXMsgRspnUInt64ColCreatedHandler rspnUInt64ColCreatedHandler = null;
	private CFBamXMsgRspnUInt64ColReadSingleHandler rspnUInt64ColReadSingleHandler = null;
	private CFBamXMsgRspnUInt64ColReadListHandler rspnUInt64ColReadListHandler = null;
	private CFBamXMsgRspnUInt64ColLockedHandler rspnUInt64ColLockedHandler = null;
	private CFBamXMsgRspnUInt64ColUpdatedHandler rspnUInt64ColUpdatedHandler = null;
	private CFBamXMsgRspnUInt64ColDeletedHandler rspnUInt64ColDeletedHandler = null;

	// UInt64Def Response Handlers
	private CFBamXMsgRspnUInt64DefRecHandler rspnUInt64DefRecHandler = null;
	private CFBamXMsgRspnUInt64DefCreatedHandler rspnUInt64DefCreatedHandler = null;
	private CFBamXMsgRspnUInt64DefReadSingleHandler rspnUInt64DefReadSingleHandler = null;
	private CFBamXMsgRspnUInt64DefReadListHandler rspnUInt64DefReadListHandler = null;
	private CFBamXMsgRspnUInt64DefLockedHandler rspnUInt64DefLockedHandler = null;
	private CFBamXMsgRspnUInt64DefUpdatedHandler rspnUInt64DefUpdatedHandler = null;
	private CFBamXMsgRspnUInt64DefDeletedHandler rspnUInt64DefDeletedHandler = null;

	// UInt64Type Response Handlers
	private CFBamXMsgRspnUInt64TypeRecHandler rspnUInt64TypeRecHandler = null;
	private CFBamXMsgRspnUInt64TypeCreatedHandler rspnUInt64TypeCreatedHandler = null;
	private CFBamXMsgRspnUInt64TypeReadSingleHandler rspnUInt64TypeReadSingleHandler = null;
	private CFBamXMsgRspnUInt64TypeReadListHandler rspnUInt64TypeReadListHandler = null;
	private CFBamXMsgRspnUInt64TypeLockedHandler rspnUInt64TypeLockedHandler = null;
	private CFBamXMsgRspnUInt64TypeUpdatedHandler rspnUInt64TypeUpdatedHandler = null;
	private CFBamXMsgRspnUInt64TypeDeletedHandler rspnUInt64TypeDeletedHandler = null;

	// URLProtocol Response Handlers
	private CFBamXMsgRspnURLProtocolRecHandler rspnURLProtocolRecHandler = null;
	private CFBamXMsgRspnURLProtocolCreatedHandler rspnURLProtocolCreatedHandler = null;
	private CFBamXMsgRspnURLProtocolReadSingleHandler rspnURLProtocolReadSingleHandler = null;
	private CFBamXMsgRspnURLProtocolReadListHandler rspnURLProtocolReadListHandler = null;
	private CFBamXMsgRspnURLProtocolLockedHandler rspnURLProtocolLockedHandler = null;
	private CFBamXMsgRspnURLProtocolUpdatedHandler rspnURLProtocolUpdatedHandler = null;
	private CFBamXMsgRspnURLProtocolDeletedHandler rspnURLProtocolDeletedHandler = null;

	// UuidCol Response Handlers
	private CFBamXMsgRspnUuidColRecHandler rspnUuidColRecHandler = null;
	private CFBamXMsgRspnUuidColCreatedHandler rspnUuidColCreatedHandler = null;
	private CFBamXMsgRspnUuidColReadSingleHandler rspnUuidColReadSingleHandler = null;
	private CFBamXMsgRspnUuidColReadListHandler rspnUuidColReadListHandler = null;
	private CFBamXMsgRspnUuidColLockedHandler rspnUuidColLockedHandler = null;
	private CFBamXMsgRspnUuidColUpdatedHandler rspnUuidColUpdatedHandler = null;
	private CFBamXMsgRspnUuidColDeletedHandler rspnUuidColDeletedHandler = null;

	// UuidDef Response Handlers
	private CFBamXMsgRspnUuidDefRecHandler rspnUuidDefRecHandler = null;
	private CFBamXMsgRspnUuidDefCreatedHandler rspnUuidDefCreatedHandler = null;
	private CFBamXMsgRspnUuidDefReadSingleHandler rspnUuidDefReadSingleHandler = null;
	private CFBamXMsgRspnUuidDefReadListHandler rspnUuidDefReadListHandler = null;
	private CFBamXMsgRspnUuidDefLockedHandler rspnUuidDefLockedHandler = null;
	private CFBamXMsgRspnUuidDefUpdatedHandler rspnUuidDefUpdatedHandler = null;
	private CFBamXMsgRspnUuidDefDeletedHandler rspnUuidDefDeletedHandler = null;

	// UuidGen Response Handlers
	private CFBamXMsgRspnUuidGenRecHandler rspnUuidGenRecHandler = null;
	private CFBamXMsgRspnUuidGenCreatedHandler rspnUuidGenCreatedHandler = null;
	private CFBamXMsgRspnUuidGenReadSingleHandler rspnUuidGenReadSingleHandler = null;
	private CFBamXMsgRspnUuidGenReadListHandler rspnUuidGenReadListHandler = null;
	private CFBamXMsgRspnUuidGenLockedHandler rspnUuidGenLockedHandler = null;
	private CFBamXMsgRspnUuidGenUpdatedHandler rspnUuidGenUpdatedHandler = null;
	private CFBamXMsgRspnUuidGenDeletedHandler rspnUuidGenDeletedHandler = null;

	// UuidType Response Handlers
	private CFBamXMsgRspnUuidTypeRecHandler rspnUuidTypeRecHandler = null;
	private CFBamXMsgRspnUuidTypeCreatedHandler rspnUuidTypeCreatedHandler = null;
	private CFBamXMsgRspnUuidTypeReadSingleHandler rspnUuidTypeReadSingleHandler = null;
	private CFBamXMsgRspnUuidTypeReadListHandler rspnUuidTypeReadListHandler = null;
	private CFBamXMsgRspnUuidTypeLockedHandler rspnUuidTypeLockedHandler = null;
	private CFBamXMsgRspnUuidTypeUpdatedHandler rspnUuidTypeUpdatedHandler = null;
	private CFBamXMsgRspnUuidTypeDeletedHandler rspnUuidTypeDeletedHandler = null;

	// Value Response Handlers
	private CFBamXMsgRspnValueRecHandler rspnValueRecHandler = null;
	private CFBamXMsgRspnValueCreatedHandler rspnValueCreatedHandler = null;
	private CFBamXMsgRspnValueReadSingleHandler rspnValueReadSingleHandler = null;
	private CFBamXMsgRspnValueReadListHandler rspnValueReadListHandler = null;
	private CFBamXMsgRspnValueLockedHandler rspnValueLockedHandler = null;
	private CFBamXMsgRspnValueUpdatedHandler rspnValueUpdatedHandler = null;
	private CFBamXMsgRspnValueDeletedHandler rspnValueDeletedHandler = null;

	// Version Response Handlers
	private CFBamXMsgRspnVersionRecHandler rspnVersionRecHandler = null;
	private CFBamXMsgRspnVersionCreatedHandler rspnVersionCreatedHandler = null;
	private CFBamXMsgRspnVersionReadSingleHandler rspnVersionReadSingleHandler = null;
	private CFBamXMsgRspnVersionReadListHandler rspnVersionReadListHandler = null;
	private CFBamXMsgRspnVersionLockedHandler rspnVersionLockedHandler = null;
	private CFBamXMsgRspnVersionUpdatedHandler rspnVersionUpdatedHandler = null;
	private CFBamXMsgRspnVersionDeletedHandler rspnVersionDeletedHandler = null;
	private CFBamSaxRspnRootHandler saxRootHandler = null;

	private CFBamSaxRspnDocHandler saxDocHandler = null;

	// Schema object accessors

	// SchemaObj accessors

	public ICFBamSchemaObj getSchemaObj() {
		return( schemaObj );
	}

	public void setSchemaObj( ICFBamSchemaObj value ) {
		schemaObj = value;
	}

	// Result accessors

	public String getLogContents() {
		return( logContents);
	}

	public void setLogContents( String value ) {
		logContents = value;
	}

	public boolean getDataChanged() {
		return( dataChanged);
	}

	public void setDataChanged( boolean value ) {
		dataChanged = value;
	}

	public boolean getDeleted() {
		return( deleted );
	}

	public void setDeleted( boolean flag ) {
		deleted = flag;
	}

	public CFLibRuntimeException getExceptionRaised() {
		return( exceptionRaised );
	}

	public void setExceptionRaised( CFLibRuntimeException obj ) {
		exceptionRaised = obj;
	}

	public Object getLastObjectProcessed() {
		return( lastObjectProcessed );
	}

	public void setLastObjectProcessed( Object obj ) {
		lastObjectProcessed = obj;
	}

	public Object getListOfObjects() {
		return( sortedListOfObjects );
	}

	public void setListOfObjects( Object obj ) {
		sortedListOfObjects = obj;
	}

	// Element Handler Resolver Factories

	protected CFBamXMsgRspnNoDataFoundHandler getRspnNoDataFoundHandler() {
		if( rspnNoDataFoundHandler == null ) {
			rspnNoDataFoundHandler = new CFBamXMsgRspnNoDataFoundHandler( this );
		}
		return( rspnNoDataFoundHandler );
	}

	protected CFBamXMsgRspnExceptionHandler getRspnExceptionHandler() {
		if( rspnExceptionHandler == null ) {
			rspnExceptionHandler = new CFBamXMsgRspnExceptionHandler( this );
		}
		return( rspnExceptionHandler );
	}

	protected CFBamXMsgRspnFileLoadedHandler getRspnFileLoadedHandler() {
		if( rspnFileLoadedHandler == null ) {
			rspnFileLoadedHandler = new CFBamXMsgRspnFileLoadedHandler( this );
		}
		return( rspnFileLoadedHandler );
	}

	protected CFBamXMsgRspnLoggedInHandler getRspnLoggedInHandler() {
		if( rspnLoggedInHandler == null ) {
			rspnLoggedInHandler = new CFBamXMsgRspnLoggedInHandler( this );
		}
		return( rspnLoggedInHandler );
	}

	protected CFBamXMsgRspnLoggedOutHandler getRspnLoggedOutHandler() {
		if( rspnLoggedOutHandler == null ) {
			rspnLoggedOutHandler = new CFBamXMsgRspnLoggedOutHandler( this );
		}
		return( rspnLoggedOutHandler );
	}

	protected CFBamXMsgRspnServerProcExecutedHandler getRspnServerProcExecutedHandler() {
		if( rspnServerProcExecutedHandler == null ) {
			rspnServerProcExecutedHandler = new CFBamXMsgRspnServerProcExecutedHandler( this );
		}
		return( rspnServerProcExecutedHandler );
	}

	// AccessFrequency Response Handlers

	protected CFBamXMsgRspnAccessFrequencyRecHandler getRspnAccessFrequencyRecHandler() {
		if( rspnAccessFrequencyRecHandler == null ) {
			rspnAccessFrequencyRecHandler = new CFBamXMsgRspnAccessFrequencyRecHandler( this );
		}
		return( rspnAccessFrequencyRecHandler );
	}

	protected CFBamXMsgRspnAccessFrequencyCreatedHandler getRspnAccessFrequencyCreatedHandler() {
		if( rspnAccessFrequencyCreatedHandler == null ) {
			rspnAccessFrequencyCreatedHandler = new CFBamXMsgRspnAccessFrequencyCreatedHandler( this );
		}
		return( rspnAccessFrequencyCreatedHandler );
	}

	protected CFBamXMsgRspnAccessFrequencyReadSingleHandler getRspnAccessFrequencyReadSingleHandler() {
		if( rspnAccessFrequencyReadSingleHandler == null ) {
			rspnAccessFrequencyReadSingleHandler = new CFBamXMsgRspnAccessFrequencyReadSingleHandler( this );
			rspnAccessFrequencyReadSingleHandler.addElementHandler( "AccessFrequency", getRspnAccessFrequencyRecHandler() );
		}
		return( rspnAccessFrequencyReadSingleHandler );
	}

	protected CFBamXMsgRspnAccessFrequencyReadListHandler getRspnAccessFrequencyReadListHandler() {
		if( rspnAccessFrequencyReadListHandler == null ) {
			rspnAccessFrequencyReadListHandler = new CFBamXMsgRspnAccessFrequencyReadListHandler( this );
			rspnAccessFrequencyReadListHandler.addElementHandler( "AccessFrequency", getRspnAccessFrequencyRecHandler() );
		}
		return( rspnAccessFrequencyReadListHandler );
	}

	protected CFBamXMsgRspnAccessFrequencyLockedHandler getRspnAccessFrequencyLockedHandler() {
		if( rspnAccessFrequencyLockedHandler == null ) {
			rspnAccessFrequencyLockedHandler = new CFBamXMsgRspnAccessFrequencyLockedHandler( this );
		}
		return( rspnAccessFrequencyLockedHandler );
	}

	protected CFBamXMsgRspnAccessFrequencyUpdatedHandler getRspnAccessFrequencyUpdatedHandler() {
		if( rspnAccessFrequencyUpdatedHandler == null ) {
			rspnAccessFrequencyUpdatedHandler = new CFBamXMsgRspnAccessFrequencyUpdatedHandler( this );
		}
		return( rspnAccessFrequencyUpdatedHandler );
	}

	protected CFBamXMsgRspnAccessFrequencyDeletedHandler getRspnAccessFrequencyDeletedHandler() {
		if( rspnAccessFrequencyDeletedHandler == null ) {
			rspnAccessFrequencyDeletedHandler = new CFBamXMsgRspnAccessFrequencyDeletedHandler( this );
		}
		return( rspnAccessFrequencyDeletedHandler );
	}

	// AccessSecurity Response Handlers

	protected CFBamXMsgRspnAccessSecurityRecHandler getRspnAccessSecurityRecHandler() {
		if( rspnAccessSecurityRecHandler == null ) {
			rspnAccessSecurityRecHandler = new CFBamXMsgRspnAccessSecurityRecHandler( this );
		}
		return( rspnAccessSecurityRecHandler );
	}

	protected CFBamXMsgRspnAccessSecurityCreatedHandler getRspnAccessSecurityCreatedHandler() {
		if( rspnAccessSecurityCreatedHandler == null ) {
			rspnAccessSecurityCreatedHandler = new CFBamXMsgRspnAccessSecurityCreatedHandler( this );
		}
		return( rspnAccessSecurityCreatedHandler );
	}

	protected CFBamXMsgRspnAccessSecurityReadSingleHandler getRspnAccessSecurityReadSingleHandler() {
		if( rspnAccessSecurityReadSingleHandler == null ) {
			rspnAccessSecurityReadSingleHandler = new CFBamXMsgRspnAccessSecurityReadSingleHandler( this );
			rspnAccessSecurityReadSingleHandler.addElementHandler( "AccessSecurity", getRspnAccessSecurityRecHandler() );
		}
		return( rspnAccessSecurityReadSingleHandler );
	}

	protected CFBamXMsgRspnAccessSecurityReadListHandler getRspnAccessSecurityReadListHandler() {
		if( rspnAccessSecurityReadListHandler == null ) {
			rspnAccessSecurityReadListHandler = new CFBamXMsgRspnAccessSecurityReadListHandler( this );
			rspnAccessSecurityReadListHandler.addElementHandler( "AccessSecurity", getRspnAccessSecurityRecHandler() );
		}
		return( rspnAccessSecurityReadListHandler );
	}

	protected CFBamXMsgRspnAccessSecurityLockedHandler getRspnAccessSecurityLockedHandler() {
		if( rspnAccessSecurityLockedHandler == null ) {
			rspnAccessSecurityLockedHandler = new CFBamXMsgRspnAccessSecurityLockedHandler( this );
		}
		return( rspnAccessSecurityLockedHandler );
	}

	protected CFBamXMsgRspnAccessSecurityUpdatedHandler getRspnAccessSecurityUpdatedHandler() {
		if( rspnAccessSecurityUpdatedHandler == null ) {
			rspnAccessSecurityUpdatedHandler = new CFBamXMsgRspnAccessSecurityUpdatedHandler( this );
		}
		return( rspnAccessSecurityUpdatedHandler );
	}

	protected CFBamXMsgRspnAccessSecurityDeletedHandler getRspnAccessSecurityDeletedHandler() {
		if( rspnAccessSecurityDeletedHandler == null ) {
			rspnAccessSecurityDeletedHandler = new CFBamXMsgRspnAccessSecurityDeletedHandler( this );
		}
		return( rspnAccessSecurityDeletedHandler );
	}

	// Atom Response Handlers

	protected CFBamXMsgRspnAtomRecHandler getRspnAtomRecHandler() {
		if( rspnAtomRecHandler == null ) {
			rspnAtomRecHandler = new CFBamXMsgRspnAtomRecHandler( this );
		}
		return( rspnAtomRecHandler );
	}

	protected CFBamXMsgRspnAtomCreatedHandler getRspnAtomCreatedHandler() {
		if( rspnAtomCreatedHandler == null ) {
			rspnAtomCreatedHandler = new CFBamXMsgRspnAtomCreatedHandler( this );
		}
		return( rspnAtomCreatedHandler );
	}

	protected CFBamXMsgRspnAtomReadSingleHandler getRspnAtomReadSingleHandler() {
		if( rspnAtomReadSingleHandler == null ) {
			rspnAtomReadSingleHandler = new CFBamXMsgRspnAtomReadSingleHandler( this );
			rspnAtomReadSingleHandler.addElementHandler( "Atom", getRspnAtomRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "BlobDef", getRspnBlobDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "BlobCol", getRspnBlobColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "BlobType", getRspnBlobTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "BoolDef", getRspnBoolDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "BoolCol", getRspnBoolColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "BoolType", getRspnBoolTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Int16Def", getRspnInt16DefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Int16Col", getRspnInt16ColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Int16Type", getRspnInt16TypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Id16Gen", getRspnId16GenRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "EnumDef", getRspnEnumDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "EnumCol", getRspnEnumColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "EnumType", getRspnEnumTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Int32Def", getRspnInt32DefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Int32Col", getRspnInt32ColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Int32Type", getRspnInt32TypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Id32Gen", getRspnId32GenRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Int64Def", getRspnInt64DefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Int64Col", getRspnInt64ColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Int64Type", getRspnInt64TypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "Id64Gen", getRspnId64GenRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UInt16Def", getRspnUInt16DefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UInt16Col", getRspnUInt16ColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UInt16Type", getRspnUInt16TypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UInt32Def", getRspnUInt32DefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UInt32Col", getRspnUInt32ColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UInt32Type", getRspnUInt32TypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UInt64Def", getRspnUInt64DefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UInt64Col", getRspnUInt64ColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UInt64Type", getRspnUInt64TypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "FloatDef", getRspnFloatDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "FloatCol", getRspnFloatColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "FloatType", getRspnFloatTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "DoubleDef", getRspnDoubleDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "DoubleCol", getRspnDoubleColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "DoubleType", getRspnDoubleTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "NumberDef", getRspnNumberDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "NumberCol", getRspnNumberColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "NumberType", getRspnNumberTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "StringDef", getRspnStringDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "StringCol", getRspnStringColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "StringType", getRspnStringTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TextDef", getRspnTextDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TextCol", getRspnTextColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TextType", getRspnTextTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "NmTokenDef", getRspnNmTokenDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "NmTokenCol", getRspnNmTokenColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "NmTokenType", getRspnNmTokenTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "NmTokensDef", getRspnNmTokensDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "NmTokensCol", getRspnNmTokensColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "NmTokensType", getRspnNmTokensTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TokenDef", getRspnTokenDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TokenCol", getRspnTokenColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TokenType", getRspnTokenTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "DateDef", getRspnDateDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "DateCol", getRspnDateColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "DateType", getRspnDateTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TimeDef", getRspnTimeDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TimeCol", getRspnTimeColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TimeType", getRspnTimeTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TimestampDef", getRspnTimestampDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TimestampCol", getRspnTimestampColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TimestampType", getRspnTimestampTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TZDateDef", getRspnTZDateDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TZDateCol", getRspnTZDateColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TZDateType", getRspnTZDateTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TZTimeDef", getRspnTZTimeDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TZTimeCol", getRspnTZTimeColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TZTimeType", getRspnTZTimeTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TZTimestampDef", getRspnTZTimestampDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TZTimestampCol", getRspnTZTimestampColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "TZTimestampType", getRspnTZTimestampTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UuidDef", getRspnUuidDefRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UuidCol", getRspnUuidColRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UuidType", getRspnUuidTypeRecHandler() );
			rspnAtomReadSingleHandler.addElementHandler( "UuidGen", getRspnUuidGenRecHandler() );
		}
		return( rspnAtomReadSingleHandler );
	}

	protected CFBamXMsgRspnAtomReadListHandler getRspnAtomReadListHandler() {
		if( rspnAtomReadListHandler == null ) {
			rspnAtomReadListHandler = new CFBamXMsgRspnAtomReadListHandler( this );
			rspnAtomReadListHandler.addElementHandler( "Atom", getRspnAtomRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "BlobDef", getRspnBlobDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "BlobCol", getRspnBlobColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "BlobType", getRspnBlobTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "BoolDef", getRspnBoolDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "BoolCol", getRspnBoolColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "BoolType", getRspnBoolTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Int16Def", getRspnInt16DefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Int16Col", getRspnInt16ColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Int16Type", getRspnInt16TypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Id16Gen", getRspnId16GenRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "EnumDef", getRspnEnumDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "EnumCol", getRspnEnumColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "EnumType", getRspnEnumTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Int32Def", getRspnInt32DefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Int32Col", getRspnInt32ColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Int32Type", getRspnInt32TypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Id32Gen", getRspnId32GenRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Int64Def", getRspnInt64DefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Int64Col", getRspnInt64ColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Int64Type", getRspnInt64TypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "Id64Gen", getRspnId64GenRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UInt16Def", getRspnUInt16DefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UInt16Col", getRspnUInt16ColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UInt16Type", getRspnUInt16TypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UInt32Def", getRspnUInt32DefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UInt32Col", getRspnUInt32ColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UInt32Type", getRspnUInt32TypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UInt64Def", getRspnUInt64DefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UInt64Col", getRspnUInt64ColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UInt64Type", getRspnUInt64TypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "FloatDef", getRspnFloatDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "FloatCol", getRspnFloatColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "FloatType", getRspnFloatTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "DoubleDef", getRspnDoubleDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "DoubleCol", getRspnDoubleColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "DoubleType", getRspnDoubleTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "NumberDef", getRspnNumberDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "NumberCol", getRspnNumberColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "NumberType", getRspnNumberTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "StringDef", getRspnStringDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "StringCol", getRspnStringColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "StringType", getRspnStringTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TextDef", getRspnTextDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TextCol", getRspnTextColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TextType", getRspnTextTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "NmTokenDef", getRspnNmTokenDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "NmTokenCol", getRspnNmTokenColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "NmTokenType", getRspnNmTokenTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "NmTokensDef", getRspnNmTokensDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "NmTokensCol", getRspnNmTokensColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "NmTokensType", getRspnNmTokensTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TokenDef", getRspnTokenDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TokenCol", getRspnTokenColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TokenType", getRspnTokenTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "DateDef", getRspnDateDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "DateCol", getRspnDateColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "DateType", getRspnDateTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TimeDef", getRspnTimeDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TimeCol", getRspnTimeColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TimeType", getRspnTimeTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TimestampDef", getRspnTimestampDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TimestampCol", getRspnTimestampColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TimestampType", getRspnTimestampTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TZDateDef", getRspnTZDateDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TZDateCol", getRspnTZDateColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TZDateType", getRspnTZDateTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TZTimeDef", getRspnTZTimeDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TZTimeCol", getRspnTZTimeColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TZTimeType", getRspnTZTimeTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TZTimestampDef", getRspnTZTimestampDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TZTimestampCol", getRspnTZTimestampColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "TZTimestampType", getRspnTZTimestampTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UuidDef", getRspnUuidDefRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UuidCol", getRspnUuidColRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UuidType", getRspnUuidTypeRecHandler() );
			rspnAtomReadListHandler.addElementHandler( "UuidGen", getRspnUuidGenRecHandler() );
		}
		return( rspnAtomReadListHandler );
	}

	protected CFBamXMsgRspnAtomLockedHandler getRspnAtomLockedHandler() {
		if( rspnAtomLockedHandler == null ) {
			rspnAtomLockedHandler = new CFBamXMsgRspnAtomLockedHandler( this );
		}
		return( rspnAtomLockedHandler );
	}

	protected CFBamXMsgRspnAtomUpdatedHandler getRspnAtomUpdatedHandler() {
		if( rspnAtomUpdatedHandler == null ) {
			rspnAtomUpdatedHandler = new CFBamXMsgRspnAtomUpdatedHandler( this );
		}
		return( rspnAtomUpdatedHandler );
	}

	protected CFBamXMsgRspnAtomDeletedHandler getRspnAtomDeletedHandler() {
		if( rspnAtomDeletedHandler == null ) {
			rspnAtomDeletedHandler = new CFBamXMsgRspnAtomDeletedHandler( this );
		}
		return( rspnAtomDeletedHandler );
	}

	// AuditAction Response Handlers

	protected CFBamXMsgRspnAuditActionRecHandler getRspnAuditActionRecHandler() {
		if( rspnAuditActionRecHandler == null ) {
			rspnAuditActionRecHandler = new CFBamXMsgRspnAuditActionRecHandler( this );
		}
		return( rspnAuditActionRecHandler );
	}

	protected CFBamXMsgRspnAuditActionCreatedHandler getRspnAuditActionCreatedHandler() {
		if( rspnAuditActionCreatedHandler == null ) {
			rspnAuditActionCreatedHandler = new CFBamXMsgRspnAuditActionCreatedHandler( this );
		}
		return( rspnAuditActionCreatedHandler );
	}

	protected CFBamXMsgRspnAuditActionReadSingleHandler getRspnAuditActionReadSingleHandler() {
		if( rspnAuditActionReadSingleHandler == null ) {
			rspnAuditActionReadSingleHandler = new CFBamXMsgRspnAuditActionReadSingleHandler( this );
			rspnAuditActionReadSingleHandler.addElementHandler( "AuditAction", getRspnAuditActionRecHandler() );
		}
		return( rspnAuditActionReadSingleHandler );
	}

	protected CFBamXMsgRspnAuditActionReadListHandler getRspnAuditActionReadListHandler() {
		if( rspnAuditActionReadListHandler == null ) {
			rspnAuditActionReadListHandler = new CFBamXMsgRspnAuditActionReadListHandler( this );
			rspnAuditActionReadListHandler.addElementHandler( "AuditAction", getRspnAuditActionRecHandler() );
		}
		return( rspnAuditActionReadListHandler );
	}

	protected CFBamXMsgRspnAuditActionLockedHandler getRspnAuditActionLockedHandler() {
		if( rspnAuditActionLockedHandler == null ) {
			rspnAuditActionLockedHandler = new CFBamXMsgRspnAuditActionLockedHandler( this );
		}
		return( rspnAuditActionLockedHandler );
	}

	protected CFBamXMsgRspnAuditActionUpdatedHandler getRspnAuditActionUpdatedHandler() {
		if( rspnAuditActionUpdatedHandler == null ) {
			rspnAuditActionUpdatedHandler = new CFBamXMsgRspnAuditActionUpdatedHandler( this );
		}
		return( rspnAuditActionUpdatedHandler );
	}

	protected CFBamXMsgRspnAuditActionDeletedHandler getRspnAuditActionDeletedHandler() {
		if( rspnAuditActionDeletedHandler == null ) {
			rspnAuditActionDeletedHandler = new CFBamXMsgRspnAuditActionDeletedHandler( this );
		}
		return( rspnAuditActionDeletedHandler );
	}

	// BlobCol Response Handlers

	protected CFBamXMsgRspnBlobColRecHandler getRspnBlobColRecHandler() {
		if( rspnBlobColRecHandler == null ) {
			rspnBlobColRecHandler = new CFBamXMsgRspnBlobColRecHandler( this );
		}
		return( rspnBlobColRecHandler );
	}

	protected CFBamXMsgRspnBlobColCreatedHandler getRspnBlobColCreatedHandler() {
		if( rspnBlobColCreatedHandler == null ) {
			rspnBlobColCreatedHandler = new CFBamXMsgRspnBlobColCreatedHandler( this );
		}
		return( rspnBlobColCreatedHandler );
	}

	protected CFBamXMsgRspnBlobColReadSingleHandler getRspnBlobColReadSingleHandler() {
		if( rspnBlobColReadSingleHandler == null ) {
			rspnBlobColReadSingleHandler = new CFBamXMsgRspnBlobColReadSingleHandler( this );
			rspnBlobColReadSingleHandler.addElementHandler( "BlobCol", getRspnBlobColRecHandler() );
		}
		return( rspnBlobColReadSingleHandler );
	}

	protected CFBamXMsgRspnBlobColReadListHandler getRspnBlobColReadListHandler() {
		if( rspnBlobColReadListHandler == null ) {
			rspnBlobColReadListHandler = new CFBamXMsgRspnBlobColReadListHandler( this );
			rspnBlobColReadListHandler.addElementHandler( "BlobCol", getRspnBlobColRecHandler() );
		}
		return( rspnBlobColReadListHandler );
	}

	protected CFBamXMsgRspnBlobColLockedHandler getRspnBlobColLockedHandler() {
		if( rspnBlobColLockedHandler == null ) {
			rspnBlobColLockedHandler = new CFBamXMsgRspnBlobColLockedHandler( this );
		}
		return( rspnBlobColLockedHandler );
	}

	protected CFBamXMsgRspnBlobColUpdatedHandler getRspnBlobColUpdatedHandler() {
		if( rspnBlobColUpdatedHandler == null ) {
			rspnBlobColUpdatedHandler = new CFBamXMsgRspnBlobColUpdatedHandler( this );
		}
		return( rspnBlobColUpdatedHandler );
	}

	protected CFBamXMsgRspnBlobColDeletedHandler getRspnBlobColDeletedHandler() {
		if( rspnBlobColDeletedHandler == null ) {
			rspnBlobColDeletedHandler = new CFBamXMsgRspnBlobColDeletedHandler( this );
		}
		return( rspnBlobColDeletedHandler );
	}

	// BlobDef Response Handlers

	protected CFBamXMsgRspnBlobDefRecHandler getRspnBlobDefRecHandler() {
		if( rspnBlobDefRecHandler == null ) {
			rspnBlobDefRecHandler = new CFBamXMsgRspnBlobDefRecHandler( this );
		}
		return( rspnBlobDefRecHandler );
	}

	protected CFBamXMsgRspnBlobDefCreatedHandler getRspnBlobDefCreatedHandler() {
		if( rspnBlobDefCreatedHandler == null ) {
			rspnBlobDefCreatedHandler = new CFBamXMsgRspnBlobDefCreatedHandler( this );
		}
		return( rspnBlobDefCreatedHandler );
	}

	protected CFBamXMsgRspnBlobDefReadSingleHandler getRspnBlobDefReadSingleHandler() {
		if( rspnBlobDefReadSingleHandler == null ) {
			rspnBlobDefReadSingleHandler = new CFBamXMsgRspnBlobDefReadSingleHandler( this );
			rspnBlobDefReadSingleHandler.addElementHandler( "BlobDef", getRspnBlobDefRecHandler() );
			rspnBlobDefReadSingleHandler.addElementHandler( "BlobCol", getRspnBlobColRecHandler() );
			rspnBlobDefReadSingleHandler.addElementHandler( "BlobType", getRspnBlobTypeRecHandler() );
		}
		return( rspnBlobDefReadSingleHandler );
	}

	protected CFBamXMsgRspnBlobDefReadListHandler getRspnBlobDefReadListHandler() {
		if( rspnBlobDefReadListHandler == null ) {
			rspnBlobDefReadListHandler = new CFBamXMsgRspnBlobDefReadListHandler( this );
			rspnBlobDefReadListHandler.addElementHandler( "BlobDef", getRspnBlobDefRecHandler() );
			rspnBlobDefReadListHandler.addElementHandler( "BlobCol", getRspnBlobColRecHandler() );
			rspnBlobDefReadListHandler.addElementHandler( "BlobType", getRspnBlobTypeRecHandler() );
		}
		return( rspnBlobDefReadListHandler );
	}

	protected CFBamXMsgRspnBlobDefLockedHandler getRspnBlobDefLockedHandler() {
		if( rspnBlobDefLockedHandler == null ) {
			rspnBlobDefLockedHandler = new CFBamXMsgRspnBlobDefLockedHandler( this );
		}
		return( rspnBlobDefLockedHandler );
	}

	protected CFBamXMsgRspnBlobDefUpdatedHandler getRspnBlobDefUpdatedHandler() {
		if( rspnBlobDefUpdatedHandler == null ) {
			rspnBlobDefUpdatedHandler = new CFBamXMsgRspnBlobDefUpdatedHandler( this );
		}
		return( rspnBlobDefUpdatedHandler );
	}

	protected CFBamXMsgRspnBlobDefDeletedHandler getRspnBlobDefDeletedHandler() {
		if( rspnBlobDefDeletedHandler == null ) {
			rspnBlobDefDeletedHandler = new CFBamXMsgRspnBlobDefDeletedHandler( this );
		}
		return( rspnBlobDefDeletedHandler );
	}

	// BlobType Response Handlers

	protected CFBamXMsgRspnBlobTypeRecHandler getRspnBlobTypeRecHandler() {
		if( rspnBlobTypeRecHandler == null ) {
			rspnBlobTypeRecHandler = new CFBamXMsgRspnBlobTypeRecHandler( this );
		}
		return( rspnBlobTypeRecHandler );
	}

	protected CFBamXMsgRspnBlobTypeCreatedHandler getRspnBlobTypeCreatedHandler() {
		if( rspnBlobTypeCreatedHandler == null ) {
			rspnBlobTypeCreatedHandler = new CFBamXMsgRspnBlobTypeCreatedHandler( this );
		}
		return( rspnBlobTypeCreatedHandler );
	}

	protected CFBamXMsgRspnBlobTypeReadSingleHandler getRspnBlobTypeReadSingleHandler() {
		if( rspnBlobTypeReadSingleHandler == null ) {
			rspnBlobTypeReadSingleHandler = new CFBamXMsgRspnBlobTypeReadSingleHandler( this );
			rspnBlobTypeReadSingleHandler.addElementHandler( "BlobType", getRspnBlobTypeRecHandler() );
		}
		return( rspnBlobTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnBlobTypeReadListHandler getRspnBlobTypeReadListHandler() {
		if( rspnBlobTypeReadListHandler == null ) {
			rspnBlobTypeReadListHandler = new CFBamXMsgRspnBlobTypeReadListHandler( this );
			rspnBlobTypeReadListHandler.addElementHandler( "BlobType", getRspnBlobTypeRecHandler() );
		}
		return( rspnBlobTypeReadListHandler );
	}

	protected CFBamXMsgRspnBlobTypeLockedHandler getRspnBlobTypeLockedHandler() {
		if( rspnBlobTypeLockedHandler == null ) {
			rspnBlobTypeLockedHandler = new CFBamXMsgRspnBlobTypeLockedHandler( this );
		}
		return( rspnBlobTypeLockedHandler );
	}

	protected CFBamXMsgRspnBlobTypeUpdatedHandler getRspnBlobTypeUpdatedHandler() {
		if( rspnBlobTypeUpdatedHandler == null ) {
			rspnBlobTypeUpdatedHandler = new CFBamXMsgRspnBlobTypeUpdatedHandler( this );
		}
		return( rspnBlobTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnBlobTypeDeletedHandler getRspnBlobTypeDeletedHandler() {
		if( rspnBlobTypeDeletedHandler == null ) {
			rspnBlobTypeDeletedHandler = new CFBamXMsgRspnBlobTypeDeletedHandler( this );
		}
		return( rspnBlobTypeDeletedHandler );
	}

	// BoolCol Response Handlers

	protected CFBamXMsgRspnBoolColRecHandler getRspnBoolColRecHandler() {
		if( rspnBoolColRecHandler == null ) {
			rspnBoolColRecHandler = new CFBamXMsgRspnBoolColRecHandler( this );
		}
		return( rspnBoolColRecHandler );
	}

	protected CFBamXMsgRspnBoolColCreatedHandler getRspnBoolColCreatedHandler() {
		if( rspnBoolColCreatedHandler == null ) {
			rspnBoolColCreatedHandler = new CFBamXMsgRspnBoolColCreatedHandler( this );
		}
		return( rspnBoolColCreatedHandler );
	}

	protected CFBamXMsgRspnBoolColReadSingleHandler getRspnBoolColReadSingleHandler() {
		if( rspnBoolColReadSingleHandler == null ) {
			rspnBoolColReadSingleHandler = new CFBamXMsgRspnBoolColReadSingleHandler( this );
			rspnBoolColReadSingleHandler.addElementHandler( "BoolCol", getRspnBoolColRecHandler() );
		}
		return( rspnBoolColReadSingleHandler );
	}

	protected CFBamXMsgRspnBoolColReadListHandler getRspnBoolColReadListHandler() {
		if( rspnBoolColReadListHandler == null ) {
			rspnBoolColReadListHandler = new CFBamXMsgRspnBoolColReadListHandler( this );
			rspnBoolColReadListHandler.addElementHandler( "BoolCol", getRspnBoolColRecHandler() );
		}
		return( rspnBoolColReadListHandler );
	}

	protected CFBamXMsgRspnBoolColLockedHandler getRspnBoolColLockedHandler() {
		if( rspnBoolColLockedHandler == null ) {
			rspnBoolColLockedHandler = new CFBamXMsgRspnBoolColLockedHandler( this );
		}
		return( rspnBoolColLockedHandler );
	}

	protected CFBamXMsgRspnBoolColUpdatedHandler getRspnBoolColUpdatedHandler() {
		if( rspnBoolColUpdatedHandler == null ) {
			rspnBoolColUpdatedHandler = new CFBamXMsgRspnBoolColUpdatedHandler( this );
		}
		return( rspnBoolColUpdatedHandler );
	}

	protected CFBamXMsgRspnBoolColDeletedHandler getRspnBoolColDeletedHandler() {
		if( rspnBoolColDeletedHandler == null ) {
			rspnBoolColDeletedHandler = new CFBamXMsgRspnBoolColDeletedHandler( this );
		}
		return( rspnBoolColDeletedHandler );
	}

	// BoolDef Response Handlers

	protected CFBamXMsgRspnBoolDefRecHandler getRspnBoolDefRecHandler() {
		if( rspnBoolDefRecHandler == null ) {
			rspnBoolDefRecHandler = new CFBamXMsgRspnBoolDefRecHandler( this );
		}
		return( rspnBoolDefRecHandler );
	}

	protected CFBamXMsgRspnBoolDefCreatedHandler getRspnBoolDefCreatedHandler() {
		if( rspnBoolDefCreatedHandler == null ) {
			rspnBoolDefCreatedHandler = new CFBamXMsgRspnBoolDefCreatedHandler( this );
		}
		return( rspnBoolDefCreatedHandler );
	}

	protected CFBamXMsgRspnBoolDefReadSingleHandler getRspnBoolDefReadSingleHandler() {
		if( rspnBoolDefReadSingleHandler == null ) {
			rspnBoolDefReadSingleHandler = new CFBamXMsgRspnBoolDefReadSingleHandler( this );
			rspnBoolDefReadSingleHandler.addElementHandler( "BoolDef", getRspnBoolDefRecHandler() );
			rspnBoolDefReadSingleHandler.addElementHandler( "BoolCol", getRspnBoolColRecHandler() );
			rspnBoolDefReadSingleHandler.addElementHandler( "BoolType", getRspnBoolTypeRecHandler() );
		}
		return( rspnBoolDefReadSingleHandler );
	}

	protected CFBamXMsgRspnBoolDefReadListHandler getRspnBoolDefReadListHandler() {
		if( rspnBoolDefReadListHandler == null ) {
			rspnBoolDefReadListHandler = new CFBamXMsgRspnBoolDefReadListHandler( this );
			rspnBoolDefReadListHandler.addElementHandler( "BoolDef", getRspnBoolDefRecHandler() );
			rspnBoolDefReadListHandler.addElementHandler( "BoolCol", getRspnBoolColRecHandler() );
			rspnBoolDefReadListHandler.addElementHandler( "BoolType", getRspnBoolTypeRecHandler() );
		}
		return( rspnBoolDefReadListHandler );
	}

	protected CFBamXMsgRspnBoolDefLockedHandler getRspnBoolDefLockedHandler() {
		if( rspnBoolDefLockedHandler == null ) {
			rspnBoolDefLockedHandler = new CFBamXMsgRspnBoolDefLockedHandler( this );
		}
		return( rspnBoolDefLockedHandler );
	}

	protected CFBamXMsgRspnBoolDefUpdatedHandler getRspnBoolDefUpdatedHandler() {
		if( rspnBoolDefUpdatedHandler == null ) {
			rspnBoolDefUpdatedHandler = new CFBamXMsgRspnBoolDefUpdatedHandler( this );
		}
		return( rspnBoolDefUpdatedHandler );
	}

	protected CFBamXMsgRspnBoolDefDeletedHandler getRspnBoolDefDeletedHandler() {
		if( rspnBoolDefDeletedHandler == null ) {
			rspnBoolDefDeletedHandler = new CFBamXMsgRspnBoolDefDeletedHandler( this );
		}
		return( rspnBoolDefDeletedHandler );
	}

	// BoolType Response Handlers

	protected CFBamXMsgRspnBoolTypeRecHandler getRspnBoolTypeRecHandler() {
		if( rspnBoolTypeRecHandler == null ) {
			rspnBoolTypeRecHandler = new CFBamXMsgRspnBoolTypeRecHandler( this );
		}
		return( rspnBoolTypeRecHandler );
	}

	protected CFBamXMsgRspnBoolTypeCreatedHandler getRspnBoolTypeCreatedHandler() {
		if( rspnBoolTypeCreatedHandler == null ) {
			rspnBoolTypeCreatedHandler = new CFBamXMsgRspnBoolTypeCreatedHandler( this );
		}
		return( rspnBoolTypeCreatedHandler );
	}

	protected CFBamXMsgRspnBoolTypeReadSingleHandler getRspnBoolTypeReadSingleHandler() {
		if( rspnBoolTypeReadSingleHandler == null ) {
			rspnBoolTypeReadSingleHandler = new CFBamXMsgRspnBoolTypeReadSingleHandler( this );
			rspnBoolTypeReadSingleHandler.addElementHandler( "BoolType", getRspnBoolTypeRecHandler() );
		}
		return( rspnBoolTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnBoolTypeReadListHandler getRspnBoolTypeReadListHandler() {
		if( rspnBoolTypeReadListHandler == null ) {
			rspnBoolTypeReadListHandler = new CFBamXMsgRspnBoolTypeReadListHandler( this );
			rspnBoolTypeReadListHandler.addElementHandler( "BoolType", getRspnBoolTypeRecHandler() );
		}
		return( rspnBoolTypeReadListHandler );
	}

	protected CFBamXMsgRspnBoolTypeLockedHandler getRspnBoolTypeLockedHandler() {
		if( rspnBoolTypeLockedHandler == null ) {
			rspnBoolTypeLockedHandler = new CFBamXMsgRspnBoolTypeLockedHandler( this );
		}
		return( rspnBoolTypeLockedHandler );
	}

	protected CFBamXMsgRspnBoolTypeUpdatedHandler getRspnBoolTypeUpdatedHandler() {
		if( rspnBoolTypeUpdatedHandler == null ) {
			rspnBoolTypeUpdatedHandler = new CFBamXMsgRspnBoolTypeUpdatedHandler( this );
		}
		return( rspnBoolTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnBoolTypeDeletedHandler getRspnBoolTypeDeletedHandler() {
		if( rspnBoolTypeDeletedHandler == null ) {
			rspnBoolTypeDeletedHandler = new CFBamXMsgRspnBoolTypeDeletedHandler( this );
		}
		return( rspnBoolTypeDeletedHandler );
	}

	// Chain Response Handlers

	protected CFBamXMsgRspnChainRecHandler getRspnChainRecHandler() {
		if( rspnChainRecHandler == null ) {
			rspnChainRecHandler = new CFBamXMsgRspnChainRecHandler( this );
		}
		return( rspnChainRecHandler );
	}

	protected CFBamXMsgRspnChainCreatedHandler getRspnChainCreatedHandler() {
		if( rspnChainCreatedHandler == null ) {
			rspnChainCreatedHandler = new CFBamXMsgRspnChainCreatedHandler( this );
		}
		return( rspnChainCreatedHandler );
	}

	protected CFBamXMsgRspnChainReadSingleHandler getRspnChainReadSingleHandler() {
		if( rspnChainReadSingleHandler == null ) {
			rspnChainReadSingleHandler = new CFBamXMsgRspnChainReadSingleHandler( this );
			rspnChainReadSingleHandler.addElementHandler( "Chain", getRspnChainRecHandler() );
		}
		return( rspnChainReadSingleHandler );
	}

	protected CFBamXMsgRspnChainReadListHandler getRspnChainReadListHandler() {
		if( rspnChainReadListHandler == null ) {
			rspnChainReadListHandler = new CFBamXMsgRspnChainReadListHandler( this );
			rspnChainReadListHandler.addElementHandler( "Chain", getRspnChainRecHandler() );
		}
		return( rspnChainReadListHandler );
	}

	protected CFBamXMsgRspnChainLockedHandler getRspnChainLockedHandler() {
		if( rspnChainLockedHandler == null ) {
			rspnChainLockedHandler = new CFBamXMsgRspnChainLockedHandler( this );
		}
		return( rspnChainLockedHandler );
	}

	protected CFBamXMsgRspnChainUpdatedHandler getRspnChainUpdatedHandler() {
		if( rspnChainUpdatedHandler == null ) {
			rspnChainUpdatedHandler = new CFBamXMsgRspnChainUpdatedHandler( this );
		}
		return( rspnChainUpdatedHandler );
	}

	protected CFBamXMsgRspnChainDeletedHandler getRspnChainDeletedHandler() {
		if( rspnChainDeletedHandler == null ) {
			rspnChainDeletedHandler = new CFBamXMsgRspnChainDeletedHandler( this );
		}
		return( rspnChainDeletedHandler );
	}

	// ClearDep Response Handlers

	protected CFBamXMsgRspnClearDepRecHandler getRspnClearDepRecHandler() {
		if( rspnClearDepRecHandler == null ) {
			rspnClearDepRecHandler = new CFBamXMsgRspnClearDepRecHandler( this );
		}
		return( rspnClearDepRecHandler );
	}

	protected CFBamXMsgRspnClearDepCreatedHandler getRspnClearDepCreatedHandler() {
		if( rspnClearDepCreatedHandler == null ) {
			rspnClearDepCreatedHandler = new CFBamXMsgRspnClearDepCreatedHandler( this );
		}
		return( rspnClearDepCreatedHandler );
	}

	protected CFBamXMsgRspnClearDepReadSingleHandler getRspnClearDepReadSingleHandler() {
		if( rspnClearDepReadSingleHandler == null ) {
			rspnClearDepReadSingleHandler = new CFBamXMsgRspnClearDepReadSingleHandler( this );
			rspnClearDepReadSingleHandler.addElementHandler( "ClearDep", getRspnClearDepRecHandler() );
			rspnClearDepReadSingleHandler.addElementHandler( "ClearTopDep", getRspnClearTopDepRecHandler() );
			rspnClearDepReadSingleHandler.addElementHandler( "ClearSubDep1", getRspnClearSubDep1RecHandler() );
			rspnClearDepReadSingleHandler.addElementHandler( "ClearSubDep2", getRspnClearSubDep2RecHandler() );
			rspnClearDepReadSingleHandler.addElementHandler( "ClearSubDep3", getRspnClearSubDep3RecHandler() );
		}
		return( rspnClearDepReadSingleHandler );
	}

	protected CFBamXMsgRspnClearDepReadListHandler getRspnClearDepReadListHandler() {
		if( rspnClearDepReadListHandler == null ) {
			rspnClearDepReadListHandler = new CFBamXMsgRspnClearDepReadListHandler( this );
			rspnClearDepReadListHandler.addElementHandler( "ClearDep", getRspnClearDepRecHandler() );
			rspnClearDepReadListHandler.addElementHandler( "ClearTopDep", getRspnClearTopDepRecHandler() );
			rspnClearDepReadListHandler.addElementHandler( "ClearSubDep1", getRspnClearSubDep1RecHandler() );
			rspnClearDepReadListHandler.addElementHandler( "ClearSubDep2", getRspnClearSubDep2RecHandler() );
			rspnClearDepReadListHandler.addElementHandler( "ClearSubDep3", getRspnClearSubDep3RecHandler() );
		}
		return( rspnClearDepReadListHandler );
	}

	protected CFBamXMsgRspnClearDepLockedHandler getRspnClearDepLockedHandler() {
		if( rspnClearDepLockedHandler == null ) {
			rspnClearDepLockedHandler = new CFBamXMsgRspnClearDepLockedHandler( this );
		}
		return( rspnClearDepLockedHandler );
	}

	protected CFBamXMsgRspnClearDepUpdatedHandler getRspnClearDepUpdatedHandler() {
		if( rspnClearDepUpdatedHandler == null ) {
			rspnClearDepUpdatedHandler = new CFBamXMsgRspnClearDepUpdatedHandler( this );
		}
		return( rspnClearDepUpdatedHandler );
	}

	protected CFBamXMsgRspnClearDepDeletedHandler getRspnClearDepDeletedHandler() {
		if( rspnClearDepDeletedHandler == null ) {
			rspnClearDepDeletedHandler = new CFBamXMsgRspnClearDepDeletedHandler( this );
		}
		return( rspnClearDepDeletedHandler );
	}

	// ClearSubDep1 Response Handlers

	protected CFBamXMsgRspnClearSubDep1RecHandler getRspnClearSubDep1RecHandler() {
		if( rspnClearSubDep1RecHandler == null ) {
			rspnClearSubDep1RecHandler = new CFBamXMsgRspnClearSubDep1RecHandler( this );
		}
		return( rspnClearSubDep1RecHandler );
	}

	protected CFBamXMsgRspnClearSubDep1CreatedHandler getRspnClearSubDep1CreatedHandler() {
		if( rspnClearSubDep1CreatedHandler == null ) {
			rspnClearSubDep1CreatedHandler = new CFBamXMsgRspnClearSubDep1CreatedHandler( this );
		}
		return( rspnClearSubDep1CreatedHandler );
	}

	protected CFBamXMsgRspnClearSubDep1ReadSingleHandler getRspnClearSubDep1ReadSingleHandler() {
		if( rspnClearSubDep1ReadSingleHandler == null ) {
			rspnClearSubDep1ReadSingleHandler = new CFBamXMsgRspnClearSubDep1ReadSingleHandler( this );
			rspnClearSubDep1ReadSingleHandler.addElementHandler( "ClearSubDep1", getRspnClearSubDep1RecHandler() );
		}
		return( rspnClearSubDep1ReadSingleHandler );
	}

	protected CFBamXMsgRspnClearSubDep1ReadListHandler getRspnClearSubDep1ReadListHandler() {
		if( rspnClearSubDep1ReadListHandler == null ) {
			rspnClearSubDep1ReadListHandler = new CFBamXMsgRspnClearSubDep1ReadListHandler( this );
			rspnClearSubDep1ReadListHandler.addElementHandler( "ClearSubDep1", getRspnClearSubDep1RecHandler() );
		}
		return( rspnClearSubDep1ReadListHandler );
	}

	protected CFBamXMsgRspnClearSubDep1LockedHandler getRspnClearSubDep1LockedHandler() {
		if( rspnClearSubDep1LockedHandler == null ) {
			rspnClearSubDep1LockedHandler = new CFBamXMsgRspnClearSubDep1LockedHandler( this );
		}
		return( rspnClearSubDep1LockedHandler );
	}

	protected CFBamXMsgRspnClearSubDep1UpdatedHandler getRspnClearSubDep1UpdatedHandler() {
		if( rspnClearSubDep1UpdatedHandler == null ) {
			rspnClearSubDep1UpdatedHandler = new CFBamXMsgRspnClearSubDep1UpdatedHandler( this );
		}
		return( rspnClearSubDep1UpdatedHandler );
	}

	protected CFBamXMsgRspnClearSubDep1DeletedHandler getRspnClearSubDep1DeletedHandler() {
		if( rspnClearSubDep1DeletedHandler == null ) {
			rspnClearSubDep1DeletedHandler = new CFBamXMsgRspnClearSubDep1DeletedHandler( this );
		}
		return( rspnClearSubDep1DeletedHandler );
	}

	// ClearSubDep2 Response Handlers

	protected CFBamXMsgRspnClearSubDep2RecHandler getRspnClearSubDep2RecHandler() {
		if( rspnClearSubDep2RecHandler == null ) {
			rspnClearSubDep2RecHandler = new CFBamXMsgRspnClearSubDep2RecHandler( this );
		}
		return( rspnClearSubDep2RecHandler );
	}

	protected CFBamXMsgRspnClearSubDep2CreatedHandler getRspnClearSubDep2CreatedHandler() {
		if( rspnClearSubDep2CreatedHandler == null ) {
			rspnClearSubDep2CreatedHandler = new CFBamXMsgRspnClearSubDep2CreatedHandler( this );
		}
		return( rspnClearSubDep2CreatedHandler );
	}

	protected CFBamXMsgRspnClearSubDep2ReadSingleHandler getRspnClearSubDep2ReadSingleHandler() {
		if( rspnClearSubDep2ReadSingleHandler == null ) {
			rspnClearSubDep2ReadSingleHandler = new CFBamXMsgRspnClearSubDep2ReadSingleHandler( this );
			rspnClearSubDep2ReadSingleHandler.addElementHandler( "ClearSubDep2", getRspnClearSubDep2RecHandler() );
		}
		return( rspnClearSubDep2ReadSingleHandler );
	}

	protected CFBamXMsgRspnClearSubDep2ReadListHandler getRspnClearSubDep2ReadListHandler() {
		if( rspnClearSubDep2ReadListHandler == null ) {
			rspnClearSubDep2ReadListHandler = new CFBamXMsgRspnClearSubDep2ReadListHandler( this );
			rspnClearSubDep2ReadListHandler.addElementHandler( "ClearSubDep2", getRspnClearSubDep2RecHandler() );
		}
		return( rspnClearSubDep2ReadListHandler );
	}

	protected CFBamXMsgRspnClearSubDep2LockedHandler getRspnClearSubDep2LockedHandler() {
		if( rspnClearSubDep2LockedHandler == null ) {
			rspnClearSubDep2LockedHandler = new CFBamXMsgRspnClearSubDep2LockedHandler( this );
		}
		return( rspnClearSubDep2LockedHandler );
	}

	protected CFBamXMsgRspnClearSubDep2UpdatedHandler getRspnClearSubDep2UpdatedHandler() {
		if( rspnClearSubDep2UpdatedHandler == null ) {
			rspnClearSubDep2UpdatedHandler = new CFBamXMsgRspnClearSubDep2UpdatedHandler( this );
		}
		return( rspnClearSubDep2UpdatedHandler );
	}

	protected CFBamXMsgRspnClearSubDep2DeletedHandler getRspnClearSubDep2DeletedHandler() {
		if( rspnClearSubDep2DeletedHandler == null ) {
			rspnClearSubDep2DeletedHandler = new CFBamXMsgRspnClearSubDep2DeletedHandler( this );
		}
		return( rspnClearSubDep2DeletedHandler );
	}

	// ClearSubDep3 Response Handlers

	protected CFBamXMsgRspnClearSubDep3RecHandler getRspnClearSubDep3RecHandler() {
		if( rspnClearSubDep3RecHandler == null ) {
			rspnClearSubDep3RecHandler = new CFBamXMsgRspnClearSubDep3RecHandler( this );
		}
		return( rspnClearSubDep3RecHandler );
	}

	protected CFBamXMsgRspnClearSubDep3CreatedHandler getRspnClearSubDep3CreatedHandler() {
		if( rspnClearSubDep3CreatedHandler == null ) {
			rspnClearSubDep3CreatedHandler = new CFBamXMsgRspnClearSubDep3CreatedHandler( this );
		}
		return( rspnClearSubDep3CreatedHandler );
	}

	protected CFBamXMsgRspnClearSubDep3ReadSingleHandler getRspnClearSubDep3ReadSingleHandler() {
		if( rspnClearSubDep3ReadSingleHandler == null ) {
			rspnClearSubDep3ReadSingleHandler = new CFBamXMsgRspnClearSubDep3ReadSingleHandler( this );
			rspnClearSubDep3ReadSingleHandler.addElementHandler( "ClearSubDep3", getRspnClearSubDep3RecHandler() );
		}
		return( rspnClearSubDep3ReadSingleHandler );
	}

	protected CFBamXMsgRspnClearSubDep3ReadListHandler getRspnClearSubDep3ReadListHandler() {
		if( rspnClearSubDep3ReadListHandler == null ) {
			rspnClearSubDep3ReadListHandler = new CFBamXMsgRspnClearSubDep3ReadListHandler( this );
			rspnClearSubDep3ReadListHandler.addElementHandler( "ClearSubDep3", getRspnClearSubDep3RecHandler() );
		}
		return( rspnClearSubDep3ReadListHandler );
	}

	protected CFBamXMsgRspnClearSubDep3LockedHandler getRspnClearSubDep3LockedHandler() {
		if( rspnClearSubDep3LockedHandler == null ) {
			rspnClearSubDep3LockedHandler = new CFBamXMsgRspnClearSubDep3LockedHandler( this );
		}
		return( rspnClearSubDep3LockedHandler );
	}

	protected CFBamXMsgRspnClearSubDep3UpdatedHandler getRspnClearSubDep3UpdatedHandler() {
		if( rspnClearSubDep3UpdatedHandler == null ) {
			rspnClearSubDep3UpdatedHandler = new CFBamXMsgRspnClearSubDep3UpdatedHandler( this );
		}
		return( rspnClearSubDep3UpdatedHandler );
	}

	protected CFBamXMsgRspnClearSubDep3DeletedHandler getRspnClearSubDep3DeletedHandler() {
		if( rspnClearSubDep3DeletedHandler == null ) {
			rspnClearSubDep3DeletedHandler = new CFBamXMsgRspnClearSubDep3DeletedHandler( this );
		}
		return( rspnClearSubDep3DeletedHandler );
	}

	// ClearTopDep Response Handlers

	protected CFBamXMsgRspnClearTopDepRecHandler getRspnClearTopDepRecHandler() {
		if( rspnClearTopDepRecHandler == null ) {
			rspnClearTopDepRecHandler = new CFBamXMsgRspnClearTopDepRecHandler( this );
		}
		return( rspnClearTopDepRecHandler );
	}

	protected CFBamXMsgRspnClearTopDepCreatedHandler getRspnClearTopDepCreatedHandler() {
		if( rspnClearTopDepCreatedHandler == null ) {
			rspnClearTopDepCreatedHandler = new CFBamXMsgRspnClearTopDepCreatedHandler( this );
		}
		return( rspnClearTopDepCreatedHandler );
	}

	protected CFBamXMsgRspnClearTopDepReadSingleHandler getRspnClearTopDepReadSingleHandler() {
		if( rspnClearTopDepReadSingleHandler == null ) {
			rspnClearTopDepReadSingleHandler = new CFBamXMsgRspnClearTopDepReadSingleHandler( this );
			rspnClearTopDepReadSingleHandler.addElementHandler( "ClearTopDep", getRspnClearTopDepRecHandler() );
		}
		return( rspnClearTopDepReadSingleHandler );
	}

	protected CFBamXMsgRspnClearTopDepReadListHandler getRspnClearTopDepReadListHandler() {
		if( rspnClearTopDepReadListHandler == null ) {
			rspnClearTopDepReadListHandler = new CFBamXMsgRspnClearTopDepReadListHandler( this );
			rspnClearTopDepReadListHandler.addElementHandler( "ClearTopDep", getRspnClearTopDepRecHandler() );
		}
		return( rspnClearTopDepReadListHandler );
	}

	protected CFBamXMsgRspnClearTopDepLockedHandler getRspnClearTopDepLockedHandler() {
		if( rspnClearTopDepLockedHandler == null ) {
			rspnClearTopDepLockedHandler = new CFBamXMsgRspnClearTopDepLockedHandler( this );
		}
		return( rspnClearTopDepLockedHandler );
	}

	protected CFBamXMsgRspnClearTopDepUpdatedHandler getRspnClearTopDepUpdatedHandler() {
		if( rspnClearTopDepUpdatedHandler == null ) {
			rspnClearTopDepUpdatedHandler = new CFBamXMsgRspnClearTopDepUpdatedHandler( this );
		}
		return( rspnClearTopDepUpdatedHandler );
	}

	protected CFBamXMsgRspnClearTopDepDeletedHandler getRspnClearTopDepDeletedHandler() {
		if( rspnClearTopDepDeletedHandler == null ) {
			rspnClearTopDepDeletedHandler = new CFBamXMsgRspnClearTopDepDeletedHandler( this );
		}
		return( rspnClearTopDepDeletedHandler );
	}

	// Cluster Response Handlers

	protected CFBamXMsgRspnClusterRecHandler getRspnClusterRecHandler() {
		if( rspnClusterRecHandler == null ) {
			rspnClusterRecHandler = new CFBamXMsgRspnClusterRecHandler( this );
		}
		return( rspnClusterRecHandler );
	}

	protected CFBamXMsgRspnClusterCreatedHandler getRspnClusterCreatedHandler() {
		if( rspnClusterCreatedHandler == null ) {
			rspnClusterCreatedHandler = new CFBamXMsgRspnClusterCreatedHandler( this );
		}
		return( rspnClusterCreatedHandler );
	}

	protected CFBamXMsgRspnClusterReadSingleHandler getRspnClusterReadSingleHandler() {
		if( rspnClusterReadSingleHandler == null ) {
			rspnClusterReadSingleHandler = new CFBamXMsgRspnClusterReadSingleHandler( this );
			rspnClusterReadSingleHandler.addElementHandler( "Cluster", getRspnClusterRecHandler() );
		}
		return( rspnClusterReadSingleHandler );
	}

	protected CFBamXMsgRspnClusterReadListHandler getRspnClusterReadListHandler() {
		if( rspnClusterReadListHandler == null ) {
			rspnClusterReadListHandler = new CFBamXMsgRspnClusterReadListHandler( this );
			rspnClusterReadListHandler.addElementHandler( "Cluster", getRspnClusterRecHandler() );
		}
		return( rspnClusterReadListHandler );
	}

	protected CFBamXMsgRspnClusterLockedHandler getRspnClusterLockedHandler() {
		if( rspnClusterLockedHandler == null ) {
			rspnClusterLockedHandler = new CFBamXMsgRspnClusterLockedHandler( this );
		}
		return( rspnClusterLockedHandler );
	}

	protected CFBamXMsgRspnClusterUpdatedHandler getRspnClusterUpdatedHandler() {
		if( rspnClusterUpdatedHandler == null ) {
			rspnClusterUpdatedHandler = new CFBamXMsgRspnClusterUpdatedHandler( this );
		}
		return( rspnClusterUpdatedHandler );
	}

	protected CFBamXMsgRspnClusterDeletedHandler getRspnClusterDeletedHandler() {
		if( rspnClusterDeletedHandler == null ) {
			rspnClusterDeletedHandler = new CFBamXMsgRspnClusterDeletedHandler( this );
		}
		return( rspnClusterDeletedHandler );
	}

	// DataScope Response Handlers

	protected CFBamXMsgRspnDataScopeRecHandler getRspnDataScopeRecHandler() {
		if( rspnDataScopeRecHandler == null ) {
			rspnDataScopeRecHandler = new CFBamXMsgRspnDataScopeRecHandler( this );
		}
		return( rspnDataScopeRecHandler );
	}

	protected CFBamXMsgRspnDataScopeCreatedHandler getRspnDataScopeCreatedHandler() {
		if( rspnDataScopeCreatedHandler == null ) {
			rspnDataScopeCreatedHandler = new CFBamXMsgRspnDataScopeCreatedHandler( this );
		}
		return( rspnDataScopeCreatedHandler );
	}

	protected CFBamXMsgRspnDataScopeReadSingleHandler getRspnDataScopeReadSingleHandler() {
		if( rspnDataScopeReadSingleHandler == null ) {
			rspnDataScopeReadSingleHandler = new CFBamXMsgRspnDataScopeReadSingleHandler( this );
			rspnDataScopeReadSingleHandler.addElementHandler( "DataScope", getRspnDataScopeRecHandler() );
		}
		return( rspnDataScopeReadSingleHandler );
	}

	protected CFBamXMsgRspnDataScopeReadListHandler getRspnDataScopeReadListHandler() {
		if( rspnDataScopeReadListHandler == null ) {
			rspnDataScopeReadListHandler = new CFBamXMsgRspnDataScopeReadListHandler( this );
			rspnDataScopeReadListHandler.addElementHandler( "DataScope", getRspnDataScopeRecHandler() );
		}
		return( rspnDataScopeReadListHandler );
	}

	protected CFBamXMsgRspnDataScopeLockedHandler getRspnDataScopeLockedHandler() {
		if( rspnDataScopeLockedHandler == null ) {
			rspnDataScopeLockedHandler = new CFBamXMsgRspnDataScopeLockedHandler( this );
		}
		return( rspnDataScopeLockedHandler );
	}

	protected CFBamXMsgRspnDataScopeUpdatedHandler getRspnDataScopeUpdatedHandler() {
		if( rspnDataScopeUpdatedHandler == null ) {
			rspnDataScopeUpdatedHandler = new CFBamXMsgRspnDataScopeUpdatedHandler( this );
		}
		return( rspnDataScopeUpdatedHandler );
	}

	protected CFBamXMsgRspnDataScopeDeletedHandler getRspnDataScopeDeletedHandler() {
		if( rspnDataScopeDeletedHandler == null ) {
			rspnDataScopeDeletedHandler = new CFBamXMsgRspnDataScopeDeletedHandler( this );
		}
		return( rspnDataScopeDeletedHandler );
	}

	// DateCol Response Handlers

	protected CFBamXMsgRspnDateColRecHandler getRspnDateColRecHandler() {
		if( rspnDateColRecHandler == null ) {
			rspnDateColRecHandler = new CFBamXMsgRspnDateColRecHandler( this );
		}
		return( rspnDateColRecHandler );
	}

	protected CFBamXMsgRspnDateColCreatedHandler getRspnDateColCreatedHandler() {
		if( rspnDateColCreatedHandler == null ) {
			rspnDateColCreatedHandler = new CFBamXMsgRspnDateColCreatedHandler( this );
		}
		return( rspnDateColCreatedHandler );
	}

	protected CFBamXMsgRspnDateColReadSingleHandler getRspnDateColReadSingleHandler() {
		if( rspnDateColReadSingleHandler == null ) {
			rspnDateColReadSingleHandler = new CFBamXMsgRspnDateColReadSingleHandler( this );
			rspnDateColReadSingleHandler.addElementHandler( "DateCol", getRspnDateColRecHandler() );
		}
		return( rspnDateColReadSingleHandler );
	}

	protected CFBamXMsgRspnDateColReadListHandler getRspnDateColReadListHandler() {
		if( rspnDateColReadListHandler == null ) {
			rspnDateColReadListHandler = new CFBamXMsgRspnDateColReadListHandler( this );
			rspnDateColReadListHandler.addElementHandler( "DateCol", getRspnDateColRecHandler() );
		}
		return( rspnDateColReadListHandler );
	}

	protected CFBamXMsgRspnDateColLockedHandler getRspnDateColLockedHandler() {
		if( rspnDateColLockedHandler == null ) {
			rspnDateColLockedHandler = new CFBamXMsgRspnDateColLockedHandler( this );
		}
		return( rspnDateColLockedHandler );
	}

	protected CFBamXMsgRspnDateColUpdatedHandler getRspnDateColUpdatedHandler() {
		if( rspnDateColUpdatedHandler == null ) {
			rspnDateColUpdatedHandler = new CFBamXMsgRspnDateColUpdatedHandler( this );
		}
		return( rspnDateColUpdatedHandler );
	}

	protected CFBamXMsgRspnDateColDeletedHandler getRspnDateColDeletedHandler() {
		if( rspnDateColDeletedHandler == null ) {
			rspnDateColDeletedHandler = new CFBamXMsgRspnDateColDeletedHandler( this );
		}
		return( rspnDateColDeletedHandler );
	}

	// DateDef Response Handlers

	protected CFBamXMsgRspnDateDefRecHandler getRspnDateDefRecHandler() {
		if( rspnDateDefRecHandler == null ) {
			rspnDateDefRecHandler = new CFBamXMsgRspnDateDefRecHandler( this );
		}
		return( rspnDateDefRecHandler );
	}

	protected CFBamXMsgRspnDateDefCreatedHandler getRspnDateDefCreatedHandler() {
		if( rspnDateDefCreatedHandler == null ) {
			rspnDateDefCreatedHandler = new CFBamXMsgRspnDateDefCreatedHandler( this );
		}
		return( rspnDateDefCreatedHandler );
	}

	protected CFBamXMsgRspnDateDefReadSingleHandler getRspnDateDefReadSingleHandler() {
		if( rspnDateDefReadSingleHandler == null ) {
			rspnDateDefReadSingleHandler = new CFBamXMsgRspnDateDefReadSingleHandler( this );
			rspnDateDefReadSingleHandler.addElementHandler( "DateDef", getRspnDateDefRecHandler() );
			rspnDateDefReadSingleHandler.addElementHandler( "DateCol", getRspnDateColRecHandler() );
			rspnDateDefReadSingleHandler.addElementHandler( "DateType", getRspnDateTypeRecHandler() );
		}
		return( rspnDateDefReadSingleHandler );
	}

	protected CFBamXMsgRspnDateDefReadListHandler getRspnDateDefReadListHandler() {
		if( rspnDateDefReadListHandler == null ) {
			rspnDateDefReadListHandler = new CFBamXMsgRspnDateDefReadListHandler( this );
			rspnDateDefReadListHandler.addElementHandler( "DateDef", getRspnDateDefRecHandler() );
			rspnDateDefReadListHandler.addElementHandler( "DateCol", getRspnDateColRecHandler() );
			rspnDateDefReadListHandler.addElementHandler( "DateType", getRspnDateTypeRecHandler() );
		}
		return( rspnDateDefReadListHandler );
	}

	protected CFBamXMsgRspnDateDefLockedHandler getRspnDateDefLockedHandler() {
		if( rspnDateDefLockedHandler == null ) {
			rspnDateDefLockedHandler = new CFBamXMsgRspnDateDefLockedHandler( this );
		}
		return( rspnDateDefLockedHandler );
	}

	protected CFBamXMsgRspnDateDefUpdatedHandler getRspnDateDefUpdatedHandler() {
		if( rspnDateDefUpdatedHandler == null ) {
			rspnDateDefUpdatedHandler = new CFBamXMsgRspnDateDefUpdatedHandler( this );
		}
		return( rspnDateDefUpdatedHandler );
	}

	protected CFBamXMsgRspnDateDefDeletedHandler getRspnDateDefDeletedHandler() {
		if( rspnDateDefDeletedHandler == null ) {
			rspnDateDefDeletedHandler = new CFBamXMsgRspnDateDefDeletedHandler( this );
		}
		return( rspnDateDefDeletedHandler );
	}

	// DateType Response Handlers

	protected CFBamXMsgRspnDateTypeRecHandler getRspnDateTypeRecHandler() {
		if( rspnDateTypeRecHandler == null ) {
			rspnDateTypeRecHandler = new CFBamXMsgRspnDateTypeRecHandler( this );
		}
		return( rspnDateTypeRecHandler );
	}

	protected CFBamXMsgRspnDateTypeCreatedHandler getRspnDateTypeCreatedHandler() {
		if( rspnDateTypeCreatedHandler == null ) {
			rspnDateTypeCreatedHandler = new CFBamXMsgRspnDateTypeCreatedHandler( this );
		}
		return( rspnDateTypeCreatedHandler );
	}

	protected CFBamXMsgRspnDateTypeReadSingleHandler getRspnDateTypeReadSingleHandler() {
		if( rspnDateTypeReadSingleHandler == null ) {
			rspnDateTypeReadSingleHandler = new CFBamXMsgRspnDateTypeReadSingleHandler( this );
			rspnDateTypeReadSingleHandler.addElementHandler( "DateType", getRspnDateTypeRecHandler() );
		}
		return( rspnDateTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnDateTypeReadListHandler getRspnDateTypeReadListHandler() {
		if( rspnDateTypeReadListHandler == null ) {
			rspnDateTypeReadListHandler = new CFBamXMsgRspnDateTypeReadListHandler( this );
			rspnDateTypeReadListHandler.addElementHandler( "DateType", getRspnDateTypeRecHandler() );
		}
		return( rspnDateTypeReadListHandler );
	}

	protected CFBamXMsgRspnDateTypeLockedHandler getRspnDateTypeLockedHandler() {
		if( rspnDateTypeLockedHandler == null ) {
			rspnDateTypeLockedHandler = new CFBamXMsgRspnDateTypeLockedHandler( this );
		}
		return( rspnDateTypeLockedHandler );
	}

	protected CFBamXMsgRspnDateTypeUpdatedHandler getRspnDateTypeUpdatedHandler() {
		if( rspnDateTypeUpdatedHandler == null ) {
			rspnDateTypeUpdatedHandler = new CFBamXMsgRspnDateTypeUpdatedHandler( this );
		}
		return( rspnDateTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnDateTypeDeletedHandler getRspnDateTypeDeletedHandler() {
		if( rspnDateTypeDeletedHandler == null ) {
			rspnDateTypeDeletedHandler = new CFBamXMsgRspnDateTypeDeletedHandler( this );
		}
		return( rspnDateTypeDeletedHandler );
	}

	// DelDep Response Handlers

	protected CFBamXMsgRspnDelDepRecHandler getRspnDelDepRecHandler() {
		if( rspnDelDepRecHandler == null ) {
			rspnDelDepRecHandler = new CFBamXMsgRspnDelDepRecHandler( this );
		}
		return( rspnDelDepRecHandler );
	}

	protected CFBamXMsgRspnDelDepCreatedHandler getRspnDelDepCreatedHandler() {
		if( rspnDelDepCreatedHandler == null ) {
			rspnDelDepCreatedHandler = new CFBamXMsgRspnDelDepCreatedHandler( this );
		}
		return( rspnDelDepCreatedHandler );
	}

	protected CFBamXMsgRspnDelDepReadSingleHandler getRspnDelDepReadSingleHandler() {
		if( rspnDelDepReadSingleHandler == null ) {
			rspnDelDepReadSingleHandler = new CFBamXMsgRspnDelDepReadSingleHandler( this );
			rspnDelDepReadSingleHandler.addElementHandler( "DelDep", getRspnDelDepRecHandler() );
			rspnDelDepReadSingleHandler.addElementHandler( "DelTopDep", getRspnDelTopDepRecHandler() );
			rspnDelDepReadSingleHandler.addElementHandler( "DelSubDep1", getRspnDelSubDep1RecHandler() );
			rspnDelDepReadSingleHandler.addElementHandler( "DelSubDep2", getRspnDelSubDep2RecHandler() );
			rspnDelDepReadSingleHandler.addElementHandler( "DelSubDep3", getRspnDelSubDep3RecHandler() );
		}
		return( rspnDelDepReadSingleHandler );
	}

	protected CFBamXMsgRspnDelDepReadListHandler getRspnDelDepReadListHandler() {
		if( rspnDelDepReadListHandler == null ) {
			rspnDelDepReadListHandler = new CFBamXMsgRspnDelDepReadListHandler( this );
			rspnDelDepReadListHandler.addElementHandler( "DelDep", getRspnDelDepRecHandler() );
			rspnDelDepReadListHandler.addElementHandler( "DelTopDep", getRspnDelTopDepRecHandler() );
			rspnDelDepReadListHandler.addElementHandler( "DelSubDep1", getRspnDelSubDep1RecHandler() );
			rspnDelDepReadListHandler.addElementHandler( "DelSubDep2", getRspnDelSubDep2RecHandler() );
			rspnDelDepReadListHandler.addElementHandler( "DelSubDep3", getRspnDelSubDep3RecHandler() );
		}
		return( rspnDelDepReadListHandler );
	}

	protected CFBamXMsgRspnDelDepLockedHandler getRspnDelDepLockedHandler() {
		if( rspnDelDepLockedHandler == null ) {
			rspnDelDepLockedHandler = new CFBamXMsgRspnDelDepLockedHandler( this );
		}
		return( rspnDelDepLockedHandler );
	}

	protected CFBamXMsgRspnDelDepUpdatedHandler getRspnDelDepUpdatedHandler() {
		if( rspnDelDepUpdatedHandler == null ) {
			rspnDelDepUpdatedHandler = new CFBamXMsgRspnDelDepUpdatedHandler( this );
		}
		return( rspnDelDepUpdatedHandler );
	}

	protected CFBamXMsgRspnDelDepDeletedHandler getRspnDelDepDeletedHandler() {
		if( rspnDelDepDeletedHandler == null ) {
			rspnDelDepDeletedHandler = new CFBamXMsgRspnDelDepDeletedHandler( this );
		}
		return( rspnDelDepDeletedHandler );
	}

	// DelSubDep1 Response Handlers

	protected CFBamXMsgRspnDelSubDep1RecHandler getRspnDelSubDep1RecHandler() {
		if( rspnDelSubDep1RecHandler == null ) {
			rspnDelSubDep1RecHandler = new CFBamXMsgRspnDelSubDep1RecHandler( this );
		}
		return( rspnDelSubDep1RecHandler );
	}

	protected CFBamXMsgRspnDelSubDep1CreatedHandler getRspnDelSubDep1CreatedHandler() {
		if( rspnDelSubDep1CreatedHandler == null ) {
			rspnDelSubDep1CreatedHandler = new CFBamXMsgRspnDelSubDep1CreatedHandler( this );
		}
		return( rspnDelSubDep1CreatedHandler );
	}

	protected CFBamXMsgRspnDelSubDep1ReadSingleHandler getRspnDelSubDep1ReadSingleHandler() {
		if( rspnDelSubDep1ReadSingleHandler == null ) {
			rspnDelSubDep1ReadSingleHandler = new CFBamXMsgRspnDelSubDep1ReadSingleHandler( this );
			rspnDelSubDep1ReadSingleHandler.addElementHandler( "DelSubDep1", getRspnDelSubDep1RecHandler() );
		}
		return( rspnDelSubDep1ReadSingleHandler );
	}

	protected CFBamXMsgRspnDelSubDep1ReadListHandler getRspnDelSubDep1ReadListHandler() {
		if( rspnDelSubDep1ReadListHandler == null ) {
			rspnDelSubDep1ReadListHandler = new CFBamXMsgRspnDelSubDep1ReadListHandler( this );
			rspnDelSubDep1ReadListHandler.addElementHandler( "DelSubDep1", getRspnDelSubDep1RecHandler() );
		}
		return( rspnDelSubDep1ReadListHandler );
	}

	protected CFBamXMsgRspnDelSubDep1LockedHandler getRspnDelSubDep1LockedHandler() {
		if( rspnDelSubDep1LockedHandler == null ) {
			rspnDelSubDep1LockedHandler = new CFBamXMsgRspnDelSubDep1LockedHandler( this );
		}
		return( rspnDelSubDep1LockedHandler );
	}

	protected CFBamXMsgRspnDelSubDep1UpdatedHandler getRspnDelSubDep1UpdatedHandler() {
		if( rspnDelSubDep1UpdatedHandler == null ) {
			rspnDelSubDep1UpdatedHandler = new CFBamXMsgRspnDelSubDep1UpdatedHandler( this );
		}
		return( rspnDelSubDep1UpdatedHandler );
	}

	protected CFBamXMsgRspnDelSubDep1DeletedHandler getRspnDelSubDep1DeletedHandler() {
		if( rspnDelSubDep1DeletedHandler == null ) {
			rspnDelSubDep1DeletedHandler = new CFBamXMsgRspnDelSubDep1DeletedHandler( this );
		}
		return( rspnDelSubDep1DeletedHandler );
	}

	// DelSubDep2 Response Handlers

	protected CFBamXMsgRspnDelSubDep2RecHandler getRspnDelSubDep2RecHandler() {
		if( rspnDelSubDep2RecHandler == null ) {
			rspnDelSubDep2RecHandler = new CFBamXMsgRspnDelSubDep2RecHandler( this );
		}
		return( rspnDelSubDep2RecHandler );
	}

	protected CFBamXMsgRspnDelSubDep2CreatedHandler getRspnDelSubDep2CreatedHandler() {
		if( rspnDelSubDep2CreatedHandler == null ) {
			rspnDelSubDep2CreatedHandler = new CFBamXMsgRspnDelSubDep2CreatedHandler( this );
		}
		return( rspnDelSubDep2CreatedHandler );
	}

	protected CFBamXMsgRspnDelSubDep2ReadSingleHandler getRspnDelSubDep2ReadSingleHandler() {
		if( rspnDelSubDep2ReadSingleHandler == null ) {
			rspnDelSubDep2ReadSingleHandler = new CFBamXMsgRspnDelSubDep2ReadSingleHandler( this );
			rspnDelSubDep2ReadSingleHandler.addElementHandler( "DelSubDep2", getRspnDelSubDep2RecHandler() );
		}
		return( rspnDelSubDep2ReadSingleHandler );
	}

	protected CFBamXMsgRspnDelSubDep2ReadListHandler getRspnDelSubDep2ReadListHandler() {
		if( rspnDelSubDep2ReadListHandler == null ) {
			rspnDelSubDep2ReadListHandler = new CFBamXMsgRspnDelSubDep2ReadListHandler( this );
			rspnDelSubDep2ReadListHandler.addElementHandler( "DelSubDep2", getRspnDelSubDep2RecHandler() );
		}
		return( rspnDelSubDep2ReadListHandler );
	}

	protected CFBamXMsgRspnDelSubDep2LockedHandler getRspnDelSubDep2LockedHandler() {
		if( rspnDelSubDep2LockedHandler == null ) {
			rspnDelSubDep2LockedHandler = new CFBamXMsgRspnDelSubDep2LockedHandler( this );
		}
		return( rspnDelSubDep2LockedHandler );
	}

	protected CFBamXMsgRspnDelSubDep2UpdatedHandler getRspnDelSubDep2UpdatedHandler() {
		if( rspnDelSubDep2UpdatedHandler == null ) {
			rspnDelSubDep2UpdatedHandler = new CFBamXMsgRspnDelSubDep2UpdatedHandler( this );
		}
		return( rspnDelSubDep2UpdatedHandler );
	}

	protected CFBamXMsgRspnDelSubDep2DeletedHandler getRspnDelSubDep2DeletedHandler() {
		if( rspnDelSubDep2DeletedHandler == null ) {
			rspnDelSubDep2DeletedHandler = new CFBamXMsgRspnDelSubDep2DeletedHandler( this );
		}
		return( rspnDelSubDep2DeletedHandler );
	}

	// DelSubDep3 Response Handlers

	protected CFBamXMsgRspnDelSubDep3RecHandler getRspnDelSubDep3RecHandler() {
		if( rspnDelSubDep3RecHandler == null ) {
			rspnDelSubDep3RecHandler = new CFBamXMsgRspnDelSubDep3RecHandler( this );
		}
		return( rspnDelSubDep3RecHandler );
	}

	protected CFBamXMsgRspnDelSubDep3CreatedHandler getRspnDelSubDep3CreatedHandler() {
		if( rspnDelSubDep3CreatedHandler == null ) {
			rspnDelSubDep3CreatedHandler = new CFBamXMsgRspnDelSubDep3CreatedHandler( this );
		}
		return( rspnDelSubDep3CreatedHandler );
	}

	protected CFBamXMsgRspnDelSubDep3ReadSingleHandler getRspnDelSubDep3ReadSingleHandler() {
		if( rspnDelSubDep3ReadSingleHandler == null ) {
			rspnDelSubDep3ReadSingleHandler = new CFBamXMsgRspnDelSubDep3ReadSingleHandler( this );
			rspnDelSubDep3ReadSingleHandler.addElementHandler( "DelSubDep3", getRspnDelSubDep3RecHandler() );
		}
		return( rspnDelSubDep3ReadSingleHandler );
	}

	protected CFBamXMsgRspnDelSubDep3ReadListHandler getRspnDelSubDep3ReadListHandler() {
		if( rspnDelSubDep3ReadListHandler == null ) {
			rspnDelSubDep3ReadListHandler = new CFBamXMsgRspnDelSubDep3ReadListHandler( this );
			rspnDelSubDep3ReadListHandler.addElementHandler( "DelSubDep3", getRspnDelSubDep3RecHandler() );
		}
		return( rspnDelSubDep3ReadListHandler );
	}

	protected CFBamXMsgRspnDelSubDep3LockedHandler getRspnDelSubDep3LockedHandler() {
		if( rspnDelSubDep3LockedHandler == null ) {
			rspnDelSubDep3LockedHandler = new CFBamXMsgRspnDelSubDep3LockedHandler( this );
		}
		return( rspnDelSubDep3LockedHandler );
	}

	protected CFBamXMsgRspnDelSubDep3UpdatedHandler getRspnDelSubDep3UpdatedHandler() {
		if( rspnDelSubDep3UpdatedHandler == null ) {
			rspnDelSubDep3UpdatedHandler = new CFBamXMsgRspnDelSubDep3UpdatedHandler( this );
		}
		return( rspnDelSubDep3UpdatedHandler );
	}

	protected CFBamXMsgRspnDelSubDep3DeletedHandler getRspnDelSubDep3DeletedHandler() {
		if( rspnDelSubDep3DeletedHandler == null ) {
			rspnDelSubDep3DeletedHandler = new CFBamXMsgRspnDelSubDep3DeletedHandler( this );
		}
		return( rspnDelSubDep3DeletedHandler );
	}

	// DelTopDep Response Handlers

	protected CFBamXMsgRspnDelTopDepRecHandler getRspnDelTopDepRecHandler() {
		if( rspnDelTopDepRecHandler == null ) {
			rspnDelTopDepRecHandler = new CFBamXMsgRspnDelTopDepRecHandler( this );
		}
		return( rspnDelTopDepRecHandler );
	}

	protected CFBamXMsgRspnDelTopDepCreatedHandler getRspnDelTopDepCreatedHandler() {
		if( rspnDelTopDepCreatedHandler == null ) {
			rspnDelTopDepCreatedHandler = new CFBamXMsgRspnDelTopDepCreatedHandler( this );
		}
		return( rspnDelTopDepCreatedHandler );
	}

	protected CFBamXMsgRspnDelTopDepReadSingleHandler getRspnDelTopDepReadSingleHandler() {
		if( rspnDelTopDepReadSingleHandler == null ) {
			rspnDelTopDepReadSingleHandler = new CFBamXMsgRspnDelTopDepReadSingleHandler( this );
			rspnDelTopDepReadSingleHandler.addElementHandler( "DelTopDep", getRspnDelTopDepRecHandler() );
		}
		return( rspnDelTopDepReadSingleHandler );
	}

	protected CFBamXMsgRspnDelTopDepReadListHandler getRspnDelTopDepReadListHandler() {
		if( rspnDelTopDepReadListHandler == null ) {
			rspnDelTopDepReadListHandler = new CFBamXMsgRspnDelTopDepReadListHandler( this );
			rspnDelTopDepReadListHandler.addElementHandler( "DelTopDep", getRspnDelTopDepRecHandler() );
		}
		return( rspnDelTopDepReadListHandler );
	}

	protected CFBamXMsgRspnDelTopDepLockedHandler getRspnDelTopDepLockedHandler() {
		if( rspnDelTopDepLockedHandler == null ) {
			rspnDelTopDepLockedHandler = new CFBamXMsgRspnDelTopDepLockedHandler( this );
		}
		return( rspnDelTopDepLockedHandler );
	}

	protected CFBamXMsgRspnDelTopDepUpdatedHandler getRspnDelTopDepUpdatedHandler() {
		if( rspnDelTopDepUpdatedHandler == null ) {
			rspnDelTopDepUpdatedHandler = new CFBamXMsgRspnDelTopDepUpdatedHandler( this );
		}
		return( rspnDelTopDepUpdatedHandler );
	}

	protected CFBamXMsgRspnDelTopDepDeletedHandler getRspnDelTopDepDeletedHandler() {
		if( rspnDelTopDepDeletedHandler == null ) {
			rspnDelTopDepDeletedHandler = new CFBamXMsgRspnDelTopDepDeletedHandler( this );
		}
		return( rspnDelTopDepDeletedHandler );
	}

	// Domain Response Handlers

	protected CFBamXMsgRspnDomainRecHandler getRspnDomainRecHandler() {
		if( rspnDomainRecHandler == null ) {
			rspnDomainRecHandler = new CFBamXMsgRspnDomainRecHandler( this );
		}
		return( rspnDomainRecHandler );
	}

	protected CFBamXMsgRspnDomainCreatedHandler getRspnDomainCreatedHandler() {
		if( rspnDomainCreatedHandler == null ) {
			rspnDomainCreatedHandler = new CFBamXMsgRspnDomainCreatedHandler( this );
		}
		return( rspnDomainCreatedHandler );
	}

	protected CFBamXMsgRspnDomainReadSingleHandler getRspnDomainReadSingleHandler() {
		if( rspnDomainReadSingleHandler == null ) {
			rspnDomainReadSingleHandler = new CFBamXMsgRspnDomainReadSingleHandler( this );
			rspnDomainReadSingleHandler.addElementHandler( "Domain", getRspnDomainRecHandler() );
		}
		return( rspnDomainReadSingleHandler );
	}

	protected CFBamXMsgRspnDomainReadListHandler getRspnDomainReadListHandler() {
		if( rspnDomainReadListHandler == null ) {
			rspnDomainReadListHandler = new CFBamXMsgRspnDomainReadListHandler( this );
			rspnDomainReadListHandler.addElementHandler( "Domain", getRspnDomainRecHandler() );
		}
		return( rspnDomainReadListHandler );
	}

	protected CFBamXMsgRspnDomainLockedHandler getRspnDomainLockedHandler() {
		if( rspnDomainLockedHandler == null ) {
			rspnDomainLockedHandler = new CFBamXMsgRspnDomainLockedHandler( this );
		}
		return( rspnDomainLockedHandler );
	}

	protected CFBamXMsgRspnDomainUpdatedHandler getRspnDomainUpdatedHandler() {
		if( rspnDomainUpdatedHandler == null ) {
			rspnDomainUpdatedHandler = new CFBamXMsgRspnDomainUpdatedHandler( this );
		}
		return( rspnDomainUpdatedHandler );
	}

	protected CFBamXMsgRspnDomainDeletedHandler getRspnDomainDeletedHandler() {
		if( rspnDomainDeletedHandler == null ) {
			rspnDomainDeletedHandler = new CFBamXMsgRspnDomainDeletedHandler( this );
		}
		return( rspnDomainDeletedHandler );
	}

	// DomainBase Response Handlers

	protected CFBamXMsgRspnDomainBaseRecHandler getRspnDomainBaseRecHandler() {
		if( rspnDomainBaseRecHandler == null ) {
			rspnDomainBaseRecHandler = new CFBamXMsgRspnDomainBaseRecHandler( this );
		}
		return( rspnDomainBaseRecHandler );
	}

	protected CFBamXMsgRspnDomainBaseCreatedHandler getRspnDomainBaseCreatedHandler() {
		if( rspnDomainBaseCreatedHandler == null ) {
			rspnDomainBaseCreatedHandler = new CFBamXMsgRspnDomainBaseCreatedHandler( this );
		}
		return( rspnDomainBaseCreatedHandler );
	}

	protected CFBamXMsgRspnDomainBaseReadSingleHandler getRspnDomainBaseReadSingleHandler() {
		if( rspnDomainBaseReadSingleHandler == null ) {
			rspnDomainBaseReadSingleHandler = new CFBamXMsgRspnDomainBaseReadSingleHandler( this );
			rspnDomainBaseReadSingleHandler.addElementHandler( "DomainBase", getRspnDomainBaseRecHandler() );
			rspnDomainBaseReadSingleHandler.addElementHandler( "TopDomain", getRspnTopDomainRecHandler() );
			rspnDomainBaseReadSingleHandler.addElementHandler( "Domain", getRspnDomainRecHandler() );
			rspnDomainBaseReadSingleHandler.addElementHandler( "ProjectBase", getRspnProjectBaseRecHandler() );
			rspnDomainBaseReadSingleHandler.addElementHandler( "RealProject", getRspnRealProjectRecHandler() );
			rspnDomainBaseReadSingleHandler.addElementHandler( "TopProject", getRspnTopProjectRecHandler() );
			rspnDomainBaseReadSingleHandler.addElementHandler( "SubProject", getRspnSubProjectRecHandler() );
			rspnDomainBaseReadSingleHandler.addElementHandler( "Version", getRspnVersionRecHandler() );
			rspnDomainBaseReadSingleHandler.addElementHandler( "MajorVersion", getRspnMajorVersionRecHandler() );
			rspnDomainBaseReadSingleHandler.addElementHandler( "MinorVersion", getRspnMinorVersionRecHandler() );
		}
		return( rspnDomainBaseReadSingleHandler );
	}

	protected CFBamXMsgRspnDomainBaseReadListHandler getRspnDomainBaseReadListHandler() {
		if( rspnDomainBaseReadListHandler == null ) {
			rspnDomainBaseReadListHandler = new CFBamXMsgRspnDomainBaseReadListHandler( this );
			rspnDomainBaseReadListHandler.addElementHandler( "DomainBase", getRspnDomainBaseRecHandler() );
			rspnDomainBaseReadListHandler.addElementHandler( "TopDomain", getRspnTopDomainRecHandler() );
			rspnDomainBaseReadListHandler.addElementHandler( "Domain", getRspnDomainRecHandler() );
			rspnDomainBaseReadListHandler.addElementHandler( "ProjectBase", getRspnProjectBaseRecHandler() );
			rspnDomainBaseReadListHandler.addElementHandler( "RealProject", getRspnRealProjectRecHandler() );
			rspnDomainBaseReadListHandler.addElementHandler( "TopProject", getRspnTopProjectRecHandler() );
			rspnDomainBaseReadListHandler.addElementHandler( "SubProject", getRspnSubProjectRecHandler() );
			rspnDomainBaseReadListHandler.addElementHandler( "Version", getRspnVersionRecHandler() );
			rspnDomainBaseReadListHandler.addElementHandler( "MajorVersion", getRspnMajorVersionRecHandler() );
			rspnDomainBaseReadListHandler.addElementHandler( "MinorVersion", getRspnMinorVersionRecHandler() );
		}
		return( rspnDomainBaseReadListHandler );
	}

	protected CFBamXMsgRspnDomainBaseLockedHandler getRspnDomainBaseLockedHandler() {
		if( rspnDomainBaseLockedHandler == null ) {
			rspnDomainBaseLockedHandler = new CFBamXMsgRspnDomainBaseLockedHandler( this );
		}
		return( rspnDomainBaseLockedHandler );
	}

	protected CFBamXMsgRspnDomainBaseUpdatedHandler getRspnDomainBaseUpdatedHandler() {
		if( rspnDomainBaseUpdatedHandler == null ) {
			rspnDomainBaseUpdatedHandler = new CFBamXMsgRspnDomainBaseUpdatedHandler( this );
		}
		return( rspnDomainBaseUpdatedHandler );
	}

	protected CFBamXMsgRspnDomainBaseDeletedHandler getRspnDomainBaseDeletedHandler() {
		if( rspnDomainBaseDeletedHandler == null ) {
			rspnDomainBaseDeletedHandler = new CFBamXMsgRspnDomainBaseDeletedHandler( this );
		}
		return( rspnDomainBaseDeletedHandler );
	}

	// DoubleCol Response Handlers

	protected CFBamXMsgRspnDoubleColRecHandler getRspnDoubleColRecHandler() {
		if( rspnDoubleColRecHandler == null ) {
			rspnDoubleColRecHandler = new CFBamXMsgRspnDoubleColRecHandler( this );
		}
		return( rspnDoubleColRecHandler );
	}

	protected CFBamXMsgRspnDoubleColCreatedHandler getRspnDoubleColCreatedHandler() {
		if( rspnDoubleColCreatedHandler == null ) {
			rspnDoubleColCreatedHandler = new CFBamXMsgRspnDoubleColCreatedHandler( this );
		}
		return( rspnDoubleColCreatedHandler );
	}

	protected CFBamXMsgRspnDoubleColReadSingleHandler getRspnDoubleColReadSingleHandler() {
		if( rspnDoubleColReadSingleHandler == null ) {
			rspnDoubleColReadSingleHandler = new CFBamXMsgRspnDoubleColReadSingleHandler( this );
			rspnDoubleColReadSingleHandler.addElementHandler( "DoubleCol", getRspnDoubleColRecHandler() );
		}
		return( rspnDoubleColReadSingleHandler );
	}

	protected CFBamXMsgRspnDoubleColReadListHandler getRspnDoubleColReadListHandler() {
		if( rspnDoubleColReadListHandler == null ) {
			rspnDoubleColReadListHandler = new CFBamXMsgRspnDoubleColReadListHandler( this );
			rspnDoubleColReadListHandler.addElementHandler( "DoubleCol", getRspnDoubleColRecHandler() );
		}
		return( rspnDoubleColReadListHandler );
	}

	protected CFBamXMsgRspnDoubleColLockedHandler getRspnDoubleColLockedHandler() {
		if( rspnDoubleColLockedHandler == null ) {
			rspnDoubleColLockedHandler = new CFBamXMsgRspnDoubleColLockedHandler( this );
		}
		return( rspnDoubleColLockedHandler );
	}

	protected CFBamXMsgRspnDoubleColUpdatedHandler getRspnDoubleColUpdatedHandler() {
		if( rspnDoubleColUpdatedHandler == null ) {
			rspnDoubleColUpdatedHandler = new CFBamXMsgRspnDoubleColUpdatedHandler( this );
		}
		return( rspnDoubleColUpdatedHandler );
	}

	protected CFBamXMsgRspnDoubleColDeletedHandler getRspnDoubleColDeletedHandler() {
		if( rspnDoubleColDeletedHandler == null ) {
			rspnDoubleColDeletedHandler = new CFBamXMsgRspnDoubleColDeletedHandler( this );
		}
		return( rspnDoubleColDeletedHandler );
	}

	// DoubleDef Response Handlers

	protected CFBamXMsgRspnDoubleDefRecHandler getRspnDoubleDefRecHandler() {
		if( rspnDoubleDefRecHandler == null ) {
			rspnDoubleDefRecHandler = new CFBamXMsgRspnDoubleDefRecHandler( this );
		}
		return( rspnDoubleDefRecHandler );
	}

	protected CFBamXMsgRspnDoubleDefCreatedHandler getRspnDoubleDefCreatedHandler() {
		if( rspnDoubleDefCreatedHandler == null ) {
			rspnDoubleDefCreatedHandler = new CFBamXMsgRspnDoubleDefCreatedHandler( this );
		}
		return( rspnDoubleDefCreatedHandler );
	}

	protected CFBamXMsgRspnDoubleDefReadSingleHandler getRspnDoubleDefReadSingleHandler() {
		if( rspnDoubleDefReadSingleHandler == null ) {
			rspnDoubleDefReadSingleHandler = new CFBamXMsgRspnDoubleDefReadSingleHandler( this );
			rspnDoubleDefReadSingleHandler.addElementHandler( "DoubleDef", getRspnDoubleDefRecHandler() );
			rspnDoubleDefReadSingleHandler.addElementHandler( "DoubleCol", getRspnDoubleColRecHandler() );
			rspnDoubleDefReadSingleHandler.addElementHandler( "DoubleType", getRspnDoubleTypeRecHandler() );
		}
		return( rspnDoubleDefReadSingleHandler );
	}

	protected CFBamXMsgRspnDoubleDefReadListHandler getRspnDoubleDefReadListHandler() {
		if( rspnDoubleDefReadListHandler == null ) {
			rspnDoubleDefReadListHandler = new CFBamXMsgRspnDoubleDefReadListHandler( this );
			rspnDoubleDefReadListHandler.addElementHandler( "DoubleDef", getRspnDoubleDefRecHandler() );
			rspnDoubleDefReadListHandler.addElementHandler( "DoubleCol", getRspnDoubleColRecHandler() );
			rspnDoubleDefReadListHandler.addElementHandler( "DoubleType", getRspnDoubleTypeRecHandler() );
		}
		return( rspnDoubleDefReadListHandler );
	}

	protected CFBamXMsgRspnDoubleDefLockedHandler getRspnDoubleDefLockedHandler() {
		if( rspnDoubleDefLockedHandler == null ) {
			rspnDoubleDefLockedHandler = new CFBamXMsgRspnDoubleDefLockedHandler( this );
		}
		return( rspnDoubleDefLockedHandler );
	}

	protected CFBamXMsgRspnDoubleDefUpdatedHandler getRspnDoubleDefUpdatedHandler() {
		if( rspnDoubleDefUpdatedHandler == null ) {
			rspnDoubleDefUpdatedHandler = new CFBamXMsgRspnDoubleDefUpdatedHandler( this );
		}
		return( rspnDoubleDefUpdatedHandler );
	}

	protected CFBamXMsgRspnDoubleDefDeletedHandler getRspnDoubleDefDeletedHandler() {
		if( rspnDoubleDefDeletedHandler == null ) {
			rspnDoubleDefDeletedHandler = new CFBamXMsgRspnDoubleDefDeletedHandler( this );
		}
		return( rspnDoubleDefDeletedHandler );
	}

	// DoubleType Response Handlers

	protected CFBamXMsgRspnDoubleTypeRecHandler getRspnDoubleTypeRecHandler() {
		if( rspnDoubleTypeRecHandler == null ) {
			rspnDoubleTypeRecHandler = new CFBamXMsgRspnDoubleTypeRecHandler( this );
		}
		return( rspnDoubleTypeRecHandler );
	}

	protected CFBamXMsgRspnDoubleTypeCreatedHandler getRspnDoubleTypeCreatedHandler() {
		if( rspnDoubleTypeCreatedHandler == null ) {
			rspnDoubleTypeCreatedHandler = new CFBamXMsgRspnDoubleTypeCreatedHandler( this );
		}
		return( rspnDoubleTypeCreatedHandler );
	}

	protected CFBamXMsgRspnDoubleTypeReadSingleHandler getRspnDoubleTypeReadSingleHandler() {
		if( rspnDoubleTypeReadSingleHandler == null ) {
			rspnDoubleTypeReadSingleHandler = new CFBamXMsgRspnDoubleTypeReadSingleHandler( this );
			rspnDoubleTypeReadSingleHandler.addElementHandler( "DoubleType", getRspnDoubleTypeRecHandler() );
		}
		return( rspnDoubleTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnDoubleTypeReadListHandler getRspnDoubleTypeReadListHandler() {
		if( rspnDoubleTypeReadListHandler == null ) {
			rspnDoubleTypeReadListHandler = new CFBamXMsgRspnDoubleTypeReadListHandler( this );
			rspnDoubleTypeReadListHandler.addElementHandler( "DoubleType", getRspnDoubleTypeRecHandler() );
		}
		return( rspnDoubleTypeReadListHandler );
	}

	protected CFBamXMsgRspnDoubleTypeLockedHandler getRspnDoubleTypeLockedHandler() {
		if( rspnDoubleTypeLockedHandler == null ) {
			rspnDoubleTypeLockedHandler = new CFBamXMsgRspnDoubleTypeLockedHandler( this );
		}
		return( rspnDoubleTypeLockedHandler );
	}

	protected CFBamXMsgRspnDoubleTypeUpdatedHandler getRspnDoubleTypeUpdatedHandler() {
		if( rspnDoubleTypeUpdatedHandler == null ) {
			rspnDoubleTypeUpdatedHandler = new CFBamXMsgRspnDoubleTypeUpdatedHandler( this );
		}
		return( rspnDoubleTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnDoubleTypeDeletedHandler getRspnDoubleTypeDeletedHandler() {
		if( rspnDoubleTypeDeletedHandler == null ) {
			rspnDoubleTypeDeletedHandler = new CFBamXMsgRspnDoubleTypeDeletedHandler( this );
		}
		return( rspnDoubleTypeDeletedHandler );
	}

	// EnumCol Response Handlers

	protected CFBamXMsgRspnEnumColRecHandler getRspnEnumColRecHandler() {
		if( rspnEnumColRecHandler == null ) {
			rspnEnumColRecHandler = new CFBamXMsgRspnEnumColRecHandler( this );
		}
		return( rspnEnumColRecHandler );
	}

	protected CFBamXMsgRspnEnumColCreatedHandler getRspnEnumColCreatedHandler() {
		if( rspnEnumColCreatedHandler == null ) {
			rspnEnumColCreatedHandler = new CFBamXMsgRspnEnumColCreatedHandler( this );
		}
		return( rspnEnumColCreatedHandler );
	}

	protected CFBamXMsgRspnEnumColReadSingleHandler getRspnEnumColReadSingleHandler() {
		if( rspnEnumColReadSingleHandler == null ) {
			rspnEnumColReadSingleHandler = new CFBamXMsgRspnEnumColReadSingleHandler( this );
			rspnEnumColReadSingleHandler.addElementHandler( "EnumCol", getRspnEnumColRecHandler() );
		}
		return( rspnEnumColReadSingleHandler );
	}

	protected CFBamXMsgRspnEnumColReadListHandler getRspnEnumColReadListHandler() {
		if( rspnEnumColReadListHandler == null ) {
			rspnEnumColReadListHandler = new CFBamXMsgRspnEnumColReadListHandler( this );
			rspnEnumColReadListHandler.addElementHandler( "EnumCol", getRspnEnumColRecHandler() );
		}
		return( rspnEnumColReadListHandler );
	}

	protected CFBamXMsgRspnEnumColLockedHandler getRspnEnumColLockedHandler() {
		if( rspnEnumColLockedHandler == null ) {
			rspnEnumColLockedHandler = new CFBamXMsgRspnEnumColLockedHandler( this );
		}
		return( rspnEnumColLockedHandler );
	}

	protected CFBamXMsgRspnEnumColUpdatedHandler getRspnEnumColUpdatedHandler() {
		if( rspnEnumColUpdatedHandler == null ) {
			rspnEnumColUpdatedHandler = new CFBamXMsgRspnEnumColUpdatedHandler( this );
		}
		return( rspnEnumColUpdatedHandler );
	}

	protected CFBamXMsgRspnEnumColDeletedHandler getRspnEnumColDeletedHandler() {
		if( rspnEnumColDeletedHandler == null ) {
			rspnEnumColDeletedHandler = new CFBamXMsgRspnEnumColDeletedHandler( this );
		}
		return( rspnEnumColDeletedHandler );
	}

	// EnumDef Response Handlers

	protected CFBamXMsgRspnEnumDefRecHandler getRspnEnumDefRecHandler() {
		if( rspnEnumDefRecHandler == null ) {
			rspnEnumDefRecHandler = new CFBamXMsgRspnEnumDefRecHandler( this );
		}
		return( rspnEnumDefRecHandler );
	}

	protected CFBamXMsgRspnEnumDefCreatedHandler getRspnEnumDefCreatedHandler() {
		if( rspnEnumDefCreatedHandler == null ) {
			rspnEnumDefCreatedHandler = new CFBamXMsgRspnEnumDefCreatedHandler( this );
		}
		return( rspnEnumDefCreatedHandler );
	}

	protected CFBamXMsgRspnEnumDefReadSingleHandler getRspnEnumDefReadSingleHandler() {
		if( rspnEnumDefReadSingleHandler == null ) {
			rspnEnumDefReadSingleHandler = new CFBamXMsgRspnEnumDefReadSingleHandler( this );
			rspnEnumDefReadSingleHandler.addElementHandler( "EnumDef", getRspnEnumDefRecHandler() );
			rspnEnumDefReadSingleHandler.addElementHandler( "EnumCol", getRspnEnumColRecHandler() );
			rspnEnumDefReadSingleHandler.addElementHandler( "EnumType", getRspnEnumTypeRecHandler() );
		}
		return( rspnEnumDefReadSingleHandler );
	}

	protected CFBamXMsgRspnEnumDefReadListHandler getRspnEnumDefReadListHandler() {
		if( rspnEnumDefReadListHandler == null ) {
			rspnEnumDefReadListHandler = new CFBamXMsgRspnEnumDefReadListHandler( this );
			rspnEnumDefReadListHandler.addElementHandler( "EnumDef", getRspnEnumDefRecHandler() );
			rspnEnumDefReadListHandler.addElementHandler( "EnumCol", getRspnEnumColRecHandler() );
			rspnEnumDefReadListHandler.addElementHandler( "EnumType", getRspnEnumTypeRecHandler() );
		}
		return( rspnEnumDefReadListHandler );
	}

	protected CFBamXMsgRspnEnumDefLockedHandler getRspnEnumDefLockedHandler() {
		if( rspnEnumDefLockedHandler == null ) {
			rspnEnumDefLockedHandler = new CFBamXMsgRspnEnumDefLockedHandler( this );
		}
		return( rspnEnumDefLockedHandler );
	}

	protected CFBamXMsgRspnEnumDefUpdatedHandler getRspnEnumDefUpdatedHandler() {
		if( rspnEnumDefUpdatedHandler == null ) {
			rspnEnumDefUpdatedHandler = new CFBamXMsgRspnEnumDefUpdatedHandler( this );
		}
		return( rspnEnumDefUpdatedHandler );
	}

	protected CFBamXMsgRspnEnumDefDeletedHandler getRspnEnumDefDeletedHandler() {
		if( rspnEnumDefDeletedHandler == null ) {
			rspnEnumDefDeletedHandler = new CFBamXMsgRspnEnumDefDeletedHandler( this );
		}
		return( rspnEnumDefDeletedHandler );
	}

	// EnumTag Response Handlers

	protected CFBamXMsgRspnEnumTagRecHandler getRspnEnumTagRecHandler() {
		if( rspnEnumTagRecHandler == null ) {
			rspnEnumTagRecHandler = new CFBamXMsgRspnEnumTagRecHandler( this );
		}
		return( rspnEnumTagRecHandler );
	}

	protected CFBamXMsgRspnEnumTagCreatedHandler getRspnEnumTagCreatedHandler() {
		if( rspnEnumTagCreatedHandler == null ) {
			rspnEnumTagCreatedHandler = new CFBamXMsgRspnEnumTagCreatedHandler( this );
		}
		return( rspnEnumTagCreatedHandler );
	}

	protected CFBamXMsgRspnEnumTagReadSingleHandler getRspnEnumTagReadSingleHandler() {
		if( rspnEnumTagReadSingleHandler == null ) {
			rspnEnumTagReadSingleHandler = new CFBamXMsgRspnEnumTagReadSingleHandler( this );
			rspnEnumTagReadSingleHandler.addElementHandler( "EnumTag", getRspnEnumTagRecHandler() );
		}
		return( rspnEnumTagReadSingleHandler );
	}

	protected CFBamXMsgRspnEnumTagReadListHandler getRspnEnumTagReadListHandler() {
		if( rspnEnumTagReadListHandler == null ) {
			rspnEnumTagReadListHandler = new CFBamXMsgRspnEnumTagReadListHandler( this );
			rspnEnumTagReadListHandler.addElementHandler( "EnumTag", getRspnEnumTagRecHandler() );
		}
		return( rspnEnumTagReadListHandler );
	}

	protected CFBamXMsgRspnEnumTagLockedHandler getRspnEnumTagLockedHandler() {
		if( rspnEnumTagLockedHandler == null ) {
			rspnEnumTagLockedHandler = new CFBamXMsgRspnEnumTagLockedHandler( this );
		}
		return( rspnEnumTagLockedHandler );
	}

	protected CFBamXMsgRspnEnumTagUpdatedHandler getRspnEnumTagUpdatedHandler() {
		if( rspnEnumTagUpdatedHandler == null ) {
			rspnEnumTagUpdatedHandler = new CFBamXMsgRspnEnumTagUpdatedHandler( this );
		}
		return( rspnEnumTagUpdatedHandler );
	}

	protected CFBamXMsgRspnEnumTagDeletedHandler getRspnEnumTagDeletedHandler() {
		if( rspnEnumTagDeletedHandler == null ) {
			rspnEnumTagDeletedHandler = new CFBamXMsgRspnEnumTagDeletedHandler( this );
		}
		return( rspnEnumTagDeletedHandler );
	}

	// EnumType Response Handlers

	protected CFBamXMsgRspnEnumTypeRecHandler getRspnEnumTypeRecHandler() {
		if( rspnEnumTypeRecHandler == null ) {
			rspnEnumTypeRecHandler = new CFBamXMsgRspnEnumTypeRecHandler( this );
		}
		return( rspnEnumTypeRecHandler );
	}

	protected CFBamXMsgRspnEnumTypeCreatedHandler getRspnEnumTypeCreatedHandler() {
		if( rspnEnumTypeCreatedHandler == null ) {
			rspnEnumTypeCreatedHandler = new CFBamXMsgRspnEnumTypeCreatedHandler( this );
		}
		return( rspnEnumTypeCreatedHandler );
	}

	protected CFBamXMsgRspnEnumTypeReadSingleHandler getRspnEnumTypeReadSingleHandler() {
		if( rspnEnumTypeReadSingleHandler == null ) {
			rspnEnumTypeReadSingleHandler = new CFBamXMsgRspnEnumTypeReadSingleHandler( this );
			rspnEnumTypeReadSingleHandler.addElementHandler( "EnumType", getRspnEnumTypeRecHandler() );
		}
		return( rspnEnumTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnEnumTypeReadListHandler getRspnEnumTypeReadListHandler() {
		if( rspnEnumTypeReadListHandler == null ) {
			rspnEnumTypeReadListHandler = new CFBamXMsgRspnEnumTypeReadListHandler( this );
			rspnEnumTypeReadListHandler.addElementHandler( "EnumType", getRspnEnumTypeRecHandler() );
		}
		return( rspnEnumTypeReadListHandler );
	}

	protected CFBamXMsgRspnEnumTypeLockedHandler getRspnEnumTypeLockedHandler() {
		if( rspnEnumTypeLockedHandler == null ) {
			rspnEnumTypeLockedHandler = new CFBamXMsgRspnEnumTypeLockedHandler( this );
		}
		return( rspnEnumTypeLockedHandler );
	}

	protected CFBamXMsgRspnEnumTypeUpdatedHandler getRspnEnumTypeUpdatedHandler() {
		if( rspnEnumTypeUpdatedHandler == null ) {
			rspnEnumTypeUpdatedHandler = new CFBamXMsgRspnEnumTypeUpdatedHandler( this );
		}
		return( rspnEnumTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnEnumTypeDeletedHandler getRspnEnumTypeDeletedHandler() {
		if( rspnEnumTypeDeletedHandler == null ) {
			rspnEnumTypeDeletedHandler = new CFBamXMsgRspnEnumTypeDeletedHandler( this );
		}
		return( rspnEnumTypeDeletedHandler );
	}

	// FloatCol Response Handlers

	protected CFBamXMsgRspnFloatColRecHandler getRspnFloatColRecHandler() {
		if( rspnFloatColRecHandler == null ) {
			rspnFloatColRecHandler = new CFBamXMsgRspnFloatColRecHandler( this );
		}
		return( rspnFloatColRecHandler );
	}

	protected CFBamXMsgRspnFloatColCreatedHandler getRspnFloatColCreatedHandler() {
		if( rspnFloatColCreatedHandler == null ) {
			rspnFloatColCreatedHandler = new CFBamXMsgRspnFloatColCreatedHandler( this );
		}
		return( rspnFloatColCreatedHandler );
	}

	protected CFBamXMsgRspnFloatColReadSingleHandler getRspnFloatColReadSingleHandler() {
		if( rspnFloatColReadSingleHandler == null ) {
			rspnFloatColReadSingleHandler = new CFBamXMsgRspnFloatColReadSingleHandler( this );
			rspnFloatColReadSingleHandler.addElementHandler( "FloatCol", getRspnFloatColRecHandler() );
		}
		return( rspnFloatColReadSingleHandler );
	}

	protected CFBamXMsgRspnFloatColReadListHandler getRspnFloatColReadListHandler() {
		if( rspnFloatColReadListHandler == null ) {
			rspnFloatColReadListHandler = new CFBamXMsgRspnFloatColReadListHandler( this );
			rspnFloatColReadListHandler.addElementHandler( "FloatCol", getRspnFloatColRecHandler() );
		}
		return( rspnFloatColReadListHandler );
	}

	protected CFBamXMsgRspnFloatColLockedHandler getRspnFloatColLockedHandler() {
		if( rspnFloatColLockedHandler == null ) {
			rspnFloatColLockedHandler = new CFBamXMsgRspnFloatColLockedHandler( this );
		}
		return( rspnFloatColLockedHandler );
	}

	protected CFBamXMsgRspnFloatColUpdatedHandler getRspnFloatColUpdatedHandler() {
		if( rspnFloatColUpdatedHandler == null ) {
			rspnFloatColUpdatedHandler = new CFBamXMsgRspnFloatColUpdatedHandler( this );
		}
		return( rspnFloatColUpdatedHandler );
	}

	protected CFBamXMsgRspnFloatColDeletedHandler getRspnFloatColDeletedHandler() {
		if( rspnFloatColDeletedHandler == null ) {
			rspnFloatColDeletedHandler = new CFBamXMsgRspnFloatColDeletedHandler( this );
		}
		return( rspnFloatColDeletedHandler );
	}

	// FloatDef Response Handlers

	protected CFBamXMsgRspnFloatDefRecHandler getRspnFloatDefRecHandler() {
		if( rspnFloatDefRecHandler == null ) {
			rspnFloatDefRecHandler = new CFBamXMsgRspnFloatDefRecHandler( this );
		}
		return( rspnFloatDefRecHandler );
	}

	protected CFBamXMsgRspnFloatDefCreatedHandler getRspnFloatDefCreatedHandler() {
		if( rspnFloatDefCreatedHandler == null ) {
			rspnFloatDefCreatedHandler = new CFBamXMsgRspnFloatDefCreatedHandler( this );
		}
		return( rspnFloatDefCreatedHandler );
	}

	protected CFBamXMsgRspnFloatDefReadSingleHandler getRspnFloatDefReadSingleHandler() {
		if( rspnFloatDefReadSingleHandler == null ) {
			rspnFloatDefReadSingleHandler = new CFBamXMsgRspnFloatDefReadSingleHandler( this );
			rspnFloatDefReadSingleHandler.addElementHandler( "FloatDef", getRspnFloatDefRecHandler() );
			rspnFloatDefReadSingleHandler.addElementHandler( "FloatCol", getRspnFloatColRecHandler() );
			rspnFloatDefReadSingleHandler.addElementHandler( "FloatType", getRspnFloatTypeRecHandler() );
		}
		return( rspnFloatDefReadSingleHandler );
	}

	protected CFBamXMsgRspnFloatDefReadListHandler getRspnFloatDefReadListHandler() {
		if( rspnFloatDefReadListHandler == null ) {
			rspnFloatDefReadListHandler = new CFBamXMsgRspnFloatDefReadListHandler( this );
			rspnFloatDefReadListHandler.addElementHandler( "FloatDef", getRspnFloatDefRecHandler() );
			rspnFloatDefReadListHandler.addElementHandler( "FloatCol", getRspnFloatColRecHandler() );
			rspnFloatDefReadListHandler.addElementHandler( "FloatType", getRspnFloatTypeRecHandler() );
		}
		return( rspnFloatDefReadListHandler );
	}

	protected CFBamXMsgRspnFloatDefLockedHandler getRspnFloatDefLockedHandler() {
		if( rspnFloatDefLockedHandler == null ) {
			rspnFloatDefLockedHandler = new CFBamXMsgRspnFloatDefLockedHandler( this );
		}
		return( rspnFloatDefLockedHandler );
	}

	protected CFBamXMsgRspnFloatDefUpdatedHandler getRspnFloatDefUpdatedHandler() {
		if( rspnFloatDefUpdatedHandler == null ) {
			rspnFloatDefUpdatedHandler = new CFBamXMsgRspnFloatDefUpdatedHandler( this );
		}
		return( rspnFloatDefUpdatedHandler );
	}

	protected CFBamXMsgRspnFloatDefDeletedHandler getRspnFloatDefDeletedHandler() {
		if( rspnFloatDefDeletedHandler == null ) {
			rspnFloatDefDeletedHandler = new CFBamXMsgRspnFloatDefDeletedHandler( this );
		}
		return( rspnFloatDefDeletedHandler );
	}

	// FloatType Response Handlers

	protected CFBamXMsgRspnFloatTypeRecHandler getRspnFloatTypeRecHandler() {
		if( rspnFloatTypeRecHandler == null ) {
			rspnFloatTypeRecHandler = new CFBamXMsgRspnFloatTypeRecHandler( this );
		}
		return( rspnFloatTypeRecHandler );
	}

	protected CFBamXMsgRspnFloatTypeCreatedHandler getRspnFloatTypeCreatedHandler() {
		if( rspnFloatTypeCreatedHandler == null ) {
			rspnFloatTypeCreatedHandler = new CFBamXMsgRspnFloatTypeCreatedHandler( this );
		}
		return( rspnFloatTypeCreatedHandler );
	}

	protected CFBamXMsgRspnFloatTypeReadSingleHandler getRspnFloatTypeReadSingleHandler() {
		if( rspnFloatTypeReadSingleHandler == null ) {
			rspnFloatTypeReadSingleHandler = new CFBamXMsgRspnFloatTypeReadSingleHandler( this );
			rspnFloatTypeReadSingleHandler.addElementHandler( "FloatType", getRspnFloatTypeRecHandler() );
		}
		return( rspnFloatTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnFloatTypeReadListHandler getRspnFloatTypeReadListHandler() {
		if( rspnFloatTypeReadListHandler == null ) {
			rspnFloatTypeReadListHandler = new CFBamXMsgRspnFloatTypeReadListHandler( this );
			rspnFloatTypeReadListHandler.addElementHandler( "FloatType", getRspnFloatTypeRecHandler() );
		}
		return( rspnFloatTypeReadListHandler );
	}

	protected CFBamXMsgRspnFloatTypeLockedHandler getRspnFloatTypeLockedHandler() {
		if( rspnFloatTypeLockedHandler == null ) {
			rspnFloatTypeLockedHandler = new CFBamXMsgRspnFloatTypeLockedHandler( this );
		}
		return( rspnFloatTypeLockedHandler );
	}

	protected CFBamXMsgRspnFloatTypeUpdatedHandler getRspnFloatTypeUpdatedHandler() {
		if( rspnFloatTypeUpdatedHandler == null ) {
			rspnFloatTypeUpdatedHandler = new CFBamXMsgRspnFloatTypeUpdatedHandler( this );
		}
		return( rspnFloatTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnFloatTypeDeletedHandler getRspnFloatTypeDeletedHandler() {
		if( rspnFloatTypeDeletedHandler == null ) {
			rspnFloatTypeDeletedHandler = new CFBamXMsgRspnFloatTypeDeletedHandler( this );
		}
		return( rspnFloatTypeDeletedHandler );
	}

	// HostNode Response Handlers

	protected CFBamXMsgRspnHostNodeRecHandler getRspnHostNodeRecHandler() {
		if( rspnHostNodeRecHandler == null ) {
			rspnHostNodeRecHandler = new CFBamXMsgRspnHostNodeRecHandler( this );
		}
		return( rspnHostNodeRecHandler );
	}

	protected CFBamXMsgRspnHostNodeCreatedHandler getRspnHostNodeCreatedHandler() {
		if( rspnHostNodeCreatedHandler == null ) {
			rspnHostNodeCreatedHandler = new CFBamXMsgRspnHostNodeCreatedHandler( this );
		}
		return( rspnHostNodeCreatedHandler );
	}

	protected CFBamXMsgRspnHostNodeReadSingleHandler getRspnHostNodeReadSingleHandler() {
		if( rspnHostNodeReadSingleHandler == null ) {
			rspnHostNodeReadSingleHandler = new CFBamXMsgRspnHostNodeReadSingleHandler( this );
			rspnHostNodeReadSingleHandler.addElementHandler( "HostNode", getRspnHostNodeRecHandler() );
		}
		return( rspnHostNodeReadSingleHandler );
	}

	protected CFBamXMsgRspnHostNodeReadListHandler getRspnHostNodeReadListHandler() {
		if( rspnHostNodeReadListHandler == null ) {
			rspnHostNodeReadListHandler = new CFBamXMsgRspnHostNodeReadListHandler( this );
			rspnHostNodeReadListHandler.addElementHandler( "HostNode", getRspnHostNodeRecHandler() );
		}
		return( rspnHostNodeReadListHandler );
	}

	protected CFBamXMsgRspnHostNodeLockedHandler getRspnHostNodeLockedHandler() {
		if( rspnHostNodeLockedHandler == null ) {
			rspnHostNodeLockedHandler = new CFBamXMsgRspnHostNodeLockedHandler( this );
		}
		return( rspnHostNodeLockedHandler );
	}

	protected CFBamXMsgRspnHostNodeUpdatedHandler getRspnHostNodeUpdatedHandler() {
		if( rspnHostNodeUpdatedHandler == null ) {
			rspnHostNodeUpdatedHandler = new CFBamXMsgRspnHostNodeUpdatedHandler( this );
		}
		return( rspnHostNodeUpdatedHandler );
	}

	protected CFBamXMsgRspnHostNodeDeletedHandler getRspnHostNodeDeletedHandler() {
		if( rspnHostNodeDeletedHandler == null ) {
			rspnHostNodeDeletedHandler = new CFBamXMsgRspnHostNodeDeletedHandler( this );
		}
		return( rspnHostNodeDeletedHandler );
	}

	// ISOCountry Response Handlers

	protected CFBamXMsgRspnISOCountryRecHandler getRspnISOCountryRecHandler() {
		if( rspnISOCountryRecHandler == null ) {
			rspnISOCountryRecHandler = new CFBamXMsgRspnISOCountryRecHandler( this );
		}
		return( rspnISOCountryRecHandler );
	}

	protected CFBamXMsgRspnISOCountryCreatedHandler getRspnISOCountryCreatedHandler() {
		if( rspnISOCountryCreatedHandler == null ) {
			rspnISOCountryCreatedHandler = new CFBamXMsgRspnISOCountryCreatedHandler( this );
		}
		return( rspnISOCountryCreatedHandler );
	}

	protected CFBamXMsgRspnISOCountryReadSingleHandler getRspnISOCountryReadSingleHandler() {
		if( rspnISOCountryReadSingleHandler == null ) {
			rspnISOCountryReadSingleHandler = new CFBamXMsgRspnISOCountryReadSingleHandler( this );
			rspnISOCountryReadSingleHandler.addElementHandler( "ISOCountry", getRspnISOCountryRecHandler() );
		}
		return( rspnISOCountryReadSingleHandler );
	}

	protected CFBamXMsgRspnISOCountryReadListHandler getRspnISOCountryReadListHandler() {
		if( rspnISOCountryReadListHandler == null ) {
			rspnISOCountryReadListHandler = new CFBamXMsgRspnISOCountryReadListHandler( this );
			rspnISOCountryReadListHandler.addElementHandler( "ISOCountry", getRspnISOCountryRecHandler() );
		}
		return( rspnISOCountryReadListHandler );
	}

	protected CFBamXMsgRspnISOCountryLockedHandler getRspnISOCountryLockedHandler() {
		if( rspnISOCountryLockedHandler == null ) {
			rspnISOCountryLockedHandler = new CFBamXMsgRspnISOCountryLockedHandler( this );
		}
		return( rspnISOCountryLockedHandler );
	}

	protected CFBamXMsgRspnISOCountryUpdatedHandler getRspnISOCountryUpdatedHandler() {
		if( rspnISOCountryUpdatedHandler == null ) {
			rspnISOCountryUpdatedHandler = new CFBamXMsgRspnISOCountryUpdatedHandler( this );
		}
		return( rspnISOCountryUpdatedHandler );
	}

	protected CFBamXMsgRspnISOCountryDeletedHandler getRspnISOCountryDeletedHandler() {
		if( rspnISOCountryDeletedHandler == null ) {
			rspnISOCountryDeletedHandler = new CFBamXMsgRspnISOCountryDeletedHandler( this );
		}
		return( rspnISOCountryDeletedHandler );
	}

	// ISOCountryCurrency Response Handlers

	protected CFBamXMsgRspnISOCountryCurrencyRecHandler getRspnISOCountryCurrencyRecHandler() {
		if( rspnISOCountryCurrencyRecHandler == null ) {
			rspnISOCountryCurrencyRecHandler = new CFBamXMsgRspnISOCountryCurrencyRecHandler( this );
		}
		return( rspnISOCountryCurrencyRecHandler );
	}

	protected CFBamXMsgRspnISOCountryCurrencyCreatedHandler getRspnISOCountryCurrencyCreatedHandler() {
		if( rspnISOCountryCurrencyCreatedHandler == null ) {
			rspnISOCountryCurrencyCreatedHandler = new CFBamXMsgRspnISOCountryCurrencyCreatedHandler( this );
		}
		return( rspnISOCountryCurrencyCreatedHandler );
	}

	protected CFBamXMsgRspnISOCountryCurrencyReadSingleHandler getRspnISOCountryCurrencyReadSingleHandler() {
		if( rspnISOCountryCurrencyReadSingleHandler == null ) {
			rspnISOCountryCurrencyReadSingleHandler = new CFBamXMsgRspnISOCountryCurrencyReadSingleHandler( this );
			rspnISOCountryCurrencyReadSingleHandler.addElementHandler( "ISOCountryCurrency", getRspnISOCountryCurrencyRecHandler() );
		}
		return( rspnISOCountryCurrencyReadSingleHandler );
	}

	protected CFBamXMsgRspnISOCountryCurrencyReadListHandler getRspnISOCountryCurrencyReadListHandler() {
		if( rspnISOCountryCurrencyReadListHandler == null ) {
			rspnISOCountryCurrencyReadListHandler = new CFBamXMsgRspnISOCountryCurrencyReadListHandler( this );
			rspnISOCountryCurrencyReadListHandler.addElementHandler( "ISOCountryCurrency", getRspnISOCountryCurrencyRecHandler() );
		}
		return( rspnISOCountryCurrencyReadListHandler );
	}

	protected CFBamXMsgRspnISOCountryCurrencyLockedHandler getRspnISOCountryCurrencyLockedHandler() {
		if( rspnISOCountryCurrencyLockedHandler == null ) {
			rspnISOCountryCurrencyLockedHandler = new CFBamXMsgRspnISOCountryCurrencyLockedHandler( this );
		}
		return( rspnISOCountryCurrencyLockedHandler );
	}

	protected CFBamXMsgRspnISOCountryCurrencyUpdatedHandler getRspnISOCountryCurrencyUpdatedHandler() {
		if( rspnISOCountryCurrencyUpdatedHandler == null ) {
			rspnISOCountryCurrencyUpdatedHandler = new CFBamXMsgRspnISOCountryCurrencyUpdatedHandler( this );
		}
		return( rspnISOCountryCurrencyUpdatedHandler );
	}

	protected CFBamXMsgRspnISOCountryCurrencyDeletedHandler getRspnISOCountryCurrencyDeletedHandler() {
		if( rspnISOCountryCurrencyDeletedHandler == null ) {
			rspnISOCountryCurrencyDeletedHandler = new CFBamXMsgRspnISOCountryCurrencyDeletedHandler( this );
		}
		return( rspnISOCountryCurrencyDeletedHandler );
	}

	// ISOCountryLanguage Response Handlers

	protected CFBamXMsgRspnISOCountryLanguageRecHandler getRspnISOCountryLanguageRecHandler() {
		if( rspnISOCountryLanguageRecHandler == null ) {
			rspnISOCountryLanguageRecHandler = new CFBamXMsgRspnISOCountryLanguageRecHandler( this );
		}
		return( rspnISOCountryLanguageRecHandler );
	}

	protected CFBamXMsgRspnISOCountryLanguageCreatedHandler getRspnISOCountryLanguageCreatedHandler() {
		if( rspnISOCountryLanguageCreatedHandler == null ) {
			rspnISOCountryLanguageCreatedHandler = new CFBamXMsgRspnISOCountryLanguageCreatedHandler( this );
		}
		return( rspnISOCountryLanguageCreatedHandler );
	}

	protected CFBamXMsgRspnISOCountryLanguageReadSingleHandler getRspnISOCountryLanguageReadSingleHandler() {
		if( rspnISOCountryLanguageReadSingleHandler == null ) {
			rspnISOCountryLanguageReadSingleHandler = new CFBamXMsgRspnISOCountryLanguageReadSingleHandler( this );
			rspnISOCountryLanguageReadSingleHandler.addElementHandler( "ISOCountryLanguage", getRspnISOCountryLanguageRecHandler() );
		}
		return( rspnISOCountryLanguageReadSingleHandler );
	}

	protected CFBamXMsgRspnISOCountryLanguageReadListHandler getRspnISOCountryLanguageReadListHandler() {
		if( rspnISOCountryLanguageReadListHandler == null ) {
			rspnISOCountryLanguageReadListHandler = new CFBamXMsgRspnISOCountryLanguageReadListHandler( this );
			rspnISOCountryLanguageReadListHandler.addElementHandler( "ISOCountryLanguage", getRspnISOCountryLanguageRecHandler() );
		}
		return( rspnISOCountryLanguageReadListHandler );
	}

	protected CFBamXMsgRspnISOCountryLanguageLockedHandler getRspnISOCountryLanguageLockedHandler() {
		if( rspnISOCountryLanguageLockedHandler == null ) {
			rspnISOCountryLanguageLockedHandler = new CFBamXMsgRspnISOCountryLanguageLockedHandler( this );
		}
		return( rspnISOCountryLanguageLockedHandler );
	}

	protected CFBamXMsgRspnISOCountryLanguageUpdatedHandler getRspnISOCountryLanguageUpdatedHandler() {
		if( rspnISOCountryLanguageUpdatedHandler == null ) {
			rspnISOCountryLanguageUpdatedHandler = new CFBamXMsgRspnISOCountryLanguageUpdatedHandler( this );
		}
		return( rspnISOCountryLanguageUpdatedHandler );
	}

	protected CFBamXMsgRspnISOCountryLanguageDeletedHandler getRspnISOCountryLanguageDeletedHandler() {
		if( rspnISOCountryLanguageDeletedHandler == null ) {
			rspnISOCountryLanguageDeletedHandler = new CFBamXMsgRspnISOCountryLanguageDeletedHandler( this );
		}
		return( rspnISOCountryLanguageDeletedHandler );
	}

	// ISOCurrency Response Handlers

	protected CFBamXMsgRspnISOCurrencyRecHandler getRspnISOCurrencyRecHandler() {
		if( rspnISOCurrencyRecHandler == null ) {
			rspnISOCurrencyRecHandler = new CFBamXMsgRspnISOCurrencyRecHandler( this );
		}
		return( rspnISOCurrencyRecHandler );
	}

	protected CFBamXMsgRspnISOCurrencyCreatedHandler getRspnISOCurrencyCreatedHandler() {
		if( rspnISOCurrencyCreatedHandler == null ) {
			rspnISOCurrencyCreatedHandler = new CFBamXMsgRspnISOCurrencyCreatedHandler( this );
		}
		return( rspnISOCurrencyCreatedHandler );
	}

	protected CFBamXMsgRspnISOCurrencyReadSingleHandler getRspnISOCurrencyReadSingleHandler() {
		if( rspnISOCurrencyReadSingleHandler == null ) {
			rspnISOCurrencyReadSingleHandler = new CFBamXMsgRspnISOCurrencyReadSingleHandler( this );
			rspnISOCurrencyReadSingleHandler.addElementHandler( "ISOCurrency", getRspnISOCurrencyRecHandler() );
		}
		return( rspnISOCurrencyReadSingleHandler );
	}

	protected CFBamXMsgRspnISOCurrencyReadListHandler getRspnISOCurrencyReadListHandler() {
		if( rspnISOCurrencyReadListHandler == null ) {
			rspnISOCurrencyReadListHandler = new CFBamXMsgRspnISOCurrencyReadListHandler( this );
			rspnISOCurrencyReadListHandler.addElementHandler( "ISOCurrency", getRspnISOCurrencyRecHandler() );
		}
		return( rspnISOCurrencyReadListHandler );
	}

	protected CFBamXMsgRspnISOCurrencyLockedHandler getRspnISOCurrencyLockedHandler() {
		if( rspnISOCurrencyLockedHandler == null ) {
			rspnISOCurrencyLockedHandler = new CFBamXMsgRspnISOCurrencyLockedHandler( this );
		}
		return( rspnISOCurrencyLockedHandler );
	}

	protected CFBamXMsgRspnISOCurrencyUpdatedHandler getRspnISOCurrencyUpdatedHandler() {
		if( rspnISOCurrencyUpdatedHandler == null ) {
			rspnISOCurrencyUpdatedHandler = new CFBamXMsgRspnISOCurrencyUpdatedHandler( this );
		}
		return( rspnISOCurrencyUpdatedHandler );
	}

	protected CFBamXMsgRspnISOCurrencyDeletedHandler getRspnISOCurrencyDeletedHandler() {
		if( rspnISOCurrencyDeletedHandler == null ) {
			rspnISOCurrencyDeletedHandler = new CFBamXMsgRspnISOCurrencyDeletedHandler( this );
		}
		return( rspnISOCurrencyDeletedHandler );
	}

	// ISOLanguage Response Handlers

	protected CFBamXMsgRspnISOLanguageRecHandler getRspnISOLanguageRecHandler() {
		if( rspnISOLanguageRecHandler == null ) {
			rspnISOLanguageRecHandler = new CFBamXMsgRspnISOLanguageRecHandler( this );
		}
		return( rspnISOLanguageRecHandler );
	}

	protected CFBamXMsgRspnISOLanguageCreatedHandler getRspnISOLanguageCreatedHandler() {
		if( rspnISOLanguageCreatedHandler == null ) {
			rspnISOLanguageCreatedHandler = new CFBamXMsgRspnISOLanguageCreatedHandler( this );
		}
		return( rspnISOLanguageCreatedHandler );
	}

	protected CFBamXMsgRspnISOLanguageReadSingleHandler getRspnISOLanguageReadSingleHandler() {
		if( rspnISOLanguageReadSingleHandler == null ) {
			rspnISOLanguageReadSingleHandler = new CFBamXMsgRspnISOLanguageReadSingleHandler( this );
			rspnISOLanguageReadSingleHandler.addElementHandler( "ISOLanguage", getRspnISOLanguageRecHandler() );
		}
		return( rspnISOLanguageReadSingleHandler );
	}

	protected CFBamXMsgRspnISOLanguageReadListHandler getRspnISOLanguageReadListHandler() {
		if( rspnISOLanguageReadListHandler == null ) {
			rspnISOLanguageReadListHandler = new CFBamXMsgRspnISOLanguageReadListHandler( this );
			rspnISOLanguageReadListHandler.addElementHandler( "ISOLanguage", getRspnISOLanguageRecHandler() );
		}
		return( rspnISOLanguageReadListHandler );
	}

	protected CFBamXMsgRspnISOLanguageLockedHandler getRspnISOLanguageLockedHandler() {
		if( rspnISOLanguageLockedHandler == null ) {
			rspnISOLanguageLockedHandler = new CFBamXMsgRspnISOLanguageLockedHandler( this );
		}
		return( rspnISOLanguageLockedHandler );
	}

	protected CFBamXMsgRspnISOLanguageUpdatedHandler getRspnISOLanguageUpdatedHandler() {
		if( rspnISOLanguageUpdatedHandler == null ) {
			rspnISOLanguageUpdatedHandler = new CFBamXMsgRspnISOLanguageUpdatedHandler( this );
		}
		return( rspnISOLanguageUpdatedHandler );
	}

	protected CFBamXMsgRspnISOLanguageDeletedHandler getRspnISOLanguageDeletedHandler() {
		if( rspnISOLanguageDeletedHandler == null ) {
			rspnISOLanguageDeletedHandler = new CFBamXMsgRspnISOLanguageDeletedHandler( this );
		}
		return( rspnISOLanguageDeletedHandler );
	}

	// ISOTimezone Response Handlers

	protected CFBamXMsgRspnISOTimezoneRecHandler getRspnISOTimezoneRecHandler() {
		if( rspnISOTimezoneRecHandler == null ) {
			rspnISOTimezoneRecHandler = new CFBamXMsgRspnISOTimezoneRecHandler( this );
		}
		return( rspnISOTimezoneRecHandler );
	}

	protected CFBamXMsgRspnISOTimezoneCreatedHandler getRspnISOTimezoneCreatedHandler() {
		if( rspnISOTimezoneCreatedHandler == null ) {
			rspnISOTimezoneCreatedHandler = new CFBamXMsgRspnISOTimezoneCreatedHandler( this );
		}
		return( rspnISOTimezoneCreatedHandler );
	}

	protected CFBamXMsgRspnISOTimezoneReadSingleHandler getRspnISOTimezoneReadSingleHandler() {
		if( rspnISOTimezoneReadSingleHandler == null ) {
			rspnISOTimezoneReadSingleHandler = new CFBamXMsgRspnISOTimezoneReadSingleHandler( this );
			rspnISOTimezoneReadSingleHandler.addElementHandler( "ISOTimezone", getRspnISOTimezoneRecHandler() );
		}
		return( rspnISOTimezoneReadSingleHandler );
	}

	protected CFBamXMsgRspnISOTimezoneReadListHandler getRspnISOTimezoneReadListHandler() {
		if( rspnISOTimezoneReadListHandler == null ) {
			rspnISOTimezoneReadListHandler = new CFBamXMsgRspnISOTimezoneReadListHandler( this );
			rspnISOTimezoneReadListHandler.addElementHandler( "ISOTimezone", getRspnISOTimezoneRecHandler() );
		}
		return( rspnISOTimezoneReadListHandler );
	}

	protected CFBamXMsgRspnISOTimezoneLockedHandler getRspnISOTimezoneLockedHandler() {
		if( rspnISOTimezoneLockedHandler == null ) {
			rspnISOTimezoneLockedHandler = new CFBamXMsgRspnISOTimezoneLockedHandler( this );
		}
		return( rspnISOTimezoneLockedHandler );
	}

	protected CFBamXMsgRspnISOTimezoneUpdatedHandler getRspnISOTimezoneUpdatedHandler() {
		if( rspnISOTimezoneUpdatedHandler == null ) {
			rspnISOTimezoneUpdatedHandler = new CFBamXMsgRspnISOTimezoneUpdatedHandler( this );
		}
		return( rspnISOTimezoneUpdatedHandler );
	}

	protected CFBamXMsgRspnISOTimezoneDeletedHandler getRspnISOTimezoneDeletedHandler() {
		if( rspnISOTimezoneDeletedHandler == null ) {
			rspnISOTimezoneDeletedHandler = new CFBamXMsgRspnISOTimezoneDeletedHandler( this );
		}
		return( rspnISOTimezoneDeletedHandler );
	}

	// Id16Gen Response Handlers

	protected CFBamXMsgRspnId16GenRecHandler getRspnId16GenRecHandler() {
		if( rspnId16GenRecHandler == null ) {
			rspnId16GenRecHandler = new CFBamXMsgRspnId16GenRecHandler( this );
		}
		return( rspnId16GenRecHandler );
	}

	protected CFBamXMsgRspnId16GenCreatedHandler getRspnId16GenCreatedHandler() {
		if( rspnId16GenCreatedHandler == null ) {
			rspnId16GenCreatedHandler = new CFBamXMsgRspnId16GenCreatedHandler( this );
		}
		return( rspnId16GenCreatedHandler );
	}

	protected CFBamXMsgRspnId16GenReadSingleHandler getRspnId16GenReadSingleHandler() {
		if( rspnId16GenReadSingleHandler == null ) {
			rspnId16GenReadSingleHandler = new CFBamXMsgRspnId16GenReadSingleHandler( this );
			rspnId16GenReadSingleHandler.addElementHandler( "Id16Gen", getRspnId16GenRecHandler() );
		}
		return( rspnId16GenReadSingleHandler );
	}

	protected CFBamXMsgRspnId16GenReadListHandler getRspnId16GenReadListHandler() {
		if( rspnId16GenReadListHandler == null ) {
			rspnId16GenReadListHandler = new CFBamXMsgRspnId16GenReadListHandler( this );
			rspnId16GenReadListHandler.addElementHandler( "Id16Gen", getRspnId16GenRecHandler() );
		}
		return( rspnId16GenReadListHandler );
	}

	protected CFBamXMsgRspnId16GenLockedHandler getRspnId16GenLockedHandler() {
		if( rspnId16GenLockedHandler == null ) {
			rspnId16GenLockedHandler = new CFBamXMsgRspnId16GenLockedHandler( this );
		}
		return( rspnId16GenLockedHandler );
	}

	protected CFBamXMsgRspnId16GenUpdatedHandler getRspnId16GenUpdatedHandler() {
		if( rspnId16GenUpdatedHandler == null ) {
			rspnId16GenUpdatedHandler = new CFBamXMsgRspnId16GenUpdatedHandler( this );
		}
		return( rspnId16GenUpdatedHandler );
	}

	protected CFBamXMsgRspnId16GenDeletedHandler getRspnId16GenDeletedHandler() {
		if( rspnId16GenDeletedHandler == null ) {
			rspnId16GenDeletedHandler = new CFBamXMsgRspnId16GenDeletedHandler( this );
		}
		return( rspnId16GenDeletedHandler );
	}

	// Id32Gen Response Handlers

	protected CFBamXMsgRspnId32GenRecHandler getRspnId32GenRecHandler() {
		if( rspnId32GenRecHandler == null ) {
			rspnId32GenRecHandler = new CFBamXMsgRspnId32GenRecHandler( this );
		}
		return( rspnId32GenRecHandler );
	}

	protected CFBamXMsgRspnId32GenCreatedHandler getRspnId32GenCreatedHandler() {
		if( rspnId32GenCreatedHandler == null ) {
			rspnId32GenCreatedHandler = new CFBamXMsgRspnId32GenCreatedHandler( this );
		}
		return( rspnId32GenCreatedHandler );
	}

	protected CFBamXMsgRspnId32GenReadSingleHandler getRspnId32GenReadSingleHandler() {
		if( rspnId32GenReadSingleHandler == null ) {
			rspnId32GenReadSingleHandler = new CFBamXMsgRspnId32GenReadSingleHandler( this );
			rspnId32GenReadSingleHandler.addElementHandler( "Id32Gen", getRspnId32GenRecHandler() );
		}
		return( rspnId32GenReadSingleHandler );
	}

	protected CFBamXMsgRspnId32GenReadListHandler getRspnId32GenReadListHandler() {
		if( rspnId32GenReadListHandler == null ) {
			rspnId32GenReadListHandler = new CFBamXMsgRspnId32GenReadListHandler( this );
			rspnId32GenReadListHandler.addElementHandler( "Id32Gen", getRspnId32GenRecHandler() );
		}
		return( rspnId32GenReadListHandler );
	}

	protected CFBamXMsgRspnId32GenLockedHandler getRspnId32GenLockedHandler() {
		if( rspnId32GenLockedHandler == null ) {
			rspnId32GenLockedHandler = new CFBamXMsgRspnId32GenLockedHandler( this );
		}
		return( rspnId32GenLockedHandler );
	}

	protected CFBamXMsgRspnId32GenUpdatedHandler getRspnId32GenUpdatedHandler() {
		if( rspnId32GenUpdatedHandler == null ) {
			rspnId32GenUpdatedHandler = new CFBamXMsgRspnId32GenUpdatedHandler( this );
		}
		return( rspnId32GenUpdatedHandler );
	}

	protected CFBamXMsgRspnId32GenDeletedHandler getRspnId32GenDeletedHandler() {
		if( rspnId32GenDeletedHandler == null ) {
			rspnId32GenDeletedHandler = new CFBamXMsgRspnId32GenDeletedHandler( this );
		}
		return( rspnId32GenDeletedHandler );
	}

	// Id64Gen Response Handlers

	protected CFBamXMsgRspnId64GenRecHandler getRspnId64GenRecHandler() {
		if( rspnId64GenRecHandler == null ) {
			rspnId64GenRecHandler = new CFBamXMsgRspnId64GenRecHandler( this );
		}
		return( rspnId64GenRecHandler );
	}

	protected CFBamXMsgRspnId64GenCreatedHandler getRspnId64GenCreatedHandler() {
		if( rspnId64GenCreatedHandler == null ) {
			rspnId64GenCreatedHandler = new CFBamXMsgRspnId64GenCreatedHandler( this );
		}
		return( rspnId64GenCreatedHandler );
	}

	protected CFBamXMsgRspnId64GenReadSingleHandler getRspnId64GenReadSingleHandler() {
		if( rspnId64GenReadSingleHandler == null ) {
			rspnId64GenReadSingleHandler = new CFBamXMsgRspnId64GenReadSingleHandler( this );
			rspnId64GenReadSingleHandler.addElementHandler( "Id64Gen", getRspnId64GenRecHandler() );
		}
		return( rspnId64GenReadSingleHandler );
	}

	protected CFBamXMsgRspnId64GenReadListHandler getRspnId64GenReadListHandler() {
		if( rspnId64GenReadListHandler == null ) {
			rspnId64GenReadListHandler = new CFBamXMsgRspnId64GenReadListHandler( this );
			rspnId64GenReadListHandler.addElementHandler( "Id64Gen", getRspnId64GenRecHandler() );
		}
		return( rspnId64GenReadListHandler );
	}

	protected CFBamXMsgRspnId64GenLockedHandler getRspnId64GenLockedHandler() {
		if( rspnId64GenLockedHandler == null ) {
			rspnId64GenLockedHandler = new CFBamXMsgRspnId64GenLockedHandler( this );
		}
		return( rspnId64GenLockedHandler );
	}

	protected CFBamXMsgRspnId64GenUpdatedHandler getRspnId64GenUpdatedHandler() {
		if( rspnId64GenUpdatedHandler == null ) {
			rspnId64GenUpdatedHandler = new CFBamXMsgRspnId64GenUpdatedHandler( this );
		}
		return( rspnId64GenUpdatedHandler );
	}

	protected CFBamXMsgRspnId64GenDeletedHandler getRspnId64GenDeletedHandler() {
		if( rspnId64GenDeletedHandler == null ) {
			rspnId64GenDeletedHandler = new CFBamXMsgRspnId64GenDeletedHandler( this );
		}
		return( rspnId64GenDeletedHandler );
	}

	// Index Response Handlers

	protected CFBamXMsgRspnIndexRecHandler getRspnIndexRecHandler() {
		if( rspnIndexRecHandler == null ) {
			rspnIndexRecHandler = new CFBamXMsgRspnIndexRecHandler( this );
		}
		return( rspnIndexRecHandler );
	}

	protected CFBamXMsgRspnIndexCreatedHandler getRspnIndexCreatedHandler() {
		if( rspnIndexCreatedHandler == null ) {
			rspnIndexCreatedHandler = new CFBamXMsgRspnIndexCreatedHandler( this );
		}
		return( rspnIndexCreatedHandler );
	}

	protected CFBamXMsgRspnIndexReadSingleHandler getRspnIndexReadSingleHandler() {
		if( rspnIndexReadSingleHandler == null ) {
			rspnIndexReadSingleHandler = new CFBamXMsgRspnIndexReadSingleHandler( this );
			rspnIndexReadSingleHandler.addElementHandler( "Index", getRspnIndexRecHandler() );
		}
		return( rspnIndexReadSingleHandler );
	}

	protected CFBamXMsgRspnIndexReadListHandler getRspnIndexReadListHandler() {
		if( rspnIndexReadListHandler == null ) {
			rspnIndexReadListHandler = new CFBamXMsgRspnIndexReadListHandler( this );
			rspnIndexReadListHandler.addElementHandler( "Index", getRspnIndexRecHandler() );
		}
		return( rspnIndexReadListHandler );
	}

	protected CFBamXMsgRspnIndexLockedHandler getRspnIndexLockedHandler() {
		if( rspnIndexLockedHandler == null ) {
			rspnIndexLockedHandler = new CFBamXMsgRspnIndexLockedHandler( this );
		}
		return( rspnIndexLockedHandler );
	}

	protected CFBamXMsgRspnIndexUpdatedHandler getRspnIndexUpdatedHandler() {
		if( rspnIndexUpdatedHandler == null ) {
			rspnIndexUpdatedHandler = new CFBamXMsgRspnIndexUpdatedHandler( this );
		}
		return( rspnIndexUpdatedHandler );
	}

	protected CFBamXMsgRspnIndexDeletedHandler getRspnIndexDeletedHandler() {
		if( rspnIndexDeletedHandler == null ) {
			rspnIndexDeletedHandler = new CFBamXMsgRspnIndexDeletedHandler( this );
		}
		return( rspnIndexDeletedHandler );
	}

	// IndexCol Response Handlers

	protected CFBamXMsgRspnIndexColRecHandler getRspnIndexColRecHandler() {
		if( rspnIndexColRecHandler == null ) {
			rspnIndexColRecHandler = new CFBamXMsgRspnIndexColRecHandler( this );
		}
		return( rspnIndexColRecHandler );
	}

	protected CFBamXMsgRspnIndexColCreatedHandler getRspnIndexColCreatedHandler() {
		if( rspnIndexColCreatedHandler == null ) {
			rspnIndexColCreatedHandler = new CFBamXMsgRspnIndexColCreatedHandler( this );
		}
		return( rspnIndexColCreatedHandler );
	}

	protected CFBamXMsgRspnIndexColReadSingleHandler getRspnIndexColReadSingleHandler() {
		if( rspnIndexColReadSingleHandler == null ) {
			rspnIndexColReadSingleHandler = new CFBamXMsgRspnIndexColReadSingleHandler( this );
			rspnIndexColReadSingleHandler.addElementHandler( "IndexCol", getRspnIndexColRecHandler() );
		}
		return( rspnIndexColReadSingleHandler );
	}

	protected CFBamXMsgRspnIndexColReadListHandler getRspnIndexColReadListHandler() {
		if( rspnIndexColReadListHandler == null ) {
			rspnIndexColReadListHandler = new CFBamXMsgRspnIndexColReadListHandler( this );
			rspnIndexColReadListHandler.addElementHandler( "IndexCol", getRspnIndexColRecHandler() );
		}
		return( rspnIndexColReadListHandler );
	}

	protected CFBamXMsgRspnIndexColLockedHandler getRspnIndexColLockedHandler() {
		if( rspnIndexColLockedHandler == null ) {
			rspnIndexColLockedHandler = new CFBamXMsgRspnIndexColLockedHandler( this );
		}
		return( rspnIndexColLockedHandler );
	}

	protected CFBamXMsgRspnIndexColUpdatedHandler getRspnIndexColUpdatedHandler() {
		if( rspnIndexColUpdatedHandler == null ) {
			rspnIndexColUpdatedHandler = new CFBamXMsgRspnIndexColUpdatedHandler( this );
		}
		return( rspnIndexColUpdatedHandler );
	}

	protected CFBamXMsgRspnIndexColDeletedHandler getRspnIndexColDeletedHandler() {
		if( rspnIndexColDeletedHandler == null ) {
			rspnIndexColDeletedHandler = new CFBamXMsgRspnIndexColDeletedHandler( this );
		}
		return( rspnIndexColDeletedHandler );
	}

	// Int16Col Response Handlers

	protected CFBamXMsgRspnInt16ColRecHandler getRspnInt16ColRecHandler() {
		if( rspnInt16ColRecHandler == null ) {
			rspnInt16ColRecHandler = new CFBamXMsgRspnInt16ColRecHandler( this );
		}
		return( rspnInt16ColRecHandler );
	}

	protected CFBamXMsgRspnInt16ColCreatedHandler getRspnInt16ColCreatedHandler() {
		if( rspnInt16ColCreatedHandler == null ) {
			rspnInt16ColCreatedHandler = new CFBamXMsgRspnInt16ColCreatedHandler( this );
		}
		return( rspnInt16ColCreatedHandler );
	}

	protected CFBamXMsgRspnInt16ColReadSingleHandler getRspnInt16ColReadSingleHandler() {
		if( rspnInt16ColReadSingleHandler == null ) {
			rspnInt16ColReadSingleHandler = new CFBamXMsgRspnInt16ColReadSingleHandler( this );
			rspnInt16ColReadSingleHandler.addElementHandler( "Int16Col", getRspnInt16ColRecHandler() );
		}
		return( rspnInt16ColReadSingleHandler );
	}

	protected CFBamXMsgRspnInt16ColReadListHandler getRspnInt16ColReadListHandler() {
		if( rspnInt16ColReadListHandler == null ) {
			rspnInt16ColReadListHandler = new CFBamXMsgRspnInt16ColReadListHandler( this );
			rspnInt16ColReadListHandler.addElementHandler( "Int16Col", getRspnInt16ColRecHandler() );
		}
		return( rspnInt16ColReadListHandler );
	}

	protected CFBamXMsgRspnInt16ColLockedHandler getRspnInt16ColLockedHandler() {
		if( rspnInt16ColLockedHandler == null ) {
			rspnInt16ColLockedHandler = new CFBamXMsgRspnInt16ColLockedHandler( this );
		}
		return( rspnInt16ColLockedHandler );
	}

	protected CFBamXMsgRspnInt16ColUpdatedHandler getRspnInt16ColUpdatedHandler() {
		if( rspnInt16ColUpdatedHandler == null ) {
			rspnInt16ColUpdatedHandler = new CFBamXMsgRspnInt16ColUpdatedHandler( this );
		}
		return( rspnInt16ColUpdatedHandler );
	}

	protected CFBamXMsgRspnInt16ColDeletedHandler getRspnInt16ColDeletedHandler() {
		if( rspnInt16ColDeletedHandler == null ) {
			rspnInt16ColDeletedHandler = new CFBamXMsgRspnInt16ColDeletedHandler( this );
		}
		return( rspnInt16ColDeletedHandler );
	}

	// Int16Def Response Handlers

	protected CFBamXMsgRspnInt16DefRecHandler getRspnInt16DefRecHandler() {
		if( rspnInt16DefRecHandler == null ) {
			rspnInt16DefRecHandler = new CFBamXMsgRspnInt16DefRecHandler( this );
		}
		return( rspnInt16DefRecHandler );
	}

	protected CFBamXMsgRspnInt16DefCreatedHandler getRspnInt16DefCreatedHandler() {
		if( rspnInt16DefCreatedHandler == null ) {
			rspnInt16DefCreatedHandler = new CFBamXMsgRspnInt16DefCreatedHandler( this );
		}
		return( rspnInt16DefCreatedHandler );
	}

	protected CFBamXMsgRspnInt16DefReadSingleHandler getRspnInt16DefReadSingleHandler() {
		if( rspnInt16DefReadSingleHandler == null ) {
			rspnInt16DefReadSingleHandler = new CFBamXMsgRspnInt16DefReadSingleHandler( this );
			rspnInt16DefReadSingleHandler.addElementHandler( "Int16Def", getRspnInt16DefRecHandler() );
			rspnInt16DefReadSingleHandler.addElementHandler( "Int16Col", getRspnInt16ColRecHandler() );
			rspnInt16DefReadSingleHandler.addElementHandler( "Int16Type", getRspnInt16TypeRecHandler() );
			rspnInt16DefReadSingleHandler.addElementHandler( "Id16Gen", getRspnId16GenRecHandler() );
			rspnInt16DefReadSingleHandler.addElementHandler( "EnumDef", getRspnEnumDefRecHandler() );
			rspnInt16DefReadSingleHandler.addElementHandler( "EnumCol", getRspnEnumColRecHandler() );
			rspnInt16DefReadSingleHandler.addElementHandler( "EnumType", getRspnEnumTypeRecHandler() );
		}
		return( rspnInt16DefReadSingleHandler );
	}

	protected CFBamXMsgRspnInt16DefReadListHandler getRspnInt16DefReadListHandler() {
		if( rspnInt16DefReadListHandler == null ) {
			rspnInt16DefReadListHandler = new CFBamXMsgRspnInt16DefReadListHandler( this );
			rspnInt16DefReadListHandler.addElementHandler( "Int16Def", getRspnInt16DefRecHandler() );
			rspnInt16DefReadListHandler.addElementHandler( "Int16Col", getRspnInt16ColRecHandler() );
			rspnInt16DefReadListHandler.addElementHandler( "Int16Type", getRspnInt16TypeRecHandler() );
			rspnInt16DefReadListHandler.addElementHandler( "Id16Gen", getRspnId16GenRecHandler() );
			rspnInt16DefReadListHandler.addElementHandler( "EnumDef", getRspnEnumDefRecHandler() );
			rspnInt16DefReadListHandler.addElementHandler( "EnumCol", getRspnEnumColRecHandler() );
			rspnInt16DefReadListHandler.addElementHandler( "EnumType", getRspnEnumTypeRecHandler() );
		}
		return( rspnInt16DefReadListHandler );
	}

	protected CFBamXMsgRspnInt16DefLockedHandler getRspnInt16DefLockedHandler() {
		if( rspnInt16DefLockedHandler == null ) {
			rspnInt16DefLockedHandler = new CFBamXMsgRspnInt16DefLockedHandler( this );
		}
		return( rspnInt16DefLockedHandler );
	}

	protected CFBamXMsgRspnInt16DefUpdatedHandler getRspnInt16DefUpdatedHandler() {
		if( rspnInt16DefUpdatedHandler == null ) {
			rspnInt16DefUpdatedHandler = new CFBamXMsgRspnInt16DefUpdatedHandler( this );
		}
		return( rspnInt16DefUpdatedHandler );
	}

	protected CFBamXMsgRspnInt16DefDeletedHandler getRspnInt16DefDeletedHandler() {
		if( rspnInt16DefDeletedHandler == null ) {
			rspnInt16DefDeletedHandler = new CFBamXMsgRspnInt16DefDeletedHandler( this );
		}
		return( rspnInt16DefDeletedHandler );
	}

	// Int16Type Response Handlers

	protected CFBamXMsgRspnInt16TypeRecHandler getRspnInt16TypeRecHandler() {
		if( rspnInt16TypeRecHandler == null ) {
			rspnInt16TypeRecHandler = new CFBamXMsgRspnInt16TypeRecHandler( this );
		}
		return( rspnInt16TypeRecHandler );
	}

	protected CFBamXMsgRspnInt16TypeCreatedHandler getRspnInt16TypeCreatedHandler() {
		if( rspnInt16TypeCreatedHandler == null ) {
			rspnInt16TypeCreatedHandler = new CFBamXMsgRspnInt16TypeCreatedHandler( this );
		}
		return( rspnInt16TypeCreatedHandler );
	}

	protected CFBamXMsgRspnInt16TypeReadSingleHandler getRspnInt16TypeReadSingleHandler() {
		if( rspnInt16TypeReadSingleHandler == null ) {
			rspnInt16TypeReadSingleHandler = new CFBamXMsgRspnInt16TypeReadSingleHandler( this );
			rspnInt16TypeReadSingleHandler.addElementHandler( "Int16Type", getRspnInt16TypeRecHandler() );
			rspnInt16TypeReadSingleHandler.addElementHandler( "Id16Gen", getRspnId16GenRecHandler() );
		}
		return( rspnInt16TypeReadSingleHandler );
	}

	protected CFBamXMsgRspnInt16TypeReadListHandler getRspnInt16TypeReadListHandler() {
		if( rspnInt16TypeReadListHandler == null ) {
			rspnInt16TypeReadListHandler = new CFBamXMsgRspnInt16TypeReadListHandler( this );
			rspnInt16TypeReadListHandler.addElementHandler( "Int16Type", getRspnInt16TypeRecHandler() );
			rspnInt16TypeReadListHandler.addElementHandler( "Id16Gen", getRspnId16GenRecHandler() );
		}
		return( rspnInt16TypeReadListHandler );
	}

	protected CFBamXMsgRspnInt16TypeLockedHandler getRspnInt16TypeLockedHandler() {
		if( rspnInt16TypeLockedHandler == null ) {
			rspnInt16TypeLockedHandler = new CFBamXMsgRspnInt16TypeLockedHandler( this );
		}
		return( rspnInt16TypeLockedHandler );
	}

	protected CFBamXMsgRspnInt16TypeUpdatedHandler getRspnInt16TypeUpdatedHandler() {
		if( rspnInt16TypeUpdatedHandler == null ) {
			rspnInt16TypeUpdatedHandler = new CFBamXMsgRspnInt16TypeUpdatedHandler( this );
		}
		return( rspnInt16TypeUpdatedHandler );
	}

	protected CFBamXMsgRspnInt16TypeDeletedHandler getRspnInt16TypeDeletedHandler() {
		if( rspnInt16TypeDeletedHandler == null ) {
			rspnInt16TypeDeletedHandler = new CFBamXMsgRspnInt16TypeDeletedHandler( this );
		}
		return( rspnInt16TypeDeletedHandler );
	}

	// Int32Col Response Handlers

	protected CFBamXMsgRspnInt32ColRecHandler getRspnInt32ColRecHandler() {
		if( rspnInt32ColRecHandler == null ) {
			rspnInt32ColRecHandler = new CFBamXMsgRspnInt32ColRecHandler( this );
		}
		return( rspnInt32ColRecHandler );
	}

	protected CFBamXMsgRspnInt32ColCreatedHandler getRspnInt32ColCreatedHandler() {
		if( rspnInt32ColCreatedHandler == null ) {
			rspnInt32ColCreatedHandler = new CFBamXMsgRspnInt32ColCreatedHandler( this );
		}
		return( rspnInt32ColCreatedHandler );
	}

	protected CFBamXMsgRspnInt32ColReadSingleHandler getRspnInt32ColReadSingleHandler() {
		if( rspnInt32ColReadSingleHandler == null ) {
			rspnInt32ColReadSingleHandler = new CFBamXMsgRspnInt32ColReadSingleHandler( this );
			rspnInt32ColReadSingleHandler.addElementHandler( "Int32Col", getRspnInt32ColRecHandler() );
		}
		return( rspnInt32ColReadSingleHandler );
	}

	protected CFBamXMsgRspnInt32ColReadListHandler getRspnInt32ColReadListHandler() {
		if( rspnInt32ColReadListHandler == null ) {
			rspnInt32ColReadListHandler = new CFBamXMsgRspnInt32ColReadListHandler( this );
			rspnInt32ColReadListHandler.addElementHandler( "Int32Col", getRspnInt32ColRecHandler() );
		}
		return( rspnInt32ColReadListHandler );
	}

	protected CFBamXMsgRspnInt32ColLockedHandler getRspnInt32ColLockedHandler() {
		if( rspnInt32ColLockedHandler == null ) {
			rspnInt32ColLockedHandler = new CFBamXMsgRspnInt32ColLockedHandler( this );
		}
		return( rspnInt32ColLockedHandler );
	}

	protected CFBamXMsgRspnInt32ColUpdatedHandler getRspnInt32ColUpdatedHandler() {
		if( rspnInt32ColUpdatedHandler == null ) {
			rspnInt32ColUpdatedHandler = new CFBamXMsgRspnInt32ColUpdatedHandler( this );
		}
		return( rspnInt32ColUpdatedHandler );
	}

	protected CFBamXMsgRspnInt32ColDeletedHandler getRspnInt32ColDeletedHandler() {
		if( rspnInt32ColDeletedHandler == null ) {
			rspnInt32ColDeletedHandler = new CFBamXMsgRspnInt32ColDeletedHandler( this );
		}
		return( rspnInt32ColDeletedHandler );
	}

	// Int32Def Response Handlers

	protected CFBamXMsgRspnInt32DefRecHandler getRspnInt32DefRecHandler() {
		if( rspnInt32DefRecHandler == null ) {
			rspnInt32DefRecHandler = new CFBamXMsgRspnInt32DefRecHandler( this );
		}
		return( rspnInt32DefRecHandler );
	}

	protected CFBamXMsgRspnInt32DefCreatedHandler getRspnInt32DefCreatedHandler() {
		if( rspnInt32DefCreatedHandler == null ) {
			rspnInt32DefCreatedHandler = new CFBamXMsgRspnInt32DefCreatedHandler( this );
		}
		return( rspnInt32DefCreatedHandler );
	}

	protected CFBamXMsgRspnInt32DefReadSingleHandler getRspnInt32DefReadSingleHandler() {
		if( rspnInt32DefReadSingleHandler == null ) {
			rspnInt32DefReadSingleHandler = new CFBamXMsgRspnInt32DefReadSingleHandler( this );
			rspnInt32DefReadSingleHandler.addElementHandler( "Int32Def", getRspnInt32DefRecHandler() );
			rspnInt32DefReadSingleHandler.addElementHandler( "Int32Col", getRspnInt32ColRecHandler() );
			rspnInt32DefReadSingleHandler.addElementHandler( "Int32Type", getRspnInt32TypeRecHandler() );
			rspnInt32DefReadSingleHandler.addElementHandler( "Id32Gen", getRspnId32GenRecHandler() );
		}
		return( rspnInt32DefReadSingleHandler );
	}

	protected CFBamXMsgRspnInt32DefReadListHandler getRspnInt32DefReadListHandler() {
		if( rspnInt32DefReadListHandler == null ) {
			rspnInt32DefReadListHandler = new CFBamXMsgRspnInt32DefReadListHandler( this );
			rspnInt32DefReadListHandler.addElementHandler( "Int32Def", getRspnInt32DefRecHandler() );
			rspnInt32DefReadListHandler.addElementHandler( "Int32Col", getRspnInt32ColRecHandler() );
			rspnInt32DefReadListHandler.addElementHandler( "Int32Type", getRspnInt32TypeRecHandler() );
			rspnInt32DefReadListHandler.addElementHandler( "Id32Gen", getRspnId32GenRecHandler() );
		}
		return( rspnInt32DefReadListHandler );
	}

	protected CFBamXMsgRspnInt32DefLockedHandler getRspnInt32DefLockedHandler() {
		if( rspnInt32DefLockedHandler == null ) {
			rspnInt32DefLockedHandler = new CFBamXMsgRspnInt32DefLockedHandler( this );
		}
		return( rspnInt32DefLockedHandler );
	}

	protected CFBamXMsgRspnInt32DefUpdatedHandler getRspnInt32DefUpdatedHandler() {
		if( rspnInt32DefUpdatedHandler == null ) {
			rspnInt32DefUpdatedHandler = new CFBamXMsgRspnInt32DefUpdatedHandler( this );
		}
		return( rspnInt32DefUpdatedHandler );
	}

	protected CFBamXMsgRspnInt32DefDeletedHandler getRspnInt32DefDeletedHandler() {
		if( rspnInt32DefDeletedHandler == null ) {
			rspnInt32DefDeletedHandler = new CFBamXMsgRspnInt32DefDeletedHandler( this );
		}
		return( rspnInt32DefDeletedHandler );
	}

	// Int32Type Response Handlers

	protected CFBamXMsgRspnInt32TypeRecHandler getRspnInt32TypeRecHandler() {
		if( rspnInt32TypeRecHandler == null ) {
			rspnInt32TypeRecHandler = new CFBamXMsgRspnInt32TypeRecHandler( this );
		}
		return( rspnInt32TypeRecHandler );
	}

	protected CFBamXMsgRspnInt32TypeCreatedHandler getRspnInt32TypeCreatedHandler() {
		if( rspnInt32TypeCreatedHandler == null ) {
			rspnInt32TypeCreatedHandler = new CFBamXMsgRspnInt32TypeCreatedHandler( this );
		}
		return( rspnInt32TypeCreatedHandler );
	}

	protected CFBamXMsgRspnInt32TypeReadSingleHandler getRspnInt32TypeReadSingleHandler() {
		if( rspnInt32TypeReadSingleHandler == null ) {
			rspnInt32TypeReadSingleHandler = new CFBamXMsgRspnInt32TypeReadSingleHandler( this );
			rspnInt32TypeReadSingleHandler.addElementHandler( "Int32Type", getRspnInt32TypeRecHandler() );
			rspnInt32TypeReadSingleHandler.addElementHandler( "Id32Gen", getRspnId32GenRecHandler() );
		}
		return( rspnInt32TypeReadSingleHandler );
	}

	protected CFBamXMsgRspnInt32TypeReadListHandler getRspnInt32TypeReadListHandler() {
		if( rspnInt32TypeReadListHandler == null ) {
			rspnInt32TypeReadListHandler = new CFBamXMsgRspnInt32TypeReadListHandler( this );
			rspnInt32TypeReadListHandler.addElementHandler( "Int32Type", getRspnInt32TypeRecHandler() );
			rspnInt32TypeReadListHandler.addElementHandler( "Id32Gen", getRspnId32GenRecHandler() );
		}
		return( rspnInt32TypeReadListHandler );
	}

	protected CFBamXMsgRspnInt32TypeLockedHandler getRspnInt32TypeLockedHandler() {
		if( rspnInt32TypeLockedHandler == null ) {
			rspnInt32TypeLockedHandler = new CFBamXMsgRspnInt32TypeLockedHandler( this );
		}
		return( rspnInt32TypeLockedHandler );
	}

	protected CFBamXMsgRspnInt32TypeUpdatedHandler getRspnInt32TypeUpdatedHandler() {
		if( rspnInt32TypeUpdatedHandler == null ) {
			rspnInt32TypeUpdatedHandler = new CFBamXMsgRspnInt32TypeUpdatedHandler( this );
		}
		return( rspnInt32TypeUpdatedHandler );
	}

	protected CFBamXMsgRspnInt32TypeDeletedHandler getRspnInt32TypeDeletedHandler() {
		if( rspnInt32TypeDeletedHandler == null ) {
			rspnInt32TypeDeletedHandler = new CFBamXMsgRspnInt32TypeDeletedHandler( this );
		}
		return( rspnInt32TypeDeletedHandler );
	}

	// Int64Col Response Handlers

	protected CFBamXMsgRspnInt64ColRecHandler getRspnInt64ColRecHandler() {
		if( rspnInt64ColRecHandler == null ) {
			rspnInt64ColRecHandler = new CFBamXMsgRspnInt64ColRecHandler( this );
		}
		return( rspnInt64ColRecHandler );
	}

	protected CFBamXMsgRspnInt64ColCreatedHandler getRspnInt64ColCreatedHandler() {
		if( rspnInt64ColCreatedHandler == null ) {
			rspnInt64ColCreatedHandler = new CFBamXMsgRspnInt64ColCreatedHandler( this );
		}
		return( rspnInt64ColCreatedHandler );
	}

	protected CFBamXMsgRspnInt64ColReadSingleHandler getRspnInt64ColReadSingleHandler() {
		if( rspnInt64ColReadSingleHandler == null ) {
			rspnInt64ColReadSingleHandler = new CFBamXMsgRspnInt64ColReadSingleHandler( this );
			rspnInt64ColReadSingleHandler.addElementHandler( "Int64Col", getRspnInt64ColRecHandler() );
		}
		return( rspnInt64ColReadSingleHandler );
	}

	protected CFBamXMsgRspnInt64ColReadListHandler getRspnInt64ColReadListHandler() {
		if( rspnInt64ColReadListHandler == null ) {
			rspnInt64ColReadListHandler = new CFBamXMsgRspnInt64ColReadListHandler( this );
			rspnInt64ColReadListHandler.addElementHandler( "Int64Col", getRspnInt64ColRecHandler() );
		}
		return( rspnInt64ColReadListHandler );
	}

	protected CFBamXMsgRspnInt64ColLockedHandler getRspnInt64ColLockedHandler() {
		if( rspnInt64ColLockedHandler == null ) {
			rspnInt64ColLockedHandler = new CFBamXMsgRspnInt64ColLockedHandler( this );
		}
		return( rspnInt64ColLockedHandler );
	}

	protected CFBamXMsgRspnInt64ColUpdatedHandler getRspnInt64ColUpdatedHandler() {
		if( rspnInt64ColUpdatedHandler == null ) {
			rspnInt64ColUpdatedHandler = new CFBamXMsgRspnInt64ColUpdatedHandler( this );
		}
		return( rspnInt64ColUpdatedHandler );
	}

	protected CFBamXMsgRspnInt64ColDeletedHandler getRspnInt64ColDeletedHandler() {
		if( rspnInt64ColDeletedHandler == null ) {
			rspnInt64ColDeletedHandler = new CFBamXMsgRspnInt64ColDeletedHandler( this );
		}
		return( rspnInt64ColDeletedHandler );
	}

	// Int64Def Response Handlers

	protected CFBamXMsgRspnInt64DefRecHandler getRspnInt64DefRecHandler() {
		if( rspnInt64DefRecHandler == null ) {
			rspnInt64DefRecHandler = new CFBamXMsgRspnInt64DefRecHandler( this );
		}
		return( rspnInt64DefRecHandler );
	}

	protected CFBamXMsgRspnInt64DefCreatedHandler getRspnInt64DefCreatedHandler() {
		if( rspnInt64DefCreatedHandler == null ) {
			rspnInt64DefCreatedHandler = new CFBamXMsgRspnInt64DefCreatedHandler( this );
		}
		return( rspnInt64DefCreatedHandler );
	}

	protected CFBamXMsgRspnInt64DefReadSingleHandler getRspnInt64DefReadSingleHandler() {
		if( rspnInt64DefReadSingleHandler == null ) {
			rspnInt64DefReadSingleHandler = new CFBamXMsgRspnInt64DefReadSingleHandler( this );
			rspnInt64DefReadSingleHandler.addElementHandler( "Int64Def", getRspnInt64DefRecHandler() );
			rspnInt64DefReadSingleHandler.addElementHandler( "Int64Col", getRspnInt64ColRecHandler() );
			rspnInt64DefReadSingleHandler.addElementHandler( "Int64Type", getRspnInt64TypeRecHandler() );
			rspnInt64DefReadSingleHandler.addElementHandler( "Id64Gen", getRspnId64GenRecHandler() );
		}
		return( rspnInt64DefReadSingleHandler );
	}

	protected CFBamXMsgRspnInt64DefReadListHandler getRspnInt64DefReadListHandler() {
		if( rspnInt64DefReadListHandler == null ) {
			rspnInt64DefReadListHandler = new CFBamXMsgRspnInt64DefReadListHandler( this );
			rspnInt64DefReadListHandler.addElementHandler( "Int64Def", getRspnInt64DefRecHandler() );
			rspnInt64DefReadListHandler.addElementHandler( "Int64Col", getRspnInt64ColRecHandler() );
			rspnInt64DefReadListHandler.addElementHandler( "Int64Type", getRspnInt64TypeRecHandler() );
			rspnInt64DefReadListHandler.addElementHandler( "Id64Gen", getRspnId64GenRecHandler() );
		}
		return( rspnInt64DefReadListHandler );
	}

	protected CFBamXMsgRspnInt64DefLockedHandler getRspnInt64DefLockedHandler() {
		if( rspnInt64DefLockedHandler == null ) {
			rspnInt64DefLockedHandler = new CFBamXMsgRspnInt64DefLockedHandler( this );
		}
		return( rspnInt64DefLockedHandler );
	}

	protected CFBamXMsgRspnInt64DefUpdatedHandler getRspnInt64DefUpdatedHandler() {
		if( rspnInt64DefUpdatedHandler == null ) {
			rspnInt64DefUpdatedHandler = new CFBamXMsgRspnInt64DefUpdatedHandler( this );
		}
		return( rspnInt64DefUpdatedHandler );
	}

	protected CFBamXMsgRspnInt64DefDeletedHandler getRspnInt64DefDeletedHandler() {
		if( rspnInt64DefDeletedHandler == null ) {
			rspnInt64DefDeletedHandler = new CFBamXMsgRspnInt64DefDeletedHandler( this );
		}
		return( rspnInt64DefDeletedHandler );
	}

	// Int64Type Response Handlers

	protected CFBamXMsgRspnInt64TypeRecHandler getRspnInt64TypeRecHandler() {
		if( rspnInt64TypeRecHandler == null ) {
			rspnInt64TypeRecHandler = new CFBamXMsgRspnInt64TypeRecHandler( this );
		}
		return( rspnInt64TypeRecHandler );
	}

	protected CFBamXMsgRspnInt64TypeCreatedHandler getRspnInt64TypeCreatedHandler() {
		if( rspnInt64TypeCreatedHandler == null ) {
			rspnInt64TypeCreatedHandler = new CFBamXMsgRspnInt64TypeCreatedHandler( this );
		}
		return( rspnInt64TypeCreatedHandler );
	}

	protected CFBamXMsgRspnInt64TypeReadSingleHandler getRspnInt64TypeReadSingleHandler() {
		if( rspnInt64TypeReadSingleHandler == null ) {
			rspnInt64TypeReadSingleHandler = new CFBamXMsgRspnInt64TypeReadSingleHandler( this );
			rspnInt64TypeReadSingleHandler.addElementHandler( "Int64Type", getRspnInt64TypeRecHandler() );
			rspnInt64TypeReadSingleHandler.addElementHandler( "Id64Gen", getRspnId64GenRecHandler() );
		}
		return( rspnInt64TypeReadSingleHandler );
	}

	protected CFBamXMsgRspnInt64TypeReadListHandler getRspnInt64TypeReadListHandler() {
		if( rspnInt64TypeReadListHandler == null ) {
			rspnInt64TypeReadListHandler = new CFBamXMsgRspnInt64TypeReadListHandler( this );
			rspnInt64TypeReadListHandler.addElementHandler( "Int64Type", getRspnInt64TypeRecHandler() );
			rspnInt64TypeReadListHandler.addElementHandler( "Id64Gen", getRspnId64GenRecHandler() );
		}
		return( rspnInt64TypeReadListHandler );
	}

	protected CFBamXMsgRspnInt64TypeLockedHandler getRspnInt64TypeLockedHandler() {
		if( rspnInt64TypeLockedHandler == null ) {
			rspnInt64TypeLockedHandler = new CFBamXMsgRspnInt64TypeLockedHandler( this );
		}
		return( rspnInt64TypeLockedHandler );
	}

	protected CFBamXMsgRspnInt64TypeUpdatedHandler getRspnInt64TypeUpdatedHandler() {
		if( rspnInt64TypeUpdatedHandler == null ) {
			rspnInt64TypeUpdatedHandler = new CFBamXMsgRspnInt64TypeUpdatedHandler( this );
		}
		return( rspnInt64TypeUpdatedHandler );
	}

	protected CFBamXMsgRspnInt64TypeDeletedHandler getRspnInt64TypeDeletedHandler() {
		if( rspnInt64TypeDeletedHandler == null ) {
			rspnInt64TypeDeletedHandler = new CFBamXMsgRspnInt64TypeDeletedHandler( this );
		}
		return( rspnInt64TypeDeletedHandler );
	}

	// License Response Handlers

	protected CFBamXMsgRspnLicenseRecHandler getRspnLicenseRecHandler() {
		if( rspnLicenseRecHandler == null ) {
			rspnLicenseRecHandler = new CFBamXMsgRspnLicenseRecHandler( this );
		}
		return( rspnLicenseRecHandler );
	}

	protected CFBamXMsgRspnLicenseCreatedHandler getRspnLicenseCreatedHandler() {
		if( rspnLicenseCreatedHandler == null ) {
			rspnLicenseCreatedHandler = new CFBamXMsgRspnLicenseCreatedHandler( this );
		}
		return( rspnLicenseCreatedHandler );
	}

	protected CFBamXMsgRspnLicenseReadSingleHandler getRspnLicenseReadSingleHandler() {
		if( rspnLicenseReadSingleHandler == null ) {
			rspnLicenseReadSingleHandler = new CFBamXMsgRspnLicenseReadSingleHandler( this );
			rspnLicenseReadSingleHandler.addElementHandler( "License", getRspnLicenseRecHandler() );
		}
		return( rspnLicenseReadSingleHandler );
	}

	protected CFBamXMsgRspnLicenseReadListHandler getRspnLicenseReadListHandler() {
		if( rspnLicenseReadListHandler == null ) {
			rspnLicenseReadListHandler = new CFBamXMsgRspnLicenseReadListHandler( this );
			rspnLicenseReadListHandler.addElementHandler( "License", getRspnLicenseRecHandler() );
		}
		return( rspnLicenseReadListHandler );
	}

	protected CFBamXMsgRspnLicenseLockedHandler getRspnLicenseLockedHandler() {
		if( rspnLicenseLockedHandler == null ) {
			rspnLicenseLockedHandler = new CFBamXMsgRspnLicenseLockedHandler( this );
		}
		return( rspnLicenseLockedHandler );
	}

	protected CFBamXMsgRspnLicenseUpdatedHandler getRspnLicenseUpdatedHandler() {
		if( rspnLicenseUpdatedHandler == null ) {
			rspnLicenseUpdatedHandler = new CFBamXMsgRspnLicenseUpdatedHandler( this );
		}
		return( rspnLicenseUpdatedHandler );
	}

	protected CFBamXMsgRspnLicenseDeletedHandler getRspnLicenseDeletedHandler() {
		if( rspnLicenseDeletedHandler == null ) {
			rspnLicenseDeletedHandler = new CFBamXMsgRspnLicenseDeletedHandler( this );
		}
		return( rspnLicenseDeletedHandler );
	}

	// LoaderBehaviour Response Handlers

	protected CFBamXMsgRspnLoaderBehaviourRecHandler getRspnLoaderBehaviourRecHandler() {
		if( rspnLoaderBehaviourRecHandler == null ) {
			rspnLoaderBehaviourRecHandler = new CFBamXMsgRspnLoaderBehaviourRecHandler( this );
		}
		return( rspnLoaderBehaviourRecHandler );
	}

	protected CFBamXMsgRspnLoaderBehaviourCreatedHandler getRspnLoaderBehaviourCreatedHandler() {
		if( rspnLoaderBehaviourCreatedHandler == null ) {
			rspnLoaderBehaviourCreatedHandler = new CFBamXMsgRspnLoaderBehaviourCreatedHandler( this );
		}
		return( rspnLoaderBehaviourCreatedHandler );
	}

	protected CFBamXMsgRspnLoaderBehaviourReadSingleHandler getRspnLoaderBehaviourReadSingleHandler() {
		if( rspnLoaderBehaviourReadSingleHandler == null ) {
			rspnLoaderBehaviourReadSingleHandler = new CFBamXMsgRspnLoaderBehaviourReadSingleHandler( this );
			rspnLoaderBehaviourReadSingleHandler.addElementHandler( "LoaderBehaviour", getRspnLoaderBehaviourRecHandler() );
		}
		return( rspnLoaderBehaviourReadSingleHandler );
	}

	protected CFBamXMsgRspnLoaderBehaviourReadListHandler getRspnLoaderBehaviourReadListHandler() {
		if( rspnLoaderBehaviourReadListHandler == null ) {
			rspnLoaderBehaviourReadListHandler = new CFBamXMsgRspnLoaderBehaviourReadListHandler( this );
			rspnLoaderBehaviourReadListHandler.addElementHandler( "LoaderBehaviour", getRspnLoaderBehaviourRecHandler() );
		}
		return( rspnLoaderBehaviourReadListHandler );
	}

	protected CFBamXMsgRspnLoaderBehaviourLockedHandler getRspnLoaderBehaviourLockedHandler() {
		if( rspnLoaderBehaviourLockedHandler == null ) {
			rspnLoaderBehaviourLockedHandler = new CFBamXMsgRspnLoaderBehaviourLockedHandler( this );
		}
		return( rspnLoaderBehaviourLockedHandler );
	}

	protected CFBamXMsgRspnLoaderBehaviourUpdatedHandler getRspnLoaderBehaviourUpdatedHandler() {
		if( rspnLoaderBehaviourUpdatedHandler == null ) {
			rspnLoaderBehaviourUpdatedHandler = new CFBamXMsgRspnLoaderBehaviourUpdatedHandler( this );
		}
		return( rspnLoaderBehaviourUpdatedHandler );
	}

	protected CFBamXMsgRspnLoaderBehaviourDeletedHandler getRspnLoaderBehaviourDeletedHandler() {
		if( rspnLoaderBehaviourDeletedHandler == null ) {
			rspnLoaderBehaviourDeletedHandler = new CFBamXMsgRspnLoaderBehaviourDeletedHandler( this );
		}
		return( rspnLoaderBehaviourDeletedHandler );
	}

	// MajorVersion Response Handlers

	protected CFBamXMsgRspnMajorVersionRecHandler getRspnMajorVersionRecHandler() {
		if( rspnMajorVersionRecHandler == null ) {
			rspnMajorVersionRecHandler = new CFBamXMsgRspnMajorVersionRecHandler( this );
		}
		return( rspnMajorVersionRecHandler );
	}

	protected CFBamXMsgRspnMajorVersionCreatedHandler getRspnMajorVersionCreatedHandler() {
		if( rspnMajorVersionCreatedHandler == null ) {
			rspnMajorVersionCreatedHandler = new CFBamXMsgRspnMajorVersionCreatedHandler( this );
		}
		return( rspnMajorVersionCreatedHandler );
	}

	protected CFBamXMsgRspnMajorVersionReadSingleHandler getRspnMajorVersionReadSingleHandler() {
		if( rspnMajorVersionReadSingleHandler == null ) {
			rspnMajorVersionReadSingleHandler = new CFBamXMsgRspnMajorVersionReadSingleHandler( this );
			rspnMajorVersionReadSingleHandler.addElementHandler( "MajorVersion", getRspnMajorVersionRecHandler() );
		}
		return( rspnMajorVersionReadSingleHandler );
	}

	protected CFBamXMsgRspnMajorVersionReadListHandler getRspnMajorVersionReadListHandler() {
		if( rspnMajorVersionReadListHandler == null ) {
			rspnMajorVersionReadListHandler = new CFBamXMsgRspnMajorVersionReadListHandler( this );
			rspnMajorVersionReadListHandler.addElementHandler( "MajorVersion", getRspnMajorVersionRecHandler() );
		}
		return( rspnMajorVersionReadListHandler );
	}

	protected CFBamXMsgRspnMajorVersionLockedHandler getRspnMajorVersionLockedHandler() {
		if( rspnMajorVersionLockedHandler == null ) {
			rspnMajorVersionLockedHandler = new CFBamXMsgRspnMajorVersionLockedHandler( this );
		}
		return( rspnMajorVersionLockedHandler );
	}

	protected CFBamXMsgRspnMajorVersionUpdatedHandler getRspnMajorVersionUpdatedHandler() {
		if( rspnMajorVersionUpdatedHandler == null ) {
			rspnMajorVersionUpdatedHandler = new CFBamXMsgRspnMajorVersionUpdatedHandler( this );
		}
		return( rspnMajorVersionUpdatedHandler );
	}

	protected CFBamXMsgRspnMajorVersionDeletedHandler getRspnMajorVersionDeletedHandler() {
		if( rspnMajorVersionDeletedHandler == null ) {
			rspnMajorVersionDeletedHandler = new CFBamXMsgRspnMajorVersionDeletedHandler( this );
		}
		return( rspnMajorVersionDeletedHandler );
	}

	// MimeType Response Handlers

	protected CFBamXMsgRspnMimeTypeRecHandler getRspnMimeTypeRecHandler() {
		if( rspnMimeTypeRecHandler == null ) {
			rspnMimeTypeRecHandler = new CFBamXMsgRspnMimeTypeRecHandler( this );
		}
		return( rspnMimeTypeRecHandler );
	}

	protected CFBamXMsgRspnMimeTypeCreatedHandler getRspnMimeTypeCreatedHandler() {
		if( rspnMimeTypeCreatedHandler == null ) {
			rspnMimeTypeCreatedHandler = new CFBamXMsgRspnMimeTypeCreatedHandler( this );
		}
		return( rspnMimeTypeCreatedHandler );
	}

	protected CFBamXMsgRspnMimeTypeReadSingleHandler getRspnMimeTypeReadSingleHandler() {
		if( rspnMimeTypeReadSingleHandler == null ) {
			rspnMimeTypeReadSingleHandler = new CFBamXMsgRspnMimeTypeReadSingleHandler( this );
			rspnMimeTypeReadSingleHandler.addElementHandler( "MimeType", getRspnMimeTypeRecHandler() );
		}
		return( rspnMimeTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnMimeTypeReadListHandler getRspnMimeTypeReadListHandler() {
		if( rspnMimeTypeReadListHandler == null ) {
			rspnMimeTypeReadListHandler = new CFBamXMsgRspnMimeTypeReadListHandler( this );
			rspnMimeTypeReadListHandler.addElementHandler( "MimeType", getRspnMimeTypeRecHandler() );
		}
		return( rspnMimeTypeReadListHandler );
	}

	protected CFBamXMsgRspnMimeTypeLockedHandler getRspnMimeTypeLockedHandler() {
		if( rspnMimeTypeLockedHandler == null ) {
			rspnMimeTypeLockedHandler = new CFBamXMsgRspnMimeTypeLockedHandler( this );
		}
		return( rspnMimeTypeLockedHandler );
	}

	protected CFBamXMsgRspnMimeTypeUpdatedHandler getRspnMimeTypeUpdatedHandler() {
		if( rspnMimeTypeUpdatedHandler == null ) {
			rspnMimeTypeUpdatedHandler = new CFBamXMsgRspnMimeTypeUpdatedHandler( this );
		}
		return( rspnMimeTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnMimeTypeDeletedHandler getRspnMimeTypeDeletedHandler() {
		if( rspnMimeTypeDeletedHandler == null ) {
			rspnMimeTypeDeletedHandler = new CFBamXMsgRspnMimeTypeDeletedHandler( this );
		}
		return( rspnMimeTypeDeletedHandler );
	}

	// MinorVersion Response Handlers

	protected CFBamXMsgRspnMinorVersionRecHandler getRspnMinorVersionRecHandler() {
		if( rspnMinorVersionRecHandler == null ) {
			rspnMinorVersionRecHandler = new CFBamXMsgRspnMinorVersionRecHandler( this );
		}
		return( rspnMinorVersionRecHandler );
	}

	protected CFBamXMsgRspnMinorVersionCreatedHandler getRspnMinorVersionCreatedHandler() {
		if( rspnMinorVersionCreatedHandler == null ) {
			rspnMinorVersionCreatedHandler = new CFBamXMsgRspnMinorVersionCreatedHandler( this );
		}
		return( rspnMinorVersionCreatedHandler );
	}

	protected CFBamXMsgRspnMinorVersionReadSingleHandler getRspnMinorVersionReadSingleHandler() {
		if( rspnMinorVersionReadSingleHandler == null ) {
			rspnMinorVersionReadSingleHandler = new CFBamXMsgRspnMinorVersionReadSingleHandler( this );
			rspnMinorVersionReadSingleHandler.addElementHandler( "MinorVersion", getRspnMinorVersionRecHandler() );
		}
		return( rspnMinorVersionReadSingleHandler );
	}

	protected CFBamXMsgRspnMinorVersionReadListHandler getRspnMinorVersionReadListHandler() {
		if( rspnMinorVersionReadListHandler == null ) {
			rspnMinorVersionReadListHandler = new CFBamXMsgRspnMinorVersionReadListHandler( this );
			rspnMinorVersionReadListHandler.addElementHandler( "MinorVersion", getRspnMinorVersionRecHandler() );
		}
		return( rspnMinorVersionReadListHandler );
	}

	protected CFBamXMsgRspnMinorVersionLockedHandler getRspnMinorVersionLockedHandler() {
		if( rspnMinorVersionLockedHandler == null ) {
			rspnMinorVersionLockedHandler = new CFBamXMsgRspnMinorVersionLockedHandler( this );
		}
		return( rspnMinorVersionLockedHandler );
	}

	protected CFBamXMsgRspnMinorVersionUpdatedHandler getRspnMinorVersionUpdatedHandler() {
		if( rspnMinorVersionUpdatedHandler == null ) {
			rspnMinorVersionUpdatedHandler = new CFBamXMsgRspnMinorVersionUpdatedHandler( this );
		}
		return( rspnMinorVersionUpdatedHandler );
	}

	protected CFBamXMsgRspnMinorVersionDeletedHandler getRspnMinorVersionDeletedHandler() {
		if( rspnMinorVersionDeletedHandler == null ) {
			rspnMinorVersionDeletedHandler = new CFBamXMsgRspnMinorVersionDeletedHandler( this );
		}
		return( rspnMinorVersionDeletedHandler );
	}

	// NmTokenCol Response Handlers

	protected CFBamXMsgRspnNmTokenColRecHandler getRspnNmTokenColRecHandler() {
		if( rspnNmTokenColRecHandler == null ) {
			rspnNmTokenColRecHandler = new CFBamXMsgRspnNmTokenColRecHandler( this );
		}
		return( rspnNmTokenColRecHandler );
	}

	protected CFBamXMsgRspnNmTokenColCreatedHandler getRspnNmTokenColCreatedHandler() {
		if( rspnNmTokenColCreatedHandler == null ) {
			rspnNmTokenColCreatedHandler = new CFBamXMsgRspnNmTokenColCreatedHandler( this );
		}
		return( rspnNmTokenColCreatedHandler );
	}

	protected CFBamXMsgRspnNmTokenColReadSingleHandler getRspnNmTokenColReadSingleHandler() {
		if( rspnNmTokenColReadSingleHandler == null ) {
			rspnNmTokenColReadSingleHandler = new CFBamXMsgRspnNmTokenColReadSingleHandler( this );
			rspnNmTokenColReadSingleHandler.addElementHandler( "NmTokenCol", getRspnNmTokenColRecHandler() );
		}
		return( rspnNmTokenColReadSingleHandler );
	}

	protected CFBamXMsgRspnNmTokenColReadListHandler getRspnNmTokenColReadListHandler() {
		if( rspnNmTokenColReadListHandler == null ) {
			rspnNmTokenColReadListHandler = new CFBamXMsgRspnNmTokenColReadListHandler( this );
			rspnNmTokenColReadListHandler.addElementHandler( "NmTokenCol", getRspnNmTokenColRecHandler() );
		}
		return( rspnNmTokenColReadListHandler );
	}

	protected CFBamXMsgRspnNmTokenColLockedHandler getRspnNmTokenColLockedHandler() {
		if( rspnNmTokenColLockedHandler == null ) {
			rspnNmTokenColLockedHandler = new CFBamXMsgRspnNmTokenColLockedHandler( this );
		}
		return( rspnNmTokenColLockedHandler );
	}

	protected CFBamXMsgRspnNmTokenColUpdatedHandler getRspnNmTokenColUpdatedHandler() {
		if( rspnNmTokenColUpdatedHandler == null ) {
			rspnNmTokenColUpdatedHandler = new CFBamXMsgRspnNmTokenColUpdatedHandler( this );
		}
		return( rspnNmTokenColUpdatedHandler );
	}

	protected CFBamXMsgRspnNmTokenColDeletedHandler getRspnNmTokenColDeletedHandler() {
		if( rspnNmTokenColDeletedHandler == null ) {
			rspnNmTokenColDeletedHandler = new CFBamXMsgRspnNmTokenColDeletedHandler( this );
		}
		return( rspnNmTokenColDeletedHandler );
	}

	// NmTokenDef Response Handlers

	protected CFBamXMsgRspnNmTokenDefRecHandler getRspnNmTokenDefRecHandler() {
		if( rspnNmTokenDefRecHandler == null ) {
			rspnNmTokenDefRecHandler = new CFBamXMsgRspnNmTokenDefRecHandler( this );
		}
		return( rspnNmTokenDefRecHandler );
	}

	protected CFBamXMsgRspnNmTokenDefCreatedHandler getRspnNmTokenDefCreatedHandler() {
		if( rspnNmTokenDefCreatedHandler == null ) {
			rspnNmTokenDefCreatedHandler = new CFBamXMsgRspnNmTokenDefCreatedHandler( this );
		}
		return( rspnNmTokenDefCreatedHandler );
	}

	protected CFBamXMsgRspnNmTokenDefReadSingleHandler getRspnNmTokenDefReadSingleHandler() {
		if( rspnNmTokenDefReadSingleHandler == null ) {
			rspnNmTokenDefReadSingleHandler = new CFBamXMsgRspnNmTokenDefReadSingleHandler( this );
			rspnNmTokenDefReadSingleHandler.addElementHandler( "NmTokenDef", getRspnNmTokenDefRecHandler() );
			rspnNmTokenDefReadSingleHandler.addElementHandler( "NmTokenCol", getRspnNmTokenColRecHandler() );
			rspnNmTokenDefReadSingleHandler.addElementHandler( "NmTokenType", getRspnNmTokenTypeRecHandler() );
		}
		return( rspnNmTokenDefReadSingleHandler );
	}

	protected CFBamXMsgRspnNmTokenDefReadListHandler getRspnNmTokenDefReadListHandler() {
		if( rspnNmTokenDefReadListHandler == null ) {
			rspnNmTokenDefReadListHandler = new CFBamXMsgRspnNmTokenDefReadListHandler( this );
			rspnNmTokenDefReadListHandler.addElementHandler( "NmTokenDef", getRspnNmTokenDefRecHandler() );
			rspnNmTokenDefReadListHandler.addElementHandler( "NmTokenCol", getRspnNmTokenColRecHandler() );
			rspnNmTokenDefReadListHandler.addElementHandler( "NmTokenType", getRspnNmTokenTypeRecHandler() );
		}
		return( rspnNmTokenDefReadListHandler );
	}

	protected CFBamXMsgRspnNmTokenDefLockedHandler getRspnNmTokenDefLockedHandler() {
		if( rspnNmTokenDefLockedHandler == null ) {
			rspnNmTokenDefLockedHandler = new CFBamXMsgRspnNmTokenDefLockedHandler( this );
		}
		return( rspnNmTokenDefLockedHandler );
	}

	protected CFBamXMsgRspnNmTokenDefUpdatedHandler getRspnNmTokenDefUpdatedHandler() {
		if( rspnNmTokenDefUpdatedHandler == null ) {
			rspnNmTokenDefUpdatedHandler = new CFBamXMsgRspnNmTokenDefUpdatedHandler( this );
		}
		return( rspnNmTokenDefUpdatedHandler );
	}

	protected CFBamXMsgRspnNmTokenDefDeletedHandler getRspnNmTokenDefDeletedHandler() {
		if( rspnNmTokenDefDeletedHandler == null ) {
			rspnNmTokenDefDeletedHandler = new CFBamXMsgRspnNmTokenDefDeletedHandler( this );
		}
		return( rspnNmTokenDefDeletedHandler );
	}

	// NmTokenType Response Handlers

	protected CFBamXMsgRspnNmTokenTypeRecHandler getRspnNmTokenTypeRecHandler() {
		if( rspnNmTokenTypeRecHandler == null ) {
			rspnNmTokenTypeRecHandler = new CFBamXMsgRspnNmTokenTypeRecHandler( this );
		}
		return( rspnNmTokenTypeRecHandler );
	}

	protected CFBamXMsgRspnNmTokenTypeCreatedHandler getRspnNmTokenTypeCreatedHandler() {
		if( rspnNmTokenTypeCreatedHandler == null ) {
			rspnNmTokenTypeCreatedHandler = new CFBamXMsgRspnNmTokenTypeCreatedHandler( this );
		}
		return( rspnNmTokenTypeCreatedHandler );
	}

	protected CFBamXMsgRspnNmTokenTypeReadSingleHandler getRspnNmTokenTypeReadSingleHandler() {
		if( rspnNmTokenTypeReadSingleHandler == null ) {
			rspnNmTokenTypeReadSingleHandler = new CFBamXMsgRspnNmTokenTypeReadSingleHandler( this );
			rspnNmTokenTypeReadSingleHandler.addElementHandler( "NmTokenType", getRspnNmTokenTypeRecHandler() );
		}
		return( rspnNmTokenTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnNmTokenTypeReadListHandler getRspnNmTokenTypeReadListHandler() {
		if( rspnNmTokenTypeReadListHandler == null ) {
			rspnNmTokenTypeReadListHandler = new CFBamXMsgRspnNmTokenTypeReadListHandler( this );
			rspnNmTokenTypeReadListHandler.addElementHandler( "NmTokenType", getRspnNmTokenTypeRecHandler() );
		}
		return( rspnNmTokenTypeReadListHandler );
	}

	protected CFBamXMsgRspnNmTokenTypeLockedHandler getRspnNmTokenTypeLockedHandler() {
		if( rspnNmTokenTypeLockedHandler == null ) {
			rspnNmTokenTypeLockedHandler = new CFBamXMsgRspnNmTokenTypeLockedHandler( this );
		}
		return( rspnNmTokenTypeLockedHandler );
	}

	protected CFBamXMsgRspnNmTokenTypeUpdatedHandler getRspnNmTokenTypeUpdatedHandler() {
		if( rspnNmTokenTypeUpdatedHandler == null ) {
			rspnNmTokenTypeUpdatedHandler = new CFBamXMsgRspnNmTokenTypeUpdatedHandler( this );
		}
		return( rspnNmTokenTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnNmTokenTypeDeletedHandler getRspnNmTokenTypeDeletedHandler() {
		if( rspnNmTokenTypeDeletedHandler == null ) {
			rspnNmTokenTypeDeletedHandler = new CFBamXMsgRspnNmTokenTypeDeletedHandler( this );
		}
		return( rspnNmTokenTypeDeletedHandler );
	}

	// NmTokensCol Response Handlers

	protected CFBamXMsgRspnNmTokensColRecHandler getRspnNmTokensColRecHandler() {
		if( rspnNmTokensColRecHandler == null ) {
			rspnNmTokensColRecHandler = new CFBamXMsgRspnNmTokensColRecHandler( this );
		}
		return( rspnNmTokensColRecHandler );
	}

	protected CFBamXMsgRspnNmTokensColCreatedHandler getRspnNmTokensColCreatedHandler() {
		if( rspnNmTokensColCreatedHandler == null ) {
			rspnNmTokensColCreatedHandler = new CFBamXMsgRspnNmTokensColCreatedHandler( this );
		}
		return( rspnNmTokensColCreatedHandler );
	}

	protected CFBamXMsgRspnNmTokensColReadSingleHandler getRspnNmTokensColReadSingleHandler() {
		if( rspnNmTokensColReadSingleHandler == null ) {
			rspnNmTokensColReadSingleHandler = new CFBamXMsgRspnNmTokensColReadSingleHandler( this );
			rspnNmTokensColReadSingleHandler.addElementHandler( "NmTokensCol", getRspnNmTokensColRecHandler() );
		}
		return( rspnNmTokensColReadSingleHandler );
	}

	protected CFBamXMsgRspnNmTokensColReadListHandler getRspnNmTokensColReadListHandler() {
		if( rspnNmTokensColReadListHandler == null ) {
			rspnNmTokensColReadListHandler = new CFBamXMsgRspnNmTokensColReadListHandler( this );
			rspnNmTokensColReadListHandler.addElementHandler( "NmTokensCol", getRspnNmTokensColRecHandler() );
		}
		return( rspnNmTokensColReadListHandler );
	}

	protected CFBamXMsgRspnNmTokensColLockedHandler getRspnNmTokensColLockedHandler() {
		if( rspnNmTokensColLockedHandler == null ) {
			rspnNmTokensColLockedHandler = new CFBamXMsgRspnNmTokensColLockedHandler( this );
		}
		return( rspnNmTokensColLockedHandler );
	}

	protected CFBamXMsgRspnNmTokensColUpdatedHandler getRspnNmTokensColUpdatedHandler() {
		if( rspnNmTokensColUpdatedHandler == null ) {
			rspnNmTokensColUpdatedHandler = new CFBamXMsgRspnNmTokensColUpdatedHandler( this );
		}
		return( rspnNmTokensColUpdatedHandler );
	}

	protected CFBamXMsgRspnNmTokensColDeletedHandler getRspnNmTokensColDeletedHandler() {
		if( rspnNmTokensColDeletedHandler == null ) {
			rspnNmTokensColDeletedHandler = new CFBamXMsgRspnNmTokensColDeletedHandler( this );
		}
		return( rspnNmTokensColDeletedHandler );
	}

	// NmTokensDef Response Handlers

	protected CFBamXMsgRspnNmTokensDefRecHandler getRspnNmTokensDefRecHandler() {
		if( rspnNmTokensDefRecHandler == null ) {
			rspnNmTokensDefRecHandler = new CFBamXMsgRspnNmTokensDefRecHandler( this );
		}
		return( rspnNmTokensDefRecHandler );
	}

	protected CFBamXMsgRspnNmTokensDefCreatedHandler getRspnNmTokensDefCreatedHandler() {
		if( rspnNmTokensDefCreatedHandler == null ) {
			rspnNmTokensDefCreatedHandler = new CFBamXMsgRspnNmTokensDefCreatedHandler( this );
		}
		return( rspnNmTokensDefCreatedHandler );
	}

	protected CFBamXMsgRspnNmTokensDefReadSingleHandler getRspnNmTokensDefReadSingleHandler() {
		if( rspnNmTokensDefReadSingleHandler == null ) {
			rspnNmTokensDefReadSingleHandler = new CFBamXMsgRspnNmTokensDefReadSingleHandler( this );
			rspnNmTokensDefReadSingleHandler.addElementHandler( "NmTokensDef", getRspnNmTokensDefRecHandler() );
			rspnNmTokensDefReadSingleHandler.addElementHandler( "NmTokensCol", getRspnNmTokensColRecHandler() );
			rspnNmTokensDefReadSingleHandler.addElementHandler( "NmTokensType", getRspnNmTokensTypeRecHandler() );
		}
		return( rspnNmTokensDefReadSingleHandler );
	}

	protected CFBamXMsgRspnNmTokensDefReadListHandler getRspnNmTokensDefReadListHandler() {
		if( rspnNmTokensDefReadListHandler == null ) {
			rspnNmTokensDefReadListHandler = new CFBamXMsgRspnNmTokensDefReadListHandler( this );
			rspnNmTokensDefReadListHandler.addElementHandler( "NmTokensDef", getRspnNmTokensDefRecHandler() );
			rspnNmTokensDefReadListHandler.addElementHandler( "NmTokensCol", getRspnNmTokensColRecHandler() );
			rspnNmTokensDefReadListHandler.addElementHandler( "NmTokensType", getRspnNmTokensTypeRecHandler() );
		}
		return( rspnNmTokensDefReadListHandler );
	}

	protected CFBamXMsgRspnNmTokensDefLockedHandler getRspnNmTokensDefLockedHandler() {
		if( rspnNmTokensDefLockedHandler == null ) {
			rspnNmTokensDefLockedHandler = new CFBamXMsgRspnNmTokensDefLockedHandler( this );
		}
		return( rspnNmTokensDefLockedHandler );
	}

	protected CFBamXMsgRspnNmTokensDefUpdatedHandler getRspnNmTokensDefUpdatedHandler() {
		if( rspnNmTokensDefUpdatedHandler == null ) {
			rspnNmTokensDefUpdatedHandler = new CFBamXMsgRspnNmTokensDefUpdatedHandler( this );
		}
		return( rspnNmTokensDefUpdatedHandler );
	}

	protected CFBamXMsgRspnNmTokensDefDeletedHandler getRspnNmTokensDefDeletedHandler() {
		if( rspnNmTokensDefDeletedHandler == null ) {
			rspnNmTokensDefDeletedHandler = new CFBamXMsgRspnNmTokensDefDeletedHandler( this );
		}
		return( rspnNmTokensDefDeletedHandler );
	}

	// NmTokensType Response Handlers

	protected CFBamXMsgRspnNmTokensTypeRecHandler getRspnNmTokensTypeRecHandler() {
		if( rspnNmTokensTypeRecHandler == null ) {
			rspnNmTokensTypeRecHandler = new CFBamXMsgRspnNmTokensTypeRecHandler( this );
		}
		return( rspnNmTokensTypeRecHandler );
	}

	protected CFBamXMsgRspnNmTokensTypeCreatedHandler getRspnNmTokensTypeCreatedHandler() {
		if( rspnNmTokensTypeCreatedHandler == null ) {
			rspnNmTokensTypeCreatedHandler = new CFBamXMsgRspnNmTokensTypeCreatedHandler( this );
		}
		return( rspnNmTokensTypeCreatedHandler );
	}

	protected CFBamXMsgRspnNmTokensTypeReadSingleHandler getRspnNmTokensTypeReadSingleHandler() {
		if( rspnNmTokensTypeReadSingleHandler == null ) {
			rspnNmTokensTypeReadSingleHandler = new CFBamXMsgRspnNmTokensTypeReadSingleHandler( this );
			rspnNmTokensTypeReadSingleHandler.addElementHandler( "NmTokensType", getRspnNmTokensTypeRecHandler() );
		}
		return( rspnNmTokensTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnNmTokensTypeReadListHandler getRspnNmTokensTypeReadListHandler() {
		if( rspnNmTokensTypeReadListHandler == null ) {
			rspnNmTokensTypeReadListHandler = new CFBamXMsgRspnNmTokensTypeReadListHandler( this );
			rspnNmTokensTypeReadListHandler.addElementHandler( "NmTokensType", getRspnNmTokensTypeRecHandler() );
		}
		return( rspnNmTokensTypeReadListHandler );
	}

	protected CFBamXMsgRspnNmTokensTypeLockedHandler getRspnNmTokensTypeLockedHandler() {
		if( rspnNmTokensTypeLockedHandler == null ) {
			rspnNmTokensTypeLockedHandler = new CFBamXMsgRspnNmTokensTypeLockedHandler( this );
		}
		return( rspnNmTokensTypeLockedHandler );
	}

	protected CFBamXMsgRspnNmTokensTypeUpdatedHandler getRspnNmTokensTypeUpdatedHandler() {
		if( rspnNmTokensTypeUpdatedHandler == null ) {
			rspnNmTokensTypeUpdatedHandler = new CFBamXMsgRspnNmTokensTypeUpdatedHandler( this );
		}
		return( rspnNmTokensTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnNmTokensTypeDeletedHandler getRspnNmTokensTypeDeletedHandler() {
		if( rspnNmTokensTypeDeletedHandler == null ) {
			rspnNmTokensTypeDeletedHandler = new CFBamXMsgRspnNmTokensTypeDeletedHandler( this );
		}
		return( rspnNmTokensTypeDeletedHandler );
	}

	// NumberCol Response Handlers

	protected CFBamXMsgRspnNumberColRecHandler getRspnNumberColRecHandler() {
		if( rspnNumberColRecHandler == null ) {
			rspnNumberColRecHandler = new CFBamXMsgRspnNumberColRecHandler( this );
		}
		return( rspnNumberColRecHandler );
	}

	protected CFBamXMsgRspnNumberColCreatedHandler getRspnNumberColCreatedHandler() {
		if( rspnNumberColCreatedHandler == null ) {
			rspnNumberColCreatedHandler = new CFBamXMsgRspnNumberColCreatedHandler( this );
		}
		return( rspnNumberColCreatedHandler );
	}

	protected CFBamXMsgRspnNumberColReadSingleHandler getRspnNumberColReadSingleHandler() {
		if( rspnNumberColReadSingleHandler == null ) {
			rspnNumberColReadSingleHandler = new CFBamXMsgRspnNumberColReadSingleHandler( this );
			rspnNumberColReadSingleHandler.addElementHandler( "NumberCol", getRspnNumberColRecHandler() );
		}
		return( rspnNumberColReadSingleHandler );
	}

	protected CFBamXMsgRspnNumberColReadListHandler getRspnNumberColReadListHandler() {
		if( rspnNumberColReadListHandler == null ) {
			rspnNumberColReadListHandler = new CFBamXMsgRspnNumberColReadListHandler( this );
			rspnNumberColReadListHandler.addElementHandler( "NumberCol", getRspnNumberColRecHandler() );
		}
		return( rspnNumberColReadListHandler );
	}

	protected CFBamXMsgRspnNumberColLockedHandler getRspnNumberColLockedHandler() {
		if( rspnNumberColLockedHandler == null ) {
			rspnNumberColLockedHandler = new CFBamXMsgRspnNumberColLockedHandler( this );
		}
		return( rspnNumberColLockedHandler );
	}

	protected CFBamXMsgRspnNumberColUpdatedHandler getRspnNumberColUpdatedHandler() {
		if( rspnNumberColUpdatedHandler == null ) {
			rspnNumberColUpdatedHandler = new CFBamXMsgRspnNumberColUpdatedHandler( this );
		}
		return( rspnNumberColUpdatedHandler );
	}

	protected CFBamXMsgRspnNumberColDeletedHandler getRspnNumberColDeletedHandler() {
		if( rspnNumberColDeletedHandler == null ) {
			rspnNumberColDeletedHandler = new CFBamXMsgRspnNumberColDeletedHandler( this );
		}
		return( rspnNumberColDeletedHandler );
	}

	// NumberDef Response Handlers

	protected CFBamXMsgRspnNumberDefRecHandler getRspnNumberDefRecHandler() {
		if( rspnNumberDefRecHandler == null ) {
			rspnNumberDefRecHandler = new CFBamXMsgRspnNumberDefRecHandler( this );
		}
		return( rspnNumberDefRecHandler );
	}

	protected CFBamXMsgRspnNumberDefCreatedHandler getRspnNumberDefCreatedHandler() {
		if( rspnNumberDefCreatedHandler == null ) {
			rspnNumberDefCreatedHandler = new CFBamXMsgRspnNumberDefCreatedHandler( this );
		}
		return( rspnNumberDefCreatedHandler );
	}

	protected CFBamXMsgRspnNumberDefReadSingleHandler getRspnNumberDefReadSingleHandler() {
		if( rspnNumberDefReadSingleHandler == null ) {
			rspnNumberDefReadSingleHandler = new CFBamXMsgRspnNumberDefReadSingleHandler( this );
			rspnNumberDefReadSingleHandler.addElementHandler( "NumberDef", getRspnNumberDefRecHandler() );
			rspnNumberDefReadSingleHandler.addElementHandler( "NumberCol", getRspnNumberColRecHandler() );
			rspnNumberDefReadSingleHandler.addElementHandler( "NumberType", getRspnNumberTypeRecHandler() );
		}
		return( rspnNumberDefReadSingleHandler );
	}

	protected CFBamXMsgRspnNumberDefReadListHandler getRspnNumberDefReadListHandler() {
		if( rspnNumberDefReadListHandler == null ) {
			rspnNumberDefReadListHandler = new CFBamXMsgRspnNumberDefReadListHandler( this );
			rspnNumberDefReadListHandler.addElementHandler( "NumberDef", getRspnNumberDefRecHandler() );
			rspnNumberDefReadListHandler.addElementHandler( "NumberCol", getRspnNumberColRecHandler() );
			rspnNumberDefReadListHandler.addElementHandler( "NumberType", getRspnNumberTypeRecHandler() );
		}
		return( rspnNumberDefReadListHandler );
	}

	protected CFBamXMsgRspnNumberDefLockedHandler getRspnNumberDefLockedHandler() {
		if( rspnNumberDefLockedHandler == null ) {
			rspnNumberDefLockedHandler = new CFBamXMsgRspnNumberDefLockedHandler( this );
		}
		return( rspnNumberDefLockedHandler );
	}

	protected CFBamXMsgRspnNumberDefUpdatedHandler getRspnNumberDefUpdatedHandler() {
		if( rspnNumberDefUpdatedHandler == null ) {
			rspnNumberDefUpdatedHandler = new CFBamXMsgRspnNumberDefUpdatedHandler( this );
		}
		return( rspnNumberDefUpdatedHandler );
	}

	protected CFBamXMsgRspnNumberDefDeletedHandler getRspnNumberDefDeletedHandler() {
		if( rspnNumberDefDeletedHandler == null ) {
			rspnNumberDefDeletedHandler = new CFBamXMsgRspnNumberDefDeletedHandler( this );
		}
		return( rspnNumberDefDeletedHandler );
	}

	// NumberType Response Handlers

	protected CFBamXMsgRspnNumberTypeRecHandler getRspnNumberTypeRecHandler() {
		if( rspnNumberTypeRecHandler == null ) {
			rspnNumberTypeRecHandler = new CFBamXMsgRspnNumberTypeRecHandler( this );
		}
		return( rspnNumberTypeRecHandler );
	}

	protected CFBamXMsgRspnNumberTypeCreatedHandler getRspnNumberTypeCreatedHandler() {
		if( rspnNumberTypeCreatedHandler == null ) {
			rspnNumberTypeCreatedHandler = new CFBamXMsgRspnNumberTypeCreatedHandler( this );
		}
		return( rspnNumberTypeCreatedHandler );
	}

	protected CFBamXMsgRspnNumberTypeReadSingleHandler getRspnNumberTypeReadSingleHandler() {
		if( rspnNumberTypeReadSingleHandler == null ) {
			rspnNumberTypeReadSingleHandler = new CFBamXMsgRspnNumberTypeReadSingleHandler( this );
			rspnNumberTypeReadSingleHandler.addElementHandler( "NumberType", getRspnNumberTypeRecHandler() );
		}
		return( rspnNumberTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnNumberTypeReadListHandler getRspnNumberTypeReadListHandler() {
		if( rspnNumberTypeReadListHandler == null ) {
			rspnNumberTypeReadListHandler = new CFBamXMsgRspnNumberTypeReadListHandler( this );
			rspnNumberTypeReadListHandler.addElementHandler( "NumberType", getRspnNumberTypeRecHandler() );
		}
		return( rspnNumberTypeReadListHandler );
	}

	protected CFBamXMsgRspnNumberTypeLockedHandler getRspnNumberTypeLockedHandler() {
		if( rspnNumberTypeLockedHandler == null ) {
			rspnNumberTypeLockedHandler = new CFBamXMsgRspnNumberTypeLockedHandler( this );
		}
		return( rspnNumberTypeLockedHandler );
	}

	protected CFBamXMsgRspnNumberTypeUpdatedHandler getRspnNumberTypeUpdatedHandler() {
		if( rspnNumberTypeUpdatedHandler == null ) {
			rspnNumberTypeUpdatedHandler = new CFBamXMsgRspnNumberTypeUpdatedHandler( this );
		}
		return( rspnNumberTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnNumberTypeDeletedHandler getRspnNumberTypeDeletedHandler() {
		if( rspnNumberTypeDeletedHandler == null ) {
			rspnNumberTypeDeletedHandler = new CFBamXMsgRspnNumberTypeDeletedHandler( this );
		}
		return( rspnNumberTypeDeletedHandler );
	}

	// Param Response Handlers

	protected CFBamXMsgRspnParamRecHandler getRspnParamRecHandler() {
		if( rspnParamRecHandler == null ) {
			rspnParamRecHandler = new CFBamXMsgRspnParamRecHandler( this );
		}
		return( rspnParamRecHandler );
	}

	protected CFBamXMsgRspnParamCreatedHandler getRspnParamCreatedHandler() {
		if( rspnParamCreatedHandler == null ) {
			rspnParamCreatedHandler = new CFBamXMsgRspnParamCreatedHandler( this );
		}
		return( rspnParamCreatedHandler );
	}

	protected CFBamXMsgRspnParamReadSingleHandler getRspnParamReadSingleHandler() {
		if( rspnParamReadSingleHandler == null ) {
			rspnParamReadSingleHandler = new CFBamXMsgRspnParamReadSingleHandler( this );
			rspnParamReadSingleHandler.addElementHandler( "Param", getRspnParamRecHandler() );
		}
		return( rspnParamReadSingleHandler );
	}

	protected CFBamXMsgRspnParamReadListHandler getRspnParamReadListHandler() {
		if( rspnParamReadListHandler == null ) {
			rspnParamReadListHandler = new CFBamXMsgRspnParamReadListHandler( this );
			rspnParamReadListHandler.addElementHandler( "Param", getRspnParamRecHandler() );
		}
		return( rspnParamReadListHandler );
	}

	protected CFBamXMsgRspnParamLockedHandler getRspnParamLockedHandler() {
		if( rspnParamLockedHandler == null ) {
			rspnParamLockedHandler = new CFBamXMsgRspnParamLockedHandler( this );
		}
		return( rspnParamLockedHandler );
	}

	protected CFBamXMsgRspnParamUpdatedHandler getRspnParamUpdatedHandler() {
		if( rspnParamUpdatedHandler == null ) {
			rspnParamUpdatedHandler = new CFBamXMsgRspnParamUpdatedHandler( this );
		}
		return( rspnParamUpdatedHandler );
	}

	protected CFBamXMsgRspnParamDeletedHandler getRspnParamDeletedHandler() {
		if( rspnParamDeletedHandler == null ) {
			rspnParamDeletedHandler = new CFBamXMsgRspnParamDeletedHandler( this );
		}
		return( rspnParamDeletedHandler );
	}

	// PopDep Response Handlers

	protected CFBamXMsgRspnPopDepRecHandler getRspnPopDepRecHandler() {
		if( rspnPopDepRecHandler == null ) {
			rspnPopDepRecHandler = new CFBamXMsgRspnPopDepRecHandler( this );
		}
		return( rspnPopDepRecHandler );
	}

	protected CFBamXMsgRspnPopDepCreatedHandler getRspnPopDepCreatedHandler() {
		if( rspnPopDepCreatedHandler == null ) {
			rspnPopDepCreatedHandler = new CFBamXMsgRspnPopDepCreatedHandler( this );
		}
		return( rspnPopDepCreatedHandler );
	}

	protected CFBamXMsgRspnPopDepReadSingleHandler getRspnPopDepReadSingleHandler() {
		if( rspnPopDepReadSingleHandler == null ) {
			rspnPopDepReadSingleHandler = new CFBamXMsgRspnPopDepReadSingleHandler( this );
			rspnPopDepReadSingleHandler.addElementHandler( "PopDep", getRspnPopDepRecHandler() );
			rspnPopDepReadSingleHandler.addElementHandler( "PopTopDep", getRspnPopTopDepRecHandler() );
			rspnPopDepReadSingleHandler.addElementHandler( "PopSubDep1", getRspnPopSubDep1RecHandler() );
			rspnPopDepReadSingleHandler.addElementHandler( "PopSubDep2", getRspnPopSubDep2RecHandler() );
			rspnPopDepReadSingleHandler.addElementHandler( "PopSubDep3", getRspnPopSubDep3RecHandler() );
		}
		return( rspnPopDepReadSingleHandler );
	}

	protected CFBamXMsgRspnPopDepReadListHandler getRspnPopDepReadListHandler() {
		if( rspnPopDepReadListHandler == null ) {
			rspnPopDepReadListHandler = new CFBamXMsgRspnPopDepReadListHandler( this );
			rspnPopDepReadListHandler.addElementHandler( "PopDep", getRspnPopDepRecHandler() );
			rspnPopDepReadListHandler.addElementHandler( "PopTopDep", getRspnPopTopDepRecHandler() );
			rspnPopDepReadListHandler.addElementHandler( "PopSubDep1", getRspnPopSubDep1RecHandler() );
			rspnPopDepReadListHandler.addElementHandler( "PopSubDep2", getRspnPopSubDep2RecHandler() );
			rspnPopDepReadListHandler.addElementHandler( "PopSubDep3", getRspnPopSubDep3RecHandler() );
		}
		return( rspnPopDepReadListHandler );
	}

	protected CFBamXMsgRspnPopDepLockedHandler getRspnPopDepLockedHandler() {
		if( rspnPopDepLockedHandler == null ) {
			rspnPopDepLockedHandler = new CFBamXMsgRspnPopDepLockedHandler( this );
		}
		return( rspnPopDepLockedHandler );
	}

	protected CFBamXMsgRspnPopDepUpdatedHandler getRspnPopDepUpdatedHandler() {
		if( rspnPopDepUpdatedHandler == null ) {
			rspnPopDepUpdatedHandler = new CFBamXMsgRspnPopDepUpdatedHandler( this );
		}
		return( rspnPopDepUpdatedHandler );
	}

	protected CFBamXMsgRspnPopDepDeletedHandler getRspnPopDepDeletedHandler() {
		if( rspnPopDepDeletedHandler == null ) {
			rspnPopDepDeletedHandler = new CFBamXMsgRspnPopDepDeletedHandler( this );
		}
		return( rspnPopDepDeletedHandler );
	}

	// PopSubDep1 Response Handlers

	protected CFBamXMsgRspnPopSubDep1RecHandler getRspnPopSubDep1RecHandler() {
		if( rspnPopSubDep1RecHandler == null ) {
			rspnPopSubDep1RecHandler = new CFBamXMsgRspnPopSubDep1RecHandler( this );
		}
		return( rspnPopSubDep1RecHandler );
	}

	protected CFBamXMsgRspnPopSubDep1CreatedHandler getRspnPopSubDep1CreatedHandler() {
		if( rspnPopSubDep1CreatedHandler == null ) {
			rspnPopSubDep1CreatedHandler = new CFBamXMsgRspnPopSubDep1CreatedHandler( this );
		}
		return( rspnPopSubDep1CreatedHandler );
	}

	protected CFBamXMsgRspnPopSubDep1ReadSingleHandler getRspnPopSubDep1ReadSingleHandler() {
		if( rspnPopSubDep1ReadSingleHandler == null ) {
			rspnPopSubDep1ReadSingleHandler = new CFBamXMsgRspnPopSubDep1ReadSingleHandler( this );
			rspnPopSubDep1ReadSingleHandler.addElementHandler( "PopSubDep1", getRspnPopSubDep1RecHandler() );
		}
		return( rspnPopSubDep1ReadSingleHandler );
	}

	protected CFBamXMsgRspnPopSubDep1ReadListHandler getRspnPopSubDep1ReadListHandler() {
		if( rspnPopSubDep1ReadListHandler == null ) {
			rspnPopSubDep1ReadListHandler = new CFBamXMsgRspnPopSubDep1ReadListHandler( this );
			rspnPopSubDep1ReadListHandler.addElementHandler( "PopSubDep1", getRspnPopSubDep1RecHandler() );
		}
		return( rspnPopSubDep1ReadListHandler );
	}

	protected CFBamXMsgRspnPopSubDep1LockedHandler getRspnPopSubDep1LockedHandler() {
		if( rspnPopSubDep1LockedHandler == null ) {
			rspnPopSubDep1LockedHandler = new CFBamXMsgRspnPopSubDep1LockedHandler( this );
		}
		return( rspnPopSubDep1LockedHandler );
	}

	protected CFBamXMsgRspnPopSubDep1UpdatedHandler getRspnPopSubDep1UpdatedHandler() {
		if( rspnPopSubDep1UpdatedHandler == null ) {
			rspnPopSubDep1UpdatedHandler = new CFBamXMsgRspnPopSubDep1UpdatedHandler( this );
		}
		return( rspnPopSubDep1UpdatedHandler );
	}

	protected CFBamXMsgRspnPopSubDep1DeletedHandler getRspnPopSubDep1DeletedHandler() {
		if( rspnPopSubDep1DeletedHandler == null ) {
			rspnPopSubDep1DeletedHandler = new CFBamXMsgRspnPopSubDep1DeletedHandler( this );
		}
		return( rspnPopSubDep1DeletedHandler );
	}

	// PopSubDep2 Response Handlers

	protected CFBamXMsgRspnPopSubDep2RecHandler getRspnPopSubDep2RecHandler() {
		if( rspnPopSubDep2RecHandler == null ) {
			rspnPopSubDep2RecHandler = new CFBamXMsgRspnPopSubDep2RecHandler( this );
		}
		return( rspnPopSubDep2RecHandler );
	}

	protected CFBamXMsgRspnPopSubDep2CreatedHandler getRspnPopSubDep2CreatedHandler() {
		if( rspnPopSubDep2CreatedHandler == null ) {
			rspnPopSubDep2CreatedHandler = new CFBamXMsgRspnPopSubDep2CreatedHandler( this );
		}
		return( rspnPopSubDep2CreatedHandler );
	}

	protected CFBamXMsgRspnPopSubDep2ReadSingleHandler getRspnPopSubDep2ReadSingleHandler() {
		if( rspnPopSubDep2ReadSingleHandler == null ) {
			rspnPopSubDep2ReadSingleHandler = new CFBamXMsgRspnPopSubDep2ReadSingleHandler( this );
			rspnPopSubDep2ReadSingleHandler.addElementHandler( "PopSubDep2", getRspnPopSubDep2RecHandler() );
		}
		return( rspnPopSubDep2ReadSingleHandler );
	}

	protected CFBamXMsgRspnPopSubDep2ReadListHandler getRspnPopSubDep2ReadListHandler() {
		if( rspnPopSubDep2ReadListHandler == null ) {
			rspnPopSubDep2ReadListHandler = new CFBamXMsgRspnPopSubDep2ReadListHandler( this );
			rspnPopSubDep2ReadListHandler.addElementHandler( "PopSubDep2", getRspnPopSubDep2RecHandler() );
		}
		return( rspnPopSubDep2ReadListHandler );
	}

	protected CFBamXMsgRspnPopSubDep2LockedHandler getRspnPopSubDep2LockedHandler() {
		if( rspnPopSubDep2LockedHandler == null ) {
			rspnPopSubDep2LockedHandler = new CFBamXMsgRspnPopSubDep2LockedHandler( this );
		}
		return( rspnPopSubDep2LockedHandler );
	}

	protected CFBamXMsgRspnPopSubDep2UpdatedHandler getRspnPopSubDep2UpdatedHandler() {
		if( rspnPopSubDep2UpdatedHandler == null ) {
			rspnPopSubDep2UpdatedHandler = new CFBamXMsgRspnPopSubDep2UpdatedHandler( this );
		}
		return( rspnPopSubDep2UpdatedHandler );
	}

	protected CFBamXMsgRspnPopSubDep2DeletedHandler getRspnPopSubDep2DeletedHandler() {
		if( rspnPopSubDep2DeletedHandler == null ) {
			rspnPopSubDep2DeletedHandler = new CFBamXMsgRspnPopSubDep2DeletedHandler( this );
		}
		return( rspnPopSubDep2DeletedHandler );
	}

	// PopSubDep3 Response Handlers

	protected CFBamXMsgRspnPopSubDep3RecHandler getRspnPopSubDep3RecHandler() {
		if( rspnPopSubDep3RecHandler == null ) {
			rspnPopSubDep3RecHandler = new CFBamXMsgRspnPopSubDep3RecHandler( this );
		}
		return( rspnPopSubDep3RecHandler );
	}

	protected CFBamXMsgRspnPopSubDep3CreatedHandler getRspnPopSubDep3CreatedHandler() {
		if( rspnPopSubDep3CreatedHandler == null ) {
			rspnPopSubDep3CreatedHandler = new CFBamXMsgRspnPopSubDep3CreatedHandler( this );
		}
		return( rspnPopSubDep3CreatedHandler );
	}

	protected CFBamXMsgRspnPopSubDep3ReadSingleHandler getRspnPopSubDep3ReadSingleHandler() {
		if( rspnPopSubDep3ReadSingleHandler == null ) {
			rspnPopSubDep3ReadSingleHandler = new CFBamXMsgRspnPopSubDep3ReadSingleHandler( this );
			rspnPopSubDep3ReadSingleHandler.addElementHandler( "PopSubDep3", getRspnPopSubDep3RecHandler() );
		}
		return( rspnPopSubDep3ReadSingleHandler );
	}

	protected CFBamXMsgRspnPopSubDep3ReadListHandler getRspnPopSubDep3ReadListHandler() {
		if( rspnPopSubDep3ReadListHandler == null ) {
			rspnPopSubDep3ReadListHandler = new CFBamXMsgRspnPopSubDep3ReadListHandler( this );
			rspnPopSubDep3ReadListHandler.addElementHandler( "PopSubDep3", getRspnPopSubDep3RecHandler() );
		}
		return( rspnPopSubDep3ReadListHandler );
	}

	protected CFBamXMsgRspnPopSubDep3LockedHandler getRspnPopSubDep3LockedHandler() {
		if( rspnPopSubDep3LockedHandler == null ) {
			rspnPopSubDep3LockedHandler = new CFBamXMsgRspnPopSubDep3LockedHandler( this );
		}
		return( rspnPopSubDep3LockedHandler );
	}

	protected CFBamXMsgRspnPopSubDep3UpdatedHandler getRspnPopSubDep3UpdatedHandler() {
		if( rspnPopSubDep3UpdatedHandler == null ) {
			rspnPopSubDep3UpdatedHandler = new CFBamXMsgRspnPopSubDep3UpdatedHandler( this );
		}
		return( rspnPopSubDep3UpdatedHandler );
	}

	protected CFBamXMsgRspnPopSubDep3DeletedHandler getRspnPopSubDep3DeletedHandler() {
		if( rspnPopSubDep3DeletedHandler == null ) {
			rspnPopSubDep3DeletedHandler = new CFBamXMsgRspnPopSubDep3DeletedHandler( this );
		}
		return( rspnPopSubDep3DeletedHandler );
	}

	// PopTopDep Response Handlers

	protected CFBamXMsgRspnPopTopDepRecHandler getRspnPopTopDepRecHandler() {
		if( rspnPopTopDepRecHandler == null ) {
			rspnPopTopDepRecHandler = new CFBamXMsgRspnPopTopDepRecHandler( this );
		}
		return( rspnPopTopDepRecHandler );
	}

	protected CFBamXMsgRspnPopTopDepCreatedHandler getRspnPopTopDepCreatedHandler() {
		if( rspnPopTopDepCreatedHandler == null ) {
			rspnPopTopDepCreatedHandler = new CFBamXMsgRspnPopTopDepCreatedHandler( this );
		}
		return( rspnPopTopDepCreatedHandler );
	}

	protected CFBamXMsgRspnPopTopDepReadSingleHandler getRspnPopTopDepReadSingleHandler() {
		if( rspnPopTopDepReadSingleHandler == null ) {
			rspnPopTopDepReadSingleHandler = new CFBamXMsgRspnPopTopDepReadSingleHandler( this );
			rspnPopTopDepReadSingleHandler.addElementHandler( "PopTopDep", getRspnPopTopDepRecHandler() );
		}
		return( rspnPopTopDepReadSingleHandler );
	}

	protected CFBamXMsgRspnPopTopDepReadListHandler getRspnPopTopDepReadListHandler() {
		if( rspnPopTopDepReadListHandler == null ) {
			rspnPopTopDepReadListHandler = new CFBamXMsgRspnPopTopDepReadListHandler( this );
			rspnPopTopDepReadListHandler.addElementHandler( "PopTopDep", getRspnPopTopDepRecHandler() );
		}
		return( rspnPopTopDepReadListHandler );
	}

	protected CFBamXMsgRspnPopTopDepLockedHandler getRspnPopTopDepLockedHandler() {
		if( rspnPopTopDepLockedHandler == null ) {
			rspnPopTopDepLockedHandler = new CFBamXMsgRspnPopTopDepLockedHandler( this );
		}
		return( rspnPopTopDepLockedHandler );
	}

	protected CFBamXMsgRspnPopTopDepUpdatedHandler getRspnPopTopDepUpdatedHandler() {
		if( rspnPopTopDepUpdatedHandler == null ) {
			rspnPopTopDepUpdatedHandler = new CFBamXMsgRspnPopTopDepUpdatedHandler( this );
		}
		return( rspnPopTopDepUpdatedHandler );
	}

	protected CFBamXMsgRspnPopTopDepDeletedHandler getRspnPopTopDepDeletedHandler() {
		if( rspnPopTopDepDeletedHandler == null ) {
			rspnPopTopDepDeletedHandler = new CFBamXMsgRspnPopTopDepDeletedHandler( this );
		}
		return( rspnPopTopDepDeletedHandler );
	}

	// ProjectBase Response Handlers

	protected CFBamXMsgRspnProjectBaseRecHandler getRspnProjectBaseRecHandler() {
		if( rspnProjectBaseRecHandler == null ) {
			rspnProjectBaseRecHandler = new CFBamXMsgRspnProjectBaseRecHandler( this );
		}
		return( rspnProjectBaseRecHandler );
	}

	protected CFBamXMsgRspnProjectBaseCreatedHandler getRspnProjectBaseCreatedHandler() {
		if( rspnProjectBaseCreatedHandler == null ) {
			rspnProjectBaseCreatedHandler = new CFBamXMsgRspnProjectBaseCreatedHandler( this );
		}
		return( rspnProjectBaseCreatedHandler );
	}

	protected CFBamXMsgRspnProjectBaseReadSingleHandler getRspnProjectBaseReadSingleHandler() {
		if( rspnProjectBaseReadSingleHandler == null ) {
			rspnProjectBaseReadSingleHandler = new CFBamXMsgRspnProjectBaseReadSingleHandler( this );
			rspnProjectBaseReadSingleHandler.addElementHandler( "ProjectBase", getRspnProjectBaseRecHandler() );
			rspnProjectBaseReadSingleHandler.addElementHandler( "RealProject", getRspnRealProjectRecHandler() );
			rspnProjectBaseReadSingleHandler.addElementHandler( "TopProject", getRspnTopProjectRecHandler() );
			rspnProjectBaseReadSingleHandler.addElementHandler( "SubProject", getRspnSubProjectRecHandler() );
			rspnProjectBaseReadSingleHandler.addElementHandler( "Version", getRspnVersionRecHandler() );
			rspnProjectBaseReadSingleHandler.addElementHandler( "MajorVersion", getRspnMajorVersionRecHandler() );
			rspnProjectBaseReadSingleHandler.addElementHandler( "MinorVersion", getRspnMinorVersionRecHandler() );
		}
		return( rspnProjectBaseReadSingleHandler );
	}

	protected CFBamXMsgRspnProjectBaseReadListHandler getRspnProjectBaseReadListHandler() {
		if( rspnProjectBaseReadListHandler == null ) {
			rspnProjectBaseReadListHandler = new CFBamXMsgRspnProjectBaseReadListHandler( this );
			rspnProjectBaseReadListHandler.addElementHandler( "ProjectBase", getRspnProjectBaseRecHandler() );
			rspnProjectBaseReadListHandler.addElementHandler( "RealProject", getRspnRealProjectRecHandler() );
			rspnProjectBaseReadListHandler.addElementHandler( "TopProject", getRspnTopProjectRecHandler() );
			rspnProjectBaseReadListHandler.addElementHandler( "SubProject", getRspnSubProjectRecHandler() );
			rspnProjectBaseReadListHandler.addElementHandler( "Version", getRspnVersionRecHandler() );
			rspnProjectBaseReadListHandler.addElementHandler( "MajorVersion", getRspnMajorVersionRecHandler() );
			rspnProjectBaseReadListHandler.addElementHandler( "MinorVersion", getRspnMinorVersionRecHandler() );
		}
		return( rspnProjectBaseReadListHandler );
	}

	protected CFBamXMsgRspnProjectBaseLockedHandler getRspnProjectBaseLockedHandler() {
		if( rspnProjectBaseLockedHandler == null ) {
			rspnProjectBaseLockedHandler = new CFBamXMsgRspnProjectBaseLockedHandler( this );
		}
		return( rspnProjectBaseLockedHandler );
	}

	protected CFBamXMsgRspnProjectBaseUpdatedHandler getRspnProjectBaseUpdatedHandler() {
		if( rspnProjectBaseUpdatedHandler == null ) {
			rspnProjectBaseUpdatedHandler = new CFBamXMsgRspnProjectBaseUpdatedHandler( this );
		}
		return( rspnProjectBaseUpdatedHandler );
	}

	protected CFBamXMsgRspnProjectBaseDeletedHandler getRspnProjectBaseDeletedHandler() {
		if( rspnProjectBaseDeletedHandler == null ) {
			rspnProjectBaseDeletedHandler = new CFBamXMsgRspnProjectBaseDeletedHandler( this );
		}
		return( rspnProjectBaseDeletedHandler );
	}

	// RealProject Response Handlers

	protected CFBamXMsgRspnRealProjectRecHandler getRspnRealProjectRecHandler() {
		if( rspnRealProjectRecHandler == null ) {
			rspnRealProjectRecHandler = new CFBamXMsgRspnRealProjectRecHandler( this );
		}
		return( rspnRealProjectRecHandler );
	}

	protected CFBamXMsgRspnRealProjectCreatedHandler getRspnRealProjectCreatedHandler() {
		if( rspnRealProjectCreatedHandler == null ) {
			rspnRealProjectCreatedHandler = new CFBamXMsgRspnRealProjectCreatedHandler( this );
		}
		return( rspnRealProjectCreatedHandler );
	}

	protected CFBamXMsgRspnRealProjectReadSingleHandler getRspnRealProjectReadSingleHandler() {
		if( rspnRealProjectReadSingleHandler == null ) {
			rspnRealProjectReadSingleHandler = new CFBamXMsgRspnRealProjectReadSingleHandler( this );
			rspnRealProjectReadSingleHandler.addElementHandler( "RealProject", getRspnRealProjectRecHandler() );
			rspnRealProjectReadSingleHandler.addElementHandler( "TopProject", getRspnTopProjectRecHandler() );
			rspnRealProjectReadSingleHandler.addElementHandler( "SubProject", getRspnSubProjectRecHandler() );
		}
		return( rspnRealProjectReadSingleHandler );
	}

	protected CFBamXMsgRspnRealProjectReadListHandler getRspnRealProjectReadListHandler() {
		if( rspnRealProjectReadListHandler == null ) {
			rspnRealProjectReadListHandler = new CFBamXMsgRspnRealProjectReadListHandler( this );
			rspnRealProjectReadListHandler.addElementHandler( "RealProject", getRspnRealProjectRecHandler() );
			rspnRealProjectReadListHandler.addElementHandler( "TopProject", getRspnTopProjectRecHandler() );
			rspnRealProjectReadListHandler.addElementHandler( "SubProject", getRspnSubProjectRecHandler() );
		}
		return( rspnRealProjectReadListHandler );
	}

	protected CFBamXMsgRspnRealProjectLockedHandler getRspnRealProjectLockedHandler() {
		if( rspnRealProjectLockedHandler == null ) {
			rspnRealProjectLockedHandler = new CFBamXMsgRspnRealProjectLockedHandler( this );
		}
		return( rspnRealProjectLockedHandler );
	}

	protected CFBamXMsgRspnRealProjectUpdatedHandler getRspnRealProjectUpdatedHandler() {
		if( rspnRealProjectUpdatedHandler == null ) {
			rspnRealProjectUpdatedHandler = new CFBamXMsgRspnRealProjectUpdatedHandler( this );
		}
		return( rspnRealProjectUpdatedHandler );
	}

	protected CFBamXMsgRspnRealProjectDeletedHandler getRspnRealProjectDeletedHandler() {
		if( rspnRealProjectDeletedHandler == null ) {
			rspnRealProjectDeletedHandler = new CFBamXMsgRspnRealProjectDeletedHandler( this );
		}
		return( rspnRealProjectDeletedHandler );
	}

	// Relation Response Handlers

	protected CFBamXMsgRspnRelationRecHandler getRspnRelationRecHandler() {
		if( rspnRelationRecHandler == null ) {
			rspnRelationRecHandler = new CFBamXMsgRspnRelationRecHandler( this );
		}
		return( rspnRelationRecHandler );
	}

	protected CFBamXMsgRspnRelationCreatedHandler getRspnRelationCreatedHandler() {
		if( rspnRelationCreatedHandler == null ) {
			rspnRelationCreatedHandler = new CFBamXMsgRspnRelationCreatedHandler( this );
		}
		return( rspnRelationCreatedHandler );
	}

	protected CFBamXMsgRspnRelationReadSingleHandler getRspnRelationReadSingleHandler() {
		if( rspnRelationReadSingleHandler == null ) {
			rspnRelationReadSingleHandler = new CFBamXMsgRspnRelationReadSingleHandler( this );
			rspnRelationReadSingleHandler.addElementHandler( "Relation", getRspnRelationRecHandler() );
		}
		return( rspnRelationReadSingleHandler );
	}

	protected CFBamXMsgRspnRelationReadListHandler getRspnRelationReadListHandler() {
		if( rspnRelationReadListHandler == null ) {
			rspnRelationReadListHandler = new CFBamXMsgRspnRelationReadListHandler( this );
			rspnRelationReadListHandler.addElementHandler( "Relation", getRspnRelationRecHandler() );
		}
		return( rspnRelationReadListHandler );
	}

	protected CFBamXMsgRspnRelationLockedHandler getRspnRelationLockedHandler() {
		if( rspnRelationLockedHandler == null ) {
			rspnRelationLockedHandler = new CFBamXMsgRspnRelationLockedHandler( this );
		}
		return( rspnRelationLockedHandler );
	}

	protected CFBamXMsgRspnRelationUpdatedHandler getRspnRelationUpdatedHandler() {
		if( rspnRelationUpdatedHandler == null ) {
			rspnRelationUpdatedHandler = new CFBamXMsgRspnRelationUpdatedHandler( this );
		}
		return( rspnRelationUpdatedHandler );
	}

	protected CFBamXMsgRspnRelationDeletedHandler getRspnRelationDeletedHandler() {
		if( rspnRelationDeletedHandler == null ) {
			rspnRelationDeletedHandler = new CFBamXMsgRspnRelationDeletedHandler( this );
		}
		return( rspnRelationDeletedHandler );
	}

	// RelationCol Response Handlers

	protected CFBamXMsgRspnRelationColRecHandler getRspnRelationColRecHandler() {
		if( rspnRelationColRecHandler == null ) {
			rspnRelationColRecHandler = new CFBamXMsgRspnRelationColRecHandler( this );
		}
		return( rspnRelationColRecHandler );
	}

	protected CFBamXMsgRspnRelationColCreatedHandler getRspnRelationColCreatedHandler() {
		if( rspnRelationColCreatedHandler == null ) {
			rspnRelationColCreatedHandler = new CFBamXMsgRspnRelationColCreatedHandler( this );
		}
		return( rspnRelationColCreatedHandler );
	}

	protected CFBamXMsgRspnRelationColReadSingleHandler getRspnRelationColReadSingleHandler() {
		if( rspnRelationColReadSingleHandler == null ) {
			rspnRelationColReadSingleHandler = new CFBamXMsgRspnRelationColReadSingleHandler( this );
			rspnRelationColReadSingleHandler.addElementHandler( "RelationCol", getRspnRelationColRecHandler() );
		}
		return( rspnRelationColReadSingleHandler );
	}

	protected CFBamXMsgRspnRelationColReadListHandler getRspnRelationColReadListHandler() {
		if( rspnRelationColReadListHandler == null ) {
			rspnRelationColReadListHandler = new CFBamXMsgRspnRelationColReadListHandler( this );
			rspnRelationColReadListHandler.addElementHandler( "RelationCol", getRspnRelationColRecHandler() );
		}
		return( rspnRelationColReadListHandler );
	}

	protected CFBamXMsgRspnRelationColLockedHandler getRspnRelationColLockedHandler() {
		if( rspnRelationColLockedHandler == null ) {
			rspnRelationColLockedHandler = new CFBamXMsgRspnRelationColLockedHandler( this );
		}
		return( rspnRelationColLockedHandler );
	}

	protected CFBamXMsgRspnRelationColUpdatedHandler getRspnRelationColUpdatedHandler() {
		if( rspnRelationColUpdatedHandler == null ) {
			rspnRelationColUpdatedHandler = new CFBamXMsgRspnRelationColUpdatedHandler( this );
		}
		return( rspnRelationColUpdatedHandler );
	}

	protected CFBamXMsgRspnRelationColDeletedHandler getRspnRelationColDeletedHandler() {
		if( rspnRelationColDeletedHandler == null ) {
			rspnRelationColDeletedHandler = new CFBamXMsgRspnRelationColDeletedHandler( this );
		}
		return( rspnRelationColDeletedHandler );
	}

	// RelationType Response Handlers

	protected CFBamXMsgRspnRelationTypeRecHandler getRspnRelationTypeRecHandler() {
		if( rspnRelationTypeRecHandler == null ) {
			rspnRelationTypeRecHandler = new CFBamXMsgRspnRelationTypeRecHandler( this );
		}
		return( rspnRelationTypeRecHandler );
	}

	protected CFBamXMsgRspnRelationTypeCreatedHandler getRspnRelationTypeCreatedHandler() {
		if( rspnRelationTypeCreatedHandler == null ) {
			rspnRelationTypeCreatedHandler = new CFBamXMsgRspnRelationTypeCreatedHandler( this );
		}
		return( rspnRelationTypeCreatedHandler );
	}

	protected CFBamXMsgRspnRelationTypeReadSingleHandler getRspnRelationTypeReadSingleHandler() {
		if( rspnRelationTypeReadSingleHandler == null ) {
			rspnRelationTypeReadSingleHandler = new CFBamXMsgRspnRelationTypeReadSingleHandler( this );
			rspnRelationTypeReadSingleHandler.addElementHandler( "RelationType", getRspnRelationTypeRecHandler() );
		}
		return( rspnRelationTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnRelationTypeReadListHandler getRspnRelationTypeReadListHandler() {
		if( rspnRelationTypeReadListHandler == null ) {
			rspnRelationTypeReadListHandler = new CFBamXMsgRspnRelationTypeReadListHandler( this );
			rspnRelationTypeReadListHandler.addElementHandler( "RelationType", getRspnRelationTypeRecHandler() );
		}
		return( rspnRelationTypeReadListHandler );
	}

	protected CFBamXMsgRspnRelationTypeLockedHandler getRspnRelationTypeLockedHandler() {
		if( rspnRelationTypeLockedHandler == null ) {
			rspnRelationTypeLockedHandler = new CFBamXMsgRspnRelationTypeLockedHandler( this );
		}
		return( rspnRelationTypeLockedHandler );
	}

	protected CFBamXMsgRspnRelationTypeUpdatedHandler getRspnRelationTypeUpdatedHandler() {
		if( rspnRelationTypeUpdatedHandler == null ) {
			rspnRelationTypeUpdatedHandler = new CFBamXMsgRspnRelationTypeUpdatedHandler( this );
		}
		return( rspnRelationTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnRelationTypeDeletedHandler getRspnRelationTypeDeletedHandler() {
		if( rspnRelationTypeDeletedHandler == null ) {
			rspnRelationTypeDeletedHandler = new CFBamXMsgRspnRelationTypeDeletedHandler( this );
		}
		return( rspnRelationTypeDeletedHandler );
	}

	// SchemaDef Response Handlers

	protected CFBamXMsgRspnSchemaDefRecHandler getRspnSchemaDefRecHandler() {
		if( rspnSchemaDefRecHandler == null ) {
			rspnSchemaDefRecHandler = new CFBamXMsgRspnSchemaDefRecHandler( this );
		}
		return( rspnSchemaDefRecHandler );
	}

	protected CFBamXMsgRspnSchemaDefCreatedHandler getRspnSchemaDefCreatedHandler() {
		if( rspnSchemaDefCreatedHandler == null ) {
			rspnSchemaDefCreatedHandler = new CFBamXMsgRspnSchemaDefCreatedHandler( this );
		}
		return( rspnSchemaDefCreatedHandler );
	}

	protected CFBamXMsgRspnSchemaDefReadSingleHandler getRspnSchemaDefReadSingleHandler() {
		if( rspnSchemaDefReadSingleHandler == null ) {
			rspnSchemaDefReadSingleHandler = new CFBamXMsgRspnSchemaDefReadSingleHandler( this );
			rspnSchemaDefReadSingleHandler.addElementHandler( "SchemaDef", getRspnSchemaDefRecHandler() );
		}
		return( rspnSchemaDefReadSingleHandler );
	}

	protected CFBamXMsgRspnSchemaDefReadListHandler getRspnSchemaDefReadListHandler() {
		if( rspnSchemaDefReadListHandler == null ) {
			rspnSchemaDefReadListHandler = new CFBamXMsgRspnSchemaDefReadListHandler( this );
			rspnSchemaDefReadListHandler.addElementHandler( "SchemaDef", getRspnSchemaDefRecHandler() );
		}
		return( rspnSchemaDefReadListHandler );
	}

	protected CFBamXMsgRspnSchemaDefLockedHandler getRspnSchemaDefLockedHandler() {
		if( rspnSchemaDefLockedHandler == null ) {
			rspnSchemaDefLockedHandler = new CFBamXMsgRspnSchemaDefLockedHandler( this );
		}
		return( rspnSchemaDefLockedHandler );
	}

	protected CFBamXMsgRspnSchemaDefUpdatedHandler getRspnSchemaDefUpdatedHandler() {
		if( rspnSchemaDefUpdatedHandler == null ) {
			rspnSchemaDefUpdatedHandler = new CFBamXMsgRspnSchemaDefUpdatedHandler( this );
		}
		return( rspnSchemaDefUpdatedHandler );
	}

	protected CFBamXMsgRspnSchemaDefDeletedHandler getRspnSchemaDefDeletedHandler() {
		if( rspnSchemaDefDeletedHandler == null ) {
			rspnSchemaDefDeletedHandler = new CFBamXMsgRspnSchemaDefDeletedHandler( this );
		}
		return( rspnSchemaDefDeletedHandler );
	}

	// SchemaRef Response Handlers

	protected CFBamXMsgRspnSchemaRefRecHandler getRspnSchemaRefRecHandler() {
		if( rspnSchemaRefRecHandler == null ) {
			rspnSchemaRefRecHandler = new CFBamXMsgRspnSchemaRefRecHandler( this );
		}
		return( rspnSchemaRefRecHandler );
	}

	protected CFBamXMsgRspnSchemaRefCreatedHandler getRspnSchemaRefCreatedHandler() {
		if( rspnSchemaRefCreatedHandler == null ) {
			rspnSchemaRefCreatedHandler = new CFBamXMsgRspnSchemaRefCreatedHandler( this );
		}
		return( rspnSchemaRefCreatedHandler );
	}

	protected CFBamXMsgRspnSchemaRefReadSingleHandler getRspnSchemaRefReadSingleHandler() {
		if( rspnSchemaRefReadSingleHandler == null ) {
			rspnSchemaRefReadSingleHandler = new CFBamXMsgRspnSchemaRefReadSingleHandler( this );
			rspnSchemaRefReadSingleHandler.addElementHandler( "SchemaRef", getRspnSchemaRefRecHandler() );
		}
		return( rspnSchemaRefReadSingleHandler );
	}

	protected CFBamXMsgRspnSchemaRefReadListHandler getRspnSchemaRefReadListHandler() {
		if( rspnSchemaRefReadListHandler == null ) {
			rspnSchemaRefReadListHandler = new CFBamXMsgRspnSchemaRefReadListHandler( this );
			rspnSchemaRefReadListHandler.addElementHandler( "SchemaRef", getRspnSchemaRefRecHandler() );
		}
		return( rspnSchemaRefReadListHandler );
	}

	protected CFBamXMsgRspnSchemaRefLockedHandler getRspnSchemaRefLockedHandler() {
		if( rspnSchemaRefLockedHandler == null ) {
			rspnSchemaRefLockedHandler = new CFBamXMsgRspnSchemaRefLockedHandler( this );
		}
		return( rspnSchemaRefLockedHandler );
	}

	protected CFBamXMsgRspnSchemaRefUpdatedHandler getRspnSchemaRefUpdatedHandler() {
		if( rspnSchemaRefUpdatedHandler == null ) {
			rspnSchemaRefUpdatedHandler = new CFBamXMsgRspnSchemaRefUpdatedHandler( this );
		}
		return( rspnSchemaRefUpdatedHandler );
	}

	protected CFBamXMsgRspnSchemaRefDeletedHandler getRspnSchemaRefDeletedHandler() {
		if( rspnSchemaRefDeletedHandler == null ) {
			rspnSchemaRefDeletedHandler = new CFBamXMsgRspnSchemaRefDeletedHandler( this );
		}
		return( rspnSchemaRefDeletedHandler );
	}

	// Scope Response Handlers

	protected CFBamXMsgRspnScopeRecHandler getRspnScopeRecHandler() {
		if( rspnScopeRecHandler == null ) {
			rspnScopeRecHandler = new CFBamXMsgRspnScopeRecHandler( this );
		}
		return( rspnScopeRecHandler );
	}

	protected CFBamXMsgRspnScopeCreatedHandler getRspnScopeCreatedHandler() {
		if( rspnScopeCreatedHandler == null ) {
			rspnScopeCreatedHandler = new CFBamXMsgRspnScopeCreatedHandler( this );
		}
		return( rspnScopeCreatedHandler );
	}

	protected CFBamXMsgRspnScopeReadSingleHandler getRspnScopeReadSingleHandler() {
		if( rspnScopeReadSingleHandler == null ) {
			rspnScopeReadSingleHandler = new CFBamXMsgRspnScopeReadSingleHandler( this );
			rspnScopeReadSingleHandler.addElementHandler( "Scope", getRspnScopeRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "SchemaDef", getRspnSchemaDefRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "SchemaRef", getRspnSchemaRefRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "Table", getRspnTableRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "DelDep", getRspnDelDepRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "DelTopDep", getRspnDelTopDepRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "DelSubDep1", getRspnDelSubDep1RecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "DelSubDep2", getRspnDelSubDep2RecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "DelSubDep3", getRspnDelSubDep3RecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "Index", getRspnIndexRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "Relation", getRspnRelationRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "ServerMethod", getRspnServerMethodRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "ServerProc", getRspnServerProcRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "ServerObjFunc", getRspnServerObjFuncRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "ServerListFunc", getRspnServerListFuncRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "PopDep", getRspnPopDepRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "PopTopDep", getRspnPopTopDepRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "PopSubDep1", getRspnPopSubDep1RecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "PopSubDep2", getRspnPopSubDep2RecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "PopSubDep3", getRspnPopSubDep3RecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "ClearDep", getRspnClearDepRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "ClearTopDep", getRspnClearTopDepRecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "ClearSubDep1", getRspnClearSubDep1RecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "ClearSubDep2", getRspnClearSubDep2RecHandler() );
			rspnScopeReadSingleHandler.addElementHandler( "ClearSubDep3", getRspnClearSubDep3RecHandler() );
		}
		return( rspnScopeReadSingleHandler );
	}

	protected CFBamXMsgRspnScopeReadListHandler getRspnScopeReadListHandler() {
		if( rspnScopeReadListHandler == null ) {
			rspnScopeReadListHandler = new CFBamXMsgRspnScopeReadListHandler( this );
			rspnScopeReadListHandler.addElementHandler( "Scope", getRspnScopeRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "SchemaDef", getRspnSchemaDefRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "SchemaRef", getRspnSchemaRefRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "Table", getRspnTableRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "DelDep", getRspnDelDepRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "DelTopDep", getRspnDelTopDepRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "DelSubDep1", getRspnDelSubDep1RecHandler() );
			rspnScopeReadListHandler.addElementHandler( "DelSubDep2", getRspnDelSubDep2RecHandler() );
			rspnScopeReadListHandler.addElementHandler( "DelSubDep3", getRspnDelSubDep3RecHandler() );
			rspnScopeReadListHandler.addElementHandler( "Index", getRspnIndexRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "Relation", getRspnRelationRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "ServerMethod", getRspnServerMethodRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "ServerProc", getRspnServerProcRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "ServerObjFunc", getRspnServerObjFuncRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "ServerListFunc", getRspnServerListFuncRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "PopDep", getRspnPopDepRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "PopTopDep", getRspnPopTopDepRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "PopSubDep1", getRspnPopSubDep1RecHandler() );
			rspnScopeReadListHandler.addElementHandler( "PopSubDep2", getRspnPopSubDep2RecHandler() );
			rspnScopeReadListHandler.addElementHandler( "PopSubDep3", getRspnPopSubDep3RecHandler() );
			rspnScopeReadListHandler.addElementHandler( "ClearDep", getRspnClearDepRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "ClearTopDep", getRspnClearTopDepRecHandler() );
			rspnScopeReadListHandler.addElementHandler( "ClearSubDep1", getRspnClearSubDep1RecHandler() );
			rspnScopeReadListHandler.addElementHandler( "ClearSubDep2", getRspnClearSubDep2RecHandler() );
			rspnScopeReadListHandler.addElementHandler( "ClearSubDep3", getRspnClearSubDep3RecHandler() );
		}
		return( rspnScopeReadListHandler );
	}

	protected CFBamXMsgRspnScopeLockedHandler getRspnScopeLockedHandler() {
		if( rspnScopeLockedHandler == null ) {
			rspnScopeLockedHandler = new CFBamXMsgRspnScopeLockedHandler( this );
		}
		return( rspnScopeLockedHandler );
	}

	protected CFBamXMsgRspnScopeUpdatedHandler getRspnScopeUpdatedHandler() {
		if( rspnScopeUpdatedHandler == null ) {
			rspnScopeUpdatedHandler = new CFBamXMsgRspnScopeUpdatedHandler( this );
		}
		return( rspnScopeUpdatedHandler );
	}

	protected CFBamXMsgRspnScopeDeletedHandler getRspnScopeDeletedHandler() {
		if( rspnScopeDeletedHandler == null ) {
			rspnScopeDeletedHandler = new CFBamXMsgRspnScopeDeletedHandler( this );
		}
		return( rspnScopeDeletedHandler );
	}

	// SecApp Response Handlers

	protected CFBamXMsgRspnSecAppRecHandler getRspnSecAppRecHandler() {
		if( rspnSecAppRecHandler == null ) {
			rspnSecAppRecHandler = new CFBamXMsgRspnSecAppRecHandler( this );
		}
		return( rspnSecAppRecHandler );
	}

	protected CFBamXMsgRspnSecAppCreatedHandler getRspnSecAppCreatedHandler() {
		if( rspnSecAppCreatedHandler == null ) {
			rspnSecAppCreatedHandler = new CFBamXMsgRspnSecAppCreatedHandler( this );
		}
		return( rspnSecAppCreatedHandler );
	}

	protected CFBamXMsgRspnSecAppReadSingleHandler getRspnSecAppReadSingleHandler() {
		if( rspnSecAppReadSingleHandler == null ) {
			rspnSecAppReadSingleHandler = new CFBamXMsgRspnSecAppReadSingleHandler( this );
			rspnSecAppReadSingleHandler.addElementHandler( "SecApp", getRspnSecAppRecHandler() );
		}
		return( rspnSecAppReadSingleHandler );
	}

	protected CFBamXMsgRspnSecAppReadListHandler getRspnSecAppReadListHandler() {
		if( rspnSecAppReadListHandler == null ) {
			rspnSecAppReadListHandler = new CFBamXMsgRspnSecAppReadListHandler( this );
			rspnSecAppReadListHandler.addElementHandler( "SecApp", getRspnSecAppRecHandler() );
		}
		return( rspnSecAppReadListHandler );
	}

	protected CFBamXMsgRspnSecAppLockedHandler getRspnSecAppLockedHandler() {
		if( rspnSecAppLockedHandler == null ) {
			rspnSecAppLockedHandler = new CFBamXMsgRspnSecAppLockedHandler( this );
		}
		return( rspnSecAppLockedHandler );
	}

	protected CFBamXMsgRspnSecAppUpdatedHandler getRspnSecAppUpdatedHandler() {
		if( rspnSecAppUpdatedHandler == null ) {
			rspnSecAppUpdatedHandler = new CFBamXMsgRspnSecAppUpdatedHandler( this );
		}
		return( rspnSecAppUpdatedHandler );
	}

	protected CFBamXMsgRspnSecAppDeletedHandler getRspnSecAppDeletedHandler() {
		if( rspnSecAppDeletedHandler == null ) {
			rspnSecAppDeletedHandler = new CFBamXMsgRspnSecAppDeletedHandler( this );
		}
		return( rspnSecAppDeletedHandler );
	}

	// SecDevice Response Handlers

	protected CFBamXMsgRspnSecDeviceRecHandler getRspnSecDeviceRecHandler() {
		if( rspnSecDeviceRecHandler == null ) {
			rspnSecDeviceRecHandler = new CFBamXMsgRspnSecDeviceRecHandler( this );
		}
		return( rspnSecDeviceRecHandler );
	}

	protected CFBamXMsgRspnSecDeviceCreatedHandler getRspnSecDeviceCreatedHandler() {
		if( rspnSecDeviceCreatedHandler == null ) {
			rspnSecDeviceCreatedHandler = new CFBamXMsgRspnSecDeviceCreatedHandler( this );
		}
		return( rspnSecDeviceCreatedHandler );
	}

	protected CFBamXMsgRspnSecDeviceReadSingleHandler getRspnSecDeviceReadSingleHandler() {
		if( rspnSecDeviceReadSingleHandler == null ) {
			rspnSecDeviceReadSingleHandler = new CFBamXMsgRspnSecDeviceReadSingleHandler( this );
			rspnSecDeviceReadSingleHandler.addElementHandler( "SecDevice", getRspnSecDeviceRecHandler() );
		}
		return( rspnSecDeviceReadSingleHandler );
	}

	protected CFBamXMsgRspnSecDeviceReadListHandler getRspnSecDeviceReadListHandler() {
		if( rspnSecDeviceReadListHandler == null ) {
			rspnSecDeviceReadListHandler = new CFBamXMsgRspnSecDeviceReadListHandler( this );
			rspnSecDeviceReadListHandler.addElementHandler( "SecDevice", getRspnSecDeviceRecHandler() );
		}
		return( rspnSecDeviceReadListHandler );
	}

	protected CFBamXMsgRspnSecDeviceLockedHandler getRspnSecDeviceLockedHandler() {
		if( rspnSecDeviceLockedHandler == null ) {
			rspnSecDeviceLockedHandler = new CFBamXMsgRspnSecDeviceLockedHandler( this );
		}
		return( rspnSecDeviceLockedHandler );
	}

	protected CFBamXMsgRspnSecDeviceUpdatedHandler getRspnSecDeviceUpdatedHandler() {
		if( rspnSecDeviceUpdatedHandler == null ) {
			rspnSecDeviceUpdatedHandler = new CFBamXMsgRspnSecDeviceUpdatedHandler( this );
		}
		return( rspnSecDeviceUpdatedHandler );
	}

	protected CFBamXMsgRspnSecDeviceDeletedHandler getRspnSecDeviceDeletedHandler() {
		if( rspnSecDeviceDeletedHandler == null ) {
			rspnSecDeviceDeletedHandler = new CFBamXMsgRspnSecDeviceDeletedHandler( this );
		}
		return( rspnSecDeviceDeletedHandler );
	}

	// SecForm Response Handlers

	protected CFBamXMsgRspnSecFormRecHandler getRspnSecFormRecHandler() {
		if( rspnSecFormRecHandler == null ) {
			rspnSecFormRecHandler = new CFBamXMsgRspnSecFormRecHandler( this );
		}
		return( rspnSecFormRecHandler );
	}

	protected CFBamXMsgRspnSecFormCreatedHandler getRspnSecFormCreatedHandler() {
		if( rspnSecFormCreatedHandler == null ) {
			rspnSecFormCreatedHandler = new CFBamXMsgRspnSecFormCreatedHandler( this );
		}
		return( rspnSecFormCreatedHandler );
	}

	protected CFBamXMsgRspnSecFormReadSingleHandler getRspnSecFormReadSingleHandler() {
		if( rspnSecFormReadSingleHandler == null ) {
			rspnSecFormReadSingleHandler = new CFBamXMsgRspnSecFormReadSingleHandler( this );
			rspnSecFormReadSingleHandler.addElementHandler( "SecForm", getRspnSecFormRecHandler() );
		}
		return( rspnSecFormReadSingleHandler );
	}

	protected CFBamXMsgRspnSecFormReadListHandler getRspnSecFormReadListHandler() {
		if( rspnSecFormReadListHandler == null ) {
			rspnSecFormReadListHandler = new CFBamXMsgRspnSecFormReadListHandler( this );
			rspnSecFormReadListHandler.addElementHandler( "SecForm", getRspnSecFormRecHandler() );
		}
		return( rspnSecFormReadListHandler );
	}

	protected CFBamXMsgRspnSecFormLockedHandler getRspnSecFormLockedHandler() {
		if( rspnSecFormLockedHandler == null ) {
			rspnSecFormLockedHandler = new CFBamXMsgRspnSecFormLockedHandler( this );
		}
		return( rspnSecFormLockedHandler );
	}

	protected CFBamXMsgRspnSecFormUpdatedHandler getRspnSecFormUpdatedHandler() {
		if( rspnSecFormUpdatedHandler == null ) {
			rspnSecFormUpdatedHandler = new CFBamXMsgRspnSecFormUpdatedHandler( this );
		}
		return( rspnSecFormUpdatedHandler );
	}

	protected CFBamXMsgRspnSecFormDeletedHandler getRspnSecFormDeletedHandler() {
		if( rspnSecFormDeletedHandler == null ) {
			rspnSecFormDeletedHandler = new CFBamXMsgRspnSecFormDeletedHandler( this );
		}
		return( rspnSecFormDeletedHandler );
	}

	// SecGroup Response Handlers

	protected CFBamXMsgRspnSecGroupRecHandler getRspnSecGroupRecHandler() {
		if( rspnSecGroupRecHandler == null ) {
			rspnSecGroupRecHandler = new CFBamXMsgRspnSecGroupRecHandler( this );
		}
		return( rspnSecGroupRecHandler );
	}

	protected CFBamXMsgRspnSecGroupCreatedHandler getRspnSecGroupCreatedHandler() {
		if( rspnSecGroupCreatedHandler == null ) {
			rspnSecGroupCreatedHandler = new CFBamXMsgRspnSecGroupCreatedHandler( this );
		}
		return( rspnSecGroupCreatedHandler );
	}

	protected CFBamXMsgRspnSecGroupReadSingleHandler getRspnSecGroupReadSingleHandler() {
		if( rspnSecGroupReadSingleHandler == null ) {
			rspnSecGroupReadSingleHandler = new CFBamXMsgRspnSecGroupReadSingleHandler( this );
			rspnSecGroupReadSingleHandler.addElementHandler( "SecGroup", getRspnSecGroupRecHandler() );
		}
		return( rspnSecGroupReadSingleHandler );
	}

	protected CFBamXMsgRspnSecGroupReadListHandler getRspnSecGroupReadListHandler() {
		if( rspnSecGroupReadListHandler == null ) {
			rspnSecGroupReadListHandler = new CFBamXMsgRspnSecGroupReadListHandler( this );
			rspnSecGroupReadListHandler.addElementHandler( "SecGroup", getRspnSecGroupRecHandler() );
		}
		return( rspnSecGroupReadListHandler );
	}

	protected CFBamXMsgRspnSecGroupLockedHandler getRspnSecGroupLockedHandler() {
		if( rspnSecGroupLockedHandler == null ) {
			rspnSecGroupLockedHandler = new CFBamXMsgRspnSecGroupLockedHandler( this );
		}
		return( rspnSecGroupLockedHandler );
	}

	protected CFBamXMsgRspnSecGroupUpdatedHandler getRspnSecGroupUpdatedHandler() {
		if( rspnSecGroupUpdatedHandler == null ) {
			rspnSecGroupUpdatedHandler = new CFBamXMsgRspnSecGroupUpdatedHandler( this );
		}
		return( rspnSecGroupUpdatedHandler );
	}

	protected CFBamXMsgRspnSecGroupDeletedHandler getRspnSecGroupDeletedHandler() {
		if( rspnSecGroupDeletedHandler == null ) {
			rspnSecGroupDeletedHandler = new CFBamXMsgRspnSecGroupDeletedHandler( this );
		}
		return( rspnSecGroupDeletedHandler );
	}

	// SecGroupForm Response Handlers

	protected CFBamXMsgRspnSecGroupFormRecHandler getRspnSecGroupFormRecHandler() {
		if( rspnSecGroupFormRecHandler == null ) {
			rspnSecGroupFormRecHandler = new CFBamXMsgRspnSecGroupFormRecHandler( this );
		}
		return( rspnSecGroupFormRecHandler );
	}

	protected CFBamXMsgRspnSecGroupFormCreatedHandler getRspnSecGroupFormCreatedHandler() {
		if( rspnSecGroupFormCreatedHandler == null ) {
			rspnSecGroupFormCreatedHandler = new CFBamXMsgRspnSecGroupFormCreatedHandler( this );
		}
		return( rspnSecGroupFormCreatedHandler );
	}

	protected CFBamXMsgRspnSecGroupFormReadSingleHandler getRspnSecGroupFormReadSingleHandler() {
		if( rspnSecGroupFormReadSingleHandler == null ) {
			rspnSecGroupFormReadSingleHandler = new CFBamXMsgRspnSecGroupFormReadSingleHandler( this );
			rspnSecGroupFormReadSingleHandler.addElementHandler( "SecGroupForm", getRspnSecGroupFormRecHandler() );
		}
		return( rspnSecGroupFormReadSingleHandler );
	}

	protected CFBamXMsgRspnSecGroupFormReadListHandler getRspnSecGroupFormReadListHandler() {
		if( rspnSecGroupFormReadListHandler == null ) {
			rspnSecGroupFormReadListHandler = new CFBamXMsgRspnSecGroupFormReadListHandler( this );
			rspnSecGroupFormReadListHandler.addElementHandler( "SecGroupForm", getRspnSecGroupFormRecHandler() );
		}
		return( rspnSecGroupFormReadListHandler );
	}

	protected CFBamXMsgRspnSecGroupFormLockedHandler getRspnSecGroupFormLockedHandler() {
		if( rspnSecGroupFormLockedHandler == null ) {
			rspnSecGroupFormLockedHandler = new CFBamXMsgRspnSecGroupFormLockedHandler( this );
		}
		return( rspnSecGroupFormLockedHandler );
	}

	protected CFBamXMsgRspnSecGroupFormUpdatedHandler getRspnSecGroupFormUpdatedHandler() {
		if( rspnSecGroupFormUpdatedHandler == null ) {
			rspnSecGroupFormUpdatedHandler = new CFBamXMsgRspnSecGroupFormUpdatedHandler( this );
		}
		return( rspnSecGroupFormUpdatedHandler );
	}

	protected CFBamXMsgRspnSecGroupFormDeletedHandler getRspnSecGroupFormDeletedHandler() {
		if( rspnSecGroupFormDeletedHandler == null ) {
			rspnSecGroupFormDeletedHandler = new CFBamXMsgRspnSecGroupFormDeletedHandler( this );
		}
		return( rspnSecGroupFormDeletedHandler );
	}

	// SecGroupInclude Response Handlers

	protected CFBamXMsgRspnSecGroupIncludeRecHandler getRspnSecGroupIncludeRecHandler() {
		if( rspnSecGroupIncludeRecHandler == null ) {
			rspnSecGroupIncludeRecHandler = new CFBamXMsgRspnSecGroupIncludeRecHandler( this );
		}
		return( rspnSecGroupIncludeRecHandler );
	}

	protected CFBamXMsgRspnSecGroupIncludeCreatedHandler getRspnSecGroupIncludeCreatedHandler() {
		if( rspnSecGroupIncludeCreatedHandler == null ) {
			rspnSecGroupIncludeCreatedHandler = new CFBamXMsgRspnSecGroupIncludeCreatedHandler( this );
		}
		return( rspnSecGroupIncludeCreatedHandler );
	}

	protected CFBamXMsgRspnSecGroupIncludeReadSingleHandler getRspnSecGroupIncludeReadSingleHandler() {
		if( rspnSecGroupIncludeReadSingleHandler == null ) {
			rspnSecGroupIncludeReadSingleHandler = new CFBamXMsgRspnSecGroupIncludeReadSingleHandler( this );
			rspnSecGroupIncludeReadSingleHandler.addElementHandler( "SecGroupInclude", getRspnSecGroupIncludeRecHandler() );
		}
		return( rspnSecGroupIncludeReadSingleHandler );
	}

	protected CFBamXMsgRspnSecGroupIncludeReadListHandler getRspnSecGroupIncludeReadListHandler() {
		if( rspnSecGroupIncludeReadListHandler == null ) {
			rspnSecGroupIncludeReadListHandler = new CFBamXMsgRspnSecGroupIncludeReadListHandler( this );
			rspnSecGroupIncludeReadListHandler.addElementHandler( "SecGroupInclude", getRspnSecGroupIncludeRecHandler() );
		}
		return( rspnSecGroupIncludeReadListHandler );
	}

	protected CFBamXMsgRspnSecGroupIncludeLockedHandler getRspnSecGroupIncludeLockedHandler() {
		if( rspnSecGroupIncludeLockedHandler == null ) {
			rspnSecGroupIncludeLockedHandler = new CFBamXMsgRspnSecGroupIncludeLockedHandler( this );
		}
		return( rspnSecGroupIncludeLockedHandler );
	}

	protected CFBamXMsgRspnSecGroupIncludeUpdatedHandler getRspnSecGroupIncludeUpdatedHandler() {
		if( rspnSecGroupIncludeUpdatedHandler == null ) {
			rspnSecGroupIncludeUpdatedHandler = new CFBamXMsgRspnSecGroupIncludeUpdatedHandler( this );
		}
		return( rspnSecGroupIncludeUpdatedHandler );
	}

	protected CFBamXMsgRspnSecGroupIncludeDeletedHandler getRspnSecGroupIncludeDeletedHandler() {
		if( rspnSecGroupIncludeDeletedHandler == null ) {
			rspnSecGroupIncludeDeletedHandler = new CFBamXMsgRspnSecGroupIncludeDeletedHandler( this );
		}
		return( rspnSecGroupIncludeDeletedHandler );
	}

	// SecGroupMember Response Handlers

	protected CFBamXMsgRspnSecGroupMemberRecHandler getRspnSecGroupMemberRecHandler() {
		if( rspnSecGroupMemberRecHandler == null ) {
			rspnSecGroupMemberRecHandler = new CFBamXMsgRspnSecGroupMemberRecHandler( this );
		}
		return( rspnSecGroupMemberRecHandler );
	}

	protected CFBamXMsgRspnSecGroupMemberCreatedHandler getRspnSecGroupMemberCreatedHandler() {
		if( rspnSecGroupMemberCreatedHandler == null ) {
			rspnSecGroupMemberCreatedHandler = new CFBamXMsgRspnSecGroupMemberCreatedHandler( this );
		}
		return( rspnSecGroupMemberCreatedHandler );
	}

	protected CFBamXMsgRspnSecGroupMemberReadSingleHandler getRspnSecGroupMemberReadSingleHandler() {
		if( rspnSecGroupMemberReadSingleHandler == null ) {
			rspnSecGroupMemberReadSingleHandler = new CFBamXMsgRspnSecGroupMemberReadSingleHandler( this );
			rspnSecGroupMemberReadSingleHandler.addElementHandler( "SecGroupMember", getRspnSecGroupMemberRecHandler() );
		}
		return( rspnSecGroupMemberReadSingleHandler );
	}

	protected CFBamXMsgRspnSecGroupMemberReadListHandler getRspnSecGroupMemberReadListHandler() {
		if( rspnSecGroupMemberReadListHandler == null ) {
			rspnSecGroupMemberReadListHandler = new CFBamXMsgRspnSecGroupMemberReadListHandler( this );
			rspnSecGroupMemberReadListHandler.addElementHandler( "SecGroupMember", getRspnSecGroupMemberRecHandler() );
		}
		return( rspnSecGroupMemberReadListHandler );
	}

	protected CFBamXMsgRspnSecGroupMemberLockedHandler getRspnSecGroupMemberLockedHandler() {
		if( rspnSecGroupMemberLockedHandler == null ) {
			rspnSecGroupMemberLockedHandler = new CFBamXMsgRspnSecGroupMemberLockedHandler( this );
		}
		return( rspnSecGroupMemberLockedHandler );
	}

	protected CFBamXMsgRspnSecGroupMemberUpdatedHandler getRspnSecGroupMemberUpdatedHandler() {
		if( rspnSecGroupMemberUpdatedHandler == null ) {
			rspnSecGroupMemberUpdatedHandler = new CFBamXMsgRspnSecGroupMemberUpdatedHandler( this );
		}
		return( rspnSecGroupMemberUpdatedHandler );
	}

	protected CFBamXMsgRspnSecGroupMemberDeletedHandler getRspnSecGroupMemberDeletedHandler() {
		if( rspnSecGroupMemberDeletedHandler == null ) {
			rspnSecGroupMemberDeletedHandler = new CFBamXMsgRspnSecGroupMemberDeletedHandler( this );
		}
		return( rspnSecGroupMemberDeletedHandler );
	}

	// SecSession Response Handlers

	protected CFBamXMsgRspnSecSessionRecHandler getRspnSecSessionRecHandler() {
		if( rspnSecSessionRecHandler == null ) {
			rspnSecSessionRecHandler = new CFBamXMsgRspnSecSessionRecHandler( this );
		}
		return( rspnSecSessionRecHandler );
	}

	protected CFBamXMsgRspnSecSessionCreatedHandler getRspnSecSessionCreatedHandler() {
		if( rspnSecSessionCreatedHandler == null ) {
			rspnSecSessionCreatedHandler = new CFBamXMsgRspnSecSessionCreatedHandler( this );
		}
		return( rspnSecSessionCreatedHandler );
	}

	protected CFBamXMsgRspnSecSessionReadSingleHandler getRspnSecSessionReadSingleHandler() {
		if( rspnSecSessionReadSingleHandler == null ) {
			rspnSecSessionReadSingleHandler = new CFBamXMsgRspnSecSessionReadSingleHandler( this );
			rspnSecSessionReadSingleHandler.addElementHandler( "SecSession", getRspnSecSessionRecHandler() );
		}
		return( rspnSecSessionReadSingleHandler );
	}

	protected CFBamXMsgRspnSecSessionReadListHandler getRspnSecSessionReadListHandler() {
		if( rspnSecSessionReadListHandler == null ) {
			rspnSecSessionReadListHandler = new CFBamXMsgRspnSecSessionReadListHandler( this );
			rspnSecSessionReadListHandler.addElementHandler( "SecSession", getRspnSecSessionRecHandler() );
		}
		return( rspnSecSessionReadListHandler );
	}

	protected CFBamXMsgRspnSecSessionLockedHandler getRspnSecSessionLockedHandler() {
		if( rspnSecSessionLockedHandler == null ) {
			rspnSecSessionLockedHandler = new CFBamXMsgRspnSecSessionLockedHandler( this );
		}
		return( rspnSecSessionLockedHandler );
	}

	protected CFBamXMsgRspnSecSessionUpdatedHandler getRspnSecSessionUpdatedHandler() {
		if( rspnSecSessionUpdatedHandler == null ) {
			rspnSecSessionUpdatedHandler = new CFBamXMsgRspnSecSessionUpdatedHandler( this );
		}
		return( rspnSecSessionUpdatedHandler );
	}

	protected CFBamXMsgRspnSecSessionDeletedHandler getRspnSecSessionDeletedHandler() {
		if( rspnSecSessionDeletedHandler == null ) {
			rspnSecSessionDeletedHandler = new CFBamXMsgRspnSecSessionDeletedHandler( this );
		}
		return( rspnSecSessionDeletedHandler );
	}

	// SecUser Response Handlers

	protected CFBamXMsgRspnSecUserRecHandler getRspnSecUserRecHandler() {
		if( rspnSecUserRecHandler == null ) {
			rspnSecUserRecHandler = new CFBamXMsgRspnSecUserRecHandler( this );
		}
		return( rspnSecUserRecHandler );
	}

	protected CFBamXMsgRspnSecUserCreatedHandler getRspnSecUserCreatedHandler() {
		if( rspnSecUserCreatedHandler == null ) {
			rspnSecUserCreatedHandler = new CFBamXMsgRspnSecUserCreatedHandler( this );
		}
		return( rspnSecUserCreatedHandler );
	}

	protected CFBamXMsgRspnSecUserReadSingleHandler getRspnSecUserReadSingleHandler() {
		if( rspnSecUserReadSingleHandler == null ) {
			rspnSecUserReadSingleHandler = new CFBamXMsgRspnSecUserReadSingleHandler( this );
			rspnSecUserReadSingleHandler.addElementHandler( "SecUser", getRspnSecUserRecHandler() );
		}
		return( rspnSecUserReadSingleHandler );
	}

	protected CFBamXMsgRspnSecUserReadListHandler getRspnSecUserReadListHandler() {
		if( rspnSecUserReadListHandler == null ) {
			rspnSecUserReadListHandler = new CFBamXMsgRspnSecUserReadListHandler( this );
			rspnSecUserReadListHandler.addElementHandler( "SecUser", getRspnSecUserRecHandler() );
		}
		return( rspnSecUserReadListHandler );
	}

	protected CFBamXMsgRspnSecUserLockedHandler getRspnSecUserLockedHandler() {
		if( rspnSecUserLockedHandler == null ) {
			rspnSecUserLockedHandler = new CFBamXMsgRspnSecUserLockedHandler( this );
		}
		return( rspnSecUserLockedHandler );
	}

	protected CFBamXMsgRspnSecUserUpdatedHandler getRspnSecUserUpdatedHandler() {
		if( rspnSecUserUpdatedHandler == null ) {
			rspnSecUserUpdatedHandler = new CFBamXMsgRspnSecUserUpdatedHandler( this );
		}
		return( rspnSecUserUpdatedHandler );
	}

	protected CFBamXMsgRspnSecUserDeletedHandler getRspnSecUserDeletedHandler() {
		if( rspnSecUserDeletedHandler == null ) {
			rspnSecUserDeletedHandler = new CFBamXMsgRspnSecUserDeletedHandler( this );
		}
		return( rspnSecUserDeletedHandler );
	}

	// SecurityScope Response Handlers

	protected CFBamXMsgRspnSecurityScopeRecHandler getRspnSecurityScopeRecHandler() {
		if( rspnSecurityScopeRecHandler == null ) {
			rspnSecurityScopeRecHandler = new CFBamXMsgRspnSecurityScopeRecHandler( this );
		}
		return( rspnSecurityScopeRecHandler );
	}

	protected CFBamXMsgRspnSecurityScopeCreatedHandler getRspnSecurityScopeCreatedHandler() {
		if( rspnSecurityScopeCreatedHandler == null ) {
			rspnSecurityScopeCreatedHandler = new CFBamXMsgRspnSecurityScopeCreatedHandler( this );
		}
		return( rspnSecurityScopeCreatedHandler );
	}

	protected CFBamXMsgRspnSecurityScopeReadSingleHandler getRspnSecurityScopeReadSingleHandler() {
		if( rspnSecurityScopeReadSingleHandler == null ) {
			rspnSecurityScopeReadSingleHandler = new CFBamXMsgRspnSecurityScopeReadSingleHandler( this );
			rspnSecurityScopeReadSingleHandler.addElementHandler( "SecurityScope", getRspnSecurityScopeRecHandler() );
		}
		return( rspnSecurityScopeReadSingleHandler );
	}

	protected CFBamXMsgRspnSecurityScopeReadListHandler getRspnSecurityScopeReadListHandler() {
		if( rspnSecurityScopeReadListHandler == null ) {
			rspnSecurityScopeReadListHandler = new CFBamXMsgRspnSecurityScopeReadListHandler( this );
			rspnSecurityScopeReadListHandler.addElementHandler( "SecurityScope", getRspnSecurityScopeRecHandler() );
		}
		return( rspnSecurityScopeReadListHandler );
	}

	protected CFBamXMsgRspnSecurityScopeLockedHandler getRspnSecurityScopeLockedHandler() {
		if( rspnSecurityScopeLockedHandler == null ) {
			rspnSecurityScopeLockedHandler = new CFBamXMsgRspnSecurityScopeLockedHandler( this );
		}
		return( rspnSecurityScopeLockedHandler );
	}

	protected CFBamXMsgRspnSecurityScopeUpdatedHandler getRspnSecurityScopeUpdatedHandler() {
		if( rspnSecurityScopeUpdatedHandler == null ) {
			rspnSecurityScopeUpdatedHandler = new CFBamXMsgRspnSecurityScopeUpdatedHandler( this );
		}
		return( rspnSecurityScopeUpdatedHandler );
	}

	protected CFBamXMsgRspnSecurityScopeDeletedHandler getRspnSecurityScopeDeletedHandler() {
		if( rspnSecurityScopeDeletedHandler == null ) {
			rspnSecurityScopeDeletedHandler = new CFBamXMsgRspnSecurityScopeDeletedHandler( this );
		}
		return( rspnSecurityScopeDeletedHandler );
	}

	// ServerListFunc Response Handlers

	protected CFBamXMsgRspnServerListFuncRecHandler getRspnServerListFuncRecHandler() {
		if( rspnServerListFuncRecHandler == null ) {
			rspnServerListFuncRecHandler = new CFBamXMsgRspnServerListFuncRecHandler( this );
		}
		return( rspnServerListFuncRecHandler );
	}

	protected CFBamXMsgRspnServerListFuncCreatedHandler getRspnServerListFuncCreatedHandler() {
		if( rspnServerListFuncCreatedHandler == null ) {
			rspnServerListFuncCreatedHandler = new CFBamXMsgRspnServerListFuncCreatedHandler( this );
		}
		return( rspnServerListFuncCreatedHandler );
	}

	protected CFBamXMsgRspnServerListFuncReadSingleHandler getRspnServerListFuncReadSingleHandler() {
		if( rspnServerListFuncReadSingleHandler == null ) {
			rspnServerListFuncReadSingleHandler = new CFBamXMsgRspnServerListFuncReadSingleHandler( this );
			rspnServerListFuncReadSingleHandler.addElementHandler( "ServerListFunc", getRspnServerListFuncRecHandler() );
		}
		return( rspnServerListFuncReadSingleHandler );
	}

	protected CFBamXMsgRspnServerListFuncReadListHandler getRspnServerListFuncReadListHandler() {
		if( rspnServerListFuncReadListHandler == null ) {
			rspnServerListFuncReadListHandler = new CFBamXMsgRspnServerListFuncReadListHandler( this );
			rspnServerListFuncReadListHandler.addElementHandler( "ServerListFunc", getRspnServerListFuncRecHandler() );
		}
		return( rspnServerListFuncReadListHandler );
	}

	protected CFBamXMsgRspnServerListFuncLockedHandler getRspnServerListFuncLockedHandler() {
		if( rspnServerListFuncLockedHandler == null ) {
			rspnServerListFuncLockedHandler = new CFBamXMsgRspnServerListFuncLockedHandler( this );
		}
		return( rspnServerListFuncLockedHandler );
	}

	protected CFBamXMsgRspnServerListFuncUpdatedHandler getRspnServerListFuncUpdatedHandler() {
		if( rspnServerListFuncUpdatedHandler == null ) {
			rspnServerListFuncUpdatedHandler = new CFBamXMsgRspnServerListFuncUpdatedHandler( this );
		}
		return( rspnServerListFuncUpdatedHandler );
	}

	protected CFBamXMsgRspnServerListFuncDeletedHandler getRspnServerListFuncDeletedHandler() {
		if( rspnServerListFuncDeletedHandler == null ) {
			rspnServerListFuncDeletedHandler = new CFBamXMsgRspnServerListFuncDeletedHandler( this );
		}
		return( rspnServerListFuncDeletedHandler );
	}

	// ServerMethod Response Handlers

	protected CFBamXMsgRspnServerMethodRecHandler getRspnServerMethodRecHandler() {
		if( rspnServerMethodRecHandler == null ) {
			rspnServerMethodRecHandler = new CFBamXMsgRspnServerMethodRecHandler( this );
		}
		return( rspnServerMethodRecHandler );
	}

	protected CFBamXMsgRspnServerMethodCreatedHandler getRspnServerMethodCreatedHandler() {
		if( rspnServerMethodCreatedHandler == null ) {
			rspnServerMethodCreatedHandler = new CFBamXMsgRspnServerMethodCreatedHandler( this );
		}
		return( rspnServerMethodCreatedHandler );
	}

	protected CFBamXMsgRspnServerMethodReadSingleHandler getRspnServerMethodReadSingleHandler() {
		if( rspnServerMethodReadSingleHandler == null ) {
			rspnServerMethodReadSingleHandler = new CFBamXMsgRspnServerMethodReadSingleHandler( this );
			rspnServerMethodReadSingleHandler.addElementHandler( "ServerMethod", getRspnServerMethodRecHandler() );
			rspnServerMethodReadSingleHandler.addElementHandler( "ServerProc", getRspnServerProcRecHandler() );
			rspnServerMethodReadSingleHandler.addElementHandler( "ServerObjFunc", getRspnServerObjFuncRecHandler() );
			rspnServerMethodReadSingleHandler.addElementHandler( "ServerListFunc", getRspnServerListFuncRecHandler() );
		}
		return( rspnServerMethodReadSingleHandler );
	}

	protected CFBamXMsgRspnServerMethodReadListHandler getRspnServerMethodReadListHandler() {
		if( rspnServerMethodReadListHandler == null ) {
			rspnServerMethodReadListHandler = new CFBamXMsgRspnServerMethodReadListHandler( this );
			rspnServerMethodReadListHandler.addElementHandler( "ServerMethod", getRspnServerMethodRecHandler() );
			rspnServerMethodReadListHandler.addElementHandler( "ServerProc", getRspnServerProcRecHandler() );
			rspnServerMethodReadListHandler.addElementHandler( "ServerObjFunc", getRspnServerObjFuncRecHandler() );
			rspnServerMethodReadListHandler.addElementHandler( "ServerListFunc", getRspnServerListFuncRecHandler() );
		}
		return( rspnServerMethodReadListHandler );
	}

	protected CFBamXMsgRspnServerMethodLockedHandler getRspnServerMethodLockedHandler() {
		if( rspnServerMethodLockedHandler == null ) {
			rspnServerMethodLockedHandler = new CFBamXMsgRspnServerMethodLockedHandler( this );
		}
		return( rspnServerMethodLockedHandler );
	}

	protected CFBamXMsgRspnServerMethodUpdatedHandler getRspnServerMethodUpdatedHandler() {
		if( rspnServerMethodUpdatedHandler == null ) {
			rspnServerMethodUpdatedHandler = new CFBamXMsgRspnServerMethodUpdatedHandler( this );
		}
		return( rspnServerMethodUpdatedHandler );
	}

	protected CFBamXMsgRspnServerMethodDeletedHandler getRspnServerMethodDeletedHandler() {
		if( rspnServerMethodDeletedHandler == null ) {
			rspnServerMethodDeletedHandler = new CFBamXMsgRspnServerMethodDeletedHandler( this );
		}
		return( rspnServerMethodDeletedHandler );
	}

	// ServerObjFunc Response Handlers

	protected CFBamXMsgRspnServerObjFuncRecHandler getRspnServerObjFuncRecHandler() {
		if( rspnServerObjFuncRecHandler == null ) {
			rspnServerObjFuncRecHandler = new CFBamXMsgRspnServerObjFuncRecHandler( this );
		}
		return( rspnServerObjFuncRecHandler );
	}

	protected CFBamXMsgRspnServerObjFuncCreatedHandler getRspnServerObjFuncCreatedHandler() {
		if( rspnServerObjFuncCreatedHandler == null ) {
			rspnServerObjFuncCreatedHandler = new CFBamXMsgRspnServerObjFuncCreatedHandler( this );
		}
		return( rspnServerObjFuncCreatedHandler );
	}

	protected CFBamXMsgRspnServerObjFuncReadSingleHandler getRspnServerObjFuncReadSingleHandler() {
		if( rspnServerObjFuncReadSingleHandler == null ) {
			rspnServerObjFuncReadSingleHandler = new CFBamXMsgRspnServerObjFuncReadSingleHandler( this );
			rspnServerObjFuncReadSingleHandler.addElementHandler( "ServerObjFunc", getRspnServerObjFuncRecHandler() );
		}
		return( rspnServerObjFuncReadSingleHandler );
	}

	protected CFBamXMsgRspnServerObjFuncReadListHandler getRspnServerObjFuncReadListHandler() {
		if( rspnServerObjFuncReadListHandler == null ) {
			rspnServerObjFuncReadListHandler = new CFBamXMsgRspnServerObjFuncReadListHandler( this );
			rspnServerObjFuncReadListHandler.addElementHandler( "ServerObjFunc", getRspnServerObjFuncRecHandler() );
		}
		return( rspnServerObjFuncReadListHandler );
	}

	protected CFBamXMsgRspnServerObjFuncLockedHandler getRspnServerObjFuncLockedHandler() {
		if( rspnServerObjFuncLockedHandler == null ) {
			rspnServerObjFuncLockedHandler = new CFBamXMsgRspnServerObjFuncLockedHandler( this );
		}
		return( rspnServerObjFuncLockedHandler );
	}

	protected CFBamXMsgRspnServerObjFuncUpdatedHandler getRspnServerObjFuncUpdatedHandler() {
		if( rspnServerObjFuncUpdatedHandler == null ) {
			rspnServerObjFuncUpdatedHandler = new CFBamXMsgRspnServerObjFuncUpdatedHandler( this );
		}
		return( rspnServerObjFuncUpdatedHandler );
	}

	protected CFBamXMsgRspnServerObjFuncDeletedHandler getRspnServerObjFuncDeletedHandler() {
		if( rspnServerObjFuncDeletedHandler == null ) {
			rspnServerObjFuncDeletedHandler = new CFBamXMsgRspnServerObjFuncDeletedHandler( this );
		}
		return( rspnServerObjFuncDeletedHandler );
	}

	// ServerProc Response Handlers

	protected CFBamXMsgRspnServerProcRecHandler getRspnServerProcRecHandler() {
		if( rspnServerProcRecHandler == null ) {
			rspnServerProcRecHandler = new CFBamXMsgRspnServerProcRecHandler( this );
		}
		return( rspnServerProcRecHandler );
	}

	protected CFBamXMsgRspnServerProcCreatedHandler getRspnServerProcCreatedHandler() {
		if( rspnServerProcCreatedHandler == null ) {
			rspnServerProcCreatedHandler = new CFBamXMsgRspnServerProcCreatedHandler( this );
		}
		return( rspnServerProcCreatedHandler );
	}

	protected CFBamXMsgRspnServerProcReadSingleHandler getRspnServerProcReadSingleHandler() {
		if( rspnServerProcReadSingleHandler == null ) {
			rspnServerProcReadSingleHandler = new CFBamXMsgRspnServerProcReadSingleHandler( this );
			rspnServerProcReadSingleHandler.addElementHandler( "ServerProc", getRspnServerProcRecHandler() );
		}
		return( rspnServerProcReadSingleHandler );
	}

	protected CFBamXMsgRspnServerProcReadListHandler getRspnServerProcReadListHandler() {
		if( rspnServerProcReadListHandler == null ) {
			rspnServerProcReadListHandler = new CFBamXMsgRspnServerProcReadListHandler( this );
			rspnServerProcReadListHandler.addElementHandler( "ServerProc", getRspnServerProcRecHandler() );
		}
		return( rspnServerProcReadListHandler );
	}

	protected CFBamXMsgRspnServerProcLockedHandler getRspnServerProcLockedHandler() {
		if( rspnServerProcLockedHandler == null ) {
			rspnServerProcLockedHandler = new CFBamXMsgRspnServerProcLockedHandler( this );
		}
		return( rspnServerProcLockedHandler );
	}

	protected CFBamXMsgRspnServerProcUpdatedHandler getRspnServerProcUpdatedHandler() {
		if( rspnServerProcUpdatedHandler == null ) {
			rspnServerProcUpdatedHandler = new CFBamXMsgRspnServerProcUpdatedHandler( this );
		}
		return( rspnServerProcUpdatedHandler );
	}

	protected CFBamXMsgRspnServerProcDeletedHandler getRspnServerProcDeletedHandler() {
		if( rspnServerProcDeletedHandler == null ) {
			rspnServerProcDeletedHandler = new CFBamXMsgRspnServerProcDeletedHandler( this );
		}
		return( rspnServerProcDeletedHandler );
	}

	// Service Response Handlers

	protected CFBamXMsgRspnServiceRecHandler getRspnServiceRecHandler() {
		if( rspnServiceRecHandler == null ) {
			rspnServiceRecHandler = new CFBamXMsgRspnServiceRecHandler( this );
		}
		return( rspnServiceRecHandler );
	}

	protected CFBamXMsgRspnServiceCreatedHandler getRspnServiceCreatedHandler() {
		if( rspnServiceCreatedHandler == null ) {
			rspnServiceCreatedHandler = new CFBamXMsgRspnServiceCreatedHandler( this );
		}
		return( rspnServiceCreatedHandler );
	}

	protected CFBamXMsgRspnServiceReadSingleHandler getRspnServiceReadSingleHandler() {
		if( rspnServiceReadSingleHandler == null ) {
			rspnServiceReadSingleHandler = new CFBamXMsgRspnServiceReadSingleHandler( this );
			rspnServiceReadSingleHandler.addElementHandler( "Service", getRspnServiceRecHandler() );
		}
		return( rspnServiceReadSingleHandler );
	}

	protected CFBamXMsgRspnServiceReadListHandler getRspnServiceReadListHandler() {
		if( rspnServiceReadListHandler == null ) {
			rspnServiceReadListHandler = new CFBamXMsgRspnServiceReadListHandler( this );
			rspnServiceReadListHandler.addElementHandler( "Service", getRspnServiceRecHandler() );
		}
		return( rspnServiceReadListHandler );
	}

	protected CFBamXMsgRspnServiceLockedHandler getRspnServiceLockedHandler() {
		if( rspnServiceLockedHandler == null ) {
			rspnServiceLockedHandler = new CFBamXMsgRspnServiceLockedHandler( this );
		}
		return( rspnServiceLockedHandler );
	}

	protected CFBamXMsgRspnServiceUpdatedHandler getRspnServiceUpdatedHandler() {
		if( rspnServiceUpdatedHandler == null ) {
			rspnServiceUpdatedHandler = new CFBamXMsgRspnServiceUpdatedHandler( this );
		}
		return( rspnServiceUpdatedHandler );
	}

	protected CFBamXMsgRspnServiceDeletedHandler getRspnServiceDeletedHandler() {
		if( rspnServiceDeletedHandler == null ) {
			rspnServiceDeletedHandler = new CFBamXMsgRspnServiceDeletedHandler( this );
		}
		return( rspnServiceDeletedHandler );
	}

	// ServiceType Response Handlers

	protected CFBamXMsgRspnServiceTypeRecHandler getRspnServiceTypeRecHandler() {
		if( rspnServiceTypeRecHandler == null ) {
			rspnServiceTypeRecHandler = new CFBamXMsgRspnServiceTypeRecHandler( this );
		}
		return( rspnServiceTypeRecHandler );
	}

	protected CFBamXMsgRspnServiceTypeCreatedHandler getRspnServiceTypeCreatedHandler() {
		if( rspnServiceTypeCreatedHandler == null ) {
			rspnServiceTypeCreatedHandler = new CFBamXMsgRspnServiceTypeCreatedHandler( this );
		}
		return( rspnServiceTypeCreatedHandler );
	}

	protected CFBamXMsgRspnServiceTypeReadSingleHandler getRspnServiceTypeReadSingleHandler() {
		if( rspnServiceTypeReadSingleHandler == null ) {
			rspnServiceTypeReadSingleHandler = new CFBamXMsgRspnServiceTypeReadSingleHandler( this );
			rspnServiceTypeReadSingleHandler.addElementHandler( "ServiceType", getRspnServiceTypeRecHandler() );
		}
		return( rspnServiceTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnServiceTypeReadListHandler getRspnServiceTypeReadListHandler() {
		if( rspnServiceTypeReadListHandler == null ) {
			rspnServiceTypeReadListHandler = new CFBamXMsgRspnServiceTypeReadListHandler( this );
			rspnServiceTypeReadListHandler.addElementHandler( "ServiceType", getRspnServiceTypeRecHandler() );
		}
		return( rspnServiceTypeReadListHandler );
	}

	protected CFBamXMsgRspnServiceTypeLockedHandler getRspnServiceTypeLockedHandler() {
		if( rspnServiceTypeLockedHandler == null ) {
			rspnServiceTypeLockedHandler = new CFBamXMsgRspnServiceTypeLockedHandler( this );
		}
		return( rspnServiceTypeLockedHandler );
	}

	protected CFBamXMsgRspnServiceTypeUpdatedHandler getRspnServiceTypeUpdatedHandler() {
		if( rspnServiceTypeUpdatedHandler == null ) {
			rspnServiceTypeUpdatedHandler = new CFBamXMsgRspnServiceTypeUpdatedHandler( this );
		}
		return( rspnServiceTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnServiceTypeDeletedHandler getRspnServiceTypeDeletedHandler() {
		if( rspnServiceTypeDeletedHandler == null ) {
			rspnServiceTypeDeletedHandler = new CFBamXMsgRspnServiceTypeDeletedHandler( this );
		}
		return( rspnServiceTypeDeletedHandler );
	}

	// StringCol Response Handlers

	protected CFBamXMsgRspnStringColRecHandler getRspnStringColRecHandler() {
		if( rspnStringColRecHandler == null ) {
			rspnStringColRecHandler = new CFBamXMsgRspnStringColRecHandler( this );
		}
		return( rspnStringColRecHandler );
	}

	protected CFBamXMsgRspnStringColCreatedHandler getRspnStringColCreatedHandler() {
		if( rspnStringColCreatedHandler == null ) {
			rspnStringColCreatedHandler = new CFBamXMsgRspnStringColCreatedHandler( this );
		}
		return( rspnStringColCreatedHandler );
	}

	protected CFBamXMsgRspnStringColReadSingleHandler getRspnStringColReadSingleHandler() {
		if( rspnStringColReadSingleHandler == null ) {
			rspnStringColReadSingleHandler = new CFBamXMsgRspnStringColReadSingleHandler( this );
			rspnStringColReadSingleHandler.addElementHandler( "StringCol", getRspnStringColRecHandler() );
		}
		return( rspnStringColReadSingleHandler );
	}

	protected CFBamXMsgRspnStringColReadListHandler getRspnStringColReadListHandler() {
		if( rspnStringColReadListHandler == null ) {
			rspnStringColReadListHandler = new CFBamXMsgRspnStringColReadListHandler( this );
			rspnStringColReadListHandler.addElementHandler( "StringCol", getRspnStringColRecHandler() );
		}
		return( rspnStringColReadListHandler );
	}

	protected CFBamXMsgRspnStringColLockedHandler getRspnStringColLockedHandler() {
		if( rspnStringColLockedHandler == null ) {
			rspnStringColLockedHandler = new CFBamXMsgRspnStringColLockedHandler( this );
		}
		return( rspnStringColLockedHandler );
	}

	protected CFBamXMsgRspnStringColUpdatedHandler getRspnStringColUpdatedHandler() {
		if( rspnStringColUpdatedHandler == null ) {
			rspnStringColUpdatedHandler = new CFBamXMsgRspnStringColUpdatedHandler( this );
		}
		return( rspnStringColUpdatedHandler );
	}

	protected CFBamXMsgRspnStringColDeletedHandler getRspnStringColDeletedHandler() {
		if( rspnStringColDeletedHandler == null ) {
			rspnStringColDeletedHandler = new CFBamXMsgRspnStringColDeletedHandler( this );
		}
		return( rspnStringColDeletedHandler );
	}

	// StringDef Response Handlers

	protected CFBamXMsgRspnStringDefRecHandler getRspnStringDefRecHandler() {
		if( rspnStringDefRecHandler == null ) {
			rspnStringDefRecHandler = new CFBamXMsgRspnStringDefRecHandler( this );
		}
		return( rspnStringDefRecHandler );
	}

	protected CFBamXMsgRspnStringDefCreatedHandler getRspnStringDefCreatedHandler() {
		if( rspnStringDefCreatedHandler == null ) {
			rspnStringDefCreatedHandler = new CFBamXMsgRspnStringDefCreatedHandler( this );
		}
		return( rspnStringDefCreatedHandler );
	}

	protected CFBamXMsgRspnStringDefReadSingleHandler getRspnStringDefReadSingleHandler() {
		if( rspnStringDefReadSingleHandler == null ) {
			rspnStringDefReadSingleHandler = new CFBamXMsgRspnStringDefReadSingleHandler( this );
			rspnStringDefReadSingleHandler.addElementHandler( "StringDef", getRspnStringDefRecHandler() );
			rspnStringDefReadSingleHandler.addElementHandler( "StringCol", getRspnStringColRecHandler() );
			rspnStringDefReadSingleHandler.addElementHandler( "StringType", getRspnStringTypeRecHandler() );
		}
		return( rspnStringDefReadSingleHandler );
	}

	protected CFBamXMsgRspnStringDefReadListHandler getRspnStringDefReadListHandler() {
		if( rspnStringDefReadListHandler == null ) {
			rspnStringDefReadListHandler = new CFBamXMsgRspnStringDefReadListHandler( this );
			rspnStringDefReadListHandler.addElementHandler( "StringDef", getRspnStringDefRecHandler() );
			rspnStringDefReadListHandler.addElementHandler( "StringCol", getRspnStringColRecHandler() );
			rspnStringDefReadListHandler.addElementHandler( "StringType", getRspnStringTypeRecHandler() );
		}
		return( rspnStringDefReadListHandler );
	}

	protected CFBamXMsgRspnStringDefLockedHandler getRspnStringDefLockedHandler() {
		if( rspnStringDefLockedHandler == null ) {
			rspnStringDefLockedHandler = new CFBamXMsgRspnStringDefLockedHandler( this );
		}
		return( rspnStringDefLockedHandler );
	}

	protected CFBamXMsgRspnStringDefUpdatedHandler getRspnStringDefUpdatedHandler() {
		if( rspnStringDefUpdatedHandler == null ) {
			rspnStringDefUpdatedHandler = new CFBamXMsgRspnStringDefUpdatedHandler( this );
		}
		return( rspnStringDefUpdatedHandler );
	}

	protected CFBamXMsgRspnStringDefDeletedHandler getRspnStringDefDeletedHandler() {
		if( rspnStringDefDeletedHandler == null ) {
			rspnStringDefDeletedHandler = new CFBamXMsgRspnStringDefDeletedHandler( this );
		}
		return( rspnStringDefDeletedHandler );
	}

	// StringType Response Handlers

	protected CFBamXMsgRspnStringTypeRecHandler getRspnStringTypeRecHandler() {
		if( rspnStringTypeRecHandler == null ) {
			rspnStringTypeRecHandler = new CFBamXMsgRspnStringTypeRecHandler( this );
		}
		return( rspnStringTypeRecHandler );
	}

	protected CFBamXMsgRspnStringTypeCreatedHandler getRspnStringTypeCreatedHandler() {
		if( rspnStringTypeCreatedHandler == null ) {
			rspnStringTypeCreatedHandler = new CFBamXMsgRspnStringTypeCreatedHandler( this );
		}
		return( rspnStringTypeCreatedHandler );
	}

	protected CFBamXMsgRspnStringTypeReadSingleHandler getRspnStringTypeReadSingleHandler() {
		if( rspnStringTypeReadSingleHandler == null ) {
			rspnStringTypeReadSingleHandler = new CFBamXMsgRspnStringTypeReadSingleHandler( this );
			rspnStringTypeReadSingleHandler.addElementHandler( "StringType", getRspnStringTypeRecHandler() );
		}
		return( rspnStringTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnStringTypeReadListHandler getRspnStringTypeReadListHandler() {
		if( rspnStringTypeReadListHandler == null ) {
			rspnStringTypeReadListHandler = new CFBamXMsgRspnStringTypeReadListHandler( this );
			rspnStringTypeReadListHandler.addElementHandler( "StringType", getRspnStringTypeRecHandler() );
		}
		return( rspnStringTypeReadListHandler );
	}

	protected CFBamXMsgRspnStringTypeLockedHandler getRspnStringTypeLockedHandler() {
		if( rspnStringTypeLockedHandler == null ) {
			rspnStringTypeLockedHandler = new CFBamXMsgRspnStringTypeLockedHandler( this );
		}
		return( rspnStringTypeLockedHandler );
	}

	protected CFBamXMsgRspnStringTypeUpdatedHandler getRspnStringTypeUpdatedHandler() {
		if( rspnStringTypeUpdatedHandler == null ) {
			rspnStringTypeUpdatedHandler = new CFBamXMsgRspnStringTypeUpdatedHandler( this );
		}
		return( rspnStringTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnStringTypeDeletedHandler getRspnStringTypeDeletedHandler() {
		if( rspnStringTypeDeletedHandler == null ) {
			rspnStringTypeDeletedHandler = new CFBamXMsgRspnStringTypeDeletedHandler( this );
		}
		return( rspnStringTypeDeletedHandler );
	}

	// SubProject Response Handlers

	protected CFBamXMsgRspnSubProjectRecHandler getRspnSubProjectRecHandler() {
		if( rspnSubProjectRecHandler == null ) {
			rspnSubProjectRecHandler = new CFBamXMsgRspnSubProjectRecHandler( this );
		}
		return( rspnSubProjectRecHandler );
	}

	protected CFBamXMsgRspnSubProjectCreatedHandler getRspnSubProjectCreatedHandler() {
		if( rspnSubProjectCreatedHandler == null ) {
			rspnSubProjectCreatedHandler = new CFBamXMsgRspnSubProjectCreatedHandler( this );
		}
		return( rspnSubProjectCreatedHandler );
	}

	protected CFBamXMsgRspnSubProjectReadSingleHandler getRspnSubProjectReadSingleHandler() {
		if( rspnSubProjectReadSingleHandler == null ) {
			rspnSubProjectReadSingleHandler = new CFBamXMsgRspnSubProjectReadSingleHandler( this );
			rspnSubProjectReadSingleHandler.addElementHandler( "SubProject", getRspnSubProjectRecHandler() );
		}
		return( rspnSubProjectReadSingleHandler );
	}

	protected CFBamXMsgRspnSubProjectReadListHandler getRspnSubProjectReadListHandler() {
		if( rspnSubProjectReadListHandler == null ) {
			rspnSubProjectReadListHandler = new CFBamXMsgRspnSubProjectReadListHandler( this );
			rspnSubProjectReadListHandler.addElementHandler( "SubProject", getRspnSubProjectRecHandler() );
		}
		return( rspnSubProjectReadListHandler );
	}

	protected CFBamXMsgRspnSubProjectLockedHandler getRspnSubProjectLockedHandler() {
		if( rspnSubProjectLockedHandler == null ) {
			rspnSubProjectLockedHandler = new CFBamXMsgRspnSubProjectLockedHandler( this );
		}
		return( rspnSubProjectLockedHandler );
	}

	protected CFBamXMsgRspnSubProjectUpdatedHandler getRspnSubProjectUpdatedHandler() {
		if( rspnSubProjectUpdatedHandler == null ) {
			rspnSubProjectUpdatedHandler = new CFBamXMsgRspnSubProjectUpdatedHandler( this );
		}
		return( rspnSubProjectUpdatedHandler );
	}

	protected CFBamXMsgRspnSubProjectDeletedHandler getRspnSubProjectDeletedHandler() {
		if( rspnSubProjectDeletedHandler == null ) {
			rspnSubProjectDeletedHandler = new CFBamXMsgRspnSubProjectDeletedHandler( this );
		}
		return( rspnSubProjectDeletedHandler );
	}

	// SysCluster Response Handlers

	protected CFBamXMsgRspnSysClusterRecHandler getRspnSysClusterRecHandler() {
		if( rspnSysClusterRecHandler == null ) {
			rspnSysClusterRecHandler = new CFBamXMsgRspnSysClusterRecHandler( this );
		}
		return( rspnSysClusterRecHandler );
	}

	protected CFBamXMsgRspnSysClusterCreatedHandler getRspnSysClusterCreatedHandler() {
		if( rspnSysClusterCreatedHandler == null ) {
			rspnSysClusterCreatedHandler = new CFBamXMsgRspnSysClusterCreatedHandler( this );
		}
		return( rspnSysClusterCreatedHandler );
	}

	protected CFBamXMsgRspnSysClusterReadSingleHandler getRspnSysClusterReadSingleHandler() {
		if( rspnSysClusterReadSingleHandler == null ) {
			rspnSysClusterReadSingleHandler = new CFBamXMsgRspnSysClusterReadSingleHandler( this );
			rspnSysClusterReadSingleHandler.addElementHandler( "SysCluster", getRspnSysClusterRecHandler() );
		}
		return( rspnSysClusterReadSingleHandler );
	}

	protected CFBamXMsgRspnSysClusterReadListHandler getRspnSysClusterReadListHandler() {
		if( rspnSysClusterReadListHandler == null ) {
			rspnSysClusterReadListHandler = new CFBamXMsgRspnSysClusterReadListHandler( this );
			rspnSysClusterReadListHandler.addElementHandler( "SysCluster", getRspnSysClusterRecHandler() );
		}
		return( rspnSysClusterReadListHandler );
	}

	protected CFBamXMsgRspnSysClusterLockedHandler getRspnSysClusterLockedHandler() {
		if( rspnSysClusterLockedHandler == null ) {
			rspnSysClusterLockedHandler = new CFBamXMsgRspnSysClusterLockedHandler( this );
		}
		return( rspnSysClusterLockedHandler );
	}

	protected CFBamXMsgRspnSysClusterUpdatedHandler getRspnSysClusterUpdatedHandler() {
		if( rspnSysClusterUpdatedHandler == null ) {
			rspnSysClusterUpdatedHandler = new CFBamXMsgRspnSysClusterUpdatedHandler( this );
		}
		return( rspnSysClusterUpdatedHandler );
	}

	protected CFBamXMsgRspnSysClusterDeletedHandler getRspnSysClusterDeletedHandler() {
		if( rspnSysClusterDeletedHandler == null ) {
			rspnSysClusterDeletedHandler = new CFBamXMsgRspnSysClusterDeletedHandler( this );
		}
		return( rspnSysClusterDeletedHandler );
	}

	// TSecGroup Response Handlers

	protected CFBamXMsgRspnTSecGroupRecHandler getRspnTSecGroupRecHandler() {
		if( rspnTSecGroupRecHandler == null ) {
			rspnTSecGroupRecHandler = new CFBamXMsgRspnTSecGroupRecHandler( this );
		}
		return( rspnTSecGroupRecHandler );
	}

	protected CFBamXMsgRspnTSecGroupCreatedHandler getRspnTSecGroupCreatedHandler() {
		if( rspnTSecGroupCreatedHandler == null ) {
			rspnTSecGroupCreatedHandler = new CFBamXMsgRspnTSecGroupCreatedHandler( this );
		}
		return( rspnTSecGroupCreatedHandler );
	}

	protected CFBamXMsgRspnTSecGroupReadSingleHandler getRspnTSecGroupReadSingleHandler() {
		if( rspnTSecGroupReadSingleHandler == null ) {
			rspnTSecGroupReadSingleHandler = new CFBamXMsgRspnTSecGroupReadSingleHandler( this );
			rspnTSecGroupReadSingleHandler.addElementHandler( "TSecGroup", getRspnTSecGroupRecHandler() );
		}
		return( rspnTSecGroupReadSingleHandler );
	}

	protected CFBamXMsgRspnTSecGroupReadListHandler getRspnTSecGroupReadListHandler() {
		if( rspnTSecGroupReadListHandler == null ) {
			rspnTSecGroupReadListHandler = new CFBamXMsgRspnTSecGroupReadListHandler( this );
			rspnTSecGroupReadListHandler.addElementHandler( "TSecGroup", getRspnTSecGroupRecHandler() );
		}
		return( rspnTSecGroupReadListHandler );
	}

	protected CFBamXMsgRspnTSecGroupLockedHandler getRspnTSecGroupLockedHandler() {
		if( rspnTSecGroupLockedHandler == null ) {
			rspnTSecGroupLockedHandler = new CFBamXMsgRspnTSecGroupLockedHandler( this );
		}
		return( rspnTSecGroupLockedHandler );
	}

	protected CFBamXMsgRspnTSecGroupUpdatedHandler getRspnTSecGroupUpdatedHandler() {
		if( rspnTSecGroupUpdatedHandler == null ) {
			rspnTSecGroupUpdatedHandler = new CFBamXMsgRspnTSecGroupUpdatedHandler( this );
		}
		return( rspnTSecGroupUpdatedHandler );
	}

	protected CFBamXMsgRspnTSecGroupDeletedHandler getRspnTSecGroupDeletedHandler() {
		if( rspnTSecGroupDeletedHandler == null ) {
			rspnTSecGroupDeletedHandler = new CFBamXMsgRspnTSecGroupDeletedHandler( this );
		}
		return( rspnTSecGroupDeletedHandler );
	}

	// TSecGroupInclude Response Handlers

	protected CFBamXMsgRspnTSecGroupIncludeRecHandler getRspnTSecGroupIncludeRecHandler() {
		if( rspnTSecGroupIncludeRecHandler == null ) {
			rspnTSecGroupIncludeRecHandler = new CFBamXMsgRspnTSecGroupIncludeRecHandler( this );
		}
		return( rspnTSecGroupIncludeRecHandler );
	}

	protected CFBamXMsgRspnTSecGroupIncludeCreatedHandler getRspnTSecGroupIncludeCreatedHandler() {
		if( rspnTSecGroupIncludeCreatedHandler == null ) {
			rspnTSecGroupIncludeCreatedHandler = new CFBamXMsgRspnTSecGroupIncludeCreatedHandler( this );
		}
		return( rspnTSecGroupIncludeCreatedHandler );
	}

	protected CFBamXMsgRspnTSecGroupIncludeReadSingleHandler getRspnTSecGroupIncludeReadSingleHandler() {
		if( rspnTSecGroupIncludeReadSingleHandler == null ) {
			rspnTSecGroupIncludeReadSingleHandler = new CFBamXMsgRspnTSecGroupIncludeReadSingleHandler( this );
			rspnTSecGroupIncludeReadSingleHandler.addElementHandler( "TSecGroupInclude", getRspnTSecGroupIncludeRecHandler() );
		}
		return( rspnTSecGroupIncludeReadSingleHandler );
	}

	protected CFBamXMsgRspnTSecGroupIncludeReadListHandler getRspnTSecGroupIncludeReadListHandler() {
		if( rspnTSecGroupIncludeReadListHandler == null ) {
			rspnTSecGroupIncludeReadListHandler = new CFBamXMsgRspnTSecGroupIncludeReadListHandler( this );
			rspnTSecGroupIncludeReadListHandler.addElementHandler( "TSecGroupInclude", getRspnTSecGroupIncludeRecHandler() );
		}
		return( rspnTSecGroupIncludeReadListHandler );
	}

	protected CFBamXMsgRspnTSecGroupIncludeLockedHandler getRspnTSecGroupIncludeLockedHandler() {
		if( rspnTSecGroupIncludeLockedHandler == null ) {
			rspnTSecGroupIncludeLockedHandler = new CFBamXMsgRspnTSecGroupIncludeLockedHandler( this );
		}
		return( rspnTSecGroupIncludeLockedHandler );
	}

	protected CFBamXMsgRspnTSecGroupIncludeUpdatedHandler getRspnTSecGroupIncludeUpdatedHandler() {
		if( rspnTSecGroupIncludeUpdatedHandler == null ) {
			rspnTSecGroupIncludeUpdatedHandler = new CFBamXMsgRspnTSecGroupIncludeUpdatedHandler( this );
		}
		return( rspnTSecGroupIncludeUpdatedHandler );
	}

	protected CFBamXMsgRspnTSecGroupIncludeDeletedHandler getRspnTSecGroupIncludeDeletedHandler() {
		if( rspnTSecGroupIncludeDeletedHandler == null ) {
			rspnTSecGroupIncludeDeletedHandler = new CFBamXMsgRspnTSecGroupIncludeDeletedHandler( this );
		}
		return( rspnTSecGroupIncludeDeletedHandler );
	}

	// TSecGroupMember Response Handlers

	protected CFBamXMsgRspnTSecGroupMemberRecHandler getRspnTSecGroupMemberRecHandler() {
		if( rspnTSecGroupMemberRecHandler == null ) {
			rspnTSecGroupMemberRecHandler = new CFBamXMsgRspnTSecGroupMemberRecHandler( this );
		}
		return( rspnTSecGroupMemberRecHandler );
	}

	protected CFBamXMsgRspnTSecGroupMemberCreatedHandler getRspnTSecGroupMemberCreatedHandler() {
		if( rspnTSecGroupMemberCreatedHandler == null ) {
			rspnTSecGroupMemberCreatedHandler = new CFBamXMsgRspnTSecGroupMemberCreatedHandler( this );
		}
		return( rspnTSecGroupMemberCreatedHandler );
	}

	protected CFBamXMsgRspnTSecGroupMemberReadSingleHandler getRspnTSecGroupMemberReadSingleHandler() {
		if( rspnTSecGroupMemberReadSingleHandler == null ) {
			rspnTSecGroupMemberReadSingleHandler = new CFBamXMsgRspnTSecGroupMemberReadSingleHandler( this );
			rspnTSecGroupMemberReadSingleHandler.addElementHandler( "TSecGroupMember", getRspnTSecGroupMemberRecHandler() );
		}
		return( rspnTSecGroupMemberReadSingleHandler );
	}

	protected CFBamXMsgRspnTSecGroupMemberReadListHandler getRspnTSecGroupMemberReadListHandler() {
		if( rspnTSecGroupMemberReadListHandler == null ) {
			rspnTSecGroupMemberReadListHandler = new CFBamXMsgRspnTSecGroupMemberReadListHandler( this );
			rspnTSecGroupMemberReadListHandler.addElementHandler( "TSecGroupMember", getRspnTSecGroupMemberRecHandler() );
		}
		return( rspnTSecGroupMemberReadListHandler );
	}

	protected CFBamXMsgRspnTSecGroupMemberLockedHandler getRspnTSecGroupMemberLockedHandler() {
		if( rspnTSecGroupMemberLockedHandler == null ) {
			rspnTSecGroupMemberLockedHandler = new CFBamXMsgRspnTSecGroupMemberLockedHandler( this );
		}
		return( rspnTSecGroupMemberLockedHandler );
	}

	protected CFBamXMsgRspnTSecGroupMemberUpdatedHandler getRspnTSecGroupMemberUpdatedHandler() {
		if( rspnTSecGroupMemberUpdatedHandler == null ) {
			rspnTSecGroupMemberUpdatedHandler = new CFBamXMsgRspnTSecGroupMemberUpdatedHandler( this );
		}
		return( rspnTSecGroupMemberUpdatedHandler );
	}

	protected CFBamXMsgRspnTSecGroupMemberDeletedHandler getRspnTSecGroupMemberDeletedHandler() {
		if( rspnTSecGroupMemberDeletedHandler == null ) {
			rspnTSecGroupMemberDeletedHandler = new CFBamXMsgRspnTSecGroupMemberDeletedHandler( this );
		}
		return( rspnTSecGroupMemberDeletedHandler );
	}

	// TZDateCol Response Handlers

	protected CFBamXMsgRspnTZDateColRecHandler getRspnTZDateColRecHandler() {
		if( rspnTZDateColRecHandler == null ) {
			rspnTZDateColRecHandler = new CFBamXMsgRspnTZDateColRecHandler( this );
		}
		return( rspnTZDateColRecHandler );
	}

	protected CFBamXMsgRspnTZDateColCreatedHandler getRspnTZDateColCreatedHandler() {
		if( rspnTZDateColCreatedHandler == null ) {
			rspnTZDateColCreatedHandler = new CFBamXMsgRspnTZDateColCreatedHandler( this );
		}
		return( rspnTZDateColCreatedHandler );
	}

	protected CFBamXMsgRspnTZDateColReadSingleHandler getRspnTZDateColReadSingleHandler() {
		if( rspnTZDateColReadSingleHandler == null ) {
			rspnTZDateColReadSingleHandler = new CFBamXMsgRspnTZDateColReadSingleHandler( this );
			rspnTZDateColReadSingleHandler.addElementHandler( "TZDateCol", getRspnTZDateColRecHandler() );
		}
		return( rspnTZDateColReadSingleHandler );
	}

	protected CFBamXMsgRspnTZDateColReadListHandler getRspnTZDateColReadListHandler() {
		if( rspnTZDateColReadListHandler == null ) {
			rspnTZDateColReadListHandler = new CFBamXMsgRspnTZDateColReadListHandler( this );
			rspnTZDateColReadListHandler.addElementHandler( "TZDateCol", getRspnTZDateColRecHandler() );
		}
		return( rspnTZDateColReadListHandler );
	}

	protected CFBamXMsgRspnTZDateColLockedHandler getRspnTZDateColLockedHandler() {
		if( rspnTZDateColLockedHandler == null ) {
			rspnTZDateColLockedHandler = new CFBamXMsgRspnTZDateColLockedHandler( this );
		}
		return( rspnTZDateColLockedHandler );
	}

	protected CFBamXMsgRspnTZDateColUpdatedHandler getRspnTZDateColUpdatedHandler() {
		if( rspnTZDateColUpdatedHandler == null ) {
			rspnTZDateColUpdatedHandler = new CFBamXMsgRspnTZDateColUpdatedHandler( this );
		}
		return( rspnTZDateColUpdatedHandler );
	}

	protected CFBamXMsgRspnTZDateColDeletedHandler getRspnTZDateColDeletedHandler() {
		if( rspnTZDateColDeletedHandler == null ) {
			rspnTZDateColDeletedHandler = new CFBamXMsgRspnTZDateColDeletedHandler( this );
		}
		return( rspnTZDateColDeletedHandler );
	}

	// TZDateDef Response Handlers

	protected CFBamXMsgRspnTZDateDefRecHandler getRspnTZDateDefRecHandler() {
		if( rspnTZDateDefRecHandler == null ) {
			rspnTZDateDefRecHandler = new CFBamXMsgRspnTZDateDefRecHandler( this );
		}
		return( rspnTZDateDefRecHandler );
	}

	protected CFBamXMsgRspnTZDateDefCreatedHandler getRspnTZDateDefCreatedHandler() {
		if( rspnTZDateDefCreatedHandler == null ) {
			rspnTZDateDefCreatedHandler = new CFBamXMsgRspnTZDateDefCreatedHandler( this );
		}
		return( rspnTZDateDefCreatedHandler );
	}

	protected CFBamXMsgRspnTZDateDefReadSingleHandler getRspnTZDateDefReadSingleHandler() {
		if( rspnTZDateDefReadSingleHandler == null ) {
			rspnTZDateDefReadSingleHandler = new CFBamXMsgRspnTZDateDefReadSingleHandler( this );
			rspnTZDateDefReadSingleHandler.addElementHandler( "TZDateDef", getRspnTZDateDefRecHandler() );
			rspnTZDateDefReadSingleHandler.addElementHandler( "TZDateCol", getRspnTZDateColRecHandler() );
			rspnTZDateDefReadSingleHandler.addElementHandler( "TZDateType", getRspnTZDateTypeRecHandler() );
		}
		return( rspnTZDateDefReadSingleHandler );
	}

	protected CFBamXMsgRspnTZDateDefReadListHandler getRspnTZDateDefReadListHandler() {
		if( rspnTZDateDefReadListHandler == null ) {
			rspnTZDateDefReadListHandler = new CFBamXMsgRspnTZDateDefReadListHandler( this );
			rspnTZDateDefReadListHandler.addElementHandler( "TZDateDef", getRspnTZDateDefRecHandler() );
			rspnTZDateDefReadListHandler.addElementHandler( "TZDateCol", getRspnTZDateColRecHandler() );
			rspnTZDateDefReadListHandler.addElementHandler( "TZDateType", getRspnTZDateTypeRecHandler() );
		}
		return( rspnTZDateDefReadListHandler );
	}

	protected CFBamXMsgRspnTZDateDefLockedHandler getRspnTZDateDefLockedHandler() {
		if( rspnTZDateDefLockedHandler == null ) {
			rspnTZDateDefLockedHandler = new CFBamXMsgRspnTZDateDefLockedHandler( this );
		}
		return( rspnTZDateDefLockedHandler );
	}

	protected CFBamXMsgRspnTZDateDefUpdatedHandler getRspnTZDateDefUpdatedHandler() {
		if( rspnTZDateDefUpdatedHandler == null ) {
			rspnTZDateDefUpdatedHandler = new CFBamXMsgRspnTZDateDefUpdatedHandler( this );
		}
		return( rspnTZDateDefUpdatedHandler );
	}

	protected CFBamXMsgRspnTZDateDefDeletedHandler getRspnTZDateDefDeletedHandler() {
		if( rspnTZDateDefDeletedHandler == null ) {
			rspnTZDateDefDeletedHandler = new CFBamXMsgRspnTZDateDefDeletedHandler( this );
		}
		return( rspnTZDateDefDeletedHandler );
	}

	// TZDateType Response Handlers

	protected CFBamXMsgRspnTZDateTypeRecHandler getRspnTZDateTypeRecHandler() {
		if( rspnTZDateTypeRecHandler == null ) {
			rspnTZDateTypeRecHandler = new CFBamXMsgRspnTZDateTypeRecHandler( this );
		}
		return( rspnTZDateTypeRecHandler );
	}

	protected CFBamXMsgRspnTZDateTypeCreatedHandler getRspnTZDateTypeCreatedHandler() {
		if( rspnTZDateTypeCreatedHandler == null ) {
			rspnTZDateTypeCreatedHandler = new CFBamXMsgRspnTZDateTypeCreatedHandler( this );
		}
		return( rspnTZDateTypeCreatedHandler );
	}

	protected CFBamXMsgRspnTZDateTypeReadSingleHandler getRspnTZDateTypeReadSingleHandler() {
		if( rspnTZDateTypeReadSingleHandler == null ) {
			rspnTZDateTypeReadSingleHandler = new CFBamXMsgRspnTZDateTypeReadSingleHandler( this );
			rspnTZDateTypeReadSingleHandler.addElementHandler( "TZDateType", getRspnTZDateTypeRecHandler() );
		}
		return( rspnTZDateTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnTZDateTypeReadListHandler getRspnTZDateTypeReadListHandler() {
		if( rspnTZDateTypeReadListHandler == null ) {
			rspnTZDateTypeReadListHandler = new CFBamXMsgRspnTZDateTypeReadListHandler( this );
			rspnTZDateTypeReadListHandler.addElementHandler( "TZDateType", getRspnTZDateTypeRecHandler() );
		}
		return( rspnTZDateTypeReadListHandler );
	}

	protected CFBamXMsgRspnTZDateTypeLockedHandler getRspnTZDateTypeLockedHandler() {
		if( rspnTZDateTypeLockedHandler == null ) {
			rspnTZDateTypeLockedHandler = new CFBamXMsgRspnTZDateTypeLockedHandler( this );
		}
		return( rspnTZDateTypeLockedHandler );
	}

	protected CFBamXMsgRspnTZDateTypeUpdatedHandler getRspnTZDateTypeUpdatedHandler() {
		if( rspnTZDateTypeUpdatedHandler == null ) {
			rspnTZDateTypeUpdatedHandler = new CFBamXMsgRspnTZDateTypeUpdatedHandler( this );
		}
		return( rspnTZDateTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnTZDateTypeDeletedHandler getRspnTZDateTypeDeletedHandler() {
		if( rspnTZDateTypeDeletedHandler == null ) {
			rspnTZDateTypeDeletedHandler = new CFBamXMsgRspnTZDateTypeDeletedHandler( this );
		}
		return( rspnTZDateTypeDeletedHandler );
	}

	// TZTimeCol Response Handlers

	protected CFBamXMsgRspnTZTimeColRecHandler getRspnTZTimeColRecHandler() {
		if( rspnTZTimeColRecHandler == null ) {
			rspnTZTimeColRecHandler = new CFBamXMsgRspnTZTimeColRecHandler( this );
		}
		return( rspnTZTimeColRecHandler );
	}

	protected CFBamXMsgRspnTZTimeColCreatedHandler getRspnTZTimeColCreatedHandler() {
		if( rspnTZTimeColCreatedHandler == null ) {
			rspnTZTimeColCreatedHandler = new CFBamXMsgRspnTZTimeColCreatedHandler( this );
		}
		return( rspnTZTimeColCreatedHandler );
	}

	protected CFBamXMsgRspnTZTimeColReadSingleHandler getRspnTZTimeColReadSingleHandler() {
		if( rspnTZTimeColReadSingleHandler == null ) {
			rspnTZTimeColReadSingleHandler = new CFBamXMsgRspnTZTimeColReadSingleHandler( this );
			rspnTZTimeColReadSingleHandler.addElementHandler( "TZTimeCol", getRspnTZTimeColRecHandler() );
		}
		return( rspnTZTimeColReadSingleHandler );
	}

	protected CFBamXMsgRspnTZTimeColReadListHandler getRspnTZTimeColReadListHandler() {
		if( rspnTZTimeColReadListHandler == null ) {
			rspnTZTimeColReadListHandler = new CFBamXMsgRspnTZTimeColReadListHandler( this );
			rspnTZTimeColReadListHandler.addElementHandler( "TZTimeCol", getRspnTZTimeColRecHandler() );
		}
		return( rspnTZTimeColReadListHandler );
	}

	protected CFBamXMsgRspnTZTimeColLockedHandler getRspnTZTimeColLockedHandler() {
		if( rspnTZTimeColLockedHandler == null ) {
			rspnTZTimeColLockedHandler = new CFBamXMsgRspnTZTimeColLockedHandler( this );
		}
		return( rspnTZTimeColLockedHandler );
	}

	protected CFBamXMsgRspnTZTimeColUpdatedHandler getRspnTZTimeColUpdatedHandler() {
		if( rspnTZTimeColUpdatedHandler == null ) {
			rspnTZTimeColUpdatedHandler = new CFBamXMsgRspnTZTimeColUpdatedHandler( this );
		}
		return( rspnTZTimeColUpdatedHandler );
	}

	protected CFBamXMsgRspnTZTimeColDeletedHandler getRspnTZTimeColDeletedHandler() {
		if( rspnTZTimeColDeletedHandler == null ) {
			rspnTZTimeColDeletedHandler = new CFBamXMsgRspnTZTimeColDeletedHandler( this );
		}
		return( rspnTZTimeColDeletedHandler );
	}

	// TZTimeDef Response Handlers

	protected CFBamXMsgRspnTZTimeDefRecHandler getRspnTZTimeDefRecHandler() {
		if( rspnTZTimeDefRecHandler == null ) {
			rspnTZTimeDefRecHandler = new CFBamXMsgRspnTZTimeDefRecHandler( this );
		}
		return( rspnTZTimeDefRecHandler );
	}

	protected CFBamXMsgRspnTZTimeDefCreatedHandler getRspnTZTimeDefCreatedHandler() {
		if( rspnTZTimeDefCreatedHandler == null ) {
			rspnTZTimeDefCreatedHandler = new CFBamXMsgRspnTZTimeDefCreatedHandler( this );
		}
		return( rspnTZTimeDefCreatedHandler );
	}

	protected CFBamXMsgRspnTZTimeDefReadSingleHandler getRspnTZTimeDefReadSingleHandler() {
		if( rspnTZTimeDefReadSingleHandler == null ) {
			rspnTZTimeDefReadSingleHandler = new CFBamXMsgRspnTZTimeDefReadSingleHandler( this );
			rspnTZTimeDefReadSingleHandler.addElementHandler( "TZTimeDef", getRspnTZTimeDefRecHandler() );
			rspnTZTimeDefReadSingleHandler.addElementHandler( "TZTimeCol", getRspnTZTimeColRecHandler() );
			rspnTZTimeDefReadSingleHandler.addElementHandler( "TZTimeType", getRspnTZTimeTypeRecHandler() );
		}
		return( rspnTZTimeDefReadSingleHandler );
	}

	protected CFBamXMsgRspnTZTimeDefReadListHandler getRspnTZTimeDefReadListHandler() {
		if( rspnTZTimeDefReadListHandler == null ) {
			rspnTZTimeDefReadListHandler = new CFBamXMsgRspnTZTimeDefReadListHandler( this );
			rspnTZTimeDefReadListHandler.addElementHandler( "TZTimeDef", getRspnTZTimeDefRecHandler() );
			rspnTZTimeDefReadListHandler.addElementHandler( "TZTimeCol", getRspnTZTimeColRecHandler() );
			rspnTZTimeDefReadListHandler.addElementHandler( "TZTimeType", getRspnTZTimeTypeRecHandler() );
		}
		return( rspnTZTimeDefReadListHandler );
	}

	protected CFBamXMsgRspnTZTimeDefLockedHandler getRspnTZTimeDefLockedHandler() {
		if( rspnTZTimeDefLockedHandler == null ) {
			rspnTZTimeDefLockedHandler = new CFBamXMsgRspnTZTimeDefLockedHandler( this );
		}
		return( rspnTZTimeDefLockedHandler );
	}

	protected CFBamXMsgRspnTZTimeDefUpdatedHandler getRspnTZTimeDefUpdatedHandler() {
		if( rspnTZTimeDefUpdatedHandler == null ) {
			rspnTZTimeDefUpdatedHandler = new CFBamXMsgRspnTZTimeDefUpdatedHandler( this );
		}
		return( rspnTZTimeDefUpdatedHandler );
	}

	protected CFBamXMsgRspnTZTimeDefDeletedHandler getRspnTZTimeDefDeletedHandler() {
		if( rspnTZTimeDefDeletedHandler == null ) {
			rspnTZTimeDefDeletedHandler = new CFBamXMsgRspnTZTimeDefDeletedHandler( this );
		}
		return( rspnTZTimeDefDeletedHandler );
	}

	// TZTimeType Response Handlers

	protected CFBamXMsgRspnTZTimeTypeRecHandler getRspnTZTimeTypeRecHandler() {
		if( rspnTZTimeTypeRecHandler == null ) {
			rspnTZTimeTypeRecHandler = new CFBamXMsgRspnTZTimeTypeRecHandler( this );
		}
		return( rspnTZTimeTypeRecHandler );
	}

	protected CFBamXMsgRspnTZTimeTypeCreatedHandler getRspnTZTimeTypeCreatedHandler() {
		if( rspnTZTimeTypeCreatedHandler == null ) {
			rspnTZTimeTypeCreatedHandler = new CFBamXMsgRspnTZTimeTypeCreatedHandler( this );
		}
		return( rspnTZTimeTypeCreatedHandler );
	}

	protected CFBamXMsgRspnTZTimeTypeReadSingleHandler getRspnTZTimeTypeReadSingleHandler() {
		if( rspnTZTimeTypeReadSingleHandler == null ) {
			rspnTZTimeTypeReadSingleHandler = new CFBamXMsgRspnTZTimeTypeReadSingleHandler( this );
			rspnTZTimeTypeReadSingleHandler.addElementHandler( "TZTimeType", getRspnTZTimeTypeRecHandler() );
		}
		return( rspnTZTimeTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnTZTimeTypeReadListHandler getRspnTZTimeTypeReadListHandler() {
		if( rspnTZTimeTypeReadListHandler == null ) {
			rspnTZTimeTypeReadListHandler = new CFBamXMsgRspnTZTimeTypeReadListHandler( this );
			rspnTZTimeTypeReadListHandler.addElementHandler( "TZTimeType", getRspnTZTimeTypeRecHandler() );
		}
		return( rspnTZTimeTypeReadListHandler );
	}

	protected CFBamXMsgRspnTZTimeTypeLockedHandler getRspnTZTimeTypeLockedHandler() {
		if( rspnTZTimeTypeLockedHandler == null ) {
			rspnTZTimeTypeLockedHandler = new CFBamXMsgRspnTZTimeTypeLockedHandler( this );
		}
		return( rspnTZTimeTypeLockedHandler );
	}

	protected CFBamXMsgRspnTZTimeTypeUpdatedHandler getRspnTZTimeTypeUpdatedHandler() {
		if( rspnTZTimeTypeUpdatedHandler == null ) {
			rspnTZTimeTypeUpdatedHandler = new CFBamXMsgRspnTZTimeTypeUpdatedHandler( this );
		}
		return( rspnTZTimeTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnTZTimeTypeDeletedHandler getRspnTZTimeTypeDeletedHandler() {
		if( rspnTZTimeTypeDeletedHandler == null ) {
			rspnTZTimeTypeDeletedHandler = new CFBamXMsgRspnTZTimeTypeDeletedHandler( this );
		}
		return( rspnTZTimeTypeDeletedHandler );
	}

	// TZTimestampCol Response Handlers

	protected CFBamXMsgRspnTZTimestampColRecHandler getRspnTZTimestampColRecHandler() {
		if( rspnTZTimestampColRecHandler == null ) {
			rspnTZTimestampColRecHandler = new CFBamXMsgRspnTZTimestampColRecHandler( this );
		}
		return( rspnTZTimestampColRecHandler );
	}

	protected CFBamXMsgRspnTZTimestampColCreatedHandler getRspnTZTimestampColCreatedHandler() {
		if( rspnTZTimestampColCreatedHandler == null ) {
			rspnTZTimestampColCreatedHandler = new CFBamXMsgRspnTZTimestampColCreatedHandler( this );
		}
		return( rspnTZTimestampColCreatedHandler );
	}

	protected CFBamXMsgRspnTZTimestampColReadSingleHandler getRspnTZTimestampColReadSingleHandler() {
		if( rspnTZTimestampColReadSingleHandler == null ) {
			rspnTZTimestampColReadSingleHandler = new CFBamXMsgRspnTZTimestampColReadSingleHandler( this );
			rspnTZTimestampColReadSingleHandler.addElementHandler( "TZTimestampCol", getRspnTZTimestampColRecHandler() );
		}
		return( rspnTZTimestampColReadSingleHandler );
	}

	protected CFBamXMsgRspnTZTimestampColReadListHandler getRspnTZTimestampColReadListHandler() {
		if( rspnTZTimestampColReadListHandler == null ) {
			rspnTZTimestampColReadListHandler = new CFBamXMsgRspnTZTimestampColReadListHandler( this );
			rspnTZTimestampColReadListHandler.addElementHandler( "TZTimestampCol", getRspnTZTimestampColRecHandler() );
		}
		return( rspnTZTimestampColReadListHandler );
	}

	protected CFBamXMsgRspnTZTimestampColLockedHandler getRspnTZTimestampColLockedHandler() {
		if( rspnTZTimestampColLockedHandler == null ) {
			rspnTZTimestampColLockedHandler = new CFBamXMsgRspnTZTimestampColLockedHandler( this );
		}
		return( rspnTZTimestampColLockedHandler );
	}

	protected CFBamXMsgRspnTZTimestampColUpdatedHandler getRspnTZTimestampColUpdatedHandler() {
		if( rspnTZTimestampColUpdatedHandler == null ) {
			rspnTZTimestampColUpdatedHandler = new CFBamXMsgRspnTZTimestampColUpdatedHandler( this );
		}
		return( rspnTZTimestampColUpdatedHandler );
	}

	protected CFBamXMsgRspnTZTimestampColDeletedHandler getRspnTZTimestampColDeletedHandler() {
		if( rspnTZTimestampColDeletedHandler == null ) {
			rspnTZTimestampColDeletedHandler = new CFBamXMsgRspnTZTimestampColDeletedHandler( this );
		}
		return( rspnTZTimestampColDeletedHandler );
	}

	// TZTimestampDef Response Handlers

	protected CFBamXMsgRspnTZTimestampDefRecHandler getRspnTZTimestampDefRecHandler() {
		if( rspnTZTimestampDefRecHandler == null ) {
			rspnTZTimestampDefRecHandler = new CFBamXMsgRspnTZTimestampDefRecHandler( this );
		}
		return( rspnTZTimestampDefRecHandler );
	}

	protected CFBamXMsgRspnTZTimestampDefCreatedHandler getRspnTZTimestampDefCreatedHandler() {
		if( rspnTZTimestampDefCreatedHandler == null ) {
			rspnTZTimestampDefCreatedHandler = new CFBamXMsgRspnTZTimestampDefCreatedHandler( this );
		}
		return( rspnTZTimestampDefCreatedHandler );
	}

	protected CFBamXMsgRspnTZTimestampDefReadSingleHandler getRspnTZTimestampDefReadSingleHandler() {
		if( rspnTZTimestampDefReadSingleHandler == null ) {
			rspnTZTimestampDefReadSingleHandler = new CFBamXMsgRspnTZTimestampDefReadSingleHandler( this );
			rspnTZTimestampDefReadSingleHandler.addElementHandler( "TZTimestampDef", getRspnTZTimestampDefRecHandler() );
			rspnTZTimestampDefReadSingleHandler.addElementHandler( "TZTimestampCol", getRspnTZTimestampColRecHandler() );
			rspnTZTimestampDefReadSingleHandler.addElementHandler( "TZTimestampType", getRspnTZTimestampTypeRecHandler() );
		}
		return( rspnTZTimestampDefReadSingleHandler );
	}

	protected CFBamXMsgRspnTZTimestampDefReadListHandler getRspnTZTimestampDefReadListHandler() {
		if( rspnTZTimestampDefReadListHandler == null ) {
			rspnTZTimestampDefReadListHandler = new CFBamXMsgRspnTZTimestampDefReadListHandler( this );
			rspnTZTimestampDefReadListHandler.addElementHandler( "TZTimestampDef", getRspnTZTimestampDefRecHandler() );
			rspnTZTimestampDefReadListHandler.addElementHandler( "TZTimestampCol", getRspnTZTimestampColRecHandler() );
			rspnTZTimestampDefReadListHandler.addElementHandler( "TZTimestampType", getRspnTZTimestampTypeRecHandler() );
		}
		return( rspnTZTimestampDefReadListHandler );
	}

	protected CFBamXMsgRspnTZTimestampDefLockedHandler getRspnTZTimestampDefLockedHandler() {
		if( rspnTZTimestampDefLockedHandler == null ) {
			rspnTZTimestampDefLockedHandler = new CFBamXMsgRspnTZTimestampDefLockedHandler( this );
		}
		return( rspnTZTimestampDefLockedHandler );
	}

	protected CFBamXMsgRspnTZTimestampDefUpdatedHandler getRspnTZTimestampDefUpdatedHandler() {
		if( rspnTZTimestampDefUpdatedHandler == null ) {
			rspnTZTimestampDefUpdatedHandler = new CFBamXMsgRspnTZTimestampDefUpdatedHandler( this );
		}
		return( rspnTZTimestampDefUpdatedHandler );
	}

	protected CFBamXMsgRspnTZTimestampDefDeletedHandler getRspnTZTimestampDefDeletedHandler() {
		if( rspnTZTimestampDefDeletedHandler == null ) {
			rspnTZTimestampDefDeletedHandler = new CFBamXMsgRspnTZTimestampDefDeletedHandler( this );
		}
		return( rspnTZTimestampDefDeletedHandler );
	}

	// TZTimestampType Response Handlers

	protected CFBamXMsgRspnTZTimestampTypeRecHandler getRspnTZTimestampTypeRecHandler() {
		if( rspnTZTimestampTypeRecHandler == null ) {
			rspnTZTimestampTypeRecHandler = new CFBamXMsgRspnTZTimestampTypeRecHandler( this );
		}
		return( rspnTZTimestampTypeRecHandler );
	}

	protected CFBamXMsgRspnTZTimestampTypeCreatedHandler getRspnTZTimestampTypeCreatedHandler() {
		if( rspnTZTimestampTypeCreatedHandler == null ) {
			rspnTZTimestampTypeCreatedHandler = new CFBamXMsgRspnTZTimestampTypeCreatedHandler( this );
		}
		return( rspnTZTimestampTypeCreatedHandler );
	}

	protected CFBamXMsgRspnTZTimestampTypeReadSingleHandler getRspnTZTimestampTypeReadSingleHandler() {
		if( rspnTZTimestampTypeReadSingleHandler == null ) {
			rspnTZTimestampTypeReadSingleHandler = new CFBamXMsgRspnTZTimestampTypeReadSingleHandler( this );
			rspnTZTimestampTypeReadSingleHandler.addElementHandler( "TZTimestampType", getRspnTZTimestampTypeRecHandler() );
		}
		return( rspnTZTimestampTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnTZTimestampTypeReadListHandler getRspnTZTimestampTypeReadListHandler() {
		if( rspnTZTimestampTypeReadListHandler == null ) {
			rspnTZTimestampTypeReadListHandler = new CFBamXMsgRspnTZTimestampTypeReadListHandler( this );
			rspnTZTimestampTypeReadListHandler.addElementHandler( "TZTimestampType", getRspnTZTimestampTypeRecHandler() );
		}
		return( rspnTZTimestampTypeReadListHandler );
	}

	protected CFBamXMsgRspnTZTimestampTypeLockedHandler getRspnTZTimestampTypeLockedHandler() {
		if( rspnTZTimestampTypeLockedHandler == null ) {
			rspnTZTimestampTypeLockedHandler = new CFBamXMsgRspnTZTimestampTypeLockedHandler( this );
		}
		return( rspnTZTimestampTypeLockedHandler );
	}

	protected CFBamXMsgRspnTZTimestampTypeUpdatedHandler getRspnTZTimestampTypeUpdatedHandler() {
		if( rspnTZTimestampTypeUpdatedHandler == null ) {
			rspnTZTimestampTypeUpdatedHandler = new CFBamXMsgRspnTZTimestampTypeUpdatedHandler( this );
		}
		return( rspnTZTimestampTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnTZTimestampTypeDeletedHandler getRspnTZTimestampTypeDeletedHandler() {
		if( rspnTZTimestampTypeDeletedHandler == null ) {
			rspnTZTimestampTypeDeletedHandler = new CFBamXMsgRspnTZTimestampTypeDeletedHandler( this );
		}
		return( rspnTZTimestampTypeDeletedHandler );
	}

	// Table Response Handlers

	protected CFBamXMsgRspnTableRecHandler getRspnTableRecHandler() {
		if( rspnTableRecHandler == null ) {
			rspnTableRecHandler = new CFBamXMsgRspnTableRecHandler( this );
		}
		return( rspnTableRecHandler );
	}

	protected CFBamXMsgRspnTableCreatedHandler getRspnTableCreatedHandler() {
		if( rspnTableCreatedHandler == null ) {
			rspnTableCreatedHandler = new CFBamXMsgRspnTableCreatedHandler( this );
		}
		return( rspnTableCreatedHandler );
	}

	protected CFBamXMsgRspnTableReadSingleHandler getRspnTableReadSingleHandler() {
		if( rspnTableReadSingleHandler == null ) {
			rspnTableReadSingleHandler = new CFBamXMsgRspnTableReadSingleHandler( this );
			rspnTableReadSingleHandler.addElementHandler( "Table", getRspnTableRecHandler() );
		}
		return( rspnTableReadSingleHandler );
	}

	protected CFBamXMsgRspnTableReadListHandler getRspnTableReadListHandler() {
		if( rspnTableReadListHandler == null ) {
			rspnTableReadListHandler = new CFBamXMsgRspnTableReadListHandler( this );
			rspnTableReadListHandler.addElementHandler( "Table", getRspnTableRecHandler() );
		}
		return( rspnTableReadListHandler );
	}

	protected CFBamXMsgRspnTableLockedHandler getRspnTableLockedHandler() {
		if( rspnTableLockedHandler == null ) {
			rspnTableLockedHandler = new CFBamXMsgRspnTableLockedHandler( this );
		}
		return( rspnTableLockedHandler );
	}

	protected CFBamXMsgRspnTableUpdatedHandler getRspnTableUpdatedHandler() {
		if( rspnTableUpdatedHandler == null ) {
			rspnTableUpdatedHandler = new CFBamXMsgRspnTableUpdatedHandler( this );
		}
		return( rspnTableUpdatedHandler );
	}

	protected CFBamXMsgRspnTableDeletedHandler getRspnTableDeletedHandler() {
		if( rspnTableDeletedHandler == null ) {
			rspnTableDeletedHandler = new CFBamXMsgRspnTableDeletedHandler( this );
		}
		return( rspnTableDeletedHandler );
	}

	// TableCol Response Handlers

	protected CFBamXMsgRspnTableColRecHandler getRspnTableColRecHandler() {
		if( rspnTableColRecHandler == null ) {
			rspnTableColRecHandler = new CFBamXMsgRspnTableColRecHandler( this );
		}
		return( rspnTableColRecHandler );
	}

	protected CFBamXMsgRspnTableColCreatedHandler getRspnTableColCreatedHandler() {
		if( rspnTableColCreatedHandler == null ) {
			rspnTableColCreatedHandler = new CFBamXMsgRspnTableColCreatedHandler( this );
		}
		return( rspnTableColCreatedHandler );
	}

	protected CFBamXMsgRspnTableColReadSingleHandler getRspnTableColReadSingleHandler() {
		if( rspnTableColReadSingleHandler == null ) {
			rspnTableColReadSingleHandler = new CFBamXMsgRspnTableColReadSingleHandler( this );
			rspnTableColReadSingleHandler.addElementHandler( "TableCol", getRspnTableColRecHandler() );
		}
		return( rspnTableColReadSingleHandler );
	}

	protected CFBamXMsgRspnTableColReadListHandler getRspnTableColReadListHandler() {
		if( rspnTableColReadListHandler == null ) {
			rspnTableColReadListHandler = new CFBamXMsgRspnTableColReadListHandler( this );
			rspnTableColReadListHandler.addElementHandler( "TableCol", getRspnTableColRecHandler() );
		}
		return( rspnTableColReadListHandler );
	}

	protected CFBamXMsgRspnTableColLockedHandler getRspnTableColLockedHandler() {
		if( rspnTableColLockedHandler == null ) {
			rspnTableColLockedHandler = new CFBamXMsgRspnTableColLockedHandler( this );
		}
		return( rspnTableColLockedHandler );
	}

	protected CFBamXMsgRspnTableColUpdatedHandler getRspnTableColUpdatedHandler() {
		if( rspnTableColUpdatedHandler == null ) {
			rspnTableColUpdatedHandler = new CFBamXMsgRspnTableColUpdatedHandler( this );
		}
		return( rspnTableColUpdatedHandler );
	}

	protected CFBamXMsgRspnTableColDeletedHandler getRspnTableColDeletedHandler() {
		if( rspnTableColDeletedHandler == null ) {
			rspnTableColDeletedHandler = new CFBamXMsgRspnTableColDeletedHandler( this );
		}
		return( rspnTableColDeletedHandler );
	}

	// Tenant Response Handlers

	protected CFBamXMsgRspnTenantRecHandler getRspnTenantRecHandler() {
		if( rspnTenantRecHandler == null ) {
			rspnTenantRecHandler = new CFBamXMsgRspnTenantRecHandler( this );
		}
		return( rspnTenantRecHandler );
	}

	protected CFBamXMsgRspnTenantCreatedHandler getRspnTenantCreatedHandler() {
		if( rspnTenantCreatedHandler == null ) {
			rspnTenantCreatedHandler = new CFBamXMsgRspnTenantCreatedHandler( this );
		}
		return( rspnTenantCreatedHandler );
	}

	protected CFBamXMsgRspnTenantReadSingleHandler getRspnTenantReadSingleHandler() {
		if( rspnTenantReadSingleHandler == null ) {
			rspnTenantReadSingleHandler = new CFBamXMsgRspnTenantReadSingleHandler( this );
			rspnTenantReadSingleHandler.addElementHandler( "Tenant", getRspnTenantRecHandler() );
		}
		return( rspnTenantReadSingleHandler );
	}

	protected CFBamXMsgRspnTenantReadListHandler getRspnTenantReadListHandler() {
		if( rspnTenantReadListHandler == null ) {
			rspnTenantReadListHandler = new CFBamXMsgRspnTenantReadListHandler( this );
			rspnTenantReadListHandler.addElementHandler( "Tenant", getRspnTenantRecHandler() );
		}
		return( rspnTenantReadListHandler );
	}

	protected CFBamXMsgRspnTenantLockedHandler getRspnTenantLockedHandler() {
		if( rspnTenantLockedHandler == null ) {
			rspnTenantLockedHandler = new CFBamXMsgRspnTenantLockedHandler( this );
		}
		return( rspnTenantLockedHandler );
	}

	protected CFBamXMsgRspnTenantUpdatedHandler getRspnTenantUpdatedHandler() {
		if( rspnTenantUpdatedHandler == null ) {
			rspnTenantUpdatedHandler = new CFBamXMsgRspnTenantUpdatedHandler( this );
		}
		return( rspnTenantUpdatedHandler );
	}

	protected CFBamXMsgRspnTenantDeletedHandler getRspnTenantDeletedHandler() {
		if( rspnTenantDeletedHandler == null ) {
			rspnTenantDeletedHandler = new CFBamXMsgRspnTenantDeletedHandler( this );
		}
		return( rspnTenantDeletedHandler );
	}

	// TextCol Response Handlers

	protected CFBamXMsgRspnTextColRecHandler getRspnTextColRecHandler() {
		if( rspnTextColRecHandler == null ) {
			rspnTextColRecHandler = new CFBamXMsgRspnTextColRecHandler( this );
		}
		return( rspnTextColRecHandler );
	}

	protected CFBamXMsgRspnTextColCreatedHandler getRspnTextColCreatedHandler() {
		if( rspnTextColCreatedHandler == null ) {
			rspnTextColCreatedHandler = new CFBamXMsgRspnTextColCreatedHandler( this );
		}
		return( rspnTextColCreatedHandler );
	}

	protected CFBamXMsgRspnTextColReadSingleHandler getRspnTextColReadSingleHandler() {
		if( rspnTextColReadSingleHandler == null ) {
			rspnTextColReadSingleHandler = new CFBamXMsgRspnTextColReadSingleHandler( this );
			rspnTextColReadSingleHandler.addElementHandler( "TextCol", getRspnTextColRecHandler() );
		}
		return( rspnTextColReadSingleHandler );
	}

	protected CFBamXMsgRspnTextColReadListHandler getRspnTextColReadListHandler() {
		if( rspnTextColReadListHandler == null ) {
			rspnTextColReadListHandler = new CFBamXMsgRspnTextColReadListHandler( this );
			rspnTextColReadListHandler.addElementHandler( "TextCol", getRspnTextColRecHandler() );
		}
		return( rspnTextColReadListHandler );
	}

	protected CFBamXMsgRspnTextColLockedHandler getRspnTextColLockedHandler() {
		if( rspnTextColLockedHandler == null ) {
			rspnTextColLockedHandler = new CFBamXMsgRspnTextColLockedHandler( this );
		}
		return( rspnTextColLockedHandler );
	}

	protected CFBamXMsgRspnTextColUpdatedHandler getRspnTextColUpdatedHandler() {
		if( rspnTextColUpdatedHandler == null ) {
			rspnTextColUpdatedHandler = new CFBamXMsgRspnTextColUpdatedHandler( this );
		}
		return( rspnTextColUpdatedHandler );
	}

	protected CFBamXMsgRspnTextColDeletedHandler getRspnTextColDeletedHandler() {
		if( rspnTextColDeletedHandler == null ) {
			rspnTextColDeletedHandler = new CFBamXMsgRspnTextColDeletedHandler( this );
		}
		return( rspnTextColDeletedHandler );
	}

	// TextDef Response Handlers

	protected CFBamXMsgRspnTextDefRecHandler getRspnTextDefRecHandler() {
		if( rspnTextDefRecHandler == null ) {
			rspnTextDefRecHandler = new CFBamXMsgRspnTextDefRecHandler( this );
		}
		return( rspnTextDefRecHandler );
	}

	protected CFBamXMsgRspnTextDefCreatedHandler getRspnTextDefCreatedHandler() {
		if( rspnTextDefCreatedHandler == null ) {
			rspnTextDefCreatedHandler = new CFBamXMsgRspnTextDefCreatedHandler( this );
		}
		return( rspnTextDefCreatedHandler );
	}

	protected CFBamXMsgRspnTextDefReadSingleHandler getRspnTextDefReadSingleHandler() {
		if( rspnTextDefReadSingleHandler == null ) {
			rspnTextDefReadSingleHandler = new CFBamXMsgRspnTextDefReadSingleHandler( this );
			rspnTextDefReadSingleHandler.addElementHandler( "TextDef", getRspnTextDefRecHandler() );
			rspnTextDefReadSingleHandler.addElementHandler( "TextCol", getRspnTextColRecHandler() );
			rspnTextDefReadSingleHandler.addElementHandler( "TextType", getRspnTextTypeRecHandler() );
		}
		return( rspnTextDefReadSingleHandler );
	}

	protected CFBamXMsgRspnTextDefReadListHandler getRspnTextDefReadListHandler() {
		if( rspnTextDefReadListHandler == null ) {
			rspnTextDefReadListHandler = new CFBamXMsgRspnTextDefReadListHandler( this );
			rspnTextDefReadListHandler.addElementHandler( "TextDef", getRspnTextDefRecHandler() );
			rspnTextDefReadListHandler.addElementHandler( "TextCol", getRspnTextColRecHandler() );
			rspnTextDefReadListHandler.addElementHandler( "TextType", getRspnTextTypeRecHandler() );
		}
		return( rspnTextDefReadListHandler );
	}

	protected CFBamXMsgRspnTextDefLockedHandler getRspnTextDefLockedHandler() {
		if( rspnTextDefLockedHandler == null ) {
			rspnTextDefLockedHandler = new CFBamXMsgRspnTextDefLockedHandler( this );
		}
		return( rspnTextDefLockedHandler );
	}

	protected CFBamXMsgRspnTextDefUpdatedHandler getRspnTextDefUpdatedHandler() {
		if( rspnTextDefUpdatedHandler == null ) {
			rspnTextDefUpdatedHandler = new CFBamXMsgRspnTextDefUpdatedHandler( this );
		}
		return( rspnTextDefUpdatedHandler );
	}

	protected CFBamXMsgRspnTextDefDeletedHandler getRspnTextDefDeletedHandler() {
		if( rspnTextDefDeletedHandler == null ) {
			rspnTextDefDeletedHandler = new CFBamXMsgRspnTextDefDeletedHandler( this );
		}
		return( rspnTextDefDeletedHandler );
	}

	// TextType Response Handlers

	protected CFBamXMsgRspnTextTypeRecHandler getRspnTextTypeRecHandler() {
		if( rspnTextTypeRecHandler == null ) {
			rspnTextTypeRecHandler = new CFBamXMsgRspnTextTypeRecHandler( this );
		}
		return( rspnTextTypeRecHandler );
	}

	protected CFBamXMsgRspnTextTypeCreatedHandler getRspnTextTypeCreatedHandler() {
		if( rspnTextTypeCreatedHandler == null ) {
			rspnTextTypeCreatedHandler = new CFBamXMsgRspnTextTypeCreatedHandler( this );
		}
		return( rspnTextTypeCreatedHandler );
	}

	protected CFBamXMsgRspnTextTypeReadSingleHandler getRspnTextTypeReadSingleHandler() {
		if( rspnTextTypeReadSingleHandler == null ) {
			rspnTextTypeReadSingleHandler = new CFBamXMsgRspnTextTypeReadSingleHandler( this );
			rspnTextTypeReadSingleHandler.addElementHandler( "TextType", getRspnTextTypeRecHandler() );
		}
		return( rspnTextTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnTextTypeReadListHandler getRspnTextTypeReadListHandler() {
		if( rspnTextTypeReadListHandler == null ) {
			rspnTextTypeReadListHandler = new CFBamXMsgRspnTextTypeReadListHandler( this );
			rspnTextTypeReadListHandler.addElementHandler( "TextType", getRspnTextTypeRecHandler() );
		}
		return( rspnTextTypeReadListHandler );
	}

	protected CFBamXMsgRspnTextTypeLockedHandler getRspnTextTypeLockedHandler() {
		if( rspnTextTypeLockedHandler == null ) {
			rspnTextTypeLockedHandler = new CFBamXMsgRspnTextTypeLockedHandler( this );
		}
		return( rspnTextTypeLockedHandler );
	}

	protected CFBamXMsgRspnTextTypeUpdatedHandler getRspnTextTypeUpdatedHandler() {
		if( rspnTextTypeUpdatedHandler == null ) {
			rspnTextTypeUpdatedHandler = new CFBamXMsgRspnTextTypeUpdatedHandler( this );
		}
		return( rspnTextTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnTextTypeDeletedHandler getRspnTextTypeDeletedHandler() {
		if( rspnTextTypeDeletedHandler == null ) {
			rspnTextTypeDeletedHandler = new CFBamXMsgRspnTextTypeDeletedHandler( this );
		}
		return( rspnTextTypeDeletedHandler );
	}

	// TimeCol Response Handlers

	protected CFBamXMsgRspnTimeColRecHandler getRspnTimeColRecHandler() {
		if( rspnTimeColRecHandler == null ) {
			rspnTimeColRecHandler = new CFBamXMsgRspnTimeColRecHandler( this );
		}
		return( rspnTimeColRecHandler );
	}

	protected CFBamXMsgRspnTimeColCreatedHandler getRspnTimeColCreatedHandler() {
		if( rspnTimeColCreatedHandler == null ) {
			rspnTimeColCreatedHandler = new CFBamXMsgRspnTimeColCreatedHandler( this );
		}
		return( rspnTimeColCreatedHandler );
	}

	protected CFBamXMsgRspnTimeColReadSingleHandler getRspnTimeColReadSingleHandler() {
		if( rspnTimeColReadSingleHandler == null ) {
			rspnTimeColReadSingleHandler = new CFBamXMsgRspnTimeColReadSingleHandler( this );
			rspnTimeColReadSingleHandler.addElementHandler( "TimeCol", getRspnTimeColRecHandler() );
		}
		return( rspnTimeColReadSingleHandler );
	}

	protected CFBamXMsgRspnTimeColReadListHandler getRspnTimeColReadListHandler() {
		if( rspnTimeColReadListHandler == null ) {
			rspnTimeColReadListHandler = new CFBamXMsgRspnTimeColReadListHandler( this );
			rspnTimeColReadListHandler.addElementHandler( "TimeCol", getRspnTimeColRecHandler() );
		}
		return( rspnTimeColReadListHandler );
	}

	protected CFBamXMsgRspnTimeColLockedHandler getRspnTimeColLockedHandler() {
		if( rspnTimeColLockedHandler == null ) {
			rspnTimeColLockedHandler = new CFBamXMsgRspnTimeColLockedHandler( this );
		}
		return( rspnTimeColLockedHandler );
	}

	protected CFBamXMsgRspnTimeColUpdatedHandler getRspnTimeColUpdatedHandler() {
		if( rspnTimeColUpdatedHandler == null ) {
			rspnTimeColUpdatedHandler = new CFBamXMsgRspnTimeColUpdatedHandler( this );
		}
		return( rspnTimeColUpdatedHandler );
	}

	protected CFBamXMsgRspnTimeColDeletedHandler getRspnTimeColDeletedHandler() {
		if( rspnTimeColDeletedHandler == null ) {
			rspnTimeColDeletedHandler = new CFBamXMsgRspnTimeColDeletedHandler( this );
		}
		return( rspnTimeColDeletedHandler );
	}

	// TimeDef Response Handlers

	protected CFBamXMsgRspnTimeDefRecHandler getRspnTimeDefRecHandler() {
		if( rspnTimeDefRecHandler == null ) {
			rspnTimeDefRecHandler = new CFBamXMsgRspnTimeDefRecHandler( this );
		}
		return( rspnTimeDefRecHandler );
	}

	protected CFBamXMsgRspnTimeDefCreatedHandler getRspnTimeDefCreatedHandler() {
		if( rspnTimeDefCreatedHandler == null ) {
			rspnTimeDefCreatedHandler = new CFBamXMsgRspnTimeDefCreatedHandler( this );
		}
		return( rspnTimeDefCreatedHandler );
	}

	protected CFBamXMsgRspnTimeDefReadSingleHandler getRspnTimeDefReadSingleHandler() {
		if( rspnTimeDefReadSingleHandler == null ) {
			rspnTimeDefReadSingleHandler = new CFBamXMsgRspnTimeDefReadSingleHandler( this );
			rspnTimeDefReadSingleHandler.addElementHandler( "TimeDef", getRspnTimeDefRecHandler() );
			rspnTimeDefReadSingleHandler.addElementHandler( "TimeCol", getRspnTimeColRecHandler() );
			rspnTimeDefReadSingleHandler.addElementHandler( "TimeType", getRspnTimeTypeRecHandler() );
		}
		return( rspnTimeDefReadSingleHandler );
	}

	protected CFBamXMsgRspnTimeDefReadListHandler getRspnTimeDefReadListHandler() {
		if( rspnTimeDefReadListHandler == null ) {
			rspnTimeDefReadListHandler = new CFBamXMsgRspnTimeDefReadListHandler( this );
			rspnTimeDefReadListHandler.addElementHandler( "TimeDef", getRspnTimeDefRecHandler() );
			rspnTimeDefReadListHandler.addElementHandler( "TimeCol", getRspnTimeColRecHandler() );
			rspnTimeDefReadListHandler.addElementHandler( "TimeType", getRspnTimeTypeRecHandler() );
		}
		return( rspnTimeDefReadListHandler );
	}

	protected CFBamXMsgRspnTimeDefLockedHandler getRspnTimeDefLockedHandler() {
		if( rspnTimeDefLockedHandler == null ) {
			rspnTimeDefLockedHandler = new CFBamXMsgRspnTimeDefLockedHandler( this );
		}
		return( rspnTimeDefLockedHandler );
	}

	protected CFBamXMsgRspnTimeDefUpdatedHandler getRspnTimeDefUpdatedHandler() {
		if( rspnTimeDefUpdatedHandler == null ) {
			rspnTimeDefUpdatedHandler = new CFBamXMsgRspnTimeDefUpdatedHandler( this );
		}
		return( rspnTimeDefUpdatedHandler );
	}

	protected CFBamXMsgRspnTimeDefDeletedHandler getRspnTimeDefDeletedHandler() {
		if( rspnTimeDefDeletedHandler == null ) {
			rspnTimeDefDeletedHandler = new CFBamXMsgRspnTimeDefDeletedHandler( this );
		}
		return( rspnTimeDefDeletedHandler );
	}

	// TimeType Response Handlers

	protected CFBamXMsgRspnTimeTypeRecHandler getRspnTimeTypeRecHandler() {
		if( rspnTimeTypeRecHandler == null ) {
			rspnTimeTypeRecHandler = new CFBamXMsgRspnTimeTypeRecHandler( this );
		}
		return( rspnTimeTypeRecHandler );
	}

	protected CFBamXMsgRspnTimeTypeCreatedHandler getRspnTimeTypeCreatedHandler() {
		if( rspnTimeTypeCreatedHandler == null ) {
			rspnTimeTypeCreatedHandler = new CFBamXMsgRspnTimeTypeCreatedHandler( this );
		}
		return( rspnTimeTypeCreatedHandler );
	}

	protected CFBamXMsgRspnTimeTypeReadSingleHandler getRspnTimeTypeReadSingleHandler() {
		if( rspnTimeTypeReadSingleHandler == null ) {
			rspnTimeTypeReadSingleHandler = new CFBamXMsgRspnTimeTypeReadSingleHandler( this );
			rspnTimeTypeReadSingleHandler.addElementHandler( "TimeType", getRspnTimeTypeRecHandler() );
		}
		return( rspnTimeTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnTimeTypeReadListHandler getRspnTimeTypeReadListHandler() {
		if( rspnTimeTypeReadListHandler == null ) {
			rspnTimeTypeReadListHandler = new CFBamXMsgRspnTimeTypeReadListHandler( this );
			rspnTimeTypeReadListHandler.addElementHandler( "TimeType", getRspnTimeTypeRecHandler() );
		}
		return( rspnTimeTypeReadListHandler );
	}

	protected CFBamXMsgRspnTimeTypeLockedHandler getRspnTimeTypeLockedHandler() {
		if( rspnTimeTypeLockedHandler == null ) {
			rspnTimeTypeLockedHandler = new CFBamXMsgRspnTimeTypeLockedHandler( this );
		}
		return( rspnTimeTypeLockedHandler );
	}

	protected CFBamXMsgRspnTimeTypeUpdatedHandler getRspnTimeTypeUpdatedHandler() {
		if( rspnTimeTypeUpdatedHandler == null ) {
			rspnTimeTypeUpdatedHandler = new CFBamXMsgRspnTimeTypeUpdatedHandler( this );
		}
		return( rspnTimeTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnTimeTypeDeletedHandler getRspnTimeTypeDeletedHandler() {
		if( rspnTimeTypeDeletedHandler == null ) {
			rspnTimeTypeDeletedHandler = new CFBamXMsgRspnTimeTypeDeletedHandler( this );
		}
		return( rspnTimeTypeDeletedHandler );
	}

	// TimestampCol Response Handlers

	protected CFBamXMsgRspnTimestampColRecHandler getRspnTimestampColRecHandler() {
		if( rspnTimestampColRecHandler == null ) {
			rspnTimestampColRecHandler = new CFBamXMsgRspnTimestampColRecHandler( this );
		}
		return( rspnTimestampColRecHandler );
	}

	protected CFBamXMsgRspnTimestampColCreatedHandler getRspnTimestampColCreatedHandler() {
		if( rspnTimestampColCreatedHandler == null ) {
			rspnTimestampColCreatedHandler = new CFBamXMsgRspnTimestampColCreatedHandler( this );
		}
		return( rspnTimestampColCreatedHandler );
	}

	protected CFBamXMsgRspnTimestampColReadSingleHandler getRspnTimestampColReadSingleHandler() {
		if( rspnTimestampColReadSingleHandler == null ) {
			rspnTimestampColReadSingleHandler = new CFBamXMsgRspnTimestampColReadSingleHandler( this );
			rspnTimestampColReadSingleHandler.addElementHandler( "TimestampCol", getRspnTimestampColRecHandler() );
		}
		return( rspnTimestampColReadSingleHandler );
	}

	protected CFBamXMsgRspnTimestampColReadListHandler getRspnTimestampColReadListHandler() {
		if( rspnTimestampColReadListHandler == null ) {
			rspnTimestampColReadListHandler = new CFBamXMsgRspnTimestampColReadListHandler( this );
			rspnTimestampColReadListHandler.addElementHandler( "TimestampCol", getRspnTimestampColRecHandler() );
		}
		return( rspnTimestampColReadListHandler );
	}

	protected CFBamXMsgRspnTimestampColLockedHandler getRspnTimestampColLockedHandler() {
		if( rspnTimestampColLockedHandler == null ) {
			rspnTimestampColLockedHandler = new CFBamXMsgRspnTimestampColLockedHandler( this );
		}
		return( rspnTimestampColLockedHandler );
	}

	protected CFBamXMsgRspnTimestampColUpdatedHandler getRspnTimestampColUpdatedHandler() {
		if( rspnTimestampColUpdatedHandler == null ) {
			rspnTimestampColUpdatedHandler = new CFBamXMsgRspnTimestampColUpdatedHandler( this );
		}
		return( rspnTimestampColUpdatedHandler );
	}

	protected CFBamXMsgRspnTimestampColDeletedHandler getRspnTimestampColDeletedHandler() {
		if( rspnTimestampColDeletedHandler == null ) {
			rspnTimestampColDeletedHandler = new CFBamXMsgRspnTimestampColDeletedHandler( this );
		}
		return( rspnTimestampColDeletedHandler );
	}

	// TimestampDef Response Handlers

	protected CFBamXMsgRspnTimestampDefRecHandler getRspnTimestampDefRecHandler() {
		if( rspnTimestampDefRecHandler == null ) {
			rspnTimestampDefRecHandler = new CFBamXMsgRspnTimestampDefRecHandler( this );
		}
		return( rspnTimestampDefRecHandler );
	}

	protected CFBamXMsgRspnTimestampDefCreatedHandler getRspnTimestampDefCreatedHandler() {
		if( rspnTimestampDefCreatedHandler == null ) {
			rspnTimestampDefCreatedHandler = new CFBamXMsgRspnTimestampDefCreatedHandler( this );
		}
		return( rspnTimestampDefCreatedHandler );
	}

	protected CFBamXMsgRspnTimestampDefReadSingleHandler getRspnTimestampDefReadSingleHandler() {
		if( rspnTimestampDefReadSingleHandler == null ) {
			rspnTimestampDefReadSingleHandler = new CFBamXMsgRspnTimestampDefReadSingleHandler( this );
			rspnTimestampDefReadSingleHandler.addElementHandler( "TimestampDef", getRspnTimestampDefRecHandler() );
			rspnTimestampDefReadSingleHandler.addElementHandler( "TimestampCol", getRspnTimestampColRecHandler() );
			rspnTimestampDefReadSingleHandler.addElementHandler( "TimestampType", getRspnTimestampTypeRecHandler() );
		}
		return( rspnTimestampDefReadSingleHandler );
	}

	protected CFBamXMsgRspnTimestampDefReadListHandler getRspnTimestampDefReadListHandler() {
		if( rspnTimestampDefReadListHandler == null ) {
			rspnTimestampDefReadListHandler = new CFBamXMsgRspnTimestampDefReadListHandler( this );
			rspnTimestampDefReadListHandler.addElementHandler( "TimestampDef", getRspnTimestampDefRecHandler() );
			rspnTimestampDefReadListHandler.addElementHandler( "TimestampCol", getRspnTimestampColRecHandler() );
			rspnTimestampDefReadListHandler.addElementHandler( "TimestampType", getRspnTimestampTypeRecHandler() );
		}
		return( rspnTimestampDefReadListHandler );
	}

	protected CFBamXMsgRspnTimestampDefLockedHandler getRspnTimestampDefLockedHandler() {
		if( rspnTimestampDefLockedHandler == null ) {
			rspnTimestampDefLockedHandler = new CFBamXMsgRspnTimestampDefLockedHandler( this );
		}
		return( rspnTimestampDefLockedHandler );
	}

	protected CFBamXMsgRspnTimestampDefUpdatedHandler getRspnTimestampDefUpdatedHandler() {
		if( rspnTimestampDefUpdatedHandler == null ) {
			rspnTimestampDefUpdatedHandler = new CFBamXMsgRspnTimestampDefUpdatedHandler( this );
		}
		return( rspnTimestampDefUpdatedHandler );
	}

	protected CFBamXMsgRspnTimestampDefDeletedHandler getRspnTimestampDefDeletedHandler() {
		if( rspnTimestampDefDeletedHandler == null ) {
			rspnTimestampDefDeletedHandler = new CFBamXMsgRspnTimestampDefDeletedHandler( this );
		}
		return( rspnTimestampDefDeletedHandler );
	}

	// TimestampType Response Handlers

	protected CFBamXMsgRspnTimestampTypeRecHandler getRspnTimestampTypeRecHandler() {
		if( rspnTimestampTypeRecHandler == null ) {
			rspnTimestampTypeRecHandler = new CFBamXMsgRspnTimestampTypeRecHandler( this );
		}
		return( rspnTimestampTypeRecHandler );
	}

	protected CFBamXMsgRspnTimestampTypeCreatedHandler getRspnTimestampTypeCreatedHandler() {
		if( rspnTimestampTypeCreatedHandler == null ) {
			rspnTimestampTypeCreatedHandler = new CFBamXMsgRspnTimestampTypeCreatedHandler( this );
		}
		return( rspnTimestampTypeCreatedHandler );
	}

	protected CFBamXMsgRspnTimestampTypeReadSingleHandler getRspnTimestampTypeReadSingleHandler() {
		if( rspnTimestampTypeReadSingleHandler == null ) {
			rspnTimestampTypeReadSingleHandler = new CFBamXMsgRspnTimestampTypeReadSingleHandler( this );
			rspnTimestampTypeReadSingleHandler.addElementHandler( "TimestampType", getRspnTimestampTypeRecHandler() );
		}
		return( rspnTimestampTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnTimestampTypeReadListHandler getRspnTimestampTypeReadListHandler() {
		if( rspnTimestampTypeReadListHandler == null ) {
			rspnTimestampTypeReadListHandler = new CFBamXMsgRspnTimestampTypeReadListHandler( this );
			rspnTimestampTypeReadListHandler.addElementHandler( "TimestampType", getRspnTimestampTypeRecHandler() );
		}
		return( rspnTimestampTypeReadListHandler );
	}

	protected CFBamXMsgRspnTimestampTypeLockedHandler getRspnTimestampTypeLockedHandler() {
		if( rspnTimestampTypeLockedHandler == null ) {
			rspnTimestampTypeLockedHandler = new CFBamXMsgRspnTimestampTypeLockedHandler( this );
		}
		return( rspnTimestampTypeLockedHandler );
	}

	protected CFBamXMsgRspnTimestampTypeUpdatedHandler getRspnTimestampTypeUpdatedHandler() {
		if( rspnTimestampTypeUpdatedHandler == null ) {
			rspnTimestampTypeUpdatedHandler = new CFBamXMsgRspnTimestampTypeUpdatedHandler( this );
		}
		return( rspnTimestampTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnTimestampTypeDeletedHandler getRspnTimestampTypeDeletedHandler() {
		if( rspnTimestampTypeDeletedHandler == null ) {
			rspnTimestampTypeDeletedHandler = new CFBamXMsgRspnTimestampTypeDeletedHandler( this );
		}
		return( rspnTimestampTypeDeletedHandler );
	}

	// Tld Response Handlers

	protected CFBamXMsgRspnTldRecHandler getRspnTldRecHandler() {
		if( rspnTldRecHandler == null ) {
			rspnTldRecHandler = new CFBamXMsgRspnTldRecHandler( this );
		}
		return( rspnTldRecHandler );
	}

	protected CFBamXMsgRspnTldCreatedHandler getRspnTldCreatedHandler() {
		if( rspnTldCreatedHandler == null ) {
			rspnTldCreatedHandler = new CFBamXMsgRspnTldCreatedHandler( this );
		}
		return( rspnTldCreatedHandler );
	}

	protected CFBamXMsgRspnTldReadSingleHandler getRspnTldReadSingleHandler() {
		if( rspnTldReadSingleHandler == null ) {
			rspnTldReadSingleHandler = new CFBamXMsgRspnTldReadSingleHandler( this );
			rspnTldReadSingleHandler.addElementHandler( "Tld", getRspnTldRecHandler() );
		}
		return( rspnTldReadSingleHandler );
	}

	protected CFBamXMsgRspnTldReadListHandler getRspnTldReadListHandler() {
		if( rspnTldReadListHandler == null ) {
			rspnTldReadListHandler = new CFBamXMsgRspnTldReadListHandler( this );
			rspnTldReadListHandler.addElementHandler( "Tld", getRspnTldRecHandler() );
		}
		return( rspnTldReadListHandler );
	}

	protected CFBamXMsgRspnTldLockedHandler getRspnTldLockedHandler() {
		if( rspnTldLockedHandler == null ) {
			rspnTldLockedHandler = new CFBamXMsgRspnTldLockedHandler( this );
		}
		return( rspnTldLockedHandler );
	}

	protected CFBamXMsgRspnTldUpdatedHandler getRspnTldUpdatedHandler() {
		if( rspnTldUpdatedHandler == null ) {
			rspnTldUpdatedHandler = new CFBamXMsgRspnTldUpdatedHandler( this );
		}
		return( rspnTldUpdatedHandler );
	}

	protected CFBamXMsgRspnTldDeletedHandler getRspnTldDeletedHandler() {
		if( rspnTldDeletedHandler == null ) {
			rspnTldDeletedHandler = new CFBamXMsgRspnTldDeletedHandler( this );
		}
		return( rspnTldDeletedHandler );
	}

	// TokenCol Response Handlers

	protected CFBamXMsgRspnTokenColRecHandler getRspnTokenColRecHandler() {
		if( rspnTokenColRecHandler == null ) {
			rspnTokenColRecHandler = new CFBamXMsgRspnTokenColRecHandler( this );
		}
		return( rspnTokenColRecHandler );
	}

	protected CFBamXMsgRspnTokenColCreatedHandler getRspnTokenColCreatedHandler() {
		if( rspnTokenColCreatedHandler == null ) {
			rspnTokenColCreatedHandler = new CFBamXMsgRspnTokenColCreatedHandler( this );
		}
		return( rspnTokenColCreatedHandler );
	}

	protected CFBamXMsgRspnTokenColReadSingleHandler getRspnTokenColReadSingleHandler() {
		if( rspnTokenColReadSingleHandler == null ) {
			rspnTokenColReadSingleHandler = new CFBamXMsgRspnTokenColReadSingleHandler( this );
			rspnTokenColReadSingleHandler.addElementHandler( "TokenCol", getRspnTokenColRecHandler() );
		}
		return( rspnTokenColReadSingleHandler );
	}

	protected CFBamXMsgRspnTokenColReadListHandler getRspnTokenColReadListHandler() {
		if( rspnTokenColReadListHandler == null ) {
			rspnTokenColReadListHandler = new CFBamXMsgRspnTokenColReadListHandler( this );
			rspnTokenColReadListHandler.addElementHandler( "TokenCol", getRspnTokenColRecHandler() );
		}
		return( rspnTokenColReadListHandler );
	}

	protected CFBamXMsgRspnTokenColLockedHandler getRspnTokenColLockedHandler() {
		if( rspnTokenColLockedHandler == null ) {
			rspnTokenColLockedHandler = new CFBamXMsgRspnTokenColLockedHandler( this );
		}
		return( rspnTokenColLockedHandler );
	}

	protected CFBamXMsgRspnTokenColUpdatedHandler getRspnTokenColUpdatedHandler() {
		if( rspnTokenColUpdatedHandler == null ) {
			rspnTokenColUpdatedHandler = new CFBamXMsgRspnTokenColUpdatedHandler( this );
		}
		return( rspnTokenColUpdatedHandler );
	}

	protected CFBamXMsgRspnTokenColDeletedHandler getRspnTokenColDeletedHandler() {
		if( rspnTokenColDeletedHandler == null ) {
			rspnTokenColDeletedHandler = new CFBamXMsgRspnTokenColDeletedHandler( this );
		}
		return( rspnTokenColDeletedHandler );
	}

	// TokenDef Response Handlers

	protected CFBamXMsgRspnTokenDefRecHandler getRspnTokenDefRecHandler() {
		if( rspnTokenDefRecHandler == null ) {
			rspnTokenDefRecHandler = new CFBamXMsgRspnTokenDefRecHandler( this );
		}
		return( rspnTokenDefRecHandler );
	}

	protected CFBamXMsgRspnTokenDefCreatedHandler getRspnTokenDefCreatedHandler() {
		if( rspnTokenDefCreatedHandler == null ) {
			rspnTokenDefCreatedHandler = new CFBamXMsgRspnTokenDefCreatedHandler( this );
		}
		return( rspnTokenDefCreatedHandler );
	}

	protected CFBamXMsgRspnTokenDefReadSingleHandler getRspnTokenDefReadSingleHandler() {
		if( rspnTokenDefReadSingleHandler == null ) {
			rspnTokenDefReadSingleHandler = new CFBamXMsgRspnTokenDefReadSingleHandler( this );
			rspnTokenDefReadSingleHandler.addElementHandler( "TokenDef", getRspnTokenDefRecHandler() );
			rspnTokenDefReadSingleHandler.addElementHandler( "TokenCol", getRspnTokenColRecHandler() );
			rspnTokenDefReadSingleHandler.addElementHandler( "TokenType", getRspnTokenTypeRecHandler() );
		}
		return( rspnTokenDefReadSingleHandler );
	}

	protected CFBamXMsgRspnTokenDefReadListHandler getRspnTokenDefReadListHandler() {
		if( rspnTokenDefReadListHandler == null ) {
			rspnTokenDefReadListHandler = new CFBamXMsgRspnTokenDefReadListHandler( this );
			rspnTokenDefReadListHandler.addElementHandler( "TokenDef", getRspnTokenDefRecHandler() );
			rspnTokenDefReadListHandler.addElementHandler( "TokenCol", getRspnTokenColRecHandler() );
			rspnTokenDefReadListHandler.addElementHandler( "TokenType", getRspnTokenTypeRecHandler() );
		}
		return( rspnTokenDefReadListHandler );
	}

	protected CFBamXMsgRspnTokenDefLockedHandler getRspnTokenDefLockedHandler() {
		if( rspnTokenDefLockedHandler == null ) {
			rspnTokenDefLockedHandler = new CFBamXMsgRspnTokenDefLockedHandler( this );
		}
		return( rspnTokenDefLockedHandler );
	}

	protected CFBamXMsgRspnTokenDefUpdatedHandler getRspnTokenDefUpdatedHandler() {
		if( rspnTokenDefUpdatedHandler == null ) {
			rspnTokenDefUpdatedHandler = new CFBamXMsgRspnTokenDefUpdatedHandler( this );
		}
		return( rspnTokenDefUpdatedHandler );
	}

	protected CFBamXMsgRspnTokenDefDeletedHandler getRspnTokenDefDeletedHandler() {
		if( rspnTokenDefDeletedHandler == null ) {
			rspnTokenDefDeletedHandler = new CFBamXMsgRspnTokenDefDeletedHandler( this );
		}
		return( rspnTokenDefDeletedHandler );
	}

	// TokenType Response Handlers

	protected CFBamXMsgRspnTokenTypeRecHandler getRspnTokenTypeRecHandler() {
		if( rspnTokenTypeRecHandler == null ) {
			rspnTokenTypeRecHandler = new CFBamXMsgRspnTokenTypeRecHandler( this );
		}
		return( rspnTokenTypeRecHandler );
	}

	protected CFBamXMsgRspnTokenTypeCreatedHandler getRspnTokenTypeCreatedHandler() {
		if( rspnTokenTypeCreatedHandler == null ) {
			rspnTokenTypeCreatedHandler = new CFBamXMsgRspnTokenTypeCreatedHandler( this );
		}
		return( rspnTokenTypeCreatedHandler );
	}

	protected CFBamXMsgRspnTokenTypeReadSingleHandler getRspnTokenTypeReadSingleHandler() {
		if( rspnTokenTypeReadSingleHandler == null ) {
			rspnTokenTypeReadSingleHandler = new CFBamXMsgRspnTokenTypeReadSingleHandler( this );
			rspnTokenTypeReadSingleHandler.addElementHandler( "TokenType", getRspnTokenTypeRecHandler() );
		}
		return( rspnTokenTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnTokenTypeReadListHandler getRspnTokenTypeReadListHandler() {
		if( rspnTokenTypeReadListHandler == null ) {
			rspnTokenTypeReadListHandler = new CFBamXMsgRspnTokenTypeReadListHandler( this );
			rspnTokenTypeReadListHandler.addElementHandler( "TokenType", getRspnTokenTypeRecHandler() );
		}
		return( rspnTokenTypeReadListHandler );
	}

	protected CFBamXMsgRspnTokenTypeLockedHandler getRspnTokenTypeLockedHandler() {
		if( rspnTokenTypeLockedHandler == null ) {
			rspnTokenTypeLockedHandler = new CFBamXMsgRspnTokenTypeLockedHandler( this );
		}
		return( rspnTokenTypeLockedHandler );
	}

	protected CFBamXMsgRspnTokenTypeUpdatedHandler getRspnTokenTypeUpdatedHandler() {
		if( rspnTokenTypeUpdatedHandler == null ) {
			rspnTokenTypeUpdatedHandler = new CFBamXMsgRspnTokenTypeUpdatedHandler( this );
		}
		return( rspnTokenTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnTokenTypeDeletedHandler getRspnTokenTypeDeletedHandler() {
		if( rspnTokenTypeDeletedHandler == null ) {
			rspnTokenTypeDeletedHandler = new CFBamXMsgRspnTokenTypeDeletedHandler( this );
		}
		return( rspnTokenTypeDeletedHandler );
	}

	// TopDomain Response Handlers

	protected CFBamXMsgRspnTopDomainRecHandler getRspnTopDomainRecHandler() {
		if( rspnTopDomainRecHandler == null ) {
			rspnTopDomainRecHandler = new CFBamXMsgRspnTopDomainRecHandler( this );
		}
		return( rspnTopDomainRecHandler );
	}

	protected CFBamXMsgRspnTopDomainCreatedHandler getRspnTopDomainCreatedHandler() {
		if( rspnTopDomainCreatedHandler == null ) {
			rspnTopDomainCreatedHandler = new CFBamXMsgRspnTopDomainCreatedHandler( this );
		}
		return( rspnTopDomainCreatedHandler );
	}

	protected CFBamXMsgRspnTopDomainReadSingleHandler getRspnTopDomainReadSingleHandler() {
		if( rspnTopDomainReadSingleHandler == null ) {
			rspnTopDomainReadSingleHandler = new CFBamXMsgRspnTopDomainReadSingleHandler( this );
			rspnTopDomainReadSingleHandler.addElementHandler( "TopDomain", getRspnTopDomainRecHandler() );
		}
		return( rspnTopDomainReadSingleHandler );
	}

	protected CFBamXMsgRspnTopDomainReadListHandler getRspnTopDomainReadListHandler() {
		if( rspnTopDomainReadListHandler == null ) {
			rspnTopDomainReadListHandler = new CFBamXMsgRspnTopDomainReadListHandler( this );
			rspnTopDomainReadListHandler.addElementHandler( "TopDomain", getRspnTopDomainRecHandler() );
		}
		return( rspnTopDomainReadListHandler );
	}

	protected CFBamXMsgRspnTopDomainLockedHandler getRspnTopDomainLockedHandler() {
		if( rspnTopDomainLockedHandler == null ) {
			rspnTopDomainLockedHandler = new CFBamXMsgRspnTopDomainLockedHandler( this );
		}
		return( rspnTopDomainLockedHandler );
	}

	protected CFBamXMsgRspnTopDomainUpdatedHandler getRspnTopDomainUpdatedHandler() {
		if( rspnTopDomainUpdatedHandler == null ) {
			rspnTopDomainUpdatedHandler = new CFBamXMsgRspnTopDomainUpdatedHandler( this );
		}
		return( rspnTopDomainUpdatedHandler );
	}

	protected CFBamXMsgRspnTopDomainDeletedHandler getRspnTopDomainDeletedHandler() {
		if( rspnTopDomainDeletedHandler == null ) {
			rspnTopDomainDeletedHandler = new CFBamXMsgRspnTopDomainDeletedHandler( this );
		}
		return( rspnTopDomainDeletedHandler );
	}

	// TopProject Response Handlers

	protected CFBamXMsgRspnTopProjectRecHandler getRspnTopProjectRecHandler() {
		if( rspnTopProjectRecHandler == null ) {
			rspnTopProjectRecHandler = new CFBamXMsgRspnTopProjectRecHandler( this );
		}
		return( rspnTopProjectRecHandler );
	}

	protected CFBamXMsgRspnTopProjectCreatedHandler getRspnTopProjectCreatedHandler() {
		if( rspnTopProjectCreatedHandler == null ) {
			rspnTopProjectCreatedHandler = new CFBamXMsgRspnTopProjectCreatedHandler( this );
		}
		return( rspnTopProjectCreatedHandler );
	}

	protected CFBamXMsgRspnTopProjectReadSingleHandler getRspnTopProjectReadSingleHandler() {
		if( rspnTopProjectReadSingleHandler == null ) {
			rspnTopProjectReadSingleHandler = new CFBamXMsgRspnTopProjectReadSingleHandler( this );
			rspnTopProjectReadSingleHandler.addElementHandler( "TopProject", getRspnTopProjectRecHandler() );
		}
		return( rspnTopProjectReadSingleHandler );
	}

	protected CFBamXMsgRspnTopProjectReadListHandler getRspnTopProjectReadListHandler() {
		if( rspnTopProjectReadListHandler == null ) {
			rspnTopProjectReadListHandler = new CFBamXMsgRspnTopProjectReadListHandler( this );
			rspnTopProjectReadListHandler.addElementHandler( "TopProject", getRspnTopProjectRecHandler() );
		}
		return( rspnTopProjectReadListHandler );
	}

	protected CFBamXMsgRspnTopProjectLockedHandler getRspnTopProjectLockedHandler() {
		if( rspnTopProjectLockedHandler == null ) {
			rspnTopProjectLockedHandler = new CFBamXMsgRspnTopProjectLockedHandler( this );
		}
		return( rspnTopProjectLockedHandler );
	}

	protected CFBamXMsgRspnTopProjectUpdatedHandler getRspnTopProjectUpdatedHandler() {
		if( rspnTopProjectUpdatedHandler == null ) {
			rspnTopProjectUpdatedHandler = new CFBamXMsgRspnTopProjectUpdatedHandler( this );
		}
		return( rspnTopProjectUpdatedHandler );
	}

	protected CFBamXMsgRspnTopProjectDeletedHandler getRspnTopProjectDeletedHandler() {
		if( rspnTopProjectDeletedHandler == null ) {
			rspnTopProjectDeletedHandler = new CFBamXMsgRspnTopProjectDeletedHandler( this );
		}
		return( rspnTopProjectDeletedHandler );
	}

	// UInt16Col Response Handlers

	protected CFBamXMsgRspnUInt16ColRecHandler getRspnUInt16ColRecHandler() {
		if( rspnUInt16ColRecHandler == null ) {
			rspnUInt16ColRecHandler = new CFBamXMsgRspnUInt16ColRecHandler( this );
		}
		return( rspnUInt16ColRecHandler );
	}

	protected CFBamXMsgRspnUInt16ColCreatedHandler getRspnUInt16ColCreatedHandler() {
		if( rspnUInt16ColCreatedHandler == null ) {
			rspnUInt16ColCreatedHandler = new CFBamXMsgRspnUInt16ColCreatedHandler( this );
		}
		return( rspnUInt16ColCreatedHandler );
	}

	protected CFBamXMsgRspnUInt16ColReadSingleHandler getRspnUInt16ColReadSingleHandler() {
		if( rspnUInt16ColReadSingleHandler == null ) {
			rspnUInt16ColReadSingleHandler = new CFBamXMsgRspnUInt16ColReadSingleHandler( this );
			rspnUInt16ColReadSingleHandler.addElementHandler( "UInt16Col", getRspnUInt16ColRecHandler() );
		}
		return( rspnUInt16ColReadSingleHandler );
	}

	protected CFBamXMsgRspnUInt16ColReadListHandler getRspnUInt16ColReadListHandler() {
		if( rspnUInt16ColReadListHandler == null ) {
			rspnUInt16ColReadListHandler = new CFBamXMsgRspnUInt16ColReadListHandler( this );
			rspnUInt16ColReadListHandler.addElementHandler( "UInt16Col", getRspnUInt16ColRecHandler() );
		}
		return( rspnUInt16ColReadListHandler );
	}

	protected CFBamXMsgRspnUInt16ColLockedHandler getRspnUInt16ColLockedHandler() {
		if( rspnUInt16ColLockedHandler == null ) {
			rspnUInt16ColLockedHandler = new CFBamXMsgRspnUInt16ColLockedHandler( this );
		}
		return( rspnUInt16ColLockedHandler );
	}

	protected CFBamXMsgRspnUInt16ColUpdatedHandler getRspnUInt16ColUpdatedHandler() {
		if( rspnUInt16ColUpdatedHandler == null ) {
			rspnUInt16ColUpdatedHandler = new CFBamXMsgRspnUInt16ColUpdatedHandler( this );
		}
		return( rspnUInt16ColUpdatedHandler );
	}

	protected CFBamXMsgRspnUInt16ColDeletedHandler getRspnUInt16ColDeletedHandler() {
		if( rspnUInt16ColDeletedHandler == null ) {
			rspnUInt16ColDeletedHandler = new CFBamXMsgRspnUInt16ColDeletedHandler( this );
		}
		return( rspnUInt16ColDeletedHandler );
	}

	// UInt16Def Response Handlers

	protected CFBamXMsgRspnUInt16DefRecHandler getRspnUInt16DefRecHandler() {
		if( rspnUInt16DefRecHandler == null ) {
			rspnUInt16DefRecHandler = new CFBamXMsgRspnUInt16DefRecHandler( this );
		}
		return( rspnUInt16DefRecHandler );
	}

	protected CFBamXMsgRspnUInt16DefCreatedHandler getRspnUInt16DefCreatedHandler() {
		if( rspnUInt16DefCreatedHandler == null ) {
			rspnUInt16DefCreatedHandler = new CFBamXMsgRspnUInt16DefCreatedHandler( this );
		}
		return( rspnUInt16DefCreatedHandler );
	}

	protected CFBamXMsgRspnUInt16DefReadSingleHandler getRspnUInt16DefReadSingleHandler() {
		if( rspnUInt16DefReadSingleHandler == null ) {
			rspnUInt16DefReadSingleHandler = new CFBamXMsgRspnUInt16DefReadSingleHandler( this );
			rspnUInt16DefReadSingleHandler.addElementHandler( "UInt16Def", getRspnUInt16DefRecHandler() );
			rspnUInt16DefReadSingleHandler.addElementHandler( "UInt16Col", getRspnUInt16ColRecHandler() );
			rspnUInt16DefReadSingleHandler.addElementHandler( "UInt16Type", getRspnUInt16TypeRecHandler() );
		}
		return( rspnUInt16DefReadSingleHandler );
	}

	protected CFBamXMsgRspnUInt16DefReadListHandler getRspnUInt16DefReadListHandler() {
		if( rspnUInt16DefReadListHandler == null ) {
			rspnUInt16DefReadListHandler = new CFBamXMsgRspnUInt16DefReadListHandler( this );
			rspnUInt16DefReadListHandler.addElementHandler( "UInt16Def", getRspnUInt16DefRecHandler() );
			rspnUInt16DefReadListHandler.addElementHandler( "UInt16Col", getRspnUInt16ColRecHandler() );
			rspnUInt16DefReadListHandler.addElementHandler( "UInt16Type", getRspnUInt16TypeRecHandler() );
		}
		return( rspnUInt16DefReadListHandler );
	}

	protected CFBamXMsgRspnUInt16DefLockedHandler getRspnUInt16DefLockedHandler() {
		if( rspnUInt16DefLockedHandler == null ) {
			rspnUInt16DefLockedHandler = new CFBamXMsgRspnUInt16DefLockedHandler( this );
		}
		return( rspnUInt16DefLockedHandler );
	}

	protected CFBamXMsgRspnUInt16DefUpdatedHandler getRspnUInt16DefUpdatedHandler() {
		if( rspnUInt16DefUpdatedHandler == null ) {
			rspnUInt16DefUpdatedHandler = new CFBamXMsgRspnUInt16DefUpdatedHandler( this );
		}
		return( rspnUInt16DefUpdatedHandler );
	}

	protected CFBamXMsgRspnUInt16DefDeletedHandler getRspnUInt16DefDeletedHandler() {
		if( rspnUInt16DefDeletedHandler == null ) {
			rspnUInt16DefDeletedHandler = new CFBamXMsgRspnUInt16DefDeletedHandler( this );
		}
		return( rspnUInt16DefDeletedHandler );
	}

	// UInt16Type Response Handlers

	protected CFBamXMsgRspnUInt16TypeRecHandler getRspnUInt16TypeRecHandler() {
		if( rspnUInt16TypeRecHandler == null ) {
			rspnUInt16TypeRecHandler = new CFBamXMsgRspnUInt16TypeRecHandler( this );
		}
		return( rspnUInt16TypeRecHandler );
	}

	protected CFBamXMsgRspnUInt16TypeCreatedHandler getRspnUInt16TypeCreatedHandler() {
		if( rspnUInt16TypeCreatedHandler == null ) {
			rspnUInt16TypeCreatedHandler = new CFBamXMsgRspnUInt16TypeCreatedHandler( this );
		}
		return( rspnUInt16TypeCreatedHandler );
	}

	protected CFBamXMsgRspnUInt16TypeReadSingleHandler getRspnUInt16TypeReadSingleHandler() {
		if( rspnUInt16TypeReadSingleHandler == null ) {
			rspnUInt16TypeReadSingleHandler = new CFBamXMsgRspnUInt16TypeReadSingleHandler( this );
			rspnUInt16TypeReadSingleHandler.addElementHandler( "UInt16Type", getRspnUInt16TypeRecHandler() );
		}
		return( rspnUInt16TypeReadSingleHandler );
	}

	protected CFBamXMsgRspnUInt16TypeReadListHandler getRspnUInt16TypeReadListHandler() {
		if( rspnUInt16TypeReadListHandler == null ) {
			rspnUInt16TypeReadListHandler = new CFBamXMsgRspnUInt16TypeReadListHandler( this );
			rspnUInt16TypeReadListHandler.addElementHandler( "UInt16Type", getRspnUInt16TypeRecHandler() );
		}
		return( rspnUInt16TypeReadListHandler );
	}

	protected CFBamXMsgRspnUInt16TypeLockedHandler getRspnUInt16TypeLockedHandler() {
		if( rspnUInt16TypeLockedHandler == null ) {
			rspnUInt16TypeLockedHandler = new CFBamXMsgRspnUInt16TypeLockedHandler( this );
		}
		return( rspnUInt16TypeLockedHandler );
	}

	protected CFBamXMsgRspnUInt16TypeUpdatedHandler getRspnUInt16TypeUpdatedHandler() {
		if( rspnUInt16TypeUpdatedHandler == null ) {
			rspnUInt16TypeUpdatedHandler = new CFBamXMsgRspnUInt16TypeUpdatedHandler( this );
		}
		return( rspnUInt16TypeUpdatedHandler );
	}

	protected CFBamXMsgRspnUInt16TypeDeletedHandler getRspnUInt16TypeDeletedHandler() {
		if( rspnUInt16TypeDeletedHandler == null ) {
			rspnUInt16TypeDeletedHandler = new CFBamXMsgRspnUInt16TypeDeletedHandler( this );
		}
		return( rspnUInt16TypeDeletedHandler );
	}

	// UInt32Col Response Handlers

	protected CFBamXMsgRspnUInt32ColRecHandler getRspnUInt32ColRecHandler() {
		if( rspnUInt32ColRecHandler == null ) {
			rspnUInt32ColRecHandler = new CFBamXMsgRspnUInt32ColRecHandler( this );
		}
		return( rspnUInt32ColRecHandler );
	}

	protected CFBamXMsgRspnUInt32ColCreatedHandler getRspnUInt32ColCreatedHandler() {
		if( rspnUInt32ColCreatedHandler == null ) {
			rspnUInt32ColCreatedHandler = new CFBamXMsgRspnUInt32ColCreatedHandler( this );
		}
		return( rspnUInt32ColCreatedHandler );
	}

	protected CFBamXMsgRspnUInt32ColReadSingleHandler getRspnUInt32ColReadSingleHandler() {
		if( rspnUInt32ColReadSingleHandler == null ) {
			rspnUInt32ColReadSingleHandler = new CFBamXMsgRspnUInt32ColReadSingleHandler( this );
			rspnUInt32ColReadSingleHandler.addElementHandler( "UInt32Col", getRspnUInt32ColRecHandler() );
		}
		return( rspnUInt32ColReadSingleHandler );
	}

	protected CFBamXMsgRspnUInt32ColReadListHandler getRspnUInt32ColReadListHandler() {
		if( rspnUInt32ColReadListHandler == null ) {
			rspnUInt32ColReadListHandler = new CFBamXMsgRspnUInt32ColReadListHandler( this );
			rspnUInt32ColReadListHandler.addElementHandler( "UInt32Col", getRspnUInt32ColRecHandler() );
		}
		return( rspnUInt32ColReadListHandler );
	}

	protected CFBamXMsgRspnUInt32ColLockedHandler getRspnUInt32ColLockedHandler() {
		if( rspnUInt32ColLockedHandler == null ) {
			rspnUInt32ColLockedHandler = new CFBamXMsgRspnUInt32ColLockedHandler( this );
		}
		return( rspnUInt32ColLockedHandler );
	}

	protected CFBamXMsgRspnUInt32ColUpdatedHandler getRspnUInt32ColUpdatedHandler() {
		if( rspnUInt32ColUpdatedHandler == null ) {
			rspnUInt32ColUpdatedHandler = new CFBamXMsgRspnUInt32ColUpdatedHandler( this );
		}
		return( rspnUInt32ColUpdatedHandler );
	}

	protected CFBamXMsgRspnUInt32ColDeletedHandler getRspnUInt32ColDeletedHandler() {
		if( rspnUInt32ColDeletedHandler == null ) {
			rspnUInt32ColDeletedHandler = new CFBamXMsgRspnUInt32ColDeletedHandler( this );
		}
		return( rspnUInt32ColDeletedHandler );
	}

	// UInt32Def Response Handlers

	protected CFBamXMsgRspnUInt32DefRecHandler getRspnUInt32DefRecHandler() {
		if( rspnUInt32DefRecHandler == null ) {
			rspnUInt32DefRecHandler = new CFBamXMsgRspnUInt32DefRecHandler( this );
		}
		return( rspnUInt32DefRecHandler );
	}

	protected CFBamXMsgRspnUInt32DefCreatedHandler getRspnUInt32DefCreatedHandler() {
		if( rspnUInt32DefCreatedHandler == null ) {
			rspnUInt32DefCreatedHandler = new CFBamXMsgRspnUInt32DefCreatedHandler( this );
		}
		return( rspnUInt32DefCreatedHandler );
	}

	protected CFBamXMsgRspnUInt32DefReadSingleHandler getRspnUInt32DefReadSingleHandler() {
		if( rspnUInt32DefReadSingleHandler == null ) {
			rspnUInt32DefReadSingleHandler = new CFBamXMsgRspnUInt32DefReadSingleHandler( this );
			rspnUInt32DefReadSingleHandler.addElementHandler( "UInt32Def", getRspnUInt32DefRecHandler() );
			rspnUInt32DefReadSingleHandler.addElementHandler( "UInt32Col", getRspnUInt32ColRecHandler() );
			rspnUInt32DefReadSingleHandler.addElementHandler( "UInt32Type", getRspnUInt32TypeRecHandler() );
		}
		return( rspnUInt32DefReadSingleHandler );
	}

	protected CFBamXMsgRspnUInt32DefReadListHandler getRspnUInt32DefReadListHandler() {
		if( rspnUInt32DefReadListHandler == null ) {
			rspnUInt32DefReadListHandler = new CFBamXMsgRspnUInt32DefReadListHandler( this );
			rspnUInt32DefReadListHandler.addElementHandler( "UInt32Def", getRspnUInt32DefRecHandler() );
			rspnUInt32DefReadListHandler.addElementHandler( "UInt32Col", getRspnUInt32ColRecHandler() );
			rspnUInt32DefReadListHandler.addElementHandler( "UInt32Type", getRspnUInt32TypeRecHandler() );
		}
		return( rspnUInt32DefReadListHandler );
	}

	protected CFBamXMsgRspnUInt32DefLockedHandler getRspnUInt32DefLockedHandler() {
		if( rspnUInt32DefLockedHandler == null ) {
			rspnUInt32DefLockedHandler = new CFBamXMsgRspnUInt32DefLockedHandler( this );
		}
		return( rspnUInt32DefLockedHandler );
	}

	protected CFBamXMsgRspnUInt32DefUpdatedHandler getRspnUInt32DefUpdatedHandler() {
		if( rspnUInt32DefUpdatedHandler == null ) {
			rspnUInt32DefUpdatedHandler = new CFBamXMsgRspnUInt32DefUpdatedHandler( this );
		}
		return( rspnUInt32DefUpdatedHandler );
	}

	protected CFBamXMsgRspnUInt32DefDeletedHandler getRspnUInt32DefDeletedHandler() {
		if( rspnUInt32DefDeletedHandler == null ) {
			rspnUInt32DefDeletedHandler = new CFBamXMsgRspnUInt32DefDeletedHandler( this );
		}
		return( rspnUInt32DefDeletedHandler );
	}

	// UInt32Type Response Handlers

	protected CFBamXMsgRspnUInt32TypeRecHandler getRspnUInt32TypeRecHandler() {
		if( rspnUInt32TypeRecHandler == null ) {
			rspnUInt32TypeRecHandler = new CFBamXMsgRspnUInt32TypeRecHandler( this );
		}
		return( rspnUInt32TypeRecHandler );
	}

	protected CFBamXMsgRspnUInt32TypeCreatedHandler getRspnUInt32TypeCreatedHandler() {
		if( rspnUInt32TypeCreatedHandler == null ) {
			rspnUInt32TypeCreatedHandler = new CFBamXMsgRspnUInt32TypeCreatedHandler( this );
		}
		return( rspnUInt32TypeCreatedHandler );
	}

	protected CFBamXMsgRspnUInt32TypeReadSingleHandler getRspnUInt32TypeReadSingleHandler() {
		if( rspnUInt32TypeReadSingleHandler == null ) {
			rspnUInt32TypeReadSingleHandler = new CFBamXMsgRspnUInt32TypeReadSingleHandler( this );
			rspnUInt32TypeReadSingleHandler.addElementHandler( "UInt32Type", getRspnUInt32TypeRecHandler() );
		}
		return( rspnUInt32TypeReadSingleHandler );
	}

	protected CFBamXMsgRspnUInt32TypeReadListHandler getRspnUInt32TypeReadListHandler() {
		if( rspnUInt32TypeReadListHandler == null ) {
			rspnUInt32TypeReadListHandler = new CFBamXMsgRspnUInt32TypeReadListHandler( this );
			rspnUInt32TypeReadListHandler.addElementHandler( "UInt32Type", getRspnUInt32TypeRecHandler() );
		}
		return( rspnUInt32TypeReadListHandler );
	}

	protected CFBamXMsgRspnUInt32TypeLockedHandler getRspnUInt32TypeLockedHandler() {
		if( rspnUInt32TypeLockedHandler == null ) {
			rspnUInt32TypeLockedHandler = new CFBamXMsgRspnUInt32TypeLockedHandler( this );
		}
		return( rspnUInt32TypeLockedHandler );
	}

	protected CFBamXMsgRspnUInt32TypeUpdatedHandler getRspnUInt32TypeUpdatedHandler() {
		if( rspnUInt32TypeUpdatedHandler == null ) {
			rspnUInt32TypeUpdatedHandler = new CFBamXMsgRspnUInt32TypeUpdatedHandler( this );
		}
		return( rspnUInt32TypeUpdatedHandler );
	}

	protected CFBamXMsgRspnUInt32TypeDeletedHandler getRspnUInt32TypeDeletedHandler() {
		if( rspnUInt32TypeDeletedHandler == null ) {
			rspnUInt32TypeDeletedHandler = new CFBamXMsgRspnUInt32TypeDeletedHandler( this );
		}
		return( rspnUInt32TypeDeletedHandler );
	}

	// UInt64Col Response Handlers

	protected CFBamXMsgRspnUInt64ColRecHandler getRspnUInt64ColRecHandler() {
		if( rspnUInt64ColRecHandler == null ) {
			rspnUInt64ColRecHandler = new CFBamXMsgRspnUInt64ColRecHandler( this );
		}
		return( rspnUInt64ColRecHandler );
	}

	protected CFBamXMsgRspnUInt64ColCreatedHandler getRspnUInt64ColCreatedHandler() {
		if( rspnUInt64ColCreatedHandler == null ) {
			rspnUInt64ColCreatedHandler = new CFBamXMsgRspnUInt64ColCreatedHandler( this );
		}
		return( rspnUInt64ColCreatedHandler );
	}

	protected CFBamXMsgRspnUInt64ColReadSingleHandler getRspnUInt64ColReadSingleHandler() {
		if( rspnUInt64ColReadSingleHandler == null ) {
			rspnUInt64ColReadSingleHandler = new CFBamXMsgRspnUInt64ColReadSingleHandler( this );
			rspnUInt64ColReadSingleHandler.addElementHandler( "UInt64Col", getRspnUInt64ColRecHandler() );
		}
		return( rspnUInt64ColReadSingleHandler );
	}

	protected CFBamXMsgRspnUInt64ColReadListHandler getRspnUInt64ColReadListHandler() {
		if( rspnUInt64ColReadListHandler == null ) {
			rspnUInt64ColReadListHandler = new CFBamXMsgRspnUInt64ColReadListHandler( this );
			rspnUInt64ColReadListHandler.addElementHandler( "UInt64Col", getRspnUInt64ColRecHandler() );
		}
		return( rspnUInt64ColReadListHandler );
	}

	protected CFBamXMsgRspnUInt64ColLockedHandler getRspnUInt64ColLockedHandler() {
		if( rspnUInt64ColLockedHandler == null ) {
			rspnUInt64ColLockedHandler = new CFBamXMsgRspnUInt64ColLockedHandler( this );
		}
		return( rspnUInt64ColLockedHandler );
	}

	protected CFBamXMsgRspnUInt64ColUpdatedHandler getRspnUInt64ColUpdatedHandler() {
		if( rspnUInt64ColUpdatedHandler == null ) {
			rspnUInt64ColUpdatedHandler = new CFBamXMsgRspnUInt64ColUpdatedHandler( this );
		}
		return( rspnUInt64ColUpdatedHandler );
	}

	protected CFBamXMsgRspnUInt64ColDeletedHandler getRspnUInt64ColDeletedHandler() {
		if( rspnUInt64ColDeletedHandler == null ) {
			rspnUInt64ColDeletedHandler = new CFBamXMsgRspnUInt64ColDeletedHandler( this );
		}
		return( rspnUInt64ColDeletedHandler );
	}

	// UInt64Def Response Handlers

	protected CFBamXMsgRspnUInt64DefRecHandler getRspnUInt64DefRecHandler() {
		if( rspnUInt64DefRecHandler == null ) {
			rspnUInt64DefRecHandler = new CFBamXMsgRspnUInt64DefRecHandler( this );
		}
		return( rspnUInt64DefRecHandler );
	}

	protected CFBamXMsgRspnUInt64DefCreatedHandler getRspnUInt64DefCreatedHandler() {
		if( rspnUInt64DefCreatedHandler == null ) {
			rspnUInt64DefCreatedHandler = new CFBamXMsgRspnUInt64DefCreatedHandler( this );
		}
		return( rspnUInt64DefCreatedHandler );
	}

	protected CFBamXMsgRspnUInt64DefReadSingleHandler getRspnUInt64DefReadSingleHandler() {
		if( rspnUInt64DefReadSingleHandler == null ) {
			rspnUInt64DefReadSingleHandler = new CFBamXMsgRspnUInt64DefReadSingleHandler( this );
			rspnUInt64DefReadSingleHandler.addElementHandler( "UInt64Def", getRspnUInt64DefRecHandler() );
			rspnUInt64DefReadSingleHandler.addElementHandler( "UInt64Col", getRspnUInt64ColRecHandler() );
			rspnUInt64DefReadSingleHandler.addElementHandler( "UInt64Type", getRspnUInt64TypeRecHandler() );
		}
		return( rspnUInt64DefReadSingleHandler );
	}

	protected CFBamXMsgRspnUInt64DefReadListHandler getRspnUInt64DefReadListHandler() {
		if( rspnUInt64DefReadListHandler == null ) {
			rspnUInt64DefReadListHandler = new CFBamXMsgRspnUInt64DefReadListHandler( this );
			rspnUInt64DefReadListHandler.addElementHandler( "UInt64Def", getRspnUInt64DefRecHandler() );
			rspnUInt64DefReadListHandler.addElementHandler( "UInt64Col", getRspnUInt64ColRecHandler() );
			rspnUInt64DefReadListHandler.addElementHandler( "UInt64Type", getRspnUInt64TypeRecHandler() );
		}
		return( rspnUInt64DefReadListHandler );
	}

	protected CFBamXMsgRspnUInt64DefLockedHandler getRspnUInt64DefLockedHandler() {
		if( rspnUInt64DefLockedHandler == null ) {
			rspnUInt64DefLockedHandler = new CFBamXMsgRspnUInt64DefLockedHandler( this );
		}
		return( rspnUInt64DefLockedHandler );
	}

	protected CFBamXMsgRspnUInt64DefUpdatedHandler getRspnUInt64DefUpdatedHandler() {
		if( rspnUInt64DefUpdatedHandler == null ) {
			rspnUInt64DefUpdatedHandler = new CFBamXMsgRspnUInt64DefUpdatedHandler( this );
		}
		return( rspnUInt64DefUpdatedHandler );
	}

	protected CFBamXMsgRspnUInt64DefDeletedHandler getRspnUInt64DefDeletedHandler() {
		if( rspnUInt64DefDeletedHandler == null ) {
			rspnUInt64DefDeletedHandler = new CFBamXMsgRspnUInt64DefDeletedHandler( this );
		}
		return( rspnUInt64DefDeletedHandler );
	}

	// UInt64Type Response Handlers

	protected CFBamXMsgRspnUInt64TypeRecHandler getRspnUInt64TypeRecHandler() {
		if( rspnUInt64TypeRecHandler == null ) {
			rspnUInt64TypeRecHandler = new CFBamXMsgRspnUInt64TypeRecHandler( this );
		}
		return( rspnUInt64TypeRecHandler );
	}

	protected CFBamXMsgRspnUInt64TypeCreatedHandler getRspnUInt64TypeCreatedHandler() {
		if( rspnUInt64TypeCreatedHandler == null ) {
			rspnUInt64TypeCreatedHandler = new CFBamXMsgRspnUInt64TypeCreatedHandler( this );
		}
		return( rspnUInt64TypeCreatedHandler );
	}

	protected CFBamXMsgRspnUInt64TypeReadSingleHandler getRspnUInt64TypeReadSingleHandler() {
		if( rspnUInt64TypeReadSingleHandler == null ) {
			rspnUInt64TypeReadSingleHandler = new CFBamXMsgRspnUInt64TypeReadSingleHandler( this );
			rspnUInt64TypeReadSingleHandler.addElementHandler( "UInt64Type", getRspnUInt64TypeRecHandler() );
		}
		return( rspnUInt64TypeReadSingleHandler );
	}

	protected CFBamXMsgRspnUInt64TypeReadListHandler getRspnUInt64TypeReadListHandler() {
		if( rspnUInt64TypeReadListHandler == null ) {
			rspnUInt64TypeReadListHandler = new CFBamXMsgRspnUInt64TypeReadListHandler( this );
			rspnUInt64TypeReadListHandler.addElementHandler( "UInt64Type", getRspnUInt64TypeRecHandler() );
		}
		return( rspnUInt64TypeReadListHandler );
	}

	protected CFBamXMsgRspnUInt64TypeLockedHandler getRspnUInt64TypeLockedHandler() {
		if( rspnUInt64TypeLockedHandler == null ) {
			rspnUInt64TypeLockedHandler = new CFBamXMsgRspnUInt64TypeLockedHandler( this );
		}
		return( rspnUInt64TypeLockedHandler );
	}

	protected CFBamXMsgRspnUInt64TypeUpdatedHandler getRspnUInt64TypeUpdatedHandler() {
		if( rspnUInt64TypeUpdatedHandler == null ) {
			rspnUInt64TypeUpdatedHandler = new CFBamXMsgRspnUInt64TypeUpdatedHandler( this );
		}
		return( rspnUInt64TypeUpdatedHandler );
	}

	protected CFBamXMsgRspnUInt64TypeDeletedHandler getRspnUInt64TypeDeletedHandler() {
		if( rspnUInt64TypeDeletedHandler == null ) {
			rspnUInt64TypeDeletedHandler = new CFBamXMsgRspnUInt64TypeDeletedHandler( this );
		}
		return( rspnUInt64TypeDeletedHandler );
	}

	// URLProtocol Response Handlers

	protected CFBamXMsgRspnURLProtocolRecHandler getRspnURLProtocolRecHandler() {
		if( rspnURLProtocolRecHandler == null ) {
			rspnURLProtocolRecHandler = new CFBamXMsgRspnURLProtocolRecHandler( this );
		}
		return( rspnURLProtocolRecHandler );
	}

	protected CFBamXMsgRspnURLProtocolCreatedHandler getRspnURLProtocolCreatedHandler() {
		if( rspnURLProtocolCreatedHandler == null ) {
			rspnURLProtocolCreatedHandler = new CFBamXMsgRspnURLProtocolCreatedHandler( this );
		}
		return( rspnURLProtocolCreatedHandler );
	}

	protected CFBamXMsgRspnURLProtocolReadSingleHandler getRspnURLProtocolReadSingleHandler() {
		if( rspnURLProtocolReadSingleHandler == null ) {
			rspnURLProtocolReadSingleHandler = new CFBamXMsgRspnURLProtocolReadSingleHandler( this );
			rspnURLProtocolReadSingleHandler.addElementHandler( "URLProtocol", getRspnURLProtocolRecHandler() );
		}
		return( rspnURLProtocolReadSingleHandler );
	}

	protected CFBamXMsgRspnURLProtocolReadListHandler getRspnURLProtocolReadListHandler() {
		if( rspnURLProtocolReadListHandler == null ) {
			rspnURLProtocolReadListHandler = new CFBamXMsgRspnURLProtocolReadListHandler( this );
			rspnURLProtocolReadListHandler.addElementHandler( "URLProtocol", getRspnURLProtocolRecHandler() );
		}
		return( rspnURLProtocolReadListHandler );
	}

	protected CFBamXMsgRspnURLProtocolLockedHandler getRspnURLProtocolLockedHandler() {
		if( rspnURLProtocolLockedHandler == null ) {
			rspnURLProtocolLockedHandler = new CFBamXMsgRspnURLProtocolLockedHandler( this );
		}
		return( rspnURLProtocolLockedHandler );
	}

	protected CFBamXMsgRspnURLProtocolUpdatedHandler getRspnURLProtocolUpdatedHandler() {
		if( rspnURLProtocolUpdatedHandler == null ) {
			rspnURLProtocolUpdatedHandler = new CFBamXMsgRspnURLProtocolUpdatedHandler( this );
		}
		return( rspnURLProtocolUpdatedHandler );
	}

	protected CFBamXMsgRspnURLProtocolDeletedHandler getRspnURLProtocolDeletedHandler() {
		if( rspnURLProtocolDeletedHandler == null ) {
			rspnURLProtocolDeletedHandler = new CFBamXMsgRspnURLProtocolDeletedHandler( this );
		}
		return( rspnURLProtocolDeletedHandler );
	}

	// UuidCol Response Handlers

	protected CFBamXMsgRspnUuidColRecHandler getRspnUuidColRecHandler() {
		if( rspnUuidColRecHandler == null ) {
			rspnUuidColRecHandler = new CFBamXMsgRspnUuidColRecHandler( this );
		}
		return( rspnUuidColRecHandler );
	}

	protected CFBamXMsgRspnUuidColCreatedHandler getRspnUuidColCreatedHandler() {
		if( rspnUuidColCreatedHandler == null ) {
			rspnUuidColCreatedHandler = new CFBamXMsgRspnUuidColCreatedHandler( this );
		}
		return( rspnUuidColCreatedHandler );
	}

	protected CFBamXMsgRspnUuidColReadSingleHandler getRspnUuidColReadSingleHandler() {
		if( rspnUuidColReadSingleHandler == null ) {
			rspnUuidColReadSingleHandler = new CFBamXMsgRspnUuidColReadSingleHandler( this );
			rspnUuidColReadSingleHandler.addElementHandler( "UuidCol", getRspnUuidColRecHandler() );
		}
		return( rspnUuidColReadSingleHandler );
	}

	protected CFBamXMsgRspnUuidColReadListHandler getRspnUuidColReadListHandler() {
		if( rspnUuidColReadListHandler == null ) {
			rspnUuidColReadListHandler = new CFBamXMsgRspnUuidColReadListHandler( this );
			rspnUuidColReadListHandler.addElementHandler( "UuidCol", getRspnUuidColRecHandler() );
		}
		return( rspnUuidColReadListHandler );
	}

	protected CFBamXMsgRspnUuidColLockedHandler getRspnUuidColLockedHandler() {
		if( rspnUuidColLockedHandler == null ) {
			rspnUuidColLockedHandler = new CFBamXMsgRspnUuidColLockedHandler( this );
		}
		return( rspnUuidColLockedHandler );
	}

	protected CFBamXMsgRspnUuidColUpdatedHandler getRspnUuidColUpdatedHandler() {
		if( rspnUuidColUpdatedHandler == null ) {
			rspnUuidColUpdatedHandler = new CFBamXMsgRspnUuidColUpdatedHandler( this );
		}
		return( rspnUuidColUpdatedHandler );
	}

	protected CFBamXMsgRspnUuidColDeletedHandler getRspnUuidColDeletedHandler() {
		if( rspnUuidColDeletedHandler == null ) {
			rspnUuidColDeletedHandler = new CFBamXMsgRspnUuidColDeletedHandler( this );
		}
		return( rspnUuidColDeletedHandler );
	}

	// UuidDef Response Handlers

	protected CFBamXMsgRspnUuidDefRecHandler getRspnUuidDefRecHandler() {
		if( rspnUuidDefRecHandler == null ) {
			rspnUuidDefRecHandler = new CFBamXMsgRspnUuidDefRecHandler( this );
		}
		return( rspnUuidDefRecHandler );
	}

	protected CFBamXMsgRspnUuidDefCreatedHandler getRspnUuidDefCreatedHandler() {
		if( rspnUuidDefCreatedHandler == null ) {
			rspnUuidDefCreatedHandler = new CFBamXMsgRspnUuidDefCreatedHandler( this );
		}
		return( rspnUuidDefCreatedHandler );
	}

	protected CFBamXMsgRspnUuidDefReadSingleHandler getRspnUuidDefReadSingleHandler() {
		if( rspnUuidDefReadSingleHandler == null ) {
			rspnUuidDefReadSingleHandler = new CFBamXMsgRspnUuidDefReadSingleHandler( this );
			rspnUuidDefReadSingleHandler.addElementHandler( "UuidDef", getRspnUuidDefRecHandler() );
			rspnUuidDefReadSingleHandler.addElementHandler( "UuidCol", getRspnUuidColRecHandler() );
			rspnUuidDefReadSingleHandler.addElementHandler( "UuidType", getRspnUuidTypeRecHandler() );
			rspnUuidDefReadSingleHandler.addElementHandler( "UuidGen", getRspnUuidGenRecHandler() );
		}
		return( rspnUuidDefReadSingleHandler );
	}

	protected CFBamXMsgRspnUuidDefReadListHandler getRspnUuidDefReadListHandler() {
		if( rspnUuidDefReadListHandler == null ) {
			rspnUuidDefReadListHandler = new CFBamXMsgRspnUuidDefReadListHandler( this );
			rspnUuidDefReadListHandler.addElementHandler( "UuidDef", getRspnUuidDefRecHandler() );
			rspnUuidDefReadListHandler.addElementHandler( "UuidCol", getRspnUuidColRecHandler() );
			rspnUuidDefReadListHandler.addElementHandler( "UuidType", getRspnUuidTypeRecHandler() );
			rspnUuidDefReadListHandler.addElementHandler( "UuidGen", getRspnUuidGenRecHandler() );
		}
		return( rspnUuidDefReadListHandler );
	}

	protected CFBamXMsgRspnUuidDefLockedHandler getRspnUuidDefLockedHandler() {
		if( rspnUuidDefLockedHandler == null ) {
			rspnUuidDefLockedHandler = new CFBamXMsgRspnUuidDefLockedHandler( this );
		}
		return( rspnUuidDefLockedHandler );
	}

	protected CFBamXMsgRspnUuidDefUpdatedHandler getRspnUuidDefUpdatedHandler() {
		if( rspnUuidDefUpdatedHandler == null ) {
			rspnUuidDefUpdatedHandler = new CFBamXMsgRspnUuidDefUpdatedHandler( this );
		}
		return( rspnUuidDefUpdatedHandler );
	}

	protected CFBamXMsgRspnUuidDefDeletedHandler getRspnUuidDefDeletedHandler() {
		if( rspnUuidDefDeletedHandler == null ) {
			rspnUuidDefDeletedHandler = new CFBamXMsgRspnUuidDefDeletedHandler( this );
		}
		return( rspnUuidDefDeletedHandler );
	}

	// UuidGen Response Handlers

	protected CFBamXMsgRspnUuidGenRecHandler getRspnUuidGenRecHandler() {
		if( rspnUuidGenRecHandler == null ) {
			rspnUuidGenRecHandler = new CFBamXMsgRspnUuidGenRecHandler( this );
		}
		return( rspnUuidGenRecHandler );
	}

	protected CFBamXMsgRspnUuidGenCreatedHandler getRspnUuidGenCreatedHandler() {
		if( rspnUuidGenCreatedHandler == null ) {
			rspnUuidGenCreatedHandler = new CFBamXMsgRspnUuidGenCreatedHandler( this );
		}
		return( rspnUuidGenCreatedHandler );
	}

	protected CFBamXMsgRspnUuidGenReadSingleHandler getRspnUuidGenReadSingleHandler() {
		if( rspnUuidGenReadSingleHandler == null ) {
			rspnUuidGenReadSingleHandler = new CFBamXMsgRspnUuidGenReadSingleHandler( this );
			rspnUuidGenReadSingleHandler.addElementHandler( "UuidGen", getRspnUuidGenRecHandler() );
		}
		return( rspnUuidGenReadSingleHandler );
	}

	protected CFBamXMsgRspnUuidGenReadListHandler getRspnUuidGenReadListHandler() {
		if( rspnUuidGenReadListHandler == null ) {
			rspnUuidGenReadListHandler = new CFBamXMsgRspnUuidGenReadListHandler( this );
			rspnUuidGenReadListHandler.addElementHandler( "UuidGen", getRspnUuidGenRecHandler() );
		}
		return( rspnUuidGenReadListHandler );
	}

	protected CFBamXMsgRspnUuidGenLockedHandler getRspnUuidGenLockedHandler() {
		if( rspnUuidGenLockedHandler == null ) {
			rspnUuidGenLockedHandler = new CFBamXMsgRspnUuidGenLockedHandler( this );
		}
		return( rspnUuidGenLockedHandler );
	}

	protected CFBamXMsgRspnUuidGenUpdatedHandler getRspnUuidGenUpdatedHandler() {
		if( rspnUuidGenUpdatedHandler == null ) {
			rspnUuidGenUpdatedHandler = new CFBamXMsgRspnUuidGenUpdatedHandler( this );
		}
		return( rspnUuidGenUpdatedHandler );
	}

	protected CFBamXMsgRspnUuidGenDeletedHandler getRspnUuidGenDeletedHandler() {
		if( rspnUuidGenDeletedHandler == null ) {
			rspnUuidGenDeletedHandler = new CFBamXMsgRspnUuidGenDeletedHandler( this );
		}
		return( rspnUuidGenDeletedHandler );
	}

	// UuidType Response Handlers

	protected CFBamXMsgRspnUuidTypeRecHandler getRspnUuidTypeRecHandler() {
		if( rspnUuidTypeRecHandler == null ) {
			rspnUuidTypeRecHandler = new CFBamXMsgRspnUuidTypeRecHandler( this );
		}
		return( rspnUuidTypeRecHandler );
	}

	protected CFBamXMsgRspnUuidTypeCreatedHandler getRspnUuidTypeCreatedHandler() {
		if( rspnUuidTypeCreatedHandler == null ) {
			rspnUuidTypeCreatedHandler = new CFBamXMsgRspnUuidTypeCreatedHandler( this );
		}
		return( rspnUuidTypeCreatedHandler );
	}

	protected CFBamXMsgRspnUuidTypeReadSingleHandler getRspnUuidTypeReadSingleHandler() {
		if( rspnUuidTypeReadSingleHandler == null ) {
			rspnUuidTypeReadSingleHandler = new CFBamXMsgRspnUuidTypeReadSingleHandler( this );
			rspnUuidTypeReadSingleHandler.addElementHandler( "UuidType", getRspnUuidTypeRecHandler() );
			rspnUuidTypeReadSingleHandler.addElementHandler( "UuidGen", getRspnUuidGenRecHandler() );
		}
		return( rspnUuidTypeReadSingleHandler );
	}

	protected CFBamXMsgRspnUuidTypeReadListHandler getRspnUuidTypeReadListHandler() {
		if( rspnUuidTypeReadListHandler == null ) {
			rspnUuidTypeReadListHandler = new CFBamXMsgRspnUuidTypeReadListHandler( this );
			rspnUuidTypeReadListHandler.addElementHandler( "UuidType", getRspnUuidTypeRecHandler() );
			rspnUuidTypeReadListHandler.addElementHandler( "UuidGen", getRspnUuidGenRecHandler() );
		}
		return( rspnUuidTypeReadListHandler );
	}

	protected CFBamXMsgRspnUuidTypeLockedHandler getRspnUuidTypeLockedHandler() {
		if( rspnUuidTypeLockedHandler == null ) {
			rspnUuidTypeLockedHandler = new CFBamXMsgRspnUuidTypeLockedHandler( this );
		}
		return( rspnUuidTypeLockedHandler );
	}

	protected CFBamXMsgRspnUuidTypeUpdatedHandler getRspnUuidTypeUpdatedHandler() {
		if( rspnUuidTypeUpdatedHandler == null ) {
			rspnUuidTypeUpdatedHandler = new CFBamXMsgRspnUuidTypeUpdatedHandler( this );
		}
		return( rspnUuidTypeUpdatedHandler );
	}

	protected CFBamXMsgRspnUuidTypeDeletedHandler getRspnUuidTypeDeletedHandler() {
		if( rspnUuidTypeDeletedHandler == null ) {
			rspnUuidTypeDeletedHandler = new CFBamXMsgRspnUuidTypeDeletedHandler( this );
		}
		return( rspnUuidTypeDeletedHandler );
	}

	// Value Response Handlers

	protected CFBamXMsgRspnValueRecHandler getRspnValueRecHandler() {
		if( rspnValueRecHandler == null ) {
			rspnValueRecHandler = new CFBamXMsgRspnValueRecHandler( this );
		}
		return( rspnValueRecHandler );
	}

	protected CFBamXMsgRspnValueCreatedHandler getRspnValueCreatedHandler() {
		if( rspnValueCreatedHandler == null ) {
			rspnValueCreatedHandler = new CFBamXMsgRspnValueCreatedHandler( this );
		}
		return( rspnValueCreatedHandler );
	}

	protected CFBamXMsgRspnValueReadSingleHandler getRspnValueReadSingleHandler() {
		if( rspnValueReadSingleHandler == null ) {
			rspnValueReadSingleHandler = new CFBamXMsgRspnValueReadSingleHandler( this );
			rspnValueReadSingleHandler.addElementHandler( "Value", getRspnValueRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TableCol", getRspnTableColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Atom", getRspnAtomRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "BlobDef", getRspnBlobDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "BlobCol", getRspnBlobColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "BlobType", getRspnBlobTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "BoolDef", getRspnBoolDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "BoolCol", getRspnBoolColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "BoolType", getRspnBoolTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Int16Def", getRspnInt16DefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Int16Col", getRspnInt16ColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Int16Type", getRspnInt16TypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Id16Gen", getRspnId16GenRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "EnumDef", getRspnEnumDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "EnumCol", getRspnEnumColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "EnumType", getRspnEnumTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Int32Def", getRspnInt32DefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Int32Col", getRspnInt32ColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Int32Type", getRspnInt32TypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Id32Gen", getRspnId32GenRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Int64Def", getRspnInt64DefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Int64Col", getRspnInt64ColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Int64Type", getRspnInt64TypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "Id64Gen", getRspnId64GenRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UInt16Def", getRspnUInt16DefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UInt16Col", getRspnUInt16ColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UInt16Type", getRspnUInt16TypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UInt32Def", getRspnUInt32DefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UInt32Col", getRspnUInt32ColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UInt32Type", getRspnUInt32TypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UInt64Def", getRspnUInt64DefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UInt64Col", getRspnUInt64ColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UInt64Type", getRspnUInt64TypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "FloatDef", getRspnFloatDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "FloatCol", getRspnFloatColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "FloatType", getRspnFloatTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "DoubleDef", getRspnDoubleDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "DoubleCol", getRspnDoubleColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "DoubleType", getRspnDoubleTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "NumberDef", getRspnNumberDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "NumberCol", getRspnNumberColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "NumberType", getRspnNumberTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "StringDef", getRspnStringDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "StringCol", getRspnStringColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "StringType", getRspnStringTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TextDef", getRspnTextDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TextCol", getRspnTextColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TextType", getRspnTextTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "NmTokenDef", getRspnNmTokenDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "NmTokenCol", getRspnNmTokenColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "NmTokenType", getRspnNmTokenTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "NmTokensDef", getRspnNmTokensDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "NmTokensCol", getRspnNmTokensColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "NmTokensType", getRspnNmTokensTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TokenDef", getRspnTokenDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TokenCol", getRspnTokenColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TokenType", getRspnTokenTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "DateDef", getRspnDateDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "DateCol", getRspnDateColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "DateType", getRspnDateTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TimeDef", getRspnTimeDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TimeCol", getRspnTimeColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TimeType", getRspnTimeTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TimestampDef", getRspnTimestampDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TimestampCol", getRspnTimestampColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TimestampType", getRspnTimestampTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TZDateDef", getRspnTZDateDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TZDateCol", getRspnTZDateColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TZDateType", getRspnTZDateTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TZTimeDef", getRspnTZTimeDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TZTimeCol", getRspnTZTimeColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TZTimeType", getRspnTZTimeTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TZTimestampDef", getRspnTZTimestampDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TZTimestampCol", getRspnTZTimestampColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "TZTimestampType", getRspnTZTimestampTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UuidDef", getRspnUuidDefRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UuidCol", getRspnUuidColRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UuidType", getRspnUuidTypeRecHandler() );
			rspnValueReadSingleHandler.addElementHandler( "UuidGen", getRspnUuidGenRecHandler() );
		}
		return( rspnValueReadSingleHandler );
	}

	protected CFBamXMsgRspnValueReadListHandler getRspnValueReadListHandler() {
		if( rspnValueReadListHandler == null ) {
			rspnValueReadListHandler = new CFBamXMsgRspnValueReadListHandler( this );
			rspnValueReadListHandler.addElementHandler( "Value", getRspnValueRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TableCol", getRspnTableColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Atom", getRspnAtomRecHandler() );
			rspnValueReadListHandler.addElementHandler( "BlobDef", getRspnBlobDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "BlobCol", getRspnBlobColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "BlobType", getRspnBlobTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "BoolDef", getRspnBoolDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "BoolCol", getRspnBoolColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "BoolType", getRspnBoolTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Int16Def", getRspnInt16DefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Int16Col", getRspnInt16ColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Int16Type", getRspnInt16TypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Id16Gen", getRspnId16GenRecHandler() );
			rspnValueReadListHandler.addElementHandler( "EnumDef", getRspnEnumDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "EnumCol", getRspnEnumColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "EnumType", getRspnEnumTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Int32Def", getRspnInt32DefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Int32Col", getRspnInt32ColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Int32Type", getRspnInt32TypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Id32Gen", getRspnId32GenRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Int64Def", getRspnInt64DefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Int64Col", getRspnInt64ColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Int64Type", getRspnInt64TypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "Id64Gen", getRspnId64GenRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UInt16Def", getRspnUInt16DefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UInt16Col", getRspnUInt16ColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UInt16Type", getRspnUInt16TypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UInt32Def", getRspnUInt32DefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UInt32Col", getRspnUInt32ColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UInt32Type", getRspnUInt32TypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UInt64Def", getRspnUInt64DefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UInt64Col", getRspnUInt64ColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UInt64Type", getRspnUInt64TypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "FloatDef", getRspnFloatDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "FloatCol", getRspnFloatColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "FloatType", getRspnFloatTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "DoubleDef", getRspnDoubleDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "DoubleCol", getRspnDoubleColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "DoubleType", getRspnDoubleTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "NumberDef", getRspnNumberDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "NumberCol", getRspnNumberColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "NumberType", getRspnNumberTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "StringDef", getRspnStringDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "StringCol", getRspnStringColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "StringType", getRspnStringTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TextDef", getRspnTextDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TextCol", getRspnTextColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TextType", getRspnTextTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "NmTokenDef", getRspnNmTokenDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "NmTokenCol", getRspnNmTokenColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "NmTokenType", getRspnNmTokenTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "NmTokensDef", getRspnNmTokensDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "NmTokensCol", getRspnNmTokensColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "NmTokensType", getRspnNmTokensTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TokenDef", getRspnTokenDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TokenCol", getRspnTokenColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TokenType", getRspnTokenTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "DateDef", getRspnDateDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "DateCol", getRspnDateColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "DateType", getRspnDateTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TimeDef", getRspnTimeDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TimeCol", getRspnTimeColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TimeType", getRspnTimeTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TimestampDef", getRspnTimestampDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TimestampCol", getRspnTimestampColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TimestampType", getRspnTimestampTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TZDateDef", getRspnTZDateDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TZDateCol", getRspnTZDateColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TZDateType", getRspnTZDateTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TZTimeDef", getRspnTZTimeDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TZTimeCol", getRspnTZTimeColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TZTimeType", getRspnTZTimeTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TZTimestampDef", getRspnTZTimestampDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TZTimestampCol", getRspnTZTimestampColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "TZTimestampType", getRspnTZTimestampTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UuidDef", getRspnUuidDefRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UuidCol", getRspnUuidColRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UuidType", getRspnUuidTypeRecHandler() );
			rspnValueReadListHandler.addElementHandler( "UuidGen", getRspnUuidGenRecHandler() );
		}
		return( rspnValueReadListHandler );
	}

	protected CFBamXMsgRspnValueLockedHandler getRspnValueLockedHandler() {
		if( rspnValueLockedHandler == null ) {
			rspnValueLockedHandler = new CFBamXMsgRspnValueLockedHandler( this );
		}
		return( rspnValueLockedHandler );
	}

	protected CFBamXMsgRspnValueUpdatedHandler getRspnValueUpdatedHandler() {
		if( rspnValueUpdatedHandler == null ) {
			rspnValueUpdatedHandler = new CFBamXMsgRspnValueUpdatedHandler( this );
		}
		return( rspnValueUpdatedHandler );
	}

	protected CFBamXMsgRspnValueDeletedHandler getRspnValueDeletedHandler() {
		if( rspnValueDeletedHandler == null ) {
			rspnValueDeletedHandler = new CFBamXMsgRspnValueDeletedHandler( this );
		}
		return( rspnValueDeletedHandler );
	}

	// Version Response Handlers

	protected CFBamXMsgRspnVersionRecHandler getRspnVersionRecHandler() {
		if( rspnVersionRecHandler == null ) {
			rspnVersionRecHandler = new CFBamXMsgRspnVersionRecHandler( this );
		}
		return( rspnVersionRecHandler );
	}

	protected CFBamXMsgRspnVersionCreatedHandler getRspnVersionCreatedHandler() {
		if( rspnVersionCreatedHandler == null ) {
			rspnVersionCreatedHandler = new CFBamXMsgRspnVersionCreatedHandler( this );
		}
		return( rspnVersionCreatedHandler );
	}

	protected CFBamXMsgRspnVersionReadSingleHandler getRspnVersionReadSingleHandler() {
		if( rspnVersionReadSingleHandler == null ) {
			rspnVersionReadSingleHandler = new CFBamXMsgRspnVersionReadSingleHandler( this );
			rspnVersionReadSingleHandler.addElementHandler( "Version", getRspnVersionRecHandler() );
			rspnVersionReadSingleHandler.addElementHandler( "MajorVersion", getRspnMajorVersionRecHandler() );
			rspnVersionReadSingleHandler.addElementHandler( "MinorVersion", getRspnMinorVersionRecHandler() );
		}
		return( rspnVersionReadSingleHandler );
	}

	protected CFBamXMsgRspnVersionReadListHandler getRspnVersionReadListHandler() {
		if( rspnVersionReadListHandler == null ) {
			rspnVersionReadListHandler = new CFBamXMsgRspnVersionReadListHandler( this );
			rspnVersionReadListHandler.addElementHandler( "Version", getRspnVersionRecHandler() );
			rspnVersionReadListHandler.addElementHandler( "MajorVersion", getRspnMajorVersionRecHandler() );
			rspnVersionReadListHandler.addElementHandler( "MinorVersion", getRspnMinorVersionRecHandler() );
		}
		return( rspnVersionReadListHandler );
	}

	protected CFBamXMsgRspnVersionLockedHandler getRspnVersionLockedHandler() {
		if( rspnVersionLockedHandler == null ) {
			rspnVersionLockedHandler = new CFBamXMsgRspnVersionLockedHandler( this );
		}
		return( rspnVersionLockedHandler );
	}

	protected CFBamXMsgRspnVersionUpdatedHandler getRspnVersionUpdatedHandler() {
		if( rspnVersionUpdatedHandler == null ) {
			rspnVersionUpdatedHandler = new CFBamXMsgRspnVersionUpdatedHandler( this );
		}
		return( rspnVersionUpdatedHandler );
	}

	protected CFBamXMsgRspnVersionDeletedHandler getRspnVersionDeletedHandler() {
		if( rspnVersionDeletedHandler == null ) {
			rspnVersionDeletedHandler = new CFBamXMsgRspnVersionDeletedHandler( this );
		}
		return( rspnVersionDeletedHandler );
	}

	// Root Element Handler Resolver Factory

	protected CFBamSaxRspnRootHandler getSaxRspnRootHandler() {
		if( saxRootHandler == null ) {
			saxRootHandler = new CFBamSaxRspnRootHandler( this );
			saxRootHandler.addElementHandler( "CFBamRspn", getSaxRspnDocHandler() );
			saxRootHandler.addElementHandler( "CFSecurityRspn", getSaxRspnDocHandler() );
			saxRootHandler.addElementHandler( "CFInternetRspn", getSaxRspnDocHandler() );
		}
		return( saxRootHandler );
	}

	// Root Element Handler

	/*
	 *	CFBamSaxRspnRootHandler XML SAX Root Element Handler implementation
	 */
	public class CFBamSaxRspnRootHandler
		extends CFLibXmlCoreElementHandler
	{
		public CFBamSaxRspnRootHandler( CFBamXMsgRspnHandler xmsgRspnHandler ) {
			super( xmsgRspnHandler );
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

	protected CFBamSaxRspnDocHandler getSaxRspnDocHandler() {
		if( saxDocHandler == null ) {
			saxDocHandler = new CFBamSaxRspnDocHandler( this );
			saxDocHandler.addElementHandler( "RspnNoDataFound", getRspnNoDataFoundHandler() );
			saxDocHandler.addElementHandler( "RspnException", getRspnExceptionHandler() );
			saxDocHandler.addElementHandler( "RspnFileLoaded", getRspnFileLoadedHandler() );
			saxDocHandler.addElementHandler( "RspnLoggedIn", getRspnLoggedInHandler() );
			saxDocHandler.addElementHandler( "RspnLoggedOut", getRspnLoggedOutHandler() );
			saxDocHandler.addElementHandler( "RspnServerProcExecuted", getRspnServerProcExecutedHandler() );

			// AccessFrequency Response Handlers

			saxDocHandler.addElementHandler( "RspnAccessFrequencyCreated", getRspnAccessFrequencyCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnAccessFrequencyReadSingle", getRspnAccessFrequencyReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnAccessFrequencyReadList", getRspnAccessFrequencyReadListHandler() );
			saxDocHandler.addElementHandler( "RspnAccessFrequencyLocked", getRspnAccessFrequencyLockedHandler() );
			saxDocHandler.addElementHandler( "RspnAccessFrequencyUpdated", getRspnAccessFrequencyUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnAccessFrequencyDeleted", getRspnAccessFrequencyDeletedHandler() );

			// AccessSecurity Response Handlers

			saxDocHandler.addElementHandler( "RspnAccessSecurityCreated", getRspnAccessSecurityCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnAccessSecurityReadSingle", getRspnAccessSecurityReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnAccessSecurityReadList", getRspnAccessSecurityReadListHandler() );
			saxDocHandler.addElementHandler( "RspnAccessSecurityLocked", getRspnAccessSecurityLockedHandler() );
			saxDocHandler.addElementHandler( "RspnAccessSecurityUpdated", getRspnAccessSecurityUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnAccessSecurityDeleted", getRspnAccessSecurityDeletedHandler() );

			// Atom Response Handlers

			saxDocHandler.addElementHandler( "RspnAtomCreated", getRspnAtomCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnAtomReadSingle", getRspnAtomReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnAtomReadList", getRspnAtomReadListHandler() );
			saxDocHandler.addElementHandler( "RspnAtomLocked", getRspnAtomLockedHandler() );
			saxDocHandler.addElementHandler( "RspnAtomUpdated", getRspnAtomUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnAtomDeleted", getRspnAtomDeletedHandler() );

			// AuditAction Response Handlers

			saxDocHandler.addElementHandler( "RspnAuditActionCreated", getRspnAuditActionCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnAuditActionReadSingle", getRspnAuditActionReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnAuditActionReadList", getRspnAuditActionReadListHandler() );
			saxDocHandler.addElementHandler( "RspnAuditActionLocked", getRspnAuditActionLockedHandler() );
			saxDocHandler.addElementHandler( "RspnAuditActionUpdated", getRspnAuditActionUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnAuditActionDeleted", getRspnAuditActionDeletedHandler() );

			// BlobCol Response Handlers

			saxDocHandler.addElementHandler( "RspnBlobColCreated", getRspnBlobColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnBlobColReadSingle", getRspnBlobColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnBlobColReadList", getRspnBlobColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnBlobColLocked", getRspnBlobColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnBlobColUpdated", getRspnBlobColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnBlobColDeleted", getRspnBlobColDeletedHandler() );

			// BlobDef Response Handlers

			saxDocHandler.addElementHandler( "RspnBlobDefCreated", getRspnBlobDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnBlobDefReadSingle", getRspnBlobDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnBlobDefReadList", getRspnBlobDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnBlobDefLocked", getRspnBlobDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnBlobDefUpdated", getRspnBlobDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnBlobDefDeleted", getRspnBlobDefDeletedHandler() );

			// BlobType Response Handlers

			saxDocHandler.addElementHandler( "RspnBlobTypeCreated", getRspnBlobTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnBlobTypeReadSingle", getRspnBlobTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnBlobTypeReadList", getRspnBlobTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnBlobTypeLocked", getRspnBlobTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnBlobTypeUpdated", getRspnBlobTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnBlobTypeDeleted", getRspnBlobTypeDeletedHandler() );

			// BoolCol Response Handlers

			saxDocHandler.addElementHandler( "RspnBoolColCreated", getRspnBoolColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnBoolColReadSingle", getRspnBoolColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnBoolColReadList", getRspnBoolColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnBoolColLocked", getRspnBoolColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnBoolColUpdated", getRspnBoolColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnBoolColDeleted", getRspnBoolColDeletedHandler() );

			// BoolDef Response Handlers

			saxDocHandler.addElementHandler( "RspnBoolDefCreated", getRspnBoolDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnBoolDefReadSingle", getRspnBoolDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnBoolDefReadList", getRspnBoolDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnBoolDefLocked", getRspnBoolDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnBoolDefUpdated", getRspnBoolDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnBoolDefDeleted", getRspnBoolDefDeletedHandler() );

			// BoolType Response Handlers

			saxDocHandler.addElementHandler( "RspnBoolTypeCreated", getRspnBoolTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnBoolTypeReadSingle", getRspnBoolTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnBoolTypeReadList", getRspnBoolTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnBoolTypeLocked", getRspnBoolTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnBoolTypeUpdated", getRspnBoolTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnBoolTypeDeleted", getRspnBoolTypeDeletedHandler() );

			// Chain Response Handlers

			saxDocHandler.addElementHandler( "RspnChainCreated", getRspnChainCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnChainReadSingle", getRspnChainReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnChainReadList", getRspnChainReadListHandler() );
			saxDocHandler.addElementHandler( "RspnChainLocked", getRspnChainLockedHandler() );
			saxDocHandler.addElementHandler( "RspnChainUpdated", getRspnChainUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnChainDeleted", getRspnChainDeletedHandler() );

			// ClearDep Response Handlers

			saxDocHandler.addElementHandler( "RspnClearDepCreated", getRspnClearDepCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnClearDepReadSingle", getRspnClearDepReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnClearDepReadList", getRspnClearDepReadListHandler() );
			saxDocHandler.addElementHandler( "RspnClearDepLocked", getRspnClearDepLockedHandler() );
			saxDocHandler.addElementHandler( "RspnClearDepUpdated", getRspnClearDepUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnClearDepDeleted", getRspnClearDepDeletedHandler() );

			// ClearSubDep1 Response Handlers

			saxDocHandler.addElementHandler( "RspnClearSubDep1Created", getRspnClearSubDep1CreatedHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep1ReadSingle", getRspnClearSubDep1ReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep1ReadList", getRspnClearSubDep1ReadListHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep1Locked", getRspnClearSubDep1LockedHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep1Updated", getRspnClearSubDep1UpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep1Deleted", getRspnClearSubDep1DeletedHandler() );

			// ClearSubDep2 Response Handlers

			saxDocHandler.addElementHandler( "RspnClearSubDep2Created", getRspnClearSubDep2CreatedHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep2ReadSingle", getRspnClearSubDep2ReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep2ReadList", getRspnClearSubDep2ReadListHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep2Locked", getRspnClearSubDep2LockedHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep2Updated", getRspnClearSubDep2UpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep2Deleted", getRspnClearSubDep2DeletedHandler() );

			// ClearSubDep3 Response Handlers

			saxDocHandler.addElementHandler( "RspnClearSubDep3Created", getRspnClearSubDep3CreatedHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep3ReadSingle", getRspnClearSubDep3ReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep3ReadList", getRspnClearSubDep3ReadListHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep3Locked", getRspnClearSubDep3LockedHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep3Updated", getRspnClearSubDep3UpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnClearSubDep3Deleted", getRspnClearSubDep3DeletedHandler() );

			// ClearTopDep Response Handlers

			saxDocHandler.addElementHandler( "RspnClearTopDepCreated", getRspnClearTopDepCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnClearTopDepReadSingle", getRspnClearTopDepReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnClearTopDepReadList", getRspnClearTopDepReadListHandler() );
			saxDocHandler.addElementHandler( "RspnClearTopDepLocked", getRspnClearTopDepLockedHandler() );
			saxDocHandler.addElementHandler( "RspnClearTopDepUpdated", getRspnClearTopDepUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnClearTopDepDeleted", getRspnClearTopDepDeletedHandler() );

			// Cluster Response Handlers

			saxDocHandler.addElementHandler( "RspnClusterCreated", getRspnClusterCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnClusterReadSingle", getRspnClusterReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnClusterReadList", getRspnClusterReadListHandler() );
			saxDocHandler.addElementHandler( "RspnClusterLocked", getRspnClusterLockedHandler() );
			saxDocHandler.addElementHandler( "RspnClusterUpdated", getRspnClusterUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnClusterDeleted", getRspnClusterDeletedHandler() );

			// DataScope Response Handlers

			saxDocHandler.addElementHandler( "RspnDataScopeCreated", getRspnDataScopeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDataScopeReadSingle", getRspnDataScopeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDataScopeReadList", getRspnDataScopeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDataScopeLocked", getRspnDataScopeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDataScopeUpdated", getRspnDataScopeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDataScopeDeleted", getRspnDataScopeDeletedHandler() );

			// DateCol Response Handlers

			saxDocHandler.addElementHandler( "RspnDateColCreated", getRspnDateColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDateColReadSingle", getRspnDateColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDateColReadList", getRspnDateColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDateColLocked", getRspnDateColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDateColUpdated", getRspnDateColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDateColDeleted", getRspnDateColDeletedHandler() );

			// DateDef Response Handlers

			saxDocHandler.addElementHandler( "RspnDateDefCreated", getRspnDateDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDateDefReadSingle", getRspnDateDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDateDefReadList", getRspnDateDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDateDefLocked", getRspnDateDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDateDefUpdated", getRspnDateDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDateDefDeleted", getRspnDateDefDeletedHandler() );

			// DateType Response Handlers

			saxDocHandler.addElementHandler( "RspnDateTypeCreated", getRspnDateTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDateTypeReadSingle", getRspnDateTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDateTypeReadList", getRspnDateTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDateTypeLocked", getRspnDateTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDateTypeUpdated", getRspnDateTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDateTypeDeleted", getRspnDateTypeDeletedHandler() );

			// DelDep Response Handlers

			saxDocHandler.addElementHandler( "RspnDelDepCreated", getRspnDelDepCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDelDepReadSingle", getRspnDelDepReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDelDepReadList", getRspnDelDepReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDelDepLocked", getRspnDelDepLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDelDepUpdated", getRspnDelDepUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDelDepDeleted", getRspnDelDepDeletedHandler() );

			// DelSubDep1 Response Handlers

			saxDocHandler.addElementHandler( "RspnDelSubDep1Created", getRspnDelSubDep1CreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep1ReadSingle", getRspnDelSubDep1ReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep1ReadList", getRspnDelSubDep1ReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep1Locked", getRspnDelSubDep1LockedHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep1Updated", getRspnDelSubDep1UpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep1Deleted", getRspnDelSubDep1DeletedHandler() );

			// DelSubDep2 Response Handlers

			saxDocHandler.addElementHandler( "RspnDelSubDep2Created", getRspnDelSubDep2CreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep2ReadSingle", getRspnDelSubDep2ReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep2ReadList", getRspnDelSubDep2ReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep2Locked", getRspnDelSubDep2LockedHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep2Updated", getRspnDelSubDep2UpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep2Deleted", getRspnDelSubDep2DeletedHandler() );

			// DelSubDep3 Response Handlers

			saxDocHandler.addElementHandler( "RspnDelSubDep3Created", getRspnDelSubDep3CreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep3ReadSingle", getRspnDelSubDep3ReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep3ReadList", getRspnDelSubDep3ReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep3Locked", getRspnDelSubDep3LockedHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep3Updated", getRspnDelSubDep3UpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDelSubDep3Deleted", getRspnDelSubDep3DeletedHandler() );

			// DelTopDep Response Handlers

			saxDocHandler.addElementHandler( "RspnDelTopDepCreated", getRspnDelTopDepCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDelTopDepReadSingle", getRspnDelTopDepReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDelTopDepReadList", getRspnDelTopDepReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDelTopDepLocked", getRspnDelTopDepLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDelTopDepUpdated", getRspnDelTopDepUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDelTopDepDeleted", getRspnDelTopDepDeletedHandler() );

			// Domain Response Handlers

			saxDocHandler.addElementHandler( "RspnDomainCreated", getRspnDomainCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDomainReadSingle", getRspnDomainReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDomainReadList", getRspnDomainReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDomainLocked", getRspnDomainLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDomainUpdated", getRspnDomainUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDomainDeleted", getRspnDomainDeletedHandler() );

			// DomainBase Response Handlers

			saxDocHandler.addElementHandler( "RspnDomainBaseCreated", getRspnDomainBaseCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDomainBaseReadSingle", getRspnDomainBaseReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDomainBaseReadList", getRspnDomainBaseReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDomainBaseLocked", getRspnDomainBaseLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDomainBaseUpdated", getRspnDomainBaseUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDomainBaseDeleted", getRspnDomainBaseDeletedHandler() );

			// DoubleCol Response Handlers

			saxDocHandler.addElementHandler( "RspnDoubleColCreated", getRspnDoubleColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleColReadSingle", getRspnDoubleColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleColReadList", getRspnDoubleColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleColLocked", getRspnDoubleColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleColUpdated", getRspnDoubleColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleColDeleted", getRspnDoubleColDeletedHandler() );

			// DoubleDef Response Handlers

			saxDocHandler.addElementHandler( "RspnDoubleDefCreated", getRspnDoubleDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleDefReadSingle", getRspnDoubleDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleDefReadList", getRspnDoubleDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleDefLocked", getRspnDoubleDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleDefUpdated", getRspnDoubleDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleDefDeleted", getRspnDoubleDefDeletedHandler() );

			// DoubleType Response Handlers

			saxDocHandler.addElementHandler( "RspnDoubleTypeCreated", getRspnDoubleTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleTypeReadSingle", getRspnDoubleTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleTypeReadList", getRspnDoubleTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleTypeLocked", getRspnDoubleTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleTypeUpdated", getRspnDoubleTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnDoubleTypeDeleted", getRspnDoubleTypeDeletedHandler() );

			// EnumCol Response Handlers

			saxDocHandler.addElementHandler( "RspnEnumColCreated", getRspnEnumColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumColReadSingle", getRspnEnumColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnEnumColReadList", getRspnEnumColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnEnumColLocked", getRspnEnumColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumColUpdated", getRspnEnumColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumColDeleted", getRspnEnumColDeletedHandler() );

			// EnumDef Response Handlers

			saxDocHandler.addElementHandler( "RspnEnumDefCreated", getRspnEnumDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumDefReadSingle", getRspnEnumDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnEnumDefReadList", getRspnEnumDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnEnumDefLocked", getRspnEnumDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumDefUpdated", getRspnEnumDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumDefDeleted", getRspnEnumDefDeletedHandler() );

			// EnumTag Response Handlers

			saxDocHandler.addElementHandler( "RspnEnumTagCreated", getRspnEnumTagCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumTagReadSingle", getRspnEnumTagReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnEnumTagReadList", getRspnEnumTagReadListHandler() );
			saxDocHandler.addElementHandler( "RspnEnumTagLocked", getRspnEnumTagLockedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumTagUpdated", getRspnEnumTagUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumTagDeleted", getRspnEnumTagDeletedHandler() );

			// EnumType Response Handlers

			saxDocHandler.addElementHandler( "RspnEnumTypeCreated", getRspnEnumTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumTypeReadSingle", getRspnEnumTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnEnumTypeReadList", getRspnEnumTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnEnumTypeLocked", getRspnEnumTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumTypeUpdated", getRspnEnumTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnEnumTypeDeleted", getRspnEnumTypeDeletedHandler() );

			// FloatCol Response Handlers

			saxDocHandler.addElementHandler( "RspnFloatColCreated", getRspnFloatColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnFloatColReadSingle", getRspnFloatColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnFloatColReadList", getRspnFloatColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnFloatColLocked", getRspnFloatColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnFloatColUpdated", getRspnFloatColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnFloatColDeleted", getRspnFloatColDeletedHandler() );

			// FloatDef Response Handlers

			saxDocHandler.addElementHandler( "RspnFloatDefCreated", getRspnFloatDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnFloatDefReadSingle", getRspnFloatDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnFloatDefReadList", getRspnFloatDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnFloatDefLocked", getRspnFloatDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnFloatDefUpdated", getRspnFloatDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnFloatDefDeleted", getRspnFloatDefDeletedHandler() );

			// FloatType Response Handlers

			saxDocHandler.addElementHandler( "RspnFloatTypeCreated", getRspnFloatTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnFloatTypeReadSingle", getRspnFloatTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnFloatTypeReadList", getRspnFloatTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnFloatTypeLocked", getRspnFloatTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnFloatTypeUpdated", getRspnFloatTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnFloatTypeDeleted", getRspnFloatTypeDeletedHandler() );

			// HostNode Response Handlers

			saxDocHandler.addElementHandler( "RspnHostNodeCreated", getRspnHostNodeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnHostNodeReadSingle", getRspnHostNodeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnHostNodeReadList", getRspnHostNodeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnHostNodeLocked", getRspnHostNodeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnHostNodeUpdated", getRspnHostNodeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnHostNodeDeleted", getRspnHostNodeDeletedHandler() );

			// ISOCountry Response Handlers

			saxDocHandler.addElementHandler( "RspnISOCountryCreated", getRspnISOCountryCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryReadSingle", getRspnISOCountryReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryReadList", getRspnISOCountryReadListHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryLocked", getRspnISOCountryLockedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryUpdated", getRspnISOCountryUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryDeleted", getRspnISOCountryDeletedHandler() );

			// ISOCountryCurrency Response Handlers

			saxDocHandler.addElementHandler( "RspnISOCountryCurrencyCreated", getRspnISOCountryCurrencyCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryCurrencyReadSingle", getRspnISOCountryCurrencyReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryCurrencyReadList", getRspnISOCountryCurrencyReadListHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryCurrencyLocked", getRspnISOCountryCurrencyLockedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryCurrencyUpdated", getRspnISOCountryCurrencyUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryCurrencyDeleted", getRspnISOCountryCurrencyDeletedHandler() );

			// ISOCountryLanguage Response Handlers

			saxDocHandler.addElementHandler( "RspnISOCountryLanguageCreated", getRspnISOCountryLanguageCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryLanguageReadSingle", getRspnISOCountryLanguageReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryLanguageReadList", getRspnISOCountryLanguageReadListHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryLanguageLocked", getRspnISOCountryLanguageLockedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryLanguageUpdated", getRspnISOCountryLanguageUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCountryLanguageDeleted", getRspnISOCountryLanguageDeletedHandler() );

			// ISOCurrency Response Handlers

			saxDocHandler.addElementHandler( "RspnISOCurrencyCreated", getRspnISOCurrencyCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCurrencyReadSingle", getRspnISOCurrencyReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnISOCurrencyReadList", getRspnISOCurrencyReadListHandler() );
			saxDocHandler.addElementHandler( "RspnISOCurrencyLocked", getRspnISOCurrencyLockedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCurrencyUpdated", getRspnISOCurrencyUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOCurrencyDeleted", getRspnISOCurrencyDeletedHandler() );

			// ISOLanguage Response Handlers

			saxDocHandler.addElementHandler( "RspnISOLanguageCreated", getRspnISOLanguageCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOLanguageReadSingle", getRspnISOLanguageReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnISOLanguageReadList", getRspnISOLanguageReadListHandler() );
			saxDocHandler.addElementHandler( "RspnISOLanguageLocked", getRspnISOLanguageLockedHandler() );
			saxDocHandler.addElementHandler( "RspnISOLanguageUpdated", getRspnISOLanguageUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOLanguageDeleted", getRspnISOLanguageDeletedHandler() );

			// ISOTimezone Response Handlers

			saxDocHandler.addElementHandler( "RspnISOTimezoneCreated", getRspnISOTimezoneCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOTimezoneReadSingle", getRspnISOTimezoneReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnISOTimezoneReadList", getRspnISOTimezoneReadListHandler() );
			saxDocHandler.addElementHandler( "RspnISOTimezoneLocked", getRspnISOTimezoneLockedHandler() );
			saxDocHandler.addElementHandler( "RspnISOTimezoneUpdated", getRspnISOTimezoneUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnISOTimezoneDeleted", getRspnISOTimezoneDeletedHandler() );

			// Id16Gen Response Handlers

			saxDocHandler.addElementHandler( "RspnId16GenCreated", getRspnId16GenCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnId16GenReadSingle", getRspnId16GenReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnId16GenReadList", getRspnId16GenReadListHandler() );
			saxDocHandler.addElementHandler( "RspnId16GenLocked", getRspnId16GenLockedHandler() );
			saxDocHandler.addElementHandler( "RspnId16GenUpdated", getRspnId16GenUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnId16GenDeleted", getRspnId16GenDeletedHandler() );

			// Id32Gen Response Handlers

			saxDocHandler.addElementHandler( "RspnId32GenCreated", getRspnId32GenCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnId32GenReadSingle", getRspnId32GenReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnId32GenReadList", getRspnId32GenReadListHandler() );
			saxDocHandler.addElementHandler( "RspnId32GenLocked", getRspnId32GenLockedHandler() );
			saxDocHandler.addElementHandler( "RspnId32GenUpdated", getRspnId32GenUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnId32GenDeleted", getRspnId32GenDeletedHandler() );

			// Id64Gen Response Handlers

			saxDocHandler.addElementHandler( "RspnId64GenCreated", getRspnId64GenCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnId64GenReadSingle", getRspnId64GenReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnId64GenReadList", getRspnId64GenReadListHandler() );
			saxDocHandler.addElementHandler( "RspnId64GenLocked", getRspnId64GenLockedHandler() );
			saxDocHandler.addElementHandler( "RspnId64GenUpdated", getRspnId64GenUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnId64GenDeleted", getRspnId64GenDeletedHandler() );

			// Index Response Handlers

			saxDocHandler.addElementHandler( "RspnIndexCreated", getRspnIndexCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnIndexReadSingle", getRspnIndexReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnIndexReadList", getRspnIndexReadListHandler() );
			saxDocHandler.addElementHandler( "RspnIndexLocked", getRspnIndexLockedHandler() );
			saxDocHandler.addElementHandler( "RspnIndexUpdated", getRspnIndexUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnIndexDeleted", getRspnIndexDeletedHandler() );

			// IndexCol Response Handlers

			saxDocHandler.addElementHandler( "RspnIndexColCreated", getRspnIndexColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnIndexColReadSingle", getRspnIndexColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnIndexColReadList", getRspnIndexColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnIndexColLocked", getRspnIndexColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnIndexColUpdated", getRspnIndexColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnIndexColDeleted", getRspnIndexColDeletedHandler() );

			// Int16Col Response Handlers

			saxDocHandler.addElementHandler( "RspnInt16ColCreated", getRspnInt16ColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt16ColReadSingle", getRspnInt16ColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnInt16ColReadList", getRspnInt16ColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnInt16ColLocked", getRspnInt16ColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnInt16ColUpdated", getRspnInt16ColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt16ColDeleted", getRspnInt16ColDeletedHandler() );

			// Int16Def Response Handlers

			saxDocHandler.addElementHandler( "RspnInt16DefCreated", getRspnInt16DefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt16DefReadSingle", getRspnInt16DefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnInt16DefReadList", getRspnInt16DefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnInt16DefLocked", getRspnInt16DefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnInt16DefUpdated", getRspnInt16DefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt16DefDeleted", getRspnInt16DefDeletedHandler() );

			// Int16Type Response Handlers

			saxDocHandler.addElementHandler( "RspnInt16TypeCreated", getRspnInt16TypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt16TypeReadSingle", getRspnInt16TypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnInt16TypeReadList", getRspnInt16TypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnInt16TypeLocked", getRspnInt16TypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnInt16TypeUpdated", getRspnInt16TypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt16TypeDeleted", getRspnInt16TypeDeletedHandler() );

			// Int32Col Response Handlers

			saxDocHandler.addElementHandler( "RspnInt32ColCreated", getRspnInt32ColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt32ColReadSingle", getRspnInt32ColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnInt32ColReadList", getRspnInt32ColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnInt32ColLocked", getRspnInt32ColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnInt32ColUpdated", getRspnInt32ColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt32ColDeleted", getRspnInt32ColDeletedHandler() );

			// Int32Def Response Handlers

			saxDocHandler.addElementHandler( "RspnInt32DefCreated", getRspnInt32DefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt32DefReadSingle", getRspnInt32DefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnInt32DefReadList", getRspnInt32DefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnInt32DefLocked", getRspnInt32DefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnInt32DefUpdated", getRspnInt32DefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt32DefDeleted", getRspnInt32DefDeletedHandler() );

			// Int32Type Response Handlers

			saxDocHandler.addElementHandler( "RspnInt32TypeCreated", getRspnInt32TypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt32TypeReadSingle", getRspnInt32TypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnInt32TypeReadList", getRspnInt32TypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnInt32TypeLocked", getRspnInt32TypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnInt32TypeUpdated", getRspnInt32TypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt32TypeDeleted", getRspnInt32TypeDeletedHandler() );

			// Int64Col Response Handlers

			saxDocHandler.addElementHandler( "RspnInt64ColCreated", getRspnInt64ColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt64ColReadSingle", getRspnInt64ColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnInt64ColReadList", getRspnInt64ColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnInt64ColLocked", getRspnInt64ColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnInt64ColUpdated", getRspnInt64ColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt64ColDeleted", getRspnInt64ColDeletedHandler() );

			// Int64Def Response Handlers

			saxDocHandler.addElementHandler( "RspnInt64DefCreated", getRspnInt64DefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt64DefReadSingle", getRspnInt64DefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnInt64DefReadList", getRspnInt64DefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnInt64DefLocked", getRspnInt64DefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnInt64DefUpdated", getRspnInt64DefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt64DefDeleted", getRspnInt64DefDeletedHandler() );

			// Int64Type Response Handlers

			saxDocHandler.addElementHandler( "RspnInt64TypeCreated", getRspnInt64TypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt64TypeReadSingle", getRspnInt64TypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnInt64TypeReadList", getRspnInt64TypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnInt64TypeLocked", getRspnInt64TypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnInt64TypeUpdated", getRspnInt64TypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnInt64TypeDeleted", getRspnInt64TypeDeletedHandler() );

			// License Response Handlers

			saxDocHandler.addElementHandler( "RspnLicenseCreated", getRspnLicenseCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnLicenseReadSingle", getRspnLicenseReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnLicenseReadList", getRspnLicenseReadListHandler() );
			saxDocHandler.addElementHandler( "RspnLicenseLocked", getRspnLicenseLockedHandler() );
			saxDocHandler.addElementHandler( "RspnLicenseUpdated", getRspnLicenseUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnLicenseDeleted", getRspnLicenseDeletedHandler() );

			// LoaderBehaviour Response Handlers

			saxDocHandler.addElementHandler( "RspnLoaderBehaviourCreated", getRspnLoaderBehaviourCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnLoaderBehaviourReadSingle", getRspnLoaderBehaviourReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnLoaderBehaviourReadList", getRspnLoaderBehaviourReadListHandler() );
			saxDocHandler.addElementHandler( "RspnLoaderBehaviourLocked", getRspnLoaderBehaviourLockedHandler() );
			saxDocHandler.addElementHandler( "RspnLoaderBehaviourUpdated", getRspnLoaderBehaviourUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnLoaderBehaviourDeleted", getRspnLoaderBehaviourDeletedHandler() );

			// MajorVersion Response Handlers

			saxDocHandler.addElementHandler( "RspnMajorVersionCreated", getRspnMajorVersionCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnMajorVersionReadSingle", getRspnMajorVersionReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnMajorVersionReadList", getRspnMajorVersionReadListHandler() );
			saxDocHandler.addElementHandler( "RspnMajorVersionLocked", getRspnMajorVersionLockedHandler() );
			saxDocHandler.addElementHandler( "RspnMajorVersionUpdated", getRspnMajorVersionUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnMajorVersionDeleted", getRspnMajorVersionDeletedHandler() );

			// MimeType Response Handlers

			saxDocHandler.addElementHandler( "RspnMimeTypeCreated", getRspnMimeTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnMimeTypeReadSingle", getRspnMimeTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnMimeTypeReadList", getRspnMimeTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnMimeTypeLocked", getRspnMimeTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnMimeTypeUpdated", getRspnMimeTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnMimeTypeDeleted", getRspnMimeTypeDeletedHandler() );

			// MinorVersion Response Handlers

			saxDocHandler.addElementHandler( "RspnMinorVersionCreated", getRspnMinorVersionCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnMinorVersionReadSingle", getRspnMinorVersionReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnMinorVersionReadList", getRspnMinorVersionReadListHandler() );
			saxDocHandler.addElementHandler( "RspnMinorVersionLocked", getRspnMinorVersionLockedHandler() );
			saxDocHandler.addElementHandler( "RspnMinorVersionUpdated", getRspnMinorVersionUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnMinorVersionDeleted", getRspnMinorVersionDeletedHandler() );

			// NmTokenCol Response Handlers

			saxDocHandler.addElementHandler( "RspnNmTokenColCreated", getRspnNmTokenColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenColReadSingle", getRspnNmTokenColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenColReadList", getRspnNmTokenColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenColLocked", getRspnNmTokenColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenColUpdated", getRspnNmTokenColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenColDeleted", getRspnNmTokenColDeletedHandler() );

			// NmTokenDef Response Handlers

			saxDocHandler.addElementHandler( "RspnNmTokenDefCreated", getRspnNmTokenDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenDefReadSingle", getRspnNmTokenDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenDefReadList", getRspnNmTokenDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenDefLocked", getRspnNmTokenDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenDefUpdated", getRspnNmTokenDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenDefDeleted", getRspnNmTokenDefDeletedHandler() );

			// NmTokenType Response Handlers

			saxDocHandler.addElementHandler( "RspnNmTokenTypeCreated", getRspnNmTokenTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenTypeReadSingle", getRspnNmTokenTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenTypeReadList", getRspnNmTokenTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenTypeLocked", getRspnNmTokenTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenTypeUpdated", getRspnNmTokenTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokenTypeDeleted", getRspnNmTokenTypeDeletedHandler() );

			// NmTokensCol Response Handlers

			saxDocHandler.addElementHandler( "RspnNmTokensColCreated", getRspnNmTokensColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensColReadSingle", getRspnNmTokensColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensColReadList", getRspnNmTokensColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensColLocked", getRspnNmTokensColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensColUpdated", getRspnNmTokensColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensColDeleted", getRspnNmTokensColDeletedHandler() );

			// NmTokensDef Response Handlers

			saxDocHandler.addElementHandler( "RspnNmTokensDefCreated", getRspnNmTokensDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensDefReadSingle", getRspnNmTokensDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensDefReadList", getRspnNmTokensDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensDefLocked", getRspnNmTokensDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensDefUpdated", getRspnNmTokensDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensDefDeleted", getRspnNmTokensDefDeletedHandler() );

			// NmTokensType Response Handlers

			saxDocHandler.addElementHandler( "RspnNmTokensTypeCreated", getRspnNmTokensTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensTypeReadSingle", getRspnNmTokensTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensTypeReadList", getRspnNmTokensTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensTypeLocked", getRspnNmTokensTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensTypeUpdated", getRspnNmTokensTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnNmTokensTypeDeleted", getRspnNmTokensTypeDeletedHandler() );

			// NumberCol Response Handlers

			saxDocHandler.addElementHandler( "RspnNumberColCreated", getRspnNumberColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnNumberColReadSingle", getRspnNumberColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnNumberColReadList", getRspnNumberColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnNumberColLocked", getRspnNumberColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnNumberColUpdated", getRspnNumberColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnNumberColDeleted", getRspnNumberColDeletedHandler() );

			// NumberDef Response Handlers

			saxDocHandler.addElementHandler( "RspnNumberDefCreated", getRspnNumberDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnNumberDefReadSingle", getRspnNumberDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnNumberDefReadList", getRspnNumberDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnNumberDefLocked", getRspnNumberDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnNumberDefUpdated", getRspnNumberDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnNumberDefDeleted", getRspnNumberDefDeletedHandler() );

			// NumberType Response Handlers

			saxDocHandler.addElementHandler( "RspnNumberTypeCreated", getRspnNumberTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnNumberTypeReadSingle", getRspnNumberTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnNumberTypeReadList", getRspnNumberTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnNumberTypeLocked", getRspnNumberTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnNumberTypeUpdated", getRspnNumberTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnNumberTypeDeleted", getRspnNumberTypeDeletedHandler() );

			// Param Response Handlers

			saxDocHandler.addElementHandler( "RspnParamCreated", getRspnParamCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnParamReadSingle", getRspnParamReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnParamReadList", getRspnParamReadListHandler() );
			saxDocHandler.addElementHandler( "RspnParamLocked", getRspnParamLockedHandler() );
			saxDocHandler.addElementHandler( "RspnParamUpdated", getRspnParamUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnParamDeleted", getRspnParamDeletedHandler() );

			// PopDep Response Handlers

			saxDocHandler.addElementHandler( "RspnPopDepCreated", getRspnPopDepCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnPopDepReadSingle", getRspnPopDepReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnPopDepReadList", getRspnPopDepReadListHandler() );
			saxDocHandler.addElementHandler( "RspnPopDepLocked", getRspnPopDepLockedHandler() );
			saxDocHandler.addElementHandler( "RspnPopDepUpdated", getRspnPopDepUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnPopDepDeleted", getRspnPopDepDeletedHandler() );

			// PopSubDep1 Response Handlers

			saxDocHandler.addElementHandler( "RspnPopSubDep1Created", getRspnPopSubDep1CreatedHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep1ReadSingle", getRspnPopSubDep1ReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep1ReadList", getRspnPopSubDep1ReadListHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep1Locked", getRspnPopSubDep1LockedHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep1Updated", getRspnPopSubDep1UpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep1Deleted", getRspnPopSubDep1DeletedHandler() );

			// PopSubDep2 Response Handlers

			saxDocHandler.addElementHandler( "RspnPopSubDep2Created", getRspnPopSubDep2CreatedHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep2ReadSingle", getRspnPopSubDep2ReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep2ReadList", getRspnPopSubDep2ReadListHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep2Locked", getRspnPopSubDep2LockedHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep2Updated", getRspnPopSubDep2UpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep2Deleted", getRspnPopSubDep2DeletedHandler() );

			// PopSubDep3 Response Handlers

			saxDocHandler.addElementHandler( "RspnPopSubDep3Created", getRspnPopSubDep3CreatedHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep3ReadSingle", getRspnPopSubDep3ReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep3ReadList", getRspnPopSubDep3ReadListHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep3Locked", getRspnPopSubDep3LockedHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep3Updated", getRspnPopSubDep3UpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnPopSubDep3Deleted", getRspnPopSubDep3DeletedHandler() );

			// PopTopDep Response Handlers

			saxDocHandler.addElementHandler( "RspnPopTopDepCreated", getRspnPopTopDepCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnPopTopDepReadSingle", getRspnPopTopDepReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnPopTopDepReadList", getRspnPopTopDepReadListHandler() );
			saxDocHandler.addElementHandler( "RspnPopTopDepLocked", getRspnPopTopDepLockedHandler() );
			saxDocHandler.addElementHandler( "RspnPopTopDepUpdated", getRspnPopTopDepUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnPopTopDepDeleted", getRspnPopTopDepDeletedHandler() );

			// ProjectBase Response Handlers

			saxDocHandler.addElementHandler( "RspnProjectBaseCreated", getRspnProjectBaseCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnProjectBaseReadSingle", getRspnProjectBaseReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnProjectBaseReadList", getRspnProjectBaseReadListHandler() );
			saxDocHandler.addElementHandler( "RspnProjectBaseLocked", getRspnProjectBaseLockedHandler() );
			saxDocHandler.addElementHandler( "RspnProjectBaseUpdated", getRspnProjectBaseUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnProjectBaseDeleted", getRspnProjectBaseDeletedHandler() );

			// RealProject Response Handlers

			saxDocHandler.addElementHandler( "RspnRealProjectCreated", getRspnRealProjectCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnRealProjectReadSingle", getRspnRealProjectReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnRealProjectReadList", getRspnRealProjectReadListHandler() );
			saxDocHandler.addElementHandler( "RspnRealProjectLocked", getRspnRealProjectLockedHandler() );
			saxDocHandler.addElementHandler( "RspnRealProjectUpdated", getRspnRealProjectUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnRealProjectDeleted", getRspnRealProjectDeletedHandler() );

			// Relation Response Handlers

			saxDocHandler.addElementHandler( "RspnRelationCreated", getRspnRelationCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnRelationReadSingle", getRspnRelationReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnRelationReadList", getRspnRelationReadListHandler() );
			saxDocHandler.addElementHandler( "RspnRelationLocked", getRspnRelationLockedHandler() );
			saxDocHandler.addElementHandler( "RspnRelationUpdated", getRspnRelationUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnRelationDeleted", getRspnRelationDeletedHandler() );

			// RelationCol Response Handlers

			saxDocHandler.addElementHandler( "RspnRelationColCreated", getRspnRelationColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnRelationColReadSingle", getRspnRelationColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnRelationColReadList", getRspnRelationColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnRelationColLocked", getRspnRelationColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnRelationColUpdated", getRspnRelationColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnRelationColDeleted", getRspnRelationColDeletedHandler() );

			// RelationType Response Handlers

			saxDocHandler.addElementHandler( "RspnRelationTypeCreated", getRspnRelationTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnRelationTypeReadSingle", getRspnRelationTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnRelationTypeReadList", getRspnRelationTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnRelationTypeLocked", getRspnRelationTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnRelationTypeUpdated", getRspnRelationTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnRelationTypeDeleted", getRspnRelationTypeDeletedHandler() );

			// SchemaDef Response Handlers

			saxDocHandler.addElementHandler( "RspnSchemaDefCreated", getRspnSchemaDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSchemaDefReadSingle", getRspnSchemaDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSchemaDefReadList", getRspnSchemaDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSchemaDefLocked", getRspnSchemaDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSchemaDefUpdated", getRspnSchemaDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSchemaDefDeleted", getRspnSchemaDefDeletedHandler() );

			// SchemaRef Response Handlers

			saxDocHandler.addElementHandler( "RspnSchemaRefCreated", getRspnSchemaRefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSchemaRefReadSingle", getRspnSchemaRefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSchemaRefReadList", getRspnSchemaRefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSchemaRefLocked", getRspnSchemaRefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSchemaRefUpdated", getRspnSchemaRefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSchemaRefDeleted", getRspnSchemaRefDeletedHandler() );

			// Scope Response Handlers

			saxDocHandler.addElementHandler( "RspnScopeCreated", getRspnScopeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnScopeReadSingle", getRspnScopeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnScopeReadList", getRspnScopeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnScopeLocked", getRspnScopeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnScopeUpdated", getRspnScopeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnScopeDeleted", getRspnScopeDeletedHandler() );

			// SecApp Response Handlers

			saxDocHandler.addElementHandler( "RspnSecAppCreated", getRspnSecAppCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecAppReadSingle", getRspnSecAppReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSecAppReadList", getRspnSecAppReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSecAppLocked", getRspnSecAppLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSecAppUpdated", getRspnSecAppUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecAppDeleted", getRspnSecAppDeletedHandler() );

			// SecDevice Response Handlers

			saxDocHandler.addElementHandler( "RspnSecDeviceCreated", getRspnSecDeviceCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecDeviceReadSingle", getRspnSecDeviceReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSecDeviceReadList", getRspnSecDeviceReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSecDeviceLocked", getRspnSecDeviceLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSecDeviceUpdated", getRspnSecDeviceUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecDeviceDeleted", getRspnSecDeviceDeletedHandler() );

			// SecForm Response Handlers

			saxDocHandler.addElementHandler( "RspnSecFormCreated", getRspnSecFormCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecFormReadSingle", getRspnSecFormReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSecFormReadList", getRspnSecFormReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSecFormLocked", getRspnSecFormLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSecFormUpdated", getRspnSecFormUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecFormDeleted", getRspnSecFormDeletedHandler() );

			// SecGroup Response Handlers

			saxDocHandler.addElementHandler( "RspnSecGroupCreated", getRspnSecGroupCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupReadSingle", getRspnSecGroupReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupReadList", getRspnSecGroupReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupLocked", getRspnSecGroupLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupUpdated", getRspnSecGroupUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupDeleted", getRspnSecGroupDeletedHandler() );

			// SecGroupForm Response Handlers

			saxDocHandler.addElementHandler( "RspnSecGroupFormCreated", getRspnSecGroupFormCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupFormReadSingle", getRspnSecGroupFormReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupFormReadList", getRspnSecGroupFormReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupFormLocked", getRspnSecGroupFormLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupFormUpdated", getRspnSecGroupFormUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupFormDeleted", getRspnSecGroupFormDeletedHandler() );

			// SecGroupInclude Response Handlers

			saxDocHandler.addElementHandler( "RspnSecGroupIncludeCreated", getRspnSecGroupIncludeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupIncludeReadSingle", getRspnSecGroupIncludeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupIncludeReadList", getRspnSecGroupIncludeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupIncludeLocked", getRspnSecGroupIncludeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupIncludeUpdated", getRspnSecGroupIncludeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupIncludeDeleted", getRspnSecGroupIncludeDeletedHandler() );

			// SecGroupMember Response Handlers

			saxDocHandler.addElementHandler( "RspnSecGroupMemberCreated", getRspnSecGroupMemberCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupMemberReadSingle", getRspnSecGroupMemberReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupMemberReadList", getRspnSecGroupMemberReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupMemberLocked", getRspnSecGroupMemberLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupMemberUpdated", getRspnSecGroupMemberUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecGroupMemberDeleted", getRspnSecGroupMemberDeletedHandler() );

			// SecSession Response Handlers

			saxDocHandler.addElementHandler( "RspnSecSessionCreated", getRspnSecSessionCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecSessionReadSingle", getRspnSecSessionReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSecSessionReadList", getRspnSecSessionReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSecSessionLocked", getRspnSecSessionLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSecSessionUpdated", getRspnSecSessionUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecSessionDeleted", getRspnSecSessionDeletedHandler() );

			// SecUser Response Handlers

			saxDocHandler.addElementHandler( "RspnSecUserCreated", getRspnSecUserCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecUserReadSingle", getRspnSecUserReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSecUserReadList", getRspnSecUserReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSecUserLocked", getRspnSecUserLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSecUserUpdated", getRspnSecUserUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecUserDeleted", getRspnSecUserDeletedHandler() );

			// SecurityScope Response Handlers

			saxDocHandler.addElementHandler( "RspnSecurityScopeCreated", getRspnSecurityScopeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecurityScopeReadSingle", getRspnSecurityScopeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSecurityScopeReadList", getRspnSecurityScopeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSecurityScopeLocked", getRspnSecurityScopeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSecurityScopeUpdated", getRspnSecurityScopeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSecurityScopeDeleted", getRspnSecurityScopeDeletedHandler() );

			// ServerListFunc Response Handlers

			saxDocHandler.addElementHandler( "RspnServerListFuncCreated", getRspnServerListFuncCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnServerListFuncReadSingle", getRspnServerListFuncReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnServerListFuncReadList", getRspnServerListFuncReadListHandler() );
			saxDocHandler.addElementHandler( "RspnServerListFuncLocked", getRspnServerListFuncLockedHandler() );
			saxDocHandler.addElementHandler( "RspnServerListFuncUpdated", getRspnServerListFuncUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnServerListFuncDeleted", getRspnServerListFuncDeletedHandler() );

			// ServerMethod Response Handlers

			saxDocHandler.addElementHandler( "RspnServerMethodCreated", getRspnServerMethodCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnServerMethodReadSingle", getRspnServerMethodReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnServerMethodReadList", getRspnServerMethodReadListHandler() );
			saxDocHandler.addElementHandler( "RspnServerMethodLocked", getRspnServerMethodLockedHandler() );
			saxDocHandler.addElementHandler( "RspnServerMethodUpdated", getRspnServerMethodUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnServerMethodDeleted", getRspnServerMethodDeletedHandler() );

			// ServerObjFunc Response Handlers

			saxDocHandler.addElementHandler( "RspnServerObjFuncCreated", getRspnServerObjFuncCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnServerObjFuncReadSingle", getRspnServerObjFuncReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnServerObjFuncReadList", getRspnServerObjFuncReadListHandler() );
			saxDocHandler.addElementHandler( "RspnServerObjFuncLocked", getRspnServerObjFuncLockedHandler() );
			saxDocHandler.addElementHandler( "RspnServerObjFuncUpdated", getRspnServerObjFuncUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnServerObjFuncDeleted", getRspnServerObjFuncDeletedHandler() );

			// ServerProc Response Handlers

			saxDocHandler.addElementHandler( "RspnServerProcCreated", getRspnServerProcCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnServerProcReadSingle", getRspnServerProcReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnServerProcReadList", getRspnServerProcReadListHandler() );
			saxDocHandler.addElementHandler( "RspnServerProcLocked", getRspnServerProcLockedHandler() );
			saxDocHandler.addElementHandler( "RspnServerProcUpdated", getRspnServerProcUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnServerProcDeleted", getRspnServerProcDeletedHandler() );

			// Service Response Handlers

			saxDocHandler.addElementHandler( "RspnServiceCreated", getRspnServiceCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnServiceReadSingle", getRspnServiceReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnServiceReadList", getRspnServiceReadListHandler() );
			saxDocHandler.addElementHandler( "RspnServiceLocked", getRspnServiceLockedHandler() );
			saxDocHandler.addElementHandler( "RspnServiceUpdated", getRspnServiceUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnServiceDeleted", getRspnServiceDeletedHandler() );

			// ServiceType Response Handlers

			saxDocHandler.addElementHandler( "RspnServiceTypeCreated", getRspnServiceTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnServiceTypeReadSingle", getRspnServiceTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnServiceTypeReadList", getRspnServiceTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnServiceTypeLocked", getRspnServiceTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnServiceTypeUpdated", getRspnServiceTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnServiceTypeDeleted", getRspnServiceTypeDeletedHandler() );

			// StringCol Response Handlers

			saxDocHandler.addElementHandler( "RspnStringColCreated", getRspnStringColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnStringColReadSingle", getRspnStringColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnStringColReadList", getRspnStringColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnStringColLocked", getRspnStringColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnStringColUpdated", getRspnStringColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnStringColDeleted", getRspnStringColDeletedHandler() );

			// StringDef Response Handlers

			saxDocHandler.addElementHandler( "RspnStringDefCreated", getRspnStringDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnStringDefReadSingle", getRspnStringDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnStringDefReadList", getRspnStringDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnStringDefLocked", getRspnStringDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnStringDefUpdated", getRspnStringDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnStringDefDeleted", getRspnStringDefDeletedHandler() );

			// StringType Response Handlers

			saxDocHandler.addElementHandler( "RspnStringTypeCreated", getRspnStringTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnStringTypeReadSingle", getRspnStringTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnStringTypeReadList", getRspnStringTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnStringTypeLocked", getRspnStringTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnStringTypeUpdated", getRspnStringTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnStringTypeDeleted", getRspnStringTypeDeletedHandler() );

			// SubProject Response Handlers

			saxDocHandler.addElementHandler( "RspnSubProjectCreated", getRspnSubProjectCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSubProjectReadSingle", getRspnSubProjectReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSubProjectReadList", getRspnSubProjectReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSubProjectLocked", getRspnSubProjectLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSubProjectUpdated", getRspnSubProjectUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSubProjectDeleted", getRspnSubProjectDeletedHandler() );

			// SysCluster Response Handlers

			saxDocHandler.addElementHandler( "RspnSysClusterCreated", getRspnSysClusterCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnSysClusterReadSingle", getRspnSysClusterReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnSysClusterReadList", getRspnSysClusterReadListHandler() );
			saxDocHandler.addElementHandler( "RspnSysClusterLocked", getRspnSysClusterLockedHandler() );
			saxDocHandler.addElementHandler( "RspnSysClusterUpdated", getRspnSysClusterUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnSysClusterDeleted", getRspnSysClusterDeletedHandler() );

			// TSecGroup Response Handlers

			saxDocHandler.addElementHandler( "RspnTSecGroupCreated", getRspnTSecGroupCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupReadSingle", getRspnTSecGroupReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupReadList", getRspnTSecGroupReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupLocked", getRspnTSecGroupLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupUpdated", getRspnTSecGroupUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupDeleted", getRspnTSecGroupDeletedHandler() );

			// TSecGroupInclude Response Handlers

			saxDocHandler.addElementHandler( "RspnTSecGroupIncludeCreated", getRspnTSecGroupIncludeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupIncludeReadSingle", getRspnTSecGroupIncludeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupIncludeReadList", getRspnTSecGroupIncludeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupIncludeLocked", getRspnTSecGroupIncludeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupIncludeUpdated", getRspnTSecGroupIncludeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupIncludeDeleted", getRspnTSecGroupIncludeDeletedHandler() );

			// TSecGroupMember Response Handlers

			saxDocHandler.addElementHandler( "RspnTSecGroupMemberCreated", getRspnTSecGroupMemberCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupMemberReadSingle", getRspnTSecGroupMemberReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupMemberReadList", getRspnTSecGroupMemberReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupMemberLocked", getRspnTSecGroupMemberLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupMemberUpdated", getRspnTSecGroupMemberUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTSecGroupMemberDeleted", getRspnTSecGroupMemberDeletedHandler() );

			// TZDateCol Response Handlers

			saxDocHandler.addElementHandler( "RspnTZDateColCreated", getRspnTZDateColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateColReadSingle", getRspnTZDateColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateColReadList", getRspnTZDateColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateColLocked", getRspnTZDateColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateColUpdated", getRspnTZDateColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateColDeleted", getRspnTZDateColDeletedHandler() );

			// TZDateDef Response Handlers

			saxDocHandler.addElementHandler( "RspnTZDateDefCreated", getRspnTZDateDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateDefReadSingle", getRspnTZDateDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateDefReadList", getRspnTZDateDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateDefLocked", getRspnTZDateDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateDefUpdated", getRspnTZDateDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateDefDeleted", getRspnTZDateDefDeletedHandler() );

			// TZDateType Response Handlers

			saxDocHandler.addElementHandler( "RspnTZDateTypeCreated", getRspnTZDateTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateTypeReadSingle", getRspnTZDateTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateTypeReadList", getRspnTZDateTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateTypeLocked", getRspnTZDateTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateTypeUpdated", getRspnTZDateTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZDateTypeDeleted", getRspnTZDateTypeDeletedHandler() );

			// TZTimeCol Response Handlers

			saxDocHandler.addElementHandler( "RspnTZTimeColCreated", getRspnTZTimeColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeColReadSingle", getRspnTZTimeColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeColReadList", getRspnTZTimeColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeColLocked", getRspnTZTimeColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeColUpdated", getRspnTZTimeColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeColDeleted", getRspnTZTimeColDeletedHandler() );

			// TZTimeDef Response Handlers

			saxDocHandler.addElementHandler( "RspnTZTimeDefCreated", getRspnTZTimeDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeDefReadSingle", getRspnTZTimeDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeDefReadList", getRspnTZTimeDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeDefLocked", getRspnTZTimeDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeDefUpdated", getRspnTZTimeDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeDefDeleted", getRspnTZTimeDefDeletedHandler() );

			// TZTimeType Response Handlers

			saxDocHandler.addElementHandler( "RspnTZTimeTypeCreated", getRspnTZTimeTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeTypeReadSingle", getRspnTZTimeTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeTypeReadList", getRspnTZTimeTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeTypeLocked", getRspnTZTimeTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeTypeUpdated", getRspnTZTimeTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimeTypeDeleted", getRspnTZTimeTypeDeletedHandler() );

			// TZTimestampCol Response Handlers

			saxDocHandler.addElementHandler( "RspnTZTimestampColCreated", getRspnTZTimestampColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampColReadSingle", getRspnTZTimestampColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampColReadList", getRspnTZTimestampColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampColLocked", getRspnTZTimestampColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampColUpdated", getRspnTZTimestampColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampColDeleted", getRspnTZTimestampColDeletedHandler() );

			// TZTimestampDef Response Handlers

			saxDocHandler.addElementHandler( "RspnTZTimestampDefCreated", getRspnTZTimestampDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampDefReadSingle", getRspnTZTimestampDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampDefReadList", getRspnTZTimestampDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampDefLocked", getRspnTZTimestampDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampDefUpdated", getRspnTZTimestampDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampDefDeleted", getRspnTZTimestampDefDeletedHandler() );

			// TZTimestampType Response Handlers

			saxDocHandler.addElementHandler( "RspnTZTimestampTypeCreated", getRspnTZTimestampTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampTypeReadSingle", getRspnTZTimestampTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampTypeReadList", getRspnTZTimestampTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampTypeLocked", getRspnTZTimestampTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampTypeUpdated", getRspnTZTimestampTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTZTimestampTypeDeleted", getRspnTZTimestampTypeDeletedHandler() );

			// Table Response Handlers

			saxDocHandler.addElementHandler( "RspnTableCreated", getRspnTableCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTableReadSingle", getRspnTableReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTableReadList", getRspnTableReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTableLocked", getRspnTableLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTableUpdated", getRspnTableUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTableDeleted", getRspnTableDeletedHandler() );

			// TableCol Response Handlers

			saxDocHandler.addElementHandler( "RspnTableColCreated", getRspnTableColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTableColReadSingle", getRspnTableColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTableColReadList", getRspnTableColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTableColLocked", getRspnTableColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTableColUpdated", getRspnTableColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTableColDeleted", getRspnTableColDeletedHandler() );

			// Tenant Response Handlers

			saxDocHandler.addElementHandler( "RspnTenantCreated", getRspnTenantCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTenantReadSingle", getRspnTenantReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTenantReadList", getRspnTenantReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTenantLocked", getRspnTenantLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTenantUpdated", getRspnTenantUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTenantDeleted", getRspnTenantDeletedHandler() );

			// TextCol Response Handlers

			saxDocHandler.addElementHandler( "RspnTextColCreated", getRspnTextColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTextColReadSingle", getRspnTextColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTextColReadList", getRspnTextColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTextColLocked", getRspnTextColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTextColUpdated", getRspnTextColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTextColDeleted", getRspnTextColDeletedHandler() );

			// TextDef Response Handlers

			saxDocHandler.addElementHandler( "RspnTextDefCreated", getRspnTextDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTextDefReadSingle", getRspnTextDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTextDefReadList", getRspnTextDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTextDefLocked", getRspnTextDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTextDefUpdated", getRspnTextDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTextDefDeleted", getRspnTextDefDeletedHandler() );

			// TextType Response Handlers

			saxDocHandler.addElementHandler( "RspnTextTypeCreated", getRspnTextTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTextTypeReadSingle", getRspnTextTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTextTypeReadList", getRspnTextTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTextTypeLocked", getRspnTextTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTextTypeUpdated", getRspnTextTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTextTypeDeleted", getRspnTextTypeDeletedHandler() );

			// TimeCol Response Handlers

			saxDocHandler.addElementHandler( "RspnTimeColCreated", getRspnTimeColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimeColReadSingle", getRspnTimeColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTimeColReadList", getRspnTimeColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTimeColLocked", getRspnTimeColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTimeColUpdated", getRspnTimeColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimeColDeleted", getRspnTimeColDeletedHandler() );

			// TimeDef Response Handlers

			saxDocHandler.addElementHandler( "RspnTimeDefCreated", getRspnTimeDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimeDefReadSingle", getRspnTimeDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTimeDefReadList", getRspnTimeDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTimeDefLocked", getRspnTimeDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTimeDefUpdated", getRspnTimeDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimeDefDeleted", getRspnTimeDefDeletedHandler() );

			// TimeType Response Handlers

			saxDocHandler.addElementHandler( "RspnTimeTypeCreated", getRspnTimeTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimeTypeReadSingle", getRspnTimeTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTimeTypeReadList", getRspnTimeTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTimeTypeLocked", getRspnTimeTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTimeTypeUpdated", getRspnTimeTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimeTypeDeleted", getRspnTimeTypeDeletedHandler() );

			// TimestampCol Response Handlers

			saxDocHandler.addElementHandler( "RspnTimestampColCreated", getRspnTimestampColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampColReadSingle", getRspnTimestampColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampColReadList", getRspnTimestampColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampColLocked", getRspnTimestampColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampColUpdated", getRspnTimestampColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampColDeleted", getRspnTimestampColDeletedHandler() );

			// TimestampDef Response Handlers

			saxDocHandler.addElementHandler( "RspnTimestampDefCreated", getRspnTimestampDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampDefReadSingle", getRspnTimestampDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampDefReadList", getRspnTimestampDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampDefLocked", getRspnTimestampDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampDefUpdated", getRspnTimestampDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampDefDeleted", getRspnTimestampDefDeletedHandler() );

			// TimestampType Response Handlers

			saxDocHandler.addElementHandler( "RspnTimestampTypeCreated", getRspnTimestampTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampTypeReadSingle", getRspnTimestampTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampTypeReadList", getRspnTimestampTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampTypeLocked", getRspnTimestampTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampTypeUpdated", getRspnTimestampTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTimestampTypeDeleted", getRspnTimestampTypeDeletedHandler() );

			// Tld Response Handlers

			saxDocHandler.addElementHandler( "RspnTldCreated", getRspnTldCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTldReadSingle", getRspnTldReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTldReadList", getRspnTldReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTldLocked", getRspnTldLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTldUpdated", getRspnTldUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTldDeleted", getRspnTldDeletedHandler() );

			// TokenCol Response Handlers

			saxDocHandler.addElementHandler( "RspnTokenColCreated", getRspnTokenColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTokenColReadSingle", getRspnTokenColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTokenColReadList", getRspnTokenColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTokenColLocked", getRspnTokenColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTokenColUpdated", getRspnTokenColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTokenColDeleted", getRspnTokenColDeletedHandler() );

			// TokenDef Response Handlers

			saxDocHandler.addElementHandler( "RspnTokenDefCreated", getRspnTokenDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTokenDefReadSingle", getRspnTokenDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTokenDefReadList", getRspnTokenDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTokenDefLocked", getRspnTokenDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTokenDefUpdated", getRspnTokenDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTokenDefDeleted", getRspnTokenDefDeletedHandler() );

			// TokenType Response Handlers

			saxDocHandler.addElementHandler( "RspnTokenTypeCreated", getRspnTokenTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTokenTypeReadSingle", getRspnTokenTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTokenTypeReadList", getRspnTokenTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTokenTypeLocked", getRspnTokenTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTokenTypeUpdated", getRspnTokenTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTokenTypeDeleted", getRspnTokenTypeDeletedHandler() );

			// TopDomain Response Handlers

			saxDocHandler.addElementHandler( "RspnTopDomainCreated", getRspnTopDomainCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTopDomainReadSingle", getRspnTopDomainReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTopDomainReadList", getRspnTopDomainReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTopDomainLocked", getRspnTopDomainLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTopDomainUpdated", getRspnTopDomainUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTopDomainDeleted", getRspnTopDomainDeletedHandler() );

			// TopProject Response Handlers

			saxDocHandler.addElementHandler( "RspnTopProjectCreated", getRspnTopProjectCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnTopProjectReadSingle", getRspnTopProjectReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnTopProjectReadList", getRspnTopProjectReadListHandler() );
			saxDocHandler.addElementHandler( "RspnTopProjectLocked", getRspnTopProjectLockedHandler() );
			saxDocHandler.addElementHandler( "RspnTopProjectUpdated", getRspnTopProjectUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnTopProjectDeleted", getRspnTopProjectDeletedHandler() );

			// UInt16Col Response Handlers

			saxDocHandler.addElementHandler( "RspnUInt16ColCreated", getRspnUInt16ColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16ColReadSingle", getRspnUInt16ColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16ColReadList", getRspnUInt16ColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16ColLocked", getRspnUInt16ColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16ColUpdated", getRspnUInt16ColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16ColDeleted", getRspnUInt16ColDeletedHandler() );

			// UInt16Def Response Handlers

			saxDocHandler.addElementHandler( "RspnUInt16DefCreated", getRspnUInt16DefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16DefReadSingle", getRspnUInt16DefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16DefReadList", getRspnUInt16DefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16DefLocked", getRspnUInt16DefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16DefUpdated", getRspnUInt16DefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16DefDeleted", getRspnUInt16DefDeletedHandler() );

			// UInt16Type Response Handlers

			saxDocHandler.addElementHandler( "RspnUInt16TypeCreated", getRspnUInt16TypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16TypeReadSingle", getRspnUInt16TypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16TypeReadList", getRspnUInt16TypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16TypeLocked", getRspnUInt16TypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16TypeUpdated", getRspnUInt16TypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt16TypeDeleted", getRspnUInt16TypeDeletedHandler() );

			// UInt32Col Response Handlers

			saxDocHandler.addElementHandler( "RspnUInt32ColCreated", getRspnUInt32ColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32ColReadSingle", getRspnUInt32ColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32ColReadList", getRspnUInt32ColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32ColLocked", getRspnUInt32ColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32ColUpdated", getRspnUInt32ColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32ColDeleted", getRspnUInt32ColDeletedHandler() );

			// UInt32Def Response Handlers

			saxDocHandler.addElementHandler( "RspnUInt32DefCreated", getRspnUInt32DefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32DefReadSingle", getRspnUInt32DefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32DefReadList", getRspnUInt32DefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32DefLocked", getRspnUInt32DefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32DefUpdated", getRspnUInt32DefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32DefDeleted", getRspnUInt32DefDeletedHandler() );

			// UInt32Type Response Handlers

			saxDocHandler.addElementHandler( "RspnUInt32TypeCreated", getRspnUInt32TypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32TypeReadSingle", getRspnUInt32TypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32TypeReadList", getRspnUInt32TypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32TypeLocked", getRspnUInt32TypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32TypeUpdated", getRspnUInt32TypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt32TypeDeleted", getRspnUInt32TypeDeletedHandler() );

			// UInt64Col Response Handlers

			saxDocHandler.addElementHandler( "RspnUInt64ColCreated", getRspnUInt64ColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64ColReadSingle", getRspnUInt64ColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64ColReadList", getRspnUInt64ColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64ColLocked", getRspnUInt64ColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64ColUpdated", getRspnUInt64ColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64ColDeleted", getRspnUInt64ColDeletedHandler() );

			// UInt64Def Response Handlers

			saxDocHandler.addElementHandler( "RspnUInt64DefCreated", getRspnUInt64DefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64DefReadSingle", getRspnUInt64DefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64DefReadList", getRspnUInt64DefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64DefLocked", getRspnUInt64DefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64DefUpdated", getRspnUInt64DefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64DefDeleted", getRspnUInt64DefDeletedHandler() );

			// UInt64Type Response Handlers

			saxDocHandler.addElementHandler( "RspnUInt64TypeCreated", getRspnUInt64TypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64TypeReadSingle", getRspnUInt64TypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64TypeReadList", getRspnUInt64TypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64TypeLocked", getRspnUInt64TypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64TypeUpdated", getRspnUInt64TypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUInt64TypeDeleted", getRspnUInt64TypeDeletedHandler() );

			// URLProtocol Response Handlers

			saxDocHandler.addElementHandler( "RspnURLProtocolCreated", getRspnURLProtocolCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnURLProtocolReadSingle", getRspnURLProtocolReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnURLProtocolReadList", getRspnURLProtocolReadListHandler() );
			saxDocHandler.addElementHandler( "RspnURLProtocolLocked", getRspnURLProtocolLockedHandler() );
			saxDocHandler.addElementHandler( "RspnURLProtocolUpdated", getRspnURLProtocolUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnURLProtocolDeleted", getRspnURLProtocolDeletedHandler() );

			// UuidCol Response Handlers

			saxDocHandler.addElementHandler( "RspnUuidColCreated", getRspnUuidColCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidColReadSingle", getRspnUuidColReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUuidColReadList", getRspnUuidColReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUuidColLocked", getRspnUuidColLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidColUpdated", getRspnUuidColUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidColDeleted", getRspnUuidColDeletedHandler() );

			// UuidDef Response Handlers

			saxDocHandler.addElementHandler( "RspnUuidDefCreated", getRspnUuidDefCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidDefReadSingle", getRspnUuidDefReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUuidDefReadList", getRspnUuidDefReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUuidDefLocked", getRspnUuidDefLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidDefUpdated", getRspnUuidDefUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidDefDeleted", getRspnUuidDefDeletedHandler() );

			// UuidGen Response Handlers

			saxDocHandler.addElementHandler( "RspnUuidGenCreated", getRspnUuidGenCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidGenReadSingle", getRspnUuidGenReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUuidGenReadList", getRspnUuidGenReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUuidGenLocked", getRspnUuidGenLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidGenUpdated", getRspnUuidGenUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidGenDeleted", getRspnUuidGenDeletedHandler() );

			// UuidType Response Handlers

			saxDocHandler.addElementHandler( "RspnUuidTypeCreated", getRspnUuidTypeCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidTypeReadSingle", getRspnUuidTypeReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnUuidTypeReadList", getRspnUuidTypeReadListHandler() );
			saxDocHandler.addElementHandler( "RspnUuidTypeLocked", getRspnUuidTypeLockedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidTypeUpdated", getRspnUuidTypeUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnUuidTypeDeleted", getRspnUuidTypeDeletedHandler() );

			// Value Response Handlers

			saxDocHandler.addElementHandler( "RspnValueCreated", getRspnValueCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnValueReadSingle", getRspnValueReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnValueReadList", getRspnValueReadListHandler() );
			saxDocHandler.addElementHandler( "RspnValueLocked", getRspnValueLockedHandler() );
			saxDocHandler.addElementHandler( "RspnValueUpdated", getRspnValueUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnValueDeleted", getRspnValueDeletedHandler() );

			// Version Response Handlers

			saxDocHandler.addElementHandler( "RspnVersionCreated", getRspnVersionCreatedHandler() );
			saxDocHandler.addElementHandler( "RspnVersionReadSingle", getRspnVersionReadSingleHandler() );
			saxDocHandler.addElementHandler( "RspnVersionReadList", getRspnVersionReadListHandler() );
			saxDocHandler.addElementHandler( "RspnVersionLocked", getRspnVersionLockedHandler() );
			saxDocHandler.addElementHandler( "RspnVersionUpdated", getRspnVersionUpdatedHandler() );
			saxDocHandler.addElementHandler( "RspnVersionDeleted", getRspnVersionDeletedHandler() );

		}
		return( saxDocHandler );
	}

	// Document Element Handler

	/*
	 *	CFBamSaxRspnDocHandler XML SAX Doc Element Handler implementation
	 */
	public class CFBamSaxRspnDocHandler
		extends CFLibXmlCoreElementHandler
	{
		public CFBamSaxRspnDocHandler( CFBamXMsgRspnHandler xmsgRspnHandler ) {
			super( xmsgRspnHandler );
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

	// Parse an XML string's contents

	public void parseStringContents( String str ) {
		deleted = false;
		exceptionRaised = null;
		lastObjectProcessed = null;
		sortedListOfObjects = null;
		logContents = null;
		dataChanged = false;
		super.parseStringContents( str );
	}

	// Parse a file

	public void parse( String url ) {
		deleted = false;
		exceptionRaised = null;
		lastObjectProcessed = null;
		sortedListOfObjects = null;
		logContents = null;
		dataChanged = false;
		super.parse( url );
	}

	public void parseFile( String url ) {
		deleted = false;
		exceptionRaised = null;
		lastObjectProcessed = null;
		sortedListOfObjects = null;
		logContents = null;
		dataChanged = false;
		super.parse( url );
	}
}
