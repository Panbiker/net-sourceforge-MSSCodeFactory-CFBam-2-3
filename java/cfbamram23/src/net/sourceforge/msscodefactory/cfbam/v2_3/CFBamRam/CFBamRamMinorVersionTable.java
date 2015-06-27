
// Description: Java7 in-memory RAM DbIO implementation for MinorVersion.

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
 *	CFBamRamMinorVersionTable in-memory RAM DbIO implementation
 *	for MinorVersion.
 */
public class CFBamRamMinorVersionTable
	implements ICFBamMinorVersionTable
{
	private CFBamRamSchema schema;
	private Map< CFBamDomainBasePKey,
				CFBamMinorVersionBuff > dictByPKey
		= new HashMap< CFBamDomainBasePKey,
				CFBamMinorVersionBuff >();
	private Map< CFBamMinorVersionByMajorIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamMinorVersionBuff >> dictByMajorIdx
		= new HashMap< CFBamMinorVersionByMajorIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamMinorVersionBuff >>();
	private Map< CFBamMinorVersionByNameIdxKey,
			CFBamMinorVersionBuff > dictByNameIdx
		= new HashMap< CFBamMinorVersionByNameIdxKey,
			CFBamMinorVersionBuff >();

	public CFBamRamMinorVersionTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createMinorVersion( CFBamAuthorization Authorization,
		CFBamMinorVersionBuff Buff )
	{
		final String S_ProcName = "createMinorVersion";
		schema.getTableVersion().createVersion( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamMinorVersionByMajorIdxKey keyMajorIdx = schema.getFactoryMinorVersion().newMajorIdxKey();
		keyMajorIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyMajorIdx.setRequiredMajorId( Buff.getRequiredMajorId() );

		CFBamMinorVersionByNameIdxKey keyNameIdx = schema.getFactoryMinorVersion().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyNameIdx.setRequiredMajorId( Buff.getRequiredMajorId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"MinorVersionNameIdx",
				keyNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableVersion().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"Version",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableMajorVersion().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredMajorId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"MajorVersion",
						"MajorVersion",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamDomainBasePKey, CFBamMinorVersionBuff > subdictMajorIdx;
		if( dictByMajorIdx.containsKey( keyMajorIdx ) ) {
			subdictMajorIdx = dictByMajorIdx.get( keyMajorIdx );
		}
		else {
			subdictMajorIdx = new HashMap< CFBamDomainBasePKey, CFBamMinorVersionBuff >();
			dictByMajorIdx.put( keyMajorIdx, subdictMajorIdx );
		}
		subdictMajorIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

	}

	public CFBamMinorVersionBuff readDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamMinorVersion.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamMinorVersionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMinorVersionBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamMinorVersion.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamMinorVersionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMinorVersionBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamMinorVersion.readAllDerived() ";
		CFBamMinorVersionBuff[] retList = new CFBamMinorVersionBuff[ dictByPKey.values().size() ];
		Iterator< CFBamMinorVersionBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamMinorVersionBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByTenantIdx() ";
		CFBamDomainBaseBuff buffList[] = schema.getTableDomainBase().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamDomainBaseBuff buff;
			ArrayList<CFBamMinorVersionBuff> filteredList = new ArrayList<CFBamMinorVersionBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamMinorVersionBuff ) ) {
					filteredList.add( (CFBamMinorVersionBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamMinorVersionBuff[0] ) );
		}
	}

	public CFBamMinorVersionBuff[] readDerivedByMajorIdx( CFBamAuthorization Authorization,
		long TenantId,
		long MajorId )
	{
		final String S_ProcName = "CFBamRamMinorVersion.readDerivedByMajorIdx() ";
		CFBamMinorVersionByMajorIdxKey key = schema.getFactoryMinorVersion().newMajorIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMajorId( MajorId );

		CFBamMinorVersionBuff[] recArray;
		if( dictByMajorIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamMinorVersionBuff > subdictMajorIdx
				= dictByMajorIdx.get( key );
			recArray = new CFBamMinorVersionBuff[ subdictMajorIdx.size() ];
			Iterator< CFBamMinorVersionBuff > iter = subdictMajorIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamDomainBasePKey, CFBamMinorVersionBuff > subdictMajorIdx
				= new HashMap< CFBamDomainBasePKey, CFBamMinorVersionBuff >();
			dictByMajorIdx.put( key, subdictMajorIdx );
			recArray = new CFBamMinorVersionBuff[0];
		}
		return( recArray );
	}

	public CFBamMinorVersionBuff readDerivedByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long MajorId,
		String Name )
	{
		final String S_ProcName = "CFBamRamMinorVersion.readDerivedByNameIdx() ";
		CFBamMinorVersionByNameIdxKey key = schema.getFactoryMinorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMajorId( MajorId );
		key.setRequiredName( Name );

		CFBamMinorVersionBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMinorVersionBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByIdIdx() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamMinorVersionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMinorVersionBuff readBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamMinorVersion.readBuff() ";
		CFBamMinorVersionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "MNVR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamMinorVersionBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamMinorVersion.readBuff() ";
		CFBamMinorVersionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "MNVR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamMinorVersionBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamMinorVersion.readAllBuff() ";
		CFBamMinorVersionBuff buff;
		ArrayList<CFBamMinorVersionBuff> filteredList = new ArrayList<CFBamMinorVersionBuff>();
		CFBamMinorVersionBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "MNVR" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamMinorVersionBuff[0] ) );
	}

	public CFBamMinorVersionBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByIdIdx() ";
		CFBamDomainBaseBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
			return( (CFBamMinorVersionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamMinorVersionBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByTenantIdx() ";
		CFBamDomainBaseBuff buff;
		ArrayList<CFBamMinorVersionBuff> filteredList = new ArrayList<CFBamMinorVersionBuff>();
		CFBamDomainBaseBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
				filteredList.add( (CFBamMinorVersionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamMinorVersionBuff[0] ) );
	}

	public CFBamMinorVersionBuff[] readBuffByMajorIdx( CFBamAuthorization Authorization,
		long TenantId,
		long MajorId )
	{
		final String S_ProcName = "CFBamRamMinorVersion.readBuffByMajorIdx() ";
		CFBamMinorVersionBuff buff;
		ArrayList<CFBamMinorVersionBuff> filteredList = new ArrayList<CFBamMinorVersionBuff>();
		CFBamMinorVersionBuff[] buffList = readDerivedByMajorIdx( Authorization,
			TenantId,
			MajorId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "MNVR" ) ) {
				filteredList.add( (CFBamMinorVersionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamMinorVersionBuff[0] ) );
	}

	public CFBamMinorVersionBuff readBuffByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long MajorId,
		String Name )
	{
		final String S_ProcName = "CFBamRamMinorVersion.readBuffByNameIdx() ";
		CFBamMinorVersionBuff buff = readDerivedByNameIdx( Authorization,
			TenantId,
			MajorId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "MNVR" ) ) {
			return( (CFBamMinorVersionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateMinorVersion( CFBamAuthorization Authorization,
		CFBamMinorVersionBuff Buff )
	{
		schema.getTableVersion().updateVersion( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamMinorVersionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateMinorVersion",
				"Existing record not found",
				"MinorVersion",
				pkey );
		}
		CFBamMinorVersionByMajorIdxKey existingKeyMajorIdx = schema.getFactoryMinorVersion().newMajorIdxKey();
		existingKeyMajorIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyMajorIdx.setRequiredMajorId( existing.getRequiredMajorId() );

		CFBamMinorVersionByMajorIdxKey newKeyMajorIdx = schema.getFactoryMinorVersion().newMajorIdxKey();
		newKeyMajorIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyMajorIdx.setRequiredMajorId( Buff.getRequiredMajorId() );

		CFBamMinorVersionByNameIdxKey existingKeyNameIdx = schema.getFactoryMinorVersion().newNameIdxKey();
		existingKeyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyNameIdx.setRequiredMajorId( existing.getRequiredMajorId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamMinorVersionByNameIdxKey newKeyNameIdx = schema.getFactoryMinorVersion().newNameIdxKey();
		newKeyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyNameIdx.setRequiredMajorId( Buff.getRequiredMajorId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateMinorVersion",
					"MinorVersionNameIdx",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableVersion().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateMinorVersion",
						"Superclass",
						"SuperClass",
						"Version",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableMajorVersion().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredMajorId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateMinorVersion",
						"Container",
						"MajorVersion",
						"MajorVersion",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamDomainBasePKey, CFBamMinorVersionBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByMajorIdx.get( existingKeyMajorIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByMajorIdx.containsKey( newKeyMajorIdx ) ) {
			subdict = dictByMajorIdx.get( newKeyMajorIdx );
		}
		else {
			subdict = new HashMap< CFBamDomainBasePKey, CFBamMinorVersionBuff >();
			dictByMajorIdx.put( newKeyMajorIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

	}

	public void deleteMinorVersion( CFBamAuthorization Authorization,
		CFBamMinorVersionBuff Buff )
	{
		final String S_ProcName = "CFBamRamMinorVersionTable.deleteMinorVersion() ";
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamMinorVersionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteMinorVersion",
				pkey );
		}
		CFBamMinorVersionByMajorIdxKey keyMajorIdx = schema.getFactoryMinorVersion().newMajorIdxKey();
		keyMajorIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyMajorIdx.setRequiredMajorId( existing.getRequiredMajorId() );

		CFBamMinorVersionByNameIdxKey keyNameIdx = schema.getFactoryMinorVersion().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyNameIdx.setRequiredMajorId( existing.getRequiredMajorId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableSchemaDef().deleteSchemaDefByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableLicense().deleteLicenseByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamDomainBasePKey, CFBamMinorVersionBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByMajorIdx.get( keyMajorIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

		schema.getTableVersion().deleteVersion( Authorization,
			Buff );
	}

	public void deleteMinorVersionByMajorIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argMajorId )
	{
		CFBamMinorVersionByMajorIdxKey key = schema.getFactoryMinorVersion().newMajorIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredMajorId( argMajorId );
		deleteMinorVersionByMajorIdx( Authorization, key );
	}

	public void deleteMinorVersionByMajorIdx( CFBamAuthorization Authorization,
		CFBamMinorVersionByMajorIdxKey argKey )
	{
		CFBamMinorVersionBuff cur;
		LinkedList<CFBamMinorVersionBuff> matchSet = new LinkedList<CFBamMinorVersionBuff>();
		Iterator<CFBamMinorVersionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamMinorVersionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteMinorVersion( Authorization, cur );
		}
	}

	public void deleteMinorVersionByNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argMajorId,
		String argName )
	{
		CFBamMinorVersionByNameIdxKey key = schema.getFactoryMinorVersion().newNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredMajorId( argMajorId );
		key.setRequiredName( argName );
		deleteMinorVersionByNameIdx( Authorization, key );
	}

	public void deleteMinorVersionByNameIdx( CFBamAuthorization Authorization,
		CFBamMinorVersionByNameIdxKey argKey )
	{
		CFBamMinorVersionBuff cur;
		LinkedList<CFBamMinorVersionBuff> matchSet = new LinkedList<CFBamMinorVersionBuff>();
		Iterator<CFBamMinorVersionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamMinorVersionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteMinorVersion( Authorization, cur );
		}
	}

	public void deleteMinorVersionByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteMinorVersionByIdIdx( Authorization, key );
	}

	public void deleteMinorVersionByIdIdx( CFBamAuthorization Authorization,
		CFBamDomainBasePKey argKey )
	{
		CFBamMinorVersionBuff cur;
		LinkedList<CFBamMinorVersionBuff> matchSet = new LinkedList<CFBamMinorVersionBuff>();
		Iterator<CFBamMinorVersionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamMinorVersionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteMinorVersion( Authorization, cur );
		}
	}

	public void deleteMinorVersionByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteMinorVersionByTenantIdx( Authorization, key );
	}

	public void deleteMinorVersionByTenantIdx( CFBamAuthorization Authorization,
		CFBamDomainBaseByTenantIdxKey argKey )
	{
		CFBamMinorVersionBuff cur;
		LinkedList<CFBamMinorVersionBuff> matchSet = new LinkedList<CFBamMinorVersionBuff>();
		Iterator<CFBamMinorVersionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamMinorVersionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteMinorVersion( Authorization, cur );
		}
	}

	public CFBamCursor openMinorVersionCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamMinorVersionCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openMinorVersionCursorByMajorIdx( CFBamAuthorization Authorization,
		long TenantId,
		long MajorId )
	{
		CFBamCursor cursor;
		CFBamMinorVersionByMajorIdxKey key = schema.getFactoryMinorVersion().newMajorIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredMajorId( MajorId );

		if( dictByMajorIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamMinorVersionBuff > subdictMajorIdx
				= dictByMajorIdx.get( key );
			cursor = new CFBamRamMinorVersionCursor( Authorization,
				schema,
				subdictMajorIdx.values() );
		}
		else {
			cursor = new CFBamRamMinorVersionCursor( Authorization,
				schema,
				new ArrayList< CFBamMinorVersionBuff >() );
		}
		return( cursor );
	}

	public void closeMinorVersionCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamMinorVersionBuff nextMinorVersionCursor( CFBamCursor Cursor ) {
		CFBamRamMinorVersionCursor cursor = (CFBamRamMinorVersionCursor)Cursor;
		CFBamMinorVersionBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamMinorVersionBuff prevMinorVersionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamMinorVersionBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextMinorVersionCursor( Cursor );
		}
		return( rec );
	}

	public CFBamMinorVersionBuff firstMinorVersionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamMinorVersionBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextMinorVersionCursor( Cursor );
		}
		return( rec );
	}

	public CFBamMinorVersionBuff lastMinorVersionCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastMinorVersionCursor" );
	}

	public CFBamMinorVersionBuff nthMinorVersionCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamMinorVersionBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextMinorVersionCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
