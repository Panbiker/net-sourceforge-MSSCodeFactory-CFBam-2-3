
// Description: Java 7 XML Message message formatter for CFBam.UuidGen

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
 *	CFBamXMsgUuidGenMessageFormatter XML message formatter
 *	for CFBam.UuidGen.
 */
public class CFBamXMsgUuidGenMessageFormatter
	extends CFBamXMsgUuidTypeMessageFormatter
{
	public CFBamXMsgUuidGenMessageFormatter() {
		super();
	}

	public static String formatUuidGenBuffAttributes( String separator, CFBamUuidGenBuff buff ) {
		String retval = CFBamXMsgUuidTypeMessageFormatter.formatUuidTypeBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DispenserTenantId",
					buff.getOptionalDispenserTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DispenserId",
					buff.getOptionalDispenserId() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"Slice",
					buff.getRequiredSlice() )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"BlockSize",
					buff.getRequiredBlockSize() );
		return( retval );
	}

	public static String formatUuidGenRqstCreate( String separator, CFBamUuidGenBuff buff ) {
		String retval = "<RqstUuidGenCreate "
			+	formatUuidGenBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstRead( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstUuidGenRead "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstRead( String separator, CFBamUuidGenBuff buff ) {
		String retval = "<RqstUuidGenRead "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstUuidGenRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadAll( String separator ) {
		String retval = "<RqstUuidGenReadAll />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstUuidGenRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstUuidGenReadByUNameIdx "
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

	public static String formatUuidGenRqstReadByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstUuidGenReadByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstUuidGenReadByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstUuidGenReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstUuidGenReadByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstUuidGenReadByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstUuidGenReadByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstUuidGenReadByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstUuidGenReadByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstUuidGenReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstUuidGenReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstUuidGenReadByContPrevIdx "
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

	public static String formatUuidGenRqstReadByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstUuidGenReadByContNextIdx "
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

	public static String formatUuidGenRqstReadBySchemaIdx( String separator,
		long argTenantId,
		long argSchemaDefId )
	{
		String retval = "<RqstUuidGenReadBySchemaIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstReadByDispIdx( String separator,
		Long argDispenserTenantId,
		Long argDispenserId )
	{
		String retval = "<RqstUuidGenReadByDispIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DispenserTenantId",
					argDispenserTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DispenserId",
					argDispenserId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstLock( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstUuidGenLock "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstLock( String separator, CFBamUuidGenBuff buff ) {
		String retval = "<RqstUuidGenLock "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstUuidGenLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstUpdate( String separator, CFBamUuidGenBuff buff ) {
		String retval = "<RqstUuidGenUpdate "
			+	formatUuidGenBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDelete( String separator, CFBamUuidGenBuff buff ) {
		String retval = "<RqstUuidGenDelete "
				+	formatValuePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstUuidGenMoveUp "
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

	public static String formatUuidGenRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstUuidGenMoveDown "
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

	public static String formatUuidGenRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstUuidGenDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstUuidGenDeleteByUNameIdx "
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

	public static String formatUuidGenRqstDeleteByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstUuidGenDeleteByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstUuidGenDeleteByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstUuidGenDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstUuidGenDeleteByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstUuidGenDeleteByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstUuidGenDeleteByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstUuidGenDeleteByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstUuidGenDeleteByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstUuidGenDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstUuidGenDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstUuidGenDeleteByContPrevIdx "
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

	public static String formatUuidGenRqstDeleteByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstUuidGenDeleteByContNextIdx "
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

	public static String formatUuidGenRqstDeleteBySchemaIdx( String separator,
		long argTenantId,
		long argSchemaDefId )
	{
		String retval = "<RqstUuidGenDeleteBySchemaIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRqstDeleteByDispIdx( String separator,
		Long argDispenserTenantId,
		Long argDispenserId )
	{
		String retval = "<RqstUuidGenDeleteByDispIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DispenserTenantId",
					argDispenserTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DispenserId",
					argDispenserId )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRspnSingleOpenTag() {
		final String retval = "<RspnUuidGenReadSingle>";
		return( retval );
	}

	public static String formatUuidGenRspnSingleCloseTag() {
		final String retval = "</RspnUuidGenReadSingle>";
		return( retval );
	}

	public static String formatUuidGenRspnListOpenTag() {
		final String retval = "<RspnUuidGenReadList>";
		return( retval );
	}

	public static String formatUuidGenRspnListCloseTag() {
		final String retval = "</RspnUuidGenReadList>";
		return( retval );
	}

	public static String formatUuidGenRspnRec( String separator, CFBamUuidGenBuff buff ) {
		String retval = "<UuidGen "
			+	formatUuidGenBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRspnDerivedRec( String separator, CFBamUuidGenBuff buff ) {
		String retval;
		retval = formatUuidGenRspnRec( separator, buff );
		return( retval );
	}

	public static String formatUuidGenRspnCreated( String separator, CFBamUuidGenBuff buff ) {
		String retval = "<RspnUuidGenCreated "
			+	formatUuidGenBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRspnLocked( String separator, CFBamUuidGenBuff buff ) {
		String retval = "<RspnUuidGenLocked "
			+	formatUuidGenBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRspnUpdated( String separator, CFBamUuidGenBuff buff ) {
		String retval = "<RspnUuidGenUpdated "
			+	formatUuidGenBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatUuidGenRspnDeleted() {
		String retval = "<RspnUuidGenDeleted />";
		return( retval );
	}
}
