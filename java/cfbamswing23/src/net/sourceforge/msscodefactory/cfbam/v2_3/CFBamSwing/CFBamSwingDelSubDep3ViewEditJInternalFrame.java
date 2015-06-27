// Description: Java 7 Swing View/Edit JInternalFrame implementation for DelSubDep3.

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

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/**
 *	CFBamSwingDelSubDep3ViewEditJInternalFrame Swing View/Edit JInternalFrame implementation
 *	for DelSubDep3.
 */
public class CFBamSwingDelSubDep3ViewEditJInternalFrame
extends CFJInternalFrame
implements ICFBamSwingDelSubDep3JPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	protected JPanel swingViewEditJPanel = null;
	protected class ActionEdit
	extends AbstractAction
	{
		public ActionEdit() {
			super();
			putValue( Action.NAME, "Edit DelSubDep3" );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			if( getSwingFocusAsDelSubDep3() != null ) {
				if( null == getSwingFocusAsDelSubDep3().getEdit() ) {
					setPanelMode( CFJPanel.PanelMode.Edit );
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
						S_ProcName,
						"Cannot begin an edit of an object already edited by another window instance" );
				}
			}
		}
	}

	protected class ActionSave
	extends AbstractAction
	{
		public ActionSave() {
			super();
			putValue( Action.NAME, "Save and Close" );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamDelSubDep3Obj focus = getSwingFocusAsDelSubDep3();
			if( focus != null ) {
				ICFBamDelSubDep3EditObj editObj = (ICFBamDelSubDep3EditObj)( focus.getEdit() );
				if( editObj != null ) {
					setPanelMode( CFJPanel.PanelMode.Update );
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
						S_ProcName,
						"Cannot save on object that isn't being edited" );
				}
			}
			try {
				setClosed( true );
			}
			catch( Exception x ) {
			}
		}
	}

	protected class ActionDelete
	extends AbstractAction
	{
		public ActionDelete() {
			super();
			putValue( Action.NAME, "Delete DelSubDep3..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			if( getSwingFocusAsDelSubDep3() != null ) {
				if( null == getSwingFocusAsDelSubDep3().getEdit() ) {
					JInternalFrame frame = swingSchema.getDelSubDep3Factory().newAskDeleteJInternalFrame( getSwingFocusAsDelSubDep3() );
					((ICFBamSwingDelSubDep3JPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					getDesktopPane().add( frame );
					frame.setVisible( true );
					frame.show();
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
						S_ProcName,
						"Cannot begin deletion of an object already edited by another window instance" );
				}
			}
		}
	}

	protected class ActionClose
	extends AbstractAction
	{
		public ActionClose() {
			super();
			putValue( Action.NAME, "Close/Cancel" );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			ICFBamDelSubDep3Obj focus = getSwingFocusAsDelSubDep3();
			if( focus != null ) {
				ICFBamDelSubDep3EditObj editObj = (ICFBamDelSubDep3EditObj)focus.getEdit();
				if( editObj != null ) {
					if( editObj.getIsNew() ) {
						editObj.endEdit();
						setSwingFocus( null );
						setPanelMode( CFJPanel.PanelMode.Unknown );
					}
					else {
						editObj.endEdit();
						setPanelMode( CFJPanel.PanelMode.View );
					}
				}
			}
			try {
				setClosed( true );
			}
			catch( Exception x ) {
			}
		}
	}

	protected Action actionEdit = null;
	protected Action actionSave = null;
	protected Action actionDelete = null;
	protected Action actionClose = null;
	protected JMenuBar frameMenuBar = null;
	protected JMenu menuFile = null;

	public CFBamSwingDelSubDep3ViewEditJInternalFrame( ICFBamSwingSchema argSchema, ICFBamDelSubDep3Obj argFocus ) {
		super();
		final String S_ProcName = "construct-schema-focus";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		swingSchema = argSchema;
		swingFocus = argFocus;
		if( ( argFocus != null ) && ( ! argFocus.getIsNew() ) ) {
			argFocus = (ICFBamDelSubDep3Obj)argFocus.read( true );
			swingFocus = argFocus;
		}
		swingViewEditJPanel = argSchema.getDelSubDep3Factory().newViewEditJPanel( argFocus );
		setContentPane( swingViewEditJPanel );
		Dimension dim = new Dimension( 1024, 480 );
		setSize( dim );
		dim = new Dimension( 320, 240 );
		setMinimumSize( dim );
		setTitle( "View/Edit DelSubDep3" );
		setJMenuBar( getFrameMenuBar() );
		setIconifiable( true );
		setMaximizable( true );
		setResizable( true );
		setClosable( false );
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public void setSwingFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setSwingFocus";
		if( ( value == null ) || ( value instanceof ICFBamDelSubDep3Obj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamDelSubDep3Obj" );
		}
		((ICFBamSwingDelSubDep3JPanelCommon)swingViewEditJPanel).setSwingFocus( value );
		ICFBamDelSubDep3Obj argFocus = (ICFBamDelSubDep3Obj)value;
		if( ( argFocus != null ) && ( ! argFocus.getIsNew() ) ) {
			argFocus = (ICFBamDelSubDep3Obj)argFocus.read( true );
			super.setSwingFocus( argFocus );
		}
	}

	public ICFBamDelSubDep3Obj getSwingFocusAsDelSubDep3() {
		return( (ICFBamDelSubDep3Obj)getSwingFocus() );
	}
	
	public void setSwingFocusAsDelSubDep3( ICFBamDelSubDep3Obj value ) {
		setSwingFocus( value );
	}

	public JMenuBar getFrameMenuBar() {
		if( frameMenuBar == null ) {
			JMenuItem menuItem;
			frameMenuBar = new JMenuBar();
				menuFile = new JMenu( "File" );
					actionEdit = new ActionEdit();
					menuItem = new JMenuItem( actionEdit );
					menuFile.add( menuItem );
					actionSave = new ActionSave();
					menuItem = new JMenuItem( actionSave );
					menuFile.add( menuItem );
					actionClose = new ActionClose();
					menuItem = new JMenuItem( actionClose );
					menuFile.add( menuItem );
					actionDelete = new ActionDelete();
					menuItem = new JMenuItem( actionDelete );
					menuFile.add( menuItem );
				frameMenuBar.add( menuFile );
		}
		return( frameMenuBar );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		CFJPanel.PanelMode oldMode = getPanelMode();
		if( oldMode == value ) {
			return;
		}
		super.setPanelMode( value );
		((ICFBamSwingDelSubDep3JPanelCommon)swingViewEditJPanel).setPanelMode( value );
		if( value == CFJPanel.PanelMode.View ) {
			if( actionEdit != null ) {
				actionEdit.setEnabled( true );
			}
			if( actionSave != null ) {
				actionSave.setEnabled( false );
			}
			if( actionDelete != null ) {
				actionDelete.setEnabled( true );
			}
			if( actionClose != null ) {
				actionClose.setEnabled( true );
			}
		}
		else if( value == CFJPanel.PanelMode.Edit ) {
			if( actionEdit != null ) {
				actionEdit.setEnabled( false );
			}
			if( actionSave != null ) {
				actionSave.setEnabled( true );
			}
			if( actionDelete != null ) {
				actionDelete.setEnabled( false );
			}
			if( actionClose != null ) {
				actionClose.setEnabled( true );
			}
		}
		else if( value == CFJPanel.PanelMode.Add ) {
			if( actionEdit != null ) {
				actionEdit.setEnabled( false );
			}
			if( actionSave != null ) {
				actionSave.setEnabled( true );
			}
			if( actionDelete != null ) {
				actionDelete.setEnabled( false );
			}
			if( actionClose != null ) {
				actionClose.setEnabled( true );
			}
		}
		else {
			if( actionEdit != null ) {
				actionEdit.setEnabled( false );
			}
			if( actionSave != null ) {
				actionSave.setEnabled( false );
			}
			if( actionDelete != null ) {
				actionDelete.setEnabled( false );
			}
			if( actionClose != null ) {
				actionClose.setEnabled( true );
			}
		}
	}
}
