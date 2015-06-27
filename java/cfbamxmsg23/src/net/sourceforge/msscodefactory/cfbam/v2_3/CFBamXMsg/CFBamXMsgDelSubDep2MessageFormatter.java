
// Description: Java 7 XML Message message formatter for CFBam.DelSubDep2

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
 *	CFBamXMsgDelSubDep2MessageFormatter XML message formatter
 *	for CFBam.DelSubDep2.
 */
public class CFBamXMsgDelSubDep2MessageFormatter
	extends CFBamXMsgDelDepMessageFormatter
{
	public CFBamXMsgDelSubDep2MessageFormatter() {
		super();
	}

	public static String formatDelSubDep2BuffAttributes( String separator, CFBamDelSubDep2Buff buff ) {
		String retval = CFBamXMsgDelDepMessageFormatter.formatDelDepBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTenantId",
					buff.getRequiredContTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelDep1Id",
					buff.getRequiredContDelDep1Id() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatDelSubDep2RqstCreate( String separator, CFBamDelSubDep2Buff buff ) {
		String retval = "<RqstDelSubDep2Create "
			+	formatDelSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstDelSubDep2Read "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstRead( String separator, CFBamDelSubDep2Buff buff ) {
		String retval = "<RqstDelSubDep2Read "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep2Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstReadAll( String separator ) {
		String retval = "<RqstDelSubDep2ReadAll />";
		return( retval );
	}

	public static String formatDelSubDep2RqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep2Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDelSubDep2ReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstDelSubDep2ReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstReadByTableIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstDelSubDep2ReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstReadByContDelDep1Idx( String separator,
		long argContTenantId,
		long argContDelDep1Id )
	{
		String retval = "<RqstDelSubDep2ReadByContDelDep1Idx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelDep1Id",
					argContDelDep1Id )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstReadByUNameIdx( String separator,
		long argContTenantId,
		long argContDelDep1Id,
		String argName )
	{
		String retval = "<RqstDelSubDep2ReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelDep1Id",
					argContDelDep1Id )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstDelSubDep2Lock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstLock( String separator, CFBamDelSubDep2Buff buff ) {
		String retval = "<RqstDelSubDep2Lock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep2Lock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstUpdate( String separator, CFBamDelSubDep2Buff buff ) {
		String retval = "<RqstDelSubDep2Update "
			+	formatDelSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstDelete( String separator, CFBamDelSubDep2Buff buff ) {
		String retval = "<RqstDelSubDep2Delete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep2Delete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDelSubDep2DeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstDelSubDep2DeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstDeleteByTableIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstDelSubDep2DeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstDeleteByContDelDep1Idx( String separator,
		long argContTenantId,
		long argContDelDep1Id )
	{
		String retval = "<RqstDelSubDep2DeleteByContDelDep1Idx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelDep1Id",
					argContDelDep1Id )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RqstDeleteByUNameIdx( String separator,
		long argContTenantId,
		long argContDelDep1Id,
		String argName )
	{
		String retval = "<RqstDelSubDep2DeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelDep1Id",
					argContDelDep1Id )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RspnSingleOpenTag() {
		final String retval = "<RspnDelSubDep2ReadSingle>";
		return( retval );
	}

	public static String formatDelSubDep2RspnSingleCloseTag() {
		final String retval = "</RspnDelSubDep2ReadSingle>";
		return( retval );
	}

	public static String formatDelSubDep2RspnListOpenTag() {
		final String retval = "<RspnDelSubDep2ReadList>";
		return( retval );
	}

	public static String formatDelSubDep2RspnListCloseTag() {
		final String retval = "</RspnDelSubDep2ReadList>";
		return( retval );
	}

	public static String formatDelSubDep2RspnRec( String separator, CFBamDelSubDep2Buff buff ) {
		String retval = "<DelSubDep2 "
			+	formatDelSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RspnDerivedRec( String separator, CFBamDelSubDep2Buff buff ) {
		String retval;
		retval = formatDelSubDep2RspnRec( separator, buff );
		return( retval );
	}

	public static String formatDelSubDep2RspnCreated( String separator, CFBamDelSubDep2Buff buff ) {
		String retval = "<RspnDelSubDep2Created "
			+	formatDelSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RspnLocked( String separator, CFBamDelSubDep2Buff buff ) {
		String retval = "<RspnDelSubDep2Locked "
			+	formatDelSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RspnUpdated( String separator, CFBamDelSubDep2Buff buff ) {
		String retval = "<RspnDelSubDep2Updated "
			+	formatDelSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep2RspnDeleted() {
		String retval = "<RspnDelSubDep2Deleted />";
		return( retval );
	}
}
