// Description: Java7 Instance Edit Object interface for CFBam Relation.

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

public interface ICFBamRelationEditObj
extends ICFBamRelationObj, ICFBamScopeEditObj
{

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamRelationObj.
	 */
	ICFBamRelationObj getOrigAsRelation();

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
	 *	Get the optional String attribute Suffix.
	 *
	 *	@return	The String value of the attribute Suffix.
	 */
	String getOptionalSuffix();

	/**
	 *	Set the optional String attribute Suffix.
	 *
	 *	@param	value	the String value of the attribute Suffix.
	 */
	void setOptionalSuffix( String value );

	/**
	 *	Get the required boolean attribute IsRequired.
	 *
	 *	@return	The boolean value of the attribute IsRequired.
	 */
	boolean getRequiredIsRequired();

	/**
	 *	Set the required boolean attribute IsRequired.
	 *
	 *	@param	value	the boolean value of the attribute IsRequired.
	 */
	void setRequiredIsRequired( boolean value );

	/**
	 *	Get the required boolean attribute IsAbstract.
	 *
	 *	@return	The boolean value of the attribute IsAbstract.
	 */
	boolean getRequiredIsAbstract();

	/**
	 *	Set the required boolean attribute IsAbstract.
	 *
	 *	@param	value	the boolean value of the attribute IsAbstract.
	 */
	void setRequiredIsAbstract( boolean value );

	/**
	 *	Get the required boolean attribute IsXsdContainer.
	 *
	 *	@return	The boolean value of the attribute IsXsdContainer.
	 */
	boolean getRequiredIsXsdContainer();

	/**
	 *	Set the required boolean attribute IsXsdContainer.
	 *
	 *	@param	value	the boolean value of the attribute IsXsdContainer.
	 */
	void setRequiredIsXsdContainer( boolean value );

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
	 *	Get the ICFBamTenantObj instance referenced by the RelTenant key.
	 *
	 *	@return	The ICFBamTenantObj instance referenced by the RelTenant key.
	 */
	ICFBamTenantObj getRequiredOwnerRelTenant();

	/**
	 *	Set the ICFBamTenantObj instance referenced by the RelTenant key.
	 *
	 *	@param	value	the ICFBamTenantObj instance to be referenced by the RelTenant key.
	 */
	void setRequiredOwnerRelTenant( ICFBamTenantObj value );

	/**
	 *	Get the ICFBamRelationTypeObj instance referenced by the RelationType key.
	 *
	 *	@return	The ICFBamRelationTypeObj instance referenced by the RelationType key.
	 */
	ICFBamRelationTypeObj getRequiredLookupRelationType();

	/**
	 *	Set the ICFBamRelationTypeObj instance referenced by the RelationType key.
	 *
	 *	@param	value	the ICFBamRelationTypeObj instance to be referenced by the RelationType key.
	 */
	void setRequiredLookupRelationType( ICFBamRelationTypeObj value );

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
	 *	Get the ICFBamTableObj instance referenced by the FromTable key.
	 *
	 *	@return	The ICFBamTableObj instance referenced by the FromTable key.
	 */
	ICFBamTableObj getRequiredContainerFromTable();

	/**
	 *	Set the ICFBamTableObj instance referenced by the FromTable key.
	 *
	 *	@param	value	the ICFBamTableObj instance to be referenced by the FromTable key.
	 */
	void setRequiredContainerFromTable( ICFBamTableObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the FromIndex key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the FromIndex key.
	 */
	ICFBamIndexObj getRequiredLookupFromIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the FromIndex key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the FromIndex key.
	 */
	void setRequiredLookupFromIndex( ICFBamIndexObj value );

	/**
	 *	Get the ICFBamTableObj instance referenced by the ToTable key.
	 *
	 *	@return	The ICFBamTableObj instance referenced by the ToTable key.
	 */
	ICFBamTableObj getRequiredLookupToTable();

	/**
	 *	Set the ICFBamTableObj instance referenced by the ToTable key.
	 *
	 *	@param	value	the ICFBamTableObj instance to be referenced by the ToTable key.
	 */
	void setRequiredLookupToTable( ICFBamTableObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the ToIndex key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the ToIndex key.
	 */
	ICFBamIndexObj getRequiredLookupToIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the ToIndex key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the ToIndex key.
	 */
	void setRequiredLookupToIndex( ICFBamIndexObj value );

	/**
	 *	Get the ICFBamRelationObj instance referenced by the Narrowed key.
	 *
	 *	@return	The ICFBamRelationObj instance referenced by the Narrowed key.
	 */
	ICFBamRelationObj getOptionalLookupNarrowed();

	/**
	 *	Set the ICFBamRelationObj instance referenced by the Narrowed key.
	 *
	 *	@param	value	the ICFBamRelationObj instance to be referenced by the Narrowed key.
	 */
	void setOptionalLookupNarrowed( ICFBamRelationObj value );
}
