// Description: Java7 Instance Edit Object interface for CFBam Service.

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

public interface ICFBamServiceEditObj
extends ICFBamServiceObj
{

	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFBamServiceObj.
	 */
	ICFBamServiceObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamServiceObj.
	 */
	ICFBamServiceObj getOrigAsService();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFBamServiceObj create();

	/*
	 *	Update the instance.
	 */
	void update();

	/*
	 *	Delete the instance.
	 */
	void delete();

	/**
	 *	Get the required short attribute HostPort.
	 *
	 *	@return	The short value of the attribute HostPort.
	 */
	short getRequiredHostPort();

	/**
	 *	Set the required short attribute HostPort.
	 *
	 *	@param	value	the short value of the attribute HostPort.
	 */
	void setRequiredHostPort( short value );

	/**
	 *	Get the ICFBamClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The ICFBamClusterObj instance referenced by the Cluster key.
	 */
	ICFBamClusterObj getRequiredOwnerCluster();

	/**
	 *	Set the ICFBamClusterObj instance referenced by the Cluster key.
	 *
	 *	@param	value	the ICFBamClusterObj instance to be referenced by the Cluster key.
	 */
	void setRequiredOwnerCluster( ICFBamClusterObj value );

	/**
	 *	Get the ICFBamHostNodeObj instance referenced by the Host key.
	 *
	 *	@return	The ICFBamHostNodeObj instance referenced by the Host key.
	 */
	ICFBamHostNodeObj getOptionalContainerHost();

	/**
	 *	Set the ICFBamHostNodeObj instance referenced by the Host key.
	 *
	 *	@param	value	the ICFBamHostNodeObj instance to be referenced by the Host key.
	 */
	void setOptionalContainerHost( ICFBamHostNodeObj value );

	/**
	 *	Get the ICFBamServiceTypeObj instance referenced by the ServiceType key.
	 *
	 *	@return	The ICFBamServiceTypeObj instance referenced by the ServiceType key.
	 */
	ICFBamServiceTypeObj getOptionalParentServiceType();

	/**
	 *	Set the ICFBamServiceTypeObj instance referenced by the ServiceType key.
	 *
	 *	@param	value	the ICFBamServiceTypeObj instance to be referenced by the ServiceType key.
	 */
	void setOptionalParentServiceType( ICFBamServiceTypeObj value );

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
