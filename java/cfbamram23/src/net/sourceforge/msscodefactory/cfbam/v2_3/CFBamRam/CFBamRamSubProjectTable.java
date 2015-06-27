
// Description: Java7 in-memory RAM DbIO implementation for SubProject.

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
 *	CFBamRamSubProjectTable in-memory RAM DbIO implementation
 *	for SubProject.
 */
public class CFBamRamSubProjectTable
	implements ICFBamSubProjectTable
{
	private CFBamRamSchema schema;
	private Map< CFBamDomainBasePKey,
				CFBamSubProjectBuff > dictByPKey
		= new HashMap< CFBamDomainBasePKey,
				CFBamSubProjectBuff >();
	private Map< CFBamSubProjectByParentIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamSubProjectBuff >> dictByParentIdx
		= new HashMap< CFBamSubProjectByParentIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamSubProjectBuff >>();
	private Map< CFBamSubProjectByNameIdxKey,
			CFBamSubProjectBuff > dictByNameIdx
		= new HashMap< CFBamSubProjectByNameIdxKey,
			CFBamSubProjectBuff >();

	public CFBamRamSubProjectTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createSubProject( CFBamAuthorization Authorization,
		CFBamSubProjectBuff Buff )
	{
		final String S_ProcName = "createSubProject";
		schema.getTableRealProject().createRealProject( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSubProjectByParentIdxKey keyParentIdx = schema.getFactorySubProject().newParentIdxKey();
		keyParentIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyParentIdx.setRequiredParentProjectId( Buff.getRequiredParentProjectId() );

		CFBamSubProjectByNameIdxKey keyNameIdx = schema.getFactorySubProject().newNameIdxKey();
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
				"SubProjectNameIdx",
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
				if( null == schema.getTableTopProject().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredParentProjectId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"ParentProject",
						"TopProject",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamDomainBasePKey, CFBamSubProjectBuff > subdictParentIdx;
		if( dictByParentIdx.containsKey( keyParentIdx ) ) {
			subdictParentIdx = dictByParentIdx.get( keyParentIdx );
		}
		else {
			subdictParentIdx = new HashMap< CFBamDomainBasePKey, CFBamSubProjectBuff >();
			dictByParentIdx.put( keyParentIdx, subdictParentIdx );
		}
		subdictParentIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

	}

	public CFBamSubProjectBuff readDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamSubProject.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamSubProjectBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSubProjectBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamSubProject.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamSubProjectBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSubProjectBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamSubProject.readAllDerived() ";
		CFBamSubProjectBuff[] retList = new CFBamSubProjectBuff[ dictByPKey.values().size() ];
		Iterator< CFBamSubProjectBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamSubProjectBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamSubProjectBuff> filteredList = new ArrayList<CFBamSubProjectBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamSubProjectBuff ) ) {
					filteredList.add( (CFBamSubProjectBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamSubProjectBuff[0] ) );
		}
	}

	public CFBamSubProjectBuff[] readDerivedByParentIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ParentProjectId )
	{
		final String S_ProcName = "CFBamRamSubProject.readDerivedByParentIdx() ";
		CFBamSubProjectByParentIdxKey key = schema.getFactorySubProject().newParentIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );

		CFBamSubProjectBuff[] recArray;
		if( dictByParentIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamSubProjectBuff > subdictParentIdx
				= dictByParentIdx.get( key );
			recArray = new CFBamSubProjectBuff[ subdictParentIdx.size() ];
			Iterator< CFBamSubProjectBuff > iter = subdictParentIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamDomainBasePKey, CFBamSubProjectBuff > subdictParentIdx
				= new HashMap< CFBamDomainBasePKey, CFBamSubProjectBuff >();
			dictByParentIdx.put( key, subdictParentIdx );
			recArray = new CFBamSubProjectBuff[0];
		}
		return( recArray );
	}

	public CFBamSubProjectBuff readDerivedByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ParentProjectId,
		String Name )
	{
		final String S_ProcName = "CFBamRamSubProject.readDerivedByNameIdx() ";
		CFBamSubProjectByNameIdxKey key = schema.getFactorySubProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );
		key.setRequiredName( Name );

		CFBamSubProjectBuff buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSubProjectBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByIdIdx() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamSubProjectBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamSubProjectBuff readBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamSubProject.readBuff() ";
		CFBamSubProjectBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SPRJ" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSubProjectBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamSubProject.readBuff() ";
		CFBamSubProjectBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "SPRJ" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamSubProjectBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamSubProject.readAllBuff() ";
		CFBamSubProjectBuff buff;
		ArrayList<CFBamSubProjectBuff> filteredList = new ArrayList<CFBamSubProjectBuff>();
		CFBamSubProjectBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRJ" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamSubProjectBuff[0] ) );
	}

	public CFBamSubProjectBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByIdIdx() ";
		CFBamDomainBaseBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
			return( (CFBamSubProjectBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamSubProjectBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByTenantIdx() ";
		CFBamDomainBaseBuff buff;
		ArrayList<CFBamSubProjectBuff> filteredList = new ArrayList<CFBamSubProjectBuff>();
		CFBamDomainBaseBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
				filteredList.add( (CFBamSubProjectBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSubProjectBuff[0] ) );
	}

	public CFBamSubProjectBuff[] readBuffByParentIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ParentProjectId )
	{
		final String S_ProcName = "CFBamRamSubProject.readBuffByParentIdx() ";
		CFBamSubProjectBuff buff;
		ArrayList<CFBamSubProjectBuff> filteredList = new ArrayList<CFBamSubProjectBuff>();
		CFBamSubProjectBuff[] buffList = readDerivedByParentIdx( Authorization,
			TenantId,
			ParentProjectId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "SPRJ" ) ) {
				filteredList.add( (CFBamSubProjectBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamSubProjectBuff[0] ) );
	}

	public CFBamSubProjectBuff readBuffByNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ParentProjectId,
		String Name )
	{
		final String S_ProcName = "CFBamRamSubProject.readBuffByNameIdx() ";
		CFBamSubProjectBuff buff = readDerivedByNameIdx( Authorization,
			TenantId,
			ParentProjectId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "SPRJ" ) ) {
			return( (CFBamSubProjectBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateSubProject( CFBamAuthorization Authorization,
		CFBamSubProjectBuff Buff )
	{
		schema.getTableRealProject().updateRealProject( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSubProjectBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateSubProject",
				"Existing record not found",
				"SubProject",
				pkey );
		}
		CFBamSubProjectByParentIdxKey existingKeyParentIdx = schema.getFactorySubProject().newParentIdxKey();
		existingKeyParentIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyParentIdx.setRequiredParentProjectId( existing.getRequiredParentProjectId() );

		CFBamSubProjectByParentIdxKey newKeyParentIdx = schema.getFactorySubProject().newParentIdxKey();
		newKeyParentIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyParentIdx.setRequiredParentProjectId( Buff.getRequiredParentProjectId() );

		CFBamSubProjectByNameIdxKey existingKeyNameIdx = schema.getFactorySubProject().newNameIdxKey();
		existingKeyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyNameIdx.setRequiredParentProjectId( existing.getRequiredParentProjectId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamSubProjectByNameIdxKey newKeyNameIdx = schema.getFactorySubProject().newNameIdxKey();
		newKeyNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyNameIdx.setRequiredParentProjectId( Buff.getRequiredParentProjectId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateSubProject",
					"SubProjectNameIdx",
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
						"updateSubProject",
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
				if( null == schema.getTableTopProject().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredParentProjectId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateSubProject",
						"Container",
						"ParentProject",
						"TopProject",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamDomainBasePKey, CFBamSubProjectBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByParentIdx.get( existingKeyParentIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByParentIdx.containsKey( newKeyParentIdx ) ) {
			subdict = dictByParentIdx.get( newKeyParentIdx );
		}
		else {
			subdict = new HashMap< CFBamDomainBasePKey, CFBamSubProjectBuff >();
			dictByParentIdx.put( newKeyParentIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

	}

	public void deleteSubProject( CFBamAuthorization Authorization,
		CFBamSubProjectBuff Buff )
	{
		final String S_ProcName = "CFBamRamSubProjectTable.deleteSubProject() ";
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamSubProjectBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteSubProject",
				pkey );
		}
		CFBamSubProjectByParentIdxKey keyParentIdx = schema.getFactorySubProject().newParentIdxKey();
		keyParentIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyParentIdx.setRequiredParentProjectId( existing.getRequiredParentProjectId() );

		CFBamSubProjectByNameIdxKey keyNameIdx = schema.getFactorySubProject().newNameIdxKey();
		keyNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyNameIdx.setRequiredParentProjectId( existing.getRequiredParentProjectId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableMajorVersion().deleteMajorVersionByPPrjIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableSchemaDef().deleteSchemaDefByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableLicense().deleteLicenseByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamDomainBasePKey, CFBamSubProjectBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByParentIdx.get( keyParentIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

		schema.getTableRealProject().deleteRealProject( Authorization,
			Buff );
	}

	public void deleteSubProjectByParentIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argParentProjectId )
	{
		CFBamSubProjectByParentIdxKey key = schema.getFactorySubProject().newParentIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredParentProjectId( argParentProjectId );
		deleteSubProjectByParentIdx( Authorization, key );
	}

	public void deleteSubProjectByParentIdx( CFBamAuthorization Authorization,
		CFBamSubProjectByParentIdxKey argKey )
	{
		CFBamSubProjectBuff cur;
		LinkedList<CFBamSubProjectBuff> matchSet = new LinkedList<CFBamSubProjectBuff>();
		Iterator<CFBamSubProjectBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSubProjectBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSubProject( Authorization, cur );
		}
	}

	public void deleteSubProjectByNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argParentProjectId,
		String argName )
	{
		CFBamSubProjectByNameIdxKey key = schema.getFactorySubProject().newNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredParentProjectId( argParentProjectId );
		key.setRequiredName( argName );
		deleteSubProjectByNameIdx( Authorization, key );
	}

	public void deleteSubProjectByNameIdx( CFBamAuthorization Authorization,
		CFBamSubProjectByNameIdxKey argKey )
	{
		CFBamSubProjectBuff cur;
		LinkedList<CFBamSubProjectBuff> matchSet = new LinkedList<CFBamSubProjectBuff>();
		Iterator<CFBamSubProjectBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSubProjectBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSubProject( Authorization, cur );
		}
	}

	public void deleteSubProjectByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteSubProjectByIdIdx( Authorization, key );
	}

	public void deleteSubProjectByIdIdx( CFBamAuthorization Authorization,
		CFBamDomainBasePKey argKey )
	{
		CFBamSubProjectBuff cur;
		LinkedList<CFBamSubProjectBuff> matchSet = new LinkedList<CFBamSubProjectBuff>();
		Iterator<CFBamSubProjectBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSubProjectBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSubProject( Authorization, cur );
		}
	}

	public void deleteSubProjectByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteSubProjectByTenantIdx( Authorization, key );
	}

	public void deleteSubProjectByTenantIdx( CFBamAuthorization Authorization,
		CFBamDomainBaseByTenantIdxKey argKey )
	{
		CFBamSubProjectBuff cur;
		LinkedList<CFBamSubProjectBuff> matchSet = new LinkedList<CFBamSubProjectBuff>();
		Iterator<CFBamSubProjectBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamSubProjectBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteSubProject( Authorization, cur );
		}
	}

	public CFBamCursor openSubProjectCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamSubProjectCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openSubProjectCursorByParentIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ParentProjectId )
	{
		CFBamCursor cursor;
		CFBamSubProjectByParentIdxKey key = schema.getFactorySubProject().newParentIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredParentProjectId( ParentProjectId );

		if( dictByParentIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamSubProjectBuff > subdictParentIdx
				= dictByParentIdx.get( key );
			cursor = new CFBamRamSubProjectCursor( Authorization,
				schema,
				subdictParentIdx.values() );
		}
		else {
			cursor = new CFBamRamSubProjectCursor( Authorization,
				schema,
				new ArrayList< CFBamSubProjectBuff >() );
		}
		return( cursor );
	}

	public void closeSubProjectCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamSubProjectBuff nextSubProjectCursor( CFBamCursor Cursor ) {
		CFBamRamSubProjectCursor cursor = (CFBamRamSubProjectCursor)Cursor;
		CFBamSubProjectBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamSubProjectBuff prevSubProjectCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamSubProjectBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSubProjectCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSubProjectBuff firstSubProjectCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamSubProjectBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSubProjectCursor( Cursor );
		}
		return( rec );
	}

	public CFBamSubProjectBuff lastSubProjectCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastSubProjectCursor" );
	}

	public CFBamSubProjectBuff nthSubProjectCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamSubProjectBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextSubProjectCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
