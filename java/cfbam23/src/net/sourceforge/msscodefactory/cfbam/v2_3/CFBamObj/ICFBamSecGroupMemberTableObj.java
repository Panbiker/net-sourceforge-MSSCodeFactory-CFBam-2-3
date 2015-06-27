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

public interface ICFBamSecGroupMemberTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecGroupMember instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamSecGroupMemberObj newInstance();

	/**
	 *	Instantiate a new SecGroupMember edition of the specified SecGroupMember instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamSecGroupMemberEditObj newEditInstance( ICFBamSecGroupMemberObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupMemberObj realizeSecGroupMember( ICFBamSecGroupMemberObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecGroupMember( ICFBamSecGroupMemberObj Obj );
	void forgetSecGroupMember( ICFBamSecGroupMemberObj Obj, boolean forgetSubObjects );
	void forgetSecGroupMemberByIdIdx( long ClusterId,
		long SecGroupMemberId );

	void forgetSecGroupMemberByClusterIdx( long ClusterId );

	void forgetSecGroupMemberByGroupIdx( long ClusterId,
		int SecGroupId );

	void forgetSecGroupMemberByUserIdx( UUID SecUserId );

	void forgetSecGroupMemberByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId );


	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupMemberObj createSecGroupMember( ICFBamSecGroupMemberObj Obj );

	/**
	 *	Read a SecGroupMember-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGroupMember-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSecGroupMemberObj readSecGroupMember( CFBamSecGroupMemberPKey pkey );

	/**
	 *	Read a SecGroupMember-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGroupMember-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSecGroupMemberObj readSecGroupMember( CFBamSecGroupMemberPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupMemberObj lockSecGroupMember( CFBamSecGroupMemberPKey pkey );

	/**
	 *	Return a sorted map of all the SecGroupMember-derived instances in the database.
	 *
	 *	@return	List of ICFBamSecGroupMemberObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSecGroupMemberObj> readAllSecGroupMember();

	/**
	 *	Return a sorted map of all the SecGroupMember-derived instances in the database.
	 *
	 *	@return	List of ICFBamSecGroupMemberObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSecGroupMemberObj> readAllSecGroupMember( boolean forceRead );

	/**
	 *	Get the CFBamSecGroupMemberObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupMemberId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupMemberObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupMemberObj readSecGroupMemberByIdIdx( long ClusterId,
		long SecGroupMemberId );

	/**
	 *	Get the CFBamSecGroupMemberObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupMemberId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupMemberObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupMemberObj readSecGroupMemberByIdIdx( long ClusterId,
		long SecGroupMemberId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecGroupMemberObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupMemberObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupMemberObj> readSecGroupMemberByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFBamSecGroupMemberObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupMemberObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupMemberObj> readSecGroupMemberByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecGroupMemberObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupMemberObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupMemberObj> readSecGroupMemberByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Get the map of CFBamSecGroupMemberObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupMemberObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupMemberObj> readSecGroupMemberByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecGroupMemberObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	argSecUserId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupMemberObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupMemberObj> readSecGroupMemberByUserIdx( UUID SecUserId );

	/**
	 *	Get the map of CFBamSecGroupMemberObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	argSecUserId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupMemberObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupMemberObj> readSecGroupMemberByUserIdx( UUID SecUserId,
		boolean forceRead );

	/**
	 *	Get the CFBamSecGroupMemberObj instance for the unique UUserIdx key.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupMemberObj cached instance for the unique UUserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupMemberObj readSecGroupMemberByUUserIdx(long ClusterId,
		int SecGroupId,
		UUID SecUserId );

	/**
	 *	Get the CFBamSecGroupMemberObj instance for the unique UUserIdx key.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupMemberObj refreshed instance for the unique UUserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupMemberObj readSecGroupMemberByUUserIdx(long ClusterId,
		int SecGroupId,
		UUID SecUserId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupMemberObj updateSecGroupMember( ICFBamSecGroupMemberObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecGroupMember( ICFBamSecGroupMemberObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupMemberId	The SecGroupMember key attribute of the instance generating the id.
	 */
	void deleteSecGroupMemberByIdIdx( long ClusterId,
		long SecGroupMemberId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 */
	void deleteSecGroupMemberByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupMember key attribute of the instance generating the id.
	 */
	void deleteSecGroupMemberByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecGroupMember key attribute of the instance generating the id.
	 */
	void deleteSecGroupMemberByUserIdx( UUID SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The SecGroupMember key attribute of the instance generating the id.
	 */
	void deleteSecGroupMemberByUUserIdx(long ClusterId,
		int SecGroupId,
		UUID SecUserId );
}
