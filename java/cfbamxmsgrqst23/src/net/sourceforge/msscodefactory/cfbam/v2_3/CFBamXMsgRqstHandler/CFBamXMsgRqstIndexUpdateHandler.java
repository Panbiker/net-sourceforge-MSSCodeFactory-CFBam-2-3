
// Description: Java 7 XML Message SAX Response Record Element Handler for Index

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgRqstHandler;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsg.*;

/*
 *	CFBamXMsgRqstIndexUpdateHandler XML SAX Element Handler implementation
 *	for Index.
 */
public class CFBamXMsgRqstIndexUpdateHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamXMsgRqstIndexUpdateHandler( CFBamXMsgRqstHandler xmsgRqstHandler ) {
		super( xmsgRqstHandler );
	}

	public void startElement(
		String		uri,
		String		localName,
		String		qName,
		Attributes	attrs )
	throws SAXException
	{
		CFBamXMsgSchemaMessageFormatter schemaFormatter = null;
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
			// Index Attributes
			String	attrTableId = null;
			String	attrDefSchemaTenantId = null;
			String	attrDefSchemaId = null;
			String	attrName = null;
			String	attrShortName = null;
			String	attrLabel = null;
			String	attrShortDescription = null;
			String	attrDescription = null;
			String	attrDbName = null;
			String	attrSuffix = null;
			String	attrIsUnique = null;
			String	attrIsDbMapped = null;
			String	attrDefaultVisibility = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "RqstIndexUpdate" );

			CFBamXMsgRqstHandler xmsgRqstHandler = (CFBamXMsgRqstHandler)getParser();
			if( xmsgRqstHandler == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			schemaFormatter = xmsgRqstHandler.getSchemaMessageFormatter();

			ICFBamSchemaObj schemaObj = xmsgRqstHandler.getSchemaObj();
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
				else if( attrLocalName.equals( "TableId" ) ) {
					if( attrTableId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTableId = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "IsUnique" ) ) {
					if( attrIsUnique != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsUnique = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "IsDbMapped" ) ) {
					if( attrIsDbMapped != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsDbMapped = attrs.getValue( idxAttr );
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
			if( ( attrCreatedAt == null ) || ( attrCreatedAt.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"CreatedAt" );
			}
			if( ( attrCreatedBy == null ) || ( attrCreatedBy.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"CreatedBy" );
			}
			if( ( attrUpdatedAt == null ) || ( attrUpdatedAt.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"UpdatedAt" );
			}
			if( ( attrUpdatedBy == null ) || ( attrUpdatedBy.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"UpdatedBy" );
			}
			if( ( attrTableId == null ) || ( attrTableId.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"TableId" );
			}
			if( attrName == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Name" );
			}
			if( ( attrIsUnique == null ) || ( attrIsUnique.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsUnique" );
			}
			if( ( attrIsDbMapped == null ) || ( attrIsDbMapped.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsDbMapped" );
			}
			if( ( attrDefaultVisibility == null ) || ( attrDefaultVisibility.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"DefaultVisibility" );
			}

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();

			// Instantiate a PKey buffer for the parsed information
			CFBamScopePKey pkey = schemaObj.getBackingStore().getFactoryScope().newPKey();

			long natTenantId;
				natTenantId = Long.parseLong( attrTenantId );
			pkey.setRequiredTenantId( natTenantId );
			long natId;
				natId = Long.parseLong( attrId );
			pkey.setRequiredId( natId );
			// Read the instance
			ICFBamIndexObj origBuff = schemaObj.getIndexTableObj().readIndex( pkey );
			if( origBuff == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getIndexTableObj().readIndex()" );
			}
			else {
				// Edit the instance
				ICFBamIndexEditObj editBuff = (ICFBamIndexEditObj)origBuff.beginEdit();
				CFBamIndexBuff dataBuff = editBuff.getIndexBuff();
				// Convert string attributes to native Java types
				// and apply the converted attributes to the editBuff.
				int natRevision = Integer.parseInt( attrRevision );
				dataBuff.setRequiredRevision( natRevision );
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
			long natTableId = Long.parseLong( attrTableId );

			dataBuff.setRequiredTableId( natTableId );

			Long natDefSchemaTenantId;
			if( ( attrDefSchemaTenantId == null ) || ( attrDefSchemaTenantId.length() <= 0 ) ) {
				natDefSchemaTenantId = null;
			}
			else {
				natDefSchemaTenantId = new Long( Long.parseLong( attrDefSchemaTenantId ) );
			}

			dataBuff.setOptionalDefSchemaTenantId( natDefSchemaTenantId );

			Long natDefSchemaId;
			if( ( attrDefSchemaId == null ) || ( attrDefSchemaId.length() <= 0 ) ) {
				natDefSchemaId = null;
			}
			else {
				natDefSchemaId = new Long( Long.parseLong( attrDefSchemaId ) );
			}

			dataBuff.setOptionalDefSchemaId( natDefSchemaId );

			String natName = attrName;

			dataBuff.setRequiredName( natName );

			String natShortName = attrShortName;

			dataBuff.setOptionalShortName( natShortName );

			String natLabel = attrLabel;

			dataBuff.setOptionalLabel( natLabel );

			String natShortDescription = attrShortDescription;

			dataBuff.setOptionalShortDescription( natShortDescription );

			String natDescription = attrDescription;

			dataBuff.setOptionalDescription( natDescription );

			String natDbName = attrDbName;

			dataBuff.setOptionalDbName( natDbName );

			String natSuffix = attrSuffix;

			dataBuff.setOptionalSuffix( natSuffix );

			boolean natIsUnique;
			if( attrIsUnique.equals( "true" ) || attrIsUnique.equals( "yes" ) || attrIsUnique.equals( "1" ) ) {
				natIsUnique = true;
			}
			else if( attrIsUnique.equals( "false" ) || attrIsUnique.equals( "no" ) || attrIsUnique.equals( "0" ) ) {
				natIsUnique = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected IsUnique value, must be one of true, false, yes, no, 1, or 0, not \"" + attrIsUnique + "\"" );
			}

			dataBuff.setRequiredIsUnique( natIsUnique );

			boolean natIsDbMapped;
			if( attrIsDbMapped.equals( "true" ) || attrIsDbMapped.equals( "yes" ) || attrIsDbMapped.equals( "1" ) ) {
				natIsDbMapped = true;
			}
			else if( attrIsDbMapped.equals( "false" ) || attrIsDbMapped.equals( "no" ) || attrIsDbMapped.equals( "0" ) ) {
				natIsDbMapped = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected IsDbMapped value, must be one of true, false, yes, no, 1, or 0, not \"" + attrIsDbMapped + "\"" );
			}

			dataBuff.setRequiredIsDbMapped( natIsDbMapped );

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

			dataBuff.setRequiredDefaultVisibility( natDefaultVisibility );

				//	Attempt the update
				editBuff.update();
				editBuff.endEdit();
				String response = schemaFormatter.formatRspnXmlPreamble() + "\n"
					+	"\t" + CFBamXMsgIndexMessageFormatter.formatIndexRspnUpdated( "\n\t\t\t", origBuff.getIndexBuff() )
					+	"\n"
					+	schemaFormatter.formatRspnXmlPostamble();
				((CFBamXMsgRqstHandler)getParser()).appendResponse( response );
			}
		}
		catch( RuntimeException e ) {
			CFBamXMsgRqstHandler xmsgRqstHandler = ((CFBamXMsgRqstHandler)getParser());
			schemaFormatter = xmsgRqstHandler.getSchemaMessageFormatter();
			String response = schemaFormatter.formatRspnXmlPreamble() + "\n"
				+	"\t" + CFBamXMsgSchemaMessageFormatter.formatRspnException( "\n\t\t\t", e )
				+	"\n"
				+	schemaFormatter.formatRspnXmlPostamble();
			xmsgRqstHandler.resetResponse();
			xmsgRqstHandler.appendResponse( response );
			xmsgRqstHandler.setCaughtException( true );
		}
		catch( Error e ) {
			CFBamXMsgRqstHandler xmsgRqstHandler = ((CFBamXMsgRqstHandler)getParser());
			schemaFormatter = xmsgRqstHandler.getSchemaMessageFormatter();
			String response = schemaFormatter.formatRspnXmlPreamble() + "\n"
				+	"\t" + CFBamXMsgSchemaMessageFormatter.formatRspnException( "\n\t\t\t", e )
				+	"\n"
				+	schemaFormatter.formatRspnXmlPostamble();
			xmsgRqstHandler.resetResponse();
			xmsgRqstHandler.appendResponse( response );
			xmsgRqstHandler.setCaughtException( true );
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
