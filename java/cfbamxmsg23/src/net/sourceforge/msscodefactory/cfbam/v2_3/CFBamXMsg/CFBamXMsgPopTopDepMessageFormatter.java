
// Description: Java 7 XML Message message formatter for CFBam.PopTopDep

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
 *	CFBamXMsgPopTopDepMessageFormatter XML message formatter
 *	for CFBam.PopTopDep.
 */
public class CFBamXMsgPopTopDepMessageFormatter
	extends CFBamXMsgPopDepMessageFormatter
{
	public CFBamXMsgPopTopDepMessageFormatter() {
		super();
	}

	public static String formatPopTopDepBuffAttributes( String separator, CFBamPopTopDepBuff buff ) {
		String retval = CFBamXMsgPopDepMessageFormatter.formatPopDepBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTenantId",
					buff.getRequiredContTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContRelationId",
					buff.getRequiredContRelationId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatPopTopDepRqstCreate( String separator, CFBamPopTopDepBuff buff ) {
		String retval = "<RqstPopTopDepCreate "
			+	formatPopTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstPopTopDepRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstRead( String separator, CFBamPopTopDepBuff buff ) {
		String retval = "<RqstPopTopDepRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopTopDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstReadAll( String separator ) {
		String retval = "<RqstPopTopDepReadAll />";
		return( retval );
	}

	public static String formatPopTopDepRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopTopDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstPopTopDepReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstReadByRelationIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstPopTopDepReadByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstPopTopDepReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstReadByContRelIdx( String separator,
		long argContTenantId,
		long argContRelationId )
	{
		String retval = "<RqstPopTopDepReadByContRelIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContRelationId",
					argContRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstReadByUNameIdx( String separator,
		long argContTenantId,
		long argContRelationId,
		String argName )
	{
		String retval = "<RqstPopTopDepReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContRelationId",
					argContRelationId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstPopTopDepLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstLock( String separator, CFBamPopTopDepBuff buff ) {
		String retval = "<RqstPopTopDepLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopTopDepLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstUpdate( String separator, CFBamPopTopDepBuff buff ) {
		String retval = "<RqstPopTopDepUpdate "
			+	formatPopTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstDelete( String separator, CFBamPopTopDepBuff buff ) {
		String retval = "<RqstPopTopDepDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopTopDepDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstPopTopDepDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstDeleteByRelationIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstPopTopDepDeleteByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstPopTopDepDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstDeleteByContRelIdx( String separator,
		long argContTenantId,
		long argContRelationId )
	{
		String retval = "<RqstPopTopDepDeleteByContRelIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContRelationId",
					argContRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRqstDeleteByUNameIdx( String separator,
		long argContTenantId,
		long argContRelationId,
		String argName )
	{
		String retval = "<RqstPopTopDepDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContRelationId",
					argContRelationId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRspnSingleOpenTag() {
		final String retval = "<RspnPopTopDepReadSingle>";
		return( retval );
	}

	public static String formatPopTopDepRspnSingleCloseTag() {
		final String retval = "</RspnPopTopDepReadSingle>";
		return( retval );
	}

	public static String formatPopTopDepRspnListOpenTag() {
		final String retval = "<RspnPopTopDepReadList>";
		return( retval );
	}

	public static String formatPopTopDepRspnListCloseTag() {
		final String retval = "</RspnPopTopDepReadList>";
		return( retval );
	}

	public static String formatPopTopDepRspnRec( String separator, CFBamPopTopDepBuff buff ) {
		String retval = "<PopTopDep "
			+	formatPopTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRspnDerivedRec( String separator, CFBamPopTopDepBuff buff ) {
		String retval;
		retval = formatPopTopDepRspnRec( separator, buff );
		return( retval );
	}

	public static String formatPopTopDepRspnCreated( String separator, CFBamPopTopDepBuff buff ) {
		String retval = "<RspnPopTopDepCreated "
			+	formatPopTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRspnLocked( String separator, CFBamPopTopDepBuff buff ) {
		String retval = "<RspnPopTopDepLocked "
			+	formatPopTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRspnUpdated( String separator, CFBamPopTopDepBuff buff ) {
		String retval = "<RspnPopTopDepUpdated "
			+	formatPopTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopTopDepRspnDeleted() {
		String retval = "<RspnPopTopDepDeleted />";
		return( retval );
	}
}
