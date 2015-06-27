
// Description: Java 7 XML Message message formatter for CFBam.DelSubDep1

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
 *	CFBamXMsgDelSubDep1MessageFormatter XML message formatter
 *	for CFBam.DelSubDep1.
 */
public class CFBamXMsgDelSubDep1MessageFormatter
	extends CFBamXMsgDelDepMessageFormatter
{
	public CFBamXMsgDelSubDep1MessageFormatter() {
		super();
	}

	public static String formatDelSubDep1BuffAttributes( String separator, CFBamDelSubDep1Buff buff ) {
		String retval = CFBamXMsgDelDepMessageFormatter.formatDelDepBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTenantId",
					buff.getRequiredContTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelTopDepId",
					buff.getRequiredContDelTopDepId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatDelSubDep1RqstCreate( String separator, CFBamDelSubDep1Buff buff ) {
		String retval = "<RqstDelSubDep1Create "
			+	formatDelSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstDelSubDep1Read "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstRead( String separator, CFBamDelSubDep1Buff buff ) {
		String retval = "<RqstDelSubDep1Read "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep1Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstReadAll( String separator ) {
		String retval = "<RqstDelSubDep1ReadAll />";
		return( retval );
	}

	public static String formatDelSubDep1RqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep1Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDelSubDep1ReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstDelSubDep1ReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstReadByTableIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstDelSubDep1ReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstReadByContDelTopIdx( String separator,
		long argContTenantId,
		long argContDelTopDepId )
	{
		String retval = "<RqstDelSubDep1ReadByContDelTopIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelTopDepId",
					argContDelTopDepId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstReadByUNameIdx( String separator,
		long argContTenantId,
		long argContDelTopDepId,
		String argName )
	{
		String retval = "<RqstDelSubDep1ReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelTopDepId",
					argContDelTopDepId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstDelSubDep1Lock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstLock( String separator, CFBamDelSubDep1Buff buff ) {
		String retval = "<RqstDelSubDep1Lock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep1Lock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstUpdate( String separator, CFBamDelSubDep1Buff buff ) {
		String retval = "<RqstDelSubDep1Update "
			+	formatDelSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstDelete( String separator, CFBamDelSubDep1Buff buff ) {
		String retval = "<RqstDelSubDep1Delete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelSubDep1Delete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDelSubDep1DeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstDelSubDep1DeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstDeleteByTableIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstDelSubDep1DeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstDeleteByContDelTopIdx( String separator,
		long argContTenantId,
		long argContDelTopDepId )
	{
		String retval = "<RqstDelSubDep1DeleteByContDelTopIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelTopDepId",
					argContDelTopDepId )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RqstDeleteByUNameIdx( String separator,
		long argContTenantId,
		long argContDelTopDepId,
		String argName )
	{
		String retval = "<RqstDelSubDep1DeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContDelTopDepId",
					argContDelTopDepId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RspnSingleOpenTag() {
		final String retval = "<RspnDelSubDep1ReadSingle>";
		return( retval );
	}

	public static String formatDelSubDep1RspnSingleCloseTag() {
		final String retval = "</RspnDelSubDep1ReadSingle>";
		return( retval );
	}

	public static String formatDelSubDep1RspnListOpenTag() {
		final String retval = "<RspnDelSubDep1ReadList>";
		return( retval );
	}

	public static String formatDelSubDep1RspnListCloseTag() {
		final String retval = "</RspnDelSubDep1ReadList>";
		return( retval );
	}

	public static String formatDelSubDep1RspnRec( String separator, CFBamDelSubDep1Buff buff ) {
		String retval = "<DelSubDep1 "
			+	formatDelSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RspnDerivedRec( String separator, CFBamDelSubDep1Buff buff ) {
		String retval;
		retval = formatDelSubDep1RspnRec( separator, buff );
		return( retval );
	}

	public static String formatDelSubDep1RspnCreated( String separator, CFBamDelSubDep1Buff buff ) {
		String retval = "<RspnDelSubDep1Created "
			+	formatDelSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RspnLocked( String separator, CFBamDelSubDep1Buff buff ) {
		String retval = "<RspnDelSubDep1Locked "
			+	formatDelSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RspnUpdated( String separator, CFBamDelSubDep1Buff buff ) {
		String retval = "<RspnDelSubDep1Updated "
			+	formatDelSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelSubDep1RspnDeleted() {
		String retval = "<RspnDelSubDep1Deleted />";
		return( retval );
	}
}
