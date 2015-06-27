// Description: Java7 implementation of a ISOLanguage history buffer object.

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

public class CFBamISOLanguageHBuff

	extends CFBamHPKey	implements Comparable<Object>,
		Serializable
{
	public static final short ID_INIT_VALUE = (short)1;
	public static final String ISOCODE_INIT_VALUE = new String( "" );
	public static final String BASELANGUAGECODE_INIT_VALUE = new String( "" );
	public static final short ISOCOUNTRYID_INIT_VALUE = (short)124;
	public static final short ID_MIN_VALUE = (short)1;
	public static final short ISOCOUNTRYID_MIN_VALUE = (short)1;

	protected short requiredId;
	protected String requiredISOCode;
	protected String requiredBaseLanguageCode;
	protected Short optionalISOCountryId;
	protected int requiredRevision;
	public CFBamISOLanguageHBuff() {
		super();
		requiredId = CFBamISOLanguageBuff.ID_INIT_VALUE;
		requiredISOCode = new String( CFBamISOLanguageBuff.ISOCODE_INIT_VALUE );
		requiredBaseLanguageCode = new String( CFBamISOLanguageBuff.BASELANGUAGECODE_INIT_VALUE );
		optionalISOCountryId = null;
	}

	public String getClassCode() {
		return( CFBamISOLanguageBuff.CLASS_CODE );
	}

	public short getRequiredId() {
		return( requiredId );
	}

	public void setRequiredId( short value ) {
		if( value < CFBamISOLanguageBuff.ID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredId",
				1,
				"value",
				value,
				CFBamISOLanguageBuff.ID_MIN_VALUE );
		}
		requiredId = value;
	}

	public String getRequiredISOCode() {
		return( requiredISOCode );
	}

	public void setRequiredISOCode( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredISOCode",
				1,
				"value" );
		}
		if( value.length() > 5 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredISOCode",
				1,
				"value.length()",
				value.length(),
				5 );
		}
		requiredISOCode = value;
	}

	public String getRequiredBaseLanguageCode() {
		return( requiredBaseLanguageCode );
	}

	public void setRequiredBaseLanguageCode( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredBaseLanguageCode",
				1,
				"value" );
		}
		if( value.length() > 2 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredBaseLanguageCode",
				1,
				"value.length()",
				value.length(),
				2 );
		}
		requiredBaseLanguageCode = value;
	}

	public Short getOptionalISOCountryId() {
		return( optionalISOCountryId );
	}

	public void setOptionalISOCountryId( Short value ) {
		if( value == null ) {
			optionalISOCountryId = null;
		}
		else if( value < CFBamISOLanguageBuff.ISOCOUNTRYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setOptionalISOCountryId",
				1,
				"value",
				value,
				CFBamISOLanguageBuff.ISOCOUNTRYID_MIN_VALUE );
		}
		else {
			optionalISOCountryId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamISOLanguageHBuff ) {
			CFBamISOLanguageHBuff rhs = (CFBamISOLanguageHBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( ! getRequiredISOCode().equals( rhs.getRequiredISOCode() ) ) {
				return( false );
			}
			if( ! getRequiredBaseLanguageCode().equals( rhs.getRequiredBaseLanguageCode() ) ) {
				return( false );
			}
			if( getOptionalISOCountryId() != null ) {
				if( rhs.getOptionalISOCountryId() != null ) {
					if( ! getOptionalISOCountryId().equals( rhs.getOptionalISOCountryId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalISOCountryId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamISOLanguageBuff ) {
			CFBamISOLanguageBuff rhs = (CFBamISOLanguageBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( ! getRequiredISOCode().equals( rhs.getRequiredISOCode() ) ) {
				return( false );
			}
			if( ! getRequiredBaseLanguageCode().equals( rhs.getRequiredBaseLanguageCode() ) ) {
				return( false );
			}
			if( getOptionalISOCountryId() != null ) {
				if( rhs.getOptionalISOCountryId() != null ) {
					if( ! getOptionalISOCountryId().equals( rhs.getOptionalISOCountryId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalISOCountryId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamISOLanguageByBaseIdxKey ) {
			CFBamISOLanguageByBaseIdxKey rhs = (CFBamISOLanguageByBaseIdxKey)obj;
			if( ! getRequiredBaseLanguageCode().equals( rhs.getRequiredBaseLanguageCode() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamISOLanguageByCountryIdxKey ) {
			CFBamISOLanguageByCountryIdxKey rhs = (CFBamISOLanguageByCountryIdxKey)obj;
			if( getOptionalISOCountryId() != null ) {
				if( rhs.getOptionalISOCountryId() != null ) {
					if( ! getOptionalISOCountryId().equals( rhs.getOptionalISOCountryId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalISOCountryId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamISOLanguageByCodeIdxKey ) {
			CFBamISOLanguageByCodeIdxKey rhs = (CFBamISOLanguageByCodeIdxKey)obj;
			if( ! getRequiredISOCode().equals( rhs.getRequiredISOCode() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamISOLanguageHPKey ) {
			CFBamISOLanguageHPKey rhs = (CFBamISOLanguageHPKey)obj;
			{
				long lhsClusterId = getAuditClusterId();
				long rhsClusterId = rhs.getAuditClusterId();
				if( lhsClusterId != rhsClusterId ) {
					return( false );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp != null ) {
					if( rhsAuditStamp != null ) {
						if( ! lhsAuditStamp.equals( rhsAuditStamp ) ) {
							return( false );
						}
					}
					else {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			{
				short lhsActionId = getAuditActionId();
				short rhsActionId = rhs.getAuditActionId();
				if( lhsActionId != rhsActionId ) {
					return( false );
				}
			}
			{
				int lhsRevision = getRequiredRevision();
				int rhsRevision = rhs.getRequiredRevision();
				if( lhsRevision != rhsRevision ) {
					return( false );
				}
			}
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId != null ) {
					if( rhsAuditSessionId != null ) {
						if( ! lhsAuditSessionId.equals( rhsAuditSessionId ) ) {
							return( false );
						}
					}
					else {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamHPKey ) {
			CFBamHPKey rhs = (CFBamHPKey)obj;
			{
				long lhsClusterId = getAuditClusterId();
				long rhsClusterId = rhs.getAuditClusterId();
				if( lhsClusterId != rhsClusterId ) {
					return( false );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp != null ) {
					if( rhsAuditStamp != null ) {
						if( ! lhsAuditStamp.equals( rhsAuditStamp ) ) {
							return( false );
						}
					}
					else {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			{
				short lhsActionId = getAuditActionId();
				short rhsActionId = rhs.getAuditActionId();
				if( lhsActionId != rhsActionId ) {
					return( false );
				}
			}
			{
				int lhsRevision = getRequiredRevision();
				int rhsRevision = rhs.getRequiredRevision();
				if( lhsRevision != rhsRevision ) {
					return( false );
				}
			}
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId != null ) {
					if( rhsAuditSessionId != null ) {
						if( ! lhsAuditSessionId.equals( rhsAuditSessionId ) ) {
							return( false );
						}
					}
					else {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamISOLanguagePKey ) {
			CFBamISOLanguagePKey rhs = (CFBamISOLanguagePKey)obj;
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else {
			return( super.equals( obj ) );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = ( hashCode * 0x10000 ) + getRequiredId();
		if( getRequiredISOCode() != null ) {
			hashCode = hashCode + getRequiredISOCode().hashCode();
		}
		if( getRequiredBaseLanguageCode() != null ) {
			hashCode = hashCode + getRequiredBaseLanguageCode().hashCode();
		}
		if( getOptionalISOCountryId() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalISOCountryId();
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
		else if( obj instanceof CFBamISOLanguageBuff ) {
			CFBamISOLanguageBuff rhs = (CFBamISOLanguageBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamISOLanguageByBaseIdxKey ) {
			CFBamISOLanguageByBaseIdxKey rhs = (CFBamISOLanguageByBaseIdxKey)obj;

			{
				int cmp = getRequiredBaseLanguageCode().compareTo( rhs.getRequiredBaseLanguageCode() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamISOLanguageByCountryIdxKey ) {
			CFBamISOLanguageByCountryIdxKey rhs = (CFBamISOLanguageByCountryIdxKey)obj;

			if( getOptionalISOCountryId() != null ) {
				Short lhsISOCountryId = getOptionalISOCountryId();
				if( rhs.getOptionalISOCountryId() != null ) {
					Short rhsISOCountryId = rhs.getOptionalISOCountryId();
					int cmp = lhsISOCountryId.compareTo( rhsISOCountryId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalISOCountryId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamISOLanguageByCodeIdxKey ) {
			CFBamISOLanguageByCodeIdxKey rhs = (CFBamISOLanguageByCodeIdxKey)obj;

			{
				int cmp = getRequiredISOCode().compareTo( rhs.getRequiredISOCode() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamISOLanguageHBuff ) {
			CFBamISOLanguageHBuff rhs = (CFBamISOLanguageHBuff)obj;

			int retval = 0;
			{
				long lhsAuditClusterId = getAuditClusterId();
				long rhsAuditClusterId = rhs.getAuditClusterId();
				if( lhsAuditClusterId < rhsAuditClusterId ) {
					return( -1 );
				}
				else if( lhsAuditClusterId > rhsAuditClusterId ) {
					return( 1 );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp == null ) {
					if( rhsAuditStamp != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditStamp == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditStamp.compareTo( rhsAuditStamp );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			{
				short lhsAuditActionId = getAuditActionId();
				short rhsAuditActionId = rhs.getAuditActionId();
				if( lhsAuditActionId < rhsAuditActionId ) {
					return( -1 );
				}
				else if( lhsAuditActionId > rhsAuditActionId ) {
					return( 1 );
				}
			}
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
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId == null ) {
					if( rhsAuditSessionId != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditSessionId == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditSessionId.compareTo( rhsAuditSessionId );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			{
				long lhsAuditClusterId = getAuditClusterId();
				long rhsAuditClusterId = rhs.getAuditClusterId();
				if( lhsAuditClusterId < rhsAuditClusterId ) {
					return( -1 );
				}
				else if( lhsAuditClusterId > rhsAuditClusterId ) {
					return( 1 );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp == null ) {
					if( rhsAuditStamp != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditStamp == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditStamp.compareTo( rhsAuditStamp );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			{
				short lhsAuditActionId = getAuditActionId();
				short rhsAuditActionId = rhs.getAuditActionId();
				if( lhsAuditActionId < rhsAuditActionId ) {
					return( -1 );
				}
				else if( lhsAuditActionId > rhsAuditActionId ) {
					return( 1 );
				}
			}
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
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId == null ) {
					if( rhsAuditSessionId != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditSessionId == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditSessionId.compareTo( rhsAuditSessionId );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredISOCode().compareTo( rhs.getRequiredISOCode() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredBaseLanguageCode().compareTo( rhs.getRequiredBaseLanguageCode() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalISOCountryId() != null ) {
				Short lhsISOCountryId = getOptionalISOCountryId();
				if( rhs.getOptionalISOCountryId() != null ) {
					Short rhsISOCountryId = rhs.getOptionalISOCountryId();
					int cmp = lhsISOCountryId.compareTo( rhsISOCountryId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalISOCountryId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamISOLanguageHPKey ) {
			CFBamISOLanguageHPKey rhs = (CFBamISOLanguageHPKey)obj;
			{
				long lhsAuditClusterId = getAuditClusterId();
				long rhsAuditClusterId = rhs.getAuditClusterId();
				if( lhsAuditClusterId < rhsAuditClusterId ) {
					return( -1 );
				}
				else if( lhsAuditClusterId > rhsAuditClusterId ) {
					return( 1 );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp == null ) {
					if( rhsAuditStamp != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditStamp == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditStamp.compareTo( rhsAuditStamp );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			{
				short lhsAuditActionId = getAuditActionId();
				short rhsAuditActionId = rhs.getAuditActionId();
				if( lhsAuditActionId < rhsAuditActionId ) {
					return( -1 );
				}
				else if( lhsAuditActionId > rhsAuditActionId ) {
					return( 1 );
				}
			}
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
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId == null ) {
					if( rhsAuditSessionId != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditSessionId == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditSessionId.compareTo( rhsAuditSessionId );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamISOLanguagePKey ) {
			CFBamISOLanguagePKey rhs = (CFBamISOLanguagePKey)obj;
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamHPKey ) {
			CFBamHPKey rhs = (CFBamHPKey)obj;
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
			return( 0 );
		}
		else {
			return( super.compareTo( obj ) );
		}
	}

	public void set( CFBamISOLanguageBuff src ) {
		setISOLanguageBuff( src );
	}

	public void setISOLanguageBuff( CFBamISOLanguageBuff src ) {
		setRequiredId( src.getRequiredId() );
		setRequiredISOCode( src.getRequiredISOCode() );
		setRequiredBaseLanguageCode( src.getRequiredBaseLanguageCode() );
		setOptionalISOCountryId( src.getOptionalISOCountryId() );
		setRequiredRevision( src.getRequiredRevision() );
	}

	public void set( CFBamISOLanguageHBuff src ) {
		setISOLanguageBuff( src );
	}

	public void setISOLanguageBuff( CFBamISOLanguageHBuff src ) {
		setRequiredId( src.getRequiredId() );
		setRequiredISOCode( src.getRequiredISOCode() );
		setRequiredBaseLanguageCode( src.getRequiredBaseLanguageCode() );
		setOptionalISOCountryId( src.getOptionalISOCountryId() );
		setRequiredRevision( src.getRequiredRevision() );
	}
}
