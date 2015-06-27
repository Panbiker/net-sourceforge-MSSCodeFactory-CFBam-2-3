
// Description: Java 7 XML Message message formatter for CFBam.StringDef

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
 *	CFBamXMsgStringDefMessageFormatter XML message formatter
 *	for CFBam.StringDef.
 */
public class CFBamXMsgStringDefMessageFormatter
	extends CFBamXMsgAtomMessageFormatter
{
	public CFBamXMsgStringDefMessageFormatter() {
		super();
	}

	public static String formatStringDefBuffAttributes( String separator, CFBamStringDefBuff buff ) {
		String retval = CFBamXMsgAtomMessageFormatter.formatAtomBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"MaxLen",
					buff.getRequiredMaxLen() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"ShowLines",
					buff.getRequiredShowLines() )
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
					buff.getOptionalUnknownValue() );
		return( retval );
	}

	public static String formatStringDefRqstCreate( String separator, CFBamStringDefBuff buff ) {
		String retval = "<RqstStringDefCreate "
			+	formatStringDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstRead( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstStringDefRead "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstRead( String separator, CFBamStringDefBuff buff ) {
		String retval = "<RqstStringDefRead "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstStringDefRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadAll( String separator ) {
		String retval = "<RqstStringDefReadAll />";
		return( retval );
	}

	public static String formatStringDefRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstStringDefRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstStringDefReadByUNameIdx "
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

	public static String formatStringDefRqstReadByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstStringDefReadByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstStringDefReadByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstStringDefReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstStringDefReadByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstStringDefReadByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstStringDefReadByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstStringDefReadByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstStringDefReadByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstStringDefReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstStringDefReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstReadByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstStringDefReadByContPrevIdx "
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

	public static String formatStringDefRqstReadByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstStringDefReadByContNextIdx "
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

	public static String formatStringDefRqstLock( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstStringDefLock "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstLock( String separator, CFBamStringDefBuff buff ) {
		String retval = "<RqstStringDefLock "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstStringDefLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstUpdate( String separator, CFBamStringDefBuff buff ) {
		String retval = "<RqstStringDefUpdate "
			+	formatStringDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDelete( String separator, CFBamStringDefBuff buff ) {
		String retval = "<RqstStringDefDelete "
				+	formatValuePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatStringDefRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstStringDefMoveUp "
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

	public static String formatStringDefRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstStringDefMoveDown "
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

	public static String formatStringDefRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstStringDefDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstStringDefDeleteByUNameIdx "
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

	public static String formatStringDefRqstDeleteByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstStringDefDeleteByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstStringDefDeleteByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstStringDefDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstStringDefDeleteByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstStringDefDeleteByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstStringDefDeleteByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstStringDefDeleteByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstStringDefDeleteByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstStringDefDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstStringDefDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRqstDeleteByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstStringDefDeleteByContPrevIdx "
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

	public static String formatStringDefRqstDeleteByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstStringDefDeleteByContNextIdx "
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

	public static String formatStringDefRspnSingleOpenTag() {
		final String retval = "<RspnStringDefReadSingle>";
		return( retval );
	}

	public static String formatStringDefRspnSingleCloseTag() {
		final String retval = "</RspnStringDefReadSingle>";
		return( retval );
	}

	public static String formatStringDefRspnListOpenTag() {
		final String retval = "<RspnStringDefReadList>";
		return( retval );
	}

	public static String formatStringDefRspnListCloseTag() {
		final String retval = "</RspnStringDefReadList>";
		return( retval );
	}

	public static String formatStringDefRspnRec( String separator, CFBamStringDefBuff buff ) {
		String retval = "<StringDef "
			+	formatStringDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRspnDerivedRec( String separator, CFBamStringDefBuff buff ) {
		String retval;
		final String S_ProcName = "formatStringDefRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "STRD" ) ) {
			retval = formatStringDefRspnRec( separator, buff );
		}
		else if( classCode.equals( "STRC" ) ) {
			retval = CFBamXMsgStringColMessageFormatter.formatStringColRspnRec( separator, (CFBamStringColBuff)buff );
		}
		else if( classCode.equals( "STRT" ) ) {
			retval = CFBamXMsgStringTypeMessageFormatter.formatStringTypeRspnRec( separator, (CFBamStringTypeBuff)buff );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgStringDefMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of StringDef" );
		}
		return( retval );
	}

	public static String formatStringDefRspnCreated( String separator, CFBamStringDefBuff buff ) {
		String retval = "<RspnStringDefCreated "
			+	formatStringDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRspnLocked( String separator, CFBamStringDefBuff buff ) {
		String retval = "<RspnStringDefLocked "
			+	formatStringDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRspnUpdated( String separator, CFBamStringDefBuff buff ) {
		String retval = "<RspnStringDefUpdated "
			+	formatStringDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatStringDefRspnDeleted() {
		String retval = "<RspnStringDefDeleted />";
		return( retval );
	}
}
