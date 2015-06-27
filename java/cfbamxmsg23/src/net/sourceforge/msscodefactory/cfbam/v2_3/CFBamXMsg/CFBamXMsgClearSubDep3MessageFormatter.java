
// Description: Java 7 XML Message message formatter for CFBam.ClearSubDep3

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
 *	CFBamXMsgClearSubDep3MessageFormatter XML message formatter
 *	for CFBam.ClearSubDep3.
 */
public class CFBamXMsgClearSubDep3MessageFormatter
	extends CFBamXMsgClearDepMessageFormatter
{
	public CFBamXMsgClearSubDep3MessageFormatter() {
		super();
	}

	public static String formatClearSubDep3BuffAttributes( String separator, CFBamClearSubDep3Buff buff ) {
		String retval = CFBamXMsgClearDepMessageFormatter.formatClearDepBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContClearDep2TenantId",
					buff.getRequiredContClearDep2TenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContClearDep2Id",
					buff.getRequiredContClearDep2Id() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatClearSubDep3RqstCreate( String separator, CFBamClearSubDep3Buff buff ) {
		String retval = "<RqstClearSubDep3Create "
			+	formatClearSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstClearSubDep3Read "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstRead( String separator, CFBamClearSubDep3Buff buff ) {
		String retval = "<RqstClearSubDep3Read "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearSubDep3Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstReadAll( String separator ) {
		String retval = "<RqstClearSubDep3ReadAll />";
		return( retval );
	}

	public static String formatClearSubDep3RqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearSubDep3Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstClearSubDep3ReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstReadByTableIdx( String separator,
		long argTenantId,
		long argRelationId )
	{
		String retval = "<RqstClearSubDep3ReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstReadByContClearDep2Idx( String separator,
		long argContClearDep2TenantId,
		long argContClearDep2Id )
	{
		String retval = "<RqstClearSubDep3ReadByContClearDep2Idx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContClearDep2TenantId",
					argContClearDep2TenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContClearDep2Id",
					argContClearDep2Id )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstReadByUNameIdx( String separator,
		long argTenantId,
		long argContClearDep2Id,
		String argName )
	{
		String retval = "<RqstClearSubDep3ReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContClearDep2Id",
					argContClearDep2Id )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstClearSubDep3Lock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstLock( String separator, CFBamClearSubDep3Buff buff ) {
		String retval = "<RqstClearSubDep3Lock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearSubDep3Lock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstUpdate( String separator, CFBamClearSubDep3Buff buff ) {
		String retval = "<RqstClearSubDep3Update "
			+	formatClearSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstDelete( String separator, CFBamClearSubDep3Buff buff ) {
		String retval = "<RqstClearSubDep3Delete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstClearSubDep3Delete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstClearSubDep3DeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstDeleteByTableIdx( String separator,
		long argTenantId,
		long argRelationId )
	{
		String retval = "<RqstClearSubDep3DeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstDeleteByContClearDep2Idx( String separator,
		long argContClearDep2TenantId,
		long argContClearDep2Id )
	{
		String retval = "<RqstClearSubDep3DeleteByContClearDep2Idx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContClearDep2TenantId",
					argContClearDep2TenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContClearDep2Id",
					argContClearDep2Id )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argContClearDep2Id,
		String argName )
	{
		String retval = "<RqstClearSubDep3DeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContClearDep2Id",
					argContClearDep2Id )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RspnSingleOpenTag() {
		final String retval = "<RspnClearSubDep3ReadSingle>";
		return( retval );
	}

	public static String formatClearSubDep3RspnSingleCloseTag() {
		final String retval = "</RspnClearSubDep3ReadSingle>";
		return( retval );
	}

	public static String formatClearSubDep3RspnListOpenTag() {
		final String retval = "<RspnClearSubDep3ReadList>";
		return( retval );
	}

	public static String formatClearSubDep3RspnListCloseTag() {
		final String retval = "</RspnClearSubDep3ReadList>";
		return( retval );
	}

	public static String formatClearSubDep3RspnRec( String separator, CFBamClearSubDep3Buff buff ) {
		String retval = "<ClearSubDep3 "
			+	formatClearSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RspnDerivedRec( String separator, CFBamClearSubDep3Buff buff ) {
		String retval;
		retval = formatClearSubDep3RspnRec( separator, buff );
		return( retval );
	}

	public static String formatClearSubDep3RspnCreated( String separator, CFBamClearSubDep3Buff buff ) {
		String retval = "<RspnClearSubDep3Created "
			+	formatClearSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RspnLocked( String separator, CFBamClearSubDep3Buff buff ) {
		String retval = "<RspnClearSubDep3Locked "
			+	formatClearSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RspnUpdated( String separator, CFBamClearSubDep3Buff buff ) {
		String retval = "<RspnClearSubDep3Updated "
			+	formatClearSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatClearSubDep3RspnDeleted() {
		String retval = "<RspnClearSubDep3Deleted />";
		return( retval );
	}
}
