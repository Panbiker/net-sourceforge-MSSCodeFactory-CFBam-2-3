
// Description: Java 7 XML Message message formatter for CFBam.Table

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
 *	CFBamXMsgTableMessageFormatter XML message formatter
 *	for CFBam.Table.
 */
public class CFBamXMsgTableMessageFormatter
	extends CFBamXMsgScopeMessageFormatter
{
	public CFBamXMsgTableMessageFormatter() {
		super();
	}

	public static String formatTableBuffAttributes( String separator, CFBamTableBuff buff ) {
		String retval = CFBamXMsgScopeMessageFormatter.formatScopeBuffAttributes( separator, buff )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					buff.getRequiredSchemaDefId() )
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
					"PrimaryIndexTenantId",
					buff.getOptionalPrimaryIndexTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrimaryIndexId",
					buff.getOptionalPrimaryIndexId() )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"TableClassCode",
					buff.getRequiredTableClassCode() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"LookupIndexTenantId",
					buff.getOptionalLookupIndexTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"LookupIndexId",
					buff.getOptionalLookupIndexId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"AltIndexTenantId",
					buff.getOptionalAltIndexTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"AltIndexId",
					buff.getOptionalAltIndexId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"QualifyingTenantId",
					buff.getOptionalQualifyingTenantId() )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"QualifyingTableId",
					buff.getOptionalQualifyingTableId() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"PolyBase",
					buff.getRequiredPolyBase() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"IsInstantiable",
					buff.getRequiredIsInstantiable() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"HasHistory",
					buff.getRequiredHasHistory() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"HasAuditColumns",
					buff.getRequiredHasAuditColumns() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"LoaderBehaviourId",
					buff.getRequiredLoaderBehaviourId() )
			+	CFLibXmlUtil.formatOptionalInt16( separator,
					"DataScopeId",
					buff.getOptionalDataScopeId() )
			+	CFLibXmlUtil.formatRequiredInt16( separator,
					"SecurityScopeId",
					buff.getRequiredSecurityScopeId() )
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
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JObjMembers",
					buff.getOptionalJObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JObjInterface",
					buff.getOptionalJObjInterface() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JObjImport",
					buff.getOptionalJObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JObjImplementation",
					buff.getOptionalJObjImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JEditObjMembers",
					buff.getOptionalJEditObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JEditObjInterface",
					buff.getOptionalJEditObjInterface() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JEditObjImport",
					buff.getOptionalJEditObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JEditObjImplementation",
					buff.getOptionalJEditObjImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JTableImport",
					buff.getOptionalJTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JTableMembers",
					buff.getOptionalJTableMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JTableInterface",
					buff.getOptionalJTableInterface() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JTableImplementation",
					buff.getOptionalJTableImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JTableObjImport",
					buff.getOptionalJTableObjImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JTableObjMembers",
					buff.getOptionalJTableObjMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JTableObjInterface",
					buff.getOptionalJTableObjInterface() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JTableObjImplementation",
					buff.getOptionalJTableObjImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JDb2LUWTableImport",
					buff.getOptionalJDb2LUWTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JDb2LUWTableMembers",
					buff.getOptionalJDb2LUWTableMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JDb2LUWTableImplementation",
					buff.getOptionalJDb2LUWTableImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMSSqlTableImport",
					buff.getOptionalJMSSqlTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMSSqlTableMembers",
					buff.getOptionalJMSSqlTableMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMSSqlTableImplementation",
					buff.getOptionalJMSSqlTableImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMySqlTableImport",
					buff.getOptionalJMySqlTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMySqlTableMembers",
					buff.getOptionalJMySqlTableMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JMySqlTableImplementation",
					buff.getOptionalJMySqlTableImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JOracleTableImport",
					buff.getOptionalJOracleTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JOracleTableMembers",
					buff.getOptionalJOracleTableMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JOracleTableImplementation",
					buff.getOptionalJOracleTableImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JPgSqlTableImport",
					buff.getOptionalJPgSqlTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JPgSqlTableMembers",
					buff.getOptionalJPgSqlTableMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JPgSqlTableImplementation",
					buff.getOptionalJPgSqlTableImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSybaseTableImport",
					buff.getOptionalJSybaseTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSybaseTableMembers",
					buff.getOptionalJSybaseTableMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSybaseTableImplementation",
					buff.getOptionalJSybaseTableImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JRamTableImport",
					buff.getOptionalJRamTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JRamTableMembers",
					buff.getOptionalJRamTableMembers() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JRamTableImplementation",
					buff.getOptionalJRamTableImplementation() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSaxLoaderImport",
					buff.getOptionalJSaxLoaderImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSaxLoaderStartElement",
					buff.getOptionalJSaxLoaderStartElement() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JSaxLoaderEndElement",
					buff.getOptionalJSaxLoaderEndElement() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgTableImport",
					buff.getOptionalJXMsgTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgTableFormatters",
					buff.getOptionalJXMsgTableFormatters() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRqstTableImport",
					buff.getOptionalJXMsgRqstTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRspnTableImport",
					buff.getOptionalJXMsgRspnTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgClientTableImport",
					buff.getOptionalJXMsgClientTableImport() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRqstTableBody",
					buff.getOptionalJXMsgRqstTableBody() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgRspnTableBody",
					buff.getOptionalJXMsgRspnTableBody() )
			+	CFLibXmlUtil.formatOptionalXmlString( separator,
					"JXMsgClientTableBody",
					buff.getOptionalJXMsgClientTableBody() )
			+	CFLibXmlUtil.formatRequiredBoolean( separator,
					"DefaultVisibility",
					buff.getRequiredDefaultVisibility() );
		return( retval );
	}

	public static String formatTableRqstCreate( String separator, CFBamTableBuff buff ) {
		String retval = "<RqstTableCreate "
			+	formatTableBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstRead( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstTableRead "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstRead( String separator, CFBamTableBuff buff ) {
		String retval = "<RqstTableRead "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstRead( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTableRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadAll( String separator ) {
		String retval = "<RqstTableReadAll />";
		return( retval );
	}

	public static String formatTableRqstReadByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTableRead "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTableReadByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadBySchemaDefIdx( String separator,
		long argTenantId,
		long argSchemaDefId )
	{
		String retval = "<RqstTableReadBySchemaDefIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstTableReadByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByUNameIdx( String separator,
		long argTenantId,
		long argSchemaDefId,
		String argName )
	{
		String retval = "<RqstTableReadByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadBySchemaCdIdx( String separator,
		long argTenantId,
		long argSchemaDefId,
		String argTableClassCode )
	{
		String retval = "<RqstTableReadBySchemaCdIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"TableClassCode",
					argTableClassCode )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByPrimaryIndexIdx( String separator,
		Long argPrimaryIndexTenantId,
		Long argPrimaryIndexId )
	{
		String retval = "<RqstTableReadByPrimaryIndexIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrimaryIndexTenantId",
					argPrimaryIndexTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrimaryIndexId",
					argPrimaryIndexId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByLookupIndexIdx( String separator,
		Long argLookupIndexTenantId,
		Long argLookupIndexId )
	{
		String retval = "<RqstTableReadByLookupIndexIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"LookupIndexTenantId",
					argLookupIndexTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"LookupIndexId",
					argLookupIndexId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByAltIndexIdx( String separator,
		Long argAltIndexTenantId,
		Long argAltIndexId )
	{
		String retval = "<RqstTableReadByAltIndexIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"AltIndexTenantId",
					argAltIndexTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"AltIndexId",
					argAltIndexId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByQualTableIdx( String separator,
		Long argQualifyingTenantId,
		Long argQualifyingTableId )
	{
		String retval = "<RqstTableReadByQualTableIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"QualifyingTenantId",
					argQualifyingTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"QualifyingTableId",
					argQualifyingTableId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByLoadBehaveIdx( String separator,
		short argLoaderBehaviourId )
	{
		String retval = "<RqstTableReadByLoadBehaveIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"LoaderBehaviourId",
					argLoaderBehaviourId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstTableReadByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadBySecScopeIdx( String separator,
		short argSecurityScopeId )
	{
		String retval = "<RqstTableReadBySecScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"SecurityScopeId",
					argSecurityScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstTableReadByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstTableReadByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstTableReadByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstReadByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstTableReadByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstLock( String separator, CFBamScopePKey pkey ) {
		String retval = "<RqstTableLock "
			+	formatScopePKeyAttributes( separator, pkey )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstLock( String separator, CFBamTableBuff buff ) {
		String retval = "<RqstTableLock "
			+	formatScopePKeyAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstLock( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTableLock "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstUpdate( String separator, CFBamTableBuff buff ) {
		String retval = "<RqstTableUpdate "
			+	formatTableBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDelete( String separator, CFBamTableBuff buff ) {
		String retval = "<RqstTableDelete "
				+	formatScopePKeyAttributes( separator, buff )
				+	CFLibXmlUtil.formatRequiredInt32( separator,
						"Revision",
						buff.getRequiredRevision() )
				+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByIdIdx( String separator,
		long argTenantId,
		long argId )
	{
		String retval = "<RqstTableDelete "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"Id",
					argId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByTenantIdx( String separator,
		long argTenantId )
	{
		String retval = "<RqstTableDeleteByTenantIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteBySchemaDefIdx( String separator,
		long argTenantId,
		long argSchemaDefId )
	{
		String retval = "<RqstTableDeleteBySchemaDefIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByDefSchemaIdx( String separator,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		String retval = "<RqstTableDeleteByDefSchemaIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"DefSchemaTenantId",
					argDefSchemaTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"DefSchemaId",
					argDefSchemaId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByUNameIdx( String separator,
		long argTenantId,
		long argSchemaDefId,
		String argName )
	{
		String retval = "<RqstTableDeleteByUNameIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"Name",
					argName )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteBySchemaCdIdx( String separator,
		long argTenantId,
		long argSchemaDefId,
		String argTableClassCode )
	{
		String retval = "<RqstTableDeleteBySchemaCdIdx "
			+	CFLibXmlUtil.formatRequiredInt64( null,
					"TenantId",
					argTenantId )
			+	CFLibXmlUtil.formatRequiredInt64( separator,
					"SchemaDefId",
					argSchemaDefId )
			+	CFLibXmlUtil.formatRequiredXmlString( separator,
					"TableClassCode",
					argTableClassCode )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByPrimaryIndexIdx( String separator,
		Long argPrimaryIndexTenantId,
		Long argPrimaryIndexId )
	{
		String retval = "<RqstTableDeleteByPrimaryIndexIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"PrimaryIndexTenantId",
					argPrimaryIndexTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"PrimaryIndexId",
					argPrimaryIndexId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByLookupIndexIdx( String separator,
		Long argLookupIndexTenantId,
		Long argLookupIndexId )
	{
		String retval = "<RqstTableDeleteByLookupIndexIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"LookupIndexTenantId",
					argLookupIndexTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"LookupIndexId",
					argLookupIndexId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByAltIndexIdx( String separator,
		Long argAltIndexTenantId,
		Long argAltIndexId )
	{
		String retval = "<RqstTableDeleteByAltIndexIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"AltIndexTenantId",
					argAltIndexTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"AltIndexId",
					argAltIndexId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByQualTableIdx( String separator,
		Long argQualifyingTenantId,
		Long argQualifyingTableId )
	{
		String retval = "<RqstTableDeleteByQualTableIdx "
			+	CFLibXmlUtil.formatOptionalInt64( null,
					"QualifyingTenantId",
					argQualifyingTenantId )
			+	CFLibXmlUtil.formatOptionalInt64( separator,
					"QualifyingTableId",
					argQualifyingTableId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByLoadBehaveIdx( String separator,
		short argLoaderBehaviourId )
	{
		String retval = "<RqstTableDeleteByLoadBehaveIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"LoaderBehaviourId",
					argLoaderBehaviourId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByDataScopeIdx( String separator,
		Short argDataScopeId )
	{
		String retval = "<RqstTableDeleteByDataScopeIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"DataScopeId",
					argDataScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteBySecScopeIdx( String separator,
		short argSecurityScopeId )
	{
		String retval = "<RqstTableDeleteBySecScopeIdx "
			+	CFLibXmlUtil.formatRequiredInt16( null,
					"SecurityScopeId",
					argSecurityScopeId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByVAccSecIdx( String separator,
		Short argViewAccessSecurityId )
	{
		String retval = "<RqstTableDeleteByVAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessSecurityId",
					argViewAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByVAccFreqIdx( String separator,
		Short argViewAccessFrequencyId )
	{
		String retval = "<RqstTableDeleteByVAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"ViewAccessFrequencyId",
					argViewAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByEAccSecIdx( String separator,
		Short argEditAccessSecurityId )
	{
		String retval = "<RqstTableDeleteByEAccSecIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessSecurityId",
					argEditAccessSecurityId )
			+	" />";
		return( retval );
	}

	public static String formatTableRqstDeleteByEAccFreqIdx( String separator,
		Short argEditAccessFrequencyId )
	{
		String retval = "<RqstTableDeleteByEAccFreqIdx "
			+	CFLibXmlUtil.formatOptionalInt16( null,
					"EditAccessFrequencyId",
					argEditAccessFrequencyId )
			+	" />";
		return( retval );
	}

	public static String formatTableRspnSingleOpenTag() {
		final String retval = "<RspnTableReadSingle>";
		return( retval );
	}

	public static String formatTableRspnSingleCloseTag() {
		final String retval = "</RspnTableReadSingle>";
		return( retval );
	}

	public static String formatTableRspnListOpenTag() {
		final String retval = "<RspnTableReadList>";
		return( retval );
	}

	public static String formatTableRspnListCloseTag() {
		final String retval = "</RspnTableReadList>";
		return( retval );
	}

	public static String formatTableRspnRec( String separator, CFBamTableBuff buff ) {
		String retval = "<Table "
			+	formatTableBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTableRspnDerivedRec( String separator, CFBamTableBuff buff ) {
		String retval;
		retval = formatTableRspnRec( separator, buff );
		return( retval );
	}

	public static String formatTableRspnCreated( String separator, CFBamTableBuff buff ) {
		String retval = "<RspnTableCreated "
			+	formatTableBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTableRspnLocked( String separator, CFBamTableBuff buff ) {
		String retval = "<RspnTableLocked "
			+	formatTableBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTableRspnUpdated( String separator, CFBamTableBuff buff ) {
		String retval = "<RspnTableUpdated "
			+	formatTableBuffAttributes( separator, buff )
			+	" />";
		return( retval );
	}

	public static String formatTableRspnDeleted() {
		String retval = "<RspnTableDeleted />";
		return( retval );
	}
}
