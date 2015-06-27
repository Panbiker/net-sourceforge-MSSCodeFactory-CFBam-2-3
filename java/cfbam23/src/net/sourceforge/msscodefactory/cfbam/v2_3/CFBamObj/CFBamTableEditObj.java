// Description: Java7 edit object instance implementation for CFBam Table.

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

public class CFBamTableEditObj
	extends CFBamScopeEditObj

	implements ICFBamTableEditObj
{
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

	public CFBamTableEditObj( ICFBamTableObj argOrig ) {
		super( argOrig );
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
		return( CFBamTableObj.CLASS_CODE );
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
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamTableObj retobj = getSchema().getTableTableObj().realizeTable( (ICFBamTableObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsTable().getSchema().getTableTableObj().forgetTable( getOrigAsTable(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamTableObj retobj = getOrigAsTable().getSchema().getTableTableObj().createTable( getOrigAsTable() );
		if( retobj == getOrigAsTable() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getTableTableObj().updateTable( (ICFBamTableObj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getTableTableObj().deleteTable( getOrigAsTable() );
	}

	public ICFBamTableTableObj getTableTable() {
		return( orig.getSchema().getTableTableObj() );
	}

	public ICFBamTableEditObj getEditAsTable() {
		return( (ICFBamTableEditObj)this );
	}

	public ICFBamTableObj getOrigAsTable() {
		return( (ICFBamTableObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsTable().getSchema().getBackingStore().getFactoryTable().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
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
	}

	public CFBamTableBuff getTableBuff() {
		return( (CFBamTableBuff)getBuff() );
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

	public void setRequiredName( String value ) {
		if( getTableBuff().getRequiredName() != value ) {
			getTableBuff().setRequiredName( value );
		}
	}

	public String getOptionalDbName() {
		return( getTableBuff().getOptionalDbName() );
	}

	public void setOptionalDbName( String value ) {
		if( getTableBuff().getOptionalDbName() != value ) {
			getTableBuff().setOptionalDbName( value );
		}
	}

	public String getOptionalShortName() {
		return( getTableBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getTableBuff().getOptionalShortName() != value ) {
			getTableBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getTableBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getTableBuff().getOptionalLabel() != value ) {
			getTableBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getTableBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getTableBuff().getOptionalShortDescription() != value ) {
			getTableBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getTableBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getTableBuff().getOptionalDescription() != value ) {
			getTableBuff().setOptionalDescription( value );
		}
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

	public void setRequiredTableClassCode( String value ) {
		if( getTableBuff().getRequiredTableClassCode() != value ) {
			getTableBuff().setRequiredTableClassCode( value );
		}
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

	public void setRequiredPolyBase( boolean value ) {
		if( getTableBuff().getRequiredPolyBase() != value ) {
			getTableBuff().setRequiredPolyBase( value );
		}
	}

	public boolean getRequiredIsInstantiable() {
		return( getTableBuff().getRequiredIsInstantiable() );
	}

	public void setRequiredIsInstantiable( boolean value ) {
		if( getTableBuff().getRequiredIsInstantiable() != value ) {
			getTableBuff().setRequiredIsInstantiable( value );
		}
	}

	public boolean getRequiredHasHistory() {
		return( getTableBuff().getRequiredHasHistory() );
	}

	public void setRequiredHasHistory( boolean value ) {
		if( getTableBuff().getRequiredHasHistory() != value ) {
			getTableBuff().setRequiredHasHistory( value );
		}
	}

	public boolean getRequiredHasAuditColumns() {
		return( getTableBuff().getRequiredHasAuditColumns() );
	}

	public void setRequiredHasAuditColumns( boolean value ) {
		if( getTableBuff().getRequiredHasAuditColumns() != value ) {
			getTableBuff().setRequiredHasAuditColumns( value );
		}
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

	public void setOptionalJObjMembers( String value ) {
		if( getTableBuff().getOptionalJObjMembers() != value ) {
			getTableBuff().setOptionalJObjMembers( value );
		}
	}

	public String getOptionalJObjInterface() {
		return( getTableBuff().getOptionalJObjInterface() );
	}

	public void setOptionalJObjInterface( String value ) {
		if( getTableBuff().getOptionalJObjInterface() != value ) {
			getTableBuff().setOptionalJObjInterface( value );
		}
	}

	public String getOptionalJObjImport() {
		return( getTableBuff().getOptionalJObjImport() );
	}

	public void setOptionalJObjImport( String value ) {
		if( getTableBuff().getOptionalJObjImport() != value ) {
			getTableBuff().setOptionalJObjImport( value );
		}
	}

	public String getOptionalJObjImplementation() {
		return( getTableBuff().getOptionalJObjImplementation() );
	}

	public void setOptionalJObjImplementation( String value ) {
		if( getTableBuff().getOptionalJObjImplementation() != value ) {
			getTableBuff().setOptionalJObjImplementation( value );
		}
	}

	public String getOptionalJEditObjMembers() {
		return( getTableBuff().getOptionalJEditObjMembers() );
	}

	public void setOptionalJEditObjMembers( String value ) {
		if( getTableBuff().getOptionalJEditObjMembers() != value ) {
			getTableBuff().setOptionalJEditObjMembers( value );
		}
	}

	public String getOptionalJEditObjInterface() {
		return( getTableBuff().getOptionalJEditObjInterface() );
	}

	public void setOptionalJEditObjInterface( String value ) {
		if( getTableBuff().getOptionalJEditObjInterface() != value ) {
			getTableBuff().setOptionalJEditObjInterface( value );
		}
	}

	public String getOptionalJEditObjImport() {
		return( getTableBuff().getOptionalJEditObjImport() );
	}

	public void setOptionalJEditObjImport( String value ) {
		if( getTableBuff().getOptionalJEditObjImport() != value ) {
			getTableBuff().setOptionalJEditObjImport( value );
		}
	}

	public String getOptionalJEditObjImplementation() {
		return( getTableBuff().getOptionalJEditObjImplementation() );
	}

	public void setOptionalJEditObjImplementation( String value ) {
		if( getTableBuff().getOptionalJEditObjImplementation() != value ) {
			getTableBuff().setOptionalJEditObjImplementation( value );
		}
	}

	public String getOptionalJTableImport() {
		return( getTableBuff().getOptionalJTableImport() );
	}

	public void setOptionalJTableImport( String value ) {
		if( getTableBuff().getOptionalJTableImport() != value ) {
			getTableBuff().setOptionalJTableImport( value );
		}
	}

	public String getOptionalJTableMembers() {
		return( getTableBuff().getOptionalJTableMembers() );
	}

	public void setOptionalJTableMembers( String value ) {
		if( getTableBuff().getOptionalJTableMembers() != value ) {
			getTableBuff().setOptionalJTableMembers( value );
		}
	}

	public String getOptionalJTableInterface() {
		return( getTableBuff().getOptionalJTableInterface() );
	}

	public void setOptionalJTableInterface( String value ) {
		if( getTableBuff().getOptionalJTableInterface() != value ) {
			getTableBuff().setOptionalJTableInterface( value );
		}
	}

	public String getOptionalJTableImplementation() {
		return( getTableBuff().getOptionalJTableImplementation() );
	}

	public void setOptionalJTableImplementation( String value ) {
		if( getTableBuff().getOptionalJTableImplementation() != value ) {
			getTableBuff().setOptionalJTableImplementation( value );
		}
	}

	public String getOptionalJTableObjImport() {
		return( getTableBuff().getOptionalJTableObjImport() );
	}

	public void setOptionalJTableObjImport( String value ) {
		if( getTableBuff().getOptionalJTableObjImport() != value ) {
			getTableBuff().setOptionalJTableObjImport( value );
		}
	}

	public String getOptionalJTableObjMembers() {
		return( getTableBuff().getOptionalJTableObjMembers() );
	}

	public void setOptionalJTableObjMembers( String value ) {
		if( getTableBuff().getOptionalJTableObjMembers() != value ) {
			getTableBuff().setOptionalJTableObjMembers( value );
		}
	}

	public String getOptionalJTableObjInterface() {
		return( getTableBuff().getOptionalJTableObjInterface() );
	}

	public void setOptionalJTableObjInterface( String value ) {
		if( getTableBuff().getOptionalJTableObjInterface() != value ) {
			getTableBuff().setOptionalJTableObjInterface( value );
		}
	}

	public String getOptionalJTableObjImplementation() {
		return( getTableBuff().getOptionalJTableObjImplementation() );
	}

	public void setOptionalJTableObjImplementation( String value ) {
		if( getTableBuff().getOptionalJTableObjImplementation() != value ) {
			getTableBuff().setOptionalJTableObjImplementation( value );
		}
	}

	public String getOptionalJDb2LUWTableImport() {
		return( getTableBuff().getOptionalJDb2LUWTableImport() );
	}

	public void setOptionalJDb2LUWTableImport( String value ) {
		if( getTableBuff().getOptionalJDb2LUWTableImport() != value ) {
			getTableBuff().setOptionalJDb2LUWTableImport( value );
		}
	}

	public String getOptionalJDb2LUWTableMembers() {
		return( getTableBuff().getOptionalJDb2LUWTableMembers() );
	}

	public void setOptionalJDb2LUWTableMembers( String value ) {
		if( getTableBuff().getOptionalJDb2LUWTableMembers() != value ) {
			getTableBuff().setOptionalJDb2LUWTableMembers( value );
		}
	}

	public String getOptionalJDb2LUWTableImplementation() {
		return( getTableBuff().getOptionalJDb2LUWTableImplementation() );
	}

	public void setOptionalJDb2LUWTableImplementation( String value ) {
		if( getTableBuff().getOptionalJDb2LUWTableImplementation() != value ) {
			getTableBuff().setOptionalJDb2LUWTableImplementation( value );
		}
	}

	public String getOptionalJMSSqlTableImport() {
		return( getTableBuff().getOptionalJMSSqlTableImport() );
	}

	public void setOptionalJMSSqlTableImport( String value ) {
		if( getTableBuff().getOptionalJMSSqlTableImport() != value ) {
			getTableBuff().setOptionalJMSSqlTableImport( value );
		}
	}

	public String getOptionalJMSSqlTableMembers() {
		return( getTableBuff().getOptionalJMSSqlTableMembers() );
	}

	public void setOptionalJMSSqlTableMembers( String value ) {
		if( getTableBuff().getOptionalJMSSqlTableMembers() != value ) {
			getTableBuff().setOptionalJMSSqlTableMembers( value );
		}
	}

	public String getOptionalJMSSqlTableImplementation() {
		return( getTableBuff().getOptionalJMSSqlTableImplementation() );
	}

	public void setOptionalJMSSqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalJMSSqlTableImplementation() != value ) {
			getTableBuff().setOptionalJMSSqlTableImplementation( value );
		}
	}

	public String getOptionalJMySqlTableImport() {
		return( getTableBuff().getOptionalJMySqlTableImport() );
	}

	public void setOptionalJMySqlTableImport( String value ) {
		if( getTableBuff().getOptionalJMySqlTableImport() != value ) {
			getTableBuff().setOptionalJMySqlTableImport( value );
		}
	}

	public String getOptionalJMySqlTableMembers() {
		return( getTableBuff().getOptionalJMySqlTableMembers() );
	}

	public void setOptionalJMySqlTableMembers( String value ) {
		if( getTableBuff().getOptionalJMySqlTableMembers() != value ) {
			getTableBuff().setOptionalJMySqlTableMembers( value );
		}
	}

	public String getOptionalJMySqlTableImplementation() {
		return( getTableBuff().getOptionalJMySqlTableImplementation() );
	}

	public void setOptionalJMySqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalJMySqlTableImplementation() != value ) {
			getTableBuff().setOptionalJMySqlTableImplementation( value );
		}
	}

	public String getOptionalJOracleTableImport() {
		return( getTableBuff().getOptionalJOracleTableImport() );
	}

	public void setOptionalJOracleTableImport( String value ) {
		if( getTableBuff().getOptionalJOracleTableImport() != value ) {
			getTableBuff().setOptionalJOracleTableImport( value );
		}
	}

	public String getOptionalJOracleTableMembers() {
		return( getTableBuff().getOptionalJOracleTableMembers() );
	}

	public void setOptionalJOracleTableMembers( String value ) {
		if( getTableBuff().getOptionalJOracleTableMembers() != value ) {
			getTableBuff().setOptionalJOracleTableMembers( value );
		}
	}

	public String getOptionalJOracleTableImplementation() {
		return( getTableBuff().getOptionalJOracleTableImplementation() );
	}

	public void setOptionalJOracleTableImplementation( String value ) {
		if( getTableBuff().getOptionalJOracleTableImplementation() != value ) {
			getTableBuff().setOptionalJOracleTableImplementation( value );
		}
	}

	public String getOptionalJPgSqlTableImport() {
		return( getTableBuff().getOptionalJPgSqlTableImport() );
	}

	public void setOptionalJPgSqlTableImport( String value ) {
		if( getTableBuff().getOptionalJPgSqlTableImport() != value ) {
			getTableBuff().setOptionalJPgSqlTableImport( value );
		}
	}

	public String getOptionalJPgSqlTableMembers() {
		return( getTableBuff().getOptionalJPgSqlTableMembers() );
	}

	public void setOptionalJPgSqlTableMembers( String value ) {
		if( getTableBuff().getOptionalJPgSqlTableMembers() != value ) {
			getTableBuff().setOptionalJPgSqlTableMembers( value );
		}
	}

	public String getOptionalJPgSqlTableImplementation() {
		return( getTableBuff().getOptionalJPgSqlTableImplementation() );
	}

	public void setOptionalJPgSqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalJPgSqlTableImplementation() != value ) {
			getTableBuff().setOptionalJPgSqlTableImplementation( value );
		}
	}

	public String getOptionalJSybaseTableImport() {
		return( getTableBuff().getOptionalJSybaseTableImport() );
	}

	public void setOptionalJSybaseTableImport( String value ) {
		if( getTableBuff().getOptionalJSybaseTableImport() != value ) {
			getTableBuff().setOptionalJSybaseTableImport( value );
		}
	}

	public String getOptionalJSybaseTableMembers() {
		return( getTableBuff().getOptionalJSybaseTableMembers() );
	}

	public void setOptionalJSybaseTableMembers( String value ) {
		if( getTableBuff().getOptionalJSybaseTableMembers() != value ) {
			getTableBuff().setOptionalJSybaseTableMembers( value );
		}
	}

	public String getOptionalJSybaseTableImplementation() {
		return( getTableBuff().getOptionalJSybaseTableImplementation() );
	}

	public void setOptionalJSybaseTableImplementation( String value ) {
		if( getTableBuff().getOptionalJSybaseTableImplementation() != value ) {
			getTableBuff().setOptionalJSybaseTableImplementation( value );
		}
	}

	public String getOptionalJRamTableImport() {
		return( getTableBuff().getOptionalJRamTableImport() );
	}

	public void setOptionalJRamTableImport( String value ) {
		if( getTableBuff().getOptionalJRamTableImport() != value ) {
			getTableBuff().setOptionalJRamTableImport( value );
		}
	}

	public String getOptionalJRamTableMembers() {
		return( getTableBuff().getOptionalJRamTableMembers() );
	}

	public void setOptionalJRamTableMembers( String value ) {
		if( getTableBuff().getOptionalJRamTableMembers() != value ) {
			getTableBuff().setOptionalJRamTableMembers( value );
		}
	}

	public String getOptionalJRamTableImplementation() {
		return( getTableBuff().getOptionalJRamTableImplementation() );
	}

	public void setOptionalJRamTableImplementation( String value ) {
		if( getTableBuff().getOptionalJRamTableImplementation() != value ) {
			getTableBuff().setOptionalJRamTableImplementation( value );
		}
	}

	public String getOptionalJSaxLoaderImport() {
		return( getTableBuff().getOptionalJSaxLoaderImport() );
	}

	public void setOptionalJSaxLoaderImport( String value ) {
		if( getTableBuff().getOptionalJSaxLoaderImport() != value ) {
			getTableBuff().setOptionalJSaxLoaderImport( value );
		}
	}

	public String getOptionalJSaxLoaderStartElement() {
		return( getTableBuff().getOptionalJSaxLoaderStartElement() );
	}

	public void setOptionalJSaxLoaderStartElement( String value ) {
		if( getTableBuff().getOptionalJSaxLoaderStartElement() != value ) {
			getTableBuff().setOptionalJSaxLoaderStartElement( value );
		}
	}

	public String getOptionalJSaxLoaderEndElement() {
		return( getTableBuff().getOptionalJSaxLoaderEndElement() );
	}

	public void setOptionalJSaxLoaderEndElement( String value ) {
		if( getTableBuff().getOptionalJSaxLoaderEndElement() != value ) {
			getTableBuff().setOptionalJSaxLoaderEndElement( value );
		}
	}

	public String getOptionalJXMsgTableImport() {
		return( getTableBuff().getOptionalJXMsgTableImport() );
	}

	public void setOptionalJXMsgTableImport( String value ) {
		if( getTableBuff().getOptionalJXMsgTableImport() != value ) {
			getTableBuff().setOptionalJXMsgTableImport( value );
		}
	}

	public String getOptionalJXMsgTableFormatters() {
		return( getTableBuff().getOptionalJXMsgTableFormatters() );
	}

	public void setOptionalJXMsgTableFormatters( String value ) {
		if( getTableBuff().getOptionalJXMsgTableFormatters() != value ) {
			getTableBuff().setOptionalJXMsgTableFormatters( value );
		}
	}

	public String getOptionalJXMsgRqstTableImport() {
		return( getTableBuff().getOptionalJXMsgRqstTableImport() );
	}

	public void setOptionalJXMsgRqstTableImport( String value ) {
		if( getTableBuff().getOptionalJXMsgRqstTableImport() != value ) {
			getTableBuff().setOptionalJXMsgRqstTableImport( value );
		}
	}

	public String getOptionalJXMsgRspnTableImport() {
		return( getTableBuff().getOptionalJXMsgRspnTableImport() );
	}

	public void setOptionalJXMsgRspnTableImport( String value ) {
		if( getTableBuff().getOptionalJXMsgRspnTableImport() != value ) {
			getTableBuff().setOptionalJXMsgRspnTableImport( value );
		}
	}

	public String getOptionalJXMsgClientTableImport() {
		return( getTableBuff().getOptionalJXMsgClientTableImport() );
	}

	public void setOptionalJXMsgClientTableImport( String value ) {
		if( getTableBuff().getOptionalJXMsgClientTableImport() != value ) {
			getTableBuff().setOptionalJXMsgClientTableImport( value );
		}
	}

	public String getOptionalJXMsgRqstTableBody() {
		return( getTableBuff().getOptionalJXMsgRqstTableBody() );
	}

	public void setOptionalJXMsgRqstTableBody( String value ) {
		if( getTableBuff().getOptionalJXMsgRqstTableBody() != value ) {
			getTableBuff().setOptionalJXMsgRqstTableBody( value );
		}
	}

	public String getOptionalJXMsgRspnTableBody() {
		return( getTableBuff().getOptionalJXMsgRspnTableBody() );
	}

	public void setOptionalJXMsgRspnTableBody( String value ) {
		if( getTableBuff().getOptionalJXMsgRspnTableBody() != value ) {
			getTableBuff().setOptionalJXMsgRspnTableBody( value );
		}
	}

	public String getOptionalJXMsgClientTableBody() {
		return( getTableBuff().getOptionalJXMsgClientTableBody() );
	}

	public void setOptionalJXMsgClientTableBody( String value ) {
		if( getTableBuff().getOptionalJXMsgClientTableBody() != value ) {
			getTableBuff().setOptionalJXMsgClientTableBody( value );
		}
	}

	public boolean getRequiredDefaultVisibility() {
		return( getTableBuff().getRequiredDefaultVisibility() );
	}

	public void setRequiredDefaultVisibility( boolean value ) {
		if( getTableBuff().getRequiredDefaultVisibility() != value ) {
			getTableBuff().setRequiredDefaultVisibility( value );
		}
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef() {
		return( getRequiredContainerSchemaDef( false ) );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead ) {
		if( forceRead || ( requiredContainerSchemaDef == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = getOrigAsTable().getSchema().getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
					getTableBuff().getRequiredSchemaDefId() );
				requiredContainerSchemaDef = obj;
				if( obj != null ) {
					getTableBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getTableBuff().setRequiredSchemaDefId( obj.getRequiredId() );
					requiredContainerSchemaDef = obj;
				}
			}
		}
		return( requiredContainerSchemaDef );
	}

	public void setRequiredContainerSchemaDef( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			requiredContainerSchemaDef = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getTableBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getTableBuff().setRequiredSchemaDefId( value.getRequiredId() );
			}
			requiredContainerSchemaDef = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = getOrigAsTable().getSchema().getSchemaDefTableObj().readSchemaDefByIdIdx( getTableBuff().getOptionalDefSchemaTenantId(),
					getTableBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getTableBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalDefSchemaTenantId( null );
				getTableBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public List<ICFBamRelationObj> getOptionalComponentsRelation() {
		List<ICFBamRelationObj> retval;
		retval = getOrigAsTable().getSchema().getRelationTableObj().readRelationByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalComponentsRelation( boolean forceRead ) {
		List<ICFBamRelationObj> retval;
		retval = getOrigAsTable().getSchema().getRelationTableObj().readRelationByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamIndexObj getOptionalLookupLookupIndex() {
		return( getOptionalLookupLookupIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupLookupIndex( boolean forceRead ) {
		if( forceRead || ( optionalLookupLookupIndex == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalLookupIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalLookupIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamIndexObj obj = getOrigAsTable().getSchema().getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalLookupIndexTenantId(),
					getTableBuff().getOptionalLookupIndexId() );
				optionalLookupLookupIndex = obj;
			}
		}
		return( optionalLookupLookupIndex );
	}

	public void setOptionalLookupLookupIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalLookupIndexTenantId( value.getRequiredTenantId() );
				getTableBuff().setOptionalLookupIndexId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalLookupIndexTenantId( null );
				getTableBuff().setOptionalLookupIndexId( null );
			}
			optionalLookupLookupIndex = value;
	}

	public ICFBamIndexObj getOptionalLookupAltIndex() {
		return( getOptionalLookupAltIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupAltIndex( boolean forceRead ) {
		if( forceRead || ( optionalLookupAltIndex == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalAltIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalAltIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamIndexObj obj = getOrigAsTable().getSchema().getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalAltIndexTenantId(),
					getTableBuff().getOptionalAltIndexId() );
				optionalLookupAltIndex = obj;
			}
		}
		return( optionalLookupAltIndex );
	}

	public void setOptionalLookupAltIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalAltIndexTenantId( value.getRequiredTenantId() );
				getTableBuff().setOptionalAltIndexId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalAltIndexTenantId( null );
				getTableBuff().setOptionalAltIndexId( null );
			}
			optionalLookupAltIndex = value;
	}

	public ICFBamTableObj getOptionalLookupQualTable() {
		return( getOptionalLookupQualTable( false ) );
	}

	public ICFBamTableObj getOptionalLookupQualTable( boolean forceRead ) {
		if( forceRead || ( optionalLookupQualTable == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalQualifyingTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalQualifyingTableId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamTableObj obj = getOrigAsTable().getSchema().getTableTableObj().readTableByIdIdx( getTableBuff().getOptionalQualifyingTenantId(),
					getTableBuff().getOptionalQualifyingTableId() );
				optionalLookupQualTable = obj;
			}
		}
		return( optionalLookupQualTable );
	}

	public void setOptionalLookupQualTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalQualifyingTenantId( value.getRequiredTenantId() );
				getTableBuff().setOptionalQualifyingTableId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalQualifyingTenantId( null );
				getTableBuff().setOptionalQualifyingTableId( null );
			}
			optionalLookupQualTable = value;
	}

	public ICFBamLoaderBehaviourObj getRequiredLookupLoaderBehaviour() {
		return( getRequiredLookupLoaderBehaviour( false ) );
	}

	public ICFBamLoaderBehaviourObj getRequiredLookupLoaderBehaviour( boolean forceRead ) {
		if( forceRead || ( requiredLookupLoaderBehaviour == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamLoaderBehaviourObj obj = getOrigAsTable().getSchema().getLoaderBehaviourTableObj().readLoaderBehaviourByIdIdx( getTableBuff().getRequiredLoaderBehaviourId() );
				requiredLookupLoaderBehaviour = obj;
			}
		}
		return( requiredLookupLoaderBehaviour );
	}

	public void setRequiredLookupLoaderBehaviour( ICFBamLoaderBehaviourObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setRequiredLoaderBehaviourId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupLoaderBehaviour = value;
	}

	public List<ICFBamIndexObj> getOptionalComponentsIndex() {
		List<ICFBamIndexObj> retval;
		retval = getOrigAsTable().getSchema().getIndexTableObj().readIndexByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamIndexObj> getOptionalComponentsIndex( boolean forceRead ) {
		List<ICFBamIndexObj> retval;
		retval = getOrigAsTable().getSchema().getIndexTableObj().readIndexByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamIndexObj getOptionalLookupPrimaryIndex() {
		return( getOptionalLookupPrimaryIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupPrimaryIndex( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrimaryIndex == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalPrimaryIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalPrimaryIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamIndexObj obj = getOrigAsTable().getSchema().getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalPrimaryIndexTenantId(),
					getTableBuff().getOptionalPrimaryIndexId() );
				optionalLookupPrimaryIndex = obj;
			}
		}
		return( optionalLookupPrimaryIndex );
	}

	public void setOptionalLookupPrimaryIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalPrimaryIndexTenantId( value.getRequiredTenantId() );
				getTableBuff().setOptionalPrimaryIndexId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalPrimaryIndexTenantId( null );
				getTableBuff().setOptionalPrimaryIndexId( null );
			}
			optionalLookupPrimaryIndex = value;
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope() {
		return( getOptionalLookupDataScope( false ) );
	}

	public ICFBamDataScopeObj getOptionalLookupDataScope( boolean forceRead ) {
		if( forceRead || ( optionalLookupDataScope == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalDataScopeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamDataScopeObj obj = getOrigAsTable().getSchema().getDataScopeTableObj().readDataScopeByIdIdx( getTableBuff().getOptionalDataScopeId() );
				optionalLookupDataScope = obj;
			}
		}
		return( optionalLookupDataScope );
	}

	public void setOptionalLookupDataScope( ICFBamDataScopeObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalDataScopeId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalDataScopeId( null );
			}
			optionalLookupDataScope = value;
	}

	public ICFBamSecurityScopeObj getRequiredLookupSecScope() {
		return( getRequiredLookupSecScope( false ) );
	}

	public ICFBamSecurityScopeObj getRequiredLookupSecScope( boolean forceRead ) {
		if( forceRead || ( requiredLookupSecScope == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamSecurityScopeObj obj = getOrigAsTable().getSchema().getSecurityScopeTableObj().readSecurityScopeByIdIdx( getTableBuff().getRequiredSecurityScopeId() );
				requiredLookupSecScope = obj;
			}
		}
		return( requiredLookupSecScope );
	}

	public void setRequiredLookupSecScope( ICFBamSecurityScopeObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setRequiredSecurityScopeId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupSecScope = value;
	}

	public ICFBamAccessSecurityObj getOptionalLookupVAccSec() {
		return( getOptionalLookupVAccSec( false ) );
	}

	public ICFBamAccessSecurityObj getOptionalLookupVAccSec( boolean forceRead ) {
		if( forceRead || ( optionalLookupVAccSec == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalViewAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessSecurityObj obj = getOrigAsTable().getSchema().getAccessSecurityTableObj().readAccessSecurityByIdIdx( getTableBuff().getOptionalViewAccessSecurityId() );
				optionalLookupVAccSec = obj;
			}
		}
		return( optionalLookupVAccSec );
	}

	public void setOptionalLookupVAccSec( ICFBamAccessSecurityObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalViewAccessSecurityId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalViewAccessSecurityId( null );
			}
			optionalLookupVAccSec = value;
	}

	public ICFBamAccessSecurityObj getOptionalLookupEAccSec() {
		return( getOptionalLookupEAccSec( false ) );
	}

	public ICFBamAccessSecurityObj getOptionalLookupEAccSec( boolean forceRead ) {
		if( forceRead || ( optionalLookupEAccSec == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalEditAccessSecurityId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessSecurityObj obj = getOrigAsTable().getSchema().getAccessSecurityTableObj().readAccessSecurityByIdIdx( getTableBuff().getOptionalEditAccessSecurityId() );
				optionalLookupEAccSec = obj;
			}
		}
		return( optionalLookupEAccSec );
	}

	public void setOptionalLookupEAccSec( ICFBamAccessSecurityObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalEditAccessSecurityId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalEditAccessSecurityId( null );
			}
			optionalLookupEAccSec = value;
	}

	public ICFBamAccessFrequencyObj getOptionalLookupVAccFreq() {
		return( getOptionalLookupVAccFreq( false ) );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupVAccFreq( boolean forceRead ) {
		if( forceRead || ( optionalLookupVAccFreq == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalViewAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessFrequencyObj obj = getOrigAsTable().getSchema().getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getTableBuff().getOptionalViewAccessFrequencyId() );
				optionalLookupVAccFreq = obj;
			}
		}
		return( optionalLookupVAccFreq );
	}

	public void setOptionalLookupVAccFreq( ICFBamAccessFrequencyObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalViewAccessFrequencyId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalViewAccessFrequencyId( null );
			}
			optionalLookupVAccFreq = value;
	}

	public ICFBamAccessFrequencyObj getOptionalLookupEAccFreq() {
		return( getOptionalLookupEAccFreq( false ) );
	}

	public ICFBamAccessFrequencyObj getOptionalLookupEAccFreq( boolean forceRead ) {
		if( forceRead || ( optionalLookupEAccFreq == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalEditAccessFrequencyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamAccessFrequencyObj obj = getOrigAsTable().getSchema().getAccessFrequencyTableObj().readAccessFrequencyByIdIdx( getTableBuff().getOptionalEditAccessFrequencyId() );
				optionalLookupEAccFreq = obj;
			}
		}
		return( optionalLookupEAccFreq );
	}

	public void setOptionalLookupEAccFreq( ICFBamAccessFrequencyObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalEditAccessFrequencyId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalEditAccessFrequencyId( null );
			}
			optionalLookupEAccFreq = value;
	}

	public List<ICFBamValueObj> getOptionalComponentsColumns() {
		List<ICFBamValueObj> retval;
		retval = getOrigAsTable().getSchema().getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamValueObj> retval;
		retval = getOrigAsTable().getSchema().getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalChildrenReverseRelations() {
		List<ICFBamRelationObj> retval;
		retval = getOrigAsTable().getSchema().getRelationTableObj().readRelationByToTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalChildrenReverseRelations( boolean forceRead ) {
		List<ICFBamRelationObj> retval;
		retval = getOrigAsTable().getSchema().getRelationTableObj().readRelationByToTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamChainObj> getOptionalComponentsChains() {
		List<ICFBamChainObj> retval;
		retval = getOrigAsTable().getSchema().getChainTableObj().readChainByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamChainObj> getOptionalComponentsChains( boolean forceRead ) {
		List<ICFBamChainObj> retval;
		retval = getOrigAsTable().getSchema().getChainTableObj().readChainByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamDelTopDepObj> getOptionalComponentsDelDep() {
		List<ICFBamDelTopDepObj> retval;
		retval = getOrigAsTable().getSchema().getDelTopDepTableObj().readDelTopDepByContTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDelTopDepObj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<ICFBamDelTopDepObj> retval;
		retval = getOrigAsTable().getSchema().getDelTopDepTableObj().readDelTopDepByContTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamClearTopDepObj> getOptionalComponentsClearDep() {
		List<ICFBamClearTopDepObj> retval;
		retval = getOrigAsTable().getSchema().getClearTopDepTableObj().readClearTopDepByContTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamClearTopDepObj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<ICFBamClearTopDepObj> retval;
		retval = getOrigAsTable().getSchema().getClearTopDepTableObj().readClearTopDepByContTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen() {
		List<ICFBamId16GenObj> retval;
		retval = getOrigAsTable().getSchema().getId16GenTableObj().readId16GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen( boolean forceRead ) {
		List<ICFBamId16GenObj> retval;
		retval = getOrigAsTable().getSchema().getId16GenTableObj().readId16GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen() {
		List<ICFBamId32GenObj> retval;
		retval = getOrigAsTable().getSchema().getId32GenTableObj().readId32GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen( boolean forceRead ) {
		List<ICFBamId32GenObj> retval;
		retval = getOrigAsTable().getSchema().getId32GenTableObj().readId32GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen() {
		List<ICFBamId64GenObj> retval;
		retval = getOrigAsTable().getSchema().getId64GenTableObj().readId64GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen( boolean forceRead ) {
		List<ICFBamId64GenObj> retval;
		retval = getOrigAsTable().getSchema().getId64GenTableObj().readId64GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamServerMethodObj> getOptionalComponentsServerMethods() {
		List<ICFBamServerMethodObj> retval;
		retval = getOrigAsTable().getSchema().getServerMethodTableObj().readServerMethodByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamServerMethodObj> getOptionalComponentsServerMethods( boolean forceRead ) {
		List<ICFBamServerMethodObj> retval;
		retval = getOrigAsTable().getSchema().getServerMethodTableObj().readServerMethodByTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamTableBuff origBuff = getOrigAsTable().getTableBuff();
		CFBamTableBuff myBuff = getTableBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamTableBuff origBuff = getOrigAsTable().getTableBuff();
		CFBamTableBuff myBuff = getTableBuff();
		myBuff.set( origBuff );
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
