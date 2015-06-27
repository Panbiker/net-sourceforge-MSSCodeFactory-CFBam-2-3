
// Description: Java7 in-memory RAM DbIO implementation for TokenDef.

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
 *	CFBamRamTokenDefTable in-memory RAM DbIO implementation
 *	for TokenDef.
 */
public class CFBamRamTokenDefTable
	implements ICFBamTokenDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamTokenDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamTokenDefBuff >();

	public CFBamRamTokenDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTokenDef( CFBamAuthorization Authorization,
		CFBamTokenDefBuff Buff )
	{
		final String S_ProcName = "createTokenDef";
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

	public CFBamTokenDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTokenDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTokenDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTokenDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTokenDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTokenDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTokenDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTokenDef.readAllDerived() ";
		CFBamTokenDefBuff[] retList = new CFBamTokenDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTokenDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTokenDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamTokenDefBuff ) {
			return( (CFBamTokenDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTokenDefBuff ) ) {
					filteredList.add( (CFBamTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
		}
	}

	public CFBamTokenDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamTokenDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTokenDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTokenDef.readBuff() ";
		CFBamTokenDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TKND" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTokenDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTokenDef.readBuff() ";
		CFBamTokenDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TKND" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTokenDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTokenDef.readAllBuff() ";
		CFBamTokenDefBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamTokenDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TKND" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamTokenDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTokenDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamTokenDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTokenDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	public CFBamTokenDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTokenDefBuff> filteredList = new ArrayList<CFBamTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTokenDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamTokenDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamTokenDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateTokenDef( CFBamAuthorization Authorization,
		CFBamTokenDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTokenDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTokenDef",
				"Existing record not found",
				"TokenDef",
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
						"updateTokenDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamTokenDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteTokenDef( CFBamAuthorization Authorization,
		CFBamTokenDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamTokenDefTable.deleteTokenDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTokenDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTokenDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableTokenCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTokenDef",
				"Superclass",
				"SuperClass",
				"TokenCol",
				pkey );
		}

		if( schema.getTableTokenType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTokenDef",
				"Superclass",
				"SuperClass",
				"TokenType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamTokenDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteTokenDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteTokenDefByIdIdx( Authorization, key );
	}

	public void deleteTokenDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByIdIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteTokenDefByUNameIdx( Authorization, key );
	}

	public void deleteTokenDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByUNameIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTokenDefByValTentIdx( Authorization, key );
	}

	public void deleteTokenDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByValTentIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteTokenDefByScopeIdx( Authorization, key );
	}

	public void deleteTokenDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByScopeIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteTokenDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteTokenDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByDefSchemaIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteTokenDefByDataScopeIdx( Authorization, key );
	}

	public void deleteTokenDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByDataScopeIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteTokenDefByVAccSecIdx( Authorization, key );
	}

	public void deleteTokenDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByVAccSecIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteTokenDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteTokenDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByVAccFreqIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteTokenDefByEAccSecIdx( Authorization, key );
	}

	public void deleteTokenDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByEAccSecIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteTokenDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteTokenDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByEAccFreqIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteTokenDefByPrevIdx( Authorization, key );
	}

	public void deleteTokenDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByPrevIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteTokenDefByNextIdx( Authorization, key );
	}

	public void deleteTokenDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByNextIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteTokenDefByContPrevIdx( Authorization, key );
	}

	public void deleteTokenDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByContPrevIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTokenDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteTokenDefByContNextIdx( Authorization, key );
	}

	public void deleteTokenDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteTokenDefByContNextIdx";
		CFBamTokenDefBuff cur;
		LinkedList<CFBamTokenDefBuff> matchSet = new LinkedList<CFBamTokenDefBuff>();
		Iterator<CFBamTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openTokenDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTokenDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeTokenDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTokenDefBuff nextTokenDefCursor( CFBamCursor Cursor ) {
		CFBamRamTokenDefCursor cursor = (CFBamRamTokenDefCursor)Cursor;
		CFBamTokenDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTokenDefBuff prevTokenDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTokenDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTokenDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTokenDefBuff firstTokenDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTokenDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTokenDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTokenDefBuff lastTokenDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTokenDefCursor" );
	}

	public CFBamTokenDefBuff nthTokenDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTokenDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTokenDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
