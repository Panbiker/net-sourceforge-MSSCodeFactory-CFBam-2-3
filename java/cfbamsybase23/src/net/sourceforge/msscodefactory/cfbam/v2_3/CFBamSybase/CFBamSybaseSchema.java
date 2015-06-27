// Description: Java 7 Sybase ASE 15.7 Jdbc DbIO implementation for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSybase;

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

public class CFBamSybaseSchema
	extends CFBamSchema
{
	protected static Calendar serverCalendar = new GregorianCalendar();
	protected static TimeZone serverTimeZone = serverCalendar.getTimeZone();

	public static TimeZone getServerTimeZone() {
		return( serverTimeZone );
	}

	protected Connection cnx;
	protected boolean inTransaction;
	protected PreparedStatement stmtBeginTransaction = null;

	public CFBamSybaseSchema() {
		super();
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamSybaseAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamSybaseAccessSecurityTable( this );
		tableAtom = new CFBamSybaseAtomTable( this );
		tableAuditAction = new CFBamSybaseAuditActionTable( this );
		tableBlobCol = new CFBamSybaseBlobColTable( this );
		tableBlobDef = new CFBamSybaseBlobDefTable( this );
		tableBlobType = new CFBamSybaseBlobTypeTable( this );
		tableBoolCol = new CFBamSybaseBoolColTable( this );
		tableBoolDef = new CFBamSybaseBoolDefTable( this );
		tableBoolType = new CFBamSybaseBoolTypeTable( this );
		tableChain = new CFBamSybaseChainTable( this );
		tableClearDep = new CFBamSybaseClearDepTable( this );
		tableClearSubDep1 = new CFBamSybaseClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamSybaseClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamSybaseClearSubDep3Table( this );
		tableClearTopDep = new CFBamSybaseClearTopDepTable( this );
		tableCluster = new CFBamSybaseClusterTable( this );
		tableDataScope = new CFBamSybaseDataScopeTable( this );
		tableDateCol = new CFBamSybaseDateColTable( this );
		tableDateDef = new CFBamSybaseDateDefTable( this );
		tableDateType = new CFBamSybaseDateTypeTable( this );
		tableDelDep = new CFBamSybaseDelDepTable( this );
		tableDelSubDep1 = new CFBamSybaseDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamSybaseDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamSybaseDelSubDep3Table( this );
		tableDelTopDep = new CFBamSybaseDelTopDepTable( this );
		tableDomain = new CFBamSybaseDomainTable( this );
		tableDomainBase = new CFBamSybaseDomainBaseTable( this );
		tableDoubleCol = new CFBamSybaseDoubleColTable( this );
		tableDoubleDef = new CFBamSybaseDoubleDefTable( this );
		tableDoubleType = new CFBamSybaseDoubleTypeTable( this );
		tableEnumCol = new CFBamSybaseEnumColTable( this );
		tableEnumDef = new CFBamSybaseEnumDefTable( this );
		tableEnumTag = new CFBamSybaseEnumTagTable( this );
		tableEnumType = new CFBamSybaseEnumTypeTable( this );
		tableFloatCol = new CFBamSybaseFloatColTable( this );
		tableFloatDef = new CFBamSybaseFloatDefTable( this );
		tableFloatType = new CFBamSybaseFloatTypeTable( this );
		tableHostNode = new CFBamSybaseHostNodeTable( this );
		tableISOCountry = new CFBamSybaseISOCountryTable( this );
		tableISOCountryCurrency = new CFBamSybaseISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamSybaseISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamSybaseISOCurrencyTable( this );
		tableISOLanguage = new CFBamSybaseISOLanguageTable( this );
		tableISOTimezone = new CFBamSybaseISOTimezoneTable( this );
		tableId16Gen = new CFBamSybaseId16GenTable( this );
		tableId32Gen = new CFBamSybaseId32GenTable( this );
		tableId64Gen = new CFBamSybaseId64GenTable( this );
		tableIndex = new CFBamSybaseIndexTable( this );
		tableIndexCol = new CFBamSybaseIndexColTable( this );
		tableInt16Col = new CFBamSybaseInt16ColTable( this );
		tableInt16Def = new CFBamSybaseInt16DefTable( this );
		tableInt16Type = new CFBamSybaseInt16TypeTable( this );
		tableInt32Col = new CFBamSybaseInt32ColTable( this );
		tableInt32Def = new CFBamSybaseInt32DefTable( this );
		tableInt32Type = new CFBamSybaseInt32TypeTable( this );
		tableInt64Col = new CFBamSybaseInt64ColTable( this );
		tableInt64Def = new CFBamSybaseInt64DefTable( this );
		tableInt64Type = new CFBamSybaseInt64TypeTable( this );
		tableLicense = new CFBamSybaseLicenseTable( this );
		tableLoaderBehaviour = new CFBamSybaseLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamSybaseMajorVersionTable( this );
		tableMimeType = new CFBamSybaseMimeTypeTable( this );
		tableMinorVersion = new CFBamSybaseMinorVersionTable( this );
		tableNmTokenCol = new CFBamSybaseNmTokenColTable( this );
		tableNmTokenDef = new CFBamSybaseNmTokenDefTable( this );
		tableNmTokenType = new CFBamSybaseNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamSybaseNmTokensColTable( this );
		tableNmTokensDef = new CFBamSybaseNmTokensDefTable( this );
		tableNmTokensType = new CFBamSybaseNmTokensTypeTable( this );
		tableNumberCol = new CFBamSybaseNumberColTable( this );
		tableNumberDef = new CFBamSybaseNumberDefTable( this );
		tableNumberType = new CFBamSybaseNumberTypeTable( this );
		tableParam = new CFBamSybaseParamTable( this );
		tablePopDep = new CFBamSybasePopDepTable( this );
		tablePopSubDep1 = new CFBamSybasePopSubDep1Table( this );
		tablePopSubDep2 = new CFBamSybasePopSubDep2Table( this );
		tablePopSubDep3 = new CFBamSybasePopSubDep3Table( this );
		tablePopTopDep = new CFBamSybasePopTopDepTable( this );
		tableProjectBase = new CFBamSybaseProjectBaseTable( this );
		tableRealProject = new CFBamSybaseRealProjectTable( this );
		tableRelation = new CFBamSybaseRelationTable( this );
		tableRelationCol = new CFBamSybaseRelationColTable( this );
		tableRelationType = new CFBamSybaseRelationTypeTable( this );
		tableSchemaDef = new CFBamSybaseSchemaDefTable( this );
		tableSchemaRef = new CFBamSybaseSchemaRefTable( this );
		tableScope = new CFBamSybaseScopeTable( this );
		tableSecApp = new CFBamSybaseSecAppTable( this );
		tableSecDevice = new CFBamSybaseSecDeviceTable( this );
		tableSecForm = new CFBamSybaseSecFormTable( this );
		tableSecGroup = new CFBamSybaseSecGroupTable( this );
		tableSecGroupForm = new CFBamSybaseSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamSybaseSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamSybaseSecGroupMemberTable( this );
		tableSecSession = new CFBamSybaseSecSessionTable( this );
		tableSecUser = new CFBamSybaseSecUserTable( this );
		tableSecurityScope = new CFBamSybaseSecurityScopeTable( this );
		tableServerListFunc = new CFBamSybaseServerListFuncTable( this );
		tableServerMethod = new CFBamSybaseServerMethodTable( this );
		tableServerObjFunc = new CFBamSybaseServerObjFuncTable( this );
		tableServerProc = new CFBamSybaseServerProcTable( this );
		tableService = new CFBamSybaseServiceTable( this );
		tableServiceType = new CFBamSybaseServiceTypeTable( this );
		tableStringCol = new CFBamSybaseStringColTable( this );
		tableStringDef = new CFBamSybaseStringDefTable( this );
		tableStringType = new CFBamSybaseStringTypeTable( this );
		tableSubProject = new CFBamSybaseSubProjectTable( this );
		tableSysCluster = new CFBamSybaseSysClusterTable( this );
		tableTSecGroup = new CFBamSybaseTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamSybaseTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamSybaseTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamSybaseTZDateColTable( this );
		tableTZDateDef = new CFBamSybaseTZDateDefTable( this );
		tableTZDateType = new CFBamSybaseTZDateTypeTable( this );
		tableTZTimeCol = new CFBamSybaseTZTimeColTable( this );
		tableTZTimeDef = new CFBamSybaseTZTimeDefTable( this );
		tableTZTimeType = new CFBamSybaseTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamSybaseTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamSybaseTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamSybaseTZTimestampTypeTable( this );
		tableTable = new CFBamSybaseTableTable( this );
		tableTableCol = new CFBamSybaseTableColTable( this );
		tableTenant = new CFBamSybaseTenantTable( this );
		tableTextCol = new CFBamSybaseTextColTable( this );
		tableTextDef = new CFBamSybaseTextDefTable( this );
		tableTextType = new CFBamSybaseTextTypeTable( this );
		tableTimeCol = new CFBamSybaseTimeColTable( this );
		tableTimeDef = new CFBamSybaseTimeDefTable( this );
		tableTimeType = new CFBamSybaseTimeTypeTable( this );
		tableTimestampCol = new CFBamSybaseTimestampColTable( this );
		tableTimestampDef = new CFBamSybaseTimestampDefTable( this );
		tableTimestampType = new CFBamSybaseTimestampTypeTable( this );
		tableTld = new CFBamSybaseTldTable( this );
		tableTokenCol = new CFBamSybaseTokenColTable( this );
		tableTokenDef = new CFBamSybaseTokenDefTable( this );
		tableTokenType = new CFBamSybaseTokenTypeTable( this );
		tableTopDomain = new CFBamSybaseTopDomainTable( this );
		tableTopProject = new CFBamSybaseTopProjectTable( this );
		tableUInt16Col = new CFBamSybaseUInt16ColTable( this );
		tableUInt16Def = new CFBamSybaseUInt16DefTable( this );
		tableUInt16Type = new CFBamSybaseUInt16TypeTable( this );
		tableUInt32Col = new CFBamSybaseUInt32ColTable( this );
		tableUInt32Def = new CFBamSybaseUInt32DefTable( this );
		tableUInt32Type = new CFBamSybaseUInt32TypeTable( this );
		tableUInt64Col = new CFBamSybaseUInt64ColTable( this );
		tableUInt64Def = new CFBamSybaseUInt64DefTable( this );
		tableUInt64Type = new CFBamSybaseUInt64TypeTable( this );
		tableURLProtocol = new CFBamSybaseURLProtocolTable( this );
		tableUuidCol = new CFBamSybaseUuidColTable( this );
		tableUuidDef = new CFBamSybaseUuidDefTable( this );
		tableUuidGen = new CFBamSybaseUuidGenTable( this );
		tableUuidType = new CFBamSybaseUuidTypeTable( this );
		tableValue = new CFBamSybaseValueTable( this );
		tableVersion = new CFBamSybaseVersionTable( this );
	}

	public CFBamSybaseSchema( CFBamConfigurationFile conf ) {
		super( conf );
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamSybaseAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamSybaseAccessSecurityTable( this );
		tableAtom = new CFBamSybaseAtomTable( this );
		tableAuditAction = new CFBamSybaseAuditActionTable( this );
		tableBlobCol = new CFBamSybaseBlobColTable( this );
		tableBlobDef = new CFBamSybaseBlobDefTable( this );
		tableBlobType = new CFBamSybaseBlobTypeTable( this );
		tableBoolCol = new CFBamSybaseBoolColTable( this );
		tableBoolDef = new CFBamSybaseBoolDefTable( this );
		tableBoolType = new CFBamSybaseBoolTypeTable( this );
		tableChain = new CFBamSybaseChainTable( this );
		tableClearDep = new CFBamSybaseClearDepTable( this );
		tableClearSubDep1 = new CFBamSybaseClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamSybaseClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamSybaseClearSubDep3Table( this );
		tableClearTopDep = new CFBamSybaseClearTopDepTable( this );
		tableCluster = new CFBamSybaseClusterTable( this );
		tableDataScope = new CFBamSybaseDataScopeTable( this );
		tableDateCol = new CFBamSybaseDateColTable( this );
		tableDateDef = new CFBamSybaseDateDefTable( this );
		tableDateType = new CFBamSybaseDateTypeTable( this );
		tableDelDep = new CFBamSybaseDelDepTable( this );
		tableDelSubDep1 = new CFBamSybaseDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamSybaseDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamSybaseDelSubDep3Table( this );
		tableDelTopDep = new CFBamSybaseDelTopDepTable( this );
		tableDomain = new CFBamSybaseDomainTable( this );
		tableDomainBase = new CFBamSybaseDomainBaseTable( this );
		tableDoubleCol = new CFBamSybaseDoubleColTable( this );
		tableDoubleDef = new CFBamSybaseDoubleDefTable( this );
		tableDoubleType = new CFBamSybaseDoubleTypeTable( this );
		tableEnumCol = new CFBamSybaseEnumColTable( this );
		tableEnumDef = new CFBamSybaseEnumDefTable( this );
		tableEnumTag = new CFBamSybaseEnumTagTable( this );
		tableEnumType = new CFBamSybaseEnumTypeTable( this );
		tableFloatCol = new CFBamSybaseFloatColTable( this );
		tableFloatDef = new CFBamSybaseFloatDefTable( this );
		tableFloatType = new CFBamSybaseFloatTypeTable( this );
		tableHostNode = new CFBamSybaseHostNodeTable( this );
		tableISOCountry = new CFBamSybaseISOCountryTable( this );
		tableISOCountryCurrency = new CFBamSybaseISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamSybaseISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamSybaseISOCurrencyTable( this );
		tableISOLanguage = new CFBamSybaseISOLanguageTable( this );
		tableISOTimezone = new CFBamSybaseISOTimezoneTable( this );
		tableId16Gen = new CFBamSybaseId16GenTable( this );
		tableId32Gen = new CFBamSybaseId32GenTable( this );
		tableId64Gen = new CFBamSybaseId64GenTable( this );
		tableIndex = new CFBamSybaseIndexTable( this );
		tableIndexCol = new CFBamSybaseIndexColTable( this );
		tableInt16Col = new CFBamSybaseInt16ColTable( this );
		tableInt16Def = new CFBamSybaseInt16DefTable( this );
		tableInt16Type = new CFBamSybaseInt16TypeTable( this );
		tableInt32Col = new CFBamSybaseInt32ColTable( this );
		tableInt32Def = new CFBamSybaseInt32DefTable( this );
		tableInt32Type = new CFBamSybaseInt32TypeTable( this );
		tableInt64Col = new CFBamSybaseInt64ColTable( this );
		tableInt64Def = new CFBamSybaseInt64DefTable( this );
		tableInt64Type = new CFBamSybaseInt64TypeTable( this );
		tableLicense = new CFBamSybaseLicenseTable( this );
		tableLoaderBehaviour = new CFBamSybaseLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamSybaseMajorVersionTable( this );
		tableMimeType = new CFBamSybaseMimeTypeTable( this );
		tableMinorVersion = new CFBamSybaseMinorVersionTable( this );
		tableNmTokenCol = new CFBamSybaseNmTokenColTable( this );
		tableNmTokenDef = new CFBamSybaseNmTokenDefTable( this );
		tableNmTokenType = new CFBamSybaseNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamSybaseNmTokensColTable( this );
		tableNmTokensDef = new CFBamSybaseNmTokensDefTable( this );
		tableNmTokensType = new CFBamSybaseNmTokensTypeTable( this );
		tableNumberCol = new CFBamSybaseNumberColTable( this );
		tableNumberDef = new CFBamSybaseNumberDefTable( this );
		tableNumberType = new CFBamSybaseNumberTypeTable( this );
		tableParam = new CFBamSybaseParamTable( this );
		tablePopDep = new CFBamSybasePopDepTable( this );
		tablePopSubDep1 = new CFBamSybasePopSubDep1Table( this );
		tablePopSubDep2 = new CFBamSybasePopSubDep2Table( this );
		tablePopSubDep3 = new CFBamSybasePopSubDep3Table( this );
		tablePopTopDep = new CFBamSybasePopTopDepTable( this );
		tableProjectBase = new CFBamSybaseProjectBaseTable( this );
		tableRealProject = new CFBamSybaseRealProjectTable( this );
		tableRelation = new CFBamSybaseRelationTable( this );
		tableRelationCol = new CFBamSybaseRelationColTable( this );
		tableRelationType = new CFBamSybaseRelationTypeTable( this );
		tableSchemaDef = new CFBamSybaseSchemaDefTable( this );
		tableSchemaRef = new CFBamSybaseSchemaRefTable( this );
		tableScope = new CFBamSybaseScopeTable( this );
		tableSecApp = new CFBamSybaseSecAppTable( this );
		tableSecDevice = new CFBamSybaseSecDeviceTable( this );
		tableSecForm = new CFBamSybaseSecFormTable( this );
		tableSecGroup = new CFBamSybaseSecGroupTable( this );
		tableSecGroupForm = new CFBamSybaseSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamSybaseSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamSybaseSecGroupMemberTable( this );
		tableSecSession = new CFBamSybaseSecSessionTable( this );
		tableSecUser = new CFBamSybaseSecUserTable( this );
		tableSecurityScope = new CFBamSybaseSecurityScopeTable( this );
		tableServerListFunc = new CFBamSybaseServerListFuncTable( this );
		tableServerMethod = new CFBamSybaseServerMethodTable( this );
		tableServerObjFunc = new CFBamSybaseServerObjFuncTable( this );
		tableServerProc = new CFBamSybaseServerProcTable( this );
		tableService = new CFBamSybaseServiceTable( this );
		tableServiceType = new CFBamSybaseServiceTypeTable( this );
		tableStringCol = new CFBamSybaseStringColTable( this );
		tableStringDef = new CFBamSybaseStringDefTable( this );
		tableStringType = new CFBamSybaseStringTypeTable( this );
		tableSubProject = new CFBamSybaseSubProjectTable( this );
		tableSysCluster = new CFBamSybaseSysClusterTable( this );
		tableTSecGroup = new CFBamSybaseTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamSybaseTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamSybaseTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamSybaseTZDateColTable( this );
		tableTZDateDef = new CFBamSybaseTZDateDefTable( this );
		tableTZDateType = new CFBamSybaseTZDateTypeTable( this );
		tableTZTimeCol = new CFBamSybaseTZTimeColTable( this );
		tableTZTimeDef = new CFBamSybaseTZTimeDefTable( this );
		tableTZTimeType = new CFBamSybaseTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamSybaseTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamSybaseTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamSybaseTZTimestampTypeTable( this );
		tableTable = new CFBamSybaseTableTable( this );
		tableTableCol = new CFBamSybaseTableColTable( this );
		tableTenant = new CFBamSybaseTenantTable( this );
		tableTextCol = new CFBamSybaseTextColTable( this );
		tableTextDef = new CFBamSybaseTextDefTable( this );
		tableTextType = new CFBamSybaseTextTypeTable( this );
		tableTimeCol = new CFBamSybaseTimeColTable( this );
		tableTimeDef = new CFBamSybaseTimeDefTable( this );
		tableTimeType = new CFBamSybaseTimeTypeTable( this );
		tableTimestampCol = new CFBamSybaseTimestampColTable( this );
		tableTimestampDef = new CFBamSybaseTimestampDefTable( this );
		tableTimestampType = new CFBamSybaseTimestampTypeTable( this );
		tableTld = new CFBamSybaseTldTable( this );
		tableTokenCol = new CFBamSybaseTokenColTable( this );
		tableTokenDef = new CFBamSybaseTokenDefTable( this );
		tableTokenType = new CFBamSybaseTokenTypeTable( this );
		tableTopDomain = new CFBamSybaseTopDomainTable( this );
		tableTopProject = new CFBamSybaseTopProjectTable( this );
		tableUInt16Col = new CFBamSybaseUInt16ColTable( this );
		tableUInt16Def = new CFBamSybaseUInt16DefTable( this );
		tableUInt16Type = new CFBamSybaseUInt16TypeTable( this );
		tableUInt32Col = new CFBamSybaseUInt32ColTable( this );
		tableUInt32Def = new CFBamSybaseUInt32DefTable( this );
		tableUInt32Type = new CFBamSybaseUInt32TypeTable( this );
		tableUInt64Col = new CFBamSybaseUInt64ColTable( this );
		tableUInt64Def = new CFBamSybaseUInt64DefTable( this );
		tableUInt64Type = new CFBamSybaseUInt64TypeTable( this );
		tableURLProtocol = new CFBamSybaseURLProtocolTable( this );
		tableUuidCol = new CFBamSybaseUuidColTable( this );
		tableUuidDef = new CFBamSybaseUuidDefTable( this );
		tableUuidGen = new CFBamSybaseUuidGenTable( this );
		tableUuidType = new CFBamSybaseUuidTypeTable( this );
		tableValue = new CFBamSybaseValueTable( this );
		tableVersion = new CFBamSybaseVersionTable( this );
		setDbSchemaName( conf.getDbDatabase() );
	}

	public CFBamSybaseSchema( String argJndiName ) {
		super( argJndiName );
		cnx = null;
		inTransaction = false;
		tableAccessFrequency = new CFBamSybaseAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamSybaseAccessSecurityTable( this );
		tableAtom = new CFBamSybaseAtomTable( this );
		tableAuditAction = new CFBamSybaseAuditActionTable( this );
		tableBlobCol = new CFBamSybaseBlobColTable( this );
		tableBlobDef = new CFBamSybaseBlobDefTable( this );
		tableBlobType = new CFBamSybaseBlobTypeTable( this );
		tableBoolCol = new CFBamSybaseBoolColTable( this );
		tableBoolDef = new CFBamSybaseBoolDefTable( this );
		tableBoolType = new CFBamSybaseBoolTypeTable( this );
		tableChain = new CFBamSybaseChainTable( this );
		tableClearDep = new CFBamSybaseClearDepTable( this );
		tableClearSubDep1 = new CFBamSybaseClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamSybaseClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamSybaseClearSubDep3Table( this );
		tableClearTopDep = new CFBamSybaseClearTopDepTable( this );
		tableCluster = new CFBamSybaseClusterTable( this );
		tableDataScope = new CFBamSybaseDataScopeTable( this );
		tableDateCol = new CFBamSybaseDateColTable( this );
		tableDateDef = new CFBamSybaseDateDefTable( this );
		tableDateType = new CFBamSybaseDateTypeTable( this );
		tableDelDep = new CFBamSybaseDelDepTable( this );
		tableDelSubDep1 = new CFBamSybaseDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamSybaseDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamSybaseDelSubDep3Table( this );
		tableDelTopDep = new CFBamSybaseDelTopDepTable( this );
		tableDomain = new CFBamSybaseDomainTable( this );
		tableDomainBase = new CFBamSybaseDomainBaseTable( this );
		tableDoubleCol = new CFBamSybaseDoubleColTable( this );
		tableDoubleDef = new CFBamSybaseDoubleDefTable( this );
		tableDoubleType = new CFBamSybaseDoubleTypeTable( this );
		tableEnumCol = new CFBamSybaseEnumColTable( this );
		tableEnumDef = new CFBamSybaseEnumDefTable( this );
		tableEnumTag = new CFBamSybaseEnumTagTable( this );
		tableEnumType = new CFBamSybaseEnumTypeTable( this );
		tableFloatCol = new CFBamSybaseFloatColTable( this );
		tableFloatDef = new CFBamSybaseFloatDefTable( this );
		tableFloatType = new CFBamSybaseFloatTypeTable( this );
		tableHostNode = new CFBamSybaseHostNodeTable( this );
		tableISOCountry = new CFBamSybaseISOCountryTable( this );
		tableISOCountryCurrency = new CFBamSybaseISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamSybaseISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamSybaseISOCurrencyTable( this );
		tableISOLanguage = new CFBamSybaseISOLanguageTable( this );
		tableISOTimezone = new CFBamSybaseISOTimezoneTable( this );
		tableId16Gen = new CFBamSybaseId16GenTable( this );
		tableId32Gen = new CFBamSybaseId32GenTable( this );
		tableId64Gen = new CFBamSybaseId64GenTable( this );
		tableIndex = new CFBamSybaseIndexTable( this );
		tableIndexCol = new CFBamSybaseIndexColTable( this );
		tableInt16Col = new CFBamSybaseInt16ColTable( this );
		tableInt16Def = new CFBamSybaseInt16DefTable( this );
		tableInt16Type = new CFBamSybaseInt16TypeTable( this );
		tableInt32Col = new CFBamSybaseInt32ColTable( this );
		tableInt32Def = new CFBamSybaseInt32DefTable( this );
		tableInt32Type = new CFBamSybaseInt32TypeTable( this );
		tableInt64Col = new CFBamSybaseInt64ColTable( this );
		tableInt64Def = new CFBamSybaseInt64DefTable( this );
		tableInt64Type = new CFBamSybaseInt64TypeTable( this );
		tableLicense = new CFBamSybaseLicenseTable( this );
		tableLoaderBehaviour = new CFBamSybaseLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamSybaseMajorVersionTable( this );
		tableMimeType = new CFBamSybaseMimeTypeTable( this );
		tableMinorVersion = new CFBamSybaseMinorVersionTable( this );
		tableNmTokenCol = new CFBamSybaseNmTokenColTable( this );
		tableNmTokenDef = new CFBamSybaseNmTokenDefTable( this );
		tableNmTokenType = new CFBamSybaseNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamSybaseNmTokensColTable( this );
		tableNmTokensDef = new CFBamSybaseNmTokensDefTable( this );
		tableNmTokensType = new CFBamSybaseNmTokensTypeTable( this );
		tableNumberCol = new CFBamSybaseNumberColTable( this );
		tableNumberDef = new CFBamSybaseNumberDefTable( this );
		tableNumberType = new CFBamSybaseNumberTypeTable( this );
		tableParam = new CFBamSybaseParamTable( this );
		tablePopDep = new CFBamSybasePopDepTable( this );
		tablePopSubDep1 = new CFBamSybasePopSubDep1Table( this );
		tablePopSubDep2 = new CFBamSybasePopSubDep2Table( this );
		tablePopSubDep3 = new CFBamSybasePopSubDep3Table( this );
		tablePopTopDep = new CFBamSybasePopTopDepTable( this );
		tableProjectBase = new CFBamSybaseProjectBaseTable( this );
		tableRealProject = new CFBamSybaseRealProjectTable( this );
		tableRelation = new CFBamSybaseRelationTable( this );
		tableRelationCol = new CFBamSybaseRelationColTable( this );
		tableRelationType = new CFBamSybaseRelationTypeTable( this );
		tableSchemaDef = new CFBamSybaseSchemaDefTable( this );
		tableSchemaRef = new CFBamSybaseSchemaRefTable( this );
		tableScope = new CFBamSybaseScopeTable( this );
		tableSecApp = new CFBamSybaseSecAppTable( this );
		tableSecDevice = new CFBamSybaseSecDeviceTable( this );
		tableSecForm = new CFBamSybaseSecFormTable( this );
		tableSecGroup = new CFBamSybaseSecGroupTable( this );
		tableSecGroupForm = new CFBamSybaseSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamSybaseSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamSybaseSecGroupMemberTable( this );
		tableSecSession = new CFBamSybaseSecSessionTable( this );
		tableSecUser = new CFBamSybaseSecUserTable( this );
		tableSecurityScope = new CFBamSybaseSecurityScopeTable( this );
		tableServerListFunc = new CFBamSybaseServerListFuncTable( this );
		tableServerMethod = new CFBamSybaseServerMethodTable( this );
		tableServerObjFunc = new CFBamSybaseServerObjFuncTable( this );
		tableServerProc = new CFBamSybaseServerProcTable( this );
		tableService = new CFBamSybaseServiceTable( this );
		tableServiceType = new CFBamSybaseServiceTypeTable( this );
		tableStringCol = new CFBamSybaseStringColTable( this );
		tableStringDef = new CFBamSybaseStringDefTable( this );
		tableStringType = new CFBamSybaseStringTypeTable( this );
		tableSubProject = new CFBamSybaseSubProjectTable( this );
		tableSysCluster = new CFBamSybaseSysClusterTable( this );
		tableTSecGroup = new CFBamSybaseTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamSybaseTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamSybaseTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamSybaseTZDateColTable( this );
		tableTZDateDef = new CFBamSybaseTZDateDefTable( this );
		tableTZDateType = new CFBamSybaseTZDateTypeTable( this );
		tableTZTimeCol = new CFBamSybaseTZTimeColTable( this );
		tableTZTimeDef = new CFBamSybaseTZTimeDefTable( this );
		tableTZTimeType = new CFBamSybaseTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamSybaseTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamSybaseTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamSybaseTZTimestampTypeTable( this );
		tableTable = new CFBamSybaseTableTable( this );
		tableTableCol = new CFBamSybaseTableColTable( this );
		tableTenant = new CFBamSybaseTenantTable( this );
		tableTextCol = new CFBamSybaseTextColTable( this );
		tableTextDef = new CFBamSybaseTextDefTable( this );
		tableTextType = new CFBamSybaseTextTypeTable( this );
		tableTimeCol = new CFBamSybaseTimeColTable( this );
		tableTimeDef = new CFBamSybaseTimeDefTable( this );
		tableTimeType = new CFBamSybaseTimeTypeTable( this );
		tableTimestampCol = new CFBamSybaseTimestampColTable( this );
		tableTimestampDef = new CFBamSybaseTimestampDefTable( this );
		tableTimestampType = new CFBamSybaseTimestampTypeTable( this );
		tableTld = new CFBamSybaseTldTable( this );
		tableTokenCol = new CFBamSybaseTokenColTable( this );
		tableTokenDef = new CFBamSybaseTokenDefTable( this );
		tableTokenType = new CFBamSybaseTokenTypeTable( this );
		tableTopDomain = new CFBamSybaseTopDomainTable( this );
		tableTopProject = new CFBamSybaseTopProjectTable( this );
		tableUInt16Col = new CFBamSybaseUInt16ColTable( this );
		tableUInt16Def = new CFBamSybaseUInt16DefTable( this );
		tableUInt16Type = new CFBamSybaseUInt16TypeTable( this );
		tableUInt32Col = new CFBamSybaseUInt32ColTable( this );
		tableUInt32Def = new CFBamSybaseUInt32DefTable( this );
		tableUInt32Type = new CFBamSybaseUInt32TypeTable( this );
		tableUInt64Col = new CFBamSybaseUInt64ColTable( this );
		tableUInt64Def = new CFBamSybaseUInt64DefTable( this );
		tableUInt64Type = new CFBamSybaseUInt64TypeTable( this );
		tableURLProtocol = new CFBamSybaseURLProtocolTable( this );
		tableUuidCol = new CFBamSybaseUuidColTable( this );
		tableUuidDef = new CFBamSybaseUuidDefTable( this );
		tableUuidGen = new CFBamSybaseUuidGenTable( this );
		tableUuidType = new CFBamSybaseUuidTypeTable( this );
		tableValue = new CFBamSybaseValueTable( this );
		tableVersion = new CFBamSybaseVersionTable( this );
	}

	public CFBamSybaseSchema( Connection argCnx ) {
		super();
		cnx = argCnx;
		inTransaction = false;
		tableAccessFrequency = new CFBamSybaseAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamSybaseAccessSecurityTable( this );
		tableAtom = new CFBamSybaseAtomTable( this );
		tableAuditAction = new CFBamSybaseAuditActionTable( this );
		tableBlobCol = new CFBamSybaseBlobColTable( this );
		tableBlobDef = new CFBamSybaseBlobDefTable( this );
		tableBlobType = new CFBamSybaseBlobTypeTable( this );
		tableBoolCol = new CFBamSybaseBoolColTable( this );
		tableBoolDef = new CFBamSybaseBoolDefTable( this );
		tableBoolType = new CFBamSybaseBoolTypeTable( this );
		tableChain = new CFBamSybaseChainTable( this );
		tableClearDep = new CFBamSybaseClearDepTable( this );
		tableClearSubDep1 = new CFBamSybaseClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamSybaseClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamSybaseClearSubDep3Table( this );
		tableClearTopDep = new CFBamSybaseClearTopDepTable( this );
		tableCluster = new CFBamSybaseClusterTable( this );
		tableDataScope = new CFBamSybaseDataScopeTable( this );
		tableDateCol = new CFBamSybaseDateColTable( this );
		tableDateDef = new CFBamSybaseDateDefTable( this );
		tableDateType = new CFBamSybaseDateTypeTable( this );
		tableDelDep = new CFBamSybaseDelDepTable( this );
		tableDelSubDep1 = new CFBamSybaseDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamSybaseDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamSybaseDelSubDep3Table( this );
		tableDelTopDep = new CFBamSybaseDelTopDepTable( this );
		tableDomain = new CFBamSybaseDomainTable( this );
		tableDomainBase = new CFBamSybaseDomainBaseTable( this );
		tableDoubleCol = new CFBamSybaseDoubleColTable( this );
		tableDoubleDef = new CFBamSybaseDoubleDefTable( this );
		tableDoubleType = new CFBamSybaseDoubleTypeTable( this );
		tableEnumCol = new CFBamSybaseEnumColTable( this );
		tableEnumDef = new CFBamSybaseEnumDefTable( this );
		tableEnumTag = new CFBamSybaseEnumTagTable( this );
		tableEnumType = new CFBamSybaseEnumTypeTable( this );
		tableFloatCol = new CFBamSybaseFloatColTable( this );
		tableFloatDef = new CFBamSybaseFloatDefTable( this );
		tableFloatType = new CFBamSybaseFloatTypeTable( this );
		tableHostNode = new CFBamSybaseHostNodeTable( this );
		tableISOCountry = new CFBamSybaseISOCountryTable( this );
		tableISOCountryCurrency = new CFBamSybaseISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamSybaseISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamSybaseISOCurrencyTable( this );
		tableISOLanguage = new CFBamSybaseISOLanguageTable( this );
		tableISOTimezone = new CFBamSybaseISOTimezoneTable( this );
		tableId16Gen = new CFBamSybaseId16GenTable( this );
		tableId32Gen = new CFBamSybaseId32GenTable( this );
		tableId64Gen = new CFBamSybaseId64GenTable( this );
		tableIndex = new CFBamSybaseIndexTable( this );
		tableIndexCol = new CFBamSybaseIndexColTable( this );
		tableInt16Col = new CFBamSybaseInt16ColTable( this );
		tableInt16Def = new CFBamSybaseInt16DefTable( this );
		tableInt16Type = new CFBamSybaseInt16TypeTable( this );
		tableInt32Col = new CFBamSybaseInt32ColTable( this );
		tableInt32Def = new CFBamSybaseInt32DefTable( this );
		tableInt32Type = new CFBamSybaseInt32TypeTable( this );
		tableInt64Col = new CFBamSybaseInt64ColTable( this );
		tableInt64Def = new CFBamSybaseInt64DefTable( this );
		tableInt64Type = new CFBamSybaseInt64TypeTable( this );
		tableLicense = new CFBamSybaseLicenseTable( this );
		tableLoaderBehaviour = new CFBamSybaseLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamSybaseMajorVersionTable( this );
		tableMimeType = new CFBamSybaseMimeTypeTable( this );
		tableMinorVersion = new CFBamSybaseMinorVersionTable( this );
		tableNmTokenCol = new CFBamSybaseNmTokenColTable( this );
		tableNmTokenDef = new CFBamSybaseNmTokenDefTable( this );
		tableNmTokenType = new CFBamSybaseNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamSybaseNmTokensColTable( this );
		tableNmTokensDef = new CFBamSybaseNmTokensDefTable( this );
		tableNmTokensType = new CFBamSybaseNmTokensTypeTable( this );
		tableNumberCol = new CFBamSybaseNumberColTable( this );
		tableNumberDef = new CFBamSybaseNumberDefTable( this );
		tableNumberType = new CFBamSybaseNumberTypeTable( this );
		tableParam = new CFBamSybaseParamTable( this );
		tablePopDep = new CFBamSybasePopDepTable( this );
		tablePopSubDep1 = new CFBamSybasePopSubDep1Table( this );
		tablePopSubDep2 = new CFBamSybasePopSubDep2Table( this );
		tablePopSubDep3 = new CFBamSybasePopSubDep3Table( this );
		tablePopTopDep = new CFBamSybasePopTopDepTable( this );
		tableProjectBase = new CFBamSybaseProjectBaseTable( this );
		tableRealProject = new CFBamSybaseRealProjectTable( this );
		tableRelation = new CFBamSybaseRelationTable( this );
		tableRelationCol = new CFBamSybaseRelationColTable( this );
		tableRelationType = new CFBamSybaseRelationTypeTable( this );
		tableSchemaDef = new CFBamSybaseSchemaDefTable( this );
		tableSchemaRef = new CFBamSybaseSchemaRefTable( this );
		tableScope = new CFBamSybaseScopeTable( this );
		tableSecApp = new CFBamSybaseSecAppTable( this );
		tableSecDevice = new CFBamSybaseSecDeviceTable( this );
		tableSecForm = new CFBamSybaseSecFormTable( this );
		tableSecGroup = new CFBamSybaseSecGroupTable( this );
		tableSecGroupForm = new CFBamSybaseSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamSybaseSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamSybaseSecGroupMemberTable( this );
		tableSecSession = new CFBamSybaseSecSessionTable( this );
		tableSecUser = new CFBamSybaseSecUserTable( this );
		tableSecurityScope = new CFBamSybaseSecurityScopeTable( this );
		tableServerListFunc = new CFBamSybaseServerListFuncTable( this );
		tableServerMethod = new CFBamSybaseServerMethodTable( this );
		tableServerObjFunc = new CFBamSybaseServerObjFuncTable( this );
		tableServerProc = new CFBamSybaseServerProcTable( this );
		tableService = new CFBamSybaseServiceTable( this );
		tableServiceType = new CFBamSybaseServiceTypeTable( this );
		tableStringCol = new CFBamSybaseStringColTable( this );
		tableStringDef = new CFBamSybaseStringDefTable( this );
		tableStringType = new CFBamSybaseStringTypeTable( this );
		tableSubProject = new CFBamSybaseSubProjectTable( this );
		tableSysCluster = new CFBamSybaseSysClusterTable( this );
		tableTSecGroup = new CFBamSybaseTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamSybaseTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamSybaseTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamSybaseTZDateColTable( this );
		tableTZDateDef = new CFBamSybaseTZDateDefTable( this );
		tableTZDateType = new CFBamSybaseTZDateTypeTable( this );
		tableTZTimeCol = new CFBamSybaseTZTimeColTable( this );
		tableTZTimeDef = new CFBamSybaseTZTimeDefTable( this );
		tableTZTimeType = new CFBamSybaseTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamSybaseTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamSybaseTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamSybaseTZTimestampTypeTable( this );
		tableTable = new CFBamSybaseTableTable( this );
		tableTableCol = new CFBamSybaseTableColTable( this );
		tableTenant = new CFBamSybaseTenantTable( this );
		tableTextCol = new CFBamSybaseTextColTable( this );
		tableTextDef = new CFBamSybaseTextDefTable( this );
		tableTextType = new CFBamSybaseTextTypeTable( this );
		tableTimeCol = new CFBamSybaseTimeColTable( this );
		tableTimeDef = new CFBamSybaseTimeDefTable( this );
		tableTimeType = new CFBamSybaseTimeTypeTable( this );
		tableTimestampCol = new CFBamSybaseTimestampColTable( this );
		tableTimestampDef = new CFBamSybaseTimestampDefTable( this );
		tableTimestampType = new CFBamSybaseTimestampTypeTable( this );
		tableTld = new CFBamSybaseTldTable( this );
		tableTokenCol = new CFBamSybaseTokenColTable( this );
		tableTokenDef = new CFBamSybaseTokenDefTable( this );
		tableTokenType = new CFBamSybaseTokenTypeTable( this );
		tableTopDomain = new CFBamSybaseTopDomainTable( this );
		tableTopProject = new CFBamSybaseTopProjectTable( this );
		tableUInt16Col = new CFBamSybaseUInt16ColTable( this );
		tableUInt16Def = new CFBamSybaseUInt16DefTable( this );
		tableUInt16Type = new CFBamSybaseUInt16TypeTable( this );
		tableUInt32Col = new CFBamSybaseUInt32ColTable( this );
		tableUInt32Def = new CFBamSybaseUInt32DefTable( this );
		tableUInt32Type = new CFBamSybaseUInt32TypeTable( this );
		tableUInt64Col = new CFBamSybaseUInt64ColTable( this );
		tableUInt64Def = new CFBamSybaseUInt64DefTable( this );
		tableUInt64Type = new CFBamSybaseUInt64TypeTable( this );
		tableURLProtocol = new CFBamSybaseURLProtocolTable( this );
		tableUuidCol = new CFBamSybaseUuidColTable( this );
		tableUuidDef = new CFBamSybaseUuidDefTable( this );
		tableUuidGen = new CFBamSybaseUuidGenTable( this );
		tableUuidType = new CFBamSybaseUuidTypeTable( this );
		tableValue = new CFBamSybaseValueTable( this );
		tableVersion = new CFBamSybaseVersionTable( this );
		try {
			cnx.setAutoCommit( false );
			cnx.rollback();
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"CFBamSybaseSchema-constructor",
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
				Class.forName( "com.sybase.jdbc4.jdbc.SybDriver" );
			}
			catch( ClassNotFoundException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"connect",
					"Could not load Sybase ASE 15.7 driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = configuration.getDbUserName();
			String dbPassword = configuration.getDbPassword();
			String url =
					"jdbc:sybase:Tds:" + dbServer
				+	":" + Integer.toString( dbPort );
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
			Statement stmtSetChainedOff = null;
			try {
				stmtSetChainedOff = cnx.createStatement();
				stmtSetChainedOff.executeUpdate( "set chained off" );
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName + "<<setChainedOff>>",
					e );
			}
			finally {
				if( stmtSetChainedOff != null ) {
					try {
						stmtSetChainedOff.close();
					}
					catch( SQLException e ) {
					}
					stmtSetChainedOff = null;
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
				Class.forName( "com.sybase.jdbc4.jdbc.SybDriver" );
			}
			catch( ClassNotFoundException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					"connect",
					"Could not load Sybase ASE 15.7 driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = username;
			String dbPassword = password;
			String url =
					"jdbc:sybase:Tds:" + dbServer
				+	":" + Integer.toString( dbPort );
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
			Statement stmtSetChainedOff = null;
			try {
				stmtSetChainedOff = cnx.createStatement();
				stmtSetChainedOff.executeUpdate( "set chained off" );
			}
			catch( SQLException e ) {
				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
					S_ProcName + "<<setChainedOff>>",
					e );
			}
			finally {
				if( stmtSetChainedOff != null ) {
					try {
						stmtSetChainedOff.close();
					}
					catch( SQLException e ) {
					}
					stmtSetChainedOff = null;
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
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"isSystemUser",
				"Not in a transaction" );
		}
		CallableStatement stmtSecurityCheck = null;
		try {
			final String sql = "{ call sp_is_system_user( ?, ? ) }";
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
				"isSystemUser",
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
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"isClusterUser",
				"Not in a transaction" );
		}
		CallableStatement stmtSecurityCheck = null;
		try {
			final String sql = "{ call sp_is_cluster_user( ?, ?, ?, ? ) }";
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
				"isClusterUser",
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
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"isTenantUser",
				"Not in a transaction" );
		}
		CallableStatement stmtSecurityCheck = null;
		try {
			final String sql = "{ call sp_is_tenant_user( ?, ?, ?, ? ) }";
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
				"isTenantUser",
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
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"nextServiceTypeIdGen",
				"Not in a transaction" );
		}
		CallableStatement stmtNext = null;
		try {
			final String sql = "{ call sp_next_servicetypeidgen( ? ) }";
			stmtNext = cnx.prepareCall( sql );
			stmtNext.registerOutParameter( 1, java.sql.Types.INTEGER );
			stmtNext.execute();
			int nextId = stmtNext.getInt( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"nextServiceTypeIdGen",
				e );
		}
		finally {
			if( stmtNext != null ) {
				try {
					stmtNext.close();
				}
				catch( SQLException e ) {
				}
				stmtNext = null;
			}
		}
	}

	public int nextMimeTypeIdGen() {
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"nextMimeTypeIdGen",
				"Not in a transaction" );
		}
		CallableStatement stmtNext = null;
		try {
			final String sql = "{ call sp_next_mimetypeidgen( ? ) }";
			stmtNext = cnx.prepareCall( sql );
			stmtNext.registerOutParameter( 1, java.sql.Types.INTEGER );
			stmtNext.execute();
			int nextId = stmtNext.getInt( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"nextMimeTypeIdGen",
				e );
		}
		finally {
			if( stmtNext != null ) {
				try {
					stmtNext.close();
				}
				catch( SQLException e ) {
				}
				stmtNext = null;
			}
		}
	}

	public long nextClusterIdGen() {
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"nextClusterIdGen",
				"Not in a transaction" );
		}
		CallableStatement stmtNext = null;
		try {
			final String sql = "{ call sp_next_clusteridgen( ? ) }";
			stmtNext = cnx.prepareCall( sql );
			stmtNext.registerOutParameter( 1, java.sql.Types.BIGINT );
			stmtNext.execute();
			long nextId = stmtNext.getLong( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"nextClusterIdGen",
				e );
		}
		finally {
			if( stmtNext != null ) {
				try {
					stmtNext.close();
				}
				catch( SQLException e ) {
				}
				stmtNext = null;
			}
		}
	}

	public long nextTenantIdGen() {
		if( ! inTransaction ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"nextTenantIdGen",
				"Not in a transaction" );
		}
		CallableStatement stmtNext = null;
		try {
			final String sql = "{ call sp_next_tenantidgen( ? ) }";
			stmtNext = cnx.prepareCall( sql );
			stmtNext.registerOutParameter( 1, java.sql.Types.BIGINT );
			stmtNext.execute();
			long nextId = stmtNext.getLong( 1 );
			return( nextId );
		}
		catch( SQLException e ) {
			throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
				"nextTenantIdGen",
				e );
		}
		finally {
			if( stmtNext != null ) {
				try {
					stmtNext.close();
				}
				catch( SQLException e ) {
				}
				stmtNext = null;
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
		if( stmtBeginTransaction != null ) {
			try {
				stmtBeginTransaction.close();
			}
			catch( SQLException e ) {
//				throw CFLib.getDefaultExceptionFactory().newDbException( getClass(),
//					S_ProcName,
//					e );
			}
			stmtBeginTransaction = null;
		}

		if( ( tableAccessFrequency != null ) && ( tableAccessFrequency instanceof CFBamSybaseAccessFrequencyTable ) ) {
			CFBamSybaseAccessFrequencyTable table = (CFBamSybaseAccessFrequencyTable)tableAccessFrequency;
			table.releasePreparedStatements();
		}
		if( ( tableAccessSecurity != null ) && ( tableAccessSecurity instanceof CFBamSybaseAccessSecurityTable ) ) {
			CFBamSybaseAccessSecurityTable table = (CFBamSybaseAccessSecurityTable)tableAccessSecurity;
			table.releasePreparedStatements();
		}
		if( ( tableAtom != null ) && ( tableAtom instanceof CFBamSybaseAtomTable ) ) {
			CFBamSybaseAtomTable table = (CFBamSybaseAtomTable)tableAtom;
			table.releasePreparedStatements();
		}
		if( ( tableAuditAction != null ) && ( tableAuditAction instanceof CFBamSybaseAuditActionTable ) ) {
			CFBamSybaseAuditActionTable table = (CFBamSybaseAuditActionTable)tableAuditAction;
			table.releasePreparedStatements();
		}
		if( ( tableBlobCol != null ) && ( tableBlobCol instanceof CFBamSybaseBlobColTable ) ) {
			CFBamSybaseBlobColTable table = (CFBamSybaseBlobColTable)tableBlobCol;
			table.releasePreparedStatements();
		}
		if( ( tableBlobDef != null ) && ( tableBlobDef instanceof CFBamSybaseBlobDefTable ) ) {
			CFBamSybaseBlobDefTable table = (CFBamSybaseBlobDefTable)tableBlobDef;
			table.releasePreparedStatements();
		}
		if( ( tableBlobType != null ) && ( tableBlobType instanceof CFBamSybaseBlobTypeTable ) ) {
			CFBamSybaseBlobTypeTable table = (CFBamSybaseBlobTypeTable)tableBlobType;
			table.releasePreparedStatements();
		}
		if( ( tableBoolCol != null ) && ( tableBoolCol instanceof CFBamSybaseBoolColTable ) ) {
			CFBamSybaseBoolColTable table = (CFBamSybaseBoolColTable)tableBoolCol;
			table.releasePreparedStatements();
		}
		if( ( tableBoolDef != null ) && ( tableBoolDef instanceof CFBamSybaseBoolDefTable ) ) {
			CFBamSybaseBoolDefTable table = (CFBamSybaseBoolDefTable)tableBoolDef;
			table.releasePreparedStatements();
		}
		if( ( tableBoolType != null ) && ( tableBoolType instanceof CFBamSybaseBoolTypeTable ) ) {
			CFBamSybaseBoolTypeTable table = (CFBamSybaseBoolTypeTable)tableBoolType;
			table.releasePreparedStatements();
		}
		if( ( tableChain != null ) && ( tableChain instanceof CFBamSybaseChainTable ) ) {
			CFBamSybaseChainTable table = (CFBamSybaseChainTable)tableChain;
			table.releasePreparedStatements();
		}
		if( ( tableClearDep != null ) && ( tableClearDep instanceof CFBamSybaseClearDepTable ) ) {
			CFBamSybaseClearDepTable table = (CFBamSybaseClearDepTable)tableClearDep;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep1 != null ) && ( tableClearSubDep1 instanceof CFBamSybaseClearSubDep1Table ) ) {
			CFBamSybaseClearSubDep1Table table = (CFBamSybaseClearSubDep1Table)tableClearSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep2 != null ) && ( tableClearSubDep2 instanceof CFBamSybaseClearSubDep2Table ) ) {
			CFBamSybaseClearSubDep2Table table = (CFBamSybaseClearSubDep2Table)tableClearSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep3 != null ) && ( tableClearSubDep3 instanceof CFBamSybaseClearSubDep3Table ) ) {
			CFBamSybaseClearSubDep3Table table = (CFBamSybaseClearSubDep3Table)tableClearSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tableClearTopDep != null ) && ( tableClearTopDep instanceof CFBamSybaseClearTopDepTable ) ) {
			CFBamSybaseClearTopDepTable table = (CFBamSybaseClearTopDepTable)tableClearTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableCluster != null ) && ( tableCluster instanceof CFBamSybaseClusterTable ) ) {
			CFBamSybaseClusterTable table = (CFBamSybaseClusterTable)tableCluster;
			table.releasePreparedStatements();
		}
		if( ( tableDataScope != null ) && ( tableDataScope instanceof CFBamSybaseDataScopeTable ) ) {
			CFBamSybaseDataScopeTable table = (CFBamSybaseDataScopeTable)tableDataScope;
			table.releasePreparedStatements();
		}
		if( ( tableDateCol != null ) && ( tableDateCol instanceof CFBamSybaseDateColTable ) ) {
			CFBamSybaseDateColTable table = (CFBamSybaseDateColTable)tableDateCol;
			table.releasePreparedStatements();
		}
		if( ( tableDateDef != null ) && ( tableDateDef instanceof CFBamSybaseDateDefTable ) ) {
			CFBamSybaseDateDefTable table = (CFBamSybaseDateDefTable)tableDateDef;
			table.releasePreparedStatements();
		}
		if( ( tableDateType != null ) && ( tableDateType instanceof CFBamSybaseDateTypeTable ) ) {
			CFBamSybaseDateTypeTable table = (CFBamSybaseDateTypeTable)tableDateType;
			table.releasePreparedStatements();
		}
		if( ( tableDelDep != null ) && ( tableDelDep instanceof CFBamSybaseDelDepTable ) ) {
			CFBamSybaseDelDepTable table = (CFBamSybaseDelDepTable)tableDelDep;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep1 != null ) && ( tableDelSubDep1 instanceof CFBamSybaseDelSubDep1Table ) ) {
			CFBamSybaseDelSubDep1Table table = (CFBamSybaseDelSubDep1Table)tableDelSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep2 != null ) && ( tableDelSubDep2 instanceof CFBamSybaseDelSubDep2Table ) ) {
			CFBamSybaseDelSubDep2Table table = (CFBamSybaseDelSubDep2Table)tableDelSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep3 != null ) && ( tableDelSubDep3 instanceof CFBamSybaseDelSubDep3Table ) ) {
			CFBamSybaseDelSubDep3Table table = (CFBamSybaseDelSubDep3Table)tableDelSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tableDelTopDep != null ) && ( tableDelTopDep instanceof CFBamSybaseDelTopDepTable ) ) {
			CFBamSybaseDelTopDepTable table = (CFBamSybaseDelTopDepTable)tableDelTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableDomain != null ) && ( tableDomain instanceof CFBamSybaseDomainTable ) ) {
			CFBamSybaseDomainTable table = (CFBamSybaseDomainTable)tableDomain;
			table.releasePreparedStatements();
		}
		if( ( tableDomainBase != null ) && ( tableDomainBase instanceof CFBamSybaseDomainBaseTable ) ) {
			CFBamSybaseDomainBaseTable table = (CFBamSybaseDomainBaseTable)tableDomainBase;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleCol != null ) && ( tableDoubleCol instanceof CFBamSybaseDoubleColTable ) ) {
			CFBamSybaseDoubleColTable table = (CFBamSybaseDoubleColTable)tableDoubleCol;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleDef != null ) && ( tableDoubleDef instanceof CFBamSybaseDoubleDefTable ) ) {
			CFBamSybaseDoubleDefTable table = (CFBamSybaseDoubleDefTable)tableDoubleDef;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleType != null ) && ( tableDoubleType instanceof CFBamSybaseDoubleTypeTable ) ) {
			CFBamSybaseDoubleTypeTable table = (CFBamSybaseDoubleTypeTable)tableDoubleType;
			table.releasePreparedStatements();
		}
		if( ( tableEnumCol != null ) && ( tableEnumCol instanceof CFBamSybaseEnumColTable ) ) {
			CFBamSybaseEnumColTable table = (CFBamSybaseEnumColTable)tableEnumCol;
			table.releasePreparedStatements();
		}
		if( ( tableEnumDef != null ) && ( tableEnumDef instanceof CFBamSybaseEnumDefTable ) ) {
			CFBamSybaseEnumDefTable table = (CFBamSybaseEnumDefTable)tableEnumDef;
			table.releasePreparedStatements();
		}
		if( ( tableEnumTag != null ) && ( tableEnumTag instanceof CFBamSybaseEnumTagTable ) ) {
			CFBamSybaseEnumTagTable table = (CFBamSybaseEnumTagTable)tableEnumTag;
			table.releasePreparedStatements();
		}
		if( ( tableEnumType != null ) && ( tableEnumType instanceof CFBamSybaseEnumTypeTable ) ) {
			CFBamSybaseEnumTypeTable table = (CFBamSybaseEnumTypeTable)tableEnumType;
			table.releasePreparedStatements();
		}
		if( ( tableFloatCol != null ) && ( tableFloatCol instanceof CFBamSybaseFloatColTable ) ) {
			CFBamSybaseFloatColTable table = (CFBamSybaseFloatColTable)tableFloatCol;
			table.releasePreparedStatements();
		}
		if( ( tableFloatDef != null ) && ( tableFloatDef instanceof CFBamSybaseFloatDefTable ) ) {
			CFBamSybaseFloatDefTable table = (CFBamSybaseFloatDefTable)tableFloatDef;
			table.releasePreparedStatements();
		}
		if( ( tableFloatType != null ) && ( tableFloatType instanceof CFBamSybaseFloatTypeTable ) ) {
			CFBamSybaseFloatTypeTable table = (CFBamSybaseFloatTypeTable)tableFloatType;
			table.releasePreparedStatements();
		}
		if( ( tableHostNode != null ) && ( tableHostNode instanceof CFBamSybaseHostNodeTable ) ) {
			CFBamSybaseHostNodeTable table = (CFBamSybaseHostNodeTable)tableHostNode;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountry != null ) && ( tableISOCountry instanceof CFBamSybaseISOCountryTable ) ) {
			CFBamSybaseISOCountryTable table = (CFBamSybaseISOCountryTable)tableISOCountry;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountryCurrency != null ) && ( tableISOCountryCurrency instanceof CFBamSybaseISOCountryCurrencyTable ) ) {
			CFBamSybaseISOCountryCurrencyTable table = (CFBamSybaseISOCountryCurrencyTable)tableISOCountryCurrency;
			table.releasePreparedStatements();
		}
		if( ( tableISOCountryLanguage != null ) && ( tableISOCountryLanguage instanceof CFBamSybaseISOCountryLanguageTable ) ) {
			CFBamSybaseISOCountryLanguageTable table = (CFBamSybaseISOCountryLanguageTable)tableISOCountryLanguage;
			table.releasePreparedStatements();
		}
		if( ( tableISOCurrency != null ) && ( tableISOCurrency instanceof CFBamSybaseISOCurrencyTable ) ) {
			CFBamSybaseISOCurrencyTable table = (CFBamSybaseISOCurrencyTable)tableISOCurrency;
			table.releasePreparedStatements();
		}
		if( ( tableISOLanguage != null ) && ( tableISOLanguage instanceof CFBamSybaseISOLanguageTable ) ) {
			CFBamSybaseISOLanguageTable table = (CFBamSybaseISOLanguageTable)tableISOLanguage;
			table.releasePreparedStatements();
		}
		if( ( tableISOTimezone != null ) && ( tableISOTimezone instanceof CFBamSybaseISOTimezoneTable ) ) {
			CFBamSybaseISOTimezoneTable table = (CFBamSybaseISOTimezoneTable)tableISOTimezone;
			table.releasePreparedStatements();
		}
		if( ( tableId16Gen != null ) && ( tableId16Gen instanceof CFBamSybaseId16GenTable ) ) {
			CFBamSybaseId16GenTable table = (CFBamSybaseId16GenTable)tableId16Gen;
			table.releasePreparedStatements();
		}
		if( ( tableId32Gen != null ) && ( tableId32Gen instanceof CFBamSybaseId32GenTable ) ) {
			CFBamSybaseId32GenTable table = (CFBamSybaseId32GenTable)tableId32Gen;
			table.releasePreparedStatements();
		}
		if( ( tableId64Gen != null ) && ( tableId64Gen instanceof CFBamSybaseId64GenTable ) ) {
			CFBamSybaseId64GenTable table = (CFBamSybaseId64GenTable)tableId64Gen;
			table.releasePreparedStatements();
		}
		if( ( tableIndex != null ) && ( tableIndex instanceof CFBamSybaseIndexTable ) ) {
			CFBamSybaseIndexTable table = (CFBamSybaseIndexTable)tableIndex;
			table.releasePreparedStatements();
		}
		if( ( tableIndexCol != null ) && ( tableIndexCol instanceof CFBamSybaseIndexColTable ) ) {
			CFBamSybaseIndexColTable table = (CFBamSybaseIndexColTable)tableIndexCol;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Col != null ) && ( tableInt16Col instanceof CFBamSybaseInt16ColTable ) ) {
			CFBamSybaseInt16ColTable table = (CFBamSybaseInt16ColTable)tableInt16Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Def != null ) && ( tableInt16Def instanceof CFBamSybaseInt16DefTable ) ) {
			CFBamSybaseInt16DefTable table = (CFBamSybaseInt16DefTable)tableInt16Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Type != null ) && ( tableInt16Type instanceof CFBamSybaseInt16TypeTable ) ) {
			CFBamSybaseInt16TypeTable table = (CFBamSybaseInt16TypeTable)tableInt16Type;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Col != null ) && ( tableInt32Col instanceof CFBamSybaseInt32ColTable ) ) {
			CFBamSybaseInt32ColTable table = (CFBamSybaseInt32ColTable)tableInt32Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Def != null ) && ( tableInt32Def instanceof CFBamSybaseInt32DefTable ) ) {
			CFBamSybaseInt32DefTable table = (CFBamSybaseInt32DefTable)tableInt32Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Type != null ) && ( tableInt32Type instanceof CFBamSybaseInt32TypeTable ) ) {
			CFBamSybaseInt32TypeTable table = (CFBamSybaseInt32TypeTable)tableInt32Type;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Col != null ) && ( tableInt64Col instanceof CFBamSybaseInt64ColTable ) ) {
			CFBamSybaseInt64ColTable table = (CFBamSybaseInt64ColTable)tableInt64Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Def != null ) && ( tableInt64Def instanceof CFBamSybaseInt64DefTable ) ) {
			CFBamSybaseInt64DefTable table = (CFBamSybaseInt64DefTable)tableInt64Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Type != null ) && ( tableInt64Type instanceof CFBamSybaseInt64TypeTable ) ) {
			CFBamSybaseInt64TypeTable table = (CFBamSybaseInt64TypeTable)tableInt64Type;
			table.releasePreparedStatements();
		}
		if( ( tableLicense != null ) && ( tableLicense instanceof CFBamSybaseLicenseTable ) ) {
			CFBamSybaseLicenseTable table = (CFBamSybaseLicenseTable)tableLicense;
			table.releasePreparedStatements();
		}
		if( ( tableLoaderBehaviour != null ) && ( tableLoaderBehaviour instanceof CFBamSybaseLoaderBehaviourTable ) ) {
			CFBamSybaseLoaderBehaviourTable table = (CFBamSybaseLoaderBehaviourTable)tableLoaderBehaviour;
			table.releasePreparedStatements();
		}
		if( ( tableMajorVersion != null ) && ( tableMajorVersion instanceof CFBamSybaseMajorVersionTable ) ) {
			CFBamSybaseMajorVersionTable table = (CFBamSybaseMajorVersionTable)tableMajorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableMimeType != null ) && ( tableMimeType instanceof CFBamSybaseMimeTypeTable ) ) {
			CFBamSybaseMimeTypeTable table = (CFBamSybaseMimeTypeTable)tableMimeType;
			table.releasePreparedStatements();
		}
		if( ( tableMinorVersion != null ) && ( tableMinorVersion instanceof CFBamSybaseMinorVersionTable ) ) {
			CFBamSybaseMinorVersionTable table = (CFBamSybaseMinorVersionTable)tableMinorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenCol != null ) && ( tableNmTokenCol instanceof CFBamSybaseNmTokenColTable ) ) {
			CFBamSybaseNmTokenColTable table = (CFBamSybaseNmTokenColTable)tableNmTokenCol;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenDef != null ) && ( tableNmTokenDef instanceof CFBamSybaseNmTokenDefTable ) ) {
			CFBamSybaseNmTokenDefTable table = (CFBamSybaseNmTokenDefTable)tableNmTokenDef;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenType != null ) && ( tableNmTokenType instanceof CFBamSybaseNmTokenTypeTable ) ) {
			CFBamSybaseNmTokenTypeTable table = (CFBamSybaseNmTokenTypeTable)tableNmTokenType;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensCol != null ) && ( tableNmTokensCol instanceof CFBamSybaseNmTokensColTable ) ) {
			CFBamSybaseNmTokensColTable table = (CFBamSybaseNmTokensColTable)tableNmTokensCol;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensDef != null ) && ( tableNmTokensDef instanceof CFBamSybaseNmTokensDefTable ) ) {
			CFBamSybaseNmTokensDefTable table = (CFBamSybaseNmTokensDefTable)tableNmTokensDef;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensType != null ) && ( tableNmTokensType instanceof CFBamSybaseNmTokensTypeTable ) ) {
			CFBamSybaseNmTokensTypeTable table = (CFBamSybaseNmTokensTypeTable)tableNmTokensType;
			table.releasePreparedStatements();
		}
		if( ( tableNumberCol != null ) && ( tableNumberCol instanceof CFBamSybaseNumberColTable ) ) {
			CFBamSybaseNumberColTable table = (CFBamSybaseNumberColTable)tableNumberCol;
			table.releasePreparedStatements();
		}
		if( ( tableNumberDef != null ) && ( tableNumberDef instanceof CFBamSybaseNumberDefTable ) ) {
			CFBamSybaseNumberDefTable table = (CFBamSybaseNumberDefTable)tableNumberDef;
			table.releasePreparedStatements();
		}
		if( ( tableNumberType != null ) && ( tableNumberType instanceof CFBamSybaseNumberTypeTable ) ) {
			CFBamSybaseNumberTypeTable table = (CFBamSybaseNumberTypeTable)tableNumberType;
			table.releasePreparedStatements();
		}
		if( ( tableParam != null ) && ( tableParam instanceof CFBamSybaseParamTable ) ) {
			CFBamSybaseParamTable table = (CFBamSybaseParamTable)tableParam;
			table.releasePreparedStatements();
		}
		if( ( tablePopDep != null ) && ( tablePopDep instanceof CFBamSybasePopDepTable ) ) {
			CFBamSybasePopDepTable table = (CFBamSybasePopDepTable)tablePopDep;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep1 != null ) && ( tablePopSubDep1 instanceof CFBamSybasePopSubDep1Table ) ) {
			CFBamSybasePopSubDep1Table table = (CFBamSybasePopSubDep1Table)tablePopSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep2 != null ) && ( tablePopSubDep2 instanceof CFBamSybasePopSubDep2Table ) ) {
			CFBamSybasePopSubDep2Table table = (CFBamSybasePopSubDep2Table)tablePopSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep3 != null ) && ( tablePopSubDep3 instanceof CFBamSybasePopSubDep3Table ) ) {
			CFBamSybasePopSubDep3Table table = (CFBamSybasePopSubDep3Table)tablePopSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tablePopTopDep != null ) && ( tablePopTopDep instanceof CFBamSybasePopTopDepTable ) ) {
			CFBamSybasePopTopDepTable table = (CFBamSybasePopTopDepTable)tablePopTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableProjectBase != null ) && ( tableProjectBase instanceof CFBamSybaseProjectBaseTable ) ) {
			CFBamSybaseProjectBaseTable table = (CFBamSybaseProjectBaseTable)tableProjectBase;
			table.releasePreparedStatements();
		}
		if( ( tableRealProject != null ) && ( tableRealProject instanceof CFBamSybaseRealProjectTable ) ) {
			CFBamSybaseRealProjectTable table = (CFBamSybaseRealProjectTable)tableRealProject;
			table.releasePreparedStatements();
		}
		if( ( tableRelation != null ) && ( tableRelation instanceof CFBamSybaseRelationTable ) ) {
			CFBamSybaseRelationTable table = (CFBamSybaseRelationTable)tableRelation;
			table.releasePreparedStatements();
		}
		if( ( tableRelationCol != null ) && ( tableRelationCol instanceof CFBamSybaseRelationColTable ) ) {
			CFBamSybaseRelationColTable table = (CFBamSybaseRelationColTable)tableRelationCol;
			table.releasePreparedStatements();
		}
		if( ( tableRelationType != null ) && ( tableRelationType instanceof CFBamSybaseRelationTypeTable ) ) {
			CFBamSybaseRelationTypeTable table = (CFBamSybaseRelationTypeTable)tableRelationType;
			table.releasePreparedStatements();
		}
		if( ( tableSchemaDef != null ) && ( tableSchemaDef instanceof CFBamSybaseSchemaDefTable ) ) {
			CFBamSybaseSchemaDefTable table = (CFBamSybaseSchemaDefTable)tableSchemaDef;
			table.releasePreparedStatements();
		}
		if( ( tableSchemaRef != null ) && ( tableSchemaRef instanceof CFBamSybaseSchemaRefTable ) ) {
			CFBamSybaseSchemaRefTable table = (CFBamSybaseSchemaRefTable)tableSchemaRef;
			table.releasePreparedStatements();
		}
		if( ( tableScope != null ) && ( tableScope instanceof CFBamSybaseScopeTable ) ) {
			CFBamSybaseScopeTable table = (CFBamSybaseScopeTable)tableScope;
			table.releasePreparedStatements();
		}
		if( ( tableSecApp != null ) && ( tableSecApp instanceof CFBamSybaseSecAppTable ) ) {
			CFBamSybaseSecAppTable table = (CFBamSybaseSecAppTable)tableSecApp;
			table.releasePreparedStatements();
		}
		if( ( tableSecDevice != null ) && ( tableSecDevice instanceof CFBamSybaseSecDeviceTable ) ) {
			CFBamSybaseSecDeviceTable table = (CFBamSybaseSecDeviceTable)tableSecDevice;
			table.releasePreparedStatements();
		}
		if( ( tableSecForm != null ) && ( tableSecForm instanceof CFBamSybaseSecFormTable ) ) {
			CFBamSybaseSecFormTable table = (CFBamSybaseSecFormTable)tableSecForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroup != null ) && ( tableSecGroup instanceof CFBamSybaseSecGroupTable ) ) {
			CFBamSybaseSecGroupTable table = (CFBamSybaseSecGroupTable)tableSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupForm != null ) && ( tableSecGroupForm instanceof CFBamSybaseSecGroupFormTable ) ) {
			CFBamSybaseSecGroupFormTable table = (CFBamSybaseSecGroupFormTable)tableSecGroupForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupInclude != null ) && ( tableSecGroupInclude instanceof CFBamSybaseSecGroupIncludeTable ) ) {
			CFBamSybaseSecGroupIncludeTable table = (CFBamSybaseSecGroupIncludeTable)tableSecGroupInclude;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupMember != null ) && ( tableSecGroupMember instanceof CFBamSybaseSecGroupMemberTable ) ) {
			CFBamSybaseSecGroupMemberTable table = (CFBamSybaseSecGroupMemberTable)tableSecGroupMember;
			table.releasePreparedStatements();
		}
		if( ( tableSecSession != null ) && ( tableSecSession instanceof CFBamSybaseSecSessionTable ) ) {
			CFBamSybaseSecSessionTable table = (CFBamSybaseSecSessionTable)tableSecSession;
			table.releasePreparedStatements();
		}
		if( ( tableSecUser != null ) && ( tableSecUser instanceof CFBamSybaseSecUserTable ) ) {
			CFBamSybaseSecUserTable table = (CFBamSybaseSecUserTable)tableSecUser;
			table.releasePreparedStatements();
		}
		if( ( tableSecurityScope != null ) && ( tableSecurityScope instanceof CFBamSybaseSecurityScopeTable ) ) {
			CFBamSybaseSecurityScopeTable table = (CFBamSybaseSecurityScopeTable)tableSecurityScope;
			table.releasePreparedStatements();
		}
		if( ( tableServerListFunc != null ) && ( tableServerListFunc instanceof CFBamSybaseServerListFuncTable ) ) {
			CFBamSybaseServerListFuncTable table = (CFBamSybaseServerListFuncTable)tableServerListFunc;
			table.releasePreparedStatements();
		}
		if( ( tableServerMethod != null ) && ( tableServerMethod instanceof CFBamSybaseServerMethodTable ) ) {
			CFBamSybaseServerMethodTable table = (CFBamSybaseServerMethodTable)tableServerMethod;
			table.releasePreparedStatements();
		}
		if( ( tableServerObjFunc != null ) && ( tableServerObjFunc instanceof CFBamSybaseServerObjFuncTable ) ) {
			CFBamSybaseServerObjFuncTable table = (CFBamSybaseServerObjFuncTable)tableServerObjFunc;
			table.releasePreparedStatements();
		}
		if( ( tableServerProc != null ) && ( tableServerProc instanceof CFBamSybaseServerProcTable ) ) {
			CFBamSybaseServerProcTable table = (CFBamSybaseServerProcTable)tableServerProc;
			table.releasePreparedStatements();
		}
		if( ( tableService != null ) && ( tableService instanceof CFBamSybaseServiceTable ) ) {
			CFBamSybaseServiceTable table = (CFBamSybaseServiceTable)tableService;
			table.releasePreparedStatements();
		}
		if( ( tableServiceType != null ) && ( tableServiceType instanceof CFBamSybaseServiceTypeTable ) ) {
			CFBamSybaseServiceTypeTable table = (CFBamSybaseServiceTypeTable)tableServiceType;
			table.releasePreparedStatements();
		}
		if( ( tableStringCol != null ) && ( tableStringCol instanceof CFBamSybaseStringColTable ) ) {
			CFBamSybaseStringColTable table = (CFBamSybaseStringColTable)tableStringCol;
			table.releasePreparedStatements();
		}
		if( ( tableStringDef != null ) && ( tableStringDef instanceof CFBamSybaseStringDefTable ) ) {
			CFBamSybaseStringDefTable table = (CFBamSybaseStringDefTable)tableStringDef;
			table.releasePreparedStatements();
		}
		if( ( tableStringType != null ) && ( tableStringType instanceof CFBamSybaseStringTypeTable ) ) {
			CFBamSybaseStringTypeTable table = (CFBamSybaseStringTypeTable)tableStringType;
			table.releasePreparedStatements();
		}
		if( ( tableSubProject != null ) && ( tableSubProject instanceof CFBamSybaseSubProjectTable ) ) {
			CFBamSybaseSubProjectTable table = (CFBamSybaseSubProjectTable)tableSubProject;
			table.releasePreparedStatements();
		}
		if( ( tableSysCluster != null ) && ( tableSysCluster instanceof CFBamSybaseSysClusterTable ) ) {
			CFBamSybaseSysClusterTable table = (CFBamSybaseSysClusterTable)tableSysCluster;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroup != null ) && ( tableTSecGroup instanceof CFBamSybaseTSecGroupTable ) ) {
			CFBamSybaseTSecGroupTable table = (CFBamSybaseTSecGroupTable)tableTSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroupInclude != null ) && ( tableTSecGroupInclude instanceof CFBamSybaseTSecGroupIncludeTable ) ) {
			CFBamSybaseTSecGroupIncludeTable table = (CFBamSybaseTSecGroupIncludeTable)tableTSecGroupInclude;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroupMember != null ) && ( tableTSecGroupMember instanceof CFBamSybaseTSecGroupMemberTable ) ) {
			CFBamSybaseTSecGroupMemberTable table = (CFBamSybaseTSecGroupMemberTable)tableTSecGroupMember;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateCol != null ) && ( tableTZDateCol instanceof CFBamSybaseTZDateColTable ) ) {
			CFBamSybaseTZDateColTable table = (CFBamSybaseTZDateColTable)tableTZDateCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateDef != null ) && ( tableTZDateDef instanceof CFBamSybaseTZDateDefTable ) ) {
			CFBamSybaseTZDateDefTable table = (CFBamSybaseTZDateDefTable)tableTZDateDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateType != null ) && ( tableTZDateType instanceof CFBamSybaseTZDateTypeTable ) ) {
			CFBamSybaseTZDateTypeTable table = (CFBamSybaseTZDateTypeTable)tableTZDateType;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeCol != null ) && ( tableTZTimeCol instanceof CFBamSybaseTZTimeColTable ) ) {
			CFBamSybaseTZTimeColTable table = (CFBamSybaseTZTimeColTable)tableTZTimeCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeDef != null ) && ( tableTZTimeDef instanceof CFBamSybaseTZTimeDefTable ) ) {
			CFBamSybaseTZTimeDefTable table = (CFBamSybaseTZTimeDefTable)tableTZTimeDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeType != null ) && ( tableTZTimeType instanceof CFBamSybaseTZTimeTypeTable ) ) {
			CFBamSybaseTZTimeTypeTable table = (CFBamSybaseTZTimeTypeTable)tableTZTimeType;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampCol != null ) && ( tableTZTimestampCol instanceof CFBamSybaseTZTimestampColTable ) ) {
			CFBamSybaseTZTimestampColTable table = (CFBamSybaseTZTimestampColTable)tableTZTimestampCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampDef != null ) && ( tableTZTimestampDef instanceof CFBamSybaseTZTimestampDefTable ) ) {
			CFBamSybaseTZTimestampDefTable table = (CFBamSybaseTZTimestampDefTable)tableTZTimestampDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampType != null ) && ( tableTZTimestampType instanceof CFBamSybaseTZTimestampTypeTable ) ) {
			CFBamSybaseTZTimestampTypeTable table = (CFBamSybaseTZTimestampTypeTable)tableTZTimestampType;
			table.releasePreparedStatements();
		}
		if( ( tableTable != null ) && ( tableTable instanceof CFBamSybaseTableTable ) ) {
			CFBamSybaseTableTable table = (CFBamSybaseTableTable)tableTable;
			table.releasePreparedStatements();
		}
		if( ( tableTableCol != null ) && ( tableTableCol instanceof CFBamSybaseTableColTable ) ) {
			CFBamSybaseTableColTable table = (CFBamSybaseTableColTable)tableTableCol;
			table.releasePreparedStatements();
		}
		if( ( tableTenant != null ) && ( tableTenant instanceof CFBamSybaseTenantTable ) ) {
			CFBamSybaseTenantTable table = (CFBamSybaseTenantTable)tableTenant;
			table.releasePreparedStatements();
		}
		if( ( tableTextCol != null ) && ( tableTextCol instanceof CFBamSybaseTextColTable ) ) {
			CFBamSybaseTextColTable table = (CFBamSybaseTextColTable)tableTextCol;
			table.releasePreparedStatements();
		}
		if( ( tableTextDef != null ) && ( tableTextDef instanceof CFBamSybaseTextDefTable ) ) {
			CFBamSybaseTextDefTable table = (CFBamSybaseTextDefTable)tableTextDef;
			table.releasePreparedStatements();
		}
		if( ( tableTextType != null ) && ( tableTextType instanceof CFBamSybaseTextTypeTable ) ) {
			CFBamSybaseTextTypeTable table = (CFBamSybaseTextTypeTable)tableTextType;
			table.releasePreparedStatements();
		}
		if( ( tableTimeCol != null ) && ( tableTimeCol instanceof CFBamSybaseTimeColTable ) ) {
			CFBamSybaseTimeColTable table = (CFBamSybaseTimeColTable)tableTimeCol;
			table.releasePreparedStatements();
		}
		if( ( tableTimeDef != null ) && ( tableTimeDef instanceof CFBamSybaseTimeDefTable ) ) {
			CFBamSybaseTimeDefTable table = (CFBamSybaseTimeDefTable)tableTimeDef;
			table.releasePreparedStatements();
		}
		if( ( tableTimeType != null ) && ( tableTimeType instanceof CFBamSybaseTimeTypeTable ) ) {
			CFBamSybaseTimeTypeTable table = (CFBamSybaseTimeTypeTable)tableTimeType;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampCol != null ) && ( tableTimestampCol instanceof CFBamSybaseTimestampColTable ) ) {
			CFBamSybaseTimestampColTable table = (CFBamSybaseTimestampColTable)tableTimestampCol;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampDef != null ) && ( tableTimestampDef instanceof CFBamSybaseTimestampDefTable ) ) {
			CFBamSybaseTimestampDefTable table = (CFBamSybaseTimestampDefTable)tableTimestampDef;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampType != null ) && ( tableTimestampType instanceof CFBamSybaseTimestampTypeTable ) ) {
			CFBamSybaseTimestampTypeTable table = (CFBamSybaseTimestampTypeTable)tableTimestampType;
			table.releasePreparedStatements();
		}
		if( ( tableTld != null ) && ( tableTld instanceof CFBamSybaseTldTable ) ) {
			CFBamSybaseTldTable table = (CFBamSybaseTldTable)tableTld;
			table.releasePreparedStatements();
		}
		if( ( tableTokenCol != null ) && ( tableTokenCol instanceof CFBamSybaseTokenColTable ) ) {
			CFBamSybaseTokenColTable table = (CFBamSybaseTokenColTable)tableTokenCol;
			table.releasePreparedStatements();
		}
		if( ( tableTokenDef != null ) && ( tableTokenDef instanceof CFBamSybaseTokenDefTable ) ) {
			CFBamSybaseTokenDefTable table = (CFBamSybaseTokenDefTable)tableTokenDef;
			table.releasePreparedStatements();
		}
		if( ( tableTokenType != null ) && ( tableTokenType instanceof CFBamSybaseTokenTypeTable ) ) {
			CFBamSybaseTokenTypeTable table = (CFBamSybaseTokenTypeTable)tableTokenType;
			table.releasePreparedStatements();
		}
		if( ( tableTopDomain != null ) && ( tableTopDomain instanceof CFBamSybaseTopDomainTable ) ) {
			CFBamSybaseTopDomainTable table = (CFBamSybaseTopDomainTable)tableTopDomain;
			table.releasePreparedStatements();
		}
		if( ( tableTopProject != null ) && ( tableTopProject instanceof CFBamSybaseTopProjectTable ) ) {
			CFBamSybaseTopProjectTable table = (CFBamSybaseTopProjectTable)tableTopProject;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Col != null ) && ( tableUInt16Col instanceof CFBamSybaseUInt16ColTable ) ) {
			CFBamSybaseUInt16ColTable table = (CFBamSybaseUInt16ColTable)tableUInt16Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Def != null ) && ( tableUInt16Def instanceof CFBamSybaseUInt16DefTable ) ) {
			CFBamSybaseUInt16DefTable table = (CFBamSybaseUInt16DefTable)tableUInt16Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Type != null ) && ( tableUInt16Type instanceof CFBamSybaseUInt16TypeTable ) ) {
			CFBamSybaseUInt16TypeTable table = (CFBamSybaseUInt16TypeTable)tableUInt16Type;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Col != null ) && ( tableUInt32Col instanceof CFBamSybaseUInt32ColTable ) ) {
			CFBamSybaseUInt32ColTable table = (CFBamSybaseUInt32ColTable)tableUInt32Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Def != null ) && ( tableUInt32Def instanceof CFBamSybaseUInt32DefTable ) ) {
			CFBamSybaseUInt32DefTable table = (CFBamSybaseUInt32DefTable)tableUInt32Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Type != null ) && ( tableUInt32Type instanceof CFBamSybaseUInt32TypeTable ) ) {
			CFBamSybaseUInt32TypeTable table = (CFBamSybaseUInt32TypeTable)tableUInt32Type;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Col != null ) && ( tableUInt64Col instanceof CFBamSybaseUInt64ColTable ) ) {
			CFBamSybaseUInt64ColTable table = (CFBamSybaseUInt64ColTable)tableUInt64Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Def != null ) && ( tableUInt64Def instanceof CFBamSybaseUInt64DefTable ) ) {
			CFBamSybaseUInt64DefTable table = (CFBamSybaseUInt64DefTable)tableUInt64Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Type != null ) && ( tableUInt64Type instanceof CFBamSybaseUInt64TypeTable ) ) {
			CFBamSybaseUInt64TypeTable table = (CFBamSybaseUInt64TypeTable)tableUInt64Type;
			table.releasePreparedStatements();
		}
		if( ( tableURLProtocol != null ) && ( tableURLProtocol instanceof CFBamSybaseURLProtocolTable ) ) {
			CFBamSybaseURLProtocolTable table = (CFBamSybaseURLProtocolTable)tableURLProtocol;
			table.releasePreparedStatements();
		}
		if( ( tableUuidCol != null ) && ( tableUuidCol instanceof CFBamSybaseUuidColTable ) ) {
			CFBamSybaseUuidColTable table = (CFBamSybaseUuidColTable)tableUuidCol;
			table.releasePreparedStatements();
		}
		if( ( tableUuidDef != null ) && ( tableUuidDef instanceof CFBamSybaseUuidDefTable ) ) {
			CFBamSybaseUuidDefTable table = (CFBamSybaseUuidDefTable)tableUuidDef;
			table.releasePreparedStatements();
		}
		if( ( tableUuidGen != null ) && ( tableUuidGen instanceof CFBamSybaseUuidGenTable ) ) {
			CFBamSybaseUuidGenTable table = (CFBamSybaseUuidGenTable)tableUuidGen;
			table.releasePreparedStatements();
		}
		if( ( tableUuidType != null ) && ( tableUuidType instanceof CFBamSybaseUuidTypeTable ) ) {
			CFBamSybaseUuidTypeTable table = (CFBamSybaseUuidTypeTable)tableUuidType;
			table.releasePreparedStatements();
		}
		if( ( tableValue != null ) && ( tableValue instanceof CFBamSybaseValueTable ) ) {
			CFBamSybaseValueTable table = (CFBamSybaseValueTable)tableValue;
			table.releasePreparedStatements();
		}
		if( ( tableVersion != null ) && ( tableVersion instanceof CFBamSybaseVersionTable ) ) {
			CFBamSybaseVersionTable table = (CFBamSybaseVersionTable)tableVersion;
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamSybaseSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamSybaseSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamSybaseSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamSybaseSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamSybaseSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamSybaseSchema.class,
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
			throw CFLib.getDefaultExceptionFactory().newDbException( CFBamSybaseSchema.class,
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
			buff.append( "T" );
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
			Calendar cal;
			if( val.getTimeZone().equals( getServerTimeZone() ) ) {
				cal = val;
			}
			else {
				cal = new GregorianCalendar( getServerTimeZone() );
				cal.setTimeInMillis( val.getTimeInMillis() );
			}
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", cal.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "T" );
			fmt.format( "%1$02d", cal.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.SECOND ) );
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
			Calendar cal;
			if( val.getTimeZone().equals( getServerTimeZone() ) ) {
				cal = val;
			}
			else {
				cal = new GregorianCalendar( getServerTimeZone() );
				cal.setTimeInMillis( val.getTimeInMillis() );
			}
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", cal.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "T" );
			fmt.format( "%1$02d", cal.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.SECOND ) );
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
			Calendar cal;
			if( val.getTimeZone().equals( getServerTimeZone() ) ) {
				cal = val;
			}
			else {
				cal = new GregorianCalendar( getServerTimeZone() );
				cal.setTimeInMillis( val.getTimeInMillis() );
			}
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", cal.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "T" );
			fmt.format( "%1$02d", cal.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.SECOND ) );
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
			fmt.format( "%1$04d", val.get( Calendar.YEAR ) );
			fmt.format( "%1$02d", val.get( Calendar.MONTH ) + 1 );
			fmt.format( "%1$02d", val.get( Calendar.DAY_OF_MONTH ) );
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
			fmt.format( "%1$02d", val.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", val.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", val.get( Calendar.SECOND ) );
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
			fmt.format( "%1$04d", val.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", val.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", val.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "T" );
			fmt.format( "%1$02d", val.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", val.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", val.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar cal;
			if( val.getTimeZone().equals( getServerTimeZone() ) ) {
				cal = val;
			}
			else {
				cal = new GregorianCalendar( getServerTimeZone() );
				cal.setTimeInMillis( val.getTimeInMillis() );
			}
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", cal.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "T" );
			fmt.format( "%1$02d", cal.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar cal;
			if( val.getTimeZone().equals( getServerTimeZone() ) ) {
				cal = val;
			}
			else {
				cal = new GregorianCalendar( getServerTimeZone() );
				cal.setTimeInMillis( val.getTimeInMillis() );
			}
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", cal.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "T" );
			fmt.format( "%1$02d", cal.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar cal;
			if( val.getTimeZone().equals( getServerTimeZone() ) ) {
				cal = val;
			}
			else {
				cal = new GregorianCalendar( getServerTimeZone() );
				cal.setTimeInMillis( val.getTimeInMillis() );
			}
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", cal.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", cal.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "T" );
			fmt.format( "%1$02d", cal.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", cal.get( Calendar.SECOND ) );
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
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
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
			Calendar retval = new GregorianCalendar( getServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR, 0 );
			retval.set( Calendar.MINUTE, 0 );
			retval.set( Calendar.SECOND, 0 );
			retval.getTimeInMillis(); // Force update calculations
			return( retval );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
				"convertDateString",
            	"Value must be in YYYYMMDD format, \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 8 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
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
			Calendar retval = new GregorianCalendar( getServerTimeZone() );
			retval.set( Calendar.YEAR, 1 );
			retval.set( Calendar.MONTH, 0 );
			retval.set( Calendar.DAY_OF_MONTH, 1 );
			retval.set( Calendar.HOUR, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			retval.getTimeInMillis(); // Force update calculations
			return( retval );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
				"convertTimeString",
            	"Value must be in HH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}
	public static Calendar convertTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
				"convertTimestampString",
            	"Value must be in YYYY-MM-DDTHH24:MI:SS format \"" + val + "\" is invalid" );
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
			 && (val.charAt( 10 ) == 'T' )
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
			Calendar retval = new GregorianCalendar( getServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			retval.getTimeInMillis(); // Force update calculations
			return( retval );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
				"convertTimestampString",
            	"Value must be in YYYY-MM-DDTHH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
				"convertTZDateString",
            	"Value must be in YYYY-MM-DDTHH24:MI:SS format \"" + val + "\" is invalid" );
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
			 && (val.charAt( 10 ) == 'T' )
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
			Calendar retval = new GregorianCalendar( getServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			retval.getTimeInMillis(); // Force update calculations
			return( retval );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
				"convertTZDateString",
            	"Value must be in YYYY-MM-DDTHH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
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
			 && (val.charAt( 10 ) == 'T' )
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
			Calendar retval = new GregorianCalendar( getServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			retval.getTimeInMillis(); // Force update calculations
			return( retval );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
				"convertTZTimeString",
            	"Value must be in YYYY-MM-DDTHH24:MI:SS format \"" + val + "\" is invalid" );
        }
	}

	public static Calendar convertTZTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
        else if ( val.length() != 19 ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
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
			 && (val.charAt( 10 ) == 'T' )
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
			Calendar retval = new GregorianCalendar( getServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			retval.getTimeInMillis(); // Force update calculations
			return( retval );
        }
        else {
			throw CFLib.getDefaultExceptionFactory().newUsageException( CFBamSybaseSchema.class,
				"convertTZTimestampString",
            	"Value must be in YYYY-MM-DDTHH24:MI:SS format \"" + val + "\" is invalid" );
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
