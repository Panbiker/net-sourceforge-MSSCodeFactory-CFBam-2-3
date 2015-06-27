
// Description: Java 7 XML Message message formatter for CFBam.ServerListFunc

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
 *	CFBamXMsgServerListFuncMessageFormatter XML message formatter
 *	for CFBam.ServerListFunc.
 */
public class CFBamXMsgServerListFuncMessageFormatter
	extends CFBamXMsgServerMethodMessageFormatter
{
	public CFBamXMsgServerListFuncMessageFormatter() {
		super();
	}

	public static String formatServerListFuncBuffAttributes( String separator, CFBamServerListFuncBuff buff ) {
		String retval = CFBamXMsgServerMethodMessageFormatter.formatServerMethodBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"RetTenantId",
					buff.getOptionalRetTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"RetTableId",
					buff.getOptionalRetTableId() );
		return( retval );
	}

	public static String formatServerListFuncRqstCreate( String separator, CFBamServerListFuncBuff buff ) {
		String retval = "<RqstServerListFuncCreate "
			+	formatServerListFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstServerListFuncRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstRead( String separator, CFBamServerListFuncBuff buff ) {
		String retval = "<RqstServerListFuncRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerListFuncRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstReadAll( String separator ) {
		String retval = "<RqstServerListFuncReadAll />";
		return( retval );
	}

	public static String formatServerListFuncRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerListFuncRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstServerListFuncReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstServerListFuncReadByUNameIdx "
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

	public static String formatServerListFuncRqstReadByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstServerListFuncReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstServerListFuncReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstReadByRetTblIdx( String separator,
		Long argRetTenantId,
		Long argRetTableId )
	{
		String retval = "<RqstServerListFuncReadByRetTblIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"RetTenantId",
					argRetTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"RetTableId",
					argRetTableId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstServerListFuncLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstLock( String separator, CFBamServerListFuncBuff buff ) {
		String retval = "<RqstServerListFuncLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerListFuncLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstUpdate( String separator, CFBamServerListFuncBuff buff ) {
		String retval = "<RqstServerListFuncUpdate "
			+	formatServerListFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstDelete( String separator, CFBamServerListFuncBuff buff ) {
		String retval = "<RqstServerListFuncDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerListFuncDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstServerListFuncDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstServerListFuncDeleteByUNameIdx "
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

	public static String formatServerListFuncRqstDeleteByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstServerListFuncDeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstServerListFuncDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRqstDeleteByRetTblIdx( String separator,
		Long argRetTenantId,
		Long argRetTableId )
	{
		String retval = "<RqstServerListFuncDeleteByRetTblIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"RetTenantId",
					argRetTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"RetTableId",
					argRetTableId )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRspnSingleOpenTag() {
		final String retval = "<RspnServerListFuncReadSingle>";
		return( retval );
	}

	public static String formatServerListFuncRspnSingleCloseTag() {
		final String retval = "</RspnServerListFuncReadSingle>";
		return( retval );
	}

	public static String formatServerListFuncRspnListOpenTag() {
		final String retval = "<RspnServerListFuncReadList>";
		return( retval );
	}

	public static String formatServerListFuncRspnListCloseTag() {
		final String retval = "</RspnServerListFuncReadList>";
		return( retval );
	}

	public static String formatServerListFuncRspnRec( String separator, CFBamServerListFuncBuff buff ) {
		String retval = "<ServerListFunc "
			+	formatServerListFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRspnDerivedRec( String separator, CFBamServerListFuncBuff buff ) {
		String retval;
		retval = formatServerListFuncRspnRec( separator, buff );
		return( retval );
	}

	public static String formatServerListFuncRspnCreated( String separator, CFBamServerListFuncBuff buff ) {
		String retval = "<RspnServerListFuncCreated "
			+	formatServerListFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRspnLocked( String separator, CFBamServerListFuncBuff buff ) {
		String retval = "<RspnServerListFuncLocked "
			+	formatServerListFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRspnUpdated( String separator, CFBamServerListFuncBuff buff ) {
		String retval = "<RspnServerListFuncUpdated "
			+	formatServerListFuncBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerListFuncRspnDeleted() {
		String retval = "<RspnServerListFuncDeleted />";
		return( retval );
	}
}
