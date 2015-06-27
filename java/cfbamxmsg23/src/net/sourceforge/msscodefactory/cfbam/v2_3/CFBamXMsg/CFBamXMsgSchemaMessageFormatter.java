
// Description: Java 7 XML Message message formatter for CFBam

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsg;

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
 *	CFBamXMsgSchemaMessageFormatter XML message formatter
 *	for CFBam.
 */
public class CFBamXMsgSchemaMessageFormatter
{
	private String messageNamespace = "CFBam";

	public String getMessageNamespace() {
		return( messageNamespace );
	}

	public void setMessageNamespace( String value ) {
		final String S_ProcName = "setMessageNamespace";
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"value" );
		}
		messageNamespace = new String( value );
	}

	public CFBamXMsgSchemaMessageFormatter() {
	}

	public static String formatRqstXmlPreamble() {
		final String retval =
				"<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
			+	"<CFBamRqst\n"
			+	"\t\txmlns=\"uri://xsd/cfbamrqst\"\n"
			+	"\t\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
			+	"\t\txmlns:xs=\"http://www.w3.org/2001/XMLSchema\"\n"
			+	"\t\txsi:schemaLocation=\"uri://xsd/cfbamrqst file://xsd/cfbam-23-rqst.xsd\" >";
		return( retval );
	}

	public static String formatRqstXmlPostamble() {
		final String retval =
				"</CFBamRqst>\n";
		return( retval );
	}

	public String formatRspnXmlPreamble() {
		final String retval =
				"<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
			+	"<" + messageNamespace + "Rspn\n"
			+	"\t\txmlns=\"uri://xsd/" + messageNamespace.toLowerCase() + "rspn\"\n"
			+	"\t\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
			+	"\t\txmlns:xs=\"http://www.w3.org/2001/XMLSchema\"\n"
			+	"\t\txsi:schemaLocation=\"uri://xsd/" + messageNamespace.toLowerCase() + "rspn file://xsd/" + messageNamespace.toLowerCase() + "-23-rspn.xsd\" >";
		return( retval );
	}

	public String formatRspnXmlPostamble() {
		final String retval =
				"</" + messageNamespace + "Rspn>\n";
		return( retval );
	}

	public static String formatRspnNoDataFound() {
		String retval = "<RspnNoDataFound />";
		return( retval );
	}

	public static String formatRspnException( String separator, Throwable t ) {
		String retval = "<RspnException "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					t.getClass().getName() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Message",
					t.getMessage() )
			+	" />";
		return( retval );
	}

	public static String formatRqstFileImport( String separator, String fileName, String fileContents ) {
		String retval = "<RqstFileImport "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"FileName",
					fileName )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"FileContents",
					fileContents )
			+	" />";
		return( retval );
	}

	public static String formatRqstLogIn( String separator, String loginId, String deviceName, byte devEncPWHash[], String clusterName, String tenantName ) {
		String retval = "<RqstLogIn "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"LoginId",
					loginId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"DeviceName",
					deviceName )
			+	CFLibXmlUtil.formatRequiredBlob( separator,
					"DevEncPWHash",
					devEncPWHash )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"ClusterName",
					clusterName )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"TenantName",
					tenantName )
			+	" />";
		return( retval );
	}

	public static String formatRqstLogOut( String separator, UUID secSessionId ) {
		String retval = "<RqstLogOut "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"SecSessionId",
					secSessionId.toString() )
			+	" />";
		return( retval );
	}

	public static String formatRspnFileLoaded( String separator, String logContents ) {
		String retval = "<RspnFileLoaded "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"LogContents",
					logContents )
			+	" />";
		return( retval );
	}

	public static String formatRspnServerProcExecuted( String separator, boolean dataChanged ) {
		String retval = "<RspnServerProcExecuted "
			+	CFLibXmlUtil.formatRequiredBoolean( null,
					"DataChanged",
					dataChanged )
			+	" />";
		return( retval );
	}

	public static String formatRspnLoggedIn( String separator, long clusterId, String clusterName, long tenantId, String tenantName, UUID secUserId, String secUserName, UUID secSessionId ) {
		String retval = "<RspnLoggedIn "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					clusterId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"ClusterName",
					clusterName )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					tenantId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"TenantName",
					tenantName )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"SecUserId",
					secUserId.toString() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"SecUserName",
					secUserName )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"SecSessionId",
					secSessionId.toString() )
			+	" />";
		return( retval );
	}

	public static String formatRspnLoggedOut( String separator, UUID secSessionId ) {
		String retval = "<RspnLoggedOut "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"SecSessionId",
					secSessionId.toString() )
			+	" />";
		return( retval );
	}
}
