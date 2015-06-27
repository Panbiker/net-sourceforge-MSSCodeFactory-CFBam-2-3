// Description: Java 7 XMsg Client DbIO implementation for SecGroupForm.

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
 *	CFBamXMsgClientSecGroupFormTable XMsg Client DbIO implementation
 *	for SecGroupForm.
 */
public class CFBamXMsgClientSecGroupFormTable
	implements ICFBamSecGroupFormTable
{
	private CFBamXMsgClientSchema schema;

	public CFBamXMsgClientSecGroupFormTable( CFBamXMsgClientSchema argSchema ) {
		schema = argSchema;
	}

	public void createSecGroupForm( CFBamAuthorization Authorization,
		CFBamSecGroupFormBuff Buff )
	{
		final String S_ProcName = "createSecGroupForm";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstCreate( "\n\t\t\t", Buff )
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
			ICFBamSecGroupFormObj realized = null;
			if( lastObjectProcessed instanceof ICFBamSecGroupFormObj ) {
				realized = (ICFBamSecGroupFormObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamSecGroupFormObj" );
			}
			if( realized != null ) {
				Buff.set( realized.getSecGroupFormBuff() );
			}
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				0,
				"responseHandler.getLastObjectProcessed()" );
		}
	}

	public CFBamSecGroupFormBuff readDerived( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
	{
		final String S_ProcName = "readDerived";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstRead( "\n\t\t\t", PKey )
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
		CFBamSecGroupFormBuff buff = null;
		Object lastObjectProcessed = responseHandler.getLastObjectProcessed();
		if( lastObjectProcessed != null ) {
			ICFBamSecGroupFormObj realized = null;
			if( lastObjectProcessed instanceof ICFBamSecGroupFormObj ) {
				realized = (ICFBamSecGroupFormObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamSecGroupFormObj" );
			}
			if( realized != null ) {
				buff = realized.getSecGroupFormBuff();
			}
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff lockDerived( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
	{
		final String S_ProcName = "lockDerived";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstLock( "\n\t\t\t", PKey )
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
		CFBamSecGroupFormBuff buff = null;
		Object lastObjectProcessed = responseHandler.getLastObjectProcessed();
		if( lastObjectProcessed != null ) {
			ICFBamSecGroupFormObj realized = null;
			if( lastObjectProcessed instanceof ICFBamSecGroupFormObj ) {
				realized = (ICFBamSecGroupFormObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamSecGroupFormObj" );
			}
			if( realized != null ) {
				buff = realized.getSecGroupFormBuff();
			}
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff[] readAllDerived( CFBamAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstReadAll( "\n\t\t\t" )
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
		List<ICFBamSecGroupFormObj> sortedList =
			(List<ICFBamSecGroupFormObj>)sortedListObj;
		int sz = sortedList.size();
		CFBamSecGroupFormBuff arr[] = new CFBamSecGroupFormBuff[ sz ];
		Iterator<ICFBamSecGroupFormObj> iter = sortedList.iterator();
		ICFBamSecGroupFormObj cur;
		for( int idx = 0; idx < sz; idx ++ ) {
			cur = (ICFBamSecGroupFormObj)iter.next();
			arr[idx] = cur.getSecGroupFormBuff();
		}
		return( arr );
	}

	public CFBamSecGroupFormBuff readDerivedByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argSecGroupFormId )
	{
		final String S_ProcName = "readDerivedByIdIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstReadByIdIdx( "\n\t\t\t",
							argClusterId,
							argSecGroupFormId )
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
		CFBamSecGroupFormBuff buff = null;
		Object lastObjectProcessed = responseHandler.getLastObjectProcessed();
		if( lastObjectProcessed != null ) {
			ICFBamSecGroupFormObj realized = null;
			if( lastObjectProcessed instanceof ICFBamSecGroupFormObj ) {
				realized = (ICFBamSecGroupFormObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamSecGroupFormObj" );
			}
			if( realized != null ) {
				buff = realized.getSecGroupFormBuff();
			}
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff[] readDerivedByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		final String S_ProcName = "readDerivedByClusterIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstReadByClusterIdx( "\n\t\t\t",
							argClusterId )
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
		List<ICFBamSecGroupFormObj> sortedList =
			(List<ICFBamSecGroupFormObj>)sortedListObj;
		int sz = sortedList.size();
		CFBamSecGroupFormBuff arr[] = new CFBamSecGroupFormBuff[ sz ];
		Iterator<ICFBamSecGroupFormObj> iter = sortedList.iterator();
		ICFBamSecGroupFormObj cur;
		for( int idx = 0; idx < sz; idx ++ ) {
			cur = (ICFBamSecGroupFormObj)iter.next();
			arr[idx] = cur.getSecGroupFormBuff();
		}
		return( arr );
	}

	public CFBamSecGroupFormBuff[] readDerivedByGroupIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		final String S_ProcName = "readDerivedByGroupIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstReadByGroupIdx( "\n\t\t\t",
							argClusterId,
							argSecGroupId )
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
		List<ICFBamSecGroupFormObj> sortedList =
			(List<ICFBamSecGroupFormObj>)sortedListObj;
		int sz = sortedList.size();
		CFBamSecGroupFormBuff arr[] = new CFBamSecGroupFormBuff[ sz ];
		Iterator<ICFBamSecGroupFormObj> iter = sortedList.iterator();
		ICFBamSecGroupFormObj cur;
		for( int idx = 0; idx < sz; idx ++ ) {
			cur = (ICFBamSecGroupFormObj)iter.next();
			arr[idx] = cur.getSecGroupFormBuff();
		}
		return( arr );
	}

	public CFBamSecGroupFormBuff[] readDerivedByAppIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		final String S_ProcName = "readDerivedByAppIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstReadByAppIdx( "\n\t\t\t",
							argClusterId,
							argSecAppId )
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
		List<ICFBamSecGroupFormObj> sortedList =
			(List<ICFBamSecGroupFormObj>)sortedListObj;
		int sz = sortedList.size();
		CFBamSecGroupFormBuff arr[] = new CFBamSecGroupFormBuff[ sz ];
		Iterator<ICFBamSecGroupFormObj> iter = sortedList.iterator();
		ICFBamSecGroupFormObj cur;
		for( int idx = 0; idx < sz; idx ++ ) {
			cur = (ICFBamSecGroupFormObj)iter.next();
			arr[idx] = cur.getSecGroupFormBuff();
		}
		return( arr );
	}

	public CFBamSecGroupFormBuff[] readDerivedByFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecFormId )
	{
		final String S_ProcName = "readDerivedByFormIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstReadByFormIdx( "\n\t\t\t",
							argClusterId,
							argSecFormId )
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
		List<ICFBamSecGroupFormObj> sortedList =
			(List<ICFBamSecGroupFormObj>)sortedListObj;
		int sz = sortedList.size();
		CFBamSecGroupFormBuff arr[] = new CFBamSecGroupFormBuff[ sz ];
		Iterator<ICFBamSecGroupFormObj> iter = sortedList.iterator();
		ICFBamSecGroupFormObj cur;
		for( int idx = 0; idx < sz; idx ++ ) {
			cur = (ICFBamSecGroupFormObj)iter.next();
			arr[idx] = cur.getSecGroupFormBuff();
		}
		return( arr );
	}

	public CFBamSecGroupFormBuff readDerivedByUFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		int argSecFormId )
	{
		final String S_ProcName = "readDerivedByUFormIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstReadByUFormIdx( "\n\t\t\t",
							argClusterId,
							argSecGroupId,
							argSecFormId )
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
		CFBamSecGroupFormBuff buff = null;
		Object lastObjectProcessed = responseHandler.getLastObjectProcessed();
		if( lastObjectProcessed != null ) {
			ICFBamSecGroupFormObj realized = null;
			if( lastObjectProcessed instanceof ICFBamSecGroupFormObj ) {
				realized = (ICFBamSecGroupFormObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamSecGroupFormObj" );
			}
			if( realized != null ) {
				buff = realized.getSecGroupFormBuff();
			}
		}
		return( buff );
	}

	public CFBamSecGroupFormBuff readBuff( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuff" );
	}

	public CFBamSecGroupFormBuff lockBuff( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey PKey )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"lockBuff" );
	}

	public CFBamSecGroupFormBuff[] readAllBuff( CFBamAuthorization Authorization ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readAllBuff" );
	}

	public CFBamSecGroupFormBuff readBuffByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argSecGroupFormId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuffByIdIdx" );
	}

	public CFBamSecGroupFormBuff[] readBuffByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuffByClusterIdx" );
	}

	public CFBamSecGroupFormBuff[] readBuffByGroupIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuffByGroupIdx" );
	}

	public CFBamSecGroupFormBuff[] readBuffByAppIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuffByAppIdx" );
	}

	public CFBamSecGroupFormBuff[] readBuffByFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecFormId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuffByFormIdx" );
	}

	public CFBamSecGroupFormBuff readBuffByUFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		int argSecFormId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"readBuffByUFormIdx" );
	}

	public void updateSecGroupForm( CFBamAuthorization Authorization,
		CFBamSecGroupFormBuff Buff )
	{
		final String S_ProcName = "updateSecGroupForm";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstUpdate( "\n\t\t\t", Buff )
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
		CFBamSecGroupFormBuff buff = null;
		Object lastObjectProcessed = responseHandler.getLastObjectProcessed();
		if( lastObjectProcessed != null ) {
			ICFBamSecGroupFormObj realized = null;
			if( lastObjectProcessed instanceof ICFBamSecGroupFormObj ) {
				realized = (ICFBamSecGroupFormObj)lastObjectProcessed;
			}
			else {
				throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
					S_ProcName,
					"lastObjectProcessed",
					lastObjectProcessed,
					"ICFBamSecGroupFormObj" );
			}
			if( realized != null ) {
				buff = realized.getSecGroupFormBuff();
			}
		}
		if( buff != null ) {
			Buff.set( buff );
		}
	}

	public void deleteSecGroupForm( CFBamAuthorization Authorization,
		CFBamSecGroupFormBuff Buff )
	{
		final String S_ProcName = "deleteSecGroupForm";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstDelete( "\n\t\t\t", Buff )
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

	public void deleteSecGroupFormByIdIdx( CFBamAuthorization Authorization,
		long argClusterId,
		long argSecGroupFormId )
	{
		final String S_ProcName = "deleteSecGroupFormByIdIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstDeleteByIdIdx( "\n\t\t\t",
							argClusterId,
							argSecGroupFormId )
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

	public void deleteSecGroupFormByIdIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormPKey argKey )
	{
		deleteSecGroupFormByIdIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredSecGroupFormId() );
	}
	public void deleteSecGroupFormByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		final String S_ProcName = "deleteSecGroupFormByClusterIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstDeleteByClusterIdx( "\n\t\t\t",
							argClusterId )
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

	public void deleteSecGroupFormByClusterIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByClusterIdxKey argKey )
	{
		deleteSecGroupFormByClusterIdx( Authorization,
			argKey.getRequiredClusterId() );
	}
	public void deleteSecGroupFormByGroupIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		final String S_ProcName = "deleteSecGroupFormByGroupIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstDeleteByGroupIdx( "\n\t\t\t",
							argClusterId,
							argSecGroupId )
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

	public void deleteSecGroupFormByGroupIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByGroupIdxKey argKey )
	{
		deleteSecGroupFormByGroupIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredSecGroupId() );
	}
	public void deleteSecGroupFormByAppIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		final String S_ProcName = "deleteSecGroupFormByAppIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstDeleteByAppIdx( "\n\t\t\t",
							argClusterId,
							argSecAppId )
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

	public void deleteSecGroupFormByAppIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByAppIdxKey argKey )
	{
		deleteSecGroupFormByAppIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredSecAppId() );
	}
	public void deleteSecGroupFormByFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecFormId )
	{
		final String S_ProcName = "deleteSecGroupFormByFormIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstDeleteByFormIdx( "\n\t\t\t",
							argClusterId,
							argSecFormId )
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

	public void deleteSecGroupFormByFormIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByFormIdxKey argKey )
	{
		deleteSecGroupFormByFormIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredSecFormId() );
	}
	public void deleteSecGroupFormByUFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId,
		int argSecFormId )
	{
		final String S_ProcName = "deleteSecGroupFormByUFormIdx";
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSecGroupFormMessageFormatter.formatSecGroupFormRqstDeleteByUFormIdx( "\n\t\t\t",
							argClusterId,
							argSecGroupId,
							argSecFormId )
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

	public void deleteSecGroupFormByUFormIdx( CFBamAuthorization Authorization,
		CFBamSecGroupFormByUFormIdxKey argKey )
	{
		deleteSecGroupFormByUFormIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredSecGroupId(),
			argKey.getRequiredSecFormId() );
	}
	public CFBamCursor openSecGroupFormCursorAll( CFBamAuthorization Authorization ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"openSecGroupFormCursorAll" );
	}

	public CFBamCursor openSecGroupFormCursorByClusterIdx( CFBamAuthorization Authorization,
		long argClusterId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"openSecGroupFormCursorByClusterIdx" );
	}

	public CFBamCursor openSecGroupFormCursorByGroupIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecGroupId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"openSecGroupFormCursorByGroupIdx" );
	}

	public CFBamCursor openSecGroupFormCursorByAppIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecAppId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"openSecGroupFormCursorByAppIdx" );
	}

	public CFBamCursor openSecGroupFormCursorByFormIdx( CFBamAuthorization Authorization,
		long argClusterId,
		int argSecFormId )
	{
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"openSecGroupFormCursorByFormIdx" );
	}

	public void closeSecGroupFormCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"closeSecGroupFormCursor" );
	}

	public CFBamSecGroupFormBuff nextSecGroupFormCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"nextSecGroupFormCursor" );
	}

	public CFBamSecGroupFormBuff prevSecGroupFormCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"prevSecGroupFormCursor" );
	}

	public CFBamSecGroupFormBuff firstSecGroupFormCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"firstSecGroupFormCursor" );
	}

	public CFBamSecGroupFormBuff lastSecGroupFormCursor( CFBamCursor Cursor ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"lastSecGroupFormCursor" );
	}

	public CFBamSecGroupFormBuff nthSecGroupFormCursor( CFBamCursor Cursor, int Idx ) {
		throw CFLib.getDefaultExceptionFactory().newNotSupportedException( getClass(),
			"nthSecGroupFormCursor" );
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
