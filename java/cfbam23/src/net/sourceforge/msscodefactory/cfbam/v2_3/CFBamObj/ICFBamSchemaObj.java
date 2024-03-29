// Description: Java7 Schema Object interface for CFBam.

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

public interface ICFBamSchemaObj
{
	CFBamAuthorization getAuthorization();
	void setAuthorization( CFBamAuthorization value );

	ICFBamSchema getBackingStore();
	void setBackingStore( ICFBamSchema value );

	String getSchemaName();

	void setSecClusterName( String value );
	ICFBamClusterObj getSecCluster();
	void setSecCluster( ICFBamClusterObj value );

	void setSecTenantName( String value );
	ICFBamTenantObj getSecTenant();
	void setSecTenant( ICFBamTenantObj value );

	void setSecUserName( String value );
	ICFBamSecUserObj getSecUser();
	void setSecUser( ICFBamSecUserObj value );

	void setSecSessionId( UUID value );
	ICFBamSecSessionObj getSecSession();
	void setSecSession( ICFBamSecSessionObj value );

	boolean isConnected();
	boolean connect();
	boolean connect( String username, String password );
	boolean connect( String clusterName, String tenantName, String secUserName, String password );
	void disconnect( boolean doCommit );
	void logout();

	boolean getCacheMisses();
	void setCacheMisses( boolean value );

	void minimizeMemory();

	String fileImport( String fileName, String fileContents );

	/**
	 *	When you first connect to a database, you can opt to specify a database
	 *	name to be used by the session.
	 */
	String getDbSchemaName();

	/**
	 *	PostgreSQL coerces database schema names to lowercase for consistency.
	 */
	String getLowerDbSchemaName();

	/**
	 *	When you set the database name, the database-specific implementation
	 *	of this method does a "commit; use database"-type sequence to change
	 *	to the target database.  This should be specified globally for all
	 *	database connections in a given cluster, so that all of
	 *	the application implementation clients are using the same database instance
	 *	regardless of what's been provided by the custom client implementation,
	 *	be it as a Java application or a web interface written using JEE.
	 */
	void setDbSchemaName( String argDbSchemaName );

	/**
	 *	If a transaction is already opened for the schema connection,
	 *	return false.  If a new transaction is successfully opened,
	 *	return true.  Otherwise throw a RuntimeException detailing
	 *	why a transaction could not be initiated.
	 *
	 *	This permits the database persistence implementations to
	 *	switch between participating in an existing transaction
	 *	or implementing an implicit atomic transaction that is
	 *	committed or rolled back before the method returns:
	 *
	 *		boolean txnInitiated = false;
	 *		try {
	 *			txnInitiated = schema.beginTransaction();
	 *			... business logic and presentation code ...
	 *			if( txnInitiated ) {
	 *				schema.commit();
	 *			}
	 *		}
	 *		catch( RuntimeException e ) {
	 *			if( txnInitiated ) {
	 *				try {
	 *					schema.rollback();
	 *				}
	 *				catch( RuntimeException e ) {
	 *				}
	 *			}
	 *			... report exception or throw exception with cause ...
	 *		}
	 *
	 *	As the current web-form focused implementation will be managing
	 *	the transactions in the Servlet page response, I don't need to
	 *	implement the atomic transaction wrappers yet.
	 */
	boolean isTransactionOpen();
	boolean beginTransaction();
	void commit();
	void rollback();

	/**
	 *	Release any prepared statements acquired by this connection.
	 *	<p>
	 *	Resets the prepared statements so they can acquire the new value of
	 *	<tt>setDbSchemaName()</tt>.
	 */
	void releasePreparedStatements();
	/**
	 *	Get the AccessFrequency interface for the schema.
	 *
	 *	@return	The ICFBamAccessFrequencyTableObj interface implementation for the schema.
	 */
	ICFBamAccessFrequencyTableObj getAccessFrequencyTableObj();

	/**
	 *	Get the AccessSecurity interface for the schema.
	 *
	 *	@return	The ICFBamAccessSecurityTableObj interface implementation for the schema.
	 */
	ICFBamAccessSecurityTableObj getAccessSecurityTableObj();

	/**
	 *	Get the Atom interface for the schema.
	 *
	 *	@return	The ICFBamAtomTableObj interface implementation for the schema.
	 */
	ICFBamAtomTableObj getAtomTableObj();

	/**
	 *	Get the AuditAction interface for the schema.
	 *
	 *	@return	The ICFBamAuditActionTableObj interface implementation for the schema.
	 */
	ICFBamAuditActionTableObj getAuditActionTableObj();

	/**
	 *	Get the BlobCol interface for the schema.
	 *
	 *	@return	The ICFBamBlobColTableObj interface implementation for the schema.
	 */
	ICFBamBlobColTableObj getBlobColTableObj();

	/**
	 *	Get the BlobDef interface for the schema.
	 *
	 *	@return	The ICFBamBlobDefTableObj interface implementation for the schema.
	 */
	ICFBamBlobDefTableObj getBlobDefTableObj();

