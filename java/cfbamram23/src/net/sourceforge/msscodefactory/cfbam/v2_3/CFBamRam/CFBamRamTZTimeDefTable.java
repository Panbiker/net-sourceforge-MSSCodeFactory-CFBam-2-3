
// Description: Java7 in-memory RAM DbIO implementation for TZTimeDef.

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
 *	CFBamRamTZTimeDefTable in-memory RAM DbIO implementation
 *	for TZTimeDef.
 */
public class CFBamRamTZTimeDefTable
	implements ICFBamTZTimeDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamTZTimeDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamTZTimeDefBuff >();

	public CFBamRamTZTimeDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createTZTimeDef( CFBamAuthorization Authorization,
		CFBamTZTimeDefBuff Buff )
	{
		final String S_ProcName = "createTZTimeDef";
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

	public CFBamTZTimeDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTZTimeDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTZTimeDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTZTimeDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTZTimeDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamTZTimeDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTZTimeDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamTZTimeDef.readAllDerived() ";
		CFBamTZTimeDefBuff[] retList = new CFBamTZTimeDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamTZTimeDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamTZTimeDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamTZTimeDefBuff ) {
			return( (CFBamTZTimeDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamTZTimeDefBuff ) ) {
					filteredList.add( (CFBamTZTimeDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
		}
	}

	public CFBamTZTimeDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamTZTimeDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamTZTimeDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTZTimeDef.readBuff() ";
		CFBamTZTimeDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TMZD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTZTimeDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamTZTimeDef.readBuff() ";
		CFBamTZTimeDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "TMZD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamTZTimeDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamTZTimeDef.readAllBuff() ";
		CFBamTZTimeDefBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamTZTimeDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "TMZD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamTZTimeDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTZTimeDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamTZTimeDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamTZTimeDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	public CFBamTZTimeDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamTZTimeDefBuff> filteredList = new ArrayList<CFBamTZTimeDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamTZTimeDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamTZTimeDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamTZTimeDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamTZTimeDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateTZTimeDef( CFBamAuthorization Authorization,
		CFBamTZTimeDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTZTimeDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateTZTimeDef",
				"Existing record not found",
				"TZTimeDef",
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
						"updateTZTimeDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamTZTimeDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteTZTimeDef( CFBamAuthorization Authorization,
		CFBamTZTimeDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamTZTimeDefTable.deleteTZTimeDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamTZTimeDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteTZTimeDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableTZTimeCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTZTimeDef",
				"Superclass",
				"SuperClass",
				"TZTimeCol",
				pkey );
		}

		if( schema.getTableTZTimeType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteTZTimeDef",
				"Superclass",
				"SuperClass",
				"TZTimeType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamTZTimeDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteTZTimeDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteTZTimeDefByIdIdx( Authorization, key );
	}

	public void deleteTZTimeDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByIdIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteTZTimeDefByUNameIdx( Authorization, key );
	}

	public void deleteTZTimeDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByUNameIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTZTimeDefByValTentIdx( Authorization, key );
	}

	public void deleteTZTimeDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByValTentIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteTZTimeDefByScopeIdx( Authorization, key );
	}

	public void deleteTZTimeDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByScopeIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteTZTimeDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteTZTimeDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByDefSchemaIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteTZTimeDefByDataScopeIdx( Authorization, key );
	}

	public void deleteTZTimeDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByDataScopeIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteTZTimeDefByVAccSecIdx( Authorization, key );
	}

	public void deleteTZTimeDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByVAccSecIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteTZTimeDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteTZTimeDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByVAccFreqIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteTZTimeDefByEAccSecIdx( Authorization, key );
	}

	public void deleteTZTimeDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByEAccSecIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteTZTimeDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteTZTimeDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByEAccFreqIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteTZTimeDefByPrevIdx( Authorization, key );
	}

	public void deleteTZTimeDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByPrevIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteTZTimeDefByNextIdx( Authorization, key );
	}

	public void deleteTZTimeDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByNextIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteTZTimeDefByContPrevIdx( Authorization, key );
	}

	public void deleteTZTimeDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByContPrevIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteTZTimeDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteTZTimeDefByContNextIdx( Authorization, key );
	}

	public void deleteTZTimeDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteTZTimeDefByContNextIdx";
		CFBamTZTimeDefBuff cur;
		LinkedList<CFBamTZTimeDefBuff> matchSet = new LinkedList<CFBamTZTimeDefBuff>();
		Iterator<CFBamTZTimeDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamTZTimeDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "TMZD".equals( subClassCode ) ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, cur );
			}
			else if( "TMZC".equals( subClassCode ) ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (CFBamTZTimeColBuff)cur );
			}
			else if( "TMZT".equals( subClassCode ) ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (CFBamTZTimeTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of TZTimeDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openTZTimeDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamTZTimeDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeTZTimeDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamTZTimeDefBuff nextTZTimeDefCursor( CFBamCursor Cursor ) {
		CFBamRamTZTimeDefCursor cursor = (CFBamRamTZTimeDefCursor)Cursor;
		CFBamTZTimeDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamTZTimeDefBuff prevTZTimeDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamTZTimeDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTZTimeDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTZTimeDefBuff firstTZTimeDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamTZTimeDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTZTimeDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamTZTimeDefBuff lastTZTimeDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastTZTimeDefCursor" );
	}

	public CFBamTZTimeDefBuff nthTZTimeDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamTZTimeDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextTZTimeDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
