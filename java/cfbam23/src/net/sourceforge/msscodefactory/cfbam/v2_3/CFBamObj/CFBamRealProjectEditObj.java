// Description: Java7 edit object instance implementation for CFBam RealProject.

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

public class CFBamRealProjectEditObj
	extends CFBamProjectBaseEditObj

	implements ICFBamRealProjectEditObj
{

	public CFBamRealProjectEditObj( ICFBamRealProjectObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFBamRealProjectObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "RealProject" );
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
		if( subObj == null ) {
			subObj = getSchema().getMajorVersionTableObj().readMajorVersionByNameIdx( getRequiredTenantId(),
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
		// We realize this so that it's buffer will get copied to orig during realization
		ICFBamRealProjectObj retobj = getSchema().getRealProjectTableObj().realizeRealProject( (ICFBamRealProjectObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		getOrigAsRealProject().getSchema().getRealProjectTableObj().forgetRealProject( getOrigAsRealProject(), forgetSubObjects );
	}

	public ICFBamDomainBaseObj create() {
		copyBuffToOrig();
		ICFBamRealProjectObj retobj = getOrigAsRealProject().getSchema().getRealProjectTableObj().createRealProject( getOrigAsRealProject() );
		if( retobj == getOrigAsRealProject() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public void update() {
		getSchema().getRealProjectTableObj().updateRealProject( (ICFBamRealProjectObj)this );
	}

	public void delete() {
		super.forget();
		getSchema().getRealProjectTableObj().deleteRealProject( getOrigAsRealProject() );
	}

	public ICFBamRealProjectTableObj getRealProjectTable() {
		return( orig.getSchema().getRealProjectTableObj() );
	}

	public ICFBamRealProjectEditObj getEditAsRealProject() {
		return( (ICFBamRealProjectEditObj)this );
	}

	public ICFBamRealProjectObj getOrigAsRealProject() {
		return( (ICFBamRealProjectObj)orig );
	}

	public CFBamDomainBaseBuff getBuff() {
		if( buff == null ) {
			buff = getOrigAsRealProject().getSchema().getBackingStore().getFactoryRealProject().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamDomainBaseBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFBamRealProjectBuff getRealProjectBuff() {
		return( (CFBamRealProjectBuff)getBuff() );
	}

	public List<ICFBamMajorVersionObj> getOptionalComponentsMajorVersion() {
		List<ICFBamMajorVersionObj> retval;
		retval = getOrigAsRealProject().getSchema().getMajorVersionTableObj().readMajorVersionByPPrjIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamMajorVersionObj> getOptionalComponentsMajorVersion( boolean forceRead ) {
		List<ICFBamMajorVersionObj> retval;
		retval = getOrigAsRealProject().getSchema().getMajorVersionTableObj().readMajorVersionByPPrjIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamRealProjectBuff origBuff = getOrigAsRealProject().getRealProjectBuff();
		CFBamRealProjectBuff myBuff = getRealProjectBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamRealProjectBuff origBuff = getOrigAsRealProject().getRealProjectBuff();
		CFBamRealProjectBuff myBuff = getRealProjectBuff();
		myBuff.set( origBuff );
	}
}
