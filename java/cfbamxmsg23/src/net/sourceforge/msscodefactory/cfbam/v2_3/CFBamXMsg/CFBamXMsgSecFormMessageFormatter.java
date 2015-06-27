
// Description: Java 7 XML Message message formatter for CFBam.SecForm

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
 *	CFBamXMsgSecFormMessageFormatter XML message formatter
 *	for CFBam.SecForm.
 */
public class CFBamXMsgSecFormMessageFormatter
{
	public CFBamXMsgSecFormMessageFormatter() {
	}

	public static String formatSecFormPKeyAttributes( String separator, CFBamSecFormPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"ClusterId",
				pkey.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
				"SecFormId",
				pkey.getRequiredSecFormId() );
		return( retval );
	}

	public static String formatSecFormPKeyAttributes( String separator, CFBamSecFormBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"ClusterId",
					buff.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecFormId",
					buff.getRequiredSecFormId() );
		return( retval );
	}

	public static String formatSecFormBuffAttributes( String separator, CFBamSecFormBuff buff ) {
		String retval = CFBamXMsgSecFormMessageFormatter.formatSecFormPKeyAttributes( separator, buff )
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
					"SecAppId",
					buff.getRequiredSecAppId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"JEEServletMapName",
					buff.getRequiredJEEServletMapName() );
		return( retval );
	}

	public static String formatSecFormRqstCreate( String separator, CFBamSecFormBuff buff ) {
		String retval = "<RqstSecFormCreate "
			+	formatSecFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstRead( String separator, CFBamSecFormPKey pkey ) {
		String retval = "<RqstSecFormRead "
			+	formatSecFormPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstRead( String separator, CFBamSecFormBuff buff ) {
		String retval = "<RqstSecFormRead "
			+	formatSecFormPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstRead( String separator,
		long argClusterId,
		int argSecFormId )
	{
		String retval = "<RqstSecFormRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecFormId",
					argSecFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstReadAll( String separator ) {
		String retval = "<RqstSecFormReadAll />";
		return( retval );
	}

	public static String formatSecFormRqstReadByIdIdx( String separator,
		long argClusterId,
		int argSecFormId )
	{
		String retval = "<RqstSecFormRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecFormId",
					argSecFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstReadByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstSecFormReadByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstReadBySecAppIdx( String separator,
		long argClusterId,
		int argSecAppId )
	{
		String retval = "<RqstSecFormReadBySecAppIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecAppId",
					argSecAppId )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstReadByUJEEServletIdx( String separator,
		long argClusterId,
		int argSecAppId,
		String argJEEServletMapName )
	{
		String retval = "<RqstSecFormReadByUJEEServletIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecAppId",
					argSecAppId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"JEEServletMapName",
					argJEEServletMapName )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstLock( String separator, CFBamSecFormPKey pkey ) {
		String retval = "<RqstSecFormLock "
			+	formatSecFormPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstLock( String separator, CFBamSecFormBuff buff ) {
		String retval = "<RqstSecFormLock "
			+	formatSecFormPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstLock( String separator,
		long argClusterId,
		int argSecFormId )
	{
		String retval = "<RqstSecFormLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecFormId",
					argSecFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstUpdate( String separator, CFBamSecFormBuff buff ) {
		String retval = "<RqstSecFormUpdate "
			+	formatSecFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstDelete( String separator, CFBamSecFormBuff buff ) {
		String retval = "<RqstSecFormDelete "
				+	formatSecFormPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatSecFormRqstDeleteByIdIdx( String separator,
		long argClusterId,
		int argSecFormId )
	{
		String retval = "<RqstSecFormDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecFormId",
					argSecFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstDeleteByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstSecFormDeleteByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstDeleteBySecAppIdx( String separator,
		long argClusterId,
		int argSecAppId )
	{
		String retval = "<RqstSecFormDeleteBySecAppIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecAppId",
					argSecAppId )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRqstDeleteByUJEEServletIdx( String separator,
		long argClusterId,
		int argSecAppId,
		String argJEEServletMapName )
	{
		String retval = "<RqstSecFormDeleteByUJEEServletIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecAppId",
					argSecAppId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"JEEServletMapName",
					argJEEServletMapName )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRspnSingleOpenTag() {
		final String retval = "<RspnSecFormReadSingle>";
		return( retval );
	}

	public static String formatSecFormRspnSingleCloseTag() {
		final String retval = "</RspnSecFormReadSingle>";
		return( retval );
	}

	public static String formatSecFormRspnListOpenTag() {
		final String retval = "<RspnSecFormReadList>";
		return( retval );
	}

	public static String formatSecFormRspnListCloseTag() {
		final String retval = "</RspnSecFormReadList>";
		return( retval );
	}

	public static String formatSecFormRspnRec( String separator, CFBamSecFormBuff buff ) {
		String retval = "<SecForm "
			+	formatSecFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRspnDerivedRec( String separator, CFBamSecFormBuff buff ) {
		String retval;
		retval = formatSecFormRspnRec( separator, buff );
		return( retval );
	}

	public static String formatSecFormRspnCreated( String separator, CFBamSecFormBuff buff ) {
		String retval = "<RspnSecFormCreated "
			+	formatSecFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRspnLocked( String separator, CFBamSecFormBuff buff ) {
		String retval = "<RspnSecFormLocked "
			+	formatSecFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRspnUpdated( String separator, CFBamSecFormBuff buff ) {
		String retval = "<RspnSecFormUpdated "
			+	formatSecFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecFormRspnDeleted() {
		String retval = "<RspnSecFormDeleted />";
		return( retval );
	}
}
