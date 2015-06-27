// Description: Java7 edit object instance implementation for CFBam DelSubDep1.

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

public class CFBamDelSubDep1EditObj
	extends CFBamDelDepEditObj

	implements ICFBamDelSubDep1EditObj
{
	protected ICFBamDelTopDepObj requiredContainerContDelTopDep;

	public CFBamDelSubDep1EditObj( ICFBamDelSubDep1Obj argOrig ) {
		super( argOrig );
		requiredContainerContDelTopDep = null;
	}

	public String getClassCode() {
		return( CFBamDelSubDep1Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "DelSubDep1" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamDelTopDepObj scope = getRequiredContainerContDelTopDep();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamDelTopDepObj scope = getRequiredContainerContDelTopDep();
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
		ICFBamDelSubDep1Obj retobj = getSchema().getDelSubDep1TableObj().realizeDelSubDep1( (ICFBamDelSubDep1Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsDelSubDep1().getSchema().getDelSubDep1TableObj().forgetDelSubDep1( getOrigAsDelSubDep1(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamDelSubDep1Obj retobj = getOrigAsDelSubDep1().getSchema().getDelSubDep1TableObj().createDelSubDep1( getOrigAsDelSubDep1() );
		if( retobj == getOrigAsDelSubDep1() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getDelSubDep1TableObj().updateDelSubDep1( (ICFBamDelSubDep1Obj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getDelSubDep1TableObj().deleteDelSubDep1( getOrigAsDelSubDep1() );
	}

	public ICFBamDelSubDep1TableObj getDelSubDep1Table() {
		return( orig.getSchema().getDelSubDep1TableObj() );
	}

	public ICFBamDelSubDep1EditObj getEditAsDelSubDep1() {
		return( (ICFBamDelSubDep1EditObj)this );
	}

	public ICFBamDelSubDep1Obj getOrigAsDelSubDep1() {
		return( (ICFBamDelSubDep1Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsDelSubDep1().getSchema().getBackingStore().getFactoryDelSubDep1().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerContDelTopDep = null;
		}
	}

	public CFBamDelSubDep1Buff getDelSubDep1Buff() {
		return( (CFBamDelSubDep1Buff)getBuff() );
	}

	public long getRequiredContTenantId() {
		return( getDelSubDep1Buff().getRequiredContTenantId() );
	}

	public long getRequiredContDelTopDepId() {
		return( getDelSubDep1Buff().getRequiredContDelTopDepId() );
	}

	public String getRequiredName() {
		return( getDelSubDep1Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getDelSubDep1Buff().getRequiredName() != value ) {
			getDelSubDep1Buff().setRequiredName( value );
		}
	}

	public ICFBamDelTopDepObj getRequiredContainerContDelTopDep() {
		return( getRequiredContainerContDelTopDep( false ) );
	}

	public ICFBamDelTopDepObj getRequiredContainerContDelTopDep( boolean forceRead ) {
		if( forceRead || ( requiredContainerContDelTopDep == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamDelTopDepObj obj = getOrigAsDelSubDep1().getSchema().getDelTopDepTableObj().readDelTopDepByIdIdx( getDelSubDep1Buff().getRequiredContTenantId(),
					getDelSubDep1Buff().getRequiredContDelTopDepId() );
				requiredContainerContDelTopDep = obj;
				if( obj != null ) {
					getDelSubDep1Buff().setRequiredContTenantId( obj.getRequiredTenantId() );
					getDelSubDep1Buff().setRequiredContDelTopDepId( obj.getRequiredId() );
					requiredContainerContDelTopDep = obj;
				}
			}
		}
		return( requiredContainerContDelTopDep );
	}

	public void setRequiredContainerContDelTopDep( ICFBamDelTopDepObj value ) {
			if( buff == null ) {
				getDelSubDep1Buff();
			}
			requiredContainerContDelTopDep = null;
			if( value != null ) {
				getDelSubDep1Buff().setRequiredContTenantId( value.getRequiredTenantId() );
				getDelSubDep1Buff().setRequiredContDelTopDepId( value.getRequiredId() );
			}
			requiredContainerContDelTopDep = value;
	}

	public List<ICFBamDelSubDep2Obj> getOptionalComponentsDelDep() {
		List<ICFBamDelSubDep2Obj> retval;
		retval = getOrigAsDelSubDep1().getSchema().getDelSubDep2TableObj().readDelSubDep2ByContDelDep1Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDelSubDep2Obj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<ICFBamDelSubDep2Obj> retval;
		retval = getOrigAsDelSubDep1().getSchema().getDelSubDep2TableObj().readDelSubDep2ByContDelDep1Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamDelSubDep1Buff origBuff = getOrigAsDelSubDep1().getDelSubDep1Buff();
		CFBamDelSubDep1Buff myBuff = getDelSubDep1Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamDelSubDep1Buff origBuff = getOrigAsDelSubDep1().getDelSubDep1Buff();
		CFBamDelSubDep1Buff myBuff = getDelSubDep1Buff();
		myBuff.set( origBuff );
	}
}
