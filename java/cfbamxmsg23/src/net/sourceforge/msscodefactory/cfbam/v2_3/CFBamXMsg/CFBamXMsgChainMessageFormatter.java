
// Description: Java 7 XML Message message formatter for CFBam.Chain

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
 *	CFBamXMsgChainMessageFormatter XML message formatter
 *	for CFBam.Chain.
 */
public class CFBamXMsgChainMessageFormatter
{
	public CFBamXMsgChainMessageFormatter() {
	}

	public static String formatChainPKeyAttributes( String separator, CFBamChainPKey pkey ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( null,
				"TenantId",
				pkey.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
				"Id",
				pkey.getRequiredId() );
		return( retval );
	}

	public static String formatChainPKeyAttributes( String separator, CFBamChainBuff buff ) {
		String retval = CFLibXmlUtil.formatRequiredInt64( separator,
					"TenantId",
					buff.getRequiredTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					buff.getRequiredId() );
		return( retval );
	}

	public static String formatChainBuffAttributes( String separator, CFBamChainBuff buff ) {
		String retval = CFBamXMsgChainMessageFormatter.formatChainPKeyAttributes( separator, buff )
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
					"TableId",
					buff.getRequiredTableId() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"Suffix",
					buff.getOptionalSuffix() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"PrevRelationTenantId",
					buff.getRequiredPrevRelationTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"PrevRelationId",
					buff.getRequiredPrevRelationId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"NextRelationTenantId",
					buff.getRequiredNextRelationTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"NextRelationId",
					buff.getRequiredNextRelationId() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"DefaultVisibility",
					buff.getRequiredDefaultVisibility() );
		return( retval );
	}

	public static String formatChainRqstCreate( String separator, CFBamChainBuff buff ) {
		String retval = "<RqstChainCreate "
			+	formatChainBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstRead( String separator, CFBamChainPKey pkey ) {
		String retval = "<RqstChainRead "
			+	formatChainPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstRead( String separator, CFBamChainBuff buff ) {
		String retval = "<RqstChainRead "
			+	formatChainPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstChainRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstReadAll( String separator ) {
		String retval = "<RqstChainReadAll />";
		return( retval );
	}

	public static String formatChainRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstChainRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstChainReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstReadByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstChainReadByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstChainReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstChainReadByUNameIdx "
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

	public static String formatChainRqstReadByPrevRelIdx( String separator,
		long argPrevRelationTenantId,
		long argPrevRelationId )
	{
		String retval = "<RqstChainReadByPrevRelIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"PrevRelationTenantId",
					argPrevRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"PrevRelationId",
					argPrevRelationId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstReadByNextRelIdx( String separator,
		long argNextRelationTenantId,
		long argNextRelationId )
	{
		String retval = "<RqstChainReadByNextRelIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"NextRelationTenantId",
					argNextRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"NextRelationId",
					argNextRelationId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstLock( String separator, CFBamChainPKey pkey ) {
		String retval = "<RqstChainLock "
			+	formatChainPKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstLock( String separator, CFBamChainBuff buff ) {
		String retval = "<RqstChainLock "
			+	formatChainPKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstChainLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstUpdate( String separator, CFBamChainBuff buff ) {
		String retval = "<RqstChainUpdate "
			+	formatChainBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstDelete( String separator, CFBamChainBuff buff ) {
		String retval = "<RqstChainDelete "
				+	formatChainPKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatChainRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstChainDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstChainDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstDeleteByTableIdx( String separator,
		long argTenantId,
		long argTableId )
	{
		String retval = "<RqstChainDeleteByTableIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"TableId",
					argTableId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstChainDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argTableId,
		String argName )
	{
		String retval = "<RqstChainDeleteByUNameIdx "
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

	public static String formatChainRqstDeleteByPrevRelIdx( String separator,
		long argPrevRelationTenantId,
		long argPrevRelationId )
	{
		String retval = "<RqstChainDeleteByPrevRelIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"PrevRelationTenantId",
					argPrevRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"PrevRelationId",
					argPrevRelationId )
			+	" />";
		return( retval );
	}

	public static String formatChainRqstDeleteByNextRelIdx( String separator,
		long argNextRelationTenantId,
		long argNextRelationId )
	{
		String retval = "<RqstChainDeleteByNextRelIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"NextRelationTenantId",
					argNextRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"NextRelationId",
					argNextRelationId )
			+	" />";
		return( retval );
	}

	public static String formatChainRspnSingleOpenTag() {
		final String retval = "<RspnChainReadSingle>";
		return( retval );
	}

	public static String formatChainRspnSingleCloseTag() {
		final String retval = "</RspnChainReadSingle>";
		return( retval );
	}

	public static String formatChainRspnListOpenTag() {
		final String retval = "<RspnChainReadList>";
		return( retval );
	}

	public static String formatChainRspnListCloseTag() {
		final String retval = "</RspnChainReadList>";
		return( retval );
	}

	public static String formatChainRspnRec( String separator, CFBamChainBuff buff ) {
		String retval = "<Chain "
			+	formatChainBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatChainRspnDerivedRec( String separator, CFBamChainBuff buff ) {
		String retval;
		retval = formatChainRspnRec( separator, buff );
		return( retval );
	}

	public static String formatChainRspnCreated( String separator, CFBamChainBuff buff ) {
		String retval = "<RspnChainCreated "
			+	formatChainBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatChainRspnLocked( String separator, CFBamChainBuff buff ) {
		String retval = "<RspnChainLocked "
			+	formatChainBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatChainRspnUpdated( String separator, CFBamChainBuff buff ) {
		String retval = "<RspnChainUpdated "
			+	formatChainBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatChainRspnDeleted() {
		String retval = "<RspnChainDeleted />";
		return( retval );
	}
}
