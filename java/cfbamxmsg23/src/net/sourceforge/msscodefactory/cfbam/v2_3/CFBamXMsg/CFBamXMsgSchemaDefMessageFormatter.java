
// Description: Java 7 XML Message message formatter for CFBam.SchemaDef

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
 *	CFBamXMsgSchemaDefMessageFormatter XML message formatter
 *	for CFBam.SchemaDef.
 */
public class CFBamXMsgSchemaDefMessageFormatter
	extends CFBamXMsgScopeMessageFormatter
{
	public CFBamXMsgSchemaDefMessageFormatter() {
		super();
	}

	public static String formatSchemaDefBuffAttributes( String separator, CFBamSchemaDefBuff buff ) {
		String retval = CFBamXMsgScopeMessageFormatter.formatScopeBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					buff.getRequiredDomainId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					buff.getRequiredName() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"DbName",
					buff.getOptionalDbName() )
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
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefaultLicenseTenantId",
					buff.getOptionalDefaultLicenseTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefaultLicenseId",
					buff.getOptionalDefaultLicenseId() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"ExtendCFCore",
					buff.getRequiredExtendCFCore() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"DataScopeId",
					buff.getOptionalDataScopeId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"ViewAccessSecurityId",
					buff.getOptionalViewAccessSecurityId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"EditAccessSecurityId",
					buff.getOptionalEditAccessSecurityId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"ViewAccessFrequencyId",
					buff.getOptionalViewAccessFrequencyId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"EditAccessFrequencyId",
					buff.getOptionalEditAccessFrequencyId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"CopyrightPeriod",
					buff.getRequiredCopyrightPeriod() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"CopyrightHolder",
					buff.getRequiredCopyrightHolder() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"PublishURI",
					buff.getRequiredPublishURI() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSchemaObjImport",
					buff.getOptionalJSchemaObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSchemaObjInterface",
					buff.getOptionalJSchemaObjInterface() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSchemaObjMembers",
					buff.getOptionalJSchemaObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSchemaObjImplementation",
					buff.getOptionalJSchemaObjImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JDb2LUWSchemaObjMembers",
					buff.getOptionalJDb2LUWSchemaObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JDb2LUWSchemaObjImpl",
					buff.getOptionalJDb2LUWSchemaObjImpl() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JDb2LUWSchemaObjImport",
					buff.getOptionalJDb2LUWSchemaObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMSSqlSchemaObjMembers",
					buff.getOptionalJMSSqlSchemaObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMSSqlSchemaObjImpl",
					buff.getOptionalJMSSqlSchemaObjImpl() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMSSqlSchemaObjImport",
					buff.getOptionalJMSSqlSchemaObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMySqlSchemaObjMembers",
					buff.getOptionalJMySqlSchemaObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMySqlSchemaObjImpl",
					buff.getOptionalJMySqlSchemaObjImpl() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMySqlSchemaObjImport",
					buff.getOptionalJMySqlSchemaObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JOracleSchemaObjMembers",
					buff.getOptionalJOracleSchemaObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JOracleSchemaObjImpl",
					buff.getOptionalJOracleSchemaObjImpl() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JOracleSchemaObjImport",
					buff.getOptionalJOracleSchemaObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JPgSqlSchemaObjMembers",
					buff.getOptionalJPgSqlSchemaObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JPgSqlSchemaObjImpl",
					buff.getOptionalJPgSqlSchemaObjImpl() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JPgSqlSchemaObjImport",
					buff.getOptionalJPgSqlSchemaObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSybaseSchemaObjMembers",
					buff.getOptionalJSybaseSchemaObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSybaseSchemaObjImpl",
					buff.getOptionalJSybaseSchemaObjImpl() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSybaseSchemaObjImport",
					buff.getOptionalJSybaseSchemaObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JRamSchemaObjMembers",
					buff.getOptionalJRamSchemaObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JRamSchemaObjImpl",
					buff.getOptionalJRamSchemaObjImpl() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JRamSchemaObjImport",
					buff.getOptionalJRamSchemaObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgSchemaImport",
					buff.getOptionalJXMsgSchemaImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgSchemaFormatters",
					buff.getOptionalJXMsgSchemaFormatters() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgClientSchemaImport",
					buff.getOptionalJXMsgClientSchemaImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgClientSchemaBody",
					buff.getOptionalJXMsgClientSchemaBody() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRqstSchemaBody",
					buff.getOptionalJXMsgRqstSchemaBody() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRqstSchemaImport",
					buff.getOptionalJXMsgRqstSchemaImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRqstSchemaWireParsers",
					buff.getOptionalJXMsgRqstSchemaWireParsers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRqstSchemaXsdSpec",
					buff.getOptionalJXMsgRqstSchemaXsdSpec() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRqstSchemaXsdElementList",
					buff.getOptionalJXMsgRqstSchemaXsdElementList() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRspnSchemaBody",
					buff.getOptionalJXMsgRspnSchemaBody() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRspnSchemaImport",
					buff.getOptionalJXMsgRspnSchemaImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRspnSchemaWireParsers",
					buff.getOptionalJXMsgRspnSchemaWireParsers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRspnSchemaXsdElementList",
					buff.getOptionalJXMsgRspnSchemaXsdElementList() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRspnSchemaXsdSpec",
					buff.getOptionalJXMsgRspnSchemaXsdSpec() );
		return( retval );
	}

	public static String formatSchemaDefRqstCreate( String separator, CFBamSchemaDefBuff buff ) {
		String retval = "<RqstSchemaDefCreate "
			+	formatSchemaDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstSchemaDefRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstRead( String separator, CFBamSchemaDefBuff buff ) {
		String retval = "<RqstSchemaDefRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstSchemaDefRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadAll( String separator ) {
		String retval = "<RqstSchemaDefReadAll />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstSchemaDefRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstSchemaDefReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByCTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstSchemaDefReadByCTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByDomainIdx( String separator,
		long argTenantId,
		long argDomainId )
	{
		String retval = "<RqstSchemaDefReadByDomainIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argDomainId,
		String argName )
	{
		String retval = "<RqstSchemaDefReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByDefLcnIdx( String separator,
		Long argDefaultLicenseTenantId,
		Long argDefaultLicenseId )
	{
		String retval = "<RqstSchemaDefReadByDefLcnIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefaultLicenseTenantId",
					argDefaultLicenseTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefaultLicenseId",
					argDefaultLicenseId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstSchemaDefReadByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstSchemaDefReadByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstSchemaDefReadByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstSchemaDefReadByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstSchemaDefReadByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstReadByPubURIIdx( String separator,
		long argTenantId,
		String argPublishURI )
	{
		String retval = "<RqstSchemaDefReadByPubURIIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"PublishURI",
					argPublishURI )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstSchemaDefLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstLock( String separator, CFBamSchemaDefBuff buff ) {
		String retval = "<RqstSchemaDefLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstSchemaDefLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstUpdate( String separator, CFBamSchemaDefBuff buff ) {
		String retval = "<RqstSchemaDefUpdate "
			+	formatSchemaDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDelete( String separator, CFBamSchemaDefBuff buff ) {
		String retval = "<RqstSchemaDefDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstSchemaDefDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstSchemaDefDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByCTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstSchemaDefDeleteByCTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByDomainIdx( String separator,
		long argTenantId,
		long argDomainId )
	{
		String retval = "<RqstSchemaDefDeleteByDomainIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argDomainId,
		String argName )
	{
		String retval = "<RqstSchemaDefDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"DomainId",
					argDomainId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByDefLcnIdx( String separator,
		Long argDefaultLicenseTenantId,
		Long argDefaultLicenseId )
	{
		String retval = "<RqstSchemaDefDeleteByDefLcnIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefaultLicenseTenantId",
					argDefaultLicenseTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefaultLicenseId",
					argDefaultLicenseId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstSchemaDefDeleteByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstSchemaDefDeleteByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstSchemaDefDeleteByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstSchemaDefDeleteByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstSchemaDefDeleteByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRqstDeleteByPubURIIdx( String separator,
		long argTenantId,
		String argPublishURI )
	{
		String retval = "<RqstSchemaDefDeleteByPubURIIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"PublishURI",
					argPublishURI )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRspnSingleOpenTag() {
		final String retval = "<RspnSchemaDefReadSingle>";
		return( retval );
	}

	public static String formatSchemaDefRspnSingleCloseTag() {
		final String retval = "</RspnSchemaDefReadSingle>";
		return( retval );
	}

	public static String formatSchemaDefRspnListOpenTag() {
		final String retval = "<RspnSchemaDefReadList>";
		return( retval );
	}

	public static String formatSchemaDefRspnListCloseTag() {
		final String retval = "</RspnSchemaDefReadList>";
		return( retval );
	}

	public static String formatSchemaDefRspnRec( String separator, CFBamSchemaDefBuff buff ) {
		String retval = "<SchemaDef "
			+	formatSchemaDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRspnDerivedRec( String separator, CFBamSchemaDefBuff buff ) {
		String retval;
		retval = formatSchemaDefRspnRec( separator, buff );
		return( retval );
	}

	public static String formatSchemaDefRspnCreated( String separator, CFBamSchemaDefBuff buff ) {
		String retval = "<RspnSchemaDefCreated "
			+	formatSchemaDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRspnLocked( String separator, CFBamSchemaDefBuff buff ) {
		String retval = "<RspnSchemaDefLocked "
			+	formatSchemaDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRspnUpdated( String separator, CFBamSchemaDefBuff buff ) {
		String retval = "<RspnSchemaDefUpdated "
			+	formatSchemaDefBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatSchemaDefRspnDeleted() {
		String retval = "<RspnSchemaDefDeleted />";
		return( retval );
	}
}
