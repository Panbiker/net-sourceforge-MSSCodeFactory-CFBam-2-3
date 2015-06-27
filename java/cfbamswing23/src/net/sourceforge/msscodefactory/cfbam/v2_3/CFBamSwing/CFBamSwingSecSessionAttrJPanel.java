// Description: Java 7 Swing Attribute JPanel implementation for SecSession.

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
 *	CFBamSwingSecSessionAttrJPanel Swing Attribute JPanel implementation
 *	for SecSession.
 */
public class CFBamSwingSecSessionAttrJPanel
extends CFJPanel
implements ICFBamSwingSecSessionJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class SecSessionUserJLabel
		extends JLabel
	{
		public SecSessionUserJLabel() {
			super();
			setText( "Security User" );
		}
	}

	protected class CallbackSecSessionUserChosen
	implements ICFBamSwingSecUserChosen
	{
		public CallbackSecSessionUserChosen() {
		}

		public void choseSecUser( ICFBamSecUserObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerSecUser != null ) {
						ICFBamSecSessionObj cur = getSwingFocusAsSecSession();
						if( cur != null ) {
							ICFBamSecSessionEditObj editObj = (ICFBamSecSessionEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerSecUser.setReferencedObject( value );
									editObj.setRequiredContainerSecUser( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewSecSessionUserReference
	extends AbstractAction
	{
		public ActionViewSecSessionUserReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSecSessionObj focus = getSwingFocusAsSecSession();
			if( focus != null ) {
				ICFBamSecSessionEditObj editObj  = (ICFBamSecSessionEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamSecUserObj referencedObj = focus.getRequiredContainerSecUser( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SUSR".equals( classCode ) ) {
						frame = swingSchema.getSecUserFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
							cont = cont.getParent();
						}
						if( cont != null ) {
							JInternalFrame myInternalFrame = (JInternalFrame)cont;
							myInternalFrame.getDesktopPane().add( frame );
							frame.setVisible( true );
							frame.show();
						}
					}
					else {
						throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
							S_ProcName,
							"swingFocus",
							focus,
							"ICFBamSecUserObj" );
					}
				}
			}
		}
	}

	protected class ActionPickSecSessionUserReference
	extends AbstractAction
	{
		public ActionPickSecSessionUserReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSecSessionObj focus = getSwingFocusAsSecSession();
			ICFBamSecSessionEditObj editObj  = (ICFBamSecSessionEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamSecUserObj referencedObj = focus.getRequiredContainerSecUser( swingIsInitializing );
			java.util.List<ICFBamSecUserObj> listOfSecUser = null;
			listOfSecUser = schemaObj.getSecUserTableObj().readAllSecUser();
			if( listOfSecUser == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfSecUser" );
			}
			Collection<ICFBamSecUserObj> cltn = listOfSecUser;
			JInternalFrame frame = swingSchema.getSecUserFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSecSessionUserChosen() );
			((ICFBamSwingSecUserJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				JInternalFrame myInternalFrame = (JInternalFrame)cont;
				myInternalFrame.getDesktopPane().add( frame );
				frame.setVisible( true );
				frame.show();
			}
		}
	}

	protected class SecSessionUserCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SecSessionUserCFJReferenceEditor() {
			super( new ActionPickSecSessionUserReference(), new ActionViewSecSessionUserReference() );
		}
	}

	protected class SecSessionProxyJLabel
		extends JLabel
	{
		public SecSessionProxyJLabel() {
			super();
			setText( "Security Proxy User" );
		}
	}

	protected class CallbackSecSessionProxyChosen
	implements ICFBamSwingSecUserChosen
	{
		public CallbackSecSessionProxyChosen() {
		}

		public void choseSecUser( ICFBamSecUserObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceParentSecProxy != null ) {
						ICFBamSecSessionObj cur = getSwingFocusAsSecSession();
						if( cur != null ) {
							ICFBamSecSessionEditObj editObj = (ICFBamSecSessionEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceParentSecProxy.setReferencedObject( value );
									editObj.setRequiredParentSecProxy( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewSecSessionProxyReference
	extends AbstractAction
	{
		public ActionViewSecSessionProxyReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSecSessionObj focus = getSwingFocusAsSecSession();
			if( focus != null ) {
				ICFBamSecSessionEditObj editObj  = (ICFBamSecSessionEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamSecUserObj referencedObj = focus.getRequiredParentSecProxy( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SUSR".equals( classCode ) ) {
						frame = swingSchema.getSecUserFactory().newViewEditJInternalFrame( referencedObj );
						cont = getParent();
						while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
							cont = cont.getParent();
						}
						if( cont != null ) {
							JInternalFrame myInternalFrame = (JInternalFrame)cont;
							myInternalFrame.getDesktopPane().add( frame );
							frame.setVisible( true );
							frame.show();
						}
					}
					else {
						throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
							S_ProcName,
							"swingFocus",
							focus,
							"ICFBamSecUserObj" );
					}
				}
			}
		}
	}

	protected class ActionPickSecSessionProxyReference
	extends AbstractAction
	{
		public ActionPickSecSessionProxyReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSecSessionObj focus = getSwingFocusAsSecSession();
			ICFBamSecSessionEditObj editObj  = (ICFBamSecSessionEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamSecUserObj referencedObj = focus.getRequiredParentSecProxy( swingIsInitializing );
			java.util.List<ICFBamSecUserObj> listOfSecUser = null;
			listOfSecUser = schemaObj.getSecUserTableObj().readAllSecUser();
			if( listOfSecUser == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfSecUser" );
			}
			Collection<ICFBamSecUserObj> cltn = listOfSecUser;
			JInternalFrame frame = swingSchema.getSecUserFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSecSessionProxyChosen() );
			((ICFBamSwingSecUserJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
			cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				JInternalFrame myInternalFrame = (JInternalFrame)cont;
				myInternalFrame.getDesktopPane().add( frame );
				frame.setVisible( true );
				frame.show();
			}
		}
	}

	protected class SecSessionProxyCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SecSessionProxyCFJReferenceEditor() {
			super( new ActionPickSecSessionProxyReference(), new ActionViewSecSessionProxyReference() );
		}
	}

	protected class SecSessionIdJLabel
		extends JLabel
	{
		public SecSessionIdJLabel() {
			super();
			setText( "Security Session Id" );
		}
	}

	protected class SecSessionIdJEditor
		extends CFJUuidEditor
	{
		public SecSessionIdJEditor() {
			super();
		}
	}

	protected class SecDevNameJLabel
		extends JLabel
	{
		public SecDevNameJLabel() {
			super();
			setText( "Sesion Device Name" );
		}
	}

	protected class SecDevNameJEditor
		extends CFJStringEditor
	{
		public SecDevNameJEditor() {
			super();
			setMaxLen( 127 );
		}
	}

	protected class StartJLabel
		extends JLabel
	{
		public StartJLabel() {
			super();
			setText( "Start" );
		}
	}

	protected class StartJEditor
		extends CFJTimestampEditor
	{
		public StartJEditor() {
			super();
		}
	}

	protected class FinishJLabel
		extends JLabel
	{
		public FinishJLabel() {
			super();
			setText( "Finish" );
		}
	}

	protected class FinishJEditor
		extends CFJTimestampEditor
	{
		public FinishJEditor() {
			super();
		}
	}

	protected ICFBamSecUserObj swingContainerSecUserObj = null;
	protected SecSessionUserJLabel swingLabelContainerSecUser = null;
	protected SecSessionUserCFJReferenceEditor swingReferenceContainerSecUser = null;
	protected ICFBamSecUserObj swingParentSecProxyObj = null;
	protected SecSessionProxyJLabel swingLabelParentSecProxy = null;
	protected SecSessionProxyCFJReferenceEditor swingReferenceParentSecProxy = null;
	protected SecSessionIdJLabel swingLabelSecSessionId = null;
	protected SecSessionIdJEditor swingEditorSecSessionId = null;
	protected SecDevNameJLabel swingLabelSecDevName = null;
	protected SecDevNameJEditor swingEditorSecDevName = null;
	protected StartJLabel swingLabelStart = null;
	protected StartJEditor swingEditorStart = null;
	protected FinishJLabel swingLabelFinish = null;
	protected FinishJEditor swingEditorFinish = null;

	public CFBamSwingSecSessionAttrJPanel( ICFBamSwingSchema argSchema, ICFBamSecSessionObj argFocus ) {
		super();
		JLabel label;
		JComponent compo;
		CFJReferenceEditor reference;
		final String S_ProcName = "construct-schema-focus";
		if( argSchema == null ) {
			throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		swingSchema = argSchema;
		setSwingFocusAsSecSession( argFocus );
		final int spacing = 5;
		int y = spacing;
		final int height = 25;
		final int textheight = 80;
		final int vspacing = height + spacing;
		final int textvspacing = textheight + spacing;
		final int labelx = spacing;
		final int labelwidth = 200;
		final int fieldx = labelx + labelwidth + spacing;
		final int fieldwidth = 785;
		final int panelwidth = fieldx + fieldwidth + spacing;
		// temporary -- I think you have to have a panel bigger than the coordinates initially
		setSize( panelwidth, 100000 );

		label = getSwingLabelContainerSecUser();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerSecUser();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelParentSecProxy();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceParentSecProxy();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelSecSessionId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSecSessionId();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelSecDevName();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSecDevName();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelStart();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorStart();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelFinish();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorFinish();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		// Now we can set the proper size based on the fields and references populated
		setSize( panelwidth, y );
		Dimension pfsz = new Dimension( panelwidth, y );
		setPreferredSize( pfsz );
		Dimension min = new Dimension( 400, y );
		setMinimumSize( min );
		populateFields();
		adjustComponentEnableStates();
		swingIsInitializing = false;
	}

	public ICFBamSwingSchema getSwingSchema() {
		return( swingSchema );
	}

	public void setSwingFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setSwingFocus";
		if( ( value == null ) || ( value instanceof ICFBamSecSessionObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamSecSessionObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamSecSessionObj getSwingFocusAsSecSession() {
		return( (ICFBamSecSessionObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsSecSession( ICFBamSecSessionObj value ) {
		setSwingFocus( value );
	}

	public ICFBamSecUserObj getSwingContainerSecUserObj() {
		if( swingContainerSecUserObj == null ) {
		}
		return( swingContainerSecUserObj );
	}

	public void setSwingContainerSecUserObj( ICFBamSecUserObj value ) {
		swingContainerSecUserObj = value;
	}

	public SecSessionUserJLabel getSwingLabelContainerSecUser() {
		if( swingLabelContainerSecUser == null ) {
			swingLabelContainerSecUser = new SecSessionUserJLabel();
		}
		return( swingLabelContainerSecUser );
	}

	public SecSessionUserCFJReferenceEditor getSwingReferenceContainerSecUser() {
		if( swingReferenceContainerSecUser == null ) {
			swingReferenceContainerSecUser = new SecSessionUserCFJReferenceEditor();
		}
		return( swingReferenceContainerSecUser );
	}

	public void setSwingReferenceContainerSecUser( SecSessionUserCFJReferenceEditor value ) {
		swingReferenceContainerSecUser = value;
	}

	public ICFBamSecUserObj getSwingParentSecProxyObj() {
		return( swingParentSecProxyObj );
	}

	public void setSwingParentSecProxyObj( ICFBamSecUserObj value ) {
		swingParentSecProxyObj = value;
	}

	public JLabel getSwingLabelParentSecProxy() {
		if( swingLabelParentSecProxy == null ) {
			swingLabelParentSecProxy = new SecSessionProxyJLabel();
		}
		return( swingLabelParentSecProxy );
	}

	public CFJReferenceEditor getSwingReferenceParentSecProxy() {
		if( swingReferenceParentSecProxy == null ) {
			swingReferenceParentSecProxy = new SecSessionProxyCFJReferenceEditor();
		}
		return( swingReferenceParentSecProxy );
	}

	public void setSwingReferenceParentSecProxy( SecSessionProxyCFJReferenceEditor value ) {
		swingReferenceParentSecProxy = value;
	}

	public SecSessionIdJLabel getSwingLabelSecSessionId() {
		if( swingLabelSecSessionId == null ) {
			swingLabelSecSessionId = new SecSessionIdJLabel();
		}
		return( swingLabelSecSessionId );
	}

	public void setSwingLabelSecSessionId( SecSessionIdJLabel value ) {
		swingLabelSecSessionId = value;
	}

	public SecSessionIdJEditor getSwingEditorSecSessionId() {
		if( swingEditorSecSessionId == null ) {
			swingEditorSecSessionId = new SecSessionIdJEditor();
		}
		return( swingEditorSecSessionId );
	}

	public void setSwingEditorSecSessionId( SecSessionIdJEditor value ) {
		swingEditorSecSessionId = value;
	}

	public SecDevNameJLabel getSwingLabelSecDevName() {
		if( swingLabelSecDevName == null ) {
			swingLabelSecDevName = new SecDevNameJLabel();
		}
		return( swingLabelSecDevName );
	}

	public void setSwingLabelSecDevName( SecDevNameJLabel value ) {
		swingLabelSecDevName = value;
	}

	public SecDevNameJEditor getSwingEditorSecDevName() {
		if( swingEditorSecDevName == null ) {
			swingEditorSecDevName = new SecDevNameJEditor();
		}
		return( swingEditorSecDevName );
	}

	public void setSwingEditorSecDevName( SecDevNameJEditor value ) {
		swingEditorSecDevName = value;
	}

	public StartJLabel getSwingLabelStart() {
		if( swingLabelStart == null ) {
			swingLabelStart = new StartJLabel();
		}
		return( swingLabelStart );
	}

	public void setSwingLabelStart( StartJLabel value ) {
		swingLabelStart = value;
	}

	public StartJEditor getSwingEditorStart() {
		if( swingEditorStart == null ) {
			swingEditorStart = new StartJEditor();
		}
		return( swingEditorStart );
	}

	public void setSwingEditorStart( StartJEditor value ) {
		swingEditorStart = value;
	}

	public FinishJLabel getSwingLabelFinish() {
		if( swingLabelFinish == null ) {
			swingLabelFinish = new FinishJLabel();
		}
		return( swingLabelFinish );
	}

	public void setSwingLabelFinish( FinishJLabel value ) {
		swingLabelFinish = value;
	}

	public FinishJEditor getSwingEditorFinish() {
		if( swingEditorFinish == null ) {
			swingEditorFinish = new FinishJEditor();
		}
		return( swingEditorFinish );
	}

	public void setSwingEditorFinish( FinishJEditor value ) {
		swingEditorFinish = value;
	}

	public void doLayout() {
		JLabel label;
		JComponent compo;
		CFJReferenceEditor reference;
		Dimension dim;
		final int spacing = 5;
		int y = spacing;
		final int height = 25;
		final int textheight = 80;
		final int vspacing = height + spacing;
		final int textvspacing = textheight + spacing;
		final int labelx = spacing;
		final int labelwidth = 200;
		final int fieldx = labelx + labelwidth + spacing;
		final int fieldwidth = 1024;
		Dimension jpsz = getSize();
		int usefieldwidth = jpsz.width - 215;

		label = getSwingLabelContainerSecUser();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerSecUser();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelParentSecProxy();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceParentSecProxy();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelSecSessionId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSecSessionId();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelSecDevName();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSecDevName();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelStart();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorStart();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelFinish();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorFinish();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

	}

	public void populateFields()
	{
		ICFBamSecSessionObj popObj;
		ICFBamSecSessionObj focus = getSwingFocusAsSecSession();
		if( focus != null ) {
			popObj = (ICFBamSecSessionObj)(focus.getEdit());
			if( popObj == null ) {
				popObj = focus;
			}
		}
		else {
			popObj = null;
		}
		if( getPanelMode() == CFJPanel.PanelMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			swingContainerSecUserObj = null;
		}
		else {
			swingContainerSecUserObj = popObj.getRequiredContainerSecUser( swingIsInitializing );
		}
		if( swingReferenceContainerSecUser != null ) {
			swingReferenceContainerSecUser.setReferencedObject( swingContainerSecUserObj );
		}

		if( popObj == null ) {
			swingParentSecProxyObj = null;
		}
		else {
			swingParentSecProxyObj = popObj.getRequiredParentSecProxy( swingIsInitializing );
		}
		if( swingReferenceParentSecProxy != null ) {
			swingReferenceParentSecProxy.setReferencedObject( swingParentSecProxyObj );
		}

		if( popObj == null ) {
			getSwingEditorSecSessionId().setUuidValue( null );
		}
		else {
			getSwingEditorSecSessionId().setUuidValue( popObj.getRequiredSecSessionId() );
		}

		if( popObj == null ) {
			getSwingEditorSecDevName().setStringValue( null );
		}
		else {
			getSwingEditorSecDevName().setStringValue( popObj.getOptionalSecDevName() );
		}

		if( popObj == null ) {
			getSwingEditorStart().setTimestampValue( null );
		}
		else {
			getSwingEditorStart().setTimestampValue( popObj.getRequiredStart() );
		}

		if( popObj == null ) {
			getSwingEditorFinish().setTimestampValue( null );
		}
		else {
			getSwingEditorFinish().setTimestampValue( popObj.getOptionalFinish() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamSecSessionObj focus = getSwingFocusAsSecSession();
		ICFBamSecSessionEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamSecSessionEditObj)(focus.getEdit());
		}
		else {
			editObj = null;
		}
		if( editObj == null ) {
			throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
				S_ProcName,
				"Panel is unfocused or is not editing the focus object" );
		}
		// You are not allowed to edit the Container or Owner references, so they're not retrieved

		swingParentSecProxyObj = (ICFBamSecUserObj)( swingReferenceParentSecProxy.getReferencedObject() );
		editObj.setRequiredParentSecProxy( swingParentSecProxyObj );

		editObj.setOptionalSecDevName( getSwingEditorSecDevName().getStringValue() );

		editObj.setRequiredStart( getSwingEditorStart().getTimestampValue() );

		editObj.setOptionalFinish( getSwingEditorFinish().getTimestampValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamSecSessionObj focus = getSwingFocusAsSecSession();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamSecSessionEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamSecSessionEditObj)focus.getEdit();
		}
		else {
			editObj = null;
		}
		switch( value ) {
			case Unknown:
				switch( oldValue ) {
					case Unknown:
						break;
					default:
						if( editObj != null ) {
							editObj.endEdit();
						}
						break;
				}
				break;
			case Add:
				switch( oldValue ) {
					case Unknown:
					case Add:
					case View:
						if( editObj == null ) {
							if( focus != null ) {
								if( ! focus.getIsNew() ) {
									throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
										S_ProcName,
										"Transitioning to PanelMode Add requires Focus.getIsNew() to be true" );
								}
								editObj = (ICFBamSecSessionEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
										S_ProcName,
										"Expected beginEdit() to return a new edition of the focus object" );
								}
							}
							else {
								throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
									S_ProcName,
									0,
									"focus" );
							}
						}
						break;
					case Edit:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode Edit to Add" );
					case Update:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode Update to Add" );
					case Delete:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode Delete to Add" );
					default:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode default to Add" );
				}
				break;
			case View:
				switch( oldValue ) {
					case Unknown:
						break;
					case View:
						break;
					case Edit:
						break;
					case Update:
						break;
					case Delete:
						break;
					default:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode " + oldValue + " to View" );
				}
				if( editObj != null ) {
					editObj.endEdit();
				}
				break;
			case Edit:
				switch( oldValue ) {
					case Unknown:
						if( editObj == null ) {
							editObj = (ICFBamSecSessionEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamSecSessionEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamSecSessionEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					default:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode " + oldValue + " to Edit" ); 
				}
				break;
			case Update:
				if( ( oldValue != CFJPanel.PanelMode.Edit ) && ( oldValue != CFJPanel.PanelMode.Add ) ) {
					throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
						S_ProcName,
						"Cannot transition from mode " + oldValue + " to Update" );
				}
				super.setPanelMode( value );
				if( editObj != null ) {
					postFields();
					if( editObj.getIsNew() ) {
						focus = (ICFBamSecSessionObj)editObj.create();
						setSwingFocus( focus );
					}
					else {
						editObj.update();
					}
					editObj.endEdit();
					editObj = null;
				}
				setPanelMode( CFJPanel.PanelMode.View );
				break;
			case Delete:
				switch( oldValue ) {
					case View:
						if( focus != null ) {
							if( editObj == null ) {
								editObj = (ICFBamSecSessionEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
										S_ProcName,
										"Expected beginEdit() to return a new edition of the focus object" );
								}
							}
						}
						break;
					case Edit:
						if( focus != null ) {
							if( editObj == null ) {
								editObj = (ICFBamSecSessionEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
										S_ProcName,
										"Expected beginEdit() to return a new edition of the focus object" );
								}
							}
						}
						break;
					case Update:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode Update to Delete" ); 
					case Delete:
						if( editObj == null ) {
							editObj = (ICFBamSecSessionEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					default:
						throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
							S_ProcName,
							"Cannot transition PanelMode " + oldValue + " to Delete" ); 
				}
				editObj.delete();
				editObj.endEdit();
				setSwingFocus( null );
				setPanelMode( CFJPanel.PanelMode.Unknown );
				break;
			default:
				switch( oldValue ) {
					case Unknown:
						break;
					default:
						if( editObj != null ) {
							editObj.endEdit();
						}
						break;
				}
				break;
		}
		super.setPanelMode( value );
		populateFields();
		adjustComponentEnableStates();
	}

	public void adjustComponentEnableStates() {
		CFJPanel.PanelMode mode = getPanelMode();
		boolean isEditing;
		switch( mode ) {
			case Unknown:
			case View:
			case Delete:
				isEditing = false;
				break;
			case Add:
			case Edit:
			case Update:
				isEditing = true;
				break;
			default:
				isEditing = false;
				break;
		}
		if( isEditing ) {
			ICFBamSecSessionObj focus = getSwingFocusAsSecSession();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingReferenceContainerSecUser != null ) {
			swingReferenceContainerSecUser.setEnabled( false );
		}
		if( swingReferenceParentSecProxy != null ) {
			swingReferenceParentSecProxy.setEnabled( isEditing );
		}
		if( swingEditorSecSessionId != null ) {
			swingEditorSecSessionId.setEnabled( false );
		}
		if( swingEditorSecDevName != null ) {
			swingEditorSecDevName.setEnabled( isEditing );
		}
		if( swingEditorStart != null ) {
			swingEditorStart.setEnabled( isEditing );
		}
		if( swingEditorFinish != null ) {
			swingEditorFinish.setEnabled( isEditing );
		}
	}
}
