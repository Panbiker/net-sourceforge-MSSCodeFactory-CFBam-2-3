
// Description: Java 7 XML Message message formatter for CFBam.Tenant

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
 *	CFBamXMsgTenantMessageFormatter XML message formatter
 *	for CFBam.Tenant.
 */
public class CFBamXMsgTenantMessageFormatter
{
	public CFBamXMsgTenantMessageFormatter() {
	}

	public static String formatTenantPKeyAttributes( String separator, CFBamTenantPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatTenantPKeyAttributes( String separator, CFBamTenantBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatTenantBuffAttributes( String separator, CFBamTenantBuff buff ) {
		String retval = CFBamXMsgTenantMessageFormatter.formatTenantPKeyAttributes( separator, buff )
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
					"ClusterId",
					buff.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"TenantName",
					buff.getRequiredTenantName() );
		return( retval );
	}

	public static String formatTenantRqstCreate( String separator, CFBamTenantBuff buff ) {
		String retval = "<RqstTenantCreate "
			+	formatTenantBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstRead( String separator, CFBamTenantPKey pkey ) {
		String retval = "<RqstTenantRead "
			+	formatTenantPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstRead( String separator, CFBamTenantBuff buff ) {
		String retval = "<RqstTenantRead "
			+	formatTenantPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstRead( String separator,
		long argId )
	{
		String retval = "<RqstTenantRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstReadAll( String separator ) {
		String retval = "<RqstTenantReadAll />";
		return( retval );
	}

	public static String formatTenantRqstReadByIdIdx( String separator,
		long argId )
	{
		String retval = "<RqstTenantRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstReadByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstTenantReadByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstReadByUNameIdx( String separator,
		long argClusterId,
		String argTenantName )
	{
		String retval = "<RqstTenantReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"TenantName",
					argTenantName )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstLock( String separator, CFBamTenantPKey pkey ) {
		String retval = "<RqstTenantLock "
			+	formatTenantPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstLock( String separator, CFBamTenantBuff buff ) {
		String retval = "<RqstTenantLock "
			+	formatTenantPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstLock( String separator,
		long argId )
	{
		String retval = "<RqstTenantLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstUpdate( String separator, CFBamTenantBuff buff ) {
		String retval = "<RqstTenantUpdate "
			+	formatTenantBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstDelete( String separator, CFBamTenantBuff buff ) {
		String retval = "<RqstTenantDelete "
				+	formatTenantPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatTenantRqstDeleteByIdIdx( String separator,
		long argId )
	{
		String retval = "<RqstTenantDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstDeleteByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstTenantDeleteByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatTenantRqstDeleteByUNameIdx( String separator,
		long argClusterId,
		String argTenantName )
	{
		String retval = "<RqstTenantDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"TenantName",
					argTenantName )
			+	" />";
		return( retval );
	}

	public static String formatTenantRspnSingleOpenTag() {
		final String retval = "<RspnTenantReadSingle>";
		return( retval );
	}

	public static String formatTenantRspnSingleCloseTag() {
		final String retval = "</RspnTenantReadSingle>";
		return( retval );
	}

	public static String formatTenantRspnListOpenTag() {
		final String retval = "<RspnTenantReadList>";
		return( retval );
	}

	public static String formatTenantRspnListCloseTag() {
		final String retval = "</RspnTenantReadList>";
		return( retval );
	}

	public static String formatTenantRspnRec( String separator, CFBamTenantBuff buff ) {
		String retval = "<Tenant "
			+	formatTenantBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTenantRspnDerivedRec( String separator, CFBamTenantBuff buff ) {
		String retval;
		retval = formatTenantRspnRec( separator, buff );
		return( retval );
	}

	public static String formatTenantRspnCreated( String separator, CFBamTenantBuff buff ) {
		String retval = "<RspnTenantCreated "
			+	formatTenantBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTenantRspnLocked( String separator, CFBamTenantBuff buff ) {
		String retval = "<RspnTenantLocked "
			+	formatTenantBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTenantRspnUpdated( String separator, CFBamTenantBuff buff ) {
		String retval = "<RspnTenantUpdated "
			+	formatTenantBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTenantRspnDeleted() {
		String retval = "<RspnTenantDeleted />";
		return( retval );
	}
}
