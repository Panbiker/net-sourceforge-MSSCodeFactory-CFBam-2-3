
// Description: Java7 in-memory RAM DbIO implementation for Atom.

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
 *	CFBamRamAtomTable in-memory RAM DbIO implementation
 *	for Atom.
 */
public class CFBamRamAtomTable
	implements ICFBamAtomTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamAtomBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamAtomBuff >();

	public CFBamRamAtomTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createAtom( CFBamAuthorization Authorization,
		CFBamAtomBuff Buff )
	{
		final String S_ProcName = "createAtom";
		schema.getTableValue().createValue( Authorization,
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
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"Value",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

	}

	public CFBamAtomBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamAtom.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamAtomBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAtomBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamAtom.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamAtomBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAtomBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamAtom.readAllDerived() ";
		CFBamAtomBuff[] retList = new CFBamAtomBuff[ dictByPKey.values().size() ];
		Iterator< CFBamAtomBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamAtomBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamAtomBuff ) {
			return( (CFBamAtomBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamAtomBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamAtomBuff ) ) {
					filteredList.add( (CFBamAtomBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamAtomBuff[0] ) );
		}
	}

	public CFBamAtomBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamAtomBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamAtomBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamAtom.readBuff() ";
		CFBamAtomBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ATOM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamAtomBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamAtom.readBuff() ";
		CFBamAtomBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ATOM" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamAtomBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamAtom.readAllBuff() ";
		CFBamAtomBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamAtomBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ATOM" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamAtomBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamAtomBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamAtomBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamAtomBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	public CFBamAtomBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamAtomBuff> filteredList = new ArrayList<CFBamAtomBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamAtomBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamAtomBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamAtomBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamAtomBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateAtom( CFBamAuthorization Authorization,
		CFBamAtomBuff Buff )
	{
		schema.getTableValue().updateValue( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamAtomBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateAtom",
				"Existing record not found",
				"Atom",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateAtom",
						"Superclass",
						"SuperClass",
						"Value",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamAtomBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteAtom( CFBamAuthorization Authorization,
		CFBamAtomBuff Buff )
	{
		final String S_ProcName = "CFBamRamAtomTable.deleteAtom() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamAtomBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteAtom",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableBlobDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"BlobDef",
				pkey );
		}

		if( schema.getTableBoolDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"BoolDef",
				pkey );
		}

		if( schema.getTableInt16Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"Int16Def",
				pkey );
		}

		if( schema.getTableInt32Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"Int32Def",
				pkey );
		}

		if( schema.getTableInt64Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"Int64Def",
				pkey );
		}

		if( schema.getTableUInt16Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"UInt16Def",
				pkey );
		}

		if( schema.getTableUInt32Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"UInt32Def",
				pkey );
		}

		if( schema.getTableUInt64Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"UInt64Def",
				pkey );
		}

		if( schema.getTableFloatDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"FloatDef",
				pkey );
		}

		if( schema.getTableDoubleDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"DoubleDef",
				pkey );
		}

		if( schema.getTableNumberDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"NumberDef",
				pkey );
		}

		if( schema.getTableStringDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"StringDef",
				pkey );
		}

		if( schema.getTableTextDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"TextDef",
				pkey );
		}

		if( schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"NmTokenDef",
				pkey );
		}

		if( schema.getTableNmTokensDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"NmTokensDef",
				pkey );
		}

		if( schema.getTableTokenDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"TokenDef",
				pkey );
		}

		if( schema.getTableDateDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"DateDef",
				pkey );
		}

		if( schema.getTableTimeDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"TimeDef",
				pkey );
		}

		if( schema.getTableTimestampDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"TimestampDef",
				pkey );
		}

		if( schema.getTableTZDateDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"TZDateDef",
				pkey );
		}

		if( schema.getTableTZTimeDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"TZTimeDef",
				pkey );
		}

		if( schema.getTableTZTimestampDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"TZTimestampDef",
				pkey );
		}

		if( schema.getTableUuidDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"SuperClass",
				"UuidDef",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamAtomBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableValue().deleteValue( Authorization,
			Buff );
	}

	public void deleteAtomByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteAtomByIdIdx( Authorization, key );
	}

	public void deleteAtomByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteAtomByIdIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteAtomByUNameIdx( Authorization, key );
	}

	public void deleteAtomByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByUNameIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteAtomByValTentIdx( Authorization, key );
	}

	public void deleteAtomByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByValTentIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteAtomByScopeIdx( Authorization, key );
	}

	public void deleteAtomByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByScopeIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteAtomByDefSchemaIdx( Authorization, key );
	}

	public void deleteAtomByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByDefSchemaIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteAtomByDataScopeIdx( Authorization, key );
	}

	public void deleteAtomByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByDataScopeIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteAtomByVAccSecIdx( Authorization, key );
	}

	public void deleteAtomByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByVAccSecIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteAtomByVAccFreqIdx( Authorization, key );
	}

	public void deleteAtomByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByVAccFreqIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteAtomByEAccSecIdx( Authorization, key );
	}

	public void deleteAtomByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByEAccSecIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteAtomByEAccFreqIdx( Authorization, key );
	}

	public void deleteAtomByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByEAccFreqIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteAtomByPrevIdx( Authorization, key );
	}

	public void deleteAtomByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByPrevIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteAtomByNextIdx( Authorization, key );
	}

	public void deleteAtomByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByNextIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteAtomByContPrevIdx( Authorization, key );
	}

	public void deleteAtomByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByContPrevIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteAtomByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteAtomByContNextIdx( Authorization, key );
	}

	public void deleteAtomByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByContNextIdx";
		CFBamAtomBuff cur;
		LinkedList<CFBamAtomBuff> matchSet = new LinkedList<CFBamAtomBuff>();
		Iterator<CFBamAtomBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamAtomBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ATOM".equals( subClassCode ) ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (CFBamBlobDefBuff)cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else if( "BOLD".equals( subClassCode ) ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (CFBamBoolDefBuff)cur );
			}
			else if( "BOLC".equals( subClassCode ) ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (CFBamBoolColBuff)cur );
			}
			else if( "BOLT".equals( subClassCode ) ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (CFBamBoolTypeBuff)cur );
			}
			else if( "I16D".equals( subClassCode ) ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (CFBamInt16DefBuff)cur );
			}
			else if( "I16C".equals( subClassCode ) ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (CFBamInt16ColBuff)cur );
			}
			else if( "I16T".equals( subClassCode ) ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (CFBamInt16TypeBuff)cur );
			}
			else if( "IG16".equals( subClassCode ) ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (CFBamId16GenBuff)cur );
			}
			else if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (CFBamEnumDefBuff)cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else if( "I32D".equals( subClassCode ) ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (CFBamInt32DefBuff)cur );
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
			else if( "I64D".equals( subClassCode ) ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (CFBamInt64DefBuff)cur );
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
			else if( "U16D".equals( subClassCode ) ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (CFBamUInt16DefBuff)cur );
			}
			else if( "U16C".equals( subClassCode ) ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (CFBamUInt16ColBuff)cur );
			}
			else if( "U16T".equals( subClassCode ) ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (CFBamUInt16TypeBuff)cur );
			}
			else if( "U32D".equals( subClassCode ) ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (CFBamUInt32DefBuff)cur );
			}
			else if( "U32C".equals( subClassCode ) ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (CFBamUInt32ColBuff)cur );
			}
			else if( "U32T".equals( subClassCode ) ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (CFBamUInt32TypeBuff)cur );
			}
			else if( "U64D".equals( subClassCode ) ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (CFBamUInt64DefBuff)cur );
			}
			else if( "U64C".equals( subClassCode ) ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (CFBamUInt64ColBuff)cur );
			}
			else if( "U64T".equals( subClassCode ) ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (CFBamUInt64TypeBuff)cur );
			}
			else if( "FLTD".equals( subClassCode ) ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (CFBamFloatDefBuff)cur );
			}
			else if( "FLTC".equals( subClassCode ) ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (CFBamFloatColBuff)cur );
			}
			else if( "FLTT".equals( subClassCode ) ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (CFBamFloatTypeBuff)cur );
			}
			else if( "DBLD".equals( subClassCode ) ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (CFBamDoubleDefBuff)cur );
			}
			else if( "DBLC".equals( subClassCode ) ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (CFBamDoubleColBuff)cur );
			}
			else if( "DBLT".equals( subClassCode ) ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (CFBamDoubleTypeBuff)cur );
			}
			else if( "NUMD".equals( subClassCode ) ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (CFBamNumberDefBuff)cur );
			}
			else if( "NUMC".equals( subClassCode ) ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (CFBamNumberColBuff)cur );
			}
			else if( "NUMT".equals( subClassCode ) ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (CFBamNumberTypeBuff)cur );
			}
			else if( "STRD".equals( subClassCode ) ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (CFBamStringDefBuff)cur );
			}
			else if( "STRC".equals( subClassCode ) ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (CFBamStringColBuff)cur );
			}
			else if( "STRT".equals( subClassCode ) ) {
				schema.getTableStringType().deleteStringType( Authorization, (CFBamStringTypeBuff)cur );
			}
			else if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (CFBamTextDefBuff)cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else if( "NTKD".equals( subClassCode ) ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (CFBamNmTokenDefBuff)cur );
			}
			else if( "NTKC".equals( subClassCode ) ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (CFBamNmTokenColBuff)cur );
			}
			else if( "NTKT".equals( subClassCode ) ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (CFBamNmTokenTypeBuff)cur );
			}
			else if( "NTSD".equals( subClassCode ) ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (CFBamNmTokensDefBuff)cur );
			}
			else if( "NTSC".equals( subClassCode ) ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (CFBamNmTokensColBuff)cur );
			}
			else if( "NTST".equals( subClassCode ) ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (CFBamNmTokensTypeBuff)cur );
			}
			else if( "TKND".equals( subClassCode ) ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (CFBamTokenDefBuff)cur );
			}
			else if( "TKNC".equals( subClassCode ) ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (CFBamTokenColBuff)cur );
			}
			else if( "TKNT".equals( subClassCode ) ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (CFBamTokenTypeBuff)cur );
			}
			else if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (CFBamDateDefBuff)cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else if( "TIMD".equals( subClassCode ) ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (CFBamTimeDefBuff)cur );
			}
			else if( "TIMC".equals( subClassCode ) ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (CFBamTimeColBuff)cur );
			}
			else if( "TIMT".equals( subClassCode ) ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (CFBamTimeTypeBuff)cur );
			}
			else if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (CFBamTimestampDefBuff)cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else if( "DAZD".equals( subClassCode ) ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (CFBamTZDateDefBuff)cur );
			}
			else if( "DAZC".equals( subClassCode ) ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (CFBamTZDateColBuff)cur );
			}
			else if( "DAZT".equals( subClassCode ) ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (CFBamTZDateTypeBuff)cur );
			}
			else if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (CFBamTZTimeDefBuff)cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else if( "UIDD".equals( subClassCode ) ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (CFBamUuidDefBuff)cur );
			}
			else if( "UIDC".equals( subClassCode ) ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (CFBamUuidColBuff)cur );
			}
			else if( "UIDT".equals( subClassCode ) ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (CFBamUuidTypeBuff)cur );
			}
			else if( "IGUU".equals( subClassCode ) ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (CFBamUuidGenBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of Atom must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openAtomCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamAtomCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeAtomCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamAtomBuff nextAtomCursor( CFBamCursor Cursor ) {
		CFBamRamAtomCursor cursor = (CFBamRamAtomCursor)Cursor;
		CFBamAtomBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamAtomBuff prevAtomCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamAtomBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAtomCursor( Cursor );
		}
		return( rec );
	}

	public CFBamAtomBuff firstAtomCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamAtomBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAtomCursor( Cursor );
		}
		return( rec );
	}

	public CFBamAtomBuff lastAtomCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastAtomCursor" );
	}

	public CFBamAtomBuff nthAtomCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamAtomBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextAtomCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
