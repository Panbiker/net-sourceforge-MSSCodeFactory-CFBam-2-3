
// Description: Java 7 XML Message message formatter for CFBam.MimeType

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
 *	CFBamXMsgMimeTypeMessageFormatter XML message formatter
 *	for CFBam.MimeType.
 */
public class CFBamXMsgMimeTypeMessageFormatter
{
	public CFBamXMsgMimeTypeMessageFormatter() {
	}

	public static String formatMimeTypePKeyAttributes( String separator, CFBamMimeTypePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt32( null,
				"MimeTypeId",
				pkey.getRequiredMimeTypeId() );
		return( retval );
	}

	public static String formatMimeTypePKeyAttributes( String separator, CFBamMimeTypeBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt32( separator,
					"MimeTypeId",
					buff.getRequiredMimeTypeId() );
		return( retval );
	}

	public static String formatMimeTypeBuffAttributes( String separator, CFBamMimeTypeBuff buff ) {
		String retval = CFBamXMsgMimeTypeMessageFormatter.formatMimeTypePKeyAttributes( separator, buff )
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
					buff.getRequiredDescription() );
		return( retval );
	}

	public static String formatMimeTypeRqstCreate( String separator, CFBamMimeTypeBuff buff ) {
		String retval = "<RqstMimeTypeCreate "
			+	formatMimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstRead( String separator, CFBamMimeTypePKey pkey ) {
		String retval = "<RqstMimeTypeRead "
			+	formatMimeTypePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstRead( String separator, CFBamMimeTypeBuff buff ) {
		String retval = "<RqstMimeTypeRead "
			+	formatMimeTypePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstRead( String separator,
		int argMimeTypeId )
	{
		String retval = "<RqstMimeTypeRead "
			+	CFLibXmlUtil.formatRequiredInt32( null,
					"MimeTypeId",
					argMimeTypeId )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstReadAll( String separator ) {
		String retval = "<RqstMimeTypeReadAll />";
		return( retval );
	}

	public static String formatMimeTypeRqstReadByIdIdx( String separator,
		int argMimeTypeId )
	{
		String retval = "<RqstMimeTypeRead "
			+	CFLibXmlUtil.formatRequiredInt32( null,
					"MimeTypeId",
					argMimeTypeId )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstReadByUNameIdx( String separator,
		String argName )
	{
		String retval = "<RqstMimeTypeReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstLock( String separator, CFBamMimeTypePKey pkey ) {
		String retval = "<RqstMimeTypeLock "
			+	formatMimeTypePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstLock( String separator, CFBamMimeTypeBuff buff ) {
		String retval = "<RqstMimeTypeLock "
			+	formatMimeTypePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstLock( String separator,
		int argMimeTypeId )
	{
		String retval = "<RqstMimeTypeLock "
			+	CFLibXmlUtil.formatRequiredInt32( null,
					"MimeTypeId",
					argMimeTypeId )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstUpdate( String separator, CFBamMimeTypeBuff buff ) {
		String retval = "<RqstMimeTypeUpdate "
			+	formatMimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstDelete( String separator, CFBamMimeTypeBuff buff ) {
		String retval = "<RqstMimeTypeDelete "
				+	formatMimeTypePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstDeleteByIdIdx( String separator,
		int argMimeTypeId )
	{
		String retval = "<RqstMimeTypeDelete "
			+	CFLibXmlUtil.formatRequiredInt32( null,
					"MimeTypeId",
					argMimeTypeId )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRqstDeleteByUNameIdx( String separator,
		String argName )
	{
		String retval = "<RqstMimeTypeDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRspnSingleOpenTag() {
		final String retval = "<RspnMimeTypeReadSingle>";
		return( retval );
	}

	public static String formatMimeTypeRspnSingleCloseTag() {
		final String retval = "</RspnMimeTypeReadSingle>";
		return( retval );
	}

	public static String formatMimeTypeRspnListOpenTag() {
		final String retval = "<RspnMimeTypeReadList>";
		return( retval );
	}

	public static String formatMimeTypeRspnListCloseTag() {
		final String retval = "</RspnMimeTypeReadList>";
		return( retval );
	}

	public static String formatMimeTypeRspnRec( String separator, CFBamMimeTypeBuff buff ) {
		String retval = "<MimeType "
			+	formatMimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRspnDerivedRec( String separator, CFBamMimeTypeBuff buff ) {
		String retval;
		retval = formatMimeTypeRspnRec( separator, buff );
		return( retval );
	}

	public static String formatMimeTypeRspnCreated( String separator, CFBamMimeTypeBuff buff ) {
		String retval = "<RspnMimeTypeCreated "
			+	formatMimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRspnLocked( String separator, CFBamMimeTypeBuff buff ) {
		String retval = "<RspnMimeTypeLocked "
			+	formatMimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRspnUpdated( String separator, CFBamMimeTypeBuff buff ) {
		String retval = "<RspnMimeTypeUpdated "
			+	formatMimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMimeTypeRspnDeleted() {
		String retval = "<RspnMimeTypeDeleted />";
		return( retval );
	}
}