	/**
	 *	Get the BlobType interface for the schema.
	 *
	 *	@return	The ICFBamBlobTypeTableObj interface implementation for the schema.
	 */
	ICFBamBlobTypeTableObj getBlobTypeTableObj();

	/**
	 *	Get the BoolCol interface for the schema.
	 *
	 *	@return	The ICFBamBoolColTableObj interface implementation for the schema.
	 */
	ICFBamBoolColTableObj getBoolColTableObj();

	/**
	 *	Get the BoolDef interface for the schema.
	 *
	 *	@return	The ICFBamBoolDefTableObj interface implementation for the schema.
	 */
	ICFBamBoolDefTableObj getBoolDefTableObj();

	/**
	 *	Get the BoolType interface for the schema.
	 *
	 *	@return	The ICFBamBoolTypeTableObj interface implementation for the schema.
	 */
	ICFBamBoolTypeTableObj getBoolTypeTableObj();

	/**
	 *	Get the Chain interface for the schema.
	 *
	 *	@return	The ICFBamChainTableObj interface implementation for the schema.
	 */
	ICFBamChainTableObj getChainTableObj();

	/**
	 *	Get the ClearDep interface for the schema.
	 *
	 *	@return	The ICFBamClearDepTableObj interface implementation for the schema.
	 */
	ICFBamClearDepTableObj getClearDepTableObj();

	/**
	 *	Get the ClearSubDep1 interface for the schema.
	 *
	 *	@return	The ICFBamClearSubDep1TableObj interface implementation for the schema.
	 */
	ICFBamClearSubDep1TableObj getClearSubDep1TableObj();

	/**
	 *	Get the ClearSubDep2 interface for the schema.
	 *
	 *	@return	The ICFBamClearSubDep2TableObj interface implementation for the schema.
	 */
	ICFBamClearSubDep2TableObj getClearSubDep2TableObj();

	/**
	 *	Get the ClearSubDep3 interface for the schema.
	 *
	 *	@return	The ICFBamClearSubDep3TableObj interface implementation for the schema.
	 */
	ICFBamClearSubDep3TableObj getClearSubDep3TableObj();

	/**
	 *	Get the ClearTopDep interface for the schema.
	 *
	 *	@return	The ICFBamClearTopDepTableObj interface implementation for the schema.
	 */
	ICFBamClearTopDepTableObj getClearTopDepTableObj();

	/**
	 *	Get the Cluster interface for the schema.
	 *
	 *	@return	The ICFBamClusterTableObj interface implementation for the schema.
	 */
	ICFBamClusterTableObj getClusterTableObj();

	/**
	 *	Get the DataScope interface for the schema.
	 *
	 *	@return	The ICFBamDataScopeTableObj interface implementation for the schema.
	 */
	ICFBamDataScopeTableObj getDataScopeTableObj();

	/**
	 *	Get the DateCol interface for the schema.
	 *
	 *	@return	The ICFBamDateColTableObj interface implementation for the schema.
	 */
	ICFBamDateColTableObj getDateColTableObj();

	/**
	 *	Get the DateDef interface for the schema.
	 *
	 *	@return	The ICFBamDateDefTableObj interface implementation for the schema.
	 */
	ICFBamDateDefTableObj getDateDefTableObj();

	/**
	 *	Get the DateType interface for the schema.
	 *
	 *	@return	The ICFBamDateTypeTableObj interface implementation for the schema.
	 */
	ICFBamDateTypeTableObj getDateTypeTableObj();

	/**
	 *	Get the DelDep interface for the schema.
	 *
	 *	@return	The ICFBamDelDepTableObj interface implementation for the schema.
	 */
	ICFBamDelDepTableObj getDelDepTableObj();

	/**
	 *	Get the DelSubDep1 interface for the schema.
	 *
	 *	@return	The ICFBamDelSubDep1TableObj interface implementation for the schema.
	 */
	ICFBamDelSubDep1TableObj getDelSubDep1TableObj();

	/**
	 *	Get the DelSubDep2 interface for the schema.
	 *
	 *	@return	The ICFBamDelSubDep2TableObj interface implementation for the schema.
	 */
	ICFBamDelSubDep2TableObj getDelSubDep2TableObj();

	/**
	 *	Get the DelSubDep3 interface for the schema.
	 *
	 *	@return	The ICFBamDelSubDep3TableObj interface implementation for the schema.
	 */
	ICFBamDelSubDep3TableObj getDelSubDep3TableObj();

	/**
	 *	Get the DelTopDep interface for the schema.
	 *
	 *	@return	The ICFBamDelTopDepTableObj interface implementation for the schema.
	 */
	ICFBamDelTopDepTableObj getDelTopDepTableObj();

	/**
	 *	Get the Domain interface for the schema.
	 *
	 *	@return	The ICFBamDomainTableObj interface implementation for the schema.
	 */
	ICFBamDomainTableObj getDomainTableObj();

