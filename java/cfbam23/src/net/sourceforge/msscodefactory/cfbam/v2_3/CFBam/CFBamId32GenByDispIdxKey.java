// Description: Java7 implementation of a Id32Gen by DispIdx index key object.

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

public class CFBamId32GenByDispIdxKey
	implements Comparable<Object>,
		Serializable
{

	protected Long optionalDispenserTenantId;
	protected Long optionalDispenserId;
	public CFBamId32GenByDispIdxKey() {
		optionalDispenserTenantId = null;
		optionalDispenserId = null;
	}

	public Long getOptionalDispenserTenantId() {
		return( optionalDispenserTenantId );
	}

	public void setOptionalDispenserTenantId( Long value ) {
		if( value == null ) {
			optionalDispenserTenantId = null;
		}
		else if( value < CFBamId32GenBuff.DISPENSERTENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDispenserTenantId",
				1,
				"value",
				value,
				CFBamId32GenBuff.DISPENSERTENANTID_MIN_VALUE );
		}
		else {
			optionalDispenserTenantId = value;
		}
	}

	public Long getOptionalDispenserId() {
		return( optionalDispenserId );
	}

	public void setOptionalDispenserId( Long value ) {
		if( value == null ) {
			optionalDispenserId = null;
		}
		else if( value < CFBamId32GenBuff.DISPENSERID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDispenserId",
				1,
				"value",
				value,
				CFBamId32GenBuff.DISPENSERID_MIN_VALUE );
		}
		else {
			optionalDispenserId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamId32GenByDispIdxKey ) {
			CFBamId32GenByDispIdxKey rhs = (CFBamId32GenByDispIdxKey)obj;
			if( getOptionalDispenserTenantId() != null ) {
				if( rhs.getOptionalDispenserTenantId() != null ) {
					if( ! getOptionalDispenserTenantId().equals( rhs.getOptionalDispenserTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDispenserTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDispenserId() != null ) {
				if( rhs.getOptionalDispenserId() != null ) {
					if( ! getOptionalDispenserId().equals( rhs.getOptionalDispenserId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDispenserId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamId32GenBuff ) {
			CFBamId32GenBuff rhs = (CFBamId32GenBuff)obj;
			if( getOptionalDispenserTenantId() != null ) {
				if( rhs.getOptionalDispenserTenantId() != null ) {
					if( ! getOptionalDispenserTenantId().equals( rhs.getOptionalDispenserTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDispenserTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDispenserId() != null ) {
				if( rhs.getOptionalDispenserId() != null ) {
					if( ! getOptionalDispenserId().equals( rhs.getOptionalDispenserId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDispenserId() != null ) {
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
		if( getOptionalDispenserTenantId() != null ) {
			hashCode = hashCode + getOptionalDispenserTenantId().hashCode();
		}
		if( getOptionalDispenserId() != null ) {
			hashCode = hashCode + getOptionalDispenserId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamId32GenByDispIdxKey ) {
			CFBamId32GenByDispIdxKey rhs = (CFBamId32GenByDispIdxKey)obj;
			if( getOptionalDispenserTenantId() != null ) {
				Long lhsDispenserTenantId = getOptionalDispenserTenantId();
				if( rhs.getOptionalDispenserTenantId() != null ) {
					Long rhsDispenserTenantId = rhs.getOptionalDispenserTenantId();
					int cmp = lhsDispenserTenantId.compareTo( rhsDispenserTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDispenserTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDispenserId() != null ) {
				Long lhsDispenserId = getOptionalDispenserId();
				if( rhs.getOptionalDispenserId() != null ) {
					Long rhsDispenserId = rhs.getOptionalDispenserId();
					int cmp = lhsDispenserId.compareTo( rhsDispenserId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDispenserId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamId32GenBuff ) {
			CFBamId32GenBuff rhs = (CFBamId32GenBuff)obj;
			if( getOptionalDispenserTenantId() != null ) {
				Long lhsDispenserTenantId = getOptionalDispenserTenantId();
				if( rhs.getOptionalDispenserTenantId() != null ) {
					Long rhsDispenserTenantId = rhs.getOptionalDispenserTenantId();
					int cmp = lhsDispenserTenantId.compareTo( rhsDispenserTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDispenserTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDispenserId() != null ) {
				Long lhsDispenserId = getOptionalDispenserId();
				if( rhs.getOptionalDispenserId() != null ) {
					Long rhsDispenserId = rhs.getOptionalDispenserId();
					int cmp = lhsDispenserId.compareTo( rhsDispenserId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDispenserId() != null ) {
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
		String ret = "<CFBamId32GenByDispIdx"
			+ " OptionalDispenserTenantId=" + ( ( getOptionalDispenserTenantId() == null ) ? "null" : "\"" + getOptionalDispenserTenantId().toString() + "\"" )
			+ " OptionalDispenserId=" + ( ( getOptionalDispenserId() == null ) ? "null" : "\"" + getOptionalDispenserId().toString() + "\"" )
			+ "/>";
		return( ret );
	}
}
