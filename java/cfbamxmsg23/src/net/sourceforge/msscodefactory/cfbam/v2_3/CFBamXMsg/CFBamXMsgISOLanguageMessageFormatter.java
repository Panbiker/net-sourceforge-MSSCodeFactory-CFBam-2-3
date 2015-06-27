
// Description: Java 7 XML Message message formatter for CFBam.ISOLanguage

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
 *	CFBamXMsgISOLanguageMessageFormatter XML message formatter
 *	for CFBam.ISOLanguage.
 */
public class CFBamXMsgISOLanguageMessageFormatter
{
	public CFBamXMsgISOLanguageMessageFormatter() {
	}

	public static String formatISOLanguagePKeyAttributes( String separator, CFBamISOLanguagePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( null,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatISOLanguagePKeyAttributes( String separator, CFBamISOLanguageBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatISOLanguageBuffAttributes( String separator, CFBamISOLanguageBuff buff ) {
		String retval = CFBamXMsgISOLanguageMessageFormatter.formatISOLanguagePKeyAttributes( separator, buff )
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
					"ISOCode",
					buff.getRequiredISOCode() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"BaseLanguageCode",
					buff.getRequiredBaseLanguageCode() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"ISOCountryId",
					buff.getOptionalISOCountryId() );
		return( retval );
	}

	public static String formatISOLanguageRqstCreate( String separator, CFBamISOLanguageBuff buff ) {
		String retval = "<RqstISOLanguageCreate "
			+	formatISOLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstRead( String separator, CFBamISOLanguagePKey pkey ) {
		String retval = "<RqstISOLanguageRead "
			+	formatISOLanguagePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstRead( String separator, CFBamISOLanguageBuff buff ) {
		String retval = "<RqstISOLanguageRead "
			+	formatISOLanguagePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstRead( String separator,
		short argId )
	{
		String retval = "<RqstISOLanguageRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstReadAll( String separator ) {
		String retval = "<RqstISOLanguageReadAll />";
		return( retval );
	}

	public static String formatISOLanguageRqstReadByIdIdx( String separator,
		short argId )
	{
		String retval = "<RqstISOLanguageRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstReadByBaseIdx( String separator,
		String argBaseLanguageCode )
	{
		String retval = "<RqstISOLanguageReadByBaseIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"BaseLanguageCode",
					argBaseLanguageCode )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstReadByCountryIdx( String separator,
		Short argISOCountryId )
	{
		String retval = "<RqstISOLanguageReadByCountryIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ISOCountryId",
					argISOCountryId )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstReadByCodeIdx( String separator,
		String argISOCode )
	{
		String retval = "<RqstISOLanguageReadByCodeIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"ISOCode",
					argISOCode )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstLock( String separator, CFBamISOLanguagePKey pkey ) {
		String retval = "<RqstISOLanguageLock "
			+	formatISOLanguagePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstLock( String separator, CFBamISOLanguageBuff buff ) {
		String retval = "<RqstISOLanguageLock "
			+	formatISOLanguagePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstLock( String separator,
		short argId )
	{
		String retval = "<RqstISOLanguageLock "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstUpdate( String separator, CFBamISOLanguageBuff buff ) {
		String retval = "<RqstISOLanguageUpdate "
			+	formatISOLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstDelete( String separator, CFBamISOLanguageBuff buff ) {
		String retval = "<RqstISOLanguageDelete "
				+	formatISOLanguagePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstDeleteByIdIdx( String separator,
		short argId )
	{
		String retval = "<RqstISOLanguageDelete "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstDeleteByBaseIdx( String separator,
		String argBaseLanguageCode )
	{
		String retval = "<RqstISOLanguageDeleteByBaseIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"BaseLanguageCode",
					argBaseLanguageCode )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstDeleteByCountryIdx( String separator,
		Short argISOCountryId )
	{
		String retval = "<RqstISOLanguageDeleteByCountryIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ISOCountryId",
					argISOCountryId )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRqstDeleteByCodeIdx( String separator,
		String argISOCode )
	{
		String retval = "<RqstISOLanguageDeleteByCodeIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"ISOCode",
					argISOCode )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRspnSingleOpenTag() {
		final String retval = "<RspnISOLanguageReadSingle>";
		return( retval );
	}

	public static String formatISOLanguageRspnSingleCloseTag() {
		final String retval = "</RspnISOLanguageReadSingle>";
		return( retval );
	}

	public static String formatISOLanguageRspnListOpenTag() {
		final String retval = "<RspnISOLanguageReadList>";
		return( retval );
	}

	public static String formatISOLanguageRspnListCloseTag() {
		final String retval = "</RspnISOLanguageReadList>";
		return( retval );
	}

	public static String formatISOLanguageRspnRec( String separator, CFBamISOLanguageBuff buff ) {
		String retval = "<ISOLanguage "
			+	formatISOLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRspnDerivedRec( String separator, CFBamISOLanguageBuff buff ) {
		String retval;
		retval = formatISOLanguageRspnRec( separator, buff );
		return( retval );
	}

	public static String formatISOLanguageRspnCreated( String separator, CFBamISOLanguageBuff buff ) {
		String retval = "<RspnISOLanguageCreated "
			+	formatISOLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRspnLocked( String separator, CFBamISOLanguageBuff buff ) {
		String retval = "<RspnISOLanguageLocked "
			+	formatISOLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRspnUpdated( String separator, CFBamISOLanguageBuff buff ) {
		String retval = "<RspnISOLanguageUpdated "
			+	formatISOLanguageBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatISOLanguageRspnDeleted() {
		String retval = "<RspnISOLanguageDeleted />";
		return( retval );
	}
}
