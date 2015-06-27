
// Description: Java 7 XML Message message formatter for CFBam.DelTopDep

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
 *	CFBamXMsgDelTopDepMessageFormatter XML message formatter
 *	for CFBam.DelTopDep.
 */
public class CFBamXMsgDelTopDepMessageFormatter
	extends CFBamXMsgDelDepMessageFormatter
{
	public CFBamXMsgDelTopDepMessageFormatter() {
		super();
	}

	public static String formatDelTopDepBuffAttributes( String separator, CFBamDelTopDepBuff buff ) {
		String retval = CFBamXMsgDelDepMessageFormatter.formatDelDepBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTenantId",
					buff.getRequiredContTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTableId",
					buff.getRequiredContTableId() );
		return( retval );
	}

	public static String formatDelTopDepRqstCreate( String separator, CFBamDelTopDepBuff buff ) {
		String retval = "<RqstDelTopDepCreate "
			+	formatDelTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstDelTopDepRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstRead( String separator, CFBamDelTopDepBuff buff ) {
		String retval = "<RqstDelTopDepRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelTopDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstReadAll( String separator ) {
		String retval = "<RqstDelTopDepReadAll />";
		return( retval );
	}

	public static String formatDelTopDepRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelTopDepRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDelTopDepReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstDelTopDepReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstReadByTableIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstDelTopDepReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstReadByContTblIdx( String separator,
		long argContTenantId,
		long argContTableId )
	{
		String retval = "<RqstDelTopDepReadByContTblIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTableId",
					argContTableId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstReadByUNameIdx( String separator,
		long argContTenantId,
		long argContTableId,
		String argName )
	{
		String retval = "<RqstDelTopDepReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTableId",
					argContTableId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstDelTopDepLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstLock( String separator, CFBamDelTopDepBuff buff ) {
		String retval = "<RqstDelTopDepLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelTopDepLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstUpdate( String separator, CFBamDelTopDepBuff buff ) {
		String retval = "<RqstDelTopDepUpdate "
			+	formatDelTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstDelete( String separator, CFBamDelTopDepBuff buff ) {
		String retval = "<RqstDelTopDepDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstDelTopDepDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstDelTopDepDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstDelTopDepDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstDeleteByTableIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstDelTopDepDeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstDeleteByContTblIdx( String separator,
		long argContTenantId,
		long argContTableId )
	{
		String retval = "<RqstDelTopDepDeleteByContTblIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTableId",
					argContTableId )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRqstDeleteByUNameIdx( String separator,
		long argContTenantId,
		long argContTableId,
		String argName )
	{
		String retval = "<RqstDelTopDepDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTableId",
					argContTableId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRspnSingleOpenTag() {
		final String retval = "<RspnDelTopDepReadSingle>";
		return( retval );
	}

	public static String formatDelTopDepRspnSingleCloseTag() {
		final String retval = "</RspnDelTopDepReadSingle>";
		return( retval );
	}

	public static String formatDelTopDepRspnListOpenTag() {
		final String retval = "<RspnDelTopDepReadList>";
		return( retval );
	}

	public static String formatDelTopDepRspnListCloseTag() {
		final String retval = "</RspnDelTopDepReadList>";
		return( retval );
	}

	public static String formatDelTopDepRspnRec( String separator, CFBamDelTopDepBuff buff ) {
		String retval = "<DelTopDep "
			+	formatDelTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRspnDerivedRec( String separator, CFBamDelTopDepBuff buff ) {
		String retval;
		retval = formatDelTopDepRspnRec( separator, buff );
		return( retval );
	}

	public static String formatDelTopDepRspnCreated( String separator, CFBamDelTopDepBuff buff ) {
		String retval = "<RspnDelTopDepCreated "
			+	formatDelTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRspnLocked( String separator, CFBamDelTopDepBuff buff ) {
		String retval = "<RspnDelTopDepLocked "
			+	formatDelTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRspnUpdated( String separator, CFBamDelTopDepBuff buff ) {
		String retval = "<RspnDelTopDepUpdated "
			+	formatDelTopDepBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatDelTopDepRspnDeleted() {
		String retval = "<RspnDelTopDepDeleted />";
		return( retval );
	}
}
