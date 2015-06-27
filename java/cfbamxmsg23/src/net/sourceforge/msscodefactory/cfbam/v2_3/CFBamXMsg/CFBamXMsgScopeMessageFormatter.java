
// Description: Java 7 XML Message message formatter for CFBam.Scope

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
 *	CFBamXMsgScopeMessageFormatter XML message formatter
 *	for CFBam.Scope.
 */
public class CFBamXMsgScopeMessageFormatter
{
	public CFBamXMsgScopeMessageFormatter() {
	}

	public static String formatScopePKeyAttributes( String separator, CFBamScopePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatScopePKeyAttributes( String separator, CFBamScopeBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatScopeBuffAttributes( String separator, CFBamScopeBuff buff ) {
		String retval = CFBamXMsgScopeMessageFormatter.formatScopePKeyAttributes( separator, buff )
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
					buff.getUpdatedAt() );
		return( retval );
	}

	public static String formatScopeRqstCreate( String separator, CFBamScopeBuff buff ) {
		String retval = "<RqstScopeCreate "
			+	formatScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstScopeRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstRead( String separator, CFBamScopeBuff buff ) {
		String retval = "<RqstScopeRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstScopeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstReadAll( String separator ) {
		String retval = "<RqstScopeReadAll />";
		return( retval );
	}

	public static String formatScopeRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstScopeRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstScopeReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstScopeLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstLock( String separator, CFBamScopeBuff buff ) {
		String retval = "<RqstScopeLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstScopeLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstUpdate( String separator, CFBamScopeBuff buff ) {
		String retval = "<RqstScopeUpdate "
			+	formatScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstDelete( String separator, CFBamScopeBuff buff ) {
		String retval = "<RqstScopeDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatScopeRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstScopeDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatScopeRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstScopeDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatScopeRspnSingleOpenTag() {
		final String retval = "<RspnScopeReadSingle>";
		return( retval );
	}

	public static String formatScopeRspnSingleCloseTag() {
		final String retval = "</RspnScopeReadSingle>";
		return( retval );
	}

	public static String formatScopeRspnListOpenTag() {
		final String retval = "<RspnScopeReadList>";
		return( retval );
	}

	public static String formatScopeRspnListCloseTag() {
		final String retval = "</RspnScopeReadList>";
		return( retval );
	}

	public static String formatScopeRspnRec( String separator, CFBamScopeBuff buff ) {
		String retval = "<Scope "
			+	formatScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatScopeRspnDerivedRec( String separator, CFBamScopeBuff buff ) {
		String retval;
		final String S_ProcName = "formatScopeRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "SCOP" ) ) {
			retval = formatScopeRspnRec( separator, buff );
		}
		else if( classCode.equals( "SCHM" ) ) {
			retval = CFBamXMsgSchemaDefMessageFormatter.formatSchemaDefRspnRec( separator, (CFBamSchemaDefBuff)buff );
		}
		else if( classCode.equals( "SCRF" ) ) {
			retval = CFBamXMsgSchemaRefMessageFormatter.formatSchemaRefRspnRec( separator, (CFBamSchemaRefBuff)buff );
		}
		else if( classCode.equals( "TBLD" ) ) {
			retval = CFBamXMsgTableMessageFormatter.formatTableRspnRec( separator, (CFBamTableBuff)buff );
		}
		else if( classCode.equals( "DELD" ) ) {
			retval = CFBamXMsgDelDepMessageFormatter.formatDelDepRspnRec( separator, (CFBamDelDepBuff)buff );
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
		else if( classCode.equals( "IDXD" ) ) {
			retval = CFBamXMsgIndexMessageFormatter.formatIndexRspnRec( separator, (CFBamIndexBuff)buff );
		}
		else if( classCode.equals( "RELD" ) ) {
			retval = CFBamXMsgRelationMessageFormatter.formatRelationRspnRec( separator, (CFBamRelationBuff)buff );
		}
		else if( classCode.equals( "SRVM" ) ) {
			retval = CFBamXMsgServerMethodMessageFormatter.formatServerMethodRspnRec( separator, (CFBamServerMethodBuff)buff );
		}
		else if( classCode.equals( "SRVP" ) ) {
			retval = CFBamXMsgServerProcMessageFormatter.formatServerProcRspnRec( separator, (CFBamServerProcBuff)buff );
		}
		else if( classCode.equals( "SRVO" ) ) {
			retval = CFBamXMsgServerObjFuncMessageFormatter.formatServerObjFuncRspnRec( separator, (CFBamServerObjFuncBuff)buff );
		}
		else if( classCode.equals( "SRVL" ) ) {
			retval = CFBamXMsgServerListFuncMessageFormatter.formatServerListFuncRspnRec( separator, (CFBamServerListFuncBuff)buff );
		}
		else if( classCode.equals( "POPD" ) ) {
			retval = CFBamXMsgPopDepMessageFormatter.formatPopDepRspnRec( separator, (CFBamPopDepBuff)buff );
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
		else if( classCode.equals( "CLRD" ) ) {
			retval = CFBamXMsgClearDepMessageFormatter.formatClearDepRspnRec( separator, (CFBamClearDepBuff)buff );
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
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgScopeMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of Scope" );
		}
		return( retval );
	}

	public static String formatScopeRspnCreated( String separator, CFBamScopeBuff buff ) {
		String retval = "<RspnScopeCreated "
			+	formatScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatScopeRspnLocked( String separator, CFBamScopeBuff buff ) {
		String retval = "<RspnScopeLocked "
			+	formatScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatScopeRspnUpdated( String separator, CFBamScopeBuff buff ) {
		String retval = "<RspnScopeUpdated "
			+	formatScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatScopeRspnDeleted() {
		String retval = "<RspnScopeDeleted />";
		return( retval );
	}
}
