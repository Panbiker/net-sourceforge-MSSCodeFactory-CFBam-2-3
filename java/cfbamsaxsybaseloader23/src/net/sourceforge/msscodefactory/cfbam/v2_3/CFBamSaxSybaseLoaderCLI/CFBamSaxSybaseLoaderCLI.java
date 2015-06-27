// Description: Java 7 XML SAX Loader CLI persisting as PostgreSQL for CFBam.

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSaxSybaseLoaderCLI;

import org.apache.log4j.*;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSybase.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSaxLoader.*;

public class CFBamSaxSybaseLoaderCLI
	extends CFBamSaxLoaderCLI
{
	private static ICFLibMessageLog log = new CFLibMessageLogWrapper();

	// Constructors

	public CFBamSaxSybaseLoaderCLI() {
		super( log );
	}

	// main() entry point

	public static void main( String args[] ) {
		final String S_ProcName = "CFBamSaxSybaseLoaderCLI.main() ";
		initConsoleLog();
		int numArgs = args.length;
		if( numArgs >= 2 ) {
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
			CFBamConfigurationFile cFBamConfig = new CFBamConfigurationFile();
			String cFBamConfigFileName = homeDir.getPath() + File.separator + ".cfbamsybaserc";
			cFBamConfig.setFileName( cFBamConfigFileName );
			File cFBamConfigFile = new File( cFBamConfigFileName );
			if( ! cFBamConfigFile.exists() ) {
				cFBamConfig.setDbServer( "localhost" );
				cFBamConfig.setDbPort( 2345 );
				cFBamConfig.setDbDatabase( "CFBam23" );
				cFBamConfig.setDbUserName( "sa" );
				cFBamConfig.setDbPassword( "edit-me-please" );
				cFBamConfig.save();
				log.message( S_ProcName + "INFO: Created configuration file " + cFBamConfigFileName + ", please edit configuration and restart." );
				return;
			}
			if( ! cFBamConfigFile.isFile() ) {
				log.message( S_ProcName + "ERROR: Proposed configuration file " + cFBamConfigFileName + " is not a file." );
				return;
			}
			if( ! cFBamConfigFile.canRead() ) {
				log.message( S_ProcName + "ERROR: Permission denied attempting to read configuration file " + cFBamConfigFileName );
				return;
			}
			cFBamConfig.load();
			boolean fastExit = false;
			CFBamClientConfigurationFile cFDbTestClientConfig = new CFBamClientConfigurationFile();
			String cFDbTestClientConfigFileName = homeDir.getPath() + File.separator + ".cfdbtestclientrc";
			cFDbTestClientConfig.setFileName( cFDbTestClientConfigFileName );
			File cFDbTestClientConfigFile = new File( cFDbTestClientConfigFileName );
			if( ! cFDbTestClientConfigFile.exists() ) {
				String cFDbTestKeyStoreFileName = homeDir.getPath() + File.separator + ".msscfjceks";
				cFDbTestClientConfig.setKeyStore( cFDbTestKeyStoreFileName );
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
				cFDbTestClientConfig.setDeviceName( deviceName );
				cFDbTestClientConfig.save();
				log.message( S_ProcName + "INFO: Created CFBam client configuration file " + cFDbTestClientConfigFileName );
				fastExit = true;
			}
			if( ! cFDbTestClientConfigFile.isFile() ) {
				log.message( S_ProcName + "ERROR: Proposed client configuration file " + cFDbTestClientConfigFileName + " is not a file." );
				fastExit = true;
			}
			if( ! cFDbTestClientConfigFile.canRead() ) {
				log.message( S_ProcName + "ERROR: Permission denied attempting to read client configuration file " + cFDbTestClientConfigFileName );
				fastExit = true;
			}
			cFDbTestClientConfig.load();

			if( fastExit ) {
				return;
			}

			// Configure logging
			Properties sysProps = System.getProperties();
			sysProps.setProperty( "log4j.rootCategory", "WARN" );
			sysProps.setProperty( "org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Log4JLogger" );

			Logger httpLogger = Logger.getLogger( "org.apache.http" );
			httpLogger.setLevel( Level.WARN );

			ICFBamSchema cFBamSchema = new CFBamSybaseSchema();
			cFBamSchema.setConfiguration( cFBamConfig );
			ICFBamSchemaObj cFBamSchemaObj = new CFBamSchemaObj();
			cFBamSchemaObj.setBackingStore( cFBamSchema );
			CFBamSaxLoaderCLI cli = new CFBamSaxSybaseLoaderCLI();
			CFBamSaxLoader loader = cli.getSaxLoader();
			loader.setSchemaObj( cFBamSchemaObj );
			cFBamSchema.connect();
			String url = args[1];
			if( numArgs >= 5 ) {
				cli.setClusterName( args[2] );
				cli.setTenantName( args[3] );
				cli.setSecUserName( args[4] );
			}
			else {
				cli.setClusterName( "default" );
				cli.setTenantName( "system" );
				cli.setSecUserName( "system" );
			}
			loader.setUseCluster( cli.getClusterObj() );
			loader.setUseTenant( cli.getTenantObj() );
			try {
				cFBamSchema.beginTransaction();
				cFBamSchemaObj.setSecCluster( cli.getClusterObj() );
				cFBamSchemaObj.setSecTenant( cli.getTenantObj() );
				cFBamSchemaObj.setSecUser( cli.getSecUserObj() );
				cFBamSchemaObj.setSecSession( cli.getSecSessionObj() );
				CFBamAuthorization auth = new CFBamAuthorization();
				auth.setSecCluster( cFBamSchemaObj.getSecCluster() );
				auth.setSecTenant( cFBamSchemaObj.getSecTenant() );
				auth.setSecSession( cFBamSchemaObj.getSecSession() );
				cFBamSchemaObj.setAuthorization( auth );
				applyLoaderOptions( loader, args[0] );
				if( numArgs >= 5 ) {
					cli.evaluateRemainingArgs( args, 5 );
				}
				else {
					cli.evaluateRemainingArgs( args, 2 );
				}
				loader.parseFile( url );
				cFBamSchema.commit();
				cFBamSchema.disconnect( true );
			}
			catch( Exception e ) {
				log.message( S_ProcName + "EXCEPTION: Could not parse XML file \"" + url + "\": " + e.getMessage() );
				e.printStackTrace( System.out );
			}
			catch( Error e ) {
				log.message( S_ProcName + "ERROR: Could not parse XML file \"" + url + "\": " + e.getMessage() );
				e.printStackTrace( System.out );
			}
			finally {
				if( cFBamSchema.isConnected() ) {
					cFBamSchema.rollback();
					cFBamSchema.disconnect( false );
				}
			}
		}
		else {
			log.message( S_ProcName + "ERROR: Expected at least two argument specifying the loader options and the name of the XML file to parse.  The first argument may be empty." );
		}
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

	// Evaluate remaining arguments

	public void evaluateRemainingArgs( String[] args, int consumed ) {
		// There are no extra arguments for the Sybase ASE database instance
		if( args.length > consumed ) {
			log.message( "CFBamSaxSybaseLoaderCLI.evaluateRemainingArgs() WARNING No extra arguments are expected for a Sybase ASE database instance, but "
				+ Integer.toString( args.length - consumed )
				+ " extra arguments were specified.  Extra arguments ignored." );
		}
	}

}
