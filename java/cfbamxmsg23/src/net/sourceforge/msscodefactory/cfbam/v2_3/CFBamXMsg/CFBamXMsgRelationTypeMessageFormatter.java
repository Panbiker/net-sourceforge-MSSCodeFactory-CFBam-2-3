
// Description: Java 7 XML Message message formatter for CFBam.RelationType

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
 *	CFBamXMsgRelationTypeMessageFormatter XML message formatter
 *	for CFBam.RelationType.
 */
public class CFBamXMsgRelationTypeMessageFormatter
{
	public CFBamXMsgRelationTypeMessageFormatter() {
	}

	public static String formatRelationTypePKeyAttributes( String separator, CFBamRelationTypePKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( null,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatRelationTypePKeyAttributes( String separator, CFBamRelationTypeBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt16( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatRelationTypeBuffAttributes( String separator, CFBamRelationTypeBuff buff ) {
		String retval = CFBamXMsgRelationTypeMessageFormatter.formatRelationTypePKeyAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"Revision",
					buff.getRequiredRevision() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Tag",
					buff.getRequiredTag() );
		return( retval );
	}

	public static String formatRelationTypeRqstCreate( String separator, CFBamRelationTypeBuff buff ) {
		String retval = "<RqstRelationTypeCreate "
			+	formatRelationTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstRead( String separator, CFBamRelationTypePKey pkey ) {
		String retval = "<RqstRelationTypeRead "
			+	formatRelationTypePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstRead( String separator, CFBamRelationTypeBuff buff ) {
		String retval = "<RqstRelationTypeRead "
			+	formatRelationTypePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstRead( String separator,
		short argId )
	{
		String retval = "<RqstRelationTypeRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstReadAll( String separator ) {
		String retval = "<RqstRelationTypeReadAll />";
		return( retval );
	}

	public static String formatRelationTypeRqstReadByIdIdx( String separator,
		short argId )
	{
		String retval = "<RqstRelationTypeRead "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstReadByUTagIdx( String separator,
		String argTag )
	{
		String retval = "<RqstRelationTypeReadByUTagIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Tag",
					argTag )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstLock( String separator, CFBamRelationTypePKey pkey ) {
		String retval = "<RqstRelationTypeLock "
			+	formatRelationTypePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstLock( String separator, CFBamRelationTypeBuff buff ) {
		String retval = "<RqstRelationTypeLock "
			+	formatRelationTypePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstLock( String separator,
		short argId )
	{
		String retval = "<RqstRelationTypeLock "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstUpdate( String separator, CFBamRelationTypeBuff buff ) {
		String retval = "<RqstRelationTypeUpdate "
			+	formatRelationTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstDelete( String separator, CFBamRelationTypeBuff buff ) {
		String retval = "<RqstRelationTypeDelete "
				+	formatRelationTypePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstDeleteByIdIdx( String separator,
		short argId )
	{
		String retval = "<RqstRelationTypeDelete "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRqstDeleteByUTagIdx( String separator,
		String argTag )
	{
		String retval = "<RqstRelationTypeDeleteByUTagIdx "
			+	CFLibXmlUtil.formatRequiredXmlString( null,
					"Tag",
					argTag )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRspnSingleOpenTag() {
		final String retval = "<RspnRelationTypeReadSingle>";
		return( retval );
	}

	public static String formatRelationTypeRspnSingleCloseTag() {
		final String retval = "</RspnRelationTypeReadSingle>";
		return( retval );
	}

	public static String formatRelationTypeRspnListOpenTag() {
		final String retval = "<RspnRelationTypeReadList>";
		return( retval );
	}

	public static String formatRelationTypeRspnListCloseTag() {
		final String retval = "</RspnRelationTypeReadList>";
		return( retval );
	}

	public static String formatRelationTypeRspnRec( String separator, CFBamRelationTypeBuff buff ) {
		String retval = "<RelationType "
			+	formatRelationTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRspnDerivedRec( String separator, CFBamRelationTypeBuff buff ) {
		String retval;
		retval = formatRelationTypeRspnRec( separator, buff );
		return( retval );
	}

	public static String formatRelationTypeRspnCreated( String separator, CFBamRelationTypeBuff buff ) {
		String retval = "<RspnRelationTypeCreated "
			+	formatRelationTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRspnLocked( String separator, CFBamRelationTypeBuff buff ) {
		String retval = "<RspnRelationTypeLocked "
			+	formatRelationTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRspnUpdated( String separator, CFBamRelationTypeBuff buff ) {
		String retval = "<RspnRelationTypeUpdated "
			+	formatRelationTypeBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationTypeRspnDeleted() {
		String retval = "<RspnRelationTypeDeleted />";
		return( retval );
	}
}
