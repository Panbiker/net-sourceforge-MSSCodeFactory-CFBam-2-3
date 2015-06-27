
// Description: Java 7 XML Message message formatter for CFBam.SecGroupForm

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
 *	CFBamXMsgSecGroupFormMessageFormatter XML message formatter
 *	for CFBam.SecGroupForm.
 */
public class CFBamXMsgSecGroupFormMessageFormatter
{
	public CFBamXMsgSecGroupFormMessageFormatter() {
	}

	public static String formatSecGroupFormPKeyAttributes( String separator, CFBamSecGroupFormPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"ClusterId",
				pkey.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"SecGroupFormId",
				pkey.getRequiredSecGroupFormId() );
		return( retval );
	}

	public static String formatSecGroupFormPKeyAttributes( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"ClusterId",
					buff.getRequiredClusterId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupFormId",
					buff.getRequiredSecGroupFormId() );
		return( retval );
	}

	public static String formatSecGroupFormBuffAttributes( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormPKeyAttributes( separator, buff )
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
					"SecAppId",
					buff.getRequiredSecAppId() )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecFormId",
					buff.getRequiredSecFormId() );
		return( retval );
	}

	public static String formatSecGroupFormRqstCreate( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = "<RqstSecGroupFormCreate "
			+	formatSecGroupFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstRead( String separator, CFBamSecGroupFormPKey pkey ) {
		String retval = "<RqstSecGroupFormRead "
			+	formatSecGroupFormPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstRead( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = "<RqstSecGroupFormRead "
			+	formatSecGroupFormPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstRead( String separator,
		long argClusterId,
		long argSecGroupFormId )
	{
		String retval = "<RqstSecGroupFormRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupFormId",
					argSecGroupFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstReadAll( String separator ) {
		String retval = "<RqstSecGroupFormReadAll />";
		return( retval );
	}

	public static String formatSecGroupFormRqstReadByIdIdx( String separator,
		long argClusterId,
		long argSecGroupFormId )
	{
		String retval = "<RqstSecGroupFormRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupFormId",
					argSecGroupFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstReadByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstSecGroupFormReadByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstReadByGroupIdx( String separator,
		long argClusterId,
		int argSecGroupId )
	{
		String retval = "<RqstSecGroupFormReadByGroupIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstReadByAppIdx( String separator,
		long argClusterId,
		int argSecAppId )
	{
		String retval = "<RqstSecGroupFormReadByAppIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecAppId",
					argSecAppId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstReadByFormIdx( String separator,
		long argClusterId,
		int argSecFormId )
	{
		String retval = "<RqstSecGroupFormReadByFormIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecFormId",
					argSecFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstReadByUFormIdx( String separator,
		long argClusterId,
		int argSecGroupId,
		int argSecFormId )
	{
		String retval = "<RqstSecGroupFormReadByUFormIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecFormId",
					argSecFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstLock( String separator, CFBamSecGroupFormPKey pkey ) {
		String retval = "<RqstSecGroupFormLock "
			+	formatSecGroupFormPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstLock( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = "<RqstSecGroupFormLock "
			+	formatSecGroupFormPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstLock( String separator,
		long argClusterId,
		long argSecGroupFormId )
	{
		String retval = "<RqstSecGroupFormLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupFormId",
					argSecGroupFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstUpdate( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = "<RqstSecGroupFormUpdate "
			+	formatSecGroupFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstDelete( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = "<RqstSecGroupFormDelete "
				+	formatSecGroupFormPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstDeleteByIdIdx( String separator,
		long argClusterId,
		long argSecGroupFormId )
	{
		String retval = "<RqstSecGroupFormDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SecGroupFormId",
					argSecGroupFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstDeleteByClusterIdx( String separator,
		long argClusterId )
	{
		String retval = "<RqstSecGroupFormDeleteByClusterIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstDeleteByGroupIdx( String separator,
		long argClusterId,
		int argSecGroupId )
	{
		String retval = "<RqstSecGroupFormDeleteByGroupIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstDeleteByAppIdx( String separator,
		long argClusterId,
		int argSecAppId )
	{
		String retval = "<RqstSecGroupFormDeleteByAppIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecAppId",
					argSecAppId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstDeleteByFormIdx( String separator,
		long argClusterId,
		int argSecFormId )
	{
		String retval = "<RqstSecGroupFormDeleteByFormIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecFormId",
					argSecFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRqstDeleteByUFormIdx( String separator,
		long argClusterId,
		int argSecGroupId,
		int argSecFormId )
	{
		String retval = "<RqstSecGroupFormDeleteByUFormIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ClusterId",
					argClusterId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecGroupId",
					argSecGroupId )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"SecFormId",
					argSecFormId )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRspnSingleOpenTag() {
		final String retval = "<RspnSecGroupFormReadSingle>";
		return( retval );
	}

	public static String formatSecGroupFormRspnSingleCloseTag() {
		final String retval = "</RspnSecGroupFormReadSingle>";
		return( retval );
	}

	public static String formatSecGroupFormRspnListOpenTag() {
		final String retval = "<RspnSecGroupFormReadList>";
		return( retval );
	}

	public static String formatSecGroupFormRspnListCloseTag() {
		final String retval = "</RspnSecGroupFormReadList>";
		return( retval );
	}

	public static String formatSecGroupFormRspnRec( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = "<SecGroupForm "
			+	formatSecGroupFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRspnDerivedRec( String separator, CFBamSecGroupFormBuff buff ) {
		String retval;
		retval = formatSecGroupFormRspnRec( separator, buff );
		return( retval );
	}

	public static String formatSecGroupFormRspnCreated( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = "<RspnSecGroupFormCreated "
			+	formatSecGroupFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRspnLocked( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = "<RspnSecGroupFormLocked "
			+	formatSecGroupFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRspnUpdated( String separator, CFBamSecGroupFormBuff buff ) {
		String retval = "<RspnSecGroupFormUpdated "
			+	formatSecGroupFormBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecGroupFormRspnDeleted() {
		String retval = "<RspnSecGroupFormDeleted />";
		return( retval );
	}
}
