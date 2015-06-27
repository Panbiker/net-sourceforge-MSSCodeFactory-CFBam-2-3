// Description: Java7 Object interface for CFBam Table.

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
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public interface ICFBamTableObj
	extends ICFBamScopeObj
{

	/**
	 *	Get the current edition of this Table instance as a ICFBamTableEditObj.
	 *
	 *	@return	The ICFBamTableEditObj edition of this instance.
	 */
	ICFBamTableEditObj getEditAsTable();

	/**
	 *	Get the ICFBamTableTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamTableTableObj table cache which manages this instance.
	 */
	ICFBamTableTableObj getTableTable();

	/**
	 *	Get the CFBamTableBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamTableBuff instance which currently backs this object.
	 */
	CFBamTableBuff getTableBuff();

	/**
	 *	Get the required long attribute SchemaDefId.
	 *
	 *	@return	The required long attribute SchemaDefId.
	 */
	long getRequiredSchemaDefId();

	/**
	 *	Get the optional Long attribute DefSchemaTenantId.
	 *
	 *	@return	The optional Long attribute DefSchemaTenantId.
	 */
	Long getOptionalDefSchemaTenantId();

	/**
	 *	Get the optional Long attribute DefSchemaId.
	 *
	 *	@return	The optional Long attribute DefSchemaId.
	 */
	Long getOptionalDefSchemaId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The optional String attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The optional String attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The optional String attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The optional String attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Get the optional Long attribute PrimaryIndexTenantId.
	 *
	 *	@return	The optional Long attribute PrimaryIndexTenantId.
	 */
	Long getOptionalPrimaryIndexTenantId();

	/**
	 *	Get the optional Long attribute PrimaryIndexId.
	 *
	 *	@return	The optional Long attribute PrimaryIndexId.
	 */
	Long getOptionalPrimaryIndexId();

	/**
	 *	Get the required String attribute TableClassCode.
	 *
	 *	@return	The required String attribute TableClassCode.
	 */
	String getRequiredTableClassCode();

	/**
	 *	Get the optional Long attribute LookupIndexTenantId.
	 *
	 *	@return	The optional Long attribute LookupIndexTenantId.
	 */
	Long getOptionalLookupIndexTenantId();

	/**
	 *	Get the optional Long attribute LookupIndexId.
	 *
	 *	@return	The optional Long attribute LookupIndexId.
	 */
	Long getOptionalLookupIndexId();

	/**
	 *	Get the optional Long attribute AltIndexTenantId.
	 *
	 *	@return	The optional Long attribute AltIndexTenantId.
	 */
	Long getOptionalAltIndexTenantId();

	/**
	 *	Get the optional Long attribute AltIndexId.
	 *
	 *	@return	The optional Long attribute AltIndexId.
	 */
	Long getOptionalAltIndexId();

	/**
	 *	Get the optional Long attribute QualifyingTenantId.
	 *
	 *	@return	The optional Long attribute QualifyingTenantId.
	 */
	Long getOptionalQualifyingTenantId();

	/**
	 *	Get the optional Long attribute QualifyingTableId.
	 *
	 *	@return	The optional Long attribute QualifyingTableId.
	 */
	Long getOptionalQualifyingTableId();

	/**
	 *	Get the required boolean attribute PolyBase.
	 *
	 *	@return	The required boolean attribute PolyBase.
	 */
	boolean getRequiredPolyBase();

	/**
	 *	Get the required boolean attribute IsInstantiable.
	 *
	 *	@return	The required boolean attribute IsInstantiable.
	 */
	boolean getRequiredIsInstantiable();

	/**
	 *	Get the required boolean attribute HasHistory.
	 *
	 *	@return	The required boolean attribute HasHistory.
	 */
	boolean getRequiredHasHistory();

	/**
	 *	Get the required boolean attribute HasAuditColumns.
	 *
	 *	@return	The required boolean attribute HasAuditColumns.
	 */
	boolean getRequiredHasAuditColumns();

	/**
	 *	Get the required short attribute LoaderBehaviourId.
	 *
	 *	@return	The required short attribute LoaderBehaviourId.
	 */
	short getRequiredLoaderBehaviourId();

	/**
	 *	Get the optional Short attribute DataScopeId.
	 *
	 *	@return	The optional Short attribute DataScopeId.
	 */
	Short getOptionalDataScopeId();

	/**
	 *	Get the required short attribute SecurityScopeId.
	 *
	 *	@return	The required short attribute SecurityScopeId.
	 */
	short getRequiredSecurityScopeId();

	/**
	 *	Get the optional Short attribute ViewAccessSecurityId.
	 *
	 *	@return	The optional Short attribute ViewAccessSecurityId.
	 */
	Short getOptionalViewAccessSecurityId();

	/**
	 *	Get the optional Short attribute EditAccessSecurityId.
	 *
	 *	@return	The optional Short attribute EditAccessSecurityId.
	 */
	Short getOptionalEditAccessSecurityId();

	/**
	 *	Get the optional Short attribute ViewAccessFrequencyId.
	 *
	 *	@return	The optional Short attribute ViewAccessFrequencyId.
	 */
	Short getOptionalViewAccessFrequencyId();

	/**
	 *	Get the optional Short attribute EditAccessFrequencyId.
	 *
	 *	@return	The optional Short attribute EditAccessFrequencyId.
	 */
	Short getOptionalEditAccessFrequencyId();

	/**
	 *	Get the optional String attribute JObjMembers.
	 *
	 *	@return	The optional String attribute JObjMembers.
	 */
	String getOptionalJObjMembers();

	/**
	 *	Get the optional String attribute JObjInterface.
	 *
	 *	@return	The optional String attribute JObjInterface.
	 */
	String getOptionalJObjInterface();

	/**
	 *	Get the optional String attribute JObjImport.
	 *
	 *	@return	The optional String attribute JObjImport.
	 */
	String getOptionalJObjImport();

	/**
	 *	Get the optional String attribute JObjImplementation.
	 *
	 *	@return	The optional String attribute JObjImplementation.
	 */
	String getOptionalJObjImplementation();

	/**
	 *	Get the optional String attribute JEditObjMembers.
	 *
	 *	@return	The optional String attribute JEditObjMembers.
	 */
	String getOptionalJEditObjMembers();

	/**
	 *	Get the optional String attribute JEditObjInterface.
	 *
	 *	@return	The optional String attribute JEditObjInterface.
	 */
	String getOptionalJEditObjInterface();

	/**
	 *	Get the optional String attribute JEditObjImport.
	 *
	 *	@return	The optional String attribute JEditObjImport.
	 */
	String getOptionalJEditObjImport();

	/**
	 *	Get the optional String attribute JEditObjImplementation.
	 *
	 *	@return	The optional String attribute JEditObjImplementation.
	 */
	String getOptionalJEditObjImplementation();

	/**
	 *	Get the optional String attribute JTableImport.
	 *
	 *	@return	The optional String attribute JTableImport.
	 */
	String getOptionalJTableImport();

	/**
	 *	Get the optional String attribute JTableMembers.
	 *
	 *	@return	The optional String attribute JTableMembers.
	 */
	String getOptionalJTableMembers();

	/**
	 *	Get the optional String attribute JTableInterface.
	 *
	 *	@return	The optional String attribute JTableInterface.
	 */
	String getOptionalJTableInterface();

	/**
	 *	Get the optional String attribute JTableImplementation.
	 *
	 *	@return	The optional String attribute JTableImplementation.
	 */
	String getOptionalJTableImplementation();

	/**
	 *	Get the optional String attribute JTableObjImport.
	 *
	 *	@return	The optional String attribute JTableObjImport.
	 */
	String getOptionalJTableObjImport();

	/**
	 *	Get the optional String attribute JTableObjMembers.
	 *
	 *	@return	The optional String attribute JTableObjMembers.
	 */
	String getOptionalJTableObjMembers();

	/**
	 *	Get the optional String attribute JTableObjInterface.
	 *
	 *	@return	The optional String attribute JTableObjInterface.
	 */
	String getOptionalJTableObjInterface();

	/**
	 *	Get the optional String attribute JTableObjImplementation.
	 *
	 *	@return	The optional String attribute JTableObjImplementation.
	 */
	String getOptionalJTableObjImplementation();

	/**
	 *	Get the optional String attribute JDb2LUWTableImport.
	 *
	 *	@return	The optional String attribute JDb2LUWTableImport.
	 */
	String getOptionalJDb2LUWTableImport();

	/**
	 *	Get the optional String attribute JDb2LUWTableMembers.
	 *
	 *	@return	The optional String attribute JDb2LUWTableMembers.
	 */
	String getOptionalJDb2LUWTableMembers();

	/**
	 *	Get the optional String attribute JDb2LUWTableImplementation.
	 *
	 *	@return	The optional String attribute JDb2LUWTableImplementation.
	 */
	String getOptionalJDb2LUWTableImplementation();

	/**
	 *	Get the optional String attribute JMSSqlTableImport.
	 *
	 *	@return	The optional String attribute JMSSqlTableImport.
	 */
	String getOptionalJMSSqlTableImport();

	/**
	 *	Get the optional String attribute JMSSqlTableMembers.
	 *
	 *	@return	The optional String attribute JMSSqlTableMembers.
	 */
	String getOptionalJMSSqlTableMembers();

	/**
	 *	Get the optional String attribute JMSSqlTableImplementation.
	 *
	 *	@return	The optional String attribute JMSSqlTableImplementation.
	 */
	String getOptionalJMSSqlTableImplementation();

	/**
	 *	Get the optional String attribute JMySqlTableImport.
	 *
	 *	@return	The optional String attribute JMySqlTableImport.
	 */
	String getOptionalJMySqlTableImport();

	/**
	 *	Get the optional String attribute JMySqlTableMembers.
	 *
	 *	@return	The optional String attribute JMySqlTableMembers.
	 */
	String getOptionalJMySqlTableMembers();

	/**
	 *	Get the optional String attribute JMySqlTableImplementation.
	 *
	 *	@return	The optional String attribute JMySqlTableImplementation.
	 */
	String getOptionalJMySqlTableImplementation();

	/**
	 *	Get the optional String attribute JOracleTableImport.
	 *
	 *	@return	The optional String attribute JOracleTableImport.
	 */
	String getOptionalJOracleTableImport();

	/**
	 *	Get the optional String attribute JOracleTableMembers.
	 *
	 *	@return	The optional String attribute JOracleTableMembers.
	 */
	String getOptionalJOracleTableMembers();

	/**
	 *	Get the optional String attribute JOracleTableImplementation.
	 *
	 *	@return	The optional String attribute JOracleTableImplementation.
	 */
	String getOptionalJOracleTableImplementation();

	/**
	 *	Get the optional String attribute JPgSqlTableImport.
	 *
	 *	@return	The optional String attribute JPgSqlTableImport.
	 */
	String getOptionalJPgSqlTableImport();

	/**
	 *	Get the optional String attribute JPgSqlTableMembers.
	 *
	 *	@return	The optional String attribute JPgSqlTableMembers.
	 */
	String getOptionalJPgSqlTableMembers();

	/**
	 *	Get the optional String attribute JPgSqlTableImplementation.
	 *
	 *	@return	The optional String attribute JPgSqlTableImplementation.
	 */
	String getOptionalJPgSqlTableImplementation();

	/**
	 *	Get the optional String attribute JSybaseTableImport.
	 *
	 *	@return	The optional String attribute JSybaseTableImport.
	 */
	String getOptionalJSybaseTableImport();

	/**
	 *	Get the optional String attribute JSybaseTableMembers.
	 *
	 *	@return	The optional String attribute JSybaseTableMembers.
	 */
	String getOptionalJSybaseTableMembers();

	/**
	 *	Get the optional String attribute JSybaseTableImplementation.
	 *
	 *	@return	The optional String attribute JSybaseTableImplementation.
	 */
	String getOptionalJSybaseTableImplementation();

	/**
	 *	Get the optional String attribute JRamTableImport.
	 *
	 *	@return	The optional String attribute JRamTableImport.
	 */
	String getOptionalJRamTableImport();

	/**
	 *	Get the optional String attribute JRamTableMembers.
	 *
	 *	@return	The optional String attribute JRamTableMembers.
	 */
	String getOptionalJRamTableMembers();

	/**
	 *	Get the optional String attribute JRamTableImplementation.
	 *
	 *	@return	The optional String attribute JRamTableImplementation.
	 */
	String getOptionalJRamTableImplementation();

	/**
	 *	Get the optional String attribute JSaxLoaderImport.
	 *
	 *	@return	The optional String attribute JSaxLoaderImport.
	 */
	String getOptionalJSaxLoaderImport();

	/**
	 *	Get the optional String attribute JSaxLoaderStartElement.
	 *
	 *	@return	The optional String attribute JSaxLoaderStartElement.
	 */
	String getOptionalJSaxLoaderStartElement();

	/**
	 *	Get the optional String attribute JSaxLoaderEndElement.
	 *
	 *	@return	The optional String attribute JSaxLoaderEndElement.
	 */
	String getOptionalJSaxLoaderEndElement();

	/**
	 *	Get the optional String attribute JXMsgTableImport.
	 *
	 *	@return	The optional String attribute JXMsgTableImport.
	 */
	String getOptionalJXMsgTableImport();

	/**
	 *	Get the optional String attribute JXMsgTableFormatters.
	 *
	 *	@return	The optional String attribute JXMsgTableFormatters.
	 */
	String getOptionalJXMsgTableFormatters();

	/**
	 *	Get the optional String attribute JXMsgRqstTableImport.
	 *
	 *	@return	The optional String attribute JXMsgRqstTableImport.
	 */
	String getOptionalJXMsgRqstTableImport();

	/**
	 *	Get the optional String attribute JXMsgRspnTableImport.
	 *
	 *	@return	The optional String attribute JXMsgRspnTableImport.
	 */
	String getOptionalJXMsgRspnTableImport();

	/**
	 *	Get the optional String attribute JXMsgClientTableImport.
	 *
	 *	@return	The optional String attribute JXMsgClientTableImport.
	 */
	String getOptionalJXMsgClientTableImport();

	/**
	 *	Get the optional String attribute JXMsgRqstTableBody.
	 *
	 *	@return	The optional String attribute JXMsgRqstTableBody.
	 */
	String getOptionalJXMsgRqstTableBody();

	/**
	 *	Get the optional String attribute JXMsgRspnTableBody.
	 *
	 *	@return	The optional String attribute JXMsgRspnTableBody.
	 */
	String getOptionalJXMsgRspnTableBody();

	/**
	 *	Get the optional String attribute JXMsgClientTableBody.
	 *
	 *	@return	The optional String attribute JXMsgClientTableBody.
	 */
	String getOptionalJXMsgClientTableBody();

	/**
	 *	Get the required boolean attribute DefaultVisibility.
	 *
	 *	@return	The required boolean attribute DefaultVisibility.
	 */
	boolean getRequiredDefaultVisibility();

	/**
	 *	Get the required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchemaDef();

	/**
	 *	Get the required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead );

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamRelationObj array of instances referenced by the Relation key.
	 *
	 *	@return	The optional ICFBamRelationObj[] array of instances referenced by the Relation key.
	 */
	List<ICFBamRelationObj> getOptionalComponentsRelation();

	/**
	 *	Get the array of optional ICFBamRelationObj array of instances referenced by the Relation key.
	 *
	 *	@return	The optional ICFBamRelationObj[] array of instances referenced by the Relation key.
	 */
	List<ICFBamRelationObj> getOptionalComponentsRelation( boolean forceRead );

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the LookupIndex key.
	 */
	ICFBamIndexObj getOptionalLookupLookupIndex();

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the LookupIndex key.
	 */
	ICFBamIndexObj getOptionalLookupLookupIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the AltIndex key.
	 */
	ICFBamIndexObj getOptionalLookupAltIndex();

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the AltIndex key.
	 */
	ICFBamIndexObj getOptionalLookupAltIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The optional ICFBamTableObj instance referenced by the QualTable key.
	 */
	ICFBamTableObj getOptionalLookupQualTable();

	/**
	 *	Get the optional ICFBamTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The optional ICFBamTableObj instance referenced by the QualTable key.
	 */
	ICFBamTableObj getOptionalLookupQualTable( boolean forceRead );

	/**
	 *	Get the required ICFBamLoaderBehaviourObj instance referenced by the LoaderBehaviour key.
	 *
	 *	@return	The required ICFBamLoaderBehaviourObj instance referenced by the LoaderBehaviour key.
	 */
	ICFBamLoaderBehaviourObj getRequiredLookupLoaderBehaviour();

	/**
	 *	Get the required ICFBamLoaderBehaviourObj instance referenced by the LoaderBehaviour key.
	 *
	 *	@return	The required ICFBamLoaderBehaviourObj instance referenced by the LoaderBehaviour key.
	 */
	ICFBamLoaderBehaviourObj getRequiredLookupLoaderBehaviour( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamIndexObj array of instances referenced by the Index key.
	 *
	 *	@return	The optional ICFBamIndexObj[] array of instances referenced by the Index key.
	 */
	List<ICFBamIndexObj> getOptionalComponentsIndex();

	/**
	 *	Get the array of optional ICFBamIndexObj array of instances referenced by the Index key.
	 *
	 *	@return	The optional ICFBamIndexObj[] array of instances referenced by the Index key.
	 */
	List<ICFBamIndexObj> getOptionalComponentsIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 */
	ICFBamIndexObj getOptionalLookupPrimaryIndex();

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 */
	ICFBamIndexObj getOptionalLookupPrimaryIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 *
	 *	@return	The optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 */
	ICFBamDataScopeObj getOptionalLookupDataScope();

	/**
	 *	Get the optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 *
	 *	@return	The optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 */
	ICFBamDataScopeObj getOptionalLookupDataScope( boolean forceRead );

	/**
	 *	Get the required ICFBamSecurityScopeObj instance referenced by the SecScope key.
	 *
	 *	@return	The required ICFBamSecurityScopeObj instance referenced by the SecScope key.
	 */
	ICFBamSecurityScopeObj getRequiredLookupSecScope();

	/**
	 *	Get the required ICFBamSecurityScopeObj instance referenced by the SecScope key.
	 *
	 *	@return	The required ICFBamSecurityScopeObj instance referenced by the SecScope key.
	 */
	ICFBamSecurityScopeObj getRequiredLookupSecScope( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupVAccSec();

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupVAccSec( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupEAccSec();

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupEAccSec( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupVAccFreq();

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupVAccFreq( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupEAccFreq();

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupEAccFreq( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamValueObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional ICFBamValueObj[] array of instances referenced by the Columns key.
	 */
	List<ICFBamValueObj> getOptionalComponentsColumns();

	/**
	 *	Get the array of optional ICFBamValueObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional ICFBamValueObj[] array of instances referenced by the Columns key.
	 */
	List<ICFBamValueObj> getOptionalComponentsColumns( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamRelationObj array of instances referenced by the ReverseRelations key.
	 *
	 *	@return	The optional ICFBamRelationObj[] array of instances referenced by the ReverseRelations key.
	 */
	List<ICFBamRelationObj> getOptionalChildrenReverseRelations();

	/**
	 *	Get the array of optional ICFBamRelationObj array of instances referenced by the ReverseRelations key.
	 *
	 *	@return	The optional ICFBamRelationObj[] array of instances referenced by the ReverseRelations key.
	 */
	List<ICFBamRelationObj> getOptionalChildrenReverseRelations( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamChainObj array of instances referenced by the Chains key.
	 *
	 *	@return	The optional ICFBamChainObj[] array of instances referenced by the Chains key.
	 */
	List<ICFBamChainObj> getOptionalComponentsChains();

	/**
	 *	Get the array of optional ICFBamChainObj array of instances referenced by the Chains key.
	 *
	 *	@return	The optional ICFBamChainObj[] array of instances referenced by the Chains key.
	 */
	List<ICFBamChainObj> getOptionalComponentsChains( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamDelTopDepObj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamDelTopDepObj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamDelTopDepObj> getOptionalComponentsDelDep();

	/**
	 *	Get the array of optional ICFBamDelTopDepObj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamDelTopDepObj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamDelTopDepObj> getOptionalComponentsDelDep( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamClearTopDepObj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional ICFBamClearTopDepObj[] array of instances referenced by the ClearDep key.
	 */
	List<ICFBamClearTopDepObj> getOptionalComponentsClearDep();

	/**
	 *	Get the array of optional ICFBamClearTopDepObj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional ICFBamClearTopDepObj[] array of instances referenced by the ClearDep key.
	 */
	List<ICFBamClearTopDepObj> getOptionalComponentsClearDep( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamId16GenObj array of instances referenced by the DispId16Gen key.
	 *
	 *	@return	The optional ICFBamId16GenObj[] array of instances referenced by the DispId16Gen key.
	 */
	List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen();

	/**
	 *	Get the array of optional ICFBamId16GenObj array of instances referenced by the DispId16Gen key.
	 *
	 *	@return	The optional ICFBamId16GenObj[] array of instances referenced by the DispId16Gen key.
	 */
	List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamId32GenObj array of instances referenced by the DispId32Gen key.
	 *
	 *	@return	The optional ICFBamId32GenObj[] array of instances referenced by the DispId32Gen key.
	 */
	List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen();

	/**
	 *	Get the array of optional ICFBamId32GenObj array of instances referenced by the DispId32Gen key.
	 *
	 *	@return	The optional ICFBamId32GenObj[] array of instances referenced by the DispId32Gen key.
	 */
	List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamId64GenObj array of instances referenced by the DispId64Gen key.
	 *
	 *	@return	The optional ICFBamId64GenObj[] array of instances referenced by the DispId64Gen key.
	 */
	List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen();

	/**
	 *	Get the array of optional ICFBamId64GenObj array of instances referenced by the DispId64Gen key.
	 *
	 *	@return	The optional ICFBamId64GenObj[] array of instances referenced by the DispId64Gen key.
	 */
	List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamServerMethodObj array of instances referenced by the ServerMethods key.
	 *
	 *	@return	The optional ICFBamServerMethodObj[] array of instances referenced by the ServerMethods key.
	 */
	List<ICFBamServerMethodObj> getOptionalComponentsServerMethods();

	/**
	 *	Get the array of optional ICFBamServerMethodObj array of instances referenced by the ServerMethods key.
	 *
	 *	@return	The optional ICFBamServerMethodObj[] array of instances referenced by the ServerMethods key.
	 */
	List<ICFBamServerMethodObj> getOptionalComponentsServerMethods( boolean forceRead );

    List<ICFBamRelationObj> getOnlyOwnerRelations();
    List<ICFBamRelationObj> getContainerOwnerRelations();
    ICFBamRelationObj getContainerRelation();
    ICFBamRelationObj getInheritedContainerRelation();
    ICFBamRelationObj getOwnerRelation();
    ICFBamRelationObj getInheritedOwnerRelation();
    List<ICFBamRelationObj> getOwnerLookupRelations();
    List<ICFBamRelationObj> getOwnerContainerNamedLookupChainRelations();
    List<ICFBamAtomObj> getChildrenAtoms();
    ICFBamRelationObj getSuperClassRelation();
    List<ICFBamRelationObj> getSubClassRelations();
    ICFBamIndexObj getPrimaryKeyIndex();
    List<ICFBamRelationObj> getFactoryOwnerRelations();
    List<ICFBamIndexObj> getInheritedIndexes();
    List<ICFBamIndexObj> getChildrenIndexes();
    List<ICFBamRelationObj> getInheritedRelations();
    List<ICFBamRelationObj> getChildrenRelations();
}
