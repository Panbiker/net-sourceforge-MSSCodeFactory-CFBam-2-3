// Description: Java7 implementation of a TSecGroup primary key object.

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
import org.apache.commons.codec.binary.Base64;

/*
 *	CFBamTSecGroupPKey Primary Key for TSecGroup

 *		requiredTenantId	Required object attribute TenantId.
 *		requiredTSecGroupId	Required object attribute TSecGroupId. */
public class CFBamTSecGroupPKey
	implements Comparable<Object>,
		Serializable
{

	protected long requiredTenantId;
	protected int requiredTSecGroupId;
	public CFBamTSecGroupPKey() {
		requiredTenantId = CFBamTSecGroupBuff.TENANTID_INIT_VALUE;
		requiredTSecGroupId = CFBamTSecGroupBuff.TSECGROUPID_INIT_VALUE;
	}

	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFBamTSecGroupBuff.TENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFBamTSecGroupBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public int getRequiredTSecGroupId() {
		return( requiredTSecGroupId );
	}

	public void setRequiredTSecGroupId( int value ) {
		if( value < CFBamTSecGroupBuff.TSECGROUPID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredTSecGroupId",
				1,
				"value",
				value,
				CFBamTSecGroupBuff.TSECGROUPID_MIN_VALUE );
		}
		requiredTSecGroupId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamTSecGroupHPKey ) {
			CFBamTSecGroupHPKey rhs = (CFBamTSecGroupHPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupId() != rhs.getRequiredTSecGroupId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTSecGroupPKey ) {
			CFBamTSecGroupPKey rhs = (CFBamTSecGroupPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupId() != rhs.getRequiredTSecGroupId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTSecGroupHBuff ) {
			CFBamTSecGroupHBuff rhs = (CFBamTSecGroupHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupId() != rhs.getRequiredTSecGroupId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTSecGroupBuff ) {
			CFBamTSecGroupBuff rhs = (CFBamTSecGroupBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupId() != rhs.getRequiredTSecGroupId() ) {
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
		hashCode = hashCode + (int)( getRequiredTenantId() );
		hashCode = hashCode + getRequiredTSecGroupId();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamTSecGroupHPKey ) {
			CFBamTSecGroupHPKey rhs = (CFBamTSecGroupHPKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupId() < rhs.getRequiredTSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupId() > rhs.getRequiredTSecGroupId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTSecGroupPKey ) {
			CFBamTSecGroupPKey rhs = (CFBamTSecGroupPKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupId() < rhs.getRequiredTSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupId() > rhs.getRequiredTSecGroupId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTSecGroupBuff ) {
			CFBamTSecGroupBuff rhs = (CFBamTSecGroupBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupId() < rhs.getRequiredTSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupId() > rhs.getRequiredTSecGroupId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTSecGroupHBuff ) {
			CFBamTSecGroupHBuff rhs = (CFBamTSecGroupHBuff)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupId() < rhs.getRequiredTSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupId() > rhs.getRequiredTSecGroupId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				"CFBamTSecGroupPKey, CFBamTSecGroupBuff" );
		}
	}

	public String toString() {
		String ret = "<CFBamTSecGroupPKey"
			+ " RequiredTenantId=" + "\"" + Long.toString( getRequiredTenantId() ) + "\""
			+ " RequiredTSecGroupId=" + "\"" + Integer.toString( getRequiredTSecGroupId() ) + "\""
			+ "/>";
		return( ret );
	}
}
