
// Description: Java7 in-memory RAM DbIO implementation for BlobDef.

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
 *	CFBamRamBlobDefTable in-memory RAM DbIO implementation
 *	for BlobDef.
 */
public class CFBamRamBlobDefTable
	implements ICFBamBlobDefTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamBlobDefBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamBlobDefBuff >();

	public CFBamRamBlobDefTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createBlobDef( CFBamAuthorization Authorization,
		CFBamBlobDefBuff Buff )
	{
		final String S_ProcName = "createBlobDef";
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

	public CFBamBlobDefBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamBlobDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamBlobDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamBlobDefBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamBlobDef.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamBlobDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamBlobDefBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamBlobDef.readAllDerived() ";
		CFBamBlobDefBuff[] retList = new CFBamBlobDefBuff[ dictByPKey.values().size() ];
		Iterator< CFBamBlobDefBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamBlobDefBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamBlobDefBuff ) {
			return( (CFBamBlobDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamBlobDefBuff ) ) {
					filteredList.add( (CFBamBlobDefBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
		}
	}

	public CFBamBlobDefBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamBlobDefBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamBlobDefBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamBlobDef.readBuff() ";
		CFBamBlobDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "BLBD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamBlobDefBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamBlobDef.readBuff() ";
		CFBamBlobDefBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "BLBD" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamBlobDefBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamBlobDef.readAllBuff() ";
		CFBamBlobDefBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamBlobDefBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "BLBD" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamBlobDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamBlobDefBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamBlobDefBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamBlobDefBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	public CFBamBlobDefBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamBlobDefBuff> filteredList = new ArrayList<CFBamBlobDefBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamBlobDefBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamBlobDefBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamBlobDefBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamBlobDefBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateBlobDef( CFBamAuthorization Authorization,
		CFBamBlobDefBuff Buff )
	{
		schema.getTableAtom().updateAtom( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamBlobDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateBlobDef",
				"Existing record not found",
				"BlobDef",
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
						"updateBlobDef",
						"Superclass",
						"SuperClass",
						"Atom",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamBlobDefBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

	}

	public void deleteBlobDef( CFBamAuthorization Authorization,
		CFBamBlobDefBuff Buff )
	{
		final String S_ProcName = "CFBamRamBlobDefTable.deleteBlobDef() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamBlobDefBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteBlobDef",
				pkey );
		}

		// Validate reverse foreign keys

		if( schema.getTableBlobCol().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteBlobDef",
				"Superclass",
				"SuperClass",
				"BlobCol",
				pkey );
		}

		if( schema.getTableBlobType().readDerivedByIdIdx( Authorization,
					existing.getRequiredTenantId(),
					existing.getRequiredId() ) != null )
		{
			throw CFLib.getDefaultExceptionFactory().newDependentsDetectedException( getClass(),
				"deleteBlobDef",
				"Superclass",
				"SuperClass",
				"BlobType",
				pkey );
		}

		// Delete is valid

		Map< CFBamValuePKey, CFBamBlobDefBuff > subdict;

		dictByPKey.remove( pkey );

		schema.getTableAtom().deleteAtom( Authorization,
			Buff );
	}

	public void deleteBlobDefByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteBlobDefByIdIdx( Authorization, key );
	}

	public void deleteBlobDefByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByIdIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteBlobDefByUNameIdx( Authorization, key );
	}

	public void deleteBlobDefByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByUNameIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteBlobDefByValTentIdx( Authorization, key );
	}

	public void deleteBlobDefByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByValTentIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteBlobDefByScopeIdx( Authorization, key );
	}

	public void deleteBlobDefByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByScopeIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteBlobDefByDefSchemaIdx( Authorization, key );
	}

	public void deleteBlobDefByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByDefSchemaIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteBlobDefByDataScopeIdx( Authorization, key );
	}

	public void deleteBlobDefByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByDataScopeIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteBlobDefByVAccSecIdx( Authorization, key );
	}

	public void deleteBlobDefByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByVAccSecIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteBlobDefByVAccFreqIdx( Authorization, key );
	}

	public void deleteBlobDefByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByVAccFreqIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteBlobDefByEAccSecIdx( Authorization, key );
	}

	public void deleteBlobDefByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByEAccSecIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteBlobDefByEAccFreqIdx( Authorization, key );
	}

	public void deleteBlobDefByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByEAccFreqIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteBlobDefByPrevIdx( Authorization, key );
	}

	public void deleteBlobDefByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByPrevIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteBlobDefByNextIdx( Authorization, key );
	}

	public void deleteBlobDefByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByNextIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteBlobDefByContPrevIdx( Authorization, key );
	}

	public void deleteBlobDefByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByContPrevIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public void deleteBlobDefByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteBlobDefByContNextIdx( Authorization, key );
	}

	public void deleteBlobDefByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteBlobDefByContNextIdx";
		CFBamBlobDefBuff cur;
		LinkedList<CFBamBlobDefBuff> matchSet = new LinkedList<CFBamBlobDefBuff>();
		Iterator<CFBamBlobDefBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamBlobDefBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			String subClassCode = cur.getClassCode();
			if( "BLBD".equals( subClassCode ) ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, cur );
			}
			else if( "BLBC".equals( subClassCode ) ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (CFBamBlobColBuff)cur );
			}
			else if( "BLBT".equals( subClassCode ) ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (CFBamBlobTypeBuff)cur );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"subClassCode",
					cur,
					"Instance of or subclass of BlobDef must not be \"" + subClassCode + "\"" );
			}
		}
	}

	public CFBamCursor openBlobDefCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamBlobDefCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public void closeBlobDefCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamBlobDefBuff nextBlobDefCursor( CFBamCursor Cursor ) {
		CFBamRamBlobDefCursor cursor = (CFBamRamBlobDefCursor)Cursor;
		CFBamBlobDefBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamBlobDefBuff prevBlobDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamBlobDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextBlobDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamBlobDefBuff firstBlobDefCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamBlobDefBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextBlobDefCursor( Cursor );
		}
		return( rec );
	}

	public CFBamBlobDefBuff lastBlobDefCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastBlobDefCursor" );
	}

	public CFBamBlobDefBuff nthBlobDefCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamBlobDefBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextBlobDefCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
