
// Description: Java 7 XML Message message formatter for CFBam.Relation

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
 *	CFBamXMsgRelationMessageFormatter XML message formatter
 *	for CFBam.Relation.
 */
public class CFBamXMsgRelationMessageFormatter
	extends CFBamXMsgScopeMessageFormatter
{
	public CFBamXMsgRelationMessageFormatter() {
		super();
	}

	public static String formatRelationBuffAttributes( String separator, CFBamRelationBuff buff ) {
		String retval = CFBamXMsgScopeMessageFormatter.formatScopeBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					buff.getRequiredTableId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaTenantId",
					buff.getOptionalDefSchemaTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					buff.getOptionalDefSchemaId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"ShortName",
					buff.getOptionalShortName() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"Label",
					buff.getOptionalLabel() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"ShortDescription",
					buff.getOptionalShortDescription() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"Description",
					buff.getOptionalDescription() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"RelationTypeId",
					buff.getRequiredRelationTypeId() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"DbName",
					buff.getOptionalDbName() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"Suffix",
					buff.getOptionalSuffix() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"FromIndexId",
					buff.getRequiredFromIndexId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ToTableId",
					buff.getRequiredToTableId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ToIndexId",
					buff.getRequiredToIndexId() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsRequired",
					buff.getRequiredIsRequired() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsAbstract",
					buff.getRequiredIsAbstract() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsXsdContainer",
					buff.getRequiredIsXsdContainer() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NarrowedTenantId",
					buff.getOptionalNarrowedTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NarrowedId",
					buff.getOptionalNarrowedId() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"DefaultVisibility",
					buff.getRequiredDefaultVisibility() );
		return( retval );
	}

	public static String formatRelationRqstCreate( String separator, CFBamRelationBuff buff ) {
		String retval = "<RqstRelationCreate "
			+	formatRelationBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstRelationRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstRead( String separator, CFBamRelationBuff buff ) {
		String retval = "<RqstRelationRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRelationRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadAll( String separator ) {
		String retval = "<RqstRelationReadAll />";
		return( retval );
	}

	public static String formatRelationRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRelationRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstRelationReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstRelationReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadByRelnTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstRelationReadByRelnTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstRelationReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstRelationReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadByRTypeKeyIdx( String separator,
		short argRelationTypeId )
	{
		String retval = "<RqstRelationReadByRTypeKeyIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"RelationTypeId",
					argRelationTypeId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadByFromKeyIdx( String separator,
		long argTenantId,
		long argFromIndexId )
	{
		String retval = "<RqstRelationReadByFromKeyIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"FromIndexId",
					argFromIndexId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadByToTblIdx( String separator,
		long argTenantId,
		long argToTableId )
	{
		String retval = "<RqstRelationReadByToTblIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ToTableId",
					argToTableId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadByToKeyIdx( String separator,
		long argTenantId,
		long argToIndexId )
	{
		String retval = "<RqstRelationReadByToKeyIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ToIndexId",
					argToIndexId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstReadByNarrowedIdx( String separator,
		Long argNarrowedTenantId,
		Long argNarrowedId )
	{
		String retval = "<RqstRelationReadByNarrowedIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NarrowedTenantId",
					argNarrowedTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NarrowedId",
					argNarrowedId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstRelationLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstLock( String separator, CFBamRelationBuff buff ) {
		String retval = "<RqstRelationLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRelationLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstUpdate( String separator, CFBamRelationBuff buff ) {
		String retval = "<RqstRelationUpdate "
			+	formatRelationBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDelete( String separator, CFBamRelationBuff buff ) {
		String retval = "<RqstRelationDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRelationDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstRelationDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstRelationDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByRelnTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstRelationDeleteByRelnTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstRelationDeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstRelationDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByRTypeKeyIdx( String separator,
		short argRelationTypeId )
	{
		String retval = "<RqstRelationDeleteByRTypeKeyIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"RelationTypeId",
					argRelationTypeId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByFromKeyIdx( String separator,
		long argTenantId,
		long argFromIndexId )
	{
		String retval = "<RqstRelationDeleteByFromKeyIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"FromIndexId",
					argFromIndexId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByToTblIdx( String separator,
		long argTenantId,
		long argToTableId )
	{
		String retval = "<RqstRelationDeleteByToTblIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ToTableId",
					argToTableId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByToKeyIdx( String separator,
		long argTenantId,
		long argToIndexId )
	{
		String retval = "<RqstRelationDeleteByToKeyIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ToIndexId",
					argToIndexId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRqstDeleteByNarrowedIdx( String separator,
		Long argNarrowedTenantId,
		Long argNarrowedId )
	{
		String retval = "<RqstRelationDeleteByNarrowedIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NarrowedTenantId",
					argNarrowedTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NarrowedId",
					argNarrowedId )
			+	" />";
		return( retval );
	}

	public static String formatRelationRspnSingleOpenTag() {
		final String retval = "<RspnRelationReadSingle>";
		return( retval );
	}

	public static String formatRelationRspnSingleCloseTag() {
		final String retval = "</RspnRelationReadSingle>";
		return( retval );
	}

	public static String formatRelationRspnListOpenTag() {
		final String retval = "<RspnRelationReadList>";
		return( retval );
	}

	public static String formatRelationRspnListCloseTag() {
		final String retval = "</RspnRelationReadList>";
		return( retval );
	}

	public static String formatRelationRspnRec( String separator, CFBamRelationBuff buff ) {
		String retval = "<Relation "
			+	formatRelationBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationRspnDerivedRec( String separator, CFBamRelationBuff buff ) {
		String retval;
		retval = formatRelationRspnRec( separator, buff );
		return( retval );
	}

	public static String formatRelationRspnCreated( String separator, CFBamRelationBuff buff ) {
		String retval = "<RspnRelationCreated "
			+	formatRelationBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationRspnLocked( String separator, CFBamRelationBuff buff ) {
		String retval = "<RspnRelationLocked "
			+	formatRelationBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationRspnUpdated( String separator, CFBamRelationBuff buff ) {
		String retval = "<RspnRelationUpdated "
			+	formatRelationBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationRspnDeleted() {
		String retval = "<RspnRelationDeleted />";
		return( retval );
	}
}