	/**
	 *	Get the DomainBase interface for the schema.
	 *
	 *	@return	The ICFBamDomainBaseTableObj interface implementation for the schema.
	 */
	ICFBamDomainBaseTableObj getDomainBaseTableObj();

	/**
	 *	Get the DoubleCol interface for the schema.
	 *
	 *	@return	The ICFBamDoubleColTableObj interface implementation for the schema.
	 */
	ICFBamDoubleColTableObj getDoubleColTableObj();

	/**
	 *	Get the DoubleDef interface for the schema.
	 *
	 *	@return	The ICFBamDoubleDefTableObj interface implementation for the schema.
	 */
	ICFBamDoubleDefTableObj getDoubleDefTableObj();

	/**
	 *	Get the DoubleType interface for the schema.
	 *
	 *	@return	The ICFBamDoubleTypeTableObj interface implementation for the schema.
	 */
	ICFBamDoubleTypeTableObj getDoubleTypeTableObj();

	/**
	 *	Get the EnumCol interface for the schema.
	 *
	 *	@return	The ICFBamEnumColTableObj interface implementation for the schema.
	 */
	ICFBamEnumColTableObj getEnumColTableObj();

	/**
	 *	Get the EnumDef interface for the schema.
	 *
	 *	@return	The ICFBamEnumDefTableObj interface implementation for the schema.
	 */
	ICFBamEnumDefTableObj getEnumDefTableObj();

	/**
	 *	Get the EnumTag interface for the schema.
	 *
	 *	@return	The ICFBamEnumTagTableObj interface implementation for the schema.
	 */
	ICFBamEnumTagTableObj getEnumTagTableObj();

	/**
	 *	Get the EnumType interface for the schema.
	 *
	 *	@return	The ICFBamEnumTypeTableObj interface implementation for the schema.
	 */
	ICFBamEnumTypeTableObj getEnumTypeTableObj();

	/**
	 *	Get the FloatCol interface for the schema.
	 *
	 *	@return	The ICFBamFloatColTableObj interface implementation for the schema.
	 */
	ICFBamFloatColTableObj getFloatColTableObj();

	/**
	 *	Get the FloatDef interface for the schema.
	 *
	 *	@return	The ICFBamFloatDefTableObj interface implementation for the schema.
	 */
	ICFBamFloatDefTableObj getFloatDefTableObj();

	/**
	 *	Get the FloatType interface for the schema.
	 *
	 *	@return	The ICFBamFloatTypeTableObj interface implementation for the schema.
	 */
	ICFBamFloatTypeTableObj getFloatTypeTableObj();

	/**
	 *	Get the HostNode interface for the schema.
	 *
	 *	@return	The ICFBamHostNodeTableObj interface implementation for the schema.
	 */
	ICFBamHostNodeTableObj getHostNodeTableObj();

	/**
	 *	Get the ISOCountry interface for the schema.
	 *
	 *	@return	The ICFBamISOCountryTableObj interface implementation for the schema.
	 */
	ICFBamISOCountryTableObj getISOCountryTableObj();

	/**
	 *	Get the ISOCountryCurrency interface for the schema.
	 *
	 *	@return	The ICFBamISOCountryCurrencyTableObj interface implementation for the schema.
	 */
	ICFBamISOCountryCurrencyTableObj getISOCountryCurrencyTableObj();

	/**
	 *	Get the ISOCountryLanguage interface for the schema.
	 *
	 *	@return	The ICFBamISOCountryLanguageTableObj interface implementation for the schema.
	 */
	ICFBamISOCountryLanguageTableObj getISOCountryLanguageTableObj();

	/**
	 *	Get the ISOCurrency interface for the schema.
	 *
	 *	@return	The ICFBamISOCurrencyTableObj interface implementation for the schema.
	 */
	ICFBamISOCurrencyTableObj getISOCurrencyTableObj();

	/**
	 *	Get the ISOLanguage interface for the schema.
	 *
	 *	@return	The ICFBamISOLanguageTableObj interface implementation for the schema.
	 */
	ICFBamISOLanguageTableObj getISOLanguageTableObj();

	/**
	 *	Get the ISOTimezone interface for the schema.
	 *
	 *	@return	The ICFBamISOTimezoneTableObj interface implementation for the schema.
	 */
	ICFBamISOTimezoneTableObj getISOTimezoneTableObj();

	/**
	 *	Get the Id16Gen interface for the schema.
	 *
	 *	@return	The ICFBamId16GenTableObj interface implementation for the schema.
	 */
	ICFBamId16GenTableObj getId16GenTableObj();

	/**
	 *	Get the Id32Gen interface for the schema.
	 *
	 *	@return	The ICFBamId32GenTableObj interface implementation for the schema.
	 */
	ICFBamId32GenTableObj getId32GenTableObj();

	/**
	 *	Get the Id64Gen interface for the schema.
	 *
	 *	@return	The ICFBamId64GenTableObj interface implementation for the schema.
	 */
	ICFBamId64GenTableObj getId64GenTableObj();

