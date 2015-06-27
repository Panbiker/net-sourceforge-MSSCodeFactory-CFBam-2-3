// Description: Java7 implementation of a ISOTimezone buffer object.

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

public class CFBamISOTimezoneBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "ITZN";
	public final static String S_INIT_CREATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_CREATEDBY = UUID.fromString( S_INIT_CREATEDBY );
	public final static String S_INIT_UPDATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_UPDATEDBY = UUID.fromString( S_INIT_UPDATEDBY );
	public static final short ISOTIMEZONEID_INIT_VALUE = (short)2;
	public static final String ISO8601_INIT_VALUE = new String( "" );
	public static final String TZNAME_INIT_VALUE = new String( "" );
	public static final short TZHOUROFFSET_INIT_VALUE = (short)0;
	public static final short TZMINOFFSET_INIT_VALUE = (short)0;
	public static final String DESCRIPTION_INIT_VALUE = new String( "" );
	public final static boolean VISIBLE_INIT_VALUE = true;
	public static final short ISOTIMEZONEID_MIN_VALUE = (short)1;
	public static final short TZHOUROFFSET_MIN_VALUE = (short)0;
	public static final short TZMINOFFSET_MIN_VALUE = (short)0;
	public static final short TZHOUROFFSET_MAX_VALUE = (short)24;
	public static final short TZMINOFFSET_MAX_VALUE = (short)59;
	protected UUID createdByUserId = CFBamISOTimezoneBuff.INIT_CREATEDBY;
	protected Calendar createdAt = Calendar.getInstance();
	protected UUID updatedByUserId = CFBamISOTimezoneBuff.INIT_UPDATEDBY;
	protected Calendar updatedAt = Calendar.getInstance();
	protected short requiredISOTimezoneId;
	protected String requiredIso8601;
	protected String requiredTZName;
	protected short requiredTZHourOffset;
	protected short requiredTZMinOffset;
	protected String requiredDescription;
	protected boolean requiredVisible;
	protected int requiredRevision;
	public CFBamISOTimezoneBuff() {
		requiredISOTimezoneId = CFBamISOTimezoneBuff.ISOTIMEZONEID_INIT_VALUE;
		requiredIso8601 = new String( CFBamISOTimezoneBuff.ISO8601_INIT_VALUE );
		requiredTZName = new String( CFBamISOTimezoneBuff.TZNAME_INIT_VALUE );
		requiredTZHourOffset = CFBamISOTimezoneBuff.TZHOUROFFSET_INIT_VALUE;
		requiredTZMinOffset = CFBamISOTimezoneBuff.TZMINOFFSET_INIT_VALUE;
		requiredDescription = new String( CFBamISOTimezoneBuff.DESCRIPTION_INIT_VALUE );
		requiredVisible = CFBamISOTimezoneBuff.VISIBLE_INIT_VALUE;
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
	public short getRequiredISOTimezoneId() {
		return( requiredISOTimezoneId );
	}

	public void setRequiredISOTimezoneId( short value ) {
		if( value < CFBamISOTimezoneBuff.ISOTIMEZONEID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredISOTimezoneId",
				1,
				"value",
				value,
				CFBamISOTimezoneBuff.ISOTIMEZONEID_MIN_VALUE );
		}
		requiredISOTimezoneId = value;
	}

	public String getRequiredIso8601() {
		return( requiredIso8601 );
	}

	public void setRequiredIso8601( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredIso8601",
				1,
				"value" );
		}
		if( value.length() > 5 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredIso8601",
				1,
				"value.length()",
				value.length(),
				5 );
		}
		requiredIso8601 = value;
	}

	public String getRequiredTZName() {
		return( requiredTZName );
	}

	public void setRequiredTZName( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredTZName",
				1,
				"value" );
		}
		if( value.length() > 64 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredTZName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredTZName = value;
	}

	public short getRequiredTZHourOffset() {
		return( requiredTZHourOffset );
	}

	public void setRequiredTZHourOffset( short value ) {
		if( value < CFBamISOTimezoneBuff.TZHOUROFFSET_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredTZHourOffset",
				1,
				"value",
				value,
				CFBamISOTimezoneBuff.TZHOUROFFSET_MIN_VALUE );
		}
		if( value > CFBamISOTimezoneBuff.TZHOUROFFSET_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredTZHourOffset",
				1,
				"value",
				value,
				CFBamISOTimezoneBuff.TZHOUROFFSET_MAX_VALUE );
		}
		requiredTZHourOffset = value;
	}

	public short getRequiredTZMinOffset() {
		return( requiredTZMinOffset );
	}

	public void setRequiredTZMinOffset( short value ) {
		if( value < CFBamISOTimezoneBuff.TZMINOFFSET_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredTZMinOffset",
				1,
				"value",
				value,
				CFBamISOTimezoneBuff.TZMINOFFSET_MIN_VALUE );
		}
		if( value > CFBamISOTimezoneBuff.TZMINOFFSET_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredTZMinOffset",
				1,
				"value",
				value,
				CFBamISOTimezoneBuff.TZMINOFFSET_MAX_VALUE );
		}
		requiredTZMinOffset = value;
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
		if( value.length() > 128 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredDescription",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		requiredDescription = value;
	}

	public boolean getRequiredVisible() {
		return( requiredVisible );
	}

	public void setRequiredVisible( boolean value ) {
		requiredVisible = value;
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
		else if( obj instanceof CFBamISOTimezoneBuff ) {
			CFBamISOTimezoneBuff rhs = (CFBamISOTimezoneBuff)obj;
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
			if( getRequiredISOTimezoneId() != rhs.getRequiredISOTimezoneId() ) {
				return( false );
			}
			if( ! getRequiredIso8601().equals( rhs.getRequiredIso8601() ) ) {
				return( false );
			}
			if( ! getRequiredTZName().equals( rhs.getRequiredTZName() ) ) {
				return( false );
			}
			if( getRequiredTZHourOffset() != rhs.getRequiredTZHourOffset() ) {
				return( false );
			}
			if( getRequiredTZMinOffset() != rhs.getRequiredTZMinOffset() ) {
				return( false );
			}
			if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
				return( false );
			}
			if( getRequiredVisible() != rhs.getRequiredVisible() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamISOTimezonePKey ) {
			CFBamISOTimezonePKey rhs = (CFBamISOTimezonePKey)obj;
			if( getRequiredISOTimezoneId() != rhs.getRequiredISOTimezoneId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamISOTimezoneHBuff ) {
			CFBamISOTimezoneHBuff rhs = (CFBamISOTimezoneHBuff)obj;
			if( getRequiredISOTimezoneId() != rhs.getRequiredISOTimezoneId() ) {
				return( false );
			}
			if( ! getRequiredIso8601().equals( rhs.getRequiredIso8601() ) ) {
				return( false );
			}
			if( ! getRequiredTZName().equals( rhs.getRequiredTZName() ) ) {
				return( false );
			}
			if( getRequiredTZHourOffset() != rhs.getRequiredTZHourOffset() ) {
				return( false );
			}
			if( getRequiredTZMinOffset() != rhs.getRequiredTZMinOffset() ) {
				return( false );
			}
			if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
				return( false );
			}
			if( getRequiredVisible() != rhs.getRequiredVisible() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamISOTimezoneHPKey ) {
			CFBamISOTimezoneHPKey rhs = (CFBamISOTimezoneHPKey)obj;
			if( getRequiredISOTimezoneId() != rhs.getRequiredISOTimezoneId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamISOTimezoneByOffsetIdxKey ) {
			CFBamISOTimezoneByOffsetIdxKey rhs = (CFBamISOTimezoneByOffsetIdxKey)obj;
			if( getRequiredTZHourOffset() != rhs.getRequiredTZHourOffset() ) {
				return( false );
			}
			if( getRequiredTZMinOffset() != rhs.getRequiredTZMinOffset() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamISOTimezoneByUTZNameIdxKey ) {
			CFBamISOTimezoneByUTZNameIdxKey rhs = (CFBamISOTimezoneByUTZNameIdxKey)obj;
			if( ! getRequiredTZName().equals( rhs.getRequiredTZName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamISOTimezoneByIso8601IdxKey ) {
			CFBamISOTimezoneByIso8601IdxKey rhs = (CFBamISOTimezoneByIso8601IdxKey)obj;
			if( ! getRequiredIso8601().equals( rhs.getRequiredIso8601() ) ) {
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOTimezoneId();
		if( getRequiredIso8601() != null ) {
			hashCode = hashCode + getRequiredIso8601().hashCode();
		}
		if( getRequiredTZName() != null ) {
			hashCode = hashCode + getRequiredTZName().hashCode();
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredTZHourOffset();
		hashCode = ( hashCode * 0x10000 ) + getRequiredTZMinOffset();
		if( getRequiredDescription() != null ) {
			hashCode = hashCode + getRequiredDescription().hashCode();
		}
		if( getRequiredVisible() ) {
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
		else if( obj instanceof CFBamISOTimezoneBuff ) {
			CFBamISOTimezoneBuff rhs = (CFBamISOTimezoneBuff)obj;
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
			if( getRequiredISOTimezoneId() < rhs.getRequiredISOTimezoneId() ) {
				return( -1 );
			}
			else if( getRequiredISOTimezoneId() > rhs.getRequiredISOTimezoneId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredIso8601().compareTo( rhs.getRequiredIso8601() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredTZName().compareTo( rhs.getRequiredTZName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredTZHourOffset() < rhs.getRequiredTZHourOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZHourOffset() > rhs.getRequiredTZHourOffset() ) {
				return( 1 );
			}
			if( getRequiredTZMinOffset() < rhs.getRequiredTZMinOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZMinOffset() > rhs.getRequiredTZMinOffset() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredVisible() ) {
				if( ! rhs.getRequiredVisible() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredVisible() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamISOTimezonePKey ) {
			CFBamISOTimezonePKey rhs = (CFBamISOTimezonePKey)obj;
			if( getRequiredISOTimezoneId() < rhs.getRequiredISOTimezoneId() ) {
				return( -1 );
			}
			else if( getRequiredISOTimezoneId() > rhs.getRequiredISOTimezoneId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamISOTimezoneHPKey ) {
			CFBamISOTimezoneHPKey rhs = (CFBamISOTimezoneHPKey)obj;
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
			if( getRequiredISOTimezoneId() < rhs.getRequiredISOTimezoneId() ) {
				return( -1 );
			}
			else if( getRequiredISOTimezoneId() > rhs.getRequiredISOTimezoneId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamISOTimezoneHBuff ) {
			CFBamISOTimezoneHBuff rhs = (CFBamISOTimezoneHBuff)obj;
			int retval = 0;
			if( getRequiredISOTimezoneId() < rhs.getRequiredISOTimezoneId() ) {
				return( -1 );
			}
			else if( getRequiredISOTimezoneId() > rhs.getRequiredISOTimezoneId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredIso8601().compareTo( rhs.getRequiredIso8601() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredTZName().compareTo( rhs.getRequiredTZName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredTZHourOffset() < rhs.getRequiredTZHourOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZHourOffset() > rhs.getRequiredTZHourOffset() ) {
				return( 1 );
			}
			if( getRequiredTZMinOffset() < rhs.getRequiredTZMinOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZMinOffset() > rhs.getRequiredTZMinOffset() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredVisible() ) {
				if( ! rhs.getRequiredVisible() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredVisible() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamISOTimezoneByOffsetIdxKey ) {
			CFBamISOTimezoneByOffsetIdxKey rhs = (CFBamISOTimezoneByOffsetIdxKey)obj;

			if( getRequiredTZHourOffset() < rhs.getRequiredTZHourOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZHourOffset() > rhs.getRequiredTZHourOffset() ) {
				return( 1 );
			}
			if( getRequiredTZMinOffset() < rhs.getRequiredTZMinOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZMinOffset() > rhs.getRequiredTZMinOffset() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamISOTimezoneByUTZNameIdxKey ) {
			CFBamISOTimezoneByUTZNameIdxKey rhs = (CFBamISOTimezoneByUTZNameIdxKey)obj;

			{
				int cmp = getRequiredTZName().compareTo( rhs.getRequiredTZName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamISOTimezoneByIso8601IdxKey ) {
			CFBamISOTimezoneByIso8601IdxKey rhs = (CFBamISOTimezoneByIso8601IdxKey)obj;

			{
				int cmp = getRequiredIso8601().compareTo( rhs.getRequiredIso8601() );
				if( cmp != 0 ) {
					return( cmp );
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

	public void set( CFBamISOTimezoneBuff src ) {
		setISOTimezoneBuff( src );
	}

	public void setISOTimezoneBuff( CFBamISOTimezoneBuff src ) {
		setRequiredISOTimezoneId( src.getRequiredISOTimezoneId() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredIso8601( src.getRequiredIso8601() );
		setRequiredTZName( src.getRequiredTZName() );
		setRequiredTZHourOffset( src.getRequiredTZHourOffset() );
		setRequiredTZMinOffset( src.getRequiredTZMinOffset() );
		setRequiredDescription( src.getRequiredDescription() );
		setRequiredVisible( src.getRequiredVisible() );
		setRequiredRevision( src.getRequiredRevision() );
	}
	
	public void set( CFBamISOTimezoneHBuff src ) {
		setISOTimezoneBuff( src );
	}

	public void setISOTimezoneBuff( CFBamISOTimezoneHBuff src ) {
		setRequiredISOTimezoneId( src.getRequiredISOTimezoneId() );
		setRequiredIso8601( src.getRequiredIso8601() );
		setRequiredTZName( src.getRequiredTZName() );
		setRequiredTZHourOffset( src.getRequiredTZHourOffset() );
		setRequiredTZMinOffset( src.getRequiredTZMinOffset() );
		setRequiredDescription( src.getRequiredDescription() );
		setRequiredVisible( src.getRequiredVisible() );
	}
}
