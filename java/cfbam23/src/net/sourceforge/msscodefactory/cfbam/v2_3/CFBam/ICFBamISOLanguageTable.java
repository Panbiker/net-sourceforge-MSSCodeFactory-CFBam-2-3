
// Description: Java7 DbIO interface for ISOLanguage.

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
 *	CFBamISOLanguageTable DbIO interface for ISOLanguage
 */
public interface ICFBamISOLanguageTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createISOLanguage( CFBamAuthorization Authorization,
		CFBamISOLanguageBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateISOLanguage( CFBamAuthorization Authorization,
		CFBamISOLanguageBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteISOLanguage( CFBamAuthorization Authorization,
		CFBamISOLanguageBuff Buff );
	/**
	 *	Delete the ISOLanguage instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The ISOLanguage key attribute of the instance generating the id.
	 */
	void deleteISOLanguageByIdIdx( CFBamAuthorization Authorization,
		short argId );

	/**
	 *	Delete the ISOLanguage instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteISOLanguageByIdIdx( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey argKey );
	/**
	 *	Delete the ISOLanguage instances identified by the key BaseIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBaseLanguageCode	The ISOLanguage key attribute of the instance generating the id.
	 */
	void deleteISOLanguageByBaseIdx( CFBamAuthorization Authorization,
		String argBaseLanguageCode );

	/**
	 *	Delete the ISOLanguage instances identified by the key BaseIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOLanguageByBaseIdx( CFBamAuthorization Authorization,
		CFBamISOLanguageByBaseIdxKey argKey );
	/**
	 *	Delete the ISOLanguage instances identified by the key CountryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCountryId	The ISOLanguage key attribute of the instance generating the id.
	 */
	void deleteISOLanguageByCountryIdx( CFBamAuthorization Authorization,
		Short argISOCountryId );

	/**
	 *	Delete the ISOLanguage instances identified by the key CountryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOLanguageByCountryIdx( CFBamAuthorization Authorization,
		CFBamISOLanguageByCountryIdxKey argKey );
	/**
	 *	Delete the ISOLanguage instances identified by the key CodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCode	The ISOLanguage key attribute of the instance generating the id.
	 */
	void deleteISOLanguageByCodeIdx( CFBamAuthorization Authorization,
		String argISOCode );

	/**
	 *	Delete the ISOLanguage instances identified by the key CodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOLanguageByCodeIdx( CFBamAuthorization Authorization,
		CFBamISOLanguageByCodeIdxKey argKey );

	/**
	 *	Open a cursor over all the instances of ISOLanguage.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over ISOLanguage for the specfied key
	 *		of the index.
	 */
	CFBamCursor openISOLanguageCursorAll( CFBamAuthorization Authorization );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over ISOLanguage for the specfied key
	 *		of the index.
	 */
	CFBamCursor openISOLanguageCursorByBaseIdx( CFBamAuthorization Authorization,
		String BaseLanguageCode );
	/**
	 *	Open a cursor over the specified index key value.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over ISOLanguage for the specfied key
	 *		of the index.
	 */
	CFBamCursor openISOLanguageCursorByCountryIdx( CFBamAuthorization Authorization,
		Short ISOCountryId );
	/**
	 *	Close the specified cursor.
	 *
	 *	@param	Cursor	The cursor to close.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void closeISOLanguageCursor( CFBamCursor Cursor );
	/**
	 *	Get the next instance of a ISOLanguage for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the next instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff nextISOLanguageCursor( CFBamCursor Cursor );
	/**
	 *	Get the previous instance of a ISOLanguage for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the previous instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff prevISOLanguageCursor( CFBamCursor Cursor );
	/**
	 *	Get the first instance of a ISOLanguage for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff firstISOLanguageCursor( CFBamCursor Cursor );
	/**
	 *	Get the last instance of a ISOLanguage for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the last instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff lastISOLanguageCursor( CFBamCursor Cursor );
	/**
	 *	Get the nth instance of a ISOLanguage for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@param	Idx	The zero-based cursor index.  0 is the first instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff nthISOLanguageCursor( CFBamCursor Cursor, int Idx );

	/**
	 *	Read the derived ISOLanguage buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOLanguage instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamISOLanguageBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey );

	/**
	 *	Lock the derived ISOLanguage buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOLanguage instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamISOLanguageBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey );

	/**
	 *	Read all ISOLanguage instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamISOLanguageBuff[] readAllDerived( CFBamAuthorization Authorization );

	/**
	 *	Read the derived ISOLanguage buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The ISOLanguage key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamISOLanguageBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id );

	/**
	 *	Read an array of the derived ISOLanguage buffer instances identified by the duplicate key BaseIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBaseLanguageCode	The ISOLanguage key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamISOLanguageBuff[] readDerivedByBaseIdx( CFBamAuthorization Authorization,
		String BaseLanguageCode );

	/**
	 *	Read an array of the derived ISOLanguage buffer instances identified by the duplicate key CountryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCountryId	The ISOLanguage key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFBamISOLanguageBuff[] readDerivedByCountryIdx( CFBamAuthorization Authorization,
		Short ISOCountryId );

	/**
	 *	Read the derived ISOLanguage buffer instance identified by the unique key CodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCode	The ISOLanguage key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamISOLanguageBuff readDerivedByCodeIdx( CFBamAuthorization Authorization,
		String ISOCode );

	/**
	 *	Read the specific ISOLanguage buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOLanguage instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey );

	/**
	 *	Lock the specific ISOLanguage buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOLanguage instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOLanguagePKey PKey );

	/**
	 *	Read all the specific ISOLanguage buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ISOLanguage instances in the database accessible for the Authorization.
	 */
	CFBamISOLanguageBuff[] readAllBuff( CFBamAuthorization Authorization );

	/**
	 *	Read the specific ISOLanguage buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The ISOLanguage key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id );

	/**
	 *	Read an array of the specific ISOLanguage buffer instances identified by the duplicate key BaseIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argBaseLanguageCode	The ISOLanguage key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff[] readBuffByBaseIdx( CFBamAuthorization Authorization,
		String BaseLanguageCode );

	/**
	 *	Read an array of the specific ISOLanguage buffer instances identified by the duplicate key CountryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCountryId	The ISOLanguage key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff[] readBuffByCountryIdx( CFBamAuthorization Authorization,
		Short ISOCountryId );

	/**
	 *	Read the specific ISOLanguage buffer instance identified by the unique key CodeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argISOCode	The ISOLanguage key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamISOLanguageBuff readBuffByCodeIdx( CFBamAuthorization Authorization,
		String ISOCode );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
