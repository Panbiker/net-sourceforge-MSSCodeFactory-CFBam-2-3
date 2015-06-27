
// Description: Java7 DbIO interface for ISOCountryLanguage.

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
 *	CFBamISOCountryLanguageTable DbIO interface for ISOCountryLanguage
 */
public interface ICFBamISOCountryLanguageTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createISOCountryLanguage( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateISOCountryLanguage( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteISOCountryLanguage( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageBuff Buff );
	/**
	 *	Delete the ISOCountryLanguage instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCountryId	The ISOCountryLanguage key attribute of the instance generating the id.
	 *
	 *	@param	argISOLanguageId	The ISOCountryLanguage key attribute of the instance generating the id.
	 */
	void deleteISOCountryLanguageByIdIdx( CFBamAuthorization Authorization,
		short argISOCountryId,
		short argISOLanguageId );

	/**
	 *	Delete the ISOCountryLanguage instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteISOCountryLanguageByIdIdx( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey argKey );
	/**
	 *	Delete the ISOCountryLanguage instances identified by the key CountryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCountryId	The ISOCountryLanguage key attribute of the instance generating the id.
	 */
	void deleteISOCountryLanguageByCountryIdx( CFBamAuthorization Authorization,
		short argISOCountryId );

	/**
	 *	Delete the ISOCountryLanguage instances identified by the key CountryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOCountryLanguageByCountryIdx( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageByCountryIdxKey argKey );
	/**
	 *	Delete the ISOCountryLanguage instances identified by the key LanguageIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOLanguageId	The ISOCountryLanguage key attribute of the instance generating the id.
	 */
	void deleteISOCountryLanguageByLanguageIdx( CFBamAuthorization Authorization,
		short argISOLanguageId );

	/**
	 *	Delete the ISOCountryLanguage instances identified by the key LanguageIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOCountryLanguageByLanguageIdx( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageByLanguageIdxKey argKey );

	/**
	 *	Open a cursor over all the instances of ISOCountryLanguage.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over ISOCountryLanguage for the specfied key
	 *		of the index.
	 */
	CFBamCursor openISOCountryLanguageCursorAll( CFBamAuthorization Authorization );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over ISOCountryLanguage for the specfied key
	 *		of the index.
	 */
	CFBamCursor openISOCountryLanguageCursorByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over ISOCountryLanguage for the specfied key
	 *		of the index.
	 */
	CFBamCursor openISOCountryLanguageCursorByLanguageIdx( CFBamAuthorization Authorization,
		short ISOLanguageId );
	/**
	 *	Close the specified cursor.
	 *
	 *	@param	Cursor	The cursor to close.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void closeISOCountryLanguageCursor( CFBamCursor Cursor );
	/**
	 *	Get the next instance of a ISOCountryLanguage for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the next instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOCountryLanguageBuff nextISOCountryLanguageCursor( CFBamCursor Cursor );
	/**
	 *	Get the previous instance of a ISOCountryLanguage for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the previous instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOCountryLanguageBuff prevISOCountryLanguageCursor( CFBamCursor Cursor );
	/**
	 *	Get the first instance of a ISOCountryLanguage for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOCountryLanguageBuff firstISOCountryLanguageCursor( CFBamCursor Cursor );
	/**
	 *	Get the last instance of a ISOCountryLanguage for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the last instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOCountryLanguageBuff lastISOCountryLanguageCursor( CFBamCursor Cursor );
	/**
	 *	Get the nth instance of a ISOCountryLanguage for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@param	Idx	The zero-based cursor index.  0 is the first instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOCountryLanguageBuff nthISOCountryLanguageCursor( CFBamCursor Cursor, int Idx );

	/**
	 *	Read the derived ISOCountryLanguage buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCountryLanguage instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamISOCountryLanguageBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey );

	/**
	 *	Lock the derived ISOCountryLanguage buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCountryLanguage instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamISOCountryLanguageBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey );

	/**
	 *	Read all ISOCountryLanguage instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamISOCountryLanguageBuff[] readAllDerived( CFBamAuthorization Authorization );

	/**
	 *	Read the derived ISOCountryLanguage buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCountryId	The ISOCountryLanguage key attribute of the instance generating the id.
	 *
	 *	@param	argISOLanguageId	The ISOCountryLanguage key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamISOCountryLanguageBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short ISOCountryId,
		short ISOLanguageId );

	/**
	 *	Read an array of the derived ISOCountryLanguage buffer instances identified by the duplicate key CountryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCountryId	The ISOCountryLanguage key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamISOCountryLanguageBuff[] readDerivedByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId );

	/**
	 *	Read an array of the derived ISOCountryLanguage buffer instances identified by the duplicate key LanguageIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOLanguageId	The ISOCountryLanguage key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamISOCountryLanguageBuff[] readDerivedByLanguageIdx( CFBamAuthorization Authorization,
		short ISOLanguageId );

	/**
	 *	Read the specific ISOCountryLanguage buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCountryLanguage instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOCountryLanguageBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey );

	/**
	 *	Lock the specific ISOCountryLanguage buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCountryLanguage instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOCountryLanguageBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey );

	/**
	 *	Read all the specific ISOCountryLanguage buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ISOCountryLanguage instances in the database accessible for the Authorization.
	 */
	CFBamISOCountryLanguageBuff[] readAllBuff( CFBamAuthorization Authorization );

	/**
	 *	Read the specific ISOCountryLanguage buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCountryId	The ISOCountryLanguage key attribute of the instance generating the id.
	 *
	 *	@param	argISOLanguageId	The ISOCountryLanguage key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOCountryLanguageBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short ISOCountryId,
		short ISOLanguageId );

	/**
	 *	Read an array of the specific ISOCountryLanguage buffer instances identified by the duplicate key CountryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCountryId	The ISOCountryLanguage key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOCountryLanguageBuff[] readBuffByCountryIdx( CFBamAuthorization Authorization,
		short ISOCountryId );

	/**
	 *	Read an array of the specific ISOCountryLanguage buffer instances identified by the duplicate key LanguageIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOLanguageId	The ISOCountryLanguage key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOCountryLanguageBuff[] readBuffByLanguageIdx( CFBamAuthorization Authorization,
		short ISOLanguageId );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
