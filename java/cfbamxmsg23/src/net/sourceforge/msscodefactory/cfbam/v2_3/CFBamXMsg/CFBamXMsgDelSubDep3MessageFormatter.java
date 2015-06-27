
// Description: Java 7 XML Message message formatter for CFBam.DelSubDep3

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
 *	CFBamXMsgDelSubDep3MessageFormatter XML message formatter
 *	for CFBam.DelSubDep3.
 */
public class CFBamXMsgDelSubDep3MessageFormatter
	extends CFBamXMsgDelDepMessageFormatter
{
	public CFBamXMsgDelSubDep3MessageFormatter() {
		super();
	}

	public static String formatDelSubDep3BuffAttributes( String separator, CFBamDelSubDep3Buff buff ) {
		String retval = CFBamXMsgDelDepMessageFormatter.formatDelDepBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTenantId",
					buff.getRequiredContTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelDep2Id",
					buff.getRequiredContDelDep2Id() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatDelSubDep3RqstCreate( String separator, CFBamDelSubDep3Buff buff ) {
		String retval = "<RqstDelSubDep3Create "
			+	formatDelSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstDelSubDep3Read "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstRead( String separator, CFBamDelSubDep3Buff buff ) {
		String retval = "<RqstDelSubDep3Read "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep3Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstReadAll( String separator ) {
		String retval = "<RqstDelSubDep3ReadAll />";
		return( retval );
	}

	public static String formatDelSubDep3RqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep3Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDelSubDep3ReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstDelSubDep3ReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstReadByTableIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstDelSubDep3ReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstReadByContDelDep2Idx( String separator,
		long argContTenantId,
		long argContDelDep2Id )
	{
		String retval = "<RqstDelSubDep3ReadByContDelDep2Idx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelDep2Id",
					argContDelDep2Id )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstReadByUNameIdx( String separator,
		long argContTenantId,
		long argContDelDep2Id,
		String argName )
	{
		String retval = "<RqstDelSubDep3ReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelDep2Id",
					argContDelDep2Id )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstDelSubDep3Lock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstLock( String separator, CFBamDelSubDep3Buff buff ) {
		String retval = "<RqstDelSubDep3Lock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep3Lock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstUpdate( String separator, CFBamDelSubDep3Buff buff ) {
		String retval = "<RqstDelSubDep3Update "
			+	formatDelSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstDelete( String separator, CFBamDelSubDep3Buff buff ) {
		String retval = "<RqstDelSubDep3Delete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep3Delete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDelSubDep3DeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstDelSubDep3DeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstDeleteByTableIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstDelSubDep3DeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstDeleteByContDelDep2Idx( String separator,
		long argContTenantId,
		long argContDelDep2Id )
	{
		String retval = "<RqstDelSubDep3DeleteByContDelDep2Idx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelDep2Id",
					argContDelDep2Id )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RqstDeleteByUNameIdx( String separator,
		long argContTenantId,
		long argContDelDep2Id,
		String argName )
	{
		String retval = "<RqstDelSubDep3DeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelDep2Id",
					argContDelDep2Id )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RspnSingleOpenTag() {
		final String retval = "<RspnDelSubDep3ReadSingle>";
		return( retval );
	}

	public static String formatDelSubDep3RspnSingleCloseTag() {
		final String retval = "</RspnDelSubDep3ReadSingle>";
		return( retval );
	}

	public static String formatDelSubDep3RspnListOpenTag() {
		final String retval = "<RspnDelSubDep3ReadList>";
		return( retval );
	}

	public static String formatDelSubDep3RspnListCloseTag() {
		final String retval = "</RspnDelSubDep3ReadList>";
		return( retval );
	}

	public static String formatDelSubDep3RspnRec( String separator, CFBamDelSubDep3Buff buff ) {
		String retval = "<DelSubDep3 "
			+	formatDelSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RspnDerivedRec( String separator, CFBamDelSubDep3Buff buff ) {
		String retval;
		retval = formatDelSubDep3RspnRec( separator, buff );
		return( retval );
	}

	public static String formatDelSubDep3RspnCreated( String separator, CFBamDelSubDep3Buff buff ) {
		String retval = "<RspnDelSubDep3Created "
			+	formatDelSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RspnLocked( String separator, CFBamDelSubDep3Buff buff ) {
		String retval = "<RspnDelSubDep3Locked "
			+	formatDelSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RspnUpdated( String separator, CFBamDelSubDep3Buff buff ) {
		String retval = "<RspnDelSubDep3Updated "
			+	formatDelSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep3RspnDeleted() {
		String retval = "<RspnDelSubDep3Deleted />";
		return( retval );
	}
}
