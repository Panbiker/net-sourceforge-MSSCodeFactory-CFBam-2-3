
// Description: Java7 in-memory RAM DbIO implementation for TextDef.

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
 *	CFBamRamTextDefTable in-memory RAM DbIO implementation
 *	for TextDef.
 */
public class CFBamRamTextDefTable
	implements ICFBamTextDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamTextDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamTextDefBuff >();

	public CFBamRamTextDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTextDef( CFBamAuthorization Authorization,
		CFBamTextDefBuff Buff )
	{
		final String S_ProcName = "createTextDef";
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

	public CFBamTextDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTextDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTextDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTextDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTextDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTextDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTextDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTextDef.readAllDerived() ";
		CFBamTextDefBuff[] retList = new CFBamTextDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTextDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTextDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamTextDefBuff ) {
			return( (CFBamTextDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTextDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTextDefBuff ) ) {
					filteredList.add( (CFBamTextDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
		}
	}

	public CFBamTextDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamTextDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTextDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTextDef.readBuff() ";
		CFBamTextDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TXTD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTextDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTextDef.readBuff() ";
		CFBamTextDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TXTD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTextDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTextDef.readAllBuff() ";
		CFBamTextDefBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamTextDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TXTD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamTextDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTextDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamTextDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTextDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	public CFBamTextDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTextDefBuff> filteredList = new ArrayList<CFBamTextDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTextDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTextDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamTextDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamTextDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateTextDef( CFBamAuthorization Authorization,
		CFBamTextDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTextDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTextDef",
				"Existing record not found",
				"TextDef",
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
						"updateTextDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamTextDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteTextDef( CFBamAuthorization Authorization,
		CFBamTextDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamTextDefTable.deleteTextDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTextDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTextDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableTextCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTextDef",
				"Superclass",
				"SuperClass",
				"TextCol",
				pkey );
		}

		if( schema.getTableTextType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTextDef",
				"Superclass",
				"SuperClass",
				"TextType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamTextDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteTextDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteTextDefByIdIdx( Authorization, key );
	}

	public void deleteTextDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteTextDefByIdIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteTextDefByUNameIdx( Authorization, key );
	}

	public void deleteTextDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByUNameIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTextDefByValTentIdx( Authorization, key );
	}

	public void deleteTextDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByValTentIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteTextDefByScopeIdx( Authorization, key );
	}

	public void deleteTextDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByScopeIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteTextDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteTextDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByDefSchemaIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteTextDefByDataScopeIdx( Authorization, key );
	}

	public void deleteTextDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByDataScopeIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteTextDefByVAccSecIdx( Authorization, key );
	}

	public void deleteTextDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByVAccSecIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteTextDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteTextDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByVAccFreqIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteTextDefByEAccSecIdx( Authorization, key );
	}

	public void deleteTextDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByEAccSecIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteTextDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteTextDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByEAccFreqIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteTextDefByPrevIdx( Authorization, key );
	}

	public void deleteTextDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByPrevIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteTextDefByNextIdx( Authorization, key );
	}

	public void deleteTextDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByNextIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteTextDefByContPrevIdx( Authorization, key );
	}

	public void deleteTextDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByContPrevIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTextDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteTextDefByContNextIdx( Authorization, key );
	}

	public void deleteTextDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteTextDefByContNextIdx";
		CFBamTextDefBuff cur;
		LinkedList<CFBamTextDefBuff> matchSet = new LinkedList<CFBamTextDefBuff>();
		Iterator<CFBamTextDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTextDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TXTD".equals( subClassCode ) ) {
				schema.getTableTextDef().deleteTextDef( Authorization, cur );
			}
			else if( "TXTC".equals( subClassCode ) ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (CFBamTextColBuff)cur );
			}
			else if( "TXTT".equals( subClassCode ) ) {
				schema.getTableTextType().deleteTextType( Authorization, (CFBamTextTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TextDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openTextDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTextDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeTextDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTextDefBuff nextTextDefCursor( CFBamCursor Cursor ) {
		CFBamRamTextDefCursor cursor = (CFBamRamTextDefCursor)Cursor;
		CFBamTextDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTextDefBuff prevTextDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTextDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTextDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTextDefBuff firstTextDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTextDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTextDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTextDefBuff lastTextDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTextDefCursor" );
	}

	public CFBamTextDefBuff nthTextDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTextDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTextDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
