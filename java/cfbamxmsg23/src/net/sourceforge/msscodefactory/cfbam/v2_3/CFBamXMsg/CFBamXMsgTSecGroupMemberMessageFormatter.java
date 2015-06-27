
// Description: Java 7 XML Message message formatter for CFBam.TSecGroupMember

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
 *	CFBamXMsgTSecGroupMemberMessageFormatter XML message formatter
 *	for CFBam.TSecGroupMember.
 */
public class CFBamXMsgTSecGroupMemberMessageFormatter
{
	public CFBamXMsgTSecGroupMemberMessageFormatter() {
	}

	public static String formatTSecGroupMemberPKeyAttributes( String separator, CFBamTSecGroupMemberPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"TSecGroupMemberId",
				pkey.getRequiredTSecGroupMemberId() );
		return( retval );
	}

	public static String formatTSecGroupMemberPKeyAttributes( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TSecGroupMemberId",
					buff.getRequiredTSecGroupMemberId() );
		return( retval );
	}

	public static String formatTSecGroupMemberBuffAttributes( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = CFBamXMsgTSecGroupMemberMessageFormatter.formatTSecGroupMemberPKeyAttributes( separator, buff )
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
			+	CFLibXmlUtil.formatRequiredUuid( separator,
					"SecUserId",
					buff.getRequiredSecUserId() );
		return( retval );
	}

	public static String formatTSecGroupMemberRqstCreate( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = "<RqstTSecGroupMemberCreate "
			+	formatTSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstRead( String separator, CFBamTSecGroupMemberPKey pkey ) {
		String retval = "<RqstTSecGroupMemberRead "
			+	formatTSecGroupMemberPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstRead( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = "<RqstTSecGroupMemberRead "
			+	formatTSecGroupMemberPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstRead( String separator,
		long argTenantId,
		long argTSecGroupMemberId )
	{
		String retval = "<RqstTSecGroupMemberRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TSecGroupMemberId",
					argTSecGroupMemberId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstReadAll( String separator ) {
		String retval = "<RqstTSecGroupMemberReadAll />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstReadByIdIdx( String separator,
		long argTenantId,
		long argTSecGroupMemberId )
	{
		String retval = "<RqstTSecGroupMemberRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TSecGroupMemberId",
					argTSecGroupMemberId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTSecGroupMemberReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstReadByGroupIdx( String separator,
		long argTenantId,
		int argTSecGroupId )
	{
		String retval = "<RqstTSecGroupMemberReadByGroupIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"TSecGroupId",
					argTSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstReadByUserIdx( String separator,
		UUID argSecUserId )
	{
		String retval = "<RqstTSecGroupMemberReadByUserIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstReadByUUserIdx( String separator,
		long argTenantId,
		int argTSecGroupId,
		UUID argSecUserId )
	{
		String retval = "<RqstTSecGroupMemberReadByUUserIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"TSecGroupId",
					argTSecGroupId )
			+	CFLibXmlUtil.formatRequiredUuid( separator,
					"SecUserId",
					argSecUserId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstLock( String separator, CFBamTSecGroupMemberPKey pkey ) {
		String retval = "<RqstTSecGroupMemberLock "
			+	formatTSecGroupMemberPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstLock( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = "<RqstTSecGroupMemberLock "
			+	formatTSecGroupMemberPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstLock( String separator,
		long argTenantId,
		long argTSecGroupMemberId )
	{
		String retval = "<RqstTSecGroupMemberLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TSecGroupMemberId",
					argTSecGroupMemberId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstUpdate( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = "<RqstTSecGroupMemberUpdate "
			+	formatTSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstDelete( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = "<RqstTSecGroupMemberDelete "
				+	formatTSecGroupMemberPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argTSecGroupMemberId )
	{
		String retval = "<RqstTSecGroupMemberDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TSecGroupMemberId",
					argTSecGroupMemberId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTSecGroupMemberDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstDeleteByGroupIdx( String separator,
		long argTenantId,
		int argTSecGroupId )
	{
		String retval = "<RqstTSecGroupMemberDeleteByGroupIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"TSecGroupId",
					argTSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstDeleteByUserIdx( String separator,
		UUID argSecUserId )
	{
		String retval = "<RqstTSecGroupMemberDeleteByUserIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRqstDeleteByUUserIdx( String separator,
		long argTenantId,
		int argTSecGroupId,
		UUID argSecUserId )
	{
		String retval = "<RqstTSecGroupMemberDeleteByUUserIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"TSecGroupId",
					argTSecGroupId )
			+	CFLibXmlUtil.formatRequiredUuid( separator,
					"SecUserId",
					argSecUserId )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRspnSingleOpenTag() {
		final String retval = "<RspnTSecGroupMemberReadSingle>";
		return( retval );
	}

	public static String formatTSecGroupMemberRspnSingleCloseTag() {
		final String retval = "</RspnTSecGroupMemberReadSingle>";
		return( retval );
	}

	public static String formatTSecGroupMemberRspnListOpenTag() {
		final String retval = "<RspnTSecGroupMemberReadList>";
		return( retval );
	}

	public static String formatTSecGroupMemberRspnListCloseTag() {
		final String retval = "</RspnTSecGroupMemberReadList>";
		return( retval );
	}

	public static String formatTSecGroupMemberRspnRec( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = "<TSecGroupMember "
			+	formatTSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRspnDerivedRec( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval;
		retval = formatTSecGroupMemberRspnRec( separator, buff );
		return( retval );
	}

	public static String formatTSecGroupMemberRspnCreated( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = "<RspnTSecGroupMemberCreated "
			+	formatTSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRspnLocked( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = "<RspnTSecGroupMemberLocked "
			+	formatTSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRspnUpdated( String separator, CFBamTSecGroupMemberBuff buff ) {
		String retval = "<RspnTSecGroupMemberUpdated "
			+	formatTSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTSecGroupMemberRspnDeleted() {
		String retval = "<RspnTSecGroupMemberDeleted />";
		return( retval );
	}
}
