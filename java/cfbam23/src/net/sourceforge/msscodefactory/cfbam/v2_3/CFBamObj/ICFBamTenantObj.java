// Description: Java7 Object interface for CFBam Tenant.

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

public interface ICFBamTenantObj
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
	 *	Realize this instance of a Tenant.
	 *
	 *	@return	CFBamTenantObj instance which should be subsequently referenced.
	 */
	ICFBamTenantObj realize();

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
	 *	@return	ICFBamTenantObj the reference to the cached or read (realized) instance.
	 */
	ICFBamTenantObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFBamTenantObj the reference to the cached or read (realized) instance.
	 */
	ICFBamTenantObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this Tenant instance.
	 *
	 *	@return	The newly locked ICFBamTenantEditObj edition of this instance.
	 */
	ICFBamTenantEditObj beginEdit();

	/**
	 *	End this edition of this Tenant instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Tenant instance.
	 *
	 *	@return	The ICFBamTenantEditObj edition of this instance.
	 */
	ICFBamTenantEditObj getEdit();

	/**
	 *	Get the current edition of this Tenant instance as a ICFBamTenantEditObj.
	 *
	 *	@return	The ICFBamTenantEditObj edition of this instance.
	 */
	ICFBamTenantEditObj getEditAsTenant();

	/**
	 *	Get the ICFBamTenantTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamTenantTableObj table cache which manages this instance.
	 */
	ICFBamTenantTableObj getTenantTable();

	/**
	 *	Get the ICFBamSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFBamSchemaObj schema cache which manages this instance.
	 */
	ICFBamSchemaObj getSchema();

	/**
	 *	Get the CFBamTenantBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamTenantBuff instance which currently backs this object.
	 */
	CFBamTenantBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFBamTenantBuff value );

	/**
	 *	Get the CFBamTenantBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamTenantBuff instance which currently backs this object.
	 */
	CFBamTenantBuff getTenantBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFBamTenantPKey primary key for this instance.
	 */
	CFBamTenantPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFBamTenantPKey primary key value for this instance.
	 */
	void setPKey( CFBamTenantPKey value );

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
	 *	Get the required long attribute ClusterId.
	 *
	 *	@return	The required long attribute ClusterId.
	 */
	long getRequiredClusterId();

	/**
	 *	Get the required long attribute Id.
	 *
	 *	@return	The required long attribute Id.
	 */
	long getRequiredId();

	/**
	 *	Get the required String attribute TenantName.
	 *
	 *	@return	The required String attribute TenantName.
	 */
	String getRequiredTenantName();

	/**
	 *	Get the required ICFBamClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ICFBamClusterObj instance referenced by the Cluster key.
	 */
	ICFBamClusterObj getRequiredContainerCluster();

	/**
	 *	Get the required ICFBamClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ICFBamClusterObj instance referenced by the Cluster key.
	 */
	ICFBamClusterObj getRequiredContainerCluster( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamTSecGroupObj array of instances referenced by the TSecGroup key.
	 *
	 *	@return	The optional ICFBamTSecGroupObj[] array of instances referenced by the TSecGroup key.
	 */
	List<ICFBamTSecGroupObj> getOptionalComponentsTSecGroup();

	/**
	 *	Get the array of optional ICFBamTSecGroupObj array of instances referenced by the TSecGroup key.
	 *
	 *	@return	The optional ICFBamTSecGroupObj[] array of instances referenced by the TSecGroup key.
	 */
	List<ICFBamTSecGroupObj> getOptionalComponentsTSecGroup( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamDomainBaseObj array of instances referenced by the DomainBase key.
	 *
	 *	@return	The optional ICFBamDomainBaseObj[] array of instances referenced by the DomainBase key.
	 */
	List<ICFBamDomainBaseObj> getOptionalComponentsDomainBase();

	/**
	 *	Get the array of optional ICFBamDomainBaseObj array of instances referenced by the DomainBase key.
	 *
	 *	@return	The optional ICFBamDomainBaseObj[] array of instances referenced by the DomainBase key.
	 */
	List<ICFBamDomainBaseObj> getOptionalComponentsDomainBase( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamTldObj array of instances referenced by the Tld key.
	 *
	 *	@return	The optional ICFBamTldObj[] array of instances referenced by the Tld key.
	 */
	List<ICFBamTldObj> getOptionalComponentsTld();

	/**
	 *	Get the array of optional ICFBamTldObj array of instances referenced by the Tld key.
	 *
	 *	@return	The optional ICFBamTldObj[] array of instances referenced by the Tld key.
	 */
	List<ICFBamTldObj> getOptionalComponentsTld( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamSchemaDefObj array of instances referenced by the Schema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj[] array of instances referenced by the Schema key.
	 */
	List<ICFBamSchemaDefObj> getOptionalComponentsSchema();

	/**
	 *	Get the array of optional ICFBamSchemaDefObj array of instances referenced by the Schema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj[] array of instances referenced by the Schema key.
	 */
	List<ICFBamSchemaDefObj> getOptionalComponentsSchema( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();
}
