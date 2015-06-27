// Description: Java7 implementation of a StringDef history buffer object.

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

public class CFBamStringDefHBuff
	extends CFBamAtomHBuff
	implements Comparable<Object>,
		Serializable
{
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final int MAXLEN_INIT_VALUE = 0;
	public static final short SHOWLINES_INIT_VALUE = (short)1;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final int MAXLEN_MIN_VALUE = 0;
	public static final short SHOWLINES_MIN_VALUE = (short)1;
	public static final int MAXLEN_MAX_VALUE = 2147483647;
	public static final short SHOWLINES_MAX_VALUE = (short)300;

	protected int requiredMaxLen;
	protected short requiredShowLines;
	protected String optionalInitValue;
	protected String optionalDefaultValue;
	protected String optionalNullValue;
	protected String optionalUnknownValue;
	public CFBamStringDefHBuff() {
		super();
		requiredMaxLen = CFBamStringDefBuff.MAXLEN_INIT_VALUE;
		requiredShowLines = CFBamStringDefBuff.SHOWLINES_INIT_VALUE;
		optionalInitValue = null;
		optionalDefaultValue = null;
		optionalNullValue = null;
		optionalUnknownValue = null;
	}

	public String getClassCode() {
		return( CFBamStringDefBuff.CLASS_CODE );
	}

	public int getRequiredMaxLen() {
		return( requiredMaxLen );
	}

	public void setRequiredMaxLen( int value ) {
		if( value < CFBamStringDefBuff.MAXLEN_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredMaxLen",
				1,
				"value",
				value,
				CFBamStringDefBuff.MAXLEN_MIN_VALUE );
		}
		if( value > CFBamStringDefBuff.MAXLEN_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredMaxLen",
				1,
				"value",
				value,
				CFBamStringDefBuff.MAXLEN_MAX_VALUE );
		}
		requiredMaxLen = value;
	}

	public short getRequiredShowLines() {
		return( requiredShowLines );
	}

	public void setRequiredShowLines( short value ) {
		if( value < CFBamStringDefBuff.SHOWLINES_MIN_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentUnderflowException( getClass(),
				"setRequiredShowLines",
				1,
				"value",
				value,
				CFBamStringDefBuff.SHOWLINES_MIN_VALUE );
		}
		if( value > CFBamStringDefBuff.SHOWLINES_MAX_VALUE ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setRequiredShowLines",
				1,
				"value",
				value,
				CFBamStringDefBuff.SHOWLINES_MAX_VALUE );
		}
		requiredShowLines = value;
	}

	public String getOptionalInitValue() {
		return( optionalInitValue );
	}

	public void setOptionalInitValue( String value ) {
		if( value == null ) {
			optionalInitValue = null;
		}
		else if( value.length() > 500 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalInitValue",
				1,
				"value.length()",
				value.length(),
				500 );
		}
		else {
			optionalInitValue = value;
		}
	}

	public String getOptionalDefaultValue() {
		return( optionalDefaultValue );
	}

	public void setOptionalDefaultValue( String value ) {
		if( value == null ) {
			optionalDefaultValue = null;
		}
		else if( value.length() > 500 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalDefaultValue",
				1,
				"value.length()",
				value.length(),
				500 );
		}
		else {
			optionalDefaultValue = value;
		}
	}

	public String getOptionalNullValue() {
		return( optionalNullValue );
	}

	public void setOptionalNullValue( String value ) {
		if( value == null ) {
			optionalNullValue = null;
		}
		else if( value.length() > 500 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalNullValue",
				1,
				"value.length()",
				value.length(),
				500 );
		}
		else {
			optionalNullValue = value;
		}
	}

	public String getOptionalUnknownValue() {
		return( optionalUnknownValue );
	}

	public void setOptionalUnknownValue( String value ) {
		if( value == null ) {
			optionalUnknownValue = null;
		}
		else if( value.length() > 500 ) {
			throw CFLib.getDefaultExceptionFactory().newArgumentOverflowException( getClass(),
				"setOptionalUnknownValue",
				1,
				"value.length()",
				value.length(),
				500 );
		}
		else {
			optionalUnknownValue = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamStringDefHBuff ) {
			CFBamStringDefHBuff rhs = (CFBamStringDefHBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredMaxLen() != rhs.getRequiredMaxLen() ) {
				return( false );
			}
			if( getRequiredShowLines() != rhs.getRequiredShowLines() ) {
				return( false );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					if( ! getOptionalInitValue().equals( rhs.getOptionalInitValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultValue() != null ) {
				if( rhs.getOptionalDefaultValue() != null ) {
					if( ! getOptionalDefaultValue().equals( rhs.getOptionalDefaultValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultValue() != null ) {
					return( false );
				}
			}
			if( getOptionalNullValue() != null ) {
				if( rhs.getOptionalNullValue() != null ) {
					if( ! getOptionalNullValue().equals( rhs.getOptionalNullValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNullValue() != null ) {
					return( false );
				}
			}
			if( getOptionalUnknownValue() != null ) {
				if( rhs.getOptionalUnknownValue() != null ) {
					if( ! getOptionalUnknownValue().equals( rhs.getOptionalUnknownValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalUnknownValue() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamStringDefBuff ) {
			CFBamStringDefBuff rhs = (CFBamStringDefBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredMaxLen() != rhs.getRequiredMaxLen() ) {
				return( false );
			}
			if( getRequiredShowLines() != rhs.getRequiredShowLines() ) {
				return( false );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					if( ! getOptionalInitValue().equals( rhs.getOptionalInitValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultValue() != null ) {
				if( rhs.getOptionalDefaultValue() != null ) {
					if( ! getOptionalDefaultValue().equals( rhs.getOptionalDefaultValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultValue() != null ) {
					return( false );
				}
			}
			if( getOptionalNullValue() != null ) {
				if( rhs.getOptionalNullValue() != null ) {
					if( ! getOptionalNullValue().equals( rhs.getOptionalNullValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNullValue() != null ) {
					return( false );
				}
			}
			if( getOptionalUnknownValue() != null ) {
				if( rhs.getOptionalUnknownValue() != null ) {
					if( ! getOptionalUnknownValue().equals( rhs.getOptionalUnknownValue() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalUnknownValue() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			return( super.equals( obj ) );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + getRequiredMaxLen();
		hashCode = ( hashCode * 0x10000 ) + getRequiredShowLines();
		if( getOptionalInitValue() != null ) {
			hashCode = hashCode + getOptionalInitValue().hashCode();
		}
		if( getOptionalDefaultValue() != null ) {
			hashCode = hashCode + getOptionalDefaultValue().hashCode();
		}
		if( getOptionalNullValue() != null ) {
			hashCode = hashCode + getOptionalNullValue().hashCode();
		}
		if( getOptionalUnknownValue() != null ) {
			hashCode = hashCode + getOptionalUnknownValue().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamStringDefBuff ) {
			CFBamStringDefBuff rhs = (CFBamStringDefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamStringDefHBuff ) {
			CFBamStringDefHBuff rhs = (CFBamStringDefHBuff)obj;

			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
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
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredScopeId() < rhs.getRequiredScopeId() ) {
				return( -1 );
			}
			else if( getRequiredScopeId() > rhs.getRequiredScopeId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				Long lhsDefSchemaTenantId = getOptionalDefSchemaTenantId();
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					Long rhsDefSchemaTenantId = rhs.getOptionalDefSchemaTenantId();
					int cmp = lhsDefSchemaTenantId.compareTo( rhsDefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				Long lhsDefSchemaId = getOptionalDefSchemaId();
				if( rhs.getOptionalDefSchemaId() != null ) {
					Long rhsDefSchemaId = rhs.getOptionalDefSchemaId();
					int cmp = lhsDefSchemaId.compareTo( rhsDefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					int cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					int cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					int cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					int cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsNullable() ) {
				if( ! rhs.getRequiredIsNullable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsNullable() ) {
					return( -1 );
				}
			}
			if( getOptionalGenerateId() != null ) {
				Boolean lhsGenerateId = getOptionalGenerateId();
				if( rhs.getOptionalGenerateId() ) {
					Boolean rhsGenerateId = rhs.getOptionalGenerateId();
					if( lhsGenerateId ) {
						if( ! rhsGenerateId ) {
							return( 1 );
						}
					}
					else {
						if( rhsGenerateId ) {
							return( -1 );
						}
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalGenerateId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDataScopeId() != null ) {
				Short lhsDataScopeId = getOptionalDataScopeId();
				if( rhs.getOptionalDataScopeId() != null ) {
					Short rhsDataScopeId = rhs.getOptionalDataScopeId();
					int cmp = lhsDataScopeId.compareTo( rhsDataScopeId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDataScopeId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalViewAccessSecurityId() != null ) {
				Short lhsViewAccessSecurityId = getOptionalViewAccessSecurityId();
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					Short rhsViewAccessSecurityId = rhs.getOptionalViewAccessSecurityId();
					int cmp = lhsViewAccessSecurityId.compareTo( rhsViewAccessSecurityId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalViewAccessSecurityId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalEditAccessSecurityId() != null ) {
				Short lhsEditAccessSecurityId = getOptionalEditAccessSecurityId();
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					Short rhsEditAccessSecurityId = rhs.getOptionalEditAccessSecurityId();
					int cmp = lhsEditAccessSecurityId.compareTo( rhsEditAccessSecurityId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEditAccessSecurityId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalViewAccessFrequencyId() != null ) {
				Short lhsViewAccessFrequencyId = getOptionalViewAccessFrequencyId();
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					Short rhsViewAccessFrequencyId = rhs.getOptionalViewAccessFrequencyId();
					int cmp = lhsViewAccessFrequencyId.compareTo( rhsViewAccessFrequencyId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalViewAccessFrequencyId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalEditAccessFrequencyId() != null ) {
				Short lhsEditAccessFrequencyId = getOptionalEditAccessFrequencyId();
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					Short rhsEditAccessFrequencyId = rhs.getOptionalEditAccessFrequencyId();
					int cmp = lhsEditAccessFrequencyId.compareTo( rhsEditAccessFrequencyId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEditAccessFrequencyId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevTenantId() != null ) {
				Long lhsPrevTenantId = getOptionalPrevTenantId();
				if( rhs.getOptionalPrevTenantId() != null ) {
					Long rhsPrevTenantId = rhs.getOptionalPrevTenantId();
					int cmp = lhsPrevTenantId.compareTo( rhsPrevTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevId() != null ) {
				Long lhsPrevId = getOptionalPrevId();
				if( rhs.getOptionalPrevId() != null ) {
					Long rhsPrevId = rhs.getOptionalPrevId();
					int cmp = lhsPrevId.compareTo( rhsPrevId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextTenantId() != null ) {
				Long lhsNextTenantId = getOptionalNextTenantId();
				if( rhs.getOptionalNextTenantId() != null ) {
					Long rhsNextTenantId = rhs.getOptionalNextTenantId();
					int cmp = lhsNextTenantId.compareTo( rhsNextTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				Long lhsNextId = getOptionalNextId();
				if( rhs.getOptionalNextId() != null ) {
					Long rhsNextId = rhs.getOptionalNextId();
					int cmp = lhsNextId.compareTo( rhsNextId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredDefaultVisibility() ) {
				if( ! rhs.getRequiredDefaultVisibility() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredDefaultVisibility() ) {
					return( -1 );
				}
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					int cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getRequiredMaxLen() < rhs.getRequiredMaxLen() ) {
				return( -1 );
			}
			else if( getRequiredMaxLen() > rhs.getRequiredMaxLen() ) {
				return( 1 );
			}
			if( getRequiredShowLines() < rhs.getRequiredShowLines() ) {
				return( -1 );
			}
			else if( getRequiredShowLines() > rhs.getRequiredShowLines() ) {
				return( 1 );
			}
			if( getOptionalInitValue() != null ) {
				if( rhs.getOptionalInitValue() != null ) {
					int cmp = getOptionalInitValue().compareTo( rhs.getOptionalInitValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalInitValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultValue() != null ) {
				if( rhs.getOptionalDefaultValue() != null ) {
					int cmp = getOptionalDefaultValue().compareTo( rhs.getOptionalDefaultValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNullValue() != null ) {
				if( rhs.getOptionalNullValue() != null ) {
					int cmp = getOptionalNullValue().compareTo( rhs.getOptionalNullValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNullValue() != null ) {
					return( -1 );
				}
			}
			if( getOptionalUnknownValue() != null ) {
				if( rhs.getOptionalUnknownValue() != null ) {
					int cmp = getOptionalUnknownValue().compareTo( rhs.getOptionalUnknownValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalUnknownValue() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else {
			return( super.compareTo( obj ) );
		}
	}

	public void set( CFBamValueBuff src ) {
		if( src instanceof CFBamStringDefBuff ) {
			setStringDefBuff( (CFBamStringDefBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamStringDefBuff" );
		}
	}

	public void setStringDefBuff( CFBamStringDefBuff src ) {
		super.setAtomBuff( src );
		setRequiredMaxLen( src.getRequiredMaxLen() );
		setRequiredShowLines( src.getRequiredShowLines() );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalDefaultValue( src.getOptionalDefaultValue() );
		setOptionalNullValue( src.getOptionalNullValue() );
		setOptionalUnknownValue( src.getOptionalUnknownValue() );
	}

	public void set( CFBamValueHBuff src ) {
		if( src instanceof CFBamStringDefHBuff ) {
			setStringDefBuff( (CFBamStringDefHBuff)src );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamStringDefHBuff" );
		}
	}

	public void setStringDefBuff( CFBamStringDefHBuff src ) {
		super.setAtomBuff( src );
		setRequiredMaxLen( src.getRequiredMaxLen() );
		setRequiredShowLines( src.getRequiredShowLines() );
		setOptionalInitValue( src.getOptionalInitValue() );
		setOptionalDefaultValue( src.getOptionalDefaultValue() );
		setOptionalNullValue( src.getOptionalNullValue() );
		setOptionalUnknownValue( src.getOptionalUnknownValue() );
	}
}
