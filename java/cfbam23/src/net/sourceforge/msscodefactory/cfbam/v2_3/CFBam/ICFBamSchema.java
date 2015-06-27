// Description: Java7 interface for a CFBam schema.

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

public interface ICFBamSchema
{

	CFBamConfigurationFile getConfiguration();
	void setConfiguration( CFBamConfigurationFile value );

	String getJndiName();
	void setJndiName( String value );

	/**
	 *	Is the schema connected to a persistent storage server?
	 *
	 *	@return	True if the schema is connected to persistent storage,
	 *		otherwise false.
	 */
	boolean isConnected();

	/**
	 *	Connect to the persistent storage server.
	 *
	 *	@return	True if a connection was established, otherwise false.
	 */
	boolean connect();

	/**
	 *	Connect to the persistent storage server using the specified
	 *	user name and password with the server and database specified
	 *	by the configuration file.  JNDI names are ignored by this method.
	 *
	 *	@return	True if a connection was established, otherwise false.
	 */
	boolean connect( String username, String password );

	/**
	 *	Extended login format for GUI login screens
	 */
	boolean connect( String loginId, String password, String clusterName, String tenantName );

	/**
	 *	Disconnect from the persistent storage server.
	 */
	void disconnect( boolean doCommit );

	/**
	 *	Log out of the server, releasing the authorization information.
	 */
	void logout( CFBamAuthorization auth );

	/**
	 *	Import the contents of the specified file name
	 *	and file contents by applying a SAX Loader parse.
	 */
	String fileImport( CFBamAuthorization auth, String fileName, String fileContents );

	/**
	 *	Allocate a new schema instance.
	 *
	 *	@return	A new ICFBamSchema instance.
	 */
	ICFBamSchema newSchema();

