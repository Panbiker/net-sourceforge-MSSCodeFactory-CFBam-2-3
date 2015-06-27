
// Description: Java7 in-memory RAM DbIO implementation for DateType.

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
 *	CFBamRamDateTypeTable in-memory RAM DbIO implementation
 *	for DateType.
 */
public class CFBamRamDateTypeTable
	implements ICFBamDateTypeTable
{
	private CFBamRamSchema schema;
	private Map< CFBamValuePKey,
				CFBamDateTypeBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamDateTypeBuff >();
	private Map< CFBamDateTypeBySchemaIdxKey,
				Map< CFBamValuePKey,
					CFBamDateTypeBuff >> dictBySchemaIdx
		= new HashMap< CFBamDateTypeBySchemaIdxKey,
				Map< CFBamValuePKey,
					CFBamDateTypeBuff >>();

	public CFBamRamDateTypeTable( CFBamRamSchema argSchema ) {
		schema = argSchema;
	}

	public void createDateType( CFBamAuthorization Authorization,
		CFBamDateTypeBuff Buff )
	{
		final String S_ProcName = "createDateType";
		CFBamValueBuff tail = null;
		if( Buff.getClassCode().equals( "DATT" ) ) {
			CFBamValueBuff[] siblings = schema.getTableValue().readDerivedByScopeIdx( Authorization,
				Buff.getRequiredTenantId(),
				Buff.getRequiredSchemaDefId() );
			for( int idx = 0; ( tail == null ) && ( idx < siblings.length ); idx ++ ) {
				if( ( siblings[idx].getOptionalNextTenantId() == null )
					&& ( siblings[idx].getOptionalNextId() == null ) )
				{
					tail = siblings[idx];
				}
			}
			if( tail != null ) {
				Buff.setOptionalPrevTenantId( tail.getRequiredTenantId() );
				Buff.setOptionalPrevId( tail.getRequiredId() );
			}
			else {
				Buff.setOptionalPrevTenantId( null );
				Buff.setOptionalPrevId( null );
			}
		}
		schema.getTableDateDef().createDateDef( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDateTypeBySchemaIdxKey keySchemaIdx = schema.getFactoryDateType().newSchemaIdxKey();
		keySchemaIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keySchemaIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

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
				if( null == schema.getTableDateDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"DateDef",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredSchemaDefId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamDateTypeBuff > subdictSchemaIdx;
		if( dictBySchemaIdx.containsKey( keySchemaIdx ) ) {
			subdictSchemaIdx = dictBySchemaIdx.get( keySchemaIdx );
		}
		else {
			subdictSchemaIdx = new HashMap< CFBamValuePKey, CFBamDateTypeBuff >();
			dictBySchemaIdx.put( keySchemaIdx, subdictSchemaIdx );
		}
		subdictSchemaIdx.put( pkey, Buff );

		if( tail != null ) {
			String tailClassCode = tail.getClassCode();
			if( tailClassCode.equals( "VALU" ) ) {
				CFBamValueBuff tailEdit = schema.getFactoryValue().newBuff();
				tailEdit.set( (CFBamValueBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableValue().updateValue( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TBLC" ) ) {
				CFBamTableColBuff tailEdit = schema.getFactoryTableCol().newBuff();
				tailEdit.set( (CFBamTableColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTableCol().updateTableCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ATOM" ) ) {
				CFBamAtomBuff tailEdit = schema.getFactoryAtom().newBuff();
				tailEdit.set( (CFBamAtomBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableAtom().updateAtom( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BLBD" ) ) {
				CFBamBlobDefBuff tailEdit = schema.getFactoryBlobDef().newBuff();
				tailEdit.set( (CFBamBlobDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBlobDef().updateBlobDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BLBC" ) ) {
				CFBamBlobColBuff tailEdit = schema.getFactoryBlobCol().newBuff();
				tailEdit.set( (CFBamBlobColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBlobCol().updateBlobCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BLBT" ) ) {
				CFBamBlobTypeBuff tailEdit = schema.getFactoryBlobType().newBuff();
				tailEdit.set( (CFBamBlobTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBlobType().updateBlobType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BOLD" ) ) {
				CFBamBoolDefBuff tailEdit = schema.getFactoryBoolDef().newBuff();
				tailEdit.set( (CFBamBoolDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBoolDef().updateBoolDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BOLC" ) ) {
				CFBamBoolColBuff tailEdit = schema.getFactoryBoolCol().newBuff();
				tailEdit.set( (CFBamBoolColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBoolCol().updateBoolCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BOLT" ) ) {
				CFBamBoolTypeBuff tailEdit = schema.getFactoryBoolType().newBuff();
				tailEdit.set( (CFBamBoolTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBoolType().updateBoolType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I16D" ) ) {
				CFBamInt16DefBuff tailEdit = schema.getFactoryInt16Def().newBuff();
				tailEdit.set( (CFBamInt16DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt16Def().updateInt16Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I16C" ) ) {
				CFBamInt16ColBuff tailEdit = schema.getFactoryInt16Col().newBuff();
				tailEdit.set( (CFBamInt16ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt16Col().updateInt16Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I16T" ) ) {
				CFBamInt16TypeBuff tailEdit = schema.getFactoryInt16Type().newBuff();
				tailEdit.set( (CFBamInt16TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt16Type().updateInt16Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "IG16" ) ) {
				CFBamId16GenBuff tailEdit = schema.getFactoryId16Gen().newBuff();
				tailEdit.set( (CFBamId16GenBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableId16Gen().updateId16Gen( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ENMD" ) ) {
				CFBamEnumDefBuff tailEdit = schema.getFactoryEnumDef().newBuff();
				tailEdit.set( (CFBamEnumDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableEnumDef().updateEnumDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ENMC" ) ) {
				CFBamEnumColBuff tailEdit = schema.getFactoryEnumCol().newBuff();
				tailEdit.set( (CFBamEnumColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableEnumCol().updateEnumCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ENMT" ) ) {
				CFBamEnumTypeBuff tailEdit = schema.getFactoryEnumType().newBuff();
				tailEdit.set( (CFBamEnumTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableEnumType().updateEnumType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I32D" ) ) {
				CFBamInt32DefBuff tailEdit = schema.getFactoryInt32Def().newBuff();
				tailEdit.set( (CFBamInt32DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt32Def().updateInt32Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I32C" ) ) {
				CFBamInt32ColBuff tailEdit = schema.getFactoryInt32Col().newBuff();
				tailEdit.set( (CFBamInt32ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt32Col().updateInt32Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I32T" ) ) {
				CFBamInt32TypeBuff tailEdit = schema.getFactoryInt32Type().newBuff();
				tailEdit.set( (CFBamInt32TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt32Type().updateInt32Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "IG32" ) ) {
				CFBamId32GenBuff tailEdit = schema.getFactoryId32Gen().newBuff();
				tailEdit.set( (CFBamId32GenBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableId32Gen().updateId32Gen( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I64D" ) ) {
				CFBamInt64DefBuff tailEdit = schema.getFactoryInt64Def().newBuff();
				tailEdit.set( (CFBamInt64DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt64Def().updateInt64Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I64C" ) ) {
				CFBamInt64ColBuff tailEdit = schema.getFactoryInt64Col().newBuff();
				tailEdit.set( (CFBamInt64ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt64Col().updateInt64Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I64T" ) ) {
				CFBamInt64TypeBuff tailEdit = schema.getFactoryInt64Type().newBuff();
				tailEdit.set( (CFBamInt64TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt64Type().updateInt64Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "IG64" ) ) {
				CFBamId64GenBuff tailEdit = schema.getFactoryId64Gen().newBuff();
				tailEdit.set( (CFBamId64GenBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableId64Gen().updateId64Gen( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U16D" ) ) {
				CFBamUInt16DefBuff tailEdit = schema.getFactoryUInt16Def().newBuff();
				tailEdit.set( (CFBamUInt16DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt16Def().updateUInt16Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U16C" ) ) {
				CFBamUInt16ColBuff tailEdit = schema.getFactoryUInt16Col().newBuff();
				tailEdit.set( (CFBamUInt16ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt16Col().updateUInt16Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U16T" ) ) {
				CFBamUInt16TypeBuff tailEdit = schema.getFactoryUInt16Type().newBuff();
				tailEdit.set( (CFBamUInt16TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt16Type().updateUInt16Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff tailEdit = schema.getFactoryUInt32Def().newBuff();
				tailEdit.set( (CFBamUInt32DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt32Def().updateUInt32Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff tailEdit = schema.getFactoryUInt32Col().newBuff();
				tailEdit.set( (CFBamUInt32ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt32Col().updateUInt32Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff tailEdit = schema.getFactoryUInt32Type().newBuff();
				tailEdit.set( (CFBamUInt32TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt32Type().updateUInt32Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U64D" ) ) {
				CFBamUInt64DefBuff tailEdit = schema.getFactoryUInt64Def().newBuff();
				tailEdit.set( (CFBamUInt64DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt64Def().updateUInt64Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U64C" ) ) {
				CFBamUInt64ColBuff tailEdit = schema.getFactoryUInt64Col().newBuff();
				tailEdit.set( (CFBamUInt64ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt64Col().updateUInt64Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U64T" ) ) {
				CFBamUInt64TypeBuff tailEdit = schema.getFactoryUInt64Type().newBuff();
				tailEdit.set( (CFBamUInt64TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt64Type().updateUInt64Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "FLTD" ) ) {
				CFBamFloatDefBuff tailEdit = schema.getFactoryFloatDef().newBuff();
				tailEdit.set( (CFBamFloatDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableFloatDef().updateFloatDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "FLTC" ) ) {
				CFBamFloatColBuff tailEdit = schema.getFactoryFloatCol().newBuff();
				tailEdit.set( (CFBamFloatColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableFloatCol().updateFloatCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "FLTT" ) ) {
				CFBamFloatTypeBuff tailEdit = schema.getFactoryFloatType().newBuff();
				tailEdit.set( (CFBamFloatTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableFloatType().updateFloatType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DBLD" ) ) {
				CFBamDoubleDefBuff tailEdit = schema.getFactoryDoubleDef().newBuff();
				tailEdit.set( (CFBamDoubleDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDoubleDef().updateDoubleDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DBLC" ) ) {
				CFBamDoubleColBuff tailEdit = schema.getFactoryDoubleCol().newBuff();
				tailEdit.set( (CFBamDoubleColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDoubleCol().updateDoubleCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DBLT" ) ) {
				CFBamDoubleTypeBuff tailEdit = schema.getFactoryDoubleType().newBuff();
				tailEdit.set( (CFBamDoubleTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDoubleType().updateDoubleType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NUMD" ) ) {
				CFBamNumberDefBuff tailEdit = schema.getFactoryNumberDef().newBuff();
				tailEdit.set( (CFBamNumberDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNumberDef().updateNumberDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NUMC" ) ) {
				CFBamNumberColBuff tailEdit = schema.getFactoryNumberCol().newBuff();
				tailEdit.set( (CFBamNumberColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNumberCol().updateNumberCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NUMT" ) ) {
				CFBamNumberTypeBuff tailEdit = schema.getFactoryNumberType().newBuff();
				tailEdit.set( (CFBamNumberTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNumberType().updateNumberType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "STRD" ) ) {
				CFBamStringDefBuff tailEdit = schema.getFactoryStringDef().newBuff();
				tailEdit.set( (CFBamStringDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableStringDef().updateStringDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "STRC" ) ) {
				CFBamStringColBuff tailEdit = schema.getFactoryStringCol().newBuff();
				tailEdit.set( (CFBamStringColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableStringCol().updateStringCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "STRT" ) ) {
				CFBamStringTypeBuff tailEdit = schema.getFactoryStringType().newBuff();
				tailEdit.set( (CFBamStringTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableStringType().updateStringType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TXTD" ) ) {
				CFBamTextDefBuff tailEdit = schema.getFactoryTextDef().newBuff();
				tailEdit.set( (CFBamTextDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTextDef().updateTextDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TXTC" ) ) {
				CFBamTextColBuff tailEdit = schema.getFactoryTextCol().newBuff();
				tailEdit.set( (CFBamTextColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTextCol().updateTextCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TXTT" ) ) {
				CFBamTextTypeBuff tailEdit = schema.getFactoryTextType().newBuff();
				tailEdit.set( (CFBamTextTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTextType().updateTextType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTKD" ) ) {
				CFBamNmTokenDefBuff tailEdit = schema.getFactoryNmTokenDef().newBuff();
				tailEdit.set( (CFBamNmTokenDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTKC" ) ) {
				CFBamNmTokenColBuff tailEdit = schema.getFactoryNmTokenCol().newBuff();
				tailEdit.set( (CFBamNmTokenColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTKT" ) ) {
				CFBamNmTokenTypeBuff tailEdit = schema.getFactoryNmTokenType().newBuff();
				tailEdit.set( (CFBamNmTokenTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokenType().updateNmTokenType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTSD" ) ) {
				CFBamNmTokensDefBuff tailEdit = schema.getFactoryNmTokensDef().newBuff();
				tailEdit.set( (CFBamNmTokensDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTSC" ) ) {
				CFBamNmTokensColBuff tailEdit = schema.getFactoryNmTokensCol().newBuff();
				tailEdit.set( (CFBamNmTokensColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTST" ) ) {
				CFBamNmTokensTypeBuff tailEdit = schema.getFactoryNmTokensType().newBuff();
				tailEdit.set( (CFBamNmTokensTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokensType().updateNmTokensType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TKND" ) ) {
				CFBamTokenDefBuff tailEdit = schema.getFactoryTokenDef().newBuff();
				tailEdit.set( (CFBamTokenDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTokenDef().updateTokenDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TKNC" ) ) {
				CFBamTokenColBuff tailEdit = schema.getFactoryTokenCol().newBuff();
				tailEdit.set( (CFBamTokenColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTokenCol().updateTokenCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TKNT" ) ) {
				CFBamTokenTypeBuff tailEdit = schema.getFactoryTokenType().newBuff();
				tailEdit.set( (CFBamTokenTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTokenType().updateTokenType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DATD" ) ) {
				CFBamDateDefBuff tailEdit = schema.getFactoryDateDef().newBuff();
				tailEdit.set( (CFBamDateDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDateDef().updateDateDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DATC" ) ) {
				CFBamDateColBuff tailEdit = schema.getFactoryDateCol().newBuff();
				tailEdit.set( (CFBamDateColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDateCol().updateDateCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DATT" ) ) {
				CFBamDateTypeBuff tailEdit = schema.getFactoryDateType().newBuff();
				tailEdit.set( (CFBamDateTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDateType().updateDateType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TIMD" ) ) {
				CFBamTimeDefBuff tailEdit = schema.getFactoryTimeDef().newBuff();
				tailEdit.set( (CFBamTimeDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimeDef().updateTimeDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TIMC" ) ) {
				CFBamTimeColBuff tailEdit = schema.getFactoryTimeCol().newBuff();
				tailEdit.set( (CFBamTimeColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimeCol().updateTimeCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TIMT" ) ) {
				CFBamTimeTypeBuff tailEdit = schema.getFactoryTimeType().newBuff();
				tailEdit.set( (CFBamTimeTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimeType().updateTimeType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TSPD" ) ) {
				CFBamTimestampDefBuff tailEdit = schema.getFactoryTimestampDef().newBuff();
				tailEdit.set( (CFBamTimestampDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimestampDef().updateTimestampDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TSPC" ) ) {
				CFBamTimestampColBuff tailEdit = schema.getFactoryTimestampCol().newBuff();
				tailEdit.set( (CFBamTimestampColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimestampCol().updateTimestampCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TSPT" ) ) {
				CFBamTimestampTypeBuff tailEdit = schema.getFactoryTimestampType().newBuff();
				tailEdit.set( (CFBamTimestampTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimestampType().updateTimestampType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DAZD" ) ) {
				CFBamTZDateDefBuff tailEdit = schema.getFactoryTZDateDef().newBuff();
				tailEdit.set( (CFBamTZDateDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZDateDef().updateTZDateDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DAZC" ) ) {
				CFBamTZDateColBuff tailEdit = schema.getFactoryTZDateCol().newBuff();
				tailEdit.set( (CFBamTZDateColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZDateCol().updateTZDateCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DAZT" ) ) {
				CFBamTZDateTypeBuff tailEdit = schema.getFactoryTZDateType().newBuff();
				tailEdit.set( (CFBamTZDateTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZDateType().updateTZDateType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TMZD" ) ) {
				CFBamTZTimeDefBuff tailEdit = schema.getFactoryTZTimeDef().newBuff();
				tailEdit.set( (CFBamTZTimeDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TMZC" ) ) {
				CFBamTZTimeColBuff tailEdit = schema.getFactoryTZTimeCol().newBuff();
				tailEdit.set( (CFBamTZTimeColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TMZT" ) ) {
				CFBamTZTimeTypeBuff tailEdit = schema.getFactoryTZTimeType().newBuff();
				tailEdit.set( (CFBamTZTimeTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimeType().updateTZTimeType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ZSTD" ) ) {
				CFBamTZTimestampDefBuff tailEdit = schema.getFactoryTZTimestampDef().newBuff();
				tailEdit.set( (CFBamTZTimestampDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ZSTC" ) ) {
				CFBamTZTimestampColBuff tailEdit = schema.getFactoryTZTimestampCol().newBuff();
				tailEdit.set( (CFBamTZTimestampColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ZSTT" ) ) {
				CFBamTZTimestampTypeBuff tailEdit = schema.getFactoryTZTimestampType().newBuff();
				tailEdit.set( (CFBamTZTimestampTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "UIDD" ) ) {
				CFBamUuidDefBuff tailEdit = schema.getFactoryUuidDef().newBuff();
				tailEdit.set( (CFBamUuidDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUuidDef().updateUuidDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "UIDC" ) ) {
				CFBamUuidColBuff tailEdit = schema.getFactoryUuidCol().newBuff();
				tailEdit.set( (CFBamUuidColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUuidCol().updateUuidCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "UIDT" ) ) {
				CFBamUuidTypeBuff tailEdit = schema.getFactoryUuidType().newBuff();
				tailEdit.set( (CFBamUuidTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUuidType().updateUuidType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "IGUU" ) ) {
				CFBamUuidGenBuff tailEdit = schema.getFactoryUuidGen().newBuff();
				tailEdit.set( (CFBamUuidGenBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUuidGen().updateUuidGen( Authorization, tailEdit );
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode " + tailClassCode );
			}
		}
	}

	public CFBamDateTypeBuff readDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDateType.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDateTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDateTypeBuff lockDerived( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDateType.readDerived() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamDateTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDateTypeBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamDateType.readAllDerived() ";
		CFBamDateTypeBuff[] retList = new CFBamDateTypeBuff[ dictByPKey.values().size() ];
		Iterator< CFBamDateTypeBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamDateTypeBuff readDerivedByUNameIdx( CFBamAuthorization Authorization,
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
		else if( buff instanceof CFBamDateTypeBuff ) {
			return( (CFBamDateTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByValTentIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByDefSchemaIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByDataScopeIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByVAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByVAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByEAccSecIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByEAccFreqIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByContPrevIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedByContNextIdx( CFBamAuthorization Authorization,
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
			ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamDateTypeBuff ) ) {
					filteredList.add( (CFBamDateTypeBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
		}
	}

	public CFBamDateTypeBuff[] readDerivedBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		final String S_ProcName = "CFBamRamDateType.readDerivedBySchemaIdx() ";
		CFBamDateTypeBySchemaIdxKey key = schema.getFactoryDateType().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );

		CFBamDateTypeBuff[] recArray;
		if( dictBySchemaIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamDateTypeBuff > subdictSchemaIdx
				= dictBySchemaIdx.get( key );
			recArray = new CFBamDateTypeBuff[ subdictSchemaIdx.size() ];
			Iterator< CFBamDateTypeBuff > iter = subdictSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamDateTypeBuff > subdictSchemaIdx
				= new HashMap< CFBamValuePKey, CFBamDateTypeBuff >();
			dictBySchemaIdx.put( key, subdictSchemaIdx );
			recArray = new CFBamDateTypeBuff[0];
		}
		return( recArray );
	}

	public CFBamDateTypeBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamDateTypeBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamDateTypeBuff readBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDateType.readBuff() ";
		CFBamDateTypeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DATT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDateTypeBuff lockBuff( CFBamAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamDateType.readBuff() ";
		CFBamDateTypeBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "DATT" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamDateTypeBuff[] readAllBuff( CFBamAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamDateType.readAllBuff() ";
		CFBamDateTypeBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamDateTypeBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DATT" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamValueBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamDateTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDateTypeBuff readBuffByUNameIdx( CFBamAuthorization Authorization,
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
			return( (CFBamDateTypeBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamDateTypeBuff[] readBuffByValTentIdx( CFBamAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByScopeIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByDefSchemaIdx( CFBamAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByDataScopeIdx( CFBamAuthorization Authorization,
		Short DataScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDataScopeIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByDataScopeIdx( Authorization,
			DataScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByVAccSecIdx( CFBamAuthorization Authorization,
		Short ViewAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccSecIdx( Authorization,
			ViewAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByVAccFreqIdx( CFBamAuthorization Authorization,
		Short ViewAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByVAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByVAccFreqIdx( Authorization,
			ViewAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByEAccSecIdx( CFBamAuthorization Authorization,
		Short EditAccessSecurityId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccSecIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccSecIdx( Authorization,
			EditAccessSecurityId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByEAccFreqIdx( CFBamAuthorization Authorization,
		Short EditAccessFrequencyId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByEAccFreqIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByEAccFreqIdx( Authorization,
			EditAccessFrequencyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByPrevIdx( CFBamAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByNextIdx( CFBamAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByContPrevIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffByContNextIdx( CFBamAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamValueBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamValueBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	public CFBamDateTypeBuff[] readBuffBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		final String S_ProcName = "CFBamRamDateType.readBuffBySchemaIdx() ";
		CFBamDateTypeBuff buff;
		ArrayList<CFBamDateTypeBuff> filteredList = new ArrayList<CFBamDateTypeBuff>();
		CFBamDateTypeBuff[] buffList = readDerivedBySchemaIdx( Authorization,
			TenantId,
			SchemaDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "DATT" ) ) {
				filteredList.add( (CFBamDateTypeBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamDateTypeBuff[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamDateTypeBuff moveBuffUp( CFBamAuthorization Authorization,
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
	public CFBamDateTypeBuff moveBuffDown( CFBamAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(), "moveBuffDown" );
	}

	public void updateDateType( CFBamAuthorization Authorization,
		CFBamDateTypeBuff Buff )
	{
		schema.getTableDateDef().updateDateDef( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDateTypeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw CFLib.getDefaultExceptionFactory().newStaleCacheDetectedException( getClass(),
				"updateDateType",
				"Existing record not found",
				"DateType",
				pkey );
		}
		CFBamDateTypeBySchemaIdxKey existingKeySchemaIdx = schema.getFactoryDateType().newSchemaIdxKey();
		existingKeySchemaIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		CFBamDateTypeBySchemaIdxKey newKeySchemaIdx = schema.getFactoryDateType().newSchemaIdxKey();
		newKeySchemaIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeySchemaIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDateDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDateType",
						"Superclass",
						"SuperClass",
						"DateDef",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredSchemaDefId() ) )
				{
					throw CFLib.getDefaultExceptionFactory().newUnresolvedRelationException( getClass(),
						"updateDateType",
						"Container",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		// Update is valid
			
		Map< CFBamValuePKey, CFBamDateTypeBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySchemaIdx.get( existingKeySchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySchemaIdx.containsKey( newKeySchemaIdx ) ) {
			subdict = dictBySchemaIdx.get( newKeySchemaIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamDateTypeBuff >();
			dictBySchemaIdx.put( newKeySchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteDateType( CFBamAuthorization Authorization,
		CFBamDateTypeBuff Buff )
	{
		final String S_ProcName = "CFBamRamDateTypeTable.deleteDateType() ";
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamDateTypeBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw CFLib.getDefaultExceptionFactory().newCollisionDetectedException( getClass(),
				"deleteDateType",
				pkey );
		}
		CFBamDateTypeBySchemaIdxKey keySchemaIdx = schema.getFactoryDateType().newSchemaIdxKey();
		keySchemaIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );


		// Validate reverse foreign keys

		// Delete is valid

		schema.getTableTableCol().deleteTableColByDataIdx( Authorization,
			Buff.getRequiredTenantId(),
			Buff.getRequiredId() );
		Map< CFBamValuePKey, CFBamDateTypeBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySchemaIdx.get( keySchemaIdx );
		subdict.remove( pkey );

		schema.getTableDateDef().deleteDateDef( Authorization,
			Buff );
	}

	public void deleteDateTypeBySchemaIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId )
	{
		CFBamDateTypeBySchemaIdxKey key = schema.getFactoryDateType().newSchemaIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredSchemaDefId( argSchemaDefId );
		deleteDateTypeBySchemaIdx( Authorization, key );
	}

	public void deleteDateTypeBySchemaIdx( CFBamAuthorization Authorization,
		CFBamDateTypeBySchemaIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByIdIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteDateTypeByIdIdx( Authorization, key );
	}

	public void deleteDateTypeByIdIdx( CFBamAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByUNameIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteDateTypeByUNameIdx( Authorization, key );
	}

	public void deleteDateTypeByUNameIdx( CFBamAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByValTentIdx( CFBamAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDateTypeByValTentIdx( Authorization, key );
	}

	public void deleteDateTypeByValTentIdx( CFBamAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByScopeIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteDateTypeByScopeIdx( Authorization, key );
	}

	public void deleteDateTypeByScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByDefSchemaIdx( CFBamAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDateTypeByDefSchemaIdx( Authorization, key );
	}

	public void deleteDateTypeByDefSchemaIdx( CFBamAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByDataScopeIdx( CFBamAuthorization Authorization,
		Short argDataScopeId )
	{
		CFBamValueByDataScopeIdxKey key = schema.getFactoryValue().newDataScopeIdxKey();
		key.setOptionalDataScopeId( argDataScopeId );
		deleteDateTypeByDataScopeIdx( Authorization, key );
	}

	public void deleteDateTypeByDataScopeIdx( CFBamAuthorization Authorization,
		CFBamValueByDataScopeIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByVAccSecIdx( CFBamAuthorization Authorization,
		Short argViewAccessSecurityId )
	{
		CFBamValueByVAccSecIdxKey key = schema.getFactoryValue().newVAccSecIdxKey();
		key.setOptionalViewAccessSecurityId( argViewAccessSecurityId );
		deleteDateTypeByVAccSecIdx( Authorization, key );
	}

	public void deleteDateTypeByVAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccSecIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByVAccFreqIdx( CFBamAuthorization Authorization,
		Short argViewAccessFrequencyId )
	{
		CFBamValueByVAccFreqIdxKey key = schema.getFactoryValue().newVAccFreqIdxKey();
		key.setOptionalViewAccessFrequencyId( argViewAccessFrequencyId );
		deleteDateTypeByVAccFreqIdx( Authorization, key );
	}

	public void deleteDateTypeByVAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByVAccFreqIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByEAccSecIdx( CFBamAuthorization Authorization,
		Short argEditAccessSecurityId )
	{
		CFBamValueByEAccSecIdxKey key = schema.getFactoryValue().newEAccSecIdxKey();
		key.setOptionalEditAccessSecurityId( argEditAccessSecurityId );
		deleteDateTypeByEAccSecIdx( Authorization, key );
	}

	public void deleteDateTypeByEAccSecIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccSecIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByEAccFreqIdx( CFBamAuthorization Authorization,
		Short argEditAccessFrequencyId )
	{
		CFBamValueByEAccFreqIdxKey key = schema.getFactoryValue().newEAccFreqIdxKey();
		key.setOptionalEditAccessFrequencyId( argEditAccessFrequencyId );
		deleteDateTypeByEAccFreqIdx( Authorization, key );
	}

	public void deleteDateTypeByEAccFreqIdx( CFBamAuthorization Authorization,
		CFBamValueByEAccFreqIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByPrevIdx( CFBamAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteDateTypeByPrevIdx( Authorization, key );
	}

	public void deleteDateTypeByPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByNextIdx( CFBamAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteDateTypeByNextIdx( Authorization, key );
	}

	public void deleteDateTypeByNextIdx( CFBamAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByContPrevIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteDateTypeByContPrevIdx( Authorization, key );
	}

	public void deleteDateTypeByContPrevIdx( CFBamAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public void deleteDateTypeByContNextIdx( CFBamAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteDateTypeByContNextIdx( Authorization, key );
	}

	public void deleteDateTypeByContNextIdx( CFBamAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		CFBamDateTypeBuff cur;
		LinkedList<CFBamDateTypeBuff> matchSet = new LinkedList<CFBamDateTypeBuff>();
		Iterator<CFBamDateTypeBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamDateTypeBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			deleteDateType( Authorization, cur );
		}
	}

	public CFBamCursor openDateTypeCursorAll( CFBamAuthorization Authorization ) {
		CFBamCursor cursor = new CFBamRamDateTypeCursor( Authorization,
			schema,
			dictByPKey.values() );
		return( cursor );
	}

	public CFBamCursor openDateTypeCursorBySchemaIdx( CFBamAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		CFBamCursor cursor;
		CFBamDateTypeBySchemaIdxKey key = schema.getFactoryDateType().newSchemaIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSchemaDefId( SchemaDefId );

		if( dictBySchemaIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamDateTypeBuff > subdictSchemaIdx
				= dictBySchemaIdx.get( key );
			cursor = new CFBamRamDateTypeCursor( Authorization,
				schema,
				subdictSchemaIdx.values() );
		}
		else {
			cursor = new CFBamRamDateTypeCursor( Authorization,
				schema,
				new ArrayList< CFBamDateTypeBuff >() );
		}
		return( cursor );
	}

	public void closeDateTypeCursor( CFBamCursor Cursor ) {
		// Cursor.DataReader.Close();
	}

	public CFBamDateTypeBuff nextDateTypeCursor( CFBamCursor Cursor ) {
		CFBamRamDateTypeCursor cursor = (CFBamRamDateTypeCursor)Cursor;
		CFBamDateTypeBuff rec = cursor.getCursor().next();
		cursor.setRowIdx( cursor.getRowIdx() + 1 );
		return( rec );
	}

	public CFBamDateTypeBuff prevDateTypeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = ( Cursor.getRowIdx() > 1 ) ? Cursor.getRowIdx() - 1 : 1;
		CFBamDateTypeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDateTypeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDateTypeBuff firstDateTypeCursor( CFBamCursor Cursor ) {
		int targetRowIdx = 1;
		CFBamDateTypeBuff rec = null;
		Cursor.reset();
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDateTypeCursor( Cursor );
		}
		return( rec );
	}

	public CFBamDateTypeBuff lastDateTypeCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
			"lastDateTypeCursor" );
	}

	public CFBamDateTypeBuff nthDateTypeCursor( CFBamCursor Cursor, int Idx ) {
		int targetRowIdx = Idx;
		CFBamDateTypeBuff rec = null;
		if( Cursor.getRowIdx() >= targetRowIdx ) {
			Cursor.reset();
		}
		while( Cursor.getRowIdx() < targetRowIdx ) {
			rec = nextDateTypeCursor( Cursor );
		}
		return( rec );
	}

	public void releasePreparedStatements() {
	}
}
