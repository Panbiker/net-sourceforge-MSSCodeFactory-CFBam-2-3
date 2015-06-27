// Description: Java7 implementation of a SecUser history buffer object.

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

public class CFBamSecUserHBuff

	extends CFBamHPKey	implements Comparable<Object>,
		Serializable
{
	public static final UUID SECUSERID_INIT_VALUE = UUID.fromString( "654dbba0-eda7-11e1-aff1-0800200c9a66" );
	public static final String LOGINID_INIT_VALUE = new String( "" );
	public static final String EMAILADDRESS_INIT_VALUE = new String( "" );
	public static final UUID DEFAULTDEVSECUSERID_INIT_VALUE = UUID.fromString( "654dbba0-eda7-11e1-aff1-0800200c9a66" );
	public static final String DEFAULTDEVNAME_INIT_VALUE = new String( "" );
	public static final String PASSWORDHASH_INIT_VALUE = new String( "" );

	protected UUID requiredSecUserId;
	protected String requiredLoginId;
	protected String requiredEMailAddress;
	protected UUID optionalEMailConfirmationUuid;
	protected UUID optionalDefaultDevSecUserId;
	protected String optionalDefaultDevName;
	protected String requiredPasswordHash;
	protected UUID optionalPasswordResetUuid;
	protected int requiredRevision;
	public CFBamSecUserHBuff() {
		super();
		requiredSecUserId = UUID.fromString( CFBamSecUserBuff.SECUSERID_INIT_VALUE.toString() );
		requiredLoginId = new String( CFBamSecUserBuff.LOGINID_INIT_VALUE );
		requiredEMailAddress = new String( CFBamSecUserBuff.EMAILADDRESS_INIT_VALUE );
		optionalEMailConfirmationUuid = null;
		optionalDefaultDevSecUserId = null;
		optionalDefaultDevName = null;
		requiredPasswordHash = new String( CFBamSecUserBuff.PASSWORDHASH_INIT_VALUE );
		optionalPasswordResetUuid = null;
	}

	public String getClassCode() {
		return( CFBamSecUserBuff.CLASS_CODE );
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

	public String getRequiredLoginId() {
		return( requiredLoginId );
	}

	public void setRequiredLoginId( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredLoginId",
				1,
				"value" );
		}
		if( value.length() > 32 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredLoginId",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		requiredLoginId = value;
	}

	public String getRequiredEMailAddress() {
		return( requiredEMailAddress );
	}

	public void setRequiredEMailAddress( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredEMailAddress",
				1,
				"value" );
		}
		if( value.length() > 192 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredEMailAddress",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredEMailAddress = value;
	}

	public UUID getOptionalEMailConfirmationUuid() {
		return( optionalEMailConfirmationUuid );
	}

	public void setOptionalEMailConfirmationUuid( UUID value ) {
		if( value == null ) {
			optionalEMailConfirmationUuid = null;
		}
		else {
			optionalEMailConfirmationUuid = value;
		}
	}

	public UUID getOptionalDefaultDevSecUserId() {
		return( optionalDefaultDevSecUserId );
	}

	public void setOptionalDefaultDevSecUserId( UUID value ) {
		if( value == null ) {
			optionalDefaultDevSecUserId = null;
		}
		else {
			optionalDefaultDevSecUserId = value;
		}
	}

	public String getOptionalDefaultDevName() {
		return( optionalDefaultDevName );
	}

	public void setOptionalDefaultDevName( String value ) {
		if( value == null ) {
			optionalDefaultDevName = null;
		}
		else if( value.length() > 127 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalDefaultDevName",
				1,
				"value.length()",
				value.length(),
				127 );
		}
		else {
			optionalDefaultDevName = value;
		}
	}

	public String getRequiredPasswordHash() {
		return( requiredPasswordHash );
	}

	public void setRequiredPasswordHash( String value ) {
		if( value == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setRequiredPasswordHash",
				1,
				"value" );
		}
		if( value.length() > 256 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredPasswordHash",
				1,
				"value.length()",
				value.length(),
				256 );
		}
		requiredPasswordHash = value;
	}

	public UUID getOptionalPasswordResetUuid() {
		return( optionalPasswordResetUuid );
	}

	public void setOptionalPasswordResetUuid( UUID value ) {
		if( value == null ) {
			optionalPasswordResetUuid = null;
		}
		else {
			optionalPasswordResetUuid = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSecUserHBuff ) {
			CFBamSecUserHBuff rhs = (CFBamSecUserHBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( ! getRequiredLoginId().equals( rhs.getRequiredLoginId() ) ) {
				return( false );
			}
			if( ! getRequiredEMailAddress().equals( rhs.getRequiredEMailAddress() ) ) {
				return( false );
			}
			if( getOptionalEMailConfirmationUuid() != null ) {
				if( rhs.getOptionalEMailConfirmationUuid() != null ) {
					if( ! getOptionalEMailConfirmationUuid().equals( rhs.getOptionalEMailConfirmationUuid() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmationUuid() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultDevSecUserId() != null ) {
				if( rhs.getOptionalDefaultDevSecUserId() != null ) {
					if( ! getOptionalDefaultDevSecUserId().equals( rhs.getOptionalDefaultDevSecUserId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultDevSecUserId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultDevName() != null ) {
				if( rhs.getOptionalDefaultDevName() != null ) {
					if( ! getOptionalDefaultDevName().equals( rhs.getOptionalDefaultDevName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultDevName() != null ) {
					return( false );
				}
			}
			if( ! getRequiredPasswordHash().equals( rhs.getRequiredPasswordHash() ) ) {
				return( false );
			}
			if( getOptionalPasswordResetUuid() != null ) {
				if( rhs.getOptionalPasswordResetUuid() != null ) {
					if( ! getOptionalPasswordResetUuid().equals( rhs.getOptionalPasswordResetUuid() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSecUserBuff ) {
			CFBamSecUserBuff rhs = (CFBamSecUserBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
				return( false );
			}
			if( ! getRequiredLoginId().equals( rhs.getRequiredLoginId() ) ) {
				return( false );
			}
			if( ! getRequiredEMailAddress().equals( rhs.getRequiredEMailAddress() ) ) {
				return( false );
			}
			if( getOptionalEMailConfirmationUuid() != null ) {
				if( rhs.getOptionalEMailConfirmationUuid() != null ) {
					if( ! getOptionalEMailConfirmationUuid().equals( rhs.getOptionalEMailConfirmationUuid() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmationUuid() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultDevSecUserId() != null ) {
				if( rhs.getOptionalDefaultDevSecUserId() != null ) {
					if( ! getOptionalDefaultDevSecUserId().equals( rhs.getOptionalDefaultDevSecUserId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultDevSecUserId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultDevName() != null ) {
				if( rhs.getOptionalDefaultDevName() != null ) {
					if( ! getOptionalDefaultDevName().equals( rhs.getOptionalDefaultDevName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultDevName() != null ) {
					return( false );
				}
			}
			if( ! getRequiredPasswordHash().equals( rhs.getRequiredPasswordHash() ) ) {
				return( false );
			}
			if( getOptionalPasswordResetUuid() != null ) {
				if( rhs.getOptionalPasswordResetUuid() != null ) {
					if( ! getOptionalPasswordResetUuid().equals( rhs.getOptionalPasswordResetUuid() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSecUserByULoginIdxKey ) {
			CFBamSecUserByULoginIdxKey rhs = (CFBamSecUserByULoginIdxKey)obj;
			if( ! getRequiredLoginId().equals( rhs.getRequiredLoginId() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSecUserByEMConfIdxKey ) {
			CFBamSecUserByEMConfIdxKey rhs = (CFBamSecUserByEMConfIdxKey)obj;
			if( getOptionalEMailConfirmationUuid() != null ) {
				if( rhs.getOptionalEMailConfirmationUuid() != null ) {
					if( ! getOptionalEMailConfirmationUuid().equals( rhs.getOptionalEMailConfirmationUuid() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmationUuid() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSecUserByPwdResetIdxKey ) {
			CFBamSecUserByPwdResetIdxKey rhs = (CFBamSecUserByPwdResetIdxKey)obj;
			if( getOptionalPasswordResetUuid() != null ) {
				if( rhs.getOptionalPasswordResetUuid() != null ) {
					if( ! getOptionalPasswordResetUuid().equals( rhs.getOptionalPasswordResetUuid() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSecUserByDefDevIdxKey ) {
			CFBamSecUserByDefDevIdxKey rhs = (CFBamSecUserByDefDevIdxKey)obj;
			if( getOptionalDefaultDevSecUserId() != null ) {
				if( rhs.getOptionalDefaultDevSecUserId() != null ) {
					if( ! getOptionalDefaultDevSecUserId().equals( rhs.getOptionalDefaultDevSecUserId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultDevSecUserId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultDevName() != null ) {
				if( rhs.getOptionalDefaultDevName() != null ) {
					if( ! getOptionalDefaultDevName().equals( rhs.getOptionalDefaultDevName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultDevName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSecUserHPKey ) {
			CFBamSecUserHPKey rhs = (CFBamSecUserHPKey)obj;
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
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
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
		else if( obj instanceof CFBamSecUserPKey ) {
			CFBamSecUserPKey rhs = (CFBamSecUserPKey)obj;
			if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
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
		hashCode = hashCode + getRequiredSecUserId().hashCode();
		if( getRequiredLoginId() != null ) {
			hashCode = hashCode + getRequiredLoginId().hashCode();
		}
		if( getRequiredEMailAddress() != null ) {
			hashCode = hashCode + getRequiredEMailAddress().hashCode();
		}
		if( getOptionalEMailConfirmationUuid() != null ) {
			hashCode = hashCode + getOptionalEMailConfirmationUuid().hashCode();
		}
		if( getOptionalDefaultDevSecUserId() != null ) {
			hashCode = hashCode + getOptionalDefaultDevSecUserId().hashCode();
		}
		if( getOptionalDefaultDevName() != null ) {
			hashCode = hashCode + getOptionalDefaultDevName().hashCode();
		}
		if( getRequiredPasswordHash() != null ) {
			hashCode = hashCode + getRequiredPasswordHash().hashCode();
		}
		if( getOptionalPasswordResetUuid() != null ) {
			hashCode = hashCode + getOptionalPasswordResetUuid().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamSecUserBuff ) {
			CFBamSecUserBuff rhs = (CFBamSecUserBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecUserByULoginIdxKey ) {
			CFBamSecUserByULoginIdxKey rhs = (CFBamSecUserByULoginIdxKey)obj;

			{
				int cmp = getRequiredLoginId().compareTo( rhs.getRequiredLoginId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecUserByEMConfIdxKey ) {
			CFBamSecUserByEMConfIdxKey rhs = (CFBamSecUserByEMConfIdxKey)obj;

			if( getOptionalEMailConfirmationUuid() != null ) {
				if( rhs.getOptionalEMailConfirmationUuid() != null ) {
					int cmp = getOptionalEMailConfirmationUuid().compareTo( rhs.getOptionalEMailConfirmationUuid() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmationUuid() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecUserByPwdResetIdxKey ) {
			CFBamSecUserByPwdResetIdxKey rhs = (CFBamSecUserByPwdResetIdxKey)obj;

			if( getOptionalPasswordResetUuid() != null ) {
				if( rhs.getOptionalPasswordResetUuid() != null ) {
					int cmp = getOptionalPasswordResetUuid().compareTo( rhs.getOptionalPasswordResetUuid() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecUserByDefDevIdxKey ) {
			CFBamSecUserByDefDevIdxKey rhs = (CFBamSecUserByDefDevIdxKey)obj;

			if( getOptionalDefaultDevSecUserId() != null ) {
				if( rhs.getOptionalDefaultDevSecUserId() != null ) {
					int cmp = getOptionalDefaultDevSecUserId().compareTo( rhs.getOptionalDefaultDevSecUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultDevSecUserId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultDevName() != null ) {
				if( rhs.getOptionalDefaultDevName() != null ) {
					int cmp = getOptionalDefaultDevName().compareTo( rhs.getOptionalDefaultDevName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultDevName() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSecUserHBuff ) {
			CFBamSecUserHBuff rhs = (CFBamSecUserHBuff)obj;

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
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredLoginId().compareTo( rhs.getRequiredLoginId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredEMailAddress().compareTo( rhs.getRequiredEMailAddress() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalEMailConfirmationUuid() != null ) {
				if( rhs.getOptionalEMailConfirmationUuid() != null ) {
					int cmp = getOptionalEMailConfirmationUuid().compareTo( rhs.getOptionalEMailConfirmationUuid() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmationUuid() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultDevSecUserId() != null ) {
				if( rhs.getOptionalDefaultDevSecUserId() != null ) {
					int cmp = getOptionalDefaultDevSecUserId().compareTo( rhs.getOptionalDefaultDevSecUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultDevSecUserId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultDevName() != null ) {
				if( rhs.getOptionalDefaultDevName() != null ) {
					int cmp = getOptionalDefaultDevName().compareTo( rhs.getOptionalDefaultDevName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultDevName() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredPasswordHash().compareTo( rhs.getRequiredPasswordHash() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalPasswordResetUuid() != null ) {
				if( rhs.getOptionalPasswordResetUuid() != null ) {
					int cmp = getOptionalPasswordResetUuid().compareTo( rhs.getOptionalPasswordResetUuid() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecUserHPKey ) {
			CFBamSecUserHPKey rhs = (CFBamSecUserHPKey)obj;
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
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSecUserPKey ) {
			CFBamSecUserPKey rhs = (CFBamSecUserPKey)obj;
			{
				int cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
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

	public void set( CFBamSecUserBuff src ) {
		setSecUserBuff( src );
	}

	public void setSecUserBuff( CFBamSecUserBuff src ) {
		setRequiredSecUserId( src.getRequiredSecUserId() );
		setRequiredLoginId( src.getRequiredLoginId() );
		setRequiredEMailAddress( src.getRequiredEMailAddress() );
		setOptionalEMailConfirmationUuid( src.getOptionalEMailConfirmationUuid() );
		setOptionalDefaultDevSecUserId( src.getOptionalDefaultDevSecUserId() );
		setOptionalDefaultDevName( src.getOptionalDefaultDevName() );
		setRequiredPasswordHash( src.getRequiredPasswordHash() );
		setOptionalPasswordResetUuid( src.getOptionalPasswordResetUuid() );
		setRequiredRevision( src.getRequiredRevision() );
	}

	public void set( CFBamSecUserHBuff src ) {
		setSecUserBuff( src );
	}

	public void setSecUserBuff( CFBamSecUserHBuff src ) {
		setRequiredSecUserId( src.getRequiredSecUserId() );
		setRequiredLoginId( src.getRequiredLoginId() );
		setRequiredEMailAddress( src.getRequiredEMailAddress() );
		setOptionalEMailConfirmationUuid( src.getOptionalEMailConfirmationUuid() );
		setOptionalDefaultDevSecUserId( src.getOptionalDefaultDevSecUserId() );
		setOptionalDefaultDevName( src.getOptionalDefaultDevName() );
		setRequiredPasswordHash( src.getRequiredPasswordHash() );
		setOptionalPasswordResetUuid( src.getOptionalPasswordResetUuid() );
		setRequiredRevision( src.getRequiredRevision() );
	}
}
