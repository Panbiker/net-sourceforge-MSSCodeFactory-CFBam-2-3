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

public interface ICFBamBoolDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new BoolDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamBoolDefObj newInstance();

	/**
	 *	Instantiate a new BoolDef edition of the specified BoolDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamBoolDefEditObj newEditInstance( ICFBamBoolDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamBoolDefObj realizeBoolDef( ICFBamBoolDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetBoolDef( ICFBamBoolDefObj Obj );
	void forgetBoolDef( ICFBamBoolDefObj Obj, boolean forgetSubObjects );
	void forgetBoolDefByIdIdx( long TenantId,
		long Id );

	void forgetBoolDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetBoolDefByValTentIdx( long TenantId );

	void forgetBoolDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetBoolDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetBoolDefByDataScopeIdx( Short DataScopeId );

	void forgetBoolDefByVAccSecIdx( Short ViewAccessSecurityId );

	void forgetBoolDefByVAccFreqIdx( Short ViewAccessFrequencyId );

	void forgetBoolDefByEAccSecIdx( Short EditAccessSecurityId );

	void forgetBoolDefByEAccFreqIdx( Short EditAccessFrequencyId );

	void forgetBoolDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetBoolDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetBoolDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetBoolDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamBoolDefObj createBoolDef( ICFBamBoolDefObj Obj );

	/**
	 *	Read a BoolDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The BoolDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamBoolDefObj readBoolDef( CFBamValuePKey pkey );

	/**
	 *	Read a BoolDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The BoolDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamBoolDefObj readBoolDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamBoolDefObj lockBoolDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted map of all the BoolDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamBoolDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamBoolDefObj> readAllBoolDef();

	/**
	 *	Return a sorted map of all the BoolDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamBoolDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamBoolDefObj> readAllBoolDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamBoolDefObj readBoolDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamBoolDefObj readBoolDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamBoolDefObj readBoolDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamBoolDefObj readBoolDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DataScopeIdx key.
	 *
	 *	@param	argDataScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DataScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByDataScopeIdx( Short DataScopeId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DataScopeIdx key.
	 *
	 *	@param	argDataScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate DataScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByDataScopeIdx( Short DataScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccSecIdx key.
	 *
	 *	@param	argViewAccessSecurityId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByVAccSecIdx( Short ViewAccessSecurityId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccSecIdx key.
	 *
	 *	@param	argViewAccessSecurityId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccFreqIdx key.
	 *
	 *	@param	argViewAccessFrequencyId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByVAccFreqIdx( Short ViewAccessFrequencyId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate VAccFreqIdx key.
	 *
	 *	@param	argViewAccessFrequencyId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate VAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccSecIdx key.
	 *
	 *	@param	argEditAccessSecurityId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByEAccSecIdx( Short EditAccessSecurityId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccSecIdx key.
	 *
	 *	@param	argEditAccessSecurityId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccFreqIdx key.
	 *
	 *	@param	argEditAccessFrequencyId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByEAccFreqIdx( Short EditAccessFrequencyId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate EAccFreqIdx key.
	 *
	 *	@param	argEditAccessFrequencyId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate EAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamValueObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolDefObj> readBoolDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamBoolDefObj updateBoolDef( ICFBamBoolDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteBoolDef( ICFBamBoolDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDataScopeId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByDataScopeIdx( Short DataScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argViewAccessSecurityId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByVAccSecIdx( Short ViewAccessSecurityId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argViewAccessFrequencyId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByVAccFreqIdx( Short ViewAccessFrequencyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEditAccessSecurityId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByEAccSecIdx( Short EditAccessSecurityId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEditAccessFrequencyId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByEAccFreqIdx( Short EditAccessFrequencyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolDef key attribute of the instance generating the id.
	 */
	void deleteBoolDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamBoolDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamBoolDefObj refreshed cache instance.
	 */
	ICFBamBoolDefObj moveUpBoolDef( ICFBamBoolDefObj Obj );

	/**
	 *	Move the CFBamBoolDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamBoolDefObj refreshed cache instance.
	 */
	ICFBamBoolDefObj moveDownBoolDef( ICFBamBoolDefObj Obj );
}
