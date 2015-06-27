
// Description: Java7 in-memory RAM DbIO implementation for Int32Def.

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
 *	CFBamRamInt32DefTable in-memory RAM DbIO implementation
 *	for Int32Def.
 */
public class CFBamRamInt32DefTable
	implements ICFBamInt32DefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamInt32DefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamInt32DefBuff >();

	public CFBamRamInt32DefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createInt32Def( CFBamAuthorization Authorization,
		CFBamInt32DefBuff Buff )
	{
		final String S_ProcName = "createInt32Def";
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

	public CFBamInt32DefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamInt32Def.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamInt32DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamInt32DefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamInt32Def.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamInt32DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamInt32DefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamInt32Def.readAllDerived() ";
		CFBamInt32DefBuff[] retList = new CFBamInt32DefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamInt32DefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamInt32DefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamInt32DefBuff ) {
			return( (CFBamInt32DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamInt32DefBuff ) ) {
					filteredList.add( (CFBamInt32DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
		}
	}

	public CFBamInt32DefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamInt32DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamInt32DefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamInt32Def.readBuff() ";
		CFBamInt32DefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "I32D" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamInt32DefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamInt32Def.readBuff() ";
		CFBamInt32DefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "I32D" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamInt32DefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamInt32Def.readAllBuff() ";
		CFBamInt32DefBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamInt32DefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "I32D" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamInt32DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamInt32DefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamInt32DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamInt32DefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	public CFBamInt32DefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamInt32DefBuff> filteredList = new ArrayList<CFBamInt32DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamInt32DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamInt32DefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamInt32DefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamInt32DefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateInt32Def( CFBamAuthorization Authorization,
		CFBamInt32DefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamInt32DefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateInt32Def",
				"Existing record not found",
				"Int32Def",
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
						"updateInt32Def",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamInt32DefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteInt32Def( CFBamAuthorization Authorization,
		CFBamInt32DefBuff Buff )
	{
		final String S_ProcName = "CFBamRamInt32DefTable.deleteInt32Def() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamInt32DefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteInt32Def",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableInt32Col().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteInt32Def",
				"Superclass",
				"SuperClass",
				"Int32Col",
				pkey );
		}

		if( schema.getTableInt32Type().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteInt32Def",
				"Superclass",
				"SuperClass",
				"Int32Type",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamInt32DefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteInt32DefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteInt32DefByIdIdx( Authorization, key );
	}

	public void deleteInt32DefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByIdIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteInt32DefByUNameIdx( Authorization, key );
	}

	public void deleteInt32DefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByUNameIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteInt32DefByValTentIdx( Authorization, key );
	}

	public void deleteInt32DefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByValTentIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteInt32DefByScopeIdx( Authorization, key );
	}

	public void deleteInt32DefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByScopeIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteInt32DefByDefSchemaIdx( Authorization, key );
	}

	public void deleteInt32DefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByDefSchemaIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteInt32DefByDataScopeIdx( Authorization, key );
	}

	public void deleteInt32DefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByDataScopeIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteInt32DefByVAccSecIdx( Authorization, key );
	}

	public void deleteInt32DefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByVAccSecIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteInt32DefByVAccFreqIdx( Authorization, key );
	}

	public void deleteInt32DefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByVAccFreqIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteInt32DefByEAccSecIdx( Authorization, key );
	}

	public void deleteInt32DefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByEAccSecIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteInt32DefByEAccFreqIdx( Authorization, key );
	}

	public void deleteInt32DefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByEAccFreqIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteInt32DefByPrevIdx( Authorization, key );
	}

	public void deleteInt32DefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByPrevIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteInt32DefByNextIdx( Authorization, key );
	}

	public void deleteInt32DefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByNextIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteInt32DefByContPrevIdx( Authorization, key );
	}

	public void deleteInt32DefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByContPrevIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteInt32DefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteInt32DefByContNextIdx( Authorization, key );
	}

	public void deleteInt32DefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteInt32DefByContNextIdx";
		CFBamInt32DefBuff cur;
		LinkedList<CFBamInt32DefBuff> matchSet = new LinkedList<CFBamInt32DefBuff>();
		Iterator<CFBamInt32DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamInt32DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, cur );
			}
			else if( "I32C".equals( subClassCode ) ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (CFBamInt32ColBuff)cur );
			}
			else if( "I32T".equals( subClassCode ) ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (CFBamInt32TypeBuff)cur );
			}
			else if( "IG32".equals( subClassCode ) ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (CFBamId32GenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Int32Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openInt32DefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamInt32DefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeInt32DefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamInt32DefBuff nextInt32DefCursor( CFBamCursor Cursor ) {
		CFBamRamInt32DefCursor cursor = (CFBamRamInt32DefCursor)Cursor;
		CFBamInt32DefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamInt32DefBuff prevInt32DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamInt32DefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextInt32DefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamInt32DefBuff firstInt32DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamInt32DefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextInt32DefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamInt32DefBuff lastInt32DefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastInt32DefCursor" );
	}

	public CFBamInt32DefBuff nthInt32DefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamInt32DefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextInt32DefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
