// Description: Java 7 MS SQL Server 2012 Express Advanced Edition Jdbc DbIO implementation for CFBam.

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

public class CFBamMSSqlSchema
	extends CFBamSchema
{
	protected Connection cnx;
	protected PreparedStatement stmtSelectNextServiceTypeIdGen = null;
	protected PreparedStatement stmtSelectNextMimeTypeIdGen = null;
	protected PreparedStatement stmtSelectNextClusterIdGen = null;
	protected PreparedStatement stmtSelectNextTenantIdGen = null;
	protected boolean inTransaction;
	protected PreparedStatement stmtBeginTransaction = null;

	public CFBamMSSqlSchema() {
		super();
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamMSSqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamMSSqlAccessSecurityTable( this );
		tableAtom = new CFBamMSSqlAtomTable( this );
		tableAuditAction = new CFBamMSSqlAuditActionTable( this );
		tableBlobCol = new CFBamMSSqlBlobColTable( this );
		tableBlobDef = new CFBamMSSqlBlobDefTable( this );
		tableBlobType = new CFBamMSSqlBlobTypeTable( this );
		tableBoolCol = new CFBamMSSqlBoolColTable( this );
		tableBoolDef = new CFBamMSSqlBoolDefTable( this );
		tableBoolType = new CFBamMSSqlBoolTypeTable( this );
		tableChain = new CFBamMSSqlChainTable( this );
		tableClearDep = new CFBamMSSqlClearDepTable( this );
		tableClearSubDep1 = new CFBamMSSqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamMSSqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamMSSqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamMSSqlClearTopDepTable( this );
		tableCluster = new CFBamMSSqlClusterTable( this );
		tableDataScope = new CFBamMSSqlDataScopeTable( this );
		tableDateCol = new CFBamMSSqlDateColTable( this );
		tableDateDef = new CFBamMSSqlDateDefTable( this );
		tableDateType = new CFBamMSSqlDateTypeTable( this );
		tableDelDep = new CFBamMSSqlDelDepTable( this );
		tableDelSubDep1 = new CFBamMSSqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamMSSqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamMSSqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamMSSqlDelTopDepTable( this );
		tableDomain = new CFBamMSSqlDomainTable( this );
		tableDomainBase = new CFBamMSSqlDomainBaseTable( this );
		tableDoubleCol = new CFBamMSSqlDoubleColTable( this );
		tableDoubleDef = new CFBamMSSqlDoubleDefTable( this );
		tableDoubleType = new CFBamMSSqlDoubleTypeTable( this );
		tableEnumCol = new CFBamMSSqlEnumColTable( this );
		tableEnumDef = new CFBamMSSqlEnumDefTable( this );
		tableEnumTag = new CFBamMSSqlEnumTagTable( this );
		tableEnumType = new CFBamMSSqlEnumTypeTable( this );
		tableFloatCol = new CFBamMSSqlFloatColTable( this );
		tableFloatDef = new CFBamMSSqlFloatDefTable( this );
		tableFloatType = new CFBamMSSqlFloatTypeTable( this );
		tableHostNode = new CFBamMSSqlHostNodeTable( this );
		tableISOCountry = new CFBamMSSqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamMSSqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamMSSqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamMSSqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamMSSqlISOLanguageTable( this );
		tableISOTimezone = new CFBamMSSqlISOTimezoneTable( this );
		tableId16Gen = new CFBamMSSqlId16GenTable( this );
		tableId32Gen = new CFBamMSSqlId32GenTable( this );
		tableId64Gen = new CFBamMSSqlId64GenTable( this );
		tableIndex = new CFBamMSSqlIndexTable( this );
		tableIndexCol = new CFBamMSSqlIndexColTable( this );
		tableInt16Col = new CFBamMSSqlInt16ColTable( this );
		tableInt16Def = new CFBamMSSqlInt16DefTable( this );
		tableInt16Type = new CFBamMSSqlInt16TypeTable( this );
		tableInt32Col = new CFBamMSSqlInt32ColTable( this );
		tableInt32Def = new CFBamMSSqlInt32DefTable( this );
		tableInt32Type = new CFBamMSSqlInt32TypeTable( this );
		tableInt64Col = new CFBamMSSqlInt64ColTable( this );
		tableInt64Def = new CFBamMSSqlInt64DefTable( this );
		tableInt64Type = new CFBamMSSqlInt64TypeTable( this );
		tableLicense = new CFBamMSSqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamMSSqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamMSSqlMajorVersionTable( this );
		tableMimeType = new CFBamMSSqlMimeTypeTable( this );
		tableMinorVersion = new CFBamMSSqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamMSSqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamMSSqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamMSSqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamMSSqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamMSSqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamMSSqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamMSSqlNumberColTable( this );
		tableNumberDef = new CFBamMSSqlNumberDefTable( this );
		tableNumberType = new CFBamMSSqlNumberTypeTable( this );
		tableParam = new CFBamMSSqlParamTable( this );
		tablePopDep = new CFBamMSSqlPopDepTable( this );
		tablePopSubDep1 = new CFBamMSSqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamMSSqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamMSSqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamMSSqlPopTopDepTable( this );
		tableProjectBase = new CFBamMSSqlProjectBaseTable( this );
		tableRealProject = new CFBamMSSqlRealProjectTable( this );
		tableRelation = new CFBamMSSqlRelationTable( this );
		tableRelationCol = new CFBamMSSqlRelationColTable( this );
		tableRelationType = new CFBamMSSqlRelationTypeTable( this );
		tableSchemaDef = new CFBamMSSqlSchemaDefTable( this );
		tableSchemaRef = new CFBamMSSqlSchemaRefTable( this );
		tableScope = new CFBamMSSqlScopeTable( this );
		tableSecApp = new CFBamMSSqlSecAppTable( this );
		tableSecDevice = new CFBamMSSqlSecDeviceTable( this );
		tableSecForm = new CFBamMSSqlSecFormTable( this );
		tableSecGroup = new CFBamMSSqlSecGroupTable( this );
		tableSecGroupForm = new CFBamMSSqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamMSSqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamMSSqlSecGroupMemberTable( this );
		tableSecSession = new CFBamMSSqlSecSessionTable( this );
		tableSecUser = new CFBamMSSqlSecUserTable( this );
		tableSecurityScope = new CFBamMSSqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamMSSqlServerListFuncTable( this );
		tableServerMethod = new CFBamMSSqlServerMethodTable( this );
		tableServerObjFunc = new CFBamMSSqlServerObjFuncTable( this );
		tableServerProc = new CFBamMSSqlServerProcTable( this );
		tableService = new CFBamMSSqlServiceTable( this );
		tableServiceType = new CFBamMSSqlServiceTypeTable( this );
		tableStringCol = new CFBamMSSqlStringColTable( this );
		tableStringDef = new CFBamMSSqlStringDefTable( this );
		tableStringType = new CFBamMSSqlStringTypeTable( this );
		tableSubProject = new CFBamMSSqlSubProjectTable( this );
		tableSysCluster = new CFBamMSSqlSysClusterTable( this );
		tableTSecGroup = new CFBamMSSqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamMSSqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamMSSqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamMSSqlTZDateColTable( this );
		tableTZDateDef = new CFBamMSSqlTZDateDefTable( this );
		tableTZDateType = new CFBamMSSqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamMSSqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamMSSqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamMSSqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamMSSqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamMSSqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamMSSqlTZTimestampTypeTable( this );
		tableTable = new CFBamMSSqlTableTable( this );
		tableTableCol = new CFBamMSSqlTableColTable( this );
		tableTenant = new CFBamMSSqlTenantTable( this );
		tableTextCol = new CFBamMSSqlTextColTable( this );
		tableTextDef = new CFBamMSSqlTextDefTable( this );
		tableTextType = new CFBamMSSqlTextTypeTable( this );
		tableTimeCol = new CFBamMSSqlTimeColTable( this );
		tableTimeDef = new CFBamMSSqlTimeDefTable( this );
		tableTimeType = new CFBamMSSqlTimeTypeTable( this );
		tableTimestampCol = new CFBamMSSqlTimestampColTable( this );
		tableTimestampDef = new CFBamMSSqlTimestampDefTable( this );
		tableTimestampType = new CFBamMSSqlTimestampTypeTable( this );
		tableTld = new CFBamMSSqlTldTable( this );
		tableTokenCol = new CFBamMSSqlTokenColTable( this );
		tableTokenDef = new CFBamMSSqlTokenDefTable( this );
		tableTokenType = new CFBamMSSqlTokenTypeTable( this );
		tableTopDomain = new CFBamMSSqlTopDomainTable( this );
		tableTopProject = new CFBamMSSqlTopProjectTable( this );
		tableUInt16Col = new CFBamMSSqlUInt16ColTable( this );
		tableUInt16Def = new CFBamMSSqlUInt16DefTable( this );
		tableUInt16Type = new CFBamMSSqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamMSSqlUInt32ColTable( this );
		tableUInt32Def = new CFBamMSSqlUInt32DefTable( this );
		tableUInt32Type = new CFBamMSSqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamMSSqlUInt64ColTable( this );
		tableUInt64Def = new CFBamMSSqlUInt64DefTable( this );
		tableUInt64Type = new CFBamMSSqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamMSSqlURLProtocolTable( this );
		tableUuidCol = new CFBamMSSqlUuidColTable( this );
		tableUuidDef = new CFBamMSSqlUuidDefTable( this );
		tableUuidGen = new CFBamMSSqlUuidGenTable( this );
		tableUuidType = new CFBamMSSqlUuidTypeTable( this );
		tableValue = new CFBamMSSqlValueTable( this );
		tableVersion = new CFBamMSSqlVersionTable( this );
	}

	public CFBamMSSqlSchema( CFBamConfigurationFile conf ) {
		super( conf );
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamMSSqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamMSSqlAccessSecurityTable( this );
		tableAtom = new CFBamMSSqlAtomTable( this );
		tableAuditAction = new CFBamMSSqlAuditActionTable( this );
		tableBlobCol = new CFBamMSSqlBlobColTable( this );
		tableBlobDef = new CFBamMSSqlBlobDefTable( this );
		tableBlobType = new CFBamMSSqlBlobTypeTable( this );
		tableBoolCol = new CFBamMSSqlBoolColTable( this );
		tableBoolDef = new CFBamMSSqlBoolDefTable( this );
		tableBoolType = new CFBamMSSqlBoolTypeTable( this );
		tableChain = new CFBamMSSqlChainTable( this );
		tableClearDep = new CFBamMSSqlClearDepTable( this );
		tableClearSubDep1 = new CFBamMSSqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamMSSqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamMSSqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamMSSqlClearTopDepTable( this );
		tableCluster = new CFBamMSSqlClusterTable( this );
		tableDataScope = new CFBamMSSqlDataScopeTable( this );
		tableDateCol = new CFBamMSSqlDateColTable( this );
		tableDateDef = new CFBamMSSqlDateDefTable( this );
		tableDateType = new CFBamMSSqlDateTypeTable( this );
		tableDelDep = new CFBamMSSqlDelDepTable( this );
		tableDelSubDep1 = new CFBamMSSqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamMSSqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamMSSqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamMSSqlDelTopDepTable( this );
		tableDomain = new CFBamMSSqlDomainTable( this );
		tableDomainBase = new CFBamMSSqlDomainBaseTable( this );
		tableDoubleCol = new CFBamMSSqlDoubleColTable( this );
		tableDoubleDef = new CFBamMSSqlDoubleDefTable( this );
		tableDoubleType = new CFBamMSSqlDoubleTypeTable( this );
		tableEnumCol = new CFBamMSSqlEnumColTable( this );
		tableEnumDef = new CFBamMSSqlEnumDefTable( this );
		tableEnumTag = new CFBamMSSqlEnumTagTable( this );
		tableEnumType = new CFBamMSSqlEnumTypeTable( this );
		tableFloatCol = new CFBamMSSqlFloatColTable( this );
		tableFloatDef = new CFBamMSSqlFloatDefTable( this );
		tableFloatType = new CFBamMSSqlFloatTypeTable( this );
		tableHostNode = new CFBamMSSqlHostNodeTable( this );
		tableISOCountry = new CFBamMSSqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamMSSqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamMSSqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamMSSqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamMSSqlISOLanguageTable( this );
		tableISOTimezone = new CFBamMSSqlISOTimezoneTable( this );
		tableId16Gen = new CFBamMSSqlId16GenTable( this );
		tableId32Gen = new CFBamMSSqlId32GenTable( this );
		tableId64Gen = new CFBamMSSqlId64GenTable( this );
		tableIndex = new CFBamMSSqlIndexTable( this );
		tableIndexCol = new CFBamMSSqlIndexColTable( this );
		tableInt16Col = new CFBamMSSqlInt16ColTable( this );
		tableInt16Def = new CFBamMSSqlInt16DefTable( this );
		tableInt16Type = new CFBamMSSqlInt16TypeTable( this );
		tableInt32Col = new CFBamMSSqlInt32ColTable( this );
		tableInt32Def = new CFBamMSSqlInt32DefTable( this );
		tableInt32Type = new CFBamMSSqlInt32TypeTable( this );
		tableInt64Col = new CFBamMSSqlInt64ColTable( this );
		tableInt64Def = new CFBamMSSqlInt64DefTable( this );
		tableInt64Type = new CFBamMSSqlInt64TypeTable( this );
		tableLicense = new CFBamMSSqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamMSSqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamMSSqlMajorVersionTable( this );
		tableMimeType = new CFBamMSSqlMimeTypeTable( this );
		tableMinorVersion = new CFBamMSSqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamMSSqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamMSSqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamMSSqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamMSSqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamMSSqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamMSSqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamMSSqlNumberColTable( this );
		tableNumberDef = new CFBamMSSqlNumberDefTable( this );
		tableNumberType = new CFBamMSSqlNumberTypeTable( this );
		tableParam = new CFBamMSSqlParamTable( this );
		tablePopDep = new CFBamMSSqlPopDepTable( this );
		tablePopSubDep1 = new CFBamMSSqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamMSSqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamMSSqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamMSSqlPopTopDepTable( this );
		tableProjectBase = new CFBamMSSqlProjectBaseTable( this );
		tableRealProject = new CFBamMSSqlRealProjectTable( this );
		tableRelation = new CFBamMSSqlRelationTable( this );
		tableRelationCol = new CFBamMSSqlRelationColTable( this );
		tableRelationType = new CFBamMSSqlRelationTypeTable( this );
		tableSchemaDef = new CFBamMSSqlSchemaDefTable( this );
		tableSchemaRef = new CFBamMSSqlSchemaRefTable( this );
		tableScope = new CFBamMSSqlScopeTable( this );
		tableSecApp = new CFBamMSSqlSecAppTable( this );
		tableSecDevice = new CFBamMSSqlSecDeviceTable( this );
		tableSecForm = new CFBamMSSqlSecFormTable( this );
		tableSecGroup = new CFBamMSSqlSecGroupTable( this );
		tableSecGroupForm = new CFBamMSSqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamMSSqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamMSSqlSecGroupMemberTable( this );
		tableSecSession = new CFBamMSSqlSecSessionTable( this );
		tableSecUser = new CFBamMSSqlSecUserTable( this );
		tableSecurityScope = new CFBamMSSqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamMSSqlServerListFuncTable( this );
		tableServerMethod = new CFBamMSSqlServerMethodTable( this );
		tableServerObjFunc = new CFBamMSSqlServerObjFuncTable( this );
		tableServerProc = new CFBamMSSqlServerProcTable( this );
		tableService = new CFBamMSSqlServiceTable( this );
		tableServiceType = new CFBamMSSqlServiceTypeTable( this );
		tableStringCol = new CFBamMSSqlStringColTable( this );
		tableStringDef = new CFBamMSSqlStringDefTable( this );
		tableStringType = new CFBamMSSqlStringTypeTable( this );
		tableSubProject = new CFBamMSSqlSubProjectTable( this );
		tableSysCluster = new CFBamMSSqlSysClusterTable( this );
		tableTSecGroup = new CFBamMSSqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamMSSqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamMSSqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamMSSqlTZDateColTable( this );
		tableTZDateDef = new CFBamMSSqlTZDateDefTable( this );
		tableTZDateType = new CFBamMSSqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamMSSqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamMSSqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamMSSqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamMSSqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamMSSqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamMSSqlTZTimestampTypeTable( this );
		tableTable = new CFBamMSSqlTableTable( this );
		tableTableCol = new CFBamMSSqlTableColTable( this );
		tableTenant = new CFBamMSSqlTenantTable( this );
		tableTextCol = new CFBamMSSqlTextColTable( this );
		tableTextDef = new CFBamMSSqlTextDefTable( this );
		tableTextType = new CFBamMSSqlTextTypeTable( this );
		tableTimeCol = new CFBamMSSqlTimeColTable( this );
		tableTimeDef = new CFBamMSSqlTimeDefTable( this );
		tableTimeType = new CFBamMSSqlTimeTypeTable( this );
		tableTimestampCol = new CFBamMSSqlTimestampColTable( this );
		tableTimestampDef = new CFBamMSSqlTimestampDefTable( this );
		tableTimestampType = new CFBamMSSqlTimestampTypeTable( this );
		tableTld = new CFBamMSSqlTldTable( this );
		tableTokenCol = new CFBamMSSqlTokenColTable( this );
		tableTokenDef = new CFBamMSSqlTokenDefTable( this );
		tableTokenType = new CFBamMSSqlTokenTypeTable( this );
		tableTopDomain = new CFBamMSSqlTopDomainTable( this );
		tableTopProject = new CFBamMSSqlTopProjectTable( this );
		tableUInt16Col = new CFBamMSSqlUInt16ColTable( this );
		tableUInt16Def = new CFBamMSSqlUInt16DefTable( this );
		tableUInt16Type = new CFBamMSSqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamMSSqlUInt32ColTable( this );
		tableUInt32Def = new CFBamMSSqlUInt32DefTable( this );
		tableUInt32Type = new CFBamMSSqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamMSSqlUInt64ColTable( this );
		tableUInt64Def = new CFBamMSSqlUInt64DefTable( this );
		tableUInt64Type = new CFBamMSSqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamMSSqlURLProtocolTable( this );
		tableUuidCol = new CFBamMSSqlUuidColTable( this );
		tableUuidDef = new CFBamMSSqlUuidDefTable( this );
		tableUuidGen = new CFBamMSSqlUuidGenTable( this );
		tableUuidType = new CFBamMSSqlUuidTypeTable( this );
		tableValue = new CFBamMSSqlValueTable( this );
		tableVersion = new CFBamMSSqlVersionTable( this );
		setDbSchemaName( conf.getDbDatabase() );
	}

	public CFBamMSSqlSchema( String argJndiName ) {
		super( argJndiName );
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamMSSqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamMSSqlAccessSecurityTable( this );
		tableAtom = new CFBamMSSqlAtomTable( this );
		tableAuditAction = new CFBamMSSqlAuditActionTable( this );
		tableBlobCol = new CFBamMSSqlBlobColTable( this );
		tableBlobDef = new CFBamMSSqlBlobDefTable( this );
		tableBlobType = new CFBamMSSqlBlobTypeTable( this );
		tableBoolCol = new CFBamMSSqlBoolColTable( this );
		tableBoolDef = new CFBamMSSqlBoolDefTable( this );
		tableBoolType = new CFBamMSSqlBoolTypeTable( this );
		tableChain = new CFBamMSSqlChainTable( this );
		tableClearDep = new CFBamMSSqlClearDepTable( this );
		tableClearSubDep1 = new CFBamMSSqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamMSSqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamMSSqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamMSSqlClearTopDepTable( this );
		tableCluster = new CFBamMSSqlClusterTable( this );
		tableDataScope = new CFBamMSSqlDataScopeTable( this );
		tableDateCol = new CFBamMSSqlDateColTable( this );
		tableDateDef = new CFBamMSSqlDateDefTable( this );
		tableDateType = new CFBamMSSqlDateTypeTable( this );
		tableDelDep = new CFBamMSSqlDelDepTable( this );
		tableDelSubDep1 = new CFBamMSSqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamMSSqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamMSSqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamMSSqlDelTopDepTable( this );
		tableDomain = new CFBamMSSqlDomainTable( this );
		tableDomainBase = new CFBamMSSqlDomainBaseTable( this );
		tableDoubleCol = new CFBamMSSqlDoubleColTable( this );
		tableDoubleDef = new CFBamMSSqlDoubleDefTable( this );
		tableDoubleType = new CFBamMSSqlDoubleTypeTable( this );
		tableEnumCol = new CFBamMSSqlEnumColTable( this );
		tableEnumDef = new CFBamMSSqlEnumDefTable( this );
		tableEnumTag = new CFBamMSSqlEnumTagTable( this );
		tableEnumType = new CFBamMSSqlEnumTypeTable( this );
		tableFloatCol = new CFBamMSSqlFloatColTable( this );
		tableFloatDef = new CFBamMSSqlFloatDefTable( this );
		tableFloatType = new CFBamMSSqlFloatTypeTable( this );
		tableHostNode = new CFBamMSSqlHostNodeTable( this );
		tableISOCountry = new CFBamMSSqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamMSSqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamMSSqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamMSSqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamMSSqlISOLanguageTable( this );
		tableISOTimezone = new CFBamMSSqlISOTimezoneTable( this );
		tableId16Gen = new CFBamMSSqlId16GenTable( this );
		tableId32Gen = new CFBamMSSqlId32GenTable( this );
		tableId64Gen = new CFBamMSSqlId64GenTable( this );
		tableIndex = new CFBamMSSqlIndexTable( this );
		tableIndexCol = new CFBamMSSqlIndexColTable( this );
		tableInt16Col = new CFBamMSSqlInt16ColTable( this );
		tableInt16Def = new CFBamMSSqlInt16DefTable( this );
		tableInt16Type = new CFBamMSSqlInt16TypeTable( this );
		tableInt32Col = new CFBamMSSqlInt32ColTable( this );
		tableInt32Def = new CFBamMSSqlInt32DefTable( this );
		tableInt32Type = new CFBamMSSqlInt32TypeTable( this );
		tableInt64Col = new CFBamMSSqlInt64ColTable( this );
		tableInt64Def = new CFBamMSSqlInt64DefTable( this );
		tableInt64Type = new CFBamMSSqlInt64TypeTable( this );
		tableLicense = new CFBamMSSqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamMSSqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamMSSqlMajorVersionTable( this );
		tableMimeType = new CFBamMSSqlMimeTypeTable( this );
		tableMinorVersion = new CFBamMSSqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamMSSqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamMSSqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamMSSqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamMSSqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamMSSqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamMSSqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamMSSqlNumberColTable( this );
		tableNumberDef = new CFBamMSSqlNumberDefTable( this );
		tableNumberType = new CFBamMSSqlNumberTypeTable( this );
		tableParam = new CFBamMSSqlParamTable( this );
		tablePopDep = new CFBamMSSqlPopDepTable( this );
		tablePopSubDep1 = new CFBamMSSqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamMSSqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamMSSqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamMSSqlPopTopDepTable( this );
		tableProjectBase = new CFBamMSSqlProjectBaseTable( this );
		tableRealProject = new CFBamMSSqlRealProjectTable( this );
		tableRelation = new CFBamMSSqlRelationTable( this );
		tableRelationCol = new CFBamMSSqlRelationColTable( this );
		tableRelationType = new CFBamMSSqlRelationTypeTable( this );
		tableSchemaDef = new CFBamMSSqlSchemaDefTable( this );
		tableSchemaRef = new CFBamMSSqlSchemaRefTable( this );
		tableScope = new CFBamMSSqlScopeTable( this );
		tableSecApp = new CFBamMSSqlSecAppTable( this );
		tableSecDevice = new CFBamMSSqlSecDeviceTable( this );
		tableSecForm = new CFBamMSSqlSecFormTable( this );
		tableSecGroup = new CFBamMSSqlSecGroupTable( this );
		tableSecGroupForm = new CFBamMSSqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamMSSqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamMSSqlSecGroupMemberTable( this );
		tableSecSession = new CFBamMSSqlSecSessionTable( this );
		tableSecUser = new CFBamMSSqlSecUserTable( this );
		tableSecurityScope = new CFBamMSSqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamMSSqlServerListFuncTable( this );
		tableServerMethod = new CFBamMSSqlServerMethodTable( this );
		tableServerObjFunc = new CFBamMSSqlServerObjFuncTable( this );
		tableServerProc = new CFBamMSSqlServerProcTable( this );
		tableService = new CFBamMSSqlServiceTable( this );
		tableServiceType = new CFBamMSSqlServiceTypeTable( this );
		tableStringCol = new CFBamMSSqlStringColTable( this );
		tableStringDef = new CFBamMSSqlStringDefTable( this );
		tableStringType = new CFBamMSSqlStringTypeTable( this );
		tableSubProject = new CFBamMSSqlSubProjectTable( this );
		tableSysCluster = new CFBamMSSqlSysClusterTable( this );
		tableTSecGroup = new CFBamMSSqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamMSSqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamMSSqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamMSSqlTZDateColTable( this );
		tableTZDateDef = new CFBamMSSqlTZDateDefTable( this );
		tableTZDateType = new CFBamMSSqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamMSSqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamMSSqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamMSSqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamMSSqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamMSSqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamMSSqlTZTimestampTypeTable( this );
		tableTable = new CFBamMSSqlTableTable( this );
		tableTableCol = new CFBamMSSqlTableColTable( this );
		tableTenant = new CFBamMSSqlTenantTable( this );
		tableTextCol = new CFBamMSSqlTextColTable( this );
		tableTextDef = new CFBamMSSqlTextDefTable( this );
		tableTextType = new CFBamMSSqlTextTypeTable( this );
		tableTimeCol = new CFBamMSSqlTimeColTable( this );
		tableTimeDef = new CFBamMSSqlTimeDefTable( this );
		tableTimeType = new CFBamMSSqlTimeTypeTable( this );
		tableTimestampCol = new CFBamMSSqlTimestampColTable( this );
		tableTimestampDef = new CFBamMSSqlTimestampDefTable( this );
		tableTimestampType = new CFBamMSSqlTimestampTypeTable( this );
		tableTld = new CFBamMSSqlTldTable( this );
		tableTokenCol = new CFBamMSSqlTokenColTable( this );
		tableTokenDef = new CFBamMSSqlTokenDefTable( this );
		tableTokenType = new CFBamMSSqlTokenTypeTable( this );
		tableTopDomain = new CFBamMSSqlTopDomainTable( this );
		tableTopProject = new CFBamMSSqlTopProjectTable( this );
		tableUInt16Col = new CFBamMSSqlUInt16ColTable( this );
		tableUInt16Def = new CFBamMSSqlUInt16DefTable( this );
		tableUInt16Type = new CFBamMSSqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamMSSqlUInt32ColTable( this );
		tableUInt32Def = new CFBamMSSqlUInt32DefTable( this );
		tableUInt32Type = new CFBamMSSqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamMSSqlUInt64ColTable( this );
		tableUInt64Def = new CFBamMSSqlUInt64DefTable( this );
		tableUInt64Type = new CFBamMSSqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamMSSqlURLProtocolTable( this );
		tableUuidCol = new CFBamMSSqlUuidColTable( this );
		tableUuidDef = new CFBamMSSqlUuidDefTable( this );
		tableUuidGen = new CFBamMSSqlUuidGenTable( this );
		tableUuidType = new CFBamMSSqlUuidTypeTable( this );
		tableValue = new CFBamMSSqlValueTable( this );
		tableVersion = new CFBamMSSqlVersionTable( this );
	}

	public CFBamMSSqlSchema( Connection argCnx ) {
		super();
		cnx = argCnx;
		inTransaction = false;
		tableAccessFrequency = new CFBamMSSqlAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamMSSqlAccessSecurityTable( this );
		tableAtom = new CFBamMSSqlAtomTable( this );
		tableAuditAction = new CFBamMSSqlAuditActionTable( this );
		tableBlobCol = new CFBamMSSqlBlobColTable( this );
		tableBlobDef = new CFBamMSSqlBlobDefTable( this );
		tableBlobType = new CFBamMSSqlBlobTypeTable( this );
		tableBoolCol = new CFBamMSSqlBoolColTable( this );
		tableBoolDef = new CFBamMSSqlBoolDefTable( this );
		tableBoolType = new CFBamMSSqlBoolTypeTable( this );
		tableChain = new CFBamMSSqlChainTable( this );
		tableClearDep = new CFBamMSSqlClearDepTable( this );
		tableClearSubDep1 = new CFBamMSSqlClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamMSSqlClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamMSSqlClearSubDep3Table( this );
		tableClearTopDep = new CFBamMSSqlClearTopDepTable( this );
		tableCluster = new CFBamMSSqlClusterTable( this );
		tableDataScope = new CFBamMSSqlDataScopeTable( this );
		tableDateCol = new CFBamMSSqlDateColTable( this );
		tableDateDef = new CFBamMSSqlDateDefTable( this );
		tableDateType = new CFBamMSSqlDateTypeTable( this );
		tableDelDep = new CFBamMSSqlDelDepTable( this );
		tableDelSubDep1 = new CFBamMSSqlDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamMSSqlDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamMSSqlDelSubDep3Table( this );
		tableDelTopDep = new CFBamMSSqlDelTopDepTable( this );
		tableDomain = new CFBamMSSqlDomainTable( this );
		tableDomainBase = new CFBamMSSqlDomainBaseTable( this );
		tableDoubleCol = new CFBamMSSqlDoubleColTable( this );
		tableDoubleDef = new CFBamMSSqlDoubleDefTable( this );
		tableDoubleType = new CFBamMSSqlDoubleTypeTable( this );
		tableEnumCol = new CFBamMSSqlEnumColTable( this );
		tableEnumDef = new CFBamMSSqlEnumDefTable( this );
		tableEnumTag = new CFBamMSSqlEnumTagTable( this );
		tableEnumType = new CFBamMSSqlEnumTypeTable( this );
		tableFloatCol = new CFBamMSSqlFloatColTable( this );
		tableFloatDef = new CFBamMSSqlFloatDefTable( this );
		tableFloatType = new CFBamMSSqlFloatTypeTable( this );
		tableHostNode = new CFBamMSSqlHostNodeTable( this );
		tableISOCountry = new CFBamMSSqlISOCountryTable( this );
		tableISOCountryCurrency = new CFBamMSSqlISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamMSSqlISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamMSSqlISOCurrencyTable( this );
		tableISOLanguage = new CFBamMSSqlISOLanguageTable( this );
		tableISOTimezone = new CFBamMSSqlISOTimezoneTable( this );
		tableId16Gen = new CFBamMSSqlId16GenTable( this );
		tableId32Gen = new CFBamMSSqlId32GenTable( this );
		tableId64Gen = new CFBamMSSqlId64GenTable( this );
		tableIndex = new CFBamMSSqlIndexTable( this );
		tableIndexCol = new CFBamMSSqlIndexColTable( this );
		tableInt16Col = new CFBamMSSqlInt16ColTable( this );
		tableInt16Def = new CFBamMSSqlInt16DefTable( this );
		tableInt16Type = new CFBamMSSqlInt16TypeTable( this );
		tableInt32Col = new CFBamMSSqlInt32ColTable( this );
		tableInt32Def = new CFBamMSSqlInt32DefTable( this );
		tableInt32Type = new CFBamMSSqlInt32TypeTable( this );
		tableInt64Col = new CFBamMSSqlInt64ColTable( this );
		tableInt64Def = new CFBamMSSqlInt64DefTable( this );
		tableInt64Type = new CFBamMSSqlInt64TypeTable( this );
		tableLicense = new CFBamMSSqlLicenseTable( this );
		tableLoaderBehaviour = new CFBamMSSqlLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamMSSqlMajorVersionTable( this );
		tableMimeType = new CFBamMSSqlMimeTypeTable( this );
		tableMinorVersion = new CFBamMSSqlMinorVersionTable( this );
		tableNmTokenCol = new CFBamMSSqlNmTokenColTable( this );
		tableNmTokenDef = new CFBamMSSqlNmTokenDefTable( this );
		tableNmTokenType = new CFBamMSSqlNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamMSSqlNmTokensColTable( this );
		tableNmTokensDef = new CFBamMSSqlNmTokensDefTable( this );
		tableNmTokensType = new CFBamMSSqlNmTokensTypeTable( this );
		tableNumberCol = new CFBamMSSqlNumberColTable( this );
		tableNumberDef = new CFBamMSSqlNumberDefTable( this );
		tableNumberType = new CFBamMSSqlNumberTypeTable( this );
		tableParam = new CFBamMSSqlParamTable( this );
		tablePopDep = new CFBamMSSqlPopDepTable( this );
		tablePopSubDep1 = new CFBamMSSqlPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamMSSqlPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamMSSqlPopSubDep3Table( this );
		tablePopTopDep = new CFBamMSSqlPopTopDepTable( this );
		tableProjectBase = new CFBamMSSqlProjectBaseTable( this );
		tableRealProject = new CFBamMSSqlRealProjectTable( this );
		tableRelation = new CFBamMSSqlRelationTable( this );
		tableRelationCol = new CFBamMSSqlRelationColTable( this );
		tableRelationType = new CFBamMSSqlRelationTypeTable( this );
		tableSchemaDef = new CFBamMSSqlSchemaDefTable( this );
		tableSchemaRef = new CFBamMSSqlSchemaRefTable( this );
		tableScope = new CFBamMSSqlScopeTable( this );
		tableSecApp = new CFBamMSSqlSecAppTable( this );
		tableSecDevice = new CFBamMSSqlSecDeviceTable( this );
		tableSecForm = new CFBamMSSqlSecFormTable( this );
		tableSecGroup = new CFBamMSSqlSecGroupTable( this );
		tableSecGroupForm = new CFBamMSSqlSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamMSSqlSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamMSSqlSecGroupMemberTable( this );
		tableSecSession = new CFBamMSSqlSecSessionTable( this );
		tableSecUser = new CFBamMSSqlSecUserTable( this );
		tableSecurityScope = new CFBamMSSqlSecurityScopeTable( this );
		tableServerListFunc = new CFBamMSSqlServerListFuncTable( this );
		tableServerMethod = new CFBamMSSqlServerMethodTable( this );
		tableServerObjFunc = new CFBamMSSqlServerObjFuncTable( this );
		tableServerProc = new CFBamMSSqlServerProcTable( this );
		tableService = new CFBamMSSqlServiceTable( this );
		tableServiceType = new CFBamMSSqlServiceTypeTable( this );
		tableStringCol = new CFBamMSSqlStringColTable( this );
		tableStringDef = new CFBamMSSqlStringDefTable( this );
		tableStringType = new CFBamMSSqlStringTypeTable( this );
		tableSubProject = new CFBamMSSqlSubProjectTable( this );
		tableSysCluster = new CFBamMSSqlSysClusterTable( this );
		tableTSecGroup = new CFBamMSSqlTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamMSSqlTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamMSSqlTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamMSSqlTZDateColTable( this );
		tableTZDateDef = new CFBamMSSqlTZDateDefTable( this );
		tableTZDateType = new CFBamMSSqlTZDateTypeTable( this );
		tableTZTimeCol = new CFBamMSSqlTZTimeColTable( this );
		tableTZTimeDef = new CFBamMSSqlTZTimeDefTable( this );
		tableTZTimeType = new CFBamMSSqlTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamMSSqlTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamMSSqlTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamMSSqlTZTimestampTypeTable( this );
		tableTable = new CFBamMSSqlTableTable( this );
		tableTableCol = new CFBamMSSqlTableColTable( this );
		tableTenant = new CFBamMSSqlTenantTable( this );
		tableTextCol = new CFBamMSSqlTextColTable( this );
		tableTextDef = new CFBamMSSqlTextDefTable( this );
		tableTextType = new CFBamMSSqlTextTypeTable( this );
		tableTimeCol = new CFBamMSSqlTimeColTable( this );
		tableTimeDef = new CFBamMSSqlTimeDefTable( this );
		tableTimeType = new CFBamMSSqlTimeTypeTable( this );
		tableTimestampCol = new CFBamMSSqlTimestampColTable( this );
		tableTimestampDef = new CFBamMSSqlTimestampDefTable( this );
		tableTimestampType = new CFBamMSSqlTimestampTypeTable( this );
		tableTld = new CFBamMSSqlTldTable( this );
		tableTokenCol = new CFBamMSSqlTokenColTable( this );
		tableTokenDef = new CFBamMSSqlTokenDefTable( this );
		tableTokenType = new CFBamMSSqlTokenTypeTable( this );
		tableTopDomain = new CFBamMSSqlTopDomainTable( this );
		tableTopProject = new CFBamMSSqlTopProjectTable( this );
		tableUInt16Col = new CFBamMSSqlUInt16ColTable( this );
		tableUInt16Def = new CFBamMSSqlUInt16DefTable( this );
		tableUInt16Type = new CFBamMSSqlUInt16TypeTable( this );
		tableUInt32Col = new CFBamMSSqlUInt32ColTable( this );
		tableUInt32Def = new CFBamMSSqlUInt32DefTable( this );
		tableUInt32Type = new CFBamMSSqlUInt32TypeTable( this );
		tableUInt64Col = new CFBamMSSqlUInt64ColTable( this );
		tableUInt64Def = new CFBamMSSqlUInt64DefTable( this );
		tableUInt64Type = new CFBamMSSqlUInt64TypeTable( this );
		tableURLProtocol = new CFBamMSSqlURLProtocolTable( this );
		tableUuidCol = new CFBamMSSqlUuidColTable( this );
		tableUuidDef = new CFBamMSSqlUuidDefTable( this );
		tableUuidGen = new CFBamMSSqlUuidGenTable( this );
		tableUuidType = new CFBamMSSqlUuidTypeTable( this );
		tableValue = new CFBamMSSqlValueTable( this );
		tableVersion = new CFBamMSSqlVersionTable( this );
		try {
			cnx.setAutoCommit( false );
			cnx.rollback();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"CFBamMSSqlSchema-constructor",
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
				Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
			}
			catch( ClassNotFoundException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"connect",
					"Could not load MS SQL Server 2012 Express Advanced Edition driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = configuration.getDbUserName();
			String dbPassword = configuration.getDbPassword();
			String url =
					"jdbc:sqlserver://" + dbServer
				+	":" + Integer.toString( dbPort ) + ";";
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
					S_ProcName + "<<connect>>",
					e );
			}
			Statement stmtUseDatabase = null;
			try {
				stmtUseDatabase = cnx.createStatement();
				stmtUseDatabase.executeUpdate( "use " + dbDatabase );
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName + "<<useDatabase>>",
					e );
			}
			finally {
				if( stmtUseDatabase != null ) {
					try {
						stmtUseDatabase.close();
					}
					catch( SQLException e ) {
					}
					stmtUseDatabase = null;
				}
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
					S_ProcName + "<<jndiGetConnection>>",
					"NamingException " + e.getMessage(),
					e );
			}
			catch( SQLException e ) {
				cnx = null;
				inTransaction = false;
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName + "<<jndiGetConnection>>",
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
			try {
				Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
			}
			catch( ClassNotFoundException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"connect",
					"Could not load MS SQL Server 2012 Express Advanced Edition driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = username;
			String dbPassword = password;
			String url =
					"jdbc:sqlserver://" + dbServer
				+	":" + Integer.toString( dbPort ) + ";";
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
					S_ProcName + "<<connect>>",
					e );
			}
			Statement stmtUseDatabase = null;
			try {
				stmtUseDatabase = cnx.createStatement();
				stmtUseDatabase.executeUpdate( "use " + dbDatabase );
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName + "<<useDatabase>>",
					e );
			}
			finally {
				if( stmtUseDatabase != null ) {
					try {
						stmtUseDatabase.close();
					}
					catch( SQLException e ) {
					}
					stmtUseDatabase = null;
				}
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
					releasePreparedStatements();
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
			final String sql = "begin transaction";
			if( stmtBeginTransaction == null ) {
				stmtBeginTransaction = cnx.prepareStatement( sql );
			}
			stmtBeginTransaction.execute();
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

	public boolean isSystemUser( CFBamAuthorization Authorization ) {
		final String S_ProcName = "isSystemUser";
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		CallableStatement stmtSecurityCheck = null;
		try {
			final String sql = "exec sp_is_system_user ?, ?";
			stmtSecurityCheck = cnx.prepareCall( sql );
			stmtSecurityCheck.registerOutParameter( 1, java.sql.Types.INTEGER );
			stmtSecurityCheck.setString( 2, Authorization.getSecUserId().toString() );
			stmtSecurityCheck.execute();
			int isAuthorized = stmtSecurityCheck.getInt( 1 );
			if( isAuthorized == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSecurityCheck != null ) {
				try {
					stmtSecurityCheck.close();
				}
				catch( SQLException e ) {
				}
				stmtSecurityCheck = null;
			}
		}
	}

	public boolean isClusterUser( CFBamAuthorization Authorization,
		long clusterId,
		String secGroupName )
	{
		final String S_ProcName = "isClusterUser";
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		CallableStatement stmtSecurityCheck = null;
		try {
			final String sql = "exec sp_is_cluster_user ?, ?, ?, ?";
			stmtSecurityCheck = cnx.prepareCall( sql );
			stmtSecurityCheck.registerOutParameter( 1, java.sql.Types.INTEGER );
			stmtSecurityCheck.setLong( 2, clusterId );
			stmtSecurityCheck.setString( 3, secGroupName );
			stmtSecurityCheck.setString( 4, Authorization.getSecUserId().toString() );
			stmtSecurityCheck.execute();
			int isAuthorized = stmtSecurityCheck.getInt( 1 );
			if( isAuthorized == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSecurityCheck != null ) {
				try {
					stmtSecurityCheck.close();
				}
				catch( SQLException e ) {
				}
				stmtSecurityCheck = null;
			}
		}
	}

	public boolean isTenantUser( CFBamAuthorization Authorization,
		long tenantId,
		String secGroupName )
	{
		final String S_ProcName = "isTenantUser";
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		CallableStatement stmtSecurityCheck = null;
		try {
			final String sql = "exec sp_is_tenant_user ?, ?, ?, ?";
			stmtSecurityCheck = cnx.prepareCall( sql );
			stmtSecurityCheck.registerOutParameter( 1, java.sql.Types.INTEGER );
			stmtSecurityCheck.setLong( 2, tenantId );
			stmtSecurityCheck.setString( 3, secGroupName );
			stmtSecurityCheck.setString( 4, Authorization.getSecUserId().toString() );
			stmtSecurityCheck.execute();
			int isAuthorized = stmtSecurityCheck.getInt( 1 );
			if( isAuthorized == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSecurityCheck != null ) {
				try {
					stmtSecurityCheck.close();
				}
				catch( SQLException e ) {
				}
				stmtSecurityCheck = null;
			}
		}
	}

	public int nextServiceTypeIdGen() {
		final String S_ProcName = "nextServiceTypeIdGen";
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		int nextId = -1;
		Statement stmtNext = null;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_servicetypeidgen";
			if( stmtSelectNextServiceTypeIdGen == null ) {
				stmtSelectNextServiceTypeIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextServiceTypeIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextServiceTypeIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextServiceTypeIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextServiceTypeIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
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
		final String S_ProcName = "nextMimeTypeIdGen";
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		int nextId = -1;
		Statement stmtNext = null;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_mimetypeidgen";
			if( stmtSelectNextMimeTypeIdGen == null ) {
				stmtSelectNextMimeTypeIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextMimeTypeIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextMimeTypeIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextMimeTypeIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextMimeTypeIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
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
		final String S_ProcName = "nextClusterIdGen";
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		long nextId = -1;
		Statement stmtNext = null;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_clusteridgen";
			if( stmtSelectNextClusterIdGen == null ) {
				stmtSelectNextClusterIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextClusterIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextClusterIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextClusterIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextClusterIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
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
		final String S_ProcName = "nextTenantIdGen";
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		long nextId = -1;
		Statement stmtNext = null;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_tenantidgen";
			if( stmtSelectNextTenantIdGen == null ) {
				stmtSelectNextTenantIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextTenantIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextTenantIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextTenantIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextTenantIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
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
		final String S_ProcName = "fileImport";

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
		if( stmtBeginTransaction != null ) {
			try {
				stmtBeginTransaction.close();
			}
			catch( SQLException e ) {
			}
			stmtBeginTransaction = null;
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

		if( ( tableAccessFrequency != null ) && ( tableAccessFrequency instanceof CFBamMSSqlAccessFrequencyTable ) ) {
			CFBamMSSqlAccessFrequencyTable table = (CFBamMSSqlAccessFrequencyTable)tableAccessFrequency;
			table.releasePreparedStatements();
		}
		if( ( tableAccessSecurity != null ) && ( tableAccessSecurity instanceof CFBamMSSqlAccessSecurityTable ) ) {
			CFBamMSSqlAccessSecurityTable table = (CFBamMSSqlAccessSecurityTable)tableAccessSecurity;
			table.releasePreparedStatements();
		}
		if( ( tableAtom != null ) && ( tableAtom instanceof CFBamMSSqlAtomTable ) ) {
			CFBamMSSqlAtomTable table = (CFBamMSSqlAtomTable)tableAtom;
			table.releasePreparedStatements();
		}
		if( ( tableAuditAction != null ) && ( tableAuditAction instanceof CFBamMSSqlAuditActionTable ) ) {
			CFBamMSSqlAuditActionTable table = (CFBamMSSqlAuditActionTable)tableAuditAction;
			table.releasePreparedStatements();
		}
		if( ( tableBlobCol != null ) && ( tableBlobCol instanceof CFBamMSSqlBlobColTable ) ) {
			CFBamMSSqlBlobColTable table = (CFBamMSSqlBlobColTable)tableBlobCol;
			table.releasePreparedStatements();
		}
		if( ( tableBlobDef != null ) && ( tableBlobDef instanceof CFBamMSSqlBlobDefTable ) ) {
			CFBamMSSqlBlobDefTable table = (CFBamMSSqlBlobDefTable)tableBlobDef;
			table.releasePreparedStatements();
		}
		if( ( tableBlobType != null ) && ( tableBlobType instanceof CFBamMSSqlBlobTypeTable ) ) {
			CFBamMSSqlBlobTypeTable table = (CFBamMSSqlBlobTypeTable)tableBlobType;
			table.releasePreparedStatements();
		}
		if( ( tableBoolCol != null ) && ( tableBoolCol instanceof CFBamMSSqlBoolColTable ) ) {
			CFBamMSSqlBoolColTable table = (CFBamMSSqlBoolColTable)tableBoolCol;
			table.releasePreparedStatements();
		}
		if( ( tableBoolDef != null ) && ( tableBoolDef instanceof CFBamMSSqlBoolDefTable ) ) {
			CFBamMSSqlBoolDefTable table = (CFBamMSSqlBoolDefTable)tableBoolDef;
			table.releasePreparedStatements();
		}
		if( ( tableBoolType != null ) && ( tableBoolType instanceof CFBamMSSqlBoolTypeTable ) ) {
			CFBamMSSqlBoolTypeTable table = (CFBamMSSqlBoolTypeTable)tableBoolType;
			table.releasePreparedStatements();
		}
		if( ( tableChain != null ) && ( tableChain instanceof CFBamMSSqlChainTable ) ) {
			CFBamMSSqlChainTable table = (CFBamMSSqlChainTable)tableChain;
			table.releasePreparedStatements();
		}
		if( ( tableClearDep != null ) && ( tableClearDep instanceof CFBamMSSqlClearDepTable ) ) {
			CFBamMSSqlClearDepTable table = (CFBamMSSqlClearDepTable)tableClearDep;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep1 != null ) && ( tableClearSubDep1 instanceof CFBamMSSqlClearSubDep1Table ) ) {
			CFBamMSSqlClearSubDep1Table table = (CFBamMSSqlClearSubDep1Table)tableClearSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep2 != null ) && ( tableClearSubDep2 instanceof CFBamMSSqlClearSubDep2Table ) ) {
			CFBamMSSqlClearSubDep2Table table = (CFBamMSSqlClearSubDep2Table)tableClearSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep3 != null ) && ( tableClearSubDep3 instanceof CFBamMSSqlClearSubDep3Table ) ) {
			CFBamMSSqlClearSubDep3Table table = (CFBamMSSqlClearSubDep3Table)tableClearSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tableClearTopDep != null ) && ( tableClearTopDep instanceof CFBamMSSqlClearTopDepTable ) ) {
			CFBamMSSqlClearTopDepTable table = (CFBamMSSqlClearTopDepTable)tableClearTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableCluster != null ) && ( tableCluster instanceof CFBamMSSqlClusterTable ) ) {
			CFBamMSSqlClusterTable table = (CFBamMSSqlClusterTable)tableCluster;
			table.releasePreparedStatements();
		}
		if( ( tableDataScope != null ) && ( tableDataScope instanceof CFBamMSSqlDataScopeTable ) ) {
			CFBamMSSqlDataScopeTable table = (CFBamMSSqlDataScopeTable)tableDataScope;
			table.releasePreparedStatements();
		}
		if( ( tableDateCol != null ) && ( tableDateCol instanceof CFBamMSSqlDateColTable ) ) {
			CFBamMSSqlDateColTable table = (CFBamMSSqlDateColTable)tableDateCol;
			table.releasePreparedStatements();
		}
		if( ( tableDateDef != null ) && ( tableDateDef instanceof CFBamMSSqlDateDefTable ) ) {
			CFBamMSSqlDateDefTable table = (CFBamMSSqlDateDefTable)tableDateDef;
			table.releasePreparedStatements();
		}
		if( ( tableDateType != null ) && ( tableDateType instanceof CFBamMSSqlDateTypeTable ) ) {
			CFBamMSSqlDateTypeTable table = (CFBamMSSqlDateTypeTable)tableDateType;
			table.releasePreparedStatements();
		}
		if( ( tableDelDep != null ) && ( tableDelDep instanceof CFBamMSSqlDelDepTable ) ) {
			CFBamMSSqlDelDepTable table = (CFBamMSSqlDelDepTable)tableDelDep;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep1 != null ) && ( tableDelSubDep1 instanceof CFBamMSSqlDelSubDep1Table ) ) {
			CFBamMSSqlDelSubDep1Table table = (CFBamMSSqlDelSubDep1Table)tableDelSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep2 != null ) && ( tableDelSubDep2 instanceof CFBamMSSqlDelSubDep2Table ) ) {
			CFBamMSSqlDelSubDep2Table table = (CFBamMSSqlDelSubDep2Table)tableDelSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep3 != null ) && ( tableDelSubDep3 instanceof CFBamMSSqlDelSubDep3Table ) ) {
			CFBamMSSqlDelSubDep3Table table = (CFBamMSSqlDelSubDep3Table)tableDelSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tableDelTopDep != null ) && ( tableDelTopDep instanceof CFBamMSSqlDelTopDepTable ) ) {
			CFBamMSSqlDelTopDepTable table = (CFBamMSSqlDelTopDepTable)tableDelTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableDomain != null ) && ( tableDomain instanceof CFBamMSSqlDomainTable ) ) {
			CFBamMSSqlDomainTable table = (CFBamMSSqlDomainTable)tableDomain;
			table.releasePreparedStatements();
		}
		if( ( tableDomainBase != null ) && ( tableDomainBase instanceof CFBamMSSqlDomainBaseTable ) ) {
			CFBamMSSqlDomainBaseTable table = (CFBamMSSqlDomainBaseTable)tableDomainBase;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleCol != null ) && ( tableDoubleCol instanceof CFBamMSSqlDoubleColTable ) ) {
			CFBamMSSqlDoubleColTable table = (CFBamMSSqlDoubleColTable)tableDoubleCol;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleDef != null ) && ( tableDoubleDef instanceof CFBamMSSqlDoubleDefTable ) ) {
			CFBamMSSqlDoubleDefTable table = (CFBamMSSqlDoubleDefTable)tableDoubleDef;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleType != null ) && ( tableDoubleType instanceof CFBamMSSqlDoubleTypeTable ) ) {
			CFBamMSSqlDoubleTypeTable table = (CFBamMSSqlDoubleTypeTable)tableDoubleType;
			table.releasePreparedStatements();
		}
		if( ( tableEnumCol != null ) && ( tableEnumCol instanceof CFBamMSSqlEnumColTable ) ) {
			CFBamMSSqlEnumColTable table = (CFBamMSSqlEnumColTable)tableEnumCol;
			table.releasePreparedStatements();
		}
		if( ( tableEnumDef != null ) && ( tableEnumDef instanceof CFBamMSSqlEnumDefTable ) ) {
			CFBamMSSqlEnumDefTable table = (CFBamMSSqlEnumDefTable)tableEnumDef;
			table.releasePreparedStatements();
		}
		if( ( tableEnumTag != null ) && ( tableEnumTag instanceof CFBamMSSqlEnumTagTable ) ) {
			CFBamMSSqlEnumTagTable table = (CFBamMSSqlEnumTagTable)tableEnumTag;
			table.releasePreparedStatements();
		}
		if( ( tableEnumType != null ) && ( tableEnumType instanceof CFBamMSSqlEnumTypeTable ) ) {
			CFBamMSSqlEnumTypeTable table = (CFBamMSSqlEnumTypeTable)tableEnumType;
			table.releasePreparedStatements();
		}
		if( ( tableFloatCol != null ) && ( tableFloatCol instanceof CFBamMSSqlFloatColTable ) ) {
			CFBamMSSqlFloatColTable table = (CFBamMSSqlFloatColTable)tableFloatCol;
			table.releasePreparedStatements();
		}
		if( ( tableFloatDef != null ) && ( tableFloatDef instanceof CFBamMSSqlFloatDefTable ) ) {
			CFBamMSSqlFloatDefTable table = (CFBamMSSqlFloatDefTable)tableFloatDef;
			table.releasePreparedStatements();
		}
		if( ( tableFloatType != null ) && ( tableFloatType instanceof CFBamMSSqlFloatTypeTable ) ) {
			CFBamMSSqlFloatTypeTable table = (CFBamMSSqlFloatTypeTable)tableFloatType;
			table.releasePreparedStatements();
		}
		if( ( tableHostNode != null ) && ( tableHostNode instanceof CFBamMSSqlHostNodeTable ) ) {
			CFBamMSSqlHostNodeTable table = (CFBamMSSqlHostNodeTable)tableHostNode;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountry != null ) && ( tableISOCountry instanceof CFBamMSSqlISOCountryTable ) ) {
			CFBamMSSqlISOCountryTable table = (CFBamMSSqlISOCountryTable)tableISOCountry;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountryCurrency != null ) && ( tableISOCountryCurrency instanceof CFBamMSSqlISOCountryCurrencyTable ) ) {
			CFBamMSSqlISOCountryCurrencyTable table = (CFBamMSSqlISOCountryCurrencyTable)tableISOCountryCurrency;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountryLanguage != null ) && ( tableISOCountryLanguage instanceof CFBamMSSqlISOCountryLanguageTable ) ) {
			CFBamMSSqlISOCountryLanguageTable table = (CFBamMSSqlISOCountryLanguageTable)tableISOCountryLanguage;
			table.releasePreparedStatements();
		}
		if( ( tableISOCurrency != null ) && ( tableISOCurrency instanceof CFBamMSSqlISOCurrencyTable ) ) {
			CFBamMSSqlISOCurrencyTable table = (CFBamMSSqlISOCurrencyTable)tableISOCurrency;
			table.releasePreparedStatements();
		}
		if( ( tableISOLanguage != null ) && ( tableISOLanguage instanceof CFBamMSSqlISOLanguageTable ) ) {
			CFBamMSSqlISOLanguageTable table = (CFBamMSSqlISOLanguageTable)tableISOLanguage;
			table.releasePreparedStatements();
		}
		if( ( tableISOTimezone != null ) && ( tableISOTimezone instanceof CFBamMSSqlISOTimezoneTable ) ) {
			CFBamMSSqlISOTimezoneTable table = (CFBamMSSqlISOTimezoneTable)tableISOTimezone;
			table.releasePreparedStatements();
		}
		if( ( tableId16Gen != null ) && ( tableId16Gen instanceof CFBamMSSqlId16GenTable ) ) {
			CFBamMSSqlId16GenTable table = (CFBamMSSqlId16GenTable)tableId16Gen;
			table.releasePreparedStatements();
		}
		if( ( tableId32Gen != null ) && ( tableId32Gen instanceof CFBamMSSqlId32GenTable ) ) {
			CFBamMSSqlId32GenTable table = (CFBamMSSqlId32GenTable)tableId32Gen;
			table.releasePreparedStatements();
		}
		if( ( tableId64Gen != null ) && ( tableId64Gen instanceof CFBamMSSqlId64GenTable ) ) {
			CFBamMSSqlId64GenTable table = (CFBamMSSqlId64GenTable)tableId64Gen;
			table.releasePreparedStatements();
		}
		if( ( tableIndex != null ) && ( tableIndex instanceof CFBamMSSqlIndexTable ) ) {
			CFBamMSSqlIndexTable table = (CFBamMSSqlIndexTable)tableIndex;
			table.releasePreparedStatements();
		}
		if( ( tableIndexCol != null ) && ( tableIndexCol instanceof CFBamMSSqlIndexColTable ) ) {
			CFBamMSSqlIndexColTable table = (CFBamMSSqlIndexColTable)tableIndexCol;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Col != null ) && ( tableInt16Col instanceof CFBamMSSqlInt16ColTable ) ) {
			CFBamMSSqlInt16ColTable table = (CFBamMSSqlInt16ColTable)tableInt16Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Def != null ) && ( tableInt16Def instanceof CFBamMSSqlInt16DefTable ) ) {
			CFBamMSSqlInt16DefTable table = (CFBamMSSqlInt16DefTable)tableInt16Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Type != null ) && ( tableInt16Type instanceof CFBamMSSqlInt16TypeTable ) ) {
			CFBamMSSqlInt16TypeTable table = (CFBamMSSqlInt16TypeTable)tableInt16Type;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Col != null ) && ( tableInt32Col instanceof CFBamMSSqlInt32ColTable ) ) {
			CFBamMSSqlInt32ColTable table = (CFBamMSSqlInt32ColTable)tableInt32Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Def != null ) && ( tableInt32Def instanceof CFBamMSSqlInt32DefTable ) ) {
			CFBamMSSqlInt32DefTable table = (CFBamMSSqlInt32DefTable)tableInt32Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Type != null ) && ( tableInt32Type instanceof CFBamMSSqlInt32TypeTable ) ) {
			CFBamMSSqlInt32TypeTable table = (CFBamMSSqlInt32TypeTable)tableInt32Type;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Col != null ) && ( tableInt64Col instanceof CFBamMSSqlInt64ColTable ) ) {
			CFBamMSSqlInt64ColTable table = (CFBamMSSqlInt64ColTable)tableInt64Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Def != null ) && ( tableInt64Def instanceof CFBamMSSqlInt64DefTable ) ) {
			CFBamMSSqlInt64DefTable table = (CFBamMSSqlInt64DefTable)tableInt64Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Type != null ) && ( tableInt64Type instanceof CFBamMSSqlInt64TypeTable ) ) {
			CFBamMSSqlInt64TypeTable table = (CFBamMSSqlInt64TypeTable)tableInt64Type;
			table.releasePreparedStatements();
		}
		if( ( tableLicense != null ) && ( tableLicense instanceof CFBamMSSqlLicenseTable ) ) {
			CFBamMSSqlLicenseTable table = (CFBamMSSqlLicenseTable)tableLicense;
			table.releasePreparedStatements();
		}
		if( ( tableLoaderBehaviour != null ) && ( tableLoaderBehaviour instanceof CFBamMSSqlLoaderBehaviourTable ) ) {
			CFBamMSSqlLoaderBehaviourTable table = (CFBamMSSqlLoaderBehaviourTable)tableLoaderBehaviour;
			table.releasePreparedStatements();
		}
		if( ( tableMajorVersion != null ) && ( tableMajorVersion instanceof CFBamMSSqlMajorVersionTable ) ) {
			CFBamMSSqlMajorVersionTable table = (CFBamMSSqlMajorVersionTable)tableMajorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableMimeType != null ) && ( tableMimeType instanceof CFBamMSSqlMimeTypeTable ) ) {
			CFBamMSSqlMimeTypeTable table = (CFBamMSSqlMimeTypeTable)tableMimeType;
			table.releasePreparedStatements();
		}
		if( ( tableMinorVersion != null ) && ( tableMinorVersion instanceof CFBamMSSqlMinorVersionTable ) ) {
			CFBamMSSqlMinorVersionTable table = (CFBamMSSqlMinorVersionTable)tableMinorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenCol != null ) && ( tableNmTokenCol instanceof CFBamMSSqlNmTokenColTable ) ) {
			CFBamMSSqlNmTokenColTable table = (CFBamMSSqlNmTokenColTable)tableNmTokenCol;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenDef != null ) && ( tableNmTokenDef instanceof CFBamMSSqlNmTokenDefTable ) ) {
			CFBamMSSqlNmTokenDefTable table = (CFBamMSSqlNmTokenDefTable)tableNmTokenDef;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenType != null ) && ( tableNmTokenType instanceof CFBamMSSqlNmTokenTypeTable ) ) {
			CFBamMSSqlNmTokenTypeTable table = (CFBamMSSqlNmTokenTypeTable)tableNmTokenType;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensCol != null ) && ( tableNmTokensCol instanceof CFBamMSSqlNmTokensColTable ) ) {
			CFBamMSSqlNmTokensColTable table = (CFBamMSSqlNmTokensColTable)tableNmTokensCol;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensDef != null ) && ( tableNmTokensDef instanceof CFBamMSSqlNmTokensDefTable ) ) {
			CFBamMSSqlNmTokensDefTable table = (CFBamMSSqlNmTokensDefTable)tableNmTokensDef;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensType != null ) && ( tableNmTokensType instanceof CFBamMSSqlNmTokensTypeTable ) ) {
			CFBamMSSqlNmTokensTypeTable table = (CFBamMSSqlNmTokensTypeTable)tableNmTokensType;
			table.releasePreparedStatements();
		}
		if( ( tableNumberCol != null ) && ( tableNumberCol instanceof CFBamMSSqlNumberColTable ) ) {
			CFBamMSSqlNumberColTable table = (CFBamMSSqlNumberColTable)tableNumberCol;
			table.releasePreparedStatements();
		}
		if( ( tableNumberDef != null ) && ( tableNumberDef instanceof CFBamMSSqlNumberDefTable ) ) {
			CFBamMSSqlNumberDefTable table = (CFBamMSSqlNumberDefTable)tableNumberDef;
			table.releasePreparedStatements();
		}
		if( ( tableNumberType != null ) && ( tableNumberType instanceof CFBamMSSqlNumberTypeTable ) ) {
			CFBamMSSqlNumberTypeTable table = (CFBamMSSqlNumberTypeTable)tableNumberType;
			table.releasePreparedStatements();
		}
		if( ( tableParam != null ) && ( tableParam instanceof CFBamMSSqlParamTable ) ) {
			CFBamMSSqlParamTable table = (CFBamMSSqlParamTable)tableParam;
			table.releasePreparedStatements();
		}
		if( ( tablePopDep != null ) && ( tablePopDep instanceof CFBamMSSqlPopDepTable ) ) {
			CFBamMSSqlPopDepTable table = (CFBamMSSqlPopDepTable)tablePopDep;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep1 != null ) && ( tablePopSubDep1 instanceof CFBamMSSqlPopSubDep1Table ) ) {
			CFBamMSSqlPopSubDep1Table table = (CFBamMSSqlPopSubDep1Table)tablePopSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep2 != null ) && ( tablePopSubDep2 instanceof CFBamMSSqlPopSubDep2Table ) ) {
			CFBamMSSqlPopSubDep2Table table = (CFBamMSSqlPopSubDep2Table)tablePopSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep3 != null ) && ( tablePopSubDep3 instanceof CFBamMSSqlPopSubDep3Table ) ) {
			CFBamMSSqlPopSubDep3Table table = (CFBamMSSqlPopSubDep3Table)tablePopSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tablePopTopDep != null ) && ( tablePopTopDep instanceof CFBamMSSqlPopTopDepTable ) ) {
			CFBamMSSqlPopTopDepTable table = (CFBamMSSqlPopTopDepTable)tablePopTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableProjectBase != null ) && ( tableProjectBase instanceof CFBamMSSqlProjectBaseTable ) ) {
			CFBamMSSqlProjectBaseTable table = (CFBamMSSqlProjectBaseTable)tableProjectBase;
			table.releasePreparedStatements();
		}
		if( ( tableRealProject != null ) && ( tableRealProject instanceof CFBamMSSqlRealProjectTable ) ) {
			CFBamMSSqlRealProjectTable table = (CFBamMSSqlRealProjectTable)tableRealProject;
			table.releasePreparedStatements();
		}
		if( ( tableRelation != null ) && ( tableRelation instanceof CFBamMSSqlRelationTable ) ) {
			CFBamMSSqlRelationTable table = (CFBamMSSqlRelationTable)tableRelation;
			table.releasePreparedStatements();
		}
		if( ( tableRelationCol != null ) && ( tableRelationCol instanceof CFBamMSSqlRelationColTable ) ) {
			CFBamMSSqlRelationColTable table = (CFBamMSSqlRelationColTable)tableRelationCol;
			table.releasePreparedStatements();
		}
		if( ( tableRelationType != null ) && ( tableRelationType instanceof CFBamMSSqlRelationTypeTable ) ) {
			CFBamMSSqlRelationTypeTable table = (CFBamMSSqlRelationTypeTable)tableRelationType;
			table.releasePreparedStatements();
		}
		if( ( tableSchemaDef != null ) && ( tableSchemaDef instanceof CFBamMSSqlSchemaDefTable ) ) {
			CFBamMSSqlSchemaDefTable table = (CFBamMSSqlSchemaDefTable)tableSchemaDef;
			table.releasePreparedStatements();
		}
		if( ( tableSchemaRef != null ) && ( tableSchemaRef instanceof CFBamMSSqlSchemaRefTable ) ) {
			CFBamMSSqlSchemaRefTable table = (CFBamMSSqlSchemaRefTable)tableSchemaRef;
			table.releasePreparedStatements();
		}
		if( ( tableScope != null ) && ( tableScope instanceof CFBamMSSqlScopeTable ) ) {
			CFBamMSSqlScopeTable table = (CFBamMSSqlScopeTable)tableScope;
			table.releasePreparedStatements();
		}
		if( ( tableSecApp != null ) && ( tableSecApp instanceof CFBamMSSqlSecAppTable ) ) {
			CFBamMSSqlSecAppTable table = (CFBamMSSqlSecAppTable)tableSecApp;
			table.releasePreparedStatements();
		}
		if( ( tableSecDevice != null ) && ( tableSecDevice instanceof CFBamMSSqlSecDeviceTable ) ) {
			CFBamMSSqlSecDeviceTable table = (CFBamMSSqlSecDeviceTable)tableSecDevice;
			table.releasePreparedStatements();
		}
		if( ( tableSecForm != null ) && ( tableSecForm instanceof CFBamMSSqlSecFormTable ) ) {
			CFBamMSSqlSecFormTable table = (CFBamMSSqlSecFormTable)tableSecForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroup != null ) && ( tableSecGroup instanceof CFBamMSSqlSecGroupTable ) ) {
			CFBamMSSqlSecGroupTable table = (CFBamMSSqlSecGroupTable)tableSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupForm != null ) && ( tableSecGroupForm instanceof CFBamMSSqlSecGroupFormTable ) ) {
			CFBamMSSqlSecGroupFormTable table = (CFBamMSSqlSecGroupFormTable)tableSecGroupForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupInclude != null ) && ( tableSecGroupInclude instanceof CFBamMSSqlSecGroupIncludeTable ) ) {
			CFBamMSSqlSecGroupIncludeTable table = (CFBamMSSqlSecGroupIncludeTable)tableSecGroupInclude;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupMember != null ) && ( tableSecGroupMember instanceof CFBamMSSqlSecGroupMemberTable ) ) {
			CFBamMSSqlSecGroupMemberTable table = (CFBamMSSqlSecGroupMemberTable)tableSecGroupMember;
			table.releasePreparedStatements();
		}
		if( ( tableSecSession != null ) && ( tableSecSession instanceof CFBamMSSqlSecSessionTable ) ) {
			CFBamMSSqlSecSessionTable table = (CFBamMSSqlSecSessionTable)tableSecSession;
			table.releasePreparedStatements();
		}
		if( ( tableSecUser != null ) && ( tableSecUser instanceof CFBamMSSqlSecUserTable ) ) {
			CFBamMSSqlSecUserTable table = (CFBamMSSqlSecUserTable)tableSecUser;
			table.releasePreparedStatements();
		}
		if( ( tableSecurityScope != null ) && ( tableSecurityScope instanceof CFBamMSSqlSecurityScopeTable ) ) {
			CFBamMSSqlSecurityScopeTable table = (CFBamMSSqlSecurityScopeTable)tableSecurityScope;
			table.releasePreparedStatements();
		}
		if( ( tableServerListFunc != null ) && ( tableServerListFunc instanceof CFBamMSSqlServerListFuncTable ) ) {
			CFBamMSSqlServerListFuncTable table = (CFBamMSSqlServerListFuncTable)tableServerListFunc;
			table.releasePreparedStatements();
		}
		if( ( tableServerMethod != null ) && ( tableServerMethod instanceof CFBamMSSqlServerMethodTable ) ) {
			CFBamMSSqlServerMethodTable table = (CFBamMSSqlServerMethodTable)tableServerMethod;
			table.releasePreparedStatements();
		}
		if( ( tableServerObjFunc != null ) && ( tableServerObjFunc instanceof CFBamMSSqlServerObjFuncTable ) ) {
			CFBamMSSqlServerObjFuncTable table = (CFBamMSSqlServerObjFuncTable)tableServerObjFunc;
			table.releasePreparedStatements();
		}
		if( ( tableServerProc != null ) && ( tableServerProc instanceof CFBamMSSqlServerProcTable ) ) {
			CFBamMSSqlServerProcTable table = (CFBamMSSqlServerProcTable)tableServerProc;
			table.releasePreparedStatements();
		}
		if( ( tableService != null ) && ( tableService instanceof CFBamMSSqlServiceTable ) ) {
			CFBamMSSqlServiceTable table = (CFBamMSSqlServiceTable)tableService;
			table.releasePreparedStatements();
		}
		if( ( tableServiceType != null ) && ( tableServiceType instanceof CFBamMSSqlServiceTypeTable ) ) {
			CFBamMSSqlServiceTypeTable table = (CFBamMSSqlServiceTypeTable)tableServiceType;
			table.releasePreparedStatements();
		}
		if( ( tableStringCol != null ) && ( tableStringCol instanceof CFBamMSSqlStringColTable ) ) {
			CFBamMSSqlStringColTable table = (CFBamMSSqlStringColTable)tableStringCol;
			table.releasePreparedStatements();
		}
		if( ( tableStringDef != null ) && ( tableStringDef instanceof CFBamMSSqlStringDefTable ) ) {
			CFBamMSSqlStringDefTable table = (CFBamMSSqlStringDefTable)tableStringDef;
			table.releasePreparedStatements();
		}
		if( ( tableStringType != null ) && ( tableStringType instanceof CFBamMSSqlStringTypeTable ) ) {
			CFBamMSSqlStringTypeTable table = (CFBamMSSqlStringTypeTable)tableStringType;
			table.releasePreparedStatements();
		}
		if( ( tableSubProject != null ) && ( tableSubProject instanceof CFBamMSSqlSubProjectTable ) ) {
			CFBamMSSqlSubProjectTable table = (CFBamMSSqlSubProjectTable)tableSubProject;
			table.releasePreparedStatements();
		}
		if( ( tableSysCluster != null ) && ( tableSysCluster instanceof CFBamMSSqlSysClusterTable ) ) {
			CFBamMSSqlSysClusterTable table = (CFBamMSSqlSysClusterTable)tableSysCluster;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroup != null ) && ( tableTSecGroup instanceof CFBamMSSqlTSecGroupTable ) ) {
			CFBamMSSqlTSecGroupTable table = (CFBamMSSqlTSecGroupTable)tableTSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroupInclude != null ) && ( tableTSecGroupInclude instanceof CFBamMSSqlTSecGroupIncludeTable ) ) {
			CFBamMSSqlTSecGroupIncludeTable table = (CFBamMSSqlTSecGroupIncludeTable)tableTSecGroupInclude;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroupMember != null ) && ( tableTSecGroupMember instanceof CFBamMSSqlTSecGroupMemberTable ) ) {
			CFBamMSSqlTSecGroupMemberTable table = (CFBamMSSqlTSecGroupMemberTable)tableTSecGroupMember;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateCol != null ) && ( tableTZDateCol instanceof CFBamMSSqlTZDateColTable ) ) {
			CFBamMSSqlTZDateColTable table = (CFBamMSSqlTZDateColTable)tableTZDateCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateDef != null ) && ( tableTZDateDef instanceof CFBamMSSqlTZDateDefTable ) ) {
			CFBamMSSqlTZDateDefTable table = (CFBamMSSqlTZDateDefTable)tableTZDateDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateType != null ) && ( tableTZDateType instanceof CFBamMSSqlTZDateTypeTable ) ) {
			CFBamMSSqlTZDateTypeTable table = (CFBamMSSqlTZDateTypeTable)tableTZDateType;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeCol != null ) && ( tableTZTimeCol instanceof CFBamMSSqlTZTimeColTable ) ) {
			CFBamMSSqlTZTimeColTable table = (CFBamMSSqlTZTimeColTable)tableTZTimeCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeDef != null ) && ( tableTZTimeDef instanceof CFBamMSSqlTZTimeDefTable ) ) {
			CFBamMSSqlTZTimeDefTable table = (CFBamMSSqlTZTimeDefTable)tableTZTimeDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeType != null ) && ( tableTZTimeType instanceof CFBamMSSqlTZTimeTypeTable ) ) {
			CFBamMSSqlTZTimeTypeTable table = (CFBamMSSqlTZTimeTypeTable)tableTZTimeType;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampCol != null ) && ( tableTZTimestampCol instanceof CFBamMSSqlTZTimestampColTable ) ) {
			CFBamMSSqlTZTimestampColTable table = (CFBamMSSqlTZTimestampColTable)tableTZTimestampCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampDef != null ) && ( tableTZTimestampDef instanceof CFBamMSSqlTZTimestampDefTable ) ) {
			CFBamMSSqlTZTimestampDefTable table = (CFBamMSSqlTZTimestampDefTable)tableTZTimestampDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampType != null ) && ( tableTZTimestampType instanceof CFBamMSSqlTZTimestampTypeTable ) ) {
			CFBamMSSqlTZTimestampTypeTable table = (CFBamMSSqlTZTimestampTypeTable)tableTZTimestampType;
			table.releasePreparedStatements();
		}
		if( ( tableTable != null ) && ( tableTable instanceof CFBamMSSqlTableTable ) ) {
			CFBamMSSqlTableTable table = (CFBamMSSqlTableTable)tableTable;
			table.releasePreparedStatements();
		}
		if( ( tableTableCol != null ) && ( tableTableCol instanceof CFBamMSSqlTableColTable ) ) {
			CFBamMSSqlTableColTable table = (CFBamMSSqlTableColTable)tableTableCol;
			table.releasePreparedStatements();
		}
		if( ( tableTenant != null ) && ( tableTenant instanceof CFBamMSSqlTenantTable ) ) {
			CFBamMSSqlTenantTable table = (CFBamMSSqlTenantTable)tableTenant;
			table.releasePreparedStatements();
		}
		if( ( tableTextCol != null ) && ( tableTextCol instanceof CFBamMSSqlTextColTable ) ) {
			CFBamMSSqlTextColTable table = (CFBamMSSqlTextColTable)tableTextCol;
			table.releasePreparedStatements();
		}
		if( ( tableTextDef != null ) && ( tableTextDef instanceof CFBamMSSqlTextDefTable ) ) {
			CFBamMSSqlTextDefTable table = (CFBamMSSqlTextDefTable)tableTextDef;
			table.releasePreparedStatements();
		}
		if( ( tableTextType != null ) && ( tableTextType instanceof CFBamMSSqlTextTypeTable ) ) {
			CFBamMSSqlTextTypeTable table = (CFBamMSSqlTextTypeTable)tableTextType;
			table.releasePreparedStatements();
		}
		if( ( tableTimeCol != null ) && ( tableTimeCol instanceof CFBamMSSqlTimeColTable ) ) {
			CFBamMSSqlTimeColTable table = (CFBamMSSqlTimeColTable)tableTimeCol;
			table.releasePreparedStatements();
		}
		if( ( tableTimeDef != null ) && ( tableTimeDef instanceof CFBamMSSqlTimeDefTable ) ) {
			CFBamMSSqlTimeDefTable table = (CFBamMSSqlTimeDefTable)tableTimeDef;
			table.releasePreparedStatements();
		}
		if( ( tableTimeType != null ) && ( tableTimeType instanceof CFBamMSSqlTimeTypeTable ) ) {
			CFBamMSSqlTimeTypeTable table = (CFBamMSSqlTimeTypeTable)tableTimeType;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampCol != null ) && ( tableTimestampCol instanceof CFBamMSSqlTimestampColTable ) ) {
			CFBamMSSqlTimestampColTable table = (CFBamMSSqlTimestampColTable)tableTimestampCol;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampDef != null ) && ( tableTimestampDef instanceof CFBamMSSqlTimestampDefTable ) ) {
			CFBamMSSqlTimestampDefTable table = (CFBamMSSqlTimestampDefTable)tableTimestampDef;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampType != null ) && ( tableTimestampType instanceof CFBamMSSqlTimestampTypeTable ) ) {
			CFBamMSSqlTimestampTypeTable table = (CFBamMSSqlTimestampTypeTable)tableTimestampType;
			table.releasePreparedStatements();
		}
		if( ( tableTld != null ) && ( tableTld instanceof CFBamMSSqlTldTable ) ) {
			CFBamMSSqlTldTable table = (CFBamMSSqlTldTable)tableTld;
			table.releasePreparedStatements();
		}
		if( ( tableTokenCol != null ) && ( tableTokenCol instanceof CFBamMSSqlTokenColTable ) ) {
			CFBamMSSqlTokenColTable table = (CFBamMSSqlTokenColTable)tableTokenCol;
			table.releasePreparedStatements();
		}
		if( ( tableTokenDef != null ) && ( tableTokenDef instanceof CFBamMSSqlTokenDefTable ) ) {
			CFBamMSSqlTokenDefTable table = (CFBamMSSqlTokenDefTable)tableTokenDef;
			table.releasePreparedStatements();
		}
		if( ( tableTokenType != null ) && ( tableTokenType instanceof CFBamMSSqlTokenTypeTable ) ) {
			CFBamMSSqlTokenTypeTable table = (CFBamMSSqlTokenTypeTable)tableTokenType;
			table.releasePreparedStatements();
		}
		if( ( tableTopDomain != null ) && ( tableTopDomain instanceof CFBamMSSqlTopDomainTable ) ) {
			CFBamMSSqlTopDomainTable table = (CFBamMSSqlTopDomainTable)tableTopDomain;
			table.releasePreparedStatements();
		}
		if( ( tableTopProject != null ) && ( tableTopProject instanceof CFBamMSSqlTopProjectTable ) ) {
			CFBamMSSqlTopProjectTable table = (CFBamMSSqlTopProjectTable)tableTopProject;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Col != null ) && ( tableUInt16Col instanceof CFBamMSSqlUInt16ColTable ) ) {
			CFBamMSSqlUInt16ColTable table = (CFBamMSSqlUInt16ColTable)tableUInt16Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Def != null ) && ( tableUInt16Def instanceof CFBamMSSqlUInt16DefTable ) ) {
			CFBamMSSqlUInt16DefTable table = (CFBamMSSqlUInt16DefTable)tableUInt16Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Type != null ) && ( tableUInt16Type instanceof CFBamMSSqlUInt16TypeTable ) ) {
			CFBamMSSqlUInt16TypeTable table = (CFBamMSSqlUInt16TypeTable)tableUInt16Type;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Col != null ) && ( tableUInt32Col instanceof CFBamMSSqlUInt32ColTable ) ) {
			CFBamMSSqlUInt32ColTable table = (CFBamMSSqlUInt32ColTable)tableUInt32Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Def != null ) && ( tableUInt32Def instanceof CFBamMSSqlUInt32DefTable ) ) {
			CFBamMSSqlUInt32DefTable table = (CFBamMSSqlUInt32DefTable)tableUInt32Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Type != null ) && ( tableUInt32Type instanceof CFBamMSSqlUInt32TypeTable ) ) {
			CFBamMSSqlUInt32TypeTable table = (CFBamMSSqlUInt32TypeTable)tableUInt32Type;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Col != null ) && ( tableUInt64Col instanceof CFBamMSSqlUInt64ColTable ) ) {
			CFBamMSSqlUInt64ColTable table = (CFBamMSSqlUInt64ColTable)tableUInt64Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Def != null ) && ( tableUInt64Def instanceof CFBamMSSqlUInt64DefTable ) ) {
			CFBamMSSqlUInt64DefTable table = (CFBamMSSqlUInt64DefTable)tableUInt64Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Type != null ) && ( tableUInt64Type instanceof CFBamMSSqlUInt64TypeTable ) ) {
			CFBamMSSqlUInt64TypeTable table = (CFBamMSSqlUInt64TypeTable)tableUInt64Type;
			table.releasePreparedStatements();
		}
		if( ( tableURLProtocol != null ) && ( tableURLProtocol instanceof CFBamMSSqlURLProtocolTable ) ) {
			CFBamMSSqlURLProtocolTable table = (CFBamMSSqlURLProtocolTable)tableURLProtocol;
			table.releasePreparedStatements();
		}
		if( ( tableUuidCol != null ) && ( tableUuidCol instanceof CFBamMSSqlUuidColTable ) ) {
			CFBamMSSqlUuidColTable table = (CFBamMSSqlUuidColTable)tableUuidCol;
			table.releasePreparedStatements();
		}
		if( ( tableUuidDef != null ) && ( tableUuidDef instanceof CFBamMSSqlUuidDefTable ) ) {
			CFBamMSSqlUuidDefTable table = (CFBamMSSqlUuidDefTable)tableUuidDef;
			table.releasePreparedStatements();
		}
		if( ( tableUuidGen != null ) && ( tableUuidGen instanceof CFBamMSSqlUuidGenTable ) ) {
			CFBamMSSqlUuidGenTable table = (CFBamMSSqlUuidGenTable)tableUuidGen;
			table.releasePreparedStatements();
		}
		if( ( tableUuidType != null ) && ( tableUuidType instanceof CFBamMSSqlUuidTypeTable ) ) {
			CFBamMSSqlUuidTypeTable table = (CFBamMSSqlUuidTypeTable)tableUuidType;
			table.releasePreparedStatements();
		}
		if( ( tableValue != null ) && ( tableValue instanceof CFBamMSSqlValueTable ) ) {
			CFBamMSSqlValueTable table = (CFBamMSSqlValueTable)tableValue;
			table.releasePreparedStatements();
		}
		if( ( tableVersion != null ) && ( tableVersion instanceof CFBamMSSqlVersionTable ) ) {
			CFBamMSSqlVersionTable table = (CFBamMSSqlVersionTable)tableVersion;
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMSSqlSchema.class,
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
				return( "'Y'" );
			}
			else {
				return( "'N'" );
			}
		}
	}

	public static String getBoolString(boolean val) {
		if( val ) {
			return( "'Y'" );
		}
		else {
			return( "'N'" );
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMSSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMSSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMSSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMSSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMSSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamMSSqlSchema.class,
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
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
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
        else if ( val.length() != 8 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
				"convertDateString",
            	"Value must be in YYYYMMDD format, \"" + val + "\" is invalid" );
        }
        else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
             && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
             && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
             && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
             && ((val.charAt( 4 ) >= '0') && (val.charAt( 4 ) <= '1'))
             && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '9'))
             && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '3'))
             && ((val.charAt( 7 ) >= '0') && (val.charAt( 7 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
            int year = Integer.parseInt( val.substring( 0, 4 ) );
            int month = Integer.parseInt( val.substring( 4, 6 ) );
            int day = Integer.parseInt( val.substring( 6, 8 ) );
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
				"convertDateString",
            	"Value must be in YYYYMMDD format, \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 8 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
				"convertTimeString",
            	"Value must be in HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
				"convertTimestampString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
				"convertTZDateString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
				"convertTZTimeString",
            	"Value must be in YYYY-MM-DD HH24.MI.SS format \"" + val + "\" is invalid" );
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
				"convertTZTimeString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
				"convertTZTimestampString",
            	"Value must be in YYYY-MM-DD-HH24.MI.SS format \"" + val + "\" is invalid" );
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamMSSqlSchema.class,
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
