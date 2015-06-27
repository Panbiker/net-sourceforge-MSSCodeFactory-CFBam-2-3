// Description: Java7 implementation of a Int16Def buffer object.

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

public class CFBamInt16DefBuff

	extends CFBamAtomBuff	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "I16D";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final short INITVALUE_INIT_VALUE = (short)0;
	public static final short DEFAULTVALUE_INIT_VALUE = (short)0;
	public static final short MINVALUE_INIT_VALUE = (short)0;
	public static final short MAXVALUE_INIT_VALUE = (short)0;
	public static final short NULLVALUE_INIT_VALUE = (short)0;
	public static final short UNKNOWNVALUE_INIT_VALUE = (short)0;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final short INITVALUE_MIN_VALUE = (short)-32768;
	public static final short DEFAULTVALUE_MIN_VALUE = (short)-32768;
	public static final short MINVALUE_MIN_VALUE = (short)-32768;
	public static final short MAXVALUE_MIN_VALUE = (short)-32768;
	public static final short NULLVALUE_MIN_VALUE = (short)-32768;
	public static final short UNKNOWNVALUE_MIN_VALUE = (short)-32768;
	public static final short INITVALUE_MAX_VALUE = (short)32767;
	public static final short DEFAULTVALUE_MAX_VALUE = (short)32767;
	public static final short MINVALUE_MAX_VALUE = (short)32767;
	public static final short MAXVALUE_MAX_VALUE = (short)32767;
	public static final short NULLVALUE_MAX_VALUE = (short)32767;
	public static final short UNKNOWNVALUE_MAX_VALUE = (short)32767;
	protected Short optionalInitValue;
	protected Short optionalDefaultValue;
	protected Short optionalMinValue;
	protected Short optionalMaxValue;
	protected Short optionalNullValue;
	protected Short optionalUnknownValue;
	public CFBamInt16DefBuff() {
		super();
		optionalInitValue = null;
		optionalDefaultValue = null;
		optionalMinValue = null;
		optionalMaxValue = null;
		optionalNullValue = null;
		optionalUnknownValue = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public Short getOptionalInitValue() {
		return( optionalInitValue );
	}

	public void setOptionalInitValue( Short value ) {
		if( value == null ) {
			optionalInitValue = null;
		}
		else if( value < CFBamInt16DefBuff.INITVALUE_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalInitValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.INITVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt16DefBuff.INITVALUE_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalInitValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.INITVALUE_MAX_VALUE );
		}
		else {
			optionalInitValue = value;
		}
	}

	public Short getOptionalDefaultValue() {
		return( optionalDefaultValue );
	}

	public void setOptionalDefaultValue( Short value ) {
		if( value == null ) {
			optionalDefaultValue = null;
		}
		else if( value < CFBamInt16DefBuff.DEFAULTVALUE_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalDefaultValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.DEFAULTVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt16DefBuff.DEFAULTVALUE_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalDefaultValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.DEFAULTVALUE_MAX_VALUE );
		}
		else {
			optionalDefaultValue = value;
		}
	}

	public Short getOptionalMinValue() {
		return( optionalMinValue );
	}

	public void setOptionalMinValue( Short value ) {
		if( value == null ) {
			optionalMinValue = null;
		}
		else if( value < CFBamInt16DefBuff.MINVALUE_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalMinValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.MINVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt16DefBuff.MINVALUE_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalMinValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.MINVALUE_MAX_VALUE );
		}
		else {
			optionalMinValue = value;
		}
	}

	public Short getOptionalMaxValue() {
		return( optionalMaxValue );
	}

	public void setOptionalMaxValue( Short value ) {
		if( value == null ) {
			optionalMaxValue = null;
		}
		else if( value < CFBamInt16DefBuff.MAXVALUE_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalMaxValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.MAXVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt16DefBuff.MAXVALUE_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalMaxValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.MAXVALUE_MAX_VALUE );
		}
		else {
			optionalMaxValue = value;
		}
	}

	public Short getOptionalNullValue() {
		return( optionalNullValue );
	}

	public void setOptionalNullValue( Short value ) {
		if( value == null ) {
			optionalNullValue = null;
		}
		else if( value < CFBamInt16DefBuff.NULLVALUE_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalNullValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.NULLVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt16DefBuff.NULLVALUE_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalNullValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.NULLVALUE_MAX_VALUE );
		}
		else {
			optionalNullValue = value;
		}
	}

	public Short getOptionalUnknownValue() {
		return( optionalUnknownValue );
	}

	public void setOptionalUnknownValue( Short value ) {
		if( value == null ) {
			optionalUnknownValue = null;
		}
		else if( value < CFBamInt16DefBuff.UNKNOWNVALUE_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalUnknownValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.UNKNOWNVALUE_MIN_VALUE );
		}
		else if( value > CFBamInt16DefBuff.UNKNOWNVALUE_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalUnknownValue",
				1,
				"value",
				value,
				CFBamInt16DefBuff.UNKNOWNVALUE_MAX_VALUE );
		}
		else {
			optionalUnknownValue = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamInt16DefBuff ) {
			CFBamInt16DefBuff rhs = (CFBamInt16DefBuff)obj;
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
			if( getOptionalMinValue() != null ) {
				if( rhs.getOptionalMinValue() != null ) {
					if( ! getOptionalMinValue().equals( rhs.getOptionalMinValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( false );
				}
			}
			if( getOptionalMaxValue() != null ) {
				if( rhs.getOptionalMaxValue() != null ) {
					if( ! getOptionalMaxValue().equals( rhs.getOptionalMaxValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
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
		else if( obj instanceof CFBamInt16DefHBuff ) {
			CFBamInt16DefHBuff rhs = (CFBamInt16DefHBuff)obj;
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
			if( getOptionalMinValue() != null ) {
				if( rhs.getOptionalMinValue() != null ) {
					if( ! getOptionalMinValue().equals( rhs.getOptionalMinValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( false );
				}
			}
			if( getOptionalMaxValue() != null ) {
				if( rhs.getOptionalMaxValue() != null ) {
					if( ! getOptionalMaxValue().equals( rhs.getOptionalMaxValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
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
			hashCode = ( hashCode * 0x10000 ) + getOptionalInitValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalDefaultValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalDefaultValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalMinValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalMinValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalMaxValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalMaxValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalNullValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalNullValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getOptionalUnknownValue() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalUnknownValue();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamInt16DefBuff ) {
			CFBamInt16DefBuff rhs = (CFBamInt16DefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				Short lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() != null ) {
					Short rhsInitValue = rhs.getOptionalInitValue();
					int cmp = lhsInitValue.compareTo( rhsInitValue );
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
				Short lhsDefaultValue = getOptionalDefaultValue();
				if( rhs.getOptionalDefaultValue() != null ) {
					Short rhsDefaultValue = rhs.getOptionalDefaultValue();
					int cmp = lhsDefaultValue.compareTo( rhsDefaultValue );
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
			if( getOptionalMinValue() != null ) {
				Short lhsMinValue = getOptionalMinValue();
				if( rhs.getOptionalMinValue() != null ) {
					Short rhsMinValue = rhs.getOptionalMinValue();
					int cmp = lhsMinValue.compareTo( rhsMinValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalMaxValue() != null ) {
				Short lhsMaxValue = getOptionalMaxValue();
				if( rhs.getOptionalMaxValue() != null ) {
					Short rhsMaxValue = rhs.getOptionalMaxValue();
					int cmp = lhsMaxValue.compareTo( rhsMaxValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullValue() != null ) {
				Short lhsNullValue = getOptionalNullValue();
				if( rhs.getOptionalNullValue() != null ) {
					Short rhsNullValue = rhs.getOptionalNullValue();
					int cmp = lhsNullValue.compareTo( rhsNullValue );
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
				Short lhsUnknownValue = getOptionalUnknownValue();
				if( rhs.getOptionalUnknownValue() != null ) {
					Short rhsUnknownValue = rhs.getOptionalUnknownValue();
					int cmp = lhsUnknownValue.compareTo( rhsUnknownValue );
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
		else if( obj instanceof CFBamInt16DefHBuff ) {
			CFBamInt16DefHBuff rhs = (CFBamInt16DefHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalInitValue() != null ) {
				Short lhsInitValue = getOptionalInitValue();
				if( rhs.getOptionalInitValue() != null ) {
					Short rhsInitValue = rhs.getOptionalInitValue();
					int cmp = lhsInitValue.compareTo( rhsInitValue );
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
				Short lhsDefaultValue = getOptionalDefaultValue();
				if( rhs.getOptionalDefaultValue() != null ) {
					Short rhsDefaultValue = rhs.getOptionalDefaultValue();
					int cmp = lhsDefaultValue.compareTo( rhsDefaultValue );
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
			if( getOptionalMinValue() != null ) {
				Short lhsMinValue = getOptionalMinValue();
				if( rhs.getOptionalMinValue() != null ) {
					Short rhsMinValue = rhs.getOptionalMinValue();
					int cmp = lhsMinValue.compareTo( rhsMinValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMinValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalMaxValue() != null ) {
				Short lhsMaxValue = getOptionalMaxValue();
				if( rhs.getOptionalMaxValue() != null ) {
					Short rhsMaxValue = rhs.getOptionalMaxValue();
					int cmp = lhsMaxValue.compareTo( rhsMaxValue );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalMaxValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullValue() != null ) {
				Short lhsNullValue = getOptionalNullValue();
				if( rhs.getOptionalNullValue() != null ) {
					Short rhsNullValue = rhs.getOptionalNullValue();
					int cmp = lhsNullValue.compareTo( rhsNullValue );
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
				Short lhsUnknownValue = getOptionalUnknownValue();
				if( rhs.getOptionalUnknownValue() != null ) {
					Short rhsUnknownValue = rhs.getOptionalUnknownValue();
					int cmp = lhsUnknownValue.compareTo( rhsUnknownValue );
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
		if( src instanceof CFBamInt16DefBuff ) {
			setInt16DefBuff( (CFBamInt16DefBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamInt16DefBuff" );
		}
	}

	public void setInt16DefBuff( CFBamInt16DefBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalDefaultValue( src.getOptionalDefaultValue() );
		setOptionalMinValue( src.getOptionalMinValue() );
		setOptionalMaxValue( src.getOptionalMaxValue() );
		setOptionalNullValue( src.getOptionalNullValue() );
		setOptionalUnknownValue( src.getOptionalUnknownValue() );
	}
	
	public void set( CFBamValueHBuff src ) {
		if( src instanceof CFBamInt16DefHBuff ) {
			setInt16DefBuff( (CFBamInt16DefHBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamInt16DefHBuff" );
		}
	}

	public void setInt16DefBuff( CFBamInt16DefHBuff src ) {
		super.setAtomBuff( src );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalDefaultValue( src.getOptionalDefaultValue() );
		setOptionalMinValue( src.getOptionalMinValue() );
		setOptionalMaxValue( src.getOptionalMaxValue() );
		setOptionalNullValue( src.getOptionalNullValue() );
		setOptionalUnknownValue( src.getOptionalUnknownValue() );
	}
}
