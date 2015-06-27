
// Description: Java 7 XML Message message formatter for CFBam.Atom

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
 *	CFBamXMsgAtomMessageFormatter XML message formatter
 *	for CFBam.Atom.
 */
public class CFBamXMsgAtomMessageFormatter
	extends CFBamXMsgValueMessageFormatter
{
	public CFBamXMsgAtomMessageFormatter() {
		super();
	}

	public static String formatAtomBuffAttributes( String separator, CFBamAtomBuff buff ) {
		String retval = CFBamXMsgValueMessageFormatter.formatValueBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"DbName",
					buff.getOptionalDbName() );
		return( retval );
	}

	public static String formatAtomRqstCreate( String separator, CFBamAtomBuff buff ) {
		String retval = "<RqstAtomCreate "
			+	formatAtomBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstRead( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstAtomRead "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstRead( String separator, CFBamAtomBuff buff ) {
		String retval = "<RqstAtomRead "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstAtomRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadAll( String separator ) {
		String retval = "<RqstAtomReadAll />";
		return( retval );
	}

	public static String formatAtomRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstAtomRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstAtomReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstAtomReadByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstAtomReadByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstAtomReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstAtomReadByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstAtomReadByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstAtomReadByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstAtomReadByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstAtomReadByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstAtomReadByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstAtomReadByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstAtomReadByContPrevIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstReadByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstAtomReadByContNextIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstLock( String separator, CFBamValuePKey pkey ) {
		String retval = "<RqstAtomLock "
			+	formatValuePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstLock( String separator, CFBamAtomBuff buff ) {
		String retval = "<RqstAtomLock "
			+	formatValuePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstAtomLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstUpdate( String separator, CFBamAtomBuff buff ) {
		String retval = "<RqstAtomUpdate "
			+	formatAtomBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDelete( String separator, CFBamAtomBuff buff ) {
		String retval = "<RqstAtomDelete "
				+	formatValuePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatAtomRqstMoveUp( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstAtomMoveUp "
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

	public static String formatAtomRqstMoveDown( String separator,
		long TenantId,
		long Id,
		int revision )
	{
		String retval = "<RqstAtomMoveDown "
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

	public static String formatAtomRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstAtomDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		String retval = "<RqstAtomDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByValTentIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstAtomDeleteByValTentIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByScopeIdx( String separator,
		long argTenantId,
		long argScopeId )
	{
		String retval = "<RqstAtomDeleteByScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstAtomDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstAtomDeleteByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstAtomDeleteByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstAtomDeleteByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstAtomDeleteByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstAtomDeleteByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByPrevIdx( String separator,
		Long argPrevTenantId,
		Long argPrevId )
	{
		String retval = "<RqstAtomDeleteByPrevIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrevTenantId",
					argPrevTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByNextIdx( String separator,
		Long argNextTenantId,
		Long argNextId )
	{
		String retval = "<RqstAtomDeleteByNextIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"NextTenantId",
					argNextTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByContPrevIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		String retval = "<RqstAtomDeleteByContPrevIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrevId",
					argPrevId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRqstDeleteByContNextIdx( String separator,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		String retval = "<RqstAtomDeleteByContNextIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ScopeId",
					argScopeId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"NextId",
					argNextId )
			+	" />";
		return( retval );
	}

	public static String formatAtomRspnSingleOpenTag() {
		final String retval = "<RspnAtomReadSingle>";
		return( retval );
	}

	public static String formatAtomRspnSingleCloseTag() {
		final String retval = "</RspnAtomReadSingle>";
		return( retval );
	}

	public static String formatAtomRspnListOpenTag() {
		final String retval = "<RspnAtomReadList>";
		return( retval );
	}

	public static String formatAtomRspnListCloseTag() {
		final String retval = "</RspnAtomReadList>";
		return( retval );
	}

	public static String formatAtomRspnRec( String separator, CFBamAtomBuff buff ) {
		String retval = "<Atom "
			+	formatAtomBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAtomRspnDerivedRec( String separator, CFBamAtomBuff buff ) {
		String retval;
		final String S_ProcName = "formatAtomRspnDerivedRec";
		String classCode = buff.getClassCode();
		if( classCode.equals( "ATOM" ) ) {
			retval = formatAtomRspnRec( separator, buff );
		}
		else if( classCode.equals( "BLBD" ) ) {
			retval = CFBamXMsgBlobDefMessageFormatter.formatBlobDefRspnRec( separator, (CFBamBlobDefBuff)buff );
		}
		else if( classCode.equals( "BLBC" ) ) {
			retval = CFBamXMsgBlobColMessageFormatter.formatBlobColRspnRec( separator, (CFBamBlobColBuff)buff );
		}
		else if( classCode.equals( "BLBT" ) ) {
			retval = CFBamXMsgBlobTypeMessageFormatter.formatBlobTypeRspnRec( separator, (CFBamBlobTypeBuff)buff );
		}
		else if( classCode.equals( "BOLD" ) ) {
			retval = CFBamXMsgBoolDefMessageFormatter.formatBoolDefRspnRec( separator, (CFBamBoolDefBuff)buff );
		}
		else if( classCode.equals( "BOLC" ) ) {
			retval = CFBamXMsgBoolColMessageFormatter.formatBoolColRspnRec( separator, (CFBamBoolColBuff)buff );
		}
		else if( classCode.equals( "BOLT" ) ) {
			retval = CFBamXMsgBoolTypeMessageFormatter.formatBoolTypeRspnRec( separator, (CFBamBoolTypeBuff)buff );
		}
		else if( classCode.equals( "I16D" ) ) {
			retval = CFBamXMsgInt16DefMessageFormatter.formatInt16DefRspnRec( separator, (CFBamInt16DefBuff)buff );
		}
		else if( classCode.equals( "I16C" ) ) {
			retval = CFBamXMsgInt16ColMessageFormatter.formatInt16ColRspnRec( separator, (CFBamInt16ColBuff)buff );
		}
		else if( classCode.equals( "I16T" ) ) {
			retval = CFBamXMsgInt16TypeMessageFormatter.formatInt16TypeRspnRec( separator, (CFBamInt16TypeBuff)buff );
		}
		else if( classCode.equals( "IG16" ) ) {
			retval = CFBamXMsgId16GenMessageFormatter.formatId16GenRspnRec( separator, (CFBamId16GenBuff)buff );
		}
		else if( classCode.equals( "ENMD" ) ) {
			retval = CFBamXMsgEnumDefMessageFormatter.formatEnumDefRspnRec( separator, (CFBamEnumDefBuff)buff );
		}
		else if( classCode.equals( "ENMC" ) ) {
			retval = CFBamXMsgEnumColMessageFormatter.formatEnumColRspnRec( separator, (CFBamEnumColBuff)buff );
		}
		else if( classCode.equals( "ENMT" ) ) {
			retval = CFBamXMsgEnumTypeMessageFormatter.formatEnumTypeRspnRec( separator, (CFBamEnumTypeBuff)buff );
		}
		else if( classCode.equals( "I32D" ) ) {
			retval = CFBamXMsgInt32DefMessageFormatter.formatInt32DefRspnRec( separator, (CFBamInt32DefBuff)buff );
		}
		else if( classCode.equals( "I32C" ) ) {
			retval = CFBamXMsgInt32ColMessageFormatter.formatInt32ColRspnRec( separator, (CFBamInt32ColBuff)buff );
		}
		else if( classCode.equals( "I32T" ) ) {
			retval = CFBamXMsgInt32TypeMessageFormatter.formatInt32TypeRspnRec( separator, (CFBamInt32TypeBuff)buff );
		}
		else if( classCode.equals( "IG32" ) ) {
			retval = CFBamXMsgId32GenMessageFormatter.formatId32GenRspnRec( separator, (CFBamId32GenBuff)buff );
		}
		else if( classCode.equals( "I64D" ) ) {
			retval = CFBamXMsgInt64DefMessageFormatter.formatInt64DefRspnRec( separator, (CFBamInt64DefBuff)buff );
		}
		else if( classCode.equals( "I64C" ) ) {
			retval = CFBamXMsgInt64ColMessageFormatter.formatInt64ColRspnRec( separator, (CFBamInt64ColBuff)buff );
		}
		else if( classCode.equals( "I64T" ) ) {
			retval = CFBamXMsgInt64TypeMessageFormatter.formatInt64TypeRspnRec( separator, (CFBamInt64TypeBuff)buff );
		}
		else if( classCode.equals( "IG64" ) ) {
			retval = CFBamXMsgId64GenMessageFormatter.formatId64GenRspnRec( separator, (CFBamId64GenBuff)buff );
		}
		else if( classCode.equals( "U16D" ) ) {
			retval = CFBamXMsgUInt16DefMessageFormatter.formatUInt16DefRspnRec( separator, (CFBamUInt16DefBuff)buff );
		}
		else if( classCode.equals( "U16C" ) ) {
			retval = CFBamXMsgUInt16ColMessageFormatter.formatUInt16ColRspnRec( separator, (CFBamUInt16ColBuff)buff );
		}
		else if( classCode.equals( "U16T" ) ) {
			retval = CFBamXMsgUInt16TypeMessageFormatter.formatUInt16TypeRspnRec( separator, (CFBamUInt16TypeBuff)buff );
		}
		else if( classCode.equals( "U32D" ) ) {
			retval = CFBamXMsgUInt32DefMessageFormatter.formatUInt32DefRspnRec( separator, (CFBamUInt32DefBuff)buff );
		}
		else if( classCode.equals( "U32C" ) ) {
			retval = CFBamXMsgUInt32ColMessageFormatter.formatUInt32ColRspnRec( separator, (CFBamUInt32ColBuff)buff );
		}
		else if( classCode.equals( "U32T" ) ) {
			retval = CFBamXMsgUInt32TypeMessageFormatter.formatUInt32TypeRspnRec( separator, (CFBamUInt32TypeBuff)buff );
		}
		else if( classCode.equals( "U64D" ) ) {
			retval = CFBamXMsgUInt64DefMessageFormatter.formatUInt64DefRspnRec( separator, (CFBamUInt64DefBuff)buff );
		}
		else if( classCode.equals( "U64C" ) ) {
			retval = CFBamXMsgUInt64ColMessageFormatter.formatUInt64ColRspnRec( separator, (CFBamUInt64ColBuff)buff );
		}
		else if( classCode.equals( "U64T" ) ) {
			retval = CFBamXMsgUInt64TypeMessageFormatter.formatUInt64TypeRspnRec( separator, (CFBamUInt64TypeBuff)buff );
		}
		else if( classCode.equals( "FLTD" ) ) {
			retval = CFBamXMsgFloatDefMessageFormatter.formatFloatDefRspnRec( separator, (CFBamFloatDefBuff)buff );
		}
		else if( classCode.equals( "FLTC" ) ) {
			retval = CFBamXMsgFloatColMessageFormatter.formatFloatColRspnRec( separator, (CFBamFloatColBuff)buff );
		}
		else if( classCode.equals( "FLTT" ) ) {
			retval = CFBamXMsgFloatTypeMessageFormatter.formatFloatTypeRspnRec( separator, (CFBamFloatTypeBuff)buff );
		}
		else if( classCode.equals( "DBLD" ) ) {
			retval = CFBamXMsgDoubleDefMessageFormatter.formatDoubleDefRspnRec( separator, (CFBamDoubleDefBuff)buff );
		}
		else if( classCode.equals( "DBLC" ) ) {
			retval = CFBamXMsgDoubleColMessageFormatter.formatDoubleColRspnRec( separator, (CFBamDoubleColBuff)buff );
		}
		else if( classCode.equals( "DBLT" ) ) {
			retval = CFBamXMsgDoubleTypeMessageFormatter.formatDoubleTypeRspnRec( separator, (CFBamDoubleTypeBuff)buff );
		}
		else if( classCode.equals( "NUMD" ) ) {
			retval = CFBamXMsgNumberDefMessageFormatter.formatNumberDefRspnRec( separator, (CFBamNumberDefBuff)buff );
		}
		else if( classCode.equals( "NUMC" ) ) {
			retval = CFBamXMsgNumberColMessageFormatter.formatNumberColRspnRec( separator, (CFBamNumberColBuff)buff );
		}
		else if( classCode.equals( "NUMT" ) ) {
			retval = CFBamXMsgNumberTypeMessageFormatter.formatNumberTypeRspnRec( separator, (CFBamNumberTypeBuff)buff );
		}
		else if( classCode.equals( "STRD" ) ) {
			retval = CFBamXMsgStringDefMessageFormatter.formatStringDefRspnRec( separator, (CFBamStringDefBuff)buff );
		}
		else if( classCode.equals( "STRC" ) ) {
			retval = CFBamXMsgStringColMessageFormatter.formatStringColRspnRec( separator, (CFBamStringColBuff)buff );
		}
		else if( classCode.equals( "STRT" ) ) {
			retval = CFBamXMsgStringTypeMessageFormatter.formatStringTypeRspnRec( separator, (CFBamStringTypeBuff)buff );
		}
		else if( classCode.equals( "TXTD" ) ) {
			retval = CFBamXMsgTextDefMessageFormatter.formatTextDefRspnRec( separator, (CFBamTextDefBuff)buff );
		}
		else if( classCode.equals( "TXTC" ) ) {
			retval = CFBamXMsgTextColMessageFormatter.formatTextColRspnRec( separator, (CFBamTextColBuff)buff );
		}
		else if( classCode.equals( "TXTT" ) ) {
			retval = CFBamXMsgTextTypeMessageFormatter.formatTextTypeRspnRec( separator, (CFBamTextTypeBuff)buff );
		}
		else if( classCode.equals( "NTKD" ) ) {
			retval = CFBamXMsgNmTokenDefMessageFormatter.formatNmTokenDefRspnRec( separator, (CFBamNmTokenDefBuff)buff );
		}
		else if( classCode.equals( "NTKC" ) ) {
			retval = CFBamXMsgNmTokenColMessageFormatter.formatNmTokenColRspnRec( separator, (CFBamNmTokenColBuff)buff );
		}
		else if( classCode.equals( "NTKT" ) ) {
			retval = CFBamXMsgNmTokenTypeMessageFormatter.formatNmTokenTypeRspnRec( separator, (CFBamNmTokenTypeBuff)buff );
		}
		else if( classCode.equals( "NTSD" ) ) {
			retval = CFBamXMsgNmTokensDefMessageFormatter.formatNmTokensDefRspnRec( separator, (CFBamNmTokensDefBuff)buff );
		}
		else if( classCode.equals( "NTSC" ) ) {
			retval = CFBamXMsgNmTokensColMessageFormatter.formatNmTokensColRspnRec( separator, (CFBamNmTokensColBuff)buff );
		}
		else if( classCode.equals( "NTST" ) ) {
			retval = CFBamXMsgNmTokensTypeMessageFormatter.formatNmTokensTypeRspnRec( separator, (CFBamNmTokensTypeBuff)buff );
		}
		else if( classCode.equals( "TKND" ) ) {
			retval = CFBamXMsgTokenDefMessageFormatter.formatTokenDefRspnRec( separator, (CFBamTokenDefBuff)buff );
		}
		else if( classCode.equals( "TKNC" ) ) {
			retval = CFBamXMsgTokenColMessageFormatter.formatTokenColRspnRec( separator, (CFBamTokenColBuff)buff );
		}
		else if( classCode.equals( "TKNT" ) ) {
			retval = CFBamXMsgTokenTypeMessageFormatter.formatTokenTypeRspnRec( separator, (CFBamTokenTypeBuff)buff );
		}
		else if( classCode.equals( "DATD" ) ) {
			retval = CFBamXMsgDateDefMessageFormatter.formatDateDefRspnRec( separator, (CFBamDateDefBuff)buff );
		}
		else if( classCode.equals( "DATC" ) ) {
			retval = CFBamXMsgDateColMessageFormatter.formatDateColRspnRec( separator, (CFBamDateColBuff)buff );
		}
		else if( classCode.equals( "DATT" ) ) {
			retval = CFBamXMsgDateTypeMessageFormatter.formatDateTypeRspnRec( separator, (CFBamDateTypeBuff)buff );
		}
		else if( classCode.equals( "TIMD" ) ) {
			retval = CFBamXMsgTimeDefMessageFormatter.formatTimeDefRspnRec( separator, (CFBamTimeDefBuff)buff );
		}
		else if( classCode.equals( "TIMC" ) ) {
			retval = CFBamXMsgTimeColMessageFormatter.formatTimeColRspnRec( separator, (CFBamTimeColBuff)buff );
		}
		else if( classCode.equals( "TIMT" ) ) {
			retval = CFBamXMsgTimeTypeMessageFormatter.formatTimeTypeRspnRec( separator, (CFBamTimeTypeBuff)buff );
		}
		else if( classCode.equals( "TSPD" ) ) {
			retval = CFBamXMsgTimestampDefMessageFormatter.formatTimestampDefRspnRec( separator, (CFBamTimestampDefBuff)buff );
		}
		else if( classCode.equals( "TSPC" ) ) {
			retval = CFBamXMsgTimestampColMessageFormatter.formatTimestampColRspnRec( separator, (CFBamTimestampColBuff)buff );
		}
		else if( classCode.equals( "TSPT" ) ) {
			retval = CFBamXMsgTimestampTypeMessageFormatter.formatTimestampTypeRspnRec( separator, (CFBamTimestampTypeBuff)buff );
		}
		else if( classCode.equals( "DAZD" ) ) {
			retval = CFBamXMsgTZDateDefMessageFormatter.formatTZDateDefRspnRec( separator, (CFBamTZDateDefBuff)buff );
		}
		else if( classCode.equals( "DAZC" ) ) {
			retval = CFBamXMsgTZDateColMessageFormatter.formatTZDateColRspnRec( separator, (CFBamTZDateColBuff)buff );
		}
		else if( classCode.equals( "DAZT" ) ) {
			retval = CFBamXMsgTZDateTypeMessageFormatter.formatTZDateTypeRspnRec( separator, (CFBamTZDateTypeBuff)buff );
		}
		else if( classCode.equals( "TMZD" ) ) {
			retval = CFBamXMsgTZTimeDefMessageFormatter.formatTZTimeDefRspnRec( separator, (CFBamTZTimeDefBuff)buff );
		}
		else if( classCode.equals( "TMZC" ) ) {
			retval = CFBamXMsgTZTimeColMessageFormatter.formatTZTimeColRspnRec( separator, (CFBamTZTimeColBuff)buff );
		}
		else if( classCode.equals( "TMZT" ) ) {
			retval = CFBamXMsgTZTimeTypeMessageFormatter.formatTZTimeTypeRspnRec( separator, (CFBamTZTimeTypeBuff)buff );
		}
		else if( classCode.equals( "ZSTD" ) ) {
			retval = CFBamXMsgTZTimestampDefMessageFormatter.formatTZTimestampDefRspnRec( separator, (CFBamTZTimestampDefBuff)buff );
		}
		else if( classCode.equals( "ZSTC" ) ) {
			retval = CFBamXMsgTZTimestampColMessageFormatter.formatTZTimestampColRspnRec( separator, (CFBamTZTimestampColBuff)buff );
		}
		else if( classCode.equals( "ZSTT" ) ) {
			retval = CFBamXMsgTZTimestampTypeMessageFormatter.formatTZTimestampTypeRspnRec( separator, (CFBamTZTimestampTypeBuff)buff );
		}
		else if( classCode.equals( "UIDD" ) ) {
			retval = CFBamXMsgUuidDefMessageFormatter.formatUuidDefRspnRec( separator, (CFBamUuidDefBuff)buff );
		}
		else if( classCode.equals( "UIDC" ) ) {
			retval = CFBamXMsgUuidColMessageFormatter.formatUuidColRspnRec( separator, (CFBamUuidColBuff)buff );
		}
		else if( classCode.equals( "UIDT" ) ) {
			retval = CFBamXMsgUuidTypeMessageFormatter.formatUuidTypeRspnRec( separator, (CFBamUuidTypeBuff)buff );
		}
		else if( classCode.equals( "IGUU" ) ) {
			retval = CFBamXMsgUuidGenMessageFormatter.formatUuidGenRspnRec( separator, (CFBamUuidGenBuff)buff );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( CFBamXMsgAtomMessageFormatter.class,
				S_ProcName,
				"buff",
				buff,
				"derivative of Atom" );
		}
		return( retval );
	}

	public static String formatAtomRspnCreated( String separator, CFBamAtomBuff buff ) {
		String retval = "<RspnAtomCreated "
			+	formatAtomBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAtomRspnLocked( String separator, CFBamAtomBuff buff ) {
		String retval = "<RspnAtomLocked "
			+	formatAtomBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAtomRspnUpdated( String separator, CFBamAtomBuff buff ) {
		String retval = "<RspnAtomUpdated "
			+	formatAtomBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatAtomRspnDeleted() {
		String retval = "<RspnAtomDeleted />";
		return( retval );
	}
}
