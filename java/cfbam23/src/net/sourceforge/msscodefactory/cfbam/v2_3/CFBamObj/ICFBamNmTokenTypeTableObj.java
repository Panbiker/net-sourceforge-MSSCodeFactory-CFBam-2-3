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

public interface ICFBamNmTokenTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new NmTokenType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamNmTokenTypeObj newInstance();

	/**
	 *	Instantiate a new NmTokenType edition of the specified NmTokenType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamNmTokenTypeEditObj newEditInstance( ICFBamNmTokenTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokenTypeObj realizeNmTokenType( ICFBamNmTokenTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetNmTokenType( ICFBamNmTokenTypeObj Obj );
	void forgetNmTokenType( ICFBamNmTokenTypeObj Obj, boolean forgetSubObjects );
	void forgetNmTokenTypeByIdIdx( long TenantId,
		long Id );

	void forgetNmTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetNmTokenTypeByValTentIdx( long TenantId );

	void forgetNmTokenTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetNmTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetNmTokenTypeByDataScopeIdx( Short DataScopeId );

	void forgetNmTokenTypeByVAccSecIdx( Short ViewAccessSecurityId );

	void forgetNmTokenTypeByVAccFreqIdx( Short ViewAccessFrequencyId );

	void forgetNmTokenTypeByEAccSecIdx( Short EditAccessSecurityId );

	void forgetNmTokenTypeByEAccFreqIdx( Short EditAccessFrequencyId );

	void forgetNmTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetNmTokenTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetNmTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetNmTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetNmTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamNmTokenTypeObj createNmTokenType( ICFBamNmTokenTypeObj Obj );

	/**
	 *	Read a NmTokenType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NmTokenType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamNmTokenTypeObj readNmTokenType( CFBamValuePKey pkey );

	/**
	 *	Read a NmTokenType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NmTokenType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamNmTokenTypeObj readNmTokenType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokenTypeObj lockNmTokenType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted map of all the NmTokenType-derived instances in the database.
	 *
	 *	@return	List of ICFBamNmTokenTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readAllNmTokenType();

	/**
	 *	Return a sorted map of all the NmTokenType-derived instances in the database.
	 *
	 *	@return	List of ICFBamNmTokenTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readAllNmTokenType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokenTypeObj readNmTokenTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokenTypeObj readNmTokenTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokenTypeObj readNmTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokenTypeObj readNmTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DataScopeIdx key.
	 *
	 *	@param	argDataScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DataScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByDataScopeIdx( Short DataScopeId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DataScopeIdx key.
	 *
	 *	@param	argDataScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DataScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByDataScopeIdx( Short DataScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccSecIdx key.
	 *
	 *	@param	argViewAccessSecurityId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByVAccSecIdx( Short ViewAccessSecurityId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccSecIdx key.
	 *
	 *	@param	argViewAccessSecurityId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccFreqIdx key.
	 *
	 *	@param	argViewAccessFrequencyId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByVAccFreqIdx( Short ViewAccessFrequencyId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccFreqIdx key.
	 *
	 *	@param	argViewAccessFrequencyId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccSecIdx key.
	 *
	 *	@param	argEditAccessSecurityId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByEAccSecIdx( Short EditAccessSecurityId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccSecIdx key.
	 *
	 *	@param	argEditAccessSecurityId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccFreqIdx key.
	 *
	 *	@param	argEditAccessFrequencyId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByEAccFreqIdx( Short EditAccessFrequencyId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccFreqIdx key.
	 *
	 *	@param	argEditAccessFrequencyId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamNmTokenTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamNmTokenTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokenTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokenTypeObj> readNmTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokenTypeObj updateNmTokenType( ICFBamNmTokenTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteNmTokenType( ICFBamNmTokenTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDataScopeId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByDataScopeIdx( Short DataScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argViewAccessSecurityId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByVAccSecIdx( Short ViewAccessSecurityId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argViewAccessFrequencyId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByVAccFreqIdx( Short ViewAccessFrequencyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEditAccessSecurityId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByEAccSecIdx( Short EditAccessSecurityId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEditAccessFrequencyId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByEAccFreqIdx( Short EditAccessFrequencyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokenType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The NmTokenType key attribute of the instance generating the id.
	 */
	void deleteNmTokenTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamNmTokenTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamNmTokenTypeObj refreshed cache instance.
	 */
	ICFBamNmTokenTypeObj moveUpNmTokenType( ICFBamNmTokenTypeObj Obj );

	/**
	 *	Move the CFBamNmTokenTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamNmTokenTypeObj refreshed cache instance.
	 */
	ICFBamNmTokenTypeObj moveDownNmTokenType( ICFBamNmTokenTypeObj Obj );
}
