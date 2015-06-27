
// Description: Java 7 XML Message message formatter for CFBam.Tld

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
 *	CFBamXMsgTldMessageFormatter XML message formatter
 *	for CFBam.Tld.
 */
public class CFBamXMsgTldMessageFormatter
{
	public CFBamXMsgTldMessageFormatter() {
	}

	public static String formatTldPKeyAttributes( String separator, CFBamTldPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"TldId",
				pkey.getRequiredTldId() );
		return( retval );
	}

	public static String formatTldPKeyAttributes( String separator, CFBamTldBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TldId",
					buff.getRequiredTldId() );
		return( retval );
	}

	public static String formatTldBuffAttributes( String separator, CFBamTldBuff buff ) {
		String retval = CFBamXMsgTldMessageFormatter.formatTldPKeyAttributes( separator, buff )
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

	public static String formatTldRqstCreate( String separator, CFBamTldBuff buff ) {
		String retval = "<RqstTldCreate "
			+	formatTldBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstRead( String separator, CFBamTldPKey pkey ) {
		String retval = "<RqstTldRead "
			+	formatTldPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstRead( String separator, CFBamTldBuff buff ) {
		String retval = "<RqstTldRead "
			+	formatTldPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstRead( String separator,
		long argTenantId,
		long argTldId )
	{
		String retval = "<RqstTldRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TldId",
					argTldId )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstReadAll( String separator ) {
		String retval = "<RqstTldReadAll />";
		return( retval );
	}

	public static String formatTldRqstReadByIdIdx( String separator,
		long argTenantId,
		long argTldId )
	{
		String retval = "<RqstTldRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TldId",
					argTldId )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTldReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstReadByNameIdx( String separator,
		long argTenantId,
		String argName )
	{
		String retval = "<RqstTldReadByNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstLock( String separator, CFBamTldPKey pkey ) {
		String retval = "<RqstTldLock "
			+	formatTldPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstLock( String separator, CFBamTldBuff buff ) {
		String retval = "<RqstTldLock "
			+	formatTldPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstLock( String separator,
		long argTenantId,
		long argTldId )
	{
		String retval = "<RqstTldLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TldId",
					argTldId )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstUpdate( String separator, CFBamTldBuff buff ) {
		String retval = "<RqstTldUpdate "
			+	formatTldBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstDelete( String separator, CFBamTldBuff buff ) {
		String retval = "<RqstTldDelete "
				+	formatTldPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatTldRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argTldId )
	{
		String retval = "<RqstTldDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TldId",
					argTldId )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTldDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTldRqstDeleteByNameIdx( String separator,
		long argTenantId,
		String argName )
	{
		String retval = "<RqstTldDeleteByNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatTldRspnSingleOpenTag() {
		final String retval = "<RspnTldReadSingle>";
		return( retval );
	}

	public static String formatTldRspnSingleCloseTag() {
		final String retval = "</RspnTldReadSingle>";
		return( retval );
	}

	public static String formatTldRspnListOpenTag() {
		final String retval = "<RspnTldReadList>";
		return( retval );
	}

	public static String formatTldRspnListCloseTag() {
		final String retval = "</RspnTldReadList>";
		return( retval );
	}

	public static String formatTldRspnRec( String separator, CFBamTldBuff buff ) {
		String retval = "<Tld "
			+	formatTldBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTldRspnDerivedRec( String separator, CFBamTldBuff buff ) {
		String retval;
		retval = formatTldRspnRec( separator, buff );
		return( retval );
	}

	public static String formatTldRspnCreated( String separator, CFBamTldBuff buff ) {
		String retval = "<RspnTldCreated "
			+	formatTldBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTldRspnLocked( String separator, CFBamTldBuff buff ) {
		String retval = "<RspnTldLocked "
			+	formatTldBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTldRspnUpdated( String separator, CFBamTldBuff buff ) {
		String retval = "<RspnTldUpdated "
			+	formatTldBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTldRspnDeleted() {
		String retval = "<RspnTldDeleted />";
		return( retval );
	}
}
