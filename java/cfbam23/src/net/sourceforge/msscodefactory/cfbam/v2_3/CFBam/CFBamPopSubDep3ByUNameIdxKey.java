// Description: Java7 implementation of a PopSubDep3 by UNameIdx index key object.

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

public class CFBamPopSubDep3ByUNameIdxKey
	implements Comparable<Object>,
		Serializable
{

	protected long requiredContTenantId;
	protected long requiredContPopDep2Id;
	protected String requiredName;
	public CFBamPopSubDep3ByUNameIdxKey() {
		requiredContTenantId = CFBamPopSubDep3Buff.CONTTENANTID_INIT_VALUE;
		requiredContPopDep2Id = CFBamPopSubDep3Buff.CONTPOPDEP2ID_INIT_VALUE;
		requiredName = new String( CFBamPopSubDep3Buff.NAME_INIT_VALUE );
	}

	public long getRequiredContTenantId() {
		return( requiredContTenantId );
	}

	public void setRequiredContTenantId( long value ) {
		if( value < CFBamPopSubDep3Buff.CONTTENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredContTenantId",
				1,
				"value",
				value,
				CFBamPopSubDep3Buff.CONTTENANTID_MIN_VALUE );
		}
		requiredContTenantId = value;
	}

	public long getRequiredContPopDep2Id() {
		return( requiredContPopDep2Id );
	}

	public void setRequiredContPopDep2Id( long value ) {
		if( value < CFBamPopSubDep3Buff.CONTPOPDEP2ID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredContPopDep2Id",
				1,
				"value",
				value,
				CFBamPopSubDep3Buff.CONTPOPDEP2ID_MIN_VALUE );
		}
		requiredContPopDep2Id = value;
	}

	public String getRequiredName() {
		return( requiredName );
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		if( value.length() > 192 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredName = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamPopSubDep3ByUNameIdxKey ) {
			CFBamPopSubDep3ByUNameIdxKey rhs = (CFBamPopSubDep3ByUNameIdxKey)obj;
			if( getRequiredContTenantId() != rhs.getRequiredContTenantId() ) {
				return( false );
			}
			if( getRequiredContPopDep2Id() != rhs.getRequiredContPopDep2Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamPopSubDep3Buff ) {
			CFBamPopSubDep3Buff rhs = (CFBamPopSubDep3Buff)obj;
			if( getRequiredContTenantId() != rhs.getRequiredContTenantId() ) {
				return( false );
			}
			if( getRequiredContPopDep2Id() != rhs.getRequiredContPopDep2Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + (int)( getRequiredContTenantId() );
		hashCode = hashCode + (int)( getRequiredContPopDep2Id() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamPopSubDep3ByUNameIdxKey ) {
			CFBamPopSubDep3ByUNameIdxKey rhs = (CFBamPopSubDep3ByUNameIdxKey)obj;
			if( getRequiredContTenantId() < rhs.getRequiredContTenantId() ) {
				return( -1 );
			}
			else if( getRequiredContTenantId() > rhs.getRequiredContTenantId() ) {
				return( 1 );
			}
			if( getRequiredContPopDep2Id() < rhs.getRequiredContPopDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredContPopDep2Id() > rhs.getRequiredContPopDep2Id() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamPopSubDep3Buff ) {
			CFBamPopSubDep3Buff rhs = (CFBamPopSubDep3Buff)obj;
			if( getRequiredContTenantId() < rhs.getRequiredContTenantId() ) {
				return( -1 );
			}
			else if( getRequiredContTenantId() > rhs.getRequiredContTenantId() ) {
				return( 1 );
			}
			if( getRequiredContPopDep2Id() < rhs.getRequiredContPopDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredContPopDep2Id() > rhs.getRequiredContPopDep2Id() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
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
		String ret = "<CFBamPopSubDep3ByUNameIdx"
			+ " RequiredContTenantId=" + "\"" + Long.toString( getRequiredContTenantId() ) + "\""
			+ " RequiredContPopDep2Id=" + "\"" + Long.toString( getRequiredContPopDep2Id() ) + "\""
			+ " RequiredName=" + "\"" + CFBamSchema.xmlEncodeString( getRequiredName() ) + "\""
			+ "/>";
		return( ret );
	}
}
