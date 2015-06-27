
// Description: Java 7 XML Message message formatter for CFBam.PopDep

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
 *	CFBamXMsgPopDepMessageFormatter XML message formatter
 *	for CFBam.PopDep.
 */
public class CFBamXMsgPopDepMessageFormatter
	extends CFBamXMsgScopeMessageFormatter
{
	public CFBamXMsgPopDepMessageFormatter() {
		super();
	}

	public static String formatPopDepBuffAttributes( String separator, CFBamPopDepBuff buff ) {
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

	public static String formatPopDepRqstCreate( String separator, CFBamPopDepBuff buff ) {
		String retval = "<RqstPopDepCreate "
			+	formatPopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstPopDepRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstRead( String separator, CFBamPopDepBuff buff ) {
		String retval = "<RqstPopDepRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstReadAll( String separator ) {
		String retval = "<RqstPopDepReadAll />";
		return( retval );
	}

	public static String formatPopDepRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstPopDepReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstReadByRelationIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstPopDepReadByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstPopDepReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstPopDepLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstLock( String separator, CFBamPopDepBuff buff ) {
		String retval = "<RqstPopDepLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopDepLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstUpdate( String separator, CFBamPopDepBuff buff ) {
		String retval = "<RqstPopDepUpdate "
			+	formatPopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstDelete( String separator, CFBamPopDepBuff buff ) {
		String retval = "<RqstPopDepDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatPopDepRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopDepDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstPopDepDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstDeleteByRelationIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstPopDepDeleteByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstPopDepDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRspnSingleOpenTag() {
		final String retval = "<RspnPopDepReadSingle>";
		return( retval );
	}

	public static String formatPopDepRspnSingleCloseTag() {
		final String retval = "</RspnPopDepReadSingle>";
		return( retval );
	}

	public static String formatPopDepRspnListOpenTag() {
		final String retval = "<RspnPopDepReadList>";
		return( retval );
	}

	public static String formatPopDepRspnListCloseTag() {
		final String retval = "</RspnPopDepReadList>";
		return( retval );
	}

	public static String formatPopDepRspnRec( String separator, CFBamPopDepBuff buff ) {
		String retval = "<PopDep "
			+	formatPopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRspnDerivedRec( String separator, CFBamPopDepBuff buff ) {
		String retval;
		final String S_ProcName = "formatPopDepRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "POPD" ) ) {
			retval = formatPopDepRspnRec( separator, buff );
		}
		else if( classCode.equals( "POPT" ) ) {
			retval = CFBamXMsgPopTopDepMessageFormatter.formatPopTopDepRspnRec( separator, (CFBamPopTopDepBuff)buff );
		}
		else if( classCode.equals( "POP1" ) ) {
			retval = CFBamXMsgPopSubDep1MessageFormatter.formatPopSubDep1RspnRec( separator, (CFBamPopSubDep1Buff)buff );
		}
		else if( classCode.equals( "POP2" ) ) {
			retval = CFBamXMsgPopSubDep2MessageFormatter.formatPopSubDep2RspnRec( separator, (CFBamPopSubDep2Buff)buff );
		}
		else if( classCode.equals( "POP3" ) ) {
			retval = CFBamXMsgPopSubDep3MessageFormatter.formatPopSubDep3RspnRec( separator, (CFBamPopSubDep3Buff)buff );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgPopDepMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of PopDep" );
		}
		return( retval );
	}

	public static String formatPopDepRspnCreated( String separator, CFBamPopDepBuff buff ) {
		String retval = "<RspnPopDepCreated "
			+	formatPopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRspnLocked( String separator, CFBamPopDepBuff buff ) {
		String retval = "<RspnPopDepLocked "
			+	formatPopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRspnUpdated( String separator, CFBamPopDepBuff buff ) {
		String retval = "<RspnPopDepUpdated "
			+	formatPopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopDepRspnDeleted() {
		String retval = "<RspnPopDepDeleted />";
		return( retval );
	}
}
