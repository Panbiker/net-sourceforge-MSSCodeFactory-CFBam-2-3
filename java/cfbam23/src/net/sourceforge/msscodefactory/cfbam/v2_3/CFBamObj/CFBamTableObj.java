// Description: Java7 base object instance implementation for CFBam Table.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public class CFBamTableObj
	extends CFBamScopeObj
	implements ICFBamTableObj
{
	public final static String CLASS_CODE = "TBLD";
	protected ICFBamSchemaDefObj requiredContainerSchemaDef;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamIndexObj optionalLookupLookupIndex;
	protected ICFBamIndexObj optionalLookupAltIndex;
	protected ICFBamTableObj optionalLookupQualTable;
	protected ICFBamLoaderBehaviourObj requiredLookupLoaderBehaviour;
	protected ICFBamIndexObj optionalLookupPrimaryIndex;
	protected ICFBamDataScopeObj optionalLookupDataScope;
	protected ICFBamSecurityScopeObj requiredLookupSecScope;
	protected ICFBamAccessSecurityObj optionalLookupVAccSec;
	protected ICFBamAccessSecurityObj optionalLookupEAccSec;
	protected ICFBamAccessFrequencyObj optionalLookupVAccFreq;
	protected ICFBamAccessFrequencyObj optionalLookupEAccFreq;

	public CFBamTableObj() {
		super();
		requiredContainerSchemaDef = null;
		optionalLookupDefSchema = null;
		optionalLookupLookupIndex = null;
		optionalLookupAltIndex = null;
		optionalLookupQualTable = null;
		requiredLookupLoaderBehaviour = null;
		optionalLookupPrimaryIndex = null;
		optionalLookupDataScope = null;
		requiredLookupSecScope = null;
		optionalLookupVAccSec = null;
		optionalLookupEAccSec = null;
		optionalLookupVAccFreq = null;
		optionalLookupEAccFreq = null;
	}

	public CFBamTableObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerSchemaDef = null;
		optionalLookupDefSchema = null;
		optionalLookupLookupIndex = null;
		optionalLookupAltIndex = null;
		optionalLookupQualTable = null;
		requiredLookupLoaderBehaviour = null;
		optionalLookupPrimaryIndex = null;
		optionalLookupDataScope = null;
		requiredLookupSecScope = null;
		optionalLookupVAccSec = null;
		optionalLookupEAccSec = null;
		optionalLookupVAccFreq = null;
		optionalLookupEAccFreq = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Table" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchemaDef();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchemaDef();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredName();
		return( objName );
	}

	public ICFLibAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		ICFLibAnyObj subObj = null;
		ICFLibAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( subObj == null ) {
			subObj = getSchema().getRelationTableObj().readRelationByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = getSchema().getIndexTableObj().readIndexByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = getSchema().getValueTableObj().readValueByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = getSchema().getChainTableObj().readChainByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = getSchema().getServerMethodTableObj().readServerMethodByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	public ICFBamScopeObj realize() {
		ICFBamTableObj retobj = schema.getTableTableObj().realizeTable(
			(ICFBamTableObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		schema.getTableTableObj().forgetTable( (ICFBamTableObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamTableObj retobj = schema.getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamTableObj retobj = schema.getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamTableTableObj getTableTable() {
		return( schema.getTableTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = schema.getBackingStore().getFactoryTable().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = schema.getBackingStore().getTableTable().readDerivedByIdIdx( schema.getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamTableBuff ) ) ) {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamTableBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerSchemaDef = null;
		optionalLookupDefSchema = null;
		optionalLookupLookupIndex = null;
		optionalLookupAltIndex = null;
		optionalLookupQualTable = null;
		requiredLookupLoaderBehaviour = null;
		optionalLookupPrimaryIndex = null;
		optionalLookupDataScope = null;
		requiredLookupSecScope = null;
		optionalLookupVAccSec = null;
		optionalLookupEAccSec = null;
		optionalLookupVAccFreq = null;
		optionalLookupEAccFreq = null;
	}

	public CFBamTableBuff getTableBuff() {
		return( (CFBamTableBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamTableObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamTableObj)this;
		}
		else {
			lockobj = schema.getTableTableObj().lockTable( getPKey() );
		}
		edit = schema.getTableTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamTableEditObj getEditAsTable() {
		return( (ICFBamTableEditObj)edit );
	}

	public ICFBamSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamScopeBuff buff = getBuff();
			createdBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFBamSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamScopeBuff buff = getBuff();
			updatedBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredSchemaDefId() {
		return( getTableBuff().getRequiredSchemaDefId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getTableBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getTableBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getTableBuff().getRequiredName() );
	}

	public String getOptionalDbName() {
		return( getTableBuff().getOptionalDbName() );
	}

	public String getOptionalShortName() {
		return( getTableBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getTableBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getTableBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getTableBuff().getOptionalDescription() );
	}

	public Long getOptionalPrimaryIndexTenantId() {
		return( getTableBuff().getOptionalPrimaryIndexTenantId() );
	}

	public Long getOptionalPrimaryIndexId() {
		return( getTableBuff().getOptionalPrimaryIndexId() );
	}

	public String getRequiredTableClassCode() {
		return( getTableBuff().getRequiredTableClassCode() );
	}

	public Long getOptionalLookupIndexTenantId() {
		return( getTableBuff().getOptionalLookupIndexTenantId() );
	}

	public Long getOptionalLookupIndexId() {
		return( getTableBuff().getOptionalLookupIndexId() );
	}

	public Long getOptionalAltIndexTenantId() {
		return( getTableBuff().getOptionalAltIndexTenantId() );
	}

	public Long getOptionalAltIndexId() {
		return( getTableBuff().getOptionalAltIndexId() );
	}

	public Long getOptionalQualifyingTenantId() {
		return( getTableBuff().getOptionalQualifyingTenantId() );
	}

	public Long getOptionalQualifyingTableId() {
		return( getTableBuff().getOptionalQualifyingTableId() );
	}

	public boolean getRequiredPolyBase() {
		return( getTableBuff().getRequiredPolyBase() );
	}

	public boolean getRequiredIsInstantiable() {
		return( getTableBuff().getRequiredIsInstantiable() );
	}

	public boolean getRequiredHasHistory() {
		return( getTableBuff().getRequiredHasHistory() );
	}

	public boolean getRequiredHasAuditColumns() {
		return( getTableBuff().getRequiredHasAuditColumns() );
	}

	public short getRequiredLoaderBehaviourId() {
		return( getTableBuff().getRequiredLoaderBehaviourId() );
	}

	public Short getOptionalDataScopeId() {
		return( getTableBuff().getOptionalDataScopeId() );
	}

	public short getRequiredSecurityScopeId() {
		return( getTableBuff().getRequiredSecurityScopeId() );
	}

	public Short getOptionalViewAccessSecurityId() {
		return( getTableBuff().getOptionalViewAccessSecurityId() );
	}

	public Short getOptionalEditAccessSecurityId() {
		return( getTableBuff().getOptionalEditAccessSecurityId() );
	}

	public Short getOptionalViewAccessFrequencyId() {
		return( getTableBuff().getOptionalViewAccessFrequencyId() );
	}

	public Short getOptionalEditAccessFrequencyId() {
		return( getTableBuff().getOptionalEditAccessFrequencyId() );
	}

	public String getOptionalJObjMembers() {
		return( getTableBuff().getOptionalJObjMembers() );
	}

	public String getOptionalJObjInterface() {
		return( getTableBuff().getOptionalJObjInterface() );
	}

	public String getOptionalJObjImport() {
		return( getTableBuff().getOptionalJObjImport() );
	}

	public String getOptionalJObjImplementation() {
		return( getTableBuff().getOptionalJObjImplementation() );
	}

	public String getOptionalJEditObjMembers() {
		return( getTableBuff().getOptionalJEditObjMembers() );
	}

	public String getOptionalJEditObjInterface() {
		return( getTableBuff().getOptionalJEditObjInterface() );
	}

	public String getOptionalJEditObjImport() {
		return( getTableBuff().getOptionalJEditObjImport() );
	}

	public String getOptionalJEditObjImplementation() {
		return( getTableBuff().getOptionalJEditObjImplementation() );
	}

	public String getOptionalJTableImport() {
		return( getTableBuff().getOptionalJTableImport() );
	}

	public String getOptionalJTableMembers() {
		return( getTableBuff().getOptionalJTableMembers() );
	}

	public String getOptionalJTableInterface() {
		return( getTableBuff().getOptionalJTableInterface() );
	}

	public String getOptionalJTableImplementation() {
		return( getTableBuff().getOptionalJTableImplementation() );
	}

	public String getOptionalJTableObjImport() {
		return( getTableBuff().getOptionalJTableObjImport() );
	}

	public String getOptionalJTableObjMembers() {
		return( getTableBuff().getOptionalJTableObjMembers() );
	}

	public String getOptionalJTableObjInterface() {
		return( getTableBuff().getOptionalJTableObjInterface() );
	}

	public String getOptionalJTableObjImplementation() {
		return( getTableBuff().getOptionalJTableObjImplementation() );
	}

	public String getOptionalJDb2LUWTableImport() {
		return( getTableBuff().getOptionalJDb2LUWTableImport() );
	}

	public String getOptionalJDb2LUWTableMembers() {
		return( getTableBuff().getOptionalJDb2LUWTableMembers() );
	}

	public String getOptionalJDb2LUWTableImplementation() {
		return( getTableBuff().getOptionalJDb2LUWTableImplementation() );
	}

	public String getOptionalJMSSqlTableImport() {
		return( getTableBuff().getOptionalJMSSqlTableImport() );
	}

	public String getOptionalJMSSqlTableMembers() {
		return( getTableBuff().getOptionalJMSSqlTableMembers() );
	}

	public String getOptionalJMSSqlTableImplementation() {
		return( getTableBuff().getOptionalJMSSqlTableImplementation() );
	}

	public String getOptionalJMySqlTableImport() {
		return( getTableBuff().getOptionalJMySqlTableImport() );
	}

	public String getOptionalJMySqlTableMembers() {
		return( getTableBuff().getOptionalJMySqlTableMembers() );
	}

	public String getOptionalJMySqlTableImplementation() {
		return( getTableBuff().getOptionalJMySqlTableImplementation() );
	}

	public String getOptionalJOracleTableImport() {
		return( getTableBuff().getOptionalJOracleTableImport() );
	}

	public String getOptionalJOracleTableMembers() {
		return( getTableBuff().getOptionalJOracleTableMembers() );
	}

	public String getOptionalJOracleTableImplementation() {
		return( getTableBuff().getOptionalJOracleTableImplementation() );
	}

	public String getOptionalJPgSqlTableImport() {
		return( getTableBuff().getOptionalJPgSqlTableImport() );
	}

	public String getOptionalJPgSqlTableMembers() {
		return( getTableBuff().getOptionalJPgSqlTableMembers() );
	}

	public String getOptionalJPgSqlTableImplementation() {
		return( getTableBuff().getOptionalJPgSqlTableImplementation() );
	}

	public String getOptionalJSybaseTableImport() {
		return( getTableBuff().getOptionalJSybaseTableImport() );
	}

	public String getOptionalJSybaseTableMembers() {
		return( getTableBuff().getOptionalJSybaseTableMembers() );
	}

	public String getOptionalJSybaseTableImplementation() {
		return( getTableBuff().getOptionalJSybaseTableImplementation() );
	}

	public String getOptionalJRamTableImport() {
		return( getTableBuff().getOptionalJRamTableImport() );
	}

	public String getOptionalJRamTableMembers() {
		return( getTableBuff().getOptionalJRamTableMembers() );
	}

	public String getOptionalJRamTableImplementation() {
		return( getTableBuff().getOptionalJRamTableImplementation() );
	}

	public String getOptionalJSaxLoaderImport() {
		return( getTableBuff().getOptionalJSaxLoaderImport() );
	}

	public String getOptionalJSaxLoaderStartElement() {
		return( getTableBuff().getOptionalJSaxLoaderStartElement() );
	}

	public String getOptionalJSaxLoaderEndElement() {
		return( getTableBuff().getOptionalJSaxLoaderEndElement() );
	}

	public String getOptionalJXMsgTableImport() {
		return( getTableBuff().getOptionalJXMsgTableImport() );
	}

	public String getOptionalJXMsgTableFormatters() {
		return( getTableBuff().getOptionalJXMsgTableFormatters() );
	}

	public String getOptionalJXMsgRqstTableImport() {
		return( getTableBuff().getOptionalJXMsgRqstTableImport() );
	}

	public String getOptionalJXMsgRspnTableImport() {
		return( getTableBuff().getOptionalJXMsgRspnTableImport() );
	}

	public String getOptionalJXMsgClientTableImport() {
		return( getTableBuff().getOptionalJXMsgClientTableImport() );
	}

	public String getOptionalJXMsgRqstTableBody() {
		return( getTableBuff().getOptionalJXMsgRqstTableBody() );
	}

	public String getOptionalJXMsgRspnTableBody() {
		return( getTableBuff().getOptionalJXMsgRspnTableBody() );
	}

	public String getOptionalJXMsgClientTableBody() {
		return( getTableBuff().getOptionalJXMsgClientTableBody() );
	}

	public boolean getRequiredDefaultVisibility() {
		return( getTableBuff().getRequiredDefaultVisibility() );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef() {
		return( getRequiredContainerSchemaDef( false ) );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead ) {
		if( ( requiredContainerSchemaDef == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSchemaDef = schema.getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
					getTableBuff().getRequiredSchemaDefId(), forceRead );
			}
		}
		return( requiredContainerSchemaDef );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = schema.getSchemaDefTableObj().readSchemaDefByIdIdx( getTableBuff().getOptionalDefSchemaTenantId(),
					getTableBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public List<ICFBamRelationObj> getOptionalComponentsRelation() {
		List<ICFBamRelationObj> retval;
		retval = schema.getRelationTableObj().readRelationByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalComponentsRelation( boolean forceRead ) {
		List<ICFBamRelationObj> retval;
		retval = schema.getRelationTableObj().readRelationByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamIndexObj getOptionalLookupLookupIndex() {
		return( getOptionalLookupLookupIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupLookupIndex( boolean forceRead ) {
		if( ( optionalLookupLookupIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalLookupIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalLookupIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupLookupIndex = schema.getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalLookupIndexTenantId(),
					getTableBuff().getOptionalLookupIndexId(), forceRead );
			}
		}
		return( optionalLookupLookupIndex );
	}

	public ICFBamIndexObj getOptionalLookupAltIndex() {
		return( getOptionalLookupAltIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupAltIndex( boolean forceRead ) {
		if( ( optionalLookupAltIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalAltIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalAltIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupAltIndex = schema.getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalAltIndexTenantId(),
					getTableBuff().getOptionalAltIndexId(), forceRead );
			}
		}
		return( optionalLookupAltIndex );
	}

	public ICFBamTableObj getOptionalLookupQualTable() {
		return( getOptionalLookupQualTable( false ) );
	}

	public ICFBamTableObj getOptionalLookupQualTable( boolean forceRead ) {
		if( ( optionalLookupQualTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalQualifyingTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalQualifyingTableId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupQualTable = schema.getTableTableObj().readTableByIdIdx( getTableBuff().getOptionalQualifyingTenantId(),
					getTableBuff().getOptionalQualifyingTableId(), forceRead );
			}
		}
		return( optionalLookupQualTable );
	}

	public ICFBamLoaderBehaviourObj getRequiredLookupLoaderBehaviour() {
		return( getRequiredLookupLoaderBehaviour( false ) );
	}

	public ICFBamLoaderBehaviourObj getRequiredLookupLoaderBehaviour( boolean forceRead ) {
		if( ( requiredLookupLoaderBehaviour == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupLoaderBehaviour = schema.getLoaderBehaviourTableObj().readLoaderBehaviourByIdIdx( getTableBuff().getRequiredLoaderBehaviourId(), forceRead );
			}
		}
		return( requiredLookupLoaderBehaviour );
	}

	public List<ICFBamIndexObj> getOptionalComponentsIndex() {
		List<ICFBamIndexObj> retval;
		retval = schema.getIndexTableObj().readIndexByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamIndexObj> getOptionalComponentsIndex( boolean forceRead ) {
		List<ICFBamIndexObj> retval;
		retval = schema.getIndexTableObj().readIndexByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamIndexObj getOptionalLookupPrimaryIndex() {
		return( getOptionalLookupPrimaryIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupPrimaryIndex( boolean forceRead ) {
		if( ( optionalLookupPrimaryIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalPrimaryIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalPrimaryIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrimaryIndex = schema.getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalPrimaryIndexTenantId(),
					getTableBuff().getOptionalPrimaryIndexId(), forceRead );
			}
		}
		return( optionalLookupPrimaryIndex );
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope() {
		return( getOptionalLookupDataScope( false ) );
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope( boolean forceRead ) {
		if( ( optionalLookupDataScope == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalDataScopeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDataScope = schema.getDataScopeTableObj().readDataScopeByIdIdx( getTableBuff().getOptionalDataScopeId(), forceRead );
			}
		}
		return( optionalLookupDataScope );
	}

	public ICFBamSecurityScopeObj getRequiredLookupSecScope() {
		return( getRequiredLookupSecScope( false ) );
	}

	public ICFBamSecurityScopeObj getRequiredLookupSecScope( boolean forceRead ) {
		if( ( requiredLookupSecScope == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupSecScope = schema.getSecurityScopeTableObj().readSecurityScopeByIdIdx( getTableBuff().getRequiredSecurityScopeId(), forceRead );
			}
		}
		return( requiredLookupSecScope );
	}

	public ICFBamAccessSecurityObj getOptionalLookupVAccSec() {
		return( getOptionalLookupVAccSec( false ) );
	}

	public ICFBamAccessSecurityObj getOptionalLookupVAccSec( boolean forceRead ) {
		if( ( optionalLookupVAccSec == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalViewAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupVAccSec = schema.getAccessSecurityTableObj().readAccessSecurityByIdIdx( getTableBuff().getOptionalViewAccessSecurityId(), forceRead );
			}
		}
		return( optionalLookupVAccSec );
	}

	public ICFBamAccessSecurityObj getOptionalLookupEAccSec() {
		return( getOptionalLookupEAccSec( false ) );
	}

	public ICFBamAccessSecurityObj getOptionalLookupEAccSec( boolean forceRead ) {
		if( ( optionalLookupEAccSec == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalEditAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupEAccSec = schema.getAccessSecurityTableObj().readAccessSecurityByIdIdx( getTableBuff().getOptionalEditAccessSecurityId(), forceRead );
			}
		}
		return( optionalLookupEAccSec );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupVAccFreq() {
		return( getOptionalLookupVAccFreq( false ) );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupVAccFreq( boolean forceRead ) {
		if( ( optionalLookupVAccFreq == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalViewAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupVAccFreq = schema.getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getTableBuff().getOptionalViewAccessFrequencyId(), forceRead );
			}
		}
		return( optionalLookupVAccFreq );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupEAccFreq() {
		return( getOptionalLookupEAccFreq( false ) );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupEAccFreq( boolean forceRead ) {
		if( ( optionalLookupEAccFreq == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalEditAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupEAccFreq = schema.getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getTableBuff().getOptionalEditAccessFrequencyId(), forceRead );
			}
		}
		return( optionalLookupEAccFreq );
	}

	public List<ICFBamValueObj> getOptionalComponentsColumns() {
		List<ICFBamValueObj> retval;
		retval = schema.getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamValueObj> retval;
		retval = schema.getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalChildrenReverseRelations() {
		List<ICFBamRelationObj> retval;
		retval = schema.getRelationTableObj().readRelationByToTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalChildrenReverseRelations( boolean forceRead ) {
		List<ICFBamRelationObj> retval;
		retval = schema.getRelationTableObj().readRelationByToTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamChainObj> getOptionalComponentsChains() {
		List<ICFBamChainObj> retval;
		retval = schema.getChainTableObj().readChainByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamChainObj> getOptionalComponentsChains( boolean forceRead ) {
		List<ICFBamChainObj> retval;
		retval = schema.getChainTableObj().readChainByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamDelTopDepObj> getOptionalComponentsDelDep() {
		List<ICFBamDelTopDepObj> retval;
		retval = schema.getDelTopDepTableObj().readDelTopDepByContTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDelTopDepObj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<ICFBamDelTopDepObj> retval;
		retval = schema.getDelTopDepTableObj().readDelTopDepByContTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamClearTopDepObj> getOptionalComponentsClearDep() {
		List<ICFBamClearTopDepObj> retval;
		retval = schema.getClearTopDepTableObj().readClearTopDepByContTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamClearTopDepObj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<ICFBamClearTopDepObj> retval;
		retval = schema.getClearTopDepTableObj().readClearTopDepByContTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen() {
		List<ICFBamId16GenObj> retval;
		retval = schema.getId16GenTableObj().readId16GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen( boolean forceRead ) {
		List<ICFBamId16GenObj> retval;
		retval = schema.getId16GenTableObj().readId16GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen() {
		List<ICFBamId32GenObj> retval;
		retval = schema.getId32GenTableObj().readId32GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen( boolean forceRead ) {
		List<ICFBamId32GenObj> retval;
		retval = schema.getId32GenTableObj().readId32GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen() {
		List<ICFBamId64GenObj> retval;
		retval = schema.getId64GenTableObj().readId64GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen( boolean forceRead ) {
		List<ICFBamId64GenObj> retval;
		retval = schema.getId64GenTableObj().readId64GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamServerMethodObj> getOptionalComponentsServerMethods() {
		List<ICFBamServerMethodObj> retval;
		retval = schema.getServerMethodTableObj().readServerMethodByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamServerMethodObj> getOptionalComponentsServerMethods( boolean forceRead ) {
		List<ICFBamServerMethodObj> retval;
		retval = schema.getServerMethodTableObj().readServerMethodByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamRelationObj> getOnlyOwnerRelations()
	{
		ICFBamTableObj tableDef;
		ICFBamRelationObj relationDef = null;
		String relationTag = null;
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
			if (relationTag.equals("Owner")) {
				list.add(relationDef);
			}
		}
		
		ICFBamRelationObj superClass = getSuperClassRelation();
		while( superClass != null ) {
			tableDef = superClass.getRequiredLookupToTable();
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
				if (relationTag.equals("Owner")) {
					list.add(relationDef);
				}
			}
			superClass = tableDef.getSuperClassRelation();
		}
		
		childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
			if (relationTag.equals("Container")) {
				list.add(relationDef);
			}
		}
		
		superClass = getSuperClassRelation();
		while( superClass != null ) {
			tableDef = superClass.getRequiredLookupToTable();
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
				if (relationTag.equals("Container")) {
					list.add(relationDef);
				}
			}
			superClass = tableDef.getSuperClassRelation();
		}
		
		return (list);
	}

	public List<ICFBamRelationObj> getContainerOwnerRelations()
	{
		ICFBamTableObj tableDef;
		ICFBamRelationObj relationDef = null;
		String relationTag = null;
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
			if (relationTag.equals("Owner")) {
				list.add(relationDef);
			}
			else if( relationTag.equals( "Master" )) {
				list.add(relationDef);
			}
			else if( relationTag.equals( "Parent" )) {
				list.add(relationDef);
			}
			else if( relationTag.equals( "Container" )) {
				list.add(relationDef);
			}
		}
		
		ICFBamRelationObj superClass = getSuperClassRelation();
		while( superClass != null ) {
			tableDef = superClass.getRequiredLookupToTable();
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
				if (relationTag.equals("Owner")) {
					list.add(relationDef);
				}
				else if( relationTag.equals( "Master" )) {
					list.add(relationDef);
				}
				else if( relationTag.equals( "Parent" )) {
					list.add(relationDef);
				}
				else if( relationTag.equals( "Container" )) {
					list.add(relationDef);
				}
			}
			superClass = tableDef.getSuperClassRelation();
		}
		
		return (list);
	}

	public ICFBamRelationObj getContainerRelation()
	{
		ICFBamRelationObj relationDef;
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			String relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
			if (relationTag.equals("Container")) {
				return (relationDef);
			}
		}
		return (null);
	}

	public ICFBamRelationObj getInheritedContainerRelation()
	{
		ICFBamRelationObj inheritedContainerRelation = null;
		ICFBamRelationObj relationDef;
		Iterator<ICFBamRelationObj> childrenRelations;
		ICFBamTableObj tableDef = this;
		while( ( inheritedContainerRelation == null ) && ( tableDef != null ) ) {
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				String relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
				if (relationTag.equals("Container")) {
					return( relationDef );
				}
			}
			relationDef = tableDef.getSuperClassRelation();
			if( relationDef == null ) {
				tableDef = null;
			}
			else {
				tableDef = relationDef.getRequiredLookupToTable();
			}
		}
		return (null);
	}

	public ICFBamRelationObj getOwnerRelation()
	{
		ICFBamRelationObj relationDef;
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			String relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
			if (relationTag.equals("Owner")) {
				return (relationDef);
			}
		}
		return (null);
	}

	public ICFBamRelationObj getInheritedOwnerRelation()
	{
		ICFBamTableObj tableDef = this;
		ICFBamRelationObj inheritedOwnerRelation = null;
		ICFBamRelationObj relationDef;
		Iterator<ICFBamRelationObj> childrenRelations;
		while( ( inheritedOwnerRelation == null ) && ( tableDef != null ) ) {
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				String relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
				if (relationTag.equals("Owner")) {
					return( relationDef );
				}
			}
			relationDef = tableDef.getSuperClassRelation();
			if( relationDef == null ) {
				tableDef = null;
			}
			else {
				tableDef = relationDef.getRequiredLookupToTable();
			}
		}
		return (null);
	}

	public List<ICFBamRelationObj> getOwnerLookupRelations()
	{
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext())
		{
			ICFBamRelationObj relationDef = childrenRelations.next();
			String relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
			if (relationTag.equals("Parent"))
			{
				list.add(relationDef);
			}
			else if (relationTag.equals("Master"))
			{
				list.add(relationDef);
			}
			else if (relationTag.equals("Container"))
			{
				list.add(relationDef);
			}
			else if (relationTag.equals("Lookup"))
			{
				list.add(relationDef);
			}
			else if (relationTag.equals("Owner"))
			{
				list.add(relationDef);
			}
		}
		return (list);
	}

	public List<ICFBamRelationObj> getOwnerContainerNamedLookupChainRelations()
	{
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		List<ICFBamChainObj> componentChains = getOptionalComponentsChains();
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			ICFBamRelationObj relationDef = childrenRelations.next();
			String relationTag = relationDef.getRequiredLookupRelationType().getRequiredTag();
			if (relationTag.equals("Superclass")) {
				;
			}
			else if (relationTag.equals("Container")) {
				list.add(relationDef);
			}
			else if (relationTag.equals("Owner")) {
				list.add(relationDef);
			}
			else {
				if( ! relationDef.getRequiredIsXsdContainer() ) {
					ICFBamIndexObj toIndex = relationDef.getRequiredLookupToIndex();
					if( toIndex.getRequiredIsUnique() ) {
						boolean referencedByChain = false;
						Iterator<ICFBamChainObj> iterChain = componentChains.iterator();
						while( ( ! referencedByChain ) && iterChain.hasNext() ) {
							ICFBamChainObj chain = iterChain.next();
							if( chain.getRequiredLookupPrevRel() == relationDef ) {
								referencedByChain = true;
							}
							else if( chain.getRequiredLookupNextRel() == relationDef ) {
								referencedByChain = true;
							}
						}
						if( referencedByChain ) {
							list.add( relationDef );
						}
						else {
							ICFBamTableObj toTable = relationDef.getRequiredLookupToTable();
							ICFBamIndexObj lookupIndex = toTable.getOptionalLookupLookupIndex();
							while( ( lookupIndex == null ) && ( toTable != null ) ) {
								ICFBamRelationObj superRelation = toTable.getSuperClassRelation();
								if( superRelation != null ) {
									toTable = superRelation.getRequiredLookupToTable();
									if( toTable != null ) {
										lookupIndex = toTable.getOptionalLookupLookupIndex();
									}
								}
								else {
									toTable = null;
								}
							}
							if( lookupIndex != null ) {
								list.add( relationDef );
							}
						}
					}
				}
			}
		}
		return (list);
	}

	public List<ICFBamAtomObj> getChildrenAtoms()
	{
		List<ICFBamAtomObj> list = new LinkedList<ICFBamAtomObj>();
		Iterator<ICFBamValueObj> childrenColumns = getOptionalComponentsColumns().iterator();
		while (childrenColumns.hasNext())
		{
			ICFBamValueObj colDef = childrenColumns.next();
			if (colDef instanceof ICFBamAtomObj)
			{
				list.add( (ICFBamAtomObj)colDef);
			}
		}
		return (list);
	}

    public ICFBamRelationObj getSuperClassRelation()
    {
        Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
        while (childrenRelations.hasNext())
        {
            ICFBamRelationObj relationDef = childrenRelations.next();
            if( ( relationDef.getRequiredLookupRelationType().getRequiredTag().equals( "Superclass" ) )
             || ( relationDef.getRequiredLookupRelationType().getRequiredTag().equals( "SuperClass" ) ) )
            {
                return( relationDef );
            }
        }
        return (null);
    }

    public List<ICFBamRelationObj> getSubClassRelations()
    {
        List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
        Iterator<ICFBamRelationObj> reverseRelations = getOptionalChildrenReverseRelations().iterator();
        while (reverseRelations.hasNext())
        {
            ICFBamRelationObj reverseRelation = reverseRelations.next();
            String reverseTag = reverseRelation.getRequiredLookupRelationType().getRequiredTag();
            if (reverseTag.equals("Superclass"))
            {
                list.add(reverseRelation);
            }
        }
        return (list);
    }

    public ICFBamIndexObj getPrimaryKeyIndex()
    {
        ICFBamIndexObj primaryIndex = getOptionalLookupPrimaryIndex();
        return (primaryIndex);
    }

    public List<ICFBamRelationObj> getFactoryOwnerRelations()
    {
        List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
        Iterator<ICFBamRelationObj> ownerRelations = getContainerOwnerRelations().iterator();
        while (ownerRelations.hasNext())
        {
            // throw new NotImplementedException();
            ICFBamRelationObj ownerRelation = ownerRelations.next();
            String ownerTag = ownerRelation.getRequiredLookupRelationType().getRequiredTag();
            if (ownerTag.equals("Superclass"))
            {
                list.add(ownerRelation);
            }
        }
        return (list);
    }

    public List<ICFBamIndexObj> getInheritedIndexes()
    {
        List<ICFBamIndexObj> list = new LinkedList<ICFBamIndexObj>();
        ICFBamRelationObj superClassRelation = getSuperClassRelation();
        if (superClassRelation != null)
        {
            Iterator<ICFBamIndexObj> superClassInheritedIndexes
                = superClassRelation.getRequiredLookupToTable().getInheritedIndexes().iterator();
            while (superClassInheritedIndexes.hasNext())
            {
                list.add(superClassInheritedIndexes.next());
            }
            Iterator<ICFBamIndexObj> myIndexes = getChildrenIndexes().iterator();
            while( myIndexes.hasNext() )
            {
                list.add( myIndexes.next() );
            }
        }
        return (list);
    }

    public List<ICFBamIndexObj> getChildrenIndexes()
    {
        Iterator<ICFBamIndexObj> iter = getOptionalComponentsIndex().iterator();
        List<ICFBamIndexObj> list = new LinkedList<ICFBamIndexObj>();
        while( iter.hasNext() ) {
        	list.add( iter.next() );
        }
        return( list );
    }

    public List<ICFBamRelationObj> getInheritedRelations()
    {
        List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
        ICFBamRelationObj superClassRelation = getSuperClassRelation();
        if (superClassRelation != null)
        {
            Iterator<ICFBamRelationObj> superClassInheritedRelations
                = superClassRelation.getRequiredLookupToTable().getInheritedRelations().iterator();
            while (superClassInheritedRelations.hasNext())
            {
                list.add(superClassInheritedRelations.next());
            }
            Iterator<ICFBamRelationObj> myRelations = getChildrenRelations().iterator();
            while (myRelations.hasNext())
            {
                list.add(myRelations.next());
            }
        }
        return (list);
    }

    public List<ICFBamRelationObj> getChildrenRelations()
    {
        List<ICFBamRelationObj> childrenRelations = new LinkedList<ICFBamRelationObj>();
        Collection<ICFBamRelationObj> cltn = getOptionalComponentsRelation();
        Iterator<ICFBamRelationObj> iter = cltn.iterator();
        while( iter.hasNext() ) {
        	childrenRelations.add( iter.next() );
        }
        return (childrenRelations);
    }
}
