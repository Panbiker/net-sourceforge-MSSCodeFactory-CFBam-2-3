
// Description: Java 7 XML Message message formatter for CFBam.RelationCol

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
 *	CFBamXMsgRelationColMessageFormatter XML message formatter
 *	for CFBam.RelationCol.
 */
public class CFBamXMsgRelationColMessageFormatter
{
	public CFBamXMsgRelationColMessageFormatter() {
	}

	public static String formatRelationColPKeyAttributes( String separator, CFBamRelationColPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatRelationColPKeyAttributes( String separator, CFBamRelationColBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatRelationColBuffAttributes( String separator, CFBamRelationColBuff buff ) {
		String retval = CFBamXMsgRelationColMessageFormatter.formatRelationColPKeyAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt32( separator,
					"Revision",
					buff.getRequiredRevision() )
			+	CFLibXmlUtil.formatOptionalUuid( separator,
					"CreatedBy",
					buff.getCreatedByUserId() )
			+	CFLibXmlUtil.formatOptionalTimestamp( separator,
					"CreatedAt",
					buff.getCreatedAt() )
			+	CFLibXmlUtil.formatOptionalUuid( separator,
					"UpdatedBy",
					buff.getUpdatedByUserId() )
			+	CFLibXmlUtil.formatOptionalTimestamp( separator,
					"UpdatedAt",
					buff.getUpdatedAt() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					buff.getRequiredRelationId() )
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
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"FromColId",
					buff.getRequiredFromColId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ToColId",
					buff.getRequiredToColId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevTenantId",
					buff.getOptionalPrevTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					buff.getOptionalPrevId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextTenantId",
					buff.getOptionalNextTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					buff.getOptionalNextId() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"DefaultVisibility",
					buff.getRequiredDefaultVisibility() );
		return( retval );
	}

	public static String formatRelationColRqstCreate( String separator, CFBamRelationColBuff buff ) {
		String retval = "<RqstRelationColCreate "
			+	formatRelationColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstRead( String separator, CFBamRelationColPKey pkey ) {
		String retval = "<RqstRelationColRead "
			+	formatRelationColPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstRead( String separator, CFBamRelationColBuff buff ) {
		String retval = "<RqstRelationColRead "
			+	formatRelationColPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRelationColRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadAll( String separator ) {
		String retval = "<RqstRelationColReadAll />";
		return( retval );
	}

	public static String formatRelationColRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRelationColRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argRelationId,
		String argName )
	{
		String retval = "<RqstRelationColReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadByRelColTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstRelationColReadByRelColTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadByRelationIdx( String separator,
		long argTenantId,
		long argRelationId )
	{
		String retval = "<RqstRelationColReadByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstRelationColReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadByFromColIdx( String separator,
		long argTenantId,
		long argFromColId )
	{
		String retval = "<RqstRelationColReadByFromColIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"FromColId",
					argFromColId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadByToColIdx( String separator,
		long argTenantId,
		long argToColId )
	{
		String retval = "<RqstRelationColReadByToColIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ToColId",
					argToColId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstRelationColReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstRelationColReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadByRelPrevIdx( String separator,
		long argTenantId,
		long argRelationId,
		Long argPrevId )
	{
		String retval = "<RqstRelationColReadByRelPrevIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstReadByRelNextIdx( String separator,
		long argTenantId,
		long argRelationId,
		Long argNextId )
	{
		String retval = "<RqstRelationColReadByRelNextIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstLock( String separator, CFBamRelationColPKey pkey ) {
		String retval = "<RqstRelationColLock "
			+	formatRelationColPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstLock( String separator, CFBamRelationColBuff buff ) {
		String retval = "<RqstRelationColLock "
			+	formatRelationColPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRelationColLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstUpdate( String separator, CFBamRelationColBuff buff ) {
		String retval = "<RqstRelationColUpdate "
			+	formatRelationColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDelete( String separator, CFBamRelationColBuff buff ) {
		String retval = "<RqstRelationColDelete "
				+	formatRelationColPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatRelationColRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstRelationColMoveUp "
				+	CFLibXmlUtil.formatRequiredInt64( separator,
						"TenantId",
						TenantId )
				+	CFLibXmlUtil.formatRequiredInt64( separator,
						"Id",
						Id )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						revision )
				+	" />";
		return( retval );
	}

	public static String formatRelationColRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstRelationColMoveDown "
				+	CFLibXmlUtil.formatRequiredInt64( separator,
						"TenantId",
						TenantId )
				+	CFLibXmlUtil.formatRequiredInt64( separator,
						"Id",
						Id )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						revision )
				+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstRelationColDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argRelationId,
		String argName )
	{
		String retval = "<RqstRelationColDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByRelColTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstRelationColDeleteByRelColTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByRelationIdx( String separator,
		long argTenantId,
		long argRelationId )
	{
		String retval = "<RqstRelationColDeleteByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstRelationColDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByFromColIdx( String separator,
		long argTenantId,
		long argFromColId )
	{
		String retval = "<RqstRelationColDeleteByFromColIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"FromColId",
					argFromColId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByToColIdx( String separator,
		long argTenantId,
		long argToColId )
	{
		String retval = "<RqstRelationColDeleteByToColIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ToColId",
					argToColId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstRelationColDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstRelationColDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByRelPrevIdx( String separator,
		long argTenantId,
		long argRelationId,
		Long argPrevId )
	{
		String retval = "<RqstRelationColDeleteByRelPrevIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRqstDeleteByRelNextIdx( String separator,
		long argTenantId,
		long argRelationId,
		Long argNextId )
	{
		String retval = "<RqstRelationColDeleteByRelNextIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRspnSingleOpenTag() {
		final String retval = "<RspnRelationColReadSingle>";
		return( retval );
	}

	public static String formatRelationColRspnSingleCloseTag() {
		final String retval = "</RspnRelationColReadSingle>";
		return( retval );
	}

	public static String formatRelationColRspnListOpenTag() {
		final String retval = "<RspnRelationColReadList>";
		return( retval );
	}

	public static String formatRelationColRspnListCloseTag() {
		final String retval = "</RspnRelationColReadList>";
		return( retval );
	}

	public static String formatRelationColRspnRec( String separator, CFBamRelationColBuff buff ) {
		String retval = "<RelationCol "
			+	formatRelationColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRspnDerivedRec( String separator, CFBamRelationColBuff buff ) {
		String retval;
		retval = formatRelationColRspnRec( separator, buff );
		return( retval );
	}

	public static String formatRelationColRspnCreated( String separator, CFBamRelationColBuff buff ) {
		String retval = "<RspnRelationColCreated "
			+	formatRelationColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRspnLocked( String separator, CFBamRelationColBuff buff ) {
		String retval = "<RspnRelationColLocked "
			+	formatRelationColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRspnUpdated( String separator, CFBamRelationColBuff buff ) {
		String retval = "<RspnRelationColUpdated "
			+	formatRelationColBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatRelationColRspnDeleted() {
		String retval = "<RspnRelationColDeleted />";
		return( retval );
	}
}
