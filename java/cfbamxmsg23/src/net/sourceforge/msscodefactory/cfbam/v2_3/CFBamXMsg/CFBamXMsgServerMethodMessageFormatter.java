
// Description: Java 7 XML Message message formatter for CFBam.ServerMethod

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
 *	CFBamXMsgServerMethodMessageFormatter XML message formatter
 *	for CFBam.ServerMethod.
 */
public class CFBamXMsgServerMethodMessageFormatter
	extends CFBamXMsgScopeMessageFormatter
{
	public CFBamXMsgServerMethodMessageFormatter() {
		super();
	}

	public static String formatServerMethodBuffAttributes( String separator, CFBamServerMethodBuff buff ) {
		String retval = CFBamXMsgScopeMessageFormatter.formatScopeBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					buff.getRequiredTableId() )
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
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"Suffix",
					buff.getOptionalSuffix() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"DefaultVisibility",
					buff.getRequiredDefaultVisibility() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsInstanceMethod",
					buff.getRequiredIsInstanceMethod() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"JMethodBody",
					buff.getRequiredJMethodBody() );
		return( retval );
	}

	public static String formatServerMethodRqstCreate( String separator, CFBamServerMethodBuff buff ) {
		String retval = "<RqstServerMethodCreate "
			+	formatServerMethodBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstServerMethodRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstRead( String separator, CFBamServerMethodBuff buff ) {
		String retval = "<RqstServerMethodRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerMethodRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstReadAll( String separator ) {
		String retval = "<RqstServerMethodReadAll />";
		return( retval );
	}

	public static String formatServerMethodRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerMethodRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstServerMethodReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstServerMethodReadByUNameIdx "
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

	public static String formatServerMethodRqstReadByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstServerMethodReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstServerMethodReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstServerMethodLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstLock( String separator, CFBamServerMethodBuff buff ) {
		String retval = "<RqstServerMethodLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerMethodLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstUpdate( String separator, CFBamServerMethodBuff buff ) {
		String retval = "<RqstServerMethodUpdate "
			+	formatServerMethodBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstDelete( String separator, CFBamServerMethodBuff buff ) {
		String retval = "<RqstServerMethodDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstServerMethodDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstServerMethodDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstServerMethodDeleteByUNameIdx "
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

	public static String formatServerMethodRqstDeleteByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstServerMethodDeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstServerMethodDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRspnSingleOpenTag() {
		final String retval = "<RspnServerMethodReadSingle>";
		return( retval );
	}

	public static String formatServerMethodRspnSingleCloseTag() {
		final String retval = "</RspnServerMethodReadSingle>";
		return( retval );
	}

	public static String formatServerMethodRspnListOpenTag() {
		final String retval = "<RspnServerMethodReadList>";
		return( retval );
	}

	public static String formatServerMethodRspnListCloseTag() {
		final String retval = "</RspnServerMethodReadList>";
		return( retval );
	}

	public static String formatServerMethodRspnRec( String separator, CFBamServerMethodBuff buff ) {
		String retval = "<ServerMethod "
			+	formatServerMethodBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRspnDerivedRec( String separator, CFBamServerMethodBuff buff ) {
		String retval;
		final String S_ProcName = "formatServerMethodRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "SRVM" ) ) {
			retval = formatServerMethodRspnRec( separator, buff );
		}
		else if( classCode.equals( "SRVP" ) ) {
			retval = CFBamXMsgServerProcMessageFormatter.formatServerProcRspnRec( separator, (CFBamServerProcBuff)buff );
		}
		else if( classCode.equals( "SRVO" ) ) {
			retval = CFBamXMsgServerObjFuncMessageFormatter.formatServerObjFuncRspnRec( separator, (CFBamServerObjFuncBuff)buff );
		}
		else if( classCode.equals( "SRVL" ) ) {
			retval = CFBamXMsgServerListFuncMessageFormatter.formatServerListFuncRspnRec( separator, (CFBamServerListFuncBuff)buff );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgServerMethodMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of ServerMethod" );
		}
		return( retval );
	}

	public static String formatServerMethodRspnCreated( String separator, CFBamServerMethodBuff buff ) {
		String retval = "<RspnServerMethodCreated "
			+	formatServerMethodBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRspnLocked( String separator, CFBamServerMethodBuff buff ) {
		String retval = "<RspnServerMethodLocked "
			+	formatServerMethodBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRspnUpdated( String separator, CFBamServerMethodBuff buff ) {
		String retval = "<RspnServerMethodUpdated "
			+	formatServerMethodBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatServerMethodRspnDeleted() {
		String retval = "<RspnServerMethodDeleted />";
		return( retval );
	}
}
