
// Description: Java7 MSSCodeFactory CFEngine for CFBam

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
 */


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamMssCF;

import java.sql.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfcore.v2_3.MssCF.*;
import net.sourceforge.msscodefactory.cfcore.v2_3.CFGenKbObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public abstract class CFBamMssCFEngine
	extends MssCFEngine
{
	private static final long serialVersionUID = 1L;
	public static final String ITEMNAME_TOP = "top";
	protected ICFBamSchemaObj cFBamSchema = null;

	public CFBamMssCFEngine() {
		super();
		setTargetRuleName( ITEMNAME_TOP );
	}

	public abstract String fixGenDefName( String rawName );

	public ICFBamSchemaObj getCFBamSchema() {
		return( cFBamSchema );
	}

	public void setCFBamSchema( ICFBamSchemaObj value ) {
		cFBamSchema = value;
	}

	public void init( ICFGenKbSchemaObj argCFGenKbSchema,
		ICFGenKbTenantObj argTenant,
		ICFBamSchemaObj argCFBamSchema,
		String strRootGenDir )
	{
		setCFBamSchema( argCFBamSchema );
		init( argCFGenKbSchema, argTenant, strRootGenDir );
	}

	public void init( ICFGenKbSchemaObj argCFGenKbSchema,
		ICFGenKbTenantObj argTenant,
		String strRootGenDir )
	{
		super.init( argCFGenKbSchema, argTenant, strRootGenDir );
		setGenContext( getGenContextFactory().newGenContext(
			this,
			strRootGenDir,
			"any",
			"Object",
			"Object",
			getTargetRuleName() ) );
	}
	public ICFGenKbGenFileObj defineFile(
		String	toolsetName,
		String	scopeDefClassName,
		String	genDefClassName,
		String	itemName,
		String	expansionBody,
		String	sourceBundle,
		String	basePackageName,
		String	subPackageName,
		String	expansionClassName,
		String	expansionKeyName,
		String	expansionFileName )
	{
		return(
			super.defineFile( toolsetName,
				fixGenDefName(scopeDefClassName),
				fixGenDefName(genDefClassName),
				itemName,
				expansionBody,
				sourceBundle,
				basePackageName,
				subPackageName,
				expansionClassName,
				expansionKeyName,
				expansionFileName) );
	}
	public ICFGenKbGenRuleObj defineRule(
		String	toolsetName,
		String	scopeDefClassName,
		String	genDefClassName,
		String	itemName,
		String	expansionBody )
	{
		return(
			super.defineRule(toolsetName,
				fixGenDefName(scopeDefClassName),
				fixGenDefName(genDefClassName),
				itemName,
				expansionBody ) );
	}
	public ICFGenKbGenTruncObj defineTrunc(
		String	toolsetName,
		String	scopeDefClassName,
		String	genDefClassName,
		String	itemName,
		String	expansionBody,
		int		truncAt  )
	{
		return(
			super.defineTrunc(toolsetName,
				fixGenDefName(scopeDefClassName),
				fixGenDefName(genDefClassName),
				itemName,
				expansionBody,
				truncAt) );
	}
	public void bootstrapDefClasses() {
		ICFGenKbDefClassObj defClassObject = bootstrapDefClass( "Object", null );
		ICFGenKbDefClassObj defClassAccessFrequency = bootstrapDefClass( "AccessFrequency", defClassObject );
		ICFGenKbDefClassObj defClassAccessSecurity = bootstrapDefClass( "AccessSecurity", defClassObject );
		ICFGenKbDefClassObj defClassAuditAction = bootstrapDefClass( "AuditAction", defClassObject );
		ICFGenKbDefClassObj defClassChain = bootstrapDefClass( "Chain", defClassObject );
		ICFGenKbDefClassObj defClassCluster = bootstrapDefClass( "Cluster", defClassObject );
		ICFGenKbDefClassObj defClassDataScope = bootstrapDefClass( "DataScope", defClassObject );
		ICFGenKbDefClassObj defClassDomainBase = bootstrapDefClass( "DomainBase", defClassObject );
		ICFGenKbDefClassObj defClassTopDomain = bootstrapDefClass( "TopDomain", defClassDomainBase );
		ICFGenKbDefClassObj defClassDomain = bootstrapDefClass( "Domain", defClassDomainBase );
		ICFGenKbDefClassObj defClassProjectBase = bootstrapDefClass( "ProjectBase", defClassDomainBase );
		ICFGenKbDefClassObj defClassRealProject = bootstrapDefClass( "RealProject", defClassProjectBase );
		ICFGenKbDefClassObj defClassTopProject = bootstrapDefClass( "TopProject", defClassRealProject );
		ICFGenKbDefClassObj defClassSubProject = bootstrapDefClass( "SubProject", defClassRealProject );
		ICFGenKbDefClassObj defClassVersion = bootstrapDefClass( "Version", defClassProjectBase );
		ICFGenKbDefClassObj defClassMajorVersion = bootstrapDefClass( "MajorVersion", defClassVersion );
		ICFGenKbDefClassObj defClassMinorVersion = bootstrapDefClass( "MinorVersion", defClassVersion );
		ICFGenKbDefClassObj defClassEnumTag = bootstrapDefClass( "EnumTag", defClassObject );
		ICFGenKbDefClassObj defClassHostNode = bootstrapDefClass( "HostNode", defClassObject );
		ICFGenKbDefClassObj defClassISOCountry = bootstrapDefClass( "ISOCountry", defClassObject );
		ICFGenKbDefClassObj defClassISOCountryCurrency = bootstrapDefClass( "ISOCountryCurrency", defClassObject );
		ICFGenKbDefClassObj defClassISOCountryLanguage = bootstrapDefClass( "ISOCountryLanguage", defClassObject );
		ICFGenKbDefClassObj defClassISOCurrency = bootstrapDefClass( "ISOCurrency", defClassObject );
		ICFGenKbDefClassObj defClassISOLanguage = bootstrapDefClass( "ISOLanguage", defClassObject );
		ICFGenKbDefClassObj defClassISOTimezone = bootstrapDefClass( "ISOTimezone", defClassObject );
		ICFGenKbDefClassObj defClassIndexCol = bootstrapDefClass( "IndexCol", defClassObject );
		ICFGenKbDefClassObj defClassLicense = bootstrapDefClass( "License", defClassObject );
		ICFGenKbDefClassObj defClassLoaderBehaviour = bootstrapDefClass( "LoaderBehaviour", defClassObject );
		ICFGenKbDefClassObj defClassMimeType = bootstrapDefClass( "MimeType", defClassObject );
		ICFGenKbDefClassObj defClassParam = bootstrapDefClass( "Param", defClassObject );
		ICFGenKbDefClassObj defClassRelationCol = bootstrapDefClass( "RelationCol", defClassObject );
		ICFGenKbDefClassObj defClassRelationType = bootstrapDefClass( "RelationType", defClassObject );
		ICFGenKbDefClassObj defClassScope = bootstrapDefClass( "Scope", defClassObject );
		ICFGenKbDefClassObj defClassSchemaDef = bootstrapDefClass( "SchemaDef", defClassScope );
		ICFGenKbDefClassObj defClassSchemaRef = bootstrapDefClass( "SchemaRef", defClassScope );
		ICFGenKbDefClassObj defClassTable = bootstrapDefClass( "Table", defClassScope );
		ICFGenKbDefClassObj defClassDelDep = bootstrapDefClass( "DelDep", defClassScope );
		ICFGenKbDefClassObj defClassDelTopDep = bootstrapDefClass( "DelTopDep", defClassDelDep );
		ICFGenKbDefClassObj defClassDelSubDep1 = bootstrapDefClass( "DelSubDep1", defClassDelDep );
		ICFGenKbDefClassObj defClassDelSubDep2 = bootstrapDefClass( "DelSubDep2", defClassDelDep );
		ICFGenKbDefClassObj defClassDelSubDep3 = bootstrapDefClass( "DelSubDep3", defClassDelDep );
		ICFGenKbDefClassObj defClassIndex = bootstrapDefClass( "Index", defClassScope );
		ICFGenKbDefClassObj defClassRelation = bootstrapDefClass( "Relation", defClassScope );
		ICFGenKbDefClassObj defClassServerMethod = bootstrapDefClass( "ServerMethod", defClassScope );
		ICFGenKbDefClassObj defClassServerProc = bootstrapDefClass( "ServerProc", defClassServerMethod );
		ICFGenKbDefClassObj defClassServerObjFunc = bootstrapDefClass( "ServerObjFunc", defClassServerMethod );
		ICFGenKbDefClassObj defClassServerListFunc = bootstrapDefClass( "ServerListFunc", defClassServerMethod );
		ICFGenKbDefClassObj defClassPopDep = bootstrapDefClass( "PopDep", defClassScope );
		ICFGenKbDefClassObj defClassPopTopDep = bootstrapDefClass( "PopTopDep", defClassPopDep );
		ICFGenKbDefClassObj defClassPopSubDep1 = bootstrapDefClass( "PopSubDep1", defClassPopDep );
		ICFGenKbDefClassObj defClassPopSubDep2 = bootstrapDefClass( "PopSubDep2", defClassPopDep );
		ICFGenKbDefClassObj defClassPopSubDep3 = bootstrapDefClass( "PopSubDep3", defClassPopDep );
		ICFGenKbDefClassObj defClassClearDep = bootstrapDefClass( "ClearDep", defClassScope );
		ICFGenKbDefClassObj defClassClearTopDep = bootstrapDefClass( "ClearTopDep", defClassClearDep );
		ICFGenKbDefClassObj defClassClearSubDep1 = bootstrapDefClass( "ClearSubDep1", defClassClearDep );
		ICFGenKbDefClassObj defClassClearSubDep2 = bootstrapDefClass( "ClearSubDep2", defClassClearDep );
		ICFGenKbDefClassObj defClassClearSubDep3 = bootstrapDefClass( "ClearSubDep3", defClassClearDep );
		ICFGenKbDefClassObj defClassSecApp = bootstrapDefClass( "SecApp", defClassObject );
		ICFGenKbDefClassObj defClassSecDevice = bootstrapDefClass( "SecDevice", defClassObject );
		ICFGenKbDefClassObj defClassSecForm = bootstrapDefClass( "SecForm", defClassObject );
		ICFGenKbDefClassObj defClassSecGroup = bootstrapDefClass( "SecGroup", defClassObject );
		ICFGenKbDefClassObj defClassSecGroupForm = bootstrapDefClass( "SecGroupForm", defClassObject );
		ICFGenKbDefClassObj defClassSecGroupInclude = bootstrapDefClass( "SecGroupInclude", defClassObject );
		ICFGenKbDefClassObj defClassSecGroupMember = bootstrapDefClass( "SecGroupMember", defClassObject );
		ICFGenKbDefClassObj defClassSecSession = bootstrapDefClass( "SecSession", defClassObject );
		ICFGenKbDefClassObj defClassSecUser = bootstrapDefClass( "SecUser", defClassObject );
		ICFGenKbDefClassObj defClassSecurityScope = bootstrapDefClass( "SecurityScope", defClassObject );
		ICFGenKbDefClassObj defClassService = bootstrapDefClass( "Service", defClassObject );
		ICFGenKbDefClassObj defClassServiceType = bootstrapDefClass( "ServiceType", defClassObject );
		ICFGenKbDefClassObj defClassSysCluster = bootstrapDefClass( "SysCluster", defClassObject );
		ICFGenKbDefClassObj defClassTSecGroup = bootstrapDefClass( "TSecGroup", defClassObject );
		ICFGenKbDefClassObj defClassTSecGroupInclude = bootstrapDefClass( "TSecGroupInclude", defClassObject );
		ICFGenKbDefClassObj defClassTSecGroupMember = bootstrapDefClass( "TSecGroupMember", defClassObject );
		ICFGenKbDefClassObj defClassTenant = bootstrapDefClass( "Tenant", defClassObject );
		ICFGenKbDefClassObj defClassTld = bootstrapDefClass( "Tld", defClassObject );
		ICFGenKbDefClassObj defClassURLProtocol = bootstrapDefClass( "URLProtocol", defClassObject );
		ICFGenKbDefClassObj defClassValue = bootstrapDefClass( "Value", defClassObject );
		ICFGenKbDefClassObj defClassTableCol = bootstrapDefClass( "TableCol", defClassValue );
		ICFGenKbDefClassObj defClassAtom = bootstrapDefClass( "Atom", defClassValue );
		ICFGenKbDefClassObj defClassBlobDef = bootstrapDefClass( "BlobDef", defClassAtom );
		ICFGenKbDefClassObj defClassBlobCol = bootstrapDefClass( "BlobCol", defClassBlobDef );
		ICFGenKbDefClassObj defClassBlobType = bootstrapDefClass( "BlobType", defClassBlobDef );
		ICFGenKbDefClassObj defClassBoolDef = bootstrapDefClass( "BoolDef", defClassAtom );
		ICFGenKbDefClassObj defClassBoolCol = bootstrapDefClass( "BoolCol", defClassBoolDef );
		ICFGenKbDefClassObj defClassBoolType = bootstrapDefClass( "BoolType", defClassBoolDef );
		ICFGenKbDefClassObj defClassInt16Def = bootstrapDefClass( "Int16Def", defClassAtom );
		ICFGenKbDefClassObj defClassInt16Col = bootstrapDefClass( "Int16Col", defClassInt16Def );
		ICFGenKbDefClassObj defClassInt16Type = bootstrapDefClass( "Int16Type", defClassInt16Def );
		ICFGenKbDefClassObj defClassId16Gen = bootstrapDefClass( "Id16Gen", defClassInt16Type );
		ICFGenKbDefClassObj defClassEnumDef = bootstrapDefClass( "EnumDef", defClassInt16Def );
		ICFGenKbDefClassObj defClassEnumCol = bootstrapDefClass( "EnumCol", defClassEnumDef );
		ICFGenKbDefClassObj defClassEnumType = bootstrapDefClass( "EnumType", defClassEnumDef );
		ICFGenKbDefClassObj defClassInt32Def = bootstrapDefClass( "Int32Def", defClassAtom );
		ICFGenKbDefClassObj defClassInt32Col = bootstrapDefClass( "Int32Col", defClassInt32Def );
		ICFGenKbDefClassObj defClassInt32Type = bootstrapDefClass( "Int32Type", defClassInt32Def );
		ICFGenKbDefClassObj defClassId32Gen = bootstrapDefClass( "Id32Gen", defClassInt32Type );
		ICFGenKbDefClassObj defClassInt64Def = bootstrapDefClass( "Int64Def", defClassAtom );
		ICFGenKbDefClassObj defClassInt64Col = bootstrapDefClass( "Int64Col", defClassInt64Def );
		ICFGenKbDefClassObj defClassInt64Type = bootstrapDefClass( "Int64Type", defClassInt64Def );
		ICFGenKbDefClassObj defClassId64Gen = bootstrapDefClass( "Id64Gen", defClassInt64Type );
		ICFGenKbDefClassObj defClassUInt16Def = bootstrapDefClass( "UInt16Def", defClassAtom );
		ICFGenKbDefClassObj defClassUInt16Col = bootstrapDefClass( "UInt16Col", defClassUInt16Def );
		ICFGenKbDefClassObj defClassUInt16Type = bootstrapDefClass( "UInt16Type", defClassUInt16Def );
		ICFGenKbDefClassObj defClassUInt32Def = bootstrapDefClass( "UInt32Def", defClassAtom );
		ICFGenKbDefClassObj defClassUInt32Col = bootstrapDefClass( "UInt32Col", defClassUInt32Def );
		ICFGenKbDefClassObj defClassUInt32Type = bootstrapDefClass( "UInt32Type", defClassUInt32Def );
		ICFGenKbDefClassObj defClassUInt64Def = bootstrapDefClass( "UInt64Def", defClassAtom );
		ICFGenKbDefClassObj defClassUInt64Col = bootstrapDefClass( "UInt64Col", defClassUInt64Def );
		ICFGenKbDefClassObj defClassUInt64Type = bootstrapDefClass( "UInt64Type", defClassUInt64Def );
		ICFGenKbDefClassObj defClassFloatDef = bootstrapDefClass( "FloatDef", defClassAtom );
		ICFGenKbDefClassObj defClassFloatCol = bootstrapDefClass( "FloatCol", defClassFloatDef );
		ICFGenKbDefClassObj defClassFloatType = bootstrapDefClass( "FloatType", defClassFloatDef );
		ICFGenKbDefClassObj defClassDoubleDef = bootstrapDefClass( "DoubleDef", defClassAtom );
		ICFGenKbDefClassObj defClassDoubleCol = bootstrapDefClass( "DoubleCol", defClassDoubleDef );
		ICFGenKbDefClassObj defClassDoubleType = bootstrapDefClass( "DoubleType", defClassDoubleDef );
		ICFGenKbDefClassObj defClassNumberDef = bootstrapDefClass( "NumberDef", defClassAtom );
		ICFGenKbDefClassObj defClassNumberCol = bootstrapDefClass( "NumberCol", defClassNumberDef );
		ICFGenKbDefClassObj defClassNumberType = bootstrapDefClass( "NumberType", defClassNumberDef );
		ICFGenKbDefClassObj defClassStringDef = bootstrapDefClass( "StringDef", defClassAtom );
		ICFGenKbDefClassObj defClassStringCol = bootstrapDefClass( "StringCol", defClassStringDef );
		ICFGenKbDefClassObj defClassStringType = bootstrapDefClass( "StringType", defClassStringDef );
		ICFGenKbDefClassObj defClassTextDef = bootstrapDefClass( "TextDef", defClassAtom );
		ICFGenKbDefClassObj defClassTextCol = bootstrapDefClass( "TextCol", defClassTextDef );
		ICFGenKbDefClassObj defClassTextType = bootstrapDefClass( "TextType", defClassTextDef );
		ICFGenKbDefClassObj defClassNmTokenDef = bootstrapDefClass( "NmTokenDef", defClassAtom );
		ICFGenKbDefClassObj defClassNmTokenCol = bootstrapDefClass( "NmTokenCol", defClassNmTokenDef );
		ICFGenKbDefClassObj defClassNmTokenType = bootstrapDefClass( "NmTokenType", defClassNmTokenDef );
		ICFGenKbDefClassObj defClassNmTokensDef = bootstrapDefClass( "NmTokensDef", defClassAtom );
		ICFGenKbDefClassObj defClassNmTokensCol = bootstrapDefClass( "NmTokensCol", defClassNmTokensDef );
		ICFGenKbDefClassObj defClassNmTokensType = bootstrapDefClass( "NmTokensType", defClassNmTokensDef );
		ICFGenKbDefClassObj defClassTokenDef = bootstrapDefClass( "TokenDef", defClassAtom );
		ICFGenKbDefClassObj defClassTokenCol = bootstrapDefClass( "TokenCol", defClassTokenDef );
		ICFGenKbDefClassObj defClassTokenType = bootstrapDefClass( "TokenType", defClassTokenDef );
		ICFGenKbDefClassObj defClassDateDef = bootstrapDefClass( "DateDef", defClassAtom );
		ICFGenKbDefClassObj defClassDateCol = bootstrapDefClass( "DateCol", defClassDateDef );
		ICFGenKbDefClassObj defClassDateType = bootstrapDefClass( "DateType", defClassDateDef );
		ICFGenKbDefClassObj defClassTimeDef = bootstrapDefClass( "TimeDef", defClassAtom );
		ICFGenKbDefClassObj defClassTimeCol = bootstrapDefClass( "TimeCol", defClassTimeDef );
		ICFGenKbDefClassObj defClassTimeType = bootstrapDefClass( "TimeType", defClassTimeDef );
		ICFGenKbDefClassObj defClassTimestampDef = bootstrapDefClass( "TimestampDef", defClassAtom );
		ICFGenKbDefClassObj defClassTimestampCol = bootstrapDefClass( "TimestampCol", defClassTimestampDef );
		ICFGenKbDefClassObj defClassTimestampType = bootstrapDefClass( "TimestampType", defClassTimestampDef );
		ICFGenKbDefClassObj defClassTZDateDef = bootstrapDefClass( "TZDateDef", defClassAtom );
		ICFGenKbDefClassObj defClassTZDateCol = bootstrapDefClass( "TZDateCol", defClassTZDateDef );
		ICFGenKbDefClassObj defClassTZDateType = bootstrapDefClass( "TZDateType", defClassTZDateDef );
		ICFGenKbDefClassObj defClassTZTimeDef = bootstrapDefClass( "TZTimeDef", defClassAtom );
		ICFGenKbDefClassObj defClassTZTimeCol = bootstrapDefClass( "TZTimeCol", defClassTZTimeDef );
		ICFGenKbDefClassObj defClassTZTimeType = bootstrapDefClass( "TZTimeType", defClassTZTimeDef );
		ICFGenKbDefClassObj defClassTZTimestampDef = bootstrapDefClass( "TZTimestampDef", defClassAtom );
		ICFGenKbDefClassObj defClassTZTimestampCol = bootstrapDefClass( "TZTimestampCol", defClassTZTimestampDef );
		ICFGenKbDefClassObj defClassTZTimestampType = bootstrapDefClass( "TZTimestampType", defClassTZTimestampDef );
		ICFGenKbDefClassObj defClassUuidDef = bootstrapDefClass( "UuidDef", defClassAtom );
		ICFGenKbDefClassObj defClassUuidCol = bootstrapDefClass( "UuidCol", defClassUuidDef );
		ICFGenKbDefClassObj defClassUuidType = bootstrapDefClass( "UuidType", defClassUuidDef );
		ICFGenKbDefClassObj defClassUuidGen = bootstrapDefClass( "UuidGen", defClassUuidType );
	}

	public void bootstrapBindings() {
		ICFGenKbGenBindObj bind = null;
		ICFGenKbGenBindEditObj editBind = null;
        ICFGenKbRuleCartObj ruleCart = this.getInternalRuleCart();
        ICFGenKbRuleTypeObj ruleTypeBind = this.getRuleTypeTableObj().readRuleTypeByNameIdx("Bind");

		bind = new CFBamMssCFBindAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindAccessFrequencyName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindAccessSecurityName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindAtomDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasAtomDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindAuditActionAuditActionId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindAuditActionDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBlobColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBlobDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBlobDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasBlobDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBlobDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasBlobDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBlobDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasBlobDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBlobDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasBlobDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBlobTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBoolColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBoolDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasBoolDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBoolDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasBoolDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBoolDefFalseString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasBoolDefFalseString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBoolDefTrueString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasBoolDefTrueString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBoolDefNullString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasBoolDefNullString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindBoolTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasChainDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasChainDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasChainShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasChainLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasChainShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasChainDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasChainSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainPrevRelationTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainPrevRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainNextRelationTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainNextRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindChainDefaultVisibility( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasChainDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearDepRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearSubDep1ContClearTopDepTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearSubDep1ContClearTopDepId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearSubDep1Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearSubDep2ContClearDep1TenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearSubDep2ContClearDep1Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearSubDep2Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearSubDep3ContClearDep2TenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearSubDep3ContClearDep2Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearSubDep3Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearTopDepContTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClearTopDepName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClusterFullDomainName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindClusterDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDataScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDataScopeName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDateColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDateDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDateDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDateDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDateDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDateDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDateDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDateDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDateDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDateDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDateDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDateDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDateDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDateTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelDepDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDelDepDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelDepDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDelDepDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelDepRelationTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelDepRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDelDepDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelSubDep1ContTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelSubDep1ContDelTopDepId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelSubDep1Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelSubDep2ContTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelSubDep2ContDelDep1Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelSubDep2Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelSubDep3ContTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelSubDep3ContDelDep2Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelSubDep3Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelTopDepName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelTopDepContTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDelTopDepContTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDomainSubDomainOfId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDomainName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDomainBaseTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDomainBaseId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDomainBaseDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDomainBaseDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDoubleColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDoubleDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDoubleDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDoubleDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDoubleDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDoubleDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDoubleDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDoubleDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDoubleDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDoubleDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDoubleDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDoubleDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasDoubleDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindDoubleTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasEnumTagDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasEnumTagDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagEnumId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagEnumCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasEnumTagEnumCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasEnumTagPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasEnumTagPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasEnumTagNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTagNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasEnumTagNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasEnumTagDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasEnumTagPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasEnumTagNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindEnumTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindFloatColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindFloatDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasFloatDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindFloatDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasFloatDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindFloatDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasFloatDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindFloatDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasFloatDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindFloatDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasFloatDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindFloatDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasFloatDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindFloatTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHostNodeClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHostNodeHostNodeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHostNodeDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHostNodeHostName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCountryId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCountryISOCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCountryName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCountryCurrencyISOCountryId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCountryCurrencyISOCurrencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCountryLanguageISOCountryId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCountryLanguageISOLanguageId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCurrencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCurrencyISOCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCurrencyName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCurrencyUnitSymbol( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasISOCurrencyUnitSymbol( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCurrencyFracSymbol( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasISOCurrencyFracSymbol( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOCurrencyPrecis( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOLanguageId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOLanguageISOCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOLanguageBaseLanguageCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOLanguageISOCountryId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasISOLanguageISOCountryId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOTimezoneISOTimezoneId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOTimezoneIso8601( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOTimezoneTZName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOTimezoneTZHourOffset( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOTimezoneTZMinOffset( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOTimezoneDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindISOTimezoneVisible( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId16GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasId16GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId16GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasId16GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId16GenSlice( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId16GenBlockSize( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasId16GenDispenser( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId32GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasId32GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId32GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasId32GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId32GenSlice( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId32GenBlockSize( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasId32GenDispenser( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId64GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasId64GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId64GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasId64GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId64GenSlice( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindId64GenBlockSize( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasId64GenDispenser( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexIsUnique( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexIsDbMapped( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexDefaultVisibility( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColColumnId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColIsAscending( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindIndexColDefaultVisibility( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasIndexColNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt16ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt16DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt16DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt16DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt16DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt16DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt16DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt16DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt16DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt16DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt16DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt16DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt16DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt16TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt32ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt32DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt32DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt32DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt32DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt32DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt32DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt32DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt32DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt32DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt32DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt32DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt32DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt32TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt64ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt64DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt64DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt64DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt64DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt64DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt64DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt64DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt64DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt64DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt64DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt64DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasInt64DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindInt64TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLicenseTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLicenseId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLicenseDomainId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLicenseName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLicenseShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasLicenseShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLicenseLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasLicenseLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLicenseShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasLicenseShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLicenseDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasLicenseDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLicenseEmbeddedText( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasLicenseEmbeddedText( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLicenseFullText( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasLicenseFullText( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLoaderBehaviourId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindLoaderBehaviourName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindMajorVersionParentProjectId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindMajorVersionName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindMimeTypeMimeTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindMimeTypeName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindMimeTypeDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindMinorVersionMajorId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindMinorVersionName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokenColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokenDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokenDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNmTokenDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokenDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNmTokenDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokenDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNmTokenDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokenDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNmTokenDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokenDefShowLines( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokenTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokensColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokensDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokensDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNmTokensDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokensDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNmTokensDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokensDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNmTokensDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokensDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNmTokensDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokensDefShowLines( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNmTokensTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNumberColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNumberDefDigits( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNumberDefPrecis( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNumberDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNumberDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNumberDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNumberDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNumberDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNumberDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNumberDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNumberDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNumberDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNumberDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNumberDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasNumberDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindNumberTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamServerMethodId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamIsNullable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamTypeTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamTypeTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindParamNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasParamNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopDepDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasPopDepDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopDepDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasPopDepDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopDepRelationTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopDepRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasPopDepDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopSubDep1ContTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopSubDep1ContPopTopDepId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopSubDep1Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopSubDep2ContTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopSubDep2ContPopDep1Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopSubDep2Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopSubDep3ContTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopSubDep3ContPopDep2Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopSubDep3Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopTopDepContTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopTopDepContRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindPopTopDepName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationRelationTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationFromIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationToTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationToIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationIsRequired( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationIsAbstract( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationIsXsdContainer( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationNarrowedTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationNarrowedTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationNarrowedId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationNarrowedId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationDefaultVisibility( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationNarrowed( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColFromColId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColToColId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationColDefaultVisibility( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasRelationColNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindRelationTypeTag( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefDomainId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefDefaultLicenseTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefDefaultLicenseTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefDefaultLicenseId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefDefaultLicenseId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefExtendCFCore( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefDataScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefDataScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefViewAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefViewAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefEditAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefEditAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefViewAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefViewAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefEditAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefEditAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefCopyrightPeriod( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefCopyrightHolder( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefPublishURI( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJSchemaObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJSchemaObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJSchemaObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJSchemaObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJDb2LUWSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJDb2LUWSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJDb2LUWSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJDb2LUWSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJDb2LUWSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJDb2LUWSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJMSSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJMSSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJMSSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJMSSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJMSSqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJMSSqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJMySqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJMySqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJMySqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJMySqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJMySqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJMySqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJOracleSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJOracleSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJOracleSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJOracleSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJOracleSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJOracleSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJPgSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJPgSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJPgSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJPgSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJPgSqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJPgSqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJSybaseSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJSybaseSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJSybaseSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJSybaseSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJSybaseSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJSybaseSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJRamSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJRamSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJRamSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJRamSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJRamSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJRamSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgSchemaFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgSchemaFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgClientSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgClientSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgClientSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgClientSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgRqstSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRqstSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgRqstSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRqstSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgRqstSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRqstSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgRqstSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRqstSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgRqstSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRqstSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgRspnSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRspnSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgRspnSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRspnSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgRspnSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRspnSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgRspnSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRspnSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaDefJXMsgRspnSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRspnSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefDefaultLicense( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefDataScope( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefVAccSec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefEAccSec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefVAccFreq( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaDefEAccFreq( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaRefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaRefName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaRefRefModelName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaRefIncludeRoot( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaRefRefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaRefRefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSchemaRefRefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaRefRefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSchemaRefRefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindScopeTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecAppClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecAppSecAppId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecAppJEEMountName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecDeviceSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecDeviceDevName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecDevicePubKey( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSecDevicePubKey( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecFormClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecFormSecFormId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecFormSecAppId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecFormJEEServletMapName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupFormClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupFormSecGroupFormId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupFormSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupFormSecAppId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupFormSecFormId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupIncludeClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupIncludeSecGroupIncludeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupIncludeSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupIncludeIncludeGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupMemberClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupMemberSecGroupMemberId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupMemberSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecGroupMemberSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecSessionSecSessionId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecSessionSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecSessionSecDevName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSecSessionSecDevName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecSessionStart( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecSessionFinish( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSecSessionFinish( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecSessionSecProxyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSecSessionSecProxyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecUserSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecUserLoginId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecUserEMailAddress( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecUserEMailConfirmationUuid( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSecUserEMailConfirmationUuid( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecUserDefaultDevSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSecUserDefaultDevSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecUserDefaultDevName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSecUserDefaultDevName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecUserPasswordHash( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecUserPasswordResetUuid( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSecUserPasswordResetUuid( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasSecUserDefDev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecurityScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSecurityScopeName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerListFuncRetTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerListFuncRetTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerListFuncRetTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerListFuncRetTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerListFuncRetTable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerMethodDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerMethodDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerMethodShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerMethodLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerMethodShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerMethodDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerMethodSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodDefaultVisibility( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodIsInstanceMethod( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerMethodJMethodBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerMethodDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerObjFuncRetTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerObjFuncRetTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerObjFuncRetTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerObjFuncRetTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerObjFuncRetTable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServerProcDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServerProcDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServiceClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServiceServiceId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServiceHostNodeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServiceServiceTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServiceHostPort( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServiceHost( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasServiceServiceType( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServiceTypeServiceTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindServiceTypeDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindStringColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindStringDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindStringDefShowLines( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindStringDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasStringDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindStringDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasStringDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindStringDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasStringDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindStringDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasStringDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindStringTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSubProjectParentProjectId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSubProjectName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSysClusterSingletonId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindSysClusterClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupTSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupIncludeTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupIncludeTSecGroupIncludeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupIncludeTSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupIncludeIncludeGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupMemberTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupMemberTSecGroupMemberId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupMemberTSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTSecGroupMemberSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZDateColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZDateDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZDateDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZDateDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZDateDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZDateDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZDateDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZDateDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZDateDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZDateDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZDateDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZDateDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZDateDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZDateTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimeColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimeDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZTimeDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimeDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZTimeDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimeDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZTimeDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimeDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZTimeDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimeTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimestampColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimestampDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZTimestampDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimestampDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZTimestampDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimestampDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZTimestampDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimestampDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZTimestampDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimestampDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZTimestampDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimestampDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTZTimestampDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTZTimestampTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTablePrimaryIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTablePrimaryIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTablePrimaryIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTablePrimaryIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableTableClassCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableLookupIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableLookupIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableLookupIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableLookupIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableAltIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableAltIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableAltIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableAltIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableQualifyingTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableQualifyingTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableQualifyingTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableQualifyingTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTablePolyBase( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableIsInstantiable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableHasHistory( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableHasAuditColumns( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableLoaderBehaviourId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableDataScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableDataScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableSecurityScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableViewAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableViewAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableEditAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableEditAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableViewAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableViewAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableEditAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableEditAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJEditObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJEditObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJEditObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJEditObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJEditObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJEditObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJEditObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJEditObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJTableInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJTableInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJTableObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJTableObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJTableObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJTableObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJTableObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJTableObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJTableObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJTableObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJDb2LUWTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJDb2LUWTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJDb2LUWTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJDb2LUWTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJDb2LUWTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJDb2LUWTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJMSSqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJMSSqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJMSSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJMSSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJMSSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJMSSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJMySqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJMySqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJMySqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJMySqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJMySqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJMySqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJOracleTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJOracleTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJOracleTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJOracleTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJOracleTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJOracleTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJPgSqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJPgSqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJPgSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJPgSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJPgSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJPgSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJSybaseTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJSybaseTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJSybaseTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJSybaseTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJSybaseTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJSybaseTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJRamTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJRamTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJRamTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJRamTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJRamTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJRamTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJSaxLoaderImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJSaxLoaderImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJSaxLoaderStartElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJSaxLoaderStartElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJSaxLoaderEndElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJSaxLoaderEndElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJXMsgTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJXMsgTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJXMsgTableFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJXMsgTableFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJXMsgRqstTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJXMsgRqstTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJXMsgRspnTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJXMsgRspnTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJXMsgClientTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJXMsgClientTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJXMsgRqstTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJXMsgRqstTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJXMsgRspnTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJXMsgRspnTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableJXMsgClientTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableJXMsgClientTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableDefaultVisibility( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableLookupIndex( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableAltIndex( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableQualTable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTablePrimaryIndex( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableDataScope( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableVAccSec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableEAccSec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableVAccFreq( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableEAccFreq( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableColDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTableColDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTableColDataId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTenantClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTenantTenantName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTextColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTextDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTextDefShowLines( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTextDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTextDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTextDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTextDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTextDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTextDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTextDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTextDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTextTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimeColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimeDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTimeDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimeDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTimeDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimeDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTimeDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimeDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTimeDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimeTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimestampColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimestampDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTimestampDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimestampDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTimestampDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimestampDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTimestampDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimestampDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTimestampDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimestampDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTimestampDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimestampDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTimestampDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTimestampTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTldTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTldTldId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTldName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTokenColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTokenDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTokenDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTokenDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTokenDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTokenDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTokenDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTokenDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTokenDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasTokenDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTokenDefShowLines( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTokenTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTopDomainTldId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTopDomainName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTopProjectDomainId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindTopProjectName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt16ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt16DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt16DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt16DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt16DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt16DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt16DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt16DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt16DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt16DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt16DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt16DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt16DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt16TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt32ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt32DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt32DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt32DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt32DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt32DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt32DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt32DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt32DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt32DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt32DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt32DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt32DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt32TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt64ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt64DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt64DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt64DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt64DefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt64DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt64DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt64DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt64DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt64DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt64DefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt64DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUInt64DefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUInt64TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindURLProtocolURLProtocolId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindURLProtocolName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindURLProtocolDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindURLProtocolIsSecure( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUuidColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUuidDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUuidDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUuidDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUuidDefDefaultValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUuidDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUuidDefNullValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUuidDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUuidDefUnknownValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUuidGenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUuidGenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUuidGenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUuidGenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUuidGenSlice( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUuidGenBlockSize( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasUuidGenDispenser( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindUuidTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueIsNullable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueGenerateId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueGenerateId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueDataScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueDataScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueViewAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueViewAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueEditAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueEditAccessSecurityId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueViewAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueViewAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueEditAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueEditAccessFrequencyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValuePrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValuePrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValuePrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValuePrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindValueDefaultVisibility( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueDataScope( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueVAccSec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueEAccSec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueVAccFreq( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueEAccFreq( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValuePrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

		bind = new CFBamMssCFBindHasValueNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind.endEdit();

	}

	public void boostrapIterators() {
		ICFGenKbGenIteratorObj iterator = null;
		ICFGenKbGenIteratorEditObj editIterator = null;
		ICFGenKbRuleCartObj ruleCart = this.getInternalRuleCart();
		ICFGenKbRuleTypeObj ruleTypeIterator = this.getRuleTypeTableObj().readRuleTypeByNameIdx("Iterator");

		iterator = new CFBamMssCFIterateBlobTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateBoolTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateClearSubDep1ClearDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateClearSubDep2ClearDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateClearTopDepClearDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateClusterHostNode( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateClusterTenant( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateClusterSecApp( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateClusterSecGroup( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateClusterSysCluster( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateDateTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateDelSubDep1DelDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateDelSubDep2DelDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateDelTopDepDelDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateDomainTopProject( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateDomainBaseSchemaDef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateDomainBaseLicense( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateDoubleTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateEnumDefTag( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateEnumTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateFloatTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateHostNodeService( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateISOCountryCurrency( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateISOCountryLanguage( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateISOCurrencyCountry( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateISOLanguageCountry( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateIndexColumns( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateInt16TypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateInt32TypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateInt64TypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateMajorVersionMinorVersion( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateNmTokenTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateNmTokensTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateNumberTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIteratePopSubDep1PopDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIteratePopSubDep2PopDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIteratePopTopDepPopDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateRealProjectMajorVersion( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateRelationColumns( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateRelationPopDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSchemaDefTables( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSchemaDefTypes( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSchemaDefSchemaRefs( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSecAppForm( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSecGroupInclude( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSecGroupMember( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSecGroupIncByGroup( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSecGroupForm( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSecUserSecDev( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSecUserSecSess( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSecUserSecProxy( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSecUserSecGroupMember( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateSecUserTSecGroupMember( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateServerMethodParams( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateServiceTypeDeployed( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateStringTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTSecGroupInclude( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTSecGroupMember( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTSecGroupIncByGroup( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTZDateTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTZTimeTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTZTimestampTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableRelation( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableIndex( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableColumns( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableReverseRelations( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableChains( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableDelDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableClearDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableDispId16Gen( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableDispId32Gen( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableDispId64Gen( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTableServerMethods( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTenantTSecGroup( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTenantDomainBase( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTenantTld( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTenantSchema( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTextTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTimeTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTimestampTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTldTopDomain( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTokenTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTopDomainSubDomain( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTopDomainTopProject( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateTopProjectSubProject( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateUInt16TypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateUInt32TypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateUInt64TypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

		iterator = new CFBamMssCFIterateUuidTypeRef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator.endEdit();

	}

	public void boostrapReferences() {
		ICFGenKbGenReferenceObj refer = null;
		ICFGenKbGenReferenceEditObj editRefer = null;
		ICFGenKbRuleCartObj ruleCart = this.getInternalRuleCart();
		ICFGenKbRuleTypeObj ruleTypeReference = this.getRuleTypeTableObj().readRuleTypeByNameIdx("Reference");

		refer = new CFBamMssCFReferenceBlobColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceBlobTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceBoolColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceBoolTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceChainTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceChainTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceChainDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceChainPrevRel( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceChainNextRel( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceClearDepRelation( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceClearSubDep1ContClearTopDep( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceClearSubDep2ContClearSubDep1( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceClearSubDep3ContClearSubDep2( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceClearTopDepContTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDateColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDateTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDelDepRelation( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDelDepDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDelSubDep1ContDelTopDep( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDelSubDep2ContDelSubDep1( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDelSubDep3ContDelSubDep2( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDelTopDepContTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDomainParentDomain( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDomainBaseTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDoubleColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceDoubleTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceEnumColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceEnumTagTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceEnumTagEnumDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceEnumTagDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceEnumTagPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceEnumTagNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceEnumTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceFloatColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceFloatTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceHostNodeCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceISOCountryCurrencyCountry( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceISOCountryCurrencyCurrency( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceISOCountryLanguageCountry( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceISOCountryLanguageLanguage( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceId16GenDispenser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceId32GenDispenser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceId64GenDispenser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceIndexIdxTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceIndexTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceIndexDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceIndexColTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceIndexColIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceIndexColDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceIndexColColumn( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceIndexColPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceIndexColNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceInt16ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceInt16TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceInt32ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceInt32TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceInt64ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceInt64TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceLicenseTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceLicenseDomain( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceMajorVersionParent( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceMinorVersionMajorVersion( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceNmTokenColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceNmTokenTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceNmTokensColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceNmTokensTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceNumberColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceNumberTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceParamServerMeth( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceParamTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceParamDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceParamType( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceParamPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceParamNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferencePopDepRelation( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferencePopDepDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferencePopSubDep1ContPopTopDep( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferencePopSubDep2ContPopSubDep1( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferencePopSubDep3ContPopSubDep2( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferencePopTopDepContRelation( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationRelTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationRelationType( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationFromTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationFromIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationToTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationToIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationNarrowed( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationColRelation( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationColTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationColDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationColFromCol( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationColToCol( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationColPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceRelationColNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSchemaDefDomain( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSchemaDefCTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSchemaDefDefaultLicense( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSchemaDefDataScope( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSchemaDefVAccSec( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSchemaDefEAccSec( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSchemaDefVAccFreq( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSchemaDefEAccFreq( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSchemaRefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSchemaRefRefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceScopeTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecAppCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecDeviceSecUser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecFormCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecFormApplication( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupFormCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupFormGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupFormApp( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupFormForm( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupIncludeCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupIncludeGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupIncludeSubGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupMemberCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupMemberGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecGroupMemberUser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecSessionSecUser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecSessionSecProxy( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSecUserDefDev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceServerListFuncRetTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceServerMethodDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceServerMethodForTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceServerObjFuncRetTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceServiceCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceServiceHost( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceServiceServiceType( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceStringColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceStringTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSubProjectParentProject( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceSysClusterCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTSecGroupTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTSecGroupIncludeTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTSecGroupIncludeGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTSecGroupIncludeSubGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTSecGroupMemberTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTSecGroupMemberGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTSecGroupMemberUser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTZDateColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTZDateTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTZTimeColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTZTimeTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTZTimestampColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTZTimestampTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableLookupIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableAltIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableQualTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableLoaderBehaviour( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTablePrimaryIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableDataScope( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableSecScope( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableVAccSec( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableEAccSec( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableVAccFreq( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableEAccFreq( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTableColDataType( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTenantCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTextColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTextTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTimeColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTimeTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTimestampColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTimestampTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTldTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTokenColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTokenTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTopDomainTld( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceTopProjectDomain( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceUInt16ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceUInt16TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceUInt32ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceUInt32TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceUInt64ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceUInt64TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceUuidColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceUuidGenDispenser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceUuidTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceValueTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceValueScope( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceValueDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceValueDataScope( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceValueVAccSec( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceValueEAccSec( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceValueVAccFreq( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceValueEAccFreq( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceValuePrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

		refer = new CFBamMssCFReferenceValueNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer.endEdit();

	}}
