// Description: Java 7 XMsg Client HTTP DbIO implementation for CFBam.

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

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Tip.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsg.*;

public class CFBamXMsgClientHttpSchema
	extends CFBamXMsgClientSchema
{
	protected String serverURL = "http://localhost/cfbamxmsgsrvwar23/CFBamXMsgSrvWarRequestXml";
	protected HttpClientContext clientContext = null;

	public CFBamXMsgClientHttpSchema() {
		super();
	}

	public CFBamXMsgClientHttpSchema( CFBamSchemaObj handlerSchema ) {
		super( handlerSchema );
	}

	public CFBamXMsgClientHttpSchema( CFBamSchemaObj handlerSchema, CFBamConfigurationFile conf ) {
		super( handlerSchema, conf );
	}

	public CFBamXMsgClientHttpSchema( CFBamSchemaObj handlerSchema, String argJndiName ) {
		super( handlerSchema, argJndiName );
	}

	public void setLog( ICFLibMessageLog newlog ) {
		super.setLog( newlog );
		if( cftipClientHandler != null ) {
			if( newlog != cftipClientHandler.getLog() ) {
				cftipClientHandler.setLog( newlog );
			}
		}
	}

	public void setServerURL( String value ) {
		final String S_ProcName = "setServerURL";
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				0,
				"value" );
		}
		serverURL = value;
	}
	
	public String getServerURL() {
		return( serverURL );
	}

	// Overload this to create an instance implementing your sendReceive() processing for CFTip
	public CFTipClientHandler getCFTipClientHandler() {
		if( cftipClientHandler == null ) {
			cftipClientHandler = new ClientHandler();
			cftipClientHandler.setLog( getLog() );
		}
		return( cftipClientHandler );
	}

	public boolean connect( String loginId, String password, String clusterName, String tenantName ) {
		final String S_ProcName = "connect-full";
		CFTipClientHandler clientHandler = getCFTipClientHandler();
		String deviceName = clientHandler.getDeviceName();
		if( clientContext != null ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"clientContext already exists" );
		}
		CookieStore cookieStore = new BasicCookieStore();
		clientContext = HttpClientContext.create();
		clientContext.setCookieStore( cookieStore );

		String rqst = null;

		try {
			clientHandler.requestServerInfo();
			
			MessageDigest msgDigest = MessageDigest.getInstance( "SHA-512" );
			msgDigest.update( password.getBytes( "UTF-8" ) );
			byte[] hash = msgDigest.digest();
			byte[] encodedHash = Base64.encodeBase64( hash );
			byte[] devEncPWHash = clientHandler.encryptWithDevicePrivateKey( encodedHash );
	
			clientHandler.initSessionKey();
			
			rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
				+	"\t" + CFBamXMsgSchemaMessageFormatter.formatRqstLogIn( "\n\t\t\t",
								loginId,
								deviceName,
								devEncPWHash,
								clusterName,
								tenantName )
				+	"\n"
				+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		}
		catch( NoSuchAlgorithmException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( UnsupportedEncodingException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught UnsupportedEncodingException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( BadPaddingException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeySpecException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeySpecException - " + e.getMessage(),
				e );
		}
		catch( RuntimeException e ) {
			clientContext = null;
			throw e;
		}

		try {
			cftipClientHandler.issueLoginRequest( rqst );
		}
		catch( InvalidAlgorithmParameterException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidAlgorithmParameterException - " + e.getMessage(),
				e );
		}
		catch( BadPaddingException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught BadPaddingException - " + e.getMessage(),
				e );
		}
		catch( IllegalBlockSizeException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught IllegalBlockSizeException - " + e.getMessage(),
				e );
		}
		catch( InvalidKeyException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught InvalidKeyException - " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException - " + e.getMessage(),
				e );
		}
		catch( NoSuchPaddingException e ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchPaddingException - " + e.getMessage(),
				e );
		}
		catch( RuntimeException e ) {
			clientContext = null;
			throw e;
		}
		// The response handler sets up the authorization
		ICFTipResponseHandler responseHandler = cftipClientHandler.getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			clientContext = null;
			throw exceptionRaised;
		}
		// If we got a response instead of an exception, we succeeded at logging in.
		return( true );
	}

	public void logout( CFBamAuthorization auth ) {
		final String S_ProcName = "logout";
		if( ( clientContext == null ) || ( auth == null ) || ( null == auth.getSecSessionId() ) ) {
			clientContext = null;
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Not authorized/connected" );
		}
		String rqst = CFBamXMsgSchemaMessageFormatter.formatRqstXmlPreamble() + "\n"
			+	"\t" + CFBamXMsgSchemaMessageFormatter.formatRqstLogOut( "\n\t\t\t",
							auth.getSecSessionId() )
			+	"\n"
			+	CFBamXMsgSchemaMessageFormatter.formatRqstXmlPostamble();
		try {
			cftipClientHandler.issueAppRequest( rqst );
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
		finally {
			clientContext = null;
		}
		ICFTipResponseHandler responseHandler = cftipClientHandler.getResponseHandler();
		CFLibRuntimeException exceptionRaised = responseHandler.getExceptionRaised();
		if( exceptionRaised != null ) {
			throw exceptionRaised;
		}
	}

	public class ClientHandler
	extends CFTipClientHandler
	{
		public ClientHandler() {
			super();
		}

		public ClientHandler( ICFLibMessageLog logger ) {
			super( logger );
		}

		public String sendReceive( String value ) {
			final String S_ProcName = "sendReceive";

			if( ( value == null ) || ( value.length() <= 0 ) ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					1,
					"value" );
			}

			if( clientContext == null ) {
				throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
					S_ProcName,
					"clientContext must be initialized by invoking connect() with full parameters first" );
			}

			String rspn = null;
			CloseableHttpClient httpClient = null;
			CloseableHttpResponse httpResponse = null;
			try {
				// Prepare to POST the form to the server URL
				List<NameValuePair> formParams = new ArrayList<NameValuePair>();
				formParams.add( new BasicNameValuePair( "MessageBody", value ) );
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity( formParams, Consts.UTF_8 );
				HttpPost httpPost = new HttpPost( getServerURL() );
				httpPost.setEntity( entity );

				// POST the form and analyze the response validity
				httpClient = HttpClients.createDefault();
				httpResponse = httpClient.execute( httpPost, clientContext );
				StatusLine statusLine = httpResponse.getStatusLine();
				if( statusLine.getStatusCode() >= 300 ) {
					throw new HttpResponseException( statusLine.getStatusCode(),
						statusLine.getReasonPhrase() );
				}
				HttpEntity responseEntity = httpResponse.getEntity();
				if( responseEntity == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"responseEntity" );
				}

				// Read the response into a string
				ContentType contentType = ContentType.getOrDefault( responseEntity );
				Charset charSet = contentType.getCharset();
				Reader reader = new InputStreamReader( responseEntity.getContent(), charSet );
				StringBuffer buff = new StringBuffer();
				char ca[] = new char[1];
				int bytesRead = reader.read( ca );
				while( bytesRead == 1 ) {
					buff.append( ca[0] );
					bytesRead = reader.read( ca );
				}
				rspn = buff.toString();
			}
			catch( Exception e ) {
				rspn = null;
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"EXCEPTION processing HTTP POST -- " + e.getMessage(),
					e );
			}
			catch( Error e ) {
				rspn = null;
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"ERROR processing HTTP POST -- " + e.getMessage(),
					e );
			}
			finally {
				if( httpResponse != null ) {
					try {
						httpResponse.close();
					}
					catch (IOException e) {
					}
					httpResponse = null;
				}
				if( httpClient != null ) {
					try {
						httpClient.close();
					}
					catch (IOException e) {
					}
					httpClient = null;
				}
			}
			return( rspn );
		}

}

}
