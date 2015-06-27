// Description: Java 7 Swing DisplayPublicKey JInternalFrame implementation for CFBam.

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

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.awt.*;
import java.awt.event.*;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;

import org.apache.commons.codec.binary.Base64;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Tip.CFTipClientHandler;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamXMsgClient.CFBamXMsgClientHttpSchema;

/**
 *	CFBamSwingDisplayPublicKeyJInternalFrame Swing DisplayPublicKey JInternalFrame implementation
 *	for CFBam.
 */
public class CFBamSwingDisplayPublicKeyJInternalFrame
extends CFJInternalFrame
{
	protected ICFBamSwingSchema swingSchema = null;
	protected class DisplayPublicKeyJPanel extends CFJPanel {
		protected JLabel labelDeviceName = null;
		protected CFJStringEditor textDeviceName = null;
		protected JLabel labelDevicePublicKey = null;
		protected CFJTextEditor textDevicePublicKey = null;
		protected JButton buttonOk = null;

		protected class ActionOk 
		extends AbstractAction
		{
			public ActionOk() {
				super();
				putValue( Action.NAME, "Ok" );
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

		public DisplayPublicKeyJPanel() {
			super();
			final String S_ProcName = "DisplayPublicKeyJPanel-ConstructDefault";
			labelDeviceName = new JLabel();
			labelDeviceName.setText( "Keystore Name" );
			textDeviceName = new CFJStringEditor();
			textDeviceName.setEditable( false );
			textDeviceName.setEnabled( true );
			textDeviceName.setMaxLen( 127 );
			CFBamClientConfigurationFile configFile = swingSchema.getClientConfigurationFile();
			String deviceName = configFile.getDeviceName();
			textDeviceName.setText( deviceName );
			labelDevicePublicKey = new JLabel();
			labelDevicePublicKey.setText( "Public Key");
			textDevicePublicKey = new CFJTextEditor();
			textDevicePublicKey.setMaxLen( 4096 );
			textDevicePublicKey.setEnabled( true );
			CFBamXMsgClientHttpSchema xmsgClientSchema = (CFBamXMsgClientHttpSchema)( swingSchema.getSchema().getBackingStore() );
			CFTipClientHandler clientHandler = xmsgClientSchema.getCFTipClientHandler();
			byte[] encodedPublicKey;
			try {
				encodedPublicKey = clientHandler.getEncodedDevicePublicKey();
			}
			catch ( InvalidKeyException
				| NoSuchAlgorithmException
				| NoSuchPaddingException
				| IllegalBlockSizeException e )
			{
				throw CFLib.getDefaultExceptionFactory().newRuntimeException( getClass(),
					S_ProcName,
					"Caught " + e.getClass().getName() + " -- " + e.getMessage(),
					e );
			}
			byte[] base64 = Base64.encodeBase64( encodedPublicKey );
			String base64Encoded = new String( base64 );
			textDevicePublicKey.setTextValue( base64Encoded );
			actionOk = new ActionOk();
			buttonOk = new JButton( actionOk );
			add( labelDeviceName );
			add( textDeviceName );
			add( labelDevicePublicKey );
			add( textDevicePublicKey );
			add( buttonOk );
			Dimension sz = new Dimension( 800, 600 );
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
			final int publicKeyHeight = 400;
			final int buttonHeight = 35;
			final int buttonWidth = 100;
			int y = itemSpacing;
			int fieldWidth = sz.width - ( itemSpacing + labelWidth + itemSpacing + itemSpacing );
			int fieldX = itemSpacing + labelWidth + itemSpacing;
			int buttonSpacing = ( sz.width - ( buttonWidth + buttonWidth ) ) / 2;
			labelDeviceName.setBounds( itemSpacing, y, labelWidth, itemHeight );
			textDeviceName.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing;
			labelDevicePublicKey.setBounds( itemSpacing, y, labelWidth, itemHeight );
			textDevicePublicKey.setBounds( fieldX, y, fieldWidth, publicKeyHeight );
			y = y + itemHeight + itemSpacing + publicKeyHeight;
			buttonOk.setBounds( buttonSpacing, y, buttonWidth, buttonHeight );
			y = y + buttonHeight + itemSpacing + itemSpacing;
			return( y );
		}
}
	protected DisplayPublicKeyJPanel DisplayPublicKeyJPanel = null;

	public CFBamSwingDisplayPublicKeyJInternalFrame( ICFBamSwingSchema argSchema ) {
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
		DisplayPublicKeyJPanel = new DisplayPublicKeyJPanel();
		setContentPane( DisplayPublicKeyJPanel );
		Dimension dim = new Dimension( 800, 480 );
		setSize( dim );
		int panelHeight = DisplayPublicKeyJPanel.doLayoutRetHeight();
		// 60 is a fudge factor for the window decorations and menus
		dim = new Dimension( 800, panelHeight + 60 );
		setSize( dim );
		dim = new Dimension( 400, panelHeight + 60);
		setMinimumSize( dim );
		CFBamClientConfigurationFile configFile = swingSchema.getClientConfigurationFile();
		String deviceName = configFile.getDeviceName();
		setTitle( "Public key information for " + deviceName );
		setIconifiable( false );
		setMaximizable( false );
		setResizable( true );
		setClosable( false );
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}
}
