
// Description: Java 7 XML Message message formatter for CFBam.Value

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
 *	CFBamXMsgValueMessageFormatter XML message formatter
 *	for CFBam.Value.
 */
public class CFBamXMsgValueMessageFormatter
{
	public CFBamXMsgValueMessageFormatter() {
	}

	public static String formatValuePKeyAttributes( String separator, CFBamValuePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatValuePKeyAttributes( String separator, CFBamValueBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatValueBuffAttributes( String separator, CFBamValueBuff buff ) {
		String retval = CFBamXMsgValueMessageFormatter.formatValuePKeyAttributes( separator, buff )
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
					"ScopeId",
					buff.getRequiredScopeId() )
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
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsNullable",
					buff.getRequiredIsNullable() )
			+	CFLibXmlUtil.formatOptionalBoolean( separator,
					"GenerateId",
					buff.getOptionalGenerateId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"DataScopeId",
					buff.getOptionalDataScopeId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"ViewAccessSecurityId",
					buff.getOptionalViewAccessSecurityId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"EditAccessSecurityId",
					buff.getOptionalEditAccessSecurityId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"ViewAccessFrequencyId",
					buff.getOptionalViewAccessFrequencyId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"EditAccessFrequencyId",
					buff.getOptionalEditAccessFrequencyId() )
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

	public static String formatValueRqstCreate( String separator, CFBamValueBuff buff ) {
		String retval = "<RqstValueCreate "
			+	formatValueBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstRead( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstValueRead "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstRead( String separator, CFBamValueBuff buff ) {
		String retval = "<RqstValueRead "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstValueRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadAll( String separator ) {
		String retval = "<RqstValueReadAll />";
		return( retval );
	}

	public static String formatValueRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstValueRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstValueReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstValueReadByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstValueReadByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstValueReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstValueReadByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstValueReadByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstValueReadByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstValueReadByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstValueReadByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstValueReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstValueReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstValueReadByContPrevIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstReadByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstValueReadByContNextIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstLock( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstValueLock "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstLock( String separator, CFBamValueBuff buff ) {
		String retval = "<RqstValueLock "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstValueLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstUpdate( String separator, CFBamValueBuff buff ) {
		String retval = "<RqstValueUpdate "
			+	formatValueBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDelete( String separator, CFBamValueBuff buff ) {
		String retval = "<RqstValueDelete "
				+	formatValuePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatValueRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstValueMoveUp "
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

	public static String formatValueRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstValueMoveDown "
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

	public static String formatValueRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstValueDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstValueDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstValueDeleteByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstValueDeleteByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstValueDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstValueDeleteByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstValueDeleteByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstValueDeleteByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstValueDeleteByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstValueDeleteByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstValueDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstValueDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstValueDeleteByContPrevIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatValueRqstDeleteByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstValueDeleteByContNextIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatValueRspnSingleOpenTag() {
		final String retval = "<RspnValueReadSingle>";
		return( retval );
	}

	public static String formatValueRspnSingleCloseTag() {
		final String retval = "</RspnValueReadSingle>";
		return( retval );
	}

	public static String formatValueRspnListOpenTag() {
		final String retval = "<RspnValueReadList>";
		return( retval );
	}

	public static String formatValueRspnListCloseTag() {
		final String retval = "</RspnValueReadList>";
		return( retval );
	}

	public static String formatValueRspnRec( String separator, CFBamValueBuff buff ) {
		String retval = "<Value "
			+	formatValueBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatValueRspnDerivedRec( String separator, CFBamValueBuff buff ) {
		String retval;
		final String S_ProcName = "formatValueRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "VALU" ) ) {
			retval = formatValueRspnRec( separator, buff );
		}
		else if( classCode.equals( "TBLC" ) ) {
			retval = CFBamXMsgTableColMessageFormatter.formatTableColRspnRec( separator, (CFBamTableColBuff)buff );
		}
		else if( classCode.equals( "ATOM" ) ) {
			retval = CFBamXMsgAtomMessageFormatter.formatAtomRspnRec( separator, (CFBamAtomBuff)buff );
		}
		else if( classCode.equals( "BLBD" ) ) {
			retval = CFBamXMsgBlobDefMessageFormatter.formatBlobDefRspnRec( separator, (CFBamBlobDefBuff)buff );
		}
		else if( classCode.equals( "BLBC" ) ) {
			retval = CFBamXMsgBlobColMessageFormatter.formatBlobColRspnRec( separator, (CFBamBlobColBuff)buff );
		}
		else if( classCode.equals( "BLBT" ) ) {
			retval = CFBamXMsgBlobTypeMessageFormatter.formatBlobTypeRspnRec( separator, (CFBamBlobTypeBuff)buff );
		}
		else if( classCode.equals( "BOLD" ) ) {
			retval = CFBamXMsgBoolDefMessageFormatter.formatBoolDefRspnRec( separator, (CFBamBoolDefBuff)buff );
		}
		else if( classCode.equals( "BOLC" ) ) {
			retval = CFBamXMsgBoolColMessageFormatter.formatBoolColRspnRec( separator, (CFBamBoolColBuff)buff );
		}
		else if( classCode.equals( "BOLT" ) ) {
			retval = CFBamXMsgBoolTypeMessageFormatter.formatBoolTypeRspnRec( separator, (CFBamBoolTypeBuff)buff );
		}
		else if( classCode.equals( "I16D" ) ) {
			retval = CFBamXMsgInt16DefMessageFormatter.formatInt16DefRspnRec( separator, (CFBamInt16DefBuff)buff );
		}
		else if( classCode.equals( "I16C" ) ) {
			retval = CFBamXMsgInt16ColMessageFormatter.formatInt16ColRspnRec( separator, (CFBamInt16ColBuff)buff );
		}
		else if( classCode.equals( "I16T" ) ) {
			retval = CFBamXMsgInt16TypeMessageFormatter.formatInt16TypeRspnRec( separator, (CFBamInt16TypeBuff)buff );
		}
		else if( classCode.equals( "IG16" ) ) {
			retval = CFBamXMsgId16GenMessageFormatter.formatId16GenRspnRec( separator, (CFBamId16GenBuff)buff );
		}
		else if( classCode.equals( "ENMD" ) ) {
			retval = CFBamXMsgEnumDefMessageFormatter.formatEnumDefRspnRec( separator, (CFBamEnumDefBuff)buff );
		}
		else if( classCode.equals( "ENMC" ) ) {
			retval = CFBamXMsgEnumColMessageFormatter.formatEnumColRspnRec( separator, (CFBamEnumColBuff)buff );
		}
		else if( classCode.equals( "ENMT" ) ) {
			retval = CFBamXMsgEnumTypeMessageFormatter.formatEnumTypeRspnRec( separator, (CFBamEnumTypeBuff)buff );
		}
		else if( classCode.equals( "I32D" ) ) {
			retval = CFBamXMsgInt32DefMessageFormatter.formatInt32DefRspnRec( separator, (CFBamInt32DefBuff)buff );
		}
		else if( classCode.equals( "I32C" ) ) {
			retval = CFBamXMsgInt32ColMessageFormatter.formatInt32ColRspnRec( separator, (CFBamInt32ColBuff)buff );
		}
		else if( classCode.equals( "I32T" ) ) {
			retval = CFBamXMsgInt32TypeMessageFormatter.formatInt32TypeRspnRec( separator, (CFBamInt32TypeBuff)buff );
		}
		else if( classCode.equals( "IG32" ) ) {
			retval = CFBamXMsgId32GenMessageFormatter.formatId32GenRspnRec( separator, (CFBamId32GenBuff)buff );
		}
		else if( classCode.equals( "I64D" ) ) {
			retval = CFBamXMsgInt64DefMessageFormatter.formatInt64DefRspnRec( separator, (CFBamInt64DefBuff)buff );
		}
		else if( classCode.equals( "I64C" ) ) {
			retval = CFBamXMsgInt64ColMessageFormatter.formatInt64ColRspnRec( separator, (CFBamInt64ColBuff)buff );
		}
		else if( classCode.equals( "I64T" ) ) {
			retval = CFBamXMsgInt64TypeMessageFormatter.formatInt64TypeRspnRec( separator, (CFBamInt64TypeBuff)buff );
		}
		else if( classCode.equals( "IG64" ) ) {
			retval = CFBamXMsgId64GenMessageFormatter.formatId64GenRspnRec( separator, (CFBamId64GenBuff)buff );
		}
		else if( classCode.equals( "U16D" ) ) {
			retval = CFBamXMsgUInt16DefMessageFormatter.formatUInt16DefRspnRec( separator, (CFBamUInt16DefBuff)buff );
		}
		else if( classCode.equals( "U16C" ) ) {
			retval = CFBamXMsgUInt16ColMessageFormatter.formatUInt16ColRspnRec( separator, (CFBamUInt16ColBuff)buff );
		}
		else if( classCode.equals( "U16T" ) ) {
			retval = CFBamXMsgUInt16TypeMessageFormatter.formatUInt16TypeRspnRec( separator, (CFBamUInt16TypeBuff)buff );
		}
		else if( classCode.equals( "U32D" ) ) {
			retval = CFBamXMsgUInt32DefMessageFormatter.formatUInt32DefRspnRec( separator, (CFBamUInt32DefBuff)buff );
		}
		else if( classCode.equals( "U32C" ) ) {
			retval = CFBamXMsgUInt32ColMessageFormatter.formatUInt32ColRspnRec( separator, (CFBamUInt32ColBuff)buff );
		}
		else if( classCode.equals( "U32T" ) ) {
			retval = CFBamXMsgUInt32TypeMessageFormatter.formatUInt32TypeRspnRec( separator, (CFBamUInt32TypeBuff)buff );
		}
		else if( classCode.equals( "U64D" ) ) {
			retval = CFBamXMsgUInt64DefMessageFormatter.formatUInt64DefRspnRec( separator, (CFBamUInt64DefBuff)buff );
		}
		else if( classCode.equals( "U64C" ) ) {
			retval = CFBamXMsgUInt64ColMessageFormatter.formatUInt64ColRspnRec( separator, (CFBamUInt64ColBuff)buff );
		}
		else if( classCode.equals( "U64T" ) ) {
			retval = CFBamXMsgUInt64TypeMessageFormatter.formatUInt64TypeRspnRec( separator, (CFBamUInt64TypeBuff)buff );
		}
		else if( classCode.equals( "FLTD" ) ) {
			retval = CFBamXMsgFloatDefMessageFormatter.formatFloatDefRspnRec( separator, (CFBamFloatDefBuff)buff );
		}
		else if( classCode.equals( "FLTC" ) ) {
			retval = CFBamXMsgFloatColMessageFormatter.formatFloatColRspnRec( separator, (CFBamFloatColBuff)buff );
		}
		else if( classCode.equals( "FLTT" ) ) {
			retval = CFBamXMsgFloatTypeMessageFormatter.formatFloatTypeRspnRec( separator, (CFBamFloatTypeBuff)buff );
		}
		else if( classCode.equals( "DBLD" ) ) {
			retval = CFBamXMsgDoubleDefMessageFormatter.formatDoubleDefRspnRec( separator, (CFBamDoubleDefBuff)buff );
		}
		else if( classCode.equals( "DBLC" ) ) {
			retval = CFBamXMsgDoubleColMessageFormatter.formatDoubleColRspnRec( separator, (CFBamDoubleColBuff)buff );
		}
		else if( classCode.equals( "DBLT" ) ) {
			retval = CFBamXMsgDoubleTypeMessageFormatter.formatDoubleTypeRspnRec( separator, (CFBamDoubleTypeBuff)buff );
		}
		else if( classCode.equals( "NUMD" ) ) {
			retval = CFBamXMsgNumberDefMessageFormatter.formatNumberDefRspnRec( separator, (CFBamNumberDefBuff)buff );
		}
		else if( classCode.equals( "NUMC" ) ) {
			retval = CFBamXMsgNumberColMessageFormatter.formatNumberColRspnRec( separator, (CFBamNumberColBuff)buff );
		}
		else if( classCode.equals( "NUMT" ) ) {
			retval = CFBamXMsgNumberTypeMessageFormatter.formatNumberTypeRspnRec( separator, (CFBamNumberTypeBuff)buff );
		}
		else if( classCode.equals( "STRD" ) ) {
			retval = CFBamXMsgStringDefMessageFormatter.formatStringDefRspnRec( separator, (CFBamStringDefBuff)buff );
		}
		else if( classCode.equals( "STRC" ) ) {
			retval = CFBamXMsgStringColMessageFormatter.formatStringColRspnRec( separator, (CFBamStringColBuff)buff );
		}
		else if( classCode.equals( "STRT" ) ) {
			retval = CFBamXMsgStringTypeMessageFormatter.formatStringTypeRspnRec( separator, (CFBamStringTypeBuff)buff );
		}
		else if( classCode.equals( "TXTD" ) ) {
			retval = CFBamXMsgTextDefMessageFormatter.formatTextDefRspnRec( separator, (CFBamTextDefBuff)buff );
		}
		else if( classCode.equals( "TXTC" ) ) {
			retval = CFBamXMsgTextColMessageFormatter.formatTextColRspnRec( separator, (CFBamTextColBuff)buff );
		}
		else if( classCode.equals( "TXTT" ) ) {
			retval = CFBamXMsgTextTypeMessageFormatter.formatTextTypeRspnRec( separator, (CFBamTextTypeBuff)buff );
		}
		else if( classCode.equals( "NTKD" ) ) {
			retval = CFBamXMsgNmTokenDefMessageFormatter.formatNmTokenDefRspnRec( separator, (CFBamNmTokenDefBuff)buff );
		}
		else if( classCode.equals( "NTKC" ) ) {
			retval = CFBamXMsgNmTokenColMessageFormatter.formatNmTokenColRspnRec( separator, (CFBamNmTokenColBuff)buff );
		}
		else if( classCode.equals( "NTKT" ) ) {
			retval = CFBamXMsgNmTokenTypeMessageFormatter.formatNmTokenTypeRspnRec( separator, (CFBamNmTokenTypeBuff)buff );
		}
		else if( classCode.equals( "NTSD" ) ) {
			retval = CFBamXMsgNmTokensDefMessageFormatter.formatNmTokensDefRspnRec( separator, (CFBamNmTokensDefBuff)buff );
		}
		else if( classCode.equals( "NTSC" ) ) {
			retval = CFBamXMsgNmTokensColMessageFormatter.formatNmTokensColRspnRec( separator, (CFBamNmTokensColBuff)buff );
		}
		else if( classCode.equals( "NTST" ) ) {
			retval = CFBamXMsgNmTokensTypeMessageFormatter.formatNmTokensTypeRspnRec( separator, (CFBamNmTokensTypeBuff)buff );
		}
		else if( classCode.equals( "TKND" ) ) {
			retval = CFBamXMsgTokenDefMessageFormatter.formatTokenDefRspnRec( separator, (CFBamTokenDefBuff)buff );
		}
		else if( classCode.equals( "TKNC" ) ) {
			retval = CFBamXMsgTokenColMessageFormatter.formatTokenColRspnRec( separator, (CFBamTokenColBuff)buff );
		}
		else if( classCode.equals( "TKNT" ) ) {
			retval = CFBamXMsgTokenTypeMessageFormatter.formatTokenTypeRspnRec( separator, (CFBamTokenTypeBuff)buff );
		}
		else if( classCode.equals( "DATD" ) ) {
			retval = CFBamXMsgDateDefMessageFormatter.formatDateDefRspnRec( separator, (CFBamDateDefBuff)buff );
		}
		else if( classCode.equals( "DATC" ) ) {
			retval = CFBamXMsgDateColMessageFormatter.formatDateColRspnRec( separator, (CFBamDateColBuff)buff );
		}
		else if( classCode.equals( "DATT" ) ) {
			retval = CFBamXMsgDateTypeMessageFormatter.formatDateTypeRspnRec( separator, (CFBamDateTypeBuff)buff );
		}
		else if( classCode.equals( "TIMD" ) ) {
			retval = CFBamXMsgTimeDefMessageFormatter.formatTimeDefRspnRec( separator, (CFBamTimeDefBuff)buff );
		}
		else if( classCode.equals( "TIMC" ) ) {
			retval = CFBamXMsgTimeColMessageFormatter.formatTimeColRspnRec( separator, (CFBamTimeColBuff)buff );
		}
		else if( classCode.equals( "TIMT" ) ) {
			retval = CFBamXMsgTimeTypeMessageFormatter.formatTimeTypeRspnRec( separator, (CFBamTimeTypeBuff)buff );
		}
		else if( classCode.equals( "TSPD" ) ) {
			retval = CFBamXMsgTimestampDefMessageFormatter.formatTimestampDefRspnRec( separator, (CFBamTimestampDefBuff)buff );
		}
		else if( classCode.equals( "TSPC" ) ) {
			retval = CFBamXMsgTimestampColMessageFormatter.formatTimestampColRspnRec( separator, (CFBamTimestampColBuff)buff );
		}
		else if( classCode.equals( "TSPT" ) ) {
			retval = CFBamXMsgTimestampTypeMessageFormatter.formatTimestampTypeRspnRec( separator, (CFBamTimestampTypeBuff)buff );
		}
		else if( classCode.equals( "DAZD" ) ) {
			retval = CFBamXMsgTZDateDefMessageFormatter.formatTZDateDefRspnRec( separator, (CFBamTZDateDefBuff)buff );
		}
		else if( classCode.equals( "DAZC" ) ) {
			retval = CFBamXMsgTZDateColMessageFormatter.formatTZDateColRspnRec( separator, (CFBamTZDateColBuff)buff );
		}
		else if( classCode.equals( "DAZT" ) ) {
			retval = CFBamXMsgTZDateTypeMessageFormatter.formatTZDateTypeRspnRec( separator, (CFBamTZDateTypeBuff)buff );
		}
		else if( classCode.equals( "TMZD" ) ) {
			retval = CFBamXMsgTZTimeDefMessageFormatter.formatTZTimeDefRspnRec( separator, (CFBamTZTimeDefBuff)buff );
		}
		else if( classCode.equals( "TMZC" ) ) {
			retval = CFBamXMsgTZTimeColMessageFormatter.formatTZTimeColRspnRec( separator, (CFBamTZTimeColBuff)buff );
		}
		else if( classCode.equals( "TMZT" ) ) {
			retval = CFBamXMsgTZTimeTypeMessageFormatter.formatTZTimeTypeRspnRec( separator, (CFBamTZTimeTypeBuff)buff );
		}
		else if( classCode.equals( "ZSTD" ) ) {
			retval = CFBamXMsgTZTimestampDefMessageFormatter.formatTZTimestampDefRspnRec( separator, (CFBamTZTimestampDefBuff)buff );
		}
		else if( classCode.equals( "ZSTC" ) ) {
			retval = CFBamXMsgTZTimestampColMessageFormatter.formatTZTimestampColRspnRec( separator, (CFBamTZTimestampColBuff)buff );
		}
		else if( classCode.equals( "ZSTT" ) ) {
			retval = CFBamXMsgTZTimestampTypeMessageFormatter.formatTZTimestampTypeRspnRec( separator, (CFBamTZTimestampTypeBuff)buff );
		}
		else if( classCode.equals( "UIDD" ) ) {
			retval = CFBamXMsgUuidDefMessageFormatter.formatUuidDefRspnRec( separator, (CFBamUuidDefBuff)buff );
		}
		else if( classCode.equals( "UIDC" ) ) {
			retval = CFBamXMsgUuidColMessageFormatter.formatUuidColRspnRec( separator, (CFBamUuidColBuff)buff );
		}
		else if( classCode.equals( "UIDT" ) ) {
			retval = CFBamXMsgUuidTypeMessageFormatter.formatUuidTypeRspnRec( separator, (CFBamUuidTypeBuff)buff );
		}
		else if( classCode.equals( "IGUU" ) ) {
			retval = CFBamXMsgUuidGenMessageFormatter.formatUuidGenRspnRec( separator, (CFBamUuidGenBuff)buff );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgValueMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of Value" );
		}
		return( retval );
	}

	public static String formatValueRspnCreated( String separator, CFBamValueBuff buff ) {
		String retval = "<RspnValueCreated "
			+	formatValueBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatValueRspnLocked( String separator, CFBamValueBuff buff ) {
		String retval = "<RspnValueLocked "
			+	formatValueBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatValueRspnUpdated( String separator, CFBamValueBuff buff ) {
		String retval = "<RspnValueUpdated "
			+	formatValueBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatValueRspnDeleted() {
		String retval = "<RspnValueDeleted />";
		return( retval );
	}
}
