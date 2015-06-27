
// Description: Java 7 XML Message message formatter for CFBam.PopSubDep1

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
 *	CFBamXMsgPopSubDep1MessageFormatter XML message formatter
 *	for CFBam.PopSubDep1.
 */
public class CFBamXMsgPopSubDep1MessageFormatter
	extends CFBamXMsgPopDepMessageFormatter
{
	public CFBamXMsgPopSubDep1MessageFormatter() {
		super();
	}

	public static String formatPopSubDep1BuffAttributes( String separator, CFBamPopSubDep1Buff buff ) {
		String retval = CFBamXMsgPopDepMessageFormatter.formatPopDepBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTenantId",
					buff.getRequiredContTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopTopDepId",
					buff.getRequiredContPopTopDepId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatPopSubDep1RqstCreate( String separator, CFBamPopSubDep1Buff buff ) {
		String retval = "<RqstPopSubDep1Create "
			+	formatPopSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstPopSubDep1Read "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstRead( String separator, CFBamPopSubDep1Buff buff ) {
		String retval = "<RqstPopSubDep1Read "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep1Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstReadAll( String separator ) {
		String retval = "<RqstPopSubDep1ReadAll />";
		return( retval );
	}

	public static String formatPopSubDep1RqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep1Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstPopSubDep1ReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstReadByRelationIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstPopSubDep1ReadByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstPopSubDep1ReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstReadByContPopTopIdx( String separator,
		long argContTenantId,
		long argContPopTopDepId )
	{
		String retval = "<RqstPopSubDep1ReadByContPopTopIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopTopDepId",
					argContPopTopDepId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstReadByUNameIdx( String separator,
		long argContTenantId,
		long argContPopTopDepId,
		String argName )
	{
		String retval = "<RqstPopSubDep1ReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopTopDepId",
					argContPopTopDepId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstPopSubDep1Lock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstLock( String separator, CFBamPopSubDep1Buff buff ) {
		String retval = "<RqstPopSubDep1Lock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep1Lock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstUpdate( String separator, CFBamPopSubDep1Buff buff ) {
		String retval = "<RqstPopSubDep1Update "
			+	formatPopSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstDelete( String separator, CFBamPopSubDep1Buff buff ) {
		String retval = "<RqstPopSubDep1Delete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep1Delete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstPopSubDep1DeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstDeleteByRelationIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstPopSubDep1DeleteByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstPopSubDep1DeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstDeleteByContPopTopIdx( String separator,
		long argContTenantId,
		long argContPopTopDepId )
	{
		String retval = "<RqstPopSubDep1DeleteByContPopTopIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopTopDepId",
					argContPopTopDepId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RqstDeleteByUNameIdx( String separator,
		long argContTenantId,
		long argContPopTopDepId,
		String argName )
	{
		String retval = "<RqstPopSubDep1DeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopTopDepId",
					argContPopTopDepId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RspnSingleOpenTag() {
		final String retval = "<RspnPopSubDep1ReadSingle>";
		return( retval );
	}

	public static String formatPopSubDep1RspnSingleCloseTag() {
		final String retval = "</RspnPopSubDep1ReadSingle>";
		return( retval );
	}

	public static String formatPopSubDep1RspnListOpenTag() {
		final String retval = "<RspnPopSubDep1ReadList>";
		return( retval );
	}

	public static String formatPopSubDep1RspnListCloseTag() {
		final String retval = "</RspnPopSubDep1ReadList>";
		return( retval );
	}

	public static String formatPopSubDep1RspnRec( String separator, CFBamPopSubDep1Buff buff ) {
		String retval = "<PopSubDep1 "
			+	formatPopSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RspnDerivedRec( String separator, CFBamPopSubDep1Buff buff ) {
		String retval;
		retval = formatPopSubDep1RspnRec( separator, buff );
		return( retval );
	}

	public static String formatPopSubDep1RspnCreated( String separator, CFBamPopSubDep1Buff buff ) {
		String retval = "<RspnPopSubDep1Created "
			+	formatPopSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RspnLocked( String separator, CFBamPopSubDep1Buff buff ) {
		String retval = "<RspnPopSubDep1Locked "
			+	formatPopSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RspnUpdated( String separator, CFBamPopSubDep1Buff buff ) {
		String retval = "<RspnPopSubDep1Updated "
			+	formatPopSubDep1BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep1RspnDeleted() {
		String retval = "<RspnPopSubDep1Deleted />";
		return( retval );
	}
}
