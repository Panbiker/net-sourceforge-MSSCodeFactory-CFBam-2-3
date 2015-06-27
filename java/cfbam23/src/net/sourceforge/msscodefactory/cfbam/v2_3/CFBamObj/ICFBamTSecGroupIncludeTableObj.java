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

public interface ICFBamTSecGroupIncludeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TSecGroupInclude instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTSecGroupIncludeObj newInstance();

	/**
	 *	Instantiate a new TSecGroupInclude edition of the specified TSecGroupInclude instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTSecGroupIncludeEditObj newEditInstance( ICFBamTSecGroupIncludeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTSecGroupIncludeObj realizeTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj );
	void forgetTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj, boolean forgetSubObjects );
	void forgetTSecGroupIncludeByIdIdx( long TenantId,
		long TSecGroupIncludeId );

	void forgetTSecGroupIncludeByTenantIdx( long TenantId );

	void forgetTSecGroupIncludeByGroupIdx( long TenantId,
		int TSecGroupId );

	void forgetTSecGroupIncludeByIncludeIdx( long TenantId,
		int IncludeGroupId );

	void forgetTSecGroupIncludeByUIncludeIdx( long TenantId,
		int TSecGroupId,
		int IncludeGroupId );


	/**
	 *	Internal use only.
	 */
	ICFBamTSecGroupIncludeObj createTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj );

	/**
	 *	Read a TSecGroupInclude-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TSecGroupInclude-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTSecGroupIncludeObj readTSecGroupInclude( CFBamTSecGroupIncludePKey pkey );

	/**
	 *	Read a TSecGroupInclude-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TSecGroupInclude-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTSecGroupIncludeObj readTSecGroupInclude( CFBamTSecGroupIncludePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTSecGroupIncludeObj lockTSecGroupInclude( CFBamTSecGroupIncludePKey pkey );

	/**
	 *	Return a sorted map of all the TSecGroupInclude-derived instances in the database.
	 *
	 *	@return	List of ICFBamTSecGroupIncludeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTSecGroupIncludeObj> readAllTSecGroupInclude();

	/**
	 *	Return a sorted map of all the TSecGroupInclude-derived instances in the database.
	 *
	 *	@return	List of ICFBamTSecGroupIncludeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTSecGroupIncludeObj> readAllTSecGroupInclude( boolean forceRead );

	/**
	 *	Get the CFBamTSecGroupIncludeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupIncludeId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTSecGroupIncludeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTSecGroupIncludeObj readTSecGroupIncludeByIdIdx( long TenantId,
		long TSecGroupIncludeId );

	/**
	 *	Get the CFBamTSecGroupIncludeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupIncludeId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTSecGroupIncludeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTSecGroupIncludeObj readTSecGroupIncludeByIdIdx( long TenantId,
		long TSecGroupIncludeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTSecGroupIncludeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamTSecGroupIncludeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTSecGroupIncludeObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByGroupIdx( long TenantId,
		int TSecGroupId );

	/**
	 *	Get the map of CFBamTSecGroupIncludeObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByGroupIdx( long TenantId,
		int TSecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTSecGroupIncludeObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByIncludeIdx( long TenantId,
		int IncludeGroupId );

	/**
	 *	Get the map of CFBamTSecGroupIncludeObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTSecGroupIncludeObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTSecGroupIncludeObj> readTSecGroupIncludeByIncludeIdx( long TenantId,
		int IncludeGroupId,
		boolean forceRead );

	/**
	 *	Get the CFBamTSecGroupIncludeObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTSecGroupIncludeObj cached instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTSecGroupIncludeObj readTSecGroupIncludeByUIncludeIdx(long TenantId,
		int TSecGroupId,
		int IncludeGroupId );

	/**
	 *	Get the CFBamTSecGroupIncludeObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTSecGroupIncludeObj refreshed instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTSecGroupIncludeObj readTSecGroupIncludeByUIncludeIdx(long TenantId,
		int TSecGroupId,
		int IncludeGroupId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTSecGroupIncludeObj updateTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTSecGroupInclude( ICFBamTSecGroupIncludeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupIncludeId	The TSecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteTSecGroupIncludeByIdIdx( long TenantId,
		long TSecGroupIncludeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteTSecGroupIncludeByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteTSecGroupIncludeByGroupIdx( long TenantId,
		int TSecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteTSecGroupIncludeByIncludeIdx( long TenantId,
		int IncludeGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The TSecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteTSecGroupIncludeByUIncludeIdx(long TenantId,
		int TSecGroupId,
		int IncludeGroupId );
}
