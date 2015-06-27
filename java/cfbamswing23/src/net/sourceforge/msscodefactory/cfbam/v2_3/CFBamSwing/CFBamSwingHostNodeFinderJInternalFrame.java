// Description: Java 7 Swing Finder JInternalFrame implementation for HostNode.

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
import javax.swing.event.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.*;
import net.sourceforge.msscodefactory.cflib.v2_3.CFLib.Swing.*;
import org.apache.commons.codec.binary.Base64;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBam.*;
import net.sourceforge.msscodefactory.cfbam.v2_3.CFBamObj.*;

/**
 *	CFBamSwingHostNodeFinderJInternalFrame Swing Finder JInternalFrame implementation
 *	for HostNode.
 */
public class CFBamSwingHostNodeFinderJInternalFrame
extends CFJInternalFrame
implements ICFBamSwingHostNodeJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	protected JPanel swingFinderJPanel = null;
	protected JMenuBar finderMenuBar = null;
	protected JMenu menuFile = null;
	protected Action actionClose = null;
	protected JMenu menuAdd = null;
	protected ViewEditInternalFrameListener viewEditInternalFrameListener = null;
	protected Action actionAddHostNode = null;
	protected ActionViewSelectedHostNode actionViewSelected = null;
	protected ActionEditSelectedHostNode actionEditSelected = null;
	protected ActionDeleteSelectedHostNode actionDeleteSelected = null;

	protected class ViewEditInternalFrameListener
	implements InternalFrameListener
	{
		public ViewEditInternalFrameListener() {
		}

		public void internalFrameActivated( InternalFrameEvent e ) {
		}

		public void internalFrameClosed( InternalFrameEvent e ) {
			((ICFJRefreshCallback)swingFinderJPanel).refreshMe();
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
			try {
				setClosed( true );
			}
			catch( Exception x ) {
			}
		}
	}

	protected class ActionViewSelectedHostNode
	extends AbstractAction
	{
		public ActionViewSelectedHostNode() {
			super();
			putValue( Action.NAME, "View Selected..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			if( schemaObj == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"schemaObj" );
			}
			ICFBamHostNodeObj selectedInstance = getSwingFocusAsHostNode();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "HSND".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getHostNodeFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingHostNodeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					getDesktopPane().add( frame );
					frame.setVisible( true );
					frame.show();
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
						S_ProcName,
						"selectedInstance",
						selectedInstance,
						"ICFBamHostNodeObj" );
				}
			}
		}
	}

	protected class ActionEditSelectedHostNode
	extends AbstractAction
	{
		public ActionEditSelectedHostNode() {
			super();
			putValue( Action.NAME, "Edit Selected..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			if( schemaObj == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"schemaObj" );
			}
			ICFBamHostNodeObj selectedInstance = getSwingFocusAsHostNode();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "HSND".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getHostNodeFactory().newViewEditJInternalFrame( selectedInstance );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					((ICFBamSwingHostNodeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.Edit );
					getDesktopPane().add( frame );
					frame.setVisible( true );
					frame.show();
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
						S_ProcName,
						"selectedInstance",
						selectedInstance,
						"ICFBamHostNodeObj" );
				}
			}
		}
	}

	protected class ActionDeleteSelectedHostNode
	extends AbstractAction
	{
		public ActionDeleteSelectedHostNode() {
			super();
			putValue( Action.NAME, "Delete Selected..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			if( schemaObj == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"schemaObj" );
			}
			ICFBamHostNodeObj selectedInstance = getSwingFocusAsHostNode();
			if( selectedInstance != null ) {
				String classCode = selectedInstance.getClassCode();
				if( "HSND".equals( classCode ) ) {
					JInternalFrame frame = swingSchema.getHostNodeFactory().newAskDeleteJInternalFrame( selectedInstance );
					((ICFBamSwingHostNodeJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
					frame.addInternalFrameListener( getViewEditInternalFrameListener() );
					getDesktopPane().add( frame );
					frame.setVisible( true );
					frame.show();
				}
				else {
					throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
						S_ProcName,
						"selectedInstance",
						selectedInstance,
						"ICFBamHostNodeObj" );
				}
			}
		}
	}

	protected class ActionAddHostNode
	extends AbstractAction
	{
		public ActionAddHostNode() {
			super();
			putValue( Action.NAME, "Add Host Node..." );
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			if( schemaObj == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"schemaObj" );
			}
			ICFBamHostNodeObj obj = schemaObj.getHostNodeTableObj().newInstance();
			ICFBamHostNodeEditObj edit = (ICFBamHostNodeEditObj)( obj.beginEdit() );
			if( edit == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"edit" );
			}
		ICFBamClusterObj secCluster = schemaObj.getSecCluster();
		edit.setRequiredContainerCluster( secCluster );
			JInternalFrame frame = swingSchema.getHostNodeFactory().newViewEditJInternalFrame( obj );
			frame.addInternalFrameListener( getViewEditInternalFrameListener() );
			ICFBamSwingHostNodeJPanelCommon jpanelCommon = (ICFBamSwingHostNodeJPanelCommon)frame;
			jpanelCommon.setPanelMode( CFJPanel.PanelMode.Add );
			getDesktopPane().add( frame );
			frame.setVisible( true );
			frame.show();
		}
	}

	public CFBamSwingHostNodeFinderJInternalFrame( ICFBamSwingSchema argSchema ) {
		super();
		final String S_ProcName = "construct-schema-focus";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		swingSchema = argSchema;
		swingFinderJPanel = argSchema.getHostNodeFactory().newFinderJPanel();
		setContentPane( swingFinderJPanel );
		Dimension dim = new Dimension( 1024, 480 );
		setSize( dim );
		dim = new Dimension( 320, 240 );
		setMinimumSize( dim );
		setTitle( "Find Host Node" );
		setJMenuBar( getFinderMenuBar() );
		setIconifiable( true );
		setMaximizable( true );
		setResizable( true );
		setClosable( false );
		adjustFinderMenuBar();
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public JMenuBar getFinderMenuBar() {
		if( finderMenuBar == null ) {
			JMenuItem menuItem;
			finderMenuBar = new JMenuBar();
				menuFile = new JMenu( "File" );
					actionAddHostNode = new ActionAddHostNode();
					menuItem = new JMenuItem( actionAddHostNode );
					menuFile.add( menuItem );
				actionViewSelected = new ActionViewSelectedHostNode();
				menuItem = new JMenuItem( actionViewSelected );
				menuFile.add( menuItem );
				actionEditSelected = new ActionEditSelectedHostNode();
				menuItem = new JMenuItem( actionEditSelected );
				menuFile.add( menuItem );
				actionDeleteSelected = new ActionDeleteSelectedHostNode();
				menuItem = new JMenuItem( actionDeleteSelected );
				menuFile.add( menuItem );
				actionClose = new ActionClose();
				menuItem = new JMenuItem( actionClose );
				menuFile.add( menuItem );
				finderMenuBar.add( menuFile );
		}
		return( finderMenuBar );
	}

	public void setSwingFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setSwingFocus";
		if( ( value == null ) || ( value instanceof ICFBamHostNodeObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamHostNodeObj" );
		}
		adjustFinderMenuBar();
	}

	public ICFBamHostNodeObj getSwingFocusAsHostNode() {
		return( (ICFBamHostNodeObj)getSwingFocus() );
	}

	public void setSwingFocusAsHostNode( ICFBamHostNodeObj value ) {
		setSwingFocus( value );
	}

	public void adjustFinderMenuBar() {
		JMenuItem menuItem;
		Action act;
		String itemLabel;
		ICFBamHostNodeObj selectedObj = getSwingFocusAsHostNode();
		boolean enableState;
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			enableState = true;
		}

		if( actionViewSelected != null ) {
			actionViewSelected.setEnabled( enableState );
		}
		if( actionEditSelected != null ) {
			actionEditSelected.setEnabled( enableState );
		}
		if( actionDeleteSelected != null ) {
			actionDeleteSelected.setEnabled( enableState );
		}
		if( actionAddHostNode != null ) {
			actionAddHostNode.setEnabled( true );
		}

		if( menuFile != null ) {
			int itemCount = menuFile.getItemCount();
			for( int itemIdx = 0; itemIdx < itemCount; itemIdx ++ ) {
				menuItem = menuFile.getItem( itemIdx );
				act = menuItem.getAction();
				if( act != null ) {
					if( act == actionViewSelected ) {
						menuItem.setEnabled( enableState );
					}
					else if( act == actionEditSelected ) {
						menuItem.setEnabled( enableState );
					}
					else if( act == actionDeleteSelected ) {
						menuItem.setEnabled( enableState );
					}
					else if( act == actionAddHostNode ) {
						menuItem.setEnabled( true );
					}
				}
			}
		}
	}

	protected ViewEditInternalFrameListener getViewEditInternalFrameListener() {
		if( viewEditInternalFrameListener == null ) {
			viewEditInternalFrameListener = new ViewEditInternalFrameListener();
		}
		return( viewEditInternalFrameListener );
	}
}
