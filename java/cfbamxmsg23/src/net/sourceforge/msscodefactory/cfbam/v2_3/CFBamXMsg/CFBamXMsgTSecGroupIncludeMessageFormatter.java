
// Description: Java 7 XML Message message formatter for CFBam.TSecGroupInclude

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
 *	CFBamXMsgTSecGroupIncludeMessageFormatter XML message formatter
 *	for CFBam.TSecGroupInclude.
 */
public class CFBamXMsgTSecGroupIncludeMessageFormatter
{
	public CFBamXMsgTSecGroupIncludeMessageFormatter() {
	}

	public static String formatTSecGroupIncludePKeyAttributes( String separator, CFBamTSecGroupIncludePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"TSecGroupIncludeId",
				pkey.getRequiredTSecGroupIncludeId() );
		return( retval );
	}

	public static String formatTSecGroupIncludePKeyAttributes( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TSecGroupIncludeId",
					buff.getRequiredTSecGroupIncludeId() );
		return( retval );
	}

	public static String formatTSecGroupIncludeBuffAttributes( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = CFBamXMsgTSecGroupIncludeMessageFormatter.formatTSecGroupIncludePKeyAttributes( separator, buff )
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
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"TSecGroupId",
					buff.getRequiredTSecGroupId() )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"IncludeGroupId",
					buff.getRequiredIncludeGroupId() );
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstCreate( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = "<RqstTSecGroupIncludeCreate "
			+	formatTSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstRead( String separator, CFBamTSecGroupIncludePKey pkey ) {
		String retval = "<RqstTSecGroupIncludeRead "
			+	formatTSecGroupIncludePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstRead( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = "<RqstTSecGroupIncludeRead "
			+	formatTSecGroupIncludePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstRead( String separator,
		long argTenantId,
		long argTSecGroupIncludeId )
	{
		String retval = "<RqstTSecGroupIncludeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TSecGroupIncludeId",
					argTSecGroupIncludeId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstReadAll( String separator ) {
		String retval = "<RqstTSecGroupIncludeReadAll />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstReadByIdIdx( String separator,
		long argTenantId,
		long argTSecGroupIncludeId )
	{
		String retval = "<RqstTSecGroupIncludeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TSecGroupIncludeId",
					argTSecGroupIncludeId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTSecGroupIncludeReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstReadByGroupIdx( String separator,
		long argTenantId,
		int argTSecGroupId )
	{
		String retval = "<RqstTSecGroupIncludeReadByGroupIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"TSecGroupId",
					argTSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstReadByIncludeIdx( String separator,
		long argTenantId,
		int argIncludeGroupId )
	{
		String retval = "<RqstTSecGroupIncludeReadByIncludeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"IncludeGroupId",
					argIncludeGroupId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstReadByUIncludeIdx( String separator,
		long argTenantId,
		int argTSecGroupId,
		int argIncludeGroupId )
	{
		String retval = "<RqstTSecGroupIncludeReadByUIncludeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"TSecGroupId",
					argTSecGroupId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"IncludeGroupId",
					argIncludeGroupId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstLock( String separator, CFBamTSecGroupIncludePKey pkey ) {
		String retval = "<RqstTSecGroupIncludeLock "
			+	formatTSecGroupIncludePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstLock( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = "<RqstTSecGroupIncludeLock "
			+	formatTSecGroupIncludePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstLock( String separator,
		long argTenantId,
		long argTSecGroupIncludeId )
	{
		String retval = "<RqstTSecGroupIncludeLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TSecGroupIncludeId",
					argTSecGroupIncludeId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstUpdate( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = "<RqstTSecGroupIncludeUpdate "
			+	formatTSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstDelete( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = "<RqstTSecGroupIncludeDelete "
				+	formatTSecGroupIncludePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argTSecGroupIncludeId )
	{
		String retval = "<RqstTSecGroupIncludeDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TSecGroupIncludeId",
					argTSecGroupIncludeId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTSecGroupIncludeDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstDeleteByGroupIdx( String separator,
		long argTenantId,
		int argTSecGroupId )
	{
		String retval = "<RqstTSecGroupIncludeDeleteByGroupIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"TSecGroupId",
					argTSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstDeleteByIncludeIdx( String separator,
		long argTenantId,
		int argIncludeGroupId )
	{
		String retval = "<RqstTSecGroupIncludeDeleteByIncludeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"IncludeGroupId",
					argIncludeGroupId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRqstDeleteByUIncludeIdx( String separator,
		long argTenantId,
		int argTSecGroupId,
		int argIncludeGroupId )
	{
		String retval = "<RqstTSecGroupIncludeDeleteByUIncludeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"TSecGroupId",
					argTSecGroupId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"IncludeGroupId",
					argIncludeGroupId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRspnSingleOpenTag() {
		final String retval = "<RspnTSecGroupIncludeReadSingle>";
		return( retval );
	}

	public static String formatTSecGroupIncludeRspnSingleCloseTag() {
		final String retval = "</RspnTSecGroupIncludeReadSingle>";
		return( retval );
	}

	public static String formatTSecGroupIncludeRspnListOpenTag() {
		final String retval = "<RspnTSecGroupIncludeReadList>";
		return( retval );
	}

	public static String formatTSecGroupIncludeRspnListCloseTag() {
		final String retval = "</RspnTSecGroupIncludeReadList>";
		return( retval );
	}

	public static String formatTSecGroupIncludeRspnRec( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = "<TSecGroupInclude "
			+	formatTSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRspnDerivedRec( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval;
		retval = formatTSecGroupIncludeRspnRec( separator, buff );
		return( retval );
	}

	public static String formatTSecGroupIncludeRspnCreated( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = "<RspnTSecGroupIncludeCreated "
			+	formatTSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRspnLocked( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = "<RspnTSecGroupIncludeLocked "
			+	formatTSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRspnUpdated( String separator, CFBamTSecGroupIncludeBuff buff ) {
		String retval = "<RspnTSecGroupIncludeUpdated "
			+	formatTSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupIncludeRspnDeleted() {
		String retval = "<RspnTSecGroupIncludeDeleted />";
		return( retval );
	}
}
