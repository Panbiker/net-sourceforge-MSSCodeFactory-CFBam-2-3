
// Description: Java7 in-memory RAM DbIO implementation for TimestampDef.

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
 *	CFBamRamTimestampDefTable in-memory RAM DbIO implementation
 *	for TimestampDef.
 */
public class CFBamRamTimestampDefTable
	implements ICFBamTimestampDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamTimestampDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamTimestampDefBuff >();

	public CFBamRamTimestampDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTimestampDef( CFBamAuthorization Authorization,
		CFBamTimestampDefBuff Buff )
	{
		final String S_ProcName = "createTimestampDef";
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

	public CFBamTimestampDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTimestampDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTimestampDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTimestampDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTimestampDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTimestampDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTimestampDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTimestampDef.readAllDerived() ";
		CFBamTimestampDefBuff[] retList = new CFBamTimestampDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTimestampDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTimestampDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamTimestampDefBuff ) {
			return( (CFBamTimestampDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTimestampDefBuff ) ) {
					filteredList.add( (CFBamTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
		}
	}

	public CFBamTimestampDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamTimestampDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTimestampDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTimestampDef.readBuff() ";
		CFBamTimestampDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TSPD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTimestampDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTimestampDef.readBuff() ";
		CFBamTimestampDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TSPD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTimestampDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTimestampDef.readAllBuff() ";
		CFBamTimestampDefBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamTimestampDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TSPD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamTimestampDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTimestampDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamTimestampDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTimestampDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	public CFBamTimestampDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTimestampDefBuff> filteredList = new ArrayList<CFBamTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTimestampDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamTimestampDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamTimestampDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateTimestampDef( CFBamAuthorization Authorization,
		CFBamTimestampDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTimestampDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTimestampDef",
				"Existing record not found",
				"TimestampDef",
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
						"updateTimestampDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamTimestampDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteTimestampDef( CFBamAuthorization Authorization,
		CFBamTimestampDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamTimestampDefTable.deleteTimestampDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTimestampDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTimestampDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableTimestampCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTimestampDef",
				"Superclass",
				"SuperClass",
				"TimestampCol",
				pkey );
		}

		if( schema.getTableTimestampType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTimestampDef",
				"Superclass",
				"SuperClass",
				"TimestampType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamTimestampDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteTimestampDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteTimestampDefByIdIdx( Authorization, key );
	}

	public void deleteTimestampDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByIdIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteTimestampDefByUNameIdx( Authorization, key );
	}

	public void deleteTimestampDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByUNameIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTimestampDefByValTentIdx( Authorization, key );
	}

	public void deleteTimestampDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByValTentIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteTimestampDefByScopeIdx( Authorization, key );
	}

	public void deleteTimestampDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByScopeIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteTimestampDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteTimestampDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByDefSchemaIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteTimestampDefByDataScopeIdx( Authorization, key );
	}

	public void deleteTimestampDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByDataScopeIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteTimestampDefByVAccSecIdx( Authorization, key );
	}

	public void deleteTimestampDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByVAccSecIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteTimestampDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteTimestampDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByVAccFreqIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteTimestampDefByEAccSecIdx( Authorization, key );
	}

	public void deleteTimestampDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByEAccSecIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteTimestampDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteTimestampDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByEAccFreqIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteTimestampDefByPrevIdx( Authorization, key );
	}

	public void deleteTimestampDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByPrevIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteTimestampDefByNextIdx( Authorization, key );
	}

	public void deleteTimestampDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByNextIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteTimestampDefByContPrevIdx( Authorization, key );
	}

	public void deleteTimestampDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByContPrevIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTimestampDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteTimestampDefByContNextIdx( Authorization, key );
	}

	public void deleteTimestampDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteTimestampDefByContNextIdx";
		CFBamTimestampDefBuff cur;
		LinkedList<CFBamTimestampDefBuff> matchSet = new LinkedList<CFBamTimestampDefBuff>();
		Iterator<CFBamTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TSPD".equals( subClassCode ) ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, cur );
			}
			else if( "TSPC".equals( subClassCode ) ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (CFBamTimestampColBuff)cur );
			}
			else if( "TSPT".equals( subClassCode ) ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (CFBamTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openTimestampDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTimestampDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeTimestampDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTimestampDefBuff nextTimestampDefCursor( CFBamCursor Cursor ) {
		CFBamRamTimestampDefCursor cursor = (CFBamRamTimestampDefCursor)Cursor;
		CFBamTimestampDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTimestampDefBuff prevTimestampDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTimestampDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTimestampDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTimestampDefBuff firstTimestampDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTimestampDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTimestampDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTimestampDefBuff lastTimestampDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTimestampDefCursor" );
	}

	public CFBamTimestampDefBuff nthTimestampDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTimestampDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTimestampDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
