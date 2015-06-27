
// Description: Java7 DbIO interface for TSecGroupMember.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBam;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;

/*
 *	CFBamTSecGroupMemberTable DbIO interface for TSecGroupMember
 */
public interface ICFBamTSecGroupMemberTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createTSecGroupMember( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateTSecGroupMember( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteTSecGroupMember( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberBuff Buff );
	/**
	 *	Delete the TSecGroupMember instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupMemberId	The TSecGroupMember key attribute of the instance generating the id.
	 */
	void deleteTSecGroupMemberByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTSecGroupMemberId );

	/**
	 *	Delete the TSecGroupMember instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteTSecGroupMemberByIdIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberPKey argKey );
	/**
	 *	Delete the TSecGroupMember instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 */
	void deleteTSecGroupMemberByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the TSecGroupMember instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGroupMemberByTenantIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberByTenantIdxKey argKey );
	/**
	 *	Delete the TSecGroupMember instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 */
	void deleteTSecGroupMemberByGroupIdx( CFBamAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId );

	/**
	 *	Delete the TSecGroupMember instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGroupMemberByGroupIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberByGroupIdxKey argKey );
	/**
	 *	Delete the TSecGroupMember instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 */
	void deleteTSecGroupMemberByUserIdx( CFBamAuthorization Authorization,
		UUID argSecUserId );

	/**
	 *	Delete the TSecGroupMember instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGroupMemberByUserIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberByUserIdxKey argKey );
	/**
	 *	Delete the TSecGroupMember instances identified by the key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 */
	void deleteTSecGroupMemberByUUserIdx( CFBamAuthorization Authorization,
		long argTenantId,
		int argTSecGroupId,
		UUID argSecUserId );

	/**
	 *	Delete the TSecGroupMember instances identified by the key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGroupMemberByUUserIdx( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberByUUserIdxKey argKey );

	/**
	 *	Open a cursor over all the instances of TSecGroupMember.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over TSecGroupMember for the specfied key
	 *		of the index.
	 */
	CFBamCursor openTSecGroupMemberCursorAll( CFBamAuthorization Authorization );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over TSecGroupMember for the specfied key
	 *		of the index.
	 */
	CFBamCursor openTSecGroupMemberCursorByTenantIdx( CFBamAuthorization Authorization,
		long TenantId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over TSecGroupMember for the specfied key
	 *		of the index.
	 */
	CFBamCursor openTSecGroupMemberCursorByGroupIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over TSecGroupMember for the specfied key
	 *		of the index.
	 */
	CFBamCursor openTSecGroupMemberCursorByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId );
	/**
	 *	Close the specified cursor.
	 *
	 *	@param	Cursor	The cursor to close.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void closeTSecGroupMemberCursor( CFBamCursor Cursor );
	/**
	 *	Get the next instance of a TSecGroupMember for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the next instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff nextTSecGroupMemberCursor( CFBamCursor Cursor );
	/**
	 *	Get the previous instance of a TSecGroupMember for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the previous instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff prevTSecGroupMemberCursor( CFBamCursor Cursor );
	/**
	 *	Get the first instance of a TSecGroupMember for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff firstTSecGroupMemberCursor( CFBamCursor Cursor );
	/**
	 *	Get the last instance of a TSecGroupMember for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the last instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff lastTSecGroupMemberCursor( CFBamCursor Cursor );
	/**
	 *	Get the nth instance of a TSecGroupMember for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@param	Idx	The zero-based cursor index.  0 is the first instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff nthTSecGroupMemberCursor( CFBamCursor Cursor, int Idx );

	/**
	 *	Read the derived TSecGroupMember buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGroupMember instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTSecGroupMemberBuff readDerived( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberPKey PKey );

	/**
	 *	Lock the derived TSecGroupMember buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGroupMember instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTSecGroupMemberBuff lockDerived( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberPKey PKey );

	/**
	 *	Read all TSecGroupMember instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamTSecGroupMemberBuff[] readAllDerived( CFBamAuthorization Authorization );

	/**
	 *	Read the derived TSecGroupMember buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupMemberId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTSecGroupMemberBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TSecGroupMemberId );

	/**
	 *	Read an array of the derived TSecGroupMember buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTSecGroupMemberBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived TSecGroupMember buffer instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTSecGroupMemberBuff[] readDerivedByGroupIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId );

	/**
	 *	Read an array of the derived TSecGroupMember buffer instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamTSecGroupMemberBuff[] readDerivedByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId );

	/**
	 *	Read the derived TSecGroupMember buffer instance identified by the unique key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamTSecGroupMemberBuff readDerivedByUUserIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		UUID SecUserId );

	/**
	 *	Read the specific TSecGroupMember buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGroupMember instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff readBuff( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberPKey PKey );

	/**
	 *	Lock the specific TSecGroupMember buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGroupMember instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff lockBuff( CFBamAuthorization Authorization,
		CFBamTSecGroupMemberPKey PKey );

	/**
	 *	Read all the specific TSecGroupMember buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TSecGroupMember instances in the database accessible for the Authorization.
	 */
	CFBamTSecGroupMemberBuff[] readAllBuff( CFBamAuthorization Authorization );

	/**
	 *	Read the specific TSecGroupMember buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupMemberId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TSecGroupMemberId );

	/**
	 *	Read an array of the specific TSecGroupMember buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific TSecGroupMember buffer instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff[] readBuffByGroupIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId );

	/**
	 *	Read an array of the specific TSecGroupMember buffer instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff[] readBuffByUserIdx( CFBamAuthorization Authorization,
		UUID SecUserId );

	/**
	 *	Read the specific TSecGroupMember buffer instance identified by the unique key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The TSecGroupMember key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamTSecGroupMemberBuff readBuffByUUserIdx( CFBamAuthorization Authorization,
		long TenantId,
		int TSecGroupId,
		UUID SecUserId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