	/**
	 *	Get the Index interface for the schema.
	 *
	 *	@return	The ICFBamIndexTableObj interface implementation for the schema.
	 */
	ICFBamIndexTableObj getIndexTableObj();

	/**
	 *	Get the IndexCol interface for the schema.
	 *
	 *	@return	The ICFBamIndexColTableObj interface implementation for the schema.
	 */
	ICFBamIndexColTableObj getIndexColTableObj();

	/**
	 *	Get the Int16Col interface for the schema.
	 *
	 *	@return	The ICFBamInt16ColTableObj interface implementation for the schema.
	 */
	ICFBamInt16ColTableObj getInt16ColTableObj();

	/**
	 *	Get the Int16Def interface for the schema.
	 *
	 *	@return	The ICFBamInt16DefTableObj interface implementation for the schema.
	 */
	ICFBamInt16DefTableObj getInt16DefTableObj();

	/**
	 *	Get the Int16Type interface for the schema.
	 *
	 *	@return	The ICFBamInt16TypeTableObj interface implementation for the schema.
	 */
	ICFBamInt16TypeTableObj getInt16TypeTableObj();

	/**
	 *	Get the Int32Col interface for the schema.
	 *
	 *	@return	The ICFBamInt32ColTableObj interface implementation for the schema.
	 */
	ICFBamInt32ColTableObj getInt32ColTableObj();

	/**
	 *	Get the Int32Def interface for the schema.
	 *
	 *	@return	The ICFBamInt32DefTableObj interface implementation for the schema.
	 */
	ICFBamInt32DefTableObj getInt32DefTableObj();

	/**
	 *	Get the Int32Type interface for the schema.
	 *
	 *	@return	The ICFBamInt32TypeTableObj interface implementation for the schema.
	 */
	ICFBamInt32TypeTableObj getInt32TypeTableObj();

	/**
	 *	Get the Int64Col interface for the schema.
	 *
	 *	@return	The ICFBamInt64ColTableObj interface implementation for the schema.
	 */
	ICFBamInt64ColTableObj getInt64ColTableObj();

	/**
	 *	Get the Int64Def interface for the schema.
	 *
	 *	@return	The ICFBamInt64DefTableObj interface implementation for the schema.
	 */
	ICFBamInt64DefTableObj getInt64DefTableObj();

	/**
	 *	Get the Int64Type interface for the schema.
	 *
	 *	@return	The ICFBamInt64TypeTableObj interface implementation for the schema.
	 */
	ICFBamInt64TypeTableObj getInt64TypeTableObj();

	/**
	 *	Get the License interface for the schema.
	 *
	 *	@return	The ICFBamLicenseTableObj interface implementation for the schema.
	 */
	ICFBamLicenseTableObj getLicenseTableObj();

	/**
	 *	Get the LoaderBehaviour interface for the schema.
	 *
	 *	@return	The ICFBamLoaderBehaviourTableObj interface implementation for the schema.
	 */
	ICFBamLoaderBehaviourTableObj getLoaderBehaviourTableObj();

	/**
	 *	Get the MajorVersion interface for the schema.
	 *
	 *	@return	The ICFBamMajorVersionTableObj interface implementation for the schema.
	 */
	ICFBamMajorVersionTableObj getMajorVersionTableObj();

	/**
	 *	Get the MimeType interface for the schema.
	 *
	 *	@return	The ICFBamMimeTypeTableObj interface implementation for the schema.
	 */
	ICFBamMimeTypeTableObj getMimeTypeTableObj();

	/**
	 *	Get the MinorVersion interface for the schema.
	 *
	 *	@return	The ICFBamMinorVersionTableObj interface implementation for the schema.
	 */
	ICFBamMinorVersionTableObj getMinorVersionTableObj();

	/**
	 *	Get the NmTokenCol interface for the schema.
	 *
	 *	@return	The ICFBamNmTokenColTableObj interface implementation for the schema.
	 */
	ICFBamNmTokenColTableObj getNmTokenColTableObj();

	/**
	 *	Get the NmTokenDef interface for the schema.
	 *
	 *	@return	The ICFBamNmTokenDefTableObj interface implementation for the schema.
	 */
	ICFBamNmTokenDefTableObj getNmTokenDefTableObj();

	/**
	 *	Get the NmTokenType interface for the schema.
	 *
	 *	@return	The ICFBamNmTokenTypeTableObj interface implementation for the schema.
	 */
	ICFBamNmTokenTypeTableObj getNmTokenTypeTableObj();

	/**
	 *	Get the NmTokensCol interface for the schema.
	 *
	 *	@return	The ICFBamNmTokensColTableObj interface implementation for the schema.
	 */
	ICFBamNmTokensColTableObj getNmTokensColTableObj();

	/**
	 *	Get the NmTokensDef interface for the schema.
	 *
	 *	@return	The ICFBamNmTokensDefTableObj interface implementation for the schema.
	 */
	ICFBamNmTokensDefTableObj getNmTokensDefTableObj();

