
// Description: Java 7 XML Message message formatter for CFBam.NmTokenDef

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
 *	CFBamXMsgNmTokenDefMessageFormatter XML message formatter
 *	for CFBam.NmTokenDef.
 */
public class CFBamXMsgNmTokenDefMessageFormatter
	extends CFBamXMsgAtomMessageFormatter
{
	public CFBamXMsgNmTokenDefMessageFormatter() {
		super();
	}

	public static String formatNmTokenDefBuffAttributes( String separator, CFBamNmTokenDefBuff buff ) {
		String retval = CFBamXMsgAtomMessageFormatter.formatAtomBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"MaxLen",
					buff.getRequiredMaxLen() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"InitValue",
					buff.getOptionalInitValue() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"DefaultValue",
					buff.getOptionalDefaultValue() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"NullValue",
					buff.getOptionalNullValue() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"UnknownValue",
					buff.getOptionalUnknownValue() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"ShowLines",
					buff.getRequiredShowLines() );
		return( retval );
	}

	public static String formatNmTokenDefRqstCreate( String separator, CFBamNmTokenDefBuff buff ) {
		String retval = "<RqstNmTokenDefCreate "
			+	formatNmTokenDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstRead( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstNmTokenDefRead "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstRead( String separator, CFBamNmTokenDefBuff buff ) {
		String retval = "<RqstNmTokenDefRead "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstNmTokenDefRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadAll( String separator ) {
		String retval = "<RqstNmTokenDefReadAll />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstNmTokenDefRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstNmTokenDefReadByUNameIdx "
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

	public static String formatNmTokenDefRqstReadByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstNmTokenDefReadByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstNmTokenDefReadByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstNmTokenDefReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstNmTokenDefReadByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstNmTokenDefReadByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstNmTokenDefReadByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstNmTokenDefReadByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstNmTokenDefReadByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstNmTokenDefReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstNmTokenDefReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstReadByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstNmTokenDefReadByContPrevIdx "
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

	public static String formatNmTokenDefRqstReadByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstNmTokenDefReadByContNextIdx "
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

	public static String formatNmTokenDefRqstLock( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstNmTokenDefLock "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstLock( String separator, CFBamNmTokenDefBuff buff ) {
		String retval = "<RqstNmTokenDefLock "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstNmTokenDefLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstUpdate( String separator, CFBamNmTokenDefBuff buff ) {
		String retval = "<RqstNmTokenDefUpdate "
			+	formatNmTokenDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDelete( String separator, CFBamNmTokenDefBuff buff ) {
		String retval = "<RqstNmTokenDefDelete "
				+	formatValuePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstNmTokenDefMoveUp "
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

	public static String formatNmTokenDefRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstNmTokenDefMoveDown "
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

	public static String formatNmTokenDefRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstNmTokenDefDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstNmTokenDefDeleteByUNameIdx "
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

	public static String formatNmTokenDefRqstDeleteByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstNmTokenDefDeleteByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstNmTokenDefDeleteByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstNmTokenDefDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstNmTokenDefDeleteByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstNmTokenDefDeleteByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstNmTokenDefDeleteByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstNmTokenDefDeleteByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstNmTokenDefDeleteByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstNmTokenDefDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstNmTokenDefDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRqstDeleteByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstNmTokenDefDeleteByContPrevIdx "
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

	public static String formatNmTokenDefRqstDeleteByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstNmTokenDefDeleteByContNextIdx "
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

	public static String formatNmTokenDefRspnSingleOpenTag() {
		final String retval = "<RspnNmTokenDefReadSingle>";
		return( retval );
	}

	public static String formatNmTokenDefRspnSingleCloseTag() {
		final String retval = "</RspnNmTokenDefReadSingle>";
		return( retval );
	}

	public static String formatNmTokenDefRspnListOpenTag() {
		final String retval = "<RspnNmTokenDefReadList>";
		return( retval );
	}

	public static String formatNmTokenDefRspnListCloseTag() {
		final String retval = "</RspnNmTokenDefReadList>";
		return( retval );
	}

	public static String formatNmTokenDefRspnRec( String separator, CFBamNmTokenDefBuff buff ) {
		String retval = "<NmTokenDef "
			+	formatNmTokenDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRspnDerivedRec( String separator, CFBamNmTokenDefBuff buff ) {
		String retval;
		final String S_ProcName = "formatNmTokenDefRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "NTKD" ) ) {
			retval = formatNmTokenDefRspnRec( separator, buff );
		}
		else if( classCode.equals( "NTKC" ) ) {
			retval = CFBamXMsgNmTokenColMessageFormatter.formatNmTokenColRspnRec( separator, (CFBamNmTokenColBuff)buff );
		}
		else if( classCode.equals( "NTKT" ) ) {
			retval = CFBamXMsgNmTokenTypeMessageFormatter.formatNmTokenTypeRspnRec( separator, (CFBamNmTokenTypeBuff)buff );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgNmTokenDefMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of NmTokenDef" );
		}
		return( retval );
	}

	public static String formatNmTokenDefRspnCreated( String separator, CFBamNmTokenDefBuff buff ) {
		String retval = "<RspnNmTokenDefCreated "
			+	formatNmTokenDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRspnLocked( String separator, CFBamNmTokenDefBuff buff ) {
		String retval = "<RspnNmTokenDefLocked "
			+	formatNmTokenDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRspnUpdated( String separator, CFBamNmTokenDefBuff buff ) {
		String retval = "<RspnNmTokenDefUpdated "
			+	formatNmTokenDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatNmTokenDefRspnDeleted() {
		String retval = "<RspnNmTokenDefDeleted />";
		return( retval );
	}
}
