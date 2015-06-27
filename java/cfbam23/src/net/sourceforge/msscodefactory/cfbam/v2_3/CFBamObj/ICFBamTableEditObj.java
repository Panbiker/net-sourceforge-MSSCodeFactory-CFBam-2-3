// Description: Java7 Instance Edit Object interface for CFBam Table.

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

public interface ICFBamTableEditObj
extends ICFBamTableObj, ICFBamScopeEditObj
{

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamTableObj.
	 */
	ICFBamTableObj getOrigAsTable();

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
	 *	Get the required String attribute TableClassCode.
	 *
	 *	@return	The String value of the attribute TableClassCode.
	 */
	String getRequiredTableClassCode();

	/**
	 *	Set the required String attribute TableClassCode.
	 *
	 *	@param	value	the String value of the attribute TableClassCode.
	 */
	void setRequiredTableClassCode( String value );

	/**
	 *	Get the required boolean attribute PolyBase.
	 *
	 *	@return	The boolean value of the attribute PolyBase.
	 */
	boolean getRequiredPolyBase();

	/**
	 *	Set the required boolean attribute PolyBase.
	 *
	 *	@param	value	the boolean value of the attribute PolyBase.
	 */
	void setRequiredPolyBase( boolean value );

	/**
	 *	Get the required boolean attribute IsInstantiable.
	 *
	 *	@return	The boolean value of the attribute IsInstantiable.
	 */
	boolean getRequiredIsInstantiable();

	/**
	 *	Set the required boolean attribute IsInstantiable.
	 *
	 *	@param	value	the boolean value of the attribute IsInstantiable.
	 */
	void setRequiredIsInstantiable( boolean value );

	/**
	 *	Get the required boolean attribute HasHistory.
	 *
	 *	@return	The boolean value of the attribute HasHistory.
	 */
	boolean getRequiredHasHistory();

	/**
	 *	Set the required boolean attribute HasHistory.
	 *
	 *	@param	value	the boolean value of the attribute HasHistory.
	 */
	void setRequiredHasHistory( boolean value );

	/**
	 *	Get the required boolean attribute HasAuditColumns.
	 *
	 *	@return	The boolean value of the attribute HasAuditColumns.
	 */
	boolean getRequiredHasAuditColumns();

	/**
	 *	Set the required boolean attribute HasAuditColumns.
	 *
	 *	@param	value	the boolean value of the attribute HasAuditColumns.
	 */
	void setRequiredHasAuditColumns( boolean value );

	/**
	 *	Get the optional String attribute JObjMembers.
	 *
	 *	@return	The String value of the attribute JObjMembers.
	 */
	String getOptionalJObjMembers();

	/**
	 *	Set the optional String attribute JObjMembers.
	 *
	 *	@param	value	the String value of the attribute JObjMembers.
	 */
	void setOptionalJObjMembers( String value );

	/**
	 *	Get the optional String attribute JObjInterface.
	 *
	 *	@return	The String value of the attribute JObjInterface.
	 */
	String getOptionalJObjInterface();

	/**
	 *	Set the optional String attribute JObjInterface.
	 *
	 *	@param	value	the String value of the attribute JObjInterface.
	 */
	void setOptionalJObjInterface( String value );

	/**
	 *	Get the optional String attribute JObjImport.
	 *
	 *	@return	The String value of the attribute JObjImport.
	 */
	String getOptionalJObjImport();

	/**
	 *	Set the optional String attribute JObjImport.
	 *
	 *	@param	value	the String value of the attribute JObjImport.
	 */
	void setOptionalJObjImport( String value );

	/**
	 *	Get the optional String attribute JObjImplementation.
	 *
	 *	@return	The String value of the attribute JObjImplementation.
	 */
	String getOptionalJObjImplementation();

	/**
	 *	Set the optional String attribute JObjImplementation.
	 *
	 *	@param	value	the String value of the attribute JObjImplementation.
	 */
	void setOptionalJObjImplementation( String value );

	/**
	 *	Get the optional String attribute JEditObjMembers.
	 *
	 *	@return	The String value of the attribute JEditObjMembers.
	 */
	String getOptionalJEditObjMembers();

	/**
	 *	Set the optional String attribute JEditObjMembers.
	 *
	 *	@param	value	the String value of the attribute JEditObjMembers.
	 */
	void setOptionalJEditObjMembers( String value );

	/**
	 *	Get the optional String attribute JEditObjInterface.
	 *
	 *	@return	The String value of the attribute JEditObjInterface.
	 */
	String getOptionalJEditObjInterface();

	/**
	 *	Set the optional String attribute JEditObjInterface.
	 *
	 *	@param	value	the String value of the attribute JEditObjInterface.
	 */
	void setOptionalJEditObjInterface( String value );

	/**
	 *	Get the optional String attribute JEditObjImport.
	 *
	 *	@return	The String value of the attribute JEditObjImport.
	 */
	String getOptionalJEditObjImport();

	/**
	 *	Set the optional String attribute JEditObjImport.
	 *
	 *	@param	value	the String value of the attribute JEditObjImport.
	 */
	void setOptionalJEditObjImport( String value );

	/**
	 *	Get the optional String attribute JEditObjImplementation.
	 *
	 *	@return	The String value of the attribute JEditObjImplementation.
	 */
	String getOptionalJEditObjImplementation();

	/**
	 *	Set the optional String attribute JEditObjImplementation.
	 *
	 *	@param	value	the String value of the attribute JEditObjImplementation.
	 */
	void setOptionalJEditObjImplementation( String value );

	/**
	 *	Get the optional String attribute JTableImport.
	 *
	 *	@return	The String value of the attribute JTableImport.
	 */
	String getOptionalJTableImport();

	/**
	 *	Set the optional String attribute JTableImport.
	 *
	 *	@param	value	the String value of the attribute JTableImport.
	 */
	void setOptionalJTableImport( String value );

	/**
	 *	Get the optional String attribute JTableMembers.
	 *
	 *	@return	The String value of the attribute JTableMembers.
	 */
	String getOptionalJTableMembers();

	/**
	 *	Set the optional String attribute JTableMembers.
	 *
	 *	@param	value	the String value of the attribute JTableMembers.
	 */
	void setOptionalJTableMembers( String value );

	/**
	 *	Get the optional String attribute JTableInterface.
	 *
	 *	@return	The String value of the attribute JTableInterface.
	 */
	String getOptionalJTableInterface();

	/**
	 *	Set the optional String attribute JTableInterface.
	 *
	 *	@param	value	the String value of the attribute JTableInterface.
	 */
	void setOptionalJTableInterface( String value );

	/**
	 *	Get the optional String attribute JTableImplementation.
	 *
	 *	@return	The String value of the attribute JTableImplementation.
	 */
	String getOptionalJTableImplementation();

	/**
	 *	Set the optional String attribute JTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JTableImplementation.
	 */
	void setOptionalJTableImplementation( String value );

	/**
	 *	Get the optional String attribute JTableObjImport.
	 *
	 *	@return	The String value of the attribute JTableObjImport.
	 */
	String getOptionalJTableObjImport();

	/**
	 *	Set the optional String attribute JTableObjImport.
	 *
	 *	@param	value	the String value of the attribute JTableObjImport.
	 */
	void setOptionalJTableObjImport( String value );

	/**
	 *	Get the optional String attribute JTableObjMembers.
	 *
	 *	@return	The String value of the attribute JTableObjMembers.
	 */
	String getOptionalJTableObjMembers();

	/**
	 *	Set the optional String attribute JTableObjMembers.
	 *
	 *	@param	value	the String value of the attribute JTableObjMembers.
	 */
	void setOptionalJTableObjMembers( String value );

	/**
	 *	Get the optional String attribute JTableObjInterface.
	 *
	 *	@return	The String value of the attribute JTableObjInterface.
	 */
	String getOptionalJTableObjInterface();

	/**
	 *	Set the optional String attribute JTableObjInterface.
	 *
	 *	@param	value	the String value of the attribute JTableObjInterface.
	 */
	void setOptionalJTableObjInterface( String value );

	/**
	 *	Get the optional String attribute JTableObjImplementation.
	 *
	 *	@return	The String value of the attribute JTableObjImplementation.
	 */
	String getOptionalJTableObjImplementation();

	/**
	 *	Set the optional String attribute JTableObjImplementation.
	 *
	 *	@param	value	the String value of the attribute JTableObjImplementation.
	 */
	void setOptionalJTableObjImplementation( String value );

	/**
	 *	Get the optional String attribute JDb2LUWTableImport.
	 *
	 *	@return	The String value of the attribute JDb2LUWTableImport.
	 */
	String getOptionalJDb2LUWTableImport();

	/**
	 *	Set the optional String attribute JDb2LUWTableImport.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWTableImport.
	 */
	void setOptionalJDb2LUWTableImport( String value );

	/**
	 *	Get the optional String attribute JDb2LUWTableMembers.
	 *
	 *	@return	The String value of the attribute JDb2LUWTableMembers.
	 */
	String getOptionalJDb2LUWTableMembers();

	/**
	 *	Set the optional String attribute JDb2LUWTableMembers.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWTableMembers.
	 */
	void setOptionalJDb2LUWTableMembers( String value );

	/**
	 *	Get the optional String attribute JDb2LUWTableImplementation.
	 *
	 *	@return	The String value of the attribute JDb2LUWTableImplementation.
	 */
	String getOptionalJDb2LUWTableImplementation();

	/**
	 *	Set the optional String attribute JDb2LUWTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWTableImplementation.
	 */
	void setOptionalJDb2LUWTableImplementation( String value );

	/**
	 *	Get the optional String attribute JMSSqlTableImport.
	 *
	 *	@return	The String value of the attribute JMSSqlTableImport.
	 */
	String getOptionalJMSSqlTableImport();

	/**
	 *	Set the optional String attribute JMSSqlTableImport.
	 *
	 *	@param	value	the String value of the attribute JMSSqlTableImport.
	 */
	void setOptionalJMSSqlTableImport( String value );

	/**
	 *	Get the optional String attribute JMSSqlTableMembers.
	 *
	 *	@return	The String value of the attribute JMSSqlTableMembers.
	 */
	String getOptionalJMSSqlTableMembers();

	/**
	 *	Set the optional String attribute JMSSqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute JMSSqlTableMembers.
	 */
	void setOptionalJMSSqlTableMembers( String value );

	/**
	 *	Get the optional String attribute JMSSqlTableImplementation.
	 *
	 *	@return	The String value of the attribute JMSSqlTableImplementation.
	 */
	String getOptionalJMSSqlTableImplementation();

	/**
	 *	Set the optional String attribute JMSSqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JMSSqlTableImplementation.
	 */
	void setOptionalJMSSqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute JMySqlTableImport.
	 *
	 *	@return	The String value of the attribute JMySqlTableImport.
	 */
	String getOptionalJMySqlTableImport();

	/**
	 *	Set the optional String attribute JMySqlTableImport.
	 *
	 *	@param	value	the String value of the attribute JMySqlTableImport.
	 */
	void setOptionalJMySqlTableImport( String value );

	/**
	 *	Get the optional String attribute JMySqlTableMembers.
	 *
	 *	@return	The String value of the attribute JMySqlTableMembers.
	 */
	String getOptionalJMySqlTableMembers();

	/**
	 *	Set the optional String attribute JMySqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute JMySqlTableMembers.
	 */
	void setOptionalJMySqlTableMembers( String value );

	/**
	 *	Get the optional String attribute JMySqlTableImplementation.
	 *
	 *	@return	The String value of the attribute JMySqlTableImplementation.
	 */
	String getOptionalJMySqlTableImplementation();

	/**
	 *	Set the optional String attribute JMySqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JMySqlTableImplementation.
	 */
	void setOptionalJMySqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute JOracleTableImport.
	 *
	 *	@return	The String value of the attribute JOracleTableImport.
	 */
	String getOptionalJOracleTableImport();

	/**
	 *	Set the optional String attribute JOracleTableImport.
	 *
	 *	@param	value	the String value of the attribute JOracleTableImport.
	 */
	void setOptionalJOracleTableImport( String value );

	/**
	 *	Get the optional String attribute JOracleTableMembers.
	 *
	 *	@return	The String value of the attribute JOracleTableMembers.
	 */
	String getOptionalJOracleTableMembers();

	/**
	 *	Set the optional String attribute JOracleTableMembers.
	 *
	 *	@param	value	the String value of the attribute JOracleTableMembers.
	 */
	void setOptionalJOracleTableMembers( String value );

	/**
	 *	Get the optional String attribute JOracleTableImplementation.
	 *
	 *	@return	The String value of the attribute JOracleTableImplementation.
	 */
	String getOptionalJOracleTableImplementation();

	/**
	 *	Set the optional String attribute JOracleTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JOracleTableImplementation.
	 */
	void setOptionalJOracleTableImplementation( String value );

	/**
	 *	Get the optional String attribute JPgSqlTableImport.
	 *
	 *	@return	The String value of the attribute JPgSqlTableImport.
	 */
	String getOptionalJPgSqlTableImport();

	/**
	 *	Set the optional String attribute JPgSqlTableImport.
	 *
	 *	@param	value	the String value of the attribute JPgSqlTableImport.
	 */
	void setOptionalJPgSqlTableImport( String value );

	/**
	 *	Get the optional String attribute JPgSqlTableMembers.
	 *
	 *	@return	The String value of the attribute JPgSqlTableMembers.
	 */
	String getOptionalJPgSqlTableMembers();

	/**
	 *	Set the optional String attribute JPgSqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute JPgSqlTableMembers.
	 */
	void setOptionalJPgSqlTableMembers( String value );

	/**
	 *	Get the optional String attribute JPgSqlTableImplementation.
	 *
	 *	@return	The String value of the attribute JPgSqlTableImplementation.
	 */
	String getOptionalJPgSqlTableImplementation();

	/**
	 *	Set the optional String attribute JPgSqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JPgSqlTableImplementation.
	 */
	void setOptionalJPgSqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute JSybaseTableImport.
	 *
	 *	@return	The String value of the attribute JSybaseTableImport.
	 */
	String getOptionalJSybaseTableImport();

	/**
	 *	Set the optional String attribute JSybaseTableImport.
	 *
	 *	@param	value	the String value of the attribute JSybaseTableImport.
	 */
	void setOptionalJSybaseTableImport( String value );

	/**
	 *	Get the optional String attribute JSybaseTableMembers.
	 *
	 *	@return	The String value of the attribute JSybaseTableMembers.
	 */
	String getOptionalJSybaseTableMembers();

	/**
	 *	Set the optional String attribute JSybaseTableMembers.
	 *
	 *	@param	value	the String value of the attribute JSybaseTableMembers.
	 */
	void setOptionalJSybaseTableMembers( String value );

	/**
	 *	Get the optional String attribute JSybaseTableImplementation.
	 *
	 *	@return	The String value of the attribute JSybaseTableImplementation.
	 */
	String getOptionalJSybaseTableImplementation();

	/**
	 *	Set the optional String attribute JSybaseTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JSybaseTableImplementation.
	 */
	void setOptionalJSybaseTableImplementation( String value );

	/**
	 *	Get the optional String attribute JRamTableImport.
	 *
	 *	@return	The String value of the attribute JRamTableImport.
	 */
	String getOptionalJRamTableImport();

	/**
	 *	Set the optional String attribute JRamTableImport.
	 *
	 *	@param	value	the String value of the attribute JRamTableImport.
	 */
	void setOptionalJRamTableImport( String value );

	/**
	 *	Get the optional String attribute JRamTableMembers.
	 *
	 *	@return	The String value of the attribute JRamTableMembers.
	 */
	String getOptionalJRamTableMembers();

	/**
	 *	Set the optional String attribute JRamTableMembers.
	 *
	 *	@param	value	the String value of the attribute JRamTableMembers.
	 */
	void setOptionalJRamTableMembers( String value );

	/**
	 *	Get the optional String attribute JRamTableImplementation.
	 *
	 *	@return	The String value of the attribute JRamTableImplementation.
	 */
	String getOptionalJRamTableImplementation();

	/**
	 *	Set the optional String attribute JRamTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JRamTableImplementation.
	 */
	void setOptionalJRamTableImplementation( String value );

	/**
	 *	Get the optional String attribute JSaxLoaderImport.
	 *
	 *	@return	The String value of the attribute JSaxLoaderImport.
	 */
	String getOptionalJSaxLoaderImport();

	/**
	 *	Set the optional String attribute JSaxLoaderImport.
	 *
	 *	@param	value	the String value of the attribute JSaxLoaderImport.
	 */
	void setOptionalJSaxLoaderImport( String value );

	/**
	 *	Get the optional String attribute JSaxLoaderStartElement.
	 *
	 *	@return	The String value of the attribute JSaxLoaderStartElement.
	 */
	String getOptionalJSaxLoaderStartElement();

	/**
	 *	Set the optional String attribute JSaxLoaderStartElement.
	 *
	 *	@param	value	the String value of the attribute JSaxLoaderStartElement.
	 */
	void setOptionalJSaxLoaderStartElement( String value );

	/**
	 *	Get the optional String attribute JSaxLoaderEndElement.
	 *
	 *	@return	The String value of the attribute JSaxLoaderEndElement.
	 */
	String getOptionalJSaxLoaderEndElement();

	/**
	 *	Set the optional String attribute JSaxLoaderEndElement.
	 *
	 *	@param	value	the String value of the attribute JSaxLoaderEndElement.
	 */
	void setOptionalJSaxLoaderEndElement( String value );

	/**
	 *	Get the optional String attribute JXMsgTableImport.
	 *
	 *	@return	The String value of the attribute JXMsgTableImport.
	 */
	String getOptionalJXMsgTableImport();

	/**
	 *	Set the optional String attribute JXMsgTableImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgTableImport.
	 */
	void setOptionalJXMsgTableImport( String value );

	/**
	 *	Get the optional String attribute JXMsgTableFormatters.
	 *
	 *	@return	The String value of the attribute JXMsgTableFormatters.
	 */
	String getOptionalJXMsgTableFormatters();

	/**
	 *	Set the optional String attribute JXMsgTableFormatters.
	 *
	 *	@param	value	the String value of the attribute JXMsgTableFormatters.
	 */
	void setOptionalJXMsgTableFormatters( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstTableImport.
	 *
	 *	@return	The String value of the attribute JXMsgRqstTableImport.
	 */
	String getOptionalJXMsgRqstTableImport();

	/**
	 *	Set the optional String attribute JXMsgRqstTableImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstTableImport.
	 */
	void setOptionalJXMsgRqstTableImport( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnTableImport.
	 *
	 *	@return	The String value of the attribute JXMsgRspnTableImport.
	 */
	String getOptionalJXMsgRspnTableImport();

	/**
	 *	Set the optional String attribute JXMsgRspnTableImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnTableImport.
	 */
	void setOptionalJXMsgRspnTableImport( String value );

	/**
	 *	Get the optional String attribute JXMsgClientTableImport.
	 *
	 *	@return	The String value of the attribute JXMsgClientTableImport.
	 */
	String getOptionalJXMsgClientTableImport();

	/**
	 *	Set the optional String attribute JXMsgClientTableImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgClientTableImport.
	 */
	void setOptionalJXMsgClientTableImport( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstTableBody.
	 *
	 *	@return	The String value of the attribute JXMsgRqstTableBody.
	 */
	String getOptionalJXMsgRqstTableBody();

	/**
	 *	Set the optional String attribute JXMsgRqstTableBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstTableBody.
	 */
	void setOptionalJXMsgRqstTableBody( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnTableBody.
	 *
	 *	@return	The String value of the attribute JXMsgRspnTableBody.
	 */
	String getOptionalJXMsgRspnTableBody();

	/**
	 *	Set the optional String attribute JXMsgRspnTableBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnTableBody.
	 */
	void setOptionalJXMsgRspnTableBody( String value );

	/**
	 *	Get the optional String attribute JXMsgClientTableBody.
	 *
	 *	@return	The String value of the attribute JXMsgClientTableBody.
	 */
	String getOptionalJXMsgClientTableBody();

	/**
	 *	Set the optional String attribute JXMsgClientTableBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgClientTableBody.
	 */
	void setOptionalJXMsgClientTableBody( String value );

	/**
	 *	Get the required boolean attribute DefaultVisibility.
	 *
	 *	@return	The boolean value of the attribute DefaultVisibility.
	 */
	boolean getRequiredDefaultVisibility();

	/**
	 *	Set the required boolean attribute DefaultVisibility.
	 *
	 *	@param	value	the boolean value of the attribute DefaultVisibility.
	 */
	void setRequiredDefaultVisibility( boolean value );

	/**
	 *	Get the ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchemaDef();

	/**
	 *	Set the ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@param	value	the ICFBamSchemaDefObj instance to be referenced by the SchemaDef key.
	 */
	void setRequiredContainerSchemaDef( ICFBamSchemaDefObj value );

	/**
	 *	Get the ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Set the ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@param	value	the ICFBamSchemaDefObj instance to be referenced by the DefSchema key.
	 */
	void setOptionalLookupDefSchema( ICFBamSchemaDefObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the LookupIndex key.
	 */
	ICFBamIndexObj getOptionalLookupLookupIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the LookupIndex key.
	 */
	void setOptionalLookupLookupIndex( ICFBamIndexObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the AltIndex key.
	 */
	ICFBamIndexObj getOptionalLookupAltIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the AltIndex key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the AltIndex key.
	 */
	void setOptionalLookupAltIndex( ICFBamIndexObj value );

	/**
	 *	Get the ICFBamTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The ICFBamTableObj instance referenced by the QualTable key.
	 */
	ICFBamTableObj getOptionalLookupQualTable();

	/**
	 *	Set the ICFBamTableObj instance referenced by the QualTable key.
	 *
	 *	@param	value	the ICFBamTableObj instance to be referenced by the QualTable key.
	 */
	void setOptionalLookupQualTable( ICFBamTableObj value );

	/**
	 *	Get the ICFBamLoaderBehaviourObj instance referenced by the LoaderBehaviour key.
	 *
	 *	@return	The ICFBamLoaderBehaviourObj instance referenced by the LoaderBehaviour key.
	 */
	ICFBamLoaderBehaviourObj getRequiredLookupLoaderBehaviour();

	/**
	 *	Set the ICFBamLoaderBehaviourObj instance referenced by the LoaderBehaviour key.
	 *
	 *	@param	value	the ICFBamLoaderBehaviourObj instance to be referenced by the LoaderBehaviour key.
	 */
	void setRequiredLookupLoaderBehaviour( ICFBamLoaderBehaviourObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 */
	ICFBamIndexObj getOptionalLookupPrimaryIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the PrimaryIndex key.
	 */
	void setOptionalLookupPrimaryIndex( ICFBamIndexObj value );

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
	 *	Get the ICFBamSecurityScopeObj instance referenced by the SecScope key.
	 *
	 *	@return	The ICFBamSecurityScopeObj instance referenced by the SecScope key.
	 */
	ICFBamSecurityScopeObj getRequiredLookupSecScope();

	/**
	 *	Set the ICFBamSecurityScopeObj instance referenced by the SecScope key.
	 *
	 *	@param	value	the ICFBamSecurityScopeObj instance to be referenced by the SecScope key.
	 */
	void setRequiredLookupSecScope( ICFBamSecurityScopeObj value );

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
