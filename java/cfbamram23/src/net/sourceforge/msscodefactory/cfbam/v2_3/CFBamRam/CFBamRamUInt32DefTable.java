
// Description: Java7 in-memory RAM DbIO implementation for UInt32Def.

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
 *	CFBamRamUInt32DefTable in-memory RAM DbIO implementation
 *	for UInt32Def.
 */
public class CFBamRamUInt32DefTable
	implements ICFBamUInt32DefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamUInt32DefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamUInt32DefBuff >();

	public CFBamRamUInt32DefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createUInt32Def( CFBamAuthorization Authorization,
		CFBamUInt32DefBuff Buff )
	{
		final String S_ProcName = "createUInt32Def";
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

	public CFBamUInt32DefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt32Def.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamUInt32DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt32DefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt32Def.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamUInt32DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt32DefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamUInt32Def.readAllDerived() ";
		CFBamUInt32DefBuff[] retList = new CFBamUInt32DefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamUInt32DefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamUInt32DefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamUInt32DefBuff ) {
			return( (CFBamUInt32DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt32DefBuff ) ) {
					filteredList.add( (CFBamUInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
		}
	}

	public CFBamUInt32DefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamUInt32DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt32DefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt32Def.readBuff() ";
		CFBamUInt32DefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "U32D" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt32DefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt32Def.readBuff() ";
		CFBamUInt32DefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "U32D" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt32DefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamUInt32Def.readAllBuff() ";
		CFBamUInt32DefBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamUInt32DefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "U32D" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamUInt32DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt32DefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamUInt32DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt32DefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	public CFBamUInt32DefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt32DefBuff> filteredList = new ArrayList<CFBamUInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt32DefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamUInt32DefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamUInt32DefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateUInt32Def( CFBamAuthorization Authorization,
		CFBamUInt32DefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUInt32DefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateUInt32Def",
				"Existing record not found",
				"UInt32Def",
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
						"updateUInt32Def",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamUInt32DefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteUInt32Def( CFBamAuthorization Authorization,
		CFBamUInt32DefBuff Buff )
	{
		final String S_ProcName = "CFBamRamUInt32DefTable.deleteUInt32Def() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUInt32DefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteUInt32Def",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableUInt32Col().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteUInt32Def",
				"Superclass",
				"SuperClass",
				"UInt32Col",
				pkey );
		}

		if( schema.getTableUInt32Type().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteUInt32Def",
				"Superclass",
				"SuperClass",
				"UInt32Type",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamUInt32DefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteUInt32DefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteUInt32DefByIdIdx( Authorization, key );
	}

	public void deleteUInt32DefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByIdIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteUInt32DefByUNameIdx( Authorization, key );
	}

	public void deleteUInt32DefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByUNameIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteUInt32DefByValTentIdx( Authorization, key );
	}

	public void deleteUInt32DefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByValTentIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteUInt32DefByScopeIdx( Authorization, key );
	}

	public void deleteUInt32DefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByScopeIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteUInt32DefByDefSchemaIdx( Authorization, key );
	}

	public void deleteUInt32DefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByDefSchemaIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteUInt32DefByDataScopeIdx( Authorization, key );
	}

	public void deleteUInt32DefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByDataScopeIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteUInt32DefByVAccSecIdx( Authorization, key );
	}

	public void deleteUInt32DefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByVAccSecIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteUInt32DefByVAccFreqIdx( Authorization, key );
	}

	public void deleteUInt32DefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByVAccFreqIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteUInt32DefByEAccSecIdx( Authorization, key );
	}

	public void deleteUInt32DefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByEAccSecIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteUInt32DefByEAccFreqIdx( Authorization, key );
	}

	public void deleteUInt32DefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByEAccFreqIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteUInt32DefByPrevIdx( Authorization, key );
	}

	public void deleteUInt32DefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByPrevIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteUInt32DefByNextIdx( Authorization, key );
	}

	public void deleteUInt32DefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByNextIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteUInt32DefByContPrevIdx( Authorization, key );
	}

	public void deleteUInt32DefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByContPrevIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt32DefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteUInt32DefByContNextIdx( Authorization, key );
	}

	public void deleteUInt32DefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt32DefByContNextIdx";
		CFBamUInt32DefBuff cur;
		LinkedList<CFBamUInt32DefBuff> matchSet = new LinkedList<CFBamUInt32DefBuff>();
		Iterator<CFBamUInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openUInt32DefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamUInt32DefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeUInt32DefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamUInt32DefBuff nextUInt32DefCursor( CFBamCursor Cursor ) {
		CFBamRamUInt32DefCursor cursor = (CFBamRamUInt32DefCursor)Cursor;
		CFBamUInt32DefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamUInt32DefBuff prevUInt32DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamUInt32DefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUInt32DefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamUInt32DefBuff firstUInt32DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamUInt32DefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUInt32DefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamUInt32DefBuff lastUInt32DefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastUInt32DefCursor" );
	}

	public CFBamUInt32DefBuff nthUInt32DefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamUInt32DefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUInt32DefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
