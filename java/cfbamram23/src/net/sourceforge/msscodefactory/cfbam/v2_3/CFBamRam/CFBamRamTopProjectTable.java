
// Description: Java7 in-memory RAM DbIO implementation for TopProject.

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
 *	CFBamRamTopProjectTable in-memory RAM DbIO implementation
 *	for TopProject.
 */
public class CFBamRamTopProjectTable
	implements ICFBamTopProjectTable
{
	private CFBamRamSchema schema;
	private Map< CFBamDomainBasePKey,
				CFBamTopProjectBuff > dictByPKey
		= new HashMap< CFBamDomainBasePKey,
				CFBamTopProjectBuff >();
	private Map< CFBamTopProjectByDomainIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamTopProjectBuff >> dictByDomainIdx
		= new HashMap< CFBamTopProjectByDomainIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamTopProjectBuff >>();
	private Map< CFBamTopProjectByNameIdxKey,
			CFBamTopProjectBuff > dictByNameIdx
		= new HashMap< CFBamTopProjectByNameIdxKey,
			CFBamTopProjectBuff >();

	public CFBamRamTopProjectTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTopProject( CFBamAuthorization Authorization,
		CFBamTopProjectBuff Buff )
	{
		final String S_ProcName = "createTopProject";
		schema.getTableRealProject().createRealProject( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTopProjectByDomainIdxKey keyDomainIdx = schema.getFactoryTopProject().newDomainIdxKey();
		keyDomainIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyDomainIdx.setRequiredDomainId( Buff.getRequiredDomainId() );

		CFBamTopProjectByNameIdxKey keyNameIdx = schema.getFactoryTopProject().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyNameIdx.setRequiredDomainId( Buff.getRequiredDomainId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TopProjectNameIdx",
				keyNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRealProject().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"RealProject",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableDomainBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredDomainId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Domain",
						"DomainBase",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamDomainBasePKey, CFBamTopProjectBuff > subdictDomainIdx;
		if( dictByDomainIdx.containsKey( keyDomainIdx ) ) {
			subdictDomainIdx = dictByDomainIdx.get( keyDomainIdx );
		}
		else {
			subdictDomainIdx = new HashMap< CFBamDomainBasePKey, CFBamTopProjectBuff >();
			dictByDomainIdx.put( keyDomainIdx, subdictDomainIdx );
		}
		subdictDomainIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

	}

	public CFBamTopProjectBuff readDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamTopProject.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTopProjectBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopProjectBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamTopProject.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTopProjectBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopProjectBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTopProject.readAllDerived() ";
		CFBamTopProjectBuff[] retList = new CFBamTopProjectBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTopProjectBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTopProjectBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTopProjectBuff> filteredList = new ArrayList<CFBamTopProjectBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTopProjectBuff ) ) {
					filteredList.add( (CFBamTopProjectBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTopProjectBuff[0] ) );
		}
	}

	public CFBamTopProjectBuff[] readDerivedByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		final String S_ProcName = "CFBamRamTopProject.readDerivedByDomainIdx() ";
		CFBamTopProjectByDomainIdxKey key = schema.getFactoryTopProject().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );

		CFBamTopProjectBuff[] recArray;
		if( dictByDomainIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamTopProjectBuff > subdictDomainIdx
				= dictByDomainIdx.get( key );
			recArray = new CFBamTopProjectBuff[ subdictDomainIdx.size() ];
			Iterator< CFBamTopProjectBuff > iter = subdictDomainIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamDomainBasePKey, CFBamTopProjectBuff > subdictDomainIdx
				= new HashMap< CFBamDomainBasePKey, CFBamTopProjectBuff >();
			dictByDomainIdx.put( key, subdictDomainIdx );
			recArray = new CFBamTopProjectBuff[0];
		}
		return( recArray );
	}

	public CFBamTopProjectBuff readDerivedByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId,
		String Name )
	{
		final String S_ProcName = "CFBamRamTopProject.readDerivedByNameIdx() ";
		CFBamTopProjectByNameIdxKey key = schema.getFactoryTopProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );

		CFBamTopProjectBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopProjectBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByIdIdx() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamTopProjectBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopProjectBuff readBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamTopProject.readBuff() ";
		CFBamTopProjectBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TPRJ" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopProjectBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamTopProject.readBuff() ";
		CFBamTopProjectBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TPRJ" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTopProjectBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTopProject.readAllBuff() ";
		CFBamTopProjectBuff buff;
		ArrayList<CFBamTopProjectBuff> filteredList = new ArrayList<CFBamTopProjectBuff>();
		CFBamTopProjectBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TPRJ" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTopProjectBuff[0] ) );
	}

	public CFBamTopProjectBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByIdIdx() ";
		CFBamDomainBaseBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
			return( (CFBamTopProjectBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTopProjectBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByTenantIdx() ";
		CFBamDomainBaseBuff buff;
		ArrayList<CFBamTopProjectBuff> filteredList = new ArrayList<CFBamTopProjectBuff>();
		CFBamDomainBaseBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
				filteredList.add( (CFBamTopProjectBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTopProjectBuff[0] ) );
	}

	public CFBamTopProjectBuff[] readBuffByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		final String S_ProcName = "CFBamRamTopProject.readBuffByDomainIdx() ";
		CFBamTopProjectBuff buff;
		ArrayList<CFBamTopProjectBuff> filteredList = new ArrayList<CFBamTopProjectBuff>();
		CFBamTopProjectBuff[] buffList = readDerivedByDomainIdx( Authorization,
			TenantId,
			DomainId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TPRJ" ) ) {
				filteredList.add( (CFBamTopProjectBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTopProjectBuff[0] ) );
	}

	public CFBamTopProjectBuff readBuffByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId,
		String Name )
	{
		final String S_ProcName = "CFBamRamTopProject.readBuffByNameIdx() ";
		CFBamTopProjectBuff buff = readDerivedByNameIdx( Authorization,
			TenantId,
			DomainId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "TPRJ" ) ) {
			return( (CFBamTopProjectBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateTopProject( CFBamAuthorization Authorization,
		CFBamTopProjectBuff Buff )
	{
		schema.getTableRealProject().updateRealProject( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTopProjectBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTopProject",
				"Existing record not found",
				"TopProject",
				pkey );
		}
		CFBamTopProjectByDomainIdxKey existingKeyDomainIdx = schema.getFactoryTopProject().newDomainIdxKey();
		existingKeyDomainIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyDomainIdx.setRequiredDomainId( existing.getRequiredDomainId() );

		CFBamTopProjectByDomainIdxKey newKeyDomainIdx = schema.getFactoryTopProject().newDomainIdxKey();
		newKeyDomainIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyDomainIdx.setRequiredDomainId( Buff.getRequiredDomainId() );

		CFBamTopProjectByNameIdxKey existingKeyNameIdx = schema.getFactoryTopProject().newNameIdxKey();
		existingKeyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyNameIdx.setRequiredDomainId( existing.getRequiredDomainId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamTopProjectByNameIdxKey newKeyNameIdx = schema.getFactoryTopProject().newNameIdxKey();
		newKeyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyNameIdx.setRequiredDomainId( Buff.getRequiredDomainId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateTopProject",
					"TopProjectNameIdx",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRealProject().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTopProject",
						"Superclass",
						"SuperClass",
						"RealProject",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDomainBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredDomainId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateTopProject",
						"Container",
						"Domain",
						"DomainBase",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamDomainBasePKey, CFBamTopProjectBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByDomainIdx.get( existingKeyDomainIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDomainIdx.containsKey( newKeyDomainIdx ) ) {
			subdict = dictByDomainIdx.get( newKeyDomainIdx );
		}
		else {
			subdict = new HashMap< CFBamDomainBasePKey, CFBamTopProjectBuff >();
			dictByDomainIdx.put( newKeyDomainIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

	}

	public void deleteTopProject( CFBamAuthorization Authorization,
		CFBamTopProjectBuff Buff )
	{
		final String S_ProcName = "CFBamRamTopProjectTable.deleteTopProject() ";
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTopProjectBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTopProject",
				pkey );
		}
		CFBamTopProjectByDomainIdxKey keyDomainIdx = schema.getFactoryTopProject().newDomainIdxKey();
		keyDomainIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyDomainIdx.setRequiredDomainId( existing.getRequiredDomainId() );

		CFBamTopProjectByNameIdxKey keyNameIdx = schema.getFactoryTopProject().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyNameIdx.setRequiredDomainId( existing.getRequiredDomainId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableSubProject().deleteSubProjectByParentIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableMajorVersion().deleteMajorVersionByPPrjIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableSchemaDef().deleteSchemaDefByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableLicense().deleteLicenseByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamDomainBasePKey, CFBamTopProjectBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByDomainIdx.get( keyDomainIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

		schema.getTableRealProject().deleteRealProject( Authorization,
			Buff );
	}

	public void deleteTopProjectByDomainIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argDomainId )
	{
		CFBamTopProjectByDomainIdxKey key = schema.getFactoryTopProject().newDomainIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredDomainId( argDomainId );
		deleteTopProjectByDomainIdx( Authorization, key );
	}

	public void deleteTopProjectByDomainIdx( CFBamAuthorization Authorization,
		CFBamTopProjectByDomainIdxKey argKey )
	{
		CFBamTopProjectBuff cur;
		LinkedList<CFBamTopProjectBuff> matchSet = new LinkedList<CFBamTopProjectBuff>();
		Iterator<CFBamTopProjectBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTopProjectBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTopProject( Authorization, cur );
		}
	}

	public void deleteTopProjectByNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argDomainId,
		String argName )
	{
		CFBamTopProjectByNameIdxKey key = schema.getFactoryTopProject().newNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredDomainId( argDomainId );
		key.setRequiredName( argName );
		deleteTopProjectByNameIdx( Authorization, key );
	}

	public void deleteTopProjectByNameIdx( CFBamAuthorization Authorization,
		CFBamTopProjectByNameIdxKey argKey )
	{
		CFBamTopProjectBuff cur;
		LinkedList<CFBamTopProjectBuff> matchSet = new LinkedList<CFBamTopProjectBuff>();
		Iterator<CFBamTopProjectBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTopProjectBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTopProject( Authorization, cur );
		}
	}

	public void deleteTopProjectByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteTopProjectByIdIdx( Authorization, key );
	}

	public void deleteTopProjectByIdIdx( CFBamAuthorization Authorization,
		CFBamDomainBasePKey argKey )
	{
		CFBamTopProjectBuff cur;
		LinkedList<CFBamTopProjectBuff> matchSet = new LinkedList<CFBamTopProjectBuff>();
		Iterator<CFBamTopProjectBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTopProjectBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTopProject( Authorization, cur );
		}
	}

	public void deleteTopProjectByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTopProjectByTenantIdx( Authorization, key );
	}

	public void deleteTopProjectByTenantIdx( CFBamAuthorization Authorization,
		CFBamDomainBaseByTenantIdxKey argKey )
	{
		CFBamTopProjectBuff cur;
		LinkedList<CFBamTopProjectBuff> matchSet = new LinkedList<CFBamTopProjectBuff>();
		Iterator<CFBamTopProjectBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTopProjectBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteTopProject( Authorization, cur );
		}
	}

	public CFBamCursor openTopProjectCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTopProjectCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openTopProjectCursorByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		CFBamCursor cursor;
		CFBamTopProjectByDomainIdxKey key = schema.getFactoryTopProject().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );

		if( dictByDomainIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamTopProjectBuff > subdictDomainIdx
				= dictByDomainIdx.get( key );
			cursor = new CFBamRamTopProjectCursor( Authorization,
				schema,
				subdictDomainIdx.values() );
		}
		else {
			cursor = new CFBamRamTopProjectCursor( Authorization,
				schema,
				new ArrayList< CFBamTopProjectBuff >() );
		}
		return( cursor );
	}

	public void closeTopProjectCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTopProjectBuff nextTopProjectCursor( CFBamCursor Cursor ) {
		CFBamRamTopProjectCursor cursor = (CFBamRamTopProjectCursor)Cursor;
		CFBamTopProjectBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTopProjectBuff prevTopProjectCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTopProjectBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTopProjectCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTopProjectBuff firstTopProjectCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTopProjectBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTopProjectCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTopProjectBuff lastTopProjectCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTopProjectCursor" );
	}

	public CFBamTopProjectBuff nthTopProjectCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTopProjectBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTopProjectCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
