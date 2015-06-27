// Description: Java7 implementation of a TSecGroupInclude buffer object.

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

public class CFBamTSecGroupIncludeBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "TGNC";
	public final static String S_INIT_CREATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_CREATEDBY = UUID.fromString( S_INIT_CREATEDBY );
	public final static String S_INIT_UPDATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_UPDATEDBY = UUID.fromString( S_INIT_UPDATEDBY );
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long TSECGROUPINCLUDEID_INIT_VALUE = 0L;
	public static final int TSECGROUPID_INIT_VALUE = 0;
	public static final int INCLUDEGROUPID_INIT_VALUE = 0;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long TSECGROUPINCLUDEID_MIN_VALUE = 0L;
	public static final int TSECGROUPID_MIN_VALUE = 0;
	public static final int INCLUDEGROUPID_MIN_VALUE = 0;
	protected UUID createdByUserId = CFBamTSecGroupIncludeBuff.INIT_CREATEDBY;
	protected Calendar createdAt = Calendar.getInstance();
	protected UUID updatedByUserId = CFBamTSecGroupIncludeBuff.INIT_UPDATEDBY;
	protected Calendar updatedAt = Calendar.getInstance();
	protected long requiredTenantId;
	protected long requiredTSecGroupIncludeId;
	protected int requiredTSecGroupId;
	protected int requiredIncludeGroupId;
	protected int requiredRevision;
	public CFBamTSecGroupIncludeBuff() {
		requiredTenantId = CFBamTSecGroupIncludeBuff.TENANTID_INIT_VALUE;
		requiredTSecGroupIncludeId = CFBamTSecGroupIncludeBuff.TSECGROUPINCLUDEID_INIT_VALUE;
		requiredTSecGroupId = CFBamTSecGroupIncludeBuff.TSECGROUPID_INIT_VALUE;
		requiredIncludeGroupId = CFBamTSecGroupIncludeBuff.INCLUDEGROUPID_INIT_VALUE;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public UUID getCreatedByUserId() {
		return( createdByUserId );
	}

	public void setCreatedByUserId( UUID value ) {
		createdByUserId = value;
	}

	public Calendar getCreatedAt() {
		return( createdAt );
	}

	public void setCreatedAt( Calendar value ) {
		createdAt = value;
	}

	public UUID getUpdatedByUserId() {
		return( updatedByUserId );
	}

	public void setUpdatedByUserId( UUID value ) {
		updatedByUserId = value;
	}

	public Calendar getUpdatedAt() {
		return( updatedAt );
	}

	public void setUpdatedAt( Calendar value ) {
		updatedAt = value;
	}
	public long getRequiredTenantId() {
		return( requiredTenantId );
	}

	public void setRequiredTenantId( long value ) {
		if( value < CFBamTSecGroupIncludeBuff.TENANTID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredTenantId",
				1,
				"value",
				value,
				CFBamTSecGroupIncludeBuff.TENANTID_MIN_VALUE );
		}
		requiredTenantId = value;
	}

	public long getRequiredTSecGroupIncludeId() {
		return( requiredTSecGroupIncludeId );
	}

	public void setRequiredTSecGroupIncludeId( long value ) {
		if( value < CFBamTSecGroupIncludeBuff.TSECGROUPINCLUDEID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredTSecGroupIncludeId",
				1,
				"value",
				value,
				CFBamTSecGroupIncludeBuff.TSECGROUPINCLUDEID_MIN_VALUE );
		}
		requiredTSecGroupIncludeId = value;
	}

	public int getRequiredTSecGroupId() {
		return( requiredTSecGroupId );
	}

	public void setRequiredTSecGroupId( int value ) {
		if( value < CFBamTSecGroupIncludeBuff.TSECGROUPID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredTSecGroupId",
				1,
				"value",
				value,
				CFBamTSecGroupIncludeBuff.TSECGROUPID_MIN_VALUE );
		}
		requiredTSecGroupId = value;
	}

	public int getRequiredIncludeGroupId() {
		return( requiredIncludeGroupId );
	}

	public void setRequiredIncludeGroupId( int value ) {
		if( value < CFBamTSecGroupIncludeBuff.INCLUDEGROUPID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredIncludeGroupId",
				1,
				"value",
				value,
				CFBamTSecGroupIncludeBuff.INCLUDEGROUPID_MIN_VALUE );
		}
		requiredIncludeGroupId = value;
	}

	public int getRequiredRevision() {
		return( requiredRevision );
	}

	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamTSecGroupIncludeBuff ) {
			CFBamTSecGroupIncludeBuff rhs = (CFBamTSecGroupIncludeBuff)obj;
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupIncludeId() != rhs.getRequiredTSecGroupIncludeId() ) {
				return( false );
			}
			if( getRequiredTSecGroupId() != rhs.getRequiredTSecGroupId() ) {
				return( false );
			}
			if( getRequiredIncludeGroupId() != rhs.getRequiredIncludeGroupId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTSecGroupIncludePKey ) {
			CFBamTSecGroupIncludePKey rhs = (CFBamTSecGroupIncludePKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupIncludeId() != rhs.getRequiredTSecGroupIncludeId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTSecGroupIncludeHBuff ) {
			CFBamTSecGroupIncludeHBuff rhs = (CFBamTSecGroupIncludeHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupIncludeId() != rhs.getRequiredTSecGroupIncludeId() ) {
				return( false );
			}
			if( getRequiredTSecGroupId() != rhs.getRequiredTSecGroupId() ) {
				return( false );
			}
			if( getRequiredIncludeGroupId() != rhs.getRequiredIncludeGroupId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTSecGroupIncludeHPKey ) {
			CFBamTSecGroupIncludeHPKey rhs = (CFBamTSecGroupIncludeHPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupIncludeId() != rhs.getRequiredTSecGroupIncludeId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTSecGroupIncludeByTenantIdxKey ) {
			CFBamTSecGroupIncludeByTenantIdxKey rhs = (CFBamTSecGroupIncludeByTenantIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTSecGroupIncludeByGroupIdxKey ) {
			CFBamTSecGroupIncludeByGroupIdxKey rhs = (CFBamTSecGroupIncludeByGroupIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupId() != rhs.getRequiredTSecGroupId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTSecGroupIncludeByIncludeIdxKey ) {
			CFBamTSecGroupIncludeByIncludeIdxKey rhs = (CFBamTSecGroupIncludeByIncludeIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredIncludeGroupId() != rhs.getRequiredIncludeGroupId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTSecGroupIncludeByUIncludeIdxKey ) {
			CFBamTSecGroupIncludeByUIncludeIdxKey rhs = (CFBamTSecGroupIncludeByUIncludeIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTSecGroupId() != rhs.getRequiredTSecGroupId() ) {
				return( false );
			}
			if( getRequiredIncludeGroupId() != rhs.getRequiredIncludeGroupId() ) {
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
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = hashCode + (int)( getRequiredTenantId() );
		hashCode = hashCode + (int)( getRequiredTSecGroupIncludeId() );
		hashCode = hashCode + getRequiredTSecGroupId();
		hashCode = hashCode + getRequiredIncludeGroupId();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamTSecGroupIncludeBuff ) {
			CFBamTSecGroupIncludeBuff rhs = (CFBamTSecGroupIncludeBuff)obj;
			int retval = 0;
			{
				int cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupIncludeId() < rhs.getRequiredTSecGroupIncludeId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupIncludeId() > rhs.getRequiredTSecGroupIncludeId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupId() < rhs.getRequiredTSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupId() > rhs.getRequiredTSecGroupId() ) {
				return( 1 );
			}
			if( getRequiredIncludeGroupId() < rhs.getRequiredIncludeGroupId() ) {
				return( -1 );
			}
			else if( getRequiredIncludeGroupId() > rhs.getRequiredIncludeGroupId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTSecGroupIncludePKey ) {
			CFBamTSecGroupIncludePKey rhs = (CFBamTSecGroupIncludePKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupIncludeId() < rhs.getRequiredTSecGroupIncludeId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupIncludeId() > rhs.getRequiredTSecGroupIncludeId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTSecGroupIncludeHPKey ) {
			CFBamTSecGroupIncludeHPKey rhs = (CFBamTSecGroupIncludeHPKey)obj;
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
			if( getRequiredTSecGroupIncludeId() < rhs.getRequiredTSecGroupIncludeId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupIncludeId() > rhs.getRequiredTSecGroupIncludeId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTSecGroupIncludeHBuff ) {
			CFBamTSecGroupIncludeHBuff rhs = (CFBamTSecGroupIncludeHBuff)obj;
			int retval = 0;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupIncludeId() < rhs.getRequiredTSecGroupIncludeId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupIncludeId() > rhs.getRequiredTSecGroupIncludeId() ) {
				return( 1 );
			}
			if( getRequiredTSecGroupId() < rhs.getRequiredTSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredTSecGroupId() > rhs.getRequiredTSecGroupId() ) {
				return( 1 );
			}
			if( getRequiredIncludeGroupId() < rhs.getRequiredIncludeGroupId() ) {
				return( -1 );
			}
			else if( getRequiredIncludeGroupId() > rhs.getRequiredIncludeGroupId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTSecGroupIncludeByTenantIdxKey ) {
			CFBamTSecGroupIncludeByTenantIdxKey rhs = (CFBamTSecGroupIncludeByTenantIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamTSecGroupIncludeByGroupIdxKey ) {
			CFBamTSecGroupIncludeByGroupIdxKey rhs = (CFBamTSecGroupIncludeByGroupIdxKey)obj;

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
			}			return( 0 );
		}
		else if( obj instanceof CFBamTSecGroupIncludeByIncludeIdxKey ) {
			CFBamTSecGroupIncludeByIncludeIdxKey rhs = (CFBamTSecGroupIncludeByIncludeIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredIncludeGroupId() < rhs.getRequiredIncludeGroupId() ) {
				return( -1 );
			}
			else if( getRequiredIncludeGroupId() > rhs.getRequiredIncludeGroupId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamTSecGroupIncludeByUIncludeIdxKey ) {
			CFBamTSecGroupIncludeByUIncludeIdxKey rhs = (CFBamTSecGroupIncludeByUIncludeIdxKey)obj;

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
			if( getRequiredIncludeGroupId() < rhs.getRequiredIncludeGroupId() ) {
				return( -1 );
			}
			else if( getRequiredIncludeGroupId() > rhs.getRequiredIncludeGroupId() ) {
				return( 1 );
			}			return( 0 );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	public void set( CFBamTSecGroupIncludeBuff src ) {
		setTSecGroupIncludeBuff( src );
	}

	public void setTSecGroupIncludeBuff( CFBamTSecGroupIncludeBuff src ) {
		setRequiredTenantId( src.getRequiredTenantId() );
		setRequiredTSecGroupIncludeId( src.getRequiredTSecGroupIncludeId() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredTSecGroupId( src.getRequiredTSecGroupId() );
		setRequiredIncludeGroupId( src.getRequiredIncludeGroupId() );
		setRequiredRevision( src.getRequiredRevision() );
	}
	
	public void set( CFBamTSecGroupIncludeHBuff src ) {
		setTSecGroupIncludeBuff( src );
	}

	public void setTSecGroupIncludeBuff( CFBamTSecGroupIncludeHBuff src ) {
		setRequiredTenantId( src.getRequiredTenantId() );
		setRequiredTSecGroupIncludeId( src.getRequiredTSecGroupIncludeId() );
		setRequiredTSecGroupId( src.getRequiredTSecGroupId() );
		setRequiredIncludeGroupId( src.getRequiredIncludeGroupId() );
	}
}
