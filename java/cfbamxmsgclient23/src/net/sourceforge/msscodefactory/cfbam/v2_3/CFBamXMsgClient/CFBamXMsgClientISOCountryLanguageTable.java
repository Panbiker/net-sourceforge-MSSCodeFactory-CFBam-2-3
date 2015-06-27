// Description: Java 7 XMsg Client DbIO implementation for ISOCountryLanguage.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgClient;

import java.lang.reflect.*;
import java.math.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.naming.*;
import javax.sql.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Tip.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsg.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgRspnHandler.*;

/*
 *	CFBamXMsgClientISOCountryLanguageTable XMsg Client DbIO implementation
 *	for ISOCountryLanguage.
 */
public class CFBamXMsgClientISOCountryLanguageTable
	implements ICFBamISOCountryLanguageTable
{
	private CFBamXMsgClientSchema schema;

	public CFBamXMsgClientISOCountryLanguageTable( CFBamXMsgClientSchema argSchema ) {
		schema = argSchema;
	}

	public void createISOCountryLanguage( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageBuff Buff )
	{
		final String S_ProcName = "createISOCountryLanguage";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstCreate( "\n\t\t\t", Buff )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		Object lastObjectProcessed = responseHandler.getLastObjectProcessed();
		if( lastObjectProcessed != null ) {
			ICFBamISOCountryLanguageObj realized = null;
			if( lastObjectProcessed instanceof ICFBamISOCountryLanguageObj ) {
				realized = (ICFBamISOCountryLanguageObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamISOCountryLanguageObj" );
			}
			if( realized != null ) {
				Buff.set( realized.getISOCountryLanguageBuff() );
			}
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				0,
				"responseHandler.getLastObjectProcessed()" );
		}
	}

	public CFBamISOCountryLanguageBuff readDerived( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey )
	{
		final String S_ProcName = "readDerived";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstRead( "\n\t\t\t", PKey )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		CFBamISOCountryLanguageBuff buff = null;
		Object lastObjectProcessed = responseHandler.getLastObjectProcessed();
		if( lastObjectProcessed != null ) {
			ICFBamISOCountryLanguageObj realized = null;
			if( lastObjectProcessed instanceof ICFBamISOCountryLanguageObj ) {
				realized = (ICFBamISOCountryLanguageObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamISOCountryLanguageObj" );
			}
			if( realized != null ) {
				buff = realized.getISOCountryLanguageBuff();
			}
		}
		return( buff );
	}

	public CFBamISOCountryLanguageBuff lockDerived( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstLock( "\n\t\t\t", PKey )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		CFBamISOCountryLanguageBuff buff = null;
		Object lastObjectProcessed = responseHandler.getLastObjectProcessed();
		if( lastObjectProcessed != null ) {
			ICFBamISOCountryLanguageObj realized = null;
			if( lastObjectProcessed instanceof ICFBamISOCountryLanguageObj ) {
				realized = (ICFBamISOCountryLanguageObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamISOCountryLanguageObj" );
			}
			if( realized != null ) {
				buff = realized.getISOCountryLanguageBuff();
			}
		}
		return( buff );
	}

	public CFBamISOCountryLanguageBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstReadAll( "\n\t\t\t" )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		Object sortedListObj = responseHandler.getListOfObjects();
		if( sortedListObj == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				0,
				"responseHandler.getListOfObjects" );
		}
		@SuppressWarnings("unchecked")
		List<ICFBamISOCountryLanguageObj> sortedList =
			(List<ICFBamISOCountryLanguageObj>)sortedListObj;
		int sz = sortedList.size();
		CFBamISOCountryLanguageBuff arr[] = new CFBamISOCountryLanguageBuff[ sz ];
		Iterator<ICFBamISOCountryLanguageObj> iter = sortedList.iterator();
		ICFBamISOCountryLanguageObj cur;
		for( int idx = 0; idx < sz; idx ++ ) {
			cur = (ICFBamISOCountryLanguageObj)iter.next();
			arr[idx] = cur.getISOCountryLanguageBuff();
		}
		return( arr );
	}

	public CFBamISOCountryLanguageBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		short argISOCountryId,
		short argISOLanguageId )
	{
		final String S_ProcName = "readDerivedByIdIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstReadByIdIdx( "\n\t\t\t",
							argISOCountryId,
							argISOLanguageId )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		CFBamISOCountryLanguageBuff buff = null;
		Object lastObjectProcessed = responseHandler.getLastObjectProcessed();
		if( lastObjectProcessed != null ) {
			ICFBamISOCountryLanguageObj realized = null;
			if( lastObjectProcessed instanceof ICFBamISOCountryLanguageObj ) {
				realized = (ICFBamISOCountryLanguageObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamISOCountryLanguageObj" );
			}
			if( realized != null ) {
				buff = realized.getISOCountryLanguageBuff();
			}
		}
		return( buff );
	}

	public CFBamISOCountryLanguageBuff[] readDerivedByCountryIdx( CFBamAuthorization Authorization,
		short argISOCountryId )
	{
		final String S_ProcName = "readDerivedByCountryIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstReadByCountryIdx( "\n\t\t\t",
							argISOCountryId )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		Object sortedListObj = responseHandler.getListOfObjects();
		if( sortedListObj == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				0,
				"responseHandler.getListOfObjects" );
		}
		@SuppressWarnings("unchecked")
		List<ICFBamISOCountryLanguageObj> sortedList =
			(List<ICFBamISOCountryLanguageObj>)sortedListObj;
		int sz = sortedList.size();
		CFBamISOCountryLanguageBuff arr[] = new CFBamISOCountryLanguageBuff[ sz ];
		Iterator<ICFBamISOCountryLanguageObj> iter = sortedList.iterator();
		ICFBamISOCountryLanguageObj cur;
		for( int idx = 0; idx < sz; idx ++ ) {
			cur = (ICFBamISOCountryLanguageObj)iter.next();
			arr[idx] = cur.getISOCountryLanguageBuff();
		}
		return( arr );
	}

	public CFBamISOCountryLanguageBuff[] readDerivedByLanguageIdx( CFBamAuthorization Authorization,
		short argISOLanguageId )
	{
		final String S_ProcName = "readDerivedByLanguageIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstReadByLanguageIdx( "\n\t\t\t",
							argISOLanguageId )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		Object sortedListObj = responseHandler.getListOfObjects();
		if( sortedListObj == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				0,
				"responseHandler.getListOfObjects" );
		}
		@SuppressWarnings("unchecked")
		List<ICFBamISOCountryLanguageObj> sortedList =
			(List<ICFBamISOCountryLanguageObj>)sortedListObj;
		int sz = sortedList.size();
		CFBamISOCountryLanguageBuff arr[] = new CFBamISOCountryLanguageBuff[ sz ];
		Iterator<ICFBamISOCountryLanguageObj> iter = sortedList.iterator();
		ICFBamISOCountryLanguageObj cur;
		for( int idx = 0; idx < sz; idx ++ ) {
			cur = (ICFBamISOCountryLanguageObj)iter.next();
			arr[idx] = cur.getISOCountryLanguageBuff();
		}
		return( arr );
	}

	public CFBamISOCountryLanguageBuff readBuff( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuff" );
	}

	public CFBamISOCountryLanguageBuff lockBuff( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey PKey )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"lockBuff" );
	}

	public CFBamISOCountryLanguageBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readAllBuff" );
	}

	public CFBamISOCountryLanguageBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		short argISOCountryId,
		short argISOLanguageId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuffByIdIdx" );
	}

	public CFBamISOCountryLanguageBuff[] readBuffByCountryIdx( CFBamAuthorization Authorization,
		short argISOCountryId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuffByCountryIdx" );
	}

	public CFBamISOCountryLanguageBuff[] readBuffByLanguageIdx( CFBamAuthorization Authorization,
		short argISOLanguageId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuffByLanguageIdx" );
	}

	public void updateISOCountryLanguage( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageBuff Buff )
	{
		final String S_ProcName = "updateISOCountryLanguage";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstUpdate( "\n\t\t\t", Buff )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		CFBamISOCountryLanguageBuff buff = null;
		Object lastObjectProcessed = responseHandler.getLastObjectProcessed();
		if( lastObjectProcessed != null ) {
			ICFBamISOCountryLanguageObj realized = null;
			if( lastObjectProcessed instanceof ICFBamISOCountryLanguageObj ) {
				realized = (ICFBamISOCountryLanguageObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamISOCountryLanguageObj" );
			}
			if( realized != null ) {
				buff = realized.getISOCountryLanguageBuff();
			}
		}
		if( buff != null ) {
			Buff.set( buff );
		}
	}

	public void deleteISOCountryLanguage( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageBuff Buff )
	{
		final String S_ProcName = "deleteISOCountryLanguage";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstDelete( "\n\t\t\t", Buff )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		boolean deleted = responseHandler.getDeleted();
		if( ! deleted ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Server did not respond with a Deleted message" );
		}
	}

	public void deleteISOCountryLanguageByIdIdx( CFBamAuthorization Authorization,
		short argISOCountryId,
		short argISOLanguageId )
	{
		final String S_ProcName = "deleteISOCountryLanguageByIdIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstDeleteByIdIdx( "\n\t\t\t",
							argISOCountryId,
							argISOLanguageId )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		boolean deleted = responseHandler.getDeleted();
		if( ! deleted ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Server did not respond with a Deleted message" );
		}
	}

	public void deleteISOCountryLanguageByIdIdx( CFBamAuthorization Authorization,
		CFBamISOCountryLanguagePKey argKey )
	{
		deleteISOCountryLanguageByIdIdx( Authorization,
			argKey.getRequiredISOCountryId(),
			argKey.getRequiredISOLanguageId() );
	}
	public void deleteISOCountryLanguageByCountryIdx( CFBamAuthorization Authorization,
		short argISOCountryId )
	{
		final String S_ProcName = "deleteISOCountryLanguageByCountryIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstDeleteByCountryIdx( "\n\t\t\t",
							argISOCountryId )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		boolean deleted = responseHandler.getDeleted();
		if( ! deleted ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Server did not respond with a Deleted message" );
		}
	}

	public void deleteISOCountryLanguageByCountryIdx( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageByCountryIdxKey argKey )
	{
		deleteISOCountryLanguageByCountryIdx( Authorization,
			argKey.getRequiredISOCountryId() );
	}
	public void deleteISOCountryLanguageByLanguageIdx( CFBamAuthorization Authorization,
		short argISOLanguageId )
	{
		final String S_ProcName = "deleteISOCountryLanguageByLanguageIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgISOCountryLanguageMessageFormatter.formatISOCountryLanguageRqstDeleteByLanguageIdx( "\n\t\t\t",
							argISOLanguageId )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			schema.getCFTipClientHandler().issueAppRequest( rqst );
		}
		catch( BadPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( InvalidAlgorithmParameterException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		ICFTipResponseHandler responseHandler = schema.getCFTipClientHandler().getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
		boolean deleted = responseHandler.getDeleted();
		if( ! deleted ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Server did not respond with a Deleted message" );
		}
	}

	public void deleteISOCountryLanguageByLanguageIdx( CFBamAuthorization Authorization,
		CFBamISOCountryLanguageByLanguageIdxKey argKey )
	{
		deleteISOCountryLanguageByLanguageIdx( Authorization,
			argKey.getRequiredISOLanguageId() );
	}
	public CFBamCursor openISOCountryLanguageCursorAll( CFBamAuthorization Authorization ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"openISOCountryLanguageCursorAll" );
	}

	public CFBamCursor openISOCountryLanguageCursorByCountryIdx( CFBamAuthorization Authorization,
		short argISOCountryId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"openISOCountryLanguageCursorByCountryIdx" );
	}

	public CFBamCursor openISOCountryLanguageCursorByLanguageIdx( CFBamAuthorization Authorization,
		short argISOLanguageId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"openISOCountryLanguageCursorByLanguageIdx" );
	}

	public void closeISOCountryLanguageCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"closeISOCountryLanguageCursor" );
	}

	public CFBamISOCountryLanguageBuff nextISOCountryLanguageCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"nextISOCountryLanguageCursor" );
	}

	public CFBamISOCountryLanguageBuff prevISOCountryLanguageCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"prevISOCountryLanguageCursor" );
	}

	public CFBamISOCountryLanguageBuff firstISOCountryLanguageCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"firstISOCountryLanguageCursor" );
	}

	public CFBamISOCountryLanguageBuff lastISOCountryLanguageCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"lastISOCountryLanguageCursor" );
	}

	public CFBamISOCountryLanguageBuff nthISOCountryLanguageCursor( CFBamCursor Cursor, int Idx ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"nthISOCountryLanguageCursor" );
	}

	/**
	 *	Release the prepared statements.
	 *	<p>
	 *	When the schema changes connections, the prepared statements
	 *	have to be released because they contain connection-specific
	 *	information for most databases.
	 */
	public void releasePreparedStatements() {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"releasePreparedStatements" );
	}
}
