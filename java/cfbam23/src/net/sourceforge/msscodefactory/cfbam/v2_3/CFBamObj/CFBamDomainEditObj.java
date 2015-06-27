// Description: Java7 edit object instance implementation for CFBam Domain.

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

public class CFBamDomainEditObj
	extends CFBamDomainBaseEditObj

	implements ICFBamDomainEditObj
{
	protected ICFBamDomainBaseObj requiredContainerParentDomain;

	public CFBamDomainEditObj( ICFBamDomainObj argOrig ) {
		super( argOrig );
		requiredContainerParentDomain = null;
	}

	public String getClassCode() {
		return( CFBamDomainObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Domain" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamDomainBaseObj scope = getRequiredContainerParentDomain();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamDomainBaseObj scope = getRequiredContainerParentDomain();
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
		ICFBamDomainObj retobj = getSchema().getDomainTableObj().realizeDomain( (ICFBamDomainObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsDomain().getSchema().getDomainTableObj().forgetDomain( getOrigAsDomain(), forgetSubObjects );
	}

	public ICFBamDomainBaseObj create() {
		copyBuffToOrig();
		ICFBamDomainObj retobj = getOrigAsDomain().getSchema().getDomainTableObj().createDomain( getOrigAsDomain() );
		if( retobj == getOrigAsDomain() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getDomainTableObj().updateDomain( (ICFBamDomainObj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getDomainTableObj().deleteDomain( getOrigAsDomain() );
	}

	public ICFBamDomainTableObj getDomainTable() {
		return( orig.getSchema().getDomainTableObj() );
	}

	public ICFBamDomainEditObj getEditAsDomain() {
		return( (ICFBamDomainEditObj)this );
	}

	public ICFBamDomainObj getOrigAsDomain() {
		return( (ICFBamDomainObj)orig );
	}

	public CFBamDomainBaseBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsDomain().getSchema().getBackingStore().getFactoryDomain().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamDomainBaseBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerParentDomain = null;
		}
	}

	public CFBamDomainBuff getDomainBuff() {
		return( (CFBamDomainBuff)getBuff() );
	}

	public long getRequiredSubDomainOfId() {
		return( getDomainBuff().getRequiredSubDomainOfId() );
	}

	public String getRequiredName() {
		return( getDomainBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getDomainBuff().getRequiredName() != value ) {
			getDomainBuff().setRequiredName( value );
		}
	}

	public ICFBamDomainBaseObj getRequiredContainerParentDomain() {
		return( getRequiredContainerParentDomain( false ) );
	}

	public ICFBamDomainBaseObj getRequiredContainerParentDomain( boolean forceRead ) {
		if( forceRead || ( requiredContainerParentDomain == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamDomainBaseObj obj = getOrigAsDomain().getSchema().getDomainBaseTableObj().readDomainBaseByIdIdx( getPKey().getRequiredTenantId(),
					getDomainBuff().getRequiredSubDomainOfId() );
				requiredContainerParentDomain = obj;
				if( obj != null ) {
					getDomainBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getDomainBuff().setRequiredSubDomainOfId( obj.getRequiredId() );
					requiredContainerParentDomain = obj;
				}
			}
		}
		return( requiredContainerParentDomain );
	}

	public void setRequiredContainerParentDomain( ICFBamDomainBaseObj value ) {
			if( buff == null ) {
				getDomainBuff();
			}
			requiredContainerParentDomain = null;
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getDomainBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getDomainBuff().setRequiredSubDomainOfId( value.getRequiredId() );
			}
			requiredContainerParentDomain = value;
	}

	public List<ICFBamTopProjectObj> getOptionalComponentsTopProject() {
		List<ICFBamTopProjectObj> retval;
		retval = getOrigAsDomain().getSchema().getTopProjectTableObj().readTopProjectByDomainIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamTopProjectObj> getOptionalComponentsTopProject( boolean forceRead ) {
		List<ICFBamTopProjectObj> retval;
		retval = getOrigAsDomain().getSchema().getTopProjectTableObj().readTopProjectByDomainIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamDomainBuff origBuff = getOrigAsDomain().getDomainBuff();
		CFBamDomainBuff myBuff = getDomainBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamDomainBuff origBuff = getOrigAsDomain().getDomainBuff();
		CFBamDomainBuff myBuff = getDomainBuff();
		myBuff.set( origBuff );
	}
}