	/**
	 *	Get the NmTokensType interface for the schema.
	 *
	 *	@return	The ICFBamNmTokensTypeTableObj interface implementation for the schema.
	 */
	ICFBamNmTokensTypeTableObj getNmTokensTypeTableObj();

	/**
	 *	Get the NumberCol interface for the schema.
	 *
	 *	@return	The ICFBamNumberColTableObj interface implementation for the schema.
	 */
	ICFBamNumberColTableObj getNumberColTableObj();

	/**
	 *	Get the NumberDef interface for the schema.
	 *
	 *	@return	The ICFBamNumberDefTableObj interface implementation for the schema.
	 */
	ICFBamNumberDefTableObj getNumberDefTableObj();

	/**
	 *	Get the NumberType interface for the schema.
	 *
	 *	@return	The ICFBamNumberTypeTableObj interface implementation for the schema.
	 */
	ICFBamNumberTypeTableObj getNumberTypeTableObj();

	/**
	 *	Get the Param interface for the schema.
	 *
	 *	@return	The ICFBamParamTableObj interface implementation for the schema.
	 */
	ICFBamParamTableObj getParamTableObj();

	/**
	 *	Get the PopDep interface for the schema.
	 *
	 *	@return	The ICFBamPopDepTableObj interface implementation for the schema.
	 */
	ICFBamPopDepTableObj getPopDepTableObj();

	/**
	 *	Get the PopSubDep1 interface for the schema.
	 *
	 *	@return	The ICFBamPopSubDep1TableObj interface implementation for the schema.
	 */
	ICFBamPopSubDep1TableObj getPopSubDep1TableObj();

	/**
	 *	Get the PopSubDep2 interface for the schema.
	 *
	 *	@return	The ICFBamPopSubDep2TableObj interface implementation for the schema.
	 */
	ICFBamPopSubDep2TableObj getPopSubDep2TableObj();

	/**
	 *	Get the PopSubDep3 interface for the schema.
	 *
	 *	@return	The ICFBamPopSubDep3TableObj interface implementation for the schema.
	 */
	ICFBamPopSubDep3TableObj getPopSubDep3TableObj();

	/**
	 *	Get the PopTopDep interface for the schema.
	 *
	 *	@return	The ICFBamPopTopDepTableObj interface implementation for the schema.
	 */
	ICFBamPopTopDepTableObj getPopTopDepTableObj();

	/**
	 *	Get the ProjectBase interface for the schema.
	 *
	 *	@return	The ICFBamProjectBaseTableObj interface implementation for the schema.
	 */
	ICFBamProjectBaseTableObj getProjectBaseTableObj();

	/**
	 *	Get the RealProject interface for the schema.
	 *
	 *	@return	The ICFBamRealProjectTableObj interface implementation for the schema.
	 */
	ICFBamRealProjectTableObj getRealProjectTableObj();

	/**
	 *	Get the Relation interface for the schema.
	 *
	 *	@return	The ICFBamRelationTableObj interface implementation for the schema.
	 */
	ICFBamRelationTableObj getRelationTableObj();

	/**
	 *	Get the RelationCol interface for the schema.
	 *
	 *	@return	The ICFBamRelationColTableObj interface implementation for the schema.
	 */
	ICFBamRelationColTableObj getRelationColTableObj();

	/**
	 *	Get the RelationType interface for the schema.
	 *
	 *	@return	The ICFBamRelationTypeTableObj interface implementation for the schema.
	 */
	ICFBamRelationTypeTableObj getRelationTypeTableObj();

	/**
	 *	Get the SchemaDef interface for the schema.
	 *
	 *	@return	The ICFBamSchemaDefTableObj interface implementation for the schema.
	 */
	ICFBamSchemaDefTableObj getSchemaDefTableObj();

	/**
	 *	Get the SchemaRef interface for the schema.
	 *
	 *	@return	The ICFBamSchemaRefTableObj interface implementation for the schema.
	 */
	ICFBamSchemaRefTableObj getSchemaRefTableObj();

	/**
	 *	Get the Scope interface for the schema.
	 *
	 *	@return	The ICFBamScopeTableObj interface implementation for the schema.
	 */
	ICFBamScopeTableObj getScopeTableObj();

	/**
	 *	Get the SecApp interface for the schema.
	 *
	 *	@return	The ICFBamSecAppTableObj interface implementation for the schema.
	 */
	ICFBamSecAppTableObj getSecAppTableObj();

	/**
	 *	Get the SecDevice interface for the schema.
	 *
	 *	@return	The ICFBamSecDeviceTableObj interface implementation for the schema.
	 */
	ICFBamSecDeviceTableObj getSecDeviceTableObj();

	/**
	 *	Get the SecForm interface for the schema.
	 *
	 *	@return	The ICFBamSecFormTableObj interface implementation for the schema.
	 */
	ICFBamSecFormTableObj getSecFormTableObj();

	/**
	 *	Get the SecGroup interface for the schema.
	 *
	 *	@return	The ICFBamSecGroupTableObj interface implementation for the schema.
	 */
	ICFBamSecGroupTableObj getSecGroupTableObj();

