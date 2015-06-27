// Description: Java7 edit object instance implementation for CFBam SchemaRef.

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

public class CFBamSchemaRefEditObj
	extends CFBamScopeEditObj

	implements ICFBamSchemaRefEditObj
{
	protected ICFBamSchemaDefObj requiredContainerSchema;
	protected ICFBamSchemaDefObj optionalLookupRefSchema;

	public CFBamSchemaRefEditObj( ICFBamSchemaRefObj argOrig ) {
		super( argOrig );
		requiredContainerSchema = null;
		optionalLookupRefSchema = null;
	}

	public String getClassCode() {
		return( CFBamSchemaRefObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SchemaRef" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchema();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchema();
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
		ICFBamSchemaRefObj retobj = getSchema().getSchemaRefTableObj().realizeSchemaRef( (ICFBamSchemaRefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsSchemaRef().getSchema().getSchemaRefTableObj().forgetSchemaRef( getOrigAsSchemaRef(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamSchemaRefObj retobj = getOrigAsSchemaRef().getSchema().getSchemaRefTableObj().createSchemaRef( getOrigAsSchemaRef() );
		if( retobj == getOrigAsSchemaRef() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getSchemaRefTableObj().updateSchemaRef( (ICFBamSchemaRefObj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getSchemaRefTableObj().deleteSchemaRef( getOrigAsSchemaRef() );
	}

	public ICFBamSchemaRefTableObj getSchemaRefTable() {
		return( orig.getSchema().getSchemaRefTableObj() );
	}

	public ICFBamSchemaRefEditObj getEditAsSchemaRef() {
		return( (ICFBamSchemaRefEditObj)this );
	}

	public ICFBamSchemaRefObj getOrigAsSchemaRef() {
		return( (ICFBamSchemaRefObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsSchemaRef().getSchema().getBackingStore().getFactorySchemaRef().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerSchema = null;
			optionalLookupRefSchema = null;
		}
	}

	public CFBamSchemaRefBuff getSchemaRefBuff() {
		return( (CFBamSchemaRefBuff)getBuff() );
	}

	public long getRequiredSchemaId() {
		return( getSchemaRefBuff().getRequiredSchemaId() );
	}

	public String getRequiredName() {
		return( getSchemaRefBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getSchemaRefBuff().getRequiredName() != value ) {
			getSchemaRefBuff().setRequiredName( value );
		}
	}

	public String getRequiredRefModelName() {
		return( getSchemaRefBuff().getRequiredRefModelName() );
	}

	public void setRequiredRefModelName( String value ) {
		if( getSchemaRefBuff().getRequiredRefModelName() != value ) {
			getSchemaRefBuff().setRequiredRefModelName( value );
		}
	}

	public String getRequiredIncludeRoot() {
		return( getSchemaRefBuff().getRequiredIncludeRoot() );
	}

	public void setRequiredIncludeRoot( String value ) {
		if( getSchemaRefBuff().getRequiredIncludeRoot() != value ) {
			getSchemaRefBuff().setRequiredIncludeRoot( value );
		}
	}

	public Long getOptionalRefSchemaTenantId() {
		return( getSchemaRefBuff().getOptionalRefSchemaTenantId() );
	}

	public Long getOptionalRefSchemaId() {
		return( getSchemaRefBuff().getOptionalRefSchemaId() );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchema() {
		return( getRequiredContainerSchema( false ) );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchema( boolean forceRead ) {
		if( forceRead || ( requiredContainerSchema == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = getOrigAsSchemaRef().getSchema().getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
					getSchemaRefBuff().getRequiredSchemaId() );
				requiredContainerSchema = obj;
				if( obj != null ) {
					getSchemaRefBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getSchemaRefBuff().setRequiredSchemaId( obj.getRequiredId() );
					requiredContainerSchema = obj;
				}
			}
		}
		return( requiredContainerSchema );
	}

	public void setRequiredContainerSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getSchemaRefBuff();
			}
			requiredContainerSchema = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getSchemaRefBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getSchemaRefBuff().setRequiredSchemaId( value.getRequiredId() );
			}
			requiredContainerSchema = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupRefSchema() {
		return( getOptionalLookupRefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupRefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupRefSchema == null ) ) {
			boolean anyMissing = false;
			if( getSchemaRefBuff().getOptionalRefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaRefBuff().getOptionalRefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = getOrigAsSchemaRef().getSchema().getSchemaDefTableObj().readSchemaDefByIdIdx( getSchemaRefBuff().getOptionalRefSchemaTenantId(),
					getSchemaRefBuff().getOptionalRefSchemaId() );
				optionalLookupRefSchema = obj;
			}
		}
		return( optionalLookupRefSchema );
	}

	public void setOptionalLookupRefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getSchemaRefBuff();
			}
			if( value != null ) {
				getSchemaRefBuff().setOptionalRefSchemaTenantId( value.getRequiredTenantId() );
				getSchemaRefBuff().setOptionalRefSchemaId( value.getRequiredId() );
			}
			else {
				getSchemaRefBuff().setOptionalRefSchemaTenantId( null );
				getSchemaRefBuff().setOptionalRefSchemaId( null );
			}
			optionalLookupRefSchema = value;
	}

	public void copyBuffToOrig() {
		CFBamSchemaRefBuff origBuff = getOrigAsSchemaRef().getSchemaRefBuff();
		CFBamSchemaRefBuff myBuff = getSchemaRefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamSchemaRefBuff origBuff = getOrigAsSchemaRef().getSchemaRefBuff();
		CFBamSchemaRefBuff myBuff = getSchemaRefBuff();
		myBuff.set( origBuff );
	}
}
