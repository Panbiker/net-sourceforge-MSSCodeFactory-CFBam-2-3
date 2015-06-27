
// Description: Java7 in-memory RAM DbIO implementation for StringDef.

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
 *	CFBamRamStringDefTable in-memory RAM DbIO implementation
 *	for StringDef.
 */
public class CFBamRamStringDefTable
	implements ICFBamStringDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamStringDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamStringDefBuff >();

	public CFBamRamStringDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createStringDef( CFBamAuthorization Authorization,
		CFBamStringDefBuff Buff )
	{
		final String S_ProcName = "createStringDef";
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

	public CFBamStringDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamStringDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamStringDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamStringDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamStringDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamStringDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamStringDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamStringDef.readAllDerived() ";
		CFBamStringDefBuff[] retList = new CFBamStringDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamStringDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamStringDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamStringDefBuff ) {
			return( (CFBamStringDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamStringDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamStringDefBuff ) ) {
					filteredList.add( (CFBamStringDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
		}
	}

	public CFBamStringDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamStringDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamStringDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamStringDef.readBuff() ";
		CFBamStringDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "STRD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamStringDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamStringDef.readBuff() ";
		CFBamStringDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "STRD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamStringDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamStringDef.readAllBuff() ";
		CFBamStringDefBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamStringDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "STRD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamStringDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamStringDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamStringDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamStringDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	public CFBamStringDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamStringDefBuff> filteredList = new ArrayList<CFBamStringDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamStringDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamStringDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamStringDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamStringDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateStringDef( CFBamAuthorization Authorization,
		CFBamStringDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamStringDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateStringDef",
				"Existing record not found",
				"StringDef",
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
						"updateStringDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamStringDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteStringDef( CFBamAuthorization Authorization,
		CFBamStringDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamStringDefTable.deleteStringDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamStringDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteStringDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableStringCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteStringDef",
				"Superclass",
				"SuperClass",
				"StringCol",
				pkey );
		}

		if( schema.getTableStringType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteStringDef",
				"Superclass",
				"SuperClass",
				"StringType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamStringDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteStringDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteStringDefByIdIdx( Authorization, key );
	}

	public void deleteStringDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteStringDefByIdIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteStringDefByUNameIdx( Authorization, key );
	}

	public void deleteStringDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByUNameIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteStringDefByValTentIdx( Authorization, key );
	}

	public void deleteStringDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByValTentIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteStringDefByScopeIdx( Authorization, key );
	}

	public void deleteStringDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByScopeIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteStringDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteStringDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByDefSchemaIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteStringDefByDataScopeIdx( Authorization, key );
	}

	public void deleteStringDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByDataScopeIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteStringDefByVAccSecIdx( Authorization, key );
	}

	public void deleteStringDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByVAccSecIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteStringDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteStringDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByVAccFreqIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteStringDefByEAccSecIdx( Authorization, key );
	}

	public void deleteStringDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByEAccSecIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteStringDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteStringDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByEAccFreqIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteStringDefByPrevIdx( Authorization, key );
	}

	public void deleteStringDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByPrevIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteStringDefByNextIdx( Authorization, key );
	}

	public void deleteStringDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByNextIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteStringDefByContPrevIdx( Authorization, key );
	}

	public void deleteStringDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByContPrevIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteStringDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteStringDefByContNextIdx( Authorization, key );
	}

	public void deleteStringDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteStringDefByContNextIdx";
		CFBamStringDefBuff cur;
		LinkedList<CFBamStringDefBuff> matchSet = new LinkedList<CFBamStringDefBuff>();
		Iterator<CFBamStringDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamStringDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of StringDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openStringDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamStringDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeStringDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamStringDefBuff nextStringDefCursor( CFBamCursor Cursor ) {
		CFBamRamStringDefCursor cursor = (CFBamRamStringDefCursor)Cursor;
		CFBamStringDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamStringDefBuff prevStringDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamStringDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextStringDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamStringDefBuff firstStringDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamStringDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextStringDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamStringDefBuff lastStringDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastStringDefCursor" );
	}

	public CFBamStringDefBuff nthStringDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamStringDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextStringDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
