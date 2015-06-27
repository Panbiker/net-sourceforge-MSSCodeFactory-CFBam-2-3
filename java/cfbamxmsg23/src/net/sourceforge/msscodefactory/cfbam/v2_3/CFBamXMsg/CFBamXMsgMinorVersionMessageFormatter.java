
// Description: Java 7 XML Message message formatter for CFBam.MinorVersion

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
 *	CFBamXMsgMinorVersionMessageFormatter XML message formatter
 *	for CFBam.MinorVersion.
 */
public class CFBamXMsgMinorVersionMessageFormatter
	extends CFBamXMsgVersionMessageFormatter
{
	public CFBamXMsgMinorVersionMessageFormatter() {
		super();
	}

	public static String formatMinorVersionBuffAttributes( String separator, CFBamMinorVersionBuff buff ) {
		String retval = CFBamXMsgVersionMessageFormatter.formatVersionBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"MajorId",
					buff.getRequiredMajorId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatMinorVersionRqstCreate( String separator, CFBamMinorVersionBuff buff ) {
		String retval = "<RqstMinorVersionCreate "
			+	formatMinorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstRead( String separator, CFBamDomainBasePKey pkey ) {
		String retval = "<RqstMinorVersionRead "
			+	formatDomainBasePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstRead( String separator, CFBamMinorVersionBuff buff ) {
		String retval = "<RqstMinorVersionRead "
			+	formatDomainBasePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstMinorVersionRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstReadAll( String separator ) {
		String retval = "<RqstMinorVersionReadAll />";
		return( retval );
	}

	public static String formatMinorVersionRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstMinorVersionRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstMinorVersionReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstReadByMajorIdx( String separator,
		long argTenantId,
		long argMajorId )
	{
		String retval = "<RqstMinorVersionReadByMajorIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"MajorId",
					argMajorId )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstReadByNameIdx( String separator,
		long argTenantId,
		long argMajorId,
		String argName )
	{
		String retval = "<RqstMinorVersionReadByNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"MajorId",
					argMajorId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstLock( String separator, CFBamDomainBasePKey pkey ) {
		String retval = "<RqstMinorVersionLock "
			+	formatDomainBasePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstLock( String separator, CFBamMinorVersionBuff buff ) {
		String retval = "<RqstMinorVersionLock "
			+	formatDomainBasePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstMinorVersionLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstUpdate( String separator, CFBamMinorVersionBuff buff ) {
		String retval = "<RqstMinorVersionUpdate "
			+	formatMinorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstDelete( String separator, CFBamMinorVersionBuff buff ) {
		String retval = "<RqstMinorVersionDelete "
				+	formatDomainBasePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstMinorVersionDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstMinorVersionDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstDeleteByMajorIdx( String separator,
		long argTenantId,
		long argMajorId )
	{
		String retval = "<RqstMinorVersionDeleteByMajorIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"MajorId",
					argMajorId )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRqstDeleteByNameIdx( String separator,
		long argTenantId,
		long argMajorId,
		String argName )
	{
		String retval = "<RqstMinorVersionDeleteByNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"MajorId",
					argMajorId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRspnSingleOpenTag() {
		final String retval = "<RspnMinorVersionReadSingle>";
		return( retval );
	}

	public static String formatMinorVersionRspnSingleCloseTag() {
		final String retval = "</RspnMinorVersionReadSingle>";
		return( retval );
	}

	public static String formatMinorVersionRspnListOpenTag() {
		final String retval = "<RspnMinorVersionReadList>";
		return( retval );
	}

	public static String formatMinorVersionRspnListCloseTag() {
		final String retval = "</RspnMinorVersionReadList>";
		return( retval );
	}

	public static String formatMinorVersionRspnRec( String separator, CFBamMinorVersionBuff buff ) {
		String retval = "<MinorVersion "
			+	formatMinorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRspnDerivedRec( String separator, CFBamMinorVersionBuff buff ) {
		String retval;
		retval = formatMinorVersionRspnRec( separator, buff );
		return( retval );
	}

	public static String formatMinorVersionRspnCreated( String separator, CFBamMinorVersionBuff buff ) {
		String retval = "<RspnMinorVersionCreated "
			+	formatMinorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRspnLocked( String separator, CFBamMinorVersionBuff buff ) {
		String retval = "<RspnMinorVersionLocked "
			+	formatMinorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRspnUpdated( String separator, CFBamMinorVersionBuff buff ) {
		String retval = "<RspnMinorVersionUpdated "
			+	formatMinorVersionBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatMinorVersionRspnDeleted() {
		String retval = "<RspnMinorVersionDeleted />";
		return( retval );
	}
}
