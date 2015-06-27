// Description: Java7 edit object instance implementation for CFBam ClearSubDep2.

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

public class CFBamClearSubDep2EditObj
	extends CFBamClearDepEditObj

	implements ICFBamClearSubDep2EditObj
{
	protected ICFBamClearSubDep1Obj requiredContainerContClearSubDep1;

	public CFBamClearSubDep2EditObj( ICFBamClearSubDep2Obj argOrig ) {
		super( argOrig );
		requiredContainerContClearSubDep1 = null;
	}

	public String getClassCode() {
		return( CFBamClearSubDep2Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ClearSubDep2" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamClearSubDep1Obj scope = getRequiredContainerContClearSubDep1();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamClearSubDep1Obj scope = getRequiredContainerContClearSubDep1();
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
		ICFBamClearSubDep2Obj retobj = getSchema().getClearSubDep2TableObj().realizeClearSubDep2( (ICFBamClearSubDep2Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsClearSubDep2().getSchema().getClearSubDep2TableObj().forgetClearSubDep2( getOrigAsClearSubDep2(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamClearSubDep2Obj retobj = getOrigAsClearSubDep2().getSchema().getClearSubDep2TableObj().createClearSubDep2( getOrigAsClearSubDep2() );
		if( retobj == getOrigAsClearSubDep2() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getClearSubDep2TableObj().updateClearSubDep2( (ICFBamClearSubDep2Obj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getClearSubDep2TableObj().deleteClearSubDep2( getOrigAsClearSubDep2() );
	}

	public ICFBamClearSubDep2TableObj getClearSubDep2Table() {
		return( orig.getSchema().getClearSubDep2TableObj() );
	}

	public ICFBamClearSubDep2EditObj getEditAsClearSubDep2() {
		return( (ICFBamClearSubDep2EditObj)this );
	}

	public ICFBamClearSubDep2Obj getOrigAsClearSubDep2() {
		return( (ICFBamClearSubDep2Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsClearSubDep2().getSchema().getBackingStore().getFactoryClearSubDep2().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerContClearSubDep1 = null;
		}
	}

	public CFBamClearSubDep2Buff getClearSubDep2Buff() {
		return( (CFBamClearSubDep2Buff)getBuff() );
	}

	public long getRequiredContClearDep1TenantId() {
		return( getClearSubDep2Buff().getRequiredContClearDep1TenantId() );
	}

	public long getRequiredContClearDep1Id() {
		return( getClearSubDep2Buff().getRequiredContClearDep1Id() );
	}

	public String getRequiredName() {
		return( getClearSubDep2Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getClearSubDep2Buff().getRequiredName() != value ) {
			getClearSubDep2Buff().setRequiredName( value );
		}
	}

	public ICFBamClearSubDep1Obj getRequiredContainerContClearSubDep1() {
		return( getRequiredContainerContClearSubDep1( false ) );
	}

	public ICFBamClearSubDep1Obj getRequiredContainerContClearSubDep1( boolean forceRead ) {
		if( forceRead || ( requiredContainerContClearSubDep1 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamClearSubDep1Obj obj = getOrigAsClearSubDep2().getSchema().getClearSubDep1TableObj().readClearSubDep1ByIdIdx( getClearSubDep2Buff().getRequiredContClearDep1TenantId(),
					getClearSubDep2Buff().getRequiredContClearDep1Id() );
				requiredContainerContClearSubDep1 = obj;
				if( obj != null ) {
					getClearSubDep2Buff().setRequiredContClearDep1TenantId( obj.getRequiredTenantId() );
					getClearSubDep2Buff().setRequiredContClearDep1Id( obj.getRequiredId() );
					requiredContainerContClearSubDep1 = obj;
				}
			}
		}
		return( requiredContainerContClearSubDep1 );
	}

	public void setRequiredContainerContClearSubDep1( ICFBamClearSubDep1Obj value ) {
			if( buff == null ) {
				getClearSubDep2Buff();
			}
			requiredContainerContClearSubDep1 = null;
			if( value != null ) {
				getClearSubDep2Buff().setRequiredContClearDep1TenantId( value.getRequiredTenantId() );
				getClearSubDep2Buff().setRequiredContClearDep1Id( value.getRequiredId() );
			}
			requiredContainerContClearSubDep1 = value;
	}

	public List<ICFBamClearSubDep3Obj> getOptionalComponentsClearDep() {
		List<ICFBamClearSubDep3Obj> retval;
		retval = getOrigAsClearSubDep2().getSchema().getClearSubDep3TableObj().readClearSubDep3ByContClearDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamClearSubDep3Obj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<ICFBamClearSubDep3Obj> retval;
		retval = getOrigAsClearSubDep2().getSchema().getClearSubDep3TableObj().readClearSubDep3ByContClearDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamClearSubDep2Buff origBuff = getOrigAsClearSubDep2().getClearSubDep2Buff();
		CFBamClearSubDep2Buff myBuff = getClearSubDep2Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamClearSubDep2Buff origBuff = getOrigAsClearSubDep2().getClearSubDep2Buff();
		CFBamClearSubDep2Buff myBuff = getClearSubDep2Buff();
		myBuff.set( origBuff );
	}
}
