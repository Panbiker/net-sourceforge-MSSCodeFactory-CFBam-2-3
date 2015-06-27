// Description: Java7 implementation of a BoolDef buffer object.

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

public class CFBamBoolDefBuff

	extends CFBamAtomBuff	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "BOLD";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	protected Boolean optionalInitValue;
	protected Boolean optionalDefaultValue;
	protected String optionalFalseString;
	protected String optionalTrueString;
	protected String optionalNullString;
	public CFBamBoolDefBuff() {
		super();
		optionalInitValue = null;
		optionalDefaultValue = null;
		optionalFalseString = null;
		optionalTrueString = null;
		optionalNullString = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public Boolean getOptionalInitValue() {
		return( optionalInitValue );
	}

	public void setOptionalInitValue( Boolean value ) {
		optionalInitValue = value;
	}

	public Boolean getOptionalDefaultValue() {
		return( optionalDefaultValue );
	}

	public void setOptionalDefaultValue( Boolean value ) {
		optionalDefaultValue = value;
	}

	public String getOptionalFalseString() {
		return( optionalFalseString );
	}

	public void setOptionalFalseString( String value ) {
		if( value == null ) {
			optionalFalseString = null;
		}
		else if( value.length() > 32 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalFalseString",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		else {
			optionalFalseString = value;
		}
	}

	public String getOptionalTrueString() {
		return( optionalTrueString );
	}

	public void setOptionalTrueString( String value ) {
		if( value == null ) {
			optionalTrueString = null;
		}
		else if( value.length() > 32 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalTrueString",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		else {
			optionalTrueString = value;
		}
	}

	public String getOptionalNullString() {
		return( optionalNullString );
	}

	public void setOptionalNullString( String value ) {
		if( value == null ) {
			optionalNullString = null;
		}
		else if( value.length() > 32 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalNullString",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		else {
			optionalNullString = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamBoolDefBuff ) {
			CFBamBoolDefBuff rhs = (CFBamBoolDefBuff)obj;
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					if( ! getOptionalFalseString().equals( rhs.getOptionalFalseString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( false );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					if( ! getOptionalTrueString().equals( rhs.getOptionalTrueString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( false );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					if( ! getOptionalNullString().equals( rhs.getOptionalNullString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
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
		else if( obj instanceof CFBamBoolDefHBuff ) {
			CFBamBoolDefHBuff rhs = (CFBamBoolDefHBuff)obj;
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					if( ! getOptionalFalseString().equals( rhs.getOptionalFalseString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( false );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					if( ! getOptionalTrueString().equals( rhs.getOptionalTrueString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( false );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					if( ! getOptionalNullString().equals( rhs.getOptionalNullString() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
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
			if( getOptionalInitValue() ) {
				hashCode = ( hashCode * 4 ) + 1;
			}
			else {
				hashCode = hashCode * 4;
			}
		}
		else {
			hashCode = (hashCode * 4 ) + 3;
		}
		if( getOptionalDefaultValue() != null ) {
			if( getOptionalDefaultValue() ) {
				hashCode = ( hashCode * 4 ) + 1;
			}
			else {
				hashCode = hashCode * 4;
			}
		}
		else {
			hashCode = (hashCode * 4 ) + 3;
		}
		if( getOptionalFalseString() != null ) {
			hashCode = hashCode + getOptionalFalseString().hashCode();
		}
		if( getOptionalTrueString() != null ) {
			hashCode = hashCode + getOptionalTrueString().hashCode();
		}
		if( getOptionalNullString() != null ) {
			hashCode = hashCode + getOptionalNullString().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamBoolDefBuff ) {
			CFBamBoolDefBuff rhs = (CFBamBoolDefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				Boolean lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() ) {
					Boolean rhsInitValue = rhs.getOptionalInitValue();
					if( lhsInitValue ) {
						if( ! rhsInitValue ) {
							return( 1 );
						}
					}
					else {
						if( rhsInitValue ) {
							return( -1 );
						}
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
				Boolean lhsDefaultValue = getOptionalDefaultValue();
				if( rhs.getOptionalDefaultValue() ) {
					Boolean rhsDefaultValue = rhs.getOptionalDefaultValue();
					if( lhsDefaultValue ) {
						if( ! rhsDefaultValue ) {
							return( 1 );
						}
					}
					else {
						if( rhsDefaultValue ) {
							return( -1 );
						}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					int cmp = getOptionalFalseString().compareTo( rhs.getOptionalFalseString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					int cmp = getOptionalTrueString().compareTo( rhs.getOptionalTrueString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					int cmp = getOptionalNullString().compareTo( rhs.getOptionalNullString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
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
		else if( obj instanceof CFBamBoolDefHBuff ) {
			CFBamBoolDefHBuff rhs = (CFBamBoolDefHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				Boolean lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() ) {
					Boolean rhsInitValue = rhs.getOptionalInitValue();
					if( lhsInitValue ) {
						if( ! rhsInitValue ) {
							return( 1 );
						}
					}
					else {
						if( rhsInitValue ) {
							return( -1 );
						}
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
				Boolean lhsDefaultValue = getOptionalDefaultValue();
				if( rhs.getOptionalDefaultValue() ) {
					Boolean rhsDefaultValue = rhs.getOptionalDefaultValue();
					if( lhsDefaultValue ) {
						if( ! rhsDefaultValue ) {
							return( 1 );
						}
					}
					else {
						if( rhsDefaultValue ) {
							return( -1 );
						}
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
			if( getOptionalFalseString() != null ) {
				if( rhs.getOptionalFalseString() != null ) {
					int cmp = getOptionalFalseString().compareTo( rhs.getOptionalFalseString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFalseString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalTrueString() != null ) {
				if( rhs.getOptionalTrueString() != null ) {
					int cmp = getOptionalTrueString().compareTo( rhs.getOptionalTrueString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTrueString() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullString() != null ) {
				if( rhs.getOptionalNullString() != null ) {
					int cmp = getOptionalNullString().compareTo( rhs.getOptionalNullString() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullString() != null ) {
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
		if( src instanceof CFBamBoolDefBuff ) {
			setBoolDefBuff( (CFBamBoolDefBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamBoolDefBuff" );
		}
	}

	public void setBoolDefBuff( CFBamBoolDefBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalDefaultValue( src.getOptionalDefaultValue() );
		setOptionalFalseString( src.getOptionalFalseString() );
		setOptionalTrueString( src.getOptionalTrueString() );
		setOptionalNullString( src.getOptionalNullString() );
	}
	
	public void set( CFBamValueHBuff src ) {
		if( src instanceof CFBamBoolDefHBuff ) {
			setBoolDefBuff( (CFBamBoolDefHBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamBoolDefHBuff" );
		}
	}

	public void setBoolDefBuff( CFBamBoolDefHBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalDefaultValue( src.getOptionalDefaultValue() );
		setOptionalFalseString( src.getOptionalFalseString() );
		setOptionalTrueString( src.getOptionalTrueString() );
		setOptionalNullString( src.getOptionalNullString() );
	}
}
