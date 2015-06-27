
// Description: Java 7 XML Message message formatter for CFBam.ClearTopDep

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
 *	CFBamXMsgClearTopDepMessageFormatter XML message formatter
 *	for CFBam.ClearTopDep.
 */
public class CFBamXMsgClearTopDepMessageFormatter
	extends CFBamXMsgClearDepMessageFormatter
{
	public CFBamXMsgClearTopDepMessageFormatter() {
		super();
	}

	public static String formatClearTopDepBuffAttributes( String separator, CFBamClearTopDepBuff buff ) {
		String retval = CFBamXMsgClearDepMessageFormatter.formatClearDepBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTableId",
					buff.getRequiredContTableId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatClearTopDepRqstCreate( String separator, CFBamClearTopDepBuff buff ) {
		String retval = "<RqstClearTopDepCreate "
			+	formatClearTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstClearTopDepRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstRead( String separator, CFBamClearTopDepBuff buff ) {
		String retval = "<RqstClearTopDepRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearTopDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstReadAll( String separator ) {
		String retval = "<RqstClearTopDepReadAll />";
		return( retval );
	}

	public static String formatClearTopDepRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearTopDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstClearTopDepReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstReadByTableIdx( String separator,
		long argTenantId,
		long argRelationId )
	{
		String retval = "<RqstClearTopDepReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstReadByContTblIdx( String separator,
		long argTenantId,
		long argContTableId )
	{
		String retval = "<RqstClearTopDepReadByContTblIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTableId",
					argContTableId )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argContTableId,
		String argName )
	{
		String retval = "<RqstClearTopDepReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTableId",
					argContTableId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstClearTopDepLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstLock( String separator, CFBamClearTopDepBuff buff ) {
		String retval = "<RqstClearTopDepLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearTopDepLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstUpdate( String separator, CFBamClearTopDepBuff buff ) {
		String retval = "<RqstClearTopDepUpdate "
			+	formatClearTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstDelete( String separator, CFBamClearTopDepBuff buff ) {
		String retval = "<RqstClearTopDepDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearTopDepDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstClearTopDepDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstDeleteByTableIdx( String separator,
		long argTenantId,
		long argRelationId )
	{
		String retval = "<RqstClearTopDepDeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstDeleteByContTblIdx( String separator,
		long argTenantId,
		long argContTableId )
	{
		String retval = "<RqstClearTopDepDeleteByContTblIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTableId",
					argContTableId )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argContTableId,
		String argName )
	{
		String retval = "<RqstClearTopDepDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTableId",
					argContTableId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRspnSingleOpenTag() {
		final String retval = "<RspnClearTopDepReadSingle>";
		return( retval );
	}

	public static String formatClearTopDepRspnSingleCloseTag() {
		final String retval = "</RspnClearTopDepReadSingle>";
		return( retval );
	}

	public static String formatClearTopDepRspnListOpenTag() {
		final String retval = "<RspnClearTopDepReadList>";
		return( retval );
	}

	public static String formatClearTopDepRspnListCloseTag() {
		final String retval = "</RspnClearTopDepReadList>";
		return( retval );
	}

	public static String formatClearTopDepRspnRec( String separator, CFBamClearTopDepBuff buff ) {
		String retval = "<ClearTopDep "
			+	formatClearTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRspnDerivedRec( String separator, CFBamClearTopDepBuff buff ) {
		String retval;
		retval = formatClearTopDepRspnRec( separator, buff );
		return( retval );
	}

	public static String formatClearTopDepRspnCreated( String separator, CFBamClearTopDepBuff buff ) {
		String retval = "<RspnClearTopDepCreated "
			+	formatClearTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRspnLocked( String separator, CFBamClearTopDepBuff buff ) {
		String retval = "<RspnClearTopDepLocked "
			+	formatClearTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRspnUpdated( String separator, CFBamClearTopDepBuff buff ) {
		String retval = "<RspnClearTopDepUpdated "
			+	formatClearTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearTopDepRspnDeleted() {
		String retval = "<RspnClearTopDepDeleted />";
		return( retval );
	}
}
