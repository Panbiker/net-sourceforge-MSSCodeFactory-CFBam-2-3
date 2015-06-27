
// Description: Java7 in-memory RAM DbIO implementation for TZTimestampDef.

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
 *	CFBamRamTZTimestampDefTable in-memory RAM DbIO implementation
 *	for TZTimestampDef.
 */
public class CFBamRamTZTimestampDefTable
	implements ICFBamTZTimestampDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamTZTimestampDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamTZTimestampDefBuff >();

	public CFBamRamTZTimestampDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTZTimestampDef( CFBamAuthorization Authorization,
		CFBamTZTimestampDefBuff Buff )
	{
		final String S_ProcName = "createTZTimestampDef";
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

	public CFBamTZTimestampDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTZTimestampDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTZTimestampDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTZTimestampDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTZTimestampDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTZTimestampDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTZTimestampDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTZTimestampDef.readAllDerived() ";
		CFBamTZTimestampDefBuff[] retList = new CFBamTZTimestampDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTZTimestampDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTZTimestampDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamTZTimestampDefBuff ) {
			return( (CFBamTZTimestampDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimestampDefBuff ) ) {
					filteredList.add( (CFBamTZTimestampDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
		}
	}

	public CFBamTZTimestampDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamTZTimestampDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTZTimestampDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTZTimestampDef.readBuff() ";
		CFBamTZTimestampDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ZSTD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTZTimestampDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTZTimestampDef.readBuff() ";
		CFBamTZTimestampDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "ZSTD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTZTimestampDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTZTimestampDef.readAllBuff() ";
		CFBamTZTimestampDefBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamTZTimestampDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "ZSTD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamTZTimestampDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTZTimestampDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamTZTimestampDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTZTimestampDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	public CFBamTZTimestampDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimestampDefBuff> filteredList = new ArrayList<CFBamTZTimestampDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimestampDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimestampDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamTZTimestampDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamTZTimestampDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateTZTimestampDef( CFBamAuthorization Authorization,
		CFBamTZTimestampDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTZTimestampDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTZTimestampDef",
				"Existing record not found",
				"TZTimestampDef",
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
						"updateTZTimestampDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamTZTimestampDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteTZTimestampDef( CFBamAuthorization Authorization,
		CFBamTZTimestampDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamTZTimestampDefTable.deleteTZTimestampDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTZTimestampDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTZTimestampDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableTZTimestampCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTZTimestampDef",
				"Superclass",
				"SuperClass",
				"TZTimestampCol",
				pkey );
		}

		if( schema.getTableTZTimestampType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTZTimestampDef",
				"Superclass",
				"SuperClass",
				"TZTimestampType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamTZTimestampDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteTZTimestampDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteTZTimestampDefByIdIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByIdIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteTZTimestampDefByUNameIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByUNameIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTZTimestampDefByValTentIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByValTentIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteTZTimestampDefByScopeIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByScopeIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteTZTimestampDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByDefSchemaIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteTZTimestampDefByDataScopeIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByDataScopeIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteTZTimestampDefByVAccSecIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByVAccSecIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteTZTimestampDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByVAccFreqIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteTZTimestampDefByEAccSecIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByEAccSecIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteTZTimestampDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByEAccFreqIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteTZTimestampDefByPrevIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByPrevIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteTZTimestampDefByNextIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByNextIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteTZTimestampDefByContPrevIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByContPrevIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimestampDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteTZTimestampDefByContNextIdx( Authorization, key );
	}

	public void deleteTZTimestampDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimestampDefByContNextIdx";
		CFBamTZTimestampDefBuff cur;
		LinkedList<CFBamTZTimestampDefBuff> matchSet = new LinkedList<CFBamTZTimestampDefBuff>();
		Iterator<CFBamTZTimestampDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimestampDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "ZSTD".equals( subClassCode ) ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, cur );
			}
			else if( "ZSTC".equals( subClassCode ) ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)cur );
			}
			else if( "ZSTT".equals( subClassCode ) ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimestampDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openTZTimestampDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTZTimestampDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeTZTimestampDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTZTimestampDefBuff nextTZTimestampDefCursor( CFBamCursor Cursor ) {
		CFBamRamTZTimestampDefCursor cursor = (CFBamRamTZTimestampDefCursor)Cursor;
		CFBamTZTimestampDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTZTimestampDefBuff prevTZTimestampDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTZTimestampDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTZTimestampDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTZTimestampDefBuff firstTZTimestampDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTZTimestampDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTZTimestampDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTZTimestampDefBuff lastTZTimestampDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTZTimestampDefCursor" );
	}

	public CFBamTZTimestampDefBuff nthTZTimestampDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTZTimestampDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTZTimestampDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
