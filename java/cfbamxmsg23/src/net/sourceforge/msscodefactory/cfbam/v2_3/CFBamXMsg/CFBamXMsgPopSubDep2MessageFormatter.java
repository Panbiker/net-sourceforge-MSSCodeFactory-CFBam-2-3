
// Description: Java 7 XML Message message formatter for CFBam.PopSubDep2

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
 *	CFBamXMsgPopSubDep2MessageFormatter XML message formatter
 *	for CFBam.PopSubDep2.
 */
public class CFBamXMsgPopSubDep2MessageFormatter
	extends CFBamXMsgPopDepMessageFormatter
{
	public CFBamXMsgPopSubDep2MessageFormatter() {
		super();
	}

	public static String formatPopSubDep2BuffAttributes( String separator, CFBamPopSubDep2Buff buff ) {
		String retval = CFBamXMsgPopDepMessageFormatter.formatPopDepBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTenantId",
					buff.getRequiredContTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopDep1Id",
					buff.getRequiredContPopDep1Id() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatPopSubDep2RqstCreate( String separator, CFBamPopSubDep2Buff buff ) {
		String retval = "<RqstPopSubDep2Create "
			+	formatPopSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstPopSubDep2Read "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstRead( String separator, CFBamPopSubDep2Buff buff ) {
		String retval = "<RqstPopSubDep2Read "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep2Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstReadAll( String separator ) {
		String retval = "<RqstPopSubDep2ReadAll />";
		return( retval );
	}

	public static String formatPopSubDep2RqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep2Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstPopSubDep2ReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstReadByRelationIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstPopSubDep2ReadByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstPopSubDep2ReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstReadByContPopDep1Idx( String separator,
		long argContTenantId,
		long argContPopDep1Id )
	{
		String retval = "<RqstPopSubDep2ReadByContPopDep1Idx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopDep1Id",
					argContPopDep1Id )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstReadByUNameIdx( String separator,
		long argContTenantId,
		long argContPopDep1Id,
		String argName )
	{
		String retval = "<RqstPopSubDep2ReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopDep1Id",
					argContPopDep1Id )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstPopSubDep2Lock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstLock( String separator, CFBamPopSubDep2Buff buff ) {
		String retval = "<RqstPopSubDep2Lock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep2Lock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstUpdate( String separator, CFBamPopSubDep2Buff buff ) {
		String retval = "<RqstPopSubDep2Update "
			+	formatPopSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstDelete( String separator, CFBamPopSubDep2Buff buff ) {
		String retval = "<RqstPopSubDep2Delete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep2Delete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstPopSubDep2DeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstDeleteByRelationIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstPopSubDep2DeleteByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstPopSubDep2DeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstDeleteByContPopDep1Idx( String separator,
		long argContTenantId,
		long argContPopDep1Id )
	{
		String retval = "<RqstPopSubDep2DeleteByContPopDep1Idx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopDep1Id",
					argContPopDep1Id )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RqstDeleteByUNameIdx( String separator,
		long argContTenantId,
		long argContPopDep1Id,
		String argName )
	{
		String retval = "<RqstPopSubDep2DeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopDep1Id",
					argContPopDep1Id )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RspnSingleOpenTag() {
		final String retval = "<RspnPopSubDep2ReadSingle>";
		return( retval );
	}

	public static String formatPopSubDep2RspnSingleCloseTag() {
		final String retval = "</RspnPopSubDep2ReadSingle>";
		return( retval );
	}

	public static String formatPopSubDep2RspnListOpenTag() {
		final String retval = "<RspnPopSubDep2ReadList>";
		return( retval );
	}

	public static String formatPopSubDep2RspnListCloseTag() {
		final String retval = "</RspnPopSubDep2ReadList>";
		return( retval );
	}

	public static String formatPopSubDep2RspnRec( String separator, CFBamPopSubDep2Buff buff ) {
		String retval = "<PopSubDep2 "
			+	formatPopSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RspnDerivedRec( String separator, CFBamPopSubDep2Buff buff ) {
		String retval;
		retval = formatPopSubDep2RspnRec( separator, buff );
		return( retval );
	}

	public static String formatPopSubDep2RspnCreated( String separator, CFBamPopSubDep2Buff buff ) {
		String retval = "<RspnPopSubDep2Created "
			+	formatPopSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RspnLocked( String separator, CFBamPopSubDep2Buff buff ) {
		String retval = "<RspnPopSubDep2Locked "
			+	formatPopSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RspnUpdated( String separator, CFBamPopSubDep2Buff buff ) {
		String retval = "<RspnPopSubDep2Updated "
			+	formatPopSubDep2BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep2RspnDeleted() {
		String retval = "<RspnPopSubDep2Deleted />";
		return( retval );
	}
}
