
// Description: Java 7 XML Message message formatter for CFBam.RealProject

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
 *	CFBamXMsgRealProjectMessageFormatter XML message formatter
 *	for CFBam.RealProject.
 */
public class CFBamXMsgRealProjectMessageFormatter
	extends CFBamXMsgProjectBaseMessageFormatter
{
	public CFBamXMsgRealProjectMessageFormatter() {
		super();
	}

	public static String formatRealProjectBuffAttributes( String separator, CFBamRealProjectBuff buff ) {
		String retval = CFBamXMsgProjectBaseMessageFormatter.formatProjectBaseBuffAttributes( separator, buff );
		return( retval );
	}

	public static String formatRealProjectRqstCreate( String separator, CFBamRealProjectBuff buff ) {
		String retval = "<RqstRealProjectCreate "
			+	formatRealProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstRead( String separator, CFBamDomainBasePKey pkey ) {
		String retval = "<RqstRealProjectRead "
			+	formatDomainBasePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstRead( String separator, CFBamRealProjectBuff buff ) {
		String retval = "<RqstRealProjectRead "
			+	formatDomainBasePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRealProjectRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstReadAll( String separator ) {
		String retval = "<RqstRealProjectReadAll />";
		return( retval );
	}

	public static String formatRealProjectRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRealProjectRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstRealProjectReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstLock( String separator, CFBamDomainBasePKey pkey ) {
		String retval = "<RqstRealProjectLock "
			+	formatDomainBasePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstLock( String separator, CFBamRealProjectBuff buff ) {
		String retval = "<RqstRealProjectLock "
			+	formatDomainBasePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRealProjectLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstUpdate( String separator, CFBamRealProjectBuff buff ) {
		String retval = "<RqstRealProjectUpdate "
			+	formatRealProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstDelete( String separator, CFBamRealProjectBuff buff ) {
		String retval = "<RqstRealProjectDelete "
				+	formatDomainBasePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRealProjectDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstRealProjectDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRspnSingleOpenTag() {
		final String retval = "<RspnRealProjectReadSingle>";
		return( retval );
	}

	public static String formatRealProjectRspnSingleCloseTag() {
		final String retval = "</RspnRealProjectReadSingle>";
		return( retval );
	}

	public static String formatRealProjectRspnListOpenTag() {
		final String retval = "<RspnRealProjectReadList>";
		return( retval );
	}

	public static String formatRealProjectRspnListCloseTag() {
		final String retval = "</RspnRealProjectReadList>";
		return( retval );
	}

	public static String formatRealProjectRspnRec( String separator, CFBamRealProjectBuff buff ) {
		String retval = "<RealProject "
			+	formatRealProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRspnDerivedRec( String separator, CFBamRealProjectBuff buff ) {
		String retval;
		final String S_ProcName = "formatRealProjectRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "RPRJ" ) ) {
			retval = formatRealProjectRspnRec( separator, buff );
		}
		else if( classCode.equals( "TPRJ" ) ) {
			retval = CFBamXMsgTopProjectMessageFormatter.formatTopProjectRspnRec( separator, (CFBamTopProjectBuff)buff );
		}
		else if( classCode.equals( "SPRJ" ) ) {
			retval = CFBamXMsgSubProjectMessageFormatter.formatSubProjectRspnRec( separator, (CFBamSubProjectBuff)buff );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgRealProjectMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of RealProject" );
		}
		return( retval );
	}

	public static String formatRealProjectRspnCreated( String separator, CFBamRealProjectBuff buff ) {
		String retval = "<RspnRealProjectCreated "
			+	formatRealProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRspnLocked( String separator, CFBamRealProjectBuff buff ) {
		String retval = "<RspnRealProjectLocked "
			+	formatRealProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRspnUpdated( String separator, CFBamRealProjectBuff buff ) {
		String retval = "<RspnRealProjectUpdated "
			+	formatRealProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRealProjectRspnDeleted() {
		String retval = "<RspnRealProjectDeleted />";
		return( retval );
	}
}
