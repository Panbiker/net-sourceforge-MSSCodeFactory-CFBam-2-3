
// Description: Java 7 XMsg Server Add Device Servlet

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgSrvWar;

import java.io.*;
import java.security.*;
import java.util.*;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.output.WriterOutputStream;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.CFLib;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.ICFLibMessageLog;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Tip.CFTipEnvelopeHandler;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Tip.CFTipServerInfo;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgRqstHandler.CFBamXMsgRqstHandler;

/**
 * Servlet implementation class CFBamXMsgSrvWarRequestXml
 */
@WebServlet("/CFBamXMsgSrvWarRequestXml")
public class CFBamXMsgSrvWarRequestXml extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected MessageLogHandler log = new MessageLogHandler();
	protected PrintWriter printWriter = null;
	protected PrintStream printStream = null;
	protected int indent = 0;

    public class MessageLogHandler implements ICFLibMessageLog {

    	public MessageLogHandler() {
    		printWriter = null;
    		printStream = null;
    		indent = 0;
    	}

    	public void setPrintWriter( PrintWriter value ) {
    		if( value == null ) {
    			printWriter = null;
    			printStream = null;
    			indent = 0;
    		}
    		else {
    			indent = 0;
    			printWriter = value;
				WriterOutputStream writerOutputStream = new WriterOutputStream( printWriter );
				printStream = new PrintStream( writerOutputStream );
    		}
    	}

		public String getBacklog() {
			return( null );
		}

    	public PrintStream getPrintStream() {
			if( printStream == null ) {
				WriterOutputStream writerOutputStream = new WriterOutputStream( printWriter );
				printStream = new PrintStream( writerOutputStream );
			}
			return( printStream );
		}

		public int getMessageLogIndent() {
			return indent;
		}

		public void indent() {
			indent ++;
		}

		public void dedent() {
			if( indent > 0 ) {
				indent --;
			}
			else {
				indent = 0;
			}
		}

		public void message(String msg) {

			if( msg == null ) {
				return;
			}

			StringBuffer buff = new StringBuffer();

			Calendar cal = Calendar.getInstance();
			String stamp = String.format( "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL ", cal );
			buff.append( stamp );

			int			i;
			for( i = 0; i < indent; i ++ ) {
				buff.append( "\t" );
			}
			buff.append( msg );
			if( ! msg.endsWith( "\n" ) ) {
				buff.append( "\n" );
			}

			if( printStream != null ) {
				printStream.append( buff.toString() );
				printStream.flush();
			}
		}

		public void openLogFile(String fileName) throws FileNotFoundException {
			throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
				"openLogFile" );
		}

		public void closeLogFile() {
			throw CFLib.getDefaultExceptionFactory().newNotImplementedYetException( getClass(),
					"openLogFile" );
		}
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CFBamXMsgSrvWarRequestXml() {
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
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SchemaObj" );
			}
		}

		CFTipEnvelopeHandler envelopeHandler = (CFTipEnvelopeHandler)sess.getAttribute( "CFTipEnvelopeHandler" );
		if( envelopeHandler == null ) {
			envelopeHandler = new CFTipEnvelopeHandler();
			envelopeHandler.setLog( log );
			CFBamXMsgRqstHandler requestHandler = new CFBamXMsgRqstHandler();
			requestHandler.setSchemaObj( schemaObj );
			envelopeHandler.setRequestHandler( requestHandler );
			sess.setAttribute( "CFTipEnvelopeHandler", envelopeHandler );
		}

		ICFBamSchema dbSchema = null;
		try {
			dbSchema = CFBamSchemaPool.getSchemaPool().getInstance();
			schemaObj.setBackingStore( dbSchema );
			schemaObj.beginTransaction();

			ICFBamSysClusterObj sysCluster = schemaObj.getSysClusterTableObj().readSysClusterByIdIdx( 1, false );
			if( sysCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SysCluster" );
			}

			ICFBamClusterObj secCluster = sysCluster.getRequiredContainerCluster();
			if( secCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SysCluster.Cluster" );
			}

			CFTipServerInfo serverInfo = CFBamXMsgSrvWarApplicationListener.getServerInfo();
			if( serverInfo == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ServerInfo" );
			}

			if( null == envelopeHandler.getServerInfo() ) {
				serverInfo.setClusterDescr( secCluster.getRequiredDescription() );
				serverInfo.setClusterURL( secCluster.getRequiredFullDomainName() );
				envelopeHandler.setServerInfo( serverInfo );
				envelopeHandler.initServerKeys();
			}

			String clusterDescription = serverInfo.getClusterDescr();

			response.setContentType( "text/html" );
			PrintWriter out = response.getWriter();
			out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
			out.println( "<HTML>" );
			out.println( "<BODY>" );
			out.println( "<form method=\"post\" formaction=\"CFBamXMsgSrvWarRequestXml\">" );
			out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " XMsg Server</H1>" );
			out.println( "<H2 style=\"text-align:center\"> Enter a CFTipEnvelope XML request message to process</H2>" );
			out.println( "<p>" );
			out.println( "<table style=\"width:90%\">" );
			out.println( "<tr><th style=\"text-align:left\">Message Body:</th><td><textarea name=\"MessageBody\" cols=\"60\" rows=\"10\"></textarea></td></tr>");
			out.println( "</table>" );
			out.println( "<p style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Submit Request</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type=\"button\" name=\"Cancel\"\" onclick=\"window.location.href='CFBamXMsgSrvWarRequestXml'\">Cancel;</button>" );
			out.println( "</form>" );
			out.println( "</BODY>" );
			out.println( "</HTML>" );
		}
		catch( RuntimeException
			| InvalidKeyException
			| NoSuchAlgorithmException
			| NoSuchPaddingException
			| IllegalBlockSizeException e )
		{
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught " + e.getClass().getName() + " -- " + e.getMessage(),
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
					"SchemaObj" );
			}
		}

		CFTipEnvelopeHandler envelopeHandler = (CFTipEnvelopeHandler)sess.getAttribute( "CFTipEnvelopeHandler" );
		if( envelopeHandler == null ) {
			envelopeHandler = new CFTipEnvelopeHandler();
			envelopeHandler.setLog( log );
			CFBamXMsgRqstHandler requestHandler = new CFBamXMsgRqstHandler();
			requestHandler.setSchemaObj( schemaObj );
			envelopeHandler.setRequestHandler( requestHandler );
			sess.setAttribute( "CFTipEnvelopeHandler", envelopeHandler );
		}

		String clusterDescription = "";

		ICFBamSchema dbSchema = null;
		try {
			dbSchema = CFBamSchemaPool.getSchemaPool().getInstance();
			schemaObj.setBackingStore( dbSchema );
			schemaObj.beginTransaction();

			ICFBamSysClusterObj sysCluster = schemaObj.getSysClusterTableObj().readSysClusterByIdIdx( 1, false );
			if( sysCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SysCluster" );
			}

			ICFBamClusterObj secCluster = sysCluster.getRequiredContainerCluster();
			if( secCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SysCluster.Cluster" );
			}

			CFTipServerInfo serverInfo = CFBamXMsgSrvWarApplicationListener.getServerInfo();
			if( serverInfo == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ServerInfo" );
			}

			if( null == envelopeHandler.getServerInfo() ) {
				serverInfo.setClusterDescr( secCluster.getRequiredDescription() );
				serverInfo.setClusterURL( secCluster.getRequiredFullDomainName() );
				envelopeHandler.setServerInfo( serverInfo );
				envelopeHandler.initServerKeys();
			}

			clusterDescription = serverInfo.getClusterDescr();

			// envelopeHandler.setLog( log );

			String messageBody = request.getParameter( "MessageBody" );
			if( ( messageBody == null ) || ( messageBody.length() <= 0 ) ) {
				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				out.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">" );
				out.println( "<HTML>" );
				out.println( "<BODY>" );
				out.println( "<form method=\"post\" formaction=\"CFBamXMsgSrvWarRequestXml\">" );
				out.println( "<H1 style=\"text-align:center\">" + clusterDescription + " XMsg Server</H1>" );
				out.println( "<H2 style=\"text-align:center\"> Enter a CFTipEnvelope XML request message to process</H2>" );
				out.println( "<p>" );
				out.println( "<table style=\"width:90%\">" );
				out.println( "<tr><th style=\"text-align:left\">Message Body:</th><td><textarea name=\"MessageBody\" cols=\"60\" rows=\"10\"></textarea></td></tr>");
				out.println( "</table>" );
				out.println( "<p style=\"text-align:center\"><button type=\"submit\" name=\"Ok\"\">Submit Request</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type=\"button\" name=\"Cancel\"\" onclick=\"window.location.href='CFBamXMsgSrvWarRequestXml'\">Cancel;</button>" );
				out.println( "</form>" );
				out.println( "</BODY>" );
				out.println( "</HTML>" );
				return;
			}

			PrintWriter out = response.getWriter();
			log.setPrintWriter( out );
			envelopeHandler.parseStringContents( messageBody );
			response.setContentType( "text/plain" );
			String rspnBase64EncodedEncryptedSessionBlock = envelopeHandler.getResponse();
			out.append( rspnBase64EncodedEncryptedSessionBlock );
			out.flush();
		}

		catch( RuntimeException
			| InvalidKeyException
			| NoSuchAlgorithmException
			| NoSuchPaddingException
			| IllegalBlockSizeException e )
		{
			throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
				S_ProcName,
				"Caught " + e.getClass().getName() + " -- " + e.getMessage(),
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
