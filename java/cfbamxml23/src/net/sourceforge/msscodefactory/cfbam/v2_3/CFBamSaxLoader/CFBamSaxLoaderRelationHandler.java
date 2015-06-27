
// Description: Java 7 XML SAX Element Handler for Relation

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
 *	CFBamSaxLoaderRelationParse XML SAX Element Handler implementation
 *	for Relation.
 */
public class CFBamSaxLoaderRelationHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamSaxLoaderRelationHandler( CFBamSaxLoader saxLoader ) {
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
			// Relation Attributes
			String	attrName = null;
			String	attrShortName = null;
			String	attrLabel = null;
			String	attrShortDescription = null;
			String	attrDescription = null;
			String	attrDbName = null;
			String	attrSuffix = null;
			String	attrIsRequired = null;
			String	attrIsAbstract = null;
			String	attrIsXsdContainer = null;
			String	attrDefaultVisibility = null;
			String	attrRelationType = null;
			String	attrDefSchema = null;
			String	attrFromIndex = null;
			String	attrToTable = null;
			String	attrToIndex = null;
			String	attrNarrowed = null;
			// Relation References
			ICFBamTenantObj refRelTenant = null;
			ICFBamRelationTypeObj refRelationType = null;
			ICFBamSchemaDefObj refDefSchema = null;
			ICFBamTableObj refFromTable = null;
			ICFBamIndexObj refFromIndex = null;
			ICFBamTableObj refToTable = null;
			ICFBamIndexObj refToIndex = null;
			ICFBamRelationObj refNarrowed = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "Relation" );

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
			ICFBamRelationEditObj editBuff = (ICFBamRelationEditObj)schemaObj.getRelationTableObj().newInstance().beginEdit();

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
				else if( attrLocalName.equals( "DbName" ) ) {
					if( attrDbName != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDbName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Suffix" ) ) {
					if( attrSuffix != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSuffix = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "IsRequired" ) ) {
					if( attrIsRequired != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsRequired = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "IsAbstract" ) ) {
					if( attrIsAbstract != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsAbstract = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "IsXsdContainer" ) ) {
					if( attrIsXsdContainer != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsXsdContainer = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "RelationType" ) ) {
					if( attrRelationType != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrRelationType = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "FromIndex" ) ) {
					if( attrFromIndex != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrFromIndex = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ToTable" ) ) {
					if( attrToTable != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrToTable = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ToIndex" ) ) {
					if( attrToIndex != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrToIndex = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Narrowed" ) ) {
					if( attrNarrowed != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrNarrowed = attrs.getValue( idxAttr );
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
			if( ( attrIsRequired == null ) || ( attrIsRequired.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsRequired" );
			}
			if( ( attrIsAbstract == null ) || ( attrIsAbstract.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsAbstract" );
			}
			if( ( attrIsXsdContainer == null ) || ( attrIsXsdContainer.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsXsdContainer" );
			}
			if( ( attrDefaultVisibility == null ) || ( attrDefaultVisibility.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"DefaultVisibility" );
			}
			if( ( attrRelationType == null ) || ( attrRelationType.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"RelationType" );
			}
			if( ( attrFromIndex == null ) || ( attrFromIndex.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"FromIndex" );
			}
			if( ( attrToTable == null ) || ( attrToTable.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ToTable" );
			}
			if( ( attrToIndex == null ) || ( attrToIndex.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ToIndex" );
			}

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "ShortName", attrShortName );
			curContext.putNamedValue( "Label", attrLabel );
			curContext.putNamedValue( "ShortDescription", attrShortDescription );
			curContext.putNamedValue( "Description", attrDescription );
			curContext.putNamedValue( "DbName", attrDbName );
			curContext.putNamedValue( "Suffix", attrSuffix );
			curContext.putNamedValue( "IsRequired", attrIsRequired );
			curContext.putNamedValue( "IsAbstract", attrIsAbstract );
			curContext.putNamedValue( "IsXsdContainer", attrIsXsdContainer );
			curContext.putNamedValue( "DefaultVisibility", attrDefaultVisibility );
			curContext.putNamedValue( "RelationType", attrRelationType );
			curContext.putNamedValue( "DefSchema", attrDefSchema );
			curContext.putNamedValue( "FromIndex", attrFromIndex );
			curContext.putNamedValue( "ToTable", attrToTable );
			curContext.putNamedValue( "ToIndex", attrToIndex );
			curContext.putNamedValue( "Narrowed", attrNarrowed );

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

			String natDbName = attrDbName;
			editBuff.setOptionalDbName( natDbName );

			String natSuffix = attrSuffix;
			editBuff.setOptionalSuffix( natSuffix );

			boolean natIsRequired;
			if( attrIsRequired.equals( "true" ) || attrIsRequired.equals( "yes" ) || attrIsRequired.equals( "1" ) ) {
				natIsRequired = true;
			}
			else if( attrIsRequired.equals( "false" ) || attrIsRequired.equals( "no" ) || attrIsRequired.equals( "0" ) ) {
				natIsRequired = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected IsRequired value, must be one of true, false, yes, no, 1, or 0, not \"" + attrIsRequired + "\"" );
			}
			editBuff.setRequiredIsRequired( natIsRequired );

			boolean natIsAbstract;
			if( attrIsAbstract.equals( "true" ) || attrIsAbstract.equals( "yes" ) || attrIsAbstract.equals( "1" ) ) {
				natIsAbstract = true;
			}
			else if( attrIsAbstract.equals( "false" ) || attrIsAbstract.equals( "no" ) || attrIsAbstract.equals( "0" ) ) {
				natIsAbstract = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected IsAbstract value, must be one of true, false, yes, no, 1, or 0, not \"" + attrIsAbstract + "\"" );
			}
			editBuff.setRequiredIsAbstract( natIsAbstract );

			boolean natIsXsdContainer;
			if( attrIsXsdContainer.equals( "true" ) || attrIsXsdContainer.equals( "yes" ) || attrIsXsdContainer.equals( "1" ) ) {
				natIsXsdContainer = true;
			}
			else if( attrIsXsdContainer.equals( "false" ) || attrIsXsdContainer.equals( "no" ) || attrIsXsdContainer.equals( "0" ) ) {
				natIsXsdContainer = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected IsXsdContainer value, must be one of true, false, yes, no, 1, or 0, not \"" + attrIsXsdContainer + "\"" );
			}
			editBuff.setRequiredIsXsdContainer( natIsXsdContainer );

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
			else if( scopeObj instanceof ICFBamTableObj ) {
				refFromTable = (ICFBamTableObj) scopeObj;
				editBuff.setRequiredContainerFromTable( refFromTable );
				refRelTenant = editBuff.getRequiredOwnerRelTenant();
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ICFBamTableObj" );
			}

			// Resolve and apply Owner reference
 
			if( refRelTenant == null ) {
				if( scopeObj instanceof ICFBamTenantObj ) {
					refRelTenant = (ICFBamTenantObj) scopeObj;
					editBuff.setRequiredOwnerRelTenant( refRelTenant );
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Owner<RelTenant>" );
				}
			}

			refTenant = refRelTenant;
			// Lookup refRelationType by key name value attr
			if( ( attrRelationType != null ) && ( attrRelationType.length() > 0 ) ) {
				refRelationType = schemaObj.getRelationTypeTableObj().readRelationTypeByUTagIdx( attrRelationType );
				if( refRelationType == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve RelationType reference named \"" + attrRelationType + "\" to table RelationType" );
				}
			}
			else {
				refRelationType = null;
			}
			editBuff.setRequiredLookupRelationType( refRelationType );

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

			// Lookup refFromIndex by qualified name
			if( ( attrFromIndex != null ) && ( attrFromIndex.length() > 0 ) ) {
				refFromIndex = (ICFBamIndexObj)(editBuff.getNamedObject( schemaObj.getIndexTableObj().getObjQualifyingClass(),
					attrFromIndex ) );
				if( refFromIndex == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve FromIndex reference qualified name \"" + attrFromIndex + "\" to table Index" );
				}
			}
			else {
				refFromIndex = null;
			}
			editBuff.setRequiredLookupFromIndex( refFromIndex );

			// Lookup refToTable by qualified name
			if( ( attrToTable != null ) && ( attrToTable.length() > 0 ) ) {
				refToTable = (ICFBamTableObj)(editBuff.getNamedObject( schemaObj.getTableTableObj().getObjQualifyingClass(),
					attrToTable ) );
				if( refToTable == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve ToTable reference qualified name \"" + attrToTable + "\" to table Table" );
				}
			}
			else {
				refToTable = null;
			}
			editBuff.setRequiredLookupToTable( refToTable );

			// Lookup refToIndex by qualified name
			if( ( attrToIndex != null ) && ( attrToIndex.length() > 0 ) ) {
				refToIndex = (ICFBamIndexObj)(editBuff.getNamedObject( schemaObj.getIndexTableObj().getObjQualifyingClass(),
					attrToIndex ) );
				if( refToIndex == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve ToIndex reference qualified name \"" + attrToIndex + "\" to table Index" );
				}
			}
			else {
				refToIndex = null;
			}
			editBuff.setRequiredLookupToIndex( refToIndex );

			// Lookup refNarrowed by qualified name
			if( ( attrNarrowed != null ) && ( attrNarrowed.length() > 0 ) ) {
				refNarrowed = (ICFBamRelationObj)(editBuff.getNamedObject( schemaObj.getRelationTableObj().getObjQualifyingClass(),
					attrNarrowed ) );
				if( refNarrowed == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve Narrowed reference qualified name \"" + attrNarrowed + "\" to table Relation" );
				}
			}
			else {
				refNarrowed = null;
			}
			editBuff.setOptionalLookupNarrowed( refNarrowed );

			CFBamSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getRelationLoaderBehaviour();
			ICFBamRelationEditObj editRelation = null;
			ICFBamRelationObj origRelation = schemaObj.getRelationTableObj().readRelationByUNameIdx( refRelTenant.getRequiredId(),
			refFromTable.getRequiredId(),
			editBuff.getRequiredName() );
			if( origRelation == null ) {
				editRelation = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editRelation = (ICFBamRelationEditObj)origRelation.beginEdit();
						editRelation.setRequiredName( editBuff.getRequiredName() );
						editRelation.setOptionalShortName( editBuff.getOptionalShortName() );
						editRelation.setOptionalLabel( editBuff.getOptionalLabel() );
						editRelation.setOptionalShortDescription( editBuff.getOptionalShortDescription() );
						editRelation.setOptionalDescription( editBuff.getOptionalDescription() );
						editRelation.setOptionalDbName( editBuff.getOptionalDbName() );
						editRelation.setOptionalSuffix( editBuff.getOptionalSuffix() );
						editRelation.setRequiredIsRequired( editBuff.getRequiredIsRequired() );
						editRelation.setRequiredIsAbstract( editBuff.getRequiredIsAbstract() );
						editRelation.setRequiredIsXsdContainer( editBuff.getRequiredIsXsdContainer() );
						editRelation.setRequiredDefaultVisibility( editBuff.getRequiredDefaultVisibility() );
						editRelation.setRequiredLookupRelationType( editBuff.getRequiredLookupRelationType() );
						editRelation.setOptionalLookupDefSchema( editBuff.getOptionalLookupDefSchema() );
						editRelation.setRequiredLookupFromIndex( editBuff.getRequiredLookupFromIndex() );
						editRelation.setRequiredLookupToTable( editBuff.getRequiredLookupToTable() );
						editRelation.setRequiredLookupToIndex( editBuff.getRequiredLookupToIndex() );
						editRelation.setOptionalLookupNarrowed( editBuff.getOptionalLookupNarrowed() );
						break;
					case Replace:
						editRelation = (ICFBamRelationEditObj)origRelation.beginEdit();
						editRelation.delete();
						editRelation.endEdit();
						origRelation = null;
						editRelation = editBuff;
						break;
				}
			}

			if( editRelation != null ) {
				if( origRelation != null ) {
					editRelation.update();
				}
				else {
					origRelation = (ICFBamRelationObj)editRelation.create();
				}
				editRelation.endEdit();
			}

			curContext.putNamedValue( "Object", origRelation );
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
