// Description: Java7 edit object instance implementation for CFBam DelSubDep3.

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

public class CFBamDelSubDep3EditObj
	extends CFBamDelDepEditObj

	implements ICFBamDelSubDep3EditObj
{
	protected ICFBamDelSubDep2Obj requiredContainerContDelSubDep2;

	public CFBamDelSubDep3EditObj( ICFBamDelSubDep3Obj argOrig ) {
		super( argOrig );
		requiredContainerContDelSubDep2 = null;
	}

	public String getClassCode() {
		return( CFBamDelSubDep3Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "DelSubDep3" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamDelSubDep2Obj scope = getRequiredContainerContDelSubDep2();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamDelSubDep2Obj scope = getRequiredContainerContDelSubDep2();
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
		ICFBamDelSubDep3Obj retobj = getSchema().getDelSubDep3TableObj().realizeDelSubDep3( (ICFBamDelSubDep3Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsDelSubDep3().getSchema().getDelSubDep3TableObj().forgetDelSubDep3( getOrigAsDelSubDep3(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamDelSubDep3Obj retobj = getOrigAsDelSubDep3().getSchema().getDelSubDep3TableObj().createDelSubDep3( getOrigAsDelSubDep3() );
		if( retobj == getOrigAsDelSubDep3() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getDelSubDep3TableObj().updateDelSubDep3( (ICFBamDelSubDep3Obj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getDelSubDep3TableObj().deleteDelSubDep3( getOrigAsDelSubDep3() );
	}

	public ICFBamDelSubDep3TableObj getDelSubDep3Table() {
		return( orig.getSchema().getDelSubDep3TableObj() );
	}

	public ICFBamDelSubDep3EditObj getEditAsDelSubDep3() {
		return( (ICFBamDelSubDep3EditObj)this );
	}

	public ICFBamDelSubDep3Obj getOrigAsDelSubDep3() {
		return( (ICFBamDelSubDep3Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsDelSubDep3().getSchema().getBackingStore().getFactoryDelSubDep3().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerContDelSubDep2 = null;
		}
	}

	public CFBamDelSubDep3Buff getDelSubDep3Buff() {
		return( (CFBamDelSubDep3Buff)getBuff() );
	}

	public long getRequiredContTenantId() {
		return( getDelSubDep3Buff().getRequiredContTenantId() );
	}

	public long getRequiredContDelDep2Id() {
		return( getDelSubDep3Buff().getRequiredContDelDep2Id() );
	}

	public String getRequiredName() {
		return( getDelSubDep3Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getDelSubDep3Buff().getRequiredName() != value ) {
			getDelSubDep3Buff().setRequiredName( value );
		}
	}

	public ICFBamDelSubDep2Obj getRequiredContainerContDelSubDep2() {
		return( getRequiredContainerContDelSubDep2( false ) );
	}

	public ICFBamDelSubDep2Obj getRequiredContainerContDelSubDep2( boolean forceRead ) {
		if( forceRead || ( requiredContainerContDelSubDep2 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamDelSubDep2Obj obj = getOrigAsDelSubDep3().getSchema().getDelSubDep2TableObj().readDelSubDep2ByIdIdx( getDelSubDep3Buff().getRequiredContTenantId(),
					getDelSubDep3Buff().getRequiredContDelDep2Id() );
				requiredContainerContDelSubDep2 = obj;
				if( obj != null ) {
					getDelSubDep3Buff().setRequiredContTenantId( obj.getRequiredTenantId() );
					getDelSubDep3Buff().setRequiredContDelDep2Id( obj.getRequiredId() );
					requiredContainerContDelSubDep2 = obj;
				}
			}
		}
		return( requiredContainerContDelSubDep2 );
	}

	public void setRequiredContainerContDelSubDep2( ICFBamDelSubDep2Obj value ) {
			if( buff == null ) {
				getDelSubDep3Buff();
			}
			requiredContainerContDelSubDep2 = null;
			if( value != null ) {
				getDelSubDep3Buff().setRequiredContTenantId( value.getRequiredTenantId() );
				getDelSubDep3Buff().setRequiredContDelDep2Id( value.getRequiredId() );
			}
			requiredContainerContDelSubDep2 = value;
	}

	public void copyBuffToOrig() {
		CFBamDelSubDep3Buff origBuff = getOrigAsDelSubDep3().getDelSubDep3Buff();
		CFBamDelSubDep3Buff myBuff = getDelSubDep3Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamDelSubDep3Buff origBuff = getOrigAsDelSubDep3().getDelSubDep3Buff();
		CFBamDelSubDep3Buff myBuff = getDelSubDep3Buff();
		myBuff.set( origBuff );
	}
}
