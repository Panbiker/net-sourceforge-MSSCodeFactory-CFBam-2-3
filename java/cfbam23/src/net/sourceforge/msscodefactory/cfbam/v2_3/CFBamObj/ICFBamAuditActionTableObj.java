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

public interface ICFBamAuditActionTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new AuditAction instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamAuditActionObj newInstance();

	/**
	 *	Instantiate a new AuditAction edition of the specified AuditAction instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamAuditActionEditObj newEditInstance( ICFBamAuditActionObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamAuditActionObj realizeAuditAction( ICFBamAuditActionObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetAuditAction( ICFBamAuditActionObj Obj );
	void forgetAuditAction( ICFBamAuditActionObj Obj, boolean forgetSubObjects );
	void forgetAuditActionByIdIdx( short AuditActionId );

	void forgetAuditActionByUDescrIdx( String Description );


	/**
	 *	Internal use only.
	 */
	ICFBamAuditActionObj createAuditAction( ICFBamAuditActionObj Obj );

	/**
	 *	Read a AuditAction-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The AuditAction-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamAuditActionObj readAuditAction( CFBamAuditActionPKey pkey );

	/**
	 *	Read a AuditAction-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The AuditAction-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamAuditActionObj readAuditAction( CFBamAuditActionPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamAuditActionObj lockAuditAction( CFBamAuditActionPKey pkey );

	/**
	 *	Return a sorted map of all the AuditAction-derived instances in the database.
	 *
	 *	@return	List of ICFBamAuditActionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamAuditActionObj> readAllAuditAction();

	/**
	 *	Return a sorted map of all the AuditAction-derived instances in the database.
	 *
	 *	@return	List of ICFBamAuditActionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamAuditActionObj> readAllAuditAction( boolean forceRead );

	/**
	 *	Get the CFBamAuditActionObj instance for the primary key attributes.
	 *
	 *	@param	argAuditActionId	The AuditAction key attribute of the instance generating the id.
	 *
	 *	@return	CFBamAuditActionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamAuditActionObj readAuditActionByIdIdx( short AuditActionId );

	/**
	 *	Get the CFBamAuditActionObj instance for the primary key attributes.
	 *
	 *	@param	argAuditActionId	The AuditAction key attribute of the instance generating the id.
	 *
	 *	@return	CFBamAuditActionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamAuditActionObj readAuditActionByIdIdx( short AuditActionId,
		boolean forceRead );

	/**
	 *	Get the CFBamAuditActionObj instance for the unique UDescrIdx key.
	 *
	 *	@param	argDescription	The AuditAction key attribute of the instance generating the id.
	 *
	 *	@return	CFBamAuditActionObj cached instance for the unique UDescrIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamAuditActionObj readAuditActionByUDescrIdx(String Description );

	/**
	 *	Get the CFBamAuditActionObj instance for the unique UDescrIdx key.
	 *
	 *	@param	argDescription	The AuditAction key attribute of the instance generating the id.
	 *
	 *	@return	CFBamAuditActionObj refreshed instance for the unique UDescrIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamAuditActionObj readAuditActionByUDescrIdx(String Description,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamAuditActionObj updateAuditAction( ICFBamAuditActionObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteAuditAction( ICFBamAuditActionObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argAuditActionId	The AuditAction key attribute of the instance generating the id.
	 */
	void deleteAuditActionByIdIdx( short AuditActionId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDescription	The AuditAction key attribute of the instance generating the id.
	 */
	void deleteAuditActionByUDescrIdx(String Description );

	void bootstrapAuditActions();
}
