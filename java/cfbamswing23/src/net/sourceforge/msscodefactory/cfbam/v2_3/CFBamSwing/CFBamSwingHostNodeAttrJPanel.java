// Description: Java 7 Swing Attribute JPanel implementation for HostNode.

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
 *	CFBamSwingHostNodeAttrJPanel Swing Attribute JPanel implementation
 *	for HostNode.
 */
public class CFBamSwingHostNodeAttrJPanel
extends CFJPanel
implements ICFBamSwingHostNodeJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class HostNodeClusterJLabel
		extends JLabel
	{
		public HostNodeClusterJLabel() {
			super();
			setText( "Cluster" );
		}
	}

	protected class CallbackHostNodeClusterChosen
	implements ICFBamSwingClusterChosen
	{
		public CallbackHostNodeClusterChosen() {
		}

		public void choseCluster( ICFBamClusterObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerCluster != null ) {
						ICFBamHostNodeObj cur = getSwingFocusAsHostNode();
						if( cur != null ) {
							ICFBamHostNodeEditObj editObj = (ICFBamHostNodeEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerCluster.setReferencedObject( value );
									editObj.setRequiredContainerCluster( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewHostNodeClusterReference
	extends AbstractAction
	{
		public ActionViewHostNodeClusterReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamHostNodeObj focus = getSwingFocusAsHostNode();
			if( focus != null ) {
				ICFBamHostNodeEditObj editObj  = (ICFBamHostNodeEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamClusterObj referencedObj = focus.getRequiredContainerCluster( swingIsInitializing );
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

	protected class ActionPickHostNodeClusterReference
	extends AbstractAction
	{
		public ActionPickHostNodeClusterReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamHostNodeObj focus = getSwingFocusAsHostNode();
			ICFBamHostNodeEditObj editObj  = (ICFBamHostNodeEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamClusterObj referencedObj = focus.getRequiredContainerCluster( swingIsInitializing );
			java.util.List<ICFBamClusterObj> listOfCluster = null;
			listOfCluster = schemaObj.getClusterTableObj().readAllCluster();
			if( listOfCluster == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfCluster" );
			}
			Collection<ICFBamClusterObj> cltn = listOfCluster;
			JInternalFrame frame = swingSchema.getClusterFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackHostNodeClusterChosen() );
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

	protected class HostNodeClusterCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public HostNodeClusterCFJReferenceEditor() {
			super( new ActionPickHostNodeClusterReference(), new ActionViewHostNodeClusterReference() );
		}
	}

	protected class HostNodeIdJLabel
		extends JLabel
	{
		public HostNodeIdJLabel() {
			super();
			setText( "Host Node Id" );
		}
	}

	protected class HostNodeIdJEditor
		extends CFJInt64Editor
	{
		public HostNodeIdJEditor() {
			super();
			setMinValue( 0L );
		}
	}

	protected class DescriptionJLabel
		extends JLabel
	{
		public DescriptionJLabel() {
			super();
			setText( "Description" );
		}
	}

	protected class DescriptionJEditor
		extends CFJStringEditor
	{
		public DescriptionJEditor() {
			super();
			setMaxLen( 255 );
		}
	}

	protected class HostNameJLabel
		extends JLabel
	{
		public HostNameJLabel() {
			super();
			setText( "Host Name" );
		}
	}

	protected class HostNameJEditor
		extends CFJStringEditor
	{
		public HostNameJEditor() {
			super();
			setMaxLen( 192 );
		}
	}

	protected ICFBamClusterObj swingContainerClusterObj = null;
	protected HostNodeClusterJLabel swingLabelContainerCluster = null;
	protected HostNodeClusterCFJReferenceEditor swingReferenceContainerCluster = null;
	protected HostNodeIdJLabel swingLabelHostNodeId = null;
	protected HostNodeIdJEditor swingEditorHostNodeId = null;
	protected DescriptionJLabel swingLabelDescription = null;
	protected DescriptionJEditor swingEditorDescription = null;
	protected HostNameJLabel swingLabelHostName = null;
	protected HostNameJEditor swingEditorHostName = null;

	public CFBamSwingHostNodeAttrJPanel( ICFBamSwingSchema argSchema, ICFBamHostNodeObj argFocus ) {
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
		setSwingFocusAsHostNode( argFocus );
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

		label = getSwingLabelContainerCluster();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerCluster();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelHostNodeId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorHostNodeId();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelDescription();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDescription();
		add( compo );
		compo.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelHostName();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorHostName();
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
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamHostNodeObj getSwingFocusAsHostNode() {
		return( (ICFBamHostNodeObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsHostNode( ICFBamHostNodeObj value ) {
		setSwingFocus( value );
	}

	public ICFBamClusterObj getSwingContainerClusterObj() {
		if( swingContainerClusterObj == null ) {
		}
		return( swingContainerClusterObj );
	}

	public void setSwingContainerClusterObj( ICFBamClusterObj value ) {
		swingContainerClusterObj = value;
	}

	public HostNodeClusterJLabel getSwingLabelContainerCluster() {
		if( swingLabelContainerCluster == null ) {
			swingLabelContainerCluster = new HostNodeClusterJLabel();
		}
		return( swingLabelContainerCluster );
	}

	public HostNodeClusterCFJReferenceEditor getSwingReferenceContainerCluster() {
		if( swingReferenceContainerCluster == null ) {
			swingReferenceContainerCluster = new HostNodeClusterCFJReferenceEditor();
		}
		return( swingReferenceContainerCluster );
	}

	public void setSwingReferenceContainerCluster( HostNodeClusterCFJReferenceEditor value ) {
		swingReferenceContainerCluster = value;
	}

	public HostNodeIdJLabel getSwingLabelHostNodeId() {
		if( swingLabelHostNodeId == null ) {
			swingLabelHostNodeId = new HostNodeIdJLabel();
		}
		return( swingLabelHostNodeId );
	}

	public void setSwingLabelHostNodeId( HostNodeIdJLabel value ) {
		swingLabelHostNodeId = value;
	}

	public HostNodeIdJEditor getSwingEditorHostNodeId() {
		if( swingEditorHostNodeId == null ) {
			swingEditorHostNodeId = new HostNodeIdJEditor();
		}
		return( swingEditorHostNodeId );
	}

	public void setSwingEditorHostNodeId( HostNodeIdJEditor value ) {
		swingEditorHostNodeId = value;
	}

	public DescriptionJLabel getSwingLabelDescription() {
		if( swingLabelDescription == null ) {
			swingLabelDescription = new DescriptionJLabel();
		}
		return( swingLabelDescription );
	}

	public void setSwingLabelDescription( DescriptionJLabel value ) {
		swingLabelDescription = value;
	}

	public DescriptionJEditor getSwingEditorDescription() {
		if( swingEditorDescription == null ) {
			swingEditorDescription = new DescriptionJEditor();
		}
		return( swingEditorDescription );
	}

	public void setSwingEditorDescription( DescriptionJEditor value ) {
		swingEditorDescription = value;
	}

	public HostNameJLabel getSwingLabelHostName() {
		if( swingLabelHostName == null ) {
			swingLabelHostName = new HostNameJLabel();
		}
		return( swingLabelHostName );
	}

	public void setSwingLabelHostName( HostNameJLabel value ) {
		swingLabelHostName = value;
	}

	public HostNameJEditor getSwingEditorHostName() {
		if( swingEditorHostName == null ) {
			swingEditorHostName = new HostNameJEditor();
		}
		return( swingEditorHostName );
	}

	public void setSwingEditorHostName( HostNameJEditor value ) {
		swingEditorHostName = value;
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

		label = getSwingLabelContainerCluster();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerCluster();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelHostNodeId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorHostNodeId();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelDescription();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorDescription();
		dim = compo.getMaximumSize();
		if( dim.width < usefieldwidth ) {
			compo.setBounds( fieldx, y, dim.width, height );
		}
		else {
			compo.setBounds( fieldx, y, fieldwidth, height  );
		}
		y = y + vspacing;

		label = getSwingLabelHostName();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorHostName();
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
		ICFBamHostNodeObj popObj;
		ICFBamHostNodeObj focus = getSwingFocusAsHostNode();
		if( focus != null ) {
			popObj = (ICFBamHostNodeObj)(focus.getEdit());
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
			swingContainerClusterObj = null;
		}
		else {
			swingContainerClusterObj = popObj.getRequiredContainerCluster( swingIsInitializing );
		}
		if( swingReferenceContainerCluster != null ) {
			swingReferenceContainerCluster.setReferencedObject( swingContainerClusterObj );
		}

		if( popObj == null ) {
			getSwingEditorHostNodeId().setInt64Value( null );
		}
		else {
			getSwingEditorHostNodeId().setInt64Value( popObj.getRequiredHostNodeId() );
		}

		if( popObj == null ) {
			getSwingEditorDescription().setStringValue( null );
		}
		else {
			getSwingEditorDescription().setStringValue( popObj.getRequiredDescription() );
		}

		if( popObj == null ) {
			getSwingEditorHostName().setStringValue( null );
		}
		else {
			getSwingEditorHostName().setStringValue( popObj.getRequiredHostName() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamHostNodeObj focus = getSwingFocusAsHostNode();
		ICFBamHostNodeEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamHostNodeEditObj)(focus.getEdit());
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

		editObj.setRequiredDescription( getSwingEditorDescription().getStringValue() );

		editObj.setRequiredHostName( getSwingEditorHostName().getStringValue() );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamHostNodeObj focus = getSwingFocusAsHostNode();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamHostNodeEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamHostNodeEditObj)focus.getEdit();
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
								editObj = (ICFBamHostNodeEditObj)focus.beginEdit();
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
							editObj = (ICFBamHostNodeEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamHostNodeEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamHostNodeEditObj)focus.beginEdit();
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
						focus = (ICFBamHostNodeObj)editObj.create();
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
								editObj = (ICFBamHostNodeEditObj)focus.beginEdit();
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
								editObj = (ICFBamHostNodeEditObj)focus.beginEdit();
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
							editObj = (ICFBamHostNodeEditObj)focus.beginEdit();
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
			ICFBamHostNodeObj focus = getSwingFocusAsHostNode();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( swingReferenceContainerCluster != null ) {
			swingReferenceContainerCluster.setEnabled( false );
		}
		if( swingEditorHostNodeId != null ) {
			swingEditorHostNodeId.setEnabled( false );
		}
		if( swingEditorDescription != null ) {
			swingEditorDescription.setEnabled( isEditing );
		}
		if( swingEditorHostName != null ) {
			swingEditorHostName.setEnabled( isEditing );
		}
	}
}
