
// Description: Java7 in-memory RAM DbIO implementation for License.

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
 *	CFBamRamLicenseTable in-memory RAM DbIO implementation
 *	for License.
 */
public class CFBamRamLicenseTable
	implements ICFBamLicenseTable
{
	private CFBamRamSchema schema;
	private Map< CFBamLicensePKey,
				CFBamLicenseBuff > dictByPKey
		= new HashMap< CFBamLicensePKey,
				CFBamLicenseBuff >();
	private Map< CFBamLicenseByLicnTenantIdxKey,
				Map< CFBamLicensePKey,
					CFBamLicenseBuff >> dictByLicnTenantIdx
		= new HashMap< CFBamLicenseByLicnTenantIdxKey,
				Map< CFBamLicensePKey,
					CFBamLicenseBuff >>();
	private Map< CFBamLicenseByDomainIdxKey,
				Map< CFBamLicensePKey,
					CFBamLicenseBuff >> dictByDomainIdx
		= new HashMap< CFBamLicenseByDomainIdxKey,
				Map< CFBamLicensePKey,
					CFBamLicenseBuff >>();
	private Map< CFBamLicenseByUNameIdxKey,
			CFBamLicenseBuff > dictByUNameIdx
		= new HashMap< CFBamLicenseByUNameIdxKey,
			CFBamLicenseBuff >();

	public CFBamRamLicenseTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createLicense( CFBamAuthorization Authorization,
		CFBamLicenseBuff Buff )
	{
		final String S_ProcName = "createLicense";
		CFBamLicensePKey pkey = schema.getFactoryLicense().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( ((CFBamRamTenantTable)schema.getTableTenant()).nextLicenseIdGen( Authorization,
			Buff.getRequiredTenantId() ) );
		Buff.setRequiredTenantId( pkey.getRequiredTenantId() );
		Buff.setRequiredId( pkey.getRequiredId() );
		CFBamLicenseByLicnTenantIdxKey keyLicnTenantIdx = schema.getFactoryLicense().newLicnTenantIdxKey();
		keyLicnTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamLicenseByDomainIdxKey keyDomainIdx = schema.getFactoryLicense().newDomainIdxKey();
		keyDomainIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyDomainIdx.setRequiredDomainId( Buff.getRequiredDomainId() );

		CFBamLicenseByUNameIdxKey keyUNameIdx = schema.getFactoryLicense().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredDomainId( Buff.getRequiredDomainId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw CFLib.getDefaultExceptionFactory().newPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
				S_ProcName,
				"LicenseUNameIdx",
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
						"Owner",
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

		Map< CFBamLicensePKey, CFBamLicenseBuff > subdictLicnTenantIdx;
		if( dictByLicnTenantIdx.containsKey( keyLicnTenantIdx ) ) {
			subdictLicnTenantIdx = dictByLicnTenantIdx.get( keyLicnTenantIdx );
		}
		else {
			subdictLicnTenantIdx = new HashMap< CFBamLicensePKey, CFBamLicenseBuff >();
			dictByLicnTenantIdx.put( keyLicnTenantIdx, subdictLicnTenantIdx );
		}
		subdictLicnTenantIdx.put( pkey, Buff );

		Map< CFBamLicensePKey, CFBamLicenseBuff > subdictDomainIdx;
		if( dictByDomainIdx.containsKey( keyDomainIdx ) ) {
			subdictDomainIdx = dictByDomainIdx.get( keyDomainIdx );
		}
		else {
			subdictDomainIdx = new HashMap< CFBamLicensePKey, CFBamLicenseBuff >();
			dictByDomainIdx.put( keyDomainIdx, subdictDomainIdx );
		}
		subdictDomainIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

	}

	public CFBamLicenseBuff readDerived( CFBamAuthorization Authorization,
		CFBamLicensePKey PKey )
	{
		final String S_ProcName = "CFBamRamLicense.readDerived() ";
		CFBamLicensePKey key = schema.getFactoryLicense().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamLicenseBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamLicenseBuff lockDerived( CFBamAuthorization Authorization,
		CFBamLicensePKey PKey )
	{
		final String S_ProcName = "CFBamRamLicense.readDerived() ";
		CFBamLicensePKey key = schema.getFactoryLicense().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamLicenseBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamLicenseBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamLicense.readAllDerived() ";
		CFBamLicenseBuff[] retList = new CFBamLicenseBuff[ dictByPKey.values().size() ];
		Iterator< CFBamLicenseBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamLicenseBuff[] readDerivedByLicnTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamLicense.readDerivedByLicnTenantIdx() ";
		CFBamLicenseByLicnTenantIdxKey key = schema.getFactoryLicense().newLicnTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		CFBamLicenseBuff[] recArray;
		if( dictByLicnTenantIdx.containsKey( key ) ) {
			Map< CFBamLicensePKey, CFBamLicenseBuff > subdictLicnTenantIdx
				= dictByLicnTenantIdx.get( key );
			recArray = new CFBamLicenseBuff[ subdictLicnTenantIdx.size() ];
			Iterator< CFBamLicenseBuff > iter = subdictLicnTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamLicensePKey, CFBamLicenseBuff > subdictLicnTenantIdx
				= new HashMap< CFBamLicensePKey, CFBamLicenseBuff >();
			dictByLicnTenantIdx.put( key, subdictLicnTenantIdx );
			recArray = new CFBamLicenseBuff[0];
		}
		return( recArray );
	}

	public CFBamLicenseBuff[] readDerivedByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		final String S_ProcName = "CFBamRamLicense.readDerivedByDomainIdx() ";
		CFBamLicenseByDomainIdxKey key = schema.getFactoryLicense().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );

		CFBamLicenseBuff[] recArray;
		if( dictByDomainIdx.containsKey( key ) ) {
			Map< CFBamLicensePKey, CFBamLicenseBuff > subdictDomainIdx
				= dictByDomainIdx.get( key );
			recArray = new CFBamLicenseBuff[ subdictDomainIdx.size() ];
			Iterator< CFBamLicenseBuff > iter = subdictDomainIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamLicensePKey, CFBamLicenseBuff > subdictDomainIdx
				= new HashMap< CFBamLicensePKey, CFBamLicenseBuff >();
			dictByDomainIdx.put( key, subdictDomainIdx );
			recArray = new CFBamLicenseBuff[0];
		}
		return( recArray );
	}

	public CFBamLicenseBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId,
		String Name )
	{
		final String S_ProcName = "CFBamRamLicense.readDerivedByUNameIdx() ";
		CFBamLicenseByUNameIdxKey key = schema.getFactoryLicense().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );
		key.setRequiredName( Name );

		CFBamLicenseBuff buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamLicenseBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamLicense.readDerivedByIdIdx() ";
		CFBamLicensePKey key = schema.getFactoryLicense().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamLicenseBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamLicenseBuff readBuff( CFBamAuthorization Authorization,
		CFBamLicensePKey PKey )
	{
		final String S_ProcName = "CFBamRamLicense.readBuff() ";
		CFBamLicenseBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "LIC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamLicenseBuff lockBuff( CFBamAuthorization Authorization,
		CFBamLicensePKey PKey )
	{
		final String S_ProcName = "CFBamRamLicense.readBuff() ";
		CFBamLicenseBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "LIC" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamLicenseBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamLicense.readAllBuff() ";
		CFBamLicenseBuff buff;
		ArrayList<CFBamLicenseBuff> filteredList = new ArrayList<CFBamLicenseBuff>();
		CFBamLicenseBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "LIC" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamLicenseBuff[0] ) );
	}

	public CFBamLicenseBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamLicense.readBuffByIdIdx() ";
		CFBamLicenseBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "LIC" ) ) {
			return( (CFBamLicenseBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamLicenseBuff[] readBuffByLicnTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamLicense.readBuffByLicnTenantIdx() ";
		CFBamLicenseBuff buff;
		ArrayList<CFBamLicenseBuff> filteredList = new ArrayList<CFBamLicenseBuff>();
		CFBamLicenseBuff[] buffList = readDerivedByLicnTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "LIC" ) ) {
				filteredList.add( (CFBamLicenseBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamLicenseBuff[0] ) );
	}

	public CFBamLicenseBuff[] readBuffByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		final String S_ProcName = "CFBamRamLicense.readBuffByDomainIdx() ";
		CFBamLicenseBuff buff;
		ArrayList<CFBamLicenseBuff> filteredList = new ArrayList<CFBamLicenseBuff>();
		CFBamLicenseBuff[] buffList = readDerivedByDomainIdx( Authorization,
			TenantId,
			DomainId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "LIC" ) ) {
				filteredList.add( (CFBamLicenseBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamLicenseBuff[0] ) );
	}

	public CFBamLicenseBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId,
		String Name )
	{
		final String S_ProcName = "CFBamRamLicense.readBuffByUNameIdx() ";
		CFBamLicenseBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			DomainId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "LIC" ) ) {
			return( (CFBamLicenseBuff)buff );
		}
		else {
			return( null );
		}
	}

	public void updateLicense( CFBamAuthorization Authorization,
		CFBamLicenseBuff Buff )
	{
		CFBamLicensePKey pkey = schema.getFactoryLicense().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamLicenseBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateLicense",
				"Existing record not found",
				"License",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"updateLicense",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		CFBamLicenseByLicnTenantIdxKey existingKeyLicnTenantIdx = schema.getFactoryLicense().newLicnTenantIdxKey();
		existingKeyLicnTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamLicenseByLicnTenantIdxKey newKeyLicnTenantIdx = schema.getFactoryLicense().newLicnTenantIdxKey();
		newKeyLicnTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		CFBamLicenseByDomainIdxKey existingKeyDomainIdx = schema.getFactoryLicense().newDomainIdxKey();
		existingKeyDomainIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyDomainIdx.setRequiredDomainId( existing.getRequiredDomainId() );

		CFBamLicenseByDomainIdxKey newKeyDomainIdx = schema.getFactoryLicense().newDomainIdxKey();
		newKeyDomainIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyDomainIdx.setRequiredDomainId( Buff.getRequiredDomainId() );

		CFBamLicenseByUNameIdxKey existingKeyUNameIdx = schema.getFactoryLicense().newUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredDomainId( existing.getRequiredDomainId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		CFBamLicenseByUNameIdxKey newKeyUNameIdx = schema.getFactoryLicense().newUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredDomainId( Buff.getRequiredDomainId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw CFLib.getDefaultExceptionFactory().newUniqueIndexViolationException( getClass(),
					"updateLicense",
					"LicenseUNameIdx",
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
						"updateLicense",
						"Owner",
						"Owner",
						"Tenant",
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
						"updateLicense",
						"Container",
						"Domain",
						"DomainBase",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamLicensePKey, CFBamLicenseBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByLicnTenantIdx.get( existingKeyLicnTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLicnTenantIdx.containsKey( newKeyLicnTenantIdx ) ) {
			subdict = dictByLicnTenantIdx.get( newKeyLicnTenantIdx );
		}
		else {
			subdict = new HashMap< CFBamLicensePKey, CFBamLicenseBuff >();
			dictByLicnTenantIdx.put( newKeyLicnTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDomainIdx.get( existingKeyDomainIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDomainIdx.containsKey( newKeyDomainIdx ) ) {
			subdict = dictByDomainIdx.get( newKeyDomainIdx );
		}
		else {
			subdict = new HashMap< CFBamLicensePKey, CFBamLicenseBuff >();
			dictByDomainIdx.put( newKeyDomainIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

	}

	public void deleteLicense( CFBamAuthorization Authorization,
		CFBamLicenseBuff Buff )
	{
		final String S_ProcName = "CFBamRamLicenseTable.deleteLicense() ";
		CFBamLicensePKey pkey = schema.getFactoryLicense().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamLicenseBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteLicense",
				pkey );
		}
		CFBamLicenseByLicnTenantIdxKey keyLicnTenantIdx = schema.getFactoryLicense().newLicnTenantIdxKey();
		keyLicnTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		CFBamLicenseByDomainIdxKey keyDomainIdx = schema.getFactoryLicense().newDomainIdxKey();
		keyDomainIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyDomainIdx.setRequiredDomainId( existing.getRequiredDomainId() );

		CFBamLicenseByUNameIdxKey keyUNameIdx = schema.getFactoryLicense().newUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredDomainId( existing.getRequiredDomainId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		// Validate reverse foreign keys

		// Delete is valid

		Map< CFBamLicensePKey, CFBamLicenseBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByLicnTenantIdx.get( keyLicnTenantIdx );
		subdict.remove( pkey );

		subdict = dictByDomainIdx.get( keyDomainIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}

	public void deleteLicenseByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamLicensePKey key = schema.getFactoryLicense().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteLicenseByIdIdx( Authorization, key );
	}

	public void deleteLicenseByIdIdx( CFBamAuthorization Authorization,
		CFBamLicensePKey argKey )
	{
		CFBamLicenseBuff cur;
		LinkedList<CFBamLicenseBuff> matchSet = new LinkedList<CFBamLicenseBuff>();
		Iterator<CFBamLicenseBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamLicenseBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteLicense( Authorization, cur );
		}
	}

	public void deleteLicenseByLicnTenantIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamLicenseByLicnTenantIdxKey key = schema.getFactoryLicense().newLicnTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteLicenseByLicnTenantIdx( Authorization, key );
	}

	public void deleteLicenseByLicnTenantIdx( CFBamAuthorization Authorization,
		CFBamLicenseByLicnTenantIdxKey argKey )
	{
		CFBamLicenseBuff cur;
		LinkedList<CFBamLicenseBuff> matchSet = new LinkedList<CFBamLicenseBuff>();
		Iterator<CFBamLicenseBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamLicenseBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteLicense( Authorization, cur );
		}
	}

	public void deleteLicenseByDomainIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argDomainId )
	{
		CFBamLicenseByDomainIdxKey key = schema.getFactoryLicense().newDomainIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredDomainId( argDomainId );
		deleteLicenseByDomainIdx( Authorization, key );
	}

	public void deleteLicenseByDomainIdx( CFBamAuthorization Authorization,
		CFBamLicenseByDomainIdxKey argKey )
	{
		CFBamLicenseBuff cur;
		LinkedList<CFBamLicenseBuff> matchSet = new LinkedList<CFBamLicenseBuff>();
		Iterator<CFBamLicenseBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamLicenseBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteLicense( Authorization, cur );
		}
	}

	public void deleteLicenseByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argDomainId,
		String argName )
	{
		CFBamLicenseByUNameIdxKey key = schema.getFactoryLicense().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredDomainId( argDomainId );
		key.setRequiredName( argName );
		deleteLicenseByUNameIdx( Authorization, key );
	}

	public void deleteLicenseByUNameIdx( CFBamAuthorization Authorization,
		CFBamLicenseByUNameIdxKey argKey )
	{
		CFBamLicenseBuff cur;
		LinkedList<CFBamLicenseBuff> matchSet = new LinkedList<CFBamLicenseBuff>();
		Iterator<CFBamLicenseBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamLicenseBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteLicense( Authorization, cur );
		}
	}

	public CFBamCursor openLicenseCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamLicenseCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openLicenseCursorByLicnTenantIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		CFBamCursor cursor;
		CFBamLicenseByLicnTenantIdxKey key = schema.getFactoryLicense().newLicnTenantIdxKey();
		key.setRequiredTenantId( TenantId );

		if( dictByLicnTenantIdx.containsKey( key ) ) {
			Map< CFBamLicensePKey, CFBamLicenseBuff > subdictLicnTenantIdx
				= dictByLicnTenantIdx.get( key );
			cursor = new CFBamRamLicenseCursor( Authorization,
				schema,
				subdictLicnTenantIdx.values() );
		}
		else {
			cursor = new CFBamRamLicenseCursor( Authorization,
				schema,
				new ArrayList< CFBamLicenseBuff >() );
		}
		return( cursor );
	}

	public CFBamCursor openLicenseCursorByDomainIdx( CFBamAuthorization Authorization,
		long TenantId,
		long DomainId )
	{
		CFBamCursor cursor;
		CFBamLicenseByDomainIdxKey key = schema.getFactoryLicense().newDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredDomainId( DomainId );

		if( dictByDomainIdx.containsKey( key ) ) {
			Map< CFBamLicensePKey, CFBamLicenseBuff > subdictDomainIdx
				= dictByDomainIdx.get( key );
			cursor = new CFBamRamLicenseCursor( Authorization,
				schema,
				subdictDomainIdx.values() );
		}
		else {
			cursor = new CFBamRamLicenseCursor( Authorization,
				schema,
				new ArrayList< CFBamLicenseBuff >() );
		}
		return( cursor );
	}

	public void closeLicenseCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamLicenseBuff nextLicenseCursor( CFBamCursor Cursor ) {
		CFBamRamLicenseCursor cursor = (CFBamRamLicenseCursor)Cursor;
		CFBamLicenseBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamLicenseBuff prevLicenseCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamLicenseBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextLicenseCursor( Cursor );
		}
		return( rec );
	}

	public CFBamLicenseBuff firstLicenseCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamLicenseBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextLicenseCursor( Cursor );
		}
		return( rec );
	}

	public CFBamLicenseBuff lastLicenseCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastLicenseCursor" );
	}

	public CFBamLicenseBuff nthLicenseCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamLicenseBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextLicenseCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
