// Description: Java 7 Swing FileImport JInternalFrame implementation for CFBam.

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
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.*;

import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;

import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/**
 *	CFBamSwingFileImportJInternalFrame Swing FileImport JInternalFrame implementation
 *	for CFBam.
 */
public class CFBamSwingFileImportJInternalFrame
extends CFJInternalFrame
{
	protected ICFBamSwingSchema swingSchema = null;
	protected class FileImportJPanel extends CFJPanel {

		protected JLabel labelFileName = null;
		protected CFJStringEditor textFileName = null;
		protected JLabel labelLogContents = null;
		protected CFJTextEditor textLogContents = null;
		protected JButton buttonChooseFile = null;
		protected JButton buttonImportFile = null;
		protected JButton buttonClose = null;
		protected JFileChooser fileChooser = null;

		protected class ActionChooseFile 
		extends AbstractAction
		{
			public ActionChooseFile() {
				super();
				putValue( Action.NAME, "Choose File..." );
				setEnabled( true );
			}

			public void actionPerformed( ActionEvent e ) {
				if( fileChooser == null ) {
					fileChooser = new JFileChooser();
				}
				Container cont = getParent();
				while( ( cont != null ) && ( ! ( cont instanceof JDesktopPane ) ) ) {
					cont = cont.getParent();
				}
				int retval = fileChooser.showOpenDialog( cont );
				if( retval == JFileChooser.APPROVE_OPTION ) {
					File chosen = fileChooser.getSelectedFile();
					if( chosen != null ) {
						String path = chosen.getAbsolutePath();
						textFileName.setText( path );
					}
				}
			}
		}

		protected class ActionImportFile 
		extends AbstractAction
		{
			public ActionImportFile() {
				super();
				putValue( Action.NAME, "Import File" );
				setEnabled( true );
			}

			public void actionPerformed( ActionEvent e ) {
				String fileName = textFileName.getText();
				if( ( fileName == null ) || ( fileName.length() <= 0 ) ) {
					JOptionPane.showMessageDialog( null, "File name must be specified", "Error", JOptionPane.ERROR_MESSAGE );
					return;
				}
				File file = new File( fileName );
				if( ! file.exists() ) {
					JOptionPane.showMessageDialog( null, "Could not find file \"" + fileName + "\"", "Error", JOptionPane.ERROR_MESSAGE );
					return;
				}
				if( ! file.isFile() ) {
					JOptionPane.showMessageDialog( null, "Not a file: \"" + fileName + "\"", "Error", JOptionPane.ERROR_MESSAGE );
					return;
				}
				if( ! file.canRead() ) {
					JOptionPane.showMessageDialog( null, "Read permission denied for file \"" + fileName + "\"", "Error", JOptionPane.ERROR_MESSAGE );
					return;
				}
				String fileContents;
				try {
					byte[] rawFileContents = Files.readAllBytes( file.toPath() );
					fileContents = new String( rawFileContents, StandardCharsets.UTF_8 );
				}
				catch( IOException x ) {
					JOptionPane.showMessageDialog( null,  "Error reading from file \"" + fileName + "\"", "Error", JOptionPane.ERROR_MESSAGE );
					return;
				}
				textLogContents.setTextValue( "" );
				// Open the file and read the contents
				String logContents = swingSchema.getSchema().fileImport( fileName, fileContents );
				if( logContents == null ) {
					logContents = "";
				}
				textLogContents.setTextValue( logContents );
			}
		}

		protected class ActionClose
		extends AbstractAction
		{
			public ActionClose() {
				super();
				putValue( Action.NAME, "Close" );
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

		protected Action actionChooseFile = null;
		protected Action actionImportFile = null;
		protected Action actionClose = null;

		public FileImportJPanel() {
			super();
			labelFileName = new JLabel();
			labelFileName.setText( "Server URL" );
			labelFileName = new JLabel();
			labelFileName.setText( "File Name" );
			textFileName = new CFJStringEditor();
			textFileName.setMaxLen( 4096 );
			labelLogContents = new JLabel();
			labelLogContents.setText( "Import Log Contents" );
			textLogContents = new CFJTextEditor();
			textLogContents.setMaxLen( 1000000 );
			actionChooseFile = new ActionChooseFile();
			actionImportFile = new ActionImportFile();
			actionClose = new ActionClose();
			buttonChooseFile = new JButton( actionChooseFile );
			buttonImportFile = new JButton( actionImportFile );
			buttonClose = new JButton( actionClose );
			add( labelFileName );
			add( textFileName );
			add( labelLogContents );
			add( textLogContents );
			add( buttonChooseFile );
			add( buttonImportFile );
			add( buttonClose );
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
			int buttonSpacing = ( sz.width - ( buttonWidth + buttonWidth ) ) / 4;
			labelFileName.setBounds( itemSpacing, y, labelWidth, itemHeight );
			textFileName.setBounds( fieldX, y, fieldWidth, itemHeight );
			y = y + itemHeight + itemSpacing;
			labelLogContents.setBounds( itemSpacing, y, labelWidth, itemHeight );
			int logContentsHeight = sz.height - ( y + buttonHeight + itemSpacing + itemSpacing );
			if( logContentsHeight < 100 ) {
				logContentsHeight = 100;
			}
			textLogContents.setBounds( fieldX, y, fieldWidth, logContentsHeight );
			y = y + logContentsHeight + itemSpacing + itemSpacing;
			buttonChooseFile.setBounds( buttonSpacing, y, buttonWidth, buttonHeight );
			buttonImportFile.setBounds( buttonSpacing + buttonWidth + buttonSpacing, y, buttonWidth, buttonHeight );
			buttonClose.setBounds( buttonSpacing + buttonWidth + buttonSpacing + buttonWidth + buttonSpacing, y, buttonWidth, buttonHeight );
			y = y + buttonHeight + itemSpacing + itemSpacing;
			return( y );
		}
	}

	protected FileImportJPanel fileImportJPanel = null;

	public CFBamSwingFileImportJInternalFrame( ICFBamSwingSchema argSchema ) {
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
		fileImportJPanel = new FileImportJPanel();
		setContentPane( fileImportJPanel );
		Dimension dim = new Dimension( 800, 480 );
		setSize( dim );
		int panelHeight = fileImportJPanel.doLayoutRetHeight();
		// 60 is a fudge factor for the window decorations and menus
		dim = new Dimension( 800, panelHeight + 60 );
		setSize( dim );
		dim = new Dimension( 400, panelHeight + 60);
		setMinimumSize( dim );
		setTitle( "Please choose a file to import" );
		setIconifiable( false );
		setMaximizable( false );
		setResizable( true );
		setClosable( false );
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}
}
