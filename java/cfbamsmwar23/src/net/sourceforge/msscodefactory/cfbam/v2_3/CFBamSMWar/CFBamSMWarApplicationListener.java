
// Description: Java 7 Security Manager Application Listener

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

import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

import com.sun.mail.smtp.SMTPTransport;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.CFLib;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.CFBamSchemaPool;

/**
 * Application Lifecycle Listener implementation class CFBamPgSqlWARApplicationListener
 *
 */
@WebListener
public class CFBamSMWarApplicationListener implements ServletContextListener {
	protected String smtpUsername = null;
	protected String smtpPassword = null;

    /**
     * Default constructor. 
     */
    public CFBamSMWarApplicationListener() {
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		final String S_ProcName = "contextInitialized";
		
		Properties props = System.getProperties();
		if( null == CFBamSchemaPool.getSchemaPool() ) {
			try {
				Context ctx = new InitialContext();
				String poolClassName = (String)ctx.lookup( "java:comp/env/CFBam23PoolClass");
				if( ( poolClassName == null ) || ( poolClassName.length() <= 0 ) ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"JNDI lookup for CFBam23PoolClass" );
				}

				Class poolClass = Class.forName( poolClassName );
				if( poolClass == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"CFBam23PoolClass \"" + poolClassName + "\" not found." );
				}
				
				Object obj = poolClass.newInstance();
				if( obj instanceof CFBamSchemaPool ) {
					CFBamSchemaPool newPool = (CFBamSchemaPool)obj;
					newPool.setConfigurationFile( null );
					newPool.setJndiName( "java:comp/env/CFBam23Connection" );
					CFBamSchemaPool.setSchemaPool( newPool );
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
						S_ProcName,
						"Problems constructing an instance of " + poolClassName );
				}

				String smtpHost = (String)ctx.lookup( "java:comp/env/CFBam23SmtpHost");
				if( ( smtpHost == null ) || ( smtpHost.length() <= 0 ) ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
							S_ProcName,
							0,
							"JNDI lookup for CFBam23SmtpHost" );
				}
				props.setProperty( "mail.smtp.host", smtpHost );

				String smtpStartTLS = (String)ctx.lookup( "java:comp/env/CFBam23SmtpStartTLS");
				if( ( smtpHost == null ) || ( smtpHost.length() <= 0 ) ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
							S_ProcName,
							0,
							"JNDI lookup for CFBam23SmtpStartTLS" );
				}
				props.setProperty( "mail.smtp.starttls.enable", smtpStartTLS );

				String smtpSocketFactoryClass = (String)ctx.lookup( "java:comp/env/CFBam23SmtpSocketFactoryClass");
				if( ( smtpSocketFactoryClass == null ) || ( smtpSocketFactoryClass.length() <= 0 ) ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
							S_ProcName,
							0,
							"JNDI lookup for CFBam23SmtpSocketFactoryClass" );
				}
				props.setProperty( "mail.smtp.socketFactory.class", smtpSocketFactoryClass );
				
				props.setProperty( "mail.smtp.socketFactory.fallback", "false" );

				String smtpPort = (String)ctx.lookup( "java:comp/env/CFBam23SmtpPort");
				if( ( smtpPort == null ) || ( smtpPort.length() <= 0 ) ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
							S_ProcName,
							0,
							"JNDI lookup for CFBam23SmtpPort" );
				}
				props.setProperty( "mail.smtp.port", smtpPort );
				props.setProperty( "mail.smtp.socketFactory.port", smtpPort );

				props.setProperty( "mail.smtps.auth", "true" );
				
				props.put( "mail.smtps.quitwait", "false" );

				String smtpEmailFrom = (String)ctx.lookup( "java:comp/env/CFBam23SmtpEmailFrom");
				if( ( smtpEmailFrom == null ) || ( smtpEmailFrom.length() <= 0 ) ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
							S_ProcName,
							0,
							"JNDI lookup for CFBam23SmtpEmailFrom" );
				}

				smtpUsername = (String)ctx.lookup( "java:comp/env/CFBam23SmtpUsername");
				if( ( smtpUsername == null ) || ( smtpUsername.length() <= 0 ) ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
							S_ProcName,
							0,
							"JNDI lookup for CFBam23SmtpUsername" );
				}

				smtpPassword = (String)ctx.lookup( "java:comp/env/CFBam23SmtpPassword");
				if( ( smtpPassword == null ) || ( smtpPassword.length() <= 0 ) ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
							S_ProcName,
							0,
							"JNDI lookup for CFBam23SmtpPassword" );
				}

			}
			catch( ClassNotFoundException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Caught ClassNotFoundException -- " + e.getMessage(),
					e );
			}
			catch( IllegalAccessException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Caught IllegalAccessException trying to construct newInstance() -- " + e.getMessage(),
					e );
			}
			catch( InstantiationException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Caught InstantiationException trying to construct newInstance() -- " + e.getMessage(),
					e );
			}
			catch( NamingException e ) {
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Caught NamingException -- " + e.getMessage(),
					e );
			}
		}
	}
}
