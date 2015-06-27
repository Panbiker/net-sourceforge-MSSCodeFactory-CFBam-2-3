// Description: Java7 implementation of a DelSubDep2 buffer object.

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

public class CFBamDelSubDep2Buff

	extends CFBamDelDepBuff	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "DEL2";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long CONTTENANTID_INIT_VALUE = 0L;
	public static final long CONTDELDEP1ID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long CONTTENANTID_MIN_VALUE = 0L;
	public static final long CONTDELDEP1ID_MIN_VALUE = 0L;
	protected long requiredContTenantId;
	protected long requiredContDelDep1Id;
	protected String requiredName;
	public CFBamDelSubDep2Buff() {
		super();
		requiredContTenantId = CFBamDelSubDep2Buff.CONTTENANTID_INIT_VALUE;
		requiredContDelDep1Id = CFBamDelSubDep2Buff.CONTDELDEP1ID_INIT_VALUE;
		requiredName = new String( CFBamDelSubDep2Buff.NAME_INIT_VALUE );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public long getRequiredContTenantId() {
		return( requiredContTenantId );
	}

	public void setRequiredContTenantId( long value ) {
		if( value < CFBamDelSubDep2Buff.CONTTENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredContTenantId",
				1,
				"value",
				value,
				CFBamDelSubDep2Buff.CONTTENANTID_MIN_VALUE );
		}
		requiredContTenantId = value;
	}

	public long getRequiredContDelDep1Id() {
		return( requiredContDelDep1Id );
	}

	public void setRequiredContDelDep1Id( long value ) {
		if( value < CFBamDelSubDep2Buff.CONTDELDEP1ID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredContDelDep1Id",
				1,
				"value",
				value,
				CFBamDelSubDep2Buff.CONTDELDEP1ID_MIN_VALUE );
		}
		requiredContDelDep1Id = value;
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
		else if( obj instanceof CFBamDelSubDep2Buff ) {
			CFBamDelSubDep2Buff rhs = (CFBamDelSubDep2Buff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredContTenantId() != rhs.getRequiredContTenantId() ) {
				return( false );
			}
			if( getRequiredContDelDep1Id() != rhs.getRequiredContDelDep1Id() ) {
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
		else if( obj instanceof CFBamDelSubDep2HBuff ) {
			CFBamDelSubDep2HBuff rhs = (CFBamDelSubDep2HBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredContTenantId() != rhs.getRequiredContTenantId() ) {
				return( false );
			}
			if( getRequiredContDelDep1Id() != rhs.getRequiredContDelDep1Id() ) {
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
		else if( obj instanceof CFBamDelSubDep2ByContDelDep1IdxKey ) {
			CFBamDelSubDep2ByContDelDep1IdxKey rhs = (CFBamDelSubDep2ByContDelDep1IdxKey)obj;
			if( getRequiredContTenantId() != rhs.getRequiredContTenantId() ) {
				return( false );
			}
			if( getRequiredContDelDep1Id() != rhs.getRequiredContDelDep1Id() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamDelSubDep2ByUNameIdxKey ) {
			CFBamDelSubDep2ByUNameIdxKey rhs = (CFBamDelSubDep2ByUNameIdxKey)obj;
			if( getRequiredContTenantId() != rhs.getRequiredContTenantId() ) {
				return( false );
			}
			if( getRequiredContDelDep1Id() != rhs.getRequiredContDelDep1Id() ) {
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
		hashCode = hashCode + (int)( getRequiredContDelDep1Id() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamDelSubDep2Buff ) {
			CFBamDelSubDep2Buff rhs = (CFBamDelSubDep2Buff)obj;
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
			if( getRequiredContDelDep1Id() < rhs.getRequiredContDelDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredContDelDep1Id() > rhs.getRequiredContDelDep1Id() ) {
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
		else if( obj instanceof CFBamDelSubDep2HBuff ) {
			CFBamDelSubDep2HBuff rhs = (CFBamDelSubDep2HBuff)obj;
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
			if( getRequiredContDelDep1Id() < rhs.getRequiredContDelDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredContDelDep1Id() > rhs.getRequiredContDelDep1Id() ) {
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
		else if( obj instanceof CFBamDelSubDep2ByContDelDep1IdxKey ) {
			CFBamDelSubDep2ByContDelDep1IdxKey rhs = (CFBamDelSubDep2ByContDelDep1IdxKey)obj;

			if( getRequiredContTenantId() < rhs.getRequiredContTenantId() ) {
				return( -1 );
			}
			else if( getRequiredContTenantId() > rhs.getRequiredContTenantId() ) {
				return( 1 );
			}
			if( getRequiredContDelDep1Id() < rhs.getRequiredContDelDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredContDelDep1Id() > rhs.getRequiredContDelDep1Id() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamDelSubDep2ByUNameIdxKey ) {
			CFBamDelSubDep2ByUNameIdxKey rhs = (CFBamDelSubDep2ByUNameIdxKey)obj;

			if( getRequiredContTenantId() < rhs.getRequiredContTenantId() ) {
				return( -1 );
			}
			else if( getRequiredContTenantId() > rhs.getRequiredContTenantId() ) {
				return( 1 );
			}
			if( getRequiredContDelDep1Id() < rhs.getRequiredContDelDep1Id() ) {
				return( -1 );
			}
			else if( getRequiredContDelDep1Id() > rhs.getRequiredContDelDep1Id() ) {
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
		if( src instanceof CFBamDelSubDep2Buff ) {
			setDelSubDep2Buff( (CFBamDelSubDep2Buff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamDelSubDep2Buff" );
		}
	}

	public void setDelSubDep2Buff( CFBamDelSubDep2Buff src ) {
		super.setDelDepBuff( src );
		setRequiredContTenantId( src.getRequiredContTenantId() );
		setRequiredContDelDep1Id( src.getRequiredContDelDep1Id() );
		setRequiredName( src.getRequiredName() );
	}
	
	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamDelSubDep2HBuff ) {
			setDelSubDep2Buff( (CFBamDelSubDep2HBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamDelSubDep2HBuff" );
		}
	}

	public void setDelSubDep2Buff( CFBamDelSubDep2HBuff src ) {
		super.setDelDepBuff( src );
		setRequiredContTenantId( src.getRequiredContTenantId() );
		setRequiredContDelDep1Id( src.getRequiredContDelDep1Id() );
		setRequiredName( src.getRequiredName() );
	}
}
