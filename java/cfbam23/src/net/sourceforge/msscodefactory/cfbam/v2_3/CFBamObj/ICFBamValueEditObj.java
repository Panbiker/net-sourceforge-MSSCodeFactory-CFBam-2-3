// Description: Java7 Instance Edit Object interface for CFBam Value.

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

public interface ICFBamValueEditObj
extends ICFBamValueObj
{

	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFBamValueObj.
	 */
	ICFBamValueObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamValueObj.
	 */
	ICFBamValueObj getOrigAsValue();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFBamValueObj create();

	/*
	 *	Update the instance.
	 */
	void update();

	/*
	 *	Delete the instance.
	 */
	void delete();

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
	 *	Get the required boolean attribute IsNullable.
	 *
	 *	@return	The boolean value of the attribute IsNullable.
	 */
	boolean getRequiredIsNullable();

	/**
	 *	Set the required boolean attribute IsNullable.
	 *
	 *	@param	value	the boolean value of the attribute IsNullable.
	 */
	void setRequiredIsNullable( boolean value );

	/**
	 *	Get the optional Boolean attribute GenerateId.
	 *
	 *	@return	The Boolean value of the attribute GenerateId.
	 */
	Boolean getOptionalGenerateId();

	/**
	 *	Set the optional Boolean attribute GenerateId.
	 *
	 *	@param	value	the Boolean value of the attribute GenerateId.
	 */
	void setOptionalGenerateId( Boolean value );

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
	 *	Get the ICFBamTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ICFBamTenantObj instance referenced by the Tenant key.
	 */
	ICFBamTenantObj getRequiredOwnerTenant();

	/**
	 *	Set the ICFBamTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ICFBamTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ICFBamTenantObj value );

	/**
	 *	Get the ICFBamScopeObj instance referenced by the Scope key.
	 *
	 *	@return	The ICFBamScopeObj instance referenced by the Scope key.
	 */
	ICFBamScopeObj getRequiredContainerScope();

	/**
	 *	Set the ICFBamScopeObj instance referenced by the Scope key.
	 *
	 *	@param	value	the ICFBamScopeObj instance to be referenced by the Scope key.
	 */
	void setRequiredContainerScope( ICFBamScopeObj value );

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

	/**
	 *	Get the ICFBamValueObj instance referenced by the Prev key.
	 *
	 *	@return	The ICFBamValueObj instance referenced by the Prev key.
	 */
	ICFBamValueObj getOptionalLookupPrev();

	/**
	 *	Set the ICFBamValueObj instance referenced by the Prev key.
	 *
	 *	@param	value	the ICFBamValueObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( ICFBamValueObj value );

	/**
	 *	Get the ICFBamValueObj instance referenced by the Next key.
	 *
	 *	@return	The ICFBamValueObj instance referenced by the Next key.
	 */
	ICFBamValueObj getOptionalLookupNext();

	/**
	 *	Set the ICFBamValueObj instance referenced by the Next key.
	 *
	 *	@param	value	the ICFBamValueObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( ICFBamValueObj value );

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ICFBamSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ICFBamSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( Calendar value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ICFBamSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ICFBamSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( Calendar value );}
