
// Description: Java7 in-memory RAM DbIO implementation for UuidDef.

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
 *	CFBamRamUuidDefTable in-memory RAM DbIO implementation
 *	for UuidDef.
 */
public class CFBamRamUuidDefTable
	implements ICFBamUuidDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamUuidDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamUuidDefBuff >();

	public CFBamRamUuidDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createUuidDef( CFBamAuthorization Authorization,
		CFBamUuidDefBuff Buff )
	{
		final String S_ProcName = "createUuidDef";
		schema.getTableAtom().createAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
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
				if( null == schema.getTableAtom().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

	}

	public CFBamUuidDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUuidDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamUuidDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUuidDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUuidDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamUuidDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUuidDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamUuidDef.readAllDerived() ";
		CFBamUuidDefBuff[] retList = new CFBamUuidDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamUuidDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamUuidDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByUNameIdx() ";
		CFBamValueBuff buff = schema.getTableValue().readDerivedByUNameIdx( Authorization,
			TenantId,
			ScopeId,
			Name );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof CFBamUuidDefBuff ) {
			return( (CFBamUuidDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByValTentIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByValTentIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByScopeIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByDefSchemaIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByDataScopeIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByVAccSecIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByVAccFreqIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByEAccSecIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByEAccFreqIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByPrevIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByNextIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByContPrevIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByContNextIdx() ";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUuidDefBuff ) ) {
					filteredList.add( (CFBamUuidDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
		}
	}

	public CFBamUuidDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamUuidDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUuidDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUuidDef.readBuff() ";
		CFBamUuidDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "UIDD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamUuidDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUuidDef.readBuff() ";
		CFBamUuidDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "UIDD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamUuidDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamUuidDef.readAllBuff() ";
		CFBamUuidDefBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamUuidDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "UIDD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamUuidDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUuidDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamUuidDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUuidDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	public CFBamUuidDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUuidDefBuff> filteredList = new ArrayList<CFBamUuidDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUuidDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUuidDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamUuidDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamUuidDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateUuidDef( CFBamAuthorization Authorization,
		CFBamUuidDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUuidDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateUuidDef",
				"Existing record not found",
				"UuidDef",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableAtom().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateUuidDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamUuidDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteUuidDef( CFBamAuthorization Authorization,
		CFBamUuidDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamUuidDefTable.deleteUuidDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUuidDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteUuidDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableUuidCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteUuidDef",
				"Superclass",
				"SuperClass",
				"UuidCol",
				pkey );
		}

		if( schema.getTableUuidType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteUuidDef",
				"Superclass",
				"SuperClass",
				"UuidType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamUuidDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteUuidDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteUuidDefByIdIdx( Authorization, key );
	}

	public void deleteUuidDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByIdIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteUuidDefByUNameIdx( Authorization, key );
	}

	public void deleteUuidDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByUNameIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteUuidDefByValTentIdx( Authorization, key );
	}

	public void deleteUuidDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByValTentIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteUuidDefByScopeIdx( Authorization, key );
	}

	public void deleteUuidDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByScopeIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteUuidDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteUuidDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByDefSchemaIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteUuidDefByDataScopeIdx( Authorization, key );
	}

	public void deleteUuidDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByDataScopeIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteUuidDefByVAccSecIdx( Authorization, key );
	}

	public void deleteUuidDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByVAccSecIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteUuidDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteUuidDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByVAccFreqIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteUuidDefByEAccSecIdx( Authorization, key );
	}

	public void deleteUuidDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByEAccSecIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteUuidDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteUuidDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByEAccFreqIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteUuidDefByPrevIdx( Authorization, key );
	}

	public void deleteUuidDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByPrevIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteUuidDefByNextIdx( Authorization, key );
	}

	public void deleteUuidDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByNextIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteUuidDefByContPrevIdx( Authorization, key );
	}

	public void deleteUuidDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByContPrevIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUuidDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteUuidDefByContNextIdx( Authorization, key );
	}

	public void deleteUuidDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUuidDefByContNextIdx";
		CFBamUuidDefBuff cur;
		LinkedList<CFBamUuidDefBuff> matchSet = new LinkedList<CFBamUuidDefBuff>();
		Iterator<CFBamUuidDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUuidDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, cur );
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
					"Instance of or subclass of UuidDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openUuidDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamUuidDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeUuidDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamUuidDefBuff nextUuidDefCursor( CFBamCursor Cursor ) {
		CFBamRamUuidDefCursor cursor = (CFBamRamUuidDefCursor)Cursor;
		CFBamUuidDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamUuidDefBuff prevUuidDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamUuidDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUuidDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamUuidDefBuff firstUuidDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamUuidDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUuidDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamUuidDefBuff lastUuidDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastUuidDefCursor" );
	}

	public CFBamUuidDefBuff nthUuidDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamUuidDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUuidDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
