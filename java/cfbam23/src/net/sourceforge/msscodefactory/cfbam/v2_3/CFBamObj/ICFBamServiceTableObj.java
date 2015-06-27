// Description: Java 7 Table Object interface for CFBam.

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
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

public interface ICFBamServiceTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Service instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamServiceObj newInstance();

	/**
	 *	Instantiate a new Service edition of the specified Service instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamServiceEditObj newEditInstance( ICFBamServiceObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamServiceObj realizeService( ICFBamServiceObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetService( ICFBamServiceObj Obj );
	void forgetService( ICFBamServiceObj Obj, boolean forgetSubObjects );
	void forgetServiceByIdIdx( long ClusterId,
		long ServiceId );

	void forgetServiceByClusterIdx( long ClusterId );

	void forgetServiceByHostIdx( long ClusterId,
		long HostNodeId );

	void forgetServiceByTypeIdx( int ServiceTypeId );

	void forgetServiceByUTypeIdx( long ClusterId,
		long HostNodeId,
		int ServiceTypeId );

	void forgetServiceByUHostPortIdx( long ClusterId,
		long HostNodeId,
		short HostPort );


	/**
	 *	Internal use only.
	 */
	ICFBamServiceObj createService( ICFBamServiceObj Obj );

	/**
	 *	Read a Service-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Service-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamServiceObj readService( CFBamServicePKey pkey );

	/**
	 *	Read a Service-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Service-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamServiceObj readService( CFBamServicePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamServiceObj lockService( CFBamServicePKey pkey );

	/**
	 *	Return a sorted map of all the Service-derived instances in the database.
	 *
	 *	@return	List of ICFBamServiceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamServiceObj> readAllService();

	/**
	 *	Return a sorted map of all the Service-derived instances in the database.
	 *
	 *	@return	List of ICFBamServiceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamServiceObj> readAllService( boolean forceRead );

	/**
	 *	Get the CFBamServiceObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServiceObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamServiceObj readServiceByIdIdx( long ClusterId,
		long ServiceId );

	/**
	 *	Get the CFBamServiceObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServiceObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamServiceObj readServiceByIdIdx( long ClusterId,
		long ServiceId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamServiceObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServiceObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServiceObj> readServiceByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFBamServiceObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServiceObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServiceObj> readServiceByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamServiceObj instances sorted by their primary keys for the duplicate HostIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServiceObj cached instances sorted by their primary keys for the duplicate HostIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServiceObj> readServiceByHostIdx( long ClusterId,
		long HostNodeId );

	/**
	 *	Get the map of CFBamServiceObj instances sorted by their primary keys for the duplicate HostIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServiceObj cached instances sorted by their primary keys for the duplicate HostIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServiceObj> readServiceByHostIdx( long ClusterId,
		long HostNodeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamServiceObj instances sorted by their primary keys for the duplicate TypeIdx key.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServiceObj cached instances sorted by their primary keys for the duplicate TypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServiceObj> readServiceByTypeIdx( int ServiceTypeId );

	/**
	 *	Get the map of CFBamServiceObj instances sorted by their primary keys for the duplicate TypeIdx key.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServiceObj cached instances sorted by their primary keys for the duplicate TypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServiceObj> readServiceByTypeIdx( int ServiceTypeId,
		boolean forceRead );

	/**
	 *	Get the CFBamServiceObj instance for the unique UTypeIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServiceObj cached instance for the unique UTypeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamServiceObj readServiceByUTypeIdx(long ClusterId,
		long HostNodeId,
		int ServiceTypeId );

	/**
	 *	Get the CFBamServiceObj instance for the unique UTypeIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServiceObj refreshed instance for the unique UTypeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamServiceObj readServiceByUTypeIdx(long ClusterId,
		long HostNodeId,
		int ServiceTypeId,
		boolean forceRead );

	/**
	 *	Get the CFBamServiceObj instance for the unique UHostPortIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostPort	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServiceObj cached instance for the unique UHostPortIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamServiceObj readServiceByUHostPortIdx(long ClusterId,
		long HostNodeId,
		short HostPort );

	/**
	 *	Get the CFBamServiceObj instance for the unique UHostPortIdx key.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostPort	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServiceObj refreshed instance for the unique UHostPortIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamServiceObj readServiceByUHostPortIdx(long ClusterId,
		long HostNodeId,
		short HostPort,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamServiceObj updateService( ICFBamServiceObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteService( ICFBamServiceObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByIdIdx( long ClusterId,
		long ServiceId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByHostIdx( long ClusterId,
		long HostNodeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByTypeIdx( int ServiceTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argServiceTypeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByUTypeIdx(long ClusterId,
		long HostNodeId,
		int ServiceTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	argHostPort	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByUHostPortIdx(long ClusterId,
		long HostNodeId,
		short HostPort );
}
