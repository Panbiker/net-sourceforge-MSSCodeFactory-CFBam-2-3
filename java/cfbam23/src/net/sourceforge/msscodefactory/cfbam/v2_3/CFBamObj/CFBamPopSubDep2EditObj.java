// Description: Java7 edit object instance implementation for CFBam PopSubDep2.

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

public class CFBamPopSubDep2EditObj
	extends CFBamPopDepEditObj

	implements ICFBamPopSubDep2EditObj
{
	protected ICFBamPopSubDep1Obj requiredContainerContPopSubDep1;

	public CFBamPopSubDep2EditObj( ICFBamPopSubDep2Obj argOrig ) {
		super( argOrig );
		requiredContainerContPopSubDep1 = null;
	}

	public String getClassCode() {
		return( CFBamPopSubDep2Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "PopSubDep2" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamPopSubDep1Obj scope = getRequiredContainerContPopSubDep1();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamPopSubDep1Obj scope = getRequiredContainerContPopSubDep1();
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
		ICFBamPopSubDep2Obj retobj = getSchema().getPopSubDep2TableObj().realizePopSubDep2( (ICFBamPopSubDep2Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsPopSubDep2().getSchema().getPopSubDep2TableObj().forgetPopSubDep2( getOrigAsPopSubDep2(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamPopSubDep2Obj retobj = getOrigAsPopSubDep2().getSchema().getPopSubDep2TableObj().createPopSubDep2( getOrigAsPopSubDep2() );
		if( retobj == getOrigAsPopSubDep2() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getPopSubDep2TableObj().updatePopSubDep2( (ICFBamPopSubDep2Obj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getPopSubDep2TableObj().deletePopSubDep2( getOrigAsPopSubDep2() );
	}

	public ICFBamPopSubDep2TableObj getPopSubDep2Table() {
		return( orig.getSchema().getPopSubDep2TableObj() );
	}

	public ICFBamPopSubDep2EditObj getEditAsPopSubDep2() {
		return( (ICFBamPopSubDep2EditObj)this );
	}

	public ICFBamPopSubDep2Obj getOrigAsPopSubDep2() {
		return( (ICFBamPopSubDep2Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsPopSubDep2().getSchema().getBackingStore().getFactoryPopSubDep2().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerContPopSubDep1 = null;
		}
	}

	public CFBamPopSubDep2Buff getPopSubDep2Buff() {
		return( (CFBamPopSubDep2Buff)getBuff() );
	}

	public long getRequiredContTenantId() {
		return( getPopSubDep2Buff().getRequiredContTenantId() );
	}

	public long getRequiredContPopDep1Id() {
		return( getPopSubDep2Buff().getRequiredContPopDep1Id() );
	}

	public String getRequiredName() {
		return( getPopSubDep2Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getPopSubDep2Buff().getRequiredName() != value ) {
			getPopSubDep2Buff().setRequiredName( value );
		}
	}

	public ICFBamPopSubDep1Obj getRequiredContainerContPopSubDep1() {
		return( getRequiredContainerContPopSubDep1( false ) );
	}

	public ICFBamPopSubDep1Obj getRequiredContainerContPopSubDep1( boolean forceRead ) {
		if( forceRead || ( requiredContainerContPopSubDep1 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamPopSubDep1Obj obj = getOrigAsPopSubDep2().getSchema().getPopSubDep1TableObj().readPopSubDep1ByIdIdx( getPopSubDep2Buff().getRequiredContTenantId(),
					getPopSubDep2Buff().getRequiredContPopDep1Id() );
				requiredContainerContPopSubDep1 = obj;
				if( obj != null ) {
					getPopSubDep2Buff().setRequiredContTenantId( obj.getRequiredTenantId() );
					getPopSubDep2Buff().setRequiredContPopDep1Id( obj.getRequiredId() );
					requiredContainerContPopSubDep1 = obj;
				}
			}
		}
		return( requiredContainerContPopSubDep1 );
	}

	public void setRequiredContainerContPopSubDep1( ICFBamPopSubDep1Obj value ) {
			if( buff == null ) {
				getPopSubDep2Buff();
			}
			requiredContainerContPopSubDep1 = null;
			if( value != null ) {
				getPopSubDep2Buff().setRequiredContTenantId( value.getRequiredTenantId() );
				getPopSubDep2Buff().setRequiredContPopDep1Id( value.getRequiredId() );
			}
			requiredContainerContPopSubDep1 = value;
	}

	public List<ICFBamPopSubDep3Obj> getOptionalComponentsPopDep() {
		List<ICFBamPopSubDep3Obj> retval;
		retval = getOrigAsPopSubDep2().getSchema().getPopSubDep3TableObj().readPopSubDep3ByContPopDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamPopSubDep3Obj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<ICFBamPopSubDep3Obj> retval;
		retval = getOrigAsPopSubDep2().getSchema().getPopSubDep3TableObj().readPopSubDep3ByContPopDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamPopSubDep2Buff origBuff = getOrigAsPopSubDep2().getPopSubDep2Buff();
		CFBamPopSubDep2Buff myBuff = getPopSubDep2Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamPopSubDep2Buff origBuff = getOrigAsPopSubDep2().getPopSubDep2Buff();
		CFBamPopSubDep2Buff myBuff = getPopSubDep2Buff();
		myBuff.set( origBuff );
	}
}
