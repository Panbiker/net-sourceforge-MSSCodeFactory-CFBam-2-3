
// Description: Java 7 XML Message message formatter for CFBam.License

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
 *	CFBamXMsgLicenseMessageFormatter XML message formatter
 *	for CFBam.License.
 */
public class CFBamXMsgLicenseMessageFormatter
{
	public CFBamXMsgLicenseMessageFormatter() {
	}

	public static String formatLicensePKeyAttributes( String separator, CFBamLicensePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatLicensePKeyAttributes( String separator, CFBamLicenseBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatLicenseBuffAttributes( String separator, CFBamLicenseBuff buff ) {
		String retval = CFBamXMsgLicenseMessageFormatter.formatLicensePKeyAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"Revision",
					buff.getRequiredRevision() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					buff.getRequiredDomainId() )
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
					"EmbeddedText",
					buff.getOptionalEmbeddedText() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"FullText",
					buff.getOptionalFullText() );
		return( retval );
	}

	public static String formatLicenseRqstCreate( String separator, CFBamLicenseBuff buff ) {
		String retval = "<RqstLicenseCreate "
			+	formatLicenseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstRead( String separator, CFBamLicensePKey pkey ) {
		String retval = "<RqstLicenseRead "
			+	formatLicensePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstRead( String separator, CFBamLicenseBuff buff ) {
		String retval = "<RqstLicenseRead "
			+	formatLicensePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstLicenseRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstReadAll( String separator ) {
		String retval = "<RqstLicenseReadAll />";
		return( retval );
	}

	public static String formatLicenseRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstLicenseRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstReadByLicnTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstLicenseReadByLicnTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstReadByDomainIdx( String separator,
		long argTenantId,
		long argDomainId )
	{
		String retval = "<RqstLicenseReadByDomainIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argDomainId,
		String argName )
	{
		String retval = "<RqstLicenseReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstLock( String separator, CFBamLicensePKey pkey ) {
		String retval = "<RqstLicenseLock "
			+	formatLicensePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstLock( String separator, CFBamLicenseBuff buff ) {
		String retval = "<RqstLicenseLock "
			+	formatLicensePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstLicenseLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstUpdate( String separator, CFBamLicenseBuff buff ) {
		String retval = "<RqstLicenseUpdate "
			+	formatLicenseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstDelete( String separator, CFBamLicenseBuff buff ) {
		String retval = "<RqstLicenseDelete "
				+	formatLicensePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatLicenseRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstLicenseDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstDeleteByLicnTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstLicenseDeleteByLicnTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstDeleteByDomainIdx( String separator,
		long argTenantId,
		long argDomainId )
	{
		String retval = "<RqstLicenseDeleteByDomainIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argDomainId,
		String argName )
	{
		String retval = "<RqstLicenseDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRspnSingleOpenTag() {
		final String retval = "<RspnLicenseReadSingle>";
		return( retval );
	}

	public static String formatLicenseRspnSingleCloseTag() {
		final String retval = "</RspnLicenseReadSingle>";
		return( retval );
	}

	public static String formatLicenseRspnListOpenTag() {
		final String retval = "<RspnLicenseReadList>";
		return( retval );
	}

	public static String formatLicenseRspnListCloseTag() {
		final String retval = "</RspnLicenseReadList>";
		return( retval );
	}

	public static String formatLicenseRspnRec( String separator, CFBamLicenseBuff buff ) {
		String retval = "<License "
			+	formatLicenseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRspnDerivedRec( String separator, CFBamLicenseBuff buff ) {
		String retval;
		retval = formatLicenseRspnRec( separator, buff );
		return( retval );
	}

	public static String formatLicenseRspnCreated( String separator, CFBamLicenseBuff buff ) {
		String retval = "<RspnLicenseCreated "
			+	formatLicenseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRspnLocked( String separator, CFBamLicenseBuff buff ) {
		String retval = "<RspnLicenseLocked "
			+	formatLicenseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRspnUpdated( String separator, CFBamLicenseBuff buff ) {
		String retval = "<RspnLicenseUpdated "
			+	formatLicenseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatLicenseRspnDeleted() {
		String retval = "<RspnLicenseDeleted />";
		return( retval );
	}
}
