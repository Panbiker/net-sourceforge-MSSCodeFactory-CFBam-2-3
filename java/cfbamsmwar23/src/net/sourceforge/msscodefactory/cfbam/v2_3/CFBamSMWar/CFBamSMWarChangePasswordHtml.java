
// Description: Java 7 Security Manager Change Password Servlet

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

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.UUID;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.codec.binary.Base64;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.CFLib;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/**
 * Servlet implementation class CFBamSMWarChangePasswordHtml
 */
@WebServlet("/CFBamSMWarChangePasswordHtml")
public class CFBamSMWarChangePasswordHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CFBamSMWarChangePasswordHtml() {
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
			if( auth == null ) {
				response.sendRedirect( "CFBamSMWarLoginHtml" );
				return;
			}

			dbSchema = CFBamSchemaPool.getSchemaPool().getInstance();
			schemaObj.setBackingStore( dbSchema );
			schemaObj.beginTransaction();
			ICFBamSecUserObj secUser = schemaObj.getSecUserTableObj().readSecUserByIdIdx( auth.getSecUserId() );
			if( secUser == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"secUser" );
			}
			
			ICFBamClusterObj secCluster = schemaObj.getClusterTableObj().readClusterByIdIdx( auth.getSecClusterId() );
			if( secCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"secCluster" );
			}
			String clusterDescription = secCluster.getRequiredDescription();

			response.setContentType( "text/html" );
			PrintWriter out = response.getWriter();
			out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
			out.println( "<HTML>" );
			out.println( "<BODY>" );
			out.println( "<form method=\"post\" formaction=\"CFBamSMWarChangePasswordHtml\">" );
			out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
			out.println( "<H2 style=\"text-align:center\">Change Password for " + secUser.getRequiredEMailAddress() + "</H2>" );
			out.println( "<p>" );
			out.println( "<center>" );
			out.println( "<table style=\"width:75%\">" );
			out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\" readonly=\"true\" value=\"" + secUser.getRequiredEMailAddress() + "\"/></td></tr>");
			out.println( "<tr><th style=\"text-align:left\">Old Password:</th><td><input type=\"password\" name=\"OldPassword\"/></td></tr>");
			out.println( "<tr><th style=\"text-align:left\">New Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
			out.println( "<tr><th style=\"text-align:left\">Confirm New Password:</th><td><input type=\"password\" name=\"ConfirmPassword\"/></td></tr>");
			out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
			out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarLoginHtml\">Take me to the " + secCluster.getRequiredDescription() + " Security Manager Login</A></td></tr>" );
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
			if( auth == null ) {
				response.sendRedirect( "CFBamSMWarLoginHtml" );
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

			ICFBamSecUserObj secUser = schemaObj.getSecUserTableObj().readSecUserByIdIdx( auth.getSecUserId() );
			if( secUser == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"secUser" );
			}

			ICFBamClusterObj secCluster = schemaObj.getClusterTableObj().readClusterByIdIdx( auth.getSecClusterId() );
			if( secCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"secCluster" );
			}
			String clusterDescription = secCluster.getRequiredDescription();

			String oldPassword = (String)request.getParameter( "OldPassword" );
			if( ( oldPassword == null ) || ( oldPassword.length() <= 0 ) ) {
				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamSMWarChangePasswordHtml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
				out.println( "<H2 style=\"text-align:center\">ERROR</H2>" );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Old Password must be specified." );
				out.println( "<p>" );
				out.println( "<center>" );
				out.println( "<table style=\"width:75%\">" );
				out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\" readonly=\"true\" value=\"" + secUser.getRequiredEMailAddress() + "\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Old Password:</th><td><input type=\"password\" name=\"OldPassword\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">New Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Confirm New Password:</th><td><input type=\"password\" name=\"ConfirmPassword\"/></td></tr>");
				out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarLoginHtml\">Take me to the " + secCluster.getRequiredDescription() + " Security Manager Login</A></td></tr>" );
				out.println( "</table>" );
				out.println( "</center>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );
				return;
			}

			String password = (String)request.getParameter( "Password" );
			if( ( password == null ) || ( password.length() <= 0 ) ) {
				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamSMWarChangePasswordHtml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
				out.println( "<H2 style=\"text-align:center\">ERROR</H2>" );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "New Password must be specified." );
				out.println( "<p>" );
				out.println( "<center>" );
				out.println( "<table style=\"width:75%\">" );
				out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\" readonly=\"true\" value=\"" + secUser.getRequiredEMailAddress() + "\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Old Password:</th><td><input type=\"password\" name=\"OldPassword\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">New Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Confirm New Password:</th><td><input type=\"password\" name=\"ConfirmPassword\"/></td></tr>");
				out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarLoginHtml\">Take me to the " + secCluster.getRequiredDescription() + " Security Manager Login</A></td></tr>" );
				out.println( "</table>" );
				out.println( "</center>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );
				return;
			}

			String confirmPassword = (String)request.getParameter( "ConfirmPassword" );
			if( ( confirmPassword == null ) || ( confirmPassword.length() <= 0 ) ) {
				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamSMWarChangePasswordHtml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
				out.println( "<H2 style=\"text-align:center\">ERROR</H2>" );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Confirm New Password must be specified." );
				out.println( "<p>" );
				out.println( "<center>" );
				out.println( "<table style=\"width:75%\">" );
				out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\" readonly=\"true\" value=\"" + secUser.getRequiredEMailAddress() + "\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Old Password:</th><td><input type=\"password\" name=\"OldPassword\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">New Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Confirm New Password:</th><td><input type=\"password\" name=\"ConfirmPassword\"/></td></tr>");
				out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarLoginHtml\">Take me to the " + secCluster.getRequiredDescription() + " Security Manager Login</A></td></tr>" );
				out.println( "</table>" );
				out.println( "</center>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );
				return;
			}

			if( ! confirmPassword.equals( password ) ) {
				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamSMWarChangePasswordHtml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
				out.println( "<H2 style=\"text-align:center\">ERROR</H2>" );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "New Password and Confirm New Password do not match." );
				out.println( "<p>" );
				out.println( "<center>" );
				out.println( "<table style=\"width:75%\">" );
				out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\" readonly=\"true\" value=\"" + secUser.getRequiredEMailAddress() + "\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Old Password:</th><td><input type=\"password\" name=\"OldPassword\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">New Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Confirm New Password:</th><td><input type=\"password\" name=\"ConfirmPassword\"/></td></tr>");
				out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarLoginHtml\">Take me to the " + secCluster.getRequiredDescription() + " Security Manager Login</A></td></tr>" );
				out.println( "</table>" );
				out.println( "</center>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );
				return;
			}

			MessageDigest msgDigest = MessageDigest.getInstance( "SHA-512" );
			msgDigest.update( oldPassword.getBytes( "UTF-8" ) );
			byte[] hash = msgDigest.digest();
			byte[] encodedHash = Base64.encodeBase64( hash );
			msgDigest.update( encodedHash );
			hash = msgDigest.digest();
			encodedHash = Base64.encodeBase64( hash );
			String oldHashedAndEncodedPassword = new String( encodedHash );

			if( ! oldHashedAndEncodedPassword.equals( secUser.getRequiredPasswordHash() ) ) {
				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamSMWarChangePasswordHtml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
				out.println( "<H2 style=\"text-align:center\">ERROR</H2>" );
				out.println( "<p style=\"text-align:center\">" );
				out.println( "Old Password is invalid." );
				out.println( "<p>" );
				out.println( "<center>" );
				out.println( "<table style=\"width:75%\">" );
				out.println( "<tr><th style=\"text-align:left\">Login Id:</th><td><input type=\"text\" name=\"LoginId\" readonly=\"true\" value=\"" + secUser.getRequiredEMailAddress() + "\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Old Password:</th><td><input type=\"password\" name=\"OldPassword\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">New Password:</th><td><input type=\"password\" name=\"Password\"/></td></tr>");
				out.println( "<tr><th style=\"text-align:left\">Confirm New Password:</th><td><input type=\"password\" name=\"ConfirmPassword\"/></td></tr>");
				out.println( "<tr><td colspan=\"2\" style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Ok</button></td></tr>" );
				out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarLoginHtml\">Take me to the " + secCluster.getRequiredDescription() + " Security Manager Login</A></td></tr>" );
				out.println( "</table>" );
				out.println( "</center>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );
				return;
			}

			msgDigest.update( password.getBytes( "UTF-8" ) );
			hash = msgDigest.digest();
			encodedHash = Base64.encodeBase64( hash );
			msgDigest.update( encodedHash );
			hash = msgDigest.digest();
			encodedHash = Base64.encodeBase64( hash );
			String newHashedAndEncodedPassword = new String( encodedHash );

			ICFBamClusterObj systemCluster = schemaObj.getClusterTableObj().readClusterByUDomainNameIdx( "system" );
			ICFBamTenantObj systemTenant = schemaObj.getTenantTableObj().readTenantByUNameIdx( systemCluster.getRequiredId(), "system" );
			ICFBamSecSessionObj systemSession = schemaObj.getSecSessionTableObj().newInstance();
			ICFBamSecSessionEditObj editSystemSession = (ICFBamSecSessionEditObj)systemSession.beginEdit();
			editSystemSession.setRequiredContainerSecUser( systemUser );
			editSystemSession.setRequiredStart( Calendar.getInstance() );
			systemSession = editSystemSession.create();
			editSystemSession.endEdit();

			CFBamAuthorization oldAuth = schemaObj.getAuthorization();

			auth = new CFBamAuthorization();
			auth.setSecCluster( systemCluster );
			auth.setSecTenant( systemTenant );
			auth.setSecSession( systemSession );
			schemaObj.setAuthorization( auth );

			ICFBamSecUserEditObj editSecUser = secUser.beginEdit();
			editSecUser.setRequiredPasswordHash( newHashedAndEncodedPassword );
			editSecUser.update();
			editSecUser.endEdit();

			editSystemSession = (ICFBamSecSessionEditObj)systemSession.beginEdit();
			editSystemSession.setOptionalFinish( Calendar.getInstance() );
			editSystemSession.update();
			editSystemSession.endEdit();
			
			schemaObj.commit();

			schemaObj.setAuthorization( oldAuth );

			response.setContentType( "text/html" );
			PrintWriter out = response.getWriter();
			out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
			out.println( "<HTML>" );
			out.println( "<BODY>" );
			out.println( "<form method=\"post\" formaction=\"CFBamSMWarChangePasswordHtml\">" );
			out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " Security Manager</H1>" );
			out.println( "<H2 style=\"text-align:center\">Password Set.</H2>" );
			out.println( "<p>" );
			out.println( "<center>" );
			out.println( "<table style=\"width:75%\">" );
			out.println( "<tr><td colSpan=\"2\" style=\"text-align:center\"><A HRef=\"CFBamSMWarLoginHtml\">Take me back to the " + secCluster.getRequiredDescription() + " Security Manager Main page</A></td></tr>" );
			out.println( "</table>" );
			out.println( "</center>" );
			out.println( "</form>" );
			out.println( "</BODY>" );
			out.println( "</HTML>" );
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
}
