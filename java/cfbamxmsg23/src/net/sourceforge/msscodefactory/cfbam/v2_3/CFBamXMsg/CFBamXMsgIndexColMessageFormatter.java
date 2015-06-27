
// Description: Java 7 XML Message message formatter for CFBam.IndexCol

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
 *	CFBamXMsgIndexColMessageFormatter XML message formatter
 *	for CFBam.IndexCol.
 */
public class CFBamXMsgIndexColMessageFormatter
{
	public CFBamXMsgIndexColMessageFormatter() {
	}

	public static String formatIndexColPKeyAttributes( String separator, CFBamIndexColPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatIndexColPKeyAttributes( String separator, CFBamIndexColBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatIndexColBuffAttributes( String separator, CFBamIndexColBuff buff ) {
		String retval = CFBamXMsgIndexColMessageFormatter.formatIndexColPKeyAttributes( separator, buff )
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
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"IndexId",
					buff.getRequiredIndexId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaTenantId",
					buff.getOptionalDefSchemaTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					buff.getOptionalDefSchemaId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"ShortName",
					buff.getOptionalShortName() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"Label",
					buff.getOptionalLabel() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"ShortDescription",
					buff.getOptionalShortDescription() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"Description",
					buff.getOptionalDescription() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ColumnId",
					buff.getRequiredColumnId() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsAscending",
					buff.getRequiredIsAscending() )
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
					buff.getOptionalNextId() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"DefaultVisibility",
					buff.getRequiredDefaultVisibility() );
		return( retval );
	}

	public static String formatIndexColRqstCreate( String separator, CFBamIndexColBuff buff ) {
		String retval = "<RqstIndexColCreate "
			+	formatIndexColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstRead( String separator, CFBamIndexColPKey pkey ) {
		String retval = "<RqstIndexColRead "
			+	formatIndexColPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstRead( String separator, CFBamIndexColBuff buff ) {
		String retval = "<RqstIndexColRead "
			+	formatIndexColPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstIndexColRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstReadAll( String separator ) {
		String retval = "<RqstIndexColReadAll />";
		return( retval );
	}

	public static String formatIndexColRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstIndexColRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argIndexId,
		String argName )
	{
		String retval = "<RqstIndexColReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"IndexId",
					argIndexId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstReadByIdxColTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstIndexColReadByIdxColTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstReadByIndexIdx( String separator,
		long argTenantId,
		long argIndexId )
	{
		String retval = "<RqstIndexColReadByIndexIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"IndexId",
					argIndexId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstIndexColReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstReadByColIdx( String separator,
		long argTenantId,
		long argColumnId )
	{
		String retval = "<RqstIndexColReadByColIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ColumnId",
					argColumnId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstIndexColReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstIndexColReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstReadByIdxPrevIdx( String separator,
		long argTenantId,
		long argIndexId,
		Long argPrevId )
	{
		String retval = "<RqstIndexColReadByIdxPrevIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"IndexId",
					argIndexId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstReadByIdxNextIdx( String separator,
		long argTenantId,
		long argIndexId,
		Long argNextId )
	{
		String retval = "<RqstIndexColReadByIdxNextIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"IndexId",
					argIndexId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstLock( String separator, CFBamIndexColPKey pkey ) {
		String retval = "<RqstIndexColLock "
			+	formatIndexColPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstLock( String separator, CFBamIndexColBuff buff ) {
		String retval = "<RqstIndexColLock "
			+	formatIndexColPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstIndexColLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstUpdate( String separator, CFBamIndexColBuff buff ) {
		String retval = "<RqstIndexColUpdate "
			+	formatIndexColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstDelete( String separator, CFBamIndexColBuff buff ) {
		String retval = "<RqstIndexColDelete "
				+	formatIndexColPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatIndexColRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstIndexColMoveUp "
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

	public static String formatIndexColRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstIndexColMoveDown "
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

	public static String formatIndexColRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstIndexColDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argIndexId,
		String argName )
	{
		String retval = "<RqstIndexColDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"IndexId",
					argIndexId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstDeleteByIdxColTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstIndexColDeleteByIdxColTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstDeleteByIndexIdx( String separator,
		long argTenantId,
		long argIndexId )
	{
		String retval = "<RqstIndexColDeleteByIndexIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"IndexId",
					argIndexId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstIndexColDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstDeleteByColIdx( String separator,
		long argTenantId,
		long argColumnId )
	{
		String retval = "<RqstIndexColDeleteByColIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ColumnId",
					argColumnId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstIndexColDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstIndexColDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstDeleteByIdxPrevIdx( String separator,
		long argTenantId,
		long argIndexId,
		Long argPrevId )
	{
		String retval = "<RqstIndexColDeleteByIdxPrevIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"IndexId",
					argIndexId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRqstDeleteByIdxNextIdx( String separator,
		long argTenantId,
		long argIndexId,
		Long argNextId )
	{
		String retval = "<RqstIndexColDeleteByIdxNextIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"IndexId",
					argIndexId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRspnSingleOpenTag() {
		final String retval = "<RspnIndexColReadSingle>";
		return( retval );
	}

	public static String formatIndexColRspnSingleCloseTag() {
		final String retval = "</RspnIndexColReadSingle>";
		return( retval );
	}

	public static String formatIndexColRspnListOpenTag() {
		final String retval = "<RspnIndexColReadList>";
		return( retval );
	}

	public static String formatIndexColRspnListCloseTag() {
		final String retval = "</RspnIndexColReadList>";
		return( retval );
	}

	public static String formatIndexColRspnRec( String separator, CFBamIndexColBuff buff ) {
		String retval = "<IndexCol "
			+	formatIndexColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRspnDerivedRec( String separator, CFBamIndexColBuff buff ) {
		String retval;
		retval = formatIndexColRspnRec( separator, buff );
		return( retval );
	}

	public static String formatIndexColRspnCreated( String separator, CFBamIndexColBuff buff ) {
		String retval = "<RspnIndexColCreated "
			+	formatIndexColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRspnLocked( String separator, CFBamIndexColBuff buff ) {
		String retval = "<RspnIndexColLocked "
			+	formatIndexColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRspnUpdated( String separator, CFBamIndexColBuff buff ) {
		String retval = "<RspnIndexColUpdated "
			+	formatIndexColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexColRspnDeleted() {
		String retval = "<RspnIndexColDeleted />";
		return( retval );
	}
}
