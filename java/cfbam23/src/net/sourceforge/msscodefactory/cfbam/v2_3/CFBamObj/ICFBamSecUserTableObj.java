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

public interface ICFBamSecUserTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecUser instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamSecUserObj newInstance();

	/**
	 *	Instantiate a new SecUser edition of the specified SecUser instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamSecUserEditObj newEditInstance( ICFBamSecUserObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamSecUserObj realizeSecUser( ICFBamSecUserObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecUser( ICFBamSecUserObj Obj );
	void forgetSecUser( ICFBamSecUserObj Obj, boolean forgetSubObjects );
	void forgetSecUserByIdIdx( UUID SecUserId );

	void forgetSecUserByULoginIdx( String LoginId );

	void forgetSecUserByEMConfIdx( UUID EMailConfirmationUuid );

	void forgetSecUserByPwdResetIdx( UUID PasswordResetUuid );

	void forgetSecUserByDefDevIdx( UUID DefaultDevSecUserId,
		String DefaultDevName );


	/**
	 *	Internal use only.
	 */
	ICFBamSecUserObj createSecUser( ICFBamSecUserObj Obj );

	/**
	 *	Read a SecUser-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecUser-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSecUserObj readSecUser( CFBamSecUserPKey pkey );

	/**
	 *	Read a SecUser-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecUser-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSecUserObj readSecUser( CFBamSecUserPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSecUserObj lockSecUser( CFBamSecUserPKey pkey );

	/**
	 *	Return a sorted map of all the SecUser-derived instances in the database.
	 *
	 *	@return	List of ICFBamSecUserObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSecUserObj> readAllSecUser();

	/**
	 *	Return a sorted map of all the SecUser-derived instances in the database.
	 *
	 *	@return	List of ICFBamSecUserObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSecUserObj> readAllSecUser( boolean forceRead );

	/**
	 *	Get the CFBamSecUserObj instance for the primary key attributes.
	 *
	 *	@param	argSecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecUserObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecUserObj readSecUserByIdIdx( UUID SecUserId );

	/**
	 *	Get the CFBamSecUserObj instance for the primary key attributes.
	 *
	 *	@param	argSecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecUserObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecUserObj readSecUserByIdIdx( UUID SecUserId,
		boolean forceRead );

	/**
	 *	Get the CFBamSecUserObj instance for the unique ULoginIdx key.
	 *
	 *	@param	argLoginId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecUserObj cached instance for the unique ULoginIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecUserObj readSecUserByULoginIdx(String LoginId );

	/**
	 *	Get the CFBamSecUserObj instance for the unique ULoginIdx key.
	 *
	 *	@param	argLoginId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecUserObj refreshed instance for the unique ULoginIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecUserObj readSecUserByULoginIdx(String LoginId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecUserObj instances sorted by their primary keys for the duplicate EMConfIdx key.
	 *
	 *	@param	argEMailConfirmationUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecUserObj cached instances sorted by their primary keys for the duplicate EMConfIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecUserObj> readSecUserByEMConfIdx( UUID EMailConfirmationUuid );

	/**
	 *	Get the map of CFBamSecUserObj instances sorted by their primary keys for the duplicate EMConfIdx key.
	 *
	 *	@param	argEMailConfirmationUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecUserObj cached instances sorted by their primary keys for the duplicate EMConfIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecUserObj> readSecUserByEMConfIdx( UUID EMailConfirmationUuid,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSecUserObj instances sorted by their primary keys for the duplicate PwdResetIdx key.
	 *
	 *	@param	argPasswordResetUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecUserObj cached instances sorted by their primary keys for the duplicate PwdResetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecUserObj> readSecUserByPwdResetIdx( UUID PasswordResetUuid );

	/**
	 *	Get the map of CFBamSecUserObj instances sorted by their primary keys for the duplicate PwdResetIdx key.
	 *
	 *	@param	argPasswordResetUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSecUserObj cached instances sorted by their primary keys for the duplicate PwdResetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSecUserObj> readSecUserByPwdResetIdx( UUID PasswordResetUuid,
		boolean forceRead );

	/**
	 *	Get the CFBamSecUserObj instance for the unique DefDevIdx key.
	 *
	 *	@param	argDefaultDevSecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	argDefaultDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecUserObj cached instance for the unique DefDevIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecUserObj readSecUserByDefDevIdx(UUID DefaultDevSecUserId,
		String DefaultDevName );

	/**
	 *	Get the CFBamSecUserObj instance for the unique DefDevIdx key.
	 *
	 *	@param	argDefaultDevSecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	argDefaultDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSecUserObj refreshed instance for the unique DefDevIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSecUserObj readSecUserByDefDevIdx(UUID DefaultDevSecUserId,
		String DefaultDevName,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSecUserObj updateSecUser( ICFBamSecUserObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecUser( ICFBamSecUserObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByIdIdx( UUID SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argLoginId	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByULoginIdx(String LoginId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEMailConfirmationUuid	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByEMConfIdx( UUID EMailConfirmationUuid );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPasswordResetUuid	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByPwdResetIdx( UUID PasswordResetUuid );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefaultDevSecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	argDefaultDevName	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByDefDevIdx(UUID DefaultDevSecUserId,
		String DefaultDevName );

	ICFBamSecUserObj getSystemUser();
}
