
// Description: Java 7 XML Message message formatter for CFBam.Param

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
 *	CFBamXMsgParamMessageFormatter XML message formatter
 *	for CFBam.Param.
 */
public class CFBamXMsgParamMessageFormatter
{
	public CFBamXMsgParamMessageFormatter() {
	}

	public static String formatParamPKeyAttributes( String separator, CFBamParamPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatParamPKeyAttributes( String separator, CFBamParamBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatParamBuffAttributes( String separator, CFBamParamBuff buff ) {
		String retval = CFBamXMsgParamMessageFormatter.formatParamPKeyAttributes( separator, buff )
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
					"ServerMethodId",
					buff.getRequiredServerMethodId() )
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
					"ShortDescription",
					buff.getOptionalShortDescription() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"Description",
					buff.getOptionalDescription() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsNullable",
					buff.getRequiredIsNullable() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"TypeTenantId",
					buff.getOptionalTypeTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"TypeId",
					buff.getOptionalTypeId() )
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

	public static String formatParamRqstCreate( String separator, CFBamParamBuff buff ) {
		String retval = "<RqstParamCreate "
			+	formatParamBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstRead( String separator, CFBamParamPKey pkey ) {
		String retval = "<RqstParamRead "
			+	formatParamPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstRead( String separator, CFBamParamBuff buff ) {
		String retval = "<RqstParamRead "
			+	formatParamPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstParamRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstReadAll( String separator ) {
		String retval = "<RqstParamReadAll />";
		return( retval );
	}

	public static String formatParamRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstParamRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argServerMethodId,
		String argName )
	{
		String retval = "<RqstParamReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServerMethodId",
					argServerMethodId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstReadByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstParamReadByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstReadByServerMethodIdx( String separator,
		long argTenantId,
		long argServerMethodId )
	{
		String retval = "<RqstParamReadByServerMethodIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServerMethodId",
					argServerMethodId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstParamReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstReadByServerTypeIdx( String separator,
		Long argTypeTenantId,
		Long argTypeId )
	{
		String retval = "<RqstParamReadByServerTypeIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"TypeTenantId",
					argTypeTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"TypeId",
					argTypeId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstParamReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstParamReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstReadByContPrevIdx( String separator,
		long argTenantId,
		long argServerMethodId,
		Long argPrevId )
	{
		String retval = "<RqstParamReadByContPrevIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServerMethodId",
					argServerMethodId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstReadByContNextIdx( String separator,
		long argTenantId,
		long argServerMethodId,
		Long argNextId )
	{
		String retval = "<RqstParamReadByContNextIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServerMethodId",
					argServerMethodId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstLock( String separator, CFBamParamPKey pkey ) {
		String retval = "<RqstParamLock "
			+	formatParamPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstLock( String separator, CFBamParamBuff buff ) {
		String retval = "<RqstParamLock "
			+	formatParamPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstParamLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstUpdate( String separator, CFBamParamBuff buff ) {
		String retval = "<RqstParamUpdate "
			+	formatParamBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstDelete( String separator, CFBamParamBuff buff ) {
		String retval = "<RqstParamDelete "
				+	formatParamPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatParamRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstParamMoveUp "
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

	public static String formatParamRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstParamMoveDown "
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

	public static String formatParamRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstParamDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argServerMethodId,
		String argName )
	{
		String retval = "<RqstParamDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServerMethodId",
					argServerMethodId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstDeleteByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstParamDeleteByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstDeleteByServerMethodIdx( String separator,
		long argTenantId,
		long argServerMethodId )
	{
		String retval = "<RqstParamDeleteByServerMethodIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServerMethodId",
					argServerMethodId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstParamDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstDeleteByServerTypeIdx( String separator,
		Long argTypeTenantId,
		Long argTypeId )
	{
		String retval = "<RqstParamDeleteByServerTypeIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"TypeTenantId",
					argTypeTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"TypeId",
					argTypeId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstParamDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstParamDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstDeleteByContPrevIdx( String separator,
		long argTenantId,
		long argServerMethodId,
		Long argPrevId )
	{
		String retval = "<RqstParamDeleteByContPrevIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServerMethodId",
					argServerMethodId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatParamRqstDeleteByContNextIdx( String separator,
		long argTenantId,
		long argServerMethodId,
		Long argNextId )
	{
		String retval = "<RqstParamDeleteByContNextIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ServerMethodId",
					argServerMethodId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatParamRspnSingleOpenTag() {
		final String retval = "<RspnParamReadSingle>";
		return( retval );
	}

	public static String formatParamRspnSingleCloseTag() {
		final String retval = "</RspnParamReadSingle>";
		return( retval );
	}

	public static String formatParamRspnListOpenTag() {
		final String retval = "<RspnParamReadList>";
		return( retval );
	}

	public static String formatParamRspnListCloseTag() {
		final String retval = "</RspnParamReadList>";
		return( retval );
	}

	public static String formatParamRspnRec( String separator, CFBamParamBuff buff ) {
		String retval = "<Param "
			+	formatParamBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatParamRspnDerivedRec( String separator, CFBamParamBuff buff ) {
		String retval;
		retval = formatParamRspnRec( separator, buff );
		return( retval );
	}

	public static String formatParamRspnCreated( String separator, CFBamParamBuff buff ) {
		String retval = "<RspnParamCreated "
			+	formatParamBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatParamRspnLocked( String separator, CFBamParamBuff buff ) {
		String retval = "<RspnParamLocked "
			+	formatParamBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatParamRspnUpdated( String separator, CFBamParamBuff buff ) {
		String retval = "<RspnParamUpdated "
			+	formatParamBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatParamRspnDeleted() {
		String retval = "<RspnParamDeleted />";
		return( retval );
	}
}
