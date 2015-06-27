// Description: Java7 implementation of a SecGroupForm buffer object.

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

public class CFBamSecGroupFormBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "SGFM";
	public final static String S_INIT_CREATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_CREATEDBY = UUID.fromString( S_INIT_CREATEDBY );
	public final static String S_INIT_UPDATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_UPDATEDBY = UUID.fromString( S_INIT_UPDATEDBY );
	public static final long CLUSTERID_INIT_VALUE = 0L;
	public static final long SECGROUPFORMID_INIT_VALUE = 0L;
	public static final int SECGROUPID_INIT_VALUE = 0;
	public static final int SECAPPID_INIT_VALUE = 0;
	public static final int SECFORMID_INIT_VALUE = 0;
	public static final long CLUSTERID_MIN_VALUE = 0L;
	public static final long SECGROUPFORMID_MIN_VALUE = 0L;
	public static final int SECGROUPID_MIN_VALUE = 0;
	public static final int SECAPPID_MIN_VALUE = 0;
	public static final int SECFORMID_MIN_VALUE = 0;
	protected UUID createdByUserId = CFBamSecGroupFormBuff.INIT_CREATEDBY;
	protected Calendar createdAt = Calendar.getInstance();
	protected UUID updatedByUserId = CFBamSecGroupFormBuff.INIT_UPDATEDBY;
	protected Calendar updatedAt = Calendar.getInstance();
	protected long requiredClusterId;
	protected long requiredSecGroupFormId;
	protected int requiredSecGroupId;
	protected int requiredSecAppId;
	protected int requiredSecFormId;
	protected int requiredRevision;
	public CFBamSecGroupFormBuff() {
		requiredClusterId = CFBamSecGroupFormBuff.CLUSTERID_INIT_VALUE;
		requiredSecGroupFormId = CFBamSecGroupFormBuff.SECGROUPFORMID_INIT_VALUE;
		requiredSecGroupId = CFBamSecGroupFormBuff.SECGROUPID_INIT_VALUE;
		requiredSecAppId = CFBamSecGroupFormBuff.SECAPPID_INIT_VALUE;
		requiredSecFormId = CFBamSecGroupFormBuff.SECFORMID_INIT_VALUE;
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
	public long getRequiredClusterId() {
		return( requiredClusterId );
	}

	public void setRequiredClusterId( long value ) {
		if( value < CFBamSecGroupFormBuff.CLUSTERID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredClusterId",
				1,
				"value",
				value,
				CFBamSecGroupFormBuff.CLUSTERID_MIN_VALUE );
		}
		requiredClusterId = value;
	}

	public long getRequiredSecGroupFormId() {
		return( requiredSecGroupFormId );
	}

	public void setRequiredSecGroupFormId( long value ) {
		if( value < CFBamSecGroupFormBuff.SECGROUPFORMID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredSecGroupFormId",
				1,
				"value",
				value,
				CFBamSecGroupFormBuff.SECGROUPFORMID_MIN_VALUE );
		}
		requiredSecGroupFormId = value;
	}

	public int getRequiredSecGroupId() {
		return( requiredSecGroupId );
	}

	public void setRequiredSecGroupId( int value ) {
		if( value < CFBamSecGroupFormBuff.SECGROUPID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredSecGroupId",
				1,
				"value",
				value,
				CFBamSecGroupFormBuff.SECGROUPID_MIN_VALUE );
		}
		requiredSecGroupId = value;
	}

	public int getRequiredSecAppId() {
		return( requiredSecAppId );
	}

	public void setRequiredSecAppId( int value ) {
		if( value < CFBamSecGroupFormBuff.SECAPPID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredSecAppId",
				1,
				"value",
				value,
				CFBamSecGroupFormBuff.SECAPPID_MIN_VALUE );
		}
		requiredSecAppId = value;
	}

	public int getRequiredSecFormId() {
		return( requiredSecFormId );
	}

	public void setRequiredSecFormId( int value ) {
		if( value < CFBamSecGroupFormBuff.SECFORMID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredSecFormId",
				1,
				"value",
				value,
				CFBamSecGroupFormBuff.SECFORMID_MIN_VALUE );
		}
		requiredSecFormId = value;
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
		else if( obj instanceof CFBamSecGroupFormBuff ) {
			CFBamSecGroupFormBuff rhs = (CFBamSecGroupFormBuff)obj;
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
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupFormId() != rhs.getRequiredSecGroupFormId() ) {
				return( false );
			}
			if( getRequiredSecGroupId() != rhs.getRequiredSecGroupId() ) {
				return( false );
			}
			if( getRequiredSecAppId() != rhs.getRequiredSecAppId() ) {
				return( false );
			}
			if( getRequiredSecFormId() != rhs.getRequiredSecFormId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupFormPKey ) {
			CFBamSecGroupFormPKey rhs = (CFBamSecGroupFormPKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupFormId() != rhs.getRequiredSecGroupFormId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupFormHBuff ) {
			CFBamSecGroupFormHBuff rhs = (CFBamSecGroupFormHBuff)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupFormId() != rhs.getRequiredSecGroupFormId() ) {
				return( false );
			}
			if( getRequiredSecGroupId() != rhs.getRequiredSecGroupId() ) {
				return( false );
			}
			if( getRequiredSecAppId() != rhs.getRequiredSecAppId() ) {
				return( false );
			}
			if( getRequiredSecFormId() != rhs.getRequiredSecFormId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupFormHPKey ) {
			CFBamSecGroupFormHPKey rhs = (CFBamSecGroupFormHPKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupFormId() != rhs.getRequiredSecGroupFormId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupFormByClusterIdxKey ) {
			CFBamSecGroupFormByClusterIdxKey rhs = (CFBamSecGroupFormByClusterIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupFormByGroupIdxKey ) {
			CFBamSecGroupFormByGroupIdxKey rhs = (CFBamSecGroupFormByGroupIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupId() != rhs.getRequiredSecGroupId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupFormByAppIdxKey ) {
			CFBamSecGroupFormByAppIdxKey rhs = (CFBamSecGroupFormByAppIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecAppId() != rhs.getRequiredSecAppId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupFormByFormIdxKey ) {
			CFBamSecGroupFormByFormIdxKey rhs = (CFBamSecGroupFormByFormIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecFormId() != rhs.getRequiredSecFormId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecGroupFormByUFormIdxKey ) {
			CFBamSecGroupFormByUFormIdxKey rhs = (CFBamSecGroupFormByUFormIdxKey)obj;
			if( getRequiredClusterId() != rhs.getRequiredClusterId() ) {
				return( false );
			}
			if( getRequiredSecGroupId() != rhs.getRequiredSecGroupId() ) {
				return( false );
			}
			if( getRequiredSecFormId() != rhs.getRequiredSecFormId() ) {
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
		hashCode = hashCode + (int)( getRequiredClusterId() );
		hashCode = hashCode + (int)( getRequiredSecGroupFormId() );
		hashCode = hashCode + getRequiredSecGroupId();
		hashCode = hashCode + getRequiredSecAppId();
		hashCode = hashCode + getRequiredSecFormId();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamSecGroupFormBuff ) {
			CFBamSecGroupFormBuff rhs = (CFBamSecGroupFormBuff)obj;
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
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupFormId() < rhs.getRequiredSecGroupFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupFormId() > rhs.getRequiredSecGroupFormId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupId() < rhs.getRequiredSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupId() > rhs.getRequiredSecGroupId() ) {
				return( 1 );
			}
			if( getRequiredSecAppId() < rhs.getRequiredSecAppId() ) {
				return( -1 );
			}
			else if( getRequiredSecAppId() > rhs.getRequiredSecAppId() ) {
				return( 1 );
			}
			if( getRequiredSecFormId() < rhs.getRequiredSecFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecFormId() > rhs.getRequiredSecFormId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupFormPKey ) {
			CFBamSecGroupFormPKey rhs = (CFBamSecGroupFormPKey)obj;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupFormId() < rhs.getRequiredSecGroupFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupFormId() > rhs.getRequiredSecGroupFormId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupFormHPKey ) {
			CFBamSecGroupFormHPKey rhs = (CFBamSecGroupFormHPKey)obj;
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
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupFormId() < rhs.getRequiredSecGroupFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupFormId() > rhs.getRequiredSecGroupFormId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupFormHBuff ) {
			CFBamSecGroupFormHBuff rhs = (CFBamSecGroupFormHBuff)obj;
			int retval = 0;
			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupFormId() < rhs.getRequiredSecGroupFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupFormId() > rhs.getRequiredSecGroupFormId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupId() < rhs.getRequiredSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupId() > rhs.getRequiredSecGroupId() ) {
				return( 1 );
			}
			if( getRequiredSecAppId() < rhs.getRequiredSecAppId() ) {
				return( -1 );
			}
			else if( getRequiredSecAppId() > rhs.getRequiredSecAppId() ) {
				return( 1 );
			}
			if( getRequiredSecFormId() < rhs.getRequiredSecFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecFormId() > rhs.getRequiredSecFormId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupFormByClusterIdxKey ) {
			CFBamSecGroupFormByClusterIdxKey rhs = (CFBamSecGroupFormByClusterIdxKey)obj;

			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupFormByGroupIdxKey ) {
			CFBamSecGroupFormByGroupIdxKey rhs = (CFBamSecGroupFormByGroupIdxKey)obj;

			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupId() < rhs.getRequiredSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupId() > rhs.getRequiredSecGroupId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupFormByAppIdxKey ) {
			CFBamSecGroupFormByAppIdxKey rhs = (CFBamSecGroupFormByAppIdxKey)obj;

			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecAppId() < rhs.getRequiredSecAppId() ) {
				return( -1 );
			}
			else if( getRequiredSecAppId() > rhs.getRequiredSecAppId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupFormByFormIdxKey ) {
			CFBamSecGroupFormByFormIdxKey rhs = (CFBamSecGroupFormByFormIdxKey)obj;

			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecFormId() < rhs.getRequiredSecFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecFormId() > rhs.getRequiredSecFormId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecGroupFormByUFormIdxKey ) {
			CFBamSecGroupFormByUFormIdxKey rhs = (CFBamSecGroupFormByUFormIdxKey)obj;

			if( getRequiredClusterId() < rhs.getRequiredClusterId() ) {
				return( -1 );
			}
			else if( getRequiredClusterId() > rhs.getRequiredClusterId() ) {
				return( 1 );
			}
			if( getRequiredSecGroupId() < rhs.getRequiredSecGroupId() ) {
				return( -1 );
			}
			else if( getRequiredSecGroupId() > rhs.getRequiredSecGroupId() ) {
				return( 1 );
			}
			if( getRequiredSecFormId() < rhs.getRequiredSecFormId() ) {
				return( -1 );
			}
			else if( getRequiredSecFormId() > rhs.getRequiredSecFormId() ) {
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

	public void set( CFBamSecGroupFormBuff src ) {
		setSecGroupFormBuff( src );
	}

	public void setSecGroupFormBuff( CFBamSecGroupFormBuff src ) {
		setRequiredClusterId( src.getRequiredClusterId() );
		setRequiredSecGroupFormId( src.getRequiredSecGroupFormId() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredSecGroupId( src.getRequiredSecGroupId() );
		setRequiredSecAppId( src.getRequiredSecAppId() );
		setRequiredSecFormId( src.getRequiredSecFormId() );
		setRequiredRevision( src.getRequiredRevision() );
	}
	
	public void set( CFBamSecGroupFormHBuff src ) {
		setSecGroupFormBuff( src );
	}

	public void setSecGroupFormBuff( CFBamSecGroupFormHBuff src ) {
		setRequiredClusterId( src.getRequiredClusterId() );
		setRequiredSecGroupFormId( src.getRequiredSecGroupFormId() );
		setRequiredSecGroupId( src.getRequiredSecGroupId() );
		setRequiredSecAppId( src.getRequiredSecAppId() );
		setRequiredSecFormId( src.getRequiredSecFormId() );
	}
}
