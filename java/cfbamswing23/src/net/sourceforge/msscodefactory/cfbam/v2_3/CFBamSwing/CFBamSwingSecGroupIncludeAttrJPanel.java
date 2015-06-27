// Description: Java 7 Swing Attribute JPanel implementation for SecGroupInclude.

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
 *	CFBamSwingSecGroupIncludeAttrJPanel Swing Attribute JPanel implementation
 *	for SecGroupInclude.
 */
public class CFBamSwingSecGroupIncludeAttrJPanel
extends CFJPanel
implements ICFBamSwingSecGroupIncludeJPanelCommon
{
	protected ICFBamSwingSchema swingSchema = null;
	boolean swingIsInitializing = true;

	protected class SecGroupIncludeClusterJLabel
		extends JLabel
	{
		public SecGroupIncludeClusterJLabel() {
			super();
			setText( "Cluster" );
		}
	}

	protected class CallbackSecGroupIncludeClusterChosen
	implements ICFBamSwingClusterChosen
	{
		public CallbackSecGroupIncludeClusterChosen() {
		}

		public void choseCluster( ICFBamClusterObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceOwnerCluster != null ) {
						ICFBamSecGroupIncludeObj cur = getSwingFocusAsSecGroupInclude();
						if( cur != null ) {
							ICFBamSecGroupIncludeEditObj editObj = (ICFBamSecGroupIncludeEditObj)cur.getEdit();
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

	protected class ActionViewSecGroupIncludeClusterReference
	extends AbstractAction
	{
		public ActionViewSecGroupIncludeClusterReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSecGroupIncludeObj focus = getSwingFocusAsSecGroupInclude();
			if( focus != null ) {
				ICFBamSecGroupIncludeEditObj editObj  = (ICFBamSecGroupIncludeEditObj)focus.getEdit();
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

	protected class ActionPickSecGroupIncludeClusterReference
	extends AbstractAction
	{
		public ActionPickSecGroupIncludeClusterReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSecGroupIncludeObj focus = getSwingFocusAsSecGroupInclude();
			ICFBamSecGroupIncludeEditObj editObj  = (ICFBamSecGroupIncludeEditObj)focus.getEdit();
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
			JInternalFrame frame = swingSchema.getClusterFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSecGroupIncludeClusterChosen() );
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

	protected class SecGroupIncludeClusterCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SecGroupIncludeClusterCFJReferenceEditor() {
			super( new ActionPickSecGroupIncludeClusterReference(), new ActionViewSecGroupIncludeClusterReference() );
		}
	}

	protected class SecGroupIncludeGroupJLabel
		extends JLabel
	{
		public SecGroupIncludeGroupJLabel() {
			super();
			setText( "Group" );
		}
	}

	protected class CallbackSecGroupIncludeGroupChosen
	implements ICFBamSwingSecGroupChosen
	{
		public CallbackSecGroupIncludeGroupChosen() {
		}

		public void choseSecGroup( ICFBamSecGroupObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceContainerGroup != null ) {
						ICFBamSecGroupIncludeObj cur = getSwingFocusAsSecGroupInclude();
						if( cur != null ) {
							ICFBamSecGroupIncludeEditObj editObj = (ICFBamSecGroupIncludeEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceContainerGroup.setReferencedObject( value );
									editObj.setRequiredContainerGroup( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewSecGroupIncludeGroupReference
	extends AbstractAction
	{
		public ActionViewSecGroupIncludeGroupReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSecGroupIncludeObj focus = getSwingFocusAsSecGroupInclude();
			if( focus != null ) {
				ICFBamSecGroupIncludeEditObj editObj  = (ICFBamSecGroupIncludeEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamSecGroupObj referencedObj = focus.getRequiredContainerGroup( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SGRP".equals( classCode ) ) {
						frame = swingSchema.getSecGroupFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamSecGroupObj" );
					}
				}
			}
		}
	}

	protected class ActionPickSecGroupIncludeGroupReference
	extends AbstractAction
	{
		public ActionPickSecGroupIncludeGroupReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSecGroupIncludeObj focus = getSwingFocusAsSecGroupInclude();
			ICFBamSecGroupIncludeEditObj editObj  = (ICFBamSecGroupIncludeEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamSecGroupObj referencedObj = focus.getRequiredContainerGroup( swingIsInitializing );
			java.util.List<ICFBamSecGroupObj> listOfSecGroup = null;
			CFBamAuthorization auth = schemaObj.getAuthorization();
			long containingClusterId = auth.getSecClusterId();
			listOfSecGroup = schemaObj.getSecGroupTableObj().readSecGroupByClusterIdx( containingClusterId );
			if( listOfSecGroup == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfSecGroup" );
			}
			Collection<ICFBamSecGroupObj> cltn = listOfSecGroup;
			JInternalFrame frame = swingSchema.getSecGroupFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSecGroupIncludeGroupChosen() );
			((ICFBamSwingSecGroupJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class SecGroupIncludeGroupCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SecGroupIncludeGroupCFJReferenceEditor() {
			super( new ActionPickSecGroupIncludeGroupReference(), new ActionViewSecGroupIncludeGroupReference() );
		}
	}

	protected class SecGroupIncludeSubGroupJLabel
		extends JLabel
	{
		public SecGroupIncludeSubGroupJLabel() {
			super();
			setText( "SubGroup" );
		}
	}

	protected class CallbackSecGroupIncludeSubGroupChosen
	implements ICFBamSwingSecGroupChosen
	{
		public CallbackSecGroupIncludeSubGroupChosen() {
		}

		public void choseSecGroup( ICFBamSecGroupObj value ) {
			Component cont = getParent();
			while( ( cont != null ) && ( ! ( cont instanceof JInternalFrame ) ) ) {
				cont = cont.getParent();
			}
			if( cont != null ) {
				if( ! ((JInternalFrame)cont).isClosed() ) {
					if( swingReferenceParentSubGroup != null ) {
						ICFBamSecGroupIncludeObj cur = getSwingFocusAsSecGroupInclude();
						if( cur != null ) {
							ICFBamSecGroupIncludeEditObj editObj = (ICFBamSecGroupIncludeEditObj)cur.getEdit();
							if( null != editObj ) {
								CFJPanel.PanelMode curMode = getPanelMode();
								if( ( curMode == CFJPanel.PanelMode.Add ) || ( curMode == CFJPanel.PanelMode.Edit ) ) {
									swingReferenceParentSubGroup.setReferencedObject( value );
									editObj.setRequiredParentSubGroup( value );
								}
							}
						}
					}
				}
			}
		}
	}

	protected class ActionViewSecGroupIncludeSubGroupReference
	extends AbstractAction
	{
		public ActionViewSecGroupIncludeSubGroupReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSecGroupIncludeObj focus = getSwingFocusAsSecGroupInclude();
			if( focus != null ) {
				ICFBamSecGroupIncludeEditObj editObj  = (ICFBamSecGroupIncludeEditObj)focus.getEdit();
				if( editObj != null ) {
					focus = editObj;
				}
				JInternalFrame frame = null;
				Container cont;
				JDesktopPane desktop;
				ICFBamSecGroupObj referencedObj = focus.getRequiredParentSubGroup( swingIsInitializing );
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SGRP".equals( classCode ) ) {
						frame = swingSchema.getSecGroupFactory().newViewEditJInternalFrame( referencedObj );
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
							"ICFBamSecGroupObj" );
					}
				}
			}
		}
	}

	protected class ActionPickSecGroupIncludeSubGroupReference
	extends AbstractAction
	{
		public ActionPickSecGroupIncludeSubGroupReference() {
			super();
			setEnabled( true );
		}

		public void actionPerformed( ActionEvent e ) {
			final String S_ProcName = "actionPerformed";
			Container cont;
			JDesktopPane desktop;
			ICFBamSchemaObj schemaObj = swingSchema.getSchema();
			ICFBamSecGroupIncludeObj focus = getSwingFocusAsSecGroupInclude();
			ICFBamSecGroupIncludeEditObj editObj  = (ICFBamSecGroupIncludeEditObj)focus.getEdit();
			if( editObj != null ) {
				focus = editObj;
			}
			ICFBamSecGroupObj referencedObj = focus.getRequiredParentSubGroup( swingIsInitializing );
			java.util.List<ICFBamSecGroupObj> listOfSecGroup = null;
			CFBamAuthorization auth = schemaObj.getAuthorization();
			long containingClusterId = auth.getSecClusterId();
			listOfSecGroup = schemaObj.getSecGroupTableObj().readSecGroupByClusterIdx( containingClusterId );
			if( listOfSecGroup == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfSecGroup" );
			}
			Collection<ICFBamSecGroupObj> cltn = listOfSecGroup;
			JInternalFrame frame = swingSchema.getSecGroupFactory().newPickerJInternalFrame( referencedObj, null, cltn, new CallbackSecGroupIncludeSubGroupChosen() );
			((ICFBamSwingSecGroupJPanelCommon)frame).setPanelMode( CFJPanel.PanelMode.View );
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

	protected class SecGroupIncludeSubGroupCFJReferenceEditor
		extends CFJReferenceEditor
	{
		public SecGroupIncludeSubGroupCFJReferenceEditor() {
			super( new ActionPickSecGroupIncludeSubGroupReference(), new ActionViewSecGroupIncludeSubGroupReference() );
		}
	}

	protected class SecGroupIncludeIdJLabel
		extends JLabel
	{
		public SecGroupIncludeIdJLabel() {
			super();
			setText( "Security Group Include Id" );
		}
	}

	protected class SecGroupIncludeIdJEditor
		extends CFJInt64Editor
	{
		public SecGroupIncludeIdJEditor() {
			super();
			setMinValue( 0L );
		}
	}

	protected ICFBamClusterObj swingOwnerClusterObj = null;
	protected SecGroupIncludeClusterJLabel swingLabelOwnerCluster = null;
	protected SecGroupIncludeClusterCFJReferenceEditor swingReferenceOwnerCluster = null;
	protected ICFBamSecGroupObj swingContainerGroupObj = null;
	protected SecGroupIncludeGroupJLabel swingLabelContainerGroup = null;
	protected SecGroupIncludeGroupCFJReferenceEditor swingReferenceContainerGroup = null;
	protected ICFBamSecGroupObj swingParentSubGroupObj = null;
	protected SecGroupIncludeSubGroupJLabel swingLabelParentSubGroup = null;
	protected SecGroupIncludeSubGroupCFJReferenceEditor swingReferenceParentSubGroup = null;
	protected SecGroupIncludeIdJLabel swingLabelSecGroupIncludeId = null;
	protected SecGroupIncludeIdJEditor swingEditorSecGroupIncludeId = null;

	public CFBamSwingSecGroupIncludeAttrJPanel( ICFBamSwingSchema argSchema, ICFBamSecGroupIncludeObj argFocus ) {
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
		setSwingFocusAsSecGroupInclude( argFocus );
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

		label = getSwingLabelContainerGroup();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerGroup();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelParentSubGroup();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceParentSubGroup();
		add( reference );
		reference.setBounds( fieldx, y, fieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelSecGroupIncludeId();
		add( label );
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSecGroupIncludeId();
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
		if( ( value == null ) || ( value instanceof ICFBamSecGroupIncludeObj ) ) {
			super.setSwingFocus( value );
		}
		else {
			throw CFLib.getDefaultExceptionFactory().newUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamSecGroupIncludeObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamSecGroupIncludeObj getSwingFocusAsSecGroupInclude() {
		return( (ICFBamSecGroupIncludeObj)getSwingFocus() );
	}
	
	public void setSwingFocusAsSecGroupInclude( ICFBamSecGroupIncludeObj value ) {
		setSwingFocus( value );
	}

	public ICFBamClusterObj getSwingOwnerClusterObj() {
		return( swingOwnerClusterObj );
	}

	public void setSwingOwnerClusterObj( ICFBamClusterObj value ) {
		swingOwnerClusterObj = value;
	}

	public SecGroupIncludeClusterJLabel getSwingLabelOwnerCluster() {
		if( swingLabelOwnerCluster == null ) {
			swingLabelOwnerCluster = new SecGroupIncludeClusterJLabel();
		}
		return( swingLabelOwnerCluster );
	}

	public CFJReferenceEditor getSwingReferenceOwnerCluster() {
		if( swingReferenceOwnerCluster == null ) {
			swingReferenceOwnerCluster = new SecGroupIncludeClusterCFJReferenceEditor();
		}
		return( swingReferenceOwnerCluster );
	}

	public void setSwingReferenceOwnerCluster( SecGroupIncludeClusterCFJReferenceEditor value ) {
		swingReferenceOwnerCluster = value;
	}

	public ICFBamSecGroupObj getSwingContainerGroupObj() {
		if( swingContainerGroupObj == null ) {
		}
		return( swingContainerGroupObj );
	}

	public void setSwingContainerGroupObj( ICFBamSecGroupObj value ) {
		swingContainerGroupObj = value;
	}

	public SecGroupIncludeGroupJLabel getSwingLabelContainerGroup() {
		if( swingLabelContainerGroup == null ) {
			swingLabelContainerGroup = new SecGroupIncludeGroupJLabel();
		}
		return( swingLabelContainerGroup );
	}

	public SecGroupIncludeGroupCFJReferenceEditor getSwingReferenceContainerGroup() {
		if( swingReferenceContainerGroup == null ) {
			swingReferenceContainerGroup = new SecGroupIncludeGroupCFJReferenceEditor();
		}
		return( swingReferenceContainerGroup );
	}

	public void setSwingReferenceContainerGroup( SecGroupIncludeGroupCFJReferenceEditor value ) {
		swingReferenceContainerGroup = value;
	}

	public ICFBamSecGroupObj getSwingParentSubGroupObj() {
		return( swingParentSubGroupObj );
	}

	public void setSwingParentSubGroupObj( ICFBamSecGroupObj value ) {
		swingParentSubGroupObj = value;
	}

	public JLabel getSwingLabelParentSubGroup() {
		if( swingLabelParentSubGroup == null ) {
			swingLabelParentSubGroup = new SecGroupIncludeSubGroupJLabel();
		}
		return( swingLabelParentSubGroup );
	}

	public CFJReferenceEditor getSwingReferenceParentSubGroup() {
		if( swingReferenceParentSubGroup == null ) {
			swingReferenceParentSubGroup = new SecGroupIncludeSubGroupCFJReferenceEditor();
		}
		return( swingReferenceParentSubGroup );
	}

	public void setSwingReferenceParentSubGroup( SecGroupIncludeSubGroupCFJReferenceEditor value ) {
		swingReferenceParentSubGroup = value;
	}

	public SecGroupIncludeIdJLabel getSwingLabelSecGroupIncludeId() {
		if( swingLabelSecGroupIncludeId == null ) {
			swingLabelSecGroupIncludeId = new SecGroupIncludeIdJLabel();
		}
		return( swingLabelSecGroupIncludeId );
	}

	public void setSwingLabelSecGroupIncludeId( SecGroupIncludeIdJLabel value ) {
		swingLabelSecGroupIncludeId = value;
	}

	public SecGroupIncludeIdJEditor getSwingEditorSecGroupIncludeId() {
		if( swingEditorSecGroupIncludeId == null ) {
			swingEditorSecGroupIncludeId = new SecGroupIncludeIdJEditor();
		}
		return( swingEditorSecGroupIncludeId );
	}

	public void setSwingEditorSecGroupIncludeId( SecGroupIncludeIdJEditor value ) {
		swingEditorSecGroupIncludeId = value;
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

		label = getSwingLabelContainerGroup();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceContainerGroup();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelParentSubGroup();
		label.setBounds( labelx, y, labelwidth, height );
		reference = getSwingReferenceParentSubGroup();
		reference.setBounds( fieldx, y, usefieldwidth, height );
		y = y + vspacing;

		label = getSwingLabelSecGroupIncludeId();
		label.setBounds( labelx, y, labelwidth, height );
		compo = getSwingEditorSecGroupIncludeId();
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
		ICFBamSecGroupIncludeObj popObj;
		ICFBamSecGroupIncludeObj focus = getSwingFocusAsSecGroupInclude();
		if( focus != null ) {
			popObj = (ICFBamSecGroupIncludeObj)(focus.getEdit());
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
			swingContainerGroupObj = null;
		}
		else {
			swingContainerGroupObj = popObj.getRequiredContainerGroup( swingIsInitializing );
		}
		if( swingReferenceContainerGroup != null ) {
			swingReferenceContainerGroup.setReferencedObject( swingContainerGroupObj );
		}

		if( popObj == null ) {
			swingParentSubGroupObj = null;
		}
		else {
			swingParentSubGroupObj = popObj.getRequiredParentSubGroup( swingIsInitializing );
		}
		if( swingReferenceParentSubGroup != null ) {
			swingReferenceParentSubGroup.setReferencedObject( swingParentSubGroupObj );
		}

		if( popObj == null ) {
			getSwingEditorSecGroupIncludeId().setInt64Value( null );
		}
		else {
			getSwingEditorSecGroupIncludeId().setInt64Value( popObj.getRequiredSecGroupIncludeId() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamSecGroupIncludeObj focus = getSwingFocusAsSecGroupInclude();
		ICFBamSecGroupIncludeEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamSecGroupIncludeEditObj)(focus.getEdit());
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

		swingParentSubGroupObj = (ICFBamSecGroupObj)( swingReferenceParentSubGroup.getReferencedObject() );
		editObj.setRequiredParentSubGroup( swingParentSubGroupObj );
	}

	public void setPanelMode( CFJPanel.PanelMode value ) {
		final String S_ProcName = "setPanelMode";
		CFJPanel.PanelMode oldValue = getPanelMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamSecGroupIncludeObj focus = getSwingFocusAsSecGroupInclude();
		if( ( value != CFJPanel.PanelMode.Unknown ) && ( value != CFJPanel.PanelMode.View ) ) {
			if( focus == null ) {
				throw CFLib.getDefaultExceptionFactory().newNullArgumentException( getClass(),
					S_ProcName,
					0,
					"swingFocus" );
			}
		}
		ICFBamSecGroupIncludeEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamSecGroupIncludeEditObj)focus.getEdit();
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
								editObj = (ICFBamSecGroupIncludeEditObj)focus.beginEdit();
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
							editObj = (ICFBamSecGroupIncludeEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamSecGroupIncludeEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw CFLib.getDefaultExceptionFactory().newUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamSecGroupIncludeEditObj)focus.beginEdit();
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
						focus = (ICFBamSecGroupIncludeObj)editObj.create();
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
								editObj = (ICFBamSecGroupIncludeEditObj)focus.beginEdit();
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
								editObj = (ICFBamSecGroupIncludeEditObj)focus.beginEdit();
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
							editObj = (ICFBamSecGroupIncludeEditObj)focus.beginEdit();
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
			ICFBamSecGroupIncludeObj focus = getSwingFocusAsSecGroupInclude();
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
		if( swingReferenceContainerGroup != null ) {
			swingReferenceContainerGroup.setEnabled( false );
		}
		if( swingReferenceParentSubGroup != null ) {
			swingReferenceParentSubGroup.setEnabled( isEditing );
		}
		if( swingEditorSecGroupIncludeId != null ) {
			swingEditorSecGroupIncludeId.setEnabled( false );
		}
	}
}
