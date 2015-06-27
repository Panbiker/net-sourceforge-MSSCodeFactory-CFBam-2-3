// Description: Java7 edit object instance implementation for CFBam ISOLanguage.

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

public class CFBamISOLanguageEditObj
	implements ICFBamISOLanguageEditObj
{
	protected ICFBamISOLanguageObj orig;
	protected CFBamISOLanguageBuff buff;
	protected ICFBamSecUserObj createdBy = null;
	protected ICFBamSecUserObj updatedBy = null;

	public CFBamISOLanguageEditObj( ICFBamISOLanguageObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamISOLanguageBuff origBuff = orig.getBuff();
		buff.set( origBuff );
	}

	public ICFBamSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamISOLanguageBuff buff = getBuff();
			createdBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFBamSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamISOLanguageBuff buff = getBuff();
			updatedBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public void setCreatedBy( ICFBamSecUserObj value ) {
		createdBy = value;
		if( value != null ) {
			getBuff().setCreatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setCreatedAt( Calendar value ) {
		getBuff().setCreatedAt( value );
	}

	public void setUpdatedBy( ICFBamSecUserObj value ) {
		updatedBy = value;
		if( value != null ) {
			getBuff().setUpdatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setUpdatedAt( Calendar value ) {
		getBuff().setUpdatedAt( value );
	}

	public String getClassCode() {
		return( CFBamISOLanguageObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ISOLanguage" );
	}

	public ICFLibAnyObj getScope() {
		return( null );
	}

	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredISOCode();
		return( objName );
	}

	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
					break;
				}
				else if( qualifyingClass.isInstance( container ) ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		else {
			while( container != null ) {
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	public ICFLibAnyObj getNamedObject( Class qualifyingClass, String objName ) {
		ICFLibAnyObj topContainer = getObjQualifier( qualifyingClass );
		if( topContainer == null ) {
			return( null );
		}
		ICFLibAnyObj namedObject = topContainer.getNamedObject( objName );
		return( namedObject );
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

	public String getObjQualifiedName() {
		String qualName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFBamClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFBamTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	public String getObjFullName() {
		String fullName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFBamClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFBamTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				fullName = containerName + "." + fullName;
				container = container.getObjScope();
			}
		}
		return( fullName );
	}

	public ICFBamISOLanguageObj realize() {
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamISOLanguageObj retobj = getSchema().getISOLanguageTableObj().realizeISOLanguage( (ICFBamISOLanguageObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsISOLanguage().getSchema().getISOLanguageTableObj().forgetISOLanguage( getOrigAsISOLanguage(), forgetSubObjects );
	}

	public ICFBamISOLanguageObj read() {
		ICFBamISOLanguageObj retval = getOrigAsISOLanguage().read();
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamISOLanguageObj read( boolean forceRead ) {
		ICFBamISOLanguageObj retval = getOrigAsISOLanguage().read( forceRead );
		if( retval != orig ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamISOLanguageObj create() {
		copyPKeyToBuff();
		copyBuffToOrig();
		orig.copyBuffToPKey();
		ICFBamISOLanguageObj retobj = getOrigAsISOLanguage().getSchema().getISOLanguageTableObj().createISOLanguage( getOrigAsISOLanguage() );
		if( retobj == getOrigAsISOLanguage() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getISOLanguageTableObj().updateISOLanguage( (ICFBamISOLanguageObj)this );
	}

	public void delete() {
		if( getIsNew() ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getISOLanguageTableObj().deleteISOLanguage( getOrigAsISOLanguage() );
	}

	public ICFBamISOLanguageTableObj getISOLanguageTable() {
		return( orig.getSchema().getISOLanguageTableObj() );
	}

	public ICFBamISOLanguageEditObj getEdit() {
		return( (ICFBamISOLanguageEditObj)this );
	}

	public ICFBamISOLanguageEditObj getEditAsISOLanguage() {
		return( (ICFBamISOLanguageEditObj)this );
	}

	public ICFBamISOLanguageEditObj beginEdit() {
		throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamISOLanguageObj getOrig() {
		return( orig );
	}

	public ICFBamISOLanguageObj getOrigAsISOLanguage() {
		return( (ICFBamISOLanguageObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamISOLanguageBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsISOLanguage().getSchema().getBackingStore().getFactoryISOLanguage().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamISOLanguageBuff value ) {
		if( buff != value ) {
			buff = value;
		}
	}

	public CFBamISOLanguageBuff getISOLanguageBuff() {
		return( (CFBamISOLanguageBuff)getBuff() );
	}

	public CFBamISOLanguagePKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamISOLanguagePKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public short getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public String getRequiredISOCode() {
		return( getISOLanguageBuff().getRequiredISOCode() );
	}

	public void setRequiredISOCode( String value ) {
		if( getISOLanguageBuff().getRequiredISOCode() != value ) {
			getISOLanguageBuff().setRequiredISOCode( value );
		}
	}

	public String getRequiredBaseLanguageCode() {
		return( getISOLanguageBuff().getRequiredBaseLanguageCode() );
	}

	public void setRequiredBaseLanguageCode( String value ) {
		if( getISOLanguageBuff().getRequiredBaseLanguageCode() != value ) {
			getISOLanguageBuff().setRequiredBaseLanguageCode( value );
		}
	}

	public Short getOptionalISOCountryId() {
		return( getISOLanguageBuff().getOptionalISOCountryId() );
	}

	public void setOptionalISOCountryId( Short value ) {
		if( getISOLanguageBuff().getOptionalISOCountryId() != value ) {
			getISOLanguageBuff().setOptionalISOCountryId( value );
		}
	}

	public List<ICFBamISOCountryLanguageObj> getOptionalChildrenCountry() {
		List<ICFBamISOCountryLanguageObj> retval;
		retval = getOrigAsISOLanguage().getSchema().getISOCountryLanguageTableObj().readISOCountryLanguageByLanguageIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamISOCountryLanguageObj> getOptionalChildrenCountry( boolean forceRead ) {
		List<ICFBamISOCountryLanguageObj> retval;
		retval = getOrigAsISOLanguage().getSchema().getISOCountryLanguageTableObj().readISOCountryLanguageByLanguageIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFBamISOLanguageBuff origBuff = getOrigAsISOLanguage().getISOLanguageBuff();
		CFBamISOLanguageBuff myBuff = getISOLanguageBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamISOLanguageBuff origBuff = getOrigAsISOLanguage().getISOLanguageBuff();
		CFBamISOLanguageBuff myBuff = getISOLanguageBuff();
		myBuff.set( origBuff );
	}
}
