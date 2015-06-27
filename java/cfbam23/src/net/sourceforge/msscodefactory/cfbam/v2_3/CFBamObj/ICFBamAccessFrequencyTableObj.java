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

public interface ICFBamAccessFrequencyTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new AccessFrequency instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamAccessFrequencyObj newInstance();

	/**
	 *	Instantiate a new AccessFrequency edition of the specified AccessFrequency instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamAccessFrequencyEditObj newEditInstance( ICFBamAccessFrequencyObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamAccessFrequencyObj realizeAccessFrequency( ICFBamAccessFrequencyObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetAccessFrequency( ICFBamAccessFrequencyObj Obj );
	void forgetAccessFrequency( ICFBamAccessFrequencyObj Obj, boolean forgetSubObjects );
	void forgetAccessFrequencyByIdIdx( short Id );

	void forgetAccessFrequencyByUNameIdx( String Name );


	/**
	 *	Internal use only.
	 */
	ICFBamAccessFrequencyObj createAccessFrequency( ICFBamAccessFrequencyObj Obj );

	/**
	 *	Read a AccessFrequency-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The AccessFrequency-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamAccessFrequencyObj readAccessFrequency( CFBamAccessFrequencyPKey pkey );

	/**
	 *	Read a AccessFrequency-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The AccessFrequency-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamAccessFrequencyObj readAccessFrequency( CFBamAccessFrequencyPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamAccessFrequencyObj lockAccessFrequency( CFBamAccessFrequencyPKey pkey );

	/**
	 *	Return a sorted map of all the AccessFrequency-derived instances in the database.
	 *
	 *	@return	List of ICFBamAccessFrequencyObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamAccessFrequencyObj> readAllAccessFrequency();

	/**
	 *	Return a sorted map of all the AccessFrequency-derived instances in the database.
	 *
	 *	@return	List of ICFBamAccessFrequencyObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamAccessFrequencyObj> readAllAccessFrequency( boolean forceRead );

	/**
	 *	Get the CFBamAccessFrequencyObj instance for the primary key attributes.
	 *
	 *	@param	argId	The AccessFrequency key attribute of the instance generating the id.
	 *
	 *	@return	CFBamAccessFrequencyObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamAccessFrequencyObj readAccessFrequencyByIdIdx( short Id );

	/**
	 *	Get the CFBamAccessFrequencyObj instance for the primary key attributes.
	 *
	 *	@param	argId	The AccessFrequency key attribute of the instance generating the id.
	 *
	 *	@return	CFBamAccessFrequencyObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamAccessFrequencyObj readAccessFrequencyByIdIdx( short Id,
		boolean forceRead );

	/**
	 *	Get the CFBamAccessFrequencyObj instance for the unique UNameIdx key.
	 *
	 *	@param	argName	The AccessFrequency key attribute of the instance generating the id.
	 *
	 *	@return	CFBamAccessFrequencyObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamAccessFrequencyObj readAccessFrequencyByUNameIdx(String Name );

	/**
	 *	Get the CFBamAccessFrequencyObj instance for the unique UNameIdx key.
	 *
	 *	@param	argName	The AccessFrequency key attribute of the instance generating the id.
	 *
	 *	@return	CFBamAccessFrequencyObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamAccessFrequencyObj readAccessFrequencyByUNameIdx(String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamAccessFrequencyObj updateAccessFrequency( ICFBamAccessFrequencyObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteAccessFrequency( ICFBamAccessFrequencyObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argId	The AccessFrequency key attribute of the instance generating the id.
	 */
	void deleteAccessFrequencyByIdIdx( short Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argName	The AccessFrequency key attribute of the instance generating the id.
	 */
	void deleteAccessFrequencyByUNameIdx(String Name );
}