	/**
	 *	Get the next ServiceTypeIdGen identifier.
	 *
	 *	@return	The next ServiceTypeIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	int nextServiceTypeIdGen();

	/**
	 *	Get the next MimeTypeIdGen identifier.
	 *
	 *	@return	The next MimeTypeIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	int nextMimeTypeIdGen();

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	long nextClusterIdGen();

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	long nextTenantIdGen();

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	UUID nextSecSessionIdGen();

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	UUID nextSecUserIdGen();

	/**
	 *	Get the AccessFrequency Table interface for the schema.
	 *
	 *	@return	The AccessFrequency Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamAccessFrequencyTable getTableAccessFrequency();

	/**
	 *	Get the AccessFrequency Factory interface for the schema.
	 *
	 *	@return	The AccessFrequency Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamAccessFrequencyFactory getFactoryAccessFrequency();

	/**
	 *	Get the AccessSecurity Table interface for the schema.
	 *
	 *	@return	The AccessSecurity Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamAccessSecurityTable getTableAccessSecurity();

	/**
	 *	Get the AccessSecurity Factory interface for the schema.
	 *
	 *	@return	The AccessSecurity Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamAccessSecurityFactory getFactoryAccessSecurity();

	/**
	 *	Get the Atom Table interface for the schema.
	 *
	 *	@return	The Atom Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamAtomTable getTableAtom();

	/**
	 *	Get the Atom Factory interface for the schema.
	 *
	 *	@return	The Atom Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamAtomFactory getFactoryAtom();

	/**
	 *	Get the AuditAction Table interface for the schema.
	 *
	 *	@return	The AuditAction Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamAuditActionTable getTableAuditAction();

	/**
	 *	Get the AuditAction Factory interface for the schema.
	 *
	 *	@return	The AuditAction Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamAuditActionFactory getFactoryAuditAction();

	/**
	 *	Get the BlobCol Table interface for the schema.
	 *
	 *	@return	The BlobCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobColTable getTableBlobCol();

	/**
	 *	Get the BlobCol Factory interface for the schema.
	 *
	 *	@return	The BlobCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobColFactory getFactoryBlobCol();

	/**
	 *	Get the BlobDef Table interface for the schema.
	 *
	 *	@return	The BlobDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobDefTable getTableBlobDef();

	/**
	 *	Get the BlobDef Factory interface for the schema.
	 *
	 *	@return	The BlobDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobDefFactory getFactoryBlobDef();

	/**
	 *	Get the BlobType Table interface for the schema.
	 *
	 *	@return	The BlobType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobTypeTable getTableBlobType();

	/**
	 *	Get the BlobType Factory interface for the schema.
	 *
	 *	@return	The BlobType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobTypeFactory getFactoryBlobType();

	/**
	 *	Get the BoolCol Table interface for the schema.
	 *
	 *	@return	The BoolCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolColTable getTableBoolCol();

	/**
	 *	Get the BoolCol Factory interface for the schema.
	 *
	 *	@return	The BoolCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolColFactory getFactoryBoolCol();

	/**
	 *	Get the BoolDef Table interface for the schema.
	 *
	 *	@return	The BoolDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolDefTable getTableBoolDef();

	/**
	 *	Get the BoolDef Factory interface for the schema.
	 *
	 *	@return	The BoolDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolDefFactory getFactoryBoolDef();

	/**
	 *	Get the BoolType Table interface for the schema.
	 *
	 *	@return	The BoolType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolTypeTable getTableBoolType();

	/**
	 *	Get the BoolType Factory interface for the schema.
	 *
	 *	@return	The BoolType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolTypeFactory getFactoryBoolType();

	/**
	 *	Get the Chain Table interface for the schema.
	 *
	 *	@return	The Chain Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamChainTable getTableChain();

	/**
	 *	Get the Chain Factory interface for the schema.
	 *
	 *	@return	The Chain Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamChainFactory getFactoryChain();

	/**
	 *	Get the ClearDep Table interface for the schema.
	 *
	 *	@return	The ClearDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearDepTable getTableClearDep();

	/**
	 *	Get the ClearDep Factory interface for the schema.
	 *
	 *	@return	The ClearDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearDepFactory getFactoryClearDep();

	/**
	 *	Get the ClearSubDep1 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep1 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep1Table getTableClearSubDep1();

	/**
	 *	Get the ClearSubDep1 Factory interface for the schema.
	 *
	 *	@return	The ClearSubDep1 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep1Factory getFactoryClearSubDep1();

	/**
	 *	Get the ClearSubDep2 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep2 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep2Table getTableClearSubDep2();

	/**
	 *	Get the ClearSubDep2 Factory interface for the schema.
	 *
	 *	@return	The ClearSubDep2 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep2Factory getFactoryClearSubDep2();

	/**
	 *	Get the ClearSubDep3 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep3 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep3Table getTableClearSubDep3();

	/**
	 *	Get the ClearSubDep3 Factory interface for the schema.
	 *
	 *	@return	The ClearSubDep3 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep3Factory getFactoryClearSubDep3();

	/**
	 *	Get the ClearTopDep Table interface for the schema.
	 *
	 *	@return	The ClearTopDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearTopDepTable getTableClearTopDep();

	/**
	 *	Get the ClearTopDep Factory interface for the schema.
	 *
	 *	@return	The ClearTopDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearTopDepFactory getFactoryClearTopDep();

	/**
	 *	Get the Cluster Table interface for the schema.
	 *
	 *	@return	The Cluster Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClusterTable getTableCluster();

	/**
	 *	Get the Cluster Factory interface for the schema.
	 *
	 *	@return	The Cluster Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClusterFactory getFactoryCluster();

	/**
	 *	Get the DataScope Table interface for the schema.
	 *
	 *	@return	The DataScope Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDataScopeTable getTableDataScope();

	/**
	 *	Get the DataScope Factory interface for the schema.
	 *
	 *	@return	The DataScope Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDataScopeFactory getFactoryDataScope();

	/**
	 *	Get the DateCol Table interface for the schema.
	 *
	 *	@return	The DateCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateColTable getTableDateCol();

	/**
	 *	Get the DateCol Factory interface for the schema.
	 *
	 *	@return	The DateCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateColFactory getFactoryDateCol();

	/**
	 *	Get the DateDef Table interface for the schema.
	 *
	 *	@return	The DateDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateDefTable getTableDateDef();

	/**
	 *	Get the DateDef Factory interface for the schema.
	 *
	 *	@return	The DateDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateDefFactory getFactoryDateDef();

	/**
	 *	Get the DateType Table interface for the schema.
	 *
	 *	@return	The DateType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateTypeTable getTableDateType();

	/**
	 *	Get the DateType Factory interface for the schema.
	 *
	 *	@return	The DateType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateTypeFactory getFactoryDateType();

	/**
	 *	Get the DelDep Table interface for the schema.
	 *
	 *	@return	The DelDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelDepTable getTableDelDep();

	/**
	 *	Get the DelDep Factory interface for the schema.
	 *
	 *	@return	The DelDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelDepFactory getFactoryDelDep();

	/**
	 *	Get the DelSubDep1 Table interface for the schema.
	 *
	 *	@return	The DelSubDep1 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep1Table getTableDelSubDep1();

	/**
	 *	Get the DelSubDep1 Factory interface for the schema.
	 *
	 *	@return	The DelSubDep1 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep1Factory getFactoryDelSubDep1();

	/**
	 *	Get the DelSubDep2 Table interface for the schema.
	 *
	 *	@return	The DelSubDep2 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep2Table getTableDelSubDep2();

	/**
	 *	Get the DelSubDep2 Factory interface for the schema.
	 *
	 *	@return	The DelSubDep2 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep2Factory getFactoryDelSubDep2();

	/**
	 *	Get the DelSubDep3 Table interface for the schema.
	 *
	 *	@return	The DelSubDep3 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep3Table getTableDelSubDep3();

	/**
	 *	Get the DelSubDep3 Factory interface for the schema.
	 *
	 *	@return	The DelSubDep3 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep3Factory getFactoryDelSubDep3();

	/**
	 *	Get the DelTopDep Table interface for the schema.
	 *
	 *	@return	The DelTopDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelTopDepTable getTableDelTopDep();

	/**
	 *	Get the DelTopDep Factory interface for the schema.
	 *
	 *	@return	The DelTopDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelTopDepFactory getFactoryDelTopDep();

	/**
	 *	Get the Domain Table interface for the schema.
	 *
	 *	@return	The Domain Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDomainTable getTableDomain();

	/**
	 *	Get the Domain Factory interface for the schema.
	 *
	 *	@return	The Domain Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDomainFactory getFactoryDomain();

	/**
	 *	Get the DomainBase Table interface for the schema.
	 *
	 *	@return	The DomainBase Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDomainBaseTable getTableDomainBase();

	/**
	 *	Get the DomainBase Factory interface for the schema.
	 *
	 *	@return	The DomainBase Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDomainBaseFactory getFactoryDomainBase();

	/**
	 *	Get the DoubleCol Table interface for the schema.
	 *
	 *	@return	The DoubleCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleColTable getTableDoubleCol();

	/**
	 *	Get the DoubleCol Factory interface for the schema.
	 *
	 *	@return	The DoubleCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleColFactory getFactoryDoubleCol();

	/**
	 *	Get the DoubleDef Table interface for the schema.
	 *
	 *	@return	The DoubleDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleDefTable getTableDoubleDef();

	/**
	 *	Get the DoubleDef Factory interface for the schema.
	 *
	 *	@return	The DoubleDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleDefFactory getFactoryDoubleDef();

	/**
	 *	Get the DoubleType Table interface for the schema.
	 *
	 *	@return	The DoubleType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleTypeTable getTableDoubleType();

	/**
	 *	Get the DoubleType Factory interface for the schema.
	 *
	 *	@return	The DoubleType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleTypeFactory getFactoryDoubleType();

	/**
	 *	Get the EnumCol Table interface for the schema.
	 *
	 *	@return	The EnumCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumColTable getTableEnumCol();

	/**
	 *	Get the EnumCol Factory interface for the schema.
	 *
	 *	@return	The EnumCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumColFactory getFactoryEnumCol();

	/**
	 *	Get the EnumDef Table interface for the schema.
	 *
	 *	@return	The EnumDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumDefTable getTableEnumDef();

	/**
	 *	Get the EnumDef Factory interface for the schema.
	 *
	 *	@return	The EnumDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumDefFactory getFactoryEnumDef();

	/**
	 *	Get the EnumTag Table interface for the schema.
	 *
	 *	@return	The EnumTag Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumTagTable getTableEnumTag();

	/**
	 *	Get the EnumTag Factory interface for the schema.
	 *
	 *	@return	The EnumTag Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumTagFactory getFactoryEnumTag();

	/**
	 *	Get the EnumType Table interface for the schema.
	 *
	 *	@return	The EnumType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumTypeTable getTableEnumType();

	/**
	 *	Get the EnumType Factory interface for the schema.
	 *
	 *	@return	The EnumType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumTypeFactory getFactoryEnumType();

	/**
	 *	Get the FloatCol Table interface for the schema.
	 *
	 *	@return	The FloatCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatColTable getTableFloatCol();

	/**
	 *	Get the FloatCol Factory interface for the schema.
	 *
	 *	@return	The FloatCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatColFactory getFactoryFloatCol();

	/**
	 *	Get the FloatDef Table interface for the schema.
	 *
	 *	@return	The FloatDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatDefTable getTableFloatDef();

	/**
	 *	Get the FloatDef Factory interface for the schema.
	 *
	 *	@return	The FloatDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatDefFactory getFactoryFloatDef();

	/**
	 *	Get the FloatType Table interface for the schema.
	 *
	 *	@return	The FloatType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatTypeTable getTableFloatType();

	/**
	 *	Get the FloatType Factory interface for the schema.
	 *
	 *	@return	The FloatType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatTypeFactory getFactoryFloatType();

	/**
	 *	Get the HostNode Table interface for the schema.
	 *
	 *	@return	The HostNode Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamHostNodeTable getTableHostNode();

	/**
	 *	Get the HostNode Factory interface for the schema.
	 *
	 *	@return	The HostNode Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamHostNodeFactory getFactoryHostNode();

	/**
	 *	Get the ISOCountry Table interface for the schema.
	 *
	 *	@return	The ISOCountry Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOCountryTable getTableISOCountry();

	/**
	 *	Get the ISOCountry Factory interface for the schema.
	 *
	 *	@return	The ISOCountry Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOCountryFactory getFactoryISOCountry();

	/**
	 *	Get the ISOCountryCurrency Table interface for the schema.
	 *
	 *	@return	The ISOCountryCurrency Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOCountryCurrencyTable getTableISOCountryCurrency();

	/**
	 *	Get the ISOCountryCurrency Factory interface for the schema.
	 *
	 *	@return	The ISOCountryCurrency Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOCountryCurrencyFactory getFactoryISOCountryCurrency();

	/**
	 *	Get the ISOCountryLanguage Table interface for the schema.
	 *
	 *	@return	The ISOCountryLanguage Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOCountryLanguageTable getTableISOCountryLanguage();

	/**
	 *	Get the ISOCountryLanguage Factory interface for the schema.
	 *
	 *	@return	The ISOCountryLanguage Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOCountryLanguageFactory getFactoryISOCountryLanguage();

	/**
	 *	Get the ISOCurrency Table interface for the schema.
	 *
	 *	@return	The ISOCurrency Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOCurrencyTable getTableISOCurrency();

	/**
	 *	Get the ISOCurrency Factory interface for the schema.
	 *
	 *	@return	The ISOCurrency Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOCurrencyFactory getFactoryISOCurrency();

	/**
	 *	Get the ISOLanguage Table interface for the schema.
	 *
	 *	@return	The ISOLanguage Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOLanguageTable getTableISOLanguage();

	/**
	 *	Get the ISOLanguage Factory interface for the schema.
	 *
	 *	@return	The ISOLanguage Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOLanguageFactory getFactoryISOLanguage();

	/**
	 *	Get the ISOTimezone Table interface for the schema.
	 *
	 *	@return	The ISOTimezone Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOTimezoneTable getTableISOTimezone();

	/**
	 *	Get the ISOTimezone Factory interface for the schema.
	 *
	 *	@return	The ISOTimezone Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamISOTimezoneFactory getFactoryISOTimezone();

	/**
	 *	Get the Id16Gen Table interface for the schema.
	 *
	 *	@return	The Id16Gen Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId16GenTable getTableId16Gen();

	/**
	 *	Get the Id16Gen Factory interface for the schema.
	 *
	 *	@return	The Id16Gen Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId16GenFactory getFactoryId16Gen();

	/**
	 *	Get the Id32Gen Table interface for the schema.
	 *
	 *	@return	The Id32Gen Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId32GenTable getTableId32Gen();

	/**
	 *	Get the Id32Gen Factory interface for the schema.
	 *
	 *	@return	The Id32Gen Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId32GenFactory getFactoryId32Gen();

	/**
	 *	Get the Id64Gen Table interface for the schema.
	 *
	 *	@return	The Id64Gen Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId64GenTable getTableId64Gen();

	/**
	 *	Get the Id64Gen Factory interface for the schema.
	 *
	 *	@return	The Id64Gen Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId64GenFactory getFactoryId64Gen();

	/**
	 *	Get the Index Table interface for the schema.
	 *
	 *	@return	The Index Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamIndexTable getTableIndex();

	/**
	 *	Get the Index Factory interface for the schema.
	 *
	 *	@return	The Index Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamIndexFactory getFactoryIndex();

	/**
	 *	Get the IndexCol Table interface for the schema.
	 *
	 *	@return	The IndexCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamIndexColTable getTableIndexCol();

	/**
	 *	Get the IndexCol Factory interface for the schema.
	 *
	 *	@return	The IndexCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamIndexColFactory getFactoryIndexCol();

	/**
	 *	Get the Int16Col Table interface for the schema.
	 *
	 *	@return	The Int16Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16ColTable getTableInt16Col();

	/**
	 *	Get the Int16Col Factory interface for the schema.
	 *
	 *	@return	The Int16Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16ColFactory getFactoryInt16Col();

	/**
	 *	Get the Int16Def Table interface for the schema.
	 *
	 *	@return	The Int16Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16DefTable getTableInt16Def();

	/**
	 *	Get the Int16Def Factory interface for the schema.
	 *
	 *	@return	The Int16Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16DefFactory getFactoryInt16Def();

	/**
	 *	Get the Int16Type Table interface for the schema.
	 *
	 *	@return	The Int16Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16TypeTable getTableInt16Type();

	/**
	 *	Get the Int16Type Factory interface for the schema.
	 *
	 *	@return	The Int16Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16TypeFactory getFactoryInt16Type();

	/**
	 *	Get the Int32Col Table interface for the schema.
	 *
	 *	@return	The Int32Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32ColTable getTableInt32Col();

	/**
	 *	Get the Int32Col Factory interface for the schema.
	 *
	 *	@return	The Int32Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32ColFactory getFactoryInt32Col();

	/**
	 *	Get the Int32Def Table interface for the schema.
	 *
	 *	@return	The Int32Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32DefTable getTableInt32Def();

	/**
	 *	Get the Int32Def Factory interface for the schema.
	 *
	 *	@return	The Int32Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32DefFactory getFactoryInt32Def();

	/**
	 *	Get the Int32Type Table interface for the schema.
	 *
	 *	@return	The Int32Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32TypeTable getTableInt32Type();

	/**
	 *	Get the Int32Type Factory interface for the schema.
	 *
	 *	@return	The Int32Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32TypeFactory getFactoryInt32Type();

	/**
	 *	Get the Int64Col Table interface for the schema.
	 *
	 *	@return	The Int64Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64ColTable getTableInt64Col();

	/**
	 *	Get the Int64Col Factory interface for the schema.
	 *
	 *	@return	The Int64Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64ColFactory getFactoryInt64Col();

	/**
	 *	Get the Int64Def Table interface for the schema.
	 *
	 *	@return	The Int64Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64DefTable getTableInt64Def();

	/**
	 *	Get the Int64Def Factory interface for the schema.
	 *
	 *	@return	The Int64Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64DefFactory getFactoryInt64Def();

	/**
	 *	Get the Int64Type Table interface for the schema.
	 *
	 *	@return	The Int64Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64TypeTable getTableInt64Type();

	/**
	 *	Get the Int64Type Factory interface for the schema.
	 *
	 *	@return	The Int64Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64TypeFactory getFactoryInt64Type();

	/**
	 *	Get the License Table interface for the schema.
	 *
	 *	@return	The License Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamLicenseTable getTableLicense();

	/**
	 *	Get the License Factory interface for the schema.
	 *
	 *	@return	The License Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamLicenseFactory getFactoryLicense();

	/**
	 *	Get the LoaderBehaviour Table interface for the schema.
	 *
	 *	@return	The LoaderBehaviour Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamLoaderBehaviourTable getTableLoaderBehaviour();

	/**
	 *	Get the LoaderBehaviour Factory interface for the schema.
	 *
	 *	@return	The LoaderBehaviour Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamLoaderBehaviourFactory getFactoryLoaderBehaviour();

	/**
	 *	Get the MajorVersion Table interface for the schema.
	 *
	 *	@return	The MajorVersion Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamMajorVersionTable getTableMajorVersion();

	/**
	 *	Get the MajorVersion Factory interface for the schema.
	 *
	 *	@return	The MajorVersion Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamMajorVersionFactory getFactoryMajorVersion();

	/**
	 *	Get the MimeType Table interface for the schema.
	 *
	 *	@return	The MimeType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamMimeTypeTable getTableMimeType();

	/**
	 *	Get the MimeType Factory interface for the schema.
	 *
	 *	@return	The MimeType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamMimeTypeFactory getFactoryMimeType();

	/**
	 *	Get the MinorVersion Table interface for the schema.
	 *
	 *	@return	The MinorVersion Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamMinorVersionTable getTableMinorVersion();

	/**
	 *	Get the MinorVersion Factory interface for the schema.
	 *
	 *	@return	The MinorVersion Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamMinorVersionFactory getFactoryMinorVersion();

	/**
	 *	Get the NmTokenCol Table interface for the schema.
	 *
	 *	@return	The NmTokenCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenColTable getTableNmTokenCol();

	/**
	 *	Get the NmTokenCol Factory interface for the schema.
	 *
	 *	@return	The NmTokenCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenColFactory getFactoryNmTokenCol();

	/**
	 *	Get the NmTokenDef Table interface for the schema.
	 *
	 *	@return	The NmTokenDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenDefTable getTableNmTokenDef();

	/**
	 *	Get the NmTokenDef Factory interface for the schema.
	 *
	 *	@return	The NmTokenDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenDefFactory getFactoryNmTokenDef();

	/**
	 *	Get the NmTokenType Table interface for the schema.
	 *
	 *	@return	The NmTokenType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenTypeTable getTableNmTokenType();

	/**
	 *	Get the NmTokenType Factory interface for the schema.
	 *
	 *	@return	The NmTokenType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenTypeFactory getFactoryNmTokenType();

	/**
	 *	Get the NmTokensCol Table interface for the schema.
	 *
	 *	@return	The NmTokensCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensColTable getTableNmTokensCol();

	/**
	 *	Get the NmTokensCol Factory interface for the schema.
	 *
	 *	@return	The NmTokensCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensColFactory getFactoryNmTokensCol();

	/**
	 *	Get the NmTokensDef Table interface for the schema.
	 *
	 *	@return	The NmTokensDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensDefTable getTableNmTokensDef();

	/**
	 *	Get the NmTokensDef Factory interface for the schema.
	 *
	 *	@return	The NmTokensDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensDefFactory getFactoryNmTokensDef();

	/**
	 *	Get the NmTokensType Table interface for the schema.
	 *
	 *	@return	The NmTokensType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensTypeTable getTableNmTokensType();

	/**
	 *	Get the NmTokensType Factory interface for the schema.
	 *
	 *	@return	The NmTokensType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensTypeFactory getFactoryNmTokensType();

	/**
	 *	Get the NumberCol Table interface for the schema.
	 *
	 *	@return	The NumberCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberColTable getTableNumberCol();

	/**
	 *	Get the NumberCol Factory interface for the schema.
	 *
	 *	@return	The NumberCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberColFactory getFactoryNumberCol();

	/**
	 *	Get the NumberDef Table interface for the schema.
	 *
	 *	@return	The NumberDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberDefTable getTableNumberDef();

	/**
	 *	Get the NumberDef Factory interface for the schema.
	 *
	 *	@return	The NumberDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberDefFactory getFactoryNumberDef();

	/**
	 *	Get the NumberType Table interface for the schema.
	 *
	 *	@return	The NumberType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberTypeTable getTableNumberType();

	/**
	 *	Get the NumberType Factory interface for the schema.
	 *
	 *	@return	The NumberType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberTypeFactory getFactoryNumberType();

	/**
	 *	Get the Param Table interface for the schema.
	 *
	 *	@return	The Param Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamParamTable getTableParam();

	/**
	 *	Get the Param Factory interface for the schema.
	 *
	 *	@return	The Param Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamParamFactory getFactoryParam();

	/**
	 *	Get the PopDep Table interface for the schema.
	 *
	 *	@return	The PopDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopDepTable getTablePopDep();

	/**
	 *	Get the PopDep Factory interface for the schema.
	 *
	 *	@return	The PopDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopDepFactory getFactoryPopDep();

	/**
	 *	Get the PopSubDep1 Table interface for the schema.
	 *
	 *	@return	The PopSubDep1 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep1Table getTablePopSubDep1();

	/**
	 *	Get the PopSubDep1 Factory interface for the schema.
	 *
	 *	@return	The PopSubDep1 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep1Factory getFactoryPopSubDep1();

	/**
	 *	Get the PopSubDep2 Table interface for the schema.
	 *
	 *	@return	The PopSubDep2 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep2Table getTablePopSubDep2();

	/**
	 *	Get the PopSubDep2 Factory interface for the schema.
	 *
	 *	@return	The PopSubDep2 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep2Factory getFactoryPopSubDep2();

	/**
	 *	Get the PopSubDep3 Table interface for the schema.
	 *
	 *	@return	The PopSubDep3 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep3Table getTablePopSubDep3();

	/**
	 *	Get the PopSubDep3 Factory interface for the schema.
	 *
	 *	@return	The PopSubDep3 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep3Factory getFactoryPopSubDep3();

	/**
	 *	Get the PopTopDep Table interface for the schema.
	 *
	 *	@return	The PopTopDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopTopDepTable getTablePopTopDep();

	/**
	 *	Get the PopTopDep Factory interface for the schema.
	 *
	 *	@return	The PopTopDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopTopDepFactory getFactoryPopTopDep();

	/**
	 *	Get the ProjectBase Table interface for the schema.
	 *
	 *	@return	The ProjectBase Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamProjectBaseTable getTableProjectBase();

	/**
	 *	Get the ProjectBase Factory interface for the schema.
	 *
	 *	@return	The ProjectBase Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamProjectBaseFactory getFactoryProjectBase();

	/**
	 *	Get the RealProject Table interface for the schema.
	 *
	 *	@return	The RealProject Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRealProjectTable getTableRealProject();

	/**
	 *	Get the RealProject Factory interface for the schema.
	 *
	 *	@return	The RealProject Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRealProjectFactory getFactoryRealProject();

	/**
	 *	Get the Relation Table interface for the schema.
	 *
	 *	@return	The Relation Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRelationTable getTableRelation();

	/**
	 *	Get the Relation Factory interface for the schema.
	 *
	 *	@return	The Relation Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRelationFactory getFactoryRelation();

	/**
	 *	Get the RelationCol Table interface for the schema.
	 *
	 *	@return	The RelationCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRelationColTable getTableRelationCol();

	/**
	 *	Get the RelationCol Factory interface for the schema.
	 *
	 *	@return	The RelationCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRelationColFactory getFactoryRelationCol();

	/**
	 *	Get the RelationType Table interface for the schema.
	 *
	 *	@return	The RelationType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRelationTypeTable getTableRelationType();

	/**
	 *	Get the RelationType Factory interface for the schema.
	 *
	 *	@return	The RelationType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRelationTypeFactory getFactoryRelationType();

	/**
	 *	Get the SchemaDef Table interface for the schema.
	 *
	 *	@return	The SchemaDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSchemaDefTable getTableSchemaDef();

	/**
	 *	Get the SchemaDef Factory interface for the schema.
	 *
	 *	@return	The SchemaDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSchemaDefFactory getFactorySchemaDef();

	/**
	 *	Get the SchemaRef Table interface for the schema.
	 *
	 *	@return	The SchemaRef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSchemaRefTable getTableSchemaRef();

	/**
	 *	Get the SchemaRef Factory interface for the schema.
	 *
	 *	@return	The SchemaRef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSchemaRefFactory getFactorySchemaRef();

	/**
	 *	Get the Scope Table interface for the schema.
	 *
	 *	@return	The Scope Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamScopeTable getTableScope();

	/**
	 *	Get the Scope Factory interface for the schema.
	 *
	 *	@return	The Scope Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamScopeFactory getFactoryScope();

	/**
	 *	Get the SecApp Table interface for the schema.
	 *
	 *	@return	The SecApp Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecAppTable getTableSecApp();

	/**
	 *	Get the SecApp Factory interface for the schema.
	 *
	 *	@return	The SecApp Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecAppFactory getFactorySecApp();

	/**
	 *	Get the SecDevice Table interface for the schema.
	 *
	 *	@return	The SecDevice Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecDeviceTable getTableSecDevice();

	/**
	 *	Get the SecDevice Factory interface for the schema.
	 *
	 *	@return	The SecDevice Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecDeviceFactory getFactorySecDevice();

	/**
	 *	Get the SecForm Table interface for the schema.
	 *
	 *	@return	The SecForm Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecFormTable getTableSecForm();

	/**
	 *	Get the SecForm Factory interface for the schema.
	 *
	 *	@return	The SecForm Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecFormFactory getFactorySecForm();

	/**
	 *	Get the SecGroup Table interface for the schema.
	 *
	 *	@return	The SecGroup Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecGroupTable getTableSecGroup();

	/**
	 *	Get the SecGroup Factory interface for the schema.
	 *
	 *	@return	The SecGroup Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecGroupFactory getFactorySecGroup();

	/**
	 *	Get the SecGroupForm Table interface for the schema.
	 *
	 *	@return	The SecGroupForm Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecGroupFormTable getTableSecGroupForm();

	/**
	 *	Get the SecGroupForm Factory interface for the schema.
	 *
	 *	@return	The SecGroupForm Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecGroupFormFactory getFactorySecGroupForm();

	/**
	 *	Get the SecGroupInclude Table interface for the schema.
	 *
	 *	@return	The SecGroupInclude Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecGroupIncludeTable getTableSecGroupInclude();

	/**
	 *	Get the SecGroupInclude Factory interface for the schema.
	 *
	 *	@return	The SecGroupInclude Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecGroupIncludeFactory getFactorySecGroupInclude();

	/**
	 *	Get the SecGroupMember Table interface for the schema.
	 *
	 *	@return	The SecGroupMember Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecGroupMemberTable getTableSecGroupMember();

	/**
	 *	Get the SecGroupMember Factory interface for the schema.
	 *
	 *	@return	The SecGroupMember Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecGroupMemberFactory getFactorySecGroupMember();

	/**
	 *	Get the SecSession Table interface for the schema.
	 *
	 *	@return	The SecSession Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecSessionTable getTableSecSession();

	/**
	 *	Get the SecSession Factory interface for the schema.
	 *
	 *	@return	The SecSession Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecSessionFactory getFactorySecSession();

	/**
	 *	Get the SecUser Table interface for the schema.
	 *
	 *	@return	The SecUser Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecUserTable getTableSecUser();

	/**
	 *	Get the SecUser Factory interface for the schema.
	 *
	 *	@return	The SecUser Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecUserFactory getFactorySecUser();

	/**
	 *	Get the SecurityScope Table interface for the schema.
	 *
	 *	@return	The SecurityScope Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecurityScopeTable getTableSecurityScope();

	/**
	 *	Get the SecurityScope Factory interface for the schema.
	 *
	 *	@return	The SecurityScope Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSecurityScopeFactory getFactorySecurityScope();

	/**
	 *	Get the ServerListFunc Table interface for the schema.
	 *
	 *	@return	The ServerListFunc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerListFuncTable getTableServerListFunc();

	/**
	 *	Get the ServerListFunc Factory interface for the schema.
	 *
	 *	@return	The ServerListFunc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerListFuncFactory getFactoryServerListFunc();

	/**
	 *	Get the ServerMethod Table interface for the schema.
	 *
	 *	@return	The ServerMethod Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerMethodTable getTableServerMethod();

	/**
	 *	Get the ServerMethod Factory interface for the schema.
	 *
	 *	@return	The ServerMethod Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerMethodFactory getFactoryServerMethod();

	/**
	 *	Get the ServerObjFunc Table interface for the schema.
	 *
	 *	@return	The ServerObjFunc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerObjFuncTable getTableServerObjFunc();

	/**
	 *	Get the ServerObjFunc Factory interface for the schema.
	 *
	 *	@return	The ServerObjFunc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerObjFuncFactory getFactoryServerObjFunc();

	/**
	 *	Get the ServerProc Table interface for the schema.
	 *
	 *	@return	The ServerProc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerProcTable getTableServerProc();

	/**
	 *	Get the ServerProc Factory interface for the schema.
	 *
	 *	@return	The ServerProc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerProcFactory getFactoryServerProc();

	/**
	 *	Get the Service Table interface for the schema.
	 *
	 *	@return	The Service Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServiceTable getTableService();

	/**
	 *	Get the Service Factory interface for the schema.
	 *
	 *	@return	The Service Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServiceFactory getFactoryService();

	/**
	 *	Get the ServiceType Table interface for the schema.
	 *
	 *	@return	The ServiceType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServiceTypeTable getTableServiceType();

	/**
	 *	Get the ServiceType Factory interface for the schema.
	 *
	 *	@return	The ServiceType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServiceTypeFactory getFactoryServiceType();

	/**
	 *	Get the StringCol Table interface for the schema.
	 *
	 *	@return	The StringCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringColTable getTableStringCol();

	/**
	 *	Get the StringCol Factory interface for the schema.
	 *
	 *	@return	The StringCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringColFactory getFactoryStringCol();

	/**
	 *	Get the StringDef Table interface for the schema.
	 *
	 *	@return	The StringDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringDefTable getTableStringDef();

	/**
	 *	Get the StringDef Factory interface for the schema.
	 *
	 *	@return	The StringDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringDefFactory getFactoryStringDef();

	/**
	 *	Get the StringType Table interface for the schema.
	 *
	 *	@return	The StringType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringTypeTable getTableStringType();

	/**
	 *	Get the StringType Factory interface for the schema.
	 *
	 *	@return	The StringType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringTypeFactory getFactoryStringType();

	/**
	 *	Get the SubProject Table interface for the schema.
	 *
	 *	@return	The SubProject Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSubProjectTable getTableSubProject();

	/**
	 *	Get the SubProject Factory interface for the schema.
	 *
	 *	@return	The SubProject Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSubProjectFactory getFactorySubProject();

	/**
	 *	Get the SysCluster Table interface for the schema.
	 *
	 *	@return	The SysCluster Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSysClusterTable getTableSysCluster();

	/**
	 *	Get the SysCluster Factory interface for the schema.
	 *
	 *	@return	The SysCluster Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSysClusterFactory getFactorySysCluster();

	/**
	 *	Get the TSecGroup Table interface for the schema.
	 *
	 *	@return	The TSecGroup Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTSecGroupTable getTableTSecGroup();

	/**
	 *	Get the TSecGroup Factory interface for the schema.
	 *
	 *	@return	The TSecGroup Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTSecGroupFactory getFactoryTSecGroup();

	/**
	 *	Get the TSecGroupInclude Table interface for the schema.
	 *
	 *	@return	The TSecGroupInclude Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTSecGroupIncludeTable getTableTSecGroupInclude();

	/**
	 *	Get the TSecGroupInclude Factory interface for the schema.
	 *
	 *	@return	The TSecGroupInclude Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTSecGroupIncludeFactory getFactoryTSecGroupInclude();

	/**
	 *	Get the TSecGroupMember Table interface for the schema.
	 *
	 *	@return	The TSecGroupMember Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTSecGroupMemberTable getTableTSecGroupMember();

	/**
	 *	Get the TSecGroupMember Factory interface for the schema.
	 *
	 *	@return	The TSecGroupMember Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTSecGroupMemberFactory getFactoryTSecGroupMember();

	/**
	 *	Get the TZDateCol Table interface for the schema.
	 *
	 *	@return	The TZDateCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateColTable getTableTZDateCol();

	/**
	 *	Get the TZDateCol Factory interface for the schema.
	 *
	 *	@return	The TZDateCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateColFactory getFactoryTZDateCol();

	/**
	 *	Get the TZDateDef Table interface for the schema.
	 *
	 *	@return	The TZDateDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateDefTable getTableTZDateDef();

	/**
	 *	Get the TZDateDef Factory interface for the schema.
	 *
	 *	@return	The TZDateDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateDefFactory getFactoryTZDateDef();

	/**
	 *	Get the TZDateType Table interface for the schema.
	 *
	 *	@return	The TZDateType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateTypeTable getTableTZDateType();

	/**
	 *	Get the TZDateType Factory interface for the schema.
	 *
	 *	@return	The TZDateType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateTypeFactory getFactoryTZDateType();

	/**
	 *	Get the TZTimeCol Table interface for the schema.
	 *
	 *	@return	The TZTimeCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeColTable getTableTZTimeCol();

	/**
	 *	Get the TZTimeCol Factory interface for the schema.
	 *
	 *	@return	The TZTimeCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeColFactory getFactoryTZTimeCol();

	/**
	 *	Get the TZTimeDef Table interface for the schema.
	 *
	 *	@return	The TZTimeDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeDefTable getTableTZTimeDef();

	/**
	 *	Get the TZTimeDef Factory interface for the schema.
	 *
	 *	@return	The TZTimeDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeDefFactory getFactoryTZTimeDef();

	/**
	 *	Get the TZTimeType Table interface for the schema.
	 *
	 *	@return	The TZTimeType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeTypeTable getTableTZTimeType();

	/**
	 *	Get the TZTimeType Factory interface for the schema.
	 *
	 *	@return	The TZTimeType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeTypeFactory getFactoryTZTimeType();

	/**
	 *	Get the TZTimestampCol Table interface for the schema.
	 *
	 *	@return	The TZTimestampCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampColTable getTableTZTimestampCol();

	/**
	 *	Get the TZTimestampCol Factory interface for the schema.
	 *
	 *	@return	The TZTimestampCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampColFactory getFactoryTZTimestampCol();

	/**
	 *	Get the TZTimestampDef Table interface for the schema.
	 *
	 *	@return	The TZTimestampDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampDefTable getTableTZTimestampDef();

	/**
	 *	Get the TZTimestampDef Factory interface for the schema.
	 *
	 *	@return	The TZTimestampDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampDefFactory getFactoryTZTimestampDef();

	/**
	 *	Get the TZTimestampType Table interface for the schema.
	 *
	 *	@return	The TZTimestampType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampTypeTable getTableTZTimestampType();

	/**
	 *	Get the TZTimestampType Factory interface for the schema.
	 *
	 *	@return	The TZTimestampType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampTypeFactory getFactoryTZTimestampType();

	/**
	 *	Get the Table Table interface for the schema.
	 *
	 *	@return	The Table Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTableTable getTableTable();

	/**
	 *	Get the Table Factory interface for the schema.
	 *
	 *	@return	The Table Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTableFactory getFactoryTable();

	/**
	 *	Get the TableCol Table interface for the schema.
	 *
	 *	@return	The TableCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTableColTable getTableTableCol();

	/**
	 *	Get the TableCol Factory interface for the schema.
	 *
	 *	@return	The TableCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTableColFactory getFactoryTableCol();

	/**
	 *	Get the Tenant Table interface for the schema.
	 *
	 *	@return	The Tenant Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTenantTable getTableTenant();

	/**
	 *	Get the Tenant Factory interface for the schema.
	 *
	 *	@return	The Tenant Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTenantFactory getFactoryTenant();

	/**
	 *	Get the TextCol Table interface for the schema.
	 *
	 *	@return	The TextCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextColTable getTableTextCol();

	/**
	 *	Get the TextCol Factory interface for the schema.
	 *
	 *	@return	The TextCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextColFactory getFactoryTextCol();

	/**
	 *	Get the TextDef Table interface for the schema.
	 *
	 *	@return	The TextDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextDefTable getTableTextDef();

	/**
	 *	Get the TextDef Factory interface for the schema.
	 *
	 *	@return	The TextDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextDefFactory getFactoryTextDef();

	/**
	 *	Get the TextType Table interface for the schema.
	 *
	 *	@return	The TextType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextTypeTable getTableTextType();

	/**
	 *	Get the TextType Factory interface for the schema.
	 *
	 *	@return	The TextType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextTypeFactory getFactoryTextType();

	/**
	 *	Get the TimeCol Table interface for the schema.
	 *
	 *	@return	The TimeCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeColTable getTableTimeCol();

	/**
	 *	Get the TimeCol Factory interface for the schema.
	 *
	 *	@return	The TimeCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeColFactory getFactoryTimeCol();

	/**
	 *	Get the TimeDef Table interface for the schema.
	 *
	 *	@return	The TimeDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeDefTable getTableTimeDef();

	/**
	 *	Get the TimeDef Factory interface for the schema.
	 *
	 *	@return	The TimeDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeDefFactory getFactoryTimeDef();

	/**
	 *	Get the TimeType Table interface for the schema.
	 *
	 *	@return	The TimeType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeTypeTable getTableTimeType();

	/**
	 *	Get the TimeType Factory interface for the schema.
	 *
	 *	@return	The TimeType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeTypeFactory getFactoryTimeType();

	/**
	 *	Get the TimestampCol Table interface for the schema.
	 *
	 *	@return	The TimestampCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampColTable getTableTimestampCol();

	/**
	 *	Get the TimestampCol Factory interface for the schema.
	 *
	 *	@return	The TimestampCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampColFactory getFactoryTimestampCol();

	/**
	 *	Get the TimestampDef Table interface for the schema.
	 *
	 *	@return	The TimestampDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampDefTable getTableTimestampDef();

	/**
	 *	Get the TimestampDef Factory interface for the schema.
	 *
	 *	@return	The TimestampDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampDefFactory getFactoryTimestampDef();

	/**
	 *	Get the TimestampType Table interface for the schema.
	 *
	 *	@return	The TimestampType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampTypeTable getTableTimestampType();

	/**
	 *	Get the TimestampType Factory interface for the schema.
	 *
	 *	@return	The TimestampType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampTypeFactory getFactoryTimestampType();

	/**
	 *	Get the Tld Table interface for the schema.
	 *
	 *	@return	The Tld Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTldTable getTableTld();

	/**
	 *	Get the Tld Factory interface for the schema.
	 *
	 *	@return	The Tld Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTldFactory getFactoryTld();

	/**
	 *	Get the TokenCol Table interface for the schema.
	 *
	 *	@return	The TokenCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenColTable getTableTokenCol();

	/**
	 *	Get the TokenCol Factory interface for the schema.
	 *
	 *	@return	The TokenCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenColFactory getFactoryTokenCol();

	/**
	 *	Get the TokenDef Table interface for the schema.
	 *
	 *	@return	The TokenDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenDefTable getTableTokenDef();

	/**
	 *	Get the TokenDef Factory interface for the schema.
	 *
	 *	@return	The TokenDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenDefFactory getFactoryTokenDef();

	/**
	 *	Get the TokenType Table interface for the schema.
	 *
	 *	@return	The TokenType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenTypeTable getTableTokenType();

	/**
	 *	Get the TokenType Factory interface for the schema.
	 *
	 *	@return	The TokenType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenTypeFactory getFactoryTokenType();

	/**
	 *	Get the TopDomain Table interface for the schema.
	 *
	 *	@return	The TopDomain Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTopDomainTable getTableTopDomain();

	/**
	 *	Get the TopDomain Factory interface for the schema.
	 *
	 *	@return	The TopDomain Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTopDomainFactory getFactoryTopDomain();

	/**
	 *	Get the TopProject Table interface for the schema.
	 *
	 *	@return	The TopProject Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTopProjectTable getTableTopProject();

	/**
	 *	Get the TopProject Factory interface for the schema.
	 *
	 *	@return	The TopProject Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTopProjectFactory getFactoryTopProject();

	/**
	 *	Get the UInt16Col Table interface for the schema.
	 *
	 *	@return	The UInt16Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16ColTable getTableUInt16Col();

	/**
	 *	Get the UInt16Col Factory interface for the schema.
	 *
	 *	@return	The UInt16Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16ColFactory getFactoryUInt16Col();

	/**
	 *	Get the UInt16Def Table interface for the schema.
	 *
	 *	@return	The UInt16Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16DefTable getTableUInt16Def();

	/**
	 *	Get the UInt16Def Factory interface for the schema.
	 *
	 *	@return	The UInt16Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16DefFactory getFactoryUInt16Def();

	/**
	 *	Get the UInt16Type Table interface for the schema.
	 *
	 *	@return	The UInt16Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16TypeTable getTableUInt16Type();

	/**
	 *	Get the UInt16Type Factory interface for the schema.
	 *
	 *	@return	The UInt16Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16TypeFactory getFactoryUInt16Type();

	/**
	 *	Get the UInt32Col Table interface for the schema.
	 *
	 *	@return	The UInt32Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32ColTable getTableUInt32Col();

	/**
	 *	Get the UInt32Col Factory interface for the schema.
	 *
	 *	@return	The UInt32Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32ColFactory getFactoryUInt32Col();

	/**
	 *	Get the UInt32Def Table interface for the schema.
	 *
	 *	@return	The UInt32Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32DefTable getTableUInt32Def();

	/**
	 *	Get the UInt32Def Factory interface for the schema.
	 *
	 *	@return	The UInt32Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32DefFactory getFactoryUInt32Def();

	/**
	 *	Get the UInt32Type Table interface for the schema.
	 *
	 *	@return	The UInt32Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32TypeTable getTableUInt32Type();

	/**
	 *	Get the UInt32Type Factory interface for the schema.
	 *
	 *	@return	The UInt32Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32TypeFactory getFactoryUInt32Type();

	/**
	 *	Get the UInt64Col Table interface for the schema.
	 *
	 *	@return	The UInt64Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64ColTable getTableUInt64Col();

	/**
	 *	Get the UInt64Col Factory interface for the schema.
	 *
	 *	@return	The UInt64Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64ColFactory getFactoryUInt64Col();

	/**
	 *	Get the UInt64Def Table interface for the schema.
	 *
	 *	@return	The UInt64Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64DefTable getTableUInt64Def();

	/**
	 *	Get the UInt64Def Factory interface for the schema.
	 *
	 *	@return	The UInt64Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64DefFactory getFactoryUInt64Def();

	/**
	 *	Get the UInt64Type Table interface for the schema.
	 *
	 *	@return	The UInt64Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64TypeTable getTableUInt64Type();

	/**
	 *	Get the UInt64Type Factory interface for the schema.
	 *
	 *	@return	The UInt64Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64TypeFactory getFactoryUInt64Type();

	/**
	 *	Get the URLProtocol Table interface for the schema.
	 *
	 *	@return	The URLProtocol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamURLProtocolTable getTableURLProtocol();

	/**
	 *	Get the URLProtocol Factory interface for the schema.
	 *
	 *	@return	The URLProtocol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamURLProtocolFactory getFactoryURLProtocol();

	/**
	 *	Get the UuidCol Table interface for the schema.
	 *
	 *	@return	The UuidCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidColTable getTableUuidCol();

	/**
	 *	Get the UuidCol Factory interface for the schema.
	 *
	 *	@return	The UuidCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidColFactory getFactoryUuidCol();

	/**
	 *	Get the UuidDef Table interface for the schema.
	 *
	 *	@return	The UuidDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidDefTable getTableUuidDef();

	/**
	 *	Get the UuidDef Factory interface for the schema.
	 *
	 *	@return	The UuidDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidDefFactory getFactoryUuidDef();

	/**
	 *	Get the UuidGen Table interface for the schema.
	 *
	 *	@return	The UuidGen Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidGenTable getTableUuidGen();

	/**
	 *	Get the UuidGen Factory interface for the schema.
	 *
	 *	@return	The UuidGen Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidGenFactory getFactoryUuidGen();

	/**
	 *	Get the UuidType Table interface for the schema.
	 *
	 *	@return	The UuidType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidTypeTable getTableUuidType();

	/**
	 *	Get the UuidType Factory interface for the schema.
	 *
	 *	@return	The UuidType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidTypeFactory getFactoryUuidType();

	/**
	 *	Get the Value Table interface for the schema.
	 *
	 *	@return	The Value Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamValueTable getTableValue();

	/**
	 *	Get the Value Factory interface for the schema.
	 *
	 *	@return	The Value Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamValueFactory getFactoryValue();

	/**
	 *	Get the Version Table interface for the schema.
	 *
	 *	@return	The Version Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamVersionTable getTableVersion();

	/**
	 *	Get the Version Factory interface for the schema.
	 *
	 *	@return	The Version Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamVersionFactory getFactoryVersion();

	/**
	 *	If a transaction is already opened for the schema connection,
	 *	return false.  If a new transaction is successfully opened,
	 *	return true.  Otherwise throw a RuntimeException detailing
	 *	why a transaction could not be initiated.
	 *	<p>
	 *	This permits the database persistence implementations to
	 *	switch between participating in an existing transaction
	 *	or implementing an implicit atomic transaction that is
	 *	committed or rolled back before the method returns:
	 *	<p>
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
	 *	<p>
	 *	As the current web-form focused implementation will be managing
	 *	the transactions in the Servlet page response, I don't need to
	 *	implement the atomic transaction wrappers yet.
	 */

	/**
	 *	The client-side implementations always return true for this method.
	 *
	 *	@return	True if there is currently a transaction open, otherwise false.
	 *		Client-side implementations always return true.
	 */
	boolean isTransactionOpen();

	/**
	 *	Begin a transaction.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	boolean beginTransaction();

	/**
	 *	Commit the current open transaction.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void commit();

	/**
	 *	Roll back the current open transaction.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void rollback();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTablePerms getTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void setTablePerms( ICFBamTablePerms value );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@Exception CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();

	/**
	 *	When you first connect to a database, you can opt to specify a database
	 *	schema name to be used by the session.  The implementation code must always
	 *	be dynamically based on the invocation of <tt>String getDbSchemaName()</tt>
	 *	at runtime.
	 *	<p>
	 *	The initial value is defined by the implementing schema model which has inherited
	 *	the expression of the current schema model being expanded.  That is, it is specified
	 *	in the DbSchemaName attribute of a SchemaDef instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	String getDbSchemaName();
	String getLowerDbSchemaName();

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
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void setDbSchemaName( String argDbSchemaName );
}
