// Description: Java 7 MS SQL Server 2012 Express Advanced Edition Jdbc DbIO implementation for SchemaDef.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamMSSql;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

/*
 *	CFBamMSSqlSchemaDefTable PostgreSQL Jdbc DbIO implementation
 *	for SchemaDef.
 */
public class CFBamMSSqlSchemaDefTable
	implements ICFBamSchemaDefTable
{
	private CFBamMSSqlSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtAuditCreatedByPKey = null;
	protected PreparedStatement stmtAuditUpdatedByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByTenantIdx = null;
	protected PreparedStatement stmtReadBuffByCTenantIdx = null;
	protected PreparedStatement stmtReadBuffByDomainIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtReadBuffByDefLcnIdx = null;
	protected PreparedStatement stmtReadBuffByDataScopeIdx = null;
	protected PreparedStatement stmtReadBuffByVAccSecIdx = null;
	protected PreparedStatement stmtReadBuffByVAccFreqIdx = null;
	protected PreparedStatement stmtReadBuffByEAccSecIdx = null;
	protected PreparedStatement stmtReadBuffByEAccFreqIdx = null;
	protected PreparedStatement stmtReadBuffByPubURIIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByTenantIdx = null;
	protected PreparedStatement stmtDeleteByCTenantIdx = null;
	protected PreparedStatement stmtDeleteByDomainIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;
	protected PreparedStatement stmtDeleteByDefLcnIdx = null;
	protected PreparedStatement stmtDeleteByDataScopeIdx = null;
	protected PreparedStatement stmtDeleteByVAccSecIdx = null;
	protected PreparedStatement stmtDeleteByVAccFreqIdx = null;
	protected PreparedStatement stmtDeleteByEAccSecIdx = null;
	protected PreparedStatement stmtDeleteByEAccFreqIdx = null;
	protected PreparedStatement stmtDeleteByPubURIIdx = null;

	public CFBamMSSqlSchemaDefTable( CFBamMSSqlSchema argSchema ) {
		schema = argSchema;
	}

	public void createSchemaDef( CFBamAuthorization Authorization,
		CFBamSchemaDefBuff Buff )
	{
		final String S_ProcName = "createSchemaDef";
		if( "SCHM".equals( Buff.getClassCode() )
			&& ( ! schema.isTenantUser( Authorization,
				Buff.getRequiredTenantId(),
				"CreateSchemaDef" ) ) )
		{
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Permission denied -- User not part of TSecGroup CreateSchemaDef" );
		}
		schema.getTableScope().createScope( Authorization, Buff );
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			long DomainId = Buff.getRequiredDomainId();
			String Name = Buff.getRequiredName();
			String DbName = Buff.getOptionalDbName();
			String ShortName = Buff.getOptionalShortName();
			String Label = Buff.getOptionalLabel();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			Long DefaultLicenseTenantId = Buff.getOptionalDefaultLicenseTenantId();
			Long DefaultLicenseId = Buff.getOptionalDefaultLicenseId();
			boolean ExtendCFCore = Buff.getRequiredExtendCFCore();
			Short DataScopeId = Buff.getOptionalDataScopeId();
			Short ViewAccessSecurityId = Buff.getOptionalViewAccessSecurityId();
			Short EditAccessSecurityId = Buff.getOptionalEditAccessSecurityId();
			Short ViewAccessFrequencyId = Buff.getOptionalViewAccessFrequencyId();
			Short EditAccessFrequencyId = Buff.getOptionalEditAccessFrequencyId();
			String CopyrightPeriod = Buff.getRequiredCopyrightPeriod();
			String CopyrightHolder = Buff.getRequiredCopyrightHolder();
			String PublishURI = Buff.getRequiredPublishURI();
			String JSchemaObjImport = Buff.getOptionalJSchemaObjImport();
			String JSchemaObjInterface = Buff.getOptionalJSchemaObjInterface();
			String JSchemaObjMembers = Buff.getOptionalJSchemaObjMembers();
			String JSchemaObjImplementation = Buff.getOptionalJSchemaObjImplementation();
			String JDb2LUWSchemaObjMembers = Buff.getOptionalJDb2LUWSchemaObjMembers();
			String JDb2LUWSchemaObjImpl = Buff.getOptionalJDb2LUWSchemaObjImpl();
			String JDb2LUWSchemaObjImport = Buff.getOptionalJDb2LUWSchemaObjImport();
			String JMSSqlSchemaObjMembers = Buff.getOptionalJMSSqlSchemaObjMembers();
			String JMSSqlSchemaObjImpl = Buff.getOptionalJMSSqlSchemaObjImpl();
			String JMSSqlSchemaObjImport = Buff.getOptionalJMSSqlSchemaObjImport();
			String JMySqlSchemaObjMembers = Buff.getOptionalJMySqlSchemaObjMembers();
			String JMySqlSchemaObjImpl = Buff.getOptionalJMySqlSchemaObjImpl();
			String JMySqlSchemaObjImport = Buff.getOptionalJMySqlSchemaObjImport();
			String JOracleSchemaObjMembers = Buff.getOptionalJOracleSchemaObjMembers();
			String JOracleSchemaObjImpl = Buff.getOptionalJOracleSchemaObjImpl();
			String JOracleSchemaObjImport = Buff.getOptionalJOracleSchemaObjImport();
			String JPgSqlSchemaObjMembers = Buff.getOptionalJPgSqlSchemaObjMembers();
			String JPgSqlSchemaObjImpl = Buff.getOptionalJPgSqlSchemaObjImpl();
			String JPgSqlSchemaObjImport = Buff.getOptionalJPgSqlSchemaObjImport();
			String JSybaseSchemaObjMembers = Buff.getOptionalJSybaseSchemaObjMembers();
			String JSybaseSchemaObjImpl = Buff.getOptionalJSybaseSchemaObjImpl();
			String JSybaseSchemaObjImport = Buff.getOptionalJSybaseSchemaObjImport();
			String JRamSchemaObjMembers = Buff.getOptionalJRamSchemaObjMembers();
			String JRamSchemaObjImpl = Buff.getOptionalJRamSchemaObjImpl();
			String JRamSchemaObjImport = Buff.getOptionalJRamSchemaObjImport();
			String JXMsgSchemaImport = Buff.getOptionalJXMsgSchemaImport();
			String JXMsgSchemaFormatters = Buff.getOptionalJXMsgSchemaFormatters();
			String JXMsgClientSchemaImport = Buff.getOptionalJXMsgClientSchemaImport();
			String JXMsgClientSchemaBody = Buff.getOptionalJXMsgClientSchemaBody();
			String JXMsgRqstSchemaBody = Buff.getOptionalJXMsgRqstSchemaBody();
			String JXMsgRqstSchemaImport = Buff.getOptionalJXMsgRqstSchemaImport();
			String JXMsgRqstSchemaWireParsers = Buff.getOptionalJXMsgRqstSchemaWireParsers();
			String JXMsgRqstSchemaXsdSpec = Buff.getOptionalJXMsgRqstSchemaXsdSpec();
			String JXMsgRqstSchemaXsdElementList = Buff.getOptionalJXMsgRqstSchemaXsdElementList();
			String JXMsgRspnSchemaBody = Buff.getOptionalJXMsgRspnSchemaBody();
			String JXMsgRspnSchemaImport = Buff.getOptionalJXMsgRspnSchemaImport();
			String JXMsgRspnSchemaWireParsers = Buff.getOptionalJXMsgRspnSchemaWireParsers();
			String JXMsgRspnSchemaXsdElementList = Buff.getOptionalJXMsgRspnSchemaXsdElementList();
			String JXMsgRspnSchemaXsdSpec = Buff.getOptionalJXMsgRspnSchemaXsdSpec();
			String sql =
					"INSERT INTO " + schema.getLowerDbSchemaName() + "..schemadef( "
				+		"tenantid, "
				+		"id, "
				+		"domainid, "
				+		"name, "
				+		"dbname, "
				+		"short_name, "
				+		"label, "
				+		"short_descr, "
				+		"descr, "
				+		"defaultlicensetenantid, "
				+		"deflcnid, "
				+		"extendcfcore, "
				+		"datascopeid, "
				+		"vaccsecid, "
				+		"eaccsecid, "
				+		"vaccfreqid, "
				+		"eaccfreqid, "
				+		"copyperd, "
				+		"copyhold, "
				+		"puburi, "
				+		"jobj_import, "
				+		"jobj_xface, "
				+		"jobj_memb, "
				+		"jobj_impl, "
				+		"jdb2_memb, "
				+		"jdb2_impl, "
				+		"jdb2_import, "
				+		"jmssql_memb, "
				+		"jmssql_impl, "
				+		"jmssql_import, "
				+		"jmysql_memb, "
				+		"jmysql_impl, "
				+		"jmysql_import, "
				+		"joracle_memb, "
				+		"joracle_impl, "
				+		"joracle_import, "
				+		"jpgsql_memb, "
				+		"jpgsql_impl, "
				+		"jpgsql_import, "
				+		"jsybase_memb, "
				+		"jsybase_impl, "
				+		"jsybase_import, "
				+		"jram_memb, "
				+		"jram_impl, "
				+		"jram_impl, "
				+		"javaxmsgschimp, "
				+		"javaxmsgschfmts, "
				+		"javaxmsgcltschimp, "
				+		"javaxmsgcltschbdy, "
				+		"javaxmsgrqstschbdy, "
				+		"javaxmsgrqstschimp, "
				+		"javaxmsgrqstschwirep, "
				+		"javaxmsgrqstschxsdspec, "
				+		"javaxmsgrqstschxsdeltlst, "
				+		"javaxmsgrspnschemabody, "
				+		"javaxmsgrspnschimp, "
				+		"javaxmsgrspnschwirep, "
				+		"javaxmsgrspnschxsdeltlst, "
				+		"javaxmsgrspnschxsdspec" + " )"
				+	"VALUES ( "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtCreateByPKey == null ) {
				stmtCreateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtCreateByPKey.setLong( argIdx++, TenantId );
			stmtCreateByPKey.setLong( argIdx++, Id );
			stmtCreateByPKey.setLong( argIdx++, DomainId );
			stmtCreateByPKey.setString( argIdx++, Name );
			if( DbName != null ) {
				stmtCreateByPKey.setString( argIdx++, DbName );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( ShortName != null ) {
				stmtCreateByPKey.setString( argIdx++, ShortName );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Label != null ) {
				stmtCreateByPKey.setString( argIdx++, Label );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( ShortDescription != null ) {
				stmtCreateByPKey.setString( argIdx++, ShortDescription );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Description != null ) {
				stmtCreateByPKey.setString( argIdx++, Description );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DefaultLicenseTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, DefaultLicenseTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefaultLicenseId != null ) {
				stmtCreateByPKey.setLong( argIdx++, DefaultLicenseId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( ExtendCFCore ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( DataScopeId != null ) {
				stmtCreateByPKey.setShort( argIdx++, DataScopeId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( ViewAccessSecurityId != null ) {
				stmtCreateByPKey.setShort( argIdx++, ViewAccessSecurityId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( EditAccessSecurityId != null ) {
				stmtCreateByPKey.setShort( argIdx++, EditAccessSecurityId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( ViewAccessFrequencyId != null ) {
				stmtCreateByPKey.setShort( argIdx++, ViewAccessFrequencyId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( EditAccessFrequencyId != null ) {
				stmtCreateByPKey.setShort( argIdx++, EditAccessFrequencyId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtCreateByPKey.setString( argIdx++, CopyrightPeriod );
			stmtCreateByPKey.setString( argIdx++, CopyrightHolder );
			stmtCreateByPKey.setString( argIdx++, PublishURI );
			if( JSchemaObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JSchemaObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSchemaObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, JSchemaObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSchemaObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JSchemaObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSchemaObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JSchemaObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWSchemaObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JDb2LUWSchemaObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWSchemaObjImpl != null ) {
				stmtCreateByPKey.setString( argIdx++, JDb2LUWSchemaObjImpl );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWSchemaObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JDb2LUWSchemaObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlSchemaObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JMSSqlSchemaObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlSchemaObjImpl != null ) {
				stmtCreateByPKey.setString( argIdx++, JMSSqlSchemaObjImpl );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlSchemaObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JMSSqlSchemaObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlSchemaObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JMySqlSchemaObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlSchemaObjImpl != null ) {
				stmtCreateByPKey.setString( argIdx++, JMySqlSchemaObjImpl );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlSchemaObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JMySqlSchemaObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleSchemaObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JOracleSchemaObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleSchemaObjImpl != null ) {
				stmtCreateByPKey.setString( argIdx++, JOracleSchemaObjImpl );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleSchemaObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JOracleSchemaObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlSchemaObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JPgSqlSchemaObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlSchemaObjImpl != null ) {
				stmtCreateByPKey.setString( argIdx++, JPgSqlSchemaObjImpl );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlSchemaObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JPgSqlSchemaObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseSchemaObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JSybaseSchemaObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseSchemaObjImpl != null ) {
				stmtCreateByPKey.setString( argIdx++, JSybaseSchemaObjImpl );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseSchemaObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JSybaseSchemaObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamSchemaObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JRamSchemaObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamSchemaObjImpl != null ) {
				stmtCreateByPKey.setString( argIdx++, JRamSchemaObjImpl );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamSchemaObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JRamSchemaObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgSchemaImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgSchemaImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgSchemaFormatters != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgSchemaFormatters );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgClientSchemaImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgClientSchemaImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgClientSchemaBody != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgClientSchemaBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstSchemaBody != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRqstSchemaBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstSchemaImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRqstSchemaImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstSchemaWireParsers != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRqstSchemaWireParsers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstSchemaXsdSpec != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRqstSchemaXsdSpec );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstSchemaXsdElementList != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRqstSchemaXsdElementList );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnSchemaBody != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRspnSchemaBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnSchemaImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRspnSchemaImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnSchemaWireParsers != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRspnSchemaWireParsers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnSchemaXsdElementList != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRspnSchemaXsdElementList );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnSchemaXsdSpec != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRspnSchemaXsdSpec );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			int rowsAffected = stmtCreateByPKey.executeUpdate();
			if( rowsAffected != 1 ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be affected by insert, not " + rowsAffected );
			}
			if( "SCHM".equals( Buff.getClassCode() ) ) {
				String sqlAuditCreated =
						"INSERT INTO " + schema.getLowerDbSchemaName() + "..schemadef_h( auditclusterid, "
					+		" auditsessionid,"
					+		" auditstamp,"
					+		" classcode" + ", "
					+		"tenantid" + ", "
					+		"id" + ", "
					+		"domainid" + ", "
					+		"name" + ", "
					+		"dbname" + ", "
					+		"short_name" + ", "
					+		"label" + ", "
					+		"short_descr" + ", "
					+		"descr" + ", "
					+		"defaultlicensetenantid" + ", "
					+		"deflcnid" + ", "
					+		"extendcfcore" + ", "
					+		"datascopeid" + ", "
					+		"vaccsecid" + ", "
					+		"eaccsecid" + ", "
					+		"vaccfreqid" + ", "
					+		"eaccfreqid" + ", "
					+		"copyperd" + ", "
					+		"copyhold" + ", "
					+		"puburi" + ", "
					+		"jobj_import" + ", "
					+		"jobj_xface" + ", "
					+		"jobj_memb" + ", "
					+		"jobj_impl" + ", "
					+		"jdb2_memb" + ", "
					+		"jdb2_impl" + ", "
					+		"jdb2_import" + ", "
					+		"jmssql_memb" + ", "
					+		"jmssql_impl" + ", "
					+		"jmssql_import" + ", "
					+		"jmysql_memb" + ", "
					+		"jmysql_impl" + ", "
					+		"jmysql_import" + ", "
					+		"joracle_memb" + ", "
					+		"joracle_impl" + ", "
					+		"joracle_import" + ", "
					+		"jpgsql_memb" + ", "
					+		"jpgsql_impl" + ", "
					+		"jpgsql_import" + ", "
					+		"jsybase_memb" + ", "
					+		"jsybase_impl" + ", "
					+		"jsybase_import" + ", "
					+		"jram_memb" + ", "
					+		"jram_impl" + ", "
					+		"jram_impl" + ", "
					+		"javaxmsgschimp" + ", "
					+		"javaxmsgschfmts" + ", "
					+		"javaxmsgcltschimp" + ", "
					+		"javaxmsgcltschbdy" + ", "
					+		"javaxmsgrqstschbdy" + ", "
					+		"javaxmsgrqstschimp" + ", "
					+		"javaxmsgrqstschwirep" + ", "
					+		"javaxmsgrqstschxsdspec" + ", "
					+		"javaxmsgrqstschxsdeltlst" + ", "
					+		"javaxmsgrspnschemabody" + ", "
					+		"javaxmsgrspnschimp" + ", "
					+		"javaxmsgrspnschwirep" + ", "
					+		"javaxmsgrspnschxsdeltlst" + ", "
					+		"javaxmsgrspnschxsdspec" + ", "
					+		" revision, "
					+		" auditaction ) "
					+	"SELECT ?, ?, sysdatetime(), scop.classcode" + ", "
					+		"scop.tenantid"  + ", "
					+		"scop.id"  + ", "
					+		"schm.domainid" + ", "
					+		"schm.name" + ", "
					+		"schm.dbname" + ", "
					+		"schm.short_name" + ", "
					+		"schm.label" + ", "
					+		"schm.short_descr" + ", "
					+		"schm.descr" + ", "
					+		"schm.defaultlicensetenantid" + ", "
					+		"schm.deflcnid" + ", "
					+		"schm.extendcfcore" + ", "
					+		"schm.datascopeid" + ", "
					+		"schm.vaccsecid" + ", "
					+		"schm.eaccsecid" + ", "
					+		"schm.vaccfreqid" + ", "
					+		"schm.eaccfreqid" + ", "
					+		"schm.copyperd" + ", "
					+		"schm.copyhold" + ", "
					+		"schm.puburi" + ", "
					+		"schm.jobj_import" + ", "
					+		"schm.jobj_xface" + ", "
					+		"schm.jobj_memb" + ", "
					+		"schm.jobj_impl" + ", "
					+		"schm.jdb2_memb" + ", "
					+		"schm.jdb2_impl" + ", "
					+		"schm.jdb2_import" + ", "
					+		"schm.jmssql_memb" + ", "
					+		"schm.jmssql_impl" + ", "
					+		"schm.jmssql_import" + ", "
					+		"schm.jmysql_memb" + ", "
					+		"schm.jmysql_impl" + ", "
					+		"schm.jmysql_import" + ", "
					+		"schm.joracle_memb" + ", "
					+		"schm.joracle_impl" + ", "
					+		"schm.joracle_import" + ", "
					+		"schm.jpgsql_memb" + ", "
					+		"schm.jpgsql_impl" + ", "
					+		"schm.jpgsql_import" + ", "
					+		"schm.jsybase_memb" + ", "
					+		"schm.jsybase_impl" + ", "
					+		"schm.jsybase_import" + ", "
					+		"schm.jram_memb" + ", "
					+		"schm.jram_impl" + ", "
					+		"schm.jram_impl" + ", "
					+		"schm.javaxmsgschimp" + ", "
					+		"schm.javaxmsgschfmts" + ", "
					+		"schm.javaxmsgcltschimp" + ", "
					+		"schm.javaxmsgcltschbdy" + ", "
					+		"schm.javaxmsgrqstschbdy" + ", "
					+		"schm.javaxmsgrqstschimp" + ", "
					+		"schm.javaxmsgrqstschwirep" + ", "
					+		"schm.javaxmsgrqstschxsdspec" + ", "
					+		"schm.javaxmsgrqstschxsdeltlst" + ", "
					+		"schm.javaxmsgrspnschemabody" + ", "
					+		"schm.javaxmsgrspnschimp" + ", "
					+		"schm.javaxmsgrspnschwirep" + ", "
					+		"schm.javaxmsgrspnschxsdeltlst" + ", "
					+		"schm.javaxmsgrspnschxsdspec" + ", "
					+		" scop.revision, "
					+		" 1 "
					+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..schemadef schm ON "
				+		"schm.TenantId = scop.TenantId "
				+		"AND schm.Id = scop.Id "
					+	" WHERE "
					+				"scop.tenantid = ? "
					+			"AND scop.id = ? ";
				if( stmtAuditCreatedByPKey == null ) {
					stmtAuditCreatedByPKey = cnx.prepareStatement( sqlAuditCreated );
				}
				argIdx = 1;
				stmtAuditCreatedByPKey.setLong( argIdx++, Authorization.getSecClusterId() );
				stmtAuditCreatedByPKey.setString( argIdx++, Authorization.getSecSessionId().toString() );
				stmtAuditCreatedByPKey.setLong( argIdx++, TenantId );
				stmtAuditCreatedByPKey.setLong( argIdx++, Id );
				int rowsAudited = stmtAuditCreatedByPKey.executeUpdate();
				if( rowsAudited != 1 ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Expected 1 row to be affected by audit via insert-selected, not " + rowsAffected );
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	protected static String S_sqlSelectSchemaDefDistinctClassCode = null;

	public String getSqlSelectSchemaDefDistinctClassCode() {
		if( S_sqlSelectSchemaDefDistinctClassCode == null ) {
			S_sqlSelectSchemaDefDistinctClassCode =
					"SELECT "
				+		"DISTINCT scop.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..schemadef schm ON "
				+		"schm.TenantId = scop.TenantId "
				+		"AND schm.Id = scop.Id ";
		}
		return( S_sqlSelectSchemaDefDistinctClassCode );
	}

	protected static String S_sqlSelectSchemaDefBuff = null;

	public String getSqlSelectSchemaDefBuff() {
		if( S_sqlSelectSchemaDefBuff == null ) {
			S_sqlSelectSchemaDefBuff =
					"SELECT "
				+		"scop.ClassCode, "
				+		"scop.tenantid, "
				+		"scop.id, "
				+		"schm.domainid, "
				+		"schm.name, "
				+		"schm.dbname, "
				+		"schm.short_name, "
				+		"schm.label, "
				+		"schm.short_descr, "
				+		"schm.descr, "
				+		"schm.defaultlicensetenantid, "
				+		"schm.deflcnid, "
				+		"schm.extendcfcore, "
				+		"schm.datascopeid, "
				+		"schm.vaccsecid, "
				+		"schm.eaccsecid, "
				+		"schm.vaccfreqid, "
				+		"schm.eaccfreqid, "
				+		"schm.copyperd, "
				+		"schm.copyhold, "
				+		"schm.puburi, "
				+		"schm.jobj_import, "
				+		"schm.jobj_xface, "
				+		"schm.jobj_memb, "
				+		"schm.jobj_impl, "
				+		"schm.jdb2_memb, "
				+		"schm.jdb2_impl, "
				+		"schm.jdb2_import, "
				+		"schm.jmssql_memb, "
				+		"schm.jmssql_impl, "
				+		"schm.jmssql_import, "
				+		"schm.jmysql_memb, "
				+		"schm.jmysql_impl, "
				+		"schm.jmysql_import, "
				+		"schm.joracle_memb, "
				+		"schm.joracle_impl, "
				+		"schm.joracle_import, "
				+		"schm.jpgsql_memb, "
				+		"schm.jpgsql_impl, "
				+		"schm.jpgsql_import, "
				+		"schm.jsybase_memb, "
				+		"schm.jsybase_impl, "
				+		"schm.jsybase_import, "
				+		"schm.jram_memb, "
				+		"schm.jram_impl, "
				+		"schm.jram_impl, "
				+		"schm.javaxmsgschimp, "
				+		"schm.javaxmsgschfmts, "
				+		"schm.javaxmsgcltschimp, "
				+		"schm.javaxmsgcltschbdy, "
				+		"schm.javaxmsgrqstschbdy, "
				+		"schm.javaxmsgrqstschimp, "
				+		"schm.javaxmsgrqstschwirep, "
				+		"schm.javaxmsgrqstschxsdspec, "
				+		"schm.javaxmsgrqstschxsdeltlst, "
				+		"schm.javaxmsgrspnschemabody, "
				+		"schm.javaxmsgrspnschimp, "
				+		"schm.javaxmsgrspnschwirep, "
				+		"schm.javaxmsgrspnschxsdeltlst, "
				+		"schm.javaxmsgrspnschxsdspec, "
				+		"scop.revision "
				+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..schemadef schm ON "
				+		"schm.TenantId = scop.TenantId "
				+		"AND schm.Id = scop.Id ";
		}
		return( S_sqlSelectSchemaDefBuff );
	}

	protected CFBamSchemaDefBuff unpackSchemaDefResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackSchemaDefResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamSchemaDefBuff buff;
		if( classCode.equals( "SCHM" ) ) {
			buff = schema.getFactorySchemaDef().newBuff();
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Unrecognized class code \"" + classCode + "\"" );
		}
		{
			String colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setCreatedByUserId( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setCreatedByUserId( null );
			}
			else {
				buff.setCreatedByUserId( UUID.fromString( colString ) );
			}
			idxcol ++;

			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setCreatedAt( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setCreatedAt( null );
			}
			else {
				buff.setCreatedAt( CFBamMSSqlSchema.convertTimestampString( colString ) );
			}
			idxcol++;
			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setUpdatedByUserId( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setUpdatedByUserId( null );
			}
			else {
				buff.setUpdatedByUserId( UUID.fromString( colString ) );
			}
			idxcol ++;

			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setUpdatedAt( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setUpdatedAt( null );
			}
			else {
				buff.setUpdatedAt( CFBamMSSqlSchema.convertTimestampString( colString ) );
			}
			idxcol++;
		}
		buff.setRequiredTenantId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredDomainId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredName( resultSet.getString( idxcol ) );
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDbName( null );
			}
			else {
				buff.setOptionalDbName( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalShortName( null );
			}
			else {
				buff.setOptionalShortName( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalLabel( null );
			}
			else {
				buff.setOptionalLabel( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalShortDescription( null );
			}
			else {
				buff.setOptionalShortDescription( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDescription( null );
			}
			else {
				buff.setOptionalDescription( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefaultLicenseTenantId( null );
			}
			else {
				buff.setOptionalDefaultLicenseTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefaultLicenseId( null );
			}
			else {
				buff.setOptionalDefaultLicenseId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredExtendCFCore( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDataScopeId( null );
			}
			else {
				buff.setOptionalDataScopeId( colVal );
			}
		}
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalViewAccessSecurityId( null );
			}
			else {
				buff.setOptionalViewAccessSecurityId( colVal );
			}
		}
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalEditAccessSecurityId( null );
			}
			else {
				buff.setOptionalEditAccessSecurityId( colVal );
			}
		}
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalViewAccessFrequencyId( null );
			}
			else {
				buff.setOptionalViewAccessFrequencyId( colVal );
			}
		}
		idxcol++;
		{
			short colVal = resultSet.getShort( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalEditAccessFrequencyId( null );
			}
			else {
				buff.setOptionalEditAccessFrequencyId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredCopyrightPeriod( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredCopyrightHolder( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredPublishURI( resultSet.getString( idxcol ) );
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSchemaObjImport( null );
			}
			else {
				buff.setOptionalJSchemaObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSchemaObjInterface( null );
			}
			else {
				buff.setOptionalJSchemaObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSchemaObjMembers( null );
			}
			else {
				buff.setOptionalJSchemaObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSchemaObjImplementation( null );
			}
			else {
				buff.setOptionalJSchemaObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJDb2LUWSchemaObjMembers( null );
			}
			else {
				buff.setOptionalJDb2LUWSchemaObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJDb2LUWSchemaObjImpl( null );
			}
			else {
				buff.setOptionalJDb2LUWSchemaObjImpl( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJDb2LUWSchemaObjImport( null );
			}
			else {
				buff.setOptionalJDb2LUWSchemaObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMSSqlSchemaObjMembers( null );
			}
			else {
				buff.setOptionalJMSSqlSchemaObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMSSqlSchemaObjImpl( null );
			}
			else {
				buff.setOptionalJMSSqlSchemaObjImpl( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMSSqlSchemaObjImport( null );
			}
			else {
				buff.setOptionalJMSSqlSchemaObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMySqlSchemaObjMembers( null );
			}
			else {
				buff.setOptionalJMySqlSchemaObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMySqlSchemaObjImpl( null );
			}
			else {
				buff.setOptionalJMySqlSchemaObjImpl( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMySqlSchemaObjImport( null );
			}
			else {
				buff.setOptionalJMySqlSchemaObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJOracleSchemaObjMembers( null );
			}
			else {
				buff.setOptionalJOracleSchemaObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJOracleSchemaObjImpl( null );
			}
			else {
				buff.setOptionalJOracleSchemaObjImpl( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJOracleSchemaObjImport( null );
			}
			else {
				buff.setOptionalJOracleSchemaObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJPgSqlSchemaObjMembers( null );
			}
			else {
				buff.setOptionalJPgSqlSchemaObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJPgSqlSchemaObjImpl( null );
			}
			else {
				buff.setOptionalJPgSqlSchemaObjImpl( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJPgSqlSchemaObjImport( null );
			}
			else {
				buff.setOptionalJPgSqlSchemaObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSybaseSchemaObjMembers( null );
			}
			else {
				buff.setOptionalJSybaseSchemaObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSybaseSchemaObjImpl( null );
			}
			else {
				buff.setOptionalJSybaseSchemaObjImpl( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSybaseSchemaObjImport( null );
			}
			else {
				buff.setOptionalJSybaseSchemaObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJRamSchemaObjMembers( null );
			}
			else {
				buff.setOptionalJRamSchemaObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJRamSchemaObjImpl( null );
			}
			else {
				buff.setOptionalJRamSchemaObjImpl( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJRamSchemaObjImport( null );
			}
			else {
				buff.setOptionalJRamSchemaObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgSchemaImport( null );
			}
			else {
				buff.setOptionalJXMsgSchemaImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgSchemaFormatters( null );
			}
			else {
				buff.setOptionalJXMsgSchemaFormatters( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgClientSchemaImport( null );
			}
			else {
				buff.setOptionalJXMsgClientSchemaImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgClientSchemaBody( null );
			}
			else {
				buff.setOptionalJXMsgClientSchemaBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRqstSchemaBody( null );
			}
			else {
				buff.setOptionalJXMsgRqstSchemaBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRqstSchemaImport( null );
			}
			else {
				buff.setOptionalJXMsgRqstSchemaImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRqstSchemaWireParsers( null );
			}
			else {
				buff.setOptionalJXMsgRqstSchemaWireParsers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRqstSchemaXsdSpec( null );
			}
			else {
				buff.setOptionalJXMsgRqstSchemaXsdSpec( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRqstSchemaXsdElementList( null );
			}
			else {
				buff.setOptionalJXMsgRqstSchemaXsdElementList( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRspnSchemaBody( null );
			}
			else {
				buff.setOptionalJXMsgRspnSchemaBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRspnSchemaImport( null );
			}
			else {
				buff.setOptionalJXMsgRspnSchemaImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRspnSchemaWireParsers( null );
			}
			else {
				buff.setOptionalJXMsgRspnSchemaWireParsers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRspnSchemaXsdElementList( null );
			}
			else {
				buff.setOptionalJXMsgRspnSchemaXsdElementList( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRspnSchemaXsdSpec( null );
			}
			else {
				buff.setOptionalJXMsgRspnSchemaXsdSpec( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamSchemaDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSchemaDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamSchemaDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamSchemaDefBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamSchemaDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamMSSqlSchemaDefTable.readDerivedByIdIdx() ";
		CFBamSchemaDefBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		return( buff );
	}

	public CFBamSchemaDefBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff[] buffList = readBuffByTenantIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamSchemaDefBuff[] readDerivedByCTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByCTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff[] buffList = readBuffByCTenantIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamSchemaDefBuff[] readDerivedByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		final String S_ProcName = "readDerivedByDomainIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff[] buffList = readBuffByDomainIdx( Authorization,
				TenantId,
				DomainId );
		return( buffList );

	}

	public CFBamSchemaDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId,
		String Name )
	{
		final String S_ProcName = "CFBamMSSqlSchemaDefTable.readDerivedByUNameIdx() ";
		CFBamSchemaDefBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUNameIdx( Authorization,
				TenantId,
				DomainId,
				Name );
		return( buff );
	}

	public CFBamSchemaDefBuff[] readDerivedByDefLcnIdx( CFBamAuthorization Authorization,
		Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		final String S_ProcName = "readDerivedByDefLcnIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff[] buffList = readBuffByDefLcnIdx( Authorization,
				DefaultLicenseTenantId,
				DefaultLicenseId );
		return( buffList );

	}

	public CFBamSchemaDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "readDerivedByDataScopeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff[] buffList = readBuffByDataScopeIdx( Authorization,
				DataScopeId );
		return( buffList );

	}

	public CFBamSchemaDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "readDerivedByVAccSecIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff[] buffList = readBuffByVAccSecIdx( Authorization,
				ViewAccessSecurityId );
		return( buffList );

	}

	public CFBamSchemaDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "readDerivedByVAccFreqIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff[] buffList = readBuffByVAccFreqIdx( Authorization,
				ViewAccessFrequencyId );
		return( buffList );

	}

	public CFBamSchemaDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "readDerivedByEAccSecIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff[] buffList = readBuffByEAccSecIdx( Authorization,
				EditAccessSecurityId );
		return( buffList );

	}

	public CFBamSchemaDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "readDerivedByEAccFreqIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamSchemaDefBuff[] buffList = readBuffByEAccFreqIdx( Authorization,
				EditAccessFrequencyId );
		return( buffList );

	}

	public CFBamSchemaDefBuff readDerivedByPubURIIdx( CFBamAuthorization Authorization,
		long TenantId,
		String PublishURI )
	{
		final String S_ProcName = "CFBamMSSqlSchemaDefTable.readDerivedByPubURIIdx() ";
		CFBamSchemaDefBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByPubURIIdx( Authorization,
				TenantId,
				PublishURI );
		return( buff );
	}

	public CFBamSchemaDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "readBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();
			String sql = "{ call sp_read_schemadef( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByPKey == null ) {
				stmtReadBuffByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByPKey.setLong( argIdx++, TenantId );
			stmtReadBuffByPKey.setLong( argIdx++, Id );
			resultSet = stmtReadBuffByPKey.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				return( buff );
			}
			else {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "lockBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();
			String sql = "{ call sp_lock_schemadef( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtLockBuffByPKey == null ) {
				stmtLockBuffByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockBuffByPKey.setLong( argIdx++, TenantId );
			stmtLockBuffByPKey.setLong( argIdx++, Id );
			stmtLockBuffByPKey.execute();
			boolean moreResults = true;
			resultSet = null;
			while( resultSet == null ) {
				try {
					moreResults = stmtLockBuffByPKey.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtLockBuffByPKey.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtLockBuffByPKey.getUpdateCount() ) {
					break;
				}
			}
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				return( buff );
			}
			else {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_all( ?, ?, ?, ?, ? ) }";
			if( stmtReadAllBuff == null ) {
				stmtReadAllBuff = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			resultSet = stmtReadAllBuff.executeQuery();
			List<CFBamSchemaDefBuff> buffList = new LinkedList<CFBamSchemaDefBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSchemaDefBuff[] retBuff = new CFBamSchemaDefBuff[ buffList.size() ];
			Iterator<CFBamSchemaDefBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_ididx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByIdIdx == null ) {
				stmtReadBuffByIdIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByIdIdx.setLong( argIdx++, Id );
			resultSet = stmtReadBuffByIdIdx.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				return( buff );
			}
			else {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByTenantIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_tenantidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByTenantIdx == null ) {
				stmtReadBuffByTenantIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByTenantIdx.setLong( argIdx++, TenantId );
			resultSet = stmtReadBuffByTenantIdx.executeQuery();
			List<CFBamSchemaDefBuff> buffList = new LinkedList<CFBamSchemaDefBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSchemaDefBuff[] retBuff = new CFBamSchemaDefBuff[ buffList.size() ];
			Iterator<CFBamSchemaDefBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff[] readBuffByCTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByCTenantIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_ctenantidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByCTenantIdx == null ) {
				stmtReadBuffByCTenantIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByCTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByCTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByCTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByCTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByCTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByCTenantIdx.setLong( argIdx++, TenantId );
			resultSet = stmtReadBuffByCTenantIdx.executeQuery();
			List<CFBamSchemaDefBuff> buffList = new LinkedList<CFBamSchemaDefBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSchemaDefBuff[] retBuff = new CFBamSchemaDefBuff[ buffList.size() ];
			Iterator<CFBamSchemaDefBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff[] readBuffByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		final String S_ProcName = "readBuffByDomainIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_domainidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByDomainIdx == null ) {
				stmtReadBuffByDomainIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByDomainIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDomainIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByDomainIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByDomainIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDomainIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByDomainIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByDomainIdx.setLong( argIdx++, DomainId );
			resultSet = stmtReadBuffByDomainIdx.executeQuery();
			List<CFBamSchemaDefBuff> buffList = new LinkedList<CFBamSchemaDefBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSchemaDefBuff[] retBuff = new CFBamSchemaDefBuff[ buffList.size() ];
			Iterator<CFBamSchemaDefBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId,
		String Name )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_unameidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByUNameIdx == null ) {
				stmtReadBuffByUNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByUNameIdx.setLong( argIdx++, DomainId );
			stmtReadBuffByUNameIdx.setString( argIdx++, Name );
			resultSet = stmtReadBuffByUNameIdx.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				return( buff );
			}
			else {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff[] readBuffByDefLcnIdx( CFBamAuthorization Authorization,
		Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		final String S_ProcName = "readBuffByDefLcnIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_deflcnidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByDefLcnIdx == null ) {
				stmtReadBuffByDefLcnIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByDefLcnIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDefLcnIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByDefLcnIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByDefLcnIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDefLcnIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DefaultLicenseTenantId != null ) {
				stmtReadBuffByDefLcnIdx.setLong( argIdx++, DefaultLicenseTenantId.longValue() );
			}
			else {
				stmtReadBuffByDefLcnIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefaultLicenseId != null ) {
				stmtReadBuffByDefLcnIdx.setLong( argIdx++, DefaultLicenseId.longValue() );
			}
			else {
				stmtReadBuffByDefLcnIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByDefLcnIdx.executeQuery();
			List<CFBamSchemaDefBuff> buffList = new LinkedList<CFBamSchemaDefBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSchemaDefBuff[] retBuff = new CFBamSchemaDefBuff[ buffList.size() ];
			Iterator<CFBamSchemaDefBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "readBuffByDataScopeIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_datascopeidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByDataScopeIdx == null ) {
				stmtReadBuffByDataScopeIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDataScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByDataScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DataScopeId != null ) {
				stmtReadBuffByDataScopeIdx.setShort( argIdx++, DataScopeId.shortValue() );
			}
			else {
				stmtReadBuffByDataScopeIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			resultSet = stmtReadBuffByDataScopeIdx.executeQuery();
			List<CFBamSchemaDefBuff> buffList = new LinkedList<CFBamSchemaDefBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSchemaDefBuff[] retBuff = new CFBamSchemaDefBuff[ buffList.size() ];
			Iterator<CFBamSchemaDefBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "readBuffByVAccSecIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_vaccsecidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByVAccSecIdx == null ) {
				stmtReadBuffByVAccSecIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByVAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByVAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( ViewAccessSecurityId != null ) {
				stmtReadBuffByVAccSecIdx.setShort( argIdx++, ViewAccessSecurityId.shortValue() );
			}
			else {
				stmtReadBuffByVAccSecIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			resultSet = stmtReadBuffByVAccSecIdx.executeQuery();
			List<CFBamSchemaDefBuff> buffList = new LinkedList<CFBamSchemaDefBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSchemaDefBuff[] retBuff = new CFBamSchemaDefBuff[ buffList.size() ];
			Iterator<CFBamSchemaDefBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "readBuffByVAccFreqIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_vaccfreqidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByVAccFreqIdx == null ) {
				stmtReadBuffByVAccFreqIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByVAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByVAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( ViewAccessFrequencyId != null ) {
				stmtReadBuffByVAccFreqIdx.setShort( argIdx++, ViewAccessFrequencyId.shortValue() );
			}
			else {
				stmtReadBuffByVAccFreqIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			resultSet = stmtReadBuffByVAccFreqIdx.executeQuery();
			List<CFBamSchemaDefBuff> buffList = new LinkedList<CFBamSchemaDefBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSchemaDefBuff[] retBuff = new CFBamSchemaDefBuff[ buffList.size() ];
			Iterator<CFBamSchemaDefBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "readBuffByEAccSecIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_eaccsecidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByEAccSecIdx == null ) {
				stmtReadBuffByEAccSecIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByEAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( EditAccessSecurityId != null ) {
				stmtReadBuffByEAccSecIdx.setShort( argIdx++, EditAccessSecurityId.shortValue() );
			}
			else {
				stmtReadBuffByEAccSecIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			resultSet = stmtReadBuffByEAccSecIdx.executeQuery();
			List<CFBamSchemaDefBuff> buffList = new LinkedList<CFBamSchemaDefBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSchemaDefBuff[] retBuff = new CFBamSchemaDefBuff[ buffList.size() ];
			Iterator<CFBamSchemaDefBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "readBuffByEAccFreqIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_eaccfreqidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByEAccFreqIdx == null ) {
				stmtReadBuffByEAccFreqIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByEAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( EditAccessFrequencyId != null ) {
				stmtReadBuffByEAccFreqIdx.setShort( argIdx++, EditAccessFrequencyId.shortValue() );
			}
			else {
				stmtReadBuffByEAccFreqIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			resultSet = stmtReadBuffByEAccFreqIdx.executeQuery();
			List<CFBamSchemaDefBuff> buffList = new LinkedList<CFBamSchemaDefBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamSchemaDefBuff[] retBuff = new CFBamSchemaDefBuff[ buffList.size() ];
			Iterator<CFBamSchemaDefBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFBamSchemaDefBuff readBuffByPubURIIdx( CFBamAuthorization Authorization,
		long TenantId,
		String PublishURI )
	{
		final String S_ProcName = "readBuffByPubURIIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_schemadef_by_puburiidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByPubURIIdx == null ) {
				stmtReadBuffByPubURIIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByPubURIIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPubURIIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPubURIIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPubURIIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPubURIIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByPubURIIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByPubURIIdx.setString( argIdx++, PublishURI );
			resultSet = stmtReadBuffByPubURIIdx.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				return( buff );
			}
			else {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void updateSchemaDef( CFBamAuthorization Authorization,
		CFBamSchemaDefBuff Buff )
	{
		final String S_ProcName = "updateSchemaDef";
		if( "SCHM".equals( Buff.getClassCode() )
			&& ( ! schema.isTenantUser( Authorization,
				Buff.getRequiredTenantId(),
				"UpdateSchemaDef" ) ) )
		{
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Permission denied -- User not part of TSecGroup UpdateSchemaDef" );
		}
		schema.getTableScope().updateScope( Authorization, Buff );
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			long DomainId = Buff.getRequiredDomainId();
			String Name = Buff.getRequiredName();
			String DbName = Buff.getOptionalDbName();
			String ShortName = Buff.getOptionalShortName();
			String Label = Buff.getOptionalLabel();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			Long DefaultLicenseTenantId = Buff.getOptionalDefaultLicenseTenantId();
			Long DefaultLicenseId = Buff.getOptionalDefaultLicenseId();
			boolean ExtendCFCore = Buff.getRequiredExtendCFCore();
			Short DataScopeId = Buff.getOptionalDataScopeId();
			Short ViewAccessSecurityId = Buff.getOptionalViewAccessSecurityId();
			Short EditAccessSecurityId = Buff.getOptionalEditAccessSecurityId();
			Short ViewAccessFrequencyId = Buff.getOptionalViewAccessFrequencyId();
			Short EditAccessFrequencyId = Buff.getOptionalEditAccessFrequencyId();
			String CopyrightPeriod = Buff.getRequiredCopyrightPeriod();
			String CopyrightHolder = Buff.getRequiredCopyrightHolder();
			String PublishURI = Buff.getRequiredPublishURI();
			String JSchemaObjImport = Buff.getOptionalJSchemaObjImport();
			String JSchemaObjInterface = Buff.getOptionalJSchemaObjInterface();
			String JSchemaObjMembers = Buff.getOptionalJSchemaObjMembers();
			String JSchemaObjImplementation = Buff.getOptionalJSchemaObjImplementation();
			String JDb2LUWSchemaObjMembers = Buff.getOptionalJDb2LUWSchemaObjMembers();
			String JDb2LUWSchemaObjImpl = Buff.getOptionalJDb2LUWSchemaObjImpl();
			String JDb2LUWSchemaObjImport = Buff.getOptionalJDb2LUWSchemaObjImport();
			String JMSSqlSchemaObjMembers = Buff.getOptionalJMSSqlSchemaObjMembers();
			String JMSSqlSchemaObjImpl = Buff.getOptionalJMSSqlSchemaObjImpl();
			String JMSSqlSchemaObjImport = Buff.getOptionalJMSSqlSchemaObjImport();
			String JMySqlSchemaObjMembers = Buff.getOptionalJMySqlSchemaObjMembers();
			String JMySqlSchemaObjImpl = Buff.getOptionalJMySqlSchemaObjImpl();
			String JMySqlSchemaObjImport = Buff.getOptionalJMySqlSchemaObjImport();
			String JOracleSchemaObjMembers = Buff.getOptionalJOracleSchemaObjMembers();
			String JOracleSchemaObjImpl = Buff.getOptionalJOracleSchemaObjImpl();
			String JOracleSchemaObjImport = Buff.getOptionalJOracleSchemaObjImport();
			String JPgSqlSchemaObjMembers = Buff.getOptionalJPgSqlSchemaObjMembers();
			String JPgSqlSchemaObjImpl = Buff.getOptionalJPgSqlSchemaObjImpl();
			String JPgSqlSchemaObjImport = Buff.getOptionalJPgSqlSchemaObjImport();
			String JSybaseSchemaObjMembers = Buff.getOptionalJSybaseSchemaObjMembers();
			String JSybaseSchemaObjImpl = Buff.getOptionalJSybaseSchemaObjImpl();
			String JSybaseSchemaObjImport = Buff.getOptionalJSybaseSchemaObjImport();
			String JRamSchemaObjMembers = Buff.getOptionalJRamSchemaObjMembers();
			String JRamSchemaObjImpl = Buff.getOptionalJRamSchemaObjImpl();
			String JRamSchemaObjImport = Buff.getOptionalJRamSchemaObjImport();
			String JXMsgSchemaImport = Buff.getOptionalJXMsgSchemaImport();
			String JXMsgSchemaFormatters = Buff.getOptionalJXMsgSchemaFormatters();
			String JXMsgClientSchemaImport = Buff.getOptionalJXMsgClientSchemaImport();
			String JXMsgClientSchemaBody = Buff.getOptionalJXMsgClientSchemaBody();
			String JXMsgRqstSchemaBody = Buff.getOptionalJXMsgRqstSchemaBody();
			String JXMsgRqstSchemaImport = Buff.getOptionalJXMsgRqstSchemaImport();
			String JXMsgRqstSchemaWireParsers = Buff.getOptionalJXMsgRqstSchemaWireParsers();
			String JXMsgRqstSchemaXsdSpec = Buff.getOptionalJXMsgRqstSchemaXsdSpec();
			String JXMsgRqstSchemaXsdElementList = Buff.getOptionalJXMsgRqstSchemaXsdElementList();
			String JXMsgRspnSchemaBody = Buff.getOptionalJXMsgRspnSchemaBody();
			String JXMsgRspnSchemaImport = Buff.getOptionalJXMsgRspnSchemaImport();
			String JXMsgRspnSchemaWireParsers = Buff.getOptionalJXMsgRspnSchemaWireParsers();
			String JXMsgRspnSchemaXsdElementList = Buff.getOptionalJXMsgRspnSchemaXsdElementList();
			String JXMsgRspnSchemaXsdSpec = Buff.getOptionalJXMsgRspnSchemaXsdSpec();
			int Revision = Buff.getRequiredRevision();

			String sql =
					"UPDATE " + schema.getLowerDbSchemaName() + "..schemadef "
				+	"SET "
				+		"tenantid = ?" + ", "
				+		"id = ?" + ", "
				+		"domainid = ?" + ", "
				+		"name = ?" + ", "
				+		"dbname = ?" + ", "
				+		"short_name = ?" + ", "
				+		"label = ?" + ", "
				+		"short_descr = ?" + ", "
				+		"descr = ?" + ", "
				+		"defaultlicensetenantid = ?" + ", "
				+		"deflcnid = ?" + ", "
				+		"extendcfcore = ?" + ", "
				+		"datascopeid = ?" + ", "
				+		"vaccsecid = ?" + ", "
				+		"eaccsecid = ?" + ", "
				+		"vaccfreqid = ?" + ", "
				+		"eaccfreqid = ?" + ", "
				+		"copyperd = ?" + ", "
				+		"copyhold = ?" + ", "
				+		"puburi = ?" + ", "
				+		"jobj_import = ?" + ", "
				+		"jobj_xface = ?" + ", "
				+		"jobj_memb = ?" + ", "
				+		"jobj_impl = ?" + ", "
				+		"jdb2_memb = ?" + ", "
				+		"jdb2_impl = ?" + ", "
				+		"jdb2_import = ?" + ", "
				+		"jmssql_memb = ?" + ", "
				+		"jmssql_impl = ?" + ", "
				+		"jmssql_import = ?" + ", "
				+		"jmysql_memb = ?" + ", "
				+		"jmysql_impl = ?" + ", "
				+		"jmysql_import = ?" + ", "
				+		"joracle_memb = ?" + ", "
				+		"joracle_impl = ?" + ", "
				+		"joracle_import = ?" + ", "
				+		"jpgsql_memb = ?" + ", "
				+		"jpgsql_impl = ?" + ", "
				+		"jpgsql_import = ?" + ", "
				+		"jsybase_memb = ?" + ", "
				+		"jsybase_impl = ?" + ", "
				+		"jsybase_import = ?" + ", "
				+		"jram_memb = ?" + ", "
				+		"jram_impl = ?" + ", "
				+		"jram_impl = ?" + ", "
				+		"javaxmsgschimp = ?" + ", "
				+		"javaxmsgschfmts = ?" + ", "
				+		"javaxmsgcltschimp = ?" + ", "
				+		"javaxmsgcltschbdy = ?" + ", "
				+		"javaxmsgrqstschbdy = ?" + ", "
				+		"javaxmsgrqstschimp = ?" + ", "
				+		"javaxmsgrqstschwirep = ?" + ", "
				+		"javaxmsgrqstschxsdspec = ?" + ", "
				+		"javaxmsgrqstschxsdeltlst = ?" + ", "
				+		"javaxmsgrspnschemabody = ?" + ", "
				+		"javaxmsgrspnschimp = ?" + ", "
				+		"javaxmsgrspnschwirep = ?" + ", "
				+		"javaxmsgrspnschxsdeltlst = ?" + ", "
				+		"javaxmsgrspnschxsdspec = ?"
				+	" WHERE "
				+		"tenantid = ? "
				+	"AND "
				+		"id = ? ";
			if( stmtUpdateByPKey == null ) {
				stmtUpdateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;

			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, Id );
			stmtUpdateByPKey.setLong( argIdx++, DomainId );
			stmtUpdateByPKey.setString( argIdx++, Name );
			if( DbName != null ) {
				stmtUpdateByPKey.setString( argIdx++, DbName );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( ShortName != null ) {
				stmtUpdateByPKey.setString( argIdx++, ShortName );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Label != null ) {
				stmtUpdateByPKey.setString( argIdx++, Label );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( ShortDescription != null ) {
				stmtUpdateByPKey.setString( argIdx++, ShortDescription );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Description != null ) {
				stmtUpdateByPKey.setString( argIdx++, Description );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DefaultLicenseTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, DefaultLicenseTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefaultLicenseId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, DefaultLicenseId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( ExtendCFCore ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( DataScopeId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, DataScopeId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( ViewAccessSecurityId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, ViewAccessSecurityId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( EditAccessSecurityId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, EditAccessSecurityId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( ViewAccessFrequencyId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, ViewAccessFrequencyId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			if( EditAccessFrequencyId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, EditAccessFrequencyId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtUpdateByPKey.setString( argIdx++, CopyrightPeriod );
			stmtUpdateByPKey.setString( argIdx++, CopyrightHolder );
			stmtUpdateByPKey.setString( argIdx++, PublishURI );
			if( JSchemaObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSchemaObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSchemaObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSchemaObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSchemaObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSchemaObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSchemaObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSchemaObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWSchemaObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JDb2LUWSchemaObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWSchemaObjImpl != null ) {
				stmtUpdateByPKey.setString( argIdx++, JDb2LUWSchemaObjImpl );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWSchemaObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JDb2LUWSchemaObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlSchemaObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMSSqlSchemaObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlSchemaObjImpl != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMSSqlSchemaObjImpl );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlSchemaObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMSSqlSchemaObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlSchemaObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMySqlSchemaObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlSchemaObjImpl != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMySqlSchemaObjImpl );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlSchemaObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMySqlSchemaObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleSchemaObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JOracleSchemaObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleSchemaObjImpl != null ) {
				stmtUpdateByPKey.setString( argIdx++, JOracleSchemaObjImpl );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleSchemaObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JOracleSchemaObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlSchemaObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JPgSqlSchemaObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlSchemaObjImpl != null ) {
				stmtUpdateByPKey.setString( argIdx++, JPgSqlSchemaObjImpl );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlSchemaObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JPgSqlSchemaObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseSchemaObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSybaseSchemaObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseSchemaObjImpl != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSybaseSchemaObjImpl );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseSchemaObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSybaseSchemaObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamSchemaObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JRamSchemaObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamSchemaObjImpl != null ) {
				stmtUpdateByPKey.setString( argIdx++, JRamSchemaObjImpl );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamSchemaObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JRamSchemaObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgSchemaImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgSchemaImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgSchemaFormatters != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgSchemaFormatters );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgClientSchemaImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgClientSchemaImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgClientSchemaBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgClientSchemaBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstSchemaBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRqstSchemaBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstSchemaImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRqstSchemaImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstSchemaWireParsers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRqstSchemaWireParsers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstSchemaXsdSpec != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRqstSchemaXsdSpec );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstSchemaXsdElementList != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRqstSchemaXsdElementList );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnSchemaBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRspnSchemaBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnSchemaImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRspnSchemaImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnSchemaWireParsers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRspnSchemaWireParsers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnSchemaXsdElementList != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRspnSchemaXsdElementList );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnSchemaXsdSpec != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRspnSchemaXsdSpec );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, Id );;
			int rowsAffected = stmtUpdateByPKey.executeUpdate();
			if( rowsAffected != 1 ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be affected by update, not " + rowsAffected );
			}
			if( "SCHM".equals( Buff.getClassCode() ) ) {
				String sqlAuditUpdated =
						"INSERT INTO " + schema.getLowerDbSchemaName() + "..schemadef_h( auditclusterid, "
					+		" auditsessionid, "
					+		" auditstamp, "
					+		" classcode" + ", "
					+		"tenantid" + ", "
					+		"id" + ", "
					+		"domainid" + ", "
					+		"name" + ", "
					+		"dbname" + ", "
					+		"short_name" + ", "
					+		"label" + ", "
					+		"short_descr" + ", "
					+		"descr" + ", "
					+		"defaultlicensetenantid" + ", "
					+		"deflcnid" + ", "
					+		"extendcfcore" + ", "
					+		"datascopeid" + ", "
					+		"vaccsecid" + ", "
					+		"eaccsecid" + ", "
					+		"vaccfreqid" + ", "
					+		"eaccfreqid" + ", "
					+		"copyperd" + ", "
					+		"copyhold" + ", "
					+		"puburi" + ", "
					+		"jobj_import" + ", "
					+		"jobj_xface" + ", "
					+		"jobj_memb" + ", "
					+		"jobj_impl" + ", "
					+		"jdb2_memb" + ", "
					+		"jdb2_impl" + ", "
					+		"jdb2_import" + ", "
					+		"jmssql_memb" + ", "
					+		"jmssql_impl" + ", "
					+		"jmssql_import" + ", "
					+		"jmysql_memb" + ", "
					+		"jmysql_impl" + ", "
					+		"jmysql_import" + ", "
					+		"joracle_memb" + ", "
					+		"joracle_impl" + ", "
					+		"joracle_import" + ", "
					+		"jpgsql_memb" + ", "
					+		"jpgsql_impl" + ", "
					+		"jpgsql_import" + ", "
					+		"jsybase_memb" + ", "
					+		"jsybase_impl" + ", "
					+		"jsybase_import" + ", "
					+		"jram_memb" + ", "
					+		"jram_impl" + ", "
					+		"jram_impl" + ", "
					+		"javaxmsgschimp" + ", "
					+		"javaxmsgschfmts" + ", "
					+		"javaxmsgcltschimp" + ", "
					+		"javaxmsgcltschbdy" + ", "
					+		"javaxmsgrqstschbdy" + ", "
					+		"javaxmsgrqstschimp" + ", "
					+		"javaxmsgrqstschwirep" + ", "
					+		"javaxmsgrqstschxsdspec" + ", "
					+		"javaxmsgrqstschxsdeltlst" + ", "
					+		"javaxmsgrspnschemabody" + ", "
					+		"javaxmsgrspnschimp" + ", "
					+		"javaxmsgrspnschwirep" + ", "
					+		"javaxmsgrspnschxsdeltlst" + ", "
					+		"javaxmsgrspnschxsdspec" + ", "
					+		" revision, "
					+		" auditaction ) "
					+	"SELECT ?, ?, sysdatetime(), scop.classcode" + ", "
					+		"scop.tenantid"  + ", "
					+		"scop.id"  + ", "
					+		"schm.domainid" + ", "
					+		"schm.name" + ", "
					+		"schm.dbname" + ", "
					+		"schm.short_name" + ", "
					+		"schm.label" + ", "
					+		"schm.short_descr" + ", "
					+		"schm.descr" + ", "
					+		"schm.defaultlicensetenantid" + ", "
					+		"schm.deflcnid" + ", "
					+		"schm.extendcfcore" + ", "
					+		"schm.datascopeid" + ", "
					+		"schm.vaccsecid" + ", "
					+		"schm.eaccsecid" + ", "
					+		"schm.vaccfreqid" + ", "
					+		"schm.eaccfreqid" + ", "
					+		"schm.copyperd" + ", "
					+		"schm.copyhold" + ", "
					+		"schm.puburi" + ", "
					+		"schm.jobj_import" + ", "
					+		"schm.jobj_xface" + ", "
					+		"schm.jobj_memb" + ", "
					+		"schm.jobj_impl" + ", "
					+		"schm.jdb2_memb" + ", "
					+		"schm.jdb2_impl" + ", "
					+		"schm.jdb2_import" + ", "
					+		"schm.jmssql_memb" + ", "
					+		"schm.jmssql_impl" + ", "
					+		"schm.jmssql_import" + ", "
					+		"schm.jmysql_memb" + ", "
					+		"schm.jmysql_impl" + ", "
					+		"schm.jmysql_import" + ", "
					+		"schm.joracle_memb" + ", "
					+		"schm.joracle_impl" + ", "
					+		"schm.joracle_import" + ", "
					+		"schm.jpgsql_memb" + ", "
					+		"schm.jpgsql_impl" + ", "
					+		"schm.jpgsql_import" + ", "
					+		"schm.jsybase_memb" + ", "
					+		"schm.jsybase_impl" + ", "
					+		"schm.jsybase_import" + ", "
					+		"schm.jram_memb" + ", "
					+		"schm.jram_impl" + ", "
					+		"schm.jram_impl" + ", "
					+		"schm.javaxmsgschimp" + ", "
					+		"schm.javaxmsgschfmts" + ", "
					+		"schm.javaxmsgcltschimp" + ", "
					+		"schm.javaxmsgcltschbdy" + ", "
					+		"schm.javaxmsgrqstschbdy" + ", "
					+		"schm.javaxmsgrqstschimp" + ", "
					+		"schm.javaxmsgrqstschwirep" + ", "
					+		"schm.javaxmsgrqstschxsdspec" + ", "
					+		"schm.javaxmsgrqstschxsdeltlst" + ", "
					+		"schm.javaxmsgrspnschemabody" + ", "
					+		"schm.javaxmsgrspnschimp" + ", "
					+		"schm.javaxmsgrspnschwirep" + ", "
					+		"schm.javaxmsgrspnschxsdeltlst" + ", "
					+		"schm.javaxmsgrspnschxsdspec" + ", "
					+		" scop.revision, "
					+		" 2 "
					+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..schemadef schm ON "
				+		"schm.TenantId = scop.TenantId "
				+		"AND schm.Id = scop.Id "
					+	" WHERE "
					+				"scop.tenantid = ? "
					+			"AND scop.id = ? ";
				if( stmtAuditUpdatedByPKey == null ) {
					stmtAuditUpdatedByPKey = cnx.prepareStatement( sqlAuditUpdated );
				}
				argIdx = 1;
				stmtAuditUpdatedByPKey.setLong( argIdx++, Authorization.getSecClusterId() );
				stmtAuditUpdatedByPKey.setString( argIdx++, Authorization.getSecSessionId().toString() );
				stmtAuditUpdatedByPKey.setLong( argIdx++, TenantId );
				stmtAuditUpdatedByPKey.setLong( argIdx++, Id );
				int rowsAudited = stmtAuditUpdatedByPKey.executeUpdate();
				if( rowsAudited != 1 ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Expected 1 row to be affected by audit via insert-selected, not " + rowsAffected );
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public void deleteSchemaDef( CFBamAuthorization Authorization,
		CFBamSchemaDefBuff Buff )
	{
		final String S_ProcName = "deleteSchemaDef";
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();

			String sql = "exec sp_delete_schemadef ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByPKey == null ) {
				stmtDeleteByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByPKey.setLong( argIdx++, TenantId );
			stmtDeleteByPKey.setLong( argIdx++, Id );
			stmtDeleteByPKey.setInt( argIdx++, Buff.getRequiredRevision() );;
			Object stuff = null;
			boolean moreResults = stmtDeleteByPKey.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByPKey.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByPKey.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByPKey.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public void deleteSchemaDefByCTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteSchemaDefByCTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_ctenantidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByCTenantIdx== null ) {
				stmtDeleteByCTenantIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByCTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByCTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByCTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByCTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByCTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByCTenantIdx.setLong( argIdx++, argTenantId );
			Object stuff = null;
			boolean moreResults = stmtDeleteByCTenantIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByCTenantIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByCTenantIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByCTenantIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByCTenantIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByCTenantIdxKey argKey )
	{
		deleteSchemaDefByCTenantIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	public void deleteSchemaDefByDomainIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argDomainId )
	{
		final String S_ProcName = "deleteSchemaDefByDomainIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_domainidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByDomainIdx== null ) {
				stmtDeleteByDomainIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByDomainIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByDomainIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByDomainIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByDomainIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByDomainIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByDomainIdx.setLong( argIdx++, argTenantId );
			stmtDeleteByDomainIdx.setLong( argIdx++, argDomainId );
			Object stuff = null;
			boolean moreResults = stmtDeleteByDomainIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByDomainIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByDomainIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByDomainIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByDomainIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByDomainIdxKey argKey )
	{
		deleteSchemaDefByDomainIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredDomainId() );
	}

	public void deleteSchemaDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argDomainId,
		String argName )
	{
		final String S_ProcName = "deleteSchemaDefByUNameIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_unameidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByUNameIdx== null ) {
				stmtDeleteByUNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByUNameIdx.setLong( argIdx++, argTenantId );
			stmtDeleteByUNameIdx.setLong( argIdx++, argDomainId );
			stmtDeleteByUNameIdx.setString( argIdx++, argName );
			Object stuff = null;
			boolean moreResults = stmtDeleteByUNameIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByUNameIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByUNameIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByUNameIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByUNameIdxKey argKey )
	{
		deleteSchemaDefByUNameIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredDomainId(),
			argKey.getRequiredName() );
	}

	public void deleteSchemaDefByDefLcnIdx( CFBamAuthorization Authorization,
		Long argDefaultLicenseTenantId,
		Long argDefaultLicenseId )
	{
		final String S_ProcName = "deleteSchemaDefByDefLcnIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_deflcnidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByDefLcnIdx== null ) {
				stmtDeleteByDefLcnIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByDefLcnIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByDefLcnIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByDefLcnIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByDefLcnIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByDefLcnIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argDefaultLicenseTenantId != null ) {
				stmtDeleteByDefLcnIdx.setLong( argIdx++, argDefaultLicenseTenantId.longValue() );
			}
			else {
				stmtDeleteByDefLcnIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( argDefaultLicenseId != null ) {
				stmtDeleteByDefLcnIdx.setLong( argIdx++, argDefaultLicenseId.longValue() );
			}
			else {
				stmtDeleteByDefLcnIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByDefLcnIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByDefLcnIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByDefLcnIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByDefLcnIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByDefLcnIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByDefLcnIdxKey argKey )
	{
		deleteSchemaDefByDefLcnIdx( Authorization,
			argKey.getOptionalDefaultLicenseTenantId(),
			argKey.getOptionalDefaultLicenseId() );
	}

	public void deleteSchemaDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		final String S_ProcName = "deleteSchemaDefByDataScopeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_datascopeidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByDataScopeIdx== null ) {
				stmtDeleteByDataScopeIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByDataScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByDataScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByDataScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argDataScopeId != null ) {
				stmtDeleteByDataScopeIdx.setShort( argIdx++, argDataScopeId.shortValue() );
			}
			else {
				stmtDeleteByDataScopeIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByDataScopeIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByDataScopeIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByDataScopeIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByDataScopeIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByDataScopeIdxKey argKey )
	{
		deleteSchemaDefByDataScopeIdx( Authorization,
			argKey.getOptionalDataScopeId() );
	}

	public void deleteSchemaDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		final String S_ProcName = "deleteSchemaDefByVAccSecIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_vaccsecidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByVAccSecIdx== null ) {
				stmtDeleteByVAccSecIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByVAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByVAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByVAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argViewAccessSecurityId != null ) {
				stmtDeleteByVAccSecIdx.setShort( argIdx++, argViewAccessSecurityId.shortValue() );
			}
			else {
				stmtDeleteByVAccSecIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByVAccSecIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByVAccSecIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByVAccSecIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByVAccSecIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByVAccSecIdxKey argKey )
	{
		deleteSchemaDefByVAccSecIdx( Authorization,
			argKey.getOptionalViewAccessSecurityId() );
	}

	public void deleteSchemaDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		final String S_ProcName = "deleteSchemaDefByVAccFreqIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_vaccfreqidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByVAccFreqIdx== null ) {
				stmtDeleteByVAccFreqIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByVAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByVAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByVAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argViewAccessFrequencyId != null ) {
				stmtDeleteByVAccFreqIdx.setShort( argIdx++, argViewAccessFrequencyId.shortValue() );
			}
			else {
				stmtDeleteByVAccFreqIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByVAccFreqIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByVAccFreqIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByVAccFreqIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByVAccFreqIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByVAccFreqIdxKey argKey )
	{
		deleteSchemaDefByVAccFreqIdx( Authorization,
			argKey.getOptionalViewAccessFrequencyId() );
	}

	public void deleteSchemaDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		final String S_ProcName = "deleteSchemaDefByEAccSecIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_eaccsecidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByEAccSecIdx== null ) {
				stmtDeleteByEAccSecIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByEAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByEAccSecIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByEAccSecIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argEditAccessSecurityId != null ) {
				stmtDeleteByEAccSecIdx.setShort( argIdx++, argEditAccessSecurityId.shortValue() );
			}
			else {
				stmtDeleteByEAccSecIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByEAccSecIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByEAccSecIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByEAccSecIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByEAccSecIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByEAccSecIdxKey argKey )
	{
		deleteSchemaDefByEAccSecIdx( Authorization,
			argKey.getOptionalEditAccessSecurityId() );
	}

	public void deleteSchemaDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		final String S_ProcName = "deleteSchemaDefByEAccFreqIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_eaccfreqidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByEAccFreqIdx== null ) {
				stmtDeleteByEAccFreqIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByEAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByEAccFreqIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByEAccFreqIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argEditAccessFrequencyId != null ) {
				stmtDeleteByEAccFreqIdx.setShort( argIdx++, argEditAccessFrequencyId.shortValue() );
			}
			else {
				stmtDeleteByEAccFreqIdx.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByEAccFreqIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByEAccFreqIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByEAccFreqIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByEAccFreqIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByEAccFreqIdxKey argKey )
	{
		deleteSchemaDefByEAccFreqIdx( Authorization,
			argKey.getOptionalEditAccessFrequencyId() );
	}

	public void deleteSchemaDefByPubURIIdx( CFBamAuthorization Authorization,
		long argTenantId,
		String argPublishURI )
	{
		final String S_ProcName = "deleteSchemaDefByPubURIIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_puburiidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByPubURIIdx== null ) {
				stmtDeleteByPubURIIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByPubURIIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPubURIIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPubURIIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPubURIIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPubURIIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByPubURIIdx.setLong( argIdx++, argTenantId );
			stmtDeleteByPubURIIdx.setString( argIdx++, argPublishURI );
			Object stuff = null;
			boolean moreResults = stmtDeleteByPubURIIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByPubURIIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByPubURIIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByPubURIIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByPubURIIdx( CFBamAuthorization Authorization,
		CFBamSchemaDefByPubURIIdxKey argKey )
	{
		deleteSchemaDefByPubURIIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredPublishURI() );
	}

	public void deleteSchemaDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deleteSchemaDefByIdIdx";
		// MSS TODO WORKING
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			S_ProcName );
	}

	public void deleteSchemaDefByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		deleteSchemaDefByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteSchemaDefByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteSchemaDefByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_schemadef_by_tenantidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByTenantIdx== null ) {
				stmtDeleteByTenantIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByTenantIdx.setLong( argIdx++, argTenantId );
			Object stuff = null;
			boolean moreResults = stmtDeleteByTenantIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByTenantIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByTenantIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByTenantIdx.getUpdateCount() ) {
					break;
				}
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteSchemaDefByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		deleteSchemaDefByTenantIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	public CFBamCursor openSchemaDefCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectSchemaDefBuff()
			+	"ORDER BY " 
			+		"schm.TenantId ASC" + ", "
			+		"schm.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByCTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		String sql = getSqlSelectSchemaDefBuff()
			+	" WHERE "
				+		"schm.tenantid = " + Long.toString( TenantId ) + " "
				+		"AND "
				+			"scop.ClassCode = 'SCHM'"
			+	"ORDER BY " 
			+		"schm.TenantId ASC" + ", "
			+		"schm.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		String sql = getSqlSelectSchemaDefBuff()
			+	" WHERE "
				+		"schm.tenantid = " + Long.toString( TenantId ) + " "
			+	"AND "
				+		"schm.domainid = " + Long.toString( DomainId ) + " "
				+		"AND "
				+			"scop.ClassCode = 'SCHM'"
			+	"ORDER BY " 
			+		"schm.TenantId ASC" + ", "
			+		"schm.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByDefLcnIdx( CFBamAuthorization Authorization,
		Long DefaultLicenseTenantId,
		Long DefaultLicenseId )
	{
		String sql = getSqlSelectSchemaDefBuff()
			+	" WHERE "
				+		( ( DefaultLicenseTenantId == null ) ? "schm.defaultlicensetenantid is null "
							: "schm.defaultlicensetenantid = " + DefaultLicenseTenantId.toString() + " " )
			+	"AND "
				+		( ( DefaultLicenseId == null ) ? "schm.deflcnid is null "
							: "schm.deflcnid = " + DefaultLicenseId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'SCHM'"
			+	"ORDER BY " 
			+		"schm.TenantId ASC" + ", "
			+		"schm.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		String sql = getSqlSelectSchemaDefBuff()
			+	" WHERE "
				+		( ( DataScopeId == null ) ? "schm.datascopeid is null "
							: "schm.datascopeid = " + DataScopeId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'SCHM'"
			+	"ORDER BY " 
			+		"schm.TenantId ASC" + ", "
			+		"schm.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		String sql = getSqlSelectSchemaDefBuff()
			+	" WHERE "
				+		( ( ViewAccessSecurityId == null ) ? "schm.vaccsecid is null "
							: "schm.vaccsecid = " + ViewAccessSecurityId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'SCHM'"
			+	"ORDER BY " 
			+		"schm.TenantId ASC" + ", "
			+		"schm.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		String sql = getSqlSelectSchemaDefBuff()
			+	" WHERE "
				+		( ( ViewAccessFrequencyId == null ) ? "schm.vaccfreqid is null "
							: "schm.vaccfreqid = " + ViewAccessFrequencyId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'SCHM'"
			+	"ORDER BY " 
			+		"schm.TenantId ASC" + ", "
			+		"schm.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		String sql = getSqlSelectSchemaDefBuff()
			+	" WHERE "
				+		( ( EditAccessSecurityId == null ) ? "schm.eaccsecid is null "
							: "schm.eaccsecid = " + EditAccessSecurityId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'SCHM'"
			+	"ORDER BY " 
			+		"schm.TenantId ASC" + ", "
			+		"schm.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openSchemaDefCursorByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		String sql = getSqlSelectSchemaDefBuff()
			+	" WHERE "
				+		( ( EditAccessFrequencyId == null ) ? "schm.eaccfreqid is null "
							: "schm.eaccfreqid = " + EditAccessFrequencyId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'SCHM'"
			+	"ORDER BY " 
			+		"schm.TenantId ASC" + ", "
			+		"schm.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeSchemaDefCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeSchemaDefCursor",
				e );
		}
	}

	public CFBamSchemaDefBuff nextSchemaDefCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextSchemaDefCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamSchemaDefBuff buff = unpackSchemaDefResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamSchemaDefBuff prevSchemaDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSchemaDefBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSchemaDefCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSchemaDefBuff firstSchemaDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSchemaDefBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSchemaDefCursor( Cursor );
		}
		return( buff );
	}

	public CFBamSchemaDefBuff lastSchemaDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastSchemaDefCursor" );
	}

	public CFBamSchemaDefBuff nthSchemaDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSchemaDefBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextSchemaDefCursor( Cursor );
		}
		return( buff );
	}

	/**
	 *	Release the prepared statements.
	 *	<p>
	 *	When the schema changes connections, the prepared statements
	 *	have to be released because they contain connection-specific
	 *	information for most databases.
	 */
	public void releasePreparedStatements() {
		final String S_ProcName = "releasePreparedStatements";
		S_sqlSelectSchemaDefDistinctClassCode = null;
		S_sqlSelectSchemaDefBuff = null;
		if( stmtReadBuffByPKey != null ) {
			try {
				stmtReadBuffByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByPKey = null;
		}
		if( stmtLockBuffByPKey != null ) {
			try {
				stmtLockBuffByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtLockBuffByPKey = null;
		}
		if( stmtAuditCreatedByPKey != null ) {
			try {
				stmtAuditCreatedByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtAuditCreatedByPKey = null;
		}
		if( stmtAuditUpdatedByPKey != null ) {
			try {
				stmtAuditUpdatedByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtAuditUpdatedByPKey = null;
		}
		if( stmtCreateByPKey != null ) {
			try {
				stmtCreateByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtCreateByPKey = null;
		}
		if( stmtUpdateByPKey != null ) {
			try {
				stmtUpdateByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtUpdateByPKey = null;
		}
		if( stmtDeleteByPKey != null ) {
			try {
				stmtDeleteByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByPKey = null;
		}
		if( stmtDeleteByTenantIdx != null ) {
			try {
				stmtDeleteByTenantIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByTenantIdx = null;
			}
		}
		if( stmtDeleteByCTenantIdx != null ) {
			try {
				stmtDeleteByCTenantIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByCTenantIdx = null;
			}
		}
		if( stmtDeleteByDomainIdx != null ) {
			try {
				stmtDeleteByDomainIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByDomainIdx = null;
			}
		}
		if( stmtDeleteByUNameIdx != null ) {
			try {
				stmtDeleteByUNameIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByUNameIdx = null;
			}
		}
		if( stmtDeleteByDefLcnIdx != null ) {
			try {
				stmtDeleteByDefLcnIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByDefLcnIdx = null;
			}
		}
		if( stmtDeleteByDataScopeIdx != null ) {
			try {
				stmtDeleteByDataScopeIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByDataScopeIdx = null;
			}
		}
		if( stmtDeleteByVAccSecIdx != null ) {
			try {
				stmtDeleteByVAccSecIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByVAccSecIdx = null;
			}
		}
		if( stmtDeleteByVAccFreqIdx != null ) {
			try {
				stmtDeleteByVAccFreqIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByVAccFreqIdx = null;
			}
		}
		if( stmtDeleteByEAccSecIdx != null ) {
			try {
				stmtDeleteByEAccSecIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByEAccSecIdx = null;
			}
		}
		if( stmtDeleteByEAccFreqIdx != null ) {
			try {
				stmtDeleteByEAccFreqIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByEAccFreqIdx = null;
			}
		}
		if( stmtDeleteByPubURIIdx != null ) {
			try {
				stmtDeleteByPubURIIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByPubURIIdx = null;
			}
		}
		if( stmtReadAllBuff != null ) {
			try {
				stmtReadAllBuff.close();
			}
			catch( SQLException e ) {
			}
			stmtReadAllBuff = null;
		}
		if( stmtReadBuffByIdIdx != null ) {
			try {
				stmtReadBuffByIdIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByIdIdx = null;
		}
		if( stmtReadBuffByTenantIdx != null ) {
			try {
				stmtReadBuffByTenantIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByTenantIdx = null;
		}
		if( stmtReadBuffByCTenantIdx != null ) {
			try {
				stmtReadBuffByCTenantIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByCTenantIdx = null;
		}
		if( stmtReadBuffByDomainIdx != null ) {
			try {
				stmtReadBuffByDomainIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByDomainIdx = null;
		}
		if( stmtReadBuffByUNameIdx != null ) {
			try {
				stmtReadBuffByUNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByUNameIdx = null;
		}
		if( stmtReadBuffByDefLcnIdx != null ) {
			try {
				stmtReadBuffByDefLcnIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByDefLcnIdx = null;
		}
		if( stmtReadBuffByDataScopeIdx != null ) {
			try {
				stmtReadBuffByDataScopeIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByDataScopeIdx = null;
		}
		if( stmtReadBuffByVAccSecIdx != null ) {
			try {
				stmtReadBuffByVAccSecIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByVAccSecIdx = null;
		}
		if( stmtReadBuffByVAccFreqIdx != null ) {
			try {
				stmtReadBuffByVAccFreqIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByVAccFreqIdx = null;
		}
		if( stmtReadBuffByEAccSecIdx != null ) {
			try {
				stmtReadBuffByEAccSecIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByEAccSecIdx = null;
		}
		if( stmtReadBuffByEAccFreqIdx != null ) {
			try {
				stmtReadBuffByEAccFreqIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByEAccFreqIdx = null;
		}
		if( stmtReadBuffByPubURIIdx != null ) {
			try {
				stmtReadBuffByPubURIIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByPubURIIdx = null;
		}
	}
}
