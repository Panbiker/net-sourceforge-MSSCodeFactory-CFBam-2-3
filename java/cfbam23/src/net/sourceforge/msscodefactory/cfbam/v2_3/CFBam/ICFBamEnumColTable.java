
// Description: Java7 DbIO interface for EnumCol.

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
 *	CFBamEnumColTable DbIO interface for EnumCol
 */
public interface ICFBamEnumColTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createEnumCol( CFBamAuthorization Authorization,
		CFBamEnumColBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateEnumCol( CFBamAuthorization Authorization,
		CFBamEnumColBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteEnumCol( CFBamAuthorization Authorization,
		CFBamEnumColBuff Buff );
	/**
	 *	Delete the EnumCol instances identified by the key TableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByTableIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argTableId );

	/**
	 *	Delete the EnumCol instances identified by the key TableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByTableIdx( CFBamAuthorization Authorization,
		CFBamEnumColByTableIdxKey argKey );
	/**
	 *	Delete the EnumCol instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the EnumCol instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteEnumColByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName );

	/**
	 *	Delete the EnumCol instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the EnumCol instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId );

	/**
	 *	Delete the EnumCol instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the EnumCol instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDataScopeId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId );

	/**
	 *	Delete the EnumCol instances identified by the key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessSecurityId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId );

	/**
	 *	Delete the EnumCol instances identified by the key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessFrequencyId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId );

	/**
	 *	Delete the EnumCol instances identified by the key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessSecurityId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId );

	/**
	 *	Delete the EnumCol instances identified by the key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessFrequencyId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId );

	/**
	 *	Delete the EnumCol instances identified by the key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the EnumCol instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the EnumCol instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId );

	/**
	 *	Delete the EnumCol instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey );
	/**
	 *	Delete the EnumCol instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumCol key attribute of the instance generating the id.
	 */
	void deleteEnumColByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId );

	/**
	 *	Delete the EnumCol instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteEnumColByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey );

	/**
	 *	Open a cursor over all the instances of EnumCol.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over EnumCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openEnumColCursorAll( CFBamAuthorization Authorization );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over EnumCol for the specfied key
	 *		of the index.
	 */
	CFBamCursor openEnumColCursorByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId );
	/**
	 *	Close the specified cursor.
	 *
	 *	@param	Cursor	The cursor to close.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void closeEnumColCursor( CFBamCursor Cursor );
	/**
	 *	Get the next instance of a EnumCol for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the next instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff nextEnumColCursor( CFBamCursor Cursor );
	/**
	 *	Get the previous instance of a EnumCol for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the previous instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff prevEnumColCursor( CFBamCursor Cursor );
	/**
	 *	Get the first instance of a EnumCol for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff firstEnumColCursor( CFBamCursor Cursor );
	/**
	 *	Get the last instance of a EnumCol for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the last instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff lastEnumColCursor( CFBamCursor Cursor );
	/**
	 *	Get the nth instance of a EnumCol for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@param	Idx	The zero-based cursor index.  0 is the first instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff nthEnumColCursor( CFBamCursor Cursor, int Idx );

	/**
	 *	Read the derived EnumCol buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the EnumCol instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamEnumColBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the derived EnumCol buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the EnumCol instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamEnumColBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all EnumCol instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readAllDerived( CFBamAuthorization Authorization );

	/**
	 *	Read the derived EnumCol buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamEnumColBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the derived EnumCol buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamEnumColBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDataScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessSecurityId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessFrequencyId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessSecurityId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessFrequencyId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read an array of the derived EnumCol buffer instances identified by the duplicate key TableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamEnumColBuff[] readDerivedByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId );

	/**
	 *	Read the specific EnumCol buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the EnumCol instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the specific EnumCol buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the EnumCol instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all the specific EnumCol buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific EnumCol instances in the database accessible for the Authorization.
	 */
	CFBamEnumColBuff[] readAllBuff( CFBamAuthorization Authorization );

	/**
	 *	Read the specific EnumCol buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the specific EnumCol buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDataScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessSecurityId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessFrequencyId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessSecurityId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessFrequencyId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read an array of the specific EnumCol buffer instances identified by the duplicate key TableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The EnumCol key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamEnumColBuff[] readBuffByTableIdx( CFBamAuthorization Authorization,
		long TenantId,
		long TableId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamEnumColBuff moveBuffUp( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamEnumColBuff moveBuffDown( CFBamAuthorization Authorization,
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
