
// Description: Java 7 XML Message SAX Response Record Element Handler for Table

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
 *	CFBamXMsgRspnTableLockedHandler XML SAX Element Handler implementation
 *	for Table.
 */
public class CFBamXMsgRspnTableLockedHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamXMsgRspnTableLockedHandler( CFBamXMsgRspnHandler xmsgRspnHandler ) {
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
			// Table Attributes
			String	attrSchemaDefId = null;
			String	attrDefSchemaTenantId = null;
			String	attrDefSchemaId = null;
			String	attrName = null;
			String	attrDbName = null;
			String	attrShortName = null;
			String	attrLabel = null;
			String	attrShortDescription = null;
			String	attrDescription = null;
			String	attrPrimaryIndexTenantId = null;
			String	attrPrimaryIndexId = null;
			String	attrTableClassCode = null;
			String	attrLookupIndexTenantId = null;
			String	attrLookupIndexId = null;
			String	attrAltIndexTenantId = null;
			String	attrAltIndexId = null;
			String	attrQualifyingTenantId = null;
			String	attrQualifyingTableId = null;
			String	attrPolyBase = null;
			String	attrIsInstantiable = null;
			String	attrHasHistory = null;
			String	attrHasAuditColumns = null;
			String	attrLoaderBehaviourId = null;
			String	attrDataScopeId = null;
			String	attrSecurityScopeId = null;
			String	attrViewAccessSecurityId = null;
			String	attrEditAccessSecurityId = null;
			String	attrViewAccessFrequencyId = null;
			String	attrEditAccessFrequencyId = null;
			String	attrJObjMembers = null;
			String	attrJObjInterface = null;
			String	attrJObjImport = null;
			String	attrJObjImplementation = null;
			String	attrJEditObjMembers = null;
			String	attrJEditObjInterface = null;
			String	attrJEditObjImport = null;
			String	attrJEditObjImplementation = null;
			String	attrJTableImport = null;
			String	attrJTableMembers = null;
			String	attrJTableInterface = null;
			String	attrJTableImplementation = null;
			String	attrJTableObjImport = null;
			String	attrJTableObjMembers = null;
			String	attrJTableObjInterface = null;
			String	attrJTableObjImplementation = null;
			String	attrJDb2LUWTableImport = null;
			String	attrJDb2LUWTableMembers = null;
			String	attrJDb2LUWTableImplementation = null;
			String	attrJMSSqlTableImport = null;
			String	attrJMSSqlTableMembers = null;
			String	attrJMSSqlTableImplementation = null;
			String	attrJMySqlTableImport = null;
			String	attrJMySqlTableMembers = null;
			String	attrJMySqlTableImplementation = null;
			String	attrJOracleTableImport = null;
			String	attrJOracleTableMembers = null;
			String	attrJOracleTableImplementation = null;
			String	attrJPgSqlTableImport = null;
			String	attrJPgSqlTableMembers = null;
			String	attrJPgSqlTableImplementation = null;
			String	attrJSybaseTableImport = null;
			String	attrJSybaseTableMembers = null;
			String	attrJSybaseTableImplementation = null;
			String	attrJRamTableImport = null;
			String	attrJRamTableMembers = null;
			String	attrJRamTableImplementation = null;
			String	attrJSaxLoaderImport = null;
			String	attrJSaxLoaderStartElement = null;
			String	attrJSaxLoaderEndElement = null;
			String	attrJXMsgTableImport = null;
			String	attrJXMsgTableFormatters = null;
			String	attrJXMsgRqstTableImport = null;
			String	attrJXMsgRspnTableImport = null;
			String	attrJXMsgClientTableImport = null;
			String	attrJXMsgRqstTableBody = null;
			String	attrJXMsgRspnTableBody = null;
			String	attrJXMsgClientTableBody = null;
			String	attrDefaultVisibility = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "RspnTableLocked" );

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
				else if( attrLocalName.equals( "SchemaDefId" ) ) {
					if( attrSchemaDefId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSchemaDefId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefSchemaTenantId" ) ) {
					if( attrDefSchemaTenantId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefSchemaTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefSchemaId" ) ) {
					if( attrDefSchemaId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefSchemaId = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "PrimaryIndexTenantId" ) ) {
					if( attrPrimaryIndexTenantId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPrimaryIndexTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PrimaryIndexId" ) ) {
					if( attrPrimaryIndexId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPrimaryIndexId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "TableClassCode" ) ) {
					if( attrTableClassCode != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTableClassCode = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "LookupIndexTenantId" ) ) {
					if( attrLookupIndexTenantId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLookupIndexTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "LookupIndexId" ) ) {
					if( attrLookupIndexId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLookupIndexId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "AltIndexTenantId" ) ) {
					if( attrAltIndexTenantId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrAltIndexTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "AltIndexId" ) ) {
					if( attrAltIndexId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrAltIndexId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "QualifyingTenantId" ) ) {
					if( attrQualifyingTenantId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrQualifyingTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "QualifyingTableId" ) ) {
					if( attrQualifyingTableId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrQualifyingTableId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PolyBase" ) ) {
					if( attrPolyBase != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPolyBase = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "IsInstantiable" ) ) {
					if( attrIsInstantiable != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsInstantiable = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HasHistory" ) ) {
					if( attrHasHistory != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHasHistory = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HasAuditColumns" ) ) {
					if( attrHasAuditColumns != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHasAuditColumns = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "LoaderBehaviourId" ) ) {
					if( attrLoaderBehaviourId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLoaderBehaviourId = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "SecurityScopeId" ) ) {
					if( attrSecurityScopeId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSecurityScopeId = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "JObjMembers" ) ) {
					if( attrJObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JObjInterface" ) ) {
					if( attrJObjInterface != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JObjImport" ) ) {
					if( attrJObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JObjImplementation" ) ) {
					if( attrJObjImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JEditObjMembers" ) ) {
					if( attrJEditObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJEditObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JEditObjInterface" ) ) {
					if( attrJEditObjInterface != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJEditObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JEditObjImport" ) ) {
					if( attrJEditObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJEditObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JEditObjImplementation" ) ) {
					if( attrJEditObjImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJEditObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableImport" ) ) {
					if( attrJTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableMembers" ) ) {
					if( attrJTableMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableInterface" ) ) {
					if( attrJTableInterface != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableImplementation" ) ) {
					if( attrJTableImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableObjImport" ) ) {
					if( attrJTableObjImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableObjMembers" ) ) {
					if( attrJTableObjMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableObjInterface" ) ) {
					if( attrJTableObjInterface != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableObjImplementation" ) ) {
					if( attrJTableObjImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWTableImport" ) ) {
					if( attrJDb2LUWTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWTableMembers" ) ) {
					if( attrJDb2LUWTableMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWTableImplementation" ) ) {
					if( attrJDb2LUWTableImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlTableImport" ) ) {
					if( attrJMSSqlTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlTableMembers" ) ) {
					if( attrJMSSqlTableMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlTableImplementation" ) ) {
					if( attrJMSSqlTableImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlTableImport" ) ) {
					if( attrJMySqlTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlTableMembers" ) ) {
					if( attrJMySqlTableMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlTableImplementation" ) ) {
					if( attrJMySqlTableImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleTableImport" ) ) {
					if( attrJOracleTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleTableMembers" ) ) {
					if( attrJOracleTableMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleTableImplementation" ) ) {
					if( attrJOracleTableImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlTableImport" ) ) {
					if( attrJPgSqlTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlTableMembers" ) ) {
					if( attrJPgSqlTableMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlTableImplementation" ) ) {
					if( attrJPgSqlTableImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSybaseTableImport" ) ) {
					if( attrJSybaseTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSybaseTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSybaseTableMembers" ) ) {
					if( attrJSybaseTableMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSybaseTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSybaseTableImplementation" ) ) {
					if( attrJSybaseTableImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSybaseTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamTableImport" ) ) {
					if( attrJRamTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamTableMembers" ) ) {
					if( attrJRamTableMembers != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamTableImplementation" ) ) {
					if( attrJRamTableImplementation != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSaxLoaderImport" ) ) {
					if( attrJSaxLoaderImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSaxLoaderImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSaxLoaderStartElement" ) ) {
					if( attrJSaxLoaderStartElement != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSaxLoaderStartElement = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSaxLoaderEndElement" ) ) {
					if( attrJSaxLoaderEndElement != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSaxLoaderEndElement = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgTableImport" ) ) {
					if( attrJXMsgTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgTableFormatters" ) ) {
					if( attrJXMsgTableFormatters != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgTableFormatters = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstTableImport" ) ) {
					if( attrJXMsgRqstTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnTableImport" ) ) {
					if( attrJXMsgRspnTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgClientTableImport" ) ) {
					if( attrJXMsgClientTableImport != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgClientTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstTableBody" ) ) {
					if( attrJXMsgRqstTableBody != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnTableBody" ) ) {
					if( attrJXMsgRspnTableBody != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgClientTableBody" ) ) {
					if( attrJXMsgClientTableBody != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgClientTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefaultVisibility" ) ) {
					if( attrDefaultVisibility != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefaultVisibility = attrs.getValue( idxAttr );
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
			if( ( attrSchemaDefId == null ) || ( attrSchemaDefId.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SchemaDefId" );
			}
			if( attrName == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Name" );
			}
			if( attrTableClassCode == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"TableClassCode" );
			}
			if( ( attrPolyBase == null ) || ( attrPolyBase.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"PolyBase" );
			}
			if( ( attrIsInstantiable == null ) || ( attrIsInstantiable.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsInstantiable" );
			}
			if( ( attrHasHistory == null ) || ( attrHasHistory.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"HasHistory" );
			}
			if( ( attrHasAuditColumns == null ) || ( attrHasAuditColumns.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"HasAuditColumns" );
			}
			if( ( attrLoaderBehaviourId == null ) || ( attrLoaderBehaviourId.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"LoaderBehaviourId" );
			}
			if( ( attrSecurityScopeId == null ) || ( attrSecurityScopeId.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SecurityScopeId" );
			}
			if( ( attrDefaultVisibility == null ) || ( attrDefaultVisibility.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"DefaultVisibility" );
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
			long natSchemaDefId = Long.parseLong( attrSchemaDefId );

			Long natDefSchemaTenantId;
			if( ( attrDefSchemaTenantId == null ) || ( attrDefSchemaTenantId.length() <= 0 ) ) {
				natDefSchemaTenantId = null;
			}
			else {
				natDefSchemaTenantId = new Long( Long.parseLong( attrDefSchemaTenantId ) );
			}

			Long natDefSchemaId;
			if( ( attrDefSchemaId == null ) || ( attrDefSchemaId.length() <= 0 ) ) {
				natDefSchemaId = null;
			}
			else {
				natDefSchemaId = new Long( Long.parseLong( attrDefSchemaId ) );
			}

			String natName = attrName;

			String natDbName = attrDbName;

			String natShortName = attrShortName;

			String natLabel = attrLabel;

			String natShortDescription = attrShortDescription;

			String natDescription = attrDescription;

			Long natPrimaryIndexTenantId;
			if( ( attrPrimaryIndexTenantId == null ) || ( attrPrimaryIndexTenantId.length() <= 0 ) ) {
				natPrimaryIndexTenantId = null;
			}
			else {
				natPrimaryIndexTenantId = new Long( Long.parseLong( attrPrimaryIndexTenantId ) );
			}

			Long natPrimaryIndexId;
			if( ( attrPrimaryIndexId == null ) || ( attrPrimaryIndexId.length() <= 0 ) ) {
				natPrimaryIndexId = null;
			}
			else {
				natPrimaryIndexId = new Long( Long.parseLong( attrPrimaryIndexId ) );
			}

			String natTableClassCode = attrTableClassCode;

			Long natLookupIndexTenantId;
			if( ( attrLookupIndexTenantId == null ) || ( attrLookupIndexTenantId.length() <= 0 ) ) {
				natLookupIndexTenantId = null;
			}
			else {
				natLookupIndexTenantId = new Long( Long.parseLong( attrLookupIndexTenantId ) );
			}

			Long natLookupIndexId;
			if( ( attrLookupIndexId == null ) || ( attrLookupIndexId.length() <= 0 ) ) {
				natLookupIndexId = null;
			}
			else {
				natLookupIndexId = new Long( Long.parseLong( attrLookupIndexId ) );
			}

			Long natAltIndexTenantId;
			if( ( attrAltIndexTenantId == null ) || ( attrAltIndexTenantId.length() <= 0 ) ) {
				natAltIndexTenantId = null;
			}
			else {
				natAltIndexTenantId = new Long( Long.parseLong( attrAltIndexTenantId ) );
			}

			Long natAltIndexId;
			if( ( attrAltIndexId == null ) || ( attrAltIndexId.length() <= 0 ) ) {
				natAltIndexId = null;
			}
			else {
				natAltIndexId = new Long( Long.parseLong( attrAltIndexId ) );
			}

			Long natQualifyingTenantId;
			if( ( attrQualifyingTenantId == null ) || ( attrQualifyingTenantId.length() <= 0 ) ) {
				natQualifyingTenantId = null;
			}
			else {
				natQualifyingTenantId = new Long( Long.parseLong( attrQualifyingTenantId ) );
			}

			Long natQualifyingTableId;
			if( ( attrQualifyingTableId == null ) || ( attrQualifyingTableId.length() <= 0 ) ) {
				natQualifyingTableId = null;
			}
			else {
				natQualifyingTableId = new Long( Long.parseLong( attrQualifyingTableId ) );
			}

			boolean natPolyBase;
			if( attrPolyBase.equals( "true" ) || attrPolyBase.equals( "yes" ) || attrPolyBase.equals( "1" ) ) {
				natPolyBase = true;
			}
			else if( attrPolyBase.equals( "false" ) || attrPolyBase.equals( "no" ) || attrPolyBase.equals( "0" ) ) {
				natPolyBase = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected PolyBase value, must be one of true, false, yes, no, 1, or 0, not \"" + attrPolyBase + "\"" );
			}

			boolean natIsInstantiable;
			if( attrIsInstantiable.equals( "true" ) || attrIsInstantiable.equals( "yes" ) || attrIsInstantiable.equals( "1" ) ) {
				natIsInstantiable = true;
			}
			else if( attrIsInstantiable.equals( "false" ) || attrIsInstantiable.equals( "no" ) || attrIsInstantiable.equals( "0" ) ) {
				natIsInstantiable = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected IsInstantiable value, must be one of true, false, yes, no, 1, or 0, not \"" + attrIsInstantiable + "\"" );
			}

			boolean natHasHistory;
			if( attrHasHistory.equals( "true" ) || attrHasHistory.equals( "yes" ) || attrHasHistory.equals( "1" ) ) {
				natHasHistory = true;
			}
			else if( attrHasHistory.equals( "false" ) || attrHasHistory.equals( "no" ) || attrHasHistory.equals( "0" ) ) {
				natHasHistory = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected HasHistory value, must be one of true, false, yes, no, 1, or 0, not \"" + attrHasHistory + "\"" );
			}

			boolean natHasAuditColumns;
			if( attrHasAuditColumns.equals( "true" ) || attrHasAuditColumns.equals( "yes" ) || attrHasAuditColumns.equals( "1" ) ) {
				natHasAuditColumns = true;
			}
			else if( attrHasAuditColumns.equals( "false" ) || attrHasAuditColumns.equals( "no" ) || attrHasAuditColumns.equals( "0" ) ) {
				natHasAuditColumns = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected HasAuditColumns value, must be one of true, false, yes, no, 1, or 0, not \"" + attrHasAuditColumns + "\"" );
			}

			short natLoaderBehaviourId = Short.parseShort( attrLoaderBehaviourId );

			Short natDataScopeId;
			if( ( attrDataScopeId == null ) || ( attrDataScopeId.length() <= 0 ) ) {
				natDataScopeId = null;
			}
			else {
				natDataScopeId= new Short( Short.parseShort( attrDataScopeId ) );
			}

			short natSecurityScopeId = Short.parseShort( attrSecurityScopeId );

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

			String natJObjMembers = attrJObjMembers;

			String natJObjInterface = attrJObjInterface;

			String natJObjImport = attrJObjImport;

			String natJObjImplementation = attrJObjImplementation;

			String natJEditObjMembers = attrJEditObjMembers;

			String natJEditObjInterface = attrJEditObjInterface;

			String natJEditObjImport = attrJEditObjImport;

			String natJEditObjImplementation = attrJEditObjImplementation;

			String natJTableImport = attrJTableImport;

			String natJTableMembers = attrJTableMembers;

			String natJTableInterface = attrJTableInterface;

			String natJTableImplementation = attrJTableImplementation;

			String natJTableObjImport = attrJTableObjImport;

			String natJTableObjMembers = attrJTableObjMembers;

			String natJTableObjInterface = attrJTableObjInterface;

			String natJTableObjImplementation = attrJTableObjImplementation;

			String natJDb2LUWTableImport = attrJDb2LUWTableImport;

			String natJDb2LUWTableMembers = attrJDb2LUWTableMembers;

			String natJDb2LUWTableImplementation = attrJDb2LUWTableImplementation;

			String natJMSSqlTableImport = attrJMSSqlTableImport;

			String natJMSSqlTableMembers = attrJMSSqlTableMembers;

			String natJMSSqlTableImplementation = attrJMSSqlTableImplementation;

			String natJMySqlTableImport = attrJMySqlTableImport;

			String natJMySqlTableMembers = attrJMySqlTableMembers;

			String natJMySqlTableImplementation = attrJMySqlTableImplementation;

			String natJOracleTableImport = attrJOracleTableImport;

			String natJOracleTableMembers = attrJOracleTableMembers;

			String natJOracleTableImplementation = attrJOracleTableImplementation;

			String natJPgSqlTableImport = attrJPgSqlTableImport;

			String natJPgSqlTableMembers = attrJPgSqlTableMembers;

			String natJPgSqlTableImplementation = attrJPgSqlTableImplementation;

			String natJSybaseTableImport = attrJSybaseTableImport;

			String natJSybaseTableMembers = attrJSybaseTableMembers;

			String natJSybaseTableImplementation = attrJSybaseTableImplementation;

			String natJRamTableImport = attrJRamTableImport;

			String natJRamTableMembers = attrJRamTableMembers;

			String natJRamTableImplementation = attrJRamTableImplementation;

			String natJSaxLoaderImport = attrJSaxLoaderImport;

			String natJSaxLoaderStartElement = attrJSaxLoaderStartElement;

			String natJSaxLoaderEndElement = attrJSaxLoaderEndElement;

			String natJXMsgTableImport = attrJXMsgTableImport;

			String natJXMsgTableFormatters = attrJXMsgTableFormatters;

			String natJXMsgRqstTableImport = attrJXMsgRqstTableImport;

			String natJXMsgRspnTableImport = attrJXMsgRspnTableImport;

			String natJXMsgClientTableImport = attrJXMsgClientTableImport;

			String natJXMsgRqstTableBody = attrJXMsgRqstTableBody;

			String natJXMsgRspnTableBody = attrJXMsgRspnTableBody;

			String natJXMsgClientTableBody = attrJXMsgClientTableBody;

			boolean natDefaultVisibility;
			if( attrDefaultVisibility.equals( "true" ) || attrDefaultVisibility.equals( "yes" ) || attrDefaultVisibility.equals( "1" ) ) {
				natDefaultVisibility = true;
			}
			else if( attrDefaultVisibility.equals( "false" ) || attrDefaultVisibility.equals( "no" ) || attrDefaultVisibility.equals( "0" ) ) {
				natDefaultVisibility = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected DefaultVisibility value, must be one of true, false, yes, no, 1, or 0, not \"" + attrDefaultVisibility + "\"" );
			}

			// Instantiate a buffer for the parsed information
			ICFBamTableObj obj = schemaObj.getTableTableObj().newInstance();
			CFBamTableBuff dataBuff = obj.getTableBuff();
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
			dataBuff.setRequiredSchemaDefId( natSchemaDefId );
			dataBuff.setOptionalDefSchemaTenantId( natDefSchemaTenantId );
			dataBuff.setOptionalDefSchemaId( natDefSchemaId );
			dataBuff.setRequiredName( natName );
			dataBuff.setOptionalDbName( natDbName );
			dataBuff.setOptionalShortName( natShortName );
			dataBuff.setOptionalLabel( natLabel );
			dataBuff.setOptionalShortDescription( natShortDescription );
			dataBuff.setOptionalDescription( natDescription );
			dataBuff.setOptionalPrimaryIndexTenantId( natPrimaryIndexTenantId );
			dataBuff.setOptionalPrimaryIndexId( natPrimaryIndexId );
			dataBuff.setRequiredTableClassCode( natTableClassCode );
			dataBuff.setOptionalLookupIndexTenantId( natLookupIndexTenantId );
			dataBuff.setOptionalLookupIndexId( natLookupIndexId );
			dataBuff.setOptionalAltIndexTenantId( natAltIndexTenantId );
			dataBuff.setOptionalAltIndexId( natAltIndexId );
			dataBuff.setOptionalQualifyingTenantId( natQualifyingTenantId );
			dataBuff.setOptionalQualifyingTableId( natQualifyingTableId );
			dataBuff.setRequiredPolyBase( natPolyBase );
			dataBuff.setRequiredIsInstantiable( natIsInstantiable );
			dataBuff.setRequiredHasHistory( natHasHistory );
			dataBuff.setRequiredHasAuditColumns( natHasAuditColumns );
			dataBuff.setRequiredLoaderBehaviourId( natLoaderBehaviourId );
			dataBuff.setOptionalDataScopeId( natDataScopeId );
			dataBuff.setRequiredSecurityScopeId( natSecurityScopeId );
			dataBuff.setOptionalViewAccessSecurityId( natViewAccessSecurityId );
			dataBuff.setOptionalEditAccessSecurityId( natEditAccessSecurityId );
			dataBuff.setOptionalViewAccessFrequencyId( natViewAccessFrequencyId );
			dataBuff.setOptionalEditAccessFrequencyId( natEditAccessFrequencyId );
			dataBuff.setOptionalJObjMembers( natJObjMembers );
			dataBuff.setOptionalJObjInterface( natJObjInterface );
			dataBuff.setOptionalJObjImport( natJObjImport );
			dataBuff.setOptionalJObjImplementation( natJObjImplementation );
			dataBuff.setOptionalJEditObjMembers( natJEditObjMembers );
			dataBuff.setOptionalJEditObjInterface( natJEditObjInterface );
			dataBuff.setOptionalJEditObjImport( natJEditObjImport );
			dataBuff.setOptionalJEditObjImplementation( natJEditObjImplementation );
			dataBuff.setOptionalJTableImport( natJTableImport );
			dataBuff.setOptionalJTableMembers( natJTableMembers );
			dataBuff.setOptionalJTableInterface( natJTableInterface );
			dataBuff.setOptionalJTableImplementation( natJTableImplementation );
			dataBuff.setOptionalJTableObjImport( natJTableObjImport );
			dataBuff.setOptionalJTableObjMembers( natJTableObjMembers );
			dataBuff.setOptionalJTableObjInterface( natJTableObjInterface );
			dataBuff.setOptionalJTableObjImplementation( natJTableObjImplementation );
			dataBuff.setOptionalJDb2LUWTableImport( natJDb2LUWTableImport );
			dataBuff.setOptionalJDb2LUWTableMembers( natJDb2LUWTableMembers );
			dataBuff.setOptionalJDb2LUWTableImplementation( natJDb2LUWTableImplementation );
			dataBuff.setOptionalJMSSqlTableImport( natJMSSqlTableImport );
			dataBuff.setOptionalJMSSqlTableMembers( natJMSSqlTableMembers );
			dataBuff.setOptionalJMSSqlTableImplementation( natJMSSqlTableImplementation );
			dataBuff.setOptionalJMySqlTableImport( natJMySqlTableImport );
			dataBuff.setOptionalJMySqlTableMembers( natJMySqlTableMembers );
			dataBuff.setOptionalJMySqlTableImplementation( natJMySqlTableImplementation );
			dataBuff.setOptionalJOracleTableImport( natJOracleTableImport );
			dataBuff.setOptionalJOracleTableMembers( natJOracleTableMembers );
			dataBuff.setOptionalJOracleTableImplementation( natJOracleTableImplementation );
			dataBuff.setOptionalJPgSqlTableImport( natJPgSqlTableImport );
			dataBuff.setOptionalJPgSqlTableMembers( natJPgSqlTableMembers );
			dataBuff.setOptionalJPgSqlTableImplementation( natJPgSqlTableImplementation );
			dataBuff.setOptionalJSybaseTableImport( natJSybaseTableImport );
			dataBuff.setOptionalJSybaseTableMembers( natJSybaseTableMembers );
			dataBuff.setOptionalJSybaseTableImplementation( natJSybaseTableImplementation );
			dataBuff.setOptionalJRamTableImport( natJRamTableImport );
			dataBuff.setOptionalJRamTableMembers( natJRamTableMembers );
			dataBuff.setOptionalJRamTableImplementation( natJRamTableImplementation );
			dataBuff.setOptionalJSaxLoaderImport( natJSaxLoaderImport );
			dataBuff.setOptionalJSaxLoaderStartElement( natJSaxLoaderStartElement );
			dataBuff.setOptionalJSaxLoaderEndElement( natJSaxLoaderEndElement );
			dataBuff.setOptionalJXMsgTableImport( natJXMsgTableImport );
			dataBuff.setOptionalJXMsgTableFormatters( natJXMsgTableFormatters );
			dataBuff.setOptionalJXMsgRqstTableImport( natJXMsgRqstTableImport );
			dataBuff.setOptionalJXMsgRspnTableImport( natJXMsgRspnTableImport );
			dataBuff.setOptionalJXMsgClientTableImport( natJXMsgClientTableImport );
			dataBuff.setOptionalJXMsgRqstTableBody( natJXMsgRqstTableBody );
			dataBuff.setOptionalJXMsgRspnTableBody( natJXMsgRspnTableBody );
			dataBuff.setOptionalJXMsgClientTableBody( natJXMsgClientTableBody );
			dataBuff.setRequiredDefaultVisibility( natDefaultVisibility );
			obj.copyBuffToPKey();
			ICFBamTableObj realized = (ICFBamTableObj)obj.realize();
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
