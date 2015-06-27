
// Description: Java 7 XML Message message formatter for CFBam.PopSubDep3

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
 *	CFBamXMsgPopSubDep3MessageFormatter XML message formatter
 *	for CFBam.PopSubDep3.
 */
public class CFBamXMsgPopSubDep3MessageFormatter
	extends CFBamXMsgPopDepMessageFormatter
{
	public CFBamXMsgPopSubDep3MessageFormatter() {
		super();
	}

	public static String formatPopSubDep3BuffAttributes( String separator, CFBamPopSubDep3Buff buff ) {
		String retval = CFBamXMsgPopDepMessageFormatter.formatPopDepBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContTenantId",
					buff.getRequiredContTenantId() )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopDep2Id",
					buff.getRequiredContPopDep2Id() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() );
		return( retval );
	}

	public static String formatPopSubDep3RqstCreate( String separator, CFBamPopSubDep3Buff buff ) {
		String retval = "<RqstPopSubDep3Create "
			+	formatPopSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstPopSubDep3Read "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstRead( String separator, CFBamPopSubDep3Buff buff ) {
		String retval = "<RqstPopSubDep3Read "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep3Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstReadAll( String separator ) {
		String retval = "<RqstPopSubDep3ReadAll />";
		return( retval );
	}

	public static String formatPopSubDep3RqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep3Read "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstPopSubDep3ReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstReadByRelationIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstPopSubDep3ReadByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstPopSubDep3ReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstReadByContPopDep2Idx( String separator,
		long argContTenantId,
		long argContPopDep2Id )
	{
		String retval = "<RqstPopSubDep3ReadByContPopDep2Idx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopDep2Id",
					argContPopDep2Id )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstReadByUNameIdx( String separator,
		long argContTenantId,
		long argContPopDep2Id,
		String argName )
	{
		String retval = "<RqstPopSubDep3ReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopDep2Id",
					argContPopDep2Id )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstPopSubDep3Lock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstLock( String separator, CFBamPopSubDep3Buff buff ) {
		String retval = "<RqstPopSubDep3Lock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep3Lock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstUpdate( String separator, CFBamPopSubDep3Buff buff ) {
		String retval = "<RqstPopSubDep3Update "
			+	formatPopSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstDelete( String separator, CFBamPopSubDep3Buff buff ) {
		String retval = "<RqstPopSubDep3Delete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstPopSubDep3Delete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstPopSubDep3DeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstDeleteByRelationIdx( String separator,
		long argRelationTenantId,
		long argRelationId )
	{
		String retval = "<RqstPopSubDep3DeleteByRelationIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"RelationTenantId",
					argRelationTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"RelationId",
					argRelationId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstPopSubDep3DeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstDeleteByContPopDep2Idx( String separator,
		long argContTenantId,
		long argContPopDep2Id )
	{
		String retval = "<RqstPopSubDep3DeleteByContPopDep2Idx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopDep2Id",
					argContPopDep2Id )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RqstDeleteByUNameIdx( String separator,
		long argContTenantId,
		long argContPopDep2Id,
		String argName )
	{
		String retval = "<RqstPopSubDep3DeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"ContTenantId",
					argContTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"ContPopDep2Id",
					argContPopDep2Id )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RspnSingleOpenTag() {
		final String retval = "<RspnPopSubDep3ReadSingle>";
		return( retval );
	}

	public static String formatPopSubDep3RspnSingleCloseTag() {
		final String retval = "</RspnPopSubDep3ReadSingle>";
		return( retval );
	}

	public static String formatPopSubDep3RspnListOpenTag() {
		final String retval = "<RspnPopSubDep3ReadList>";
		return( retval );
	}

	public static String formatPopSubDep3RspnListCloseTag() {
		final String retval = "</RspnPopSubDep3ReadList>";
		return( retval );
	}

	public static String formatPopSubDep3RspnRec( String separator, CFBamPopSubDep3Buff buff ) {
		String retval = "<PopSubDep3 "
			+	formatPopSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RspnDerivedRec( String separator, CFBamPopSubDep3Buff buff ) {
		String retval;
		retval = formatPopSubDep3RspnRec( separator, buff );
		return( retval );
	}

	public static String formatPopSubDep3RspnCreated( String separator, CFBamPopSubDep3Buff buff ) {
		String retval = "<RspnPopSubDep3Created "
			+	formatPopSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RspnLocked( String separator, CFBamPopSubDep3Buff buff ) {
		String retval = "<RspnPopSubDep3Locked "
			+	formatPopSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RspnUpdated( String separator, CFBamPopSubDep3Buff buff ) {
		String retval = "<RspnPopSubDep3Updated "
			+	formatPopSubDep3BuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatPopSubDep3RspnDeleted() {
		String retval = "<RspnPopSubDep3Deleted />";
		return( retval );
	}
}
