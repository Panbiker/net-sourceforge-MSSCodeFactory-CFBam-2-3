
// Description: Java 7 XML Message message formatter for CFBam.EnumTag

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
 *	CFBamXMsgEnumTagMessageFormatter XML message formatter
 *	for CFBam.EnumTag.
 */
public class CFBamXMsgEnumTagMessageFormatter
{
	public CFBamXMsgEnumTagMessageFormatter() {
	}

	public static String formatEnumTagPKeyAttributes( String separator, CFBamEnumTagPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatEnumTagPKeyAttributes( String separator, CFBamEnumTagBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatEnumTagBuffAttributes( String separator, CFBamEnumTagBuff buff ) {
		String retval = CFBamXMsgEnumTagMessageFormatter.formatEnumTagPKeyAttributes( separator, buff )
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
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaTenantId",
					buff.getOptionalDefSchemaTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					buff.getOptionalDefSchemaId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"EnumId",
					buff.getRequiredEnumId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"EnumCode",
					buff.getOptionalEnumCode() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevTenantId",
					buff.getOptionalPrevTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					buff.getOptionalPrevId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextTenantId",
					buff.getOptionalNextTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					buff.getOptionalNextId() );
		return( retval );
	}

	public static String formatEnumTagRqstCreate( String separator, CFBamEnumTagBuff buff ) {
		String retval = "<RqstEnumTagCreate "
			+	formatEnumTagBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstRead( String separator, CFBamEnumTagPKey pkey ) {
		String retval = "<RqstEnumTagRead "
			+	formatEnumTagPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstRead( String separator, CFBamEnumTagBuff buff ) {
		String retval = "<RqstEnumTagRead "
			+	formatEnumTagPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstEnumTagRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstReadAll( String separator ) {
		String retval = "<RqstEnumTagReadAll />";
		return( retval );
	}

	public static String formatEnumTagRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstEnumTagRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstReadByEnumTagTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstEnumTagReadByEnumTagTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstReadByEnumIdx( String separator,
		long argTenantId,
		long argEnumId )
	{
		String retval = "<RqstEnumTagReadByEnumIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"EnumId",
					argEnumId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstEnumTagReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstReadByEnumNameIdx( String separator,
		long argTenantId,
		long argEnumId,
		String argName )
	{
		String retval = "<RqstEnumTagReadByEnumNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"EnumId",
					argEnumId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstEnumTagReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstEnumTagReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstLock( String separator, CFBamEnumTagPKey pkey ) {
		String retval = "<RqstEnumTagLock "
			+	formatEnumTagPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstLock( String separator, CFBamEnumTagBuff buff ) {
		String retval = "<RqstEnumTagLock "
			+	formatEnumTagPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstEnumTagLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstUpdate( String separator, CFBamEnumTagBuff buff ) {
		String retval = "<RqstEnumTagUpdate "
			+	formatEnumTagBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstDelete( String separator, CFBamEnumTagBuff buff ) {
		String retval = "<RqstEnumTagDelete "
				+	formatEnumTagPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstEnumTagMoveUp "
				+	CFLibXmlUtil.formatRequiredInt64( separator,
						"TenantId",
						TenantId )
				+	CFLibXmlUtil.formatRequiredInt64( separator,
						"Id",
						Id )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						revision )
				+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstEnumTagMoveDown "
				+	CFLibXmlUtil.formatRequiredInt64( separator,
						"TenantId",
						TenantId )
				+	CFLibXmlUtil.formatRequiredInt64( separator,
						"Id",
						Id )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						revision )
				+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstEnumTagDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstDeleteByEnumTagTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstEnumTagDeleteByEnumTagTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstDeleteByEnumIdx( String separator,
		long argTenantId,
		long argEnumId )
	{
		String retval = "<RqstEnumTagDeleteByEnumIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"EnumId",
					argEnumId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstEnumTagDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstDeleteByEnumNameIdx( String separator,
		long argTenantId,
		long argEnumId,
		String argName )
	{
		String retval = "<RqstEnumTagDeleteByEnumNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"EnumId",
					argEnumId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstEnumTagDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstEnumTagDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRspnSingleOpenTag() {
		final String retval = "<RspnEnumTagReadSingle>";
		return( retval );
	}

	public static String formatEnumTagRspnSingleCloseTag() {
		final String retval = "</RspnEnumTagReadSingle>";
		return( retval );
	}

	public static String formatEnumTagRspnListOpenTag() {
		final String retval = "<RspnEnumTagReadList>";
		return( retval );
	}

	public static String formatEnumTagRspnListCloseTag() {
		final String retval = "</RspnEnumTagReadList>";
		return( retval );
	}

	public static String formatEnumTagRspnRec( String separator, CFBamEnumTagBuff buff ) {
		String retval = "<EnumTag "
			+	formatEnumTagBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRspnDerivedRec( String separator, CFBamEnumTagBuff buff ) {
		String retval;
		retval = formatEnumTagRspnRec( separator, buff );
		return( retval );
	}

	public static String formatEnumTagRspnCreated( String separator, CFBamEnumTagBuff buff ) {
		String retval = "<RspnEnumTagCreated "
			+	formatEnumTagBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRspnLocked( String separator, CFBamEnumTagBuff buff ) {
		String retval = "<RspnEnumTagLocked "
			+	formatEnumTagBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRspnUpdated( String separator, CFBamEnumTagBuff buff ) {
		String retval = "<RspnEnumTagUpdated "
			+	formatEnumTagBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatEnumTagRspnDeleted() {
		String retval = "<RspnEnumTagDeleted />";
		return( retval );
	}
}
