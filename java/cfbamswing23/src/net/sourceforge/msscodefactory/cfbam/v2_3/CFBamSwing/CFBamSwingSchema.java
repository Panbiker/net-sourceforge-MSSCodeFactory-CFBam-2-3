// Description: Java 7 Swing Schema for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSwing;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.security.KeyStore;
import javax.swing.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSaxLoader.CFBamSaxLoader;

/**
 *	The CFBamSwingSchema acts as the factory for the various manufactured
 *	table JPanels used to construct the overall GUI interface, and serves as a
 *	focal point for shared methods and data accessible throughout the GUI hierarchy.
 */
public class CFBamSwingSchema
implements ICFBamSwingSchema
{
	protected CFBamClientConfigurationFile clientConfigurationFile = null;
	protected KeyStore keyStore = null;
	protected ICFBamSchemaObj schema = null;
	protected String clusterName = "system";
	protected ICFBamClusterObj clusterObj = null;
	protected String tenantName = "system";
	protected ICFBamTenantObj tenantObj = null;
	protected String secUserName = "system";
	protected ICFBamSecUserObj secUserObj = null;
	protected ICFBamSecSessionObj secSessionObj = null;
	protected ICFBamSwingAccessFrequencyFactory factoryAccessFrequency = null;
	protected ICFBamSwingAccessSecurityFactory factoryAccessSecurity = null;
	protected ICFBamSwingAtomFactory factoryAtom = null;
	protected ICFBamSwingAuditActionFactory factoryAuditAction = null;
	protected ICFBamSwingBlobColFactory factoryBlobCol = null;
	protected ICFBamSwingBlobDefFactory factoryBlobDef = null;
	protected ICFBamSwingBlobTypeFactory factoryBlobType = null;
	protected ICFBamSwingBoolColFactory factoryBoolCol = null;
	protected ICFBamSwingBoolDefFactory factoryBoolDef = null;
	protected ICFBamSwingBoolTypeFactory factoryBoolType = null;
	protected ICFBamSwingChainFactory factoryChain = null;
	protected ICFBamSwingClearDepFactory factoryClearDep = null;
	protected ICFBamSwingClearSubDep1Factory factoryClearSubDep1 = null;
	protected ICFBamSwingClearSubDep2Factory factoryClearSubDep2 = null;
	protected ICFBamSwingClearSubDep3Factory factoryClearSubDep3 = null;
	protected ICFBamSwingClearTopDepFactory factoryClearTopDep = null;
	protected ICFBamSwingClusterFactory factoryCluster = null;
	protected ICFBamSwingDataScopeFactory factoryDataScope = null;
	protected ICFBamSwingDateColFactory factoryDateCol = null;
	protected ICFBamSwingDateDefFactory factoryDateDef = null;
	protected ICFBamSwingDateTypeFactory factoryDateType = null;
	protected ICFBamSwingDelDepFactory factoryDelDep = null;
	protected ICFBamSwingDelSubDep1Factory factoryDelSubDep1 = null;
	protected ICFBamSwingDelSubDep2Factory factoryDelSubDep2 = null;
	protected ICFBamSwingDelSubDep3Factory factoryDelSubDep3 = null;
	protected ICFBamSwingDelTopDepFactory factoryDelTopDep = null;
	protected ICFBamSwingDomainFactory factoryDomain = null;
	protected ICFBamSwingDomainBaseFactory factoryDomainBase = null;
	protected ICFBamSwingDoubleColFactory factoryDoubleCol = null;
	protected ICFBamSwingDoubleDefFactory factoryDoubleDef = null;
	protected ICFBamSwingDoubleTypeFactory factoryDoubleType = null;
	protected ICFBamSwingEnumColFactory factoryEnumCol = null;
	protected ICFBamSwingEnumDefFactory factoryEnumDef = null;
	protected ICFBamSwingEnumTagFactory factoryEnumTag = null;
	protected ICFBamSwingEnumTypeFactory factoryEnumType = null;
	protected ICFBamSwingFloatColFactory factoryFloatCol = null;
	protected ICFBamSwingFloatDefFactory factoryFloatDef = null;
	protected ICFBamSwingFloatTypeFactory factoryFloatType = null;
	protected ICFBamSwingHostNodeFactory factoryHostNode = null;
	protected ICFBamSwingISOCountryFactory factoryISOCountry = null;
	protected ICFBamSwingISOCountryCurrencyFactory factoryISOCountryCurrency = null;
	protected ICFBamSwingISOCountryLanguageFactory factoryISOCountryLanguage = null;
	protected ICFBamSwingISOCurrencyFactory factoryISOCurrency = null;
	protected ICFBamSwingISOLanguageFactory factoryISOLanguage = null;
	protected ICFBamSwingISOTimezoneFactory factoryISOTimezone = null;
	protected ICFBamSwingId16GenFactory factoryId16Gen = null;
	protected ICFBamSwingId32GenFactory factoryId32Gen = null;
	protected ICFBamSwingId64GenFactory factoryId64Gen = null;
	protected ICFBamSwingIndexFactory factoryIndex = null;
	protected ICFBamSwingIndexColFactory factoryIndexCol = null;
	protected ICFBamSwingInt16ColFactory factoryInt16Col = null;
	protected ICFBamSwingInt16DefFactory factoryInt16Def = null;
	protected ICFBamSwingInt16TypeFactory factoryInt16Type = null;
	protected ICFBamSwingInt32ColFactory factoryInt32Col = null;
	protected ICFBamSwingInt32DefFactory factoryInt32Def = null;
	protected ICFBamSwingInt32TypeFactory factoryInt32Type = null;
	protected ICFBamSwingInt64ColFactory factoryInt64Col = null;
	protected ICFBamSwingInt64DefFactory factoryInt64Def = null;
	protected ICFBamSwingInt64TypeFactory factoryInt64Type = null;
	protected ICFBamSwingLicenseFactory factoryLicense = null;
	protected ICFBamSwingLoaderBehaviourFactory factoryLoaderBehaviour = null;
	protected ICFBamSwingMajorVersionFactory factoryMajorVersion = null;
	protected ICFBamSwingMimeTypeFactory factoryMimeType = null;
	protected ICFBamSwingMinorVersionFactory factoryMinorVersion = null;
	protected ICFBamSwingNmTokenColFactory factoryNmTokenCol = null;
	protected ICFBamSwingNmTokenDefFactory factoryNmTokenDef = null;
	protected ICFBamSwingNmTokenTypeFactory factoryNmTokenType = null;
	protected ICFBamSwingNmTokensColFactory factoryNmTokensCol = null;
	protected ICFBamSwingNmTokensDefFactory factoryNmTokensDef = null;
	protected ICFBamSwingNmTokensTypeFactory factoryNmTokensType = null;
	protected ICFBamSwingNumberColFactory factoryNumberCol = null;
	protected ICFBamSwingNumberDefFactory factoryNumberDef = null;
	protected ICFBamSwingNumberTypeFactory factoryNumberType = null;
	protected ICFBamSwingParamFactory factoryParam = null;
	protected ICFBamSwingPopDepFactory factoryPopDep = null;
	protected ICFBamSwingPopSubDep1Factory factoryPopSubDep1 = null;
	protected ICFBamSwingPopSubDep2Factory factoryPopSubDep2 = null;
	protected ICFBamSwingPopSubDep3Factory factoryPopSubDep3 = null;
	protected ICFBamSwingPopTopDepFactory factoryPopTopDep = null;
	protected ICFBamSwingProjectBaseFactory factoryProjectBase = null;
	protected ICFBamSwingRealProjectFactory factoryRealProject = null;
	protected ICFBamSwingRelationFactory factoryRelation = null;
	protected ICFBamSwingRelationColFactory factoryRelationCol = null;
	protected ICFBamSwingRelationTypeFactory factoryRelationType = null;
	protected ICFBamSwingSchemaDefFactory factorySchemaDef = null;
	protected ICFBamSwingSchemaRefFactory factorySchemaRef = null;
	protected ICFBamSwingScopeFactory factoryScope = null;
	protected ICFBamSwingSecAppFactory factorySecApp = null;
	protected ICFBamSwingSecDeviceFactory factorySecDevice = null;
	protected ICFBamSwingSecFormFactory factorySecForm = null;
	protected ICFBamSwingSecGroupFactory factorySecGroup = null;
	protected ICFBamSwingSecGroupFormFactory factorySecGroupForm = null;
	protected ICFBamSwingSecGroupIncludeFactory factorySecGroupInclude = null;
	protected ICFBamSwingSecGroupMemberFactory factorySecGroupMember = null;
	protected ICFBamSwingSecSessionFactory factorySecSession = null;
	protected ICFBamSwingSecUserFactory factorySecUser = null;
	protected ICFBamSwingSecurityScopeFactory factorySecurityScope = null;
	protected ICFBamSwingServerListFuncFactory factoryServerListFunc = null;
	protected ICFBamSwingServerMethodFactory factoryServerMethod = null;
	protected ICFBamSwingServerObjFuncFactory factoryServerObjFunc = null;
	protected ICFBamSwingServerProcFactory factoryServerProc = null;
	protected ICFBamSwingServiceFactory factoryService = null;
	protected ICFBamSwingServiceTypeFactory factoryServiceType = null;
	protected ICFBamSwingStringColFactory factoryStringCol = null;
	protected ICFBamSwingStringDefFactory factoryStringDef = null;
	protected ICFBamSwingStringTypeFactory factoryStringType = null;
	protected ICFBamSwingSubProjectFactory factorySubProject = null;
	protected ICFBamSwingSysClusterFactory factorySysCluster = null;
	protected ICFBamSwingTSecGroupFactory factoryTSecGroup = null;
	protected ICFBamSwingTSecGroupIncludeFactory factoryTSecGroupInclude = null;
	protected ICFBamSwingTSecGroupMemberFactory factoryTSecGroupMember = null;
	protected ICFBamSwingTZDateColFactory factoryTZDateCol = null;
	protected ICFBamSwingTZDateDefFactory factoryTZDateDef = null;
	protected ICFBamSwingTZDateTypeFactory factoryTZDateType = null;
	protected ICFBamSwingTZTimeColFactory factoryTZTimeCol = null;
	protected ICFBamSwingTZTimeDefFactory factoryTZTimeDef = null;
	protected ICFBamSwingTZTimeTypeFactory factoryTZTimeType = null;
	protected ICFBamSwingTZTimestampColFactory factoryTZTimestampCol = null;
	protected ICFBamSwingTZTimestampDefFactory factoryTZTimestampDef = null;
	protected ICFBamSwingTZTimestampTypeFactory factoryTZTimestampType = null;
	protected ICFBamSwingTableFactory factoryTable = null;
	protected ICFBamSwingTableColFactory factoryTableCol = null;
	protected ICFBamSwingTenantFactory factoryTenant = null;
	protected ICFBamSwingTextColFactory factoryTextCol = null;
	protected ICFBamSwingTextDefFactory factoryTextDef = null;
	protected ICFBamSwingTextTypeFactory factoryTextType = null;
	protected ICFBamSwingTimeColFactory factoryTimeCol = null;
	protected ICFBamSwingTimeDefFactory factoryTimeDef = null;
	protected ICFBamSwingTimeTypeFactory factoryTimeType = null;
	protected ICFBamSwingTimestampColFactory factoryTimestampCol = null;
	protected ICFBamSwingTimestampDefFactory factoryTimestampDef = null;
	protected ICFBamSwingTimestampTypeFactory factoryTimestampType = null;
	protected ICFBamSwingTldFactory factoryTld = null;
	protected ICFBamSwingTokenColFactory factoryTokenCol = null;
	protected ICFBamSwingTokenDefFactory factoryTokenDef = null;
	protected ICFBamSwingTokenTypeFactory factoryTokenType = null;
	protected ICFBamSwingTopDomainFactory factoryTopDomain = null;
	protected ICFBamSwingTopProjectFactory factoryTopProject = null;
	protected ICFBamSwingUInt16ColFactory factoryUInt16Col = null;
	protected ICFBamSwingUInt16DefFactory factoryUInt16Def = null;
	protected ICFBamSwingUInt16TypeFactory factoryUInt16Type = null;
	protected ICFBamSwingUInt32ColFactory factoryUInt32Col = null;
	protected ICFBamSwingUInt32DefFactory factoryUInt32Def = null;
	protected ICFBamSwingUInt32TypeFactory factoryUInt32Type = null;
	protected ICFBamSwingUInt64ColFactory factoryUInt64Col = null;
	protected ICFBamSwingUInt64DefFactory factoryUInt64Def = null;
	protected ICFBamSwingUInt64TypeFactory factoryUInt64Type = null;
	protected ICFBamSwingURLProtocolFactory factoryURLProtocol = null;
	protected ICFBamSwingUuidColFactory factoryUuidCol = null;
	protected ICFBamSwingUuidDefFactory factoryUuidDef = null;
	protected ICFBamSwingUuidGenFactory factoryUuidGen = null;
	protected ICFBamSwingUuidTypeFactory factoryUuidType = null;
	protected ICFBamSwingValueFactory factoryValue = null;
	protected ICFBamSwingVersionFactory factoryVersion = null;

	public CFBamSwingSchema() {
	}

	public CFBamClientConfigurationFile getClientConfigurationFile() {
		return( clientConfigurationFile );
	}

	public void setClientConfigurationFile( CFBamClientConfigurationFile value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setClientConfigurationFile",
				1,
				"value" );
		}
		clientConfigurationFile = value;
	}

	public KeyStore getKeyStore() {
		return( keyStore );
	}

	public void setKeyStore( KeyStore value ) {
		keyStore = value;
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj argSchema ) {
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setSchema",
				1,
				"argSchema" );
		}
		schema = argSchema;
	}

	public String getClusterName() {
		return( clusterName );
	}

	public void setClusterName( String argClusterName ) {
		final String S_ProcName = "setClusterName";
		if( ( argClusterName == null ) || ( argClusterName.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argClusterName" );
		}
		clusterName = argClusterName;
		clusterObj = null;
	}

	public ICFBamClusterObj getClusterObj() {
		if( clusterObj == null ) {
			if( ( schema != null ) && schema.isConnected() ) {
				boolean transactionStarted = schema.beginTransaction();
				try {
					clusterObj = schema.getClusterTableObj().readClusterByUDomainNameIdx( clusterName );
					if( transactionStarted ) {
						schema.commit();
					}
				}
				catch( RuntimeException e ) {
					if( transactionStarted ) {
						try {
							schema.rollback();
						}
						catch( Exception e2 ) {
						}
					}
					throw e;
				}
			}
			if( clusterObj == null ) {
				throw new RuntimeException( "Cluster \"" + clusterName + "\" could not be found" );
			}
		}
		else {
			throw new RuntimeException( "Cannot resolve Cluster before a connection is established" );
		}
		return( clusterObj );
	}

	public String getTenantName() {
		return( tenantName );
	}

	public void setTenantName( String argTenantName ) {
		final String S_ProcName = "setTenantName";
		if( ( argTenantName == null ) || ( argTenantName.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argTenantName" );
		}
		tenantName = argTenantName;
		tenantObj = null;
	}

	public ICFBamTenantObj getTenantObj() {
		if( tenantObj == null ) {
			if( ( schema != null ) && schema.isConnected() ) {
				boolean transactionStarted = schema.beginTransaction();
				try {
					tenantObj = schema.getTenantTableObj().readTenantByUNameIdx( getClusterObj().getRequiredId(), tenantName );
					if( transactionStarted ) {
						schema.commit();
					}
				}
				catch( RuntimeException e ) {
					if( transactionStarted ) {
						try {
							schema.rollback();
						}
						catch( Exception e2 ) {
						}
					}
					throw e;
				}
			}
			if( tenantObj == null ) {
				throw new RuntimeException( "Tenant \"" + tenantName + "\" could not be found for Cluster \"" + clusterName + "\"" );
			}
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( "Cannot resolve tenant before a connection is established" );
		}
		return( tenantObj );
	}

	public String getSecUserName() {
		return( secUserName );
	}

	public void setSecUserName( String argSecUserName ) {
		final String S_ProcName = "setSecUserName";
		if( ( argSecUserName == null ) || ( argSecUserName.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSecUserName" );
		}
		secUserName = argSecUserName;
		secUserObj = null;
	}

	public ICFBamSecUserObj getSecUserObj() {
		if( secUserObj == null ) {
			if( ( schema != null ) && schema.isConnected() ) {
				boolean transactionStarted = schema.beginTransaction();
				try {
					secUserObj = schema.getSecUserTableObj().readSecUserByULoginIdx( secUserName );
					if( transactionStarted ) {
						schema.commit();
					}
				}
				catch( RuntimeException e ) {
					if( transactionStarted ) {
						try {
							schema.rollback();
						}
						catch( Exception e2 ) {
						}
					}
					throw e;
				}
			}
			if( secUserObj == null ) {
				throw new RuntimeException( "SecUser \"" + secUserName + "\" could not be found" );
			}
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( "Cannot resolve security user before a connection is established" );
		}
		return( secUserObj );
	}

	public ICFBamSecSessionObj getSecSessionObj() {
		if( secSessionObj == null ) {
			if( ( schema != null ) && schema.isConnected() ) {
				boolean transactionStarted = schema.beginTransaction();
				try {
					getClusterObj();
					getTenantObj();
					getSecUserObj();
					secSessionObj = schema.getSecSessionTableObj().newInstance();
					ICFBamSecSessionEditObj sessionEdit = secSessionObj.beginEdit();
					sessionEdit.setRequiredContainerSecUser( secUserObj );
					sessionEdit.setRequiredStart( Calendar.getInstance() );
					sessionEdit.setOptionalFinish( null );
					secSessionObj = sessionEdit.create();
					sessionEdit.endEdit();
					if( transactionStarted ) {
						schema.commit();
					}
				}
				catch( RuntimeException e ) {
					if( transactionStarted ) {
						try {
							schema.rollback();
						}
						catch( Exception e2 ) {
						}
					}
					throw e;
				}
			}
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( "Cannot resolve security session before a connection is established" );
		}
		return( secSessionObj );
	}

	public JFrame newMainJFrame() {
		JFrame jframe = new CFBamSwingMainJFrame( this );
		return( jframe );
	}

	public JInternalFrame newOpenKeystoreJInternalFrame() {
		JInternalFrame jframe = new CFBamSwingOpenKeystoreJInternalFrame( this );
		return( jframe );
	}

	public JInternalFrame newCreateKeystoreJInternalFrame() {
		JInternalFrame jframe = new CFBamSwingCreateKeystoreJInternalFrame( this );
		return( jframe );
	}

	public JInternalFrame newOpenDeviceKeyJInternalFrame() {
		JInternalFrame jframe = new CFBamSwingOpenDeviceKeyJInternalFrame( this );
		return( jframe );
	}

	public JInternalFrame newDisplayPublicKeyJInternalFrame() {
		JInternalFrame jframe = new CFBamSwingDisplayPublicKeyJInternalFrame( this );
		return( jframe );
	}

	public JInternalFrame newFileImportJInternalFrame() {
		JInternalFrame jframe = new CFBamSwingFileImportJInternalFrame( this );
		return( jframe );
	}

	public JInternalFrame newLoginJInternalFrame() {
		JInternalFrame jframe = new CFBamSwingLoginJInternalFrame( this );
		return( jframe );
	}

	public ICFBamSwingAccessFrequencyFactory getAccessFrequencyFactory() {
		if( factoryAccessFrequency == null ) {
			factoryAccessFrequency = new CFBamSwingAccessFrequencyFactory( this );
		}
		return( factoryAccessFrequency );
	}

	public ICFBamSwingAccessSecurityFactory getAccessSecurityFactory() {
		if( factoryAccessSecurity == null ) {
			factoryAccessSecurity = new CFBamSwingAccessSecurityFactory( this );
		}
		return( factoryAccessSecurity );
	}

	public ICFBamSwingAtomFactory getAtomFactory() {
		if( factoryAtom == null ) {
			factoryAtom = new CFBamSwingAtomFactory( this );
		}
		return( factoryAtom );
	}

	public ICFBamSwingAuditActionFactory getAuditActionFactory() {
		if( factoryAuditAction == null ) {
			factoryAuditAction = new CFBamSwingAuditActionFactory( this );
		}
		return( factoryAuditAction );
	}

	public ICFBamSwingBlobColFactory getBlobColFactory() {
		if( factoryBlobCol == null ) {
			factoryBlobCol = new CFBamSwingBlobColFactory( this );
		}
		return( factoryBlobCol );
	}

	public ICFBamSwingBlobDefFactory getBlobDefFactory() {
		if( factoryBlobDef == null ) {
			factoryBlobDef = new CFBamSwingBlobDefFactory( this );
		}
		return( factoryBlobDef );
	}

	public ICFBamSwingBlobTypeFactory getBlobTypeFactory() {
		if( factoryBlobType == null ) {
			factoryBlobType = new CFBamSwingBlobTypeFactory( this );
		}
		return( factoryBlobType );
	}

	public ICFBamSwingBoolColFactory getBoolColFactory() {
		if( factoryBoolCol == null ) {
			factoryBoolCol = new CFBamSwingBoolColFactory( this );
		}
		return( factoryBoolCol );
	}

	public ICFBamSwingBoolDefFactory getBoolDefFactory() {
		if( factoryBoolDef == null ) {
			factoryBoolDef = new CFBamSwingBoolDefFactory( this );
		}
		return( factoryBoolDef );
	}

	public ICFBamSwingBoolTypeFactory getBoolTypeFactory() {
		if( factoryBoolType == null ) {
			factoryBoolType = new CFBamSwingBoolTypeFactory( this );
		}
		return( factoryBoolType );
	}

	public ICFBamSwingChainFactory getChainFactory() {
		if( factoryChain == null ) {
			factoryChain = new CFBamSwingChainFactory( this );
		}
		return( factoryChain );
	}

	public ICFBamSwingClearDepFactory getClearDepFactory() {
		if( factoryClearDep == null ) {
			factoryClearDep = new CFBamSwingClearDepFactory( this );
		}
		return( factoryClearDep );
	}

	public ICFBamSwingClearSubDep1Factory getClearSubDep1Factory() {
		if( factoryClearSubDep1 == null ) {
			factoryClearSubDep1 = new CFBamSwingClearSubDep1Factory( this );
		}
		return( factoryClearSubDep1 );
	}

	public ICFBamSwingClearSubDep2Factory getClearSubDep2Factory() {
		if( factoryClearSubDep2 == null ) {
			factoryClearSubDep2 = new CFBamSwingClearSubDep2Factory( this );
		}
		return( factoryClearSubDep2 );
	}

	public ICFBamSwingClearSubDep3Factory getClearSubDep3Factory() {
		if( factoryClearSubDep3 == null ) {
			factoryClearSubDep3 = new CFBamSwingClearSubDep3Factory( this );
		}
		return( factoryClearSubDep3 );
	}

	public ICFBamSwingClearTopDepFactory getClearTopDepFactory() {
		if( factoryClearTopDep == null ) {
			factoryClearTopDep = new CFBamSwingClearTopDepFactory( this );
		}
		return( factoryClearTopDep );
	}

	public ICFBamSwingClusterFactory getClusterFactory() {
		if( factoryCluster == null ) {
			factoryCluster = new CFBamSwingClusterFactory( this );
		}
		return( factoryCluster );
	}

	public ICFBamSwingDataScopeFactory getDataScopeFactory() {
		if( factoryDataScope == null ) {
			factoryDataScope = new CFBamSwingDataScopeFactory( this );
		}
		return( factoryDataScope );
	}

	public ICFBamSwingDateColFactory getDateColFactory() {
		if( factoryDateCol == null ) {
			factoryDateCol = new CFBamSwingDateColFactory( this );
		}
		return( factoryDateCol );
	}

	public ICFBamSwingDateDefFactory getDateDefFactory() {
		if( factoryDateDef == null ) {
			factoryDateDef = new CFBamSwingDateDefFactory( this );
		}
		return( factoryDateDef );
	}

	public ICFBamSwingDateTypeFactory getDateTypeFactory() {
		if( factoryDateType == null ) {
			factoryDateType = new CFBamSwingDateTypeFactory( this );
		}
		return( factoryDateType );
	}

	public ICFBamSwingDelDepFactory getDelDepFactory() {
		if( factoryDelDep == null ) {
			factoryDelDep = new CFBamSwingDelDepFactory( this );
		}
		return( factoryDelDep );
	}

	public ICFBamSwingDelSubDep1Factory getDelSubDep1Factory() {
		if( factoryDelSubDep1 == null ) {
			factoryDelSubDep1 = new CFBamSwingDelSubDep1Factory( this );
		}
		return( factoryDelSubDep1 );
	}

	public ICFBamSwingDelSubDep2Factory getDelSubDep2Factory() {
		if( factoryDelSubDep2 == null ) {
			factoryDelSubDep2 = new CFBamSwingDelSubDep2Factory( this );
		}
		return( factoryDelSubDep2 );
	}

	public ICFBamSwingDelSubDep3Factory getDelSubDep3Factory() {
		if( factoryDelSubDep3 == null ) {
			factoryDelSubDep3 = new CFBamSwingDelSubDep3Factory( this );
		}
		return( factoryDelSubDep3 );
	}

	public ICFBamSwingDelTopDepFactory getDelTopDepFactory() {
		if( factoryDelTopDep == null ) {
			factoryDelTopDep = new CFBamSwingDelTopDepFactory( this );
		}
		return( factoryDelTopDep );
	}

	public ICFBamSwingDomainFactory getDomainFactory() {
		if( factoryDomain == null ) {
			factoryDomain = new CFBamSwingDomainFactory( this );
		}
		return( factoryDomain );
	}

	public ICFBamSwingDomainBaseFactory getDomainBaseFactory() {
		if( factoryDomainBase == null ) {
			factoryDomainBase = new CFBamSwingDomainBaseFactory( this );
		}
		return( factoryDomainBase );
	}

	public ICFBamSwingDoubleColFactory getDoubleColFactory() {
		if( factoryDoubleCol == null ) {
			factoryDoubleCol = new CFBamSwingDoubleColFactory( this );
		}
		return( factoryDoubleCol );
	}

	public ICFBamSwingDoubleDefFactory getDoubleDefFactory() {
		if( factoryDoubleDef == null ) {
			factoryDoubleDef = new CFBamSwingDoubleDefFactory( this );
		}
		return( factoryDoubleDef );
	}

	public ICFBamSwingDoubleTypeFactory getDoubleTypeFactory() {
		if( factoryDoubleType == null ) {
			factoryDoubleType = new CFBamSwingDoubleTypeFactory( this );
		}
		return( factoryDoubleType );
	}

	public ICFBamSwingEnumColFactory getEnumColFactory() {
		if( factoryEnumCol == null ) {
			factoryEnumCol = new CFBamSwingEnumColFactory( this );
		}
		return( factoryEnumCol );
	}

	public ICFBamSwingEnumDefFactory getEnumDefFactory() {
		if( factoryEnumDef == null ) {
			factoryEnumDef = new CFBamSwingEnumDefFactory( this );
		}
		return( factoryEnumDef );
	}

	public ICFBamSwingEnumTagFactory getEnumTagFactory() {
		if( factoryEnumTag == null ) {
			factoryEnumTag = new CFBamSwingEnumTagFactory( this );
		}
		return( factoryEnumTag );
	}

	public ICFBamSwingEnumTypeFactory getEnumTypeFactory() {
		if( factoryEnumType == null ) {
			factoryEnumType = new CFBamSwingEnumTypeFactory( this );
		}
		return( factoryEnumType );
	}

	public ICFBamSwingFloatColFactory getFloatColFactory() {
		if( factoryFloatCol == null ) {
			factoryFloatCol = new CFBamSwingFloatColFactory( this );
		}
		return( factoryFloatCol );
	}

	public ICFBamSwingFloatDefFactory getFloatDefFactory() {
		if( factoryFloatDef == null ) {
			factoryFloatDef = new CFBamSwingFloatDefFactory( this );
		}
		return( factoryFloatDef );
	}

	public ICFBamSwingFloatTypeFactory getFloatTypeFactory() {
		if( factoryFloatType == null ) {
			factoryFloatType = new CFBamSwingFloatTypeFactory( this );
		}
		return( factoryFloatType );
	}

	public ICFBamSwingHostNodeFactory getHostNodeFactory() {
		if( factoryHostNode == null ) {
			factoryHostNode = new CFBamSwingHostNodeFactory( this );
		}
		return( factoryHostNode );
	}

	public ICFBamSwingISOCountryFactory getISOCountryFactory() {
		if( factoryISOCountry == null ) {
			factoryISOCountry = new CFBamSwingISOCountryFactory( this );
		}
		return( factoryISOCountry );
	}

	public ICFBamSwingISOCountryCurrencyFactory getISOCountryCurrencyFactory() {
		if( factoryISOCountryCurrency == null ) {
			factoryISOCountryCurrency = new CFBamSwingISOCountryCurrencyFactory( this );
		}
		return( factoryISOCountryCurrency );
	}

	public ICFBamSwingISOCountryLanguageFactory getISOCountryLanguageFactory() {
		if( factoryISOCountryLanguage == null ) {
			factoryISOCountryLanguage = new CFBamSwingISOCountryLanguageFactory( this );
		}
		return( factoryISOCountryLanguage );
	}

	public ICFBamSwingISOCurrencyFactory getISOCurrencyFactory() {
		if( factoryISOCurrency == null ) {
			factoryISOCurrency = new CFBamSwingISOCurrencyFactory( this );
		}
		return( factoryISOCurrency );
	}

	public ICFBamSwingISOLanguageFactory getISOLanguageFactory() {
		if( factoryISOLanguage == null ) {
			factoryISOLanguage = new CFBamSwingISOLanguageFactory( this );
		}
		return( factoryISOLanguage );
	}

	public ICFBamSwingISOTimezoneFactory getISOTimezoneFactory() {
		if( factoryISOTimezone == null ) {
			factoryISOTimezone = new CFBamSwingISOTimezoneFactory( this );
		}
		return( factoryISOTimezone );
	}

	public ICFBamSwingId16GenFactory getId16GenFactory() {
		if( factoryId16Gen == null ) {
			factoryId16Gen = new CFBamSwingId16GenFactory( this );
		}
		return( factoryId16Gen );
	}

	public ICFBamSwingId32GenFactory getId32GenFactory() {
		if( factoryId32Gen == null ) {
			factoryId32Gen = new CFBamSwingId32GenFactory( this );
		}
		return( factoryId32Gen );
	}

	public ICFBamSwingId64GenFactory getId64GenFactory() {
		if( factoryId64Gen == null ) {
			factoryId64Gen = new CFBamSwingId64GenFactory( this );
		}
		return( factoryId64Gen );
	}

	public ICFBamSwingIndexFactory getIndexFactory() {
		if( factoryIndex == null ) {
			factoryIndex = new CFBamSwingIndexFactory( this );
		}
		return( factoryIndex );
	}

	public ICFBamSwingIndexColFactory getIndexColFactory() {
		if( factoryIndexCol == null ) {
			factoryIndexCol = new CFBamSwingIndexColFactory( this );
		}
		return( factoryIndexCol );
	}

	public ICFBamSwingInt16ColFactory getInt16ColFactory() {
		if( factoryInt16Col == null ) {
			factoryInt16Col = new CFBamSwingInt16ColFactory( this );
		}
		return( factoryInt16Col );
	}

	public ICFBamSwingInt16DefFactory getInt16DefFactory() {
		if( factoryInt16Def == null ) {
			factoryInt16Def = new CFBamSwingInt16DefFactory( this );
		}
		return( factoryInt16Def );
	}

	public ICFBamSwingInt16TypeFactory getInt16TypeFactory() {
		if( factoryInt16Type == null ) {
			factoryInt16Type = new CFBamSwingInt16TypeFactory( this );
		}
		return( factoryInt16Type );
	}

	public ICFBamSwingInt32ColFactory getInt32ColFactory() {
		if( factoryInt32Col == null ) {
			factoryInt32Col = new CFBamSwingInt32ColFactory( this );
		}
		return( factoryInt32Col );
	}

	public ICFBamSwingInt32DefFactory getInt32DefFactory() {
		if( factoryInt32Def == null ) {
			factoryInt32Def = new CFBamSwingInt32DefFactory( this );
		}
		return( factoryInt32Def );
	}

	public ICFBamSwingInt32TypeFactory getInt32TypeFactory() {
		if( factoryInt32Type == null ) {
			factoryInt32Type = new CFBamSwingInt32TypeFactory( this );
		}
		return( factoryInt32Type );
	}

	public ICFBamSwingInt64ColFactory getInt64ColFactory() {
		if( factoryInt64Col == null ) {
			factoryInt64Col = new CFBamSwingInt64ColFactory( this );
		}
		return( factoryInt64Col );
	}

	public ICFBamSwingInt64DefFactory getInt64DefFactory() {
		if( factoryInt64Def == null ) {
			factoryInt64Def = new CFBamSwingInt64DefFactory( this );
		}
		return( factoryInt64Def );
	}

	public ICFBamSwingInt64TypeFactory getInt64TypeFactory() {
		if( factoryInt64Type == null ) {
			factoryInt64Type = new CFBamSwingInt64TypeFactory( this );
		}
		return( factoryInt64Type );
	}

	public ICFBamSwingLicenseFactory getLicenseFactory() {
		if( factoryLicense == null ) {
			factoryLicense = new CFBamSwingLicenseFactory( this );
		}
		return( factoryLicense );
	}

	public ICFBamSwingLoaderBehaviourFactory getLoaderBehaviourFactory() {
		if( factoryLoaderBehaviour == null ) {
			factoryLoaderBehaviour = new CFBamSwingLoaderBehaviourFactory( this );
		}
		return( factoryLoaderBehaviour );
	}

	public ICFBamSwingMajorVersionFactory getMajorVersionFactory() {
		if( factoryMajorVersion == null ) {
			factoryMajorVersion = new CFBamSwingMajorVersionFactory( this );
		}
		return( factoryMajorVersion );
	}

	public ICFBamSwingMimeTypeFactory getMimeTypeFactory() {
		if( factoryMimeType == null ) {
			factoryMimeType = new CFBamSwingMimeTypeFactory( this );
		}
		return( factoryMimeType );
	}

	public ICFBamSwingMinorVersionFactory getMinorVersionFactory() {
		if( factoryMinorVersion == null ) {
			factoryMinorVersion = new CFBamSwingMinorVersionFactory( this );
		}
		return( factoryMinorVersion );
	}

	public ICFBamSwingNmTokenColFactory getNmTokenColFactory() {
		if( factoryNmTokenCol == null ) {
			factoryNmTokenCol = new CFBamSwingNmTokenColFactory( this );
		}
		return( factoryNmTokenCol );
	}

	public ICFBamSwingNmTokenDefFactory getNmTokenDefFactory() {
		if( factoryNmTokenDef == null ) {
			factoryNmTokenDef = new CFBamSwingNmTokenDefFactory( this );
		}
		return( factoryNmTokenDef );
	}

	public ICFBamSwingNmTokenTypeFactory getNmTokenTypeFactory() {
		if( factoryNmTokenType == null ) {
			factoryNmTokenType = new CFBamSwingNmTokenTypeFactory( this );
		}
		return( factoryNmTokenType );
	}

	public ICFBamSwingNmTokensColFactory getNmTokensColFactory() {
		if( factoryNmTokensCol == null ) {
			factoryNmTokensCol = new CFBamSwingNmTokensColFactory( this );
		}
		return( factoryNmTokensCol );
	}

	public ICFBamSwingNmTokensDefFactory getNmTokensDefFactory() {
		if( factoryNmTokensDef == null ) {
			factoryNmTokensDef = new CFBamSwingNmTokensDefFactory( this );
		}
		return( factoryNmTokensDef );
	}

	public ICFBamSwingNmTokensTypeFactory getNmTokensTypeFactory() {
		if( factoryNmTokensType == null ) {
			factoryNmTokensType = new CFBamSwingNmTokensTypeFactory( this );
		}
		return( factoryNmTokensType );
	}

	public ICFBamSwingNumberColFactory getNumberColFactory() {
		if( factoryNumberCol == null ) {
			factoryNumberCol = new CFBamSwingNumberColFactory( this );
		}
		return( factoryNumberCol );
	}

	public ICFBamSwingNumberDefFactory getNumberDefFactory() {
		if( factoryNumberDef == null ) {
			factoryNumberDef = new CFBamSwingNumberDefFactory( this );
		}
		return( factoryNumberDef );
	}

	public ICFBamSwingNumberTypeFactory getNumberTypeFactory() {
		if( factoryNumberType == null ) {
			factoryNumberType = new CFBamSwingNumberTypeFactory( this );
		}
		return( factoryNumberType );
	}

	public ICFBamSwingParamFactory getParamFactory() {
		if( factoryParam == null ) {
			factoryParam = new CFBamSwingParamFactory( this );
		}
		return( factoryParam );
	}

	public ICFBamSwingPopDepFactory getPopDepFactory() {
		if( factoryPopDep == null ) {
			factoryPopDep = new CFBamSwingPopDepFactory( this );
		}
		return( factoryPopDep );
	}

	public ICFBamSwingPopSubDep1Factory getPopSubDep1Factory() {
		if( factoryPopSubDep1 == null ) {
			factoryPopSubDep1 = new CFBamSwingPopSubDep1Factory( this );
		}
		return( factoryPopSubDep1 );
	}

	public ICFBamSwingPopSubDep2Factory getPopSubDep2Factory() {
		if( factoryPopSubDep2 == null ) {
			factoryPopSubDep2 = new CFBamSwingPopSubDep2Factory( this );
		}
		return( factoryPopSubDep2 );
	}

	public ICFBamSwingPopSubDep3Factory getPopSubDep3Factory() {
		if( factoryPopSubDep3 == null ) {
			factoryPopSubDep3 = new CFBamSwingPopSubDep3Factory( this );
		}
		return( factoryPopSubDep3 );
	}

	public ICFBamSwingPopTopDepFactory getPopTopDepFactory() {
		if( factoryPopTopDep == null ) {
			factoryPopTopDep = new CFBamSwingPopTopDepFactory( this );
		}
		return( factoryPopTopDep );
	}

	public ICFBamSwingProjectBaseFactory getProjectBaseFactory() {
		if( factoryProjectBase == null ) {
			factoryProjectBase = new CFBamSwingProjectBaseFactory( this );
		}
		return( factoryProjectBase );
	}

	public ICFBamSwingRealProjectFactory getRealProjectFactory() {
		if( factoryRealProject == null ) {
			factoryRealProject = new CFBamSwingRealProjectFactory( this );
		}
		return( factoryRealProject );
	}

	public ICFBamSwingRelationFactory getRelationFactory() {
		if( factoryRelation == null ) {
			factoryRelation = new CFBamSwingRelationFactory( this );
		}
		return( factoryRelation );
	}

	public ICFBamSwingRelationColFactory getRelationColFactory() {
		if( factoryRelationCol == null ) {
			factoryRelationCol = new CFBamSwingRelationColFactory( this );
		}
		return( factoryRelationCol );
	}

	public ICFBamSwingRelationTypeFactory getRelationTypeFactory() {
		if( factoryRelationType == null ) {
			factoryRelationType = new CFBamSwingRelationTypeFactory( this );
		}
		return( factoryRelationType );
	}

	public ICFBamSwingSchemaDefFactory getSchemaDefFactory() {
		if( factorySchemaDef == null ) {
			factorySchemaDef = new CFBamSwingSchemaDefFactory( this );
		}
		return( factorySchemaDef );
	}

	public ICFBamSwingSchemaRefFactory getSchemaRefFactory() {
		if( factorySchemaRef == null ) {
			factorySchemaRef = new CFBamSwingSchemaRefFactory( this );
		}
		return( factorySchemaRef );
	}

	public ICFBamSwingScopeFactory getScopeFactory() {
		if( factoryScope == null ) {
			factoryScope = new CFBamSwingScopeFactory( this );
		}
		return( factoryScope );
	}

	public ICFBamSwingSecAppFactory getSecAppFactory() {
		if( factorySecApp == null ) {
			factorySecApp = new CFBamSwingSecAppFactory( this );
		}
		return( factorySecApp );
	}

	public ICFBamSwingSecDeviceFactory getSecDeviceFactory() {
		if( factorySecDevice == null ) {
			factorySecDevice = new CFBamSwingSecDeviceFactory( this );
		}
		return( factorySecDevice );
	}

	public ICFBamSwingSecFormFactory getSecFormFactory() {
		if( factorySecForm == null ) {
			factorySecForm = new CFBamSwingSecFormFactory( this );
		}
		return( factorySecForm );
	}

	public ICFBamSwingSecGroupFactory getSecGroupFactory() {
		if( factorySecGroup == null ) {
			factorySecGroup = new CFBamSwingSecGroupFactory( this );
		}
		return( factorySecGroup );
	}

	public ICFBamSwingSecGroupFormFactory getSecGroupFormFactory() {
		if( factorySecGroupForm == null ) {
			factorySecGroupForm = new CFBamSwingSecGroupFormFactory( this );
		}
		return( factorySecGroupForm );
	}

	public ICFBamSwingSecGroupIncludeFactory getSecGroupIncludeFactory() {
		if( factorySecGroupInclude == null ) {
			factorySecGroupInclude = new CFBamSwingSecGroupIncludeFactory( this );
		}
		return( factorySecGroupInclude );
	}

	public ICFBamSwingSecGroupMemberFactory getSecGroupMemberFactory() {
		if( factorySecGroupMember == null ) {
			factorySecGroupMember = new CFBamSwingSecGroupMemberFactory( this );
		}
		return( factorySecGroupMember );
	}

	public ICFBamSwingSecSessionFactory getSecSessionFactory() {
		if( factorySecSession == null ) {
			factorySecSession = new CFBamSwingSecSessionFactory( this );
		}
		return( factorySecSession );
	}

	public ICFBamSwingSecUserFactory getSecUserFactory() {
		if( factorySecUser == null ) {
			factorySecUser = new CFBamSwingSecUserFactory( this );
		}
		return( factorySecUser );
	}

	public ICFBamSwingSecurityScopeFactory getSecurityScopeFactory() {
		if( factorySecurityScope == null ) {
			factorySecurityScope = new CFBamSwingSecurityScopeFactory( this );
		}
		return( factorySecurityScope );
	}

	public ICFBamSwingServerListFuncFactory getServerListFuncFactory() {
		if( factoryServerListFunc == null ) {
			factoryServerListFunc = new CFBamSwingServerListFuncFactory( this );
		}
		return( factoryServerListFunc );
	}

	public ICFBamSwingServerMethodFactory getServerMethodFactory() {
		if( factoryServerMethod == null ) {
			factoryServerMethod = new CFBamSwingServerMethodFactory( this );
		}
		return( factoryServerMethod );
	}

	public ICFBamSwingServerObjFuncFactory getServerObjFuncFactory() {
		if( factoryServerObjFunc == null ) {
			factoryServerObjFunc = new CFBamSwingServerObjFuncFactory( this );
		}
		return( factoryServerObjFunc );
	}

	public ICFBamSwingServerProcFactory getServerProcFactory() {
		if( factoryServerProc == null ) {
			factoryServerProc = new CFBamSwingServerProcFactory( this );
		}
		return( factoryServerProc );
	}

	public ICFBamSwingServiceFactory getServiceFactory() {
		if( factoryService == null ) {
			factoryService = new CFBamSwingServiceFactory( this );
		}
		return( factoryService );
	}

	public ICFBamSwingServiceTypeFactory getServiceTypeFactory() {
		if( factoryServiceType == null ) {
			factoryServiceType = new CFBamSwingServiceTypeFactory( this );
		}
		return( factoryServiceType );
	}

	public ICFBamSwingStringColFactory getStringColFactory() {
		if( factoryStringCol == null ) {
			factoryStringCol = new CFBamSwingStringColFactory( this );
		}
		return( factoryStringCol );
	}

	public ICFBamSwingStringDefFactory getStringDefFactory() {
		if( factoryStringDef == null ) {
			factoryStringDef = new CFBamSwingStringDefFactory( this );
		}
		return( factoryStringDef );
	}

	public ICFBamSwingStringTypeFactory getStringTypeFactory() {
		if( factoryStringType == null ) {
			factoryStringType = new CFBamSwingStringTypeFactory( this );
		}
		return( factoryStringType );
	}

	public ICFBamSwingSubProjectFactory getSubProjectFactory() {
		if( factorySubProject == null ) {
			factorySubProject = new CFBamSwingSubProjectFactory( this );
		}
		return( factorySubProject );
	}

	public ICFBamSwingSysClusterFactory getSysClusterFactory() {
		if( factorySysCluster == null ) {
			factorySysCluster = new CFBamSwingSysClusterFactory( this );
		}
		return( factorySysCluster );
	}

	public ICFBamSwingTSecGroupFactory getTSecGroupFactory() {
		if( factoryTSecGroup == null ) {
			factoryTSecGroup = new CFBamSwingTSecGroupFactory( this );
		}
		return( factoryTSecGroup );
	}

	public ICFBamSwingTSecGroupIncludeFactory getTSecGroupIncludeFactory() {
		if( factoryTSecGroupInclude == null ) {
			factoryTSecGroupInclude = new CFBamSwingTSecGroupIncludeFactory( this );
		}
		return( factoryTSecGroupInclude );
	}

	public ICFBamSwingTSecGroupMemberFactory getTSecGroupMemberFactory() {
		if( factoryTSecGroupMember == null ) {
			factoryTSecGroupMember = new CFBamSwingTSecGroupMemberFactory( this );
		}
		return( factoryTSecGroupMember );
	}

	public ICFBamSwingTZDateColFactory getTZDateColFactory() {
		if( factoryTZDateCol == null ) {
			factoryTZDateCol = new CFBamSwingTZDateColFactory( this );
		}
		return( factoryTZDateCol );
	}

	public ICFBamSwingTZDateDefFactory getTZDateDefFactory() {
		if( factoryTZDateDef == null ) {
			factoryTZDateDef = new CFBamSwingTZDateDefFactory( this );
		}
		return( factoryTZDateDef );
	}

	public ICFBamSwingTZDateTypeFactory getTZDateTypeFactory() {
		if( factoryTZDateType == null ) {
			factoryTZDateType = new CFBamSwingTZDateTypeFactory( this );
		}
		return( factoryTZDateType );
	}

	public ICFBamSwingTZTimeColFactory getTZTimeColFactory() {
		if( factoryTZTimeCol == null ) {
			factoryTZTimeCol = new CFBamSwingTZTimeColFactory( this );
		}
		return( factoryTZTimeCol );
	}

	public ICFBamSwingTZTimeDefFactory getTZTimeDefFactory() {
		if( factoryTZTimeDef == null ) {
			factoryTZTimeDef = new CFBamSwingTZTimeDefFactory( this );
		}
		return( factoryTZTimeDef );
	}

	public ICFBamSwingTZTimeTypeFactory getTZTimeTypeFactory() {
		if( factoryTZTimeType == null ) {
			factoryTZTimeType = new CFBamSwingTZTimeTypeFactory( this );
		}
		return( factoryTZTimeType );
	}

	public ICFBamSwingTZTimestampColFactory getTZTimestampColFactory() {
		if( factoryTZTimestampCol == null ) {
			factoryTZTimestampCol = new CFBamSwingTZTimestampColFactory( this );
		}
		return( factoryTZTimestampCol );
	}

	public ICFBamSwingTZTimestampDefFactory getTZTimestampDefFactory() {
		if( factoryTZTimestampDef == null ) {
			factoryTZTimestampDef = new CFBamSwingTZTimestampDefFactory( this );
		}
		return( factoryTZTimestampDef );
	}

	public ICFBamSwingTZTimestampTypeFactory getTZTimestampTypeFactory() {
		if( factoryTZTimestampType == null ) {
			factoryTZTimestampType = new CFBamSwingTZTimestampTypeFactory( this );
		}
		return( factoryTZTimestampType );
	}

	public ICFBamSwingTableFactory getTableFactory() {
		if( factoryTable == null ) {
			factoryTable = new CFBamSwingTableFactory( this );
		}
		return( factoryTable );
	}

	public ICFBamSwingTableColFactory getTableColFactory() {
		if( factoryTableCol == null ) {
			factoryTableCol = new CFBamSwingTableColFactory( this );
		}
		return( factoryTableCol );
	}

	public ICFBamSwingTenantFactory getTenantFactory() {
		if( factoryTenant == null ) {
			factoryTenant = new CFBamSwingTenantFactory( this );
		}
		return( factoryTenant );
	}

	public ICFBamSwingTextColFactory getTextColFactory() {
		if( factoryTextCol == null ) {
			factoryTextCol = new CFBamSwingTextColFactory( this );
		}
		return( factoryTextCol );
	}

	public ICFBamSwingTextDefFactory getTextDefFactory() {
		if( factoryTextDef == null ) {
			factoryTextDef = new CFBamSwingTextDefFactory( this );
		}
		return( factoryTextDef );
	}

	public ICFBamSwingTextTypeFactory getTextTypeFactory() {
		if( factoryTextType == null ) {
			factoryTextType = new CFBamSwingTextTypeFactory( this );
		}
		return( factoryTextType );
	}

	public ICFBamSwingTimeColFactory getTimeColFactory() {
		if( factoryTimeCol == null ) {
			factoryTimeCol = new CFBamSwingTimeColFactory( this );
		}
		return( factoryTimeCol );
	}

	public ICFBamSwingTimeDefFactory getTimeDefFactory() {
		if( factoryTimeDef == null ) {
			factoryTimeDef = new CFBamSwingTimeDefFactory( this );
		}
		return( factoryTimeDef );
	}

	public ICFBamSwingTimeTypeFactory getTimeTypeFactory() {
		if( factoryTimeType == null ) {
			factoryTimeType = new CFBamSwingTimeTypeFactory( this );
		}
		return( factoryTimeType );
	}

	public ICFBamSwingTimestampColFactory getTimestampColFactory() {
		if( factoryTimestampCol == null ) {
			factoryTimestampCol = new CFBamSwingTimestampColFactory( this );
		}
		return( factoryTimestampCol );
	}

	public ICFBamSwingTimestampDefFactory getTimestampDefFactory() {
		if( factoryTimestampDef == null ) {
			factoryTimestampDef = new CFBamSwingTimestampDefFactory( this );
		}
		return( factoryTimestampDef );
	}

	public ICFBamSwingTimestampTypeFactory getTimestampTypeFactory() {
		if( factoryTimestampType == null ) {
			factoryTimestampType = new CFBamSwingTimestampTypeFactory( this );
		}
		return( factoryTimestampType );
	}

	public ICFBamSwingTldFactory getTldFactory() {
		if( factoryTld == null ) {
			factoryTld = new CFBamSwingTldFactory( this );
		}
		return( factoryTld );
	}

	public ICFBamSwingTokenColFactory getTokenColFactory() {
		if( factoryTokenCol == null ) {
			factoryTokenCol = new CFBamSwingTokenColFactory( this );
		}
		return( factoryTokenCol );
	}

	public ICFBamSwingTokenDefFactory getTokenDefFactory() {
		if( factoryTokenDef == null ) {
			factoryTokenDef = new CFBamSwingTokenDefFactory( this );
		}
		return( factoryTokenDef );
	}

	public ICFBamSwingTokenTypeFactory getTokenTypeFactory() {
		if( factoryTokenType == null ) {
			factoryTokenType = new CFBamSwingTokenTypeFactory( this );
		}
		return( factoryTokenType );
	}

	public ICFBamSwingTopDomainFactory getTopDomainFactory() {
		if( factoryTopDomain == null ) {
			factoryTopDomain = new CFBamSwingTopDomainFactory( this );
		}
		return( factoryTopDomain );
	}

	public ICFBamSwingTopProjectFactory getTopProjectFactory() {
		if( factoryTopProject == null ) {
			factoryTopProject = new CFBamSwingTopProjectFactory( this );
		}
		return( factoryTopProject );
	}

	public ICFBamSwingUInt16ColFactory getUInt16ColFactory() {
		if( factoryUInt16Col == null ) {
			factoryUInt16Col = new CFBamSwingUInt16ColFactory( this );
		}
		return( factoryUInt16Col );
	}

	public ICFBamSwingUInt16DefFactory getUInt16DefFactory() {
		if( factoryUInt16Def == null ) {
			factoryUInt16Def = new CFBamSwingUInt16DefFactory( this );
		}
		return( factoryUInt16Def );
	}

	public ICFBamSwingUInt16TypeFactory getUInt16TypeFactory() {
		if( factoryUInt16Type == null ) {
			factoryUInt16Type = new CFBamSwingUInt16TypeFactory( this );
		}
		return( factoryUInt16Type );
	}

	public ICFBamSwingUInt32ColFactory getUInt32ColFactory() {
		if( factoryUInt32Col == null ) {
			factoryUInt32Col = new CFBamSwingUInt32ColFactory( this );
		}
		return( factoryUInt32Col );
	}

	public ICFBamSwingUInt32DefFactory getUInt32DefFactory() {
		if( factoryUInt32Def == null ) {
			factoryUInt32Def = new CFBamSwingUInt32DefFactory( this );
		}
		return( factoryUInt32Def );
	}

	public ICFBamSwingUInt32TypeFactory getUInt32TypeFactory() {
		if( factoryUInt32Type == null ) {
			factoryUInt32Type = new CFBamSwingUInt32TypeFactory( this );
		}
		return( factoryUInt32Type );
	}

	public ICFBamSwingUInt64ColFactory getUInt64ColFactory() {
		if( factoryUInt64Col == null ) {
			factoryUInt64Col = new CFBamSwingUInt64ColFactory( this );
		}
		return( factoryUInt64Col );
	}

	public ICFBamSwingUInt64DefFactory getUInt64DefFactory() {
		if( factoryUInt64Def == null ) {
			factoryUInt64Def = new CFBamSwingUInt64DefFactory( this );
		}
		return( factoryUInt64Def );
	}

	public ICFBamSwingUInt64TypeFactory getUInt64TypeFactory() {
		if( factoryUInt64Type == null ) {
			factoryUInt64Type = new CFBamSwingUInt64TypeFactory( this );
		}
		return( factoryUInt64Type );
	}

	public ICFBamSwingURLProtocolFactory getURLProtocolFactory() {
		if( factoryURLProtocol == null ) {
			factoryURLProtocol = new CFBamSwingURLProtocolFactory( this );
		}
		return( factoryURLProtocol );
	}

	public ICFBamSwingUuidColFactory getUuidColFactory() {
		if( factoryUuidCol == null ) {
			factoryUuidCol = new CFBamSwingUuidColFactory( this );
		}
		return( factoryUuidCol );
	}

	public ICFBamSwingUuidDefFactory getUuidDefFactory() {
		if( factoryUuidDef == null ) {
			factoryUuidDef = new CFBamSwingUuidDefFactory( this );
		}
		return( factoryUuidDef );
	}

	public ICFBamSwingUuidGenFactory getUuidGenFactory() {
		if( factoryUuidGen == null ) {
			factoryUuidGen = new CFBamSwingUuidGenFactory( this );
		}
		return( factoryUuidGen );
	}

	public ICFBamSwingUuidTypeFactory getUuidTypeFactory() {
		if( factoryUuidType == null ) {
			factoryUuidType = new CFBamSwingUuidTypeFactory( this );
		}
		return( factoryUuidType );
	}

	public ICFBamSwingValueFactory getValueFactory() {
		if( factoryValue == null ) {
			factoryValue = new CFBamSwingValueFactory( this );
		}
		return( factoryValue );
	}

	public ICFBamSwingVersionFactory getVersionFactory() {
		if( factoryVersion == null ) {
			factoryVersion = new CFBamSwingVersionFactory( this );
		}
		return( factoryVersion );
	}
}
