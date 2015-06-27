// Description: Java7 implementation of a Table history buffer object.

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
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;

public class CFBamTableHBuff
	extends CFBamScopeHBuff
	implements Comparable<Object>,
		Serializable
{
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long SCHEMADEFID_INIT_VALUE = 0L;
	public static final long DEFSCHEMATENANTID_INIT_VALUE = 0L;
	public static final long DEFSCHEMAID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final long PRIMARYINDEXTENANTID_INIT_VALUE = 0L;
	public static final long PRIMARYINDEXID_INIT_VALUE = 0L;
	public static final String TABLECLASSCODE_INIT_VALUE = new String( "" );
	public static final long LOOKUPINDEXTENANTID_INIT_VALUE = 0L;
	public static final long LOOKUPINDEXID_INIT_VALUE = 0L;
	public static final long ALTINDEXTENANTID_INIT_VALUE = 0L;
	public static final long ALTINDEXID_INIT_VALUE = 0L;
	public static final long QUALIFYINGTENANTID_INIT_VALUE = 0L;
	public static final long QUALIFYINGTABLEID_INIT_VALUE = 0L;
	public final static boolean POLYBASE_INIT_VALUE = false;
	public final static boolean ISINSTANTIABLE_INIT_VALUE = true;
	public final static boolean HASHISTORY_INIT_VALUE = false;
	public final static boolean HASAUDITCOLUMNS_INIT_VALUE = false;
	public static final short LOADERBEHAVIOURID_INIT_VALUE = (short)1;
	public static final short DATASCOPEID_INIT_VALUE = (short)0;
	public static final short SECURITYSCOPEID_INIT_VALUE = (short)2;
	public static final short VIEWACCESSSECURITYID_INIT_VALUE = (short)0;
	public static final short EDITACCESSSECURITYID_INIT_VALUE = (short)0;
	public static final short VIEWACCESSFREQUENCYID_INIT_VALUE = (short)0;
	public static final short EDITACCESSFREQUENCYID_INIT_VALUE = (short)0;
	public static final String JOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String JOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JEDITOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JEDITOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String JEDITOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JEDITOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JTABLEINTERFACE_INIT_VALUE = new String( "" );
	public static final String JTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JTABLEOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JTABLEOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JTABLEOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String JTABLEOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JDB2LUWTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JDB2LUWTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JDB2LUWTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JMSSQLTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JMSSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JMSSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JMYSQLTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JMYSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JMYSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JORACLETABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JORACLETABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JORACLETABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JPGSQLTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JPGSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JPGSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JSYBASETABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JSYBASETABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JSYBASETABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JRAMTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JRAMTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JRAMTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JSAXLOADERIMPORT_INIT_VALUE = new String( "" );
	public static final String JSAXLOADERSTARTELEMENT_INIT_VALUE = new String( "" );
	public static final String JSAXLOADERENDELEMENT_INIT_VALUE = new String( "" );
	public static final String JXMSGTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGTABLEFORMATTERS_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGCLIENTTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTTABLEBODY_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNTABLEBODY_INIT_VALUE = new String( "" );
	public static final String JXMSGCLIENTTABLEBODY_INIT_VALUE = new String( "" );
	public final static boolean DEFAULTVISIBILITY_INIT_VALUE = true;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long SCHEMADEFID_MIN_VALUE = 0L;
	public static final long DEFSCHEMATENANTID_MIN_VALUE = 0L;
	public static final long DEFSCHEMAID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long PRIMARYINDEXTENANTID_MIN_VALUE = 0L;
	public static final long PRIMARYINDEXID_MIN_VALUE = 0L;
	public static final long LOOKUPINDEXTENANTID_MIN_VALUE = 0L;
	public static final long LOOKUPINDEXID_MIN_VALUE = 0L;
	public static final long ALTINDEXTENANTID_MIN_VALUE = 0L;
	public static final long ALTINDEXID_MIN_VALUE = 0L;
	public static final long QUALIFYINGTENANTID_MIN_VALUE = 0L;
	public static final long QUALIFYINGTABLEID_MIN_VALUE = 0L;
	public static final short LOADERBEHAVIOURID_MIN_VALUE = (short)1;
	public static final short DATASCOPEID_MIN_VALUE = (short)0;
	public static final short SECURITYSCOPEID_MIN_VALUE = (short)1;
	public static final short VIEWACCESSSECURITYID_MIN_VALUE = (short)0;
	public static final short EDITACCESSSECURITYID_MIN_VALUE = (short)0;
	public static final short VIEWACCESSFREQUENCYID_MIN_VALUE = (short)0;
	public static final short EDITACCESSFREQUENCYID_MIN_VALUE = (short)0;

	protected long requiredSchemaDefId;
	protected Long optionalDefSchemaTenantId;
	protected Long optionalDefSchemaId;
	protected String requiredName;
	protected String optionalDbName;
	protected String optionalShortName;
	protected String optionalLabel;
	protected String optionalShortDescription;
	protected String optionalDescription;
	protected Long optionalPrimaryIndexTenantId;
	protected Long optionalPrimaryIndexId;
	protected String requiredTableClassCode;
	protected Long optionalLookupIndexTenantId;
	protected Long optionalLookupIndexId;
	protected Long optionalAltIndexTenantId;
	protected Long optionalAltIndexId;
	protected Long optionalQualifyingTenantId;
	protected Long optionalQualifyingTableId;
	protected boolean requiredPolyBase;
	protected boolean requiredIsInstantiable;
	protected boolean requiredHasHistory;
	protected boolean requiredHasAuditColumns;
	protected short requiredLoaderBehaviourId;
	protected Short optionalDataScopeId;
	protected short requiredSecurityScopeId;
	protected Short optionalViewAccessSecurityId;
	protected Short optionalEditAccessSecurityId;
	protected Short optionalViewAccessFrequencyId;
	protected Short optionalEditAccessFrequencyId;
	protected String optionalJObjMembers;
	protected String optionalJObjInterface;
	protected String optionalJObjImport;
	protected String optionalJObjImplementation;
	protected String optionalJEditObjMembers;
	protected String optionalJEditObjInterface;
	protected String optionalJEditObjImport;
	protected String optionalJEditObjImplementation;
	protected String optionalJTableImport;
	protected String optionalJTableMembers;
	protected String optionalJTableInterface;
	protected String optionalJTableImplementation;
	protected String optionalJTableObjImport;
	protected String optionalJTableObjMembers;
	protected String optionalJTableObjInterface;
	protected String optionalJTableObjImplementation;
	protected String optionalJDb2LUWTableImport;
	protected String optionalJDb2LUWTableMembers;
	protected String optionalJDb2LUWTableImplementation;
	protected String optionalJMSSqlTableImport;
	protected String optionalJMSSqlTableMembers;
	protected String optionalJMSSqlTableImplementation;
	protected String optionalJMySqlTableImport;
	protected String optionalJMySqlTableMembers;
	protected String optionalJMySqlTableImplementation;
	protected String optionalJOracleTableImport;
	protected String optionalJOracleTableMembers;
	protected String optionalJOracleTableImplementation;
	protected String optionalJPgSqlTableImport;
	protected String optionalJPgSqlTableMembers;
	protected String optionalJPgSqlTableImplementation;
	protected String optionalJSybaseTableImport;
	protected String optionalJSybaseTableMembers;
	protected String optionalJSybaseTableImplementation;
	protected String optionalJRamTableImport;
	protected String optionalJRamTableMembers;
	protected String optionalJRamTableImplementation;
	protected String optionalJSaxLoaderImport;
	protected String optionalJSaxLoaderStartElement;
	protected String optionalJSaxLoaderEndElement;
	protected String optionalJXMsgTableImport;
	protected String optionalJXMsgTableFormatters;
	protected String optionalJXMsgRqstTableImport;
	protected String optionalJXMsgRspnTableImport;
	protected String optionalJXMsgClientTableImport;
	protected String optionalJXMsgRqstTableBody;
	protected String optionalJXMsgRspnTableBody;
	protected String optionalJXMsgClientTableBody;
	protected boolean requiredDefaultVisibility;
	public CFBamTableHBuff() {
		super();
		requiredSchemaDefId = CFBamTableBuff.SCHEMADEFID_INIT_VALUE;
		optionalDefSchemaTenantId = null;
		optionalDefSchemaId = null;
		requiredName = new String( CFBamTableBuff.NAME_INIT_VALUE );
		optionalDbName = null;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		optionalPrimaryIndexTenantId = null;
		optionalPrimaryIndexId = null;
		requiredTableClassCode = new String( CFBamTableBuff.TABLECLASSCODE_INIT_VALUE );
		optionalLookupIndexTenantId = null;
		optionalLookupIndexId = null;
		optionalAltIndexTenantId = null;
		optionalAltIndexId = null;
		optionalQualifyingTenantId = null;
		optionalQualifyingTableId = null;
		requiredPolyBase = CFBamTableBuff.POLYBASE_INIT_VALUE;
		requiredIsInstantiable = CFBamTableBuff.ISINSTANTIABLE_INIT_VALUE;
		requiredHasHistory = CFBamTableBuff.HASHISTORY_INIT_VALUE;
		requiredHasAuditColumns = CFBamTableBuff.HASAUDITCOLUMNS_INIT_VALUE;
		requiredLoaderBehaviourId = CFBamTableBuff.LOADERBEHAVIOURID_INIT_VALUE;
		optionalDataScopeId = null;
		requiredSecurityScopeId = CFBamTableBuff.SECURITYSCOPEID_INIT_VALUE;
		optionalViewAccessSecurityId = null;
		optionalEditAccessSecurityId = null;
		optionalViewAccessFrequencyId = null;
		optionalEditAccessFrequencyId = null;
		optionalJObjMembers = null;
		optionalJObjInterface = null;
		optionalJObjImport = null;
		optionalJObjImplementation = null;
		optionalJEditObjMembers = null;
		optionalJEditObjInterface = null;
		optionalJEditObjImport = null;
		optionalJEditObjImplementation = null;
		optionalJTableImport = null;
		optionalJTableMembers = null;
		optionalJTableInterface = null;
		optionalJTableImplementation = null;
		optionalJTableObjImport = null;
		optionalJTableObjMembers = null;
		optionalJTableObjInterface = null;
		optionalJTableObjImplementation = null;
		optionalJDb2LUWTableImport = null;
		optionalJDb2LUWTableMembers = null;
		optionalJDb2LUWTableImplementation = null;
		optionalJMSSqlTableImport = null;
		optionalJMSSqlTableMembers = null;
		optionalJMSSqlTableImplementation = null;
		optionalJMySqlTableImport = null;
		optionalJMySqlTableMembers = null;
		optionalJMySqlTableImplementation = null;
		optionalJOracleTableImport = null;
		optionalJOracleTableMembers = null;
		optionalJOracleTableImplementation = null;
		optionalJPgSqlTableImport = null;
		optionalJPgSqlTableMembers = null;
		optionalJPgSqlTableImplementation = null;
		optionalJSybaseTableImport = null;
		optionalJSybaseTableMembers = null;
		optionalJSybaseTableImplementation = null;
		optionalJRamTableImport = null;
		optionalJRamTableMembers = null;
		optionalJRamTableImplementation = null;
		optionalJSaxLoaderImport = null;
		optionalJSaxLoaderStartElement = null;
		optionalJSaxLoaderEndElement = null;
		optionalJXMsgTableImport = null;
		optionalJXMsgTableFormatters = null;
		optionalJXMsgRqstTableImport = null;
		optionalJXMsgRspnTableImport = null;
		optionalJXMsgClientTableImport = null;
		optionalJXMsgRqstTableBody = null;
		optionalJXMsgRspnTableBody = null;
		optionalJXMsgClientTableBody = null;
		requiredDefaultVisibility = CFBamTableBuff.DEFAULTVISIBILITY_INIT_VALUE;
	}

	public String getClassCode() {
		return( CFBamTableBuff.CLASS_CODE );
	}

	public long getRequiredSchemaDefId() {
		return( requiredSchemaDefId );
	}

	public void setRequiredSchemaDefId( long value ) {
		if( value < CFBamTableBuff.SCHEMADEFID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredSchemaDefId",
				1,
				"value",
				value,
				CFBamTableBuff.SCHEMADEFID_MIN_VALUE );
		}
		requiredSchemaDefId = value;
	}

	public Long getOptionalDefSchemaTenantId() {
		return( optionalDefSchemaTenantId );
	}

	public void setOptionalDefSchemaTenantId( Long value ) {
		if( value == null ) {
			optionalDefSchemaTenantId = null;
		}
		else if( value < CFBamTableBuff.DEFSCHEMATENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDefSchemaTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.DEFSCHEMATENANTID_MIN_VALUE );
		}
		else {
			optionalDefSchemaTenantId = value;
		}
	}

	public Long getOptionalDefSchemaId() {
		return( optionalDefSchemaId );
	}

	public void setOptionalDefSchemaId( Long value ) {
		if( value == null ) {
			optionalDefSchemaId = null;
		}
		else if( value < CFBamTableBuff.DEFSCHEMAID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDefSchemaId",
				1,
				"value",
				value,
				CFBamTableBuff.DEFSCHEMAID_MIN_VALUE );
		}
		else {
			optionalDefSchemaId = value;
		}
	}

	public String getRequiredName() {
		return( requiredName );
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		if( value.length() > 192 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredName = value;
	}

	public String getOptionalDbName() {
		return( optionalDbName );
	}

	public void setOptionalDbName( String value ) {
		if( value == null ) {
			optionalDbName = null;
		}
		else if( value.length() > 32 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalDbName",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		else {
			optionalDbName = value;
		}
	}

	public String getOptionalShortName() {
		return( optionalShortName );
	}

	public void setOptionalShortName( String value ) {
		if( value == null ) {
			optionalShortName = null;
		}
		else if( value.length() > 16 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalShortName",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		else {
			optionalShortName = value;
		}
	}

	public String getOptionalLabel() {
		return( optionalLabel );
	}

	public void setOptionalLabel( String value ) {
		if( value == null ) {
			optionalLabel = null;
		}
		else if( value.length() > 64 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalLabel",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		else {
			optionalLabel = value;
		}
	}

	public String getOptionalShortDescription() {
		return( optionalShortDescription );
	}

	public void setOptionalShortDescription( String value ) {
		if( value == null ) {
			optionalShortDescription = null;
		}
		else if( value.length() > 50 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				50 );
		}
		else {
			optionalShortDescription = value;
		}
	}

	public String getOptionalDescription() {
		return( optionalDescription );
	}

	public void setOptionalDescription( String value ) {
		if( value == null ) {
			optionalDescription = null;
		}
		else if( value.length() > 100 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				100 );
		}
		else {
			optionalDescription = value;
		}
	}

	public Long getOptionalPrimaryIndexTenantId() {
		return( optionalPrimaryIndexTenantId );
	}

	public void setOptionalPrimaryIndexTenantId( Long value ) {
		if( value == null ) {
			optionalPrimaryIndexTenantId = null;
		}
		else if( value < CFBamTableBuff.PRIMARYINDEXTENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalPrimaryIndexTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.PRIMARYINDEXTENANTID_MIN_VALUE );
		}
		else {
			optionalPrimaryIndexTenantId = value;
		}
	}

	public Long getOptionalPrimaryIndexId() {
		return( optionalPrimaryIndexId );
	}

	public void setOptionalPrimaryIndexId( Long value ) {
		if( value == null ) {
			optionalPrimaryIndexId = null;
		}
		else if( value < CFBamTableBuff.PRIMARYINDEXID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalPrimaryIndexId",
				1,
				"value",
				value,
				CFBamTableBuff.PRIMARYINDEXID_MIN_VALUE );
		}
		else {
			optionalPrimaryIndexId = value;
		}
	}

	public String getRequiredTableClassCode() {
		return( requiredTableClassCode );
	}

	public void setRequiredTableClassCode( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredTableClassCode",
				1,
				"value" );
		}
		if( value.length() > 4 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredTableClassCode",
				1,
				"value.length()",
				value.length(),
				4 );
		}
		requiredTableClassCode = value;
	}

	public Long getOptionalLookupIndexTenantId() {
		return( optionalLookupIndexTenantId );
	}

	public void setOptionalLookupIndexTenantId( Long value ) {
		if( value == null ) {
			optionalLookupIndexTenantId = null;
		}
		else if( value < CFBamTableBuff.LOOKUPINDEXTENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalLookupIndexTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.LOOKUPINDEXTENANTID_MIN_VALUE );
		}
		else {
			optionalLookupIndexTenantId = value;
		}
	}

	public Long getOptionalLookupIndexId() {
		return( optionalLookupIndexId );
	}

	public void setOptionalLookupIndexId( Long value ) {
		if( value == null ) {
			optionalLookupIndexId = null;
		}
		else if( value < CFBamTableBuff.LOOKUPINDEXID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalLookupIndexId",
				1,
				"value",
				value,
				CFBamTableBuff.LOOKUPINDEXID_MIN_VALUE );
		}
		else {
			optionalLookupIndexId = value;
		}
	}

	public Long getOptionalAltIndexTenantId() {
		return( optionalAltIndexTenantId );
	}

	public void setOptionalAltIndexTenantId( Long value ) {
		if( value == null ) {
			optionalAltIndexTenantId = null;
		}
		else if( value < CFBamTableBuff.ALTINDEXTENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalAltIndexTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.ALTINDEXTENANTID_MIN_VALUE );
		}
		else {
			optionalAltIndexTenantId = value;
		}
	}

	public Long getOptionalAltIndexId() {
		return( optionalAltIndexId );
	}

	public void setOptionalAltIndexId( Long value ) {
		if( value == null ) {
			optionalAltIndexId = null;
		}
		else if( value < CFBamTableBuff.ALTINDEXID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalAltIndexId",
				1,
				"value",
				value,
				CFBamTableBuff.ALTINDEXID_MIN_VALUE );
		}
		else {
			optionalAltIndexId = value;
		}
	}

	public Long getOptionalQualifyingTenantId() {
		return( optionalQualifyingTenantId );
	}

	public void setOptionalQualifyingTenantId( Long value ) {
		if( value == null ) {
			optionalQualifyingTenantId = null;
		}
		else if( value < CFBamTableBuff.QUALIFYINGTENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalQualifyingTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.QUALIFYINGTENANTID_MIN_VALUE );
		}
		else {
			optionalQualifyingTenantId = value;
		}
	}

	public Long getOptionalQualifyingTableId() {
		return( optionalQualifyingTableId );
	}

	public void setOptionalQualifyingTableId( Long value ) {
		if( value == null ) {
			optionalQualifyingTableId = null;
		}
		else if( value < CFBamTableBuff.QUALIFYINGTABLEID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalQualifyingTableId",
				1,
				"value",
				value,
				CFBamTableBuff.QUALIFYINGTABLEID_MIN_VALUE );
		}
		else {
			optionalQualifyingTableId = value;
		}
	}

	public boolean getRequiredPolyBase() {
		return( requiredPolyBase );
	}

	public void setRequiredPolyBase( boolean value ) {
		requiredPolyBase = value;
	}

	public boolean getRequiredIsInstantiable() {
		return( requiredIsInstantiable );
	}

	public void setRequiredIsInstantiable( boolean value ) {
		requiredIsInstantiable = value;
	}

	public boolean getRequiredHasHistory() {
		return( requiredHasHistory );
	}

	public void setRequiredHasHistory( boolean value ) {
		requiredHasHistory = value;
	}

	public boolean getRequiredHasAuditColumns() {
		return( requiredHasAuditColumns );
	}

	public void setRequiredHasAuditColumns( boolean value ) {
		requiredHasAuditColumns = value;
	}

	public short getRequiredLoaderBehaviourId() {
		return( requiredLoaderBehaviourId );
	}

	public void setRequiredLoaderBehaviourId( short value ) {
		if( value < CFBamTableBuff.LOADERBEHAVIOURID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredLoaderBehaviourId",
				1,
				"value",
				value,
				CFBamTableBuff.LOADERBEHAVIOURID_MIN_VALUE );
		}
		requiredLoaderBehaviourId = value;
	}

	public Short getOptionalDataScopeId() {
		return( optionalDataScopeId );
	}

	public void setOptionalDataScopeId( Short value ) {
		if( value == null ) {
			optionalDataScopeId = null;
		}
		else if( value < CFBamTableBuff.DATASCOPEID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDataScopeId",
				1,
				"value",
				value,
				CFBamTableBuff.DATASCOPEID_MIN_VALUE );
		}
		else {
			optionalDataScopeId = value;
		}
	}

	public short getRequiredSecurityScopeId() {
		return( requiredSecurityScopeId );
	}

	public void setRequiredSecurityScopeId( short value ) {
		if( value < CFBamTableBuff.SECURITYSCOPEID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredSecurityScopeId",
				1,
				"value",
				value,
				CFBamTableBuff.SECURITYSCOPEID_MIN_VALUE );
		}
		requiredSecurityScopeId = value;
	}

	public Short getOptionalViewAccessSecurityId() {
		return( optionalViewAccessSecurityId );
	}

	public void setOptionalViewAccessSecurityId( Short value ) {
		if( value == null ) {
			optionalViewAccessSecurityId = null;
		}
		else if( value < CFBamTableBuff.VIEWACCESSSECURITYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalViewAccessSecurityId",
				1,
				"value",
				value,
				CFBamTableBuff.VIEWACCESSSECURITYID_MIN_VALUE );
		}
		else {
			optionalViewAccessSecurityId = value;
		}
	}

	public Short getOptionalEditAccessSecurityId() {
		return( optionalEditAccessSecurityId );
	}

	public void setOptionalEditAccessSecurityId( Short value ) {
		if( value == null ) {
			optionalEditAccessSecurityId = null;
		}
		else if( value < CFBamTableBuff.EDITACCESSSECURITYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalEditAccessSecurityId",
				1,
				"value",
				value,
				CFBamTableBuff.EDITACCESSSECURITYID_MIN_VALUE );
		}
		else {
			optionalEditAccessSecurityId = value;
		}
	}

	public Short getOptionalViewAccessFrequencyId() {
		return( optionalViewAccessFrequencyId );
	}

	public void setOptionalViewAccessFrequencyId( Short value ) {
		if( value == null ) {
			optionalViewAccessFrequencyId = null;
		}
		else if( value < CFBamTableBuff.VIEWACCESSFREQUENCYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalViewAccessFrequencyId",
				1,
				"value",
				value,
				CFBamTableBuff.VIEWACCESSFREQUENCYID_MIN_VALUE );
		}
		else {
			optionalViewAccessFrequencyId = value;
		}
	}

	public Short getOptionalEditAccessFrequencyId() {
		return( optionalEditAccessFrequencyId );
	}

	public void setOptionalEditAccessFrequencyId( Short value ) {
		if( value == null ) {
			optionalEditAccessFrequencyId = null;
		}
		else if( value < CFBamTableBuff.EDITACCESSFREQUENCYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalEditAccessFrequencyId",
				1,
				"value",
				value,
				CFBamTableBuff.EDITACCESSFREQUENCYID_MIN_VALUE );
		}
		else {
			optionalEditAccessFrequencyId = value;
		}
	}

	public String getOptionalJObjMembers() {
		return( optionalJObjMembers );
	}

	public void setOptionalJObjMembers( String value ) {
		if( value == null ) {
			optionalJObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJObjMembers = value;
		}
	}

	public String getOptionalJObjInterface() {
		return( optionalJObjInterface );
	}

	public void setOptionalJObjInterface( String value ) {
		if( value == null ) {
			optionalJObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJObjInterface = value;
		}
	}

	public String getOptionalJObjImport() {
		return( optionalJObjImport );
	}

	public void setOptionalJObjImport( String value ) {
		if( value == null ) {
			optionalJObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJObjImport = value;
		}
	}

	public String getOptionalJObjImplementation() {
		return( optionalJObjImplementation );
	}

	public void setOptionalJObjImplementation( String value ) {
		if( value == null ) {
			optionalJObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJObjImplementation = value;
		}
	}

	public String getOptionalJEditObjMembers() {
		return( optionalJEditObjMembers );
	}

	public void setOptionalJEditObjMembers( String value ) {
		if( value == null ) {
			optionalJEditObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJEditObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJEditObjMembers = value;
		}
	}

	public String getOptionalJEditObjInterface() {
		return( optionalJEditObjInterface );
	}

	public void setOptionalJEditObjInterface( String value ) {
		if( value == null ) {
			optionalJEditObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJEditObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJEditObjInterface = value;
		}
	}

	public String getOptionalJEditObjImport() {
		return( optionalJEditObjImport );
	}

	public void setOptionalJEditObjImport( String value ) {
		if( value == null ) {
			optionalJEditObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJEditObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJEditObjImport = value;
		}
	}

	public String getOptionalJEditObjImplementation() {
		return( optionalJEditObjImplementation );
	}

	public void setOptionalJEditObjImplementation( String value ) {
		if( value == null ) {
			optionalJEditObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJEditObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJEditObjImplementation = value;
		}
	}

	public String getOptionalJTableImport() {
		return( optionalJTableImport );
	}

	public void setOptionalJTableImport( String value ) {
		if( value == null ) {
			optionalJTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableImport = value;
		}
	}

	public String getOptionalJTableMembers() {
		return( optionalJTableMembers );
	}

	public void setOptionalJTableMembers( String value ) {
		if( value == null ) {
			optionalJTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableMembers = value;
		}
	}

	public String getOptionalJTableInterface() {
		return( optionalJTableInterface );
	}

	public void setOptionalJTableInterface( String value ) {
		if( value == null ) {
			optionalJTableInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJTableInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableInterface = value;
		}
	}

	public String getOptionalJTableImplementation() {
		return( optionalJTableImplementation );
	}

	public void setOptionalJTableImplementation( String value ) {
		if( value == null ) {
			optionalJTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableImplementation = value;
		}
	}

	public String getOptionalJTableObjImport() {
		return( optionalJTableObjImport );
	}

	public void setOptionalJTableObjImport( String value ) {
		if( value == null ) {
			optionalJTableObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJTableObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableObjImport = value;
		}
	}

	public String getOptionalJTableObjMembers() {
		return( optionalJTableObjMembers );
	}

	public void setOptionalJTableObjMembers( String value ) {
		if( value == null ) {
			optionalJTableObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJTableObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableObjMembers = value;
		}
	}

	public String getOptionalJTableObjInterface() {
		return( optionalJTableObjInterface );
	}

	public void setOptionalJTableObjInterface( String value ) {
		if( value == null ) {
			optionalJTableObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJTableObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableObjInterface = value;
		}
	}

	public String getOptionalJTableObjImplementation() {
		return( optionalJTableObjImplementation );
	}

	public void setOptionalJTableObjImplementation( String value ) {
		if( value == null ) {
			optionalJTableObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJTableObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableObjImplementation = value;
		}
	}

	public String getOptionalJDb2LUWTableImport() {
		return( optionalJDb2LUWTableImport );
	}

	public void setOptionalJDb2LUWTableImport( String value ) {
		if( value == null ) {
			optionalJDb2LUWTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWTableImport = value;
		}
	}

	public String getOptionalJDb2LUWTableMembers() {
		return( optionalJDb2LUWTableMembers );
	}

	public void setOptionalJDb2LUWTableMembers( String value ) {
		if( value == null ) {
			optionalJDb2LUWTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWTableMembers = value;
		}
	}

	public String getOptionalJDb2LUWTableImplementation() {
		return( optionalJDb2LUWTableImplementation );
	}

	public void setOptionalJDb2LUWTableImplementation( String value ) {
		if( value == null ) {
			optionalJDb2LUWTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWTableImplementation = value;
		}
	}

	public String getOptionalJMSSqlTableImport() {
		return( optionalJMSSqlTableImport );
	}

	public void setOptionalJMSSqlTableImport( String value ) {
		if( value == null ) {
			optionalJMSSqlTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMSSqlTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlTableImport = value;
		}
	}

	public String getOptionalJMSSqlTableMembers() {
		return( optionalJMSSqlTableMembers );
	}

	public void setOptionalJMSSqlTableMembers( String value ) {
		if( value == null ) {
			optionalJMSSqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMSSqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlTableMembers = value;
		}
	}

	public String getOptionalJMSSqlTableImplementation() {
		return( optionalJMSSqlTableImplementation );
	}

	public void setOptionalJMSSqlTableImplementation( String value ) {
		if( value == null ) {
			optionalJMSSqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMSSqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlTableImplementation = value;
		}
	}

	public String getOptionalJMySqlTableImport() {
		return( optionalJMySqlTableImport );
	}

	public void setOptionalJMySqlTableImport( String value ) {
		if( value == null ) {
			optionalJMySqlTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMySqlTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlTableImport = value;
		}
	}

	public String getOptionalJMySqlTableMembers() {
		return( optionalJMySqlTableMembers );
	}

	public void setOptionalJMySqlTableMembers( String value ) {
		if( value == null ) {
			optionalJMySqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMySqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlTableMembers = value;
		}
	}

	public String getOptionalJMySqlTableImplementation() {
		return( optionalJMySqlTableImplementation );
	}

	public void setOptionalJMySqlTableImplementation( String value ) {
		if( value == null ) {
			optionalJMySqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMySqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlTableImplementation = value;
		}
	}

	public String getOptionalJOracleTableImport() {
		return( optionalJOracleTableImport );
	}

	public void setOptionalJOracleTableImport( String value ) {
		if( value == null ) {
			optionalJOracleTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJOracleTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleTableImport = value;
		}
	}

	public String getOptionalJOracleTableMembers() {
		return( optionalJOracleTableMembers );
	}

	public void setOptionalJOracleTableMembers( String value ) {
		if( value == null ) {
			optionalJOracleTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJOracleTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleTableMembers = value;
		}
	}

	public String getOptionalJOracleTableImplementation() {
		return( optionalJOracleTableImplementation );
	}

	public void setOptionalJOracleTableImplementation( String value ) {
		if( value == null ) {
			optionalJOracleTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJOracleTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleTableImplementation = value;
		}
	}

	public String getOptionalJPgSqlTableImport() {
		return( optionalJPgSqlTableImport );
	}

	public void setOptionalJPgSqlTableImport( String value ) {
		if( value == null ) {
			optionalJPgSqlTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJPgSqlTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlTableImport = value;
		}
	}

	public String getOptionalJPgSqlTableMembers() {
		return( optionalJPgSqlTableMembers );
	}

	public void setOptionalJPgSqlTableMembers( String value ) {
		if( value == null ) {
			optionalJPgSqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJPgSqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlTableMembers = value;
		}
	}

	public String getOptionalJPgSqlTableImplementation() {
		return( optionalJPgSqlTableImplementation );
	}

	public void setOptionalJPgSqlTableImplementation( String value ) {
		if( value == null ) {
			optionalJPgSqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJPgSqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlTableImplementation = value;
		}
	}

	public String getOptionalJSybaseTableImport() {
		return( optionalJSybaseTableImport );
	}

	public void setOptionalJSybaseTableImport( String value ) {
		if( value == null ) {
			optionalJSybaseTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSybaseTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSybaseTableImport = value;
		}
	}

	public String getOptionalJSybaseTableMembers() {
		return( optionalJSybaseTableMembers );
	}

	public void setOptionalJSybaseTableMembers( String value ) {
		if( value == null ) {
			optionalJSybaseTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSybaseTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSybaseTableMembers = value;
		}
	}

	public String getOptionalJSybaseTableImplementation() {
		return( optionalJSybaseTableImplementation );
	}

	public void setOptionalJSybaseTableImplementation( String value ) {
		if( value == null ) {
			optionalJSybaseTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSybaseTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSybaseTableImplementation = value;
		}
	}

	public String getOptionalJRamTableImport() {
		return( optionalJRamTableImport );
	}

	public void setOptionalJRamTableImport( String value ) {
		if( value == null ) {
			optionalJRamTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJRamTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamTableImport = value;
		}
	}

	public String getOptionalJRamTableMembers() {
		return( optionalJRamTableMembers );
	}

	public void setOptionalJRamTableMembers( String value ) {
		if( value == null ) {
			optionalJRamTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJRamTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamTableMembers = value;
		}
	}

	public String getOptionalJRamTableImplementation() {
		return( optionalJRamTableImplementation );
	}

	public void setOptionalJRamTableImplementation( String value ) {
		if( value == null ) {
			optionalJRamTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJRamTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamTableImplementation = value;
		}
	}

	public String getOptionalJSaxLoaderImport() {
		return( optionalJSaxLoaderImport );
	}

	public void setOptionalJSaxLoaderImport( String value ) {
		if( value == null ) {
			optionalJSaxLoaderImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSaxLoaderImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSaxLoaderImport = value;
		}
	}

	public String getOptionalJSaxLoaderStartElement() {
		return( optionalJSaxLoaderStartElement );
	}

	public void setOptionalJSaxLoaderStartElement( String value ) {
		if( value == null ) {
			optionalJSaxLoaderStartElement = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSaxLoaderStartElement",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSaxLoaderStartElement = value;
		}
	}

	public String getOptionalJSaxLoaderEndElement() {
		return( optionalJSaxLoaderEndElement );
	}

	public void setOptionalJSaxLoaderEndElement( String value ) {
		if( value == null ) {
			optionalJSaxLoaderEndElement = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSaxLoaderEndElement",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSaxLoaderEndElement = value;
		}
	}

	public String getOptionalJXMsgTableImport() {
		return( optionalJXMsgTableImport );
	}

	public void setOptionalJXMsgTableImport( String value ) {
		if( value == null ) {
			optionalJXMsgTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgTableImport = value;
		}
	}

	public String getOptionalJXMsgTableFormatters() {
		return( optionalJXMsgTableFormatters );
	}

	public void setOptionalJXMsgTableFormatters( String value ) {
		if( value == null ) {
			optionalJXMsgTableFormatters = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgTableFormatters",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgTableFormatters = value;
		}
	}

	public String getOptionalJXMsgRqstTableImport() {
		return( optionalJXMsgRqstTableImport );
	}

	public void setOptionalJXMsgRqstTableImport( String value ) {
		if( value == null ) {
			optionalJXMsgRqstTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstTableImport = value;
		}
	}

	public String getOptionalJXMsgRspnTableImport() {
		return( optionalJXMsgRspnTableImport );
	}

	public void setOptionalJXMsgRspnTableImport( String value ) {
		if( value == null ) {
			optionalJXMsgRspnTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnTableImport = value;
		}
	}

	public String getOptionalJXMsgClientTableImport() {
		return( optionalJXMsgClientTableImport );
	}

	public void setOptionalJXMsgClientTableImport( String value ) {
		if( value == null ) {
			optionalJXMsgClientTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgClientTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgClientTableImport = value;
		}
	}

	public String getOptionalJXMsgRqstTableBody() {
		return( optionalJXMsgRqstTableBody );
	}

	public void setOptionalJXMsgRqstTableBody( String value ) {
		if( value == null ) {
			optionalJXMsgRqstTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstTableBody = value;
		}
	}

	public String getOptionalJXMsgRspnTableBody() {
		return( optionalJXMsgRspnTableBody );
	}

	public void setOptionalJXMsgRspnTableBody( String value ) {
		if( value == null ) {
			optionalJXMsgRspnTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnTableBody = value;
		}
	}

	public String getOptionalJXMsgClientTableBody() {
		return( optionalJXMsgClientTableBody );
	}

	public void setOptionalJXMsgClientTableBody( String value ) {
		if( value == null ) {
			optionalJXMsgClientTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgClientTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgClientTableBody = value;
		}
	}

	public boolean getRequiredDefaultVisibility() {
		return( requiredDefaultVisibility );
	}

	public void setRequiredDefaultVisibility( boolean value ) {
		requiredDefaultVisibility = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamTableHBuff ) {
			CFBamTableHBuff rhs = (CFBamTableHBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaDefId() != rhs.getRequiredSchemaDefId() ) {
				return( false );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalPrimaryIndexTenantId() != null ) {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					if( ! getOptionalPrimaryIndexTenantId().equals( rhs.getOptionalPrimaryIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
				return( false );
			}
			if( getOptionalLookupIndexTenantId() != null ) {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					if( ! getOptionalLookupIndexTenantId().equals( rhs.getOptionalLookupIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexTenantId() != null ) {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					if( ! getOptionalAltIndexTenantId().equals( rhs.getOptionalAltIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTenantId() != null ) {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					if( ! getOptionalQualifyingTenantId().equals( rhs.getOptionalQualifyingTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredPolyBase() != rhs.getRequiredPolyBase() ) {
				return( false );
			}
			if( getRequiredIsInstantiable() != rhs.getRequiredIsInstantiable() ) {
				return( false );
			}
			if( getRequiredHasHistory() != rhs.getRequiredHasHistory() ) {
				return( false );
			}
			if( getRequiredHasAuditColumns() != rhs.getRequiredHasAuditColumns() ) {
				return( false );
			}
			if( getRequiredLoaderBehaviourId() != rhs.getRequiredLoaderBehaviourId() ) {
				return( false );
			}
			if( getOptionalDataScopeId() != null ) {
				if( rhs.getOptionalDataScopeId() != null ) {
					if( ! getOptionalDataScopeId().equals( rhs.getOptionalDataScopeId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDataScopeId() != null ) {
					return( false );
				}
			}
			if( getRequiredSecurityScopeId() != rhs.getRequiredSecurityScopeId() ) {
				return( false );
			}
			if( getOptionalViewAccessSecurityId() != null ) {
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					if( ! getOptionalViewAccessSecurityId().equals( rhs.getOptionalViewAccessSecurityId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					return( false );
				}
			}
			if( getOptionalEditAccessSecurityId() != null ) {
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					if( ! getOptionalEditAccessSecurityId().equals( rhs.getOptionalEditAccessSecurityId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					return( false );
				}
			}
			if( getOptionalViewAccessFrequencyId() != null ) {
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					if( ! getOptionalViewAccessFrequencyId().equals( rhs.getOptionalViewAccessFrequencyId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					return( false );
				}
			}
			if( getOptionalEditAccessFrequencyId() != null ) {
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					if( ! getOptionalEditAccessFrequencyId().equals( rhs.getOptionalEditAccessFrequencyId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjMembers() != null ) {
				if( rhs.getOptionalJObjMembers() != null ) {
					if( ! getOptionalJObjMembers().equals( rhs.getOptionalJObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjInterface() != null ) {
				if( rhs.getOptionalJObjInterface() != null ) {
					if( ! getOptionalJObjInterface().equals( rhs.getOptionalJObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjImport() != null ) {
				if( rhs.getOptionalJObjImport() != null ) {
					if( ! getOptionalJObjImport().equals( rhs.getOptionalJObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjImplementation() != null ) {
				if( rhs.getOptionalJObjImplementation() != null ) {
					if( ! getOptionalJObjImplementation().equals( rhs.getOptionalJObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjMembers() != null ) {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					if( ! getOptionalJEditObjMembers().equals( rhs.getOptionalJEditObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjInterface() != null ) {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					if( ! getOptionalJEditObjInterface().equals( rhs.getOptionalJEditObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjImport() != null ) {
				if( rhs.getOptionalJEditObjImport() != null ) {
					if( ! getOptionalJEditObjImport().equals( rhs.getOptionalJEditObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjImplementation() != null ) {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					if( ! getOptionalJEditObjImplementation().equals( rhs.getOptionalJEditObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableImport() != null ) {
				if( rhs.getOptionalJTableImport() != null ) {
					if( ! getOptionalJTableImport().equals( rhs.getOptionalJTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableMembers() != null ) {
				if( rhs.getOptionalJTableMembers() != null ) {
					if( ! getOptionalJTableMembers().equals( rhs.getOptionalJTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableInterface() != null ) {
				if( rhs.getOptionalJTableInterface() != null ) {
					if( ! getOptionalJTableInterface().equals( rhs.getOptionalJTableInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableImplementation() != null ) {
				if( rhs.getOptionalJTableImplementation() != null ) {
					if( ! getOptionalJTableImplementation().equals( rhs.getOptionalJTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjImport() != null ) {
				if( rhs.getOptionalJTableObjImport() != null ) {
					if( ! getOptionalJTableObjImport().equals( rhs.getOptionalJTableObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjMembers() != null ) {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					if( ! getOptionalJTableObjMembers().equals( rhs.getOptionalJTableObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjInterface() != null ) {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					if( ! getOptionalJTableObjInterface().equals( rhs.getOptionalJTableObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjImplementation() != null ) {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					if( ! getOptionalJTableObjImplementation().equals( rhs.getOptionalJTableObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableImport() != null ) {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					if( ! getOptionalJDb2LUWTableImport().equals( rhs.getOptionalJDb2LUWTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					if( ! getOptionalJDb2LUWTableMembers().equals( rhs.getOptionalJDb2LUWTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					if( ! getOptionalJDb2LUWTableImplementation().equals( rhs.getOptionalJDb2LUWTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableImport() != null ) {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					if( ! getOptionalJMSSqlTableImport().equals( rhs.getOptionalJMSSqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableMembers() != null ) {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					if( ! getOptionalJMSSqlTableMembers().equals( rhs.getOptionalJMSSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					if( ! getOptionalJMSSqlTableImplementation().equals( rhs.getOptionalJMSSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableImport() != null ) {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					if( ! getOptionalJMySqlTableImport().equals( rhs.getOptionalJMySqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableMembers() != null ) {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					if( ! getOptionalJMySqlTableMembers().equals( rhs.getOptionalJMySqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableImplementation() != null ) {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					if( ! getOptionalJMySqlTableImplementation().equals( rhs.getOptionalJMySqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableImport() != null ) {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					if( ! getOptionalJOracleTableImport().equals( rhs.getOptionalJOracleTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableMembers() != null ) {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					if( ! getOptionalJOracleTableMembers().equals( rhs.getOptionalJOracleTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableImplementation() != null ) {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					if( ! getOptionalJOracleTableImplementation().equals( rhs.getOptionalJOracleTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableImport() != null ) {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					if( ! getOptionalJPgSqlTableImport().equals( rhs.getOptionalJPgSqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableMembers() != null ) {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					if( ! getOptionalJPgSqlTableMembers().equals( rhs.getOptionalJPgSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					if( ! getOptionalJPgSqlTableImplementation().equals( rhs.getOptionalJPgSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseTableImport() != null ) {
				if( rhs.getOptionalJSybaseTableImport() != null ) {
					if( ! getOptionalJSybaseTableImport().equals( rhs.getOptionalJSybaseTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseTableMembers() != null ) {
				if( rhs.getOptionalJSybaseTableMembers() != null ) {
					if( ! getOptionalJSybaseTableMembers().equals( rhs.getOptionalJSybaseTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseTableImplementation() != null ) {
				if( rhs.getOptionalJSybaseTableImplementation() != null ) {
					if( ! getOptionalJSybaseTableImplementation().equals( rhs.getOptionalJSybaseTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableImport() != null ) {
				if( rhs.getOptionalJRamTableImport() != null ) {
					if( ! getOptionalJRamTableImport().equals( rhs.getOptionalJRamTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableMembers() != null ) {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					if( ! getOptionalJRamTableMembers().equals( rhs.getOptionalJRamTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableImplementation() != null ) {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					if( ! getOptionalJRamTableImplementation().equals( rhs.getOptionalJRamTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderImport() != null ) {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					if( ! getOptionalJSaxLoaderImport().equals( rhs.getOptionalJSaxLoaderImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					if( ! getOptionalJSaxLoaderStartElement().equals( rhs.getOptionalJSaxLoaderStartElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					if( ! getOptionalJSaxLoaderEndElement().equals( rhs.getOptionalJSaxLoaderEndElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgTableImport() != null ) {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					if( ! getOptionalJXMsgTableImport().equals( rhs.getOptionalJXMsgTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgTableFormatters() != null ) {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					if( ! getOptionalJXMsgTableFormatters().equals( rhs.getOptionalJXMsgTableFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstTableImport() != null ) {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					if( ! getOptionalJXMsgRqstTableImport().equals( rhs.getOptionalJXMsgRqstTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnTableImport() != null ) {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					if( ! getOptionalJXMsgRspnTableImport().equals( rhs.getOptionalJXMsgRspnTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientTableImport() != null ) {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					if( ! getOptionalJXMsgClientTableImport().equals( rhs.getOptionalJXMsgClientTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					if( ! getOptionalJXMsgRqstTableBody().equals( rhs.getOptionalJXMsgRqstTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					if( ! getOptionalJXMsgRspnTableBody().equals( rhs.getOptionalJXMsgRspnTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientTableBody() != null ) {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					if( ! getOptionalJXMsgClientTableBody().equals( rhs.getOptionalJXMsgClientTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					return( false );
				}
			}
			if( getRequiredDefaultVisibility() != rhs.getRequiredDefaultVisibility() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableBuff ) {
			CFBamTableBuff rhs = (CFBamTableBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaDefId() != rhs.getRequiredSchemaDefId() ) {
				return( false );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalPrimaryIndexTenantId() != null ) {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					if( ! getOptionalPrimaryIndexTenantId().equals( rhs.getOptionalPrimaryIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
				return( false );
			}
			if( getOptionalLookupIndexTenantId() != null ) {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					if( ! getOptionalLookupIndexTenantId().equals( rhs.getOptionalLookupIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexTenantId() != null ) {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					if( ! getOptionalAltIndexTenantId().equals( rhs.getOptionalAltIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTenantId() != null ) {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					if( ! getOptionalQualifyingTenantId().equals( rhs.getOptionalQualifyingTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredPolyBase() != rhs.getRequiredPolyBase() ) {
				return( false );
			}
			if( getRequiredIsInstantiable() != rhs.getRequiredIsInstantiable() ) {
				return( false );
			}
			if( getRequiredHasHistory() != rhs.getRequiredHasHistory() ) {
				return( false );
			}
			if( getRequiredHasAuditColumns() != rhs.getRequiredHasAuditColumns() ) {
				return( false );
			}
			if( getRequiredLoaderBehaviourId() != rhs.getRequiredLoaderBehaviourId() ) {
				return( false );
			}
			if( getOptionalDataScopeId() != null ) {
				if( rhs.getOptionalDataScopeId() != null ) {
					if( ! getOptionalDataScopeId().equals( rhs.getOptionalDataScopeId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDataScopeId() != null ) {
					return( false );
				}
			}
			if( getRequiredSecurityScopeId() != rhs.getRequiredSecurityScopeId() ) {
				return( false );
			}
			if( getOptionalViewAccessSecurityId() != null ) {
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					if( ! getOptionalViewAccessSecurityId().equals( rhs.getOptionalViewAccessSecurityId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					return( false );
				}
			}
			if( getOptionalEditAccessSecurityId() != null ) {
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					if( ! getOptionalEditAccessSecurityId().equals( rhs.getOptionalEditAccessSecurityId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					return( false );
				}
			}
			if( getOptionalViewAccessFrequencyId() != null ) {
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					if( ! getOptionalViewAccessFrequencyId().equals( rhs.getOptionalViewAccessFrequencyId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					return( false );
				}
			}
			if( getOptionalEditAccessFrequencyId() != null ) {
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					if( ! getOptionalEditAccessFrequencyId().equals( rhs.getOptionalEditAccessFrequencyId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjMembers() != null ) {
				if( rhs.getOptionalJObjMembers() != null ) {
					if( ! getOptionalJObjMembers().equals( rhs.getOptionalJObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjInterface() != null ) {
				if( rhs.getOptionalJObjInterface() != null ) {
					if( ! getOptionalJObjInterface().equals( rhs.getOptionalJObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjImport() != null ) {
				if( rhs.getOptionalJObjImport() != null ) {
					if( ! getOptionalJObjImport().equals( rhs.getOptionalJObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjImplementation() != null ) {
				if( rhs.getOptionalJObjImplementation() != null ) {
					if( ! getOptionalJObjImplementation().equals( rhs.getOptionalJObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjMembers() != null ) {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					if( ! getOptionalJEditObjMembers().equals( rhs.getOptionalJEditObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjInterface() != null ) {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					if( ! getOptionalJEditObjInterface().equals( rhs.getOptionalJEditObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjImport() != null ) {
				if( rhs.getOptionalJEditObjImport() != null ) {
					if( ! getOptionalJEditObjImport().equals( rhs.getOptionalJEditObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjImplementation() != null ) {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					if( ! getOptionalJEditObjImplementation().equals( rhs.getOptionalJEditObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableImport() != null ) {
				if( rhs.getOptionalJTableImport() != null ) {
					if( ! getOptionalJTableImport().equals( rhs.getOptionalJTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableMembers() != null ) {
				if( rhs.getOptionalJTableMembers() != null ) {
					if( ! getOptionalJTableMembers().equals( rhs.getOptionalJTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableInterface() != null ) {
				if( rhs.getOptionalJTableInterface() != null ) {
					if( ! getOptionalJTableInterface().equals( rhs.getOptionalJTableInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableImplementation() != null ) {
				if( rhs.getOptionalJTableImplementation() != null ) {
					if( ! getOptionalJTableImplementation().equals( rhs.getOptionalJTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjImport() != null ) {
				if( rhs.getOptionalJTableObjImport() != null ) {
					if( ! getOptionalJTableObjImport().equals( rhs.getOptionalJTableObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjMembers() != null ) {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					if( ! getOptionalJTableObjMembers().equals( rhs.getOptionalJTableObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjInterface() != null ) {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					if( ! getOptionalJTableObjInterface().equals( rhs.getOptionalJTableObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjImplementation() != null ) {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					if( ! getOptionalJTableObjImplementation().equals( rhs.getOptionalJTableObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableImport() != null ) {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					if( ! getOptionalJDb2LUWTableImport().equals( rhs.getOptionalJDb2LUWTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					if( ! getOptionalJDb2LUWTableMembers().equals( rhs.getOptionalJDb2LUWTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					if( ! getOptionalJDb2LUWTableImplementation().equals( rhs.getOptionalJDb2LUWTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableImport() != null ) {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					if( ! getOptionalJMSSqlTableImport().equals( rhs.getOptionalJMSSqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableMembers() != null ) {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					if( ! getOptionalJMSSqlTableMembers().equals( rhs.getOptionalJMSSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					if( ! getOptionalJMSSqlTableImplementation().equals( rhs.getOptionalJMSSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableImport() != null ) {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					if( ! getOptionalJMySqlTableImport().equals( rhs.getOptionalJMySqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableMembers() != null ) {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					if( ! getOptionalJMySqlTableMembers().equals( rhs.getOptionalJMySqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableImplementation() != null ) {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					if( ! getOptionalJMySqlTableImplementation().equals( rhs.getOptionalJMySqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableImport() != null ) {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					if( ! getOptionalJOracleTableImport().equals( rhs.getOptionalJOracleTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableMembers() != null ) {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					if( ! getOptionalJOracleTableMembers().equals( rhs.getOptionalJOracleTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableImplementation() != null ) {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					if( ! getOptionalJOracleTableImplementation().equals( rhs.getOptionalJOracleTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableImport() != null ) {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					if( ! getOptionalJPgSqlTableImport().equals( rhs.getOptionalJPgSqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableMembers() != null ) {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					if( ! getOptionalJPgSqlTableMembers().equals( rhs.getOptionalJPgSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					if( ! getOptionalJPgSqlTableImplementation().equals( rhs.getOptionalJPgSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseTableImport() != null ) {
				if( rhs.getOptionalJSybaseTableImport() != null ) {
					if( ! getOptionalJSybaseTableImport().equals( rhs.getOptionalJSybaseTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseTableMembers() != null ) {
				if( rhs.getOptionalJSybaseTableMembers() != null ) {
					if( ! getOptionalJSybaseTableMembers().equals( rhs.getOptionalJSybaseTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseTableImplementation() != null ) {
				if( rhs.getOptionalJSybaseTableImplementation() != null ) {
					if( ! getOptionalJSybaseTableImplementation().equals( rhs.getOptionalJSybaseTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableImport() != null ) {
				if( rhs.getOptionalJRamTableImport() != null ) {
					if( ! getOptionalJRamTableImport().equals( rhs.getOptionalJRamTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableMembers() != null ) {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					if( ! getOptionalJRamTableMembers().equals( rhs.getOptionalJRamTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableImplementation() != null ) {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					if( ! getOptionalJRamTableImplementation().equals( rhs.getOptionalJRamTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderImport() != null ) {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					if( ! getOptionalJSaxLoaderImport().equals( rhs.getOptionalJSaxLoaderImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					if( ! getOptionalJSaxLoaderStartElement().equals( rhs.getOptionalJSaxLoaderStartElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					if( ! getOptionalJSaxLoaderEndElement().equals( rhs.getOptionalJSaxLoaderEndElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgTableImport() != null ) {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					if( ! getOptionalJXMsgTableImport().equals( rhs.getOptionalJXMsgTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgTableFormatters() != null ) {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					if( ! getOptionalJXMsgTableFormatters().equals( rhs.getOptionalJXMsgTableFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstTableImport() != null ) {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					if( ! getOptionalJXMsgRqstTableImport().equals( rhs.getOptionalJXMsgRqstTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnTableImport() != null ) {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					if( ! getOptionalJXMsgRspnTableImport().equals( rhs.getOptionalJXMsgRspnTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientTableImport() != null ) {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					if( ! getOptionalJXMsgClientTableImport().equals( rhs.getOptionalJXMsgClientTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					if( ! getOptionalJXMsgRqstTableBody().equals( rhs.getOptionalJXMsgRqstTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					if( ! getOptionalJXMsgRspnTableBody().equals( rhs.getOptionalJXMsgRspnTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientTableBody() != null ) {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					if( ! getOptionalJXMsgClientTableBody().equals( rhs.getOptionalJXMsgClientTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					return( false );
				}
			}
			if( getRequiredDefaultVisibility() != rhs.getRequiredDefaultVisibility() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableBySchemaDefIdxKey ) {
			CFBamTableBySchemaDefIdxKey rhs = (CFBamTableBySchemaDefIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaDefId() != rhs.getRequiredSchemaDefId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByDefSchemaIdxKey ) {
			CFBamTableByDefSchemaIdxKey rhs = (CFBamTableByDefSchemaIdxKey)obj;
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByUNameIdxKey ) {
			CFBamTableByUNameIdxKey rhs = (CFBamTableByUNameIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaDefId() != rhs.getRequiredSchemaDefId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableBySchemaCdIdxKey ) {
			CFBamTableBySchemaCdIdxKey rhs = (CFBamTableBySchemaCdIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaDefId() != rhs.getRequiredSchemaDefId() ) {
				return( false );
			}
			if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByPrimaryIndexIdxKey ) {
			CFBamTableByPrimaryIndexIdxKey rhs = (CFBamTableByPrimaryIndexIdxKey)obj;
			if( getOptionalPrimaryIndexTenantId() != null ) {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					if( ! getOptionalPrimaryIndexTenantId().equals( rhs.getOptionalPrimaryIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByLookupIndexIdxKey ) {
			CFBamTableByLookupIndexIdxKey rhs = (CFBamTableByLookupIndexIdxKey)obj;
			if( getOptionalLookupIndexTenantId() != null ) {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					if( ! getOptionalLookupIndexTenantId().equals( rhs.getOptionalLookupIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByAltIndexIdxKey ) {
			CFBamTableByAltIndexIdxKey rhs = (CFBamTableByAltIndexIdxKey)obj;
			if( getOptionalAltIndexTenantId() != null ) {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					if( ! getOptionalAltIndexTenantId().equals( rhs.getOptionalAltIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByQualTableIdxKey ) {
			CFBamTableByQualTableIdxKey rhs = (CFBamTableByQualTableIdxKey)obj;
			if( getOptionalQualifyingTenantId() != null ) {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					if( ! getOptionalQualifyingTenantId().equals( rhs.getOptionalQualifyingTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByLoadBehaveIdxKey ) {
			CFBamTableByLoadBehaveIdxKey rhs = (CFBamTableByLoadBehaveIdxKey)obj;
			if( getRequiredLoaderBehaviourId() != rhs.getRequiredLoaderBehaviourId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByDataScopeIdxKey ) {
			CFBamTableByDataScopeIdxKey rhs = (CFBamTableByDataScopeIdxKey)obj;
			if( getOptionalDataScopeId() != null ) {
				if( rhs.getOptionalDataScopeId() != null ) {
					if( ! getOptionalDataScopeId().equals( rhs.getOptionalDataScopeId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDataScopeId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableBySecScopeIdxKey ) {
			CFBamTableBySecScopeIdxKey rhs = (CFBamTableBySecScopeIdxKey)obj;
			if( getRequiredSecurityScopeId() != rhs.getRequiredSecurityScopeId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByVAccSecIdxKey ) {
			CFBamTableByVAccSecIdxKey rhs = (CFBamTableByVAccSecIdxKey)obj;
			if( getOptionalViewAccessSecurityId() != null ) {
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					if( ! getOptionalViewAccessSecurityId().equals( rhs.getOptionalViewAccessSecurityId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByVAccFreqIdxKey ) {
			CFBamTableByVAccFreqIdxKey rhs = (CFBamTableByVAccFreqIdxKey)obj;
			if( getOptionalViewAccessFrequencyId() != null ) {
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					if( ! getOptionalViewAccessFrequencyId().equals( rhs.getOptionalViewAccessFrequencyId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByEAccSecIdxKey ) {
			CFBamTableByEAccSecIdxKey rhs = (CFBamTableByEAccSecIdxKey)obj;
			if( getOptionalEditAccessSecurityId() != null ) {
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					if( ! getOptionalEditAccessSecurityId().equals( rhs.getOptionalEditAccessSecurityId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByEAccFreqIdxKey ) {
			CFBamTableByEAccFreqIdxKey rhs = (CFBamTableByEAccFreqIdxKey)obj;
			if( getOptionalEditAccessFrequencyId() != null ) {
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					if( ! getOptionalEditAccessFrequencyId().equals( rhs.getOptionalEditAccessFrequencyId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			return( super.equals( obj ) );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + (int)( getRequiredSchemaDefId() );
		if( getOptionalDefSchemaTenantId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaTenantId().hashCode();
		}
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalDbName() != null ) {
			hashCode = hashCode + getOptionalDbName().hashCode();
		}
		if( getOptionalShortName() != null ) {
			hashCode = hashCode + getOptionalShortName().hashCode();
		}
		if( getOptionalLabel() != null ) {
			hashCode = hashCode + getOptionalLabel().hashCode();
		}
		if( getOptionalShortDescription() != null ) {
			hashCode = hashCode + getOptionalShortDescription().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		if( getOptionalPrimaryIndexTenantId() != null ) {
			hashCode = hashCode + getOptionalPrimaryIndexTenantId().hashCode();
		}
		if( getOptionalPrimaryIndexId() != null ) {
			hashCode = hashCode + getOptionalPrimaryIndexId().hashCode();
		}
		if( getRequiredTableClassCode() != null ) {
			hashCode = hashCode + getRequiredTableClassCode().hashCode();
		}
		if( getOptionalLookupIndexTenantId() != null ) {
			hashCode = hashCode + getOptionalLookupIndexTenantId().hashCode();
		}
		if( getOptionalLookupIndexId() != null ) {
			hashCode = hashCode + getOptionalLookupIndexId().hashCode();
		}
		if( getOptionalAltIndexTenantId() != null ) {
			hashCode = hashCode + getOptionalAltIndexTenantId().hashCode();
		}
		if( getOptionalAltIndexId() != null ) {
			hashCode = hashCode + getOptionalAltIndexId().hashCode();
		}
		if( getOptionalQualifyingTenantId() != null ) {
			hashCode = hashCode + getOptionalQualifyingTenantId().hashCode();
		}
		if( getOptionalQualifyingTableId() != null ) {
			hashCode = hashCode + getOptionalQualifyingTableId().hashCode();
		}
		if( getRequiredPolyBase() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredIsInstantiable() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredHasHistory() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredHasAuditColumns() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredLoaderBehaviourId();
		if( getOptionalDataScopeId() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalDataScopeId();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredSecurityScopeId();
		if( getOptionalViewAccessSecurityId() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalViewAccessSecurityId();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalEditAccessSecurityId() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalEditAccessSecurityId();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalViewAccessFrequencyId() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalViewAccessFrequencyId();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalEditAccessFrequencyId() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalEditAccessFrequencyId();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalJObjMembers() != null ) {
			hashCode = hashCode + getOptionalJObjMembers().hashCode();
		}
		if( getOptionalJObjInterface() != null ) {
			hashCode = hashCode + getOptionalJObjInterface().hashCode();
		}
		if( getOptionalJObjImport() != null ) {
			hashCode = hashCode + getOptionalJObjImport().hashCode();
		}
		if( getOptionalJObjImplementation() != null ) {
			hashCode = hashCode + getOptionalJObjImplementation().hashCode();
		}
		if( getOptionalJEditObjMembers() != null ) {
			hashCode = hashCode + getOptionalJEditObjMembers().hashCode();
		}
		if( getOptionalJEditObjInterface() != null ) {
			hashCode = hashCode + getOptionalJEditObjInterface().hashCode();
		}
		if( getOptionalJEditObjImport() != null ) {
			hashCode = hashCode + getOptionalJEditObjImport().hashCode();
		}
		if( getOptionalJEditObjImplementation() != null ) {
			hashCode = hashCode + getOptionalJEditObjImplementation().hashCode();
		}
		if( getOptionalJTableImport() != null ) {
			hashCode = hashCode + getOptionalJTableImport().hashCode();
		}
		if( getOptionalJTableMembers() != null ) {
			hashCode = hashCode + getOptionalJTableMembers().hashCode();
		}
		if( getOptionalJTableInterface() != null ) {
			hashCode = hashCode + getOptionalJTableInterface().hashCode();
		}
		if( getOptionalJTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJTableImplementation().hashCode();
		}
		if( getOptionalJTableObjImport() != null ) {
			hashCode = hashCode + getOptionalJTableObjImport().hashCode();
		}
		if( getOptionalJTableObjMembers() != null ) {
			hashCode = hashCode + getOptionalJTableObjMembers().hashCode();
		}
		if( getOptionalJTableObjInterface() != null ) {
			hashCode = hashCode + getOptionalJTableObjInterface().hashCode();
		}
		if( getOptionalJTableObjImplementation() != null ) {
			hashCode = hashCode + getOptionalJTableObjImplementation().hashCode();
		}
		if( getOptionalJDb2LUWTableImport() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWTableImport().hashCode();
		}
		if( getOptionalJDb2LUWTableMembers() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWTableMembers().hashCode();
		}
		if( getOptionalJDb2LUWTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWTableImplementation().hashCode();
		}
		if( getOptionalJMSSqlTableImport() != null ) {
			hashCode = hashCode + getOptionalJMSSqlTableImport().hashCode();
		}
		if( getOptionalJMSSqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalJMSSqlTableMembers().hashCode();
		}
		if( getOptionalJMSSqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJMSSqlTableImplementation().hashCode();
		}
		if( getOptionalJMySqlTableImport() != null ) {
			hashCode = hashCode + getOptionalJMySqlTableImport().hashCode();
		}
		if( getOptionalJMySqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalJMySqlTableMembers().hashCode();
		}
		if( getOptionalJMySqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJMySqlTableImplementation().hashCode();
		}
		if( getOptionalJOracleTableImport() != null ) {
			hashCode = hashCode + getOptionalJOracleTableImport().hashCode();
		}
		if( getOptionalJOracleTableMembers() != null ) {
			hashCode = hashCode + getOptionalJOracleTableMembers().hashCode();
		}
		if( getOptionalJOracleTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJOracleTableImplementation().hashCode();
		}
		if( getOptionalJPgSqlTableImport() != null ) {
			hashCode = hashCode + getOptionalJPgSqlTableImport().hashCode();
		}
		if( getOptionalJPgSqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalJPgSqlTableMembers().hashCode();
		}
		if( getOptionalJPgSqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJPgSqlTableImplementation().hashCode();
		}
		if( getOptionalJSybaseTableImport() != null ) {
			hashCode = hashCode + getOptionalJSybaseTableImport().hashCode();
		}
		if( getOptionalJSybaseTableMembers() != null ) {
			hashCode = hashCode + getOptionalJSybaseTableMembers().hashCode();
		}
		if( getOptionalJSybaseTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJSybaseTableImplementation().hashCode();
		}
		if( getOptionalJRamTableImport() != null ) {
			hashCode = hashCode + getOptionalJRamTableImport().hashCode();
		}
		if( getOptionalJRamTableMembers() != null ) {
			hashCode = hashCode + getOptionalJRamTableMembers().hashCode();
		}
		if( getOptionalJRamTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJRamTableImplementation().hashCode();
		}
		if( getOptionalJSaxLoaderImport() != null ) {
			hashCode = hashCode + getOptionalJSaxLoaderImport().hashCode();
		}
		if( getOptionalJSaxLoaderStartElement() != null ) {
			hashCode = hashCode + getOptionalJSaxLoaderStartElement().hashCode();
		}
		if( getOptionalJSaxLoaderEndElement() != null ) {
			hashCode = hashCode + getOptionalJSaxLoaderEndElement().hashCode();
		}
		if( getOptionalJXMsgTableImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgTableImport().hashCode();
		}
		if( getOptionalJXMsgTableFormatters() != null ) {
			hashCode = hashCode + getOptionalJXMsgTableFormatters().hashCode();
		}
		if( getOptionalJXMsgRqstTableImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstTableImport().hashCode();
		}
		if( getOptionalJXMsgRspnTableImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnTableImport().hashCode();
		}
		if( getOptionalJXMsgClientTableImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgClientTableImport().hashCode();
		}
		if( getOptionalJXMsgRqstTableBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstTableBody().hashCode();
		}
		if( getOptionalJXMsgRspnTableBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnTableBody().hashCode();
		}
		if( getOptionalJXMsgClientTableBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgClientTableBody().hashCode();
		}
		if( getRequiredDefaultVisibility() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamTableBuff ) {
			CFBamTableBuff rhs = (CFBamTableBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTableBySchemaDefIdxKey ) {
			CFBamTableBySchemaDefIdxKey rhs = (CFBamTableBySchemaDefIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredSchemaDefId() < rhs.getRequiredSchemaDefId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaDefId() > rhs.getRequiredSchemaDefId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByDefSchemaIdxKey ) {
			CFBamTableByDefSchemaIdxKey rhs = (CFBamTableByDefSchemaIdxKey)obj;

			if( getOptionalDefSchemaTenantId() != null ) {
				Long lhsDefSchemaTenantId = getOptionalDefSchemaTenantId();
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					Long rhsDefSchemaTenantId = rhs.getOptionalDefSchemaTenantId();
					int cmp = lhsDefSchemaTenantId.compareTo( rhsDefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				Long lhsDefSchemaId = getOptionalDefSchemaId();
				if( rhs.getOptionalDefSchemaId() != null ) {
					Long rhsDefSchemaId = rhs.getOptionalDefSchemaId();
					int cmp = lhsDefSchemaId.compareTo( rhsDefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByUNameIdxKey ) {
			CFBamTableByUNameIdxKey rhs = (CFBamTableByUNameIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredSchemaDefId() < rhs.getRequiredSchemaDefId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaDefId() > rhs.getRequiredSchemaDefId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableBySchemaCdIdxKey ) {
			CFBamTableBySchemaCdIdxKey rhs = (CFBamTableBySchemaCdIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredSchemaDefId() < rhs.getRequiredSchemaDefId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaDefId() > rhs.getRequiredSchemaDefId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredTableClassCode().compareTo( rhs.getRequiredTableClassCode() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByPrimaryIndexIdxKey ) {
			CFBamTableByPrimaryIndexIdxKey rhs = (CFBamTableByPrimaryIndexIdxKey)obj;

			if( getOptionalPrimaryIndexTenantId() != null ) {
				Long lhsPrimaryIndexTenantId = getOptionalPrimaryIndexTenantId();
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					Long rhsPrimaryIndexTenantId = rhs.getOptionalPrimaryIndexTenantId();
					int cmp = lhsPrimaryIndexTenantId.compareTo( rhsPrimaryIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				Long lhsPrimaryIndexId = getOptionalPrimaryIndexId();
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					Long rhsPrimaryIndexId = rhs.getOptionalPrimaryIndexId();
					int cmp = lhsPrimaryIndexId.compareTo( rhsPrimaryIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByLookupIndexIdxKey ) {
			CFBamTableByLookupIndexIdxKey rhs = (CFBamTableByLookupIndexIdxKey)obj;

			if( getOptionalLookupIndexTenantId() != null ) {
				Long lhsLookupIndexTenantId = getOptionalLookupIndexTenantId();
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					Long rhsLookupIndexTenantId = rhs.getOptionalLookupIndexTenantId();
					int cmp = lhsLookupIndexTenantId.compareTo( rhsLookupIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				Long lhsLookupIndexId = getOptionalLookupIndexId();
				if( rhs.getOptionalLookupIndexId() != null ) {
					Long rhsLookupIndexId = rhs.getOptionalLookupIndexId();
					int cmp = lhsLookupIndexId.compareTo( rhsLookupIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByAltIndexIdxKey ) {
			CFBamTableByAltIndexIdxKey rhs = (CFBamTableByAltIndexIdxKey)obj;

			if( getOptionalAltIndexTenantId() != null ) {
				Long lhsAltIndexTenantId = getOptionalAltIndexTenantId();
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					Long rhsAltIndexTenantId = rhs.getOptionalAltIndexTenantId();
					int cmp = lhsAltIndexTenantId.compareTo( rhsAltIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				Long lhsAltIndexId = getOptionalAltIndexId();
				if( rhs.getOptionalAltIndexId() != null ) {
					Long rhsAltIndexId = rhs.getOptionalAltIndexId();
					int cmp = lhsAltIndexId.compareTo( rhsAltIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByQualTableIdxKey ) {
			CFBamTableByQualTableIdxKey rhs = (CFBamTableByQualTableIdxKey)obj;

			if( getOptionalQualifyingTenantId() != null ) {
				Long lhsQualifyingTenantId = getOptionalQualifyingTenantId();
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					Long rhsQualifyingTenantId = rhs.getOptionalQualifyingTenantId();
					int cmp = lhsQualifyingTenantId.compareTo( rhsQualifyingTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				Long lhsQualifyingTableId = getOptionalQualifyingTableId();
				if( rhs.getOptionalQualifyingTableId() != null ) {
					Long rhsQualifyingTableId = rhs.getOptionalQualifyingTableId();
					int cmp = lhsQualifyingTableId.compareTo( rhsQualifyingTableId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByLoadBehaveIdxKey ) {
			CFBamTableByLoadBehaveIdxKey rhs = (CFBamTableByLoadBehaveIdxKey)obj;

			if( getRequiredLoaderBehaviourId() < rhs.getRequiredLoaderBehaviourId() ) {
				return( -1 );
			}
			else if( getRequiredLoaderBehaviourId() > rhs.getRequiredLoaderBehaviourId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByDataScopeIdxKey ) {
			CFBamTableByDataScopeIdxKey rhs = (CFBamTableByDataScopeIdxKey)obj;

			if( getOptionalDataScopeId() != null ) {
				Short lhsDataScopeId = getOptionalDataScopeId();
				if( rhs.getOptionalDataScopeId() != null ) {
					Short rhsDataScopeId = rhs.getOptionalDataScopeId();
					int cmp = lhsDataScopeId.compareTo( rhsDataScopeId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDataScopeId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableBySecScopeIdxKey ) {
			CFBamTableBySecScopeIdxKey rhs = (CFBamTableBySecScopeIdxKey)obj;

			if( getRequiredSecurityScopeId() < rhs.getRequiredSecurityScopeId() ) {
				return( -1 );
			}
			else if( getRequiredSecurityScopeId() > rhs.getRequiredSecurityScopeId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByVAccSecIdxKey ) {
			CFBamTableByVAccSecIdxKey rhs = (CFBamTableByVAccSecIdxKey)obj;

			if( getOptionalViewAccessSecurityId() != null ) {
				Short lhsViewAccessSecurityId = getOptionalViewAccessSecurityId();
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					Short rhsViewAccessSecurityId = rhs.getOptionalViewAccessSecurityId();
					int cmp = lhsViewAccessSecurityId.compareTo( rhsViewAccessSecurityId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByVAccFreqIdxKey ) {
			CFBamTableByVAccFreqIdxKey rhs = (CFBamTableByVAccFreqIdxKey)obj;

			if( getOptionalViewAccessFrequencyId() != null ) {
				Short lhsViewAccessFrequencyId = getOptionalViewAccessFrequencyId();
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					Short rhsViewAccessFrequencyId = rhs.getOptionalViewAccessFrequencyId();
					int cmp = lhsViewAccessFrequencyId.compareTo( rhsViewAccessFrequencyId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByEAccSecIdxKey ) {
			CFBamTableByEAccSecIdxKey rhs = (CFBamTableByEAccSecIdxKey)obj;

			if( getOptionalEditAccessSecurityId() != null ) {
				Short lhsEditAccessSecurityId = getOptionalEditAccessSecurityId();
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					Short rhsEditAccessSecurityId = rhs.getOptionalEditAccessSecurityId();
					int cmp = lhsEditAccessSecurityId.compareTo( rhsEditAccessSecurityId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByEAccFreqIdxKey ) {
			CFBamTableByEAccFreqIdxKey rhs = (CFBamTableByEAccFreqIdxKey)obj;

			if( getOptionalEditAccessFrequencyId() != null ) {
				Short lhsEditAccessFrequencyId = getOptionalEditAccessFrequencyId();
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					Short rhsEditAccessFrequencyId = rhs.getOptionalEditAccessFrequencyId();
					int cmp = lhsEditAccessFrequencyId.compareTo( rhsEditAccessFrequencyId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableHBuff ) {
			CFBamTableHBuff rhs = (CFBamTableHBuff)obj;

			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			{
				long lhsAuditClusterId = getAuditClusterId();
				long rhsAuditClusterId = rhs.getAuditClusterId();
				if( lhsAuditClusterId < rhsAuditClusterId ) {
					return( -1 );
				}
				else if( lhsAuditClusterId > rhsAuditClusterId ) {
					return( 1 );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp == null ) {
					if( rhsAuditStamp != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditStamp == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditStamp.compareTo( rhsAuditStamp );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			{
				short lhsAuditActionId = getAuditActionId();
				short rhsAuditActionId = rhs.getAuditActionId();
				if( lhsAuditActionId < rhsAuditActionId ) {
					return( -1 );
				}
				else if( lhsAuditActionId > rhsAuditActionId ) {
					return( 1 );
				}
			}
			{
				int lhsRequiredRevision = getRequiredRevision();
				int rhsRequiredRevision = rhs.getRequiredRevision();
				if( lhsRequiredRevision < rhsRequiredRevision ) {
					return( -1 );
				}
				else if( lhsRequiredRevision > rhsRequiredRevision ) {
					return( 1 );
				}
			}
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId == null ) {
					if( rhsAuditSessionId != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditSessionId == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditSessionId.compareTo( rhsAuditSessionId );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			if( getRequiredSchemaDefId() < rhs.getRequiredSchemaDefId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaDefId() > rhs.getRequiredSchemaDefId() ) {
				return( 1 );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				Long lhsDefSchemaTenantId = getOptionalDefSchemaTenantId();
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					Long rhsDefSchemaTenantId = rhs.getOptionalDefSchemaTenantId();
					int cmp = lhsDefSchemaTenantId.compareTo( rhsDefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				Long lhsDefSchemaId = getOptionalDefSchemaId();
				if( rhs.getOptionalDefSchemaId() != null ) {
					Long rhsDefSchemaId = rhs.getOptionalDefSchemaId();
					int cmp = lhsDefSchemaId.compareTo( rhsDefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					int cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					int cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					int cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					int cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					int cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrimaryIndexTenantId() != null ) {
				Long lhsPrimaryIndexTenantId = getOptionalPrimaryIndexTenantId();
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					Long rhsPrimaryIndexTenantId = rhs.getOptionalPrimaryIndexTenantId();
					int cmp = lhsPrimaryIndexTenantId.compareTo( rhsPrimaryIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				Long lhsPrimaryIndexId = getOptionalPrimaryIndexId();
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					Long rhsPrimaryIndexId = rhs.getOptionalPrimaryIndexId();
					int cmp = lhsPrimaryIndexId.compareTo( rhsPrimaryIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredTableClassCode().compareTo( rhs.getRequiredTableClassCode() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalLookupIndexTenantId() != null ) {
				Long lhsLookupIndexTenantId = getOptionalLookupIndexTenantId();
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					Long rhsLookupIndexTenantId = rhs.getOptionalLookupIndexTenantId();
					int cmp = lhsLookupIndexTenantId.compareTo( rhsLookupIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				Long lhsLookupIndexId = getOptionalLookupIndexId();
				if( rhs.getOptionalLookupIndexId() != null ) {
					Long rhsLookupIndexId = rhs.getOptionalLookupIndexId();
					int cmp = lhsLookupIndexId.compareTo( rhsLookupIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalAltIndexTenantId() != null ) {
				Long lhsAltIndexTenantId = getOptionalAltIndexTenantId();
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					Long rhsAltIndexTenantId = rhs.getOptionalAltIndexTenantId();
					int cmp = lhsAltIndexTenantId.compareTo( rhsAltIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				Long lhsAltIndexId = getOptionalAltIndexId();
				if( rhs.getOptionalAltIndexId() != null ) {
					Long rhsAltIndexId = rhs.getOptionalAltIndexId();
					int cmp = lhsAltIndexId.compareTo( rhsAltIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalQualifyingTenantId() != null ) {
				Long lhsQualifyingTenantId = getOptionalQualifyingTenantId();
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					Long rhsQualifyingTenantId = rhs.getOptionalQualifyingTenantId();
					int cmp = lhsQualifyingTenantId.compareTo( rhsQualifyingTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				Long lhsQualifyingTableId = getOptionalQualifyingTableId();
				if( rhs.getOptionalQualifyingTableId() != null ) {
					Long rhsQualifyingTableId = rhs.getOptionalQualifyingTableId();
					int cmp = lhsQualifyingTableId.compareTo( rhsQualifyingTableId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredPolyBase() ) {
				if( ! rhs.getRequiredPolyBase() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredPolyBase() ) {
					return( -1 );
				}
			}
			if( getRequiredIsInstantiable() ) {
				if( ! rhs.getRequiredIsInstantiable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsInstantiable() ) {
					return( -1 );
				}
			}
			if( getRequiredHasHistory() ) {
				if( ! rhs.getRequiredHasHistory() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasHistory() ) {
					return( -1 );
				}
			}
			if( getRequiredHasAuditColumns() ) {
				if( ! rhs.getRequiredHasAuditColumns() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasAuditColumns() ) {
					return( -1 );
				}
			}
			if( getRequiredLoaderBehaviourId() < rhs.getRequiredLoaderBehaviourId() ) {
				return( -1 );
			}
			else if( getRequiredLoaderBehaviourId() > rhs.getRequiredLoaderBehaviourId() ) {
				return( 1 );
			}
			if( getOptionalDataScopeId() != null ) {
				Short lhsDataScopeId = getOptionalDataScopeId();
				if( rhs.getOptionalDataScopeId() != null ) {
					Short rhsDataScopeId = rhs.getOptionalDataScopeId();
					int cmp = lhsDataScopeId.compareTo( rhsDataScopeId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDataScopeId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredSecurityScopeId() < rhs.getRequiredSecurityScopeId() ) {
				return( -1 );
			}
			else if( getRequiredSecurityScopeId() > rhs.getRequiredSecurityScopeId() ) {
				return( 1 );
			}
			if( getOptionalViewAccessSecurityId() != null ) {
				Short lhsViewAccessSecurityId = getOptionalViewAccessSecurityId();
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					Short rhsViewAccessSecurityId = rhs.getOptionalViewAccessSecurityId();
					int cmp = lhsViewAccessSecurityId.compareTo( rhsViewAccessSecurityId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalEditAccessSecurityId() != null ) {
				Short lhsEditAccessSecurityId = getOptionalEditAccessSecurityId();
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					Short rhsEditAccessSecurityId = rhs.getOptionalEditAccessSecurityId();
					int cmp = lhsEditAccessSecurityId.compareTo( rhsEditAccessSecurityId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalViewAccessFrequencyId() != null ) {
				Short lhsViewAccessFrequencyId = getOptionalViewAccessFrequencyId();
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					Short rhsViewAccessFrequencyId = rhs.getOptionalViewAccessFrequencyId();
					int cmp = lhsViewAccessFrequencyId.compareTo( rhsViewAccessFrequencyId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalEditAccessFrequencyId() != null ) {
				Short lhsEditAccessFrequencyId = getOptionalEditAccessFrequencyId();
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					Short rhsEditAccessFrequencyId = rhs.getOptionalEditAccessFrequencyId();
					int cmp = lhsEditAccessFrequencyId.compareTo( rhsEditAccessFrequencyId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJObjMembers() != null ) {
				if( rhs.getOptionalJObjMembers() != null ) {
					int cmp = getOptionalJObjMembers().compareTo( rhs.getOptionalJObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJObjInterface() != null ) {
				if( rhs.getOptionalJObjInterface() != null ) {
					int cmp = getOptionalJObjInterface().compareTo( rhs.getOptionalJObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJObjImport() != null ) {
				if( rhs.getOptionalJObjImport() != null ) {
					int cmp = getOptionalJObjImport().compareTo( rhs.getOptionalJObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJObjImplementation() != null ) {
				if( rhs.getOptionalJObjImplementation() != null ) {
					int cmp = getOptionalJObjImplementation().compareTo( rhs.getOptionalJObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJEditObjMembers() != null ) {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					int cmp = getOptionalJEditObjMembers().compareTo( rhs.getOptionalJEditObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJEditObjInterface() != null ) {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					int cmp = getOptionalJEditObjInterface().compareTo( rhs.getOptionalJEditObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJEditObjImport() != null ) {
				if( rhs.getOptionalJEditObjImport() != null ) {
					int cmp = getOptionalJEditObjImport().compareTo( rhs.getOptionalJEditObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJEditObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJEditObjImplementation() != null ) {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					int cmp = getOptionalJEditObjImplementation().compareTo( rhs.getOptionalJEditObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableImport() != null ) {
				if( rhs.getOptionalJTableImport() != null ) {
					int cmp = getOptionalJTableImport().compareTo( rhs.getOptionalJTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableMembers() != null ) {
				if( rhs.getOptionalJTableMembers() != null ) {
					int cmp = getOptionalJTableMembers().compareTo( rhs.getOptionalJTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableInterface() != null ) {
				if( rhs.getOptionalJTableInterface() != null ) {
					int cmp = getOptionalJTableInterface().compareTo( rhs.getOptionalJTableInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableImplementation() != null ) {
				if( rhs.getOptionalJTableImplementation() != null ) {
					int cmp = getOptionalJTableImplementation().compareTo( rhs.getOptionalJTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableObjImport() != null ) {
				if( rhs.getOptionalJTableObjImport() != null ) {
					int cmp = getOptionalJTableObjImport().compareTo( rhs.getOptionalJTableObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableObjMembers() != null ) {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					int cmp = getOptionalJTableObjMembers().compareTo( rhs.getOptionalJTableObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableObjInterface() != null ) {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					int cmp = getOptionalJTableObjInterface().compareTo( rhs.getOptionalJTableObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableObjImplementation() != null ) {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					int cmp = getOptionalJTableObjImplementation().compareTo( rhs.getOptionalJTableObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWTableImport() != null ) {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					int cmp = getOptionalJDb2LUWTableImport().compareTo( rhs.getOptionalJDb2LUWTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					int cmp = getOptionalJDb2LUWTableMembers().compareTo( rhs.getOptionalJDb2LUWTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					int cmp = getOptionalJDb2LUWTableImplementation().compareTo( rhs.getOptionalJDb2LUWTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlTableImport() != null ) {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					int cmp = getOptionalJMSSqlTableImport().compareTo( rhs.getOptionalJMSSqlTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlTableMembers() != null ) {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					int cmp = getOptionalJMSSqlTableMembers().compareTo( rhs.getOptionalJMSSqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					int cmp = getOptionalJMSSqlTableImplementation().compareTo( rhs.getOptionalJMSSqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlTableImport() != null ) {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					int cmp = getOptionalJMySqlTableImport().compareTo( rhs.getOptionalJMySqlTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlTableMembers() != null ) {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					int cmp = getOptionalJMySqlTableMembers().compareTo( rhs.getOptionalJMySqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlTableImplementation() != null ) {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					int cmp = getOptionalJMySqlTableImplementation().compareTo( rhs.getOptionalJMySqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleTableImport() != null ) {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					int cmp = getOptionalJOracleTableImport().compareTo( rhs.getOptionalJOracleTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleTableMembers() != null ) {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					int cmp = getOptionalJOracleTableMembers().compareTo( rhs.getOptionalJOracleTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleTableImplementation() != null ) {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					int cmp = getOptionalJOracleTableImplementation().compareTo( rhs.getOptionalJOracleTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlTableImport() != null ) {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					int cmp = getOptionalJPgSqlTableImport().compareTo( rhs.getOptionalJPgSqlTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlTableMembers() != null ) {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					int cmp = getOptionalJPgSqlTableMembers().compareTo( rhs.getOptionalJPgSqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					int cmp = getOptionalJPgSqlTableImplementation().compareTo( rhs.getOptionalJPgSqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSybaseTableImport() != null ) {
				if( rhs.getOptionalJSybaseTableImport() != null ) {
					int cmp = getOptionalJSybaseTableImport().compareTo( rhs.getOptionalJSybaseTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSybaseTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSybaseTableMembers() != null ) {
				if( rhs.getOptionalJSybaseTableMembers() != null ) {
					int cmp = getOptionalJSybaseTableMembers().compareTo( rhs.getOptionalJSybaseTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSybaseTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSybaseTableImplementation() != null ) {
				if( rhs.getOptionalJSybaseTableImplementation() != null ) {
					int cmp = getOptionalJSybaseTableImplementation().compareTo( rhs.getOptionalJSybaseTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSybaseTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamTableImport() != null ) {
				if( rhs.getOptionalJRamTableImport() != null ) {
					int cmp = getOptionalJRamTableImport().compareTo( rhs.getOptionalJRamTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamTableMembers() != null ) {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					int cmp = getOptionalJRamTableMembers().compareTo( rhs.getOptionalJRamTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamTableImplementation() != null ) {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					int cmp = getOptionalJRamTableImplementation().compareTo( rhs.getOptionalJRamTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSaxLoaderImport() != null ) {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					int cmp = getOptionalJSaxLoaderImport().compareTo( rhs.getOptionalJSaxLoaderImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					int cmp = getOptionalJSaxLoaderStartElement().compareTo( rhs.getOptionalJSaxLoaderStartElement() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					int cmp = getOptionalJSaxLoaderEndElement().compareTo( rhs.getOptionalJSaxLoaderEndElement() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgTableImport() != null ) {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					int cmp = getOptionalJXMsgTableImport().compareTo( rhs.getOptionalJXMsgTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgTableFormatters() != null ) {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					int cmp = getOptionalJXMsgTableFormatters().compareTo( rhs.getOptionalJXMsgTableFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstTableImport() != null ) {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					int cmp = getOptionalJXMsgRqstTableImport().compareTo( rhs.getOptionalJXMsgRqstTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnTableImport() != null ) {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					int cmp = getOptionalJXMsgRspnTableImport().compareTo( rhs.getOptionalJXMsgRspnTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgClientTableImport() != null ) {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					int cmp = getOptionalJXMsgClientTableImport().compareTo( rhs.getOptionalJXMsgClientTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					int cmp = getOptionalJXMsgRqstTableBody().compareTo( rhs.getOptionalJXMsgRqstTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					int cmp = getOptionalJXMsgRspnTableBody().compareTo( rhs.getOptionalJXMsgRspnTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgClientTableBody() != null ) {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					int cmp = getOptionalJXMsgClientTableBody().compareTo( rhs.getOptionalJXMsgClientTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					return( -1 );
				}
			}
			if( getRequiredDefaultVisibility() ) {
				if( ! rhs.getRequiredDefaultVisibility() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredDefaultVisibility() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else {
			return( super.compareTo( obj ) );
		}
	}

	public void set( CFBamScopeBuff src ) {
		if( src instanceof CFBamTableBuff ) {
			setTableBuff( (CFBamTableBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamTableBuff" );
		}
	}

	public void setTableBuff( CFBamTableBuff src ) {
		super.setScopeBuff( src );
		setRequiredSchemaDefId( src.getRequiredSchemaDefId() );
		setOptionalDefSchemaTenantId( src.getOptionalDefSchemaTenantId() );
		setOptionalDefSchemaId( src.getOptionalDefSchemaId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setOptionalPrimaryIndexTenantId( src.getOptionalPrimaryIndexTenantId() );
		setOptionalPrimaryIndexId( src.getOptionalPrimaryIndexId() );
		setRequiredTableClassCode( src.getRequiredTableClassCode() );
		setOptionalLookupIndexTenantId( src.getOptionalLookupIndexTenantId() );
		setOptionalLookupIndexId( src.getOptionalLookupIndexId() );
		setOptionalAltIndexTenantId( src.getOptionalAltIndexTenantId() );
		setOptionalAltIndexId( src.getOptionalAltIndexId() );
		setOptionalQualifyingTenantId( src.getOptionalQualifyingTenantId() );
		setOptionalQualifyingTableId( src.getOptionalQualifyingTableId() );
		setRequiredPolyBase( src.getRequiredPolyBase() );
		setRequiredIsInstantiable( src.getRequiredIsInstantiable() );
		setRequiredHasHistory( src.getRequiredHasHistory() );
		setRequiredHasAuditColumns( src.getRequiredHasAuditColumns() );
		setRequiredLoaderBehaviourId( src.getRequiredLoaderBehaviourId() );
		setOptionalDataScopeId( src.getOptionalDataScopeId() );
		setRequiredSecurityScopeId( src.getRequiredSecurityScopeId() );
		setOptionalViewAccessSecurityId( src.getOptionalViewAccessSecurityId() );
		setOptionalEditAccessSecurityId( src.getOptionalEditAccessSecurityId() );
		setOptionalViewAccessFrequencyId( src.getOptionalViewAccessFrequencyId() );
		setOptionalEditAccessFrequencyId( src.getOptionalEditAccessFrequencyId() );
		setOptionalJObjMembers( src.getOptionalJObjMembers() );
		setOptionalJObjInterface( src.getOptionalJObjInterface() );
		setOptionalJObjImport( src.getOptionalJObjImport() );
		setOptionalJObjImplementation( src.getOptionalJObjImplementation() );
		setOptionalJEditObjMembers( src.getOptionalJEditObjMembers() );
		setOptionalJEditObjInterface( src.getOptionalJEditObjInterface() );
		setOptionalJEditObjImport( src.getOptionalJEditObjImport() );
		setOptionalJEditObjImplementation( src.getOptionalJEditObjImplementation() );
		setOptionalJTableImport( src.getOptionalJTableImport() );
		setOptionalJTableMembers( src.getOptionalJTableMembers() );
		setOptionalJTableInterface( src.getOptionalJTableInterface() );
		setOptionalJTableImplementation( src.getOptionalJTableImplementation() );
		setOptionalJTableObjImport( src.getOptionalJTableObjImport() );
		setOptionalJTableObjMembers( src.getOptionalJTableObjMembers() );
		setOptionalJTableObjInterface( src.getOptionalJTableObjInterface() );
		setOptionalJTableObjImplementation( src.getOptionalJTableObjImplementation() );
		setOptionalJDb2LUWTableImport( src.getOptionalJDb2LUWTableImport() );
		setOptionalJDb2LUWTableMembers( src.getOptionalJDb2LUWTableMembers() );
		setOptionalJDb2LUWTableImplementation( src.getOptionalJDb2LUWTableImplementation() );
		setOptionalJMSSqlTableImport( src.getOptionalJMSSqlTableImport() );
		setOptionalJMSSqlTableMembers( src.getOptionalJMSSqlTableMembers() );
		setOptionalJMSSqlTableImplementation( src.getOptionalJMSSqlTableImplementation() );
		setOptionalJMySqlTableImport( src.getOptionalJMySqlTableImport() );
		setOptionalJMySqlTableMembers( src.getOptionalJMySqlTableMembers() );
		setOptionalJMySqlTableImplementation( src.getOptionalJMySqlTableImplementation() );
		setOptionalJOracleTableImport( src.getOptionalJOracleTableImport() );
		setOptionalJOracleTableMembers( src.getOptionalJOracleTableMembers() );
		setOptionalJOracleTableImplementation( src.getOptionalJOracleTableImplementation() );
		setOptionalJPgSqlTableImport( src.getOptionalJPgSqlTableImport() );
		setOptionalJPgSqlTableMembers( src.getOptionalJPgSqlTableMembers() );
		setOptionalJPgSqlTableImplementation( src.getOptionalJPgSqlTableImplementation() );
		setOptionalJSybaseTableImport( src.getOptionalJSybaseTableImport() );
		setOptionalJSybaseTableMembers( src.getOptionalJSybaseTableMembers() );
		setOptionalJSybaseTableImplementation( src.getOptionalJSybaseTableImplementation() );
		setOptionalJRamTableImport( src.getOptionalJRamTableImport() );
		setOptionalJRamTableMembers( src.getOptionalJRamTableMembers() );
		setOptionalJRamTableImplementation( src.getOptionalJRamTableImplementation() );
		setOptionalJSaxLoaderImport( src.getOptionalJSaxLoaderImport() );
		setOptionalJSaxLoaderStartElement( src.getOptionalJSaxLoaderStartElement() );
		setOptionalJSaxLoaderEndElement( src.getOptionalJSaxLoaderEndElement() );
		setOptionalJXMsgTableImport( src.getOptionalJXMsgTableImport() );
		setOptionalJXMsgTableFormatters( src.getOptionalJXMsgTableFormatters() );
		setOptionalJXMsgRqstTableImport( src.getOptionalJXMsgRqstTableImport() );
		setOptionalJXMsgRspnTableImport( src.getOptionalJXMsgRspnTableImport() );
		setOptionalJXMsgClientTableImport( src.getOptionalJXMsgClientTableImport() );
		setOptionalJXMsgRqstTableBody( src.getOptionalJXMsgRqstTableBody() );
		setOptionalJXMsgRspnTableBody( src.getOptionalJXMsgRspnTableBody() );
		setOptionalJXMsgClientTableBody( src.getOptionalJXMsgClientTableBody() );
		setRequiredDefaultVisibility( src.getRequiredDefaultVisibility() );
	}

	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamTableHBuff ) {
			setTableBuff( (CFBamTableHBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamTableHBuff" );
		}
	}

	public void setTableBuff( CFBamTableHBuff src ) {
		super.setScopeBuff( src );
		setRequiredSchemaDefId( src.getRequiredSchemaDefId() );
		setOptionalDefSchemaTenantId( src.getOptionalDefSchemaTenantId() );
		setOptionalDefSchemaId( src.getOptionalDefSchemaId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setOptionalPrimaryIndexTenantId( src.getOptionalPrimaryIndexTenantId() );
		setOptionalPrimaryIndexId( src.getOptionalPrimaryIndexId() );
		setRequiredTableClassCode( src.getRequiredTableClassCode() );
		setOptionalLookupIndexTenantId( src.getOptionalLookupIndexTenantId() );
		setOptionalLookupIndexId( src.getOptionalLookupIndexId() );
		setOptionalAltIndexTenantId( src.getOptionalAltIndexTenantId() );
		setOptionalAltIndexId( src.getOptionalAltIndexId() );
		setOptionalQualifyingTenantId( src.getOptionalQualifyingTenantId() );
		setOptionalQualifyingTableId( src.getOptionalQualifyingTableId() );
		setRequiredPolyBase( src.getRequiredPolyBase() );
		setRequiredIsInstantiable( src.getRequiredIsInstantiable() );
		setRequiredHasHistory( src.getRequiredHasHistory() );
		setRequiredHasAuditColumns( src.getRequiredHasAuditColumns() );
		setRequiredLoaderBehaviourId( src.getRequiredLoaderBehaviourId() );
		setOptionalDataScopeId( src.getOptionalDataScopeId() );
		setRequiredSecurityScopeId( src.getRequiredSecurityScopeId() );
		setOptionalViewAccessSecurityId( src.getOptionalViewAccessSecurityId() );
		setOptionalEditAccessSecurityId( src.getOptionalEditAccessSecurityId() );
		setOptionalViewAccessFrequencyId( src.getOptionalViewAccessFrequencyId() );
		setOptionalEditAccessFrequencyId( src.getOptionalEditAccessFrequencyId() );
		setOptionalJObjMembers( src.getOptionalJObjMembers() );
		setOptionalJObjInterface( src.getOptionalJObjInterface() );
		setOptionalJObjImport( src.getOptionalJObjImport() );
		setOptionalJObjImplementation( src.getOptionalJObjImplementation() );
		setOptionalJEditObjMembers( src.getOptionalJEditObjMembers() );
		setOptionalJEditObjInterface( src.getOptionalJEditObjInterface() );
		setOptionalJEditObjImport( src.getOptionalJEditObjImport() );
		setOptionalJEditObjImplementation( src.getOptionalJEditObjImplementation() );
		setOptionalJTableImport( src.getOptionalJTableImport() );
		setOptionalJTableMembers( src.getOptionalJTableMembers() );
		setOptionalJTableInterface( src.getOptionalJTableInterface() );
		setOptionalJTableImplementation( src.getOptionalJTableImplementation() );
		setOptionalJTableObjImport( src.getOptionalJTableObjImport() );
		setOptionalJTableObjMembers( src.getOptionalJTableObjMembers() );
		setOptionalJTableObjInterface( src.getOptionalJTableObjInterface() );
		setOptionalJTableObjImplementation( src.getOptionalJTableObjImplementation() );
		setOptionalJDb2LUWTableImport( src.getOptionalJDb2LUWTableImport() );
		setOptionalJDb2LUWTableMembers( src.getOptionalJDb2LUWTableMembers() );
		setOptionalJDb2LUWTableImplementation( src.getOptionalJDb2LUWTableImplementation() );
		setOptionalJMSSqlTableImport( src.getOptionalJMSSqlTableImport() );
		setOptionalJMSSqlTableMembers( src.getOptionalJMSSqlTableMembers() );
		setOptionalJMSSqlTableImplementation( src.getOptionalJMSSqlTableImplementation() );
		setOptionalJMySqlTableImport( src.getOptionalJMySqlTableImport() );
		setOptionalJMySqlTableMembers( src.getOptionalJMySqlTableMembers() );
		setOptionalJMySqlTableImplementation( src.getOptionalJMySqlTableImplementation() );
		setOptionalJOracleTableImport( src.getOptionalJOracleTableImport() );
		setOptionalJOracleTableMembers( src.getOptionalJOracleTableMembers() );
		setOptionalJOracleTableImplementation( src.getOptionalJOracleTableImplementation() );
		setOptionalJPgSqlTableImport( src.getOptionalJPgSqlTableImport() );
		setOptionalJPgSqlTableMembers( src.getOptionalJPgSqlTableMembers() );
		setOptionalJPgSqlTableImplementation( src.getOptionalJPgSqlTableImplementation() );
		setOptionalJSybaseTableImport( src.getOptionalJSybaseTableImport() );
		setOptionalJSybaseTableMembers( src.getOptionalJSybaseTableMembers() );
		setOptionalJSybaseTableImplementation( src.getOptionalJSybaseTableImplementation() );
		setOptionalJRamTableImport( src.getOptionalJRamTableImport() );
		setOptionalJRamTableMembers( src.getOptionalJRamTableMembers() );
		setOptionalJRamTableImplementation( src.getOptionalJRamTableImplementation() );
		setOptionalJSaxLoaderImport( src.getOptionalJSaxLoaderImport() );
		setOptionalJSaxLoaderStartElement( src.getOptionalJSaxLoaderStartElement() );
		setOptionalJSaxLoaderEndElement( src.getOptionalJSaxLoaderEndElement() );
		setOptionalJXMsgTableImport( src.getOptionalJXMsgTableImport() );
		setOptionalJXMsgTableFormatters( src.getOptionalJXMsgTableFormatters() );
		setOptionalJXMsgRqstTableImport( src.getOptionalJXMsgRqstTableImport() );
		setOptionalJXMsgRspnTableImport( src.getOptionalJXMsgRspnTableImport() );
		setOptionalJXMsgClientTableImport( src.getOptionalJXMsgClientTableImport() );
		setOptionalJXMsgRqstTableBody( src.getOptionalJXMsgRqstTableBody() );
		setOptionalJXMsgRspnTableBody( src.getOptionalJXMsgRspnTableBody() );
		setOptionalJXMsgClientTableBody( src.getOptionalJXMsgClientTableBody() );
		setRequiredDefaultVisibility( src.getRequiredDefaultVisibility() );
	}
}
