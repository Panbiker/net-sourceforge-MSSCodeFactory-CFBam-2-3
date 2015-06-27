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

public interface ICFBamSecGroupFormTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecGroupForm instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamSecGroupFormObj newInstance();

	/**
	 *	Instantiate a new SecGroupForm edition of the specified SecGroupForm instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamSecGroupFormEditObj newEditInstance( ICFBamSecGroupFormObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupFormObj realizeSecGroupForm( ICFBamSecGroupFormObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecGroupForm( ICFBamSecGroupFormObj Obj );
	void forgetSecGroupForm( ICFBamSecGroupFormObj Obj, boolean forgetSubObjects );
	void forgetSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId );

	void forgetSecGroupFormByClusterIdx( long ClusterId );

	void forgetSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId );

	void forgetSecGroupFormByAppIdx( long ClusterId,
		int SecAppId );

	void forgetSecGroupFormByFormIdx( long ClusterId,
		int SecFormId );

	void forgetSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId );


	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupFormObj createSecGroupForm( ICFBamSecGroupFormObj Obj );

	/**
	 *	Read a SecGroupForm-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGroupForm-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSecGroupFormObj readSecGroupForm( CFBamSecGroupFormPKey pkey );

	/**
	 *	Read a SecGroupForm-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGroupForm-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSecGroupFormObj readSecGroupForm( CFBamSecGroupFormPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupFormObj lockSecGroupForm( CFBamSecGroupFormPKey pkey );

	/**
	 *	Return a sorted map of all the SecGroupForm-derived instances in the database.
	 *
	 *	@return	List of ICFBamSecGroupFormObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSecGroupFormObj> readAllSecGroupForm();

	/**
	 *	Return a sorted map of all the SecGroupForm-derived instances in the database.
	 *
	 *	@return	List of ICFBamSecGroupFormObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSecGroupFormObj> readAllSecGroupForm( boolean forceRead );

	/**
	 *	Get the CFBamSecGroupFormObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupFormId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupFormObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupFormObj readSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId );

	/**
	 *	Get the CFBamSecGroupFormObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupFormId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupFormObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupFormObj readSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecGroupFormObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupFormObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupFormObj> readSecGroupFormByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFBamSecGroupFormObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupFormObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupFormObj> readSecGroupFormByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecGroupFormObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupFormObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupFormObj> readSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Get the map of CFBamSecGroupFormObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupFormObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupFormObj> readSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecGroupFormObj instances sorted by their primary keys for the duplicate AppIdx key.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecAppId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupFormObj cached instances sorted by their primary keys for the duplicate AppIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupFormObj> readSecGroupFormByAppIdx( long ClusterId,
		int SecAppId );

	/**
	 *	Get the map of CFBamSecGroupFormObj instances sorted by their primary keys for the duplicate AppIdx key.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecAppId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupFormObj cached instances sorted by their primary keys for the duplicate AppIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupFormObj> readSecGroupFormByAppIdx( long ClusterId,
		int SecAppId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecGroupFormObj instances sorted by their primary keys for the duplicate FormIdx key.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecFormId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupFormObj cached instances sorted by their primary keys for the duplicate FormIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupFormObj> readSecGroupFormByFormIdx( long ClusterId,
		int SecFormId );

	/**
	 *	Get the map of CFBamSecGroupFormObj instances sorted by their primary keys for the duplicate FormIdx key.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecFormId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecGroupFormObj cached instances sorted by their primary keys for the duplicate FormIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecGroupFormObj> readSecGroupFormByFormIdx( long ClusterId,
		int SecFormId,
		boolean forceRead );

	/**
	 *	Get the CFBamSecGroupFormObj instance for the unique UFormIdx key.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecFormId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupFormObj cached instance for the unique UFormIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupFormObj readSecGroupFormByUFormIdx(long ClusterId,
		int SecGroupId,
		int SecFormId );

	/**
	 *	Get the CFBamSecGroupFormObj instance for the unique UFormIdx key.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecFormId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecGroupFormObj refreshed instance for the unique UFormIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecGroupFormObj readSecGroupFormByUFormIdx(long ClusterId,
		int SecGroupId,
		int SecFormId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSecGroupFormObj updateSecGroupForm( ICFBamSecGroupFormObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecGroupForm( ICFBamSecGroupFormObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupFormId	The SecGroupForm key attribute of the instance generating the id.
	 */
	void deleteSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 */
	void deleteSecGroupFormByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupForm key attribute of the instance generating the id.
	 */
	void deleteSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecAppId	The SecGroupForm key attribute of the instance generating the id.
	 */
	void deleteSecGroupFormByAppIdx( long ClusterId,
		int SecAppId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecFormId	The SecGroupForm key attribute of the instance generating the id.
	 */
	void deleteSecGroupFormByFormIdx( long ClusterId,
		int SecFormId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecFormId	The SecGroupForm key attribute of the instance generating the id.
	 */
	void deleteSecGroupFormByUFormIdx(long ClusterId,
		int SecGroupId,
		int SecFormId );
}
