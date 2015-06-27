
// Description: Java7 DbIO interface for ClearSubDep2.

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
 *	CFBamClearSubDep2Table DbIO interface for ClearSubDep2
 */
public interface ICFBamClearSubDep2Table
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createClearSubDep2( CFBamAuthorization Authorization,
		CFBamClearSubDep2Buff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateClearSubDep2( CFBamAuthorization Authorization,
		CFBamClearSubDep2Buff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteClearSubDep2( CFBamAuthorization Authorization,
		CFBamClearSubDep2Buff Buff );
	/**
	 *	Delete the ClearSubDep2 instances identified by the key ContClearDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argContClearDep1TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByContClearDep1Idx( CFBamAuthorization Authorization,
		long argContClearDep1TenantId,
		long argContClearDep1Id );

	/**
	 *	Delete the ClearSubDep2 instances identified by the key ContClearDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep2ByContClearDep1Idx( CFBamAuthorization Authorization,
		CFBamClearSubDep2ByContClearDep1IdxKey argKey );
	/**
	 *	Delete the ClearSubDep2 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argContClearDep1Id,
		String argName );

	/**
	 *	Delete the ClearSubDep2 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep2ByUNameIdx( CFBamAuthorization Authorization,
		CFBamClearSubDep2ByUNameIdxKey argKey );
	/**
	 *	Delete the ClearSubDep2 instances identified by the key TableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId );

	/**
	 *	Delete the ClearSubDep2 instances identified by the key TableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep2ByTableIdx( CFBamAuthorization Authorization,
		CFBamClearDepByTableIdxKey argKey );
	/**
	 *	Delete the ClearSubDep2 instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the ClearSubDep2 instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteClearSubDep2ByIdIdx( CFBamAuthorization Authorization,
		CFBamScopePKey argKey );
	/**
	 *	Delete the ClearSubDep2 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the ClearSubDep2 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClearSubDep2ByTenantIdx( CFBamAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey );

	/**
	 *	Open a cursor over all the instances of ClearSubDep2.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over ClearSubDep2 for the specfied key
	 *		of the index.
	 */
	CFBamCursor openClearSubDep2CursorAll( CFBamAuthorization Authorization );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over ClearSubDep2 for the specfied key
	 *		of the index.
	 */
	CFBamCursor openClearSubDep2CursorByContClearDep1Idx( CFBamAuthorization Authorization,
		long ContClearDep1TenantId,
		long ContClearDep1Id );
	/**
	 *	Close the specified cursor.
	 *
	 *	@param	Cursor	The cursor to close.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void closeClearSubDep2Cursor( CFBamCursor Cursor );
	/**
	 *	Get the next instance of a ClearSubDep2 for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the next instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff nextClearSubDep2Cursor( CFBamCursor Cursor );
	/**
	 *	Get the previous instance of a ClearSubDep2 for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the previous instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff prevClearSubDep2Cursor( CFBamCursor Cursor );
	/**
	 *	Get the first instance of a ClearSubDep2 for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff firstClearSubDep2Cursor( CFBamCursor Cursor );
	/**
	 *	Get the last instance of a ClearSubDep2 for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the last instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff lastClearSubDep2Cursor( CFBamCursor Cursor );
	/**
	 *	Get the nth instance of a ClearSubDep2 for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@param	Idx	The zero-based cursor index.  0 is the first instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff nthClearSubDep2Cursor( CFBamCursor Cursor, int Idx );

	/**
	 *	Read the derived ClearSubDep2 buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep2 instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep2Buff readDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the derived ClearSubDep2 buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep2 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep2Buff lockDerived( CFBamAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all ClearSubDep2 instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep2Buff[] readAllDerived( CFBamAuthorization Authorization );

	/**
	 *	Read the derived ClearSubDep2 buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep2Buff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived ClearSubDep2 buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep2Buff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived ClearSubDep2 buffer instances identified by the duplicate key TableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep2Buff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the derived ClearSubDep2 buffer instances identified by the duplicate key ContClearDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argContClearDep1TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamClearSubDep2Buff[] readDerivedByContClearDep1Idx( CFBamAuthorization Authorization,
		long ContClearDep1TenantId,
		long ContClearDep1Id );

	/**
	 *	Read the derived ClearSubDep2 buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamClearSubDep2Buff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContClearDep1Id,
		String Name );

	/**
	 *	Read the specific ClearSubDep2 buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep2 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff readBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Lock the specific ClearSubDep2 buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ClearSubDep2 instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff lockBuff( CFBamAuthorization Authorization,
		CFBamScopePKey PKey );

	/**
	 *	Read all the specific ClearSubDep2 buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ClearSubDep2 instances in the database accessible for the Authorization.
	 */
	CFBamClearSubDep2Buff[] readAllBuff( CFBamAuthorization Authorization );

	/**
	 *	Read the specific ClearSubDep2 buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific ClearSubDep2 buffer instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific ClearSubDep2 buffer instances identified by the duplicate key TableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the specific ClearSubDep2 buffer instances identified by the duplicate key ContClearDep1Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argContClearDep1TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff[] readBuffByContClearDep1Idx( CFBamAuthorization Authorization,
		long ContClearDep1TenantId,
		long ContClearDep1Id );

	/**
	 *	Read the specific ClearSubDep2 buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argContClearDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamClearSubDep2Buff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ContClearDep1Id,
		String Name );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
