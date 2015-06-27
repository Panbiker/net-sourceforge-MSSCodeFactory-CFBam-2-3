
// Description: Java 7 XML SAX Element Handler for UInt64Col

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
 *	CFBamSaxLoaderUInt64ColParse XML SAX Element Handler implementation
 *	for UInt64Col.
 */
public class CFBamSaxLoaderUInt64ColHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamSaxLoaderUInt64ColHandler( CFBamSaxLoader saxLoader ) {
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
			// Atom Attributes
			String	attrDbName = null;
			// Atom References
			// UInt64Def Attributes
			String	attrInitValue = null;
			String	attrDefaultValue = null;
			String	attrMinValue = null;
			String	attrMaxValue = null;
			String	attrNullValue = null;
			String	attrUnknownValue = null;
			// UInt64Def References
			// UInt64Col Attributes
			// UInt64Col References
			ICFBamTableObj refTable = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "UInt64Col" );

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
			ICFBamUInt64ColEditObj editBuff = (ICFBamUInt64ColEditObj)schemaObj.getUInt64ColTableObj().newInstance().beginEdit();

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
				else if( attrLocalName.equals( "InitValue" ) ) {
					if( attrInitValue != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrInitValue = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefaultValue" ) ) {
					if( attrDefaultValue != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefaultValue = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "MinValue" ) ) {
					if( attrMinValue != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrMinValue = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "MaxValue" ) ) {
					if( attrMaxValue != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrMaxValue = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "NullValue" ) ) {
					if( attrNullValue != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrNullValue = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "UnknownValue" ) ) {
					if( attrUnknownValue != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrUnknownValue = attrs.getValue( idxAttr );
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
			curContext.putNamedValue( "InitValue", attrInitValue );
			curContext.putNamedValue( "DefaultValue", attrDefaultValue );
			curContext.putNamedValue( "MinValue", attrMinValue );
			curContext.putNamedValue( "MaxValue", attrMaxValue );
			curContext.putNamedValue( "NullValue", attrNullValue );
			curContext.putNamedValue( "UnknownValue", attrUnknownValue );

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

			BigDecimal natInitValue;
			if( ( attrInitValue == null ) || ( attrInitValue.length() <= 0 ) ) {
				natInitValue = null;
			}
			else {
				natInitValue= new BigDecimal( attrInitValue );
			}
			editBuff.setOptionalInitValue( natInitValue );

			BigDecimal natDefaultValue;
			if( ( attrDefaultValue == null ) || ( attrDefaultValue.length() <= 0 ) ) {
				natDefaultValue = null;
			}
			else {
				natDefaultValue= new BigDecimal( attrDefaultValue );
			}
			editBuff.setOptionalDefaultValue( natDefaultValue );

			BigDecimal natMinValue;
			if( ( attrMinValue == null ) || ( attrMinValue.length() <= 0 ) ) {
				natMinValue = null;
			}
			else {
				natMinValue= new BigDecimal( attrMinValue );
			}
			editBuff.setOptionalMinValue( natMinValue );

			BigDecimal natMaxValue;
			if( ( attrMaxValue == null ) || ( attrMaxValue.length() <= 0 ) ) {
				natMaxValue = null;
			}
			else {
				natMaxValue= new BigDecimal( attrMaxValue );
			}
			editBuff.setOptionalMaxValue( natMaxValue );

			BigDecimal natNullValue;
			if( ( attrNullValue == null ) || ( attrNullValue.length() <= 0 ) ) {
				natNullValue = null;
			}
			else {
				natNullValue= new BigDecimal( attrNullValue );
			}
			editBuff.setOptionalNullValue( natNullValue );

			BigDecimal natUnknownValue;
			if( ( attrUnknownValue == null ) || ( attrUnknownValue.length() <= 0 ) ) {
				natUnknownValue = null;
			}
			else {
				natUnknownValue= new BigDecimal( attrUnknownValue );
			}
			editBuff.setOptionalUnknownValue( natUnknownValue );

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

			CFBamSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getUInt64ColLoaderBehaviour();
			ICFBamUInt64ColEditObj editUInt64Col = null;
			ICFBamUInt64ColObj origUInt64Col = schemaObj.getUInt64ColTableObj().readUInt64ColByUNameIdx( refTenant.getRequiredId(),
			refScope.getRequiredId(),
			editBuff.getRequiredName() );
			if( origUInt64Col == null ) {
				editUInt64Col = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editUInt64Col = (ICFBamUInt64ColEditObj)origUInt64Col.beginEdit();
						editUInt64Col.setRequiredName( editBuff.getRequiredName() );
						editUInt64Col.setOptionalShortName( editBuff.getOptionalShortName() );
						editUInt64Col.setOptionalLabel( editBuff.getOptionalLabel() );
						editUInt64Col.setOptionalShortDescription( editBuff.getOptionalShortDescription() );
						editUInt64Col.setOptionalDescription( editBuff.getOptionalDescription() );
						editUInt64Col.setRequiredIsNullable( editBuff.getRequiredIsNullable() );
						editUInt64Col.setOptionalGenerateId( editBuff.getOptionalGenerateId() );
						editUInt64Col.setRequiredDefaultVisibility( editBuff.getRequiredDefaultVisibility() );
						editUInt64Col.setOptionalDbName( editBuff.getOptionalDbName() );
						editUInt64Col.setOptionalInitValue( editBuff.getOptionalInitValue() );
						editUInt64Col.setOptionalDefaultValue( editBuff.getOptionalDefaultValue() );
						editUInt64Col.setOptionalMinValue( editBuff.getOptionalMinValue() );
						editUInt64Col.setOptionalMaxValue( editBuff.getOptionalMaxValue() );
						editUInt64Col.setOptionalNullValue( editBuff.getOptionalNullValue() );
						editUInt64Col.setOptionalUnknownValue( editBuff.getOptionalUnknownValue() );
						editUInt64Col.setOptionalLookupDefSchema( editBuff.getOptionalLookupDefSchema() );
						editUInt64Col.setOptionalLookupDataScope( editBuff.getOptionalLookupDataScope() );
						editUInt64Col.setOptionalLookupVAccSec( editBuff.getOptionalLookupVAccSec() );
						editUInt64Col.setOptionalLookupEAccSec( editBuff.getOptionalLookupEAccSec() );
						editUInt64Col.setOptionalLookupVAccFreq( editBuff.getOptionalLookupVAccFreq() );
						editUInt64Col.setOptionalLookupEAccFreq( editBuff.getOptionalLookupEAccFreq() );
						break;
					case Replace:
						editUInt64Col = (ICFBamUInt64ColEditObj)origUInt64Col.beginEdit();
						editUInt64Col.delete();
						editUInt64Col.endEdit();
						origUInt64Col = null;
						editUInt64Col = editBuff;
						break;
				}
			}

			if( editUInt64Col != null ) {
				if( origUInt64Col != null ) {
					editUInt64Col.update();
				}
				else {
					origUInt64Col = (ICFBamUInt64ColObj)editUInt64Col.create();
				}
				editUInt64Col.endEdit();
			}

			curContext.putNamedValue( "Object", origUInt64Col );
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
