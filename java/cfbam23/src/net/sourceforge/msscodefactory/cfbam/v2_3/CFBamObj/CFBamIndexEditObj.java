// Description: Java7 edit object instance implementation for CFBam Index.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

public class CFBamIndexEditObj
	extends CFBamScopeEditObj

	implements ICFBamIndexEditObj
{
	protected ICFBamTenantObj requiredOwnerIdxTenant;
	protected ICFBamTableObj requiredContainerTable;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;

	public CFBamIndexEditObj( ICFBamIndexObj argOrig ) {
		super( argOrig );
		requiredOwnerIdxTenant = null;
		requiredContainerTable = null;
		optionalLookupDefSchema = null;
	}

	public String getClassCode() {
		return( CFBamIndexObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Index" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamTableObj scope = getRequiredContainerTable();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamTableObj scope = getRequiredContainerTable();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredName();
		return( objName );
	}

	public ICFLibAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		ICFLibAnyObj subObj = null;
		ICFLibAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( subObj == null ) {
			subObj = getSchema().getIndexColTableObj().readIndexColByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	public ICFBamScopeObj realize() {
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamIndexObj retobj = getSchema().getIndexTableObj().realizeIndex( (ICFBamIndexObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsIndex().getSchema().getIndexTableObj().forgetIndex( getOrigAsIndex(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamIndexObj retobj = getOrigAsIndex().getSchema().getIndexTableObj().createIndex( getOrigAsIndex() );
		if( retobj == getOrigAsIndex() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getIndexTableObj().updateIndex( (ICFBamIndexObj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getIndexTableObj().deleteIndex( getOrigAsIndex() );
	}

	public ICFBamIndexTableObj getIndexTable() {
		return( orig.getSchema().getIndexTableObj() );
	}

	public ICFBamIndexEditObj getEditAsIndex() {
		return( (ICFBamIndexEditObj)this );
	}

	public ICFBamIndexObj getOrigAsIndex() {
		return( (ICFBamIndexObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsIndex().getSchema().getBackingStore().getFactoryIndex().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredOwnerIdxTenant = null;
			requiredContainerTable = null;
			optionalLookupDefSchema = null;
		}
	}

	public CFBamIndexBuff getIndexBuff() {
		return( (CFBamIndexBuff)getBuff() );
	}

	public long getRequiredTableId() {
		return( getIndexBuff().getRequiredTableId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getIndexBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getIndexBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getIndexBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getIndexBuff().getRequiredName() != value ) {
			getIndexBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getIndexBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getIndexBuff().getOptionalShortName() != value ) {
			getIndexBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getIndexBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getIndexBuff().getOptionalLabel() != value ) {
			getIndexBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getIndexBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getIndexBuff().getOptionalShortDescription() != value ) {
			getIndexBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getIndexBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getIndexBuff().getOptionalDescription() != value ) {
			getIndexBuff().setOptionalDescription( value );
		}
	}

	public String getOptionalDbName() {
		return( getIndexBuff().getOptionalDbName() );
	}

	public void setOptionalDbName( String value ) {
		if( getIndexBuff().getOptionalDbName() != value ) {
			getIndexBuff().setOptionalDbName( value );
		}
	}

	public String getOptionalSuffix() {
		return( getIndexBuff().getOptionalSuffix() );
	}

	public void setOptionalSuffix( String value ) {
		if( getIndexBuff().getOptionalSuffix() != value ) {
			getIndexBuff().setOptionalSuffix( value );
		}
	}

	public boolean getRequiredIsUnique() {
		return( getIndexBuff().getRequiredIsUnique() );
	}

	public void setRequiredIsUnique( boolean value ) {
		if( getIndexBuff().getRequiredIsUnique() != value ) {
			getIndexBuff().setRequiredIsUnique( value );
		}
	}

	public boolean getRequiredIsDbMapped() {
		return( getIndexBuff().getRequiredIsDbMapped() );
	}

	public void setRequiredIsDbMapped( boolean value ) {
		if( getIndexBuff().getRequiredIsDbMapped() != value ) {
			getIndexBuff().setRequiredIsDbMapped( value );
		}
	}

	public boolean getRequiredDefaultVisibility() {
		return( getIndexBuff().getRequiredDefaultVisibility() );
	}

	public void setRequiredDefaultVisibility( boolean value ) {
		if( getIndexBuff().getRequiredDefaultVisibility() != value ) {
			getIndexBuff().setRequiredDefaultVisibility( value );
		}
	}

	public ICFBamTenantObj getRequiredOwnerIdxTenant() {
		return( getRequiredOwnerIdxTenant( false ) );
	}

	public ICFBamTenantObj getRequiredOwnerIdxTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerIdxTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTenantObj obj = getOrigAsIndex().getSchema().getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerIdxTenant = obj;
			}
		}
		return( requiredOwnerIdxTenant );
	}

	public void setRequiredOwnerIdxTenant( ICFBamTenantObj value ) {
			if( buff == null ) {
				getIndexBuff();
			}
			requiredOwnerIdxTenant = null;
			requiredContainerTable = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getIndexBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerIdxTenant = value;

		super.setRequiredOwnerTenant( value );	}

	public ICFBamTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerTable( boolean forceRead ) {
		if( forceRead || ( requiredContainerTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTableObj obj = getOrigAsIndex().getSchema().getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getIndexBuff().getRequiredTableId() );
				requiredContainerTable = obj;
				if( obj != null ) {
					getIndexBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getIndexBuff().setRequiredTableId( obj.getRequiredId() );
					requiredContainerTable = obj;
				}
			}
		}
		return( requiredContainerTable );
	}

	public void setRequiredContainerTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getIndexBuff();
			}
			requiredOwnerIdxTenant = null;
			requiredContainerTable = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getIndexBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getIndexBuff().setRequiredTableId( value.getRequiredId() );
			}
			requiredContainerTable = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getIndexBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getIndexBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = getOrigAsIndex().getSchema().getSchemaDefTableObj().readSchemaDefByIdIdx( getIndexBuff().getOptionalDefSchemaTenantId(),
					getIndexBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getIndexBuff();
			}
			if( value != null ) {
				getIndexBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getIndexBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getIndexBuff().setOptionalDefSchemaTenantId( null );
				getIndexBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public List<ICFBamIndexColObj> getOptionalComponentsColumns() {
		List<ICFBamIndexColObj> retval;
		retval = getOrigAsIndex().getSchema().getIndexColTableObj().readIndexColByIndexIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamIndexColObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamIndexColObj> retval;
		retval = getOrigAsIndex().getSchema().getIndexColTableObj().readIndexColByIndexIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamIndexBuff origBuff = getOrigAsIndex().getIndexBuff();
		CFBamIndexBuff myBuff = getIndexBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamIndexBuff origBuff = getOrigAsIndex().getIndexBuff();
		CFBamIndexBuff myBuff = getIndexBuff();
		myBuff.set( origBuff );
	}
}
