// Description: Java 7 Swing OpenDeviceKey JInternalFrame implementation for CFBam.

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

import java.security.*;
import java.security.cert.Certificate;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Tip.CFTipClientHandler;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgClient.CFBamXMsgClientHttpSchema;

/**
 *	CFBamSwingOpenDeviceKeyJInternalFrame Swing OpenDeviceKey JInternalFrame implementation
 *	for CFBam.
 */
public class CFBamSwingOpenDeviceKeyJInternalFrame
extends CFJInternalFrame
{
	protected CFBamSwingOpenDeviceKeyJInternalFrame myFrame = null;
	protected ICFBamSwingSchema swingSchema = null;
	protected class OpenDeviceKeyJPanel extends CFJPanel {

		protected JLabel labelDeviceName = null;
		protected CFJStringEditor textDeviceName = null;
		protected JLabel labelDeviceKeyPassword = null;
		protected JPasswordField textDeviceKeyPassword = null;
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
				char pw[] = textDeviceKeyPassword.getPassword();
				KeyStore keyStore = swingSchema.getKeyStore();
				if( keyStore == null ) {
					throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
						S_ProcName,
						0,
						"swingSchema.KeyStore" );
				}
				String deviceName = swingSchema.getClientConfigurationFile().getDeviceName();
				Certificate publicKeyCertificate;
				PublicKey publicDeviceKey;
				try {
					publicKeyCertificate = keyStore.getCertificate( deviceName );
				}
				catch( KeyStoreException x ) {
					publicKeyCertificate = null;
				}
				if( publicKeyCertificate == null ) {
					CFBamXMsgClientHttpSchema xmsgClientSchema = (CFBamXMsgClientHttpSchema)( swingSchema.getSchema().getBackingStore() );
					CFTipClientHandler clientHandler = xmsgClientSchema.getCFTipClientHandler();
					clientHandler.setDeviceName( null );
					clientHandler.setDevicePrivateKey( null );
					clientHandler.setDevicePublicKey( null );
					CFBamClientConfigurationFile configFile = swingSchema.getClientConfigurationFile();
					String keystoreFileName = configFile.getKeyStore();
					JOptionPane.showMessageDialog( null,
						"You need to use the Java keytool to create an RSA 2048 bit key pair for the device \"" + deviceName + "\".\n"
							+ "For example, to create a self-signed certificate:\n\n"
							+ "    keytool -genkeypair -keystore " + keystoreFileName + " -storepass pw -keyalg RSA -keysize 2048 -alias " + deviceName + " -validity 2000 -storetype jceks\n\n"
							+ "The application will now exit.",
						"Error",
						JOptionPane.ERROR_MESSAGE,
						null );
					swingSchema.setKeyStore( null );
					mainJFrame.exitApplication();
				}
				else {
					publicDeviceKey = publicKeyCertificate.getPublicKey();
					PrivateKey privateDeviceKey;
					try {
						Key key = keyStore.getKey( deviceName, pw );
						if( key instanceof PrivateKey ) {
							privateDeviceKey = (PrivateKey)key;
						}
						else {
							throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
								S_ProcName,
								"key",
								key,
								"PrivateKey" );
						}
					}
					catch( KeyStoreException x ) {
						privateDeviceKey = null;
						JOptionPane.showMessageDialog( null,
							"Could not open private device key due to KeyStoreException -- " + x.getMessage(),
							"Error",
							JOptionPane.ERROR_MESSAGE,
							null );
					}
					catch(UnrecoverableKeyException x ) {
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Caught UnrecoverableKeyException -- " + x.getMessage(),
							x );
					}
					catch(NoSuchAlgorithmException x ) {
						throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
							S_ProcName,
							"Caught NoSuchAlgorithmException -- " + x.getMessage(),
							x );
					}
					if( privateDeviceKey != null ) {
						CFBamXMsgClientHttpSchema xmsgClientSchema = (CFBamXMsgClientHttpSchema)( swingSchema.getSchema().getBackingStore() );
						CFTipClientHandler clientHandler = xmsgClientSchema.getCFTipClientHandler();
						clientHandler.setDeviceName( deviceName );
						clientHandler.setDevicePrivateKey( privateDeviceKey );
						clientHandler.setDevicePublicKey( publicDeviceKey );
						JInternalFrame nextForm = swingSchema.newDisplayPublicKeyJInternalFrame();
						getDesktopPane().add( nextForm );
						nextForm.setVisible( true );
						nextForm.show();
						try {
							myFrame.setClosed( true );
						}
						catch( PropertyVetoException x ) {
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
					CFBamXMsgClientHttpSchema xmsgClientSchema = (CFBamXMsgClientHttpSchema)( swingSchema.getSchema().getBackingStore() );
					CFTipClientHandler clientHandler = xmsgClientSchema.getCFTipClientHandler();
					clientHandler.setDeviceName( null );
					clientHandler.setDevicePrivateKey( null );
					clientHandler.setDevicePublicKey( null );
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

		public OpenDeviceKeyJPanel() {
			super();
			labelDeviceName = new JLabel();
			labelDeviceName.setText( "Device Name" );
			textDeviceName = new CFJStringEditor();
			textDeviceName.setEditable( false );
			textDeviceName.setEnabled( false );
			textDeviceName.setMaxLen( 127 );
			CFBamClientConfigurationFile configFile = swingSchema.getClientConfigurationFile();
			String deviceName = configFile.getDeviceName();
			textDeviceName.setText( deviceName );
			labelDeviceKeyPassword = new JLabel();
			labelDeviceKeyPassword.setText( "Device Key Password" );
			textDeviceKeyPassword = new JPasswordField();
			actionOk = new ActionOk();
			actionCancel = new ActionCancel();
			buttonOk = new JButton( actionOk );
			buttonCancel = new JButton( actionCancel );
			add( labelDeviceName );
			add( textDeviceName );
			add( labelDeviceKeyPassword );
			add( textDeviceKeyPassword );
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
			labelDeviceName.setBounds( itemSpacing, y, labelWidth, itemHeight );
			textDeviceName.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing;
			labelDeviceKeyPassword.setBounds( itemSpacing, y, labelWidth, itemHeight );
			textDeviceKeyPassword.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing + itemSpacing;
			buttonOk.setBounds( buttonSpacing, y, buttonWidth, buttonHeight );
			buttonCancel.setBounds( buttonSpacing + buttonWidth + buttonSpacing, y, buttonWidth, buttonHeight );
			y = y + buttonHeight + itemSpacing + itemSpacing;
			return( y );
		}

	}

	protected OpenDeviceKeyJPanel OpenDeviceKeyJPanel = null;

	public CFBamSwingOpenDeviceKeyJInternalFrame( ICFBamSwingSchema argSchema ) {
		super();
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		myFrame = this;
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		swingSchema = argSchema;
		OpenDeviceKeyJPanel = new OpenDeviceKeyJPanel();
		setContentPane( OpenDeviceKeyJPanel );
		Dimension dim = new Dimension( 800, 480 );
		setSize( dim );
		int panelHeight = OpenDeviceKeyJPanel.doLayoutRetHeight();
		// 60 is a fudge factor for the window decorations and menus
		dim = new Dimension( 800, panelHeight + 60 );
		setSize( dim );
		dim = new Dimension( 400, panelHeight + 60);
		setMinimumSize( dim );
		setTitle( "Please open the device key" );
		setIconifiable( false );
		setMaximizable( false );
		setResizable( true );
		setClosable( false );
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}
}