	/**
	 *	Get the SecGroupForm interface for the schema.
	 *
	 *	@return	The ICFBamSecGroupFormTableObj interface implementation for the schema.
	 */
	ICFBamSecGroupFormTableObj getSecGroupFormTableObj();

	/**
	 *	Get the SecGroupInclude interface for the schema.
	 *
	 *	@return	The ICFBamSecGroupIncludeTableObj interface implementation for the schema.
	 */
	ICFBamSecGroupIncludeTableObj getSecGroupIncludeTableObj();

	/**
	 *	Get the SecGroupMember interface for the schema.
	 *
	 *	@return	The ICFBamSecGroupMemberTableObj interface implementation for the schema.
	 */
	ICFBamSecGroupMemberTableObj getSecGroupMemberTableObj();

	/**
	 *	Get the SecSession interface for the schema.
	 *
	 *	@return	The ICFBamSecSessionTableObj interface implementation for the schema.
	 */
	ICFBamSecSessionTableObj getSecSessionTableObj();

	/**
	 *	Get the SecUser interface for the schema.
	 *
	 *	@return	The ICFBamSecUserTableObj interface implementation for the schema.
	 */
	ICFBamSecUserTableObj getSecUserTableObj();

	/**
	 *	Get the SecurityScope interface for the schema.
	 *
	 *	@return	The ICFBamSecurityScopeTableObj interface implementation for the schema.
	 */
	ICFBamSecurityScopeTableObj getSecurityScopeTableObj();

	/**
	 *	Get the ServerListFunc interface for the schema.
	 *
	 *	@return	The ICFBamServerListFuncTableObj interface implementation for the schema.
	 */
	ICFBamServerListFuncTableObj getServerListFuncTableObj();

	/**
	 *	Get the ServerMethod interface for the schema.
	 *
	 *	@return	The ICFBamServerMethodTableObj interface implementation for the schema.
	 */
	ICFBamServerMethodTableObj getServerMethodTableObj();

	/**
	 *	Get the ServerObjFunc interface for the schema.
	 *
	 *	@return	The ICFBamServerObjFuncTableObj interface implementation for the schema.
	 */
	ICFBamServerObjFuncTableObj getServerObjFuncTableObj();

	/**
	 *	Get the ServerProc interface for the schema.
	 *
	 *	@return	The ICFBamServerProcTableObj interface implementation for the schema.
	 */
	ICFBamServerProcTableObj getServerProcTableObj();

	/**
	 *	Get the Service interface for the schema.
	 *
	 *	@return	The ICFBamServiceTableObj interface implementation for the schema.
	 */
	ICFBamServiceTableObj getServiceTableObj();

	/**
	 *	Get the ServiceType interface for the schema.
	 *
	 *	@return	The ICFBamServiceTypeTableObj interface implementation for the schema.
	 */
	ICFBamServiceTypeTableObj getServiceTypeTableObj();

	/**
	 *	Get the StringCol interface for the schema.
	 *
	 *	@return	The ICFBamStringColTableObj interface implementation for the schema.
	 */
	ICFBamStringColTableObj getStringColTableObj();

	/**
	 *	Get the StringDef interface for the schema.
	 *
	 *	@return	The ICFBamStringDefTableObj interface implementation for the schema.
	 */
	ICFBamStringDefTableObj getStringDefTableObj();

	/**
	 *	Get the StringType interface for the schema.
	 *
	 *	@return	The ICFBamStringTypeTableObj interface implementation for the schema.
	 */
	ICFBamStringTypeTableObj getStringTypeTableObj();

	/**
	 *	Get the SubProject interface for the schema.
	 *
	 *	@return	The ICFBamSubProjectTableObj interface implementation for the schema.
	 */
	ICFBamSubProjectTableObj getSubProjectTableObj();

	/**
	 *	Get the SysCluster interface for the schema.
	 *
	 *	@return	The ICFBamSysClusterTableObj interface implementation for the schema.
	 */
	ICFBamSysClusterTableObj getSysClusterTableObj();

	/**
	 *	Get the TSecGroup interface for the schema.
	 *
	 *	@return	The ICFBamTSecGroupTableObj interface implementation for the schema.
	 */
	ICFBamTSecGroupTableObj getTSecGroupTableObj();

	/**
	 *	Get the TSecGroupInclude interface for the schema.
	 *
	 *	@return	The ICFBamTSecGroupIncludeTableObj interface implementation for the schema.
	 */
	ICFBamTSecGroupIncludeTableObj getTSecGroupIncludeTableObj();

	/**
	 *	Get the TSecGroupMember interface for the schema.
	 *
	 *	@return	The ICFBamTSecGroupMemberTableObj interface implementation for the schema.
	 */
	ICFBamTSecGroupMemberTableObj getTSecGroupMemberTableObj();

