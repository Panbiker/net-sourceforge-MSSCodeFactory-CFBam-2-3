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

public interface ICFBamSecGroupIncludeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecGroupInclude instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamSecGroupIncludeObj newInstance();

	/**
	 *	Instantiate a new SecGroupInclude edition of the specified SecGroupInclude instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamSecGroupIncludeEditObj newEditInstance( ICFBamSecGroupIncludeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupIncludeObj realizeSecGroupInclude( ICFBamSecGroupIncludeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecGroupInclude( ICFBamSecGroupIncludeObj Obj );
	void forgetSecGroupInclude( ICFBamSecGroupIncludeObj Obj, boolean forgetSubObjects );
	void forgetSecGroupIncludeByIdIdx( long ClusterId,
		long SecGroupIncludeId );

	void forgetSecGroupIncludeByClusterIdx( long ClusterId );

	void forgetSecGroupIncludeByGroupIdx( long ClusterId,
		int SecGroupId );

	void forgetSecGroupIncludeByIncludeIdx( long ClusterId,
		int IncludeGroupId );

	void forgetSecGroupIncludeByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId );


	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupIncludeObj createSecGroupInclude( ICFBamSecGroupIncludeObj Obj );

	/**
	 *	Read a SecGroupInclude-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGroupInclude-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSecGroupIncludeObj readSecGroupInclude( CFBamSecGroupIncludePKey pkey );

	/**
	 *	Read a SecGroupInclude-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGroupInclude-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSecGroupIncludeObj readSecGroupInclude( CFBamSecGroupIncludePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupIncludeObj lockSecGroupInclude( CFBamSecGroupIncludePKey pkey );

	/**
	 *	Return a sorted map of all the SecGroupInclude-derived instances in the database.
	 *
	 *	@return	List of ICFBamSecGroupIncludeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSecGroupIncludeObj> readAllSecGroupInclude();

	/**
	 *	Return a sorted map of all the SecGroupInclude-derived instances in the database.
	 *
	 *	@return	List of ICFBamSecGroupIncludeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSecGroupIncludeObj> readAllSecGroupInclude( boolean forceRead );

	/**
	 *	Get the CFBamSecGroupIncludeObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupIncludeId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupIncludeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupIncludeObj readSecGroupIncludeByIdIdx( long ClusterId,
		long SecGroupIncludeId );

	/**
	 *	Get the CFBamSecGroupIncludeObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupIncludeId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupIncludeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupIncludeObj readSecGroupIncludeByIdIdx( long ClusterId,
		long SecGroupIncludeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecGroupIncludeObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFBamSecGroupIncludeObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecGroupIncludeObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Get the map of CFBamSecGroupIncludeObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecGroupIncludeObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByIncludeIdx( long ClusterId,
		int IncludeGroupId );

	/**
	 *	Get the map of CFBamSecGroupIncludeObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupIncludeObj> readSecGroupIncludeByIncludeIdx( long ClusterId,
		int IncludeGroupId,
		boolean forceRead );

	/**
	 *	Get the CFBamSecGroupIncludeObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupIncludeObj cached instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupIncludeObj readSecGroupIncludeByUIncludeIdx(long ClusterId,
		int SecGroupId,
		int IncludeGroupId );

	/**
	 *	Get the CFBamSecGroupIncludeObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupIncludeObj refreshed instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupIncludeObj readSecGroupIncludeByUIncludeIdx(long ClusterId,
		int SecGroupId,
		int IncludeGroupId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupIncludeObj updateSecGroupInclude( ICFBamSecGroupIncludeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecGroupInclude( ICFBamSecGroupIncludeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupIncludeId	The SecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteSecGroupIncludeByIdIdx( long ClusterId,
		long SecGroupIncludeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteSecGroupIncludeByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteSecGroupIncludeByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteSecGroupIncludeByIncludeIdx( long ClusterId,
		int IncludeGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteSecGroupIncludeByUIncludeIdx(long ClusterId,
		int SecGroupId,
		int IncludeGroupId );
}
