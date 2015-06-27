// Description: Java7 implementation of a DelSubDep3 buffer object.

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

public class CFBamDelSubDep3Buff

	extends CFBamDelDepBuff	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "DEL3";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long CONTTENANTID_INIT_VALUE = 0L;
	public static final long CONTDELDEP2ID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long CONTTENANTID_MIN_VALUE = 0L;
	public static final long CONTDELDEP2ID_MIN_VALUE = 0L;
	protected long requiredContTenantId;
	protected long requiredContDelDep2Id;
	protected String requiredName;
	public CFBamDelSubDep3Buff() {
		super();
		requiredContTenantId = CFBamDelSubDep3Buff.CONTTENANTID_INIT_VALUE;
		requiredContDelDep2Id = CFBamDelSubDep3Buff.CONTDELDEP2ID_INIT_VALUE;
		requiredName = new String( CFBamDelSubDep3Buff.NAME_INIT_VALUE );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public long getRequiredContTenantId() {
		return( requiredContTenantId );
	}

	public void setRequiredContTenantId( long value ) {
		if( value < CFBamDelSubDep3Buff.CONTTENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredContTenantId",
				1,
				"value",
				value,
				CFBamDelSubDep3Buff.CONTTENANTID_MIN_VALUE );
		}
		requiredContTenantId = value;
	}

	public long getRequiredContDelDep2Id() {
		return( requiredContDelDep2Id );
	}

	public void setRequiredContDelDep2Id( long value ) {
		if( value < CFBamDelSubDep3Buff.CONTDELDEP2ID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredContDelDep2Id",
				1,
				"value",
				value,
				CFBamDelSubDep3Buff.CONTDELDEP2ID_MIN_VALUE );
		}
		requiredContDelDep2Id = value;
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
		else if( obj instanceof CFBamDelSubDep3Buff ) {
			CFBamDelSubDep3Buff rhs = (CFBamDelSubDep3Buff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredContTenantId() != rhs.getRequiredContTenantId() ) {
				return( false );
			}
			if( getRequiredContDelDep2Id() != rhs.getRequiredContDelDep2Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
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
		else if( obj instanceof CFBamDelSubDep3HBuff ) {
			CFBamDelSubDep3HBuff rhs = (CFBamDelSubDep3HBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredContTenantId() != rhs.getRequiredContTenantId() ) {
				return( false );
			}
			if( getRequiredContDelDep2Id() != rhs.getRequiredContDelDep2Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
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
		else if( obj instanceof CFBamDelSubDep3ByContDelDep2IdxKey ) {
			CFBamDelSubDep3ByContDelDep2IdxKey rhs = (CFBamDelSubDep3ByContDelDep2IdxKey)obj;
			if( getRequiredContTenantId() != rhs.getRequiredContTenantId() ) {
				return( false );
			}
			if( getRequiredContDelDep2Id() != rhs.getRequiredContDelDep2Id() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep3ByUNameIdxKey ) {
			CFBamDelSubDep3ByUNameIdxKey rhs = (CFBamDelSubDep3ByUNameIdxKey)obj;
			if( getRequiredContTenantId() != rhs.getRequiredContTenantId() ) {
				return( false );
			}
			if( getRequiredContDelDep2Id() != rhs.getRequiredContDelDep2Id() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
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
		hashCode = hashCode + (int)( getRequiredContTenantId() );
		hashCode = hashCode + (int)( getRequiredContDelDep2Id() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamDelSubDep3Buff ) {
			CFBamDelSubDep3Buff rhs = (CFBamDelSubDep3Buff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredContTenantId() < rhs.getRequiredContTenantId() ) {
				return( -1 );
			}
			else if( getRequiredContTenantId() > rhs.getRequiredContTenantId() ) {
				return( 1 );
			}
			if( getRequiredContDelDep2Id() < rhs.getRequiredContDelDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredContDelDep2Id() > rhs.getRequiredContDelDep2Id() ) {
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
		else if( obj instanceof CFBamDelSubDep3HBuff ) {
			CFBamDelSubDep3HBuff rhs = (CFBamDelSubDep3HBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredContTenantId() < rhs.getRequiredContTenantId() ) {
				return( -1 );
			}
			else if( getRequiredContTenantId() > rhs.getRequiredContTenantId() ) {
				return( 1 );
			}
			if( getRequiredContDelDep2Id() < rhs.getRequiredContDelDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredContDelDep2Id() > rhs.getRequiredContDelDep2Id() ) {
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
		else if( obj instanceof CFBamDelSubDep3ByContDelDep2IdxKey ) {
			CFBamDelSubDep3ByContDelDep2IdxKey rhs = (CFBamDelSubDep3ByContDelDep2IdxKey)obj;

			if( getRequiredContTenantId() < rhs.getRequiredContTenantId() ) {
				return( -1 );
			}
			else if( getRequiredContTenantId() > rhs.getRequiredContTenantId() ) {
				return( 1 );
			}
			if( getRequiredContDelDep2Id() < rhs.getRequiredContDelDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredContDelDep2Id() > rhs.getRequiredContDelDep2Id() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamDelSubDep3ByUNameIdxKey ) {
			CFBamDelSubDep3ByUNameIdxKey rhs = (CFBamDelSubDep3ByUNameIdxKey)obj;

			if( getRequiredContTenantId() < rhs.getRequiredContTenantId() ) {
				return( -1 );
			}
			else if( getRequiredContTenantId() > rhs.getRequiredContTenantId() ) {
				return( 1 );
			}
			if( getRequiredContDelDep2Id() < rhs.getRequiredContDelDep2Id() ) {
				return( -1 );
			}
			else if( getRequiredContDelDep2Id() > rhs.getRequiredContDelDep2Id() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamScopeBuff src ) {
		if( src instanceof CFBamDelSubDep3Buff ) {
			setDelSubDep3Buff( (CFBamDelSubDep3Buff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamDelSubDep3Buff" );
		}
	}

	public void setDelSubDep3Buff( CFBamDelSubDep3Buff src ) {
		super.setDelDepBuff( src );
		setRequiredContTenantId( src.getRequiredContTenantId() );
		setRequiredContDelDep2Id( src.getRequiredContDelDep2Id() );
		setRequiredName( src.getRequiredName() );
	}
	
	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamDelSubDep3HBuff ) {
			setDelSubDep3Buff( (CFBamDelSubDep3HBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamDelSubDep3HBuff" );
		}
	}

	public void setDelSubDep3Buff( CFBamDelSubDep3HBuff src ) {
		super.setDelDepBuff( src );
		setRequiredContTenantId( src.getRequiredContTenantId() );
		setRequiredContDelDep2Id( src.getRequiredContDelDep2Id() );
		setRequiredName( src.getRequiredName() );
	}
}