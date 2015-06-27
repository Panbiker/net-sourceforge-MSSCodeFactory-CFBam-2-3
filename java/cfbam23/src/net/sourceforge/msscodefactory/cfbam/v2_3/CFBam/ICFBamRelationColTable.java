
// Description: Java7 DbIO interface for RelationCol.

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
 *	CFBamRelationColTable DbIO interface for RelationCol
 */
public interface ICFBamRelationColTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createRelationCol( CFBamAuthorization Authorization,
		CFBamRelationColBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateRelationCol( CFBamAuthorization Authorization,
		CFBamRelationColBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteRelationCol( CFBamAuthorization Authorization,
		CFBamRelationColBuff Buff );
	/**
	 *	Delete the RelationCol instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the RelationCol instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteRelationColByIdIdx( CFBamAuthorization Authorization,
		CFBamRelationColPKey argKey );
	/**
	 *	Delete the RelationCol instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId,
		String argName );

	/**
	 *	Delete the RelationCol instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteRelationColByUNameIdx( CFBamAuthorization Authorization,
		CFBamRelationColByUNameIdxKey argKey );
	/**
	 *	Delete the RelationCol instances identified by the key RelColTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByRelColTenantIdx( CFBamAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the RelationCol instances identified by the key RelColTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteRelationColByRelColTenantIdx( CFBamAuthorization Authorization,
		CFBamRelationColByRelColTenantIdxKey argKey );
	/**
	 *	Delete the RelationCol instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByRelationIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId );

	/**
	 *	Delete the RelationCol instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteRelationColByRelationIdx( CFBamAuthorization Authorization,
		CFBamRelationColByRelationIdxKey argKey );
	/**
	 *	Delete the RelationCol instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the RelationCol instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteRelationColByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamRelationColByDefSchemaIdxKey argKey );
	/**
	 *	Delete the RelationCol instances identified by the key FromColIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argFromColId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByFromColIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argFromColId );

	/**
	 *	Delete the RelationCol instances identified by the key FromColIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteRelationColByFromColIdx( CFBamAuthorization Authorization,
		CFBamRelationColByFromColIdxKey argKey );
	/**
	 *	Delete the RelationCol instances identified by the key ToColIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argToColId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByToColIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argToColId );

	/**
	 *	Delete the RelationCol instances identified by the key ToColIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteRelationColByToColIdx( CFBamAuthorization Authorization,
		CFBamRelationColByToColIdxKey argKey );
	/**
	 *	Delete the RelationCol instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the RelationCol instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteRelationColByPrevIdx( CFBamAuthorization Authorization,
		CFBamRelationColByPrevIdxKey argKey );
	/**
	 *	Delete the RelationCol instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the RelationCol instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteRelationColByNextIdx( CFBamAuthorization Authorization,
		CFBamRelationColByNextIdxKey argKey );
	/**
	 *	Delete the RelationCol instances identified by the key RelPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByRelPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId,
		Long argPrevId );

	/**
	 *	Delete the RelationCol instances identified by the key RelPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteRelationColByRelPrevIdx( CFBamAuthorization Authorization,
		CFBamRelationColByRelPrevIdxKey argKey );
	/**
	 *	Delete the RelationCol instances identified by the key RelNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByRelNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argRelationId,
		Long argNextId );

	/**
	 *	Delete the RelationCol instances identified by the key RelNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteRelationColByRelNextIdx( CFBamAuthorization Authorization,
		CFBamRelationColByRelNextIdxKey argKey );

	/**
	 *	Open a cursor over all the instances of RelationCol.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over RelationCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openRelationColCursorAll( CFBamAuthorization Authorization );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over RelationCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openRelationColCursorByRelColTenantIdx( CFBamAuthorization Authorization,
		long TenantId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over RelationCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openRelationColCursorByRelationIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over RelationCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openRelationColCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over RelationCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openRelationColCursorByFromColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long FromColId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over RelationCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openRelationColCursorByToColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToColId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over RelationCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openRelationColCursorByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over RelationCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openRelationColCursorByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over RelationCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openRelationColCursorByRelPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long PrevId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over RelationCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openRelationColCursorByRelNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long NextId );
	/**
	 *	Close the specified cursor.
	 *
	 *	@param	Cursor	The cursor to close.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void closeRelationColCursor( CFBamCursor Cursor );
	/**
	 *	Get the next instance of a RelationCol for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the next instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff nextRelationColCursor( CFBamCursor Cursor );
	/**
	 *	Get the previous instance of a RelationCol for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the previous instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff prevRelationColCursor( CFBamCursor Cursor );
	/**
	 *	Get the first instance of a RelationCol for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff firstRelationColCursor( CFBamCursor Cursor );
	/**
	 *	Get the last instance of a RelationCol for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the last instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff lastRelationColCursor( CFBamCursor Cursor );
	/**
	 *	Get the nth instance of a RelationCol for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@param	Idx	The zero-based cursor index.  0 is the first instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff nthRelationColCursor( CFBamCursor Cursor, int Idx );

	/**
	 *	Read the derived RelationCol buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the RelationCol instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamRelationColBuff readDerived( CFBamAuthorization Authorization,
		CFBamRelationColPKey PKey );

	/**
	 *	Lock the derived RelationCol buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the RelationCol instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamRelationColBuff lockDerived( CFBamAuthorization Authorization,
		CFBamRelationColPKey PKey );

	/**
	 *	Read all RelationCol instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamRelationColBuff[] readAllDerived( CFBamAuthorization Authorization );

	/**
	 *	Read the derived RelationCol buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamRelationColBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the derived RelationCol buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamRelationColBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		String Name );

	/**
	 *	Read an array of the derived RelationCol buffer instances identified by the duplicate key RelColTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamRelationColBuff[] readDerivedByRelColTenantIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived RelationCol buffer instances identified by the duplicate key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamRelationColBuff[] readDerivedByRelationIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the derived RelationCol buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamRelationColBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived RelationCol buffer instances identified by the duplicate key FromColIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argFromColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamRelationColBuff[] readDerivedByFromColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long FromColId );

	/**
	 *	Read an array of the derived RelationCol buffer instances identified by the duplicate key ToColIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argToColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamRelationColBuff[] readDerivedByToColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToColId );

	/**
	 *	Read an array of the derived RelationCol buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamRelationColBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived RelationCol buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamRelationColBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the derived RelationCol buffer instances identified by the duplicate key RelPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamRelationColBuff[] readDerivedByRelPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long PrevId );

	/**
	 *	Read an array of the derived RelationCol buffer instances identified by the duplicate key RelNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamRelationColBuff[] readDerivedByRelNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long NextId );

	/**
	 *	Read the specific RelationCol buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the RelationCol instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff readBuff( CFBamAuthorization Authorization,
		CFBamRelationColPKey PKey );

	/**
	 *	Lock the specific RelationCol buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the RelationCol instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff lockBuff( CFBamAuthorization Authorization,
		CFBamRelationColPKey PKey );

	/**
	 *	Read all the specific RelationCol buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific RelationCol instances in the database accessible for the Authorization.
	 */
	CFBamRelationColBuff[] readAllBuff( CFBamAuthorization Authorization );

	/**
	 *	Read the specific RelationCol buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the specific RelationCol buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		String Name );

	/**
	 *	Read an array of the specific RelationCol buffer instances identified by the duplicate key RelColTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff[] readBuffByRelColTenantIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific RelationCol buffer instances identified by the duplicate key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff[] readBuffByRelationIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId );

	/**
	 *	Read an array of the specific RelationCol buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific RelationCol buffer instances identified by the duplicate key FromColIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argFromColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff[] readBuffByFromColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long FromColId );

	/**
	 *	Read an array of the specific RelationCol buffer instances identified by the duplicate key ToColIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argToColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff[] readBuffByToColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ToColId );

	/**
	 *	Read an array of the specific RelationCol buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific RelationCol buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the specific RelationCol buffer instances identified by the duplicate key RelPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff[] readBuffByRelPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long PrevId );

	/**
	 *	Read an array of the specific RelationCol buffer instances identified by the duplicate key RelNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamRelationColBuff[] readBuffByRelNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long RelationId,
		Long NextId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamRelationColBuff moveBuffUp( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamRelationColBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
