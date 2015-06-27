
// Description: Java7 in-memory RAM DbIO implementation for DateDef.

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
 *	CFBamRamDateDefTable in-memory RAM DbIO implementation
 *	for DateDef.
 */
public class CFBamRamDateDefTable
	implements ICFBamDateDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamDateDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamDateDefBuff >();

	public CFBamRamDateDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDateDef( CFBamAuthorization Authorization,
		CFBamDateDefBuff Buff )
	{
		final String S_ProcName = "createDateDef";
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

	public CFBamDateDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDateDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDateDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDateDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDateDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDateDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDateDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDateDef.readAllDerived() ";
		CFBamDateDefBuff[] retList = new CFBamDateDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamDateDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDateDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamDateDefBuff ) {
			return( (CFBamDateDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDateDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateDefBuff ) ) {
					filteredList.add( (CFBamDateDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
		}
	}

	public CFBamDateDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamDateDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDateDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDateDef.readBuff() ";
		CFBamDateDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DATD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDateDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDateDef.readBuff() ";
		CFBamDateDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DATD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDateDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDateDef.readAllBuff() ";
		CFBamDateDefBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamDateDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DATD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamDateDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDateDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamDateDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDateDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	public CFBamDateDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateDefBuff> filteredList = new ArrayList<CFBamDateDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamDateDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamDateDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateDateDef( CFBamAuthorization Authorization,
		CFBamDateDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDateDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDateDef",
				"Existing record not found",
				"DateDef",
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
						"updateDateDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamDateDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteDateDef( CFBamAuthorization Authorization,
		CFBamDateDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamDateDefTable.deleteDateDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDateDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDateDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableDateCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDateDef",
				"Superclass",
				"SuperClass",
				"DateCol",
				pkey );
		}

		if( schema.getTableDateType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteDateDef",
				"Superclass",
				"SuperClass",
				"DateType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamDateDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteDateDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteDateDefByIdIdx( Authorization, key );
	}

	public void deleteDateDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteDateDefByIdIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteDateDefByUNameIdx( Authorization, key );
	}

	public void deleteDateDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByUNameIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDateDefByValTentIdx( Authorization, key );
	}

	public void deleteDateDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByValTentIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteDateDefByScopeIdx( Authorization, key );
	}

	public void deleteDateDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByScopeIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDateDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteDateDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByDefSchemaIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteDateDefByDataScopeIdx( Authorization, key );
	}

	public void deleteDateDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByDataScopeIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteDateDefByVAccSecIdx( Authorization, key );
	}

	public void deleteDateDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByVAccSecIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteDateDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteDateDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByVAccFreqIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteDateDefByEAccSecIdx( Authorization, key );
	}

	public void deleteDateDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByEAccSecIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteDateDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteDateDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByEAccFreqIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteDateDefByPrevIdx( Authorization, key );
	}

	public void deleteDateDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByPrevIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteDateDefByNextIdx( Authorization, key );
	}

	public void deleteDateDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByNextIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteDateDefByContPrevIdx( Authorization, key );
	}

	public void deleteDateDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByContPrevIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteDateDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteDateDefByContNextIdx( Authorization, key );
	}

	public void deleteDateDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteDateDefByContNextIdx";
		CFBamDateDefBuff cur;
		LinkedList<CFBamDateDefBuff> matchSet = new LinkedList<CFBamDateDefBuff>();
		Iterator<CFBamDateDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "DATD".equals( subClassCode ) ) {
				schema.getTableDateDef().deleteDateDef( Authorization, cur );
			}
			else if( "DATC".equals( subClassCode ) ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (CFBamDateColBuff)cur );
			}
			else if( "DATT".equals( subClassCode ) ) {
				schema.getTableDateType().deleteDateType( Authorization, (CFBamDateTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of DateDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openDateDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDateDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeDateDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDateDefBuff nextDateDefCursor( CFBamCursor Cursor ) {
		CFBamRamDateDefCursor cursor = (CFBamRamDateDefCursor)Cursor;
		CFBamDateDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDateDefBuff prevDateDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDateDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDateDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDateDefBuff firstDateDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDateDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDateDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDateDefBuff lastDateDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDateDefCursor" );
	}

	public CFBamDateDefBuff nthDateDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDateDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDateDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
