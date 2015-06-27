
// Description: Java 7 XML Message message formatter for CFBam.SecGroupInclude

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
 *	CFBamXMsgSecGroupIncludeMessageFormatter XML message formatter
 *	for CFBam.SecGroupInclude.
 */
public class CFBamXMsgSecGroupIncludeMessageFormatter
{
	public CFBamXMsgSecGroupIncludeMessageFormatter() {
	}

	public static String formatSecGroupIncludePKeyAttributes( String separator, CFBamSecGroupIncludePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"ClusterId",
				pkey.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"SecGroupIncludeId",
				pkey.getRequiredSecGroupIncludeId() );
		return( retval );
	}

	public static String formatSecGroupIncludePKeyAttributes( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"ClusterId",
					buff.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupIncludeId",
					buff.getRequiredSecGroupIncludeId() );
		return( retval );
	}

	public static String formatSecGroupIncludeBuffAttributes( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = CFBamXMsgSecGroupIncludeMessageFormatter.formatSecGroupIncludePKeyAttributes( separator, buff )
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
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"IncludeGroupId",
					buff.getRequiredIncludeGroupId() );
		return( retval );
	}

	public static String formatSecGroupIncludeRqstCreate( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = "<RqstSecGroupIncludeCreate "
			+	formatSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstRead( String separator, CFBamSecGroupIncludePKey pkey ) {
		String retval = "<RqstSecGroupIncludeRead "
			+	formatSecGroupIncludePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstRead( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = "<RqstSecGroupIncludeRead "
			+	formatSecGroupIncludePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstRead( String separator,
		long argClusterId,
		long argSecGroupIncludeId )
	{
		String retval = "<RqstSecGroupIncludeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupIncludeId",
					argSecGroupIncludeId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstReadAll( String separator ) {
		String retval = "<RqstSecGroupIncludeReadAll />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstReadByIdIdx( String separator,
		long argClusterId,
		long argSecGroupIncludeId )
	{
		String retval = "<RqstSecGroupIncludeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupIncludeId",
					argSecGroupIncludeId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstReadByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstSecGroupIncludeReadByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstReadByGroupIdx( String separator,
		long argClusterId,
		int argSecGroupId )
	{
		String retval = "<RqstSecGroupIncludeReadByGroupIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstReadByIncludeIdx( String separator,
		long argClusterId,
		int argIncludeGroupId )
	{
		String retval = "<RqstSecGroupIncludeReadByIncludeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"IncludeGroupId",
					argIncludeGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstReadByUIncludeIdx( String separator,
		long argClusterId,
		int argSecGroupId,
		int argIncludeGroupId )
	{
		String retval = "<RqstSecGroupIncludeReadByUIncludeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"IncludeGroupId",
					argIncludeGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstLock( String separator, CFBamSecGroupIncludePKey pkey ) {
		String retval = "<RqstSecGroupIncludeLock "
			+	formatSecGroupIncludePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstLock( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = "<RqstSecGroupIncludeLock "
			+	formatSecGroupIncludePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstLock( String separator,
		long argClusterId,
		long argSecGroupIncludeId )
	{
		String retval = "<RqstSecGroupIncludeLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupIncludeId",
					argSecGroupIncludeId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstUpdate( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = "<RqstSecGroupIncludeUpdate "
			+	formatSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstDelete( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = "<RqstSecGroupIncludeDelete "
				+	formatSecGroupIncludePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstDeleteByIdIdx( String separator,
		long argClusterId,
		long argSecGroupIncludeId )
	{
		String retval = "<RqstSecGroupIncludeDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupIncludeId",
					argSecGroupIncludeId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstDeleteByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstSecGroupIncludeDeleteByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstDeleteByGroupIdx( String separator,
		long argClusterId,
		int argSecGroupId )
	{
		String retval = "<RqstSecGroupIncludeDeleteByGroupIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstDeleteByIncludeIdx( String separator,
		long argClusterId,
		int argIncludeGroupId )
	{
		String retval = "<RqstSecGroupIncludeDeleteByIncludeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"IncludeGroupId",
					argIncludeGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRqstDeleteByUIncludeIdx( String separator,
		long argClusterId,
		int argSecGroupId,
		int argIncludeGroupId )
	{
		String retval = "<RqstSecGroupIncludeDeleteByUIncludeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"IncludeGroupId",
					argIncludeGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRspnSingleOpenTag() {
		final String retval = "<RspnSecGroupIncludeReadSingle>";
		return( retval );
	}

	public static String formatSecGroupIncludeRspnSingleCloseTag() {
		final String retval = "</RspnSecGroupIncludeReadSingle>";
		return( retval );
	}

	public static String formatSecGroupIncludeRspnListOpenTag() {
		final String retval = "<RspnSecGroupIncludeReadList>";
		return( retval );
	}

	public static String formatSecGroupIncludeRspnListCloseTag() {
		final String retval = "</RspnSecGroupIncludeReadList>";
		return( retval );
	}

	public static String formatSecGroupIncludeRspnRec( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = "<SecGroupInclude "
			+	formatSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRspnDerivedRec( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval;
		retval = formatSecGroupIncludeRspnRec( separator, buff );
		return( retval );
	}

	public static String formatSecGroupIncludeRspnCreated( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = "<RspnSecGroupIncludeCreated "
			+	formatSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRspnLocked( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = "<RspnSecGroupIncludeLocked "
			+	formatSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRspnUpdated( String separator, CFBamSecGroupIncludeBuff buff ) {
		String retval = "<RspnSecGroupIncludeUpdated "
			+	formatSecGroupIncludeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupIncludeRspnDeleted() {
		String retval = "<RspnSecGroupIncludeDeleted />";
		return( retval );
	}
}
