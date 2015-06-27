// Description: Java 7 Swing Schema Interface for CFBam.

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

/**
 *	The ICFBamSwingSchema defines the factory interface for the
 *	for the various panels and components used to construct a GUI interface
 *	using the Swing framework.
 */
public interface ICFBamSwingSchema
{
	CFBamClientConfigurationFile getClientConfigurationFile();
	void setClientConfigurationFile( CFBamClientConfigurationFile value );

	KeyStore getKeyStore();
	void setKeyStore( KeyStore value );

	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj argSchema );

	String getClusterName();
	void setClusterName( String argClusterName );
	ICFBamClusterObj getClusterObj();

	String getTenantName();
	void setTenantName( String argTenantName );
	ICFBamTenantObj getTenantObj();

	String getSecUserName();
	void setSecUserName( String argSecUserName );
	ICFBamSecUserObj getSecUserObj();

	ICFBamSecSessionObj getSecSessionObj();

	JFrame newMainJFrame();
	JInternalFrame newOpenKeystoreJInternalFrame();
	JInternalFrame newCreateKeystoreJInternalFrame();
	JInternalFrame newOpenDeviceKeyJInternalFrame();
	JInternalFrame newDisplayPublicKeyJInternalFrame();
	JInternalFrame newLoginJInternalFrame();
	JInternalFrame newFileImportJInternalFrame();

	public ICFBamSwingAccessFrequencyFactory getAccessFrequencyFactory();

	public ICFBamSwingAccessSecurityFactory getAccessSecurityFactory();

	public ICFBamSwingAtomFactory getAtomFactory();

	public ICFBamSwingAuditActionFactory getAuditActionFactory();

	public ICFBamSwingBlobColFactory getBlobColFactory();

	public ICFBamSwingBlobDefFactory getBlobDefFactory();

	public ICFBamSwingBlobTypeFactory getBlobTypeFactory();

	public ICFBamSwingBoolColFactory getBoolColFactory();

	public ICFBamSwingBoolDefFactory getBoolDefFactory();

	public ICFBamSwingBoolTypeFactory getBoolTypeFactory();

	public ICFBamSwingChainFactory getChainFactory();

	public ICFBamSwingClearDepFactory getClearDepFactory();

	public ICFBamSwingClearSubDep1Factory getClearSubDep1Factory();

	public ICFBamSwingClearSubDep2Factory getClearSubDep2Factory();

	public ICFBamSwingClearSubDep3Factory getClearSubDep3Factory();

	public ICFBamSwingClearTopDepFactory getClearTopDepFactory();

	public ICFBamSwingClusterFactory getClusterFactory();

	public ICFBamSwingDataScopeFactory getDataScopeFactory();

	public ICFBamSwingDateColFactory getDateColFactory();

	public ICFBamSwingDateDefFactory getDateDefFactory();

	public ICFBamSwingDateTypeFactory getDateTypeFactory();

	public ICFBamSwingDelDepFactory getDelDepFactory();

	public ICFBamSwingDelSubDep1Factory getDelSubDep1Factory();

	public ICFBamSwingDelSubDep2Factory getDelSubDep2Factory();

	public ICFBamSwingDelSubDep3Factory getDelSubDep3Factory();

	public ICFBamSwingDelTopDepFactory getDelTopDepFactory();

	public ICFBamSwingDomainFactory getDomainFactory();

	public ICFBamSwingDomainBaseFactory getDomainBaseFactory();

	public ICFBamSwingDoubleColFactory getDoubleColFactory();

	public ICFBamSwingDoubleDefFactory getDoubleDefFactory();

	public ICFBamSwingDoubleTypeFactory getDoubleTypeFactory();

	public ICFBamSwingEnumColFactory getEnumColFactory();

	public ICFBamSwingEnumDefFactory getEnumDefFactory();

	public ICFBamSwingEnumTagFactory getEnumTagFactory();

	public ICFBamSwingEnumTypeFactory getEnumTypeFactory();

	public ICFBamSwingFloatColFactory getFloatColFactory();

	public ICFBamSwingFloatDefFactory getFloatDefFactory();

	public ICFBamSwingFloatTypeFactory getFloatTypeFactory();

	public ICFBamSwingHostNodeFactory getHostNodeFactory();

	public ICFBamSwingISOCountryFactory getISOCountryFactory();

	public ICFBamSwingISOCountryCurrencyFactory getISOCountryCurrencyFactory();

	public ICFBamSwingISOCountryLanguageFactory getISOCountryLanguageFactory();

	public ICFBamSwingISOCurrencyFactory getISOCurrencyFactory();

	public ICFBamSwingISOLanguageFactory getISOLanguageFactory();

	public ICFBamSwingISOTimezoneFactory getISOTimezoneFactory();

	public ICFBamSwingId16GenFactory getId16GenFactory();

	public ICFBamSwingId32GenFactory getId32GenFactory();

	public ICFBamSwingId64GenFactory getId64GenFactory();

	public ICFBamSwingIndexFactory getIndexFactory();

	public ICFBamSwingIndexColFactory getIndexColFactory();

	public ICFBamSwingInt16ColFactory getInt16ColFactory();

	public ICFBamSwingInt16DefFactory getInt16DefFactory();

	public ICFBamSwingInt16TypeFactory getInt16TypeFactory();

	public ICFBamSwingInt32ColFactory getInt32ColFactory();

	public ICFBamSwingInt32DefFactory getInt32DefFactory();

	public ICFBamSwingInt32TypeFactory getInt32TypeFactory();

	public ICFBamSwingInt64ColFactory getInt64ColFactory();

	public ICFBamSwingInt64DefFactory getInt64DefFactory();

	public ICFBamSwingInt64TypeFactory getInt64TypeFactory();

	public ICFBamSwingLicenseFactory getLicenseFactory();

	public ICFBamSwingLoaderBehaviourFactory getLoaderBehaviourFactory();

	public ICFBamSwingMajorVersionFactory getMajorVersionFactory();

	public ICFBamSwingMimeTypeFactory getMimeTypeFactory();

	public ICFBamSwingMinorVersionFactory getMinorVersionFactory();

	public ICFBamSwingNmTokenColFactory getNmTokenColFactory();

	public ICFBamSwingNmTokenDefFactory getNmTokenDefFactory();

	public ICFBamSwingNmTokenTypeFactory getNmTokenTypeFactory();

	public ICFBamSwingNmTokensColFactory getNmTokensColFactory();

	public ICFBamSwingNmTokensDefFactory getNmTokensDefFactory();

	public ICFBamSwingNmTokensTypeFactory getNmTokensTypeFactory();

	public ICFBamSwingNumberColFactory getNumberColFactory();

	public ICFBamSwingNumberDefFactory getNumberDefFactory();

	public ICFBamSwingNumberTypeFactory getNumberTypeFactory();

	public ICFBamSwingParamFactory getParamFactory();

	public ICFBamSwingPopDepFactory getPopDepFactory();

	public ICFBamSwingPopSubDep1Factory getPopSubDep1Factory();

	public ICFBamSwingPopSubDep2Factory getPopSubDep2Factory();

	public ICFBamSwingPopSubDep3Factory getPopSubDep3Factory();

	public ICFBamSwingPopTopDepFactory getPopTopDepFactory();

	public ICFBamSwingProjectBaseFactory getProjectBaseFactory();

	public ICFBamSwingRealProjectFactory getRealProjectFactory();

	public ICFBamSwingRelationFactory getRelationFactory();

	public ICFBamSwingRelationColFactory getRelationColFactory();

	public ICFBamSwingRelationTypeFactory getRelationTypeFactory();

	public ICFBamSwingSchemaDefFactory getSchemaDefFactory();

	public ICFBamSwingSchemaRefFactory getSchemaRefFactory();

	public ICFBamSwingScopeFactory getScopeFactory();

	public ICFBamSwingSecAppFactory getSecAppFactory();

	public ICFBamSwingSecDeviceFactory getSecDeviceFactory();

	public ICFBamSwingSecFormFactory getSecFormFactory();

	public ICFBamSwingSecGroupFactory getSecGroupFactory();

	public ICFBamSwingSecGroupFormFactory getSecGroupFormFactory();

	public ICFBamSwingSecGroupIncludeFactory getSecGroupIncludeFactory();

	public ICFBamSwingSecGroupMemberFactory getSecGroupMemberFactory();

	public ICFBamSwingSecSessionFactory getSecSessionFactory();

	public ICFBamSwingSecUserFactory getSecUserFactory();

	public ICFBamSwingSecurityScopeFactory getSecurityScopeFactory();

	public ICFBamSwingServerListFuncFactory getServerListFuncFactory();

	public ICFBamSwingServerMethodFactory getServerMethodFactory();

	public ICFBamSwingServerObjFuncFactory getServerObjFuncFactory();

	public ICFBamSwingServerProcFactory getServerProcFactory();

	public ICFBamSwingServiceFactory getServiceFactory();

	public ICFBamSwingServiceTypeFactory getServiceTypeFactory();

	public ICFBamSwingStringColFactory getStringColFactory();

	public ICFBamSwingStringDefFactory getStringDefFactory();

	public ICFBamSwingStringTypeFactory getStringTypeFactory();

	public ICFBamSwingSubProjectFactory getSubProjectFactory();

	public ICFBamSwingSysClusterFactory getSysClusterFactory();

	public ICFBamSwingTSecGroupFactory getTSecGroupFactory();

	public ICFBamSwingTSecGroupIncludeFactory getTSecGroupIncludeFactory();

	public ICFBamSwingTSecGroupMemberFactory getTSecGroupMemberFactory();

	public ICFBamSwingTZDateColFactory getTZDateColFactory();

	public ICFBamSwingTZDateDefFactory getTZDateDefFactory();

	public ICFBamSwingTZDateTypeFactory getTZDateTypeFactory();

	public ICFBamSwingTZTimeColFactory getTZTimeColFactory();

	public ICFBamSwingTZTimeDefFactory getTZTimeDefFactory();

	public ICFBamSwingTZTimeTypeFactory getTZTimeTypeFactory();

	public ICFBamSwingTZTimestampColFactory getTZTimestampColFactory();

	public ICFBamSwingTZTimestampDefFactory getTZTimestampDefFactory();

	public ICFBamSwingTZTimestampTypeFactory getTZTimestampTypeFactory();

	public ICFBamSwingTableFactory getTableFactory();

	public ICFBamSwingTableColFactory getTableColFactory();

	public ICFBamSwingTenantFactory getTenantFactory();

	public ICFBamSwingTextColFactory getTextColFactory();

	public ICFBamSwingTextDefFactory getTextDefFactory();

	public ICFBamSwingTextTypeFactory getTextTypeFactory();

	public ICFBamSwingTimeColFactory getTimeColFactory();

	public ICFBamSwingTimeDefFactory getTimeDefFactory();

	public ICFBamSwingTimeTypeFactory getTimeTypeFactory();

	public ICFBamSwingTimestampColFactory getTimestampColFactory();

	public ICFBamSwingTimestampDefFactory getTimestampDefFactory();

	public ICFBamSwingTimestampTypeFactory getTimestampTypeFactory();

	public ICFBamSwingTldFactory getTldFactory();

	public ICFBamSwingTokenColFactory getTokenColFactory();

	public ICFBamSwingTokenDefFactory getTokenDefFactory();

	public ICFBamSwingTokenTypeFactory getTokenTypeFactory();

	public ICFBamSwingTopDomainFactory getTopDomainFactory();

	public ICFBamSwingTopProjectFactory getTopProjectFactory();

	public ICFBamSwingUInt16ColFactory getUInt16ColFactory();

	public ICFBamSwingUInt16DefFactory getUInt16DefFactory();

	public ICFBamSwingUInt16TypeFactory getUInt16TypeFactory();

	public ICFBamSwingUInt32ColFactory getUInt32ColFactory();

	public ICFBamSwingUInt32DefFactory getUInt32DefFactory();

	public ICFBamSwingUInt32TypeFactory getUInt32TypeFactory();

	public ICFBamSwingUInt64ColFactory getUInt64ColFactory();

	public ICFBamSwingUInt64DefFactory getUInt64DefFactory();

	public ICFBamSwingUInt64TypeFactory getUInt64TypeFactory();

	public ICFBamSwingURLProtocolFactory getURLProtocolFactory();

	public ICFBamSwingUuidColFactory getUuidColFactory();

	public ICFBamSwingUuidDefFactory getUuidDefFactory();

	public ICFBamSwingUuidGenFactory getUuidGenFactory();

	public ICFBamSwingUuidTypeFactory getUuidTypeFactory();

	public ICFBamSwingValueFactory getValueFactory();

	public ICFBamSwingVersionFactory getVersionFactory();
}
