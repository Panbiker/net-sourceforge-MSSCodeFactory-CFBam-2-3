// Description: Java7 edit object instance implementation for CFBam ClearSubDep3.

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

public class CFBamClearSubDep3EditObj
	extends CFBamClearDepEditObj

	implements ICFBamClearSubDep3EditObj
{
	protected ICFBamClearSubDep2Obj requiredContainerContClearSubDep2;

	public CFBamClearSubDep3EditObj( ICFBamClearSubDep3Obj argOrig ) {
		super( argOrig );
		requiredContainerContClearSubDep2 = null;
	}

	public String getClassCode() {
		return( CFBamClearSubDep3Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ClearSubDep3" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamClearSubDep2Obj scope = getRequiredContainerContClearSubDep2();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamClearSubDep2Obj scope = getRequiredContainerContClearSubDep2();
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
		ICFBamClearSubDep3Obj retobj = getSchema().getClearSubDep3TableObj().realizeClearSubDep3( (ICFBamClearSubDep3Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsClearSubDep3().getSchema().getClearSubDep3TableObj().forgetClearSubDep3( getOrigAsClearSubDep3(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamClearSubDep3Obj retobj = getOrigAsClearSubDep3().getSchema().getClearSubDep3TableObj().createClearSubDep3( getOrigAsClearSubDep3() );
		if( retobj == getOrigAsClearSubDep3() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getClearSubDep3TableObj().updateClearSubDep3( (ICFBamClearSubDep3Obj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getClearSubDep3TableObj().deleteClearSubDep3( getOrigAsClearSubDep3() );
	}

	public ICFBamClearSubDep3TableObj getClearSubDep3Table() {
		return( orig.getSchema().getClearSubDep3TableObj() );
	}

	public ICFBamClearSubDep3EditObj getEditAsClearSubDep3() {
		return( (ICFBamClearSubDep3EditObj)this );
	}

	public ICFBamClearSubDep3Obj getOrigAsClearSubDep3() {
		return( (ICFBamClearSubDep3Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsClearSubDep3().getSchema().getBackingStore().getFactoryClearSubDep3().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerContClearSubDep2 = null;
		}
	}

	public CFBamClearSubDep3Buff getClearSubDep3Buff() {
		return( (CFBamClearSubDep3Buff)getBuff() );
	}

	public long getRequiredContClearDep2TenantId() {
		return( getClearSubDep3Buff().getRequiredContClearDep2TenantId() );
	}

	public long getRequiredContClearDep2Id() {
		return( getClearSubDep3Buff().getRequiredContClearDep2Id() );
	}

	public String getRequiredName() {
		return( getClearSubDep3Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getClearSubDep3Buff().getRequiredName() != value ) {
			getClearSubDep3Buff().setRequiredName( value );
		}
	}

	public ICFBamClearSubDep2Obj getRequiredContainerContClearSubDep2() {
		return( getRequiredContainerContClearSubDep2( false ) );
	}

	public ICFBamClearSubDep2Obj getRequiredContainerContClearSubDep2( boolean forceRead ) {
		if( forceRead || ( requiredContainerContClearSubDep2 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamClearSubDep2Obj obj = getOrigAsClearSubDep3().getSchema().getClearSubDep2TableObj().readClearSubDep2ByIdIdx( getClearSubDep3Buff().getRequiredContClearDep2TenantId(),
					getClearSubDep3Buff().getRequiredContClearDep2Id() );
				requiredContainerContClearSubDep2 = obj;
				if( obj != null ) {
					getClearSubDep3Buff().setRequiredContClearDep2TenantId( obj.getRequiredTenantId() );
					getClearSubDep3Buff().setRequiredContClearDep2Id( obj.getRequiredId() );
					requiredContainerContClearSubDep2 = obj;
				}
			}
		}
		return( requiredContainerContClearSubDep2 );
	}

	public void setRequiredContainerContClearSubDep2( ICFBamClearSubDep2Obj value ) {
			if( buff == null ) {
				getClearSubDep3Buff();
			}
			requiredContainerContClearSubDep2 = null;
			if( value != null ) {
				getClearSubDep3Buff().setRequiredContClearDep2TenantId( value.getRequiredTenantId() );
				getClearSubDep3Buff().setRequiredContClearDep2Id( value.getRequiredId() );
			}
			requiredContainerContClearSubDep2 = value;
	}

	public void copyBuffToOrig() {
		CFBamClearSubDep3Buff origBuff = getOrigAsClearSubDep3().getClearSubDep3Buff();
		CFBamClearSubDep3Buff myBuff = getClearSubDep3Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamClearSubDep3Buff origBuff = getOrigAsClearSubDep3().getClearSubDep3Buff();
		CFBamClearSubDep3Buff myBuff = getClearSubDep3Buff();
		myBuff.set( origBuff );
	}
}
