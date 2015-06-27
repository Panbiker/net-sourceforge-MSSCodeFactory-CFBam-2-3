
// Description: Java7 in-memory RAM DbIO implementation for EnumTag.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamRam;

import java.sql.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamRam.*;

/*
 *	CFBamRamEnumTagTable in-memory RAM DbIO implementation
 *	for EnumTag.
 */
public class CFBamRamEnumTagTable
	implements ICFBamEnumTagTable
{
	private CFBamRamSchema schema;
	private Map< CFBamEnumTagPKey,
				CFBamEnumTagBuff > dictByPKey
		= new HashMap< CFBamEnumTagPKey,
				CFBamEnumTagBuff >();
	private Map< CFBamEnumTagByEnumTagTenantIdxKey,
				Map< CFBamEnumTagPKey,
					CFBamEnumTagBuff >> dictByEnumTagTenantIdx
		= new HashMap< CFBamEnumTagByEnumTagTenantIdxKey,
				Map< CFBamEnumTagPKey,
					CFBamEnumTagBuff >>();
	private Map< CFBamEnumTagByEnumIdxKey,
				Map< CFBamEnumTagPKey,
					CFBamEnumTagBuff >> dictByEnumIdx
		= new HashMap< CFBamEnumTagByEnumIdxKey,
				Map< CFBamEnumTagPKey,
					CFBamEnumTagBuff >>();
	private Map< CFBamEnumTagByDefSchemaIdxKey,
				Map< CFBamEnumTagPKey,
					CFBamEnumTagBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamEnumTagByDefSchemaIdxKey,
				Map< CFBamEnumTagPKey,
					CFBamEnumTagBuff >>();
	private Map< CFBamEnumTagByEnumNameIdxKey,
			CFBamEnumTagBuff > dictByEnumNameIdx
		= new HashMap< CFBamEnumTagByEnumNameIdxKey,
			CFBamEnumTagBuff >();
	private Map< CFBamEnumTagByPrevIdxKey,
				Map< CFBamEnumTagPKey,
					CFBamEnumTagBuff >> dictByPrevIdx
		= new HashMap< CFBamEnumTagByPrevIdxKey,
				Map< CFBamEnumTagPKey,
					CFBamEnumTagBuff >>();
	private Map< CFBamEnumTagByNextIdxKey,
				Map< CFBamEnumTagPKey,
					CFBamEnumTagBuff >> dictByNextIdx
		= new HashMap< CFBamEnumTagByNextIdxKey,
				Map< CFBamEnumTagPKey,
					CFBamEnumTagBuff >>();

	public CFBamRamEnumTagTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createEnumTag( CFBamAuthorization Authorization,
		CFBamEnumTagBuff Buff )
	{
		final String S_ProcName = "createEnumTag";
			CFBamEnumTagBuff tail = null;

			CFBamEnumTagBuff[] siblings = schema.getTableEnumTag().readDerivedByEnumIdx( Authorization,
				Buff.getRequiredTenantId(),
				Buff.getRequiredEnumId() );
			for( int idx = 0; ( tail == null ) && ( idx < siblings.length ); idx ++ ) {
				if( ( siblings[idx].getOptionalNextTenantId() == null )
					&& ( siblings[idx].getOptionalNextId() == null ) )
				{
					tail = siblings[idx];
				}
			}
			if( tail != null ) {
				Buff.setOptionalPrevTenantId( tail.getRequiredTenantId() );
				Buff.setOptionalPrevId( tail.getRequiredId() );
			}
			else {
				Buff.setOptionalPrevTenantId( null );
				Buff.setOptionalPrevId( null );
			}
		
		CFBamEnumTagPKey pkey = schema.getFactoryEnumTag().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( ((CFBamRamTenantTable)schema.getTableTenant()).nextEnumTagIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamEnumTagByEnumTagTenantIdxKey keyEnumTagTenantIdx = schema.getFactoryEnumTag().newEnumTagTenantIdxKey();
		keyEnumTagTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamEnumTagByEnumIdxKey keyEnumIdx = schema.getFactoryEnumTag().newEnumIdxKey();
		keyEnumIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyEnumIdx.setRequiredEnumId( Buff.getRequiredEnumId() );

		CFBamEnumTagByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryEnumTag().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamEnumTagByEnumNameIdxKey keyEnumNameIdx = schema.getFactoryEnumTag().newEnumNameIdxKey();
		keyEnumNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyEnumNameIdx.setRequiredEnumId( Buff.getRequiredEnumId() );
		keyEnumNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamEnumTagByPrevIdxKey keyPrevIdx = schema.getFactoryEnumTag().newPrevIdxKey();
		keyPrevIdx.setOptionalPrevTenantId( Buff.getOptionalPrevTenantId() );
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamEnumTagByNextIdxKey keyNextIdx = schema.getFactoryEnumTag().newNextIdxKey();
		keyNextIdx.setOptionalNextTenantId( Buff.getOptionalNextTenantId() );
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByEnumNameIdx.containsKey( keyEnumNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"EnumTagEnumNameIdx",
				keyEnumNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableEnumDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredEnumId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"EnumDef",
						"EnumDef",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictEnumTagTenantIdx;
		if( dictByEnumTagTenantIdx.containsKey( keyEnumTagTenantIdx ) ) {
			subdictEnumTagTenantIdx = dictByEnumTagTenantIdx.get( keyEnumTagTenantIdx );
		}
		else {
			subdictEnumTagTenantIdx = new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByEnumTagTenantIdx.put( keyEnumTagTenantIdx, subdictEnumTagTenantIdx );
		}
		subdictEnumTagTenantIdx.put( pkey, Buff );

		Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictEnumIdx;
		if( dictByEnumIdx.containsKey( keyEnumIdx ) ) {
			subdictEnumIdx = dictByEnumIdx.get( keyEnumIdx );
		}
		else {
			subdictEnumIdx = new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByEnumIdx.put( keyEnumIdx, subdictEnumIdx );
		}
		subdictEnumIdx.put( pkey, Buff );

		Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		dictByEnumNameIdx.put( keyEnumNameIdx, Buff );

		Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		if( tail != null ) {
			CFBamEnumTagBuff tailEdit = schema.getFactoryEnumTag().newBuff();
			tailEdit.set( (CFBamEnumTagBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
			schema.getTableEnumTag().updateEnumTag( Authorization, tailEdit );
		}
	}

	public CFBamEnumTagBuff readDerived( CFBamAuthorization Authorization,
		CFBamEnumTagPKey PKey )
	{
		final String S_ProcName = "CFBamRamEnumTag.readDerived() ";
		CFBamEnumTagPKey key = schema.getFactoryEnumTag().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamEnumTagBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumTagBuff lockDerived( CFBamAuthorization Authorization,
		CFBamEnumTagPKey PKey )
	{
		final String S_ProcName = "CFBamRamEnumTag.readDerived() ";
		CFBamEnumTagPKey key = schema.getFactoryEnumTag().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamEnumTagBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumTagBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamEnumTag.readAllDerived() ";
		CFBamEnumTagBuff[] retList = new CFBamEnumTagBuff[ dictByPKey.values().size() ];
		Iterator< CFBamEnumTagBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamEnumTagBuff[] readDerivedByEnumTagTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamEnumTag.readDerivedByEnumTagTenantIdx() ";
		CFBamEnumTagByEnumTagTenantIdxKey key = schema.getFactoryEnumTag().newEnumTagTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamEnumTagBuff[] recArray;
		if( dictByEnumTagTenantIdx.containsKey( key ) ) {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictEnumTagTenantIdx
				= dictByEnumTagTenantIdx.get( key );
			recArray = new CFBamEnumTagBuff[ subdictEnumTagTenantIdx.size() ];
			Iterator< CFBamEnumTagBuff > iter = subdictEnumTagTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictEnumTagTenantIdx
				= new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByEnumTagTenantIdx.put( key, subdictEnumTagTenantIdx );
			recArray = new CFBamEnumTagBuff[0];
		}
		return( recArray );
	}

	public CFBamEnumTagBuff[] readDerivedByEnumIdx( CFBamAuthorization Authorization,
		long TenantId,
		long EnumId )
	{
		final String S_ProcName = "CFBamRamEnumTag.readDerivedByEnumIdx() ";
		CFBamEnumTagByEnumIdxKey key = schema.getFactoryEnumTag().newEnumIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredEnumId( EnumId );

		CFBamEnumTagBuff[] recArray;
		if( dictByEnumIdx.containsKey( key ) ) {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictEnumIdx
				= dictByEnumIdx.get( key );
			recArray = new CFBamEnumTagBuff[ subdictEnumIdx.size() ];
			Iterator< CFBamEnumTagBuff > iter = subdictEnumIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictEnumIdx
				= new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByEnumIdx.put( key, subdictEnumIdx );
			recArray = new CFBamEnumTagBuff[0];
		}
		return( recArray );
	}

	public CFBamEnumTagBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamEnumTag.readDerivedByDefSchemaIdx() ";
		CFBamEnumTagByDefSchemaIdxKey key = schema.getFactoryEnumTag().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamEnumTagBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamEnumTagBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamEnumTagBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictDefSchemaIdx
				= new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamEnumTagBuff[0];
		}
		return( recArray );
	}

	public CFBamEnumTagBuff readDerivedByEnumNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long EnumId,
		String Name )
	{
		final String S_ProcName = "CFBamRamEnumTag.readDerivedByEnumNameIdx() ";
		CFBamEnumTagByEnumNameIdxKey key = schema.getFactoryEnumTag().newEnumNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredEnumId( EnumId );
		key.setRequiredName( Name );

		CFBamEnumTagBuff buff;
		if( dictByEnumNameIdx.containsKey( key ) ) {
			buff = dictByEnumNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumTagBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamEnumTag.readDerivedByPrevIdx() ";
		CFBamEnumTagByPrevIdxKey key = schema.getFactoryEnumTag().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );

		CFBamEnumTagBuff[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new CFBamEnumTagBuff[ subdictPrevIdx.size() ];
			Iterator< CFBamEnumTagBuff > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictPrevIdx
				= new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new CFBamEnumTagBuff[0];
		}
		return( recArray );
	}

	public CFBamEnumTagBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamEnumTag.readDerivedByNextIdx() ";
		CFBamEnumTagByNextIdxKey key = schema.getFactoryEnumTag().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );

		CFBamEnumTagBuff[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new CFBamEnumTagBuff[ subdictNextIdx.size() ];
			Iterator< CFBamEnumTagBuff > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictNextIdx
				= new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new CFBamEnumTagBuff[0];
		}
		return( recArray );
	}

	public CFBamEnumTagBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamEnumTag.readDerivedByIdIdx() ";
		CFBamEnumTagPKey key = schema.getFactoryEnumTag().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamEnumTagBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumTagBuff readBuff( CFBamAuthorization Authorization,
		CFBamEnumTagPKey PKey )
	{
		final String S_ProcName = "CFBamRamEnumTag.readBuff() ";
		CFBamEnumTagBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ETG" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumTagBuff lockBuff( CFBamAuthorization Authorization,
		CFBamEnumTagPKey PKey )
	{
		final String S_ProcName = "CFBamRamEnumTag.readBuff() ";
		CFBamEnumTagBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ETG" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumTagBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamEnumTag.readAllBuff() ";
		CFBamEnumTagBuff buff;
		ArrayList<CFBamEnumTagBuff> filteredList = new ArrayList<CFBamEnumTagBuff>();
		CFBamEnumTagBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ETG" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumTagBuff[0] ) );
	}

	public CFBamEnumTagBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamEnumTag.readBuffByIdIdx() ";
		CFBamEnumTagBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "ETG" ) ) {
			return( (CFBamEnumTagBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamEnumTagBuff[] readBuffByEnumTagTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamEnumTag.readBuffByEnumTagTenantIdx() ";
		CFBamEnumTagBuff buff;
		ArrayList<CFBamEnumTagBuff> filteredList = new ArrayList<CFBamEnumTagBuff>();
		CFBamEnumTagBuff[] buffList = readDerivedByEnumTagTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ETG" ) ) {
				filteredList.add( (CFBamEnumTagBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumTagBuff[0] ) );
	}

	public CFBamEnumTagBuff[] readBuffByEnumIdx( CFBamAuthorization Authorization,
		long TenantId,
		long EnumId )
	{
		final String S_ProcName = "CFBamRamEnumTag.readBuffByEnumIdx() ";
		CFBamEnumTagBuff buff;
		ArrayList<CFBamEnumTagBuff> filteredList = new ArrayList<CFBamEnumTagBuff>();
		CFBamEnumTagBuff[] buffList = readDerivedByEnumIdx( Authorization,
			TenantId,
			EnumId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ETG" ) ) {
				filteredList.add( (CFBamEnumTagBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumTagBuff[0] ) );
	}

	public CFBamEnumTagBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamEnumTag.readBuffByDefSchemaIdx() ";
		CFBamEnumTagBuff buff;
		ArrayList<CFBamEnumTagBuff> filteredList = new ArrayList<CFBamEnumTagBuff>();
		CFBamEnumTagBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ETG" ) ) {
				filteredList.add( (CFBamEnumTagBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumTagBuff[0] ) );
	}

	public CFBamEnumTagBuff readBuffByEnumNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long EnumId,
		String Name )
	{
		final String S_ProcName = "CFBamRamEnumTag.readBuffByEnumNameIdx() ";
		CFBamEnumTagBuff buff = readDerivedByEnumNameIdx( Authorization,
			TenantId,
			EnumId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "ETG" ) ) {
			return( (CFBamEnumTagBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamEnumTagBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamEnumTag.readBuffByPrevIdx() ";
		CFBamEnumTagBuff buff;
		ArrayList<CFBamEnumTagBuff> filteredList = new ArrayList<CFBamEnumTagBuff>();
		CFBamEnumTagBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ETG" ) ) {
				filteredList.add( (CFBamEnumTagBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumTagBuff[0] ) );
	}

	public CFBamEnumTagBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamEnumTag.readBuffByNextIdx() ";
		CFBamEnumTagBuff buff;
		ArrayList<CFBamEnumTagBuff> filteredList = new ArrayList<CFBamEnumTagBuff>();
		CFBamEnumTagBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ETG" ) ) {
				filteredList.add( (CFBamEnumTagBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumTagBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamEnumTagBuff moveBuffUp( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffUp" );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamEnumTagBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateEnumTag( CFBamAuthorization Authorization,
		CFBamEnumTagBuff Buff )
	{
		CFBamEnumTagPKey pkey = schema.getFactoryEnumTag().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamEnumTagBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateEnumTag",
				"Existing record not found",
				"EnumTag",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateEnumTag",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamEnumTagByEnumTagTenantIdxKey existingKeyEnumTagTenantIdx = schema.getFactoryEnumTag().newEnumTagTenantIdxKey();
		existingKeyEnumTagTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamEnumTagByEnumTagTenantIdxKey newKeyEnumTagTenantIdx = schema.getFactoryEnumTag().newEnumTagTenantIdxKey();
		newKeyEnumTagTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamEnumTagByEnumIdxKey existingKeyEnumIdx = schema.getFactoryEnumTag().newEnumIdxKey();
		existingKeyEnumIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyEnumIdx.setRequiredEnumId( existing.getRequiredEnumId() );

		CFBamEnumTagByEnumIdxKey newKeyEnumIdx = schema.getFactoryEnumTag().newEnumIdxKey();
		newKeyEnumIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyEnumIdx.setRequiredEnumId( Buff.getRequiredEnumId() );

		CFBamEnumTagByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryEnumTag().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamEnumTagByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryEnumTag().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamEnumTagByEnumNameIdxKey existingKeyEnumNameIdx = schema.getFactoryEnumTag().newEnumNameIdxKey();
		existingKeyEnumNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyEnumNameIdx.setRequiredEnumId( existing.getRequiredEnumId() );
		existingKeyEnumNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamEnumTagByEnumNameIdxKey newKeyEnumNameIdx = schema.getFactoryEnumTag().newEnumNameIdxKey();
		newKeyEnumNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyEnumNameIdx.setRequiredEnumId( Buff.getRequiredEnumId() );
		newKeyEnumNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamEnumTagByPrevIdxKey existingKeyPrevIdx = schema.getFactoryEnumTag().newPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevTenantId( existing.getOptionalPrevTenantId() );
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamEnumTagByPrevIdxKey newKeyPrevIdx = schema.getFactoryEnumTag().newPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevTenantId( Buff.getOptionalPrevTenantId() );
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamEnumTagByNextIdxKey existingKeyNextIdx = schema.getFactoryEnumTag().newNextIdxKey();
		existingKeyNextIdx.setOptionalNextTenantId( existing.getOptionalNextTenantId() );
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamEnumTagByNextIdxKey newKeyNextIdx = schema.getFactoryEnumTag().newNextIdxKey();
		newKeyNextIdx.setOptionalNextTenantId( Buff.getOptionalNextTenantId() );
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyEnumNameIdx.equals( newKeyEnumNameIdx ) ) {
			if( dictByEnumNameIdx.containsKey( newKeyEnumNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateEnumTag",
					"EnumTagEnumNameIdx",
					newKeyEnumNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateEnumTag",
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableEnumDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredEnumId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateEnumTag",
						"Container",
						"EnumDef",
						"EnumDef",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByEnumTagTenantIdx.get( existingKeyEnumTagTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEnumTagTenantIdx.containsKey( newKeyEnumTagTenantIdx ) ) {
			subdict = dictByEnumTagTenantIdx.get( newKeyEnumTagTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByEnumTagTenantIdx.put( newKeyEnumTagTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByEnumIdx.get( existingKeyEnumIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEnumIdx.containsKey( newKeyEnumIdx ) ) {
			subdict = dictByEnumIdx.get( newKeyEnumIdx );
		}
		else {
			subdict = new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByEnumIdx.put( newKeyEnumIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDefSchemaIdx.get( existingKeyDefSchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDefSchemaIdx.containsKey( newKeyDefSchemaIdx ) ) {
			subdict = dictByDefSchemaIdx.get( newKeyDefSchemaIdx );
		}
		else {
			subdict = new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByEnumNameIdx.remove( existingKeyEnumNameIdx );
		dictByEnumNameIdx.put( newKeyEnumNameIdx, Buff );

		subdict = dictByPrevIdx.get( existingKeyPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrevIdx.containsKey( newKeyPrevIdx ) ) {
			subdict = dictByPrevIdx.get( newKeyPrevIdx );
		}
		else {
			subdict = new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByPrevIdx.put( newKeyPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNextIdx.get( existingKeyNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNextIdx.containsKey( newKeyNextIdx ) ) {
			subdict = dictByNextIdx.get( newKeyNextIdx );
		}
		else {
			subdict = new HashMap< CFBamEnumTagPKey, CFBamEnumTagBuff >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteEnumTag( CFBamAuthorization Authorization,
		CFBamEnumTagBuff Buff )
	{
		final String S_ProcName = "CFBamRamEnumTagTable.deleteEnumTag() ";
		CFBamEnumTagPKey pkey = schema.getFactoryEnumTag().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamEnumTagBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteEnumTag",
				pkey );
		}
		CFBamEnumTagByEnumTagTenantIdxKey keyEnumTagTenantIdx = schema.getFactoryEnumTag().newEnumTagTenantIdxKey();
		keyEnumTagTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamEnumTagByEnumIdxKey keyEnumIdx = schema.getFactoryEnumTag().newEnumIdxKey();
		keyEnumIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyEnumIdx.setRequiredEnumId( existing.getRequiredEnumId() );

		CFBamEnumTagByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryEnumTag().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamEnumTagByEnumNameIdxKey keyEnumNameIdx = schema.getFactoryEnumTag().newEnumNameIdxKey();
		keyEnumNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyEnumNameIdx.setRequiredEnumId( existing.getRequiredEnumId() );
		keyEnumNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamEnumTagByPrevIdxKey keyPrevIdx = schema.getFactoryEnumTag().newPrevIdxKey();
		keyPrevIdx.setOptionalPrevTenantId( existing.getOptionalPrevTenantId() );
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamEnumTagByNextIdxKey keyNextIdx = schema.getFactoryEnumTag().newNextIdxKey();
		keyNextIdx.setOptionalNextTenantId( existing.getOptionalNextTenantId() );
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByEnumTagTenantIdx.get( keyEnumTagTenantIdx );
		subdict.remove( pkey );

		subdict = dictByEnumIdx.get( keyEnumIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		dictByEnumNameIdx.remove( keyEnumNameIdx );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

	}

	public void deleteEnumTagByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamEnumTagPKey key = schema.getFactoryEnumTag().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteEnumTagByIdIdx( Authorization, key );
	}

	public void deleteEnumTagByIdIdx( CFBamAuthorization Authorization,
		CFBamEnumTagPKey argKey )
	{
		CFBamEnumTagBuff cur;
		LinkedList<CFBamEnumTagBuff> matchSet = new LinkedList<CFBamEnumTagBuff>();
		Iterator<CFBamEnumTagBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumTagBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteEnumTag( Authorization, cur );
		}
	}

	public void deleteEnumTagByEnumTagTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamEnumTagByEnumTagTenantIdxKey key = schema.getFactoryEnumTag().newEnumTagTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteEnumTagByEnumTagTenantIdx( Authorization, key );
	}

	public void deleteEnumTagByEnumTagTenantIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByEnumTagTenantIdxKey argKey )
	{
		CFBamEnumTagBuff cur;
		LinkedList<CFBamEnumTagBuff> matchSet = new LinkedList<CFBamEnumTagBuff>();
		Iterator<CFBamEnumTagBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumTagBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteEnumTag( Authorization, cur );
		}
	}

	public void deleteEnumTagByEnumIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argEnumId )
	{
		CFBamEnumTagByEnumIdxKey key = schema.getFactoryEnumTag().newEnumIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredEnumId( argEnumId );
		deleteEnumTagByEnumIdx( Authorization, key );
	}

	public void deleteEnumTagByEnumIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByEnumIdxKey argKey )
	{
		CFBamEnumTagBuff cur;
		LinkedList<CFBamEnumTagBuff> matchSet = new LinkedList<CFBamEnumTagBuff>();
		Iterator<CFBamEnumTagBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumTagBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteEnumTag( Authorization, cur );
		}
	}

	public void deleteEnumTagByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamEnumTagByDefSchemaIdxKey key = schema.getFactoryEnumTag().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteEnumTagByDefSchemaIdx( Authorization, key );
	}

	public void deleteEnumTagByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByDefSchemaIdxKey argKey )
	{
		CFBamEnumTagBuff cur;
		LinkedList<CFBamEnumTagBuff> matchSet = new LinkedList<CFBamEnumTagBuff>();
		Iterator<CFBamEnumTagBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumTagBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteEnumTag( Authorization, cur );
		}
	}

	public void deleteEnumTagByEnumNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argEnumId,
		String argName )
	{
		CFBamEnumTagByEnumNameIdxKey key = schema.getFactoryEnumTag().newEnumNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredEnumId( argEnumId );
		key.setRequiredName( argName );
		deleteEnumTagByEnumNameIdx( Authorization, key );
	}

	public void deleteEnumTagByEnumNameIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByEnumNameIdxKey argKey )
	{
		CFBamEnumTagBuff cur;
		LinkedList<CFBamEnumTagBuff> matchSet = new LinkedList<CFBamEnumTagBuff>();
		Iterator<CFBamEnumTagBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumTagBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteEnumTag( Authorization, cur );
		}
	}

	public void deleteEnumTagByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamEnumTagByPrevIdxKey key = schema.getFactoryEnumTag().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteEnumTagByPrevIdx( Authorization, key );
	}

	public void deleteEnumTagByPrevIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByPrevIdxKey argKey )
	{
		CFBamEnumTagBuff cur;
		LinkedList<CFBamEnumTagBuff> matchSet = new LinkedList<CFBamEnumTagBuff>();
		Iterator<CFBamEnumTagBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumTagBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteEnumTag( Authorization, cur );
		}
	}

	public void deleteEnumTagByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamEnumTagByNextIdxKey key = schema.getFactoryEnumTag().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteEnumTagByNextIdx( Authorization, key );
	}

	public void deleteEnumTagByNextIdx( CFBamAuthorization Authorization,
		CFBamEnumTagByNextIdxKey argKey )
	{
		CFBamEnumTagBuff cur;
		LinkedList<CFBamEnumTagBuff> matchSet = new LinkedList<CFBamEnumTagBuff>();
		Iterator<CFBamEnumTagBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumTagBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteEnumTag( Authorization, cur );
		}
	}

	public CFBamCursor openEnumTagCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamEnumTagCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openEnumTagCursorByEnumTagTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamEnumTagByEnumTagTenantIdxKey key = schema.getFactoryEnumTag().newEnumTagTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByEnumTagTenantIdx.containsKey( key ) ) {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictEnumTagTenantIdx
				= dictByEnumTagTenantIdx.get( key );
			cursor = new CFBamRamEnumTagCursor( Authorization,
				schema,
				subdictEnumTagTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamEnumTagCursor( Authorization,
				schema,
				new ArrayList< CFBamEnumTagBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openEnumTagCursorByEnumIdx( CFBamAuthorization Authorization,
		long TenantId,
		long EnumId )
	{
		CFBamCursor cursor;
		CFBamEnumTagByEnumIdxKey key = schema.getFactoryEnumTag().newEnumIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredEnumId( EnumId );

		if( dictByEnumIdx.containsKey( key ) ) {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictEnumIdx
				= dictByEnumIdx.get( key );
			cursor = new CFBamRamEnumTagCursor( Authorization,
				schema,
				subdictEnumIdx.values() );
		}
		else {
			cursor = new CFBamRamEnumTagCursor( Authorization,
				schema,
				new ArrayList< CFBamEnumTagBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openEnumTagCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamEnumTagByDefSchemaIdxKey key = schema.getFactoryEnumTag().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamEnumTagCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamEnumTagCursor( Authorization,
				schema,
				new ArrayList< CFBamEnumTagBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openEnumTagCursorByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		CFBamCursor cursor;
		CFBamEnumTagByPrevIdxKey key = schema.getFactoryEnumTag().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );

		if( dictByPrevIdx.containsKey( key ) ) {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictPrevIdx
				= dictByPrevIdx.get( key );
			cursor = new CFBamRamEnumTagCursor( Authorization,
				schema,
				subdictPrevIdx.values() );
		}
		else {
			cursor = new CFBamRamEnumTagCursor( Authorization,
				schema,
				new ArrayList< CFBamEnumTagBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openEnumTagCursorByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		CFBamCursor cursor;
		CFBamEnumTagByNextIdxKey key = schema.getFactoryEnumTag().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );

		if( dictByNextIdx.containsKey( key ) ) {
			Map< CFBamEnumTagPKey, CFBamEnumTagBuff > subdictNextIdx
				= dictByNextIdx.get( key );
			cursor = new CFBamRamEnumTagCursor( Authorization,
				schema,
				subdictNextIdx.values() );
		}
		else {
			cursor = new CFBamRamEnumTagCursor( Authorization,
				schema,
				new ArrayList< CFBamEnumTagBuff >() );
		}
		return( cursor );
	}

	public void closeEnumTagCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamEnumTagBuff nextEnumTagCursor( CFBamCursor Cursor ) {
		CFBamRamEnumTagCursor cursor = (CFBamRamEnumTagCursor)Cursor;
		CFBamEnumTagBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamEnumTagBuff prevEnumTagCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamEnumTagBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextEnumTagCursor( Cursor );
		}
		return( rec );
	}

	public CFBamEnumTagBuff firstEnumTagCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamEnumTagBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextEnumTagCursor( Cursor );
		}
		return( rec );
	}

	public CFBamEnumTagBuff lastEnumTagCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastEnumTagCursor" );
	}

	public CFBamEnumTagBuff nthEnumTagCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamEnumTagBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextEnumTagCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
