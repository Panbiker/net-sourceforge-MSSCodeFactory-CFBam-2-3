
// Description: Java 7 XML Message message formatter for CFBam.DelDep

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
 *	CFBamXMsgDelDepMessageFormatter XML message formatter
 *	for CFBam.DelDep.
 */
public class CFBamXMsgDelDepMessageFormatter
	extends CFBamXMsgScopeMessageFormatter
{
	public CFBamXMsgDelDepMessageFormatter() {
		super();
	}

	public static String formatDelDepBuffAttributes( String separator, CFBamDelDepBuff buff ) {
		String retval = CFBamXMsgScopeMessageFormatter.formatScopeBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaTenantId",
					buff.getOptionalDefSchemaTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					buff.getOptionalDefSchemaId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationTenantId",
					buff.getRequiredRelationTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					buff.getRequiredRelationId() );
		return( retval );
	}

	public static String formatDelDepRqstCreate( String separator, CFBamDelDepBuff buff ) {
		String retval = "<RqstDelDepCreate "
			+	formatDelDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstDelDepRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstRead( String separator, CFBamDelDepBuff buff ) {
		String retval = "<RqstDelDepRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstReadAll( String separator ) {
		String retval = "<RqstDelDepReadAll />";
		return( retval );
	}

	public static String formatDelDepRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDelDepReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstDelDepReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstReadByTableIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstDelDepReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstDelDepLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstLock( String separator, CFBamDelDepBuff buff ) {
		String retval = "<RqstDelDepLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelDepLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstUpdate( String separator, CFBamDelDepBuff buff ) {
		String retval = "<RqstDelDepUpdate "
			+	formatDelDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstDelete( String separator, CFBamDelDepBuff buff ) {
		String retval = "<RqstDelDepDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatDelDepRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelDepDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDelDepDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstDelDepDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRqstDeleteByTableIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstDelDepDeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRspnSingleOpenTag() {
		final String retval = "<RspnDelDepReadSingle>";
		return( retval );
	}

	public static String formatDelDepRspnSingleCloseTag() {
		final String retval = "</RspnDelDepReadSingle>";
		return( retval );
	}

	public static String formatDelDepRspnListOpenTag() {
		final String retval = "<RspnDelDepReadList>";
		return( retval );
	}

	public static String formatDelDepRspnListCloseTag() {
		final String retval = "</RspnDelDepReadList>";
		return( retval );
	}

	public static String formatDelDepRspnRec( String separator, CFBamDelDepBuff buff ) {
		String retval = "<DelDep "
			+	formatDelDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRspnDerivedRec( String separator, CFBamDelDepBuff buff ) {
		String retval;
		final String S_ProcName = "formatDelDepRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "DELD" ) ) {
			retval = formatDelDepRspnRec( separator, buff );
		}
		else if( classCode.equals( "DELT" ) ) {
			retval = CFBamXMsgDelTopDepMessageFormatter.formatDelTopDepRspnRec( separator, (CFBamDelTopDepBuff)buff );
		}
		else if( classCode.equals( "DEL1" ) ) {
			retval = CFBamXMsgDelSubDep1MessageFormatter.formatDelSubDep1RspnRec( separator, (CFBamDelSubDep1Buff)buff );
		}
		else if( classCode.equals( "DEL2" ) ) {
			retval = CFBamXMsgDelSubDep2MessageFormatter.formatDelSubDep2RspnRec( separator, (CFBamDelSubDep2Buff)buff );
		}
		else if( classCode.equals( "DEL3" ) ) {
			retval = CFBamXMsgDelSubDep3MessageFormatter.formatDelSubDep3RspnRec( separator, (CFBamDelSubDep3Buff)buff );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgDelDepMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of DelDep" );
		}
		return( retval );
	}

	public static String formatDelDepRspnCreated( String separator, CFBamDelDepBuff buff ) {
		String retval = "<RspnDelDepCreated "
			+	formatDelDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRspnLocked( String separator, CFBamDelDepBuff buff ) {
		String retval = "<RspnDelDepLocked "
			+	formatDelDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRspnUpdated( String separator, CFBamDelDepBuff buff ) {
		String retval = "<RspnDelDepUpdated "
			+	formatDelDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelDepRspnDeleted() {
		String retval = "<RspnDelDepDeleted />";
		return( retval );
	}
}
