
// Description: Java7 in-memory RAM DbIO implementation for ProjectBase.

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
 *	CFBamRamProjectBaseTable in-memory RAM DbIO implementation
 *	for ProjectBase.
 */
public class CFBamRamProjectBaseTable
	implements ICFBamProjectBaseTable
{
	private CFBamRamSchema schema;
	private Map< CFBamDomainBasePKey,
				CFBamProjectBaseBuff > dictByPKey
		= new HashMap< CFBamDomainBasePKey,
				CFBamProjectBaseBuff >();

	public CFBamRamProjectBaseTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createProjectBase( CFBamAuthorization Authorization,
		CFBamProjectBaseBuff Buff )
	{
		final String S_ProcName = "createProjectBase";
		schema.getTableDomainBase().createDomainBase( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableDomainBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"DomainBase",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

	}

	public CFBamProjectBaseBuff readDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamProjectBase.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamProjectBaseBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamProjectBaseBuff lockDerived( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamProjectBase.readDerived() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamProjectBaseBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamProjectBaseBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamProjectBase.readAllDerived() ";
		CFBamProjectBaseBuff[] retList = new CFBamProjectBaseBuff[ dictByPKey.values().size() ];
		Iterator< CFBamProjectBaseBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamProjectBaseBuff[] readDerivedByTenantIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamProjectBaseBuff> filteredList = new ArrayList<CFBamProjectBaseBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamProjectBaseBuff ) ) {
					filteredList.add( (CFBamProjectBaseBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamProjectBaseBuff[0] ) );
		}
	}

	public CFBamProjectBaseBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readDerivedByIdIdx() ";
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamProjectBaseBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamProjectBaseBuff readBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamProjectBase.readBuff() ";
		CFBamProjectBaseBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "BPRJ" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamProjectBaseBuff lockBuff( CFBamAuthorization Authorization,
		CFBamDomainBasePKey PKey )
	{
		final String S_ProcName = "CFBamRamProjectBase.readBuff() ";
		CFBamProjectBaseBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "BPRJ" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamProjectBaseBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamProjectBase.readAllBuff() ";
		CFBamProjectBaseBuff buff;
		ArrayList<CFBamProjectBaseBuff> filteredList = new ArrayList<CFBamProjectBaseBuff>();
		CFBamProjectBaseBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BPRJ" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamProjectBaseBuff[0] ) );
	}

	public CFBamProjectBaseBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByIdIdx() ";
		CFBamDomainBaseBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
			return( (CFBamProjectBaseBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamProjectBaseBuff[] readBuffByTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamDomainBase.readBuffByTenantIdx() ";
		CFBamDomainBaseBuff buff;
		ArrayList<CFBamProjectBaseBuff> filteredList = new ArrayList<CFBamProjectBaseBuff>();
		CFBamDomainBaseBuff[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BDOM" ) ) {
				filteredList.add( (CFBamProjectBaseBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamProjectBaseBuff[0] ) );
	}

	public void updateProjectBase( CFBamAuthorization Authorization,
		CFBamProjectBaseBuff Buff )
	{
		schema.getTableDomainBase().updateDomainBase( Authorization,
			Buff );
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamProjectBaseBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateProjectBase",
				"Existing record not found",
				"ProjectBase",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDomainBase().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateProjectBase",
						"Superclass",
						"SuperClass",
						"DomainBase",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamDomainBasePKey, CFBamProjectBaseBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteProjectBase( CFBamAuthorization Authorization,
		CFBamProjectBaseBuff Buff )
	{
		final String S_ProcName = "CFBamRamProjectBaseTable.deleteProjectBase() ";
		CFBamDomainBasePKey pkey = schema.getFactoryDomainBase().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamProjectBaseBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteProjectBase",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableRealProject().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteProjectBase",
				"Superclass",
				"SuperClass",
				"RealProject",
				pkey );
		}

		if( schema.getTableVersion().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteProjectBase",
				"Superclass",
				"SuperClass",
				"Version",
				pkey );
		}

		// Delete is valid

		schema.getTableSchemaDef().deleteSchemaDefByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		schema.getTableLicense().deleteLicenseByDomainIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamDomainBasePKey, CFBamProjectBaseBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableDomainBase().deleteDomainBase( Authorization,
			Buff );
	}

	public void deleteProjectBaseByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamDomainBasePKey key = schema.getFactoryDomainBase().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteProjectBaseByIdIdx( Authorization, key );
	}

	public void deleteProjectBaseByIdIdx( CFBamAuthorization Authorization,
		CFBamDomainBasePKey argKey )
	{
		final String S_ProcName = "deleteProjectBaseByIdIdx";
		CFBamProjectBaseBuff cur;
		LinkedList<CFBamProjectBaseBuff> matchSet = new LinkedList<CFBamProjectBaseBuff>();
		Iterator<CFBamProjectBaseBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamProjectBaseBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BPRJ".equals( subClassCode ) ) {
				schema.getTableProjectBase().deleteProjectBase( Authorization, cur );
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
					"Instance of or subclass of ProjectBase must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteProjectBaseByTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamDomainBaseByTenantIdxKey key = schema.getFactoryDomainBase().newTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteProjectBaseByTenantIdx( Authorization, key );
	}

	public void deleteProjectBaseByTenantIdx( CFBamAuthorization Authorization,
		CFBamDomainBaseByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteProjectBaseByTenantIdx";
		CFBamProjectBaseBuff cur;
		LinkedList<CFBamProjectBaseBuff> matchSet = new LinkedList<CFBamProjectBaseBuff>();
		Iterator<CFBamProjectBaseBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamProjectBaseBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BPRJ".equals( subClassCode ) ) {
				schema.getTableProjectBase().deleteProjectBase( Authorization, cur );
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
					"Instance of or subclass of ProjectBase must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openProjectBaseCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamProjectBaseCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeProjectBaseCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamProjectBaseBuff nextProjectBaseCursor( CFBamCursor Cursor ) {
		CFBamRamProjectBaseCursor cursor = (CFBamRamProjectBaseCursor)Cursor;
		CFBamProjectBaseBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamProjectBaseBuff prevProjectBaseCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamProjectBaseBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextProjectBaseCursor( Cursor );
		}
		return( rec );
	}

	public CFBamProjectBaseBuff firstProjectBaseCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamProjectBaseBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextProjectBaseCursor( Cursor );
		}
		return( rec );
	}

	public CFBamProjectBaseBuff lastProjectBaseCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastProjectBaseCursor" );
	}

	public CFBamProjectBaseBuff nthProjectBaseCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamProjectBaseBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextProjectBaseCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
