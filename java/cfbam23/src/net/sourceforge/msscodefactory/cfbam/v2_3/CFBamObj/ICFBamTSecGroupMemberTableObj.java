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

public interface ICFBamTSecGroupMemberTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TSecGroupMember instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTSecGroupMemberObj newInstance();

	/**
	 *	Instantiate a new TSecGroupMember edition of the specified TSecGroupMember instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTSecGroupMemberEditObj newEditInstance( ICFBamTSecGroupMemberObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTSecGroupMemberObj realizeTSecGroupMember( ICFBamTSecGroupMemberObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTSecGroupMember( ICFBamTSecGroupMemberObj Obj );
	void forgetTSecGroupMember( ICFBamTSecGroupMemberObj Obj, boolean forgetSubObjects );
	void forgetTSecGroupMemberByIdIdx( long TenantId,
		long TSecGroupMemberId );

	void forgetTSecGroupMemberByTenantIdx( long TenantId );

	void forgetTSecGroupMemberByGroupIdx( long TenantId,
		int TSecGroupId );

	void forgetTSecGroupMemberByUserIdx( UUID SecUserId );

	void forgetTSecGroupMemberByUUserIdx( long TenantId,
		int TSecGroupId,
		UUID SecUserId );


	/**
	 *	Internal use only.
	 */
	ICFBamTSecGroupMemberObj createTSecGroupMember( ICFBamTSecGroupMemberObj Obj );

	/**
	 *	Read a TSecGroupMember-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TSecGroupMember-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTSecGroupMemberObj readTSecGroupMember( CFBamTSecGroupMemberPKey pkey );

	/**
	 *	Read a TSecGroupMember-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TSecGroupMember-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTSecGroupMemberObj readTSecGroupMember( CFBamTSecGroupMemberPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTSecGroupMemberObj lockTSecGroupMember( CFBamTSecGroupMemberPKey pkey );

	/**
	 *	Return a sorted map of all the TSecGroupMember-derived instances in the database.
	 *
	 *	@return	List of ICFBamTSecGroupMemberObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTSecGroupMemberObj> readAllTSecGroupMember();

	/**
	 *	Return a sorted map of all the TSecGroupMember-derived instances in the database.
	 *
	 *	@return	List of ICFBamTSecGroupMemberObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTSecGroupMemberObj> readAllTSecGroupMember( boolean forceRead );

	/**
	 *	Get the CFBamTSecGroupMemberObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupMemberId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTSecGroupMemberObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTSecGroupMemberObj readTSecGroupMemberByIdIdx( long TenantId,
		long TSecGroupMemberId );

	/**
	 *	Get the CFBamTSecGroupMemberObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupMemberId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTSecGroupMemberObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTSecGroupMemberObj readTSecGroupMemberByIdIdx( long TenantId,
		long TSecGroupMemberId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTSecGroupMemberObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupMemberObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamTSecGroupMemberObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupMemberObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTSecGroupMemberObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupMemberObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByGroupIdx( long TenantId,
		int TSecGroupId );

	/**
	 *	Get the map of CFBamTSecGroupMemberObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupMemberObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByGroupIdx( long TenantId,
		int TSecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTSecGroupMemberObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupMemberObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByUserIdx( UUID SecUserId );

	/**
	 *	Get the map of CFBamTSecGroupMemberObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupMemberObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupMemberObj> readTSecGroupMemberByUserIdx( UUID SecUserId,
		boolean forceRead );

	/**
	 *	Get the CFBamTSecGroupMemberObj instance for the unique UUserIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTSecGroupMemberObj cached instance for the unique UUserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTSecGroupMemberObj readTSecGroupMemberByUUserIdx(long TenantId,
		int TSecGroupId,
		UUID SecUserId );

	/**
	 *	Get the CFBamTSecGroupMemberObj instance for the unique UUserIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTSecGroupMemberObj refreshed instance for the unique UUserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTSecGroupMemberObj readTSecGroupMemberByUUserIdx(long TenantId,
		int TSecGroupId,
		UUID SecUserId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTSecGroupMemberObj updateTSecGroupMember( ICFBamTSecGroupMemberObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTSecGroupMember( ICFBamTSecGroupMemberObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupMemberId	The TSecGroupMember key attribute of the instance generating the id.
	 */
	void deleteTSecGroupMemberByIdIdx( long TenantId,
		long TSecGroupMemberId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 */
	void deleteTSecGroupMemberByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 */
	void deleteTSecGroupMemberByGroupIdx( long TenantId,
		int TSecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 */
	void deleteTSecGroupMemberByUserIdx( UUID SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 */
	void deleteTSecGroupMemberByUUserIdx(long TenantId,
		int TSecGroupId,
		UUID SecUserId );
}
