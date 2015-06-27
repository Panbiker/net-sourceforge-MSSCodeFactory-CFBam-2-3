// Description: Java7 edit object instance implementation for CFBam Id64Gen.

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

public class CFBamId64GenEditObj
	extends CFBamInt64TypeEditObj

	implements ICFBamId64GenEditObj
{
	protected ICFBamTableObj optionalLookupDispenser;

	public CFBamId64GenEditObj( ICFBamId64GenObj argOrig ) {
		super( argOrig );
		optionalLookupDispenser = null;
	}

	public String getClassCode() {
		return( CFBamId64GenObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Id64Gen" );
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
		ICFBamId64GenObj retobj = getSchema().getId64GenTableObj().realizeId64Gen( (ICFBamId64GenObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsId64Gen().getSchema().getId64GenTableObj().forgetId64Gen( getOrigAsId64Gen(), forgetSubObjects );
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
		ICFBamId64GenObj retobj = getOrigAsId64Gen().getSchema().getId64GenTableObj().createId64Gen( getOrigAsId64Gen() );
		if( retobj == getOrigAsId64Gen() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getId64GenTableObj().updateId64Gen( (ICFBamId64GenObj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getId64GenTableObj().deleteId64Gen( getOrigAsId64Gen() );
	}

	public ICFBamId64GenTableObj getId64GenTable() {
		return( orig.getSchema().getId64GenTableObj() );
	}

	public ICFBamId64GenEditObj getEditAsId64Gen() {
		return( (ICFBamId64GenEditObj)this );
	}

	public ICFBamId64GenObj getOrigAsId64Gen() {
		return( (ICFBamId64GenObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsId64Gen().getSchema().getBackingStore().getFactoryId64Gen().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			optionalLookupDispenser = null;
		}
	}

	public CFBamId64GenBuff getId64GenBuff() {
		return( (CFBamId64GenBuff)getBuff() );
	}

	public Long getOptionalDispenserTenantId() {
		return( getId64GenBuff().getOptionalDispenserTenantId() );
	}

	public Long getOptionalDispenserId() {
		return( getId64GenBuff().getOptionalDispenserId() );
	}

	public short getRequiredSlice() {
		return( getId64GenBuff().getRequiredSlice() );
	}

	public void setRequiredSlice( short value ) {
		if( getId64GenBuff().getRequiredSlice() != value ) {
			getId64GenBuff().setRequiredSlice( value );
		}
	}

	public long getRequiredBlockSize() {
		return( getId64GenBuff().getRequiredBlockSize() );
	}

	public void setRequiredBlockSize( long value ) {
		if( getId64GenBuff().getRequiredBlockSize() != value ) {
			getId64GenBuff().setRequiredBlockSize( value );
		}
	}

	public ICFBamTableObj getOptionalLookupDispenser() {
		return( getOptionalLookupDispenser( false ) );
	}

	public ICFBamTableObj getOptionalLookupDispenser( boolean forceRead ) {
		if( forceRead || ( optionalLookupDispenser == null ) ) {
			boolean anyMissing = false;
			if( getId64GenBuff().getOptionalDispenserTenantId() == null ) {
				anyMissing = true;
			}
			if( getId64GenBuff().getOptionalDispenserId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamTableObj obj = getOrigAsId64Gen().getSchema().getTableTableObj().readTableByIdIdx( getId64GenBuff().getOptionalDispenserTenantId(),
					getId64GenBuff().getOptionalDispenserId() );
				optionalLookupDispenser = obj;
			}
		}
		return( optionalLookupDispenser );
	}

	public void setOptionalLookupDispenser( ICFBamTableObj value ) {
			if( buff == null ) {
				getId64GenBuff();
			}
			if( value != null ) {
				getId64GenBuff().setOptionalDispenserTenantId( value.getRequiredTenantId() );
				getId64GenBuff().setOptionalDispenserId( value.getRequiredId() );
			}
			else {
				getId64GenBuff().setOptionalDispenserTenantId( null );
				getId64GenBuff().setOptionalDispenserId( null );
			}
			optionalLookupDispenser = value;
	}

	public void copyBuffToOrig() {
		CFBamId64GenBuff origBuff = getOrigAsId64Gen().getId64GenBuff();
		CFBamId64GenBuff myBuff = getId64GenBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamId64GenBuff origBuff = getOrigAsId64Gen().getId64GenBuff();
		CFBamId64GenBuff myBuff = getId64GenBuff();
		myBuff.set( origBuff );
	}
}
