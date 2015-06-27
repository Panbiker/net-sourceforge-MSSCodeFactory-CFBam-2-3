// Description: Java7 implementation of a ClearSubDep2 by ContClearDep1Idx index key object.

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

public class CFBamClearSubDep2ByContClearDep1IdxKey
	implements Comparable<Object>,
		Serializable
{

	protected long requiredContClearDep1TenantId;
	protected long requiredContClearDep1Id;
	public CFBamClearSubDep2ByContClearDep1IdxKey() {
		requiredContClearDep1TenantId = CFBamClearSubDep2Buff.CONTCLEARDEP1TENANTID_INIT_VALUE;
		requiredContClearDep1Id = CFBamClearSubDep2Buff.CONTCLEARDEP1ID_INIT_VALUE;
	}

	public long getRequiredContClearDep1TenantId() {
		return( requiredContClearDep1TenantId );
	}

	public void setRequiredContClearDep1TenantId( long value ) {
		if( value < CFBamClearSubDep2Buff.CONTCLEARDEP1TENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredContClearDep1TenantId",
				1,
				"value",
				value,
				CFBamClearSubDep2Buff.CONTCLEARDEP1TENANTID_MIN_VALUE );
		}
		requiredContClearDep1TenantId = value;
	}

	public long getRequiredContClearDep1Id() {
		return( requiredContClearDep1Id );
	}

	public void setRequiredContClearDep1Id( long value ) {
		if( value < CFBamClearSubDep2Buff.CONTCLEARDEP1ID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredContClearDep1Id",
				1,
				"value",
				value,
				CFBamClearSubDep2Buff.CONTCLEARDEP1ID_MIN_VALUE );
		}
		requiredContClearDep1Id = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamClearSubDep2ByContClearDep1IdxKey ) {
			CFBamClearSubDep2ByContClearDep1IdxKey rhs = (CFBamClearSubDep2ByContClearDep1IdxKey)obj;
			if( getRequiredContClearDep1TenantId() != rhs.getRequiredContClearDep1TenantId() ) {
				return( false );
			}
			if( getRequiredContClearDep1Id() != rhs.getRequiredContClearDep1Id() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamClearSubDep2Buff ) {
			CFBamClearSubDep2Buff rhs = (CFBamClearSubDep2Buff)obj;
			if( getRequiredContClearDep1TenantId() != rhs.getRequiredContClearDep1TenantId() ) {
				return( false );
			}
			if( getRequiredContClearDep1Id() != rhs.getRequiredContClearDep1Id() ) {
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
		hashCode = hashCode + (int)( getRequiredContClearDep1TenantId() );
		hashCode = hashCode + (int)( getRequiredContClearDep1Id() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof CFBamClearSubDep2ByContClearDep1IdxKey ) {
			CFBamClearSubDep2ByContClearDep1IdxKey rhs = (CFBamClearSubDep2ByContClearDep1IdxKey)obj;
			if( getRequiredContClearDep1TenantId() < rhs.getRequiredContClearDep1TenantId() ) {
				return( -1 );
			}
			else if( getRequiredContClearDep1TenantId() > rhs.getRequiredContClearDep1TenantId() ) {
				return( 1 );
			}
			if( getRequiredContClearDep1Id() < rhs.getRequiredContClearDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredContClearDep1Id() > rhs.getRequiredContClearDep1Id() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamClearSubDep2Buff ) {
			CFBamClearSubDep2Buff rhs = (CFBamClearSubDep2Buff)obj;
			if( getRequiredContClearDep1TenantId() < rhs.getRequiredContClearDep1TenantId() ) {
				return( -1 );
			}
			else if( getRequiredContClearDep1TenantId() > rhs.getRequiredContClearDep1TenantId() ) {
				return( 1 );
			}
			if( getRequiredContClearDep1Id() < rhs.getRequiredContClearDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredContClearDep1Id() > rhs.getRequiredContClearDep1Id() ) {
				return( 1 );
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
		String ret = "<CFBamClearSubDep2ByContClearDep1Idx"
			+ " RequiredContClearDep1TenantId=" + "\"" + Long.toString( getRequiredContClearDep1TenantId() ) + "\""
			+ " RequiredContClearDep1Id=" + "\"" + Long.toString( getRequiredContClearDep1Id() ) + "\""
			+ "/>";
		return( ret );
	}
}
