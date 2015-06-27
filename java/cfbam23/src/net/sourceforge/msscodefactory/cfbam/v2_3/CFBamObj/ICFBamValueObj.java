// Description: Java7 Object interface for CFBam Value.

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
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public interface ICFBamValueObj
	extends ICFLibAnyObj
{

	String getClassCode();
	/**
	 *	Get the user who created this instance.
	 *
	 *	@return	The ICFBamSecUserObj instance who created this instance.
	 */
	ICFBamSecUserObj getCreatedBy();

	/**
	 *	Get the Calendar date-time this instance was created.
	 *
	 *	@return	The Calendar value for the create time of the instance.
	 */
	Calendar getCreatedAt();

	/**
	 *	Get the user who updated this instance.
	 *
	 *	@return	The ICFBamSecUserObj instance who updated this instance.
	 */
	ICFBamSecUserObj getUpdatedBy();

	/**
	 *	Get the Calendar date-time this instance was updated.
	 *
	 *	@return	The Calendar value for the create time of the instance.
	 */
	Calendar getUpdatedAt();
	/**
	 *	Realize this instance of a Value.
	 *
	 *	@return	CFBamValueObj instance which should be subsequently referenced.
	 */
	ICFBamValueObj realize();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();
	void forget( boolean forgetSubObjects );

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFBamValueObj the reference to the cached or read (realized) instance.
	 */
	ICFBamValueObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFBamValueObj the reference to the cached or read (realized) instance.
	 */
	ICFBamValueObj read( boolean forceRead );

	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	ICFBamValueObj the reference to the moved and refreshed instance.
	 */
	ICFBamValueObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	ICFBamValueObj the reference to the moved and refreshed instance.
	 */
	ICFBamValueObj moveDown();

	/**
	 *	Initialize and return a locked edition of this Value instance.
	 *
	 *	@return	The newly locked ICFBamValueEditObj edition of this instance.
	 */
	ICFBamValueEditObj beginEdit();

	/**
	 *	End this edition of this Value instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Value instance.
	 *
	 *	@return	The ICFBamValueEditObj edition of this instance.
	 */
	ICFBamValueEditObj getEdit();

	/**
	 *	Get the current edition of this Value instance as a ICFBamValueEditObj.
	 *
	 *	@return	The ICFBamValueEditObj edition of this instance.
	 */
	ICFBamValueEditObj getEditAsValue();

	/**
	 *	Get the ICFBamValueTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamValueTableObj table cache which manages this instance.
	 */
	ICFBamValueTableObj getValueTable();

	/**
	 *	Get the ICFBamSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFBamSchemaObj schema cache which manages this instance.
	 */
	ICFBamSchemaObj getSchema();

	/**
	 *	Get the CFBamValueBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamValueBuff instance which currently backs this object.
	 */
	CFBamValueBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFBamValueBuff value );

	/**
	 *	Get the CFBamValueBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamValueBuff instance which currently backs this object.
	 */
	CFBamValueBuff getValueBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFBamValuePKey primary key for this instance.
	 */
	CFBamValuePKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFBamValuePKey primary key value for this instance.
	 */
	void setPKey( CFBamValuePKey value );

	/**
	 *	Is this a new instance?
	 *
	 *	@return	True if this is a new instance, otherwise false if it has
	 *		been read, locked, or created.
	 */
	boolean getIsNew();

	/**
	 *	Indicate whether this is a new instance.
	 *	<p>
	 *	This method should only be used by implementation internals.
	 *
	 *	@param	True if this is a new instance, otherwise false.
	 */
	void setIsNew( boolean value );

	/**
	 *	Get the required long attribute TenantId.
	 *
	 *	@return	The required long attribute TenantId.
	 */
	long getRequiredTenantId();

	/**
	 *	Get the required long attribute ScopeId.
	 *
	 *	@return	The required long attribute ScopeId.
	 */
	long getRequiredScopeId();

	/**
	 *	Get the required long attribute Id.
	 *
	 *	@return	The required long attribute Id.
	 */
	long getRequiredId();

	/**
	 *	Get the optional Long attribute DefSchemaTenantId.
	 *
	 *	@return	The optional Long attribute DefSchemaTenantId.
	 */
	Long getOptionalDefSchemaTenantId();

	/**
	 *	Get the optional Long attribute DefSchemaId.
	 *
	 *	@return	The optional Long attribute DefSchemaId.
	 */
	Long getOptionalDefSchemaId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The optional String attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The optional String attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The optional String attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Get the required boolean attribute IsNullable.
	 *
	 *	@return	The required boolean attribute IsNullable.
	 */
	boolean getRequiredIsNullable();

	/**
	 *	Get the optional Boolean attribute GenerateId.
	 *
	 *	@return	The optional Boolean attribute GenerateId.
	 */
	Boolean getOptionalGenerateId();

	/**
	 *	Get the optional Short attribute DataScopeId.
	 *
	 *	@return	The optional Short attribute DataScopeId.
	 */
	Short getOptionalDataScopeId();

	/**
	 *	Get the optional Short attribute ViewAccessSecurityId.
	 *
	 *	@return	The optional Short attribute ViewAccessSecurityId.
	 */
	Short getOptionalViewAccessSecurityId();

	/**
	 *	Get the optional Short attribute EditAccessSecurityId.
	 *
	 *	@return	The optional Short attribute EditAccessSecurityId.
	 */
	Short getOptionalEditAccessSecurityId();

	/**
	 *	Get the optional Short attribute ViewAccessFrequencyId.
	 *
	 *	@return	The optional Short attribute ViewAccessFrequencyId.
	 */
	Short getOptionalViewAccessFrequencyId();

	/**
	 *	Get the optional Short attribute EditAccessFrequencyId.
	 *
	 *	@return	The optional Short attribute EditAccessFrequencyId.
	 */
	Short getOptionalEditAccessFrequencyId();

	/**
	 *	Get the optional Long attribute PrevTenantId.
	 *
	 *	@return	The optional Long attribute PrevTenantId.
	 */
	Long getOptionalPrevTenantId();

	/**
	 *	Get the optional Long attribute PrevId.
	 *
	 *	@return	The optional Long attribute PrevId.
	 */
	Long getOptionalPrevId();

	/**
	 *	Get the optional Long attribute NextTenantId.
	 *
	 *	@return	The optional Long attribute NextTenantId.
	 */
	Long getOptionalNextTenantId();

	/**
	 *	Get the optional Long attribute NextId.
	 *
	 *	@return	The optional Long attribute NextId.
	 */
	Long getOptionalNextId();

	/**
	 *	Get the required boolean attribute DefaultVisibility.
	 *
	 *	@return	The required boolean attribute DefaultVisibility.
	 */
	boolean getRequiredDefaultVisibility();

	/**
	 *	Get the required ICFBamTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFBamTenantObj instance referenced by the Tenant key.
	 */
	ICFBamTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ICFBamTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFBamTenantObj instance referenced by the Tenant key.
	 */
	ICFBamTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Get the required ICFBamScopeObj instance referenced by the Scope key.
	 *
	 *	@return	The required ICFBamScopeObj instance referenced by the Scope key.
	 */
	ICFBamScopeObj getRequiredContainerScope();

	/**
	 *	Get the required ICFBamScopeObj instance referenced by the Scope key.
	 *
	 *	@return	The required ICFBamScopeObj instance referenced by the Scope key.
	 */
	ICFBamScopeObj getRequiredContainerScope( boolean forceRead );

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 *
	 *	@return	The optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 */
	ICFBamDataScopeObj getOptionalLookupDataScope();

	/**
	 *	Get the optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 *
	 *	@return	The optional ICFBamDataScopeObj instance referenced by the DataScope key.
	 */
	ICFBamDataScopeObj getOptionalLookupDataScope( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupVAccSec();

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the VAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupVAccSec( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupEAccSec();

	/**
	 *	Get the optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 *
	 *	@return	The optional ICFBamAccessSecurityObj instance referenced by the EAccSec key.
	 */
	ICFBamAccessSecurityObj getOptionalLookupEAccSec( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupVAccFreq();

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the VAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupVAccFreq( boolean forceRead );

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupEAccFreq();

	/**
	 *	Get the optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 *
	 *	@return	The optional ICFBamAccessFrequencyObj instance referenced by the EAccFreq key.
	 */
	ICFBamAccessFrequencyObj getOptionalLookupEAccFreq( boolean forceRead );

	/**
	 *	Get the optional ICFBamValueObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamValueObj instance referenced by the Prev key.
	 */
	ICFBamValueObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamValueObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamValueObj instance referenced by the Prev key.
	 */
	ICFBamValueObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional ICFBamValueObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamValueObj instance referenced by the Next key.
	 */
	ICFBamValueObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamValueObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamValueObj instance referenced by the Next key.
	 */
	ICFBamValueObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

    List<ICFBamIndexObj> getAffectedIndexes();
    List<ICFBamRelationObj> getAffectedRelations();
    List<ICFBamIndexObj> getAffectedUniqueIndexes();
    List<ICFBamRelationObj> getColumnInMemberRelations();
    List<ICFBamRelationObj> getColumnInComponentsRelations();
    boolean getGenerateId();
}
