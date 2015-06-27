// Description: Java7 implementation of a URLProtocol buffer object.

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

public class CFBamURLProtocolBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "UPRT";
	public final static String S_INIT_CREATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_CREATEDBY = UUID.fromString( S_INIT_CREATEDBY );
	public final static String S_INIT_UPDATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_UPDATEDBY = UUID.fromString( S_INIT_UPDATEDBY );
	public static final short URLPROTOCOLID_INIT_VALUE = (short)1;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String DESCRIPTION_INIT_VALUE = new String( "" );
	public final static boolean ISSECURE_INIT_VALUE = false;
	public static final short URLPROTOCOLID_MIN_VALUE = (short)1;
	protected UUID createdByUserId = CFBamURLProtocolBuff.INIT_CREATEDBY;
	protected Calendar createdAt = Calendar.getInstance();
	protected UUID updatedByUserId = CFBamURLProtocolBuff.INIT_UPDATEDBY;
	protected Calendar updatedAt = Calendar.getInstance();
	protected short requiredURLProtocolId;
	protected String requiredName;
	protected String requiredDescription;
	protected boolean requiredIsSecure;
	protected int requiredRevision;
	public CFBamURLProtocolBuff() {
		requiredURLProtocolId = CFBamURLProtocolBuff.URLPROTOCOLID_INIT_VALUE;
		requiredName = new String( CFBamURLProtocolBuff.NAME_INIT_VALUE );
		requiredDescription = new String( CFBamURLProtocolBuff.DESCRIPTION_INIT_VALUE );
		requiredIsSecure = CFBamURLProtocolBuff.ISSECURE_INIT_VALUE;
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
	public short getRequiredURLProtocolId() {
		return( requiredURLProtocolId );
	}

	public void setRequiredURLProtocolId( short value ) {
		if( value < CFBamURLProtocolBuff.URLPROTOCOLID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredURLProtocolId",
				1,
				"value",
				value,
				CFBamURLProtocolBuff.URLPROTOCOLID_MIN_VALUE );
		}
		requiredURLProtocolId = value;
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
		if( value.length() > 16 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		requiredName = value;
	}

	public String getRequiredDescription() {
		return( requiredDescription );
	}

	public void setRequiredDescription( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredDescription",
				1,
				"value" );
		}
		if( value.length() > 50 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredDescription",
				1,
				"value.length()",
				value.length(),
				50 );
		}
		requiredDescription = value;
	}

	public boolean getRequiredIsSecure() {
		return( requiredIsSecure );
	}

	public void setRequiredIsSecure( boolean value ) {
		requiredIsSecure = value;
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
		else if( obj instanceof CFBamURLProtocolBuff ) {
			CFBamURLProtocolBuff rhs = (CFBamURLProtocolBuff)obj;
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
			if( getRequiredURLProtocolId() != rhs.getRequiredURLProtocolId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
				return( false );
			}
			if( getRequiredIsSecure() != rhs.getRequiredIsSecure() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamURLProtocolPKey ) {
			CFBamURLProtocolPKey rhs = (CFBamURLProtocolPKey)obj;
			if( getRequiredURLProtocolId() != rhs.getRequiredURLProtocolId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamURLProtocolHBuff ) {
			CFBamURLProtocolHBuff rhs = (CFBamURLProtocolHBuff)obj;
			if( getRequiredURLProtocolId() != rhs.getRequiredURLProtocolId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
				return( false );
			}
			if( getRequiredIsSecure() != rhs.getRequiredIsSecure() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamURLProtocolHPKey ) {
			CFBamURLProtocolHPKey rhs = (CFBamURLProtocolHPKey)obj;
			if( getRequiredURLProtocolId() != rhs.getRequiredURLProtocolId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamURLProtocolByUNameIdxKey ) {
			CFBamURLProtocolByUNameIdxKey rhs = (CFBamURLProtocolByUNameIdxKey)obj;
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamURLProtocolByIsSecureIdxKey ) {
			CFBamURLProtocolByIsSecureIdxKey rhs = (CFBamURLProtocolByIsSecureIdxKey)obj;
			if( getRequiredIsSecure() != rhs.getRequiredIsSecure() ) {
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredURLProtocolId();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getRequiredDescription() != null ) {
			hashCode = hashCode + getRequiredDescription().hashCode();
		}
		if( getRequiredIsSecure() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamURLProtocolBuff ) {
			CFBamURLProtocolBuff rhs = (CFBamURLProtocolBuff)obj;
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
			if( getRequiredURLProtocolId() < rhs.getRequiredURLProtocolId() ) {
				return( -1 );
			}
			else if( getRequiredURLProtocolId() > rhs.getRequiredURLProtocolId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredIsSecure() ) {
				if( ! rhs.getRequiredIsSecure() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsSecure() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamURLProtocolPKey ) {
			CFBamURLProtocolPKey rhs = (CFBamURLProtocolPKey)obj;
			if( getRequiredURLProtocolId() < rhs.getRequiredURLProtocolId() ) {
				return( -1 );
			}
			else if( getRequiredURLProtocolId() > rhs.getRequiredURLProtocolId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamURLProtocolHPKey ) {
			CFBamURLProtocolHPKey rhs = (CFBamURLProtocolHPKey)obj;
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
			if( getRequiredURLProtocolId() < rhs.getRequiredURLProtocolId() ) {
				return( -1 );
			}
			else if( getRequiredURLProtocolId() > rhs.getRequiredURLProtocolId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamURLProtocolHBuff ) {
			CFBamURLProtocolHBuff rhs = (CFBamURLProtocolHBuff)obj;
			int retval = 0;
			if( getRequiredURLProtocolId() < rhs.getRequiredURLProtocolId() ) {
				return( -1 );
			}
			else if( getRequiredURLProtocolId() > rhs.getRequiredURLProtocolId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredIsSecure() ) {
				if( ! rhs.getRequiredIsSecure() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsSecure() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamURLProtocolByUNameIdxKey ) {
			CFBamURLProtocolByUNameIdxKey rhs = (CFBamURLProtocolByUNameIdxKey)obj;

			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamURLProtocolByIsSecureIdxKey ) {
			CFBamURLProtocolByIsSecureIdxKey rhs = (CFBamURLProtocolByIsSecureIdxKey)obj;

			if( getRequiredIsSecure() ) {
				if( ! rhs.getRequiredIsSecure() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsSecure() ) {
					return( -1 );
				}
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

	public void set( CFBamURLProtocolBuff src ) {
		setURLProtocolBuff( src );
	}

	public void setURLProtocolBuff( CFBamURLProtocolBuff src ) {
		setRequiredURLProtocolId( src.getRequiredURLProtocolId() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredName( src.getRequiredName() );
		setRequiredDescription( src.getRequiredDescription() );
		setRequiredIsSecure( src.getRequiredIsSecure() );
		setRequiredRevision( src.getRequiredRevision() );
	}
	
	public void set( CFBamURLProtocolHBuff src ) {
		setURLProtocolBuff( src );
	}

	public void setURLProtocolBuff( CFBamURLProtocolHBuff src ) {
		setRequiredURLProtocolId( src.getRequiredURLProtocolId() );
		setRequiredName( src.getRequiredName() );
		setRequiredDescription( src.getRequiredDescription() );
		setRequiredIsSecure( src.getRequiredIsSecure() );
	}
}
