
// Description: Java7 in-memory RAM DbIO implementation for DoubleDef.

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
 *	CFBamRamDoubleDefTable in-memory RAM DbIO implementation
 *	for DoubleDef.
 */
public class CFBamRamDoubleDefTable
	implements ICFBamDoubleDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamDoubleDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamDoubleDefBuff >();

	public CFBamRamDoubleDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDoubleDef( CFBamAuthorization Authorization,
		CFBamDoubleDefBuff Buff )
	{
		final String S_ProcName = "createDoubleDef";
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

	public CFBamDoubleDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDoubleDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDoubleDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDoubleDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDoubleDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDoubleDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDoubleDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDoubleDef.readAllDerived() ";
		CFBamDoubleDefBuff[] retList = new CFBamDoubleDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamDoubleDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDoubleDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamDoubleDefBuff ) {
			return( (CFBamDoubleDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDoubleDefBuff ) ) {
					filteredList.add( (CFBamDoubleDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
		}
	}

	public CFBamDoubleDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamDoubleDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDoubleDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDoubleDef.readBuff() ";
		CFBamDoubleDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DBLD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDoubleDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDoubleDef.readBuff() ";
		CFBamDoubleDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DBLD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDoubleDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDoubleDef.readAllBuff() ";
		CFBamDoubleDefBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamDoubleDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DBLD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamDoubleDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDoubleDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamDoubleDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDoubleDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	public CFBamDoubleDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDoubleDefBuff> filteredList = new ArrayList<CFBamDoubleDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDoubleDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDoubleDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamDoubleDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamDoubleDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateDoubleDef( CFBamAuthorization Authorization,
		CFBamDoubleDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDoubleDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDoubleDef",
				"Existing record not found",
				"DoubleDef",
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
						"updateDoubleDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamDoubleDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteDoubleDef( CFBamAuthorization Authorization,
		CFBamDoubleDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamDoubleDefTable.deleteDoubleDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDoubleDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDoubleDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableDoubleCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDoubleDef",
				"Superclass",
				"SuperClass",
				"DoubleCol",
				pkey );
		}

		if( schema.getTableDoubleType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDoubleDef",
				"Superclass",
				"SuperClass",
				"DoubleType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamDoubleDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteDoubleDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteDoubleDefByIdIdx( Authorization, key );
	}

	public void deleteDoubleDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByIdIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteDoubleDefByUNameIdx( Authorization, key );
	}

	public void deleteDoubleDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByUNameIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDoubleDefByValTentIdx( Authorization, key );
	}

	public void deleteDoubleDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByValTentIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteDoubleDefByScopeIdx( Authorization, key );
	}

	public void deleteDoubleDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByScopeIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDoubleDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteDoubleDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByDefSchemaIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteDoubleDefByDataScopeIdx( Authorization, key );
	}

	public void deleteDoubleDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByDataScopeIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteDoubleDefByVAccSecIdx( Authorization, key );
	}

	public void deleteDoubleDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByVAccSecIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteDoubleDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteDoubleDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByVAccFreqIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteDoubleDefByEAccSecIdx( Authorization, key );
	}

	public void deleteDoubleDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByEAccSecIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteDoubleDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteDoubleDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByEAccFreqIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteDoubleDefByPrevIdx( Authorization, key );
	}

	public void deleteDoubleDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByPrevIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteDoubleDefByNextIdx( Authorization, key );
	}

	public void deleteDoubleDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByNextIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteDoubleDefByContPrevIdx( Authorization, key );
	}

	public void deleteDoubleDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByContPrevIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDoubleDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteDoubleDefByContNextIdx( Authorization, key );
	}

	public void deleteDoubleDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteDoubleDefByContNextIdx";
		CFBamDoubleDefBuff cur;
		LinkedList<CFBamDoubleDefBuff> matchSet = new LinkedList<CFBamDoubleDefBuff>();
		Iterator<CFBamDoubleDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDoubleDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DoubleDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openDoubleDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDoubleDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeDoubleDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDoubleDefBuff nextDoubleDefCursor( CFBamCursor Cursor ) {
		CFBamRamDoubleDefCursor cursor = (CFBamRamDoubleDefCursor)Cursor;
		CFBamDoubleDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDoubleDefBuff prevDoubleDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDoubleDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDoubleDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDoubleDefBuff firstDoubleDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDoubleDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDoubleDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDoubleDefBuff lastDoubleDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDoubleDefCursor" );
	}

	public CFBamDoubleDefBuff nthDoubleDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDoubleDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDoubleDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
