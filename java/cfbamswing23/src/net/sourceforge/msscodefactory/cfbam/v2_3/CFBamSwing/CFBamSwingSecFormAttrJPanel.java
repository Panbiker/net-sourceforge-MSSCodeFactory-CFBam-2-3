// Description: Java 7 Swing Attribute JPanel implementation for SecForm.

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
 *	CFBamSwingSecFormAttrJPanel Swing Attribute JPanel implementation
 *	for SecForm.
 */
public class CFBamSwingSecFormAttrJPanel
extends CFJPanel
implements ICFBamSwingSecFormJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class SecFormClusterJLabel
		extends JLabel
	{
		public SecFormClusterJLabel() {
			super();
			setText( "Cluster" );
		}
	}

	protected class CallbackSecFormClusterChosen
	implements ICFBamSwingClusterChosen
	{
		public CallbackSecFormClusterChosen() {
		}

		public void choseCluster( ICFBamClusterObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceOwnerCluster != null ) {
						ICFBamSecFormObj cur = getSwingFocusAsSecForm();
						if( cur != null ) {
							ICFBamSecFormEditObj editObj = (ICFBamSecFormEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceOwnerCluster.setReferencedObject( value );
									editObj.setRequiredOwnerCluster( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewSecFormClusterReference
	extends AbstractAction
	{
		public ActionViewSecFormClusterReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSecFormObj focus = getSwingFocusAsSecForm();
			if( focus != null ) {
				ICFBamSecFormEditObj editObj  = (ICFBamSecFormEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamClusterObj referencedObj = focus.getRequiredOwnerCluster( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "CLUS".equals( classCode ) ) {
						frame = swingSchema.getClusterFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamClusterObj" );
					}
				}
			}
		}
	}

	protected class ActionPickSecFormClusterReference
	extends AbstractAction
	{
		public ActionPickSecFormClusterReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSecFormObj focus = getSwingFocusAsSecForm();
			ICFBamSecFormEditObj editObj  = (ICFBamSecFormEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamClusterObj referencedObj = focus.getRequiredOwnerCluster( swingIsInitializing );
			java.util.List<ICFBamClusterObj> listOfCluster = null;
			listOfCluster = schemaObj.getClusterTableObj().readAllCluster();
			if( listOfCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfCluster" );
			}
			Collection<ICFBamClusterObj> cltn = listOfCluster;
			JInternalFrame frame = swingSchema.getClusterFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSecFormClusterChosen() );
			((ICFBamSwingClusterJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class SecFormClusterCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SecFormClusterCFJReferenceEditor() {
			super( new ActionPickSecFormClusterReference(), new ActionViewSecFormClusterReference() );
		}
	}

	protected class SecFormApplicationJLabel
		extends JLabel
	{
		public SecFormApplicationJLabel() {
			super();
			setText( "Application" );
		}
	}

	protected class CallbackSecFormApplicationChosen
	implements ICFBamSwingSecAppChosen
	{
		public CallbackSecFormApplicationChosen() {
		}

		public void choseSecApp( ICFBamSecAppObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerApplication != null ) {
						ICFBamSecFormObj cur = getSwingFocusAsSecForm();
						if( cur != null ) {
							ICFBamSecFormEditObj editObj = (ICFBamSecFormEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerApplication.setReferencedObject( value );
									editObj.setRequiredContainerApplication( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewSecFormApplicationReference
	extends AbstractAction
	{
		public ActionViewSecFormApplicationReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSecFormObj focus = getSwingFocusAsSecForm();
			if( focus != null ) {
				ICFBamSecFormEditObj editObj  = (ICFBamSecFormEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamSecAppObj referencedObj = focus.getRequiredContainerApplication( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SAPP".equals( classCode ) ) {
						frame = swingSchema.getSecAppFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamSecAppObj" );
					}
				}
			}
		}
	}

	protected class ActionPickSecFormApplicationReference
	extends AbstractAction
	{
		public ActionPickSecFormApplicationReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSecFormObj focus = getSwingFocusAsSecForm();
			ICFBamSecFormEditObj editObj  = (ICFBamSecFormEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamSecAppObj referencedObj = focus.getRequiredContainerApplication( swingIsInitializing );
			java.util.List<ICFBamSecAppObj> listOfSecApp = null;
			CFBamAuthorization auth = schemaObj.getAuthorization();
			long containingClusterId = auth.getSecClusterId();
			listOfSecApp = schemaObj.getSecAppTableObj().readSecAppByClusterIdx( containingClusterId );
			if( listOfSecApp == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfSecApp" );
			}
			Collection<ICFBamSecAppObj> cltn = listOfSecApp;
			JInternalFrame frame = swingSchema.getSecAppFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSecFormApplicationChosen() );
			((ICFBamSwingSecAppJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class SecFormApplicationCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SecFormApplicationCFJReferenceEditor() {
			super( new ActionPickSecFormApplicationReference(), new ActionViewSecFormApplicationReference() );
		}
	}

	protected class SecFormIdJLabel
		extends JLabel
	{
		public SecFormIdJLabel() {
			super();
			setText( "Security Form Id" );
		}
	}

	protected class SecFormIdJEditor
		extends CFJInt32Editor
	{
		public SecFormIdJEditor() {
			super();
			setMinValue( 0 );
		}
	}

	protected class JEEServletMapNameJLabel
		extends JLabel
	{
		public JEEServletMapNameJLabel() {
			super();
			setText( "JEE Servlet Map Name" );
		}
	}

	protected class JEEServletMapNameJEditor
		extends CFJStringEditor
	{
		public JEEServletMapNameJEditor() {
			super();
			setMaxLen( 192 );
		}
	}

	protected ICFBamClusterObj swingOwnerClusterObj = null;
	protected SecFormClusterJLabel swingLabelOwnerCluster = null;
	protected SecFormClusterCFJReferenceEditor swingReferenceOwnerCluster = null;
	protected ICFBamSecAppObj swingContainerApplicationObj = null;
	protected SecFormApplicationJLabel swingLabelContainerApplication = null;
	protected SecFormApplicationCFJReferenceEditor swingReferenceContainerApplication = null;
	protected SecFormIdJLabel swingLabelSecFormId = null;
	protected SecFormIdJEditor swingEditorSecFormId = null;
	protected JEEServletMapNameJLabel swingLabelJEEServletMapName = null;
	protected JEEServletMapNameJEditor swingEditorJEEServletMapName = null;

	public CFBamSwingSecFormAttrJPanel( ICFBamSwingSchema argSchema, ICFBamSecFormObj argFocus ) {
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
		setSwingFocusAsSecForm( argFocus );
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

		label = getSwingLabelOwnerCluster();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerCluster();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerApplication();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerApplication();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelSecFormId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSecFormId();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelJEEServletMapName();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJEEServletMapName();
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
		if( ( value == null ) || ( value instanceof ICFBamSecFormObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamSecFormObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamSecFormObj getSwingFocusAsSecForm() {
		return( (ICFBamSecFormObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsSecForm( ICFBamSecFormObj value ) {
		setSwingFocus( value );
	}

	public ICFBamClusterObj getSwingOwnerClusterObj() {
		return( swingOwnerClusterObj );
	}

	public void setSwingOwnerClusterObj( ICFBamClusterObj value ) {
		swingOwnerClusterObj = value;
	}

	public SecFormClusterJLabel getSwingLabelOwnerCluster() {
		if( swingLabelOwnerCluster == null ) {
			swingLabelOwnerCluster = new SecFormClusterJLabel();
		}
		return( swingLabelOwnerCluster );
	}

	public CFJReferenceEditor getSwingReferenceOwnerCluster() {
		if( swingReferenceOwnerCluster == null ) {
			swingReferenceOwnerCluster = new SecFormClusterCFJReferenceEditor();
		}
		return( swingReferenceOwnerCluster );
	}

	public void setSwingReferenceOwnerCluster( SecFormClusterCFJReferenceEditor value ) {
		swingReferenceOwnerCluster = value;
	}

	public ICFBamSecAppObj getSwingContainerApplicationObj() {
		if( swingContainerApplicationObj == null ) {
		}
		return( swingContainerApplicationObj );
	}

	public void setSwingContainerApplicationObj( ICFBamSecAppObj value ) {
		swingContainerApplicationObj = value;
	}

	public SecFormApplicationJLabel getSwingLabelContainerApplication() {
		if( swingLabelContainerApplication == null ) {
			swingLabelContainerApplication = new SecFormApplicationJLabel();
		}
		return( swingLabelContainerApplication );
	}

	public SecFormApplicationCFJReferenceEditor getSwingReferenceContainerApplication() {
		if( swingReferenceContainerApplication == null ) {
			swingReferenceContainerApplication = new SecFormApplicationCFJReferenceEditor();
		}
		return( swingReferenceContainerApplication );
	}

	public void setSwingReferenceContainerApplication( SecFormApplicationCFJReferenceEditor value ) {
		swingReferenceContainerApplication = value;
	}

	public SecFormIdJLabel getSwingLabelSecFormId() {
		if( swingLabelSecFormId == null ) {
			swingLabelSecFormId = new SecFormIdJLabel();
		}
		return( swingLabelSecFormId );
	}

	public void setSwingLabelSecFormId( SecFormIdJLabel value ) {
		swingLabelSecFormId = value;
	}

	public SecFormIdJEditor getSwingEditorSecFormId() {
		if( swingEditorSecFormId == null ) {
			swingEditorSecFormId = new SecFormIdJEditor();
		}
		return( swingEditorSecFormId );
	}

	public void setSwingEditorSecFormId( SecFormIdJEditor value ) {
		swingEditorSecFormId = value;
	}

	public JEEServletMapNameJLabel getSwingLabelJEEServletMapName() {
		if( swingLabelJEEServletMapName == null ) {
			swingLabelJEEServletMapName = new JEEServletMapNameJLabel();
		}
		return( swingLabelJEEServletMapName );
	}

	public void setSwingLabelJEEServletMapName( JEEServletMapNameJLabel value ) {
		swingLabelJEEServletMapName = value;
	}

	public JEEServletMapNameJEditor getSwingEditorJEEServletMapName() {
		if( swingEditorJEEServletMapName == null ) {
			swingEditorJEEServletMapName = new JEEServletMapNameJEditor();
		}
		return( swingEditorJEEServletMapName );
	}

	public void setSwingEditorJEEServletMapName( JEEServletMapNameJEditor value ) {
		swingEditorJEEServletMapName = value;
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

		label = getSwingLabelOwnerCluster();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceOwnerCluster();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelContainerApplication();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerApplication();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelSecFormId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSecFormId();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelJEEServletMapName();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorJEEServletMapName();
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
		ICFBamSecFormObj popObj;
		ICFBamSecFormObj focus = getSwingFocusAsSecForm();
		if( focus != null ) {
			popObj = (ICFBamSecFormObj)(focus.getEdit());
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
			swingOwnerClusterObj = null;
		}
		else {
			swingOwnerClusterObj = popObj.getRequiredOwnerCluster( swingIsInitializing );
		}
		if( swingReferenceOwnerCluster != null ) {
			swingReferenceOwnerCluster.setReferencedObject( swingOwnerClusterObj );
		}

		if( popObj == null ) {
			swingContainerApplicationObj = null;
		}
		else {
			swingContainerApplicationObj = popObj.getRequiredContainerApplication( swingIsInitializing );
		}
		if( swingReferenceContainerApplication != null ) {
			swingReferenceContainerApplication.setReferencedObject( swingContainerApplicationObj );
		}

		if( popObj == null ) {
			getSwingEditorSecFormId().setInt32Value( null );
		}
		else {
			getSwingEditorSecFormId().setInt32Value( popObj.getRequiredSecFormId() );
		}

		if( popObj == null ) {
			getSwingEditorJEEServletMapName().setStringValue( null );
		}
		else {
			getSwingEditorJEEServletMapName().setStringValue( popObj.getRequiredJEEServletMapName() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamSecFormObj focus = getSwingFocusAsSecForm();
		ICFBamSecFormEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamSecFormEditObj)(focus.getEdit());
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

		editObj.setRequiredJEEServletMapName( getSwingEditorJEEServletMapName().getStringValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamSecFormObj focus = getSwingFocusAsSecForm();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamSecFormEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamSecFormEditObj)focus.getEdit();
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
								editObj = (ICFBamSecFormEditObj)focus.beginEdit();
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
							editObj = (ICFBamSecFormEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamSecFormEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamSecFormEditObj)focus.beginEdit();
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
						focus = (ICFBamSecFormObj)editObj.create();
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
								editObj = (ICFBamSecFormEditObj)focus.beginEdit();
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
								editObj = (ICFBamSecFormEditObj)focus.beginEdit();
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
							editObj = (ICFBamSecFormEditObj)focus.beginEdit();
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
			ICFBamSecFormObj focus = getSwingFocusAsSecForm();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingReferenceOwnerCluster != null ) {
			swingReferenceOwnerCluster.setEnabled( false );
		}
		if( swingReferenceContainerApplication != null ) {
			swingReferenceContainerApplication.setEnabled( false );
		}
		if( swingEditorSecFormId != null ) {
			swingEditorSecFormId.setEnabled( false );
		}
		if( swingEditorJEEServletMapName != null ) {
			swingEditorJEEServletMapName.setEnabled( isEditing );
		}
	}
}
