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

public interface ICFBamClearSubDep3TableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ClearSubDep3 instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamClearSubDep3Obj newInstance();

	/**
	 *	Instantiate a new ClearSubDep3 edition of the specified ClearSubDep3 instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamClearSubDep3EditObj newEditInstance( ICFBamClearSubDep3Obj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamClearSubDep3Obj realizeClearSubDep3( ICFBamClearSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetClearSubDep3( ICFBamClearSubDep3Obj Obj );
	void forgetClearSubDep3( ICFBamClearSubDep3Obj Obj, boolean forgetSubObjects );
	void forgetClearSubDep3ByIdIdx( long TenantId,
		long Id );

	void forgetClearSubDep3ByTenantIdx( long TenantId );

	void forgetClearSubDep3ByTableIdx( long TenantId,
		long RelationId );

	void forgetClearSubDep3ByContClearDep2Idx( long ContClearDep2TenantId,
		long ContClearDep2Id );

	void forgetClearSubDep3ByUNameIdx( long TenantId,
		long ContClearDep2Id,
		String Name );


	/**
	 *	Internal use only.
	 */
	ICFBamClearSubDep3Obj createClearSubDep3( ICFBamClearSubDep3Obj Obj );

	/**
	 *	Read a ClearSubDep3-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearSubDep3-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamClearSubDep3Obj readClearSubDep3( CFBamScopePKey pkey );

	/**
	 *	Read a ClearSubDep3-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearSubDep3-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamClearSubDep3Obj readClearSubDep3( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamClearSubDep3Obj lockClearSubDep3( CFBamScopePKey pkey );

	/**
	 *	Return a sorted map of all the ClearSubDep3-derived instances in the database.
	 *
	 *	@return	List of ICFBamClearSubDep3Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamClearSubDep3Obj> readAllClearSubDep3();

	/**
	 *	Return a sorted map of all the ClearSubDep3-derived instances in the database.
	 *
	 *	@return	List of ICFBamClearSubDep3Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamClearSubDep3Obj> readAllClearSubDep3( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearSubDep3Obj readClearSubDep3ByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearSubDep3Obj readClearSubDep3ByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamScopeObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep3Obj> readClearSubDep3ByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamScopeObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep3Obj> readClearSubDep3ByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearDepObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep3Obj> readClearSubDep3ByTableIdx( long TenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamClearDepObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearDepObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep3Obj> readClearSubDep3ByTableIdx( long TenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamClearSubDep3Obj instances sorted by their primary keys for the duplicate ContClearDep2Idx key.
	 *
	 *	@param	argContClearDep2TenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearSubDep3Obj cached instances sorted by their primary keys for the duplicate ContClearDep2Idx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep3Obj> readClearSubDep3ByContClearDep2Idx( long ContClearDep2TenantId,
		long ContClearDep2Id );

	/**
	 *	Get the map of CFBamClearSubDep3Obj instances sorted by their primary keys for the duplicate ContClearDep2Idx key.
	 *
	 *	@param	argContClearDep2TenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamClearSubDep3Obj cached instances sorted by their primary keys for the duplicate ContClearDep2Idx key,
	 *		which may be an empty set.
	 */
	List<ICFBamClearSubDep3Obj> readClearSubDep3ByContClearDep2Idx( long ContClearDep2TenantId,
		long ContClearDep2Id,
		boolean forceRead );

	/**
	 *	Get the CFBamClearSubDep3Obj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamClearSubDep3Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearSubDep3Obj readClearSubDep3ByUNameIdx(long TenantId,
		long ContClearDep2Id,
		String Name );

	/**
	 *	Get the CFBamClearSubDep3Obj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamClearSubDep3Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamClearSubDep3Obj readClearSubDep3ByUNameIdx(long TenantId,
		long ContClearDep2Id,
		String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamClearSubDep3Obj updateClearSubDep3( ICFBamClearSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteClearSubDep3( ICFBamClearSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByTableIdx( long TenantId,
		long RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argContClearDep2TenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByContClearDep2Idx( long ContClearDep2TenantId,
		long ContClearDep2Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByUNameIdx(long TenantId,
		long ContClearDep2Id,
		String Name );
}
