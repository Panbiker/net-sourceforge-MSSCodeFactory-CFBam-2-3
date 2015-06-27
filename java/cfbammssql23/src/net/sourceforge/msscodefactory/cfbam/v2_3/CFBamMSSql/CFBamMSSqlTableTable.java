// Description: Java 7 MS SQL Server 2012 Express Advanced Edition Jdbc DbIO implementation for Table.

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
 *	CFBamMSSqlTableTable PostgreSQL Jdbc DbIO implementation
 *	for Table.
 */
public class CFBamMSSqlTableTable
	implements ICFBamTableTable
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
	protected PreparedStatement stmtReadBuffBySchemaDefIdx = null;
	protected PreparedStatement stmtReadBuffByDefSchemaIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtReadBuffBySchemaCdIdx = null;
	protected PreparedStatement stmtReadBuffByPrimaryIndexIdx = null;
	protected PreparedStatement stmtReadBuffByLookupIndexIdx = null;
	protected PreparedStatement stmtReadBuffByAltIndexIdx = null;
	protected PreparedStatement stmtReadBuffByQualTableIdx = null;
	protected PreparedStatement stmtReadBuffByLoadBehaveIdx = null;
	protected PreparedStatement stmtReadBuffByDataScopeIdx = null;
	protected PreparedStatement stmtReadBuffBySecScopeIdx = null;
	protected PreparedStatement stmtReadBuffByVAccSecIdx = null;
	protected PreparedStatement stmtReadBuffByVAccFreqIdx = null;
	protected PreparedStatement stmtReadBuffByEAccSecIdx = null;
	protected PreparedStatement stmtReadBuffByEAccFreqIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByTenantIdx = null;
	protected PreparedStatement stmtDeleteBySchemaDefIdx = null;
	protected PreparedStatement stmtDeleteByDefSchemaIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;
	protected PreparedStatement stmtDeleteBySchemaCdIdx = null;
	protected PreparedStatement stmtDeleteByPrimaryIndexIdx = null;
	protected PreparedStatement stmtDeleteByLookupIndexIdx = null;
	protected PreparedStatement stmtDeleteByAltIndexIdx = null;
	protected PreparedStatement stmtDeleteByQualTableIdx = null;
	protected PreparedStatement stmtDeleteByLoadBehaveIdx = null;
	protected PreparedStatement stmtDeleteByDataScopeIdx = null;
	protected PreparedStatement stmtDeleteBySecScopeIdx = null;
	protected PreparedStatement stmtDeleteByVAccSecIdx = null;
	protected PreparedStatement stmtDeleteByVAccFreqIdx = null;
	protected PreparedStatement stmtDeleteByEAccSecIdx = null;
	protected PreparedStatement stmtDeleteByEAccFreqIdx = null;

	public CFBamMSSqlTableTable( CFBamMSSqlSchema argSchema ) {
		schema = argSchema;
	}

	public void createTable( CFBamAuthorization Authorization,
		CFBamTableBuff Buff )
	{
		final String S_ProcName = "createTable";
		if( "TBLD".equals( Buff.getClassCode() )
			&& ( ! schema.isTenantUser( Authorization,
				Buff.getRequiredTenantId(),
				"CreateTable" ) ) )
		{
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Permission denied -- User not part of TSecGroup CreateTable" );
		}
		schema.getTableScope().createScope( Authorization, Buff );
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			long SchemaDefId = Buff.getRequiredSchemaDefId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			String Name = Buff.getRequiredName();
			String DbName = Buff.getOptionalDbName();
			String ShortName = Buff.getOptionalShortName();
			String Label = Buff.getOptionalLabel();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			Long PrimaryIndexTenantId = Buff.getOptionalPrimaryIndexTenantId();
			Long PrimaryIndexId = Buff.getOptionalPrimaryIndexId();
			String TableClassCode = Buff.getRequiredTableClassCode();
			Long LookupIndexTenantId = Buff.getOptionalLookupIndexTenantId();
			Long LookupIndexId = Buff.getOptionalLookupIndexId();
			Long AltIndexTenantId = Buff.getOptionalAltIndexTenantId();
			Long AltIndexId = Buff.getOptionalAltIndexId();
			Long QualifyingTenantId = Buff.getOptionalQualifyingTenantId();
			Long QualifyingTableId = Buff.getOptionalQualifyingTableId();
			boolean PolyBase = Buff.getRequiredPolyBase();
			boolean IsInstantiable = Buff.getRequiredIsInstantiable();
			boolean HasHistory = Buff.getRequiredHasHistory();
			boolean HasAuditColumns = Buff.getRequiredHasAuditColumns();
			short LoaderBehaviourId = Buff.getRequiredLoaderBehaviourId();
			Short DataScopeId = Buff.getOptionalDataScopeId();
			short SecurityScopeId = Buff.getRequiredSecurityScopeId();
			Short ViewAccessSecurityId = Buff.getOptionalViewAccessSecurityId();
			Short EditAccessSecurityId = Buff.getOptionalEditAccessSecurityId();
			Short ViewAccessFrequencyId = Buff.getOptionalViewAccessFrequencyId();
			Short EditAccessFrequencyId = Buff.getOptionalEditAccessFrequencyId();
			String JObjMembers = Buff.getOptionalJObjMembers();
			String JObjInterface = Buff.getOptionalJObjInterface();
			String JObjImport = Buff.getOptionalJObjImport();
			String JObjImplementation = Buff.getOptionalJObjImplementation();
			String JEditObjMembers = Buff.getOptionalJEditObjMembers();
			String JEditObjInterface = Buff.getOptionalJEditObjInterface();
			String JEditObjImport = Buff.getOptionalJEditObjImport();
			String JEditObjImplementation = Buff.getOptionalJEditObjImplementation();
			String JTableImport = Buff.getOptionalJTableImport();
			String JTableMembers = Buff.getOptionalJTableMembers();
			String JTableInterface = Buff.getOptionalJTableInterface();
			String JTableImplementation = Buff.getOptionalJTableImplementation();
			String JTableObjImport = Buff.getOptionalJTableObjImport();
			String JTableObjMembers = Buff.getOptionalJTableObjMembers();
			String JTableObjInterface = Buff.getOptionalJTableObjInterface();
			String JTableObjImplementation = Buff.getOptionalJTableObjImplementation();
			String JDb2LUWTableImport = Buff.getOptionalJDb2LUWTableImport();
			String JDb2LUWTableMembers = Buff.getOptionalJDb2LUWTableMembers();
			String JDb2LUWTableImplementation = Buff.getOptionalJDb2LUWTableImplementation();
			String JMSSqlTableImport = Buff.getOptionalJMSSqlTableImport();
			String JMSSqlTableMembers = Buff.getOptionalJMSSqlTableMembers();
			String JMSSqlTableImplementation = Buff.getOptionalJMSSqlTableImplementation();
			String JMySqlTableImport = Buff.getOptionalJMySqlTableImport();
			String JMySqlTableMembers = Buff.getOptionalJMySqlTableMembers();
			String JMySqlTableImplementation = Buff.getOptionalJMySqlTableImplementation();
			String JOracleTableImport = Buff.getOptionalJOracleTableImport();
			String JOracleTableMembers = Buff.getOptionalJOracleTableMembers();
			String JOracleTableImplementation = Buff.getOptionalJOracleTableImplementation();
			String JPgSqlTableImport = Buff.getOptionalJPgSqlTableImport();
			String JPgSqlTableMembers = Buff.getOptionalJPgSqlTableMembers();
			String JPgSqlTableImplementation = Buff.getOptionalJPgSqlTableImplementation();
			String JSybaseTableImport = Buff.getOptionalJSybaseTableImport();
			String JSybaseTableMembers = Buff.getOptionalJSybaseTableMembers();
			String JSybaseTableImplementation = Buff.getOptionalJSybaseTableImplementation();
			String JRamTableImport = Buff.getOptionalJRamTableImport();
			String JRamTableMembers = Buff.getOptionalJRamTableMembers();
			String JRamTableImplementation = Buff.getOptionalJRamTableImplementation();
			String JSaxLoaderImport = Buff.getOptionalJSaxLoaderImport();
			String JSaxLoaderStartElement = Buff.getOptionalJSaxLoaderStartElement();
			String JSaxLoaderEndElement = Buff.getOptionalJSaxLoaderEndElement();
			String JXMsgTableImport = Buff.getOptionalJXMsgTableImport();
			String JXMsgTableFormatters = Buff.getOptionalJXMsgTableFormatters();
			String JXMsgRqstTableImport = Buff.getOptionalJXMsgRqstTableImport();
			String JXMsgRspnTableImport = Buff.getOptionalJXMsgRspnTableImport();
			String JXMsgClientTableImport = Buff.getOptionalJXMsgClientTableImport();
			String JXMsgRqstTableBody = Buff.getOptionalJXMsgRqstTableBody();
			String JXMsgRspnTableBody = Buff.getOptionalJXMsgRspnTableBody();
			String JXMsgClientTableBody = Buff.getOptionalJXMsgClientTableBody();
			boolean DefaultVisibility = Buff.getRequiredDefaultVisibility();
			String sql =
					"INSERT INTO " + schema.getLowerDbSchemaName() + "..tbldef( "
				+		"tenantid, "
				+		"schemadefid, "
				+		"defschtentid, "
				+		"defschid, "
				+		"id, "
				+		"name, "
				+		"dbname, "
				+		"short_name, "
				+		"label, "
				+		"short_descr, "
				+		"descr, "
				+		"primidxtentid, "
				+		"primidxid, "
				+		"tblclscd, "
				+		"lookidxtentid, "
				+		"lookidxid, "
				+		"altidxtentid, "
				+		"altidxid, "
				+		"qualtentid, "
				+		"qualtblid, "
				+		"polybase, "
				+		"isinstantiable, "
				+		"hashistory, "
				+		"hasauditcolumns, "
				+		"loadbehavid, "
				+		"datascopeid, "
				+		"secscopeid, "
				+		"vasecid, "
				+		"easecid, "
				+		"vafid, "
				+		"eafid, "
				+		"jobj_memb, "
				+		"jobj_xface, "
				+		"jtbl_objimp, "
				+		"jobj_impl, "
				+		"jedt_memb, "
				+		"jedt_xface, "
				+		"jtbl_eobjimp, "
				+		"jedt_impl, "
				+		"jtbl_imp, "
				+		"jtbl_memb, "
				+		"jtbl_xface, "
				+		"jtbl_impl, "
				+		"jtbl_objimp, "
				+		"jtbl_objmemb, "
				+		"jtbl_objxface, "
				+		"jtbl_objimpl, "
				+		"jtbl_db2imp, "
				+		"jdb2_memb, "
				+		"jdb2_impl, "
				+		"jtbl_msimp, "
				+		"jmssql_memb, "
				+		"jmssql_impl, "
				+		"jtbl_myimp, "
				+		"jmysql_memb, "
				+		"jmysql_impl, "
				+		"jtbl_oraimp, "
				+		"joracle_memb, "
				+		"joracle_impl, "
				+		"jtbl_pgimp, "
				+		"jpgsql_memb, "
				+		"jpgsql_impl, "
				+		"jtbl_sybaseimp, "
				+		"jsybase_memb, "
				+		"jsybase_impl, "
				+		"jtbl_ramimp, "
				+		"jram_memb, "
				+		"jram_impl, "
				+		"jtbl_saxldimp, "
				+		"jsaxstart_memb, "
				+		"jsaxend_impl, "
				+		"jxmtbl_imp, "
				+		"jxmtbl_fmt, "
				+		"jxmtbl_rqstimp, "
				+		"jxmtbl_rspnimp, "
				+		"jxmtbl_clntimp, "
				+		"jxmtbl_rqstbdy, "
				+		"jxmtbl_rspnbdy, "
				+		"jxmtbl_clntbdy, "
				+		"dflt_vis" + " )"
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
			stmtCreateByPKey.setLong( argIdx++, SchemaDefId );
			if( DefSchemaTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtCreateByPKey.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtCreateByPKey.setLong( argIdx++, Id );
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
			if( PrimaryIndexTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, PrimaryIndexTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrimaryIndexId != null ) {
				stmtCreateByPKey.setLong( argIdx++, PrimaryIndexId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtCreateByPKey.setString( argIdx++, TableClassCode );
			if( LookupIndexTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, LookupIndexTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( LookupIndexId != null ) {
				stmtCreateByPKey.setLong( argIdx++, LookupIndexId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( AltIndexTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, AltIndexTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( AltIndexId != null ) {
				stmtCreateByPKey.setLong( argIdx++, AltIndexId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( QualifyingTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, QualifyingTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( QualifyingTableId != null ) {
				stmtCreateByPKey.setLong( argIdx++, QualifyingTableId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PolyBase ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( IsInstantiable ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( HasHistory ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( HasAuditColumns ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			stmtCreateByPKey.setShort( argIdx++, LoaderBehaviourId );
			if( DataScopeId != null ) {
				stmtCreateByPKey.setShort( argIdx++, DataScopeId.shortValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtCreateByPKey.setShort( argIdx++, SecurityScopeId );
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
			if( JObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, JObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JEditObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JEditObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JEditObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, JEditObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JEditObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JEditObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JEditObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JEditObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JDb2LUWTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JDb2LUWTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JDb2LUWTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JMSSqlTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JMSSqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JMSSqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JMySqlTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JMySqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JMySqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JOracleTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JOracleTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JOracleTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JPgSqlTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JPgSqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JPgSqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JSybaseTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JSybaseTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JSybaseTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JRamTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JRamTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JRamTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSaxLoaderImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JSaxLoaderImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSaxLoaderStartElement != null ) {
				stmtCreateByPKey.setString( argIdx++, JSaxLoaderStartElement );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSaxLoaderEndElement != null ) {
				stmtCreateByPKey.setString( argIdx++, JSaxLoaderEndElement );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgTableFormatters != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgTableFormatters );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRqstTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRspnTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgClientTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgClientTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRqstTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRspnTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgClientTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgClientTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DefaultVisibility ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			int rowsAffected = stmtCreateByPKey.executeUpdate();
			if( rowsAffected != 1 ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be affected by insert, not " + rowsAffected );
			}
			if( "TBLD".equals( Buff.getClassCode() ) ) {
				String sqlAuditCreated =
						"INSERT INTO " + schema.getLowerDbSchemaName() + "..tbldef_h( auditclusterid, "
					+		" auditsessionid,"
					+		" auditstamp,"
					+		" classcode" + ", "
					+		"tenantid" + ", "
					+		"id" + ", "
					+		"schemadefid" + ", "
					+		"defschtentid" + ", "
					+		"defschid" + ", "
					+		"name" + ", "
					+		"dbname" + ", "
					+		"short_name" + ", "
					+		"label" + ", "
					+		"short_descr" + ", "
					+		"descr" + ", "
					+		"primidxtentid" + ", "
					+		"primidxid" + ", "
					+		"tblclscd" + ", "
					+		"lookidxtentid" + ", "
					+		"lookidxid" + ", "
					+		"altidxtentid" + ", "
					+		"altidxid" + ", "
					+		"qualtentid" + ", "
					+		"qualtblid" + ", "
					+		"polybase" + ", "
					+		"isinstantiable" + ", "
					+		"hashistory" + ", "
					+		"hasauditcolumns" + ", "
					+		"loadbehavid" + ", "
					+		"datascopeid" + ", "
					+		"secscopeid" + ", "
					+		"vasecid" + ", "
					+		"easecid" + ", "
					+		"vafid" + ", "
					+		"eafid" + ", "
					+		"jobj_memb" + ", "
					+		"jobj_xface" + ", "
					+		"jtbl_objimp" + ", "
					+		"jobj_impl" + ", "
					+		"jedt_memb" + ", "
					+		"jedt_xface" + ", "
					+		"jtbl_eobjimp" + ", "
					+		"jedt_impl" + ", "
					+		"jtbl_imp" + ", "
					+		"jtbl_memb" + ", "
					+		"jtbl_xface" + ", "
					+		"jtbl_impl" + ", "
					+		"jtbl_objimp" + ", "
					+		"jtbl_objmemb" + ", "
					+		"jtbl_objxface" + ", "
					+		"jtbl_objimpl" + ", "
					+		"jtbl_db2imp" + ", "
					+		"jdb2_memb" + ", "
					+		"jdb2_impl" + ", "
					+		"jtbl_msimp" + ", "
					+		"jmssql_memb" + ", "
					+		"jmssql_impl" + ", "
					+		"jtbl_myimp" + ", "
					+		"jmysql_memb" + ", "
					+		"jmysql_impl" + ", "
					+		"jtbl_oraimp" + ", "
					+		"joracle_memb" + ", "
					+		"joracle_impl" + ", "
					+		"jtbl_pgimp" + ", "
					+		"jpgsql_memb" + ", "
					+		"jpgsql_impl" + ", "
					+		"jtbl_sybaseimp" + ", "
					+		"jsybase_memb" + ", "
					+		"jsybase_impl" + ", "
					+		"jtbl_ramimp" + ", "
					+		"jram_memb" + ", "
					+		"jram_impl" + ", "
					+		"jtbl_saxldimp" + ", "
					+		"jsaxstart_memb" + ", "
					+		"jsaxend_impl" + ", "
					+		"jxmtbl_imp" + ", "
					+		"jxmtbl_fmt" + ", "
					+		"jxmtbl_rqstimp" + ", "
					+		"jxmtbl_rspnimp" + ", "
					+		"jxmtbl_clntimp" + ", "
					+		"jxmtbl_rqstbdy" + ", "
					+		"jxmtbl_rspnbdy" + ", "
					+		"jxmtbl_clntbdy" + ", "
					+		"dflt_vis" + ", "
					+		" revision, "
					+		" auditaction ) "
					+	"SELECT ?, ?, sysdatetime(), scop.classcode" + ", "
					+		"scop.tenantid"  + ", "
					+		"scop.id"  + ", "
					+		"tbld.schemadefid" + ", "
					+		"tbld.defschtentid" + ", "
					+		"tbld.defschid" + ", "
					+		"tbld.name" + ", "
					+		"tbld.dbname" + ", "
					+		"tbld.short_name" + ", "
					+		"tbld.label" + ", "
					+		"tbld.short_descr" + ", "
					+		"tbld.descr" + ", "
					+		"tbld.primidxtentid" + ", "
					+		"tbld.primidxid" + ", "
					+		"tbld.tblclscd" + ", "
					+		"tbld.lookidxtentid" + ", "
					+		"tbld.lookidxid" + ", "
					+		"tbld.altidxtentid" + ", "
					+		"tbld.altidxid" + ", "
					+		"tbld.qualtentid" + ", "
					+		"tbld.qualtblid" + ", "
					+		"tbld.polybase" + ", "
					+		"tbld.isinstantiable" + ", "
					+		"tbld.hashistory" + ", "
					+		"tbld.hasauditcolumns" + ", "
					+		"tbld.loadbehavid" + ", "
					+		"tbld.datascopeid" + ", "
					+		"tbld.secscopeid" + ", "
					+		"tbld.vasecid" + ", "
					+		"tbld.easecid" + ", "
					+		"tbld.vafid" + ", "
					+		"tbld.eafid" + ", "
					+		"tbld.jobj_memb" + ", "
					+		"tbld.jobj_xface" + ", "
					+		"tbld.jtbl_objimp" + ", "
					+		"tbld.jobj_impl" + ", "
					+		"tbld.jedt_memb" + ", "
					+		"tbld.jedt_xface" + ", "
					+		"tbld.jtbl_eobjimp" + ", "
					+		"tbld.jedt_impl" + ", "
					+		"tbld.jtbl_imp" + ", "
					+		"tbld.jtbl_memb" + ", "
					+		"tbld.jtbl_xface" + ", "
					+		"tbld.jtbl_impl" + ", "
					+		"tbld.jtbl_objimp" + ", "
					+		"tbld.jtbl_objmemb" + ", "
					+		"tbld.jtbl_objxface" + ", "
					+		"tbld.jtbl_objimpl" + ", "
					+		"tbld.jtbl_db2imp" + ", "
					+		"tbld.jdb2_memb" + ", "
					+		"tbld.jdb2_impl" + ", "
					+		"tbld.jtbl_msimp" + ", "
					+		"tbld.jmssql_memb" + ", "
					+		"tbld.jmssql_impl" + ", "
					+		"tbld.jtbl_myimp" + ", "
					+		"tbld.jmysql_memb" + ", "
					+		"tbld.jmysql_impl" + ", "
					+		"tbld.jtbl_oraimp" + ", "
					+		"tbld.joracle_memb" + ", "
					+		"tbld.joracle_impl" + ", "
					+		"tbld.jtbl_pgimp" + ", "
					+		"tbld.jpgsql_memb" + ", "
					+		"tbld.jpgsql_impl" + ", "
					+		"tbld.jtbl_sybaseimp" + ", "
					+		"tbld.jsybase_memb" + ", "
					+		"tbld.jsybase_impl" + ", "
					+		"tbld.jtbl_ramimp" + ", "
					+		"tbld.jram_memb" + ", "
					+		"tbld.jram_impl" + ", "
					+		"tbld.jtbl_saxldimp" + ", "
					+		"tbld.jsaxstart_memb" + ", "
					+		"tbld.jsaxend_impl" + ", "
					+		"tbld.jxmtbl_imp" + ", "
					+		"tbld.jxmtbl_fmt" + ", "
					+		"tbld.jxmtbl_rqstimp" + ", "
					+		"tbld.jxmtbl_rspnimp" + ", "
					+		"tbld.jxmtbl_clntimp" + ", "
					+		"tbld.jxmtbl_rqstbdy" + ", "
					+		"tbld.jxmtbl_rspnbdy" + ", "
					+		"tbld.jxmtbl_clntbdy" + ", "
					+		"tbld.dflt_vis" + ", "
					+		" scop.revision, "
					+		" 1 "
					+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..tbldef tbld ON "
				+		"tbld.TenantId = scop.TenantId "
				+		"AND tbld.Id = scop.Id "
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

	protected static String S_sqlSelectTableDistinctClassCode = null;

	public String getSqlSelectTableDistinctClassCode() {
		if( S_sqlSelectTableDistinctClassCode == null ) {
			S_sqlSelectTableDistinctClassCode =
					"SELECT "
				+		"DISTINCT scop.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..tbldef tbld ON "
				+		"tbld.TenantId = scop.TenantId "
				+		"AND tbld.Id = scop.Id ";
		}
		return( S_sqlSelectTableDistinctClassCode );
	}

	protected static String S_sqlSelectTableBuff = null;

	public String getSqlSelectTableBuff() {
		if( S_sqlSelectTableBuff == null ) {
			S_sqlSelectTableBuff =
					"SELECT "
				+		"scop.ClassCode, "
				+		"scop.tenantid, "
				+		"scop.id, "
				+		"tbld.schemadefid, "
				+		"tbld.defschtentid, "
				+		"tbld.defschid, "
				+		"tbld.name, "
				+		"tbld.dbname, "
				+		"tbld.short_name, "
				+		"tbld.label, "
				+		"tbld.short_descr, "
				+		"tbld.descr, "
				+		"tbld.primidxtentid, "
				+		"tbld.primidxid, "
				+		"tbld.tblclscd, "
				+		"tbld.lookidxtentid, "
				+		"tbld.lookidxid, "
				+		"tbld.altidxtentid, "
				+		"tbld.altidxid, "
				+		"tbld.qualtentid, "
				+		"tbld.qualtblid, "
				+		"tbld.polybase, "
				+		"tbld.isinstantiable, "
				+		"tbld.hashistory, "
				+		"tbld.hasauditcolumns, "
				+		"tbld.loadbehavid, "
				+		"tbld.datascopeid, "
				+		"tbld.secscopeid, "
				+		"tbld.vasecid, "
				+		"tbld.easecid, "
				+		"tbld.vafid, "
				+		"tbld.eafid, "
				+		"tbld.jobj_memb, "
				+		"tbld.jobj_xface, "
				+		"tbld.jtbl_objimp, "
				+		"tbld.jobj_impl, "
				+		"tbld.jedt_memb, "
				+		"tbld.jedt_xface, "
				+		"tbld.jtbl_eobjimp, "
				+		"tbld.jedt_impl, "
				+		"tbld.jtbl_imp, "
				+		"tbld.jtbl_memb, "
				+		"tbld.jtbl_xface, "
				+		"tbld.jtbl_impl, "
				+		"tbld.jtbl_objimp, "
				+		"tbld.jtbl_objmemb, "
				+		"tbld.jtbl_objxface, "
				+		"tbld.jtbl_objimpl, "
				+		"tbld.jtbl_db2imp, "
				+		"tbld.jdb2_memb, "
				+		"tbld.jdb2_impl, "
				+		"tbld.jtbl_msimp, "
				+		"tbld.jmssql_memb, "
				+		"tbld.jmssql_impl, "
				+		"tbld.jtbl_myimp, "
				+		"tbld.jmysql_memb, "
				+		"tbld.jmysql_impl, "
				+		"tbld.jtbl_oraimp, "
				+		"tbld.joracle_memb, "
				+		"tbld.joracle_impl, "
				+		"tbld.jtbl_pgimp, "
				+		"tbld.jpgsql_memb, "
				+		"tbld.jpgsql_impl, "
				+		"tbld.jtbl_sybaseimp, "
				+		"tbld.jsybase_memb, "
				+		"tbld.jsybase_impl, "
				+		"tbld.jtbl_ramimp, "
				+		"tbld.jram_memb, "
				+		"tbld.jram_impl, "
				+		"tbld.jtbl_saxldimp, "
				+		"tbld.jsaxstart_memb, "
				+		"tbld.jsaxend_impl, "
				+		"tbld.jxmtbl_imp, "
				+		"tbld.jxmtbl_fmt, "
				+		"tbld.jxmtbl_rqstimp, "
				+		"tbld.jxmtbl_rspnimp, "
				+		"tbld.jxmtbl_clntimp, "
				+		"tbld.jxmtbl_rqstbdy, "
				+		"tbld.jxmtbl_rspnbdy, "
				+		"tbld.jxmtbl_clntbdy, "
				+		"tbld.dflt_vis, "
				+		"scop.revision "
				+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..tbldef tbld ON "
				+		"tbld.TenantId = scop.TenantId "
				+		"AND tbld.Id = scop.Id ";
		}
		return( S_sqlSelectTableBuff );
	}

	protected CFBamTableBuff unpackTableResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackTableResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamTableBuff buff;
		if( classCode.equals( "TBLD" ) ) {
			buff = schema.getFactoryTable().newBuff();
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
		buff.setRequiredSchemaDefId( resultSet.getLong( idxcol ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefSchemaTenantId( null );
			}
			else {
				buff.setOptionalDefSchemaTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefSchemaId( null );
			}
			else {
				buff.setOptionalDefSchemaId( colVal );
			}
		}
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
				buff.setOptionalPrimaryIndexTenantId( null );
			}
			else {
				buff.setOptionalPrimaryIndexTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalPrimaryIndexId( null );
			}
			else {
				buff.setOptionalPrimaryIndexId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredTableClassCode( resultSet.getString( idxcol ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalLookupIndexTenantId( null );
			}
			else {
				buff.setOptionalLookupIndexTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalLookupIndexId( null );
			}
			else {
				buff.setOptionalLookupIndexId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalAltIndexTenantId( null );
			}
			else {
				buff.setOptionalAltIndexTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalAltIndexId( null );
			}
			else {
				buff.setOptionalAltIndexId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalQualifyingTenantId( null );
			}
			else {
				buff.setOptionalQualifyingTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalQualifyingTableId( null );
			}
			else {
				buff.setOptionalQualifyingTableId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredPolyBase( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredIsInstantiable( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredHasHistory( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredHasAuditColumns( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredLoaderBehaviourId( resultSet.getShort( idxcol ) );
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
		buff.setRequiredSecurityScopeId( resultSet.getShort( idxcol ) );
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
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJObjMembers( null );
			}
			else {
				buff.setOptionalJObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJObjInterface( null );
			}
			else {
				buff.setOptionalJObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJObjImport( null );
			}
			else {
				buff.setOptionalJObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJObjImplementation( null );
			}
			else {
				buff.setOptionalJObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJEditObjMembers( null );
			}
			else {
				buff.setOptionalJEditObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJEditObjInterface( null );
			}
			else {
				buff.setOptionalJEditObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJEditObjImport( null );
			}
			else {
				buff.setOptionalJEditObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJEditObjImplementation( null );
			}
			else {
				buff.setOptionalJEditObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableImport( null );
			}
			else {
				buff.setOptionalJTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableMembers( null );
			}
			else {
				buff.setOptionalJTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableInterface( null );
			}
			else {
				buff.setOptionalJTableInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableImplementation( null );
			}
			else {
				buff.setOptionalJTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableObjImport( null );
			}
			else {
				buff.setOptionalJTableObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableObjMembers( null );
			}
			else {
				buff.setOptionalJTableObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableObjInterface( null );
			}
			else {
				buff.setOptionalJTableObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableObjImplementation( null );
			}
			else {
				buff.setOptionalJTableObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJDb2LUWTableImport( null );
			}
			else {
				buff.setOptionalJDb2LUWTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJDb2LUWTableMembers( null );
			}
			else {
				buff.setOptionalJDb2LUWTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJDb2LUWTableImplementation( null );
			}
			else {
				buff.setOptionalJDb2LUWTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMSSqlTableImport( null );
			}
			else {
				buff.setOptionalJMSSqlTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMSSqlTableMembers( null );
			}
			else {
				buff.setOptionalJMSSqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMSSqlTableImplementation( null );
			}
			else {
				buff.setOptionalJMSSqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMySqlTableImport( null );
			}
			else {
				buff.setOptionalJMySqlTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMySqlTableMembers( null );
			}
			else {
				buff.setOptionalJMySqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMySqlTableImplementation( null );
			}
			else {
				buff.setOptionalJMySqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJOracleTableImport( null );
			}
			else {
				buff.setOptionalJOracleTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJOracleTableMembers( null );
			}
			else {
				buff.setOptionalJOracleTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJOracleTableImplementation( null );
			}
			else {
				buff.setOptionalJOracleTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJPgSqlTableImport( null );
			}
			else {
				buff.setOptionalJPgSqlTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJPgSqlTableMembers( null );
			}
			else {
				buff.setOptionalJPgSqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJPgSqlTableImplementation( null );
			}
			else {
				buff.setOptionalJPgSqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSybaseTableImport( null );
			}
			else {
				buff.setOptionalJSybaseTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSybaseTableMembers( null );
			}
			else {
				buff.setOptionalJSybaseTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSybaseTableImplementation( null );
			}
			else {
				buff.setOptionalJSybaseTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJRamTableImport( null );
			}
			else {
				buff.setOptionalJRamTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJRamTableMembers( null );
			}
			else {
				buff.setOptionalJRamTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJRamTableImplementation( null );
			}
			else {
				buff.setOptionalJRamTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSaxLoaderImport( null );
			}
			else {
				buff.setOptionalJSaxLoaderImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSaxLoaderStartElement( null );
			}
			else {
				buff.setOptionalJSaxLoaderStartElement( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSaxLoaderEndElement( null );
			}
			else {
				buff.setOptionalJSaxLoaderEndElement( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgTableImport( null );
			}
			else {
				buff.setOptionalJXMsgTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgTableFormatters( null );
			}
			else {
				buff.setOptionalJXMsgTableFormatters( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRqstTableImport( null );
			}
			else {
				buff.setOptionalJXMsgRqstTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRspnTableImport( null );
			}
			else {
				buff.setOptionalJXMsgRspnTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgClientTableImport( null );
			}
			else {
				buff.setOptionalJXMsgClientTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRqstTableBody( null );
			}
			else {
				buff.setOptionalJXMsgRqstTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRspnTableBody( null );
			}
			else {
				buff.setOptionalJXMsgRspnTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgClientTableBody( null );
			}
			else {
				buff.setOptionalJXMsgClientTableBody( colVal );
			}
		}
		idxcol++;
		buff.setRequiredDefaultVisibility( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamTableBuff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamTableBuff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamTableBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamTableBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamTableBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamMSSqlTableTable.readDerivedByIdIdx() ";
		CFBamTableBuff buff;
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

	public CFBamTableBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByTenantIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedBySchemaDefIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		final String S_ProcName = "readDerivedBySchemaDefIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffBySchemaDefIdx( Authorization,
				TenantId,
				SchemaDefId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByDefSchemaIdx( Authorization,
				DefSchemaTenantId,
				DefSchemaId );
		return( buffList );

	}

	public CFBamTableBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String Name )
	{
		final String S_ProcName = "CFBamMSSqlTableTable.readDerivedByUNameIdx() ";
		CFBamTableBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUNameIdx( Authorization,
				TenantId,
				SchemaDefId,
				Name );
		return( buff );
	}

	public CFBamTableBuff readDerivedBySchemaCdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		final String S_ProcName = "CFBamMSSqlTableTable.readDerivedBySchemaCdIdx() ";
		CFBamTableBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffBySchemaCdIdx( Authorization,
				TenantId,
				SchemaDefId,
				TableClassCode );
		return( buff );
	}

	public CFBamTableBuff[] readDerivedByPrimaryIndexIdx( CFBamAuthorization Authorization,
		Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		final String S_ProcName = "readDerivedByPrimaryIndexIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByPrimaryIndexIdx( Authorization,
				PrimaryIndexTenantId,
				PrimaryIndexId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByLookupIndexIdx( CFBamAuthorization Authorization,
		Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		final String S_ProcName = "readDerivedByLookupIndexIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByLookupIndexIdx( Authorization,
				LookupIndexTenantId,
				LookupIndexId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByAltIndexIdx( CFBamAuthorization Authorization,
		Long AltIndexTenantId,
		Long AltIndexId )
	{
		final String S_ProcName = "readDerivedByAltIndexIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByAltIndexIdx( Authorization,
				AltIndexTenantId,
				AltIndexId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByQualTableIdx( CFBamAuthorization Authorization,
		Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		final String S_ProcName = "readDerivedByQualTableIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByQualTableIdx( Authorization,
				QualifyingTenantId,
				QualifyingTableId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByLoadBehaveIdx( CFBamAuthorization Authorization,
		short LoaderBehaviourId )
	{
		final String S_ProcName = "readDerivedByLoadBehaveIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByLoadBehaveIdx( Authorization,
				LoaderBehaviourId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "readDerivedByDataScopeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByDataScopeIdx( Authorization,
				DataScopeId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedBySecScopeIdx( CFBamAuthorization Authorization,
		short SecurityScopeId )
	{
		final String S_ProcName = "readDerivedBySecScopeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffBySecScopeIdx( Authorization,
				SecurityScopeId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "readDerivedByVAccSecIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByVAccSecIdx( Authorization,
				ViewAccessSecurityId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "readDerivedByVAccFreqIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByVAccFreqIdx( Authorization,
				ViewAccessFrequencyId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "readDerivedByEAccSecIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByEAccSecIdx( Authorization,
				EditAccessSecurityId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "readDerivedByEAccFreqIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByEAccFreqIdx( Authorization,
				EditAccessFrequencyId );
		return( buffList );

	}

	public CFBamTableBuff readBuff( CFBamAuthorization Authorization,
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
			String sql = "{ call sp_read_tbldef( ?, ?, ?, ?, ?" + ", "
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
				CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
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

	public CFBamTableBuff lockBuff( CFBamAuthorization Authorization,
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
			String sql = "{ call sp_lock_tbldef( ?, ?, ?, ?, ?" + ", "
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
				CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
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

	public CFBamTableBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_all( ?, ?, ?, ?, ? ) }";
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
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_ididx( ?, ?, ?, ?, ?" + ", "
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
				CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
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

	public CFBamTableBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByTenantIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_tenantidx( ?, ?, ?, ?, ?" + ", "
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
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffBySchemaDefIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		final String S_ProcName = "readBuffBySchemaDefIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_schemadefidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffBySchemaDefIdx == null ) {
				stmtReadBuffBySchemaDefIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySchemaDefIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffBySchemaDefIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffBySchemaDefIdx.setLong( argIdx++, TenantId );
			stmtReadBuffBySchemaDefIdx.setLong( argIdx++, SchemaDefId );
			resultSet = stmtReadBuffBySchemaDefIdx.executeQuery();
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readBuffByDefSchemaIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_defschemaidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByDefSchemaIdx == null ) {
				stmtReadBuffByDefSchemaIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DefSchemaTenantId != null ) {
				stmtReadBuffByDefSchemaIdx.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtReadBuffByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtReadBuffByDefSchemaIdx.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtReadBuffByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByDefSchemaIdx.executeQuery();
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String Name )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_unameidx( ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByUNameIdx.setLong( argIdx++, SchemaDefId );
			stmtReadBuffByUNameIdx.setString( argIdx++, Name );
			resultSet = stmtReadBuffByUNameIdx.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
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

	public CFBamTableBuff readBuffBySchemaCdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		final String S_ProcName = "readBuffBySchemaCdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_schemacdidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffBySchemaCdIdx == null ) {
				stmtReadBuffBySchemaCdIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySchemaCdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffBySchemaCdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffBySchemaCdIdx.setLong( argIdx++, TenantId );
			stmtReadBuffBySchemaCdIdx.setLong( argIdx++, SchemaDefId );
			stmtReadBuffBySchemaCdIdx.setString( argIdx++, TableClassCode );
			resultSet = stmtReadBuffBySchemaCdIdx.executeQuery();
			if( ( resultSet != null ) && resultSet.next() ) {
				CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
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

	public CFBamTableBuff[] readBuffByPrimaryIndexIdx( CFBamAuthorization Authorization,
		Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		final String S_ProcName = "readBuffByPrimaryIndexIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_primaryindexidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByPrimaryIndexIdx == null ) {
				stmtReadBuffByPrimaryIndexIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPrimaryIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPrimaryIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( PrimaryIndexTenantId != null ) {
				stmtReadBuffByPrimaryIndexIdx.setLong( argIdx++, PrimaryIndexTenantId.longValue() );
			}
			else {
				stmtReadBuffByPrimaryIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrimaryIndexId != null ) {
				stmtReadBuffByPrimaryIndexIdx.setLong( argIdx++, PrimaryIndexId.longValue() );
			}
			else {
				stmtReadBuffByPrimaryIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByPrimaryIndexIdx.executeQuery();
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffByLookupIndexIdx( CFBamAuthorization Authorization,
		Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		final String S_ProcName = "readBuffByLookupIndexIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_lookupindexidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByLookupIndexIdx == null ) {
				stmtReadBuffByLookupIndexIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByLookupIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByLookupIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( LookupIndexTenantId != null ) {
				stmtReadBuffByLookupIndexIdx.setLong( argIdx++, LookupIndexTenantId.longValue() );
			}
			else {
				stmtReadBuffByLookupIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( LookupIndexId != null ) {
				stmtReadBuffByLookupIndexIdx.setLong( argIdx++, LookupIndexId.longValue() );
			}
			else {
				stmtReadBuffByLookupIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByLookupIndexIdx.executeQuery();
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffByAltIndexIdx( CFBamAuthorization Authorization,
		Long AltIndexTenantId,
		Long AltIndexId )
	{
		final String S_ProcName = "readBuffByAltIndexIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_altindexidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByAltIndexIdx == null ) {
				stmtReadBuffByAltIndexIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByAltIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByAltIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( AltIndexTenantId != null ) {
				stmtReadBuffByAltIndexIdx.setLong( argIdx++, AltIndexTenantId.longValue() );
			}
			else {
				stmtReadBuffByAltIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( AltIndexId != null ) {
				stmtReadBuffByAltIndexIdx.setLong( argIdx++, AltIndexId.longValue() );
			}
			else {
				stmtReadBuffByAltIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByAltIndexIdx.executeQuery();
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffByQualTableIdx( CFBamAuthorization Authorization,
		Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		final String S_ProcName = "readBuffByQualTableIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_qualtableidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByQualTableIdx == null ) {
				stmtReadBuffByQualTableIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByQualTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByQualTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( QualifyingTenantId != null ) {
				stmtReadBuffByQualTableIdx.setLong( argIdx++, QualifyingTenantId.longValue() );
			}
			else {
				stmtReadBuffByQualTableIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( QualifyingTableId != null ) {
				stmtReadBuffByQualTableIdx.setLong( argIdx++, QualifyingTableId.longValue() );
			}
			else {
				stmtReadBuffByQualTableIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtReadBuffByQualTableIdx.executeQuery();
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffByLoadBehaveIdx( CFBamAuthorization Authorization,
		short LoaderBehaviourId )
	{
		final String S_ProcName = "readBuffByLoadBehaveIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_loadbehaveidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffByLoadBehaveIdx == null ) {
				stmtReadBuffByLoadBehaveIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByLoadBehaveIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByLoadBehaveIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByLoadBehaveIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByLoadBehaveIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByLoadBehaveIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByLoadBehaveIdx.setShort( argIdx++, LoaderBehaviourId );
			resultSet = stmtReadBuffByLoadBehaveIdx.executeQuery();
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "readBuffByDataScopeIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_datascopeidx( ?, ?, ?, ?, ?" + ", "
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
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffBySecScopeIdx( CFBamAuthorization Authorization,
		short SecurityScopeId )
	{
		final String S_ProcName = "readBuffBySecScopeIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_secscopeidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ) }";
			if( stmtReadBuffBySecScopeIdx == null ) {
				stmtReadBuffBySecScopeIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffBySecScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySecScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffBySecScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffBySecScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySecScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffBySecScopeIdx.setShort( argIdx++, SecurityScopeId );
			resultSet = stmtReadBuffBySecScopeIdx.executeQuery();
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "readBuffByVAccSecIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_vaccsecidx( ?, ?, ?, ?, ?" + ", "
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
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "readBuffByVAccFreqIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_vaccfreqidx( ?, ?, ?, ?, ?" + ", "
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
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "readBuffByEAccSecIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_eaccsecidx( ?, ?, ?, ?, ?" + ", "
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
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public CFBamTableBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "readBuffByEAccFreqIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "{ call sp_read_tbldef_by_eaccfreqidx( ?, ?, ?, ?, ?" + ", "
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
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			if( resultSet != null ) {
				while( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					buffList.add( buff );
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
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

	public void updateTable( CFBamAuthorization Authorization,
		CFBamTableBuff Buff )
	{
		final String S_ProcName = "updateTable";
		if( "TBLD".equals( Buff.getClassCode() )
			&& ( ! schema.isTenantUser( Authorization,
				Buff.getRequiredTenantId(),
				"UpdateTable" ) ) )
		{
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Permission denied -- User not part of TSecGroup UpdateTable" );
		}
		schema.getTableScope().updateScope( Authorization, Buff );
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long SchemaDefId = Buff.getRequiredSchemaDefId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			long Id = Buff.getRequiredId();
			String Name = Buff.getRequiredName();
			String DbName = Buff.getOptionalDbName();
			String ShortName = Buff.getOptionalShortName();
			String Label = Buff.getOptionalLabel();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			Long PrimaryIndexTenantId = Buff.getOptionalPrimaryIndexTenantId();
			Long PrimaryIndexId = Buff.getOptionalPrimaryIndexId();
			String TableClassCode = Buff.getRequiredTableClassCode();
			Long LookupIndexTenantId = Buff.getOptionalLookupIndexTenantId();
			Long LookupIndexId = Buff.getOptionalLookupIndexId();
			Long AltIndexTenantId = Buff.getOptionalAltIndexTenantId();
			Long AltIndexId = Buff.getOptionalAltIndexId();
			Long QualifyingTenantId = Buff.getOptionalQualifyingTenantId();
			Long QualifyingTableId = Buff.getOptionalQualifyingTableId();
			boolean PolyBase = Buff.getRequiredPolyBase();
			boolean IsInstantiable = Buff.getRequiredIsInstantiable();
			boolean HasHistory = Buff.getRequiredHasHistory();
			boolean HasAuditColumns = Buff.getRequiredHasAuditColumns();
			short LoaderBehaviourId = Buff.getRequiredLoaderBehaviourId();
			Short DataScopeId = Buff.getOptionalDataScopeId();
			short SecurityScopeId = Buff.getRequiredSecurityScopeId();
			Short ViewAccessSecurityId = Buff.getOptionalViewAccessSecurityId();
			Short EditAccessSecurityId = Buff.getOptionalEditAccessSecurityId();
			Short ViewAccessFrequencyId = Buff.getOptionalViewAccessFrequencyId();
			Short EditAccessFrequencyId = Buff.getOptionalEditAccessFrequencyId();
			String JObjMembers = Buff.getOptionalJObjMembers();
			String JObjInterface = Buff.getOptionalJObjInterface();
			String JObjImport = Buff.getOptionalJObjImport();
			String JObjImplementation = Buff.getOptionalJObjImplementation();
			String JEditObjMembers = Buff.getOptionalJEditObjMembers();
			String JEditObjInterface = Buff.getOptionalJEditObjInterface();
			String JEditObjImport = Buff.getOptionalJEditObjImport();
			String JEditObjImplementation = Buff.getOptionalJEditObjImplementation();
			String JTableImport = Buff.getOptionalJTableImport();
			String JTableMembers = Buff.getOptionalJTableMembers();
			String JTableInterface = Buff.getOptionalJTableInterface();
			String JTableImplementation = Buff.getOptionalJTableImplementation();
			String JTableObjImport = Buff.getOptionalJTableObjImport();
			String JTableObjMembers = Buff.getOptionalJTableObjMembers();
			String JTableObjInterface = Buff.getOptionalJTableObjInterface();
			String JTableObjImplementation = Buff.getOptionalJTableObjImplementation();
			String JDb2LUWTableImport = Buff.getOptionalJDb2LUWTableImport();
			String JDb2LUWTableMembers = Buff.getOptionalJDb2LUWTableMembers();
			String JDb2LUWTableImplementation = Buff.getOptionalJDb2LUWTableImplementation();
			String JMSSqlTableImport = Buff.getOptionalJMSSqlTableImport();
			String JMSSqlTableMembers = Buff.getOptionalJMSSqlTableMembers();
			String JMSSqlTableImplementation = Buff.getOptionalJMSSqlTableImplementation();
			String JMySqlTableImport = Buff.getOptionalJMySqlTableImport();
			String JMySqlTableMembers = Buff.getOptionalJMySqlTableMembers();
			String JMySqlTableImplementation = Buff.getOptionalJMySqlTableImplementation();
			String JOracleTableImport = Buff.getOptionalJOracleTableImport();
			String JOracleTableMembers = Buff.getOptionalJOracleTableMembers();
			String JOracleTableImplementation = Buff.getOptionalJOracleTableImplementation();
			String JPgSqlTableImport = Buff.getOptionalJPgSqlTableImport();
			String JPgSqlTableMembers = Buff.getOptionalJPgSqlTableMembers();
			String JPgSqlTableImplementation = Buff.getOptionalJPgSqlTableImplementation();
			String JSybaseTableImport = Buff.getOptionalJSybaseTableImport();
			String JSybaseTableMembers = Buff.getOptionalJSybaseTableMembers();
			String JSybaseTableImplementation = Buff.getOptionalJSybaseTableImplementation();
			String JRamTableImport = Buff.getOptionalJRamTableImport();
			String JRamTableMembers = Buff.getOptionalJRamTableMembers();
			String JRamTableImplementation = Buff.getOptionalJRamTableImplementation();
			String JSaxLoaderImport = Buff.getOptionalJSaxLoaderImport();
			String JSaxLoaderStartElement = Buff.getOptionalJSaxLoaderStartElement();
			String JSaxLoaderEndElement = Buff.getOptionalJSaxLoaderEndElement();
			String JXMsgTableImport = Buff.getOptionalJXMsgTableImport();
			String JXMsgTableFormatters = Buff.getOptionalJXMsgTableFormatters();
			String JXMsgRqstTableImport = Buff.getOptionalJXMsgRqstTableImport();
			String JXMsgRspnTableImport = Buff.getOptionalJXMsgRspnTableImport();
			String JXMsgClientTableImport = Buff.getOptionalJXMsgClientTableImport();
			String JXMsgRqstTableBody = Buff.getOptionalJXMsgRqstTableBody();
			String JXMsgRspnTableBody = Buff.getOptionalJXMsgRspnTableBody();
			String JXMsgClientTableBody = Buff.getOptionalJXMsgClientTableBody();
			boolean DefaultVisibility = Buff.getRequiredDefaultVisibility();
			int Revision = Buff.getRequiredRevision();

			String sql =
					"UPDATE " + schema.getLowerDbSchemaName() + "..tbldef "
				+	"SET "
				+		"tenantid = ?" + ", "
				+		"schemadefid = ?" + ", "
				+		"defschtentid = ?" + ", "
				+		"defschid = ?" + ", "
				+		"id = ?" + ", "
				+		"name = ?" + ", "
				+		"dbname = ?" + ", "
				+		"short_name = ?" + ", "
				+		"label = ?" + ", "
				+		"short_descr = ?" + ", "
				+		"descr = ?" + ", "
				+		"primidxtentid = ?" + ", "
				+		"primidxid = ?" + ", "
				+		"tblclscd = ?" + ", "
				+		"lookidxtentid = ?" + ", "
				+		"lookidxid = ?" + ", "
				+		"altidxtentid = ?" + ", "
				+		"altidxid = ?" + ", "
				+		"qualtentid = ?" + ", "
				+		"qualtblid = ?" + ", "
				+		"polybase = ?" + ", "
				+		"isinstantiable = ?" + ", "
				+		"hashistory = ?" + ", "
				+		"hasauditcolumns = ?" + ", "
				+		"loadbehavid = ?" + ", "
				+		"datascopeid = ?" + ", "
				+		"secscopeid = ?" + ", "
				+		"vasecid = ?" + ", "
				+		"easecid = ?" + ", "
				+		"vafid = ?" + ", "
				+		"eafid = ?" + ", "
				+		"jobj_memb = ?" + ", "
				+		"jobj_xface = ?" + ", "
				+		"jtbl_objimp = ?" + ", "
				+		"jobj_impl = ?" + ", "
				+		"jedt_memb = ?" + ", "
				+		"jedt_xface = ?" + ", "
				+		"jtbl_eobjimp = ?" + ", "
				+		"jedt_impl = ?" + ", "
				+		"jtbl_imp = ?" + ", "
				+		"jtbl_memb = ?" + ", "
				+		"jtbl_xface = ?" + ", "
				+		"jtbl_impl = ?" + ", "
				+		"jtbl_objimp = ?" + ", "
				+		"jtbl_objmemb = ?" + ", "
				+		"jtbl_objxface = ?" + ", "
				+		"jtbl_objimpl = ?" + ", "
				+		"jtbl_db2imp = ?" + ", "
				+		"jdb2_memb = ?" + ", "
				+		"jdb2_impl = ?" + ", "
				+		"jtbl_msimp = ?" + ", "
				+		"jmssql_memb = ?" + ", "
				+		"jmssql_impl = ?" + ", "
				+		"jtbl_myimp = ?" + ", "
				+		"jmysql_memb = ?" + ", "
				+		"jmysql_impl = ?" + ", "
				+		"jtbl_oraimp = ?" + ", "
				+		"joracle_memb = ?" + ", "
				+		"joracle_impl = ?" + ", "
				+		"jtbl_pgimp = ?" + ", "
				+		"jpgsql_memb = ?" + ", "
				+		"jpgsql_impl = ?" + ", "
				+		"jtbl_sybaseimp = ?" + ", "
				+		"jsybase_memb = ?" + ", "
				+		"jsybase_impl = ?" + ", "
				+		"jtbl_ramimp = ?" + ", "
				+		"jram_memb = ?" + ", "
				+		"jram_impl = ?" + ", "
				+		"jtbl_saxldimp = ?" + ", "
				+		"jsaxstart_memb = ?" + ", "
				+		"jsaxend_impl = ?" + ", "
				+		"jxmtbl_imp = ?" + ", "
				+		"jxmtbl_fmt = ?" + ", "
				+		"jxmtbl_rqstimp = ?" + ", "
				+		"jxmtbl_rspnimp = ?" + ", "
				+		"jxmtbl_clntimp = ?" + ", "
				+		"jxmtbl_rqstbdy = ?" + ", "
				+		"jxmtbl_rspnbdy = ?" + ", "
				+		"jxmtbl_clntbdy = ?" + ", "
				+		"dflt_vis = ?"
				+	" WHERE "
				+		"tenantid = ? "
				+	"AND "
				+		"id = ? ";
			if( stmtUpdateByPKey == null ) {
				stmtUpdateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;

			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, SchemaDefId );
			if( DefSchemaTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtUpdateByPKey.setLong( argIdx++, Id );
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
			if( PrimaryIndexTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, PrimaryIndexTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrimaryIndexId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, PrimaryIndexId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtUpdateByPKey.setString( argIdx++, TableClassCode );
			if( LookupIndexTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, LookupIndexTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( LookupIndexId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, LookupIndexId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( AltIndexTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, AltIndexTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( AltIndexId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, AltIndexId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( QualifyingTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, QualifyingTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( QualifyingTableId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, QualifyingTableId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PolyBase ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( IsInstantiable ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( HasHistory ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( HasAuditColumns ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			stmtUpdateByPKey.setShort( argIdx++, LoaderBehaviourId );
			if( DataScopeId != null ) {
				stmtUpdateByPKey.setShort( argIdx++, DataScopeId.shortValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.SMALLINT );
			}
			stmtUpdateByPKey.setShort( argIdx++, SecurityScopeId );
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
			if( JObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, JObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JEditObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JEditObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JEditObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, JEditObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JEditObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JEditObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JEditObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JEditObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JTableObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JDb2LUWTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JDb2LUWTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JDb2LUWTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JDb2LUWTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMSSqlTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMSSqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMSSqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMSSqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMySqlTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMySqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JMySqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMySqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JOracleTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JOracleTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JOracleTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JOracleTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JPgSqlTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JPgSqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JPgSqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JPgSqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSybaseTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSybaseTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSybaseTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSybaseTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JRamTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JRamTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JRamTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JRamTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSaxLoaderImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSaxLoaderImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSaxLoaderStartElement != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSaxLoaderStartElement );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JSaxLoaderEndElement != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSaxLoaderEndElement );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgTableFormatters != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgTableFormatters );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRqstTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRspnTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgClientTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgClientTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRqstTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRqstTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgRspnTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRspnTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( JXMsgClientTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgClientTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( DefaultVisibility ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, Id );;
			int rowsAffected = stmtUpdateByPKey.executeUpdate();
			if( rowsAffected != 1 ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be affected by update, not " + rowsAffected );
			}
			if( "TBLD".equals( Buff.getClassCode() ) ) {
				String sqlAuditUpdated =
						"INSERT INTO " + schema.getLowerDbSchemaName() + "..tbldef_h( auditclusterid, "
					+		" auditsessionid, "
					+		" auditstamp, "
					+		" classcode" + ", "
					+		"tenantid" + ", "
					+		"id" + ", "
					+		"schemadefid" + ", "
					+		"defschtentid" + ", "
					+		"defschid" + ", "
					+		"name" + ", "
					+		"dbname" + ", "
					+		"short_name" + ", "
					+		"label" + ", "
					+		"short_descr" + ", "
					+		"descr" + ", "
					+		"primidxtentid" + ", "
					+		"primidxid" + ", "
					+		"tblclscd" + ", "
					+		"lookidxtentid" + ", "
					+		"lookidxid" + ", "
					+		"altidxtentid" + ", "
					+		"altidxid" + ", "
					+		"qualtentid" + ", "
					+		"qualtblid" + ", "
					+		"polybase" + ", "
					+		"isinstantiable" + ", "
					+		"hashistory" + ", "
					+		"hasauditcolumns" + ", "
					+		"loadbehavid" + ", "
					+		"datascopeid" + ", "
					+		"secscopeid" + ", "
					+		"vasecid" + ", "
					+		"easecid" + ", "
					+		"vafid" + ", "
					+		"eafid" + ", "
					+		"jobj_memb" + ", "
					+		"jobj_xface" + ", "
					+		"jtbl_objimp" + ", "
					+		"jobj_impl" + ", "
					+		"jedt_memb" + ", "
					+		"jedt_xface" + ", "
					+		"jtbl_eobjimp" + ", "
					+		"jedt_impl" + ", "
					+		"jtbl_imp" + ", "
					+		"jtbl_memb" + ", "
					+		"jtbl_xface" + ", "
					+		"jtbl_impl" + ", "
					+		"jtbl_objimp" + ", "
					+		"jtbl_objmemb" + ", "
					+		"jtbl_objxface" + ", "
					+		"jtbl_objimpl" + ", "
					+		"jtbl_db2imp" + ", "
					+		"jdb2_memb" + ", "
					+		"jdb2_impl" + ", "
					+		"jtbl_msimp" + ", "
					+		"jmssql_memb" + ", "
					+		"jmssql_impl" + ", "
					+		"jtbl_myimp" + ", "
					+		"jmysql_memb" + ", "
					+		"jmysql_impl" + ", "
					+		"jtbl_oraimp" + ", "
					+		"joracle_memb" + ", "
					+		"joracle_impl" + ", "
					+		"jtbl_pgimp" + ", "
					+		"jpgsql_memb" + ", "
					+		"jpgsql_impl" + ", "
					+		"jtbl_sybaseimp" + ", "
					+		"jsybase_memb" + ", "
					+		"jsybase_impl" + ", "
					+		"jtbl_ramimp" + ", "
					+		"jram_memb" + ", "
					+		"jram_impl" + ", "
					+		"jtbl_saxldimp" + ", "
					+		"jsaxstart_memb" + ", "
					+		"jsaxend_impl" + ", "
					+		"jxmtbl_imp" + ", "
					+		"jxmtbl_fmt" + ", "
					+		"jxmtbl_rqstimp" + ", "
					+		"jxmtbl_rspnimp" + ", "
					+		"jxmtbl_clntimp" + ", "
					+		"jxmtbl_rqstbdy" + ", "
					+		"jxmtbl_rspnbdy" + ", "
					+		"jxmtbl_clntbdy" + ", "
					+		"dflt_vis" + ", "
					+		" revision, "
					+		" auditaction ) "
					+	"SELECT ?, ?, sysdatetime(), scop.classcode" + ", "
					+		"scop.tenantid"  + ", "
					+		"scop.id"  + ", "
					+		"tbld.schemadefid" + ", "
					+		"tbld.defschtentid" + ", "
					+		"tbld.defschid" + ", "
					+		"tbld.name" + ", "
					+		"tbld.dbname" + ", "
					+		"tbld.short_name" + ", "
					+		"tbld.label" + ", "
					+		"tbld.short_descr" + ", "
					+		"tbld.descr" + ", "
					+		"tbld.primidxtentid" + ", "
					+		"tbld.primidxid" + ", "
					+		"tbld.tblclscd" + ", "
					+		"tbld.lookidxtentid" + ", "
					+		"tbld.lookidxid" + ", "
					+		"tbld.altidxtentid" + ", "
					+		"tbld.altidxid" + ", "
					+		"tbld.qualtentid" + ", "
					+		"tbld.qualtblid" + ", "
					+		"tbld.polybase" + ", "
					+		"tbld.isinstantiable" + ", "
					+		"tbld.hashistory" + ", "
					+		"tbld.hasauditcolumns" + ", "
					+		"tbld.loadbehavid" + ", "
					+		"tbld.datascopeid" + ", "
					+		"tbld.secscopeid" + ", "
					+		"tbld.vasecid" + ", "
					+		"tbld.easecid" + ", "
					+		"tbld.vafid" + ", "
					+		"tbld.eafid" + ", "
					+		"tbld.jobj_memb" + ", "
					+		"tbld.jobj_xface" + ", "
					+		"tbld.jtbl_objimp" + ", "
					+		"tbld.jobj_impl" + ", "
					+		"tbld.jedt_memb" + ", "
					+		"tbld.jedt_xface" + ", "
					+		"tbld.jtbl_eobjimp" + ", "
					+		"tbld.jedt_impl" + ", "
					+		"tbld.jtbl_imp" + ", "
					+		"tbld.jtbl_memb" + ", "
					+		"tbld.jtbl_xface" + ", "
					+		"tbld.jtbl_impl" + ", "
					+		"tbld.jtbl_objimp" + ", "
					+		"tbld.jtbl_objmemb" + ", "
					+		"tbld.jtbl_objxface" + ", "
					+		"tbld.jtbl_objimpl" + ", "
					+		"tbld.jtbl_db2imp" + ", "
					+		"tbld.jdb2_memb" + ", "
					+		"tbld.jdb2_impl" + ", "
					+		"tbld.jtbl_msimp" + ", "
					+		"tbld.jmssql_memb" + ", "
					+		"tbld.jmssql_impl" + ", "
					+		"tbld.jtbl_myimp" + ", "
					+		"tbld.jmysql_memb" + ", "
					+		"tbld.jmysql_impl" + ", "
					+		"tbld.jtbl_oraimp" + ", "
					+		"tbld.joracle_memb" + ", "
					+		"tbld.joracle_impl" + ", "
					+		"tbld.jtbl_pgimp" + ", "
					+		"tbld.jpgsql_memb" + ", "
					+		"tbld.jpgsql_impl" + ", "
					+		"tbld.jtbl_sybaseimp" + ", "
					+		"tbld.jsybase_memb" + ", "
					+		"tbld.jsybase_impl" + ", "
					+		"tbld.jtbl_ramimp" + ", "
					+		"tbld.jram_memb" + ", "
					+		"tbld.jram_impl" + ", "
					+		"tbld.jtbl_saxldimp" + ", "
					+		"tbld.jsaxstart_memb" + ", "
					+		"tbld.jsaxend_impl" + ", "
					+		"tbld.jxmtbl_imp" + ", "
					+		"tbld.jxmtbl_fmt" + ", "
					+		"tbld.jxmtbl_rqstimp" + ", "
					+		"tbld.jxmtbl_rspnimp" + ", "
					+		"tbld.jxmtbl_clntimp" + ", "
					+		"tbld.jxmtbl_rqstbdy" + ", "
					+		"tbld.jxmtbl_rspnbdy" + ", "
					+		"tbld.jxmtbl_clntbdy" + ", "
					+		"tbld.dflt_vis" + ", "
					+		" scop.revision, "
					+		" 2 "
					+	"FROM " + schema.getLowerDbSchemaName() + "..scopedef AS scop "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + "..tbldef tbld ON "
				+		"tbld.TenantId = scop.TenantId "
				+		"AND tbld.Id = scop.Id "
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

	public void deleteTable( CFBamAuthorization Authorization,
		CFBamTableBuff Buff )
	{
		final String S_ProcName = "deleteTable";
		try {
			Connection cnx = schema.getCnx();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();

			String sql = "exec sp_delete_tbldef ?, ?, ?, ?, ?" + ", "
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

	public void deleteTableBySchemaDefIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId )
	{
		final String S_ProcName = "deleteTableBySchemaDefIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_schemadefidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteBySchemaDefIdx== null ) {
				stmtDeleteBySchemaDefIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteBySchemaDefIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteBySchemaDefIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteBySchemaDefIdx.setLong( argIdx++, argTenantId );
			stmtDeleteBySchemaDefIdx.setLong( argIdx++, argSchemaDefId );
			Object stuff = null;
			boolean moreResults = stmtDeleteBySchemaDefIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteBySchemaDefIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteBySchemaDefIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteBySchemaDefIdx.getUpdateCount() ) {
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

	public void deleteTableBySchemaDefIdx( CFBamAuthorization Authorization,
		CFBamTableBySchemaDefIdxKey argKey )
	{
		deleteTableBySchemaDefIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredSchemaDefId() );
	}

	public void deleteTableByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		final String S_ProcName = "deleteTableByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_defschemaidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByDefSchemaIdx== null ) {
				stmtDeleteByDefSchemaIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argDefSchemaTenantId != null ) {
				stmtDeleteByDefSchemaIdx.setLong( argIdx++, argDefSchemaTenantId.longValue() );
			}
			else {
				stmtDeleteByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( argDefSchemaId != null ) {
				stmtDeleteByDefSchemaIdx.setLong( argIdx++, argDefSchemaId.longValue() );
			}
			else {
				stmtDeleteByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByDefSchemaIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByDefSchemaIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByDefSchemaIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByDefSchemaIdx.getUpdateCount() ) {
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

	public void deleteTableByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamTableByDefSchemaIdxKey argKey )
	{
		deleteTableByDefSchemaIdx( Authorization,
			argKey.getOptionalDefSchemaTenantId(),
			argKey.getOptionalDefSchemaId() );
	}

	public void deleteTableByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId,
		String argName )
	{
		final String S_ProcName = "deleteTableByUNameIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_unameidx ?, ?, ?, ?, ?" + ", "
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
			stmtDeleteByUNameIdx.setLong( argIdx++, argSchemaDefId );
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

	public void deleteTableByUNameIdx( CFBamAuthorization Authorization,
		CFBamTableByUNameIdxKey argKey )
	{
		deleteTableByUNameIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredSchemaDefId(),
			argKey.getRequiredName() );
	}

	public void deleteTableBySchemaCdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId,
		String argTableClassCode )
	{
		final String S_ProcName = "deleteTableBySchemaCdIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_schemacdidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteBySchemaCdIdx== null ) {
				stmtDeleteBySchemaCdIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteBySchemaCdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteBySchemaCdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteBySchemaCdIdx.setLong( argIdx++, argTenantId );
			stmtDeleteBySchemaCdIdx.setLong( argIdx++, argSchemaDefId );
			stmtDeleteBySchemaCdIdx.setString( argIdx++, argTableClassCode );
			Object stuff = null;
			boolean moreResults = stmtDeleteBySchemaCdIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteBySchemaCdIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteBySchemaCdIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteBySchemaCdIdx.getUpdateCount() ) {
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

	public void deleteTableBySchemaCdIdx( CFBamAuthorization Authorization,
		CFBamTableBySchemaCdIdxKey argKey )
	{
		deleteTableBySchemaCdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredSchemaDefId(),
			argKey.getRequiredTableClassCode() );
	}

	public void deleteTableByPrimaryIndexIdx( CFBamAuthorization Authorization,
		Long argPrimaryIndexTenantId,
		Long argPrimaryIndexId )
	{
		final String S_ProcName = "deleteTableByPrimaryIndexIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_primaryindexidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByPrimaryIndexIdx== null ) {
				stmtDeleteByPrimaryIndexIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPrimaryIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPrimaryIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argPrimaryIndexTenantId != null ) {
				stmtDeleteByPrimaryIndexIdx.setLong( argIdx++, argPrimaryIndexTenantId.longValue() );
			}
			else {
				stmtDeleteByPrimaryIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( argPrimaryIndexId != null ) {
				stmtDeleteByPrimaryIndexIdx.setLong( argIdx++, argPrimaryIndexId.longValue() );
			}
			else {
				stmtDeleteByPrimaryIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByPrimaryIndexIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByPrimaryIndexIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByPrimaryIndexIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByPrimaryIndexIdx.getUpdateCount() ) {
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

	public void deleteTableByPrimaryIndexIdx( CFBamAuthorization Authorization,
		CFBamTableByPrimaryIndexIdxKey argKey )
	{
		deleteTableByPrimaryIndexIdx( Authorization,
			argKey.getOptionalPrimaryIndexTenantId(),
			argKey.getOptionalPrimaryIndexId() );
	}

	public void deleteTableByLookupIndexIdx( CFBamAuthorization Authorization,
		Long argLookupIndexTenantId,
		Long argLookupIndexId )
	{
		final String S_ProcName = "deleteTableByLookupIndexIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_lookupindexidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByLookupIndexIdx== null ) {
				stmtDeleteByLookupIndexIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByLookupIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByLookupIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argLookupIndexTenantId != null ) {
				stmtDeleteByLookupIndexIdx.setLong( argIdx++, argLookupIndexTenantId.longValue() );
			}
			else {
				stmtDeleteByLookupIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( argLookupIndexId != null ) {
				stmtDeleteByLookupIndexIdx.setLong( argIdx++, argLookupIndexId.longValue() );
			}
			else {
				stmtDeleteByLookupIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByLookupIndexIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByLookupIndexIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByLookupIndexIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByLookupIndexIdx.getUpdateCount() ) {
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

	public void deleteTableByLookupIndexIdx( CFBamAuthorization Authorization,
		CFBamTableByLookupIndexIdxKey argKey )
	{
		deleteTableByLookupIndexIdx( Authorization,
			argKey.getOptionalLookupIndexTenantId(),
			argKey.getOptionalLookupIndexId() );
	}

	public void deleteTableByAltIndexIdx( CFBamAuthorization Authorization,
		Long argAltIndexTenantId,
		Long argAltIndexId )
	{
		final String S_ProcName = "deleteTableByAltIndexIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_altindexidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByAltIndexIdx== null ) {
				stmtDeleteByAltIndexIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByAltIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByAltIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argAltIndexTenantId != null ) {
				stmtDeleteByAltIndexIdx.setLong( argIdx++, argAltIndexTenantId.longValue() );
			}
			else {
				stmtDeleteByAltIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( argAltIndexId != null ) {
				stmtDeleteByAltIndexIdx.setLong( argIdx++, argAltIndexId.longValue() );
			}
			else {
				stmtDeleteByAltIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByAltIndexIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByAltIndexIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByAltIndexIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByAltIndexIdx.getUpdateCount() ) {
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

	public void deleteTableByAltIndexIdx( CFBamAuthorization Authorization,
		CFBamTableByAltIndexIdxKey argKey )
	{
		deleteTableByAltIndexIdx( Authorization,
			argKey.getOptionalAltIndexTenantId(),
			argKey.getOptionalAltIndexId() );
	}

	public void deleteTableByQualTableIdx( CFBamAuthorization Authorization,
		Long argQualifyingTenantId,
		Long argQualifyingTableId )
	{
		final String S_ProcName = "deleteTableByQualTableIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_qualtableidx ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?";
			if( stmtDeleteByQualTableIdx== null ) {
				stmtDeleteByQualTableIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByQualTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByQualTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( argQualifyingTenantId != null ) {
				stmtDeleteByQualTableIdx.setLong( argIdx++, argQualifyingTenantId.longValue() );
			}
			else {
				stmtDeleteByQualTableIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( argQualifyingTableId != null ) {
				stmtDeleteByQualTableIdx.setLong( argIdx++, argQualifyingTableId.longValue() );
			}
			else {
				stmtDeleteByQualTableIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			Object stuff = null;
			boolean moreResults = stmtDeleteByQualTableIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByQualTableIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByQualTableIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByQualTableIdx.getUpdateCount() ) {
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

	public void deleteTableByQualTableIdx( CFBamAuthorization Authorization,
		CFBamTableByQualTableIdxKey argKey )
	{
		deleteTableByQualTableIdx( Authorization,
			argKey.getOptionalQualifyingTenantId(),
			argKey.getOptionalQualifyingTableId() );
	}

	public void deleteTableByLoadBehaveIdx( CFBamAuthorization Authorization,
		short argLoaderBehaviourId )
	{
		final String S_ProcName = "deleteTableByLoadBehaveIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_loadbehaveidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteByLoadBehaveIdx== null ) {
				stmtDeleteByLoadBehaveIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByLoadBehaveIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByLoadBehaveIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByLoadBehaveIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByLoadBehaveIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByLoadBehaveIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByLoadBehaveIdx.setShort( argIdx++, argLoaderBehaviourId );
			Object stuff = null;
			boolean moreResults = stmtDeleteByLoadBehaveIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteByLoadBehaveIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteByLoadBehaveIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteByLoadBehaveIdx.getUpdateCount() ) {
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

	public void deleteTableByLoadBehaveIdx( CFBamAuthorization Authorization,
		CFBamTableByLoadBehaveIdxKey argKey )
	{
		deleteTableByLoadBehaveIdx( Authorization,
			argKey.getRequiredLoaderBehaviourId() );
	}

	public void deleteTableByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		final String S_ProcName = "deleteTableByDataScopeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_datascopeidx ?, ?, ?, ?, ?" + ", "
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

	public void deleteTableByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamTableByDataScopeIdxKey argKey )
	{
		deleteTableByDataScopeIdx( Authorization,
			argKey.getOptionalDataScopeId() );
	}

	public void deleteTableBySecScopeIdx( CFBamAuthorization Authorization,
		short argSecurityScopeId )
	{
		final String S_ProcName = "deleteTableBySecScopeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_secscopeidx ?, ?, ?, ?, ?" + ", "
				+		"?";
			if( stmtDeleteBySecScopeIdx== null ) {
				stmtDeleteBySecScopeIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteBySecScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteBySecScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteBySecScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteBySecScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteBySecScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteBySecScopeIdx.setShort( argIdx++, argSecurityScopeId );
			Object stuff = null;
			boolean moreResults = stmtDeleteBySecScopeIdx.execute();
			while( stuff == null ) {
				try {
					moreResults = stmtDeleteBySecScopeIdx.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						stuff = stmtDeleteBySecScopeIdx.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtDeleteBySecScopeIdx.getUpdateCount() ) {
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

	public void deleteTableBySecScopeIdx( CFBamAuthorization Authorization,
		CFBamTableBySecScopeIdxKey argKey )
	{
		deleteTableBySecScopeIdx( Authorization,
			argKey.getRequiredSecurityScopeId() );
	}

	public void deleteTableByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		final String S_ProcName = "deleteTableByVAccSecIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_vaccsecidx ?, ?, ?, ?, ?" + ", "
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

	public void deleteTableByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamTableByVAccSecIdxKey argKey )
	{
		deleteTableByVAccSecIdx( Authorization,
			argKey.getOptionalViewAccessSecurityId() );
	}

	public void deleteTableByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		final String S_ProcName = "deleteTableByVAccFreqIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_vaccfreqidx ?, ?, ?, ?, ?" + ", "
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

	public void deleteTableByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamTableByVAccFreqIdxKey argKey )
	{
		deleteTableByVAccFreqIdx( Authorization,
			argKey.getOptionalViewAccessFrequencyId() );
	}

	public void deleteTableByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		final String S_ProcName = "deleteTableByEAccSecIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_eaccsecidx ?, ?, ?, ?, ?" + ", "
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

	public void deleteTableByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamTableByEAccSecIdxKey argKey )
	{
		deleteTableByEAccSecIdx( Authorization,
			argKey.getOptionalEditAccessSecurityId() );
	}

	public void deleteTableByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		final String S_ProcName = "deleteTableByEAccFreqIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_eaccfreqidx ?, ?, ?, ?, ?" + ", "
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

	public void deleteTableByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamTableByEAccFreqIdxKey argKey )
	{
		deleteTableByEAccFreqIdx( Authorization,
			argKey.getOptionalEditAccessFrequencyId() );
	}

	public void deleteTableByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deleteTableByIdIdx";
		// MSS TODO WORKING
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			S_ProcName );
	}

	public void deleteTableByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		deleteTableByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteTableByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteTableByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			String sql = "exec sp_delete_tbldef_by_tenantidx ?, ?, ?, ?, ?" + ", "
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

	public void deleteTableByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		deleteTableByTenantIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	public CFBamCursor openTableCursorAll( CFBamAuthorization Authorization ) {
		String sql = getSqlSelectTableBuff()
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorBySchemaDefIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		"tbld.tenantid = " + Long.toString( TenantId ) + " "
			+	"AND "
				+		"tbld.schemadefid = " + Long.toString( SchemaDefId ) + " "
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		( ( DefSchemaTenantId == null ) ? "tbld.defschtentid is null "
							: "tbld.defschtentid = " + DefSchemaTenantId.toString() + " " )
			+	"AND "
				+		( ( DefSchemaId == null ) ? "tbld.defschid is null "
							: "tbld.defschid = " + DefSchemaId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByPrimaryIndexIdx( CFBamAuthorization Authorization,
		Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		( ( PrimaryIndexTenantId == null ) ? "tbld.primidxtentid is null "
							: "tbld.primidxtentid = " + PrimaryIndexTenantId.toString() + " " )
			+	"AND "
				+		( ( PrimaryIndexId == null ) ? "tbld.primidxid is null "
							: "tbld.primidxid = " + PrimaryIndexId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByLookupIndexIdx( CFBamAuthorization Authorization,
		Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		( ( LookupIndexTenantId == null ) ? "tbld.lookidxtentid is null "
							: "tbld.lookidxtentid = " + LookupIndexTenantId.toString() + " " )
			+	"AND "
				+		( ( LookupIndexId == null ) ? "tbld.lookidxid is null "
							: "tbld.lookidxid = " + LookupIndexId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByAltIndexIdx( CFBamAuthorization Authorization,
		Long AltIndexTenantId,
		Long AltIndexId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		( ( AltIndexTenantId == null ) ? "tbld.altidxtentid is null "
							: "tbld.altidxtentid = " + AltIndexTenantId.toString() + " " )
			+	"AND "
				+		( ( AltIndexId == null ) ? "tbld.altidxid is null "
							: "tbld.altidxid = " + AltIndexId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByQualTableIdx( CFBamAuthorization Authorization,
		Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		( ( QualifyingTenantId == null ) ? "tbld.qualtentid is null "
							: "tbld.qualtentid = " + QualifyingTenantId.toString() + " " )
			+	"AND "
				+		( ( QualifyingTableId == null ) ? "tbld.qualtblid is null "
							: "tbld.qualtblid = " + QualifyingTableId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByLoadBehaveIdx( CFBamAuthorization Authorization,
		short LoaderBehaviourId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		"tbld.loadbehavid = " + Short.toString( LoaderBehaviourId ) + " "
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		( ( DataScopeId == null ) ? "tbld.datascopeid is null "
							: "tbld.datascopeid = " + DataScopeId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorBySecScopeIdx( CFBamAuthorization Authorization,
		short SecurityScopeId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		"tbld.secscopeid = " + Short.toString( SecurityScopeId ) + " "
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		( ( ViewAccessSecurityId == null ) ? "tbld.vasecid is null "
							: "tbld.vasecid = " + ViewAccessSecurityId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		( ( ViewAccessFrequencyId == null ) ? "tbld.vafid is null "
							: "tbld.vafid = " + ViewAccessFrequencyId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		( ( EditAccessSecurityId == null ) ? "tbld.easecid is null "
							: "tbld.easecid = " + EditAccessSecurityId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public CFBamCursor openTableCursorByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		String sql = getSqlSelectTableBuff()
			+	" WHERE "
				+		( ( EditAccessFrequencyId == null ) ? "tbld.eafid is null "
							: "tbld.eafid = " + EditAccessFrequencyId.toString() + " " )
				+		"AND "
				+			"scop.ClassCode = 'TBLD'"
			+	"ORDER BY " 
			+		"tbld.TenantId ASC" + ", "
			+		"tbld.Id ASC";
		CFBamCursor cursor = new CFBamMSSqlCursor( Authorization, schema, sql );
		return( cursor );
	}

	public void closeTableCursor( CFBamCursor Cursor ) {
		try {
			Cursor.getResultSet().close();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"closeTableCursor",
				e );
		}
	}

	public CFBamTableBuff nextTableCursor( CFBamCursor Cursor ) {
		final String S_ProcName = "nextTableCursor";
		try {
			ResultSet resultSet = Cursor.getResultSet();
			if( ! resultSet.next() ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"No more results available" );
			}
			CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
			return( buff );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
	}

	public CFBamTableBuff prevTableCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTableBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextTableCursor( Cursor );
		}
		return( buff );
	}

	public CFBamTableBuff firstTableCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTableBuff buff = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextTableCursor( Cursor );
		}
		return( buff );
	}

	public CFBamTableBuff lastTableCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "lastTableCursor" );
	}

	public CFBamTableBuff nthTableCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTableBuff buff = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			buff = nextTableCursor( Cursor );
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
		S_sqlSelectTableDistinctClassCode = null;
		S_sqlSelectTableBuff = null;
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
		if( stmtDeleteBySchemaDefIdx != null ) {
			try {
				stmtDeleteBySchemaDefIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteBySchemaDefIdx = null;
			}
		}
		if( stmtDeleteByDefSchemaIdx != null ) {
			try {
				stmtDeleteByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByDefSchemaIdx = null;
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
		if( stmtDeleteBySchemaCdIdx != null ) {
			try {
				stmtDeleteBySchemaCdIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteBySchemaCdIdx = null;
			}
		}
		if( stmtDeleteByPrimaryIndexIdx != null ) {
			try {
				stmtDeleteByPrimaryIndexIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByPrimaryIndexIdx = null;
			}
		}
		if( stmtDeleteByLookupIndexIdx != null ) {
			try {
				stmtDeleteByLookupIndexIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByLookupIndexIdx = null;
			}
		}
		if( stmtDeleteByAltIndexIdx != null ) {
			try {
				stmtDeleteByAltIndexIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByAltIndexIdx = null;
			}
		}
		if( stmtDeleteByQualTableIdx != null ) {
			try {
				stmtDeleteByQualTableIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByQualTableIdx = null;
			}
		}
		if( stmtDeleteByLoadBehaveIdx != null ) {
			try {
				stmtDeleteByLoadBehaveIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteByLoadBehaveIdx = null;
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
		if( stmtDeleteBySecScopeIdx != null ) {
			try {
				stmtDeleteBySecScopeIdx.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			finally {
				stmtDeleteBySecScopeIdx = null;
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
		if( stmtReadBuffBySchemaDefIdx != null ) {
			try {
				stmtReadBuffBySchemaDefIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffBySchemaDefIdx = null;
		}
		if( stmtReadBuffByDefSchemaIdx != null ) {
			try {
				stmtReadBuffByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByDefSchemaIdx = null;
		}
		if( stmtReadBuffByUNameIdx != null ) {
			try {
				stmtReadBuffByUNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByUNameIdx = null;
		}
		if( stmtReadBuffBySchemaCdIdx != null ) {
			try {
				stmtReadBuffBySchemaCdIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffBySchemaCdIdx = null;
		}
		if( stmtReadBuffByPrimaryIndexIdx != null ) {
			try {
				stmtReadBuffByPrimaryIndexIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByPrimaryIndexIdx = null;
		}
		if( stmtReadBuffByLookupIndexIdx != null ) {
			try {
				stmtReadBuffByLookupIndexIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByLookupIndexIdx = null;
		}
		if( stmtReadBuffByAltIndexIdx != null ) {
			try {
				stmtReadBuffByAltIndexIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByAltIndexIdx = null;
		}
		if( stmtReadBuffByQualTableIdx != null ) {
			try {
				stmtReadBuffByQualTableIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByQualTableIdx = null;
		}
		if( stmtReadBuffByLoadBehaveIdx != null ) {
			try {
				stmtReadBuffByLoadBehaveIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByLoadBehaveIdx = null;
		}
		if( stmtReadBuffByDataScopeIdx != null ) {
			try {
				stmtReadBuffByDataScopeIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByDataScopeIdx = null;
		}
		if( stmtReadBuffBySecScopeIdx != null ) {
			try {
				stmtReadBuffBySecScopeIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffBySecScopeIdx = null;
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
	}
}
