// Description: Java7 base object instance implementation for CFBam Version.

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
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

public class CFBamVersionObj
	extends CFBamProjectBaseObj
	implements ICFBamVersionObj
{
	public final static String CLASS_CODE = "VERN";

	public CFBamVersionObj() {
		super();
	}

	public CFBamVersionObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Version" );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredId();
		objName = Long.toString( val );
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
		if( subObj == null ) {
			subObj = getSchema().getSchemaDefTableObj().readSchemaDefByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = getSchema().getLicenseTableObj().readLicenseByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
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

	public ICFBamDomainBaseObj realize() {
		ICFBamVersionObj retobj = schema.getVersionTableObj().realizeVersion(
			(ICFBamVersionObj)this );
		return( (ICFBamDomainBaseObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		schema.getVersionTableObj().forgetVersion( (ICFBamVersionObj)this, forgetSubObjects );
	}

	public ICFBamDomainBaseObj read() {
		ICFBamVersionObj retobj = schema.getVersionTableObj().readVersionByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamDomainBaseObj)retobj );
	}

	public ICFBamDomainBaseObj read( boolean forceRead ) {
		ICFBamVersionObj retobj = schema.getVersionTableObj().readVersionByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamDomainBaseObj)retobj );
	}

	public ICFBamVersionTableObj getVersionTable() {
		return( schema.getVersionTableObj() );
	}

	public CFBamDomainBaseBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = schema.getBackingStore().getFactoryVersion().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = schema.getBackingStore().getTableVersion().readDerivedByIdIdx( schema.getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamDomainBaseBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamVersionBuff ) ) ) {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamVersionBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
	}

	public CFBamVersionBuff getVersionBuff() {
		return( (CFBamVersionBuff)getBuff() );
	}

	public ICFBamDomainBaseEditObj beginEdit() {
		if( edit != null ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamVersionObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamVersionObj)this;
		}
		else {
			lockobj = schema.getVersionTableObj().lockVersion( getPKey() );
		}
		edit = schema.getVersionTableObj().newEditInstance( lockobj );
		return( (ICFBamDomainBaseEditObj)edit );
	}

	public ICFBamVersionEditObj getEditAsVersion() {
		return( (ICFBamVersionEditObj)edit );
	}

	public ICFBamSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamDomainBaseBuff buff = getBuff();
			createdBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFBamSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamDomainBaseBuff buff = getBuff();
			updatedBy = getSchema().getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}
}
