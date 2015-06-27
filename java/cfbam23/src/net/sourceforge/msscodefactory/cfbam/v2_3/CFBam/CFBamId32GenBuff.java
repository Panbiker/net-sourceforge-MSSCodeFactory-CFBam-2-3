// Description: Java7 implementation of a Id32Gen buffer object.

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

public class CFBamId32GenBuff

	extends CFBamInt32TypeBuff	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "IG32";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long DISPENSERTENANTID_INIT_VALUE = 0L;
	public static final long DISPENSERID_INIT_VALUE = 0L;
	public static final short SLICE_INIT_VALUE = (short)0;
	public static final int BLOCKSIZE_INIT_VALUE = 1;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long DISPENSERTENANTID_MIN_VALUE = 0L;
	public static final long DISPENSERID_MIN_VALUE = 0L;
	public static final short SLICE_MIN_VALUE = (short)0;
	public static final int BLOCKSIZE_MIN_VALUE = 1;
	public static final short SLICE_MAX_VALUE = (short)32767;
	public static final int BLOCKSIZE_MAX_VALUE = 2147483647;
	protected Long optionalDispenserTenantId;
	protected Long optionalDispenserId;
	protected short requiredSlice;
	protected int requiredBlockSize;
	public CFBamId32GenBuff() {
		super();
		optionalDispenserTenantId = null;
		optionalDispenserId = null;
		requiredSlice = CFBamId32GenBuff.SLICE_INIT_VALUE;
		requiredBlockSize = CFBamId32GenBuff.BLOCKSIZE_INIT_VALUE;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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

	public short getRequiredSlice() {
		return( requiredSlice );
	}

	public void setRequiredSlice( short value ) {
		if( value < CFBamId32GenBuff.SLICE_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredSlice",
				1,
				"value",
				value,
				CFBamId32GenBuff.SLICE_MIN_VALUE );
		}
		if( value > CFBamId32GenBuff.SLICE_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredSlice",
				1,
				"value",
				value,
				CFBamId32GenBuff.SLICE_MAX_VALUE );
		}
		requiredSlice = value;
	}

	public int getRequiredBlockSize() {
		return( requiredBlockSize );
	}

	public void setRequiredBlockSize( int value ) {
		if( value < CFBamId32GenBuff.BLOCKSIZE_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredBlockSize",
				1,
				"value",
				value,
				CFBamId32GenBuff.BLOCKSIZE_MIN_VALUE );
		}
		if( value > CFBamId32GenBuff.BLOCKSIZE_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredBlockSize",
				1,
				"value",
				value,
				CFBamId32GenBuff.BLOCKSIZE_MAX_VALUE );
		}
		requiredBlockSize = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamId32GenBuff ) {
			CFBamId32GenBuff rhs = (CFBamId32GenBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
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
			if( getRequiredSlice() != rhs.getRequiredSlice() ) {
				return( false );
			}
			if( getRequiredBlockSize() != rhs.getRequiredBlockSize() ) {
				return( false );
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
		else if( obj instanceof CFBamId32GenHBuff ) {
			CFBamId32GenHBuff rhs = (CFBamId32GenHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
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
			if( getRequiredSlice() != rhs.getRequiredSlice() ) {
				return( false );
			}
			if( getRequiredBlockSize() != rhs.getRequiredBlockSize() ) {
				return( false );
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
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		if( getOptionalDispenserTenantId() != null ) {
			hashCode = hashCode + getOptionalDispenserTenantId().hashCode();
		}
		if( getOptionalDispenserId() != null ) {
			hashCode = hashCode + getOptionalDispenserId().hashCode();
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredSlice();
		hashCode = hashCode + getRequiredBlockSize();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamId32GenBuff ) {
			CFBamId32GenBuff rhs = (CFBamId32GenBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
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
			if( getRequiredSlice() < rhs.getRequiredSlice() ) {
				return( -1 );
			}
			else if( getRequiredSlice() > rhs.getRequiredSlice() ) {
				return( 1 );
			}
			if( getRequiredBlockSize() < rhs.getRequiredBlockSize() ) {
				return( -1 );
			}
			else if( getRequiredBlockSize() > rhs.getRequiredBlockSize() ) {
				return( 1 );
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
		else if( obj instanceof CFBamId32GenHBuff ) {
			CFBamId32GenHBuff rhs = (CFBamId32GenHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
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
			if( getRequiredSlice() < rhs.getRequiredSlice() ) {
				return( -1 );
			}
			else if( getRequiredSlice() > rhs.getRequiredSlice() ) {
				return( 1 );
			}
			if( getRequiredBlockSize() < rhs.getRequiredBlockSize() ) {
				return( -1 );
			}
			else if( getRequiredBlockSize() > rhs.getRequiredBlockSize() ) {
				return( 1 );
			}
			return( 0 );
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
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamValueBuff src ) {
		if( src instanceof CFBamId32GenBuff ) {
			setId32GenBuff( (CFBamId32GenBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamId32GenBuff" );
		}
	}

	public void setId32GenBuff( CFBamId32GenBuff src ) {
		super.setInt32TypeBuff( src );
		setOptionalDispenserTenantId( src.getOptionalDispenserTenantId() );
		setOptionalDispenserId( src.getOptionalDispenserId() );
		setRequiredSlice( src.getRequiredSlice() );
		setRequiredBlockSize( src.getRequiredBlockSize() );
	}
	
	public void set( CFBamValueHBuff src ) {
		if( src instanceof CFBamId32GenHBuff ) {
			setId32GenBuff( (CFBamId32GenHBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamId32GenHBuff" );
		}
	}

	public void setId32GenBuff( CFBamId32GenHBuff src ) {
		super.setInt32TypeBuff( src );
		setOptionalDispenserTenantId( src.getOptionalDispenserTenantId() );
		setOptionalDispenserId( src.getOptionalDispenserId() );
		setRequiredSlice( src.getRequiredSlice() );
		setRequiredBlockSize( src.getRequiredBlockSize() );
	}
}
