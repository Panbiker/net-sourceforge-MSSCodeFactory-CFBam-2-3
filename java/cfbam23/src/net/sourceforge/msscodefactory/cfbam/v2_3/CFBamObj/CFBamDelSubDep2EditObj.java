// Description: Java7 edit object instance implementation for CFBam DelSubDep2.

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

public class CFBamDelSubDep2EditObj
	extends CFBamDelDepEditObj

	implements ICFBamDelSubDep2EditObj
{
	protected ICFBamDelSubDep1Obj requiredContainerContDelSubDep1;

	public CFBamDelSubDep2EditObj( ICFBamDelSubDep2Obj argOrig ) {
		super( argOrig );
		requiredContainerContDelSubDep1 = null;
	}

	public String getClassCode() {
		return( CFBamDelSubDep2Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "DelSubDep2" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamDelSubDep1Obj scope = getRequiredContainerContDelSubDep1();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamDelSubDep1Obj scope = getRequiredContainerContDelSubDep1();
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
		ICFBamDelSubDep2Obj retobj = getSchema().getDelSubDep2TableObj().realizeDelSubDep2( (ICFBamDelSubDep2Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsDelSubDep2().getSchema().getDelSubDep2TableObj().forgetDelSubDep2( getOrigAsDelSubDep2(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamDelSubDep2Obj retobj = getOrigAsDelSubDep2().getSchema().getDelSubDep2TableObj().createDelSubDep2( getOrigAsDelSubDep2() );
		if( retobj == getOrigAsDelSubDep2() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getDelSubDep2TableObj().updateDelSubDep2( (ICFBamDelSubDep2Obj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getDelSubDep2TableObj().deleteDelSubDep2( getOrigAsDelSubDep2() );
	}

	public ICFBamDelSubDep2TableObj getDelSubDep2Table() {
		return( orig.getSchema().getDelSubDep2TableObj() );
	}

	public ICFBamDelSubDep2EditObj getEditAsDelSubDep2() {
		return( (ICFBamDelSubDep2EditObj)this );
	}

	public ICFBamDelSubDep2Obj getOrigAsDelSubDep2() {
		return( (ICFBamDelSubDep2Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsDelSubDep2().getSchema().getBackingStore().getFactoryDelSubDep2().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerContDelSubDep1 = null;
		}
	}

	public CFBamDelSubDep2Buff getDelSubDep2Buff() {
		return( (CFBamDelSubDep2Buff)getBuff() );
	}

	public long getRequiredContTenantId() {
		return( getDelSubDep2Buff().getRequiredContTenantId() );
	}

	public long getRequiredContDelDep1Id() {
		return( getDelSubDep2Buff().getRequiredContDelDep1Id() );
	}

	public String getRequiredName() {
		return( getDelSubDep2Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getDelSubDep2Buff().getRequiredName() != value ) {
			getDelSubDep2Buff().setRequiredName( value );
		}
	}

	public ICFBamDelSubDep1Obj getRequiredContainerContDelSubDep1() {
		return( getRequiredContainerContDelSubDep1( false ) );
	}

	public ICFBamDelSubDep1Obj getRequiredContainerContDelSubDep1( boolean forceRead ) {
		if( forceRead || ( requiredContainerContDelSubDep1 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamDelSubDep1Obj obj = getOrigAsDelSubDep2().getSchema().getDelSubDep1TableObj().readDelSubDep1ByIdIdx( getDelSubDep2Buff().getRequiredContTenantId(),
					getDelSubDep2Buff().getRequiredContDelDep1Id() );
				requiredContainerContDelSubDep1 = obj;
				if( obj != null ) {
					getDelSubDep2Buff().setRequiredContTenantId( obj.getRequiredTenantId() );
					getDelSubDep2Buff().setRequiredContDelDep1Id( obj.getRequiredId() );
					requiredContainerContDelSubDep1 = obj;
				}
			}
		}
		return( requiredContainerContDelSubDep1 );
	}

	public void setRequiredContainerContDelSubDep1( ICFBamDelSubDep1Obj value ) {
			if( buff == null ) {
				getDelSubDep2Buff();
			}
			requiredContainerContDelSubDep1 = null;
			if( value != null ) {
				getDelSubDep2Buff().setRequiredContTenantId( value.getRequiredTenantId() );
				getDelSubDep2Buff().setRequiredContDelDep1Id( value.getRequiredId() );
			}
			requiredContainerContDelSubDep1 = value;
	}

	public List<ICFBamDelSubDep3Obj> getOptionalComponentsDelDep() {
		List<ICFBamDelSubDep3Obj> retval;
		retval = getOrigAsDelSubDep2().getSchema().getDelSubDep3TableObj().readDelSubDep3ByContDelDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDelSubDep3Obj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<ICFBamDelSubDep3Obj> retval;
		retval = getOrigAsDelSubDep2().getSchema().getDelSubDep3TableObj().readDelSubDep3ByContDelDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamDelSubDep2Buff origBuff = getOrigAsDelSubDep2().getDelSubDep2Buff();
		CFBamDelSubDep2Buff myBuff = getDelSubDep2Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamDelSubDep2Buff origBuff = getOrigAsDelSubDep2().getDelSubDep2Buff();
		CFBamDelSubDep2Buff myBuff = getDelSubDep2Buff();
		myBuff.set( origBuff );
	}
}
