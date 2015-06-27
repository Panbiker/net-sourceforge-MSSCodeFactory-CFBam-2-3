
// Description: Java 7 XML Message message formatter for CFBam.TextType

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
 *	CFBamXMsgTextTypeMessageFormatter XML message formatter
 *	for CFBam.TextType.
 */
public class CFBamXMsgTextTypeMessageFormatter
	extends CFBamXMsgTextDefMessageFormatter
{
	public CFBamXMsgTextTypeMessageFormatter() {
		super();
	}

	public static String formatTextTypeBuffAttributes( String separator, CFBamTextTypeBuff buff ) {
		String retval = CFBamXMsgTextDefMessageFormatter.formatTextDefBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					buff.getRequiredSchemaDefId() );
		return( retval );
	}

	public static String formatTextTypeRqstCreate( String separator, CFBamTextTypeBuff buff ) {
		String retval = "<RqstTextTypeCreate "
			+	formatTextTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstRead( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstTextTypeRead "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstRead( String separator, CFBamTextTypeBuff buff ) {
		String retval = "<RqstTextTypeRead "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTextTypeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadAll( String separator ) {
		String retval = "<RqstTextTypeReadAll />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTextTypeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstTextTypeReadByUNameIdx "
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

	public static String formatTextTypeRqstReadByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTextTypeReadByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstTextTypeReadByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstTextTypeReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstTextTypeReadByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstTextTypeReadByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstTextTypeReadByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstTextTypeReadByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstTextTypeReadByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstTextTypeReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstTextTypeReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstReadByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstTextTypeReadByContPrevIdx "
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

	public static String formatTextTypeRqstReadByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstTextTypeReadByContNextIdx "
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

	public static String formatTextTypeRqstReadBySchemaIdx( String separator,
		long argTenantId,
		long argSchemaDefId )
	{
		String retval = "<RqstTextTypeReadBySchemaIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstLock( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstTextTypeLock "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstLock( String separator, CFBamTextTypeBuff buff ) {
		String retval = "<RqstTextTypeLock "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTextTypeLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstUpdate( String separator, CFBamTextTypeBuff buff ) {
		String retval = "<RqstTextTypeUpdate "
			+	formatTextTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDelete( String separator, CFBamTextTypeBuff buff ) {
		String retval = "<RqstTextTypeDelete "
				+	formatValuePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstTextTypeMoveUp "
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

	public static String formatTextTypeRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstTextTypeMoveDown "
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

	public static String formatTextTypeRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTextTypeDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstTextTypeDeleteByUNameIdx "
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

	public static String formatTextTypeRqstDeleteByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTextTypeDeleteByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstTextTypeDeleteByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstTextTypeDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstTextTypeDeleteByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstTextTypeDeleteByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstTextTypeDeleteByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstTextTypeDeleteByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstTextTypeDeleteByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstTextTypeDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstTextTypeDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRqstDeleteByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstTextTypeDeleteByContPrevIdx "
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

	public static String formatTextTypeRqstDeleteByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstTextTypeDeleteByContNextIdx "
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

	public static String formatTextTypeRqstDeleteBySchemaIdx( String separator,
		long argTenantId,
		long argSchemaDefId )
	{
		String retval = "<RqstTextTypeDeleteBySchemaIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRspnSingleOpenTag() {
		final String retval = "<RspnTextTypeReadSingle>";
		return( retval );
	}

	public static String formatTextTypeRspnSingleCloseTag() {
		final String retval = "</RspnTextTypeReadSingle>";
		return( retval );
	}

	public static String formatTextTypeRspnListOpenTag() {
		final String retval = "<RspnTextTypeReadList>";
		return( retval );
	}

	public static String formatTextTypeRspnListCloseTag() {
		final String retval = "</RspnTextTypeReadList>";
		return( retval );
	}

	public static String formatTextTypeRspnRec( String separator, CFBamTextTypeBuff buff ) {
		String retval = "<TextType "
			+	formatTextTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRspnDerivedRec( String separator, CFBamTextTypeBuff buff ) {
		String retval;
		retval = formatTextTypeRspnRec( separator, buff );
		return( retval );
	}

	public static String formatTextTypeRspnCreated( String separator, CFBamTextTypeBuff buff ) {
		String retval = "<RspnTextTypeCreated "
			+	formatTextTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRspnLocked( String separator, CFBamTextTypeBuff buff ) {
		String retval = "<RspnTextTypeLocked "
			+	formatTextTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRspnUpdated( String separator, CFBamTextTypeBuff buff ) {
		String retval = "<RspnTextTypeUpdated "
			+	formatTextTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTextTypeRspnDeleted() {
		String retval = "<RspnTextTypeDeleted />";
		return( retval );
	}
}
