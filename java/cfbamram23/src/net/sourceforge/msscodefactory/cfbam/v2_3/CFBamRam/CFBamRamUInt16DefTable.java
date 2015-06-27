
// Description: Java7 in-memory RAM DbIO implementation for UInt16Def.

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
 *	CFBamRamUInt16DefTable in-memory RAM DbIO implementation
 *	for UInt16Def.
 */
public class CFBamRamUInt16DefTable
	implements ICFBamUInt16DefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamUInt16DefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamUInt16DefBuff >();

	public CFBamRamUInt16DefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createUInt16Def( CFBamAuthorization Authorization,
		CFBamUInt16DefBuff Buff )
	{
		final String S_ProcName = "createUInt16Def";
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

	public CFBamUInt16DefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt16Def.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamUInt16DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt16DefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt16Def.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamUInt16DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt16DefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamUInt16Def.readAllDerived() ";
		CFBamUInt16DefBuff[] retList = new CFBamUInt16DefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamUInt16DefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamUInt16DefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamUInt16DefBuff ) {
			return( (CFBamUInt16DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt16DefBuff ) ) {
					filteredList.add( (CFBamUInt16DefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
		}
	}

	public CFBamUInt16DefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamUInt16DefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt16DefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt16Def.readBuff() ";
		CFBamUInt16DefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "U16D" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt16DefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt16Def.readBuff() ";
		CFBamUInt16DefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "U16D" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt16DefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamUInt16Def.readAllBuff() ";
		CFBamUInt16DefBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamUInt16DefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "U16D" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamUInt16DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt16DefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamUInt16DefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt16DefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	public CFBamUInt16DefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamUInt16DefBuff> filteredList = new ArrayList<CFBamUInt16DefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt16DefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt16DefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamUInt16DefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamUInt16DefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateUInt16Def( CFBamAuthorization Authorization,
		CFBamUInt16DefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUInt16DefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateUInt16Def",
				"Existing record not found",
				"UInt16Def",
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
						"updateUInt16Def",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamUInt16DefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteUInt16Def( CFBamAuthorization Authorization,
		CFBamUInt16DefBuff Buff )
	{
		final String S_ProcName = "CFBamRamUInt16DefTable.deleteUInt16Def() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUInt16DefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteUInt16Def",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableUInt16Col().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteUInt16Def",
				"Superclass",
				"SuperClass",
				"UInt16Col",
				pkey );
		}

		if( schema.getTableUInt16Type().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteUInt16Def",
				"Superclass",
				"SuperClass",
				"UInt16Type",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamUInt16DefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteUInt16DefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteUInt16DefByIdIdx( Authorization, key );
	}

	public void deleteUInt16DefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByIdIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteUInt16DefByUNameIdx( Authorization, key );
	}

	public void deleteUInt16DefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByUNameIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteUInt16DefByValTentIdx( Authorization, key );
	}

	public void deleteUInt16DefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByValTentIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteUInt16DefByScopeIdx( Authorization, key );
	}

	public void deleteUInt16DefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByScopeIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteUInt16DefByDefSchemaIdx( Authorization, key );
	}

	public void deleteUInt16DefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByDefSchemaIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteUInt16DefByDataScopeIdx( Authorization, key );
	}

	public void deleteUInt16DefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByDataScopeIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteUInt16DefByVAccSecIdx( Authorization, key );
	}

	public void deleteUInt16DefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByVAccSecIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteUInt16DefByVAccFreqIdx( Authorization, key );
	}

	public void deleteUInt16DefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByVAccFreqIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteUInt16DefByEAccSecIdx( Authorization, key );
	}

	public void deleteUInt16DefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByEAccSecIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteUInt16DefByEAccFreqIdx( Authorization, key );
	}

	public void deleteUInt16DefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByEAccFreqIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteUInt16DefByPrevIdx( Authorization, key );
	}

	public void deleteUInt16DefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByPrevIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteUInt16DefByNextIdx( Authorization, key );
	}

	public void deleteUInt16DefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByNextIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteUInt16DefByContPrevIdx( Authorization, key );
	}

	public void deleteUInt16DefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByContPrevIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteUInt16DefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteUInt16DefByContNextIdx( Authorization, key );
	}

	public void deleteUInt16DefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteUInt16DefByContNextIdx";
		CFBamUInt16DefBuff cur;
		LinkedList<CFBamUInt16DefBuff> matchSet = new LinkedList<CFBamUInt16DefBuff>();
		Iterator<CFBamUInt16DefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt16DefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of UInt16Def must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openUInt16DefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamUInt16DefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeUInt16DefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamUInt16DefBuff nextUInt16DefCursor( CFBamCursor Cursor ) {
		CFBamRamUInt16DefCursor cursor = (CFBamRamUInt16DefCursor)Cursor;
		CFBamUInt16DefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamUInt16DefBuff prevUInt16DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamUInt16DefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUInt16DefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamUInt16DefBuff firstUInt16DefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamUInt16DefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUInt16DefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamUInt16DefBuff lastUInt16DefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastUInt16DefCursor" );
	}

	public CFBamUInt16DefBuff nthUInt16DefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamUInt16DefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextUInt16DefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
