
// Description: Java 7 XML Message message formatter for CFBam.ClearDep

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
 *	CFBamXMsgClearDepMessageFormatter XML message formatter
 *	for CFBam.ClearDep.
 */
public class CFBamXMsgClearDepMessageFormatter
	extends CFBamXMsgScopeMessageFormatter
{
	public CFBamXMsgClearDepMessageFormatter() {
		super();
	}

	public static String formatClearDepBuffAttributes( String separator, CFBamClearDepBuff buff ) {
		String retval = CFBamXMsgScopeMessageFormatter.formatScopeBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					buff.getRequiredRelationId() );
		return( retval );
	}

	public static String formatClearDepRqstCreate( String separator, CFBamClearDepBuff buff ) {
		String retval = "<RqstClearDepCreate "
			+	formatClearDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstClearDepRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstRead( String separator, CFBamClearDepBuff buff ) {
		String retval = "<RqstClearDepRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstReadAll( String separator ) {
		String retval = "<RqstClearDepReadAll />";
		return( retval );
	}

	public static String formatClearDepRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstClearDepReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstReadByTableIdx( String separator,
		long argTenantId,
		long argRelationId )
	{
		String retval = "<RqstClearDepReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstClearDepLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstLock( String separator, CFBamClearDepBuff buff ) {
		String retval = "<RqstClearDepLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearDepLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstUpdate( String separator, CFBamClearDepBuff buff ) {
		String retval = "<RqstClearDepUpdate "
			+	formatClearDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstDelete( String separator, CFBamClearDepBuff buff ) {
		String retval = "<RqstClearDepDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatClearDepRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearDepDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstClearDepDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRqstDeleteByTableIdx( String separator,
		long argTenantId,
		long argRelationId )
	{
		String retval = "<RqstClearDepDeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRspnSingleOpenTag() {
		final String retval = "<RspnClearDepReadSingle>";
		return( retval );
	}

	public static String formatClearDepRspnSingleCloseTag() {
		final String retval = "</RspnClearDepReadSingle>";
		return( retval );
	}

	public static String formatClearDepRspnListOpenTag() {
		final String retval = "<RspnClearDepReadList>";
		return( retval );
	}

	public static String formatClearDepRspnListCloseTag() {
		final String retval = "</RspnClearDepReadList>";
		return( retval );
	}

	public static String formatClearDepRspnRec( String separator, CFBamClearDepBuff buff ) {
		String retval = "<ClearDep "
			+	formatClearDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRspnDerivedRec( String separator, CFBamClearDepBuff buff ) {
		String retval;
		final String S_ProcName = "formatClearDepRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "CLRD" ) ) {
			retval = formatClearDepRspnRec( separator, buff );
		}
		else if( classCode.equals( "CLRT" ) ) {
			retval = CFBamXMsgClearTopDepMessageFormatter.formatClearTopDepRspnRec( separator, (CFBamClearTopDepBuff)buff );
		}
		else if( classCode.equals( "CLR1" ) ) {
			retval = CFBamXMsgClearSubDep1MessageFormatter.formatClearSubDep1RspnRec( separator, (CFBamClearSubDep1Buff)buff );
		}
		else if( classCode.equals( "CLR2" ) ) {
			retval = CFBamXMsgClearSubDep2MessageFormatter.formatClearSubDep2RspnRec( separator, (CFBamClearSubDep2Buff)buff );
		}
		else if( classCode.equals( "CLR3" ) ) {
			retval = CFBamXMsgClearSubDep3MessageFormatter.formatClearSubDep3RspnRec( separator, (CFBamClearSubDep3Buff)buff );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgClearDepMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of ClearDep" );
		}
		return( retval );
	}

	public static String formatClearDepRspnCreated( String separator, CFBamClearDepBuff buff ) {
		String retval = "<RspnClearDepCreated "
			+	formatClearDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRspnLocked( String separator, CFBamClearDepBuff buff ) {
		String retval = "<RspnClearDepLocked "
			+	formatClearDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRspnUpdated( String separator, CFBamClearDepBuff buff ) {
		String retval = "<RspnClearDepUpdated "
			+	formatClearDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearDepRspnDeleted() {
		String retval = "<RspnClearDepDeleted />";
		return( retval );
	}
}
