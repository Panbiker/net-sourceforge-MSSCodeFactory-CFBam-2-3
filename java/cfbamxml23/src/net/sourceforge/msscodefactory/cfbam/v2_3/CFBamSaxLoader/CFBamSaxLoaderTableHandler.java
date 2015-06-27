
// Description: Java 7 XML SAX Element Handler for Table

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
 *	CFBamSaxLoaderTableParse XML SAX Element Handler implementation
 *	for Table.
 */
public class CFBamSaxLoaderTableHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamSaxLoaderTableHandler( CFBamSaxLoader saxLoader ) {
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
			// Table Attributes
			String	attrName = null;
			String	attrDbName = null;
			String	attrShortName = null;
			String	attrLabel = null;
			String	attrShortDescription = null;
			String	attrDescription = null;
			String	attrTableClassCode = null;
			String	attrPolyBase = null;
			String	attrIsInstantiable = null;
			String	attrHasHistory = null;
			String	attrHasAuditColumns = null;
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
			String	attrDefSchema = null;
			String	attrLookupIndex = null;
			String	attrAltIndex = null;
			String	attrQualTable = null;
			String	attrLoaderBehaviour = null;
			String	attrPrimaryIndex = null;
			String	attrDataScope = null;
			String	attrSecScope = null;
			String	attrVAccSec = null;
			String	attrEAccSec = null;
			String	attrVAccFreq = null;
			String	attrEAccFreq = null;
			// Table References
			ICFBamSchemaDefObj refSchemaDef = null;
			ICFBamSchemaDefObj refDefSchema = null;
			ICFBamIndexObj refLookupIndex = null;
			ICFBamIndexObj refAltIndex = null;
			ICFBamTableObj refQualTable = null;
			ICFBamLoaderBehaviourObj refLoaderBehaviour = null;
			ICFBamIndexObj refPrimaryIndex = null;
			ICFBamDataScopeObj refDataScope = null;
			ICFBamSecurityScopeObj refSecScope = null;
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

