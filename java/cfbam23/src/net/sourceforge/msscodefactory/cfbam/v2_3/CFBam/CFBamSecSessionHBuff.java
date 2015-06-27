// Description: Java7 implementation of a SecSession history buffer object.

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

public class CFBamSecSessionHBuff

	extends CFBamHPKey	implements Comparable<Object>,
		Serializable
{
	public static final UUID SECSESSIONID_INIT_VALUE = UUID.fromString( "654dbba0-eda7-11e1-aff1-0800200c9a66" );
	public static final UUID SECUSERID_INIT_VALUE = UUID.fromString( "654dbba0-eda7-11e1-aff1-0800200c9a66" );
	public static final String SECDEVNAME_INIT_VALUE = new String( "" );
	public static final int START_INIT_YEAR = 1;
	public static final int START_INIT_MONTH = 1;
	public static final int START_INIT_DAY = 1;
	public static final int START_INIT_HOUR = 0;
	public static final int START_INIT_MINUTE = 0;
	public static final int START_INIT_SECOND = 0;
	public static final Calendar START_INIT_VALUE = CFLib.getUTCGregorianCalendar( START_INIT_YEAR, START_INIT_MONTH - 1, START_INIT_DAY, START_INIT_HOUR, START_INIT_MINUTE, START_INIT_SECOND );
	public static final UUID SECPROXYID_INIT_VALUE = UUID.fromString( "654dbba0-eda7-11e1-aff1-0800200c9a66" );

	protected UUID requiredSecSessionId;
	protected UUID requiredSecUserId;
	protected String optionalSecDevName;
	protected Calendar requiredStart;
	protected Calendar optionalFinish;
	protected UUID optionalSecProxyId;
	protected int requiredRevision;
	public CFBamSecSessionHBuff() {
		super();
		requiredSecSessionId = UUID.fromString( CFBamSecSessionBuff.SECSESSIONID_INIT_VALUE.toString() );
		requiredSecUserId = UUID.fromString( CFBamSecSessionBuff.SECUSERID_INIT_VALUE.toString() );
		optionalSecDevName = null;
		requiredStart = CFLib.getUTCGregorianCalendar( CFBamSecSessionBuff.START_INIT_YEAR,
			CFBamSecSessionBuff.START_INIT_MONTH - 1,
			CFBamSecSessionBuff.START_INIT_DAY,
			CFBamSecSessionBuff.START_INIT_HOUR,
			CFBamSecSessionBuff.START_INIT_MINUTE,
			CFBamSecSessionBuff.START_INIT_SECOND );
		optionalFinish = null;
		optionalSecProxyId = null;
	}

	public String getClassCode() {
		return( CFBamSecSessionBuff.CLASS_CODE );
	}

	public UUID getRequiredSecSessionId() {
		return( requiredSecSessionId );
	}

	public void setRequiredSecSessionId( UUID value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredSecSessionId",
				1,
				"value" );
		}
		requiredSecSessionId = value;
	}

	public UUID getRequiredSecUserId() {
		return( requiredSecUserId );
	}

	public void setRequiredSecUserId( UUID value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredSecUserId",
				1,
				"value" );
		}
		requiredSecUserId = value;
	}

	public String getOptionalSecDevName() {
		return( optionalSecDevName );
	}

	public void setOptionalSecDevName( String value ) {
		if( value == null ) {
			optionalSecDevName = null;
		}
		else if( value.length() > 127 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalSecDevName",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		else {
			optionalSecDevName = value;
		}
	}

	public Calendar getRequiredStart() {
		return( requiredStart );
	}

	public void setRequiredStart( Calendar value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredStart",
				1,
				"value" );
		}
		requiredStart = value;
	}

	public Calendar getOptionalFinish() {
		return( optionalFinish );
	}

	public void setOptionalFinish( Calendar value ) {
		if( value == null ) {
			optionalFinish = null;
		}
		else {
			optionalFinish = value;
		}
	}

	public UUID getOptionalSecProxyId() {
		return( optionalSecProxyId );
	}

	public void setOptionalSecProxyId( UUID value ) {
		if( value == null ) {
			optionalSecProxyId = null;
		}
		else {
			optionalSecProxyId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSecSessionHBuff ) {
			CFBamSecSessionHBuff rhs = (CFBamSecSessionHBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( ! getRequiredSecSessionId().equals( rhs.getRequiredSecSessionId() ) ) {
				return( false );
			}
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( getOptionalSecDevName() != null ) {
				if( rhs.getOptionalSecDevName() != null ) {
					if( ! getOptionalSecDevName().equals( rhs.getOptionalSecDevName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSecDevName() != null ) {
					return( false );
				}
			}
			if( ! getRequiredStart().equals( rhs.getRequiredStart() ) ) {
				return( false );
			}
			if( getOptionalFinish() != null ) {
				if( rhs.getOptionalFinish() != null ) {
					if( ! getOptionalFinish().equals( rhs.getOptionalFinish() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFinish() != null ) {
					return( false );
				}
			}
			if( getOptionalSecProxyId() != null ) {
				if( rhs.getOptionalSecProxyId() != null ) {
					if( ! getOptionalSecProxyId().equals( rhs.getOptionalSecProxyId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSecProxyId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSecSessionBuff ) {
			CFBamSecSessionBuff rhs = (CFBamSecSessionBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( ! getRequiredSecSessionId().equals( rhs.getRequiredSecSessionId() ) ) {
				return( false );
			}
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( getOptionalSecDevName() != null ) {
				if( rhs.getOptionalSecDevName() != null ) {
					if( ! getOptionalSecDevName().equals( rhs.getOptionalSecDevName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSecDevName() != null ) {
					return( false );
				}
			}
			if( ! getRequiredStart().equals( rhs.getRequiredStart() ) ) {
				return( false );
			}
			if( getOptionalFinish() != null ) {
				if( rhs.getOptionalFinish() != null ) {
					if( ! getOptionalFinish().equals( rhs.getOptionalFinish() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFinish() != null ) {
					return( false );
				}
			}
			if( getOptionalSecProxyId() != null ) {
				if( rhs.getOptionalSecProxyId() != null ) {
					if( ! getOptionalSecProxyId().equals( rhs.getOptionalSecProxyId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSecProxyId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSecSessionBySecUserIdxKey ) {
			CFBamSecSessionBySecUserIdxKey rhs = (CFBamSecSessionBySecUserIdxKey)obj;
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecSessionBySecDevIdxKey ) {
			CFBamSecSessionBySecDevIdxKey rhs = (CFBamSecSessionBySecDevIdxKey)obj;
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( getOptionalSecDevName() != null ) {
				if( rhs.getOptionalSecDevName() != null ) {
					if( ! getOptionalSecDevName().equals( rhs.getOptionalSecDevName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSecDevName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSecSessionByStartIdxKey ) {
			CFBamSecSessionByStartIdxKey rhs = (CFBamSecSessionByStartIdxKey)obj;
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( ! getRequiredStart().equals( rhs.getRequiredStart() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecSessionByFinishIdxKey ) {
			CFBamSecSessionByFinishIdxKey rhs = (CFBamSecSessionByFinishIdxKey)obj;
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( getOptionalFinish() != null ) {
				if( rhs.getOptionalFinish() != null ) {
					if( ! getOptionalFinish().equals( rhs.getOptionalFinish() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFinish() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSecSessionBySecProxyIdxKey ) {
			CFBamSecSessionBySecProxyIdxKey rhs = (CFBamSecSessionBySecProxyIdxKey)obj;
			if( getOptionalSecProxyId() != null ) {
				if( rhs.getOptionalSecProxyId() != null ) {
					if( ! getOptionalSecProxyId().equals( rhs.getOptionalSecProxyId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSecProxyId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSecSessionHPKey ) {
			CFBamSecSessionHPKey rhs = (CFBamSecSessionHPKey)obj;
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
			if( ! getRequiredSecSessionId().equals( rhs.getRequiredSecSessionId() ) ) {
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
		else if( obj instanceof CFBamSecSessionPKey ) {
			CFBamSecSessionPKey rhs = (CFBamSecSessionPKey)obj;
			if( ! getRequiredSecSessionId().equals( rhs.getRequiredSecSessionId() ) ) {
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
		hashCode = hashCode + getRequiredSecSessionId().hashCode();
		hashCode = hashCode + getRequiredSecUserId().hashCode();
		if( getOptionalSecDevName() != null ) {
			hashCode = hashCode + getOptionalSecDevName().hashCode();
		}
		if( getRequiredStart() != null ) {
			hashCode = hashCode + getRequiredStart().hashCode();
		}
		if( getOptionalFinish() != null ) {
			hashCode = hashCode + getOptionalFinish().hashCode();
		}
		if( getOptionalSecProxyId() != null ) {
			hashCode = hashCode + getOptionalSecProxyId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamSecSessionBuff ) {
			CFBamSecSessionBuff rhs = (CFBamSecSessionBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecSessionBySecUserIdxKey ) {
			CFBamSecSessionBySecUserIdxKey rhs = (CFBamSecSessionBySecUserIdxKey)obj;

			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecSessionBySecDevIdxKey ) {
			CFBamSecSessionBySecDevIdxKey rhs = (CFBamSecSessionBySecDevIdxKey)obj;

			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalSecDevName() != null ) {
				if( rhs.getOptionalSecDevName() != null ) {
					int cmp = getOptionalSecDevName().compareTo( rhs.getOptionalSecDevName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSecDevName() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecSessionByStartIdxKey ) {
			CFBamSecSessionByStartIdxKey rhs = (CFBamSecSessionByStartIdxKey)obj;

			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredStart().compareTo( rhs.getRequiredStart() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecSessionByFinishIdxKey ) {
			CFBamSecSessionByFinishIdxKey rhs = (CFBamSecSessionByFinishIdxKey)obj;

			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalFinish() != null ) {
				if( rhs.getOptionalFinish() != null ) {
					int cmp = getOptionalFinish().compareTo( rhs.getOptionalFinish() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFinish() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecSessionBySecProxyIdxKey ) {
			CFBamSecSessionBySecProxyIdxKey rhs = (CFBamSecSessionBySecProxyIdxKey)obj;

			if( getOptionalSecProxyId() != null ) {
				if( rhs.getOptionalSecProxyId() != null ) {
					int cmp = getOptionalSecProxyId().compareTo( rhs.getOptionalSecProxyId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSecProxyId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecSessionHBuff ) {
			CFBamSecSessionHBuff rhs = (CFBamSecSessionHBuff)obj;

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
			{
				int cmp = getRequiredSecSessionId().compareTo( rhs.getRequiredSecSessionId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalSecDevName() != null ) {
				if( rhs.getOptionalSecDevName() != null ) {
					int cmp = getOptionalSecDevName().compareTo( rhs.getOptionalSecDevName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSecDevName() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredStart().compareTo( rhs.getRequiredStart() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalFinish() != null ) {
				if( rhs.getOptionalFinish() != null ) {
					int cmp = getOptionalFinish().compareTo( rhs.getOptionalFinish() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFinish() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSecProxyId() != null ) {
				if( rhs.getOptionalSecProxyId() != null ) {
					int cmp = getOptionalSecProxyId().compareTo( rhs.getOptionalSecProxyId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSecProxyId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecSessionHPKey ) {
			CFBamSecSessionHPKey rhs = (CFBamSecSessionHPKey)obj;
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
				int cmp = getRequiredSecSessionId().compareTo( rhs.getRequiredSecSessionId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecSessionPKey ) {
			CFBamSecSessionPKey rhs = (CFBamSecSessionPKey)obj;
			{
				int cmp = getRequiredSecSessionId().compareTo( rhs.getRequiredSecSessionId() );
				if( cmp != 0 ) {
					return( cmp );
				}
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

	public void set( CFBamSecSessionBuff src ) {
		setSecSessionBuff( src );
	}

	public void setSecSessionBuff( CFBamSecSessionBuff src ) {
		setRequiredSecSessionId( src.getRequiredSecSessionId() );
		setRequiredSecUserId( src.getRequiredSecUserId() );
		setOptionalSecDevName( src.getOptionalSecDevName() );
		setRequiredStart( src.getRequiredStart() );
		setOptionalFinish( src.getOptionalFinish() );
		setOptionalSecProxyId( src.getOptionalSecProxyId() );
		setRequiredRevision( src.getRequiredRevision() );
	}

	public void set( CFBamSecSessionHBuff src ) {
		setSecSessionBuff( src );
	}

	public void setSecSessionBuff( CFBamSecSessionHBuff src ) {
		setRequiredSecSessionId( src.getRequiredSecSessionId() );
		setRequiredSecUserId( src.getRequiredSecUserId() );
		setOptionalSecDevName( src.getOptionalSecDevName() );
		setRequiredStart( src.getRequiredStart() );
		setOptionalFinish( src.getOptionalFinish() );
		setOptionalSecProxyId( src.getOptionalSecProxyId() );
		setRequiredRevision( src.getRequiredRevision() );
	}
}
