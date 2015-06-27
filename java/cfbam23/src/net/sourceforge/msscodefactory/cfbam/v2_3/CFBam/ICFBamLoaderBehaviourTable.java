
// Description: Java7 DbIO interface for LoaderBehaviour.

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
 *	CFBamLoaderBehaviourTable DbIO interface for LoaderBehaviour
 */
public interface ICFBamLoaderBehaviourTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createLoaderBehaviour( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateLoaderBehaviour( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteLoaderBehaviour( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourBuff Buff );
	/**
	 *	Delete the LoaderBehaviour instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The LoaderBehaviour key attribute of the instance generating the id.
	 */
	void deleteLoaderBehaviourByIdIdx( CFBamAuthorization Authorization,
		short argId );

	/**
	 *	Delete the LoaderBehaviour instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteLoaderBehaviourByIdIdx( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourPKey argKey );
	/**
	 *	Delete the LoaderBehaviour instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The LoaderBehaviour key attribute of the instance generating the id.
	 */
	void deleteLoaderBehaviourByUNameIdx( CFBamAuthorization Authorization,
		String argName );

	/**
	 *	Delete the LoaderBehaviour instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteLoaderBehaviourByUNameIdx( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourByUNameIdxKey argKey );

	/**
	 *	Open a cursor over all the instances of LoaderBehaviour.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 *
	 *	@return CFBamCursor over LoaderBehaviour for the specfied key
	 *		of the index.
	 */
	CFBamCursor openLoaderBehaviourCursorAll( CFBamAuthorization Authorization );
	/**
	 *	Close the specified cursor.
	 *
	 *	@param	Cursor	The cursor to close.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void closeLoaderBehaviourCursor( CFBamCursor Cursor );
	/**
	 *	Get the next instance of a LoaderBehaviour for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the next instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamLoaderBehaviourBuff nextLoaderBehaviourCursor( CFBamCursor Cursor );
	/**
	 *	Get the previous instance of a LoaderBehaviour for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the previous instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamLoaderBehaviourBuff prevLoaderBehaviourCursor( CFBamCursor Cursor );
	/**
	 *	Get the first instance of a LoaderBehaviour for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamLoaderBehaviourBuff firstLoaderBehaviourCursor( CFBamCursor Cursor );
	/**
	 *	Get the last instance of a LoaderBehaviour for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the last instance of.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamLoaderBehaviourBuff lastLoaderBehaviourCursor( CFBamCursor Cursor );
	/**
	 *	Get the nth instance of a LoaderBehaviour for the specified cursor.
	 *
	 *	@param	Cursor	The cursor to get the first instance of.
	 *
	 *	@param	Idx	The zero-based cursor index.  0 is the first instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamLoaderBehaviourBuff nthLoaderBehaviourCursor( CFBamCursor Cursor, int Idx );

	/**
	 *	Read the derived LoaderBehaviour buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the LoaderBehaviour instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamLoaderBehaviourBuff readDerived( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourPKey PKey );

	/**
	 *	Lock the derived LoaderBehaviour buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the LoaderBehaviour instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFBamLoaderBehaviourBuff lockDerived( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourPKey PKey );

	/**
	 *	Read all LoaderBehaviour instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFBamLoaderBehaviourBuff[] readAllDerived( CFBamAuthorization Authorization );

	/**
	 *	Read the derived LoaderBehaviour buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The LoaderBehaviour key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamLoaderBehaviourBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short Id );

	/**
	 *	Read the derived LoaderBehaviour buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The LoaderBehaviour key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFBamLoaderBehaviourBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		String Name );

	/**
	 *	Read the specific LoaderBehaviour buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the LoaderBehaviour instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamLoaderBehaviourBuff readBuff( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourPKey PKey );

	/**
	 *	Lock the specific LoaderBehaviour buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the LoaderBehaviour instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamLoaderBehaviourBuff lockBuff( CFBamAuthorization Authorization,
		CFBamLoaderBehaviourPKey PKey );

	/**
	 *	Read all the specific LoaderBehaviour buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific LoaderBehaviour instances in the database accessible for the Authorization.
	 */
	CFBamLoaderBehaviourBuff[] readAllBuff( CFBamAuthorization Authorization );

	/**
	 *	Read the specific LoaderBehaviour buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argId	The LoaderBehaviour key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamLoaderBehaviourBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short Id );

	/**
	 *	Read the specific LoaderBehaviour buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argName	The LoaderBehaviour key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFBamLoaderBehaviourBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		String Name );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