	/**
	 *	Get the TZDateCol interface for the schema.
	 *
	 *	@return	The ICFBamTZDateColTableObj interface implementation for the schema.
	 */
	ICFBamTZDateColTableObj getTZDateColTableObj();

	/**
	 *	Get the TZDateDef interface for the schema.
	 *
	 *	@return	The ICFBamTZDateDefTableObj interface implementation for the schema.
	 */
	ICFBamTZDateDefTableObj getTZDateDefTableObj();

	/**
	 *	Get the TZDateType interface for the schema.
	 *
	 *	@return	The ICFBamTZDateTypeTableObj interface implementation for the schema.
	 */
	ICFBamTZDateTypeTableObj getTZDateTypeTableObj();

	/**
	 *	Get the TZTimeCol interface for the schema.
	 *
	 *	@return	The ICFBamTZTimeColTableObj interface implementation for the schema.
	 */
	ICFBamTZTimeColTableObj getTZTimeColTableObj();

	/**
	 *	Get the TZTimeDef interface for the schema.
	 *
	 *	@return	The ICFBamTZTimeDefTableObj interface implementation for the schema.
	 */
	ICFBamTZTimeDefTableObj getTZTimeDefTableObj();

	/**
	 *	Get the TZTimeType interface for the schema.
	 *
	 *	@return	The ICFBamTZTimeTypeTableObj interface implementation for the schema.
	 */
	ICFBamTZTimeTypeTableObj getTZTimeTypeTableObj();

	/**
	 *	Get the TZTimestampCol interface for the schema.
	 *
	 *	@return	The ICFBamTZTimestampColTableObj interface implementation for the schema.
	 */
	ICFBamTZTimestampColTableObj getTZTimestampColTableObj();

	/**
	 *	Get the TZTimestampDef interface for the schema.
	 *
	 *	@return	The ICFBamTZTimestampDefTableObj interface implementation for the schema.
	 */
	ICFBamTZTimestampDefTableObj getTZTimestampDefTableObj();

	/**
	 *	Get the TZTimestampType interface for the schema.
	 *
	 *	@return	The ICFBamTZTimestampTypeTableObj interface implementation for the schema.
	 */
	ICFBamTZTimestampTypeTableObj getTZTimestampTypeTableObj();

	/**
	 *	Get the Table interface for the schema.
	 *
	 *	@return	The ICFBamTableTableObj interface implementation for the schema.
	 */
	ICFBamTableTableObj getTableTableObj();

	/**
	 *	Get the TableCol interface for the schema.
	 *
	 *	@return	The ICFBamTableColTableObj interface implementation for the schema.
	 */
	ICFBamTableColTableObj getTableColTableObj();

	/**
	 *	Get the Tenant interface for the schema.
	 *
	 *	@return	The ICFBamTenantTableObj interface implementation for the schema.
	 */
	ICFBamTenantTableObj getTenantTableObj();

	/**
	 *	Get the TextCol interface for the schema.
	 *
	 *	@return	The ICFBamTextColTableObj interface implementation for the schema.
	 */
	ICFBamTextColTableObj getTextColTableObj();

	/**
	 *	Get the TextDef interface for the schema.
	 *
	 *	@return	The ICFBamTextDefTableObj interface implementation for the schema.
	 */
	ICFBamTextDefTableObj getTextDefTableObj();

	/**
	 *	Get the TextType interface for the schema.
	 *
	 *	@return	The ICFBamTextTypeTableObj interface implementation for the schema.
	 */
	ICFBamTextTypeTableObj getTextTypeTableObj();

	/**
	 *	Get the TimeCol interface for the schema.
	 *
	 *	@return	The ICFBamTimeColTableObj interface implementation for the schema.
	 */
	ICFBamTimeColTableObj getTimeColTableObj();

	/**
	 *	Get the TimeDef interface for the schema.
	 *
	 *	@return	The ICFBamTimeDefTableObj interface implementation for the schema.
	 */
	ICFBamTimeDefTableObj getTimeDefTableObj();

	/**
	 *	Get the TimeType interface for the schema.
	 *
	 *	@return	The ICFBamTimeTypeTableObj interface implementation for the schema.
	 */
	ICFBamTimeTypeTableObj getTimeTypeTableObj();

	/**
	 *	Get the TimestampCol interface for the schema.
	 *
	 *	@return	The ICFBamTimestampColTableObj interface implementation for the schema.
	 */
	ICFBamTimestampColTableObj getTimestampColTableObj();

	/**
	 *	Get the TimestampDef interface for the schema.
	 *
	 *	@return	The ICFBamTimestampDefTableObj interface implementation for the schema.
	 */
	ICFBamTimestampDefTableObj getTimestampDefTableObj();

	/**
	 *	Get the TimestampType interface for the schema.
	 *
	 *	@return	The ICFBamTimestampTypeTableObj interface implementation for the schema.
	 */
	ICFBamTimestampTypeTableObj getTimestampTypeTableObj();

	/**
	 *	Get the Tld interface for the schema.
	 *
	 *	@return	The ICFBamTldTableObj interface implementation for the schema.
	 */
	ICFBamTldTableObj getTldTableObj();

