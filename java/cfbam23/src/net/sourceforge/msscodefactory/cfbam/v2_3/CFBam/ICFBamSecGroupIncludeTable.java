
// Description: Java7 DbIO interface for SecGroupInclude.

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
 *	CFBamSecGroupIncludeTable DbIO interface for SecGroupInclude
 */
public interface ICFBamSecGroupIncludeTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createSecGroupInclude( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateSecGroupInclude( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteSecGroupInclude( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeBuff Buff );
	/**
	 *	Delete the SecGroupInclude instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupIncludeId	The SecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteSecGroupIncludeByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argSecGroupIncludeId );

	/**
	 *	Delete the SecGroupInclude instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecGroupIncludeByIdIdx( CFBamAuthorization Authorization,
		CFBamSecGroupIncludePKey argKey );
	/**
	 *	Delete the SecGroupInclude instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteSecGroupIncludeByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId );

	/**
	 *	Delete the SecGroupInclude instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGroupIncludeByClusterIdx( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeByClusterIdxKey argKey );
	/**
	 *	Delete the SecGroupInclude instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteSecGroupIncludeByGroupIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId );

	/**
	 *	Delete the SecGroupInclude instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGroupIncludeByGroupIdx( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeByGroupIdxKey argKey );
	/**
	 *	Delete the SecGroupInclude instances identified by the key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteSecGroupIncludeByIncludeIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argIncludeGroupId );

	/**
	 *	Delete the SecGroupInclude instances identified by the key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGroupIncludeByIncludeIdx( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeByIncludeIdxKey argKey );
	/**
	 *	Delete the SecGroupInclude instances identified by the key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 */
	void deleteSecGroupIncludeByUIncludeIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		int argIncludeGroupId );

	/**
	 *	Delete the SecGroupInclude instances identified by the key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGroupIncludeByUIncludeIdx( CFBamAuthorization Authorization,
		CFBamSecGroupIncludeByUIncludeIdxKey argKey );

	/**
	 *	Open a cursor over all the instances of SecGroupInclude.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over SecGroupInclude for the specfied key
	 *		of the index.
	 */
	CFBamCursor openSecGroupIncludeCursorAll( CFBamAuthorization Authorization );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over SecGroupInclude for the specfied key
	 *		of the index.
	 */
	CFBamCursor openSecGroupIncludeCursorByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over SecGroupInclude for the specfied key
	 *		of the index.
	 */
	CFBamCursor openSecGroupIncludeCursorByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over SecGroupInclude for the specfied key
	 *		of the index.
	 */
	CFBamCursor openSecGroupIncludeCursorByIncludeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int IncludeGroupId );
	/**
	 *	Close the specified cursor.
	 *
	 *	@param	Cursor	The cursor to close.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void closeSecGroupIncludeCursor( CFBamCursor Cursor );
	/**
	 *	Get the next instance of a SecGroupInclude for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the next instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff nextSecGroupIncludeCursor( CFBamCursor Cursor );
	/**
	 *	Get the previous instance of a SecGroupInclude for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the previous instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff prevSecGroupIncludeCursor( CFBamCursor Cursor );
	/**
	 *	Get the first instance of a SecGroupInclude for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff firstSecGroupIncludeCursor( CFBamCursor Cursor );
	/**
	 *	Get the last instance of a SecGroupInclude for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the last instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff lastSecGroupIncludeCursor( CFBamCursor Cursor );
	/**
	 *	Get the nth instance of a SecGroupInclude for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@param	Idx	The zero-based cursor index.  0 is the first instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff nthSecGroupIncludeCursor( CFBamCursor Cursor, int Idx );

	/**
	 *	Read the derived SecGroupInclude buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGroupInclude instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamSecGroupIncludeBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecGroupIncludePKey PKey );

	/**
	 *	Lock the derived SecGroupInclude buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGroupInclude instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamSecGroupIncludeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecGroupIncludePKey PKey );

	/**
	 *	Read all SecGroupInclude instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamSecGroupIncludeBuff[] readAllDerived( CFBamAuthorization Authorization );

	/**
	 *	Read the derived SecGroupInclude buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupIncludeId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamSecGroupIncludeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long SecGroupIncludeId );

	/**
	 *	Read an array of the derived SecGroupInclude buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamSecGroupIncludeBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read an array of the derived SecGroupInclude buffer instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamSecGroupIncludeBuff[] readDerivedByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId );

	/**
	 *	Read an array of the derived SecGroupInclude buffer instances identified by the duplicate key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamSecGroupIncludeBuff[] readDerivedByIncludeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int IncludeGroupId );

	/**
	 *	Read the derived SecGroupInclude buffer instance identified by the unique key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamSecGroupIncludeBuff readDerivedByUIncludeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int IncludeGroupId );

	/**
	 *	Read the specific SecGroupInclude buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGroupInclude instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecGroupIncludePKey PKey );

	/**
	 *	Lock the specific SecGroupInclude buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGroupInclude instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecGroupIncludePKey PKey );

	/**
	 *	Read all the specific SecGroupInclude buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecGroupInclude instances in the database accessible for the Authorization.
	 */
	CFBamSecGroupIncludeBuff[] readAllBuff( CFBamAuthorization Authorization );

	/**
	 *	Read the specific SecGroupInclude buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupIncludeId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long ClusterId,
		long SecGroupIncludeId );

	/**
	 *	Read an array of the specific SecGroupInclude buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read an array of the specific SecGroupInclude buffer instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff[] readBuffByGroupIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId );

	/**
	 *	Read an array of the specific SecGroupInclude buffer instances identified by the duplicate key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff[] readBuffByIncludeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int IncludeGroupId );

	/**
	 *	Read the specific SecGroupInclude buffer instance identified by the unique key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGroupInclude key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamSecGroupIncludeBuff readBuffByUIncludeIdx( CFBamAuthorization Authorization,
		long ClusterId,
		int SecGroupId,
		int IncludeGroupId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
