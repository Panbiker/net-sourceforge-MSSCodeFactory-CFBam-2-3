
// Description: Java7 in-memory RAM DbIO implementation for IndexCol.

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
 *	CFBamRamIndexColTable in-memory RAM DbIO implementation
 *	for IndexCol.
 */
public class CFBamRamIndexColTable
	implements ICFBamIndexColTable
{
	private CFBamRamSchema schema;
	private Map< CFBamIndexColPKey,
				CFBamIndexColBuff > dictByPKey
		= new HashMap< CFBamIndexColPKey,
				CFBamIndexColBuff >();
	private Map< CFBamIndexColByUNameIdxKey,
			CFBamIndexColBuff > dictByUNameIdx
		= new HashMap< CFBamIndexColByUNameIdxKey,
			CFBamIndexColBuff >();
	private Map< CFBamIndexColByIdxColTenantIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >> dictByIdxColTenantIdx
		= new HashMap< CFBamIndexColByIdxColTenantIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >>();
	private Map< CFBamIndexColByIndexIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >> dictByIndexIdx
		= new HashMap< CFBamIndexColByIndexIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >>();
	private Map< CFBamIndexColByDefSchemaIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamIndexColByDefSchemaIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >>();
	private Map< CFBamIndexColByColIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >> dictByColIdx
		= new HashMap< CFBamIndexColByColIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >>();
	private Map< CFBamIndexColByPrevIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >> dictByPrevIdx
		= new HashMap< CFBamIndexColByPrevIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >>();
	private Map< CFBamIndexColByNextIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >> dictByNextIdx
		= new HashMap< CFBamIndexColByNextIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >>();
	private Map< CFBamIndexColByIdxPrevIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >> dictByIdxPrevIdx
		= new HashMap< CFBamIndexColByIdxPrevIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >>();
	private Map< CFBamIndexColByIdxNextIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >> dictByIdxNextIdx
		= new HashMap< CFBamIndexColByIdxNextIdxKey,
				Map< CFBamIndexColPKey,
					CFBamIndexColBuff >>();

	public CFBamRamIndexColTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createIndexCol( CFBamAuthorization Authorization,
		CFBamIndexColBuff Buff )
	{
		final String S_ProcName = "createIndexCol";
			CFBamIndexColBuff tail = null;

			CFBamIndexColBuff[] siblings = schema.getTableIndexCol().readDerivedByIndexIdx( Authorization,
				Buff.getRequiredTenantId(),
				Buff.getRequiredIndexId() );
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
		
		CFBamIndexColPKey pkey = schema.getFactoryIndexCol().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( ((CFBamRamTenantTable)schema.getTableTenant()).nextIndexColIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamIndexColByUNameIdxKey keyUNameIdx = schema.getFactoryIndexCol().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamIndexColByIdxColTenantIdxKey keyIdxColTenantIdx = schema.getFactoryIndexCol().newIdxColTenantIdxKey();
		keyIdxColTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamIndexColByIndexIdxKey keyIndexIdx = schema.getFactoryIndexCol().newIndexIdxKey();
		keyIndexIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyIndexIdx.setRequiredIndexId( Buff.getRequiredIndexId() );

		CFBamIndexColByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryIndexCol().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamIndexColByColIdxKey keyColIdx = schema.getFactoryIndexCol().newColIdxKey();
		keyColIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyColIdx.setRequiredColumnId( Buff.getRequiredColumnId() );

		CFBamIndexColByPrevIdxKey keyPrevIdx = schema.getFactoryIndexCol().newPrevIdxKey();
		keyPrevIdx.setOptionalPrevTenantId( Buff.getOptionalPrevTenantId() );
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamIndexColByNextIdxKey keyNextIdx = schema.getFactoryIndexCol().newNextIdxKey();
		keyNextIdx.setOptionalNextTenantId( Buff.getOptionalNextTenantId() );
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		CFBamIndexColByIdxPrevIdxKey keyIdxPrevIdx = schema.getFactoryIndexCol().newIdxPrevIdxKey();
		keyIdxPrevIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyIdxPrevIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		keyIdxPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamIndexColByIdxNextIdxKey keyIdxNextIdx = schema.getFactoryIndexCol().newIdxNextIdxKey();
		keyIdxNextIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyIdxNextIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		keyIdxNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"IndexColUNameIdx",
				keyUNameIdx );
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
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredIndexId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Index",
						"Index",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredColumnId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Column",
						"Value",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxColTenantIdx;
		if( dictByIdxColTenantIdx.containsKey( keyIdxColTenantIdx ) ) {
			subdictIdxColTenantIdx = dictByIdxColTenantIdx.get( keyIdxColTenantIdx );
		}
		else {
			subdictIdxColTenantIdx = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIdxColTenantIdx.put( keyIdxColTenantIdx, subdictIdxColTenantIdx );
		}
		subdictIdxColTenantIdx.put( pkey, Buff );

		Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIndexIdx;
		if( dictByIndexIdx.containsKey( keyIndexIdx ) ) {
			subdictIndexIdx = dictByIndexIdx.get( keyIndexIdx );
		}
		else {
			subdictIndexIdx = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIndexIdx.put( keyIndexIdx, subdictIndexIdx );
		}
		subdictIndexIdx.put( pkey, Buff );

		Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictColIdx;
		if( dictByColIdx.containsKey( keyColIdx ) ) {
			subdictColIdx = dictByColIdx.get( keyColIdx );
		}
		else {
			subdictColIdx = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByColIdx.put( keyColIdx, subdictColIdx );
		}
		subdictColIdx.put( pkey, Buff );

		Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxPrevIdx;
		if( dictByIdxPrevIdx.containsKey( keyIdxPrevIdx ) ) {
			subdictIdxPrevIdx = dictByIdxPrevIdx.get( keyIdxPrevIdx );
		}
		else {
			subdictIdxPrevIdx = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIdxPrevIdx.put( keyIdxPrevIdx, subdictIdxPrevIdx );
		}
		subdictIdxPrevIdx.put( pkey, Buff );

		Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxNextIdx;
		if( dictByIdxNextIdx.containsKey( keyIdxNextIdx ) ) {
			subdictIdxNextIdx = dictByIdxNextIdx.get( keyIdxNextIdx );
		}
		else {
			subdictIdxNextIdx = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIdxNextIdx.put( keyIdxNextIdx, subdictIdxNextIdx );
		}
		subdictIdxNextIdx.put( pkey, Buff );

		if( tail != null ) {
			CFBamIndexColBuff tailEdit = schema.getFactoryIndexCol().newBuff();
			tailEdit.set( (CFBamIndexColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
			schema.getTableIndexCol().updateIndexCol( Authorization, tailEdit );
		}
	}

	public CFBamIndexColBuff readDerived( CFBamAuthorization Authorization,
		CFBamIndexColPKey PKey )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerived() ";
		CFBamIndexColPKey key = schema.getFactoryIndexCol().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamIndexColBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexColBuff lockDerived( CFBamAuthorization Authorization,
		CFBamIndexColPKey PKey )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerived() ";
		CFBamIndexColPKey key = schema.getFactoryIndexCol().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamIndexColBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexColBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamIndexCol.readAllDerived() ";
		CFBamIndexColBuff[] retList = new CFBamIndexColBuff[ dictByPKey.values().size() ];
		Iterator< CFBamIndexColBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamIndexColBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId,
		String Name )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerivedByUNameIdx() ";
		CFBamIndexColByUNameIdxKey key = schema.getFactoryIndexCol().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setRequiredName( Name );

		CFBamIndexColBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexColBuff[] readDerivedByIdxColTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerivedByIdxColTenantIdx() ";
		CFBamIndexColByIdxColTenantIdxKey key = schema.getFactoryIndexCol().newIdxColTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamIndexColBuff[] recArray;
		if( dictByIdxColTenantIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxColTenantIdx
				= dictByIdxColTenantIdx.get( key );
			recArray = new CFBamIndexColBuff[ subdictIdxColTenantIdx.size() ];
			Iterator< CFBamIndexColBuff > iter = subdictIdxColTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxColTenantIdx
				= new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIdxColTenantIdx.put( key, subdictIdxColTenantIdx );
			recArray = new CFBamIndexColBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexColBuff[] readDerivedByIndexIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerivedByIndexIdx() ";
		CFBamIndexColByIndexIdxKey key = schema.getFactoryIndexCol().newIndexIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );

		CFBamIndexColBuff[] recArray;
		if( dictByIndexIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIndexIdx
				= dictByIndexIdx.get( key );
			recArray = new CFBamIndexColBuff[ subdictIndexIdx.size() ];
			Iterator< CFBamIndexColBuff > iter = subdictIndexIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIndexIdx
				= new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIndexIdx.put( key, subdictIndexIdx );
			recArray = new CFBamIndexColBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexColBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerivedByDefSchemaIdx() ";
		CFBamIndexColByDefSchemaIdxKey key = schema.getFactoryIndexCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamIndexColBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamIndexColBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamIndexColBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictDefSchemaIdx
				= new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamIndexColBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexColBuff[] readDerivedByColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ColumnId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerivedByColIdx() ";
		CFBamIndexColByColIdxKey key = schema.getFactoryIndexCol().newColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredColumnId( ColumnId );

		CFBamIndexColBuff[] recArray;
		if( dictByColIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictColIdx
				= dictByColIdx.get( key );
			recArray = new CFBamIndexColBuff[ subdictColIdx.size() ];
			Iterator< CFBamIndexColBuff > iter = subdictColIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictColIdx
				= new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByColIdx.put( key, subdictColIdx );
			recArray = new CFBamIndexColBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexColBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerivedByPrevIdx() ";
		CFBamIndexColByPrevIdxKey key = schema.getFactoryIndexCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );

		CFBamIndexColBuff[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new CFBamIndexColBuff[ subdictPrevIdx.size() ];
			Iterator< CFBamIndexColBuff > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictPrevIdx
				= new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new CFBamIndexColBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexColBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerivedByNextIdx() ";
		CFBamIndexColByNextIdxKey key = schema.getFactoryIndexCol().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );

		CFBamIndexColBuff[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new CFBamIndexColBuff[ subdictNextIdx.size() ];
			Iterator< CFBamIndexColBuff > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictNextIdx
				= new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new CFBamIndexColBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexColBuff[] readDerivedByIdxPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerivedByIdxPrevIdx() ";
		CFBamIndexColByIdxPrevIdxKey key = schema.getFactoryIndexCol().newIdxPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setOptionalPrevId( PrevId );

		CFBamIndexColBuff[] recArray;
		if( dictByIdxPrevIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxPrevIdx
				= dictByIdxPrevIdx.get( key );
			recArray = new CFBamIndexColBuff[ subdictIdxPrevIdx.size() ];
			Iterator< CFBamIndexColBuff > iter = subdictIdxPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxPrevIdx
				= new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIdxPrevIdx.put( key, subdictIdxPrevIdx );
			recArray = new CFBamIndexColBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexColBuff[] readDerivedByIdxNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerivedByIdxNextIdx() ";
		CFBamIndexColByIdxNextIdxKey key = schema.getFactoryIndexCol().newIdxNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setOptionalNextId( NextId );

		CFBamIndexColBuff[] recArray;
		if( dictByIdxNextIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxNextIdx
				= dictByIdxNextIdx.get( key );
			recArray = new CFBamIndexColBuff[ subdictIdxNextIdx.size() ];
			Iterator< CFBamIndexColBuff > iter = subdictIdxNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxNextIdx
				= new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIdxNextIdx.put( key, subdictIdxNextIdx );
			recArray = new CFBamIndexColBuff[0];
		}
		return( recArray );
	}

	public CFBamIndexColBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamIndexCol.readDerivedByIdIdx() ";
		CFBamIndexColPKey key = schema.getFactoryIndexCol().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamIndexColBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexColBuff readBuff( CFBamAuthorization Authorization,
		CFBamIndexColPKey PKey )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuff() ";
		CFBamIndexColBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "IDXC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexColBuff lockBuff( CFBamAuthorization Authorization,
		CFBamIndexColPKey PKey )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuff() ";
		CFBamIndexColBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "IDXC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamIndexColBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamIndexCol.readAllBuff() ";
		CFBamIndexColBuff buff;
		ArrayList<CFBamIndexColBuff> filteredList = new ArrayList<CFBamIndexColBuff>();
		CFBamIndexColBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexColBuff[0] ) );
	}

	public CFBamIndexColBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuffByIdIdx() ";
		CFBamIndexColBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
			return( (CFBamIndexColBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamIndexColBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId,
		String Name )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuffByUNameIdx() ";
		CFBamIndexColBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			IndexId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
			return( (CFBamIndexColBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamIndexColBuff[] readBuffByIdxColTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuffByIdxColTenantIdx() ";
		CFBamIndexColBuff buff;
		ArrayList<CFBamIndexColBuff> filteredList = new ArrayList<CFBamIndexColBuff>();
		CFBamIndexColBuff[] buffList = readDerivedByIdxColTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
				filteredList.add( (CFBamIndexColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexColBuff[0] ) );
	}

	public CFBamIndexColBuff[] readBuffByIndexIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuffByIndexIdx() ";
		CFBamIndexColBuff buff;
		ArrayList<CFBamIndexColBuff> filteredList = new ArrayList<CFBamIndexColBuff>();
		CFBamIndexColBuff[] buffList = readDerivedByIndexIdx( Authorization,
			TenantId,
			IndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
				filteredList.add( (CFBamIndexColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexColBuff[0] ) );
	}

	public CFBamIndexColBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuffByDefSchemaIdx() ";
		CFBamIndexColBuff buff;
		ArrayList<CFBamIndexColBuff> filteredList = new ArrayList<CFBamIndexColBuff>();
		CFBamIndexColBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
				filteredList.add( (CFBamIndexColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexColBuff[0] ) );
	}

	public CFBamIndexColBuff[] readBuffByColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ColumnId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuffByColIdx() ";
		CFBamIndexColBuff buff;
		ArrayList<CFBamIndexColBuff> filteredList = new ArrayList<CFBamIndexColBuff>();
		CFBamIndexColBuff[] buffList = readDerivedByColIdx( Authorization,
			TenantId,
			ColumnId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
				filteredList.add( (CFBamIndexColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexColBuff[0] ) );
	}

	public CFBamIndexColBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuffByPrevIdx() ";
		CFBamIndexColBuff buff;
		ArrayList<CFBamIndexColBuff> filteredList = new ArrayList<CFBamIndexColBuff>();
		CFBamIndexColBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
				filteredList.add( (CFBamIndexColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexColBuff[0] ) );
	}

	public CFBamIndexColBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuffByNextIdx() ";
		CFBamIndexColBuff buff;
		ArrayList<CFBamIndexColBuff> filteredList = new ArrayList<CFBamIndexColBuff>();
		CFBamIndexColBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
				filteredList.add( (CFBamIndexColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexColBuff[0] ) );
	}

	public CFBamIndexColBuff[] readBuffByIdxPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuffByIdxPrevIdx() ";
		CFBamIndexColBuff buff;
		ArrayList<CFBamIndexColBuff> filteredList = new ArrayList<CFBamIndexColBuff>();
		CFBamIndexColBuff[] buffList = readDerivedByIdxPrevIdx( Authorization,
			TenantId,
			IndexId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
				filteredList.add( (CFBamIndexColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexColBuff[0] ) );
	}

	public CFBamIndexColBuff[] readBuffByIdxNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamIndexCol.readBuffByIdxNextIdx() ";
		CFBamIndexColBuff buff;
		ArrayList<CFBamIndexColBuff> filteredList = new ArrayList<CFBamIndexColBuff>();
		CFBamIndexColBuff[] buffList = readDerivedByIdxNextIdx( Authorization,
			TenantId,
			IndexId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "IDXC" ) ) {
				filteredList.add( (CFBamIndexColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamIndexColBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamIndexColBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamIndexColBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateIndexCol( CFBamAuthorization Authorization,
		CFBamIndexColBuff Buff )
	{
		CFBamIndexColPKey pkey = schema.getFactoryIndexCol().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamIndexColBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateIndexCol",
				"Existing record not found",
				"IndexCol",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateIndexCol",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamIndexColByUNameIdxKey existingKeyUNameIdx = schema.getFactoryIndexCol().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamIndexColByUNameIdxKey newKeyUNameIdx = schema.getFactoryIndexCol().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamIndexColByIdxColTenantIdxKey existingKeyIdxColTenantIdx = schema.getFactoryIndexCol().newIdxColTenantIdxKey();
		existingKeyIdxColTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamIndexColByIdxColTenantIdxKey newKeyIdxColTenantIdx = schema.getFactoryIndexCol().newIdxColTenantIdxKey();
		newKeyIdxColTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamIndexColByIndexIdxKey existingKeyIndexIdx = schema.getFactoryIndexCol().newIndexIdxKey();
		existingKeyIndexIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyIndexIdx.setRequiredIndexId( existing.getRequiredIndexId() );

		CFBamIndexColByIndexIdxKey newKeyIndexIdx = schema.getFactoryIndexCol().newIndexIdxKey();
		newKeyIndexIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyIndexIdx.setRequiredIndexId( Buff.getRequiredIndexId() );

		CFBamIndexColByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryIndexCol().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamIndexColByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryIndexCol().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamIndexColByColIdxKey existingKeyColIdx = schema.getFactoryIndexCol().newColIdxKey();
		existingKeyColIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyColIdx.setRequiredColumnId( existing.getRequiredColumnId() );

		CFBamIndexColByColIdxKey newKeyColIdx = schema.getFactoryIndexCol().newColIdxKey();
		newKeyColIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyColIdx.setRequiredColumnId( Buff.getRequiredColumnId() );

		CFBamIndexColByPrevIdxKey existingKeyPrevIdx = schema.getFactoryIndexCol().newPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevTenantId( existing.getOptionalPrevTenantId() );
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamIndexColByPrevIdxKey newKeyPrevIdx = schema.getFactoryIndexCol().newPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevTenantId( Buff.getOptionalPrevTenantId() );
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamIndexColByNextIdxKey existingKeyNextIdx = schema.getFactoryIndexCol().newNextIdxKey();
		existingKeyNextIdx.setOptionalNextTenantId( existing.getOptionalNextTenantId() );
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamIndexColByNextIdxKey newKeyNextIdx = schema.getFactoryIndexCol().newNextIdxKey();
		newKeyNextIdx.setOptionalNextTenantId( Buff.getOptionalNextTenantId() );
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		CFBamIndexColByIdxPrevIdxKey existingKeyIdxPrevIdx = schema.getFactoryIndexCol().newIdxPrevIdxKey();
		existingKeyIdxPrevIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyIdxPrevIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		existingKeyIdxPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamIndexColByIdxPrevIdxKey newKeyIdxPrevIdx = schema.getFactoryIndexCol().newIdxPrevIdxKey();
		newKeyIdxPrevIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyIdxPrevIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		newKeyIdxPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamIndexColByIdxNextIdxKey existingKeyIdxNextIdx = schema.getFactoryIndexCol().newIdxNextIdxKey();
		existingKeyIdxNextIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyIdxNextIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		existingKeyIdxNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamIndexColByIdxNextIdxKey newKeyIdxNextIdx = schema.getFactoryIndexCol().newIdxNextIdxKey();
		newKeyIdxNextIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyIdxNextIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		newKeyIdxNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateIndexCol",
					"IndexColUNameIdx",
					newKeyUNameIdx );
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
						"updateIndexCol",
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
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredIndexId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateIndexCol",
						"Container",
						"Index",
						"Index",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredColumnId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateIndexCol",
						"Lookup",
						"Column",
						"Value",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamIndexColPKey, CFBamIndexColBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByIdxColTenantIdx.get( existingKeyIdxColTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIdxColTenantIdx.containsKey( newKeyIdxColTenantIdx ) ) {
			subdict = dictByIdxColTenantIdx.get( newKeyIdxColTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIdxColTenantIdx.put( newKeyIdxColTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByIndexIdx.get( existingKeyIndexIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIndexIdx.containsKey( newKeyIndexIdx ) ) {
			subdict = dictByIndexIdx.get( newKeyIndexIdx );
		}
		else {
			subdict = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIndexIdx.put( newKeyIndexIdx, subdict );
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
			subdict = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByColIdx.get( existingKeyColIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByColIdx.containsKey( newKeyColIdx ) ) {
			subdict = dictByColIdx.get( newKeyColIdx );
		}
		else {
			subdict = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByColIdx.put( newKeyColIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByPrevIdx.get( existingKeyPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrevIdx.containsKey( newKeyPrevIdx ) ) {
			subdict = dictByPrevIdx.get( newKeyPrevIdx );
		}
		else {
			subdict = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
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
			subdict = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByIdxPrevIdx.get( existingKeyIdxPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIdxPrevIdx.containsKey( newKeyIdxPrevIdx ) ) {
			subdict = dictByIdxPrevIdx.get( newKeyIdxPrevIdx );
		}
		else {
			subdict = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIdxPrevIdx.put( newKeyIdxPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByIdxNextIdx.get( existingKeyIdxNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIdxNextIdx.containsKey( newKeyIdxNextIdx ) ) {
			subdict = dictByIdxNextIdx.get( newKeyIdxNextIdx );
		}
		else {
			subdict = new HashMap< CFBamIndexColPKey, CFBamIndexColBuff >();
			dictByIdxNextIdx.put( newKeyIdxNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteIndexCol( CFBamAuthorization Authorization,
		CFBamIndexColBuff Buff )
	{
		final String S_ProcName = "CFBamRamIndexColTable.deleteIndexCol() ";
		CFBamIndexColPKey pkey = schema.getFactoryIndexCol().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamIndexColBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteIndexCol",
				pkey );
		}
		CFBamIndexColByUNameIdxKey keyUNameIdx = schema.getFactoryIndexCol().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamIndexColByIdxColTenantIdxKey keyIdxColTenantIdx = schema.getFactoryIndexCol().newIdxColTenantIdxKey();
		keyIdxColTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamIndexColByIndexIdxKey keyIndexIdx = schema.getFactoryIndexCol().newIndexIdxKey();
		keyIndexIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyIndexIdx.setRequiredIndexId( existing.getRequiredIndexId() );

		CFBamIndexColByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryIndexCol().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamIndexColByColIdxKey keyColIdx = schema.getFactoryIndexCol().newColIdxKey();
		keyColIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyColIdx.setRequiredColumnId( existing.getRequiredColumnId() );

		CFBamIndexColByPrevIdxKey keyPrevIdx = schema.getFactoryIndexCol().newPrevIdxKey();
		keyPrevIdx.setOptionalPrevTenantId( existing.getOptionalPrevTenantId() );
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamIndexColByNextIdxKey keyNextIdx = schema.getFactoryIndexCol().newNextIdxKey();
		keyNextIdx.setOptionalNextTenantId( existing.getOptionalNextTenantId() );
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamIndexColByIdxPrevIdxKey keyIdxPrevIdx = schema.getFactoryIndexCol().newIdxPrevIdxKey();
		keyIdxPrevIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyIdxPrevIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		keyIdxPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamIndexColByIdxNextIdxKey keyIdxNextIdx = schema.getFactoryIndexCol().newIdxNextIdxKey();
		keyIdxNextIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyIdxNextIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		keyIdxNextIdx.setOptionalNextId( existing.getOptionalNextId() );


		// Validate reverse foreign keys

		if( schema.getTableRelationCol().readDerivedByFromColIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteIndexCol",
				"Lookup",
				"LookupFromCol",
				"RelationCol",
				pkey );
		}

		if( schema.getTableRelationCol().readDerivedByToColIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteIndexCol",
				"Lookup",
				"LookupToCol",
				"RelationCol",
				pkey );
		}

		// Delete is valid

		Map< CFBamIndexColPKey, CFBamIndexColBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByIdxColTenantIdx.get( keyIdxColTenantIdx );
		subdict.remove( pkey );

		subdict = dictByIndexIdx.get( keyIndexIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByColIdx.get( keyColIdx );
		subdict.remove( pkey );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

		subdict = dictByIdxPrevIdx.get( keyIdxPrevIdx );
		subdict.remove( pkey );

		subdict = dictByIdxNextIdx.get( keyIdxNextIdx );
		subdict.remove( pkey );

	}

	public void deleteIndexColByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamIndexColPKey key = schema.getFactoryIndexCol().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteIndexColByIdIdx( Authorization, key );
	}

	public void deleteIndexColByIdIdx( CFBamAuthorization Authorization,
		CFBamIndexColPKey argKey )
	{
		CFBamIndexColBuff cur;
		LinkedList<CFBamIndexColBuff> matchSet = new LinkedList<CFBamIndexColBuff>();
		Iterator<CFBamIndexColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndexCol( Authorization, cur );
		}
	}

	public void deleteIndexColByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argIndexId,
		String argName )
	{
		CFBamIndexColByUNameIdxKey key = schema.getFactoryIndexCol().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredIndexId( argIndexId );
		key.setRequiredName( argName );
		deleteIndexColByUNameIdx( Authorization, key );
	}

	public void deleteIndexColByUNameIdx( CFBamAuthorization Authorization,
		CFBamIndexColByUNameIdxKey argKey )
	{
		CFBamIndexColBuff cur;
		LinkedList<CFBamIndexColBuff> matchSet = new LinkedList<CFBamIndexColBuff>();
		Iterator<CFBamIndexColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndexCol( Authorization, cur );
		}
	}

	public void deleteIndexColByIdxColTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamIndexColByIdxColTenantIdxKey key = schema.getFactoryIndexCol().newIdxColTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteIndexColByIdxColTenantIdx( Authorization, key );
	}

	public void deleteIndexColByIdxColTenantIdx( CFBamAuthorization Authorization,
		CFBamIndexColByIdxColTenantIdxKey argKey )
	{
		CFBamIndexColBuff cur;
		LinkedList<CFBamIndexColBuff> matchSet = new LinkedList<CFBamIndexColBuff>();
		Iterator<CFBamIndexColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndexCol( Authorization, cur );
		}
	}

	public void deleteIndexColByIndexIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argIndexId )
	{
		CFBamIndexColByIndexIdxKey key = schema.getFactoryIndexCol().newIndexIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredIndexId( argIndexId );
		deleteIndexColByIndexIdx( Authorization, key );
	}

	public void deleteIndexColByIndexIdx( CFBamAuthorization Authorization,
		CFBamIndexColByIndexIdxKey argKey )
	{
		CFBamIndexColBuff cur;
		LinkedList<CFBamIndexColBuff> matchSet = new LinkedList<CFBamIndexColBuff>();
		Iterator<CFBamIndexColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndexCol( Authorization, cur );
		}
	}

	public void deleteIndexColByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamIndexColByDefSchemaIdxKey key = schema.getFactoryIndexCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteIndexColByDefSchemaIdx( Authorization, key );
	}

	public void deleteIndexColByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamIndexColByDefSchemaIdxKey argKey )
	{
		CFBamIndexColBuff cur;
		LinkedList<CFBamIndexColBuff> matchSet = new LinkedList<CFBamIndexColBuff>();
		Iterator<CFBamIndexColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndexCol( Authorization, cur );
		}
	}

	public void deleteIndexColByColIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argColumnId )
	{
		CFBamIndexColByColIdxKey key = schema.getFactoryIndexCol().newColIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredColumnId( argColumnId );
		deleteIndexColByColIdx( Authorization, key );
	}

	public void deleteIndexColByColIdx( CFBamAuthorization Authorization,
		CFBamIndexColByColIdxKey argKey )
	{
		CFBamIndexColBuff cur;
		LinkedList<CFBamIndexColBuff> matchSet = new LinkedList<CFBamIndexColBuff>();
		Iterator<CFBamIndexColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndexCol( Authorization, cur );
		}
	}

	public void deleteIndexColByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamIndexColByPrevIdxKey key = schema.getFactoryIndexCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteIndexColByPrevIdx( Authorization, key );
	}

	public void deleteIndexColByPrevIdx( CFBamAuthorization Authorization,
		CFBamIndexColByPrevIdxKey argKey )
	{
		CFBamIndexColBuff cur;
		LinkedList<CFBamIndexColBuff> matchSet = new LinkedList<CFBamIndexColBuff>();
		Iterator<CFBamIndexColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndexCol( Authorization, cur );
		}
	}

	public void deleteIndexColByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamIndexColByNextIdxKey key = schema.getFactoryIndexCol().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteIndexColByNextIdx( Authorization, key );
	}

	public void deleteIndexColByNextIdx( CFBamAuthorization Authorization,
		CFBamIndexColByNextIdxKey argKey )
	{
		CFBamIndexColBuff cur;
		LinkedList<CFBamIndexColBuff> matchSet = new LinkedList<CFBamIndexColBuff>();
		Iterator<CFBamIndexColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndexCol( Authorization, cur );
		}
	}

	public void deleteIndexColByIdxPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argIndexId,
		Long argPrevId )
	{
		CFBamIndexColByIdxPrevIdxKey key = schema.getFactoryIndexCol().newIdxPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredIndexId( argIndexId );
		key.setOptionalPrevId( argPrevId );
		deleteIndexColByIdxPrevIdx( Authorization, key );
	}

	public void deleteIndexColByIdxPrevIdx( CFBamAuthorization Authorization,
		CFBamIndexColByIdxPrevIdxKey argKey )
	{
		CFBamIndexColBuff cur;
		LinkedList<CFBamIndexColBuff> matchSet = new LinkedList<CFBamIndexColBuff>();
		Iterator<CFBamIndexColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndexCol( Authorization, cur );
		}
	}

	public void deleteIndexColByIdxNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argIndexId,
		Long argNextId )
	{
		CFBamIndexColByIdxNextIdxKey key = schema.getFactoryIndexCol().newIdxNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredIndexId( argIndexId );
		key.setOptionalNextId( argNextId );
		deleteIndexColByIdxNextIdx( Authorization, key );
	}

	public void deleteIndexColByIdxNextIdx( CFBamAuthorization Authorization,
		CFBamIndexColByIdxNextIdxKey argKey )
	{
		CFBamIndexColBuff cur;
		LinkedList<CFBamIndexColBuff> matchSet = new LinkedList<CFBamIndexColBuff>();
		Iterator<CFBamIndexColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamIndexColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteIndexCol( Authorization, cur );
		}
	}

	public CFBamCursor openIndexColCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamIndexColCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openIndexColCursorByIdxColTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamIndexColByIdxColTenantIdxKey key = schema.getFactoryIndexCol().newIdxColTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByIdxColTenantIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxColTenantIdx
				= dictByIdxColTenantIdx.get( key );
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				subdictIdxColTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openIndexColCursorByIndexIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId )
	{
		CFBamCursor cursor;
		CFBamIndexColByIndexIdxKey key = schema.getFactoryIndexCol().newIndexIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );

		if( dictByIndexIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIndexIdx
				= dictByIndexIdx.get( key );
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				subdictIndexIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openIndexColCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamIndexColByDefSchemaIdxKey key = schema.getFactoryIndexCol().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openIndexColCursorByColIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ColumnId )
	{
		CFBamCursor cursor;
		CFBamIndexColByColIdxKey key = schema.getFactoryIndexCol().newColIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredColumnId( ColumnId );

		if( dictByColIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictColIdx
				= dictByColIdx.get( key );
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				subdictColIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openIndexColCursorByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		CFBamCursor cursor;
		CFBamIndexColByPrevIdxKey key = schema.getFactoryIndexCol().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );

		if( dictByPrevIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictPrevIdx
				= dictByPrevIdx.get( key );
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				subdictPrevIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openIndexColCursorByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		CFBamCursor cursor;
		CFBamIndexColByNextIdxKey key = schema.getFactoryIndexCol().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );

		if( dictByNextIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictNextIdx
				= dictByNextIdx.get( key );
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				subdictNextIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openIndexColCursorByIdxPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId,
		Long PrevId )
	{
		CFBamCursor cursor;
		CFBamIndexColByIdxPrevIdxKey key = schema.getFactoryIndexCol().newIdxPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setOptionalPrevId( PrevId );

		if( dictByIdxPrevIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxPrevIdx
				= dictByIdxPrevIdx.get( key );
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				subdictIdxPrevIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexColBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openIndexColCursorByIdxNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long IndexId,
		Long NextId )
	{
		CFBamCursor cursor;
		CFBamIndexColByIdxNextIdxKey key = schema.getFactoryIndexCol().newIdxNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIndexId( IndexId );
		key.setOptionalNextId( NextId );

		if( dictByIdxNextIdx.containsKey( key ) ) {
			Map< CFBamIndexColPKey, CFBamIndexColBuff > subdictIdxNextIdx
				= dictByIdxNextIdx.get( key );
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				subdictIdxNextIdx.values() );
		}
		else {
			cursor = new CFBamRamIndexColCursor( Authorization,
				schema,
				new ArrayList< CFBamIndexColBuff >() );
		}
		return( cursor );
	}

	public void closeIndexColCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamIndexColBuff nextIndexColCursor( CFBamCursor Cursor ) {
		CFBamRamIndexColCursor cursor = (CFBamRamIndexColCursor)Cursor;
		CFBamIndexColBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamIndexColBuff prevIndexColCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamIndexColBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextIndexColCursor( Cursor );
		}
		return( rec );
	}

	public CFBamIndexColBuff firstIndexColCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamIndexColBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextIndexColCursor( Cursor );
		}
		return( rec );
	}

	public CFBamIndexColBuff lastIndexColCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastIndexColCursor" );
	}

	public CFBamIndexColBuff nthIndexColCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamIndexColBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextIndexColCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
