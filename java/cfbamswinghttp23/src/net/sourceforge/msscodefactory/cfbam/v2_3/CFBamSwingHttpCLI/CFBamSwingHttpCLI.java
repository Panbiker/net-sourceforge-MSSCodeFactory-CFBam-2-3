// Description: Java 7 Swing Client-Server GUI persisting via HTTP Web Client for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSwingHttpCLI;

import org.apache.log4j.*;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import javax.swing.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgClient.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSwing.*;

public class CFBamSwingHttpCLI
{
	private static ICFLibMessageLog log = new CFLibMessageLogWrapper();
	protected ICFBamSchemaObj schema = null;
	protected ICFBamSwingSchema swingSchema = null;
	protected JFrame desktop = null;

	protected CFBamXMsgClientHttpSchema httpClientSchema = null;

	// Constructors

	public CFBamSwingHttpCLI() {
	}

	// Accessors

	// CFBamXMsgClientHttpSchema accessors are needed to complete the wiring of the direct request invoker instance
	// that has been bound by the main() to a PostgreSQL persistance implementation.

	public CFBamXMsgClientHttpSchema getXMsgClientHttpSchema() {
		return( httpClientSchema );
	}

	public void setXMsgClientHttpSchema( CFBamXMsgClientHttpSchema invoker ) {
		httpClientSchema = invoker;
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
	}

	public ICFBamSwingSchema getSwingSchema() {
		if( swingSchema == null ) {
			swingSchema = new CFBamSwingSchema();
		}
		return( swingSchema );
	}

	public void setSwingSchema( ICFBamSwingSchema argSchema ) {
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				"setSwingSchema",
				1,
				"argSchema" );
		}
		swingSchema = argSchema;
	}

	public JFrame getDesktop() {
		if( desktop == null ) {
			ICFBamSwingSchema swing = getSwingSchema();
			desktop = swing.newMainJFrame();
		}
		return( desktop );
	}

	// main() entry point

	public static void main( String args[] ) {
		final String S_ProcName = "CFBamSwingHttpCLI.main() ";
		initConsoleLog();
		boolean fastExit = false;

		String homeDirName = System.getProperty( "HOME" );
		if( homeDirName == null ) {
			homeDirName = System.getProperty( "user.home" );
			if( homeDirName == null ) {
				log.message( S_ProcName + "ERROR: Home directory not set" );
				return;
			}
		}
		File homeDir = new File( homeDirName );
		if( ! homeDir.exists() ) {
			log.message( S_ProcName + "ERROR: Home directory \"" + homeDirName + "\" does not exist" );
			return;
		}
		if( ! homeDir.isDirectory() ) {
			log.message( S_ProcName + "ERROR: Home directory \"" + homeDirName + "\" is not a directory" );
			return;
		}

		CFBamClientConfigurationFile cFBamClientConfig = new CFBamClientConfigurationFile();
		String cFBamClientConfigFileName = homeDir.getPath() + File.separator + ".cfbamclientrc";
		cFBamClientConfig.setFileName( cFBamClientConfigFileName );
		File cFBamClientConfigFile = new File( cFBamClientConfigFileName );
		if( ! cFBamClientConfigFile.exists() ) {
			String cFBamKeyStoreFileName = homeDir.getPath() + File.separator + ".msscfjceks";
			cFBamClientConfig.setKeyStore( cFBamKeyStoreFileName );
			InetAddress localHost;
			try {
				localHost = InetAddress.getLocalHost();
			}
			catch( UnknownHostException e ) {
				localHost = null;
			}
			if( localHost == null ) {
				log.message( S_ProcName + "ERROR: LocalHost is null" );
				return;
			}
			String hostName = localHost.getHostName();
			if( ( hostName == null ) || ( hostName.length() <= 0 ) ) {
				log.message( "ERROR: LocalHost.HostName is null or empty" );
				return;
			}
			String userName = System.getProperty( "user.name" );
			if( ( userName == null ) || ( userName.length() <= 0 ) ) {
				log.message( "ERROR: user.name is null or empty" );
				return;
			}
			String deviceName = hostName.replaceAll( "[^\\w]", "_" ).toLowerCase()
				+ "-"
				+ userName.replaceAll( "[^\\w]", "_" ).toLowerCase();
			cFBamClientConfig.setDeviceName( deviceName );
			cFBamClientConfig.save();
			log.message( S_ProcName + "INFO: Created CFBam client configuration file " + cFBamClientConfigFileName );
			fastExit = true;
		}
		if( ! cFBamClientConfigFile.isFile() ) {
			log.message( S_ProcName + "ERROR: Proposed client configuration file " + cFBamClientConfigFileName + " is not a file." );
			fastExit = true;
		}
		if( ! cFBamClientConfigFile.canRead() ) {
			log.message( S_ProcName + "ERROR: Permission denied attempting to read client configuration file " + cFBamClientConfigFileName );
			fastExit = true;
		}
		cFBamClientConfig.load();

		if( fastExit ) {
			return;
		}

		// Configure logging
		Properties sysProps = System.getProperties();
		sysProps.setProperty( "log4j.rootCategory", "WARN" );
		sysProps.setProperty( "org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Log4JLogger" );

		Logger httpLogger = Logger.getLogger( "org.apache.http" );
		httpLogger.setLevel( Level.WARN );

		// The Invoker and it's implementation
		CFBamXMsgClientHttpSchema invoker = new CFBamXMsgClientHttpSchema();

		// And now for the client side cache implementation that invokes it
		ICFBamSchemaObj clientSchemaObj = new CFBamSchemaObj() {
			public void logout() {
				CFBamXMsgClientHttpSchema invoker = (CFBamXMsgClientHttpSchema)getBackingStore();
				try {
					invoker.logout( getAuthorization() );
				}
				catch( RuntimeException e ) {
				}
				setAuthorization( null );
			}
		};
		clientSchemaObj.setBackingStore( invoker );
		// And stitch the response handler to reference our client instance
		invoker.setResponseHandlerSchemaObj( clientSchemaObj );
		// And now we can stitch together the CLI to the SAX loader code
		CFBamSwingHttpCLI cli = new CFBamSwingHttpCLI();
		cli.setXMsgClientHttpSchema( invoker );
		cli.setSchema( clientSchemaObj );
		ICFBamSwingSchema swing = cli.getSwingSchema();
		swing.setClientConfigurationFile( cFBamClientConfig );
		swing.setSchema( clientSchemaObj );
		swing.setClusterName( "system" );
		swing.setTenantName( "system" );
		swing.setSecUserName( "system" );
		JFrame jframe = cli.getDesktop();
		jframe.setVisible( true );
		jframe.toFront();
	}

	// Initialize the console log

	protected static void initConsoleLog() {
		Layout layout = new PatternLayout(
				"%d{ISO8601}"		// Start with a timestamp
			+	" %-5p"				// Include the severity
			+	" %C.%M"			// pkg.class.method()
			+	" %F[%L]"			// File[lineNumber]
			+	": %m\n" );			// Message text
		BasicConfigurator.configure( new ConsoleAppender( layout, "System.out" ) );
	}

}
