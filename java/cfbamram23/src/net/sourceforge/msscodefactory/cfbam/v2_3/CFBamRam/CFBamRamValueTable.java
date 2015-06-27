
// Description: Java7 in-memory RAM DbIO implementation for Value.

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
 *	CFBamRamValueTable in-memory RAM DbIO implementation
 *	for Value.
 */
public class CFBamRamValueTable
	implements ICFBamValueTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamValueBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamValueBuff >();
	private Map< CFBamValueByUNameIdxKey,
			CFBamValueBuff > dictByUNameIdx
		= new HashMap< CFBamValueByUNameIdxKey,
			CFBamValueBuff >();
	private Map< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByValTentIdx
		= new HashMap< CFBamValueByValTentIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByScopeIdx
		= new HashMap< CFBamValueByScopeIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByDefSchemaIdx
		= new HashMap< CFBamValueByDefSchemaIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByDataScopeIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByDataScopeIdx
		= new HashMap< CFBamValueByDataScopeIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByVAccSecIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByVAccSecIdx
		= new HashMap< CFBamValueByVAccSecIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByVAccFreqIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByVAccFreqIdx
		= new HashMap< CFBamValueByVAccFreqIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByEAccSecIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByEAccSecIdx
		= new HashMap< CFBamValueByEAccSecIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByEAccFreqIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByEAccFreqIdx
		= new HashMap< CFBamValueByEAccFreqIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByPrevIdx
		= new HashMap< CFBamValueByPrevIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByNextIdx
		= new HashMap< CFBamValueByNextIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByContPrevIdx
		= new HashMap< CFBamValueByContPrevIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();
	private Map< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >> dictByContNextIdx
		= new HashMap< CFBamValueByContNextIdxKey,
				Map< CFBamValuePKey,
					CFBamValueBuff >>();

	public CFBamRamValueTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createValue( CFBamAuthorization Authorization,
		CFBamValueBuff Buff )
	{
		final String S_ProcName = "createValue";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( ((CFBamRamTenantTable)schema.getTableTenant()).nextValueIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamValueByUNameIdxKey keyUNameIdx = schema.getFactoryValue().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamValueByValTentIdxKey keyValTentIdx = schema.getFactoryValue().newValTentIdxKey();
		keyValTentIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamValueByScopeIdxKey keyScopeIdx = schema.getFactoryValue().newScopeIdxKey();
		keyScopeIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyScopeIdx.setRequiredScopeId( Buff.getRequiredScopeId() );

		CFBamValueByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryValue().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamValueByDataScopeIdxKey keyDataScopeIdx = schema.getFactoryValue().newDataScopeIdxKey();
		keyDataScopeIdx.setOptionalDataScopeId( Buff.getOptionalDataScopeId() );

		CFBamValueByVAccSecIdxKey keyVAccSecIdx = schema.getFactoryValue().newVAccSecIdxKey();
		keyVAccSecIdx.setOptionalViewAccessSecurityId( Buff.getOptionalViewAccessSecurityId() );

		CFBamValueByVAccFreqIdxKey keyVAccFreqIdx = schema.getFactoryValue().newVAccFreqIdxKey();
		keyVAccFreqIdx.setOptionalViewAccessFrequencyId( Buff.getOptionalViewAccessFrequencyId() );

		CFBamValueByEAccSecIdxKey keyEAccSecIdx = schema.getFactoryValue().newEAccSecIdxKey();
		keyEAccSecIdx.setOptionalEditAccessSecurityId( Buff.getOptionalEditAccessSecurityId() );

		CFBamValueByEAccFreqIdxKey keyEAccFreqIdx = schema.getFactoryValue().newEAccFreqIdxKey();
		keyEAccFreqIdx.setOptionalEditAccessFrequencyId( Buff.getOptionalEditAccessFrequencyId() );

		CFBamValueByPrevIdxKey keyPrevIdx = schema.getFactoryValue().newPrevIdxKey();
		keyPrevIdx.setOptionalPrevTenantId( Buff.getOptionalPrevTenantId() );
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamValueByNextIdxKey keyNextIdx = schema.getFactoryValue().newNextIdxKey();
		keyNextIdx.setOptionalNextTenantId( Buff.getOptionalNextTenantId() );
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		CFBamValueByContPrevIdxKey keyContPrevIdx = schema.getFactoryValue().newContPrevIdxKey();
		keyContPrevIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyContPrevIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		keyContPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamValueByContNextIdxKey keyContNextIdx = schema.getFactoryValue().newContNextIdxKey();
		keyContNextIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyContNextIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		keyContNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ValueUNameIdx",
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
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredScopeId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Scope",
						"Scope",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictValTentIdx;
		if( dictByValTentIdx.containsKey( keyValTentIdx ) ) {
			subdictValTentIdx = dictByValTentIdx.get( keyValTentIdx );
		}
		else {
			subdictValTentIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByValTentIdx.put( keyValTentIdx, subdictValTentIdx );
		}
		subdictValTentIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictScopeIdx;
		if( dictByScopeIdx.containsKey( keyScopeIdx ) ) {
			subdictScopeIdx = dictByScopeIdx.get( keyScopeIdx );
		}
		else {
			subdictScopeIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByScopeIdx.put( keyScopeIdx, subdictScopeIdx );
		}
		subdictScopeIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictDataScopeIdx;
		if( dictByDataScopeIdx.containsKey( keyDataScopeIdx ) ) {
			subdictDataScopeIdx = dictByDataScopeIdx.get( keyDataScopeIdx );
		}
		else {
			subdictDataScopeIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByDataScopeIdx.put( keyDataScopeIdx, subdictDataScopeIdx );
		}
		subdictDataScopeIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictVAccSecIdx;
		if( dictByVAccSecIdx.containsKey( keyVAccSecIdx ) ) {
			subdictVAccSecIdx = dictByVAccSecIdx.get( keyVAccSecIdx );
		}
		else {
			subdictVAccSecIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByVAccSecIdx.put( keyVAccSecIdx, subdictVAccSecIdx );
		}
		subdictVAccSecIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictVAccFreqIdx;
		if( dictByVAccFreqIdx.containsKey( keyVAccFreqIdx ) ) {
			subdictVAccFreqIdx = dictByVAccFreqIdx.get( keyVAccFreqIdx );
		}
		else {
			subdictVAccFreqIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByVAccFreqIdx.put( keyVAccFreqIdx, subdictVAccFreqIdx );
		}
		subdictVAccFreqIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictEAccSecIdx;
		if( dictByEAccSecIdx.containsKey( keyEAccSecIdx ) ) {
			subdictEAccSecIdx = dictByEAccSecIdx.get( keyEAccSecIdx );
		}
		else {
			subdictEAccSecIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByEAccSecIdx.put( keyEAccSecIdx, subdictEAccSecIdx );
		}
		subdictEAccSecIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictEAccFreqIdx;
		if( dictByEAccFreqIdx.containsKey( keyEAccFreqIdx ) ) {
			subdictEAccFreqIdx = dictByEAccFreqIdx.get( keyEAccFreqIdx );
		}
		else {
			subdictEAccFreqIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByEAccFreqIdx.put( keyEAccFreqIdx, subdictEAccFreqIdx );
		}
		subdictEAccFreqIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictContPrevIdx;
		if( dictByContPrevIdx.containsKey( keyContPrevIdx ) ) {
			subdictContPrevIdx = dictByContPrevIdx.get( keyContPrevIdx );
		}
		else {
			subdictContPrevIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByContPrevIdx.put( keyContPrevIdx, subdictContPrevIdx );
		}
		subdictContPrevIdx.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamValueBuff > subdictContNextIdx;
		if( dictByContNextIdx.containsKey( keyContNextIdx ) ) {
			subdictContNextIdx = dictByContNextIdx.get( keyContNextIdx );
		}
		else {
			subdictContNextIdx = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByContNextIdx.put( keyContNextIdx, subdictContNextIdx );
		}
		subdictContNextIdx.put( pkey, Buff );

	}

	public CFBamValueBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamValue.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamValueBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamValueBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamValue.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamValueBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamValueBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamValue.readAllDerived() ";
		CFBamValueBuff[] retList = new CFBamValueBuff[ dictByPKey.values().size() ];
		Iterator< CFBamValueBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamValueBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByUNameIdx() ";
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );

		CFBamValueBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamValueBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByValTentIdx() ";
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamValueBuff[] recArray;
		if( dictByValTentIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictValTentIdx
				= dictByValTentIdx.get( key );
			recArray = new CFBamValueBuff[ subdictValTentIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictValTentIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictValTentIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByValTentIdx.put( key, subdictValTentIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByScopeIdx() ";
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );

		CFBamValueBuff[] recArray;
		if( dictByScopeIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictScopeIdx
				= dictByScopeIdx.get( key );
			recArray = new CFBamValueBuff[ subdictScopeIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictScopeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictScopeIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByScopeIdx.put( key, subdictScopeIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByDefSchemaIdx() ";
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		CFBamValueBuff[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new CFBamValueBuff[ subdictDefSchemaIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictDefSchemaIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByDataScopeIdx() ";
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );

		CFBamValueBuff[] recArray;
		if( dictByDataScopeIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictDataScopeIdx
				= dictByDataScopeIdx.get( key );
			recArray = new CFBamValueBuff[ subdictDataScopeIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictDataScopeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictDataScopeIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByDataScopeIdx.put( key, subdictDataScopeIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByVAccSecIdx() ";
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );

		CFBamValueBuff[] recArray;
		if( dictByVAccSecIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictVAccSecIdx
				= dictByVAccSecIdx.get( key );
			recArray = new CFBamValueBuff[ subdictVAccSecIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictVAccSecIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictVAccSecIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByVAccSecIdx.put( key, subdictVAccSecIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByVAccFreqIdx() ";
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );

		CFBamValueBuff[] recArray;
		if( dictByVAccFreqIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictVAccFreqIdx
				= dictByVAccFreqIdx.get( key );
			recArray = new CFBamValueBuff[ subdictVAccFreqIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictVAccFreqIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictVAccFreqIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByVAccFreqIdx.put( key, subdictVAccFreqIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByEAccSecIdx() ";
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );

		CFBamValueBuff[] recArray;
		if( dictByEAccSecIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictEAccSecIdx
				= dictByEAccSecIdx.get( key );
			recArray = new CFBamValueBuff[ subdictEAccSecIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictEAccSecIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictEAccSecIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByEAccSecIdx.put( key, subdictEAccSecIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByEAccFreqIdx() ";
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );

		CFBamValueBuff[] recArray;
		if( dictByEAccFreqIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictEAccFreqIdx
				= dictByEAccFreqIdx.get( key );
			recArray = new CFBamValueBuff[ subdictEAccFreqIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictEAccFreqIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictEAccFreqIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByEAccFreqIdx.put( key, subdictEAccFreqIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByPrevIdx() ";
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );

		CFBamValueBuff[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new CFBamValueBuff[ subdictPrevIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictPrevIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByNextIdx() ";
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );

		CFBamValueBuff[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new CFBamValueBuff[ subdictNextIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictNextIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByContPrevIdx() ";
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );

		CFBamValueBuff[] recArray;
		if( dictByContPrevIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictContPrevIdx
				= dictByContPrevIdx.get( key );
			recArray = new CFBamValueBuff[ subdictContPrevIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictContPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictContPrevIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByContPrevIdx.put( key, subdictContPrevIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByContNextIdx() ";
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );

		CFBamValueBuff[] recArray;
		if( dictByContNextIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictContNextIdx
				= dictByContNextIdx.get( key );
			recArray = new CFBamValueBuff[ subdictContNextIdx.size() ];
			Iterator< CFBamValueBuff > iter = subdictContNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamValueBuff > subdictContNextIdx
				= new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByContNextIdx.put( key, subdictContNextIdx );
			recArray = new CFBamValueBuff[0];
		}
		return( recArray );
	}

	public CFBamValueBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamValueBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamValueBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamValue.readBuff() ";
		CFBamValueBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "VALU" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamValueBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamValue.readBuff() ";
		CFBamValueBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "VALU" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamValueBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamValue.readAllBuff() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamValueBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamValueBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByUNameIdx() ";
		CFBamValueBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			ScopeId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamValueBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamValueBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	public CFBamValueBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamValueBuff> filteredList = new ArrayList<CFBamValueBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamValueBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamValueBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamValueBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamValueBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateValue( CFBamAuthorization Authorization,
		CFBamValueBuff Buff )
	{
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamValueBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateValue",
				"Existing record not found",
				"Value",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateValue",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamValueByUNameIdxKey existingKeyUNameIdx = schema.getFactoryValue().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamValueByUNameIdxKey newKeyUNameIdx = schema.getFactoryValue().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		CFBamValueByValTentIdxKey existingKeyValTentIdx = schema.getFactoryValue().newValTentIdxKey();
		existingKeyValTentIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamValueByValTentIdxKey newKeyValTentIdx = schema.getFactoryValue().newValTentIdxKey();
		newKeyValTentIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamValueByScopeIdxKey existingKeyScopeIdx = schema.getFactoryValue().newScopeIdxKey();
		existingKeyScopeIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyScopeIdx.setRequiredScopeId( existing.getRequiredScopeId() );

		CFBamValueByScopeIdxKey newKeyScopeIdx = schema.getFactoryValue().newScopeIdxKey();
		newKeyScopeIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyScopeIdx.setRequiredScopeId( Buff.getRequiredScopeId() );

		CFBamValueByDefSchemaIdxKey existingKeyDefSchemaIdx = schema.getFactoryValue().newDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamValueByDefSchemaIdxKey newKeyDefSchemaIdx = schema.getFactoryValue().newDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		CFBamValueByDataScopeIdxKey existingKeyDataScopeIdx = schema.getFactoryValue().newDataScopeIdxKey();
		existingKeyDataScopeIdx.setOptionalDataScopeId( existing.getOptionalDataScopeId() );

		CFBamValueByDataScopeIdxKey newKeyDataScopeIdx = schema.getFactoryValue().newDataScopeIdxKey();
		newKeyDataScopeIdx.setOptionalDataScopeId( Buff.getOptionalDataScopeId() );

		CFBamValueByVAccSecIdxKey existingKeyVAccSecIdx = schema.getFactoryValue().newVAccSecIdxKey();
		existingKeyVAccSecIdx.setOptionalViewAccessSecurityId( existing.getOptionalViewAccessSecurityId() );

		CFBamValueByVAccSecIdxKey newKeyVAccSecIdx = schema.getFactoryValue().newVAccSecIdxKey();
		newKeyVAccSecIdx.setOptionalViewAccessSecurityId( Buff.getOptionalViewAccessSecurityId() );

		CFBamValueByVAccFreqIdxKey existingKeyVAccFreqIdx = schema.getFactoryValue().newVAccFreqIdxKey();
		existingKeyVAccFreqIdx.setOptionalViewAccessFrequencyId( existing.getOptionalViewAccessFrequencyId() );

		CFBamValueByVAccFreqIdxKey newKeyVAccFreqIdx = schema.getFactoryValue().newVAccFreqIdxKey();
		newKeyVAccFreqIdx.setOptionalViewAccessFrequencyId( Buff.getOptionalViewAccessFrequencyId() );

		CFBamValueByEAccSecIdxKey existingKeyEAccSecIdx = schema.getFactoryValue().newEAccSecIdxKey();
		existingKeyEAccSecIdx.setOptionalEditAccessSecurityId( existing.getOptionalEditAccessSecurityId() );

		CFBamValueByEAccSecIdxKey newKeyEAccSecIdx = schema.getFactoryValue().newEAccSecIdxKey();
		newKeyEAccSecIdx.setOptionalEditAccessSecurityId( Buff.getOptionalEditAccessSecurityId() );

		CFBamValueByEAccFreqIdxKey existingKeyEAccFreqIdx = schema.getFactoryValue().newEAccFreqIdxKey();
		existingKeyEAccFreqIdx.setOptionalEditAccessFrequencyId( existing.getOptionalEditAccessFrequencyId() );

		CFBamValueByEAccFreqIdxKey newKeyEAccFreqIdx = schema.getFactoryValue().newEAccFreqIdxKey();
		newKeyEAccFreqIdx.setOptionalEditAccessFrequencyId( Buff.getOptionalEditAccessFrequencyId() );

		CFBamValueByPrevIdxKey existingKeyPrevIdx = schema.getFactoryValue().newPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevTenantId( existing.getOptionalPrevTenantId() );
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamValueByPrevIdxKey newKeyPrevIdx = schema.getFactoryValue().newPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevTenantId( Buff.getOptionalPrevTenantId() );
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamValueByNextIdxKey existingKeyNextIdx = schema.getFactoryValue().newNextIdxKey();
		existingKeyNextIdx.setOptionalNextTenantId( existing.getOptionalNextTenantId() );
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamValueByNextIdxKey newKeyNextIdx = schema.getFactoryValue().newNextIdxKey();
		newKeyNextIdx.setOptionalNextTenantId( Buff.getOptionalNextTenantId() );
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		CFBamValueByContPrevIdxKey existingKeyContPrevIdx = schema.getFactoryValue().newContPrevIdxKey();
		existingKeyContPrevIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyContPrevIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		existingKeyContPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamValueByContPrevIdxKey newKeyContPrevIdx = schema.getFactoryValue().newContPrevIdxKey();
		newKeyContPrevIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyContPrevIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		newKeyContPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		CFBamValueByContNextIdxKey existingKeyContNextIdx = schema.getFactoryValue().newContNextIdxKey();
		existingKeyContNextIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyContNextIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		existingKeyContNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamValueByContNextIdxKey newKeyContNextIdx = schema.getFactoryValue().newContNextIdxKey();
		newKeyContNextIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyContNextIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		newKeyContNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateValue",
					"ValueUNameIdx",
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
						"updateValue",
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
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredScopeId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateValue",
						"Container",
						"Scope",
						"Scope",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamValueBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByValTentIdx.get( existingKeyValTentIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByValTentIdx.containsKey( newKeyValTentIdx ) ) {
			subdict = dictByValTentIdx.get( newKeyValTentIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByValTentIdx.put( newKeyValTentIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByScopeIdx.get( existingKeyScopeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByScopeIdx.containsKey( newKeyScopeIdx ) ) {
			subdict = dictByScopeIdx.get( newKeyScopeIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByScopeIdx.put( newKeyScopeIdx, subdict );
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
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDataScopeIdx.get( existingKeyDataScopeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDataScopeIdx.containsKey( newKeyDataScopeIdx ) ) {
			subdict = dictByDataScopeIdx.get( newKeyDataScopeIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByDataScopeIdx.put( newKeyDataScopeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByVAccSecIdx.get( existingKeyVAccSecIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByVAccSecIdx.containsKey( newKeyVAccSecIdx ) ) {
			subdict = dictByVAccSecIdx.get( newKeyVAccSecIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByVAccSecIdx.put( newKeyVAccSecIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByVAccFreqIdx.get( existingKeyVAccFreqIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByVAccFreqIdx.containsKey( newKeyVAccFreqIdx ) ) {
			subdict = dictByVAccFreqIdx.get( newKeyVAccFreqIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByVAccFreqIdx.put( newKeyVAccFreqIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByEAccSecIdx.get( existingKeyEAccSecIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEAccSecIdx.containsKey( newKeyEAccSecIdx ) ) {
			subdict = dictByEAccSecIdx.get( newKeyEAccSecIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByEAccSecIdx.put( newKeyEAccSecIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByEAccFreqIdx.get( existingKeyEAccFreqIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEAccFreqIdx.containsKey( newKeyEAccFreqIdx ) ) {
			subdict = dictByEAccFreqIdx.get( newKeyEAccFreqIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByEAccFreqIdx.put( newKeyEAccFreqIdx, subdict );
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
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
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
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByContPrevIdx.get( existingKeyContPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContPrevIdx.containsKey( newKeyContPrevIdx ) ) {
			subdict = dictByContPrevIdx.get( newKeyContPrevIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByContPrevIdx.put( newKeyContPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByContNextIdx.get( existingKeyContNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContNextIdx.containsKey( newKeyContNextIdx ) ) {
			subdict = dictByContNextIdx.get( newKeyContNextIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamValueBuff >();
			dictByContNextIdx.put( newKeyContNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteValue( CFBamAuthorization Authorization,
		CFBamValueBuff Buff )
	{
		final String S_ProcName = "CFBamRamValueTable.deleteValue() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamValueBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteValue",
				pkey );
		}
		CFBamValueByUNameIdxKey keyUNameIdx = schema.getFactoryValue().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamValueByValTentIdxKey keyValTentIdx = schema.getFactoryValue().newValTentIdxKey();
		keyValTentIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamValueByScopeIdxKey keyScopeIdx = schema.getFactoryValue().newScopeIdxKey();
		keyScopeIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyScopeIdx.setRequiredScopeId( existing.getRequiredScopeId() );

		CFBamValueByDefSchemaIdxKey keyDefSchemaIdx = schema.getFactoryValue().newDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		CFBamValueByDataScopeIdxKey keyDataScopeIdx = schema.getFactoryValue().newDataScopeIdxKey();
		keyDataScopeIdx.setOptionalDataScopeId( existing.getOptionalDataScopeId() );

		CFBamValueByVAccSecIdxKey keyVAccSecIdx = schema.getFactoryValue().newVAccSecIdxKey();
		keyVAccSecIdx.setOptionalViewAccessSecurityId( existing.getOptionalViewAccessSecurityId() );

		CFBamValueByVAccFreqIdxKey keyVAccFreqIdx = schema.getFactoryValue().newVAccFreqIdxKey();
		keyVAccFreqIdx.setOptionalViewAccessFrequencyId( existing.getOptionalViewAccessFrequencyId() );

		CFBamValueByEAccSecIdxKey keyEAccSecIdx = schema.getFactoryValue().newEAccSecIdxKey();
		keyEAccSecIdx.setOptionalEditAccessSecurityId( existing.getOptionalEditAccessSecurityId() );

		CFBamValueByEAccFreqIdxKey keyEAccFreqIdx = schema.getFactoryValue().newEAccFreqIdxKey();
		keyEAccFreqIdx.setOptionalEditAccessFrequencyId( existing.getOptionalEditAccessFrequencyId() );

		CFBamValueByPrevIdxKey keyPrevIdx = schema.getFactoryValue().newPrevIdxKey();
		keyPrevIdx.setOptionalPrevTenantId( existing.getOptionalPrevTenantId() );
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamValueByNextIdxKey keyNextIdx = schema.getFactoryValue().newNextIdxKey();
		keyNextIdx.setOptionalNextTenantId( existing.getOptionalNextTenantId() );
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		CFBamValueByContPrevIdxKey keyContPrevIdx = schema.getFactoryValue().newContPrevIdxKey();
		keyContPrevIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyContPrevIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyContPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		CFBamValueByContNextIdxKey keyContNextIdx = schema.getFactoryValue().newContNextIdxKey();
		keyContNextIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyContNextIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyContNextIdx.setOptionalNextId( existing.getOptionalNextId() );


		// Validate reverse foreign keys

		if( schema.getTableTableCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteValue",
				"Superclass",
				"SuperClass",
				"TableCol",
				pkey );
		}

		if( schema.getTableAtom().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteValue",
				"Superclass",
				"SuperClass",
				"Atom",
				pkey );
		}

		if( schema.getTableIndexCol().readDerivedByColIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteValue",
				"Lookup",
				"Column",
				"IndexCol",
				pkey );
		}

		if( schema.getTableParam().readDerivedByServerTypeIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ).length > 0 )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteValue",
				"Lookup",
				"Type",
				"Param",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamValueBuff > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByValTentIdx.get( keyValTentIdx );
		subdict.remove( pkey );

		subdict = dictByScopeIdx.get( keyScopeIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByDataScopeIdx.get( keyDataScopeIdx );
		subdict.remove( pkey );

		subdict = dictByVAccSecIdx.get( keyVAccSecIdx );
		subdict.remove( pkey );

		subdict = dictByVAccFreqIdx.get( keyVAccFreqIdx );
		subdict.remove( pkey );

		subdict = dictByEAccSecIdx.get( keyEAccSecIdx );
		subdict.remove( pkey );

		subdict = dictByEAccFreqIdx.get( keyEAccFreqIdx );
		subdict.remove( pkey );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

		subdict = dictByContPrevIdx.get( keyContPrevIdx );
		subdict.remove( pkey );

		subdict = dictByContNextIdx.get( keyContNextIdx );
		subdict.remove( pkey );

	}

	public void deleteValueByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteValueByIdIdx( Authorization, key );
	}

	public void deleteValueByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteValueByIdIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteValueByUNameIdx( Authorization, key );
	}

	public void deleteValueByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByUNameIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteValueByValTentIdx( Authorization, key );
	}

	public void deleteValueByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByValTentIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteValueByScopeIdx( Authorization, key );
	}

	public void deleteValueByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByScopeIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteValueByDefSchemaIdx( Authorization, key );
	}

	public void deleteValueByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByDefSchemaIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteValueByDataScopeIdx( Authorization, key );
	}

	public void deleteValueByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByDataScopeIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteValueByVAccSecIdx( Authorization, key );
	}

	public void deleteValueByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByVAccSecIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteValueByVAccFreqIdx( Authorization, key );
	}

	public void deleteValueByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByVAccFreqIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteValueByEAccSecIdx( Authorization, key );
	}

	public void deleteValueByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByEAccSecIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteValueByEAccFreqIdx( Authorization, key );
	}

	public void deleteValueByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByEAccFreqIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteValueByPrevIdx( Authorization, key );
	}

	public void deleteValueByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByPrevIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteValueByNextIdx( Authorization, key );
	}

	public void deleteValueByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByNextIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteValueByContPrevIdx( Authorization, key );
	}

	public void deleteValueByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByContPrevIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteValueByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteValueByContNextIdx( Authorization, key );
	}

	public void deleteValueByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteValueByContNextIdx";
		CFBamValueBuff cur;
		LinkedList<CFBamValueBuff> matchSet = new LinkedList<CFBamValueBuff>();
		Iterator<CFBamValueBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamValueBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "VALU".equals( subClassCode ) ) {
				schema.getTableValue().deleteValue( Authorization, cur );
			}
			else if( "TBLC".equals( subClassCode ) ) {
				schema.getTableTableCol().deleteTableCol( Authorization, (CFBamTableColBuff)cur );
			}
			else if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, (CFBamAtomBuff)cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Value must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openValueCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamValueCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openValueCursorByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByValTentIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictValTentIdx
				= dictByValTentIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictValTentIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		CFBamCursor cursor;
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );

		if( dictByScopeIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictScopeIdx
				= dictByScopeIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictScopeIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamCursor cursor;
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );

		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictDefSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		CFBamCursor cursor;
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( DataScopeId );

		if( dictByDataScopeIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictDataScopeIdx
				= dictByDataScopeIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictDataScopeIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		CFBamCursor cursor;
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( ViewAccessSecurityId );

		if( dictByVAccSecIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictVAccSecIdx
				= dictByVAccSecIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictVAccSecIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		CFBamCursor cursor;
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( ViewAccessFrequencyId );

		if( dictByVAccFreqIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictVAccFreqIdx
				= dictByVAccFreqIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictVAccFreqIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		CFBamCursor cursor;
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( EditAccessSecurityId );

		if( dictByEAccSecIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictEAccSecIdx
				= dictByEAccSecIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictEAccSecIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		CFBamCursor cursor;
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( EditAccessFrequencyId );

		if( dictByEAccFreqIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictEAccFreqIdx
				= dictByEAccFreqIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictEAccFreqIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		CFBamCursor cursor;
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );

		if( dictByPrevIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictPrevIdx
				= dictByPrevIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictPrevIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		CFBamCursor cursor;
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );

		if( dictByNextIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictNextIdx
				= dictByNextIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictNextIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		CFBamCursor cursor;
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );

		if( dictByContPrevIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictContPrevIdx
				= dictByContPrevIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictContPrevIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openValueCursorByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		CFBamCursor cursor;
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );

		if( dictByContNextIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamValueBuff > subdictContNextIdx
				= dictByContNextIdx.get( key );
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				subdictContNextIdx.values() );
		}
		else {
			cursor = new CFBamRamValueCursor( Authorization,
				schema,
				new ArrayList< CFBamValueBuff >() );
		}
		return( cursor );
	}

	public void closeValueCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamValueBuff nextValueCursor( CFBamCursor Cursor ) {
		CFBamRamValueCursor cursor = (CFBamRamValueCursor)Cursor;
		CFBamValueBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamValueBuff prevValueCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamValueBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextValueCursor( Cursor );
		}
		return( rec );
	}

	public CFBamValueBuff firstValueCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamValueBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextValueCursor( Cursor );
		}
		return( rec );
	}

	public CFBamValueBuff lastValueCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastValueCursor" );
	}

	public CFBamValueBuff nthValueCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamValueBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextValueCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
