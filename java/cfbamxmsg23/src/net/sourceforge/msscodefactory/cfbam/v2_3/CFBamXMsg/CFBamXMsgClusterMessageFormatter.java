
// Description: Java 7 XML Message message formatter for CFBam.Cluster

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
 *	CFBamXMsgClusterMessageFormatter XML message formatter
 *	for CFBam.Cluster.
 */
public class CFBamXMsgClusterMessageFormatter
{
	public CFBamXMsgClusterMessageFormatter() {
	}

	public static String formatClusterPKeyAttributes( String separator, CFBamClusterPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatClusterPKeyAttributes( String separator, CFBamClusterBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatClusterBuffAttributes( String separator, CFBamClusterBuff buff ) {
		String retval = CFBamXMsgClusterMessageFormatter.formatClusterPKeyAttributes( separator, buff )
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
					"FullDomainName",
					buff.getRequiredFullDomainName() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Description",
					buff.getRequiredDescription() );
		return( retval );
	}

	public static String formatClusterRqstCreate( String separator, CFBamClusterBuff buff ) {
		String retval = "<RqstClusterCreate "
			+	formatClusterBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstRead( String separator, CFBamClusterPKey pkey ) {
		String retval = "<RqstClusterRead "
			+	formatClusterPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstRead( String separator, CFBamClusterBuff buff ) {
		String retval = "<RqstClusterRead "
			+	formatClusterPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstRead( String separator,
		long argId )
	{
		String retval = "<RqstClusterRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstReadAll( String separator ) {
		String retval = "<RqstClusterReadAll />";
		return( retval );
	}

	public static String formatClusterRqstReadByIdIdx( String separator,
		long argId )
	{
		String retval = "<RqstClusterRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstReadByUDomainNameIdx( String separator,
		String argFullDomainName )
	{
		String retval = "<RqstClusterReadByUDomainNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"FullDomainName",
					argFullDomainName )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstReadByUDescrIdx( String separator,
		String argDescription )
	{
		String retval = "<RqstClusterReadByUDescrIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Description",
					argDescription )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstLock( String separator, CFBamClusterPKey pkey ) {
		String retval = "<RqstClusterLock "
			+	formatClusterPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstLock( String separator, CFBamClusterBuff buff ) {
		String retval = "<RqstClusterLock "
			+	formatClusterPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstLock( String separator,
		long argId )
	{
		String retval = "<RqstClusterLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstUpdate( String separator, CFBamClusterBuff buff ) {
		String retval = "<RqstClusterUpdate "
			+	formatClusterBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstDelete( String separator, CFBamClusterBuff buff ) {
		String retval = "<RqstClusterDelete "
				+	formatClusterPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatClusterRqstDeleteByIdIdx( String separator,
		long argId )
	{
		String retval = "<RqstClusterDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstDeleteByUDomainNameIdx( String separator,
		String argFullDomainName )
	{
		String retval = "<RqstClusterDeleteByUDomainNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"FullDomainName",
					argFullDomainName )
			+	" />";
		return( retval );
	}

	public static String formatClusterRqstDeleteByUDescrIdx( String separator,
		String argDescription )
	{
		String retval = "<RqstClusterDeleteByUDescrIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Description",
					argDescription )
			+	" />";
		return( retval );
	}

	public static String formatClusterRspnSingleOpenTag() {
		final String retval = "<RspnClusterReadSingle>";
		return( retval );
	}

	public static String formatClusterRspnSingleCloseTag() {
		final String retval = "</RspnClusterReadSingle>";
		return( retval );
	}

	public static String formatClusterRspnListOpenTag() {
		final String retval = "<RspnClusterReadList>";
		return( retval );
	}

	public static String formatClusterRspnListCloseTag() {
		final String retval = "</RspnClusterReadList>";
		return( retval );
	}

	public static String formatClusterRspnRec( String separator, CFBamClusterBuff buff ) {
		String retval = "<Cluster "
			+	formatClusterBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClusterRspnDerivedRec( String separator, CFBamClusterBuff buff ) {
		String retval;
		retval = formatClusterRspnRec( separator, buff );
		return( retval );
	}

	public static String formatClusterRspnCreated( String separator, CFBamClusterBuff buff ) {
		String retval = "<RspnClusterCreated "
			+	formatClusterBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClusterRspnLocked( String separator, CFBamClusterBuff buff ) {
		String retval = "<RspnClusterLocked "
			+	formatClusterBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClusterRspnUpdated( String separator, CFBamClusterBuff buff ) {
		String retval = "<RspnClusterUpdated "
			+	formatClusterBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClusterRspnDeleted() {
		String retval = "<RspnClusterDeleted />";
		return( retval );
	}
}
