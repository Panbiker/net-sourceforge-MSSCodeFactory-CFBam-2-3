
// Description: Java 7 XML Message message formatter for CFBam.TZTimeType

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
 *	CFBamXMsgTZTimeTypeMessageFormatter XML message formatter
 *	for CFBam.TZTimeType.
 */
public class CFBamXMsgTZTimeTypeMessageFormatter
	extends CFBamXMsgTZTimeDefMessageFormatter
{
	public CFBamXMsgTZTimeTypeMessageFormatter() {
		super();
	}

	public static String formatTZTimeTypeBuffAttributes( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval = CFBamXMsgTZTimeDefMessageFormatter.formatTZTimeDefBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					buff.getRequiredSchemaDefId() );
		return( retval );
	}

	public static String formatTZTimeTypeRqstCreate( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval = "<RqstTZTimeTypeCreate "
			+	formatTZTimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstRead( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstTZTimeTypeRead "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstRead( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval = "<RqstTZTimeTypeRead "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTZTimeTypeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadAll( String separator ) {
		String retval = "<RqstTZTimeTypeReadAll />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTZTimeTypeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstTZTimeTypeReadByUNameIdx "
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

	public static String formatTZTimeTypeRqstReadByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTZTimeTypeReadByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstTZTimeTypeReadByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstTZTimeTypeReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstTZTimeTypeReadByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstTZTimeTypeReadByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstTZTimeTypeReadByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstTZTimeTypeReadByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstTZTimeTypeReadByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstTZTimeTypeReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstTZTimeTypeReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstReadByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstTZTimeTypeReadByContPrevIdx "
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

	public static String formatTZTimeTypeRqstReadByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstTZTimeTypeReadByContNextIdx "
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

	public static String formatTZTimeTypeRqstReadBySchemaIdx( String separator,
		long argTenantId,
		long argSchemaDefId )
	{
		String retval = "<RqstTZTimeTypeReadBySchemaIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstLock( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstTZTimeTypeLock "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstLock( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval = "<RqstTZTimeTypeLock "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTZTimeTypeLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstUpdate( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval = "<RqstTZTimeTypeUpdate "
			+	formatTZTimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDelete( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval = "<RqstTZTimeTypeDelete "
				+	formatValuePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstTZTimeTypeMoveUp "
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

	public static String formatTZTimeTypeRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstTZTimeTypeMoveDown "
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

	public static String formatTZTimeTypeRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTZTimeTypeDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstTZTimeTypeDeleteByUNameIdx "
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

	public static String formatTZTimeTypeRqstDeleteByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTZTimeTypeDeleteByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstTZTimeTypeDeleteByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstTZTimeTypeDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstTZTimeTypeDeleteByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstTZTimeTypeDeleteByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstTZTimeTypeDeleteByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstTZTimeTypeDeleteByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstTZTimeTypeDeleteByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstTZTimeTypeDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstTZTimeTypeDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRqstDeleteByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstTZTimeTypeDeleteByContPrevIdx "
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

	public static String formatTZTimeTypeRqstDeleteByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstTZTimeTypeDeleteByContNextIdx "
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

	public static String formatTZTimeTypeRqstDeleteBySchemaIdx( String separator,
		long argTenantId,
		long argSchemaDefId )
	{
		String retval = "<RqstTZTimeTypeDeleteBySchemaIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRspnSingleOpenTag() {
		final String retval = "<RspnTZTimeTypeReadSingle>";
		return( retval );
	}

	public static String formatTZTimeTypeRspnSingleCloseTag() {
		final String retval = "</RspnTZTimeTypeReadSingle>";
		return( retval );
	}

	public static String formatTZTimeTypeRspnListOpenTag() {
		final String retval = "<RspnTZTimeTypeReadList>";
		return( retval );
	}

	public static String formatTZTimeTypeRspnListCloseTag() {
		final String retval = "</RspnTZTimeTypeReadList>";
		return( retval );
	}

	public static String formatTZTimeTypeRspnRec( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval = "<TZTimeType "
			+	formatTZTimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRspnDerivedRec( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval;
		retval = formatTZTimeTypeRspnRec( separator, buff );
		return( retval );
	}

	public static String formatTZTimeTypeRspnCreated( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval = "<RspnTZTimeTypeCreated "
			+	formatTZTimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRspnLocked( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval = "<RspnTZTimeTypeLocked "
			+	formatTZTimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRspnUpdated( String separator, CFBamTZTimeTypeBuff buff ) {
		String retval = "<RspnTZTimeTypeUpdated "
			+	formatTZTimeTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTZTimeTypeRspnDeleted() {
		String retval = "<RspnTZTimeTypeDeleted />";
		return( retval );
	}
}
