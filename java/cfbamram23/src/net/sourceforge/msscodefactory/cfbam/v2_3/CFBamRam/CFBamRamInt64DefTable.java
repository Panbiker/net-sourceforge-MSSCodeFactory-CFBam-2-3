
// Description: Java7 in-memory RAM DbIO implementation for Int64Def.

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
 *	CFBamRamInt64DefTable in-memory RAM DbIO implementation
 *	for Int64Def.
 */
public class CFBamRamInt64DefTable
	implements ICFBamInt64DefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamInt64DefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamInt64DefBuff >();

	public CFBamRamInt64DefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createInt64Def( CFBamAuthorization Authorization,
		CFBamInt64DefBuff Buff )
	{
		final String S_ProcName = "createInt64Def";
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

	public CFBamInt64DefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamInt64Def.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamInt64DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamInt64DefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamInt64Def.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamInt64DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamInt64DefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamInt64Def.readAllDerived() ";
		CFBamInt64DefBuff[] retList = new CFBamInt64DefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamInt64DefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamInt64DefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamInt64DefBuff ) {
			return( (CFBamInt64DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt64DefBuff ) ) {
					filteredList.add( (CFBamInt64DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
		}
	}

	public CFBamInt64DefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamInt64DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamInt64DefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamInt64Def.readBuff() ";
		CFBamInt64DefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "I64D" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamInt64DefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamInt64Def.readBuff() ";
		CFBamInt64DefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "I64D" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamInt64DefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamInt64Def.readAllBuff() ";
		CFBamInt64DefBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamInt64DefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "I64D" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamInt64DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamInt64DefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamInt64DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamInt64DefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	public CFBamInt64DefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt64DefBuff> filteredList = new ArrayList<CFBamInt64DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt64DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt64DefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamInt64DefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamInt64DefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateInt64Def( CFBamAuthorization Authorization,
		CFBamInt64DefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamInt64DefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateInt64Def",
				"Existing record not found",
				"Int64Def",
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
						"updateInt64Def",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamInt64DefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteInt64Def( CFBamAuthorization Authorization,
		CFBamInt64DefBuff Buff )
	{
		final String S_ProcName = "CFBamRamInt64DefTable.deleteInt64Def() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamInt64DefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteInt64Def",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableInt64Col().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteInt64Def",
				"Superclass",
				"SuperClass",
				"Int64Col",
				pkey );
		}

		if( schema.getTableInt64Type().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteInt64Def",
				"Superclass",
				"SuperClass",
				"Int64Type",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamInt64DefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteInt64DefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteInt64DefByIdIdx( Authorization, key );
	}

	public void deleteInt64DefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByIdIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteInt64DefByUNameIdx( Authorization, key );
	}

	public void deleteInt64DefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByUNameIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteInt64DefByValTentIdx( Authorization, key );
	}

	public void deleteInt64DefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByValTentIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteInt64DefByScopeIdx( Authorization, key );
	}

	public void deleteInt64DefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByScopeIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteInt64DefByDefSchemaIdx( Authorization, key );
	}

	public void deleteInt64DefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByDefSchemaIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteInt64DefByDataScopeIdx( Authorization, key );
	}

	public void deleteInt64DefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByDataScopeIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteInt64DefByVAccSecIdx( Authorization, key );
	}

	public void deleteInt64DefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByVAccSecIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteInt64DefByVAccFreqIdx( Authorization, key );
	}

	public void deleteInt64DefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByVAccFreqIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteInt64DefByEAccSecIdx( Authorization, key );
	}

	public void deleteInt64DefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByEAccSecIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteInt64DefByEAccFreqIdx( Authorization, key );
	}

	public void deleteInt64DefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByEAccFreqIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteInt64DefByPrevIdx( Authorization, key );
	}

	public void deleteInt64DefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByPrevIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteInt64DefByNextIdx( Authorization, key );
	}

	public void deleteInt64DefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByNextIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteInt64DefByContPrevIdx( Authorization, key );
	}

	public void deleteInt64DefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByContPrevIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt64DefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteInt64DefByContNextIdx( Authorization, key );
	}

	public void deleteInt64DefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteInt64DefByContNextIdx";
		CFBamInt64DefBuff cur;
		LinkedList<CFBamInt64DefBuff> matchSet = new LinkedList<CFBamInt64DefBuff>();
		Iterator<CFBamInt64DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt64DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, cur );
			}
			else if( "I64C".equals( subClassCode ) ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (CFBamInt64ColBuff)cur );
			}
			else if( "I64T".equals( subClassCode ) ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (CFBamInt64TypeBuff)cur );
			}
			else if( "IG64".equals( subClassCode ) ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (CFBamId64GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int64Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openInt64DefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamInt64DefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeInt64DefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamInt64DefBuff nextInt64DefCursor( CFBamCursor Cursor ) {
		CFBamRamInt64DefCursor cursor = (CFBamRamInt64DefCursor)Cursor;
		CFBamInt64DefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamInt64DefBuff prevInt64DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamInt64DefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextInt64DefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamInt64DefBuff firstInt64DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamInt64DefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextInt64DefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamInt64DefBuff lastInt64DefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastInt64DefCursor" );
	}

	public CFBamInt64DefBuff nthInt64DefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamInt64DefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextInt64DefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
