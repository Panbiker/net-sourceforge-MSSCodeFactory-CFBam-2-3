// Description: Java 7 Swing Login JInternalFrame implementation for CFBam.

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

import java.awt.*;
import java.awt.event.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import javax.swing.event.*;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Tip.CFTipClientHandler;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgClient.CFBamXMsgClientHttpSchema;

/**
 *	CFBamSwingLoginJInternalFrame Swing Login JInternalFrame implementation
 *	for CFBam.
 */
public class CFBamSwingLoginJInternalFrame
extends CFJInternalFrame
{
	protected ICFBamSwingSchema swingSchema = null;
	protected LoginInternalFrameListener loginInternalFrameListener = null;
	protected class LoginInternalFrameListener
	implements InternalFrameListener
	{
		public LoginInternalFrameListener() {
		}

		public void internalFrameActivated( InternalFrameEvent e ) {
		}

		public void internalFrameClosed( InternalFrameEvent e ) {
		}

		public void internalFrameClosing( InternalFrameEvent e ) {
		}

		public void internalFrameDeactivated( InternalFrameEvent e ) {
		}

		public void internalFrameIconified( InternalFrameEvent e ) {
		}

		public void internalFrameDeiconified( InternalFrameEvent e ) {
			KeyStore keyStore = swingSchema.getKeyStore();
			if( keyStore == null ) {
				JInternalFrame frame = swingSchema.newOpenKeystoreJInternalFrame();
				getDesktopPane().add( frame );
				frame.setVisible( true );
				frame.show();
			}
		}

		public void internalFrameOpened( InternalFrameEvent e ) {
			KeyStore keyStore = swingSchema.getKeyStore();
			if( keyStore == null ) {
				JInternalFrame frame = swingSchema.newOpenKeystoreJInternalFrame();
				getDesktopPane().add( frame );
				frame.setVisible( true );
				frame.show();
			}
		}
	}

	public LoginInternalFrameListener getLoginInternalFrameListener() {
		if( loginInternalFrameListener == null ) {
			loginInternalFrameListener = new LoginInternalFrameListener();
		}
		return( loginInternalFrameListener );
	}

	protected class LoginJPanel extends CFJPanel {

		protected final String strDefault = "default";
		protected final String strSystem = "system";
		protected JLabel labelServerURL = null;
		protected JComboBox<String> comboServerURL = null;
		protected JLabel labelCluster = null;
		protected JComboBox<String> comboCluster = null;
		protected JLabel labelTenant = null;
		protected CFJStringEditor textTenant = null;
		protected JLabel labelSecUser = null;
		protected CFJStringEditor textSecUser = null;
		protected JLabel labelPassword = null;
		protected JPasswordField textPassword = null;
		protected JButton buttonOk = null;
		protected JButton buttonCancel = null;

		protected class ComboClusterActionListener
		implements ActionListener
		{
			public ComboClusterActionListener() {
			}

			public void actionPerformed(ActionEvent e) {
				String selected = (String)comboCluster.getSelectedItem();
				if( strSystem.equals( selected ) ) {
					textTenant.setText( strSystem );
					textTenant.setEnabled( false );
					textTenant.setEditable( false );
				}
				else {
					textTenant.setEnabled( true );
					textTenant.setEditable( true );
				}
			}
		}

		protected class ComboServerURLActionListener
		implements ActionListener
		{
			public ComboServerURLActionListener() {
			}

			public void actionPerformed(ActionEvent e) {
				final String S_ProcName = "actionPerformed";
				if( e.getActionCommand().equals( "comboBoxEdited" ) ) {
					String selected = (String)comboServerURL.getSelectedItem();
					if( ( selected == null ) || ( selected.length() <= 0 ) ) {
						selected = (String)comboServerURL.getEditor().getItem();
					}
					if( ( selected != null ) && ( selected.length() > 0 ) ) {
						comboServerURL.addItem( selected );
						CFBamClientConfigurationFile clientConfigFile = swingSchema.getClientConfigurationFile();
						if( clientConfigFile == null ) {
							throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
								S_ProcName,
								0,
								"swingSchema.clientConfigFile" );
						}
						clientConfigFile.setLatestServerURL( selected );
					}
				}
			}
		}

		protected class ActionOk 
		extends AbstractAction
		{
			public ActionOk() {
				super();
				putValue( Action.NAME, "Ok" );
				setEnabled( true );
			}

			public void actionPerformed( ActionEvent e ) {
				final String S_ProcName = "actionPerformed";
				KeyStore keyStore = swingSchema.getKeyStore();
				if( keyStore == null ) {
					JInternalFrame nextForm = swingSchema.newOpenKeystoreJInternalFrame();
					getDesktopPane().add( nextForm );
					nextForm.setVisible( true );
					nextForm.show();
				}
				else {
					ICFBamSchemaObj schemaObj = swingSchema.getSchema();
					if( schemaObj.getAuthorization() != null ) {
						JOptionPane.showMessageDialog( null, "Already authorized", "Warning", JOptionPane.WARNING_MESSAGE );
						return;
					}
					ICFBamSchema backingStore = schemaObj.getBackingStore();
					if( ! ( backingStore instanceof CFBamXMsgClientHttpSchema ) ) {
						throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
							S_ProcName,
							"backingStore",
							backingStore,
							"CFBamXMsgClientHttpSchema" );
					}
					CFBamXMsgClientHttpSchema clientSchema = (CFBamXMsgClientHttpSchema)backingStore;
					CFTipClientHandler clientHandler = clientSchema.getCFTipClientHandler();
					String serverURL = (String)comboServerURL.getSelectedItem();
					String clusterName = (String)comboCluster.getSelectedItem();
					String tenantName = textTenant.getText();
					String secUserName = textSecUser.getText();
					char pw[] = textPassword.getPassword();
					String dbPassword;
					if( pw != null ) {
						dbPassword = new String( pw );
					}
					else {
						dbPassword = null;
					}
					if( ( ( serverURL == null ) || ( serverURL.length() <= 0 ) )
						|| ( ( clusterName == null ) || ( clusterName.length() <= 0 ) )
						|| ( ( tenantName == null ) || ( tenantName.length() <= 0 ) )
						|| ( ( secUserName == null ) || ( secUserName.length() <= 0 ) )
						|| ( ( dbPassword == null ) || ( dbPassword.length() <= 0 ) ) )
					{
						JOptionPane.showMessageDialog( null, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE );
						return;
					}
					try {
						clientSchema.setServerURL( serverURL );
						if( ! schemaObj.connect( clusterName, tenantName, secUserName, dbPassword ) ) {
							JOptionPane.showMessageDialog( null, "Could not establish authorization", "Error", JOptionPane.ERROR_MESSAGE );
							return;
						}
					}
					catch( RuntimeException x ) {
						JOptionPane.showMessageDialog( null, "Could not establish connection: " + x.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
						return;
					}
					JOptionPane.showMessageDialog( null, "Login authorized", "Information", JOptionPane.INFORMATION_MESSAGE );
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						JInternalFrame frame = (JInternalFrame)cont;
						try {
							frame.setClosed( true );
						}
						catch( Exception x ) {
						}
					}
				}
			}
		}

		protected class ActionCancel
		extends AbstractAction
		{
			public ActionCancel() {
				super();
				putValue( Action.NAME, "Cancel" );
				setEnabled( true );
			}

			public void actionPerformed( ActionEvent e ) {
				Container cont = getParent();
				while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
					cont = cont.getParent();
				}
				if( cont != null ) {
					JInternalFrame frame = (JInternalFrame)cont;
					try {
						frame.setClosed( true );
					}
					catch( Exception x ) {
					}
				}
			}
		}

		protected Action actionOk = null;
		protected Action actionCancel = null;

		public LoginJPanel() {
			super();
			labelServerURL = new JLabel();
			labelServerURL.setText( "Server URL" );
			DefaultComboBoxModel<String> comboServerURLModel = new DefaultComboBoxModel<String>();
			comboServerURL = new JComboBox<String>();
			comboServerURL.setModel( comboServerURLModel );
			comboServerURL.setEditable( true );
			comboServerURL.setEnabled( true );
			comboServerURL.addActionListener( new ComboServerURLActionListener() );
			CFBamClientConfigurationFile clientConfigFile = swingSchema.getClientConfigurationFile();
			clientConfigFile.load();
			String histServerURL[] = clientConfigFile.getServerURLArray();
			int numHistServerURL = histServerURL.length;
			int curIdx;
			String curServerURL;
			for ( curIdx = 0; curIdx < numHistServerURL; curIdx ++ ) {
				curServerURL = histServerURL[curIdx];
				comboServerURL.addItem( curServerURL );
			}
			if( numHistServerURL > 0 ) {
				comboServerURL.setSelectedIndex( 0 );
			}
			labelCluster = new JLabel();
			labelCluster.setText( "Cluster" );
			DefaultComboBoxModel<String> comboClusterModel = new DefaultComboBoxModel<String>();
			comboCluster = new JComboBox<String>();
			comboCluster.setModel( comboClusterModel );
			comboCluster.setEditable( false );
			comboCluster.setEnabled( true );
			comboCluster.addItem( strDefault );
			comboCluster.addItem( strSystem );
			comboCluster.setSelectedIndex( 0 );
			comboCluster.addActionListener( new ComboClusterActionListener() );
			labelTenant = new JLabel();
			labelTenant.setText( "Tenant" );
			textTenant = new CFJStringEditor();
			textTenant.setMaxLen( 512 );
			labelSecUser = new JLabel();
			labelSecUser.setText( "User" );
			textSecUser = new CFJStringEditor();
			textSecUser.setMaxLen( 512 );
			labelPassword = new JLabel();
			labelPassword.setText( "Password" );
			textPassword = new JPasswordField();
			actionOk = new ActionOk();
			actionCancel = new ActionCancel();
			buttonOk = new JButton( actionOk );
			buttonCancel = new JButton( actionCancel );
			add( labelServerURL );
			add( comboServerURL );
			add( labelCluster );
			add( comboCluster );
			add( labelTenant );
			add( textTenant );
			add( labelSecUser );
			add( textSecUser );
			add( labelPassword );
			add( textPassword );
			add( buttonOk );
			add( buttonCancel );
			Dimension sz = new Dimension( 800, 480 );
			setSize( sz );
			int height = doLayoutRetHeight();
			Dimension newSz = new Dimension( 800, height );
			setSize( newSz );
		}

		public void doLayout() {
			doLayoutRetHeight();
		}

		public int doLayoutRetHeight() {
			Dimension sz = getSize();
			final int itemHeight = 25;
			final int itemSpacing = 5;
			final int labelWidth = 150;
			final int buttonHeight = 35;
			final int buttonWidth = 100;
			int y = itemSpacing;
			int fieldWidth = sz.width - ( itemSpacing + labelWidth + itemSpacing + itemSpacing );
			int fieldX = itemSpacing + labelWidth + itemSpacing;
			int buttonSpacing = ( sz.width - ( buttonWidth + buttonWidth ) ) / 3;
			labelServerURL.setBounds( itemSpacing, y, labelWidth, itemHeight );
			comboServerURL.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing;
			labelCluster.setBounds( itemSpacing, y, labelWidth, itemHeight );
			comboCluster.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing;
			labelTenant.setBounds( itemSpacing, y, labelWidth, itemHeight );
			textTenant.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing;
			labelSecUser.setBounds( itemSpacing, y, labelWidth, itemHeight );
			textSecUser.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing;
			labelPassword.setBounds( itemSpacing, y, labelWidth, itemHeight );
			textPassword.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing + itemSpacing;
			buttonOk.setBounds( buttonSpacing, y, buttonWidth, buttonHeight );
			buttonCancel.setBounds( buttonSpacing + buttonWidth + buttonSpacing, y, buttonWidth, buttonHeight );
			y = y + buttonHeight + itemSpacing + itemSpacing;
			return( y );
		}
	}

	protected LoginJPanel loginJPanel = null;

	public CFBamSwingLoginJInternalFrame( ICFBamSwingSchema argSchema ) {
		super();
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		swingSchema = argSchema;
		loginJPanel = new LoginJPanel();
		setContentPane( loginJPanel );
		Dimension dim = new Dimension( 800, 480 );
		setSize( dim );
		int panelHeight = loginJPanel.doLayoutRetHeight();
		// 60 is a fudge factor for the window decorations and menus
		dim = new Dimension( 800, panelHeight + 60 );
		setSize( dim );
		dim = new Dimension( 400, panelHeight + 60);
		setMinimumSize( dim );
		setTitle( "Please log in" );
		setIconifiable( false );
		setMaximizable( false );
		setResizable( true );
		setClosable( false );
		addInternalFrameListener( getLoginInternalFrameListener() );
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}
}
