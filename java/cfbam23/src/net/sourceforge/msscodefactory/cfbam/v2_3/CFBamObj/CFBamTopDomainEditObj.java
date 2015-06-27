// Description: Java7 edit object instance implementation for CFBam TopDomain.

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

public class CFBamTopDomainEditObj
	extends CFBamDomainBaseEditObj

	implements ICFBamTopDomainEditObj
{
	protected ICFBamTldObj requiredContainerTld;

	public CFBamTopDomainEditObj( ICFBamTopDomainObj argOrig ) {
		super( argOrig );
		requiredContainerTld = null;
	}

	public String getClassCode() {
		return( CFBamTopDomainObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TopDomain" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamTldObj scope = getRequiredContainerTld();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamTldObj scope = getRequiredContainerTld();
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
			subObj = getSchema().getSchemaDefTableObj().readSchemaDefByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = getSchema().getLicenseTableObj().readLicenseByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = getSchema().getDomainTableObj().readDomainByNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = getSchema().getTopProjectTableObj().readTopProjectByNameIdx( getRequiredTenantId(),
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

	public ICFBamDomainBaseObj realize() {
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamTopDomainObj retobj = getSchema().getTopDomainTableObj().realizeTopDomain( (ICFBamTopDomainObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsTopDomain().getSchema().getTopDomainTableObj().forgetTopDomain( getOrigAsTopDomain(), forgetSubObjects );
	}

	public ICFBamDomainBaseObj create() {
		copyBuffToOrig();
		ICFBamTopDomainObj retobj = getOrigAsTopDomain().getSchema().getTopDomainTableObj().createTopDomain( getOrigAsTopDomain() );
		if( retobj == getOrigAsTopDomain() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getTopDomainTableObj().updateTopDomain( (ICFBamTopDomainObj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getTopDomainTableObj().deleteTopDomain( getOrigAsTopDomain() );
	}

	public ICFBamTopDomainTableObj getTopDomainTable() {
		return( orig.getSchema().getTopDomainTableObj() );
	}

	public ICFBamTopDomainEditObj getEditAsTopDomain() {
		return( (ICFBamTopDomainEditObj)this );
	}

	public ICFBamTopDomainObj getOrigAsTopDomain() {
		return( (ICFBamTopDomainObj)orig );
	}

	public CFBamDomainBaseBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsTopDomain().getSchema().getBackingStore().getFactoryTopDomain().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamDomainBaseBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerTld = null;
		}
	}

	public CFBamTopDomainBuff getTopDomainBuff() {
		return( (CFBamTopDomainBuff)getBuff() );
	}

	public long getRequiredTldId() {
		return( getTopDomainBuff().getRequiredTldId() );
	}

	public String getRequiredName() {
		return( getTopDomainBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getTopDomainBuff().getRequiredName() != value ) {
			getTopDomainBuff().setRequiredName( value );
		}
	}

	public ICFBamTldObj getRequiredContainerTld() {
		return( getRequiredContainerTld( false ) );
	}

	public ICFBamTldObj getRequiredContainerTld( boolean forceRead ) {
		if( forceRead || ( requiredContainerTld == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTldObj obj = getOrigAsTopDomain().getSchema().getTldTableObj().readTldByIdIdx( getPKey().getRequiredTenantId(),
					getTopDomainBuff().getRequiredTldId() );
				requiredContainerTld = obj;
				if( obj != null ) {
					getTopDomainBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getTopDomainBuff().setRequiredTldId( obj.getRequiredTldId() );
					requiredContainerTld = obj;
				}
			}
		}
		return( requiredContainerTld );
	}

	public void setRequiredContainerTld( ICFBamTldObj value ) {
			if( buff == null ) {
				getTopDomainBuff();
			}
			requiredContainerTld = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getTopDomainBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getTopDomainBuff().setRequiredTldId( value.getRequiredTldId() );
			}
			requiredContainerTld = value;
	}

	public List<ICFBamDomainObj> getOptionalComponentsSubDomain() {
		List<ICFBamDomainObj> retval;
		retval = getOrigAsTopDomain().getSchema().getDomainTableObj().readDomainBySubDomIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDomainObj> getOptionalComponentsSubDomain( boolean forceRead ) {
		List<ICFBamDomainObj> retval;
		retval = getOrigAsTopDomain().getSchema().getDomainTableObj().readDomainBySubDomIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamTopProjectObj> getOptionalComponentsTopProject() {
		List<ICFBamTopProjectObj> retval;
		retval = getOrigAsTopDomain().getSchema().getTopProjectTableObj().readTopProjectByDomainIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamTopProjectObj> getOptionalComponentsTopProject( boolean forceRead ) {
		List<ICFBamTopProjectObj> retval;
		retval = getOrigAsTopDomain().getSchema().getTopProjectTableObj().readTopProjectByDomainIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamTopDomainBuff origBuff = getOrigAsTopDomain().getTopDomainBuff();
		CFBamTopDomainBuff myBuff = getTopDomainBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamTopDomainBuff origBuff = getOrigAsTopDomain().getTopDomainBuff();
		CFBamTopDomainBuff myBuff = getTopDomainBuff();
		myBuff.set( origBuff );
	}
}
