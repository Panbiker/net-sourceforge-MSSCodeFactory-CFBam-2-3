
// Description: Java 7 XML Message message formatter for CFBam.ISOCountryLanguage

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
 *	CFBamXMsgISOCountryLanguageMessageFormatter XML message formatter
 *	for CFBam.ISOCountryLanguage.
 */
public class CFBamXMsgISOCountryLanguageMessageFormatter
{
	public CFBamXMsgISOCountryLanguageMessageFormatter() {
	}

	public static String formatISOCountryLanguagePKeyAttributes( String separator, CFBamISOCountryLanguagePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( null,
				"ISOCountryId",
				pkey.getRequiredISOCountryId() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
				"ISOLanguageId",
				pkey.getRequiredISOLanguageId() );
		return( retval );
	}

	public static String formatISOCountryLanguagePKeyAttributes( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( separator,
					"ISOCountryId",
					buff.getRequiredISOCountryId() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"ISOLanguageId",
					buff.getRequiredISOLanguageId() );
		return( retval );
	}

	public static String formatISOCountryLanguageBuffAttributes( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguagePKeyAttributes( separator, buff )
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
					buff.getUpdatedAt() );
		return( retval );
	}

	public static String formatISOCountryLanguageRqstCreate( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = "<RqstISOCountryLanguageCreate "
			+	formatISOCountryLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstRead( String separator, CFBamISOCountryLanguagePKey pkey ) {
		String retval = "<RqstISOCountryLanguageRead "
			+	formatISOCountryLanguagePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstRead( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = "<RqstISOCountryLanguageRead "
			+	formatISOCountryLanguagePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstRead( String separator,
		short argISOCountryId,
		short argISOLanguageId )
	{
		String retval = "<RqstISOCountryLanguageRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOCountryId",
					argISOCountryId )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"ISOLanguageId",
					argISOLanguageId )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstReadAll( String separator ) {
		String retval = "<RqstISOCountryLanguageReadAll />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstReadByIdIdx( String separator,
		short argISOCountryId,
		short argISOLanguageId )
	{
		String retval = "<RqstISOCountryLanguageRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOCountryId",
					argISOCountryId )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"ISOLanguageId",
					argISOLanguageId )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstReadByCountryIdx( String separator,
		short argISOCountryId )
	{
		String retval = "<RqstISOCountryLanguageReadByCountryIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOCountryId",
					argISOCountryId )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstReadByLanguageIdx( String separator,
		short argISOLanguageId )
	{
		String retval = "<RqstISOCountryLanguageReadByLanguageIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOLanguageId",
					argISOLanguageId )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstLock( String separator, CFBamISOCountryLanguagePKey pkey ) {
		String retval = "<RqstISOCountryLanguageLock "
			+	formatISOCountryLanguagePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstLock( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = "<RqstISOCountryLanguageLock "
			+	formatISOCountryLanguagePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstLock( String separator,
		short argISOCountryId,
		short argISOLanguageId )
	{
		String retval = "<RqstISOCountryLanguageLock "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOCountryId",
					argISOCountryId )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"ISOLanguageId",
					argISOLanguageId )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstUpdate( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = "<RqstISOCountryLanguageUpdate "
			+	formatISOCountryLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstDelete( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = "<RqstISOCountryLanguageDelete "
				+	formatISOCountryLanguagePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstDeleteByIdIdx( String separator,
		short argISOCountryId,
		short argISOLanguageId )
	{
		String retval = "<RqstISOCountryLanguageDelete "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOCountryId",
					argISOCountryId )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"ISOLanguageId",
					argISOLanguageId )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstDeleteByCountryIdx( String separator,
		short argISOCountryId )
	{
		String retval = "<RqstISOCountryLanguageDeleteByCountryIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOCountryId",
					argISOCountryId )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRqstDeleteByLanguageIdx( String separator,
		short argISOLanguageId )
	{
		String retval = "<RqstISOCountryLanguageDeleteByLanguageIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"ISOLanguageId",
					argISOLanguageId )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRspnSingleOpenTag() {
		final String retval = "<RspnISOCountryLanguageReadSingle>";
		return( retval );
	}

	public static String formatISOCountryLanguageRspnSingleCloseTag() {
		final String retval = "</RspnISOCountryLanguageReadSingle>";
		return( retval );
	}

	public static String formatISOCountryLanguageRspnListOpenTag() {
		final String retval = "<RspnISOCountryLanguageReadList>";
		return( retval );
	}

	public static String formatISOCountryLanguageRspnListCloseTag() {
		final String retval = "</RspnISOCountryLanguageReadList>";
		return( retval );
	}

	public static String formatISOCountryLanguageRspnRec( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = "<ISOCountryLanguage "
			+	formatISOCountryLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRspnDerivedRec( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval;
		retval = formatISOCountryLanguageRspnRec( separator, buff );
		return( retval );
	}

	public static String formatISOCountryLanguageRspnCreated( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = "<RspnISOCountryLanguageCreated "
			+	formatISOCountryLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRspnLocked( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = "<RspnISOCountryLanguageLocked "
			+	formatISOCountryLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRspnUpdated( String separator, CFBamISOCountryLanguageBuff buff ) {
		String retval = "<RspnISOCountryLanguageUpdated "
			+	formatISOCountryLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOCountryLanguageRspnDeleted() {
		String retval = "<RspnISOCountryLanguageDeleted />";
		return( retval );
	}
}
