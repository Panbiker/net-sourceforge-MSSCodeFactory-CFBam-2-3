
// Description: Java 7 XML Message message formatter for CFBam.DomainBase

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
 *	CFBamXMsgDomainBaseMessageFormatter XML message formatter
 *	for CFBam.DomainBase.
 */
public class CFBamXMsgDomainBaseMessageFormatter
{
	public CFBamXMsgDomainBaseMessageFormatter() {
	}

	public static String formatDomainBasePKeyAttributes( String separator, CFBamDomainBasePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatDomainBasePKeyAttributes( String separator, CFBamDomainBaseBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatDomainBaseBuffAttributes( String separator, CFBamDomainBaseBuff buff ) {
		String retval = CFBamXMsgDomainBaseMessageFormatter.formatDomainBasePKeyAttributes( separator, buff )
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
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"Description",
					buff.getOptionalDescription() );
		return( retval );
	}

	public static String formatDomainBaseRqstCreate( String separator, CFBamDomainBaseBuff buff ) {
		String retval = "<RqstDomainBaseCreate "
			+	formatDomainBaseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstRead( String separator, CFBamDomainBasePKey pkey ) {
		String retval = "<RqstDomainBaseRead "
			+	formatDomainBasePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstRead( String separator, CFBamDomainBaseBuff buff ) {
		String retval = "<RqstDomainBaseRead "
			+	formatDomainBasePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDomainBaseRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstReadAll( String separator ) {
		String retval = "<RqstDomainBaseReadAll />";
		return( retval );
	}

	public static String formatDomainBaseRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDomainBaseRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDomainBaseReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstLock( String separator, CFBamDomainBasePKey pkey ) {
		String retval = "<RqstDomainBaseLock "
			+	formatDomainBasePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstLock( String separator, CFBamDomainBaseBuff buff ) {
		String retval = "<RqstDomainBaseLock "
			+	formatDomainBasePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDomainBaseLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstUpdate( String separator, CFBamDomainBaseBuff buff ) {
		String retval = "<RqstDomainBaseUpdate "
			+	formatDomainBaseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstDelete( String separator, CFBamDomainBaseBuff buff ) {
		String retval = "<RqstDomainBaseDelete "
				+	formatDomainBasePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDomainBaseDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDomainBaseDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRspnSingleOpenTag() {
		final String retval = "<RspnDomainBaseReadSingle>";
		return( retval );
	}

	public static String formatDomainBaseRspnSingleCloseTag() {
		final String retval = "</RspnDomainBaseReadSingle>";
		return( retval );
	}

	public static String formatDomainBaseRspnListOpenTag() {
		final String retval = "<RspnDomainBaseReadList>";
		return( retval );
	}

	public static String formatDomainBaseRspnListCloseTag() {
		final String retval = "</RspnDomainBaseReadList>";
		return( retval );
	}

	public static String formatDomainBaseRspnRec( String separator, CFBamDomainBaseBuff buff ) {
		String retval = "<DomainBase "
			+	formatDomainBaseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRspnDerivedRec( String separator, CFBamDomainBaseBuff buff ) {
		String retval;
		final String S_ProcName = "formatDomainBaseRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "BDOM" ) ) {
			retval = formatDomainBaseRspnRec( separator, buff );
		}
		else if( classCode.equals( "TDOM" ) ) {
			retval = CFBamXMsgTopDomainMessageFormatter.formatTopDomainRspnRec( separator, (CFBamTopDomainBuff)buff );
		}
		else if( classCode.equals( "DOMN" ) ) {
			retval = CFBamXMsgDomainMessageFormatter.formatDomainRspnRec( separator, (CFBamDomainBuff)buff );
		}
		else if( classCode.equals( "BPRJ" ) ) {
			retval = CFBamXMsgProjectBaseMessageFormatter.formatProjectBaseRspnRec( separator, (CFBamProjectBaseBuff)buff );
		}
		else if( classCode.equals( "RPRJ" ) ) {
			retval = CFBamXMsgRealProjectMessageFormatter.formatRealProjectRspnRec( separator, (CFBamRealProjectBuff)buff );
		}
		else if( classCode.equals( "TPRJ" ) ) {
			retval = CFBamXMsgTopProjectMessageFormatter.formatTopProjectRspnRec( separator, (CFBamTopProjectBuff)buff );
		}
		else if( classCode.equals( "SPRJ" ) ) {
			retval = CFBamXMsgSubProjectMessageFormatter.formatSubProjectRspnRec( separator, (CFBamSubProjectBuff)buff );
		}
		else if( classCode.equals( "VERN" ) ) {
			retval = CFBamXMsgVersionMessageFormatter.formatVersionRspnRec( separator, (CFBamVersionBuff)buff );
		}
		else if( classCode.equals( "MJVR" ) ) {
			retval = CFBamXMsgMajorVersionMessageFormatter.formatMajorVersionRspnRec( separator, (CFBamMajorVersionBuff)buff );
		}
		else if( classCode.equals( "MNVR" ) ) {
			retval = CFBamXMsgMinorVersionMessageFormatter.formatMinorVersionRspnRec( separator, (CFBamMinorVersionBuff)buff );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgDomainBaseMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of DomainBase" );
		}
		return( retval );
	}

	public static String formatDomainBaseRspnCreated( String separator, CFBamDomainBaseBuff buff ) {
		String retval = "<RspnDomainBaseCreated "
			+	formatDomainBaseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRspnLocked( String separator, CFBamDomainBaseBuff buff ) {
		String retval = "<RspnDomainBaseLocked "
			+	formatDomainBaseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRspnUpdated( String separator, CFBamDomainBaseBuff buff ) {
		String retval = "<RspnDomainBaseUpdated "
			+	formatDomainBaseBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDomainBaseRspnDeleted() {
		String retval = "<RspnDomainBaseDeleted />";
		return( retval );
	}
}
