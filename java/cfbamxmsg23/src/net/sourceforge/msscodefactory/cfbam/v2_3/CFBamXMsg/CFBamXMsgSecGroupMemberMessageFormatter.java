
// Description: Java 7 XML Message message formatter for CFBam.SecGroupMember

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
 *	CFBamXMsgSecGroupMemberMessageFormatter XML message formatter
 *	for CFBam.SecGroupMember.
 */
public class CFBamXMsgSecGroupMemberMessageFormatter
{
	public CFBamXMsgSecGroupMemberMessageFormatter() {
	}

	public static String formatSecGroupMemberPKeyAttributes( String separator, CFBamSecGroupMemberPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"ClusterId",
				pkey.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"SecGroupMemberId",
				pkey.getRequiredSecGroupMemberId() );
		return( retval );
	}

	public static String formatSecGroupMemberPKeyAttributes( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"ClusterId",
					buff.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupMemberId",
					buff.getRequiredSecGroupMemberId() );
		return( retval );
	}

	public static String formatSecGroupMemberBuffAttributes( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = CFBamXMsgSecGroupMemberMessageFormatter.formatSecGroupMemberPKeyAttributes( separator, buff )
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
					"SecGroupId",
					buff.getRequiredSecGroupId() )
			+	CFLibXmlUtil.formatRequiredUuid( separator,
					"SecUserId",
					buff.getRequiredSecUserId() );
		return( retval );
	}

	public static String formatSecGroupMemberRqstCreate( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = "<RqstSecGroupMemberCreate "
			+	formatSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstRead( String separator, CFBamSecGroupMemberPKey pkey ) {
		String retval = "<RqstSecGroupMemberRead "
			+	formatSecGroupMemberPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstRead( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = "<RqstSecGroupMemberRead "
			+	formatSecGroupMemberPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstRead( String separator,
		long argClusterId,
		long argSecGroupMemberId )
	{
		String retval = "<RqstSecGroupMemberRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupMemberId",
					argSecGroupMemberId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstReadAll( String separator ) {
		String retval = "<RqstSecGroupMemberReadAll />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstReadByIdIdx( String separator,
		long argClusterId,
		long argSecGroupMemberId )
	{
		String retval = "<RqstSecGroupMemberRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupMemberId",
					argSecGroupMemberId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstReadByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstSecGroupMemberReadByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstReadByGroupIdx( String separator,
		long argClusterId,
		int argSecGroupId )
	{
		String retval = "<RqstSecGroupMemberReadByGroupIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstReadByUserIdx( String separator,
		UUID argSecUserId )
	{
		String retval = "<RqstSecGroupMemberReadByUserIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstReadByUUserIdx( String separator,
		long argClusterId,
		int argSecGroupId,
		UUID argSecUserId )
	{
		String retval = "<RqstSecGroupMemberReadByUUserIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	CFLibXmlUtil.formatRequiredUuid( separator,
					"SecUserId",
					argSecUserId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstLock( String separator, CFBamSecGroupMemberPKey pkey ) {
		String retval = "<RqstSecGroupMemberLock "
			+	formatSecGroupMemberPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstLock( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = "<RqstSecGroupMemberLock "
			+	formatSecGroupMemberPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstLock( String separator,
		long argClusterId,
		long argSecGroupMemberId )
	{
		String retval = "<RqstSecGroupMemberLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupMemberId",
					argSecGroupMemberId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstUpdate( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = "<RqstSecGroupMemberUpdate "
			+	formatSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstDelete( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = "<RqstSecGroupMemberDelete "
				+	formatSecGroupMemberPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstDeleteByIdIdx( String separator,
		long argClusterId,
		long argSecGroupMemberId )
	{
		String retval = "<RqstSecGroupMemberDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupMemberId",
					argSecGroupMemberId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstDeleteByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstSecGroupMemberDeleteByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstDeleteByGroupIdx( String separator,
		long argClusterId,
		int argSecGroupId )
	{
		String retval = "<RqstSecGroupMemberDeleteByGroupIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstDeleteByUserIdx( String separator,
		UUID argSecUserId )
	{
		String retval = "<RqstSecGroupMemberDeleteByUserIdx "
			+	CFLibXmlUtil.formatRequiredUuid( null,
					"SecUserId",
					argSecUserId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRqstDeleteByUUserIdx( String separator,
		long argClusterId,
		int argSecGroupId,
		UUID argSecUserId )
	{
		String retval = "<RqstSecGroupMemberDeleteByUUserIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	CFLibXmlUtil.formatRequiredUuid( separator,
					"SecUserId",
					argSecUserId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRspnSingleOpenTag() {
		final String retval = "<RspnSecGroupMemberReadSingle>";
		return( retval );
	}

	public static String formatSecGroupMemberRspnSingleCloseTag() {
		final String retval = "</RspnSecGroupMemberReadSingle>";
		return( retval );
	}

	public static String formatSecGroupMemberRspnListOpenTag() {
		final String retval = "<RspnSecGroupMemberReadList>";
		return( retval );
	}

	public static String formatSecGroupMemberRspnListCloseTag() {
		final String retval = "</RspnSecGroupMemberReadList>";
		return( retval );
	}

	public static String formatSecGroupMemberRspnRec( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = "<SecGroupMember "
			+	formatSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRspnDerivedRec( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval;
		retval = formatSecGroupMemberRspnRec( separator, buff );
		return( retval );
	}

	public static String formatSecGroupMemberRspnCreated( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = "<RspnSecGroupMemberCreated "
			+	formatSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRspnLocked( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = "<RspnSecGroupMemberLocked "
			+	formatSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRspnUpdated( String separator, CFBamSecGroupMemberBuff buff ) {
		String retval = "<RspnSecGroupMemberUpdated "
			+	formatSecGroupMemberBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupMemberRspnDeleted() {
		String retval = "<RspnSecGroupMemberDeleted />";
		return( retval );
	}
}
