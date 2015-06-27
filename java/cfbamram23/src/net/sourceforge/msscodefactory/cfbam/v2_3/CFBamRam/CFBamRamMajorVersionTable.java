
// Description: Java7 in-memory RAM DbIO implementation for MajorVersion.

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
 *	CFBamRamMajorVersionTable in-memory RAM DbIO implementation
 *	for MajorVersion.
 */
public class CFBamRamMajorVersionTable
	implements ICFBamMajorVersionTable
{
	private CFBamRamSchema schema;
	private Map< CFBamDomainBasePKey,
				CFBamMajorVersionBuff > dictByPKey
		= new HashMap< CFBamDomainBasePKey,
				CFBamMajorVersionBuff >();
	private Map< CFBamMajorVersionByPPrjIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamMajorVersionBuff >> dictByPPrjIdx
		= new HashMap< CFBamMajorVersionByPPrjIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamMajorVersionBuff >>();
	private Map< CFBamMajorVersionByNameIdxKey,
			CFBamMajorVersionBuff > dictByNameIdx
		= new HashMap< CFBamMajorVersionByNameIdxKey,
			CFBamMajorVersionBuff >();

	public CFBamRamMajorVersionTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createMajorVersion( CFBamAuthorization Authorization,
		CFBamMajorVersionBuff Buff )
	{
		final String S_ProcName = "createMajorVersion";
		schema.getTableVersion().createVersion( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamMajorVersionByPPrjIdxKey keyPPrjIdx = schema.getFactoryMajorVersion().newPPrjIdxKey();
		keyPPrjIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyPPrjIdx.setRequiredParentProjectId( Buff.getRequiredParentProjectId() );

		CFBamMajorVersionByNameIdxKey keyNameIdx = schema.getFactoryMajorVersion().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyNameIdx.setRequiredParentProjectId( Buff.getRequiredParentProjectId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"MajorVersionNameIdx",
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
				if( null == schema.getTableRealProject().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredParentProjectId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ParentProject",
						"RealProject",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamDomainBasePKey, CFBamMajorVersionBuff > subdictPPrjIdx;
		if( dictByPPrjIdx.containsKey( keyPPrjIdx ) ) {
			subdictPPrjIdx = dictByPPrjIdx.get( keyPPrjIdx );
		}
		else {
			subdictPPrjIdx = new HashMap< CFBamDomainBasePKey, CFBamMajorVersionBuff >();
			dictByPPrjIdx.put( keyPPrjIdx, subdictPPrjIdx );
		}
		subdictPPrjIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

	}

	public CFBamMajorVersionBuff readDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamMajorVersion.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamMajorVersionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMajorVersionBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamMajorVersion.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamMajorVersionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMajorVersionBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamMajorVersion.readAllDerived() ";
		CFBamMajorVersionBuff[] retList = new CFBamMajorVersionBuff[ dictByPKey.values().size() ];
		Iterator< CFBamMajorVersionBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamMajorVersionBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamMajorVersionBuff> filteredList = new ArrayList<CFBamMajorVersionBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamMajorVersionBuff ) ) {
					filteredList.add( (CFBamMajorVersionBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamMajorVersionBuff[0] ) );
		}
	}

	public CFBamMajorVersionBuff[] readDerivedByPPrjIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ParentProjectId )
	{
		final String S_ProcName = "CFBamRamMajorVersion.readDerivedByPPrjIdx() ";
		CFBamMajorVersionByPPrjIdxKey key = schema.getFactoryMajorVersion().newPPrjIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );

		CFBamMajorVersionBuff[] recArray;
		if( dictByPPrjIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamMajorVersionBuff > subdictPPrjIdx
				= dictByPPrjIdx.get( key );
			recArray = new CFBamMajorVersionBuff[ subdictPPrjIdx.size() ];
			Iterator< CFBamMajorVersionBuff > iter = subdictPPrjIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamDomainBasePKey, CFBamMajorVersionBuff > subdictPPrjIdx
				= new HashMap< CFBamDomainBasePKey, CFBamMajorVersionBuff >();
			dictByPPrjIdx.put( key, subdictPPrjIdx );
			recArray = new CFBamMajorVersionBuff[0];
		}
		return( recArray );
	}

	public CFBamMajorVersionBuff readDerivedByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ParentProjectId,
		String Name )
	{
		final String S_ProcName = "CFBamRamMajorVersion.readDerivedByNameIdx() ";
		CFBamMajorVersionByNameIdxKey key = schema.getFactoryMajorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		key.setRequiredName( Name );

		CFBamMajorVersionBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMajorVersionBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByIdIdx() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamMajorVersionBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamMajorVersionBuff readBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamMajorVersion.readBuff() ";
		CFBamMajorVersionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "MJVR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamMajorVersionBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamMajorVersion.readBuff() ";
		CFBamMajorVersionBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "MJVR" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamMajorVersionBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamMajorVersion.readAllBuff() ";
		CFBamMajorVersionBuff buff;
		ArrayList<CFBamMajorVersionBuff> filteredList = new ArrayList<CFBamMajorVersionBuff>();
		CFBamMajorVersionBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "MJVR" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamMajorVersionBuff[0] ) );
	}

	public CFBamMajorVersionBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByIdIdx() ";
		CFBamDomainBaseBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
			return( (CFBamMajorVersionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamMajorVersionBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByTenantIdx() ";
		CFBamDomainBaseBuff buff;
		ArrayList<CFBamMajorVersionBuff> filteredList = new ArrayList<CFBamMajorVersionBuff>();
		CFBamDomainBaseBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
				filteredList.add( (CFBamMajorVersionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamMajorVersionBuff[0] ) );
	}

	public CFBamMajorVersionBuff[] readBuffByPPrjIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ParentProjectId )
	{
		final String S_ProcName = "CFBamRamMajorVersion.readBuffByPPrjIdx() ";
		CFBamMajorVersionBuff buff;
		ArrayList<CFBamMajorVersionBuff> filteredList = new ArrayList<CFBamMajorVersionBuff>();
		CFBamMajorVersionBuff[] buffList = readDerivedByPPrjIdx( Authorization,
			TenantId,
			ParentProjectId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "MJVR" ) ) {
				filteredList.add( (CFBamMajorVersionBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamMajorVersionBuff[0] ) );
	}

	public CFBamMajorVersionBuff readBuffByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ParentProjectId,
		String Name )
	{
		final String S_ProcName = "CFBamRamMajorVersion.readBuffByNameIdx() ";
		CFBamMajorVersionBuff buff = readDerivedByNameIdx( Authorization,
			TenantId,
			ParentProjectId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "MJVR" ) ) {
			return( (CFBamMajorVersionBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateMajorVersion( CFBamAuthorization Authorization,
		CFBamMajorVersionBuff Buff )
	{
		schema.getTableVersion().updateVersion( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamMajorVersionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateMajorVersion",
				"Existing record not found",
				"MajorVersion",
				pkey );
		}
		CFBamMajorVersionByPPrjIdxKey existingKeyPPrjIdx = schema.getFactoryMajorVersion().newPPrjIdxKey();
		existingKeyPPrjIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyPPrjIdx.setRequiredParentProjectId( existing.getRequiredParentProjectId() );

		CFBamMajorVersionByPPrjIdxKey newKeyPPrjIdx = schema.getFactoryMajorVersion().newPPrjIdxKey();
		newKeyPPrjIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyPPrjIdx.setRequiredParentProjectId( Buff.getRequiredParentProjectId() );

		CFBamMajorVersionByNameIdxKey existingKeyNameIdx = schema.getFactoryMajorVersion().newNameIdxKey();
		existingKeyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyNameIdx.setRequiredParentProjectId( existing.getRequiredParentProjectId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamMajorVersionByNameIdxKey newKeyNameIdx = schema.getFactoryMajorVersion().newNameIdxKey();
		newKeyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyNameIdx.setRequiredParentProjectId( Buff.getRequiredParentProjectId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateMajorVersion",
					"MajorVersionNameIdx",
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
						"updateMajorVersion",
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
				if( null == schema.getTableRealProject().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredParentProjectId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateMajorVersion",
						"Container",
						"ParentProject",
						"RealProject",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamDomainBasePKey, CFBamMajorVersionBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByPPrjIdx.get( existingKeyPPrjIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPPrjIdx.containsKey( newKeyPPrjIdx ) ) {
			subdict = dictByPPrjIdx.get( newKeyPPrjIdx );
		}
		else {
			subdict = new HashMap< CFBamDomainBasePKey, CFBamMajorVersionBuff >();
			dictByPPrjIdx.put( newKeyPPrjIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

	}

	public void deleteMajorVersion( CFBamAuthorization Authorization,
		CFBamMajorVersionBuff Buff )
	{
		final String S_ProcName = "CFBamRamMajorVersionTable.deleteMajorVersion() ";
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamMajorVersionBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteMajorVersion",
				pkey );
		}
		CFBamMajorVersionByPPrjIdxKey keyPPrjIdx = schema.getFactoryMajorVersion().newPPrjIdxKey();
		keyPPrjIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyPPrjIdx.setRequiredParentProjectId( existing.getRequiredParentProjectId() );

		CFBamMajorVersionByNameIdxKey keyNameIdx = schema.getFactoryMajorVersion().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyNameIdx.setRequiredParentProjectId( existing.getRequiredParentProjectId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableMinorVersion().deleteMinorVersionByMajorIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableSchemaDef().deleteSchemaDefByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableLicense().deleteLicenseByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamDomainBasePKey, CFBamMajorVersionBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByPPrjIdx.get( keyPPrjIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

		schema.getTableVersion().deleteVersion( Authorization,
			Buff );
	}

	public void deleteMajorVersionByPPrjIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argParentProjectId )
	{
		CFBamMajorVersionByPPrjIdxKey key = schema.getFactoryMajorVersion().newPPrjIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredParentProjectId( argParentProjectId );
		deleteMajorVersionByPPrjIdx( Authorization, key );
	}

	public void deleteMajorVersionByPPrjIdx( CFBamAuthorization Authorization,
		CFBamMajorVersionByPPrjIdxKey argKey )
	{
		CFBamMajorVersionBuff cur;
		LinkedList<CFBamMajorVersionBuff> matchSet = new LinkedList<CFBamMajorVersionBuff>();
		Iterator<CFBamMajorVersionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamMajorVersionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteMajorVersion( Authorization, cur );
		}
	}

	public void deleteMajorVersionByNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argParentProjectId,
		String argName )
	{
		CFBamMajorVersionByNameIdxKey key = schema.getFactoryMajorVersion().newNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredParentProjectId( argParentProjectId );
		key.setRequiredName( argName );
		deleteMajorVersionByNameIdx( Authorization, key );
	}

	public void deleteMajorVersionByNameIdx( CFBamAuthorization Authorization,
		CFBamMajorVersionByNameIdxKey argKey )
	{
		CFBamMajorVersionBuff cur;
		LinkedList<CFBamMajorVersionBuff> matchSet = new LinkedList<CFBamMajorVersionBuff>();
		Iterator<CFBamMajorVersionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamMajorVersionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteMajorVersion( Authorization, cur );
		}
	}

	public void deleteMajorVersionByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteMajorVersionByIdIdx( Authorization, key );
	}

	public void deleteMajorVersionByIdIdx( CFBamAuthorization Authorization,
		CFBamDomainBasePKey argKey )
	{
		CFBamMajorVersionBuff cur;
		LinkedList<CFBamMajorVersionBuff> matchSet = new LinkedList<CFBamMajorVersionBuff>();
		Iterator<CFBamMajorVersionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamMajorVersionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteMajorVersion( Authorization, cur );
		}
	}

	public void deleteMajorVersionByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteMajorVersionByTenantIdx( Authorization, key );
	}

	public void deleteMajorVersionByTenantIdx( CFBamAuthorization Authorization,
		CFBamDomainBaseByTenantIdxKey argKey )
	{
		CFBamMajorVersionBuff cur;
		LinkedList<CFBamMajorVersionBuff> matchSet = new LinkedList<CFBamMajorVersionBuff>();
		Iterator<CFBamMajorVersionBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamMajorVersionBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteMajorVersion( Authorization, cur );
		}
	}

	public CFBamCursor openMajorVersionCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamMajorVersionCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openMajorVersionCursorByPPrjIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ParentProjectId )
	{
		CFBamCursor cursor;
		CFBamMajorVersionByPPrjIdxKey key = schema.getFactoryMajorVersion().newPPrjIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );

		if( dictByPPrjIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamMajorVersionBuff > subdictPPrjIdx
				= dictByPPrjIdx.get( key );
			cursor = new CFBamRamMajorVersionCursor( Authorization,
				schema,
				subdictPPrjIdx.values() );
		}
		else {
			cursor = new CFBamRamMajorVersionCursor( Authorization,
				schema,
				new ArrayList< CFBamMajorVersionBuff >() );
		}
		return( cursor );
	}

	public void closeMajorVersionCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamMajorVersionBuff nextMajorVersionCursor( CFBamCursor Cursor ) {
		CFBamRamMajorVersionCursor cursor = (CFBamRamMajorVersionCursor)Cursor;
		CFBamMajorVersionBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamMajorVersionBuff prevMajorVersionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamMajorVersionBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextMajorVersionCursor( Cursor );
		}
		return( rec );
	}

	public CFBamMajorVersionBuff firstMajorVersionCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamMajorVersionBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextMajorVersionCursor( Cursor );
		}
		return( rec );
	}

	public CFBamMajorVersionBuff lastMajorVersionCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastMajorVersionCursor" );
	}

	public CFBamMajorVersionBuff nthMajorVersionCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamMajorVersionBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextMajorVersionCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
