
// Description: Java 7 XML Message SAX Response Record Element Handler for SchemaDef

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
 *	CFBamXMsgRspnSchemaDefLockedHandler XML SAX Element Handler implementation
 *	for SchemaDef.
 */
public class CFBamXMsgRspnSchemaDefLockedHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamXMsgRspnSchemaDefLockedHandler( CFBamXMsgRspnHandler xmsgRspnHandler ) {
		super( xmsgRspnHandler );
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
			String	attrRevision = null;
			// Scope Attributes
			String	attrTenantId = null;
			String attrCreatedAt = null;
			String attrCreatedBy = null;
			String attrUpdatedAt = null;
			String attrUpdatedBy = null;
			// SchemaDef Attributes
			String	attrDomainId = null;
			String	attrName = null;
			String	attrDbName = null;
			String	attrShortName = null;
			String	attrLabel = null;
			String	attrShortDescription = null;
			String	attrDescription = null;
			String	attrDefaultLicenseTenantId = null;
			String	attrDefaultLicenseId = null;
			String	attrExtendCFCore = null;
			String	attrDataScopeId = null;
			String	attrViewAccessSecurityId = null;
			String	attrEditAccessSecurityId = null;
			String	attrViewAccessFrequencyId = null;
			String	attrEditAccessFrequencyId = null;
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
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "RspnSchemaDefLocked" );

			CFBamXMsgRspnHandler xmsgRspnHandler = (CFBamXMsgRspnHandler)getParser();
			if( xmsgRspnHandler == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			ICFBamSchemaObj schemaObj = xmsgRspnHandler.getSchemaObj();
			if( schemaObj == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser().getSchemaObj()" );
			}

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
				else if( attrLocalName.equals( "Revision" ) ) {
					if( attrRevision != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrRevision = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CreatedAt" ) ) {
					if( attrCreatedAt != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCreatedAt = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CreatedBy" ) ) {
					if( attrCreatedBy != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCreatedBy = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "UpdatedAt" ) ) {
					if( attrUpdatedAt != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrUpdatedAt = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "UpdatedBy" ) ) {
					if( attrUpdatedBy != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrUpdatedBy = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "TenantId" ) ) {
					if( attrTenantId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DomainId" ) ) {
					if( attrDomainId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDomainId = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "DefaultLicenseTenantId" ) ) {
					if( attrDefaultLicenseTenantId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefaultLicenseTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefaultLicenseId" ) ) {
					if( attrDefaultLicenseId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefaultLicenseId = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "DataScopeId" ) ) {
					if( attrDataScopeId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDataScopeId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ViewAccessSecurityId" ) ) {
					if( attrViewAccessSecurityId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrViewAccessSecurityId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "EditAccessSecurityId" ) ) {
					if( attrEditAccessSecurityId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrEditAccessSecurityId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ViewAccessFrequencyId" ) ) {
					if( attrViewAccessFrequencyId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrViewAccessFrequencyId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "EditAccessFrequencyId" ) ) {
					if( attrEditAccessFrequencyId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrEditAccessFrequencyId = attrs.getValue( idxAttr );
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
			if( ( attrTenantId == null ) || ( attrTenantId.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"TenantId" );
			}
			if( ( attrId == null ) || ( attrId.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Id" );
			}
			if( ( attrRevision == null ) || ( attrRevision.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Revision" );
			}
			if( ( attrDomainId == null ) || ( attrDomainId.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"DomainId" );
			}
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

			// Convert string attributes to native Java types

			long natTenantId = Long.parseLong( attrTenantId );

			long natId = Long.parseLong( attrId );

			int natRevision = Integer.parseInt( attrRevision );
			UUID createdBy = null;
			if( attrCreatedBy != null ) {
				createdBy = UUID.fromString( attrCreatedBy );
			}
			Calendar createdAt = null;
			if( attrCreatedAt != null ) {
				createdAt = CFLibXmlUtil.parseTimestamp( attrCreatedAt );
			}
			UUID updatedBy = null;
			if( attrUpdatedBy != null ) {
				updatedBy = UUID.fromString( attrUpdatedBy );
			}
			Calendar updatedAt = null;
			if( attrUpdatedAt != null ) {
				updatedAt = CFLibXmlUtil.parseTimestamp( attrUpdatedAt );
			}
			long natDomainId = Long.parseLong( attrDomainId );

			String natName = attrName;

			String natDbName = attrDbName;

			String natShortName = attrShortName;

			String natLabel = attrLabel;

			String natShortDescription = attrShortDescription;

			String natDescription = attrDescription;

			Long natDefaultLicenseTenantId;
			if( ( attrDefaultLicenseTenantId == null ) || ( attrDefaultLicenseTenantId.length() <= 0 ) ) {
				natDefaultLicenseTenantId = null;
			}
			else {
				natDefaultLicenseTenantId = new Long( Long.parseLong( attrDefaultLicenseTenantId ) );
			}

			Long natDefaultLicenseId;
			if( ( attrDefaultLicenseId == null ) || ( attrDefaultLicenseId.length() <= 0 ) ) {
				natDefaultLicenseId = null;
			}
			else {
				natDefaultLicenseId = new Long( Long.parseLong( attrDefaultLicenseId ) );
			}

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

			Short natDataScopeId;
			if( ( attrDataScopeId == null ) || ( attrDataScopeId.length() <= 0 ) ) {
				natDataScopeId = null;
			}
			else {
				natDataScopeId= new Short( Short.parseShort( attrDataScopeId ) );
			}

			Short natViewAccessSecurityId;
			if( ( attrViewAccessSecurityId == null ) || ( attrViewAccessSecurityId.length() <= 0 ) ) {
				natViewAccessSecurityId = null;
			}
			else {
				natViewAccessSecurityId= new Short( Short.parseShort( attrViewAccessSecurityId ) );
			}

			Short natEditAccessSecurityId;
			if( ( attrEditAccessSecurityId == null ) || ( attrEditAccessSecurityId.length() <= 0 ) ) {
				natEditAccessSecurityId = null;
			}
			else {
				natEditAccessSecurityId= new Short( Short.parseShort( attrEditAccessSecurityId ) );
			}

			Short natViewAccessFrequencyId;
			if( ( attrViewAccessFrequencyId == null ) || ( attrViewAccessFrequencyId.length() <= 0 ) ) {
				natViewAccessFrequencyId = null;
			}
			else {
				natViewAccessFrequencyId= new Short( Short.parseShort( attrViewAccessFrequencyId ) );
			}

			Short natEditAccessFrequencyId;
			if( ( attrEditAccessFrequencyId == null ) || ( attrEditAccessFrequencyId.length() <= 0 ) ) {
				natEditAccessFrequencyId = null;
			}
			else {
				natEditAccessFrequencyId= new Short( Short.parseShort( attrEditAccessFrequencyId ) );
			}

			String natCopyrightPeriod = attrCopyrightPeriod;

			String natCopyrightHolder = attrCopyrightHolder;

			String natPublishURI = attrPublishURI;

			String natJSchemaObjImport = attrJSchemaObjImport;

			String natJSchemaObjInterface = attrJSchemaObjInterface;

			String natJSchemaObjMembers = attrJSchemaObjMembers;

			String natJSchemaObjImplementation = attrJSchemaObjImplementation;

			String natJDb2LUWSchemaObjMembers = attrJDb2LUWSchemaObjMembers;

			String natJDb2LUWSchemaObjImpl = attrJDb2LUWSchemaObjImpl;

			String natJDb2LUWSchemaObjImport = attrJDb2LUWSchemaObjImport;

			String natJMSSqlSchemaObjMembers = attrJMSSqlSchemaObjMembers;

			String natJMSSqlSchemaObjImpl = attrJMSSqlSchemaObjImpl;

			String natJMSSqlSchemaObjImport = attrJMSSqlSchemaObjImport;

			String natJMySqlSchemaObjMembers = attrJMySqlSchemaObjMembers;

			String natJMySqlSchemaObjImpl = attrJMySqlSchemaObjImpl;

			String natJMySqlSchemaObjImport = attrJMySqlSchemaObjImport;

			String natJOracleSchemaObjMembers = attrJOracleSchemaObjMembers;

			String natJOracleSchemaObjImpl = attrJOracleSchemaObjImpl;

			String natJOracleSchemaObjImport = attrJOracleSchemaObjImport;

			String natJPgSqlSchemaObjMembers = attrJPgSqlSchemaObjMembers;

			String natJPgSqlSchemaObjImpl = attrJPgSqlSchemaObjImpl;

			String natJPgSqlSchemaObjImport = attrJPgSqlSchemaObjImport;

			String natJSybaseSchemaObjMembers = attrJSybaseSchemaObjMembers;

			String natJSybaseSchemaObjImpl = attrJSybaseSchemaObjImpl;

			String natJSybaseSchemaObjImport = attrJSybaseSchemaObjImport;

			String natJRamSchemaObjMembers = attrJRamSchemaObjMembers;

			String natJRamSchemaObjImpl = attrJRamSchemaObjImpl;

			String natJRamSchemaObjImport = attrJRamSchemaObjImport;

			String natJXMsgSchemaImport = attrJXMsgSchemaImport;

			String natJXMsgSchemaFormatters = attrJXMsgSchemaFormatters;

			String natJXMsgClientSchemaImport = attrJXMsgClientSchemaImport;

			String natJXMsgClientSchemaBody = attrJXMsgClientSchemaBody;

			String natJXMsgRqstSchemaBody = attrJXMsgRqstSchemaBody;

			String natJXMsgRqstSchemaImport = attrJXMsgRqstSchemaImport;

			String natJXMsgRqstSchemaWireParsers = attrJXMsgRqstSchemaWireParsers;

			String natJXMsgRqstSchemaXsdSpec = attrJXMsgRqstSchemaXsdSpec;

			String natJXMsgRqstSchemaXsdElementList = attrJXMsgRqstSchemaXsdElementList;

			String natJXMsgRspnSchemaBody = attrJXMsgRspnSchemaBody;

			String natJXMsgRspnSchemaImport = attrJXMsgRspnSchemaImport;

			String natJXMsgRspnSchemaWireParsers = attrJXMsgRspnSchemaWireParsers;

			String natJXMsgRspnSchemaXsdElementList = attrJXMsgRspnSchemaXsdElementList;

			String natJXMsgRspnSchemaXsdSpec = attrJXMsgRspnSchemaXsdSpec;

			// Instantiate a buffer for the parsed information
			ICFBamSchemaDefObj obj = schemaObj.getSchemaDefTableObj().newInstance();
			CFBamSchemaDefBuff dataBuff = obj.getSchemaDefBuff();
			dataBuff.setRequiredTenantId( natTenantId );
			dataBuff.setRequiredId( natId );
			dataBuff.setRequiredRevision( natRevision );
			if( createdBy != null ) {
				dataBuff.setCreatedByUserId( createdBy );
			}
			if( createdAt != null ) {
				dataBuff.setCreatedAt( createdAt );
			}
			if( updatedBy != null ) {
				dataBuff.setUpdatedByUserId( updatedBy );
			}
			if( updatedAt != null ) {
				dataBuff.setUpdatedAt( updatedAt );
			}
			dataBuff.setRequiredDomainId( natDomainId );
			dataBuff.setRequiredName( natName );
			dataBuff.setOptionalDbName( natDbName );
			dataBuff.setOptionalShortName( natShortName );
			dataBuff.setOptionalLabel( natLabel );
			dataBuff.setOptionalShortDescription( natShortDescription );
			dataBuff.setOptionalDescription( natDescription );
			dataBuff.setOptionalDefaultLicenseTenantId( natDefaultLicenseTenantId );
			dataBuff.setOptionalDefaultLicenseId( natDefaultLicenseId );
			dataBuff.setRequiredExtendCFCore( natExtendCFCore );
			dataBuff.setOptionalDataScopeId( natDataScopeId );
			dataBuff.setOptionalViewAccessSecurityId( natViewAccessSecurityId );
			dataBuff.setOptionalEditAccessSecurityId( natEditAccessSecurityId );
			dataBuff.setOptionalViewAccessFrequencyId( natViewAccessFrequencyId );
			dataBuff.setOptionalEditAccessFrequencyId( natEditAccessFrequencyId );
			dataBuff.setRequiredCopyrightPeriod( natCopyrightPeriod );
			dataBuff.setRequiredCopyrightHolder( natCopyrightHolder );
			dataBuff.setRequiredPublishURI( natPublishURI );
			dataBuff.setOptionalJSchemaObjImport( natJSchemaObjImport );
			dataBuff.setOptionalJSchemaObjInterface( natJSchemaObjInterface );
			dataBuff.setOptionalJSchemaObjMembers( natJSchemaObjMembers );
			dataBuff.setOptionalJSchemaObjImplementation( natJSchemaObjImplementation );
			dataBuff.setOptionalJDb2LUWSchemaObjMembers( natJDb2LUWSchemaObjMembers );
			dataBuff.setOptionalJDb2LUWSchemaObjImpl( natJDb2LUWSchemaObjImpl );
			dataBuff.setOptionalJDb2LUWSchemaObjImport( natJDb2LUWSchemaObjImport );
			dataBuff.setOptionalJMSSqlSchemaObjMembers( natJMSSqlSchemaObjMembers );
			dataBuff.setOptionalJMSSqlSchemaObjImpl( natJMSSqlSchemaObjImpl );
			dataBuff.setOptionalJMSSqlSchemaObjImport( natJMSSqlSchemaObjImport );
			dataBuff.setOptionalJMySqlSchemaObjMembers( natJMySqlSchemaObjMembers );
			dataBuff.setOptionalJMySqlSchemaObjImpl( natJMySqlSchemaObjImpl );
			dataBuff.setOptionalJMySqlSchemaObjImport( natJMySqlSchemaObjImport );
			dataBuff.setOptionalJOracleSchemaObjMembers( natJOracleSchemaObjMembers );
			dataBuff.setOptionalJOracleSchemaObjImpl( natJOracleSchemaObjImpl );
			dataBuff.setOptionalJOracleSchemaObjImport( natJOracleSchemaObjImport );
			dataBuff.setOptionalJPgSqlSchemaObjMembers( natJPgSqlSchemaObjMembers );
			dataBuff.setOptionalJPgSqlSchemaObjImpl( natJPgSqlSchemaObjImpl );
			dataBuff.setOptionalJPgSqlSchemaObjImport( natJPgSqlSchemaObjImport );
			dataBuff.setOptionalJSybaseSchemaObjMembers( natJSybaseSchemaObjMembers );
			dataBuff.setOptionalJSybaseSchemaObjImpl( natJSybaseSchemaObjImpl );
			dataBuff.setOptionalJSybaseSchemaObjImport( natJSybaseSchemaObjImport );
			dataBuff.setOptionalJRamSchemaObjMembers( natJRamSchemaObjMembers );
			dataBuff.setOptionalJRamSchemaObjImpl( natJRamSchemaObjImpl );
			dataBuff.setOptionalJRamSchemaObjImport( natJRamSchemaObjImport );
			dataBuff.setOptionalJXMsgSchemaImport( natJXMsgSchemaImport );
			dataBuff.setOptionalJXMsgSchemaFormatters( natJXMsgSchemaFormatters );
			dataBuff.setOptionalJXMsgClientSchemaImport( natJXMsgClientSchemaImport );
			dataBuff.setOptionalJXMsgClientSchemaBody( natJXMsgClientSchemaBody );
			dataBuff.setOptionalJXMsgRqstSchemaBody( natJXMsgRqstSchemaBody );
			dataBuff.setOptionalJXMsgRqstSchemaImport( natJXMsgRqstSchemaImport );
			dataBuff.setOptionalJXMsgRqstSchemaWireParsers( natJXMsgRqstSchemaWireParsers );
			dataBuff.setOptionalJXMsgRqstSchemaXsdSpec( natJXMsgRqstSchemaXsdSpec );
			dataBuff.setOptionalJXMsgRqstSchemaXsdElementList( natJXMsgRqstSchemaXsdElementList );
			dataBuff.setOptionalJXMsgRspnSchemaBody( natJXMsgRspnSchemaBody );
			dataBuff.setOptionalJXMsgRspnSchemaImport( natJXMsgRspnSchemaImport );
			dataBuff.setOptionalJXMsgRspnSchemaWireParsers( natJXMsgRspnSchemaWireParsers );
			dataBuff.setOptionalJXMsgRspnSchemaXsdElementList( natJXMsgRspnSchemaXsdElementList );
			dataBuff.setOptionalJXMsgRspnSchemaXsdSpec( natJXMsgRspnSchemaXsdSpec );
			obj.copyBuffToPKey();
			ICFBamSchemaDefObj realized = (ICFBamSchemaDefObj)obj.realize();
			xmsgRspnHandler.setLastObjectProcessed( realized );
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
