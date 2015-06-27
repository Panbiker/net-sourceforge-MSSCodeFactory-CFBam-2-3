// Description: Java7 implementation of an in-memory RAM CFBam schema.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamRam;

import java.lang.reflect.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

/**
 *	TODO There is a limitation to the current Ram implementation.
 *	<p>
 *	Updates do not currently refresh all of the indexes properly.
 *	I need to restructure code for that to happen, but I really
 *	don't have time for it right now.  It works well enough for
 *	the MSS Code Factory runtime, and I'll have to leave it at
 *	that for now.
 *	<p>
 *	There is no similar in-memory structure for RDBMS persistance
 *	implementations -- the databases behind them maintain the indexes
 *	as part of the SQL transactional contract.
 *	<p>
 *	The current implementation should be used on an insert-only fashion.
 *	If you update any data, it cannot be referenced by an index, or the
 *	index will be corrupted.
 */
public class CFBamRamSchema
	extends CFBamSchema
{
		protected int nextServiceTypeIdGenValue = 1;
		protected int nextMimeTypeIdGenValue = 1;
		protected long nextClusterIdGenValue = 1;
		protected long nextTenantIdGenValue = 1;


	public CFBamRamSchema() {
		super();
		tableAccessFrequency = new CFBamRamAccessFrequencyTable( this );
		tableAccessSecurity = new CFBamRamAccessSecurityTable( this );
		tableAtom = new CFBamRamAtomTable( this );
		tableAuditAction = new CFBamRamAuditActionTable( this );
		tableBlobCol = new CFBamRamBlobColTable( this );
		tableBlobDef = new CFBamRamBlobDefTable( this );
		tableBlobType = new CFBamRamBlobTypeTable( this );
		tableBoolCol = new CFBamRamBoolColTable( this );
		tableBoolDef = new CFBamRamBoolDefTable( this );
		tableBoolType = new CFBamRamBoolTypeTable( this );
		tableChain = new CFBamRamChainTable( this );
		tableClearDep = new CFBamRamClearDepTable( this );
		tableClearSubDep1 = new CFBamRamClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamRamClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamRamClearSubDep3Table( this );
		tableClearTopDep = new CFBamRamClearTopDepTable( this );
		tableCluster = new CFBamRamClusterTable( this );
		tableDataScope = new CFBamRamDataScopeTable( this );
		tableDateCol = new CFBamRamDateColTable( this );
		tableDateDef = new CFBamRamDateDefTable( this );
		tableDateType = new CFBamRamDateTypeTable( this );
		tableDelDep = new CFBamRamDelDepTable( this );
		tableDelSubDep1 = new CFBamRamDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamRamDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamRamDelSubDep3Table( this );
		tableDelTopDep = new CFBamRamDelTopDepTable( this );
		tableDomain = new CFBamRamDomainTable( this );
		tableDomainBase = new CFBamRamDomainBaseTable( this );
		tableDoubleCol = new CFBamRamDoubleColTable( this );
		tableDoubleDef = new CFBamRamDoubleDefTable( this );
		tableDoubleType = new CFBamRamDoubleTypeTable( this );
		tableEnumCol = new CFBamRamEnumColTable( this );
		tableEnumDef = new CFBamRamEnumDefTable( this );
		tableEnumTag = new CFBamRamEnumTagTable( this );
		tableEnumType = new CFBamRamEnumTypeTable( this );
		tableFloatCol = new CFBamRamFloatColTable( this );
		tableFloatDef = new CFBamRamFloatDefTable( this );
		tableFloatType = new CFBamRamFloatTypeTable( this );
		tableHostNode = new CFBamRamHostNodeTable( this );
		tableISOCountry = new CFBamRamISOCountryTable( this );
		tableISOCountryCurrency = new CFBamRamISOCountryCurrencyTable( this );
		tableISOCountryLanguage = new CFBamRamISOCountryLanguageTable( this );
		tableISOCurrency = new CFBamRamISOCurrencyTable( this );
		tableISOLanguage = new CFBamRamISOLanguageTable( this );
		tableISOTimezone = new CFBamRamISOTimezoneTable( this );
		tableId16Gen = new CFBamRamId16GenTable( this );
		tableId32Gen = new CFBamRamId32GenTable( this );
		tableId64Gen = new CFBamRamId64GenTable( this );
		tableIndex = new CFBamRamIndexTable( this );
		tableIndexCol = new CFBamRamIndexColTable( this );
		tableInt16Col = new CFBamRamInt16ColTable( this );
		tableInt16Def = new CFBamRamInt16DefTable( this );
		tableInt16Type = new CFBamRamInt16TypeTable( this );
		tableInt32Col = new CFBamRamInt32ColTable( this );
		tableInt32Def = new CFBamRamInt32DefTable( this );
		tableInt32Type = new CFBamRamInt32TypeTable( this );
		tableInt64Col = new CFBamRamInt64ColTable( this );
		tableInt64Def = new CFBamRamInt64DefTable( this );
		tableInt64Type = new CFBamRamInt64TypeTable( this );
		tableLicense = new CFBamRamLicenseTable( this );
		tableLoaderBehaviour = new CFBamRamLoaderBehaviourTable( this );
		tableMajorVersion = new CFBamRamMajorVersionTable( this );
		tableMimeType = new CFBamRamMimeTypeTable( this );
		tableMinorVersion = new CFBamRamMinorVersionTable( this );
		tableNmTokenCol = new CFBamRamNmTokenColTable( this );
		tableNmTokenDef = new CFBamRamNmTokenDefTable( this );
		tableNmTokenType = new CFBamRamNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamRamNmTokensColTable( this );
		tableNmTokensDef = new CFBamRamNmTokensDefTable( this );
		tableNmTokensType = new CFBamRamNmTokensTypeTable( this );
		tableNumberCol = new CFBamRamNumberColTable( this );
		tableNumberDef = new CFBamRamNumberDefTable( this );
		tableNumberType = new CFBamRamNumberTypeTable( this );
		tableParam = new CFBamRamParamTable( this );
		tablePopDep = new CFBamRamPopDepTable( this );
		tablePopSubDep1 = new CFBamRamPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamRamPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamRamPopSubDep3Table( this );
		tablePopTopDep = new CFBamRamPopTopDepTable( this );
		tableProjectBase = new CFBamRamProjectBaseTable( this );
		tableRealProject = new CFBamRamRealProjectTable( this );
		tableRelation = new CFBamRamRelationTable( this );
		tableRelationCol = new CFBamRamRelationColTable( this );
		tableRelationType = new CFBamRamRelationTypeTable( this );
		tableSchemaDef = new CFBamRamSchemaDefTable( this );
		tableSchemaRef = new CFBamRamSchemaRefTable( this );
		tableScope = new CFBamRamScopeTable( this );
		tableSecApp = new CFBamRamSecAppTable( this );
		tableSecDevice = new CFBamRamSecDeviceTable( this );
		tableSecForm = new CFBamRamSecFormTable( this );
		tableSecGroup = new CFBamRamSecGroupTable( this );
		tableSecGroupForm = new CFBamRamSecGroupFormTable( this );
		tableSecGroupInclude = new CFBamRamSecGroupIncludeTable( this );
		tableSecGroupMember = new CFBamRamSecGroupMemberTable( this );
		tableSecSession = new CFBamRamSecSessionTable( this );
		tableSecUser = new CFBamRamSecUserTable( this );
		tableSecurityScope = new CFBamRamSecurityScopeTable( this );
		tableServerListFunc = new CFBamRamServerListFuncTable( this );
		tableServerMethod = new CFBamRamServerMethodTable( this );
		tableServerObjFunc = new CFBamRamServerObjFuncTable( this );
		tableServerProc = new CFBamRamServerProcTable( this );
		tableService = new CFBamRamServiceTable( this );
		tableServiceType = new CFBamRamServiceTypeTable( this );
		tableStringCol = new CFBamRamStringColTable( this );
		tableStringDef = new CFBamRamStringDefTable( this );
		tableStringType = new CFBamRamStringTypeTable( this );
		tableSubProject = new CFBamRamSubProjectTable( this );
		tableSysCluster = new CFBamRamSysClusterTable( this );
		tableTSecGroup = new CFBamRamTSecGroupTable( this );
		tableTSecGroupInclude = new CFBamRamTSecGroupIncludeTable( this );
		tableTSecGroupMember = new CFBamRamTSecGroupMemberTable( this );
		tableTZDateCol = new CFBamRamTZDateColTable( this );
		tableTZDateDef = new CFBamRamTZDateDefTable( this );
		tableTZDateType = new CFBamRamTZDateTypeTable( this );
		tableTZTimeCol = new CFBamRamTZTimeColTable( this );
		tableTZTimeDef = new CFBamRamTZTimeDefTable( this );
		tableTZTimeType = new CFBamRamTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamRamTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamRamTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamRamTZTimestampTypeTable( this );
		tableTable = new CFBamRamTableTable( this );
		tableTableCol = new CFBamRamTableColTable( this );
		tableTenant = new CFBamRamTenantTable( this );
		tableTextCol = new CFBamRamTextColTable( this );
		tableTextDef = new CFBamRamTextDefTable( this );
		tableTextType = new CFBamRamTextTypeTable( this );
		tableTimeCol = new CFBamRamTimeColTable( this );
		tableTimeDef = new CFBamRamTimeDefTable( this );
		tableTimeType = new CFBamRamTimeTypeTable( this );
		tableTimestampCol = new CFBamRamTimestampColTable( this );
		tableTimestampDef = new CFBamRamTimestampDefTable( this );
		tableTimestampType = new CFBamRamTimestampTypeTable( this );
		tableTld = new CFBamRamTldTable( this );
		tableTokenCol = new CFBamRamTokenColTable( this );
		tableTokenDef = new CFBamRamTokenDefTable( this );
		tableTokenType = new CFBamRamTokenTypeTable( this );
		tableTopDomain = new CFBamRamTopDomainTable( this );
		tableTopProject = new CFBamRamTopProjectTable( this );
		tableUInt16Col = new CFBamRamUInt16ColTable( this );
		tableUInt16Def = new CFBamRamUInt16DefTable( this );
		tableUInt16Type = new CFBamRamUInt16TypeTable( this );
		tableUInt32Col = new CFBamRamUInt32ColTable( this );
		tableUInt32Def = new CFBamRamUInt32DefTable( this );
		tableUInt32Type = new CFBamRamUInt32TypeTable( this );
		tableUInt64Col = new CFBamRamUInt64ColTable( this );
		tableUInt64Def = new CFBamRamUInt64DefTable( this );
		tableUInt64Type = new CFBamRamUInt64TypeTable( this );
		tableURLProtocol = new CFBamRamURLProtocolTable( this );
		tableUuidCol = new CFBamRamUuidColTable( this );
		tableUuidDef = new CFBamRamUuidDefTable( this );
		tableUuidGen = new CFBamRamUuidGenTable( this );
		tableUuidType = new CFBamRamUuidTypeTable( this );
		tableValue = new CFBamRamValueTable( this );
		tableVersion = new CFBamRamVersionTable( this );
	}

	public boolean isConnected() {
		return( true );
	}

	public boolean connect() {
		return( false );
	}

	public boolean connect( String username, String password ) {
		return( false );
	}

	public void disconnect( boolean doCommit ) {
		// Do nothing -- you can't disconnect an in-memory database
	}

	//	Transactions are not supported, so pretend there is always one open

	public boolean isTransactionOpen() {
		return( true );
	}

	public boolean beginTransaction() {
		return( false );
	}

	public void commit() {
	}

	public void rollback() {
	}

	public ICFBamSchema newSchema() {
		throw CFLib.getDefaultExceptionFactory().newMustOverrideException( getClass(), "newSchema" );
	}

	public int nextServiceTypeIdGen() {
		int next = nextServiceTypeIdGenValue++;
		return( next );
	}

	public int nextMimeTypeIdGen() {
		int next = nextMimeTypeIdGenValue++;
		return( next );
	}

	public long nextClusterIdGen() {
		long next = nextClusterIdGenValue++;
		return( next );
	}

	public long nextTenantIdGen() {
		long next = nextTenantIdGenValue++;
		return( next );
	}

	public UUID nextSecSessionIdGen() {
		UUID next = UUID.randomUUID();
		return( next );
	}

	public UUID nextSecUserIdGen() {
		UUID next = UUID.randomUUID();
		return( next );
	}

	public void releasePreparedStatements() {
	}
}
