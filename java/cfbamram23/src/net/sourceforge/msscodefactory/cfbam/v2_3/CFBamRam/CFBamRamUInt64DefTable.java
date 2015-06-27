
// Description: Java7 in-memory RAM DbIO implementation for UInt64Def.

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
 *	CFBamRamUInt64DefTable in-memory RAM DbIO implementation
 *	for UInt64Def.
 */
public class CFBamRamUInt64DefTable
	implements ICFBamUInt64DefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamUInt64DefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamUInt64DefBuff >();

	public CFBamRamUInt64DefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createUInt64Def( CFBamAuthorization Authorization,
		CFBamUInt64DefBuff Buff )
	{
		final String S_ProcName = "createUInt64Def";
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

	public CFBamUInt64DefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt64Def.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamUInt64DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt64DefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt64Def.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamUInt64DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt64DefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamUInt64Def.readAllDerived() ";
		CFBamUInt64DefBuff[] retList = new CFBamUInt64DefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamUInt64DefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamUInt64DefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamUInt64DefBuff ) {
			return( (CFBamUInt64DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64DefBuff ) ) {
					filteredList.add( (CFBamUInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
		}
	}

	public CFBamUInt64DefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamUInt64DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt64DefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt64Def.readBuff() ";
		CFBamUInt64DefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "U64D" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt64DefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt64Def.readBuff() ";
		CFBamUInt64DefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "U64D" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt64DefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamUInt64Def.readAllBuff() ";
		CFBamUInt64DefBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamUInt64DefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "U64D" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamUInt64DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt64DefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamUInt64DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt64DefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	public CFBamUInt64DefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt64DefBuff> filteredList = new ArrayList<CFBamUInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64DefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamUInt64DefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamUInt64DefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateUInt64Def( CFBamAuthorization Authorization,
		CFBamUInt64DefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUInt64DefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateUInt64Def",
				"Existing record not found",
				"UInt64Def",
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
						"updateUInt64Def",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamUInt64DefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteUInt64Def( CFBamAuthorization Authorization,
		CFBamUInt64DefBuff Buff )
	{
		final String S_ProcName = "CFBamRamUInt64DefTable.deleteUInt64Def() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUInt64DefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteUInt64Def",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteUInt64Def",
				"Superclass",
				"SuperClass",
				"UInt64Col",
				pkey );
		}

		if( schema.getTableUInt64Type().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteUInt64Def",
				"Superclass",
				"SuperClass",
				"UInt64Type",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamUInt64DefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteUInt64DefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteUInt64DefByIdIdx( Authorization, key );
	}

	public void deleteUInt64DefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByIdIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteUInt64DefByUNameIdx( Authorization, key );
	}

	public void deleteUInt64DefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByUNameIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteUInt64DefByValTentIdx( Authorization, key );
	}

	public void deleteUInt64DefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByValTentIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteUInt64DefByScopeIdx( Authorization, key );
	}

	public void deleteUInt64DefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByScopeIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteUInt64DefByDefSchemaIdx( Authorization, key );
	}

	public void deleteUInt64DefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByDefSchemaIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteUInt64DefByDataScopeIdx( Authorization, key );
	}

	public void deleteUInt64DefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByDataScopeIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteUInt64DefByVAccSecIdx( Authorization, key );
	}

	public void deleteUInt64DefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByVAccSecIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteUInt64DefByVAccFreqIdx( Authorization, key );
	}

	public void deleteUInt64DefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByVAccFreqIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteUInt64DefByEAccSecIdx( Authorization, key );
	}

	public void deleteUInt64DefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByEAccSecIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteUInt64DefByEAccFreqIdx( Authorization, key );
	}

	public void deleteUInt64DefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByEAccFreqIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteUInt64DefByPrevIdx( Authorization, key );
	}

	public void deleteUInt64DefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByPrevIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteUInt64DefByNextIdx( Authorization, key );
	}

	public void deleteUInt64DefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByNextIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteUInt64DefByContPrevIdx( Authorization, key );
	}

	public void deleteUInt64DefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByContPrevIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt64DefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteUInt64DefByContNextIdx( Authorization, key );
	}

	public void deleteUInt64DefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt64DefByContNextIdx";
		CFBamUInt64DefBuff cur;
		LinkedList<CFBamUInt64DefBuff> matchSet = new LinkedList<CFBamUInt64DefBuff>();
		Iterator<CFBamUInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openUInt64DefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamUInt64DefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeUInt64DefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamUInt64DefBuff nextUInt64DefCursor( CFBamCursor Cursor ) {
		CFBamRamUInt64DefCursor cursor = (CFBamRamUInt64DefCursor)Cursor;
		CFBamUInt64DefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamUInt64DefBuff prevUInt64DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamUInt64DefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUInt64DefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamUInt64DefBuff firstUInt64DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamUInt64DefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUInt64DefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamUInt64DefBuff lastUInt64DefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastUInt64DefCursor" );
	}

	public CFBamUInt64DefBuff nthUInt64DefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamUInt64DefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUInt64DefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
