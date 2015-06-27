// Description: Java 7 MySQL Jdbc DbIO implementation for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamMySql;

import java.lang.reflect.*;
import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSaxLoader.CFBamSaxLoader;

public class CFBamMySqlSchema
	extends CFBamSchema
{
	protected Connection cnx;
	protected boolean inTransaction;
	protected PreparedStatement stmtSelectIsSystemUser = null;
	protected PreparedStatement stmtSelectIsClusterUser = null;
	protected PreparedStatement stmtSelectIsTenantUser = null;
	protected PreparedStatement stmtSelectNextServiceTypeIdGen = null;
	protected PreparedStatement stmtInsertNextServiceTypeIdGen = null;
	protected PreparedStatement stmtUpdateNextServiceTypeIdGen = null;
	protected PreparedStatement stmtSelectNextMimeTypeIdGen = null;
	protected PreparedStatement stmtInsertNextMimeTypeIdGen = null;
	protected PreparedStatement stmtUpdateNextMimeTypeIdGen = null;
	protected PreparedStatement stmtSelectNextClusterIdGen = null;
	protected PreparedStatement stmtInsertNextClusterIdGen = null;
	protected PreparedStatement stmtUpdateNextClusterIdGen = null;
	protected PreparedStatement stmtSelectNextTenantIdGen = null;
	protected PreparedStatement stmtInsertNextTenantIdGen = null;
	protected PreparedStatement stmtUpdateNextTenantIdGen = null;

	public CFBamMySqlSchema() {
		super();
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamMySqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamMySqlAccessSecurityTable( this );
		tableAtom = new CFBamMySqlAtomTable( this );
		tableAuditAction = new CFBamMySqlAuditActionTable( this );
		tableBlobCol = new CFBamMySqlBlobColTable( this );
		tableBlobDef = new CFBamMySqlBlobDefTable( this );
		tableBlobType = new CFBamMySqlBlobTypeTable( this );
		tableBoolCol = new CFBamMySqlBoolColTable( this );
		tableBoolDef = new CFBamMySqlBoolDefTable( this );
		tableBoolType = new CFBamMySqlBoolTypeTable( this );
		tableChain = new CFBamMySqlChainTable( this );
		tableClearDep = new CFBamMySqlClearDepTable( this );
		tableClearSubDep1 = new CFBamMySqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamMySqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamMySqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamMySqlClearTopDepTable( this );
		tableCluster = new CFBamMySqlClusterTable( this );
		tableDataScope = new CFBamMySqlDataScopeTable( this );
		tableDateCol = new CFBamMySqlDateColTable( this );
		tableDateDef = new CFBamMySqlDateDefTable( this );
		tableDateType = new CFBamMySqlDateTypeTable( this );
		tableDelDep = new CFBamMySqlDelDepTable( this );
		tableDelSubDep1 = new CFBamMySqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamMySqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamMySqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamMySqlDelTopDepTable( this );
		tableDomain = new CFBamMySqlDomainTable( this );
		tableDomainBase = new CFBamMySqlDomainBaseTable( this );
		tableDoubleCol = new CFBamMySqlDoubleColTable( this );
		tableDoubleDef = new CFBamMySqlDoubleDefTable( this );
		tableDoubleType = new CFBamMySqlDoubleTypeTable( this );
		tableEnumCol = new CFBamMySqlEnumColTable( this );
		tableEnumDef = new CFBamMySqlEnumDefTable( this );
		tableEnumTag = new CFBamMySqlEnumTagTable( this );
		tableEnumType = new CFBamMySqlEnumTypeTable( this );
		tableFloatCol = new CFBamMySqlFloatColTable( this );
		tableFloatDef = new CFBamMySqlFloatDefTable( this );
		tableFloatType = new CFBamMySqlFloatTypeTable( this );
		tableHostNode = new CFBamMySqlHostNodeTable( this );
		tableISOCountry = new CFBamMySqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamMySqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamMySqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamMySqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamMySqlISOLanguageTable( this );
		tableISOTimezone = new CFBamMySqlISOTimezoneTable( this );
		tableId16Gen = new CFBamMySqlId16GenTable( this );
		tableId32Gen = new CFBamMySqlId32GenTable( this );
		tableId64Gen = new CFBamMySqlId64GenTable( this );
		tableIndex = new CFBamMySqlIndexTable( this );
		tableIndexCol = new CFBamMySqlIndexColTable( this );
		tableInt16Col = new CFBamMySqlInt16ColTable( this );
		tableInt16Def = new CFBamMySqlInt16DefTable( this );
		tableInt16Type = new CFBamMySqlInt16TypeTable( this );
		tableInt32Col = new CFBamMySqlInt32ColTable( this );
		tableInt32Def = new CFBamMySqlInt32DefTable( this );
		tableInt32Type = new CFBamMySqlInt32TypeTable( this );
		tableInt64Col = new CFBamMySqlInt64ColTable( this );
		tableInt64Def = new CFBamMySqlInt64DefTable( this );
		tableInt64Type = new CFBamMySqlInt64TypeTable( this );
		tableLicense = new CFBamMySqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamMySqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamMySqlMajorVersionTable( this );
		tableMimeType = new CFBamMySqlMimeTypeTable( this );
		tableMinorVersion = new CFBamMySqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamMySqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamMySqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamMySqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamMySqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamMySqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamMySqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamMySqlNumberColTable( this );
		tableNumberDef = new CFBamMySqlNumberDefTable( this );
		tableNumberType = new CFBamMySqlNumberTypeTable( this );
		tableParam = new CFBamMySqlParamTable( this );
		tablePopDep = new CFBamMySqlPopDepTable( this );
		tablePopSubDep1 = new CFBamMySqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamMySqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamMySqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamMySqlPopTopDepTable( this );
		tableProjectBase = new CFBamMySqlProjectBaseTable( this );
		tableRealProject = new CFBamMySqlRealProjectTable( this );
		tableRelation = new CFBamMySqlRelationTable( this );
		tableRelationCol = new CFBamMySqlRelationColTable( this );
		tableRelationType = new CFBamMySqlRelationTypeTable( this );
		tableSchemaDef = new CFBamMySqlSchemaDefTable( this );
		tableSchemaRef = new CFBamMySqlSchemaRefTable( this );
		tableScope = new CFBamMySqlScopeTable( this );
		tableSecApp = new CFBamMySqlSecAppTable( this );
		tableSecDevice = new CFBamMySqlSecDeviceTable( this );
		tableSecForm = new CFBamMySqlSecFormTable( this );
		tableSecGroup = new CFBamMySqlSecGroupTable( this );
		tableSecGroupForm = new CFBamMySqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamMySqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamMySqlSecGroupMemberTable( this );
		tableSecSession = new CFBamMySqlSecSessionTable( this );
		tableSecUser = new CFBamMySqlSecUserTable( this );
		tableSecurityScope = new CFBamMySqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamMySqlServerListFuncTable( this );
		tableServerMethod = new CFBamMySqlServerMethodTable( this );
		tableServerObjFunc = new CFBamMySqlServerObjFuncTable( this );
		tableServerProc = new CFBamMySqlServerProcTable( this );
		tableService = new CFBamMySqlServiceTable( this );
		tableServiceType = new CFBamMySqlServiceTypeTable( this );
		tableStringCol = new CFBamMySqlStringColTable( this );
		tableStringDef = new CFBamMySqlStringDefTable( this );
		tableStringType = new CFBamMySqlStringTypeTable( this );
		tableSubProject = new CFBamMySqlSubProjectTable( this );
		tableSysCluster = new CFBamMySqlSysClusterTable( this );
		tableTSecGroup = new CFBamMySqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamMySqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamMySqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamMySqlTZDateColTable( this );
		tableTZDateDef = new CFBamMySqlTZDateDefTable( this );
		tableTZDateType = new CFBamMySqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamMySqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamMySqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamMySqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamMySqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamMySqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamMySqlTZTimestampTypeTable( this );
		tableTable = new CFBamMySqlTableTable( this );
		tableTableCol = new CFBamMySqlTableColTable( this );
		tableTenant = new CFBamMySqlTenantTable( this );
		tableTextCol = new CFBamMySqlTextColTable( this );
		tableTextDef = new CFBamMySqlTextDefTable( this );
		tableTextType = new CFBamMySqlTextTypeTable( this );
		tableTimeCol = new CFBamMySqlTimeColTable( this );
		tableTimeDef = new CFBamMySqlTimeDefTable( this );
		tableTimeType = new CFBamMySqlTimeTypeTable( this );
		tableTimestampCol = new CFBamMySqlTimestampColTable( this );
		tableTimestampDef = new CFBamMySqlTimestampDefTable( this );
		tableTimestampType = new CFBamMySqlTimestampTypeTable( this );
		tableTld = new CFBamMySqlTldTable( this );
		tableTokenCol = new CFBamMySqlTokenColTable( this );
		tableTokenDef = new CFBamMySqlTokenDefTable( this );
		tableTokenType = new CFBamMySqlTokenTypeTable( this );
		tableTopDomain = new CFBamMySqlTopDomainTable( this );
		tableTopProject = new CFBamMySqlTopProjectTable( this );
		tableUInt16Col = new CFBamMySqlUInt16ColTable( this );
		tableUInt16Def = new CFBamMySqlUInt16DefTable( this );
		tableUInt16Type = new CFBamMySqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamMySqlUInt32ColTable( this );
		tableUInt32Def = new CFBamMySqlUInt32DefTable( this );
		tableUInt32Type = new CFBamMySqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamMySqlUInt64ColTable( this );
		tableUInt64Def = new CFBamMySqlUInt64DefTable( this );
		tableUInt64Type = new CFBamMySqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamMySqlURLProtocolTable( this );
		tableUuidCol = new CFBamMySqlUuidColTable( this );
		tableUuidDef = new CFBamMySqlUuidDefTable( this );
		tableUuidGen = new CFBamMySqlUuidGenTable( this );
		tableUuidType = new CFBamMySqlUuidTypeTable( this );
		tableValue = new CFBamMySqlValueTable( this );
		tableVersion = new CFBamMySqlVersionTable( this );
	}

	public CFBamMySqlSchema( CFBamConfigurationFile conf ) {
		super( conf );
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamMySqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamMySqlAccessSecurityTable( this );
		tableAtom = new CFBamMySqlAtomTable( this );
		tableAuditAction = new CFBamMySqlAuditActionTable( this );
		tableBlobCol = new CFBamMySqlBlobColTable( this );
		tableBlobDef = new CFBamMySqlBlobDefTable( this );
		tableBlobType = new CFBamMySqlBlobTypeTable( this );
		tableBoolCol = new CFBamMySqlBoolColTable( this );
		tableBoolDef = new CFBamMySqlBoolDefTable( this );
		tableBoolType = new CFBamMySqlBoolTypeTable( this );
		tableChain = new CFBamMySqlChainTable( this );
		tableClearDep = new CFBamMySqlClearDepTable( this );
		tableClearSubDep1 = new CFBamMySqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamMySqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamMySqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamMySqlClearTopDepTable( this );
		tableCluster = new CFBamMySqlClusterTable( this );
		tableDataScope = new CFBamMySqlDataScopeTable( this );
		tableDateCol = new CFBamMySqlDateColTable( this );
		tableDateDef = new CFBamMySqlDateDefTable( this );
		tableDateType = new CFBamMySqlDateTypeTable( this );
		tableDelDep = new CFBamMySqlDelDepTable( this );
		tableDelSubDep1 = new CFBamMySqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamMySqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamMySqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamMySqlDelTopDepTable( this );
		tableDomain = new CFBamMySqlDomainTable( this );
		tableDomainBase = new CFBamMySqlDomainBaseTable( this );
		tableDoubleCol = new CFBamMySqlDoubleColTable( this );
		tableDoubleDef = new CFBamMySqlDoubleDefTable( this );
		tableDoubleType = new CFBamMySqlDoubleTypeTable( this );
		tableEnumCol = new CFBamMySqlEnumColTable( this );
		tableEnumDef = new CFBamMySqlEnumDefTable( this );
		tableEnumTag = new CFBamMySqlEnumTagTable( this );
		tableEnumType = new CFBamMySqlEnumTypeTable( this );
		tableFloatCol = new CFBamMySqlFloatColTable( this );
		tableFloatDef = new CFBamMySqlFloatDefTable( this );
		tableFloatType = new CFBamMySqlFloatTypeTable( this );
		tableHostNode = new CFBamMySqlHostNodeTable( this );
		tableISOCountry = new CFBamMySqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamMySqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamMySqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamMySqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamMySqlISOLanguageTable( this );
		tableISOTimezone = new CFBamMySqlISOTimezoneTable( this );
		tableId16Gen = new CFBamMySqlId16GenTable( this );
		tableId32Gen = new CFBamMySqlId32GenTable( this );
		tableId64Gen = new CFBamMySqlId64GenTable( this );
		tableIndex = new CFBamMySqlIndexTable( this );
		tableIndexCol = new CFBamMySqlIndexColTable( this );
		tableInt16Col = new CFBamMySqlInt16ColTable( this );
		tableInt16Def = new CFBamMySqlInt16DefTable( this );
		tableInt16Type = new CFBamMySqlInt16TypeTable( this );
		tableInt32Col = new CFBamMySqlInt32ColTable( this );
		tableInt32Def = new CFBamMySqlInt32DefTable( this );
		tableInt32Type = new CFBamMySqlInt32TypeTable( this );
		tableInt64Col = new CFBamMySqlInt64ColTable( this );
		tableInt64Def = new CFBamMySqlInt64DefTable( this );
		tableInt64Type = new CFBamMySqlInt64TypeTable( this );
		tableLicense = new CFBamMySqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamMySqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamMySqlMajorVersionTable( this );
		tableMimeType = new CFBamMySqlMimeTypeTable( this );
		tableMinorVersion = new CFBamMySqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamMySqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamMySqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamMySqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamMySqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamMySqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamMySqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamMySqlNumberColTable( this );
		tableNumberDef = new CFBamMySqlNumberDefTable( this );
		tableNumberType = new CFBamMySqlNumberTypeTable( this );
		tableParam = new CFBamMySqlParamTable( this );
		tablePopDep = new CFBamMySqlPopDepTable( this );
		tablePopSubDep1 = new CFBamMySqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamMySqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamMySqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamMySqlPopTopDepTable( this );
		tableProjectBase = new CFBamMySqlProjectBaseTable( this );
		tableRealProject = new CFBamMySqlRealProjectTable( this );
		tableRelation = new CFBamMySqlRelationTable( this );
		tableRelationCol = new CFBamMySqlRelationColTable( this );
		tableRelationType = new CFBamMySqlRelationTypeTable( this );
		tableSchemaDef = new CFBamMySqlSchemaDefTable( this );
		tableSchemaRef = new CFBamMySqlSchemaRefTable( this );
		tableScope = new CFBamMySqlScopeTable( this );
		tableSecApp = new CFBamMySqlSecAppTable( this );
		tableSecDevice = new CFBamMySqlSecDeviceTable( this );
		tableSecForm = new CFBamMySqlSecFormTable( this );
		tableSecGroup = new CFBamMySqlSecGroupTable( this );
		tableSecGroupForm = new CFBamMySqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamMySqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamMySqlSecGroupMemberTable( this );
		tableSecSession = new CFBamMySqlSecSessionTable( this );
		tableSecUser = new CFBamMySqlSecUserTable( this );
		tableSecurityScope = new CFBamMySqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamMySqlServerListFuncTable( this );
		tableServerMethod = new CFBamMySqlServerMethodTable( this );
		tableServerObjFunc = new CFBamMySqlServerObjFuncTable( this );
		tableServerProc = new CFBamMySqlServerProcTable( this );
		tableService = new CFBamMySqlServiceTable( this );
		tableServiceType = new CFBamMySqlServiceTypeTable( this );
		tableStringCol = new CFBamMySqlStringColTable( this );
		tableStringDef = new CFBamMySqlStringDefTable( this );
		tableStringType = new CFBamMySqlStringTypeTable( this );
		tableSubProject = new CFBamMySqlSubProjectTable( this );
		tableSysCluster = new CFBamMySqlSysClusterTable( this );
		tableTSecGroup = new CFBamMySqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamMySqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamMySqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamMySqlTZDateColTable( this );
		tableTZDateDef = new CFBamMySqlTZDateDefTable( this );
		tableTZDateType = new CFBamMySqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamMySqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamMySqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamMySqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamMySqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamMySqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamMySqlTZTimestampTypeTable( this );
		tableTable = new CFBamMySqlTableTable( this );
		tableTableCol = new CFBamMySqlTableColTable( this );
		tableTenant = new CFBamMySqlTenantTable( this );
		tableTextCol = new CFBamMySqlTextColTable( this );
		tableTextDef = new CFBamMySqlTextDefTable( this );
		tableTextType = new CFBamMySqlTextTypeTable( this );
		tableTimeCol = new CFBamMySqlTimeColTable( this );
		tableTimeDef = new CFBamMySqlTimeDefTable( this );
		tableTimeType = new CFBamMySqlTimeTypeTable( this );
		tableTimestampCol = new CFBamMySqlTimestampColTable( this );
		tableTimestampDef = new CFBamMySqlTimestampDefTable( this );
		tableTimestampType = new CFBamMySqlTimestampTypeTable( this );
		tableTld = new CFBamMySqlTldTable( this );
		tableTokenCol = new CFBamMySqlTokenColTable( this );
		tableTokenDef = new CFBamMySqlTokenDefTable( this );
		tableTokenType = new CFBamMySqlTokenTypeTable( this );
		tableTopDomain = new CFBamMySqlTopDomainTable( this );
		tableTopProject = new CFBamMySqlTopProjectTable( this );
		tableUInt16Col = new CFBamMySqlUInt16ColTable( this );
		tableUInt16Def = new CFBamMySqlUInt16DefTable( this );
		tableUInt16Type = new CFBamMySqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamMySqlUInt32ColTable( this );
		tableUInt32Def = new CFBamMySqlUInt32DefTable( this );
		tableUInt32Type = new CFBamMySqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamMySqlUInt64ColTable( this );
		tableUInt64Def = new CFBamMySqlUInt64DefTable( this );
		tableUInt64Type = new CFBamMySqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamMySqlURLProtocolTable( this );
		tableUuidCol = new CFBamMySqlUuidColTable( this );
		tableUuidDef = new CFBamMySqlUuidDefTable( this );
		tableUuidGen = new CFBamMySqlUuidGenTable( this );
		tableUuidType = new CFBamMySqlUuidTypeTable( this );
		tableValue = new CFBamMySqlValueTable( this );
		tableVersion = new CFBamMySqlVersionTable( this );
		setDbSchemaName( conf.getDbDatabase() );
	}

	public CFBamMySqlSchema( String argJndiName ) {
		super( argJndiName );
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamMySqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamMySqlAccessSecurityTable( this );
		tableAtom = new CFBamMySqlAtomTable( this );
		tableAuditAction = new CFBamMySqlAuditActionTable( this );
		tableBlobCol = new CFBamMySqlBlobColTable( this );
		tableBlobDef = new CFBamMySqlBlobDefTable( this );
		tableBlobType = new CFBamMySqlBlobTypeTable( this );
		tableBoolCol = new CFBamMySqlBoolColTable( this );
		tableBoolDef = new CFBamMySqlBoolDefTable( this );
		tableBoolType = new CFBamMySqlBoolTypeTable( this );
		tableChain = new CFBamMySqlChainTable( this );
		tableClearDep = new CFBamMySqlClearDepTable( this );
		tableClearSubDep1 = new CFBamMySqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamMySqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamMySqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamMySqlClearTopDepTable( this );
		tableCluster = new CFBamMySqlClusterTable( this );
		tableDataScope = new CFBamMySqlDataScopeTable( this );
		tableDateCol = new CFBamMySqlDateColTable( this );
		tableDateDef = new CFBamMySqlDateDefTable( this );
		tableDateType = new CFBamMySqlDateTypeTable( this );
		tableDelDep = new CFBamMySqlDelDepTable( this );
		tableDelSubDep1 = new CFBamMySqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamMySqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamMySqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamMySqlDelTopDepTable( this );
		tableDomain = new CFBamMySqlDomainTable( this );
		tableDomainBase = new CFBamMySqlDomainBaseTable( this );
		tableDoubleCol = new CFBamMySqlDoubleColTable( this );
		tableDoubleDef = new CFBamMySqlDoubleDefTable( this );
		tableDoubleType = new CFBamMySqlDoubleTypeTable( this );
		tableEnumCol = new CFBamMySqlEnumColTable( this );
		tableEnumDef = new CFBamMySqlEnumDefTable( this );
		tableEnumTag = new CFBamMySqlEnumTagTable( this );
		tableEnumType = new CFBamMySqlEnumTypeTable( this );
		tableFloatCol = new CFBamMySqlFloatColTable( this );
		tableFloatDef = new CFBamMySqlFloatDefTable( this );
		tableFloatType = new CFBamMySqlFloatTypeTable( this );
		tableHostNode = new CFBamMySqlHostNodeTable( this );
		tableISOCountry = new CFBamMySqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamMySqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamMySqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamMySqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamMySqlISOLanguageTable( this );
		tableISOTimezone = new CFBamMySqlISOTimezoneTable( this );
		tableId16Gen = new CFBamMySqlId16GenTable( this );
		tableId32Gen = new CFBamMySqlId32GenTable( this );
		tableId64Gen = new CFBamMySqlId64GenTable( this );
		tableIndex = new CFBamMySqlIndexTable( this );
		tableIndexCol = new CFBamMySqlIndexColTable( this );
		tableInt16Col = new CFBamMySqlInt16ColTable( this );
		tableInt16Def = new CFBamMySqlInt16DefTable( this );
		tableInt16Type = new CFBamMySqlInt16TypeTable( this );
		tableInt32Col = new CFBamMySqlInt32ColTable( this );
		tableInt32Def = new CFBamMySqlInt32DefTable( this );
		tableInt32Type = new CFBamMySqlInt32TypeTable( this );
		tableInt64Col = new CFBamMySqlInt64ColTable( this );
		tableInt64Def = new CFBamMySqlInt64DefTable( this );
		tableInt64Type = new CFBamMySqlInt64TypeTable( this );
		tableLicense = new CFBamMySqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamMySqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamMySqlMajorVersionTable( this );
		tableMimeType = new CFBamMySqlMimeTypeTable( this );
		tableMinorVersion = new CFBamMySqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamMySqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamMySqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamMySqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamMySqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamMySqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamMySqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamMySqlNumberColTable( this );
		tableNumberDef = new CFBamMySqlNumberDefTable( this );
		tableNumberType = new CFBamMySqlNumberTypeTable( this );
		tableParam = new CFBamMySqlParamTable( this );
		tablePopDep = new CFBamMySqlPopDepTable( this );
		tablePopSubDep1 = new CFBamMySqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamMySqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamMySqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamMySqlPopTopDepTable( this );
		tableProjectBase = new CFBamMySqlProjectBaseTable( this );
		tableRealProject = new CFBamMySqlRealProjectTable( this );
		tableRelation = new CFBamMySqlRelationTable( this );
		tableRelationCol = new CFBamMySqlRelationColTable( this );
		tableRelationType = new CFBamMySqlRelationTypeTable( this );
		tableSchemaDef = new CFBamMySqlSchemaDefTable( this );
		tableSchemaRef = new CFBamMySqlSchemaRefTable( this );
		tableScope = new CFBamMySqlScopeTable( this );
		tableSecApp = new CFBamMySqlSecAppTable( this );
		tableSecDevice = new CFBamMySqlSecDeviceTable( this );
		tableSecForm = new CFBamMySqlSecFormTable( this );
		tableSecGroup = new CFBamMySqlSecGroupTable( this );
		tableSecGroupForm = new CFBamMySqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamMySqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamMySqlSecGroupMemberTable( this );
		tableSecSession = new CFBamMySqlSecSessionTable( this );
		tableSecUser = new CFBamMySqlSecUserTable( this );
		tableSecurityScope = new CFBamMySqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamMySqlServerListFuncTable( this );
		tableServerMethod = new CFBamMySqlServerMethodTable( this );
		tableServerObjFunc = new CFBamMySqlServerObjFuncTable( this );
		tableServerProc = new CFBamMySqlServerProcTable( this );
		tableService = new CFBamMySqlServiceTable( this );
		tableServiceType = new CFBamMySqlServiceTypeTable( this );
		tableStringCol = new CFBamMySqlStringColTable( this );
		tableStringDef = new CFBamMySqlStringDefTable( this );
		tableStringType = new CFBamMySqlStringTypeTable( this );
		tableSubProject = new CFBamMySqlSubProjectTable( this );
		tableSysCluster = new CFBamMySqlSysClusterTable( this );
		tableTSecGroup = new CFBamMySqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamMySqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamMySqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamMySqlTZDateColTable( this );
		tableTZDateDef = new CFBamMySqlTZDateDefTable( this );
		tableTZDateType = new CFBamMySqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamMySqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamMySqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamMySqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamMySqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamMySqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamMySqlTZTimestampTypeTable( this );
		tableTable = new CFBamMySqlTableTable( this );
		tableTableCol = new CFBamMySqlTableColTable( this );
		tableTenant = new CFBamMySqlTenantTable( this );
		tableTextCol = new CFBamMySqlTextColTable( this );
		tableTextDef = new CFBamMySqlTextDefTable( this );
		tableTextType = new CFBamMySqlTextTypeTable( this );
		tableTimeCol = new CFBamMySqlTimeColTable( this );
		tableTimeDef = new CFBamMySqlTimeDefTable( this );
		tableTimeType = new CFBamMySqlTimeTypeTable( this );
		tableTimestampCol = new CFBamMySqlTimestampColTable( this );
		tableTimestampDef = new CFBamMySqlTimestampDefTable( this );
		tableTimestampType = new CFBamMySqlTimestampTypeTable( this );
		tableTld = new CFBamMySqlTldTable( this );
		tableTokenCol = new CFBamMySqlTokenColTable( this );
		tableTokenDef = new CFBamMySqlTokenDefTable( this );
		tableTokenType = new CFBamMySqlTokenTypeTable( this );
		tableTopDomain = new CFBamMySqlTopDomainTable( this );
		tableTopProject = new CFBamMySqlTopProjectTable( this );
		tableUInt16Col = new CFBamMySqlUInt16ColTable( this );
		tableUInt16Def = new CFBamMySqlUInt16DefTable( this );
		tableUInt16Type = new CFBamMySqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamMySqlUInt32ColTable( this );
		tableUInt32Def = new CFBamMySqlUInt32DefTable( this );
		tableUInt32Type = new CFBamMySqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamMySqlUInt64ColTable( this );
		tableUInt64Def = new CFBamMySqlUInt64DefTable( this );
		tableUInt64Type = new CFBamMySqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamMySqlURLProtocolTable( this );
		tableUuidCol = new CFBamMySqlUuidColTable( this );
		tableUuidDef = new CFBamMySqlUuidDefTable( this );
		tableUuidGen = new CFBamMySqlUuidGenTable( this );
		tableUuidType = new CFBamMySqlUuidTypeTable( this );
		tableValue = new CFBamMySqlValueTable( this );
		tableVersion = new CFBamMySqlVersionTable( this );
	}

	public CFBamMySqlSchema( Connection argCnx ) {
		super();
		cnx = argCnx;
		inTransaction = false;
		tableAccessFrequency = new CFBamMySqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamMySqlAccessSecurityTable( this );
		tableAtom = new CFBamMySqlAtomTable( this );
		tableAuditAction = new CFBamMySqlAuditActionTable( this );
		tableBlobCol = new CFBamMySqlBlobColTable( this );
		tableBlobDef = new CFBamMySqlBlobDefTable( this );
		tableBlobType = new CFBamMySqlBlobTypeTable( this );
		tableBoolCol = new CFBamMySqlBoolColTable( this );
		tableBoolDef = new CFBamMySqlBoolDefTable( this );
		tableBoolType = new CFBamMySqlBoolTypeTable( this );
		tableChain = new CFBamMySqlChainTable( this );
		tableClearDep = new CFBamMySqlClearDepTable( this );
		tableClearSubDep1 = new CFBamMySqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamMySqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamMySqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamMySqlClearTopDepTable( this );
		tableCluster = new CFBamMySqlClusterTable( this );
		tableDataScope = new CFBamMySqlDataScopeTable( this );
		tableDateCol = new CFBamMySqlDateColTable( this );
		tableDateDef = new CFBamMySqlDateDefTable( this );
		tableDateType = new CFBamMySqlDateTypeTable( this );
		tableDelDep = new CFBamMySqlDelDepTable( this );
		tableDelSubDep1 = new CFBamMySqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamMySqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamMySqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamMySqlDelTopDepTable( this );
		tableDomain = new CFBamMySqlDomainTable( this );
		tableDomainBase = new CFBamMySqlDomainBaseTable( this );
		tableDoubleCol = new CFBamMySqlDoubleColTable( this );
		tableDoubleDef = new CFBamMySqlDoubleDefTable( this );
		tableDoubleType = new CFBamMySqlDoubleTypeTable( this );
		tableEnumCol = new CFBamMySqlEnumColTable( this );
		tableEnumDef = new CFBamMySqlEnumDefTable( this );
		tableEnumTag = new CFBamMySqlEnumTagTable( this );
		tableEnumType = new CFBamMySqlEnumTypeTable( this );
		tableFloatCol = new CFBamMySqlFloatColTable( this );
		tableFloatDef = new CFBamMySqlFloatDefTable( this );
		tableFloatType = new CFBamMySqlFloatTypeTable( this );
		tableHostNode = new CFBamMySqlHostNodeTable( this );
		tableISOCountry = new CFBamMySqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamMySqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamMySqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamMySqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamMySqlISOLanguageTable( this );
		tableISOTimezone = new CFBamMySqlISOTimezoneTable( this );
		tableId16Gen = new CFBamMySqlId16GenTable( this );
		tableId32Gen = new CFBamMySqlId32GenTable( this );
		tableId64Gen = new CFBamMySqlId64GenTable( this );
		tableIndex = new CFBamMySqlIndexTable( this );
		tableIndexCol = new CFBamMySqlIndexColTable( this );
		tableInt16Col = new CFBamMySqlInt16ColTable( this );
		tableInt16Def = new CFBamMySqlInt16DefTable( this );
		tableInt16Type = new CFBamMySqlInt16TypeTable( this );
		tableInt32Col = new CFBamMySqlInt32ColTable( this );
		tableInt32Def = new CFBamMySqlInt32DefTable( this );
		tableInt32Type = new CFBamMySqlInt32TypeTable( this );
		tableInt64Col = new CFBamMySqlInt64ColTable( this );
		tableInt64Def = new CFBamMySqlInt64DefTable( this );
		tableInt64Type = new CFBamMySqlInt64TypeTable( this );
		tableLicense = new CFBamMySqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamMySqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamMySqlMajorVersionTable( this );
		tableMimeType = new CFBamMySqlMimeTypeTable( this );
		tableMinorVersion = new CFBamMySqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamMySqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamMySqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamMySqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamMySqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamMySqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamMySqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamMySqlNumberColTable( this );
		tableNumberDef = new CFBamMySqlNumberDefTable( this );
		tableNumberType = new CFBamMySqlNumberTypeTable( this );
		tableParam = new CFBamMySqlParamTable( this );
		tablePopDep = new CFBamMySqlPopDepTable( this );
		tablePopSubDep1 = new CFBamMySqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamMySqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamMySqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamMySqlPopTopDepTable( this );
		tableProjectBase = new CFBamMySqlProjectBaseTable( this );
		tableRealProject = new CFBamMySqlRealProjectTable( this );
		tableRelation = new CFBamMySqlRelationTable( this );
		tableRelationCol = new CFBamMySqlRelationColTable( this );
		tableRelationType = new CFBamMySqlRelationTypeTable( this );
		tableSchemaDef = new CFBamMySqlSchemaDefTable( this );
		tableSchemaRef = new CFBamMySqlSchemaRefTable( this );
		tableScope = new CFBamMySqlScopeTable( this );
		tableSecApp = new CFBamMySqlSecAppTable( this );
		tableSecDevice = new CFBamMySqlSecDeviceTable( this );
		tableSecForm = new CFBamMySqlSecFormTable( this );
		tableSecGroup = new CFBamMySqlSecGroupTable( this );
		tableSecGroupForm = new CFBamMySqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamMySqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamMySqlSecGroupMemberTable( this );
		tableSecSession = new CFBamMySqlSecSessionTable( this );
		tableSecUser = new CFBamMySqlSecUserTable( this );
		tableSecurityScope = new CFBamMySqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamMySqlServerListFuncTable( this );
		tableServerMethod = new CFBamMySqlServerMethodTable( this );
		tableServerObjFunc = new CFBamMySqlServerObjFuncTable( this );
		tableServerProc = new CFBamMySqlServerProcTable( this );
		tableService = new CFBamMySqlServiceTable( this );
		tableServiceType = new CFBamMySqlServiceTypeTable( this );
		tableStringCol = new CFBamMySqlStringColTable( this );
		tableStringDef = new CFBamMySqlStringDefTable( this );
		tableStringType = new CFBamMySqlStringTypeTable( this );
		tableSubProject = new CFBamMySqlSubProjectTable( this );
		tableSysCluster = new CFBamMySqlSysClusterTable( this );
		tableTSecGroup = new CFBamMySqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamMySqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamMySqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamMySqlTZDateColTable( this );
		tableTZDateDef = new CFBamMySqlTZDateDefTable( this );
		tableTZDateType = new CFBamMySqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamMySqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamMySqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamMySqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamMySqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamMySqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamMySqlTZTimestampTypeTable( this );
		tableTable = new CFBamMySqlTableTable( this );
		tableTableCol = new CFBamMySqlTableColTable( this );
		tableTenant = new CFBamMySqlTenantTable( this );
		tableTextCol = new CFBamMySqlTextColTable( this );
		tableTextDef = new CFBamMySqlTextDefTable( this );
		tableTextType = new CFBamMySqlTextTypeTable( this );
		tableTimeCol = new CFBamMySqlTimeColTable( this );
		tableTimeDef = new CFBamMySqlTimeDefTable( this );
		tableTimeType = new CFBamMySqlTimeTypeTable( this );
		tableTimestampCol = new CFBamMySqlTimestampColTable( this );
		tableTimestampDef = new CFBamMySqlTimestampDefTable( this );
		tableTimestampType = new CFBamMySqlTimestampTypeTable( this );
		tableTld = new CFBamMySqlTldTable( this );
		tableTokenCol = new CFBamMySqlTokenColTable( this );
		tableTokenDef = new CFBamMySqlTokenDefTable( this );
		tableTokenType = new CFBamMySqlTokenTypeTable( this );
		tableTopDomain = new CFBamMySqlTopDomainTable( this );
		tableTopProject = new CFBamMySqlTopProjectTable( this );
		tableUInt16Col = new CFBamMySqlUInt16ColTable( this );
		tableUInt16Def = new CFBamMySqlUInt16DefTable( this );
		tableUInt16Type = new CFBamMySqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamMySqlUInt32ColTable( this );
		tableUInt32Def = new CFBamMySqlUInt32DefTable( this );
		tableUInt32Type = new CFBamMySqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamMySqlUInt64ColTable( this );
		tableUInt64Def = new CFBamMySqlUInt64DefTable( this );
		tableUInt64Type = new CFBamMySqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamMySqlURLProtocolTable( this );
		tableUuidCol = new CFBamMySqlUuidColTable( this );
		tableUuidDef = new CFBamMySqlUuidDefTable( this );
		tableUuidGen = new CFBamMySqlUuidGenTable( this );
		tableUuidType = new CFBamMySqlUuidTypeTable( this );
		tableValue = new CFBamMySqlValueTable( this );
		tableVersion = new CFBamMySqlVersionTable( this );
		try {
			cnx.setAutoCommit( false );
			cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
			cnx.rollback();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"CFBamMySqlSchema-constructor",
				e );
		}
	}

	public Connection getCnx() {
		return( cnx );
	}

	public boolean isConnected() {
		final String S_ProcName = "isConnected";
		boolean retval;
		if( cnx == null ) {
			retval = false;
		}
		else {
			try {
				if( cnx.isClosed() ) {
					retval = false;
					cnx = null;
					releasePreparedStatements();
				}
				else {
					retval = true;
				}
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
		}
		return( retval );
	}

	public boolean connect() {
		final String S_ProcName = "connect";
		if( cnx != null ) {
			return( false );
		}

		if( configuration != null ) {
			try {
				Class.forName( "com.mysql.jdbc.Driver" );
			}
			catch( ClassNotFoundException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"connect",
					"Could not load MySql 5.5 JDBC driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = configuration.getDbUserName();
			String dbPassword = configuration.getDbPassword();
			String url =
					"jdbc:mysql://" + dbServer
				+	":" + Integer.toString( dbPort )
				+	"/" + dbDatabase;
			Properties props = new Properties();
			props.setProperty( "user", dbUserName );
			props.setProperty( "password", dbPassword );
			try {
				cnx = DriverManager.getConnection( url, props );
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
				setDbSchemaName( dbDatabase );
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			return( true );
		}
		if( jndiName != null ) {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup( jndiName );
				if( ds == null ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Could not get resolve DataSource \"" + jndiName + "\"" );
				}
				cnx = ds.getConnection();
				if( cnx == null ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Could not get Connection from PooledConnection for ConnectionPoolDataSource \"" + jndiName + "\"" );
				}
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
			}
			catch( NamingException e ) {
				cnx = null;
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"NamingException " + e.getMessage(),
					e );
			}
			catch( SQLException e ) {
				cnx = null;
				inTransaction = false;
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			return( true );
		}
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
			S_ProcName,
			"Neither configurationFile nor jndiName found, do not know how to connect to database" );
	}

	public boolean connect( String username, String password ) {
		final String S_ProcName = "connect-userpw";
		if( cnx != null ) {
			return( false );
		}
		if( ( username == null ) || ( username.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"username" );
		}
		if( password == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"password" );
		}

		if( configuration != null ) {
			try {
				Class.forName( "com.mysql.jdbc.Driver" );
			}
			catch( ClassNotFoundException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"connect",
					"Could not load MySql 5.5 JDBC driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = username;
			String dbPassword = password;
			String url =
					"jdbc:mysql://" + dbServer
				+	":" + Integer.toString( dbPort )
				+	"/" + dbDatabase;
			Properties props = new Properties();
			props.setProperty( "user", dbUserName );
			props.setProperty( "password", dbPassword );
			try {
				cnx = DriverManager.getConnection( url, props );
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
				setDbSchemaName( dbDatabase );
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			return( true );
		}
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
			S_ProcName,
			"configurationFile not found, do not know how to connect to database" );
	}

	public void disconnect( boolean doCommit ) {
		final String S_ProcName = "disconnect";
		if( cnx != null ) {
			try {
				if( ! cnx.isClosed() ) {
					if( doCommit ) {
						cnx.commit();
					}
					else {
						cnx.rollback();
					}
					cnx.close();
				}
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				cnx = null;
			}
		}
		releasePreparedStatements();
	}

	public boolean isTransactionOpen() {
		return( inTransaction );
	}

	public boolean beginTransaction() {
		if( inTransaction ) {
			return( false );
		}
//		try {
//			String sql =
//					"begin transaction";
//			Statement stmt = cnx.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
//			stmt.execute( sql );
			inTransaction = true;
//		}
//		catch( SQLException e ) {
//			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//				"beginTransaction",
//				e );
//		}
		return( inTransaction );
	}

	public void commit() {
		try {
			cnx.commit();
			inTransaction = false;
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"commit",
				e );
		}
	}

	public void rollback() {
		try {
			if( cnx != null ) {
				cnx.rollback();
			}
			inTransaction = false;
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"rollback",
				e );
		}
	}

	public boolean isSystemUser( CFBamAuthorization Authorization) {
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"isSystemUser",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			String sql = "SELECT " + getLowerDbSchemaName() + ".sp_is_system_user( ? ) as IsSystemUser";
			if( stmtSelectIsSystemUser == null ) {
				stmtSelectIsSystemUser = cnx.prepareStatement( sql );
			}
			stmtSelectIsSystemUser.setString( 1, Authorization.getSecUserId().toString() );
			resultSet = stmtSelectIsSystemUser.executeQuery();
			boolean resultFlag;
			if( resultSet.next() ) {
				resultFlag = resultSet.getBoolean( 1 );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"isSystemUser",
           			"Query of sp_is_system_user() did not return a result row" );
			}
			resultSet.close();
			return( resultFlag );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"isSystemUser",
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

	public boolean isClusterUser( CFBamAuthorization Authorization,
		long clusterId,
		String groupName )
	{
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"isClusterUser",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			String sql = "SELECT " + getLowerDbSchemaName() + ".sp_is_cluster_user( ?, ?, ? ) as IsClusterUser";
			if( stmtSelectIsClusterUser == null ) {
				stmtSelectIsClusterUser = cnx.prepareStatement( sql );
			}
			stmtSelectIsClusterUser.setLong( 1, clusterId );
			stmtSelectIsClusterUser.setString( 2, groupName );
			stmtSelectIsClusterUser.setString( 3, Authorization.getSecUserId().toString() );
			resultSet = stmtSelectIsClusterUser.executeQuery();
			boolean resultFlag;
			if( resultSet.next() ) {
				resultFlag = resultSet.getBoolean( 1 );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"isClusterUser",
           			"Query of sp_is_cluster_user() did not return a result row" );
			}
			resultSet.close();
			return( resultFlag );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"isClusterUser",
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

	public boolean isTenantUser( CFBamAuthorization Authorization,
		long tenantId,
		String groupName )
	{
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"isTenantUser",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			String sql = "SELECT " + getLowerDbSchemaName() + ".sp_is_tenant_user( ?, ?, ? ) as IsTenantUser";
			if( stmtSelectIsTenantUser == null ) {
				stmtSelectIsTenantUser = cnx.prepareStatement( sql );
			}
			stmtSelectIsTenantUser.setLong( 1, tenantId );
			stmtSelectIsTenantUser.setString( 2, groupName );
			stmtSelectIsTenantUser.setString( 3, Authorization.getSecUserId().toString() );
			resultSet = stmtSelectIsTenantUser.executeQuery();
			boolean resultFlag;
			if( resultSet.next() ) {
				resultFlag = resultSet.getBoolean( 1 );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"isTenantUser",
           			"Query of sp_is_tenant_user() did not return a result row" );
			}
			resultSet.close();
			return( resultFlag );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"isTenantUser",
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

	public void releasePreparedStatements() {
		if( stmtSelectIsSystemUser != null ) {
			try {
				stmtSelectIsSystemUser.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectIsSystemUser = null;
		}
		if( stmtSelectIsClusterUser != null ) {
			try {
				stmtSelectIsClusterUser.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectIsClusterUser = null;
		}
		if( stmtSelectIsTenantUser != null ) {
			try {
				stmtSelectIsTenantUser.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectIsTenantUser = null;
		}
		if( stmtSelectNextServiceTypeIdGen != null ) {
			try {
				stmtSelectNextServiceTypeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextServiceTypeIdGen= null;
		}
		if( stmtInsertNextServiceTypeIdGen != null ) {
			try {
				stmtInsertNextServiceTypeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtInsertNextServiceTypeIdGen= null;
		}
		if( stmtUpdateNextServiceTypeIdGen != null ) {
			try {
				stmtUpdateNextServiceTypeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtUpdateNextServiceTypeIdGen= null;
		}
		if( stmtSelectNextMimeTypeIdGen != null ) {
			try {
				stmtSelectNextMimeTypeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextMimeTypeIdGen= null;
		}
		if( stmtInsertNextMimeTypeIdGen != null ) {
			try {
				stmtInsertNextMimeTypeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtInsertNextMimeTypeIdGen= null;
		}
		if( stmtUpdateNextMimeTypeIdGen != null ) {
			try {
				stmtUpdateNextMimeTypeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtUpdateNextMimeTypeIdGen= null;
		}
		if( stmtSelectNextClusterIdGen != null ) {
			try {
				stmtSelectNextClusterIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextClusterIdGen= null;
		}
		if( stmtInsertNextClusterIdGen != null ) {
			try {
				stmtInsertNextClusterIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtInsertNextClusterIdGen= null;
		}
		if( stmtUpdateNextClusterIdGen != null ) {
			try {
				stmtUpdateNextClusterIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtUpdateNextClusterIdGen= null;
		}
		if( stmtSelectNextTenantIdGen != null ) {
			try {
				stmtSelectNextTenantIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTenantIdGen= null;
		}
		if( stmtInsertNextTenantIdGen != null ) {
			try {
				stmtInsertNextTenantIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtInsertNextTenantIdGen= null;
		}
		if( stmtUpdateNextTenantIdGen != null ) {
			try {
				stmtUpdateNextTenantIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtUpdateNextTenantIdGen= null;
		}
		if( tableAccessFrequency != null ) {
			((CFBamMySqlAccessFrequencyTable)tableAccessFrequency).releasePreparedStatements();
		}
		if( tableAccessSecurity != null ) {
			((CFBamMySqlAccessSecurityTable)tableAccessSecurity).releasePreparedStatements();
		}
		if( tableAtom != null ) {
			((CFBamMySqlAtomTable)tableAtom).releasePreparedStatements();
		}
		if( tableAuditAction != null ) {
			((CFBamMySqlAuditActionTable)tableAuditAction).releasePreparedStatements();
		}
		if( tableBlobCol != null ) {
			((CFBamMySqlBlobColTable)tableBlobCol).releasePreparedStatements();
		}
		if( tableBlobDef != null ) {
			((CFBamMySqlBlobDefTable)tableBlobDef).releasePreparedStatements();
		}
		if( tableBlobType != null ) {
			((CFBamMySqlBlobTypeTable)tableBlobType).releasePreparedStatements();
		}
		if( tableBoolCol != null ) {
			((CFBamMySqlBoolColTable)tableBoolCol).releasePreparedStatements();
		}
		if( tableBoolDef != null ) {
			((CFBamMySqlBoolDefTable)tableBoolDef).releasePreparedStatements();
		}
		if( tableBoolType != null ) {
			((CFBamMySqlBoolTypeTable)tableBoolType).releasePreparedStatements();
		}
		if( tableChain != null ) {
			((CFBamMySqlChainTable)tableChain).releasePreparedStatements();
		}
		if( tableClearDep != null ) {
			((CFBamMySqlClearDepTable)tableClearDep).releasePreparedStatements();
		}
		if( tableClearSubDep1 != null ) {
			((CFBamMySqlClearSubDep1Table)tableClearSubDep1).releasePreparedStatements();
		}
		if( tableClearSubDep2 != null ) {
			((CFBamMySqlClearSubDep2Table)tableClearSubDep2).releasePreparedStatements();
		}
		if( tableClearSubDep3 != null ) {
			((CFBamMySqlClearSubDep3Table)tableClearSubDep3).releasePreparedStatements();
		}
		if( tableClearTopDep != null ) {
			((CFBamMySqlClearTopDepTable)tableClearTopDep).releasePreparedStatements();
		}
		if( tableCluster != null ) {
			((CFBamMySqlClusterTable)tableCluster).releasePreparedStatements();
		}
		if( tableDataScope != null ) {
			((CFBamMySqlDataScopeTable)tableDataScope).releasePreparedStatements();
		}
		if( tableDateCol != null ) {
			((CFBamMySqlDateColTable)tableDateCol).releasePreparedStatements();
		}
		if( tableDateDef != null ) {
			((CFBamMySqlDateDefTable)tableDateDef).releasePreparedStatements();
		}
		if( tableDateType != null ) {
			((CFBamMySqlDateTypeTable)tableDateType).releasePreparedStatements();
		}
		if( tableDelDep != null ) {
			((CFBamMySqlDelDepTable)tableDelDep).releasePreparedStatements();
		}
		if( tableDelSubDep1 != null ) {
			((CFBamMySqlDelSubDep1Table)tableDelSubDep1).releasePreparedStatements();
		}
		if( tableDelSubDep2 != null ) {
			((CFBamMySqlDelSubDep2Table)tableDelSubDep2).releasePreparedStatements();
		}
		if( tableDelSubDep3 != null ) {
			((CFBamMySqlDelSubDep3Table)tableDelSubDep3).releasePreparedStatements();
		}
		if( tableDelTopDep != null ) {
			((CFBamMySqlDelTopDepTable)tableDelTopDep).releasePreparedStatements();
		}
		if( tableDomain != null ) {
			((CFBamMySqlDomainTable)tableDomain).releasePreparedStatements();
		}
		if( tableDomainBase != null ) {
			((CFBamMySqlDomainBaseTable)tableDomainBase).releasePreparedStatements();
		}
		if( tableDoubleCol != null ) {
			((CFBamMySqlDoubleColTable)tableDoubleCol).releasePreparedStatements();
		}
		if( tableDoubleDef != null ) {
			((CFBamMySqlDoubleDefTable)tableDoubleDef).releasePreparedStatements();
		}
		if( tableDoubleType != null ) {
			((CFBamMySqlDoubleTypeTable)tableDoubleType).releasePreparedStatements();
		}
		if( tableEnumCol != null ) {
			((CFBamMySqlEnumColTable)tableEnumCol).releasePreparedStatements();
		}
		if( tableEnumDef != null ) {
			((CFBamMySqlEnumDefTable)tableEnumDef).releasePreparedStatements();
		}
		if( tableEnumTag != null ) {
			((CFBamMySqlEnumTagTable)tableEnumTag).releasePreparedStatements();
		}
		if( tableEnumType != null ) {
			((CFBamMySqlEnumTypeTable)tableEnumType).releasePreparedStatements();
		}
		if( tableFloatCol != null ) {
			((CFBamMySqlFloatColTable)tableFloatCol).releasePreparedStatements();
		}
		if( tableFloatDef != null ) {
			((CFBamMySqlFloatDefTable)tableFloatDef).releasePreparedStatements();
		}
		if( tableFloatType != null ) {
			((CFBamMySqlFloatTypeTable)tableFloatType).releasePreparedStatements();
		}
		if( tableHostNode != null ) {
			((CFBamMySqlHostNodeTable)tableHostNode).releasePreparedStatements();
		}
		if( tableISOCountry != null ) {
			((CFBamMySqlISOCountryTable)tableISOCountry).releasePreparedStatements();
		}
		if( tableISOCountryCurrency != null ) {
			((CFBamMySqlISOCountryCurrencyTable)tableISOCountryCurrency).releasePreparedStatements();
		}
		if( tableISOCountryLanguage != null ) {
			((CFBamMySqlISOCountryLanguageTable)tableISOCountryLanguage).releasePreparedStatements();
		}
		if( tableISOCurrency != null ) {
			((CFBamMySqlISOCurrencyTable)tableISOCurrency).releasePreparedStatements();
		}
		if( tableISOLanguage != null ) {
			((CFBamMySqlISOLanguageTable)tableISOLanguage).releasePreparedStatements();
		}
		if( tableISOTimezone != null ) {
			((CFBamMySqlISOTimezoneTable)tableISOTimezone).releasePreparedStatements();
		}
		if( tableId16Gen != null ) {
			((CFBamMySqlId16GenTable)tableId16Gen).releasePreparedStatements();
		}
		if( tableId32Gen != null ) {
			((CFBamMySqlId32GenTable)tableId32Gen).releasePreparedStatements();
		}
		if( tableId64Gen != null ) {
			((CFBamMySqlId64GenTable)tableId64Gen).releasePreparedStatements();
		}
		if( tableIndex != null ) {
			((CFBamMySqlIndexTable)tableIndex).releasePreparedStatements();
		}
		if( tableIndexCol != null ) {
			((CFBamMySqlIndexColTable)tableIndexCol).releasePreparedStatements();
		}
		if( tableInt16Col != null ) {
			((CFBamMySqlInt16ColTable)tableInt16Col).releasePreparedStatements();
		}
		if( tableInt16Def != null ) {
			((CFBamMySqlInt16DefTable)tableInt16Def).releasePreparedStatements();
		}
		if( tableInt16Type != null ) {
			((CFBamMySqlInt16TypeTable)tableInt16Type).releasePreparedStatements();
		}
		if( tableInt32Col != null ) {
			((CFBamMySqlInt32ColTable)tableInt32Col).releasePreparedStatements();
		}
		if( tableInt32Def != null ) {
			((CFBamMySqlInt32DefTable)tableInt32Def).releasePreparedStatements();
		}
		if( tableInt32Type != null ) {
			((CFBamMySqlInt32TypeTable)tableInt32Type).releasePreparedStatements();
		}
		if( tableInt64Col != null ) {
			((CFBamMySqlInt64ColTable)tableInt64Col).releasePreparedStatements();
		}
		if( tableInt64Def != null ) {
			((CFBamMySqlInt64DefTable)tableInt64Def).releasePreparedStatements();
		}
		if( tableInt64Type != null ) {
			((CFBamMySqlInt64TypeTable)tableInt64Type).releasePreparedStatements();
		}
		if( tableLicense != null ) {
			((CFBamMySqlLicenseTable)tableLicense).releasePreparedStatements();
		}
		if( tableLoaderBehaviour != null ) {
			((CFBamMySqlLoaderBehaviourTable)tableLoaderBehaviour).releasePreparedStatements();
		}
		if( tableMajorVersion != null ) {
			((CFBamMySqlMajorVersionTable)tableMajorVersion).releasePreparedStatements();
		}
		if( tableMimeType != null ) {
			((CFBamMySqlMimeTypeTable)tableMimeType).releasePreparedStatements();
		}
		if( tableMinorVersion != null ) {
			((CFBamMySqlMinorVersionTable)tableMinorVersion).releasePreparedStatements();
		}
		if( tableNmTokenCol != null ) {
			((CFBamMySqlNmTokenColTable)tableNmTokenCol).releasePreparedStatements();
		}
		if( tableNmTokenDef != null ) {
			((CFBamMySqlNmTokenDefTable)tableNmTokenDef).releasePreparedStatements();
		}
		if( tableNmTokenType != null ) {
			((CFBamMySqlNmTokenTypeTable)tableNmTokenType).releasePreparedStatements();
		}
		if( tableNmTokensCol != null ) {
			((CFBamMySqlNmTokensColTable)tableNmTokensCol).releasePreparedStatements();
		}
		if( tableNmTokensDef != null ) {
			((CFBamMySqlNmTokensDefTable)tableNmTokensDef).releasePreparedStatements();
		}
		if( tableNmTokensType != null ) {
			((CFBamMySqlNmTokensTypeTable)tableNmTokensType).releasePreparedStatements();
		}
		if( tableNumberCol != null ) {
			((CFBamMySqlNumberColTable)tableNumberCol).releasePreparedStatements();
		}
		if( tableNumberDef != null ) {
			((CFBamMySqlNumberDefTable)tableNumberDef).releasePreparedStatements();
		}
		if( tableNumberType != null ) {
			((CFBamMySqlNumberTypeTable)tableNumberType).releasePreparedStatements();
		}
		if( tableParam != null ) {
			((CFBamMySqlParamTable)tableParam).releasePreparedStatements();
		}
		if( tablePopDep != null ) {
			((CFBamMySqlPopDepTable)tablePopDep).releasePreparedStatements();
		}
		if( tablePopSubDep1 != null ) {
			((CFBamMySqlPopSubDep1Table)tablePopSubDep1).releasePreparedStatements();
		}
		if( tablePopSubDep2 != null ) {
			((CFBamMySqlPopSubDep2Table)tablePopSubDep2).releasePreparedStatements();
		}
		if( tablePopSubDep3 != null ) {
			((CFBamMySqlPopSubDep3Table)tablePopSubDep3).releasePreparedStatements();
		}
		if( tablePopTopDep != null ) {
			((CFBamMySqlPopTopDepTable)tablePopTopDep).releasePreparedStatements();
		}
		if( tableProjectBase != null ) {
			((CFBamMySqlProjectBaseTable)tableProjectBase).releasePreparedStatements();
		}
		if( tableRealProject != null ) {
			((CFBamMySqlRealProjectTable)tableRealProject).releasePreparedStatements();
		}
		if( tableRelation != null ) {
			((CFBamMySqlRelationTable)tableRelation).releasePreparedStatements();
		}
		if( tableRelationCol != null ) {
			((CFBamMySqlRelationColTable)tableRelationCol).releasePreparedStatements();
		}
		if( tableRelationType != null ) {
			((CFBamMySqlRelationTypeTable)tableRelationType).releasePreparedStatements();
		}
		if( tableSchemaDef != null ) {
			((CFBamMySqlSchemaDefTable)tableSchemaDef).releasePreparedStatements();
		}
		if( tableSchemaRef != null ) {
			((CFBamMySqlSchemaRefTable)tableSchemaRef).releasePreparedStatements();
		}
		if( tableScope != null ) {
			((CFBamMySqlScopeTable)tableScope).releasePreparedStatements();
		}
		if( tableSecApp != null ) {
			((CFBamMySqlSecAppTable)tableSecApp).releasePreparedStatements();
		}
		if( tableSecDevice != null ) {
			((CFBamMySqlSecDeviceTable)tableSecDevice).releasePreparedStatements();
		}
		if( tableSecForm != null ) {
			((CFBamMySqlSecFormTable)tableSecForm).releasePreparedStatements();
		}
		if( tableSecGroup != null ) {
			((CFBamMySqlSecGroupTable)tableSecGroup).releasePreparedStatements();
		}
		if( tableSecGroupForm != null ) {
			((CFBamMySqlSecGroupFormTable)tableSecGroupForm).releasePreparedStatements();
		}
		if( tableSecGroupInclude != null ) {
			((CFBamMySqlSecGroupIncludeTable)tableSecGroupInclude).releasePreparedStatements();
		}
		if( tableSecGroupMember != null ) {
			((CFBamMySqlSecGroupMemberTable)tableSecGroupMember).releasePreparedStatements();
		}
		if( tableSecSession != null ) {
			((CFBamMySqlSecSessionTable)tableSecSession).releasePreparedStatements();
		}
		if( tableSecUser != null ) {
			((CFBamMySqlSecUserTable)tableSecUser).releasePreparedStatements();
		}
		if( tableSecurityScope != null ) {
			((CFBamMySqlSecurityScopeTable)tableSecurityScope).releasePreparedStatements();
		}
		if( tableServerListFunc != null ) {
			((CFBamMySqlServerListFuncTable)tableServerListFunc).releasePreparedStatements();
		}
		if( tableServerMethod != null ) {
			((CFBamMySqlServerMethodTable)tableServerMethod).releasePreparedStatements();
		}
		if( tableServerObjFunc != null ) {
			((CFBamMySqlServerObjFuncTable)tableServerObjFunc).releasePreparedStatements();
		}
		if( tableServerProc != null ) {
			((CFBamMySqlServerProcTable)tableServerProc).releasePreparedStatements();
		}
		if( tableService != null ) {
			((CFBamMySqlServiceTable)tableService).releasePreparedStatements();
		}
		if( tableServiceType != null ) {
			((CFBamMySqlServiceTypeTable)tableServiceType).releasePreparedStatements();
		}
		if( tableStringCol != null ) {
			((CFBamMySqlStringColTable)tableStringCol).releasePreparedStatements();
		}
		if( tableStringDef != null ) {
			((CFBamMySqlStringDefTable)tableStringDef).releasePreparedStatements();
		}
		if( tableStringType != null ) {
			((CFBamMySqlStringTypeTable)tableStringType).releasePreparedStatements();
		}
		if( tableSubProject != null ) {
			((CFBamMySqlSubProjectTable)tableSubProject).releasePreparedStatements();
		}
		if( tableSysCluster != null ) {
			((CFBamMySqlSysClusterTable)tableSysCluster).releasePreparedStatements();
		}
		if( tableTSecGroup != null ) {
			((CFBamMySqlTSecGroupTable)tableTSecGroup).releasePreparedStatements();
		}
		if( tableTSecGroupInclude != null ) {
			((CFBamMySqlTSecGroupIncludeTable)tableTSecGroupInclude).releasePreparedStatements();
		}
		if( tableTSecGroupMember != null ) {
			((CFBamMySqlTSecGroupMemberTable)tableTSecGroupMember).releasePreparedStatements();
		}
		if( tableTZDateCol != null ) {
			((CFBamMySqlTZDateColTable)tableTZDateCol).releasePreparedStatements();
		}
		if( tableTZDateDef != null ) {
			((CFBamMySqlTZDateDefTable)tableTZDateDef).releasePreparedStatements();
		}
		if( tableTZDateType != null ) {
			((CFBamMySqlTZDateTypeTable)tableTZDateType).releasePreparedStatements();
		}
		if( tableTZTimeCol != null ) {
			((CFBamMySqlTZTimeColTable)tableTZTimeCol).releasePreparedStatements();
		}
		if( tableTZTimeDef != null ) {
			((CFBamMySqlTZTimeDefTable)tableTZTimeDef).releasePreparedStatements();
		}
		if( tableTZTimeType != null ) {
			((CFBamMySqlTZTimeTypeTable)tableTZTimeType).releasePreparedStatements();
		}
		if( tableTZTimestampCol != null ) {
			((CFBamMySqlTZTimestampColTable)tableTZTimestampCol).releasePreparedStatements();
		}
		if( tableTZTimestampDef != null ) {
			((CFBamMySqlTZTimestampDefTable)tableTZTimestampDef).releasePreparedStatements();
		}
		if( tableTZTimestampType != null ) {
			((CFBamMySqlTZTimestampTypeTable)tableTZTimestampType).releasePreparedStatements();
		}
		if( tableTable != null ) {
			((CFBamMySqlTableTable)tableTable).releasePreparedStatements();
		}
		if( tableTableCol != null ) {
			((CFBamMySqlTableColTable)tableTableCol).releasePreparedStatements();
		}
		if( tableTenant != null ) {
			((CFBamMySqlTenantTable)tableTenant).releasePreparedStatements();
		}
		if( tableTextCol != null ) {
			((CFBamMySqlTextColTable)tableTextCol).releasePreparedStatements();
		}
		if( tableTextDef != null ) {
			((CFBamMySqlTextDefTable)tableTextDef).releasePreparedStatements();
		}
		if( tableTextType != null ) {
			((CFBamMySqlTextTypeTable)tableTextType).releasePreparedStatements();
		}
		if( tableTimeCol != null ) {
			((CFBamMySqlTimeColTable)tableTimeCol).releasePreparedStatements();
		}
		if( tableTimeDef != null ) {
			((CFBamMySqlTimeDefTable)tableTimeDef).releasePreparedStatements();
		}
		if( tableTimeType != null ) {
			((CFBamMySqlTimeTypeTable)tableTimeType).releasePreparedStatements();
		}
		if( tableTimestampCol != null ) {
			((CFBamMySqlTimestampColTable)tableTimestampCol).releasePreparedStatements();
		}
		if( tableTimestampDef != null ) {
			((CFBamMySqlTimestampDefTable)tableTimestampDef).releasePreparedStatements();
		}
		if( tableTimestampType != null ) {
			((CFBamMySqlTimestampTypeTable)tableTimestampType).releasePreparedStatements();
		}
		if( tableTld != null ) {
			((CFBamMySqlTldTable)tableTld).releasePreparedStatements();
		}
		if( tableTokenCol != null ) {
			((CFBamMySqlTokenColTable)tableTokenCol).releasePreparedStatements();
		}
		if( tableTokenDef != null ) {
			((CFBamMySqlTokenDefTable)tableTokenDef).releasePreparedStatements();
		}
		if( tableTokenType != null ) {
			((CFBamMySqlTokenTypeTable)tableTokenType).releasePreparedStatements();
		}
		if( tableTopDomain != null ) {
			((CFBamMySqlTopDomainTable)tableTopDomain).releasePreparedStatements();
		}
		if( tableTopProject != null ) {
			((CFBamMySqlTopProjectTable)tableTopProject).releasePreparedStatements();
		}
		if( tableUInt16Col != null ) {
			((CFBamMySqlUInt16ColTable)tableUInt16Col).releasePreparedStatements();
		}
		if( tableUInt16Def != null ) {
			((CFBamMySqlUInt16DefTable)tableUInt16Def).releasePreparedStatements();
		}
		if( tableUInt16Type != null ) {
			((CFBamMySqlUInt16TypeTable)tableUInt16Type).releasePreparedStatements();
		}
		if( tableUInt32Col != null ) {
			((CFBamMySqlUInt32ColTable)tableUInt32Col).releasePreparedStatements();
		}
		if( tableUInt32Def != null ) {
			((CFBamMySqlUInt32DefTable)tableUInt32Def).releasePreparedStatements();
		}
		if( tableUInt32Type != null ) {
			((CFBamMySqlUInt32TypeTable)tableUInt32Type).releasePreparedStatements();
		}
		if( tableUInt64Col != null ) {
			((CFBamMySqlUInt64ColTable)tableUInt64Col).releasePreparedStatements();
		}
		if( tableUInt64Def != null ) {
			((CFBamMySqlUInt64DefTable)tableUInt64Def).releasePreparedStatements();
		}
		if( tableUInt64Type != null ) {
			((CFBamMySqlUInt64TypeTable)tableUInt64Type).releasePreparedStatements();
		}
		if( tableURLProtocol != null ) {
			((CFBamMySqlURLProtocolTable)tableURLProtocol).releasePreparedStatements();
		}
		if( tableUuidCol != null ) {
			((CFBamMySqlUuidColTable)tableUuidCol).releasePreparedStatements();
		}
		if( tableUuidDef != null ) {
			((CFBamMySqlUuidDefTable)tableUuidDef).releasePreparedStatements();
		}
		if( tableUuidGen != null ) {
			((CFBamMySqlUuidGenTable)tableUuidGen).releasePreparedStatements();
		}
		if( tableUuidType != null ) {
			((CFBamMySqlUuidTypeTable)tableUuidType).releasePreparedStatements();
		}
		if( tableValue != null ) {
			((CFBamMySqlValueTable)tableValue).releasePreparedStatements();
		}
		if( tableVersion != null ) {
			((CFBamMySqlVersionTable)tableVersion).releasePreparedStatements();
		}
	}

	public int nextServiceTypeIdGen() {
		final String S_ProcName = "nextServiceTypeIdGen";
		String sqlSelectNextIdGen =
				"SELECT " + getLowerDbSchemaName() + ".sp_next_servicetypeidgen() as NextServiceTypeIdGen;";
		if( ! isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = getCnx();
			if( stmtSelectNextServiceTypeIdGen == null ) {
				stmtSelectNextServiceTypeIdGen = cnx.prepareStatement( sqlSelectNextIdGen );
			}
			int nextId;
			rsSelect = stmtSelectNextServiceTypeIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getInt( 1 );
				if( rsSelect.wasNull() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"next_id cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-buff select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be returned by invoking " + getLowerDbSchemaName() + ".sp_next_servicetypeidgen()" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public int nextMimeTypeIdGen() {
		final String S_ProcName = "nextMimeTypeIdGen";
		String sqlSelectNextIdGen =
				"SELECT " + getLowerDbSchemaName() + ".sp_next_mimetypeidgen() as NextMimeTypeIdGen;";
		if( ! isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = getCnx();
			if( stmtSelectNextMimeTypeIdGen == null ) {
				stmtSelectNextMimeTypeIdGen = cnx.prepareStatement( sqlSelectNextIdGen );
			}
			int nextId;
			rsSelect = stmtSelectNextMimeTypeIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getInt( 1 );
				if( rsSelect.wasNull() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"next_id cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-buff select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be returned by invoking " + getLowerDbSchemaName() + ".sp_next_mimetypeidgen()" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextClusterIdGen() {
		final String S_ProcName = "nextClusterIdGen";
		String sqlSelectNextIdGen =
				"SELECT " + getLowerDbSchemaName() + ".sp_next_clusteridgen() as NextClusterIdGen;";
		if( ! isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = getCnx();
			if( stmtSelectNextClusterIdGen == null ) {
				stmtSelectNextClusterIdGen = cnx.prepareStatement( sqlSelectNextIdGen );
			}
			long nextId;
			rsSelect = stmtSelectNextClusterIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"next_id cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-buff select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be returned by invoking " + getLowerDbSchemaName() + ".sp_next_clusteridgen()" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextTenantIdGen() {
		final String S_ProcName = "nextTenantIdGen";
		String sqlSelectNextIdGen =
				"SELECT " + getLowerDbSchemaName() + ".sp_next_tenantidgen() as NextTenantIdGen;";
		if( ! isTransactionOpen() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = getCnx();
			if( stmtSelectNextTenantIdGen == null ) {
				stmtSelectNextTenantIdGen = cnx.prepareStatement( sqlSelectNextIdGen );
			}
			long nextId;
			rsSelect = stmtSelectNextTenantIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"next_id cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-buff select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 row to be returned by invoking " + getLowerDbSchemaName() + ".sp_next_tenantidgen()" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public UUID nextSecSessionIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	public UUID nextSecUserIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	/**
	 *	Import the contents of the specified file name
	 *	and file contents by applying a SAX Loader parse.
	 */
	public String fileImport( CFBamAuthorization auth, String fileName, String fileContents ) {
		if( isTransactionOpen() ) {
			rollback();
		}

		try {
			beginTransaction();

			CFBamSaxLoader saxLoader = new CFBamSaxLoader();
			ICFBamSchemaObj schemaObj = new CFBamSchemaObj();
			schemaObj.setBackingStore( this );
			saxLoader.setSchemaObj( schemaObj );
			ICFBamClusterObj useCluster = schemaObj.getClusterTableObj().readClusterByIdIdx( auth.getSecClusterId() );
			ICFBamTenantObj useTenant = schemaObj.getTenantTableObj().readTenantByIdIdx( auth.getSecTenantId() );
			ICFLibMessageLog runlog = new CFLibMessageLogWrapper();
			saxLoader.setLog( runlog );
			saxLoader.setUseCluster( useCluster );
			saxLoader.setUseTenant( useTenant );
			saxLoader.parseStringContents( fileContents );
			String logFileContents = runlog.getBacklog();
			if( logFileContents == null ) {
				logFileContents = "";
			}
	
			commit();

			return( logFileContents );
		}
		catch( RuntimeException e ) {
			rollback();
			throw e;
		}
		catch( Error e ) {
			rollback();
			throw e;
		}
	}

	public static String getQuotedString(String val) {
		if (val == null) {
			return ("null");
		}
		else {
			char c;
			StringBuilder quoted = new StringBuilder();
			quoted.append( "'" );
			int len = val.length();
			for (int i = 0; i < len; i++)
			{
				if (val.charAt( i ) == '\'')
				{
					quoted.append("''");
				}
				else if (val.charAt( i ) == '\\') {
					quoted.append("'||E'\\\\'||'");
				}
				else {
					c = val.charAt( i );
					if (   ( c == '0' )
						|| ( c == '1' )
						|| ( c == '2' )
						|| ( c == '3' )
						|| ( c == '4' )
						|| ( c == '5' )
						|| ( c == '6' )
						|| ( c == '7' )
						|| ( c == '8' )
						|| ( c == '9' )
						|| ( c == 'a' )
						|| ( c == 'b' )
						|| ( c == 'c' )
						|| ( c == 'd' )
						|| ( c == 'e' )
						|| ( c == 'f' )
						|| ( c == 'g' )
						|| ( c == 'h' )
						|| ( c == 'i' )
						|| ( c == 'j' )
						|| ( c == 'k' )
						|| ( c == 'l' )
						|| ( c == 'm' )
						|| ( c == 'n' )
						|| ( c == 'o' )
						|| ( c == 'p' )
						|| ( c == 'q' )
						|| ( c == 'r' )
						|| ( c == 's' )
						|| ( c == 't' )
						|| ( c == 'u' )
						|| ( c == 'v' )
						|| ( c == 'w' )
						|| ( c == 'x' )
						|| ( c == 'y' )
						|| ( c == 'z' )
						|| ( c == 'A' )
						|| ( c == 'B' )
						|| ( c == 'C' )
						|| ( c == 'D' )
						|| ( c == 'E' )
						|| ( c == 'F' )
						|| ( c == 'G' )
						|| ( c == 'H' )
						|| ( c == 'I' )
						|| ( c == 'J' )
						|| ( c == 'K' )
						|| ( c == 'L' )
						|| ( c == 'M' )
						|| ( c == 'N' )
						|| ( c == 'O' )
						|| ( c == 'P' )
						|| ( c == 'Q' )
						|| ( c == 'R' )
						|| ( c == 'S' )
						|| ( c == 'T' )
						|| ( c == 'U' )
						|| ( c == 'V' )
						|| ( c == 'W' )
						|| ( c == 'X' )
						|| ( c == 'Y' )
						|| ( c == 'Z' )
						|| ( c == ' ' )
						|| ( c == '\t' )
						|| ( c == '\r' )
						|| ( c == '\n' )
						|| ( c == '`' )
						|| ( c == '~' )
						|| ( c == '!' )
						|| ( c == '@' )
						|| ( c == '#' )
						|| ( c == '$' )
						|| ( c == '%' )
						|| ( c == '^' )
						|| ( c == '&' )
						|| ( c == '*' )
						|| ( c == '(' )
						|| ( c == ')' )
						|| ( c == '-' )
						|| ( c == '_' )
						|| ( c == '=' )
						|| ( c == '+' )
						|| ( c == '[' )
						|| ( c == ']' )
						|| ( c == '{' )
						|| ( c == '}' )
						|| ( c == '|' )
						|| ( c == ';' )
						|| ( c == ':' )
						|| ( c == '"' )
						|| ( c == '<' )
						|| ( c == '>' )
						|| ( c == ',' )
						|| ( c == '.' )
						|| ( c == '/' )
						|| ( c == '?' ))
					{
						quoted.append(c);
					}
					else {
//						Syslog.warn("\t\t\tReplacing invalid character '" + c + "' with space");
						quoted.append( ' ' );
					}
				}
			}
			quoted.append( "'" );
			return (quoted.toString());
			}
		}

	public static String getNullableString(ResultSet reader, int colidx) {
		try {
			String val = reader.getString( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( val );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMySqlSchema.class,
				"getNullableString",
				e );
		}
	}

	public static String getBlobString(byte[] val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( "'" + new String( Base64.encodeBase64( val ) ) + "'" );
		}
	}

	public static String getBoolString(Boolean val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			if( val ) {
				return( "true" );
			}
			else {
				return( "false" );
			}
		}
	}

	public static String getBoolString(boolean val) {
		if( val ) {
			return( "true" );
		}
		else {
			return( "false" );
		}
	}

	public static String getInt16String(Short val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getInt16String(short val) {
		return( Short.toString( val ) );
	}

	public static String getInt32String(Integer val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getInt32String(int val) {
		return( Integer.toString( val ) );
	}

	public static String getInt64String(Long val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getInt64String(long val) {
		return( Long.toString( val ) );
	}

	public static String getUInt16String(Integer val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getUInt16String(int val) {
		return( Integer.toString( val ) );
	}

	public static String getUInt32String(Long val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getUInt32String(long val) {
		return( Long.toString( val ) );
	}

	public static String getUInt64String(BigDecimal val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getFloatString(Float val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getFloatString(float val) {
		return( Float.toString( val ) );
	}

	public static String getDoubleString(Double val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getDoubleString(double val) {
		return( Double.toString( val ) );
	}

	public static String getNumberString(BigDecimal val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static Integer getNullableInt32(ResultSet reader, int colidx) {
		try {
			int val = reader.getInt( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( new Integer( val ) );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMySqlSchema.class,
				"getNullableInt32",
				e );
		}
	}

	public static Short getNullableInt16(ResultSet reader, int colidx) {
		try {
			short val = reader.getShort( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( new Short( val ) );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMySqlSchema.class,
				"getNullableInt64",
				e );
		}
	}

	public static Integer getNullableUInt16(ResultSet reader, int colidx) {
		try {
			int val = reader.getInt( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( new Integer( val ) );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMySqlSchema.class,
				"getNullableUInt16",
				e );
		}
	}

	public static Long getNullableUInt32(ResultSet reader, int colidx) {
		try {
			long val = reader.getLong( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( new Long( val ) );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMySqlSchema.class,
				"getNullableUInt32",
				e );
		}
	}

	public static BigDecimal getNullableUInt64(ResultSet reader, int colidx) {
		try {
			String strval = reader.getString( colidx );
			if( reader.wasNull() || ( strval == null ) || ( strval.length() <=0 ) ) {
				return(null);
			}
			else {
				BigDecimal retval = new BigDecimal( strval );
				return( retval );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMySqlSchema.class,
				"getNullableUInt64",
				e );
		}
	}

	public static Byte getNullableByte(ResultSet reader, int colidx) {
		try {
			byte val = reader.getByte( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( new Byte( val ) );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMySqlSchema.class,
				"getNullableByte",
				e );
		}
	}

	public static String getQuotedDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTZDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTZTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTZTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getUuidString(UUID val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			return( "'" + val.toString() + "'" );
		}
	}

	public static Calendar convertDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 10 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertDateString",
            	"Value must be in YYYY-MM-DD format, \"" + val + "\" is invalid" );
        }
        else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
             && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
             && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
             && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
             && (val.charAt( 4 ) == '-')
             && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
             && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
             && (val.charAt( 7 ) == '-' )
             && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
             && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
            int year = Integer.parseInt( val.substring( 0, 4 ) );
            int month = Integer.parseInt( val.substring( 5, 7 ) );
            int day = Integer.parseInt( val.substring( 8, 10 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, 0 );
			retval.set( Calendar.MINUTE, 0 );
			retval.set( Calendar.SECOND, 0 );
			Calendar local = new GregorianCalendar();
			local.setTimeInMillis( retval.getTimeInMillis() );
			return( local );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertDateString",
            	"Value must be in YYYY-MM-DD format, \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 8 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertTimeString",
            	"Value must be in HH24:MI:SS format, \"" + val + "\" is invalid" );
        }
        else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '2'))
             && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
             && (val.charAt( 2 ) == ':')
             && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '5'))
             && ((val.charAt( 4 ) >= '0') && (val.charAt( 4 ) <= '9'))
             && (val.charAt( 5 ) == ':')
             && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '5'))
             && ((val.charAt( 7 ) >= '0') && (val.charAt( 7 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int hour = Integer.parseInt( val.substring( 0, 2 ) );
			int minute = Integer.parseInt( val.substring( 3, 5 ) );
			int second = Integer.parseInt( val.substring( 6, 8 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, 2000 );
			retval.set( Calendar.MONTH, 0 );
			retval.set( Calendar.DAY_OF_MONTH, 1 );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar local = new GregorianCalendar();
			local.setTimeInMillis( retval.getTimeInMillis() );
			return( local );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertTimeString",
            	"Value must be in HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertTimestampString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
        else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
             && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
             && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
             && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
             && (val.charAt( 4 ) == '-')
             && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
             && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
             && (val.charAt( 7 ) == '-' )
             && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
             && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == ' ' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == ':' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == ':' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
            int year = Integer.parseInt( val.substring( 0, 4 ) );
            int month = Integer.parseInt( val.substring( 5, 7 ) );
            int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar local = new GregorianCalendar();
			local.setTimeInMillis( retval.getTimeInMillis() );
			return( local );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertTimestampString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertTZDateString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
        else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
             && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
             && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
             && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
             && (val.charAt( 4 ) == '-')
             && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
             && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
             && (val.charAt( 7 ) == '-' )
             && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
             && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == ' ' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == ':' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == ':' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
            int year = Integer.parseInt( val.substring( 0, 4 ) );
            int month = Integer.parseInt( val.substring( 5, 7 ) );
            int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar utc = CFLibDbUtil.getUTCCalendar( retval );
			return( utc );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertTZDateString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertTZTimeString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
        else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
             && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
             && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
             && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
             && (val.charAt( 4 ) == '-')
             && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
             && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
             && (val.charAt( 7 ) == '-' )
             && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
             && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == ' ' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == ':' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == ':' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
            int year = Integer.parseInt( val.substring( 0, 4 ) );
            int month = Integer.parseInt( val.substring( 5, 7 ) );
            int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar utc = CFLibDbUtil.getUTCCalendar( retval );
			return( utc );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertTZTimeString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertTZTimestampString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
        else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
             && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
             && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
             && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
             && (val.charAt( 4 ) == '-')
             && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
             && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
             && (val.charAt( 7 ) == '-' )
             && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
             && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == ' ' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == ':' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == ':' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
            int year = Integer.parseInt( val.substring( 0, 4 ) );
            int month = Integer.parseInt( val.substring( 5, 7 ) );
            int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar utc = CFLibDbUtil.getUTCCalendar( retval );
			return( utc );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMySqlSchema.class,
				"convertTZTimestampString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static UUID convertUuidString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else {
			return( UUID.fromString( val ) );
        }
	}
}
