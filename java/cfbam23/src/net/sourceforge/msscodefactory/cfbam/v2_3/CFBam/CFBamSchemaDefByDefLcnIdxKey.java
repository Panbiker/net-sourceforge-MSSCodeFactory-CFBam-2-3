// Description: Java7 implementation of a SchemaDef by DefLcnIdx index key object.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBam;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;

public class CFBamSchemaDefByDefLcnIdxKey
	implements Comparable<Object>,
		Serializable
{

	protected Long optionalDefaultLicenseTenantId;
	protected Long optionalDefaultLicenseId;
	public CFBamSchemaDefByDefLcnIdxKey() {
		optionalDefaultLicenseTenantId = null;
		optionalDefaultLicenseId = null;
	}

	public Long getOptionalDefaultLicenseTenantId() {
		return( optionalDefaultLicenseTenantId );
	}

	public void setOptionalDefaultLicenseTenantId( Long value ) {
		if( value == null ) {
			optionalDefaultLicenseTenantId = null;
		}
		else if( value < CFBamSchemaDefBuff.DEFAULTLICENSETENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDefaultLicenseTenantId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.DEFAULTLICENSETENANTID_MIN_VALUE );
		}
		else {
			optionalDefaultLicenseTenantId = value;
		}
	}

	public Long getOptionalDefaultLicenseId() {
		return( optionalDefaultLicenseId );
	}

	public void setOptionalDefaultLicenseId( Long value ) {
		if( value == null ) {
			optionalDefaultLicenseId = null;
		}
		else if( value < CFBamSchemaDefBuff.DEFAULTLICENSEID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDefaultLicenseId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.DEFAULTLICENSEID_MIN_VALUE );
		}
		else {
			optionalDefaultLicenseId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSchemaDefByDefLcnIdxKey ) {
			CFBamSchemaDefByDefLcnIdxKey rhs = (CFBamSchemaDefByDefLcnIdxKey)obj;
			if( getOptionalDefaultLicenseTenantId() != null ) {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					if( ! getOptionalDefaultLicenseTenantId().equals( rhs.getOptionalDefaultLicenseTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					if( ! getOptionalDefaultLicenseId().equals( rhs.getOptionalDefaultLicenseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			if( getOptionalDefaultLicenseTenantId() != null ) {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					if( ! getOptionalDefaultLicenseTenantId().equals( rhs.getOptionalDefaultLicenseTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					if( ! getOptionalDefaultLicenseId().equals( rhs.getOptionalDefaultLicenseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	public int hashCode() {
		int hashCode = 0;
		if( getOptionalDefaultLicenseTenantId() != null ) {
			hashCode = hashCode + getOptionalDefaultLicenseTenantId().hashCode();
		}
		if( getOptionalDefaultLicenseId() != null ) {
			hashCode = hashCode + getOptionalDefaultLicenseId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamSchemaDefByDefLcnIdxKey ) {
			CFBamSchemaDefByDefLcnIdxKey rhs = (CFBamSchemaDefByDefLcnIdxKey)obj;
			if( getOptionalDefaultLicenseTenantId() != null ) {
				Long lhsDefaultLicenseTenantId = getOptionalDefaultLicenseTenantId();
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					Long rhsDefaultLicenseTenantId = rhs.getOptionalDefaultLicenseTenantId();
					int cmp = lhsDefaultLicenseTenantId.compareTo( rhsDefaultLicenseTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				Long lhsDefaultLicenseId = getOptionalDefaultLicenseId();
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					Long rhsDefaultLicenseId = rhs.getOptionalDefaultLicenseId();
					int cmp = lhsDefaultLicenseId.compareTo( rhsDefaultLicenseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			if( getOptionalDefaultLicenseTenantId() != null ) {
				Long lhsDefaultLicenseTenantId = getOptionalDefaultLicenseTenantId();
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					Long rhsDefaultLicenseTenantId = rhs.getOptionalDefaultLicenseTenantId();
					int cmp = lhsDefaultLicenseTenantId.compareTo( rhsDefaultLicenseTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				Long lhsDefaultLicenseId = getOptionalDefaultLicenseId();
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					Long rhsDefaultLicenseId = rhs.getOptionalDefaultLicenseId();
					int cmp = lhsDefaultLicenseId.compareTo( rhsDefaultLicenseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	public String toString() {
		String ret = "<CFBamSchemaDefByDefLcnIdx"
			+ " OptionalDefaultLicenseTenantId=" + ( ( getOptionalDefaultLicenseTenantId() == null ) ? "null" : "\"" + getOptionalDefaultLicenseTenantId().toString() + "\"" )
			+ " OptionalDefaultLicenseId=" + ( ( getOptionalDefaultLicenseId() == null ) ? "null" : "\"" + getOptionalDefaultLicenseId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
