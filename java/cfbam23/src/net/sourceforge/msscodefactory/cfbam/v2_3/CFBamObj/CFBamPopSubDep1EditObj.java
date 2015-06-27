// Description: Java7 edit object instance implementation for CFBam PopSubDep1.

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

public class CFBamPopSubDep1EditObj
	extends CFBamPopDepEditObj

	implements ICFBamPopSubDep1EditObj
{
	protected ICFBamPopTopDepObj requiredContainerContPopTopDep;

	public CFBamPopSubDep1EditObj( ICFBamPopSubDep1Obj argOrig ) {
		super( argOrig );
		requiredContainerContPopTopDep = null;
	}

	public String getClassCode() {
		return( CFBamPopSubDep1Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "PopSubDep1" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamPopTopDepObj scope = getRequiredContainerContPopTopDep();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamPopTopDepObj scope = getRequiredContainerContPopTopDep();
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
		ICFBamPopSubDep1Obj retobj = getSchema().getPopSubDep1TableObj().realizePopSubDep1( (ICFBamPopSubDep1Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsPopSubDep1().getSchema().getPopSubDep1TableObj().forgetPopSubDep1( getOrigAsPopSubDep1(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamPopSubDep1Obj retobj = getOrigAsPopSubDep1().getSchema().getPopSubDep1TableObj().createPopSubDep1( getOrigAsPopSubDep1() );
		if( retobj == getOrigAsPopSubDep1() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getPopSubDep1TableObj().updatePopSubDep1( (ICFBamPopSubDep1Obj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getPopSubDep1TableObj().deletePopSubDep1( getOrigAsPopSubDep1() );
	}

	public ICFBamPopSubDep1TableObj getPopSubDep1Table() {
		return( orig.getSchema().getPopSubDep1TableObj() );
	}

	public ICFBamPopSubDep1EditObj getEditAsPopSubDep1() {
		return( (ICFBamPopSubDep1EditObj)this );
	}

	public ICFBamPopSubDep1Obj getOrigAsPopSubDep1() {
		return( (ICFBamPopSubDep1Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsPopSubDep1().getSchema().getBackingStore().getFactoryPopSubDep1().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerContPopTopDep = null;
		}
	}

	public CFBamPopSubDep1Buff getPopSubDep1Buff() {
		return( (CFBamPopSubDep1Buff)getBuff() );
	}

	public long getRequiredContTenantId() {
		return( getPopSubDep1Buff().getRequiredContTenantId() );
	}

	public long getRequiredContPopTopDepId() {
		return( getPopSubDep1Buff().getRequiredContPopTopDepId() );
	}

	public String getRequiredName() {
		return( getPopSubDep1Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getPopSubDep1Buff().getRequiredName() != value ) {
			getPopSubDep1Buff().setRequiredName( value );
		}
	}

	public ICFBamPopTopDepObj getRequiredContainerContPopTopDep() {
		return( getRequiredContainerContPopTopDep( false ) );
	}

	public ICFBamPopTopDepObj getRequiredContainerContPopTopDep( boolean forceRead ) {
		if( forceRead || ( requiredContainerContPopTopDep == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamPopTopDepObj obj = getOrigAsPopSubDep1().getSchema().getPopTopDepTableObj().readPopTopDepByIdIdx( getPopSubDep1Buff().getRequiredContTenantId(),
					getPopSubDep1Buff().getRequiredContPopTopDepId() );
				requiredContainerContPopTopDep = obj;
				if( obj != null ) {
					getPopSubDep1Buff().setRequiredContTenantId( obj.getRequiredTenantId() );
					getPopSubDep1Buff().setRequiredContPopTopDepId( obj.getRequiredId() );
					requiredContainerContPopTopDep = obj;
				}
			}
		}
		return( requiredContainerContPopTopDep );
	}

	public void setRequiredContainerContPopTopDep( ICFBamPopTopDepObj value ) {
			if( buff == null ) {
				getPopSubDep1Buff();
			}
			requiredContainerContPopTopDep = null;
			if( value != null ) {
				getPopSubDep1Buff().setRequiredContTenantId( value.getRequiredTenantId() );
				getPopSubDep1Buff().setRequiredContPopTopDepId( value.getRequiredId() );
			}
			requiredContainerContPopTopDep = value;
	}

	public List<ICFBamPopSubDep2Obj> getOptionalComponentsPopDep() {
		List<ICFBamPopSubDep2Obj> retval;
		retval = getOrigAsPopSubDep1().getSchema().getPopSubDep2TableObj().readPopSubDep2ByContPopDep1Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamPopSubDep2Obj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<ICFBamPopSubDep2Obj> retval;
		retval = getOrigAsPopSubDep1().getSchema().getPopSubDep2TableObj().readPopSubDep2ByContPopDep1Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamPopSubDep1Buff origBuff = getOrigAsPopSubDep1().getPopSubDep1Buff();
		CFBamPopSubDep1Buff myBuff = getPopSubDep1Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamPopSubDep1Buff origBuff = getOrigAsPopSubDep1().getPopSubDep1Buff();
		CFBamPopSubDep1Buff myBuff = getPopSubDep1Buff();
		myBuff.set( origBuff );
	}
}
