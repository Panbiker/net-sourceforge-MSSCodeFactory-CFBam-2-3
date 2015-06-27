// Description: Java 7 Oracle 11gR2 Jdbc DbIO implementation for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamOracle;

import java.lang.reflect.*;
import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import oracle.jdbc.OracleDriver;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSaxLoader.CFBamSaxLoader;

public class CFBamOracleSchema
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

	public CFBamOracleSchema() {
		super();
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamOracleAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamOracleAccessSecurityTable( this );
		tableAtom = new CFBamOracleAtomTable( this );
		tableAuditAction = new CFBamOracleAuditActionTable( this );
		tableBlobCol = new CFBamOracleBlobColTable( this );
		tableBlobDef = new CFBamOracleBlobDefTable( this );
		tableBlobType = new CFBamOracleBlobTypeTable( this );
		tableBoolCol = new CFBamOracleBoolColTable( this );
		tableBoolDef = new CFBamOracleBoolDefTable( this );
		tableBoolType = new CFBamOracleBoolTypeTable( this );
		tableChain = new CFBamOracleChainTable( this );
		tableClearDep = new CFBamOracleClearDepTable( this );
		tableClearSubDep1 = new CFBamOracleClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamOracleClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamOracleClearSubDep3Table( this );
		tableClearTopDep = new CFBamOracleClearTopDepTable( this );
		tableCluster = new CFBamOracleClusterTable( this );
		tableDataScope = new CFBamOracleDataScopeTable( this );
		tableDateCol = new CFBamOracleDateColTable( this );
		tableDateDef = new CFBamOracleDateDefTable( this );
		tableDateType = new CFBamOracleDateTypeTable( this );
		tableDelDep = new CFBamOracleDelDepTable( this );
		tableDelSubDep1 = new CFBamOracleDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamOracleDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamOracleDelSubDep3Table( this );
		tableDelTopDep = new CFBamOracleDelTopDepTable( this );
		tableDomain = new CFBamOracleDomainTable( this );
		tableDomainBase = new CFBamOracleDomainBaseTable( this );
		tableDoubleCol = new CFBamOracleDoubleColTable( this );
		tableDoubleDef = new CFBamOracleDoubleDefTable( this );
		tableDoubleType = new CFBamOracleDoubleTypeTable( this );
		tableEnumCol = new CFBamOracleEnumColTable( this );
		tableEnumDef = new CFBamOracleEnumDefTable( this );
		tableEnumTag = new CFBamOracleEnumTagTable( this );
		tableEnumType = new CFBamOracleEnumTypeTable( this );
		tableFloatCol = new CFBamOracleFloatColTable( this );
		tableFloatDef = new CFBamOracleFloatDefTable( this );
		tableFloatType = new CFBamOracleFloatTypeTable( this );
		tableHostNode = new CFBamOracleHostNodeTable( this );
		tableISOCountry = new CFBamOracleISOCountryTable( this );
		tableISOCountryCurrency = new CFBamOracleISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamOracleISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamOracleISOCurrencyTable( this );
		tableISOLanguage = new CFBamOracleISOLanguageTable( this );
		tableISOTimezone = new CFBamOracleISOTimezoneTable( this );
		tableId16Gen = new CFBamOracleId16GenTable( this );
		tableId32Gen = new CFBamOracleId32GenTable( this );
		tableId64Gen = new CFBamOracleId64GenTable( this );
		tableIndex = new CFBamOracleIndexTable( this );
		tableIndexCol = new CFBamOracleIndexColTable( this );
		tableInt16Col = new CFBamOracleInt16ColTable( this );
		tableInt16Def = new CFBamOracleInt16DefTable( this );
		tableInt16Type = new CFBamOracleInt16TypeTable( this );
		tableInt32Col = new CFBamOracleInt32ColTable( this );
		tableInt32Def = new CFBamOracleInt32DefTable( this );
		tableInt32Type = new CFBamOracleInt32TypeTable( this );
		tableInt64Col = new CFBamOracleInt64ColTable( this );
		tableInt64Def = new CFBamOracleInt64DefTable( this );
		tableInt64Type = new CFBamOracleInt64TypeTable( this );
		tableLicense = new CFBamOracleLicenseTable( this );
		tableLoaderBehaviour = new CFBamOracleLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamOracleMajorVersionTable( this );
		tableMimeType = new CFBamOracleMimeTypeTable( this );
		tableMinorVersion = new CFBamOracleMinorVersionTable( this );
		tableNmTokenCol = new CFBamOracleNmTokenColTable( this );
		tableNmTokenDef = new CFBamOracleNmTokenDefTable( this );
		tableNmTokenType = new CFBamOracleNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamOracleNmTokensColTable( this );
		tableNmTokensDef = new CFBamOracleNmTokensDefTable( this );
		tableNmTokensType = new CFBamOracleNmTokensTypeTable( this );
		tableNumberCol = new CFBamOracleNumberColTable( this );
		tableNumberDef = new CFBamOracleNumberDefTable( this );
		tableNumberType = new CFBamOracleNumberTypeTable( this );
		tableParam = new CFBamOracleParamTable( this );
		tablePopDep = new CFBamOraclePopDepTable( this );
		tablePopSubDep1 = new CFBamOraclePopSubDep1Table( this );
		tablePopSubDep2 = new CFBamOraclePopSubDep2Table( this );
		tablePopSubDep3 = new CFBamOraclePopSubDep3Table( this );
		tablePopTopDep = new CFBamOraclePopTopDepTable( this );
		tableProjectBase = new CFBamOracleProjectBaseTable( this );
		tableRealProject = new CFBamOracleRealProjectTable( this );
		tableRelation = new CFBamOracleRelationTable( this );
		tableRelationCol = new CFBamOracleRelationColTable( this );
		tableRelationType = new CFBamOracleRelationTypeTable( this );
		tableSchemaDef = new CFBamOracleSchemaDefTable( this );
		tableSchemaRef = new CFBamOracleSchemaRefTable( this );
		tableScope = new CFBamOracleScopeTable( this );
		tableSecApp = new CFBamOracleSecAppTable( this );
		tableSecDevice = new CFBamOracleSecDeviceTable( this );
		tableSecForm = new CFBamOracleSecFormTable( this );
		tableSecGroup = new CFBamOracleSecGroupTable( this );
		tableSecGroupForm = new CFBamOracleSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamOracleSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamOracleSecGroupMemberTable( this );
		tableSecSession = new CFBamOracleSecSessionTable( this );
		tableSecUser = new CFBamOracleSecUserTable( this );
		tableSecurityScope = new CFBamOracleSecurityScopeTable( this );
		tableServerListFunc = new CFBamOracleServerListFuncTable( this );
		tableServerMethod = new CFBamOracleServerMethodTable( this );
		tableServerObjFunc = new CFBamOracleServerObjFuncTable( this );
		tableServerProc = new CFBamOracleServerProcTable( this );
		tableService = new CFBamOracleServiceTable( this );
		tableServiceType = new CFBamOracleServiceTypeTable( this );
		tableStringCol = new CFBamOracleStringColTable( this );
		tableStringDef = new CFBamOracleStringDefTable( this );
		tableStringType = new CFBamOracleStringTypeTable( this );
		tableSubProject = new CFBamOracleSubProjectTable( this );
		tableSysCluster = new CFBamOracleSysClusterTable( this );
		tableTSecGroup = new CFBamOracleTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamOracleTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamOracleTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamOracleTZDateColTable( this );
		tableTZDateDef = new CFBamOracleTZDateDefTable( this );
		tableTZDateType = new CFBamOracleTZDateTypeTable( this );
		tableTZTimeCol = new CFBamOracleTZTimeColTable( this );
		tableTZTimeDef = new CFBamOracleTZTimeDefTable( this );
		tableTZTimeType = new CFBamOracleTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamOracleTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamOracleTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamOracleTZTimestampTypeTable( this );
		tableTable = new CFBamOracleTableTable( this );
		tableTableCol = new CFBamOracleTableColTable( this );
		tableTenant = new CFBamOracleTenantTable( this );
		tableTextCol = new CFBamOracleTextColTable( this );
		tableTextDef = new CFBamOracleTextDefTable( this );
		tableTextType = new CFBamOracleTextTypeTable( this );
		tableTimeCol = new CFBamOracleTimeColTable( this );
		tableTimeDef = new CFBamOracleTimeDefTable( this );
		tableTimeType = new CFBamOracleTimeTypeTable( this );
		tableTimestampCol = new CFBamOracleTimestampColTable( this );
		tableTimestampDef = new CFBamOracleTimestampDefTable( this );
		tableTimestampType = new CFBamOracleTimestampTypeTable( this );
		tableTld = new CFBamOracleTldTable( this );
		tableTokenCol = new CFBamOracleTokenColTable( this );
		tableTokenDef = new CFBamOracleTokenDefTable( this );
		tableTokenType = new CFBamOracleTokenTypeTable( this );
		tableTopDomain = new CFBamOracleTopDomainTable( this );
		tableTopProject = new CFBamOracleTopProjectTable( this );
		tableUInt16Col = new CFBamOracleUInt16ColTable( this );
		tableUInt16Def = new CFBamOracleUInt16DefTable( this );
		tableUInt16Type = new CFBamOracleUInt16TypeTable( this );
		tableUInt32Col = new CFBamOracleUInt32ColTable( this );
		tableUInt32Def = new CFBamOracleUInt32DefTable( this );
		tableUInt32Type = new CFBamOracleUInt32TypeTable( this );
		tableUInt64Col = new CFBamOracleUInt64ColTable( this );
		tableUInt64Def = new CFBamOracleUInt64DefTable( this );
		tableUInt64Type = new CFBamOracleUInt64TypeTable( this );
		tableURLProtocol = new CFBamOracleURLProtocolTable( this );
		tableUuidCol = new CFBamOracleUuidColTable( this );
		tableUuidDef = new CFBamOracleUuidDefTable( this );
		tableUuidGen = new CFBamOracleUuidGenTable( this );
		tableUuidType = new CFBamOracleUuidTypeTable( this );
		tableValue = new CFBamOracleValueTable( this );
		tableVersion = new CFBamOracleVersionTable( this );
	}

	public CFBamOracleSchema( CFBamConfigurationFile conf ) {
		super( conf );
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamOracleAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamOracleAccessSecurityTable( this );
		tableAtom = new CFBamOracleAtomTable( this );
		tableAuditAction = new CFBamOracleAuditActionTable( this );
		tableBlobCol = new CFBamOracleBlobColTable( this );
		tableBlobDef = new CFBamOracleBlobDefTable( this );
		tableBlobType = new CFBamOracleBlobTypeTable( this );
		tableBoolCol = new CFBamOracleBoolColTable( this );
		tableBoolDef = new CFBamOracleBoolDefTable( this );
		tableBoolType = new CFBamOracleBoolTypeTable( this );
		tableChain = new CFBamOracleChainTable( this );
		tableClearDep = new CFBamOracleClearDepTable( this );
		tableClearSubDep1 = new CFBamOracleClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamOracleClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamOracleClearSubDep3Table( this );
		tableClearTopDep = new CFBamOracleClearTopDepTable( this );
		tableCluster = new CFBamOracleClusterTable( this );
		tableDataScope = new CFBamOracleDataScopeTable( this );
		tableDateCol = new CFBamOracleDateColTable( this );
		tableDateDef = new CFBamOracleDateDefTable( this );
		tableDateType = new CFBamOracleDateTypeTable( this );
		tableDelDep = new CFBamOracleDelDepTable( this );
		tableDelSubDep1 = new CFBamOracleDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamOracleDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamOracleDelSubDep3Table( this );
		tableDelTopDep = new CFBamOracleDelTopDepTable( this );
		tableDomain = new CFBamOracleDomainTable( this );
		tableDomainBase = new CFBamOracleDomainBaseTable( this );
		tableDoubleCol = new CFBamOracleDoubleColTable( this );
		tableDoubleDef = new CFBamOracleDoubleDefTable( this );
		tableDoubleType = new CFBamOracleDoubleTypeTable( this );
		tableEnumCol = new CFBamOracleEnumColTable( this );
		tableEnumDef = new CFBamOracleEnumDefTable( this );
		tableEnumTag = new CFBamOracleEnumTagTable( this );
		tableEnumType = new CFBamOracleEnumTypeTable( this );
		tableFloatCol = new CFBamOracleFloatColTable( this );
		tableFloatDef = new CFBamOracleFloatDefTable( this );
		tableFloatType = new CFBamOracleFloatTypeTable( this );
		tableHostNode = new CFBamOracleHostNodeTable( this );
		tableISOCountry = new CFBamOracleISOCountryTable( this );
		tableISOCountryCurrency = new CFBamOracleISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamOracleISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamOracleISOCurrencyTable( this );
		tableISOLanguage = new CFBamOracleISOLanguageTable( this );
		tableISOTimezone = new CFBamOracleISOTimezoneTable( this );
		tableId16Gen = new CFBamOracleId16GenTable( this );
		tableId32Gen = new CFBamOracleId32GenTable( this );
		tableId64Gen = new CFBamOracleId64GenTable( this );
		tableIndex = new CFBamOracleIndexTable( this );
		tableIndexCol = new CFBamOracleIndexColTable( this );
		tableInt16Col = new CFBamOracleInt16ColTable( this );
		tableInt16Def = new CFBamOracleInt16DefTable( this );
		tableInt16Type = new CFBamOracleInt16TypeTable( this );
		tableInt32Col = new CFBamOracleInt32ColTable( this );
		tableInt32Def = new CFBamOracleInt32DefTable( this );
		tableInt32Type = new CFBamOracleInt32TypeTable( this );
		tableInt64Col = new CFBamOracleInt64ColTable( this );
		tableInt64Def = new CFBamOracleInt64DefTable( this );
		tableInt64Type = new CFBamOracleInt64TypeTable( this );
		tableLicense = new CFBamOracleLicenseTable( this );
		tableLoaderBehaviour = new CFBamOracleLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamOracleMajorVersionTable( this );
		tableMimeType = new CFBamOracleMimeTypeTable( this );
		tableMinorVersion = new CFBamOracleMinorVersionTable( this );
		tableNmTokenCol = new CFBamOracleNmTokenColTable( this );
		tableNmTokenDef = new CFBamOracleNmTokenDefTable( this );
		tableNmTokenType = new CFBamOracleNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamOracleNmTokensColTable( this );
		tableNmTokensDef = new CFBamOracleNmTokensDefTable( this );
		tableNmTokensType = new CFBamOracleNmTokensTypeTable( this );
		tableNumberCol = new CFBamOracleNumberColTable( this );
		tableNumberDef = new CFBamOracleNumberDefTable( this );
		tableNumberType = new CFBamOracleNumberTypeTable( this );
		tableParam = new CFBamOracleParamTable( this );
		tablePopDep = new CFBamOraclePopDepTable( this );
		tablePopSubDep1 = new CFBamOraclePopSubDep1Table( this );
		tablePopSubDep2 = new CFBamOraclePopSubDep2Table( this );
		tablePopSubDep3 = new CFBamOraclePopSubDep3Table( this );
		tablePopTopDep = new CFBamOraclePopTopDepTable( this );
		tableProjectBase = new CFBamOracleProjectBaseTable( this );
		tableRealProject = new CFBamOracleRealProjectTable( this );
		tableRelation = new CFBamOracleRelationTable( this );
		tableRelationCol = new CFBamOracleRelationColTable( this );
		tableRelationType = new CFBamOracleRelationTypeTable( this );
		tableSchemaDef = new CFBamOracleSchemaDefTable( this );
		tableSchemaRef = new CFBamOracleSchemaRefTable( this );
		tableScope = new CFBamOracleScopeTable( this );
		tableSecApp = new CFBamOracleSecAppTable( this );
		tableSecDevice = new CFBamOracleSecDeviceTable( this );
		tableSecForm = new CFBamOracleSecFormTable( this );
		tableSecGroup = new CFBamOracleSecGroupTable( this );
		tableSecGroupForm = new CFBamOracleSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamOracleSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamOracleSecGroupMemberTable( this );
		tableSecSession = new CFBamOracleSecSessionTable( this );
		tableSecUser = new CFBamOracleSecUserTable( this );
		tableSecurityScope = new CFBamOracleSecurityScopeTable( this );
		tableServerListFunc = new CFBamOracleServerListFuncTable( this );
		tableServerMethod = new CFBamOracleServerMethodTable( this );
		tableServerObjFunc = new CFBamOracleServerObjFuncTable( this );
		tableServerProc = new CFBamOracleServerProcTable( this );
		tableService = new CFBamOracleServiceTable( this );
		tableServiceType = new CFBamOracleServiceTypeTable( this );
		tableStringCol = new CFBamOracleStringColTable( this );
		tableStringDef = new CFBamOracleStringDefTable( this );
		tableStringType = new CFBamOracleStringTypeTable( this );
		tableSubProject = new CFBamOracleSubProjectTable( this );
		tableSysCluster = new CFBamOracleSysClusterTable( this );
		tableTSecGroup = new CFBamOracleTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamOracleTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamOracleTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamOracleTZDateColTable( this );
		tableTZDateDef = new CFBamOracleTZDateDefTable( this );
		tableTZDateType = new CFBamOracleTZDateTypeTable( this );
		tableTZTimeCol = new CFBamOracleTZTimeColTable( this );
		tableTZTimeDef = new CFBamOracleTZTimeDefTable( this );
		tableTZTimeType = new CFBamOracleTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamOracleTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamOracleTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamOracleTZTimestampTypeTable( this );
		tableTable = new CFBamOracleTableTable( this );
		tableTableCol = new CFBamOracleTableColTable( this );
		tableTenant = new CFBamOracleTenantTable( this );
		tableTextCol = new CFBamOracleTextColTable( this );
		tableTextDef = new CFBamOracleTextDefTable( this );
		tableTextType = new CFBamOracleTextTypeTable( this );
		tableTimeCol = new CFBamOracleTimeColTable( this );
		tableTimeDef = new CFBamOracleTimeDefTable( this );
		tableTimeType = new CFBamOracleTimeTypeTable( this );
		tableTimestampCol = new CFBamOracleTimestampColTable( this );
		tableTimestampDef = new CFBamOracleTimestampDefTable( this );
		tableTimestampType = new CFBamOracleTimestampTypeTable( this );
		tableTld = new CFBamOracleTldTable( this );
		tableTokenCol = new CFBamOracleTokenColTable( this );
		tableTokenDef = new CFBamOracleTokenDefTable( this );
		tableTokenType = new CFBamOracleTokenTypeTable( this );
		tableTopDomain = new CFBamOracleTopDomainTable( this );
		tableTopProject = new CFBamOracleTopProjectTable( this );
		tableUInt16Col = new CFBamOracleUInt16ColTable( this );
		tableUInt16Def = new CFBamOracleUInt16DefTable( this );
		tableUInt16Type = new CFBamOracleUInt16TypeTable( this );
		tableUInt32Col = new CFBamOracleUInt32ColTable( this );
		tableUInt32Def = new CFBamOracleUInt32DefTable( this );
		tableUInt32Type = new CFBamOracleUInt32TypeTable( this );
		tableUInt64Col = new CFBamOracleUInt64ColTable( this );
		tableUInt64Def = new CFBamOracleUInt64DefTable( this );
		tableUInt64Type = new CFBamOracleUInt64TypeTable( this );
		tableURLProtocol = new CFBamOracleURLProtocolTable( this );
		tableUuidCol = new CFBamOracleUuidColTable( this );
		tableUuidDef = new CFBamOracleUuidDefTable( this );
		tableUuidGen = new CFBamOracleUuidGenTable( this );
		tableUuidType = new CFBamOracleUuidTypeTable( this );
		tableValue = new CFBamOracleValueTable( this );
		tableVersion = new CFBamOracleVersionTable( this );
		setDbSchemaName( conf.getDbDatabase() );
	}

	public CFBamOracleSchema( String argJndiName ) {
		super( argJndiName );
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamOracleAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamOracleAccessSecurityTable( this );
		tableAtom = new CFBamOracleAtomTable( this );
		tableAuditAction = new CFBamOracleAuditActionTable( this );
		tableBlobCol = new CFBamOracleBlobColTable( this );
		tableBlobDef = new CFBamOracleBlobDefTable( this );
		tableBlobType = new CFBamOracleBlobTypeTable( this );
		tableBoolCol = new CFBamOracleBoolColTable( this );
		tableBoolDef = new CFBamOracleBoolDefTable( this );
		tableBoolType = new CFBamOracleBoolTypeTable( this );
		tableChain = new CFBamOracleChainTable( this );
		tableClearDep = new CFBamOracleClearDepTable( this );
		tableClearSubDep1 = new CFBamOracleClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamOracleClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamOracleClearSubDep3Table( this );
		tableClearTopDep = new CFBamOracleClearTopDepTable( this );
		tableCluster = new CFBamOracleClusterTable( this );
		tableDataScope = new CFBamOracleDataScopeTable( this );
		tableDateCol = new CFBamOracleDateColTable( this );
		tableDateDef = new CFBamOracleDateDefTable( this );
		tableDateType = new CFBamOracleDateTypeTable( this );
		tableDelDep = new CFBamOracleDelDepTable( this );
		tableDelSubDep1 = new CFBamOracleDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamOracleDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamOracleDelSubDep3Table( this );
		tableDelTopDep = new CFBamOracleDelTopDepTable( this );
		tableDomain = new CFBamOracleDomainTable( this );
		tableDomainBase = new CFBamOracleDomainBaseTable( this );
		tableDoubleCol = new CFBamOracleDoubleColTable( this );
		tableDoubleDef = new CFBamOracleDoubleDefTable( this );
		tableDoubleType = new CFBamOracleDoubleTypeTable( this );
		tableEnumCol = new CFBamOracleEnumColTable( this );
		tableEnumDef = new CFBamOracleEnumDefTable( this );
		tableEnumTag = new CFBamOracleEnumTagTable( this );
		tableEnumType = new CFBamOracleEnumTypeTable( this );
		tableFloatCol = new CFBamOracleFloatColTable( this );
		tableFloatDef = new CFBamOracleFloatDefTable( this );
		tableFloatType = new CFBamOracleFloatTypeTable( this );
		tableHostNode = new CFBamOracleHostNodeTable( this );
		tableISOCountry = new CFBamOracleISOCountryTable( this );
		tableISOCountryCurrency = new CFBamOracleISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamOracleISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamOracleISOCurrencyTable( this );
		tableISOLanguage = new CFBamOracleISOLanguageTable( this );
		tableISOTimezone = new CFBamOracleISOTimezoneTable( this );
		tableId16Gen = new CFBamOracleId16GenTable( this );
		tableId32Gen = new CFBamOracleId32GenTable( this );
		tableId64Gen = new CFBamOracleId64GenTable( this );
		tableIndex = new CFBamOracleIndexTable( this );
		tableIndexCol = new CFBamOracleIndexColTable( this );
		tableInt16Col = new CFBamOracleInt16ColTable( this );
		tableInt16Def = new CFBamOracleInt16DefTable( this );
		tableInt16Type = new CFBamOracleInt16TypeTable( this );
		tableInt32Col = new CFBamOracleInt32ColTable( this );
		tableInt32Def = new CFBamOracleInt32DefTable( this );
		tableInt32Type = new CFBamOracleInt32TypeTable( this );
		tableInt64Col = new CFBamOracleInt64ColTable( this );
		tableInt64Def = new CFBamOracleInt64DefTable( this );
		tableInt64Type = new CFBamOracleInt64TypeTable( this );
		tableLicense = new CFBamOracleLicenseTable( this );
		tableLoaderBehaviour = new CFBamOracleLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamOracleMajorVersionTable( this );
		tableMimeType = new CFBamOracleMimeTypeTable( this );
		tableMinorVersion = new CFBamOracleMinorVersionTable( this );
		tableNmTokenCol = new CFBamOracleNmTokenColTable( this );
		tableNmTokenDef = new CFBamOracleNmTokenDefTable( this );
		tableNmTokenType = new CFBamOracleNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamOracleNmTokensColTable( this );
		tableNmTokensDef = new CFBamOracleNmTokensDefTable( this );
		tableNmTokensType = new CFBamOracleNmTokensTypeTable( this );
		tableNumberCol = new CFBamOracleNumberColTable( this );
		tableNumberDef = new CFBamOracleNumberDefTable( this );
		tableNumberType = new CFBamOracleNumberTypeTable( this );
		tableParam = new CFBamOracleParamTable( this );
		tablePopDep = new CFBamOraclePopDepTable( this );
		tablePopSubDep1 = new CFBamOraclePopSubDep1Table( this );
		tablePopSubDep2 = new CFBamOraclePopSubDep2Table( this );
		tablePopSubDep3 = new CFBamOraclePopSubDep3Table( this );
		tablePopTopDep = new CFBamOraclePopTopDepTable( this );
		tableProjectBase = new CFBamOracleProjectBaseTable( this );
		tableRealProject = new CFBamOracleRealProjectTable( this );
		tableRelation = new CFBamOracleRelationTable( this );
		tableRelationCol = new CFBamOracleRelationColTable( this );
		tableRelationType = new CFBamOracleRelationTypeTable( this );
		tableSchemaDef = new CFBamOracleSchemaDefTable( this );
		tableSchemaRef = new CFBamOracleSchemaRefTable( this );
		tableScope = new CFBamOracleScopeTable( this );
		tableSecApp = new CFBamOracleSecAppTable( this );
		tableSecDevice = new CFBamOracleSecDeviceTable( this );
		tableSecForm = new CFBamOracleSecFormTable( this );
		tableSecGroup = new CFBamOracleSecGroupTable( this );
		tableSecGroupForm = new CFBamOracleSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamOracleSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamOracleSecGroupMemberTable( this );
		tableSecSession = new CFBamOracleSecSessionTable( this );
		tableSecUser = new CFBamOracleSecUserTable( this );
		tableSecurityScope = new CFBamOracleSecurityScopeTable( this );
		tableServerListFunc = new CFBamOracleServerListFuncTable( this );
		tableServerMethod = new CFBamOracleServerMethodTable( this );
		tableServerObjFunc = new CFBamOracleServerObjFuncTable( this );
		tableServerProc = new CFBamOracleServerProcTable( this );
		tableService = new CFBamOracleServiceTable( this );
		tableServiceType = new CFBamOracleServiceTypeTable( this );
		tableStringCol = new CFBamOracleStringColTable( this );
		tableStringDef = new CFBamOracleStringDefTable( this );
		tableStringType = new CFBamOracleStringTypeTable( this );
		tableSubProject = new CFBamOracleSubProjectTable( this );
		tableSysCluster = new CFBamOracleSysClusterTable( this );
		tableTSecGroup = new CFBamOracleTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamOracleTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamOracleTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamOracleTZDateColTable( this );
		tableTZDateDef = new CFBamOracleTZDateDefTable( this );
		tableTZDateType = new CFBamOracleTZDateTypeTable( this );
		tableTZTimeCol = new CFBamOracleTZTimeColTable( this );
		tableTZTimeDef = new CFBamOracleTZTimeDefTable( this );
		tableTZTimeType = new CFBamOracleTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamOracleTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamOracleTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamOracleTZTimestampTypeTable( this );
		tableTable = new CFBamOracleTableTable( this );
		tableTableCol = new CFBamOracleTableColTable( this );
		tableTenant = new CFBamOracleTenantTable( this );
		tableTextCol = new CFBamOracleTextColTable( this );
		tableTextDef = new CFBamOracleTextDefTable( this );
		tableTextType = new CFBamOracleTextTypeTable( this );
		tableTimeCol = new CFBamOracleTimeColTable( this );
		tableTimeDef = new CFBamOracleTimeDefTable( this );
		tableTimeType = new CFBamOracleTimeTypeTable( this );
		tableTimestampCol = new CFBamOracleTimestampColTable( this );
		tableTimestampDef = new CFBamOracleTimestampDefTable( this );
		tableTimestampType = new CFBamOracleTimestampTypeTable( this );
		tableTld = new CFBamOracleTldTable( this );
		tableTokenCol = new CFBamOracleTokenColTable( this );
		tableTokenDef = new CFBamOracleTokenDefTable( this );
		tableTokenType = new CFBamOracleTokenTypeTable( this );
		tableTopDomain = new CFBamOracleTopDomainTable( this );
		tableTopProject = new CFBamOracleTopProjectTable( this );
		tableUInt16Col = new CFBamOracleUInt16ColTable( this );
		tableUInt16Def = new CFBamOracleUInt16DefTable( this );
		tableUInt16Type = new CFBamOracleUInt16TypeTable( this );
		tableUInt32Col = new CFBamOracleUInt32ColTable( this );
		tableUInt32Def = new CFBamOracleUInt32DefTable( this );
		tableUInt32Type = new CFBamOracleUInt32TypeTable( this );
		tableUInt64Col = new CFBamOracleUInt64ColTable( this );
		tableUInt64Def = new CFBamOracleUInt64DefTable( this );
		tableUInt64Type = new CFBamOracleUInt64TypeTable( this );
		tableURLProtocol = new CFBamOracleURLProtocolTable( this );
		tableUuidCol = new CFBamOracleUuidColTable( this );
		tableUuidDef = new CFBamOracleUuidDefTable( this );
		tableUuidGen = new CFBamOracleUuidGenTable( this );
		tableUuidType = new CFBamOracleUuidTypeTable( this );
		tableValue = new CFBamOracleValueTable( this );
		tableVersion = new CFBamOracleVersionTable( this );
	}

	public CFBamOracleSchema( Connection argCnx ) {
		super();
		cnx = argCnx;
		inTransaction = false;
		tableAccessFrequency = new CFBamOracleAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamOracleAccessSecurityTable( this );
		tableAtom = new CFBamOracleAtomTable( this );
		tableAuditAction = new CFBamOracleAuditActionTable( this );
		tableBlobCol = new CFBamOracleBlobColTable( this );
		tableBlobDef = new CFBamOracleBlobDefTable( this );
		tableBlobType = new CFBamOracleBlobTypeTable( this );
		tableBoolCol = new CFBamOracleBoolColTable( this );
		tableBoolDef = new CFBamOracleBoolDefTable( this );
		tableBoolType = new CFBamOracleBoolTypeTable( this );
		tableChain = new CFBamOracleChainTable( this );
		tableClearDep = new CFBamOracleClearDepTable( this );
		tableClearSubDep1 = new CFBamOracleClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamOracleClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamOracleClearSubDep3Table( this );
		tableClearTopDep = new CFBamOracleClearTopDepTable( this );
		tableCluster = new CFBamOracleClusterTable( this );
		tableDataScope = new CFBamOracleDataScopeTable( this );
		tableDateCol = new CFBamOracleDateColTable( this );
		tableDateDef = new CFBamOracleDateDefTable( this );
		tableDateType = new CFBamOracleDateTypeTable( this );
		tableDelDep = new CFBamOracleDelDepTable( this );
		tableDelSubDep1 = new CFBamOracleDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamOracleDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamOracleDelSubDep3Table( this );
		tableDelTopDep = new CFBamOracleDelTopDepTable( this );
		tableDomain = new CFBamOracleDomainTable( this );
		tableDomainBase = new CFBamOracleDomainBaseTable( this );
		tableDoubleCol = new CFBamOracleDoubleColTable( this );
		tableDoubleDef = new CFBamOracleDoubleDefTable( this );
		tableDoubleType = new CFBamOracleDoubleTypeTable( this );
		tableEnumCol = new CFBamOracleEnumColTable( this );
		tableEnumDef = new CFBamOracleEnumDefTable( this );
		tableEnumTag = new CFBamOracleEnumTagTable( this );
		tableEnumType = new CFBamOracleEnumTypeTable( this );
		tableFloatCol = new CFBamOracleFloatColTable( this );
		tableFloatDef = new CFBamOracleFloatDefTable( this );
		tableFloatType = new CFBamOracleFloatTypeTable( this );
		tableHostNode = new CFBamOracleHostNodeTable( this );
		tableISOCountry = new CFBamOracleISOCountryTable( this );
		tableISOCountryCurrency = new CFBamOracleISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamOracleISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamOracleISOCurrencyTable( this );
		tableISOLanguage = new CFBamOracleISOLanguageTable( this );
		tableISOTimezone = new CFBamOracleISOTimezoneTable( this );
		tableId16Gen = new CFBamOracleId16GenTable( this );
		tableId32Gen = new CFBamOracleId32GenTable( this );
		tableId64Gen = new CFBamOracleId64GenTable( this );
		tableIndex = new CFBamOracleIndexTable( this );
		tableIndexCol = new CFBamOracleIndexColTable( this );
		tableInt16Col = new CFBamOracleInt16ColTable( this );
		tableInt16Def = new CFBamOracleInt16DefTable( this );
		tableInt16Type = new CFBamOracleInt16TypeTable( this );
		tableInt32Col = new CFBamOracleInt32ColTable( this );
		tableInt32Def = new CFBamOracleInt32DefTable( this );
		tableInt32Type = new CFBamOracleInt32TypeTable( this );
		tableInt64Col = new CFBamOracleInt64ColTable( this );
		tableInt64Def = new CFBamOracleInt64DefTable( this );
		tableInt64Type = new CFBamOracleInt64TypeTable( this );
		tableLicense = new CFBamOracleLicenseTable( this );
		tableLoaderBehaviour = new CFBamOracleLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamOracleMajorVersionTable( this );
		tableMimeType = new CFBamOracleMimeTypeTable( this );
		tableMinorVersion = new CFBamOracleMinorVersionTable( this );
		tableNmTokenCol = new CFBamOracleNmTokenColTable( this );
		tableNmTokenDef = new CFBamOracleNmTokenDefTable( this );
		tableNmTokenType = new CFBamOracleNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamOracleNmTokensColTable( this );
		tableNmTokensDef = new CFBamOracleNmTokensDefTable( this );
		tableNmTokensType = new CFBamOracleNmTokensTypeTable( this );
		tableNumberCol = new CFBamOracleNumberColTable( this );
		tableNumberDef = new CFBamOracleNumberDefTable( this );
		tableNumberType = new CFBamOracleNumberTypeTable( this );
		tableParam = new CFBamOracleParamTable( this );
		tablePopDep = new CFBamOraclePopDepTable( this );
		tablePopSubDep1 = new CFBamOraclePopSubDep1Table( this );
		tablePopSubDep2 = new CFBamOraclePopSubDep2Table( this );
		tablePopSubDep3 = new CFBamOraclePopSubDep3Table( this );
		tablePopTopDep = new CFBamOraclePopTopDepTable( this );
		tableProjectBase = new CFBamOracleProjectBaseTable( this );
		tableRealProject = new CFBamOracleRealProjectTable( this );
		tableRelation = new CFBamOracleRelationTable( this );
		tableRelationCol = new CFBamOracleRelationColTable( this );
		tableRelationType = new CFBamOracleRelationTypeTable( this );
		tableSchemaDef = new CFBamOracleSchemaDefTable( this );
		tableSchemaRef = new CFBamOracleSchemaRefTable( this );
		tableScope = new CFBamOracleScopeTable( this );
		tableSecApp = new CFBamOracleSecAppTable( this );
		tableSecDevice = new CFBamOracleSecDeviceTable( this );
		tableSecForm = new CFBamOracleSecFormTable( this );
		tableSecGroup = new CFBamOracleSecGroupTable( this );
		tableSecGroupForm = new CFBamOracleSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamOracleSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamOracleSecGroupMemberTable( this );
		tableSecSession = new CFBamOracleSecSessionTable( this );
		tableSecUser = new CFBamOracleSecUserTable( this );
		tableSecurityScope = new CFBamOracleSecurityScopeTable( this );
		tableServerListFunc = new CFBamOracleServerListFuncTable( this );
		tableServerMethod = new CFBamOracleServerMethodTable( this );
		tableServerObjFunc = new CFBamOracleServerObjFuncTable( this );
		tableServerProc = new CFBamOracleServerProcTable( this );
		tableService = new CFBamOracleServiceTable( this );
		tableServiceType = new CFBamOracleServiceTypeTable( this );
		tableStringCol = new CFBamOracleStringColTable( this );
		tableStringDef = new CFBamOracleStringDefTable( this );
		tableStringType = new CFBamOracleStringTypeTable( this );
		tableSubProject = new CFBamOracleSubProjectTable( this );
		tableSysCluster = new CFBamOracleSysClusterTable( this );
		tableTSecGroup = new CFBamOracleTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamOracleTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamOracleTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamOracleTZDateColTable( this );
		tableTZDateDef = new CFBamOracleTZDateDefTable( this );
		tableTZDateType = new CFBamOracleTZDateTypeTable( this );
		tableTZTimeCol = new CFBamOracleTZTimeColTable( this );
		tableTZTimeDef = new CFBamOracleTZTimeDefTable( this );
		tableTZTimeType = new CFBamOracleTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamOracleTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamOracleTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamOracleTZTimestampTypeTable( this );
		tableTable = new CFBamOracleTableTable( this );
		tableTableCol = new CFBamOracleTableColTable( this );
		tableTenant = new CFBamOracleTenantTable( this );
		tableTextCol = new CFBamOracleTextColTable( this );
		tableTextDef = new CFBamOracleTextDefTable( this );
		tableTextType = new CFBamOracleTextTypeTable( this );
		tableTimeCol = new CFBamOracleTimeColTable( this );
		tableTimeDef = new CFBamOracleTimeDefTable( this );
		tableTimeType = new CFBamOracleTimeTypeTable( this );
		tableTimestampCol = new CFBamOracleTimestampColTable( this );
		tableTimestampDef = new CFBamOracleTimestampDefTable( this );
		tableTimestampType = new CFBamOracleTimestampTypeTable( this );
		tableTld = new CFBamOracleTldTable( this );
		tableTokenCol = new CFBamOracleTokenColTable( this );
		tableTokenDef = new CFBamOracleTokenDefTable( this );
		tableTokenType = new CFBamOracleTokenTypeTable( this );
		tableTopDomain = new CFBamOracleTopDomainTable( this );
		tableTopProject = new CFBamOracleTopProjectTable( this );
		tableUInt16Col = new CFBamOracleUInt16ColTable( this );
		tableUInt16Def = new CFBamOracleUInt16DefTable( this );
		tableUInt16Type = new CFBamOracleUInt16TypeTable( this );
		tableUInt32Col = new CFBamOracleUInt32ColTable( this );
		tableUInt32Def = new CFBamOracleUInt32DefTable( this );
		tableUInt32Type = new CFBamOracleUInt32TypeTable( this );
		tableUInt64Col = new CFBamOracleUInt64ColTable( this );
		tableUInt64Def = new CFBamOracleUInt64DefTable( this );
		tableUInt64Type = new CFBamOracleUInt64TypeTable( this );
		tableURLProtocol = new CFBamOracleURLProtocolTable( this );
		tableUuidCol = new CFBamOracleUuidColTable( this );
		tableUuidDef = new CFBamOracleUuidDefTable( this );
		tableUuidGen = new CFBamOracleUuidGenTable( this );
		tableUuidType = new CFBamOracleUuidTypeTable( this );
		tableValue = new CFBamOracleValueTable( this );
		tableVersion = new CFBamOracleVersionTable( this );
		try {
			cnx.setAutoCommit( false );
			cnx.rollback();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"CFBamOracleSchema-constructor",
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
				DriverManager.registerDriver( new oracle.jdbc.OracleDriver() );
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = configuration.getDbUserName();
			String dbPassword = configuration.getDbPassword();
			String url =
					"jdbc:oracle:thin:@" + dbServer;
			Properties props = new Properties();
			props.setProperty( "user", dbUserName );
			props.setProperty( "password", dbPassword );
			try {
				cnx = DriverManager.getConnection( url, props );
				cnx.setAutoCommit( false );
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
				DriverManager.registerDriver( new oracle.jdbc.OracleDriver() );
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = username;
			String dbPassword = password;
			String url =
					"jdbc:oracle:thin:@" + dbServer;
			Properties props = new Properties();
			props.setProperty( "user", dbUserName );
			props.setProperty( "password", dbPassword );
			try {
				cnx = DriverManager.getConnection( url, props );
				cnx.setAutoCommit( false );
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
			String sql = "SELECT " + getLowerDbSchemaName() + ".sp_is_system_user( ? ) as IsSystemUser FROM DUAL";
			if( stmtSelectIsSystemUser == null ) {
				stmtSelectIsSystemUser = cnx.prepareStatement( sql );
			}
			stmtSelectIsSystemUser.setString( 1, Authorization.getSecUserId().toString() );
			resultSet = stmtSelectIsSystemUser.executeQuery();
			int isSystemUserInt;
			if( resultSet.next() ) {
				isSystemUserInt = resultSet.getInt( 1 );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"nextCFBam",
           			"Query of sp_is_system_user() did not return a result row" );
			}
			resultSet.close();

			if( isSystemUserInt == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
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
			String sql = "SELECT " + getLowerDbSchemaName() + ".sp_is_cluster_user( ?, ?, ? ) as IsClusterUser FROM DUAL";
			if( stmtSelectIsClusterUser == null ) {
				stmtSelectIsClusterUser = cnx.prepareStatement( sql );
			}
			stmtSelectIsClusterUser.setLong( 1, clusterId );
			stmtSelectIsClusterUser.setString( 2, groupName );
			stmtSelectIsClusterUser.setString( 3, Authorization.getSecUserId().toString() );
			resultSet = stmtSelectIsClusterUser.executeQuery();
			int resultFlagInt;
			if( resultSet.next() ) {
				resultFlagInt = resultSet.getInt( 1 );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"isClusterUser",
           			"Query of sp_is_cluster_user() did not return a result row" );
			}
			resultSet.close();
			if( resultFlagInt == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
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
			String sql = "SELECT " + getLowerDbSchemaName() + ".sp_is_tenant_user( ?, ?, ? ) as IsTenantUser FROM DUAL";
			if( stmtSelectIsTenantUser == null ) {
				stmtSelectIsTenantUser = cnx.prepareStatement( sql );
			}
			stmtSelectIsTenantUser.setLong( 1, tenantId );
			stmtSelectIsTenantUser.setString( 2, groupName );
			stmtSelectIsTenantUser.setString( 3, Authorization.getSecUserId().toString() );
			resultSet = stmtSelectIsTenantUser.executeQuery();
			int resultFlagInt;
			if( resultSet.next() ) {
				resultFlagInt = resultSet.getInt( 1 );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"isTenantUser",
           			"Query of sp_is_tenant_user() did not return a result row" );
			}
			resultSet.close();
			if( resultFlagInt == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
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
			String sql = "SELECT " + getLowerDbSchemaName() + ".nxt_servicetypeidgen() as NextServiceTypeIdGen from dual";
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
           			"Query of nxt_servicetypeidgen() did not return a result row" );
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
			String sql = "SELECT " + getLowerDbSchemaName() + ".nxt_mimetypeidgen() as NextMimeTypeIdGen from dual";
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
           			"Query of nxt_mimetypeidgen() did not return a result row" );
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
			String sql = "SELECT " + getLowerDbSchemaName() + ".nxt_clusteridgen() as NextClusterIdGen from dual";
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
           			"Query did not return a result row" );
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
			String sql = "SELECT " + getLowerDbSchemaName() + ".nxt_tenantidgen() as NextTenantIdGen from dual";
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
           			"Query did not return a result row" );
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
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextServiceTypeIdGen = null;
		}
		if( stmtSelectNextMimeTypeIdGen != null ) {
			try {
				stmtSelectNextMimeTypeIdGen.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextMimeTypeIdGen = null;
		}
		if( stmtSelectNextClusterIdGen != null ) {
			try {
				stmtSelectNextClusterIdGen.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextClusterIdGen = null;
		}
		if( stmtSelectNextTenantIdGen != null ) {
			try {
				stmtSelectNextTenantIdGen.close();
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextTenantIdGen = null;
		}

		if( ( tableAccessFrequency != null ) && ( tableAccessFrequency instanceof CFBamOracleAccessFrequencyTable ) ) {
			CFBamOracleAccessFrequencyTable table = (CFBamOracleAccessFrequencyTable)tableAccessFrequency;
			table.releasePreparedStatements();
		}
		if( ( tableAccessSecurity != null ) && ( tableAccessSecurity instanceof CFBamOracleAccessSecurityTable ) ) {
			CFBamOracleAccessSecurityTable table = (CFBamOracleAccessSecurityTable)tableAccessSecurity;
			table.releasePreparedStatements();
		}
		if( ( tableAtom != null ) && ( tableAtom instanceof CFBamOracleAtomTable ) ) {
			CFBamOracleAtomTable table = (CFBamOracleAtomTable)tableAtom;
			table.releasePreparedStatements();
		}
		if( ( tableAuditAction != null ) && ( tableAuditAction instanceof CFBamOracleAuditActionTable ) ) {
			CFBamOracleAuditActionTable table = (CFBamOracleAuditActionTable)tableAuditAction;
			table.releasePreparedStatements();
		}
		if( ( tableBlobCol != null ) && ( tableBlobCol instanceof CFBamOracleBlobColTable ) ) {
			CFBamOracleBlobColTable table = (CFBamOracleBlobColTable)tableBlobCol;
			table.releasePreparedStatements();
		}
		if( ( tableBlobDef != null ) && ( tableBlobDef instanceof CFBamOracleBlobDefTable ) ) {
			CFBamOracleBlobDefTable table = (CFBamOracleBlobDefTable)tableBlobDef;
			table.releasePreparedStatements();
		}
		if( ( tableBlobType != null ) && ( tableBlobType instanceof CFBamOracleBlobTypeTable ) ) {
			CFBamOracleBlobTypeTable table = (CFBamOracleBlobTypeTable)tableBlobType;
			table.releasePreparedStatements();
		}
		if( ( tableBoolCol != null ) && ( tableBoolCol instanceof CFBamOracleBoolColTable ) ) {
			CFBamOracleBoolColTable table = (CFBamOracleBoolColTable)tableBoolCol;
			table.releasePreparedStatements();
		}
		if( ( tableBoolDef != null ) && ( tableBoolDef instanceof CFBamOracleBoolDefTable ) ) {
			CFBamOracleBoolDefTable table = (CFBamOracleBoolDefTable)tableBoolDef;
			table.releasePreparedStatements();
		}
		if( ( tableBoolType != null ) && ( tableBoolType instanceof CFBamOracleBoolTypeTable ) ) {
			CFBamOracleBoolTypeTable table = (CFBamOracleBoolTypeTable)tableBoolType;
			table.releasePreparedStatements();
		}
		if( ( tableChain != null ) && ( tableChain instanceof CFBamOracleChainTable ) ) {
			CFBamOracleChainTable table = (CFBamOracleChainTable)tableChain;
			table.releasePreparedStatements();
		}
		if( ( tableClearDep != null ) && ( tableClearDep instanceof CFBamOracleClearDepTable ) ) {
			CFBamOracleClearDepTable table = (CFBamOracleClearDepTable)tableClearDep;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep1 != null ) && ( tableClearSubDep1 instanceof CFBamOracleClearSubDep1Table ) ) {
			CFBamOracleClearSubDep1Table table = (CFBamOracleClearSubDep1Table)tableClearSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep2 != null ) && ( tableClearSubDep2 instanceof CFBamOracleClearSubDep2Table ) ) {
			CFBamOracleClearSubDep2Table table = (CFBamOracleClearSubDep2Table)tableClearSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep3 != null ) && ( tableClearSubDep3 instanceof CFBamOracleClearSubDep3Table ) ) {
			CFBamOracleClearSubDep3Table table = (CFBamOracleClearSubDep3Table)tableClearSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tableClearTopDep != null ) && ( tableClearTopDep instanceof CFBamOracleClearTopDepTable ) ) {
			CFBamOracleClearTopDepTable table = (CFBamOracleClearTopDepTable)tableClearTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableCluster != null ) && ( tableCluster instanceof CFBamOracleClusterTable ) ) {
			CFBamOracleClusterTable table = (CFBamOracleClusterTable)tableCluster;
			table.releasePreparedStatements();
		}
		if( ( tableDataScope != null ) && ( tableDataScope instanceof CFBamOracleDataScopeTable ) ) {
			CFBamOracleDataScopeTable table = (CFBamOracleDataScopeTable)tableDataScope;
			table.releasePreparedStatements();
		}
		if( ( tableDateCol != null ) && ( tableDateCol instanceof CFBamOracleDateColTable ) ) {
			CFBamOracleDateColTable table = (CFBamOracleDateColTable)tableDateCol;
			table.releasePreparedStatements();
		}
		if( ( tableDateDef != null ) && ( tableDateDef instanceof CFBamOracleDateDefTable ) ) {
			CFBamOracleDateDefTable table = (CFBamOracleDateDefTable)tableDateDef;
			table.releasePreparedStatements();
		}
		if( ( tableDateType != null ) && ( tableDateType instanceof CFBamOracleDateTypeTable ) ) {
			CFBamOracleDateTypeTable table = (CFBamOracleDateTypeTable)tableDateType;
			table.releasePreparedStatements();
		}
		if( ( tableDelDep != null ) && ( tableDelDep instanceof CFBamOracleDelDepTable ) ) {
			CFBamOracleDelDepTable table = (CFBamOracleDelDepTable)tableDelDep;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep1 != null ) && ( tableDelSubDep1 instanceof CFBamOracleDelSubDep1Table ) ) {
			CFBamOracleDelSubDep1Table table = (CFBamOracleDelSubDep1Table)tableDelSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep2 != null ) && ( tableDelSubDep2 instanceof CFBamOracleDelSubDep2Table ) ) {
			CFBamOracleDelSubDep2Table table = (CFBamOracleDelSubDep2Table)tableDelSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep3 != null ) && ( tableDelSubDep3 instanceof CFBamOracleDelSubDep3Table ) ) {
			CFBamOracleDelSubDep3Table table = (CFBamOracleDelSubDep3Table)tableDelSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tableDelTopDep != null ) && ( tableDelTopDep instanceof CFBamOracleDelTopDepTable ) ) {
			CFBamOracleDelTopDepTable table = (CFBamOracleDelTopDepTable)tableDelTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableDomain != null ) && ( tableDomain instanceof CFBamOracleDomainTable ) ) {
			CFBamOracleDomainTable table = (CFBamOracleDomainTable)tableDomain;
			table.releasePreparedStatements();
		}
		if( ( tableDomainBase != null ) && ( tableDomainBase instanceof CFBamOracleDomainBaseTable ) ) {
			CFBamOracleDomainBaseTable table = (CFBamOracleDomainBaseTable)tableDomainBase;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleCol != null ) && ( tableDoubleCol instanceof CFBamOracleDoubleColTable ) ) {
			CFBamOracleDoubleColTable table = (CFBamOracleDoubleColTable)tableDoubleCol;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleDef != null ) && ( tableDoubleDef instanceof CFBamOracleDoubleDefTable ) ) {
			CFBamOracleDoubleDefTable table = (CFBamOracleDoubleDefTable)tableDoubleDef;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleType != null ) && ( tableDoubleType instanceof CFBamOracleDoubleTypeTable ) ) {
			CFBamOracleDoubleTypeTable table = (CFBamOracleDoubleTypeTable)tableDoubleType;
			table.releasePreparedStatements();
		}
		if( ( tableEnumCol != null ) && ( tableEnumCol instanceof CFBamOracleEnumColTable ) ) {
			CFBamOracleEnumColTable table = (CFBamOracleEnumColTable)tableEnumCol;
			table.releasePreparedStatements();
		}
		if( ( tableEnumDef != null ) && ( tableEnumDef instanceof CFBamOracleEnumDefTable ) ) {
			CFBamOracleEnumDefTable table = (CFBamOracleEnumDefTable)tableEnumDef;
			table.releasePreparedStatements();
		}
		if( ( tableEnumTag != null ) && ( tableEnumTag instanceof CFBamOracleEnumTagTable ) ) {
			CFBamOracleEnumTagTable table = (CFBamOracleEnumTagTable)tableEnumTag;
			table.releasePreparedStatements();
		}
		if( ( tableEnumType != null ) && ( tableEnumType instanceof CFBamOracleEnumTypeTable ) ) {
			CFBamOracleEnumTypeTable table = (CFBamOracleEnumTypeTable)tableEnumType;
			table.releasePreparedStatements();
		}
		if( ( tableFloatCol != null ) && ( tableFloatCol instanceof CFBamOracleFloatColTable ) ) {
			CFBamOracleFloatColTable table = (CFBamOracleFloatColTable)tableFloatCol;
			table.releasePreparedStatements();
		}
		if( ( tableFloatDef != null ) && ( tableFloatDef instanceof CFBamOracleFloatDefTable ) ) {
			CFBamOracleFloatDefTable table = (CFBamOracleFloatDefTable)tableFloatDef;
			table.releasePreparedStatements();
		}
		if( ( tableFloatType != null ) && ( tableFloatType instanceof CFBamOracleFloatTypeTable ) ) {
			CFBamOracleFloatTypeTable table = (CFBamOracleFloatTypeTable)tableFloatType;
			table.releasePreparedStatements();
		}
		if( ( tableHostNode != null ) && ( tableHostNode instanceof CFBamOracleHostNodeTable ) ) {
			CFBamOracleHostNodeTable table = (CFBamOracleHostNodeTable)tableHostNode;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountry != null ) && ( tableISOCountry instanceof CFBamOracleISOCountryTable ) ) {
			CFBamOracleISOCountryTable table = (CFBamOracleISOCountryTable)tableISOCountry;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountryCurrency != null ) && ( tableISOCountryCurrency instanceof CFBamOracleISOCountryCurrencyTable ) ) {
			CFBamOracleISOCountryCurrencyTable table = (CFBamOracleISOCountryCurrencyTable)tableISOCountryCurrency;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountryLanguage != null ) && ( tableISOCountryLanguage instanceof CFBamOracleISOCountryLanguageTable ) ) {
			CFBamOracleISOCountryLanguageTable table = (CFBamOracleISOCountryLanguageTable)tableISOCountryLanguage;
			table.releasePreparedStatements();
		}
		if( ( tableISOCurrency != null ) && ( tableISOCurrency instanceof CFBamOracleISOCurrencyTable ) ) {
			CFBamOracleISOCurrencyTable table = (CFBamOracleISOCurrencyTable)tableISOCurrency;
			table.releasePreparedStatements();
		}
		if( ( tableISOLanguage != null ) && ( tableISOLanguage instanceof CFBamOracleISOLanguageTable ) ) {
			CFBamOracleISOLanguageTable table = (CFBamOracleISOLanguageTable)tableISOLanguage;
			table.releasePreparedStatements();
		}
		if( ( tableISOTimezone != null ) && ( tableISOTimezone instanceof CFBamOracleISOTimezoneTable ) ) {
			CFBamOracleISOTimezoneTable table = (CFBamOracleISOTimezoneTable)tableISOTimezone;
			table.releasePreparedStatements();
		}
		if( ( tableId16Gen != null ) && ( tableId16Gen instanceof CFBamOracleId16GenTable ) ) {
			CFBamOracleId16GenTable table = (CFBamOracleId16GenTable)tableId16Gen;
			table.releasePreparedStatements();
		}
		if( ( tableId32Gen != null ) && ( tableId32Gen instanceof CFBamOracleId32GenTable ) ) {
			CFBamOracleId32GenTable table = (CFBamOracleId32GenTable)tableId32Gen;
			table.releasePreparedStatements();
		}
		if( ( tableId64Gen != null ) && ( tableId64Gen instanceof CFBamOracleId64GenTable ) ) {
			CFBamOracleId64GenTable table = (CFBamOracleId64GenTable)tableId64Gen;
			table.releasePreparedStatements();
		}
		if( ( tableIndex != null ) && ( tableIndex instanceof CFBamOracleIndexTable ) ) {
			CFBamOracleIndexTable table = (CFBamOracleIndexTable)tableIndex;
			table.releasePreparedStatements();
		}
		if( ( tableIndexCol != null ) && ( tableIndexCol instanceof CFBamOracleIndexColTable ) ) {
			CFBamOracleIndexColTable table = (CFBamOracleIndexColTable)tableIndexCol;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Col != null ) && ( tableInt16Col instanceof CFBamOracleInt16ColTable ) ) {
			CFBamOracleInt16ColTable table = (CFBamOracleInt16ColTable)tableInt16Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Def != null ) && ( tableInt16Def instanceof CFBamOracleInt16DefTable ) ) {
			CFBamOracleInt16DefTable table = (CFBamOracleInt16DefTable)tableInt16Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Type != null ) && ( tableInt16Type instanceof CFBamOracleInt16TypeTable ) ) {
			CFBamOracleInt16TypeTable table = (CFBamOracleInt16TypeTable)tableInt16Type;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Col != null ) && ( tableInt32Col instanceof CFBamOracleInt32ColTable ) ) {
			CFBamOracleInt32ColTable table = (CFBamOracleInt32ColTable)tableInt32Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Def != null ) && ( tableInt32Def instanceof CFBamOracleInt32DefTable ) ) {
			CFBamOracleInt32DefTable table = (CFBamOracleInt32DefTable)tableInt32Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Type != null ) && ( tableInt32Type instanceof CFBamOracleInt32TypeTable ) ) {
			CFBamOracleInt32TypeTable table = (CFBamOracleInt32TypeTable)tableInt32Type;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Col != null ) && ( tableInt64Col instanceof CFBamOracleInt64ColTable ) ) {
			CFBamOracleInt64ColTable table = (CFBamOracleInt64ColTable)tableInt64Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Def != null ) && ( tableInt64Def instanceof CFBamOracleInt64DefTable ) ) {
			CFBamOracleInt64DefTable table = (CFBamOracleInt64DefTable)tableInt64Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Type != null ) && ( tableInt64Type instanceof CFBamOracleInt64TypeTable ) ) {
			CFBamOracleInt64TypeTable table = (CFBamOracleInt64TypeTable)tableInt64Type;
			table.releasePreparedStatements();
		}
		if( ( tableLicense != null ) && ( tableLicense instanceof CFBamOracleLicenseTable ) ) {
			CFBamOracleLicenseTable table = (CFBamOracleLicenseTable)tableLicense;
			table.releasePreparedStatements();
		}
		if( ( tableLoaderBehaviour != null ) && ( tableLoaderBehaviour instanceof CFBamOracleLoaderBehaviourTable ) ) {
			CFBamOracleLoaderBehaviourTable table = (CFBamOracleLoaderBehaviourTable)tableLoaderBehaviour;
			table.releasePreparedStatements();
		}
		if( ( tableMajorVersion != null ) && ( tableMajorVersion instanceof CFBamOracleMajorVersionTable ) ) {
			CFBamOracleMajorVersionTable table = (CFBamOracleMajorVersionTable)tableMajorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableMimeType != null ) && ( tableMimeType instanceof CFBamOracleMimeTypeTable ) ) {
			CFBamOracleMimeTypeTable table = (CFBamOracleMimeTypeTable)tableMimeType;
			table.releasePreparedStatements();
		}
		if( ( tableMinorVersion != null ) && ( tableMinorVersion instanceof CFBamOracleMinorVersionTable ) ) {
			CFBamOracleMinorVersionTable table = (CFBamOracleMinorVersionTable)tableMinorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenCol != null ) && ( tableNmTokenCol instanceof CFBamOracleNmTokenColTable ) ) {
			CFBamOracleNmTokenColTable table = (CFBamOracleNmTokenColTable)tableNmTokenCol;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenDef != null ) && ( tableNmTokenDef instanceof CFBamOracleNmTokenDefTable ) ) {
			CFBamOracleNmTokenDefTable table = (CFBamOracleNmTokenDefTable)tableNmTokenDef;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenType != null ) && ( tableNmTokenType instanceof CFBamOracleNmTokenTypeTable ) ) {
			CFBamOracleNmTokenTypeTable table = (CFBamOracleNmTokenTypeTable)tableNmTokenType;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensCol != null ) && ( tableNmTokensCol instanceof CFBamOracleNmTokensColTable ) ) {
			CFBamOracleNmTokensColTable table = (CFBamOracleNmTokensColTable)tableNmTokensCol;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensDef != null ) && ( tableNmTokensDef instanceof CFBamOracleNmTokensDefTable ) ) {
			CFBamOracleNmTokensDefTable table = (CFBamOracleNmTokensDefTable)tableNmTokensDef;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensType != null ) && ( tableNmTokensType instanceof CFBamOracleNmTokensTypeTable ) ) {
			CFBamOracleNmTokensTypeTable table = (CFBamOracleNmTokensTypeTable)tableNmTokensType;
			table.releasePreparedStatements();
		}
		if( ( tableNumberCol != null ) && ( tableNumberCol instanceof CFBamOracleNumberColTable ) ) {
			CFBamOracleNumberColTable table = (CFBamOracleNumberColTable)tableNumberCol;
			table.releasePreparedStatements();
		}
		if( ( tableNumberDef != null ) && ( tableNumberDef instanceof CFBamOracleNumberDefTable ) ) {
			CFBamOracleNumberDefTable table = (CFBamOracleNumberDefTable)tableNumberDef;
			table.releasePreparedStatements();
		}
		if( ( tableNumberType != null ) && ( tableNumberType instanceof CFBamOracleNumberTypeTable ) ) {
			CFBamOracleNumberTypeTable table = (CFBamOracleNumberTypeTable)tableNumberType;
			table.releasePreparedStatements();
		}
		if( ( tableParam != null ) && ( tableParam instanceof CFBamOracleParamTable ) ) {
			CFBamOracleParamTable table = (CFBamOracleParamTable)tableParam;
			table.releasePreparedStatements();
		}
		if( ( tablePopDep != null ) && ( tablePopDep instanceof CFBamOraclePopDepTable ) ) {
			CFBamOraclePopDepTable table = (CFBamOraclePopDepTable)tablePopDep;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep1 != null ) && ( tablePopSubDep1 instanceof CFBamOraclePopSubDep1Table ) ) {
			CFBamOraclePopSubDep1Table table = (CFBamOraclePopSubDep1Table)tablePopSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep2 != null ) && ( tablePopSubDep2 instanceof CFBamOraclePopSubDep2Table ) ) {
			CFBamOraclePopSubDep2Table table = (CFBamOraclePopSubDep2Table)tablePopSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep3 != null ) && ( tablePopSubDep3 instanceof CFBamOraclePopSubDep3Table ) ) {
			CFBamOraclePopSubDep3Table table = (CFBamOraclePopSubDep3Table)tablePopSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tablePopTopDep != null ) && ( tablePopTopDep instanceof CFBamOraclePopTopDepTable ) ) {
			CFBamOraclePopTopDepTable table = (CFBamOraclePopTopDepTable)tablePopTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableProjectBase != null ) && ( tableProjectBase instanceof CFBamOracleProjectBaseTable ) ) {
			CFBamOracleProjectBaseTable table = (CFBamOracleProjectBaseTable)tableProjectBase;
			table.releasePreparedStatements();
		}
		if( ( tableRealProject != null ) && ( tableRealProject instanceof CFBamOracleRealProjectTable ) ) {
			CFBamOracleRealProjectTable table = (CFBamOracleRealProjectTable)tableRealProject;
			table.releasePreparedStatements();
		}
		if( ( tableRelation != null ) && ( tableRelation instanceof CFBamOracleRelationTable ) ) {
			CFBamOracleRelationTable table = (CFBamOracleRelationTable)tableRelation;
			table.releasePreparedStatements();
		}
		if( ( tableRelationCol != null ) && ( tableRelationCol instanceof CFBamOracleRelationColTable ) ) {
			CFBamOracleRelationColTable table = (CFBamOracleRelationColTable)tableRelationCol;
			table.releasePreparedStatements();
		}
		if( ( tableRelationType != null ) && ( tableRelationType instanceof CFBamOracleRelationTypeTable ) ) {
			CFBamOracleRelationTypeTable table = (CFBamOracleRelationTypeTable)tableRelationType;
			table.releasePreparedStatements();
		}
		if( ( tableSchemaDef != null ) && ( tableSchemaDef instanceof CFBamOracleSchemaDefTable ) ) {
			CFBamOracleSchemaDefTable table = (CFBamOracleSchemaDefTable)tableSchemaDef;
			table.releasePreparedStatements();
		}
		if( ( tableSchemaRef != null ) && ( tableSchemaRef instanceof CFBamOracleSchemaRefTable ) ) {
			CFBamOracleSchemaRefTable table = (CFBamOracleSchemaRefTable)tableSchemaRef;
			table.releasePreparedStatements();
		}
		if( ( tableScope != null ) && ( tableScope instanceof CFBamOracleScopeTable ) ) {
			CFBamOracleScopeTable table = (CFBamOracleScopeTable)tableScope;
			table.releasePreparedStatements();
		}
		if( ( tableSecApp != null ) && ( tableSecApp instanceof CFBamOracleSecAppTable ) ) {
			CFBamOracleSecAppTable table = (CFBamOracleSecAppTable)tableSecApp;
			table.releasePreparedStatements();
		}
		if( ( tableSecDevice != null ) && ( tableSecDevice instanceof CFBamOracleSecDeviceTable ) ) {
			CFBamOracleSecDeviceTable table = (CFBamOracleSecDeviceTable)tableSecDevice;
			table.releasePreparedStatements();
		}
		if( ( tableSecForm != null ) && ( tableSecForm instanceof CFBamOracleSecFormTable ) ) {
			CFBamOracleSecFormTable table = (CFBamOracleSecFormTable)tableSecForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroup != null ) && ( tableSecGroup instanceof CFBamOracleSecGroupTable ) ) {
			CFBamOracleSecGroupTable table = (CFBamOracleSecGroupTable)tableSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupForm != null ) && ( tableSecGroupForm instanceof CFBamOracleSecGroupFormTable ) ) {
			CFBamOracleSecGroupFormTable table = (CFBamOracleSecGroupFormTable)tableSecGroupForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupInclude != null ) && ( tableSecGroupInclude instanceof CFBamOracleSecGroupIncludeTable ) ) {
			CFBamOracleSecGroupIncludeTable table = (CFBamOracleSecGroupIncludeTable)tableSecGroupInclude;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupMember != null ) && ( tableSecGroupMember instanceof CFBamOracleSecGroupMemberTable ) ) {
			CFBamOracleSecGroupMemberTable table = (CFBamOracleSecGroupMemberTable)tableSecGroupMember;
			table.releasePreparedStatements();
		}
		if( ( tableSecSession != null ) && ( tableSecSession instanceof CFBamOracleSecSessionTable ) ) {
			CFBamOracleSecSessionTable table = (CFBamOracleSecSessionTable)tableSecSession;
			table.releasePreparedStatements();
		}
		if( ( tableSecUser != null ) && ( tableSecUser instanceof CFBamOracleSecUserTable ) ) {
			CFBamOracleSecUserTable table = (CFBamOracleSecUserTable)tableSecUser;
			table.releasePreparedStatements();
		}
		if( ( tableSecurityScope != null ) && ( tableSecurityScope instanceof CFBamOracleSecurityScopeTable ) ) {
			CFBamOracleSecurityScopeTable table = (CFBamOracleSecurityScopeTable)tableSecurityScope;
			table.releasePreparedStatements();
		}
		if( ( tableServerListFunc != null ) && ( tableServerListFunc instanceof CFBamOracleServerListFuncTable ) ) {
			CFBamOracleServerListFuncTable table = (CFBamOracleServerListFuncTable)tableServerListFunc;
			table.releasePreparedStatements();
		}
		if( ( tableServerMethod != null ) && ( tableServerMethod instanceof CFBamOracleServerMethodTable ) ) {
			CFBamOracleServerMethodTable table = (CFBamOracleServerMethodTable)tableServerMethod;
			table.releasePreparedStatements();
		}
		if( ( tableServerObjFunc != null ) && ( tableServerObjFunc instanceof CFBamOracleServerObjFuncTable ) ) {
			CFBamOracleServerObjFuncTable table = (CFBamOracleServerObjFuncTable)tableServerObjFunc;
			table.releasePreparedStatements();
		}
		if( ( tableServerProc != null ) && ( tableServerProc instanceof CFBamOracleServerProcTable ) ) {
			CFBamOracleServerProcTable table = (CFBamOracleServerProcTable)tableServerProc;
			table.releasePreparedStatements();
		}
		if( ( tableService != null ) && ( tableService instanceof CFBamOracleServiceTable ) ) {
			CFBamOracleServiceTable table = (CFBamOracleServiceTable)tableService;
			table.releasePreparedStatements();
		}
		if( ( tableServiceType != null ) && ( tableServiceType instanceof CFBamOracleServiceTypeTable ) ) {
			CFBamOracleServiceTypeTable table = (CFBamOracleServiceTypeTable)tableServiceType;
			table.releasePreparedStatements();
		}
		if( ( tableStringCol != null ) && ( tableStringCol instanceof CFBamOracleStringColTable ) ) {
			CFBamOracleStringColTable table = (CFBamOracleStringColTable)tableStringCol;
			table.releasePreparedStatements();
		}
		if( ( tableStringDef != null ) && ( tableStringDef instanceof CFBamOracleStringDefTable ) ) {
			CFBamOracleStringDefTable table = (CFBamOracleStringDefTable)tableStringDef;
			table.releasePreparedStatements();
		}
		if( ( tableStringType != null ) && ( tableStringType instanceof CFBamOracleStringTypeTable ) ) {
			CFBamOracleStringTypeTable table = (CFBamOracleStringTypeTable)tableStringType;
			table.releasePreparedStatements();
		}
		if( ( tableSubProject != null ) && ( tableSubProject instanceof CFBamOracleSubProjectTable ) ) {
			CFBamOracleSubProjectTable table = (CFBamOracleSubProjectTable)tableSubProject;
			table.releasePreparedStatements();
		}
		if( ( tableSysCluster != null ) && ( tableSysCluster instanceof CFBamOracleSysClusterTable ) ) {
			CFBamOracleSysClusterTable table = (CFBamOracleSysClusterTable)tableSysCluster;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroup != null ) && ( tableTSecGroup instanceof CFBamOracleTSecGroupTable ) ) {
			CFBamOracleTSecGroupTable table = (CFBamOracleTSecGroupTable)tableTSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroupInclude != null ) && ( tableTSecGroupInclude instanceof CFBamOracleTSecGroupIncludeTable ) ) {
			CFBamOracleTSecGroupIncludeTable table = (CFBamOracleTSecGroupIncludeTable)tableTSecGroupInclude;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroupMember != null ) && ( tableTSecGroupMember instanceof CFBamOracleTSecGroupMemberTable ) ) {
			CFBamOracleTSecGroupMemberTable table = (CFBamOracleTSecGroupMemberTable)tableTSecGroupMember;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateCol != null ) && ( tableTZDateCol instanceof CFBamOracleTZDateColTable ) ) {
			CFBamOracleTZDateColTable table = (CFBamOracleTZDateColTable)tableTZDateCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateDef != null ) && ( tableTZDateDef instanceof CFBamOracleTZDateDefTable ) ) {
			CFBamOracleTZDateDefTable table = (CFBamOracleTZDateDefTable)tableTZDateDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateType != null ) && ( tableTZDateType instanceof CFBamOracleTZDateTypeTable ) ) {
			CFBamOracleTZDateTypeTable table = (CFBamOracleTZDateTypeTable)tableTZDateType;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeCol != null ) && ( tableTZTimeCol instanceof CFBamOracleTZTimeColTable ) ) {
			CFBamOracleTZTimeColTable table = (CFBamOracleTZTimeColTable)tableTZTimeCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeDef != null ) && ( tableTZTimeDef instanceof CFBamOracleTZTimeDefTable ) ) {
			CFBamOracleTZTimeDefTable table = (CFBamOracleTZTimeDefTable)tableTZTimeDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeType != null ) && ( tableTZTimeType instanceof CFBamOracleTZTimeTypeTable ) ) {
			CFBamOracleTZTimeTypeTable table = (CFBamOracleTZTimeTypeTable)tableTZTimeType;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampCol != null ) && ( tableTZTimestampCol instanceof CFBamOracleTZTimestampColTable ) ) {
			CFBamOracleTZTimestampColTable table = (CFBamOracleTZTimestampColTable)tableTZTimestampCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampDef != null ) && ( tableTZTimestampDef instanceof CFBamOracleTZTimestampDefTable ) ) {
			CFBamOracleTZTimestampDefTable table = (CFBamOracleTZTimestampDefTable)tableTZTimestampDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampType != null ) && ( tableTZTimestampType instanceof CFBamOracleTZTimestampTypeTable ) ) {
			CFBamOracleTZTimestampTypeTable table = (CFBamOracleTZTimestampTypeTable)tableTZTimestampType;
			table.releasePreparedStatements();
		}
		if( ( tableTable != null ) && ( tableTable instanceof CFBamOracleTableTable ) ) {
			CFBamOracleTableTable table = (CFBamOracleTableTable)tableTable;
			table.releasePreparedStatements();
		}
		if( ( tableTableCol != null ) && ( tableTableCol instanceof CFBamOracleTableColTable ) ) {
			CFBamOracleTableColTable table = (CFBamOracleTableColTable)tableTableCol;
			table.releasePreparedStatements();
		}
		if( ( tableTenant != null ) && ( tableTenant instanceof CFBamOracleTenantTable ) ) {
			CFBamOracleTenantTable table = (CFBamOracleTenantTable)tableTenant;
			table.releasePreparedStatements();
		}
		if( ( tableTextCol != null ) && ( tableTextCol instanceof CFBamOracleTextColTable ) ) {
			CFBamOracleTextColTable table = (CFBamOracleTextColTable)tableTextCol;
			table.releasePreparedStatements();
		}
		if( ( tableTextDef != null ) && ( tableTextDef instanceof CFBamOracleTextDefTable ) ) {
			CFBamOracleTextDefTable table = (CFBamOracleTextDefTable)tableTextDef;
			table.releasePreparedStatements();
		}
		if( ( tableTextType != null ) && ( tableTextType instanceof CFBamOracleTextTypeTable ) ) {
			CFBamOracleTextTypeTable table = (CFBamOracleTextTypeTable)tableTextType;
			table.releasePreparedStatements();
		}
		if( ( tableTimeCol != null ) && ( tableTimeCol instanceof CFBamOracleTimeColTable ) ) {
			CFBamOracleTimeColTable table = (CFBamOracleTimeColTable)tableTimeCol;
			table.releasePreparedStatements();
		}
		if( ( tableTimeDef != null ) && ( tableTimeDef instanceof CFBamOracleTimeDefTable ) ) {
			CFBamOracleTimeDefTable table = (CFBamOracleTimeDefTable)tableTimeDef;
			table.releasePreparedStatements();
		}
		if( ( tableTimeType != null ) && ( tableTimeType instanceof CFBamOracleTimeTypeTable ) ) {
			CFBamOracleTimeTypeTable table = (CFBamOracleTimeTypeTable)tableTimeType;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampCol != null ) && ( tableTimestampCol instanceof CFBamOracleTimestampColTable ) ) {
			CFBamOracleTimestampColTable table = (CFBamOracleTimestampColTable)tableTimestampCol;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampDef != null ) && ( tableTimestampDef instanceof CFBamOracleTimestampDefTable ) ) {
			CFBamOracleTimestampDefTable table = (CFBamOracleTimestampDefTable)tableTimestampDef;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampType != null ) && ( tableTimestampType instanceof CFBamOracleTimestampTypeTable ) ) {
			CFBamOracleTimestampTypeTable table = (CFBamOracleTimestampTypeTable)tableTimestampType;
			table.releasePreparedStatements();
		}
		if( ( tableTld != null ) && ( tableTld instanceof CFBamOracleTldTable ) ) {
			CFBamOracleTldTable table = (CFBamOracleTldTable)tableTld;
			table.releasePreparedStatements();
		}
		if( ( tableTokenCol != null ) && ( tableTokenCol instanceof CFBamOracleTokenColTable ) ) {
			CFBamOracleTokenColTable table = (CFBamOracleTokenColTable)tableTokenCol;
			table.releasePreparedStatements();
		}
		if( ( tableTokenDef != null ) && ( tableTokenDef instanceof CFBamOracleTokenDefTable ) ) {
			CFBamOracleTokenDefTable table = (CFBamOracleTokenDefTable)tableTokenDef;
			table.releasePreparedStatements();
		}
		if( ( tableTokenType != null ) && ( tableTokenType instanceof CFBamOracleTokenTypeTable ) ) {
			CFBamOracleTokenTypeTable table = (CFBamOracleTokenTypeTable)tableTokenType;
			table.releasePreparedStatements();
		}
		if( ( tableTopDomain != null ) && ( tableTopDomain instanceof CFBamOracleTopDomainTable ) ) {
			CFBamOracleTopDomainTable table = (CFBamOracleTopDomainTable)tableTopDomain;
			table.releasePreparedStatements();
		}
		if( ( tableTopProject != null ) && ( tableTopProject instanceof CFBamOracleTopProjectTable ) ) {
			CFBamOracleTopProjectTable table = (CFBamOracleTopProjectTable)tableTopProject;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Col != null ) && ( tableUInt16Col instanceof CFBamOracleUInt16ColTable ) ) {
			CFBamOracleUInt16ColTable table = (CFBamOracleUInt16ColTable)tableUInt16Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Def != null ) && ( tableUInt16Def instanceof CFBamOracleUInt16DefTable ) ) {
			CFBamOracleUInt16DefTable table = (CFBamOracleUInt16DefTable)tableUInt16Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Type != null ) && ( tableUInt16Type instanceof CFBamOracleUInt16TypeTable ) ) {
			CFBamOracleUInt16TypeTable table = (CFBamOracleUInt16TypeTable)tableUInt16Type;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Col != null ) && ( tableUInt32Col instanceof CFBamOracleUInt32ColTable ) ) {
			CFBamOracleUInt32ColTable table = (CFBamOracleUInt32ColTable)tableUInt32Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Def != null ) && ( tableUInt32Def instanceof CFBamOracleUInt32DefTable ) ) {
			CFBamOracleUInt32DefTable table = (CFBamOracleUInt32DefTable)tableUInt32Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Type != null ) && ( tableUInt32Type instanceof CFBamOracleUInt32TypeTable ) ) {
			CFBamOracleUInt32TypeTable table = (CFBamOracleUInt32TypeTable)tableUInt32Type;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Col != null ) && ( tableUInt64Col instanceof CFBamOracleUInt64ColTable ) ) {
			CFBamOracleUInt64ColTable table = (CFBamOracleUInt64ColTable)tableUInt64Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Def != null ) && ( tableUInt64Def instanceof CFBamOracleUInt64DefTable ) ) {
			CFBamOracleUInt64DefTable table = (CFBamOracleUInt64DefTable)tableUInt64Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Type != null ) && ( tableUInt64Type instanceof CFBamOracleUInt64TypeTable ) ) {
			CFBamOracleUInt64TypeTable table = (CFBamOracleUInt64TypeTable)tableUInt64Type;
			table.releasePreparedStatements();
		}
		if( ( tableURLProtocol != null ) && ( tableURLProtocol instanceof CFBamOracleURLProtocolTable ) ) {
			CFBamOracleURLProtocolTable table = (CFBamOracleURLProtocolTable)tableURLProtocol;
			table.releasePreparedStatements();
		}
		if( ( tableUuidCol != null ) && ( tableUuidCol instanceof CFBamOracleUuidColTable ) ) {
			CFBamOracleUuidColTable table = (CFBamOracleUuidColTable)tableUuidCol;
			table.releasePreparedStatements();
		}
		if( ( tableUuidDef != null ) && ( tableUuidDef instanceof CFBamOracleUuidDefTable ) ) {
			CFBamOracleUuidDefTable table = (CFBamOracleUuidDefTable)tableUuidDef;
			table.releasePreparedStatements();
		}
		if( ( tableUuidGen != null ) && ( tableUuidGen instanceof CFBamOracleUuidGenTable ) ) {
			CFBamOracleUuidGenTable table = (CFBamOracleUuidGenTable)tableUuidGen;
			table.releasePreparedStatements();
		}
		if( ( tableUuidType != null ) && ( tableUuidType instanceof CFBamOracleUuidTypeTable ) ) {
			CFBamOracleUuidTypeTable table = (CFBamOracleUuidTypeTable)tableUuidType;
			table.releasePreparedStatements();
		}
		if( ( tableValue != null ) && ( tableValue instanceof CFBamOracleValueTable ) ) {
			CFBamOracleValueTable table = (CFBamOracleValueTable)tableValue;
			table.releasePreparedStatements();
		}
		if( ( tableVersion != null ) && ( tableVersion instanceof CFBamOracleVersionTable ) ) {
			CFBamOracleVersionTable table = (CFBamOracleVersionTable)tableVersion;
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamOracleSchema.class,
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
				return( "Y" );
			}
			else {
				return( "N" );
			}
		}
	}

	public static String getBoolString(boolean val) {
		if( val ) {
			return( "Y" );
		}
		else {
			return( "N" );
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
				"convertDateString",
            	"Value must be in YYYY-MM-DD format, \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 8 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
				"convertTimeString",
            	"Value must be in HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
				"convertTimestampString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
				"convertTZDateString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
				"convertTZTimeString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamOracleSchema.class,
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