	/**
	 *	Get the TokenCol interface for the schema.
	 *
	 *	@return	The ICFBamTokenColTableObj interface implementation for the schema.
	 */
	ICFBamTokenColTableObj getTokenColTableObj();

	/**
	 *	Get the TokenDef interface for the schema.
	 *
	 *	@return	The ICFBamTokenDefTableObj interface implementation for the schema.
	 */
	ICFBamTokenDefTableObj getTokenDefTableObj();

	/**
	 *	Get the TokenType interface for the schema.
	 *
	 *	@return	The ICFBamTokenTypeTableObj interface implementation for the schema.
	 */
	ICFBamTokenTypeTableObj getTokenTypeTableObj();

	/**
	 *	Get the TopDomain interface for the schema.
	 *
	 *	@return	The ICFBamTopDomainTableObj interface implementation for the schema.
	 */
	ICFBamTopDomainTableObj getTopDomainTableObj();

	/**
	 *	Get the TopProject interface for the schema.
	 *
	 *	@return	The ICFBamTopProjectTableObj interface implementation for the schema.
	 */
	ICFBamTopProjectTableObj getTopProjectTableObj();

	/**
	 *	Get the UInt16Col interface for the schema.
	 *
	 *	@return	The ICFBamUInt16ColTableObj interface implementation for the schema.
	 */
	ICFBamUInt16ColTableObj getUInt16ColTableObj();

	/**
	 *	Get the UInt16Def interface for the schema.
	 *
	 *	@return	The ICFBamUInt16DefTableObj interface implementation for the schema.
	 */
	ICFBamUInt16DefTableObj getUInt16DefTableObj();

	/**
	 *	Get the UInt16Type interface for the schema.
	 *
	 *	@return	The ICFBamUInt16TypeTableObj interface implementation for the schema.
	 */
	ICFBamUInt16TypeTableObj getUInt16TypeTableObj();

	/**
	 *	Get the UInt32Col interface for the schema.
	 *
	 *	@return	The ICFBamUInt32ColTableObj interface implementation for the schema.
	 */
	ICFBamUInt32ColTableObj getUInt32ColTableObj();

	/**
	 *	Get the UInt32Def interface for the schema.
	 *
	 *	@return	The ICFBamUInt32DefTableObj interface implementation for the schema.
	 */
	ICFBamUInt32DefTableObj getUInt32DefTableObj();

	/**
	 *	Get the UInt32Type interface for the schema.
	 *
	 *	@return	The ICFBamUInt32TypeTableObj interface implementation for the schema.
	 */
	ICFBamUInt32TypeTableObj getUInt32TypeTableObj();

	/**
	 *	Get the UInt64Col interface for the schema.
	 *
	 *	@return	The ICFBamUInt64ColTableObj interface implementation for the schema.
	 */
	ICFBamUInt64ColTableObj getUInt64ColTableObj();

	/**
	 *	Get the UInt64Def interface for the schema.
	 *
	 *	@return	The ICFBamUInt64DefTableObj interface implementation for the schema.
	 */
	ICFBamUInt64DefTableObj getUInt64DefTableObj();

	/**
	 *	Get the UInt64Type interface for the schema.
	 *
	 *	@return	The ICFBamUInt64TypeTableObj interface implementation for the schema.
	 */
	ICFBamUInt64TypeTableObj getUInt64TypeTableObj();

	/**
	 *	Get the URLProtocol interface for the schema.
	 *
	 *	@return	The ICFBamURLProtocolTableObj interface implementation for the schema.
	 */
	ICFBamURLProtocolTableObj getURLProtocolTableObj();

	/**
	 *	Get the UuidCol interface for the schema.
	 *
	 *	@return	The ICFBamUuidColTableObj interface implementation for the schema.
	 */
	ICFBamUuidColTableObj getUuidColTableObj();

	/**
	 *	Get the UuidDef interface for the schema.
	 *
	 *	@return	The ICFBamUuidDefTableObj interface implementation for the schema.
	 */
	ICFBamUuidDefTableObj getUuidDefTableObj();

	/**
	 *	Get the UuidGen interface for the schema.
	 *
	 *	@return	The ICFBamUuidGenTableObj interface implementation for the schema.
	 */
	ICFBamUuidGenTableObj getUuidGenTableObj();

	/**
	 *	Get the UuidType interface for the schema.
	 *
	 *	@return	The ICFBamUuidTypeTableObj interface implementation for the schema.
	 */
	ICFBamUuidTypeTableObj getUuidTypeTableObj();

	/**
	 *	Get the Value interface for the schema.
	 *
	 *	@return	The ICFBamValueTableObj interface implementation for the schema.
	 */
	ICFBamValueTableObj getValueTableObj();

	/**
	 *	Get the Version interface for the schema.
	 *
	 *	@return	The ICFBamVersionTableObj interface implementation for the schema.
	 */
	ICFBamVersionTableObj getVersionTableObj();
}
