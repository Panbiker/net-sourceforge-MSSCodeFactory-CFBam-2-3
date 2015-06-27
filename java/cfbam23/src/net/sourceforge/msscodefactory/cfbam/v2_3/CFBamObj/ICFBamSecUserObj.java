// Description: Java7 Object interface for CFBam SecUser.

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

public interface ICFBamSecUserObj
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
	 *	Realize this instance of a SecUser.
	 *
	 *	@return	CFBamSecUserObj instance which should be subsequently referenced.
	 */
	ICFBamSecUserObj realize();

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
	 *	@return	ICFBamSecUserObj the reference to the cached or read (realized) instance.
	 */
	ICFBamSecUserObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFBamSecUserObj the reference to the cached or read (realized) instance.
	 */
	ICFBamSecUserObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecUser instance.
	 *
	 *	@return	The newly locked ICFBamSecUserEditObj edition of this instance.
	 */
	ICFBamSecUserEditObj beginEdit();

	/**
	 *	End this edition of this SecUser instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecUser instance.
	 *
	 *	@return	The ICFBamSecUserEditObj edition of this instance.
	 */
	ICFBamSecUserEditObj getEdit();

	/**
	 *	Get the current edition of this SecUser instance as a ICFBamSecUserEditObj.
	 *
	 *	@return	The ICFBamSecUserEditObj edition of this instance.
	 */
	ICFBamSecUserEditObj getEditAsSecUser();

	/**
	 *	Get the ICFBamSecUserTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamSecUserTableObj table cache which manages this instance.
	 */
	ICFBamSecUserTableObj getSecUserTable();

	/**
	 *	Get the ICFBamSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFBamSchemaObj schema cache which manages this instance.
	 */
	ICFBamSchemaObj getSchema();

	/**
	 *	Get the CFBamSecUserBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamSecUserBuff instance which currently backs this object.
	 */
	CFBamSecUserBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFBamSecUserBuff value );

	/**
	 *	Get the CFBamSecUserBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamSecUserBuff instance which currently backs this object.
	 */
	CFBamSecUserBuff getSecUserBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFBamSecUserPKey primary key for this instance.
	 */
	CFBamSecUserPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFBamSecUserPKey primary key value for this instance.
	 */
	void setPKey( CFBamSecUserPKey value );

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
	 *	Get the required UUID attribute SecUserId.
	 *
	 *	@return	The required UUID attribute SecUserId.
	 */
	UUID getRequiredSecUserId();

	/**
	 *	Get the required String attribute LoginId.
	 *
	 *	@return	The required String attribute LoginId.
	 */
	String getRequiredLoginId();

	/**
	 *	Get the required String attribute EMailAddress.
	 *
	 *	@return	The required String attribute EMailAddress.
	 */
	String getRequiredEMailAddress();

	/**
	 *	Get the optional UUID attribute EMailConfirmationUuid.
	 *
	 *	@return	The optional UUID attribute EMailConfirmationUuid.
	 */
	UUID getOptionalEMailConfirmationUuid();

	/**
	 *	Get the optional UUID attribute DefaultDevSecUserId.
	 *
	 *	@return	The optional UUID attribute DefaultDevSecUserId.
	 */
	UUID getOptionalDefaultDevSecUserId();

	/**
	 *	Get the optional String attribute DefaultDevName.
	 *
	 *	@return	The optional String attribute DefaultDevName.
	 */
	String getOptionalDefaultDevName();

	/**
	 *	Get the required String attribute PasswordHash.
	 *
	 *	@return	The required String attribute PasswordHash.
	 */
	String getRequiredPasswordHash();

	/**
	 *	Get the optional UUID attribute PasswordResetUuid.
	 *
	 *	@return	The optional UUID attribute PasswordResetUuid.
	 */
	UUID getOptionalPasswordResetUuid();

	/**
	 *	Get the array of optional ICFBamSecDeviceObj array of instances referenced by the SecDev key.
	 *
	 *	@return	The optional ICFBamSecDeviceObj[] array of instances referenced by the SecDev key.
	 */
	List<ICFBamSecDeviceObj> getOptionalComponentsSecDev();

	/**
	 *	Get the array of optional ICFBamSecDeviceObj array of instances referenced by the SecDev key.
	 *
	 *	@return	The optional ICFBamSecDeviceObj[] array of instances referenced by the SecDev key.
	 */
	List<ICFBamSecDeviceObj> getOptionalComponentsSecDev( boolean forceRead );

	/**
	 *	Get the optional ICFBamSecDeviceObj instance referenced by the DefDev key.
	 *
	 *	@return	The optional ICFBamSecDeviceObj instance referenced by the DefDev key.
	 */
	ICFBamSecDeviceObj getOptionalLookupDefDev();

	/**
	 *	Get the optional ICFBamSecDeviceObj instance referenced by the DefDev key.
	 *
	 *	@return	The optional ICFBamSecDeviceObj instance referenced by the DefDev key.
	 */
	ICFBamSecDeviceObj getOptionalLookupDefDev( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamSecSessionObj array of instances referenced by the SecSess key.
	 *
	 *	@return	The optional ICFBamSecSessionObj[] array of instances referenced by the SecSess key.
	 */
	List<ICFBamSecSessionObj> getOptionalComponentsSecSess();

	/**
	 *	Get the array of optional ICFBamSecSessionObj array of instances referenced by the SecSess key.
	 *
	 *	@return	The optional ICFBamSecSessionObj[] array of instances referenced by the SecSess key.
	 */
	List<ICFBamSecSessionObj> getOptionalComponentsSecSess( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamSecSessionObj array of instances referenced by the SecProxy key.
	 *
	 *	@return	The optional ICFBamSecSessionObj[] array of instances referenced by the SecProxy key.
	 */
	List<ICFBamSecSessionObj> getOptionalChildrenSecProxy();

	/**
	 *	Get the array of optional ICFBamSecSessionObj array of instances referenced by the SecProxy key.
	 *
	 *	@return	The optional ICFBamSecSessionObj[] array of instances referenced by the SecProxy key.
	 */
	List<ICFBamSecSessionObj> getOptionalChildrenSecProxy( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamSecGroupMemberObj array of instances referenced by the SecGroupMember key.
	 *
	 *	@return	The optional ICFBamSecGroupMemberObj[] array of instances referenced by the SecGroupMember key.
	 */
	List<ICFBamSecGroupMemberObj> getOptionalChildrenSecGroupMember();

	/**
	 *	Get the array of optional ICFBamSecGroupMemberObj array of instances referenced by the SecGroupMember key.
	 *
	 *	@return	The optional ICFBamSecGroupMemberObj[] array of instances referenced by the SecGroupMember key.
	 */
	List<ICFBamSecGroupMemberObj> getOptionalChildrenSecGroupMember( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamTSecGroupMemberObj array of instances referenced by the TSecGroupMember key.
	 *
	 *	@return	The optional ICFBamTSecGroupMemberObj[] array of instances referenced by the TSecGroupMember key.
	 */
	List<ICFBamTSecGroupMemberObj> getOptionalChildrenTSecGroupMember();

	/**
	 *	Get the array of optional ICFBamTSecGroupMemberObj array of instances referenced by the TSecGroupMember key.
	 *
	 *	@return	The optional ICFBamTSecGroupMemberObj[] array of instances referenced by the TSecGroupMember key.
	 */
	List<ICFBamTSecGroupMemberObj> getOptionalChildrenTSecGroupMember( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();
}
