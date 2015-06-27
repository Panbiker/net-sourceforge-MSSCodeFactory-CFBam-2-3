
// Description: Java7 in-memory RAM DbIO implementation for NmTokensDef.

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
 *	CFBamRamNmTokensDefTable in-memory RAM DbIO implementation
 *	for NmTokensDef.
 */
public class CFBamRamNmTokensDefTable
	implements ICFBamNmTokensDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamNmTokensDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamNmTokensDefBuff >();

	public CFBamRamNmTokensDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createNmTokensDef( CFBamAuthorization Authorization,
		CFBamNmTokensDefBuff Buff )
	{
		final String S_ProcName = "createNmTokensDef";
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

	public CFBamNmTokensDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokensDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamNmTokensDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokensDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokensDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamNmTokensDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokensDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamNmTokensDef.readAllDerived() ";
		CFBamNmTokensDefBuff[] retList = new CFBamNmTokensDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamNmTokensDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamNmTokensDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamNmTokensDefBuff ) {
			return( (CFBamNmTokensDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokensDefBuff ) ) {
					filteredList.add( (CFBamNmTokensDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
		}
	}

	public CFBamNmTokensDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamNmTokensDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokensDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokensDef.readBuff() ";
		CFBamNmTokensDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "NTSD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokensDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokensDef.readBuff() ";
		CFBamNmTokensDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "NTSD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokensDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamNmTokensDef.readAllBuff() ";
		CFBamNmTokensDefBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamNmTokensDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "NTSD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamNmTokensDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNmTokensDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamNmTokensDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNmTokensDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	public CFBamNmTokensDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokensDefBuff> filteredList = new ArrayList<CFBamNmTokensDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokensDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokensDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamNmTokensDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamNmTokensDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateNmTokensDef( CFBamAuthorization Authorization,
		CFBamNmTokensDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamNmTokensDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateNmTokensDef",
				"Existing record not found",
				"NmTokensDef",
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
						"updateNmTokensDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamNmTokensDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteNmTokensDef( CFBamAuthorization Authorization,
		CFBamNmTokensDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamNmTokensDefTable.deleteNmTokensDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamNmTokensDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteNmTokensDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableNmTokensCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteNmTokensDef",
				"Superclass",
				"SuperClass",
				"NmTokensCol",
				pkey );
		}

		if( schema.getTableNmTokensType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteNmTokensDef",
				"Superclass",
				"SuperClass",
				"NmTokensType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamNmTokensDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteNmTokensDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteNmTokensDefByIdIdx( Authorization, key );
	}

	public void deleteNmTokensDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByIdIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteNmTokensDefByUNameIdx( Authorization, key );
	}

	public void deleteNmTokensDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByUNameIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteNmTokensDefByValTentIdx( Authorization, key );
	}

	public void deleteNmTokensDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByValTentIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteNmTokensDefByScopeIdx( Authorization, key );
	}

	public void deleteNmTokensDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByScopeIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteNmTokensDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteNmTokensDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByDefSchemaIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteNmTokensDefByDataScopeIdx( Authorization, key );
	}

	public void deleteNmTokensDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByDataScopeIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteNmTokensDefByVAccSecIdx( Authorization, key );
	}

	public void deleteNmTokensDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByVAccSecIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteNmTokensDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteNmTokensDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByVAccFreqIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteNmTokensDefByEAccSecIdx( Authorization, key );
	}

	public void deleteNmTokensDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByEAccSecIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteNmTokensDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteNmTokensDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByEAccFreqIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteNmTokensDefByPrevIdx( Authorization, key );
	}

	public void deleteNmTokensDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByPrevIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteNmTokensDefByNextIdx( Authorization, key );
	}

	public void deleteNmTokensDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByNextIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteNmTokensDefByContPrevIdx( Authorization, key );
	}

	public void deleteNmTokensDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByContPrevIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokensDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteNmTokensDefByContNextIdx( Authorization, key );
	}

	public void deleteNmTokensDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokensDefByContNextIdx";
		CFBamNmTokensDefBuff cur;
		LinkedList<CFBamNmTokensDefBuff> matchSet = new LinkedList<CFBamNmTokensDefBuff>();
		Iterator<CFBamNmTokensDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokensDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokensDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openNmTokensDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamNmTokensDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeNmTokensDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamNmTokensDefBuff nextNmTokensDefCursor( CFBamCursor Cursor ) {
		CFBamRamNmTokensDefCursor cursor = (CFBamRamNmTokensDefCursor)Cursor;
		CFBamNmTokensDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamNmTokensDefBuff prevNmTokensDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamNmTokensDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextNmTokensDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamNmTokensDefBuff firstNmTokensDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamNmTokensDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextNmTokensDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamNmTokensDefBuff lastNmTokensDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastNmTokensDefCursor" );
	}

	public CFBamNmTokensDefBuff nthNmTokensDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamNmTokensDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextNmTokensDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
