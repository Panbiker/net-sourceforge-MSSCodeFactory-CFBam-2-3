
// Description: Java7 in-memory RAM DbIO implementation for EnumDef.

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
 *	CFBamRamEnumDefTable in-memory RAM DbIO implementation
 *	for EnumDef.
 */
public class CFBamRamEnumDefTable
	implements ICFBamEnumDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamEnumDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamEnumDefBuff >();

	public CFBamRamEnumDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createEnumDef( CFBamAuthorization Authorization,
		CFBamEnumDefBuff Buff )
	{
		final String S_ProcName = "createEnumDef";
		schema.getTableInt16Def().createInt16Def( Authorization,
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
				if( null == schema.getTableInt16Def().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"Int16Def",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

	}

	public CFBamEnumDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamEnumDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamEnumDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamEnumDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamEnumDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamEnumDef.readAllDerived() ";
		CFBamEnumDefBuff[] retList = new CFBamEnumDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamEnumDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamEnumDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamEnumDefBuff ) {
			return( (CFBamEnumDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamEnumDefBuff ) ) {
					filteredList.add( (CFBamEnumDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
		}
	}

	public CFBamEnumDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamEnumDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamEnumDef.readBuff() ";
		CFBamEnumDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ENMD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamEnumDef.readBuff() ";
		CFBamEnumDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ENMD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamEnumDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamEnumDef.readAllBuff() ";
		CFBamEnumDefBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamEnumDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ENMD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamEnumDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamEnumDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamEnumDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamEnumDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	public CFBamEnumDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamEnumDefBuff> filteredList = new ArrayList<CFBamEnumDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamEnumDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamEnumDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamEnumDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamEnumDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateEnumDef( CFBamAuthorization Authorization,
		CFBamEnumDefBuff Buff )
	{
		schema.getTableInt16Def().updateInt16Def( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamEnumDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateEnumDef",
				"Existing record not found",
				"EnumDef",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableInt16Def().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateEnumDef",
						"Superclass",
						"SuperClass",
						"Int16Def",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamEnumDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteEnumDef( CFBamAuthorization Authorization,
		CFBamEnumDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamEnumDefTable.deleteEnumDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamEnumDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteEnumDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableEnumCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteEnumDef",
				"Superclass",
				"SuperClass",
				"EnumCol",
				pkey );
		}

		if( schema.getTableEnumType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteEnumDef",
				"Superclass",
				"SuperClass",
				"EnumType",
				pkey );
		}

		// Delete is valid

		schema.getTableEnumTag().deleteEnumTagByEnumIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamValuePKey, CFBamEnumDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableInt16Def().deleteInt16Def( Authorization,
			Buff );
	}

	public void deleteEnumDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteEnumDefByIdIdx( Authorization, key );
	}

	public void deleteEnumDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByIdIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteEnumDefByUNameIdx( Authorization, key );
	}

	public void deleteEnumDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByUNameIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteEnumDefByValTentIdx( Authorization, key );
	}

	public void deleteEnumDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByValTentIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteEnumDefByScopeIdx( Authorization, key );
	}

	public void deleteEnumDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByScopeIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteEnumDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteEnumDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByDefSchemaIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteEnumDefByDataScopeIdx( Authorization, key );
	}

	public void deleteEnumDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByDataScopeIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteEnumDefByVAccSecIdx( Authorization, key );
	}

	public void deleteEnumDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByVAccSecIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteEnumDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteEnumDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByVAccFreqIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteEnumDefByEAccSecIdx( Authorization, key );
	}

	public void deleteEnumDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByEAccSecIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteEnumDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteEnumDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByEAccFreqIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteEnumDefByPrevIdx( Authorization, key );
	}

	public void deleteEnumDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByPrevIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteEnumDefByNextIdx( Authorization, key );
	}

	public void deleteEnumDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByNextIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteEnumDefByContPrevIdx( Authorization, key );
	}

	public void deleteEnumDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByContPrevIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteEnumDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteEnumDefByContNextIdx( Authorization, key );
	}

	public void deleteEnumDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteEnumDefByContNextIdx";
		CFBamEnumDefBuff cur;
		LinkedList<CFBamEnumDefBuff> matchSet = new LinkedList<CFBamEnumDefBuff>();
		Iterator<CFBamEnumDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamEnumDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ENMD".equals( subClassCode ) ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, cur );
			}
			else if( "ENMC".equals( subClassCode ) ) {
				schema.getTableEnumCol().deleteEnumCol( Authorization, (CFBamEnumColBuff)cur );
			}
			else if( "ENMT".equals( subClassCode ) ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (CFBamEnumTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of EnumDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openEnumDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamEnumDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeEnumDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamEnumDefBuff nextEnumDefCursor( CFBamCursor Cursor ) {
		CFBamRamEnumDefCursor cursor = (CFBamRamEnumDefCursor)Cursor;
		CFBamEnumDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamEnumDefBuff prevEnumDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamEnumDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextEnumDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamEnumDefBuff firstEnumDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamEnumDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextEnumDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamEnumDefBuff lastEnumDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastEnumDefCursor" );
	}

	public CFBamEnumDefBuff nthEnumDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamEnumDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextEnumDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
