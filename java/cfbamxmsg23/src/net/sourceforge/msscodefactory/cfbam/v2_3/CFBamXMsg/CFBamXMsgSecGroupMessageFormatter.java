
// Description: Java 7 XML Message message formatter for CFBam.SecGroup

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
 *	CFBamXMsgSecGroupMessageFormatter XML message formatter
 *	for CFBam.SecGroup.
 */
public class CFBamXMsgSecGroupMessageFormatter
{
	public CFBamXMsgSecGroupMessageFormatter() {
	}

	public static String formatSecGroupPKeyAttributes( String separator, CFBamSecGroupPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"ClusterId",
				pkey.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
				"SecGroupId",
				pkey.getRequiredSecGroupId() );
		return( retval );
	}

	public static String formatSecGroupPKeyAttributes( String separator, CFBamSecGroupBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"ClusterId",
					buff.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					buff.getRequiredSecGroupId() );
		return( retval );
	}

	public static String formatSecGroupBuffAttributes( String separator, CFBamSecGroupBuff buff ) {
		String retval = CFBamXMsgSecGroupMessageFormatter.formatSecGroupPKeyAttributes( separator, buff )
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
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatSecGroupRqstCreate( String separator, CFBamSecGroupBuff buff ) {
		String retval = "<RqstSecGroupCreate "
			+	formatSecGroupBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstRead( String separator, CFBamSecGroupPKey pkey ) {
		String retval = "<RqstSecGroupRead "
			+	formatSecGroupPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstRead( String separator, CFBamSecGroupBuff buff ) {
		String retval = "<RqstSecGroupRead "
			+	formatSecGroupPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstRead( String separator,
		long argClusterId,
		int argSecGroupId )
	{
		String retval = "<RqstSecGroupRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstReadAll( String separator ) {
		String retval = "<RqstSecGroupReadAll />";
		return( retval );
	}

	public static String formatSecGroupRqstReadByIdIdx( String separator,
		long argClusterId,
		int argSecGroupId )
	{
		String retval = "<RqstSecGroupRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstReadByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstSecGroupReadByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstReadByUNameIdx( String separator,
		long argClusterId,
		String argName )
	{
		String retval = "<RqstSecGroupReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstLock( String separator, CFBamSecGroupPKey pkey ) {
		String retval = "<RqstSecGroupLock "
			+	formatSecGroupPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstLock( String separator, CFBamSecGroupBuff buff ) {
		String retval = "<RqstSecGroupLock "
			+	formatSecGroupPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstLock( String separator,
		long argClusterId,
		int argSecGroupId )
	{
		String retval = "<RqstSecGroupLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstUpdate( String separator, CFBamSecGroupBuff buff ) {
		String retval = "<RqstSecGroupUpdate "
			+	formatSecGroupBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstDelete( String separator, CFBamSecGroupBuff buff ) {
		String retval = "<RqstSecGroupDelete "
				+	formatSecGroupPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstDeleteByIdIdx( String separator,
		long argClusterId,
		int argSecGroupId )
	{
		String retval = "<RqstSecGroupDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstDeleteByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstSecGroupDeleteByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRqstDeleteByUNameIdx( String separator,
		long argClusterId,
		String argName )
	{
		String retval = "<RqstSecGroupDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRspnSingleOpenTag() {
		final String retval = "<RspnSecGroupReadSingle>";
		return( retval );
	}

	public static String formatSecGroupRspnSingleCloseTag() {
		final String retval = "</RspnSecGroupReadSingle>";
		return( retval );
	}

	public static String formatSecGroupRspnListOpenTag() {
		final String retval = "<RspnSecGroupReadList>";
		return( retval );
	}

	public static String formatSecGroupRspnListCloseTag() {
		final String retval = "</RspnSecGroupReadList>";
		return( retval );
	}

	public static String formatSecGroupRspnRec( String separator, CFBamSecGroupBuff buff ) {
		String retval = "<SecGroup "
			+	formatSecGroupBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRspnDerivedRec( String separator, CFBamSecGroupBuff buff ) {
		String retval;
		retval = formatSecGroupRspnRec( separator, buff );
		return( retval );
	}

	public static String formatSecGroupRspnCreated( String separator, CFBamSecGroupBuff buff ) {
		String retval = "<RspnSecGroupCreated "
			+	formatSecGroupBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRspnLocked( String separator, CFBamSecGroupBuff buff ) {
		String retval = "<RspnSecGroupLocked "
			+	formatSecGroupBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRspnUpdated( String separator, CFBamSecGroupBuff buff ) {
		String retval = "<RspnSecGroupUpdated "
			+	formatSecGroupBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupRspnDeleted() {
		String retval = "<RspnSecGroupDeleted />";
		return( retval );
	}
}