			assert qName.equals( "Table" );

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
			ICFBamTableEditObj editBuff = (ICFBamTableEditObj)schemaObj.getTableTableObj().newInstance().beginEdit();

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
				else if( attrLocalName.equals( "TableClassCode" ) ) {
					if( attrTableClassCode != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTableClassCode = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "DefSchema" ) ) {
					if( attrDefSchema != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefSchema = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "LookupIndex" ) ) {
					if( attrLookupIndex != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLookupIndex = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "AltIndex" ) ) {
					if( attrAltIndex != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrAltIndex = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "QualTable" ) ) {
					if( attrQualTable != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrQualTable = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "LoaderBehaviour" ) ) {
					if( attrLoaderBehaviour != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLoaderBehaviour = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PrimaryIndex" ) ) {
					if( attrPrimaryIndex != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPrimaryIndex = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "SecScope" ) ) {
					if( attrSecScope != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSecScope = attrs.getValue( idxAttr );
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
			if( ( attrDefaultVisibility == null ) || ( attrDefaultVisibility.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"DefaultVisibility" );
			}
			if( ( attrLoaderBehaviour == null ) || ( attrLoaderBehaviour.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"LoaderBehaviour" );
			}
			if( ( attrSecScope == null ) || ( attrSecScope.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SecScope" );
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
			curContext.putNamedValue( "TableClassCode", attrTableClassCode );
			curContext.putNamedValue( "PolyBase", attrPolyBase );
			curContext.putNamedValue( "IsInstantiable", attrIsInstantiable );
			curContext.putNamedValue( "HasHistory", attrHasHistory );
			curContext.putNamedValue( "HasAuditColumns", attrHasAuditColumns );
			curContext.putNamedValue( "JObjMembers", attrJObjMembers );
			curContext.putNamedValue( "JObjInterface", attrJObjInterface );
			curContext.putNamedValue( "JObjImport", attrJObjImport );
			curContext.putNamedValue( "JObjImplementation", attrJObjImplementation );
			curContext.putNamedValue( "JEditObjMembers", attrJEditObjMembers );
			curContext.putNamedValue( "JEditObjInterface", attrJEditObjInterface );
			curContext.putNamedValue( "JEditObjImport", attrJEditObjImport );
			curContext.putNamedValue( "JEditObjImplementation", attrJEditObjImplementation );
			curContext.putNamedValue( "JTableImport", attrJTableImport );
			curContext.putNamedValue( "JTableMembers", attrJTableMembers );
			curContext.putNamedValue( "JTableInterface", attrJTableInterface );
			curContext.putNamedValue( "JTableImplementation", attrJTableImplementation );
			curContext.putNamedValue( "JTableObjImport", attrJTableObjImport );
			curContext.putNamedValue( "JTableObjMembers", attrJTableObjMembers );
			curContext.putNamedValue( "JTableObjInterface", attrJTableObjInterface );
			curContext.putNamedValue( "JTableObjImplementation", attrJTableObjImplementation );
			curContext.putNamedValue( "JDb2LUWTableImport", attrJDb2LUWTableImport );
			curContext.putNamedValue( "JDb2LUWTableMembers", attrJDb2LUWTableMembers );
			curContext.putNamedValue( "JDb2LUWTableImplementation", attrJDb2LUWTableImplementation );
			curContext.putNamedValue( "JMSSqlTableImport", attrJMSSqlTableImport );
			curContext.putNamedValue( "JMSSqlTableMembers", attrJMSSqlTableMembers );
			curContext.putNamedValue( "JMSSqlTableImplementation", attrJMSSqlTableImplementation );
			curContext.putNamedValue( "JMySqlTableImport", attrJMySqlTableImport );
			curContext.putNamedValue( "JMySqlTableMembers", attrJMySqlTableMembers );
			curContext.putNamedValue( "JMySqlTableImplementation", attrJMySqlTableImplementation );
			curContext.putNamedValue( "JOracleTableImport", attrJOracleTableImport );
			curContext.putNamedValue( "JOracleTableMembers", attrJOracleTableMembers );
			curContext.putNamedValue( "JOracleTableImplementation", attrJOracleTableImplementation );
			curContext.putNamedValue( "JPgSqlTableImport", attrJPgSqlTableImport );
			curContext.putNamedValue( "JPgSqlTableMembers", attrJPgSqlTableMembers );
			curContext.putNamedValue( "JPgSqlTableImplementation", attrJPgSqlTableImplementation );
			curContext.putNamedValue( "JSybaseTableImport", attrJSybaseTableImport );
			curContext.putNamedValue( "JSybaseTableMembers", attrJSybaseTableMembers );
			curContext.putNamedValue( "JSybaseTableImplementation", attrJSybaseTableImplementation );
			curContext.putNamedValue( "JRamTableImport", attrJRamTableImport );
			curContext.putNamedValue( "JRamTableMembers", attrJRamTableMembers );
			curContext.putNamedValue( "JRamTableImplementation", attrJRamTableImplementation );
			curContext.putNamedValue( "JSaxLoaderImport", attrJSaxLoaderImport );
			curContext.putNamedValue( "JSaxLoaderStartElement", attrJSaxLoaderStartElement );
			curContext.putNamedValue( "JSaxLoaderEndElement", attrJSaxLoaderEndElement );
			curContext.putNamedValue( "JXMsgTableImport", attrJXMsgTableImport );
			curContext.putNamedValue( "JXMsgTableFormatters", attrJXMsgTableFormatters );
			curContext.putNamedValue( "JXMsgRqstTableImport", attrJXMsgRqstTableImport );
			curContext.putNamedValue( "JXMsgRspnTableImport", attrJXMsgRspnTableImport );
			curContext.putNamedValue( "JXMsgClientTableImport", attrJXMsgClientTableImport );
			curContext.putNamedValue( "JXMsgRqstTableBody", attrJXMsgRqstTableBody );
			curContext.putNamedValue( "JXMsgRspnTableBody", attrJXMsgRspnTableBody );
			curContext.putNamedValue( "JXMsgClientTableBody", attrJXMsgClientTableBody );
			curContext.putNamedValue( "DefaultVisibility", attrDefaultVisibility );
			curContext.putNamedValue( "DefSchema", attrDefSchema );
			curContext.putNamedValue( "LookupIndex", attrLookupIndex );
			curContext.putNamedValue( "AltIndex", attrAltIndex );
			curContext.putNamedValue( "QualTable", attrQualTable );
			curContext.putNamedValue( "LoaderBehaviour", attrLoaderBehaviour );
			curContext.putNamedValue( "PrimaryIndex", attrPrimaryIndex );
			curContext.putNamedValue( "DataScope", attrDataScope );
			curContext.putNamedValue( "SecScope", attrSecScope );
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

			String natTableClassCode = attrTableClassCode;
			editBuff.setRequiredTableClassCode( natTableClassCode );

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
			editBuff.setRequiredPolyBase( natPolyBase );

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
			editBuff.setRequiredIsInstantiable( natIsInstantiable );

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
			editBuff.setRequiredHasHistory( natHasHistory );

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
			editBuff.setRequiredHasAuditColumns( natHasAuditColumns );

			String natJObjMembers = attrJObjMembers;
			editBuff.setOptionalJObjMembers( natJObjMembers );

			String natJObjInterface = attrJObjInterface;
			editBuff.setOptionalJObjInterface( natJObjInterface );

			String natJObjImport = attrJObjImport;
			editBuff.setOptionalJObjImport( natJObjImport );

			String natJObjImplementation = attrJObjImplementation;
			editBuff.setOptionalJObjImplementation( natJObjImplementation );

			String natJEditObjMembers = attrJEditObjMembers;
			editBuff.setOptionalJEditObjMembers( natJEditObjMembers );

			String natJEditObjInterface = attrJEditObjInterface;
			editBuff.setOptionalJEditObjInterface( natJEditObjInterface );

			String natJEditObjImport = attrJEditObjImport;
			editBuff.setOptionalJEditObjImport( natJEditObjImport );

			String natJEditObjImplementation = attrJEditObjImplementation;
			editBuff.setOptionalJEditObjImplementation( natJEditObjImplementation );

			String natJTableImport = attrJTableImport;
			editBuff.setOptionalJTableImport( natJTableImport );

			String natJTableMembers = attrJTableMembers;
			editBuff.setOptionalJTableMembers( natJTableMembers );

			String natJTableInterface = attrJTableInterface;
			editBuff.setOptionalJTableInterface( natJTableInterface );

			String natJTableImplementation = attrJTableImplementation;
			editBuff.setOptionalJTableImplementation( natJTableImplementation );

			String natJTableObjImport = attrJTableObjImport;
			editBuff.setOptionalJTableObjImport( natJTableObjImport );

			String natJTableObjMembers = attrJTableObjMembers;
			editBuff.setOptionalJTableObjMembers( natJTableObjMembers );

			String natJTableObjInterface = attrJTableObjInterface;
			editBuff.setOptionalJTableObjInterface( natJTableObjInterface );

			String natJTableObjImplementation = attrJTableObjImplementation;
			editBuff.setOptionalJTableObjImplementation( natJTableObjImplementation );

			String natJDb2LUWTableImport = attrJDb2LUWTableImport;
			editBuff.setOptionalJDb2LUWTableImport( natJDb2LUWTableImport );

			String natJDb2LUWTableMembers = attrJDb2LUWTableMembers;
			editBuff.setOptionalJDb2LUWTableMembers( natJDb2LUWTableMembers );

			String natJDb2LUWTableImplementation = attrJDb2LUWTableImplementation;
			editBuff.setOptionalJDb2LUWTableImplementation( natJDb2LUWTableImplementation );

			String natJMSSqlTableImport = attrJMSSqlTableImport;
			editBuff.setOptionalJMSSqlTableImport( natJMSSqlTableImport );

			String natJMSSqlTableMembers = attrJMSSqlTableMembers;
			editBuff.setOptionalJMSSqlTableMembers( natJMSSqlTableMembers );

			String natJMSSqlTableImplementation = attrJMSSqlTableImplementation;
			editBuff.setOptionalJMSSqlTableImplementation( natJMSSqlTableImplementation );

			String natJMySqlTableImport = attrJMySqlTableImport;
			editBuff.setOptionalJMySqlTableImport( natJMySqlTableImport );

			String natJMySqlTableMembers = attrJMySqlTableMembers;
			editBuff.setOptionalJMySqlTableMembers( natJMySqlTableMembers );

			String natJMySqlTableImplementation = attrJMySqlTableImplementation;
			editBuff.setOptionalJMySqlTableImplementation( natJMySqlTableImplementation );

			String natJOracleTableImport = attrJOracleTableImport;
			editBuff.setOptionalJOracleTableImport( natJOracleTableImport );

			String natJOracleTableMembers = attrJOracleTableMembers;
			editBuff.setOptionalJOracleTableMembers( natJOracleTableMembers );

			String natJOracleTableImplementation = attrJOracleTableImplementation;
			editBuff.setOptionalJOracleTableImplementation( natJOracleTableImplementation );

			String natJPgSqlTableImport = attrJPgSqlTableImport;
			editBuff.setOptionalJPgSqlTableImport( natJPgSqlTableImport );

			String natJPgSqlTableMembers = attrJPgSqlTableMembers;
			editBuff.setOptionalJPgSqlTableMembers( natJPgSqlTableMembers );

			String natJPgSqlTableImplementation = attrJPgSqlTableImplementation;
			editBuff.setOptionalJPgSqlTableImplementation( natJPgSqlTableImplementation );

			String natJSybaseTableImport = attrJSybaseTableImport;
			editBuff.setOptionalJSybaseTableImport( natJSybaseTableImport );

			String natJSybaseTableMembers = attrJSybaseTableMembers;
			editBuff.setOptionalJSybaseTableMembers( natJSybaseTableMembers );

			String natJSybaseTableImplementation = attrJSybaseTableImplementation;
			editBuff.setOptionalJSybaseTableImplementation( natJSybaseTableImplementation );

			String natJRamTableImport = attrJRamTableImport;
			editBuff.setOptionalJRamTableImport( natJRamTableImport );

			String natJRamTableMembers = attrJRamTableMembers;
			editBuff.setOptionalJRamTableMembers( natJRamTableMembers );

			String natJRamTableImplementation = attrJRamTableImplementation;
			editBuff.setOptionalJRamTableImplementation( natJRamTableImplementation );

			String natJSaxLoaderImport = attrJSaxLoaderImport;
			editBuff.setOptionalJSaxLoaderImport( natJSaxLoaderImport );

			String natJSaxLoaderStartElement = attrJSaxLoaderStartElement;
			editBuff.setOptionalJSaxLoaderStartElement( natJSaxLoaderStartElement );

			String natJSaxLoaderEndElement = attrJSaxLoaderEndElement;
			editBuff.setOptionalJSaxLoaderEndElement( natJSaxLoaderEndElement );

			String natJXMsgTableImport = attrJXMsgTableImport;
			editBuff.setOptionalJXMsgTableImport( natJXMsgTableImport );

			String natJXMsgTableFormatters = attrJXMsgTableFormatters;
			editBuff.setOptionalJXMsgTableFormatters( natJXMsgTableFormatters );

			String natJXMsgRqstTableImport = attrJXMsgRqstTableImport;
			editBuff.setOptionalJXMsgRqstTableImport( natJXMsgRqstTableImport );

			String natJXMsgRspnTableImport = attrJXMsgRspnTableImport;
			editBuff.setOptionalJXMsgRspnTableImport( natJXMsgRspnTableImport );

			String natJXMsgClientTableImport = attrJXMsgClientTableImport;
			editBuff.setOptionalJXMsgClientTableImport( natJXMsgClientTableImport );

			String natJXMsgRqstTableBody = attrJXMsgRqstTableBody;
			editBuff.setOptionalJXMsgRqstTableBody( natJXMsgRqstTableBody );

			String natJXMsgRspnTableBody = attrJXMsgRspnTableBody;
			editBuff.setOptionalJXMsgRspnTableBody( natJXMsgRspnTableBody );

			String natJXMsgClientTableBody = attrJXMsgClientTableBody;
			editBuff.setOptionalJXMsgClientTableBody( natJXMsgClientTableBody );

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
			editBuff.setRequiredDefaultVisibility( natDefaultVisibility );

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
			else if( scopeObj instanceof ICFBamSchemaDefObj ) {
				refSchemaDef = (ICFBamSchemaDefObj) scopeObj;
				editBuff.setRequiredContainerSchemaDef( refSchemaDef );
				refTenant = editBuff.getRequiredOwnerTenant();
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ICFBamSchemaDefObj" );
			}

			// Resolve and apply Owner reference
 
			if( refTenant == null ) {
				if( scopeObj instanceof ICFBamTenantObj ) {
					refTenant = (ICFBamTenantObj) scopeObj;
					editBuff.setRequiredOwnerTenant( refTenant );
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Owner<Tenant>" );
				}
			}

			// Lookup refDefSchema by qualified name
			if( ( attrDefSchema != null ) && ( attrDefSchema.length() > 0 ) ) {
				refDefSchema = (ICFBamSchemaDefObj)(editBuff.getNamedObject( schemaObj.getSchemaDefTableObj().getObjQualifyingClass(),
					attrDefSchema ) );
				if( refDefSchema == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve DefSchema reference qualified name \"" + attrDefSchema + "\" to table SchemaDef" );
				}
			}
			else {
				refDefSchema = null;
			}
			editBuff.setOptionalLookupDefSchema( refDefSchema );

			// Lookup refLookupIndex by qualified name
			if( ( attrLookupIndex != null ) && ( attrLookupIndex.length() > 0 ) ) {
				refLookupIndex = (ICFBamIndexObj)(editBuff.getNamedObject( schemaObj.getIndexTableObj().getObjQualifyingClass(),
					attrLookupIndex ) );
				if( refLookupIndex == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve LookupIndex reference qualified name \"" + attrLookupIndex + "\" to table Index" );
				}
			}
			else {
				refLookupIndex = null;
			}
			editBuff.setOptionalLookupLookupIndex( refLookupIndex );

			// Lookup refAltIndex by qualified name
			if( ( attrAltIndex != null ) && ( attrAltIndex.length() > 0 ) ) {
				refAltIndex = (ICFBamIndexObj)(editBuff.getNamedObject( schemaObj.getIndexTableObj().getObjQualifyingClass(),
					attrAltIndex ) );
				if( refAltIndex == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve AltIndex reference qualified name \"" + attrAltIndex + "\" to table Index" );
				}
			}
			else {
				refAltIndex = null;
			}
			editBuff.setOptionalLookupAltIndex( refAltIndex );

			// Lookup refQualTable by qualified name
			if( ( attrQualTable != null ) && ( attrQualTable.length() > 0 ) ) {
				refQualTable = (ICFBamTableObj)(editBuff.getNamedObject( schemaObj.getTableTableObj().getObjQualifyingClass(),
					attrQualTable ) );
				if( refQualTable == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve QualTable reference qualified name \"" + attrQualTable + "\" to table Table" );
				}
			}
			else {
				refQualTable = null;
			}
			editBuff.setOptionalLookupQualTable( refQualTable );

			// Lookup refLoaderBehaviour by key name value attr
			if( ( attrLoaderBehaviour != null ) && ( attrLoaderBehaviour.length() > 0 ) ) {
				refLoaderBehaviour = schemaObj.getLoaderBehaviourTableObj().readLoaderBehaviourByUNameIdx( attrLoaderBehaviour );
				if( refLoaderBehaviour == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve LoaderBehaviour reference named \"" + attrLoaderBehaviour + "\" to table LoaderBehaviour" );
				}
			}
			else {
				refLoaderBehaviour = null;
			}
			editBuff.setRequiredLookupLoaderBehaviour( refLoaderBehaviour );

