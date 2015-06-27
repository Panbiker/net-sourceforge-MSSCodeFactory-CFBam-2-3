
// Description: Java7 DbIO interface for StringType.

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
 *	CFBamStringTypeTable DbIO interface for StringType
 */
public interface ICFBamStringTypeTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createStringType( CFBamAuthorization Authorization,
		CFBamStringTypeBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateStringType( CFBamAuthorization Authorization,
		CFBamStringTypeBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteStringType( CFBamAuthorization Authorization,
		CFBamStringTypeBuff Buff );
	/**
	 *	Delete the StringType instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeBySchemaIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId );

	/**
	 *	Delete the StringType instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeBySchemaIdx( CFBamAuthorization Authorization,
		CFBamStringTypeBySchemaIdxKey argKey );
	/**
	 *	Delete the StringType instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the StringType instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteStringTypeByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey );
	/**
	 *	Delete the StringType instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName );

	/**
	 *	Delete the StringType instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the StringType instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId );

	/**
	 *	Delete the StringType instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the StringType instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDataScopeId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId );

	/**
	 *	Delete the StringType instances identified by the key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessSecurityId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId );

	/**
	 *	Delete the StringType instances identified by the key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessFrequencyId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId );

	/**
	 *	Delete the StringType instances identified by the key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessSecurityId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId );

	/**
	 *	Delete the StringType instances identified by the key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessFrequencyId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId );

	/**
	 *	Delete the StringType instances identified by the key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the StringType instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the StringType instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId );

	/**
	 *	Delete the StringType instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey );
	/**
	 *	Delete the StringType instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringType key attribute of the instance generating the id.
	 */
	void deleteStringTypeByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId );

	/**
	 *	Delete the StringType instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteStringTypeByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey );

	/**
	 *	Open a cursor over all the instances of StringType.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over StringType for the specfied key
	 *		of the index.
	 */
	CFBamCursor openStringTypeCursorAll( CFBamAuthorization Authorization );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over StringType for the specfied key
	 *		of the index.
	 */
	CFBamCursor openStringTypeCursorBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId );
	/**
	 *	Close the specified cursor.
	 *
	 *	@param	Cursor	The cursor to close.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void closeStringTypeCursor( CFBamCursor Cursor );
	/**
	 *	Get the next instance of a StringType for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the next instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff nextStringTypeCursor( CFBamCursor Cursor );
	/**
	 *	Get the previous instance of a StringType for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the previous instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff prevStringTypeCursor( CFBamCursor Cursor );
	/**
	 *	Get the first instance of a StringType for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff firstStringTypeCursor( CFBamCursor Cursor );
	/**
	 *	Get the last instance of a StringType for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the last instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff lastStringTypeCursor( CFBamCursor Cursor );
	/**
	 *	Get the nth instance of a StringType for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@param	Idx	The zero-based cursor index.  0 is the first instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff nthStringTypeCursor( CFBamCursor Cursor, int Idx );

	/**
	 *	Read the derived StringType buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the StringType instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamStringTypeBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the derived StringType buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the StringType instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamStringTypeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all StringType instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readAllDerived( CFBamAuthorization Authorization );

	/**
	 *	Read the derived StringType buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamStringTypeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the derived StringType buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringType key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamStringTypeBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDataScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessSecurityId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessFrequencyId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessSecurityId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessFrequencyId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read an array of the derived StringType buffer instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamStringTypeBuff[] readDerivedBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId );

	/**
	 *	Read the specific StringType buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the StringType instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the specific StringType buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the StringType instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all the specific StringType buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific StringType instances in the database accessible for the Authorization.
	 */
	CFBamStringTypeBuff[] readAllBuff( CFBamAuthorization Authorization );

	/**
	 *	Read the specific StringType buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the specific StringType buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringType key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDataScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessSecurityId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessFrequencyId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessSecurityId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessFrequencyId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read an array of the specific StringType buffer instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The StringType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The StringType key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamStringTypeBuff[] readBuffBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamStringTypeBuff moveBuffUp( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamStringTypeBuff moveBuffDown( CFBamAuthorization Authorization,
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
