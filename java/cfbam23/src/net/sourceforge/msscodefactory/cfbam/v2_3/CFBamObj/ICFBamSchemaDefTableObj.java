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

public interface ICFBamSchemaDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SchemaDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamSchemaDefObj newInstance();

	/**
	 *	Instantiate a new SchemaDef edition of the specified SchemaDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamSchemaDefEditObj newEditInstance( ICFBamSchemaDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamSchemaDefObj realizeSchemaDef( ICFBamSchemaDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSchemaDef( ICFBamSchemaDefObj Obj );
	void forgetSchemaDef( ICFBamSchemaDefObj Obj, boolean forgetSubObjects );
	void forgetSchemaDefByIdIdx( long TenantId,
		long Id );

	void forgetSchemaDefByTenantIdx( long TenantId );

	void forgetSchemaDefByCTenantIdx( long TenantId );

	void forgetSchemaDefByDomainIdx( long TenantId,
		long DomainId );

	void forgetSchemaDefByUNameIdx( long TenantId,
		long DomainId,
		String Name );

	void forgetSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId );

	void forgetSchemaDefByDataScopeIdx( Short DataScopeId );

	void forgetSchemaDefByVAccSecIdx( Short ViewAccessSecurityId );

	void forgetSchemaDefByVAccFreqIdx( Short ViewAccessFrequencyId );

	void forgetSchemaDefByEAccSecIdx( Short EditAccessSecurityId );

	void forgetSchemaDefByEAccFreqIdx( Short EditAccessFrequencyId );

	void forgetSchemaDefByPubURIIdx( long TenantId,
		String PublishURI );


	/**
	 *	Internal use only.
	 */
	ICFBamSchemaDefObj createSchemaDef( ICFBamSchemaDefObj Obj );

	/**
	 *	Read a SchemaDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSchemaDefObj readSchemaDef( CFBamScopePKey pkey );

	/**
	 *	Read a SchemaDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSchemaDefObj readSchemaDef( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSchemaDefObj lockSchemaDef( CFBamScopePKey pkey );

	/**
	 *	Return a sorted map of all the SchemaDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamSchemaDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSchemaDefObj> readAllSchemaDef();

	/**
	 *	Return a sorted map of all the SchemaDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamSchemaDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSchemaDefObj> readAllSchemaDef( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamScopeObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamScopeObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate CTenantIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate CTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByCTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate CTenantIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate CTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByCTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate DomainIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDomainId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate DomainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByDomainIdx( long TenantId,
		long DomainId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate DomainIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDomainId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate DomainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByDomainIdx( long TenantId,
		long DomainId,
		boolean forceRead );

	/**
	 *	Get the CFBamSchemaDefObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDomainId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSchemaDefObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByUNameIdx(long TenantId,
		long DomainId,
		String Name );

	/**
	 *	Get the CFBamSchemaDefObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDomainId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSchemaDefObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByUNameIdx(long TenantId,
		long DomainId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate DefLcnIdx key.
	 *
	 *	@param	argDefaultLicenseTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefaultLicenseId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate DefLcnIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate DefLcnIdx key.
	 *
	 *	@param	argDefaultLicenseTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefaultLicenseId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate DefLcnIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate DataScopeIdx key.
	 *
	 *	@param	argDataScopeId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate DataScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByDataScopeIdx( Short DataScopeId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate DataScopeIdx key.
	 *
	 *	@param	argDataScopeId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate DataScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByDataScopeIdx( Short DataScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate VAccSecIdx key.
	 *
	 *	@param	argViewAccessSecurityId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate VAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByVAccSecIdx( Short ViewAccessSecurityId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate VAccSecIdx key.
	 *
	 *	@param	argViewAccessSecurityId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate VAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByVAccSecIdx( Short ViewAccessSecurityId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate VAccFreqIdx key.
	 *
	 *	@param	argViewAccessFrequencyId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate VAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByVAccFreqIdx( Short ViewAccessFrequencyId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate VAccFreqIdx key.
	 *
	 *	@param	argViewAccessFrequencyId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate VAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByVAccFreqIdx( Short ViewAccessFrequencyId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate EAccSecIdx key.
	 *
	 *	@param	argEditAccessSecurityId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate EAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByEAccSecIdx( Short EditAccessSecurityId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate EAccSecIdx key.
	 *
	 *	@param	argEditAccessSecurityId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate EAccSecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByEAccSecIdx( Short EditAccessSecurityId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate EAccFreqIdx key.
	 *
	 *	@param	argEditAccessFrequencyId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate EAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByEAccFreqIdx( Short EditAccessFrequencyId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate EAccFreqIdx key.
	 *
	 *	@param	argEditAccessFrequencyId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate EAccFreqIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByEAccFreqIdx( Short EditAccessFrequencyId,
		boolean forceRead );

	/**
	 *	Get the CFBamSchemaDefObj instance for the unique PubURIIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argPublishURI	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSchemaDefObj cached instance for the unique PubURIIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByPubURIIdx(long TenantId,
		String PublishURI );

	/**
	 *	Get the CFBamSchemaDefObj instance for the unique PubURIIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argPublishURI	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSchemaDefObj refreshed instance for the unique PubURIIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByPubURIIdx(long TenantId,
		String PublishURI,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSchemaDefObj updateSchemaDef( ICFBamSchemaDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSchemaDef( ICFBamSchemaDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByCTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDomainId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByDomainIdx( long TenantId,
		long DomainId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDomainId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByUNameIdx(long TenantId,
		long DomainId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefaultLicenseTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefaultLicenseId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDataScopeId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByDataScopeIdx( Short DataScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argViewAccessSecurityId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByVAccSecIdx( Short ViewAccessSecurityId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argViewAccessFrequencyId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByVAccFreqIdx( Short ViewAccessFrequencyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEditAccessSecurityId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByEAccSecIdx( Short EditAccessSecurityId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEditAccessFrequencyId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByEAccFreqIdx( Short EditAccessFrequencyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argPublishURI	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByPubURIIdx(long TenantId,
		String PublishURI );
}
