// Description: Java7 Object interface for CFBam Cluster.

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

public interface ICFBamClusterObj
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
	 *	Realize this instance of a Cluster.
	 *
	 *	@return	CFBamClusterObj instance which should be subsequently referenced.
	 */
	ICFBamClusterObj realize();

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
	 *	@return	ICFBamClusterObj the reference to the cached or read (realized) instance.
	 */
	ICFBamClusterObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFBamClusterObj the reference to the cached or read (realized) instance.
	 */
	ICFBamClusterObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this Cluster instance.
	 *
	 *	@return	The newly locked ICFBamClusterEditObj edition of this instance.
	 */
	ICFBamClusterEditObj beginEdit();

	/**
	 *	End this edition of this Cluster instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Cluster instance.
	 *
	 *	@return	The ICFBamClusterEditObj edition of this instance.
	 */
	ICFBamClusterEditObj getEdit();

	/**
	 *	Get the current edition of this Cluster instance as a ICFBamClusterEditObj.
	 *
	 *	@return	The ICFBamClusterEditObj edition of this instance.
	 */
	ICFBamClusterEditObj getEditAsCluster();

	/**
	 *	Get the ICFBamClusterTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamClusterTableObj table cache which manages this instance.
	 */
	ICFBamClusterTableObj getClusterTable();

	/**
	 *	Get the ICFBamSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFBamSchemaObj schema cache which manages this instance.
	 */
	ICFBamSchemaObj getSchema();

	/**
	 *	Get the CFBamClusterBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamClusterBuff instance which currently backs this object.
	 */
	CFBamClusterBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFBamClusterBuff value );

	/**
	 *	Get the CFBamClusterBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamClusterBuff instance which currently backs this object.
	 */
	CFBamClusterBuff getClusterBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFBamClusterPKey primary key for this instance.
	 */
	CFBamClusterPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFBamClusterPKey primary key value for this instance.
	 */
	void setPKey( CFBamClusterPKey value );

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
	 *	Get the required long attribute Id.
	 *
	 *	@return	The required long attribute Id.
	 */
	long getRequiredId();

	/**
	 *	Get the required String attribute FullDomainName.
	 *
	 *	@return	The required String attribute FullDomainName.
	 */
	String getRequiredFullDomainName();

	/**
	 *	Get the required String attribute Description.
	 *
	 *	@return	The required String attribute Description.
	 */
	String getRequiredDescription();

	/**
	 *	Get the array of optional ICFBamHostNodeObj array of instances referenced by the HostNode key.
	 *
	 *	@return	The optional ICFBamHostNodeObj[] array of instances referenced by the HostNode key.
	 */
	List<ICFBamHostNodeObj> getOptionalComponentsHostNode();

	/**
	 *	Get the array of optional ICFBamHostNodeObj array of instances referenced by the HostNode key.
	 *
	 *	@return	The optional ICFBamHostNodeObj[] array of instances referenced by the HostNode key.
	 */
	List<ICFBamHostNodeObj> getOptionalComponentsHostNode( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamTenantObj array of instances referenced by the Tenant key.
	 *
	 *	@return	The optional ICFBamTenantObj[] array of instances referenced by the Tenant key.
	 */
	List<ICFBamTenantObj> getOptionalComponentsTenant();

	/**
	 *	Get the array of optional ICFBamTenantObj array of instances referenced by the Tenant key.
	 *
	 *	@return	The optional ICFBamTenantObj[] array of instances referenced by the Tenant key.
	 */
	List<ICFBamTenantObj> getOptionalComponentsTenant( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamSecAppObj array of instances referenced by the SecApp key.
	 *
	 *	@return	The optional ICFBamSecAppObj[] array of instances referenced by the SecApp key.
	 */
	List<ICFBamSecAppObj> getOptionalComponentsSecApp();

	/**
	 *	Get the array of optional ICFBamSecAppObj array of instances referenced by the SecApp key.
	 *
	 *	@return	The optional ICFBamSecAppObj[] array of instances referenced by the SecApp key.
	 */
	List<ICFBamSecAppObj> getOptionalComponentsSecApp( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamSecGroupObj array of instances referenced by the SecGroup key.
	 *
	 *	@return	The optional ICFBamSecGroupObj[] array of instances referenced by the SecGroup key.
	 */
	List<ICFBamSecGroupObj> getOptionalComponentsSecGroup();

	/**
	 *	Get the array of optional ICFBamSecGroupObj array of instances referenced by the SecGroup key.
	 *
	 *	@return	The optional ICFBamSecGroupObj[] array of instances referenced by the SecGroup key.
	 */
	List<ICFBamSecGroupObj> getOptionalComponentsSecGroup( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamSysClusterObj array of instances referenced by the SysCluster key.
	 *
	 *	@return	The optional ICFBamSysClusterObj[] array of instances referenced by the SysCluster key.
	 */
	List<ICFBamSysClusterObj> getOptionalComponentsSysCluster();

	/**
	 *	Get the array of optional ICFBamSysClusterObj array of instances referenced by the SysCluster key.
	 *
	 *	@return	The optional ICFBamSysClusterObj[] array of instances referenced by the SysCluster key.
	 */
	List<ICFBamSysClusterObj> getOptionalComponentsSysCluster( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();
}
