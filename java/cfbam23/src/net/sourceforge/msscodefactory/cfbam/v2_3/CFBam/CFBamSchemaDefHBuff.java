// Description: Java7 implementation of a SchemaDef history buffer object.

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

public class CFBamSchemaDefHBuff
	extends CFBamScopeHBuff
	implements Comparable<Object>,
		Serializable
{
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long DOMAINID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final long DEFAULTLICENSETENANTID_INIT_VALUE = 0L;
	public static final long DEFAULTLICENSEID_INIT_VALUE = 0L;
	public final static boolean EXTENDCFCORE_INIT_VALUE = false;
	public static final short DATASCOPEID_INIT_VALUE = (short)0;
	public static final short VIEWACCESSSECURITYID_INIT_VALUE = (short)0;
	public static final short EDITACCESSSECURITYID_INIT_VALUE = (short)0;
	public static final short VIEWACCESSFREQUENCYID_INIT_VALUE = (short)0;
	public static final short EDITACCESSFREQUENCYID_INIT_VALUE = (short)0;
	public static final String COPYRIGHTPERIOD_INIT_VALUE = new String( "2014" );
	public static final String COPYRIGHTHOLDER_INIT_VALUE = new String( "YourNameHere" );
	public static final String PUBLISHURI_INIT_VALUE = new String( "" );
	public static final String JSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JSCHEMAOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String JSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JSCHEMAOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JDB2LUWSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JDB2LUWSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JDB2LUWSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JMSSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JMSSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JMSSQLSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JMYSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JMYSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JMYSQLSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JORACLESCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JORACLESCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JORACLESCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JPGSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JPGSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JPGSQLSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JSYBASESCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JSYBASESCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JSYBASESCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JRAMSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JRAMSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JRAMSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGSCHEMAIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGSCHEMAFORMATTERS_INIT_VALUE = new String( "" );
	public static final String JXMSGCLIENTSCHEMAIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGCLIENTSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTSCHEMAIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTSCHEMAWIREPARSERS_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTSCHEMAXSDSPEC_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTSCHEMAXSDELEMENTLIST_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNSCHEMAIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNSCHEMAWIREPARSERS_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNSCHEMAXSDELEMENTLIST_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNSCHEMAXSDSPEC_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long DOMAINID_MIN_VALUE = 0L;
	public static final long DEFAULTLICENSETENANTID_MIN_VALUE = 0L;
	public static final long DEFAULTLICENSEID_MIN_VALUE = 0L;
	public static final short DATASCOPEID_MIN_VALUE = (short)0;
	public static final short VIEWACCESSSECURITYID_MIN_VALUE = (short)0;
	public static final short EDITACCESSSECURITYID_MIN_VALUE = (short)0;
	public static final short VIEWACCESSFREQUENCYID_MIN_VALUE = (short)0;
	public static final short EDITACCESSFREQUENCYID_MIN_VALUE = (short)0;

	protected long requiredDomainId;
	protected String requiredName;
	protected String optionalDbName;
	protected String optionalShortName;
	protected String optionalLabel;
	protected String optionalShortDescription;
	protected String optionalDescription;
	protected Long optionalDefaultLicenseTenantId;
	protected Long optionalDefaultLicenseId;
	protected boolean requiredExtendCFCore;
	protected Short optionalDataScopeId;
	protected Short optionalViewAccessSecurityId;
	protected Short optionalEditAccessSecurityId;
	protected Short optionalViewAccessFrequencyId;
	protected Short optionalEditAccessFrequencyId;
	protected String requiredCopyrightPeriod;
	protected String requiredCopyrightHolder;
	protected String requiredPublishURI;
	protected String optionalJSchemaObjImport;
	protected String optionalJSchemaObjInterface;
	protected String optionalJSchemaObjMembers;
	protected String optionalJSchemaObjImplementation;
	protected String optionalJDb2LUWSchemaObjMembers;
	protected String optionalJDb2LUWSchemaObjImpl;
	protected String optionalJDb2LUWSchemaObjImport;
	protected String optionalJMSSqlSchemaObjMembers;
	protected String optionalJMSSqlSchemaObjImpl;
	protected String optionalJMSSqlSchemaObjImport;
	protected String optionalJMySqlSchemaObjMembers;
	protected String optionalJMySqlSchemaObjImpl;
	protected String optionalJMySqlSchemaObjImport;
	protected String optionalJOracleSchemaObjMembers;
	protected String optionalJOracleSchemaObjImpl;
	protected String optionalJOracleSchemaObjImport;
	protected String optionalJPgSqlSchemaObjMembers;
	protected String optionalJPgSqlSchemaObjImpl;
	protected String optionalJPgSqlSchemaObjImport;
	protected String optionalJSybaseSchemaObjMembers;
	protected String optionalJSybaseSchemaObjImpl;
	protected String optionalJSybaseSchemaObjImport;
	protected String optionalJRamSchemaObjMembers;
	protected String optionalJRamSchemaObjImpl;
	protected String optionalJRamSchemaObjImport;
	protected String optionalJXMsgSchemaImport;
	protected String optionalJXMsgSchemaFormatters;
	protected String optionalJXMsgClientSchemaImport;
	protected String optionalJXMsgClientSchemaBody;
	protected String optionalJXMsgRqstSchemaBody;
	protected String optionalJXMsgRqstSchemaImport;
	protected String optionalJXMsgRqstSchemaWireParsers;
	protected String optionalJXMsgRqstSchemaXsdSpec;
	protected String optionalJXMsgRqstSchemaXsdElementList;
	protected String optionalJXMsgRspnSchemaBody;
	protected String optionalJXMsgRspnSchemaImport;
	protected String optionalJXMsgRspnSchemaWireParsers;
	protected String optionalJXMsgRspnSchemaXsdElementList;
	protected String optionalJXMsgRspnSchemaXsdSpec;
	public CFBamSchemaDefHBuff() {
		super();
		requiredDomainId = CFBamSchemaDefBuff.DOMAINID_INIT_VALUE;
		requiredName = new String( CFBamSchemaDefBuff.NAME_INIT_VALUE );
		optionalDbName = null;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		optionalDefaultLicenseTenantId = null;
		optionalDefaultLicenseId = null;
		requiredExtendCFCore = CFBamSchemaDefBuff.EXTENDCFCORE_INIT_VALUE;
		optionalDataScopeId = null;
		optionalViewAccessSecurityId = null;
		optionalEditAccessSecurityId = null;
		optionalViewAccessFrequencyId = null;
		optionalEditAccessFrequencyId = null;
		requiredCopyrightPeriod = new String( CFBamSchemaDefBuff.COPYRIGHTPERIOD_INIT_VALUE );
		requiredCopyrightHolder = new String( CFBamSchemaDefBuff.COPYRIGHTHOLDER_INIT_VALUE );
		requiredPublishURI = new String( CFBamSchemaDefBuff.PUBLISHURI_INIT_VALUE );
		optionalJSchemaObjImport = null;
		optionalJSchemaObjInterface = null;
		optionalJSchemaObjMembers = null;
		optionalJSchemaObjImplementation = null;
		optionalJDb2LUWSchemaObjMembers = null;
		optionalJDb2LUWSchemaObjImpl = null;
		optionalJDb2LUWSchemaObjImport = null;
		optionalJMSSqlSchemaObjMembers = null;
		optionalJMSSqlSchemaObjImpl = null;
		optionalJMSSqlSchemaObjImport = null;
		optionalJMySqlSchemaObjMembers = null;
		optionalJMySqlSchemaObjImpl = null;
		optionalJMySqlSchemaObjImport = null;
		optionalJOracleSchemaObjMembers = null;
		optionalJOracleSchemaObjImpl = null;
		optionalJOracleSchemaObjImport = null;
		optionalJPgSqlSchemaObjMembers = null;
		optionalJPgSqlSchemaObjImpl = null;
		optionalJPgSqlSchemaObjImport = null;
		optionalJSybaseSchemaObjMembers = null;
		optionalJSybaseSchemaObjImpl = null;
		optionalJSybaseSchemaObjImport = null;
		optionalJRamSchemaObjMembers = null;
		optionalJRamSchemaObjImpl = null;
		optionalJRamSchemaObjImport = null;
		optionalJXMsgSchemaImport = null;
		optionalJXMsgSchemaFormatters = null;
		optionalJXMsgClientSchemaImport = null;
		optionalJXMsgClientSchemaBody = null;
		optionalJXMsgRqstSchemaBody = null;
		optionalJXMsgRqstSchemaImport = null;
		optionalJXMsgRqstSchemaWireParsers = null;
		optionalJXMsgRqstSchemaXsdSpec = null;
		optionalJXMsgRqstSchemaXsdElementList = null;
		optionalJXMsgRspnSchemaBody = null;
		optionalJXMsgRspnSchemaImport = null;
		optionalJXMsgRspnSchemaWireParsers = null;
		optionalJXMsgRspnSchemaXsdElementList = null;
		optionalJXMsgRspnSchemaXsdSpec = null;
	}

	public String getClassCode() {
		return( CFBamSchemaDefBuff.CLASS_CODE );
	}

	public long getRequiredDomainId() {
		return( requiredDomainId );
	}

	public void setRequiredDomainId( long value ) {
		if( value < CFBamSchemaDefBuff.DOMAINID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredDomainId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.DOMAINID_MIN_VALUE );
		}
		requiredDomainId = value;
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
		else if( value.length() > 12 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalDbName",
				1,
				"value.length()",
				value.length(),
				12 );
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
		else if( value.length() > 128 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				128 );
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
		else if( value.length() > 1023 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1023 );
		}
		else {
			optionalDescription = value;
		}
	}

	public Long getOptionalDefaultLicenseTenantId() {
		return( optionalDefaultLicenseTenantId );
	}

	public void setOptionalDefaultLicenseTenantId( Long value ) {
		if( value == null ) {
			optionalDefaultLicenseTenantId = null;
		}
		else if( value < CFBamSchemaDefBuff.DEFAULTLICENSETENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDefaultLicenseTenantId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.DEFAULTLICENSETENANTID_MIN_VALUE );
		}
		else {
			optionalDefaultLicenseTenantId = value;
		}
	}

	public Long getOptionalDefaultLicenseId() {
		return( optionalDefaultLicenseId );
	}

	public void setOptionalDefaultLicenseId( Long value ) {
		if( value == null ) {
			optionalDefaultLicenseId = null;
		}
		else if( value < CFBamSchemaDefBuff.DEFAULTLICENSEID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDefaultLicenseId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.DEFAULTLICENSEID_MIN_VALUE );
		}
		else {
			optionalDefaultLicenseId = value;
		}
	}

	public boolean getRequiredExtendCFCore() {
		return( requiredExtendCFCore );
	}

	public void setRequiredExtendCFCore( boolean value ) {
		requiredExtendCFCore = value;
	}

	public Short getOptionalDataScopeId() {
		return( optionalDataScopeId );
	}

	public void setOptionalDataScopeId( Short value ) {
		if( value == null ) {
			optionalDataScopeId = null;
		}
		else if( value < CFBamSchemaDefBuff.DATASCOPEID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDataScopeId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.DATASCOPEID_MIN_VALUE );
		}
		else {
			optionalDataScopeId = value;
		}
	}

	public Short getOptionalViewAccessSecurityId() {
		return( optionalViewAccessSecurityId );
	}

	public void setOptionalViewAccessSecurityId( Short value ) {
		if( value == null ) {
			optionalViewAccessSecurityId = null;
		}
		else if( value < CFBamSchemaDefBuff.VIEWACCESSSECURITYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalViewAccessSecurityId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.VIEWACCESSSECURITYID_MIN_VALUE );
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
		else if( value < CFBamSchemaDefBuff.EDITACCESSSECURITYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalEditAccessSecurityId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.EDITACCESSSECURITYID_MIN_VALUE );
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
		else if( value < CFBamSchemaDefBuff.VIEWACCESSFREQUENCYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalViewAccessFrequencyId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.VIEWACCESSFREQUENCYID_MIN_VALUE );
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
		else if( value < CFBamSchemaDefBuff.EDITACCESSFREQUENCYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalEditAccessFrequencyId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.EDITACCESSFREQUENCYID_MIN_VALUE );
		}
		else {
			optionalEditAccessFrequencyId = value;
		}
	}

	public String getRequiredCopyrightPeriod() {
		return( requiredCopyrightPeriod );
	}

	public void setRequiredCopyrightPeriod( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredCopyrightPeriod",
				1,
				"value" );
		}
		if( value.length() > 10 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredCopyrightPeriod",
				1,
				"value.length()",
				value.length(),
				10 );
		}
		requiredCopyrightPeriod = value;
	}

	public String getRequiredCopyrightHolder() {
		return( requiredCopyrightHolder );
	}

	public void setRequiredCopyrightHolder( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredCopyrightHolder",
				1,
				"value" );
		}
		if( value.length() > 511 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredCopyrightHolder",
				1,
				"value.length()",
				value.length(),
				511 );
		}
		requiredCopyrightHolder = value;
	}

	public String getRequiredPublishURI() {
		return( requiredPublishURI );
	}

	public void setRequiredPublishURI( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredPublishURI",
				1,
				"value" );
		}
		if( value.length() > 512 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredPublishURI",
				1,
				"value.length()",
				value.length(),
				512 );
		}
		requiredPublishURI = value;
	}

	public String getOptionalJSchemaObjImport() {
		return( optionalJSchemaObjImport );
	}

	public void setOptionalJSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSchemaObjImport = value;
		}
	}

	public String getOptionalJSchemaObjInterface() {
		return( optionalJSchemaObjInterface );
	}

	public void setOptionalJSchemaObjInterface( String value ) {
		if( value == null ) {
			optionalJSchemaObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSchemaObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSchemaObjInterface = value;
		}
	}

	public String getOptionalJSchemaObjMembers() {
		return( optionalJSchemaObjMembers );
	}

	public void setOptionalJSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSchemaObjMembers = value;
		}
	}

	public String getOptionalJSchemaObjImplementation() {
		return( optionalJSchemaObjImplementation );
	}

	public void setOptionalJSchemaObjImplementation( String value ) {
		if( value == null ) {
			optionalJSchemaObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSchemaObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSchemaObjImplementation = value;
		}
	}

	public String getOptionalJDb2LUWSchemaObjMembers() {
		return( optionalJDb2LUWSchemaObjMembers );
	}

	public void setOptionalJDb2LUWSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJDb2LUWSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWSchemaObjMembers = value;
		}
	}

	public String getOptionalJDb2LUWSchemaObjImpl() {
		return( optionalJDb2LUWSchemaObjImpl );
	}

	public void setOptionalJDb2LUWSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJDb2LUWSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWSchemaObjImpl = value;
		}
	}

	public String getOptionalJDb2LUWSchemaObjImport() {
		return( optionalJDb2LUWSchemaObjImport );
	}

	public void setOptionalJDb2LUWSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJDb2LUWSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWSchemaObjImport = value;
		}
	}

	public String getOptionalJMSSqlSchemaObjMembers() {
		return( optionalJMSSqlSchemaObjMembers );
	}

	public void setOptionalJMSSqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJMSSqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMSSqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlSchemaObjMembers = value;
		}
	}

	public String getOptionalJMSSqlSchemaObjImpl() {
		return( optionalJMSSqlSchemaObjImpl );
	}

	public void setOptionalJMSSqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJMSSqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMSSqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlSchemaObjImpl = value;
		}
	}

	public String getOptionalJMSSqlSchemaObjImport() {
		return( optionalJMSSqlSchemaObjImport );
	}

	public void setOptionalJMSSqlSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJMSSqlSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMSSqlSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlSchemaObjImport = value;
		}
	}

	public String getOptionalJMySqlSchemaObjMembers() {
		return( optionalJMySqlSchemaObjMembers );
	}

	public void setOptionalJMySqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJMySqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMySqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlSchemaObjMembers = value;
		}
	}

	public String getOptionalJMySqlSchemaObjImpl() {
		return( optionalJMySqlSchemaObjImpl );
	}

	public void setOptionalJMySqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJMySqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMySqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlSchemaObjImpl = value;
		}
	}

	public String getOptionalJMySqlSchemaObjImport() {
		return( optionalJMySqlSchemaObjImport );
	}

	public void setOptionalJMySqlSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJMySqlSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJMySqlSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlSchemaObjImport = value;
		}
	}

	public String getOptionalJOracleSchemaObjMembers() {
		return( optionalJOracleSchemaObjMembers );
	}

	public void setOptionalJOracleSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJOracleSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJOracleSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleSchemaObjMembers = value;
		}
	}

	public String getOptionalJOracleSchemaObjImpl() {
		return( optionalJOracleSchemaObjImpl );
	}

	public void setOptionalJOracleSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJOracleSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJOracleSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleSchemaObjImpl = value;
		}
	}

	public String getOptionalJOracleSchemaObjImport() {
		return( optionalJOracleSchemaObjImport );
	}

	public void setOptionalJOracleSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJOracleSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJOracleSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleSchemaObjImport = value;
		}
	}

	public String getOptionalJPgSqlSchemaObjMembers() {
		return( optionalJPgSqlSchemaObjMembers );
	}

	public void setOptionalJPgSqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJPgSqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJPgSqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlSchemaObjMembers = value;
		}
	}

	public String getOptionalJPgSqlSchemaObjImpl() {
		return( optionalJPgSqlSchemaObjImpl );
	}

	public void setOptionalJPgSqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJPgSqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJPgSqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlSchemaObjImpl = value;
		}
	}

	public String getOptionalJPgSqlSchemaObjImport() {
		return( optionalJPgSqlSchemaObjImport );
	}

	public void setOptionalJPgSqlSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJPgSqlSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJPgSqlSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlSchemaObjImport = value;
		}
	}

	public String getOptionalJSybaseSchemaObjMembers() {
		return( optionalJSybaseSchemaObjMembers );
	}

	public void setOptionalJSybaseSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJSybaseSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSybaseSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSybaseSchemaObjMembers = value;
		}
	}

	public String getOptionalJSybaseSchemaObjImpl() {
		return( optionalJSybaseSchemaObjImpl );
	}

	public void setOptionalJSybaseSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJSybaseSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSybaseSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSybaseSchemaObjImpl = value;
		}
	}

	public String getOptionalJSybaseSchemaObjImport() {
		return( optionalJSybaseSchemaObjImport );
	}

	public void setOptionalJSybaseSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJSybaseSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJSybaseSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSybaseSchemaObjImport = value;
		}
	}

	public String getOptionalJRamSchemaObjMembers() {
		return( optionalJRamSchemaObjMembers );
	}

	public void setOptionalJRamSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJRamSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJRamSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamSchemaObjMembers = value;
		}
	}

	public String getOptionalJRamSchemaObjImpl() {
		return( optionalJRamSchemaObjImpl );
	}

	public void setOptionalJRamSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJRamSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJRamSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamSchemaObjImpl = value;
		}
	}

	public String getOptionalJRamSchemaObjImport() {
		return( optionalJRamSchemaObjImport );
	}

	public void setOptionalJRamSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJRamSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJRamSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamSchemaObjImport = value;
		}
	}

	public String getOptionalJXMsgSchemaImport() {
		return( optionalJXMsgSchemaImport );
	}

	public void setOptionalJXMsgSchemaImport( String value ) {
		if( value == null ) {
			optionalJXMsgSchemaImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgSchemaImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgSchemaImport = value;
		}
	}

	public String getOptionalJXMsgSchemaFormatters() {
		return( optionalJXMsgSchemaFormatters );
	}

	public void setOptionalJXMsgSchemaFormatters( String value ) {
		if( value == null ) {
			optionalJXMsgSchemaFormatters = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgSchemaFormatters",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgSchemaFormatters = value;
		}
	}

	public String getOptionalJXMsgClientSchemaImport() {
		return( optionalJXMsgClientSchemaImport );
	}

	public void setOptionalJXMsgClientSchemaImport( String value ) {
		if( value == null ) {
			optionalJXMsgClientSchemaImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgClientSchemaImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgClientSchemaImport = value;
		}
	}

	public String getOptionalJXMsgClientSchemaBody() {
		return( optionalJXMsgClientSchemaBody );
	}

	public void setOptionalJXMsgClientSchemaBody( String value ) {
		if( value == null ) {
			optionalJXMsgClientSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgClientSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgClientSchemaBody = value;
		}
	}

	public String getOptionalJXMsgRqstSchemaBody() {
		return( optionalJXMsgRqstSchemaBody );
	}

	public void setOptionalJXMsgRqstSchemaBody( String value ) {
		if( value == null ) {
			optionalJXMsgRqstSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstSchemaBody = value;
		}
	}

	public String getOptionalJXMsgRqstSchemaImport() {
		return( optionalJXMsgRqstSchemaImport );
	}

	public void setOptionalJXMsgRqstSchemaImport( String value ) {
		if( value == null ) {
			optionalJXMsgRqstSchemaImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstSchemaImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstSchemaImport = value;
		}
	}

	public String getOptionalJXMsgRqstSchemaWireParsers() {
		return( optionalJXMsgRqstSchemaWireParsers );
	}

	public void setOptionalJXMsgRqstSchemaWireParsers( String value ) {
		if( value == null ) {
			optionalJXMsgRqstSchemaWireParsers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstSchemaWireParsers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstSchemaWireParsers = value;
		}
	}

	public String getOptionalJXMsgRqstSchemaXsdSpec() {
		return( optionalJXMsgRqstSchemaXsdSpec );
	}

	public void setOptionalJXMsgRqstSchemaXsdSpec( String value ) {
		if( value == null ) {
			optionalJXMsgRqstSchemaXsdSpec = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstSchemaXsdSpec",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstSchemaXsdSpec = value;
		}
	}

	public String getOptionalJXMsgRqstSchemaXsdElementList() {
		return( optionalJXMsgRqstSchemaXsdElementList );
	}

	public void setOptionalJXMsgRqstSchemaXsdElementList( String value ) {
		if( value == null ) {
			optionalJXMsgRqstSchemaXsdElementList = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstSchemaXsdElementList",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstSchemaXsdElementList = value;
		}
	}

	public String getOptionalJXMsgRspnSchemaBody() {
		return( optionalJXMsgRspnSchemaBody );
	}

	public void setOptionalJXMsgRspnSchemaBody( String value ) {
		if( value == null ) {
			optionalJXMsgRspnSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnSchemaBody = value;
		}
	}

	public String getOptionalJXMsgRspnSchemaImport() {
		return( optionalJXMsgRspnSchemaImport );
	}

	public void setOptionalJXMsgRspnSchemaImport( String value ) {
		if( value == null ) {
			optionalJXMsgRspnSchemaImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnSchemaImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnSchemaImport = value;
		}
	}

	public String getOptionalJXMsgRspnSchemaWireParsers() {
		return( optionalJXMsgRspnSchemaWireParsers );
	}

	public void setOptionalJXMsgRspnSchemaWireParsers( String value ) {
		if( value == null ) {
			optionalJXMsgRspnSchemaWireParsers = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnSchemaWireParsers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnSchemaWireParsers = value;
		}
	}

	public String getOptionalJXMsgRspnSchemaXsdElementList() {
		return( optionalJXMsgRspnSchemaXsdElementList );
	}

	public void setOptionalJXMsgRspnSchemaXsdElementList( String value ) {
		if( value == null ) {
			optionalJXMsgRspnSchemaXsdElementList = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnSchemaXsdElementList",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnSchemaXsdElementList = value;
		}
	}

	public String getOptionalJXMsgRspnSchemaXsdSpec() {
		return( optionalJXMsgRspnSchemaXsdSpec );
	}

	public void setOptionalJXMsgRspnSchemaXsdSpec( String value ) {
		if( value == null ) {
			optionalJXMsgRspnSchemaXsdSpec = null;
		}
		else if( value.length() > 2000000 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnSchemaXsdSpec",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnSchemaXsdSpec = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSchemaDefHBuff ) {
			CFBamSchemaDefHBuff rhs = (CFBamSchemaDefHBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredDomainId() != rhs.getRequiredDomainId() ) {
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
			if( getOptionalDefaultLicenseTenantId() != null ) {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					if( ! getOptionalDefaultLicenseTenantId().equals( rhs.getOptionalDefaultLicenseTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					if( ! getOptionalDefaultLicenseId().equals( rhs.getOptionalDefaultLicenseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( false );
				}
			}
			if( getRequiredExtendCFCore() != rhs.getRequiredExtendCFCore() ) {
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
			if( ! getRequiredCopyrightPeriod().equals( rhs.getRequiredCopyrightPeriod() ) ) {
				return( false );
			}
			if( ! getRequiredCopyrightHolder().equals( rhs.getRequiredCopyrightHolder() ) ) {
				return( false );
			}
			if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
				return( false );
			}
			if( getOptionalJSchemaObjImport() != null ) {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					if( ! getOptionalJSchemaObjImport().equals( rhs.getOptionalJSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjInterface() != null ) {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					if( ! getOptionalJSchemaObjInterface().equals( rhs.getOptionalJSchemaObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjMembers() != null ) {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					if( ! getOptionalJSchemaObjMembers().equals( rhs.getOptionalJSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjImplementation() != null ) {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					if( ! getOptionalJSchemaObjImplementation().equals( rhs.getOptionalJSchemaObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjMembers().equals( rhs.getOptionalJDb2LUWSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjImpl().equals( rhs.getOptionalJDb2LUWSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImport() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjImport().equals( rhs.getOptionalJDb2LUWSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					if( ! getOptionalJMSSqlSchemaObjMembers().equals( rhs.getOptionalJMSSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					if( ! getOptionalJMSSqlSchemaObjImpl().equals( rhs.getOptionalJMSSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					if( ! getOptionalJMSSqlSchemaObjImport().equals( rhs.getOptionalJMSSqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					if( ! getOptionalJMySqlSchemaObjMembers().equals( rhs.getOptionalJMySqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					if( ! getOptionalJMySqlSchemaObjImpl().equals( rhs.getOptionalJMySqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					if( ! getOptionalJMySqlSchemaObjImport().equals( rhs.getOptionalJMySqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					if( ! getOptionalJOracleSchemaObjMembers().equals( rhs.getOptionalJOracleSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					if( ! getOptionalJOracleSchemaObjImpl().equals( rhs.getOptionalJOracleSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjImport() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					if( ! getOptionalJOracleSchemaObjImport().equals( rhs.getOptionalJOracleSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					if( ! getOptionalJPgSqlSchemaObjMembers().equals( rhs.getOptionalJPgSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					if( ! getOptionalJPgSqlSchemaObjImpl().equals( rhs.getOptionalJPgSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					if( ! getOptionalJPgSqlSchemaObjImport().equals( rhs.getOptionalJPgSqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseSchemaObjMembers() != null ) {
				if( rhs.getOptionalJSybaseSchemaObjMembers() != null ) {
					if( ! getOptionalJSybaseSchemaObjMembers().equals( rhs.getOptionalJSybaseSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseSchemaObjImpl() != null ) {
				if( rhs.getOptionalJSybaseSchemaObjImpl() != null ) {
					if( ! getOptionalJSybaseSchemaObjImpl().equals( rhs.getOptionalJSybaseSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseSchemaObjImport() != null ) {
				if( rhs.getOptionalJSybaseSchemaObjImport() != null ) {
					if( ! getOptionalJSybaseSchemaObjImport().equals( rhs.getOptionalJSybaseSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					if( ! getOptionalJRamSchemaObjMembers().equals( rhs.getOptionalJRamSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					if( ! getOptionalJRamSchemaObjImpl().equals( rhs.getOptionalJRamSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjImport() != null ) {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					if( ! getOptionalJRamSchemaObjImport().equals( rhs.getOptionalJRamSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					if( ! getOptionalJXMsgSchemaImport().equals( rhs.getOptionalJXMsgSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					if( ! getOptionalJXMsgSchemaFormatters().equals( rhs.getOptionalJXMsgSchemaFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					if( ! getOptionalJXMsgClientSchemaImport().equals( rhs.getOptionalJXMsgClientSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					if( ! getOptionalJXMsgClientSchemaBody().equals( rhs.getOptionalJXMsgClientSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					if( ! getOptionalJXMsgRqstSchemaBody().equals( rhs.getOptionalJXMsgRqstSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					if( ! getOptionalJXMsgRqstSchemaImport().equals( rhs.getOptionalJXMsgRqstSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					if( ! getOptionalJXMsgRqstSchemaWireParsers().equals( rhs.getOptionalJXMsgRqstSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					if( ! getOptionalJXMsgRqstSchemaXsdSpec().equals( rhs.getOptionalJXMsgRqstSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					if( ! getOptionalJXMsgRqstSchemaXsdElementList().equals( rhs.getOptionalJXMsgRqstSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					if( ! getOptionalJXMsgRspnSchemaBody().equals( rhs.getOptionalJXMsgRspnSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					if( ! getOptionalJXMsgRspnSchemaImport().equals( rhs.getOptionalJXMsgRspnSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					if( ! getOptionalJXMsgRspnSchemaWireParsers().equals( rhs.getOptionalJXMsgRspnSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					if( ! getOptionalJXMsgRspnSchemaXsdElementList().equals( rhs.getOptionalJXMsgRspnSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					if( ! getOptionalJXMsgRspnSchemaXsdSpec().equals( rhs.getOptionalJXMsgRspnSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredDomainId() != rhs.getRequiredDomainId() ) {
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
			if( getOptionalDefaultLicenseTenantId() != null ) {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					if( ! getOptionalDefaultLicenseTenantId().equals( rhs.getOptionalDefaultLicenseTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					if( ! getOptionalDefaultLicenseId().equals( rhs.getOptionalDefaultLicenseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( false );
				}
			}
			if( getRequiredExtendCFCore() != rhs.getRequiredExtendCFCore() ) {
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
			if( ! getRequiredCopyrightPeriod().equals( rhs.getRequiredCopyrightPeriod() ) ) {
				return( false );
			}
			if( ! getRequiredCopyrightHolder().equals( rhs.getRequiredCopyrightHolder() ) ) {
				return( false );
			}
			if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
				return( false );
			}
			if( getOptionalJSchemaObjImport() != null ) {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					if( ! getOptionalJSchemaObjImport().equals( rhs.getOptionalJSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjInterface() != null ) {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					if( ! getOptionalJSchemaObjInterface().equals( rhs.getOptionalJSchemaObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjMembers() != null ) {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					if( ! getOptionalJSchemaObjMembers().equals( rhs.getOptionalJSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjImplementation() != null ) {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					if( ! getOptionalJSchemaObjImplementation().equals( rhs.getOptionalJSchemaObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjMembers().equals( rhs.getOptionalJDb2LUWSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjImpl().equals( rhs.getOptionalJDb2LUWSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImport() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjImport().equals( rhs.getOptionalJDb2LUWSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					if( ! getOptionalJMSSqlSchemaObjMembers().equals( rhs.getOptionalJMSSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					if( ! getOptionalJMSSqlSchemaObjImpl().equals( rhs.getOptionalJMSSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					if( ! getOptionalJMSSqlSchemaObjImport().equals( rhs.getOptionalJMSSqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					if( ! getOptionalJMySqlSchemaObjMembers().equals( rhs.getOptionalJMySqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					if( ! getOptionalJMySqlSchemaObjImpl().equals( rhs.getOptionalJMySqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					if( ! getOptionalJMySqlSchemaObjImport().equals( rhs.getOptionalJMySqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					if( ! getOptionalJOracleSchemaObjMembers().equals( rhs.getOptionalJOracleSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					if( ! getOptionalJOracleSchemaObjImpl().equals( rhs.getOptionalJOracleSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjImport() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					if( ! getOptionalJOracleSchemaObjImport().equals( rhs.getOptionalJOracleSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					if( ! getOptionalJPgSqlSchemaObjMembers().equals( rhs.getOptionalJPgSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					if( ! getOptionalJPgSqlSchemaObjImpl().equals( rhs.getOptionalJPgSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					if( ! getOptionalJPgSqlSchemaObjImport().equals( rhs.getOptionalJPgSqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseSchemaObjMembers() != null ) {
				if( rhs.getOptionalJSybaseSchemaObjMembers() != null ) {
					if( ! getOptionalJSybaseSchemaObjMembers().equals( rhs.getOptionalJSybaseSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseSchemaObjImpl() != null ) {
				if( rhs.getOptionalJSybaseSchemaObjImpl() != null ) {
					if( ! getOptionalJSybaseSchemaObjImpl().equals( rhs.getOptionalJSybaseSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJSybaseSchemaObjImport() != null ) {
				if( rhs.getOptionalJSybaseSchemaObjImport() != null ) {
					if( ! getOptionalJSybaseSchemaObjImport().equals( rhs.getOptionalJSybaseSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSybaseSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					if( ! getOptionalJRamSchemaObjMembers().equals( rhs.getOptionalJRamSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					if( ! getOptionalJRamSchemaObjImpl().equals( rhs.getOptionalJRamSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjImport() != null ) {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					if( ! getOptionalJRamSchemaObjImport().equals( rhs.getOptionalJRamSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					if( ! getOptionalJXMsgSchemaImport().equals( rhs.getOptionalJXMsgSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					if( ! getOptionalJXMsgSchemaFormatters().equals( rhs.getOptionalJXMsgSchemaFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					if( ! getOptionalJXMsgClientSchemaImport().equals( rhs.getOptionalJXMsgClientSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					if( ! getOptionalJXMsgClientSchemaBody().equals( rhs.getOptionalJXMsgClientSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					if( ! getOptionalJXMsgRqstSchemaBody().equals( rhs.getOptionalJXMsgRqstSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					if( ! getOptionalJXMsgRqstSchemaImport().equals( rhs.getOptionalJXMsgRqstSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					if( ! getOptionalJXMsgRqstSchemaWireParsers().equals( rhs.getOptionalJXMsgRqstSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					if( ! getOptionalJXMsgRqstSchemaXsdSpec().equals( rhs.getOptionalJXMsgRqstSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					if( ! getOptionalJXMsgRqstSchemaXsdElementList().equals( rhs.getOptionalJXMsgRqstSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					if( ! getOptionalJXMsgRspnSchemaBody().equals( rhs.getOptionalJXMsgRspnSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					if( ! getOptionalJXMsgRspnSchemaImport().equals( rhs.getOptionalJXMsgRspnSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					if( ! getOptionalJXMsgRspnSchemaWireParsers().equals( rhs.getOptionalJXMsgRspnSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					if( ! getOptionalJXMsgRspnSchemaXsdElementList().equals( rhs.getOptionalJXMsgRspnSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					if( ! getOptionalJXMsgRspnSchemaXsdSpec().equals( rhs.getOptionalJXMsgRspnSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByCTenantIdxKey ) {
			CFBamSchemaDefByCTenantIdxKey rhs = (CFBamSchemaDefByCTenantIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByDomainIdxKey ) {
			CFBamSchemaDefByDomainIdxKey rhs = (CFBamSchemaDefByDomainIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredDomainId() != rhs.getRequiredDomainId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByUNameIdxKey ) {
			CFBamSchemaDefByUNameIdxKey rhs = (CFBamSchemaDefByUNameIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredDomainId() != rhs.getRequiredDomainId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByDefLcnIdxKey ) {
			CFBamSchemaDefByDefLcnIdxKey rhs = (CFBamSchemaDefByDefLcnIdxKey)obj;
			if( getOptionalDefaultLicenseTenantId() != null ) {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					if( ! getOptionalDefaultLicenseTenantId().equals( rhs.getOptionalDefaultLicenseTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					if( ! getOptionalDefaultLicenseId().equals( rhs.getOptionalDefaultLicenseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByDataScopeIdxKey ) {
			CFBamSchemaDefByDataScopeIdxKey rhs = (CFBamSchemaDefByDataScopeIdxKey)obj;
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
		else if( obj instanceof CFBamSchemaDefByVAccSecIdxKey ) {
			CFBamSchemaDefByVAccSecIdxKey rhs = (CFBamSchemaDefByVAccSecIdxKey)obj;
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
		else if( obj instanceof CFBamSchemaDefByVAccFreqIdxKey ) {
			CFBamSchemaDefByVAccFreqIdxKey rhs = (CFBamSchemaDefByVAccFreqIdxKey)obj;
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
		else if( obj instanceof CFBamSchemaDefByEAccSecIdxKey ) {
			CFBamSchemaDefByEAccSecIdxKey rhs = (CFBamSchemaDefByEAccSecIdxKey)obj;
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
		else if( obj instanceof CFBamSchemaDefByEAccFreqIdxKey ) {
			CFBamSchemaDefByEAccFreqIdxKey rhs = (CFBamSchemaDefByEAccFreqIdxKey)obj;
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
		else if( obj instanceof CFBamSchemaDefByPubURIIdxKey ) {
			CFBamSchemaDefByPubURIIdxKey rhs = (CFBamSchemaDefByPubURIIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
				return( false );
			}
			return( true );
		}
		else {
			return( super.equals( obj ) );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + (int)( getRequiredDomainId() );
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
		if( getOptionalDefaultLicenseTenantId() != null ) {
			hashCode = hashCode + getOptionalDefaultLicenseTenantId().hashCode();
		}
		if( getOptionalDefaultLicenseId() != null ) {
			hashCode = hashCode + getOptionalDefaultLicenseId().hashCode();
		}
		if( getRequiredExtendCFCore() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getOptionalDataScopeId() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalDataScopeId();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
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
		if( getRequiredCopyrightPeriod() != null ) {
			hashCode = hashCode + getRequiredCopyrightPeriod().hashCode();
		}
		if( getRequiredCopyrightHolder() != null ) {
			hashCode = hashCode + getRequiredCopyrightHolder().hashCode();
		}
		if( getRequiredPublishURI() != null ) {
			hashCode = hashCode + getRequiredPublishURI().hashCode();
		}
		if( getOptionalJSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJSchemaObjImport().hashCode();
		}
		if( getOptionalJSchemaObjInterface() != null ) {
			hashCode = hashCode + getOptionalJSchemaObjInterface().hashCode();
		}
		if( getOptionalJSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJSchemaObjMembers().hashCode();
		}
		if( getOptionalJSchemaObjImplementation() != null ) {
			hashCode = hashCode + getOptionalJSchemaObjImplementation().hashCode();
		}
		if( getOptionalJDb2LUWSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWSchemaObjMembers().hashCode();
		}
		if( getOptionalJDb2LUWSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWSchemaObjImpl().hashCode();
		}
		if( getOptionalJDb2LUWSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWSchemaObjImport().hashCode();
		}
		if( getOptionalJMSSqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJMSSqlSchemaObjMembers().hashCode();
		}
		if( getOptionalJMSSqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJMSSqlSchemaObjImpl().hashCode();
		}
		if( getOptionalJMSSqlSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJMSSqlSchemaObjImport().hashCode();
		}
		if( getOptionalJMySqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJMySqlSchemaObjMembers().hashCode();
		}
		if( getOptionalJMySqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJMySqlSchemaObjImpl().hashCode();
		}
		if( getOptionalJMySqlSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJMySqlSchemaObjImport().hashCode();
		}
		if( getOptionalJOracleSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJOracleSchemaObjMembers().hashCode();
		}
		if( getOptionalJOracleSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJOracleSchemaObjImpl().hashCode();
		}
		if( getOptionalJOracleSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJOracleSchemaObjImport().hashCode();
		}
		if( getOptionalJPgSqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJPgSqlSchemaObjMembers().hashCode();
		}
		if( getOptionalJPgSqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJPgSqlSchemaObjImpl().hashCode();
		}
		if( getOptionalJPgSqlSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJPgSqlSchemaObjImport().hashCode();
		}
		if( getOptionalJSybaseSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJSybaseSchemaObjMembers().hashCode();
		}
		if( getOptionalJSybaseSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJSybaseSchemaObjImpl().hashCode();
		}
		if( getOptionalJSybaseSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJSybaseSchemaObjImport().hashCode();
		}
		if( getOptionalJRamSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJRamSchemaObjMembers().hashCode();
		}
		if( getOptionalJRamSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJRamSchemaObjImpl().hashCode();
		}
		if( getOptionalJRamSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJRamSchemaObjImport().hashCode();
		}
		if( getOptionalJXMsgSchemaImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgSchemaImport().hashCode();
		}
		if( getOptionalJXMsgSchemaFormatters() != null ) {
			hashCode = hashCode + getOptionalJXMsgSchemaFormatters().hashCode();
		}
		if( getOptionalJXMsgClientSchemaImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgClientSchemaImport().hashCode();
		}
		if( getOptionalJXMsgClientSchemaBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgClientSchemaBody().hashCode();
		}
		if( getOptionalJXMsgRqstSchemaBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstSchemaBody().hashCode();
		}
		if( getOptionalJXMsgRqstSchemaImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstSchemaImport().hashCode();
		}
		if( getOptionalJXMsgRqstSchemaWireParsers() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstSchemaWireParsers().hashCode();
		}
		if( getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstSchemaXsdSpec().hashCode();
		}
		if( getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstSchemaXsdElementList().hashCode();
		}
		if( getOptionalJXMsgRspnSchemaBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnSchemaBody().hashCode();
		}
		if( getOptionalJXMsgRspnSchemaImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnSchemaImport().hashCode();
		}
		if( getOptionalJXMsgRspnSchemaWireParsers() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnSchemaWireParsers().hashCode();
		}
		if( getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnSchemaXsdElementList().hashCode();
		}
		if( getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnSchemaXsdSpec().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByCTenantIdxKey ) {
			CFBamSchemaDefByCTenantIdxKey rhs = (CFBamSchemaDefByCTenantIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByDomainIdxKey ) {
			CFBamSchemaDefByDomainIdxKey rhs = (CFBamSchemaDefByDomainIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredDomainId() < rhs.getRequiredDomainId() ) {
				return( -1 );
			}
			else if( getRequiredDomainId() > rhs.getRequiredDomainId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByUNameIdxKey ) {
			CFBamSchemaDefByUNameIdxKey rhs = (CFBamSchemaDefByUNameIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredDomainId() < rhs.getRequiredDomainId() ) {
				return( -1 );
			}
			else if( getRequiredDomainId() > rhs.getRequiredDomainId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByDefLcnIdxKey ) {
			CFBamSchemaDefByDefLcnIdxKey rhs = (CFBamSchemaDefByDefLcnIdxKey)obj;

			if( getOptionalDefaultLicenseTenantId() != null ) {
				Long lhsDefaultLicenseTenantId = getOptionalDefaultLicenseTenantId();
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					Long rhsDefaultLicenseTenantId = rhs.getOptionalDefaultLicenseTenantId();
					int cmp = lhsDefaultLicenseTenantId.compareTo( rhsDefaultLicenseTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				Long lhsDefaultLicenseId = getOptionalDefaultLicenseId();
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					Long rhsDefaultLicenseId = rhs.getOptionalDefaultLicenseId();
					int cmp = lhsDefaultLicenseId.compareTo( rhsDefaultLicenseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByDataScopeIdxKey ) {
			CFBamSchemaDefByDataScopeIdxKey rhs = (CFBamSchemaDefByDataScopeIdxKey)obj;

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
		else if( obj instanceof CFBamSchemaDefByVAccSecIdxKey ) {
			CFBamSchemaDefByVAccSecIdxKey rhs = (CFBamSchemaDefByVAccSecIdxKey)obj;

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
		else if( obj instanceof CFBamSchemaDefByVAccFreqIdxKey ) {
			CFBamSchemaDefByVAccFreqIdxKey rhs = (CFBamSchemaDefByVAccFreqIdxKey)obj;

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
		else if( obj instanceof CFBamSchemaDefByEAccSecIdxKey ) {
			CFBamSchemaDefByEAccSecIdxKey rhs = (CFBamSchemaDefByEAccSecIdxKey)obj;

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
		else if( obj instanceof CFBamSchemaDefByEAccFreqIdxKey ) {
			CFBamSchemaDefByEAccFreqIdxKey rhs = (CFBamSchemaDefByEAccFreqIdxKey)obj;

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
		else if( obj instanceof CFBamSchemaDefByPubURIIdxKey ) {
			CFBamSchemaDefByPubURIIdxKey rhs = (CFBamSchemaDefByPubURIIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefHBuff ) {
			CFBamSchemaDefHBuff rhs = (CFBamSchemaDefHBuff)obj;

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
			if( getRequiredDomainId() < rhs.getRequiredDomainId() ) {
				return( -1 );
			}
			else if( getRequiredDomainId() > rhs.getRequiredDomainId() ) {
				return( 1 );
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
			if( getOptionalDefaultLicenseTenantId() != null ) {
				Long lhsDefaultLicenseTenantId = getOptionalDefaultLicenseTenantId();
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					Long rhsDefaultLicenseTenantId = rhs.getOptionalDefaultLicenseTenantId();
					int cmp = lhsDefaultLicenseTenantId.compareTo( rhsDefaultLicenseTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				Long lhsDefaultLicenseId = getOptionalDefaultLicenseId();
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					Long rhsDefaultLicenseId = rhs.getOptionalDefaultLicenseId();
					int cmp = lhsDefaultLicenseId.compareTo( rhsDefaultLicenseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredExtendCFCore() ) {
				if( ! rhs.getRequiredExtendCFCore() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredExtendCFCore() ) {
					return( -1 );
				}
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
			{
				int cmp = getRequiredCopyrightPeriod().compareTo( rhs.getRequiredCopyrightPeriod() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredCopyrightHolder().compareTo( rhs.getRequiredCopyrightHolder() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalJSchemaObjImport() != null ) {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					int cmp = getOptionalJSchemaObjImport().compareTo( rhs.getOptionalJSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSchemaObjInterface() != null ) {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					int cmp = getOptionalJSchemaObjInterface().compareTo( rhs.getOptionalJSchemaObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSchemaObjMembers() != null ) {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					int cmp = getOptionalJSchemaObjMembers().compareTo( rhs.getOptionalJSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSchemaObjImplementation() != null ) {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					int cmp = getOptionalJSchemaObjImplementation().compareTo( rhs.getOptionalJSchemaObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					int cmp = getOptionalJDb2LUWSchemaObjMembers().compareTo( rhs.getOptionalJDb2LUWSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					int cmp = getOptionalJDb2LUWSchemaObjImpl().compareTo( rhs.getOptionalJDb2LUWSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImport() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					int cmp = getOptionalJDb2LUWSchemaObjImport().compareTo( rhs.getOptionalJDb2LUWSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalJMSSqlSchemaObjMembers().compareTo( rhs.getOptionalJMSSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalJMSSqlSchemaObjImpl().compareTo( rhs.getOptionalJMSSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					int cmp = getOptionalJMSSqlSchemaObjImport().compareTo( rhs.getOptionalJMSSqlSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					int cmp = getOptionalJMySqlSchemaObjMembers().compareTo( rhs.getOptionalJMySqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					int cmp = getOptionalJMySqlSchemaObjImpl().compareTo( rhs.getOptionalJMySqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					int cmp = getOptionalJMySqlSchemaObjImport().compareTo( rhs.getOptionalJMySqlSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					int cmp = getOptionalJOracleSchemaObjMembers().compareTo( rhs.getOptionalJOracleSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					int cmp = getOptionalJOracleSchemaObjImpl().compareTo( rhs.getOptionalJOracleSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleSchemaObjImport() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					int cmp = getOptionalJOracleSchemaObjImport().compareTo( rhs.getOptionalJOracleSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalJPgSqlSchemaObjMembers().compareTo( rhs.getOptionalJPgSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalJPgSqlSchemaObjImpl().compareTo( rhs.getOptionalJPgSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					int cmp = getOptionalJPgSqlSchemaObjImport().compareTo( rhs.getOptionalJPgSqlSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSybaseSchemaObjMembers() != null ) {
				if( rhs.getOptionalJSybaseSchemaObjMembers() != null ) {
					int cmp = getOptionalJSybaseSchemaObjMembers().compareTo( rhs.getOptionalJSybaseSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSybaseSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSybaseSchemaObjImpl() != null ) {
				if( rhs.getOptionalJSybaseSchemaObjImpl() != null ) {
					int cmp = getOptionalJSybaseSchemaObjImpl().compareTo( rhs.getOptionalJSybaseSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSybaseSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSybaseSchemaObjImport() != null ) {
				if( rhs.getOptionalJSybaseSchemaObjImport() != null ) {
					int cmp = getOptionalJSybaseSchemaObjImport().compareTo( rhs.getOptionalJSybaseSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSybaseSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					int cmp = getOptionalJRamSchemaObjMembers().compareTo( rhs.getOptionalJRamSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					int cmp = getOptionalJRamSchemaObjImpl().compareTo( rhs.getOptionalJRamSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamSchemaObjImport() != null ) {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					int cmp = getOptionalJRamSchemaObjImport().compareTo( rhs.getOptionalJRamSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					int cmp = getOptionalJXMsgSchemaImport().compareTo( rhs.getOptionalJXMsgSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					int cmp = getOptionalJXMsgSchemaFormatters().compareTo( rhs.getOptionalJXMsgSchemaFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgClientSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					int cmp = getOptionalJXMsgClientSchemaImport().compareTo( rhs.getOptionalJXMsgClientSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					int cmp = getOptionalJXMsgClientSchemaBody().compareTo( rhs.getOptionalJXMsgClientSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaBody().compareTo( rhs.getOptionalJXMsgRqstSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaImport().compareTo( rhs.getOptionalJXMsgRqstSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaWireParsers().compareTo( rhs.getOptionalJXMsgRqstSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaXsdSpec().compareTo( rhs.getOptionalJXMsgRqstSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaXsdElementList().compareTo( rhs.getOptionalJXMsgRqstSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaBody().compareTo( rhs.getOptionalJXMsgRspnSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaImport().compareTo( rhs.getOptionalJXMsgRspnSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaWireParsers().compareTo( rhs.getOptionalJXMsgRspnSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaXsdElementList().compareTo( rhs.getOptionalJXMsgRspnSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaXsdSpec().compareTo( rhs.getOptionalJXMsgRspnSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
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
		if( src instanceof CFBamSchemaDefBuff ) {
			setSchemaDefBuff( (CFBamSchemaDefBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamSchemaDefBuff" );
		}
	}

	public void setSchemaDefBuff( CFBamSchemaDefBuff src ) {
		super.setScopeBuff( src );
		setRequiredDomainId( src.getRequiredDomainId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setOptionalDefaultLicenseTenantId( src.getOptionalDefaultLicenseTenantId() );
		setOptionalDefaultLicenseId( src.getOptionalDefaultLicenseId() );
		setRequiredExtendCFCore( src.getRequiredExtendCFCore() );
		setOptionalDataScopeId( src.getOptionalDataScopeId() );
		setOptionalViewAccessSecurityId( src.getOptionalViewAccessSecurityId() );
		setOptionalEditAccessSecurityId( src.getOptionalEditAccessSecurityId() );
		setOptionalViewAccessFrequencyId( src.getOptionalViewAccessFrequencyId() );
		setOptionalEditAccessFrequencyId( src.getOptionalEditAccessFrequencyId() );
		setRequiredCopyrightPeriod( src.getRequiredCopyrightPeriod() );
		setRequiredCopyrightHolder( src.getRequiredCopyrightHolder() );
		setRequiredPublishURI( src.getRequiredPublishURI() );
		setOptionalJSchemaObjImport( src.getOptionalJSchemaObjImport() );
		setOptionalJSchemaObjInterface( src.getOptionalJSchemaObjInterface() );
		setOptionalJSchemaObjMembers( src.getOptionalJSchemaObjMembers() );
		setOptionalJSchemaObjImplementation( src.getOptionalJSchemaObjImplementation() );
		setOptionalJDb2LUWSchemaObjMembers( src.getOptionalJDb2LUWSchemaObjMembers() );
		setOptionalJDb2LUWSchemaObjImpl( src.getOptionalJDb2LUWSchemaObjImpl() );
		setOptionalJDb2LUWSchemaObjImport( src.getOptionalJDb2LUWSchemaObjImport() );
		setOptionalJMSSqlSchemaObjMembers( src.getOptionalJMSSqlSchemaObjMembers() );
		setOptionalJMSSqlSchemaObjImpl( src.getOptionalJMSSqlSchemaObjImpl() );
		setOptionalJMSSqlSchemaObjImport( src.getOptionalJMSSqlSchemaObjImport() );
		setOptionalJMySqlSchemaObjMembers( src.getOptionalJMySqlSchemaObjMembers() );
		setOptionalJMySqlSchemaObjImpl( src.getOptionalJMySqlSchemaObjImpl() );
		setOptionalJMySqlSchemaObjImport( src.getOptionalJMySqlSchemaObjImport() );
		setOptionalJOracleSchemaObjMembers( src.getOptionalJOracleSchemaObjMembers() );
		setOptionalJOracleSchemaObjImpl( src.getOptionalJOracleSchemaObjImpl() );
		setOptionalJOracleSchemaObjImport( src.getOptionalJOracleSchemaObjImport() );
		setOptionalJPgSqlSchemaObjMembers( src.getOptionalJPgSqlSchemaObjMembers() );
		setOptionalJPgSqlSchemaObjImpl( src.getOptionalJPgSqlSchemaObjImpl() );
		setOptionalJPgSqlSchemaObjImport( src.getOptionalJPgSqlSchemaObjImport() );
		setOptionalJSybaseSchemaObjMembers( src.getOptionalJSybaseSchemaObjMembers() );
		setOptionalJSybaseSchemaObjImpl( src.getOptionalJSybaseSchemaObjImpl() );
		setOptionalJSybaseSchemaObjImport( src.getOptionalJSybaseSchemaObjImport() );
		setOptionalJRamSchemaObjMembers( src.getOptionalJRamSchemaObjMembers() );
		setOptionalJRamSchemaObjImpl( src.getOptionalJRamSchemaObjImpl() );
		setOptionalJRamSchemaObjImport( src.getOptionalJRamSchemaObjImport() );
		setOptionalJXMsgSchemaImport( src.getOptionalJXMsgSchemaImport() );
		setOptionalJXMsgSchemaFormatters( src.getOptionalJXMsgSchemaFormatters() );
		setOptionalJXMsgClientSchemaImport( src.getOptionalJXMsgClientSchemaImport() );
		setOptionalJXMsgClientSchemaBody( src.getOptionalJXMsgClientSchemaBody() );
		setOptionalJXMsgRqstSchemaBody( src.getOptionalJXMsgRqstSchemaBody() );
		setOptionalJXMsgRqstSchemaImport( src.getOptionalJXMsgRqstSchemaImport() );
		setOptionalJXMsgRqstSchemaWireParsers( src.getOptionalJXMsgRqstSchemaWireParsers() );
		setOptionalJXMsgRqstSchemaXsdSpec( src.getOptionalJXMsgRqstSchemaXsdSpec() );
		setOptionalJXMsgRqstSchemaXsdElementList( src.getOptionalJXMsgRqstSchemaXsdElementList() );
		setOptionalJXMsgRspnSchemaBody( src.getOptionalJXMsgRspnSchemaBody() );
		setOptionalJXMsgRspnSchemaImport( src.getOptionalJXMsgRspnSchemaImport() );
		setOptionalJXMsgRspnSchemaWireParsers( src.getOptionalJXMsgRspnSchemaWireParsers() );
		setOptionalJXMsgRspnSchemaXsdElementList( src.getOptionalJXMsgRspnSchemaXsdElementList() );
		setOptionalJXMsgRspnSchemaXsdSpec( src.getOptionalJXMsgRspnSchemaXsdSpec() );
	}

	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamSchemaDefHBuff ) {
			setSchemaDefBuff( (CFBamSchemaDefHBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamSchemaDefHBuff" );
		}
	}

	public void setSchemaDefBuff( CFBamSchemaDefHBuff src ) {
		super.setScopeBuff( src );
		setRequiredDomainId( src.getRequiredDomainId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setOptionalDefaultLicenseTenantId( src.getOptionalDefaultLicenseTenantId() );
		setOptionalDefaultLicenseId( src.getOptionalDefaultLicenseId() );
		setRequiredExtendCFCore( src.getRequiredExtendCFCore() );
		setOptionalDataScopeId( src.getOptionalDataScopeId() );
		setOptionalViewAccessSecurityId( src.getOptionalViewAccessSecurityId() );
		setOptionalEditAccessSecurityId( src.getOptionalEditAccessSecurityId() );
		setOptionalViewAccessFrequencyId( src.getOptionalViewAccessFrequencyId() );
		setOptionalEditAccessFrequencyId( src.getOptionalEditAccessFrequencyId() );
		setRequiredCopyrightPeriod( src.getRequiredCopyrightPeriod() );
		setRequiredCopyrightHolder( src.getRequiredCopyrightHolder() );
		setRequiredPublishURI( src.getRequiredPublishURI() );
		setOptionalJSchemaObjImport( src.getOptionalJSchemaObjImport() );
		setOptionalJSchemaObjInterface( src.getOptionalJSchemaObjInterface() );
		setOptionalJSchemaObjMembers( src.getOptionalJSchemaObjMembers() );
		setOptionalJSchemaObjImplementation( src.getOptionalJSchemaObjImplementation() );
		setOptionalJDb2LUWSchemaObjMembers( src.getOptionalJDb2LUWSchemaObjMembers() );
		setOptionalJDb2LUWSchemaObjImpl( src.getOptionalJDb2LUWSchemaObjImpl() );
		setOptionalJDb2LUWSchemaObjImport( src.getOptionalJDb2LUWSchemaObjImport() );
		setOptionalJMSSqlSchemaObjMembers( src.getOptionalJMSSqlSchemaObjMembers() );
		setOptionalJMSSqlSchemaObjImpl( src.getOptionalJMSSqlSchemaObjImpl() );
		setOptionalJMSSqlSchemaObjImport( src.getOptionalJMSSqlSchemaObjImport() );
		setOptionalJMySqlSchemaObjMembers( src.getOptionalJMySqlSchemaObjMembers() );
		setOptionalJMySqlSchemaObjImpl( src.getOptionalJMySqlSchemaObjImpl() );
		setOptionalJMySqlSchemaObjImport( src.getOptionalJMySqlSchemaObjImport() );
		setOptionalJOracleSchemaObjMembers( src.getOptionalJOracleSchemaObjMembers() );
		setOptionalJOracleSchemaObjImpl( src.getOptionalJOracleSchemaObjImpl() );
		setOptionalJOracleSchemaObjImport( src.getOptionalJOracleSchemaObjImport() );
		setOptionalJPgSqlSchemaObjMembers( src.getOptionalJPgSqlSchemaObjMembers() );
		setOptionalJPgSqlSchemaObjImpl( src.getOptionalJPgSqlSchemaObjImpl() );
		setOptionalJPgSqlSchemaObjImport( src.getOptionalJPgSqlSchemaObjImport() );
		setOptionalJSybaseSchemaObjMembers( src.getOptionalJSybaseSchemaObjMembers() );
		setOptionalJSybaseSchemaObjImpl( src.getOptionalJSybaseSchemaObjImpl() );
		setOptionalJSybaseSchemaObjImport( src.getOptionalJSybaseSchemaObjImport() );
		setOptionalJRamSchemaObjMembers( src.getOptionalJRamSchemaObjMembers() );
		setOptionalJRamSchemaObjImpl( src.getOptionalJRamSchemaObjImpl() );
		setOptionalJRamSchemaObjImport( src.getOptionalJRamSchemaObjImport() );
		setOptionalJXMsgSchemaImport( src.getOptionalJXMsgSchemaImport() );
		setOptionalJXMsgSchemaFormatters( src.getOptionalJXMsgSchemaFormatters() );
		setOptionalJXMsgClientSchemaImport( src.getOptionalJXMsgClientSchemaImport() );
		setOptionalJXMsgClientSchemaBody( src.getOptionalJXMsgClientSchemaBody() );
		setOptionalJXMsgRqstSchemaBody( src.getOptionalJXMsgRqstSchemaBody() );
		setOptionalJXMsgRqstSchemaImport( src.getOptionalJXMsgRqstSchemaImport() );
		setOptionalJXMsgRqstSchemaWireParsers( src.getOptionalJXMsgRqstSchemaWireParsers() );
		setOptionalJXMsgRqstSchemaXsdSpec( src.getOptionalJXMsgRqstSchemaXsdSpec() );
		setOptionalJXMsgRqstSchemaXsdElementList( src.getOptionalJXMsgRqstSchemaXsdElementList() );
		setOptionalJXMsgRspnSchemaBody( src.getOptionalJXMsgRspnSchemaBody() );
		setOptionalJXMsgRspnSchemaImport( src.getOptionalJXMsgRspnSchemaImport() );
		setOptionalJXMsgRspnSchemaWireParsers( src.getOptionalJXMsgRspnSchemaWireParsers() );
		setOptionalJXMsgRspnSchemaXsdElementList( src.getOptionalJXMsgRspnSchemaXsdElementList() );
		setOptionalJXMsgRspnSchemaXsdSpec( src.getOptionalJXMsgRspnSchemaXsdSpec() );
	}
}
