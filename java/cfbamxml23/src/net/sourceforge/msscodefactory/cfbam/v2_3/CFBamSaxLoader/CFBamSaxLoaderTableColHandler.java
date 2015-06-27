
// Description: Java 7 XML SAX Element Handler for TableCol

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
 *	CFBamSaxLoaderTableColParse XML SAX Element Handler implementation
 *	for TableCol.
 */
public class CFBamSaxLoaderTableColHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamSaxLoaderTableColHandler( CFBamSaxLoader saxLoader ) {
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
			// Value Attributes
			String	attrName = null;
			String	attrShortName = null;
			String	attrLabel = null;
			String	attrShortDescription = null;
			String	attrDescription = null;
			String	attrIsNullable = null;
			String	attrGenerateId = null;
			String	attrDefaultVisibility = null;
			String	attrDefSchema = null;
			String	attrDataScope = null;
			String	attrVAccSec = null;
			String	attrEAccSec = null;
			String	attrVAccFreq = null;
			String	attrEAccFreq = null;
			// Value References
			ICFBamTenantObj refTenant = null;
			ICFBamScopeObj refScope = null;
			ICFBamSchemaDefObj refDefSchema = null;
			ICFBamDataScopeObj refDataScope = null;
			ICFBamAccessSecurityObj refVAccSec = null;
			ICFBamAccessSecurityObj refEAccSec = null;
			ICFBamAccessFrequencyObj refVAccFreq = null;
			ICFBamAccessFrequencyObj refEAccFreq = null;
			// TableCol Attributes
			String	attrDbName = null;
			String	attrDataType = null;
			// TableCol References
			ICFBamTableObj refTable = null;
			ICFBamValueObj refDataType = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "TableCol" );

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
			ICFBamTableColEditObj editBuff = (ICFBamTableColEditObj)schemaObj.getTableColTableObj().newInstance().beginEdit();

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
				else if( attrLocalName.equals( "IsNullable" ) ) {
					if( attrIsNullable != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsNullable = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "GenerateId" ) ) {
					if( attrGenerateId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrGenerateId = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "DbName" ) ) {
					if( attrDbName != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDbName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DataType" ) ) {
					if( attrDataType != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDataType = attrs.getValue( idxAttr );
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
			if( ( attrIsNullable == null ) || ( attrIsNullable.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsNullable" );
			}
			if( ( attrDefaultVisibility == null ) || ( attrDefaultVisibility.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"DefaultVisibility" );
			}
			if( ( attrDataType == null ) || ( attrDataType.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"DataType" );
			}

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "ShortName", attrShortName );
			curContext.putNamedValue( "Label", attrLabel );
			curContext.putNamedValue( "ShortDescription", attrShortDescription );
			curContext.putNamedValue( "Description", attrDescription );
			curContext.putNamedValue( "IsNullable", attrIsNullable );
			curContext.putNamedValue( "GenerateId", attrGenerateId );
			curContext.putNamedValue( "DefaultVisibility", attrDefaultVisibility );
			curContext.putNamedValue( "DefSchema", attrDefSchema );
			curContext.putNamedValue( "DataScope", attrDataScope );
			curContext.putNamedValue( "VAccSec", attrVAccSec );
			curContext.putNamedValue( "EAccSec", attrEAccSec );
			curContext.putNamedValue( "VAccFreq", attrVAccFreq );
			curContext.putNamedValue( "EAccFreq", attrEAccFreq );
			curContext.putNamedValue( "DbName", attrDbName );
			curContext.putNamedValue( "DataType", attrDataType );

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

			String natShortName = attrShortName;
			editBuff.setOptionalShortName( natShortName );

			String natLabel = attrLabel;
			editBuff.setOptionalLabel( natLabel );

			String natShortDescription = attrShortDescription;
			editBuff.setOptionalShortDescription( natShortDescription );

			String natDescription = attrDescription;
			editBuff.setOptionalDescription( natDescription );

			boolean natIsNullable;
			if( attrIsNullable.equals( "true" ) || attrIsNullable.equals( "yes" ) || attrIsNullable.equals( "1" ) ) {
				natIsNullable = true;
			}
			else if( attrIsNullable.equals( "false" ) || attrIsNullable.equals( "no" ) || attrIsNullable.equals( "0" ) ) {
				natIsNullable = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected IsNullable value, must be one of true, false, yes, no, 1, or 0, not \"" + attrIsNullable + "\"" );
			}
			editBuff.setRequiredIsNullable( natIsNullable );

			Boolean natGenerateId;
			if( ( attrGenerateId == null ) || ( attrGenerateId.length() <= 0 ) ) {
				natGenerateId = null;
			}
			else if( attrGenerateId.equals( "true" ) || attrGenerateId.equals( "yes" ) || attrGenerateId.equals( "1" ) ) {
				natGenerateId = true;
			}
			else if( attrGenerateId.equals( "false" ) || attrGenerateId.equals( "no" ) || attrGenerateId.equals( "0" ) ) {
				natGenerateId = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected GenerateId value, must be one of true, false, yes, no, 1, or 0, not \"" + attrGenerateId + "\"" );
			}
			editBuff.setOptionalGenerateId( natGenerateId );

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

			String natDbName = attrDbName;
			editBuff.setOptionalDbName( natDbName );

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
			else if( scopeObj instanceof ICFBamTableObj ) {
				refTable = (ICFBamTableObj) scopeObj;
				editBuff.setRequiredContainerTable( refTable );
				refTenant = editBuff.getRequiredOwnerTenant();
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ICFBamTableObj" );
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

			refScope = refTable;
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

			// Lookup refDataType by qualified name
			if( ( attrDataType != null ) && ( attrDataType.length() > 0 ) ) {
				refDataType = (ICFBamValueObj)(editBuff.getNamedObject( schemaObj.getValueTableObj().getObjQualifyingClass(),
					attrDataType ) );
				if( refDataType == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve DataType reference qualified name \"" + attrDataType + "\" to table Value" );
				}
			}
			else {
				refDataType = null;
			}
			editBuff.setRequiredParentDataType( refDataType );

			CFBamSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getTableColLoaderBehaviour();
			ICFBamTableColEditObj editTableCol = null;
			ICFBamTableColObj origTableCol = schemaObj.getTableColTableObj().readTableColByUNameIdx( refTenant.getRequiredId(),
			refScope.getRequiredId(),
			editBuff.getRequiredName() );
			if( origTableCol == null ) {
				editTableCol = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editTableCol = (ICFBamTableColEditObj)origTableCol.beginEdit();
						editTableCol.setRequiredName( editBuff.getRequiredName() );
						editTableCol.setOptionalShortName( editBuff.getOptionalShortName() );
						editTableCol.setOptionalLabel( editBuff.getOptionalLabel() );
						editTableCol.setOptionalShortDescription( editBuff.getOptionalShortDescription() );
						editTableCol.setOptionalDescription( editBuff.getOptionalDescription() );
						editTableCol.setRequiredIsNullable( editBuff.getRequiredIsNullable() );
						editTableCol.setOptionalGenerateId( editBuff.getOptionalGenerateId() );
						editTableCol.setRequiredDefaultVisibility( editBuff.getRequiredDefaultVisibility() );
						editTableCol.setOptionalDbName( editBuff.getOptionalDbName() );
						editTableCol.setOptionalLookupDefSchema( editBuff.getOptionalLookupDefSchema() );
						editTableCol.setOptionalLookupDataScope( editBuff.getOptionalLookupDataScope() );
						editTableCol.setOptionalLookupVAccSec( editBuff.getOptionalLookupVAccSec() );
						editTableCol.setOptionalLookupEAccSec( editBuff.getOptionalLookupEAccSec() );
						editTableCol.setOptionalLookupVAccFreq( editBuff.getOptionalLookupVAccFreq() );
						editTableCol.setOptionalLookupEAccFreq( editBuff.getOptionalLookupEAccFreq() );
						editTableCol.setRequiredParentDataType( editBuff.getRequiredParentDataType() );
						break;
					case Replace:
						editTableCol = (ICFBamTableColEditObj)origTableCol.beginEdit();
						editTableCol.delete();
						editTableCol.endEdit();
						origTableCol = null;
						editTableCol = editBuff;
						break;
				}
			}

			if( editTableCol != null ) {
				if( origTableCol != null ) {
					editTableCol.update();
				}
				else {
					origTableCol = (ICFBamTableColObj)editTableCol.create();
				}
				editTableCol.endEdit();
			}

			curContext.putNamedValue( "Object", origTableCol );
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
