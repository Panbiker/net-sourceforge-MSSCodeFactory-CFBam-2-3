
// Description: Java 7 XML Message message formatter for CFBam.AuditAction

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
 *	CFBamXMsgAuditActionMessageFormatter XML message formatter
 *	for CFBam.AuditAction.
 */
public class CFBamXMsgAuditActionMessageFormatter
{
	public CFBamXMsgAuditActionMessageFormatter() {
	}

	public static String formatAuditActionPKeyAttributes( String separator, CFBamAuditActionPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( null,
				"AuditActionId",
				pkey.getRequiredAuditActionId() );
		return( retval );
	}

	public static String formatAuditActionPKeyAttributes( String separator, CFBamAuditActionBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( separator,
					"AuditActionId",
					buff.getRequiredAuditActionId() );
		return( retval );
	}

	public static String formatAuditActionBuffAttributes( String separator, CFBamAuditActionBuff buff ) {
		String retval = CFBamXMsgAuditActionMessageFormatter.formatAuditActionPKeyAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"Revision",
					buff.getRequiredRevision() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Description",
					buff.getRequiredDescription() );
		return( retval );
	}

	public static String formatAuditActionRqstCreate( String separator, CFBamAuditActionBuff buff ) {
		String retval = "<RqstAuditActionCreate "
			+	formatAuditActionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstRead( String separator, CFBamAuditActionPKey pkey ) {
		String retval = "<RqstAuditActionRead "
			+	formatAuditActionPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstRead( String separator, CFBamAuditActionBuff buff ) {
		String retval = "<RqstAuditActionRead "
			+	formatAuditActionPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstRead( String separator,
		short argAuditActionId )
	{
		String retval = "<RqstAuditActionRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"AuditActionId",
					argAuditActionId )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstReadAll( String separator ) {
		String retval = "<RqstAuditActionReadAll />";
		return( retval );
	}

	public static String formatAuditActionRqstReadByIdIdx( String separator,
		short argAuditActionId )
	{
		String retval = "<RqstAuditActionRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"AuditActionId",
					argAuditActionId )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstReadByUDescrIdx( String separator,
		String argDescription )
	{
		String retval = "<RqstAuditActionReadByUDescrIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Description",
					argDescription )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstLock( String separator, CFBamAuditActionPKey pkey ) {
		String retval = "<RqstAuditActionLock "
			+	formatAuditActionPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstLock( String separator, CFBamAuditActionBuff buff ) {
		String retval = "<RqstAuditActionLock "
			+	formatAuditActionPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstLock( String separator,
		short argAuditActionId )
	{
		String retval = "<RqstAuditActionLock "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"AuditActionId",
					argAuditActionId )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstUpdate( String separator, CFBamAuditActionBuff buff ) {
		String retval = "<RqstAuditActionUpdate "
			+	formatAuditActionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstDelete( String separator, CFBamAuditActionBuff buff ) {
		String retval = "<RqstAuditActionDelete "
				+	formatAuditActionPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstDeleteByIdIdx( String separator,
		short argAuditActionId )
	{
		String retval = "<RqstAuditActionDelete "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"AuditActionId",
					argAuditActionId )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRqstDeleteByUDescrIdx( String separator,
		String argDescription )
	{
		String retval = "<RqstAuditActionDeleteByUDescrIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Description",
					argDescription )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRspnSingleOpenTag() {
		final String retval = "<RspnAuditActionReadSingle>";
		return( retval );
	}

	public static String formatAuditActionRspnSingleCloseTag() {
		final String retval = "</RspnAuditActionReadSingle>";
		return( retval );
	}

	public static String formatAuditActionRspnListOpenTag() {
		final String retval = "<RspnAuditActionReadList>";
		return( retval );
	}

	public static String formatAuditActionRspnListCloseTag() {
		final String retval = "</RspnAuditActionReadList>";
		return( retval );
	}

	public static String formatAuditActionRspnRec( String separator, CFBamAuditActionBuff buff ) {
		String retval = "<AuditAction "
			+	formatAuditActionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRspnDerivedRec( String separator, CFBamAuditActionBuff buff ) {
		String retval;
		retval = formatAuditActionRspnRec( separator, buff );
		return( retval );
	}

	public static String formatAuditActionRspnCreated( String separator, CFBamAuditActionBuff buff ) {
		String retval = "<RspnAuditActionCreated "
			+	formatAuditActionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRspnLocked( String separator, CFBamAuditActionBuff buff ) {
		String retval = "<RspnAuditActionLocked "
			+	formatAuditActionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRspnUpdated( String separator, CFBamAuditActionBuff buff ) {
		String retval = "<RspnAuditActionUpdated "
			+	formatAuditActionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAuditActionRspnDeleted() {
		String retval = "<RspnAuditActionDeleted />";
		return( retval );
	}
}
