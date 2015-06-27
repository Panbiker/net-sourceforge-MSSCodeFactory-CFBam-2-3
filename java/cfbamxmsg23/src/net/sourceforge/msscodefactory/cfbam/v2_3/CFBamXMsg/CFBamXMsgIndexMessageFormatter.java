
// Description: Java 7 XML Message message formatter for CFBam.Index

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
 *	CFBamXMsgIndexMessageFormatter XML message formatter
 *	for CFBam.Index.
 */
public class CFBamXMsgIndexMessageFormatter
	extends CFBamXMsgScopeMessageFormatter
{
	public CFBamXMsgIndexMessageFormatter() {
		super();
	}

	public static String formatIndexBuffAttributes( String separator, CFBamIndexBuff buff ) {
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
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"DbName",
					buff.getOptionalDbName() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"Suffix",
					buff.getOptionalSuffix() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsUnique",
					buff.getRequiredIsUnique() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsDbMapped",
					buff.getRequiredIsDbMapped() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"DefaultVisibility",
					buff.getRequiredDefaultVisibility() );
		return( retval );
	}

	public static String formatIndexRqstCreate( String separator, CFBamIndexBuff buff ) {
		String retval = "<RqstIndexCreate "
			+	formatIndexBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstIndexRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstRead( String separator, CFBamIndexBuff buff ) {
		String retval = "<RqstIndexRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstIndexRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstReadAll( String separator ) {
		String retval = "<RqstIndexReadAll />";
		return( retval );
	}

	public static String formatIndexRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstIndexRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstIndexReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstIndexReadByUNameIdx "
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

	public static String formatIndexRqstReadByIndexTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstIndexReadByIndexTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstReadByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstIndexReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstIndexReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstIndexLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstLock( String separator, CFBamIndexBuff buff ) {
		String retval = "<RqstIndexLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstIndexLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstUpdate( String separator, CFBamIndexBuff buff ) {
		String retval = "<RqstIndexUpdate "
			+	formatIndexBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstDelete( String separator, CFBamIndexBuff buff ) {
		String retval = "<RqstIndexDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatIndexRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstIndexDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstIndexDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstIndexDeleteByUNameIdx "
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

	public static String formatIndexRqstDeleteByIndexTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstIndexDeleteByIndexTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstDeleteByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstIndexDeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstIndexDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatIndexRspnSingleOpenTag() {
		final String retval = "<RspnIndexReadSingle>";
		return( retval );
	}

	public static String formatIndexRspnSingleCloseTag() {
		final String retval = "</RspnIndexReadSingle>";
		return( retval );
	}

	public static String formatIndexRspnListOpenTag() {
		final String retval = "<RspnIndexReadList>";
		return( retval );
	}

	public static String formatIndexRspnListCloseTag() {
		final String retval = "</RspnIndexReadList>";
		return( retval );
	}

	public static String formatIndexRspnRec( String separator, CFBamIndexBuff buff ) {
		String retval = "<Index "
			+	formatIndexBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexRspnDerivedRec( String separator, CFBamIndexBuff buff ) {
		String retval;
		retval = formatIndexRspnRec( separator, buff );
		return( retval );
	}

	public static String formatIndexRspnCreated( String separator, CFBamIndexBuff buff ) {
		String retval = "<RspnIndexCreated "
			+	formatIndexBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexRspnLocked( String separator, CFBamIndexBuff buff ) {
		String retval = "<RspnIndexLocked "
			+	formatIndexBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexRspnUpdated( String separator, CFBamIndexBuff buff ) {
		String retval = "<RspnIndexUpdated "
			+	formatIndexBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatIndexRspnDeleted() {
		String retval = "<RspnIndexDeleted />";
		return( retval );
	}
}
