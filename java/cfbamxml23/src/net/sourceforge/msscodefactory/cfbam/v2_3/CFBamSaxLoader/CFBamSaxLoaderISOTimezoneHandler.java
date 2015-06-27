
// Description: Java 7 XML SAX Element Handler for ISOTimezone

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
 *	CFBamSaxLoaderISOTimezoneParse XML SAX Element Handler implementation
 *	for ISOTimezone.
 */
public class CFBamSaxLoaderISOTimezoneHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamSaxLoaderISOTimezoneHandler( CFBamSaxLoader saxLoader ) {
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
			// Primary Key Attributes for Constant Enum support
			String attrISOTimezoneId = null;
			// ISOTimezone Attributes
			String	attrIso8601 = null;
			String	attrTZName = null;
			String	attrTZHourOffset = null;
			String	attrTZMinOffset = null;
			String	attrDescription = null;
			String	attrVisible = null;
			// ISOTimezone References
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "ISOTimezone" );

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
			ICFBamISOTimezoneEditObj editBuff = (ICFBamISOTimezoneEditObj)schemaObj.getISOTimezoneTableObj().newInstance().beginEdit();

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
				else if( attrLocalName.equals( "ISOTimezoneId" ) ) {
					if( attrISOTimezoneId != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrISOTimezoneId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Iso8601" ) ) {
					if( attrIso8601 != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIso8601 = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "TZName" ) ) {
					if( attrTZName != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTZName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "TZHourOffset" ) ) {
					if( attrTZHourOffset != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTZHourOffset = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "TZMinOffset" ) ) {
					if( attrTZMinOffset != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTZMinOffset = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "Visible" ) ) {
					if( attrVisible != null ) {
						throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrVisible = attrs.getValue( idxAttr );
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
			if( ( attrISOTimezoneId == null ) || ( attrISOTimezoneId.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ISOTimezoneId" );
			}
			if( attrIso8601 == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Iso8601" );
			}
			if( attrTZName == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"TZName" );
			}
			if( ( attrTZHourOffset == null ) || ( attrTZHourOffset.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"TZHourOffset" );
			}
			if( ( attrTZMinOffset == null ) || ( attrTZMinOffset.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"TZMinOffset" );
			}
			if( attrDescription == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Description" );
			}
			if( ( attrVisible == null ) || ( attrVisible.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Visible" );
			}

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Iso8601", attrIso8601 );
			curContext.putNamedValue( "TZName", attrTZName );
			curContext.putNamedValue( "TZHourOffset", attrTZHourOffset );
			curContext.putNamedValue( "TZMinOffset", attrTZMinOffset );
			curContext.putNamedValue( "Description", attrDescription );
			curContext.putNamedValue( "Visible", attrVisible );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

		short natISOTimezoneId;
			natISOTimezoneId = Short.parseShort( attrISOTimezoneId );
			editBuff.getPKey().setRequiredISOTimezoneId( natISOTimezoneId );
			editBuff.getISOTimezoneBuff().setRequiredISOTimezoneId( natISOTimezoneId );

			String natIso8601 = attrIso8601;
			editBuff.setRequiredIso8601( natIso8601 );

			String natTZName = attrTZName;
			editBuff.setRequiredTZName( natTZName );

			short natTZHourOffset = Short.parseShort( attrTZHourOffset );
			editBuff.setRequiredTZHourOffset( natTZHourOffset );

			short natTZMinOffset = Short.parseShort( attrTZMinOffset );
			editBuff.setRequiredTZMinOffset( natTZMinOffset );

			String natDescription = attrDescription;
			editBuff.setRequiredDescription( natDescription );

			boolean natVisible;
			if( attrVisible.equals( "true" ) || attrVisible.equals( "yes" ) || attrVisible.equals( "1" ) ) {
				natVisible = true;
			}
			else if( attrVisible.equals( "false" ) || attrVisible.equals( "no" ) || attrVisible.equals( "0" ) ) {
				natVisible = false;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unexpected Visible value, must be one of true, false, yes, no, 1, or 0, not \"" + attrVisible + "\"" );
			}
			editBuff.setRequiredVisible( natVisible );

			// Get the scope/container object

			CFLibXmlCoreContext parentContext = curContext.getPrevContext();
			Object scopeObj;
			if( parentContext != null ) {
				scopeObj = parentContext.getNamedValue( "Object" );
			}
			else {
				scopeObj = null;
			}

			CFBamSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getISOTimezoneLoaderBehaviour();
			ICFBamISOTimezoneEditObj editISOTimezone = null;
			ICFBamISOTimezoneObj origISOTimezone = schemaObj.getISOTimezoneTableObj().readISOTimezoneByUTZNameIdx( editBuff.getRequiredTZName() );
			editBuff.getPKey().setRequiredISOTimezoneId( natISOTimezoneId );
			editBuff.getISOTimezoneBuff().setRequiredISOTimezoneId( natISOTimezoneId );
			if( origISOTimezone == null ) {
				editISOTimezone = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editISOTimezone = (ICFBamISOTimezoneEditObj)origISOTimezone.beginEdit();
						editISOTimezone.setRequiredIso8601( editBuff.getRequiredIso8601() );
						editISOTimezone.setRequiredTZName( editBuff.getRequiredTZName() );
						editISOTimezone.setRequiredTZHourOffset( editBuff.getRequiredTZHourOffset() );
						editISOTimezone.setRequiredTZMinOffset( editBuff.getRequiredTZMinOffset() );
						editISOTimezone.setRequiredDescription( editBuff.getRequiredDescription() );
						editISOTimezone.setRequiredVisible( editBuff.getRequiredVisible() );
						break;
					case Replace:
						editISOTimezone = (ICFBamISOTimezoneEditObj)origISOTimezone.beginEdit();
						editISOTimezone.delete();
						editISOTimezone.endEdit();
						origISOTimezone = null;
						editISOTimezone = editBuff;
						break;
				}
			}

			if( editISOTimezone != null ) {
				if( origISOTimezone != null ) {
					editISOTimezone.update();
				}
				else {
					origISOTimezone = (ICFBamISOTimezoneObj)editISOTimezone.create();
				}
				editISOTimezone.endEdit();
			}

			curContext.putNamedValue( "Object", origISOTimezone );
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