			// Lookup refPrimaryIndex by qualified name
			if( ( attrPrimaryIndex != null ) && ( attrPrimaryIndex.length() > 0 ) ) {
				refPrimaryIndex = (ICFBamIndexObj)(editBuff.getNamedObject( schemaObj.getIndexTableObj().getObjQualifyingClass(),
					attrPrimaryIndex ) );
				if( refPrimaryIndex == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve PrimaryIndex reference qualified name \"" + attrPrimaryIndex + "\" to table Index" );
				}
			}
			else {
				refPrimaryIndex = null;
			}
			editBuff.setOptionalLookupPrimaryIndex( refPrimaryIndex );

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

			// Lookup refSecScope by key name value attr
			if( ( attrSecScope != null ) && ( attrSecScope.length() > 0 ) ) {
				refSecScope = schemaObj.getSecurityScopeTableObj().readSecurityScopeByUNameIdx( attrSecScope );
				if( refSecScope == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve SecScope reference named \"" + attrSecScope + "\" to table SecurityScope" );
				}
			}
			else {
				refSecScope = null;
			}
			editBuff.setRequiredLookupSecScope( refSecScope );

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

			CFBamSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getTableLoaderBehaviour();
			ICFBamTableEditObj editTable = null;
			ICFBamTableObj origTable = schemaObj.getTableTableObj().readTableByUNameIdx( refSchemaDef.getRequiredTenantId(),
			refSchemaDef.getRequiredId(),
			editBuff.getRequiredName() );
			if( origTable == null ) {
				editTable = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editTable = (ICFBamTableEditObj)origTable.beginEdit();
						editTable.setRequiredName( editBuff.getRequiredName() );
						editTable.setOptionalDbName( editBuff.getOptionalDbName() );
						editTable.setOptionalShortName( editBuff.getOptionalShortName() );
						editTable.setOptionalLabel( editBuff.getOptionalLabel() );
						editTable.setOptionalShortDescription( editBuff.getOptionalShortDescription() );
						editTable.setOptionalDescription( editBuff.getOptionalDescription() );
						editTable.setRequiredTableClassCode( editBuff.getRequiredTableClassCode() );
						editTable.setRequiredPolyBase( editBuff.getRequiredPolyBase() );
						editTable.setRequiredIsInstantiable( editBuff.getRequiredIsInstantiable() );
						editTable.setRequiredHasHistory( editBuff.getRequiredHasHistory() );
						editTable.setRequiredHasAuditColumns( editBuff.getRequiredHasAuditColumns() );
						editTable.setOptionalJObjMembers( editBuff.getOptionalJObjMembers() );
						editTable.setOptionalJObjInterface( editBuff.getOptionalJObjInterface() );
						editTable.setOptionalJObjImport( editBuff.getOptionalJObjImport() );
						editTable.setOptionalJObjImplementation( editBuff.getOptionalJObjImplementation() );
						editTable.setOptionalJEditObjMembers( editBuff.getOptionalJEditObjMembers() );
						editTable.setOptionalJEditObjInterface( editBuff.getOptionalJEditObjInterface() );
						editTable.setOptionalJEditObjImport( editBuff.getOptionalJEditObjImport() );
						editTable.setOptionalJEditObjImplementation( editBuff.getOptionalJEditObjImplementation() );
						editTable.setOptionalJTableImport( editBuff.getOptionalJTableImport() );
						editTable.setOptionalJTableMembers( editBuff.getOptionalJTableMembers() );
						editTable.setOptionalJTableInterface( editBuff.getOptionalJTableInterface() );
						editTable.setOptionalJTableImplementation( editBuff.getOptionalJTableImplementation() );
						editTable.setOptionalJTableObjImport( editBuff.getOptionalJTableObjImport() );
						editTable.setOptionalJTableObjMembers( editBuff.getOptionalJTableObjMembers() );
						editTable.setOptionalJTableObjInterface( editBuff.getOptionalJTableObjInterface() );
						editTable.setOptionalJTableObjImplementation( editBuff.getOptionalJTableObjImplementation() );
						editTable.setOptionalJDb2LUWTableImport( editBuff.getOptionalJDb2LUWTableImport() );
						editTable.setOptionalJDb2LUWTableMembers( editBuff.getOptionalJDb2LUWTableMembers() );
						editTable.setOptionalJDb2LUWTableImplementation( editBuff.getOptionalJDb2LUWTableImplementation() );
						editTable.setOptionalJMSSqlTableImport( editBuff.getOptionalJMSSqlTableImport() );
						editTable.setOptionalJMSSqlTableMembers( editBuff.getOptionalJMSSqlTableMembers() );
						editTable.setOptionalJMSSqlTableImplementation( editBuff.getOptionalJMSSqlTableImplementation() );
						editTable.setOptionalJMySqlTableImport( editBuff.getOptionalJMySqlTableImport() );
						editTable.setOptionalJMySqlTableMembers( editBuff.getOptionalJMySqlTableMembers() );
						editTable.setOptionalJMySqlTableImplementation( editBuff.getOptionalJMySqlTableImplementation() );
						editTable.setOptionalJOracleTableImport( editBuff.getOptionalJOracleTableImport() );
						editTable.setOptionalJOracleTableMembers( editBuff.getOptionalJOracleTableMembers() );
						editTable.setOptionalJOracleTableImplementation( editBuff.getOptionalJOracleTableImplementation() );
						editTable.setOptionalJPgSqlTableImport( editBuff.getOptionalJPgSqlTableImport() );
						editTable.setOptionalJPgSqlTableMembers( editBuff.getOptionalJPgSqlTableMembers() );
						editTable.setOptionalJPgSqlTableImplementation( editBuff.getOptionalJPgSqlTableImplementation() );
						editTable.setOptionalJSybaseTableImport( editBuff.getOptionalJSybaseTableImport() );
						editTable.setOptionalJSybaseTableMembers( editBuff.getOptionalJSybaseTableMembers() );
						editTable.setOptionalJSybaseTableImplementation( editBuff.getOptionalJSybaseTableImplementation() );
						editTable.setOptionalJRamTableImport( editBuff.getOptionalJRamTableImport() );
						editTable.setOptionalJRamTableMembers( editBuff.getOptionalJRamTableMembers() );
						editTable.setOptionalJRamTableImplementation( editBuff.getOptionalJRamTableImplementation() );
						editTable.setOptionalJSaxLoaderImport( editBuff.getOptionalJSaxLoaderImport() );
						editTable.setOptionalJSaxLoaderStartElement( editBuff.getOptionalJSaxLoaderStartElement() );
						editTable.setOptionalJSaxLoaderEndElement( editBuff.getOptionalJSaxLoaderEndElement() );
						editTable.setOptionalJXMsgTableImport( editBuff.getOptionalJXMsgTableImport() );
						editTable.setOptionalJXMsgTableFormatters( editBuff.getOptionalJXMsgTableFormatters() );
						editTable.setOptionalJXMsgRqstTableImport( editBuff.getOptionalJXMsgRqstTableImport() );
						editTable.setOptionalJXMsgRspnTableImport( editBuff.getOptionalJXMsgRspnTableImport() );
						editTable.setOptionalJXMsgClientTableImport( editBuff.getOptionalJXMsgClientTableImport() );
						editTable.setOptionalJXMsgRqstTableBody( editBuff.getOptionalJXMsgRqstTableBody() );
						editTable.setOptionalJXMsgRspnTableBody( editBuff.getOptionalJXMsgRspnTableBody() );
						editTable.setOptionalJXMsgClientTableBody( editBuff.getOptionalJXMsgClientTableBody() );
						editTable.setRequiredDefaultVisibility( editBuff.getRequiredDefaultVisibility() );
						editTable.setOptionalLookupDefSchema( editBuff.getOptionalLookupDefSchema() );
						editTable.setOptionalLookupLookupIndex( editBuff.getOptionalLookupLookupIndex() );
						editTable.setOptionalLookupAltIndex( editBuff.getOptionalLookupAltIndex() );
						editTable.setOptionalLookupQualTable( editBuff.getOptionalLookupQualTable() );
						editTable.setRequiredLookupLoaderBehaviour( editBuff.getRequiredLookupLoaderBehaviour() );
						editTable.setOptionalLookupPrimaryIndex( editBuff.getOptionalLookupPrimaryIndex() );
						editTable.setOptionalLookupDataScope( editBuff.getOptionalLookupDataScope() );
						editTable.setRequiredLookupSecScope( editBuff.getRequiredLookupSecScope() );
						editTable.setOptionalLookupVAccSec( editBuff.getOptionalLookupVAccSec() );
						editTable.setOptionalLookupEAccSec( editBuff.getOptionalLookupEAccSec() );
						editTable.setOptionalLookupVAccFreq( editBuff.getOptionalLookupVAccFreq() );
						editTable.setOptionalLookupEAccFreq( editBuff.getOptionalLookupEAccFreq() );
						break;
					case Replace:
						editTable = (ICFBamTableEditObj)origTable.beginEdit();
						editTable.delete();
						editTable.endEdit();
						origTable = null;
						editTable = editBuff;
						break;
				}
			}

			if( editTable != null ) {
				if( origTable != null ) {
					editTable.update();
				}
				else {
					origTable = (ICFBamTableObj)editTable.create();
				}
				editTable.endEdit();
			}

			curContext.putNamedValue( "Object", origTable );
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
