// Description: Java7 implementation of a SecGroupInclude primary key object.

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
 *	CFBamSecGroupIncludePKey Primary Key for SecGroupInclude

 *		requiredClusterId	Required object attribute ClusterId.
 *		requiredSecGroupIncludeId	Required object attribute SecGroupIncludeId. */
public class CFBamSecGroupIncludePKey
	implements Comparable<Object>,
		Serializable
{

	protected long requiredClusterId;
	protected long requiredSecGroupIncludeId;
	public CFBamSecGroupIncludePKey() {
		requiredClusterId = CFBamSecGroupIncludeBuff.CLUSTERID_INIT_VALUE;
		requiredSecGroupIncludeId = CFBamSecGroupIncludeBuff.SECGROUPINCLUDEID_INIT_VALUE;
	}

	public long getRequiredClusterId() {
		return( requiredClusterId );
	}

	public void setRequiredClusterId( long value ) {
		if( value < CFBamSecGroupIncludeBuff.CLUSTERID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredClusterId",
				1,
				"value",
				value,
				CFBamSecGroupIncludeBuff.CLUSTERID_MIN_VALUE );
		}
		requiredClusterId = value;
	}

	public long getRequiredSecGroupIncludeId() {
		return( requiredSecGroupIncludeId );
	}

	public void setRequiredSecGroupIncludeId( long value ) {
		if( value < CFBamSecGroupIncludeBuff.SECGROUPINCLUDEID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredSecGroupIncludeId",
				1,
				"value",
				value,
				CFBamSecGroupIncludeBuff.SECGROUPINCLUDEID_MIN_VALUE );
		}
		requiredSecGroupIncludeId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSecGroupIncludeHPKey ) {
			CFBamSecGroupIncludeHPKey rhs = (CFBamSecGroupIncludeHPKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupIncludeId() != rhs.getRequiredSecGroupIncludeId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupIncludePKey ) {
			CFBamSecGroupIncludePKey rhs = (CFBamSecGroupIncludePKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupIncludeId() != rhs.getRequiredSecGroupIncludeId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupIncludeHBuff ) {
			CFBamSecGroupIncludeHBuff rhs = (CFBamSecGroupIncludeHBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupIncludeId() != rhs.getRequiredSecGroupIncludeId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupIncludeBuff ) {
			CFBamSecGroupIncludeBuff rhs = (CFBamSecGroupIncludeBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupIncludeId() != rhs.getRequiredSecGroupIncludeId() ) {
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
		hashCode = hashCode + (int)( getRequiredClusterId() );
		hashCode = hashCode + (int)( getRequiredSecGroupIncludeId() );
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamSecGroupIncludeHPKey ) {
			CFBamSecGroupIncludeHPKey rhs = (CFBamSecGroupIncludeHPKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupIncludeId() < rhs.getRequiredSecGroupIncludeId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupIncludeId() > rhs.getRequiredSecGroupIncludeId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupIncludePKey ) {
			CFBamSecGroupIncludePKey rhs = (CFBamSecGroupIncludePKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupIncludeId() < rhs.getRequiredSecGroupIncludeId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupIncludeId() > rhs.getRequiredSecGroupIncludeId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupIncludeBuff ) {
			CFBamSecGroupIncludeBuff rhs = (CFBamSecGroupIncludeBuff)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupIncludeId() < rhs.getRequiredSecGroupIncludeId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupIncludeId() > rhs.getRequiredSecGroupIncludeId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupIncludeHBuff ) {
			CFBamSecGroupIncludeHBuff rhs = (CFBamSecGroupIncludeHBuff)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupIncludeId() < rhs.getRequiredSecGroupIncludeId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupIncludeId() > rhs.getRequiredSecGroupIncludeId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				"CFBamSecGroupIncludePKey, CFBamSecGroupIncludeBuff" );
		}
	}

	public String toString() {
		String ret = "<CFBamSecGroupIncludePKey"
			+ " RequiredClusterId=" + "\"" + Long.toString( getRequiredClusterId() ) + "\""
			+ " RequiredSecGroupIncludeId=" + "\"" + Long.toString( getRequiredSecGroupIncludeId() ) + "\""
			+ "/>";
		return( ret );
	}
}