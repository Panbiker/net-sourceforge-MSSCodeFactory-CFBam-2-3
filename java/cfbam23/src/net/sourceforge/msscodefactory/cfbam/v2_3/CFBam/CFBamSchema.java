// Description: Java7 implementation of a CFBam schema.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBam;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

public class CFBamSchema
	implements ICFBamSchema
{
	protected ICFBamTablePerms tablePerms;
	protected CFBamConfigurationFile configuration;
	protected String jndiName;
	protected String schemaDbName = "CFBam23";
	protected String lowerDbSchemaName = schemaDbName.toLowerCase();
	protected ICFBamAccessFrequencyTable tableAccessFrequency;
	protected ICFBamAccessSecurityTable tableAccessSecurity;
	protected ICFBamAtomTable tableAtom;
	protected ICFBamAuditActionTable tableAuditAction;
	protected ICFBamBlobColTable tableBlobCol;
	protected ICFBamBlobDefTable tableBlobDef;
	protected ICFBamBlobTypeTable tableBlobType;
	protected ICFBamBoolColTable tableBoolCol;
	protected ICFBamBoolDefTable tableBoolDef;
	protected ICFBamBoolTypeTable tableBoolType;
	protected ICFBamChainTable tableChain;
	protected ICFBamClearDepTable tableClearDep;
	protected ICFBamClearSubDep1Table tableClearSubDep1;
	protected ICFBamClearSubDep2Table tableClearSubDep2;
	protected ICFBamClearSubDep3Table tableClearSubDep3;
	protected ICFBamClearTopDepTable tableClearTopDep;
	protected ICFBamClusterTable tableCluster;
	protected ICFBamDataScopeTable tableDataScope;
	protected ICFBamDateColTable tableDateCol;
	protected ICFBamDateDefTable tableDateDef;
	protected ICFBamDateTypeTable tableDateType;
	protected ICFBamDelDepTable tableDelDep;
	protected ICFBamDelSubDep1Table tableDelSubDep1;
	protected ICFBamDelSubDep2Table tableDelSubDep2;
	protected ICFBamDelSubDep3Table tableDelSubDep3;
	protected ICFBamDelTopDepTable tableDelTopDep;
	protected ICFBamDomainTable tableDomain;
	protected ICFBamDomainBaseTable tableDomainBase;
	protected ICFBamDoubleColTable tableDoubleCol;
	protected ICFBamDoubleDefTable tableDoubleDef;
	protected ICFBamDoubleTypeTable tableDoubleType;
	protected ICFBamEnumColTable tableEnumCol;
	protected ICFBamEnumDefTable tableEnumDef;
	protected ICFBamEnumTagTable tableEnumTag;
	protected ICFBamEnumTypeTable tableEnumType;
	protected ICFBamFloatColTable tableFloatCol;
	protected ICFBamFloatDefTable tableFloatDef;
	protected ICFBamFloatTypeTable tableFloatType;
	protected ICFBamHostNodeTable tableHostNode;
	protected ICFBamISOCountryTable tableISOCountry;
	protected ICFBamISOCountryCurrencyTable tableISOCountryCurrency;
	protected ICFBamISOCountryLanguageTable tableISOCountryLanguage;
	protected ICFBamISOCurrencyTable tableISOCurrency;
	protected ICFBamISOLanguageTable tableISOLanguage;
	protected ICFBamISOTimezoneTable tableISOTimezone;
	protected ICFBamId16GenTable tableId16Gen;
	protected ICFBamId32GenTable tableId32Gen;
	protected ICFBamId64GenTable tableId64Gen;
	protected ICFBamIndexTable tableIndex;
	protected ICFBamIndexColTable tableIndexCol;
	protected ICFBamInt16ColTable tableInt16Col;
	protected ICFBamInt16DefTable tableInt16Def;
	protected ICFBamInt16TypeTable tableInt16Type;
	protected ICFBamInt32ColTable tableInt32Col;
	protected ICFBamInt32DefTable tableInt32Def;
	protected ICFBamInt32TypeTable tableInt32Type;
	protected ICFBamInt64ColTable tableInt64Col;
	protected ICFBamInt64DefTable tableInt64Def;
	protected ICFBamInt64TypeTable tableInt64Type;
	protected ICFBamLicenseTable tableLicense;
	protected ICFBamLoaderBehaviourTable tableLoaderBehaviour;
	protected ICFBamMajorVersionTable tableMajorVersion;
	protected ICFBamMimeTypeTable tableMimeType;
	protected ICFBamMinorVersionTable tableMinorVersion;
	protected ICFBamNmTokenColTable tableNmTokenCol;
	protected ICFBamNmTokenDefTable tableNmTokenDef;
	protected ICFBamNmTokenTypeTable tableNmTokenType;
	protected ICFBamNmTokensColTable tableNmTokensCol;
	protected ICFBamNmTokensDefTable tableNmTokensDef;
	protected ICFBamNmTokensTypeTable tableNmTokensType;
	protected ICFBamNumberColTable tableNumberCol;
	protected ICFBamNumberDefTable tableNumberDef;
	protected ICFBamNumberTypeTable tableNumberType;
	protected ICFBamParamTable tableParam;
	protected ICFBamPopDepTable tablePopDep;
	protected ICFBamPopSubDep1Table tablePopSubDep1;
	protected ICFBamPopSubDep2Table tablePopSubDep2;
	protected ICFBamPopSubDep3Table tablePopSubDep3;
	protected ICFBamPopTopDepTable tablePopTopDep;
	protected ICFBamProjectBaseTable tableProjectBase;
	protected ICFBamRealProjectTable tableRealProject;
	protected ICFBamRelationTable tableRelation;
	protected ICFBamRelationColTable tableRelationCol;
	protected ICFBamRelationTypeTable tableRelationType;
	protected ICFBamSchemaDefTable tableSchemaDef;
	protected ICFBamSchemaRefTable tableSchemaRef;
	protected ICFBamScopeTable tableScope;
	protected ICFBamSecAppTable tableSecApp;
	protected ICFBamSecDeviceTable tableSecDevice;
	protected ICFBamSecFormTable tableSecForm;
	protected ICFBamSecGroupTable tableSecGroup;
	protected ICFBamSecGroupFormTable tableSecGroupForm;
	protected ICFBamSecGroupIncludeTable tableSecGroupInclude;
	protected ICFBamSecGroupMemberTable tableSecGroupMember;
	protected ICFBamSecSessionTable tableSecSession;
	protected ICFBamSecUserTable tableSecUser;
	protected ICFBamSecurityScopeTable tableSecurityScope;
	protected ICFBamServerListFuncTable tableServerListFunc;
	protected ICFBamServerMethodTable tableServerMethod;
	protected ICFBamServerObjFuncTable tableServerObjFunc;
	protected ICFBamServerProcTable tableServerProc;
	protected ICFBamServiceTable tableService;
	protected ICFBamServiceTypeTable tableServiceType;
	protected ICFBamStringColTable tableStringCol;
	protected ICFBamStringDefTable tableStringDef;
	protected ICFBamStringTypeTable tableStringType;
	protected ICFBamSubProjectTable tableSubProject;
	protected ICFBamSysClusterTable tableSysCluster;
	protected ICFBamTSecGroupTable tableTSecGroup;
	protected ICFBamTSecGroupIncludeTable tableTSecGroupInclude;
	protected ICFBamTSecGroupMemberTable tableTSecGroupMember;
	protected ICFBamTZDateColTable tableTZDateCol;
	protected ICFBamTZDateDefTable tableTZDateDef;
	protected ICFBamTZDateTypeTable tableTZDateType;
	protected ICFBamTZTimeColTable tableTZTimeCol;
	protected ICFBamTZTimeDefTable tableTZTimeDef;
	protected ICFBamTZTimeTypeTable tableTZTimeType;
	protected ICFBamTZTimestampColTable tableTZTimestampCol;
	protected ICFBamTZTimestampDefTable tableTZTimestampDef;
	protected ICFBamTZTimestampTypeTable tableTZTimestampType;
	protected ICFBamTableTable tableTable;
	protected ICFBamTableColTable tableTableCol;
	protected ICFBamTenantTable tableTenant;
	protected ICFBamTextColTable tableTextCol;
	protected ICFBamTextDefTable tableTextDef;
	protected ICFBamTextTypeTable tableTextType;
	protected ICFBamTimeColTable tableTimeCol;
	protected ICFBamTimeDefTable tableTimeDef;
	protected ICFBamTimeTypeTable tableTimeType;
	protected ICFBamTimestampColTable tableTimestampCol;
	protected ICFBamTimestampDefTable tableTimestampDef;
	protected ICFBamTimestampTypeTable tableTimestampType;
	protected ICFBamTldTable tableTld;
	protected ICFBamTokenColTable tableTokenCol;
	protected ICFBamTokenDefTable tableTokenDef;
	protected ICFBamTokenTypeTable tableTokenType;
	protected ICFBamTopDomainTable tableTopDomain;
	protected ICFBamTopProjectTable tableTopProject;
	protected ICFBamUInt16ColTable tableUInt16Col;
	protected ICFBamUInt16DefTable tableUInt16Def;
	protected ICFBamUInt16TypeTable tableUInt16Type;
	protected ICFBamUInt32ColTable tableUInt32Col;
	protected ICFBamUInt32DefTable tableUInt32Def;
	protected ICFBamUInt32TypeTable tableUInt32Type;
	protected ICFBamUInt64ColTable tableUInt64Col;
	protected ICFBamUInt64DefTable tableUInt64Def;
	protected ICFBamUInt64TypeTable tableUInt64Type;
	protected ICFBamURLProtocolTable tableURLProtocol;
	protected ICFBamUuidColTable tableUuidCol;
	protected ICFBamUuidDefTable tableUuidDef;
	protected ICFBamUuidGenTable tableUuidGen;
	protected ICFBamUuidTypeTable tableUuidType;
	protected ICFBamValueTable tableValue;
	protected ICFBamVersionTable tableVersion;

	protected ICFBamAccessFrequencyFactory factoryAccessFrequency;
	protected ICFBamAccessSecurityFactory factoryAccessSecurity;
	protected ICFBamAtomFactory factoryAtom;
	protected ICFBamAuditActionFactory factoryAuditAction;
	protected ICFBamBlobColFactory factoryBlobCol;
	protected ICFBamBlobDefFactory factoryBlobDef;
	protected ICFBamBlobTypeFactory factoryBlobType;
	protected ICFBamBoolColFactory factoryBoolCol;
	protected ICFBamBoolDefFactory factoryBoolDef;
	protected ICFBamBoolTypeFactory factoryBoolType;
	protected ICFBamChainFactory factoryChain;
	protected ICFBamClearDepFactory factoryClearDep;
	protected ICFBamClearSubDep1Factory factoryClearSubDep1;
	protected ICFBamClearSubDep2Factory factoryClearSubDep2;
	protected ICFBamClearSubDep3Factory factoryClearSubDep3;
	protected ICFBamClearTopDepFactory factoryClearTopDep;
	protected ICFBamClusterFactory factoryCluster;
	protected ICFBamDataScopeFactory factoryDataScope;
	protected ICFBamDateColFactory factoryDateCol;
	protected ICFBamDateDefFactory factoryDateDef;
	protected ICFBamDateTypeFactory factoryDateType;
	protected ICFBamDelDepFactory factoryDelDep;
	protected ICFBamDelSubDep1Factory factoryDelSubDep1;
	protected ICFBamDelSubDep2Factory factoryDelSubDep2;
	protected ICFBamDelSubDep3Factory factoryDelSubDep3;
	protected ICFBamDelTopDepFactory factoryDelTopDep;
	protected ICFBamDomainFactory factoryDomain;
	protected ICFBamDomainBaseFactory factoryDomainBase;
	protected ICFBamDoubleColFactory factoryDoubleCol;
	protected ICFBamDoubleDefFactory factoryDoubleDef;
	protected ICFBamDoubleTypeFactory factoryDoubleType;
	protected ICFBamEnumColFactory factoryEnumCol;
	protected ICFBamEnumDefFactory factoryEnumDef;
	protected ICFBamEnumTagFactory factoryEnumTag;
	protected ICFBamEnumTypeFactory factoryEnumType;
	protected ICFBamFloatColFactory factoryFloatCol;
	protected ICFBamFloatDefFactory factoryFloatDef;
	protected ICFBamFloatTypeFactory factoryFloatType;
	protected ICFBamHostNodeFactory factoryHostNode;
	protected ICFBamISOCountryFactory factoryISOCountry;
	protected ICFBamISOCountryCurrencyFactory factoryISOCountryCurrency;
	protected ICFBamISOCountryLanguageFactory factoryISOCountryLanguage;
	protected ICFBamISOCurrencyFactory factoryISOCurrency;
	protected ICFBamISOLanguageFactory factoryISOLanguage;
	protected ICFBamISOTimezoneFactory factoryISOTimezone;
	protected ICFBamId16GenFactory factoryId16Gen;
	protected ICFBamId32GenFactory factoryId32Gen;
	protected ICFBamId64GenFactory factoryId64Gen;
	protected ICFBamIndexFactory factoryIndex;
	protected ICFBamIndexColFactory factoryIndexCol;
	protected ICFBamInt16ColFactory factoryInt16Col;
	protected ICFBamInt16DefFactory factoryInt16Def;
	protected ICFBamInt16TypeFactory factoryInt16Type;
	protected ICFBamInt32ColFactory factoryInt32Col;
	protected ICFBamInt32DefFactory factoryInt32Def;
	protected ICFBamInt32TypeFactory factoryInt32Type;
	protected ICFBamInt64ColFactory factoryInt64Col;
	protected ICFBamInt64DefFactory factoryInt64Def;
	protected ICFBamInt64TypeFactory factoryInt64Type;
	protected ICFBamLicenseFactory factoryLicense;
	protected ICFBamLoaderBehaviourFactory factoryLoaderBehaviour;
	protected ICFBamMajorVersionFactory factoryMajorVersion;
	protected ICFBamMimeTypeFactory factoryMimeType;
	protected ICFBamMinorVersionFactory factoryMinorVersion;
	protected ICFBamNmTokenColFactory factoryNmTokenCol;
	protected ICFBamNmTokenDefFactory factoryNmTokenDef;
	protected ICFBamNmTokenTypeFactory factoryNmTokenType;
	protected ICFBamNmTokensColFactory factoryNmTokensCol;
	protected ICFBamNmTokensDefFactory factoryNmTokensDef;
	protected ICFBamNmTokensTypeFactory factoryNmTokensType;
	protected ICFBamNumberColFactory factoryNumberCol;
	protected ICFBamNumberDefFactory factoryNumberDef;
	protected ICFBamNumberTypeFactory factoryNumberType;
	protected ICFBamParamFactory factoryParam;
	protected ICFBamPopDepFactory factoryPopDep;
	protected ICFBamPopSubDep1Factory factoryPopSubDep1;
	protected ICFBamPopSubDep2Factory factoryPopSubDep2;
	protected ICFBamPopSubDep3Factory factoryPopSubDep3;
	protected ICFBamPopTopDepFactory factoryPopTopDep;
	protected ICFBamProjectBaseFactory factoryProjectBase;
	protected ICFBamRealProjectFactory factoryRealProject;
	protected ICFBamRelationFactory factoryRelation;
	protected ICFBamRelationColFactory factoryRelationCol;
	protected ICFBamRelationTypeFactory factoryRelationType;
	protected ICFBamSchemaDefFactory factorySchemaDef;
	protected ICFBamSchemaRefFactory factorySchemaRef;
	protected ICFBamScopeFactory factoryScope;
	protected ICFBamSecAppFactory factorySecApp;
	protected ICFBamSecDeviceFactory factorySecDevice;
	protected ICFBamSecFormFactory factorySecForm;
	protected ICFBamSecGroupFactory factorySecGroup;
	protected ICFBamSecGroupFormFactory factorySecGroupForm;
	protected ICFBamSecGroupIncludeFactory factorySecGroupInclude;
	protected ICFBamSecGroupMemberFactory factorySecGroupMember;
	protected ICFBamSecSessionFactory factorySecSession;
	protected ICFBamSecUserFactory factorySecUser;
	protected ICFBamSecurityScopeFactory factorySecurityScope;
	protected ICFBamServerListFuncFactory factoryServerListFunc;
	protected ICFBamServerMethodFactory factoryServerMethod;
	protected ICFBamServerObjFuncFactory factoryServerObjFunc;
	protected ICFBamServerProcFactory factoryServerProc;
	protected ICFBamServiceFactory factoryService;
	protected ICFBamServiceTypeFactory factoryServiceType;
	protected ICFBamStringColFactory factoryStringCol;
	protected ICFBamStringDefFactory factoryStringDef;
	protected ICFBamStringTypeFactory factoryStringType;
	protected ICFBamSubProjectFactory factorySubProject;
	protected ICFBamSysClusterFactory factorySysCluster;
	protected ICFBamTSecGroupFactory factoryTSecGroup;
	protected ICFBamTSecGroupIncludeFactory factoryTSecGroupInclude;
	protected ICFBamTSecGroupMemberFactory factoryTSecGroupMember;
	protected ICFBamTZDateColFactory factoryTZDateCol;
	protected ICFBamTZDateDefFactory factoryTZDateDef;
	protected ICFBamTZDateTypeFactory factoryTZDateType;
	protected ICFBamTZTimeColFactory factoryTZTimeCol;
	protected ICFBamTZTimeDefFactory factoryTZTimeDef;
	protected ICFBamTZTimeTypeFactory factoryTZTimeType;
	protected ICFBamTZTimestampColFactory factoryTZTimestampCol;
	protected ICFBamTZTimestampDefFactory factoryTZTimestampDef;
	protected ICFBamTZTimestampTypeFactory factoryTZTimestampType;
	protected ICFBamTableFactory factoryTable;
	protected ICFBamTableColFactory factoryTableCol;
	protected ICFBamTenantFactory factoryTenant;
	protected ICFBamTextColFactory factoryTextCol;
	protected ICFBamTextDefFactory factoryTextDef;
	protected ICFBamTextTypeFactory factoryTextType;
	protected ICFBamTimeColFactory factoryTimeCol;
	protected ICFBamTimeDefFactory factoryTimeDef;
	protected ICFBamTimeTypeFactory factoryTimeType;
	protected ICFBamTimestampColFactory factoryTimestampCol;
	protected ICFBamTimestampDefFactory factoryTimestampDef;
	protected ICFBamTimestampTypeFactory factoryTimestampType;
	protected ICFBamTldFactory factoryTld;
	protected ICFBamTokenColFactory factoryTokenCol;
	protected ICFBamTokenDefFactory factoryTokenDef;
	protected ICFBamTokenTypeFactory factoryTokenType;
	protected ICFBamTopDomainFactory factoryTopDomain;
	protected ICFBamTopProjectFactory factoryTopProject;
	protected ICFBamUInt16ColFactory factoryUInt16Col;
	protected ICFBamUInt16DefFactory factoryUInt16Def;
	protected ICFBamUInt16TypeFactory factoryUInt16Type;
	protected ICFBamUInt32ColFactory factoryUInt32Col;
	protected ICFBamUInt32DefFactory factoryUInt32Def;
	protected ICFBamUInt32TypeFactory factoryUInt32Type;
	protected ICFBamUInt64ColFactory factoryUInt64Col;
	protected ICFBamUInt64DefFactory factoryUInt64Def;
	protected ICFBamUInt64TypeFactory factoryUInt64Type;
	protected ICFBamURLProtocolFactory factoryURLProtocol;
	protected ICFBamUuidColFactory factoryUuidCol;
	protected ICFBamUuidDefFactory factoryUuidDef;
	protected ICFBamUuidGenFactory factoryUuidGen;
	protected ICFBamUuidTypeFactory factoryUuidType;
	protected ICFBamValueFactory factoryValue;
	protected ICFBamVersionFactory factoryVersion;


	public CFBamSchema() {
		configuration = null;
		jndiName = null;
		tableAccessFrequency = null;
		tableAccessSecurity = null;
		tableAtom = null;
		tableAuditAction = null;
		tableBlobCol = null;
		tableBlobDef = null;
		tableBlobType = null;
		tableBoolCol = null;
		tableBoolDef = null;
		tableBoolType = null;
		tableChain = null;
		tableClearDep = null;
		tableClearSubDep1 = null;
		tableClearSubDep2 = null;
		tableClearSubDep3 = null;
		tableClearTopDep = null;
		tableCluster = null;
		tableDataScope = null;
		tableDateCol = null;
		tableDateDef = null;
		tableDateType = null;
		tableDelDep = null;
		tableDelSubDep1 = null;
		tableDelSubDep2 = null;
		tableDelSubDep3 = null;
		tableDelTopDep = null;
		tableDomain = null;
		tableDomainBase = null;
		tableDoubleCol = null;
		tableDoubleDef = null;
		tableDoubleType = null;
		tableEnumCol = null;
		tableEnumDef = null;
		tableEnumTag = null;
		tableEnumType = null;
		tableFloatCol = null;
		tableFloatDef = null;
		tableFloatType = null;
		tableHostNode = null;
		tableISOCountry = null;
		tableISOCountryCurrency = null;
		tableISOCountryLanguage = null;
		tableISOCurrency = null;
		tableISOLanguage = null;
		tableISOTimezone = null;
		tableId16Gen = null;
		tableId32Gen = null;
		tableId64Gen = null;
		tableIndex = null;
		tableIndexCol = null;
		tableInt16Col = null;
		tableInt16Def = null;
		tableInt16Type = null;
		tableInt32Col = null;
		tableInt32Def = null;
		tableInt32Type = null;
		tableInt64Col = null;
		tableInt64Def = null;
		tableInt64Type = null;
		tableLicense = null;
		tableLoaderBehaviour = null;
		tableMajorVersion = null;
		tableMimeType = null;
		tableMinorVersion = null;
		tableNmTokenCol = null;
		tableNmTokenDef = null;
		tableNmTokenType = null;
		tableNmTokensCol = null;
		tableNmTokensDef = null;
		tableNmTokensType = null;
		tableNumberCol = null;
		tableNumberDef = null;
		tableNumberType = null;
		tableParam = null;
		tablePopDep = null;
		tablePopSubDep1 = null;
		tablePopSubDep2 = null;
		tablePopSubDep3 = null;
		tablePopTopDep = null;
		tableProjectBase = null;
		tableRealProject = null;
		tableRelation = null;
		tableRelationCol = null;
		tableRelationType = null;
		tableSchemaDef = null;
		tableSchemaRef = null;
		tableScope = null;
		tableSecApp = null;
		tableSecDevice = null;
		tableSecForm = null;
		tableSecGroup = null;
		tableSecGroupForm = null;
		tableSecGroupInclude = null;
		tableSecGroupMember = null;
		tableSecSession = null;
		tableSecUser = null;
		tableSecurityScope = null;
		tableServerListFunc = null;
		tableServerMethod = null;
		tableServerObjFunc = null;
		tableServerProc = null;
		tableService = null;
		tableServiceType = null;
		tableStringCol = null;
		tableStringDef = null;
		tableStringType = null;
		tableSubProject = null;
		tableSysCluster = null;
		tableTSecGroup = null;
		tableTSecGroupInclude = null;
		tableTSecGroupMember = null;
		tableTZDateCol = null;
		tableTZDateDef = null;
		tableTZDateType = null;
		tableTZTimeCol = null;
		tableTZTimeDef = null;
		tableTZTimeType = null;
		tableTZTimestampCol = null;
		tableTZTimestampDef = null;
		tableTZTimestampType = null;
		tableTable = null;
		tableTableCol = null;
		tableTenant = null;
		tableTextCol = null;
		tableTextDef = null;
		tableTextType = null;
		tableTimeCol = null;
		tableTimeDef = null;
		tableTimeType = null;
		tableTimestampCol = null;
		tableTimestampDef = null;
		tableTimestampType = null;
		tableTld = null;
		tableTokenCol = null;
		tableTokenDef = null;
		tableTokenType = null;
		tableTopDomain = null;
		tableTopProject = null;
		tableUInt16Col = null;
		tableUInt16Def = null;
		tableUInt16Type = null;
		tableUInt32Col = null;
		tableUInt32Def = null;
		tableUInt32Type = null;
		tableUInt64Col = null;
		tableUInt64Def = null;
		tableUInt64Type = null;
		tableURLProtocol = null;
		tableUuidCol = null;
		tableUuidDef = null;
		tableUuidGen = null;
		tableUuidType = null;
		tableValue = null;
		tableVersion = null;

		factoryAccessFrequency = new CFBamAccessFrequencyDefaultFactory();
		factoryAccessSecurity = new CFBamAccessSecurityDefaultFactory();
		factoryAtom = new CFBamAtomDefaultFactory();
		factoryAuditAction = new CFBamAuditActionDefaultFactory();
		factoryBlobCol = new CFBamBlobColDefaultFactory();
		factoryBlobDef = new CFBamBlobDefDefaultFactory();
		factoryBlobType = new CFBamBlobTypeDefaultFactory();
		factoryBoolCol = new CFBamBoolColDefaultFactory();
		factoryBoolDef = new CFBamBoolDefDefaultFactory();
		factoryBoolType = new CFBamBoolTypeDefaultFactory();
		factoryChain = new CFBamChainDefaultFactory();
		factoryClearDep = new CFBamClearDepDefaultFactory();
		factoryClearSubDep1 = new CFBamClearSubDep1DefaultFactory();
		factoryClearSubDep2 = new CFBamClearSubDep2DefaultFactory();
		factoryClearSubDep3 = new CFBamClearSubDep3DefaultFactory();
		factoryClearTopDep = new CFBamClearTopDepDefaultFactory();
		factoryCluster = new CFBamClusterDefaultFactory();
		factoryDataScope = new CFBamDataScopeDefaultFactory();
		factoryDateCol = new CFBamDateColDefaultFactory();
		factoryDateDef = new CFBamDateDefDefaultFactory();
		factoryDateType = new CFBamDateTypeDefaultFactory();
		factoryDelDep = new CFBamDelDepDefaultFactory();
		factoryDelSubDep1 = new CFBamDelSubDep1DefaultFactory();
		factoryDelSubDep2 = new CFBamDelSubDep2DefaultFactory();
		factoryDelSubDep3 = new CFBamDelSubDep3DefaultFactory();
		factoryDelTopDep = new CFBamDelTopDepDefaultFactory();
		factoryDomain = new CFBamDomainDefaultFactory();
		factoryDomainBase = new CFBamDomainBaseDefaultFactory();
		factoryDoubleCol = new CFBamDoubleColDefaultFactory();
		factoryDoubleDef = new CFBamDoubleDefDefaultFactory();
		factoryDoubleType = new CFBamDoubleTypeDefaultFactory();
		factoryEnumCol = new CFBamEnumColDefaultFactory();
		factoryEnumDef = new CFBamEnumDefDefaultFactory();
		factoryEnumTag = new CFBamEnumTagDefaultFactory();
		factoryEnumType = new CFBamEnumTypeDefaultFactory();
		factoryFloatCol = new CFBamFloatColDefaultFactory();
		factoryFloatDef = new CFBamFloatDefDefaultFactory();
		factoryFloatType = new CFBamFloatTypeDefaultFactory();
		factoryHostNode = new CFBamHostNodeDefaultFactory();
		factoryISOCountry = new CFBamISOCountryDefaultFactory();
		factoryISOCountryCurrency = new CFBamISOCountryCurrencyDefaultFactory();
		factoryISOCountryLanguage = new CFBamISOCountryLanguageDefaultFactory();
		factoryISOCurrency = new CFBamISOCurrencyDefaultFactory();
		factoryISOLanguage = new CFBamISOLanguageDefaultFactory();
		factoryISOTimezone = new CFBamISOTimezoneDefaultFactory();
		factoryId16Gen = new CFBamId16GenDefaultFactory();
		factoryId32Gen = new CFBamId32GenDefaultFactory();
		factoryId64Gen = new CFBamId64GenDefaultFactory();
		factoryIndex = new CFBamIndexDefaultFactory();
		factoryIndexCol = new CFBamIndexColDefaultFactory();
		factoryInt16Col = new CFBamInt16ColDefaultFactory();
		factoryInt16Def = new CFBamInt16DefDefaultFactory();
		factoryInt16Type = new CFBamInt16TypeDefaultFactory();
		factoryInt32Col = new CFBamInt32ColDefaultFactory();
		factoryInt32Def = new CFBamInt32DefDefaultFactory();
		factoryInt32Type = new CFBamInt32TypeDefaultFactory();
		factoryInt64Col = new CFBamInt64ColDefaultFactory();
		factoryInt64Def = new CFBamInt64DefDefaultFactory();
		factoryInt64Type = new CFBamInt64TypeDefaultFactory();
		factoryLicense = new CFBamLicenseDefaultFactory();
		factoryLoaderBehaviour = new CFBamLoaderBehaviourDefaultFactory();
		factoryMajorVersion = new CFBamMajorVersionDefaultFactory();
		factoryMimeType = new CFBamMimeTypeDefaultFactory();
		factoryMinorVersion = new CFBamMinorVersionDefaultFactory();
		factoryNmTokenCol = new CFBamNmTokenColDefaultFactory();
		factoryNmTokenDef = new CFBamNmTokenDefDefaultFactory();
		factoryNmTokenType = new CFBamNmTokenTypeDefaultFactory();
		factoryNmTokensCol = new CFBamNmTokensColDefaultFactory();
		factoryNmTokensDef = new CFBamNmTokensDefDefaultFactory();
		factoryNmTokensType = new CFBamNmTokensTypeDefaultFactory();
		factoryNumberCol = new CFBamNumberColDefaultFactory();
		factoryNumberDef = new CFBamNumberDefDefaultFactory();
		factoryNumberType = new CFBamNumberTypeDefaultFactory();
		factoryParam = new CFBamParamDefaultFactory();
		factoryPopDep = new CFBamPopDepDefaultFactory();
		factoryPopSubDep1 = new CFBamPopSubDep1DefaultFactory();
		factoryPopSubDep2 = new CFBamPopSubDep2DefaultFactory();
		factoryPopSubDep3 = new CFBamPopSubDep3DefaultFactory();
		factoryPopTopDep = new CFBamPopTopDepDefaultFactory();
		factoryProjectBase = new CFBamProjectBaseDefaultFactory();
		factoryRealProject = new CFBamRealProjectDefaultFactory();
		factoryRelation = new CFBamRelationDefaultFactory();
		factoryRelationCol = new CFBamRelationColDefaultFactory();
		factoryRelationType = new CFBamRelationTypeDefaultFactory();
		factorySchemaDef = new CFBamSchemaDefDefaultFactory();
		factorySchemaRef = new CFBamSchemaRefDefaultFactory();
		factoryScope = new CFBamScopeDefaultFactory();
		factorySecApp = new CFBamSecAppDefaultFactory();
		factorySecDevice = new CFBamSecDeviceDefaultFactory();
		factorySecForm = new CFBamSecFormDefaultFactory();
		factorySecGroup = new CFBamSecGroupDefaultFactory();
		factorySecGroupForm = new CFBamSecGroupFormDefaultFactory();
		factorySecGroupInclude = new CFBamSecGroupIncludeDefaultFactory();
		factorySecGroupMember = new CFBamSecGroupMemberDefaultFactory();
		factorySecSession = new CFBamSecSessionDefaultFactory();
		factorySecUser = new CFBamSecUserDefaultFactory();
		factorySecurityScope = new CFBamSecurityScopeDefaultFactory();
		factoryServerListFunc = new CFBamServerListFuncDefaultFactory();
		factoryServerMethod = new CFBamServerMethodDefaultFactory();
		factoryServerObjFunc = new CFBamServerObjFuncDefaultFactory();
		factoryServerProc = new CFBamServerProcDefaultFactory();
		factoryService = new CFBamServiceDefaultFactory();
		factoryServiceType = new CFBamServiceTypeDefaultFactory();
		factoryStringCol = new CFBamStringColDefaultFactory();
		factoryStringDef = new CFBamStringDefDefaultFactory();
		factoryStringType = new CFBamStringTypeDefaultFactory();
		factorySubProject = new CFBamSubProjectDefaultFactory();
		factorySysCluster = new CFBamSysClusterDefaultFactory();
		factoryTSecGroup = new CFBamTSecGroupDefaultFactory();
		factoryTSecGroupInclude = new CFBamTSecGroupIncludeDefaultFactory();
		factoryTSecGroupMember = new CFBamTSecGroupMemberDefaultFactory();
		factoryTZDateCol = new CFBamTZDateColDefaultFactory();
		factoryTZDateDef = new CFBamTZDateDefDefaultFactory();
		factoryTZDateType = new CFBamTZDateTypeDefaultFactory();
		factoryTZTimeCol = new CFBamTZTimeColDefaultFactory();
		factoryTZTimeDef = new CFBamTZTimeDefDefaultFactory();
		factoryTZTimeType = new CFBamTZTimeTypeDefaultFactory();
		factoryTZTimestampCol = new CFBamTZTimestampColDefaultFactory();
		factoryTZTimestampDef = new CFBamTZTimestampDefDefaultFactory();
		factoryTZTimestampType = new CFBamTZTimestampTypeDefaultFactory();
		factoryTable = new CFBamTableDefaultFactory();
		factoryTableCol = new CFBamTableColDefaultFactory();
		factoryTenant = new CFBamTenantDefaultFactory();
		factoryTextCol = new CFBamTextColDefaultFactory();
		factoryTextDef = new CFBamTextDefDefaultFactory();
		factoryTextType = new CFBamTextTypeDefaultFactory();
		factoryTimeCol = new CFBamTimeColDefaultFactory();
		factoryTimeDef = new CFBamTimeDefDefaultFactory();
		factoryTimeType = new CFBamTimeTypeDefaultFactory();
		factoryTimestampCol = new CFBamTimestampColDefaultFactory();
		factoryTimestampDef = new CFBamTimestampDefDefaultFactory();
		factoryTimestampType = new CFBamTimestampTypeDefaultFactory();
		factoryTld = new CFBamTldDefaultFactory();
		factoryTokenCol = new CFBamTokenColDefaultFactory();
		factoryTokenDef = new CFBamTokenDefDefaultFactory();
		factoryTokenType = new CFBamTokenTypeDefaultFactory();
		factoryTopDomain = new CFBamTopDomainDefaultFactory();
		factoryTopProject = new CFBamTopProjectDefaultFactory();
		factoryUInt16Col = new CFBamUInt16ColDefaultFactory();
		factoryUInt16Def = new CFBamUInt16DefDefaultFactory();
		factoryUInt16Type = new CFBamUInt16TypeDefaultFactory();
		factoryUInt32Col = new CFBamUInt32ColDefaultFactory();
		factoryUInt32Def = new CFBamUInt32DefDefaultFactory();
		factoryUInt32Type = new CFBamUInt32TypeDefaultFactory();
		factoryUInt64Col = new CFBamUInt64ColDefaultFactory();
		factoryUInt64Def = new CFBamUInt64DefDefaultFactory();
		factoryUInt64Type = new CFBamUInt64TypeDefaultFactory();
		factoryURLProtocol = new CFBamURLProtocolDefaultFactory();
		factoryUuidCol = new CFBamUuidColDefaultFactory();
		factoryUuidDef = new CFBamUuidDefDefaultFactory();
		factoryUuidGen = new CFBamUuidGenDefaultFactory();
		factoryUuidType = new CFBamUuidTypeDefaultFactory();
		factoryValue = new CFBamValueDefaultFactory();
		factoryVersion = new CFBamVersionDefaultFactory();
	}

	public CFBamSchema( CFBamConfigurationFile conf ) {
		if( conf == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"CFBamSchema-constructor",
				1,
				"conf" );
		}
		configuration = conf;
		jndiName = null;
		tableAccessFrequency = null;
		tableAccessSecurity = null;
		tableAtom = null;
		tableAuditAction = null;
		tableBlobCol = null;
		tableBlobDef = null;
		tableBlobType = null;
		tableBoolCol = null;
		tableBoolDef = null;
		tableBoolType = null;
		tableChain = null;
		tableClearDep = null;
		tableClearSubDep1 = null;
		tableClearSubDep2 = null;
		tableClearSubDep3 = null;
		tableClearTopDep = null;
		tableCluster = null;
		tableDataScope = null;
		tableDateCol = null;
		tableDateDef = null;
		tableDateType = null;
		tableDelDep = null;
		tableDelSubDep1 = null;
		tableDelSubDep2 = null;
		tableDelSubDep3 = null;
		tableDelTopDep = null;
		tableDomain = null;
		tableDomainBase = null;
		tableDoubleCol = null;
		tableDoubleDef = null;
		tableDoubleType = null;
		tableEnumCol = null;
		tableEnumDef = null;
		tableEnumTag = null;
		tableEnumType = null;
		tableFloatCol = null;
		tableFloatDef = null;
		tableFloatType = null;
		tableHostNode = null;
		tableISOCountry = null;
		tableISOCountryCurrency = null;
		tableISOCountryLanguage = null;
		tableISOCurrency = null;
		tableISOLanguage = null;
		tableISOTimezone = null;
		tableId16Gen = null;
		tableId32Gen = null;
		tableId64Gen = null;
		tableIndex = null;
		tableIndexCol = null;
		tableInt16Col = null;
		tableInt16Def = null;
		tableInt16Type = null;
		tableInt32Col = null;
		tableInt32Def = null;
		tableInt32Type = null;
		tableInt64Col = null;
		tableInt64Def = null;
		tableInt64Type = null;
		tableLicense = null;
		tableLoaderBehaviour = null;
		tableMajorVersion = null;
		tableMimeType = null;
		tableMinorVersion = null;
		tableNmTokenCol = null;
		tableNmTokenDef = null;
		tableNmTokenType = null;
		tableNmTokensCol = null;
		tableNmTokensDef = null;
		tableNmTokensType = null;
		tableNumberCol = null;
		tableNumberDef = null;
		tableNumberType = null;
		tableParam = null;
		tablePopDep = null;
		tablePopSubDep1 = null;
		tablePopSubDep2 = null;
		tablePopSubDep3 = null;
		tablePopTopDep = null;
		tableProjectBase = null;
		tableRealProject = null;
		tableRelation = null;
		tableRelationCol = null;
		tableRelationType = null;
		tableSchemaDef = null;
		tableSchemaRef = null;
		tableScope = null;
		tableSecApp = null;
		tableSecDevice = null;
		tableSecForm = null;
		tableSecGroup = null;
		tableSecGroupForm = null;
		tableSecGroupInclude = null;
		tableSecGroupMember = null;
		tableSecSession = null;
		tableSecUser = null;
		tableSecurityScope = null;
		tableServerListFunc = null;
		tableServerMethod = null;
		tableServerObjFunc = null;
		tableServerProc = null;
		tableService = null;
		tableServiceType = null;
		tableStringCol = null;
		tableStringDef = null;
		tableStringType = null;
		tableSubProject = null;
		tableSysCluster = null;
		tableTSecGroup = null;
		tableTSecGroupInclude = null;
		tableTSecGroupMember = null;
		tableTZDateCol = null;
		tableTZDateDef = null;
		tableTZDateType = null;
		tableTZTimeCol = null;
		tableTZTimeDef = null;
		tableTZTimeType = null;
		tableTZTimestampCol = null;
		tableTZTimestampDef = null;
		tableTZTimestampType = null;
		tableTable = null;
		tableTableCol = null;
		tableTenant = null;
		tableTextCol = null;
		tableTextDef = null;
		tableTextType = null;
		tableTimeCol = null;
		tableTimeDef = null;
		tableTimeType = null;
		tableTimestampCol = null;
		tableTimestampDef = null;
		tableTimestampType = null;
		tableTld = null;
		tableTokenCol = null;
		tableTokenDef = null;
		tableTokenType = null;
		tableTopDomain = null;
		tableTopProject = null;
		tableUInt16Col = null;
		tableUInt16Def = null;
		tableUInt16Type = null;
		tableUInt32Col = null;
		tableUInt32Def = null;
		tableUInt32Type = null;
		tableUInt64Col = null;
		tableUInt64Def = null;
		tableUInt64Type = null;
		tableURLProtocol = null;
		tableUuidCol = null;
		tableUuidDef = null;
		tableUuidGen = null;
		tableUuidType = null;
		tableValue = null;
		tableVersion = null;

		factoryAccessFrequency = new CFBamAccessFrequencyDefaultFactory();
		factoryAccessSecurity = new CFBamAccessSecurityDefaultFactory();
		factoryAtom = new CFBamAtomDefaultFactory();
		factoryAuditAction = new CFBamAuditActionDefaultFactory();
		factoryBlobCol = new CFBamBlobColDefaultFactory();
		factoryBlobDef = new CFBamBlobDefDefaultFactory();
		factoryBlobType = new CFBamBlobTypeDefaultFactory();
		factoryBoolCol = new CFBamBoolColDefaultFactory();
		factoryBoolDef = new CFBamBoolDefDefaultFactory();
		factoryBoolType = new CFBamBoolTypeDefaultFactory();
		factoryChain = new CFBamChainDefaultFactory();
		factoryClearDep = new CFBamClearDepDefaultFactory();
		factoryClearSubDep1 = new CFBamClearSubDep1DefaultFactory();
		factoryClearSubDep2 = new CFBamClearSubDep2DefaultFactory();
		factoryClearSubDep3 = new CFBamClearSubDep3DefaultFactory();
		factoryClearTopDep = new CFBamClearTopDepDefaultFactory();
		factoryCluster = new CFBamClusterDefaultFactory();
		factoryDataScope = new CFBamDataScopeDefaultFactory();
		factoryDateCol = new CFBamDateColDefaultFactory();
		factoryDateDef = new CFBamDateDefDefaultFactory();
		factoryDateType = new CFBamDateTypeDefaultFactory();
		factoryDelDep = new CFBamDelDepDefaultFactory();
		factoryDelSubDep1 = new CFBamDelSubDep1DefaultFactory();
		factoryDelSubDep2 = new CFBamDelSubDep2DefaultFactory();
		factoryDelSubDep3 = new CFBamDelSubDep3DefaultFactory();
		factoryDelTopDep = new CFBamDelTopDepDefaultFactory();
		factoryDomain = new CFBamDomainDefaultFactory();
		factoryDomainBase = new CFBamDomainBaseDefaultFactory();
		factoryDoubleCol = new CFBamDoubleColDefaultFactory();
		factoryDoubleDef = new CFBamDoubleDefDefaultFactory();
		factoryDoubleType = new CFBamDoubleTypeDefaultFactory();
		factoryEnumCol = new CFBamEnumColDefaultFactory();
		factoryEnumDef = new CFBamEnumDefDefaultFactory();
		factoryEnumTag = new CFBamEnumTagDefaultFactory();
		factoryEnumType = new CFBamEnumTypeDefaultFactory();
		factoryFloatCol = new CFBamFloatColDefaultFactory();
		factoryFloatDef = new CFBamFloatDefDefaultFactory();
		factoryFloatType = new CFBamFloatTypeDefaultFactory();
		factoryHostNode = new CFBamHostNodeDefaultFactory();
		factoryISOCountry = new CFBamISOCountryDefaultFactory();
		factoryISOCountryCurrency = new CFBamISOCountryCurrencyDefaultFactory();
		factoryISOCountryLanguage = new CFBamISOCountryLanguageDefaultFactory();
		factoryISOCurrency = new CFBamISOCurrencyDefaultFactory();
		factoryISOLanguage = new CFBamISOLanguageDefaultFactory();
		factoryISOTimezone = new CFBamISOTimezoneDefaultFactory();
		factoryId16Gen = new CFBamId16GenDefaultFactory();
		factoryId32Gen = new CFBamId32GenDefaultFactory();
		factoryId64Gen = new CFBamId64GenDefaultFactory();
		factoryIndex = new CFBamIndexDefaultFactory();
		factoryIndexCol = new CFBamIndexColDefaultFactory();
		factoryInt16Col = new CFBamInt16ColDefaultFactory();
		factoryInt16Def = new CFBamInt16DefDefaultFactory();
		factoryInt16Type = new CFBamInt16TypeDefaultFactory();
		factoryInt32Col = new CFBamInt32ColDefaultFactory();
		factoryInt32Def = new CFBamInt32DefDefaultFactory();
		factoryInt32Type = new CFBamInt32TypeDefaultFactory();
		factoryInt64Col = new CFBamInt64ColDefaultFactory();
		factoryInt64Def = new CFBamInt64DefDefaultFactory();
		factoryInt64Type = new CFBamInt64TypeDefaultFactory();
		factoryLicense = new CFBamLicenseDefaultFactory();
		factoryLoaderBehaviour = new CFBamLoaderBehaviourDefaultFactory();
		factoryMajorVersion = new CFBamMajorVersionDefaultFactory();
		factoryMimeType = new CFBamMimeTypeDefaultFactory();
		factoryMinorVersion = new CFBamMinorVersionDefaultFactory();
		factoryNmTokenCol = new CFBamNmTokenColDefaultFactory();
		factoryNmTokenDef = new CFBamNmTokenDefDefaultFactory();
		factoryNmTokenType = new CFBamNmTokenTypeDefaultFactory();
		factoryNmTokensCol = new CFBamNmTokensColDefaultFactory();
		factoryNmTokensDef = new CFBamNmTokensDefDefaultFactory();
		factoryNmTokensType = new CFBamNmTokensTypeDefaultFactory();
		factoryNumberCol = new CFBamNumberColDefaultFactory();
		factoryNumberDef = new CFBamNumberDefDefaultFactory();
		factoryNumberType = new CFBamNumberTypeDefaultFactory();
		factoryParam = new CFBamParamDefaultFactory();
		factoryPopDep = new CFBamPopDepDefaultFactory();
		factoryPopSubDep1 = new CFBamPopSubDep1DefaultFactory();
		factoryPopSubDep2 = new CFBamPopSubDep2DefaultFactory();
		factoryPopSubDep3 = new CFBamPopSubDep3DefaultFactory();
		factoryPopTopDep = new CFBamPopTopDepDefaultFactory();
		factoryProjectBase = new CFBamProjectBaseDefaultFactory();
		factoryRealProject = new CFBamRealProjectDefaultFactory();
		factoryRelation = new CFBamRelationDefaultFactory();
		factoryRelationCol = new CFBamRelationColDefaultFactory();
		factoryRelationType = new CFBamRelationTypeDefaultFactory();
		factorySchemaDef = new CFBamSchemaDefDefaultFactory();
		factorySchemaRef = new CFBamSchemaRefDefaultFactory();
		factoryScope = new CFBamScopeDefaultFactory();
		factorySecApp = new CFBamSecAppDefaultFactory();
		factorySecDevice = new CFBamSecDeviceDefaultFactory();
		factorySecForm = new CFBamSecFormDefaultFactory();
		factorySecGroup = new CFBamSecGroupDefaultFactory();
		factorySecGroupForm = new CFBamSecGroupFormDefaultFactory();
		factorySecGroupInclude = new CFBamSecGroupIncludeDefaultFactory();
		factorySecGroupMember = new CFBamSecGroupMemberDefaultFactory();
		factorySecSession = new CFBamSecSessionDefaultFactory();
		factorySecUser = new CFBamSecUserDefaultFactory();
		factorySecurityScope = new CFBamSecurityScopeDefaultFactory();
		factoryServerListFunc = new CFBamServerListFuncDefaultFactory();
		factoryServerMethod = new CFBamServerMethodDefaultFactory();
		factoryServerObjFunc = new CFBamServerObjFuncDefaultFactory();
		factoryServerProc = new CFBamServerProcDefaultFactory();
		factoryService = new CFBamServiceDefaultFactory();
		factoryServiceType = new CFBamServiceTypeDefaultFactory();
		factoryStringCol = new CFBamStringColDefaultFactory();
		factoryStringDef = new CFBamStringDefDefaultFactory();
		factoryStringType = new CFBamStringTypeDefaultFactory();
		factorySubProject = new CFBamSubProjectDefaultFactory();
		factorySysCluster = new CFBamSysClusterDefaultFactory();
		factoryTSecGroup = new CFBamTSecGroupDefaultFactory();
		factoryTSecGroupInclude = new CFBamTSecGroupIncludeDefaultFactory();
		factoryTSecGroupMember = new CFBamTSecGroupMemberDefaultFactory();
		factoryTZDateCol = new CFBamTZDateColDefaultFactory();
		factoryTZDateDef = new CFBamTZDateDefDefaultFactory();
		factoryTZDateType = new CFBamTZDateTypeDefaultFactory();
		factoryTZTimeCol = new CFBamTZTimeColDefaultFactory();
		factoryTZTimeDef = new CFBamTZTimeDefDefaultFactory();
		factoryTZTimeType = new CFBamTZTimeTypeDefaultFactory();
		factoryTZTimestampCol = new CFBamTZTimestampColDefaultFactory();
		factoryTZTimestampDef = new CFBamTZTimestampDefDefaultFactory();
		factoryTZTimestampType = new CFBamTZTimestampTypeDefaultFactory();
		factoryTable = new CFBamTableDefaultFactory();
		factoryTableCol = new CFBamTableColDefaultFactory();
		factoryTenant = new CFBamTenantDefaultFactory();
		factoryTextCol = new CFBamTextColDefaultFactory();
		factoryTextDef = new CFBamTextDefDefaultFactory();
		factoryTextType = new CFBamTextTypeDefaultFactory();
		factoryTimeCol = new CFBamTimeColDefaultFactory();
		factoryTimeDef = new CFBamTimeDefDefaultFactory();
		factoryTimeType = new CFBamTimeTypeDefaultFactory();
		factoryTimestampCol = new CFBamTimestampColDefaultFactory();
		factoryTimestampDef = new CFBamTimestampDefDefaultFactory();
		factoryTimestampType = new CFBamTimestampTypeDefaultFactory();
		factoryTld = new CFBamTldDefaultFactory();
		factoryTokenCol = new CFBamTokenColDefaultFactory();
		factoryTokenDef = new CFBamTokenDefDefaultFactory();
		factoryTokenType = new CFBamTokenTypeDefaultFactory();
		factoryTopDomain = new CFBamTopDomainDefaultFactory();
		factoryTopProject = new CFBamTopProjectDefaultFactory();
		factoryUInt16Col = new CFBamUInt16ColDefaultFactory();
		factoryUInt16Def = new CFBamUInt16DefDefaultFactory();
		factoryUInt16Type = new CFBamUInt16TypeDefaultFactory();
		factoryUInt32Col = new CFBamUInt32ColDefaultFactory();
		factoryUInt32Def = new CFBamUInt32DefDefaultFactory();
		factoryUInt32Type = new CFBamUInt32TypeDefaultFactory();
		factoryUInt64Col = new CFBamUInt64ColDefaultFactory();
		factoryUInt64Def = new CFBamUInt64DefDefaultFactory();
		factoryUInt64Type = new CFBamUInt64TypeDefaultFactory();
		factoryURLProtocol = new CFBamURLProtocolDefaultFactory();
		factoryUuidCol = new CFBamUuidColDefaultFactory();
		factoryUuidDef = new CFBamUuidDefDefaultFactory();
		factoryUuidGen = new CFBamUuidGenDefaultFactory();
		factoryUuidType = new CFBamUuidTypeDefaultFactory();
		factoryValue = new CFBamValueDefaultFactory();
		factoryVersion = new CFBamVersionDefaultFactory();
	}

	public CFBamSchema( String argJndiName ) {
		if( ( argJndiName == null ) || ( argJndiName.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newEmptyArgumentException( getClass(),
				"CFBamSchema-constructor",
				1,
				"argJndiName" );
		}
		configuration = null;
		jndiName = argJndiName;
		tableAccessFrequency = null;
		tableAccessSecurity = null;
		tableAtom = null;
		tableAuditAction = null;
		tableBlobCol = null;
		tableBlobDef = null;
		tableBlobType = null;
		tableBoolCol = null;
		tableBoolDef = null;
		tableBoolType = null;
		tableChain = null;
		tableClearDep = null;
		tableClearSubDep1 = null;
		tableClearSubDep2 = null;
		tableClearSubDep3 = null;
		tableClearTopDep = null;
		tableCluster = null;
		tableDataScope = null;
		tableDateCol = null;
		tableDateDef = null;
		tableDateType = null;
		tableDelDep = null;
		tableDelSubDep1 = null;
		tableDelSubDep2 = null;
		tableDelSubDep3 = null;
		tableDelTopDep = null;
		tableDomain = null;
		tableDomainBase = null;
		tableDoubleCol = null;
		tableDoubleDef = null;
		tableDoubleType = null;
		tableEnumCol = null;
		tableEnumDef = null;
		tableEnumTag = null;
		tableEnumType = null;
		tableFloatCol = null;
		tableFloatDef = null;
		tableFloatType = null;
		tableHostNode = null;
		tableISOCountry = null;
		tableISOCountryCurrency = null;
		tableISOCountryLanguage = null;
		tableISOCurrency = null;
		tableISOLanguage = null;
		tableISOTimezone = null;
		tableId16Gen = null;
		tableId32Gen = null;
		tableId64Gen = null;
		tableIndex = null;
		tableIndexCol = null;
		tableInt16Col = null;
		tableInt16Def = null;
		tableInt16Type = null;
		tableInt32Col = null;
		tableInt32Def = null;
		tableInt32Type = null;
		tableInt64Col = null;
		tableInt64Def = null;
		tableInt64Type = null;
		tableLicense = null;
		tableLoaderBehaviour = null;
		tableMajorVersion = null;
		tableMimeType = null;
		tableMinorVersion = null;
		tableNmTokenCol = null;
		tableNmTokenDef = null;
		tableNmTokenType = null;
		tableNmTokensCol = null;
		tableNmTokensDef = null;
		tableNmTokensType = null;
		tableNumberCol = null;
		tableNumberDef = null;
		tableNumberType = null;
		tableParam = null;
		tablePopDep = null;
		tablePopSubDep1 = null;
		tablePopSubDep2 = null;
		tablePopSubDep3 = null;
		tablePopTopDep = null;
		tableProjectBase = null;
		tableRealProject = null;
		tableRelation = null;
		tableRelationCol = null;
		tableRelationType = null;
		tableSchemaDef = null;
		tableSchemaRef = null;
		tableScope = null;
		tableSecApp = null;
		tableSecDevice = null;
		tableSecForm = null;
		tableSecGroup = null;
		tableSecGroupForm = null;
		tableSecGroupInclude = null;
		tableSecGroupMember = null;
		tableSecSession = null;
		tableSecUser = null;
		tableSecurityScope = null;
		tableServerListFunc = null;
		tableServerMethod = null;
		tableServerObjFunc = null;
		tableServerProc = null;
		tableService = null;
		tableServiceType = null;
		tableStringCol = null;
		tableStringDef = null;
		tableStringType = null;
		tableSubProject = null;
		tableSysCluster = null;
		tableTSecGroup = null;
		tableTSecGroupInclude = null;
		tableTSecGroupMember = null;
		tableTZDateCol = null;
		tableTZDateDef = null;
		tableTZDateType = null;
		tableTZTimeCol = null;
		tableTZTimeDef = null;
		tableTZTimeType = null;
		tableTZTimestampCol = null;
		tableTZTimestampDef = null;
		tableTZTimestampType = null;
		tableTable = null;
		tableTableCol = null;
		tableTenant = null;
		tableTextCol = null;
		tableTextDef = null;
		tableTextType = null;
		tableTimeCol = null;
		tableTimeDef = null;
		tableTimeType = null;
		tableTimestampCol = null;
		tableTimestampDef = null;
		tableTimestampType = null;
		tableTld = null;
		tableTokenCol = null;
		tableTokenDef = null;
		tableTokenType = null;
		tableTopDomain = null;
		tableTopProject = null;
		tableUInt16Col = null;
		tableUInt16Def = null;
		tableUInt16Type = null;
		tableUInt32Col = null;
		tableUInt32Def = null;
		tableUInt32Type = null;
		tableUInt64Col = null;
		tableUInt64Def = null;
		tableUInt64Type = null;
		tableURLProtocol = null;
		tableUuidCol = null;
		tableUuidDef = null;
		tableUuidGen = null;
		tableUuidType = null;
		tableValue = null;
		tableVersion = null;

		factoryAccessFrequency = new CFBamAccessFrequencyDefaultFactory();
		factoryAccessSecurity = new CFBamAccessSecurityDefaultFactory();
		factoryAtom = new CFBamAtomDefaultFactory();
		factoryAuditAction = new CFBamAuditActionDefaultFactory();
		factoryBlobCol = new CFBamBlobColDefaultFactory();
		factoryBlobDef = new CFBamBlobDefDefaultFactory();
		factoryBlobType = new CFBamBlobTypeDefaultFactory();
		factoryBoolCol = new CFBamBoolColDefaultFactory();
		factoryBoolDef = new CFBamBoolDefDefaultFactory();
		factoryBoolType = new CFBamBoolTypeDefaultFactory();
		factoryChain = new CFBamChainDefaultFactory();
		factoryClearDep = new CFBamClearDepDefaultFactory();
		factoryClearSubDep1 = new CFBamClearSubDep1DefaultFactory();
		factoryClearSubDep2 = new CFBamClearSubDep2DefaultFactory();
		factoryClearSubDep3 = new CFBamClearSubDep3DefaultFactory();
		factoryClearTopDep = new CFBamClearTopDepDefaultFactory();
		factoryCluster = new CFBamClusterDefaultFactory();
		factoryDataScope = new CFBamDataScopeDefaultFactory();
		factoryDateCol = new CFBamDateColDefaultFactory();
		factoryDateDef = new CFBamDateDefDefaultFactory();
		factoryDateType = new CFBamDateTypeDefaultFactory();
		factoryDelDep = new CFBamDelDepDefaultFactory();
		factoryDelSubDep1 = new CFBamDelSubDep1DefaultFactory();
		factoryDelSubDep2 = new CFBamDelSubDep2DefaultFactory();
		factoryDelSubDep3 = new CFBamDelSubDep3DefaultFactory();
		factoryDelTopDep = new CFBamDelTopDepDefaultFactory();
		factoryDomain = new CFBamDomainDefaultFactory();
		factoryDomainBase = new CFBamDomainBaseDefaultFactory();
		factoryDoubleCol = new CFBamDoubleColDefaultFactory();
		factoryDoubleDef = new CFBamDoubleDefDefaultFactory();
		factoryDoubleType = new CFBamDoubleTypeDefaultFactory();
		factoryEnumCol = new CFBamEnumColDefaultFactory();
		factoryEnumDef = new CFBamEnumDefDefaultFactory();
		factoryEnumTag = new CFBamEnumTagDefaultFactory();
		factoryEnumType = new CFBamEnumTypeDefaultFactory();
		factoryFloatCol = new CFBamFloatColDefaultFactory();
		factoryFloatDef = new CFBamFloatDefDefaultFactory();
		factoryFloatType = new CFBamFloatTypeDefaultFactory();
		factoryHostNode = new CFBamHostNodeDefaultFactory();
		factoryISOCountry = new CFBamISOCountryDefaultFactory();
		factoryISOCountryCurrency = new CFBamISOCountryCurrencyDefaultFactory();
		factoryISOCountryLanguage = new CFBamISOCountryLanguageDefaultFactory();
		factoryISOCurrency = new CFBamISOCurrencyDefaultFactory();
		factoryISOLanguage = new CFBamISOLanguageDefaultFactory();
		factoryISOTimezone = new CFBamISOTimezoneDefaultFactory();
		factoryId16Gen = new CFBamId16GenDefaultFactory();
		factoryId32Gen = new CFBamId32GenDefaultFactory();
		factoryId64Gen = new CFBamId64GenDefaultFactory();
		factoryIndex = new CFBamIndexDefaultFactory();
		factoryIndexCol = new CFBamIndexColDefaultFactory();
		factoryInt16Col = new CFBamInt16ColDefaultFactory();
		factoryInt16Def = new CFBamInt16DefDefaultFactory();
		factoryInt16Type = new CFBamInt16TypeDefaultFactory();
		factoryInt32Col = new CFBamInt32ColDefaultFactory();
		factoryInt32Def = new CFBamInt32DefDefaultFactory();
		factoryInt32Type = new CFBamInt32TypeDefaultFactory();
		factoryInt64Col = new CFBamInt64ColDefaultFactory();
		factoryInt64Def = new CFBamInt64DefDefaultFactory();
		factoryInt64Type = new CFBamInt64TypeDefaultFactory();
		factoryLicense = new CFBamLicenseDefaultFactory();
		factoryLoaderBehaviour = new CFBamLoaderBehaviourDefaultFactory();
		factoryMajorVersion = new CFBamMajorVersionDefaultFactory();
		factoryMimeType = new CFBamMimeTypeDefaultFactory();
		factoryMinorVersion = new CFBamMinorVersionDefaultFactory();
		factoryNmTokenCol = new CFBamNmTokenColDefaultFactory();
		factoryNmTokenDef = new CFBamNmTokenDefDefaultFactory();
		factoryNmTokenType = new CFBamNmTokenTypeDefaultFactory();
		factoryNmTokensCol = new CFBamNmTokensColDefaultFactory();
		factoryNmTokensDef = new CFBamNmTokensDefDefaultFactory();
		factoryNmTokensType = new CFBamNmTokensTypeDefaultFactory();
		factoryNumberCol = new CFBamNumberColDefaultFactory();
		factoryNumberDef = new CFBamNumberDefDefaultFactory();
		factoryNumberType = new CFBamNumberTypeDefaultFactory();
		factoryParam = new CFBamParamDefaultFactory();
		factoryPopDep = new CFBamPopDepDefaultFactory();
		factoryPopSubDep1 = new CFBamPopSubDep1DefaultFactory();
		factoryPopSubDep2 = new CFBamPopSubDep2DefaultFactory();
		factoryPopSubDep3 = new CFBamPopSubDep3DefaultFactory();
		factoryPopTopDep = new CFBamPopTopDepDefaultFactory();
		factoryProjectBase = new CFBamProjectBaseDefaultFactory();
		factoryRealProject = new CFBamRealProjectDefaultFactory();
		factoryRelation = new CFBamRelationDefaultFactory();
		factoryRelationCol = new CFBamRelationColDefaultFactory();
		factoryRelationType = new CFBamRelationTypeDefaultFactory();
		factorySchemaDef = new CFBamSchemaDefDefaultFactory();
		factorySchemaRef = new CFBamSchemaRefDefaultFactory();
		factoryScope = new CFBamScopeDefaultFactory();
		factorySecApp = new CFBamSecAppDefaultFactory();
		factorySecDevice = new CFBamSecDeviceDefaultFactory();
		factorySecForm = new CFBamSecFormDefaultFactory();
		factorySecGroup = new CFBamSecGroupDefaultFactory();
		factorySecGroupForm = new CFBamSecGroupFormDefaultFactory();
		factorySecGroupInclude = new CFBamSecGroupIncludeDefaultFactory();
		factorySecGroupMember = new CFBamSecGroupMemberDefaultFactory();
		factorySecSession = new CFBamSecSessionDefaultFactory();
		factorySecUser = new CFBamSecUserDefaultFactory();
		factorySecurityScope = new CFBamSecurityScopeDefaultFactory();
		factoryServerListFunc = new CFBamServerListFuncDefaultFactory();
		factoryServerMethod = new CFBamServerMethodDefaultFactory();
		factoryServerObjFunc = new CFBamServerObjFuncDefaultFactory();
		factoryServerProc = new CFBamServerProcDefaultFactory();
		factoryService = new CFBamServiceDefaultFactory();
		factoryServiceType = new CFBamServiceTypeDefaultFactory();
		factoryStringCol = new CFBamStringColDefaultFactory();
		factoryStringDef = new CFBamStringDefDefaultFactory();
		factoryStringType = new CFBamStringTypeDefaultFactory();
		factorySubProject = new CFBamSubProjectDefaultFactory();
		factorySysCluster = new CFBamSysClusterDefaultFactory();
		factoryTSecGroup = new CFBamTSecGroupDefaultFactory();
		factoryTSecGroupInclude = new CFBamTSecGroupIncludeDefaultFactory();
		factoryTSecGroupMember = new CFBamTSecGroupMemberDefaultFactory();
		factoryTZDateCol = new CFBamTZDateColDefaultFactory();
		factoryTZDateDef = new CFBamTZDateDefDefaultFactory();
		factoryTZDateType = new CFBamTZDateTypeDefaultFactory();
		factoryTZTimeCol = new CFBamTZTimeColDefaultFactory();
		factoryTZTimeDef = new CFBamTZTimeDefDefaultFactory();
		factoryTZTimeType = new CFBamTZTimeTypeDefaultFactory();
		factoryTZTimestampCol = new CFBamTZTimestampColDefaultFactory();
		factoryTZTimestampDef = new CFBamTZTimestampDefDefaultFactory();
		factoryTZTimestampType = new CFBamTZTimestampTypeDefaultFactory();
		factoryTable = new CFBamTableDefaultFactory();
		factoryTableCol = new CFBamTableColDefaultFactory();
		factoryTenant = new CFBamTenantDefaultFactory();
		factoryTextCol = new CFBamTextColDefaultFactory();
		factoryTextDef = new CFBamTextDefDefaultFactory();
		factoryTextType = new CFBamTextTypeDefaultFactory();
		factoryTimeCol = new CFBamTimeColDefaultFactory();
		factoryTimeDef = new CFBamTimeDefDefaultFactory();
		factoryTimeType = new CFBamTimeTypeDefaultFactory();
		factoryTimestampCol = new CFBamTimestampColDefaultFactory();
		factoryTimestampDef = new CFBamTimestampDefDefaultFactory();
		factoryTimestampType = new CFBamTimestampTypeDefaultFactory();
		factoryTld = new CFBamTldDefaultFactory();
		factoryTokenCol = new CFBamTokenColDefaultFactory();
		factoryTokenDef = new CFBamTokenDefDefaultFactory();
		factoryTokenType = new CFBamTokenTypeDefaultFactory();
		factoryTopDomain = new CFBamTopDomainDefaultFactory();
		factoryTopProject = new CFBamTopProjectDefaultFactory();
		factoryUInt16Col = new CFBamUInt16ColDefaultFactory();
		factoryUInt16Def = new CFBamUInt16DefDefaultFactory();
		factoryUInt16Type = new CFBamUInt16TypeDefaultFactory();
		factoryUInt32Col = new CFBamUInt32ColDefaultFactory();
		factoryUInt32Def = new CFBamUInt32DefDefaultFactory();
		factoryUInt32Type = new CFBamUInt32TypeDefaultFactory();
		factoryUInt64Col = new CFBamUInt64ColDefaultFactory();
		factoryUInt64Def = new CFBamUInt64DefDefaultFactory();
		factoryUInt64Type = new CFBamUInt64TypeDefaultFactory();
		factoryURLProtocol = new CFBamURLProtocolDefaultFactory();
		factoryUuidCol = new CFBamUuidColDefaultFactory();
		factoryUuidDef = new CFBamUuidDefDefaultFactory();
		factoryUuidGen = new CFBamUuidGenDefaultFactory();
		factoryUuidType = new CFBamUuidTypeDefaultFactory();
		factoryValue = new CFBamValueDefaultFactory();
		factoryVersion = new CFBamVersionDefaultFactory();
	}

	public CFBamConfigurationFile getConfiguration() {
		return( configuration );
	}

	public void setConfiguration( CFBamConfigurationFile value ) {
		if( value == null ) {
			configuration = null;
		}
		else {
			configuration = value;
			jndiName = null;
		}
	}

	public String getJndiName() {
		return( jndiName );
	}

	public void setJndiName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			jndiName = null;
		}
		else {
			configuration = null;
			jndiName = value;
		}
	}

	public boolean isConnected() {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "isConnected" );
	}

	public boolean connect() {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "connect" );
	}

	public boolean connect( String username, String password ) {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "connect-userpw" );
	}

	public boolean connect( String loginId, String password, String clusterName, String tenantName ) {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "connect-full" );
	}

	public void disconnect( boolean doCommit ) {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "disconnect" );
	}

	public void logout( CFBamAuthorization auth ) {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "logout" );
	}

	public ICFBamSchema newSchema() {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "newSchema" );
	}

	/**
	 *	Import the contents of the specified file name
	 *	and file contents by applying a SAX Loader parse.
	 */
	public String fileImport( CFBamAuthorization auth, String fileName, String fileContents ) {
		final String S_ProcName = "fileImport";
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			S_ProcName,
			"You must overload this method to apply a SAX Parser to the file contents" );
	}

	public int nextServiceTypeIdGen() {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "nextServiceTypeIdGen" );
	}

	public int nextMimeTypeIdGen() {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "nextMimeTypeIdGen" );
	}

	public long nextClusterIdGen() {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "nextClusterIdGen" );
	}

	public long nextTenantIdGen() {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "nextTenantIdGen" );
	}

	public UUID nextSecSessionIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	public UUID nextSecUserIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	public ICFBamAccessFrequencyTable getTableAccessFrequency() {
		return( tableAccessFrequency );
	}

	public void setTableAccessFrequency( ICFBamAccessFrequencyTable value ) {
		tableAccessFrequency = value;
	}

	public ICFBamAccessFrequencyFactory getFactoryAccessFrequency() {
		return( factoryAccessFrequency );
	}

	public void setFactoryAccessFrequency( ICFBamAccessFrequencyFactory value ) {
		factoryAccessFrequency = value;
	}

	public ICFBamAccessSecurityTable getTableAccessSecurity() {
		return( tableAccessSecurity );
	}

	public void setTableAccessSecurity( ICFBamAccessSecurityTable value ) {
		tableAccessSecurity = value;
	}

	public ICFBamAccessSecurityFactory getFactoryAccessSecurity() {
		return( factoryAccessSecurity );
	}

	public void setFactoryAccessSecurity( ICFBamAccessSecurityFactory value ) {
		factoryAccessSecurity = value;
	}

	public ICFBamAtomTable getTableAtom() {
		return( tableAtom );
	}

	public void setTableAtom( ICFBamAtomTable value ) {
		tableAtom = value;
	}

	public ICFBamAtomFactory getFactoryAtom() {
		return( factoryAtom );
	}

	public void setFactoryAtom( ICFBamAtomFactory value ) {
		factoryAtom = value;
	}

	public ICFBamAuditActionTable getTableAuditAction() {
		return( tableAuditAction );
	}

	public void setTableAuditAction( ICFBamAuditActionTable value ) {
		tableAuditAction = value;
	}

	public ICFBamAuditActionFactory getFactoryAuditAction() {
		return( factoryAuditAction );
	}

	public void setFactoryAuditAction( ICFBamAuditActionFactory value ) {
		factoryAuditAction = value;
	}

	public ICFBamBlobColTable getTableBlobCol() {
		return( tableBlobCol );
	}

	public void setTableBlobCol( ICFBamBlobColTable value ) {
		tableBlobCol = value;
	}

	public ICFBamBlobColFactory getFactoryBlobCol() {
		return( factoryBlobCol );
	}

	public void setFactoryBlobCol( ICFBamBlobColFactory value ) {
		factoryBlobCol = value;
	}

	public ICFBamBlobDefTable getTableBlobDef() {
		return( tableBlobDef );
	}

	public void setTableBlobDef( ICFBamBlobDefTable value ) {
		tableBlobDef = value;
	}

	public ICFBamBlobDefFactory getFactoryBlobDef() {
		return( factoryBlobDef );
	}

	public void setFactoryBlobDef( ICFBamBlobDefFactory value ) {
		factoryBlobDef = value;
	}

	public ICFBamBlobTypeTable getTableBlobType() {
		return( tableBlobType );
	}

	public void setTableBlobType( ICFBamBlobTypeTable value ) {
		tableBlobType = value;
	}

	public ICFBamBlobTypeFactory getFactoryBlobType() {
		return( factoryBlobType );
	}

	public void setFactoryBlobType( ICFBamBlobTypeFactory value ) {
		factoryBlobType = value;
	}

	public ICFBamBoolColTable getTableBoolCol() {
		return( tableBoolCol );
	}

	public void setTableBoolCol( ICFBamBoolColTable value ) {
		tableBoolCol = value;
	}

	public ICFBamBoolColFactory getFactoryBoolCol() {
		return( factoryBoolCol );
	}

	public void setFactoryBoolCol( ICFBamBoolColFactory value ) {
		factoryBoolCol = value;
	}

	public ICFBamBoolDefTable getTableBoolDef() {
		return( tableBoolDef );
	}

	public void setTableBoolDef( ICFBamBoolDefTable value ) {
		tableBoolDef = value;
	}

	public ICFBamBoolDefFactory getFactoryBoolDef() {
		return( factoryBoolDef );
	}

	public void setFactoryBoolDef( ICFBamBoolDefFactory value ) {
		factoryBoolDef = value;
	}

	public ICFBamBoolTypeTable getTableBoolType() {
		return( tableBoolType );
	}

	public void setTableBoolType( ICFBamBoolTypeTable value ) {
		tableBoolType = value;
	}

	public ICFBamBoolTypeFactory getFactoryBoolType() {
		return( factoryBoolType );
	}

	public void setFactoryBoolType( ICFBamBoolTypeFactory value ) {
		factoryBoolType = value;
	}

	public ICFBamChainTable getTableChain() {
		return( tableChain );
	}

	public void setTableChain( ICFBamChainTable value ) {
		tableChain = value;
	}

	public ICFBamChainFactory getFactoryChain() {
		return( factoryChain );
	}

	public void setFactoryChain( ICFBamChainFactory value ) {
		factoryChain = value;
	}

	public ICFBamClearDepTable getTableClearDep() {
		return( tableClearDep );
	}

	public void setTableClearDep( ICFBamClearDepTable value ) {
		tableClearDep = value;
	}

	public ICFBamClearDepFactory getFactoryClearDep() {
		return( factoryClearDep );
	}

	public void setFactoryClearDep( ICFBamClearDepFactory value ) {
		factoryClearDep = value;
	}

	public ICFBamClearSubDep1Table getTableClearSubDep1() {
		return( tableClearSubDep1 );
	}

	public void setTableClearSubDep1( ICFBamClearSubDep1Table value ) {
		tableClearSubDep1 = value;
	}

	public ICFBamClearSubDep1Factory getFactoryClearSubDep1() {
		return( factoryClearSubDep1 );
	}

	public void setFactoryClearSubDep1( ICFBamClearSubDep1Factory value ) {
		factoryClearSubDep1 = value;
	}

	public ICFBamClearSubDep2Table getTableClearSubDep2() {
		return( tableClearSubDep2 );
	}

	public void setTableClearSubDep2( ICFBamClearSubDep2Table value ) {
		tableClearSubDep2 = value;
	}

	public ICFBamClearSubDep2Factory getFactoryClearSubDep2() {
		return( factoryClearSubDep2 );
	}

	public void setFactoryClearSubDep2( ICFBamClearSubDep2Factory value ) {
		factoryClearSubDep2 = value;
	}

	public ICFBamClearSubDep3Table getTableClearSubDep3() {
		return( tableClearSubDep3 );
	}

	public void setTableClearSubDep3( ICFBamClearSubDep3Table value ) {
		tableClearSubDep3 = value;
	}

	public ICFBamClearSubDep3Factory getFactoryClearSubDep3() {
		return( factoryClearSubDep3 );
	}

	public void setFactoryClearSubDep3( ICFBamClearSubDep3Factory value ) {
		factoryClearSubDep3 = value;
	}

	public ICFBamClearTopDepTable getTableClearTopDep() {
		return( tableClearTopDep );
	}

	public void setTableClearTopDep( ICFBamClearTopDepTable value ) {
		tableClearTopDep = value;
	}

	public ICFBamClearTopDepFactory getFactoryClearTopDep() {
		return( factoryClearTopDep );
	}

	public void setFactoryClearTopDep( ICFBamClearTopDepFactory value ) {
		factoryClearTopDep = value;
	}

	public ICFBamClusterTable getTableCluster() {
		return( tableCluster );
	}

	public void setTableCluster( ICFBamClusterTable value ) {
		tableCluster = value;
	}

	public ICFBamClusterFactory getFactoryCluster() {
		return( factoryCluster );
	}

	public void setFactoryCluster( ICFBamClusterFactory value ) {
		factoryCluster = value;
	}

	public ICFBamDataScopeTable getTableDataScope() {
		return( tableDataScope );
	}

	public void setTableDataScope( ICFBamDataScopeTable value ) {
		tableDataScope = value;
	}

	public ICFBamDataScopeFactory getFactoryDataScope() {
		return( factoryDataScope );
	}

	public void setFactoryDataScope( ICFBamDataScopeFactory value ) {
		factoryDataScope = value;
	}

	public ICFBamDateColTable getTableDateCol() {
		return( tableDateCol );
	}

	public void setTableDateCol( ICFBamDateColTable value ) {
		tableDateCol = value;
	}

	public ICFBamDateColFactory getFactoryDateCol() {
		return( factoryDateCol );
	}

	public void setFactoryDateCol( ICFBamDateColFactory value ) {
		factoryDateCol = value;
	}

	public ICFBamDateDefTable getTableDateDef() {
		return( tableDateDef );
	}

	public void setTableDateDef( ICFBamDateDefTable value ) {
		tableDateDef = value;
	}

	public ICFBamDateDefFactory getFactoryDateDef() {
		return( factoryDateDef );
	}

	public void setFactoryDateDef( ICFBamDateDefFactory value ) {
		factoryDateDef = value;
	}

	public ICFBamDateTypeTable getTableDateType() {
		return( tableDateType );
	}

	public void setTableDateType( ICFBamDateTypeTable value ) {
		tableDateType = value;
	}

	public ICFBamDateTypeFactory getFactoryDateType() {
		return( factoryDateType );
	}

	public void setFactoryDateType( ICFBamDateTypeFactory value ) {
		factoryDateType = value;
	}

	public ICFBamDelDepTable getTableDelDep() {
		return( tableDelDep );
	}

	public void setTableDelDep( ICFBamDelDepTable value ) {
		tableDelDep = value;
	}

	public ICFBamDelDepFactory getFactoryDelDep() {
		return( factoryDelDep );
	}

	public void setFactoryDelDep( ICFBamDelDepFactory value ) {
		factoryDelDep = value;
	}

	public ICFBamDelSubDep1Table getTableDelSubDep1() {
		return( tableDelSubDep1 );
	}

	public void setTableDelSubDep1( ICFBamDelSubDep1Table value ) {
		tableDelSubDep1 = value;
	}

	public ICFBamDelSubDep1Factory getFactoryDelSubDep1() {
		return( factoryDelSubDep1 );
	}

	public void setFactoryDelSubDep1( ICFBamDelSubDep1Factory value ) {
		factoryDelSubDep1 = value;
	}

	public ICFBamDelSubDep2Table getTableDelSubDep2() {
		return( tableDelSubDep2 );
	}

	public void setTableDelSubDep2( ICFBamDelSubDep2Table value ) {
		tableDelSubDep2 = value;
	}

	public ICFBamDelSubDep2Factory getFactoryDelSubDep2() {
		return( factoryDelSubDep2 );
	}

	public void setFactoryDelSubDep2( ICFBamDelSubDep2Factory value ) {
		factoryDelSubDep2 = value;
	}

	public ICFBamDelSubDep3Table getTableDelSubDep3() {
		return( tableDelSubDep3 );
	}

	public void setTableDelSubDep3( ICFBamDelSubDep3Table value ) {
		tableDelSubDep3 = value;
	}

	public ICFBamDelSubDep3Factory getFactoryDelSubDep3() {
		return( factoryDelSubDep3 );
	}

	public void setFactoryDelSubDep3( ICFBamDelSubDep3Factory value ) {
		factoryDelSubDep3 = value;
	}

	public ICFBamDelTopDepTable getTableDelTopDep() {
		return( tableDelTopDep );
	}

	public void setTableDelTopDep( ICFBamDelTopDepTable value ) {
		tableDelTopDep = value;
	}

	public ICFBamDelTopDepFactory getFactoryDelTopDep() {
		return( factoryDelTopDep );
	}

	public void setFactoryDelTopDep( ICFBamDelTopDepFactory value ) {
		factoryDelTopDep = value;
	}

	public ICFBamDomainTable getTableDomain() {
		return( tableDomain );
	}

	public void setTableDomain( ICFBamDomainTable value ) {
		tableDomain = value;
	}

	public ICFBamDomainFactory getFactoryDomain() {
		return( factoryDomain );
	}

	public void setFactoryDomain( ICFBamDomainFactory value ) {
		factoryDomain = value;
	}

	public ICFBamDomainBaseTable getTableDomainBase() {
		return( tableDomainBase );
	}

	public void setTableDomainBase( ICFBamDomainBaseTable value ) {
		tableDomainBase = value;
	}

	public ICFBamDomainBaseFactory getFactoryDomainBase() {
		return( factoryDomainBase );
	}

	public void setFactoryDomainBase( ICFBamDomainBaseFactory value ) {
		factoryDomainBase = value;
	}

	public ICFBamDoubleColTable getTableDoubleCol() {
		return( tableDoubleCol );
	}

	public void setTableDoubleCol( ICFBamDoubleColTable value ) {
		tableDoubleCol = value;
	}

	public ICFBamDoubleColFactory getFactoryDoubleCol() {
		return( factoryDoubleCol );
	}

	public void setFactoryDoubleCol( ICFBamDoubleColFactory value ) {
		factoryDoubleCol = value;
	}

	public ICFBamDoubleDefTable getTableDoubleDef() {
		return( tableDoubleDef );
	}

	public void setTableDoubleDef( ICFBamDoubleDefTable value ) {
		tableDoubleDef = value;
	}

	public ICFBamDoubleDefFactory getFactoryDoubleDef() {
		return( factoryDoubleDef );
	}

	public void setFactoryDoubleDef( ICFBamDoubleDefFactory value ) {
		factoryDoubleDef = value;
	}

	public ICFBamDoubleTypeTable getTableDoubleType() {
		return( tableDoubleType );
	}

	public void setTableDoubleType( ICFBamDoubleTypeTable value ) {
		tableDoubleType = value;
	}

	public ICFBamDoubleTypeFactory getFactoryDoubleType() {
		return( factoryDoubleType );
	}

	public void setFactoryDoubleType( ICFBamDoubleTypeFactory value ) {
		factoryDoubleType = value;
	}

	public ICFBamEnumColTable getTableEnumCol() {
		return( tableEnumCol );
	}

	public void setTableEnumCol( ICFBamEnumColTable value ) {
		tableEnumCol = value;
	}

	public ICFBamEnumColFactory getFactoryEnumCol() {
		return( factoryEnumCol );
	}

	public void setFactoryEnumCol( ICFBamEnumColFactory value ) {
		factoryEnumCol = value;
	}

	public ICFBamEnumDefTable getTableEnumDef() {
		return( tableEnumDef );
	}

	public void setTableEnumDef( ICFBamEnumDefTable value ) {
		tableEnumDef = value;
	}

	public ICFBamEnumDefFactory getFactoryEnumDef() {
		return( factoryEnumDef );
	}

	public void setFactoryEnumDef( ICFBamEnumDefFactory value ) {
		factoryEnumDef = value;
	}

	public ICFBamEnumTagTable getTableEnumTag() {
		return( tableEnumTag );
	}

	public void setTableEnumTag( ICFBamEnumTagTable value ) {
		tableEnumTag = value;
	}

	public ICFBamEnumTagFactory getFactoryEnumTag() {
		return( factoryEnumTag );
	}

	public void setFactoryEnumTag( ICFBamEnumTagFactory value ) {
		factoryEnumTag = value;
	}

	public ICFBamEnumTypeTable getTableEnumType() {
		return( tableEnumType );
	}

	public void setTableEnumType( ICFBamEnumTypeTable value ) {
		tableEnumType = value;
	}

	public ICFBamEnumTypeFactory getFactoryEnumType() {
		return( factoryEnumType );
	}

	public void setFactoryEnumType( ICFBamEnumTypeFactory value ) {
		factoryEnumType = value;
	}

	public ICFBamFloatColTable getTableFloatCol() {
		return( tableFloatCol );
	}

	public void setTableFloatCol( ICFBamFloatColTable value ) {
		tableFloatCol = value;
	}

	public ICFBamFloatColFactory getFactoryFloatCol() {
		return( factoryFloatCol );
	}

	public void setFactoryFloatCol( ICFBamFloatColFactory value ) {
		factoryFloatCol = value;
	}

	public ICFBamFloatDefTable getTableFloatDef() {
		return( tableFloatDef );
	}

	public void setTableFloatDef( ICFBamFloatDefTable value ) {
		tableFloatDef = value;
	}

	public ICFBamFloatDefFactory getFactoryFloatDef() {
		return( factoryFloatDef );
	}

	public void setFactoryFloatDef( ICFBamFloatDefFactory value ) {
		factoryFloatDef = value;
	}

	public ICFBamFloatTypeTable getTableFloatType() {
		return( tableFloatType );
	}

	public void setTableFloatType( ICFBamFloatTypeTable value ) {
		tableFloatType = value;
	}

	public ICFBamFloatTypeFactory getFactoryFloatType() {
		return( factoryFloatType );
	}

	public void setFactoryFloatType( ICFBamFloatTypeFactory value ) {
		factoryFloatType = value;
	}

	public ICFBamHostNodeTable getTableHostNode() {
		return( tableHostNode );
	}

	public void setTableHostNode( ICFBamHostNodeTable value ) {
		tableHostNode = value;
	}

	public ICFBamHostNodeFactory getFactoryHostNode() {
		return( factoryHostNode );
	}

	public void setFactoryHostNode( ICFBamHostNodeFactory value ) {
		factoryHostNode = value;
	}

	public ICFBamISOCountryTable getTableISOCountry() {
		return( tableISOCountry );
	}

	public void setTableISOCountry( ICFBamISOCountryTable value ) {
		tableISOCountry = value;
	}

	public ICFBamISOCountryFactory getFactoryISOCountry() {
		return( factoryISOCountry );
	}

	public void setFactoryISOCountry( ICFBamISOCountryFactory value ) {
		factoryISOCountry = value;
	}

	public ICFBamISOCountryCurrencyTable getTableISOCountryCurrency() {
		return( tableISOCountryCurrency );
	}

	public void setTableISOCountryCurrency( ICFBamISOCountryCurrencyTable value ) {
		tableISOCountryCurrency = value;
	}

	public ICFBamISOCountryCurrencyFactory getFactoryISOCountryCurrency() {
		return( factoryISOCountryCurrency );
	}

	public void setFactoryISOCountryCurrency( ICFBamISOCountryCurrencyFactory value ) {
		factoryISOCountryCurrency = value;
	}

	public ICFBamISOCountryLanguageTable getTableISOCountryLanguage() {
		return( tableISOCountryLanguage );
	}

	public void setTableISOCountryLanguage( ICFBamISOCountryLanguageTable value ) {
		tableISOCountryLanguage = value;
	}

	public ICFBamISOCountryLanguageFactory getFactoryISOCountryLanguage() {
		return( factoryISOCountryLanguage );
	}

	public void setFactoryISOCountryLanguage( ICFBamISOCountryLanguageFactory value ) {
		factoryISOCountryLanguage = value;
	}

	public ICFBamISOCurrencyTable getTableISOCurrency() {
		return( tableISOCurrency );
	}

	public void setTableISOCurrency( ICFBamISOCurrencyTable value ) {
		tableISOCurrency = value;
	}

	public ICFBamISOCurrencyFactory getFactoryISOCurrency() {
		return( factoryISOCurrency );
	}

	public void setFactoryISOCurrency( ICFBamISOCurrencyFactory value ) {
		factoryISOCurrency = value;
	}

	public ICFBamISOLanguageTable getTableISOLanguage() {
		return( tableISOLanguage );
	}

	public void setTableISOLanguage( ICFBamISOLanguageTable value ) {
		tableISOLanguage = value;
	}

	public ICFBamISOLanguageFactory getFactoryISOLanguage() {
		return( factoryISOLanguage );
	}

	public void setFactoryISOLanguage( ICFBamISOLanguageFactory value ) {
		factoryISOLanguage = value;
	}

	public ICFBamISOTimezoneTable getTableISOTimezone() {
		return( tableISOTimezone );
	}

	public void setTableISOTimezone( ICFBamISOTimezoneTable value ) {
		tableISOTimezone = value;
	}

	public ICFBamISOTimezoneFactory getFactoryISOTimezone() {
		return( factoryISOTimezone );
	}

	public void setFactoryISOTimezone( ICFBamISOTimezoneFactory value ) {
		factoryISOTimezone = value;
	}

	public ICFBamId16GenTable getTableId16Gen() {
		return( tableId16Gen );
	}

	public void setTableId16Gen( ICFBamId16GenTable value ) {
		tableId16Gen = value;
	}

	public ICFBamId16GenFactory getFactoryId16Gen() {
		return( factoryId16Gen );
	}

	public void setFactoryId16Gen( ICFBamId16GenFactory value ) {
		factoryId16Gen = value;
	}

	public ICFBamId32GenTable getTableId32Gen() {
		return( tableId32Gen );
	}

	public void setTableId32Gen( ICFBamId32GenTable value ) {
		tableId32Gen = value;
	}

	public ICFBamId32GenFactory getFactoryId32Gen() {
		return( factoryId32Gen );
	}

	public void setFactoryId32Gen( ICFBamId32GenFactory value ) {
		factoryId32Gen = value;
	}

	public ICFBamId64GenTable getTableId64Gen() {
		return( tableId64Gen );
	}

	public void setTableId64Gen( ICFBamId64GenTable value ) {
		tableId64Gen = value;
	}

	public ICFBamId64GenFactory getFactoryId64Gen() {
		return( factoryId64Gen );
	}

	public void setFactoryId64Gen( ICFBamId64GenFactory value ) {
		factoryId64Gen = value;
	}

	public ICFBamIndexTable getTableIndex() {
		return( tableIndex );
	}

	public void setTableIndex( ICFBamIndexTable value ) {
		tableIndex = value;
	}

	public ICFBamIndexFactory getFactoryIndex() {
		return( factoryIndex );
	}

	public void setFactoryIndex( ICFBamIndexFactory value ) {
		factoryIndex = value;
	}

	public ICFBamIndexColTable getTableIndexCol() {
		return( tableIndexCol );
	}

	public void setTableIndexCol( ICFBamIndexColTable value ) {
		tableIndexCol = value;
	}

	public ICFBamIndexColFactory getFactoryIndexCol() {
		return( factoryIndexCol );
	}

	public void setFactoryIndexCol( ICFBamIndexColFactory value ) {
		factoryIndexCol = value;
	}

	public ICFBamInt16ColTable getTableInt16Col() {
		return( tableInt16Col );
	}

	public void setTableInt16Col( ICFBamInt16ColTable value ) {
		tableInt16Col = value;
	}

	public ICFBamInt16ColFactory getFactoryInt16Col() {
		return( factoryInt16Col );
	}

	public void setFactoryInt16Col( ICFBamInt16ColFactory value ) {
		factoryInt16Col = value;
	}

	public ICFBamInt16DefTable getTableInt16Def() {
		return( tableInt16Def );
	}

	public void setTableInt16Def( ICFBamInt16DefTable value ) {
		tableInt16Def = value;
	}

	public ICFBamInt16DefFactory getFactoryInt16Def() {
		return( factoryInt16Def );
	}

	public void setFactoryInt16Def( ICFBamInt16DefFactory value ) {
		factoryInt16Def = value;
	}

	public ICFBamInt16TypeTable getTableInt16Type() {
		return( tableInt16Type );
	}

	public void setTableInt16Type( ICFBamInt16TypeTable value ) {
		tableInt16Type = value;
	}

	public ICFBamInt16TypeFactory getFactoryInt16Type() {
		return( factoryInt16Type );
	}

	public void setFactoryInt16Type( ICFBamInt16TypeFactory value ) {
		factoryInt16Type = value;
	}

	public ICFBamInt32ColTable getTableInt32Col() {
		return( tableInt32Col );
	}

	public void setTableInt32Col( ICFBamInt32ColTable value ) {
		tableInt32Col = value;
	}

	public ICFBamInt32ColFactory getFactoryInt32Col() {
		return( factoryInt32Col );
	}

	public void setFactoryInt32Col( ICFBamInt32ColFactory value ) {
		factoryInt32Col = value;
	}

	public ICFBamInt32DefTable getTableInt32Def() {
		return( tableInt32Def );
	}

	public void setTableInt32Def( ICFBamInt32DefTable value ) {
		tableInt32Def = value;
	}

	public ICFBamInt32DefFactory getFactoryInt32Def() {
		return( factoryInt32Def );
	}

	public void setFactoryInt32Def( ICFBamInt32DefFactory value ) {
		factoryInt32Def = value;
	}

	public ICFBamInt32TypeTable getTableInt32Type() {
		return( tableInt32Type );
	}

	public void setTableInt32Type( ICFBamInt32TypeTable value ) {
		tableInt32Type = value;
	}

	public ICFBamInt32TypeFactory getFactoryInt32Type() {
		return( factoryInt32Type );
	}

	public void setFactoryInt32Type( ICFBamInt32TypeFactory value ) {
		factoryInt32Type = value;
	}

	public ICFBamInt64ColTable getTableInt64Col() {
		return( tableInt64Col );
	}

	public void setTableInt64Col( ICFBamInt64ColTable value ) {
		tableInt64Col = value;
	}

	public ICFBamInt64ColFactory getFactoryInt64Col() {
		return( factoryInt64Col );
	}

	public void setFactoryInt64Col( ICFBamInt64ColFactory value ) {
		factoryInt64Col = value;
	}

	public ICFBamInt64DefTable getTableInt64Def() {
		return( tableInt64Def );
	}

	public void setTableInt64Def( ICFBamInt64DefTable value ) {
		tableInt64Def = value;
	}

	public ICFBamInt64DefFactory getFactoryInt64Def() {
		return( factoryInt64Def );
	}

	public void setFactoryInt64Def( ICFBamInt64DefFactory value ) {
		factoryInt64Def = value;
	}

	public ICFBamInt64TypeTable getTableInt64Type() {
		return( tableInt64Type );
	}

	public void setTableInt64Type( ICFBamInt64TypeTable value ) {
		tableInt64Type = value;
	}

	public ICFBamInt64TypeFactory getFactoryInt64Type() {
		return( factoryInt64Type );
	}

	public void setFactoryInt64Type( ICFBamInt64TypeFactory value ) {
		factoryInt64Type = value;
	}

	public ICFBamLicenseTable getTableLicense() {
		return( tableLicense );
	}

	public void setTableLicense( ICFBamLicenseTable value ) {
		tableLicense = value;
	}

	public ICFBamLicenseFactory getFactoryLicense() {
		return( factoryLicense );
	}

	public void setFactoryLicense( ICFBamLicenseFactory value ) {
		factoryLicense = value;
	}

	public ICFBamLoaderBehaviourTable getTableLoaderBehaviour() {
		return( tableLoaderBehaviour );
	}

	public void setTableLoaderBehaviour( ICFBamLoaderBehaviourTable value ) {
		tableLoaderBehaviour = value;
	}

	public ICFBamLoaderBehaviourFactory getFactoryLoaderBehaviour() {
		return( factoryLoaderBehaviour );
	}

	public void setFactoryLoaderBehaviour( ICFBamLoaderBehaviourFactory value ) {
		factoryLoaderBehaviour = value;
	}

	public ICFBamMajorVersionTable getTableMajorVersion() {
		return( tableMajorVersion );
	}

	public void setTableMajorVersion( ICFBamMajorVersionTable value ) {
		tableMajorVersion = value;
	}

	public ICFBamMajorVersionFactory getFactoryMajorVersion() {
		return( factoryMajorVersion );
	}

	public void setFactoryMajorVersion( ICFBamMajorVersionFactory value ) {
		factoryMajorVersion = value;
	}

	public ICFBamMimeTypeTable getTableMimeType() {
		return( tableMimeType );
	}

	public void setTableMimeType( ICFBamMimeTypeTable value ) {
		tableMimeType = value;
	}

	public ICFBamMimeTypeFactory getFactoryMimeType() {
		return( factoryMimeType );
	}

	public void setFactoryMimeType( ICFBamMimeTypeFactory value ) {
		factoryMimeType = value;
	}

	public ICFBamMinorVersionTable getTableMinorVersion() {
		return( tableMinorVersion );
	}

	public void setTableMinorVersion( ICFBamMinorVersionTable value ) {
		tableMinorVersion = value;
	}

	public ICFBamMinorVersionFactory getFactoryMinorVersion() {
		return( factoryMinorVersion );
	}

	public void setFactoryMinorVersion( ICFBamMinorVersionFactory value ) {
		factoryMinorVersion = value;
	}

	public ICFBamNmTokenColTable getTableNmTokenCol() {
		return( tableNmTokenCol );
	}

	public void setTableNmTokenCol( ICFBamNmTokenColTable value ) {
		tableNmTokenCol = value;
	}

	public ICFBamNmTokenColFactory getFactoryNmTokenCol() {
		return( factoryNmTokenCol );
	}

	public void setFactoryNmTokenCol( ICFBamNmTokenColFactory value ) {
		factoryNmTokenCol = value;
	}

	public ICFBamNmTokenDefTable getTableNmTokenDef() {
		return( tableNmTokenDef );
	}

	public void setTableNmTokenDef( ICFBamNmTokenDefTable value ) {
		tableNmTokenDef = value;
	}

	public ICFBamNmTokenDefFactory getFactoryNmTokenDef() {
		return( factoryNmTokenDef );
	}

	public void setFactoryNmTokenDef( ICFBamNmTokenDefFactory value ) {
		factoryNmTokenDef = value;
	}

	public ICFBamNmTokenTypeTable getTableNmTokenType() {
		return( tableNmTokenType );
	}

	public void setTableNmTokenType( ICFBamNmTokenTypeTable value ) {
		tableNmTokenType = value;
	}

	public ICFBamNmTokenTypeFactory getFactoryNmTokenType() {
		return( factoryNmTokenType );
	}

	public void setFactoryNmTokenType( ICFBamNmTokenTypeFactory value ) {
		factoryNmTokenType = value;
	}

	public ICFBamNmTokensColTable getTableNmTokensCol() {
		return( tableNmTokensCol );
	}

	public void setTableNmTokensCol( ICFBamNmTokensColTable value ) {
		tableNmTokensCol = value;
	}

	public ICFBamNmTokensColFactory getFactoryNmTokensCol() {
		return( factoryNmTokensCol );
	}

	public void setFactoryNmTokensCol( ICFBamNmTokensColFactory value ) {
		factoryNmTokensCol = value;
	}

	public ICFBamNmTokensDefTable getTableNmTokensDef() {
		return( tableNmTokensDef );
	}

	public void setTableNmTokensDef( ICFBamNmTokensDefTable value ) {
		tableNmTokensDef = value;
	}

	public ICFBamNmTokensDefFactory getFactoryNmTokensDef() {
		return( factoryNmTokensDef );
	}

	public void setFactoryNmTokensDef( ICFBamNmTokensDefFactory value ) {
		factoryNmTokensDef = value;
	}

	public ICFBamNmTokensTypeTable getTableNmTokensType() {
		return( tableNmTokensType );
	}

	public void setTableNmTokensType( ICFBamNmTokensTypeTable value ) {
		tableNmTokensType = value;
	}

	public ICFBamNmTokensTypeFactory getFactoryNmTokensType() {
		return( factoryNmTokensType );
	}

	public void setFactoryNmTokensType( ICFBamNmTokensTypeFactory value ) {
		factoryNmTokensType = value;
	}

	public ICFBamNumberColTable getTableNumberCol() {
		return( tableNumberCol );
	}

	public void setTableNumberCol( ICFBamNumberColTable value ) {
		tableNumberCol = value;
	}

	public ICFBamNumberColFactory getFactoryNumberCol() {
		return( factoryNumberCol );
	}

	public void setFactoryNumberCol( ICFBamNumberColFactory value ) {
		factoryNumberCol = value;
	}

	public ICFBamNumberDefTable getTableNumberDef() {
		return( tableNumberDef );
	}

	public void setTableNumberDef( ICFBamNumberDefTable value ) {
		tableNumberDef = value;
	}

	public ICFBamNumberDefFactory getFactoryNumberDef() {
		return( factoryNumberDef );
	}

	public void setFactoryNumberDef( ICFBamNumberDefFactory value ) {
		factoryNumberDef = value;
	}

	public ICFBamNumberTypeTable getTableNumberType() {
		return( tableNumberType );
	}

	public void setTableNumberType( ICFBamNumberTypeTable value ) {
		tableNumberType = value;
	}

	public ICFBamNumberTypeFactory getFactoryNumberType() {
		return( factoryNumberType );
	}

	public void setFactoryNumberType( ICFBamNumberTypeFactory value ) {
		factoryNumberType = value;
	}

	public ICFBamParamTable getTableParam() {
		return( tableParam );
	}

	public void setTableParam( ICFBamParamTable value ) {
		tableParam = value;
	}

	public ICFBamParamFactory getFactoryParam() {
		return( factoryParam );
	}

	public void setFactoryParam( ICFBamParamFactory value ) {
		factoryParam = value;
	}

	public ICFBamPopDepTable getTablePopDep() {
		return( tablePopDep );
	}

	public void setTablePopDep( ICFBamPopDepTable value ) {
		tablePopDep = value;
	}

	public ICFBamPopDepFactory getFactoryPopDep() {
		return( factoryPopDep );
	}

	public void setFactoryPopDep( ICFBamPopDepFactory value ) {
		factoryPopDep = value;
	}

	public ICFBamPopSubDep1Table getTablePopSubDep1() {
		return( tablePopSubDep1 );
	}

	public void setTablePopSubDep1( ICFBamPopSubDep1Table value ) {
		tablePopSubDep1 = value;
	}

	public ICFBamPopSubDep1Factory getFactoryPopSubDep1() {
		return( factoryPopSubDep1 );
	}

	public void setFactoryPopSubDep1( ICFBamPopSubDep1Factory value ) {
		factoryPopSubDep1 = value;
	}

	public ICFBamPopSubDep2Table getTablePopSubDep2() {
		return( tablePopSubDep2 );
	}

	public void setTablePopSubDep2( ICFBamPopSubDep2Table value ) {
		tablePopSubDep2 = value;
	}

	public ICFBamPopSubDep2Factory getFactoryPopSubDep2() {
		return( factoryPopSubDep2 );
	}

	public void setFactoryPopSubDep2( ICFBamPopSubDep2Factory value ) {
		factoryPopSubDep2 = value;
	}

	public ICFBamPopSubDep3Table getTablePopSubDep3() {
		return( tablePopSubDep3 );
	}

	public void setTablePopSubDep3( ICFBamPopSubDep3Table value ) {
		tablePopSubDep3 = value;
	}

	public ICFBamPopSubDep3Factory getFactoryPopSubDep3() {
		return( factoryPopSubDep3 );
	}

	public void setFactoryPopSubDep3( ICFBamPopSubDep3Factory value ) {
		factoryPopSubDep3 = value;
	}

	public ICFBamPopTopDepTable getTablePopTopDep() {
		return( tablePopTopDep );
	}

	public void setTablePopTopDep( ICFBamPopTopDepTable value ) {
		tablePopTopDep = value;
	}

	public ICFBamPopTopDepFactory getFactoryPopTopDep() {
		return( factoryPopTopDep );
	}

	public void setFactoryPopTopDep( ICFBamPopTopDepFactory value ) {
		factoryPopTopDep = value;
	}

	public ICFBamProjectBaseTable getTableProjectBase() {
		return( tableProjectBase );
	}

	public void setTableProjectBase( ICFBamProjectBaseTable value ) {
		tableProjectBase = value;
	}

	public ICFBamProjectBaseFactory getFactoryProjectBase() {
		return( factoryProjectBase );
	}

	public void setFactoryProjectBase( ICFBamProjectBaseFactory value ) {
		factoryProjectBase = value;
	}

	public ICFBamRealProjectTable getTableRealProject() {
		return( tableRealProject );
	}

	public void setTableRealProject( ICFBamRealProjectTable value ) {
		tableRealProject = value;
	}

	public ICFBamRealProjectFactory getFactoryRealProject() {
		return( factoryRealProject );
	}

	public void setFactoryRealProject( ICFBamRealProjectFactory value ) {
		factoryRealProject = value;
	}

	public ICFBamRelationTable getTableRelation() {
		return( tableRelation );
	}

	public void setTableRelation( ICFBamRelationTable value ) {
		tableRelation = value;
	}

	public ICFBamRelationFactory getFactoryRelation() {
		return( factoryRelation );
	}

	public void setFactoryRelation( ICFBamRelationFactory value ) {
		factoryRelation = value;
	}

	public ICFBamRelationColTable getTableRelationCol() {
		return( tableRelationCol );
	}

	public void setTableRelationCol( ICFBamRelationColTable value ) {
		tableRelationCol = value;
	}

	public ICFBamRelationColFactory getFactoryRelationCol() {
		return( factoryRelationCol );
	}

	public void setFactoryRelationCol( ICFBamRelationColFactory value ) {
		factoryRelationCol = value;
	}

	public ICFBamRelationTypeTable getTableRelationType() {
		return( tableRelationType );
	}

	public void setTableRelationType( ICFBamRelationTypeTable value ) {
		tableRelationType = value;
	}

	public ICFBamRelationTypeFactory getFactoryRelationType() {
		return( factoryRelationType );
	}

	public void setFactoryRelationType( ICFBamRelationTypeFactory value ) {
		factoryRelationType = value;
	}

	public ICFBamSchemaDefTable getTableSchemaDef() {
		return( tableSchemaDef );
	}

	public void setTableSchemaDef( ICFBamSchemaDefTable value ) {
		tableSchemaDef = value;
	}

	public ICFBamSchemaDefFactory getFactorySchemaDef() {
		return( factorySchemaDef );
	}

	public void setFactorySchemaDef( ICFBamSchemaDefFactory value ) {
		factorySchemaDef = value;
	}

	public ICFBamSchemaRefTable getTableSchemaRef() {
		return( tableSchemaRef );
	}

	public void setTableSchemaRef( ICFBamSchemaRefTable value ) {
		tableSchemaRef = value;
	}

	public ICFBamSchemaRefFactory getFactorySchemaRef() {
		return( factorySchemaRef );
	}

	public void setFactorySchemaRef( ICFBamSchemaRefFactory value ) {
		factorySchemaRef = value;
	}

	public ICFBamScopeTable getTableScope() {
		return( tableScope );
	}

	public void setTableScope( ICFBamScopeTable value ) {
		tableScope = value;
	}

	public ICFBamScopeFactory getFactoryScope() {
		return( factoryScope );
	}

	public void setFactoryScope( ICFBamScopeFactory value ) {
		factoryScope = value;
	}

	public ICFBamSecAppTable getTableSecApp() {
		return( tableSecApp );
	}

	public void setTableSecApp( ICFBamSecAppTable value ) {
		tableSecApp = value;
	}

	public ICFBamSecAppFactory getFactorySecApp() {
		return( factorySecApp );
	}

	public void setFactorySecApp( ICFBamSecAppFactory value ) {
		factorySecApp = value;
	}

	public ICFBamSecDeviceTable getTableSecDevice() {
		return( tableSecDevice );
	}

	public void setTableSecDevice( ICFBamSecDeviceTable value ) {
		tableSecDevice = value;
	}

	public ICFBamSecDeviceFactory getFactorySecDevice() {
		return( factorySecDevice );
	}

	public void setFactorySecDevice( ICFBamSecDeviceFactory value ) {
		factorySecDevice = value;
	}

	public ICFBamSecFormTable getTableSecForm() {
		return( tableSecForm );
	}

	public void setTableSecForm( ICFBamSecFormTable value ) {
		tableSecForm = value;
	}

	public ICFBamSecFormFactory getFactorySecForm() {
		return( factorySecForm );
	}

	public void setFactorySecForm( ICFBamSecFormFactory value ) {
		factorySecForm = value;
	}

	public ICFBamSecGroupTable getTableSecGroup() {
		return( tableSecGroup );
	}

	public void setTableSecGroup( ICFBamSecGroupTable value ) {
		tableSecGroup = value;
	}

	public ICFBamSecGroupFactory getFactorySecGroup() {
		return( factorySecGroup );
	}

	public void setFactorySecGroup( ICFBamSecGroupFactory value ) {
		factorySecGroup = value;
	}

	public ICFBamSecGroupFormTable getTableSecGroupForm() {
		return( tableSecGroupForm );
	}

	public void setTableSecGroupForm( ICFBamSecGroupFormTable value ) {
		tableSecGroupForm = value;
	}

	public ICFBamSecGroupFormFactory getFactorySecGroupForm() {
		return( factorySecGroupForm );
	}

	public void setFactorySecGroupForm( ICFBamSecGroupFormFactory value ) {
		factorySecGroupForm = value;
	}

	public ICFBamSecGroupIncludeTable getTableSecGroupInclude() {
		return( tableSecGroupInclude );
	}

	public void setTableSecGroupInclude( ICFBamSecGroupIncludeTable value ) {
		tableSecGroupInclude = value;
	}

	public ICFBamSecGroupIncludeFactory getFactorySecGroupInclude() {
		return( factorySecGroupInclude );
	}

	public void setFactorySecGroupInclude( ICFBamSecGroupIncludeFactory value ) {
		factorySecGroupInclude = value;
	}

	public ICFBamSecGroupMemberTable getTableSecGroupMember() {
		return( tableSecGroupMember );
	}

	public void setTableSecGroupMember( ICFBamSecGroupMemberTable value ) {
		tableSecGroupMember = value;
	}

	public ICFBamSecGroupMemberFactory getFactorySecGroupMember() {
		return( factorySecGroupMember );
	}

	public void setFactorySecGroupMember( ICFBamSecGroupMemberFactory value ) {
		factorySecGroupMember = value;
	}

	public ICFBamSecSessionTable getTableSecSession() {
		return( tableSecSession );
	}

	public void setTableSecSession( ICFBamSecSessionTable value ) {
		tableSecSession = value;
	}

	public ICFBamSecSessionFactory getFactorySecSession() {
		return( factorySecSession );
	}

	public void setFactorySecSession( ICFBamSecSessionFactory value ) {
		factorySecSession = value;
	}

	public ICFBamSecUserTable getTableSecUser() {
		return( tableSecUser );
	}

	public void setTableSecUser( ICFBamSecUserTable value ) {
		tableSecUser = value;
	}

	public ICFBamSecUserFactory getFactorySecUser() {
		return( factorySecUser );
	}

	public void setFactorySecUser( ICFBamSecUserFactory value ) {
		factorySecUser = value;
	}

	public ICFBamSecurityScopeTable getTableSecurityScope() {
		return( tableSecurityScope );
	}

	public void setTableSecurityScope( ICFBamSecurityScopeTable value ) {
		tableSecurityScope = value;
	}

	public ICFBamSecurityScopeFactory getFactorySecurityScope() {
		return( factorySecurityScope );
	}

	public void setFactorySecurityScope( ICFBamSecurityScopeFactory value ) {
		factorySecurityScope = value;
	}

	public ICFBamServerListFuncTable getTableServerListFunc() {
		return( tableServerListFunc );
	}

	public void setTableServerListFunc( ICFBamServerListFuncTable value ) {
		tableServerListFunc = value;
	}

	public ICFBamServerListFuncFactory getFactoryServerListFunc() {
		return( factoryServerListFunc );
	}

	public void setFactoryServerListFunc( ICFBamServerListFuncFactory value ) {
		factoryServerListFunc = value;
	}

	public ICFBamServerMethodTable getTableServerMethod() {
		return( tableServerMethod );
	}

	public void setTableServerMethod( ICFBamServerMethodTable value ) {
		tableServerMethod = value;
	}

	public ICFBamServerMethodFactory getFactoryServerMethod() {
		return( factoryServerMethod );
	}

	public void setFactoryServerMethod( ICFBamServerMethodFactory value ) {
		factoryServerMethod = value;
	}

	public ICFBamServerObjFuncTable getTableServerObjFunc() {
		return( tableServerObjFunc );
	}

	public void setTableServerObjFunc( ICFBamServerObjFuncTable value ) {
		tableServerObjFunc = value;
	}

	public ICFBamServerObjFuncFactory getFactoryServerObjFunc() {
		return( factoryServerObjFunc );
	}

	public void setFactoryServerObjFunc( ICFBamServerObjFuncFactory value ) {
		factoryServerObjFunc = value;
	}

	public ICFBamServerProcTable getTableServerProc() {
		return( tableServerProc );
	}

	public void setTableServerProc( ICFBamServerProcTable value ) {
		tableServerProc = value;
	}

	public ICFBamServerProcFactory getFactoryServerProc() {
		return( factoryServerProc );
	}

	public void setFactoryServerProc( ICFBamServerProcFactory value ) {
		factoryServerProc = value;
	}

	public ICFBamServiceTable getTableService() {
		return( tableService );
	}

	public void setTableService( ICFBamServiceTable value ) {
		tableService = value;
	}

	public ICFBamServiceFactory getFactoryService() {
		return( factoryService );
	}

	public void setFactoryService( ICFBamServiceFactory value ) {
		factoryService = value;
	}

	public ICFBamServiceTypeTable getTableServiceType() {
		return( tableServiceType );
	}

	public void setTableServiceType( ICFBamServiceTypeTable value ) {
		tableServiceType = value;
	}

	public ICFBamServiceTypeFactory getFactoryServiceType() {
		return( factoryServiceType );
	}

	public void setFactoryServiceType( ICFBamServiceTypeFactory value ) {
		factoryServiceType = value;
	}

	public ICFBamStringColTable getTableStringCol() {
		return( tableStringCol );
	}

	public void setTableStringCol( ICFBamStringColTable value ) {
		tableStringCol = value;
	}

	public ICFBamStringColFactory getFactoryStringCol() {
		return( factoryStringCol );
	}

	public void setFactoryStringCol( ICFBamStringColFactory value ) {
		factoryStringCol = value;
	}

	public ICFBamStringDefTable getTableStringDef() {
		return( tableStringDef );
	}

	public void setTableStringDef( ICFBamStringDefTable value ) {
		tableStringDef = value;
	}

	public ICFBamStringDefFactory getFactoryStringDef() {
		return( factoryStringDef );
	}

	public void setFactoryStringDef( ICFBamStringDefFactory value ) {
		factoryStringDef = value;
	}

	public ICFBamStringTypeTable getTableStringType() {
		return( tableStringType );
	}

	public void setTableStringType( ICFBamStringTypeTable value ) {
		tableStringType = value;
	}

	public ICFBamStringTypeFactory getFactoryStringType() {
		return( factoryStringType );
	}

	public void setFactoryStringType( ICFBamStringTypeFactory value ) {
		factoryStringType = value;
	}

	public ICFBamSubProjectTable getTableSubProject() {
		return( tableSubProject );
	}

	public void setTableSubProject( ICFBamSubProjectTable value ) {
		tableSubProject = value;
	}

	public ICFBamSubProjectFactory getFactorySubProject() {
		return( factorySubProject );
	}

	public void setFactorySubProject( ICFBamSubProjectFactory value ) {
		factorySubProject = value;
	}

	public ICFBamSysClusterTable getTableSysCluster() {
		return( tableSysCluster );
	}

	public void setTableSysCluster( ICFBamSysClusterTable value ) {
		tableSysCluster = value;
	}

	public ICFBamSysClusterFactory getFactorySysCluster() {
		return( factorySysCluster );
	}

	public void setFactorySysCluster( ICFBamSysClusterFactory value ) {
		factorySysCluster = value;
	}

	public ICFBamTSecGroupTable getTableTSecGroup() {
		return( tableTSecGroup );
	}

	public void setTableTSecGroup( ICFBamTSecGroupTable value ) {
		tableTSecGroup = value;
	}

	public ICFBamTSecGroupFactory getFactoryTSecGroup() {
		return( factoryTSecGroup );
	}

	public void setFactoryTSecGroup( ICFBamTSecGroupFactory value ) {
		factoryTSecGroup = value;
	}

	public ICFBamTSecGroupIncludeTable getTableTSecGroupInclude() {
		return( tableTSecGroupInclude );
	}

	public void setTableTSecGroupInclude( ICFBamTSecGroupIncludeTable value ) {
		tableTSecGroupInclude = value;
	}

	public ICFBamTSecGroupIncludeFactory getFactoryTSecGroupInclude() {
		return( factoryTSecGroupInclude );
	}

	public void setFactoryTSecGroupInclude( ICFBamTSecGroupIncludeFactory value ) {
		factoryTSecGroupInclude = value;
	}

	public ICFBamTSecGroupMemberTable getTableTSecGroupMember() {
		return( tableTSecGroupMember );
	}

	public void setTableTSecGroupMember( ICFBamTSecGroupMemberTable value ) {
		tableTSecGroupMember = value;
	}

	public ICFBamTSecGroupMemberFactory getFactoryTSecGroupMember() {
		return( factoryTSecGroupMember );
	}

	public void setFactoryTSecGroupMember( ICFBamTSecGroupMemberFactory value ) {
		factoryTSecGroupMember = value;
	}

	public ICFBamTZDateColTable getTableTZDateCol() {
		return( tableTZDateCol );
	}

	public void setTableTZDateCol( ICFBamTZDateColTable value ) {
		tableTZDateCol = value;
	}

	public ICFBamTZDateColFactory getFactoryTZDateCol() {
		return( factoryTZDateCol );
	}

	public void setFactoryTZDateCol( ICFBamTZDateColFactory value ) {
		factoryTZDateCol = value;
	}

	public ICFBamTZDateDefTable getTableTZDateDef() {
		return( tableTZDateDef );
	}

	public void setTableTZDateDef( ICFBamTZDateDefTable value ) {
		tableTZDateDef = value;
	}

	public ICFBamTZDateDefFactory getFactoryTZDateDef() {
		return( factoryTZDateDef );
	}

	public void setFactoryTZDateDef( ICFBamTZDateDefFactory value ) {
		factoryTZDateDef = value;
	}

	public ICFBamTZDateTypeTable getTableTZDateType() {
		return( tableTZDateType );
	}

	public void setTableTZDateType( ICFBamTZDateTypeTable value ) {
		tableTZDateType = value;
	}

	public ICFBamTZDateTypeFactory getFactoryTZDateType() {
		return( factoryTZDateType );
	}

	public void setFactoryTZDateType( ICFBamTZDateTypeFactory value ) {
		factoryTZDateType = value;
	}

	public ICFBamTZTimeColTable getTableTZTimeCol() {
		return( tableTZTimeCol );
	}

	public void setTableTZTimeCol( ICFBamTZTimeColTable value ) {
		tableTZTimeCol = value;
	}

	public ICFBamTZTimeColFactory getFactoryTZTimeCol() {
		return( factoryTZTimeCol );
	}

	public void setFactoryTZTimeCol( ICFBamTZTimeColFactory value ) {
		factoryTZTimeCol = value;
	}

	public ICFBamTZTimeDefTable getTableTZTimeDef() {
		return( tableTZTimeDef );
	}

	public void setTableTZTimeDef( ICFBamTZTimeDefTable value ) {
		tableTZTimeDef = value;
	}

	public ICFBamTZTimeDefFactory getFactoryTZTimeDef() {
		return( factoryTZTimeDef );
	}

	public void setFactoryTZTimeDef( ICFBamTZTimeDefFactory value ) {
		factoryTZTimeDef = value;
	}

	public ICFBamTZTimeTypeTable getTableTZTimeType() {
		return( tableTZTimeType );
	}

	public void setTableTZTimeType( ICFBamTZTimeTypeTable value ) {
		tableTZTimeType = value;
	}

	public ICFBamTZTimeTypeFactory getFactoryTZTimeType() {
		return( factoryTZTimeType );
	}

	public void setFactoryTZTimeType( ICFBamTZTimeTypeFactory value ) {
		factoryTZTimeType = value;
	}

	public ICFBamTZTimestampColTable getTableTZTimestampCol() {
		return( tableTZTimestampCol );
	}

	public void setTableTZTimestampCol( ICFBamTZTimestampColTable value ) {
		tableTZTimestampCol = value;
	}

	public ICFBamTZTimestampColFactory getFactoryTZTimestampCol() {
		return( factoryTZTimestampCol );
	}

	public void setFactoryTZTimestampCol( ICFBamTZTimestampColFactory value ) {
		factoryTZTimestampCol = value;
	}

	public ICFBamTZTimestampDefTable getTableTZTimestampDef() {
		return( tableTZTimestampDef );
	}

	public void setTableTZTimestampDef( ICFBamTZTimestampDefTable value ) {
		tableTZTimestampDef = value;
	}

	public ICFBamTZTimestampDefFactory getFactoryTZTimestampDef() {
		return( factoryTZTimestampDef );
	}

	public void setFactoryTZTimestampDef( ICFBamTZTimestampDefFactory value ) {
		factoryTZTimestampDef = value;
	}

	public ICFBamTZTimestampTypeTable getTableTZTimestampType() {
		return( tableTZTimestampType );
	}

	public void setTableTZTimestampType( ICFBamTZTimestampTypeTable value ) {
		tableTZTimestampType = value;
	}

	public ICFBamTZTimestampTypeFactory getFactoryTZTimestampType() {
		return( factoryTZTimestampType );
	}

	public void setFactoryTZTimestampType( ICFBamTZTimestampTypeFactory value ) {
		factoryTZTimestampType = value;
	}

	public ICFBamTableTable getTableTable() {
		return( tableTable );
	}

	public void setTableTable( ICFBamTableTable value ) {
		tableTable = value;
	}

	public ICFBamTableFactory getFactoryTable() {
		return( factoryTable );
	}

	public void setFactoryTable( ICFBamTableFactory value ) {
		factoryTable = value;
	}

	public ICFBamTableColTable getTableTableCol() {
		return( tableTableCol );
	}

	public void setTableTableCol( ICFBamTableColTable value ) {
		tableTableCol = value;
	}

	public ICFBamTableColFactory getFactoryTableCol() {
		return( factoryTableCol );
	}

	public void setFactoryTableCol( ICFBamTableColFactory value ) {
		factoryTableCol = value;
	}

	public ICFBamTenantTable getTableTenant() {
		return( tableTenant );
	}

	public void setTableTenant( ICFBamTenantTable value ) {
		tableTenant = value;
	}

	public ICFBamTenantFactory getFactoryTenant() {
		return( factoryTenant );
	}

	public void setFactoryTenant( ICFBamTenantFactory value ) {
		factoryTenant = value;
	}

	public ICFBamTextColTable getTableTextCol() {
		return( tableTextCol );
	}

	public void setTableTextCol( ICFBamTextColTable value ) {
		tableTextCol = value;
	}

	public ICFBamTextColFactory getFactoryTextCol() {
		return( factoryTextCol );
	}

	public void setFactoryTextCol( ICFBamTextColFactory value ) {
		factoryTextCol = value;
	}

	public ICFBamTextDefTable getTableTextDef() {
		return( tableTextDef );
	}

	public void setTableTextDef( ICFBamTextDefTable value ) {
		tableTextDef = value;
	}

	public ICFBamTextDefFactory getFactoryTextDef() {
		return( factoryTextDef );
	}

	public void setFactoryTextDef( ICFBamTextDefFactory value ) {
		factoryTextDef = value;
	}

	public ICFBamTextTypeTable getTableTextType() {
		return( tableTextType );
	}

	public void setTableTextType( ICFBamTextTypeTable value ) {
		tableTextType = value;
	}

	public ICFBamTextTypeFactory getFactoryTextType() {
		return( factoryTextType );
	}

	public void setFactoryTextType( ICFBamTextTypeFactory value ) {
		factoryTextType = value;
	}

	public ICFBamTimeColTable getTableTimeCol() {
		return( tableTimeCol );
	}

	public void setTableTimeCol( ICFBamTimeColTable value ) {
		tableTimeCol = value;
	}

	public ICFBamTimeColFactory getFactoryTimeCol() {
		return( factoryTimeCol );
	}

	public void setFactoryTimeCol( ICFBamTimeColFactory value ) {
		factoryTimeCol = value;
	}

	public ICFBamTimeDefTable getTableTimeDef() {
		return( tableTimeDef );
	}

	public void setTableTimeDef( ICFBamTimeDefTable value ) {
		tableTimeDef = value;
	}

	public ICFBamTimeDefFactory getFactoryTimeDef() {
		return( factoryTimeDef );
	}

	public void setFactoryTimeDef( ICFBamTimeDefFactory value ) {
		factoryTimeDef = value;
	}

	public ICFBamTimeTypeTable getTableTimeType() {
		return( tableTimeType );
	}

	public void setTableTimeType( ICFBamTimeTypeTable value ) {
		tableTimeType = value;
	}

	public ICFBamTimeTypeFactory getFactoryTimeType() {
		return( factoryTimeType );
	}

	public void setFactoryTimeType( ICFBamTimeTypeFactory value ) {
		factoryTimeType = value;
	}

	public ICFBamTimestampColTable getTableTimestampCol() {
		return( tableTimestampCol );
	}

	public void setTableTimestampCol( ICFBamTimestampColTable value ) {
		tableTimestampCol = value;
	}

	public ICFBamTimestampColFactory getFactoryTimestampCol() {
		return( factoryTimestampCol );
	}

	public void setFactoryTimestampCol( ICFBamTimestampColFactory value ) {
		factoryTimestampCol = value;
	}

	public ICFBamTimestampDefTable getTableTimestampDef() {
		return( tableTimestampDef );
	}

	public void setTableTimestampDef( ICFBamTimestampDefTable value ) {
		tableTimestampDef = value;
	}

	public ICFBamTimestampDefFactory getFactoryTimestampDef() {
		return( factoryTimestampDef );
	}

	public void setFactoryTimestampDef( ICFBamTimestampDefFactory value ) {
		factoryTimestampDef = value;
	}

	public ICFBamTimestampTypeTable getTableTimestampType() {
		return( tableTimestampType );
	}

	public void setTableTimestampType( ICFBamTimestampTypeTable value ) {
		tableTimestampType = value;
	}

	public ICFBamTimestampTypeFactory getFactoryTimestampType() {
		return( factoryTimestampType );
	}

	public void setFactoryTimestampType( ICFBamTimestampTypeFactory value ) {
		factoryTimestampType = value;
	}

	public ICFBamTldTable getTableTld() {
		return( tableTld );
	}

	public void setTableTld( ICFBamTldTable value ) {
		tableTld = value;
	}

	public ICFBamTldFactory getFactoryTld() {
		return( factoryTld );
	}

	public void setFactoryTld( ICFBamTldFactory value ) {
		factoryTld = value;
	}

	public ICFBamTokenColTable getTableTokenCol() {
		return( tableTokenCol );
	}

	public void setTableTokenCol( ICFBamTokenColTable value ) {
		tableTokenCol = value;
	}

	public ICFBamTokenColFactory getFactoryTokenCol() {
		return( factoryTokenCol );
	}

	public void setFactoryTokenCol( ICFBamTokenColFactory value ) {
		factoryTokenCol = value;
	}

	public ICFBamTokenDefTable getTableTokenDef() {
		return( tableTokenDef );
	}

	public void setTableTokenDef( ICFBamTokenDefTable value ) {
		tableTokenDef = value;
	}

	public ICFBamTokenDefFactory getFactoryTokenDef() {
		return( factoryTokenDef );
	}

	public void setFactoryTokenDef( ICFBamTokenDefFactory value ) {
		factoryTokenDef = value;
	}

	public ICFBamTokenTypeTable getTableTokenType() {
		return( tableTokenType );
	}

	public void setTableTokenType( ICFBamTokenTypeTable value ) {
		tableTokenType = value;
	}

	public ICFBamTokenTypeFactory getFactoryTokenType() {
		return( factoryTokenType );
	}

	public void setFactoryTokenType( ICFBamTokenTypeFactory value ) {
		factoryTokenType = value;
	}

	public ICFBamTopDomainTable getTableTopDomain() {
		return( tableTopDomain );
	}

	public void setTableTopDomain( ICFBamTopDomainTable value ) {
		tableTopDomain = value;
	}

	public ICFBamTopDomainFactory getFactoryTopDomain() {
		return( factoryTopDomain );
	}

	public void setFactoryTopDomain( ICFBamTopDomainFactory value ) {
		factoryTopDomain = value;
	}

	public ICFBamTopProjectTable getTableTopProject() {
		return( tableTopProject );
	}

	public void setTableTopProject( ICFBamTopProjectTable value ) {
		tableTopProject = value;
	}

	public ICFBamTopProjectFactory getFactoryTopProject() {
		return( factoryTopProject );
	}

	public void setFactoryTopProject( ICFBamTopProjectFactory value ) {
		factoryTopProject = value;
	}

	public ICFBamUInt16ColTable getTableUInt16Col() {
		return( tableUInt16Col );
	}

	public void setTableUInt16Col( ICFBamUInt16ColTable value ) {
		tableUInt16Col = value;
	}

	public ICFBamUInt16ColFactory getFactoryUInt16Col() {
		return( factoryUInt16Col );
	}

	public void setFactoryUInt16Col( ICFBamUInt16ColFactory value ) {
		factoryUInt16Col = value;
	}

	public ICFBamUInt16DefTable getTableUInt16Def() {
		return( tableUInt16Def );
	}

	public void setTableUInt16Def( ICFBamUInt16DefTable value ) {
		tableUInt16Def = value;
	}

	public ICFBamUInt16DefFactory getFactoryUInt16Def() {
		return( factoryUInt16Def );
	}

	public void setFactoryUInt16Def( ICFBamUInt16DefFactory value ) {
		factoryUInt16Def = value;
	}

	public ICFBamUInt16TypeTable getTableUInt16Type() {
		return( tableUInt16Type );
	}

	public void setTableUInt16Type( ICFBamUInt16TypeTable value ) {
		tableUInt16Type = value;
	}

	public ICFBamUInt16TypeFactory getFactoryUInt16Type() {
		return( factoryUInt16Type );
	}

	public void setFactoryUInt16Type( ICFBamUInt16TypeFactory value ) {
		factoryUInt16Type = value;
	}

	public ICFBamUInt32ColTable getTableUInt32Col() {
		return( tableUInt32Col );
	}

	public void setTableUInt32Col( ICFBamUInt32ColTable value ) {
		tableUInt32Col = value;
	}

	public ICFBamUInt32ColFactory getFactoryUInt32Col() {
		return( factoryUInt32Col );
	}

	public void setFactoryUInt32Col( ICFBamUInt32ColFactory value ) {
		factoryUInt32Col = value;
	}

	public ICFBamUInt32DefTable getTableUInt32Def() {
		return( tableUInt32Def );
	}

	public void setTableUInt32Def( ICFBamUInt32DefTable value ) {
		tableUInt32Def = value;
	}

	public ICFBamUInt32DefFactory getFactoryUInt32Def() {
		return( factoryUInt32Def );
	}

	public void setFactoryUInt32Def( ICFBamUInt32DefFactory value ) {
		factoryUInt32Def = value;
	}

	public ICFBamUInt32TypeTable getTableUInt32Type() {
		return( tableUInt32Type );
	}

	public void setTableUInt32Type( ICFBamUInt32TypeTable value ) {
		tableUInt32Type = value;
	}

	public ICFBamUInt32TypeFactory getFactoryUInt32Type() {
		return( factoryUInt32Type );
	}

	public void setFactoryUInt32Type( ICFBamUInt32TypeFactory value ) {
		factoryUInt32Type = value;
	}

	public ICFBamUInt64ColTable getTableUInt64Col() {
		return( tableUInt64Col );
	}

	public void setTableUInt64Col( ICFBamUInt64ColTable value ) {
		tableUInt64Col = value;
	}

	public ICFBamUInt64ColFactory getFactoryUInt64Col() {
		return( factoryUInt64Col );
	}

	public void setFactoryUInt64Col( ICFBamUInt64ColFactory value ) {
		factoryUInt64Col = value;
	}

	public ICFBamUInt64DefTable getTableUInt64Def() {
		return( tableUInt64Def );
	}

	public void setTableUInt64Def( ICFBamUInt64DefTable value ) {
		tableUInt64Def = value;
	}

	public ICFBamUInt64DefFactory getFactoryUInt64Def() {
		return( factoryUInt64Def );
	}

	public void setFactoryUInt64Def( ICFBamUInt64DefFactory value ) {
		factoryUInt64Def = value;
	}

	public ICFBamUInt64TypeTable getTableUInt64Type() {
		return( tableUInt64Type );
	}

	public void setTableUInt64Type( ICFBamUInt64TypeTable value ) {
		tableUInt64Type = value;
	}

	public ICFBamUInt64TypeFactory getFactoryUInt64Type() {
		return( factoryUInt64Type );
	}

	public void setFactoryUInt64Type( ICFBamUInt64TypeFactory value ) {
		factoryUInt64Type = value;
	}

	public ICFBamURLProtocolTable getTableURLProtocol() {
		return( tableURLProtocol );
	}

	public void setTableURLProtocol( ICFBamURLProtocolTable value ) {
		tableURLProtocol = value;
	}

	public ICFBamURLProtocolFactory getFactoryURLProtocol() {
		return( factoryURLProtocol );
	}

	public void setFactoryURLProtocol( ICFBamURLProtocolFactory value ) {
		factoryURLProtocol = value;
	}

	public ICFBamUuidColTable getTableUuidCol() {
		return( tableUuidCol );
	}

	public void setTableUuidCol( ICFBamUuidColTable value ) {
		tableUuidCol = value;
	}

	public ICFBamUuidColFactory getFactoryUuidCol() {
		return( factoryUuidCol );
	}

	public void setFactoryUuidCol( ICFBamUuidColFactory value ) {
		factoryUuidCol = value;
	}

	public ICFBamUuidDefTable getTableUuidDef() {
		return( tableUuidDef );
	}

	public void setTableUuidDef( ICFBamUuidDefTable value ) {
		tableUuidDef = value;
	}

	public ICFBamUuidDefFactory getFactoryUuidDef() {
		return( factoryUuidDef );
	}

	public void setFactoryUuidDef( ICFBamUuidDefFactory value ) {
		factoryUuidDef = value;
	}

	public ICFBamUuidGenTable getTableUuidGen() {
		return( tableUuidGen );
	}

	public void setTableUuidGen( ICFBamUuidGenTable value ) {
		tableUuidGen = value;
	}

	public ICFBamUuidGenFactory getFactoryUuidGen() {
		return( factoryUuidGen );
	}

	public void setFactoryUuidGen( ICFBamUuidGenFactory value ) {
		factoryUuidGen = value;
	}

	public ICFBamUuidTypeTable getTableUuidType() {
		return( tableUuidType );
	}

	public void setTableUuidType( ICFBamUuidTypeTable value ) {
		tableUuidType = value;
	}

	public ICFBamUuidTypeFactory getFactoryUuidType() {
		return( factoryUuidType );
	}

	public void setFactoryUuidType( ICFBamUuidTypeFactory value ) {
		factoryUuidType = value;
	}

	public ICFBamValueTable getTableValue() {
		return( tableValue );
	}

	public void setTableValue( ICFBamValueTable value ) {
		tableValue = value;
	}

	public ICFBamValueFactory getFactoryValue() {
		return( factoryValue );
	}

	public void setFactoryValue( ICFBamValueFactory value ) {
		factoryValue = value;
	}

	public ICFBamVersionTable getTableVersion() {
		return( tableVersion );
	}

	public void setTableVersion( ICFBamVersionTable value ) {
		tableVersion = value;
	}

	public ICFBamVersionFactory getFactoryVersion() {
		return( factoryVersion );
	}

	public void setFactoryVersion( ICFBamVersionFactory value ) {
		factoryVersion = value;
	}

	public boolean isTransactionOpen() {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "isTransactionOpen" );
	}

	public boolean beginTransaction() {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "beginTransaction" );
	}

	public void commit() {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "commit" );
	}

	public void rollback() {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "rollback" );
	}

	public ICFBamTablePerms getTablePerms() {
		return( tablePerms );
	}

	public void setTablePerms( ICFBamTablePerms value ) {
		tablePerms = value;
	}

	public static String xmlEncodeString( String val ) {
		StringBuffer buff = new StringBuffer();
		int len = val.length();
		for( int idx = 0; idx < len; idx ++ ) {
			char c = val.charAt( idx );
			switch( c ) {
				case '&':
					buff.append( "&amp;" );
					break;
				case '<':
					buff.append( "&lt;" );
					break;
				case '>':
					buff.append( "&gt;" );
					break;
				case '"':
					buff.append( "&quot;" );
					break;
				case '\'':
					buff.append( "&apos;" );
					break;
				default:
					buff.append( c );
					break;
			}
		}
		return( buff.toString() );
	}

	/**
	 *	Release any prepared statements bound to this database instance, such
	 *	that the value of schemaDbName has to be re-evaluated for all future
	 *	invocations.
	 */
	public void releasePreparedStatements() {
	}

	/**
	 *	When you first connect to a database, you can opt to specify a database
	 *	schema name to be used by the session.  The implementation code must always
	 *	be dynamically based on the invocation of <tt>String getDbSchemaName()</tt>
	 *	at runtime.
	 *	<p>
	 *	The initial value is defined by the implementing schema model which has inherited
	 *	the expression of the current schema model being expanded.  That is, it is specified
	 *	in the DbSchemaName attribute of a SchemaDef instance.
	 */
	public String getDbSchemaName() {
		return( schemaDbName );
	}

	public String getLowerDbSchemaName() {
		return( lowerDbSchemaName );
	}

	/**
	 *	The database is expected to override this implementation and invoke the
	 *	<tt>super.setDbSchemaName( String argDbSchemaName )</tt> early
	 *	on in the implementation of the custom body.  You should let the exceptions
	 *	which can be thrown by this implementation pass unimpeded.
	 *	<pg>
	 *	When you set the database schema name, the database-specific implementation
	 *	of this method does a "commit; use database"-type sequence to change
	 *	to the target database.  This should be specified globally for all
	 *	database connections in a given cluster, so that all of
	 *	the application implementation clients are using the same database instance
	 *	regardless of what's been provided by the custom client implementation,
	 *	be it as a Java application or a web interface written using JEE.
	 */
	public void setDbSchemaName( String argDbSchemaName ) {
		final String S_ProcName = "setDbSchemaName";
		if( ( argDbSchemaName == null ) || ( argDbSchemaName.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argDbSchemaName" );
		}
		schemaDbName = argDbSchemaName;
		lowerDbSchemaName = schemaDbName.toLowerCase();
	}
}
