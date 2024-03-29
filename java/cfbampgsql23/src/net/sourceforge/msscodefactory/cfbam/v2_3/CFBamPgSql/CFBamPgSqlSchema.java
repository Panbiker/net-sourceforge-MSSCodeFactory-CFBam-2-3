// Description: Java 7 PostgreSQL Jdbc DbIO implementation for CFBam.

/*
 *	CFBam
 *
 *	Copyright (c) 2014 2014-2015 Mark Sobkow
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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamPgSql;

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

public class CFBamPgSqlSchema
	extends CFBamSchema
{
	protected Connection cnx;
	protected boolean inTransaction;
	protected PreparedStatement stmtSelectIsSystemUser = null;
	protected PreparedStatement stmtSelectIsClusterUser = null;
	protected PreparedStatement stmtSelectIsTenantUser = null;
	protected PreparedStatement stmtSelectNextServiceTypeIdGen = null;
	protected PreparedStatement stmtSelectNextMimeTypeIdGen = null;
	protected PreparedStatement stmtSelectNextClusterIdGen = null;
	protected PreparedStatement stmtSelectNextTenantIdGen = null;

	public CFBamPgSqlSchema() {
		super();
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamPgSqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamPgSqlAccessSecurityTable( this );
		tableAtom = new CFBamPgSqlAtomTable( this );
		tableAuditAction = new CFBamPgSqlAuditActionTable( this );
		tableBlobCol = new CFBamPgSqlBlobColTable( this );
		tableBlobDef = new CFBamPgSqlBlobDefTable( this );
		tableBlobType = new CFBamPgSqlBlobTypeTable( this );
		tableBoolCol = new CFBamPgSqlBoolColTable( this );
		tableBoolDef = new CFBamPgSqlBoolDefTable( this );
		tableBoolType = new CFBamPgSqlBoolTypeTable( this );
		tableChain = new CFBamPgSqlChainTable( this );
		tableClearDep = new CFBamPgSqlClearDepTable( this );
		tableClearSubDep1 = new CFBamPgSqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamPgSqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamPgSqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamPgSqlClearTopDepTable( this );
		tableCluster = new CFBamPgSqlClusterTable( this );
		tableDataScope = new CFBamPgSqlDataScopeTable( this );
		tableDateCol = new CFBamPgSqlDateColTable( this );
		tableDateDef = new CFBamPgSqlDateDefTable( this );
		tableDateType = new CFBamPgSqlDateTypeTable( this );
		tableDelDep = new CFBamPgSqlDelDepTable( this );
		tableDelSubDep1 = new CFBamPgSqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamPgSqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamPgSqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamPgSqlDelTopDepTable( this );
		tableDomain = new CFBamPgSqlDomainTable( this );
		tableDomainBase = new CFBamPgSqlDomainBaseTable( this );
		tableDoubleCol = new CFBamPgSqlDoubleColTable( this );
		tableDoubleDef = new CFBamPgSqlDoubleDefTable( this );
		tableDoubleType = new CFBamPgSqlDoubleTypeTable( this );
		tableEnumCol = new CFBamPgSqlEnumColTable( this );
		tableEnumDef = new CFBamPgSqlEnumDefTable( this );
		tableEnumTag = new CFBamPgSqlEnumTagTable( this );
		tableEnumType = new CFBamPgSqlEnumTypeTable( this );
		tableFloatCol = new CFBamPgSqlFloatColTable( this );
		tableFloatDef = new CFBamPgSqlFloatDefTable( this );
		tableFloatType = new CFBamPgSqlFloatTypeTable( this );
		tableHostNode = new CFBamPgSqlHostNodeTable( this );
		tableISOCountry = new CFBamPgSqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamPgSqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamPgSqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamPgSqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamPgSqlISOLanguageTable( this );
		tableISOTimezone = new CFBamPgSqlISOTimezoneTable( this );
		tableId16Gen = new CFBamPgSqlId16GenTable( this );
		tableId32Gen = new CFBamPgSqlId32GenTable( this );
		tableId64Gen = new CFBamPgSqlId64GenTable( this );
		tableIndex = new CFBamPgSqlIndexTable( this );
		tableIndexCol = new CFBamPgSqlIndexColTable( this );
		tableInt16Col = new CFBamPgSqlInt16ColTable( this );
		tableInt16Def = new CFBamPgSqlInt16DefTable( this );
		tableInt16Type = new CFBamPgSqlInt16TypeTable( this );
		tableInt32Col = new CFBamPgSqlInt32ColTable( this );
		tableInt32Def = new CFBamPgSqlInt32DefTable( this );
		tableInt32Type = new CFBamPgSqlInt32TypeTable( this );
		tableInt64Col = new CFBamPgSqlInt64ColTable( this );
		tableInt64Def = new CFBamPgSqlInt64DefTable( this );
		tableInt64Type = new CFBamPgSqlInt64TypeTable( this );
		tableLicense = new CFBamPgSqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamPgSqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamPgSqlMajorVersionTable( this );
		tableMimeType = new CFBamPgSqlMimeTypeTable( this );
		tableMinorVersion = new CFBamPgSqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamPgSqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamPgSqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamPgSqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamPgSqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamPgSqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamPgSqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamPgSqlNumberColTable( this );
		tableNumberDef = new CFBamPgSqlNumberDefTable( this );
		tableNumberType = new CFBamPgSqlNumberTypeTable( this );
		tableParam = new CFBamPgSqlParamTable( this );
		tablePopDep = new CFBamPgSqlPopDepTable( this );
		tablePopSubDep1 = new CFBamPgSqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamPgSqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamPgSqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamPgSqlPopTopDepTable( this );
		tableProjectBase = new CFBamPgSqlProjectBaseTable( this );
		tableRealProject = new CFBamPgSqlRealProjectTable( this );
		tableRelation = new CFBamPgSqlRelationTable( this );
		tableRelationCol = new CFBamPgSqlRelationColTable( this );
		tableRelationType = new CFBamPgSqlRelationTypeTable( this );
		tableSchemaDef = new CFBamPgSqlSchemaDefTable( this );
		tableSchemaRef = new CFBamPgSqlSchemaRefTable( this );
		tableScope = new CFBamPgSqlScopeTable( this );
		tableSecApp = new CFBamPgSqlSecAppTable( this );
		tableSecDevice = new CFBamPgSqlSecDeviceTable( this );
		tableSecForm = new CFBamPgSqlSecFormTable( this );
		tableSecGroup = new CFBamPgSqlSecGroupTable( this );
		tableSecGroupForm = new CFBamPgSqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamPgSqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamPgSqlSecGroupMemberTable( this );
		tableSecSession = new CFBamPgSqlSecSessionTable( this );
		tableSecUser = new CFBamPgSqlSecUserTable( this );
		tableSecurityScope = new CFBamPgSqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamPgSqlServerListFuncTable( this );
		tableServerMethod = new CFBamPgSqlServerMethodTable( this );
		tableServerObjFunc = new CFBamPgSqlServerObjFuncTable( this );
		tableServerProc = new CFBamPgSqlServerProcTable( this );
		tableService = new CFBamPgSqlServiceTable( this );
		tableServiceType = new CFBamPgSqlServiceTypeTable( this );
		tableStringCol = new CFBamPgSqlStringColTable( this );
		tableStringDef = new CFBamPgSqlStringDefTable( this );
		tableStringType = new CFBamPgSqlStringTypeTable( this );
		tableSubProject = new CFBamPgSqlSubProjectTable( this );
		tableSysCluster = new CFBamPgSqlSysClusterTable( this );
		tableTSecGroup = new CFBamPgSqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamPgSqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamPgSqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamPgSqlTZDateColTable( this );
		tableTZDateDef = new CFBamPgSqlTZDateDefTable( this );
		tableTZDateType = new CFBamPgSqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamPgSqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamPgSqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamPgSqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamPgSqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamPgSqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamPgSqlTZTimestampTypeTable( this );
		tableTable = new CFBamPgSqlTableTable( this );
		tableTableCol = new CFBamPgSqlTableColTable( this );
		tableTenant = new CFBamPgSqlTenantTable( this );
		tableTextCol = new CFBamPgSqlTextColTable( this );
		tableTextDef = new CFBamPgSqlTextDefTable( this );
		tableTextType = new CFBamPgSqlTextTypeTable( this );
		tableTimeCol = new CFBamPgSqlTimeColTable( this );
		tableTimeDef = new CFBamPgSqlTimeDefTable( this );
		tableTimeType = new CFBamPgSqlTimeTypeTable( this );
		tableTimestampCol = new CFBamPgSqlTimestampColTable( this );
		tableTimestampDef = new CFBamPgSqlTimestampDefTable( this );
		tableTimestampType = new CFBamPgSqlTimestampTypeTable( this );
		tableTld = new CFBamPgSqlTldTable( this );
		tableTokenCol = new CFBamPgSqlTokenColTable( this );
		tableTokenDef = new CFBamPgSqlTokenDefTable( this );
		tableTokenType = new CFBamPgSqlTokenTypeTable( this );
		tableTopDomain = new CFBamPgSqlTopDomainTable( this );
		tableTopProject = new CFBamPgSqlTopProjectTable( this );
		tableUInt16Col = new CFBamPgSqlUInt16ColTable( this );
		tableUInt16Def = new CFBamPgSqlUInt16DefTable( this );
		tableUInt16Type = new CFBamPgSqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamPgSqlUInt32ColTable( this );
		tableUInt32Def = new CFBamPgSqlUInt32DefTable( this );
		tableUInt32Type = new CFBamPgSqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamPgSqlUInt64ColTable( this );
		tableUInt64Def = new CFBamPgSqlUInt64DefTable( this );
		tableUInt64Type = new CFBamPgSqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamPgSqlURLProtocolTable( this );
		tableUuidCol = new CFBamPgSqlUuidColTable( this );
		tableUuidDef = new CFBamPgSqlUuidDefTable( this );
		tableUuidGen = new CFBamPgSqlUuidGenTable( this );
		tableUuidType = new CFBamPgSqlUuidTypeTable( this );
		tableValue = new CFBamPgSqlValueTable( this );
		tableVersion = new CFBamPgSqlVersionTable( this );
	}

	public CFBamPgSqlSchema( CFBamConfigurationFile conf ) {
		super( conf );
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamPgSqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamPgSqlAccessSecurityTable( this );
		tableAtom = new CFBamPgSqlAtomTable( this );
		tableAuditAction = new CFBamPgSqlAuditActionTable( this );
		tableBlobCol = new CFBamPgSqlBlobColTable( this );
		tableBlobDef = new CFBamPgSqlBlobDefTable( this );
		tableBlobType = new CFBamPgSqlBlobTypeTable( this );
		tableBoolCol = new CFBamPgSqlBoolColTable( this );
		tableBoolDef = new CFBamPgSqlBoolDefTable( this );
		tableBoolType = new CFBamPgSqlBoolTypeTable( this );
		tableChain = new CFBamPgSqlChainTable( this );
		tableClearDep = new CFBamPgSqlClearDepTable( this );
		tableClearSubDep1 = new CFBamPgSqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamPgSqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamPgSqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamPgSqlClearTopDepTable( this );
		tableCluster = new CFBamPgSqlClusterTable( this );
		tableDataScope = new CFBamPgSqlDataScopeTable( this );
		tableDateCol = new CFBamPgSqlDateColTable( this );
		tableDateDef = new CFBamPgSqlDateDefTable( this );
		tableDateType = new CFBamPgSqlDateTypeTable( this );
		tableDelDep = new CFBamPgSqlDelDepTable( this );
		tableDelSubDep1 = new CFBamPgSqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamPgSqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamPgSqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamPgSqlDelTopDepTable( this );
		tableDomain = new CFBamPgSqlDomainTable( this );
		tableDomainBase = new CFBamPgSqlDomainBaseTable( this );
		tableDoubleCol = new CFBamPgSqlDoubleColTable( this );
		tableDoubleDef = new CFBamPgSqlDoubleDefTable( this );
		tableDoubleType = new CFBamPgSqlDoubleTypeTable( this );
		tableEnumCol = new CFBamPgSqlEnumColTable( this );
		tableEnumDef = new CFBamPgSqlEnumDefTable( this );
		tableEnumTag = new CFBamPgSqlEnumTagTable( this );
		tableEnumType = new CFBamPgSqlEnumTypeTable( this );
		tableFloatCol = new CFBamPgSqlFloatColTable( this );
		tableFloatDef = new CFBamPgSqlFloatDefTable( this );
		tableFloatType = new CFBamPgSqlFloatTypeTable( this );
		tableHostNode = new CFBamPgSqlHostNodeTable( this );
		tableISOCountry = new CFBamPgSqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamPgSqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamPgSqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamPgSqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamPgSqlISOLanguageTable( this );
		tableISOTimezone = new CFBamPgSqlISOTimezoneTable( this );
		tableId16Gen = new CFBamPgSqlId16GenTable( this );
		tableId32Gen = new CFBamPgSqlId32GenTable( this );
		tableId64Gen = new CFBamPgSqlId64GenTable( this );
		tableIndex = new CFBamPgSqlIndexTable( this );
		tableIndexCol = new CFBamPgSqlIndexColTable( this );
		tableInt16Col = new CFBamPgSqlInt16ColTable( this );
		tableInt16Def = new CFBamPgSqlInt16DefTable( this );
		tableInt16Type = new CFBamPgSqlInt16TypeTable( this );
		tableInt32Col = new CFBamPgSqlInt32ColTable( this );
		tableInt32Def = new CFBamPgSqlInt32DefTable( this );
		tableInt32Type = new CFBamPgSqlInt32TypeTable( this );
		tableInt64Col = new CFBamPgSqlInt64ColTable( this );
		tableInt64Def = new CFBamPgSqlInt64DefTable( this );
		tableInt64Type = new CFBamPgSqlInt64TypeTable( this );
		tableLicense = new CFBamPgSqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamPgSqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamPgSqlMajorVersionTable( this );
		tableMimeType = new CFBamPgSqlMimeTypeTable( this );
		tableMinorVersion = new CFBamPgSqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamPgSqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamPgSqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamPgSqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamPgSqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamPgSqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamPgSqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamPgSqlNumberColTable( this );
		tableNumberDef = new CFBamPgSqlNumberDefTable( this );
		tableNumberType = new CFBamPgSqlNumberTypeTable( this );
		tableParam = new CFBamPgSqlParamTable( this );
		tablePopDep = new CFBamPgSqlPopDepTable( this );
		tablePopSubDep1 = new CFBamPgSqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamPgSqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamPgSqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamPgSqlPopTopDepTable( this );
		tableProjectBase = new CFBamPgSqlProjectBaseTable( this );
		tableRealProject = new CFBamPgSqlRealProjectTable( this );
		tableRelation = new CFBamPgSqlRelationTable( this );
		tableRelationCol = new CFBamPgSqlRelationColTable( this );
		tableRelationType = new CFBamPgSqlRelationTypeTable( this );
		tableSchemaDef = new CFBamPgSqlSchemaDefTable( this );
		tableSchemaRef = new CFBamPgSqlSchemaRefTable( this );
		tableScope = new CFBamPgSqlScopeTable( this );
		tableSecApp = new CFBamPgSqlSecAppTable( this );
		tableSecDevice = new CFBamPgSqlSecDeviceTable( this );
		tableSecForm = new CFBamPgSqlSecFormTable( this );
		tableSecGroup = new CFBamPgSqlSecGroupTable( this );
		tableSecGroupForm = new CFBamPgSqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamPgSqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamPgSqlSecGroupMemberTable( this );
		tableSecSession = new CFBamPgSqlSecSessionTable( this );
		tableSecUser = new CFBamPgSqlSecUserTable( this );
		tableSecurityScope = new CFBamPgSqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamPgSqlServerListFuncTable( this );
		tableServerMethod = new CFBamPgSqlServerMethodTable( this );
		tableServerObjFunc = new CFBamPgSqlServerObjFuncTable( this );
		tableServerProc = new CFBamPgSqlServerProcTable( this );
		tableService = new CFBamPgSqlServiceTable( this );
		tableServiceType = new CFBamPgSqlServiceTypeTable( this );
		tableStringCol = new CFBamPgSqlStringColTable( this );
		tableStringDef = new CFBamPgSqlStringDefTable( this );
		tableStringType = new CFBamPgSqlStringTypeTable( this );
		tableSubProject = new CFBamPgSqlSubProjectTable( this );
		tableSysCluster = new CFBamPgSqlSysClusterTable( this );
		tableTSecGroup = new CFBamPgSqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamPgSqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamPgSqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamPgSqlTZDateColTable( this );
		tableTZDateDef = new CFBamPgSqlTZDateDefTable( this );
		tableTZDateType = new CFBamPgSqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamPgSqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamPgSqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamPgSqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamPgSqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamPgSqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamPgSqlTZTimestampTypeTable( this );
		tableTable = new CFBamPgSqlTableTable( this );
		tableTableCol = new CFBamPgSqlTableColTable( this );
		tableTenant = new CFBamPgSqlTenantTable( this );
		tableTextCol = new CFBamPgSqlTextColTable( this );
		tableTextDef = new CFBamPgSqlTextDefTable( this );
		tableTextType = new CFBamPgSqlTextTypeTable( this );
		tableTimeCol = new CFBamPgSqlTimeColTable( this );
		tableTimeDef = new CFBamPgSqlTimeDefTable( this );
		tableTimeType = new CFBamPgSqlTimeTypeTable( this );
		tableTimestampCol = new CFBamPgSqlTimestampColTable( this );
		tableTimestampDef = new CFBamPgSqlTimestampDefTable( this );
		tableTimestampType = new CFBamPgSqlTimestampTypeTable( this );
		tableTld = new CFBamPgSqlTldTable( this );
		tableTokenCol = new CFBamPgSqlTokenColTable( this );
		tableTokenDef = new CFBamPgSqlTokenDefTable( this );
		tableTokenType = new CFBamPgSqlTokenTypeTable( this );
		tableTopDomain = new CFBamPgSqlTopDomainTable( this );
		tableTopProject = new CFBamPgSqlTopProjectTable( this );
		tableUInt16Col = new CFBamPgSqlUInt16ColTable( this );
		tableUInt16Def = new CFBamPgSqlUInt16DefTable( this );
		tableUInt16Type = new CFBamPgSqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamPgSqlUInt32ColTable( this );
		tableUInt32Def = new CFBamPgSqlUInt32DefTable( this );
		tableUInt32Type = new CFBamPgSqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamPgSqlUInt64ColTable( this );
		tableUInt64Def = new CFBamPgSqlUInt64DefTable( this );
		tableUInt64Type = new CFBamPgSqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamPgSqlURLProtocolTable( this );
		tableUuidCol = new CFBamPgSqlUuidColTable( this );
		tableUuidDef = new CFBamPgSqlUuidDefTable( this );
		tableUuidGen = new CFBamPgSqlUuidGenTable( this );
		tableUuidType = new CFBamPgSqlUuidTypeTable( this );
		tableValue = new CFBamPgSqlValueTable( this );
		tableVersion = new CFBamPgSqlVersionTable( this );
		setDbSchemaName( conf.getDbDatabase() );
	}

	public CFBamPgSqlSchema( String argJndiName ) {
		super( argJndiName );
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamPgSqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamPgSqlAccessSecurityTable( this );
		tableAtom = new CFBamPgSqlAtomTable( this );
		tableAuditAction = new CFBamPgSqlAuditActionTable( this );
		tableBlobCol = new CFBamPgSqlBlobColTable( this );
		tableBlobDef = new CFBamPgSqlBlobDefTable( this );
		tableBlobType = new CFBamPgSqlBlobTypeTable( this );
		tableBoolCol = new CFBamPgSqlBoolColTable( this );
		tableBoolDef = new CFBamPgSqlBoolDefTable( this );
		tableBoolType = new CFBamPgSqlBoolTypeTable( this );
		tableChain = new CFBamPgSqlChainTable( this );
		tableClearDep = new CFBamPgSqlClearDepTable( this );
		tableClearSubDep1 = new CFBamPgSqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamPgSqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamPgSqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamPgSqlClearTopDepTable( this );
		tableCluster = new CFBamPgSqlClusterTable( this );
		tableDataScope = new CFBamPgSqlDataScopeTable( this );
		tableDateCol = new CFBamPgSqlDateColTable( this );
		tableDateDef = new CFBamPgSqlDateDefTable( this );
		tableDateType = new CFBamPgSqlDateTypeTable( this );
		tableDelDep = new CFBamPgSqlDelDepTable( this );
		tableDelSubDep1 = new CFBamPgSqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamPgSqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamPgSqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamPgSqlDelTopDepTable( this );
		tableDomain = new CFBamPgSqlDomainTable( this );
		tableDomainBase = new CFBamPgSqlDomainBaseTable( this );
		tableDoubleCol = new CFBamPgSqlDoubleColTable( this );
		tableDoubleDef = new CFBamPgSqlDoubleDefTable( this );
		tableDoubleType = new CFBamPgSqlDoubleTypeTable( this );
		tableEnumCol = new CFBamPgSqlEnumColTable( this );
		tableEnumDef = new CFBamPgSqlEnumDefTable( this );
		tableEnumTag = new CFBamPgSqlEnumTagTable( this );
		tableEnumType = new CFBamPgSqlEnumTypeTable( this );
		tableFloatCol = new CFBamPgSqlFloatColTable( this );
		tableFloatDef = new CFBamPgSqlFloatDefTable( this );
		tableFloatType = new CFBamPgSqlFloatTypeTable( this );
		tableHostNode = new CFBamPgSqlHostNodeTable( this );
		tableISOCountry = new CFBamPgSqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamPgSqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamPgSqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamPgSqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamPgSqlISOLanguageTable( this );
		tableISOTimezone = new CFBamPgSqlISOTimezoneTable( this );
		tableId16Gen = new CFBamPgSqlId16GenTable( this );
		tableId32Gen = new CFBamPgSqlId32GenTable( this );
		tableId64Gen = new CFBamPgSqlId64GenTable( this );
		tableIndex = new CFBamPgSqlIndexTable( this );
		tableIndexCol = new CFBamPgSqlIndexColTable( this );
		tableInt16Col = new CFBamPgSqlInt16ColTable( this );
		tableInt16Def = new CFBamPgSqlInt16DefTable( this );
		tableInt16Type = new CFBamPgSqlInt16TypeTable( this );
		tableInt32Col = new CFBamPgSqlInt32ColTable( this );
		tableInt32Def = new CFBamPgSqlInt32DefTable( this );
		tableInt32Type = new CFBamPgSqlInt32TypeTable( this );
		tableInt64Col = new CFBamPgSqlInt64ColTable( this );
		tableInt64Def = new CFBamPgSqlInt64DefTable( this );
		tableInt64Type = new CFBamPgSqlInt64TypeTable( this );
		tableLicense = new CFBamPgSqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamPgSqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamPgSqlMajorVersionTable( this );
		tableMimeType = new CFBamPgSqlMimeTypeTable( this );
		tableMinorVersion = new CFBamPgSqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamPgSqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamPgSqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamPgSqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamPgSqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamPgSqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamPgSqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamPgSqlNumberColTable( this );
		tableNumberDef = new CFBamPgSqlNumberDefTable( this );
		tableNumberType = new CFBamPgSqlNumberTypeTable( this );
		tableParam = new CFBamPgSqlParamTable( this );
		tablePopDep = new CFBamPgSqlPopDepTable( this );
		tablePopSubDep1 = new CFBamPgSqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamPgSqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamPgSqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamPgSqlPopTopDepTable( this );
		tableProjectBase = new CFBamPgSqlProjectBaseTable( this );
		tableRealProject = new CFBamPgSqlRealProjectTable( this );
		tableRelation = new CFBamPgSqlRelationTable( this );
		tableRelationCol = new CFBamPgSqlRelationColTable( this );
		tableRelationType = new CFBamPgSqlRelationTypeTable( this );
		tableSchemaDef = new CFBamPgSqlSchemaDefTable( this );
		tableSchemaRef = new CFBamPgSqlSchemaRefTable( this );
		tableScope = new CFBamPgSqlScopeTable( this );
		tableSecApp = new CFBamPgSqlSecAppTable( this );
		tableSecDevice = new CFBamPgSqlSecDeviceTable( this );
		tableSecForm = new CFBamPgSqlSecFormTable( this );
		tableSecGroup = new CFBamPgSqlSecGroupTable( this );
		tableSecGroupForm = new CFBamPgSqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamPgSqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamPgSqlSecGroupMemberTable( this );
		tableSecSession = new CFBamPgSqlSecSessionTable( this );
		tableSecUser = new CFBamPgSqlSecUserTable( this );
		tableSecurityScope = new CFBamPgSqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamPgSqlServerListFuncTable( this );
		tableServerMethod = new CFBamPgSqlServerMethodTable( this );
		tableServerObjFunc = new CFBamPgSqlServerObjFuncTable( this );
		tableServerProc = new CFBamPgSqlServerProcTable( this );
		tableService = new CFBamPgSqlServiceTable( this );
		tableServiceType = new CFBamPgSqlServiceTypeTable( this );
		tableStringCol = new CFBamPgSqlStringColTable( this );
		tableStringDef = new CFBamPgSqlStringDefTable( this );
		tableStringType = new CFBamPgSqlStringTypeTable( this );
		tableSubProject = new CFBamPgSqlSubProjectTable( this );
		tableSysCluster = new CFBamPgSqlSysClusterTable( this );
		tableTSecGroup = new CFBamPgSqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamPgSqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamPgSqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamPgSqlTZDateColTable( this );
		tableTZDateDef = new CFBamPgSqlTZDateDefTable( this );
		tableTZDateType = new CFBamPgSqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamPgSqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamPgSqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamPgSqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamPgSqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamPgSqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamPgSqlTZTimestampTypeTable( this );
		tableTable = new CFBamPgSqlTableTable( this );
		tableTableCol = new CFBamPgSqlTableColTable( this );
		tableTenant = new CFBamPgSqlTenantTable( this );
		tableTextCol = new CFBamPgSqlTextColTable( this );
		tableTextDef = new CFBamPgSqlTextDefTable( this );
		tableTextType = new CFBamPgSqlTextTypeTable( this );
		tableTimeCol = new CFBamPgSqlTimeColTable( this );
		tableTimeDef = new CFBamPgSqlTimeDefTable( this );
		tableTimeType = new CFBamPgSqlTimeTypeTable( this );
		tableTimestampCol = new CFBamPgSqlTimestampColTable( this );
		tableTimestampDef = new CFBamPgSqlTimestampDefTable( this );
		tableTimestampType = new CFBamPgSqlTimestampTypeTable( this );
		tableTld = new CFBamPgSqlTldTable( this );
		tableTokenCol = new CFBamPgSqlTokenColTable( this );
		tableTokenDef = new CFBamPgSqlTokenDefTable( this );
		tableTokenType = new CFBamPgSqlTokenTypeTable( this );
		tableTopDomain = new CFBamPgSqlTopDomainTable( this );
		tableTopProject = new CFBamPgSqlTopProjectTable( this );
		tableUInt16Col = new CFBamPgSqlUInt16ColTable( this );
		tableUInt16Def = new CFBamPgSqlUInt16DefTable( this );
		tableUInt16Type = new CFBamPgSqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamPgSqlUInt32ColTable( this );
		tableUInt32Def = new CFBamPgSqlUInt32DefTable( this );
		tableUInt32Type = new CFBamPgSqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamPgSqlUInt64ColTable( this );
		tableUInt64Def = new CFBamPgSqlUInt64DefTable( this );
		tableUInt64Type = new CFBamPgSqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamPgSqlURLProtocolTable( this );
		tableUuidCol = new CFBamPgSqlUuidColTable( this );
		tableUuidDef = new CFBamPgSqlUuidDefTable( this );
		tableUuidGen = new CFBamPgSqlUuidGenTable( this );
		tableUuidType = new CFBamPgSqlUuidTypeTable( this );
		tableValue = new CFBamPgSqlValueTable( this );
		tableVersion = new CFBamPgSqlVersionTable( this );
	}

	public CFBamPgSqlSchema( Connection argCnx ) {
		super();
		cnx = argCnx;
		inTransaction = false;
		tableAccessFrequency = new CFBamPgSqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamPgSqlAccessSecurityTable( this );
		tableAtom = new CFBamPgSqlAtomTable( this );
		tableAuditAction = new CFBamPgSqlAuditActionTable( this );
		tableBlobCol = new CFBamPgSqlBlobColTable( this );
		tableBlobDef = new CFBamPgSqlBlobDefTable( this );
		tableBlobType = new CFBamPgSqlBlobTypeTable( this );
		tableBoolCol = new CFBamPgSqlBoolColTable( this );
		tableBoolDef = new CFBamPgSqlBoolDefTable( this );
		tableBoolType = new CFBamPgSqlBoolTypeTable( this );
		tableChain = new CFBamPgSqlChainTable( this );
		tableClearDep = new CFBamPgSqlClearDepTable( this );
		tableClearSubDep1 = new CFBamPgSqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamPgSqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamPgSqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamPgSqlClearTopDepTable( this );
		tableCluster = new CFBamPgSqlClusterTable( this );
		tableDataScope = new CFBamPgSqlDataScopeTable( this );
		tableDateCol = new CFBamPgSqlDateColTable( this );
		tableDateDef = new CFBamPgSqlDateDefTable( this );
		tableDateType = new CFBamPgSqlDateTypeTable( this );
		tableDelDep = new CFBamPgSqlDelDepTable( this );
		tableDelSubDep1 = new CFBamPgSqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamPgSqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamPgSqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamPgSqlDelTopDepTable( this );
		tableDomain = new CFBamPgSqlDomainTable( this );
		tableDomainBase = new CFBamPgSqlDomainBaseTable( this );
		tableDoubleCol = new CFBamPgSqlDoubleColTable( this );
		tableDoubleDef = new CFBamPgSqlDoubleDefTable( this );
		tableDoubleType = new CFBamPgSqlDoubleTypeTable( this );
		tableEnumCol = new CFBamPgSqlEnumColTable( this );
		tableEnumDef = new CFBamPgSqlEnumDefTable( this );
		tableEnumTag = new CFBamPgSqlEnumTagTable( this );
		tableEnumType = new CFBamPgSqlEnumTypeTable( this );
		tableFloatCol = new CFBamPgSqlFloatColTable( this );
		tableFloatDef = new CFBamPgSqlFloatDefTable( this );
		tableFloatType = new CFBamPgSqlFloatTypeTable( this );
		tableHostNode = new CFBamPgSqlHostNodeTable( this );
		tableISOCountry = new CFBamPgSqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamPgSqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamPgSqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamPgSqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamPgSqlISOLanguageTable( this );
		tableISOTimezone = new CFBamPgSqlISOTimezoneTable( this );
		tableId16Gen = new CFBamPgSqlId16GenTable( this );
		tableId32Gen = new CFBamPgSqlId32GenTable( this );
		tableId64Gen = new CFBamPgSqlId64GenTable( this );
		tableIndex = new CFBamPgSqlIndexTable( this );
		tableIndexCol = new CFBamPgSqlIndexColTable( this );
		tableInt16Col = new CFBamPgSqlInt16ColTable( this );
		tableInt16Def = new CFBamPgSqlInt16DefTable( this );
		tableInt16Type = new CFBamPgSqlInt16TypeTable( this );
		tableInt32Col = new CFBamPgSqlInt32ColTable( this );
		tableInt32Def = new CFBamPgSqlInt32DefTable( this );
		tableInt32Type = new CFBamPgSqlInt32TypeTable( this );
		tableInt64Col = new CFBamPgSqlInt64ColTable( this );
		tableInt64Def = new CFBamPgSqlInt64DefTable( this );
		tableInt64Type = new CFBamPgSqlInt64TypeTable( this );
		tableLicense = new CFBamPgSqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamPgSqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamPgSqlMajorVersionTable( this );
		tableMimeType = new CFBamPgSqlMimeTypeTable( this );
		tableMinorVersion = new CFBamPgSqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamPgSqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamPgSqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamPgSqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamPgSqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamPgSqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamPgSqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamPgSqlNumberColTable( this );
		tableNumberDef = new CFBamPgSqlNumberDefTable( this );
		tableNumberType = new CFBamPgSqlNumberTypeTable( this );
		tableParam = new CFBamPgSqlParamTable( this );
		tablePopDep = new CFBamPgSqlPopDepTable( this );
		tablePopSubDep1 = new CFBamPgSqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamPgSqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamPgSqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamPgSqlPopTopDepTable( this );
		tableProjectBase = new CFBamPgSqlProjectBaseTable( this );
		tableRealProject = new CFBamPgSqlRealProjectTable( this );
		tableRelation = new CFBamPgSqlRelationTable( this );
		tableRelationCol = new CFBamPgSqlRelationColTable( this );
		tableRelationType = new CFBamPgSqlRelationTypeTable( this );
		tableSchemaDef = new CFBamPgSqlSchemaDefTable( this );
		tableSchemaRef = new CFBamPgSqlSchemaRefTable( this );
		tableScope = new CFBamPgSqlScopeTable( this );
		tableSecApp = new CFBamPgSqlSecAppTable( this );
		tableSecDevice = new CFBamPgSqlSecDeviceTable( this );
		tableSecForm = new CFBamPgSqlSecFormTable( this );
		tableSecGroup = new CFBamPgSqlSecGroupTable( this );
		tableSecGroupForm = new CFBamPgSqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamPgSqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamPgSqlSecGroupMemberTable( this );
		tableSecSession = new CFBamPgSqlSecSessionTable( this );
		tableSecUser = new CFBamPgSqlSecUserTable( this );
		tableSecurityScope = new CFBamPgSqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamPgSqlServerListFuncTable( this );
		tableServerMethod = new CFBamPgSqlServerMethodTable( this );
		tableServerObjFunc = new CFBamPgSqlServerObjFuncTable( this );
		tableServerProc = new CFBamPgSqlServerProcTable( this );
		tableService = new CFBamPgSqlServiceTable( this );
		tableServiceType = new CFBamPgSqlServiceTypeTable( this );
		tableStringCol = new CFBamPgSqlStringColTable( this );
		tableStringDef = new CFBamPgSqlStringDefTable( this );
		tableStringType = new CFBamPgSqlStringTypeTable( this );
		tableSubProject = new CFBamPgSqlSubProjectTable( this );
		tableSysCluster = new CFBamPgSqlSysClusterTable( this );
		tableTSecGroup = new CFBamPgSqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamPgSqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamPgSqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamPgSqlTZDateColTable( this );
		tableTZDateDef = new CFBamPgSqlTZDateDefTable( this );
		tableTZDateType = new CFBamPgSqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamPgSqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamPgSqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamPgSqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamPgSqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamPgSqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamPgSqlTZTimestampTypeTable( this );
		tableTable = new CFBamPgSqlTableTable( this );
		tableTableCol = new CFBamPgSqlTableColTable( this );
		tableTenant = new CFBamPgSqlTenantTable( this );
		tableTextCol = new CFBamPgSqlTextColTable( this );
		tableTextDef = new CFBamPgSqlTextDefTable( this );
		tableTextType = new CFBamPgSqlTextTypeTable( this );
		tableTimeCol = new CFBamPgSqlTimeColTable( this );
		tableTimeDef = new CFBamPgSqlTimeDefTable( this );
		tableTimeType = new CFBamPgSqlTimeTypeTable( this );
		tableTimestampCol = new CFBamPgSqlTimestampColTable( this );
		tableTimestampDef = new CFBamPgSqlTimestampDefTable( this );
		tableTimestampType = new CFBamPgSqlTimestampTypeTable( this );
		tableTld = new CFBamPgSqlTldTable( this );
		tableTokenCol = new CFBamPgSqlTokenColTable( this );
		tableTokenDef = new CFBamPgSqlTokenDefTable( this );
		tableTokenType = new CFBamPgSqlTokenTypeTable( this );
		tableTopDomain = new CFBamPgSqlTopDomainTable( this );
		tableTopProject = new CFBamPgSqlTopProjectTable( this );
		tableUInt16Col = new CFBamPgSqlUInt16ColTable( this );
		tableUInt16Def = new CFBamPgSqlUInt16DefTable( this );
		tableUInt16Type = new CFBamPgSqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamPgSqlUInt32ColTable( this );
		tableUInt32Def = new CFBamPgSqlUInt32DefTable( this );
		tableUInt32Type = new CFBamPgSqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamPgSqlUInt64ColTable( this );
		tableUInt64Def = new CFBamPgSqlUInt64DefTable( this );
		tableUInt64Type = new CFBamPgSqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamPgSqlURLProtocolTable( this );
		tableUuidCol = new CFBamPgSqlUuidColTable( this );
		tableUuidDef = new CFBamPgSqlUuidDefTable( this );
		tableUuidGen = new CFBamPgSqlUuidGenTable( this );
		tableUuidType = new CFBamPgSqlUuidTypeTable( this );
		tableValue = new CFBamPgSqlValueTable( this );
		tableVersion = new CFBamPgSqlVersionTable( this );
		try {
			cnx.setAutoCommit( false );
			cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
			cnx.rollback();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"CFBamPgSqlSchema-constructor",
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
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = configuration.getDbUserName();
			String dbPassword = configuration.getDbPassword();
			String url =
					"jdbc:postgresql://" + dbServer
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
		final String S_ProcName = "connect";
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
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = username;
			String dbPassword = password;
			String url =
					"jdbc:postgresql://" + dbServer
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
		try {
			String sql =
					"begin transaction";
			Statement stmt = cnx.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
			stmt.execute( sql );
			inTransaction = true;
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"beginTransaction",
				e );
		}
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
			String sql = "SELECT " + lowerDbSchemaName + ".sp_is_system_user( ? ) as IsSystemUser";
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
			String sql = "SELECT " + lowerDbSchemaName + ".sp_is_cluster_user( ?, ?, ? ) as IsClusterUser";
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
			String sql = "SELECT " + lowerDbSchemaName + ".sp_is_tenant_user( ?, ?, ? ) as IsTenantUser";
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

	public int nextServiceTypeIdGen() {
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"nextServiceTypeIdGen",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			String sql = "SELECT " + lowerDbSchemaName + ".sp_next_servicetypeidgen() as NextServiceTypeIdGen";
			if( stmtSelectNextServiceTypeIdGen == null ) {
				stmtSelectNextServiceTypeIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextServiceTypeIdGen.executeQuery();
			int nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"nextServiceTypeIdGen",
           			"Query of sp_next_servicetypeidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"nextServiceTypeIdGen",
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

	public int nextMimeTypeIdGen() {
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"nextMimeTypeIdGen",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			String sql = "SELECT " + lowerDbSchemaName + ".sp_next_mimetypeidgen() as NextMimeTypeIdGen";
			if( stmtSelectNextMimeTypeIdGen == null ) {
				stmtSelectNextMimeTypeIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextMimeTypeIdGen.executeQuery();
			int nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"nextMimeTypeIdGen",
           			"Query of sp_next_mimetypeidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"nextMimeTypeIdGen",
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

	public long nextClusterIdGen() {
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"nextClusterIdGen",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			String sql = "SELECT " + lowerDbSchemaName + ".sp_next_clusteridgen() as NextClusterIdGen";
			if( stmtSelectNextClusterIdGen == null ) {
				stmtSelectNextClusterIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextClusterIdGen.executeQuery();
			long nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"nextClusterIdGen",
           			"Query of sp_next_clusteridgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"nextClusterIdGen",
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

	public long nextTenantIdGen() {
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"nextTenantIdGen",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			String sql = "SELECT " + lowerDbSchemaName + ".sp_next_tenantidgen() as NextTenantIdGen";
			if( stmtSelectNextTenantIdGen == null ) {
				stmtSelectNextTenantIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextTenantIdGen.executeQuery();
			long nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"nextTenantIdGen",
           			"Query of sp_next_tenantidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"nextTenantIdGen",
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

	/**
	 *	Release the prepared statements.
	 *	<p>
	 *	When the schema changes connections, the prepared statements
	 *	have to be released because they contain connection-specific
	 *	information for most databases.
	 */
	public void releasePreparedStatements() {
		final String S_ProcName = "releasePreparedStatements";

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
			stmtSelectNextServiceTypeIdGen = null;
		}
		if( stmtSelectNextMimeTypeIdGen != null ) {
			try {
				stmtSelectNextMimeTypeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextMimeTypeIdGen = null;
		}
		if( stmtSelectNextClusterIdGen != null ) {
			try {
				stmtSelectNextClusterIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextClusterIdGen = null;
		}
		if( stmtSelectNextTenantIdGen != null ) {
			try {
				stmtSelectNextTenantIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTenantIdGen = null;
		}

		if( ( tableAccessFrequency != null ) && ( tableAccessFrequency instanceof CFBamPgSqlAccessFrequencyTable ) ) {
			CFBamPgSqlAccessFrequencyTable table = (CFBamPgSqlAccessFrequencyTable)tableAccessFrequency;
			table.releasePreparedStatements();
		}
		if( ( tableAccessSecurity != null ) && ( tableAccessSecurity instanceof CFBamPgSqlAccessSecurityTable ) ) {
			CFBamPgSqlAccessSecurityTable table = (CFBamPgSqlAccessSecurityTable)tableAccessSecurity;
			table.releasePreparedStatements();
		}
		if( ( tableAtom != null ) && ( tableAtom instanceof CFBamPgSqlAtomTable ) ) {
			CFBamPgSqlAtomTable table = (CFBamPgSqlAtomTable)tableAtom;
			table.releasePreparedStatements();
		}
		if( ( tableAuditAction != null ) && ( tableAuditAction instanceof CFBamPgSqlAuditActionTable ) ) {
			CFBamPgSqlAuditActionTable table = (CFBamPgSqlAuditActionTable)tableAuditAction;
			table.releasePreparedStatements();
		}
		if( ( tableBlobCol != null ) && ( tableBlobCol instanceof CFBamPgSqlBlobColTable ) ) {
			CFBamPgSqlBlobColTable table = (CFBamPgSqlBlobColTable)tableBlobCol;
			table.releasePreparedStatements();
		}
		if( ( tableBlobDef != null ) && ( tableBlobDef instanceof CFBamPgSqlBlobDefTable ) ) {
			CFBamPgSqlBlobDefTable table = (CFBamPgSqlBlobDefTable)tableBlobDef;
			table.releasePreparedStatements();
		}
		if( ( tableBlobType != null ) && ( tableBlobType instanceof CFBamPgSqlBlobTypeTable ) ) {
			CFBamPgSqlBlobTypeTable table = (CFBamPgSqlBlobTypeTable)tableBlobType;
			table.releasePreparedStatements();
		}
		if( ( tableBoolCol != null ) && ( tableBoolCol instanceof CFBamPgSqlBoolColTable ) ) {
			CFBamPgSqlBoolColTable table = (CFBamPgSqlBoolColTable)tableBoolCol;
			table.releasePreparedStatements();
		}
		if( ( tableBoolDef != null ) && ( tableBoolDef instanceof CFBamPgSqlBoolDefTable ) ) {
			CFBamPgSqlBoolDefTable table = (CFBamPgSqlBoolDefTable)tableBoolDef;
			table.releasePreparedStatements();
		}
		if( ( tableBoolType != null ) && ( tableBoolType instanceof CFBamPgSqlBoolTypeTable ) ) {
			CFBamPgSqlBoolTypeTable table = (CFBamPgSqlBoolTypeTable)tableBoolType;
			table.releasePreparedStatements();
		}
		if( ( tableChain != null ) && ( tableChain instanceof CFBamPgSqlChainTable ) ) {
			CFBamPgSqlChainTable table = (CFBamPgSqlChainTable)tableChain;
			table.releasePreparedStatements();
		}
		if( ( tableClearDep != null ) && ( tableClearDep instanceof CFBamPgSqlClearDepTable ) ) {
			CFBamPgSqlClearDepTable table = (CFBamPgSqlClearDepTable)tableClearDep;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep1 != null ) && ( tableClearSubDep1 instanceof CFBamPgSqlClearSubDep1Table ) ) {
			CFBamPgSqlClearSubDep1Table table = (CFBamPgSqlClearSubDep1Table)tableClearSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep2 != null ) && ( tableClearSubDep2 instanceof CFBamPgSqlClearSubDep2Table ) ) {
			CFBamPgSqlClearSubDep2Table table = (CFBamPgSqlClearSubDep2Table)tableClearSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep3 != null ) && ( tableClearSubDep3 instanceof CFBamPgSqlClearSubDep3Table ) ) {
			CFBamPgSqlClearSubDep3Table table = (CFBamPgSqlClearSubDep3Table)tableClearSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tableClearTopDep != null ) && ( tableClearTopDep instanceof CFBamPgSqlClearTopDepTable ) ) {
			CFBamPgSqlClearTopDepTable table = (CFBamPgSqlClearTopDepTable)tableClearTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableCluster != null ) && ( tableCluster instanceof CFBamPgSqlClusterTable ) ) {
			CFBamPgSqlClusterTable table = (CFBamPgSqlClusterTable)tableCluster;
			table.releasePreparedStatements();
		}
		if( ( tableDataScope != null ) && ( tableDataScope instanceof CFBamPgSqlDataScopeTable ) ) {
			CFBamPgSqlDataScopeTable table = (CFBamPgSqlDataScopeTable)tableDataScope;
			table.releasePreparedStatements();
		}
		if( ( tableDateCol != null ) && ( tableDateCol instanceof CFBamPgSqlDateColTable ) ) {
			CFBamPgSqlDateColTable table = (CFBamPgSqlDateColTable)tableDateCol;
			table.releasePreparedStatements();
		}
		if( ( tableDateDef != null ) && ( tableDateDef instanceof CFBamPgSqlDateDefTable ) ) {
			CFBamPgSqlDateDefTable table = (CFBamPgSqlDateDefTable)tableDateDef;
			table.releasePreparedStatements();
		}
		if( ( tableDateType != null ) && ( tableDateType instanceof CFBamPgSqlDateTypeTable ) ) {
			CFBamPgSqlDateTypeTable table = (CFBamPgSqlDateTypeTable)tableDateType;
			table.releasePreparedStatements();
		}
		if( ( tableDelDep != null ) && ( tableDelDep instanceof CFBamPgSqlDelDepTable ) ) {
			CFBamPgSqlDelDepTable table = (CFBamPgSqlDelDepTable)tableDelDep;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep1 != null ) && ( tableDelSubDep1 instanceof CFBamPgSqlDelSubDep1Table ) ) {
			CFBamPgSqlDelSubDep1Table table = (CFBamPgSqlDelSubDep1Table)tableDelSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep2 != null ) && ( tableDelSubDep2 instanceof CFBamPgSqlDelSubDep2Table ) ) {
			CFBamPgSqlDelSubDep2Table table = (CFBamPgSqlDelSubDep2Table)tableDelSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep3 != null ) && ( tableDelSubDep3 instanceof CFBamPgSqlDelSubDep3Table ) ) {
			CFBamPgSqlDelSubDep3Table table = (CFBamPgSqlDelSubDep3Table)tableDelSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tableDelTopDep != null ) && ( tableDelTopDep instanceof CFBamPgSqlDelTopDepTable ) ) {
			CFBamPgSqlDelTopDepTable table = (CFBamPgSqlDelTopDepTable)tableDelTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableDomain != null ) && ( tableDomain instanceof CFBamPgSqlDomainTable ) ) {
			CFBamPgSqlDomainTable table = (CFBamPgSqlDomainTable)tableDomain;
			table.releasePreparedStatements();
		}
		if( ( tableDomainBase != null ) && ( tableDomainBase instanceof CFBamPgSqlDomainBaseTable ) ) {
			CFBamPgSqlDomainBaseTable table = (CFBamPgSqlDomainBaseTable)tableDomainBase;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleCol != null ) && ( tableDoubleCol instanceof CFBamPgSqlDoubleColTable ) ) {
			CFBamPgSqlDoubleColTable table = (CFBamPgSqlDoubleColTable)tableDoubleCol;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleDef != null ) && ( tableDoubleDef instanceof CFBamPgSqlDoubleDefTable ) ) {
			CFBamPgSqlDoubleDefTable table = (CFBamPgSqlDoubleDefTable)tableDoubleDef;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleType != null ) && ( tableDoubleType instanceof CFBamPgSqlDoubleTypeTable ) ) {
			CFBamPgSqlDoubleTypeTable table = (CFBamPgSqlDoubleTypeTable)tableDoubleType;
			table.releasePreparedStatements();
		}
		if( ( tableEnumCol != null ) && ( tableEnumCol instanceof CFBamPgSqlEnumColTable ) ) {
			CFBamPgSqlEnumColTable table = (CFBamPgSqlEnumColTable)tableEnumCol;
			table.releasePreparedStatements();
		}
		if( ( tableEnumDef != null ) && ( tableEnumDef instanceof CFBamPgSqlEnumDefTable ) ) {
			CFBamPgSqlEnumDefTable table = (CFBamPgSqlEnumDefTable)tableEnumDef;
			table.releasePreparedStatements();
		}
		if( ( tableEnumTag != null ) && ( tableEnumTag instanceof CFBamPgSqlEnumTagTable ) ) {
			CFBamPgSqlEnumTagTable table = (CFBamPgSqlEnumTagTable)tableEnumTag;
			table.releasePreparedStatements();
		}
		if( ( tableEnumType != null ) && ( tableEnumType instanceof CFBamPgSqlEnumTypeTable ) ) {
			CFBamPgSqlEnumTypeTable table = (CFBamPgSqlEnumTypeTable)tableEnumType;
			table.releasePreparedStatements();
		}
		if( ( tableFloatCol != null ) && ( tableFloatCol instanceof CFBamPgSqlFloatColTable ) ) {
			CFBamPgSqlFloatColTable table = (CFBamPgSqlFloatColTable)tableFloatCol;
			table.releasePreparedStatements();
		}
		if( ( tableFloatDef != null ) && ( tableFloatDef instanceof CFBamPgSqlFloatDefTable ) ) {
			CFBamPgSqlFloatDefTable table = (CFBamPgSqlFloatDefTable)tableFloatDef;
			table.releasePreparedStatements();
		}
		if( ( tableFloatType != null ) && ( tableFloatType instanceof CFBamPgSqlFloatTypeTable ) ) {
			CFBamPgSqlFloatTypeTable table = (CFBamPgSqlFloatTypeTable)tableFloatType;
			table.releasePreparedStatements();
		}
		if( ( tableHostNode != null ) && ( tableHostNode instanceof CFBamPgSqlHostNodeTable ) ) {
			CFBamPgSqlHostNodeTable table = (CFBamPgSqlHostNodeTable)tableHostNode;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountry != null ) && ( tableISOCountry instanceof CFBamPgSqlISOCountryTable ) ) {
			CFBamPgSqlISOCountryTable table = (CFBamPgSqlISOCountryTable)tableISOCountry;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountryCurrency != null ) && ( tableISOCountryCurrency instanceof CFBamPgSqlISOCountryCurrencyTable ) ) {
			CFBamPgSqlISOCountryCurrencyTable table = (CFBamPgSqlISOCountryCurrencyTable)tableISOCountryCurrency;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountryLanguage != null ) && ( tableISOCountryLanguage instanceof CFBamPgSqlISOCountryLanguageTable ) ) {
			CFBamPgSqlISOCountryLanguageTable table = (CFBamPgSqlISOCountryLanguageTable)tableISOCountryLanguage;
			table.releasePreparedStatements();
		}
		if( ( tableISOCurrency != null ) && ( tableISOCurrency instanceof CFBamPgSqlISOCurrencyTable ) ) {
			CFBamPgSqlISOCurrencyTable table = (CFBamPgSqlISOCurrencyTable)tableISOCurrency;
			table.releasePreparedStatements();
		}
		if( ( tableISOLanguage != null ) && ( tableISOLanguage instanceof CFBamPgSqlISOLanguageTable ) ) {
			CFBamPgSqlISOLanguageTable table = (CFBamPgSqlISOLanguageTable)tableISOLanguage;
			table.releasePreparedStatements();
		}
		if( ( tableISOTimezone != null ) && ( tableISOTimezone instanceof CFBamPgSqlISOTimezoneTable ) ) {
			CFBamPgSqlISOTimezoneTable table = (CFBamPgSqlISOTimezoneTable)tableISOTimezone;
			table.releasePreparedStatements();
		}
		if( ( tableId16Gen != null ) && ( tableId16Gen instanceof CFBamPgSqlId16GenTable ) ) {
			CFBamPgSqlId16GenTable table = (CFBamPgSqlId16GenTable)tableId16Gen;
			table.releasePreparedStatements();
		}
		if( ( tableId32Gen != null ) && ( tableId32Gen instanceof CFBamPgSqlId32GenTable ) ) {
			CFBamPgSqlId32GenTable table = (CFBamPgSqlId32GenTable)tableId32Gen;
			table.releasePreparedStatements();
		}
		if( ( tableId64Gen != null ) && ( tableId64Gen instanceof CFBamPgSqlId64GenTable ) ) {
			CFBamPgSqlId64GenTable table = (CFBamPgSqlId64GenTable)tableId64Gen;
			table.releasePreparedStatements();
		}
		if( ( tableIndex != null ) && ( tableIndex instanceof CFBamPgSqlIndexTable ) ) {
			CFBamPgSqlIndexTable table = (CFBamPgSqlIndexTable)tableIndex;
			table.releasePreparedStatements();
		}
		if( ( tableIndexCol != null ) && ( tableIndexCol instanceof CFBamPgSqlIndexColTable ) ) {
			CFBamPgSqlIndexColTable table = (CFBamPgSqlIndexColTable)tableIndexCol;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Col != null ) && ( tableInt16Col instanceof CFBamPgSqlInt16ColTable ) ) {
			CFBamPgSqlInt16ColTable table = (CFBamPgSqlInt16ColTable)tableInt16Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Def != null ) && ( tableInt16Def instanceof CFBamPgSqlInt16DefTable ) ) {
			CFBamPgSqlInt16DefTable table = (CFBamPgSqlInt16DefTable)tableInt16Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Type != null ) && ( tableInt16Type instanceof CFBamPgSqlInt16TypeTable ) ) {
			CFBamPgSqlInt16TypeTable table = (CFBamPgSqlInt16TypeTable)tableInt16Type;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Col != null ) && ( tableInt32Col instanceof CFBamPgSqlInt32ColTable ) ) {
			CFBamPgSqlInt32ColTable table = (CFBamPgSqlInt32ColTable)tableInt32Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Def != null ) && ( tableInt32Def instanceof CFBamPgSqlInt32DefTable ) ) {
			CFBamPgSqlInt32DefTable table = (CFBamPgSqlInt32DefTable)tableInt32Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Type != null ) && ( tableInt32Type instanceof CFBamPgSqlInt32TypeTable ) ) {
			CFBamPgSqlInt32TypeTable table = (CFBamPgSqlInt32TypeTable)tableInt32Type;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Col != null ) && ( tableInt64Col instanceof CFBamPgSqlInt64ColTable ) ) {
			CFBamPgSqlInt64ColTable table = (CFBamPgSqlInt64ColTable)tableInt64Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Def != null ) && ( tableInt64Def instanceof CFBamPgSqlInt64DefTable ) ) {
			CFBamPgSqlInt64DefTable table = (CFBamPgSqlInt64DefTable)tableInt64Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Type != null ) && ( tableInt64Type instanceof CFBamPgSqlInt64TypeTable ) ) {
			CFBamPgSqlInt64TypeTable table = (CFBamPgSqlInt64TypeTable)tableInt64Type;
			table.releasePreparedStatements();
		}
		if( ( tableLicense != null ) && ( tableLicense instanceof CFBamPgSqlLicenseTable ) ) {
			CFBamPgSqlLicenseTable table = (CFBamPgSqlLicenseTable)tableLicense;
			table.releasePreparedStatements();
		}
		if( ( tableLoaderBehaviour != null ) && ( tableLoaderBehaviour instanceof CFBamPgSqlLoaderBehaviourTable ) ) {
			CFBamPgSqlLoaderBehaviourTable table = (CFBamPgSqlLoaderBehaviourTable)tableLoaderBehaviour;
			table.releasePreparedStatements();
		}
		if( ( tableMajorVersion != null ) && ( tableMajorVersion instanceof CFBamPgSqlMajorVersionTable ) ) {
			CFBamPgSqlMajorVersionTable table = (CFBamPgSqlMajorVersionTable)tableMajorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableMimeType != null ) && ( tableMimeType instanceof CFBamPgSqlMimeTypeTable ) ) {
			CFBamPgSqlMimeTypeTable table = (CFBamPgSqlMimeTypeTable)tableMimeType;
			table.releasePreparedStatements();
		}
		if( ( tableMinorVersion != null ) && ( tableMinorVersion instanceof CFBamPgSqlMinorVersionTable ) ) {
			CFBamPgSqlMinorVersionTable table = (CFBamPgSqlMinorVersionTable)tableMinorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenCol != null ) && ( tableNmTokenCol instanceof CFBamPgSqlNmTokenColTable ) ) {
			CFBamPgSqlNmTokenColTable table = (CFBamPgSqlNmTokenColTable)tableNmTokenCol;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenDef != null ) && ( tableNmTokenDef instanceof CFBamPgSqlNmTokenDefTable ) ) {
			CFBamPgSqlNmTokenDefTable table = (CFBamPgSqlNmTokenDefTable)tableNmTokenDef;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenType != null ) && ( tableNmTokenType instanceof CFBamPgSqlNmTokenTypeTable ) ) {
			CFBamPgSqlNmTokenTypeTable table = (CFBamPgSqlNmTokenTypeTable)tableNmTokenType;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensCol != null ) && ( tableNmTokensCol instanceof CFBamPgSqlNmTokensColTable ) ) {
			CFBamPgSqlNmTokensColTable table = (CFBamPgSqlNmTokensColTable)tableNmTokensCol;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensDef != null ) && ( tableNmTokensDef instanceof CFBamPgSqlNmTokensDefTable ) ) {
			CFBamPgSqlNmTokensDefTable table = (CFBamPgSqlNmTokensDefTable)tableNmTokensDef;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensType != null ) && ( tableNmTokensType instanceof CFBamPgSqlNmTokensTypeTable ) ) {
			CFBamPgSqlNmTokensTypeTable table = (CFBamPgSqlNmTokensTypeTable)tableNmTokensType;
			table.releasePreparedStatements();
		}
		if( ( tableNumberCol != null ) && ( tableNumberCol instanceof CFBamPgSqlNumberColTable ) ) {
			CFBamPgSqlNumberColTable table = (CFBamPgSqlNumberColTable)tableNumberCol;
			table.releasePreparedStatements();
		}
		if( ( tableNumberDef != null ) && ( tableNumberDef instanceof CFBamPgSqlNumberDefTable ) ) {
			CFBamPgSqlNumberDefTable table = (CFBamPgSqlNumberDefTable)tableNumberDef;
			table.releasePreparedStatements();
		}
		if( ( tableNumberType != null ) && ( tableNumberType instanceof CFBamPgSqlNumberTypeTable ) ) {
			CFBamPgSqlNumberTypeTable table = (CFBamPgSqlNumberTypeTable)tableNumberType;
			table.releasePreparedStatements();
		}
		if( ( tableParam != null ) && ( tableParam instanceof CFBamPgSqlParamTable ) ) {
			CFBamPgSqlParamTable table = (CFBamPgSqlParamTable)tableParam;
			table.releasePreparedStatements();
		}
		if( ( tablePopDep != null ) && ( tablePopDep instanceof CFBamPgSqlPopDepTable ) ) {
			CFBamPgSqlPopDepTable table = (CFBamPgSqlPopDepTable)tablePopDep;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep1 != null ) && ( tablePopSubDep1 instanceof CFBamPgSqlPopSubDep1Table ) ) {
			CFBamPgSqlPopSubDep1Table table = (CFBamPgSqlPopSubDep1Table)tablePopSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep2 != null ) && ( tablePopSubDep2 instanceof CFBamPgSqlPopSubDep2Table ) ) {
			CFBamPgSqlPopSubDep2Table table = (CFBamPgSqlPopSubDep2Table)tablePopSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep3 != null ) && ( tablePopSubDep3 instanceof CFBamPgSqlPopSubDep3Table ) ) {
			CFBamPgSqlPopSubDep3Table table = (CFBamPgSqlPopSubDep3Table)tablePopSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tablePopTopDep != null ) && ( tablePopTopDep instanceof CFBamPgSqlPopTopDepTable ) ) {
			CFBamPgSqlPopTopDepTable table = (CFBamPgSqlPopTopDepTable)tablePopTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableProjectBase != null ) && ( tableProjectBase instanceof CFBamPgSqlProjectBaseTable ) ) {
			CFBamPgSqlProjectBaseTable table = (CFBamPgSqlProjectBaseTable)tableProjectBase;
			table.releasePreparedStatements();
		}
		if( ( tableRealProject != null ) && ( tableRealProject instanceof CFBamPgSqlRealProjectTable ) ) {
			CFBamPgSqlRealProjectTable table = (CFBamPgSqlRealProjectTable)tableRealProject;
			table.releasePreparedStatements();
		}
		if( ( tableRelation != null ) && ( tableRelation instanceof CFBamPgSqlRelationTable ) ) {
			CFBamPgSqlRelationTable table = (CFBamPgSqlRelationTable)tableRelation;
			table.releasePreparedStatements();
		}
		if( ( tableRelationCol != null ) && ( tableRelationCol instanceof CFBamPgSqlRelationColTable ) ) {
			CFBamPgSqlRelationColTable table = (CFBamPgSqlRelationColTable)tableRelationCol;
			table.releasePreparedStatements();
		}
		if( ( tableRelationType != null ) && ( tableRelationType instanceof CFBamPgSqlRelationTypeTable ) ) {
			CFBamPgSqlRelationTypeTable table = (CFBamPgSqlRelationTypeTable)tableRelationType;
			table.releasePreparedStatements();
		}
		if( ( tableSchemaDef != null ) && ( tableSchemaDef instanceof CFBamPgSqlSchemaDefTable ) ) {
			CFBamPgSqlSchemaDefTable table = (CFBamPgSqlSchemaDefTable)tableSchemaDef;
			table.releasePreparedStatements();
		}
		if( ( tableSchemaRef != null ) && ( tableSchemaRef instanceof CFBamPgSqlSchemaRefTable ) ) {
			CFBamPgSqlSchemaRefTable table = (CFBamPgSqlSchemaRefTable)tableSchemaRef;
			table.releasePreparedStatements();
		}
		if( ( tableScope != null ) && ( tableScope instanceof CFBamPgSqlScopeTable ) ) {
			CFBamPgSqlScopeTable table = (CFBamPgSqlScopeTable)tableScope;
			table.releasePreparedStatements();
		}
		if( ( tableSecApp != null ) && ( tableSecApp instanceof CFBamPgSqlSecAppTable ) ) {
			CFBamPgSqlSecAppTable table = (CFBamPgSqlSecAppTable)tableSecApp;
			table.releasePreparedStatements();
		}
		if( ( tableSecDevice != null ) && ( tableSecDevice instanceof CFBamPgSqlSecDeviceTable ) ) {
			CFBamPgSqlSecDeviceTable table = (CFBamPgSqlSecDeviceTable)tableSecDevice;
			table.releasePreparedStatements();
		}
		if( ( tableSecForm != null ) && ( tableSecForm instanceof CFBamPgSqlSecFormTable ) ) {
			CFBamPgSqlSecFormTable table = (CFBamPgSqlSecFormTable)tableSecForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroup != null ) && ( tableSecGroup instanceof CFBamPgSqlSecGroupTable ) ) {
			CFBamPgSqlSecGroupTable table = (CFBamPgSqlSecGroupTable)tableSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupForm != null ) && ( tableSecGroupForm instanceof CFBamPgSqlSecGroupFormTable ) ) {
			CFBamPgSqlSecGroupFormTable table = (CFBamPgSqlSecGroupFormTable)tableSecGroupForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupInclude != null ) && ( tableSecGroupInclude instanceof CFBamPgSqlSecGroupIncludeTable ) ) {
			CFBamPgSqlSecGroupIncludeTable table = (CFBamPgSqlSecGroupIncludeTable)tableSecGroupInclude;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupMember != null ) && ( tableSecGroupMember instanceof CFBamPgSqlSecGroupMemberTable ) ) {
			CFBamPgSqlSecGroupMemberTable table = (CFBamPgSqlSecGroupMemberTable)tableSecGroupMember;
			table.releasePreparedStatements();
		}
		if( ( tableSecSession != null ) && ( tableSecSession instanceof CFBamPgSqlSecSessionTable ) ) {
			CFBamPgSqlSecSessionTable table = (CFBamPgSqlSecSessionTable)tableSecSession;
			table.releasePreparedStatements();
		}
		if( ( tableSecUser != null ) && ( tableSecUser instanceof CFBamPgSqlSecUserTable ) ) {
			CFBamPgSqlSecUserTable table = (CFBamPgSqlSecUserTable)tableSecUser;
			table.releasePreparedStatements();
		}
		if( ( tableSecurityScope != null ) && ( tableSecurityScope instanceof CFBamPgSqlSecurityScopeTable ) ) {
			CFBamPgSqlSecurityScopeTable table = (CFBamPgSqlSecurityScopeTable)tableSecurityScope;
			table.releasePreparedStatements();
		}
		if( ( tableServerListFunc != null ) && ( tableServerListFunc instanceof CFBamPgSqlServerListFuncTable ) ) {
			CFBamPgSqlServerListFuncTable table = (CFBamPgSqlServerListFuncTable)tableServerListFunc;
			table.releasePreparedStatements();
		}
		if( ( tableServerMethod != null ) && ( tableServerMethod instanceof CFBamPgSqlServerMethodTable ) ) {
			CFBamPgSqlServerMethodTable table = (CFBamPgSqlServerMethodTable)tableServerMethod;
			table.releasePreparedStatements();
		}
		if( ( tableServerObjFunc != null ) && ( tableServerObjFunc instanceof CFBamPgSqlServerObjFuncTable ) ) {
			CFBamPgSqlServerObjFuncTable table = (CFBamPgSqlServerObjFuncTable)tableServerObjFunc;
			table.releasePreparedStatements();
		}
		if( ( tableServerProc != null ) && ( tableServerProc instanceof CFBamPgSqlServerProcTable ) ) {
			CFBamPgSqlServerProcTable table = (CFBamPgSqlServerProcTable)tableServerProc;
			table.releasePreparedStatements();
		}
		if( ( tableService != null ) && ( tableService instanceof CFBamPgSqlServiceTable ) ) {
			CFBamPgSqlServiceTable table = (CFBamPgSqlServiceTable)tableService;
			table.releasePreparedStatements();
		}
		if( ( tableServiceType != null ) && ( tableServiceType instanceof CFBamPgSqlServiceTypeTable ) ) {
			CFBamPgSqlServiceTypeTable table = (CFBamPgSqlServiceTypeTable)tableServiceType;
			table.releasePreparedStatements();
		}
		if( ( tableStringCol != null ) && ( tableStringCol instanceof CFBamPgSqlStringColTable ) ) {
			CFBamPgSqlStringColTable table = (CFBamPgSqlStringColTable)tableStringCol;
			table.releasePreparedStatements();
		}
		if( ( tableStringDef != null ) && ( tableStringDef instanceof CFBamPgSqlStringDefTable ) ) {
			CFBamPgSqlStringDefTable table = (CFBamPgSqlStringDefTable)tableStringDef;
			table.releasePreparedStatements();
		}
		if( ( tableStringType != null ) && ( tableStringType instanceof CFBamPgSqlStringTypeTable ) ) {
			CFBamPgSqlStringTypeTable table = (CFBamPgSqlStringTypeTable)tableStringType;
			table.releasePreparedStatements();
		}
		if( ( tableSubProject != null ) && ( tableSubProject instanceof CFBamPgSqlSubProjectTable ) ) {
			CFBamPgSqlSubProjectTable table = (CFBamPgSqlSubProjectTable)tableSubProject;
			table.releasePreparedStatements();
		}
		if( ( tableSysCluster != null ) && ( tableSysCluster instanceof CFBamPgSqlSysClusterTable ) ) {
			CFBamPgSqlSysClusterTable table = (CFBamPgSqlSysClusterTable)tableSysCluster;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroup != null ) && ( tableTSecGroup instanceof CFBamPgSqlTSecGroupTable ) ) {
			CFBamPgSqlTSecGroupTable table = (CFBamPgSqlTSecGroupTable)tableTSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroupInclude != null ) && ( tableTSecGroupInclude instanceof CFBamPgSqlTSecGroupIncludeTable ) ) {
			CFBamPgSqlTSecGroupIncludeTable table = (CFBamPgSqlTSecGroupIncludeTable)tableTSecGroupInclude;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroupMember != null ) && ( tableTSecGroupMember instanceof CFBamPgSqlTSecGroupMemberTable ) ) {
			CFBamPgSqlTSecGroupMemberTable table = (CFBamPgSqlTSecGroupMemberTable)tableTSecGroupMember;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateCol != null ) && ( tableTZDateCol instanceof CFBamPgSqlTZDateColTable ) ) {
			CFBamPgSqlTZDateColTable table = (CFBamPgSqlTZDateColTable)tableTZDateCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateDef != null ) && ( tableTZDateDef instanceof CFBamPgSqlTZDateDefTable ) ) {
			CFBamPgSqlTZDateDefTable table = (CFBamPgSqlTZDateDefTable)tableTZDateDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateType != null ) && ( tableTZDateType instanceof CFBamPgSqlTZDateTypeTable ) ) {
			CFBamPgSqlTZDateTypeTable table = (CFBamPgSqlTZDateTypeTable)tableTZDateType;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeCol != null ) && ( tableTZTimeCol instanceof CFBamPgSqlTZTimeColTable ) ) {
			CFBamPgSqlTZTimeColTable table = (CFBamPgSqlTZTimeColTable)tableTZTimeCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeDef != null ) && ( tableTZTimeDef instanceof CFBamPgSqlTZTimeDefTable ) ) {
			CFBamPgSqlTZTimeDefTable table = (CFBamPgSqlTZTimeDefTable)tableTZTimeDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeType != null ) && ( tableTZTimeType instanceof CFBamPgSqlTZTimeTypeTable ) ) {
			CFBamPgSqlTZTimeTypeTable table = (CFBamPgSqlTZTimeTypeTable)tableTZTimeType;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampCol != null ) && ( tableTZTimestampCol instanceof CFBamPgSqlTZTimestampColTable ) ) {
			CFBamPgSqlTZTimestampColTable table = (CFBamPgSqlTZTimestampColTable)tableTZTimestampCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampDef != null ) && ( tableTZTimestampDef instanceof CFBamPgSqlTZTimestampDefTable ) ) {
			CFBamPgSqlTZTimestampDefTable table = (CFBamPgSqlTZTimestampDefTable)tableTZTimestampDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampType != null ) && ( tableTZTimestampType instanceof CFBamPgSqlTZTimestampTypeTable ) ) {
			CFBamPgSqlTZTimestampTypeTable table = (CFBamPgSqlTZTimestampTypeTable)tableTZTimestampType;
			table.releasePreparedStatements();
		}
		if( ( tableTable != null ) && ( tableTable instanceof CFBamPgSqlTableTable ) ) {
			CFBamPgSqlTableTable table = (CFBamPgSqlTableTable)tableTable;
			table.releasePreparedStatements();
		}
		if( ( tableTableCol != null ) && ( tableTableCol instanceof CFBamPgSqlTableColTable ) ) {
			CFBamPgSqlTableColTable table = (CFBamPgSqlTableColTable)tableTableCol;
			table.releasePreparedStatements();
		}
		if( ( tableTenant != null ) && ( tableTenant instanceof CFBamPgSqlTenantTable ) ) {
			CFBamPgSqlTenantTable table = (CFBamPgSqlTenantTable)tableTenant;
			table.releasePreparedStatements();
		}
		if( ( tableTextCol != null ) && ( tableTextCol instanceof CFBamPgSqlTextColTable ) ) {
			CFBamPgSqlTextColTable table = (CFBamPgSqlTextColTable)tableTextCol;
			table.releasePreparedStatements();
		}
		if( ( tableTextDef != null ) && ( tableTextDef instanceof CFBamPgSqlTextDefTable ) ) {
			CFBamPgSqlTextDefTable table = (CFBamPgSqlTextDefTable)tableTextDef;
			table.releasePreparedStatements();
		}
		if( ( tableTextType != null ) && ( tableTextType instanceof CFBamPgSqlTextTypeTable ) ) {
			CFBamPgSqlTextTypeTable table = (CFBamPgSqlTextTypeTable)tableTextType;
			table.releasePreparedStatements();
		}
		if( ( tableTimeCol != null ) && ( tableTimeCol instanceof CFBamPgSqlTimeColTable ) ) {
			CFBamPgSqlTimeColTable table = (CFBamPgSqlTimeColTable)tableTimeCol;
			table.releasePreparedStatements();
		}
		if( ( tableTimeDef != null ) && ( tableTimeDef instanceof CFBamPgSqlTimeDefTable ) ) {
			CFBamPgSqlTimeDefTable table = (CFBamPgSqlTimeDefTable)tableTimeDef;
			table.releasePreparedStatements();
		}
		if( ( tableTimeType != null ) && ( tableTimeType instanceof CFBamPgSqlTimeTypeTable ) ) {
			CFBamPgSqlTimeTypeTable table = (CFBamPgSqlTimeTypeTable)tableTimeType;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampCol != null ) && ( tableTimestampCol instanceof CFBamPgSqlTimestampColTable ) ) {
			CFBamPgSqlTimestampColTable table = (CFBamPgSqlTimestampColTable)tableTimestampCol;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampDef != null ) && ( tableTimestampDef instanceof CFBamPgSqlTimestampDefTable ) ) {
			CFBamPgSqlTimestampDefTable table = (CFBamPgSqlTimestampDefTable)tableTimestampDef;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampType != null ) && ( tableTimestampType instanceof CFBamPgSqlTimestampTypeTable ) ) {
			CFBamPgSqlTimestampTypeTable table = (CFBamPgSqlTimestampTypeTable)tableTimestampType;
			table.releasePreparedStatements();
		}
		if( ( tableTld != null ) && ( tableTld instanceof CFBamPgSqlTldTable ) ) {
			CFBamPgSqlTldTable table = (CFBamPgSqlTldTable)tableTld;
			table.releasePreparedStatements();
		}
		if( ( tableTokenCol != null ) && ( tableTokenCol instanceof CFBamPgSqlTokenColTable ) ) {
			CFBamPgSqlTokenColTable table = (CFBamPgSqlTokenColTable)tableTokenCol;
			table.releasePreparedStatements();
		}
		if( ( tableTokenDef != null ) && ( tableTokenDef instanceof CFBamPgSqlTokenDefTable ) ) {
			CFBamPgSqlTokenDefTable table = (CFBamPgSqlTokenDefTable)tableTokenDef;
			table.releasePreparedStatements();
		}
		if( ( tableTokenType != null ) && ( tableTokenType instanceof CFBamPgSqlTokenTypeTable ) ) {
			CFBamPgSqlTokenTypeTable table = (CFBamPgSqlTokenTypeTable)tableTokenType;
			table.releasePreparedStatements();
		}
		if( ( tableTopDomain != null ) && ( tableTopDomain instanceof CFBamPgSqlTopDomainTable ) ) {
			CFBamPgSqlTopDomainTable table = (CFBamPgSqlTopDomainTable)tableTopDomain;
			table.releasePreparedStatements();
		}
		if( ( tableTopProject != null ) && ( tableTopProject instanceof CFBamPgSqlTopProjectTable ) ) {
			CFBamPgSqlTopProjectTable table = (CFBamPgSqlTopProjectTable)tableTopProject;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Col != null ) && ( tableUInt16Col instanceof CFBamPgSqlUInt16ColTable ) ) {
			CFBamPgSqlUInt16ColTable table = (CFBamPgSqlUInt16ColTable)tableUInt16Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Def != null ) && ( tableUInt16Def instanceof CFBamPgSqlUInt16DefTable ) ) {
			CFBamPgSqlUInt16DefTable table = (CFBamPgSqlUInt16DefTable)tableUInt16Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Type != null ) && ( tableUInt16Type instanceof CFBamPgSqlUInt16TypeTable ) ) {
			CFBamPgSqlUInt16TypeTable table = (CFBamPgSqlUInt16TypeTable)tableUInt16Type;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Col != null ) && ( tableUInt32Col instanceof CFBamPgSqlUInt32ColTable ) ) {
			CFBamPgSqlUInt32ColTable table = (CFBamPgSqlUInt32ColTable)tableUInt32Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Def != null ) && ( tableUInt32Def instanceof CFBamPgSqlUInt32DefTable ) ) {
			CFBamPgSqlUInt32DefTable table = (CFBamPgSqlUInt32DefTable)tableUInt32Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Type != null ) && ( tableUInt32Type instanceof CFBamPgSqlUInt32TypeTable ) ) {
			CFBamPgSqlUInt32TypeTable table = (CFBamPgSqlUInt32TypeTable)tableUInt32Type;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Col != null ) && ( tableUInt64Col instanceof CFBamPgSqlUInt64ColTable ) ) {
			CFBamPgSqlUInt64ColTable table = (CFBamPgSqlUInt64ColTable)tableUInt64Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Def != null ) && ( tableUInt64Def instanceof CFBamPgSqlUInt64DefTable ) ) {
			CFBamPgSqlUInt64DefTable table = (CFBamPgSqlUInt64DefTable)tableUInt64Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Type != null ) && ( tableUInt64Type instanceof CFBamPgSqlUInt64TypeTable ) ) {
			CFBamPgSqlUInt64TypeTable table = (CFBamPgSqlUInt64TypeTable)tableUInt64Type;
			table.releasePreparedStatements();
		}
		if( ( tableURLProtocol != null ) && ( tableURLProtocol instanceof CFBamPgSqlURLProtocolTable ) ) {
			CFBamPgSqlURLProtocolTable table = (CFBamPgSqlURLProtocolTable)tableURLProtocol;
			table.releasePreparedStatements();
		}
		if( ( tableUuidCol != null ) && ( tableUuidCol instanceof CFBamPgSqlUuidColTable ) ) {
			CFBamPgSqlUuidColTable table = (CFBamPgSqlUuidColTable)tableUuidCol;
			table.releasePreparedStatements();
		}
		if( ( tableUuidDef != null ) && ( tableUuidDef instanceof CFBamPgSqlUuidDefTable ) ) {
			CFBamPgSqlUuidDefTable table = (CFBamPgSqlUuidDefTable)tableUuidDef;
			table.releasePreparedStatements();
		}
		if( ( tableUuidGen != null ) && ( tableUuidGen instanceof CFBamPgSqlUuidGenTable ) ) {
			CFBamPgSqlUuidGenTable table = (CFBamPgSqlUuidGenTable)tableUuidGen;
			table.releasePreparedStatements();
		}
		if( ( tableUuidType != null ) && ( tableUuidType instanceof CFBamPgSqlUuidTypeTable ) ) {
			CFBamPgSqlUuidTypeTable table = (CFBamPgSqlUuidTypeTable)tableUuidType;
			table.releasePreparedStatements();
		}
		if( ( tableValue != null ) && ( tableValue instanceof CFBamPgSqlValueTable ) ) {
			CFBamPgSqlValueTable table = (CFBamPgSqlValueTable)tableValue;
			table.releasePreparedStatements();
		}
		if( ( tableVersion != null ) && ( tableVersion instanceof CFBamPgSqlVersionTable ) ) {
			CFBamPgSqlVersionTable table = (CFBamPgSqlVersionTable)tableVersion;
			table.releasePreparedStatements();
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamPgSqlSchema.class,
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
			fmt.format( "%1$04d", val.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", val.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", val.get( Calendar.DAY_OF_MONTH ) );
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
			fmt.format( "%1$02d", val.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", val.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", val.get( Calendar.SECOND ) );
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
			fmt.format( "%1$04d", val.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", val.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", val.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", val.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", val.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", val.get( Calendar.SECOND ) );
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
				"convertDateString",
            	"Value must be in YYYY-MM-DD format, \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 8 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
				"convertTimeString",
            	"Value must be in HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
				"convertTimestampString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
				"convertTZDateString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
				"convertTZTimeString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamPgSqlSchema.class,
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
