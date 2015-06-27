
// Description: Java7 in-memory RAM DbIO implementation for DomainBase.

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
 *	CFBamRamDomainBaseTable in-memory RAM DbIO implementation
 *	for DomainBase.
 */
public class CFBamRamDomainBaseTable
	implements ICFBamDomainBaseTable
{
	private CFBamRamSchema schema;
	private Map< CFBamDomainBasePKey,
				CFBamDomainBaseBuff > dictByPKey
		= new HashMap< CFBamDomainBasePKey,
				CFBamDomainBaseBuff >();
	private Map< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamDomainBaseBuff >> dictByTenantIdx
		= new HashMap< CFBamDomainBaseByTenantIdxKey,
				Map< CFBamDomainBasePKey,
					CFBamDomainBaseBuff >>();

	public CFBamRamDomainBaseTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDomainBase( CFBamAuthorization Authorization,
		CFBamDomainBaseBuff Buff )
	{
		final String S_ProcName = "createDomainBase";
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( ((CFBamRamTenantTable)schema.getTableTenant()).nextDomainIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamDomainBaseByTenantIdxKey keyTenantIdx = schema.getFactoryDomainBase().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
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

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamDomainBasePKey, CFBamDomainBaseBuff > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< CFBamDomainBasePKey, CFBamDomainBaseBuff >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

	}

	public CFBamDomainBaseBuff readDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDomainBaseBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBaseBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDomainBaseBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBaseBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDomainBase.readAllDerived() ";
		CFBamDomainBaseBuff[] retList = new CFBamDomainBaseBuff[ dictByPKey.values().size() ];
		Iterator< CFBamDomainBaseBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDomainBaseBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByTenantIdx() ";
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamDomainBaseBuff[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamDomainBaseBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new CFBamDomainBaseBuff[ subdictTenantIdx.size() ];
			Iterator< CFBamDomainBaseBuff > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamDomainBasePKey, CFBamDomainBaseBuff > subdictTenantIdx
				= new HashMap< CFBamDomainBasePKey, CFBamDomainBaseBuff >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new CFBamDomainBaseBuff[0];
		}
		return( recArray );
	}

	public CFBamDomainBaseBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByIdIdx() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamDomainBaseBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBaseBuff readBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuff() ";
		CFBamDomainBaseBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "BDOM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBaseBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuff() ";
		CFBamDomainBaseBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "BDOM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDomainBaseBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDomainBase.readAllBuff() ";
		CFBamDomainBaseBuff buff;
		ArrayList<CFBamDomainBaseBuff> filteredList = new ArrayList<CFBamDomainBaseBuff>();
		CFBamDomainBaseBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDomainBaseBuff[0] ) );
	}

	public CFBamDomainBaseBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByIdIdx() ";
		CFBamDomainBaseBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
			return( (CFBamDomainBaseBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDomainBaseBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByTenantIdx() ";
		CFBamDomainBaseBuff buff;
		ArrayList<CFBamDomainBaseBuff> filteredList = new ArrayList<CFBamDomainBaseBuff>();
		CFBamDomainBaseBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
				filteredList.add( (CFBamDomainBaseBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDomainBaseBuff[0] ) );
	}

	public void updateDomainBase( CFBamAuthorization Authorization,
		CFBamDomainBaseBuff Buff )
	{
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDomainBaseBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDomainBase",
				"Existing record not found",
				"DomainBase",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateDomainBase",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamDomainBaseByTenantIdxKey existingKeyTenantIdx = schema.getFactoryDomainBase().newTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamDomainBaseByTenantIdxKey newKeyTenantIdx = schema.getFactoryDomainBase().newTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDomainBase",
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamDomainBasePKey, CFBamDomainBaseBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTenantIdx.get( existingKeyTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTenantIdx.containsKey( newKeyTenantIdx ) ) {
			subdict = dictByTenantIdx.get( newKeyTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamDomainBasePKey, CFBamDomainBaseBuff >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteDomainBase( CFBamAuthorization Authorization,
		CFBamDomainBaseBuff Buff )
	{
		final String S_ProcName = "CFBamRamDomainBaseTable.deleteDomainBase() ";
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDomainBaseBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDomainBase",
				pkey );
		}
		CFBamDomainBaseByTenantIdxKey keyTenantIdx = schema.getFactoryDomainBase().newTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );


		// Validate reverse foreign keys

		if( schema.getTableTopDomain().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDomainBase",
				"Superclass",
				"SuperClass",
				"TopDomain",
				pkey );
		}

		if( schema.getTableDomain().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDomainBase",
				"Superclass",
				"SuperClass",
				"Domain",
				pkey );
		}

		if( schema.getTableProjectBase().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDomainBase",
				"Superclass",
				"SuperClass",
				"ProjectBase",
				pkey );
		}

		// Delete is valid

		schema.getTableSchemaDef().deleteSchemaDefByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableLicense().deleteLicenseByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamDomainBasePKey, CFBamDomainBaseBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

	}

	public void deleteDomainBaseByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteDomainBaseByIdIdx( Authorization, key );
	}

	public void deleteDomainBaseByIdIdx( CFBamAuthorization Authorization,
		CFBamDomainBasePKey argKey )
	{
		final String S_ProcName = "deleteDomainBaseByIdIdx";
		CFBamDomainBaseBuff cur;
		LinkedList<CFBamDomainBaseBuff> matchSet = new LinkedList<CFBamDomainBaseBuff>();
		Iterator<CFBamDomainBaseBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDomainBaseBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BDOM".equals( subClassCode ) ) {
				schema.getTableDomainBase().deleteDomainBase( Authorization, cur );
			}
			else if( "TDOM".equals( subClassCode ) ) {
				schema.getTableTopDomain().deleteTopDomain( Authorization, (CFBamTopDomainBuff)cur );
			}
			else if( "DOMN".equals( subClassCode ) ) {
				schema.getTableDomain().deleteDomain( Authorization, (CFBamDomainBuff)cur );
			}
			else if( "BPRJ".equals( subClassCode ) ) {
				schema.getTableProjectBase().deleteProjectBase( Authorization, (CFBamProjectBaseBuff)cur );
			}
			else if( "RPRJ".equals( subClassCode ) ) {
				schema.getTableRealProject().deleteRealProject( Authorization, (CFBamRealProjectBuff)cur );
			}
			else if( "TPRJ".equals( subClassCode ) ) {
				schema.getTableTopProject().deleteTopProject( Authorization, (CFBamTopProjectBuff)cur );
			}
			else if( "SPRJ".equals( subClassCode ) ) {
				schema.getTableSubProject().deleteSubProject( Authorization, (CFBamSubProjectBuff)cur );
			}
			else if( "VERN".equals( subClassCode ) ) {
				schema.getTableVersion().deleteVersion( Authorization, (CFBamVersionBuff)cur );
			}
			else if( "MJVR".equals( subClassCode ) ) {
				schema.getTableMajorVersion().deleteMajorVersion( Authorization, (CFBamMajorVersionBuff)cur );
			}
			else if( "MNVR".equals( subClassCode ) ) {
				schema.getTableMinorVersion().deleteMinorVersion( Authorization, (CFBamMinorVersionBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DomainBase must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDomainBaseByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDomainBaseByTenantIdx( Authorization, key );
	}

	public void deleteDomainBaseByTenantIdx( CFBamAuthorization Authorization,
		CFBamDomainBaseByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteDomainBaseByTenantIdx";
		CFBamDomainBaseBuff cur;
		LinkedList<CFBamDomainBaseBuff> matchSet = new LinkedList<CFBamDomainBaseBuff>();
		Iterator<CFBamDomainBaseBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDomainBaseBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BDOM".equals( subClassCode ) ) {
				schema.getTableDomainBase().deleteDomainBase( Authorization, cur );
			}
			else if( "TDOM".equals( subClassCode ) ) {
				schema.getTableTopDomain().deleteTopDomain( Authorization, (CFBamTopDomainBuff)cur );
			}
			else if( "DOMN".equals( subClassCode ) ) {
				schema.getTableDomain().deleteDomain( Authorization, (CFBamDomainBuff)cur );
			}
			else if( "BPRJ".equals( subClassCode ) ) {
				schema.getTableProjectBase().deleteProjectBase( Authorization, (CFBamProjectBaseBuff)cur );
			}
			else if( "RPRJ".equals( subClassCode ) ) {
				schema.getTableRealProject().deleteRealProject( Authorization, (CFBamRealProjectBuff)cur );
			}
			else if( "TPRJ".equals( subClassCode ) ) {
				schema.getTableTopProject().deleteTopProject( Authorization, (CFBamTopProjectBuff)cur );
			}
			else if( "SPRJ".equals( subClassCode ) ) {
				schema.getTableSubProject().deleteSubProject( Authorization, (CFBamSubProjectBuff)cur );
			}
			else if( "VERN".equals( subClassCode ) ) {
				schema.getTableVersion().deleteVersion( Authorization, (CFBamVersionBuff)cur );
			}
			else if( "MJVR".equals( subClassCode ) ) {
				schema.getTableMajorVersion().deleteMajorVersion( Authorization, (CFBamMajorVersionBuff)cur );
			}
			else if( "MNVR".equals( subClassCode ) ) {
				schema.getTableMinorVersion().deleteMinorVersion( Authorization, (CFBamMinorVersionBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DomainBase must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openDomainBaseCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDomainBaseCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openDomainBaseCursorByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByTenantIdx.containsKey( key ) ) {
			Map< CFBamDomainBasePKey, CFBamDomainBaseBuff > subdictTenantIdx
				= dictByTenantIdx.get( key );
			cursor = new CFBamRamDomainBaseCursor( Authorization,
				schema,
				subdictTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamDomainBaseCursor( Authorization,
				schema,
				new ArrayList< CFBamDomainBaseBuff >() );
		}
		return( cursor );
	}

	public void closeDomainBaseCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDomainBaseBuff nextDomainBaseCursor( CFBamCursor Cursor ) {
		CFBamRamDomainBaseCursor cursor = (CFBamRamDomainBaseCursor)Cursor;
		CFBamDomainBaseBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDomainBaseBuff prevDomainBaseCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDomainBaseBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDomainBaseCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDomainBaseBuff firstDomainBaseCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDomainBaseBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDomainBaseCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDomainBaseBuff lastDomainBaseCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDomainBaseCursor" );
	}

	public CFBamDomainBaseBuff nthDomainBaseCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDomainBaseBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDomainBaseCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
