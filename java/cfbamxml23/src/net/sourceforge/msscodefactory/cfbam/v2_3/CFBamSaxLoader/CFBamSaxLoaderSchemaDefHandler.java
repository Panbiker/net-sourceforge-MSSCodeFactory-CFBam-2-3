
// Description: Java 7 XML SAX Element Handler for SchemaDef

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

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/*
 *	CFBamSaxLoaderSchemaDefParse XML SAX Element Handler implementation
 *	for SchemaDef.
 */
public class CFBamSaxLoaderSchemaDefHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamSaxLoaderSchemaDefHandler( CFBamSaxLoader saxLoader ) {
		super( saxLoader );
	}

	public void startElement(
		String		uri,
		String		localName,
		String		qName,
		Attributes	attrs )
	throws SAXException
	{
		try {
			// Common XML Attributes
			String	attrId = null;
			// Scope Attributes
			// Scope References
			ICFBamTenantObj refTenant = null;
			// SchemaDef Attributes
			String	attrName = null;
			String	attrDbName = null;
			String	attrShortName = null;
			String	attrLabel = null;
			String	attrShortDescription = null;
			String	attrDescription = null;
			String	attrExtendCFCore = null;
			String	attrCopyrightPeriod = null;
			String	attrCopyrightHolder = null;
			String	attrPublishURI = null;
			String	attrJSchemaObjImport = null;
			String	attrJSchemaObjInterface = null;
			String	attrJSchemaObjMembers = null;
			String	attrJSchemaObjImplementation = null;
			String	attrJDb2LUWSchemaObjMembers = null;
			String	attrJDb2LUWSchemaObjImpl = null;
			String	attrJDb2LUWSchemaObjImport = null;
			String	attrJMSSqlSchemaObjMembers = null;
			String	attrJMSSqlSchemaObjImpl = null;
			String	attrJMSSqlSchemaObjImport = null;
			String	attrJMySqlSchemaObjMembers = null;
			String	attrJMySqlSchemaObjImpl = null;
			String	attrJMySqlSchemaObjImport = null;
			String	attrJOracleSchemaObjMembers = null;
			String	attrJOracleSchemaObjImpl = null;
			String	attrJOracleSchemaObjImport = null;
			String	attrJPgSqlSchemaObjMembers = null;
			String	attrJPgSqlSchemaObjImpl = null;
			String	attrJPgSqlSchemaObjImport = null;
			String	attrJSybaseSchemaObjMembers = null;
			String	attrJSybaseSchemaObjImpl = null;
			String	attrJSybaseSchemaObjImport = null;
			String	attrJRamSchemaObjMembers = null;
			String	attrJRamSchemaObjImpl = null;
			String	attrJRamSchemaObjImport = null;
			String	attrJXMsgSchemaImport = null;
			String	attrJXMsgSchemaFormatters = null;
			String	attrJXMsgClientSchemaImport = null;
			String	attrJXMsgClientSchemaBody = null;
			String	attrJXMsgRqstSchemaBody = null;
			String	attrJXMsgRqstSchemaImport = null;
			String	attrJXMsgRqstSchemaWireParsers = null;
			String	attrJXMsgRqstSchemaXsdSpec = null;
			String	attrJXMsgRqstSchemaXsdElementList = null;
			String	attrJXMsgRspnSchemaBody = null;
			String	attrJXMsgRspnSchemaImport = null;
			String	attrJXMsgRspnSchemaWireParsers = null;
			String	attrJXMsgRspnSchemaXsdElementList = null;
			String	attrJXMsgRspnSchemaXsdSpec = null;
			String	attrDefaultLicense = null;
			String	attrDataScope = null;
			String	attrVAccSec = null;
			String	attrEAccSec = null;
			String	attrVAccFreq = null;
			String	attrEAccFreq = null;
			// SchemaDef References
			ICFBamDomainBaseObj refDomain = null;
			ICFBamTenantObj refCTenant = null;
			ICFBamLicenseObj refDefaultLicense = null;
			ICFBamDataScopeObj refDataScope = null;
			ICFBamAccessSecurityObj refVAccSec = null;
			ICFBamAccessSecurityObj refEAccSec = null;
			ICFBamAccessFrequencyObj refVAccFreq = null;
			ICFBamAccessFrequencyObj refEAccFreq = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "SchemaDef" );

			CFBamSaxLoader saxLoader = (CFBamSaxLoader)getParser();
			if( saxLoader == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			ICFBamSchemaObj schemaObj = saxLoader.getSchemaObj();
			if( schemaObj == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser().getSchemaObj()" );
			}

			// Instantiate an edit buffer for the parsed information
			ICFBamSchemaDefEditObj editBuff = (ICFBamSchemaDefEditObj)schemaObj.getSchemaDefTableObj().newInstance().beginEdit();

			// Extract Attributes
			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Id" ) ) {
					if( attrId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Name" ) ) {
					if( attrName != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DbName" ) ) {
					if( attrDbName != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDbName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ShortName" ) ) {
					if( attrShortName != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrShortName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Label" ) ) {
					if( attrLabel != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLabel = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ShortDescription" ) ) {
					if( attrShortDescription != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrShortDescription = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Description" ) ) {
					if( attrDescription != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDescription = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ExtendCFCore" ) ) {
					if( attrExtendCFCore != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrExtendCFCore = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CopyrightPeriod" ) ) {
					if( attrCopyrightPeriod != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCopyrightPeriod = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CopyrightHolder" ) ) {
					if( attrCopyrightHolder != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCopyrightHolder = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PublishURI" ) ) {
					if( attrPublishURI != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPublishURI = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSchemaObjImport" ) ) {
					if( attrJSchemaObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSchemaObjInterface" ) ) {
					if( attrJSchemaObjInterface != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSchemaObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSchemaObjMembers" ) ) {
					if( attrJSchemaObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSchemaObjImplementation" ) ) {
					if( attrJSchemaObjImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSchemaObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWSchemaObjMembers" ) ) {
					if( attrJDb2LUWSchemaObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWSchemaObjImpl" ) ) {
					if( attrJDb2LUWSchemaObjImpl != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWSchemaObjImport" ) ) {
					if( attrJDb2LUWSchemaObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlSchemaObjMembers" ) ) {
					if( attrJMSSqlSchemaObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlSchemaObjImpl" ) ) {
					if( attrJMSSqlSchemaObjImpl != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlSchemaObjImport" ) ) {
					if( attrJMSSqlSchemaObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlSchemaObjMembers" ) ) {
					if( attrJMySqlSchemaObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlSchemaObjImpl" ) ) {
					if( attrJMySqlSchemaObjImpl != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlSchemaObjImport" ) ) {
					if( attrJMySqlSchemaObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleSchemaObjMembers" ) ) {
					if( attrJOracleSchemaObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleSchemaObjImpl" ) ) {
					if( attrJOracleSchemaObjImpl != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleSchemaObjImport" ) ) {
					if( attrJOracleSchemaObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlSchemaObjMembers" ) ) {
					if( attrJPgSqlSchemaObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlSchemaObjImpl" ) ) {
					if( attrJPgSqlSchemaObjImpl != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlSchemaObjImport" ) ) {
					if( attrJPgSqlSchemaObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSybaseSchemaObjMembers" ) ) {
					if( attrJSybaseSchemaObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSybaseSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSybaseSchemaObjImpl" ) ) {
					if( attrJSybaseSchemaObjImpl != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSybaseSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSybaseSchemaObjImport" ) ) {
					if( attrJSybaseSchemaObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSybaseSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamSchemaObjMembers" ) ) {
					if( attrJRamSchemaObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamSchemaObjImpl" ) ) {
					if( attrJRamSchemaObjImpl != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamSchemaObjImport" ) ) {
					if( attrJRamSchemaObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgSchemaImport" ) ) {
					if( attrJXMsgSchemaImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgSchemaImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgSchemaFormatters" ) ) {
					if( attrJXMsgSchemaFormatters != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgSchemaFormatters = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgClientSchemaImport" ) ) {
					if( attrJXMsgClientSchemaImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgClientSchemaImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgClientSchemaBody" ) ) {
					if( attrJXMsgClientSchemaBody != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgClientSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstSchemaBody" ) ) {
					if( attrJXMsgRqstSchemaBody != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstSchemaImport" ) ) {
					if( attrJXMsgRqstSchemaImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstSchemaImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstSchemaWireParsers" ) ) {
					if( attrJXMsgRqstSchemaWireParsers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstSchemaWireParsers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstSchemaXsdSpec" ) ) {
					if( attrJXMsgRqstSchemaXsdSpec != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstSchemaXsdSpec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstSchemaXsdElementList" ) ) {
					if( attrJXMsgRqstSchemaXsdElementList != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstSchemaXsdElementList = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnSchemaBody" ) ) {
					if( attrJXMsgRspnSchemaBody != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnSchemaImport" ) ) {
					if( attrJXMsgRspnSchemaImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnSchemaImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnSchemaWireParsers" ) ) {
					if( attrJXMsgRspnSchemaWireParsers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnSchemaWireParsers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnSchemaXsdElementList" ) ) {
					if( attrJXMsgRspnSchemaXsdElementList != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnSchemaXsdElementList = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnSchemaXsdSpec" ) ) {
					if( attrJXMsgRspnSchemaXsdSpec != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnSchemaXsdSpec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefaultLicense" ) ) {
					if( attrDefaultLicense != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefaultLicense = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DataScope" ) ) {
					if( attrDataScope != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDataScope = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "VAccSec" ) ) {
					if( attrVAccSec != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrVAccSec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "EAccSec" ) ) {
					if( attrEAccSec != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrEAccSec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "VAccFreq" ) ) {
					if( attrVAccFreq != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrVAccFreq = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "EAccFreq" ) ) {
					if( attrEAccFreq != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrEAccFreq = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newUnrecognizedAttributeException( getClass(),
						S_ProcName,
						getParser().getLocationInfo(),
						attrLocalName );
				}
			}

			// Ensure that required attributes have values
			if( attrName == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Name" );
			}
			if( ( attrExtendCFCore == null ) || ( attrExtendCFCore.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ExtendCFCore" );
			}
			if( attrCopyrightPeriod == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"CopyrightPeriod" );
			}
			if( attrCopyrightHolder == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"CopyrightHolder" );
			}
			if( attrPublishURI == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"PublishURI" );
			}

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "DbName", attrDbName );
			curContext.putNamedValue( "ShortName", attrShortName );
			curContext.putNamedValue( "Label", attrLabel );
			curContext.putNamedValue( "ShortDescription", attrShortDescription );
			curContext.putNamedValue( "Description", attrDescription );
			curContext.putNamedValue( "ExtendCFCore", attrExtendCFCore );
			curContext.putNamedValue( "CopyrightPeriod", attrCopyrightPeriod );
			curContext.putNamedValue( "CopyrightHolder", attrCopyrightHolder );
			curContext.putNamedValue( "PublishURI", attrPublishURI );
			curContext.putNamedValue( "JSchemaObjImport", attrJSchemaObjImport );
			curContext.putNamedValue( "JSchemaObjInterface", attrJSchemaObjInterface );
			curContext.putNamedValue( "JSchemaObjMembers", attrJSchemaObjMembers );
			curContext.putNamedValue( "JSchemaObjImplementation", attrJSchemaObjImplementation );
			curContext.putNamedValue( "JDb2LUWSchemaObjMembers", attrJDb2LUWSchemaObjMembers );
			curContext.putNamedValue( "JDb2LUWSchemaObjImpl", attrJDb2LUWSchemaObjImpl );
			curContext.putNamedValue( "JDb2LUWSchemaObjImport", attrJDb2LUWSchemaObjImport );
			curContext.putNamedValue( "JMSSqlSchemaObjMembers", attrJMSSqlSchemaObjMembers );
			curContext.putNamedValue( "JMSSqlSchemaObjImpl", attrJMSSqlSchemaObjImpl );
			curContext.putNamedValue( "JMSSqlSchemaObjImport", attrJMSSqlSchemaObjImport );
			curContext.putNamedValue( "JMySqlSchemaObjMembers", attrJMySqlSchemaObjMembers );
			curContext.putNamedValue( "JMySqlSchemaObjImpl", attrJMySqlSchemaObjImpl );
			curContext.putNamedValue( "JMySqlSchemaObjImport", attrJMySqlSchemaObjImport );
			curContext.putNamedValue( "JOracleSchemaObjMembers", attrJOracleSchemaObjMembers );
			curContext.putNamedValue( "JOracleSchemaObjImpl", attrJOracleSchemaObjImpl );
			curContext.putNamedValue( "JOracleSchemaObjImport", attrJOracleSchemaObjImport );
			curContext.putNamedValue( "JPgSqlSchemaObjMembers", attrJPgSqlSchemaObjMembers );
			curContext.putNamedValue( "JPgSqlSchemaObjImpl", attrJPgSqlSchemaObjImpl );
			curContext.putNamedValue( "JPgSqlSchemaObjImport", attrJPgSqlSchemaObjImport );
			curContext.putNamedValue( "JSybaseSchemaObjMembers", attrJSybaseSchemaObjMembers );
			curContext.putNamedValue( "JSybaseSchemaObjImpl", attrJSybaseSchemaObjImpl );
			curContext.putNamedValue( "JSybaseSchemaObjImport", attrJSybaseSchemaObjImport );
			curContext.putNamedValue( "JRamSchemaObjMembers", attrJRamSchemaObjMembers );
			curContext.putNamedValue( "JRamSchemaObjImpl", attrJRamSchemaObjImpl );
			curContext.putNamedValue( "JRamSchemaObjImport", attrJRamSchemaObjImport );
			curContext.putNamedValue( "JXMsgSchemaImport", attrJXMsgSchemaImport );
			curContext.putNamedValue( "JXMsgSchemaFormatters", attrJXMsgSchemaFormatters );
			curContext.putNamedValue( "JXMsgClientSchemaImport", attrJXMsgClientSchemaImport );
			curContext.putNamedValue( "JXMsgClientSchemaBody", attrJXMsgClientSchemaBody );
			curContext.putNamedValue( "JXMsgRqstSchemaBody", attrJXMsgRqstSchemaBody );
			curContext.putNamedValue( "JXMsgRqstSchemaImport", attrJXMsgRqstSchemaImport );
			curContext.putNamedValue( "JXMsgRqstSchemaWireParsers", attrJXMsgRqstSchemaWireParsers );
			curContext.putNamedValue( "JXMsgRqstSchemaXsdSpec", attrJXMsgRqstSchemaXsdSpec );
			curContext.putNamedValue( "JXMsgRqstSchemaXsdElementList", attrJXMsgRqstSchemaXsdElementList );
			curContext.putNamedValue( "JXMsgRspnSchemaBody", attrJXMsgRspnSchemaBody );
			curContext.putNamedValue( "JXMsgRspnSchemaImport", attrJXMsgRspnSchemaImport );
			curContext.putNamedValue( "JXMsgRspnSchemaWireParsers", attrJXMsgRspnSchemaWireParsers );
			curContext.putNamedValue( "JXMsgRspnSchemaXsdElementList", attrJXMsgRspnSchemaXsdElementList );
			curContext.putNamedValue( "JXMsgRspnSchemaXsdSpec", attrJXMsgRspnSchemaXsdSpec );
			curContext.putNamedValue( "DefaultLicense", attrDefaultLicense );
			curContext.putNamedValue( "DataScope", attrDataScope );
			curContext.putNamedValue( "VAccSec", attrVAccSec );
			curContext.putNamedValue( "EAccSec", attrEAccSec );
			curContext.putNamedValue( "VAccFreq", attrVAccFreq );
			curContext.putNamedValue( "EAccFreq", attrEAccFreq );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			Integer natId;
			if( ( attrId != null ) && ( attrId.length() > 0 ) ) {
				natId = new Integer( Integer.parseInt( attrId ) );
			}
			else {
				natId = null;
			}
			String natName = attrName;
			editBuff.setRequiredName( natName );

			String natDbName = attrDbName;
			editBuff.setOptionalDbName( natDbName );

			String natShortName = attrShortName;
			editBuff.setOptionalShortName( natShortName );

			String natLabel = attrLabel;
			editBuff.setOptionalLabel( natLabel );

			String natShortDescription = attrShortDescription;
			editBuff.setOptionalShortDescription( natShortDescription );

			String natDescription = attrDescription;
			editBuff.setOptionalDescription( natDescription );

			boolean natExtendCFCore;
			if( attrExtendCFCore.equals( "true" ) || attrExtendCFCore.equals( "yes" ) || attrExtendCFCore.equals( "1" ) ) {
				natExtendCFCore = true;
			}
			else if( attrExtendCFCore.equals( "false" ) || attrExtendCFCore.equals( "no" ) || attrExtendCFCore.equals( "0" ) ) {
				natExtendCFCore = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected ExtendCFCore value, must be one of true, false, yes, no, 1, or 0, not \"" + attrExtendCFCore + "\"" );
			}
			editBuff.setRequiredExtendCFCore( natExtendCFCore );

			String natCopyrightPeriod = attrCopyrightPeriod;
			editBuff.setRequiredCopyrightPeriod( natCopyrightPeriod );

			String natCopyrightHolder = attrCopyrightHolder;
			editBuff.setRequiredCopyrightHolder( natCopyrightHolder );

			String natPublishURI = attrPublishURI;
			editBuff.setRequiredPublishURI( natPublishURI );

			String natJSchemaObjImport = attrJSchemaObjImport;
			editBuff.setOptionalJSchemaObjImport( natJSchemaObjImport );

			String natJSchemaObjInterface = attrJSchemaObjInterface;
			editBuff.setOptionalJSchemaObjInterface( natJSchemaObjInterface );

			String natJSchemaObjMembers = attrJSchemaObjMembers;
			editBuff.setOptionalJSchemaObjMembers( natJSchemaObjMembers );

			String natJSchemaObjImplementation = attrJSchemaObjImplementation;
			editBuff.setOptionalJSchemaObjImplementation( natJSchemaObjImplementation );

			String natJDb2LUWSchemaObjMembers = attrJDb2LUWSchemaObjMembers;
			editBuff.setOptionalJDb2LUWSchemaObjMembers( natJDb2LUWSchemaObjMembers );

			String natJDb2LUWSchemaObjImpl = attrJDb2LUWSchemaObjImpl;
			editBuff.setOptionalJDb2LUWSchemaObjImpl( natJDb2LUWSchemaObjImpl );

			String natJDb2LUWSchemaObjImport = attrJDb2LUWSchemaObjImport;
			editBuff.setOptionalJDb2LUWSchemaObjImport( natJDb2LUWSchemaObjImport );

			String natJMSSqlSchemaObjMembers = attrJMSSqlSchemaObjMembers;
			editBuff.setOptionalJMSSqlSchemaObjMembers( natJMSSqlSchemaObjMembers );

			String natJMSSqlSchemaObjImpl = attrJMSSqlSchemaObjImpl;
			editBuff.setOptionalJMSSqlSchemaObjImpl( natJMSSqlSchemaObjImpl );

			String natJMSSqlSchemaObjImport = attrJMSSqlSchemaObjImport;
			editBuff.setOptionalJMSSqlSchemaObjImport( natJMSSqlSchemaObjImport );

			String natJMySqlSchemaObjMembers = attrJMySqlSchemaObjMembers;
			editBuff.setOptionalJMySqlSchemaObjMembers( natJMySqlSchemaObjMembers );

			String natJMySqlSchemaObjImpl = attrJMySqlSchemaObjImpl;
			editBuff.setOptionalJMySqlSchemaObjImpl( natJMySqlSchemaObjImpl );

			String natJMySqlSchemaObjImport = attrJMySqlSchemaObjImport;
			editBuff.setOptionalJMySqlSchemaObjImport( natJMySqlSchemaObjImport );

			String natJOracleSchemaObjMembers = attrJOracleSchemaObjMembers;
			editBuff.setOptionalJOracleSchemaObjMembers( natJOracleSchemaObjMembers );

			String natJOracleSchemaObjImpl = attrJOracleSchemaObjImpl;
			editBuff.setOptionalJOracleSchemaObjImpl( natJOracleSchemaObjImpl );

			String natJOracleSchemaObjImport = attrJOracleSchemaObjImport;
			editBuff.setOptionalJOracleSchemaObjImport( natJOracleSchemaObjImport );

			String natJPgSqlSchemaObjMembers = attrJPgSqlSchemaObjMembers;
			editBuff.setOptionalJPgSqlSchemaObjMembers( natJPgSqlSchemaObjMembers );

			String natJPgSqlSchemaObjImpl = attrJPgSqlSchemaObjImpl;
			editBuff.setOptionalJPgSqlSchemaObjImpl( natJPgSqlSchemaObjImpl );

			String natJPgSqlSchemaObjImport = attrJPgSqlSchemaObjImport;
			editBuff.setOptionalJPgSqlSchemaObjImport( natJPgSqlSchemaObjImport );

			String natJSybaseSchemaObjMembers = attrJSybaseSchemaObjMembers;
			editBuff.setOptionalJSybaseSchemaObjMembers( natJSybaseSchemaObjMembers );

			String natJSybaseSchemaObjImpl = attrJSybaseSchemaObjImpl;
			editBuff.setOptionalJSybaseSchemaObjImpl( natJSybaseSchemaObjImpl );

			String natJSybaseSchemaObjImport = attrJSybaseSchemaObjImport;
			editBuff.setOptionalJSybaseSchemaObjImport( natJSybaseSchemaObjImport );

			String natJRamSchemaObjMembers = attrJRamSchemaObjMembers;
			editBuff.setOptionalJRamSchemaObjMembers( natJRamSchemaObjMembers );

			String natJRamSchemaObjImpl = attrJRamSchemaObjImpl;
			editBuff.setOptionalJRamSchemaObjImpl( natJRamSchemaObjImpl );

			String natJRamSchemaObjImport = attrJRamSchemaObjImport;
			editBuff.setOptionalJRamSchemaObjImport( natJRamSchemaObjImport );

			String natJXMsgSchemaImport = attrJXMsgSchemaImport;
			editBuff.setOptionalJXMsgSchemaImport( natJXMsgSchemaImport );

			String natJXMsgSchemaFormatters = attrJXMsgSchemaFormatters;
			editBuff.setOptionalJXMsgSchemaFormatters( natJXMsgSchemaFormatters );

			String natJXMsgClientSchemaImport = attrJXMsgClientSchemaImport;
			editBuff.setOptionalJXMsgClientSchemaImport( natJXMsgClientSchemaImport );

			String natJXMsgClientSchemaBody = attrJXMsgClientSchemaBody;
			editBuff.setOptionalJXMsgClientSchemaBody( natJXMsgClientSchemaBody );

			String natJXMsgRqstSchemaBody = attrJXMsgRqstSchemaBody;
			editBuff.setOptionalJXMsgRqstSchemaBody( natJXMsgRqstSchemaBody );

			String natJXMsgRqstSchemaImport = attrJXMsgRqstSchemaImport;
			editBuff.setOptionalJXMsgRqstSchemaImport( natJXMsgRqstSchemaImport );

			String natJXMsgRqstSchemaWireParsers = attrJXMsgRqstSchemaWireParsers;
			editBuff.setOptionalJXMsgRqstSchemaWireParsers( natJXMsgRqstSchemaWireParsers );

			String natJXMsgRqstSchemaXsdSpec = attrJXMsgRqstSchemaXsdSpec;
			editBuff.setOptionalJXMsgRqstSchemaXsdSpec( natJXMsgRqstSchemaXsdSpec );

			String natJXMsgRqstSchemaXsdElementList = attrJXMsgRqstSchemaXsdElementList;
			editBuff.setOptionalJXMsgRqstSchemaXsdElementList( natJXMsgRqstSchemaXsdElementList );

			String natJXMsgRspnSchemaBody = attrJXMsgRspnSchemaBody;
			editBuff.setOptionalJXMsgRspnSchemaBody( natJXMsgRspnSchemaBody );

			String natJXMsgRspnSchemaImport = attrJXMsgRspnSchemaImport;
			editBuff.setOptionalJXMsgRspnSchemaImport( natJXMsgRspnSchemaImport );

			String natJXMsgRspnSchemaWireParsers = attrJXMsgRspnSchemaWireParsers;
			editBuff.setOptionalJXMsgRspnSchemaWireParsers( natJXMsgRspnSchemaWireParsers );

			String natJXMsgRspnSchemaXsdElementList = attrJXMsgRspnSchemaXsdElementList;
			editBuff.setOptionalJXMsgRspnSchemaXsdElementList( natJXMsgRspnSchemaXsdElementList );

			String natJXMsgRspnSchemaXsdSpec = attrJXMsgRspnSchemaXsdSpec;
			editBuff.setOptionalJXMsgRspnSchemaXsdSpec( natJXMsgRspnSchemaXsdSpec );

			// Get the scope/container object

			CFLibXmlCoreContext parentContext = curContext.getPrevContext();
			Object scopeObj;
			if( parentContext != null ) {
				scopeObj = parentContext.getNamedValue( "Object" );
			}
			else {
				scopeObj = null;
			}

			// Resolve and apply required Container reference

			if( scopeObj == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"scopeObj" );
			}
			else if( scopeObj instanceof ICFBamDomainBaseObj ) {
				refDomain = (ICFBamDomainBaseObj) scopeObj;
				editBuff.setRequiredContainerDomain( refDomain );
				refCTenant = editBuff.getRequiredOwnerCTenant();
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ICFBamDomainBaseObj" );
			}

			// Resolve and apply Owner reference
 
			if( refCTenant == null ) {
				if( scopeObj instanceof ICFBamTenantObj ) {
					refCTenant = (ICFBamTenantObj) scopeObj;
					editBuff.setRequiredOwnerCTenant( refCTenant );
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Owner<CTenant>" );
				}
			}

			refTenant = refCTenant;
			// Lookup refDefaultLicense by qualified name
			if( ( attrDefaultLicense != null ) && ( attrDefaultLicense.length() > 0 ) ) {
				refDefaultLicense = (ICFBamLicenseObj)(editBuff.getNamedObject( schemaObj.getLicenseTableObj().getObjQualifyingClass(),
					attrDefaultLicense ) );
				if( refDefaultLicense == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve DefaultLicense reference qualified name \"" + attrDefaultLicense + "\" to table License" );
				}
			}
			else {
				refDefaultLicense = null;
			}
			editBuff.setOptionalLookupDefaultLicense( refDefaultLicense );

			// Lookup refDataScope by key name value attr
			if( ( attrDataScope != null ) && ( attrDataScope.length() > 0 ) ) {
				refDataScope = schemaObj.getDataScopeTableObj().readDataScopeByUNameIdx( attrDataScope );
				if( refDataScope == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve DataScope reference named \"" + attrDataScope + "\" to table DataScope" );
				}
			}
			else {
				refDataScope = null;
			}
			editBuff.setOptionalLookupDataScope( refDataScope );

			// Lookup refVAccSec by key name value attr
			if( ( attrVAccSec != null ) && ( attrVAccSec.length() > 0 ) ) {
				refVAccSec = schemaObj.getAccessSecurityTableObj().readAccessSecurityByUNameIdx( attrVAccSec );
				if( refVAccSec == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve VAccSec reference named \"" + attrVAccSec + "\" to table AccessSecurity" );
				}
			}
			else {
				refVAccSec = null;
			}
			editBuff.setOptionalLookupVAccSec( refVAccSec );

			// Lookup refEAccSec by key name value attr
			if( ( attrEAccSec != null ) && ( attrEAccSec.length() > 0 ) ) {
				refEAccSec = schemaObj.getAccessSecurityTableObj().readAccessSecurityByUNameIdx( attrEAccSec );
				if( refEAccSec == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve EAccSec reference named \"" + attrEAccSec + "\" to table AccessSecurity" );
				}
			}
			else {
				refEAccSec = null;
			}
			editBuff.setOptionalLookupEAccSec( refEAccSec );

			// Lookup refVAccFreq by key name value attr
			if( ( attrVAccFreq != null ) && ( attrVAccFreq.length() > 0 ) ) {
				refVAccFreq = schemaObj.getAccessFrequencyTableObj().readAccessFrequencyByUNameIdx( attrVAccFreq );
				if( refVAccFreq == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve VAccFreq reference named \"" + attrVAccFreq + "\" to table AccessFrequency" );
				}
			}
			else {
				refVAccFreq = null;
			}
			editBuff.setOptionalLookupVAccFreq( refVAccFreq );

			// Lookup refEAccFreq by key name value attr
			if( ( attrEAccFreq != null ) && ( attrEAccFreq.length() > 0 ) ) {
				refEAccFreq = schemaObj.getAccessFrequencyTableObj().readAccessFrequencyByUNameIdx( attrEAccFreq );
				if( refEAccFreq == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve EAccFreq reference named \"" + attrEAccFreq + "\" to table AccessFrequency" );
				}
			}
			else {
				refEAccFreq = null;
			}
			editBuff.setOptionalLookupEAccFreq( refEAccFreq );

			CFBamSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getSchemaDefLoaderBehaviour();
			ICFBamSchemaDefEditObj editSchemaDef = null;
			ICFBamSchemaDefObj origSchemaDef = schemaObj.getSchemaDefTableObj().readSchemaDefByUNameIdx( refDomain.getRequiredTenantId(),
			refDomain.getRequiredId(),
			editBuff.getRequiredName() );
			if( origSchemaDef == null ) {
				editSchemaDef = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editSchemaDef = (ICFBamSchemaDefEditObj)origSchemaDef.beginEdit();
						editSchemaDef.setRequiredName( editBuff.getRequiredName() );
						editSchemaDef.setOptionalDbName( editBuff.getOptionalDbName() );
						editSchemaDef.setOptionalShortName( editBuff.getOptionalShortName() );
						editSchemaDef.setOptionalLabel( editBuff.getOptionalLabel() );
						editSchemaDef.setOptionalShortDescription( editBuff.getOptionalShortDescription() );
						editSchemaDef.setOptionalDescription( editBuff.getOptionalDescription() );
						editSchemaDef.setRequiredExtendCFCore( editBuff.getRequiredExtendCFCore() );
						editSchemaDef.setRequiredCopyrightPeriod( editBuff.getRequiredCopyrightPeriod() );
						editSchemaDef.setRequiredCopyrightHolder( editBuff.getRequiredCopyrightHolder() );
						editSchemaDef.setRequiredPublishURI( editBuff.getRequiredPublishURI() );
						editSchemaDef.setOptionalJSchemaObjImport( editBuff.getOptionalJSchemaObjImport() );
						editSchemaDef.setOptionalJSchemaObjInterface( editBuff.getOptionalJSchemaObjInterface() );
						editSchemaDef.setOptionalJSchemaObjMembers( editBuff.getOptionalJSchemaObjMembers() );
						editSchemaDef.setOptionalJSchemaObjImplementation( editBuff.getOptionalJSchemaObjImplementation() );
						editSchemaDef.setOptionalJDb2LUWSchemaObjMembers( editBuff.getOptionalJDb2LUWSchemaObjMembers() );
						editSchemaDef.setOptionalJDb2LUWSchemaObjImpl( editBuff.getOptionalJDb2LUWSchemaObjImpl() );
						editSchemaDef.setOptionalJDb2LUWSchemaObjImport( editBuff.getOptionalJDb2LUWSchemaObjImport() );
						editSchemaDef.setOptionalJMSSqlSchemaObjMembers( editBuff.getOptionalJMSSqlSchemaObjMembers() );
						editSchemaDef.setOptionalJMSSqlSchemaObjImpl( editBuff.getOptionalJMSSqlSchemaObjImpl() );
						editSchemaDef.setOptionalJMSSqlSchemaObjImport( editBuff.getOptionalJMSSqlSchemaObjImport() );
						editSchemaDef.setOptionalJMySqlSchemaObjMembers( editBuff.getOptionalJMySqlSchemaObjMembers() );
						editSchemaDef.setOptionalJMySqlSchemaObjImpl( editBuff.getOptionalJMySqlSchemaObjImpl() );
						editSchemaDef.setOptionalJMySqlSchemaObjImport( editBuff.getOptionalJMySqlSchemaObjImport() );
						editSchemaDef.setOptionalJOracleSchemaObjMembers( editBuff.getOptionalJOracleSchemaObjMembers() );
						editSchemaDef.setOptionalJOracleSchemaObjImpl( editBuff.getOptionalJOracleSchemaObjImpl() );
						editSchemaDef.setOptionalJOracleSchemaObjImport( editBuff.getOptionalJOracleSchemaObjImport() );
						editSchemaDef.setOptionalJPgSqlSchemaObjMembers( editBuff.getOptionalJPgSqlSchemaObjMembers() );
						editSchemaDef.setOptionalJPgSqlSchemaObjImpl( editBuff.getOptionalJPgSqlSchemaObjImpl() );
						editSchemaDef.setOptionalJPgSqlSchemaObjImport( editBuff.getOptionalJPgSqlSchemaObjImport() );
						editSchemaDef.setOptionalJSybaseSchemaObjMembers( editBuff.getOptionalJSybaseSchemaObjMembers() );
						editSchemaDef.setOptionalJSybaseSchemaObjImpl( editBuff.getOptionalJSybaseSchemaObjImpl() );
						editSchemaDef.setOptionalJSybaseSchemaObjImport( editBuff.getOptionalJSybaseSchemaObjImport() );
						editSchemaDef.setOptionalJRamSchemaObjMembers( editBuff.getOptionalJRamSchemaObjMembers() );
						editSchemaDef.setOptionalJRamSchemaObjImpl( editBuff.getOptionalJRamSchemaObjImpl() );
						editSchemaDef.setOptionalJRamSchemaObjImport( editBuff.getOptionalJRamSchemaObjImport() );
						editSchemaDef.setOptionalJXMsgSchemaImport( editBuff.getOptionalJXMsgSchemaImport() );
						editSchemaDef.setOptionalJXMsgSchemaFormatters( editBuff.getOptionalJXMsgSchemaFormatters() );
						editSchemaDef.setOptionalJXMsgClientSchemaImport( editBuff.getOptionalJXMsgClientSchemaImport() );
						editSchemaDef.setOptionalJXMsgClientSchemaBody( editBuff.getOptionalJXMsgClientSchemaBody() );
						editSchemaDef.setOptionalJXMsgRqstSchemaBody( editBuff.getOptionalJXMsgRqstSchemaBody() );
						editSchemaDef.setOptionalJXMsgRqstSchemaImport( editBuff.getOptionalJXMsgRqstSchemaImport() );
						editSchemaDef.setOptionalJXMsgRqstSchemaWireParsers( editBuff.getOptionalJXMsgRqstSchemaWireParsers() );
						editSchemaDef.setOptionalJXMsgRqstSchemaXsdSpec( editBuff.getOptionalJXMsgRqstSchemaXsdSpec() );
						editSchemaDef.setOptionalJXMsgRqstSchemaXsdElementList( editBuff.getOptionalJXMsgRqstSchemaXsdElementList() );
						editSchemaDef.setOptionalJXMsgRspnSchemaBody( editBuff.getOptionalJXMsgRspnSchemaBody() );
						editSchemaDef.setOptionalJXMsgRspnSchemaImport( editBuff.getOptionalJXMsgRspnSchemaImport() );
						editSchemaDef.setOptionalJXMsgRspnSchemaWireParsers( editBuff.getOptionalJXMsgRspnSchemaWireParsers() );
						editSchemaDef.setOptionalJXMsgRspnSchemaXsdElementList( editBuff.getOptionalJXMsgRspnSchemaXsdElementList() );
						editSchemaDef.setOptionalJXMsgRspnSchemaXsdSpec( editBuff.getOptionalJXMsgRspnSchemaXsdSpec() );
						editSchemaDef.setOptionalLookupDefaultLicense( editBuff.getOptionalLookupDefaultLicense() );
						editSchemaDef.setOptionalLookupDataScope( editBuff.getOptionalLookupDataScope() );
						editSchemaDef.setOptionalLookupVAccSec( editBuff.getOptionalLookupVAccSec() );
						editSchemaDef.setOptionalLookupEAccSec( editBuff.getOptionalLookupEAccSec() );
						editSchemaDef.setOptionalLookupVAccFreq( editBuff.getOptionalLookupVAccFreq() );
						editSchemaDef.setOptionalLookupEAccFreq( editBuff.getOptionalLookupEAccFreq() );
						break;
					case Replace:
						editSchemaDef = (ICFBamSchemaDefEditObj)origSchemaDef.beginEdit();
						editSchemaDef.delete();
						editSchemaDef.endEdit();
						origSchemaDef = null;
						editSchemaDef = editBuff;
						break;
				}
			}

			if( editSchemaDef != null ) {
				if( origSchemaDef != null ) {
					editSchemaDef.update();
				}
				else {
					origSchemaDef = (ICFBamSchemaDefObj)editSchemaDef.create();
				}
				editSchemaDef.endEdit();
			}

			curContext.putNamedValue( "Object", origSchemaDef );
		}
		catch( RuntimeException e ) {
			throw new RuntimeException( "Near " + getParser().getLocationInfo() + ": Caught and rethrew " + e.getClass().getName() + " - " + e.getMessage(),
				e );
		}
		catch( Error e ) {
			throw new Error( "Near " + getParser().getLocationInfo() + ": Caught and rethrew " + e.getClass().getName() + " - " + e.getMessage(),
				e );
		}
	}

	public void endElement(
		String		uri,
		String		localName,
		String		qName )
	throws SAXException
	{
	}
}
