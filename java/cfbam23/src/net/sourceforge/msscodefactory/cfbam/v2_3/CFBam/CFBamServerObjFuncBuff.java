// Description: Java7 implementation of a ServerObjFunc buffer object.

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

public class CFBamServerObjFuncBuff

	extends CFBamServerMethodBuff	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "SRVO";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long RETTENANTID_INIT_VALUE = 0L;
	public static final long RETTABLEID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long RETTENANTID_MIN_VALUE = 0L;
	public static final long RETTABLEID_MIN_VALUE = 0L;
	protected Long optionalRetTenantId;
	protected Long optionalRetTableId;
	public CFBamServerObjFuncBuff() {
		super();
		optionalRetTenantId = null;
		optionalRetTableId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public Long getOptionalRetTenantId() {
		return( optionalRetTenantId );
	}

	public void setOptionalRetTenantId( Long value ) {
		if( value == null ) {
			optionalRetTenantId = null;
		}
		else if( value < CFBamServerObjFuncBuff.RETTENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalRetTenantId",
				1,
				"value",
				value,
				CFBamServerObjFuncBuff.RETTENANTID_MIN_VALUE );
		}
		else {
			optionalRetTenantId = value;
		}
	}

	public Long getOptionalRetTableId() {
		return( optionalRetTableId );
	}

	public void setOptionalRetTableId( Long value ) {
		if( value == null ) {
			optionalRetTableId = null;
		}
		else if( value < CFBamServerObjFuncBuff.RETTABLEID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalRetTableId",
				1,
				"value",
				value,
				CFBamServerObjFuncBuff.RETTABLEID_MIN_VALUE );
		}
		else {
			optionalRetTableId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamServerObjFuncBuff ) {
			CFBamServerObjFuncBuff rhs = (CFBamServerObjFuncBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalRetTenantId() != null ) {
				if( rhs.getOptionalRetTenantId() != null ) {
					if( ! getOptionalRetTenantId().equals( rhs.getOptionalRetTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRetTableId() != null ) {
				if( rhs.getOptionalRetTableId() != null ) {
					if( ! getOptionalRetTableId().equals( rhs.getOptionalRetTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamScopePKey ) {
			CFBamScopePKey rhs = (CFBamScopePKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamServerObjFuncHBuff ) {
			CFBamServerObjFuncHBuff rhs = (CFBamServerObjFuncHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalRetTenantId() != null ) {
				if( rhs.getOptionalRetTenantId() != null ) {
					if( ! getOptionalRetTenantId().equals( rhs.getOptionalRetTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRetTableId() != null ) {
				if( rhs.getOptionalRetTableId() != null ) {
					if( ! getOptionalRetTableId().equals( rhs.getOptionalRetTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamScopeHPKey ) {
			CFBamScopeHPKey rhs = (CFBamScopeHPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamServerObjFuncByRetTblIdxKey ) {
			CFBamServerObjFuncByRetTblIdxKey rhs = (CFBamServerObjFuncByRetTblIdxKey)obj;
			if( getOptionalRetTenantId() != null ) {
				if( rhs.getOptionalRetTenantId() != null ) {
					if( ! getOptionalRetTenantId().equals( rhs.getOptionalRetTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalRetTableId() != null ) {
				if( rhs.getOptionalRetTableId() != null ) {
					if( ! getOptionalRetTableId().equals( rhs.getOptionalRetTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
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
		if( getOptionalRetTenantId() != null ) {
			hashCode = hashCode + getOptionalRetTenantId().hashCode();
		}
		if( getOptionalRetTableId() != null ) {
			hashCode = hashCode + getOptionalRetTableId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamServerObjFuncBuff ) {
			CFBamServerObjFuncBuff rhs = (CFBamServerObjFuncBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalRetTenantId() != null ) {
				Long lhsRetTenantId = getOptionalRetTenantId();
				if( rhs.getOptionalRetTenantId() != null ) {
					Long rhsRetTenantId = rhs.getOptionalRetTenantId();
					int cmp = lhsRetTenantId.compareTo( rhsRetTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRetTableId() != null ) {
				Long lhsRetTableId = getOptionalRetTableId();
				if( rhs.getOptionalRetTableId() != null ) {
					Long rhsRetTableId = rhs.getOptionalRetTableId();
					int cmp = lhsRetTableId.compareTo( rhsRetTableId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamScopePKey ) {
			CFBamScopePKey rhs = (CFBamScopePKey)obj;
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
		else if( obj instanceof CFBamScopeHPKey ) {
			CFBamScopeHPKey rhs = (CFBamScopeHPKey)obj;
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
		else if( obj instanceof CFBamServerObjFuncHBuff ) {
			CFBamServerObjFuncHBuff rhs = (CFBamServerObjFuncHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalRetTenantId() != null ) {
				Long lhsRetTenantId = getOptionalRetTenantId();
				if( rhs.getOptionalRetTenantId() != null ) {
					Long rhsRetTenantId = rhs.getOptionalRetTenantId();
					int cmp = lhsRetTenantId.compareTo( rhsRetTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRetTableId() != null ) {
				Long lhsRetTableId = getOptionalRetTableId();
				if( rhs.getOptionalRetTableId() != null ) {
					Long rhsRetTableId = rhs.getOptionalRetTableId();
					int cmp = lhsRetTableId.compareTo( rhsRetTableId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamServerObjFuncByRetTblIdxKey ) {
			CFBamServerObjFuncByRetTblIdxKey rhs = (CFBamServerObjFuncByRetTblIdxKey)obj;

			if( getOptionalRetTenantId() != null ) {
				Long lhsRetTenantId = getOptionalRetTenantId();
				if( rhs.getOptionalRetTenantId() != null ) {
					Long rhsRetTenantId = rhs.getOptionalRetTenantId();
					int cmp = lhsRetTenantId.compareTo( rhsRetTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalRetTableId() != null ) {
				Long lhsRetTableId = getOptionalRetTableId();
				if( rhs.getOptionalRetTableId() != null ) {
					Long rhsRetTableId = rhs.getOptionalRetTableId();
					int cmp = lhsRetTableId.compareTo( rhsRetTableId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRetTableId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamScopeBuff src ) {
		if( src instanceof CFBamServerObjFuncBuff ) {
			setServerObjFuncBuff( (CFBamServerObjFuncBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamServerObjFuncBuff" );
		}
	}

	public void setServerObjFuncBuff( CFBamServerObjFuncBuff src ) {
		super.setServerMethodBuff( src );
		setOptionalRetTenantId( src.getOptionalRetTenantId() );
		setOptionalRetTableId( src.getOptionalRetTableId() );
	}
	
	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamServerObjFuncHBuff ) {
			setServerObjFuncBuff( (CFBamServerObjFuncHBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamServerObjFuncHBuff" );
		}
	}

	public void setServerObjFuncBuff( CFBamServerObjFuncHBuff src ) {
		super.setServerMethodBuff( src );
		setOptionalRetTenantId( src.getOptionalRetTenantId() );
		setOptionalRetTableId( src.getOptionalRetTableId() );
	}
}
