
// Description: Java 7 XML Message message formatter for CFBam.URLProtocol

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
 *	CFBamXMsgURLProtocolMessageFormatter XML message formatter
 *	for CFBam.URLProtocol.
 */
public class CFBamXMsgURLProtocolMessageFormatter
{
	public CFBamXMsgURLProtocolMessageFormatter() {
	}

	public static String formatURLProtocolPKeyAttributes( String separator, CFBamURLProtocolPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( null,
				"URLProtocolId",
				pkey.getRequiredURLProtocolId() );
		return( retval );
	}

	public static String formatURLProtocolPKeyAttributes( String separator, CFBamURLProtocolBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( separator,
					"URLProtocolId",
					buff.getRequiredURLProtocolId() );
		return( retval );
	}

	public static String formatURLProtocolBuffAttributes( String separator, CFBamURLProtocolBuff buff ) {
		String retval = CFBamXMsgURLProtocolMessageFormatter.formatURLProtocolPKeyAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"Revision",
					buff.getRequiredRevision() )
			+	CFLibXmlUtil.formatOptionalUuid( separator,
					"CreatedBy",
					buff.getCreatedByUserId() )
			+	CFLibXmlUtil.formatOptionalTimestamp( separator,
					"CreatedAt",
					buff.getCreatedAt() )
			+	CFLibXmlUtil.formatOptionalUuid( separator,
					"UpdatedBy",
					buff.getUpdatedByUserId() )
			+	CFLibXmlUtil.formatOptionalTimestamp( separator,
					"UpdatedAt",
					buff.getUpdatedAt() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Description",
					buff.getRequiredDescription() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsSecure",
					buff.getRequiredIsSecure() );
		return( retval );
	}

	public static String formatURLProtocolRqstCreate( String separator, CFBamURLProtocolBuff buff ) {
		String retval = "<RqstURLProtocolCreate "
			+	formatURLProtocolBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstRead( String separator, CFBamURLProtocolPKey pkey ) {
		String retval = "<RqstURLProtocolRead "
			+	formatURLProtocolPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstRead( String separator, CFBamURLProtocolBuff buff ) {
		String retval = "<RqstURLProtocolRead "
			+	formatURLProtocolPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstRead( String separator,
		short argURLProtocolId )
	{
		String retval = "<RqstURLProtocolRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"URLProtocolId",
					argURLProtocolId )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstReadAll( String separator ) {
		String retval = "<RqstURLProtocolReadAll />";
		return( retval );
	}

	public static String formatURLProtocolRqstReadByIdIdx( String separator,
		short argURLProtocolId )
	{
		String retval = "<RqstURLProtocolRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"URLProtocolId",
					argURLProtocolId )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstReadByUNameIdx( String separator,
		String argName )
	{
		String retval = "<RqstURLProtocolReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstReadByIsSecureIdx( String separator,
		boolean argIsSecure )
	{
		String retval = "<RqstURLProtocolReadByIsSecureIdx "
			+	CFLibXmlUtil.formatRequiredBoolean( null,
					"IsSecure",
					argIsSecure )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstLock( String separator, CFBamURLProtocolPKey pkey ) {
		String retval = "<RqstURLProtocolLock "
			+	formatURLProtocolPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstLock( String separator, CFBamURLProtocolBuff buff ) {
		String retval = "<RqstURLProtocolLock "
			+	formatURLProtocolPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstLock( String separator,
		short argURLProtocolId )
	{
		String retval = "<RqstURLProtocolLock "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"URLProtocolId",
					argURLProtocolId )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstUpdate( String separator, CFBamURLProtocolBuff buff ) {
		String retval = "<RqstURLProtocolUpdate "
			+	formatURLProtocolBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstDelete( String separator, CFBamURLProtocolBuff buff ) {
		String retval = "<RqstURLProtocolDelete "
				+	formatURLProtocolPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstDeleteByIdIdx( String separator,
		short argURLProtocolId )
	{
		String retval = "<RqstURLProtocolDelete "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"URLProtocolId",
					argURLProtocolId )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstDeleteByUNameIdx( String separator,
		String argName )
	{
		String retval = "<RqstURLProtocolDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRqstDeleteByIsSecureIdx( String separator,
		boolean argIsSecure )
	{
		String retval = "<RqstURLProtocolDeleteByIsSecureIdx "
			+	CFLibXmlUtil.formatRequiredBoolean( null,
					"IsSecure",
					argIsSecure )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRspnSingleOpenTag() {
		final String retval = "<RspnURLProtocolReadSingle>";
		return( retval );
	}

	public static String formatURLProtocolRspnSingleCloseTag() {
		final String retval = "</RspnURLProtocolReadSingle>";
		return( retval );
	}

	public static String formatURLProtocolRspnListOpenTag() {
		final String retval = "<RspnURLProtocolReadList>";
		return( retval );
	}

	public static String formatURLProtocolRspnListCloseTag() {
		final String retval = "</RspnURLProtocolReadList>";
		return( retval );
	}

	public static String formatURLProtocolRspnRec( String separator, CFBamURLProtocolBuff buff ) {
		String retval = "<URLProtocol "
			+	formatURLProtocolBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRspnDerivedRec( String separator, CFBamURLProtocolBuff buff ) {
		String retval;
		retval = formatURLProtocolRspnRec( separator, buff );
		return( retval );
	}

	public static String formatURLProtocolRspnCreated( String separator, CFBamURLProtocolBuff buff ) {
		String retval = "<RspnURLProtocolCreated "
			+	formatURLProtocolBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRspnLocked( String separator, CFBamURLProtocolBuff buff ) {
		String retval = "<RspnURLProtocolLocked "
			+	formatURLProtocolBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRspnUpdated( String separator, CFBamURLProtocolBuff buff ) {
		String retval = "<RspnURLProtocolUpdated "
			+	formatURLProtocolBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatURLProtocolRspnDeleted() {
		String retval = "<RspnURLProtocolDeleted />";
		return( retval );
	}
}
