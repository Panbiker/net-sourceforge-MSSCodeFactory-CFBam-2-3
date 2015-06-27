// Description: Java 7 XMsg Client DbIO implementation for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgClient;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.*;
import java.math.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.*;
import java.util.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.naming.*;
import javax.sql.*;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Tip.*;

import org.apache.commons.codec.binary.Base64;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsg.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgRspnHandler.*;

public class CFBamXMsgClientSchema
	extends CFBamSchema
{
	protected CFTipClientHandler cftipClientHandler = null;
	protected boolean transactionOpen = false;

	public CFBamXMsgClientSchema() {
		super();
		getCFTipClientHandler();
		getResponseHandler();
		tableAccessFrequency = new CFBamXMsgClientAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamXMsgClientAccessSecurityTable( this );
		tableAtom = new CFBamXMsgClientAtomTable( this );
		tableAuditAction = new CFBamXMsgClientAuditActionTable( this );
		tableBlobCol = new CFBamXMsgClientBlobColTable( this );
		tableBlobDef = new CFBamXMsgClientBlobDefTable( this );
		tableBlobType = new CFBamXMsgClientBlobTypeTable( this );
		tableBoolCol = new CFBamXMsgClientBoolColTable( this );
		tableBoolDef = new CFBamXMsgClientBoolDefTable( this );
		tableBoolType = new CFBamXMsgClientBoolTypeTable( this );
		tableChain = new CFBamXMsgClientChainTable( this );
		tableClearDep = new CFBamXMsgClientClearDepTable( this );
		tableClearSubDep1 = new CFBamXMsgClientClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamXMsgClientClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamXMsgClientClearSubDep3Table( this );
		tableClearTopDep = new CFBamXMsgClientClearTopDepTable( this );
		tableCluster = new CFBamXMsgClientClusterTable( this );
		tableDataScope = new CFBamXMsgClientDataScopeTable( this );
		tableDateCol = new CFBamXMsgClientDateColTable( this );
		tableDateDef = new CFBamXMsgClientDateDefTable( this );
		tableDateType = new CFBamXMsgClientDateTypeTable( this );
		tableDelDep = new CFBamXMsgClientDelDepTable( this );
		tableDelSubDep1 = new CFBamXMsgClientDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamXMsgClientDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamXMsgClientDelSubDep3Table( this );
		tableDelTopDep = new CFBamXMsgClientDelTopDepTable( this );
		tableDomain = new CFBamXMsgClientDomainTable( this );
		tableDomainBase = new CFBamXMsgClientDomainBaseTable( this );
		tableDoubleCol = new CFBamXMsgClientDoubleColTable( this );
		tableDoubleDef = new CFBamXMsgClientDoubleDefTable( this );
		tableDoubleType = new CFBamXMsgClientDoubleTypeTable( this );
		tableEnumCol = new CFBamXMsgClientEnumColTable( this );
		tableEnumDef = new CFBamXMsgClientEnumDefTable( this );
		tableEnumTag = new CFBamXMsgClientEnumTagTable( this );
		tableEnumType = new CFBamXMsgClientEnumTypeTable( this );
		tableFloatCol = new CFBamXMsgClientFloatColTable( this );
		tableFloatDef = new CFBamXMsgClientFloatDefTable( this );
		tableFloatType = new CFBamXMsgClientFloatTypeTable( this );
		tableHostNode = new CFBamXMsgClientHostNodeTable( this );
		tableISOCountry = new CFBamXMsgClientISOCountryTable( this );
		tableISOCountryCurrency = new CFBamXMsgClientISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamXMsgClientISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamXMsgClientISOCurrencyTable( this );
		tableISOLanguage = new CFBamXMsgClientISOLanguageTable( this );
		tableISOTimezone = new CFBamXMsgClientISOTimezoneTable( this );
		tableId16Gen = new CFBamXMsgClientId16GenTable( this );
		tableId32Gen = new CFBamXMsgClientId32GenTable( this );
		tableId64Gen = new CFBamXMsgClientId64GenTable( this );
		tableIndex = new CFBamXMsgClientIndexTable( this );
		tableIndexCol = new CFBamXMsgClientIndexColTable( this );
		tableInt16Col = new CFBamXMsgClientInt16ColTable( this );
		tableInt16Def = new CFBamXMsgClientInt16DefTable( this );
		tableInt16Type = new CFBamXMsgClientInt16TypeTable( this );
		tableInt32Col = new CFBamXMsgClientInt32ColTable( this );
		tableInt32Def = new CFBamXMsgClientInt32DefTable( this );
		tableInt32Type = new CFBamXMsgClientInt32TypeTable( this );
		tableInt64Col = new CFBamXMsgClientInt64ColTable( this );
		tableInt64Def = new CFBamXMsgClientInt64DefTable( this );
		tableInt64Type = new CFBamXMsgClientInt64TypeTable( this );
		tableLicense = new CFBamXMsgClientLicenseTable( this );
		tableLoaderBehaviour = new CFBamXMsgClientLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamXMsgClientMajorVersionTable( this );
		tableMimeType = new CFBamXMsgClientMimeTypeTable( this );
		tableMinorVersion = new CFBamXMsgClientMinorVersionTable( this );
		tableNmTokenCol = new CFBamXMsgClientNmTokenColTable( this );
		tableNmTokenDef = new CFBamXMsgClientNmTokenDefTable( this );
		tableNmTokenType = new CFBamXMsgClientNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamXMsgClientNmTokensColTable( this );
		tableNmTokensDef = new CFBamXMsgClientNmTokensDefTable( this );
		tableNmTokensType = new CFBamXMsgClientNmTokensTypeTable( this );
		tableNumberCol = new CFBamXMsgClientNumberColTable( this );
		tableNumberDef = new CFBamXMsgClientNumberDefTable( this );
		tableNumberType = new CFBamXMsgClientNumberTypeTable( this );
		tableParam = new CFBamXMsgClientParamTable( this );
		tablePopDep = new CFBamXMsgClientPopDepTable( this );
		tablePopSubDep1 = new CFBamXMsgClientPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamXMsgClientPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamXMsgClientPopSubDep3Table( this );
		tablePopTopDep = new CFBamXMsgClientPopTopDepTable( this );
		tableProjectBase = new CFBamXMsgClientProjectBaseTable( this );
		tableRealProject = new CFBamXMsgClientRealProjectTable( this );
		tableRelation = new CFBamXMsgClientRelationTable( this );
		tableRelationCol = new CFBamXMsgClientRelationColTable( this );
		tableRelationType = new CFBamXMsgClientRelationTypeTable( this );
		tableSchemaDef = new CFBamXMsgClientSchemaDefTable( this );
		tableSchemaRef = new CFBamXMsgClientSchemaRefTable( this );
		tableScope = new CFBamXMsgClientScopeTable( this );
		tableSecApp = new CFBamXMsgClientSecAppTable( this );
		tableSecDevice = new CFBamXMsgClientSecDeviceTable( this );
		tableSecForm = new CFBamXMsgClientSecFormTable( this );
		tableSecGroup = new CFBamXMsgClientSecGroupTable( this );
		tableSecGroupForm = new CFBamXMsgClientSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamXMsgClientSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamXMsgClientSecGroupMemberTable( this );
		tableSecSession = new CFBamXMsgClientSecSessionTable( this );
		tableSecUser = new CFBamXMsgClientSecUserTable( this );
		tableSecurityScope = new CFBamXMsgClientSecurityScopeTable( this );
		tableServerListFunc = new CFBamXMsgClientServerListFuncTable( this );
		tableServerMethod = new CFBamXMsgClientServerMethodTable( this );
		tableServerObjFunc = new CFBamXMsgClientServerObjFuncTable( this );
		tableServerProc = new CFBamXMsgClientServerProcTable( this );
		tableService = new CFBamXMsgClientServiceTable( this );
		tableServiceType = new CFBamXMsgClientServiceTypeTable( this );
		tableStringCol = new CFBamXMsgClientStringColTable( this );
		tableStringDef = new CFBamXMsgClientStringDefTable( this );
		tableStringType = new CFBamXMsgClientStringTypeTable( this );
		tableSubProject = new CFBamXMsgClientSubProjectTable( this );
		tableSysCluster = new CFBamXMsgClientSysClusterTable( this );
		tableTSecGroup = new CFBamXMsgClientTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamXMsgClientTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamXMsgClientTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamXMsgClientTZDateColTable( this );
		tableTZDateDef = new CFBamXMsgClientTZDateDefTable( this );
		tableTZDateType = new CFBamXMsgClientTZDateTypeTable( this );
		tableTZTimeCol = new CFBamXMsgClientTZTimeColTable( this );
		tableTZTimeDef = new CFBamXMsgClientTZTimeDefTable( this );
		tableTZTimeType = new CFBamXMsgClientTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamXMsgClientTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamXMsgClientTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamXMsgClientTZTimestampTypeTable( this );
		tableTable = new CFBamXMsgClientTableTable( this );
		tableTableCol = new CFBamXMsgClientTableColTable( this );
		tableTenant = new CFBamXMsgClientTenantTable( this );
		tableTextCol = new CFBamXMsgClientTextColTable( this );
		tableTextDef = new CFBamXMsgClientTextDefTable( this );
		tableTextType = new CFBamXMsgClientTextTypeTable( this );
		tableTimeCol = new CFBamXMsgClientTimeColTable( this );
		tableTimeDef = new CFBamXMsgClientTimeDefTable( this );
		tableTimeType = new CFBamXMsgClientTimeTypeTable( this );
		tableTimestampCol = new CFBamXMsgClientTimestampColTable( this );
		tableTimestampDef = new CFBamXMsgClientTimestampDefTable( this );
		tableTimestampType = new CFBamXMsgClientTimestampTypeTable( this );
		tableTld = new CFBamXMsgClientTldTable( this );
		tableTokenCol = new CFBamXMsgClientTokenColTable( this );
		tableTokenDef = new CFBamXMsgClientTokenDefTable( this );
		tableTokenType = new CFBamXMsgClientTokenTypeTable( this );
		tableTopDomain = new CFBamXMsgClientTopDomainTable( this );
		tableTopProject = new CFBamXMsgClientTopProjectTable( this );
		tableUInt16Col = new CFBamXMsgClientUInt16ColTable( this );
		tableUInt16Def = new CFBamXMsgClientUInt16DefTable( this );
		tableUInt16Type = new CFBamXMsgClientUInt16TypeTable( this );
		tableUInt32Col = new CFBamXMsgClientUInt32ColTable( this );
		tableUInt32Def = new CFBamXMsgClientUInt32DefTable( this );
		tableUInt32Type = new CFBamXMsgClientUInt32TypeTable( this );
		tableUInt64Col = new CFBamXMsgClientUInt64ColTable( this );
		tableUInt64Def = new CFBamXMsgClientUInt64DefTable( this );
		tableUInt64Type = new CFBamXMsgClientUInt64TypeTable( this );
		tableURLProtocol = new CFBamXMsgClientURLProtocolTable( this );
		tableUuidCol = new CFBamXMsgClientUuidColTable( this );
		tableUuidDef = new CFBamXMsgClientUuidDefTable( this );
		tableUuidGen = new CFBamXMsgClientUuidGenTable( this );
		tableUuidType = new CFBamXMsgClientUuidTypeTable( this );
		tableValue = new CFBamXMsgClientValueTable( this );
		tableVersion = new CFBamXMsgClientVersionTable( this );
		setResponseHandlerSchemaObj( null );
	}

	public CFBamXMsgClientSchema( CFBamSchemaObj handlerSchema ) {
		super();
		getCFTipClientHandler();
		getResponseHandler();
		tableAccessFrequency = new CFBamXMsgClientAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamXMsgClientAccessSecurityTable( this );
		tableAtom = new CFBamXMsgClientAtomTable( this );
		tableAuditAction = new CFBamXMsgClientAuditActionTable( this );
		tableBlobCol = new CFBamXMsgClientBlobColTable( this );
		tableBlobDef = new CFBamXMsgClientBlobDefTable( this );
		tableBlobType = new CFBamXMsgClientBlobTypeTable( this );
		tableBoolCol = new CFBamXMsgClientBoolColTable( this );
		tableBoolDef = new CFBamXMsgClientBoolDefTable( this );
		tableBoolType = new CFBamXMsgClientBoolTypeTable( this );
		tableChain = new CFBamXMsgClientChainTable( this );
		tableClearDep = new CFBamXMsgClientClearDepTable( this );
		tableClearSubDep1 = new CFBamXMsgClientClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamXMsgClientClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamXMsgClientClearSubDep3Table( this );
		tableClearTopDep = new CFBamXMsgClientClearTopDepTable( this );
		tableCluster = new CFBamXMsgClientClusterTable( this );
		tableDataScope = new CFBamXMsgClientDataScopeTable( this );
		tableDateCol = new CFBamXMsgClientDateColTable( this );
		tableDateDef = new CFBamXMsgClientDateDefTable( this );
		tableDateType = new CFBamXMsgClientDateTypeTable( this );
		tableDelDep = new CFBamXMsgClientDelDepTable( this );
		tableDelSubDep1 = new CFBamXMsgClientDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamXMsgClientDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamXMsgClientDelSubDep3Table( this );
		tableDelTopDep = new CFBamXMsgClientDelTopDepTable( this );
		tableDomain = new CFBamXMsgClientDomainTable( this );
		tableDomainBase = new CFBamXMsgClientDomainBaseTable( this );
		tableDoubleCol = new CFBamXMsgClientDoubleColTable( this );
		tableDoubleDef = new CFBamXMsgClientDoubleDefTable( this );
		tableDoubleType = new CFBamXMsgClientDoubleTypeTable( this );
		tableEnumCol = new CFBamXMsgClientEnumColTable( this );
		tableEnumDef = new CFBamXMsgClientEnumDefTable( this );
		tableEnumTag = new CFBamXMsgClientEnumTagTable( this );
		tableEnumType = new CFBamXMsgClientEnumTypeTable( this );
		tableFloatCol = new CFBamXMsgClientFloatColTable( this );
		tableFloatDef = new CFBamXMsgClientFloatDefTable( this );
		tableFloatType = new CFBamXMsgClientFloatTypeTable( this );
		tableHostNode = new CFBamXMsgClientHostNodeTable( this );
		tableISOCountry = new CFBamXMsgClientISOCountryTable( this );
		tableISOCountryCurrency = new CFBamXMsgClientISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamXMsgClientISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamXMsgClientISOCurrencyTable( this );
		tableISOLanguage = new CFBamXMsgClientISOLanguageTable( this );
		tableISOTimezone = new CFBamXMsgClientISOTimezoneTable( this );
		tableId16Gen = new CFBamXMsgClientId16GenTable( this );
		tableId32Gen = new CFBamXMsgClientId32GenTable( this );
		tableId64Gen = new CFBamXMsgClientId64GenTable( this );
		tableIndex = new CFBamXMsgClientIndexTable( this );
		tableIndexCol = new CFBamXMsgClientIndexColTable( this );
		tableInt16Col = new CFBamXMsgClientInt16ColTable( this );
		tableInt16Def = new CFBamXMsgClientInt16DefTable( this );
		tableInt16Type = new CFBamXMsgClientInt16TypeTable( this );
		tableInt32Col = new CFBamXMsgClientInt32ColTable( this );
		tableInt32Def = new CFBamXMsgClientInt32DefTable( this );
		tableInt32Type = new CFBamXMsgClientInt32TypeTable( this );
		tableInt64Col = new CFBamXMsgClientInt64ColTable( this );
		tableInt64Def = new CFBamXMsgClientInt64DefTable( this );
		tableInt64Type = new CFBamXMsgClientInt64TypeTable( this );
		tableLicense = new CFBamXMsgClientLicenseTable( this );
		tableLoaderBehaviour = new CFBamXMsgClientLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamXMsgClientMajorVersionTable( this );
		tableMimeType = new CFBamXMsgClientMimeTypeTable( this );
		tableMinorVersion = new CFBamXMsgClientMinorVersionTable( this );
		tableNmTokenCol = new CFBamXMsgClientNmTokenColTable( this );
		tableNmTokenDef = new CFBamXMsgClientNmTokenDefTable( this );
		tableNmTokenType = new CFBamXMsgClientNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamXMsgClientNmTokensColTable( this );
		tableNmTokensDef = new CFBamXMsgClientNmTokensDefTable( this );
		tableNmTokensType = new CFBamXMsgClientNmTokensTypeTable( this );
		tableNumberCol = new CFBamXMsgClientNumberColTable( this );
		tableNumberDef = new CFBamXMsgClientNumberDefTable( this );
		tableNumberType = new CFBamXMsgClientNumberTypeTable( this );
		tableParam = new CFBamXMsgClientParamTable( this );
		tablePopDep = new CFBamXMsgClientPopDepTable( this );
		tablePopSubDep1 = new CFBamXMsgClientPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamXMsgClientPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamXMsgClientPopSubDep3Table( this );
		tablePopTopDep = new CFBamXMsgClientPopTopDepTable( this );
		tableProjectBase = new CFBamXMsgClientProjectBaseTable( this );
		tableRealProject = new CFBamXMsgClientRealProjectTable( this );
		tableRelation = new CFBamXMsgClientRelationTable( this );
		tableRelationCol = new CFBamXMsgClientRelationColTable( this );
		tableRelationType = new CFBamXMsgClientRelationTypeTable( this );
		tableSchemaDef = new CFBamXMsgClientSchemaDefTable( this );
		tableSchemaRef = new CFBamXMsgClientSchemaRefTable( this );
		tableScope = new CFBamXMsgClientScopeTable( this );
		tableSecApp = new CFBamXMsgClientSecAppTable( this );
		tableSecDevice = new CFBamXMsgClientSecDeviceTable( this );
		tableSecForm = new CFBamXMsgClientSecFormTable( this );
		tableSecGroup = new CFBamXMsgClientSecGroupTable( this );
		tableSecGroupForm = new CFBamXMsgClientSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamXMsgClientSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamXMsgClientSecGroupMemberTable( this );
		tableSecSession = new CFBamXMsgClientSecSessionTable( this );
		tableSecUser = new CFBamXMsgClientSecUserTable( this );
		tableSecurityScope = new CFBamXMsgClientSecurityScopeTable( this );
		tableServerListFunc = new CFBamXMsgClientServerListFuncTable( this );
		tableServerMethod = new CFBamXMsgClientServerMethodTable( this );
		tableServerObjFunc = new CFBamXMsgClientServerObjFuncTable( this );
		tableServerProc = new CFBamXMsgClientServerProcTable( this );
		tableService = new CFBamXMsgClientServiceTable( this );
		tableServiceType = new CFBamXMsgClientServiceTypeTable( this );
		tableStringCol = new CFBamXMsgClientStringColTable( this );
		tableStringDef = new CFBamXMsgClientStringDefTable( this );
		tableStringType = new CFBamXMsgClientStringTypeTable( this );
		tableSubProject = new CFBamXMsgClientSubProjectTable( this );
		tableSysCluster = new CFBamXMsgClientSysClusterTable( this );
		tableTSecGroup = new CFBamXMsgClientTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamXMsgClientTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamXMsgClientTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamXMsgClientTZDateColTable( this );
		tableTZDateDef = new CFBamXMsgClientTZDateDefTable( this );
		tableTZDateType = new CFBamXMsgClientTZDateTypeTable( this );
		tableTZTimeCol = new CFBamXMsgClientTZTimeColTable( this );
		tableTZTimeDef = new CFBamXMsgClientTZTimeDefTable( this );
		tableTZTimeType = new CFBamXMsgClientTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamXMsgClientTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamXMsgClientTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamXMsgClientTZTimestampTypeTable( this );
		tableTable = new CFBamXMsgClientTableTable( this );
		tableTableCol = new CFBamXMsgClientTableColTable( this );
		tableTenant = new CFBamXMsgClientTenantTable( this );
		tableTextCol = new CFBamXMsgClientTextColTable( this );
		tableTextDef = new CFBamXMsgClientTextDefTable( this );
		tableTextType = new CFBamXMsgClientTextTypeTable( this );
		tableTimeCol = new CFBamXMsgClientTimeColTable( this );
		tableTimeDef = new CFBamXMsgClientTimeDefTable( this );
		tableTimeType = new CFBamXMsgClientTimeTypeTable( this );
		tableTimestampCol = new CFBamXMsgClientTimestampColTable( this );
		tableTimestampDef = new CFBamXMsgClientTimestampDefTable( this );
		tableTimestampType = new CFBamXMsgClientTimestampTypeTable( this );
		tableTld = new CFBamXMsgClientTldTable( this );
		tableTokenCol = new CFBamXMsgClientTokenColTable( this );
		tableTokenDef = new CFBamXMsgClientTokenDefTable( this );
		tableTokenType = new CFBamXMsgClientTokenTypeTable( this );
		tableTopDomain = new CFBamXMsgClientTopDomainTable( this );
		tableTopProject = new CFBamXMsgClientTopProjectTable( this );
		tableUInt16Col = new CFBamXMsgClientUInt16ColTable( this );
		tableUInt16Def = new CFBamXMsgClientUInt16DefTable( this );
		tableUInt16Type = new CFBamXMsgClientUInt16TypeTable( this );
		tableUInt32Col = new CFBamXMsgClientUInt32ColTable( this );
		tableUInt32Def = new CFBamXMsgClientUInt32DefTable( this );
		tableUInt32Type = new CFBamXMsgClientUInt32TypeTable( this );
		tableUInt64Col = new CFBamXMsgClientUInt64ColTable( this );
		tableUInt64Def = new CFBamXMsgClientUInt64DefTable( this );
		tableUInt64Type = new CFBamXMsgClientUInt64TypeTable( this );
		tableURLProtocol = new CFBamXMsgClientURLProtocolTable( this );
		tableUuidCol = new CFBamXMsgClientUuidColTable( this );
		tableUuidDef = new CFBamXMsgClientUuidDefTable( this );
		tableUuidGen = new CFBamXMsgClientUuidGenTable( this );
		tableUuidType = new CFBamXMsgClientUuidTypeTable( this );
		tableValue = new CFBamXMsgClientValueTable( this );
		tableVersion = new CFBamXMsgClientVersionTable( this );
		setResponseHandlerSchemaObj( handlerSchema );
	}

	public CFBamXMsgClientSchema( CFBamSchemaObj handlerSchema, CFBamConfigurationFile conf ) {
		super( conf );
		getCFTipClientHandler();
		getResponseHandler();
		tableAccessFrequency = new CFBamXMsgClientAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamXMsgClientAccessSecurityTable( this );
		tableAtom = new CFBamXMsgClientAtomTable( this );
		tableAuditAction = new CFBamXMsgClientAuditActionTable( this );
		tableBlobCol = new CFBamXMsgClientBlobColTable( this );
		tableBlobDef = new CFBamXMsgClientBlobDefTable( this );
		tableBlobType = new CFBamXMsgClientBlobTypeTable( this );
		tableBoolCol = new CFBamXMsgClientBoolColTable( this );
		tableBoolDef = new CFBamXMsgClientBoolDefTable( this );
		tableBoolType = new CFBamXMsgClientBoolTypeTable( this );
		tableChain = new CFBamXMsgClientChainTable( this );
		tableClearDep = new CFBamXMsgClientClearDepTable( this );
		tableClearSubDep1 = new CFBamXMsgClientClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamXMsgClientClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamXMsgClientClearSubDep3Table( this );
		tableClearTopDep = new CFBamXMsgClientClearTopDepTable( this );
		tableCluster = new CFBamXMsgClientClusterTable( this );
		tableDataScope = new CFBamXMsgClientDataScopeTable( this );
		tableDateCol = new CFBamXMsgClientDateColTable( this );
		tableDateDef = new CFBamXMsgClientDateDefTable( this );
		tableDateType = new CFBamXMsgClientDateTypeTable( this );
		tableDelDep = new CFBamXMsgClientDelDepTable( this );
		tableDelSubDep1 = new CFBamXMsgClientDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamXMsgClientDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamXMsgClientDelSubDep3Table( this );
		tableDelTopDep = new CFBamXMsgClientDelTopDepTable( this );
		tableDomain = new CFBamXMsgClientDomainTable( this );
		tableDomainBase = new CFBamXMsgClientDomainBaseTable( this );
		tableDoubleCol = new CFBamXMsgClientDoubleColTable( this );
		tableDoubleDef = new CFBamXMsgClientDoubleDefTable( this );
		tableDoubleType = new CFBamXMsgClientDoubleTypeTable( this );
		tableEnumCol = new CFBamXMsgClientEnumColTable( this );
		tableEnumDef = new CFBamXMsgClientEnumDefTable( this );
		tableEnumTag = new CFBamXMsgClientEnumTagTable( this );
		tableEnumType = new CFBamXMsgClientEnumTypeTable( this );
		tableFloatCol = new CFBamXMsgClientFloatColTable( this );
		tableFloatDef = new CFBamXMsgClientFloatDefTable( this );
		tableFloatType = new CFBamXMsgClientFloatTypeTable( this );
		tableHostNode = new CFBamXMsgClientHostNodeTable( this );
		tableISOCountry = new CFBamXMsgClientISOCountryTable( this );
		tableISOCountryCurrency = new CFBamXMsgClientISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamXMsgClientISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamXMsgClientISOCurrencyTable( this );
		tableISOLanguage = new CFBamXMsgClientISOLanguageTable( this );
		tableISOTimezone = new CFBamXMsgClientISOTimezoneTable( this );
		tableId16Gen = new CFBamXMsgClientId16GenTable( this );
		tableId32Gen = new CFBamXMsgClientId32GenTable( this );
		tableId64Gen = new CFBamXMsgClientId64GenTable( this );
		tableIndex = new CFBamXMsgClientIndexTable( this );
		tableIndexCol = new CFBamXMsgClientIndexColTable( this );
		tableInt16Col = new CFBamXMsgClientInt16ColTable( this );
		tableInt16Def = new CFBamXMsgClientInt16DefTable( this );
		tableInt16Type = new CFBamXMsgClientInt16TypeTable( this );
		tableInt32Col = new CFBamXMsgClientInt32ColTable( this );
		tableInt32Def = new CFBamXMsgClientInt32DefTable( this );
		tableInt32Type = new CFBamXMsgClientInt32TypeTable( this );
		tableInt64Col = new CFBamXMsgClientInt64ColTable( this );
		tableInt64Def = new CFBamXMsgClientInt64DefTable( this );
		tableInt64Type = new CFBamXMsgClientInt64TypeTable( this );
		tableLicense = new CFBamXMsgClientLicenseTable( this );
		tableLoaderBehaviour = new CFBamXMsgClientLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamXMsgClientMajorVersionTable( this );
		tableMimeType = new CFBamXMsgClientMimeTypeTable( this );
		tableMinorVersion = new CFBamXMsgClientMinorVersionTable( this );
		tableNmTokenCol = new CFBamXMsgClientNmTokenColTable( this );
		tableNmTokenDef = new CFBamXMsgClientNmTokenDefTable( this );
		tableNmTokenType = new CFBamXMsgClientNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamXMsgClientNmTokensColTable( this );
		tableNmTokensDef = new CFBamXMsgClientNmTokensDefTable( this );
		tableNmTokensType = new CFBamXMsgClientNmTokensTypeTable( this );
		tableNumberCol = new CFBamXMsgClientNumberColTable( this );
		tableNumberDef = new CFBamXMsgClientNumberDefTable( this );
		tableNumberType = new CFBamXMsgClientNumberTypeTable( this );
		tableParam = new CFBamXMsgClientParamTable( this );
		tablePopDep = new CFBamXMsgClientPopDepTable( this );
		tablePopSubDep1 = new CFBamXMsgClientPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamXMsgClientPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamXMsgClientPopSubDep3Table( this );
		tablePopTopDep = new CFBamXMsgClientPopTopDepTable( this );
		tableProjectBase = new CFBamXMsgClientProjectBaseTable( this );
		tableRealProject = new CFBamXMsgClientRealProjectTable( this );
		tableRelation = new CFBamXMsgClientRelationTable( this );
		tableRelationCol = new CFBamXMsgClientRelationColTable( this );
		tableRelationType = new CFBamXMsgClientRelationTypeTable( this );
		tableSchemaDef = new CFBamXMsgClientSchemaDefTable( this );
		tableSchemaRef = new CFBamXMsgClientSchemaRefTable( this );
		tableScope = new CFBamXMsgClientScopeTable( this );
		tableSecApp = new CFBamXMsgClientSecAppTable( this );
		tableSecDevice = new CFBamXMsgClientSecDeviceTable( this );
		tableSecForm = new CFBamXMsgClientSecFormTable( this );
		tableSecGroup = new CFBamXMsgClientSecGroupTable( this );
		tableSecGroupForm = new CFBamXMsgClientSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamXMsgClientSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamXMsgClientSecGroupMemberTable( this );
		tableSecSession = new CFBamXMsgClientSecSessionTable( this );
		tableSecUser = new CFBamXMsgClientSecUserTable( this );
		tableSecurityScope = new CFBamXMsgClientSecurityScopeTable( this );
		tableServerListFunc = new CFBamXMsgClientServerListFuncTable( this );
		tableServerMethod = new CFBamXMsgClientServerMethodTable( this );
		tableServerObjFunc = new CFBamXMsgClientServerObjFuncTable( this );
		tableServerProc = new CFBamXMsgClientServerProcTable( this );
		tableService = new CFBamXMsgClientServiceTable( this );
		tableServiceType = new CFBamXMsgClientServiceTypeTable( this );
		tableStringCol = new CFBamXMsgClientStringColTable( this );
		tableStringDef = new CFBamXMsgClientStringDefTable( this );
		tableStringType = new CFBamXMsgClientStringTypeTable( this );
		tableSubProject = new CFBamXMsgClientSubProjectTable( this );
		tableSysCluster = new CFBamXMsgClientSysClusterTable( this );
		tableTSecGroup = new CFBamXMsgClientTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamXMsgClientTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamXMsgClientTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamXMsgClientTZDateColTable( this );
		tableTZDateDef = new CFBamXMsgClientTZDateDefTable( this );
		tableTZDateType = new CFBamXMsgClientTZDateTypeTable( this );
		tableTZTimeCol = new CFBamXMsgClientTZTimeColTable( this );
		tableTZTimeDef = new CFBamXMsgClientTZTimeDefTable( this );
		tableTZTimeType = new CFBamXMsgClientTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamXMsgClientTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamXMsgClientTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamXMsgClientTZTimestampTypeTable( this );
		tableTable = new CFBamXMsgClientTableTable( this );
		tableTableCol = new CFBamXMsgClientTableColTable( this );
		tableTenant = new CFBamXMsgClientTenantTable( this );
		tableTextCol = new CFBamXMsgClientTextColTable( this );
		tableTextDef = new CFBamXMsgClientTextDefTable( this );
		tableTextType = new CFBamXMsgClientTextTypeTable( this );
		tableTimeCol = new CFBamXMsgClientTimeColTable( this );
		tableTimeDef = new CFBamXMsgClientTimeDefTable( this );
		tableTimeType = new CFBamXMsgClientTimeTypeTable( this );
		tableTimestampCol = new CFBamXMsgClientTimestampColTable( this );
		tableTimestampDef = new CFBamXMsgClientTimestampDefTable( this );
		tableTimestampType = new CFBamXMsgClientTimestampTypeTable( this );
		tableTld = new CFBamXMsgClientTldTable( this );
		tableTokenCol = new CFBamXMsgClientTokenColTable( this );
		tableTokenDef = new CFBamXMsgClientTokenDefTable( this );
		tableTokenType = new CFBamXMsgClientTokenTypeTable( this );
		tableTopDomain = new CFBamXMsgClientTopDomainTable( this );
		tableTopProject = new CFBamXMsgClientTopProjectTable( this );
		tableUInt16Col = new CFBamXMsgClientUInt16ColTable( this );
		tableUInt16Def = new CFBamXMsgClientUInt16DefTable( this );
		tableUInt16Type = new CFBamXMsgClientUInt16TypeTable( this );
		tableUInt32Col = new CFBamXMsgClientUInt32ColTable( this );
		tableUInt32Def = new CFBamXMsgClientUInt32DefTable( this );
		tableUInt32Type = new CFBamXMsgClientUInt32TypeTable( this );
		tableUInt64Col = new CFBamXMsgClientUInt64ColTable( this );
		tableUInt64Def = new CFBamXMsgClientUInt64DefTable( this );
		tableUInt64Type = new CFBamXMsgClientUInt64TypeTable( this );
		tableURLProtocol = new CFBamXMsgClientURLProtocolTable( this );
		tableUuidCol = new CFBamXMsgClientUuidColTable( this );
		tableUuidDef = new CFBamXMsgClientUuidDefTable( this );
		tableUuidGen = new CFBamXMsgClientUuidGenTable( this );
		tableUuidType = new CFBamXMsgClientUuidTypeTable( this );
		tableValue = new CFBamXMsgClientValueTable( this );
		tableVersion = new CFBamXMsgClientVersionTable( this );
		setDbSchemaName( conf.getDbDatabase() );
		setResponseHandlerSchemaObj( handlerSchema );
	}

	public CFBamXMsgClientSchema( CFBamSchemaObj handlerSchema, String argJndiName ) {
		super( argJndiName );
		getCFTipClientHandler();
		getResponseHandler();
		tableAccessFrequency = new CFBamXMsgClientAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamXMsgClientAccessSecurityTable( this );
		tableAtom = new CFBamXMsgClientAtomTable( this );
		tableAuditAction = new CFBamXMsgClientAuditActionTable( this );
		tableBlobCol = new CFBamXMsgClientBlobColTable( this );
		tableBlobDef = new CFBamXMsgClientBlobDefTable( this );
		tableBlobType = new CFBamXMsgClientBlobTypeTable( this );
		tableBoolCol = new CFBamXMsgClientBoolColTable( this );
		tableBoolDef = new CFBamXMsgClientBoolDefTable( this );
		tableBoolType = new CFBamXMsgClientBoolTypeTable( this );
		tableChain = new CFBamXMsgClientChainTable( this );
		tableClearDep = new CFBamXMsgClientClearDepTable( this );
		tableClearSubDep1 = new CFBamXMsgClientClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamXMsgClientClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamXMsgClientClearSubDep3Table( this );
		tableClearTopDep = new CFBamXMsgClientClearTopDepTable( this );
		tableCluster = new CFBamXMsgClientClusterTable( this );
		tableDataScope = new CFBamXMsgClientDataScopeTable( this );
		tableDateCol = new CFBamXMsgClientDateColTable( this );
		tableDateDef = new CFBamXMsgClientDateDefTable( this );
		tableDateType = new CFBamXMsgClientDateTypeTable( this );
		tableDelDep = new CFBamXMsgClientDelDepTable( this );
		tableDelSubDep1 = new CFBamXMsgClientDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamXMsgClientDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamXMsgClientDelSubDep3Table( this );
		tableDelTopDep = new CFBamXMsgClientDelTopDepTable( this );
		tableDomain = new CFBamXMsgClientDomainTable( this );
		tableDomainBase = new CFBamXMsgClientDomainBaseTable( this );
		tableDoubleCol = new CFBamXMsgClientDoubleColTable( this );
		tableDoubleDef = new CFBamXMsgClientDoubleDefTable( this );
		tableDoubleType = new CFBamXMsgClientDoubleTypeTable( this );
		tableEnumCol = new CFBamXMsgClientEnumColTable( this );
		tableEnumDef = new CFBamXMsgClientEnumDefTable( this );
		tableEnumTag = new CFBamXMsgClientEnumTagTable( this );
		tableEnumType = new CFBamXMsgClientEnumTypeTable( this );
		tableFloatCol = new CFBamXMsgClientFloatColTable( this );
		tableFloatDef = new CFBamXMsgClientFloatDefTable( this );
		tableFloatType = new CFBamXMsgClientFloatTypeTable( this );
		tableHostNode = new CFBamXMsgClientHostNodeTable( this );
		tableISOCountry = new CFBamXMsgClientISOCountryTable( this );
		tableISOCountryCurrency = new CFBamXMsgClientISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamXMsgClientISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamXMsgClientISOCurrencyTable( this );
		tableISOLanguage = new CFBamXMsgClientISOLanguageTable( this );
		tableISOTimezone = new CFBamXMsgClientISOTimezoneTable( this );
		tableId16Gen = new CFBamXMsgClientId16GenTable( this );
		tableId32Gen = new CFBamXMsgClientId32GenTable( this );
		tableId64Gen = new CFBamXMsgClientId64GenTable( this );
		tableIndex = new CFBamXMsgClientIndexTable( this );
		tableIndexCol = new CFBamXMsgClientIndexColTable( this );
		tableInt16Col = new CFBamXMsgClientInt16ColTable( this );
		tableInt16Def = new CFBamXMsgClientInt16DefTable( this );
		tableInt16Type = new CFBamXMsgClientInt16TypeTable( this );
		tableInt32Col = new CFBamXMsgClientInt32ColTable( this );
		tableInt32Def = new CFBamXMsgClientInt32DefTable( this );
		tableInt32Type = new CFBamXMsgClientInt32TypeTable( this );
		tableInt64Col = new CFBamXMsgClientInt64ColTable( this );
		tableInt64Def = new CFBamXMsgClientInt64DefTable( this );
		tableInt64Type = new CFBamXMsgClientInt64TypeTable( this );
		tableLicense = new CFBamXMsgClientLicenseTable( this );
		tableLoaderBehaviour = new CFBamXMsgClientLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamXMsgClientMajorVersionTable( this );
		tableMimeType = new CFBamXMsgClientMimeTypeTable( this );
		tableMinorVersion = new CFBamXMsgClientMinorVersionTable( this );
		tableNmTokenCol = new CFBamXMsgClientNmTokenColTable( this );
		tableNmTokenDef = new CFBamXMsgClientNmTokenDefTable( this );
		tableNmTokenType = new CFBamXMsgClientNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamXMsgClientNmTokensColTable( this );
		tableNmTokensDef = new CFBamXMsgClientNmTokensDefTable( this );
		tableNmTokensType = new CFBamXMsgClientNmTokensTypeTable( this );
		tableNumberCol = new CFBamXMsgClientNumberColTable( this );
		tableNumberDef = new CFBamXMsgClientNumberDefTable( this );
		tableNumberType = new CFBamXMsgClientNumberTypeTable( this );
		tableParam = new CFBamXMsgClientParamTable( this );
		tablePopDep = new CFBamXMsgClientPopDepTable( this );
		tablePopSubDep1 = new CFBamXMsgClientPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamXMsgClientPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamXMsgClientPopSubDep3Table( this );
		tablePopTopDep = new CFBamXMsgClientPopTopDepTable( this );
		tableProjectBase = new CFBamXMsgClientProjectBaseTable( this );
		tableRealProject = new CFBamXMsgClientRealProjectTable( this );
		tableRelation = new CFBamXMsgClientRelationTable( this );
		tableRelationCol = new CFBamXMsgClientRelationColTable( this );
		tableRelationType = new CFBamXMsgClientRelationTypeTable( this );
		tableSchemaDef = new CFBamXMsgClientSchemaDefTable( this );
		tableSchemaRef = new CFBamXMsgClientSchemaRefTable( this );
		tableScope = new CFBamXMsgClientScopeTable( this );
		tableSecApp = new CFBamXMsgClientSecAppTable( this );
		tableSecDevice = new CFBamXMsgClientSecDeviceTable( this );
		tableSecForm = new CFBamXMsgClientSecFormTable( this );
		tableSecGroup = new CFBamXMsgClientSecGroupTable( this );
		tableSecGroupForm = new CFBamXMsgClientSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamXMsgClientSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamXMsgClientSecGroupMemberTable( this );
		tableSecSession = new CFBamXMsgClientSecSessionTable( this );
		tableSecUser = new CFBamXMsgClientSecUserTable( this );
		tableSecurityScope = new CFBamXMsgClientSecurityScopeTable( this );
		tableServerListFunc = new CFBamXMsgClientServerListFuncTable( this );
		tableServerMethod = new CFBamXMsgClientServerMethodTable( this );
		tableServerObjFunc = new CFBamXMsgClientServerObjFuncTable( this );
		tableServerProc = new CFBamXMsgClientServerProcTable( this );
		tableService = new CFBamXMsgClientServiceTable( this );
		tableServiceType = new CFBamXMsgClientServiceTypeTable( this );
		tableStringCol = new CFBamXMsgClientStringColTable( this );
		tableStringDef = new CFBamXMsgClientStringDefTable( this );
		tableStringType = new CFBamXMsgClientStringTypeTable( this );
		tableSubProject = new CFBamXMsgClientSubProjectTable( this );
		tableSysCluster = new CFBamXMsgClientSysClusterTable( this );
		tableTSecGroup = new CFBamXMsgClientTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamXMsgClientTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamXMsgClientTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamXMsgClientTZDateColTable( this );
		tableTZDateDef = new CFBamXMsgClientTZDateDefTable( this );
		tableTZDateType = new CFBamXMsgClientTZDateTypeTable( this );
		tableTZTimeCol = new CFBamXMsgClientTZTimeColTable( this );
		tableTZTimeDef = new CFBamXMsgClientTZTimeDefTable( this );
		tableTZTimeType = new CFBamXMsgClientTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamXMsgClientTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamXMsgClientTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamXMsgClientTZTimestampTypeTable( this );
		tableTable = new CFBamXMsgClientTableTable( this );
		tableTableCol = new CFBamXMsgClientTableColTable( this );
		tableTenant = new CFBamXMsgClientTenantTable( this );
		tableTextCol = new CFBamXMsgClientTextColTable( this );
		tableTextDef = new CFBamXMsgClientTextDefTable( this );
		tableTextType = new CFBamXMsgClientTextTypeTable( this );
		tableTimeCol = new CFBamXMsgClientTimeColTable( this );
		tableTimeDef = new CFBamXMsgClientTimeDefTable( this );
		tableTimeType = new CFBamXMsgClientTimeTypeTable( this );
		tableTimestampCol = new CFBamXMsgClientTimestampColTable( this );
		tableTimestampDef = new CFBamXMsgClientTimestampDefTable( this );
		tableTimestampType = new CFBamXMsgClientTimestampTypeTable( this );
		tableTld = new CFBamXMsgClientTldTable( this );
		tableTokenCol = new CFBamXMsgClientTokenColTable( this );
		tableTokenDef = new CFBamXMsgClientTokenDefTable( this );
		tableTokenType = new CFBamXMsgClientTokenTypeTable( this );
		tableTopDomain = new CFBamXMsgClientTopDomainTable( this );
		tableTopProject = new CFBamXMsgClientTopProjectTable( this );
		tableUInt16Col = new CFBamXMsgClientUInt16ColTable( this );
		tableUInt16Def = new CFBamXMsgClientUInt16DefTable( this );
		tableUInt16Type = new CFBamXMsgClientUInt16TypeTable( this );
		tableUInt32Col = new CFBamXMsgClientUInt32ColTable( this );
		tableUInt32Def = new CFBamXMsgClientUInt32DefTable( this );
		tableUInt32Type = new CFBamXMsgClientUInt32TypeTable( this );
		tableUInt64Col = new CFBamXMsgClientUInt64ColTable( this );
		tableUInt64Def = new CFBamXMsgClientUInt64DefTable( this );
		tableUInt64Type = new CFBamXMsgClientUInt64TypeTable( this );
		tableURLProtocol = new CFBamXMsgClientURLProtocolTable( this );
		tableUuidCol = new CFBamXMsgClientUuidColTable( this );
		tableUuidDef = new CFBamXMsgClientUuidDefTable( this );
		tableUuidGen = new CFBamXMsgClientUuidGenTable( this );
		tableUuidType = new CFBamXMsgClientUuidTypeTable( this );
		tableValue = new CFBamXMsgClientValueTable( this );
		tableVersion = new CFBamXMsgClientVersionTable( this );
		setResponseHandlerSchemaObj( handlerSchema );
	}

	// Overload this to create an instance implementing your sendReceive() processing for CFTip
	public CFTipClientHandler getCFTipClientHandler() {
		if( cftipClientHandler == null ) {
			cftipClientHandler = new CFTipClientHandler();
		}
		return( cftipClientHandler );
	}

	/**
	 *	Get the CFBamSchemaObj that is used by the response processor to
	 *	import the response objects during the parsing of response message strings.
	 *
	 *	@return	The CFBamSchemaObj that is providing a persistence implementation
	 *			for the parsing of response message strings.
	 */
	public ICFBamSchemaObj getResponseHandlerSchemaObj() {
		ICFBamSchemaObj handlerSchema = getResponseHandler().getSchemaObj();
		return( handlerSchema );
	}

	/**
	 *	Set the CFBamSchemaObj that is to be used by the response processor to
	 *	import the response objects during the parsing of response message strings.
	 *
	 *	@param	handlerSchema The CFBamSchemaObj that is to provide a persistence implementation
	 *			for the parsing of response message strings.
	 */
	public void setResponseHandlerSchemaObj( ICFBamSchemaObj handlerSchema ) {
		getResponseHandler().setSchemaObj( handlerSchema );
	}

		public ICFLibMessageLog getLog() {
			ICFLibMessageLog mylog = getResponseHandler().getLog();
			return( mylog );
		}

		public void setLog( ICFLibMessageLog newlog ) {
			getResponseHandler().setLog( newlog );
		}

	/**
	 *	Get the CFBamDeleted flag that is used by the response processor to
	 *	indate that a Deleted response was processed.
	 *
	 *	@return	True if a Deleted message was processed, otherwise false.
	 */
	public boolean getResponseHandlerDeleted() {
		boolean deleted = getResponseHandler().getDeleted();
		return( deleted );
	}

	/**
	 *	Set the CFBamDeleted flag that is to be used by the response processor to
	 *	indicate that a Deleted response was processed.
	 *
	 *	@param	deleted True if a Deleted response was processed, otherwise false.
	 */
	public void setResponseHandlerDeleted( boolean deleted ) {
		getResponseHandler().setDeleted( deleted );
	}

	public boolean isConnected() {
		ICFBamSchemaObj schemaObj = getResponseHandlerSchemaObj();
		if( schemaObj.getAuthorization() != null ) {
			return( true );
		}
		else {
			return( false );
		}
	}

	/**
	 *	Send the request and receive a response string from the server.
	 *	<p>
	 *	You are expected to overload the implementation of this method
	 *	when binding an XMsgClient package to a particular transport
	 *	mechanism.  The implementation of sendReceive() is for pure XML
	 *	strings, so you can wire it to pretty much any implementation
	 *	you choose.
	 *
	 *	@param	Authorization -- null for connection requests
	 *
	 *	@param	rqst The String to send to the server
	 *
	 *	@return	rspn The response string recieved from the server, ready to be parsed as an XML file content.
	 */
	public String sendReceive( CFBamAuthorization Authorization,
		String rqst )
	{
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(),
			"sendReceive" );
	}

	public CFBamXMsgRspnHandler getResponseHandler() {
		CFBamXMsgRspnHandler responseHandler = null;
		CFTipClientHandler clientHandler = getCFTipClientHandler();
		responseHandler = (CFBamXMsgRspnHandler)clientHandler.getResponseHandler();
		if( responseHandler == null ) {
			responseHandler = new CFBamXMsgRspnHandler();
			clientHandler.setResponseHandler( responseHandler );
		}
		return( responseHandler );
	}

	public boolean connect() {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"connect" );
	}

	public boolean connect( String username, String password ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"connect-userpw" );
	}

	public boolean connect( String loginId, String password, String clusterName, String tenantName ) {
		final String S_ProcName = "connect-full";
		CFTipClientHandler clientHandler = getCFTipClientHandler();
		String deviceName = clientHandler.getDeviceName();

		String rqst = null;
		try {
			MessageDigest msgDigest = MessageDigest.getInstance( "SHA-512" );
			msgDigest.update( password.getBytes( "UTF-8" ) );
			byte[] hash = msgDigest.digest();
			byte[] encodedHash = Base64.encodeBase64( hash );
			byte[] devEncPWHash = clientHandler.encryptWithDevicePrivateKey( encodedHash );
	
			clientHandler.initSessionKey();
			
			rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
				+	"\t" + CFBamXMsgSchemaMessageFormatter.formatRqstLogIn( "\n\t\t\t",
								loginId,
								deviceName,
								devEncPWHash,
								clusterName,
								tenantName )
				+	"\n"
				+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( UnsupportedEncodingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught UnsupportedEncodingException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}

		try {
			cftipClientHandler.issueLoginRequest( rqst );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		// The response handler sets up the authorization
		ICFTipResponseHandler responseHandler = cftipClientHandler.getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		// If we got a response instead of an exception, we succeeded at logging in.
		return( true );
	}

	public void disconnect( boolean doCommit ) {
	}

	public void logout( CFBamAuthorization auth ) {
		final String S_ProcName = "logout";
		if( ( auth == null ) || ( null == auth.getSecSessionId() ) ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Not authorized/connected" );
		}
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSchemaMessageFormatter.formatRqstLogOut( "\n\t\t\t",
							auth.getSecSessionId() )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			cftipClientHandler.issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = cftipClientHandler.getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
	}

	public boolean isTransactionOpen() {
		return( transactionOpen );
	}

	public boolean beginTransaction() {
		if( transactionOpen ) {
			return( false );
		}
		else {
			transactionOpen = true;
			return( true );
		}
	}

	public void commit() {
		transactionOpen = false;
	}

	public void rollback() {
		transactionOpen = false;
	}

	public boolean isSystemUser( CFBamAuthorization Authorization) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"isSystemUser" );
	}

	public boolean isClusterUser( CFBamAuthorization Authorization,
		long clusterId,
		String groupName )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"isClusterUser" );
	}

	public boolean isTenantUser( CFBamAuthorization Authorization,
		long tenantId,
		String groupName )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"isTenantUser" );
	}

	public String fileImport( CFBamAuthorization Authorization,
		String fileName,
		String fileContents )
	{
		final String S_ProcName = "fileImport";
		if( ( fileName == null ) || ( fileName.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"fileName" );
		}
		if( ( fileContents == null ) || ( fileContents.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				2,
				"fileContents" );
		}
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSchemaMessageFormatter.formatRqstFileImport( "\n\t\t\t",
						fileName,
						fileContents ) + "\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		CFBamXMsgRspnHandler responseParser = (CFBamXMsgRspnHandler)responseHandler;
		String logContents = responseParser.getLogContents();
		return( logContents );
	}

	public int nextServiceTypeIdGen() {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"nextServiceTypeIdGen" );
	}

	public int nextMimeTypeIdGen() {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"nextMimeTypeIdGen" );
	}

	public long nextClusterIdGen() {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"nextClusterIdGen" );
	}

	public long nextTenantIdGen() {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"nextTenantIdGen" );
	}

	public UUID nextSecSessionIdGen() {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"nextSecSessionIdGen" );
	}

	public UUID nextSecUserIdGen() {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"nextSecUserIdGen" );
	}

	/**
	 *	Release the prepared statements.
	 *	<p>
	 *	When the schema changes connections, the prepared statements
	 *	have to be released because they contain connection-specific
	 *	information for most databases.
	 */
	public void releasePreparedStatements() {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"releasePreparedStatements" );
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
				"convertDateString",
            	"Value must be in YYYY-MM-DD format, \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 8 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
				"convertTimeString",
            	"Value must be in HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
				"convertTimestampString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
				"convertTZDateString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
				"convertTZTimeString",
            	"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamXMsgClientSchema.class,
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
