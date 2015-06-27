// Description: Java7 implementation of a TimeDef buffer object.

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

public class CFBamTimeDefBuff

	extends CFBamAtomBuff	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "TIMD";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	protected Calendar optionalInitValue;
	protected Calendar optionalDefaultValue;
	protected Calendar optionalNullValue;
	protected Calendar optionalUnknownValue;
	public CFBamTimeDefBuff() {
		super();
		optionalInitValue = null;
		optionalDefaultValue = null;
		optionalNullValue = null;
		optionalUnknownValue = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public Calendar getOptionalInitValue() {
		return( optionalInitValue );
	}

	public void setOptionalInitValue( Calendar value ) {
		if( value == null ) {
			optionalInitValue = null;
		}
		else {
			optionalInitValue = value;
		}
	}

	public Calendar getOptionalDefaultValue() {
		return( optionalDefaultValue );
	}

	public void setOptionalDefaultValue( Calendar value ) {
		if( value == null ) {
			optionalDefaultValue = null;
		}
		else {
			optionalDefaultValue = value;
		}
	}

	public Calendar getOptionalNullValue() {
		return( optionalNullValue );
	}

	public void setOptionalNullValue( Calendar value ) {
		if( value == null ) {
			optionalNullValue = null;
		}
		else {
			optionalNullValue = value;
		}
	}

	public Calendar getOptionalUnknownValue() {
		return( optionalUnknownValue );
	}

	public void setOptionalUnknownValue( Calendar value ) {
		if( value == null ) {
			optionalUnknownValue = null;
		}
		else {
			optionalUnknownValue = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamTimeDefBuff ) {
			CFBamTimeDefBuff rhs = (CFBamTimeDefBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					if( ! getOptionalInitValue().equals( rhs.getOptionalInitValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultValue() != null ) {
				if( rhs.getOptionalDefaultValue() != null ) {
					if( ! getOptionalDefaultValue().equals( rhs.getOptionalDefaultValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultValue() != null ) {
					return( false );
				}
			}
			if( getOptionalNullValue() != null ) {
				if( rhs.getOptionalNullValue() != null ) {
					if( ! getOptionalNullValue().equals( rhs.getOptionalNullValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNullValue() != null ) {
					return( false );
				}
			}
			if( getOptionalUnknownValue() != null ) {
				if( rhs.getOptionalUnknownValue() != null ) {
					if( ! getOptionalUnknownValue().equals( rhs.getOptionalUnknownValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalUnknownValue() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamValuePKey ) {
			CFBamValuePKey rhs = (CFBamValuePKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTimeDefHBuff ) {
			CFBamTimeDefHBuff rhs = (CFBamTimeDefHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					if( ! getOptionalInitValue().equals( rhs.getOptionalInitValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultValue() != null ) {
				if( rhs.getOptionalDefaultValue() != null ) {
					if( ! getOptionalDefaultValue().equals( rhs.getOptionalDefaultValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultValue() != null ) {
					return( false );
				}
			}
			if( getOptionalNullValue() != null ) {
				if( rhs.getOptionalNullValue() != null ) {
					if( ! getOptionalNullValue().equals( rhs.getOptionalNullValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNullValue() != null ) {
					return( false );
				}
			}
			if( getOptionalUnknownValue() != null ) {
				if( rhs.getOptionalUnknownValue() != null ) {
					if( ! getOptionalUnknownValue().equals( rhs.getOptionalUnknownValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalUnknownValue() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamValueHPKey ) {
			CFBamValueHPKey rhs = (CFBamValueHPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		if( getOptionalInitValue() != null ) {
			hashCode = hashCode + getOptionalInitValue().hashCode();
		}
		if( getOptionalDefaultValue() != null ) {
			hashCode = hashCode + getOptionalDefaultValue().hashCode();
		}
		if( getOptionalNullValue() != null ) {
			hashCode = hashCode + getOptionalNullValue().hashCode();
		}
		if( getOptionalUnknownValue() != null ) {
			hashCode = hashCode + getOptionalUnknownValue().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamTimeDefBuff ) {
			CFBamTimeDefBuff rhs = (CFBamTimeDefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					int cmp = getOptionalInitValue().compareTo( rhs.getOptionalInitValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultValue() != null ) {
				if( rhs.getOptionalDefaultValue() != null ) {
					int cmp = getOptionalDefaultValue().compareTo( rhs.getOptionalDefaultValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullValue() != null ) {
				if( rhs.getOptionalNullValue() != null ) {
					int cmp = getOptionalNullValue().compareTo( rhs.getOptionalNullValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalUnknownValue() != null ) {
				if( rhs.getOptionalUnknownValue() != null ) {
					int cmp = getOptionalUnknownValue().compareTo( rhs.getOptionalUnknownValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalUnknownValue() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamValuePKey ) {
			CFBamValuePKey rhs = (CFBamValuePKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamValueHPKey ) {
			CFBamValueHPKey rhs = (CFBamValueHPKey)obj;
			{
				int lhsRequiredRevision = getRequiredRevision();
				int rhsRequiredRevision = rhs.getRequiredRevision();
				if( lhsRequiredRevision < rhsRequiredRevision ) {
					return( -1 );
				}
				else if( lhsRequiredRevision > rhsRequiredRevision ) {
					return( 1 );
				}
			}
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTimeDefHBuff ) {
			CFBamTimeDefHBuff rhs = (CFBamTimeDefHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					int cmp = getOptionalInitValue().compareTo( rhs.getOptionalInitValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultValue() != null ) {
				if( rhs.getOptionalDefaultValue() != null ) {
					int cmp = getOptionalDefaultValue().compareTo( rhs.getOptionalDefaultValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullValue() != null ) {
				if( rhs.getOptionalNullValue() != null ) {
					int cmp = getOptionalNullValue().compareTo( rhs.getOptionalNullValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalUnknownValue() != null ) {
				if( rhs.getOptionalUnknownValue() != null ) {
					int cmp = getOptionalUnknownValue().compareTo( rhs.getOptionalUnknownValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalUnknownValue() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamValueBuff src ) {
		if( src instanceof CFBamTimeDefBuff ) {
			setTimeDefBuff( (CFBamTimeDefBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamTimeDefBuff" );
		}
	}

	public void setTimeDefBuff( CFBamTimeDefBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalDefaultValue( src.getOptionalDefaultValue() );
		setOptionalNullValue( src.getOptionalNullValue() );
		setOptionalUnknownValue( src.getOptionalUnknownValue() );
	}
	
	public void set( CFBamValueHBuff src ) {
		if( src instanceof CFBamTimeDefHBuff ) {
			setTimeDefBuff( (CFBamTimeDefHBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamTimeDefHBuff" );
		}
	}

	public void setTimeDefBuff( CFBamTimeDefHBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalDefaultValue( src.getOptionalDefaultValue() );
		setOptionalNullValue( src.getOptionalNullValue() );
		setOptionalUnknownValue( src.getOptionalUnknownValue() );
	}
}
