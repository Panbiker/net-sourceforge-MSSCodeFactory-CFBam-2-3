// Description: Java 7 Swing OpenKeystore JInternalFrame implementation for CFBam.

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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;

/**
 *	CFBamSwingOpenKeystoreJInternalFrame Swing OpenKeystore JInternalFrame implementation
 *	for CFBam.
 */
public class CFBamSwingOpenKeystoreJInternalFrame
extends CFJInternalFrame
{
	protected ICFBamSwingSchema swingSchema = null;
	protected class OpenKeystoreJPanel extends CFJPanel {

		protected JLabel labelKeystoreName = null;
		protected CFJStringEditor textKeystoreName = null;
		protected JLabel labelKeystorePassword = null;
		protected JPasswordField textKeystorePassword = null;
		protected JButton buttonOk = null;
		protected JButton buttonCancel = null;

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
				CFBamSwingMainJFrame mainJFrame = null;
				{
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof CFBamSwingMainJFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						mainJFrame = (CFBamSwingMainJFrame)cont;
					}
				}
				char pw[] = textKeystorePassword.getPassword();
				String keystorePassword;
				if( pw != null ) {
					keystorePassword = new String( pw );
				}
				else {
					keystorePassword = null;
				}
				CFBamClientConfigurationFile configFile = swingSchema.getClientConfigurationFile();
				String keystoreFileName = configFile.getKeyStore();
				boolean exitApp = false;
				boolean exitForm = false;
				boolean creatingKeystore = false;
				KeyStore keyStore = null;
				File keystoreFile = new File( keystoreFileName );
				if( ! keystoreFile.exists() ) {
					int userOption = JOptionPane.NO_OPTION;
					try {
						userOption = JOptionPane.showOptionDialog( null,
							"Would you like to create the keystore \"" + keystoreFileName + "\"?\n"
								+ "Selecting No will exit the application so you can edit the client configuration file and restart.",
							"Create Keystore?",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							null,
							null );
					}
					catch( HeadlessException x ) {
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Caught HeadlessException -- " + x.getMessage(),
							x );
					}
					if( userOption == JOptionPane.YES_OPTION ) {
						creatingKeystore = true;
						JInternalFrame nextForm = swingSchema.newCreateKeystoreJInternalFrame();
						getDesktopPane().add( nextForm );
						nextForm.setVisible( true );
						nextForm.show();
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
					else {
						exitApp = true;
					}
				}
				else if( ! keystoreFile.isFile() ) {
					JOptionPane.showMessageDialog( null,
						"The referenced JCEKS keystore \"" + keystoreFileName + "\" is not a file.",
						"Error",
						JOptionPane.ERROR_MESSAGE,
						null );
					exitApp = true;
				}
				else if( ! keystoreFile.canRead() ) {
					JOptionPane.showMessageDialog( null,
						"Permission denied attempting to access JCEKS keystore \"" + keystoreFileName + "\".",
						"Error",
						JOptionPane.ERROR_MESSAGE,
						null );
					exitApp = true;
				}
				if( ( ! exitApp ) && ( ! creatingKeystore ) ) {
					try {
						keyStore = KeyStore.getInstance( "jceks" );
						char[] caPassword = keystorePassword.toCharArray();
						FileInputStream input = new FileInputStream( keystoreFileName );
						keyStore.load( input, caPassword );
						input.close();
						swingSchema.setKeyStore( keyStore );
						exitForm = true;
					}
					catch( CertificateException x ) {
						keyStore = null;
						JOptionPane.showMessageDialog( null,
							"Could not open keystore due to CertificateException -- " + x.getMessage(),
							"Error",
							JOptionPane.ERROR_MESSAGE,
							null );
						exitApp = true;
					}
					catch( IOException x ) {
						keyStore = null;
						JOptionPane.showMessageDialog( null,
							"Could not open keystore due to IOException -- " + x.getMessage(),
							"Error",
							JOptionPane.ERROR_MESSAGE,
							null );
					}
					catch( KeyStoreException x ) {
						keyStore = null;
						JOptionPane.showMessageDialog( null,
							"Could not open keystore due to KeyStoreException -- " + x.getMessage(),
							"Error",
							JOptionPane.ERROR_MESSAGE,
							null );
						exitApp = true;
					}
					catch( NoSuchAlgorithmException x ) {
						keyStore = null;
						JOptionPane.showMessageDialog( null,
							"Could not open keystore due to NoSuchAlgorithmException -- " + x.getMessage(),
							"Error",
							JOptionPane.ERROR_MESSAGE,
							null );
						exitApp = true;
					}
				}
				if( exitApp ) {
					swingSchema.setKeyStore( null );
					mainJFrame.exitApplication();
				}
				else if( exitForm ) {
					JInternalFrame nextForm = swingSchema.newOpenDeviceKeyJInternalFrame();
					getDesktopPane().add( nextForm );
					nextForm.setVisible( true );
					nextForm.show();
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
				swingSchema.setKeyStore( null );
				CFBamSwingMainJFrame mainJFrame = null;
				{
					Container cont = getParent();
					while( ( cont != null ) && ( ! ( cont instanceof CFBamSwingMainJFrame ) ) ) {
						cont = cont.getParent();
					}
					if( cont != null ) {
						mainJFrame = (CFBamSwingMainJFrame)cont;
						mainJFrame.exitApplication();
					}
				}
			}
		}

		protected Action actionOk = null;
		protected Action actionCancel = null;

		public OpenKeystoreJPanel() {
			super();
			labelKeystoreName = new JLabel();
			labelKeystoreName.setText( "Keystore File" );
			textKeystoreName = new CFJStringEditor();
			textKeystoreName.setEditable( false );
			textKeystoreName.setEnabled( false );
			textKeystoreName.setMaxLen( 4096 );
			CFBamClientConfigurationFile configFile = swingSchema.getClientConfigurationFile();
			String keystoreFileName = configFile.getKeyStore();
			textKeystoreName.setText( keystoreFileName );
			labelKeystorePassword = new JLabel();
			labelKeystorePassword.setText( "Keystore Password" );
			textKeystorePassword = new JPasswordField();
			actionOk = new ActionOk();
			actionCancel = new ActionCancel();
			buttonOk = new JButton( actionOk );
			buttonCancel = new JButton( actionCancel );
			add( labelKeystoreName );
			add( textKeystoreName );
			add( labelKeystorePassword );
			add( textKeystorePassword );
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
			labelKeystoreName.setBounds( itemSpacing, y, labelWidth, itemHeight );
			textKeystoreName.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing;
			labelKeystorePassword.setBounds( itemSpacing, y, labelWidth, itemHeight );
			textKeystorePassword.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing + itemSpacing;
			buttonOk.setBounds( buttonSpacing, y, buttonWidth, buttonHeight );
			buttonCancel.setBounds( buttonSpacing + buttonWidth + buttonSpacing, y, buttonWidth, buttonHeight );
			y = y + buttonHeight + itemSpacing + itemSpacing;
			return( y );
		}

	}

	protected OpenKeystoreJPanel OpenKeystoreJPanel = null;

	public CFBamSwingOpenKeystoreJInternalFrame( ICFBamSwingSchema argSchema ) {
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
		OpenKeystoreJPanel = new OpenKeystoreJPanel();
		setContentPane( OpenKeystoreJPanel );
		Dimension dim = new Dimension( 800, 480 );
		setSize( dim );
		int panelHeight = OpenKeystoreJPanel.doLayoutRetHeight();
		// 60 is a fudge factor for the window decorations and menus
		dim = new Dimension( 800, panelHeight + 60 );
		setSize( dim );
		dim = new Dimension( 400, panelHeight + 60);
		setMinimumSize( dim );
		setTitle( "Please open the JCEKS keystore" );
		setIconifiable( false );
		setMaximizable( false );
		setResizable( true );
		setClosable( false );
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}
}
