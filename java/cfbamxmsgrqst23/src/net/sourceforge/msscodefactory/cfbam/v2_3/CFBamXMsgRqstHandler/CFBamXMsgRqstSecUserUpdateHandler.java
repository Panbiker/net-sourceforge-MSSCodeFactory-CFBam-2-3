
// Description: Java 7 XML Message SAX Response Record Element Handler for SecUser

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
 *	CFBamXMsgRqstSecUserUpdateHandler XML SAX Element Handler implementation
 *	for SecUser.
 */
public class CFBamXMsgRqstSecUserUpdateHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamXMsgRqstSecUserUpdateHandler( CFBamXMsgRqstHandler xmsgRqstHandler ) {
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
			// SecUser Attributes
			String	attrSecUserId = null;
			String	attrLoginId = null;
			String	attrEMailAddress = null;
			String	attrEMailConfirmationUuid = null;
			String	attrDefaultDevSecUserId = null;
			String	attrDefaultDevName = null;
			String	attrPasswordHash = null;
			String	attrPasswordResetUuid = null;
			String attrCreatedAt = null;
			String attrCreatedBy = null;
			String attrUpdatedAt = null;
			String attrUpdatedBy = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "RqstSecUserUpdate" );

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
				else if( attrLocalName.equals( "SecUserId" ) ) {
					if( attrSecUserId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSecUserId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "LoginId" ) ) {
					if( attrLoginId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLoginId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "EMailAddress" ) ) {
					if( attrEMailAddress != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrEMailAddress = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "EMailConfirmationUuid" ) ) {
					if( attrEMailConfirmationUuid != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrEMailConfirmationUuid = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefaultDevSecUserId" ) ) {
					if( attrDefaultDevSecUserId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefaultDevSecUserId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefaultDevName" ) ) {
					if( attrDefaultDevName != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefaultDevName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PasswordHash" ) ) {
					if( attrPasswordHash != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPasswordHash = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PasswordResetUuid" ) ) {
					if( attrPasswordResetUuid != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPasswordResetUuid = attrs.getValue( idxAttr );
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
			if( ( attrSecUserId == null ) || ( attrSecUserId.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SecUserId" );
			}
			if( attrLoginId == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"LoginId" );
			}
			if( attrEMailAddress == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"EMailAddress" );
			}
			if( attrPasswordHash == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"PasswordHash" );
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

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();

			// Instantiate a PKey buffer for the parsed information
			CFBamSecUserPKey pkey = schemaObj.getBackingStore().getFactorySecUser().newPKey();

			UUID natSecUserId;
				natSecUserId = UUID.fromString( attrSecUserId );
			pkey.setRequiredSecUserId( natSecUserId );
			// Read the instance
			ICFBamSecUserObj origBuff = schemaObj.getSecUserTableObj().readSecUser( pkey );
			if( origBuff == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getSecUserTableObj().readSecUser()" );
			}
			else {
				// Edit the instance
				ICFBamSecUserEditObj editBuff = (ICFBamSecUserEditObj)origBuff.beginEdit();
				CFBamSecUserBuff dataBuff = editBuff.getSecUserBuff();
				// Convert string attributes to native Java types
				// and apply the converted attributes to the editBuff.
			String natLoginId = attrLoginId;

			dataBuff.setRequiredLoginId( natLoginId );

			String natEMailAddress = attrEMailAddress;

			dataBuff.setRequiredEMailAddress( natEMailAddress );

			UUID natEMailConfirmationUuid;
			if( ( attrEMailConfirmationUuid == null ) || ( attrEMailConfirmationUuid.length() <= 0 ) ) {
				natEMailConfirmationUuid = null;
			}
			else {
				natEMailConfirmationUuid = UUID.fromString( attrEMailConfirmationUuid );
			}

			dataBuff.setOptionalEMailConfirmationUuid( natEMailConfirmationUuid );

			UUID natDefaultDevSecUserId;
			if( ( attrDefaultDevSecUserId == null ) || ( attrDefaultDevSecUserId.length() <= 0 ) ) {
				natDefaultDevSecUserId = null;
			}
			else {
				natDefaultDevSecUserId = UUID.fromString( attrDefaultDevSecUserId );
			}

			dataBuff.setOptionalDefaultDevSecUserId( natDefaultDevSecUserId );

			String natDefaultDevName = attrDefaultDevName;

			dataBuff.setOptionalDefaultDevName( natDefaultDevName );

			String natPasswordHash = attrPasswordHash;

			dataBuff.setRequiredPasswordHash( natPasswordHash );

			UUID natPasswordResetUuid;
			if( ( attrPasswordResetUuid == null ) || ( attrPasswordResetUuid.length() <= 0 ) ) {
				natPasswordResetUuid = null;
			}
			else {
				natPasswordResetUuid = UUID.fromString( attrPasswordResetUuid );
			}

			dataBuff.setOptionalPasswordResetUuid( natPasswordResetUuid );

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
				//	Attempt the update
				editBuff.update();
				editBuff.endEdit();
				String response = schemaFormatter.formatRspnXmlPreamble() + "\n"
					+	"\t" + CFBamXMsgSecUserMessageFormatter.formatSecUserRspnUpdated( "\n\t\t\t", origBuff.getSecUserBuff() )
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
