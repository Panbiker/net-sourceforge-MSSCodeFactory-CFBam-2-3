// Description: Java 7 Table Object interface for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

public interface ICFBamTokenTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TokenType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTokenTypeObj newInstance();

	/**
	 *	Instantiate a new TokenType edition of the specified TokenType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTokenTypeEditObj newEditInstance( ICFBamTokenTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenTypeObj realizeTokenType( ICFBamTokenTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTokenType( ICFBamTokenTypeObj Obj );
	void forgetTokenType( ICFBamTokenTypeObj Obj, boolean forgetSubObjects );
	void forgetTokenTypeByIdIdx( long TenantId,
		long Id );

	void forgetTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTokenTypeByValTentIdx( long TenantId );

	void forgetTokenTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTokenTypeByDataScopeIdx( Short DataScopeId );

	void forgetTokenTypeByVAccSecIdx( Short ViewAccessSecurityId );

	void forgetTokenTypeByVAccFreqIdx( Short ViewAccessFrequencyId );

	void forgetTokenTypeByEAccSecIdx( Short EditAccessSecurityId );

	void forgetTokenTypeByEAccFreqIdx( Short EditAccessFrequencyId );

	void forgetTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTokenTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamTokenTypeObj createTokenType( ICFBamTokenTypeObj Obj );

	/**
	 *	Read a TokenType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TokenType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTokenTypeObj readTokenType( CFBamValuePKey pkey );

	/**
	 *	Read a TokenType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TokenType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTokenTypeObj readTokenType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenTypeObj lockTokenType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted map of all the TokenType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTokenTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTokenTypeObj> readAllTokenType();

	/**
	 *	Return a sorted map of all the TokenType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTokenTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTokenTypeObj> readAllTokenType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenTypeObj readTokenTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenTypeObj readTokenTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenTypeObj readTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTokenTypeObj readTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DataScopeIdx key.
	 *
	 *	@param	argDataScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DataScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByDataScopeIdx( Short DataScopeId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DataScopeIdx key.
	 *
	 *	@param	argDataScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DataScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByDataScopeIdx( Short DataScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccSecIdx key.
	 *
	 *	@param	argViewAccessSecurityId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByVAccSecIdx( Short ViewAccessSecurityId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccSecIdx key.
	 *
	 *	@param	argViewAccessSecurityId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccFreqIdx key.
	 *
	 *	@param	argViewAccessFrequencyId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByVAccFreqIdx( Short ViewAccessFrequencyId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccFreqIdx key.
	 *
	 *	@param	argViewAccessFrequencyId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccSecIdx key.
	 *
	 *	@param	argEditAccessSecurityId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByEAccSecIdx( Short EditAccessSecurityId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccSecIdx key.
	 *
	 *	@param	argEditAccessSecurityId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccFreqIdx key.
	 *
	 *	@param	argEditAccessFrequencyId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByEAccFreqIdx( Short EditAccessFrequencyId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccFreqIdx key.
	 *
	 *	@param	argEditAccessFrequencyId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamTokenTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTokenTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTokenTypeObj> readTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTokenTypeObj updateTokenType( ICFBamTokenTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTokenType( ICFBamTokenTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDataScopeId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByDataScopeIdx( Short DataScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argViewAccessSecurityId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByVAccSecIdx( Short ViewAccessSecurityId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argViewAccessFrequencyId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByVAccFreqIdx( Short ViewAccessFrequencyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEditAccessSecurityId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByEAccSecIdx( Short EditAccessSecurityId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEditAccessFrequencyId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByEAccFreqIdx( Short EditAccessFrequencyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TokenType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TokenType key attribute of the instance generating the id.
	 */
	void deleteTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamTokenTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTokenTypeObj refreshed cache instance.
	 */
	ICFBamTokenTypeObj moveUpTokenType( ICFBamTokenTypeObj Obj );

	/**
	 *	Move the CFBamTokenTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTokenTypeObj refreshed cache instance.
	 */
	ICFBamTokenTypeObj moveDownTokenType( ICFBamTokenTypeObj Obj );
}
