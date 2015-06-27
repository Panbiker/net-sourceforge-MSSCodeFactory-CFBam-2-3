
// Description: Java 7 Security Manager Login Servlet

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSMWar;

import java.io.*;
import java.security.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

import org.apache.commons.codec.binary.Base64;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.CFLib;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/**
 * Servlet implementation class CFBamSMWarLoginHtml
 */
@WebServlet("/CFBamSMWarLoginHtml")
public class CFBamSMWarLoginHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CFBamSMWarLoginHtml() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String S_ProcName="doGet";
		ICFBamSchemaObj schemaObj;
		HttpSession sess = request.getSession( false );
		if( sess == null ) {
			sess = request.getSession( true );
			schemaObj = new CFBamSchemaPooledObj();
			sess.setAttribute( "SchemaObj", schemaObj );
		}
		else {
			schemaObj = (ICFBamSchemaObj)sess.getAttribute( "SchemaObj" );
			if( schemaObj == null ) {
				schemaObj = new CFBamSchemaPooledObj();
				sess.setAttribute( "SchemaObj", schemaObj );
			}
		}

		ICFBamSchema dbSchema = null;
		try {
			CFBamAuthorization auth = schemaObj.getAuthorization();
			if( auth != null ) {
				response.sendRedirect( "CFBamSMWarSecurityMainHtml" );
				return;
			}

			dbSchema = CFBamSchemaPool.getSchemaPool().getInstance();
			schemaObj.setBackingStore( dbSchema );
			schemaObj.beginTransaction();
			ICFBamSecUserObj systemUser = schemaObj.getSecUserTableObj().readSecUserByULoginIdx( "system" );
			String passwordHash = systemUser.getRequiredPasswordHash();
			if( ( passwordHash == null ) || ( passwordHash.length() <= 0 ) || passwordHash.equals( "bootstrap" ) ) {
				response.sendRedirect( "CFBamSMWarSetSystemPasswordHtml" );
				return;
			}

			ICFBamSysClusterObj sysCluster = schemaObj.getSysClusterTableObj().readSysClusterByIdIdx( 1, false );
			if( sysCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"sysCluster" );
			}

			ICFBamClusterObj resolvedCluster = sysCluster.getRequiredContainerCluster();
			if( resolvedCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					"resolvedCluster" );
			}
			String clusterDomainName = resolvedCluster.getRequiredFullDomainName();
			String clusterDescription = resolvedCluster.getRequiredDescription();

			response.setContentType( "text/html" );
			PrintWriter out = response.getWriter();
			out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
			out.println( "<HTML>" );
			out.println( "<BODY>" );
			out.println( "<form method=\"post\" formaction=\"CFBamSMWarLoginHtml\">" );
			out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
			out.println( "<H2 style=\"text-align:center\">Please log in or create a new account.</H2>" );
			out.println( "<p>" );
			out.println( "<center>" );
			out.println( "<table style=\"width:60%\">" );
			out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\"/></td></tr>");
			out.println( "<tr><th style=\"text-align:left\">Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
			out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
			out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarCreateNewAccountHtml\">Create new account</A></td></tr>" );
			out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarRequestResetPasswordHtml\">Request an Password Reset</A></td></tr>" );
			out.println( "</table>" );
			out.println( "</center>" );
			out.println( "</form>" );
			out.println( "</BODY>" );
			out.println( "</HTML>" );
		}
		catch( RuntimeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught RuntimeException -- " + e.getMessage(),
				e );
		}
		finally {
			if( dbSchema != null ) {
				try {
					if( schemaObj.isTransactionOpen() ) { 
						schemaObj.rollback();
					}
				}
				catch( RuntimeException e ) {
				}
				schemaObj.setBackingStore( null );
				CFBamSchemaPool.getSchemaPool().releaseInstance( dbSchema );
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String S_ProcName = "doPost";
		
		ICFBamSchemaObj schemaObj;
		HttpSession sess = request.getSession( false );
		if( sess == null ) {
			sess = request.getSession( true );
			schemaObj = new CFBamSchemaPooledObj();
			sess.setAttribute( "SchemaObj", schemaObj );
		}
		else {
			schemaObj = (ICFBamSchemaObj)sess.getAttribute( "SchemaObj" );
			if( schemaObj == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"schemaObj" );
			}
		}
		
		ICFBamSchema dbSchema = null;
		try {
			CFBamAuthorization auth = schemaObj.getAuthorization();
			if( auth != null ) {
				response.sendRedirect( "CFBamSMWarSecurityMainHtml" );
				return;
			}

			dbSchema = CFBamSchemaPool.getSchemaPool().getInstance();
			schemaObj.setBackingStore( dbSchema );
			schemaObj.beginTransaction();
			ICFBamSecUserObj systemUser = schemaObj.getSecUserTableObj().readSecUserByULoginIdx( "system" );
			String passwordHash = systemUser.getRequiredPasswordHash();
			if( ( passwordHash == null ) || ( passwordHash.length() <= 0 ) || passwordHash.equals( "bootstrap" ) ) {
				response.sendRedirect( "CFBamSMWarSetSystemPasswordHtml" );
			}

			ICFBamClusterObj resolvedCluster;
			ICFBamSysClusterObj sysCluster = schemaObj.getSysClusterTableObj().readSysClusterByIdIdx( 1, false );
			if( sysCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"sysCluster" );
			}
			resolvedCluster = sysCluster.getRequiredContainerCluster();
			if( resolvedCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					"resolvedCluster" );
			}
			String clusterDomainName = resolvedCluster.getRequiredFullDomainName();
			String clusterDescription = resolvedCluster.getRequiredDescription();

			String loginId = (String)request.getParameter( "LoginId" );
			if( ( loginId == null ) || ( loginId.length() <= 0 ) ) {
				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamSMWarLoginHtml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
				out.println( "<H2 style=\"text-align:center\">ERROR</H2>" );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Login id or password is invalid.  Permission denied." );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Please log in or create a new account." );
				out.println( "<p>" );
				out.println( "<center>" );
				out.println( "<table style=\"width:60%\">" );
				out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
				out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"/CFBamSMWarCreateNewAccountHtml\">Create new account</A></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarRequestResetPasswordHtml\">Request an Password Reset</A></td></tr>" );
				out.println( "</table>" );
				out.println( "</center>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );
				return;
			}

			ICFBamSecUserObj authenticatingUser = schemaObj.getSecUserTableObj().readSecUserByULoginIdx( loginId, true );
			if( authenticatingUser == null ) {
				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamSMWarLoginHtml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
				out.println( "<H2 style=\"text-align:center\">ERROR</H2>" );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Login id or password is invalid.  Permission denied." );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Please log in or create a new account." );
				out.println( "<p>" );
				out.println( "<center>" );
				out.println( "<table style=\"width:60%\">" );
				out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
				out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"/CFBamSMWarCreateNewAccountHtml\">Create new account</A></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarRequestResetPasswordHtml\">Request an Password Reset</A></td></tr>" );
				out.println( "</table>" );
				out.println( "</center>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );
				return;
			}

			ICFBamSecDeviceObj defDev = authenticatingUser.getOptionalLookupDefDev( true );
			
			if( null != authenticatingUser.getOptionalPasswordResetUuid() ) {

				sendPasswordResetEMail( request, authenticatingUser, resolvedCluster );

				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamSMWarLoginHtml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
				out.println( "<H2 style=\"text-align:center\">ERROR</H2>" );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Password Reset email has been resent." );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Please use the links in the password reset email to set a new Password or to cancel the request before trying to log in again." );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Please log in or create a new account." );
				out.println( "<p>" );
				out.println( "<center>" );
				out.println( "<table style=\"width:60%\">" );
				out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
				out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"/CFBamSMWarCreateNewAccountHtml\">Create new account</A></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarRequestResetPasswordHtml\">Request an Password Reset</A></td></tr>" );
				out.println( "</table>" );
				out.println( "</center>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );
				return;
			}

			String password = (String)request.getParameter( "Password" );
			if( password == null ) {
				password = "";
			}
			
			MessageDigest msgDigest = MessageDigest.getInstance( "SHA-512" );
			msgDigest.update( password.getBytes( "UTF-8" ) );
			byte[] hash = msgDigest.digest();
			byte[] encodedHash = Base64.encodeBase64( hash );
			msgDigest.update( encodedHash );
			hash = msgDigest.digest();
			byte encodedDoubleHash[] = Base64.encodeBase64( hash );
			String hashedAndEncodedPassword = new String( encodedDoubleHash );

			if( ! hashedAndEncodedPassword.equals( authenticatingUser.getRequiredPasswordHash() ) ) {
				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamSMWarLoginHtml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
				out.println( "<H2 style=\"text-align:center\">ERROR</H2>" );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Login id or password is invalid.  Permission denied." );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Please log in or create a new account." );
				out.println( "<p>" );
				out.println( "<center>" );
				out.println( "<table style=\"width:60%\">" );
				out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
				out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"/CFBamSMWarCreateNewAccountHtml\">Create new account</A></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarRequestResetPasswordHtml\">Request an Password Reset</A></td></tr>" );
				out.println( "</table>" );
				out.println( "</center>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );
				return;
			}

			if( null != authenticatingUser.getOptionalEMailConfirmationUuid() ) {

				sendConfirmationEMail( defDev, request, authenticatingUser, resolvedCluster );

				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamSMWarLoginHtml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
				out.println( "<H2 style=\"text-align:center\">ERROR</H2>" );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "EMail address "
					+	( ( defDev != null )
							? "security "
							: "" )
					+	" of login id has not been confirmed.  The "
					+	( ( defDev != null )
							? "encrypted "
							: "" )
					+	"confirmation email has been resent." );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Please log in or create a new account." );
				out.println( "<p>" );
				out.println( "<center>" );
				out.println( "<table style=\"width:60%\">" );
				out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
				out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"/CFBamSMWarCreateNewAccountHtml\">Create new account</A></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarRequestResetPasswordHtml\">Request an Password Reset</A></td></tr>" );
				out.println( "</table>" );
				out.println( "</center>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );

				return;
			}

			ICFBamTenantObj systemTenant = schemaObj.getTenantTableObj().readTenantByUNameIdx( resolvedCluster.getRequiredId(), "system" );
			ICFBamSecSessionObj systemSession = schemaObj.getSecSessionTableObj().newInstance();
			ICFBamSecSessionEditObj editSystemSession = (ICFBamSecSessionEditObj)systemSession.beginEdit();
			editSystemSession.setRequiredContainerSecUser( authenticatingUser );
			editSystemSession.setRequiredStart( Calendar.getInstance() );
			systemSession = editSystemSession.create();
			editSystemSession.endEdit();

			auth = new CFBamAuthorization();
			auth.setSecCluster( resolvedCluster );
			auth.setSecTenant( systemTenant );
			auth.setSecSession( systemSession );
			schemaObj.setAuthorization( auth );
			
			schemaObj.commit();

			response.sendRedirect( "CFBamSMWarSecurityMainHtml" );
		}
		catch( MessagingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught MessagingException -- " + e.getMessage(),
				e );
		}
		catch( NamingException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NamingException -- " + e.getMessage(),
				e );
		}
		catch( NoSuchAlgorithmException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught NoSuchAlgorithmException -- " + e.getMessage(),
				e );
		}
		catch( RuntimeException e ) {
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught RuntimeException -- " + e.getMessage(),
				e );
		}
		finally {
			if( dbSchema != null ) {
				try {
					if( schemaObj.isTransactionOpen() ) { 
						schemaObj.rollback();
					}
				}
				catch( RuntimeException e ) {
				}
				schemaObj.setBackingStore( null );
				CFBamSchemaPool.getSchemaPool().releaseInstance( dbSchema );
			}
		}
	}

	protected void sendConfirmationEMail(
		ICFBamSecDeviceObj defDev,
		HttpServletRequest request,
		ICFBamSecUserObj confirmUser,
		ICFBamClusterObj cluster )
	throws
		IOException,
		MessagingException,
		NamingException
	{
		String clusterDescription = cluster.getRequiredDescription();

		String thisURI = request.getScheme()
			+	"://"
			+	request.getServerName()
			+	":"
			+	request.getServerPort()
			+	request.getRequestURI().toString();
		int lastSlash = thisURI.lastIndexOf( '/' );
		String baseURI = thisURI.substring( 0, lastSlash );
		UUID confirmationUUID = confirmUser.getOptionalEMailConfirmationUuid();

		String msgBody =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n"
			+	"<HTML>\n"
			+	"<BODY>\n"
			+	"<p>\n"
			+	"You requested a new account for " + confirmUser.getRequiredEMailAddress() + " with " + clusterDescription + ".\n"
			+	"<p>"
			+	"Please click on the following link to confirm your email address:<br>\n"
			+	"<A HRef=\"" + baseURI + "/CFBamSMWarConfirmEMailAddressHtml?ConfirmationUUID=" + confirmationUUID.toString() + "\">"
			+		 baseURI + "/CFBamSMWarConfirmEMailAddressHtml?ConfirmationUUID=" + confirmationUUID.toString() + "</A>\n"
			+	"<p>"
			+	"Or click on the following link to cancel the request for a new account:<br>\n"
			+	"<A HRef=\"" + baseURI + "/CFBamSMWarCancelEMailAddressHtml?ConfirmationUUID=" + confirmationUUID.toString() + "\">"
			+		 baseURI + "/CFBamSMWarCancelEMailAddressHtml?ConfirmationUUID=" + confirmationUUID.toString() + "</A>\n"
			+	"</BODY>\n"
			+	"</HTML>\n";

		CFBamSMWarUtil warUtil = new CFBamSMWarUtil();
		warUtil.sendEMailToUser( confirmUser,
			"You requested an account with " + clusterDescription + "?",
			msgBody );
	}

	protected void sendPasswordResetEMail(
		HttpServletRequest request,
		ICFBamSecUserObj resetUser,
		ICFBamClusterObj cluster )
	throws
		IOException,
		MessagingException,
		NamingException
	{
		String clusterDescription = cluster.getRequiredDescription();

		String thisURI = request.getScheme()
			+	"://"
			+	request.getServerName()
			+	":"
			+	request.getServerPort()
			+	request.getRequestURI().toString();
		int lastSlash = thisURI.lastIndexOf( '/' );
		String baseURI = thisURI.substring( 0, lastSlash );
		UUID resetUUID = resetUser.getOptionalPasswordResetUuid();

		String msgBody =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n"
			+	"<HTML>\n"
			+	"<BODY>\n"
			+	"<p>\n"
			+	"You requested a password reset for " + resetUser.getRequiredEMailAddress() + " used for accessing " + clusterDescription + ".\n"
			+	"<p>"
			+	"Please click on the following link to reset your password:<br>\n"
			+	"<A HRef=\"" + baseURI + "/CFBamSMWarResetPasswordHtml?ResetUUID=" + resetUUID.toString() + "\">"
			+		 baseURI + "/CFBamSMWarResetPasswordHtml?ResetUUID=" + resetUUID.toString() + "</A>\n"
			+	"<p>"
			+	"Or click on the following link to cancel the reset request:<br>\n"
			+	"<A HRef=\"" + baseURI + "/CFBamSMWarCancelResetPasswordHtml?ResetUUID=" + resetUUID.toString() + "\">"
			+		 baseURI + "/CFBamSMWarCancelResetPasswordHtml?ResetUUID=" + resetUUID.toString() + "</A>\n"
			+	"</BODY>\n"
			+	"</HTML>\n";

		CFBamSMWarUtil warUtil = new CFBamSMWarUtil();
		warUtil.sendEMailToUser( resetUser,
			"You requested a password reset for your account with " + clusterDescription + "?",
			msgBody );
	}
}
