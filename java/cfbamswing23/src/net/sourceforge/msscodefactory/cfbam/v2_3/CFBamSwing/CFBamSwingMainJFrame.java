// Description: Java 7 Swing Main JFrame implementation for CFBam

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


package net.sourceforge.msscodefactory.cfbam.v2_3.CFBamSwing;

import java.security.KeyStore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/**
 *	CFBamSwingMainJFrame Swing Main JFrame implementation
 *	for CFBam.
 */
public class CFBamSwingMainJFrame
extends JFrame
{
	protected CFBamSwingMainJFrame mainWindow = null;
	protected ICFBamSwingSchema swingSchema = null;
	protected JDesktopPane swingDesktopPane = null;
	protected class MainDesktopPane
	extends JDesktopPane
	{
		protected int windowIndentation = 0;

		public MainDesktopPane() {
			super();
		}

		public Component add( Component compo ) {
			if( compo instanceof JInternalFrame ) {
				JInternalFrame frame = (JInternalFrame)compo;
				int xyIndent = windowIndentation * 30;
				frame.setLocation( xyIndent, xyIndent );
				windowIndentation++;
				if( windowIndentation >= 5 ) {
					windowIndentation = 0;
				}
			}
			Component retval = super.add( compo );
			return( retval );
		}
	}

	protected class MainWindowListener
	implements WindowListener
	{
		public MainWindowListener() {
			super();
		}

		public void windowOpened( WindowEvent e ) {
			KeyStore keyStore = swingSchema.getKeyStore();
			if( keyStore == null ) {
				JInternalFrame frame = swingSchema.newOpenKeystoreJInternalFrame();
				swingDesktopPane.add( frame );
				frame.setVisible( true );
				frame.show();
			}
		}

		public void windowClosing( WindowEvent e ) {
		}

		public void windowClosed( WindowEvent e ) {
		}

		public void windowIconified( WindowEvent e ) {
		}

		public void windowDeiconified( WindowEvent e ) {
			KeyStore keyStore = swingSchema.getKeyStore();
			if( keyStore == null ) {
				JInternalFrame frame = swingSchema.newOpenKeystoreJInternalFrame();
				swingDesktopPane.add( frame );
				frame.setVisible( true );
				frame.show();
			}
		}

		public void windowActivated( WindowEvent e ) {
		}

		public void windowDeactivated( WindowEvent e ) {
		}
	}

	protected class ActionFileLogin
	extends AbstractAction
	{
		public ActionFileLogin() {
			super();
			putValue( Action.NAME, "Login..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.newLoginJInternalFrame();
			swingDesktopPane.add( frame );
			if( loginInternalFrameListener == null ) {
				loginInternalFrameListener = new MainLoginInternalFrameListener();
			}
			frame.addInternalFrameListener( loginInternalFrameListener );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFileImport
	extends AbstractAction
	{
		public ActionFileImport() {
			super();
			putValue( Action.NAME, "Import..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.newFileImportJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFileLogout
	extends AbstractAction
	{
		public ActionFileLogout() {
			super();
			putValue( Action.NAME, "Logout" );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			if( ( schemaObj != null ) && ( schemaObj.getAuthorization() != null ) ) {
				try {
					schemaObj.logout();
				}
				catch( Exception x ) {
					JOptionPane.showMessageDialog( null, "Logout error: " + x.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
					return;
				}
				finally {
					schemaObj.setAuthorization( null );
					adjustMenusAndActions();
				}
			}
			JInternalFrame aframe;
			JInternalFrame[] frames = swingDesktopPane.getAllFrames();
			for( int i = frames.length - 1; i >= 0; i-- ) {
				aframe = frames[i];
				aframe.dispose();
			}
		}
	}

	public void exitApplication() {
		ICFBamSchemaObj schemaObj = swingSchema.getSchema();
		if( null != schemaObj.getAuthorization() ) {
			try {
				schemaObj.logout();
			}
			catch( Exception x ) {
			}
			finally {
				schemaObj.setAuthorization( null );
			}
		}
		mainWindow.dispose();
		mainWindow = null;
	}

	protected class ActionFileExit
	extends AbstractAction
	{
		public ActionFileExit() {
			super();
			putValue( Action.NAME, "Exit" );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			exitApplication();
		}
	}

	protected class ActionFindAccessFrequency
	extends AbstractAction
	{
		public ActionFindAccessFrequency() {
			super();
			putValue( Action.NAME, "Find AccessFrequency..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getAccessFrequencyFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindAccessSecurity
	extends AbstractAction
	{
		public ActionFindAccessSecurity() {
			super();
			putValue( Action.NAME, "Find AccessSecurity..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getAccessSecurityFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindAuditAction
	extends AbstractAction
	{
		public ActionFindAuditAction() {
			super();
			putValue( Action.NAME, "Find Audit Action..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getAuditActionFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindCluster
	extends AbstractAction
	{
		public ActionFindCluster() {
			super();
			putValue( Action.NAME, "Find Cluster..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getClusterFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindDataScope
	extends AbstractAction
	{
		public ActionFindDataScope() {
			super();
			putValue( Action.NAME, "Find DataScope..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getDataScopeFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindHostNode
	extends AbstractAction
	{
		public ActionFindHostNode() {
			super();
			putValue( Action.NAME, "Find Host Node..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getHostNodeFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindISOCountry
	extends AbstractAction
	{
		public ActionFindISOCountry() {
			super();
			putValue( Action.NAME, "Find ISO Country..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getISOCountryFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindISOCurrency
	extends AbstractAction
	{
		public ActionFindISOCurrency() {
			super();
			putValue( Action.NAME, "Find ISO Currency..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getISOCurrencyFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindISOLanguage
	extends AbstractAction
	{
		public ActionFindISOLanguage() {
			super();
			putValue( Action.NAME, "Find ISO Language..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getISOLanguageFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindISOTimezone
	extends AbstractAction
	{
		public ActionFindISOTimezone() {
			super();
			putValue( Action.NAME, "Find ISO Timezone..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getISOTimezoneFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindLoaderBehaviour
	extends AbstractAction
	{
		public ActionFindLoaderBehaviour() {
			super();
			putValue( Action.NAME, "Find LoaderBehaviour..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getLoaderBehaviourFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindMimeType
	extends AbstractAction
	{
		public ActionFindMimeType() {
			super();
			putValue( Action.NAME, "Find MIME Type..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getMimeTypeFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindRelationType
	extends AbstractAction
	{
		public ActionFindRelationType() {
			super();
			putValue( Action.NAME, "Find RelationType..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getRelationTypeFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindSecApp
	extends AbstractAction
	{
		public ActionFindSecApp() {
			super();
			putValue( Action.NAME, "Find Security Application..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getSecAppFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindSecGroup
	extends AbstractAction
	{
		public ActionFindSecGroup() {
			super();
			putValue( Action.NAME, "Find Security Group..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getSecGroupFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindSecUser
	extends AbstractAction
	{
		public ActionFindSecUser() {
			super();
			putValue( Action.NAME, "Find Security User..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getSecUserFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindSecurityScope
	extends AbstractAction
	{
		public ActionFindSecurityScope() {
			super();
			putValue( Action.NAME, "Find SecurityScope..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getSecurityScopeFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindServiceType
	extends AbstractAction
	{
		public ActionFindServiceType() {
			super();
			putValue( Action.NAME, "Find Service Type..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getServiceTypeFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindSysCluster
	extends AbstractAction
	{
		public ActionFindSysCluster() {
			super();
			putValue( Action.NAME, "Find Cluster..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getSysClusterFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindTSecGroup
	extends AbstractAction
	{
		public ActionFindTSecGroup() {
			super();
			putValue( Action.NAME, "Find Tenant Security Group..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getTSecGroupFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindTenant
	extends AbstractAction
	{
		public ActionFindTenant() {
			super();
			putValue( Action.NAME, "Find Tenant..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getTenantFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindTld
	extends AbstractAction
	{
		public ActionFindTld() {
			super();
			putValue( Action.NAME, "Find Top Level Domain..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getTldFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class ActionFindURLProtocol
	extends AbstractAction
	{
		public ActionFindURLProtocol() {
			super();
			putValue( Action.NAME, "Find URL Protocol..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			JInternalFrame frame = swingSchema.getURLProtocolFactory().newFinderJInternalFrame();
			swingDesktopPane.add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	protected class MainLoginInternalFrameListener
	implements InternalFrameListener
	{
		public MainLoginInternalFrameListener() {
		}

		public void internalFrameActivated( InternalFrameEvent e ) {
		}

		public void internalFrameClosed( InternalFrameEvent e ) {
			adjustMenusAndActions();
		}

		public void internalFrameClosing( InternalFrameEvent e ) {
		}

		public void internalFrameDeactivated( InternalFrameEvent e ) {
		}

		public void internalFrameIconified( InternalFrameEvent e ) {
		}

		public void internalFrameDeiconified( InternalFrameEvent e ) {
		}

		public void internalFrameOpened( InternalFrameEvent e ) {
			adjustMenusAndActions();
		}
	}

	protected JMenuBar mainMenuBar = null;
	protected JMenu menuFile = null;
	protected Action actionFileImport = null;
	protected Action actionFileLogin = null;
	protected Action actionFileLogout = null;
	protected Action actionFileExit = null;
	protected JMenu menuFind = null;
	protected Action actionFindAccessFrequency = null;
	protected Action actionFindAccessSecurity = null;
	protected Action actionFindAuditAction = null;
	protected Action actionFindCluster = null;
	protected Action actionFindDataScope = null;
	protected Action actionFindHostNode = null;
	protected Action actionFindISOCountry = null;
	protected Action actionFindISOCurrency = null;
	protected Action actionFindISOLanguage = null;
	protected Action actionFindISOTimezone = null;
	protected Action actionFindLoaderBehaviour = null;
	protected Action actionFindMimeType = null;
	protected Action actionFindRelationType = null;
	protected Action actionFindSecApp = null;
	protected Action actionFindSecGroup = null;
	protected Action actionFindSecUser = null;
	protected Action actionFindSecurityScope = null;
	protected Action actionFindServiceType = null;
	protected Action actionFindSysCluster = null;
	protected Action actionFindTSecGroup = null;
	protected Action actionFindTenant = null;
	protected Action actionFindTld = null;
	protected Action actionFindURLProtocol = null;
	protected MainWindowListener mainWindowListener = null;
	protected MainLoginInternalFrameListener loginInternalFrameListener = null;

	public CFBamSwingMainJFrame( ICFBamSwingSchema argSchema ) {
		super();
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		mainWindow = this;
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		swingSchema = argSchema;
		swingDesktopPane = new MainDesktopPane();
		setContentPane( swingDesktopPane );
		Dimension dim = new Dimension( 1280, 700 );
		setSize( dim );
		setMinimumSize( dim );
		setTitle( "CFBam Desktop" );
		setJMenuBar( getMainMenuBar() );
		adjustMenusAndActions();
		mainWindowListener = new MainWindowListener();
		mainWindow.addWindowListener( mainWindowListener );
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public JMenuBar getMainMenuBar() {
		if( mainMenuBar == null ) {
			JMenuItem menuItem;
			mainMenuBar = new JMenuBar();
				menuFile = new JMenu( "File" );
					menuFind = new JMenu( "Find" );
						actionFindAccessFrequency = new ActionFindAccessFrequency();
						menuItem = new JMenuItem( actionFindAccessFrequency );
						menuFind.add( menuItem );
						actionFindAccessSecurity = new ActionFindAccessSecurity();
						menuItem = new JMenuItem( actionFindAccessSecurity );
						menuFind.add( menuItem );
						actionFindAuditAction = new ActionFindAuditAction();
						menuItem = new JMenuItem( actionFindAuditAction );
						menuFind.add( menuItem );
						actionFindCluster = new ActionFindCluster();
						menuItem = new JMenuItem( actionFindCluster );
						menuFind.add( menuItem );
						actionFindDataScope = new ActionFindDataScope();
						menuItem = new JMenuItem( actionFindDataScope );
						menuFind.add( menuItem );
						actionFindHostNode = new ActionFindHostNode();
						menuItem = new JMenuItem( actionFindHostNode );
						menuFind.add( menuItem );
						actionFindISOCountry = new ActionFindISOCountry();
						menuItem = new JMenuItem( actionFindISOCountry );
						menuFind.add( menuItem );
						actionFindISOCurrency = new ActionFindISOCurrency();
						menuItem = new JMenuItem( actionFindISOCurrency );
						menuFind.add( menuItem );
						actionFindISOLanguage = new ActionFindISOLanguage();
						menuItem = new JMenuItem( actionFindISOLanguage );
						menuFind.add( menuItem );
						actionFindISOTimezone = new ActionFindISOTimezone();
						menuItem = new JMenuItem( actionFindISOTimezone );
						menuFind.add( menuItem );
						actionFindLoaderBehaviour = new ActionFindLoaderBehaviour();
						menuItem = new JMenuItem( actionFindLoaderBehaviour );
						menuFind.add( menuItem );
						actionFindMimeType = new ActionFindMimeType();
						menuItem = new JMenuItem( actionFindMimeType );
						menuFind.add( menuItem );
						actionFindRelationType = new ActionFindRelationType();
						menuItem = new JMenuItem( actionFindRelationType );
						menuFind.add( menuItem );
						actionFindSecApp = new ActionFindSecApp();
						menuItem = new JMenuItem( actionFindSecApp );
						menuFind.add( menuItem );
						actionFindSecGroup = new ActionFindSecGroup();
						menuItem = new JMenuItem( actionFindSecGroup );
						menuFind.add( menuItem );
						actionFindSecUser = new ActionFindSecUser();
						menuItem = new JMenuItem( actionFindSecUser );
						menuFind.add( menuItem );
						actionFindSecurityScope = new ActionFindSecurityScope();
						menuItem = new JMenuItem( actionFindSecurityScope );
						menuFind.add( menuItem );
						actionFindServiceType = new ActionFindServiceType();
						menuItem = new JMenuItem( actionFindServiceType );
						menuFind.add( menuItem );
						actionFindSysCluster = new ActionFindSysCluster();
						menuItem = new JMenuItem( actionFindSysCluster );
						menuFind.add( menuItem );
						actionFindTSecGroup = new ActionFindTSecGroup();
						menuItem = new JMenuItem( actionFindTSecGroup );
						menuFind.add( menuItem );
						actionFindTenant = new ActionFindTenant();
						menuItem = new JMenuItem( actionFindTenant );
						menuFind.add( menuItem );
						actionFindTld = new ActionFindTld();
						menuItem = new JMenuItem( actionFindTld );
						menuFind.add( menuItem );
						actionFindURLProtocol = new ActionFindURLProtocol();
						menuItem = new JMenuItem( actionFindURLProtocol );
						menuFind.add( menuItem );
					menuFile.add( menuFind );
					actionFileImport = new ActionFileImport();
					menuItem = new JMenuItem( actionFileImport );
					menuFile.add( menuItem );
					actionFileLogin = new ActionFileLogin();
					menuItem = new JMenuItem( actionFileLogin );
					menuFile.add( menuItem );
					actionFileLogout = new ActionFileLogout();
					menuItem = new JMenuItem( actionFileLogout );
					menuFile.add( menuItem );
					actionFileExit = new ActionFileExit();
					menuItem = new JMenuItem( actionFileExit );
					menuFile.add( menuItem );
				mainMenuBar.add( menuFile );
		}
		return( mainMenuBar );
	}

	public void adjustMenusAndActions() {
		if( null == swingSchema.getSchema().getAuthorization() ) {
			// Logged out
			actionFileLogin.setEnabled( true );
			actionFileLogout.setEnabled( false );
			actionFileImport.setEnabled( false );
			menuFind.setEnabled( false );
		}
		else {
			// Logged in
			actionFileLogin.setEnabled( false );
			actionFileLogout.setEnabled( true );
			actionFileImport.setEnabled( true );
			menuFind.setEnabled( true );
		}
		actionFileExit.setEnabled( true );
	}
}
