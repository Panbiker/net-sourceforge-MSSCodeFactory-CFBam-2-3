// Description: Java7 edit object instance implementation for CFBam PopSubDep3.

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

public class CFBamPopSubDep3EditObj
	extends CFBamPopDepEditObj

	implements ICFBamPopSubDep3EditObj
{
	protected ICFBamPopSubDep2Obj requiredContainerContPopSubDep2;

	public CFBamPopSubDep3EditObj( ICFBamPopSubDep3Obj argOrig ) {
		super( argOrig );
		requiredContainerContPopSubDep2 = null;
	}

	public String getClassCode() {
		return( CFBamPopSubDep3Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "PopSubDep3" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamPopSubDep2Obj scope = getRequiredContainerContPopSubDep2();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamPopSubDep2Obj scope = getRequiredContainerContPopSubDep2();
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
		ICFBamPopSubDep3Obj retobj = getSchema().getPopSubDep3TableObj().realizePopSubDep3( (ICFBamPopSubDep3Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsPopSubDep3().getSchema().getPopSubDep3TableObj().forgetPopSubDep3( getOrigAsPopSubDep3(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamPopSubDep3Obj retobj = getOrigAsPopSubDep3().getSchema().getPopSubDep3TableObj().createPopSubDep3( getOrigAsPopSubDep3() );
		if( retobj == getOrigAsPopSubDep3() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getPopSubDep3TableObj().updatePopSubDep3( (ICFBamPopSubDep3Obj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getPopSubDep3TableObj().deletePopSubDep3( getOrigAsPopSubDep3() );
	}

	public ICFBamPopSubDep3TableObj getPopSubDep3Table() {
		return( orig.getSchema().getPopSubDep3TableObj() );
	}

	public ICFBamPopSubDep3EditObj getEditAsPopSubDep3() {
		return( (ICFBamPopSubDep3EditObj)this );
	}

	public ICFBamPopSubDep3Obj getOrigAsPopSubDep3() {
		return( (ICFBamPopSubDep3Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsPopSubDep3().getSchema().getBackingStore().getFactoryPopSubDep3().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerContPopSubDep2 = null;
		}
	}

	public CFBamPopSubDep3Buff getPopSubDep3Buff() {
		return( (CFBamPopSubDep3Buff)getBuff() );
	}

	public long getRequiredContTenantId() {
		return( getPopSubDep3Buff().getRequiredContTenantId() );
	}

	public long getRequiredContPopDep2Id() {
		return( getPopSubDep3Buff().getRequiredContPopDep2Id() );
	}

	public String getRequiredName() {
		return( getPopSubDep3Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getPopSubDep3Buff().getRequiredName() != value ) {
			getPopSubDep3Buff().setRequiredName( value );
		}
	}

	public ICFBamPopSubDep2Obj getRequiredContainerContPopSubDep2() {
		return( getRequiredContainerContPopSubDep2( false ) );
	}

	public ICFBamPopSubDep2Obj getRequiredContainerContPopSubDep2( boolean forceRead ) {
		if( forceRead || ( requiredContainerContPopSubDep2 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamPopSubDep2Obj obj = getOrigAsPopSubDep3().getSchema().getPopSubDep2TableObj().readPopSubDep2ByIdIdx( getPopSubDep3Buff().getRequiredContTenantId(),
					getPopSubDep3Buff().getRequiredContPopDep2Id() );
				requiredContainerContPopSubDep2 = obj;
				if( obj != null ) {
					getPopSubDep3Buff().setRequiredContTenantId( obj.getRequiredTenantId() );
					getPopSubDep3Buff().setRequiredContPopDep2Id( obj.getRequiredId() );
					requiredContainerContPopSubDep2 = obj;
				}
			}
		}
		return( requiredContainerContPopSubDep2 );
	}

	public void setRequiredContainerContPopSubDep2( ICFBamPopSubDep2Obj value ) {
			if( buff == null ) {
				getPopSubDep3Buff();
			}
			requiredContainerContPopSubDep2 = null;
			if( value != null ) {
				getPopSubDep3Buff().setRequiredContTenantId( value.getRequiredTenantId() );
				getPopSubDep3Buff().setRequiredContPopDep2Id( value.getRequiredId() );
			}
			requiredContainerContPopSubDep2 = value;
	}

	public void copyBuffToOrig() {
		CFBamPopSubDep3Buff origBuff = getOrigAsPopSubDep3().getPopSubDep3Buff();
		CFBamPopSubDep3Buff myBuff = getPopSubDep3Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamPopSubDep3Buff origBuff = getOrigAsPopSubDep3().getPopSubDep3Buff();
		CFBamPopSubDep3Buff myBuff = getPopSubDep3Buff();
		myBuff.set( origBuff );
	}
}
