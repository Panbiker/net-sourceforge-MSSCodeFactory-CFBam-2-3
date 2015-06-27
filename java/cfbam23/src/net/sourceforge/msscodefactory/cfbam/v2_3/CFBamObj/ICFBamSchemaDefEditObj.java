// Description: Java7 Instance Edit Object interface for CFBam SchemaDef.

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
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public interface ICFBamSchemaDefEditObj
extends ICFBamSchemaDefObj, ICFBamScopeEditObj
{

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamSchemaDefObj.
	 */
	ICFBamSchemaDefObj getOrigAsSchemaDef();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The String value of the attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Set the required String attribute Name.
	 *
	 *	@param	value	the String value of the attribute Name.
	 */
	void setRequiredName( String value );

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The String value of the attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Set the optional String attribute DbName.
	 *
	 *	@param	value	the String value of the attribute DbName.
	 */
	void setOptionalDbName( String value );

	/**
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The String value of the attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Set the optional String attribute ShortName.
	 *
	 *	@param	value	the String value of the attribute ShortName.
	 */
	void setOptionalShortName( String value );

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The String value of the attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Set the optional String attribute Label.
	 *
	 *	@param	value	the String value of the attribute Label.
	 */
	void setOptionalLabel( String value );

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The String value of the attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Set the optional String attribute ShortDescription.
	 *
	 *	@param	value	the String value of the attribute ShortDescription.
	 */
	void setOptionalShortDescription( String value );

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The String value of the attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Set the optional String attribute Description.
	 *
	 *	@param	value	the String value of the attribute Description.
	 */
	void setOptionalDescription( String value );

	/**
	 *	Get the required boolean attribute ExtendCFCore.
	 *
	 *	@return	The boolean value of the attribute ExtendCFCore.
	 */
	boolean getRequiredExtendCFCore();

	/**
	 *	Set the required boolean attribute ExtendCFCore.
	 *
	 *	@param	value	the boolean value of the attribute ExtendCFCore.
	 */
	void setRequiredExtendCFCore( boolean value );

	/**
	 *	Get the required String attribute CopyrightPeriod.
	 *
	 *	@return	The String value of the attribute CopyrightPeriod.
	 */
	String getRequiredCopyrightPeriod();

	/**
	 *	Set the required String attribute CopyrightPeriod.
	 *
	 *	@param	value	the String value of the attribute CopyrightPeriod.
	 */
	void setRequiredCopyrightPeriod( String value );

	/**
	 *	Get the required String attribute CopyrightHolder.
	 *
	 *	@return	The String value of the attribute CopyrightHolder.
	 */
	String getRequiredCopyrightHolder();

	/**
	 *	Set the required String attribute CopyrightHolder.
	 *
	 *	@param	value	the String value of the attribute CopyrightHolder.
	 */
	void setRequiredCopyrightHolder( String value );

	/**
	 *	Get the required String attribute PublishURI.
	 *
	 *	@return	The String value of the attribute PublishURI.
	 */
	String getRequiredPublishURI();

	/**
	 *	Set the required String attribute PublishURI.
	 *
	 *	@param	value	the String value of the attribute PublishURI.
	 */
	void setRequiredPublishURI( String value );

	/**
	 *	Get the optional String attribute JSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JSchemaObjImport.
	 */
	String getOptionalJSchemaObjImport();

	/**
	 *	Set the optional String attribute JSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JSchemaObjImport.
	 */
	void setOptionalJSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JSchemaObjInterface.
	 *
	 *	@return	The String value of the attribute JSchemaObjInterface.
	 */
	String getOptionalJSchemaObjInterface();

	/**
	 *	Set the optional String attribute JSchemaObjInterface.
	 *
	 *	@param	value	the String value of the attribute JSchemaObjInterface.
	 */
	void setOptionalJSchemaObjInterface( String value );

	/**
	 *	Get the optional String attribute JSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JSchemaObjMembers.
	 */
	String getOptionalJSchemaObjMembers();

	/**
	 *	Set the optional String attribute JSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JSchemaObjMembers.
	 */
	void setOptionalJSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JSchemaObjImplementation.
	 *
	 *	@return	The String value of the attribute JSchemaObjImplementation.
	 */
	String getOptionalJSchemaObjImplementation();

	/**
	 *	Set the optional String attribute JSchemaObjImplementation.
	 *
	 *	@param	value	the String value of the attribute JSchemaObjImplementation.
	 */
	void setOptionalJSchemaObjImplementation( String value );

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JDb2LUWSchemaObjMembers.
	 */
	String getOptionalJDb2LUWSchemaObjMembers();

	/**
	 *	Set the optional String attribute JDb2LUWSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWSchemaObjMembers.
	 */
	void setOptionalJDb2LUWSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JDb2LUWSchemaObjImpl.
	 */
	String getOptionalJDb2LUWSchemaObjImpl();

	/**
	 *	Set the optional String attribute JDb2LUWSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWSchemaObjImpl.
	 */
	void setOptionalJDb2LUWSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JDb2LUWSchemaObjImport.
	 */
	String getOptionalJDb2LUWSchemaObjImport();

	/**
	 *	Set the optional String attribute JDb2LUWSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWSchemaObjImport.
	 */
	void setOptionalJDb2LUWSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JMSSqlSchemaObjMembers.
	 */
	String getOptionalJMSSqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute JMSSqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JMSSqlSchemaObjMembers.
	 */
	void setOptionalJMSSqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JMSSqlSchemaObjImpl.
	 */
	String getOptionalJMSSqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute JMSSqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JMSSqlSchemaObjImpl.
	 */
	void setOptionalJMSSqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JMSSqlSchemaObjImport.
	 */
	String getOptionalJMSSqlSchemaObjImport();

	/**
	 *	Set the optional String attribute JMSSqlSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JMSSqlSchemaObjImport.
	 */
	void setOptionalJMSSqlSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JMySqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JMySqlSchemaObjMembers.
	 */
	String getOptionalJMySqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute JMySqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JMySqlSchemaObjMembers.
	 */
	void setOptionalJMySqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JMySqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JMySqlSchemaObjImpl.
	 */
	String getOptionalJMySqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute JMySqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JMySqlSchemaObjImpl.
	 */
	void setOptionalJMySqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JMySqlSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JMySqlSchemaObjImport.
	 */
	String getOptionalJMySqlSchemaObjImport();

	/**
	 *	Set the optional String attribute JMySqlSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JMySqlSchemaObjImport.
	 */
	void setOptionalJMySqlSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JOracleSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JOracleSchemaObjMembers.
	 */
	String getOptionalJOracleSchemaObjMembers();

	/**
	 *	Set the optional String attribute JOracleSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JOracleSchemaObjMembers.
	 */
	void setOptionalJOracleSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JOracleSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JOracleSchemaObjImpl.
	 */
	String getOptionalJOracleSchemaObjImpl();

	/**
	 *	Set the optional String attribute JOracleSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JOracleSchemaObjImpl.
	 */
	void setOptionalJOracleSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JOracleSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JOracleSchemaObjImport.
	 */
	String getOptionalJOracleSchemaObjImport();

	/**
	 *	Set the optional String attribute JOracleSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JOracleSchemaObjImport.
	 */
	void setOptionalJOracleSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JPgSqlSchemaObjMembers.
	 */
	String getOptionalJPgSqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute JPgSqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JPgSqlSchemaObjMembers.
	 */
	void setOptionalJPgSqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JPgSqlSchemaObjImpl.
	 */
	String getOptionalJPgSqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute JPgSqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JPgSqlSchemaObjImpl.
	 */
	void setOptionalJPgSqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JPgSqlSchemaObjImport.
	 */
	String getOptionalJPgSqlSchemaObjImport();

	/**
	 *	Set the optional String attribute JPgSqlSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JPgSqlSchemaObjImport.
	 */
	void setOptionalJPgSqlSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JSybaseSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JSybaseSchemaObjMembers.
	 */
	String getOptionalJSybaseSchemaObjMembers();

	/**
	 *	Set the optional String attribute JSybaseSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JSybaseSchemaObjMembers.
	 */
	void setOptionalJSybaseSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JSybaseSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JSybaseSchemaObjImpl.
	 */
	String getOptionalJSybaseSchemaObjImpl();

	/**
	 *	Set the optional String attribute JSybaseSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JSybaseSchemaObjImpl.
	 */
	void setOptionalJSybaseSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JSybaseSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JSybaseSchemaObjImport.
	 */
	String getOptionalJSybaseSchemaObjImport();

	/**
	 *	Set the optional String attribute JSybaseSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JSybaseSchemaObjImport.
	 */
	void setOptionalJSybaseSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JRamSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JRamSchemaObjMembers.
	 */
	String getOptionalJRamSchemaObjMembers();

	/**
	 *	Set the optional String attribute JRamSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JRamSchemaObjMembers.
	 */
	void setOptionalJRamSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JRamSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JRamSchemaObjImpl.
	 */
	String getOptionalJRamSchemaObjImpl();

	/**
	 *	Set the optional String attribute JRamSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JRamSchemaObjImpl.
	 */
	void setOptionalJRamSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JRamSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JRamSchemaObjImport.
	 */
	String getOptionalJRamSchemaObjImport();

	/**
	 *	Set the optional String attribute JRamSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JRamSchemaObjImport.
	 */
	void setOptionalJRamSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JXMsgSchemaImport.
	 *
	 *	@return	The String value of the attribute JXMsgSchemaImport.
	 */
	String getOptionalJXMsgSchemaImport();

	/**
	 *	Set the optional String attribute JXMsgSchemaImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgSchemaImport.
	 */
	void setOptionalJXMsgSchemaImport( String value );

	/**
	 *	Get the optional String attribute JXMsgSchemaFormatters.
	 *
	 *	@return	The String value of the attribute JXMsgSchemaFormatters.
	 */
	String getOptionalJXMsgSchemaFormatters();

	/**
	 *	Set the optional String attribute JXMsgSchemaFormatters.
	 *
	 *	@param	value	the String value of the attribute JXMsgSchemaFormatters.
	 */
	void setOptionalJXMsgSchemaFormatters( String value );

	/**
	 *	Get the optional String attribute JXMsgClientSchemaImport.
	 *
	 *	@return	The String value of the attribute JXMsgClientSchemaImport.
	 */
	String getOptionalJXMsgClientSchemaImport();

	/**
	 *	Set the optional String attribute JXMsgClientSchemaImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgClientSchemaImport.
	 */
	void setOptionalJXMsgClientSchemaImport( String value );

	/**
	 *	Get the optional String attribute JXMsgClientSchemaBody.
	 *
	 *	@return	The String value of the attribute JXMsgClientSchemaBody.
	 */
	String getOptionalJXMsgClientSchemaBody();

	/**
	 *	Set the optional String attribute JXMsgClientSchemaBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgClientSchemaBody.
	 */
	void setOptionalJXMsgClientSchemaBody( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaBody.
	 *
	 *	@return	The String value of the attribute JXMsgRqstSchemaBody.
	 */
	String getOptionalJXMsgRqstSchemaBody();

	/**
	 *	Set the optional String attribute JXMsgRqstSchemaBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstSchemaBody.
	 */
	void setOptionalJXMsgRqstSchemaBody( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaImport.
	 *
	 *	@return	The String value of the attribute JXMsgRqstSchemaImport.
	 */
	String getOptionalJXMsgRqstSchemaImport();

	/**
	 *	Set the optional String attribute JXMsgRqstSchemaImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstSchemaImport.
	 */
	void setOptionalJXMsgRqstSchemaImport( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaWireParsers.
	 *
	 *	@return	The String value of the attribute JXMsgRqstSchemaWireParsers.
	 */
	String getOptionalJXMsgRqstSchemaWireParsers();

	/**
	 *	Set the optional String attribute JXMsgRqstSchemaWireParsers.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstSchemaWireParsers.
	 */
	void setOptionalJXMsgRqstSchemaWireParsers( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaXsdSpec.
	 *
	 *	@return	The String value of the attribute JXMsgRqstSchemaXsdSpec.
	 */
	String getOptionalJXMsgRqstSchemaXsdSpec();

	/**
	 *	Set the optional String attribute JXMsgRqstSchemaXsdSpec.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstSchemaXsdSpec.
	 */
	void setOptionalJXMsgRqstSchemaXsdSpec( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaXsdElementList.
	 *
	 *	@return	The String value of the attribute JXMsgRqstSchemaXsdElementList.
	 */
	String getOptionalJXMsgRqstSchemaXsdElementList();

	/**
	 *	Set the optional String attribute JXMsgRqstSchemaXsdElementList.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstSchemaXsdElementList.
	 */
	void setOptionalJXMsgRqstSchemaXsdElementList( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaBody.
	 *
	 *	@return	The String value of the attribute JXMsgRspnSchemaBody.
	 */
	String getOptionalJXMsgRspnSchemaBody();

	/**
	 *	Set the optional String attribute JXMsgRspnSchemaBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnSchemaBody.
	 */
	void setOptionalJXMsgRspnSchemaBody( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaImport.
	 *
	 *	@return	The String value of the attribute JXMsgRspnSchemaImport.
	 */
	String getOptionalJXMsgRspnSchemaImport();

	/**
	 *	Set the optional String attribute JXMsgRspnSchemaImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnSchemaImport.
	 */
	void setOptionalJXMsgRspnSchemaImport( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaWireParsers.
	 *
	 *	@return	The String value of the attribute JXMsgRspnSchemaWireParsers.
	 */
	String getOptionalJXMsgRspnSchemaWireParsers();

	/**
	 *	Set the optional String attribute JXMsgRspnSchemaWireParsers.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnSchemaWireParsers.
	 */
	void setOptionalJXMsgRspnSchemaWireParsers( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaXsdElementList.
	 *
	 *	@return	The String value of the attribute JXMsgRspnSchemaXsdElementList.
	 */
	String getOptionalJXMsgRspnSchemaXsdElementList();

	/**
	 *	Set the optional String attribute JXMsgRspnSchemaXsdElementList.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnSchemaXsdElementList.
	 */
	void setOptionalJXMsgRspnSchemaXsdElementList( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaXsdSpec.
	 *
	 *	@return	The String value of the attribute JXMsgRspnSchemaXsdSpec.
	 */
	String getOptionalJXMsgRspnSchemaXsdSpec();

	/**
	 *	Set the optional String attribute JXMsgRspnSchemaXsdSpec.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnSchemaXsdSpec.
	 */
	void setOptionalJXMsgRspnSchemaXsdSpec( String value );

	/**
	 *	Get the ICFBamDomainBaseObj instance referenced by the Domain key.
	 *
	 *	@return	The ICFBamDomainBaseObj instance referenced by the Domain key.
	 */
	ICFBamDomainBaseObj getRequiredContainerDomain();

	/**
	 *	Set the ICFBamDomainBaseObj instance referenced by the Domain key.
	 *
	 *	@param	value	the ICFBamDomainBaseObj instance to be referenced by the Domain key.
	 */
	void setRequiredContainerDomain( ICFBamDomainBaseObj value );

	/**
	 *	Get the ICFBamTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The ICFBamTenantObj instance referenced by the CTenant key.
	 */
	ICFBamTenantObj getRequiredOwnerCTenant();

	/**
	 *	Set the ICFBamTenantObj instance referenced by the CTenant key.
	 *
	 *	@param	value	the ICFBamTenantObj instance to be referenced by the CTenant key.
	 */
	void setRequiredOwnerCTenant( ICFBamTenantObj value );

	/**
	 *	Get the ICFBamLicenseObj instance referenced by the DefaultLicense key.
	 *
	 *	@return	The ICFBamLicenseObj instance referenced by the DefaultLicense key.
	 */
	ICFBamLicenseObj getOptionalLookupDefaultLicense();

	/**
	 *	Set the ICFBamLicenseObj instance referenced by the DefaultLicense key.
	 *
	 *	@param	value	the ICFBamLicenseObj instance to be referenced by the DefaultLicense key.
	 */
	void setOptionalLookupDefaultLicense( ICFBamLicenseObj value );

	/**
	 *	Get the ICFBamDataScopeObj instance referenced by the DataScope key.
	 *
	 *	@return	The ICFBamDataScopeObj instance referenced by the DataScope key.
	 */
	ICFBamDataScopeObj getOptionalLookupDataScope();

	/**
	 *	Set the ICFBamDataScopeObj instance referenced by the DataScope key.
	 *
	 *	@param	value	the ICFBamDataScopeObj instance to be referenced by the DataScope key.
	 */
	void setOptionalLookupDataScope( ICFBamDataScopeObj value );

	/**
	 *	Get the ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 *
	 *	@return	The ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupVAccSec();

	/**
	 *	Set the ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 *
	 *	@param	value	the ICFBamAccessSecurityObj instance to be referenced by the VAccSec key.
	 */
	void setOptionalLookupVAccSec( ICFBamAccessSecurityObj value );

	/**
	 *	Get the ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 *
	 *	@return	The ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupEAccSec();

	/**
	 *	Set the ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 *
	 *	@param	value	the ICFBamAccessSecurityObj instance to be referenced by the EAccSec key.
	 */
	void setOptionalLookupEAccSec( ICFBamAccessSecurityObj value );

	/**
	 *	Get the ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 *
	 *	@return	The ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupVAccFreq();

	/**
	 *	Set the ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 *
	 *	@param	value	the ICFBamAccessFrequencyObj instance to be referenced by the VAccFreq key.
	 */
	void setOptionalLookupVAccFreq( ICFBamAccessFrequencyObj value );

	/**
	 *	Get the ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 *
	 *	@return	The ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupEAccFreq();

	/**
	 *	Set the ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 *
	 *	@param	value	the ICFBamAccessFrequencyObj instance to be referenced by the EAccFreq key.
	 */
	void setOptionalLookupEAccFreq( ICFBamAccessFrequencyObj value );
}
