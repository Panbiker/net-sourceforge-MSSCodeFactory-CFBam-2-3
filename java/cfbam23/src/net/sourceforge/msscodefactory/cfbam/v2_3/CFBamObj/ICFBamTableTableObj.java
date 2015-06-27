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

public interface ICFBamTableTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Table instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTableObj newInstance();

	/**
	 *	Instantiate a new Table edition of the specified Table instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTableEditObj newEditInstance( ICFBamTableObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTableObj realizeTable( ICFBamTableObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTable( ICFBamTableObj Obj );
	void forgetTable( ICFBamTableObj Obj, boolean forgetSubObjects );
	void forgetTableByIdIdx( long TenantId,
		long Id );

	void forgetTableByTenantIdx( long TenantId );

	void forgetTableBySchemaDefIdx( long TenantId,
		long SchemaDefId );

	void forgetTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTableByUNameIdx( long TenantId,
		long SchemaDefId,
		String Name );

	void forgetTableBySchemaCdIdx( long TenantId,
		long SchemaDefId,
		String TableClassCode );

	void forgetTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId );

	void forgetTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId );

	void forgetTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId );

	void forgetTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId );

	void forgetTableByLoadBehaveIdx( short LoaderBehaviourId );

	void forgetTableByDataScopeIdx( Short DataScopeId );

	void forgetTableBySecScopeIdx( short SecurityScopeId );

	void forgetTableByVAccSecIdx( Short ViewAccessSecurityId );

	void forgetTableByVAccFreqIdx( Short ViewAccessFrequencyId );

	void forgetTableByEAccSecIdx( Short EditAccessSecurityId );

	void forgetTableByEAccFreqIdx( Short EditAccessFrequencyId );


	/**
	 *	Internal use only.
	 */
	ICFBamTableObj createTable( ICFBamTableObj Obj );

	/**
	 *	Read a Table-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Table-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTableObj readTable( CFBamScopePKey pkey );

	/**
	 *	Read a Table-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Table-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTableObj readTable( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTableObj lockTable( CFBamScopePKey pkey );

	/**
	 *	Return a sorted map of all the Table-derived instances in the database.
	 *
	 *	@return	List of ICFBamTableObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTableObj> readAllTable();

	/**
	 *	Return a sorted map of all the Table-derived instances in the database.
	 *
	 *	@return	List of ICFBamTableObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTableObj> readAllTable( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTableObj readTableByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTableObj readTableByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamScopeObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamScopeObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate SchemaDefIdx key.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate SchemaDefIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableBySchemaDefIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate SchemaDefIdx key.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate SchemaDefIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableBySchemaDefIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the CFBamTableObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Table key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTableObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTableObj readTableByUNameIdx(long TenantId,
		long SchemaDefId,
		String Name );

	/**
	 *	Get the CFBamTableObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Table key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTableObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTableObj readTableByUNameIdx(long TenantId,
		long SchemaDefId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the CFBamTableObj instance for the unique SchemaCdIdx key.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argTableClassCode	The Table key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTableObj cached instance for the unique SchemaCdIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTableObj readTableBySchemaCdIdx(long TenantId,
		long SchemaDefId,
		String TableClassCode );

	/**
	 *	Get the CFBamTableObj instance for the unique SchemaCdIdx key.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argTableClassCode	The Table key attribute of the instance generating the id.
	 *
	 *	@return	CFBamTableObj refreshed instance for the unique SchemaCdIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTableObj readTableBySchemaCdIdx(long TenantId,
		long SchemaDefId,
		String TableClassCode,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate PrimaryIndexIdx key.
	 *
	 *	@param	argPrimaryIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argPrimaryIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate PrimaryIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate PrimaryIndexIdx key.
	 *
	 *	@param	argPrimaryIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argPrimaryIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate PrimaryIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate LookupIndexIdx key.
	 *
	 *	@param	argLookupIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argLookupIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate LookupIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate LookupIndexIdx key.
	 *
	 *	@param	argLookupIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argLookupIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate LookupIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate AltIndexIdx key.
	 *
	 *	@param	argAltIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argAltIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate AltIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate AltIndexIdx key.
	 *
	 *	@param	argAltIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argAltIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate AltIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate QualTableIdx key.
	 *
	 *	@param	argQualifyingTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argQualifyingTableId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate QualTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate QualTableIdx key.
	 *
	 *	@param	argQualifyingTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argQualifyingTableId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate QualTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate LoadBehaveIdx key.
	 *
	 *	@param	argLoaderBehaviourId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate LoadBehaveIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByLoadBehaveIdx( short LoaderBehaviourId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate LoadBehaveIdx key.
	 *
	 *	@param	argLoaderBehaviourId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate LoadBehaveIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByLoadBehaveIdx( short LoaderBehaviourId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate DataScopeIdx key.
	 *
	 *	@param	argDataScopeId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate DataScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByDataScopeIdx( Short DataScopeId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate DataScopeIdx key.
	 *
	 *	@param	argDataScopeId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate DataScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByDataScopeIdx( Short DataScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate SecScopeIdx key.
	 *
	 *	@param	argSecurityScopeId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate SecScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableBySecScopeIdx( short SecurityScopeId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate SecScopeIdx key.
	 *
	 *	@param	argSecurityScopeId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate SecScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableBySecScopeIdx( short SecurityScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate VAccSecIdx key.
	 *
	 *	@param	argViewAccessSecurityId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate VAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByVAccSecIdx( Short ViewAccessSecurityId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate VAccSecIdx key.
	 *
	 *	@param	argViewAccessSecurityId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate VAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate VAccFreqIdx key.
	 *
	 *	@param	argViewAccessFrequencyId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate VAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByVAccFreqIdx( Short ViewAccessFrequencyId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate VAccFreqIdx key.
	 *
	 *	@param	argViewAccessFrequencyId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate VAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate EAccSecIdx key.
	 *
	 *	@param	argEditAccessSecurityId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate EAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByEAccSecIdx( Short EditAccessSecurityId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate EAccSecIdx key.
	 *
	 *	@param	argEditAccessSecurityId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate EAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate EAccFreqIdx key.
	 *
	 *	@param	argEditAccessFrequencyId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate EAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByEAccFreqIdx( Short EditAccessFrequencyId );

	/**
	 *	Get the map of CFBamTableObj instances sorted by their primary keys for the duplicate EAccFreqIdx key.
	 *
	 *	@param	argEditAccessFrequencyId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableObj cached instances sorted by their primary keys for the duplicate EAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableObj> readTableByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTableObj updateTable( ICFBamTableObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTable( ICFBamTableObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySchemaDefIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByUNameIdx(long TenantId,
		long SchemaDefId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argTableClassCode	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySchemaCdIdx(long TenantId,
		long SchemaDefId,
		String TableClassCode );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrimaryIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argPrimaryIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByPrimaryIndexIdx( Long PrimaryIndexTenantId,
		Long PrimaryIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argLookupIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argLookupIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByLookupIndexIdx( Long LookupIndexTenantId,
		Long LookupIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argAltIndexTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argAltIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByAltIndexIdx( Long AltIndexTenantId,
		Long AltIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argQualifyingTenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	argQualifyingTableId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByQualTableIdx( Long QualifyingTenantId,
		Long QualifyingTableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argLoaderBehaviourId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByLoadBehaveIdx( short LoaderBehaviourId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDataScopeId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByDataScopeIdx( Short DataScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecurityScopeId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySecScopeIdx( short SecurityScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argViewAccessSecurityId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByVAccSecIdx( Short ViewAccessSecurityId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argViewAccessFrequencyId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByVAccFreqIdx( Short ViewAccessFrequencyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEditAccessSecurityId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByEAccSecIdx( Short EditAccessSecurityId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEditAccessFrequencyId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByEAccFreqIdx( Short EditAccessFrequencyId );
}
