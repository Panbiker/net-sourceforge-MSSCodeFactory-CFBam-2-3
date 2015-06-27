// Description: Java7 implementation of a ISOCountryCurrency history primary key object.

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
import org.apache.commons.codec.binary.Base64;

/*
 *	CFBamISOCountryCurrencyHPKey History Primary Key for ISOCountryCurrency

 *		requiredISOCountryId	Required object attribute ISOCountryId.
 *		requiredISOCurrencyId	Required object attribute ISOCurrencyId. */
public class CFBamISOCountryCurrencyHPKey
	extends CFBamHPKey
	implements Comparable<Object>,
		Serializable
{

	protected short requiredISOCountryId;
	protected short requiredISOCurrencyId;
	public CFBamISOCountryCurrencyHPKey()
	{
		super();
		requiredISOCountryId = CFBamISOCountryCurrencyBuff.ISOCOUNTRYID_INIT_VALUE;
		requiredISOCurrencyId = CFBamISOCountryCurrencyBuff.ISOCURRENCYID_INIT_VALUE;
	}

	public short getRequiredISOCountryId() {
		return( requiredISOCountryId );
	}

	public void setRequiredISOCountryId( short value ) {
		if( value < CFBamISOCountryCurrencyBuff.ISOCOUNTRYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredISOCountryId",
				1,
				"value",
				value,
				CFBamISOCountryCurrencyBuff.ISOCOUNTRYID_MIN_VALUE );
		}
		requiredISOCountryId = value;
	}

	public short getRequiredISOCurrencyId() {
		return( requiredISOCurrencyId );
	}

	public void setRequiredISOCurrencyId( short value ) {
		if( value < CFBamISOCountryCurrencyBuff.ISOCURRENCYID_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredISOCurrencyId",
				1,
				"value",
				value,
				CFBamISOCountryCurrencyBuff.ISOCURRENCYID_MIN_VALUE );
		}
		requiredISOCurrencyId = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamISOCountryCurrencyHPKey ) {
			CFBamISOCountryCurrencyHPKey rhs = (CFBamISOCountryCurrencyHPKey)obj;
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
			if( getRequiredISOCountryId() != rhs.getRequiredISOCountryId() ) {
				return( false );
			}
			if( getRequiredISOCurrencyId() != rhs.getRequiredISOCurrencyId() ) {
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
		else if( obj instanceof CFBamISOCountryCurrencyPKey ) {
			CFBamISOCountryCurrencyPKey rhs = (CFBamISOCountryCurrencyPKey)obj;
			if( getRequiredISOCountryId() != rhs.getRequiredISOCountryId() ) {
				return( false );
			}
			if( getRequiredISOCurrencyId() != rhs.getRequiredISOCurrencyId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamISOCountryCurrencyHBuff ) {
			CFBamISOCountryCurrencyHBuff rhs = (CFBamISOCountryCurrencyHBuff)obj;
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
			if( getRequiredISOCountryId() != rhs.getRequiredISOCountryId() ) {
				return( false );
			}
			if( getRequiredISOCurrencyId() != rhs.getRequiredISOCurrencyId() ) {
				return( false );
			}
			if( getRequiredISOCountryId() != rhs.getRequiredISOCountryId() ) {
				return( false );
			}
			if( getRequiredISOCurrencyId() != rhs.getRequiredISOCurrencyId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamISOCountryCurrencyBuff ) {
			CFBamISOCountryCurrencyBuff rhs = (CFBamISOCountryCurrencyBuff)obj;
			if( getRequiredISOCountryId() != rhs.getRequiredISOCountryId() ) {
				return( false );
			}
			if( getRequiredISOCurrencyId() != rhs.getRequiredISOCurrencyId() ) {
				return( false );
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOCountryId();
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOCurrencyId();
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamISOCountryCurrencyHBuff ) {
			CFBamISOCountryCurrencyHBuff rhs = (CFBamISOCountryCurrencyHBuff)obj;
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
			if( getRequiredISOCountryId() < rhs.getRequiredISOCountryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCountryId() > rhs.getRequiredISOCountryId() ) {
				return( 1 );
			}
			if( getRequiredISOCurrencyId() < rhs.getRequiredISOCurrencyId() ) {
				return( -1 );
			}
			else if( getRequiredISOCurrencyId() > rhs.getRequiredISOCurrencyId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamISOCountryCurrencyHPKey ) {
			CFBamISOCountryCurrencyHPKey rhs = (CFBamISOCountryCurrencyHPKey)obj;
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
			if( getRequiredISOCountryId() < rhs.getRequiredISOCountryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCountryId() > rhs.getRequiredISOCountryId() ) {
				return( 1 );
			}
			if( getRequiredISOCurrencyId() < rhs.getRequiredISOCurrencyId() ) {
				return( -1 );
			}
			else if( getRequiredISOCurrencyId() > rhs.getRequiredISOCurrencyId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamHPKey ) {
			CFBamHPKey rhs = (CFBamHPKey)obj;
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
			return( 0 );
		}
		else if( obj instanceof CFBamISOCountryCurrencyPKey ) {
			CFBamISOCountryCurrencyPKey rhs = (CFBamISOCountryCurrencyPKey)obj;
			if( getRequiredISOCountryId() < rhs.getRequiredISOCountryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCountryId() > rhs.getRequiredISOCountryId() ) {
				return( 1 );
			}
			if( getRequiredISOCurrencyId() < rhs.getRequiredISOCurrencyId() ) {
				return( -1 );
			}
			else if( getRequiredISOCurrencyId() > rhs.getRequiredISOCurrencyId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamISOCountryCurrencyBuff ) {
			CFBamISOCountryCurrencyBuff rhs = (CFBamISOCountryCurrencyBuff)obj;
			if( getRequiredISOCountryId() < rhs.getRequiredISOCountryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCountryId() > rhs.getRequiredISOCountryId() ) {
				return( 1 );
			}
			if( getRequiredISOCurrencyId() < rhs.getRequiredISOCurrencyId() ) {
				return( -1 );
			}
			else if( getRequiredISOCurrencyId() > rhs.getRequiredISOCurrencyId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				"CFBamISOCountryCurrencyHPKey, CFBamISOCountryCurrencyPKey, CFBamISOCountryCurrencyBuff" );
		}
	}

	public String toString() {
		String ret = "<CFBamISOCountryCurrencyHPKey"
			+ " RequiredISOCountryId=" + "\"" + Short.toString( getRequiredISOCountryId() ) + "\""
			+ " RequiredISOCurrencyId=" + "\"" + Short.toString( getRequiredISOCurrencyId() ) + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ "/>";
		return( ret );
	}
}
