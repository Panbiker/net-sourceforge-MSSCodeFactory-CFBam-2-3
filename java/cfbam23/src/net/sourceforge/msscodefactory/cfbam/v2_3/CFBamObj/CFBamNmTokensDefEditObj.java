// Description: Java7 edit object instance implementation for CFBam NmTokensDef.

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

public class CFBamNmTokensDefEditObj
	extends CFBamAtomEditObj

	implements ICFBamNmTokensDefEditObj
{

	public CFBamNmTokensDefEditObj( ICFBamNmTokensDefObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFBamNmTokensDefObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "NmTokensDef" );
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

	public ICFBamValueObj realize() {
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamNmTokensDefObj retobj = getSchema().getNmTokensDefTableObj().realizeNmTokensDef( (ICFBamNmTokensDefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsNmTokensDef().getSchema().getNmTokensDefTableObj().forgetNmTokensDef( getOrigAsNmTokensDef(), forgetSubObjects );
	}

	public ICFBamValueObj moveUp() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
			"moveUp",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamValueObj moveDown() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
			"moveDown",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamValueObj create() {
		copyBuffToOrig();
		ICFBamNmTokensDefObj retobj = getOrigAsNmTokensDef().getSchema().getNmTokensDefTableObj().createNmTokensDef( getOrigAsNmTokensDef() );
		if( retobj == getOrigAsNmTokensDef() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getNmTokensDefTableObj().updateNmTokensDef( (ICFBamNmTokensDefObj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getNmTokensDefTableObj().deleteNmTokensDef( getOrigAsNmTokensDef() );
	}

	public ICFBamNmTokensDefTableObj getNmTokensDefTable() {
		return( orig.getSchema().getNmTokensDefTableObj() );
	}

	public ICFBamNmTokensDefEditObj getEditAsNmTokensDef() {
		return( (ICFBamNmTokensDefEditObj)this );
	}

	public ICFBamNmTokensDefObj getOrigAsNmTokensDef() {
		return( (ICFBamNmTokensDefObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsNmTokensDef().getSchema().getBackingStore().getFactoryNmTokensDef().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFBamNmTokensDefBuff getNmTokensDefBuff() {
		return( (CFBamNmTokensDefBuff)getBuff() );
	}

	public int getRequiredMaxLen() {
		return( getNmTokensDefBuff().getRequiredMaxLen() );
	}

	public void setRequiredMaxLen( int value ) {
		if( getNmTokensDefBuff().getRequiredMaxLen() != value ) {
			getNmTokensDefBuff().setRequiredMaxLen( value );
		}
	}

	public String getOptionalInitValue() {
		return( getNmTokensDefBuff().getOptionalInitValue() );
	}

	public void setOptionalInitValue( String value ) {
		if( getNmTokensDefBuff().getOptionalInitValue() != value ) {
			getNmTokensDefBuff().setOptionalInitValue( value );
		}
	}

	public String getOptionalDefaultValue() {
		return( getNmTokensDefBuff().getOptionalDefaultValue() );
	}

	public void setOptionalDefaultValue( String value ) {
		if( getNmTokensDefBuff().getOptionalDefaultValue() != value ) {
			getNmTokensDefBuff().setOptionalDefaultValue( value );
		}
	}

	public String getOptionalNullValue() {
		return( getNmTokensDefBuff().getOptionalNullValue() );
	}

	public void setOptionalNullValue( String value ) {
		if( getNmTokensDefBuff().getOptionalNullValue() != value ) {
			getNmTokensDefBuff().setOptionalNullValue( value );
		}
	}

	public String getOptionalUnknownValue() {
		return( getNmTokensDefBuff().getOptionalUnknownValue() );
	}

	public void setOptionalUnknownValue( String value ) {
		if( getNmTokensDefBuff().getOptionalUnknownValue() != value ) {
			getNmTokensDefBuff().setOptionalUnknownValue( value );
		}
	}

	public short getRequiredShowLines() {
		return( getNmTokensDefBuff().getRequiredShowLines() );
	}

	public void setRequiredShowLines( short value ) {
		if( getNmTokensDefBuff().getRequiredShowLines() != value ) {
			getNmTokensDefBuff().setRequiredShowLines( value );
		}
	}

	public void copyBuffToOrig() {
		CFBamNmTokensDefBuff origBuff = getOrigAsNmTokensDef().getNmTokensDefBuff();
		CFBamNmTokensDefBuff myBuff = getNmTokensDefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamNmTokensDefBuff origBuff = getOrigAsNmTokensDef().getNmTokensDefBuff();
		CFBamNmTokensDefBuff myBuff = getNmTokensDefBuff();
		myBuff.set( origBuff );
	}
}
