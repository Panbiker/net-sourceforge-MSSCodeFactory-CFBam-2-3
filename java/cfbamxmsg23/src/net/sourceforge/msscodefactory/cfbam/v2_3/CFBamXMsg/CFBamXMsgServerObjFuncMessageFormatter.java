
// Description: Java 7 XML Message message formatter for CFBam.ServerObjFunc

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
 *	CFBamXMsgServerObjFuncMessageFormatter XML message formatter
 *	for CFBam.ServerObjFunc.
 */
public class CFBamXMsgServerObjFuncMessageFormatter
	extends CFBamXMsgServerMethodMessageFormatter
{
	public CFBamXMsgServerObjFuncMessageFormatter() {
		super();
	}

	public static String formatServerObjFuncBuffAttributes( String separator, CFBamServerObjFuncBuff buff ) {
		String retval = CFBamXMsgServerMethodMessageFormatter.formatServerMethodBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"RetTenantId",
					buff.getOptionalRetTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"RetTableId",
					buff.getOptionalRetTableId() );
		return( retval );
	}

	public static String formatServerObjFuncRqstCreate( String separator, CFBamServerObjFuncBuff buff ) {
		String retval = "<RqstServerObjFuncCreate "
			+	formatServerObjFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstServerObjFuncRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstRead( String separator, CFBamServerObjFuncBuff buff ) {
		String retval = "<RqstServerObjFuncRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerObjFuncRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstReadAll( String separator ) {
		String retval = "<RqstServerObjFuncReadAll />";
		return( retval );
	}

	public static String formatServerObjFuncRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerObjFuncRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstServerObjFuncReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstServerObjFuncReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstReadByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstServerObjFuncReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstServerObjFuncReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstReadByRetTblIdx( String separator,
		Long argRetTenantId,
		Long argRetTableId )
	{
		String retval = "<RqstServerObjFuncReadByRetTblIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"RetTenantId",
					argRetTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"RetTableId",
					argRetTableId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstServerObjFuncLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstLock( String separator, CFBamServerObjFuncBuff buff ) {
		String retval = "<RqstServerObjFuncLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerObjFuncLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstUpdate( String separator, CFBamServerObjFuncBuff buff ) {
		String retval = "<RqstServerObjFuncUpdate "
			+	formatServerObjFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstDelete( String separator, CFBamServerObjFuncBuff buff ) {
		String retval = "<RqstServerObjFuncDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerObjFuncDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstServerObjFuncDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstServerObjFuncDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstDeleteByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstServerObjFuncDeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstServerObjFuncDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRqstDeleteByRetTblIdx( String separator,
		Long argRetTenantId,
		Long argRetTableId )
	{
		String retval = "<RqstServerObjFuncDeleteByRetTblIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"RetTenantId",
					argRetTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"RetTableId",
					argRetTableId )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRspnSingleOpenTag() {
		final String retval = "<RspnServerObjFuncReadSingle>";
		return( retval );
	}

	public static String formatServerObjFuncRspnSingleCloseTag() {
		final String retval = "</RspnServerObjFuncReadSingle>";
		return( retval );
	}

	public static String formatServerObjFuncRspnListOpenTag() {
		final String retval = "<RspnServerObjFuncReadList>";
		return( retval );
	}

	public static String formatServerObjFuncRspnListCloseTag() {
		final String retval = "</RspnServerObjFuncReadList>";
		return( retval );
	}

	public static String formatServerObjFuncRspnRec( String separator, CFBamServerObjFuncBuff buff ) {
		String retval = "<ServerObjFunc "
			+	formatServerObjFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRspnDerivedRec( String separator, CFBamServerObjFuncBuff buff ) {
		String retval;
		retval = formatServerObjFuncRspnRec( separator, buff );
		return( retval );
	}

	public static String formatServerObjFuncRspnCreated( String separator, CFBamServerObjFuncBuff buff ) {
		String retval = "<RspnServerObjFuncCreated "
			+	formatServerObjFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRspnLocked( String separator, CFBamServerObjFuncBuff buff ) {
		String retval = "<RspnServerObjFuncLocked "
			+	formatServerObjFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRspnUpdated( String separator, CFBamServerObjFuncBuff buff ) {
		String retval = "<RspnServerObjFuncUpdated "
			+	formatServerObjFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerObjFuncRspnDeleted() {
		String retval = "<RspnServerObjFuncDeleted />";
		return( retval );
	}
}
