
// Description: Java 7 XML Message message formatter for CFBam.MajorVersion

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
 *	CFBamXMsgMajorVersionMessageFormatter XML message formatter
 *	for CFBam.MajorVersion.
 */
public class CFBamXMsgMajorVersionMessageFormatter
	extends CFBamXMsgVersionMessageFormatter
{
	public CFBamXMsgMajorVersionMessageFormatter() {
		super();
	}

	public static String formatMajorVersionBuffAttributes( String separator, CFBamMajorVersionBuff buff ) {
		String retval = CFBamXMsgVersionMessageFormatter.formatVersionBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ParentProjectId",
					buff.getRequiredParentProjectId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatMajorVersionRqstCreate( String separator, CFBamMajorVersionBuff buff ) {
		String retval = "<RqstMajorVersionCreate "
			+	formatMajorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstRead( String separator, CFBamDomainBasePKey pkey ) {
		String retval = "<RqstMajorVersionRead "
			+	formatDomainBasePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstRead( String separator, CFBamMajorVersionBuff buff ) {
		String retval = "<RqstMajorVersionRead "
			+	formatDomainBasePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstMajorVersionRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstReadAll( String separator ) {
		String retval = "<RqstMajorVersionReadAll />";
		return( retval );
	}

	public static String formatMajorVersionRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstMajorVersionRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstMajorVersionReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstReadByPPrjIdx( String separator,
		long argTenantId,
		long argParentProjectId )
	{
		String retval = "<RqstMajorVersionReadByPPrjIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ParentProjectId",
					argParentProjectId )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstReadByNameIdx( String separator,
		long argTenantId,
		long argParentProjectId,
		String argName )
	{
		String retval = "<RqstMajorVersionReadByNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ParentProjectId",
					argParentProjectId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstLock( String separator, CFBamDomainBasePKey pkey ) {
		String retval = "<RqstMajorVersionLock "
			+	formatDomainBasePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstLock( String separator, CFBamMajorVersionBuff buff ) {
		String retval = "<RqstMajorVersionLock "
			+	formatDomainBasePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstMajorVersionLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstUpdate( String separator, CFBamMajorVersionBuff buff ) {
		String retval = "<RqstMajorVersionUpdate "
			+	formatMajorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstDelete( String separator, CFBamMajorVersionBuff buff ) {
		String retval = "<RqstMajorVersionDelete "
				+	formatDomainBasePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstMajorVersionDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstMajorVersionDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstDeleteByPPrjIdx( String separator,
		long argTenantId,
		long argParentProjectId )
	{
		String retval = "<RqstMajorVersionDeleteByPPrjIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ParentProjectId",
					argParentProjectId )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRqstDeleteByNameIdx( String separator,
		long argTenantId,
		long argParentProjectId,
		String argName )
	{
		String retval = "<RqstMajorVersionDeleteByNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ParentProjectId",
					argParentProjectId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRspnSingleOpenTag() {
		final String retval = "<RspnMajorVersionReadSingle>";
		return( retval );
	}

	public static String formatMajorVersionRspnSingleCloseTag() {
		final String retval = "</RspnMajorVersionReadSingle>";
		return( retval );
	}

	public static String formatMajorVersionRspnListOpenTag() {
		final String retval = "<RspnMajorVersionReadList>";
		return( retval );
	}

	public static String formatMajorVersionRspnListCloseTag() {
		final String retval = "</RspnMajorVersionReadList>";
		return( retval );
	}

	public static String formatMajorVersionRspnRec( String separator, CFBamMajorVersionBuff buff ) {
		String retval = "<MajorVersion "
			+	formatMajorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRspnDerivedRec( String separator, CFBamMajorVersionBuff buff ) {
		String retval;
		retval = formatMajorVersionRspnRec( separator, buff );
		return( retval );
	}

	public static String formatMajorVersionRspnCreated( String separator, CFBamMajorVersionBuff buff ) {
		String retval = "<RspnMajorVersionCreated "
			+	formatMajorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRspnLocked( String separator, CFBamMajorVersionBuff buff ) {
		String retval = "<RspnMajorVersionLocked "
			+	formatMajorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRspnUpdated( String separator, CFBamMajorVersionBuff buff ) {
		String retval = "<RspnMajorVersionUpdated "
			+	formatMajorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMajorVersionRspnDeleted() {
		String retval = "<RspnMajorVersionDeleted />";
		return( retval );
	}
}
