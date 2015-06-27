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

public interface ICFBamISOCountryCurrencyTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ISOCountryCurrency instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamISOCountryCurrencyObj newInstance();

	/**
	 *	Instantiate a new ISOCountryCurrency edition of the specified ISOCountryCurrency instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamISOCountryCurrencyEditObj newEditInstance( ICFBamISOCountryCurrencyObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamISOCountryCurrencyObj realizeISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj );
	void forgetISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj, boolean forgetSubObjects );
	void forgetISOCountryCurrencyByIdIdx( short ISOCountryId,
		short ISOCurrencyId );

	void forgetISOCountryCurrencyByCountryIdx( short ISOCountryId );

	void forgetISOCountryCurrencyByCurrencyIdx( short ISOCurrencyId );


	/**
	 *	Internal use only.
	 */
	ICFBamISOCountryCurrencyObj createISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj );

	/**
	 *	Read a ISOCountryCurrency-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCountryCurrency-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamISOCountryCurrencyObj readISOCountryCurrency( CFBamISOCountryCurrencyPKey pkey );

	/**
	 *	Read a ISOCountryCurrency-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCountryCurrency-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamISOCountryCurrencyObj readISOCountryCurrency( CFBamISOCountryCurrencyPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamISOCountryCurrencyObj lockISOCountryCurrency( CFBamISOCountryCurrencyPKey pkey );

	/**
	 *	Return a sorted map of all the ISOCountryCurrency-derived instances in the database.
	 *
	 *	@return	List of ICFBamISOCountryCurrencyObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamISOCountryCurrencyObj> readAllISOCountryCurrency();

	/**
	 *	Return a sorted map of all the ISOCountryCurrency-derived instances in the database.
	 *
	 *	@return	List of ICFBamISOCountryCurrencyObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamISOCountryCurrencyObj> readAllISOCountryCurrency( boolean forceRead );

	/**
	 *	Get the CFBamISOCountryCurrencyObj instance for the primary key attributes.
	 *
	 *	@param	argISOCountryId	The ISOCountryCurrency key attribute of the instance generating the id.
	 *
	 *	@param	argISOCurrencyId	The ISOCountryCurrency key attribute of the instance generating the id.
	 *
	 *	@return	CFBamISOCountryCurrencyObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamISOCountryCurrencyObj readISOCountryCurrencyByIdIdx( short ISOCountryId,
		short ISOCurrencyId );

	/**
	 *	Get the CFBamISOCountryCurrencyObj instance for the primary key attributes.
	 *
	 *	@param	argISOCountryId	The ISOCountryCurrency key attribute of the instance generating the id.
	 *
	 *	@param	argISOCurrencyId	The ISOCountryCurrency key attribute of the instance generating the id.
	 *
	 *	@return	CFBamISOCountryCurrencyObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamISOCountryCurrencyObj readISOCountryCurrencyByIdIdx( short ISOCountryId,
		short ISOCurrencyId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamISOCountryCurrencyObj instances sorted by their primary keys for the duplicate CountryIdx key.
	 *
	 *	@param	argISOCountryId	The ISOCountryCurrency key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamISOCountryCurrencyObj cached instances sorted by their primary keys for the duplicate CountryIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamISOCountryCurrencyObj> readISOCountryCurrencyByCountryIdx( short ISOCountryId );

	/**
	 *	Get the map of CFBamISOCountryCurrencyObj instances sorted by their primary keys for the duplicate CountryIdx key.
	 *
	 *	@param	argISOCountryId	The ISOCountryCurrency key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamISOCountryCurrencyObj cached instances sorted by their primary keys for the duplicate CountryIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamISOCountryCurrencyObj> readISOCountryCurrencyByCountryIdx( short ISOCountryId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamISOCountryCurrencyObj instances sorted by their primary keys for the duplicate CurrencyIdx key.
	 *
	 *	@param	argISOCurrencyId	The ISOCountryCurrency key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamISOCountryCurrencyObj cached instances sorted by their primary keys for the duplicate CurrencyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamISOCountryCurrencyObj> readISOCountryCurrencyByCurrencyIdx( short ISOCurrencyId );

	/**
	 *	Get the map of CFBamISOCountryCurrencyObj instances sorted by their primary keys for the duplicate CurrencyIdx key.
	 *
	 *	@param	argISOCurrencyId	The ISOCountryCurrency key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamISOCountryCurrencyObj cached instances sorted by their primary keys for the duplicate CurrencyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamISOCountryCurrencyObj> readISOCountryCurrencyByCurrencyIdx( short ISOCurrencyId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamISOCountryCurrencyObj updateISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteISOCountryCurrency( ICFBamISOCountryCurrencyObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argISOCountryId	The ISOCountryCurrency key attribute of the instance generating the id.
	 *
	 *	@param	argISOCurrencyId	The ISOCountryCurrency key attribute of the instance generating the id.
	 */
	void deleteISOCountryCurrencyByIdIdx( short ISOCountryId,
		short ISOCurrencyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argISOCountryId	The ISOCountryCurrency key attribute of the instance generating the id.
	 */
	void deleteISOCountryCurrencyByCountryIdx( short ISOCountryId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argISOCurrencyId	The ISOCountryCurrency key attribute of the instance generating the id.
	 */
	void deleteISOCountryCurrencyByCurrencyIdx( short ISOCurrencyId );
}
