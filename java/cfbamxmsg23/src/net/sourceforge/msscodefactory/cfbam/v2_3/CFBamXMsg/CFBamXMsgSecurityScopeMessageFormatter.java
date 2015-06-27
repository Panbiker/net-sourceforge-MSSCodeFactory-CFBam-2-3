
// Description: Java 7 XML Message message formatter for CFBam.SecurityScope

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
 *	CFBamXMsgSecurityScopeMessageFormatter XML message formatter
 *	for CFBam.SecurityScope.
 */
public class CFBamXMsgSecurityScopeMessageFormatter
{
	public CFBamXMsgSecurityScopeMessageFormatter() {
	}

	public static String formatSecurityScopePKeyAttributes( String separator, CFBamSecurityScopePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( null,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatSecurityScopePKeyAttributes( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatSecurityScopeBuffAttributes( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = CFBamXMsgSecurityScopeMessageFormatter.formatSecurityScopePKeyAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"Revision",
					buff.getRequiredRevision() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatSecurityScopeRqstCreate( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = "<RqstSecurityScopeCreate "
			+	formatSecurityScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstRead( String separator, CFBamSecurityScopePKey pkey ) {
		String retval = "<RqstSecurityScopeRead "
			+	formatSecurityScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstRead( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = "<RqstSecurityScopeRead "
			+	formatSecurityScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstRead( String separator,
		short argId )
	{
		String retval = "<RqstSecurityScopeRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstReadAll( String separator ) {
		String retval = "<RqstSecurityScopeReadAll />";
		return( retval );
	}

	public static String formatSecurityScopeRqstReadByIdIdx( String separator,
		short argId )
	{
		String retval = "<RqstSecurityScopeRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstReadByUNameIdx( String separator,
		String argName )
	{
		String retval = "<RqstSecurityScopeReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstLock( String separator, CFBamSecurityScopePKey pkey ) {
		String retval = "<RqstSecurityScopeLock "
			+	formatSecurityScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstLock( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = "<RqstSecurityScopeLock "
			+	formatSecurityScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstLock( String separator,
		short argId )
	{
		String retval = "<RqstSecurityScopeLock "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstUpdate( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = "<RqstSecurityScopeUpdate "
			+	formatSecurityScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstDelete( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = "<RqstSecurityScopeDelete "
				+	formatSecurityScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstDeleteByIdIdx( String separator,
		short argId )
	{
		String retval = "<RqstSecurityScopeDelete "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRqstDeleteByUNameIdx( String separator,
		String argName )
	{
		String retval = "<RqstSecurityScopeDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRspnSingleOpenTag() {
		final String retval = "<RspnSecurityScopeReadSingle>";
		return( retval );
	}

	public static String formatSecurityScopeRspnSingleCloseTag() {
		final String retval = "</RspnSecurityScopeReadSingle>";
		return( retval );
	}

	public static String formatSecurityScopeRspnListOpenTag() {
		final String retval = "<RspnSecurityScopeReadList>";
		return( retval );
	}

	public static String formatSecurityScopeRspnListCloseTag() {
		final String retval = "</RspnSecurityScopeReadList>";
		return( retval );
	}

	public static String formatSecurityScopeRspnRec( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = "<SecurityScope "
			+	formatSecurityScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRspnDerivedRec( String separator, CFBamSecurityScopeBuff buff ) {
		String retval;
		retval = formatSecurityScopeRspnRec( separator, buff );
		return( retval );
	}

	public static String formatSecurityScopeRspnCreated( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = "<RspnSecurityScopeCreated "
			+	formatSecurityScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRspnLocked( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = "<RspnSecurityScopeLocked "
			+	formatSecurityScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRspnUpdated( String separator, CFBamSecurityScopeBuff buff ) {
		String retval = "<RspnSecurityScopeUpdated "
			+	formatSecurityScopeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSecurityScopeRspnDeleted() {
		String retval = "<RspnSecurityScopeDeleted />";
		return( retval );
	}
}
