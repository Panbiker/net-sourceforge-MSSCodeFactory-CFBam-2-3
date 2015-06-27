
// Description: Java7 in-memory RAM DbIO implementation for NumberDef.

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
 *	CFBamRamNumberDefTable in-memory RAM DbIO implementation
 *	for NumberDef.
 */
public class CFBamRamNumberDefTable
	implements ICFBamNumberDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamNumberDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamNumberDefBuff >();

	public CFBamRamNumberDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createNumberDef( CFBamAuthorization Authorization,
		CFBamNumberDefBuff Buff )
	{
		final String S_ProcName = "createNumberDef";
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

	public CFBamNumberDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNumberDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamNumberDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNumberDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNumberDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamNumberDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNumberDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamNumberDef.readAllDerived() ";
		CFBamNumberDefBuff[] retList = new CFBamNumberDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamNumberDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamNumberDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamNumberDefBuff ) {
			return( (CFBamNumberDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamNumberDefBuff ) ) {
					filteredList.add( (CFBamNumberDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
		}
	}

	public CFBamNumberDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamNumberDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamNumberDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNumberDef.readBuff() ";
		CFBamNumberDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "NUMD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamNumberDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamNumberDef.readBuff() ";
		CFBamNumberDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "NUMD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamNumberDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamNumberDef.readAllBuff() ";
		CFBamNumberDefBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamNumberDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "NUMD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamNumberDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNumberDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamNumberDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamNumberDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	public CFBamNumberDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamNumberDefBuff> filteredList = new ArrayList<CFBamNumberDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamNumberDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamNumberDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamNumberDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamNumberDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateNumberDef( CFBamAuthorization Authorization,
		CFBamNumberDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamNumberDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateNumberDef",
				"Existing record not found",
				"NumberDef",
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
						"updateNumberDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamNumberDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteNumberDef( CFBamAuthorization Authorization,
		CFBamNumberDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamNumberDefTable.deleteNumberDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamNumberDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteNumberDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableNumberCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteNumberDef",
				"Superclass",
				"SuperClass",
				"NumberCol",
				pkey );
		}

		if( schema.getTableNumberType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteNumberDef",
				"Superclass",
				"SuperClass",
				"NumberType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamNumberDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteNumberDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteNumberDefByIdIdx( Authorization, key );
	}

	public void deleteNumberDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByIdIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteNumberDefByUNameIdx( Authorization, key );
	}

	public void deleteNumberDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByUNameIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteNumberDefByValTentIdx( Authorization, key );
	}

	public void deleteNumberDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByValTentIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteNumberDefByScopeIdx( Authorization, key );
	}

	public void deleteNumberDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByScopeIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteNumberDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteNumberDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByDefSchemaIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteNumberDefByDataScopeIdx( Authorization, key );
	}

	public void deleteNumberDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByDataScopeIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteNumberDefByVAccSecIdx( Authorization, key );
	}

	public void deleteNumberDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByVAccSecIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteNumberDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteNumberDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByVAccFreqIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteNumberDefByEAccSecIdx( Authorization, key );
	}

	public void deleteNumberDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByEAccSecIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteNumberDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteNumberDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByEAccFreqIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteNumberDefByPrevIdx( Authorization, key );
	}

	public void deleteNumberDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByPrevIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteNumberDefByNextIdx( Authorization, key );
	}

	public void deleteNumberDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByNextIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteNumberDefByContPrevIdx( Authorization, key );
	}

	public void deleteNumberDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByContPrevIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteNumberDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteNumberDefByContNextIdx( Authorization, key );
	}

	public void deleteNumberDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteNumberDefByContNextIdx";
		CFBamNumberDefBuff cur;
		LinkedList<CFBamNumberDefBuff> matchSet = new LinkedList<CFBamNumberDefBuff>();
		Iterator<CFBamNumberDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamNumberDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of NumberDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openNumberDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamNumberDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeNumberDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamNumberDefBuff nextNumberDefCursor( CFBamCursor Cursor ) {
		CFBamRamNumberDefCursor cursor = (CFBamRamNumberDefCursor)Cursor;
		CFBamNumberDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamNumberDefBuff prevNumberDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamNumberDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextNumberDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamNumberDefBuff firstNumberDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamNumberDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextNumberDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamNumberDefBuff lastNumberDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastNumberDefCursor" );
	}

	public CFBamNumberDefBuff nthNumberDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamNumberDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextNumberDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
