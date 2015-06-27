
// Description: Java7 in-memory RAM DbIO implementation for BoolDef.

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
 *	CFBamRamBoolDefTable in-memory RAM DbIO implementation
 *	for BoolDef.
 */
public class CFBamRamBoolDefTable
	implements ICFBamBoolDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamBoolDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamBoolDefBuff >();

	public CFBamRamBoolDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createBoolDef( CFBamAuthorization Authorization,
		CFBamBoolDefBuff Buff )
	{
		final String S_ProcName = "createBoolDef";
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

	public CFBamBoolDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamBoolDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamBoolDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamBoolDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamBoolDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamBoolDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamBoolDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamBoolDef.readAllDerived() ";
		CFBamBoolDefBuff[] retList = new CFBamBoolDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamBoolDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamBoolDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamBoolDefBuff ) {
			return( (CFBamBoolDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBoolDefBuff ) ) {
					filteredList.add( (CFBamBoolDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
		}
	}

	public CFBamBoolDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamBoolDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamBoolDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamBoolDef.readBuff() ";
		CFBamBoolDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "BOLD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamBoolDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamBoolDef.readBuff() ";
		CFBamBoolDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "BOLD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamBoolDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamBoolDef.readAllBuff() ";
		CFBamBoolDefBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamBoolDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BOLD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamBoolDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamBoolDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamBoolDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamBoolDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	public CFBamBoolDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBoolDefBuff> filteredList = new ArrayList<CFBamBoolDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBoolDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBoolDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamBoolDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamBoolDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateBoolDef( CFBamAuthorization Authorization,
		CFBamBoolDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamBoolDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateBoolDef",
				"Existing record not found",
				"BoolDef",
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
						"updateBoolDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamBoolDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteBoolDef( CFBamAuthorization Authorization,
		CFBamBoolDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamBoolDefTable.deleteBoolDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamBoolDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteBoolDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableBoolCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteBoolDef",
				"Superclass",
				"SuperClass",
				"BoolCol",
				pkey );
		}

		if( schema.getTableBoolType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteBoolDef",
				"Superclass",
				"SuperClass",
				"BoolType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamBoolDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteBoolDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteBoolDefByIdIdx( Authorization, key );
	}

	public void deleteBoolDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByIdIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteBoolDefByUNameIdx( Authorization, key );
	}

	public void deleteBoolDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByUNameIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteBoolDefByValTentIdx( Authorization, key );
	}

	public void deleteBoolDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByValTentIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteBoolDefByScopeIdx( Authorization, key );
	}

	public void deleteBoolDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByScopeIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteBoolDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteBoolDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByDefSchemaIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteBoolDefByDataScopeIdx( Authorization, key );
	}

	public void deleteBoolDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByDataScopeIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteBoolDefByVAccSecIdx( Authorization, key );
	}

	public void deleteBoolDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByVAccSecIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteBoolDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteBoolDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByVAccFreqIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteBoolDefByEAccSecIdx( Authorization, key );
	}

	public void deleteBoolDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByEAccSecIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteBoolDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteBoolDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByEAccFreqIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteBoolDefByPrevIdx( Authorization, key );
	}

	public void deleteBoolDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByPrevIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteBoolDefByNextIdx( Authorization, key );
	}

	public void deleteBoolDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByNextIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteBoolDefByContPrevIdx( Authorization, key );
	}

	public void deleteBoolDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByContPrevIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBoolDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteBoolDefByContNextIdx( Authorization, key );
	}

	public void deleteBoolDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteBoolDefByContNextIdx";
		CFBamBoolDefBuff cur;
		LinkedList<CFBamBoolDefBuff> matchSet = new LinkedList<CFBamBoolDefBuff>();
		Iterator<CFBamBoolDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBoolDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BoolDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openBoolDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamBoolDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeBoolDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamBoolDefBuff nextBoolDefCursor( CFBamCursor Cursor ) {
		CFBamRamBoolDefCursor cursor = (CFBamRamBoolDefCursor)Cursor;
		CFBamBoolDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamBoolDefBuff prevBoolDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamBoolDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextBoolDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamBoolDefBuff firstBoolDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamBoolDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextBoolDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamBoolDefBuff lastBoolDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastBoolDefCursor" );
	}

	public CFBamBoolDefBuff nthBoolDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamBoolDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextBoolDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
