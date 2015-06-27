
// Description: Java7 in-memory RAM DbIO implementation for NmTokenDef.

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
 *	CFBamRamNmTokenDefTable in-memory RAM DbIO implementation
 *	for NmTokenDef.
 */
public class CFBamRamNmTokenDefTable
	implements ICFBamNmTokenDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamNmTokenDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamNmTokenDefBuff >();

	public CFBamRamNmTokenDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createNmTokenDef( CFBamAuthorization Authorization,
		CFBamNmTokenDefBuff Buff )
	{
		final String S_ProcName = "createNmTokenDef";
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

	public CFBamNmTokenDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokenDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamNmTokenDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokenDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokenDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamNmTokenDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokenDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamNmTokenDef.readAllDerived() ";
		CFBamNmTokenDefBuff[] retList = new CFBamNmTokenDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamNmTokenDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamNmTokenDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamNmTokenDefBuff ) {
			return( (CFBamNmTokenDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNmTokenDefBuff ) ) {
					filteredList.add( (CFBamNmTokenDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
		}
	}

	public CFBamNmTokenDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamNmTokenDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokenDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokenDef.readBuff() ";
		CFBamNmTokenDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "NTKD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokenDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNmTokenDef.readBuff() ";
		CFBamNmTokenDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "NTKD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamNmTokenDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamNmTokenDef.readAllBuff() ";
		CFBamNmTokenDefBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamNmTokenDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "NTKD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamNmTokenDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNmTokenDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamNmTokenDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNmTokenDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	public CFBamNmTokenDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNmTokenDefBuff> filteredList = new ArrayList<CFBamNmTokenDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNmTokenDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNmTokenDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamNmTokenDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamNmTokenDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateNmTokenDef( CFBamAuthorization Authorization,
		CFBamNmTokenDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamNmTokenDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateNmTokenDef",
				"Existing record not found",
				"NmTokenDef",
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
						"updateNmTokenDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamNmTokenDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteNmTokenDef( CFBamAuthorization Authorization,
		CFBamNmTokenDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamNmTokenDefTable.deleteNmTokenDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamNmTokenDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteNmTokenDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableNmTokenCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteNmTokenDef",
				"Superclass",
				"SuperClass",
				"NmTokenCol",
				pkey );
		}

		if( schema.getTableNmTokenType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteNmTokenDef",
				"Superclass",
				"SuperClass",
				"NmTokenType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamNmTokenDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteNmTokenDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteNmTokenDefByIdIdx( Authorization, key );
	}

	public void deleteNmTokenDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByIdIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteNmTokenDefByUNameIdx( Authorization, key );
	}

	public void deleteNmTokenDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByUNameIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteNmTokenDefByValTentIdx( Authorization, key );
	}

	public void deleteNmTokenDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByValTentIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteNmTokenDefByScopeIdx( Authorization, key );
	}

	public void deleteNmTokenDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByScopeIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteNmTokenDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteNmTokenDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByDefSchemaIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteNmTokenDefByDataScopeIdx( Authorization, key );
	}

	public void deleteNmTokenDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByDataScopeIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteNmTokenDefByVAccSecIdx( Authorization, key );
	}

	public void deleteNmTokenDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByVAccSecIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteNmTokenDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteNmTokenDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByVAccFreqIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteNmTokenDefByEAccSecIdx( Authorization, key );
	}

	public void deleteNmTokenDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByEAccSecIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteNmTokenDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteNmTokenDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByEAccFreqIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteNmTokenDefByPrevIdx( Authorization, key );
	}

	public void deleteNmTokenDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByPrevIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteNmTokenDefByNextIdx( Authorization, key );
	}

	public void deleteNmTokenDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByNextIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteNmTokenDefByContPrevIdx( Authorization, key );
	}

	public void deleteNmTokenDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByContPrevIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNmTokenDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteNmTokenDefByContNextIdx( Authorization, key );
	}

	public void deleteNmTokenDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteNmTokenDefByContNextIdx";
		CFBamNmTokenDefBuff cur;
		LinkedList<CFBamNmTokenDefBuff> matchSet = new LinkedList<CFBamNmTokenDefBuff>();
		Iterator<CFBamNmTokenDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNmTokenDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NmTokenDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openNmTokenDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamNmTokenDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeNmTokenDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamNmTokenDefBuff nextNmTokenDefCursor( CFBamCursor Cursor ) {
		CFBamRamNmTokenDefCursor cursor = (CFBamRamNmTokenDefCursor)Cursor;
		CFBamNmTokenDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamNmTokenDefBuff prevNmTokenDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamNmTokenDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextNmTokenDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamNmTokenDefBuff firstNmTokenDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamNmTokenDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextNmTokenDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamNmTokenDefBuff lastNmTokenDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastNmTokenDefCursor" );
	}

	public CFBamNmTokenDefBuff nthNmTokenDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamNmTokenDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextNmTokenDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
