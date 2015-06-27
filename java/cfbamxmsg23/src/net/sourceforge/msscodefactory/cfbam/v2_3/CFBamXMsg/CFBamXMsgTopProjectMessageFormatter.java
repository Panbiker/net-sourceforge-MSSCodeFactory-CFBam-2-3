
// Description: Java 7 XML Message message formatter for CFBam.TopProject

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
 *	CFBamXMsgTopProjectMessageFormatter XML message formatter
 *	for CFBam.TopProject.
 */
public class CFBamXMsgTopProjectMessageFormatter
	extends CFBamXMsgRealProjectMessageFormatter
{
	public CFBamXMsgTopProjectMessageFormatter() {
		super();
	}

	public static String formatTopProjectBuffAttributes( String separator, CFBamTopProjectBuff buff ) {
		String retval = CFBamXMsgRealProjectMessageFormatter.formatRealProjectBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					buff.getRequiredDomainId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatTopProjectRqstCreate( String separator, CFBamTopProjectBuff buff ) {
		String retval = "<RqstTopProjectCreate "
			+	formatTopProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstRead( String separator, CFBamDomainBasePKey pkey ) {
		String retval = "<RqstTopProjectRead "
			+	formatDomainBasePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstRead( String separator, CFBamTopProjectBuff buff ) {
		String retval = "<RqstTopProjectRead "
			+	formatDomainBasePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTopProjectRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstReadAll( String separator ) {
		String retval = "<RqstTopProjectReadAll />";
		return( retval );
	}

	public static String formatTopProjectRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTopProjectRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTopProjectReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstReadByDomainIdx( String separator,
		long argTenantId,
		long argDomainId )
	{
		String retval = "<RqstTopProjectReadByDomainIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstReadByNameIdx( String separator,
		long argTenantId,
		long argDomainId,
		String argName )
	{
		String retval = "<RqstTopProjectReadByNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstLock( String separator, CFBamDomainBasePKey pkey ) {
		String retval = "<RqstTopProjectLock "
			+	formatDomainBasePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstLock( String separator, CFBamTopProjectBuff buff ) {
		String retval = "<RqstTopProjectLock "
			+	formatDomainBasePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTopProjectLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstUpdate( String separator, CFBamTopProjectBuff buff ) {
		String retval = "<RqstTopProjectUpdate "
			+	formatTopProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstDelete( String separator, CFBamTopProjectBuff buff ) {
		String retval = "<RqstTopProjectDelete "
				+	formatDomainBasePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTopProjectDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTopProjectDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstDeleteByDomainIdx( String separator,
		long argTenantId,
		long argDomainId )
	{
		String retval = "<RqstTopProjectDeleteByDomainIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRqstDeleteByNameIdx( String separator,
		long argTenantId,
		long argDomainId,
		String argName )
	{
		String retval = "<RqstTopProjectDeleteByNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRspnSingleOpenTag() {
		final String retval = "<RspnTopProjectReadSingle>";
		return( retval );
	}

	public static String formatTopProjectRspnSingleCloseTag() {
		final String retval = "</RspnTopProjectReadSingle>";
		return( retval );
	}

	public static String formatTopProjectRspnListOpenTag() {
		final String retval = "<RspnTopProjectReadList>";
		return( retval );
	}

	public static String formatTopProjectRspnListCloseTag() {
		final String retval = "</RspnTopProjectReadList>";
		return( retval );
	}

	public static String formatTopProjectRspnRec( String separator, CFBamTopProjectBuff buff ) {
		String retval = "<TopProject "
			+	formatTopProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRspnDerivedRec( String separator, CFBamTopProjectBuff buff ) {
		String retval;
		retval = formatTopProjectRspnRec( separator, buff );
		return( retval );
	}

	public static String formatTopProjectRspnCreated( String separator, CFBamTopProjectBuff buff ) {
		String retval = "<RspnTopProjectCreated "
			+	formatTopProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRspnLocked( String separator, CFBamTopProjectBuff buff ) {
		String retval = "<RspnTopProjectLocked "
			+	formatTopProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRspnUpdated( String separator, CFBamTopProjectBuff buff ) {
		String retval = "<RspnTopProjectUpdated "
			+	formatTopProjectBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTopProjectRspnDeleted() {
		String retval = "<RspnTopProjectDeleted />";
		return( retval );
	}
}
