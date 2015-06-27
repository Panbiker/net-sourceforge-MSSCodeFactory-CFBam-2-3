
// Description: Java7 DbIO interface for DoubleDef.

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
 *	CFBamDoubleDefTable DbIO interface for DoubleDef
 */
public interface ICFBamDoubleDefTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createDoubleDef( CFBamAuthorization Authorization,
		CFBamDoubleDefBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateDoubleDef( CFBamAuthorization Authorization,
		CFBamDoubleDefBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteDoubleDef( CFBamAuthorization Authorization,
		CFBamDoubleDefBuff Buff );
	/**
	 *	Delete the DoubleDef instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the DoubleDef instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteDoubleDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName );

	/**
	 *	Delete the DoubleDef instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the DoubleDef instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId );

	/**
	 *	Delete the DoubleDef instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId );

	/**
	 *	Delete the DoubleDef instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDataScopeId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId );

	/**
	 *	Delete the DoubleDef instances identified by the key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessSecurityId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId );

	/**
	 *	Delete the DoubleDef instances identified by the key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessFrequencyId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId );

	/**
	 *	Delete the DoubleDef instances identified by the key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessSecurityId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId );

	/**
	 *	Delete the DoubleDef instances identified by the key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessFrequencyId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId );

	/**
	 *	Delete the DoubleDef instances identified by the key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId );

	/**
	 *	Delete the DoubleDef instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId );

	/**
	 *	Delete the DoubleDef instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId );

	/**
	 *	Delete the DoubleDef instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey );
	/**
	 *	Delete the DoubleDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId );

	/**
	 *	Delete the DoubleDef instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteDoubleDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey );

	/**
	 *	Open a cursor over all the instances of DoubleDef.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over DoubleDef for the specfied key
	 *		of the index.
	 */
	CFBamCursor openDoubleDefCursorAll( CFBamAuthorization Authorization );
	/**
	 *	Close the specified cursor.
	 *
	 *	@param	Cursor	The cursor to close.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void closeDoubleDefCursor( CFBamCursor Cursor );
	/**
	 *	Get the next instance of a DoubleDef for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the next instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff nextDoubleDefCursor( CFBamCursor Cursor );
	/**
	 *	Get the previous instance of a DoubleDef for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the previous instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff prevDoubleDefCursor( CFBamCursor Cursor );
	/**
	 *	Get the first instance of a DoubleDef for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff firstDoubleDefCursor( CFBamCursor Cursor );
	/**
	 *	Get the last instance of a DoubleDef for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the last instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff lastDoubleDefCursor( CFBamCursor Cursor );
	/**
	 *	Get the nth instance of a DoubleDef for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@param	Idx	The zero-based cursor index.  0 is the first instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff nthDoubleDefCursor( CFBamCursor Cursor, int Idx );

	/**
	 *	Read the derived DoubleDef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DoubleDef instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDoubleDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the derived DoubleDef buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DoubleDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDoubleDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all DoubleDef instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readAllDerived( CFBamAuthorization Authorization );

	/**
	 *	Read the derived DoubleDef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDoubleDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the derived DoubleDef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamDoubleDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDataScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessSecurityId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessFrequencyId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessSecurityId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessFrequencyId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the derived DoubleDef buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamDoubleDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Read the specific DoubleDef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DoubleDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Lock the specific DoubleDef buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DoubleDef instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey );

	/**
	 *	Read all the specific DoubleDef buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific DoubleDef instances in the database accessible for the Authorization.
	 */
	CFBamDoubleDefBuff[] readAllBuff( CFBamAuthorization Authorization );

	/**
	 *	Read the specific DoubleDef buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read the specific DoubleDef buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key DataScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argDataScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key VAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessSecurityId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key VAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argViewAccessFrequencyId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key EAccSecIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessSecurityId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key EAccFreqIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argEditAccessFrequencyId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argPrevTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argNextTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Read an array of the specific DoubleDef buffer instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamDoubleDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamDoubleDefBuff moveBuffUp( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision );

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	CFBamDoubleDefBuff moveBuffDown( CFBamAuthorization Authorization,
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
